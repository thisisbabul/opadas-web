<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List :: Doctor</title>
<jsp:include page="_header.jsp"></jsp:include>
<h3 class="inner-tittle two" style="margin-left: 35px">Doctor List</h3>
<div class="graph">
	<a href="${pageContext.request.contextPath}/view/doctor/register.jsp"><input type="submit" value="Add"></a>
	<div class="table-responsive" style="height: 500px !important; overflow: scroll;">
		<table class="table table-hover" >
			<thead>
				<tr>
					<th>SL</th>
					<th>Name</th>
					<th>Qualification</th>
					<th>Expertise</th>
					<th>Organization</th>
					<th>Chamber</th>
					<th>Visiting Hours</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="doctor" items="${doctorList}">
				<tr>
					<th scope="row"><c:out value="${doctor.id}"></c:out></th>
					<td><c:out value="${doctor.name}"></c:out></td>
					<td><c:out value="${doctor.qualification}"></c:out></td>
					<td><c:out value="${doctor.expertise}"></c:out></td>
					<td><c:out value="${doctor.organization}"></c:out></td>
					<td><c:out value="${doctor.chamber}"></c:out></td>
					<td><c:out value="${doctor.visitinghours}"></c:out></td>
					<td><c:out value="${doctor.phone}"></c:out></td>
					<td><c:out value="${doctor.email}"></c:out></td>
					<td><c:out value="${doctor.password}"></c:out></td>
					<td><a href="#">Edit</a>|<a href="#">Delete</a></td>
				</tr>
			</c:forEach>	
				
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>