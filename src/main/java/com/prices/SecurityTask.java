package com.prices;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityTask implements Runnable{
	public static Logger logger = LoggerFactory.getLogger(SecurityTask.class);

	private String currentLine;
	private static Security security;
	
	public SecurityTask(String currentLine) {
		super();
		this.currentLine = currentLine;
	}

	@Override
	public void run(){
		logger.debug("Received line  = " + currentLine);
		if (!StringUtils.isEmpty(currentLine)){
			currentLine = currentLine.trim();
			if (FileProcessor.END_OF_FILE.equals(currentLine)){
				System.out.println(security);
				return;
			}
			else if (currentLine.length()==8 && StringUtils.isAlphanumeric(currentLine)) {
				//we got new security
				if (security!=null) System.out.println(security);
				security = new Security(currentLine);
			}
			else {
				try {
					BigDecimal price = new BigDecimal(currentLine);
					security.setPrice(price);
				}
				catch (Exception e){					
				}
			}
		}
	}
}
