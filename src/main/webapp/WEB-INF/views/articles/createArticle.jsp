<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath"  />

<spring:message code="label_art_title" var="labelTitle" />
<spring:message code="label_art_content" var="labelContent" />
<spring:message code="label_art_phone" var="labelPhone" />
<spring:message code="label_art_author" var="labelAuthor" />
<spring:message code="label_art_category" var="labelCategory" />
<spring:message code="label_art_save_button" var="labelSave" />

<script src="${resPath}/assets/ckeditor/ckeditor.js"></script>

<form:form method="POST" action="${contextPath}/saveArticle" modelAttribute="article">
    <div class="form-group">
        <form:hidden path="id"/>
        <label>${labelTitle}</label>
        <form:input path="name" class="form-control"/>
        <form:errors path="name" cssClass="error" />
    </div>
    <div class="form-group">
        <label>${labelContent}</label>
        <form:textarea path="content" class="form-control" id="textContent"/>
        <form:errors path="content" cssClass="error" />
    </div>
    <div class="form-group">
        <label>${labelPhone}</label>
        <form:input path="phone" class="form-control"/>
    </div>
    <div class="form-group">
        <label>${labelAuthor}</label>
        <select name="companyId">
            <c:forEach items="${companies}" var="company">
                <option value="${company.id}"
                        ${company.id == article.company.id ? "selected" : ""}>${company.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>${labelCategory}</label>
        <select name="categoryId">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}"
                        ${category.id == article.category.id ? "selected" : ""}>${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">${labelSave}</button>
</form:form>
<c:if test="${not empty message}">
    <span class="error" style="color: red">${message}</span>
</c:if>

<script type="text/javascript">
    CKEDITOR.replace('textContent');
</script>