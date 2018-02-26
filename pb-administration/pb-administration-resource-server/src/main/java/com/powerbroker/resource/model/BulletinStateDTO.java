package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class BulletinStateDTO {

    private long readCount;
    private long allCount;

    public long getUnreadCount() {
        return allCount - readCount;
    }
}