package com.student;
import java.rmi.*;

import javax.jws.WebService;

@WebService(name = "AddServerIntf", targetNamespace = "http://student.com/")
public interface AddServerIntf extends Remote{
	//reserve, cancel and show RMI
	public void reserve(String beach, int hour, int people, int idUser) throws RemoteException;
	public void cancel(String beach, int idSombrilla, int idUser) throws RemoteException;
	public void show(String beach) throws RemoteException;

}
