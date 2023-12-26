package main.java.entity;

/**
 * 用户实体类
 */
public class User {

    private String userId;          //用户id
    private String userName;        //用户名
    private String userPassword;    //用户密码

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
