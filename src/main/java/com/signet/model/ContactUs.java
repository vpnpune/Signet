package com.signet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="contactus_seq_gen")
	@SequenceGenerator(name="contactus_seq_gen", sequenceName="CONTACTUS_SEQ")
	Long id;
	
	@Column(nullable = false)
	String fullName;
	
	@Column(nullable = false)
	String email;

	@Column(nullable = false)
	String contact;
	
	@Column(nullable = false)
	String message;
	
}
