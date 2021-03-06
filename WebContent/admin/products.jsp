
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="pojo.User"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   
    <meta charset="gbk">
    <title>11</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href="bower_components/fullcalendar/dist/fullcalendar.css" rel='stylesheet'>
    <link href="bower_components/fullcalendar/dist/fullcalendar.print.css" rel='stylesheet' media='print'>
    <link href="bower_components/chosen/chosen.min.css" rel="stylesheet">
    <link href="bower_components/colorbox/example3/colorbox.css" rel="stylesheet">
    <link href="bower_components/responsive-tables/responsive-tables.css" rel='stylesheet'>
    <link href="bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css" rel='stylesheet'>
    <link href="css/jquery.noty.css" rel='stylesheet'>
    <link href="css/noty_theme_default.css" rel='stylesheet'>
    <link href="css/elfinder.min.css" rel='stylesheet'>
    <link href="css/elfinder.theme.css"rel='stylesheet'>
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
  <!-- header -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>Charisma</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

        </div>
    </div>
    <!-- topbar ends -->

    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                       <li><a class="ajax-link" href="/shopstore/index.action"><i class="glyphicon glyphicon-home"></i><span>前台</span></a>
                        </li>
                        <li><a class="ajax-link" href="adminlist.do"><i class="glyphicon glyphicon-home"></i><span>管理员管理</span></a>
                        </li>
                        <li><a class="ajax-link" ><i class="glyphicon glyphicon-eye-open"></i><span> 用户管理</span></a>
                        </li>
                      <li><a href="categorylist.do">类别管理</a></li>
                        <li><a class="ajax-link" href="userlist.do"><i
                                    class="glyphicon glyphicon-align-justify"></i><span> 用户列表</span></a></li>
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 商品管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">商品搜索</a></li>
                                <li><a href="productlist.do">商品列表</a></li>
                                <li><a href="productaddload.do">商品添加</a></li>
                            </ul>
                        </li>
                        <li><a class="ajax-link" href="calendar.html"><i class="glyphicon glyphicon-calendar"></i><span> 订单管理</span></a>
                        </li>
                      
                    </ul>
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div>
        <!--header-->\
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
                <div>
        <ul class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Tables</a>
            </li>
        </ul>
    </div>

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> Datatable + Responsive</h2>

        <div class="box-icon">
            <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
            <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
        </div>
    </div>
    <div class="box-content">
    <tr >
        <th><font size="4" color="black"><a class="ajax-link" href="userlist.do">用户ID</a></font></th>
        <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th>
        <th><font size="4" color="black"><a href="index.jsp">主页</a></font></th>
         <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th> 
                <th><font size="4" color="black"><a href="adminlist.do">管理员列表</a></font></th>
         <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th>
        <th><font size="4" color="black">用户列表</font></th>
         <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th>
        <th><font size="4" color="black"><a href="categorylist.do">类别列表</a></font></th>
         <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th>
         <th><font size="4" color="black">商品列表</font></th>
          <th>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </th>
        <th><font size="4" color="black">操作</font></th>
    </tr>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品描述</th>
        <th>普通价格</th>
        <th>会员价格</th>
         <th>上架日期</th>
        <th>所属类别</th>
    </tr>
    </thead>
    <tbody>
   
    <c:forEach var="p" items="${products}">
    
   <tr>
        <td>${p.id}</td>
        <td class="center">${p.name}</td>
        <td class="center">${p.descr}</td>
        <td class="center">${p.normalprice }</td>
         <td>${memberprice}</td>
         <td>${p.pdata}</td>
          <td>${p.category.name}</td>
        <td class="center">
            <a class="btn btn-success" href="#">
                <i class="glyphicon glyphicon-zoom-in icon-white"></i>
               操作
            </a>
            <a class="btn btn-info" href="#">
                <i class="glyphicon glyphicon-edit icon-white"></i>
             编辑用户名
            </a>
            <a class="btn btn-danger" href="#">
                <i class="glyphicon glyphicon-trash icon-white"></i>
               删除
            </a>
        </td>
       
    </tr>
   </c:forEach>
 
  
    </tbody>
    </table>
    </div>
    </div>
    </div>
    <!--/span-->


    

      
   

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
   

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">g</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
                Usman</a> 2012 - 2015</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
    </footer>

</div><!--/.fluid-container-->

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
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
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
