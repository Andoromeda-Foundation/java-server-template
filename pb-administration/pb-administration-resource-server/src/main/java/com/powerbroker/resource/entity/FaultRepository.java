package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class FaultRepository extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String appearance;
    private String faultDevice;
    private String faultReason;
    private String isolationMode;
    private String isolationReference;
}
