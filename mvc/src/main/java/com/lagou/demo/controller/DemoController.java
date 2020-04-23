package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.MyAutowired;
import com.lagou.edu.mvcframework.annotations.MyController;
import com.lagou.edu.mvcframework.annotations.MyRequestMapping;
import com.lagou.edu.mvcframework.annotations.MySecurity;

@MyController
@MyRequestMapping("/demo")
public class DemoController {


    @MyAutowired
    private IDemoService demoService;


	@MyRequestMapping("/resource1")
	@MySecurity(value = "zhangsan")
	public String resource1(String name) {

		return demoService.get();
	}

	@MyRequestMapping("/resource2")
	@MySecurity(value = "lisi")
	public String resource2() {
		return demoService.resource();
	}

	@MyRequestMapping("/resource3")
	@MySecurity(value = {"lisi", "zhangsan"})
	public String resource3() {
		return demoService.resource1();
	}
}
