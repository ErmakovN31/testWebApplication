<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Доска статей</a>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/showArticles">Просмотр всех статей</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/showCategories">Просмотр категорий</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addArticle">Создать статью</a>
            </li>
        </ul>
    </div>
</nav>