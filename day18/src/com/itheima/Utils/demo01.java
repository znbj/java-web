package com.itheima.Utils;

import redis.clients.jedis.Jedis;

public class demo01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();

    }
}
