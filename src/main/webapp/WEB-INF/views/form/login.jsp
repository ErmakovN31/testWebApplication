<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath" />

<spring:message code="label_login_link" var="loginLabel" />
<spring:message code="label_password" var="passwordLabel" />

<blockquote class="blockquote">
    <p class="mb-0">${loginLabel}</p>
</blockquote>
<form action="<c:url value='/j_spring_security_check' />" method='POST'>
    <div class="form-group row">
        <div class="col-sm-10">
            <input type="text" name="login" id="login" placeholder="${loginLabel}" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <input type="password" name="password" id="password" placeholder="${passwordLabel}" class="form-control">
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">${loginLabel}</button>
        </div>
    </div>
    <c:if test="${not empty message}">
        <span class="error" style="color: red">${message}</span>
    </c:if>
</form>