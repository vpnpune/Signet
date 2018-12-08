package com.signet.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventDto {
	private Long id;
	
	private String eventTitle;
	
	private String eventDetails;
	
	private LocalDateTime eventStartTime;
	
	private LocalDateTime endTime;
	
	private boolean completed;
	
	private String streamingURL;
	
}
