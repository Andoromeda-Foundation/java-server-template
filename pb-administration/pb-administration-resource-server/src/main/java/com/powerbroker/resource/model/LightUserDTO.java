package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
public class LightUserDTO extends AbstractDTO {

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String password;

//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
}
