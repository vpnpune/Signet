package com.signet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AreaDto {
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "areaName")
	private String areaName;
	
	@JsonProperty(value = "cityName")
	private String cityName;
	
	@JsonProperty(value = "testNumber")
	private int testNumber;

}
