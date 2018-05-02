<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List :: Patient</title>

<%
	if(!session.getAttribute("role").equals("admin")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>

<jsp:include page="_header.jsp"></jsp:include>
<h3 class="inner-tittle two" style="margin-left: 35px">Patient List</h3>
<div class="graph">
	<div class="table-responsive" style="height: 500px !important; overflow: scroll;">
		<table class="table table-hover" >
			<thead>
				<tr>
					<th>SL</th>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="patient" items="${patientList}">
				<tr>
					<th scope="row"><c:out value="${patient.id}"></c:out></th>
					<td><c:out value="${patient.name}"></c:out></td>
					<td><c:out value="${patient.address}"></c:out></td>
					<td><c:out value="${patient.mobile}"></c:out></td>
					<td><c:out value="${patient.email}"></c:out></td>
					<td><c:out value="${patient.password}"></c:out></td>
					<td><c:out value="${patient.status}"></c:out></td>
					<td><a href="#">Edit</a>|<a href="#">Delete</a></td>
				</tr>
			</c:forEach>	
				
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>