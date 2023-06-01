<%-- 
    Document   : shopping
    Created on : Mar 3, 2023, 12:06:11 AM
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
        <div id="pre-loader"> <img class="img-fluid" src="images/loader.gif" alt=""> </div>
        <!--===== header start =====-->

        <div class="wrapper">

            <!--===== header =====-->

            <%@include file="Header.jsp" %>

            <!--===== End header =====-->


            <!--===== page-title =====-->

            <section class="page-title bg-overlay-black parallax page-title-bg">
                <div class="container">
                    <div class="row"> 
                        <div class="col-lg-12">
                            <h1>Shopping</h1> 
                            <ul class="page-breadcrumb">
                                <li><a href="Home.jsp"><i class="ti-home"></i> Home</a> <i class="ti-angle-right"></i></li>
                                <li>Shopping</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>

            <!--===== End page-title =====-->

            <!--=====Product List Section =====-->
            <section class="page-section-pt">
                <div class="container">
                    <div class="row">

                        <!--Product Left Sidebar start-->
                        <div class="col-lg-3 col-md-4">
                            <!-- Sidebar Start -->
                            <div class="filter-sidebar">
                                <!--Start Category filter Start -->
                                <form action="action" method="post">
                                    <div class="filter-widget">
                                        <div class="filter-title">
                                            <h5>Categories</h5>
                                        </div>

                                        <ul class="filter-list">
                                            <c:forEach items="${requestScope.category}" var="list">

                                                <div class="custom-control custom-checkbox mb-3">
                                                    <input
                                                        <c:if test="${cateSelected.equals(list.getId()) }">checked</c:if>
                                                        type="radio" id="customCheck${list.getId()}" name="category" value="${list.getId()}" onchange='changeCate(this)'>
                                                    <label for="customCheck${list.getId()}">${list.getName()}</label>
                                                </div>
                                            </c:forEach>   
                                            <div class="custom-control custom-checkbox mb-3">
                                                <input
                                                    <c:if test="${cateSelected.equals('empty') }">checked</c:if>
                                                    type="radio" id="customCheck${list.getId()}" name="category" value="empty" onchange='changeCate(this)'>
                                                <label class="submit-btn" for="customCheck${list.getId()}" style="color: red">All Category</label>
                                            </div>
                                        </ul>

                                    </div>
                                    <!-- Category filter End -->

                                    <!-- Price filter Start -->
<!--                                    <div class="filter-widget">
                                        <div class="filter-title">
                                            <h5>Filter by price</h5>
                                        </div>
                                        <ul class="filter-list">
                                            <li>
                                                <div class="custom-control custom-radio mb-3">
                                                    <input 
                                                        <c:if test="${priceSelected eq '1'}">active</c:if>
                                                            type="radio" class="custom-control-input" id="price0" name="radio1" value="1">
                                                        <label class="custom-control-label" for="price0">less than 5.000.000 vnd </label>
                                                    </div> 
                                                </li>
                                                <li>
                                                    <div class="custom-control custom-radio mb-3">
                                                        <input 
                                                        <c:if test="${priceSelected eq '2'}">active</c:if>
                                                            type="radio" class="custom-control-input" id="price1" name="radio1" value="2">
                                                        <label class="custom-control-label" for="price1">5.000.000-10.000.000 vnd </label>
                                                    </div> 
                                                </li>
                                                <li>
                                                    <div class="custom-control custom-radio mb-3">
                                                        <input 
                                                        <c:if test="${priceSelected eq '3'}">active</c:if>
                                                            type="radio" class="custom-control-input" id="price2" name="radio1" value="3">
                                                        <label class="custom-control-label" for="price2">10.000.000-20.000.000 vnd</label>
                                                    </div> 
                                                </li>
                                                <li>
                                                    <div class="custom-control custom-radio">
                                                        <input 
                                                        <c:if test="${priceSelected eq '4'}">active</c:if>
                                                            type="radio" class="custom-control-input" id="price3" name="radio1" value="4">
                                                        <label class="custom-control-label" for="price3">20.000.000 and more vnd </label>
                                                    </div> 
                                                </li>

                                            </ul>
                                        </div>-->
                                        <!-- End Price filter -->

                                        <!-- Color filter Start -->
                                        <div class="filter-widget">
                                            <div class="filter-title">
                                                <h5>Filter by color</h5>
                                            </div>
                                        <c:forEach items="${color}" var="c">
                                            <input 
                                                <c:if test="${colorSelected.equals(c.getId()) }">checked</c:if>
                                                type="radio" name="color" id="color${c.getId()}" value="${c.getId()}" onchange="changeColor(this)">
                                            <label for="color${c.getId()}">${c.getName()} </label><br>
                                             
                                        </c:forEach>
                                            <input 
                                                
                                                type="radio" name="color" id="color${c.getId()}" value="empty" onchange="changeColor(this)">
                                            <label for="color${c.getId()}">All Color </label><br>
                                    </div>
                                    <!-- Color filter End -->
                                </form>

                            </div>
                            <!-- Sidebar End -->
                        </div>

                        <!--Product Left sidebar end-->

                        <!--Product Right-->
                        <div class="col-lg-9 col-md-8">
                            <!-- Start Product List top-->
                            <div class="product-widget mb-3">
                                <div class="row ">
                                    <div class="col-lg-3 col-7">
                                        <select name="selectvalue" class="custom-select" onchange="change(this)">
                                            <option selected></option>
                                            <option value="tang">Gia Tang Dan</option>
                                            <option value="giam">Gia Giam Dan</option>
                                        </select>
                                    </div>
                                    
                                </div>
                            </div>
                            <!-- End Product List top-->

                            <!-- Start Product List-->
                            <div class="row">
                                <!--item-->
                                <c:forEach items="${product}" var="p">
                                    <div class="col-lg-4 col-md-6">
                                        <div class="productblock product-list-wrap product-list">
                                            <div class="Content">
                                                <a href="product-detail?id=${p.getId()}">
                                                    <img class="img-fluid" src="assets/img/${p.getImage()}" alt="">		
                                                </a>
                                                    <span class="new">${p.getSee()}</span>
                                                
                                                <div class="product-title"><a href="product-detail?id=${p.getId()}">${p.getName()}</a></div>

                                                <div class="product-price"> <ins>${p.getPrice()}</ins></div>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>


                                <!-- End Product List-->

                                <!-- Start Pagination-->
                                <div class="product-widget col-lg-12 col-md-12">
                                    <ul class="pagination justify-content-center">
                                        <li class="page-item"><a hidden=""4 class="page-link" href="javascript:void(0)"><span class="ti-angle-double-left"></span></a></li>

                                        <c:forEach begin="1" end="${sizePage}" var="i">
                                            <li  <c:if test="${page == i}">class="page-item active"</c:if>
                                                                           <c:if test="${page != i}">class="page-item"</c:if>
                                                                           ><a class="page-link" href="shopping?page=${i}">${i}</a></li>
                                            </c:forEach>

                                            <li class="page-item"><a class="page-link" hidden="" href="javascript:void(0)"><span class="ti-angle-double-right"></span></a></li>
                                    </ul>
                                </div>
                                <!-- End Pagination-->

                            </div>
                            <!--Product Right-->
                        </div>  
                    </div>
            </section>
            <!--=====End Product List Section =====-->

            <!--===== Add Banner Section =====-->
            <section class="page-section-ptb">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 banner-img xs-mb-15 sm-mb-30"><a href="javascript:void(0)"><img class="img-fluid w-100" src="images/banner/HUNGNMHE160427.jpg" alt=""></a>
                        </div>
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

        <!--===== End Modal Quick view =====-->

        <!--===== jquery =====--> 
        <script>
            function change(a) {
                
                    location.assign("shopping?sort=" + a.value);

            }
            function changeCate(a) {
                if (a.checked) {
                    location.assign("shopping?cateSelected=" + a.value);
                } else {
                    location.assign("shopping?cateSelected=empty");
                }
            }
            function changeColor(a) {
                if (a.checked) {
                    location.assign("shopping?colorSelected=" + a.value);
                } else {
                    location.assign("shopping?colorSelected=empty");
                }
            }
        </script>
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
