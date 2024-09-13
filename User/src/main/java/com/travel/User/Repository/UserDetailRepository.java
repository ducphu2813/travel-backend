package com.travel.User.Repository;

import com.travel.User.Model.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepository extends MongoRepository<UserDetail, String> {

}
