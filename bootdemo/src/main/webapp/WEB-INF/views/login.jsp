<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
pageContext.setAttribute("basePath",basePath); 
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${basePath }js/jquery-1.9.1.min.js" ></script>
<script type="text/javascript" src="${basePath }js/jquery-weui.min.js" ></script>
<script type="text/javascript" src="${basePath }js/login.js" ></script>
<link rel="stylesheet" href="${basePath }css/jquery-weui.min.css">
<link rel="stylesheet" href="${basePath }css/weui.min.css">
<link rel="stylesheet" href="${basePath }css/login.css">
<title>登录页面</title>
</head>
<body>
	<header class="login-header">
		<h1 class="login-title">登录</h1>
	</header>

	<form action="${basePath }login" method="post">
		<div class="weui-cells">
			<div class="weui-cell">
				<div class="weui-cell_bd">用户名：</div>
				<div class="weui-cell_ft">
					<input class="weui-input" type="text" name="username" placeholder="请输入用户名">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell_bd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
				<div class="weui-cell_ft">
					<input class="weui-input" type="password" name="password" placeholder="请输入密码">
				</div>
			</div>
		</div>
		<div class="button-item">
			<input class="weui-btn weui-btn_primary" type="submit" value="登录" />
			<input class="weui-btn weui-btn_primary" type="reset" value="重置" />
		</div>
	</form>
</body>
</html>