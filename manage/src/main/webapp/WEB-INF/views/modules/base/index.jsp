<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-cmn-Hans-CN" >
	<head>
		<meta charset="utf-8">
		<title>首页</title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta http-equiv="X-UA-Compatible" content="IE=9" />
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
	<!--
	===================================================================
	|  01. #CSS Links                |  所有的css关联演示				  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #MAIN PANEL               |  main panel                    |
	|  13. #MAIN CONTENT             |  content holder                |
	|  14. #PAGE FOOTER              |  page footer                   |
	|  15. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  16. #PLUGINS                  |  all scripts and plugins       |
	===================================================================
	-->

	<!-- Possible Classes
		* 'smart-style-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'no-menu'			  - Hides the menu completely
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-page-footer' - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<!-- #BODY -->
	<body class="fixed-header fixed-navigation fixed-ribbon fixed-page-footer ">
		<!-- #HEADER -->
		<header id="header">
			<div id="logo-group">
				<!-- 网站logo -->
					<span id="logo">
						<img src="${ctxStatic}/img/logo.png" alt="SmartAdmin">
					</span>
				<!-- 消息 提醒 -->
					<span id="activity" class="activity-dropdown">
						<i class="fa fa-user"></i> <b class="badge"> 21 </b>
					</span>
				<div class="ajax-dropdown">
					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
						<label class="btn btn-default">
							<input type="radio" name="activity" class="active" id="ajax/notify/mail.html">
							消息 (14)
						</label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/notifications.html">
							通知 (3)
						</label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/tasks.html">
							任务 (4)
						</label>
					</div>
					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">
						<div class="alert alert-transparent">
							<h4>通过点击按钮来显示信息</h4>
							这个空白信息用于帮助你保护隐私, 你也可以直接在这里自动显示一些内容。
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>
					</div>
					<!-- end notification content -->

					<!-- footer: refresh area -->
						<span> 最后更新时间 : 12/12/2013 9:43AM
							<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right">
								<i class="fa fa-refresh"></i>
							</button> </span>
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- #PROJECTS: projects dropdown -->
			<div class="project-context hidden-xs">

				<span class="label">项目:</span>
				<span class="project-selector dropdown-toggle" data-toggle="dropdown">最近项目 <i class="fa fa-angle-down"></i></span>

				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);">在线电子商户管理系统-便用iOS与客户进行连接</a>
					</li>
					<li>
						<a href="javascript:void(0);">升级时间线说明</a>
					</li>
					<li>
						<a href="javascript:void(0);">商家帐户资产报告</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="javascript:void(0);"><i class="fa fa-power-off"></i>清除</a>
					</li>
				</ul>
				<!-- end dropdown-menu-->

			</div>
			<!-- end projects dropdown -->

			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">

				<!-- 菜单折叠按钮 -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end 菜单折叠按钮 -->

				<!-- 注销按钮 -->
				<div id="logout" class="btn-header transparent pull-right">
					<span> <a href="login.html" title="退出" data-action="userLogout" data-logout-msg="您可以在退出后关闭浏览器进一步提高安全性"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end 注销按钮 -->

				<!-- #MOBILE -->
				<!-- 顶部个人配置按钮(仅顶部菜单模式有效) -->
				<ul id="mobile-profile-img" class="header-dropdown-list hidden-xs padding-5">
					<li class="">
						<a href="#" class="dropdown-toggle no-margin userdropdown" data-toggle="dropdown">
							<img src="${ctxStatic}/img/avatars/sunny.png" alt="John Doe" class="online" />
						</a>
						<ul class="dropdown-menu pull-right">
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0"><i class="fa fa-cog"></i> 设置</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#ajax/profile.html" class="padding-10 padding-top-0 padding-bottom-0"> <i class="fa fa-user"></i> 配置文件</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="toggleShortcut"><i class="fa fa-arrow-down"></i>快捷方式</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i>全屏</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="login.html" class="padding-10 padding-top-5 padding-bottom-5" data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>注销</a>
							</li>
						</ul>
					</li>
				</ul>

				<!-- 搜索按钮 (小屏可见) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="检索"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end 搜索按钮 (小屏可见) -->

				<!-- #SEARCH -->
				<!-- 搜索框 -->
				<form action="#ajax/search.html" class="header-search pull-right">
					<input id="search-fld" type="text" name="param" placeholder="查找报表及更多">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="取消搜索"><i class="fa fa-times"></i></a>
				</form>
				<!-- end 搜索框 -->

				<!-- 全屏按钮 -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="全屏"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end 全屏按钮 -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<aside id="left-panel">
			<!-- 用户信息 -->
			<div class="login-info">
					<span>
						<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
							<img src="${ctxStatic}/img/avatars/sunny.png" alt="me" class="online" />
							<span>
								用户名
							</span>
							<i class="fa fa-angle-down"></i>
						</a>

					</span>
			</div>
			<!-- end user info -->

			<!-- NAVIGATION	-->
			<nav>
				<ul>
					<li class="">
						<a href="ajax/dashboard.html" title="仪表盘">
							<i class="fa fa-lg fa-fw fa-home"></i>
							<span class="menu-item-parent">仪表盘</span>
						</a>
					</li>
					<li>
						<a href="ajax/inbox.html">
							<i class="fa fa-lg fa-fw fa-inbox"></i>
							<span class="menu-item-parent">收件箱</span><span class="badge pull-right inbox-badge">14</span>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-lg fa-fw fa-bar-chart-o"></i>
							<span class="menu-item-parent">图表</span>
						</a>
						<ul>
							<li>
								<a href="ajax/flot.html">Flot Chart</a>
							</li>
							<li>
								<a href="ajax/morris.html">Morris Charts</a>
							</li>
							<li>
								<a href="ajax/inline-charts.html">Inline Charts</a>
							</li>
							<li>
								<a href="ajax/dygraphs.html">Dygraphs</a>
							</li>
							<li>
								<a href="ajax/chartjs.html">Chart.js <span class="badge pull-right inbox-badge bg-color-yellow">new</span></a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-lg fa-fw fa-table"></i>
							<span class="menu-item-parent">表格</span>
						</a>
						<ul>
							<li>
								<a href="ajax/table.html">普通表格</a>
							</li>
							<li>
								<a href="ajax/datatables.html">数据表格 <span class="badge inbox-badge bg-color-greenLight">v1.10</span></a>
							</li>
							<li>
								<a href="ajax/ces.html">测试 <span class="badge inbox-badge bg-color-greenLight">v1.10</span></a>
							</li>
							<li>
								<a href="ajax/ces3.html">测试3 </a>
							</li>
							<li>
								<a href="ajax/jqgrid.html">Jquery Grid</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-lg fa-fw fa-pencil-square-o"></i>
							<span class="menu-item-parent">表单</span>
						</a>
						<ul>
							<li>
								<a href="ajax/form-elements.html">表单元素</a>
							</li>
							<li>
								<a href="ajax/form-templates.html">表单布局</a>
							</li>
							<li>
								<a href="ajax/validation.html">表单验证</a>
							</li>
							<li>
								<a href="ajax/bootstrap-forms.html">Bootstrap表单元素</a>
							</li>
							<li>
								<a href="ajax/bootstrap-validator.html">Bootstrap表单验证</a>
							</li>
							<li>
								<a href="ajax/plugins.html">表单插件</a>
							</li>
							<li>
								<a href="ajax/wizard.html">向导</a>
							</li>
							<li>
								<a href="ajax/other-editors.html">Bootstrap编辑器</a>
							</li>
							<li>
								<a href="ajax/dropzone.html">Dropzone</a>
							</li>
							<li>
								<a href="ajax/image-editor.html">Image Cropping <span class="badge pull-right inbox-badge bg-color-yellow">new</span></a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-desktop"></i> <span class="menu-item-parent">用户界面元素</span></a>
						<ul>
							<li>
								<a href="ajax/general-elements.html">普通元素</a>
							</li>
							<li>
								<a href="ajax/buttons.html">按钮</a>
							</li>
							<li>
								<a href="#">图标</a>
								<ul>
									<li>
										<a href="ajax/fa.html"><i class="fa fa-plane"></i>Font Awesome</a>
									</li>
									<li>
										<a href="ajax/glyph.html"><i class="glyphicon glyphicon-plane"></i> Glyph Icons</a>
									</li>
									<li>
										<a href="ajax/flags.html"><i class="fa fa-flag"></i> Flags</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="ajax/grid.html">Grid</a>
							</li>
							<li>
								<a href="ajax/treeview.html">树型视图</a>
							</li>
							<li>
								<a href="ajax/nestable-list.html">嵌套列表</a>
							</li>
							<li>
								<a href="ajax/jqui.html">JQuery UI</a>
							</li>
							<li>
								<a href="ajax/typography.html">排版</a>
							</li>
							<li>
								<a href="#">六级菜单</a>
								<ul>
									<li>
										<a href="#"><i class="fa fa-fw fa-folder-open"></i> Item #2</a>
										<ul>
											<li>
												<a href="#"><i class="fa fa-fw fa-folder-open"></i> Sub #2.1 </a>
												<ul>
													<li>
														<a href="#"><i class="fa fa-fw fa-file-text"></i> Item #2.1.1</a>
													</li>
													<li>
														<a href="#"><i class="fa fa-fw fa-plus"></i> Expand</a>
														<ul>
															<li>
																<a href="#"><i class="fa fa-fw fa-file-text"></i> File</a>
															</li>
															<li>
																<a href="#"><i class="fa fa-fw fa-trash-o"></i> Delete</a></li>
														</ul>
													</li>
												</ul>
											</li>
										</ul>
									</li>
									<li>
										<a href="#"><i class="fa fa-fw fa-folder-open"></i> Item #3</a>

										<ul>
											<li>
												<a href="#"><i class="fa fa-fw fa-folder-open"></i> 3ed Level </a>
												<ul>
													<li>
														<a href="#"><i class="fa fa-fw fa-file-text"></i> File</a>
													</li>
													<li>
														<a href="#"><i class="fa fa-fw fa-file-text"></i> File</a>
													</li>
												</ul>
											</li>
										</ul>
									</li>
									<li>
										<a href="#" class="inactive"><i class="fa fa-fw fa-folder-open"></i> Item #4 (disabled)</a>
									</li>

								</ul>
							</li>
						</ul>
					</li>
					<li>
						<a href="ajax/calendar.html"><i class="fa fa-lg fa-fw fa-calendar"><em>3</em></i> <span class="menu-item-parent">日程表</span></a>
					</li>
					<li>
						<a href="ajax/widgets.html"><i class="fa fa-lg fa-fw fa-list-alt"></i> <span class="menu-item-parent">小部件</span></a>
					</li>
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-puzzle-piece"></i> <span class="menu-item-parent">应用视图</span></a>
						<ul>
							<li>
								<a href="ajax/projects.html"><i class="fa fa-file-text-o"></i> 项目</a>
							</li>
							<li>
								<a href="ajax/blog.html"><i class="fa fa-paragraph"></i> 博客</a>
							</li>
							<li>
								<a href="ajax/gallery.html"><i class="fa fa-picture-o"></i> 画廊</a>
							</li>
							<li>
								<a href="#"><i class="fa fa-comments"></i>论坛布局</a>
								<ul>
									<li><a href="ajax/forum.html">通用视图</a></li>
									<li><a href="ajax/forum-topic.html">主题视图</a></li>
									<li><a href="ajax/forum-post.html">Post View</a></li>
								</ul>
							</li>
							<li>
								<a href="ajax/profile.html"><i class="fa fa-group"></i> 个人中心</a>
							</li>
							<li>
								<a href="ajax/timeline.html"><i class="fa fa-clock-o"></i> 时间线</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ajax/gmap-xml.html"><i class="fa fa-lg fa-fw fa-map-marker"></i> <span class="menu-item-parent">谷歌地图</span><span class="badge bg-color-greenLight pull-right inbox-badge">9</span></a>
					</li>
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-windows"></i> <span class="menu-item-parent">其他</span></a>
						<ul>
							<li>
								<a href="ajax/pricing-table.html">定价</a>
							</li>
							<li>
								<a href="ajax/invoice.html">发票</a>
							</li>
							<li>
								<a href="login.html" target="_top">登录页</a>
							</li>
							<li>
								<a href="register.html" target="_top">注册页</a>
							</li>
							<li>
								<a href="lock.html" target="_top">锁屏</a>
							</li>
							<li>
								<a href="ajax/error404.html">404页面</a>
							</li>
							<li>
								<a href="ajax/error500.html">500页面</a>
							</li>
							<li>
								<a href="ajax/blank_.html">空白页</a>
							</li>
							<li>
								<a href="ajax/email-template.html">邮件模板</a>
							</li>
							<li>
								<a href="ajax/search.html">搜索页</a>
							</li>
							<li>
								<a href="ajax/ckeditor.html">CK Editor</a>
							</li>
						</ul>
					</li>
					<li class="chat-users top-menu-invisible">
						<a href="#">
							<i class="fa fa-lg fa-fw fa-comment-o"><em class="bg-color-pink flash animated">!</em></i>
							<span class="menu-item-parent">Smart Chat API <sup>beta</sup></span>
						</a>
						<ul>
							<li>
								<!-- DISPLAY USERS -->
								<div class="display-users">

									<input class="form-control chat-user-filter" placeholder="Filter" type="text">

									<a href="#" class="usr"
									   data-chat-id="cha1"
									   data-chat-fname="Sadi"
									   data-chat-lname="Orlaf"
									   data-chat-status="busy"
									   data-chat-alertmsg="Sadi Orlaf is in a meeting. Please do not disturb!"
									   data-chat-alertshow="true"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/5.png' alt='Sadi Orlaf'>
													<div class='usr-card-content'>
														<h3>Sadi Orlaf</h3>
														<p>Marketing Executive</p>
													</div>
												</div>
											">
										<i></i>Sadi Orlaf
									</a>

									<a href="#" class="usr"
									   data-chat-id="cha2"
									   data-chat-fname="Jessica"
									   data-chat-lname="Dolof"
									   data-chat-status="online"
									   data-chat-alertmsg=""
									   data-chat-alertshow="false"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/1.png' alt='Jessica Dolof'>
													<div class='usr-card-content'>
														<h3>Jessica Dolof</h3>
														<p>Sales Administrator</p>
													</div>
												</div>
											">
										<i></i>Jessica Dolof
									</a>

									<a href="#" class="usr"
									   data-chat-id="cha3"
									   data-chat-fname="Zekarburg"
									   data-chat-lname="Almandalie"
									   data-chat-status="online"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/3.png' alt='Zekarburg Almandalie'>
													<div class='usr-card-content'>
														<h3>Zekarburg Almandalie</h3>
														<p>Sales Admin</p>
													</div>
												</div>
											">
										<i></i>Zekarburg Almandalie
									</a>

									<a href="#" class="usr"
									   data-chat-id="cha4"
									   data-chat-fname="Barley"
									   data-chat-lname="Krazurkth"
									   data-chat-status="away"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/4.png' alt='Barley Krazurkth'>
													<div class='usr-card-content'>
														<h3>Barley Krazurkth</h3>
														<p>Sales Director</p>
													</div>
												</div>
											">
										<i></i>Barley Krazurkth
									</a>

									<a href="#" class="usr offline"
									   data-chat-id="cha5"
									   data-chat-fname="Farhana"
									   data-chat-lname="Amrin"
									   data-chat-status="incognito"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/female.png' alt='Farhana Amrin'>
													<div class='usr-card-content'>
														<h3>Farhana Amrin</h3>
														<p>Support Admin <small><i class='fa fa-music'></i> Playing Beethoven Classics</small></p>
													</div>
												</div>
											">
										<i></i>Farhana Amrin (offline)
									</a>

									<a href="#" class="usr offline"
									   data-chat-id="cha6"
									   data-chat-fname="Lezley"
									   data-chat-lname="Jacob"
									   data-chat-status="incognito"
									   data-rel="popover-hover"
									   data-placement="right"
									   data-html="true"
									   data-content="
												<div class='usr-card'>
													<img src='${ctxStatic}/img/avatars/male.png' alt='Lezley Jacob'>
													<div class='usr-card-content'>
														<h3>Lezley Jacob</h3>
														<p>Sales Director</p>
													</div>
												</div>
											">
										<i></i>Lezley Jacob (offline)
									</a>

									<a href="ajax/chat.html" class="btn btn-xs btn-default btn-block sa-chat-learnmore-btn">About the API</a>

								</div>
								<!-- END DISPLAY USERS -->
							</li>
						</ul>
					</li>
				</ul>

			</nav>
			<!-- 折叠菜单按钮 -->
			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->

		<!-- #MAIN PANEL -->
		<div id="main" role="main">
			<!-- RIBBON -->
			<div id="ribbon">
					<span class="ribbon-button-alignment">
						<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh" rel="tooltip" data-placement="bottom"
							  data-original-title="<i class='text-warning fa fa-warning'></i> 警告！这将重置您的小组件位置及颜色设置。" data-html="true"
							  data-reset-msg="您确认将重置你所有的小组件的位置并清理本地存储么？">
						<i class="fa fa-refresh"></i>
						</span>
					</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<!-- This is auto generated -->
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right" style="margin-right:25px">
					<a href="#" id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa fa-grid"></i> Change Grid</a>
					<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa fa-plus"></i> Add</span>
					<button id="search" class="btn btn-ribbon" data-title="search"><i class="fa fa-search"></i> <span class="hidden-mobile">Search</span></button>
				</span> -->
			</div>
			<!-- END RIBBON -->

			<!-- #MAIN CONTENT -->
			<div id="content"></div>
			<!-- END #MAIN CONTENT -->

		</div>
		<!-- END #MAIN PANEL -->

		<!-- #PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
						<span class="txt-color-white">
							ziduye <span class="hidden-xs"> - Web Application Framework</span> © 2014-2015
						</span>
				</div>

				<div class="col-xs-6 col-sm-6 text-right hidden-xs">
					<div class="txt-color-white inline-block">
						<i class="txt-color-blueLight hidden-mobile">
							最后活动于： <i class="fa fa-clock-o"></i> <strong>52分钟之前 &nbsp;</strong>
						</i>
						<div class="btn-group dropup">
							<button class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white" data-toggle="dropdown">
								<i class="fa fa-link"></i> <span class="caret"></span>
							</button>
							<ul class="dropdown-menu pull-right text-left">
								<li>
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">下载进度</p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-success" style="width: 50%;"></div>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">服务器负载</p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-success" style="width: 20%;"></div>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li >
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">内存负载 <span class="text-danger">*至关重要的*</span></p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-danger" style="width: 70%;"></div>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="padding-5">
										<button class="btn btn-block btn-default">刷新</button>
									</div>
								</li>
							</ul>
						</div>
						<!-- end btn-group-->
					</div>
					<!-- end div-->
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- END FOOTER -->

		<!-- #SHORTCUT AREA : 大磁贴 (单击用户名激活),自适应磁贴,可添加多个 -->
		<div id="shortcut">
			<ul>
				<li>
					<a href="#ajax/inbox.html" class="jarvismetro-tile big-cubes bg-color-blue">
							<span class="iconbox">
								<i class="fa fa-envelope fa-4x"></i> <span> 邮件  <span class="label pull-right bg-color-darken">14</span></span>
							</span>
					</a>
				</li>
				<li>
					<a href="#ajax/calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark">
							<span class="iconbox">
								<i class="fa fa-calendar fa-4x"></i> <span>日历</span>
							</span>
					</a>
				</li>
				<li>
					<a href="#ajax/gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple">
							<span class="iconbox">
								<i class="fa fa-map-marker fa-4x"></i> <span>地图</span>
							</span>
					</a>
				</li>
				<li>
					<a href="#ajax/invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark">
							<span class="iconbox">
								<i class="fa fa-book fa-4x"></i> <span>订单 <span class="label pull-right bg-color-darken">99</span></span>
							</span>
					</a>
				</li>
				<li>
					<a href="#ajax/gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight">
							<span class="iconbox">
								<i class="fa fa-picture-o fa-4x"></i> <span>画廊 </span>
							</span>
					</a>
				</li>
				<li>
					<a href="#ajax/profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark">
							<span class="iconbox">
								<i class="fa fa-user fa-4x"></i> <span>个人中心 </span>
							</span>
					</a>
				</li>
			</ul>
		</div>
		<!-- END SHORTCUT AREA -->

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>-->


		<!-- #PLUGINS -->
		<script src="${ctxStatic}/js/libs/jquery-2.1.1.min.js"></script>
		<script src="${ctxStatic}/js/libs/jquery-ui-1.10.3.min.js"></script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="${ctxStatic}/js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="${ctxStatic}/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>

		<!-- BOOTSTRAP JS -->
		<script src="${ctxStatic}/js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="${ctxStatic}/js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="${ctxStatic}/js/smartwidgets/jarvis.widget.min.js"></script>

		<!-- EASY PIE CHARTS -->
		<script src="${ctxStatic}/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<script src="${ctxStatic}/js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="${ctxStatic}/js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="${ctxStatic}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="${ctxStatic}/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="${ctxStatic}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<script src="${ctxStatic}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices: you can disable this in app.js -->
		<script src="${ctxStatic}/js/plugin/fastclick/fastclick.min.js"></script>

		<!--[if IE 8]>
		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- 显示设置面板  -->
		<script src="${ctxStatic}/js/demo.min.js"></script>

		<!-- MAIN APP JS FILE -->
		<script src="${ctxStatic}/js/app.min.js"></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="${ctxStatic}/js/speech/voicecommand.min.js"></script>

		<!-- SmartChat UI : plugin -->
		<script src="${ctxStatic}/js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="${ctxStatic}/js/smart-chat-ui/smart.chat.manager.min.js"></script>
		<script type="text/javascript">
			$.fn.datetimepicker.dates['zh_CN']={
				days:["星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日"],
				daysShort:["星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日"],
				daysMin:["日","一","二","三","四","五","六","日"],
				months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				monthsShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				today:"今天"
			};
		</script>
	</body>
</html>