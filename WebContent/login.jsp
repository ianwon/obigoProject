<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="shortcut icon" href="img/favicon.png">

<title>FlatLab - Flat & Responsive Bootstrap Admin Template</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='css/bootstrap-reset.css'/>" rel="stylesheet">
<!--external css-->
<link href="<c:url value='assets/font-awesome/css/font-awesome.css'/>"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="<c:url value='css/style.css'/>" rel="stylesheet">
<link href="<c:url value='css/style-responsive.css'/>" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>

<body class="login-body">

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">sign in now</h2>
			<div class="login-wrap">
				<input type="text" class="form-control" placeholder="User ID"
					autofocus name="userId" id="userId"> <input type="password"
					class="form-control" placeholder="Password" name="password"
					id="userId"> <label class="checkbox"> <input
					type="checkbox" value="remember-me"> Remember me <!-- <span class="pull-right">
						<a data-toggle="modal" href="#myModal"> Forgot Password?</a>
				</span> -->
				</label>
				<button class="btn btn-lg btn-login btn-block" id="signin"
					type="submit">Sign in</button>
				<div class="registration">
					Don't have an account yet? <a class="" href="registration.html">
						Create an account </a>
				</div>

			</div>
		</form>

	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value='/js/jquery.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>


</body>
<script type="text/javascript">
$(function() {
	$("#signin").click(function(){
		$.ajax({
			url : "logincheck",
			type : "post",
			data : {
				"userId" : $("#userId").val(),
				"password" : $("#password").val(),
			},
			dataType: json,
			success : function(data){
				alert("성공들어옴")
			},
			error : function(){
				alert("실패들어옴")
			}
		})
	});
});
</script>
</html>
