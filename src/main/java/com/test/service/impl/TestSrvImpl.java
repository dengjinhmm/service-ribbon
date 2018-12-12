package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.service.TestService;

/**
 * @author jin_deng
 *
 */
@Service
public class TestSrvImpl implements TestService {

	@Autowired
	public RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.test.service.TestService#testService(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "testError")
	public String testService(String name) {

		return restTemplate.getForObject("http://eureka-client/client/test?name=" + name, String.class);
	}

	public String testError(String name) {
		return name + ",对不起,本次请求的client不可用";
	}
}
