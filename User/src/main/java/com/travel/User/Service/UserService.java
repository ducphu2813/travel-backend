package com.travel.User.Service;

import com.travel.User.DTO.UserDTO;
import com.travel.User.Exception.NotFoundException;
import com.travel.User.Model.LoginModel;
import com.travel.User.Model.User;
import com.travel.User.Repository.UserRepository;
import com.travel.User.Service.Interface.IUserSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserSerivce {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserService(
            UserRepository userRepository,
            ModelMapper modelMapper,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            AuthenticationManager authenticationManager,
            JWTService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
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
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                            loginModel.getUsername(),
                            loginModel.getPassword()
                        )
                );

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(loginModel.getUsername());
        } else {
            return "Failed to verify";
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
