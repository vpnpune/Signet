package com.signet.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	@Autowired
	private ModelMapper modelMapper;
	
	public <T, V> Object convertToEntity(T objecct, Class<V> type) {
		return modelMapper.map(objecct, type);
	}
}
