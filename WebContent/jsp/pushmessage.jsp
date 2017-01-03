<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Push Message</title>
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">

				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> PushMessage </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix"></div>

							<input type="hidden" id="hidden-pushmessage">
							<div class="space15"></div>

							<!--  Pushmessage Table start -->
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>Title</th>
											<th>Upload File</th>
											<th>Content</th>
											<th>Send Date</th>
											<th>Category Number</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="p" items="${pushMessageList}" begin="0">
											<c:set var="cnumber" value="category${p.categoryNumber}" />
											<tr class="">
												<td class="center">${p.title}</td>
												<td class="center">${p.uploadFile}</td>
												<td class="center">${p.content}</td>
												<td class="center">${p.sendDate}</td>
												<td class="center"><c:out value="${messageCategoryMap[cnumber]}" /></td>
												<td><a class="Delete" href="javascript:deletePushmessage(${p.messageNumber});">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
							<!--  Pushmessage Table end -->
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
		function deletePushmessage(data) {
			if (confirm("정말 삭제하시겠습니까??") == true) { //확인
				$.ajax({
					type : "post",
					url : "/obigoProject/deletepushmessage",
					dataType : "json",
					data : {
						"messageNumber" : data
					},
					success : function(data) {
						location.reload();
					}
				});
			} else { //취소
				return;
			}
		}
	</script>
</body>
</html>
