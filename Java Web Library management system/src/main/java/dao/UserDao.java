package main.java.dao;

import main.java.entity.User;

import java.sql.ResultSet;

/**
 * 用户dao接口
 */
public interface UserDao {

    void add(User user);

    boolean query(User user);
}
