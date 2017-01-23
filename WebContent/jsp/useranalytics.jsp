<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>User Access Analytics</title>
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
<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" />


<style type="text/css">
#myTable_wrapper {
	margin-left: 0px;
	width: 80%;
}

#loading {
	border: 0;
	display: none;
	text-align: center;
	filter: alpha(opacity = 60);
	opacity: alpha*0.6;
	z-index: 5;
}
</style>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<!-- Select Box에 현재 년도와 1년전 년도를 표시하기 위함 -->
	<jsp:useBean id="toYear" class="java.util.Date" />
	<fmt:formatDate value="${toYear}" pattern="yyyy" var="nowYear" />

	<!-- 메일 전송하는 동안 띄워줄 이미지 -->
	<div id="loading">
		<img src="/obigoProject/img/loading.gif" />
	</div>

	<section id="container" class="">
		<!--main content start-->

		<section id="main-content">
			<section class="wrapper site-min-height">
				<div id="morris">
					<div class="row">
						<!-- page start-->
						<div class="col-lg-6" style="width: 1500px;">
							<section class="panel">
								<header class="panel-heading">
									User Access Analytics &nbsp;
									<span id="head-userid"></span>
									<!-- -------------- 통계 캡처 이미지 Email 발송 Button start -------------- -->
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" style="color: white; border-color: #FF6C60; background-color: #FF6C60;" onclick="capture();">
											Email
											<i class="fa fa-envelope"></i>
										</button>
									</div>
									<!-- -------------- 통계 캡처 이미지 Email 발송 Button end -------------- -->
								</header>
								<div class="panel-body" id="target">
									<!-- ------- 사용자 접속 통계의 대상이 되는 년도를 바꾸는 Select Box start ------- -->
									<form action="/obigoProject/useranalytics" id="frmSelectYear">
										<label>Year : </label>
										&nbsp; &nbsp; <select id="selectYear" name="selectYear" onchange="changeYear()">
											<c:choose>
												<c:when test="${param.selectYear==nowYear}">
													<option value="${nowYear}" selected>${nowYear}</option>
													<option value="${nowYear-1}">${nowYear-1}</option>
												</c:when>
												<c:when test="${param.selectYear==nowYear-1}">
													<option value="${nowYear}">${nowYear}</option>
													<option value="${nowYear-1}" selected>${nowYear-1}</option>
												</c:when>
												<c:otherwise>
													<option value="${nowYear}" selected>${nowYear}</option>
													<option value="${nowYear-1}">${nowYear-1}</option>
												</c:otherwise>
											</c:choose>
										</select>
										<input type="submit" hidden="hidden">
									</form>
									<!-- ------- 사용자 접속 통계의 대상이 되는 년도를 바꾸는 Select Box end ------- -->

									<!-- ------- User 접속 통계 start ------- -->
									<div id="hero-bar" class="graph"></div>
									<!-- ------- User 접속 통계 end ------- -->
								</div>
							</section>
						</div>
						<!-- page end-->
					</div>
				</div>
				<section class="panel" style="width: 1470px;">
					<header class="panel-heading">
						<form action="">
							<label>Search User ID:&nbsp;&nbsp; </label>
							<input type="text" id="searchId" style="width: 150px;" onkeyup="searchUserId()">
							<input type="text" style="display: none;" />
						</form>
					</header>
					<div class="panel-body">
						<table id="myTable">
							<thead>
								<tr>
									<th>User ID</th>
									<th>Password</th>
									<th>Name</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Role Name</th>
									<th>Date</th>
								</tr>
							</thead>
						</table>
					</div>
				</section>
			</section>
		</section>
		<!--main content end-->

		<!--footer start-->
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->

	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/obigoProject/js/jquery-migrate-1.2.1.min.js"></script>
	<!--<script src="js/jquery-1.8.3.min.js"></script>-->
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
	<script src="/obigoProject/js/respond.min.js"></script>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!-- 이미지 캡처 -->
	<script src="/obigoProject/js/html2canvas.js"></script>

	<script type="text/javascript">
		var table = null;
		$(document).ready(function() {
			// User Search Table 생성해주는 함수 호출
			createTable();
			// User를 검색하고 그래프를 생성해주는 함수
			searchUserId();

		});

		// select dropdown 버튼에서 년도를 선택했을 때 호출되는 함수
		function changeYear() {
			document.getElementById("frmSelectYear").submit();
		}

		// Table을 생성하는 함수
		function createTable() {
			// datatables 라이브러리는 사용하는데 table을 사용하기 위해서 initialize 해주는 작업
			table = $("#myTable").DataTable({
				"processing" : true,
				// 				"bDestroy" : true,
				"destroy" : true,
				"bFilter" : false,
				"order" : [ [ 0, "asc" ] ],
				"columnDefs" : [ {
					"width" : "80px",
					"targets" : 4
				}, {
					"width" : "80px",
					"targets" : 5
				} ],
				"ajax" : {
					"url" : "/obigoProject/loginuserlist",
					"data" : {
						"userId" : $("#searchId").val()
					},
					"type" : "POST"
				},
				"columns" : [ {
					"data" : "userId"
				}, {
					"data" : "password",
					"visible" : false
				}, {
					"data" : "name"
				}, {
					"data" : "eMail"
				}, {
					"data" : "phone"
				}, {
					"data" : "roleName"
				}, {
					"data" : "date"
				} ]
			});

			// table의 row를 클릭했을 때 해당된는 row의 User ID에 대한 Login 통계를 보여주는 함수
			$("#myTable tbody").on(	"click", "tr", function() {
					// 선택이 해제되었을 때 전체 User에 대한 통계를 보여줌
					if ($(this).hasClass("selected")) {
						$(this).removeClass("selected");
						$.ajax({
							type : "post",
							url : "/obigoProject/countuserlogin",
							dataType : "json",
							async : false,
							data : {
								"userId" : "",
								"selectYear" : $('#selectYear option:selected').val()
							},
							success : function(data) {
								setUp(data, "");
								
							},
							error : function(e) {
								console.log(e);
							}
						});
					}
					// 선택할 때, 해당 ID에 대한 통계를 보여줌
					else {
						table.$("tr.selected").removeClass(
								"selected");
						$(this).addClass("selected");
						var userId = $(this).find("td:eq(0)").text();

						// 선택한 User ID의 월별 Login Count를 얻어오는 AJAX
						$.ajax({
							type : "post",
							url : "/obigoProject/countuserlogin",
							dataType : "json",
							async : false,
							data : {
								"userId" : userId,
								"selectYear" : $('#selectYear option:selected').val()
							},
							success : function(data) {
								if (userId != "No data available in table") {
									setUp(data, userId);
								}
							},
							error : function(e) {
								console.log(e);
							}
						});
					}
				});
		}

		// Text에 입력한 문자열을 포함하는 User ID의 List를 테이블로 보여준다.
		function searchUserId() {
			var mytable = null;
			var header = null;
			var row = null;
			var cell = null;
			var cellName = [ "User ID", "Password", "Name", "Email", "Phone",
					"Role Name", "Date" ];

			if (table) {
				table.destroy();
				$('#myTable').empty();

				// table을 비우고 새롭게 thead를 채워주는 과정
				mytable = document.getElementById("myTable");
				header = mytable.createTHead();
				row = header.insertRow(0);
				for (var i = 0; i < 7; i++) {
					cell = row.insertCell(i);
					cell.innerHTML = cellName[i];
				}
			}

			createTable();

			if ($("#searchId").val() == "") {
				$.ajax({
					type : "post",
					url : "/obigoProject/countuserlogin",
					dataType : "json",
					async : false,
					data : {
						"userId" : "",
						"selectYear" : $('#selectYear option:selected').val()
					},
					success : function(data) {
						setUp(data, "");
					},
					error : function(e) {
						console.log(e);
					}
				});
			}
		}

		// User Login 통계 그래프를 보여주는 함수
		function setUp(data, userId) {
			if (userId == "") {
				$("#hero-bar").empty();
				$("#head-userid").text("[ All ]");
			} else {
				$("#hero-bar").empty();
				$("#head-userid").text("[ ID: " + userId + " ]");
			}

			$(function() {
				Morris.Bar({
					element : 'hero-bar',
					resize : true,
					data : [ {
						device : 'JAN',
						geekbench : data[0]
					}, {
						device : 'FEB',
						geekbench : data[1]
					}, {
						device : 'MAR',
						geekbench : data[2]
					}, {
						device : 'APR',
						geekbench : data[3]
					}, {
						device : 'MAY',
						geekbench : data[4]
					}, {
						device : 'JUN',
						geekbench : data[5]
					}, {
						device : 'JUL',
						geekbench : data[6]
					}, {
						device : 'AUG',
						geekbench : data[7]
					}, {
						device : 'SEP',
						geekbench : data[8]
					}, {
						device : 'OCT',
						geekbench : data[9]
					}, {
						device : 'NOV',
						geekbench : data[10]
					}, {
						device : 'DEC',
						geekbench : data[11]
					}, ],
					xkey : 'device',
					ykeys : [ 'geekbench' ],
					labels : [ 'Geekbench' ],
					barRatio : 0.4,
					xLabelAngle : 0,
					hideHover : 'auto',
					barColors : [ '#6883a3' ]
				});
			});
		}

		// 통계 캡쳐 및 이메일 전송
		function capture() {
			if (confirm("이메일을 전송하시겠습니까?") == true) {
				html2canvas($("#morris"), {
					onrendered : function(canvas) {
						document.body.appendChild(canvas);

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
							},
							beforeSend : function() {
								//통신을 시작할때 처리
								$('#loading').css('position', 'absolute');
								$('#loading').css('left',
										$('#target').offset().left);
								$('#loading').css('top',
										$('#target').offset().top);
								$('#loading').css('width',
										$('#target').css('width'));
								$('#loading').css('height',
										$('#target').css('height'));
								$('#loading').show().fadeIn('fast');
							},
							complete : function() {
								//통신이 완료된 후 처리
								$('#loading').fadeOut();
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