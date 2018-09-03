<%@page import="pojo.Category"%>
<%@page pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pojo.Admin" %>
<%-- <% Admin admin=(Admin)session.getAttribute("admin"); --%>

// if(admin==null){
// 	response.sendRedirect("login.jsp");
// 	return;
// }
<%-- %> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
<meta charset="utf-8">
<title>Free HTML5 Bootstrap Admin Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="css/charisma-app.css" rel="stylesheet">
<link href="bower_components/fullcalendar/dist/fullcalendar.css"
	rel='stylesheet'>
<link href="bower_components/fullcalendar/dist/fullcalendar.print.css"
	rel='stylesheet' media='print'>
<link href="bower_components/chosen/chosen.min.css" rel="stylesheet">
<link href="bower_components/colorbox/example3/colorbox.css"
	rel="stylesheet">
<link href="bower_components/responsive-tables/responsive-tables.css"
	rel='stylesheet'>
<link
	href="bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css"
	rel='stylesheet'>
<link href="css/jquery.noty.css" rel='stylesheet'>
<link href="css/noty_theme_default.css" rel='stylesheet'>
<link href="css/elfinder.min.css" rel='stylesheet'>
<link href="css/elfinder.theme.css" rel='stylesheet'>
<link href="css/jquery.iphone.toggle.css" rel='stylesheet'>
<link href="css/uploadify.css" rel='stylesheet'>
<link href="css/animate.min.css" rel='stylesheet'>

<!-- jQuery -->
<script src="bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
	<div class="ch-container">
		<div class="row">

			<div class="row">
				<div class="col-md-12 center login-header">
					<h2>
						<a href="categorylist.do">返回类别界面</a>
					</h2>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
		
			<div style="width: 800px; margin: 10px auto">
				<h2>添加子类别</h2>
				<form action="categoryaddchild.do" method="post">
					<table>

						<tr>
							<td>类别名称：</td>
							<td><input type="text" name="name" style="width: 500px" /></td>
						</tr>
						<tr>
							<td>类别描述：</td>
							<td><textarea style="width: 500px; height: 200px"
									name="descr"></textarea></td>
						</tr>
						<tr>
							<td>所属类别：</td>
							<td>${category.name}</td>
							
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="提交" />
								<input type="hidden" name="pid" value="${category.id }" />
							</td>
							<td><input type="reset" value="重置" /></td>
						</tr>

					</table>
				</form>
			</div>

		</div>
		<!--/fluid-row-->

	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->

	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src="bower_components/moment/min/moment.min.js"></script>
	<script src="bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
	<!-- data table plugin -->
	<script src="js/jquery.dataTables.min.js"></script>

	<!-- select or dropdown enhancer -->
	<script src="bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script src="bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>


</body>
</html>
