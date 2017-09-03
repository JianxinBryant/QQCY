/**
 * Created by Teacher on 2016/12/25.
 */
/**
 * 全选与反选
 */
function checkedOrUnchecked(thisz) {
    //获得所有数据行的复选框
    var idsArr = document.getElementsByName("ids");
    //循环修改选中状态属性
    for(i=0; i<idsArr.length; i++) {
        idsArr[i].checked = thisz.checked;
    }
}

/**
 * 获得选中复选框的数量
 */
function getSelectedCount() {
    //获得所有数据行的复选框
    var idsArr = document.getElementsByName("ids");
    //选中复选框的数量
    var count = 0;
    //循环统计选中复选框的数量
    for(i=0; i<idsArr.length; i++) {
        if(idsArr[i].checked) {
            count++;
        }
    }
    //返回数量
    return count;
}

/**
 * 添加
 */
function add() {
    /*//获得表单对象
    var form = document.getElementById("form2");
    //设置提交的路径
    form.action = "useradd.html";
    //提交表单
    form.submit();*/
    location.href = "useradd.html";
}

/**
 * 修改
 */
function update() {
    //获得选中的数量
    var count = getSelectedCount();
    //判断是否可以提交表单
    if(count!=1) {
        alert("请选中一条要修改的记录!");
        return;
    }
    //获得表单对象
    var form = document.getElementById("form2");
    //设置提交的路径
    form.action = "userupdate.html";
    //提交表单
    form.submit();
}

/**
 * 删除
 */
function deleted() {
    //获得选中的数量
    var count = getSelectedCount();
    //判断是否选中了数据行
    if(count==0) {
        alert("请选中要删除的记录!");
        return;
    }
    //弹出选择对话框
    if(confirm("您是否要删除选中的记录?")) {
        //获得表单对象
        var form = document.getElementById("form2");
        //设置提交的路径
        form.action = "";
        //提交表单
        form.submit();
    }
}