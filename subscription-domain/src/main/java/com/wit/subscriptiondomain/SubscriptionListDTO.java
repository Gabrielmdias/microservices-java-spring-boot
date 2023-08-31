package com.wit.subscriptiondomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class SubscriptionListDTO extends BasicDTO {
	private static final long serialVersionUID = 1L;

	public static final String SUBSCRIPTION_LIST = "SUBSCRIPTION_LIST";
	
	private List<SubscriptionDTO> subscriptionsDto;

	public List<SubscriptionDTO> getSubscriptionsDto() {
		return subscriptionsDto;
	}

	public void setSubscriptionsDto(List<SubscriptionDTO> subscriptionsDto) {
		this.subscriptionsDto = subscriptionsDto;
	}

	@Override
	public Operation getOperation() {
		return Operation.FIND_ALL;
	}

	@JsonIgnore
	@Override
	public String getApiResource() {
		return SUBSCRIPTION_LIST;
	}

	@Override
	public String toString() {
		return "SubscriptionListDTO{" +
				"subscriptionsDto=" + subscriptionsDto +
				'}';
	}
}
