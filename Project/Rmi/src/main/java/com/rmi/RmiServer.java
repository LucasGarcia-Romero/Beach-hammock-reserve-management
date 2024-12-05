package com.rmi;

import java.net.*;
import java.rmi.*;


//@WebService(targetNamespace = "http://student.com/", portName = "RmiServerPort", serviceName = "RmiServerService")

public class RmiServer {

	public static void main(String args[]) {
		//if (System.getSecurityManager() == null)
			//System.setSecurityManager(new RMISecurityManager());
		try {
			String url = "//localhost:1099/AddServerIntf";
			Naming.rebind(url, new AddServerImpl());
			System.out.println("server is running...");
		}
		catch (Exception e) {
			System.out.println("Server failed:" + e.getMessage());
		}
	}

}
