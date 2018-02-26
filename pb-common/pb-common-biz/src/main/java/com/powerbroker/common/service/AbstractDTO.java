package com.powerbroker.common.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public abstract class AbstractDTO implements IdentifierAwareDTO {

    protected String id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
