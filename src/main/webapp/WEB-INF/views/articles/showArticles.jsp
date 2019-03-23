<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<spring:message code="label_edit_art" var="labelEdit" />
<spring:message code="label_remove_art" var="labelRemove" />
<spring:message code="label_author" var="labelAuthor" />

<div style="display: flex; flex-wrap: wrap">
    <c:if test="${not empty articles}">
        <c:forEach var="article" items="${articles}">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${article.name}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${article.category.name}</h6>
                    <p class="card-text">${article.content}</p>
                    <h6 class="card-subtitle mb-2 text-muted">${labelAuthor}:&nbsp;${article.company.name}</h6>
                    <sec:authorize access="hasAuthority('admin')">
                        <a href="/editArticle${article.id}" class="card-link">${labelEdit}</a>
                        <a href="/removeArticle/${article.id}" class="card-link">${labelRemove}</a>
                    </sec:authorize>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<c:if test="${not empty message}">
    <span class="error" style="color: green">${message}</span>
</c:if>
