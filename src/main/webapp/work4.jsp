<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.dao.impl.UserDAOImpl" %>
<%@ page import="cn.db.JDBCUtils" %>
<%@ page import="cn.model.User" %>
<%@ page import="cn.util.ConnectionContext" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    Connection connection = JDBCUtils.getConnection();
    ConnectionContext.getInstance().bind(connection);
    UserDAOImpl userDAO = new UserDAOImpl();
    User user1 = new User();
    user1.setAge("19");
    user1.setGender("网络184");
    user1.setName("Best Reven");
   userDAO.insert(user1);
    List<User> user = userDAO.getUser();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>插入信息：<%=user1%></h2>
<h2>结果信息：<%=user%></h2>
</body>
</html>
