package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Area {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="area_seq_gen")
	@SequenceGenerator(name="area_seq_gen", sequenceName="AREA_SEQ")
	private Long id;

	@Column(nullable = false)
	private String areaName;
	
	@Column(nullable = false)
	private String cityName;
	
//	@Column
//	private int testNumber;
}
