<%-- 
    Document   : body-template
    Created on : Apr 15, 2015, 9:44:01 PM
    Author     : Christian
--%>

<%@tag description="Contains the body of the page" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true"%>
 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>${title}</title>
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <!-- Our own CSS -->
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
    </head>

    <body>
        
        <jsp:doBody/>
        
        
        <!-- jQuery JavaScript -->
        <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <!-- Bootstrap JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <!-- Our own JavaScript -->
        <script src="${cp}/resources/js/main.js"></script>
    </body>
</html>
