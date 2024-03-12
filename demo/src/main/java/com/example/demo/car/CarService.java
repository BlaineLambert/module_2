package com.example.demo.car;


import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    private CarRepository cr;
    @Autowired
    private PersonRepository pr;
    public List<Car> getAll(){
        return cr.findAll();
    }

    @Transactional
    public void addCar(Long personID, Long carID) {
        Person person = pr.findPersonById(personID).orElseThrow(() -> new IllegalStateException("Person with ID:" + personID + " doesnt exist"));
        Car car = cr.findCarById(carID).orElseThrow(() -> new IllegalStateException("Car with ID:" + carID + " doesnt exist"));
        person.setCar(car);
        car.getOwners().add(person);
        pr.save(person);
        cr.save(car);
    }
}
