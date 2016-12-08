<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resource Management Page</title>
</head>
<body>
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> RESOURCE </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<button id="Add" class="btn green" data-toggle="modal" href="#addModal">
										Add Resource <i class="fa fa-plus"></i>
									</button>
								</div>
								<!--modal start-->
								<!-- Add Resource 눌렀을때 모달창 -->
								<!-- Modal -->
								<div class="modal fade " id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add Resource</h4>
											</div>
											<div class="modal-body">
												<form id="form-addresource" action="/obigoProject/insertresource" class="form-signin" onsubmit="addresource()" method="POST">
													<div class="login-wrap">
														<input type="text" name="resourceName" class="form-control" placeholder="ResourceName" autofocus required="required">
														<input type="text" name="path" class="form-control" placeholder="Path" autofocus required="required">
														<input type="text" name="resourceVersion" class="form-control" placeholder="ResourceVersion" autofocus required="required">
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-addresource" value="Registration">
											</div>
										</div>
									</div>
								</div>
								<!-- modal -->
								<!--
								edit눌렀을때 모달창
								  -->
								<div class="modal fade " id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Update Bundle</h4>
											</div>
											<div class="modal-body">
												<form id="form-update" class="form-signin" action="/obigoProject/updateresource" method="POST">
													<div class="login-wrap">
														<input type="hidden" name="resourceNumber" id="editresourcenumber" class="form-control" autofocus>
														<input type="text" name="resourceName" id="editresourcename" class="form-control" autofocus required>
														<input type="file" name="path" id="editpath" class="form-control" autofocus required>
														<input type="text" name="resourceVersion" id="editresourceversion" class="form-control" autofocus required>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-update" value="Update">
											</div>
										</div>
									</div>
								</div>
								<!-- modal -->
								<!-- Modal -->
							</div>
							<br>
							<div class="space15"></div>
							<div class="bundleList">
								<form action="/obigoProject/resource">
									<select id=selectbundle name="bundleKey">
										<option value="">Select BundleVersion</option>
										<c:forEach var="b" items="${bundleList}" begin="0">
											<option value="${b.bundleKey}">Bundle Name : ${b.bundleName}, Bundle Version : ${b.bundleVersion}</option>
										</c:forEach>
									</select>
									<input type="submit" value="검색">
								</form>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>RESOURCENAME</th>
											<th>PATH</th>
											<th>RESOURCEVERSION</th>
											<th>BUNDLEKEY</th>
											<th>EDIT</th>
											<th>DELETE</th>
										</tr>
									</thead>
									<tbody id=rewource>
										<c:forEach var="r" items="${resourceList}" begin="0">
											<tr class="">
												<td>${r.resourceName}</td>
												<td>${r.path}</td>
												<td>${r.resourceVersion}</td>
												<td>${r.bundleKey}</td>
												<td><a class="update" href="javascript:update('${r.resourceNumber}','${r.resourceName}','${r.path}','${r.resourceVersion}')">Edit</a></td>
												<td><a class="del" href="javascript:resdel('${r.resourceNumber}')">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</section>
				<!-- page end-->
			</section>
		</section>
		<!-- modal -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->
	</section>
	<script type="text/javascript">
		//추가모달창
		function addresource() {
			var select = $("#selectbundle").val();
			var text = "";
			text += "<input type='hidden' name='bundleKey' value=" + select + ">";
			$("#form-addresource").append(text);
		}
		//수정모달창
		function update(resourceNumber, resourceName, path, resourceVersion) {
			$("#editresourcenumber").val(resourceNumber);
			$("#editresourcename").val(resourceName);
			$("#editresourceversion").val(resourceVersion);
			$("#editModal").modal();
		}
	
		function resdel(data) {
			if (confirm("선택한 리소스를 삭제하시겠습니까?") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/deleteresource",
					dataType : "json",
					async : false,
					data : {
						"resourceNumber" : data
					},
					success : function(resource) {
						if (resource.flag == true) {
							alert("삭제되었습니다.");
							location.reload();
						}
						else
							alert("삭제를 실패하였습니다.");
					}
				})
			}
		}
	</script>

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


</body>
</html>
