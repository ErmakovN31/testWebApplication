<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<spring:message code="label_index_showArts" var="showArticles" />
<spring:message code="label_index_createArt" var="addArticle" />

<html>
<body>
<form method="get" action="${contextPath}/showArticles">
    <button type="submit">${showArticles}</button>
</form>
<form method="get" action="${contextPath}/addArticle">
    <button type="submit">${addArticle}</button>
</form>
<c:if test="${not empty message}">
    <span class="error" style="color: green">${message}</span>
</c:if>
</body>
</html>