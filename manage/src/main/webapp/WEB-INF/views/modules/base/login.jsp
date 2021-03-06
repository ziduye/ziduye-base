<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-cmn-Hans-CN" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/smartadmin-rtl.min.css">

		<!-- We recommend you use "your_style.css" to override SmartAdmin
			 specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="${ctxStatic}/css/demo.min.css">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="${ctxStatic}/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${ctxStatic}/img/favicon/favicon.ico" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="${ctxStatic}/img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="${ctxStatic}/img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="${ctxStatic}/img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="${ctxStatic}/img/splash/touch-icon-ipad-retina.png">

		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="${ctxStatic}/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="${ctxStatic}/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="${ctxStatic}/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

	</head>

	<body class="animated fadeInDown">

	<header id="header">

		<div id="logo-group">
			<span id="logo"> <img src="${ctxStatic}/img/logo.png" alt="SmartAdmin"> </span>
		</div>

			<span id="extr-page-header-space">
				<span class="hidden-mobile hidden-xs">需要一个账号?</span>
				<a href="register.html" class="btn btn-danger">新建用户</a>
			</span>
	</header>

	<div id="main" role="main">

		<!-- MAIN CONTENT -->
		<div id="content" class="container">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
					<h1 class="txt-color-red login-header-big">
						项目名称
					</h1>
					<div class="hero">
						<div class="pull-left login-desc-box-l">
							<h4 class="paragraph-header">
								项目描述
							</h4>
							<div class="login-app-icons">
								<a href="javascript:void(0);" class="btn btn-danger btn-sm">链接</a>
								<a href="javascript:void(0);" class="btn btn-danger btn-sm">链接</a>
							</div>
						</div>
						<img src="${ctxStatic}/img/demo/iphoneview.png" class="pull-right display-image" alt="" style="width:210px">
					</div>
					<div class="row ">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">
								简介
							</h5>
							<p>
								简介
							</p>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">
								简介
							</h5>
							<p>
								简介
							</p>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form action="${ctx}/login" id="login-form" class="smart-form client-form" method="post">
							<header>登录</header>
							<fieldset >
								<section >
									<label class="label">用户名</label>
									<label class="input">
										<i class="icon-append fa fa-user"></i>
										<input name="username" placeholder="用户名" type="text">
										<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i>请输入您的用户名</b>
									</label>
								</section>
								<section >
									<label class="label">密码</label>
									<label class="input">
										<i class="icon-append fa fa-lock"></i>
										<input id="password" name="password" placeholder="请输入密码"  type="password">
										<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i>请输入您的密码</b>
									</label>
									<div class="note ">
										<a href="forgotpassword.html">忘记密码?</a>
									</div>
								</section>
								<section >
									<label class="checkbox">
										<input name="remember" checked="1"  type="checkbox">
										<i></i>保持登录状态
									</label>
								</section>
							</fieldset>
							<footer>
								<button type="submit" class="btn btn-primary ">登录</button>
							</footer>
						</form>
					</div>
					<h5 class="text-center">
						- 也可以通过以下方式登录 -
					</h5>
					<ul class="list-inline text-center">
						<li  > <a class="btn btn-primary  btn-circle" href="javascript:void(0);"> <i class="fa fa-facebook"></i></a> </li>
						<li  > <a class="btn btn-info btn-circle" href="javascript:void(0);"> <i class="fa fa-twitter"></i></a> </li>
						<li  > <a class="btn btn-warning btn-circle" href="javascript:void(0);"> <i class="fa fa-linkedin"></i> </a> </li>
					</ul>
				</div>
			</div>
		</div>

	</div>

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script src="${ctxStatic}/js/plugin/pace/pace.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script src="${ctxStatic}/js/libs/jquery-2.1.1.min.js"></script>
	<script src="${ctxStatic}/js/libs/jquery-ui-1.10.3.min.js"></script>

	<!-- IMPORTANT: APP CONFIG -->
	<script src="${ctxStatic}/js/app.config.js"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events
    <script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

	<!-- BOOTSTRAP JS -->
	<script src="${ctxStatic}/js/bootstrap/bootstrap.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script src="${ctxStatic}/js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="${ctxStatic}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!--[if IE 8]>

	<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

	<![endif]-->

	<!-- MAIN APP JS FILE -->
	<script src="${ctxStatic}/js/app.min.js"></script>

	<script type="text/javascript">
		runAllForms();

		$(function() {
			// Validation
			$("#login-form").validate({
				// Rules for form validation
				rules : {
					email : {
						required : true,
						email : true
					},
					password : {
						required : true,
						minlength : 3,
						maxlength : 20
					}
				},

				// Messages for form validation
				messages : {
					email : {
						required : '请输入您的电子邮件地址',
						email : '请输入一个有效的电子邮件地址'
					},
					password : {
						required : '请输入你的密码'
					}
				},

				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			});
		});
	</script>

	</body>
</html>