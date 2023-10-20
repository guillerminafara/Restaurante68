/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AcessoADatos.MesaData;
import Entidades.Mesa;
import javax.swing.JOptionPane;

/**
 *
 * @author Zona
 */
public class VentanaMesa extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaMesa
     */
    public VentanaMesa() {
        initComponents();
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
        JTFNumeroMesa = new javax.swing.JTextField();
        JTFCapacidadMesa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFIdMesa = new javax.swing.JTextField();
        JBAgregar = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBLimpiar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        JBBuscarPorId = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JRBEstado = new javax.swing.JRadioButton();
        JBBuscarPorNumero = new javax.swing.JButton();
        JBBuscarPorCapacidad = new javax.swing.JButton();
        JBBuscarPorEstado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("MESA");

        jLabel2.setText("Número de la mesa");

        jLabel3.setText("Capacidad de la mesa");

        jLabel4.setText("Estado");

        jLabel5.setText("Id mesa");

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

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        JBBuscarPorId.setText("Por Id");
        JBBuscarPorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarPorIdActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        JRBEstado.setText("Ocupada");

        JBBuscarPorNumero.setText("Por número de mesa");

        JBBuscarPorCapacidad.setText("Por capacidad");

        JBBuscarPorEstado.setText("Por estado");

        jLabel6.setText("Búsquedas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTFIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFCapacidadMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JRBEstado))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBBuscarPorId)
                            .addComponent(JBBuscarPorNumero)
                            .addComponent(JBBuscarPorCapacidad)
                            .addComponent(JBBuscarPorEstado)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(JBModificar)
                        .addGap(18, 18, 18)
                        .addComponent(JBLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(jBSalir)))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTFIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBBuscarPorId))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTFNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBBuscarPorNumero))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFCapacidadMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscarPorCapacidad))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JRBEstado)
                    .addComponent(JBBuscarPorEstado))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAgregar)
                    .addComponent(JBModificar)
                    .addComponent(jBSalir)
                    .addComponent(JBLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void JBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAgregarActionPerformed
        MesaData mesaData = new MesaData();
        Mesa mesa = new Mesa();

        if (JTFNumeroMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de la mesa");
            return;
        }

        if (JTFCapacidadMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la capacidad que tiene la mesa");
            return;
        }

        mesa.setNumero(Integer.parseInt(JTFNumeroMesa.getText()));
        mesa.setCapacidad(Integer.parseInt(JTFCapacidadMesa.getText()));
        mesa.setEstadoDeMesa(JRBEstado.isSelected());

        mesaData.crearMesa(mesa);
    }//GEN-LAST:event_JBAgregarActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed
        MesaData mesaData = new MesaData();
        Mesa mesa = new Mesa();
        if (JTFIdMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Id de la mesa");
            return;
        }
        if (JTFNumeroMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de la mesa");
            return;
        }

        if (JTFCapacidadMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la capacidad que tiene la mesa");
            return;
        }
        mesa.setIdMesa(Integer.parseInt(JTFIdMesa.getText()));
        mesa.setNumero(Integer.parseInt(JTFNumeroMesa.getText()));
        mesa.setCapacidad(Integer.parseInt(JTFCapacidadMesa.getText()));
        mesa.setEstadoDeMesa(JRBEstado.isSelected());

        mesaData.modificarMesa(mesa);
    }//GEN-LAST:event_JBModificarActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        JTFIdMesa.setText("");
        JTFNumeroMesa.setText("");
        JTFCapacidadMesa.setText("");
        JRBEstado.setSelected(false);
    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void JBBuscarPorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarPorIdActionPerformed
        
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        try{
        if (JTFIdMesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un Id para la búsqueda");
        }

        mesa = mesaData.BuscarMesa(Integer.parseInt(JTFIdMesa.getText()));
        JTFNumeroMesa.setText(Integer.toString(mesa.getNumero()));
        JTFCapacidadMesa.setText(Integer.toString(mesa.getCapacidad()));
        JRBEstado.setSelected(mesa.isEstadoDeMesa());
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un id válido");
        }
    }//GEN-LAST:event_JBBuscarPorIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAgregar;
    private javax.swing.JButton JBBuscarPorCapacidad;
    private javax.swing.JButton JBBuscarPorEstado;
    private javax.swing.JButton JBBuscarPorId;
    private javax.swing.JButton JBBuscarPorNumero;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JRadioButton JRBEstado;
    private javax.swing.JTextField JTFCapacidadMesa;
    private javax.swing.JTextField JTFIdMesa;
    private javax.swing.JTextField JTFNumeroMesa;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
