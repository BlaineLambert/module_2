package com.example.demo.person;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository pr;

    public List<Person> getAll(){
        return pr.findAll();
    }

    public void deletePerson(Long personId) {
        boolean exists = pr.existsById(personId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Person With Id " + personId + " Exists"
            );
        }
        pr.deleteById(personId);
    }

    public Optional<Person> getPerson(Long personId) {
        return pr.findById(personId);
    }
    @Transactional
    public void updatePerson(Long personId, String name) {
        Person person = pr.findById(personId).orElseThrow(() -> new IllegalStateException("Person with ID " + personId + " doesnt exist"));
        if (name != null){
            person.setName(name);
        }
    }

    public void insertPerson(Person person) { pr.save(person); }
}
