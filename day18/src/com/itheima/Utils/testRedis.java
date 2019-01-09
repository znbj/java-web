package com.itheima.Utils;

import redis.clients.jedis.Jedis;

public class testRedis {
    public static void main(String[] args) {
        Jedis connection = RedisUtil.getConnection();
        String name = connection.get("name");
        System.out.println(name);
        connection.close();

    }
}
