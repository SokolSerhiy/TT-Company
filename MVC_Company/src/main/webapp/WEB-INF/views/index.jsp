<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Hello</h1>
<div class="row">
	<div class="col-md-12">
		<form:form action="/" method="POST" modelAttribute="company">
			<div class="form-group">
				<label>Parent:</label>
				<form:select path="parent" cssClass="form-control">
					<option value="0">Create main company</option>
					<jsp:include page="nodeSelectCompany.jsp"/>
				</form:select>
			</div>
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label>Money</label>
				<form:input path="money" cssClass="form-control"/>
			</div>
			<button type="submit" class="btn btn-default">Create</button>
		</form:form>
	</div>
	<div class="col-md-12">
		<jsp:include page="nodeDivCompany.jsp"/>
	</div>
</div>