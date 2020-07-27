<%--
  Created by IntelliJ IDEA.
  User: mc
  Date: 2020/7/15
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <%@include file="../head.jsp"%>
</head>
<body>
<shiro:hasRole name="管理员"><a href="input/book/addbook">增加书本</a></shiro:hasRole><br/>
<form>
 <shiro:hasPermission name="bookmanager:book:query">
<label>书本名称</label><input type="text" name="bookName"/>
    <input type="submit" value="搜索"/>
 </shiro:hasPermission>
</form>
<table border="1" width="100%" >
    <tr>
    <td>编号</td>
    <td>书本名称</td>
    <td>书本价格</td>
    <td>书本类型</td>
    <td>书本图片</td>
    <td>操作</td>
    </tr>

    <c:forEach items="${bookList}" var="b">
      <tr>
        <td>${b.id}</td>
        <td>${b.bookName}</td>
        <td>${b.price}</td>
        <td>${b.bookType}</td>
        <td>
            <c:if test="${not empty b.bookImg}">  <img width="200px" src="fileimg?fileId=${b.bookImg}" /></c:if>
          </td>
        <td><a href="input/book/addfile?id=${b.id}">上传头像</a>    <a href="fileimg?fileId=${b.bookImg}">下载头像</a></td>
      </tr>
    </c:forEach>

</table>


</body>
</html>
