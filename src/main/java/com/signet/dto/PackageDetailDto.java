package com.signet.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.signet.model.Channel;
import com.signet.model.Package;

import lombok.Data;

@Data
public class PackageDetailDto {
	public class PackageDetails {
		private Long id;
		
		private Package packageId;
		
		private Collection<Channel> listOfChannels = new ArrayList<>();
	}
}
