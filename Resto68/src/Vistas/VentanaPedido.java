/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AcessoADatos.MesaData;
import AcessoADatos.PedidoData;
import Entidades.Mesa;
import Entidades.Pedido;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zona
 */
public class VentanaPedido extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    public VentanaPedido() {
        initComponents();
        cargarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.<>
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
        jLabel7 = new javax.swing.JLabel();
        jTFIdPedido = new javax.swing.JTextField();
        jTfIdMesa = new javax.swing.JTextField();
        jTFNombreMesero = new javax.swing.JTextField();
        JTFImporte = new javax.swing.JTextField();
        JTFHoras = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JRBCobrada = new javax.swing.JRadioButton();
        JBHacerPedido = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBLimpiar = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jBBuscarId = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTablaPedidos = new javax.swing.JTable();
        jBBuscarIdMesa = new javax.swing.JButton();
        jBBuscarNombreMesero = new javax.swing.JButton();
        jBBuscarFecha = new javax.swing.JButton();
        jBBuscarImporte = new javax.swing.JButton();
        jBBuscarCobrada = new javax.swing.JButton();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        JBBuscarHora = new javax.swing.JButton();

        jLabel1.setText("PEDIDOS");

        jLabel2.setText("Id pedido");

        jLabel3.setText("Id mesa");

        jLabel4.setText("Nombre mesero");

        jLabel5.setText("Fecha");

        jLabel6.setText("Importe");

        jLabel7.setText("Hora");

        JTFHoras.setText("--:--");
        JTFHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFHorasActionPerformed(evt);
            }
        });

        jLabel8.setText("Cobrada");

        JBHacerPedido.setText("Hacer pedido");
        JBHacerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHacerPedidoActionPerformed(evt);
            }
        });

        JBModificar.setText("Modificar pedido");
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

        jBBuscarId.setText("Buscar ");
        jBBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarIdActionPerformed(evt);
            }
        });

        JTTablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTTablaPedidos);

        jBBuscarIdMesa.setText("Buscar ");
        jBBuscarIdMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarIdMesaActionPerformed(evt);
            }
        });

        jBBuscarNombreMesero.setText("Buscar ");
        jBBuscarNombreMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarNombreMeseroActionPerformed(evt);
            }
        });

        jBBuscarFecha.setText("Buscar ");
        jBBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarFechaActionPerformed(evt);
            }
        });

        jBBuscarImporte.setText("Buscar ");
        jBBuscarImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarImporteActionPerformed(evt);
            }
        });

        jBBuscarCobrada.setText("Buscar ");
        jBBuscarCobrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarCobradaActionPerformed(evt);
            }
        });

        JBBuscarHora.setText("Buscar");
        JBBuscarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBHacerPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBModificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(68, 68, 68)
                                        .addComponent(jTFIdPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(74, 74, 74)
                                        .addComponent(jTfIdMesa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTFNombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBBuscarNombreMesero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBBuscarIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBLimpiar)
                                .addGap(216, 216, 216)
                                .addComponent(JBSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JTFHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JDCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jBBuscarFecha)
                                            .addComponent(JBBuscarHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JRBCobrada)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jBBuscarCobrada))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JTFImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jBBuscarImporte))))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscarId))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTfIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscarIdMesa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFNombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscarNombreMesero)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBBuscarFecha)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarHora)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(JTFImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBBuscarImporte))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(JRBCobrada)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jBBuscarCobrada)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBHacerPedido)
                    .addComponent(JBModificar)
                    .addComponent(JBLimpiar)
                    .addComponent(JBSalir))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JBHacerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHacerPedidoActionPerformed
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        try{
            if(jTfIdMesa.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el id de la mesa que desea agregar al pedido");
                return;
            }
            if(jTFNombreMesero.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del mesero que desea agregar al pedido");
                return;
            }
            if(JDCFecha.getDate()==null){
                JOptionPane.showMessageDialog(this, "Ingrese la fecha que desea agregar al pedido");
                return;
            }
            if(Integer.parseInt(JTFHoras.getText().substring(0,2))<0 || Integer.parseInt(JTFHoras.getText().substring(0,2))>12 ){
                JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 12");
                return;                
            }
            if(Integer.parseInt(JTFHoras.getText().substring(3))<0 || Integer.parseInt(JTFHoras.getText().substring(3))>59 ){
                JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 59");
                return;                
            }
            if(JTFImporte.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el Importe que desea agregar al pedido");
                return;
            }
            
            pedido.setIdMesa(Integer.parseInt(jTfIdMesa.getText()));
            pedido.setNombreMesero(jTFNombreMesero.getText());
            //combino fecha y hora 
            Instant instant = JDCFecha.getDate().toInstant();//
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();            
            LocalTime horaFinal = LocalTime.parse(JTFHoras.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime localDateTime = localDate.atTime(horaFinal);
            pedido.setFechaHora(localDateTime);
            pedido.setImporte(Double.parseDouble(JTFImporte.getText()));
            pedido.setCobrada(JRBCobrada.isSelected());
            pedidoData.agregarPedido(pedido);
            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo debe ingresar números");
        }
        
    }//GEN-LAST:event_JBHacerPedidoActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        try{
            if(jTFIdPedido.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el id del pedido que desea modificar");
                return;
            }
                        
            if(jTfIdMesa.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el id de la mesa a modificar");
                return;
            }
            if(jTFNombreMesero.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del mesero a modificar");
                return;
            }
            if(JDCFecha.getDate()==null){
                JOptionPane.showMessageDialog(this, "Ingrese la fecha a modificar");
                return;
            }
            if(Integer.parseInt(JTFHoras.getText().substring(0,2))<0 || Integer.parseInt(JTFHoras.getText().substring(0,2))>12 ){
                JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 12");
                return;                
            }
            if(Integer.parseInt(JTFHoras.getText().substring(3))<0 || Integer.parseInt(JTFHoras.getText().substring(3))>59 ){
                JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 59");
                return;                
            }
            if(JTFImporte.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el Importe a modificar");
                return;
            }
            
            pedido.setIdPedido(Integer.parseInt(jTFIdPedido.getText()));
            pedido.setIdMesa(Integer.parseInt(jTfIdMesa.getText()));
            pedido.setNombreMesero(jTFNombreMesero.getText());
            //combino fecha y hora 
            Instant instant = JDCFecha.getDate().toInstant();//
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            String hora = JTFHoras.getText();//meto en un string la fecha y la hora
            LocalTime horaFinal = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime localDateTime = localDate.atTime(horaFinal);
            pedido.setFechaHora(localDateTime);
            pedido.setImporte(Double.parseDouble(JTFImporte.getText()));
            pedido.setCobrada(JRBCobrada.isSelected());
            pedidoData.modificarPedido(pedido);
            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo debe ingresar números");
        }
    }//GEN-LAST:event_JBModificarActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        jTFIdPedido.setText("");
        jTfIdMesa.setText("");
        jTFNombreMesero.setText("");
        JDCFecha.setDate(null);
        JTFHoras.setText("");
        JTFImporte.setText("");
        JRBCobrada.setSelected(false);
        modelo.setRowCount(0);
    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void jBBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarIdActionPerformed
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try {
            if (jTFIdPedido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el id del producto que desea buscar");
                return;
            }
            
            pedido = pedidoData.buscarPedidoPorId(Integer.parseInt(jTFIdPedido.getText()));
            jTfIdMesa.setText(Integer.toString(pedido.getIdMesa()));
            jTFNombreMesero.setText(pedido.getNombreMesero());
            LocalDate fecha = pedido.getFechaHora().toLocalDate();            
            JDCFecha.setDate(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            LocalTime hora = pedido.getFechaHora().toLocalTime();
            JTFHoras.setText(hora.format(DateTimeFormatter.ofPattern("HH:mm")));
            JTFImporte.setText(Double.toString(pedido.getImporte()));
            JRBCobrada.setSelected(pedido.isCobrada());
            cargarProducto(pedido);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_jBBuscarIdActionPerformed

    private void JTFHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFHorasActionPerformed

    }//GEN-LAST:event_JTFHorasActionPerformed

    private void jBBuscarIdMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarIdMesaActionPerformed
        List<Pedido> pedidosPorMesa = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try {
            if (jTfIdMesa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el id de la mesa que desea buscar");
                return;
            }            
            pedidosPorMesa = pedidoData.listarPedidosPorMesa(Integer.parseInt(jTfIdMesa.getText()));
            if(pedidosPorMesa.isEmpty()){
                JOptionPane.showMessageDialog(this, "Esa Mesa no existe, ingrese una valida");
                jTfIdMesa.setText("");
                return;
            }
            for(Pedido listaPedidos : pedidosPorMesa)
                cargarProducto(listaPedidos);            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
    }//GEN-LAST:event_jBBuscarIdMesaActionPerformed

    private void jBBuscarNombreMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarNombreMeseroActionPerformed
        List<Pedido> pedidosPorMesero = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try {
            if (jTFNombreMesero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del mesero que desea buscar");
                return;
            }else if (!jTFNombreMesero.getText().matches("^[A-Za-z][A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "Ingrese solo letras en el campo nombre del producto");
                return;
            }        
            pedidosPorMesero = pedidoData.listarPedidosPorMesero(jTFNombreMesero.getText());
            if(pedidosPorMesero.isEmpty()){
                JOptionPane.showMessageDialog(this, "Ese nombre no existe, Ingrese uno valido");
                jTFNombreMesero.setText("");
                return;
            }
            for(Pedido listaPedidos : pedidosPorMesero)
                cargarProducto(listaPedidos);            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un mesero válido");
        } 
    }//GEN-LAST:event_jBBuscarNombreMeseroActionPerformed

    private void jBBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarFechaActionPerformed
        List<Pedido> pedidosPorFecha = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try{
            if(JDCFecha.getDate() == null){
              JOptionPane.showMessageDialog(this, "Ingrese la fecha que desea buscar");
                return;
            }
            LocalDate fecha = JDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();            
            pedidosPorFecha = pedidoData.listarPedidosPorFecha(fecha, fecha);
            if(pedidosPorFecha.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay pedidos en esta Fecha");
                JDCFecha.setDate(null);
                return;
            }
            for(Pedido listaPedidos : pedidosPorFecha)
                cargarProducto(listaPedidos);            
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válido");
        } 
    }//GEN-LAST:event_jBBuscarFechaActionPerformed

    private void JBBuscarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarHoraActionPerformed
        List<Pedido> pedidosPorHora = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try{            
            if(JTFHoras.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese la fecha que desea buscar");
                return;
            }
            if(Integer.parseInt(JTFHoras.getText().substring(0,2))<0 || Integer.parseInt(JTFHoras.getText().substring(0,2))>12 ){
                JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 23");
                return;                
            }
            if(Integer.parseInt(JTFHoras.getText().substring(3))<0 || Integer.parseInt(JTFHoras.getText().substring(3))>59 ){
                JOptionPane.showMessageDialog(this, "Ingrese minutos validos entre 0 y 59");
                return;                
            }            
            LocalTime Hora = LocalTime.parse(/*horaParcial*/JTFHoras.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            pedidosPorHora = pedidoData.listarPedidosPorHora(Hora, Hora);
            if(pedidosPorHora.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay pedidos en esta Hora");
                JTFHoras.setText("");
                return;
            }
            for(Pedido listaPedidos : pedidosPorHora)
                cargarProducto(listaPedidos);            
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una hora válido");
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo Ingrese horas del tipo (HH:mm) números");
        }
    }//GEN-LAST:event_JBBuscarHoraActionPerformed

    private void jBBuscarImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarImporteActionPerformed
        List<Pedido> pedidosPorImporte = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try{
            if(JTFImporte.getText().isEmpty()){
              JOptionPane.showMessageDialog(this, "Ingrese el importe que desea buscar");
                return;
            }
                     
            pedidosPorImporte = pedidoData.listarPedidosPorImporte(Double.parseDouble(JTFImporte.getText()), Double.parseDouble(JTFImporte.getText()));
            if(pedidosPorImporte.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay pedidos con este importe");
                JDCFecha.setDate(null);
                return;
            }
            for(Pedido listaPedidos : pedidosPorImporte)
                cargarProducto(listaPedidos);            
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válido");
        } 
    }//GEN-LAST:event_jBBuscarImporteActionPerformed

    private void jBBuscarCobradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarCobradaActionPerformed
        List<Pedido> pedidosPorCobrada = new ArrayList<Pedido>();
        PedidoData pedidoData = new PedidoData();
        modelo.setRowCount(0);
        try{        
            pedidosPorCobrada = pedidoData.listarPedidosPorCobrada(JRBCobrada.isSelected());
            if(pedidosPorCobrada.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay pedidos");                
                return;
            }
            for(Pedido listaPedidos : pedidosPorCobrada)
                cargarProducto(listaPedidos);            
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válido");
        } 
    }//GEN-LAST:event_jBBuscarCobradaActionPerformed
    private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Id Pedido");
        modelo.addColumn("Numero de Mesa");
        modelo.addColumn("Nombre Mesero");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Estado");
        JTTablaPedidos.setModel(modelo);
    }
    private void cargarProducto(Pedido pedido) { //Agrego al pedido como fila en la tabla
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        mesa = mesaData.buscarMesaPorId(pedido.getIdMesa());
        String cobrada="No esta cobrada";
        if(pedido.isCobrada())
            cobrada = "Esta cobrada";
        modelo.addRow(new Object[]{
            pedido.getIdPedido(),
            mesa.getNumero(),
            pedido.getNombreMesero(),
            pedido.getFechaHora().toLocalDate(),
            pedido.getFechaHora().toLocalTime(),
            pedido.getImporte(),
            cobrada
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscarHora;
    private javax.swing.JButton JBHacerPedido;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBSalir;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JRadioButton JRBCobrada;
    private javax.swing.JTextField JTFHoras;
    private javax.swing.JTextField JTFImporte;
    private javax.swing.JTable JTTablaPedidos;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jBBuscarCobrada;
    private javax.swing.JButton jBBuscarFecha;
    private javax.swing.JButton jBBuscarId;
    private javax.swing.JButton jBBuscarIdMesa;
    private javax.swing.JButton jBBuscarImporte;
    private javax.swing.JButton jBBuscarNombreMesero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFIdPedido;
    private javax.swing.JTextField jTFNombreMesero;
    private javax.swing.JTextField jTfIdMesa;
    // End of variables declaration//GEN-END:variables
}
