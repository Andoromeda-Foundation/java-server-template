package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.UpdaterDAO;
import com.powerbroker.resource.entity.Updater;
import com.powerbroker.resource.model.UpdaterDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultUpdaterService extends AbstractJPAService<Long, UpdaterDTO, Updater, UpdaterDAO> implements UpdaterService {



}
