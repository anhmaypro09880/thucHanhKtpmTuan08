package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController

public class ClientController {
	@Autowired
	private EurekaClient client;
	@Autowired
	
	private RestTemplateBuilder restTemplateBuilder;
	@RequestMapping("/")
	public String callSerice() {
		InstanceInfo instance = client.getNextServerFromEureka("service2", false);
		String url = instance.getHomePageUrl();
		System.out.println(url);
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
		return response.getBody();
	}
}
