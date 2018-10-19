package com.awssd.demo.service;

import com.awssd.demo.domain.User;


import java.util.List;

public interface UserService {
    public List<User> queryUserByUserName(String username);
    public int deleteUser(String username);
}
