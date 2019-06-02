<%@ page import="static org.apache.taglibs.standard.functions.Functions.substring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String word="这是一句超过12字符的话后面你看不到了";
    String word1=substring(word,0,12);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>这是原字符串 <%=word%></h2>
<h2>截取后的字符：<%=word1%>……</h2>
</body>
</html>
