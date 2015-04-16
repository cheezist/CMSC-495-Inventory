<%-- 
    Document   : innerPageTemplate
    Created on : Apr 15, 2015, 11:13:03 PM
    Author     : Christian
--%>

<%@tag description="Contains the body of the page" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="iconClass" %> 
<%@attribute name="username" %>

<nav class="navbar navbar-inverse">

    <div class="container-fluid">

        <div class="navbar-header">
            <span class="navbar-brand">MGSH Track-IT</span>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-right navbar-links">
            <span class="navbar-signed-in">Signed in as: <span class="label label-default">${username}</span> | </span>
            <a href="${cp}/sign-out">Sign Out</a>
        </div>
        
    </div>
        
</nav>