<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="main.java.entity.BookType" %>
<%@ page import="main.java.service.BookTypeService" %>
<%@ page import="main.java.service.BookService" %>
<%@ page import="main.java.entity.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!-- 登录界面 -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>首页</title>

  <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap-theme.css"/>
  <link rel="stylesheet" type="text/css" href="/webapps/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="/webapps/css/index.css"/>
</head>


<body>
  <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
   url="jdbc:mysql://localhost:3306/books_management?useUnicode=true&characterEncoding=utf-8"
   user="root"  password="admin"/>

  <div class="topbar">
    <div class="title col-lg-2 col-lg-offset-5">图书管理系统</div>
  </div>

  <div class="content">
    <div class="sidebar">
      <ul>
        <li style="background-color: #4c7bd2; box-shadow:0 0 6px black inset;"><span>图书管理</span></li>
        <li><span>图书类别管理</span></li>
      </ul>
    </div>

    <ul class="win-ul">
      <li style="display: block;" id="win-1">
        <div class="top" style="width: 860px;">
          <div class="top-content">
            <form action="" method="get">
              <input type="text" class="form-control" name="bookName" placeholder="图书名称"
                     style="width:260px;"/>
              <input type="text" class="form-control" name="bookAuthor" placeholder="图书作者"
                     style="width:260px; margin-left: 30px;"/>
              <sql:query dataSource="${snapshot}" var="result_bookTypeId">
                SELECT * from books_type;
              </sql:query>

              <select class="form-control" style="width: 100px; margin-left: 30px;" name="bookTypeId">
                <option>全部</option>
                <c:forEach var="row" items="${result_bookTypeId.rows}">
                  <option>${row.book_type_id}</option>
                </c:forEach>
              </select>
              <button type="submit" class="btn btn-primary query-but" style="margin-left: 60px;">&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;</button>
            </form>
          </div>
        </div>

        <div class="win-table table-responsive">
          <!-- 添加界面 -->
          <div class="table-add-back"> <!-- 背景 -->
            <div class="table-add-content"> <!-- 内容 -->
              <div class="close-but btn btn-default">X</div>

              <label class="title">图书添加</label>

              <form class="input-box" action="/bookAddServlet" method="get">
                <input type="text" name="bookNameAdd" class="table-add-text form-control text-flag" placeholder="图书名称"/>
                <input type="text" name="bookAuthorAdd" class="table-add-text form-control text-flag" placeholder="图书作者"/>
                <input type="text" name="bookPriceNameAdd" class="table-add-text form-control text-flag" placeholder="图书价格"/>

                <sql:query dataSource="${snapshot}" var="result_bookTypeId">
                  SELECT * from books_type;
                </sql:query>

                <select class="form-control" style="width: 100px; margin-left: 22px;" name="bookTypeIdAdd">
                  <c:forEach var="row" items="${result_bookTypeId.rows}">
                    <option>${row.book_type_id}</option>
                  </c:forEach>
                </select>
                <textarea class="table-add-text form-control text-flag" rows="6" name="bookDesc" placeholder="图书描述"></textarea>
                <button type="submit" class="table-add-but btn btn-primary">添加</button>
              </form>
            </div>
          </div>

          <input type="button" name="table_add" value="&nbsp;&nbsp;添加&nbsp;&nbsp;" class="btn btn-success add-button" style="font-weight: bold;"/>

          <table class="table table-striped table-bordered table-hover" style="width: inherit;">
            <thead>
            <tr>
              <td>图书id</td>
              <td>图书名称</td>
              <td>图书作者</td>
              <td>图书价格</td>
              <td>图书描述</td>
              <td>图书类别id</td>
              <td class="oper-cell-book">操作</td>
            </tr>
            </thead>

            <%-- 图书表格内容 --%>
            <sql:query dataSource="${snapshot}" var="result_book">
              SELECT * from `book`;
            </sql:query>

            <tbody class="table-tbody">

                <%
                  String bookName = request.getParameter("bookName");;
                  String bookAuthor = request.getParameter("bookAuthor");
                  String bookTypeId = request.getParameter("bookTypeId");

                  //要执行的sql语句前部分
                  StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM book");

                  boolean flag_WHERE = false; //是否添加WHERE标记

                  //图书名文本区不为空
                  if (!(bookName == null)) {
                    sqlBuilder.append(" WHERE " + "book_name LIKE '%"+ bookName +"%'");
                    flag_WHERE = true;
                  }

                  //图书作者文本区不为空
                  if (!(bookAuthor == null)) {
                    if(!flag_WHERE) {
                      sqlBuilder.append(" WHERE ");
                      flag_WHERE = true;
                    }
                    else
                      sqlBuilder.append(" AND ");

                    sqlBuilder.append("book_author LIKE '%"+ bookAuthor +"%'");
                  }

                  if(bookTypeId != null) {
                    //不为全部时
                    if (!bookTypeId.equals("全部")) {
                      if(!flag_WHERE) {
                        sqlBuilder.append(" WHERE ");
                        flag_WHERE = true;
                      }
                      else
                        sqlBuilder.append(" AND ");

                      sqlBuilder.append("book_type_id = '"+ bookTypeId +"'");
                    }
                  }

                  String bookSQL = sqlBuilder.toString();     //得到需要执行的sql语句

                  System.out.println(bookSQL);

                  BookService bookService = new BookService();
                  List<Book> bookList = bookService.whereQueryBook(bookSQL);

                  for(Book book : bookList) {
                    out.print("<tr>");
                    out.print("<td>" + book.getBookId() + "</td>");
                    out.print("<td>" + book.getBookName() + "</td>");
                    out.print("<td>" + book.getBookAuthor() + "</td>");
                    out.print("<td>" + book.getBookPrice() + "</td>");
                    out.print("<td>" + book.getBookDesc() + "</td>");
                    out.print("<td>" + book.getBookTypeId() + "</td>");
                    out.print("<td>" +
                            "<a  class=\"updent-but-book\" href=\"" + request.getContextPath() + "/webapps/bookUpdate.jsp?id=" + book.getBookId() + "\">修改</a>"+
                            "<a  class=\"updent-but-book\" href=\"" + request.getContextPath() + "/BookDeleteServlet?id=" + book.getBookId() + "\">删除</a>"+
                            "</td>");
                    out.print("</tr>");
                  }
                %>
            </tbody>
          </table>
        </div>
      </li>

      <!-- 图书类别管理界面 -->
      <li id="win-2" style="display: none">
        <div class="top">
          <div class="top-content">
            <form action="" method="get">
              <input type="text" class="form-control query-text" name="bookTypeName" placeholder="图书类别名称"
                     style="width:400px;"/>
              <button type="submit" class="btn btn-primary query-but" style="margin-left: 50px;">&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;</button>
            </form>
          </div>
        </div>

        <div class="win-table table-responsive">

          <!-- 添加界面 -->
          <div class="table-add-back"> <!-- 背景 -->
            <div class="table-add-content"> <!-- 内容 -->
              <div class="close-but btn btn-default">X</div>

              <label class="title">图书类别添加</label>

              <form class="input-box" action="/BookTypeAddServlet" method="get">
                <input type="text" name="bookTypeNameAdd" class="table-add-text form-control text-flag" placeholder="图书类别名称"/>
                <textarea class="table-add-text form-control text-flag" rows="6" name="bookTypeDesc" placeholder="图书类别描述"></textarea>
                <button type="submit" class="table-add-but btn btn-primary">添加</button>
              </form>
            </div>
          </div>

          <input type="button" name="table_add" value="&nbsp;&nbsp;添加&nbsp;&nbsp;" class="btn btn-success add-button" style="font-weight: bold;"/>

          <table class="table table-striped table-bordered table-hover" style="width: inherit;">
            <thead>
            <tr>
              <td>图书类别id</td>
              <td>图书类别名称</td>
              <td>图书类别描述</td>
              <td class="oper-cell">操作</td>
            </tr>
            </thead>

            <tbody class="table-tbody">

            <%
              String bookTypeName = request.getParameter("bookTypeName");

              String sql1 = "SELECT * FROM books_type WHERE book_type_name LIKE \"%"+ bookTypeName +"%\"";

              if(bookTypeName == null || bookTypeName.equals("")) {
                sql1 = null;
              }

              String sql = sql1;
              System.out.println(sql + "sql");
              if(sql == null) {
                sql = "select * from `books_type`";
              }

              System.out.println(sql + "sql");

              BookTypeService service = new BookTypeService();
              List<BookType> bookTypeList = service.whereQueryBookType(sql);

              for(BookType type : bookTypeList) {
                out.print("<tr>");
                out.print("<td>" + type.getTypeId() + "</td>");
                out.print("<td>" + type.getTypeName() + "</td>");
                out.print("<td>" + type.getTypeDesc() + "</td>");
                out.print("<td>" +
                        "<a  class=\"updent-but-book\" href=\"" + request.getContextPath() + "/webapps/bookTypeUpdate.jsp?id=" + type.getTypeId() + "\">修改</a>"+
                        "<a  class=\"updent-but-book\" href=\"" + request.getContextPath() + "/BookTypeDeleteServlet?id=" + type.getTypeId() + "\">删除</a>"+
                        "</td>");
                out.print("</tr>");
              }
            %>
            </tbody>
          </table>

<%--          暂时不做分页--%>
<%--          <div class="bottom-but">--%>
<%--            <ul class="bottom-but-ul">--%>
<%--              <li>1</li>--%>
<%--            </ul>--%>
<%--          </div>--%>
        </div>
      </li>
    </ul>
  </div>

  <script type="text/javascript" src="/webapps/javascript/jquery.js"></script>
  <script type="text/javascript" src="/webapps/javascript/index.js"></script>
</body>
</html>
