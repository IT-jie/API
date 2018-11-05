package com.vst.defend.communal.util;

import redis.clients.jedis.Jedis;

import com.vst.common.tools.number.ToolsNumber;

/**
 * Redis工具类
 * @author lhp
 * @date 2018-9-4 下午05:32:27
 * @version
 */
public class RedisUtils {
	/**
	 * 创建连接
	 * @return
	 * @throws Exception
	 */
	public static Jedis createJedis() throws Exception{
		Jedis jedis = null;
		
		String host = PropertiesReader.getProperty("redis_url");
		int port = ToolsNumber.parseInt(PropertiesReader.getProperty("redis_port"));
		String password = PropertiesReader.getProperty("redis_password");
		
		jedis = new Jedis(host, port);
		jedis.auth(password);
		
		return jedis;
	}
	
	/**
	 * 关闭连接
	 * @param jedis
	 * @throws Exception
	 */
	public static void closeJedis(Jedis jedis) throws Exception{
		if(jedis != null){
			jedis.close();
		}
	}
}
