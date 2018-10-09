package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Channels;

@Repository
public interface ChannelsRepository extends CrudRepository<Channels, Long> {

	
	
}
