<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Api</title>
</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

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

								<!--modal start-->
								<!-- ---------------insert modal start--------------- -->
								<!-- Modal -->
								<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add Api</h4>
											</div>
											<div class="modal-body">
												<form class="form-insertapi" id="form-insertapi" action="/obigoProject/insertapi" onsubmit="return check();" method="POST">
													<h2 class="form-signin-heading">Add API</h2>
													<div class="login-wrap">
														<span class="label label-primary">API NAME</span>
														<input type="text" name="apiName" id="insertApiName" class="form-control" placeholder="API NAME" autofocus required="required">
														<span class="label label-primary">RESPONSE TO SEND</span>
														<textarea name="responseToSend" class="form-control" placeholder="Response To Send" rows="15" cols="45" required="required"></textarea>
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
								<!-- modal -->
								<!-- ---------------insert modal start--------------- -->


								<!-- ---------------edit modal start--------------- -->
								<!-- Modal -->
								<div class="modal fade " id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Edit Api</h4>
											</div>
											<div class="modal-body">
												<form class="form-editapi" id="form-editapi" action="/obigoProject/updateapi" method="POST">
													<h2 class="form-signin-heading">Add API</h2>
													<div class="login-wrap">
														<span class="label label-primary">API NAME</span>
														<input type="text" name="ApiName" id="editApiName" class="form-control" placeholder="API NAME" autofocus required="required" readonly="readonly">
														<span class="label label-primary">RESPONSE TO SEND</span>
														<textarea name="ResponseToSend" id="editResponseToSend" class="form-control" placeholder="Response To Send" rows="15" cols="45" required="required"></textarea>
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
								<!-- Modal -->
								<!-- ---------------edit modal end--------------- -->

								<!-- api table start -->
							</div>
							<div class="space15"></div>
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>Api Name</th>
											<th>Response To Send</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${apiList}" begin="0">
											<tr class="">
												<td>${a.apiName}</td>
												<td class="center">${a.responseToSend}</td>
												<td><a class="Edit" href="javascript:editModal('${a.apiName}','${a.responseToSend}');">Edit</a></td>
												<td><a class="Delete" href="javascript:deleteApi(${a.apiName});">Delete</a></td>
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
	
		//apiName의 존재 여부를 확인
		function check() {
			var apiNameCheck = false;
			$.ajax({
				type : "post",
				url : "/obigoProject/apinamecheck",
				dataType : "json",
				async : false,
				data : {
					"apiName" : $("#insertApiName").val()
				},
				success : function(data) {
					if (data.flag === false) {
						alert("존재하는 Api Name입니다.");
					} else {
						alert("Api 생성에 성공하였습니다.");
						apiNameCheck = true;
					}
				}
			});
			return apiNameCheck;
		}
	
	
		//editModal을 띄워주기 위함 함수
		function editModal(apiName, responseToSend) {
			$("#editApiName").val(apiName);
			$("#editResponseToSend").val(responseToSend);
			$("#editModal").modal();
		}
	
		//api 삭제여부를 확인하고 true=삭제 false=취소
		function deleteApi(data) {
			if (confirm("정말 삭제하시겠습니까??") == true) { //확인
				$.ajax({
					type : "post",
					url : "/obigoProject/deleteapi",
					dataType : "json",
					data : {
						"apiName" : data
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
