package com.example.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class JsonPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("from_date", "01-Jan-2019");
		jsonObject.put("to_Date", "31-Dec-2019");
		jsonObject.put("email", "xyz@email.com");
		
		channel.basicPublish("", "Queue-1", null, jsonObject.toString().getBytes());
		
		channel.close();
		connection.close();
		

	}

}
