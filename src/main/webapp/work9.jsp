<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head><title>注释测试</title></head>
<body>
<h2>注释测试</h2>
<!—这段注释显示在客户端的浏览器页面中 -->
<!—这个页面加载于 <%= (new java.util.Date()).toString() %> -->
<%-- 在页面源代码中，这个注释是看不见的 --%>
</body>
</html>