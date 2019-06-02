<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.db.JDBCUtils" %>
<%@ page import="java.sql.Connection" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%
    String result = "";
    //取得数据库连接conn
    Connection conn= JDBCUtils.getConnection();
    if (conn != null) {
        result="JDBC+C3P0连接数据库成功";
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2><%=result%></h2>
</body>
</html>
