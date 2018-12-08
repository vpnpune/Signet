package com.signet.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="news_seq_gen")
	@SequenceGenerator(name="news_seq_gen", sequenceName="NEWS_SEQ")
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDate startTime;

	@Column(nullable = false)
	private LocalDate endTime;
	
	@Column(nullable = false)
	private LocalDate addedOn;
	
	@Column(nullable = false)
	private boolean archived;
	
	@Column(nullable = false)
	private boolean alert;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id", nullable = false)
	private Area area;
}
