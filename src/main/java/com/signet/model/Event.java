package com.signet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="area_seq_gen")
	@SequenceGenerator(name="area_seq_gen", sequenceName="AREA_SEQ")
	private Long id;
	
	@Column(nullable = false)
	private String eventTitle;
	
	@Column(nullable = false)
	private String eventDetails;
	
	@Column(nullable = false)
	private LocalDateTime eventStartTime;
	
	@Column(nullable = false)
	private LocalDateTime endTime;
	
	@Column(nullable = false)
	private boolean completed;
	
	@Column(nullable = false)
	private String streamingURL;
	
}
