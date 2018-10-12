package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.ChannelCategory;

@Repository
public interface ChannelCategoryRepository extends CrudRepository<ChannelCategory, Long> {

	
	
}
