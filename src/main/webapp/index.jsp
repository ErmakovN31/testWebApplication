<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<html>
<body>
<form method="get" action="/showArticles">
    <button type="submit">Показать статьи</button>
</form>
<form method="get" action="/addArticle">
    <button type="submit">Добавить статью</button>
</form>
</body>
</html>