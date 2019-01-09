package com.itheima.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtilsdemo {
    private static JedisPool jedisPool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(50);
        config.setMaxWaitMillis(1000);
        config.setMinIdle(5);
        jedisPool = new JedisPool(config, "localhost", 6379);
    }

    public static Jedis getConnection() {
        return jedisPool.getResource();
    }


   /* public static void main(String[] args) {
        Jedis connection = getConnection();
        String name = connection.get("name");
        System.out.println(name);

    }*/



}
