package com.vst.defend.communal.filter;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author weiwei(joslyn)
 * @date 2017-3-28 下午12:22:51
 * @decription
 * @version 
 */
public class MyFilter implements HandlerInterceptor{
	
	private static final Log logger = LogFactory.getLog(MyFilter.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//最后执行
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		//可以用来修改信息，跳转等
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		// todo 在此处添加要操作code 
		String url = request.getRequestURL().toString();
		int index = url.lastIndexOf('/');
		logger.info("请求的路径: " + url);
		
		if(url.indexOf("/api")+5 < index){
			String actionName = url.substring(url.indexOf("/api")+5, index);
			if("werewolf".equals(actionName)){
				return true;
			}
		}
		
		String action = url.substring(index+1);
		
		// 允许访问的地址
		Set<String> allowUrl = new HashSet<String>();
		// 工具页面
		allowUrl.add("api_list");
		allowUrl.add("game_list");
		allowUrl.add("play_list");
		allowUrl.add("note_list");
		// layui框架
		allowUrl.add("layui_hello");
		allowUrl.add("layui_form");
		// 常用接口
		allowUrl.add("ip_position");
		allowUrl.add("get_address");
		allowUrl.add("random_data");
		allowUrl.add("random_array");
		allowUrl.add("current_time");
		allowUrl.add("time_to_date");
		allowUrl.add("date_to_time");
		allowUrl.add("city_weather");
		// redis工具
		allowUrl.add("redis_all");
		allowUrl.add("redis_keys");
		allowUrl.add("redis_flushdb");
		allowUrl.add("redis_value");
		allowUrl.add("redis_add");
		allowUrl.add("redis_edit");
		allowUrl.add("redis_delete");
		// 常量配置
		allowUrl.add("option_all");
		allowUrl.add("option_keys");
		allowUrl.add("option_value");
		allowUrl.add("option_add");
		allowUrl.add("option_edit");
		allowUrl.add("option_delete");
		// 加密工具
		allowUrl.add("encrypt_SHA256");
		allowUrl.add("decrypt_SHA256");
		allowUrl.add("encrypt_MD5");
		allowUrl.add("decrypt_MD5");
		// 个人笔记
		allowUrl.add("note_linux");
		allowUrl.add("note_mysql");
		allowUrl.add("note_redis");
		allowUrl.add("note_mongodb");
		allowUrl.add("note_sqlite");
		allowUrl.add("note_kde");
		allowUrl.add("note_zookeeper");
		allowUrl.add("note_github");
		
		if(allowUrl.contains(action)){
			return true;//继续执行action,不拦截登陆的方法。
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('路径不存在！');location='/WEB-INF/jsp/index.jsp';</script>");
			return false;//此处为false时，请求不会到达control层
		}
	}
	
}
