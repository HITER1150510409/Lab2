<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
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
      <c:if test="${allBooks != null}">
        <table class="table">
          <tr>
          <th>ISBN编号</th>
          <th>图书名称</th>
          <th>出版日期</th>
          <th>出版商</th>
          <th>定价</th>
          </tr>
          <c:forEach items="${allBooks}" var="books">
          <tr>
            <td>${books.isbn}</td>
            <td>${books.name}</td>
            <td>${books.credate}</td>
            <td>${books.publisher}</td>
			<td>${books.price}</td>
          </tr>
          </c:forEach>
        </table>
      </c:if>
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
