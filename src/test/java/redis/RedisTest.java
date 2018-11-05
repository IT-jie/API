package redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
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
	            // 查看服务是否运行
	            System.out.println("服务正在运行: "+jedis.ping());
	
				// 获取存储的数据并输出
				System.out.println("redis 存储的字符串为: "+ jedis.get("wj_str"));
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
