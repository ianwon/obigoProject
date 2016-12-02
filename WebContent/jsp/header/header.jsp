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
<link rel="shortcut icon" href="/obigoProject/img/favicon.png">

<title>Header Color Change</title>

<!-- Bootstrap core CSS -->
<link href="/obigoProject/css/bootstrap.min.css" rel="stylesheet">
<link href="/obigoProject/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="/obigoProject/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

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
			<a href="index.html" class="logo">Obigo<span>MAS</span></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">


					<!-- settings start(상단 header의 통계 알림 버튼) -->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="fa fa-tasks"></i>
							<span class="badge bg-success">6</span>
					</a>
						<ul class="dropdown-menu extended tasks-bar">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 6 pending tasks</p>
							</li>
							<li><a href="#">
									<div class="task-info">
										<div class="desc">Dashboard v1.3</div>
										<div class="percent">40%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="task-info">
										<div class="desc">Database Update</div>
										<div class="percent">60%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="task-info">
										<div class="desc">Iphone Development</div>
										<div class="percent">87%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
											style="width: 87%">
											<span class="sr-only">87% Complete</span>
										</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="task-info">
										<div class="desc">Mobile App</div>
										<div class="percent">33%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: 33%">
											<span class="sr-only">33% Complete (danger)</span>
										</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="task-info">
										<div class="desc">Dashboard v1.3</div>
										<div class="percent">45%</div>
									</div>
									<div class="progress progress-striped active">
										<div class="progress-bar" role="progressbar"
											aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"
											style="width: 45%">
											<span class="sr-only">45% Complete</span>
										</div>
									</div>

							</a></li>
							<li class="external"><a href="#">See All Tasks</a></li>
						</ul></li>
					<!-- settings end -->

					<!-- notification dropdown start-->
					<li id="header_notification_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
							class="fa fa-bell-o"></i> <span class="badge bg-warning">7</span>
					</a>
						<ul class="dropdown-menu extended notification">
							<div class="notify-arrow notify-arrow-yellow"></div>
							<li>
								<p class="yellow">You have 7 new notifications</p>
							</li>
							<li><a href="#"> <span class="label label-danger"><i
										class="fa fa-bolt"></i></span> Server #3 overloaded. <span
									class="small italic">34 mins</span>
							</a></li>
							<li><a href="#"> <span class="label label-warning"><i
										class="fa fa-bell"></i></span> Server #10 not respoding. <span
									class="small italic">1 Hours</span>
							</a></li>
							<li><a href="#"> <span class="label label-danger"><i
										class="fa fa-bolt"></i></span> Database overloaded 24%. <span
									class="small italic">4 hrs</span>
							</a></li>
							<li><a href="#"> <span class="label label-success"><i
										class="fa fa-plus"></i></span> New user registered. <span
									class="small italic">Just now</span>
							</a></li>
							<li><a href="#"> <span class="label label-info"><i
										class="fa fa-bullhorn"></i></span> Application error. <span
									class="small italic">10 mins</span>
							</a></li>
							<li><a href="#">See all notifications</a></li>
						</ul></li>
					<!-- notification dropdown end -->
				</ul>
			</div>
			<div class="top-nav ">
				<ul class="nav pull-right top-menu">

					<!-- user login dropdown start (상단 header 로그인 버튼)-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <img alt=""
							src="/obigoProject/img/obigo_logo_small.png"> <span class="username">SUPERWYH</span>
							<b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<div class="log-arrow-up"></div>
							<!-- 우측상단 로그인 표시 버튼 클릭시 뜨는 메뉴  
                          <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                          <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                          <li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li> 
                          -->
							<li><a href=""><i class="fa fa-key"></i> Log Out</a></li>
						</ul></li>

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
					<li><a href="/obigoProject/userrequest"> <i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
					</a></li>

					<li class="sub-menu"><a href="javascript:;" >
							<i class="fa fa-laptop"></i> <span>Users Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/users">Admin</a></li>
							<li><a href="/obigoProject/users">User</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Request Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/userrequest">User Request</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Vehicle Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/vehicle">Vehicle</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>Bundle Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/bundle">Bundle</a></li>
							<li><a href="/obigoProject/resource">Resource</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>Api Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/api">RestFUL Api</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-envelope"></i> <span>Push Message Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/pushmessage">Message Box</a></li>
							<li><a href="/obigoProject/sendmessage">Send Message</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-bar-chart-o"></i> <span>Logs Management</span>
					</a>
						<ul class="sub">
							<li><a href="/obigoProject/log">Log</a></li>
						</ul></li>


				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

	</section>

	<!-- js placed at the end of the document so the pages load faster -->



</body>
</html>
