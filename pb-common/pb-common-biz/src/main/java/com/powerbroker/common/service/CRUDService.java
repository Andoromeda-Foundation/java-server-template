/**
 * For Business Activities.
 * <p>
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 * <p>
 * Create At 2016年8月28日
 */
package com.powerbroker.common.service;

/**
 * @author wjwjtftf
 */
public interface CRUDService<ID, DTO> extends BaseService<ID, DTO> {

    DTO create(DTO dto);

    DTO retrieve(ID id);

    DTO retrieveByCondition(DTO condition);

    boolean update(DTO dto);

    boolean delete(ID id);

    void deleteAll();

    boolean active(ID id);

    boolean deactive(ID id);
}