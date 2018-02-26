package com.powerbroker.resource.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lionel on 12/10/2016.
 */
@Entity
@Setter
@Getter
@Table(name = "plc_metric_metadatas")
@IdClass(value = PlcMetricMetadata.PlcMetricMetadataPK.class)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class PlcMetricMetadata{

	@Id
	@NonNull
	@Column(name = "node", nullable = false)
	private String node;

	@Id
	@NonNull
	@Column(name = "name", nullable = false)
	private String name;

	@Id
	@NonNull
	@Column(name = "metric_at", nullable = false)
	private String metricAt;

	@Id
	@NonNull
	@Column(name = "exec_item", nullable = false)
	private String execItem;

	@Getter
	@Setter
	@NoArgsConstructor
	@RequiredArgsConstructor
	public static class PlcMetricMetadataPK implements Serializable {

		private static final long serialVersionUID = 959741683654693227L;

		@NonNull
		private String node;

		@NonNull
		private String name;

		@NonNull
		private String metricAt;

		@NonNull
		private String execItem;
	}
}
