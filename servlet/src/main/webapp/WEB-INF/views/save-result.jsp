<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<%-- request.getAttribute()를 통해 값을 가져온 후 getter를 통해 member 값 접근 가능 --%>
    <li>id=${member.id}</li>
    <li>id=${member.username}</li>
    <li>id=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>