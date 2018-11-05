package com.vst.defend.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.communal.util.VstConstants;
import com.vst.defend.service.api.AddressUtilService;

/**
 * 地区工具接口
 * @author lhp
 * @date 2018-8-22 上午10:19:44
 * @version
 */
@Controller
public class AddressUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = AddressUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 地区工具Service接口
	 */
	@Resource
	private AddressUtilService _addressUtilService;
	
	/**
	 * 获取地区
	 * @param request
	 * @return
	 */
	@RequestMapping("/get_address")
	@ResponseBody
	public JSONObject getAddress(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 省份
			String province = ToolsString.checkEmpty(request.getParameter("province"));
			List<String> data = null;
			if(ToolsString.isEmpty(province)){
				Map<String, Object> params = new HashMap<String, Object>(1);
				params.put("vst_province_status", VstConstants.STATE_AVALIABLE);
				data = _addressUtilService.getProvinceList(params);
			}else{
				Map<String, Object> params = new HashMap<String, Object>(2);
				params.put("vst_province_name", province);
				params.put("vst_city_status", VstConstants.STATE_AVALIABLE);
				data = _addressUtilService.getCityList(params);
			}
			
			if(data != null && !data.isEmpty()){
				json.put("code", 100);
				json.put("data", data);
				json.put("msg", "调用成功！");
			}else{
				json.put("code", 200);
				json.put("msg", "没有结果！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getAddress error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
}
