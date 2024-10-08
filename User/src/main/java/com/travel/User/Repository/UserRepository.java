package com.travel.User.Repository;

import com.travel.User.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    //hàm lấy user bằng username
    User findByUsername(String username);
}
