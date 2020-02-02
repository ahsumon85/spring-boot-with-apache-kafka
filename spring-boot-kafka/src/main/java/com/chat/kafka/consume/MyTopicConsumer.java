package com.chat.kafka.consume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyTopicConsumer {

	private final List<String> messages = new ArrayList<>();

	@KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
	public void listen(String message) {
		synchronized (messages) {
			System.out.println(message);
			messages.add(message);
		}
	}

	public List<String> getMessages() {
		return messages;
	}

}
