package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.TourDAO;
import com.powerbroker.resource.entity.Tour;
import com.powerbroker.resource.model.TourDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultTourService extends AbstractJPAService<Long, TourDTO, Tour, TourDAO> implements TourService {

    @Override
    protected void createHandler(Tour target) {
        super.createHandler(target);

        target.getReward().setHasData(true);
    }
}
