package com.client;

/*import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;*/
import java.util.Scanner;

// CXF REST Client Invoking POST Method

public class MenuClient {

  public static void main(String[] args) {
	  
	  Scanner scan = new Scanner(System.in);
	  
	  int option = 0;
	  while(option!=5) {
		  String user = "";
		  System.out.println("Bienvenido al menú de sombrillas\n¿Qué desea hacer? \n1. Reservar sombrilla\n2. Listar sombrillas\n3.Cancelar sombrilla\n4.Crear usuario\n5.Salir\n");
		  option = scan.nextInt();
		  switch(option){
		  //Reserve
		  case 1:
			  System.out.println("User id:\n");
			  user = scan.next();
			  System.out.println("Beach:\n");
			  user = user + "-" + scan.next();
			  System.out.println("Hour:\n");
			  user = user + "-" + scan.next();
			  System.out.println("People:\n");
			  user = user + "-" + scan.next();
			  System.out.println(user);
			  //Conectamos a post
			  PostConn.connection("http://localhost:8080/ServerProject/rest/addReserve", user);
			  break;
			  
			//Cancelar  
		  case 2:
			  System.out.println("User id:\n");
			  user = scan.next();
			  System.out.println("Beach:\n");
			  user = user + "-" + scan.next();
			  System.out.println("Hour:\n");
			  user = user + "-" + scan.next();
			  PostConn.connection("http://localhost:8080/ServerProject/rest/cancelReserve", user);
			  break;
			  
			  //Enseñar
		  case 3:
			  System.out.println("Beach:\n");
			  user = scan.next();
			  PostConn.connection("http://localhost:8080/ServerProject/rest/showList", user);
			  break;
			  
			  //Añadir usuario
		  case 4:
			  System.out.println("Introduzca su nuevo nombre de usuario:\n");
			  user = scan.next();
			  PostConn.connection("http://localhost:8080/ServerProject/rest/addUser", user);
			  break;
			  
			  //Exit
		  case 5:
			  System.out.println("Adiós!\n");
			  break;
			  
		  default:
			  System.out.println("Entrada incorrecta.\n");
			  break;
			  
		  }
		  
	  }
	 
	  scan.close();
  }
   
}