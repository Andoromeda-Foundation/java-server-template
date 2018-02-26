package com.powerbroker.common.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Lionel on 20/9/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "plc_metric")
public class PlcMetricMongo extends PlcAuditorEntity {

}
