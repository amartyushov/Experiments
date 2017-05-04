package io.mart;

import redis.clients.jedis.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Aleksandr Martiushov
 */
public class Redis {
    private static final Jedis jedis = new Jedis("localhost");

    public static void main(String[] args) {
        // [start redis]  redis-server /usr/local/etc/redis.conf
        pipelining();
    }

    private static void ping() {
        System.out.println("Server is running: " + jedis.ping());
    }

    private static void string() {
        jedis.set("tutorial-name", "Redis tutorial");
        System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));
    }

    private static void list() {
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb", "Mysql");
        List<String> list = jedis.lrange("tutorial-list", 0, 1);
        list.stream().forEach(System.out::println);
    }

    private static void listPop() {
        jedis.lpush("queue#tasks", "firstTask");
        jedis.lpush("queue#tasks", "secondTask");
        System.out.println(jedis.rpop("queue#tasks"));
    }

    private static void keys() {
        Set<String> list = jedis.keys("*");
        list.stream().forEach(System.out::println);
    }

    private static void sets() {
        jedis.sadd("nicknames", "nickname#1");
        jedis.sadd("nicknames", "nickname#2");
        jedis.sadd("nicknames", "nickname#1");

        System.out.println(jedis.smembers("nicknames"));
        boolean exists = jedis.sismember("nicknames", "nickname#1");
    }

    private static void hash() {
        jedis.hset("user#1", "name", "Peter");
        jedis.hset("user#1", "job", "politician");

        System.out.println(jedis.hget("user#1", "name"));

        Map<String, String> fields = jedis.hgetAll("user#1");
        System.out.println(fields.get("job"));
    }

    /**
     * The variable player will hold the value PlayerThree because we are retrieving
     * the top 1 player and he is the one with the highest score.
     * The rank variable will have a value of 1 because PlayerOne
     * is the second in the ranking and the ranking is zero-based.
     */
    private static void sortedSet() {
        Map<String, Double> scores = new HashMap<String, Double>(){{
            put("PlayerOne", 3000.0);
            put("PlayerTwo", 1500.0);
            put("PlayerThree", 8200.0);
        }};

        scores.keySet().forEach(player -> {
            jedis.zadd("ranking", scores.get(player), player);
        });

        String player = jedis.zrevrange("ranking", 0, 1).iterator().next();
        System.out.println(player);
        long rank = jedis.zrevrank("ranking", "PlayerOne");
        System.out.println(rank);
    }

    private static void pipelining(){
        String userOneId = "4352523";
        String userTwoId = "4849888";

        Pipeline p = jedis.pipelined();
        p.sadd("searched#" + userOneId, "paris");
        p.zadd("ranking", 126, userOneId);
        p.zadd("ranking", 325, userTwoId);
        Response<Boolean> pipeExists = p.sismember("searched#" + userOneId, "paris");
        Response<Set<String>> pipeRanking = p.zrange("ranking", 0, -1);
        p.sync();

        Boolean exists = pipeExists.get();
        System.out.println(exists);
        Set<String> ranking = pipeRanking.get();
        System.out.println(ranking);
    }

    private static void pooling(){
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);

        JedisPool jedisPool = new JedisPool(poolConfig, "localhost");

        try (Jedis jedis = jedisPool.getResource()) {
            // do operations with jedis resource
        }
    }
}
