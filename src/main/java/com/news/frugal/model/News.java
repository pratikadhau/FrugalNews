package com.news.frugal.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.news.frugal.json.serializer.CustomDateSerializer;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class News {
	private String headline;
	private String newsDetail;
	private Date reportDate;
	private Date displayDate;
	private String newsType;
	private String reporterName;
	private String reporterEmailId;

	public String getNewsDetail() {
		return newsDetail;
	}

	public void setNewsDetail(String newsDetail) {
		this.newsDetail = newsDetail;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getHeadline() {
		return headline;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getReporterEmailId() {
		return reporterEmailId;
	}

	public void setReporterEmailId(String reporterEmailId) {
		this.reporterEmailId = reporterEmailId;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	
}
