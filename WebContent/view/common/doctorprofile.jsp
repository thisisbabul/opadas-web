<jsp:include page="_header.jsp"></jsp:include>
<div class="outter-wp">
	<!--sub-heard-part-->
	<div class="sub-heard-part">
		<ol class="breadcrumb m-b-0">
			<li><a href="${pageContext.request.contextPath}/index">Home</a></li>
			<li class="active">Profile</li>
		</ol>
	</div>
<div class="graph-form">
	<div class="profile-widget">
		<img src="doctorgetimage?id=${doctor.getId()}" alt=" "
			style="width: 150px; height: 150px" />
		<h2>${doctor.getName()}</h2>
		<p>${doctor.getExpertise()}</p>
	</div>

	<!--/profile-inner-->
	<form action="${pageContext.request.contextPath}/appointment">
		<input type="hidden" name="id" value="${doctor.getId()}">
		<div class="profile-section-inner" style="text-align: center;">
			<div class="col-md-6 profile-info">
				<div class="col-md-12 main-grid3">
					<div class="p-20">
						<div class="about-info-p">
							<strong>Full Name: </strong> <br>
							<p class="text-muted">${doctor.getName()}</p>
						</div>
						<div class="about-info-p">
							<strong>Qualification: </strong> <br>
							<p class="text-muted">${doctor.getQualification()}</p>
							</p>

						</div>
						<div class="about-info-p m-b-0">
							<strong>Organization: </strong> <br>
							<p class="text-muted">${doctor.getOrganization()}</p>
						</div>
						<div class="about-info-p m-b-0">
							<strong>Chamber: </strong> <br>
							<p class="text-muted">${doctor.getChamber()}</p>
						</div>


					</div>
				</div>
			</div>
		</div>


		<div class="col-md-6 profile-info two" style="text-align: center;">
			<div class="main-grid3 p-skill">
				<div class="about-info-p m-b-0">
					<strong>Location: </strong> <br>
					<p class="text-muted">${doctor.getLocation()}</p>
				</div>
				<div class="about-info-p m-b-0">
					<strong>Visiting Hours: </strong> <br>
					<p class="text-muted">${doctor.getVisitinghours()}</p>
				</div>
				<div class="about-info-p m-b-0">
					<strong>Phone: </strong> <br>
					<p class="text-muted">${doctor.getPhone()}</p>
				</div>
				<div class="about-info-p m-b-0">
					<strong>Email: </strong> <br>
					<p class="text-muted">${doctor.getEmail()}</p>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
		<div style="text-align: center;">
			<input type="submit" value="Take Appointment">
		</div>
	</form>
	</div>
</div>