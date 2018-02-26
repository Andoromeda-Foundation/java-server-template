package com.powerbroker.common.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by Lionel on 10/10/2016.
 */
@Data
public class AuditorEntity {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime ts;
}
