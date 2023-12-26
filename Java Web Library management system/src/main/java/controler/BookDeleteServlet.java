package main.java.controler;

import main.java.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// JavaWebBooksManagementSystem
@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        BookService service = new BookService();
        service.deleteBook(id);

        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
