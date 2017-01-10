<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>Message Analytics</title>
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

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="container" class="">
		<section id="main-content">
			<section class="wrapper site-min-height">
				<div id="container-graph" style="height: 400px;"></div>
			</section>
		</section>

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

	<script type="text/javascript">
	
		// 보내주는 Data로 Graph를 만들어 주는 함수
		function makeChart(data1) {
			$(function() {
				Highcharts.chart('container-graph', {
					chart : {
						type : 'pie',
						options3d : {
							enabled : true,
							alpha : 45
						}
					},
					title : {
						text : 'Push message Analytics'
					},
					subtitle : {
						text : 'Counting of Push message'
					},
					plotOptions : {
						pie : {
							innerSize : 100,
							depth : 45
						}
					},
					series : [ {
						name : 'Send message counting',
						data : data1
					} ]
				});
			});
		}

		// User Vehicle에 등록된 차종의 비율을 그래프를 위한 Data를 AJAX로 얻어와서
		// Graph만드는 함수의 Parameter로 넘겨준다
		$(function() {
			$.ajax({
				type : "post",
				url : "/obigoProject/getmessageanalytics",
				dataType : "json",
				success : function(data) {
					makeChart(data);
				},
				error : function(e) {
					console.log(e);
				}
			});
		});
	</script>

</body>
</html>