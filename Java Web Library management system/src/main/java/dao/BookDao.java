package main.java.dao;

import main.java.entity.Book;

import java.sql.ResultSet;
import java.util.List;

public interface BookDao {

    void add(Book book);

    void update(Book book);

    List<Book> queryAll();

    void delete(String id);

    List<Book> whereQuery(String sql);
}
