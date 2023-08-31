package com.wit.subscriptiondb.service;

import com.wit.subscriptiondb.domain.BasicEntity;
import com.wit.subscriptiondb.repository.BasicRepository;
import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.logging.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueue {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsumerQueue.class);

	private final ServiceManager serviceManager;
	
	public ConsumerQueue(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RabbitListener(queues = "queue-subscription", returnExceptions = "true")
	public <T extends BasicDTO> BasicDTO observer(T entity) {
		
		MDC.put(Utils.MDC_REQUEST_ID, entity.getRequestId());
		LOGGER.info("Receiving message: {}",  entity);

		BasicService<BasicEntity, BasicRepository<BasicEntity>> service = serviceManager.getService(entity.getApiResource(), BasicService.class);
		return service.execute(entity);
	}
}
