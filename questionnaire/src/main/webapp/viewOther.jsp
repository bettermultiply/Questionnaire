<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>账户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/metisMenu.min.css" rel="stylesheet">
    <link href="css/timeline.css" rel="stylesheet">
    <link href="css/startmin.css" rel="stylesheet">
    <link href="css/morris.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap-table-1.14.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="rescources/style.css" rel="stylesheet" type="text/css">
</head>
<header class="header">
    <img class="header-right" src="rescources/images/logo2.png" alt=""/>
    <span class="pull-right header-left">
        <a href=" " >
            <span class="glyphicon glyphicon-question-sign"></span>
            <strong class="size">帮助文档</strong><br><br>
        </a>
        <a href="#" >
            <span class="glyphicon glyphicon-user"></span>
            <strong class="size">个人中心</strong>
        </a>
    </span>
</header>
<body>
<br><br><br><br>
<div class="container">
    <form class="form-horizontal custom-form" role="form">
        <fieldset disabled>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="firstname" class="col-sm-2 control-label">姓</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control custom-input" id="firstname" placeholder="请输入姓">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="lastname" class="col-sm-2 control-label">名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control custom-input" id="lastname" placeholder="请输入名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control custom-input" id="username" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control custom-input" id="password" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="telephone" class="col-sm-2 control-label">电话号码</label>
                <div class="col-sm-6">
                    <input type="tel" class="form-control custom-input" id="telephone" placeholder="请输入电话号码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1"></div>
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-6">
                    <input type="email" class="form-control custom-input" id="email" placeholder="请输入邮箱">
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
<span>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/metisMenu.min.js"></script>
    <script src="js/raphael.min.js"></script>
    <script src="js/morris.min.js"></script>
    <script src="js/morris-data.js"></script>
    <script src="js/startmin.js"></script>
    <script src="bootstrap-table-1.14.1/bootstrap-table.min.js"></script>
    <script src="rescources/managerAccount.js"></script>
</span>
