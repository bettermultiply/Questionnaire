<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>问卷设计</title>
    <link rel="stylesheet" href="<c:url value="/rescources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/rescources/css/design.css"/>">
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
    </div><!-- /.container -->
</nav>

<div class="container design-part">
    <div class="col-md-12 text-center">
        <h1>问卷标题</h1>
        <button type="button" class="btn btn-primary"
                onclick="openTitleModifyPopup(document.getElementById('title-popup'))">
            <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
            修改标题
        </button>
    </div>

    <div class="col-md-12">
        <div class="col-md-2">
            <div class="questionList-title">
                <strong>问题列表</strong>
            </div>
        </div>
        <div class="col-md-2 col-md-offset-8">
            <form method="post" action="">
                <button type="button" class="btn btn-primary addQuestion"
                        onclick="openAddQuestionPopup(document.getElementById('add-question-popup'))">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加问题
                </button>
            </form>
        </div>
    </div>

    <div class="col-md-12 questionList">

        <div class="question-info col-md-12">
            <div class="col-md-6">
                <p>问题1</p>
                <span class="question-type">
                    <img class="icon" src="<c:url value="/rescources/images/icons/radio-black-icon.svg"/>" alt="radio icon">
                </span>
            </div>
            <div class="col-md-6 question-option">
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                        <span>删除问题</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openAddOptionPopup(document.getElementById('add-option-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/add-selection.svg"/>" alt="statistics icon">
                        <span>新增选项</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openModifyQuestionPopup(document.getElementById('modify-question-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                        <span>修改问题</span>
                    </button>
                </form>
            </div>
        </div>

        <div class="question-info col-md-12">
            <div class="col-md-6">
                <div class="option-info">
                    <img class="icon" src="<c:url value="/rescources/images/icons/arrow.svg"/>" alt="arrow icon">
                    <p>选项1</p>
                </div>
            </div>
            <div class="col-md-6 question-option">
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                        <span>删除选项</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openModifyOptionPopup(document.getElementById('modify-option-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                        <span>修改选项</span>
                    </button>
                </form>
            </div>
        </div>

        <div class="question-info col-md-12 ">
            <div class="col-md-6">
                <div class="option-info">
                    <img class="icon" src="<c:url value="/rescources/images/icons/arrow.svg"/>" alt="arrow icon">
                    <p>选项2</p>
                </div>
            </div>
            <div class="col-md-6 question-option">
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                        <span>删除选项</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openModifyOptionPopup(document.getElementById('modify-option-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                        <span>修改选项</span>
                    </button>
                </form>
            </div>
        </div>

        <div class="question-info col-md-12">
            <div class="col-md-6">
                <p>问题2</p>
                <span class="question-type">
                    <img class="icon" src="<c:url value="/rescources/images/icons/checkbox-black-icon.svg"/>" alt="checkbox icon">
                </span>
            </div>
            <div class="col-md-6 question-option">
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                        <span>删除问题</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openAddOptionPopup(document.getElementById('add-option-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/add-selection.svg"/>" alt="statistics icon">
                        <span>新增选项</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openModifyQuestionPopup(document.getElementById('modify-question-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                        <span>修改问题</span>
                    </button>
                </form>

            </div>
        </div>

        <div class="question-info col-md-12">
            <div class="col-md-6">
                <p>问题3</p>
                <span class="question-type">
                    <img class="icon" src="<c:url value="/rescources/images/icons/fillBlank-black-icon.svg"/>" alt="fillBlank icon">
                </span>
            </div>
            <div class="col-md-6 question-option">
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary">
                        <img class="icon" src="<c:url value="/rescources/images/icons/delete-icon.svg"/>" alt="delete icon">
                        <span>删除问题</span>
                    </button>
                </form>
                <form class="question-form" method="post" action="">
                    <button type="button" class="btn btn-primary"
                            onclick="openModifyQuestionPopup(document.getElementById('modify-question-popup'))">
                        <img class="icon" src="<c:url value="/rescources/images/icons/edit-icon.svg"/>" alt="edit icon">
                        <span>修改问题</span>
                    </button>
                </form>

            </div>
        </div>
    </div>

    <div class="col-md-12 text-center check-button">
        <form method="post" action="">
            <input type="hidden" name="questionnaireId" value="">
            <button type="button" class="btn btn-primary">
                <img class="icon" src="<c:url value="/rescources/images/icons/check.svg"/>" alt="check icon">
                提交审核
            </button>
        </form>
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

<div class="popup" id="title-popup">
    <div class="modify-title-form-contain">
        <div class="popup-title">
            <span>修改问卷标题</span>
            <img class="icon close-icon" src="<c:url value="/rescources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('title-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-form" method="post" action="">
                <div class="modify-title">
                    <input type="hidden" id="questionnaireId" name="questionnaireId">
                    <div class="form-group">
                        <label for="q-title">问卷标题</label>
                        <input class="form-control" id="q-title" name="title" value="问卷标题">
                    </div>
                    <button type="submit" class="btn btn-primary">保存修改</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="popup" id="add-question-popup">
    <div class="add-question-form-contain">
        <div class="popup-title">
            <span>添加问题</span>
            <img class="icon close-icon" src="<c:url value="/rescources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('add-question-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="add-form" method="post" action="">
                <input type="hidden" id="questionId" name="questionId">
                <input type="hidden" id="addType" name="addType">
                <button type="button" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/rescources/images/icons/radio-icon.svg"/>" alt="radio icon" onclick="addRadio()">
                    添加单选题
                </button>
                <button type="button" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/rescources/images/icons/checkbox-icon.svg"/>" alt="radio icon" onclick="addCheckbox()">
                    添加多选题
                </button>
                <button type="button" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/rescources/images/icons/fillBlank-icon.svg"/>" alt="radio icon" onclick="addText()">
                    添加文本题
                </button>
            </form>
        </div>
    </div>
</div>

<div class="popup" id="modify-question-popup">
    <div class="modify-question-form-contain">
        <div class="popup-title">
            <span>修改问题</span>
            <img class="icon close-icon" src="<c:url value="/rescources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('modify-question-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-form" method="post" action="">
                <input type="hidden" id="questionModifyId" name="questionModifyId">
                <div class="form-group">
                    <label for="question-title">问题</label>
                    <input class="form-control" id="question-title" name="title" value="问题">
                </div>
                <button type="submit" class="btn btn-primary">保存修改</button>
            </form>
        </div>
    </div>
</div>

<div class="popup" id="add-option-popup">
    <div class="add-option-form-contain">
        <div class="popup-title">
            <span>新增选项</span>
            <img class="icon close-icon" src="<c:url value="/rescources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('add-option-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="add-option-form" method="post" action="">
                <input type="hidden" id="optionAddId" name="optionAddId">
                <div class="form-group">
                    <label for="add-option-title">新选项</label>
                    <input class="form-control" id="add-option-title" name="title" value="新选项">
                </div>
                <button type="submit" class="btn btn-primary">新增选项</button>
            </form>
        </div>
    </div>
</div>

<div class="popup" id="modify-option-popup">
    <div class="modify-option-form-contain">
        <div class="popup-title">
            <span>修改选项</span>
            <img class="icon close-icon" src="<c:url value="/rescources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('modify-option-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-option-form" method="post" action="">
                <input type="hidden" id="optionModifyId" name="optionModifyId">
                <div class="form-group">
                    <label for="modify-option-title">新选项</label>
                    <input class="form-control" id="modify-option-title" name="title" value="新选项">
                </div>
                <button type="submit" class="btn btn-primary">保存修改</button>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/rescources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/rescources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/rescources/design.js"/>"></script>
</body>
</html>