<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.obigo.obigoproject.vo.VehicleVO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle</title>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->
			<section class="panel">
				<header class="panel-heading"> VEHICLE </header>
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix">
							<div class="btn-group">

								<!-- Vehicle Add 버튼 -->
								<a class="btn btn-success" data-toggle="modal" href="#modalAdd"> Add Vehicle <i class="fa fa-plus"></i>
								</a>

							</div>
						</div>
						<div class="space15"></div>

						<!-- -------------- Add Vehicle Modal start -------------- -->
						<div class="modal fade " id="modalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title">Add Vehicle</h4>
									</div>
									<div class="modal-body">

										<form id="form-addvehicle" enctype="multipart/form-data" class="form-signin" action="/obigoProject/insertvehicle" onsubmit="return addVehicleCheck();" method="POST">
											<div class="form-group">
												<span class="label label-primary">MODEL NAME</span>
												<input type="text" id="modelName" name="modelName" class="form-control" placeholder="Model Name" autofocus required="required">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL CODE</span>
												<input type="text" id="modelCode" name="modelCode" class="form-control" placeholder="Model Code" autofocus required="required">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL IMAGE</span>
												<input type="file" id="model_Image" name="model_Image" class="form-control" placeholder="Model Image" autofocus required="required">
											</div>
											<div class="form-group">
												<span class="label label-primary">DETAIL IMAGE</span>
												<input type="file" id="detail_Image" name="detail_Image" class="form-control" placeholder="Detail Image" autofocus required="required">
											</div>
											<div class="form-group">
												<span class="label label-primary">ENGINE</span>
												<input type="text" id="engine" name="engine" class="form-control" placeholder="Engine" required="required">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL YEAR</span>
												<input type="number" id="modelYear" name="modelYear" class="form-control" min="1900" max="2099" step="1" value="2016" />
											</div>
											<div class="form-group">
												<span class="label label-primary">MILEAGE</span>
												<input type="text" id="mileage" name="mileage" class="form-control" placeholder="mileage" required="required">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
										<input type="submit" class="btn btn-success" form="form-addvehicle" value="Add Vehicle">
									</div>
								</div>
							</div>
						</div>
						<!-- -------------- Add Vehicle Modal end -------------- -->

						<!-- -------------- Edit Vehicle Modal start -------------- -->
						<div class="modal fade " id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title">Update Vehicle</h4>
									</div>
									<div class="modal-body">
										<form id="form-editvehicle" enctype="multipart/form-data" class="form-signin" action="/obigoProject/updatevehicle" method="POST">
											<div class="form-group">
												<span class="label label-primary">MODEL NAME</span>
												<input type="text" id="editModelName" name="modelName" class="form-control" placeholder="Model Name" readonly="readonly">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL CODE</span>
												<input type="text" id="editModelCode" name="modelCode" class="form-control" placeholder="Model Code" readonly="readonly">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL IMAGE</span>
												<input type="file" id="editModelImage" name="model_Image" class="form-control" placeholder="Model Image">
											</div>
											<div class="form-group">
												<span class="label label-primary">DETAIL IMAGE</span>
												<input type="file" id="editDetailImage" name="detail_Image" class="form-control" placeholder="Detail Image">
											</div>
											<div class="form-group">
												<span class="label label-primary">ENGINE</span>
												<input type="text" id="editEngine" name="engine" class="form-control" placeholder="Engine" required="required" readonly="readonly">
											</div>
											<div class="form-group">
												<span class="label label-primary">MODEL YEAR</span>
												<input type="number" id="editModelYear" name="modelYear" class="form-control" min="1900" max="2099" step="1" value="2016" readonly="readonly">
											</div>
											<div class="form-group">
												<span class="label label-primary">MILEAGE</span>
												<input type="text" id="editMileage" name="mileage" class="form-control" placeholder="mileage" readonly="readonly" readonly="readonly">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
										<input type="submit" class="btn btn-success" form="form-editvehicle" value="Edit Vehicle">
									</div>
								</div>
							</div>
						</div>
						<!-- -------------- Edit Vehicle Modal end -------------- -->

						<!-- -------------- Vehicle Table start -------------- -->
						<div class="table-responsive">
							<table class="table table-striped table-hover table-bordered" id="editable-sample">
								<thead>
									<tr>
										<th>Model Name</th>
										<th>Model Code</th>
										<th>Model Image</th>
										<th>Detail Image</th>
										<th>Engine</th>
										<th>Model Year</th>
										<th>Mileage</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="vehicle" items="${vehicleList}" begin="0">
										<tr class="" id="vehicle${vehicle.modelCode}">
											<td>${vehicle.modelName}</td>
											<td>${vehicle.modelCode}</td>
											<td>${vehicle.modelImage}</td>
											<td>${vehicle.detailImage}</td>
											<td>${vehicle.engine}</td>
											<td>${vehicle.modelYear}</td>
											<td>${vehicle.mileage}</td>
											<td><a href="javascript:callEditModal('${vehicle.modelCode}');">Edit</a></td>
											<td><a href="javascript:deleteVehicleTr('${vehicle.modelCode}');">Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- -------------- Vehicle Table end -------------- -->
					</div>
				</div>
			</section>
			<!-- page end-->
		</section>
	</section>

	<jsp:include page="/jsp/header/footer.jsp"></jsp:include>

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
		// Edit Modal 폼을 띄울때 해당 되는 데이터를 Modal에 넣어주는 함수
		function callEditModal(modelCode) {
			$("#editModelName").val(
					$("#vehicle" + modelCode).children().eq(0).text());
			$("#editModelCode").val(
					$("#vehicle" + modelCode).children().eq(1).text());
			$("#editEngine").val(
					$("#vehicle" + modelCode).children().eq(4).text());
			$("#editModelYear").val(
					$("#vehicle" + modelCode).children().eq(5).text());
			$("#editMileage").val(
					$("#vehicle" + modelCode).children().eq(6).text());
			$("#modalEdit").modal("toggle");
		}

		// input에 입력된 값으로 공백이 존재하는지 체크
		function spaceCheck(frm) {
			var f = frm.val();
			var pattern = /\s/;

			if (f.match(pattern)) {
				alert("Model Code에 공백이 있으면 안됩니다!");
				frm.focus();
				return false;
			} else {
				return true;
			}

		}
		
		// 삭제 여부를 묻고 AJAX를 통해서 차량을 삭제하는 함수
		function deleteVehicleTr(modelCode) {
			if (confirm("삭제 하시겠습니까?") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/deletevehicle",
					dataType : "json",
					data : {
						"modelCode" : modelCode
					},
					success : function(data) {
						location.reload();
					}
				});
			} else {
				return;
			}
		}

		// 차량 등록 폼에서 AJAX로 Model Code 비교후 등록을 수행하는 함수
		function addVehicleCheck() {
			var checkModelCode = false;
			$.ajax({
				type : "post",
				url : "/obigoProject/checkmodelcode",
				dataType : "json",
				async : false,
				data : {
					"modelCode" : $("#modelCode").val()
				},
				success : function(data) {
					if (data.flag == true) {
						// Model Code에 공백이 존재하는지 체크
						if (spaceCheck($("#modelCode")) == true) {
							// 동일한 Model Code가 DB에 존재하지 않으므로 자동차를 등록할 수 있다
							checkModelCode = true;
						} else {
							checkModelCode = false;
						}
					} else {
						// 동일한 Model Code가 이미 DB에 존재하므로 자동차를 등록할 수 없다
						alert("동일한 Model Code가 이미 존재합니다!");

					}
				}
			});
			return checkModelCode;
		}
	</script>

</body>
</html>