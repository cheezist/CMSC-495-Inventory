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


    </div>
        
</t:body-container>
