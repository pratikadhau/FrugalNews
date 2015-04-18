package com.news.frugal.news.importer;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.springframework.stereotype.Component;

import com.news.frugal.dao.entity.News;

@Component
public class ODSImporter implements NewsImporter {

	@Override
	public List<News> importNews(File file){
		List<News> newsList = new ArrayList<News>();
			List<Row> firstSheet = getNewsSheet(file);
			for (Row row : firstSheet) {
				if (isHeaderRow(row)) {
					News news = getNews(row);
					newsList.add(news);
				}
			}

		return newsList;
	}

	private List<Row> getNewsSheet(File file)  {
		SpreadsheetDocument document = null;
		try {
			document = SpreadsheetDocument.loadDocument(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Row> firstSheet = getFirstSheet(document);
		return firstSheet;
	}

	private List<Row> getFirstSheet(SpreadsheetDocument document) {
		return document.getSheetByIndex(0).getRowList();
	}

	private boolean isHeaderRow(Row row) {
		return row.getPreviousRow() != null;
	}

	private News getNews(Row row) {
		News news = new News();
		news.setHeadline(row.getCellByIndex(0).getDisplayText());
		news.setNewsDetail(row.getCellByIndex(1).getDisplayText());
		try {
			news.setReportDate(dateFormat.parse(row.getCellByIndex(2).getDisplayText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			news.setDisplayDate(dateFormat.parse(row.getCellByIndex(3).getDisplayText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		news.setNewsType(row.getCellByIndex(4).getDisplayText());
		news.setReporterName(row.getCellByIndex(5).getDisplayText());
		news.setReporterEmailId(row.getCellByIndex(6).getDisplayText());
		return news;
	}

}
