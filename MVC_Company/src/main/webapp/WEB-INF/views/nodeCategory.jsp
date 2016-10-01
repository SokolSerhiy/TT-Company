<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="categories" items="${categories}">
    <c:set var="categories" value="${categories.childs}" scope="request"/>
    	<div style="padding: 0 0 0 ${categories.level * 20}px" value="${categories.id}">${categories.getName(pageContext.response.locale)}</div>
    <jsp:include page="nodeCategory.jsp"/>
</c:forEach>