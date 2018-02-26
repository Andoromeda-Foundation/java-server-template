package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import com.powerbroker.common.service.IdentifierAwareDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class UrlMappingDTO extends AbstractDTO implements IdentifierAwareDTO {

    public UrlMappingDTO() {

    }

    public UrlMappingDTO(String url, String httpMethod) {
        this.url = url;
        this.httpMethod = httpMethod;
    }

    private String url;

    private String httpMethod;
}
