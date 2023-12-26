package main.java.dao;

import main.java.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户接口实现类
 */
public class UserDaoImpl implements UserDao {

    /**
     * 添加用户方法
     */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO `user` VALUES(?,?,?)";
        MyJDBC.insert(sql, true, user.getUserId(), user.getUserName(), user.getUserPassword());
    }

    /**
     * 查询一个用户的信息
     */
    @Override
    public boolean query(User user) {
        String SQL = "select * from `user` where user_name = ? AND `password` = ?";
        ResultSet rs = MyJDBC.query(SQL, user.getUserName(), user.getUserPassword());
        boolean flag;
        try {
            flag = rs.isBeforeFirst();
        }
        catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
