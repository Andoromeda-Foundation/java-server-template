package com.jk.asset.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class DocumentDTO extends AbstractDTO {

    private String originName;

    private String savedName;

    private String contentType;

    private String checksum;

    private Long length;
}
