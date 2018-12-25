package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.ContactUs;

@Repository
public interface ContactUsRepository extends CrudRepository<ContactUs, Long> {

}
