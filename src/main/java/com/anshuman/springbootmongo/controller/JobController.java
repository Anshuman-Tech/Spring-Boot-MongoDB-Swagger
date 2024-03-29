package com.anshuman.springbootmongo.controller;

import com.anshuman.springbootmongo.model.Job;
import com.anshuman.springbootmongo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    @Autowired
    JobService jobService;


    //Direct to the swagger page for / route.
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobs")
    public List<Job> getJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Optional<Job> getJob(@PathVariable("id") String id){
        return jobService.getJob(id);
    }

    @PostMapping("/job")
    public Job postJob(@RequestBody Job job){
        return jobService.postJob(job);
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteJob(@PathVariable("id") String id){
        try{
            jobService.deleteJob(id);
            return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println("Error");
            return new ResponseEntity<>("Not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{text}")
    public List<Job> search(@PathVariable("text") String text){
        return jobService.search(text);
    }
}
