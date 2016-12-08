<%@page import="com.obigo.obigoproject.vo.UserVehicleVO"%>
<%@page import="com.obigo.obigoproject.vo.VehicleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Vehicle</title>
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--main content start-->
	<section id="main-content">
		<!--widget start-->
		<!-- page start-->
		<c:forEach var="v" items="${vehicleList}" varStatus="status">
			<div class="col-lg-4" style="width: 400px; margin-top: 120px;">
				<aside class="profile-nav alt green-border">
					<section class="panel">
						<div class="user-heading alt green-bg">
							<a href="#"> <img alt="" src="c:/obigo/vehicle/image/2011-Hyundai-Avante-3.jpg">
							</a>
							<h1>${v.modelName}</h1>
						</div>

						<ul class="nav nav-pills nav-stacked">
							<li><a href="javascript:;">Color<span class="label label-primary pull-right r-activity">${userVehicleList[status.index].color}</span></a></li>
							<li><a href="javascript:;">Model Code<span class="label label-info pull-right r-activity">${v.modelCode}</span></a></li>
							<li><a href="javascript:;">Model Year<span class="label label-warning pull-right r-activity">${v.modelYear}</span></a></li>
							<li><a href="javascript:;">Location<span class="label label-success pull-right r-activity">${userVehicleList[status.index].location}</span></a></li>
							<li><a href="javascript:;">Vin<span class="label label-success pull-right r-activity">${userVehicleList[status.index].vin}</span></a></li>
						<li><a href="javascript:;">Mileage<span class="label label-success pull-right r-activity">${v.mileage}</span></a></li> 
						</ul>

					</section>
				</aside>
			</div>
		</c:forEach>
		<!--widget end-->
	</section>
	<!--main content end-->
	<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/obigoProject/js/jquery.sparkline.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="/obigoProject/js/owl.carousel.js"></script>
	<script src="/obigoProject/js/jquery.customSelect.min.js"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="/obigoProject/js/sparkline-chart.js"></script>
	<script src="/obigoProject/js/easy-pie-chart.js"></script>
	<script src="/obigoProject/js/count.js"></script>
</body>
</html>