package com.powerbroker.resource.service;

import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.UrlMappingDAO;
import com.powerbroker.resource.entity.UrlMapping;
import com.powerbroker.resource.model.UrlMappingDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultUrlMappingService extends AbstractJPAService<Long, UrlMappingDTO, UrlMapping, UrlMappingDAO> implements UrlMappingService {

    @Override
    public UrlMappingDTO mergeUrl(UrlMappingDTO dto) {
        UrlMapping urlMapping = ((UrlMappingDAO)dao).findByUrlAndHttpMethod(dto.getUrl(), dto.getHttpMethod());

        if (null == urlMapping) {
            urlMapping = ValueUtil.dump(dto, UrlMapping.class);
            dao.save(urlMapping);
        }

        return dto;
    }
}
