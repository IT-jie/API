package redis;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class MyTest {

	@Test
	public void test1(){
		String host = "chen-fragrans.top";
        int port = 6379;
        String password = "root520";
        Jedis jedis = null;
        try {
        	// 连接Redis服务
            jedis = new Jedis(host, port);
            jedis.auth(password);
            if(jedis != null){
	            System.out.println("连接成功");
	            
	            Set<String> keys = jedis.keys("*");
	            
	            for(String key : keys){
		            String type = jedis.type(key);
		            System.out.println(key + " : " + type);
	            }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                try {
                    jedis.close();
                }catch (Exception e){
                    System.out.println("redis连接关闭失败");
                    e.printStackTrace();
                }
            }
        }
	}
}
