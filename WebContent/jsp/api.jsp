<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">
<title>Api</title>

<style type="text/css">
td {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}

textarea {
	font-size: 11px;
	text-align: left;
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
					<header class="panel-heading"> API </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<a class="btn btn-success" data-toggle="modal" href="#myModal"> Add API <i class="fa fa-plus"></i>
									</a>
								</div>

								<!-- -------------- Add Api Modal start -------------- -->
								<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add Api</h4>
											</div>
											<div class="modal-body">
												<form class="form-signin" id="form-insertapi" action="/obigoProject/insertapi" onsubmit="return check();" method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">API NAME</span>
															<input type="text" name="apiName" id="insertApiName" maxlength="40" class="form-control" placeholder="API NAME" autofocus required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">URL</span>
															<input type="text" name="url" id="insertUrl" maxlength="40" class="form-control" placeholder="URL" autofocus required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">BODY</span>
															<textarea name="body" id="insertBody" class="form-control" placeholder="BODY" rows="5" cols="45" required="required"></textarea>
														</div>
														<div class="form-group">
															<span class="label label-primary">RESPONSE TO SEND</span>
															<textarea name="responseToSend" class="form-control" placeholder="RESPONSE TO SEND" rows="10" cols="45" required="required"></textarea>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-insertapi" value="Insert">
											</div>
										</div>
									</div>
								</div>
								<!-- -------------- Add Api Modal end -------------- -->

								<!-- -------------- Edit Api Modal start -------------- -->
								<div class="modal fade " id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Update Api</h4>
											</div>
											<div class="modal-body">
												<form class="form-signin" id="form-editapi" action="/obigoProject/updateapi" method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">URL</span>
															<input type="text" name="url" id="editUrl" maxlength="40" class="form-control" placeholder="URL" autofocus readonly="readonly" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">API NAME</span>
															<input type="text" name="ApiName" id="editApiName" class="form-control" placeholder="API NAME" required="required" >
														</div>
														<div class="form-group">
															<span class="label label-primary">BODY</span>
															<textarea name="body" id="editBody" class="form-control" placeholder="BODY" rows="5" cols="45" required="required"></textarea>
														</div>
														<div class="form-group">
															<span class="label label-primary">RESPONSE TO SEND</span>
															<textarea name="ResponseToSend" id="editResponseToSend" class="form-control" placeholder="Response To Send" rows="10" cols="45" required="required"></textarea>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-editapi" value="Edit">
											</div>
										</div>
									</div>
								</div>
								<!-- -------------- Edit Api Modal end -------------- -->
							</div>
							<div class="space15"></div>
							<!-- ------------------Show Api Modal start--------------- -->
							<div class="modal fade " id="showModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											<h4 class="modal-title">Detail Api</h4>
										</div>
										<div class="modal-body">
											<form class="form-signin" id="form-insertapi" action="/obigoProject/insertapi" onsubmit="return check();" method="POST">
												<div class="login-wrap">
													<div class="form-group">
														<span class="label label-primary">API NAME</span>
														<input type="text" name="apiName" id="apiName" class="form-control" readonly="readonly">
													</div>
													<div class="form-group">
														<span class="label label-primary">URL</span>
														<input type="text" name="url" id="url" maxlength="40" class="form-control" placeholder="URL" autofocus readonly="readonly">
													</div>
													<div class="form-group">
														<span class="label label-primary">BODY</span>
														<textarea name="body" id="body" class="form-control" placeholder="BODY" rows="5" cols="45" readonly="readonly" style="font-size: 11px; text-align: left;"></textarea>
													</div>
													<div class="form-group">
														<span class="label label-primary">RESPONSE TO SEND</span>
														<textarea name="Response" id="response" class="form-control" placeholder="Response To Send" rows="15" cols="45" readonly="readonly" style="font-size: 11px; text-align: left;"></textarea>
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
							<!-- ------------------Show Api Modal end--------------- -->
							<!-- -------------- Api Table start -------------- -->
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample" style="table-layout: fixed; word-break: break-all;">
									<thead>
										<tr>
											<th style="width: 250px;">Api Name</th>
											<th style="width: 300px;">Url</th>
											<th style="width: 500px;">Body</th>
											<th>Response To Send</th>
											<th style="width: 100px;">Edit</th>
											<th style="width: 100px;">Delete</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${apiList}" begin="0" varStatus="status">
											<tr class="">
												<td id="apiName${status.index}" onclick="javascript:showModal(${status.index});" style="cursor: pointer;">${a.apiName}</td>
												<td id="url${status.index}" onclick="javascript:showModal(${status.index});" style="cursor: pointer;">${a.url}</td>
												<td id="body${status.index}" onclick="javascript:showModal(${status.index});" style="cursor: pointer;">${a.body}</td>
												<td id="responseToSend${status.index}" class="center" onclick="javascript:showModal(${status.index});" style="cursor: pointer;">${a.responseToSend}</td>
												<td><a class="Edit" href="javascript:editModal('${status.index}');">Edit</a></td>
												<td><a class="Delete" href="javascript:deleteApi('${a.url}');">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- -------------- Api Table end -------------- -->
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
	
		// input type="text" 또는 textarea의 양쪽 끝 공백을 제거해주는 함수
		$('#form-insertapi').submit(function() {
			$(this).find('input:text').each(function() {
				$(this).val($.trim($(this).val()));
			});
	
			$(this).find('textarea').each(function() {
				$(this).val($.trim($(this).val()));
			});
		});
	
	
		// Api Name의 존재 여부를 확인
		function check() {
			var apiUrlCheck = false;
			var str_space = /\s/; // 공백체크
	
			if (str_space.test($("#insertUrl").val())) { //공백 체크
				alert("해당 항목에는 공백을 사용할수 없습니다");
				apiUrlCheck = false;
			} else {
				$.ajax({
					type : "post",
					url : "/obigoProject/urlcheck",
					dataType : "json",
					async : false,
					data : {
						"url" : $("#url").val()
					},
					success : function(data) {
						if (data.flag === false) {
							alert("존재하는 url입니다.");
						} else {
							alert("Api 생성에 성공하였습니다.");
							apiUrlCheck = true;
						}
					}
				});
			}
			return apiUrlCheck;
		}
	
		// show Modal을 띄워주기 위함 함수
		function showModal(status) {
			$("#apiName").val($("#apiName" + status).text());
			$("#url").val($("#url" + status).text());
			$("#body").val($("#body" + status).text());
			$("#response").val($("#responseToSend" + status).text());
			$("#showModal").modal();
		}
	
		// Edit Modal을 띄워주기 위함 함수
// 		function editModal(apiName, responseToSend, url, body) {
// 			$("#editApiName").val(apiName);
// 			$("#editUrl").val(url);
// 			$("#editBody").val(body);
// 			$("#editResponseToSend").val(responseToSend);
// 			$("#editModal").modal();
// 		}
		function editModal(status) {
			$("#editApiName").val($("#apiName" + status).text());
			$("#editUrl").val($("#url" + status).text());
			$("#editBody").val($("#body" + status).text());
			$("#editResponseToSend").val($("#responseToSend" + status).text());
			$("#editModal").modal();
		}
	
		// Api 삭제여부를 확인하고 true=삭제 false=취소
		function deleteApi(data) {
			if (confirm("정말 삭제하시겠습니까??") == true) { //확인
				$.ajax({
					type : "post",
					url : "/obigoProject/deleteapi",
					dataType : "json",
					data : {
						"url" : data
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