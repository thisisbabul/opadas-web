<!--footer section start-->
<footer>
	<p>
		&copy 2018 OPADAS . All Rights Reserved | Developed by <a
			href="http://babul.sellzila.com" target="_blank">Babul Miah</a>
	</p>
</footer>
<!--//footer section end-->

</div>
</div>

<!--//content-inner-->
<!--/sidebar-menu-->
<div class="sidebar-menu">
	<header class="logo">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a> <a href="${pageContext.request.contextPath}/admindashboard"> <span id="logo">
				<h1>OPADAS</h1>
		</span> <!--<img id="logo" src="" alt="Logo"/>-->
		</a>
	</header>
	<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
	<!--/down-->
	<div class="down">
		<a href="${pageContext.request.contextPath}/adminview"><img src="admingetimage?id=${admin.getId()}" width="100px" height="100px"></a>
		<a href="${pageContext.request.contextPath}/adminview"><span class=" name-caret">${admin.getName()}</span></a>
		<p>${admin.getDesignation()}</p>
		<ul>
			<li><a class="tooltips" href="${pageContext.request.contextPath}/adminview"><span>Profile</span><i
					class="lnr lnr-user"></i></a></li>
			<li><a class="tooltips" href="${pageContext.request.contextPath}/logout"><span>Log out</span><i class="lnr lnr-power-switch"></i></a></li>
		</ul>
	</div>
	<!--//down-->
	<div class="menu">
		<ul id="menu">
			<li><a href="${pageContext.request.contextPath}/admindashboard"><i class="fa fa-tachometer"></i> <span>Dashboard</span></a></li>
			<li><a href="${pageContext.request.contextPath}/adminview"><i class="lnr lnr-user"></i>	<span>Profile</span></a></li>
			<li><a href="${pageContext.request.contextPath}/adminchangepass"><i class="lnr lnr-cog"></i>	<span>Change Password</span></a></li>
			<li><a href="${pageContext.request.contextPath}/admininsert"><i class="fa fa-pencil-square-o"></i> <span>Create New Admin</span></a></li>
			<li><a href="${pageContext.request.contextPath}/patientdashboard"><i class="fa fa-table"></i>	<span>Patient</span></a></li>
			<li id="menu-academico"><a href="${pageContext.request.contextPath}/doctordashboard"><i class="fa fa-file-text-o"></i> <span>Doctor</span></a></li>
			<li><a href="${pageContext.request.contextPath}/pharmacydashboard"><i class="lnr lnr-pencil"></i><span>Pharmacy</span></a></li>
			<li><a href="${pageContext.request.contextPath}/logout"><i class="lnr lnr-power-switch"></i> <span>Log out</span></a></li>
		</ul>
	</div>
</div>
<div class="clearfix"></div>
</div>
<script>
	var toggle = true;

	$(".sidebar-icon").click(
			function() {
				if (toggle) {
					$(".page-container").addClass("sidebar-collapsed")
							.removeClass("sidebar-collapsed-back");
					$("#menu span").css({
						"position" : "absolute"
					});
				} else {
					$(".page-container").removeClass("sidebar-collapsed")
							.addClass("sidebar-collapsed-back");
					setTimeout(function() {
						$("#menu span").css({
							"position" : "relative"
						});
					}, 400);
				}

				toggle = !toggle;
			});
</script>
<!--js -->
<script src="${pageContext.request.contextPath}/resource/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
</body>
</html>