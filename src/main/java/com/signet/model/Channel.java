package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Channel {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "channel_category_id", nullable = false)
	private ChannelCategory channelCategory;

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
	
	public void setChannelCategory(ChannelCategory channelCategory) {
        this.channelCategory = channelCategory;
    }
	
}
