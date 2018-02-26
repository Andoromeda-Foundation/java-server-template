package com.powerbroker.common.service;

/**
 * @author william
 */
public interface CRUDServiceAware<S> {

    <SS extends S> SS getService();
}
