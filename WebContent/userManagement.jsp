<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<title>Editable Table</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/data-tables/DT_bootstrap.css" />

<!--right slidebar-->
<link href="css/slidebars.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
		<jsp:include page="header.jsp"></jsp:include>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> Editable Table </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<button id="editable-sample_new" class="btn green">
										Add New <i class="fa fa-plus"></i>
									</button>
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

							<div class="table-responsive">

								<table class="table table-striped table-hover table-bordered"
									id="editable-sample">
									<thead>
										<tr>
											<th>Username</th>
											<th>Full Name</th>
											<th>Points</th>
											<th>Notes</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<tr class="">
											<td>Jondi Rose</td>
											<td>Alfred Jondi Rose</td>
											<td>1234</td>
											<td class="center">super user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Dulal</td>
											<td>Jonathan Smith</td>
											<td>434</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Sumon</td>
											<td>Sumon Ahmed</td>
											<td>232</td>
											<td class="center">super user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>vectorlab</td>
											<td>dk mosa</td>
											<td>132</td>
											<td class="center">elite user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Admin</td>
											<td>Flat Lab</td>
											<td>462</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Rafiqul</td>
											<td>Rafiqul dulal</td>
											<td>62</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Jhon Doe</td>
											<td>Jhon Doe</td>
											<td>1234</td>
											<td class="center">super user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Dulal</td>
											<td>Jonathan Smith</td>
											<td>434</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Sumon</td>
											<td>Sumon Ahmed</td>
											<td>232</td>
											<td class="center">super user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>vectorlab</td>
											<td>dk mosa</td>
											<td>132</td>
											<td class="center">elite user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Admin</td>
											<td>Flat Lab</td>
											<td>462</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
										<tr class="">
											<td>Rafiqul</td>
											<td>Rafiqul dulal</td>
											<td>62</td>
											<td class="center">new user</td>
											<td><a class="edit" href="javascript:;">Edit</a></td>
											<td><a class="delete" href="javascript:;">Delete</a></td>
										</tr>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</section>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="footer.jsp"></jsp:include>
		<!--footer end-->

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
    