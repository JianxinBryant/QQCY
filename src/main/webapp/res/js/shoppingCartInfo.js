

$(function(){
	console.log("初始化页面...");
	checkbox_changed();
	
})

function minus(){
	var num = document.getElementById("num");
	var getNum = parseFloat(num.value);
	if(getNum > 1){
		num.value = getNum - 0.5;
    }
}


function plus(){
	var num = document.getElementById("num");
	var getNum = parseFloat(num.value);
	if(getNum<100){
		num.value = getNum + 0.5;
	}
}

//$(function(){
//	$("#shi_vegenum").blur(function(){
//
//		var num = document.getElementById("shi_vegenum").value;
//		var vprice = document.getElementById("info3").innerHTML;
//		var sumprice = parseFloat(vprice)*num;
//		console.log(sumprice);
//		var finalprice = getSumPrice();
//		$.post("updateVege_numInCart.do",{shi_vegenum:$(this).val(), v_id:$("#v_id").html(), finalprice:finalprice},function(){
//			$("#info5").html(sumprice);
//		},"json")
//	});
//	
//
//})

function updateOnBlur(id){
	var num = document.getElementById("shi_vegenum"+id).value;
	var vprice = document.getElementById("info3"+id).innerHTML;
	var sumprice = parseFloat(vprice)*num;
	$("#info5"+id).html(sumprice.toFixed(2));
	
	var finalprice = getSumPrice();
	
	$.post("updateVege_numInCart.do",{shi_vegenum:num, v_id:$("#v_id").html(), finalprice:finalprice},function(){
		
	},"json")
	$("#info5"+id).html(sumprice.toFixed(2));
}

function updateIncrement(id){
	var v_id = document.getElementById("v_id"+id).innerHTML;
	var num = document.getElementById("shi_vegenum"+id).value;
	num = parseFloat((parseFloat(num,10) + 0.5));
	document.getElementById("shi_vegenum"+id).value = num;
	
	var vprice = document.getElementById("info3"+id).innerHTML;
	var sumprice = parseFloat(vprice)*num;
	$("#info5"+id).html(sumprice.toFixed(2));
	
	var finalprice = getSumPrice();
	$.post("updateVege_numInCart.do",{shi_vegenum:num,v_id:v_id,finalprice:finalprice},function(str){
		
	},"json")
}

function updateDecrement(id){
	
	var v_id = document.getElementById("v_id"+id).innerHTML;
	var num = document.getElementById("shi_vegenum"+id).value;
	num = parseFloat((parseFloat(num,10) - 0.5));
	document.getElementById("shi_vegenum"+id).value = num;
	
	var vprice = document.getElementById("info3"+id).innerHTML;
	var sumprice = parseFloat(vprice)*num;
	console.log(sumprice);
	$("#info5"+id).html(sumprice.toFixed(2));
	var finalprice = getSumPrice();
	
	$.post("updateVege_numInCart.do",{shi_vegenum:num, v_id:v_id,finalprice:finalprice},function(str){
		
	},"json")
	$("#finalprice").html(finalprice.toFixed(2));
}

function updateCheckbox(id){
	var v_id = document.getElementById("v_id"+id).innerHTML;
	var finalprice = getSumPrice();
	console.log("111");
	console.log(v_id);
	checkbox_changed();
	$.post("updateShi_status.do",{v_id:v_id,finalprice:finalprice},function(str){
		console.log(str);
	},"json")
}

function checkbox_changed() {
	// 选中复选框按钮
	// 遍历所有的元素，计算出选中的个数
	var checkbox = $('input[name="cart_check"]:checked');
	console.log(checkbox);
	var span = $('#checked_quantity_span');
	console.log(checkbox.length);
	span.html(checkbox.length);
}

function getSumPrice() {
    var idsAll=document.getElementsByName("cart_check");
    var finalprice=0;
    var info5="info5";
    
    for(i=0;i<idsAll.length;i++)
    {
        if(idsAll[i].checked){
        	
        	finalprice = parseFloat(finalprice) + parseFloat(document.getElementById(info5+idsAll[i].id).innerHTML);
        }
    }

	$("#finalprice").html(finalprice.toFixed(2));
    return finalprice;
    
}




