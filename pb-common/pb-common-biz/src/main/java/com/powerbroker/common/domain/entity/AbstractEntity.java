/**
 * For commerce and communication.
 * <p>
 * Copyright 2015 Fara, Org. All rights reserved.
 * Use is subject to license terms.
 * <p>
 * Create At 2015年11月29日
 */
package com.powerbroker.common.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wjwjtftf
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> extends AbstractPersistableEntity<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
}
