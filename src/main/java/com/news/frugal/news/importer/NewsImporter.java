package com.news.frugal.news.importer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.news.frugal.dao.entity.News;

public interface NewsImporter {
	final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public List<News> importNews(File file);
}
