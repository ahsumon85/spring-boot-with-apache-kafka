package com.chat.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.kafka.consume.MyTopicConsumer;
import com.chat.kafka.model.User;

@RestController
public class KafkaController {

	@Autowired
	private MyTopicConsumer myTopicConsumer;

	@Autowired
	private KafkaTemplate<String, User> template;
	private static final String TOPIC = "myTopic";

	@GetMapping(value = "/kafka/produce")
	public String produce(@RequestParam String message) {
		template.send(TOPIC, new User("Sumon", message));
		return message;
	}

	@GetMapping("/kafka/messages")
	public List<String> getMessages() {
		return myTopicConsumer.getMessages();
	}

}
