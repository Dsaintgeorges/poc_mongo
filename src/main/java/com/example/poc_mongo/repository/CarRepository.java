package com.example.poc_mongo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;



import com.example.poc_mongo.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car,String>{
}
