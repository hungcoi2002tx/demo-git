<%-- 
    Document   : ProductDetail
    Created on : Mar 18, 2023, 1:58:39 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>E-shoppers - Responsive Multi-purpose HTML5 Template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" href="images/favicon.ico" />

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
        <div id="pre-loader"> <img class="img-fluid" src="images/loader.gif" alt=""> </div>
        <!--===== preloader end =====--> 

        <!--===== header start =====-->

        <div class="wrapper"> 

            <%@include file="Header.jsp" %>

            <!--===== page-title =====-->

            <section class="page-title bg-overlay-black parallax page-title-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Product Detail</h1>
                            <ul class="page-breadcrumb">
                                <li><a href="home"><i class="ti-home"></i> Home</a> <i class="ti-angle-right"></i></li>
                                <li><a href="shopping">shopping</a> <i class="ti-angle-right"></i></li>
                                <li><span>Product Detail</span> </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>

            <!--===== End page-title =====--> 

            <!--=====Product Detail Section =====-->
            <section class="page-section-ptb">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-5"> 

                            <!--Top Slider start-->
                            <div class="swiper-container gallery-top ">
                                <div class="swiper-wrapper ">
                                    <div class="swiper-slide gallery-top-img"> <img class="img-fluid" src="assets/img/${p.getImage()}"/> </div>
                                </div>
                                <!--Controls-->

                            </div>
                            <!--Top Slider end--> 

                            <!--Bottom Slider start-->
                            <div class="swiper-container gallery-thumbs">
                                <div class="swiper-wrapper">
                                </div>
                                <!--Controls--> 
                                <!--<div class="swiper-button-next swiper-button-white control-btn"></div>
                                                                    <div class="swiper-button-prev swiper-button-white control-btn"></div>--> 
                            </div>
                            <!--Bottom Slider end--> 

                        </div>

                        <!--Product detail-->
                        <div class="col-lg-8 col-md-7">
                            <div class="product-list-view xs-mb-20">
                                <h5>Siêu Chất</h5>
                                <h4>${p.getName()}</a></h4>
                                <div class="product-price"> <ins>${p.getPrice()}</ins> </div>
                                <p class="d-md-none d-lg-block text-justify">${p.getDescription()}</p>
                            </div>
                           
                            <div class="row">
                                <div class="col-lg-6">
                                    <table class="table table-borderless bg-light mb-30">
                                        <tbody>
                                            <tr>
                                                <td>Color</td>
                                                <td>${p.getColor()}</td>
                                            </tr>
                                            <tr>
                                                <td>Brand</td>
                                                <td>${p.getBrand()}</td>
                                            </tr>
                                            <tr>
                                                <td>Storage</td>
                                                <td>${p.getStorage()}</td>
                                            </tr>
                                            <tr>
                                                <td>Ram</td>
                                                <td>${p.getRam()}</td>
                                            </tr>
                                            <tr>
                                                <td>Battery</td>
                                                <td>${p.getBattery()}</td>
                                            </tr>
                                            <tr>
                                                <td>Guarantee</td>
                                                <td>${p.getGuarantee()}</td>
                                            </tr>
                                            <tr>
                                                <td>Number-Sim</td>
                                                <td>${p.getSim()}</td>
                                            </tr>
                                            <tr>
                                                <td>Systerm</td>
                                                <td>${p.getSystem()}</td>
                                            </tr>
                                            <tr>
                                                <td>Year</td>
                                                <td>${p.getYear()}</td>
                                            </tr>
                                            <tr>
                                                <td>Origin</td>
                                                <td>${p.getOrigin()}</td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-6">
                                    <div class="box mb-30">
                                        <button class="minus">-</button>
                                        <input value="1" class="quantity text-center bg-white">
                                        <button class="plus">+</button>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="row">
                                <div class="col-lg-6 xs-mb-15 sm-mb-15"> <a class="btn theme-button animated slideInRight" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i> Add To Cart </a> </div>
                                <div class="col-lg-6">
                                    
                                </div>
                            </div>
                        </div>
                        <!--product detail end--> 
                    </div>
                </div>
            </section>
            <!--=====End Product detail Section =====--> 

            <!--===== Add Banner Section =====-->
            <section class="page-section-ptb">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 banner-img xs-mb-15 sm-mb-30"><a href="javascript:void(0)"><img class="img-fluid w-100" src="images/banner/HUNGNMHE160427.jpg" alt=""></a> </div>
                    </div>
                </div>
            </section>
            <!--=====End Add Banner Section =====--> 

            <!--===== Footer =====--> 
            <footer class="page-section-pt bg-black">
                <div class="container">
                    <div class="row pb-80">
                        ĐÂY LÀ PHÚT TỜ
                    </div>                       
                </div>
            </footer>
            <!--=====End Footer =====--> 
        </div>

        <!--===== Return to Top =====--> 
        <a href="javascript:" id="return-to-top"><i class="ti-angle-double-up"></i></a> 
        <!--===== End Return to Top =====--> 

        <!--===== Start Modal Quick view =====-->



        <!--===== jquery =====--> 

        <!-- jquery --> 
        <script src="js/jquery-3.3.1.min.js"></script> 
        <script src="js/bootstrap.min.js"></script> 
        <script src="js/font-aweosme.min.js"></script> 
        <script src="js/mega_menu.js"></script> 
        <script src="js/slick.min.js"></script> 
        <script src="js/swiper.min.js"></script> 
        <!-- plugin_path --> 
        <script>var plugin_path = 'js/';</script> 

        <!-- custom --> 
        <script src="js/custom.js"></script>
    </body>
</html>
