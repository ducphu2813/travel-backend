package com.travel.Tour.Repository;

import com.travel.Tour.Model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepository extends MongoRepository<Tour, String> {

}
