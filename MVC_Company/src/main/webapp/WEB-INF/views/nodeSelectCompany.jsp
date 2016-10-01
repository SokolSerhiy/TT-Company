<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="parents" items="${parents}">
    <c:set var="parents" value="${parents.childs}" scope="request"/>
    	<option style="padding: 0 0 0 ${parents.level * 20}px" value="${parents.id}">${parents.name}</option>
    <jsp:include page="nodeSelectCompany.jsp"/>
</c:forEach>