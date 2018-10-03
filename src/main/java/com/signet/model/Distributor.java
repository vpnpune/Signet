package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Distributor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="distributor_seq_gen")
	@SequenceGenerator(name="distributor_seq_gen", sequenceName="DISTRIBUTOR_SEQ")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private long areaId;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String contactNo;

}
