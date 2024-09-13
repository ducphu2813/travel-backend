package com.travel.User.Service;

import com.travel.User.DTO.UserDTO;
import com.travel.User.Exception.NotFoundException;
import com.travel.User.Model.User;
import com.travel.User.Repository.UserRepository;
import com.travel.User.Service.Interface.IUserSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserSerivce {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(
            UserRepository userRepository,
            ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(String id, User user) {
        User oldUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setDepartment(user.getDepartment());

        return userRepository.save(oldUser);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
