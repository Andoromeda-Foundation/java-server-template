package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class CommentDTO extends LightCommentDTO {

    private LightRewardDTO reward;
}
