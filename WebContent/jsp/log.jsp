<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log</title>
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

	<section id="container" class="">
		<!--main content start-->

		<section id="main-content">

			<section class="wrapper site-min-height">

				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> Log </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<a class="btn btn-success" data-toggle="modal" href="javascript:deleteLog();"> Delete All Log <i class="fa fa-minus"></i>
									</a>
								</div>

								<div class="btn-group pull-right">
									<button class="btn dropdown-toggle" data-toggle="dropdown">
										PDF flie <i class="fa fa-angle-down"></i>
									</button>
									<ul class="dropdown-menu pull-right">
										<li><a href="/obigoProject/viewpdf" target="_blank">View on PDF</a></li>
										<!--                            <li><a href="/obigoProject/pdfmail">Send an Email to Admin</a></li> -->
										<li><a a href='javascript:void(0);' onclick="mailToAdmin();">Send an Email to Admin</a></li>
									</ul>
								</div>
							</div>

							<input type="hidden" id="hidden-log">

							<div class="space15"></div>
							
							<!--  Log Table start -->
							<div class="table-responsive">
								<table style="table-layout:fixed; word-break:break-all;" class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>Url</th>
											<th>Body</th>
											<th>Date Time</th>
											<th style="width:800px;">Return</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="l" items="${logList}" begin="0">
											<tr class="">
												<td>${l.url}</td>
												<td class="center">${l.body}</td>
												<td class="center">${l.dateTime}</td>
												<td class="center">${l.returned}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>

							</div>
							<!-- api table end -->
						</div>
					</div>
				</section>
				<!-- page end-->
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
		//api 삭제여부를 확인하고 true=삭제 false=취소
		function deleteLog() {
			if (confirm("전체 로그를 정말 삭제하시겠습니까?") == true) { //확인
				$.ajax({
					type : "post",
					url : "/obigoProject/deletelog",
					dataType : "json",
					data : {},
					success : function(data) {
						location.reload();
					}
				});
			} else { //취소
				return;
			}
		}

		function mailToAdmin() {

			$.ajax({
				type : "post",
				url : "/obigoProject/pdfmail",
				dataType : "json",
				async : true,
				data : {},
				success : function(data) {
					if (data.flag == true)
						alert("Send email success");
					else
						alert("Send email fail");
				}
			});

		}
	</script>

</body>
</html>