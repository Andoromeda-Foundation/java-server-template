package com.powerbroker.common.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Lionel on 20/9/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "plc_command")
public class PlcCommandMongo extends PlcAuditorEntity {

    // deviceTeleCommandId
    // private String dvcCmdId;

    private String c01;
    private String c02;
    private String c03;
    private String c04;
    private String c05;
    private String c06;
    private String c07;
    private String c08;
    private String c09;
    private String c10;
    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17;
    private String c18;
    private String c19;
    private String c20;
    private String c21;
    private String c22;
    private String c23;
    private String c24;
    private String c25;
    private String c26;
    private String c27;
    private String c28;
    private String c29;
    private String c30;
    private String c31;
    private String c32;
    private String c33;
    private String c34;
    private String c35;
    private String c36;
    private String c37;
    private String c38;
    private String c39;
    private String c40;
    private String c41;
    private String c42;
    private String c43;
    private String c44;
    private String c45;
    private String c46;
    private String c47;
    private String c48;
    private String c49;
    private String c50;
    private String c51;
    private String c52;
    private String c53;
    private String c54;
    private String c55;
    private String c56;
    private String c57;
    private String c58;
    private String c59;
    private String c60;
}
