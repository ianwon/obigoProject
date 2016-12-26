<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/obigoProject/css/bootstrap.min.css" rel="stylesheet">
<link href="/obigoProject/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="/obigoProject/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="/obigoProject/assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
<!--right slidebar-->
<link href="/obigoProject/css/slidebars.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/obigoProject/css/style.css" rel="stylesheet">
<link href="/obigoProject/css/style-responsive.css" rel="stylesheet" />
<!--     <link href="/obigoProject/assets/morris.js-0.4.3/morris.css" rel="stylesheet" /> -->
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

	<section id="container" class="">
		<!--main content start-->

		<section id="main-content">
			<section class="wrapper site-min-height">

				<!-- User Vehicle에 등록된 Model 비율 통계 Start -->
				<div class="flot-chart">
					<div class="row">
						<div class="col-lg-6">
							<section class="panel">
								<header class="panel-heading"> User Vehicle 차종 통계</header>
								<div class="panel-body">
									<div id="graph2" class="chart"></div>
								</div>
							</section>
						</div>
					</div>
				</div>
				<!-- User Vehicle에 등록된 Model 비율 통계 End -->

			</section>
		</section>
		<!--main content end-->

		<!--footer start-->
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->

	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<!--<script src="js/jquery-1.8.3.min.js"></script>-->
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<script src="/obigoProject/assets/flot/jquery.flot.js"></script>
	<script src="/obigoProject/assets/flot/jquery.flot.resize.js"></script>
	<script src="/obigoProject/assets/flot/jquery.flot.pie.js"></script>
	<script src="/obigoProject/assets/flot/jquery.flot.stack.js"></script>
	<script src="/obigoProject/assets/flot/jquery.flot.crosshair.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!-- script for this page only-->
	<!-- 		<script src="/obigoProject/js/morris-script.js"></script> -->

	<script type="text/javascript">
	// User Vehicle 차종 별 통계 Method를 호출할 때, 자바스크립트 Error를 없애기 위해 필요한 선언
	jQuery.browser = {};
	(function() {
		jQuery.browser.msie = false;
		jQuery.browser.version = 0;
		if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
			jQuery.browser.msie = true;
			jQuery.browser.version = RegExp.$1;
		}
	})();
	
	
	$(document).ready(

			function() {
				
				// User Vehicle에 등록된 차종을 그래프로 출력해주는 AJAX
				$.ajax({
					type : "post",
					url : "/obigoProject/countingbymodel",
					dataType : "json",
					success : function(data) {
						// 그래프로 출력해주기 위해서 Json data를 함수의 인자로 보내준다.
						makePie2Chart(data);
					},
					error : function(e) {
						console.log(e);
					}
				});
			});
	
	// 차종별 비율을 그래프로 출력해주는 함수
	function makePie2Chart(jsonData) {

		var plot;

		$(function() {
			
			// JSON Data
			var data = jsonData;
			
			// JSON Data Array의 length
			var series=jsonData.length;

			// GRAPH 2
			$.plot($("#graph2"),
							data,
							{
								series : {
									pie : {
										show : true,
										radius : 1,
										label : {
											show : true,
											radius : 1,
											formatter : function(label,
													series) {
												return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
														+ label
														+ '<br/>'
														+ Math
																.round(series.percent)
														+ '%</div>';
											},
											background : {
												opacity : 0.8
											}
										}
									}
								},
								legend : {
									show : false
								}
							});

		});

	}
	
	</script>
</body>
</html>