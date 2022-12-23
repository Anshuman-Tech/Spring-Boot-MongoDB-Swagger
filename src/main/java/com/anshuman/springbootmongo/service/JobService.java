package com.anshuman.springbootmongo.service;

import com.anshuman.springbootmongo.model.Job;
import com.anshuman.springbootmongo.repository.JobRepository;
import com.anshuman.springbootmongo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    SearchRepository searchRepository;
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }


    public Job postJob(Job job){
        return jobRepository.save(job);
    }

    public String deleteJob(String id){
        jobRepository.deleteById(id);
        return "Deleted successfully";
    }

    public Optional<Job> getJob(String id) {
        return jobRepository.findById(id);
    }

    public List<Job> search(String text){
        return searchRepository.findByText(text);
    }
}
