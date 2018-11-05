package com.vst.defend.controller.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vst.common.pojo.VstSysOption;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.communal.util.PropertiesReader;
import com.vst.defend.dao.sys.VstOptionDao;

/**
 * 常量配置接口
 * @author lhp
 * @date 2018-9-18 上午11:06:25
 * @version
 */
@Controller
public class OptionUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = OptionUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 系统配置Dao接口
	 */
	@Resource
	private VstOptionDao _vstOptionDao;
	
	/**
	 * 查询所有数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_all")
	@ResponseBody
	public JSONObject getAll(){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			List<Map<String, Object>> list = _vstOptionDao.queryForList(null);
			if(list != null && !list.isEmpty()){
				JSONArray data = new JSONArray();
				for(Map<String, Object> map : list){
					Map<String, Object> temp = new LinkedHashMap<String, Object>();
					temp.put("key", map.get("vst_option_key"));
					temp.put("value", map.get("vst_option_value"));
					temp.put("desc", map.get("vst_option_desc"));
					data.add(temp);
				}
				json.put("code", 100);
				json.put("data", data);
			}else{
				json.put("code", 200);
				json.put("msg", "数据为空！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getAll error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 获取所有key
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_keys")
	@ResponseBody
	public JSONObject getKeys(){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			List<Map<String, Object>> list = _vstOptionDao.queryForList(null);
			if(list != null && !list.isEmpty()){
				Set<String> keys = new LinkedHashSet<String>(list.size());
				for(Map<String, Object> map : list){
					keys.add(map.get("vst_option_key")+"");
				}
				json.put("code", 100);
				json.put("keys", keys);
			}else{
				json.put("code", 200);
				json.put("msg", "数据为空！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getKeys error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 根据key获取value
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_value")
	@ResponseBody
	public JSONObject getValue(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// key
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			if(ToolsString.isEmpty(key)){
				json.put("code", 201);
				json.put("msg", "key不可为空！");
				return json;
			}
			
			Map<String, Object> map = _vstOptionDao.queryById(key);
			if(map != null){
				json.put("code", 100);
				json.put("value", map.get("vst_option_value"));
			}else{
				json.put("code", 200);
				json.put("msg", "key不存在！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getValue error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 添加常量
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_add")
	@ResponseBody
	public JSONObject addOption(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// key、value、desc
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			String value = ToolsString.checkEmpty(request.getParameter("value"));
			String desc = ToolsString.checkEmpty(request.getParameter("desc"));
			if(ToolsString.isEmpty(key) || ToolsString.isEmpty(value)){
				json.put("code", 201);
				json.put("msg", "key和value不可为空！");
				return json;
			}
			
			Map<String, Object> map = _vstOptionDao.queryById(key);
			if(map == null){
				VstSysOption bean = new VstSysOption();
				bean.setVst_option_key(key);
				bean.setVst_option_value(value);
				bean.setVst_option_desc(desc);
				_vstOptionDao.insert(bean);
				
				json.put("code", 100);
				json.put("msg", "添加成功！");
			}else{
				json.put("code", 200);
				json.put("msg", "key已存在，请更换key！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("addOption error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 修改常量
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_edit")
	@ResponseBody
	public JSONObject editOption(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// key、value、desc
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			String value = request.getParameter("value");
			String desc = request.getParameter("desc");
			if(ToolsString.isEmpty(key) || ToolsString.isEmpty(value)){
				json.put("code", 201);
				json.put("msg", "key和value不可为空！");
				return json;
			}
			
			Map<String, Object> map = _vstOptionDao.queryById(key);
			if(map != null){
				VstSysOption bean = new VstSysOption();
				bean.setVst_option_key(key);
				bean.setVst_option_value(value);
				bean.setVst_option_desc(desc);
				_vstOptionDao.update(bean);
				
				json.put("code", 100);
				json.put("msg", "修改成功！");
			}else{
				json.put("code", 200);
				json.put("msg", "key不存在！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("editOption error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 删除常量
	 * @param request
	 * @return
	 */
	@RequestMapping("/option_delete")
	@ResponseBody
	public JSONObject deleteOption(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// 命令
			String command = ToolsString.checkEmpty(request.getParameter("command"));
			if(ToolsString.isEmpty(command)){
				json.put("code", 201);
				json.put("msg", "请输入删除指令！");
				return json;
			}
			// 验证命令
			String option_command = PropertiesReader.getProperty("option_command");
			if(!command.equals(option_command)){
				json.put("code", 202);
				json.put("msg", "验证失败！");
				return json;
			}
			
			// key
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			if(ToolsString.isEmpty(key)){
				json.put("code", 201);
				json.put("msg", "key不可为空！");
				return json;
			}
			
			Map<String, Object> map = _vstOptionDao.queryById(key);
			if(map != null){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("list_ids", Arrays.asList(key.split(",")));
				_vstOptionDao.delete(params);
				
				json.put("code", 100);
				json.put("msg", "删除成功！");
			}else{
				json.put("code", 200);
				json.put("msg", "key不存在！");
			}
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("deleteOption error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
}
