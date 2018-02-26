package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class DeviceCategoryDTO extends AbstractDTO {

    private String deviceGenere;
    private String deviceCategory;
}
