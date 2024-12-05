package com.student;

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService(targetNamespace = "http://student.com/", portName = "ChangeStudentDetailsImplPort", serviceName = "ChangeStudentDetailsImplService")
@Consumes("application/json")
@Produces("application/json")

public class ChangeStudentDetailsImpl implements ChangeStudentDetails {
	
	//Array users
	private List<User> users = new ArrayList<User>();
	private static int pos = 0;
	
	//Ver si el usuario ha sign in
	public Boolean autentificar(int idUser) {
		  Boolean res = false;
		  if (pos > 0) {
			  for (int i = 0; i<= pos; i++) {
				  if (idUser == users.get(i).getId())
					  res = true;
				  break;
			  }
		  }
		  return res;
	  }
  
	//Add user
	  @POST
	  @Path("/addUser")
	  public String addUser(String name) {
		  User user = new User();
		  user.setName(name);
		  pos++;
		  user.setId(pos);
		  users.add(user);
		  return "Bienvenid@ " + users.get(pos-1).getName() + ", tu nuevo id es: " + String.valueOf(users.get(pos-1).getId());
	  }
  
	  //Add reserve
	  @POST
	  @Path("/addReserve")
	  public String addReserve(String info) {
		  String res = "";
		  //Separar informaciom
		  String[] infoSep = info.split("-",  4);
		  //usuarioId, playa, hora, n personas
		  String user = infoSep[0];
		  String beach = infoSep[1];
		  String hour = infoSep[2];
		  String nPeople = infoSep[3];
		  //autentificamos si el usuario está en el array
		  if(this.autentificar(Integer.parseInt(user)) == true) {
			  res = "user in";
			  //Nos conectamos a RMI
			 try {
					String url = "//localhost:1099/AddServerImpl";
					System.out.println("looking up " + url);
					AddServerIntf sample = (AddServerIntf)Naming.lookup(url);
					//AddServerIntf sample = (AddServerIntf)Naming.lookup("RmiServer");
					// call the remote method reserve and save the return
					sample.reserve(beach, Integer.parseInt(hour), Integer.parseInt(nPeople), Integer.parseInt(user));
					System.out.println(res);
					
				} catch(Exception e) {
					System.out.println("catch");
					res = "Rmi exception: " + e;
				}
		  }else {
			  res = "user not signed in";
		  }
		  
		  return res;
		  
	  }
	  
	  //Show reserves
	  @GET
	  @Path("/showList")
	  public String showList(String beach) {
		  String res = "";
		  try {
				String url = "//localhost:1099/AddServerImpl";
				System.out.println("looking up " + url);
				AddServerIntf sample = (AddServerIntf)Naming.lookup(url);
				//AddServerIntf sample = (AddServerIntf)Naming.lookup("RmiServer");
				// call the remote method and print the return
				sample.show(beach);
				System.out.println(res);
				
			} catch(Exception e) {
				System.out.println("catch");
				res = "Rmi exception: " + e;
			}
	    return "show list";
	  }
  
	  //Cancel reserve by id
	  @POST
	  @Path("/cancelReserve")
	  public String cancelReserve(String info) {
		  //Separamos info
		  String[] infoSep = info.split("-",  3);
		  //Pasamos a int
		  String beach = infoSep[0];
		  int sombrillaId = Integer.parseInt(infoSep[1]);
		  int userId = Integer.parseInt(infoSep[2]);
		  String res = "";
		  //Conectamos a RMI
		  try {
			  System.out.println("try\n");
				String url = "//localhost:1099/AddServerImpl";
				System.out.println("looking up " + url);
				AddServerIntf sample = (AddServerIntf)Naming.lookup(url);
				//AddServerIntf sample = (AddServerIntf)Naming.lookup("RmiServer");
				// call the remote method and print the return
				sample.cancel(beach, sombrillaId, userId);
				System.out.println(res);
				
			} catch(Exception e) {
				System.out.println("catch");
				res = "Rmi exception: " + e;
			}

		  return res;
		  
	  }
}