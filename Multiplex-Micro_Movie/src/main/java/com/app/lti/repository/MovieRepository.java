package com.app.lti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.lti.document.MovieDocument;

@Repository
public interface MovieRepository extends MongoRepository<MovieDocument, String> {

}
