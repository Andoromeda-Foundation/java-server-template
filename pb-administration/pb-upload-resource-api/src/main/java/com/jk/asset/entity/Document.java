package com.jk.asset.entity;

import com.powerbroker.common.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "documents")
public class Document extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String originName;

    private String savedName;

    private String contentType;

    private String checksum;

    @Column(name = "`length`")
    private Long length;
}
