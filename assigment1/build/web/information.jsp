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
            <section class="page-title bg-overlay-black parallax page-title-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h1>My Account</h1>
                            <ul class="page-breadcrumb">
                                <li><a href="Home.jsp"><i class="ti-home"></i> Home</a> <i class="ti-angle-right"></i></li>                                
                                <li><span>My Account</span> </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
            <div id="layoutSidenav_content" style="margin: 30px 40px 30px 40px">
                <main>
                    <div class="container-fluid px-4">                                              
                        <form class="row g-3" action="infomation" method="post">
                            <p class="text-danger">${error}</p>
                            <div class="col-12">
                                <label for="inputAddress" class="form-label">Name</label>
                                <input type="text" class="form-control" id="" placeholder="Nguyen van A" name="name" value="${sessionScope.account.username}">
                            </div>
                            <div class="col-md-12">
                                <label for="inputEmail4" class="form-label">Account</label>
                                <input type="text" class="form-control" id="inputEmail4" name="account"  value="${sessionScope.account.account}" readonly="">
                            </div>
                            <div class="col-12">
                                <label for="inputAddress2" class="form-label">Address</label>
                                <input type="text" class="form-control" id="inputAddress2" placeholder="Thach That Ha Noi" name="address" value="${sessionScope.account.address}">
                            </div>
                            <div class="col-md-8">
                                <label for="inputCity" class="form-label">Email</label>
                                <input type="email" class="form-control" id="inputCity" name="email" value="${sessionScope.account.email}">
                            </div>
                            <div class="col-md-4">
                                <label for="inputPhone" class="form-label">Phone</label>
                                <input type="text" class="form-control" id="inputPhone" name="phone" value="${sessionScope.account.phone}">
                            </div>
                                <input type="hidden" name="id" value="${sessionScope.account.id}" >
                                <div class="col-md-12" style="margin: 10px 0px 10px 0px">
                                <button type="submit" class="btn btn-primary">Update</button>
                            </div>
                        </form>

                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>

                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>

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
