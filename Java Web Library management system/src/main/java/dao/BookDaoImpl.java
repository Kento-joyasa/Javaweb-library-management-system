package main.java.dao;

import main.java.entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public void add(Book book) {
        String sql = "insert into `book` (book_name,book_author,book_price,book_desc,book_type_id) values(?,?,?,?,?)";
        MyJDBC.insert(sql, true, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookDesc(), book.getBookTypeId());
    }

    @Override
    public void update(Book book) {
        String sql = "update `book` set `book_name`=?, book_author=?, book_price=?, book_desc=?, book_type_id=? WHERE book_id=?";
        MyJDBC.execute(sql,book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookDesc(), book.getBookTypeId(), book.getBookId());
    }

    @Override
    public List<Book> queryAll() {
        return whereQuery("select * from `book`");
    }

    @Override
    public void delete(String id) {
        String SQL = "delete from `book` where book_id=?";
        MyJDBC.execute(SQL, id);
    }

    /**
     * 根据sql参数查找全部结果
     */
    @Override
    public List<Book> whereQuery(String sql) {
        ResultSet result = MyJDBC.query(sql);

        List<Book> bookList = new ArrayList<>();
        try {
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1) + "");
                book.setBookName(result.getString(2));
                book.setBookAuthor(result.getString(3));
                book.setBookPrice(result.getString(4));
                book.setBookDesc(result.getString(5));
                book.setBookTypeId(result.getInt(6) + "");

                bookList.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }
}
