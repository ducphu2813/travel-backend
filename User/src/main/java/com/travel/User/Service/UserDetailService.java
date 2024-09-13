package com.travel.User.Service;

import com.travel.User.Exception.NotFoundException;
import com.travel.User.Model.UserDetail;
import com.travel.User.Repository.UserDetailRepository;
import com.travel.User.Service.Interface.IUserDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailService implements IUserDetailService {

    private final UserDetailRepository userDetailRepository;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail getUserDetailById(String id) {
        return userDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("UserDetail not found with id: " + id));
    }

    @Override
    @Transactional
    public UserDetail createUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    @Transactional
    public UserDetail updateUserDetail(String id, UserDetail userDetail) {

        userDetail.setId(id);

        return userDetailRepository.save(userDetail);
    }

    @Override
    @Transactional
    public void deleteUserDetail(String id) {
        userDetailRepository.deleteById(id);
    }
}
