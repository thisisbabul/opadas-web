<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Online prescription & Doctor appointment system</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Online prescription & Doctor appointment system" />
<script type="application/x-javascript">addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }</script>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/resource/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.countdown.css" />
<link href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.11.1.min.js"></script>
<script	src="${pageContext.request.contextPath}/resource/js/jquery.easydropdown.js"></script>
<link href="${pageContext.request.contextPath}/resource/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script	src="${pageContext.request.contextPath}/resource/js/responsiveslides.min.js"></script>
<script	src="${pageContext.request.contextPath}/resource/js/jquery.countdown.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/script.js"></script>
<script>
function changeFunc() {
    var selectBox = document.getElementById("selectBox");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    window.location.replace("${pageContext.request.contextPath}/doctorsearch?expertise="+selectedValue);
   }
</script>

</head>
<body>
	<div class="header_top">
		<div class="container">
			<div class="header_top-box">
				<div class="header-top-left">
					<div class="clearfix"></div>
				</div>
				<marquee style="color: white;">Doctor finder in Bangladesh</marquee>
			</div>
		</div>
	</div>
	<div class="header_bottom">
		<div class="container">
			<div class="header_bottom-box">
				<div class="header_bottom_left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/resource/images/logo.jpg" alt="" /></a>
					</div>
					<form  action="${pageContext.request.contextPath}/search" method="post">	
						<ul class="clock search" style="margin-top: -1px;">
								<select style="padding: 12px; width: 250px;" id="selectBox" onchange="changeFunc();">
									<option value="">Select Doctor's Expertise...</option>
									<option value="Anesthesiology">Anesthesiology</option>
									<option value="Breast Surgeon">Breast Surgeon</option>
									<option value="Burn & Plastic Surgeon">Burn & Plastic Surgeon</option>
									<option value="Cancer - Oncology">Cancer - Oncology</option>
									<option value="Cardiac Surgeon">Cardiac Surgeon</option>
									<option value="Cardiology">Cardiology</option>
									<option value="Cardiovascular & Thoracic Surgeon">Cardiovascular & Thoracic Surgeon</option>
									<option value="Chest Surgeon">Chest Surgeon</option>
									<option value="Chest, Asthma & Medicine ">Chest, Asthma & Medicine </option>
									<option value="Child - Pediatric">Child - Pediatric</option>
									<option value="Child Neurology ">Child Neurology </option>
									<option value="Child Psycology & Nutrition ">Child Psycology & Nutrition </option>
									<option value="Clinical & Interventional Cardiology ">Clinical & Interventional Cardiology </option>
									<option value="Clinical Hematology ">Clinical Hematology </option>
									<option value="Clinical Oncology">Clinical Oncology</option>
									<option value="Colorectal & Laparoscopy Surgeon ">Colorectal & Laparoscopy Surgeon </option>
									<option value="Cosmetic & Plastic Surgeon">Cosmetic & Plastic Surgeon</option>
									<option value="Critical Care Medicine">Critical Care Medicine</option>
									<option value="Dental & Maxillofacial Surgeon">Dental & Maxillofacial Surgeon</option>
									<option value="Dentist ">Dentist </option>
									<option value="Dermatology">Dermatology</option>
									<option value="Dermatology & Venerology ">Dermatology & Venerology </option>
									<option value="Diabetes">Diabetes</option>
									<option value="Diabetes & Endocrine">Diabetes & Endocrine</option>
									<option value="Diabetic Foot & General Surgeon">Diabetic Foot & General Surgeon</option>
									<option value="Endoscopic Surgeon ">Endoscopic Surgeon </option>
									<option value="ENT - Ear, Nose & Throat  ">ENT - Ear, Nose & Throat  </option>
									<option value="ENT - Head & Neck Surgeon">ENT - Head & Neck Surgeon</option>
									<option value="Eye ( Ophthalmology )">Eye ( Ophthalmology )</option>
									<option value="Eye Surgeon">Eye Surgeon</option>
									<option value="Eye Surgeon - Contact Lens & Phaco">Eye Surgeon - Contact Lens & Phaco</option>
									<option value="Family Medicine & Sleep Medicine">Family Medicine & Sleep Medicine</option>
									<option value="Gastro Intestinal, Liver & Pancreatic Disorder">Gastro Intestinal, Liver & Pancreatic Disorder</option>
									<option value="Gastroenterology">Gastroenterology</option>
									<option value="Gastroenterology & Hepatology">Gastroenterology & Hepatology</option>
									<option value="General & Laparoscopic Surgeon">General & Laparoscopic Surgeon</option>
									<option value="General & Plastic Surgeon">General & Plastic Surgeon</option>
									<option value="General Surgeon">General Surgeon</option>
									<option value="General, Laparoscopic & Colorectal Surgeon">General, Laparoscopic & Colorectal Surgeon</option>
									<option value="General, Urology & Laparoscopic Surgeon">General, Urology & Laparoscopic Surgeon</option>
									<option value="Gynecological Oncology">Gynecological Oncology</option>
									<option value="Gynecology & Obstetrics">Gynecology & Obstetrics</option>
									<option value="Hematology">Hematology</option>
									<option value="Hemodialysis - Kidney ">Hemodialysis - Kidney </option>
									<option value="Hepatobiliary & Pancreatic Surgeon">Hepatobiliary & Pancreatic Surgeon</option>
									<option value="Hepatology ">Hepatology </option>
									<option value="Hormone & Diabetes">Hormone & Diabetes</option>
									<option value="ICU - Critical Care">ICU - Critical Care</option>
									<option value="Immunology">Immunology</option>
									<option value="Infertility ">Infertility </option>
									<option value="Internal Medicine ">Internal Medicine </option>
									<option value="Internal Medicine & Pulmonology">Internal Medicine & Pulmonology</option>
									<option value="IVF & Embryology">IVF & Embryology</option>
									<option value="Kidney & Medicine">Kidney & Medicine</option>
									<option value="Kidney ( Nephrology ) ">Kidney ( Nephrology ) </option>
									<option value="Kidney Pediatric ">Kidney Pediatric </option>
									<option value="Laparoscopic, Colorectal & Piles Surgeon">Laparoscopic, Colorectal & Piles Surgeon</option>
									<option value="Laser Surgeon">Laser Surgeon</option>
									<option value="Lithotripsy">Lithotripsy</option>
									<option value="Liver ">Liver </option>
									<option value="Liver & Gastroenterology">Liver & Gastroenterology</option>
									<option value="Liver & Medicine ">Liver & Medicine </option>
									<option value="Medcine & Pulmonology ">Medcine & Pulmonology </option>
									<option value="Medicine">Medicine</option>
									<option value="Medicine & Cardiology">Medicine & Cardiology</option>
									<option value="Medicine & Child Health">Medicine & Child Health</option>
									<option value="Medicine & Diabetes">Medicine & Diabetes</option>
									<option value="Medicine & Endocrinology">Medicine & Endocrinology</option>
									<option value="Medicine & Gastroenterology">Medicine & Gastroenterology</option>
									<option value="Medicine & Kidney">Medicine & Kidney</option>
									<option value="Medicine & liver ">Medicine & liver </option>
									<option value="Medicine & Nephrology ">Medicine & Nephrology </option>
									<option value="Medicine & Rheumatology">Medicine & Rheumatology</option>
									<option value="Medicine & Surgery ">Medicine & Surgery </option>
									<option value="Medicine, Diabetes & Cardilogy ">Medicine, Diabetes & Cardilogy </option>
									<option value="Medicine, Hormone & Diabetology">Medicine, Hormone & Diabetology</option>
									<option value="Mediicne & Hematology ">Mediicne & Hematology </option>
									<option value="Neonatal & Child Health">Neonatal & Child Health</option>
									<option value="Nephrology ( Kidney )">Nephrology ( Kidney )</option>
									<option value="Neuromedicine">Neuromedicine</option>
									<option value="Neurosurgeon">Neurosurgeon</option>
									<option value="Neurosurgeon - Brain & Spine">Neurosurgeon - Brain & Spine</option>
									<option value="Nuclear Medicine">Nuclear Medicine</option>
									<option value="Oral & Dental Surgeon">Oral & Dental Surgeon</option>
									<option value="Oral & Maxillofacial Surgeon ">Oral & Maxillofacial Surgeon </option>
									<option value="Orthopaedic">Orthopaedic</option>
									<option value="Orthopaedic Surgeon">Orthopaedic Surgeon</option>
									<option value="Orthopaedic, Spine & Trauma Surgeon">Orthopaedic, Spine & TraumaSurgeon</option>
									<option value="Pain Specialist">Pain Specialist</option>
									<option value="Pathology & Laboratory">Pathology & Laboratory</option>
									<option value="Pathology and Laboratory Services">Pathology and Laboratory Services</option>
									<option value="Pediatric - Medicine, Hematology, Oncology">Pediatric - Medicine, Hematology, Oncology</option>
									<option value="Pediatric Cardiac Surgeon">Pediatric Cardiac Surgeon</option>
									<option value="Pediatric Laparoscopic Surgeon">Pediatric Laparoscopic Surgeon</option>
									<option value="Pediatric Neonatology">Pediatric Neonatology</option>
									<option value="Pediatric Nephrologist">Pediatric Nephrologist</option>
									<option value="Pediatric Neurologist">Pediatric Neurologist</option>
									<option value="Pediatric Neurosurgeon ">Pediatric Neurosurgeon </option>
									<option value="Pediatric Orthopedic Surgeon">Pediatric Orthopedic Surgeon</option>
									<option value="Pediatric Pulmonology">Pediatric Pulmonology</option>
									<option value="Pediatric Surgeon">Pediatric Surgeon</option>
									<option value="Pediatric, Urologist & Laparoscopic Surgeon">Pediatric, Urologist & Laparoscopic Surgeon</option>
									<option value="Physical Medicine">Physical Medicine</option>
									<option value="Physical Medicine & Rehabilitation ">Physical Medicine & Rehabilitation </option>
									<option value="Physiotherapy">Physiotherapy</option>
									<option value="Plastic & Cosmetic Surgeon">Plastic & Cosmetic Surgeon</option>
									<option value="Plastic Surgeon">Plastic Surgeon</option>
									<option value="Psychiatry ">Psychiatry </option>
									<option value="Psychotherapy">Psychotherapy</option>
									<option value="Radiology ">Radiology </option>
									<option value="Radiology & Imaging ">Radiology & Imaging </option>
									<option value="Respiratory Medicine ">Respiratory Medicine </option>
									<option value="Rheumatology ">Rheumatology </option>
									<option value="Skin & VD ( Dermatology ) ">Skin & VD ( Dermatology ) </option>
									<option value="Skin &VD & Proctor">Skin &VD & Proctor</option>
									<option value="Skin and Venereal ">Skin and Venereal </option>
									<option value="Sleep & Respiratory Medicine">Sleep & Respiratory Medicine</option>
									<option value="Sonology">Sonology</option>
									<option value="Sonology & Radiology">Sonology & Radiology</option>
									<option value="Surgical Oncology ">Surgical Oncology </option>
									<option value="Thoracic & Esophageal Surgeon">Thoracic & Esophageal Surgeon</option>
									<option value="Thoracic Surgeon ">Thoracic Surgeon </option>
									<option value="Thyroid ">Thyroid </option>
									<option value="Urology">Urology</option>
									<option value="Urology & Andrology">Urology & Andrology</option>
									<option value="Urology - Renal Transplantation Surgeon">Urology - Renal Transplantation Surgeon</option>
									<option value="Urology and Laparoscopic Surgeon">Urology and Laparoscopic Surgeon</option>
									<option value="Vascular Surgeon">Vascular Surgeon</option>
									<option value="Virology ">Virology </option>
									<option value="Vitreo-Retinal Sergeon">Vitreo-Retinal Sergeon</option>
								
							</select>
						</ul>
					</form>	
					<div class="clearfix"></div>
				</div>

				<div class="header_bottom_right">
					<form id="" action="${pageContext.request.contextPath}/doctorsearch" method="post">
						<div class="search">
							<input type="text" name="search" value="Search Doctor" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Doctor';}"><input type="submit" value="">
						</div>
					</form>
					<ul class="bag">
						<a href="${pageContext.request.contextPath}/view/common/login.jsp"> <li class="bag_right"><p>Login</p></li></a>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="sellers_grid">
		<ul class="sellers">
			<i class="star"> </i>
			<li class="sellers_desc"><h2>Popular Doctors</h2></li>
			<div class="clearfix"></div>
		</ul>
	</div>
	<c:forEach var="doctor" items="${doctorList}">
		<div class="col-md-3 span_6">
			<div class="box_inner">
				<a href="${pageContext.request.contextPath}/doctor?id=<c:out value="${doctor.id}"></c:out>"><img src="doctorgetimage?id=<c:out value="${doctor.id}"></c:out>" class="img-responsive" alt="" width=300px height=300px/></a>
				<div class="desc">
					<h3>
						<c:out value="${doctor.name}"></c:out>
					</h3>
					<h4>
						<c:out value="${doctor.expertise}"></c:out>
					</h4>
						<ul class="list2">
							<li class="list2_left"><span class="m_1"><a href="${pageContext.request.contextPath}/appointment?id=<c:out value="${doctor.id}"></c:out>" class="link">Take Appoint</a></span></li>
							<li class="list2_right"><span class="m_2"><a href="${pageContext.request.contextPath}/doctor?id=<c:out value="${doctor.id}"></c:out>" class="link1">See More</a></span></li>
							<div class="clearfix"></div>
						</ul>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="clearfix"></div>
	<div class="footer">
		<div class="container">
			<img src="${pageContext.request.contextPath}/resource/images/pay.png" class="img-responsive" alt="" />
			<p style="color: white;"> &copy 2018 OPADAS . All Rights Reserved | Developed by <a	href="http://babul.sellzila.com" target="_blank">Babul Miah</a></p>
		</div>
	</div>
</body>
</html>


