<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("basePath",basePath);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${basePath }res/css/myorder.css">
	<link rel="stylesheet" type="text/css" href="${basePath }res/css/bootstrap.min.css " />
	<script type="text/javascript" src="${basePath }res/js/bootstrap.min.js "></script>
	<script type="text/javascript" src="${basePath }res/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${basePath }res/js/myOrder.js"></script>
  </head>
  
  <body>
	<div class="container-fluid">
		<!-- 头部 -->
		<div class="row" id="head">
			<div class="col-md-2"></div>
			<div class="col-md-8 page-header"><h1>我的订单  <small>  My Orders  </small></h1></div>
			<div class="col-md-2"></div>
		</div>
		
		<!-- 主体，根据订单表循环输出 -->
		<c:forEach items="${orderInfoMap }" var="order">
			<div class="row" id="order" >
			<div class="col-md-2"></div>
			<div class="col-md-8 orderkuang" >
				<!-- 表格 -->
				<table class="biaoge table-hover">
				
					<!-- 表格头 -->
					<tr class="biaogetou">
						<th class="orderid">订单号：${order.key.o_id }</th>
						<th class="shangpinname">商品名称</th>
						<th class="shuliang">数量</th>
						<th class="jine">金额</th>
					</tr>
					
					<c:forEach items="${order.value }" var="orderInfo">
						<!-- 表格体，根据订单信息表循环 -->
						<tr class="biaogeti">
							<td colspan="2">
							<div class="shucai">
								<img class="shucaiphoto img-rounded" src="${basePath }res/img/豌豆.jpg">
								<span class="shucaimiaoshu">${orderInfo.vegetable.v_discribe } </span>
							</div>
							</td>
							<td>${orderInfo.oi_vegenum }KG</td>
							<td><fmt:formatNumber value="${orderInfo.oi_vegenum*orderInfo.vegetable.v_price }" type="currency" pattern="¥.00"/>元</td>
							
						</tr>
					</c:forEach>	
				</table>
				
				<!-- 订单脚 -->
				<div class="main-foot">
					<div>
						<h4 id="main-foot-left">订单创建时间：2017-6-30 15:42</h4>
					</div>
					<div class="main-foot-right">
						<h3>总金额：${order.key.o_sumprice }</h3>
							<c:choose>
								<c:when test="${order.key.o_status == '待付款'  }">
									<h3><span class="label label-info" id="jiesuananniu" onclick="creatediv(${order.key.o_id},${order.key.o_sumprice },${order.key.o_createtime });return false;" onmouseover="this.style.cursor= 'hand' ">结算</span></h3>
								</c:when>
								<c:when test="${order.key.o_status == '已完成'  }">
									<h3><span class="label label-success" id="jiesuananniu" onclick="" onmouseover="this.style.cursor='hand'" >订单完成</span></h3>
								</c:when>
								<c:when test="${order.key.o_status == '待收货'  }">				<!-- finishOrder(${order.key.o_id})  -->
									<h3><span class="label label-primary" id="jiesuananniu" onclick="creatediv(${order.key.o_id})" onmouseover="this.style.cursor='hand'"> 确认收货</span></h3>
								</c:when>
								<c:when test="${order.key.o_status == '关闭'  }">
									<h3><span class="label label-Default" id="jiesuananniu" onclick="" onmouseover="this.style.cursor='hand'">关闭</span></h3>
								</c:when>
								<c:when test="${order.key.o_status == '已退款'  }">
									<h3><span class="label label-warning" id="jiesuananniu" onclick="" onmouseover="this.style.cursor='hand'">已退款</span></h3>
								</c:when>
							</c:choose>

						</div>
				</div>
				
			</div>
			<div class="col-md-2"></div>
		</div>
		</c:forEach>
		
			
		
	</div>

</body>
</html>
