<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--for loop 편리하게 도는 기능 제공--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a> <table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>