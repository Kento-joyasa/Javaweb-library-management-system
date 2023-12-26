package main.java.entity;

/**
 * book实体类
 */
public class Book {

    String bookId;
    String bookName;
    String bookAuthor;
    String bookPrice;
    String bookDesc;
    String bookTypeId;

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookTypeId(String bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public String getBookTypeId() {
        return bookTypeId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookTypeId='" + bookTypeId + '\'' +
                '}';
    }
}
