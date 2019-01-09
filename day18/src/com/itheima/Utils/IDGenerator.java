package com.itheima.Utils;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class IDGenerator {
    private static Map<String, Queue<Long>> queue = new ConcurrentHashMap<>();
    private static long section = 20l;//区间 一次取出多少个放在缓存
    private static final String PREFIX="ids_";

    public static String next(String idKey) {
        return _get(idKey);
    }

    private static String _get(String idKey) {
        Queue<Long> queue = getQueue(idKey);
        //此处队列肯定是存在的
        Long poll = queue.poll();
        if (poll != null) {
            return String.valueOf(poll);
        } else {
            synchronized (queue) {
                refill(queue, idKey);
            }
            return String.valueOf(queue.poll());
        }
    }

    private static Queue<Long> getQueue(String idKey) {
        if (queue.containsKey(idKey)) {
            return queue.get(idKey);
        } else {
            synchronized (IDGenerator.class) {
                //初始化队列的概率小 所有这里就直接使用
                // synchronized加锁了 没有多少性能损耗
                Queue<Long> queue = new ConcurrentLinkedQueue<>();
                ///!!!!!!!!!!!!!!!!!!!!!!





                return queue;
            }
        }

    }

    /**
     * 重新装填数据
     * @param queue
     * @param idKey
     */
    private static void refill(Queue<Long> queue, String idKey) {
        Jedis connection = RedisUtil.getConnection();
        Long end = connection.incrBy(PREFIX + idKey, section);
        long start = end - section + 1;
        initQueue(queue, start, end);
        connection.close();
        
    }

    private static void initQueue(Queue<Long> queue, long start, Long end) {

        for (long i=start;i<end;i++) {
            queue.add(i);
        }
    }

    







}
