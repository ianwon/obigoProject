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

	<!--  header file include -->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>


	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->
			<section class="panel">
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix">
							<div class="btn-group">

								<!-- Vehicle Add 버튼 -->
								<a class="btn btn-success" data-toggle="modal" href="#modalAdd"> Add New <i class="fa fa-plus"></i>
								</a>

							</div>
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									Tools <i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right">
									<li><a href="#">Print</a></li>
									<li><a href="#">Save as PDF</a></li>
									<li><a href="#">Export to Excel</a></li>
								</ul>
							</div>
						</div>
						<div class="space15"></div>

						<!-- Add 클릭시 띄워지는 Modal -->
						<div class="modal fade " id="modalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title">Add Vehicle</h4>
									</div>
									<div class="modal-body">

										<form id="form-addvehicle" class="form-signin" action="/obigoProject/insertvehicle" onsubmit="return addVehicleCheck();" method="POST">
											<input type="text" id="modelName" name="modelName" class="form-control" placeholder="Model Name" autofocus required="required">
											<input type="text" id="modelCode" name="modelCode" class="form-control" placeholder="Model Code" autofocus required="required">
											<input type="text" id="modelImage" name="modelImage" class="form-control" placeholder="Model Image" autofocus required="required">
											<input type="text" id="detailImage" name="detailImage" class="form-control" placeholder="Detail Image" autofocus required="required">
											<input type="text" id="engine" name="engine" class="form-control" placeholder="Engine" required="required">
											<input type="number" id="modelYear" name="modelYear" min="1900" max="2099" step="1" value="2016" />
											<input type="text" id="milage" name="milage" class="form-control" placeholder="Milage" required="required">
										</form>

									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
										<input type="submit" class="btn btn-success" form="form-addvehicle" value="Add Vehicle">
									</div>
								</div>
							</div>
						</div>
						<!-- Modal End -->


						<!-- Edit 클릭시 띄워지는 Modal -->
						<div class="modal fade " id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title">Edit Vehicle</h4>
									</div>
									<div class="modal-body">

										<form id="form-editvehicle" class="form-signin" action="/obigoProject/updatevehicle" method="POST">
											<input type="text" id="editModelName" name="modelName" class="form-control" placeholder="Model Name" readonly="readonly">
											<input type="text" id="editModelCode" name="modelCode" class="form-control" placeholder="Model Code" readonly="readonly">
											<input type="text" id="editModelImage" name="modelImage" class="form-control" placeholder="Model Image" required="required">
											<input type="text" id="editDetailImage" name="detailImage" class="form-control" placeholder="Detail Image" required="required">
											<input type="text" id="editEngine" name="engine" class="form-control" placeholder="Engine" required="required" readonly="readonly">
											<input type="number" id="editModelYear" name="modelYear" min="1900" max="2099" step="1" value="2016" readonly="readonly">
											<input type="text" id="editMilage" name="milage" class="form-control" placeholder="Milage" readonly="readonly" readonly="readonly">
										</form>

									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
										<input type="submit" class="btn btn-success" form="form-editvehicle" value="Edit Vehicle">
									</div>
								</div>
							</div>
						</div>
						<!-- Edit Modal End -->



						<!-- Vehicle List를 보여주는 Table -->
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
											<td>${vehicle.milage}</td>
											<td><a data-toggle="modal" href="javascript:callEditModal('${vehicle.modelCode}');">Edit</a></td>
											<td><a href="javascript:deleteVehicleTr('${vehicle.modelCode}');">Delete</a></td>
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
		function callEditModal(modelCode) {

			$("#editModelName").val(
					$("#vehicle" + modelCode).children().eq(0).text());
			$("#editModelCode").val(
					$("#vehicle" + modelCode).children().eq(1).text());
			$("#editModelImage").val(
					$("#vehicle" + modelCode).children().eq(2).text());
			$("#editDetailImage").val(
					$("#vehicle" + modelCode).children().eq(3).text());
			$("#editEngine").val(
					$("#vehicle" + modelCode).children().eq(4).text());
			$("#editModelYear").val(
					$("#vehicle" + modelCode).children().eq(5).text());
			$("#editMilage").val(
					$("#vehicle" + modelCode).children().eq(6).text());

			$("#modalEdit").modal("toggle");

		}

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
						if (data.flag == true) {
							$("#vehicle" + modelCode).remove();
						}
					}
				});
			}

		}

		function addVehicleCheck() {

			var checkModelCode = false;
			
			
			$.ajax({
				type : "post",
				url : "/obigoProject/checkmodelcode",
				dataType : "json",
				data : {
					"modelCode" : $("#modelCode").val()
				},
				success : function(data) {
					if (data.flag == true) {
						// 동일한 Model Code가 DB에 존재하지 않으므로 자동차를 등록할 수 있다
						return true;
					} else {
						// 동일한 Model Code가 이미 DB에 존재하므로 자동차를 등록할 수 없다
						alert("동일한 Model Code가 이미 존재합니다!");
						return false;
						
					} 
// 			alert(data.flag);
				}
			});
			
		/* 	if(checkModelCode)
				return true;
			else
				return false; */
		
		}
	</script>


</body>
</html>