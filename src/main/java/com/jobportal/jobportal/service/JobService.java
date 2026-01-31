package com.jobportal.jobportal.service;

import com.jobportal.jobportal.dto.JobRequestDTO;
import com.jobportal.jobportal.dto.JobResponseDTO;
import com.jobportal.jobportal.model.Job;

import java.util.List;

public interface JobService {
    void deleteJob(Long id);
    JobResponseDTO updateJob(Long id , JobRequestDTO request);
    List<JobResponseDTO> getAllJobs();

    JobResponseDTO getJobById(Long id);

    JobResponseDTO createJob(JobRequestDTO request);
}
