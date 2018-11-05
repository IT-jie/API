package com.vst.defend.controller.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.encrypt.ToolsEncrypt;
import com.vst.common.tools.http.Request;
import com.vst.common.tools.http.ToolsHttp;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.service.sys.VstOptionService;

/**
 * 加密工具接口
 * @author lhp
 * @date 2018-9-21 上午11:04:27
 * @version
 */
@Controller
public class EncryptUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = EncryptUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 控制面板Service接口
	 */
	@Resource
	private VstOptionService _vstOptionService;
	
	/**
	 * SHA256加密
	 * @param request
	 * @return
	 */
	@RequestMapping("/encrypt_SHA256")
	@ResponseBody
	public JSONObject getSHA256Encrypt(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 内容
			String text = ToolsString.checkEmpty(request.getParameter("text"));
			if(ToolsString.isEmpty(text)){
				json.put("code", 201);
				json.put("msg", "内容不可为空！");
				return json;
			}
			
			String result = ToolsEncrypt.getSHA256Encrypt(text);
			json.put("code", 100);
			json.put("result", result);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getSHA256Encrypt error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * SHA256解密
	 * @param request
	 * @return
	 */
	@RequestMapping("/decrypt_SHA256")
	@ResponseBody
	public JSONObject getSHA256Decrypt(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 内容
			String text = ToolsString.checkEmpty(request.getParameter("text"));
			if(ToolsString.isEmpty(text)){
				json.put("code", 201);
				json.put("msg", "内容不可为空！");
				return json;
			}
			
			String url = "http://www.ttmd5.com/do.php?c=Decode&m=getMD5&md5="+text;
			Request req = new Request(url);
			String cookie = _vstOptionService.getOptionValue("ttmd5_cookie");
			req.setCookie(cookie);
			JSONObject result = ToolsHttp.getJson(req);
			System.out.println(result);
			if(result.getIntValue("flag") == 1){
				json.put("code", 100);
				json.put("msg", result.get("msg"));
				json.put("result", result.getString("plain"));
			}else{
				json.put("code", 200);
				json.put("msg", "解密失败！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getSHA256Decrypt error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * MD5加密
	 * @param request
	 * @return
	 */
	@RequestMapping("/encrypt_MD5")
	@ResponseBody
	public JSONObject getMD5Encrypt(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 内容
			String text = ToolsString.checkEmpty(request.getParameter("text"));
			if(ToolsString.isEmpty(text)){
				json.put("code", 201);
				json.put("msg", "内容不可为空！");
				return json;
			}
			
			String result = ToolsEncrypt.getMD5Encrypt(text);
			json.put("code", 100);
			json.put("result", result);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getMD5Encrypt error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * MD5解密
	 * @param request
	 * @return
	 */
	@RequestMapping("/decrypt_MD5")
	@ResponseBody
	public JSONObject getMD5Decrypt(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 内容
			String text = ToolsString.checkEmpty(request.getParameter("text"));
			if(ToolsString.isEmpty(text)){
				json.put("code", 201);
				json.put("msg", "内容不可为空！");
				return json;
			}
				
			String url = "http://www.ttmd5.com/do.php?c=Decode&m=getMD5&md5="+text;
			Request req = new Request(url);
			String cookie = _vstOptionService.getOptionValue("ttmd5_cookie");
			req.setCookie(cookie);
			JSONObject result = ToolsHttp.getJson(req);
			System.out.println(result);
			if(result.getIntValue("flag") == 1){
				json.put("code", 100);
				json.put("msg", result.get("msg"));
				json.put("result", result.getString("plain"));
			}else{
				json.put("code", 200);
				json.put("msg", "解密失败！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getMD5Decrypt error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
}
