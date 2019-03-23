<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spting" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath"/>

<spring:message code="label_sign_login" var="labelLogin"/>
<spring:message code="label_sign_password" var="labelPassword"/>
<spring:message code="label_register_email" var="labelEmail"/>
<spring:message code="label_register_button" var="labelBtn"/>
<spring:message code="label_register_msg" var="labelmsg"/>

<blockquote class="blockquote">
    <p class="mb-0">${labelmsg}</p>
</blockquote>
<form:form method="post" action="${contextPath}/saveAccount" modelAttribute="account">
    <div class="form-group row">
        <label for="inputLogin3" class="col-sm-2 col-form-label">${labelLogin}</label>
        <div class="col-sm-10">
            <form:input path="login" type="text" class="form-control" id="inputLogin3" placeholder="Login"/>
            <form:errors path="login" cssClass="error"/>
            <c:if test="${not empty loginError}">
                <label style="color: red">${loginError}</label>
            </c:if>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">${labelEmail}</label>
        <div class="col-sm-10">
            <form:input path="email" type="email" class="form-control" id="inputEmail3" placeholder="Email"/>
            <form:errors path="email" cssClass="error"/>
            <c:if test="${not empty emailError}">
                <label style="color: red">${emailError}</label>
            </c:if>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPassword3" class="col-sm-2 col-form-label">${labelPassword}</label>
        <div class="col-sm-10">
            <form:input path="password" type="password" class="form-control" id="inputPassword3"
                        placeholder="Password"/>
            <form:errors path="password" cssClass="error"/>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">${labelBtn}</button>
        </div>
    </div>
</form:form>
<c:if test="${not empty message}">
    <span class="error" style="color: red">${message}</span>
</c:if>