<%
	if(!session.getAttribute("role").equals("admin")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>
<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<div class="login">
				<h3 class="inner-tittle t-inner">Change Password</h3>
				<form action="${pageContext.request.contextPath}/adminchangepass" method="post">
					<input type="password" name="opass" placeholder="Enter old password" onfocus="this.value = '';"onblur="if (this.value == '') {this.value = 'Enter old password';}">
					<input type="password" name="npass"  placeholder="Enter new password" onfocus="this.value = '';"onblur="if (this.value == '') {this.value = 'Password';}">
					<div class="submit"> <input type="submit" onclick="myFunction()" value="Save"></div>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="_footer.jsp"></jsp:include>