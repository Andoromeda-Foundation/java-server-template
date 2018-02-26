package com.powerbroker.common.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Lionel on 28/10/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PlcAuditorEntity extends AuditorEntity {

    private String node;

    private String name;

    private String createAt;

    private String msg;
}
