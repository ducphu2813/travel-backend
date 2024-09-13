package com.travel.User.Controller;

import com.travel.User.DTO.UserDTO;
import com.travel.User.Model.User;
import com.travel.User.Service.Interface.IUserSerivce;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserSerivce userService;

    public UserController(IUserSerivce userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
