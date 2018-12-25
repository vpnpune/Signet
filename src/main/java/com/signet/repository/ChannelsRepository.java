package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Channel;

@Repository
public interface ChannelsRepository extends CrudRepository<Channel, Long> {

	
	
}
