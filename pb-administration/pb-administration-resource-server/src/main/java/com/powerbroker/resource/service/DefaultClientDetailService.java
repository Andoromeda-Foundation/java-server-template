package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.Constants;
import com.powerbroker.common.utils.GeneratorUtils;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.ClientDetailDAO;
import com.powerbroker.resource.entity.ClientDetail;
import com.powerbroker.resource.model.ClientDetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultClientDetailService extends AbstractJPAService<Long, ClientDetailDTO, ClientDetail, ClientDetailDAO> implements ClientDetailService {

    @Override
    protected void createHandler(ClientDetail target) {
        target.setClientSecret(GeneratorUtils.secretGenerator());
        target.setResourceIds(Constants.OAUTH2_DEFAULT_RESOURCE_ID);
        target.setScope(Constants.OAUTH2_DEFAULT_SCOPE);
        target.setAuthorizedGrantTypes(Constants.OAUTH2_DEFAULT_GRANT_TYPE);
        target.setAccessTokenValidity(Constants.OAUTH2_DEFAULT_ACCESS_TOKEN_VALIDITY);
        target.setRefreshTokenValidity(Constants.OAUTH2_DEFAULT_REFRESH_TOKEN_VALIDITY);
        super.createHandler(target);
    }

    @Override
    public ClientDetailDTO resetSecret(ClientDetailDTO dto) {
        Long id = ValueUtil.idDecode(dto.getId());
        ClientDetailDTO clientDetailDTO = this.retrieve(id);
        clientDetailDTO.setClientSecret(GeneratorUtils.secretGenerator());
        this.update(clientDetailDTO);
        return clientDetailDTO;
    }
}
