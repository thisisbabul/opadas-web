<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Profile :: Doctor</title>

<%
	if(!session.getAttribute("role").equals("doctor")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>

<jsp:include page="_header.jsp"></jsp:include>
<div class="outter-wp">
	<!--sub-heard-part-->
	<div class="sub-heard-part">
		<ol class="breadcrumb m-b-0">
			<li><a href="doctorhome">Home</a></li>
			<li class="active">Profile</li>
		</ol>
	</div>

	<!--//sub-heard-part-->
	<!--/profile-->
	<h3 class="sub-tittle pro">Profile</h3>
	<div class="profile-widget">
		<img src="doctorgetimage?id=${doctor.getId()}" alt=" " style="width: 150px; height: 150px" />
		<h2>${doctor.getName()}</h2>
		<p>${doctor.getExpertise()}</p>
	</div>

	<!--/profile-inner-->
	<form action="${pageContext.request.contextPath}/getadmininfo">
		<div class="profile-section-inner">
			<div class="col-md-6 profile-info">
				<h3 class="inner-tittle">Personal Information</h3>
				<div class="main-grid3">
					<div class="p-20">
						<div class="about-info-p">
							<strong>Full Name</strong> <br>
							<p class="text-muted">${doctor.getName()}</p>
						</div>
						<div class="about-info-p">
							<strong>Qualification</strong> <br>
							<p class="text-muted">${doctor.getQualification()}</p>
						</div>
						<div class="about-info-p">
							<strong>Organization</strong> <br>
							<p class="text-muted">${doctor.getOrganization()}</p>
						</div>
						<div class="about-info-p">
							<strong>Chamber</strong> <br>
							<p class="text-muted">${doctor.getChamber()}</p>
						</div>
						<div class="about-info-p">
							<strong>Location</strong> <br>
							<p class="text-muted">${doctor.getLocation()}</p>
						</div>
						<div class="about-info-p">
							<strong>Visiting Hours</strong> <br>
							<p class="text-muted">${doctor.getVisitinghours()}</p>
						</div>
						<div class="about-info-p">
							<strong>Email</strong> <br>
							<p class="text-muted">
								<a href="mailto:info@example.com">${doctor.getEmail()}</a>
							</p>
						</div>
						<div class="about-info-p">
							<strong>Mobile</strong> <br>
							<p class="text-muted">${doctor.getPhone()}</p>
						</div>
						<div class="about-info-p m-b-0">
							<strong>Status</strong> <br>
							<p class="text-muted">${doctor.getStatus()}</p>
						</div>
						<div class="about-info-p m-b-0">
							<input type="submit" value="Edit">
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>