<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ques" uri="ques" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>问卷</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/questionnaire.css"/>">
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
            <a class="navbar-brand" href="<c:url value="/"/>">Questionnaire</a>
        </div>
    </div><!-- /.container -->
</nav>

<div class="container questionnaire-part">
    <div class="col-md-12 questionnaire-contain">
        <div class="col-md-12 questionnaire-title text-center">
            <p>${questionnaire.tableName}</p>
        </div>
        <form id="answerForm" method="post" action="">
            <ques:QuestionSort questionSet="${questionnaire.questions}"/>
            <c:forEach items="${questionList}" var="question" varStatus="questionOrder">
                <div class="col-md-12 question">
                    <p>${questionOrder.count}.${question.description}</p>
                    <input type="hidden" id="questionId${questionOrder.count}" name="questionId"
                           value="${question.questionId}">
                    <c:choose>
                        <c:when test="${question.questionType}">
                            <label>
                                <textarea class="form-control" rows="4" cols="60"
                                          name="question${questionOrder.count}"></textarea>
                            </label>
                        </c:when>
                        <c:otherwise>
                            <ques:QuestionTypeConversion question="${question}"/>
                            <ques:ChoiceSort choiceSet="${QChoose.choices}"/>
                            <c:choose>
                                <c:when test="${QChoose.chooseType}">
                                    <c:forEach items="${choiceList}" var="choice">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="question${questionOrder.count}"
                                                       value="${choice.choiceId}">
                                                    ${choice.choiceContent}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${choiceList}" var="choice">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="question${questionOrder.count}"
                                                       value="${choice.choiceId}">
                                                    ${choice.choiceContent}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>

            <c:choose>
                <c:when test="${questionnaire.isPublished}">
                    <div class="col-md-12 submitButton text-center">
                        <button type="button" class="btn btn-primary" onclick="submitForm()">
                            <img class="icon" src="<c:url value="/resources/images/icons/submit-icon.svg" />" alt="submit icon">
                            提交问卷
                        </button>
                    </div>
                </c:when>
                <c:when test="${not empty manager}">
                    <div class="col-md-12 submitButton text-center">
                        <a href="<c:url value="/manager/manageQuestionnaire"/>">
                            <button type="button" class="btn btn-primary">
                                <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>" alt="edit icon">
                                返回审核页面
                            </button>
                        </a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-md-12 submitButton text-center">
                        <a href="<c:url value="/questionnaire/design/${questionnaire.tableId}"/>">
                            <button type="button" class="btn btn-primary">
                                <img class="icon" src="<c:url value="/resources/images/icons/edit-icon.svg"/>" alt="edit icon">
                                返回设计页面
                            </button>
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>

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

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/questionnaire.js"/>"></script>
</body>
</html>