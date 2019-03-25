CUSIP Problem
	The following assumptions are made.

		1) CUSIP is 8 characters long. The current industry standard in 8, since it is mentioned in the problem definition, going with 8.

		2) Either CUSIP or Price per line. Only one of these per line.

		3) The data is in time ascending order.

		4) Each CUSIP only appears once in the file.

		5) There is no requirement to store all the CUSIPs and all the prices.

		6) Only requirement is to print the latest price of each CUSIP present in the file.

		7) The program outputs to file, but can be easily changed to write to console, by just commenting couple of lines code. This is done for faster 
			processing and facilitate adding test cases.

	To Build and run the program.

		1) This is a maven project, using Java 8.

		2) Build it as follows:
			mvn clean install

		3) Run the program as follows: (Usage : java -jar prices.jar <InFileName> <OutFileName>)
			java -jar  prices-1.0-SNAPSHOT.jar cusip.txt out.txt

		4) A sample "cusip.txt" file is included for testing the program as part of maven build. The build out to a file "cusip_out.txt".

		