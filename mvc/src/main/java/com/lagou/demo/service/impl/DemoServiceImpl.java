package com.lagou.demo.service.impl;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.MyService;

@MyService("demoService")
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get() {
        return "通过！";
    }

	@Override
	public String resource() {
		return "通过！";
	}

	@Override
	public String resource1() {
		return "通过！";
	}
}
