<%-- 
    Document   : inventory
    Created on : Apr 19, 2015, 11:41:01 PM
    Author     : Matthew
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - Inventory">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" username="${username}" />
    

    <div class='container-fluid text-center'>

        <div class="icons-row">

            <div class="icon">
                <a href="${cp}/home">
                    <span>Home Page</span>
                </a>
            </div>
            <div class="icon">
                <a href="${cp}/inventory/create">
                    <span>Add New Item</span>
                </a>
            </div>
                    
            <div class="icon">
                <a href="${cp}/inventory/view">
                    <span>View Item</span>
                </a>
            </div>
        </div>
                    
    </div>
    
    <p></p>

    <div class="container-fluid">

        <div class="col-md-4"></div>

        <div class="col-md-4">

            <h4>INVENTORY</h4>

            <table  class="table table-condensed">
                <tr>
                    <th>Action</th>
                    <th>Model</th>
                    <th>Make</th>
                    <th>Date</th>
                    <th>Quantity</th>
                </tr>                
                <c:forEach items="${item}" var="item" varStatus="status">
                <tr>
                    <td>
                    <a href="${cp}/inventory/edit"><span>edit</span><span>/</span></a>
                    <a href="${cp}/inventory/delete"><span>delete</span></a>
                    </td>
                    <td>${item.model}</td>
                    <td>${item.make}</td>
                    <fmt:formatDate value="${item.made}" 
                                    var="madeFormatted"  
                                    type="date" 
                                    pattern="MM/dd/yyyy" />
                    <td>${madeFormatted}</td>
                    <td>${item.quantity}</td>
                </tr>
                </c:forEach>
            </table>

        </div>


    </div>
        
</t:body-container>