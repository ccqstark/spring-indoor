package com.ccqstark.ioc.service;

import com.ccqstark.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 加了注解之后要记得配置包扫描
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<String> getAllUsers() {

        System.out.println(userDao.hello());

        List<String> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("ccq:" + i);
        }
        return users;
    }
}
