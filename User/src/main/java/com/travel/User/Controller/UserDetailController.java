package com.travel.User.Controller;

import com.travel.User.Model.UserDetail;
import com.travel.User.Service.Interface.IUserDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-detail")
public class UserDetailController {

    private final IUserDetailService userDetailService;

    public UserDetailController(IUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public List<UserDetail> getAll() {
        return userDetailService.getAllUserDetail();
    }

    @GetMapping("/{id}")
    public UserDetail getById(@PathVariable String id) {
        return userDetailService.getUserDetailById(id);
    }

    @PostMapping
    public UserDetail add(@RequestBody UserDetail userDetail) {
        return userDetailService.createUserDetail(userDetail);
    }

    @PutMapping("/{id}")
    public UserDetail update(@PathVariable String id, @RequestBody UserDetail userDetail) {
        return userDetailService.updateUserDetail(id, userDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userDetailService.deleteUserDetail(id);
    }
}
