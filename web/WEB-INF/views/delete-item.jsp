<%-- 
    Document   : deleteItem
    Created on : Apr 20, 2015, 12:03:32 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - Home">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" />
    
    <ol class="container breadcrumb">
        <li><a href="${cp}/home">Home</a></li>
        <li><a href="${cp}/inventory">Inventory</a></li>
        <li class="active">View Item #${item.id}</li>
    </ol>

    <div class="container">
        
        <h3>Delete Inventory Item</h3>
        
        <form:form 
            method="POST" 
            modelAttribute="item"
            cssClass="form-horizontal">  
            
        <div class="text-center">
            <h4>Are you sure you want to delete ${item.make} ${item.model}?</h4>
        </div>

        <div class="form-group">
            <span class="col-md-5 pull-right">
                <button type="submit" class="btn btn-danger">Delete Item</button>
                <a href="${cp}/inventory/view/${item.id}" class="btn btn-warning">Cancel</a>
            </span>
        </div>
            
        </form:form>
                
    </div>
    
</t:body-container>
