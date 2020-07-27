<%--
  Created by IntelliJ IDEA.
  User: mc
  Date: 2020/7/15
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>

</head>
<body>
<h1 style="color: red">${msg}</h1>
<f:form modelAttribute="book" action="addbook" method="post">
    <label>书本名称</label><input type="text" name="bookName"/><f:errors path="bookName" cssStyle="color: red"/><br/>
    <label>书本价格</label><input type="text" name="price"/><f:errors path="price" cssStyle="color: red"/><br/>
    <label>书本类型</label><input type="text" name="bookType"/><f:errors path="bookType" cssStyle="color: red"/><br/>
    <input type="submit" value="确认"/>
</f:form>
</body>
</html>
