<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/userHome.css"/>">
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
            <img class="logo-img" src="<c:url value="/resources/images/logo2.png"/>" alt="图片加载失败">
            <a class="navbar-brand" href="<c:url value="/questionnaire"/>">Questionnaire</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav selections">
                <li ${type == 'all' ? 'class="active"' : ''}><a href="<c:url value="/questionnaire"/>">所有问卷<span class="sr-only">(current)</span></a></li>
                <li ${type == 'unchecked' ? 'class="active"' : ''}><a href="<c:url value="/questionnaire/unchecked"/>">未审核问卷<span class="sr-only">(current)</span></a></li>
                <li ${type == 'checked' ? 'class="active"' : ''}><a href="<c:url value="/questionnaire/checked"/>">已审核问卷<span class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">${commonUser.userName}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <%--                        TODO the personal message page is not built--%>
                        <li><a href="<c:url value="/questionnaire/info"/>">个人信息</a></li>
                        <li><a href="<c:url value="/commonuser/logout.do"/>">注销登录</a></li>
                    </ul>
                </li>
                <li>
                    <a href=" " target="_blank">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        <strong class="size">帮助文档</strong>
                    </a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav>


<div class="container">
    <div class="jumbotron">
        <div class="container">
            <h1>${commonUser.userName},</h1>
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
                <button type="button" class="btn btn-primary addQuestionnaire"
                        onclick="openPopup(document.getElementById('add-questionnaire-popup'))">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建问卷
                </button>
            </form>
        </div>
    </div>

    <div class="col-md-12 questionnaireList">

        <c:forEach items="${allQuestionnaire}" var="questionnaire">
            <div class="questionnaire-info col-md-12">
                <div class="col-md-6">
                    <c:choose>
                        <c:when test="${questionnaire.isPublished && questionnaire.isChecked}">
                            <img class="big-icon" src="<c:url value="/resources/images/icons/checked.png"/>" alt="checked icon">
                            <p><c:out value="${questionnaire.tableName}"/></p>
                            <a class="link" href="<c:url value="/answerQuestionnaire/${questionnaire.tableId}"/>"
                               data-toggle="tooltip" title data-original-title="<c:url value="/answerQuestionnaire/${questionnaire.tableId}"/>">
                                <img class="icon" src="<c:url value="/resources/images/icons/link-icon.svg"/>" alt="link svg">
                            </a>
                            <a class="link" href="<c:url value="/answerQuestionnaire/getQRCode/${questionnaire.tableId}"/>"
                               data-toggle="tooltip" title data-original-title="<c:url value="/answerQuestionnaire/getQRCode/${questionnaire.tableId}"/>" download="${questionnaire.tableName}" target="_blank">
                                <img class="icon" src="<c:url value="/resources/images/icons/qrcode.svg"/>" alt="link svg">
                            </a>
                        </c:when>
                        <c:when test="${questionnaire.isPublished && !questionnaire.isChecked}">
                            <img class="big-icon" src="<c:url value="/resources/images/icons/submitted_2.png"/>" alt="checked icon">
                            <p><c:out value="${questionnaire.tableName}"/></p>
                            <a class="link" href="#" data-toggle="tooltip" title data-original-title="问卷还未审核通过">
                                <img class="icon" src="<c:url value="/resources/images/icons/link-icon.svg"/>" alt="link svg">
                            </a>
                        </c:when>
                        <c:otherwise>
                            <img class="big-icon" src="<c:url value="/resources/images/icons/unSubmitted.png"/>" alt="checked icon">
                            <p><c:out value="${questionnaire.tableName}"/></p>
                            <a class="link" href="#" data-toggle="tooltip" title data-original-title="问卷还未提交审核">
                                <img class="icon" src="<c:url value="/resources/images/icons/link-icon.svg"/>" alt="link svg">
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-6 questionnaire-option">

                    <form class="questionnaire-form" method="post" action="<c:url value="/questionnaire/statistics.do"/>">
                        <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                        <input type="hidden" name="questionnaireName" value="${questionnaire.tableName}">
                        <button type="submit" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/resources/images/icons/statistics-icon.svg"/>"
                                 alt="statistics icon">
                            <span>数据统计</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="<c:url value="/questionnaire/delete.do"/>">
                        <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                        <button type="submit" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/resources/images/icons/delete-icon.svg"/>"
                                 alt="delete icon">
                            <span>删除问卷</span>
                        </button>
                    </form>
                    <form class="questionnaire-form" method="post" action="<c:url value="/questionnaire/modify.do"/>">
                        <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                        <button type="submit" class="btn btn-primary ${questionnaire.isPublished ? "disabled" : ""}">
                            <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>"
                                 alt="edit icon">
                            <span>修改问卷</span>
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="col-md-12 paging">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="0" end="${totalPage}" step="1" var="pageCount">
                    <c:choose>
                        <c:when test="${pageCount == currentPage}">
                            <li class="active"><a href="<c:url value="/questionnaire/${type == 'all' ? '' : type}/"/>${pageCount}">${pageCount + 1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/questionnaire/${type == 'all' ? '' : type}/"/>${pageCount}">${pageCount + 1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
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
            <p>Make with BootStrap<img class="icon" src="<c:url value="/resources/images/icons/Bootstrap.svg"/>"
                                       alt="bootstrap icon"></p>
            <p>© Group One</p>
        </div>
    </footer>
</div>

<div class="popup" id="add-questionnaire-popup">
    <div class="add-questionnaire-form-contain">
        <div class="popup-title">
            <span>新建问卷</span>
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('add-questionnaire-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="add-questionnaire-form" method="post" action="<c:url value="/questionnaire/add.do"/>">
                <div class="add-title">
                    <div class="form-group">
                        <label for="q-title">问卷标题</label>
                        <input class="form-control" id="q-title" name="tableName" placeholder="请输入问卷标题">
                    </div>
                    <button type="submit" class="btn btn-primary">新建问卷</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/userHome.js"/>"></script>
</body>
</html>