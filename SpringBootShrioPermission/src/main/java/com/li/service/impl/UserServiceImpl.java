package com.li.service.impl;

import com.li.dao.Mapper.UserMapper;
import com.li.dao.pojo.User;
import com.li.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByName(String username) {
        logger.warn(username);
        return userMapper.findByUserName(username);
    }
}
