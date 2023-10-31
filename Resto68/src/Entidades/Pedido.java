/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Fran-PC
 */
public class Pedido {
    int idPedido;
    int idMesa;
    String NombreMesero;
    LocalDateTime fechaHora;
    double importe;
    boolean cobrada;

    public Pedido() {
    }

    public Pedido(int idMesa, String NombreMesero, LocalDateTime fechaHora, double importe, boolean cobrada) {
        this.idMesa = idMesa;
        this.NombreMesero = NombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public Pedido(int idPedido, int idMesa, String NombreMesero, LocalDateTime fechaHora, double importe, boolean cobrada) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.NombreMesero = NombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombreMesero() {
        return NombreMesero;
    }

    public void setNombreMesero(String NombreMesero) {
        this.NombreMesero = NombreMesero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isCobrada() {
        return cobrada;
    }

    public void setCobrada(boolean cobrada) {
        this.cobrada = cobrada;
    }

    @Override
    public String toString() {
        return  NombreMesero;
    }
    
}
