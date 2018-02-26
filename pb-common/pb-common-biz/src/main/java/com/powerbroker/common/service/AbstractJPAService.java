package com.powerbroker.common.service;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.domain.entity.AbstractPersistableEntity;
import com.powerbroker.common.utils.ValueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import javax.persistence.OneToOne;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Slf4j
public abstract class AbstractJPAService<ID extends Serializable, DTO extends IdentifierAwareDTO, ENTITY extends AbstractPersistableEntity<ID>, DAO extends JpaRepository<ENTITY, ID>>
        extends AbstractStatelessJPAService<ID, DTO, ENTITY, DAO> {

    protected PBAuthUser getCurrentAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PBAuthUser authUser = null;
        if (null != authentication) {
            authUser = (PBAuthUser) authentication.getPrincipal();
        }
        return authUser;
    }

    protected Long getCurrentAuthUserId() {
        PBAuthUser authUser = getCurrentAuthUser();

        if (null != authUser) {
            return authUser.getId();
        } else {
            log.warn("could not get current user id");
            return -1L;
        }
    }

    protected Integer getAuthType() {
        PBAuthUser authUser = getCurrentAuthUser();
        return authUser.getType();
    }

    @Override
    protected void createHandler(ENTITY target) {
        target.setCreateBy(getCurrentAuthUserId());
    }

    @Override
    protected void afterCreateHandler(ENTITY target) {
    }

    @Override
    protected void updateHandler(ENTITY target) {
        target.setUpdateBy(getCurrentAuthUserId());
    }

    @Override
    protected void deleteHandler(ENTITY target) {
        target.setDeleted(true);
        target.setDeleteAt(LocalDateTime.now());
        target.setDeleteBy(getCurrentAuthUserId());
    }

    protected void cleanup(ENTITY target) {
        if (!relativeFields.isEmpty()) {
            for (Field field : relativeFields.values()) {
                field.setAccessible(true);
                try {
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        field.set(target, new HashSet<>());
//                        ((Collection)field.get(target)).removeAll((Collection)field.get(target));
                    } else {
                        field.set(target, null);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        dao.saveAndFlush(target);
    }

    protected void merge(ENTITY entity) {
        if (!relativeFields.isEmpty()) {
            for (Field field : relativeFields.values()) {
                try {
                    JpaRepository<? extends AbstractPersistableEntity<ID>, ID> idJpaRepository = relativeDaos.get(field.getName());
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        field.setAccessible(true);
                        Collection<AbstractPersistableEntity<ID>> childEntities = (Collection<AbstractPersistableEntity<ID>>) field.get(entity);

                        if (!CollectionUtils.isEmpty(childEntities)) {

                            field.setAccessible(true);

                            Set<AbstractPersistableEntity<ID>> attachedChildEntities = new HashSet<>();
                            field.set(entity, attachedChildEntities);

                            for (AbstractPersistableEntity<ID> childEntity : childEntities) {
                                if (null != childEntity && !childEntity.isNew()) {
                                    field.setAccessible(true);
                                    AbstractPersistableEntity<ID> attachedChildEntity = idJpaRepository.findOne
                                            (childEntity.getId());
                                    attachedChildEntities.add(attachedChildEntity);
                                }

                                if (childEntity.isNew()) {
                                    Field[] childFields = childEntity.getClass().getDeclaredFields();

                                    for (Field childField : childFields) {
                                        if (childField.getName().equalsIgnoreCase(entity.getClass().getSimpleName())) {
                                            boolean access = childField.isAccessible();
                                            if (!access) childField.setAccessible(true);

                                            childField.set(childEntity, entity);
                                        }
                                    }
                                    attachedChildEntities.add(childEntity);
                                }
                            }
                        }
                    } else {
                        field.setAccessible(true);
                        AbstractPersistableEntity<ID> detachChildEntity = (AbstractPersistableEntity<ID>) field.get(entity);

                        if (null == detachChildEntity || detachChildEntity.isNew()) {
                            field.setAccessible(true);

                            if (null == detachChildEntity) {
                                field.set(entity, null);
                            } else {
                                if (null != entity.getId()) {
                                    detachChildEntity.setId(entity.getId());
                                }
                                field.set(entity, detachChildEntity);
                                handleChildRelation(entity, detachChildEntity);
                            }
                        } else {
                            AbstractPersistableEntity<ID> originChildEntity = null;

                            try {
                                originChildEntity = (AbstractPersistableEntity<ID>) field.getType().newInstance();
                                ValueUtil.copy(detachChildEntity, originChildEntity);
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }
                            field.setAccessible(true);
                            field.set(entity, null);

                            AbstractPersistableEntity<ID> persistChildEntity = idJpaRepository.findOne(detachChildEntity.getId
                                    ());
                            if (null != persistChildEntity) {
                                field.setAccessible(true);
                                field.set(entity, persistChildEntity);
                            } else {
                                field.setAccessible(true);
                                if (null != persistChildEntity) {
                                    ValueUtil.copy(originChildEntity, persistChildEntity);
                                    handleChildRelation(entity, persistChildEntity);
                                    field.set(entity, persistChildEntity);
                                } else {
                                    handleChildRelation(entity, originChildEntity);
                                    field.set(entity, originChildEntity);
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleChildRelation(ENTITY entity, AbstractPersistableEntity<ID> detachChildEntity) throws IllegalAccessException {
        for (Field childField : detachChildEntity.getClass().getDeclaredFields()) {
            if (childField.isAnnotationPresent(OneToOne.class)) {
                if (childField.getType().getSimpleName().equalsIgnoreCase(entity.getClass()
                                                                                .getSimpleName())) {
                    childField.setAccessible(true);
                    childField.set(detachChildEntity, entity);
                }
            }
        }
    }
}
