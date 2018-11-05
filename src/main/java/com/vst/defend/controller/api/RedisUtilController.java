package com.vst.defend.controller.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import com.vst.common.tools.number.ToolsNumber;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.communal.util.PropertiesReader;
import com.vst.defend.communal.util.RedisUtils;

/**
 * Redis接口
 * @author lhp
 * @date 2018-9-4 下午05:28:24
 * @version
 */
@Controller
public class RedisUtilController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = RedisUtilController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 查询所有数据项
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis_all")
	@ResponseBody
	public JSONObject getAll(){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			Set<String> keys = jedis.keys("*");
			
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			for(String key : keys){
				// 根据类型，调用不同方法
				String type = jedis.type(key);
				if("string".equals(type)){
					String value = jedis.get(key);
					data.put(key+"("+type+")", value);
				}else if("list".equals(type)){
					List<String> value = jedis.lrange(key, 0, -1);
					data.put(key+"("+type+")", value);
				}else if("set".equals(type)){
					Set<String> value = jedis.smembers(key);
					data.put(key+"("+type+")", value);
				}else if("hash".equals(type)){
					Map<String, String> value = jedis.hgetAll(key);
					data.put(key+"("+type+")", value);
				}else if("zset".equals(type)){
					Set<String> value = jedis.zrange(key, 0, -1);
					data.put(key+"("+type+")", value);
				}
			}
			
			RedisUtils.closeJedis(jedis);
			
			if(!data.isEmpty()){
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
	@RequestMapping("/redis_keys")
	@ResponseBody
	public JSONObject getKeys(){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			Set<String> keys = jedis.keys("*");
			RedisUtils.closeJedis(jedis);
			
			if(!keys.isEmpty()){
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
	@RequestMapping("/redis_value")
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
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			if(jedis.exists(key)){
				// 根据类型，调用不同方法
				String type = jedis.type(key);
				if("string".equals(type)){
					String value = jedis.get(key);
					json.put("value", value);
				}else if("list".equals(type)){
					List<String> value = jedis.lrange(key, 0, -1);
					json.put("value", value);
				}else if("set".equals(type)){
					Set<String> value = jedis.smembers(key);
					json.put("value", value);
				}else if("hash".equals(type)){
					Map<String, String> value = jedis.hgetAll(key);
					json.put("value", value);
				}else if("zset".equals(type)){
					Set<String> value = jedis.zrange(key, 0, -1);
					json.put("value", value);
				}
				json.put("code", 100);
			}else{
				json.put("code", 202);
				json.put("msg", "key不存在！");
				return json;
			}
			RedisUtils.closeJedis(jedis);
			
			json.put("code", 100);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("getValue error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 添加数据项
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis_add")
	@ResponseBody
	public JSONObject addRedis(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// key、value、type
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			String value = ToolsString.checkEmpty(request.getParameter("value"));
			String type = ToolsString.checkEmpty(request.getParameter("type"));
			if(ToolsString.isEmpty(key) || ToolsString.isEmpty(value)){
				json.put("code", 201);
				json.put("msg", "key和value不可为空！");
				return json;
			}
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			if(jedis.exists(key)){
				json.put("code", 202);
				json.put("msg", "key已存在，请更换key！");
				return json;
			}else{
				// 判断是否添加成功
				boolean flag = false;
				
				if(ToolsString.isEmpty(type)){
					// 默认添加字符串
					jedis.set(key, value);
					flag = true;
				}else{
					if("string".equals(type)){
						jedis.set(key, value);
						flag = true;
					}else if("list".equals(type)){
						// 校验list格式
						if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
							String[] array = value.substring(1, value.length()-1).split(",");
							jedis.rpush(key, array);
							flag = true;
						}
					}else if("set".equals(type)){
						// 校验set格式
						if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
							String[] array = value.substring(1, value.length()-1).split(",");
							jedis.sadd(key, array);
							flag = true;
						}
					}else if("hash".equals(type)){
						// 校验hash格式
						if(value.length() > 2 && value.charAt(0) == '{' && value.charAt(value.length()-1) == '}'){
							String[] array = value.substring(1, value.length()-1).split(",");
							Map<String, String> hash = new LinkedHashMap<String, String>();
							for(String str : array){
								String[] temp = str.split(":");
								if(temp.length == 2){
									hash.put(temp[0], temp[1]);
								}else{
									break;
								}
							}
							jedis.hmset(key, hash);
							flag = true;
						}
					}else if("zset".equals(type)){
						// 校验zset格式
						if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
							String[] array = value.substring(1, value.length()-1).split(",");
							Map<String, Double> scoreMembers = new LinkedHashMap<String, Double>();
							for(int i=0; i<array.length; i++){
								scoreMembers.put(array[i], i+1.0);
							}
							jedis.zadd(key, scoreMembers);
							flag = true;
						}
					}
				}
				
				if(flag){
					json.put("code", 100);
					json.put("msg", "添加成功(key:"+key+",value:"+value+")！");
				}else{
					json.put("code", 200);
					json.put("msg", "添加失败，格式错误！");
				}
			}
			RedisUtils.closeJedis(jedis);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("addRedis error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 修改数据项
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis_edit")
	@ResponseBody
	public JSONObject editRedis(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			this.initializeAction(_className);
			
			// key、value、type
			String key = ToolsString.checkEmpty(request.getParameter("key"));
			String value = ToolsString.checkEmpty(request.getParameter("value"));
			String type = ToolsString.checkEmpty(request.getParameter("type"));
			if(ToolsString.isEmpty(key) || ToolsString.isEmpty(value)){
				json.put("code", 201);
				json.put("msg", "key和value不可为空！");
				return json;
			}
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			if(!jedis.exists(key)){
				json.put("code", 202);
				json.put("msg", "key不存在，请更换key！");
				return json;
			}else{
				// 判断是否修改成功
				boolean flag = false;
				
				if(ToolsString.isEmpty(type) && "string".equals(jedis.type(key))){
					// 默认修改字符串
					jedis.set(key, value);
					flag = true;
				}else{
					if(type.equals(jedis.type(key))){
						if("string".equals(type)){
							jedis.set(key, value);
							flag = true;
						}else if("list".equals(type)){
							// 校验list格式
							if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
								String[] array = value.substring(1, value.length()-1).split(",");
								// 先删除，再添加
								jedis.del(key);
								jedis.rpush(key, array);
								flag = true;
							}
						}else if("set".equals(type)){
							// 校验set格式
							if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
								String[] array = value.substring(1, value.length()-1).split(",");
								// 先删除，再添加
								jedis.del(key);
								jedis.sadd(key, array);
								flag = true;
							}
						}else if("hash".equals(type)){
							// 校验hash格式
							if(value.length() > 2 && value.charAt(0) == '{' && value.charAt(value.length()-1) == '}'){
								String[] array = value.substring(1, value.length()-1).split(",");
								Map<String, String> hash = new LinkedHashMap<String, String>();
								for(String str : array){
									String[] temp = str.split(":");
									if(temp.length == 2){
										hash.put(temp[0], temp[1]);
									}else{
										break;
									}
								}
								// 先删除，再添加
								jedis.del(key);
								jedis.hmset(key, hash);
								flag = true;
							}
						}else if("zset".equals(type)){
							// 校验zset格式
							if(value.length() > 2 && value.charAt(0) == '[' && value.charAt(value.length()-1) == ']'){
								String[] array = value.substring(1, value.length()-1).split(",");
								Map<String, Double> scoreMembers = new LinkedHashMap<String, Double>();
								for(int i=0; i<array.length; i++){
									scoreMembers.put(array[i], i+1.0);
								}
								// 先删除，再添加
								jedis.del(key);
								jedis.zadd(key, scoreMembers);
								flag = true;
							}
						}
					}else{
						json.put("code", 203);
						json.put("msg", "修改key的类型和type不一致！");
						return json;
					}
				}
				
				if(flag){
					json.put("code", 100);
					json.put("msg", "修改成功(key:"+key+",value:"+value+")！");
				}else{
					json.put("code", 200);
					json.put("msg", "修改失败，格式错误！");
				}
			}
			RedisUtils.closeJedis(jedis);
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("editRedis error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 删除key
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis_delete")
	@ResponseBody
	public JSONObject deleteRedis(HttpServletRequest request){
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
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			jedis.del(key);
			RedisUtils.closeJedis(jedis);
			
			json.put("code", 100);
			json.put("msg", "删除key("+key+")成功！");
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("deleteKey error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
	/**
	 * 清空数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis_flushdb")
	@ResponseBody
	public JSONObject flushDB(HttpServletRequest request){
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
			String redis_command = PropertiesReader.getProperty("redis_command");
			if(!command.equals(redis_command)){
				json.put("code", 202);
				json.put("msg", "验证失败！");
				return json;
			}
			
			Jedis jedis = RedisUtils.createJedis();
			// 选择哪个库，默认第0个库
			String db = ToolsString.checkEmpty(request.getParameter("db"));
			if(!ToolsString.isEmpty(db)){
				int dbs = ToolsNumber.parseInt(db, 0);
				jedis.select(dbs);
			}
			
			jedis.flushDB();
			RedisUtils.closeJedis(jedis);
			
			json.put("code", 100);
			json.put("msg", "清空数据成功！");
		} catch(Exception e){
			json.put("code", 301);
			json.put("msg", "服务器异常！");
			logger.error("flushDB error." + SystemException.getExceptionInfo(e));
		}
		return json;
	}
	
}
