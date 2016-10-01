<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="companies" items="${companies}">
    <c:set var="companies" value="${companies.childs}" scope="request"/>
    	<div class="col-md-4 col-xs-4" style="padding: 0 0 0 ${companies.level * 20}px" >${companies.name} </div>
    	<div class="col-md-4 col-xs-4" >Self money ${companies.money}</div>
    	<div class="col-md-4 col-xs-4" >All money ${companies.allmoney}</div>
    <jsp:include page="nodeDivCompany.jsp"/>
</c:forEach>