package com.prices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	@Test
	public void testApplicationCreatesFile(){
		try {
	    	PrintStream fileOut = new PrintStream("cusip_out.txt");
	    	System.setOut(fileOut);
	    	ExecutorService executor =  Executors.newSingleThreadExecutor();
	    	FileProcessor fp = new FileProcessor("cusip.txt", executor);
	    	Thread t = new Thread(fp);
	    	t.start();
	    	executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
	    	File checkOutFile = new File("cusip_out.txt");
	    	Assert.assertTrue(checkOutFile.exists());
		}
		catch (Exception e){			
		}
	}
	
	@Test (dependsOnMethods={"testApplicationCreatesFile"})
	public void testApplicationCreatedFileWithFourLines(){
	    try (BufferedReader br = new BufferedReader(new FileReader("cusip_out.txt"))) {
	    	String currentLine;
	    	int lineCount = 0 ;
			while ((currentLine = br.readLine()) != null) {
				lineCount++;
			}
			Assert.assertTrue(lineCount == 4);
	    }
	    catch (Exception e){
	    	
	    }		
	}

}
