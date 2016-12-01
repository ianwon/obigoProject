<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->
			<section class="panel">
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix">
							<div class="btn-group">

								<!-- Add 버튼 -->
								<a class="btn btn-success" data-toggle="modal" href="#myModal">
									Add New <i class="fa fa-plus"></i>
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

						<!-- Add 클릭시 Modal -->
						<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title">Add Vehicle</h4>
									</div>
									<div class="modal-body">

										<form id="form-addvehicle" class="form-signin" action="/obigoProject/insertvehicle" onsubmit="return check()" method="POST">
												<input type="text" name="modelName" id="name"
													class="form-control" placeholder="Model Name" autofocus
													required="required"> 
												
												<input type="text"
													name="modelCode" class="form-control" placeholder="Model Code"
													autofocus required="required"> 
													
													
												<input type="text"
													name="modelImage" class="form-control" placeholder="Model Image"
													autofocus required="required">
												
												<input type="text" name="detailImage" id="userId"
													class="form-control" placeholder="Detail Image"
													onkeyup="idCheck()" autofocus required="required">

												<input type="text" name="engine" 
													class="form-control" placeholder="engine"
													required="required"> 
												
												<label>Year</label>&nbsp;&nbsp;&nbsp; 
												<input type="number" min="1900" max="2099" step="1" value="2016" />
													
												<input type="text" name="milage" 
													class="form-control" placeholder="milage"
													required="required"> 

										</form>

									</div>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default"
											type="button">Close</button>
										<input  class="btn btn-success" type="submit" form="form-addvehicle" value="Add Vehicle" />
									</div>
								</div>
							</div>
						</div>
						<!-- Modal End -->


						<div class="table-responsive">

							<table class="table table-striped table-hover table-bordered"
								id="editable-sample">
								<thead>
									<tr>
										<th>Model Name</th>
										<th>Model Code</th>
										<th>Model Image</th>
										<th>Detail Image</th>
										<th>Engine</th>
										<th>Mileage</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="v" items="${vehicleList}" begin="0">
										<tr class="">
											<td>${v.modelName}</td>
											<td>${v.modelCode}</td>
											<td>${v.modelImage}</td>
											<td>${v.detailImage}</td>
											<td>${v.engine}</td>
											<td>${v.milage}</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
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
	<script class="include" type="text/javascript"
		src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="/obigoProject/assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="/obigoProject/assets/data-tables/DT_bootstrap.js"></script>
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