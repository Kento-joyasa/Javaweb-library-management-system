<%@ page import="main.java.service.BookTypeService" %>
<%@ page import="main.java.entity.BookType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>图书类别修改界面</title>
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

        <div class="app">
            <label class="title">图书类别添加</label>

            <form class="input-box" action="/BookTypeYpdateProceServlet" method="get" target="nm_iframe">

                <%
                    String id = request.getParameter("id");

                    BookTypeService service = new BookTypeService();

                    BookType type = service.queryBookType(id);

                    out.print("<input type=\"text\" name=\"bookTypeIdUpdate\" value=\" " + type.getTypeId() + "\" style=\"display:none\"/>");
                    out.print("<input type=\"text\" name=\"bookTypeNameUpdate\" class=\"table-add-text form-control text-flag\" placeholder=\"图书类别名称\" value=\" " + type.getTypeName() + "\"/>");
                    out.print("<textarea class=\"table-add-text form-control text-flag\" rows=\"6\" name=\"bookTypeDescUpdate\" placeholder=\"图书类别描述\">" + type.getTypeDesc() + "</textarea>");
                %>

                <button type="submit" class="table-add-but btn btn-primary">修改</button>
            </form>
        </div>

    </body>
</html>
