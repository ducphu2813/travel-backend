package com.travel.User.Service;

import com.travel.User.DTO.UserDTO;
import com.travel.User.Exception.NotFoundException;
import com.travel.User.Model.LoginModel;
import com.travel.User.Model.User;
import com.travel.User.Repository.UserRepository;
import com.travel.User.Service.Interface.IUserSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserSerivce {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JWTService jwtService;

    public UserService(
            UserRepository userRepository,
            ModelMapper modelMapper,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            JWTService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
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

    //verify user và tạo token
    @Override
    public String verifyUser(LoginModel loginModel) {
        boolean isExist = false;
        //lấy user theo username
        User user = userRepository.findByUsername(loginModel.getUsername());
        if(user != null){
            isExist = true;
        }

        if(isExist){
            //lấy ra list role của user
            List<String> roles = user.getRole();
            return jwtService.generateToken(loginModel.getUsername(), roles);
        } else {
            return "Failed to verify, username or password is incorrect!";
        }

    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.setId(null);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
