
package vistas;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ToolTipManager;
import modelos.Process;
import modelos.Mailbox;
import utiles.ConfigOptions;
import utiles.HelpMessages;
import utiles.ProcessController;

/**
 *
 * @author XPC
 */
public class Principal_view extends javax.swing.JFrame {

    public ProcessController configurador;
    public File command__file;
    public int n_command;
    
    
    public Principal_view(ProcessController configurador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.configurador = configurador;
        this.fill_cb();
        this.fill_cb_mb();
        command_line_field.setEditable(false);
        this.displayQueueOpt();
        this.help_messages();
    }
    
    //Fill the combobox processes with data
    public void fill_cb(){
        ArrayList<Process> procesos = this.configurador.getProcesos();
        for (Process proceso: procesos) {
            this.cb_procesos.addItem(proceso.getProcess_id());
        }
    }

    public void fill_cb_mb(){
        ArrayList<Mailbox> mailboxes = this.configurador.getMailboxes();
        for (Mailbox mailbox: mailboxes) {
            this.cb_colas.addItem(mailbox.getMailbox_id());
        }
    }
    
    public void displayQueueOpt(){
        if(configurador.getAddressing_type().equals(ConfigOptions.ADDRESSING_DIRECT.option)){
            this.turn_off_options(this.cb_colas);
            this.turn_off_options(this.cola_label);
            this.turn_off_options(this.log_cola_btn);
        }
    }
    
    //Funcion encargada de deshabilitar componentes y hacerlos invisibles
    public void turn_off_options(javax.swing.JComponent element) {
        element.setVisible(false);
        element.setEnabled(false);
    }
    
    public void help_messages(){
        this.command_help_btn.setEnabled(false);
        this.setHelpMessage(command_help_btn, HelpMessages.COMMAND_HELP.message);
        this.setHelpMessage(process_help_btn, HelpMessages.PROCESS_LOG_HELP.message);
    }
    
    public void setHelpMessage(javax.swing.JComponent element, String message){
        ToolTipManager.sharedInstance().setDismissDelay(60000);
        element.setToolTipText(message);
        element.setEnabled(false);
    }

    public File getCommand__file() {
        return command__file;
    }

    public void setCommand__file(File command__file) {
        this.command__file = command__file;
    }

    public int getN_command() {
        return n_command;
    }

    public void setN_command(int n_command) {
        this.n_command = n_command;
    }

    public void load_file(){
        
        this.configurador.setCommand_file(this.command__file);
        this.configurador.setN_stop(this.n_command);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
        Date date = new Date();  
        String time = formatter.format(date);
        String message = time+" ARCHIVO_CARGADO: Se ha cargado el documento '"
                + this.command__file.getName() + "' al programa\n\n";
        this.writeInConsole(message);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_procesos = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_colas = new javax.swing.JComboBox<>();
        log_cola_btn = new javax.swing.JButton();
        log_proceso_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        command_line_field = new javax.swing.JTextArea();
        cola_label = new javax.swing.JLabel();
        command_field = new javax.swing.JTextField();
        send_command = new javax.swing.JButton();
        command_help_btn = new javax.swing.JButton();
        process_help_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        reset_btn = new javax.swing.JMenu();
        leer_btn = new javax.swing.JMenuItem();
        reiniciar_button = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 635, -1, -1));

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Procesos");

        cb_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_procesosActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Linea de comandos");

        log_cola_btn.setText("Log cola");
        log_cola_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_cola_btnActionPerformed(evt);
            }
        });

        log_proceso_btn.setText("Log proceso");
        log_proceso_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_proceso_btnActionPerformed(evt);
            }
        });

        command_line_field.setBackground(new java.awt.Color(255, 255, 255));
        command_line_field.setColumns(20);
        command_line_field.setForeground(new java.awt.Color(0, 0, 0));
        command_line_field.setRows(5);
        jScrollPane2.setViewportView(command_line_field);

        cola_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cola_label.setForeground(new java.awt.Color(0, 0, 0));
        cola_label.setText("Colas");

        send_command.setText("Enviar");
        send_command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_commandActionPerformed(evt);
            }
        });

        command_help_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        command_help_btn.setMaximumSize(new java.awt.Dimension(0, 0));
        command_help_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        command_help_btn.setPreferredSize(new java.awt.Dimension(800, 800));

        process_help_btn.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        process_help_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        process_help_btn.setMaximumSize(new java.awt.Dimension(0, 0));
        process_help_btn.setMinimumSize(new java.awt.Dimension(0, 0));
        process_help_btn.setPreferredSize(new java.awt.Dimension(800, 800));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(command_help_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_colas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_procesos, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(log_proceso_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(log_cola_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addComponent(process_help_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(command_field, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(send_command, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(cola_label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(880, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(command_help_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_procesos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(log_proceso_btn))
                            .addComponent(process_help_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_colas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(log_cola_btn))
                        .addGap(119, 119, 119)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(command_field, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send_command))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(cola_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(507, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 1050, 730));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 870));

        reset_btn.setText("Opciones");

        leer_btn.setText("Leer archivo");
        leer_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leer_btnActionPerformed(evt);
            }
        });
        reset_btn.add(leer_btn);

        reiniciar_button.setText("Reiniciar");
        reiniciar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciar_buttonActionPerformed(evt);
            }
        });
        reset_btn.add(reiniciar_button);

        jMenuBar1.add(reset_btn);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log_cola_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_cola_btnActionPerformed
        // TODO add your handling code here:
        String mailboxID = cb_colas.getSelectedItem().toString();
        Mailbox mailbox_Selected = this.configurador.getMailboxByID(mailboxID);
        MailboxLog_view mailboxlog_v = new MailboxLog_view (mailbox_Selected);
        mailboxlog_v.setVisible(true);
        
    }//GEN-LAST:event_log_cola_btnActionPerformed

    
    private void log_proceso_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_proceso_btnActionPerformed
        // TODO add your handling code here:
        String processID = cb_procesos.getSelectedItem().toString();
        Process process_Selected = this.configurador.getProcessByID(processID);
        ProcessLog_view processlog_v = new ProcessLog_view(process_Selected);
        processlog_v.setVisible(true);
    }//GEN-LAST:event_log_proceso_btnActionPerformed

    private void reiniciar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciar_buttonActionPerformed
        this.dispose();
        //configurador limpiar archivo de logs
        Configuracion_view config_v = new Configuracion_view();
        config_v.setVisible(true);
    }//GEN-LAST:event_reiniciar_buttonActionPerformed

    private void send_commandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_commandActionPerformed
        //Obtener la hora del sistema y el comando para enviarlo al configurador
        String command = command_field.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
        Date date = new Date();  
        String time = formatter.format(date);
        this.configurador.executeCommand(command, time, this);
    }//GEN-LAST:event_send_commandActionPerformed

    public void writeInConsole(String logMessage){
        command_line_field.append(logMessage + "\n");
    }
    
    private void leer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leer_btnActionPerformed
        FileReader_view file_reader_v = new FileReader_view(this);
        file_reader_v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_leer_btnActionPerformed

    private void cb_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_procesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_procesosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_colas;
    private javax.swing.JComboBox<String> cb_procesos;
    private javax.swing.JLabel cola_label;
    private javax.swing.JTextField command_field;
    private javax.swing.JButton command_help_btn;
    private javax.swing.JTextArea command_line_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem leer_btn;
    private javax.swing.JButton log_cola_btn;
    private javax.swing.JButton log_proceso_btn;
    private javax.swing.JButton process_help_btn;
    private javax.swing.JMenuItem reiniciar_button;
    private javax.swing.JMenu reset_btn;
    private javax.swing.JButton send_command;
    // End of variables declaration//GEN-END:variables
}
