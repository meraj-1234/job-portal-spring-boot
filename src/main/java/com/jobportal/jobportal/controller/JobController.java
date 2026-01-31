package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.dto.JobRequestDTO;
import com.jobportal.jobportal.dto.JobResponseDTO;
import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.service.JobService;
import jakarta.validation.Valid;
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
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
    }
    @PutMapping("/{id}")
   public JobResponseDTO updateJob( @Valid @PathVariable Long id, @RequestBody JobRequestDTO request){
        return jobService.updateJob(id,request);
   }
    @GetMapping
   public List<JobResponseDTO> getJobs(){
     return  jobService.getAllJobs();
   }
   @GetMapping("/{id}")
   public JobResponseDTO getJobByID(@PathVariable Long id){
        return jobService.getJobById(id);
   }
   @PostMapping
   public JobResponseDTO createJob(@Valid @RequestBody JobRequestDTO request){

        return jobService.createJob(request);
   }
}

