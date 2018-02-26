package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class BulletinDTO extends AbstractDTO {

    private String title;
    private String content;
    private LocalDateTime publishedAt;
    private Integer object;
    private ReadReceiptDTO readReceipt;
    private LocalDateTime createAt;
}