package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Channels {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String channelCategoryId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String network;

	@Column(nullable = false)
	private String channelNo;

	@Column(nullable = false)
	private String rate;

	@Column(nullable = false)
	private String logoCDNLink;

	@Column(nullable = false)
	private String thumbnailCDNLink;

	
}
