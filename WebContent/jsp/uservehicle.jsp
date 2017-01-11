<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="com.obigo.obigoproject.vo.UserVehicleVO"%>
<%@page import="com.obigo.obigoproject.vo.VehicleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>User Vehicle</title>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<!--main content start-->
	<section style="position: absolute;" id="main-content">
		<!-- page start-->
		<div class="row state-overview" style="margin-left: 20px; margin-top: 70px">
			<div class="col-lg-5 col-sm-6">
				<section class="panel">
					<div class="symbol terques">
						<i class="fa fa-user"></i>
					</div>
					<div class="value">
						<p>User ID</p>
						<h1 style="font-weight: bold; color: grey;">${param.userId}</h1>
					</div>
				</section>


				<div class="btn-group">
					<a style="border-color: #6CCAC9; background-color: #6CCAC9;" id="Add" class="btn btn-success" data-toggle="modal" href="/obigoProject/usermanagement"> Back <i class="fa fa-arrow-circle-left"></i></a>
				</div>
				<div class="btn-group">
					<a style="border-color: #6CCAC9; background-color: #6CCAC9;" id="Add" class="btn btn-success" data-toggle="modal" href="#addModal"> Add Vehicle <i class="fa fa-plus"></i></a>
				</div>

				<!-- -------------- Add User Vehicle Modal start -------------- -->
				<div class="modal fade " id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title">Add User Vehicle</h4>
							</div>
							<div class="modal-body">
								<form id="form-uservehicle" class="form-signin" action="/obigoProject/insertuservehicle" onsubmit="return checkVIN()" method="POST">
									<div class="login-wrap">
										<div class="form-group">
											<span class="label label-primary">User ID</span>
											<input type="text" name="userId" id="userId" value="${param.userId}" class="form-control" placeholder="User ID" required="required" readonly="readonly">
										</div>
										<div class="form-group">
											<span class="label label-primary">Model Name</span>
											<br> <select name="modelCode" required="required">
												<option value="">Choose your model...</option>
												<c:forEach var="vml" items="${vehicleModelList}" begin="0">
													<option value="${vml.modelCode}">${vml.modelName}</option>
												</c:forEach>
											</select>
											<!-- 											<input type="text" name="modelCode" class="form-control" placeholder="Model Code" required="required"> -->
										</div>
										<div class="form-group">
											<span class="label label-primary">Color</span><br> 
											<select name="color" required="required">
												<option value="">Choose your color....</option>
												<option value="Red">Red</option>
												<option value="Blue">Blue</option>
												<option value="Black">Black</option>
												<option value="White">White</option>
											</select>
										</div>
										<div class="form-group">
											<span class="label label-primary">Location</span><br> 
											<select name="location" required="required">
												<option value="">Choose your location....</option>
												<option value="서울">서울</option>
												<option value="경기">경기</option>
												<option value="강원">강원</option>
												<option value="충남">충남</option>
												<option value="충북">충북</option>
												<option value="경남">경남</option>
												<option value="경북">경북</option>
												<option value="전남">전남</option>
												<option value="전북">전북</option>
												<option value="인천">인천</option>
												<option value="대전">대전</option>
												<option value="대구">대구</option>
												<option value="부산">부산</option>
												<option value="제주">제주</option>
											</select>
										</div>
										<div class="form-group">
											<span class="label label-primary">VIN</span>
											<input type="text" name="vin" id="vin" class="form-control" placeholder="VIN" required="required">
										</div>
										<input type="hidden" name="activeDtcCount" class="form-control" value="0">
										<input type="hidden" name="userVehicleNumber" class="form-control" value="0">
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
								<input class="btn btn-success" type="submit" form="form-uservehicle" value="Registration">
							</div>
						</div>
					</div>
				</div>
				<!-- -------------- Add User Vehicle Modal end -------------- -->
			</div>
		</div>
		<div style="width: 800px;"></div>
		<section style="margin-left: 20px;" class="wrapper">
			<br>
			<div class="row">
				<!-- ------- 특정 User ID에 등록된 User Vehicle List start ------- -->
				<c:forEach var="v" items="${vehicleList}" varStatus="status">
					<div class="col-lg-4" style="width: 400px; margin-top: -70px; margin-bottom: 70px;">
						<aside class="profile-nav alt green-border">
							<section class="panel">
								<div class="user-heading alt green-bg">
									<a href="#"> <img alt="" src="/obigoProject/vehicleImage?modelImage=${v.modelImage}">
									</a>
									<h1>${v.modelName}</h1>
								</div>
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="javascript:;">Color<span class="label label-primary pull-right r-activity">${userVehicleList[status.index].color}</span></a>
									</li>
									<li>
										<a href="javascript:;">Model Code<span class="label label-info pull-right r-activity">${v.modelCode}</span></a>
									</li>
									<li>
										<a href="javascript:;">Model Year<span class="label label-warning pull-right r-activity">${v.modelYear}</span></a>
									</li>
									<li>
										<a href="javascript:;">Location<span class="label label-success pull-right r-activity">${userVehicleList[status.index].location}</span></a>
									</li>
									<li>
										<a href="javascript:;">Vin<span class="label label-success pull-right r-activity">${userVehicleList[status.index].vin}</span></a>
									</li>
									<li>
										<a href="javascript:;">Mileage<span class="label label-success pull-right r-activity">${v.mileage}</span></a>
									</li>
								</ul>
							</section>
						</aside>
					</div>
					<c:if test="${status.index mod 3 eq 2}">
						<br>
					</c:if>
				</c:forEach>
				<!-- ------- 특정 User ID에 등록된 User Vehicle List end ------- -->
			</div>
		</section>
	</section>
	<!--main content end-->

	<!--footer start-->
	<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
	<!--footer end-->

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
	<script type="text/javascript">
	function checkVIN(){
		var regex = /[(0-9)]{10}/;
		
		if(!regex.test($("#vin").val())){
			alert("VIN은 숫자 10자리이어야 합니다!");
			return false;
		}else{
			return true;
		}
	}
	</script>
</body>
</html>