package com.vst.defend.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.date.ToolsDate;
import com.vst.common.tools.number.ToolsNumber;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;

/**
 * 常用工具
 * @author lhp
 * @date 2018-8-17 下午06:16:09
 * @version
 */
@Controller
public class DateUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = DateUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 获取当前时间
	 * @param request
	 * @return
	 */
	@RequestMapping("/current_time")
	@ResponseBody
	public JSONObject getCurrentTime(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			long time = System.currentTimeMillis();
			String date = ToolsDate.formatDate(ToolsDate.yyyy_MM_dd_HH_mm_ss, time);
			
			System.out.println("date:"+date);
			
			json.put("time", time);
			json.put("date", date);
			
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getCurrentTime error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 时间戳转日期
	 * @param request
	 * @return
	 */
	@RequestMapping("/time_to_date")
	@ResponseBody
	public JSONObject timeConvertDate(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 时间戳
			String time = ToolsString.checkEmpty(request.getParameter("time"));
			if(ToolsString.isEmpty(time)){
				json.put("code", 201);
				json.put("msg", "时间戳不可为空！");
				return json;
			}
			System.out.println("time:"+time);
			
			String date = ToolsDate.formatDate(ToolsDate.yyyy_MM_dd_HH_mm_ss, ToolsNumber.parseLong(time));
			json.put("code", 100);
			json.put("date", date);
			
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("timeConvertDate error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 日期转时间戳
	 * @param request
	 * @return
	 */
	@RequestMapping("/date_to_time")
	@ResponseBody
	public JSONObject dateConvertTime(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 时间戳
			String date = ToolsString.checkEmpty(request.getParameter("date"));
			if(ToolsString.isEmpty(date)){
				json.put("code", 201);
				json.put("msg", "日期不可为空！");
				return json;
			}
			System.out.println("date:"+date);
			
			long time = ToolsDate.parseDate(ToolsDate.yyyy_MM_dd_HH_mm_ss, date).getTime();
			json.put("code", 100);
			json.put("time", time);
			
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("dateConvertTime error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
}
