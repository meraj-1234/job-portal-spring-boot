package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.Job;

import java.util.List;

public interface JobService {
    Job updateJob(Long id ,Job job);
    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job createJob(Job job);
}
