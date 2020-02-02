package com.chat.kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import com.chat.kafka.model.User;

@Configuration
public class ProducerConfiguration {
	private static final String KAFKA_BROKER = "localhost:9092";

	@Bean
	public ProducerFactory<String, User> producerFactory() {
		Map<String, Object> configurations = new HashMap<>();
		configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
		configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configurations);
	}

	@Bean
	public KafkaTemplate<String, User> kafkaTemplate() {
		return new KafkaTemplate<String, User>(producerFactory());
	}

}
