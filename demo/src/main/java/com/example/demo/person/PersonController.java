package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService ps;

    @GetMapping( "/people")
    public List<Person> getAll(){
        return ps.getAll();
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        ps.deletePerson(personId);
    }

    @GetMapping("/{personId}")
    public Optional<Person> getPerson(@PathVariable Long personId) { return ps.getPerson(personId); }

    @PutMapping("/{personId}")
    public void updatePersonNumber (
            @PathVariable("personId") Long personId,
            @RequestParam() String name) {
        ps.updatePerson(personId, name);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) { ps.insertPerson(person); }
}
