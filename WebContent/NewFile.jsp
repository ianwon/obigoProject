<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<title>Chartjs</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
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

	<div class="col-lg-6">
		<section class="panel">
			<header class="panel-heading"> Doughnut </header>
			<div class="panel-body text-center">
				<canvas id="doughnut" height="300" width="400"></canvas>
			</div>
		</section>
	</div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<!--<script src="js/jquery-1.8.3.min.js"></script>-->
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/chart-master/Chart.js"></script>
	<script src="js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>

	<!-- script for this page only-->
<!-- 	<script src="js/all-chartjs.js"></script> -->

	<script type="text/javascript">
	function bcd(a) {


	    var doughnutData = [
	        {
	            value: a,
	            color:"#F7464A"
	        },
	        {
	            value : 50,
	            color : "#46BFBD"
	        },
	        {
	            value : 100,
	            color : "#FDB45C"
	        },
	        {
	            value : 40,
	            color : "#949FB1"
	        },
	        {
	            value : 120,
	            color : "#4D5360"
	        }

	    ];
	    new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(doughnutData);
	}();
	
	
	</script>
</body>
</html>