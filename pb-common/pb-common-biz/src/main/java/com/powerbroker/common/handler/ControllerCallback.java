/**
 * For Business Activities.
 *
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 *
 * Create At 2016年8月24日
 */
package com.powerbroker.common.handler;

import java.text.ParseException;

/**
 * @author wjwjtftf
 *
 */
@FunctionalInterface
public interface ControllerCallback<RS> {

	void execute(GenericResponse<RS> response) throws ParseException;
}
