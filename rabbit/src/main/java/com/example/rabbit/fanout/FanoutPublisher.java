package com.example.rabbit.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class FanoutPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and AC";
		
		//Broadcasts the message to all the subscribed Queues
		channel.basicPublish("Fanout-Exchange", "", null, message.getBytes());
		
		channel.close();
		connection.close();
	}
}
