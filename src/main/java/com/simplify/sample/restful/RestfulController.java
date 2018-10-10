package com.simplify.sample.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplify.sample.security.domain.SecurityMember;

@RestController
public class RestfulController {

	private Logger LOGGER = LoggerFactory.getLogger(RestfulController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/restfulTest")
	public String home(@AuthenticationPrincipal SecurityMember securityMember) {
		
		LOGGER.debug(securityMember.getIp());
		
		String obj = restTemplate.getForObject("http://localhost:8080/openapi/readUser/abc", String.class);
		
		LOGGER.debug(obj);
		
		return obj;
	}
	
	
}
