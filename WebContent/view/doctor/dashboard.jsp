<%
	if(!session.getAttribute("role").equals("doctor")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
									class="lnr lnr-briefcase"></i> <span>Patient Queue</span></a></li>
						</ul>
					</nav>
					<div class="content tab">
						<section id="section-1">
							<c:forEach var="appoint" items="${appointList}">
								<form action="prescription">
								<input type="hidden" name="pid" value="${appoint.patient.id}">
								<input type="hidden" name="aid" value="${appoint.id}">
									<div class="form-group">
										<div class="row">
											<div class="col-md-12 grid_box1" style="margin-top: 15px;">
												<div class="ribbon-inner">
														<div class="ribbon left_ribbon">
															<h3><c:out value="${appoint.patient.name}"></c:out></h3>
														</div>
													<div class="ribbon both_ribbon">
														<h3>
															Prescription Id: <c:out value="${appoint.prescriptionId}"></c:out>
														</h3>
													</div><input type="submit" value="Ok">
												</div>
											</div>
										</div>
									</div>
								</form>
							</c:forEach>
						</section>
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