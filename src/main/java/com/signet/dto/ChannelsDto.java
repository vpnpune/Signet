package com.signet.dto;

import lombok.Data;

@Data
public class ChannelsDto {
	
	private Long id;
	
	private long channelCategoryId;

	private String name;

	private String network;

	private String channelNo;

	private String rate;

	private String logoCDNLink;

	private String thumbnailCDNLink;
}
