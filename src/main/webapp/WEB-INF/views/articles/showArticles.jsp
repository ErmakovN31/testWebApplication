<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Текущие статьи</title>
</head>

<body>
<div style="display: flex; flex-wrap: wrap">
    <c:if test="${not empty articles}">
        <c:forEach var="article" items="${articles}">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${article.name}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${article.category.name}</h6>
                    <p class="card-text">${article.content}</p>
                    <h6 class="card-subtitle mb-2 text-muted">Автор:&nbsp;${article.company.name}</h6>
                    <a href="/editArticle${article.id}" class="card-link">РЕДАКТИРОВАТЬ</a>
                    <a href="/removeArticle/${article.id}" class="card-link">УДАЛИТЬ</a>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<a class="btn btn-primary" href="/addArticle" role="button">Добавить статью</a>


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
