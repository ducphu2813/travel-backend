package com.travel.User.Controller;

import com.travel.User.Model.LoginModel;
import com.travel.User.Service.Interface.IUserSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IUserSerivce userService;

    public AuthController(IUserSerivce userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {

        return ResponseEntity.ok(userService.verifyUser(loginModel));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginModel loginModel) {

        return ResponseEntity.ok(loginModel);
    }
}
