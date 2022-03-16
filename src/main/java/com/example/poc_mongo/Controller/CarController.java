package com.example.poc_mongo.Controller;

import com.example.poc_mongo.model.Car;
import com.example.poc_mongo.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    public void createCar(){
        this.carService.createCar();
    }
    @GetMapping()
    public List<Car> getCar(){
        return this.carService.getCar();
    }
}
