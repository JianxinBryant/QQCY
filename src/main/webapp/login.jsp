<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<style type="text/css">
body {
	background-size: cover;
	background-image: url("${basePath }res/img/loginbg.jpg");
	background-repeat: no-repeat;
}

#container {
	position: fixed;
	top: 160px;
	right: 160px;
	width: 360px;
	height: 430px;
	background-size: cover;
	background-color: rgba(255, 255, 255, 0.7);
	background-repeat: no-repeat;
	overflow: hidden;
}

.logo {
	position: relative;
	margin: 5px auto 0;
	top: 5px;
	height: 100px;
	width: 200px;
}

#container dl {
	position: absolute;
	top: 100px;
	left: 10px;
}

#container dl dd {
	font-family: 黑体;
	color: #262626;
	font-size: 24px;
	margin-top: 10px;
}

input {
	width: 250px;
	height: 18px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 12px;
	color: #1f1f1f;
	border: 1px solid #3c3c3c;
	border-radius: 1px;
	background-color: white;
}

a {
	position: absolute;
	top: 400px;
	font-family: 黑体;
	font-size: 14px;
	text-decoration-line: none;
	color: #222222;
}

.btn {
	position: relative;
	margin: auto;
	width: 120px;
	height: 40px;
	display: block;
	background-color: #eea236;
	border: 4px solid #ffffff;
	border-radius: 0px;
	padding: 9px 14px;
	font-size: 16px;
	line-height: normal;
	text-align: center;
	color: aliceblue;
	cursor: pointer;
}

.btn:hover {
	box-shadow: #000 0px 0px 10px;
}

.btn-submit {
	background-color: #eea236;
}

.btn-reset {
	background-color: firebrick;
}
</style>
<body>
	<div id="container">
		<div class="logo">
			<div style="width: 150px;height: 100px;"><img style="width: 100%;height: 100%;" src="${basePath }res/img/qqcy.png"></div>
		</div>
		<div id="login">
			<form id="form1" method="post" action="${basePath }user/login.do">
				<dl>
					<dd>
						用户名:<br />
						<input type="text" id="username" name="u_username"
							placeholder="username" required autofocus class="input">
					</dd>
					<dd>
						密&nbsp;&nbsp;码:<br />
						<input type="password" id="password" name="u_password"
							placeholder="password" required class="input"><br />
							<span>${loginErr }</span>
					</dd>
					<dd>
						<input type="submit" value="登录" class="btn btn-submit" >
					</dd>
				</dl>
				<a href="#" style="position: absolute;left: 50px">忘记密码</a> <a
					href="${basePath }register.jsp" style="position: absolute; right: 50px">免费注册</a>
			</form>
		</div>
	</div>
</body>
</html>