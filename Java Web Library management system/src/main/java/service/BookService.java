package main.java.service;

import main.java.dao.BookDao;
import main.java.dao.BookDaoImpl;
import main.java.entity.Book;

import java.util.List;

public class BookService {

    private final BookDao bookDao = new BookDaoImpl();

    // 增加
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 修改
    public void update(Book book) {
        bookDao.update(book);
    }

    // 查询所有结果
    public List<Book> queryBooks() {
        return bookDao.queryAll();
    }

    // 查询单个book的结果
    public Book queryBook(String id) {
        Book resultBook = new Book();

        for(Book book1 : queryBooks())
            if(book1.getBookId().equals(id)) {
                resultBook.setBookTypeId(book1.getBookTypeId());
                resultBook.setBookDesc(book1.getBookDesc());
                resultBook.setBookPrice(book1.getBookPrice());
                resultBook.setBookId(book1.getBookId());
                resultBook.setBookName(book1.getBookName());
                resultBook.setBookAuthor(book1.getBookAuthor());
                break;
            }

        return resultBook;
    }

    // 删除
    public void deleteBook(String id) {
        bookDao.delete(id);
    }

    /**
     * 根据sql查询全部结果
     */
    public List<Book> whereQueryBook(String sql) {
        return bookDao.whereQuery(sql);
    }
}
