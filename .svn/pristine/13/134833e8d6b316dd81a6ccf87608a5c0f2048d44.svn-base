<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'storeManagement.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h3>搜索部分</h3>
  <hr/>
  <form action="${basePath }vegetable/list.do" method="post">
  <!-- name属性是实体类中的属性，在dao.xml中判断也要用实体类中的属性 -->
            搜索所有蔬菜：<br/>
   <input type="text" name="v_name" />
   <button type="submit">查询</button><br />
   </form>
   <table>
   <tr>
   <th>种类名</th>
   <th>蔬菜名</th>
   <th>单价</th>
   <th>数量</th>
   <th>描述</th>
   <th>图片</th>
   <th>上传时间</th>
   <th>操作</th>
   </tr>
   
   <c:forEach items="${vegetables}" var="v">
   <tr>
   <td>${v.species.sp_name}</td>
   <td>${v.v_name}</td>
   <td>${v.v_price}</td>
   <td>${v.v_num}</td>
   <td>${v.v_discribe}</td>
   <td><img src="${v.v_photo}" style="width:30px;height:40px;object-fit:contain;"/></td>
   <td>${v.v_createtime}</td>
   <td><a href="${basePath }vegetable/loadupdate.do?v_id=${v.v_id}">修改</a> <a href="${basePath }vegetable/delete.do?v_id=${v.v_id}">删除</a></td>
   </tr>
   </c:forEach>
   </table>
       <!-- 分页标签   items表示一共多少条   maxIndexPages表示5 6 7这种页面    maxItems=length  scope为某个作用域-->
    <pg:pager items="${total }" maxIndexPages="3" maxPageItems="2" url="${basePath }vegetable/list.do" scope="request">
        <pg:param name="v_name" value="${ vegetablenamequery}"/>
        <pg:param name=""/>
        <jsp:include page="res/pager_tag.jsp"></jsp:include>
    </pg:pager>
  </body>
</html>
