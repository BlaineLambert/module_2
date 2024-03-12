package com.example.demo.job;


import com.example.demo.car.CarRepository;
import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jr;
    @Autowired
    private PersonRepository pr;
    @Autowired
    private CarRepository cr;
    public List<Job> getAll(){
        return jr.findAll();
    }

    @Transactional
    public void addJob(Long personID, Long jobID) {
        Person person = pr.findById(personID).orElseThrow(() -> new IllegalStateException("Person with ID:" + personID + " doesnt exist"));
        Job job = jr.findById(jobID).orElseThrow(() -> new IllegalStateException("Job with ID:" + jobID + " doesnt exist"));
        person.getPeopleJobs().add(job);
        job.getPeopleJobs().add(person);
        pr.save(person);
        jr.save(job);
    }

    public void insertJob(Job job) { jr.save(job); }

    public void deleteJob(Long jobId) {
        boolean exists = jr.existsById(jobId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Job With Id " + jobId + " Exists"
            );
        }
        jr.deleteById(jobId);
    }

    public Optional<Job> getJob(Long jobId) {
        return jr.findById(jobId);
    }
}
