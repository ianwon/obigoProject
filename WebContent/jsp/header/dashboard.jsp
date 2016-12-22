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
			</div>
			<!--state overview end-->

  <!--custom chart start-->
                      <div class="border-head">
                          <h3>Earning Graph</h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>100</span></li>
                              <li><span>80</span></li>
                              <li><span>60</span></li>
                              <li><span>40</span></li>
                              <li><span>20</span></li>
                              <li><span>0</span></li>
                          </ul>
                          <div class="bar">
                              <div class="title">JAN</div>
                              <div class="value tooltips" data-original-title="80%" data-toggle="tooltip" data-placement="top">80%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">FEB</div>
                              <div class="value tooltips" data-original-title="50%" data-toggle="tooltip" data-placement="top">50%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">MAR</div>
                              <div class="value tooltips" data-original-title="40%" data-toggle="tooltip" data-placement="top">40%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">APR</div>
                              <div class="value tooltips" data-original-title="55%" data-toggle="tooltip" data-placement="top">55%</div>
                          </div>
                          <div class="bar">
                              <div class="title">MAY</div>
                              <div class="value tooltips" data-original-title="20%" data-toggle="tooltip" data-placement="top">20%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">JUN</div>
                              <div class="value tooltips" data-original-title="39%" data-toggle="tooltip" data-placement="top">39%</div>
                          </div>
                          <div class="bar">
                              <div class="title">JUL</div>
                              <div class="value tooltips" data-original-title="75%" data-toggle="tooltip" data-placement="top">75%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">AUG</div>
                              <div class="value tooltips" data-original-title="45%" data-toggle="tooltip" data-placement="top">45%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">SEP</div>
                              <div class="value tooltips" data-original-title="50%" data-toggle="tooltip" data-placement="top">50%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">OCT</div>
                              <div class="value tooltips" data-original-title="42%" data-toggle="tooltip" data-placement="top">42%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">NOV</div>
                              <div class="value tooltips" data-original-title="60%" data-toggle="tooltip" data-placement="top">60%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">DEC</div>
                              <div class="value tooltips" data-original-title="90%" data-toggle="tooltip" data-placement="top">90%</div>
                          </div>
                      </div>
                      <!--custom chart end-->


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
	<script src="	/obigoProject/js/owl.carousel.js"></script>
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
	function countUp(count)
	{
	    var div_by = 100,
	        speed = Math.round(count / div_by),
	        $display = $('.count'),
	        run_count = 1,
	        int_speed = 24;

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
	        int_speed = 24;

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