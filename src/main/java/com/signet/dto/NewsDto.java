package com.signet.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class NewsDto {
	
	private Long id;

	private String title;

	private String description;

	private LocalDate startTime;

	private LocalDate endTime;
	
	private LocalDate addedOn;
	
	private boolean archived;
	
	private boolean alert;
	
	private Long areaId;
}
