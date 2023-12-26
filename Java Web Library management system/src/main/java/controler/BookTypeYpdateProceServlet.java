package main.java.controler;

import main.java.entity.BookType;
import main.java.service.BookTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图书类别修改请求处理servlet
 */
@WebServlet("/BookTypeYpdateProceServlet")
public class BookTypeYpdateProceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bookTypeIdUpdate");
        String name = request.getParameter("bookTypeNameUpdate");
        String desc = request.getParameter("bookTypeDescUpdate");

        BookTypeService service = new BookTypeService();

        BookType type = new BookType();
        type.setTypeId(id);
        type.setTypeName(name);
        type.setTypeDesc(desc);

        service.updateBookType(type);

        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
