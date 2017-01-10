<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>User Request</title>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->
			<section class="panel">
				<header class="panel-heading"> USER REQUEST </header>
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix"></div>
					</div>
					<div class="space15"></div>

					<!-- -------------- User Request Table start -------------- -->
					<div class="table-responsive">
						<table class="table table-striped table-hover table-bordered" id="editable-sample">
							<thead>
								<tr>
									<th>User Name</th>
									<th>Model Name</th>
									<th>Vin</th>
									<th>Location</th>
									<th>Accept</th>
									<th>Reject</th>
								</tr>
							</thead>
							<tbody>
								<!-- 유저요청 정보를 가져와서 테이블 형식으로 출력 -->
								<c:forEach var="k" items="${userRequestList}" begin="0">
									<c:set var="code" value="${k.modelCode}" />
									<tr class="">
										<td>${k.userId}</td>
										<td><c:out value="${vehicleMap[code]}" /></td>
										<td>${k.vin}</td>
										<td class="center">${k.location}</td>
										<td><a class="Accept" href="javascript:accept(${k.userRequestNumber }, '${k.userId}','${k.vin}');">Accept</a></td>
										<td><a class="Reject" href="javascript:reject(${k.userRequestNumber }, '${k.userId}');">Reject</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- -------------- User Request Table end -------------- -->
				</div>
			</section>
			<!-- page end-->
		</section>
	</section>

	<!--footer start-->
	<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
	<!--footer end-->

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/obigoProject/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="/obigoProject/assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/data-tables/DT_bootstrap.js"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--script for this page only-->
	<script src="/obigoProject/js/editable-table.js"></script>

	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			EditableTable.init();
		});
	</script>

	<script type="text/javascript">
		//User Request Accept 함수
		function accept(requestNumber, userId, vin) {
			if (checkVin(vin) == true) {
				if (confirm("정말 수락하시겠습니까??") == true) {
					$.ajax({
						type : "post",
						url : "/obigoProject/acceptrequest",
						dataType : "json",
						data : {
							"userRequestNumber" : requestNumber,
							"userId" : userId,
							"flag" : "accept"
						},
						async : false,
						success : function(data) {
							location.reload();
						}
					});
				} else
					return;
			} else {
				alert("이미 등록된 VIN 입니다.")
			}
	
		}
	
		function checkVin(vin) {
			var flag = false;
	
			$.ajax({
				type : "post",
				url : "/obigoProject/checkvinnumber",
				dataType : "json",
				data : {
					"vin" : vin
				},
				async : false,
				success : function(data) {
					if (data.flag == true) {
						flag = true;
					} else {
						flag = false;
					}
				}
			});
			return flag;
	
		}
	
		//User Request Accept 함수
		function reject(requestNumber, userId) {
			if (confirm("정말 거절하시겠습니까??") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/rejectrequest",
					dataType : "json",
					data : {
						"userRequestNumber" : requestNumber,
						"userId" : userId,
						"flag" : "reject"
					},
					success : function(data) {
						location.reload();
					}
				});
			} else
				return;
		}
	</script>

</body>
</html>