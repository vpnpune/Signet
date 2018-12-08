package com.signet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.signet.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

}
