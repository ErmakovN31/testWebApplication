<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<spring:message code="label_header_title" var="mainTitle"/>
<spring:message code="label_header_arts" var="allArticles"/>
<spring:message code="label_header_categories" var="allCategories"/>
<spring:message code="label_header_createArt" var="addArticle"/>
<spring:message code="label_header_lang" var="language"/>
<spring:message code="label_login_link" var="loginLabel"/>
<spring:message code="label_logout_link" var="logoutLabel"/>
<spring:message code="label_register_button" var="registerLabel"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${contextPath}/">${mainTitle}</a>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${parameter == "showArticles" ? "active" : ""}">
                <a class="nav-link" href="${contextPath}/showArticles">${allArticles}</a>
            </li>
            <li class="nav-item ${parameter == "showCategories" ? "active" : ""}">
                <a class="nav-link" href="${contextPath}/showCategories">${allCategories}</a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item ${parameter == "createArticle" ? "active" : ""}">
                    <a class="nav-link" href="${contextPath}/addArticle">${addArticle}</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/logout">
                            ${logoutLabel} ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li class="nav-item ${parameter == "login" ? "active" : ""}">
                    <a class="nav-link" href="${contextPath}/login">${loginLabel}</a>
                </li>
                <li class="nav-item ${parameter == "register" ? "active" : ""}">
                    <a class="nav-link" href="${contextPath}/register">${registerLabel}</a>
                </li>
            </sec:authorize>
            <li>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle nav-link navbar-dark bg-dark" type="button"
                            id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${language}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="?lang=ru">Русский</a>
                        <a class="dropdown-item" href="?lang=en">English</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>
