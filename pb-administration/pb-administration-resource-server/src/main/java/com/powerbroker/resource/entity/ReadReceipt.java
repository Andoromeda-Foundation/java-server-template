package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Document
@Setter
@Getter
public class ReadReceipt extends AbstractEntity<String> {

    private Long bulletinId;
    private Long readBy;
    private Boolean hasRead = true;
    private LocalDateTime readAt = LocalDateTime.now();
    private Integer object;
}
