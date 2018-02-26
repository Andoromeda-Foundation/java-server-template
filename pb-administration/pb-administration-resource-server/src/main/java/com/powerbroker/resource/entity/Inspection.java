package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "inspections")
public class Inspection extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private LocalDate at;
    private String place;
    private String submitter;
    private String consequence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Vehicle vehicle;
}
