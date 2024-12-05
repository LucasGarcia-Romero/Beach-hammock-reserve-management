package com.rmi;

import java.util.Arrays;

public class Sombrilla {
	private String playa;
    private int numSombrilla;
    private int[] estado;
    private int capacidad;

    public Sombrilla(String line) {
        // Separo la línea del archivo en sus componentes
        String[] parts = line.split(";");
        //hay un total de 4 partes
        // Asigno los valores a los atributos de la sombrilla
        this.playa = (parts[0].split(": "))[1];
        this.numSombrilla = Integer.parseInt((parts[1].split(": "))[1]);
        this.capacidad = Integer.parseInt((parts[3].split(": "))[1]);
        //para guardar la capacidad esta en [0,0,0,0,0,0,0,0,0,0,0,0], por ende he de quitar las [ ]
        parts[2]=parts[2].split(": ")[1];
        parts[2]=parts[2].substring(1, parts[2].length() - 1);
        String[] temp =(parts[2].split(", "));
        this.estado=new int[temp.length];
        for(int i=0; i<temp.length; i++) {
        	this.estado[i]=Integer.parseInt(temp[i]);
        }
    }

    
    
    @Override
	public String toString() {
		return "playa: " + playa + "; sombrilla: " + numSombrilla + "; estado: " + Arrays.toString(estado) + "; tam: " + capacidad;
	}



	// Métodos getters y setters
    public String getPlaya() {
    	return playa;
    }
    
    public String setPlaya(String playa) {
    	return this.playa=playa;
    }
    public int getNumero() {
        return numSombrilla;
    }

    public void setNumero(int numSombrilla) {
        this.numSombrilla = numSombrilla;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int[] getEstado() {
        return estado;
    }

    public void setEstado(int[] estado) {
        this.estado = estado;
    }

    // Métodos adicionales

    public boolean estaLibre() {
        for (int estado : this.estado) {
            if (estado == 0) {
                return true;
            }
        }
        return false;
    }
}