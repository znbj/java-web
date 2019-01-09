package com.itheima.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;
import java.util.ResourceBundle;

public class RedisUtil {
    //创建连接池
    private static JedisPool jedisPool=null;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //解析配置文件
        ResourceBundle redis = ResourceBundle.getBundle("Redis");
        String host = redis.getString("host");
        int port = Integer.parseInt(redis.getString("port"));
        int MaxIdle = Integer.parseInt(redis.getString("MaxIdle"));
        int MaxTotal = Integer.parseInt(redis.getString("MaxTotal"));
        int MaxWaitMillis = Integer.parseInt(redis.getString("MaxWaitMillis"));
        int MinIdle = Integer.parseInt(redis.getString("MinIdle"));
        jedisPoolConfig.setMinIdle(MinIdle);
        jedisPoolConfig.setMaxWaitMillis(MaxWaitMillis);
        jedisPoolConfig.setMaxTotal(MaxTotal);
        jedisPoolConfig.setMaxIdle(MaxIdle);
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    public static Jedis getConnection() {

        return jedisPool.getResource();
    }
}
