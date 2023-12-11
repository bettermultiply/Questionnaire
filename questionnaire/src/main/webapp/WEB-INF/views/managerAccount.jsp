<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员首页</title>
    <link rel="stylesheet" href="<c:url value="/rescources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/rescources/css/home.css"/>">
    <link href="<c:url value="/rescources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/rescources/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img class="logo-img" src="<c:url value="/rescources/images/logo2.png"/>" alt="图片加载失败">
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">UserName<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="viewMe.jsp">个人信息</a></li>
                        <li><a onclick="LogOut()">注销登录</a></li>
                    </ul>
                </li>
                <li>
                    <a href=" " target="_blank">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        <strong class="size">帮助文档</strong>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<ul class="nav nav-tabs">
    <li class="active"><a href="managerAccount.jsp">管理员账号管理</a></li>
    <li><a href="managerUser.jsp">用户管理</a></li>
    <li><a href="managerQuestionnaire.jsp">问卷管理</a></li>
</ul>
<br>
<form action="#" style="margin-left: 5px">
    <a class="btn btn-info" href="addManager.jsp" role="button" style="margin-left: 50px" target="_blank">创建一个管理员账号</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" placeholder="管理员账号名.." name="search2">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>
<br><br>
<div class="table-responsive" style="text-align: center">
    <table class="table" id="table">
        <thead>
        <tr>
            <th style="text-align: center"><input type="checkbox" name="cb" id="firstCb"></th>
            <th style="text-align: center">登录名</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>管理员1</td>
            <td>
                <button onclick="myfunction()">删除</button>
                <button class="change">修改</button>
                <form class="form-horizontal changePage" role="form">
                    <p class="changeHead">修改管理员信息</p>
                    <div class="form-group">
                        <label for="lastname1" class="col-sm-2 control-label col-sm-offset-1">姓</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="lastname1" placeholder="请输入姓">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="firstname1" class="col-sm-2 control-label col-sm-offset-1">名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="firstname1" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username1" class="col-sm-2 control-label col-sm-offset-1">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username1" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password1" class="col-sm-2 control-label col-sm-offset-1">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password1" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel1" class="col-sm-2 control-label col-sm-offset-1">电话号码</label>
                        <div class="col-sm-6">
                            <input type="tel" class="form-control" id="tel1" placeholder="请输入电话号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email1" class="col-sm-2 control-label col-sm-offset-1">邮箱</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="email1" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div style="text-align: center">
                        <input type="button" value="取消" class="cancel" />
                        <input type="button" value="保存" class="save" />
                    </div>
                </form>
                <button onclick="window.location.href='viewOther.jsp'">查看</button>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb" ></td>
            <td>管理员2</td>
            <td>
                <button onclick="myfunction()">删除</button>
                <button class="change">修改</button>
                <form class="form-horizontal changePage" role="form">
                    <p class="changeHead">修改管理员信息</p>
                    <div class="form-group">
                        <label for="lastname2" class="col-sm-2 control-label col-sm-offset-1">姓</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="lastname2" placeholder="请输入姓">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="firstname2" class="col-sm-2 control-label col-sm-offset-1">名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="firstname2" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username2" class="col-sm-2 control-label col-sm-offset-1">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username2" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password2" class="col-sm-2 control-label col-sm-offset-1">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password2" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel2" class="col-sm-2 control-label col-sm-offset-1">电话号码</label>
                        <div class="col-sm-6">
                            <input type="tel" class="form-control" id="tel2" placeholder="请输入电话号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email2" class="col-sm-2 control-label col-sm-offset-1">邮箱</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="email2" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div style="text-align: center">
                        <input type="button" value="取消" class="cancel" />
                        <input type="button" value="保存" class="save" />
                    </div>
                </form>
                <button onclick="window.location.href='viewOther.jsp'">查看</button>
            </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>管理员3</td>
            <td>
                <button onclick="myfunction()">删除</button>
                <button class="change">修改</button>
                <form class="form-horizontal changePage" role="form">
                    <p class="changeHead">修改管理员信息</p>
                    <div class="form-group">
                        <label for="lastname3" class="col-sm-2 control-label col-sm-offset-1">姓</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="lastname3" placeholder="请输入姓">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="firstname3" class="col-sm-2 control-label col-sm-offset-1">名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="firstname3" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username3" class="col-sm-2 control-label col-sm-offset-1">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username3" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password3" class="col-sm-2 control-label col-sm-offset-1">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password3" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel3" class="col-sm-2 control-label col-sm-offset-1">电话号码</label>
                        <div class="col-sm-6">
                            <input type="tel" class="form-control" id="tel3" placeholder="请输入电话号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email3" class="col-sm-2 control-label col-sm-offset-1">邮箱</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="email3" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div style="text-align: center">
                        <input type="button" value="取消" class="cancel" />
                        <input type="button" value="保存" class="save" />
                    </div>
                </form>
                <button onclick="window.location.href='viewOther.jsp'">查看</button>
            </td>
        </tr>
        </tbody>
    </table>
    <div>
        <input type="button" id="selectAll" value="全选">
        <input type="button" id="unSelectAll" value="全不选">
    </div>
</div>

<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/rescources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>

</body>
<span>
    <script src="<c:url value="/rescources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/metisMenu.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/raphael.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/morris.min.js"/>"></script>
    <script src="<c:url value="/rescources/js/morris-data.js"/>"></script>
    <script src="<c:url value="/rescources/js/startmin.js"/>"></script>
    <script src="<c:url value="/rescources/bootstrap-table-1.14.1/bootstrap-table.min.js"/>"></script>
    <script src="<c:url value="/rescources/managerAccount.js"/>"></script>
</span>