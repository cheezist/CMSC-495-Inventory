<%-- 
    Document   : createItem
    Created on : Apr 19, 2015, 11:41:01 PM
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
        <li class="active">Create Item</li>
    </ol>

    <div class="container">
        <h3>Create Inventory Item</h3>
        
        <form:form 
            method="POST" 
            modelAttribute="item"
            cssClass="form-horizontal">    
            
            <div class="form-group">
                <form:label path="serialNumber" cssClass="col-md-1 control-label">Serial #</form:label>
                <span class="col-md-9">
                    <form:input path="serialNumber" cssClass="form-control"></form:input>
                </span>
            </div>
            
            <div class="form-group">
                <form:label path="make" cssClass="col-md-1 control-label">Make</form:label>
                <span class="col-md-4">
                    <form:input path="make" cssClass="form-control"></form:input>
                </span>
                <form:label path="model" cssClass="col-md-1 control-label">Model</form:label>
                <span class="col-md-4">
                    <form:input path="model" cssClass="form-control"></form:input>
                </span>
            </div>
            
            <div class="form-group">
                <form:label path="description" cssClass="col-md-1 control-label">Description</form:label>
                <span class="col-md-9">
                    <form:textarea path="description" cssClass="form-control"></form:textarea>
                </span>
            </div>
            
            <div class="form-group">
                <form:label path="type" cssClass="col-md-1 control-label">Type</form:label>
                <span class="col-md-4">
                    <form:select 
                        path="type" 
                        cssClass="form-control"
                        items="${types}">
                    </form:select>
                </span>
                <form:label path="owner" cssClass="col-md-1 control-label">Department</form:label>
                <span class="col-md-4">
                    <form:select 
                        path="owner" 
                        cssClass="form-control"
                        items="${departments}">
                    </form:select>
                </span>
            </div>
            
            <div class="form-group">
                <form:label path="location" cssClass="col-md-1 control-label">Location</form:label>
                <span class="col-md-4">
                    <form:input path="location" cssClass="form-control"></form:input>
                </span>
                <form:label path="contactEmplId" cssClass="col-md-1 control-label">Contact</form:label>
                <span class="col-md-4">
                    <form:select 
                        path="contactEmplId" 
                        cssClass="form-control"
                        items="${people}">
                    </form:select>
                </span>
            </div>
            
            <div class="form-group">
                <span class="col-md-5 pull-right">
                    <button type="reset" class="btn btn-info">Reset Form</button>
                    <button type="submit" class="btn btn-success">Save Item</button>
                </span>
            </div>
        </form:form>
        
    </div>
    
</t:body-container>
