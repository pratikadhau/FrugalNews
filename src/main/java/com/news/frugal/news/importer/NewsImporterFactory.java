package com.news.frugal.news.importer;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsImporterFactory {
	@Autowired
	private ODSImporter odsImporter;
	
	@Autowired
	private XLSXImporter xlssImporter;
	
	public NewsImporter getNewsImporte(String fileFormat){
		switch (fileFormat) {
		case "ods":
			return odsImporter;
		case "xlsx":
			return xlssImporter;
		default:
			throw new RuntimeException();
		}
	}

}
