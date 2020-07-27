<%--
  Created by IntelliJ IDEA.
  User: mc
  Date: 2020/7/16
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
</head>
<body>
<form action="addfil" method="post"  enctype="multipart/form-data">
    <label>编号 :${param.id}</label><input type="hidden"  name="bookid" value="${param.id}"/><br/>
    <label>图片</label><input type="file" name="file"/><br/>
    <input type="submit"  value="上传"/>

</form>
</body>
</html>
