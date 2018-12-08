package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
