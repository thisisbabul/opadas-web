<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<div class="login">
				<h3 class="inner-tittle t-inner">Update Personal Information</h3>
				<form action="${pageContext.request.contextPath}/adminupdate" method="post">
					
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
						<input type="submit" onclick="myFunction()" value="Register">
					</div>
					<div class="clearfix"></div>
					
				</form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
<jsp:include page="_footer.jsp"></jsp:include>	