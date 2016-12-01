<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper site-min-height">
			<!-- page start-->

			<h1>superwyh</h1>

			<!-- page end-->
		</section>
	</section>
	<!--main content end-->
	<jsp:include page="/footer.jsp"></jsp:include>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/js/jquery.scrollTo.min.js"></script>
	<script src="/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/js/jquery.sparkline.js" type="text/javascript"></script>
	<script src="/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="/js/owl.carousel.js"></script>
	<script src="/js/jquery.customSelect.min.js"></script>
	<script src="/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="/js/sparkline-chart.js"></script>
	<script src="/js/easy-pie-chart.js"></script>
	<script src="/js/count.js"></script>
</body>
</html>