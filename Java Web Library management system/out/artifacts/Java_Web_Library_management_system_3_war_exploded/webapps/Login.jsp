<!-- 登录界面 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录页面</title>

    <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap-theme.css"/>
    <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/webapps/css/Longin.css"/>
</head>

<body>

    <div class="box">
        <div class="text">图书管理系统</div>
        <form style="margin-top: 50px;" method="post" action="/public/login">
            <div class="form-group col-lg-6 col-lg-offset-3">
                <label>用户名</label>
                <input type="text" class="form-control" placeholder="用户名" name="username">
            </div>
            <div class="form-group col-lg-6 col-lg-offset-3">
                <label>密码</label>
                <input type="password" class="form-control" placeholder="密码" name="password">
            </div>
            <button type="submit" class="btn btn-default col-lg-2 col-lg-offset-5" style="margin-top: 20px;">登录</button>
        </form>
    </div>

</body>
</html>
