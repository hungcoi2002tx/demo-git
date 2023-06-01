<%-- 
    Document   : Register
    Created on : Mar 11, 2023, 9:58:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Register - SB Admin</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary" style=" background-image:url('https://tindep.com/wp-content/uploads/2019/10/hinh-nen-manchester-united-3.jpg') ">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main >
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form class="row g-3" action="register" method="post">
                                            <p class="text-danger">${error}</p>
                                            <div class="col-12">
                                                <label for="inputAddress" class="form-label">Name<span style="color: red"> (*)</span></label>
                                                <input type="text" class="form-control" id="" placeholder="Nguyen van A" name="name">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputEmail4" class="form-label">Account<span style="color: red"> (*)</span></label>
                                                <input type="text" class="form-control" id="inputEmail4" name="account">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputPassword4" class="form-label">Password<span style="color: red"> (*)</span></label>
                                                <input type="password" class="form-control" id="inputPassword4" name="pass">
                                            </div>
                                            
                                            <div class="col-12">
                                                <label for="inputAddress2" class="form-label">Address</label>
                                                <input type="text" class="form-control" id="inputAddress2" placeholder="Thach That Ha Noi" name="address">
                                            </div>
                                            <div class="col-md-8">
                                                <label for="inputCity" class="form-label">Email</label>
                                                <input type="email" class="form-control" id="inputCity" name="email">
                                            </div>
                                            <div class="col-md-4">
                                                <label for="inputPhone" class="form-label">Phone</label>
                                                <input type="text" class="form-control" id="inputPhone" name="phone">
                                            </div>
                                            <div class="col-12">
                                                <button type="submit" class="btn btn-primary">Sign in</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
    </body>
</html>
