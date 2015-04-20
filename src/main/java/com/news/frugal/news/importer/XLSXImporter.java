package com.news.frugal.news.importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.news.frugal.dao.entity.News;

@Component
public class XLSXImporter implements NewsImporter{

	@Override
	public List<News> importNews(File file) {
		List<News> importedNews = new ArrayList<News>();
		try {
			Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
			Sheet firstSheet = workbook.getSheetAt(0);
			for (Row row : firstSheet) {
				if(row.getRowNum()==0){
					continue;
				}
				if(row.getCell(0)==null){
					break;
				}
				News news = new News();
				news.setHeadline(row.getCell(0).getStringCellValue());
				news.setNewsDetail(row.getCell(1).getStringCellValue());
				news.setReportDate(dateFormat.parse(row.getCell(2).getStringCellValue()));
				news.setDisplayDate(dateFormat.parse(row.getCell(3).getStringCellValue()));
				news.setNewsType(row.getCell(4).getStringCellValue());
				news.setReporterName(row.getCell(5).getStringCellValue());
				news.setReporterEmailId(row.getCell(6).getStringCellValue());
				importedNews.add(news);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} catch (ParseException e) {
			throw new RuntimeException();
		}
		return importedNews;
	}

}
