<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
			+path+"/";
	session.setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" href="${basePath }res/css/more.css">
<script type="text/javascript" src="${basePath}res/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function minus(){
                var num = document.getElementById("num");
        		var getNum = parseFloat(num.value);
                if(getNum > 1)
                {
           			num.value = getNum - 0.5;
           		}
    }
	function plus(){
			 var num = document.getElementById("num");
			 var getNum = parseFloat(num.value);
			 if(getNum<100)
			 {
			 	num.value=getNum+0.5;
			 }
		}
	function NumUpLoad(){
				var num=document.getElementById("num");
				upNum=parseFloat(num.value);
				var hre=document.getElementById("up");
				hre.href="${basePath}shoppingcartinfo/add.do?buyNum="+upNum;
				console.log(hre.href);
	}
</script>
</head>
<body>
<header class="top">
    <div class="menu">
        <article class="logo">
            <a href="${basePath }Index.jsp"><img alt="" src="${basePath}res/img/qqcy.png" style="width:110px;height:50px;"></a>
        </article>
        <div class="link">
            <input type="search" id="select" name="select" class="input" placeholder="搜索"/>
            <a href="login.html" style="margin: 5px">登录/注册</a>
            <a href="BuyStore.html" style="margin: 5px">购物车</a>
            <a href="#" style="margin: 5px">订单管理</a>
        </div>
    </div>
</header>
<div class="containner1">
    <img src="${DisplayOfVegetable.v_photo}">
    <div class="containner1_2">
        <ul>
            <h2 style="margin: 5px">${DisplayOfVegetable.v_name }</h2>
            <hr>
            <dd><h3>${DisplayOfVegetable.v_title}</h3></dd>
            <dd>价格:<s style="margin-left:10px ">￥${DisplayOfVegetable.v_price}</s>/kg</dd>
            <dd style="color: #d43f3a">促销价:<h2 style="color: #d31e29">￥${DisplayOfVegetable.v_price}/kg</h2></dd>
				<dd>
					<button id="minus" onclick="minus()">—</button>
					<input id="num" type="text" value="1" />
					<button id="plus" onclick="plus()">+</button>
				</dd>
				<dd>${DisplayOfVegetable.v_createtime}采摘</dd>
			</ul>
        <div class="btn1"><a href="#" style="color: #1f1f1f">立即购买</a></div>
        <div class="btn2"><a id="up" href="" style="color: white;" onclick="NumUpLoad()">加入购物车</a></div>
    </div>
</div>
<div class="containner2">
    <h2>商品详情</h2>
    <hr>
    ${DisplayOfVegetable.v_ckeditor }
</div>
</body>
</html>