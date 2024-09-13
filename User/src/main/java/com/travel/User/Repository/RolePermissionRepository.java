package com.travel.User.Repository;

import com.travel.User.Model.RolePermission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RolePermissionRepository extends MongoRepository<RolePermission, String> {

    List<RolePermission> findByRoleName(String roleName);

}
