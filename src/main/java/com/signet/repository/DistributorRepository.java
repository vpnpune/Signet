package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Distributor;

@Repository
public interface DistributorRepository extends CrudRepository<Distributor, Long> {

}
