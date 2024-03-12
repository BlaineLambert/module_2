package com.example.demo.job;

import com.example.demo.person.Person;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Job {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    private Long id;
    private String company;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "peoples_jobs",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> peopleJobs = new HashSet<>();

    public Job(Long id, String company) {
        this.id = id;
        this.company = company;
    }

    public Job(String company) {
        this.company = company;
    }

    public Job(Long id, String company, Set<Person> peopleJobs) {
        this.id = id;
        this.company = company;
        this.peopleJobs = peopleJobs;
    }

    public Job() {

    }
}
