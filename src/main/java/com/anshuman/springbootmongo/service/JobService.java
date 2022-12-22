package com.anshuman.springbootmongo.service;

import com.anshuman.springbootmongo.model.Job;
import com.anshuman.springbootmongo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
}