package com.signet.dto;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AreaDto {
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "areaName")
	@NotBlank(message="Area Name should not be blank")
	private String areaName;
	
	@JsonProperty(value = "cityName")
	@NotBlank(message="City Name Should not be blank")
	private String cityName;
	
}
