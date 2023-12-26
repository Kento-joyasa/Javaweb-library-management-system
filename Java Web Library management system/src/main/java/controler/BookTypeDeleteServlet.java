package main.java.controler;

import main.java.service.BookTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图书类别删除请求处理servlet
 */
@WebServlet("/BookTypeDeleteServlet")
public class BookTypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BookTypeService service = new BookTypeService();
        service.deleteBookType(id);

        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
