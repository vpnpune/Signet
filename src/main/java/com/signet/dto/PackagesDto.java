package com.signet.dto;

import lombok.Data;

@Data
public class PackagesDto {
	
	private Long id;
	
	private String packageName;

	private String isHD;

	private boolean popular;
}
