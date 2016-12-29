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

				<!-- modal start -->
				<div class="modal fade " id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title">Update Vehicle</h4>
							</div>
							<div class="modal-body">

								<form id="form-editvehicle" enctype="multipart/form-data" class="form-signin" action="/obigoProject/updatevehicle" method="POST">
									<span class="label label-primary">MODEL NAME</span>
									<input type="text" id="ModelName" name="modelName" class="form-control" placeholder="Model Name" readonly="readonly">
									<span class="label label-primary">MODEL CODE</span>
									<input type="text" id="ModelCode" name="modelCode" class="form-control" placeholder="Model Code" readonly="readonly">
									<span class="label label-primary">MODEL IMAGE</span>
									<input type="file" id="ModelImage" name="model_Image" class="form-control" placeholder="Model Image" readonly="readonly">
									<span class="label label-primary">DETAIL IMAGE</span>
									<input type="file" id="DetailImage" name="detail_Image" class="form-control" placeholder="Detail Image" readonly="readonly">
									<span class="label label-primary">ENGINE</span>
									<input type="text" id="Engine" name="engine" class="form-control" placeholder="Engine" required="required" readonly="readonly">
									<span class="label label-primary">MODEL YEAR</span>
									<input type="number" id="ModelYear" name="modelYear" class="form-control" min="1900" max="2099" step="1" value="2016" readonly="readonly">
									<span class="label label-primary">MILEAGE</span>
									<input type="text" id="Mileage" name="mileage" class="form-control" placeholder="mileage" readonly="readonly" readonly="readonly">
								</form>

							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- modal end -->
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
				var code = jsonData[0].code;
				alert(code);
				// JSON Data Array의 length
				var series = jsonData.length;
	
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
										return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;"><a href="javascript:openModal('+"'"+ code +"'"+')">'											+ label
											+ '<br/>'
											+ Math
												.round(series.percent)
											+ '%</a></div>';
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
	
		function openModal(modelCode){
			
			$.ajax({
				type : "post",
				url : "/obigoProject/selectvehicle",
				dataType : "json",
				data : {
					"modelCode" : modelCode
				},
				success : function(data) {
					$("#ModelName").val(data.vehicle);
					$("#ModelCode").val("ggg");
					$("#modal").modal();
				}
			});
		}
	</script>
</body>
</html>