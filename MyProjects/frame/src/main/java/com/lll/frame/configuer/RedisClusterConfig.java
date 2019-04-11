package com.lll.frame.configuer;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RedisClusterConfig
 * @Description Redis集群配置类
 * @Author zl
 * @Create 2019-04-02 18:06
 **/
@Configuration
@EnableCaching
public class RedisClusterConfig extends CachingConfigurerSupport {

  @Resource
  private LettuceConnectionFactory lettuceConnectionFactory;


  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    System.err.println("key ....");
    return (target, method, params) -> {
      StringBuffer sb = new StringBuffer();
      sb.append(target.getClass().getName());
      sb.append(method.getName());
      for (Object obj : params) {
        sb.append(obj.toString());
      }
      return sb.toString();
    };
  }


  /**
   * 缓存管理器
   * @return
   */
  @Bean
  @Override
  public CacheManager cacheManager() {
    System.err.println("缓存处理器");
    RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
            .fromConnectionFactory(lettuceConnectionFactory);
    @SuppressWarnings("serial")
    Set<String> cacheNames = new HashSet<String>() {
      {
        add("codeNameCache");
      }
    };
    builder.initialCacheNames(cacheNames);
    return builder.build();
  }


}
