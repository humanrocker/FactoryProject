
//下面为设置检查的时候的一些标志位，用于设置错误的时候submit按钮无效
var usernameSubmitflag = 1;
var passwordSubmitflag = 1;
var repasswordSubmitflag = 1;
var verifycodeSubmitflag = 1;

var into = 0;//密码和重复密码错误显示取消标志位
//var XMLHttpReq=false; 

//用户名检测，不能为空，长度在6到12之间
function checkusername() {
	
	var username = document.getElementById("username").value;// dom获得username
	var checkusernameinfo = $("#checkusernameinfo");// jquery获得checkusernameinfo节点
	checkusernameinfo.html("");// 初始化span
	if ("" == trim(username)) // 为空
	{
// alert("username is required");
		checkusernameinfo.html("username is required");// span填充提示信息
		usernameSubmitflag =0;
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
	}
	else if(trim(username).length > 12  || trim(username).length < 5)// 长度 5-
																		// 12
	{
// alert("username length must between 6 in 12");
		checkusernameinfo.html("username length must between 5  in 12");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		usernameSubmitflag =0;
	}
	else if(usernameSubmitflag == 1)
	{
		verifyusername();
	}
	else
		usernameSubmitflag = 1;

//		usernameSubmitflag =1;
// verify();
//	alert(username);
//	send("register.do?name="+username); ]
	
//	alert(usernameSubmitflag);
	initsubmit();
	
}

// 密码检测，不能为空
function checkpassword() {
	var password = document.getElementById("password").value;// dom获得password
	var checkpasswordinfo = $("#checkpasswordinfo");// jquery获得checkpasswordinfo节点
	checkpasswordinfo.html("");// 初始化span
	if ("" == trim(password)) // 为空
	{
// alert("username is required");
		checkpasswordinfo.html("password is required");// span填充提示信息
		passwordSubmitflag =0;
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
	}
	else 
		passwordSubmitflag =1;
	if(into)
		checkrepassword();
	initsubmit();
}

// 重复密码检测，不能为空，也密码相同
function checkrepassword() {
	var repassword = document.getElementById("repassword").value;// dom获得repassword
	var checkrepasswordinfo = $("#checkrepasswordinfo");// jquery获得checkrepasswordinfo节点
	checkrepasswordinfo.html("");// 初始化span
	if ("" == repassword) // 为空
	{
// alert("username is required");
		checkrepasswordinfo.html("repassword is required");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		repasswordSubmitflag =0;
	}
	else if(repassword != trim(document.getElementById("password").value))// 密码和重复密码不相同
	{
// alert("username length must between 6 in 12");
		checkrepasswordinfo.html("password not equal repassword");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		repasswordSubmitflag =0;
	}
	else
		repasswordSubmitflag =1;
	into = 1;
	initsubmit();
}
//检查验证码是否正确
function checkverifycode() {
	var verifycode = document.getElementById("verifycode").value;// dom获得verifycode
	var checkverifycodeinfo = $("#checkverifycodeinfo");// jquery获得checkverifycodeinfo节点
	if("" == verifycode)
		checkverifycodeinfo.html("verifycode is required");//为空
	else
		codeverify();//正确性判断
	initsubmit();
}

// 提交之前的检查，也就是包含上面的所有的检查,防止出现没有输入直接提交表单的情况
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
	checkverifycode();
}


//下面的都是进行一些初始化，象清空错误，高亮全部，设置提交标志位
function cleanusernameerror() {
// var checkusernameinfo = $("#checkusernameinfo");//jquery获得checkusernameinfo节点
	$("#checkusernameinfo").html("");// 初始化span
	$("#username").select();
	usernameSubmitflag = 1;
//	alert(usernameSubmitflag);
	
}

function cleanpassworderror(){
// alert("clean");
// var checkpasswordinfo = $("#checkpasswordinfo");//jquery获得checkusernameinfo节点
	$("#checkpasswordinfo").html("");// 初始化span
	$("#password").select();
	passwordSubmitflag = 1;
	
}

function cleanrepassworderror() {
// var checkrepasswordinfo =
// $("#checkrepasswordinfo");//jquery获得checkusernameinfo节点
	$("#checkrepasswordinfo").html("");// 初始化span
	$("#repassword").select();
	repasswordSubmitflag = 1;
	
}

function cleanverifyerror() {
		$("#checkverifycodeinfo").html("");// 初始化span
		$("#verifycode").select();
		verifycodeSubmitflag = 1;
	}

//定义用户名校验的方法
function verifyusername(){

    //1.获取文本框中的内容
    //document.getElementById("userName");  dom的方式
    //Jquery的查找节点的方式，参数中#加上id属性值可以找到一个节点。
    //jquery的方法返回的都是jquery的对象，可以继续在上面执行其他的jquery方法
    var jqueryObj = $("#username");
    //获取节点的值
    var userName = jqueryObj.val();
//    alert(userName);

    //2.将文本框中的数据发送给服务器段的servelt
    //使用jquery的XMLHTTPrequest对象get请求的封装
//    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);
    
    $.ajax({
        type: "POST",            //http请求方式
        url: "CheckUser",    //服务器段url地址
        data: "name=" + userName,           //发送给服务器段的数据
        dataType: "xml",  //告诉JQuery返回的数据格式
        success: usernamecallback  //定义交互完成，并且服务器正确返回数据时调用的回调函数
    });


}

//回调函数
function usernamecallback(data) {
//    alert("服务器段的数据回来了！！");
    //3.接收服务器端返回的数据
//    alert(data);
    //4.将服务器段返回的数据动态的显示在页面上
    //找到保存结果信息的节点
	var jqueryObj = $(data);
    var checkusernameinfo = $("#checkusernameinfo");
//    var checkverifycodeinfo = $("#checkverifycodeinfo");
    //动态的改变页面中div节点中的内容
    if(jqueryObj.children("message").children("usernamemes").text() == "username exist,please change username")
    {
//    	resultObj.html(jqueryObj.children().children("verifycodemes"));
//    checkverifycodeinfo.html(jqueryObj.children("message").children("verifycodemes").text());
    	
    	usernameSubmitflag =0;
//    	alert(usernameSubmitflag);
//    	checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    	
    }
    else 
    {
    	usernameSubmitflag = 1;
//    	alert(usernameSubmitflag);
    }
    initsubmit();
//    alert(jqueryObj.children("message").children("usernamemes").text());
    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
//    usernameSubmitflag =1;
//    alert(usernameSubmitflag);
    	
}


function codeverify(){
//	alert("dd");
    //首先测试一下页面的按钮按下，可以调用这个方法
    //使用javascript的alert方法，显示一个探出提示框
    //alert("按钮被点击了！！！");

    //1.获取文本框中的内容
    //document.getElementById("userName");  dom的方式
    //Jquery的查找节点的方式，参数中#加上id属性值可以找到一个节点。
    //jquery的方法返回的都是jquery的对象，可以继续在上面执行其他的jquery方法
    //获取节点的值
	var jqueryObj = $("#username");
    //获取节点的值
    var userName = jqueryObj.val();
    var verifyCode =$("#verifycode").val();
//    alert(verifyCode);

    //2.将文本框中的数据发送给服务器段的servelt
    //使用jquery的XMLHTTPrequest对象get请求的封装
//    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);
    
    $.ajax({
        type: "POST",            //http请求方式
        url: "CheckUser",    //服务器段url地址
//        data: {"name" : userName , "verify" : verifyCode},           //发送给服务器段的数据，key，value对，是可以的
        data: {"verify" : verifyCode},           //发送给服务器段的数据
        dataType: "xml",  //告诉JQuery返回的数据格式
        success: codecallback  //定义交互完成，并且服务器正确返回数据时调用的回调函数
    });


}

//回调函数
function codecallback(data) {
//    alert("服务器段的数据回来了！！");
    //3.接收服务器端返回的数据
//    alert(data);
    //4.将服务器段返回的数据动态的显示在页面上
    //找到保存结果信息的节点
	var jqueryObj = $(data);
//    var checkusernameinfo = $("#checkusernameinfo");
    var checkverifycodeinfo = $("#checkverifycodeinfo");
    var verifycodemes = jqueryObj.children("message").children("verifycodemes").text();
    //动态的改变页面中div节点中的内容
    if(verifycodemes == "verifycode is error")
    	verifycodeSubmitflag = 0;
    else
    	verifycodeSubmitflag =1;
//    	resultObj.html(jqueryObj.children().children("verifycodemes"));
    checkverifycodeinfo.html(verifycodemes);
//    checkverifycodeinfo.html(data);
//    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    initsubmit();
}



//删除左右两端的空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

// 设置提交按钮的可用性
function initsubmit() {
	if(usernameSubmitflag == 0 || passwordSubmitflag == 0 || repasswordSubmitflag == 0 || repasswordSubmitflag == 0 || verifycodeSubmitflag == 0 )
		document.getElementById("submit").disabled = true;// 设置提交按钮不可用
	else
		document.getElementById("submit").disabled = false;// 设置提交按钮可用
}