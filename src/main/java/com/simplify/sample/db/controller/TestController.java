package com.simplify.sample.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplify.sample.db.dto.Test;
import com.simplify.sample.db.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping("openapi/query")
    public @ResponseBody List<Test> query() throws Exception{
        return testService.getAll();
    }
 
}
