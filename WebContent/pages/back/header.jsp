<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
  <div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
      <span class="sr-only">图书管理系统</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="/pages/index.jsp">图书管理系统</a>
  </div>
  <!--顶部-->
  <div class="header-right">
    <a href="login.html" class="btn btn-danger" title="Logout"> 退出系统</a>
  </div>
</nav>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
  <div class="sidebar-collapse">
    <ul class="nav" id="main-menu">
      <li>
        <div class="user-img-div">
        <img src="assets/img/user.png" class="img-thumbnail" />
	      <div class="inner-text">管理员: <c:if test="${aid != null}">${aid}</c:if><br />
          <small>上次登录日期:<c:if test="${lastdate != null}">${lastdate}</c:if></small>
          </div>
        </div>
      </li>
      <li><a class="active-menu" href="#"><i class="fa fa-dashboard "></i>导航</a></li>
      <!--用户信息-->
      <li>
        <a href="#"><i class="fa fa-desktop "></i>作者管理 <span class="fa arrow"></span></a>
          <ul class="nav nav-second-level"> 
            <li><a href="/LibrarySystem/pages/back/author/author_insert.jsp"><i class="fa fa-coffee"></i>增加作者</a></li>
            <li><a href="/LibrarySystem/pages/back/mediate3.jsp"><i class="fa fa-desktop "></i>查询作者作品</a></li>
          </ul>
      </li>
      <!--图书信息-->
      <li>
        <a href="#"><i class="fa fa-yelp "></i>图书管理 <span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
              <li><a href="/LibrarySystem/pages/back/mediate2.jsp"><i class="fa fa-coffee"></i>增加图书</a></li>
              <li><a href="/LibrarySystem/pages/back/mediate3.jsp"><i class="fa fa-flash "></i>图书列表</a></li>
          	  <li><a href="/LibrarySystem/pages/back/mediate4.jsp"><i class="fa fa-desktop "></i>查询图书信息</a></li>
          	  <li><a href="/LibrarySystem/pages/back/mediate5.jsp"><i class="fa fa-flash "></i>删除图书</a></li>
			  <li><a href="/LibrarySystem/pages/back/mediate6.jsp"><i class="fa fa-dashboard"></i>更新图书信息</a></li>          
          </ul>
      </li>
    </ul>
  </div>
</nav>
