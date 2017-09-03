<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
			+path+"/";
	session.setAttribute("basePath",basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部商品</title>
<link rel="stylesheet" href="${basePath }res/css/userAll.css">
</head>
<body>
	<header class="top">
	<div class="menu">
		<article class="logo"> <a href="${basePath }Index.jsp"><img alt="" src="${basePath}res/img/qqcy.png" style="width:110px;height:50px;"></a> </article>
		<div class="link">
			<input type="search" id="select" name="select" class="input" placeholder="搜索" /> 
			<a href="${basePath }login.jsp" style="margin: 5px">登录/注册</a>
			<a href="${basePath }BuyStore.jsp" style="margin: 5px">购物车</a>
			<a href="#" style="margin: 5px">订单管理</a>
		</div>
	</div>
	</header>
	<div class="containner">
		<h1 style="color: #d31e29">全部商品</h1>
		<hr>
		<c:forEach items="${vegetables }" var="v">
			<div class="containner1">
				<a href="${basePath }vegetable/getVegetableById.do?v_id=${v.v_id }" ><img src="${v.v_photo }"></a>
				<div class="containner2">
					<h2>
						<a href="#" style="color: #116644">${v.v_name }</a>
					</h2>
					<hr>
					<dd>
						<h3>${v.v_title }</h3>
					</dd>
					<dd>当日送达，全程冷链运输</dd>
					<dd>
						青青草原特价：
						<h3 style="color: #d31e29">￥${v.v_price }/kg</h3>
					</dd>
					<span style="width: 300px; height: 40px">
						<button class="btn1">
							<a href="${basePath }shoppingcartinfo/add1.do?v_id=${v.v_id }">加入购物车</a>
						</button>
						<button class="btn2">
							<a href="${basePath }vegetable/getVegetableById.do?v_id=${v.v_id }"  style="color: #1f1f1f" >查看详情</a>
						</button>
					</span>
				</div>
			</div>
		</c:forEach>
	</div>
	<footer class="footer">
		<div class="img">
			<img src="${basePath }res/img/qqcy.png" style="width: 100%;height: 100%;">
		</div>
		<div class="text">
			坏单包退 | 急速退款 | 次日送达
		</div>
	</footer>
</body>
</html>