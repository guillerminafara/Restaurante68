/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AcessoADatos.MesaData;
import AcessoADatos.PedidoData;
import AcessoADatos.PedidoProductoData;
import AcessoADatos.ProductoData;
import Entidades.Mesa;
import Entidades.Pedido;
import Entidades.PedidoProducto;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zona
 */
public class VentanaCalculos extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaCalculos
     */
    private DefaultTableModel modelo = new DefaultTableModel();//Importación del DefaultTableModel

    public VentanaCalculos() {
        initComponents();
        cargarCabecera();
        cargarCombo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JTFTotal = new javax.swing.JTextField();
        JBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JCBMesa = new javax.swing.JComboBox();
        JBCalcular = new javax.swing.JButton();

        jLabel3.setText("Total a Pagar:");

        JTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(JTabla);

        jLabel6.setText("Carro de compras:");

        JTFTotal.setEditable(false);

        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la mesa:");

        JCBMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mesa" }));
        JCBMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBMesaActionPerformed(evt);
            }
        });

        JBCalcular.setText("Calcular");
        JBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(JCBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 72, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalir)
                    .addComponent(JTFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JBCalcular))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JCBMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBMesaActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        cargarTabla();
        JTFTotal.setText("");

    }//GEN-LAST:event_JCBMesaActionPerformed

    private void JBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCalcularActionPerformed
        // TODO add your handling code here:
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        Producto producto = new Producto();
        ProductoData productoData = new ProductoData();
        PedidoProducto pp = new PedidoProducto();
        PedidoProductoData ppd = new PedidoProductoData();
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        List<Pedido> pedidoList = new ArrayList<>();
        //productoData.buscarProductoPorNombre(title);
        double precioTotal = 0;
        double subtotal=0;
        List<PedidoProducto> ppList = new ArrayList<>();
        if (JCBMesa.getSelectedIndex() != 0) {
            JCBMesa.getSelectedItem();
            mesa = mesaData.buscarMesaPorId(Integer.parseInt(JCBMesa.getSelectedItem().toString()));
            pedidoList = pedidoData.listarPedidosPorMesa(mesa.getIdMesa());
            for (Pedido pList : pedidoList) {
                ppList = ppd.buscarXPedido(pList.getIdPedido());
                for (PedidoProducto listPP : ppList) {
                    producto = productoData.buscarProducto(listPP.getIdProducto());
                    subtotal=producto.getPrecio()*listPP.getCantidad();
                    precioTotal+=subtotal; //listPP.getCantidad();
                }
            }
           JTFTotal.setText(Double.toString(precioTotal));
        }


    }//GEN-LAST:event_JBCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCalcular;
    private javax.swing.JButton JBSalir;
    private javax.swing.JComboBox JCBMesa;
    private javax.swing.JTextField JTFTotal;
    private javax.swing.JTable JTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla

        modelo.addColumn("Productos");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("SubTotal");

        JTabla.setModel(modelo);
    }

    private void cargarCombo() {
        List<Mesa> listaMesa = new ArrayList<>();
        MesaData mesaData = new MesaData();
        listaMesa = mesaData.listarMesa();
        for (Mesa mesaList : listaMesa) {
            JCBMesa.addItem(mesaList);
        }
    }

    private void cargarTabla() {
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        Producto producto = new Producto();
        ProductoData productoData = new ProductoData();
        PedidoProducto pp = new PedidoProducto();
        PedidoProductoData ppd = new PedidoProductoData();
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        List<Pedido> pedidoList = new ArrayList<>();
        //productoData.buscarProductoPorNombre(title);

        List<PedidoProducto> ppList = new ArrayList<>();
        if (JCBMesa.getSelectedIndex() != 0) {
            JCBMesa.getSelectedItem();
            mesa = mesaData.buscarMesaPorId(Integer.parseInt(JCBMesa.getSelectedItem().toString()));
            pedidoList = pedidoData.listarPedidosPorMesa(mesa.getIdMesa());
            for (Pedido pList : pedidoList) {
                ppList = ppd.buscarXPedido(pList.getIdPedido());
                for (PedidoProducto listPP : ppList) {
                    producto = productoData.buscarProducto(listPP.getIdProducto());
                    modelo.addRow(new Object[]{producto.getNombre(), listPP.getCantidad(), producto.getPrecio(), (producto.getPrecio() * listPP.getCantidad())});
                    //listPP.getCantidad();
                }
            }

        }

    }

}
