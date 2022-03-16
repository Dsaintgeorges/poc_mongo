package com.example.poc_mongo.service;

import com.example.poc_mongo.model.Accessories;
import com.example.poc_mongo.model.Car;
import com.example.poc_mongo.repository.AccessoriesRepository;
import com.example.poc_mongo.repository.CarRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final AccessoriesRepository accessoriesRepository;
    private final MongoTemplate mongoTemplate;

    public CarService(CarRepository carRepository, AccessoriesRepository accessoriesRepository, MongoTemplate mongoTemplate) {
        this.carRepository = carRepository;
        this.accessoriesRepository = accessoriesRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void createCar(){
        Car car = new Car();
        Accessories acc1 = new Accessories();
        Accessories acc2 = new Accessories();
        Accessories acc3 = new Accessories();
        acc1.setName("uno");
        acc1.setId("uno1");
        acc1.setCarId("abcde");
        acc2.setName("duo");
        acc2.setCarId("abcd");
        acc2.setId("uno2");
        acc3.setName("trio");
        acc3.setId("trio3");
        acc3.setCarId("abcde");
        List<Accessories> list = new ArrayList<>();
        list.add(acc1);
        list.add(acc2);
        list.add(acc3);
        car.setName("volvica");
        car.setId("abcde");
        this.carRepository.save(car);
        for (Accessories accessories : list) {
            mongoTemplate.update(Car.class)
                    .matching(where("id").is(accessories.getCarId()))
                    .apply(new Update().push("accessories", accessories.getId()))
                    .first();
        }


    }
    public List<Car> getCar(){
        return this.carRepository.findAll();
    }
}
