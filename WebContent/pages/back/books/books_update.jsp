<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <base href="<%=basePath%>">
  <title>图书管理系统</title>
  <link href="assets/css/bootstrap.css" rel="stylesheet" />
  <link href="assets/css/font-awesome.css" rel="stylesheet" />
  <link href="assets/css/basic.css" rel="stylesheet" />
  <link href="assets/css/custom.css" rel="stylesheet" />
  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
<jsp:include page="/pages/back/header.jsp"></jsp:include>
<!-- 此处编写内容  -->
  <div id="page-wrapper">
    <div id="page-inner">
      <div class="col-md-12">
        <div class="col-md-6 col-md-offset-4"><h1 class="h1">增加图书操作</h1></div>
        <div class="col-md-12"><hr></div>
      </div>
      <%--编写数据增加表单--%>
      <form action="BooksUpdate" class="form-horizontal" id="CheckForm">
      <c:if test="${allAuthor != null}">
      <%--aid--%>
      <div class="form-group">
      <label for="aname" class="col-md-3 control-label">作者姓名</label>
      <div class="col-md-6">
      <select class="form-control"id="aname" name="aname">
        <c:forEach items="${allAuthor}" var="author"><option value="${author.name}">${author.name}</option></c:forEach>
      </select>
      </div>
      </div>
      </c:if>
      <c:if test="${allBooks != null}">
      <%--aid--%>
      <div class="form-group">
      <label for="name" class="col-md-3 control-label">书籍名称</label>
      <div class="col-md-6">
      <select class="form-control"id="name" name="name">
        <c:forEach items="${allBooks}" var="books"><option value="${books.name}">${books.name}</option></c:forEach>
      </select>
      </div>
      </div>
      </c:if>
      <%--图书isbn编号--%>
      <div class="form-group">
      <label for="isbn" class="col-md-3 control-label">isbn编号</label>
        <div class="col-md-6"><input type="text" name="isbn" id="isbn" class="form-control input-sm"></div>
      </div>
      <%--出版日期--%>
      <div class="form-group">
      <label for="credate" class="col-md-3 control-label">出版日期</label>
        <div class="col-md-6"><input type="text" name="credate" id="credate" class="form-control input-sm"></div>
      </div>
      <%--出版商--%>
      <div class="form-group">
      <label for="publisher" class="col-md-3 control-label">出版商</label>
        <div class="col-md-6"><input type="text" name="publisher" id="publisher" class="form-control input-sm"></div>
      </div>
      <%--定价--%>
      <div class="form-group">
      <label for="price" class="col-md-3 control-label">定价</label>
        <div class="col-md-6"><input type="text" name="price" id="price" class="form-control input-sm"></div>
      </div>   
	 <!--内容简介-->
     <div class="form-group">
     <label for="note" class="col-md-3 control-label">内容简介</label>
     <div class="col-md-6"><textarea name="note" id="note" class="form-control"></textarea></div>
     </div>
	 <div class="form-group">
     <div class="col-md-5 col-md-offset-3">
     <button type="submit" class="btn btn-success c">提交</button>
     <button type="reset" class="btn btn-success">重置</button>
     </div>
   </div>
   </form>
</div>
</div>
</div>


<jsp:include page="/pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>

<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/CheckInput.js"></script>
</body>
</html>
