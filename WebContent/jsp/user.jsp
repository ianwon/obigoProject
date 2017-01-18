<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/ico" href="/obigoProject/img/favicon.ico">

<title>User Management Page</title>
</head>
<body>

	<!--header start-->
	<jsp:include page="/jsp/header/header.jsp"></jsp:include>
	<!--header end-->

	<section id="container" class="">
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<!-- page start-->
				<section class="panel">
					<header class="panel-heading"> USERS </header>
					<div class="panel-body">
						<div class="adv-table editable-table ">
							<div class="clearfix">
								<div class="btn-group">
									<a id="Add" class="btn btn-success" data-toggle="modal" href="#addModal"> Add User <i class="fa fa-plus"></i>
									</a>
								</div>

								<!-- -------------- Add User Modal start -------------- -->
								<div class="modal fade " id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add User</h4>
											</div>
											<div class="modal-body">
												<form id="form-registration" class="form-signin" action="/obigoProject/insertuser" onsubmit="return check()" method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">NAME</span>
															<input type="text" name="name" id="name" class="form-control" placeholder="Full Name" autofocus required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">E-MAIL</span>
															<input type="email" name="eMail" class="form-control" placeholder="Email" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">PHONE</span>
															<input type="text" name="phone" class="form-control" placeholder="phone" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">USER ID</span>
															<input type="text" name="userId" id="userId" class="form-control" placeholder="User Id" onkeyup="idCheck()" required="required">
															<div id="idCheck"></div>
														</div>
														<div class="form-group">
															<span class="label label-primary">PASSWORD</span>
															<input type="password" name="password" id="password" class="form-control" placeholder="Password" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">RE-TYPE PASSWORD</span>
															<input type="password" id="password2" class="form-control" placeholder="Re-type Password" onkeyup="passwordCheck()" required="required">
															<div id="passwordCheck"></div>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-registration" value="Registration">
											</div>
										</div>
									</div>
								</div>
								<!-- -------------- Add User Modal end -------------- -->

								<!-- -------------- Edit User Modal start -------------- -->
								<div class="modal fade " id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
												<h4 class="modal-title">Update User</h4>
											</div>
											<div class="modal-body">
												<form id="form-update" class="form-signin" onsubmit="return checkUpdate()" action="/obigoProject/updateuser" method="POST">
													<div class="login-wrap">
														<div class="form-group">
															<span class="label label-primary">USER ID</span>
															<input type="text" name="userId" id="edituserId" class="form-control" readonly="readonly" value="${userId}">
														</div>
														<div class="form-group">
															<span class="label label-primary">NAME</span>
															<input type="text" name="name" id="editname" class="form-control" placeholder="Full Name" readonly="readonly" value="${userName}">
														</div>
														<div class="form-group">
															<span class="label label-primary">PASSWORD</span>
															<input type="text" name="password" id="editpassword" class="form-control" autofocus="autofocus" placeholder="Password" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">EMAIL</span>
															<input type="email" name="eMail" id="editeMail" class="form-control" placeholder="Email" required="required">
														</div>
														<div class="form-group">
															<span class="label label-primary">PHONE</span>
															<input type="text" name="phone" id="editphone" class="form-control" placeholder="phone" required="required">
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default" type="button">Close</button>
												<input class="btn btn-success" type="submit" form="form-update" value="Update">
											</div>
										</div>
									</div>
								</div>
								<!-- -------------- Edit User Modal end -------------- -->
							</div>
							<div class="space15"></div>

							<!-- -------------- User Table start -------------- -->
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered" id="editable-sample">
									<thead>
										<tr>
											<th>USERID</th>
											<th>USERNAME</th>
											<th>EMAIL</th>
											<th>PHONE</th>
											<th>EDIT</th>
											<th>DELETE</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="u" items="${userList}" begin="0">
											<tr class="">
												<td onclick="userVehicle('${u.userId}')" style="cursor: pointer;">${u.userId}</td>
												<td onclick="userVehicle('${u.userId}')" style="cursor: pointer;">${u.name}</td>
												<td onclick="userVehicle('${u.userId}')" style="cursor: pointer;">${u.eMail}</td>
												<td onclick="userVehicle('${u.userId}')" style="cursor: pointer;">${u.phone}</td>
												<td><a class="update" href="javascript:update('${u.phone}','${u.eMail}','${u.name}','${u.userId }', '${u.password }')">Edit</a></td>
												<td><a class="del" href="javascript:del('${u.userId}')">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- -------------- User Table end -------------- -->
						</div>
					</div>
				</section>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->

		<!--footer start-->
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->
	</section>

	<script type="text/javascript">
		function userVehicle(userId) {
			document.location.href = "/obigoProject/userVehicle?userId=" + userId;
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
	
		// User 삭제 버튼 클릭 시 호출 되는 함수
		function del(data) {
			if (confirm("삭제 하시겠습니까?") == true) {
				$.ajax({
					type : "post",
					url : "/obigoProject/deleteuser",
					dataType : "json",
					data : {
						"userId" : data
					},
					success : function(data) {
						location.reload();
					}
				});
	
			}
		}
	
		// User 수정 버튼을 클릭 했을 때 Modal을 띄워주는 함수
		function update(phone, eMail, name, userId, password) {
			$("#editphone").val(phone);
			$("#editeMail").val(eMail);
			$("#editname").val(name);
			$("#edituserId").val(userId);
			$("#editpassword").val(password);
			$("#editModal").modal();
		}
		
		function checkUpdate() {
			var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			if (!reg_pwd.test($("#editpassword").val())) {
				alert("비밀번호는 영문,숫자를 혼합하여 6~20자 이내이어야 합니다.");
				return false;
			} else {
				return true;
			}
		}
	
		// User를 등록할 때, ID와 PW 검증이 완료 되었다면 등록진행! 만약 조건이 만족되지 않으면 다시 입력 요청
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

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/obigoProject/js/jquery.js"></script>
	<script src="/obigoProject/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/obigoProject/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="/obigoProject/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="/obigoProject/assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="/obigoProject/assets/data-tables/DT_bootstrap.js"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--script for this page only-->
	<script src="/obigoProject/js/editable-table.js"></script>

	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			EditableTable.init();
		});
	</script>


</body>
</html>
