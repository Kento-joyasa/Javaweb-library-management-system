package main.java.controler;

import main.java.entity.User;
import main.java.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/public/login")
public class LoginServlet extends HttpServlet {

    // 处理登录jsp提交的表单
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("登录servlet post");

        // 获取提交来的数据
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        UserService service = new UserService();

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);

        // 判断用户是否存在
        if(service.isUserInfo(user)) {
            // 设置该用户的session
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            session.setMaxInactiveInterval(60 * 60);
            // 存在登录成功 跳转到首页
//            request.getRequestDispatcher("/").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/");  //重定向
        }
        else {
            // 不存在则重新跳转到登录界面
            request.getRequestDispatcher("/webapps/Login.jsp").forward(request, response);
        }
    }

    // 跳转到登录jsp界面
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录界面");

        //请求转发的路径的默认路径为web/，且在路径最前边要加上/
        request.getRequestDispatcher("/webapps/Login.jsp").forward(request, response);
    }
}
