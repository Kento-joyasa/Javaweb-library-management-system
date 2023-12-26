<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="main.java.entity.Book" %>
<%@ page import="main.java.service.BookService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
    <head>
        <title>图书信息更新界面</title>
        <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap-theme.css"/>
        <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="/webapps/css/index.css"/>

        <style>
            .text-flag {
                width: 500px;
                margin-top: 20px;
            }
        </style>
    </head>

    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/books_management?useUnicode=true&characterEncoding=utf-8"
                       user="root"  password="admin"/>

        <div class="app" style="margin: 10px">
            <label class="title">图书信息修改</label>

            <sql:query dataSource="${snapshot}" var="bookre">
                SELECT * from `books_type`;
            </sql:query>

            <form class="input-box" action="/BookUpdateProceServlet" method="get">
                <%
                    String id = request.getParameter("id");

                    BookService bookService = new BookService();
                    Book book = bookService.queryBook(id);

                    out.print("<input type=\"text\" name=\"bookIdUpdate\" value=\"" + book.getBookId() + "\" style=\"display:none\" />");
                    out.print("<input type=\"text\" name=\"bookNameUpdate\" class=\"table-add-text form-control text-flag\" placeholder=\"图书名称\" value=\"" + book.getBookName() + "\"/>");
                    out.print("<input type=\"text\" name=\"bookAuthorUpdate\" class=\"table-add-text form-control text-flag\" placeholder=\"图书作者\" value=\"" + book.getBookAuthor() + "\"/>");
                    out.print("<input type=\"text\" name=\"bookPriceNameUpdate\" class=\"table-add-text form-control text-flag\" placeholder=\"图书价格\" value=\"" + book.getBookPrice() + "\"/>");
                %>

                <sql:query dataSource="${snapshot}" var="result_bookTypeId">
                    SELECT * from books_type;
                </sql:query>

                <select class="form-control" style="width: 100px; margin-left: 22px;" name="bookTypeIdUpdate">
                    <c:forEach var="row" items="${result_bookTypeId.rows}">
                        <option>${row.book_type_id}</option>
                    </c:forEach>
                </select>

                <%
                    out.print("<textarea class=\"table-add-text form-control text-flag\" rows=\"6\" name=\"bookDescUpdate\" placeholder=\"图书描述\"> " + book.getBookDesc() + " </textarea>");
                %>

                <button type="submit" class="table-add-but btn btn-primary">修改</button>
            </form>
        </div>
    </body>
</html>
