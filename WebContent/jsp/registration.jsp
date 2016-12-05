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
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<title>Registration</title>

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

		<form class="form-signin" action="/obigoProject/signup" onsubmit="return check()" method="POST">
			<h2 class="form-signin-heading">registration now</h2>
			<div class="login-wrap">
				<p>Enter your personal details below</p>
				<input type="text" name="name" id="name" class="form-control" placeholder="Full Name" autofocus required="required">

				<input type="email" name="eMail" class="form-control" placeholder="Email" autofocus required="required">
				<input type="text" id="phone" name="phone" class="form-control" placeholder="phone ex) 010-1234-5678" onblur="phoneCheck()" autofocus required="required">
				<div id="phoneCheck"></div>
				<p>Enter your account details below</p>
				<input type="text" name="userId" id="userId" class="form-control" placeholder="User Id" onkeyup="idCheck()" autofocus required="required">
				<div id="idCheck"></div>
				<input type="password" name="password" id="password" class="form-control" placeholder="Password" required="required">
				<input type="password" id="password2" class="form-control" placeholder="Re-type Password" onblur="passwordCheck()" required="required">
				<div id="passwordCheck"></div>
				<input class="btn btn-lg btn-login btn-block" type="submit" value="SUBMIT">

				<div class="registration">
					Already Registered. <a class="" href="/obigoProject/login"> Login </a>
				</div>

			</div>

		</form>

	</div>

	<script type="text/javascript">
		function phoneCheck() {
			var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

			if (!regExp.test($("#phone").val())) {
				$("#phoneCheck").html("숫자, - 를 포함한 숫자만 입력해 주세요.");
				$("#phoneCheck").css("color", "red");

				return false
			} else {
				$("#phoneCheck").html("");
				return true;

			}

		}

		//id체크
		function idCheck() {

			// 4 ~ 20 자리 영(대, 소), 숫자
			// 첫글자는 숫자 사용 불가
			var pattern = /^[A-Za-z]{1}[A-Za-z0-9]{5,19}$/;

			if (!pattern.test($("#userId").val())) {
				
				$("#idCheck").html("영어 대소문자로 시작하는 6~20자리(숫자 포함 가능)");
				$("#idCheck").css("color","red");

			} else {
				
				$.ajax({
					type : "post",
					url : "/obigoProject/idcheck",
					dataType : "json",
					data : {
						"userId" : $("#userId").val()
					},
					success : function(data) {
						if (data.flag == false) {
							$("#idCheck").html("이미 존재하는 아이디 입니다.");
							$("#idCheck").css("color", "red");
						} else {
							$("#idCheck").html("사용가능한 아이디 입니다.");
							$("#idCheck").css("color", "blue");
						}
					}
				});
				
			}

		}
		//패스워드 일치 확인
		function passwordCheck() {
			if ($("#password") == null || $("#password2") == null) {
				$("#passwordCheck").html("");
			} else {

				if ($("#password").val() == $("#password2").val()) {
					$("#passwordCheck").html("비밀번호가 일치합니다.");
					$("#passwordCheck").css("color", "blue");
				} else {
					$("#passwordCheck").html("비밀번호가 틀렸습니다.");
					$("#passwordCheck").css("color", "red");
				}
			}
		}
		
		//아이디가 사용가능하고 비밀번호가 일치해야 회원가입 가능.(onsubmit="return check()")
		function check() {
			if ($("#idCheck").html() == "사용가능한 아이디 입니다."
					&& $("#passwordCheck").html() == "비밀번호가 일치합니다.") {
				return true;
			} else {
				alert("아이디와 비밀번호를 확인해 주세요");
				return false;
			}

		}
	</script>
</body>
</html>