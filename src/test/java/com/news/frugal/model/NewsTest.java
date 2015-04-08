package com.news.frugal.model;

import junit.framework.Assert;

import org.junit.Test;

public class NewsTest {

	@Test
	public void newsShouldHaveHeadline() throws Exception {
		News news = new News();
		String headline = "headline";
		news.setHeadline(headline);
		Assert.assertEquals(news.getHeadline(), headline);
	}
}
