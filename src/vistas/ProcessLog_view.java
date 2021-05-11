/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JRootPane;
import modelos.Process;

/**
 *
 * @author XPC
 */
public class ProcessLog_view extends javax.swing.JFrame {

    Process proceso;
    
    public ProcessLog_view(Process proceso) {
        initComponents();
        this.proceso = proceso;
        setInfo();
        this.setDefaultCloseOperation(0);
    }

    public void setInfo(){
        String status = "Bloqueado: "
                    + proceso.getBlocked() + " , Preparado: "
                    + proceso.getReady() + " , Corriendo: "
                    + proceso.getRunning() + "\n";
        this.proceso_status_lable.setText(status);
        this.process_id_label.setText(proceso.getProcess_id());
        //this.log_info.setEnabled(false);
        for (String mensaje: this.proceso.getLog_messages()) {
            this.log_info.append(mensaje);
        }
        //
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        process_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        proceso_status_lable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        log_info = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        process_id_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        process_id_label.setForeground(new java.awt.Color(0, 0, 0));
        process_id_label.setText("Proceso ID");
        jPanel1.add(process_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 110, 30));

        jButton1.setText("Listo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        proceso_status_lable.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        proceso_status_lable.setForeground(new java.awt.Color(0, 0, 0));
        proceso_status_lable.setText("STATUS_INFO");
        jPanel1.add(proceso_status_lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 620, 30));

        log_info.setBackground(new java.awt.Color(255, 255, 255));
        log_info.setColumns(20);
        log_info.setForeground(new java.awt.Color(0, 0, 0));
        log_info.setRows(5);
        jScrollPane2.setViewportView(log_info);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 810, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProcessLog_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessLog_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessLog_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessLog_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea log_info;
    private javax.swing.JLabel proceso_status_lable;
    private javax.swing.JLabel process_id_label;
    // End of variables declaration//GEN-END:variables
}
