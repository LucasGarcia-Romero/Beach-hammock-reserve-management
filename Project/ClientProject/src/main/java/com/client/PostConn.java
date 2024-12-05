package com.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PostConn {
	
	public static void connection(String url1, String txt) {
		
		 try {

		      URL url = new URL(url1);
		      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      conn.setDoOutput(true); //if you want to send a request body - usually POST or PUT
		      conn.setRequestMethod("POST");
		      conn.setRequestProperty("Content-Type", "application/json");

		      OutputStream os = conn.getOutputStream();
		      os.write(txt.getBytes());
		      os.flush();

		      Scanner scanner;
		      String response;
		      if (conn.getResponseCode() != 200) {
		        scanner = new Scanner(conn.getErrorStream());
		        response = "Error From Server \n\n";
		      } else {
		        scanner = new Scanner(conn.getInputStream());
		        response = "Response From Server \n\n";
		      }
		      scanner.useDelimiter("\\Z");
		      System.out.println(response + scanner.next());
		      scanner.close();
		      conn.disconnect();
		    } catch (MalformedURLException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
	}
	
	
	

