package main.java.controler;

import main.java.entity.Book;
import main.java.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookAddServlet")
public class BookAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String bookName = request.getParameter("bookNameAdd");
        String bookAuthor = request.getParameter("bookAuthorAdd");
        String bookPriceName = request.getParameter("bookPriceNameAdd");
        String bookTypeId = request.getParameter("bookTypeIdAdd");
        String bookDesc = request.getParameter("bookDesc");

        Book book = new Book();
        book.setBookName(bookName);
        book.setBookAuthor(bookAuthor);
        book.setBookPrice(bookPriceName);
        book.setBookTypeId(bookTypeId);
        book.setBookDesc(bookDesc);

        BookService service = new BookService();
        service.addBook(book);

        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/");
    }
}
