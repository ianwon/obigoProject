<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">
<title>Bundle Management Page</title>
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
					<header class="panel-heading">
						<h1>NOW VERSION : ${bundleVersion}</h1>
						BUNDLES
					</header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<a id="Add" class="btn btn-success" data-toggle="modal" href="#addModal"> Add Bundle <i class="fa fa-plus"></i>
									</a>
								</div>

								<!-- -------------- Add Bundle Modal start -------------- -->
								<div class="modal fade " id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add Bundle</h4>
											</div>
											<div class="modal-body">
												<form id="form-addbundle" enctype="multipart/form-data" class="form-signin" action="/obigoProject/insertbundle" onsubmit="return (check() && sizeCheck('bundleFile'));"
													method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">Bundle Name</span>
															<input type="text" name="bundleName" class="form-control" placeholder="BundleName" autofocus required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">Bundle Version</span>
															<input type="text" name="bundleVersion" id="bundleversion" class="form-control" onkeyup="bundleversionCheck()" placeholder="BundleVersion" required="required">
															<div id=bundleversioncheck></div>
														</div>
														<div class="form-group">
															<span class="label label-primary">Bundle File</span>
															<input type="file" id="bundleFile" name="bundleFile" class="form-control" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">Developer</span>
															<input type="text" name="developer" class="form-control" placeholder="Developer" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">Bundle Key</span>
															<input type="text" name="bundleKey" id="bundlekey" class="form-control" onkeyup="bundlekeyCheck()" placeholder="BundleKey" required="required">
															<div id=bundlekeycheck></div>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-addbundle" value="Registration">
											</div>
										</div>
									</div>
								</div>
								<!-- -------------- Add Bundle Modal end -------------- -->

								<!-- -------------- Edit Bundle Modal start -------------- -->
								<div class="modal fade " id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Update Bundle</h4>
											</div>
											<div class="modal-body">
												<form id="form-update" class="form-signin" action="/obigoProject/updatebundle" method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">Bundle Name</span>
															<input type="text" name="bundleName" id="editbundlename" class="form-control" autofocus>
														</div>
														<div class="form-group">
															<span class="label label-primary">Bundle Version</span>
															<input type="text" name="bundleVersion" id="editbundleversion" class="form-control" readonly="readonly" value="${bundleVersion}">
														</div>
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
								<!-- -------------- Edit Bundle Modal end -------------- -->
							</div>
							<!-- table 자동정렬해주는 javascript 파일에서 어느 항목의 table인지 구분하기 위한 hidden -->
							<input type="hidden" id="hidden-bundle">
							<div class="space15"></div>

							<!-- -------------- Bundle Table start -------------- -->
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>BUNDLENAME</th>
											<th>BUNDLEVERSION</th>
											<th>FILEUPLOAD</th>
											<th>DEVELOPER</th>
											<th>BUNDLEKEY</th>
											<th>EDIT</th>
											<th>DELETE</th>
											<th>APPLY</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="b" items="${bundleList}" begin="0">
											<tr class="">
												<td>${b.bundleName}</td>
												<td>${b.bundleVersion}</td>
												<td>${b.fileUpload}</td>
												<td>${b.developer}</td>
												<td>${b.bundleKey}</td>
												<td><a class="update" href="javascript:update('${b.bundleName}','${b.bundleVersion}')">Edit</a></td>
												<td><a class="del" href="javascript:del('${b.bundleVersion}')">Delete</a></td>
												<td><a class="accept" href="javascript:apply('${b.bundleVersion}')">Apply</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- -------------- Bundle Table end -------------- -->
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
		$('#form-addbundle').submit(function() {
			$(this).find('input:text').each(function() {
				$(this).val($.trim($(this).val()));
			});
		});

		function sizeCheck(name) {
			var size = document.getElementById(name).files[0].size;
			if (size > 100000000) {
				alert("100000000byte 이하의 파일만 가능합니다.")
				return false;
			} else {
				return true;
			}
		}

		// Bundle version 체크
		function bundleversionCheck() {

			var bundleVersion = $("#bundleversion").val();

			// 공백인 상태로 다른 input으로 focus가 옮겨갈 경우 아무런 상태메시지도 보여주지 않는다
			if (bundleVersion != "") {
				$.ajax({
					type : "post",
					url : "/obigoProject/bundleversioncheck",
					dataType : "json",
					data : {
						"bundleVersion" : $("#bundleversion").val()
					},
					success : function(data) {
						if (data.flag == false) {
							$("#bundleversioncheck").html("이미 존재하는 버전 입니다.");
							$("#bundleversioncheck").css("color", "red");
						} else {
							$("#bundleversioncheck").html("등록가능한 버전 입니다.");
							$("#bundleversioncheck").css("color", "blue");
						}
					}
				});
			}
		}

		// Bundle key 체크
		function bundlekeyCheck() {
			var bundleKey = $("#bundlekey").val();

			// 공백인 상태로 다른 input으로 focus가 옮겨갈 경우 아무런 상태메시지도 보여주지 않는다
			if (bundleKey != "") {
				$.ajax({
					type : "post",
					url : "/obigoProject/bundlekeycheck",
					dataType : "json",
					data : {
						"bundleKey" : $("#bundlekey").val()
					},
					success : function(data) {
						if (data.flag == false) {
							$("#bundlekeycheck").html("이미 존재하는 키 입니다.");
							$("#bundlekeycheck").css("color", "red");
						} else {
							$("#bundlekeycheck").html("등록가능한 키 입니다.");
							$("#bundlekeycheck").css("color", "blue");
						}
					}
				});
			}
		}

		// Bundle 삭제
		function del(data) {
			if (confirm("삭제 하시겠습니까?") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/deletebundle",
					dataType : "json",
					data : {
						"bundleVersion" : data
					},
					success : function(data) {
						if (data.flag == true)
							location.reload();
						else
							alert("삭제할 수 없습니다");
					}
				});

			}
		}

		// Bundle 수정 Modal을 띄워주는 함수
		function update(bundleName, bundleVersion) {
			$("#editbundlename").val(bundleName);
			$("#editbundleversion").val(bundleVersion);
			$("#editModal").modal();
		}

		// Bundle의 version과 key가 등록가능한 조건을 만족하는지 여부를 체크한 후 등록 진행
		function check() {
			if ($("#bundleversioncheck").html() == "등록가능한 버전 입니다."
					&& $("#bundlekeycheck").html() == "등록가능한 키 입니다.") {
				return true;
			} else {
				alert("버전과 키를 확인해 주세요;");
				return false;
			}
		}

		// 선택한 Bundle version을 app에 적용하는 함수
		function apply(data) {
			if (confirm("선택한 버전을 적용하시겠습니까?") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/applybundle",
					dataType : "json",
					data : {
						"bundleVersion" : data
					},
					success : function(data) {
						location.reload();
					}
				});

			}
		}
	</script>


</body>
</html>
