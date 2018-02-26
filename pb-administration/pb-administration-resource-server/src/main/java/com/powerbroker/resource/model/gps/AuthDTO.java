package com.powerbroker.resource.model.gps;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class AuthDTO extends GenericDTO {

    private String access_token;

    private long expires_in;

}
