package main.java.controler;

import main.java.entity.Book;
import main.java.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookUpdateProceServlet")
public class BookUpdateProceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("bookIdUpdate");
        String name = request.getParameter("bookNameUpdate");
        String author = request.getParameter("bookAuthorUpdate");
        String price = request.getParameter("bookPriceNameUpdate");
        String typeId = request.getParameter("bookTypeIdUpdate");
        String desc = request.getParameter("bookDescUpdate");

        BookService service = new BookService();

        Book book = new Book();
        book.setBookId(id);
        book.setBookName(name);
        book.setBookAuthor(author);
        book.setBookPrice(price);
        book.setBookTypeId(typeId);
        book.setBookDesc(desc);

        service.update(book);

        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
