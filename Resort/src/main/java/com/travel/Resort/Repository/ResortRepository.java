package com.travel.Resort.Repository;

import com.travel.Resort.Model.Resort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResortRepository extends MongoRepository<Resort, String> {

}
