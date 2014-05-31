//用户名检测，不能为空，长度在6到12之间
var submitflag1 = 1;
var submitflag2 = 1;
var submitflag3 = 1;
var into = 0;

function checkusername() {
	
}

//密码检测，不能为空
function checkpassword() {
//	var checkusernameinfo = $("#checkusernameinfo");//jquery获得checkusernameinfo节点
//	checkusernameinfo.html("");//初始化span
//	alert("init");
}

//重复密码检测，不能为空，也密码相同
function checkrepassword() {
}

//提交之前的检查，也就是包含上面的所有的检查
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
}

//删除左右两端的空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
//设置提交按钮的可用性
function initsubmit() {
	if(submitflag1 == 0 || submitflag2 == 0 || submitflag3 == 0)
		document.getElementById("submit").disabled = true;//设置提交按钮不可用
	else
		document.getElementById("submit").disabled = false;//设置提交按钮可用
}
function cleanusernameerror() {
	var checkusernameinfo = $("#checkusernameinfo");//jquery获得checkusernameinfo节点
	checkusernameinfo.html("");//初始化span
}
