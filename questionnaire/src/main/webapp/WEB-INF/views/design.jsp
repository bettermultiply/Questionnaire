<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ques" uri="ques" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>问卷设计</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/design.css"/>">
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
        <h1>${questionnaire.tableName}</h1>
        <button type="button" class="btn btn-primary"
                onclick="openTitleModifyPopup(document.getElementById('title-popup'))">
            <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>" alt="edit icon">
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
            <button type="button" class="btn btn-primary addQuestion"
                    onclick="openAddQuestionPopup(document.getElementById('add-question-popup'))">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加问题
            </button>
        </div>
    </div>

    <div class="col-md-12 questionList">
        <ques:QuestionSort questionSet="${questionnaire.questions}"/>
        <c:forEach items="${questionList}" var="question">
            <div class="question-info col-md-12">
                <div class="col-md-6">
                    <p>${question.description}</p>
                    <span class="question-type">
                        <c:choose>
                            <%-- 判断该问题是否是填空题 --%>
                            <c:when test="${question.questionType}">
                                <img class="icon" src="<c:url value="/resources/images/icons/fillBlank-black-icon.svg"/>"
                                     alt="fillBlank icon">
                            </c:when>
                            <c:otherwise>
                                <%-- 将QuestionType类型的对象转化为QChoose对象，并将设置为属性"QChoose" --%>
                                <ques:QuestionTypeConversion question="${question}"/>
                                <%-- 判断是单选题还是多选题 --%>
                                <c:choose>
                                    <c:when test="${QChoose.chooseType}">
                                     <img class="icon" src="<c:url value="/resources/images/icons/checkbox-black-icon.svg"/>"
                                          alt="checkbox icon">
                                    </c:when>
                                    <c:otherwise>

                                    <img class="icon" src="<c:url value="/resources/images/icons/radio-black-icon.svg"/>"
                                         alt="radio icon">
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </span>
                </div>

                <div class="col-md-6 question-option">
                    <form class="question-form" method="post" action="<c:url value="/questionnaire/design/deleteQuestion.do"/>">
                        <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                        <input type="hidden" name="questionId" value="${question.questionId}">
                        <button type="submit" class="btn btn-primary">
                            <img class="icon" src="<c:url value="/resources/images/icons/delete-icon.svg"/>"
                                 alt="delete icon">
                            <span>删除问题</span>
                        </button>
                    </form>
                    <form class="question-form">
                        <button type="button" class="btn btn-primary"
                                onclick="openModifyQuestionPopup(document.getElementById('modify-question-popup'), '${question.questionId}')">
                            <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>"
                                 alt="edit icon">
                            <span>修改问题</span>
                        </button>
                    </form>
                    <form class="question-form">
                        <c:if test="${!question.questionType}">
                            <button type="button" class="btn btn-primary"
                                    onclick="openAddOptionPopup(document.getElementById('add-option-popup'), '${question.questionId}')">
                                <img class="icon" src="<c:url value="/resources/images/icons/add-selection.svg"/>"
                                     alt="statistics icon">
                                <span>新增选项</span>
                            </button>
                        </c:if>
                    </form>
                </div>
            </div>

            <c:if test="${!question.questionType}">
                <ques:ChoiceSort choiceSet="${QChoose.choices}"/>
                <c:forEach items="${choiceList}" var="choice">
                    <div class="question-info col-md-12">
                        <div class="col-md-6">
                            <div class="option-info">
                                <img class="icon" src="<c:url value="/resources/images/icons/arrow.svg"/>" alt="arrow icon">
                                <p>${choice.choiceContent}</p>
                            </div>
                        </div>
                        <div class="col-md-6 question-option">
                            <form class="question-form" method="post" action="<c:url value="/questionnaire/design/deleteChoice.do"/>">
                                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                                <input type="hidden" name="choiceId" value="${choice.choiceId}">
                                <button type="submit" class="btn btn-primary">
                                    <img class="icon" src="<c:url value="/resources/images/icons/delete-icon.svg"/>" alt="delete icon">
                                    <span>删除选项</span>
                                </button>
                            </form>
                            <form class="question-form" method="post" action="">
                                <button type="button" class="btn btn-primary"
                                        onclick="openModifyOptionPopup(document.getElementById('modify-option-popup'), '${choice.choiceId}')">
                                    <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>" alt="edit icon">
                                    <span>修改选项</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </c:forEach>
    </div>

    <div class="col-md-12 text-center check-button">
        <form method="post" action="">
            <input type="hidden" name="questionnaireId" value="">
            <button type="submit" class="btn btn-primary">
                <img class="icon" src="<c:url value="/resources/images/icons/check.svg"/>" alt="check icon">
                提交审核
            </button>
        </form>
    </div>
</div>

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

<div class="popup" id="title-popup">
    <div class="modify-title-form-contain">
        <div class="popup-title">
            <span>修改问卷标题</span>
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('title-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-form" method="post" action="<c:url value="/questionnaire/design/modifyTitle.do"/>">
                <div class="modify-title">
                    <input type="hidden" id="questionnaireId" name="questionnaireId" value="${questionnaire.tableId}">
                    <div class="form-group">
                        <label for="q-title">问卷标题</label>
                        <input class="form-control" id="q-title" name="newTitle" value="${questionnaire.tableName}">
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
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('add-question-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="add-form" method="post" action="<c:url value="/questionnaire/design/addQuestion.do"/>">
                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" name="addType" value="radio">
                <button type="submit" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/resources/images/icons/radio-icon.svg"/>" alt="radio icon">
                    添加单选题
                </button>
            </form>

            <form class="add-form" method="post" action="<c:url value="/questionnaire/design/addQuestion.do"/>">
                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" name="addType" value="checkbox">
                <button type="submit" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/resources/images/icons/checkbox-icon.svg"/>" alt="radio icon">
                    添加多选题
                </button>
            </form>

            <form class="add-form" method="post" action="<c:url value="/questionnaire/design/addQuestion.do"/>">
                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" name="addType" value="text">
                <button type="submit" class="btn btn-primary">
                    <img class="icon" src="<c:url value="/resources/images/icons/fillBlank-icon.svg"/>">
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
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('modify-question-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-form" method="post" action="<c:url value="/questionnaire/design/modifyQuestion.do"/>">
                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" id="questionModifyId" name="questionId">
                <div class="form-group">
                    <label for="question-title">问题</label>
                    <input class="form-control" id="question-title" name="newQuestionName">
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
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('add-option-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="add-option-form" method="post" action="<c:url value="/questionnaire/design/addChoice.do"/>">
                <input type="hidden"name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" id="optionAddId" name="questionId">
                <div class="form-group">
                    <label for="add-option-title">新选项</label>
                    <input class="form-control" id="add-option-title" name="newChoiceName" value="新选项">
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
            <img class="icon close-icon" src="<c:url value="/resources/images/icons/close-icon.svg"/>" alt="close icon"
                 onclick="closePopup(document.getElementById('modify-option-popup'))">
        </div>
        <hr>
        <div class="col-md-12">
            <form class="modify-option-form" method="post" action="<c:url value="/questionnaire/design/modifyChoice.do"/>">
                <input type="hidden" name="questionnaireId" value="${questionnaire.tableId}">
                <input type="hidden" id="optionModifyId" name="choiceId">
                <div class="form-group">
                    <label for="modify-option-title">新选项</label>
                    <input class="form-control" id="modify-option-title" name="newChoiceName">
                </div>
                <button type="submit" class="btn btn-primary">保存修改</button>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/design.js"/>"></script>
</body>
</html>