package com.example.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbit.model.Person;

@Service
public class ConsumerService {
	
	
	@RabbitListener(queues = "Mobile")
	public void getMessage(Person message) {
		System.out.println(message.getName());
	}
}
