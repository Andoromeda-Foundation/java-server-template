package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "contracts")
public class Contract extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String code;
    @Column(name = "type")
    private Integer type;
    @ManyToOne
    private PowerStation powerStation;
    private BigDecimal amount;
    private String clientPrincipal;
    private String clientPhone;
    private LocalDateTime signedAt;
    private LocalDateTime expiredAt;
    private String signedBy;
    private String custodianBy;
    private String remark;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;
}
