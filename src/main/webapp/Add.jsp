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
<title>上架商品</title>
<script type="text/javascript"  src="${basePath }res/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="${basePath }res/css/GuanliIndex.css">
<link rel="stylesheet" href="${basePath }res/css/jquery.validator.css">
<script type="text/javascript" src="${basePath }res/js/jquery.form.js"></script>
<script type="text/javascript" src="${basePath }res/ckeditor/ckeditor.js"></script>
<script src="${basePath }res/js/jquery.validator.js"></script>
<script src="${basePath }res/js/zh_CN.js"></script>
<script type="text/javascript">
	  function uploadImg(){
    	var options={
    		url:"${basePath}vegetable/upload.do?time="+Math.random(),
    		dataType:"json",
    		type:"post",
    		success:function(str){
    		//console.log(str);
    		$("#pre").attr("src",str);
    		$("#imgurl").val(str);
    		}
    	};
    	$("#vegetableAdd").ajaxSubmit(options);
    }
</script>
</head>
<body>
	<form style="position: absolute;top:0px; width: 95%;left: 2.5%" id="vegetableAdd" action="${basePath }vegetable/add.do" method="post" data-validator-option="{stopOnError:false, timely:true, theme:'yellow_top'}">
    <div class="scsp">
        <h1 style="color: #d31e29">上架商品</h1>
        <hr>
    </div>
    <div class="infomation">
        <h2 style="margin: 15px 10px 0">商品信息</h2> 
        <hr>
        <input type="hidden" name="v_id"  /><br/>
        <input type="text" placeholder="请输入商品名称" name="v_name"   id="v_name"  data-rule="蔬菜名:required;"><span id="nameerr"  style="color: red"></span><br/>
        <input type="text" placeholder="请输入商品价格" name="v_price" >
        <input type="text" placeholder="请输入商品数量" name="v_num" >
        <input type="text" placeholder="请输入商品简介" name="v_discribe"  >
        <input type="text" placeholder="请输入上传时间" name="v_createtime" /><br/>
        <select style="margin-left: 15px" name="species.sp_id">
           <c:forEach items="${specieses }" var="s">
					<option value="${s.sp_id}" >${s.sp_name }</option>
			</c:forEach>
        </select><br/>
    </div>
    <div class="file">
        <h2 style="margin: 15px 10px 0">上传实物图</h2>
        <hr>
        <input type="hidden" name="v_photo" id="imgurl"/>
        <input type="file"  name="file"  onchange="uploadImg()"><br />
        <img id="pre"style="border:1px red solid;width:100px;height:150px;object-fit:contain" ><br/>
    </div>
    <div class="spxq">
        <h2 style="margin: 15px 10px 10px">商品详情</h2>
        <textarea name="v_ckeditor" class="ckeditor" style="border: 0px"></textarea>
        <input type="reset" value="重置"  style="float:left; margin-bottom: 15px">
        <input type="submit" value="提交"  style="float: right; margin-bottom: 15px">
    </div>

</form>

	<script type="text/javascript">
	$(function(){
		$("#v_name").blur(function(){
			//console.log("blur");
			//验证蔬菜名是否唯一
			//发送AJAX请求
			$.post("${basePath}vegetable/validate.do",{v_name:$(this).val()},function(data){
				$("#nameerr").html(data.content);
			},"json")
		});//失去焦点时
	})
	</script>

</body>
</html>