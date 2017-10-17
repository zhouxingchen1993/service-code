package com.htsat.cart.config;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @desc redis config bean
 *
 */
//@Configuration
//@EnableAutoConfiguration
//@ConfigurationProperties(prefix = "spring.redis", locations = "classpath:application.properties")
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

	private  Logger logger = Logger.getLogger(RedisConfig.class);

	private  String host;

	private  int port;

	private  String password;

	private  int timeout;

	private  int max_active;

	private  int max_idle;

	private  int max_wait;

	private  JedisPool pool = null;

	private  JedisPool initialPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(max_idle);
		config.setMaxTotal(max_active);
		config.setMaxWaitMillis(max_wait);

		try {
			pool = new JedisPool(config,host.split(",")[0],port,timeout,password);
		} catch (Exception e1) {
			logger.error("first create JedisPool error : " + e1);
			try {
				pool = new JedisPool(config,host.split(",")[1],port,timeout,password);
			} catch (Exception e2){
				logger.error("second create JedisPool error : " + e2);
				e2.printStackTrace();
			}
		}
		return pool;
	}

	/**
	 * 多线程环境同步初始化
	 */
	private  synchronized void poolInit() {
		if (pool == null) {
			initialPool();
		}
	}

	public synchronized  Jedis getJedis(){
		if (pool == null) {
			poolInit();
		}
		Jedis jedis = null;
		try {
			if (pool != null) {
				jedis = pool.getResource();
			}
		} catch (Exception e) {
			logger.error("Get jedis error : "+e);
			e.printStackTrace();
		}finally{
			returnResource(jedis);
		}
		return jedis;
	}

	@SuppressWarnings("deprecation")
	public  void returnResource(final Jedis jedis) {
		if (jedis != null && pool !=null) {
			pool.returnResource(jedis);
		}
	}

	public  void set(String key, String value) {
		Jedis jedis = getJedis();
		try{
			value = StringUtils.isEmpty(value) ? "" : value;
			jedis.set(key, value);
			logger.info("Redis set success - " + key + ", value:" + value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
		}finally{
			returnResource(jedis);
		}
	}

	public  void set(String key ,int seconds,String value){
		Jedis jedis = getJedis();
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			jedis.setex(key, seconds, value);
			logger.info("Redis set success - " + key + ", value:" + value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
		}finally{
			returnResource(jedis);
		}
	}

	public  String get(String key) {
		if(getJedis() == null || !getJedis().exists(key)){
			return null;
		}
		String result = null;
		Jedis jedis = getJedis();
		try{
			result = jedis.get(key);
			logger.info("Redis get success - " + key + ", value:" + result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
		}finally{
			returnResource(jedis);
		}
		return result;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMax_active() {
		return max_active;
	}

	public void setMax_active(int max_active) {
		this.max_active = max_active;
	}

	public int getMax_idle() {
		return max_idle;
	}

	public void setMax_idle(int max_idle) {
		this.max_idle = max_idle;
	}

	public int getMax_wait() {
		return max_wait;
	}

	public void setMax_wait(int max_wait) {
		this.max_wait = max_wait;
	}
}
