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
</head>
<style type="text/css">
    body{
        background-size: cover;
        background-image: url("${basePath }res/img/zhuce.jpg");
        background-repeat: no-repeat;
    }
    #container{
        position: absolute;
        top: 40px;
        right: 160px;
        width: 380px;
        height: 670px;
        background-color: rgba(255,255,255,0.7);
    }
    #container dl{
        position: absolute;
        left: 0px;
    }
    #container dl dd{
        font-family: 黑体;
        font-size: 18px;
        color: rgba(44, 45, 46, 0.9);
        margin-top: 10px;
    }
    input{
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
    a{
        position: absolute;
        top:580px;
        right: 8px;
        font-family: 黑体;
        font-size: 14px;
        text-decoration-line: none;
        color: #222222;
    }
    .btn {
        position: relative;
        margin: auto;
        left: 5px;
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
    .logo{
        position: absolute;
        top: 8px;
        left: 30px;
        width: 150px;
        height: 100px;
        overflow: hidden;
    }
    .logo img{
    	width: 100%;
    	height: 100%;
    }
</style>
<script type="text/javascript"  src="${basePath }res/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="${basePath }res/css/jquery.validator.css">
<script type="text/javascript" src="${basePath }res/js/jquery.form.js"></script>
<script src="${basePath }res/js/jquery.validator.js"></script>
<script src="${basePath }res/js/zh_CN.js"></script>
<body>
<div class="logo"><img src="${basePath }res/img/qqcy.png"></div>
<div id="container">
    <form id="form" method="post" action="${basePath }user/register.do" style="width: 360px; height: 650px"data-validator-option="{stopOnError:false, timely:true, theme:'yellow_top'}">
        <dl>
            <dd>
                输入用户名:<br/>
                <input type="text" id="u_username" name="u_username" placeholder="username" autofocus class="input" data-rule="用户名:required;"><br><span id="usernameerr"  style="color: red"></span>
            </dd>
            <dd>
                设置密码:<br/>
                <input type="password" name="u_password" placeholder="set password" required class="input" data-rule="密码:required;">
            </dd>
            <dd>
                确认密码:<br/>
                <input type="password" name="confirmpassword" placeholder="confirm password" required class="input">
            </dd>
            <dd>
                请输入邮箱地址:<br/>
                <input type="email" name="u_email" placeholder="enter you email"required class="input">
            </dd>
            <dd>
               请输入真实姓名:<br/>
               <input type="text" name="u_truename" placeholder="enter your truename" required class="input">     
            </dd>
            <dd>
                请输入联系电话:<br/>
                <input type="text" name="u_telephone" placeholder="enter you telephone"required class="input">
            </dd>
            <dd>
               请输入收货地址:<br/>
            	<input type="text" name="u_address" placeholder="enter your received address"required class="input">
            </dd>
            <dd>
            性别:<label><input name="u_sex" type="radio" value="男" style="width: 20px; height: 10px"/>男</label>
            <label><input name="u_sex" type="radio" value="女" style="height:10px; width: 20px; "/>女</label>
            </dd>
            <dd>
                <input type="submit" value="注册" class="btn btn-submit">
            </dd>
            <a href="login.html">返回登录</a>
        </dl>
    </form>
    	<script type="text/javascript">
	$(function(){
		$("#u_username").blur(function(){
			//console.log("blur");
			//验证用户名是否唯一
			//发送AJAX请求
		$.post("${basePath}user/registerValidate.do",{u_username:$(this).val()},function(data){
				$("#usernameerr").html(data.content);
			},"json")
		});//失去焦点时
	})
	</script>
     
</div>
</body>
</html>