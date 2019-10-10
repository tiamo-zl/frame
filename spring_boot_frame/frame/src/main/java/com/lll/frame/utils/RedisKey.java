package com.lll.frame.utils;

import java.util.Random;

/**
 * RedisKey
 * redis key
 * @Author zl
 * @Create 2019-04-15 16:19
 **/
public class RedisKey {

    /**
     * key 存活时间
     */
    private static final Integer TIME = 60 * 60 * 2;
    /**
     * key 存活的最大随机时间
     */
    private static final Integer RANDOM_TIME = 60 * 15;
    /**
     * user_id_key
     */
    public static final String USER_ID_KEY = "user_id_Key_";
    /**
     * user_all_key
     */
    public static final String USER_ALL_KEY = "user_all_Key_";

    /**
     * 获取key存活的随机时间
     * @return
     */
    public static Integer getKeyTime(){
        return TIME + new Random().nextInt(RANDOM_TIME);
    }
}
