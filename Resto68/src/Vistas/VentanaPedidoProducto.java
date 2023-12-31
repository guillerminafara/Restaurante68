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
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zona
 */
public class VentanaPedidoProducto extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();//Importación del DefaultTableModel

    public VentanaPedidoProducto() {
        initComponents();
        cargarCabecera();
        cargarCombo();
        cargarComboProd();
        // cargarComboMesa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFIdPed = new javax.swing.JTextField();
        JTFCantidad = new javax.swing.JTextField();
        JBAgregar = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBLimpiar = new javax.swing.JButton();
        JBBuscar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaPedProd = new javax.swing.JTable();
        JCBIdPedProd = new javax.swing.JComboBox();
        JCBProd = new javax.swing.JComboBox();
        JBBProducto = new javax.swing.JButton();
        JBBCantidad = new javax.swing.JButton();
        JBCarrito = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pedidos de Productos");

        jLabel2.setText("Id Carrito:");

        jLabel3.setText("Id pedido");

        jLabel4.setText("Productos: ");

        jLabel5.setText("Cantidad");

        JBAgregar.setText("Agregar");
        JBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAgregarActionPerformed(evt);
            }
        });

        JBModificar.setText("Modificar");
        JBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModificarActionPerformed(evt);
            }
        });

        JBLimpiar.setText("Limpiar");
        JBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarActionPerformed(evt);
            }
        });

        JBBuscar.setText("Buscar");
        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        JTablaPedProd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTablaPedProd);

        JCBIdPedProd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---" }));
        JCBIdPedProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIdPedProdActionPerformed(evt);
            }
        });

        JCBProd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---" }));
        JCBProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBProdActionPerformed(evt);
            }
        });

        JBBProducto.setText("Buscar");
        JBBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBProductoActionPerformed(evt);
            }
        });

        JBBCantidad.setText("Buscar");
        JBBCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBCantidadActionPerformed(evt);
            }
        });

        JBCarrito.setText("Buscar");
        JBCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCarritoActionPerformed(evt);
            }
        });

        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(JBAgregar)
                .addGap(14, 14, 14)
                .addComponent(JBModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(327, 327, 327))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JCBProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCBIdPedProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTFIdPed, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JBBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JBBProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JBBCantidad, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(JBCarrito))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBIdPedProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCarrito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFIdPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscar)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBProducto)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBCantidad)
                    .addComponent(jLabel5))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir)
                    .addComponent(JBLimpiar)
                    .addComponent(JBModificar)
                    .addComponent(JBAgregar)
                    .addComponent(JBEliminar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void JCBIdPedProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIdPedProdActionPerformed
        /*        // TODO add your handling code here:
   try {
            PedidoProducto pedProd = new PedidoProducto();
            pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            List<Producto> listaProd = new ArrayList<>();
            Producto prod = new Producto(); //varible prod de tipo(clase) Producto
            ProductoData prodData = new ProductoData(); // variable prodData de tipo ProductoData 
            //PedidoProducto pedProducto = new PedidoProducto();
            //pedProducto = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            listaProd = prodData.listarProductos(); // lista de Producto
            // int a = (int) JCBIdPedProd.getSelectedItem();
            if (!JCBIdPedProd.getSelectedItem().toString().equals("---") || !JCBIdPedProd.getSelectedItem().toString().equals("id Carrito")) {
                for (Producto listaP : listaProd) { //obtwngo productos
                    if (pedProd.getIdProducto() == listaP.getIdProducto()) {
                        System.out.println("Pipas");
                        JCBProd.setSelectedIndex(listaP.getIdProducto());

                    }
                }
            }
            modelo.setRowCount(0);
            PedidoProductoData pedProdData = new PedidoProductoData();  //varible  pedProdData de tipo(clase) PedidoProductoData
            // PedidoProducto pedProd = new PedidoProducto(); //varible pedProd de tipo(clase) PedidoProducto
            List<PedidoProducto> pedProdList = new ArrayList<>();
            pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();//varible pedProd de tipo(clase)PedidoProducto cargada con un item(String) seleccionado en un combobox y casteado a tipo PedidoProducto
            PedidoProducto pp = new PedidoProducto();
            pedProdList = pedProdData.obtenerCarritoXidPedProd(pedProd.getIdPedidoProducto());// lista cargada con una lista que devuelve objetos de tipo PedidoProducto por id
            for (PedidoProducto listaPP : pedProdList) {
                cargarTabla(listaPP);
            }
            JTFIdPed.setText(Integer.toString(pedProd.getIdPedido()));
            JTFCantidad.setText(Integer.toString(pedProd.getCantidad()));
            //JTFSubTotal.setText("");
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un carrito");
        }
        //if (pedProd != null) {
        // JCBProd.setSelectedItem(Integer.toString(pedProd.getIdProducto()).equals(prod.getIdProducto())); // 
        //  JCBProd.setSelectedItem(listaP.getIdProducto());
        //  System.out.println(JCBProd.getSelectedItem());
        //}*/

    }//GEN-LAST:event_JCBIdPedProdActionPerformed

    private void JCBProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBProdActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_JCBProdActionPerformed

    private void JBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAgregarActionPerformed
        // TODO add your handling code here:
        try {
            if (JTFIdPed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del pedido que desea agregar");
                return;
            }
            if (JTFCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cantidad de productos que desea agregar");
                return;
            }
            PedidoProductoData pedProdData = new PedidoProductoData();
            PedidoProducto pedProd = new PedidoProducto();

            Producto producto = new Producto();
            producto = (Producto) JCBProd.getSelectedItem();
            pedProd.setIdPedido(Integer.parseInt(JTFIdPed.getText()));

            pedProd.setIdProducto(producto.getIdProducto());

            pedProd.setCantidad(Integer.parseInt(JTFCantidad.getText()));

            pedProdData.crearCarrito(pedProd);
            Pedido pedido = new Pedido();
            PedidoData pedidoData = new PedidoData();
            pedido.setImporte(Integer.parseInt(JTFCantidad.getText()) * producto.getPrecio());
            pedidoData.modificarPedido(pedido);
            modelo.setRowCount(0);
            cargarTabla(pedProd);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_JBAgregarActionPerformed

    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed
        // TODO add your handling code here:

        try {
            if (JTFIdPed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del pedido que desea buscar");
                return;
            }
            modelo.setRowCount(0);
            PedidoProductoData pedProdData = new PedidoProductoData();
            PedidoProducto pedProd = new PedidoProducto();
            List<PedidoProducto> pedProdList = new ArrayList<>();
            pedProdList = pedProdData.buscarXPedido(Integer.parseInt(JTFIdPed.getText()));
            // pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            for (PedidoProducto pedList : pedProdList) {
                cargarTabla(pedList);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }

    }//GEN-LAST:event_JBBuscarActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        JTFIdPed.setText("");
        // JTFProducto.setText("");
        JTFCantidad.setText("");
        // JTFSubTotal.setText("");
        JCBIdPedProd.setSelectedIndex(0);
        //CBMesa.setSelectedIndex(0);


    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void JBBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBProductoActionPerformed
        // TODO add your handling code here:
        try {

            // if (JCBProd.getSelectedItem().toString().equals("---") || JCBProd.getSelectedItem().toString().equals("Productos")) {
            if (JCBProd.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un producto");
                return;
            }
            modelo.setRowCount(0);
            PedidoProductoData pedProdData = new PedidoProductoData();
            PedidoProducto pedProd = new PedidoProducto();
            List<PedidoProducto> pedProdList = new ArrayList<>();
            // pedProd = (PedidoProducto) JCBProd.getSelectedItem();
            Producto producto = new Producto();
            producto = (Producto) JCBProd.getSelectedItem();
            // pedProdList = pedProdData.buscarXProducto(producto.getIdProducto());
            //  JTFIdPed.setText(pedProd.getIdPedido());
            if (JTFIdPed.getText().isEmpty()) {
                //JOptionPane.showMessageDialog(this, "Ingrese el código del pedido que desea modificar");
                //return;
                pedProdList = pedProdData.buscarXProducto(producto.getIdProducto());
                for (PedidoProducto listaPP : pedProdList) {
                    cargarTabla(listaPP);
                }

            } else {
                int idPedido = Integer.parseInt(JTFIdPed.getText());
                pedProdList = pedProdData.buscarXProductoYPedido(producto.getIdProducto(), idPedido);
                for (PedidoProducto listaPP : pedProdList) {
                    cargarTabla(listaPP);
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }

        /*
        modelo.setRowCount(0);
        PedidoProductoData pedProdData = new PedidoProductoData();
        PedidoProducto pedProd = new PedidoProducto();
        List<PedidoProducto> pedProdList = new ArrayList<>();
        // pedProdList = pedProdData.buscarXProducto(Integer.parseInt(JTFProducto.getText()));
        for (PedidoProducto pedList : pedProdList) {
            cargarTabla(pedList);
        }
         */
    }//GEN-LAST:event_JBBProductoActionPerformed

    private void JBBCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBCantidadActionPerformed
        // TODO add your handling code here:
        try {
            if (JTFCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del producto que desea buscar");
                return;
            }
            modelo.setRowCount(0);
            PedidoProductoData pedProdData = new PedidoProductoData();
            PedidoProducto pedProd = new PedidoProducto();
            List<PedidoProducto> pedProdList = new ArrayList<>();
            pedProdList = pedProdData.buscarXCantidad(Integer.parseInt(JTFCantidad.getText()));
            for (PedidoProducto pedList : pedProdList) {
                cargarTabla(pedList);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_JBBCantidadActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (JTFIdPed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del pedido que desea modificar");
                return;
            }
            if (JTFCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cantidad del producto que desea modificar");
                return;
            }
            PedidoProductoData pedProdData = new PedidoProductoData();
            PedidoProducto pedProd = new PedidoProducto();

            PedidoProducto aux = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            Producto producto = (Producto) JCBProd.getSelectedItem();
            System.out.println("aux" + aux);
            pedProd.setIdPedidoProducto(aux.getIdPedidoProducto());
            pedProd.setIdPedido(Integer.parseInt(JTFIdPed.getText()));
            pedProd.setIdProducto(producto.getIdProducto());
            pedProd.setCantidad(Integer.parseInt(JTFCantidad.getText()));
            pedProdData.modificarPedProd(pedProd);
            modelo.setRowCount(0);
            cargarTabla(pedProd);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_JBModificarActionPerformed

    private void JBCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCarritoActionPerformed
        // TODO add your handling code here:
        try {
            PedidoProducto pedProd = new PedidoProducto();
            pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            List<Producto> listaProd = new ArrayList<>();
            Producto prod = new Producto(); //varible prod de tipo(clase) Producto
            ProductoData prodData = new ProductoData(); // variable prodData de tipo ProductoData
            //PedidoProducto pedProducto = new PedidoProducto();
            //pedProducto = (PedidoProducto) JCBIdPedProd.getSelectedItem();
            listaProd = prodData.listarProductos(); // lista de Producto
            // int a = (int) JCBIdPedProd.getSelectedItem();
            // if (!JCBIdPedProd.getSelectedItem().toString().equals("---") || !JCBIdPedProd.getSelectedItem().toString().equals("id Carrito")) {
            if (JCBIdPedProd.getSelectedIndex() != 0) {
                for (Producto listaP : listaProd) { //obtwngo productos
                    if (pedProd.getIdProducto() == listaP.getIdProducto()) {
                        //System.out.println("Pipas");
                        JCBProd.setSelectedIndex(listaP.getIdProducto());

                    }
                }
            }
            modelo.setRowCount(0);
            PedidoProductoData pedProdData = new PedidoProductoData();  //varible  pedProdData de tipo(clase) PedidoProductoData
            // PedidoProducto pedProd = new PedidoProducto(); //varible pedProd de tipo(clase) PedidoProducto
            List<PedidoProducto> pedProdList = new ArrayList<>();
            pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();//varible pedProd de tipo(clase)PedidoProducto cargada con un item(String) seleccionado en un combobox y casteado a tipo PedidoProducto
            PedidoProducto pp = new PedidoProducto();
            pedProdList = pedProdData.obtenerCarritoXidPedProd(pedProd.getIdPedidoProducto());// lista cargada con una lista que devuelve objetos de tipo PedidoProducto por id
            for (PedidoProducto listaPP : pedProdList) {
                cargarTabla(listaPP);
            }
            JTFIdPed.setText(Integer.toString(pedProd.getIdPedido()));
            JTFCantidad.setText(Integer.toString(pedProd.getCantidad()));
            //JTFSubTotal.setText("");
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un carrito");
        }
    }//GEN-LAST:event_JBCarritoActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        // TODO add your handling code here:
        PedidoProducto pedProd = new PedidoProducto();
        PedidoProductoData ppData= new PedidoProductoData();
        pedProd = (PedidoProducto) JCBIdPedProd.getSelectedItem();
        
        if (JCBIdPedProd.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el carrito que desea eliminar");
        }
        
       ppData.eliminar(pedProd);
       modelo.setRowCount(0);
       // System.out.println("pipas2:"+pedProd);

    }//GEN-LAST:event_JBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAgregar;
    private javax.swing.JButton JBBCantidad;
    private javax.swing.JButton JBBProducto;
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBCarrito;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JComboBox JCBIdPedProd;
    private javax.swing.JComboBox JCBProd;
    private javax.swing.JTextField JTFCantidad;
    private javax.swing.JTextField JTFIdPed;
    private javax.swing.JTable JTablaPedProd;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        List<PedidoProducto> listaPedProd = new ArrayList<>();
        //  PedidoProducto pedProd = new PedidoProducto();
        PedidoProductoData pedProdData = new PedidoProductoData();
        listaPedProd = pedProdData.obtenerCarrito();
        for (PedidoProducto listaPP : listaPedProd) {
            JCBIdPedProd.addItem(listaPP);
        }
    }

    private void cargarComboProd() {
        List<Producto> listaProd = new ArrayList<>();

        ProductoData ProdData = new ProductoData();
        listaProd = ProdData.listarProductos();
        for (Producto listaP : listaProd) {
            JCBProd.addItem(listaP);
        }
    }

    /*
    private void cargarComboMesa() {
        List<Mesa> listaMesa = new ArrayList<>();
        MesaData mesaData = new MesaData();
        listaMesa = mesaData.listarMesa();
        for (Mesa mesaList : listaMesa) {
            CBMesa.addItem(mesaList);
        }

    }*/
    private void cargarTabla(PedidoProducto pedidoProducto) {
        Producto producto = new Producto();
        ProductoData ProductoData = new ProductoData();
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        producto = ProductoData.buscarProducto(pedidoProducto.getIdProducto());
        pedido = pedidoData.buscarPedidoPorId(pedidoProducto.getIdPedido());
        modelo.addRow(new Object[]{pedidoProducto.getIdPedidoProducto(),
            pedidoProducto.getIdPedido(),
            producto.getNombre(),
            pedidoProducto.getCantidad(),
            "$" + producto.getPrecio() * pedidoProducto.getCantidad()
        });
        /*
        try {
            producto = ProductoData.buscarProducto(pedidoProducto.getIdProducto());
            pedido = pedidoData.buscarPedidoPorId(pedidoProducto.getIdPedido());
          //  mesa = mesaData.buscarMesaPorNumero(Integer.parseInt(CBMesa.getSelectedItem().toString()));
            //System.out.println(Integer.parseInt(CBMesa.getSelectedItem().toString()));
           // Mesa mesaPedido = mesaData.buscarMesaPorId(pedido.getIdMesa());

            if (mesaPedido.getIdMesa() == mesa.getIdMesa()) {
                modelo.addRow(new Object[]{pedidoProducto.getIdPedidoProducto(), pedidoProducto.getIdPedido(), producto.getNombre(), pedidoProducto.getCantidad()});
            } else {
                JOptionPane.showMessageDialog(null, "El pedido no corresponde a dicha mesa");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una mesa");
        }*/
    }

    private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Carrito");
        modelo.addColumn("Id Pedido");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        //modelo.addColumn("Mesa");
        modelo.addColumn("Total");

        JTablaPedProd.setModel(modelo);
    }
}
