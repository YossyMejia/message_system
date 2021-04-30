package vistas;

import utiles.Configurador;

public class Configuracion_view extends javax.swing.JFrame {
    
     Configurador configurador;
     private String sincr_send;
     private String sincr_receive;
     
     
    public Configuracion_view() {
        
        this.configurador = new Configurador();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.turn_off_options(dir_indirecto_ops);
        this.turn_off_options(form_largo_opc);
        this.turn_off_options(disciplina_label);
        this.turn_off_options(manejocolas_opciones);
        this.turn_off_options(tamano_cola_label);
        this.turn_off_options(tamano_cola);
    }
    
    //Funcion encargada de deshabilitar componentes y hacerlos invisibles
    public void turn_off_options(javax.swing.JComponent element) {
        element.setVisible(false);
        element.setEnabled(false);
    }
    
    //Funcion encargada de deshabilitar componentes y hacerlos invisibles
    public void turn_on_options(javax.swing.JComponent element) {
        element.setVisible(true);
        element.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        direcc_cb2 = new javax.swing.JCheckBox();
        disciplina_label = new javax.swing.JLabel();
        tamano_cola_label = new javax.swing.JLabel();
        direccion_opciones = new javax.swing.JComboBox<>();
        manejocolas_opciones = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        dir_indirecto_ops = new javax.swing.JComboBox<>();
        sincro_send_options = new javax.swing.JComboBox<>();
        form_largo_opc = new javax.swing.JComboBox<>();
        direcc_cb3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        formato_opciones1 = new javax.swing.JComboBox<>();
        lable_receive = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tamano_cola = new javax.swing.JTextField();
        cantidad_procesos = new javax.swing.JTextField();
        crear_btn = new javax.swing.JButton();
        sincro_receive_options = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        label_send = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_ayuda = new javax.swing.JMenu();
        ayuda_definiciones = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direcc_cb2.setBackground(new java.awt.Color(153, 153, 153));
        direcc_cb2.setForeground(new java.awt.Color(0, 0, 0));
        direcc_cb2.setText("Implícito");
        direcc_cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_cb2ActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 130, -1));

        disciplina_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        disciplina_label.setForeground(new java.awt.Color(0, 0, 0));
        disciplina_label.setText("Disciplina de manejo de colas");
        jPanel1.add(disciplina_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 220, 30));

        tamano_cola_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tamano_cola_label.setForeground(new java.awt.Color(0, 0, 0));
        tamano_cola_label.setText("Tamaño de la cola: ");
        jPanel1.add(tamano_cola_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 140, 30));

        direccion_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directo", "Indirecto" }));
        direccion_opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccion_opcionesActionPerformed(evt);
            }
        });
        jPanel1.add(direccion_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, 30));

        manejocolas_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "Prioridad" }));
        jPanel1.add(manejocolas_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 140, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Direccionamiento");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 140, 30));

        dir_indirecto_ops.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinamico", "Estatico" }));
        dir_indirecto_ops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dir_indirecto_opsActionPerformed(evt);
            }
        });
        jPanel1.add(dir_indirecto_ops, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 140, 30));

        sincro_send_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "Nonblocking" }));
        sincro_send_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sincro_send_optionsActionPerformed(evt);
            }
        });
        jPanel1.add(sincro_send_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 140, 30));

        form_largo_opc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Variable" }));
        jPanel1.add(form_largo_opc, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 140, 30));

        direcc_cb3.setBackground(new java.awt.Color(153, 153, 153));
        direcc_cb3.setForeground(new java.awt.Color(0, 0, 0));
        direcc_cb3.setText("Explícito");
        direcc_cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_cb3ActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 130, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Formato");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 140, 30));

        formato_opciones1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contenido", "Largo" }));
        formato_opciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formato_opciones1ActionPerformed(evt);
            }
        });
        jPanel1.add(formato_opciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 140, 30));

        lable_receive.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lable_receive.setForeground(new java.awt.Color(0, 0, 0));
        lable_receive.setText("Receive");
        jPanel1.add(lable_receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cantidad de procesos: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 320, 30));

        tamano_cola.setText("1");
        tamano_cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamano_colaActionPerformed(evt);
            }
        });
        jPanel1.add(tamano_cola, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 260, 30));

        cantidad_procesos.setText("1");
        cantidad_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_procesosActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad_procesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 260, 30));

        crear_btn.setText("Crear");
        crear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btnActionPerformed(evt);
            }
        });
        jPanel1.add(crear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 690, 130, 50));

        sincro_receive_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "Nonblocking", "Prueba de llegada" }));
        sincro_receive_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sincro_receive_optionsActionPerformed(evt);
            }
        });
        jPanel1.add(sincro_receive_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 140, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Sincronización");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

        label_send.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_send.setForeground(new java.awt.Color(0, 0, 0));
        label_send.setText("Send");
        jPanel1.add(label_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 110, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Send");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Receive");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 1020, 780));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto_1\\src\\Imagenes\\fondo.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 1780, 900));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1218, 871));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        menu_ayuda.setText("Ayuda");

        ayuda_definiciones.setText("Explicacion de conceptos");
        ayuda_definiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayuda_definicionesActionPerformed(evt);
            }
        });
        menu_ayuda.add(ayuda_definiciones);

        jMenuBar1.add(menu_ayuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void direcc_cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcc_cb2ActionPerformed
        if(direcc_cb2.isSelected()){
            direcc_cb3.setEnabled(false);
        }
        else{
            direcc_cb3.setEnabled(true);
        }
    }//GEN-LAST:event_direcc_cb2ActionPerformed

    private void sincro_send_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sincro_send_optionsActionPerformed
        this.sincr_send = sincro_send_options.getSelectedItem().toString();
    }//GEN-LAST:event_sincro_send_optionsActionPerformed

    private void direcc_cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcc_cb3ActionPerformed
        if(direcc_cb3.isSelected()){
            direcc_cb2.setEnabled(false);
        }
        else{
            direcc_cb2.setEnabled(true);
        }
    }//GEN-LAST:event_direcc_cb3ActionPerformed

    private void dir_indirecto_opsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dir_indirecto_opsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dir_indirecto_opsActionPerformed

    private void direccion_opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccion_opcionesActionPerformed

        String element = direccion_opciones.getSelectedItem().toString();
        if (element != null) {
            this.turn_off_options(direcc_cb3);
            this.turn_off_options(direcc_cb2);
            if(element == "Directo"){
                this.turn_on_options(direcc_cb3);
                this.turn_on_options(direcc_cb2);
                this.turn_on_options(lable_receive);
                this.turn_on_options(label_send);
                this.turn_off_options(dir_indirecto_ops);
                this.turn_off_options(disciplina_label);
                this.turn_off_options(manejocolas_opciones);
                this.turn_off_options(tamano_cola_label);
                this.turn_off_options(tamano_cola);
            }
            else if(element == "Indirecto"){
               this.turn_on_options(dir_indirecto_ops);
               this.turn_on_options(disciplina_label);
               this.turn_on_options(manejocolas_opciones);
               this.turn_on_options(tamano_cola_label);
               this.turn_on_options(tamano_cola);
               this.turn_off_options(direcc_cb3);
               this.turn_off_options(direcc_cb2);
               this.turn_off_options(lable_receive);
               this.turn_off_options(label_send);
                
            }
        }
    }//GEN-LAST:event_direccion_opcionesActionPerformed

    private void formato_opciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formato_opciones1ActionPerformed
        String element = formato_opciones1.getSelectedItem().toString();
        if (element != null) {
            if(element == "Contenido"){
                this.turn_off_options(form_largo_opc);
            }
            else if(element == "Largo"){
               this.turn_on_options(form_largo_opc);
            }
        }
    }//GEN-LAST:event_formato_opciones1ActionPerformed

    private void tamano_colaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamano_colaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamano_colaActionPerformed

    private void cantidad_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_procesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_procesosActionPerformed

    private void crear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btnActionPerformed
        int procesos = Integer.parseInt(cantidad_procesos.getText());
        this.sincr_send = sincro_send_options.getSelectedItem().toString();
        this.sincr_receive = sincro_receive_options.getSelectedItem().toString();
        this.configurador.setConfig(this.sincr_receive, this.sincr_send, 
                procesos);
        this.configurador.create();
        this.dispose();
        Principal_view principal_v = new Principal_view(configurador);
        principal_v.setVisible(true);
    }//GEN-LAST:event_crear_btnActionPerformed

    private void ayuda_definicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayuda_definicionesActionPerformed
        
    }//GEN-LAST:event_ayuda_definicionesActionPerformed

    private void sincro_receive_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sincro_receive_optionsActionPerformed
         this.sincr_receive = sincro_receive_options.getSelectedItem().toString();
    }//GEN-LAST:event_sincro_receive_optionsActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ayuda_definiciones;
    private javax.swing.JTextField cantidad_procesos;
    public javax.swing.JButton crear_btn;
    private javax.swing.JComboBox<String> dir_indirecto_ops;
    public javax.swing.JCheckBox direcc_cb2;
    public javax.swing.JCheckBox direcc_cb3;
    private javax.swing.JComboBox<String> direccion_opciones;
    private javax.swing.JLabel disciplina_label;
    private javax.swing.JComboBox<String> form_largo_opc;
    private javax.swing.JComboBox<String> formato_opciones1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_send;
    private javax.swing.JLabel lable_receive;
    private javax.swing.JComboBox<String> manejocolas_opciones;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JComboBox<String> sincro_receive_options;
    private javax.swing.JComboBox<String> sincro_send_options;
    private javax.swing.JTextField tamano_cola;
    private javax.swing.JLabel tamano_cola_label;
    // End of variables declaration//GEN-END:variables
}
