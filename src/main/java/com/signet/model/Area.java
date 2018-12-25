package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Area {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="area_seq_gen")
	@SequenceGenerator(name="area_seq_gen", sequenceName="AREA_SEQ")
	Long id;

	@Column(nullable = false)
	String areaName;
	
	@Column(nullable = false)
	String cityName;
	
}
