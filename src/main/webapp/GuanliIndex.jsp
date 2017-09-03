<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
			+path+"/";
	session.setAttribute("basePath",basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="${basePath }res/css/GuanliIndex.css">
</head>
<body>
</head>
<body>
<header>
    <article class="logo"></article>
    <article class="header-title">商品管理系统</article>
    <article class="btn-close" onclick="location.href='login.jsp'">注 销</article>
</header>
<section id="pageBody">
    <div class="fenlei">
        <ul >
        <li >种类:</li>
				<c:forEach items="${specieses }" var="s">
					<li value="${s.sp_id}"><a href="${basePath }vegetable/listbyid.do?sp_id=${s.sp_id}"   target="mainFrame">${s.sp_name }</a></li>
				</c:forEach>
		</ul>
    </div>
    <section>
        <iframe src="${basePath }All.jsp" id="mainFrame" name="mainFrame"   width="100%" height="100%"
                frameborder="no"/>
    </section>
</section>
</body>
</body>
</html>