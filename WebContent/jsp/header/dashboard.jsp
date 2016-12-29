<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->

			<!--state overview start-->
			<div class="row state-overview">

				<!-- 등록된 User의 통계 Start -->
				<div class="col-lg-3 col-sm-6">
					<section class="panel">
						<div class="symbol terques">
							<i class="fa fa-user"></i>
						</div>
						<div class="value">
							<h1 class="count">0</h1>
							<p>Users</p>
						</div>
					</section>
				</div>
				<!-- 등록된 User의 통계 End -->

				<!-- 등록된 User Vehicle의 통계 Start -->
				<div class="col-lg-3 col-sm-6">
					<section class="panel">
						<div class="symbol red">
							<i class="fa fa-tags"></i>
						</div>
						<div class="value">
							<h1 class=" count2">0</h1>
							<p>User Vehicles</p>
						</div>
					</section>
				</div>
				<!-- 등록된 User Vehicle의 통계 End -->


				<!-- 날씨 api Start -->
				<div class="col-lg-4">
					<section class="panel">
						<div class="weather-bg">
							<div class="panel-body">
								<div class="row">
									<div class="col-xs-6">
										<img id="weather-icon" style="width: 100px; height: 80px;" src="http://openweathermap.org/img/w/01d.png"><br>
										<span id="weather-city">Seoul</span>
									</div>
									<div class="col-xs-6">
										<div class="degree">
											<span id="weather-temp">24</span>
											°
										</div>
									</div>
								</div>
							</div>
						</div>

						<footer class="weather-category">
							<ul>
								<li class="active">
									<h5>humidity</h5>
									<span id="weather-humidity">56</span>
									%
								</li>
								<li>
									<h5>description</h5>
									<span id="weather-description">Sky is Clear</span>
								</li>
								<li>
									<h5>winds</h5>
									<span id="weather-windspeed">10</span>
									m/s
								</li>
							</ul>
						</footer>

					</section>
				</div>
				<!-- 날씨 api End -->

			</div>
			<!--state overview end-->

			<!-- 월별 Login 통계 Start -->
			<div class="border-head">
				<h3><%=Calendar.getInstance().get(Calendar.YEAR)%>
					Graph
				</h3>
			</div>
			<div class="custom-bar-chart">
				<ul class="y-axis">
					<li>
						<span>100</span>
					</li>
					<li>
						<span>80</span>
					</li>
					<li>
						<span>60</span>
					</li>
					<li>
						<span>40</span>
					</li>
					<li>
						<span>20</span>
					</li>
					<li>
						<span>0</span>
					</li>
				</ul>
				<div class="bar">
					<div class="title">JAN</div>
					<div class="value tooltips" data-original-title="${userCountList[0]}%" data-toggle="tooltip" data-placement="top">${userCountList[0]}%</div>
				</div>
				<div class="bar ">
					<div class="title">FEB</div>
					<div class="value tooltips" data-original-title="${userCountList[1]}%" data-toggle="tooltip" data-placement="top">${userCountList[1]}%</div>
				</div>
				<div class="bar ">
					<div class="title">MAR</div>
					<div class="value tooltips" data-original-title="${userCountList[2]}%" data-toggle="tooltip" data-placement="top">${userCountList[2]}%</div>
				</div>
				<div class="bar ">
					<div class="title">APR</div>
					<div class="value tooltips" data-original-title="${userCountList[3]}%" data-toggle="tooltip" data-placement="top">${userCountList[3]}%</div>
				</div>
				<div class="bar">
					<div class="title">MAY</div>
					<div class="value tooltips" data-original-title="${userCountList[4]}%" data-toggle="tooltip" data-placement="top">${userCountList[4]}%</div>
				</div>
				<div class="bar ">
					<div class="title">JUN</div>
					<div class="value tooltips" data-original-title="${userCountList[5]}%" data-toggle="tooltip" data-placement="top">${userCountList[5]}%</div>
				</div>
				<div class="bar">
					<div class="title">JUL</div>
					<div class="value tooltips" data-original-title="${userCountList[6]}%" data-toggle="tooltip" data-placement="top">${userCountList[6]}%</div>
				</div>
				<div class="bar ">
					<div class="title">AUG</div>
					<div class="value tooltips" data-original-title="${userCountList[7]}%" data-toggle="tooltip" data-placement="top">${userCountList[7]}%</div>
				</div>
				<div class="bar ">
					<div class="title">SEP</div>
					<div class="value tooltips" data-original-title="${userCountList[8]}%" data-toggle="tooltip" data-placement="top">${userCountList[8]}%</div>
				</div>
				<div class="bar ">
					<div class="title">OCT</div>
					<div class="value tooltips" data-original-title="${userCountList[9]}%" data-toggle="tooltip" data-placement="top">${userCountList[9]}%</div>
				</div>
				<div class="bar ">
					<div class="title">NOV</div>
					<div class="value tooltips" data-original-title="${userCountList[10]}%" data-toggle="tooltip" data-placement="top">${userCountList[10]}%</div>
				</div>
				<div class="bar ">
					<div class="title">DEC</div>
					<div class="value tooltips" data-original-title="${userCountList[11]}%" data-toggle="tooltip" data-placement="top">${userCountList[11]}%</div>
				</div>
			</div>
			<!-- 월별 Login 통계 End -->


			<!-- page end-->
		</section>
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
	<!-- 	<script src="/obigoProject/js/count.js"></script> -->

	<script type="text/javascript">
	$(document).ready(

			function() {
				
				// 날씨 api 데이터를 받아서 적용해주는 AJAX
				$.ajax({
							type : "get",
							url : "http://api.openweathermap.org/data/2.5/weather?appid=979f0179827d470b83d8072d50e99855&q=Seongnam&units=metric",
							dataType : "json",
							success : function(data) {
								$("#weather-windspeed").text(data.wind.speed);
								$("#weather-humidity").text(data.main.humidity);
								$("#weather-city").text(data.name);
								$("#weather-temp").text(Math.floor(data.main.temp));
								$("#weather-description").text(data.weather[0].description);
								$("#weather-icon").attr("src","http://openweathermap.org/img/w/"+ data.weather[0].icon+".png");
							},
							error : function(e) {
								console.log(e);
							}
						});
				
				
				
				
			});
	
	
	
	function countUp(count)
	{
	    var div_by = 100,
	        speed = Math.round(count / div_by),
	        $display = $('.count'),
	        run_count = 1,
	        int_speed = 10;

	    var int = setInterval(function() {
	        if(run_count < div_by){
	            $display.text(speed * run_count);
	            run_count++;
	        } else if(parseInt($display.text()) < count) {
	            var curr_count = parseInt($display.text()) + 1;
	            $display.text(curr_count);
	        } else {
	            clearInterval(int);
	        }
	    }, int_speed);
	}

	countUp(${userCount});

	function countUp2(count)
	{
	    var div_by = 100,
	        speed = Math.round(count / div_by),
	        $display = $('.count2'),
	        run_count = 1,
	        int_speed = 10;

	    var int = setInterval(function() {
	        if(run_count < div_by){
	            $display.text(speed * run_count);
	            run_count++;
	        } else if(parseInt($display.text()) < count) {
	            var curr_count = parseInt($display.text()) + 1;
	            $display.text(curr_count);
	        } else {
	            clearInterval(int);
	        }
	    }, int_speed);
	}

	countUp2(${userVehicleCount});
	</script>
</body>
</html>