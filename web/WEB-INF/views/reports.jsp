<%-- 
    Document   : reports
    Created on : Apr 20, 2015, 12:05:41 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<t:body-container title="Track IT - Home">
    
    <t:nav-bar iconClass="glyphicon glyphicon-home" />
    
    <ol class="container breadcrumb">
        <li><a href="${cp}/home">Home</a></li>
        <li class="active">Reports</li>
    </ol>
    
    <div class='container'>
        
        <h3>Reports</h3>
        
        <div class="row" style="height: 400px;">
            
            <span class="col-md-4" id="items-by-owner" style="height: 400px;">
                <h4>Items by Owner</h4>
            </span>
            
            <span class="col-md-4" id="items-by-make" style="height: 400px;">
                <h4>Items by Make</h4>
                
            </span>
            
            <span class="col-md-4" id="statistics" style="height: 400px;">
                <h4>Overall Totals</h4>
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <th>
                                Items
                            </th>
                            <td>
                                ${totalItems}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Employees
                            </th>
                            <td>
                                ${totalEmployees}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Logins
                            </th>
                            <td>
                                ${totalLogins}
                            </td>
                        </tr>
                    </tbody>
                </table>
            </span>
            
        </div>
        
    </div>
    
    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
    <script>
    
    jQuery(function() {
        buildChart('#items-by-owner', itemsByOwnerData);
        buildChart('#items-by-make', itemsByMakeData);
    });
        
    var itemsByOwnerData = [
        <c:forEach items="${itemsByOwners}" var="stat" varStatus="status">
        {
            'index' : ${status.index},
            'name' : '${stat.key}',
            'count' : ${stat.value}
        }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];
        
    var itemsByMakeData = [
        <c:forEach items="${itemsByMakes}" var="stat" varStatus="status">
        {
            'index' : ${status.index},
            'name' : '${stat.key}',
            'count' : ${stat.value}
        }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];
    
    var colors = [
        '#BFDFFF', '#FF6666', '#59FF59', '#FF8CA9', '#FFCC99', '#FF73F3', 
        '#59E3FF', '#FFD24C'
    ];
    var colorIdx = 0;

    function buildChart(targetId, chartData) {
        
        var margin = {top: 0, right: 10, bottom: 0, left: 10},
            width = 390 - margin.left - margin.right,
            height = 275 - margin.top - margin.bottom,
            barHeight = 20, barMargin = 10, maxBarVal = 0,
            itemCount = chartData.length;
    
        barMargin = height / (itemCount + 1);
        console.log('barMargin', barMargin);
            
        // Max bar val is used to get averages
        jQuery.each( chartData, function(index, chartItem) {
            if (maxBarVal < chartItem.count) {
                maxBarVal = chartItem.count;
            }
        });
        
        var svg = d3.select(targetId).append('svg')
            .attr('width', width + margin.left + margin.right)
            .attr('height', height + margin.top + margin.bottom);
    
        var rects = svg.selectAll('rect')
                .data(chartData)
                .enter()
                .append('rect');
    
        var yLabels = svg.selectAll('text')
                .data(chartData)
                .enter()
                .append('text');
        
        var rectAttributes = rects
            .attr("width", function (d) { return width * (d.count / maxBarVal); })
            .attr("height", barMargin * 0.75)
            .attr("x", function (d) { return 0; })
            .attr("y", function (d) { return (barMargin/2) + d.index * barMargin; })
            .style("fill", getNewColor);
        
        var textAttributes = yLabels
            .attr("width", '50')
            .attr("height", '50')
            .attr("x", margin.left)
            .attr("y", function (d) { return barMargin + d.index * barMargin; })
            .text(function (d) { return d.name + ' (' + d.count + ')'; })
            .style("fill", 'black');
    }
    
    function getNewColor() {
        if (colorIdx === colors.length) {
            colorIdx = 0;
        }
        return colors[colorIdx++];
    }
    
    </script>
    
</t:body-container>
