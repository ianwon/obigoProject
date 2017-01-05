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
				<input type="password" class="form-control" placeholder="Password" name="password" id="password">
				<label class="checkbox">
					<input type="checkbox" id="remember-me" value="remember-me">
					Remember me
				</label>
				<input class="btn btn-lg btn-login btn-block" type="submit" value="Sign in">
				<div class="registration">
					Don't have an account yet? <a class="" href="/obigoProject/registration"> Create an account</a>
				</div>
			</div>
		</form>
	</div>
	
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>

	<script type="text/javascript">
	
		// Remember me 가 check 되어 있을 때, 다시 로그인시 쿠키에서 해당 ID를 불러온다 
		$(document).ready(function() {
			// 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
			var userInputId = getCookie("adminLoginId");
			$("input[name='userId']").val(userInputId);

			// 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
			if ($("input[name='userId']").val() != "") { 
				// ID 저장하기를 체크 상태로 두기
				$("#remember-me").attr("checked", true); 
			}

			// 체크박스에 변화가 있다면,
			$("#remember-me").change(function() {
				// ID 저장하기 체크했을 때,
				if ($("#remember-me").is(":checked")) { 
					var userInputId = $("input[name='userId']").val();
					// 7일 동안 쿠키 보관
					setCookie("adminLoginId", userInputId, 7); 
				} else { // ID 저장하기 체크 해제 시,
					deleteCookie("adminLoginId");
				}
			});

			// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장
			 // ID 입력 칸에 ID를 입력할 때,
			$("input[name='userId']").keyup(function() {
				// ID 저장하기를 체크한 상태라면,
				if ($("#remember-me").is(":checked")) { 
					var userInputId = $("input[name='userId']").val();
					// 7일 동안 쿠키 보관
					setCookie("adminLoginId", userInputId, 7); 
				}
			});
		});

		// Cookie 생성
		function setCookie(cookieName, value, exdays) {
			var exdate = new Date();
			exdate.setDate(exdate.getDate() + exdays);
			var cookieValue = escape(value)
					+ ((exdays == null) ? "" : "; expires="
							+ exdate.toGMTString());
			document.cookie = cookieName + "=" + cookieValue;
		}

		// Cookie 삭제
		function deleteCookie(cookieName) {
			var expireDate = new Date();
			expireDate.setDate(expireDate.getDate() - 1);
			document.cookie = cookieName + "= " + "; expires="
					+ expireDate.toGMTString();
		}

		// Cookie 검색
		function getCookie(cookieName) {
			cookieName = cookieName + '=';
			var cookieData = document.cookie;
			var start = cookieData.indexOf(cookieName);
			var cookieValue = '';
			if (start != -1) {
				start += cookieName.length;
				var end = cookieData.indexOf(';', start);
				if (end == -1)
					end = cookieData.length;
				cookieValue = cookieData.substring(start, end);
			}
			return unescape(cookieValue);
		}

		//로그인시 아이디의 존재여부 확인하는 함수
		//현재 로그인 페이지에서는 사용하고 있지 않다!!!
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

		// 로그인 페이지에서 ID/PW 체크해주고 결과를 true/false를 return 해주는 함수
		function passwordCheck() {
			$.ajax({
				type : "post",
				url : "/obigoProject/passwordcheck",
				dataType : "json",
				data : {
					"userId" : $("#userId").val(),
					"password" : $("#password").val()
				},
				success : function(data) {
					if (data.flag == true) {
						return true;
					} else {
						alert("아이디 또는 비밀번호가 틀렸습니다.");
						return false;
					}
				},
				error : function(e) {
					console.log(e);
				}
			});
		}
	</script>


</body>
</html>
