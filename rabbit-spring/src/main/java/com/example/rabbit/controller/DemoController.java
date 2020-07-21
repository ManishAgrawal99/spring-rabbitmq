package com.example.rabbit.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.model.Person;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	@GetMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) {
		 
		Person p = new Person(1L, name);
		
		rabbitTemplate.convertAndSend("Mobile", p);
		//rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", p);
		
		return name+" added to list";
	}
	
}
