<%
	if(!session.getAttribute("role").equals("doctor")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="_header.jsp"></jsp:include>
<h3 class="inner-tittle two" style="margin-left: 35px">Prescription
	List</h3>
<div class="graph">
	<form action="doctorpressearch" method="GET">
		<div class="input-group input-group-in" style="width: 300px;">
			<input type="text" name="prescriptionid" style="text-align: center;"
				class="form-control2 input-search"
				placeholder="Enter Prescription Id"> <span
				class="input-group-btn">
				<button class="btn btn-success" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
	</form>

	<div class="table-responsive"
		style="height: 500px !important; overflow: scroll;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>SL</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Prescription Id</th>
					<th>Blood Group</th>
					<th>Blood Pressure</th>
					<th>Disease Name</th>
					<th>Age</th>
					<th>Height</th>
					<th>Weight</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pres" items="${preslist}">
					<tr>
						<th scope="row"><c:out value="${pres.id}"></c:out></th>
						<td><c:out value="${pres.patient.name}"></c:out></td>
						<td><c:out value="${pres.patient.mobile}"></c:out></td>
						<td><c:out value="${pres.prescriptionId}"></c:out></td>
						<td><c:out value="${pres.bloodGroup}"></c:out></td>
						<td><c:out value="${pres.bloodPressure}"></c:out></td>
						<td><c:out value="${pres.diseaseName}"></c:out></td>
						<td><c:out value="${pres.age}"></c:out></td>
						<td><c:out value="${pres.height}"></c:out></td>
						<td><c:out value="${pres.weight}"></c:out></td>
						<td><a href="#">Print</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>