<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce Web Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body{
            height: 100vh;
        }
    </style>
</head>
<body>
    <div class="container-fluid h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-sm-4">
            <c:if test="${hasError}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>Login Failed!</strong> ${errorMessage}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
                <form action="" method="post">
                    <div class="form-group">
                        <label class="sr-only" for="txtUsername">Username</label>
                        <div class="input-group">
                            <input type="text" class="form-control form-control-lg border-right-0" id="txtUsername" name="username" placeholder="Username" autofocus>
                            <div class="input-group-append">
                                <span class="input-group-text bg-white">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="txtPassword">Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control form-control-lg border-right-0" id="txtPassword" name="password" placeholder="Password" >
                            <div class="input-group-append">
                                <span class="input-group-text bg-white">
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group d-flex">
                        <div>
                            <a id="" class="btn btn-lg btn-outline-info" href="${pageContext.request.contextPath}/Home" role="button">
                                <i class="fa fa-home" aria-hidden="true"></i>
                                Home
                            </a>
                        </div>
                        <div class="ml-1">
                            <button type="submit" class="btn btn-lg btn-info btn-block">
                                <i class="fa fa-sign-in" aria-hidden="true"></i>
                                Sign In
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.6.1.min.js"  crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
