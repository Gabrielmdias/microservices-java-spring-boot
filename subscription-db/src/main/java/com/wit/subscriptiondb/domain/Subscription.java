package com.wit.subscriptiondb.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription extends BasicEntity {
	private static final long serialVersionUID = 1L;

	private Integer packageId;
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_SUBSCRIPTION", updatable = false, nullable = false)
    private Date dataSubscription;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private User user;
	
	public Subscription() {}
	
	public Integer getPackageId() {
		return packageId;
	}
	
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDataSubscription() {
		return dataSubscription;
	}

	public void setDataSubscription(Date dataSubscription) {
		this.dataSubscription = dataSubscription;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + "]";
	}

}
