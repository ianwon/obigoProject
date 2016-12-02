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
									<form class="cmxform form-horizontal tasi-form" id="commentForm" method="get" action="">
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">Message Subject (required)</label>
											<div class="col-lg-10">
												<input class=" form-control" id="cname" name="name" minlength="2" type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="ccomment" class="control-label col-lg-2">Body (required)</label>
											<div class="col-lg-10">
												<textarea class="form-control " id="ccomment" name="comment" required></textarea>
											</div>
										</div>
										
										<div class="form-group">
                                          <label class="control-label col-md-2">File Upload</label>
                                          <div class="col-md-4">
                                              <input type="file" class="default" />
                                          </div>
                                      </div>

										
										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-10">
												<button class="btn btn-danger" type="submit">Send</button>
												<button class="btn btn-default" type="button">Cancel</button>
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
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="js/respond.min.js"></script>

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


	<!--summernote-->
	<script src="/obigoProject/assets/summernote/dist/summernote.min.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--this page  script only-->
	<script src="/obigoProject/js/advanced-form-components.js"></script>
	<script src="js/form-validation-script.js"></script>

	<script>
		jQuery(document).ready(function() {

			$('.summernote').summernote({
				height : 200, // set editor height

				minHeight : null, // set minimum height of editor
				maxHeight : null, // set maximum height of editor

				focus : true
			// set focus to editable area after initializing summernote
			});
		});
	</script>

</body>
</html>