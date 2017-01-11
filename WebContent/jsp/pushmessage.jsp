<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>Push Message</title>
<style type="text/css">
td {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
</style>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> PushMessage </header>
					<div class="panel-body">
						<!-- -------------- Push Message Modal start -------------- -->
						<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title">Select Message</h4>
									</div>
									<div class="modal-body">
										<form class="form-signin" id="form-message">
											<div class="login-wrap">
												<div class="form-group">
													<span class="label label-primary">TITLE</span>
													<input type="text" name="messageTitle" id="messageTitle" class="form-control" readonly="readonly">
												</div>
												<div class="form-group">
													<span class="label label-primary">CONTENT</span>
													<textarea name="content" id="content" class="form-control" placeholder="Response To Send" rows="15" cols="45" readonly="readonly" style="font-size: 11px; text-align: left;"></textarea>
												</div>
												<div class="form-group">
													<span class="label label-primary">SEND DATE</span>
													<input type="text" name="sendDate" id="sendDate" class="form-control" readonly="readonly">
												</div>
												<div class="form-group">
													<span class="label label-primary">MESSAGE CATEGORY</span>
													<input type="text" name="messageCategory" id="messageCategory" class="form-control" readonly="readonly">
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
									</div>
								</div>
							</div>
						</div>
						<!-- -------------- Push Message Modal end -------------- -->
						<header>
							<div class="panel">
								<form action="/obigoProject/pushmessage" id="frmSelect">
									<label>Category : </label> <select id="selectcategory" name="categoryNumber" onchange="changeFrm(this)">
										<option value="">Select Category</option>
										<c:forEach var="mcl" items="${messageCategoryList}" begin="0">
											<c:choose>
												<c:when test="${param.categoryNumber==mcl.categoryNumber}">
													<option value="${mcl.categoryNumber}" selected>Category : ${mcl.categoryName}</option>
												</c:when>
												<c:otherwise>
													<option value="${mcl.categoryNumber}">Category : ${mcl.categoryName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select> <label>Location : </label> <select id="selectlocation" name="location" onchange="changeFrm(this)">
										<option value="">Select Location</option>
										<c:forEach var="ll" items="${locationList}" begin="0">
											<c:choose>
												<c:when test="${param.location==ll.location}">
													<option value="${ll.location}" selected>Location : ${ll.location}</option>
												</c:when>
												<c:otherwise>
													<option value="${ll.location}">Location : ${ll.location}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select> <label>Model : </label> <select id="selectmodel" name="modelCode" onchange="changeFrm(this)">
										<option value="">Select Model</option>
										<c:forEach var="ml" items="${modelList}" begin="0">
											<c:choose>
												<c:when test="${param.modelCode==ml.modelCode}">
													<option value="${ml.modelCode}" selected>ModelName : ${ml.modelName}</option>
												</c:when>
												<c:otherwise>
													<option value="${ml.modelCode}">ModelName : ${ml.modelName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
									<input type="submit" hidden="hidden">
								</form>
							</div>
						</header>
						<div class="adv-table editable-table ">
							<div class="clearfix"></div>
							<!-- table 자동정렬해주는 javascript 파일에서 어느 항목의 table인지 구분하기 위한 hidden -->
							<input type="hidden" id="hidden-pushmessage">
							<div class="space15"></div>

							<!-- -------------- Push Message Table start -------------- -->
							<div class="table-responsive">
								<table style="table-layout: fixed; word-break: break-all;" class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>Title</th>
											<th>Upload File</th>
											<th style="width: 500px;">Content</th>
											<th>Send Date</th>
											<th>Model Name</th>
											<th>Location</th>
											<th>Category Name</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="p" items="${pushMessageList}" begin="0" varStatus="status">
											<!-- Catecory Number를 Map의 인덱스로 사용하기 위해서 필요한 변수 -->
											<c:set var="cnumber" value="category${p.categoryNumber}" />
											<c:set var="code" value="${p.modelCode}" />
											<tr class="">
												<td class="center" id="title${status.index}" onclick="showModal(${status.index})" style="cursor:pointer;">${p.title}</td>
												<td class="center" onclick="showModal(${status.index})" style="cursor:pointer;">${p.uploadFile}</td>
												<td class="center" id="content${status.index}" onclick="showModal(${status.index})" style="cursor:pointer;">${p.content}</td>
												<td class="center" id="sendDate${status.index}" onclick="showModal(${status.index})" style="cursor:pointer;">${p.sendDate}</td>
												<td class="center" onclick="showModal(${status.index})" style="cursor:pointer;"><c:out value="${vehicleMap[code]}" /></td>
												<td class="center" onclick="showModal(${status.index})" style="cursor:pointer;">${p.location}</td>
												<td class="center" id="messageCategory${status.index}" onclick="showModal(${status.index})" style="cursor:pointer;"><c:out value="${messageCategoryMap[cnumber]}" /></td>
												<td><a class="Delete" href="javascript:deletePushmessage(${p.messageNumber});">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- -------------- Push Message Table end -------------- -->
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
		function showModal(status) {
			$("#messageTitle").val($("#title" + status).text());
			$("#content").val($("#content" + status).text());
			$("#sendDate").val($("#sendDate" + status).text());
			$("#messageCategory").val($("#messageCategory" + status).text());
			$("#myModal").modal();
		}
	
		function changeFrm(option) {
			document.getElementById("frmSelect").submit();
		}
	
		// Push Message 삭제여부를 확인하고 true=삭제 false=취소
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
