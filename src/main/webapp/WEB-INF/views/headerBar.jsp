<%--
  Created by IntelliJ IDEA.
  User: xaero
  Date: 14.03.2019
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav nav-tabs table-dark">
    <% if (request.getAttribute("showCompanies") == null) request.setAttribute("showCompanies", "");
    if (request.getAttribute("createCompany") == null) request.setAttribute("createCompany", "");%>
    <li class="nav-item">
        <a class="nav-link ${showCompanies}" href="/showCompanies">Show companies</a>
    </li>
    <li class="nav-item">
        <a class="nav-link ${createCompany}" href="/addCompany">Create company</a>
    </li>
</ul>
