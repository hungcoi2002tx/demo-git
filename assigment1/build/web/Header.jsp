<%-- 
    Document   : Home
    Created on : Mar 1, 2023, 9:55:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

        <!-- font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">

        <!-- Plugins -->
        <link rel="stylesheet" type="text/css" href="css/plugins-css.css" />

        <!-- Typography -->
        <link rel="stylesheet" type="text/css" href="css/typography.css" />

        <!-- Style -->
        <link rel="stylesheet" type="text/css" href="css/style.css" />

        <!-- Responsive -->
        <link rel="stylesheet" type="text/css" href="css/responsive.css" />
    </head>
    <body>
        <!--===== preloader start =====-->

        <!--===== header start =====-->

        <div class="wrapper">

            <!--            ===== header =====-->

            <header id="header" class="header default fullWidth">
                <div class="topbar">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-3 xs-mb-10">
                                <div class="topbar-call text-center text-md-left">
                                    <ul>

                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-5 xs-mb-10">
                                <div class="topbar-call text-center">
                                    <ul>

                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="topbar-social text-center text-md-right">
                                    <ul>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!--                ===== mega menu =====-->

                <div class="menu">
                    <!--                     menu start -->
                    <nav id="menu" class="mega-menu">
                        <!--                         menu list items container -->
                        <section class="menu-list-items">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12">                          
                                        <!--                                         menu links -->
                                        <div class="menu-bar">
                                            <ul class="menu-links">
                                                <li><a href="Home.jsp" data-hover="Home">Home <i
                                                            class="fa fa-angle-down d-sm-none set-icon"></i></a> </li>
                                                <li><a href="shopping" data-hover="Shop">Shop<i
                                                            class="fa fa-angle-down d-lg-none set-icon"></i> </a>
                                                </li>
                                                <c:if test="${sessionScope.account == null}">
                                                    <li><a href="login" data-hover="Login">Login <i
                                                                class="fa fa-angle-down d-lg-none set-icon"></i></a>
                                                    </li>
                                                </c:if>           
                                            </ul>
                                            
                                            <div class="search-cart">
                                                
<!--                                                <div class="shpping-cart"> <a class="cart-btn txt-white" href="cart.html"> <i
                                                            class="fa fa-shopping-cart icon"></i> <strong class="item"></strong></a>
                                                </div>-->
<!--                                                <div class="shpping-cart"> <a class="cart-btn txt-white" href="cart.html"> <i
                                                            class="fa fa-shopping-cart icon"></i> <strong class="item"></strong></a>
                                                </div>-->
                                                
                                                <div id="search" style="margin-left: 10px">
                                                    <button type="button" class="close">×</button>
                                                    <form>
                                                        <input type="search" placeholder="Search for products" />
                                                        <button type="submit" class="btn btn-primary"><span class="ti-search"></span></button>
                                                    </form>
                                                </div>
                                                <c:if test="${sessionScope.account != null}">
                                                    <div class="more"> <a class="more-btn txt-white" href="javascript:void(0)"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                                                            <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
                                                            </svg></a>
                                                        <div class="sub-more">
                                                            <ul class="my-account">
                                                                <li><a href="infomation">My Account</a></li>
                                                                <li><a href="logout">Logout</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </nav>
                    <!--                     menu end -->
                </div>
            </header><!--

            ===== End header =====

            ===== Banner Slider =====

            

            ===== End Banner Slider =====
            =====End Footer =====
        </div>-->

            <!--===== Return to Top =====-->
            <a href="javascript:" id="return-to-top"><i class="ti-angle-double-up"></i></a>
            <!--===== End Return to Top =====-->

            <!--===== jquery =====-->

            <!-- jquery -->
            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/font-aweosme.min.js"></script>
            <script src="js/mega_menu.js"></script>
            <script src="js/slick.min.js"></script>
            <script src="js/swiper.min.js"></script>

            <!-- plugin_path -->
            <script>var plugin_path = 'js/'</script>

            <!-- custom -->
            <script src="js/custom.js"></script>
    </body>
</html>
