package com.travel.Resort.Repository;

import com.travel.Resort.Model.ResortRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResortRoomRepository extends MongoRepository<ResortRoom, String> {

    List<ResortRoom> findResortRoomById(List<String> id);
}
