package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractPersistableEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "md_requests")
public class MdRequest extends AbstractPersistableEntity<Long> {

    @Id
    @GenericGenerator(name = "foreign", strategy = "foreign", parameters = {
            @Parameter(name = "property", value = "powerStation")
    })
    @GeneratedValue(generator = "foreign")
    private Long id;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private PowerStation powerStation;

    private BigDecimal mdRequest;
    private BigDecimal limitPercentage;
    private BigDecimal threshold;
}