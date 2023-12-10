<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>">
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
            <a class="navbar-brand" href="#">Questionnaire</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav selections">
                <li class="active"><a href="#">所有问卷<span class="sr-only">(current)</span></a></li>
                <li><a href="#">未审核问卷<span class="sr-only">(current)</span></a></li>
                <li><a href="#">已审核问卷<span class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">UserName<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">注销登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav>


<div class="container">
    <div class="jumbotron">
        <div class="container">
            <h1>UserName,</h1>
            <h1>Welcome to Questionnaire</h1>
            <h2>Questionnaire致力于为您提供便捷的问卷服务</h2>
        </div>
    </div>

    <div class="col-md-12">
        <div class="col-md-2">
            <div class="questionnaireList-title">
                <strong>问卷列表</strong>
            </div>
        </div>
        <div class="col-md-2 col-md-offset-8">
            <form method="post" action="">
                <button type="button" class="btn btn-primary addQuestionnaire">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建问卷
                </button>
            </form>
        </div>
    </div>

    <div class="col-md-12 questionnaireList">
        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">

                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>

        <div class="questionnaire-info col-md-12">
            <div class="col-md-6">
                <p>问卷1</p>
                <a href="#">
                    <img class="icon" src="<c:url value="/rescources/images/icons/link-icon.svg"/>" alt="link svg">
                </a>
            </div>
            <div class="col-md-6 questionnaire-option">
                <form class="questionnaire-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/statistics-icon.svg"/>" alt="statistics icon">
                        <span>数据统计</span>
                    </button>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="">
                        <button type="button" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </form>
            </div>
        </div>
    </div>

    <div class="col-md-12 paging">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<div class="clearfix"></div>



<div class="container-fluid footer">
    <footer>
        <div class="col-md-4 col-md-offset-4">
            <p>Questionnaire</p>
            <p>Make with BootStrap<img class="icon" src="<c:url value="/rescources/images/icons/Bootstrap.svg"/>" alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>


<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>