package edu.ap.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Quote {
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	private String allQuotes = readFile (oscar_wilde.txt);
	String lines[] = allQuotes.split("\\r?\\n");
	
	public String getAllQuotes () {
		return allQuotes;
	}
	
	public String getQuoteWithText (String text) {
		forearch (String s in lines) {
			if (s.toLowerCase ().contains (text.toLowerCase ()) {
				return s;
			}
		}
	}
}
