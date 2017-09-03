<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="application/javascript">
function testButton(){
	 window.location="index.html";
	}
</script>
</head>

<body>
<div class="container">
<h3>基本资料</h3>
<hr />
<div class="moveleft">
 亲爱的<label></label>，填写真实的资料，有助于好友找到你哦。
 <div class="moveDown font-lg">
昵称：<input type="text" name="account-name"  class="input-md"/>（*）
<br />
<br />
<span class="font-sm">*昵称填写须知：与乐鲜业务或买家平拍冲突的昵称，乐鲜将有可能收回</span>
</div>
<div class="moveDown font-lg">
真实姓名：<input type="text" name="username"  class="input-md"/>（*）
</div>
<div class="moveDown font-lg">
性别：<input type="radio" name="sex" value="男" />男     <input type="radio" name="sex" value="女" />女
</div>
<div class="moveDown font-lg"> 
生日：
<select name="year-selector" class="font-lg">
<option value="1996" >1996</option>
<option value="1997">1997</option>
<option value="1998">1998</option>
</select>
<select name="month-selector" class="font-lg">
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
<select name="day-selector" class="font-lg">
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
</div>
<div class="moveDown font-lg">
居住地：<select name="province-selector" class="font-lg">
<option value="重庆">重庆</option>
<option value="四川">四川</option>
<option value="湖南">湖南</option>
</select>
<select name="city-selector" class="font-lg">
<option value="重庆">重庆</option>
<option value="成都">成都</option>
<option value="上海">上海</option>
</select>
</div>
<div class="moveDown font-lg">
网购地址：<input  type="text" name="address"  class="input-md"/>
</div>
<input  type="button" value="保 存" class=" moveDown font-lg margin-l"  onclick="testButton();"/>
</div>
</div>
</body>
</html>