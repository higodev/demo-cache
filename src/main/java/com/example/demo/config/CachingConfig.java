package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {

  private static final Logger logger = LoggerFactory.getLogger(CachingConfig.class);

  @CacheEvict(allEntries = true, value = {"demo"})
  @Scheduled(fixedDelay = 20000, initialDelay = 1000)
  public void reportCacheEvict() {
    logger.info("Flush cache demo");
  }
}
