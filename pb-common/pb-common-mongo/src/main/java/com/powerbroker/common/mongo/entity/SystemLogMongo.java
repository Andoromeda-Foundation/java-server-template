package com.powerbroker.common.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by Lionel on 10/10/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "sys_log")
@RequiredArgsConstructor
public class SystemLogMongo extends AuditorEntity {

    @NonNull
    private String app;

    private Level lv;

    private String ex;

    private String method;

    private String code;

    private String msg;
}
