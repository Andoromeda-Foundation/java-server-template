package com.powerbroker.resource.model.gps;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class AccountDTO extends AbstractDTO {

    private String name;
    private String password;
}
