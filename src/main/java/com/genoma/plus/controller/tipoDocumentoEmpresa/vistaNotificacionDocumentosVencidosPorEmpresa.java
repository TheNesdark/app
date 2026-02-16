package com.genoma.plus.controller.tipoDocumentoEmpresa;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.TablaRender;
import com.genoma.plus.jpa.projection.ITipoDocumentoEmpresa;
import com.genoma.plus.jpa.service.ITipoDocumentoEmpresaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.accessibility.AccessibleContext;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/vistaNotificacionDocumentosVencidosPorEmpresa.class */
public class vistaNotificacionDocumentosVencidosPorEmpresa extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    long idEmpresa;
    List<ITipoDocumentoEmpresa> listaDocumentosVencidos;
    private JButton JBTCorreo;
    private JButton JBTSalir;
    private JTable JTDetalle;
    private JTextArea jAreaMensaje;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField jTxtAsunto;
    private JTextField jTxtDestinatario;
    private final ITipoDocumentoEmpresaService xITipoDocumentoEmpresaService = (ITipoDocumentoEmpresaService) Principal.contexto.getBean(ITipoDocumentoEmpresaService.class);
    private Metodos xmt = new Metodos();

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public vistaNotificacionDocumentosVencidosPorEmpresa() {
        initComponents();
    }

    public vistaNotificacionDocumentosVencidosPorEmpresa(Frame parent, boolean modal, long xidEmpresa) {
        this.idEmpresa = xidEmpresa;
        boolean hayDocumentosVencidos = this.xITipoDocumentoEmpresaService.hayDocumentosActivosVencidos(this.idEmpresa);
        initComponents();
        if (!hayDocumentosVencidos) {
            dispose();
            return;
        }
        setVisible(true);
        mNuevo();
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa.1
            public void mouseClicked(MouseEvent e) {
                int fila = vistaNotificacionDocumentosVencidosPorEmpresa.this.JTDetalle.rowAtPoint(e.getPoint());
                int columna = vistaNotificacionDocumentosVencidosPorEmpresa.this.JTDetalle.columnAtPoint(e.getPoint());
                if (vistaNotificacionDocumentosVencidosPorEmpresa.this.JTDetalle.getModel().getColumnClass(columna).equals(JButton.class)) {
                    vistaNotificacionDocumentosVencidosPorEmpresa.this.xmt.AbrirArchivosblob(vistaNotificacionDocumentosVencidosPorEmpresa.this.listaDocumentosVencidos.get(fila).getSoporte(), "Soporte", ".pdf", true);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCorreo = new JButton();
        this.JBTSalir = new JButton();
        this.jPanel1 = new JPanel();
        this.jTxtDestinatario = new JTextField();
        this.jTxtAsunto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.jAreaMensaje = new JTextArea();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Documentos Vencidos", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa.2
            public void mouseClicked(MouseEvent evt) {
                vistaNotificacionDocumentosVencidosPorEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBTCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTCorreo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo.png")));
        this.JBTCorreo.setText("Enviar Correo");
        this.JBTCorreo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                vistaNotificacionDocumentosVencidosPorEmpresa.this.JBTCorreoActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                vistaNotificacionDocumentosVencidosPorEmpresa.this.JBTSalirActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Mensaje de Correo", 0, 0, new Font("Arial", 0, 12)));
        this.jTxtDestinatario.setFont(new Font("Arial", 1, 12));
        this.jTxtDestinatario.setBorder(BorderFactory.createTitledBorder((Border) null, "Destinatario", 0, 0, new Font("Arial", 0, 12)));
        this.jTxtAsunto.setFont(new Font("Arial", 1, 12));
        this.jTxtAsunto.setBorder(BorderFactory.createTitledBorder((Border) null, "Asunto", 0, 0, new Font("Arial", 0, 12)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTxtDestinatario).addComponent(this.jTxtAsunto));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jTxtDestinatario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTxtAsunto, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jScrollPane2.setHorizontalScrollBarPolicy(31);
        this.jAreaMensaje.setColumns(20);
        this.jAreaMensaje.setFont(new Font("Arial", 1, 12));
        this.jAreaMensaje.setRows(5);
        this.jScrollPane2.setViewportView(this.jAreaMensaje);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 576, 32767).addComponent(this.jScrollPane2).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(140, 140, 140).addComponent(this.JBTCorreo).addGap(42, 42, 42).addComponent(this.JBTSalir, -2, 131, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 106, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSalir, -2, 55, -2).addComponent(this.JBTCorreo)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() == -1 || evt.getClickCount() == 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCorreoActionPerformed(ActionEvent evt) {
        String remite;
        String destinatario = this.jTxtDestinatario.getText();
        String asunto = this.jTxtAsunto.getText();
        String cuerpo = this.jAreaMensaje.getText();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            remite = "noresponder@fundacionpanzenu.org.co";
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
            remite = "noresponder@clinicapajonal.com";
        } else {
            System.out.println("Funcionalidad no implementada");
            return;
        }
        NotificacionEmail correo = new NotificacionEmail();
        if (correo.Send(destinatario, cuerpo, remite, asunto)) {
            JOptionPane.showMessageDialog(this, "Mensaje Enviado");
        } else {
            JOptionPane.showMessageDialog(this, "Error al enviar mensaje");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private DefaultTableModel mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Doc", "Tipo Doc", "Soporte", "Observacion"}) { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa.5
            Class[] types = {String.class, String.class, String.class, JButton.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        return this.xmodelo;
    }

    private void mNuevo() {
        this.JTDetalle.removeAll();
        this.listaDocumentosVencidos = this.xITipoDocumentoEmpresaService.listaDocumentosActivosVencidos(this.idEmpresa);
        System.err.println("tamaño lista" + this.listaDocumentosVencidos.size());
        mLlenarTabla(this.listaDocumentosVencidos);
        this.jTxtDestinatario.setText(this.xITipoDocumentoEmpresaService.obtenerCorreoEmpresa(this.idEmpresa));
        this.jTxtAsunto.setText("Notificación de documentos vencidos");
        String correoCopiaDocumentos = Principal.usuarioSistemaDTO.getCorreoUsuario();
        String nombreFuncionario = Principal.usuarioSistemaDTO.getNombreUsuario();
        String cargoFuncionario = Principal.usuarioSistemaDTO.getNombreCargoUsuario();
        String cuerpo = "Estimado proveedor, le informamos que los siguientes documentos se encuentran vencidos: \n \n" + getNombresDocumentosVencidos(this.JTDetalle, 2) + "por favor enviar al correo " + correoCopiaDocumentos + " copias actualizadas de los documentos. \n\n" + nombreFuncionario + "\n" + cargoFuncionario;
        this.jAreaMensaje.setText(cuerpo);
    }

    public JTable mLlenarTabla(List<ITipoDocumentoEmpresa> listaDocumentosVencidos) {
        this.JTDetalle.removeAll();
        DefaultTableModel modeloTabla = mCrearModeloTabla();
        this.JTDetalle.setModel(modeloTabla);
        this.JTDetalle.setDefaultRenderer(Object.class, new TablaRender());
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        if (listaDocumentosVencidos != null && !listaDocumentosVencidos.isEmpty()) {
            for (int i = 0; i < listaDocumentosVencidos.size(); i++) {
                modeloTabla.addRow(this.xDato);
                modeloTabla.setValueAt(Long.valueOf(listaDocumentosVencidos.get(i).getId()), i, 0);
                modeloTabla.setValueAt(listaDocumentosVencidos.get(i).getFechaDocumento(), i, 1);
                modeloTabla.setValueAt(listaDocumentosVencidos.get(i).getNbre(), i, 2);
                modeloTabla.setValueAt(new JButton("Soporte"), i, 3);
                modeloTabla.setValueAt(listaDocumentosVencidos.get(i).getObservacion(), i, 4);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
            }
        } else {
            System.err.println("lista Nula o Vacia");
        }
        return this.JTDetalle;
    }

    private String getNombresDocumentosVencidos(JTable tabla, int columnaRecorrer) {
        String nombres = "";
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, columnaRecorrer) != null) {
                nombres = nombres + " " + tabla.getValueAt(i, columnaRecorrer).toString() + "\n";
            }
        }
        return nombres + "\n";
    }

    public boolean tablaCoincideConLista(List<ITipoDocumentoEmpresa> lista, JTable tabla) {
        if (tabla.getRowCount() != lista.size()) {
            return false;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (!tabla.getValueAt(i, 0).equals(Long.valueOf(lista.get(i).getId()))) {
                return false;
            }
        }
        return true;
    }
}
