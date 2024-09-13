package com.travel.User.Service.Interface;

import com.travel.User.DTO.UserDTO;
import com.travel.User.Model.User;

import java.util.List;

public interface IUserSerivce {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    User addUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
}
