/**
 * For Business Activities.
 * <p>
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 * <p>
 * Create At 2016年8月24日
 */
package com.powerbroker.common.handler;

import lombok.Data;

/**
 * @author wjwjtftf
 *
 */
@Data
public class GenericResponse<T> {

    private boolean result;

    private ErrorDTO error;

    private T data;

    private PageDTO page;
}
