package com.vst.defend.controller.api;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.http.ToolsHttp;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;

/**
 * 高德工具接口
 * @author lhp
 * @date 2018-8-17 下午05:59:56
 * @version
 */
@Controller
public class AmapUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = AmapUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 应用key
	 */
	private static final String KEY = "e363a9f573b748dc557fd10a5dc57e07";
	
	/**
	 * 根据IP定位
	 * @param request
	 * @return
	 */
	@RequestMapping("/ip_position")
	@ResponseBody
	public JSONObject positionByIP(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// ip
			String ip = ToolsString.checkEmpty(request.getParameter("ip"));
			if(ToolsString.isEmpty(ip)){
				ip = this.getIpAddr();
			}
			System.out.println("IP:" + ip);
			
			String url = "https://restapi.amap.com/v3/ip?key={key}&ip={ip}"
						.replace("{key}", KEY)
						.replace("{ip}", ip);
			
			json = ToolsHttp.getJson(url);
			if(json != null){
				json.put("ip", ip);
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("positionByIP error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 查询城市天气
	 * @param request
	 * @return
	 */
	@RequestMapping("/city_weather")
	@ResponseBody
	public JSONObject cityWeather(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 城市
			String city = ToolsString.checkEmpty(request.getParameter("city"));
			if(ToolsString.isEmpty(city)){
				// 获取当前城市
				String ip = this.getIpAddr();
				String url = "https://restapi.amap.com/v3/ip?key={key}&ip={ip}"
					.replace("{key}", KEY)
					.replace("{ip}", ip);
		
				JSONObject temp = ToolsHttp.getJson(url);
				city = temp.getString("city");
			}
			System.out.println("city:" + city);
			
			String url = "http://restapi.amap.com/v3/weather/weatherInfo?key={key}&city={city}"
						.replace("{key}", KEY)
						.replace("{city}", URLEncoder.encode(city, "utf-8"));
			
			json = ToolsHttp.getJson(url);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("cityWeather error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
}
