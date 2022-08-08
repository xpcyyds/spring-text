package com.cdcompany.service;

import com.cdcompany.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    //登录用户
    public boolean findUser(User user);

    //添加用户
    public boolean addUser(User user);

    //删除用户
    public boolean deleteUser(User user);

    //更改用户信息
    public boolean updateUser(User user);
}
