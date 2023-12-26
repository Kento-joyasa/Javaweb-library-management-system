package main.java.dao;

import main.java.entity.Book;
import main.java.entity.BookType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDaoImpl implements BookTypeDao {

    @Override
    public void add(BookType bookType) {
        String sql = "insert into books_type (book_type_name,book_type_desc) values(?,?)";
        MyJDBC.insert(sql, true, bookType.getTypeName(), bookType.getTypeDesc());
    }

    @Override
    public void update(BookType bookType) {
        String sql = "update `books_type` set book_type_name=?, book_type_desc=? where `book_type_id`=?";
        MyJDBC.execute(sql, bookType.getTypeName(), bookType.getTypeDesc(), bookType.getTypeId());
    }

    @Override
    public List<BookType> queryAll() {
        return whereQuery("select * from `books_type`");
    }

    @Override
    public void delete(String id) {
        String SQL = "delete from `books_type` where `book_type_id`=?";
        MyJDBC.execute(SQL, id);
    }

    /**
     * 根据sql查询所有结果
     */
    @Override
    public List<BookType> whereQuery(String sql) {
        ResultSet result = MyJDBC.query(sql);

        List<BookType> bookTypeList = new ArrayList<>();
        try {
            while (result.next()) {
                BookType type = new BookType();
                type.setTypeId(result.getInt(1) + "");
                type.setTypeName(result.getString(2));
                type.setTypeDesc(result.getString(3));

                bookTypeList.add(type);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return bookTypeList;
    }
}
