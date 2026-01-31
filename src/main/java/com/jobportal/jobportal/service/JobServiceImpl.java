package com.jobportal.jobportal.service;

import com.jobportal.jobportal.dto.JobRequestDTO;
import com.jobportal.jobportal.dto.JobResponseDTO;
import com.jobportal.jobportal.exception.ResourceNotFoundException;
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
    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public void deleteJob(Long id){
       Job job= jobRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found with id "+id));
       jobRepository.delete(job);
    }
    @Override
    public JobResponseDTO updateJob(Long id , JobRequestDTO request){
        Job existingjob=jobRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found with id "+id));
        existingjob.setTitle(request.getTitle());
        existingjob.setDescription(request.getDescription());
        existingjob.setLocation(request.getLocation());
        existingjob.setRequiredSkills(request.getRequiredSkills());
       Job updatejob= jobRepository.save(existingjob);
       return mapToResponse(updatejob);
    }

    @Override
    public JobResponseDTO getJobById(Long id) {
       Job job=jobRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found with id "+id));
       return mapToResponse(job);
    }

    @Override
    public JobResponseDTO createJob(JobRequestDTO request) {
         Job job=new Job();
         job.setTitle(request.getTitle());
         job.setLocation(request.getLocation());
         job.setDescription(request.getDescription());
         job.setRequiredSkills(request.getRequiredSkills());
         Job savedjob=jobRepository.save(job);
        return mapToResponse(savedjob);
    }
    private JobResponseDTO mapToResponse(Job job) {
        JobResponseDTO response = new JobResponseDTO();
        response.setId(job.getId());
        response.setTitle(job.getTitle());
        response.setLocation(job.getLocation());
        response.setDescription(job.getDescription());
        response.setRequiredSkills(job.getRequiredSkills());
        return response;
    }
}

