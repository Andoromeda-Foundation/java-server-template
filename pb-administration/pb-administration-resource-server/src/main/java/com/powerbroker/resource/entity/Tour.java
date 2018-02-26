package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "tours")
public class Tour extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "rfid_id")
    private Rfid rfid;

    @ManyToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;

    private Integer deviceState;
    private Boolean leak;
    private Boolean illumination;
    private Boolean animal;
    private Boolean security;
    private Boolean hygiene;
    private String content;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tours_documents",
            joinColumns = {@JoinColumn(name = "tour_id")},
            inverseJoinColumns = {@JoinColumn(name = "document_id")})
    private Set<Document> documents = new HashSet<>();
}
