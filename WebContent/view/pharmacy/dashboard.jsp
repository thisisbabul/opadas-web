<%
	if(!session.getAttribute("role").equals("pharmacy")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>

<jsp:include page="_header.jsp"></jsp:include>
<h3 class="inner-tittle two" style="margin-left: 35px">Prescription</h3>
<div class="graph" style="text-align: cetner;">
	<form action="pharmacypressearch" method="post">
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
					<th>Doctor Name</th>
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
				<tr>
					<th scope="row">${pres.id}</th>
					<td>${pres.patient.name}</td>
					<td>${pres.patient.mobile}</td>
					<td>${pres.doctor.name}</td>
					<td>${pres.prescriptionId}</td>
					<td>${pres.bloodGroup}</td>
					<td>${pres.bloodPressure}</td>
					<td>${pres.diseaseName}</td>
					<td>${pres.age}</td>
					<td>${pres.height}</td>
					<td>${pres.weight}</td>
					<td><a href="getprescription?prescriptionid=${pres.prescriptionId}">Print</a></td>
				</tr>

			</tbody>
		</table>
	</div>

</div>
<jsp:include page="_footer.jsp"></jsp:include>