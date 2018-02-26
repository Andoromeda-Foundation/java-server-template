package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wjwjtftf
 *         Created on 2017/1/11.
 */
@Setter
public class RewardDTO extends LightRewardDTO {

    @Getter
    private LightCommentDTO comment;
}
