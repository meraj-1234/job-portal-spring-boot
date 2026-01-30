package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PutMapping("/{id}")
   public Job updateJob(@PathVariable Long id, @RequestBody Job job){
        return jobService.updateJob(id,job);
   }
    @GetMapping
   public List<Job> getJobs(){
     return  jobService.getAllJobs();
   }
   @GetMapping("/{id}")
   public Job getJobByID(@PathVariable Long id){
        return jobService.getJobById(id);
   }
   @PostMapping
   public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
   }
}

