package com.prices;

import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String inFileName;
	private static String outFileName;
	private static ExecutorService  executor;
    public static void main( String[] args )
    {
    	if (!checkArgs(args)) {
    		printUsage();
    		return;
    	}
    	try {
	    	PrintStream fileOut = new PrintStream(outFileName);
	    	System.setOut(fileOut);
	    	executor =  Executors.newSingleThreadExecutor();
	    	FileProcessor fp = new FileProcessor(inFileName, executor);
	    	Thread t = new Thread(fp);
	    	t.start();
    	}
    	catch (Exception e){
    		
    	}
    }
    
    public static boolean checkArgs(String[] args){
    	if (args==null || args.length!=2){
    		return false;
    	}
    	else {
    		inFileName = args[0];
    		outFileName = args[1];
    		return true;
    	}
    }
    
    public static void printUsage(){
    	System.out.println("Usage : java -jar prices.jar <InFileName> <OutFileName>");
    }
}
