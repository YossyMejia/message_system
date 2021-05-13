package vistas;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;
import modelos.Message;
import utiles.ConfigOptions;
import utiles.HelpMessages;
import utiles.ProcessController;

public class Configuracion_view extends javax.swing.JFrame {
    
     ProcessController configurador;
     private String sincr_send;
     private String sincr_receive;
     private String addressing_type;
     private String message_length_type;
     private String message_content_type;
     private String addressing_direct_receive;
     private String indirect_type;
     private int message_lenght;
     
    public Configuracion_view() {
        
        this.configurador = new ProcessController();
        initComponents();
        this.setHelp();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.turn_off_options(dir_indirecto_ops);
        this.turn_off_options(disciplina_label);
        this.turn_off_options(manejocolas_opciones);
        this.turn_off_options(tamano_cola_label);
        this.turn_off_options(tamano_cola);
        this.turn_off_options(cantidad_mailbox_label);
        this.turn_off_options(cantidad_mailbox);
        this.direcc_cb2.setEnabled(false);
        
        //Haciendo invisibles los botones de ayuda 
        this.queueDisc_help_button.setVisible(false);
        this.tam_cola_help.setVisible(false);
        this.cant_mailbox_help.setVisible(false);
        this.direcc_indirect_help_button.setVisible(false);
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
    
    public void setHelp(){
        this.setHelpMessage(send_help_button, HelpMessages.SINCRONIZATION_SEND.message);
        this.setHelpMessage(send_help_button2, HelpMessages.SINCRONIZATION_RECEIVE.message);
        this.setHelpMessage(format_help_button, HelpMessages.FORMAT_CONTENT.message);
        this.setHelpMessage(format_help_button2, HelpMessages.FORMAT_LENGHT.message);
        this.setHelpMessage(queueDisc_help_button, HelpMessages.QUEQUE_DISCIPLINE.message);
        this.setHelpMessage(cant_proc_help, HelpMessages.PROCESS_QUANTITY.message);
        this.setHelpMessage(tam_cola_help, HelpMessages.QUEUE_SIZE.message);
        this.setHelpMessage(cant_mailbox_help, HelpMessages.MAILBOX_QUANTITY.message);
        this.setHelpMessage(direcc_help_button, HelpMessages.ADDRESSING_TYPE.message);
        this.setHelpMessage(direcc_receive_help_button, HelpMessages.ADDRESSING_RECEIEVE.message);
        this.setHelpMessage(direcc_indirect_help_button, HelpMessages.ADDRESSING_INDIRECT.message);
    }
    
    public void setHelpMessage(javax.swing.JComponent element, String message){
        ToolTipManager.sharedInstance().setDismissDelay(60000);
        element.setToolTipText(message);
        element.setEnabled(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        direcc_cb2 = new javax.swing.JCheckBox();
        disciplina_label = new javax.swing.JLabel();
        cantidad_mailbox_label = new javax.swing.JLabel();
        direccion_opciones = new javax.swing.JComboBox<>();
        manejocolas_opciones = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        dir_indirecto_ops = new javax.swing.JComboBox<>();
        sincro_send_options = new javax.swing.JComboBox<>();
        form_largo_opciones = new javax.swing.JComboBox<>();
        direcc_cb3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
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
        tamano_cola_label = new javax.swing.JLabel();
        cantidad_mailbox = new javax.swing.JTextField();
        label_largo = new javax.swing.JLabel();
        label_contenido1 = new javax.swing.JLabel();
        contenido_opciones = new javax.swing.JComboBox<>();
        label_cantidad_caracteres = new javax.swing.JLabel();
        cantidad_caracteres = new javax.swing.JTextField();
        send_help_button = new javax.swing.JButton();
        send_help_button2 = new javax.swing.JButton();
        format_help_button = new javax.swing.JButton();
        format_help_button2 = new javax.swing.JButton();
        queueDisc_help_button = new javax.swing.JButton();
        cant_proc_help = new javax.swing.JButton();
        tam_cola_help = new javax.swing.JButton();
        cant_mailbox_help = new javax.swing.JButton();
        direcc_help_button = new javax.swing.JButton();
        direcc_receive_help_button = new javax.swing.JButton();
        direcc_indirect_help_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

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
        jPanel1.add(direcc_cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 130, -1));

        disciplina_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        disciplina_label.setForeground(new java.awt.Color(0, 0, 0));
        disciplina_label.setText("Disciplina de manejo de colas");
        jPanel1.add(disciplina_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 220, 30));

        cantidad_mailbox_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cantidad_mailbox_label.setForeground(new java.awt.Color(0, 0, 0));
        cantidad_mailbox_label.setText("Cantidad de mailbox: ");
        jPanel1.add(cantidad_mailbox_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 160, 30));

        direccion_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directo", "Indirecto" }));
        direccion_opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccion_opcionesActionPerformed(evt);
            }
        });
        jPanel1.add(direccion_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, 30));

        manejocolas_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "Prioridad" }));
        jPanel1.add(manejocolas_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 140, 30));

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
        jPanel1.add(dir_indirecto_ops, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 140, 30));

        sincro_send_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "Nonblocking" }));
        sincro_send_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sincro_send_optionsActionPerformed(evt);
            }
        });
        jPanel1.add(sincro_send_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 140, 30));

        form_largo_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Variable" }));
        form_largo_opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_largo_opcionesActionPerformed(evt);
            }
        });
        jPanel1.add(form_largo_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 140, 30));

        direcc_cb3.setBackground(new java.awt.Color(153, 153, 153));
        direcc_cb3.setForeground(new java.awt.Color(0, 0, 0));
        direcc_cb3.setSelected(true);
        direcc_cb3.setText("Explícito");
        direcc_cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_cb3ActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 130, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Formato");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, 30));

        lable_receive.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lable_receive.setForeground(new java.awt.Color(0, 0, 0));
        lable_receive.setText("Receive");
        jPanel1.add(lable_receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cantidad de procesos: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 320, 30));

        tamano_cola.setText("1");
        tamano_cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamano_colaActionPerformed(evt);
            }
        });
        jPanel1.add(tamano_cola, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 260, 30));

        cantidad_procesos.setText("2");
        cantidad_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_procesosActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad_procesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 260, 30));

        crear_btn.setText("Crear sistema de mensajeria");
        crear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btnActionPerformed(evt);
            }
        });
        jPanel1.add(crear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 220, 50));

        sincro_receive_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "Nonblocking", "Prueba de llegada" }));
        sincro_receive_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sincro_receive_optionsActionPerformed(evt);
            }
        });
        jPanel1.add(sincro_receive_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 140, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Sincronización");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

        label_send.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_send.setForeground(new java.awt.Color(0, 0, 0));
        label_send.setText("Send");
        jPanel1.add(label_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 110, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Send");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Receive");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 30));

        tamano_cola_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tamano_cola_label.setForeground(new java.awt.Color(0, 0, 0));
        tamano_cola_label.setText("Tamaño de la cola: ");
        jPanel1.add(tamano_cola_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 140, 30));

        cantidad_mailbox.setText("1");
        cantidad_mailbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_mailboxActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad_mailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 260, 30));

        label_largo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_largo.setForeground(new java.awt.Color(0, 0, 0));
        label_largo.setText("Largo");
        jPanel1.add(label_largo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 110, 30));

        label_contenido1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_contenido1.setForeground(new java.awt.Color(0, 0, 0));
        label_contenido1.setText("Contenido");
        jPanel1.add(label_contenido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 110, 30));

        contenido_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Texto", "Binario" }));
        jPanel1.add(contenido_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 140, 30));

        label_cantidad_caracteres.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_cantidad_caracteres.setForeground(new java.awt.Color(0, 0, 0));
        label_cantidad_caracteres.setText("Cantidad de caracteres: ");
        jPanel1.add(label_cantidad_caracteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 160, 30));

        cantidad_caracteres.setText("100");
        cantidad_caracteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_caracteresActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad_caracteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 170, 30));

        send_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        send_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        send_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        send_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        send_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(send_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 30, 30));

        send_help_button2.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        send_help_button2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        send_help_button2.setMaximumSize(new java.awt.Dimension(0, 0));
        send_help_button2.setMinimumSize(new java.awt.Dimension(0, 0));
        send_help_button2.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(send_help_button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 30, 30));

        format_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        format_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        format_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        format_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        format_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(format_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 30, 30));

        format_help_button2.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        format_help_button2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        format_help_button2.setMaximumSize(new java.awt.Dimension(0, 0));
        format_help_button2.setMinimumSize(new java.awt.Dimension(0, 0));
        format_help_button2.setPreferredSize(new java.awt.Dimension(800, 800));
        format_help_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                format_help_button2ActionPerformed(evt);
            }
        });
        jPanel1.add(format_help_button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 30, 30));

        queueDisc_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        queueDisc_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        queueDisc_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        queueDisc_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        queueDisc_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(queueDisc_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 70, 30, 30));

        cant_proc_help.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        cant_proc_help.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cant_proc_help.setMaximumSize(new java.awt.Dimension(0, 0));
        cant_proc_help.setMinimumSize(new java.awt.Dimension(0, 0));
        cant_proc_help.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(cant_proc_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 30, 30));

        tam_cola_help.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        tam_cola_help.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tam_cola_help.setMaximumSize(new java.awt.Dimension(0, 0));
        tam_cola_help.setMinimumSize(new java.awt.Dimension(0, 0));
        tam_cola_help.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(tam_cola_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 30, 30));

        cant_mailbox_help.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        cant_mailbox_help.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cant_mailbox_help.setMaximumSize(new java.awt.Dimension(0, 0));
        cant_mailbox_help.setMinimumSize(new java.awt.Dimension(0, 0));
        cant_mailbox_help.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.add(cant_mailbox_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 30, 30));

        direcc_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        direcc_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        direcc_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        direcc_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        direcc_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        direcc_help_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_help_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 30, 30));

        direcc_receive_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        direcc_receive_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        direcc_receive_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        direcc_receive_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        direcc_receive_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        direcc_receive_help_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_receive_help_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_receive_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 30, 30));

        direcc_indirect_help_button.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto 1\\message_system\\src\\Imagenes\\help_icon.png")); // NOI18N
        direcc_indirect_help_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        direcc_indirect_help_button.setMaximumSize(new java.awt.Dimension(0, 0));
        direcc_indirect_help_button.setMinimumSize(new java.awt.Dimension(0, 0));
        direcc_indirect_help_button.setPreferredSize(new java.awt.Dimension(800, 800));
        direcc_indirect_help_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcc_indirect_help_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(direcc_indirect_help_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 30, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1150, 780));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\User\\Documentos\\Semestres\\S1 - 2021\\SO\\Proyecto 1\\Proyecto_1\\src\\Imagenes\\fondo.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 1780, 900));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 871));
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
                this.turn_off_options(cantidad_mailbox_label);
                this.turn_off_options(cantidad_mailbox);
                this.queueDisc_help_button.setVisible(false);
                this.tam_cola_help.setVisible(false);
                this.cant_mailbox_help.setVisible(false);
                this.direcc_indirect_help_button.setVisible(false);
                this.direcc_receive_help_button.setVisible(true);
            }
            else if(element == "Indirecto"){
               this.turn_on_options(dir_indirecto_ops);
               this.turn_on_options(disciplina_label);
               this.turn_on_options(manejocolas_opciones);
               this.turn_on_options(tamano_cola_label);
               this.turn_on_options(cantidad_mailbox_label);
               this.turn_on_options(cantidad_mailbox);
               this.turn_on_options(tamano_cola);
               this.turn_off_options(direcc_cb3);
               this.turn_off_options(direcc_cb2);
               this.turn_off_options(lable_receive);
               this.turn_off_options(label_send);
               this.queueDisc_help_button.setVisible(true);
               this.tam_cola_help.setVisible(true);
               this.cant_mailbox_help.setVisible(true);
               this.direcc_receive_help_button.setVisible(false);
               this.direcc_indirect_help_button.setVisible(true);
                
            }
        }
    }//GEN-LAST:event_direccion_opcionesActionPerformed

    private void tamano_colaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamano_colaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamano_colaActionPerformed

    private void cantidad_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_procesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_procesosActionPerformed

    private void crear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btnActionPerformed
        int procesos = Integer.parseInt(cantidad_procesos.getText());
        int mailboxes = Integer.parseInt(cantidad_mailbox.getText());
        int largo_cola = Integer.parseInt(tamano_cola.getText());
        this.sincr_send = sincro_send_options.getSelectedItem().toString();
        this.sincr_receive = sincro_receive_options.getSelectedItem().toString();
        this.addressing_type = direccion_opciones.getSelectedItem().toString();
        this.indirect_type = dir_indirecto_ops.getSelectedItem().toString();
        
        if(direcc_cb3.isSelected()){
            this.addressing_direct_receive = direcc_cb3.getText();
        }
        else if(direcc_cb2.isSelected()){
            this.addressing_direct_receive = direcc_cb2.getText();
        }
        else {
            this.addressing_direct_receive = direcc_cb3.getText();
        }
        
        //Set of the options to the message
        this.message_length_type = form_largo_opciones.getSelectedItem().toString();
        this.message_content_type = contenido_opciones.getSelectedItem().toString();
        this.message_lenght = Integer.parseInt(cantidad_caracteres.getText().toString());
        
        if(this.message_length_type == ConfigOptions.LENGTH_FIXED.option){
            Message set_message_options = new Message(ConfigOptions.LENGTH_FIXED.option, 
            this.message_lenght,this.message_content_type);
        }
        
        else if(this.message_length_type == ConfigOptions.LENGTH_VARIABLE.option){
            Message set_message_options = new Message(ConfigOptions.LENGTH_VARIABLE.option, 
            this.message_content_type);
        }
        
        if (this.addressing_type == ConfigOptions.ADDRESSING_INDIRECT.option) {
            this.configurador.setCantidad_mailboxes(mailboxes);
            this.configurador.setLargo_cola(largo_cola);
            this.configurador.setIndirect_opt(indirect_type);
        }
        
        this.configurador.setConfig(this.sincr_receive, this.sincr_send,
                this.addressing_type,this.addressing_direct_receive, procesos);
        this.configurador.create();
        this.dispose();
        Principal_view principal_v = new Principal_view(configurador);
        principal_v.setVisible(true);
    }//GEN-LAST:event_crear_btnActionPerformed

    private void sincro_receive_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sincro_receive_optionsActionPerformed
         this.sincr_receive = sincro_receive_options.getSelectedItem().toString();
    }//GEN-LAST:event_sincro_receive_optionsActionPerformed

    private void cantidad_mailboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_mailboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_mailboxActionPerformed

    private void cantidad_caracteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_caracteresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_caracteresActionPerformed

    private void form_largo_opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_largo_opcionesActionPerformed
        String element = form_largo_opciones.getSelectedItem().toString();
        if (element != null) {
            if(element == "Fijo"){
                this.turn_on_options(cantidad_caracteres);
                this.turn_on_options(label_cantidad_caracteres);
            }
            else if(element == "Variable"){
               this.turn_off_options(cantidad_caracteres);
               this.turn_off_options(label_cantidad_caracteres);
            }
        }
    }//GEN-LAST:event_form_largo_opcionesActionPerformed

    private void format_help_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_format_help_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_format_help_button2ActionPerformed

    private void direcc_receive_help_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcc_receive_help_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direcc_receive_help_buttonActionPerformed

    private void direcc_help_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcc_help_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direcc_help_buttonActionPerformed

    private void direcc_indirect_help_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcc_indirect_help_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direcc_indirect_help_buttonActionPerformed

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
    private javax.swing.JButton cant_mailbox_help;
    private javax.swing.JButton cant_proc_help;
    private javax.swing.JTextField cantidad_caracteres;
    private javax.swing.JTextField cantidad_mailbox;
    private javax.swing.JLabel cantidad_mailbox_label;
    private javax.swing.JTextField cantidad_procesos;
    private javax.swing.JComboBox<String> contenido_opciones;
    public javax.swing.JButton crear_btn;
    private javax.swing.JComboBox<String> dir_indirecto_ops;
    public javax.swing.JCheckBox direcc_cb2;
    public javax.swing.JCheckBox direcc_cb3;
    private javax.swing.JButton direcc_help_button;
    private javax.swing.JButton direcc_indirect_help_button;
    private javax.swing.JButton direcc_receive_help_button;
    private javax.swing.JComboBox<String> direccion_opciones;
    private javax.swing.JLabel disciplina_label;
    private javax.swing.JComboBox<String> form_largo_opciones;
    private javax.swing.JButton format_help_button;
    private javax.swing.JButton format_help_button2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_cantidad_caracteres;
    private javax.swing.JLabel label_contenido1;
    private javax.swing.JLabel label_largo;
    private javax.swing.JLabel label_send;
    private javax.swing.JLabel lable_receive;
    private javax.swing.JComboBox<String> manejocolas_opciones;
    private javax.swing.JButton queueDisc_help_button;
    private javax.swing.JButton send_help_button;
    private javax.swing.JButton send_help_button2;
    private javax.swing.JComboBox<String> sincro_receive_options;
    private javax.swing.JComboBox<String> sincro_send_options;
    private javax.swing.JButton tam_cola_help;
    private javax.swing.JTextField tamano_cola;
    private javax.swing.JLabel tamano_cola_label;
    // End of variables declaration//GEN-END:variables
}
