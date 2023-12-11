<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paranoid
  Date: 2023/12/11
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestPage</title>
</head>
<body>
<form method="post" action="<c:url value="/init/add.do"/>">
  <input type="hidden" name="tableName" value="Test">
  <button type="submit" class="btn btn-primary addQuestionnaire">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建问卷
  </button>
</form>
<form method="post" action="<c:url value="/init/addChecked.do"/>">
    <input type="hidden" name="tableName" value="Checked">
    <button type="submit" class="btn btn-primary addQuestionnaire">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建已审核问卷
    </button>
</form>
</body>
</html>
