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

            <%@include file="Header.jsp" %>

            <section id="main-slider">
                <div id="demo" class="carousel slide" data-ride="carousel">
                    <ul class="carousel-indicators d-flex align-content-end">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>
                    <div class="carousel-inner">
                        <div class="carousel-item active"> <img class="img-fluid" src="images/banner/14.jpg" alt="Banner 1">
                            <div class="slider-content">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xl-6 col-md-12 col-sm-12 offset-xl-6 bottom-15">
                                            <div class="p-5 xx-p-15 text-right" style="background-color: rgba(146, 146, 130, 0.295)">
                                                <h1 class="text-uppercase animated lightSpeedIn"><span>Ipone</span> Hot Seller </h1>
                                                <p class="mt-20 mb-30 animated slideInLeft">Enjoy up to 30% Off</p>
                                                <a class="btn theme-button animated slideInRight" href="shopping?cateSelected=1">Shop Now </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item"> <img class="img-fluid" src="images/banner/15.jpg" alt="Banner 2">
                            <div class="slider-content">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xl-6 col-md-12 col-sm-12 bottom-15">
                                            <div class="p-5 xx-p-15 text-left" style="background-color: rgba(146, 146, 130, 0.295)">
                                                <h1 class="text-uppercase animated rollIn"><span>SamSung</span> surprise price </h1>
                                                <p class="mt-20 mb-30 animated slideInLeft">Enjoy up to 20% Off</p>
                                                <a class="btn theme-button animated slideInRight" href="shopping?cateSelected=2">Shop Now </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item"> <img class="img-fluid" src="images/banner/12.jpg" alt="Banner 3">
                            <div class="slider-content">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xl-6 col-md-12 col-sm-12 offset-xl-3 bottom-15">
                                            <div class="p-5 xx-p-15 text-center" style="background-color: rgba(146, 146, 130, 0.295)">
                                                <h1 class="text-uppercase animated jackInTheBox"><span>Xiaomi</span>Super durable</h1>
                                                <p class="mt-20 mb-30 animated slideInLeft">Enjoy up to 50% Off</p>
                                                <a class="btn theme-button animated slideInRight" href="shopping?cateSelected=3">Shop Now </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#demo" data-slide="prev"><span><i
                                class="fas fa-long-arrow-alt-left fa-2x"></i></span> </a> <a class="carousel-control-next" href="#demo"
                                                                                 data-slide="next"> <span><i class="fas fa-long-arrow-alt-right fa-2x"></i></span> </a>
                </div>
            </section><!--

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
