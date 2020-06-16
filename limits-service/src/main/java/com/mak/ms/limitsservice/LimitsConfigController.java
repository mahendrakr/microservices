package com.mak.ms.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigController {
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsConfiguration() {
		return new LimitConfiguration(config.getMaximum(), config.getMinimum());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public LimitConfiguration fallbackRetrieveConfiguration() {
		return new LimitConfiguration(999, 9);
	}
}
