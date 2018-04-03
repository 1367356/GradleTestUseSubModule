package com.li.service;

import com.li.dao.pojo.User;

public interface UserService {
    User findUserByName(String username);
}
