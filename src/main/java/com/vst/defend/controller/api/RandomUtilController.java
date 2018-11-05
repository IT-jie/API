package com.vst.defend.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.number.ToolsNumber;
import com.vst.common.tools.number.ToolsRandom;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;

/**
 * 随机数工具
 * @author lhp
 * @date 2018-8-17 下午06:31:38
 * @version
 */
@Controller
public class RandomUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = RandomUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 获取随机数
	 * @param request
	 * @return
	 */
	@RequestMapping("/random_data")
	@ResponseBody
	public JSONObject getRandomNumber(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			int start = ToolsNumber.parseInt(request.getParameter("start"));
			int end = ToolsNumber.parseInt(request.getParameter("end"));
			
			if(end < start){
				json.put("code", 201);
				json.put("msg", "最大值不能小于最小值！");
				return json;
			}
			
			int random = ToolsRandom.getRandomNumber(start, end);
			
			System.out.println("start:"+start+",end:"+end+",random:"+random);
			
			json.put("code", 100);
			json.put("random", random);
			
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getRandomNumber error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 获取数组中随机一项
	 * @param request
	 * @return
	 */
	@RequestMapping("/random_array")
	@ResponseBody
	public JSONObject getRandomByArr(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			// 格式：list=[3,6,9]
			String list = ToolsString.checkEmpty(request.getParameter("list"));
			
			if(ToolsString.isEmpty(list)){
				json.put("code", 201);
				json.put("msg", "参数不可为空！");
				return json;
			}
			
			if(list.length() > 2 && list.charAt(0) == '[' && list.charAt(list.length()-1) == ']'){
				String[] array = list.substring(1, list.length()-1).split(",");
				int random = ToolsRandom.getRandomNumber(1, array.length);
				
				System.out.println("list:"+list+",random:"+array[random-1]);
				
				json.put("code", 100);
				json.put("random", array[random-1]);
			}else{
				json.put("code", 202);
				json.put("msg", "参数格式错误！");
				return json;
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getRandomNumber error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
}
