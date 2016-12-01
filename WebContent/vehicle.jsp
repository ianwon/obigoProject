<%@page import="com.obigo.obigoproject.vo.VehicleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

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
						 <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                              <h4 class="modal-title">Default Modal Tittle</h4>
                                          </div>
                                          <div class="modal-body">

                                             <form class="form-signin" action="/obigoProject/signup" onsubmit="return check()" method="POST" >
									      	 	<h2 class="form-signin-heading">Add Vehicle</h2>
										        <div class="login-wrap">
										            <p>Enter your personal details below</p>
										            <input type="text" name="name" id="name" class="form-control" placeholder="Full Name"  autofocus required="required">
										            
										            <input type="email" name="eMail" class="form-control" placeholder="Email" autofocus required="required">
										            <input type="text" name="phone" class="form-control" placeholder="phone" autofocus required="required">
										            <p> Enter your account details below</p>
										            <input type="text" name="userId" id="userId" class="form-control" placeholder="User Id"  onkeyup="idCheck()" autofocus required="required">
										            <div id="idCheck"></div>
										            <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="required">
										            <input type="password"  id="password2" class="form-control" placeholder="Re-type Password" onkeyup="passwordCheck()" required="required">
										            <div id="passwordCheck"></div>
										            <input class="btn btn-lg btn-login btn-block" type="submit" value="SUBMIT">
										
										            <div class="registration">
										                Already Registered.
										                <a class="" href="login.jsp">
										                    Login
										                </a>
										            </div>
										
										        </div>
										
									      </form>

                                          </div>
                                          <div class="modal-footer">
                                              <button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
                                              <button class="btn btn-success" type="button">Save changes</button>
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
											<td>${v.modelmage}</td>
											<td>${v.detailImage}</td>
											<td>${v.engine}</td>
											<td>${v.mileage}</td>
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
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="js/jquery-migrate-1.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>
	<script src="js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>

	<!--script for this page only-->
	<script src="js/editable-table.js"></script>

	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			EditableTable.init();
		});
	</script>

</body>
</html>