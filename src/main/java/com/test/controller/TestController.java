package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.TestService;

/**
 * @author jin_deng
 *
 */
@RestController
@RequestMapping("/ribbon")
public class TestController {

	@Autowired
	public TestService testService;

	@GetMapping("/test")
	public String test(@RequestParam String name) {
		return testService.testService(name);
	}

}
