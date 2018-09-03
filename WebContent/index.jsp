<%@page import="java.util.List"%>
<%@page import="pojo.Category"%>
<%@page import="impl.CategoryDAOimpl"%>
<%@page pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Best Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"></script>
<!-- cart -->
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic"
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic"
	rel='stylesheet' type='text/css'>
<!-- timer -->
<link rel="stylesheet" href="css/jquery.countdown.css" />
<!-- //timer -->
<!-- animation-effect -->
<link href="css/animate.min.css" rel="stylesheet">

<!-- 三级菜单 -->


<link rel="stylesheet" href="css/style1.css" />
    
<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
	
</script>
<script src="js/jquery-1.9.1.min.js"></script>
<script>
    $(document).ready(function() {
        $( '.dropdown' ).hover(
            function(){
                $(this).children('.sub-menu').slideDown(200);
            },
            function(){
                $(this).children('.sub-menu').slideUp(200);
            }
        );
    }); // end ready
</script>

<!-- //animation-effect -->
</head>

<body>
	<!-- header -->
	<div class="header">
		<div class="container">
			<div class="header-grid">
				<div class="header-grid-left animated wow slideInLeft"
					data-wow-delay=".5s">
					<ul>
						<li><i class="glyphicon glyphicon-envelope"
							aria-hidden="true"></i><a href="/shopstore/admin/index.jsp">后台</a></li>
						<li><i class="glyphicon glyphicon-earphone"
							aria-hidden="true"></i>+1234 567 892</li>
						<li><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i><a
							href="login.jsp">Login</a></li>
						<li><i class="glyphicon glyphicon-book" aria-hidden="true"></i><a
							href="register.html">Register</a></li>
					</ul>
				</div>
				<div class="header-grid-right animated wow slideInRight"
					data-wow-delay=".5s">
					<ul class="social-icons">
						<li><a href="#" class="facebook"></a></li>
						<li><a href="#" class="twitter"></a></li>
						<li><a href="#" class="g"></a></li>
						<li><a href="#" class="instagram"></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="logo-nav">
				<div class="logo-nav-left animated wow zoomIn" data-wow-delay=".5s">
					<h1>
						<a href="index.html">Best Store <span>Shop anywhere</span></a>
					</h1>
				</div>
				<div class="logo-nav-left1">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header nav_2">
							<button type="button"
								class="navbar-toggle collapsed navbar-toggle1"
								data-toggle="collapse" data-target="#bs-megadropdown-tabs">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul class="nav navbar-nav">
								<li class="active"><a href="index.html" class="act">Home</a></li>
								<!-- Mega Menu -->
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">商品列表 <b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="row">
											<div class="col-sm-4">
												<ul class="multi-column-dropdown">
													<h6>商品</h6>
													<li><a href="products.html">男装</a></li>
													<li><a href="products.html">女装</a></li>
													<li><a href="products.html">食品</a></li>
													<li><a href="products.html">电器</a>
														<ul>
															<li><a>二级类别</a>
																<ul>
																	<li><a>三级列表</a></li>
																</ul></li>
														</ul></li>
											</div>
											
											<div class="col-sm-4">
												<ul class="multi-column-dropdown">
													<h6>Kid's Wear</h6>
													<li><a href="products.html">Kids Home Fashion</a></li>
													<li><a href="products.html">Boy's Clothing</a></li>
													<li><a href="products.html">Girl's Clothing</a></li>
													<li><a href="products.html">Shoes</a></li>
													<li><a href="products.html">Brand Stores</a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</ul></li>
								<div class="col-sm-4">
											<li class="dropdown"><a href="#" ><div>商品列表</div></a>
												<ul class="sub-menu">
													<% 
													CategoryDAOimpl cdao=new CategoryDAOimpl();
								                    List<Category> cs1=cdao.findByPid(0);
								                    for(Category c1:cs1){
								                    	
								                  
													%>
													<li class="dropdown"><a href="#"><%=c1.getName()%></a>
														<ul class="sub-menu">
														<% List<Category> cs2=cdao.findByPid(c1.getId());
								                    for(Category c2:cs2){	
								                    	
								                    	
								                    	%>
								                    
													<li class="dropdown"><a href="#"><%=c2.getName()%></a>
																<ul class="sub-menu">
																<% List<Category> cs3=cdao.findByPid(c2.getId());
								                    for(Category c3:cs3){	
								                    	
								                    	
								                    	%>
															 <li><a href="#?categoryid=<%=c3.getId()%>>"><%=c3.getName()%></a></li>
																	<%} %>
																</ul></li>
															<%} %>
														</ul></li>
														<%}%>
													
												</ul></li>
												</div>
								
								
							</ul>
						</div>
					</nav>
				</div>
				<div class="logo-nav-right">
					<div class="search-box">
						<div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input"
									placeholder="Enter your search term..." type="search"
									id="search"> <input class="sb-search-submit"
									type="submit" value=""> <span class="sb-icon-search">
								</span>
							</form>
						</div>
					</div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch(document.getElementById('sb-search'));
					</script>
					<!-- //search-scripts -->
				</div>
				<div class="header-right">
					<div class="cart box_1">
						<a href="checkout.html">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span> (<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>
									items)
								</div>
								<img src="images/bag.png" alt="" />
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //header -->
	<!-- banner -->
	<div class="banner">
		<div class="container">
			<div class="banner-info animated wow zoomIn" data-wow-delay=".5s">
				<h3>Free Online Shopping</h3>
				<h4>
					Up to <span>50% <i>Off/-</i></span>
				</h4>
				<div class="wmuSlider example1">
					<div class="wmuSliderWrapper">
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-wrap">
								<div class="banner-info1">
									<p>T-Shirts + Formal Pants + Jewellery + Cosmetics</p>
								</div>
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-wrap">
								<div class="banner-info1">
									<p>Toys + Furniture + Lighting + Watches</p>
								</div>
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-wrap">
								<div class="banner-info1">
									<p>Tops + Books & Media + Sports</p>
								</div>
							</div>
						</article>
					</div>
				</div>
				<script src="js/jquery.wmuSlider.js"></script>
				<script>
					$('.example1').wmuSlider();
				</script>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="banner-bottom-grids">
				<div class="banner-bottom-grid-left animated wow slideInLeft"
					data-wow-delay=".5s">
					<div class="grid">
						<figure class="effect-julia">
							<img src="images/4.jpg" alt=" " class="img-responsive" />
							<figcaption>
								<h3>
									Best <span>Store</span><i> in online shopping</i>
								</h3>
								<div>
									<p>Cupidatat non proident, sunt</p>
									<p>Officia deserunt mollit anim</p>
									<p>Laboris nisi ut aliquip consequat</p>
								</div>
							</figcaption>
						</figure>
					</div>
				</div>
				<div class="banner-bottom-grid-left1 animated wow slideInUp"
					data-wow-delay=".5s">
					<div
						class="banner-bottom-grid-left-grid left1-grid grid-left-grid1">
						<div class="banner-bottom-grid-left-grid1">
							<img src="images/1.jpg" alt=" " class="img-responsive" />
						</div>
						<div class="banner-bottom-grid-left1-pos">
							<p>Discount 45%</p>
						</div>
					</div>
					<div
						class="banner-bottom-grid-left-grid left1-grid grid-left-grid1">
						<div class="banner-bottom-grid-left-grid1">
							<img src="images/2.jpg" alt=" " class="img-responsive" />
						</div>
						<div class="banner-bottom-grid-left1-position">
							<div class="banner-bottom-grid-left1-pos1">
								<p>Latest New Collections</p>
							</div>
						</div>
					</div>
				</div>
				<div class="banner-bottom-grid-right animated wow slideInRight"
					data-wow-delay=".5s">
					<div class="banner-bottom-grid-left-grid grid-left-grid1">
						<div class="banner-bottom-grid-left-grid1">
							<img src="images/3.jpg" alt=" " class="img-responsive" />
						</div>
						<div class="grid-left-grid1-pos">
							<p>
								top and classic designs <span>2016 Collection</span>
							</p>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //banner-bottom -->
	<!-- collections -->
	<!-- 商品开始-->




	<div class="new-collections">
		<div class="container">
			<h3 class="animated wow zoomIn" data-wow-delay=".5s">最新商品</h3>
			<p class="est animated wow zoomIn" data-wow-delay=".5s">Excepteur
				sint occaecat cupidatat non proident, sunt in culpa qui officia
				deserunt mollit anim id est laborum.</p>
			<c:forEach var="p1" items="${ps1}">
				<div class="new-collections-grids">
					<div class="col-md-3 new-collections-grid">
						<div class="new-collections-grid1 animated wow slideInUp"
							data-wow-delay=".5s">
							<div class="new-collections-grid1-image">
								<a href="single.html" class="product-image"><img
									src="images/7.jpg" alt=" " class="img-responsive" /></a>
								<div class="new-collections-grid1-image-pos">
									<a href="productload.action?id=${p1.id}">Quick View</a>
								</div>
								<div class="new-collections-grid1-right">
									<div class="rating">
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/1.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/1.png" alt=" " class="img-responsive" />
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
							<h4>
								<a href="single.html">${p1.name}</a>
							</h4>
							<p>Vel illum qui dolorem eum fugiat.</p>
							<div class="new-collections-grid1-left simpleCart_shelfItem">
								<p>
									<i>${p1.normalprice}</i> <span class="item_price">${p1.memberprice}</span><a
										class="item_add" href="#">添加购物车</a>
								</p>
							</div>
						</div>

					</div>




					<!-- 商品结束 -->

				</div>
			</c:forEach>
			<c:forEach var="p2" items="${ps2}">
				<div class="new-collections-grids">
					<div class="col-md-3 new-collections-grid">
						<div class="new-collections-grid1 animated wow slideInUp"
							data-wow-delay=".5s">
							<div class="new-collections-grid1-image">
								<a href="single.html" class="product-image"><img
									src="images/7.jpg" alt=" " class="img-responsive" /></a>
								<div class="new-collections-grid1-image-pos">
									<a href="productload.action?id=${p2.id}">Quick View</a>
								</div>
								<div class="new-collections-grid1-right">
									<div class="rating">
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/2.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/1.png" alt=" " class="img-responsive" />
										</div>
										<div class="rating-left">
											<img src="images/1.png" alt=" " class="img-responsive" />
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
							<h4>
								<a href="single.html">${p2.name}</a>
							</h4>
							<p>Vel illum qui dolorem eum fugiat.</p>
							<div class="new-collections-grid1-left simpleCart_shelfItem">
								<p>
									<i>${p2.normalprice}</i> <span class="item_price">${p2.memberprice}</span><a
										class="item_add" href="#">添加购物车</a>
								</p>
							</div>
						</div>

					</div>




					<!-- 商品结束 -->

				</div>
			</c:forEach>
		</div>
	</div>
	<!-- //collections -->
	<!-- new-timer -->
	
	<!-- //new-timer -->
	<!-- collections-bottom -->
	<div class="collections-bottom">
		<div class="container">
			<div class="collections-bottom-grids">
				<div class="collections-bottom-grid animated wow slideInLeft"
					data-wow-delay=".5s">
					<h3>
						45% Offer For <span>Women & Children's</span>
					</h3>
				</div>
			</div>
			<div class="newsletter animated wow slideInUp" data-wow-delay=".5s">
				<h3>Newsletter</h3>
				<p>Join us now to get all news and special offers.</p>
				<form>
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					<input type="email" value="Enter your email address"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter your email address';}"
						required=""> <input type="submit" value="Join Us">
				</form>
			</div>
		</div>
	</div>
	<!-- //collections-bottom -->
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid animated wow slideInLeft"
					data-wow-delay=".5s">
					<h3>About Us</h3>
					<p>
						Duis aute irure dolor in reprehenderit in voluptate velit esse.<span>Excepteur
							sint occaecat cupidatat non proident, sunt in culpa qui officia
							deserunt mollit.</span>
					</p>
				</div>
				<div class="col-md-3 footer-grid animated wow slideInLeft"
					data-wow-delay=".6s">
					<h3>Contact Info</h3>
					<ul>
						<li><i class="glyphicon glyphicon-map-marker"
							aria-hidden="true"></i>1234k Avenue, 4th block, <span>New
								York City.</span></li>
						<li><i class="glyphicon glyphicon-envelope"
							aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
						<li><i class="glyphicon glyphicon-earphone"
							aria-hidden="true"></i>+1234 567 567</li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid animated wow slideInLeft"
					data-wow-delay=".7s">
					<h3>Flickr Posts</h3>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/13.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/14.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/15.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/16.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/13.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/14.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/15.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/16.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/13.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/14.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/15.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="footer-grid-left">
						<a href="single.html"><img src="images/16.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-3 footer-grid animated wow slideInLeft"
					data-wow-delay=".8s">
					<h3>Blog Posts</h3>
					<div class="footer-grid-sub-grids">
						<div class="footer-grid-sub-grid-left">
							<a href="single.html"><img src="images/9.jpg" alt=" "
								class="img-responsive" /></a>
						</div>
						<div class="footer-grid-sub-grid-right">
							<h4>
								<a href="single.html">culpa qui officia deserunt</a>
							</h4>
							<p>Posted On 25/3/2016</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="footer-grid-sub-grids">
						<div class="footer-grid-sub-grid-left">
							<a href="single.html"><img src="images/10.jpg" alt=" "
								class="img-responsive" /></a>
						</div>
						<div class="footer-grid-sub-grid-right">
							<h4>
								<a href="single.html">Quis autem vel eum iure</a>
							</h4>
							<p>Posted On 25/3/2016</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="footer-logo animated wow slideInUp" data-wow-delay=".5s">
				<h2>
					<a href="index.html">Best Store <span>shop anywhere</span></a>
				</h2>
			</div>
			<div class="copy-right animated wow slideInUp" data-wow-delay=".5s">
				<p>
					Copyright &copy; 2016.Company name All rights reserved.More
					Templates <a href="http://www.cssmoban.com/" target="_blank"
						title="模板之家">模板之家</a> - Collect from <a
						href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</p>
			</div>
		</div>
	</div>
	<!-- //footer -->
	<div style1="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
</body>
</html>