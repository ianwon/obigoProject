<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="/obigoProject/img/favicon.png">

<title>Header Color Change</title>

<!-- Bootstrap core CSS -->
<link href="/obigoProject/css/bootstrap.min.css" rel="stylesheet">
<link href="/obigoProject/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="/obigoProject/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/obigoProject/assets/data-tables/DT_bootstrap.css" />

<!--right slidebar-->
<link href="/obigoProject/css/slidebars.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/obigoProject/css/style.css" rel="stylesheet">
<link href="/obigoProject/css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container" class="">
		<!--header start-->
		<header class="header blue-bg">
			<div class="sidebar-toggle-box">
				<i class="fa fa-bars"></i>
			</div>
			<!--logo start-->
			<a href="/obigoProject/main" class="logo">
				Obigo
				<span>MAS</span>
			</a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">

					<!-- 					notification dropdown start -->
					<li id="header_notification_bar" class="dropdown">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<i class="fa fa-bell-o"></i>
							<span class="badge bg-warning">
								<c:out value="${fn:length(userRequestList)}" />
							</span>
						</a>
						<ul class="dropdown-menu extended notification">
							<div class="notify-arrow notify-arrow-yellow"></div>
							<li>
								<p class="yellow">
									You have
									<c:out value="${fn:length(userRequestList)}" />
									new notifications
								</p>
							</li>

							<c:if test="${not empty userRequestList}">
								<c:forEach var="userRequestList" items="${userRequestList}" begin="0">
									<li>
										<a href="#">
											<span class="label label-danger">
												<i class="fa fa-bell"></i>
											</span>
											${userRequestList.userId} # requested.
											<span class="small italic"></span>
										</a>
									</li>
								</c:forEach>
								<li>
									<a href="#">See all notifications</a>
								</li>
							</c:if>
						</ul>
					</li>
					<!-- 	notification dropdown end -->
				</ul>
			</div>
			<div class="top-nav ">
				<ul class="nav pull-right top-menu">

					<!-- user login dropdown start (상단 header 로그인 버튼)-->
					<li class="dropdown">
						<a data-toggle="dropdown" class="dropdown-toggle" style="background-color: white;" href="#">
							<img alt="" src="/obigoProject/img/obigo_logo_small.png">
							<span class="username" style="color: black;">
								<c:out value="${sessionScope.LoginOK}" />
							</span>
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu extended logout">
							<div class="log-arrow-up"></div>
							<!-- 우측상단 로그인 표시 버튼 클릭시 뜨는 메뉴  
                          <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                          <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                          <li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li> 
                          -->
							<li>
								<a href="/obigoProject/logout">
									<i class="fa fa-key"></i>
									Log Out
								</a>
							</li>
						</ul>
					</li>

					<!-- user login dropdown end -->

				</ul>
			</div>
		</header>
		<!--header end-->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<li>
						<a href="/obigoProject/dashboard">
							<i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
						</a>
					</li>

					<li class="sub-menu">
						<a href="javascript:;">
							<i class="fa fa-laptop"></i>
							<span>Users Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/adminmanagement">Admin</a>
							</li>
							<li>
								<a href="/obigoProject/usermanagement">User</a>
							</li>
						</ul>
					</li>

					<li class="sub-menu">
						<a href="javascript:;">
							<i class="fa fa-book"></i>
							<span>Request Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/userrequest">User Request</a>
							</li>
						</ul>
					</li>

					<li class="sub-menu">
						<a href="javascript:;">
							<i class="fa fa-cogs"></i>
							<span>Vehicle Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/vehicle">Vehicle</a>
							</li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;">
							<i class="fa fa-tasks"></i>
							<span>Bundle Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/bundle">Bundle</a>
							</li>
							<li>
								<a href="/obigoProject/resource">Resource</a>
							</li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;">
							<i class="fa fa-th"></i>
							<span>Api Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/api">RestFUL Api</a>
							</li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;">
							<i class=" fa fa-envelope"></i>
							<span>Push Message Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/pushmessage">Message Box</a>
							</li>
							<li>
								<a href="/obigoProject/sendmessage">Send Message</a>
							</li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;">
							<i class=" fa fa-bar-chart-o"></i>
							<span>Logs Management</span>
						</a>
						<ul class="sub">
							<li>
								<a href="/obigoProject/log">Log</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		
	</section>

	<!-- js placed at the end of the document so the pages load faster -->



</body>
</html>