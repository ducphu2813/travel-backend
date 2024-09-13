package com.travel.User.Service.Interface;

import com.travel.User.Model.UserDetail;

import java.util.List;

public interface IUserDetailService {
    List<UserDetail> getAllUserDetail();
    UserDetail getUserDetailById(String id);
    UserDetail createUserDetail(UserDetail userDetail);
    UserDetail updateUserDetail(String id, UserDetail userDetail);
    void deleteUserDetail(String id);
}
