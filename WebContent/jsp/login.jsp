<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="/obigoProject/css/bootstrap.min.css" rel="stylesheet">
<link href="/obigoProject/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="/obigoProject/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="/obigoProject/css/style.css" rel="stylesheet">
<link href="/obigoProject/css/style-responsive.css" rel="stylesheet" />

</head>

<body class="login-body">

	<div class="container">

		<form class="form-signin" action="/obigoProject/logincheck" onsubmit="return passwordCheck()" method="POST">
			<h2 class="form-signin-heading">sign in now</h2>
			<div class="login-wrap">
				<input type="text" class="form-control" placeholder="User ID" autofocus name="userId" id="userId">
				<input type="password" class="form-control" placeholder="Password" name="password">
				<label class="checkbox"> <input type="checkbox" value="remember-me"> Remember me
				</label>
				<input class="btn btn-lg btn-login btn-block" type="submit" value="Sign in">
				<div class="registration">
					Don't have an account yet? <a class="" href="/obigoProject/registration"> Create an account </a>
				</div>

			</div>


		</form>

	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script type="text/javascript">
    </script>


	<script type="text/javascript">
	
		//로그인시 아이디의 존재여부 확인하는 함수
		function idCheck() {
			$.ajax({
				type : "post",
				url : "/obigoProject/idcheck",
				dataType : "json",
				data : {
					"userId" : $("#userId").val(),
					"password" : $("#password").val()
				},
				success : function(data) {
					if (data.flag == false) {
						return true;
					} else {
						alert("존재하지 않는 아이디 입니다.");
						return false;
					}
				}
			});
		}
	
		function passwordCheck() {
			$.ajax({
				type : "post",
				url : "/obigoProject/password",
				dataType : "json",
				data : {
					"userId" : $("#userId").val(),
					"password" : $("#password").val()
				},
				success : function(data) {
					if (data.flag == false) {
						return true;
					} else {
						alert("비밀번호가 틀렸습니다.");
						return false;
					}
				}
			});
		}
	</script>


</body>
</html>
