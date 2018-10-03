package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {

}
