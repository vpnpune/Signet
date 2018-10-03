package com.signet.dto;

import lombok.Data;

@Data
public class ChannelCategoryDto {
	public ChannelCategoryDto(long l, String string) {
		this.id=l;
		this.categoryName=string;
	}
	public ChannelCategoryDto() {
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String categoryName;

}
