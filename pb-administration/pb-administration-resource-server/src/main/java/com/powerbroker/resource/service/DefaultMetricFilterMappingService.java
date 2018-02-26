package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.MetricFilterMappingDAO;
import com.powerbroker.resource.entity.MetricFilterMapping;
import com.powerbroker.resource.model.MetricFilterMappingDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultMetricFilterMappingService extends AbstractJPAService<Long, MetricFilterMappingDTO, MetricFilterMapping, MetricFilterMappingDAO> implements MetricFilterMappingService {

    @Override
    protected void createHandler(MetricFilterMapping target) {
        super.createHandler(target);

        target.setUuid(UUID.randomUUID().toString());
    }
}
