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
<title>Bundle Update Analytics</title>

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

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<div id="morris">
					<div class="row">
						<!-- page start-->
						<div class="col-lg-6" style="width: 1500px">
							<section id="mysection" class="panel">
								<header class="panel-heading">
									Bundle Update Analytics
									<!-- -------------- 통계 캡처 이미지 Email 발송 Button start -------------- -->
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" style="color: white; border-color: #FF6C60; background-color: #FF6C60;" onclick="capture();">
											Email
											<i class="fa fa-envelope"></i>
										</button>
									</div>
									<!-- -------------- 통계 캡처 이미지 Email 발송 Button end -------------- -->
								</header>
								<div class="panel-body">
									<div id="hero-graph" class="graph"></div>
								</div>
							</section>
						</div>
						<!-- page end-->
					</div>
				</div>
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

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!-- 이미지 캡처 -->
	<script src="/obigoProject/js/html2canvas.js"></script>

	<script>
		var Script = setUp(${bundleUpdateList},${userCountList},${period});	
		
		//morris chart - 8개월 전부터 현재까지의 User의 숫자와 Bundle Update 숫자를 비교해주는 Graph
		function setUp(bundle,user,period){
			$(function() {
				// data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type
				var tax_data = [
					{
						"period" : period[0].toString(),
						"USERS" : user[0],
						"BUNDLE UPDATE" : bundle[0]
					},
					{
						"period" : period[1].toString(),
						"USERS" : user[1],
						"BUNDLE UPDATE" : bundle[1]
					},
					{
						"period" : period[2].toString(),
						"USERS" : user[2],
						"BUNDLE UPDATE" : bundle[2]
					},
					{
						"period" : period[3].toString(),
						"USERS" : user[3],
						"BUNDLE UPDATE" : bundle[3]
					},
					{
						"period" : period[4].toString(),
						"USERS" : user[4],
						"BUNDLE UPDATE" : bundle[4]
					},
					{
						"period" : period[5].toString(),
						"USERS" : user[5],
						"BUNDLE UPDATE" : bundle[5]
					},
					{
						"period" : period[6].toString(),
						"USERS" : user[6],
						"BUNDLE UPDATE" : bundle[6]
					},
					{
						"period" : period[7].toString(),
						"USERS" : user[7],
						"BUNDLE UPDATE" : bundle[7]
					},
					
				];
				Morris.Line({
					element : 'hero-graph',
					data : tax_data,
					xkey : 'period',
					ykeys : [ 'USERS', 'BUNDLE UPDATE' ],
					labels : [ 'users', 'bundle update' ],
					lineColors : [ '#8075c4', '#6883a3' ]
				});
			});
		}
		
		// 통계 그래프를 캡쳐한 이미지를 관리자 이메일로 전송하는 함수
		function capture() {
			if (confirm("이메일을 전송하시겠습니까?") == true) {
			html2canvas($("#mysection"), {
				onrendered : function(canvas) {
					document.body.appendChild(canvas);
					//alert(canvas.toDataURL("image/png"));
					var img = canvas.toDataURL("image/png")

					$.ajax({
						type : "post",
						data : {
							"imgSrc" : img,
						},
						url : "/obigoProject/emailanalytics",
						error : function(a, b, c) {
							alert("이메일 보내기 실패");
						},
						success : function(data) {
							if (data.flag == true) {
								alert("이메일 보내기 성공");
							} else {
								alert("이메일 보내기 실패");
							}
						}
					});
				}
			});
			} else {
				return;
			}
		}
		
	</script>


</body>
</html>
