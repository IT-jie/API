<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>接口目录</title>
	   
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
	<h2>接口目录</h2>
	<ul>
		<li>
			地图工具<br/>
			<ul>
				<li>
					<a href="${ctx}/ip_position" target="_blank">获取当前IP地址</a>
				</li>
				<li>
					<a href="${ctx}/ip_position?ip=219.136.18.15" target="_blank">根据IP获取地址</a>
				</li>
				<li>
					<a href="${ctx}/city_weather" target="_blank">获取当前城市天气</a>
				</li>
				<li>
					<a href="${ctx}/city_weather?city=广州市" target="_blank">根据城市获取天气</a>
				</li>
			</ul>
		</li>
		<li>
			时间工具<br/>
			<ul>
				<li>
					<a href="${ctx}/current_time" target="_blank">获取日期和时间戳</a>
				</li>
				<li>
					<a href="${ctx}/time_to_date?time=1534586400000" target="_blank">时间戳转日期</a>
				</li>
				<li>
					<a href="${ctx}/date_to_time?date=2018-08-18 18:00:00" target="_blank">日期转时间戳</a>
				</li>
			</ul>
		</li>
		<li>
			随机数工具<br/>
			<ul>
				<li>
					<a href="${ctx}/random_data?start=1&end=12" target="_blank">获取区间随机数</a>
				</li>
				<li>
					<a href="${ctx}/random_array?list=[守卫,骑士,名媛,白痴,长老,盗贼]" target="_blank">获取数组中的随机项</a>
				</li>
			</ul>
		</li>
		<li>
			地区工具<br/>
			<ul>
				<li>
					<a href="${ctx}/get_address" target="_blank">获取省份</a>
				</li>
				<li>
					<a href="${ctx}/get_address?province=广东省" target="_blank">根据省份获取城市</a>
				</li>
			</ul>
		</li>
		<li>
			Redis工具<br/>
			<ul>
				<li>
					<a href="${ctx}/redis_all" target="_blank">获取所有数据项</a>
				</li>
				<li>
					<a href="${ctx}/redis_keys" target="_blank">获取所有key</a>
				</li>
				<li>
					<a href="${ctx}/redis_value?key=hello" target="_blank">根据key获取value</a>
				</li>
				<li>
					<a href="${ctx}/redis_add?key=hello&value=world" target="_blank">添加数据项</a>
				</li>
				<li>
					<a href="${ctx}/redis_edit?key=hello&value=world123" target="_blank">修改数据项</a>
				</li>
				<li>
					<a href="${ctx}/redis_delete?key=hello" target="_blank">删除数据项</a>
				</li>
			</ul>
		</li>
		<li>
			控制面板<br/>
			<ul>
				<li>
					<a href="${ctx}/option_all" target="_blank">获取所有配置</a>
				</li>
				<li>
					<a href="${ctx}/option_keys" target="_blank">获取所有key</a>
				</li>
				<li>
					<a href="${ctx}/option_value?key=mymy" target="_blank">根据key获取value</a>
				</li>
				<li>
					<a href="${ctx}/option_add?key=hello&value=world&desc=123456" target="_blank">添加配置</a>
				</li>
				<li>
					<a href="${ctx}/option_edit?key=hello&value=world123&desc=备注" target="_blank">修改配置</a>
				</li>
				<li>
					<a href="${ctx}/option_delete?key=hello" target="_blank">删除配置</a>
				</li>
			</ul>
		</li>
		<li>
			加密工具<br/>
			<ul>
				<li>
					<a href="${ctx}/encrypt_SHA256?text=HelloWorld" target="_blank">SHA256加密</a>
				</li>
				<li>
					<a href="${ctx}/decrypt_SHA256?text=0e2226b5235f0ff94a276eb4d07a3bfea74b7e3b8b85e9efca6c18430f041bf8" target="_blank">SHA256解密</a>
				</li>
				<li>
					<a href="${ctx}/encrypt_MD5?text=HelloWorld" target="_blank">MD5加密</a>
				</li>
				<li>
					<a href="${ctx}/decrypt_MD5?text=68e109f0f40ca72a15e05cc22786f8e6" target="_blank">MD5解密</a>
				</li>
			</ul>
		</li>
	</ul>
</body>
</html>
