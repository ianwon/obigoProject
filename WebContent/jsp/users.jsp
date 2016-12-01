<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
	%>

	<jsp:include page="/jsp/header/header.jsp"></jsp:include>

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
									<button id="Add" class="btn green" data-toggle="modal"
										href="#myModal">
										Add User <i class="fa fa-plus"></i>
									</button>
								</div>
								<!--modal start-->
								<!-- Modal -->
								<div class="modal fade " id="myModal" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title">Add User</h4>
											</div>
											<div class="modal-body">
												<form id="form-registration" class="form-signin" action="/obigoProject/insertUser" method="POST">
													<div class="login-wrap">
														<input type="text" name="name" id="name"
															class="form-control" placeholder="Full Name" autofocus
															required="required"> <input type="email"
															name="eMail" class="form-control" placeholder="Email"
															autofocus required="required"> <input type="text"
															name="phone" class="form-control" placeholder="phone"
															autofocus required="required"> <input type="text"
															name="userId" id="userId" class="form-control"
															placeholder="User Id" onkeyup="idCheck()" autofocus
															required="required">
														<div id="idCheck"></div>
														<input type="password" name="password" id="password"
															class="form-control" placeholder="Password"
															required="required"> <input type="password"
															id="password2" class="form-control"
															placeholder="Re-type Password" onkeyup="passwordCheck()"
															required="required">
														<div id="passwordCheck"></div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal" class="btn btn-default"
													type="button">Close</button>
												<!-- <button class="btn btn-success" type="submit"
													>Registration</button> -->
												<input class="btn btn-success" type="submit" form="form-registration" value="Registration">
											</div>
										</div>
									</div>
								</div>
								<!-- modal -->
								<!-- Modal -->
							</div>
							<div class="space15"></div>
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered"
									id="editable-sample">
									<thead>
										<tr>
											<th>USERNAME</th>
											<th>EMAIL</th>
											<th>PHONE</th>
											<th>REGISTRATIONID</th>
											<th>ACTION</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="k" items="${userList}" begin="0">
											<tr class="">
												<td>${k.name}</td>
												<td>${k.eMail}</td>
												<td>${k.phone}</td>
												<td class="center">${k.registrationId}</td>
												<td><a class="Delete" href="deleteUser(${k.userId});">Delete</a></td>
											</tr>
										</c:forEach>
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
		<jsp:include page="/jsp/header/footer.jsp"></jsp:include>
		<!--footer end-->
	</section>
	<script type="text/javascript">
	
		//id체크
		function idCheck() {
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
	
		function check() {
			if ($("#idCheck").html() == "사용가능한 아이디 입니다." && $("#passwordCheck").html() == "비밀번호가 일치합니다.") {
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
	<script class="include" type="text/javascript"
		src="/obigoProject/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/obigoProject/js/jquery.scrollTo.min.js"></script>
	<script src="/obigoProject/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="/obigoProject/assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="/obigoProject/assets/data-tables/DT_bootstrap.js"></script>
	<script src="/obigoProject/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="/obigoProject/js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="/obigoProject/js/common-scripts.js"></script>

	<!--script for this page only-->
	<script src="/obigoProject/js/user-table.js"></script>

	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			EditableTable.init();
		});
	</script>


</body>
</html>
