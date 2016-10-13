package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IOEx1 {
	public static void main(String[] args) throws IOException {
		String msg = "æ»≥Á«œººø‰?";
		
		// write to file
		FileOutputStream fos = new FileOutputStream("data.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		PrintWriter pw = new PrintWriter(osw);
		pw.println(msg);
		
		pw.close();
		
		// read from file
		FileInputStream fis = new FileInputStream("data.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr); //  improve to better performance
		
		String line;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		
	}
}
