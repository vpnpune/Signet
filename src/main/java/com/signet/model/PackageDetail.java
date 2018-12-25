package com.signet.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class PackageDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="package_details_seq_gen")
	@SequenceGenerator(name="package_details_seq_gen", sequenceName="PACKAGE_DETAILS_SEQ")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "package_id", nullable = false)
	private Package packageId;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "Channel_id", nullable = false)
	// private Collection<Channel> listOfChannels = new ArrayList<>();
}
