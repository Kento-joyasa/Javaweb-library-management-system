package main.java.dao;

import main.java.entity.BookType;

import java.util.List;

public interface BookTypeDao {

    void add(BookType bookType);

    void update(BookType bookType);

    List<BookType> queryAll();

    void delete(String id);

    List<BookType> whereQuery(String sql);
}
