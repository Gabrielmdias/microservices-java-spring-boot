package com.wit.subscriptionfacade.filter.resoruce;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;


public class RequestWrapper extends HttpServletRequestWrapper {

	private final byte[] body;

	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);

		this.body = StreamUtils.copyToByteArray(request.getInputStream());
	}

	@Override
	public ServletInputStream getInputStream() {
		return new ServletInputStreamWrapper(this.body);
	}

}