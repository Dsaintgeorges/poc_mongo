package com.example.poc_mongo.repository;

import com.example.poc_mongo.model.Accessories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoriesRepository extends MongoRepository<Accessories,String> {

    @Query("INSERT into accessories a where a.carId = ?1 ")
    void saveAcc(Accessories accessories,String carId);
}
