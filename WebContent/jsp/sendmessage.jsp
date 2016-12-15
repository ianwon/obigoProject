<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-timepicker/compiled/timepicker.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-colorpicker/css/colorpicker.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="/obigoProject/assets/jquery-multi-select/css/multi-select.css" />

<!--  summernote -->
<link href="/obigoProject/assets/summernote/dist/summernote.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>


	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">

				<div class="row">
					<div class="col-lg-8">
						<section class="panel">
							<header class="panel-heading"> Send Pushmessage </header>
							<div class="panel-body">
								<div class=" form">
									<form class="cmxform form-horizontal tasi-form" id="commentForm" method="post" action="/obigoProject/sendtextmessage">
										<div class="form-group ">
												&nbsp;&nbsp;&nbsp; <label>Category : </label>
												<select id=selectcategory name="categoryNumber">
													<option value="">Select Category</option>
													<c:forEach var="c" items="${messagecategory}" begin="0">
														<option value="${c.categoryNumber}">Category Name : ${c.categoryName}</option>
													</c:forEach>
												</select>
												&nbsp;&nbsp;&nbsp; <label>Location : </label>
												<select id=selectlocation name="location">
													<option value="">Select Location</option>
													<c:forEach var="l" items="${locationList}" begin="0">
														<option value="${l.location}">Location : ${l.location}</option>
													</c:forEach>
												</select>
												&nbsp;&nbsp;&nbsp; <label>Model : </label>
												<select id=selectmodel name="modelName">
													<option value="">Select Model</option>
													<c:forEach var="m" items="${modelList}" begin="0">
														<option value="${m.modelName}">ModelName : ${m.modelName}</option>
													</c:forEach>
												</select>
										</div>
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">Message Subject (required)</label>
											<div class="col-lg-10">
												<input class=" form-control" id="cname" name="title" minlength="2" type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="ccomment" class="control-label col-lg-2">Body (required)</label>
											<div class="col-lg-10">
												<textarea class="form-control " id="ccomment" name="content" required></textarea>
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-md-2">File Upload</label>
											<div class="col-md-4">
												<input type="file" class="default" name="uploadFile" />
											</div>
										</div>


										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-10">
												<button class="btn btn-danger" type="submit">Send</button>
												<!-- 												<button class="btn btn-default" type="button">Cancel</button> -->
											</div>
										</div>

									</form>
								</div>

							</div>
						</section>
					</div>
				</div>



			</section>
		</section>
		<!--main content end-->

		<!--footer start-->
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->

	</section>


	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script type="text/javascript" src="/obigoProject/js/jquery.nicescroll.js"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<!--this page plugins-->

	<script type="text/javascript" src="/obigoProject/assets/fuelux/js/spinner.min.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/jquery-multi-select/js/jquery.multi-select.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/jquery-multi-select/js/jquery.quicksearch.js"></script>


	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--this page  script only-->
	<script src="/obigoProject/js/advanced-form-components.js"></script>


</body>
</html>