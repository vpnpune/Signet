package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Package {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String packageName;

	@Column(nullable = false)
	private String isHD;

	@Column(nullable = false)
	private boolean popular;
}
