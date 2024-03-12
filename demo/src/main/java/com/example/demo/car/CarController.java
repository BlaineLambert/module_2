package com.example.demo.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService cs;

    @GetMapping("/car")
    public List<Car> getAll(){
        return cs.getAll();
    }

    @PutMapping("car/{personID}/{carID}")
    public void addCars (
            @PathVariable("personID") Long personID,
            @PathVariable("carID") Long carID) {
            cs.addCar(personID, carID);
    }
}
