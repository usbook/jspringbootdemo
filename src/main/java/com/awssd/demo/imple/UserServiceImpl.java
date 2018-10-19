package com.awssd.demo.imple;

import com.awssd.demo.dao.UserQueryAll;
import com.awssd.demo.domain.User;

import com.awssd.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class UserServiceImpl  implements UserService {
    @Autowired
    UserQueryAll mapper;

    @Override
    public List<User> queryUserByUserName(String username) {
        List<User> list = mapper.selectUser(username);
        return list;
    }
    @Override
    public int deleteUser(String username){
        int i=mapper.deleteUser(username);
        return i;

    }

}
