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
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" username="${username}" />
    
<<<<<<< HEAD

    <div class='container-fluid text-center'>

        <div class="icons-row">

            <div class="icon">
                <a href="${cp}/home">
                    <span>Home Page</span>
                </a>
            </div>
            <div class="icon">
                <a href="${cp}/inventory/edit">
                    <span>Edit Item</span>
                </a>
            </div>
            <div class="icon">
                <a href="${cp}/inventory/delete">
                    <span>Delete Item</span>
                </a>
            </div>
            <div class="icon">
                <a href="${cp}/inventory">
                    <span>View Inventory</span>
                </a>
            </div>
                    
        </div>
    
    <p></p>

    <div class="container-fluid">

        <div class="col-md-4"></div>

        <div class="col-md-4">

            <h2>View Inventory Items</h2>

         <table  class="table table-condensed">
             <tr>
                 <td width="10" align="left">Make: </td>
                 <td colspan="1">ASUS</td>
             </tr>
             <tr>
                 <td width="10" align="left">Model: </td>
                 <td colspan="1">Chromebook</td>
             </tr>
             <tr>
                 <td width="10" align="left">Description: </td>
                 <td colspan="1">Silver laptop/ultrabook that runs the Chrome OS.Used for simple web browsing and testing of pages. Very stable but not recommended as a development or word processing machine</td>
             </tr>
             <tr>
                 <td width="10" align="left">Date: </td>
                 <td colspan="1">1/2/15</td>
             </tr>
             <tr>
                 <td width="10" align="left">Quantity: </td>
                 <td colspan="1">6</td>
             </tr>
            </table>
        </div>
=======
    <ol class="breadcrumb">
        <li><a href="${cp}/home">Home</a></li>
        <li><a href="${cp}/inventory">Inventory</a></li>
        <li class="active">View Item #${item.id}</li>
    </ol>

    <div class="container-fluid">
        <h3>View Inventory Item</h3>
    </div>

    <div class="container-fluid">

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
                    <strong>Quantity:</strong>
                </div>
                
                <div class="col-md-5">
                    ${item.quantity}
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
                    ${item.point_of_contact}
                </div>
                
            </div>
            
            <div class="row">
                
                <div class="col-md-2 view-heading">
                    <strong>Made:</strong>
                </div>
                
                <div class="col-md-3">
                    ${item.made}
                </div>
                
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
            </div>
            
        </div>

        <div class="col-md-1"></div>
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b


    </div>
        
</t:body-container>
