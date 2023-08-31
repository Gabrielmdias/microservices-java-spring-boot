package com.wit.subscriptiondomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO extends BasicDTO {
    private static final long serialVersionUID = 1L;
    public static final String USER = "USER";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public String getApiResource() {
        return USER;
    }

	@Override
	public String toString() {
		return "UserDTO{" +
				"name='" + name + '\'' +
				'}';
	}
}
