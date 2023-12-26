package main.java.controler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 */
@WebFilter(urlPatterns = {"/public/*", "*.jsp"})
public class AllFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");  //设置请求的编码
        response.setCharacterEncoding("UTF-8"); //设置响应的编码
        response.setContentType("text/html");   //设置响应的文档类型

        System.out.println("filter过滤器执行");
        // 得到HTTP请求信息对象
        HttpServletRequest req = (HttpServletRequest) request;
        // 获取路径信息
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

//        filterChain.doFilter(request, response);
//        req.getRequestDispatcher("/webapps/Login.jsp").forward(req, response);

        // 访问路径为登录界面或则可以通过，否则进入判断session
        if(servletPath.equals("/public/login")) {
            filterChain.doFilter(request, response);
        }
        else {
            // 获取session对象
            HttpSession session = req.getSession();
            // 获取session中的用户名属性值
            String sessionUserName = (String) session.getAttribute("username");
            // 判断属性值是否为空
            if(sessionUserName != null) {
                // 不为空代表已登录则可以通过
                filterChain.doFilter(request, response);
            }
            else  {
                // 为空代表未登录过，跳转至登录页面
                req.getRequestDispatcher("/public/login").forward(req, response);
//                ((HttpServletResponse) response).sendRedirect("/webapps/Login.jsp");
            }
        }

    }

    @Override
    public void destroy() {
    }
}
