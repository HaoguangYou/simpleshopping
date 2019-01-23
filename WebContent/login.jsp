<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/login.css">
<title>小米商城登陆页面</title>
</head>
<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="./index.html" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form id="SetForm"  method="post"  action="userServlet"   class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input id="code_input"  class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl">  <div id="v_container" style="width: 150px;height: 40px;"></div></div>
						
		
						<div class="clear"></div>
					</div>
				</div>
				
				<div> 
				<%if(request.getAttribute("error")!=null){
				%>
					<%=request.getAttribute("error") %>
				<%
				} %>
				</div>
				
				<div class="login_submit">
					<input id="my_button" class="submit"  type="button"  value="立即登录"  />
				</div>
				
			</div>
		</div>
		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="./image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>

		</footer>
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