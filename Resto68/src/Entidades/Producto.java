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
public class Producto {
   int idProducto;
    String tipoDeProducto;
    String nombre;
    int Stock;
    double precio;
    boolean estado;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String tipoDeProducto, int Stock, double precio, boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipoDeProducto = tipoDeProducto;
        this.Stock = Stock;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(String nombre, String tipoDeProducto, int Stock, double precio, boolean estado) {
        this.nombre = nombre;
        this.tipoDeProducto = tipoDeProducto;

        this.Stock = Stock;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", tipoDeProducto=" + tipoDeProducto + ", nombre=" + nombre + ", Stock=" + Stock + ", precio=" + precio + ", estado=" + estado + '}';
    }  
}
