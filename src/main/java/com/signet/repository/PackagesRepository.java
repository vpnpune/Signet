package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Packages;

@Repository
public interface PackagesRepository extends CrudRepository<Packages, Long> {

	
	
}
