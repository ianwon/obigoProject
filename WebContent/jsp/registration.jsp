<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">
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
				<span class="label label-primary">NAME</span>
				<input type="text" name="name" id="name" class="form-control" placeholder="Full Name" autofocus required="required">
				<span class="label label-primary">E-MAIL</span>
				<input type="email" name="eMail" class="form-control" placeholder="Email" autofocus required="required">
				<span class="label label-primary">PHONE</span>
				<input type="text" id="phone" name="phone" class="form-control" placeholder="phone ex) 010-1234-5678" onkeyup="phoneCheck()" autofocus required="required">
				<div class="check-message" id="phoneCheck"></div>
				<p>Enter your account details below</p>
				<span class="label label-primary">USER ID</span>
				<input type="text" name="userId" id="userId" class="form-control" placeholder="User Id" onkeyup="idCheck()" autofocus required="required">
				<div class="check-message" id="idCheck"></div>
				<span class="label label-primary">PASSWORD</span>
				<input type="password" name="password" id="password" class="form-control" placeholder="Password" required="required">
				<span class="label label-primary">PASSWORD</span>
				<input type="password" id="password2" class="form-control" placeholder="Re-type Password" onkeyup="passwordCheck()" required="required">
				<div class="check-message" id="passwordCheck"></div>
				<input class="btn btn-lg btn-login btn-block" type="submit" value="SUBMIT">
				<div class="registration">
					Already Registered. <a class="" href="/obigoProject/login"> Login </a>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		// 올바른 연락처인지 정규식으로 검증하는 함수
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
	
		// 가입 ID가 정규식으로 검증 및 AJAX로 이미 가입된 ID인지 여부 확인
		function idCheck() {
			var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
			if (!idReg.test($("#userId").val())) {
				$("#idCheck").html("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
				$("#idCheck").css("color", "red");
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
		
		// Password 정규식으로 검증 및 두번 입력한 password의 일치 여부 확인
		function passwordCheck() {
			var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			if (!reg_pwd.test($("#password").val())) {
				$("#passwordCheck").html("비밀번호는 영문,숫자를 혼합하여 6~20자 이내이어야 합니다.");
				$("#passwordCheck").css("color", "red");
			} else {
	
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
		}
	
		// ID/PW가 가입 조건에 합당한지 검증하는 함수(onsubmit="return check()")
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