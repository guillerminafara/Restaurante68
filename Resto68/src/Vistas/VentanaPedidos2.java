/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AcessoADatos.MesaData;
import AcessoADatos.PedidoData;
import AcessoADatos.ProductoData;
import Entidades.Mesa;
import Entidades.Pedido;
import Entidades.PedidoProducto;
import Entidades.Producto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fran-PC
 */
public class VentanaPedidos2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaPedidos2
     */
    private DefaultTableModel modelo = new DefaultTableModel();

    public VentanaPedidos2() {
        initComponents();
        cargarCabecera();
        cargarComboMesero();
        cargarComboMesa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCBMesero = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        JBSalir = new javax.swing.JButton();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        JBLimpiar = new javax.swing.JButton();
        JCBuscarMesero = new javax.swing.JButton();
        JTFHoraInicial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFHoraFinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCBMesa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        JBMesa = new javax.swing.JButton();

        JCBMesero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        JCBMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBMeseroActionPerformed(evt);
            }
        });

        jLabel1.setText("Meseros:");

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
        jScrollPane1.setViewportView(JTabla);

        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        JBLimpiar.setText("Limpiar");
        JBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarActionPerformed(evt);
            }
        });

        JCBuscarMesero.setText("Buscar");
        JCBuscarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBuscarMeseroActionPerformed(evt);
            }
        });

        JTFHoraInicial.setText("--:--");

        jLabel2.setText("Hora Inicial:");

        JTFHoraFinal.setText("--:--");

        jLabel4.setText("Hora Final:");

        JCBMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));

        jLabel5.setText("Mesa:");

        JBMesa.setText("Buscar");
        JBMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(JBLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBSalir)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCBMesero, 0, 108, Short.MAX_VALUE)
                            .addComponent(JCBMesa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBuscarMesero)
                            .addComponent(JBMesa, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(13, 13, 13)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTFHoraFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(JTFHoraInicial))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JCBuscarMesero)
                        .addGap(21, 21, 21)
                        .addComponent(JBMesa))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTFHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTFHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalir)
                    .addComponent(JBLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBMeseroActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_JCBMeseroActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        // TODO add your handling code here:

        modelo.setRowCount(0);
    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void JCBuscarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBuscarMeseroActionPerformed
        // TODO add your handling code here:
        //  JCBuscarMesero
        modelo.setRowCount(0);
        if (JCBMesero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un mesero");
            return;
        }
        List<Pedido> listaPed = new ArrayList<>();        
        PedidoData pedidoData = new PedidoData();
        listaPed = pedidoData.listarPedidosPorMesero(JCBMesero.getSelectedItem().toString());
        LocalDate fecha = JDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();        
        for (Pedido pedList : listaPed) {
            LocalDate fechaPedido = pedList.getFechaHora().toLocalDate();
            if(fecha.equals(fechaPedido)){
                cargarTabla(pedList);
            }else{
                JOptionPane.showMessageDialog(this, "No hay pedidos en esa fecha para ese mesero");
            }   
        }

    }//GEN-LAST:event_JCBuscarMeseroActionPerformed

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JBMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMesaActionPerformed
        modelo.setRowCount(0);
        if (JCBMesa.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un mesa");
            return;
        }
        List<Pedido> listaPed = new ArrayList<>();        
        PedidoData pedidoData = new PedidoData();
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        mesa = mesaData.buscarMesaPorNumero(Integer.parseInt(JCBMesa.getSelectedItem().toString()));
        try{           

            if(Integer.parseInt(JTFHoraInicial.getText().substring(0,2))<0 || Integer.parseInt(JTFHoraInicial.getText().substring(0,2))>23 ){
                    JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 23");
                    return;                
                }
            if(Integer.parseInt(JTFHoraInicial.getText().substring(3))<0 || Integer.parseInt(JTFHoraInicial.getText().substring(3))>59 ){
                    JOptionPane.showMessageDialog(this, "Ingrese minutos validos entre 0 y 59");
                    return;                
            }
            LocalTime horaInicial = LocalTime.parse(JTFHoraInicial.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            if(Integer.parseInt(JTFHoraFinal.getText().substring(0,2))<0 || Integer.parseInt(JTFHoraFinal.getText().substring(0,2))>23 ){
                    JOptionPane.showMessageDialog(this, "Ingrese una hora valida entre 0 y 23");
                    return;                
                }
            if(Integer.parseInt(JTFHoraFinal.getText().substring(3))<0 || Integer.parseInt(JTFHoraFinal.getText().substring(3))>59 ){
                    JOptionPane.showMessageDialog(this, "Ingrese minutos validos entre 0 y 59");
                    return;                
            }

            LocalTime horaFinal = LocalTime.parse(JTFHoraFinal.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalDate fecha = JDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            listaPed = pedidoData.listarPedidosPorHora(horaInicial, horaFinal);
            for(Pedido pedido : listaPed){
                LocalDate fechaPedido = pedido.getFechaHora().toLocalDate();
                if(fecha.equals(fechaPedido)&&mesa.getIdMesa()==pedido.getIdMesa()){
                    cargarTabla(pedido);  
                }
            }
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha valida");
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo Ingrese horas del tipo (HH:mm) números");
        }
    }//GEN-LAST:event_JBMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBMesa;
    private javax.swing.JButton JBSalir;
    private javax.swing.JComboBox JCBMesa;
    private javax.swing.JComboBox JCBMesero;
    private javax.swing.JButton JCBuscarMesero;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JTextField JTFHoraFinal;
    private javax.swing.JTextField JTFHoraInicial;
    private javax.swing.JTable JTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
  private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Id Pedido");
        modelo.addColumn("Numero de Mesa");
        modelo.addColumn("Nombre Mesero");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Estado");
        JTabla.setModel(modelo);
    }

    private void cargarTabla(Pedido pedido) {
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        mesa = mesaData.buscarMesaPorId(pedido.getIdMesa());
        String cobrada = "No esta cobrada";
        if (pedido.isCobrada()) {
            cobrada = "Esta cobrada";
        }
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

    private void cargarComboMesero() {
        List<Pedido> listaPed = new ArrayList<>();
        Pedido pedido = new Pedido();
        PedidoData pedidoData = new PedidoData();

        listaPed = pedidoData.listarPedidos();
        for (Pedido pedList : listaPed) {
            JCBMesero.addItem(pedList);
        }

    }

    private void cargarComboMesa() {
        List<Mesa> listaMesa = new ArrayList<>();
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();

        listaMesa = mesaData.listarMesa();
        for (Mesa pedList : listaMesa) {
            JCBMesa.addItem(pedList);
        }

    }

}
