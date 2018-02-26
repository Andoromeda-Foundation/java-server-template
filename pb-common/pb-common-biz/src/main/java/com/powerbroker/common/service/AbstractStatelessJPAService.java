package com.powerbroker.common.service;

import com.powerbroker.common.domain.entity.AbstractPersistableEntity;
import com.powerbroker.common.exception.AppException;
import com.powerbroker.common.utils.ReflectionUtils;
import com.powerbroker.common.utils.ValueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Slf4j
public abstract class AbstractStatelessJPAService<ID extends Serializable, DTO extends IdentifierAwareDTO, ENTITY extends AbstractPersistableEntity<ID>, DAO extends JpaRepository<ENTITY, ID>>
        extends AbstractService<ID, DTO> implements PageableService<ID, DTO> {

    private Class<ENTITY> entityClass;
    private Class<DAO> daoClass;

    protected DAO dao;

    protected boolean allowingDelAll = false;

    Map<String, Field> relativeFields = new ConcurrentHashMap<>();
    Map<String, JpaRepository<? extends AbstractPersistableEntity<ID>, ID>> relativeDaos = new ConcurrentHashMap<>();

    private final static ExampleMatcher DEFAULT_STRING_MATCHER = ExampleMatcher.matching().withStringMatcher
            (ExampleMatcher.StringMatcher.STARTING);

    @SuppressWarnings("unchecked")
    AbstractStatelessJPAService() {
        super();
        entityClass = ReflectionUtils.getClassGenricType(getClass(), 2);
        daoClass = ReflectionUtils.getClassGenricType(getClass(), 3);
    }

    abstract protected void createHandler(ENTITY target);

    abstract protected void afterCreateHandler(ENTITY target);

    abstract protected void updateHandler(ENTITY target);

    abstract protected void deleteHandler(ENTITY target);

    abstract protected void merge(ENTITY target);

    abstract protected void cleanup(ENTITY target);

    @Transactional
    public DTO create(DTO dto) {
        ENTITY entity = ValueUtil.dump(dto, entityClass);
        merge(entity);
        createHandler(entity);
        dao.save(entity);
        afterCreateHandler(entity);
        return ValueUtil.dump(entity, dtoClass);
    }

    @Transactional(readOnly = true)
    public DTO retrieve(ID id) {

        ENTITY entity = null;

        if (!dao.exists(id)) {
            log.warn("retrieve entity not found --- id : {} ", id);
        } else {
            entity = dao.findOne(id);
        }
        return ValueUtil.dump(entity, dtoClass);
    }

    @Override
    @Transactional(readOnly = true)
    public DTO retrieveByCondition(DTO condition) {

        // TODO:
        return null;
    }

    @Transactional
    public boolean update(DTO dto) {
        Assert.notNull(dto.getId(), "update operation must has id");

        ID id = (ID) ValueUtil.idDecode(dto.getId());

        if (dao.exists(id)) {
            ENTITY target = dao.findOne(id);
            cleanup(target);
            ValueUtil.copy(dto, target);
            updateHandler(target);
            merge(target);
            dao.save(target);
            return true;
        } else {
            log.warn("update entity not found --- id : {} ", dto.getId());
            return false;
        }
    }

    @Transactional
    public boolean delete(ID id) {

        if (!dao.exists(id)) {
            log.warn("delete entity not found --- id : {} ", id);
            return false;
        }

        return this.logicDelete(id);
    }

    @Transactional
    public void deleteAll() {

        if (!allowingDelAll) {
            return;
        }

        List<ENTITY> all = dao.findAll();

        for (ENTITY entity : all) {
            this.delete(entity.getId());
        }
    }

    private boolean logicDelete(ID id) {
        ENTITY entity = dao.findOne(id);
        deleteHandler(entity);
        return true;
    }

    private boolean physicDelete(ID id) {
        dao.delete(id);
        return true;
    }

    @Transactional
    public boolean active(ID id) {
        return this.toggleActive(id, true);
    }

    @Transactional
    public boolean deactive(ID id) {
        return this.toggleActive(id, false);
    }

    private boolean toggleActive(ID id, boolean active) {

        if (!dao.exists(id)) {
            log.warn("entity not found --- id : {} ", id);
            return false;
        }

        ENTITY entity = dao.findOne(id);
        entity.setActive(active);
        return true;
    }

    @Transactional(readOnly = true)
    public Page<DTO> listActive(Pageable pageable) {

        ENTITY probe = newProbeInstance();

        Example<ENTITY> example = Example.of(probe);
        Page<DTO> data = dao.findAll(example, pageable).map(entity -> ValueUtil.dump(entity, dtoClass));
        return data;
    }

    @Transactional(readOnly = true)
    public List<DTO> listAllActive() {

        ENTITY probe = newProbeInstance();

        Example<ENTITY> example = Example.of(probe);
        List<DTO> data = dao.findAll(example).stream().map(entity -> ValueUtil.dump(entity, dtoClass)).collect(Collectors.toList());
        return data;
    }

    private ENTITY newProbeInstance() {
        ENTITY probe = null;
        try {
            probe = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("this is not gonna happen. {}", e);
        }
        return probe;
    }

    @Transactional(readOnly = true)
    public Page<DTO> listAll(Pageable pageable) {
        Page<DTO> data = dao.findAll(pageable).map(entity -> ValueUtil.dump(entity, dtoClass));
        return data;
    }

    @Transactional(readOnly = true)
    public Page<DTO> list(DTO condition, Pageable pageable) {

        ENTITY prob = ValueUtil.dump(condition, entityClass);
        Example<ENTITY> example = Example.of(prob, DEFAULT_STRING_MATCHER);

        Page<DTO> data = dao.findAll(example, pageable).map(entity -> ValueUtil.dump(entity, dtoClass));
        return data;
    }

    @Deprecated
    public <U> List<DTO> list(U u) {
        throw new AppException("not support method");
    }

    @PostConstruct
    private void assignmentDao() {
        this.dao = beanFactory.getBean(daoClass);

        for (Field field : entityClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(ManyToOne.class) || field.isAnnotationPresent(OneToOne.class)) {

                JpaRepository<? extends AbstractPersistableEntity<ID>, ID> relativeDao = (JpaRepository<? extends
                        AbstractPersistableEntity<ID>, ID>) beanFactory.getBean(decapitalize(field
                        .getType().getSimpleName() + "DAO"));

                relativeFields.put(field.getName(), field);
                relativeDaos.put(field.getName(), relativeDao);
            }

            if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) {

                String childEntityName = ((Class) (((ParameterizedType) field.getGenericType()).getActualTypeArguments()
                        [0]))
                        .getSimpleName();
                JpaRepository<? extends AbstractPersistableEntity<ID>, ID> relativeDao = (JpaRepository<? extends
                        AbstractPersistableEntity<ID>, ID>) beanFactory.getBean(decapitalize(childEntityName + "DAO"));

                relativeFields.put(field.getName(), field);
                relativeDaos.put(field.getName(), relativeDao);
            }
        }
    }

    private static String decapitalize(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        char c[] = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c);
    }
}
