<jsp:include page="/view/common/_header.jsp"></jsp:include>
	<div class="error_page">
		<div class="error-top">
			<h2 class="inner-tittle page">OPADAS</h2>
			<div class="login">
				<h3 class="inner-tittle t-inner">Register</h3>
				<form action="${pageContext.request.contextPath}/patientinsert" method="post">
					<input type="hidden" name="doctorId" value="${doctorId}">
					<input type="text" name="name" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your full name';}">
					<input type="text" name="address" class="text" value="Address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Address';}">
					<input type="text" name="mobile" class="text" value="Mobile" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Mobile number';}">
					<input type="text" name="email" class="text" value="E-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';}">

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
<jsp:include page="/view/common/_footer.jsp"></jsp:include>	