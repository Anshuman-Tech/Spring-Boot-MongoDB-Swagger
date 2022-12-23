package com.anshuman.springbootmongo.repository;

import com.anshuman.springbootmongo.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job,String> {
}
