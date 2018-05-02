<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Dashboard :: Admin</title>

<%
	if(!session.getAttribute("role").equals("admin")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>

<jsp:include page="_header.jsp"></jsp:include>
<div class="bottom-grids" style="padding: 40px;">
	<div class="dev-table">
		<div class="col-md-6 dev-col" style="padding: 50px;">
			<div class="dev-widget dev-widget-transparent"
				style="height: 100px; text-align: center;">
				<h2 class="inner one">Profile</h2>
				<a href="adminview" class="dev-drop">View Details<span
					class="fa fa-angle-right pull-right"></span></a>
			</div>
		</div>
		<div class="col-md-6 dev-col mid" style="padding: 50px;">
			<div class="dev-widget dev-widget-transparent"
				style="height: 100px; text-align: center;">
				<h2 class="inner">Patient</h2>
				<a href="patientdashboard" class="dev-drop">View Details<span
					class="fa fa-angle-right pull-right"></span></a>
			</div>
		</div>
		<div class="col-md-6 dev-col" style="padding: 50px;">
			<div class="dev-widget dev-widget-transparent"
				style="height: 100px; text-align: center;">
				<h2 class="inner">Doctor</h2>
				<a href="${pageContext.request.contextPath}/doctordashboard" class="dev-drop">View Details<span
					class="fa fa-angle-right pull-right"></span></a>
			</div>
		</div>
		<div class="col-md-6 dev-col" style="padding: 50px;">
			<div class="dev-widget dev-widget-transparent"
				style="height: 100px; text-align: center;">
				<h2 class="inner">Pharmacy</h2>
				<a href="pharmacydashboard" class="dev-drop">View Details<span
					class="fa fa-angle-right pull-right"></span></a>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>