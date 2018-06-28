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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js" ></script>
<title>医生列表</title>
</head>
<body>

	<div>
		<div style="width:10%;float:left">id</div>
		<div style="width:10%;float:left">姓名</div>
		<div style="width:15%;float:left">职称</div>
		<div style="width:25%;float:left">url</div>
		<div style="width:10%;float:left">delflag</div>
		<div style="width:10%;float:left">createid</div>
		<div style="width:10%;float:left">createtime</div>
		<shiro:hasPermission name="add"><div style="width:10%;float:left">操作</div></shiro:hasPermission>
	    <c:forEach var="doctor" items="${all.list}">
	    	<div style="width:10%;float:left">${doctor.id}</div>
			<div style="width:10%;float:left">${doctor.doctorName}</div>
			<div style="width:15%;float:left">${doctor.doctorPosition}</div>
			<div style="width:25%;float:left">${doctor.avatarUrl}</div>
			<div style="width:10%;float:left">${doctor.delFlag}</div>
			<div style="width:10%;float:left">${doctor.createId}</div>
			<div style="width:10%;float:left">${doctor.createTime}</div>
			<shiro:hasPermission name="add"><div style="width:10%;float:left"><a href="${basePath }/doctor/modify?id=${doctor.id }">修改</a><a href="">删除</a></div></shiro:hasPermission>
	    </c:forEach>
    </div>
</body>
</html>