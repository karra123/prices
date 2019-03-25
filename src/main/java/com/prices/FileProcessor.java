package com.prices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileProcessor implements Runnable {
	public static Logger logger = LoggerFactory.getLogger(FileProcessor.class);
	public static String END_OF_FILE = "FILE_EOF";
	
	private String fileName;
	private ExecutorService executor;

	public FileProcessor(String fileName, ExecutorService executor) {
		super();
		this.fileName = fileName;
		this.executor = executor;
	}
	
	@Override
	public void run(){
	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	    	String currentLine;
			while ((currentLine = br.readLine()) != null) {
				logger.debug("Line read = " + currentLine);
				SecurityTask st = new SecurityTask(currentLine);
				executor.execute(st);
			}
			SecurityTask st = new SecurityTask(END_OF_FILE);
			executor.execute(st);
			executor.shutdown();
	    }
	    catch (Exception e){
	    	
	    }
		
	}

}
