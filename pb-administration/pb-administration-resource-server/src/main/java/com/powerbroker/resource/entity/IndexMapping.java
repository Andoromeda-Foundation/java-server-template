package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "index_mappings")
public class IndexMapping extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;
    private String indexIdentifier;
    private String stationIdentifier;
    private String lineIdentifier;
    private Integer type;

    @Column(name = "`keys`")
    private String keys;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "index_id")
    private Index index;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    private PowerStation station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "line_id")
    private PowerStationLine line;
}

