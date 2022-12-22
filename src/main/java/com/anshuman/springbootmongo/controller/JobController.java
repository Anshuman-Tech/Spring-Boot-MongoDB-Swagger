package com.anshuman.springbootmongo.controller;

import com.anshuman.springbootmongo.model.Job;
import com.anshuman.springbootmongo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobs")
    public List<Job> getJobs(){
        return jobService.getAllJobs();
    }
}
