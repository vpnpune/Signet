package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Area;
import com.signet.model.ChannelCategory;
import com.signet.model.Customer;

@Repository
public interface ChannelCategoryRepository extends CrudRepository<ChannelCategory, Long> {

	
	
}
