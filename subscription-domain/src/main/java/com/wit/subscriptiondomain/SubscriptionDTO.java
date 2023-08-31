package com.wit.subscriptiondomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.UUID;

public class SubscriptionDTO extends BasicDTO {
	private static final long serialVersionUID = 1L;
	public static final String SUBSCRIPTION = "SUBSCRIPTION";

	private Integer packageId;
	private Date dataSubscription;
	private UUID userId;

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Date getDataSubscription() {
		return dataSubscription;
	}

	public void setDataSubscription(Date dataSubscription) {
		this.dataSubscription = dataSubscription;
	}

	@JsonIgnore
	@Override
	public String getApiResource() {
		return SUBSCRIPTION;
	}

	@Override
	public String toString() {
		return "SubscriptionDTO{" +
				"packageId=" + packageId +
				", dataSubscription=" + dataSubscription +
				", userId=" + userId +
				'}';
	}
}
