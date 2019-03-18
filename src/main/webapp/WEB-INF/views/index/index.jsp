<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<spring:message code="label_index_showArts" var="showArticles" />
<spring:message code="label_index_createArt" var="addArticle" />

<html>
<body>
<form method="get" action="/showArticles">
    <button type="submit">${showArticles}</button>
</form>
<form method="get" action="/addArticle">
    <button type="submit">${addArticle}</button>
</form>
</body>
</html>