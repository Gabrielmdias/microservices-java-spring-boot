package com.wit.subscriptiondb.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

	@Value("${spring.rabbitmq.queue.name}")
	public String queueName;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName, true);
	}

}
