package main.java.service;

import main.java.dao.UserDao;
import main.java.dao.UserDaoImpl;
import main.java.entity.User;

public class UserService {

    private final UserDao userDao = new UserDaoImpl();

    // 添加用户
    public void addUser(User user) {
        userDao.add(user);
    }

    // 返回这个用户存不存在
    public boolean isUserInfo(User user) {
        return userDao.query(user);
    }
}
