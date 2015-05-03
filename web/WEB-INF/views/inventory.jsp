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
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" />
    
    <ol class="container breadcrumb">
        <li><a href="${cp}/home">Home</a></li>
        <li class="active">Inventory</li>
    </ol>

    <div class="container">
        
        <h3>Inventory</h3>

        <div class="container-fluid">

            <div class="col-md-5">

                <strong>Showing <c:if test="${pages > 1}">${first}-${last} of </c:if>${total} Items</strong>

            </div>

            <div class="col-md-7">

                <span class="pull-right">

                    <!-- Search form -->
                    <form action="${cp}/inventory" 
                          method="post" 
                          id="searchForm" 
                          name="searchForm"
                          class="form-inline search-form">
                        <div class="form-group">
                            <label class="sr-only" for="term">Search</label>
                            <input type="text" 
                                   id="term" 
                                   name="term" 
                                   value="${term}"
                                   class="form-control"
                                   placeholder="Enter Search Term"/>
                            <button type="submit" class="btn btn-default">
                                Search
                            </button>
                    </form>

                    &nbsp;&nbsp;&nbsp;&nbsp;

                    <a href="${cp}/inventory/new" 
                       class="btn btn-success">Add New Item</a>

                </span>
            </div>
        </div>

        <div class="container-fluid">

            <div class="col-md-12">

                <table  class="table table-condensed">
                    <tr>
                        <th>Actions</th>
                        <th>ID</th>
                        <th>Make</th>
                        <th>Model</th>
                        <th>Serial Number</th>
                        <th>Date Entered</th>
                        <th>Date Updated</th>
                    </tr>                
                    <c:forEach items="${items}" var="item" varStatus="status">
                    <tr>
                        <td>
                            <a href="${cp}/inventory/view/${item.id}">view</a>
                            /
                            <a href="${cp}/inventory/edit/${item.id}">edit</a>
                            /
                            <a href="${cp}/inventory/delete/${item.id}">delete</a>
                        </td>
                        <td>${item.id}</td>
                        <td>${item.make}</td>
                        <td>${item.model}</td>
                        <td>${item.serialNumber}</td>
                        <fmt:parseDate value="${item.dateEntered}"
                                       pattern="yyyy-MM-dd"
                                       var="parsedEntered"
                                       type="date" />
                        <fmt:formatDate value="${parsedEntered}" 
                                        var="enteredFormatted"  
                                        type="date" 
                                        pattern="MM/dd/yyyy" />
                        <td>${enteredFormatted}</td>
                        <fmt:parseDate value="${item.dateModified}"
                                       pattern="yyyy-MM-dd"
                                       var="parsedModified"
                                       type="date" />
                        <fmt:formatDate value="${parsedModified}" 
                                        var="modifiedFormatted"  
                                        type="date" 
                                        pattern="MM/dd/yyyy" />
                        <td>${modifiedFormatted}</td>
                    </tr>
                    </c:forEach>
                </table>

            </div>

            <c:if test="${pages > 1}">
                ${pages} pages
            <nav>
                <ul class="pagination">
                  <li>
                    <a href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var="i" begin="1" end="${pages}">
                  <li>
                      <a href="${cp}/inventory?${term!='' ? 'term='+term : ''}offset=${(i-1)*rowcount}&rowcount=${rowcount}">
                          ${i}
                      </a>
                  </li>
                  </c:forEach>
                  <li>
                    <a href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </c:if>

        </div>
                   
    </div>
        
</t:body-container>