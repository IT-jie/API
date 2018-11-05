package com.vst.defend.communal.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存配置
 * @author lhp
 * @date 2018-5-28 上午10:17:40
 * @version
 */
public class CacheConfig {
	/**
	 * 单例类
	 */
	private static final CacheConfig _cache = new CacheConfig();
	
	/**
	 * 缓存集合数据
	 */
	private Map<String, Object> _dataMap = new HashMap<String, Object>();
	
	/**
	 * 构造器私有化
	 */
	private CacheConfig(){
		
	}
	
	/**
	 * 获取单例类
	 * @return
	 */
	public static CacheConfig getInstance(){
		return _cache;
	}
	
	/**
	 * 往缓存集合中加数据
	 * @param key
	 * @param value
	 */
	public void putDataMap(String key, Object value){
		_dataMap.put(key, value);
	}
	
	/**
	 * 读取缓存集合的数据
	 * @param key
	 * @return
	 */
	public Object getDataMap(String key){
		return _dataMap.get(key);
	}
	
	/**
	 * 移除缓存集合的数据
	 * @param key
	 */
	public void removeDataMap(String key){
		_dataMap.remove(key);
	}
	
	/**
	 * 清除缓存集合
	 */
	public void clearDataMap(){
		_dataMap.clear();
	}
}
