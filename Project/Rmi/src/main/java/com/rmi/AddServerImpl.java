package com.rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{ 

	public AddServerImpl() throws RemoteException {
	}
	
	
	public void reserve(String playa, int hora, int numPersonas, int idCliente) throws Exception {
	    // Obtengo la lista de sombrillas de la playa indicada
	    List<Sombrilla> sombrillas = obtenerSombrillas(playa);
	    	   
	    // Busco la primera sombrilla vacía que tenga capacidad para el número de personas indicado
	    for (Sombrilla sombrilla : sombrillas) {
	        if (sombrilla.getEstado()[hora-8] == 0 && sombrilla.getCapacidad() >= numPersonas) {
	            // Si la encuentro, reservo la sombrilla para el cliente indicado
	        	System.out.println("reservando la sombrilla: " + playa +sombrilla.getNumero());
	            sombrilla.getEstado()[hora-8] = idCliente;
	            break;
	        }
	    }

	    File file = new File("reservas.txt");
	    FileWriter writer = new FileWriter(file);

	    for (Sombrilla sombrilla : sombrillas) {
	      writer.write(sombrilla.toString() + "\n");
	    }

	    writer.close();
	}
	
	//cancelar reserva
	public void cancel(String playa, int idSombrilla, int idCliente) throws Exception {
	    // Obtengo la lista de sombrillas de la playa indicada
	    List<Sombrilla> sombrillas = obtenerSombrillas(playa);

	    // Busco la sombrilla indicada
	    for (Sombrilla sombrilla : sombrillas) {
	        if (sombrilla.getNumero() == idSombrilla /*&& Arrays.contains(sombrilla.getEstado(), idCliente)*/) {
	        	for(int i=0; i<sombrilla.getEstado().length; i++) {
	        		if(sombrilla.getEstado()[i]==idCliente) {
	        			//esa es la posicion a borrar
	        			sombrilla.getEstado()[i]=0;
		        		break;

	        		}
	        	}
	            // Si la encuentro, cancelo la reserva
	            break;
	        }
	    }
	    
	    File file = new File("reservas.txt");
	    FileWriter writer = new FileWriter(file);

	    for (Sombrilla sombrilla : sombrillas) {
	      writer.write(sombrilla.toString() + "\n");
	    }

	    writer.close();

	}
	
	//listar sombrillas
	public void show(String playa) throws Exception {
	    // Obtengo la lista de sombrillas de la playa indicada
	    List<Sombrilla> sombrillas = obtenerSombrillas(playa);

	    // Imprimo las sombrillas que no están completamente reservadas
	    for (Sombrilla sombrilla : sombrillas) {
	        if (sombrilla.estaLibre() && sombrilla.getPlaya()==playa) {
	            System.out.println("Sombrilla " + sombrilla.getPlaya() + sombrilla.getNumero());
	            for (int i=0; i< sombrilla.getEstado().length; i++) {
	                if ((sombrilla.getEstado())[i] == 0) {
	                    System.out.println("libre a las: " + (i+8));
	                }
	            }
	        }
	    }
	}
	
	//obtener sombrilla
		private List<Sombrilla> obtenerSombrillas(String playa) throws Exception {
		    // Obtengo el archivo de reservas
		    File file = new File("reservas.txt");

		    // Creo una lista de sombrillas vacía
		    List<Sombrilla> sombrillas = new ArrayList<>();

		    // Si el archivo existe, lo leo
		    if (file.exists()) {
		    	try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                // Creo una nueva sombrilla a partir de la línea del archivo
		                sombrillas.add(new Sombrilla(line));
		            }
		        } catch (IOException e) {
		            throw new RemoteException();
		        }
		    }
		    else{
		    	System.out.println("error leyendo fichero");
		    }

		    // Devuelve la lista de sombrillas
		    return sombrillas;
		}

	}



