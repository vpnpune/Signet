package com.signet.dto;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContactUsDto {
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "fullName")
	@NotBlank(message="Full Name should not be blank")
	private String fullName;
	
	@JsonProperty(value = "email")
	@NotBlank(message="Email Should not be blank")
	private String email;

	@JsonProperty(value = "contact")
	@NotBlank(message="Contact Should not be blank")
	private String contact;

	@JsonProperty(value = "message")
	@NotBlank(message="Message Should not be blank")
	private String message;

	
}
