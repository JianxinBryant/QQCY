<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>管理员主页</title>
</head>
<body>
	<a href="${basePath }vegetable/loadadd.do">添加蔬菜</a>
	<h3>
		<a href="${basePath }vegetable/list.do">商品信息</a>
	</h3>
	<form action="${basePath }vegetable/list.do" method="post">
		<input type="" placeholder="请输入蔬菜名" name="v_name"> 种类 <select
			name="species.sp_id">
			<option value="">————</option>
			<c:forEach items="${speciess }" var="s">
				<option value="${s.sp_id }">${s.sp_name }</option>
			</c:forEach>
		</select>
		<button type="submit">查询</button>
	</form>
	<table>
		<tr>
			<th>编号</th>
			<th>蔬菜名</th>
			<th>售价</th>
			<th>数量</th>
			<th>描述</th>
			<th>图片</th>
			<th>上架时间</th>
			<th>所属种类</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${vegetables }" var="v">
			<tr>
			<td><input ty></td>
				<td>${v.v_id }</td>
				<td>${v.v_name }</td>
				<td>${v.v_price }</td>
				<td>${v.v_num }</td>
				<td>${v.v_discribe }</td>
				<td>${v.v_photo }</td>
				<td>${v.v_createtime}</td>
				<td>${species.sp_name }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 分页标签 -->
	<pg:pager items="${total }" maxIndexPages="3" maxPageItems="10"
		url="${basePath }vegetable/list.do" scope="request">
		<pg:param name="v_name" value="${vegetablenamequery}" />
		<pg:param name="species.id" value="${vegetablespeciesidquery }" />
		<jsp:include page="res/pager_tag.jsp"></jsp:include>
	</pg:pager>
</body>
</html>