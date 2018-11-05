<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>个人笔记</title>
	   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h2>笔记目录</h2>
	<ul>
		<li>
			<a href="${ctx}/note_linux?nu=true" target="_blank">Linux</a>
		</li>
		<li>
			<a href="${ctx}/note_mysql?nu=true" target="_blank">MySQL</a>
		</li>
		<li>
			<a href="${ctx}/note_redis?nu=true" target="_blank">Redis</a>
		</li>
		<li>
			<a href="${ctx}/note_mongodb?nu=true" target="_blank">MongoDB</a>
		</li>
		<li>
			<a href="${ctx}/note_sqlite?nu=true" target="_blank">SQLite</a>
		</li>
		<li>
			<a href="${ctx}/note_zookeeper?nu=true" target="_blank">Zookeeper</a>
		</li>
		<li>
			<a href="${ctx}/note_kde?nu=true" target="_blank">KodExpolorer</a>
		</li>
		<li>
			<a href="${ctx}/note_github?nu=true" target="_blank">GitHub</a>
		</li>
	</ul>
</body>
</html>
