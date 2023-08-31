package com.wit.subscriptionfacade.service;

import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.RemoteInvocationAwareMessageConverterAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendRequestService {

	private static final Logger LOGGER = LogManager.getLogger(SendRequestService.class);

	private final RabbitTemplate rabbitTemplate;
	private final Queue queue;

	@Autowired
	public SendRequestService(RabbitTemplate rabbitTemplate, Queue queue) {
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;
	}

	public BasicDTO sendSubscriptionMessage(BasicDTO dto) {
		LOGGER.info("Sending message: {}", dto);
		dto.setRequestId(MDC.get(Utils.MDC_REQUEST_ID));
		rabbitTemplate.setMessageConverter(new RemoteInvocationAwareMessageConverterAdapter());
		try {
			return (BasicDTO) rabbitTemplate.convertSendAndReceive(queue.getName(), dto);
		} catch (AmqpException e) {
			LOGGER.error(String.format("AmqpException: %s", e.getMessage()), e);
			throw e;
		}
	}

}
