<%-- 
    Document   : home
    Created on : Apr 15, 2015, 8:42:10 PM
    Author     : Christian
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - Home">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" />
    

    <div class='container text-center'>

        <h3>Select a task from the options below:</h3>

        <div class="icons-row">

            <div class="icon">
                <a href="${cp}/inventory">
                    <span class="glyphicon glyphicon-tasks"></span>
                    <span>View Inventory</span>
                </a>
            </div>

            <div class="icon">
                <a href="${cp}/inventory/new">
                    <span class="glyphicon glyphicon-plus-sign"></span>
                    <span>Create Item</span>
                </a>
            </div>

            <div class="icon">
                <a href="${cp}/reports">
                    <span class="glyphicon glyphicon-signal"></span>
                    <span>View Reports</span>
                </a>
            </div>

        </div>
                    
    </div>
    
    <p></p>

    <div class="container-fluid">

        <div class="col-md-2"></div>

        <div class="col-md-4">

            <h4>Current Users</h4>

            <table  class="table table-condensed">
                
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Last seen</th>
                </tr> 
                
                <c:forEach items="${users}" var="user" varStatus="status">
                <tr>
                    <td>${user.username}</td>
                    <td><a href="mailto:${user.email}">${user.email}</a></td>
                    <fmt:parseDate value="${user.lastLogin}"
                                   pattern="yyyy-MM-dd"
                                   var="parsedDate"
                                   type="date" />
                    <fmt:formatDate value="${parsedDate}" 
                                    var="lastLoginFormatted"  
                                    type="date" 
                                    pattern="MM/dd/yyyy" />
                    <td>${lastLoginFormatted}</td>
                </tr>
                </c:forEach>
                
            </table>
             
        </div>

        <div class="col-md-4">

            <h4>Latest Items <small><a href="${cp}/inventory">View Inventory</a></small></h4>

            <table  class="table table-condensed">
                
                <tr>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Type</th>
                    <th>Entered</th>
                </tr> 
                
                <c:forEach items="${items}" var="item" varStatus="status">
                <tr>
                    <td>
                        <a href="${cp}/inventory/view/${item.id}">${item.make}</a>
                    </td>
                    <td>
                        <a href="${cp}/inventory/view/${item.id}">${item.model}</a>
                    </td>
                    <td>${item.type}</td>
                    <fmt:parseDate value="${item.dateEntered}"
                                   pattern="yyyy-MM-dd"
                                   var="parsedDate"
                                   type="date"/>
                    <fmt:formatDate value="${parsedDate}" 
                                    var="dtEnteredFmt"  
                                    type="date" 
                                    pattern="MM/dd/yyyy" />
                    <td>${dtEnteredFmt}</td>
                </tr>
                </c:forEach>
                
            </table>
             
        </div>

        <div class="col-md-2"></div>


    </div>
        
</t:body-container>
