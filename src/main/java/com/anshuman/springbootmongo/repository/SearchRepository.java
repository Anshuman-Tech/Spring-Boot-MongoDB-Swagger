package com.anshuman.springbootmongo.repository;

import com.anshuman.springbootmongo.model.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository{

    public List<Job> findByText(String text);
}
