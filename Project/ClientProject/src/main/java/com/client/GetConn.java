package com.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//No se llega a usar pero lo dejamos para que veamos cómo se implementaría
// CXF JAX-RS client Invoking GET Method

public class GetConn {

	public static void connection(String url1) {
    try {
    	URL url = new URL(url1);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-Type", "application/json");
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