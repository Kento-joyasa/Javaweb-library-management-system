package main.java.service;

import main.java.dao.BookTypeDao;
import main.java.dao.BookTypeDaoImpl;
import main.java.entity.BookType;

import java.util.List;

public class BookTypeService {

    private final BookTypeDao bookTypeDao = new BookTypeDaoImpl();

    // 添加图书类别
    public void addBookType(BookType bookType) {
        bookTypeDao.add(bookType);
    }

    public void updateBookType(BookType bookType) {
        bookTypeDao.update(bookType);
    }

    public List<BookType> queryBookTypes() {
        return bookTypeDao.queryAll();
    }


    public BookType queryBookType(String id) {
        BookType resultType = new BookType();

        for(BookType type : queryBookTypes())
            if(type.getTypeId().equals(id)) {
                resultType.setTypeId(type.getTypeId());
                resultType.setTypeName(type.getTypeName());
                resultType.setTypeDesc(type.getTypeDesc());
                break;
            }

        return resultType;
    }

    /**
     * 删除图书类别
     */
    public void deleteBookType(String id) {
        bookTypeDao.delete(id);
    }

    /**
     * 根据语句查询所有结果
     */
    public List<BookType> whereQueryBookType(String sql) {
        return bookTypeDao.whereQuery(sql);
    }
}
