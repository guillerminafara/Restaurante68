/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto68;

import AcessoADatos.PedidoProductoData;
import Entidades.PedidoProducto;

/**
 *
 * @author Fran-PC
 */
public class Resto68 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PedidoProducto pedProd = new PedidoProducto(1, 1, 2);
        PedidoProductoData pedProdData = new PedidoProductoData();
        pedProdData.crearCarrito(pedProd);
    }
    
}
