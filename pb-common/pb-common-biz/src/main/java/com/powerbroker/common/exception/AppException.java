/**
 * For commerce and communication.
 *
 * Copyright 2015 Fara, Org. All rights reserved.
 * Use is subject to license terms.
 *
 * Create At 2015年12月1日
 */
package com.powerbroker.common.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.NestedRuntimeException;

/**
 * Service层业务性质的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * 
 * @author wjwjtftf
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 407579617933981724L;

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
	}

	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof NestedRuntimeException) {
			return ((NestedRuntimeException) cause).contains(exType);
		} else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}
}
