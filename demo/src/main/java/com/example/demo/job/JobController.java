package com.example.demo.job;

import com.example.demo.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService js;

    @GetMapping("/job")
    public List<Job> getAll(){
        return js.getAll();
    }
    @PutMapping("/job/{personID}/{jobID}")
    public void addJobs (
            @PathVariable("personID") Long personID,
            @PathVariable("jobID") Long jobID) {
        js.addJob(personID, jobID);
    }

    @PostMapping("/job")
    public void createJob(@RequestBody Job job) { js.insertJob(job); }

    @DeleteMapping("job/{jobId}")
    public void deleteJob(@PathVariable("jobId") Long jobId) {
        js.deleteJob(jobId);
    }

    @GetMapping("job/{jobId}")
    public Optional<Job> getJob(@PathVariable Long jobId) { return js.getJob(jobId); }
}
