<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="list-group">
    <c:if test="${not empty categories}">
        <c:forEach items="${categories}" var="category">
            <a href="${contextPath}/showArticles-${category.id}" class="list-group-item list-group-item-action">${category.name}</a>
        </c:forEach>
    </c:if>
</div>
