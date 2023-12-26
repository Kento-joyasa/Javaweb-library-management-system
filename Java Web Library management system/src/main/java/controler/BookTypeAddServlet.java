package main.java.controler;

import main.java.entity.BookType;
import main.java.service.BookTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookTypeAddServlet")
public class BookTypeAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookTypeName = request.getParameter("bookTypeNameAdd");
        String bookTypeDesc = request.getParameter("bookTypeDesc");

        BookType bookType = new BookType();
        bookType.setTypeName(bookTypeName);
        bookType.setTypeDesc(bookTypeDesc);

        BookTypeService service = new BookTypeService();
        service.addBookType(bookType);
//
        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
