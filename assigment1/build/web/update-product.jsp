<%-- 
    Document   : update-product
    Created on : Mar 14, 2023, 1:44:19 PM
    Author     : Admin
--%>

<%-- 
    Document   : Home
    Created on : Mar 10, 2023, 9:53:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="nav.jsp" %>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <%@include file="navdoc.jsp" %>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Product 
                            </div>
                            <form class="row g-3" action="productdetail" method="post" style="margin: 0px 10px 10px 10px" enctype="multipart/form-data">
                                <p class="text-danger">${error}</p>
                                <div class="col-md-6">
                                    <label for="inputName" class="form-label">Product Name <span style="color: red">(*)</span></label>
                                    <input type="text" class="form-control" id="inputName" name="name" value="${product.getName()}">
                                </div>
                          
                                <div class="col-md-2">
                                    <label for="inputColor" class="form-label">Color</label>

                                    <select id="inputColor" class="form-control" name ="color">
                                        
                                        <c:forEach items="${color}" var="c">
                                            <option <c:if test="${product.getColor_id().equals(c.getId())}">selected</c:if> value="${c.getId()}">${c.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-4">
                                    <label for="inputCategory" class="form-label">Category</label>
                                    <select id="inputCategory" class="form-control" name="category">
                                        <c:forEach items="${category}" var="c">
                                            <option <c:if test="${product.getCategory_id().equals(c.getId())}">selected</c:if> value="${c.getId()}">${c.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-3">
                                    <label for="inputPrice" class="form-label">Price<span style="color: red">(*)</span></label>
                                    <input type="text" class="form-control" id="inputPrice" name="price" value="${product.getPrice()}" inputmode="numeric">
                                </div>
                                <div class="col-md-2">
                                    <label for="inputStorage" class="form-label">Storage</label>
                                    <input type="number" class="form-control" id="inputStorage" name="storage"  value="${product.getStorage()}">
                                </div>
                                <div class="col-md-2">
                                    <label for="inputRam" class="form-label">Ram</label>
                                    <input type="number" class="form-control" id="inputRam" name="ram"  value="${product.getRam()}" >
                                </div>
                                <div class="col-md-3">
                                    <label for="inputBattery" class="form-label">Battery</label>
                                    <input type="number" class="form-control" id="inputBattery" name="battery"  value="${product.getBattery()}">
                                </div>
                                <div class="col-md-2">
                                    <label for="inputGuarantee" class="form-label">Guarantee</label>
                                    <input type="number" class="form-control" id="inputRam" name="guarantee"  value="${product.getGuarantee()}">
                                </div>
                                <div class="col-md-4">
                                    <label for="inputNumber_Sim" class="form-label">Number_Sim</label>
                                    <input type="number" class="form-control" id="inputNumber_Sim" name="sim"  value="${product.getSim()}">
                                </div>
                                <div class="col-md-4">
                                    <label for="inputYear" class="form-label">Year</label>
                                    <input type="number" class="form-control" id="inputYear" name="year"  value="${product.getYear()}" >
                                </div>
                                <div class="col-md-4">
                                    <label for="inputOrigin" class="form-label">Origin</label>
                                    <input type="text" class="form-control" id="inputOrigin" name="origin"  value="${product.getOrigin()}" >
                                </div>

                                <div class="col-12">
                                    <label for="inputSystem" class="form-label">System</label>
                                    <input type="text" class="form-control" id="inputSystem" name="system" value="${product.getSystem()}">
                                </div>
                                <div class="col-md-4">
                                    <label for="inputCity" class="form-label"></label>
                                    <img src="assets/img/${product.getImage()}"style="height: 350px; width: 350px" alt="alt"/>
                                    <input type="file" class="form-control" id="inputCity" name="img" value="${product.getImage()}" >
                                </div>
                                <div class="col-md-8">
                                    <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="desciption">${product.getDescription()}</textarea>
                                </div>
                                <input type="hidden" name="oldimg" value="${product.getImage()}" >
                                <input type="hidden" name="id" value="${product.getId()}" >
                                <input type="hidden" name="mode" value="update" >
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary">Update</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

