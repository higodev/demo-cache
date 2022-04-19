package com.example.demo.resources;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoResource {

  @Cacheable(value = "demo")
  @GetMapping("/demo")
  public String getDemo() {
    simulateSlowService();
    return "Demo caching =D";
  }

  private void simulateSlowService() {
    try {
      long time = 5000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
