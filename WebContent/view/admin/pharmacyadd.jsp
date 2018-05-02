<%
	if(!session.getAttribute("role").equals("admin")){
	response.sendRedirect(request.getContextPath()+"/view/common/login.jsp");
}
%>
<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<div class="register">
				<h3 class="inner-tittle t-inner">Register</h3>
				<form action="${pageContext.request.contextPath}/pharmacyadd" method="post" enctype="multipart/form-data">
					
					Select profile picture<input type="file" name="image" style="padding:12px; width:100%; background-color: #00C6D7">
					<input type="text" name="pharmacyname" class="text" value="Pharmacy Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Pharmacy Name';}">
					<input type="text" name="ownerofpharmacy" class="text" value="Owner of pharmacy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Owner of pharmacy';}">
					<input type="text" name="address" class="text" value="Address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Address';}">
					<input type="text" name="email" class="text" value="E-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';}">
					<input type="text" name="phone" class="text" value="Mobile" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Mobile number';}">
					
					<div class="sign-up">
						<input type="submit" onclick="myFunction()" value="Add Pharmacy Account">
					</div>
					<div class="clearfix"></div>
					<div class="new">
						<p class="sign">Already register?<a href="${pageContext.request.contextPath}/view/common/login.jsp">Login</a></p>
						<div class="clearfix"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
<jsp:include page="_footer.jsp"></jsp:include>	