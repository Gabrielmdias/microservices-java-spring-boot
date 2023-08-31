package com.wit.subscriptiondb.service;

import com.wit.subscriptiondb.domain.Subscription;
import com.wit.subscriptiondb.repository.SubscriptionRepository;
import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.SubscriptionDTO;
import com.wit.subscriptiondomain.SubscriptionListDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service(SubscriptionDTO.SUBSCRIPTION)
@Transactional
public class SubscriptionService extends BasicService<Subscription, SubscriptionRepository> {

	public SubscriptionService(SubscriptionRepository repository) {
		super(repository);
	}

	@Override
	public Subscription getEntity(BasicDTO dto) {
		return this.mapper.map(dto, Subscription.class);
	}

	@Override
	public SubscriptionDTO getDTO(Subscription entity) {
		return this.mapper.map(entity, SubscriptionDTO.class);
	}

	@Override
	public SubscriptionListDTO getListDTO(List<Subscription> entityList) {
		SubscriptionListDTO subscriptions = new SubscriptionListDTO();
		subscriptions.setSubscriptionsDto(entityList.stream().map(this::getDTO).collect(Collectors.toList()));
		return subscriptions;
	}
}
