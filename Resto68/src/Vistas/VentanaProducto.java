/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AcessoADatos.ProductoData;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zona
 */
public class VentanaProducto extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();//Importación del DefaultTableModel

    /**
     * Creates new form VentanaProducto
     */
    public VentanaProducto() {
        initComponents();
        cargarCabecera();
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
        jLabel6 = new javax.swing.JLabel();
        JTFTipoProducto = new javax.swing.JTextField();
        JTFIdProducto = new javax.swing.JTextField();
        JTFNombreProducto = new javax.swing.JTextField();
        JTFPrecioProducto = new javax.swing.JTextField();
        JRBEstadoProducto = new javax.swing.JRadioButton();
        JBAgregarProducto = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBLimpiar = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();
        JBBuscarPorId = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTablaProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        JTFStockProducto = new javax.swing.JTextField();
        JBBuscarTipoProducto = new javax.swing.JButton();
        JBBuscarPorNombreProducto = new javax.swing.JButton();
        JBBuscarPorPrecio = new javax.swing.JButton();
        JBBuscarPorEstado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("PRODUCTO");

        jLabel2.setText("Id producto");

        jLabel3.setText("Nombre de producto");

        jLabel4.setText("Tipo de producto");

        jLabel5.setText("Estado");

        jLabel6.setText("Precio");

        JTFNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNombreProductoActionPerformed(evt);
            }
        });

        JTFPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPrecioProductoActionPerformed(evt);
            }
        });

        JRBEstadoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBEstadoProductoActionPerformed(evt);
            }
        });

        JBAgregarProducto.setText("Agregar");
        JBAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAgregarProductoActionPerformed(evt);
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

        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        JBBuscarPorId.setText("Por Id");
        JBBuscarPorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarPorIdActionPerformed(evt);
            }
        });

        JTTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTTablaProductos);

        jLabel7.setText("Stock");

        JBBuscarTipoProducto.setText("Buscar por tipo producto");
        JBBuscarTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarTipoProductoActionPerformed(evt);
            }
        });

        JBBuscarPorNombreProducto.setText("Por nombre producto");
        JBBuscarPorNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarPorNombreProductoActionPerformed(evt);
            }
        });

        JBBuscarPorPrecio.setText("Ordenar precios de menor a mayor");
        JBBuscarPorPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarPorPrecioActionPerformed(evt);
            }
        });

        JBBuscarPorEstado.setText("Por estado");
        JBBuscarPorEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarPorEstadoActionPerformed(evt);
            }
        });

        jLabel8.setText("Búsquedas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(176, 176, 176))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JBAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(JBModificar)
                        .addGap(18, 18, 18)
                        .addComponent(JBLimpiar)
                        .addGap(107, 107, 107)
                        .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTFIdProducto)
                                    .addComponent(JTFTipoProducto)
                                    .addComponent(JTFNombreProducto)
                                    .addComponent(JTFPrecioProducto)
                                    .addComponent(JTFStockProducto)
                                    .addComponent(JRBEstadoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBBuscarPorId)
                                    .addComponent(JBBuscarTipoProducto)
                                    .addComponent(JBBuscarPorNombreProducto)
                                    .addComponent(JBBuscarPorPrecio)
                                    .addComponent(JBBuscarPorEstado)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarPorId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarTipoProducto)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarPorNombreProducto)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarPorPrecio)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JRBEstadoProducto)
                            .addComponent(JBBuscarPorEstado))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAgregarProducto)
                    .addComponent(JBModificar)
                    .addComponent(JBLimpiar)
                    .addComponent(JBSalir))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNombreProductoActionPerformed

    private void JTFPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFPrecioProductoActionPerformed

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JBAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAgregarProductoActionPerformed
        Producto produ = new Producto();
        ProductoData productoData = new ProductoData();
        try {
            String tipoProducto = JTFTipoProducto.getText();
            if (JTFTipoProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el tipo de producto que desea agregar");
                return;
            } else if (!tipoProducto.matches("^[A-Za-z ]+$")) {//VERIFICA/NOS FIJAMOS SI LO QUE SE INGRESA EN EL JTFTipoProducto contiene algo que no sean letras
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo Tipo producto");
                return;
            }

            String nombreProducto = JTFNombreProducto.getText();
            if (JTFNombreProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto que desea ingresar");
                return;
            } else if (!nombreProducto.matches("^[A-Za-z][A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo nombre de producto");
                return;
            }

            if (JTFPrecioProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el precio del producto a ingresar");
                return;
            }

            if (JTFStockProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cantidad de productos que hay en stock");
                return;
            }

            produ.setTipoDeProducto(tipoProducto);
            produ.setNombre(nombreProducto);
            produ.setPrecio(Double.parseDouble(JTFPrecioProducto.getText()));
            produ.setStock(Integer.parseInt(JTFStockProducto.getText()));
            produ.setEstado(JRBEstadoProducto.isSelected());

            productoData.agregarProducto(produ);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo debe ingresar números");
        }
    }//GEN-LAST:event_JBAgregarProductoActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed
        ProductoData productoData = new ProductoData();
        Producto produ = new Producto();
        try {
            if (JTFIdProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el id del producto que desea modificar");
                return;
            }

            String tipoProducto = JTFTipoProducto.getText();
            if (JTFTipoProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el tipo de producto que desea modificar");
                return;
            } else if (!tipoProducto.matches("^[A-Za-z ]+$")) {//VERIFICA/NOS FIJAMOS SI LO QUE SE INGRESA EN EL JTFTipoProducto contiene algo que no sean letras
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo tipo producto");
                return;
            }

            String nombreProducto = JTFNombreProducto.getText();
            if (JTFNombreProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto que desea modificarr");
                return;
            } else if (!nombreProducto.matches("^[A-Za-z ]+$")) {
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo nombre de producto");
                return;
            }

            if (JTFPrecioProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el precio del producto que desea modificar");
                return;
            }

            if (JTFStockProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cantidad de productos que hay en stock");
                return;
            }

            produ.setIdProducto(Integer.parseInt(JTFIdProducto.getText()));
            produ.setTipoDeProducto(tipoProducto);
            produ.setNombre(nombreProducto);
            produ.setPrecio(Double.parseDouble(JTFPrecioProducto.getText()));
            produ.setStock(Integer.parseInt(JTFStockProducto.getText()));
            produ.setEstado(JRBEstadoProducto.isSelected());

            productoData.modificarProducto(produ);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo debe ingresar números");
        }
    }//GEN-LAST:event_JBModificarActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        JTFIdProducto.setText("");
        JTFNombreProducto.setText("");
        JTFPrecioProducto.setText("");
        JTFStockProducto.setText("");
        JTFTipoProducto.setText("");
        JRBEstadoProducto.setSelected(false);
        modelo.setRowCount(0);//cuando apreto limpiar, también me borra las filas de la tabla
    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void JBBuscarPorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarPorIdActionPerformed
        Producto produ = new Producto();
        ProductoData productoData = new ProductoData();
        try {
            if (JTFIdProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del producto que desea buscar");
                return;
            }
            produ = productoData.buscarProducto(Integer.parseInt(JTFIdProducto.getText()));//le estoy cargando a produ un producto
            JTFTipoProducto.setText(produ.getTipoDeProducto());//busco en produ el tipo de producto, y lo seteo en el text field
            JTFNombreProducto.setText(produ.getNombre());
            JTFPrecioProducto.setText(Double.toString(produ.getPrecio()));
            JTFStockProducto.setText(Integer.toString(produ.getStock()));
            JRBEstadoProducto.setSelected(produ.isEstado());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_JBBuscarPorIdActionPerformed

    private void JBBuscarTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarTipoProductoActionPerformed
        Producto produ = new Producto();
        ProductoData productoData = new ProductoData();

        String tipoProducto = JTFTipoProducto.getText();
        if (JTFTipoProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el tipo de producto que desea buscar");
            return;
        } else if (!tipoProducto.matches("^[A-Za-z][A-Za-z ]*$")) {
            JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo Tipo de producto");
            return;
        }
        List<Producto> productosPorTipoList = new ArrayList<>();
        productosPorTipoList = productoData.buscarProductoPorTipo(JTFTipoProducto.getText());

        for (Producto tiposProducto : productosPorTipoList) {
            cargarProducto(tiposProducto);
        }

    }//GEN-LAST:event_JBBuscarTipoProductoActionPerformed

    private void JBBuscarPorNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarPorNombreProductoActionPerformed
        ProductoData productoData = new ProductoData();
        Producto produ = new Producto();
        try {
            String nombreProducto = JTFNombreProducto.getText();
            if (JTFNombreProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto que desea buscar");
                return;
            } else if (!nombreProducto.matches("^[A-Za-z][A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo nombre del producto");
                return;
            }

            produ = productoData.buscarProductoPorNombre(JTFNombreProducto.getText());
            JTFIdProducto.setText(Integer.toString(produ.getIdProducto()));
            JTFTipoProducto.setText(produ.getTipoDeProducto());//busco en produ el tipo de producto, y lo seteo en el text field
            JTFNombreProducto.setText(produ.getNombre());
            JTFPrecioProducto.setText(Double.toString(produ.getPrecio()));
            JTFStockProducto.setText(Integer.toString(produ.getStock()));
            JRBEstadoProducto.setSelected(produ.isEstado());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido");
        }
    }//GEN-LAST:event_JBBuscarPorNombreProductoActionPerformed

    private void JBBuscarPorPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarPorPrecioActionPerformed
        ProductoData productoData = new ProductoData();

//        String preciosProductos = JTFPrecioProducto.getText();
//        if (JTFPrecioProducto.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el precio del producto que desea buscar");
//            return;
//        }
        List<Producto> productosPorPrecioList = new ArrayList<>();
        productosPorPrecioList = productoData.buscarProductosMenorAMayorPrecio();

        for (Producto preciosProducto : productosPorPrecioList) {
            cargarProducto(preciosProducto);
        }
    }//GEN-LAST:event_JBBuscarPorPrecioActionPerformed

    private void JBBuscarPorEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarPorEstadoActionPerformed
        ProductoData productoData = new ProductoData();
        List<Producto> productosPorEstadoList = new ArrayList<>();
        productosPorEstadoList = productoData.buscarProductoPorEstado(JRBEstadoProducto.isSelected());

        for (Producto estadoProductos : productosPorEstadoList) {
            cargarProducto(estadoProductos);
        }
    }//GEN-LAST:event_JBBuscarPorEstadoActionPerformed

    private void JRBEstadoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBEstadoProductoActionPerformed
        //REVISARRRRRRRR
        
        
        ProductoData productoData = new ProductoData();
        Producto produ = new Producto();
        if(produ.isEstado()== true){
            JRBEstadoProducto.setSelected(true);
            
        }else{
            JRBEstadoProducto.setSelected(false);
        }
    }//GEN-LAST:event_JRBEstadoProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAgregarProducto;
    private javax.swing.JButton JBBuscarPorEstado;
    private javax.swing.JButton JBBuscarPorId;
    private javax.swing.JButton JBBuscarPorNombreProducto;
    private javax.swing.JButton JBBuscarPorPrecio;
    private javax.swing.JButton JBBuscarTipoProducto;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBSalir;
    private javax.swing.JRadioButton JRBEstadoProducto;
    private javax.swing.JTextField JTFIdProducto;
    private javax.swing.JTextField JTFNombreProducto;
    private javax.swing.JTextField JTFPrecioProducto;
    private javax.swing.JTextField JTFStockProducto;
    private javax.swing.JTextField JTFTipoProducto;
    private javax.swing.JTable JTTablaProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Id producto");
        modelo.addColumn("Tipo producto");
        modelo.addColumn("Nombre producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");
        JTTablaProductos.setModel(modelo);
    }

    private void cargarProducto(Producto producto) { //Agrego al producto como fila en la tabla
        modelo.addRow(new Object[]{producto.getIdProducto(), producto.getTipoDeProducto(), producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.isEstado()});
        //método addRow es para agregar una fila al modelo
    }
}
