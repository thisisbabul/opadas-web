<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<h2 class="inner-tittle page">OPADAS</h2>
			<div class="login">
				<h3 class="inner-tittle t-inner">Login</h3>
				<form action="${pageContext.request.contextPath}/login" method="post">
					<input type="text" name="email" class="text" value="E-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';}">
					<input type="password" name="password" value="Password" onfocus="this.value = '';"onblur="if (this.value == '') {this.value = 'Password';}">
					<select name="role" style="padding:12px; width:100%;">
						<option value="">Select Role...</option>
						<option value="admin">Admin</option>
						<option value="patient">Patient</option>
						<option value="doctor">Doctor</option>
						<option value="pharmacy">Pharmacy</option>
					</select>
					<div class="submit"> <input type="submit" onclick="myFunction()" value="Login"></div>
					<div class="clearfix"></div>
					<div class="new">
						<p><label class="checkbox11"><input type="checkbox" name="checkbox"><i> </i>Remember Password ?</label></p>
						<div class="clearfix"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="_footer.jsp"></jsp:include>