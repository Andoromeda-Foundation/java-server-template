package com.powerbroker.common.service;

import com.powerbroker.common.utils.ReflectionUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.io.Serializable;

/**
 * @author william
 */
@Slf4j
public abstract class AbstractService<ID extends Serializable, DTO extends IdentifierAwareDTO> implements BeanFactoryAware, CRUDService<ID, DTO> {

    @Setter
    protected BeanFactory beanFactory;

    protected Class<DTO> dtoClass;

    protected AbstractService() {
        dtoClass = ReflectionUtils.getClassGenricType(getClass(), 1);
    }

    @Override
    public DTO create(DTO dto) {
        return null;
    }

    @Override
    public DTO retrieve(ID id) {
        return null;
    }

    @Override
    public DTO retrieveByCondition(DTO condition) {
        return null;
    }

    @Override
    public boolean update(DTO dto) {
        return false;
    }

    @Override
    public boolean delete(ID id) {
        return false;
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public boolean active(ID id) {
        return false;
    }

    @Override
    public boolean deactive(ID id) {
        return false;
    }
}
