<jsp:include page="_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<h2 class="inner-tittle page">OPADAS</h2>
			<div class="register">
				<h3 class="inner-tittle t-inner">Register</h3>
				<form action="${pageContext.request.contextPath}/patientinsert" method="post" enctype="multipart/form-data">
					<input type="hidden" name="doctorId" value="${doctorId}">
					Select profile picture<input type="file" name="image" style="padding:12px; width:100%; background-color: #00C6D7">
					<input type="text" name="name" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
					<input type="text" name="address" class="text" value="Address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Address';}">
					<input type="text" name="mobile" class="text" value="Mobile" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobile';}">
					<input type="text" name="email" class="text" value="E-mail" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail';}">

					<div class="sign-up">
						<input type="submit" onclick="myFunction()" value="Process Appointment">
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
<jsp:include page="_footer.jsp"></jsp:include>	