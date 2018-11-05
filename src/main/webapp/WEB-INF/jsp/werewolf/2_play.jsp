<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>狼人杀</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script src="${ctx}/pub/plugins/jquery/jquery-2.2.3.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#game_type").html('${sessionScope.game_type}');
		
		var num_total = '${sessionScope.num_total}';
		var num_wolf = '${sessionScope.num_wolf}';
		var num_villager = '${sessionScope.num_villager}';
		
		var skill_role = '${sessionScope.skill_role}';
		skill_role = skill_role.substring(1,skill_role.length-1);
		var roleArr = skill_role.split(", ");

		var skill_wolf = '${sessionScope.skill_wolf}';
		skill_wolf = skill_wolf.substring(1,skill_wolf.length-1);
		var wolfArr = skill_wolf.split(", ");
		
		for(var i=1; i<=num_total; i++){
			var str = "<li><div style='width: 40px; float: left;'>"+i+"号</div>(死亡)<input type='checkbox' />：";
			for(var j=1; j<=num_wolf; j++){
				str += "<input type='radio' name="+i+"'_role' />狼人&nbsp;&nbsp;";
			}
			for(var j=0; j<wolfArr.length; j++){
				str += "<input type='radio' name="+i+"'_role' />"+wolfArr[j]+"&nbsp;&nbsp;";
			}
			for(var j=1; j<=num_villager; j++){
				str += "<input type='radio' name="+i+"'_role' />村民&nbsp;&nbsp;";
			}
			for(var j=0; j<roleArr.length; j++){
				str += "<input type='radio' name="+i+"'_role' />"+roleArr[j]+"&nbsp;&nbsp;";
			}
			str += "</li>";
			$("#setRole").html($("#setRole").html()+str);
		}
	});

	// 记录夜晚数
	var night_num = 1;

	// 下一步(夜晚)
	function next1(){
		var skill_role = '${sessionScope.skill_role}';
		skill_role = skill_role.substring(1,skill_role.length-1);
		var roleArr = skill_role.split(", ");

		var str = "<h3>天黑请闭眼(第"+night_num+"夜)</h3>";
		
		str += "狼人请睁眼，狼人请刀人<input style='width: 30px' />，确认请闭眼<br/>";
		
		if(roleArr.indexOf("女巫") != -1){
			str += "女巫请睁眼，昨晚死亡的是他，是否要救，毒人请给号码<input style='width: 30px' /><br/>";
		}
		if(roleArr.indexOf("预言家") != -1){
			str += "预言家请睁眼，今晚你要验谁<input style='width: 30px' />，他的身份是这个<br/>";
		}
		if(roleArr.indexOf("猎人") != -1){
			str += "猎人请睁眼，你的开枪状态是这个<br/>";
		}
		if(roleArr.indexOf("守卫") != -1){
			str += "守卫请睁眼，你今晚要守护的玩家是<input style='width: 30px' /><br/>";
		}
		if(night_num == 1 && roleArr.indexOf("白痴") != -1){
			str += "白痴请睁眼，白痴请闭眼<br/>";
		}
		if(night_num == 1 && roleArr.indexOf("骑士") != -1){
			str += "骑士请睁眼，骑士请闭眼<br/>";
		}
		str += "<br/><button onclick='next2()'>下一步</button><hr>";
		$("#nightMessage").html($("#nightMessage").html()+str);
		$("#nightMessage").scrollTop($("#nightMessage").height()); 
	}

	// 下一步(白天)
	function next2(){
		var str = "<h3>天亮了</h3>";
		str += "昨晚<input style='width: 30px' />死了/平安夜<br/>";
		str += "第一晚死的有遗言，从死后玩家开始发言<br/>";
		str += "发言中......<br/>";
		str += "开始投票<br/>";
		str += "<input style='width: 30px' />号被投出局，有遗言<br/>";
		str += "<br/><button onclick='next1()'>下一步</button><hr>";
		night_num ++;
		$("#nightMessage").html($("#nightMessage").html()+str);
		$("#nightMessage").scrollTop($("#nightMessage").height()); 
	}
</script>

</head>

<body>
	<div style="width: 60%;">
		<h1 style="text-align: center;">开始游戏</h1>
		
		<h3>游戏类型：<span id="game_type"></span></h3>
		
		<div>
			<h3>分配角色：</h3>
			<ul id="setRole"></ul>
		</div>
		
		<div>
			<h3>
				请大家拿好牌，确认身份<br/>
			</h3>
			<button onclick="next1()">下一步</button>
			<br/>
			<div id="nightMessage"></div>
		</div>
		
	</div>
</body>
</html>
