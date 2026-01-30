package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    @Override
    public Job updateJob(Long id , Job job){
        Job existingjob=jobRepository.findById(id).orElse(null);
        if(existingjob==null){
            return null;
        }
        existingjob.setTitle(job.getTitle());
        existingjob.setDescription(job.getDescription());
        existingjob.setLocation(job.getLocation());
        existingjob.setRequiredSkills(job.getRequiredSkills());
       return jobRepository.save(existingjob);
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
}

