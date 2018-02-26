package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "comments")
public class Comment extends AbstractEntity<Long> {

    private String name;

    private String content;

    private Integer score;

    @OneToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;
}
