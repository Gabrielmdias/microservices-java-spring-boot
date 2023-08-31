package com.wit.subscriptiondb.service;

import com.wit.subscriptiondb.domain.BasicEntity;
import com.wit.subscriptiondb.repository.BasicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceManager {
	private static final Logger LOG = LoggerFactory.getLogger(ServiceManager.class);

	private final ApplicationContext applicationContext;

	public ServiceManager(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public <T extends BasicService<BasicEntity, BasicRepository<BasicEntity>>> T getService(String syncApiResource, Class<T> targetClass) {
		T service;

		try {
			service = applicationContext.getBean(syncApiResource, targetClass);
		} catch (Exception ex) {
			LOG.error("An error occurred while trying to find a service for {}.", syncApiResource);
			throw ex;
		}
		LOG.debug("Request type: {} - service found: {}", syncApiResource, service.getClass().getName());

		return service;
	}
}
