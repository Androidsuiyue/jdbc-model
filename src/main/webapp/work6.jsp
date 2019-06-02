<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    int random = new Random().nextInt()*10;
    if(random >5){

%>
<jsp:forward page="work7.jsp">
    <jsp:param name="random" value="random" />
</jsp:forward>
<%
    }else{
%>
<jsp:forward page="work8.jsp">
    <jsp:param name="random" value="random" />
</jsp:forward>
<%
        }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2><%=random%></h2>
</body>
</html>
