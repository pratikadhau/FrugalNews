package com.news.frugal.commom.pojo;

public class NewsServiceRequest<Req> {
	private Req request;

	public Req getRequest() {
		return request;
	}

	public void setRequest(Req request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "NewsServiceRequest [request=" + request + "]";
	}
}
