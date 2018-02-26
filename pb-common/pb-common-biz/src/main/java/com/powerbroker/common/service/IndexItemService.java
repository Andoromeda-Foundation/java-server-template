/**
 * For Business Activities.
 * <p>
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 * <p>
 * Create At 2016年8月28日
 */
package com.powerbroker.common.service;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexItemService<ID, DTO> extends BaseService<ID, DTO> {

    DTO aggregate(DTO condition);

    List<DTO> history(DTO condition) throws ParseException;

    List<DTO> realTime(DTO indexDischargeDTO);
}