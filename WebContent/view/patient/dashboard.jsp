<%
	if(!session.getAttribute("role").equals("patient")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>

<jsp:include page="_header.jsp"></jsp:include>
<div class="outter-wp">
	<div class="tab-main">
		<!--/tabs-inner-->
		<div class="tab-inner">
			<div id="tabs" class="tabs">
				<div class="graph">
					<nav>
						<ul>
							<li><a href="#section-1" class="icon-shop"><i
									class="lnr lnr-briefcase"></i> <span>Appointment Details</span></a></li>
							

						</ul>
					</nav>
					<div class="content tab">
						<section id="section-1">
							<div class="main-grid3">
								<div class="p-20">
									<div class="about-info-p">
										<strong>Doctor's Name: </strong> <br>
										<p class="text-muted">${doctor.getName()}</p>
									</div>
									<div class="about-info-p">
										<strong>Chamber: </strong> <br>
										<p class="text-muted">
											<a href="mailto:info@example.com">${doctor.getChamber()}</a>
										</p>
									</div>
									<div class="about-info-p m-b-0">
										<strong>Date: </strong> <br>
										<p class="text-muted">${doctor.getLocation()}</p>
									</div>
									<div class="about-info-p m-b-0">
										<strong>Date: </strong> <br>
										<p class="text-muted">${appoint.getDate()}</p>
									</div>
									<div class="about-info-p m-b-0">
										<strong>Time: </strong> <br>
										<p class="text-muted">${doctor.getVisitinghours()}</p>
									</div>
									<div class="about-info-p m-b-0">
										<strong>Prescription Id: </strong> <br>
										<p class="text-muted">${appoint.getPrescriptionId()}</p>
									</div>
								</div>
							</div>

						</section>
						<section id="section-2"></section>
					</div>
					<!-- /content -->
				</div>
				<!-- /tabs -->

			</div>
			<script
				src="${pageContext.request.contextPath}/resource/js/cbpFWTabs.js"></script>
			<script>
				new CBPFWTabs(document.getElementById('tabs'));
			</script>

		</div>
	</div>
	<!--//tabs-inner-->
</div>
<!--//tabs-->
</div>
<jsp:include page="_footer.jsp"></jsp:include>