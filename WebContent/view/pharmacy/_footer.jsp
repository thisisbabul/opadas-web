<!--//outer-wp-->
<!--footer section start-->
<footer>
	<p>
		&copy 2018 OPADAS . All Rights Reserved | Developed by <a
			href="http://babul.sellzila.com" target="_blank">Babul Miah</a>
	</p>
</footer>
<!--footer section end-->
</div>

<!--//content-inner-->
<!--/sidebar-menu-->
<div class="sidebar-menu">
	<header class="logo">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a> <a href="${pageContext.request.contextPath}/pharmacyhome"> <span id="logo">
				<h1>OPADAS</h1>
		</span> <!--<img id="logo" src="" alt="Logo"/>-->
		</a>
	</header>
	<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
	<!--/down-->
	<div class="down">
		<a href="${pageContext.request.contextPath}/pharmacyprofile"><img src="pharmacygetimage?id=${pharmacy.getId()}" width="100px" height="100px"></a>
		<a href="${pageContext.request.contextPath}/pharmacyprofile"><span class=" name-caret">${pharmacy.getOwnerOfPharmacy()}</span></a>
		<ul>
			<li><a class="tooltips" href="${pageContext.request.contextPath}/pharmacyprofile"><span>Profile</span><i
					class="lnr lnr-user"></i></a></li>
			<li><a class="tooltips" href="${pageContext.request.contextPath}/logout"><span>Log
						out</span><i class="lnr lnr-power-switch"></i></a></li>
		</ul>
	</div>
	<!--//down-->
	<div class="menu">
		<ul id="menu">
			<li><a href="${pageContext.request.contextPath}/pharmacyhome"><i class="fa fa-tachometer"></i> <span>Dashboard</span></a></li>
			<li><a href="${pageContext.request.contextPath}/pharmacyprofile"><i class="lnr lnr-user"></i>	<span>Profile</span></a></li>
			<li><a href="${pageContext.request.contextPath}/pharmacychangepass"><i class="lnr lnr-cog"></i>	<span>Change Password</span></a></li>
			<li><a href="pharmacyhome"><i class="fa fa-smile-o"></i> <span>Search Prescription</span></a></li>
			<li><a href="${pageContext.request.contextPath}/logout"><i class="lnr lnr-power-switch"></i> <span>Log out</span></a></li>
		</ul>
	</div>
</div>
<div class="clearfix"></div>
</div>
</div>
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
<script
	src="${pageContext.request.contextPath}/resource/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/script.js"></script>
<!-- Bootstrap Core JavaScript -->
<script
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
</body>
</html>