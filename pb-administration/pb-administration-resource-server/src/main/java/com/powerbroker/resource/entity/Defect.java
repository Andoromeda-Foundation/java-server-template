package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "defects")
public class Defect extends AbstractEntity<Long> {

    private String customerName;
    private String stationName;
    private String source;
    private String primaryDevice;
    private String deviceAttachment;
    private String nature;
    private String content;
    private String discoverer;
    private LocalDateTime discoveryDate;
    private String liabilityCause;
    private String technicalReason;
    private String handleSuggestion;
    private String image;
    private LocalDateTime planDisposeDate;

    @ManyToOne
    @JoinColumn(name = "rfid_id")
    private Rfid rfid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reward_id")
    private Reward reward;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "defects_documents",
            joinColumns = {@JoinColumn(name = "defect_id")},
            inverseJoinColumns = {@JoinColumn(name = "document_id")})
    private Set<Document> documents = new HashSet<>();
}
