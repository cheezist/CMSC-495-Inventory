<%-- 
    Document   : index
    Created on : Apr 13, 2015, 8:47:37 PM
    Author     : Christian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Track IT</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
        <script src="${cp}/resources/js/main.js"></script>
    </head>
    <body>
        <h4>Spring 4 Web MVC via Annotations</h4>
        Spring says: <span class="blue">${msg}</span>
    </body>
</html>