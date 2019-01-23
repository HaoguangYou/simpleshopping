<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
		<form  method="post" action="registServlet">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="./index.html" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名"/><span>请不要输入汉字</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/><span>请输入6位以上字符</span></div>
					
					<!-- <div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div> -->
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="phone" placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input id="code_input"  class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl">  <div id="v_container" style="width: 150px;height: 40px;"></div></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册" >
				</div>
				
			</div>
		</div>
		</form>
	</body>
	<script src="js/gVerify.js"></script>
	<script>
		var verifyCode = new GVerify("v_container");

		document.getElementById("my_button").onclick = function(){
			var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
				//提交到服务器 获取表单的id
				var form =  document.getElementById("SetForm");
				form.submit();
			}else{
				alert("验证码错误");
			}
		}
	</script>
</html>