<%-- 
    Document   : viewItem
    Created on : Apr 20, 2015, 12:00:53 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - View Item">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" />
    
    <ol class="container breadcrumb">
        <li><a href="${cp}/home">Home</a></li>
        <li><a href="${cp}/inventory">Inventory</a></li>
        <li class="active">View Item #${item.id}</li>
    </ol>

    <div class="container">
        <h3>View Inventory Item</h3>
    </div>

    <div class="container">

        <div class="col-md-1"></div>

        <div class="col-md-10">
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>ID:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.id}
                </div>
                
                <div class="col-md-2 view-heading">
                    <strong>Serial #:</strong>
                </div>
                
                <div class="col-md-5">
                    ${item.serialNumber}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Make:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.make}
                </div>
                
                <div class="col-md-2 view-heading">
                    <strong>Model:</strong>
                </div>
                
                <div class="col-md-5">
                    ${item.model}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Description:</strong>
                </div>
                
                <div class="col-md-10">
                    ${item.description}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Type:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.type}
                </div>
                
                <div class="col-md-2 view-heading">
                    <strong>Owner:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.owner}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Location:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.location}
                </div>
                
                <div class="col-md-2 view-heading">
                    <strong>Contact:</strong>
                </div>
                
                <div class="col-md-5">
                    ${item.pointOfContact}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Entered:</strong>
                </div>
                
                <div class="col-md-5">
                    ${item.dateEntered}
                    
                    <c:if test="${item.dateModified != null}">
                        &nbsp;&nbsp;(last modified - ${item.dateModified})
                    </c:if>
                    
                </div>
                
            </div>
            
            <div class="row text-center">
                <p></p>
                <a class="btn btn-info" href="${cp}/inventory/edit/${item.id}">Edit Item</a>
                &nbsp;&nbsp;
                <a class="btn btn-warning" href="${cp}/inventory/delete/${item.id}">Delete Item</a>
                &nbsp;&nbsp;
                <a class="btn btn-default" href="${cp}/inventory">View Inventory</a>
                &nbsp;&nbsp;
                <a class="btn btn-success" href="${cp}/inventory/new">Create Item</a>
            </div>
            
        </div>

        <div class="col-md-1"></div>


    </div>
        
</t:body-container>
