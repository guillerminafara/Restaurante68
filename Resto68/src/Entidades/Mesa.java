/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Fran-PC
 */
public class Mesa {
  int idMesa;
    int numero;
    boolean estadoDeMesa;
    int capacidad;

    public Mesa() {
    }

    public Mesa(int numero, boolean estadoDeMesa, int capacidad) {
        this.numero = numero;
        this.estadoDeMesa = estadoDeMesa;
        this.capacidad = capacidad;
    }

    public Mesa(int idMesa, int numero, boolean estadoDeMesa, int capacidad) {
        this.idMesa = idMesa;
        this.numero = numero;
        this.estadoDeMesa = estadoDeMesa;
        this.capacidad = capacidad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstadoDeMesa() {
        return estadoDeMesa;
    }

    public void setEstadoDeMesa(boolean estadoDeMesa) {
        this.estadoDeMesa = estadoDeMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return ""+numero ;
    }  
}
