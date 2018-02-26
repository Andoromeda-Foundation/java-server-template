package com.powerbroker.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
public class LightClientDTO extends AbstractDTO {

    @Setter
    @Getter
    private String username;

    @Setter
    private String password;

    @JsonIgnore
    public String getPassword() {
        return password;
    }
}
