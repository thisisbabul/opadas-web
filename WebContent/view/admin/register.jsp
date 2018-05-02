<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<div class="login">
				<h3 class="inner-tittle t-inner">Register</h3>
				<form action="${pageContext.request.contextPath}/admininsert" method="post" enctype="multipart/form-data">
					
					Select a profile picture<input type="file" name="image" style="padding:12px; width:100%; background-color: #00C6D7">				
					<input type="text" name="name" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your full name';}">
					<input type="text" name="designation" class="text" value="Designation" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Designation';}">
					<input type="text" name="email" class="text" value="E-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';}">
					<input type="text" name="phone" class="text" value="Mobile" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Mobile number';}">
					<select name="status" style="padding:12px; width:100%;">
						<option value="">Select Status...</option>
						<option value="active">Active</option>
						<option value="inactive">Inactive</option>
					</select>
					
					
					
					<div class="sign-up">
						<input type="submit" onclick="myFunction()" value="Register">
					</div>
					<div class="clearfix"></div>
					<div class="new">
						<p><label class="checkbox11"><input type="checkbox"	name="checkbox"><i> </i>I agree with the terms</label></p>	
						<p class="sign">Already register?<a href="${pageContext.request.contextPath}/view/common/login.jsp">Login</a></p>
						<div class="clearfix"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
<jsp:include page="_footer.jsp"></jsp:include>	