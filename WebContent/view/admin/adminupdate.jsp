<%
	if(!session.getAttribute("role").equals("admin")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>
<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<div class="register">
				<h3 class="inner-tittle t-inner">Update Personal Information</h3>
				<form action="${pageContext.request.contextPath}/adminupdate" method="post">
					<input hidden="id" name="id" value="${admin.getId()}">
					<input type="text" name="name" class="text" value="${admin.getName()}"}">
					<input type="text" name="designation" class="text" value="${admin.getDesignation()}">
					<input type="text" name="email" class="text" value="${admin.getEmail()}">
					<input type="text" name="phone" class="text" value="${admin.getPhone()}">
					<select name="status" style="padding:12px; width:100%;">
						<option value="">Select Status...</option>
						<option selected="selected" value="${admin.getStatus()}">${admin.getStatus()}</option>
						<option value="Active">Active</option>
						<option value="Inactive">Inactive</option>
					</select>
					
					<div class="sign-up">
						<input type="submit" onclick="myFunction()" value="Save">
					</div>
					<div class="clearfix"></div>
					
				</form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
<jsp:include page="_footer.jsp"></jsp:include>	