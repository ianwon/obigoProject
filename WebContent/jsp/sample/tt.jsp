<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/obigoProject/css/bootstrap.min.css" rel="stylesheet">
<link href="/obigoProject/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="/obigoProject/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="/obigoProject/assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
<!--right slidebar-->
<link href="/obigoProject/css/slidebars.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/obigoProject/css/style.css" rel="stylesheet">
<link href="/obigoProject/css/style-responsive.css" rel="stylesheet" />
<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" />
<!--     <link href="/obigoProject/assets/morris.js-0.4.3/morris.css" rel="stylesheet" /> -->
</head>
<body>
	<div id="hero-bar" class="graph"></div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/obigoProject/js/jquery-migrate-1.2.1.min.js"></script>
	<!--<script src="js/jquery-1.8.3.min.js"></script>-->
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
	<script src="/obigoProject/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
	<script src="/obigoProject/js/respond.min.js"></script>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<script type="text/javascript">
	
		var table = null;
		$(document).ready(
			function() {
				// User 통계 Page가 처음 loading 되었을 때
				setUp(<c:out value="${userAnalytics}" />);
			});
		function setUp(data) {
			$(function() {
				Morris.Bar({
					element : 'hero-bar',
					resize : true,
					data : [ {
						device : 'JAN',
						geekbench : data[0]
					}, {
						device : 'FEB',
						geekbench : data[1]
					}, {
						device : 'MAR',
						geekbench : data[2]
					}, {
						device : 'APR',
						geekbench : data[3]
					}, {
						device : 'MAY',
						geekbench : data[4]
					}, {
						device : 'JUN',
						geekbench : data[5]
					}, {
						device : 'JUL',
						geekbench : data[6]
					}, {
						device : 'AUG',
						geekbench : data[7]
					}, {
						device : 'SEP',
						geekbench : data[8]
					}, {
						device : 'OCT',
						geekbench : data[9]
					}, {
						device : 'NOV',
						geekbench : data[10]
					}, {
						device : 'DEC',
						geekbench : data[11]
					}, ],
					xkey : 'device',
					ykeys : [ 'geekbench' ],
					labels : [ 'Geekbench' ],
					barRatio : 0.4,
					xLabelAngle : 0,
					hideHover : 'auto',
					barColors : [ '#6883a3' ]
				});
			});
		}
		;
	</script>
</body>
</html>