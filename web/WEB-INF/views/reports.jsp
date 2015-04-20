<%-- 
    Document   : reports
    Created on : Apr 20, 2015, 12:05:41 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - Home">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" username="${username}" />
    
    <div class='container-fluid text-center'>
        
        <h3>Reports functions will go here</h3>
        
    </div>
    
</t:body-container>
