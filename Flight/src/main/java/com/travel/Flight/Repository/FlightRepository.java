package com.travel.Flight.Repository;

import com.travel.Flight.Model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
