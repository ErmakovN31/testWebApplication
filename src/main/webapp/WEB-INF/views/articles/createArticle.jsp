<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <title>Hello, world!</title>
</head>

<body>
<form:form method="POST" action="/saveArticle" modelAttribute="article">
    <div class="form-group">
        <form:hidden path="id"/>
        <label>Заголовок статьи</label>
        <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Контент</label>
        <form:input path="content" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Контактный телефон</label>
        <form:input path="phone" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Компания-автор</label>
        <select name="company_id">
            <c:forEach items="${companies}" var="company">
                <option value="${company.id}"
                        ${company.id == article.company.id ? "selected" : ""}>${company.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Категория</label>
        <select name="category_id">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}"
                        ${category.id == article.category.id ? "selected" : ""}>${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">SAVE</button>
</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>