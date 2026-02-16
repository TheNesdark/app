package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GDetalleIngresoCyd;
import com.genoma.plus.jpa.entities.GPatologiaPrograma;
import com.genoma.plus.jpa.entities.GdetallePatologiacyd;
import com.genoma.plus.jpa.service.IngresoCYDService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JMBuscarPatologiaPorPrograma.class */
public class JMBuscarPatologiaPorPrograma extends JDialog {
    private final IngresoCYDService service;
    private final Integer programa;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private Metodos xmts;
    private final String usuarioSist;
    private JP_IngresoProgramaCyD ingresocyd;
    private List<GPatologiaPrograma> listPatologias;
    private GdetallePatologiacyd detallePatologia;
    private List<GdetallePatologiacyd> ListDdetallePatologia;
    private JButton JBOk;
    private JButton JBSalir;
    private JTable JTDetallePatologias;
    private JTable JTDetallePatologiasAgregadas;
    private JTextField JTFCie10;
    private JTextField JTFNombreCie10;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JMBuscarPatologiaPorPrograma(Frame parent, boolean modal, JP_IngresoProgramaCyD cyd) {
        super(parent, modal);
        this.service = (IngresoCYDService) Principal.contexto.getBean(IngresoCYDService.class);
        this.programa = 4;
        this.xmts = new Metodos();
        this.usuarioSist = Principal.usuarioSistemaDTO.getLogin();
        this.ListDdetallePatologia = new ArrayList();
        initComponents();
        this.ingresocyd = cyd;
        setLocationRelativeTo(null);
        if (((GDetalleIngresoCyd) this.ingresocyd.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList() != null) {
            this.ListDdetallePatologia = ((GDetalleIngresoCyd) this.ingresocyd.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList();
        }
        mCargarTablaPatologiasSeleccionadas();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloPatologias() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "CIE10", "Nombre"}) { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetallePatologias.setModel(this.xmodelo);
        this.JTDetallePatologias.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetallePatologias.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetallePatologias.getColumnModel().getColumn(2).setPreferredWidth(600);
    }

    private void mCargarTabla() {
        mCrearModeloPatologias();
        for (int i = 0; i < this.listPatologias.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(this.listPatologias.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(this.listPatologias.get(i).getIdPatologia().getId(), i, 1);
            this.xmodelo.setValueAt(this.listPatologias.get(i).getIdPatologia().getNbre(), i, 2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloPatologiasSeleccionadas() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "CIE10", "Nombre"}) { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.2
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetallePatologiasAgregadas.setModel(this.xmodelo1);
        this.JTDetallePatologiasAgregadas.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetallePatologiasAgregadas.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetallePatologiasAgregadas.getColumnModel().getColumn(2).setPreferredWidth(600);
    }

    private void mCargarTablaPatologiasSeleccionadas() {
        mCrearModeloPatologiasSeleccionadas();
        for (int i = 0; i < this.ListDdetallePatologia.size(); i++) {
            this.xmodelo1.addRow(this.xdatos);
            try {
                this.xmodelo1.setValueAt(this.ListDdetallePatologia.get(i).getId(), i, 0);
            } catch (Exception e) {
                this.xmodelo1.setValueAt("*", i, 0);
            }
            this.xmodelo1.setValueAt(this.ListDdetallePatologia.get(i).getIdPatologiaPrograma().getIdPatologia().getId(), i, 1);
            this.xmodelo1.setValueAt(this.ListDdetallePatologia.get(i).getIdPatologiaPrograma().getIdPatologia().getNbre(), i, 2);
        }
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.JTFCie10 = new JTextField();
        this.JTFNombreCie10 = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetallePatologiasAgregadas = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetallePatologias = new JTable();
        this.JBSalir = new JButton();
        this.JBOk = new JButton();
        setDefaultCloseOperation(2);
        setModal(true);
        setName("buscarPatologiaPorPrograma");
        this.jLabel1.setFont(new Font("Arial", 1, 24));
        this.jLabel1.setForeground(Color.blue);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("BUSCAR PATOLOGIA POR PROGRAMA");
        this.jLabel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel1.setName("buscarPatologia");
        this.JTFCie10.setFont(new Font("Arial", 1, 18));
        this.JTFCie10.setHorizontalAlignment(2);
        this.JTFCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCie10.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.3
            public void keyReleased(KeyEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JTFCie10KeyReleased(evt);
            }
        });
        this.JTFNombreCie10.setFont(new Font("Arial", 1, 18));
        this.JTFNombreCie10.setHorizontalAlignment(2);
        this.JTFNombreCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreCie10.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.4
            public void keyReleased(KeyEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JTFNombreCie10KeyReleased(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "PATOLOGIAS SELECCIONADAS", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTDetallePatologiasAgregadas.setFont(new Font("Arial", 1, 12));
        this.JTDetallePatologiasAgregadas.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.5
            public void keyPressed(KeyEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JTDetallePatologiasAgregadasKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetallePatologiasAgregadas);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "PATOLOGIAS", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTDetallePatologias.setFont(new Font("Arial", 1, 12));
        this.JTDetallePatologias.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.6
            public void mouseClicked(MouseEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JTDetallePatologiasMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetallePatologias);
        this.JBSalir.setFont(new Font("Arial", 1, 14));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("SALIR");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.7
            public void actionPerformed(ActionEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBOk.setFont(new Font("Arial", 1, 14));
        this.JBOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBOk.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JMBuscarPatologiaPorPrograma.8
            public void actionPerformed(ActionEvent evt) {
                JMBuscarPatologiaPorPrograma.this.JBOkActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 729, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFCie10, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombreCie10)).addComponent(this.jScrollPane1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBOk, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -2, 111, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCie10, -2, -1, -2).addComponent(this.JTFNombreCie10, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBSalir, -2, 43, -2).addComponent(this.JBOk, -2, 43, -2)).addContainerGap(14, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePatologiasMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Boolean validarGuardar = true;
            int i = 0;
            while (i < this.ListDdetallePatologia.size()) {
                if (this.ListDdetallePatologia.get(i).getIdPatologiaPrograma().getId().equals(this.listPatologias.get(this.JTDetallePatologias.getSelectedRow()).getId())) {
                    validarGuardar = false;
                    i = this.ListDdetallePatologia.size();
                }
                i++;
            }
            if (validarGuardar.booleanValue()) {
                this.detallePatologia = new GdetallePatologiacyd();
                this.detallePatologia.setIdDetalleIngreso(new GDetalleIngresoCyd());
                this.detallePatologia.setEstado(true);
                this.detallePatologia.setFecha(this.xmts.getFechaActual());
                this.detallePatologia.setIdPatologiaPrograma(this.listPatologias.get(this.JTDetallePatologias.getSelectedRow()));
                this.detallePatologia.setUsuarioSistema(this.usuarioSist);
                this.ListDdetallePatologia.add(this.detallePatologia);
                mCargarTablaPatologiasSeleccionadas();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        if (((GDetalleIngresoCyd) this.ingresocyd.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList() != null) {
            this.ListDdetallePatologia = ((GDetalleIngresoCyd) this.ingresocyd.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList();
        }
        this.ingresocyd.mCargarTabla();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBOkActionPerformed(ActionEvent evt) {
        ((GDetalleIngresoCyd) this.ingresocyd.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setGdetallePatologiacydList(this.ListDdetallePatologia);
        this.ingresocyd.listaDetallePatologias = this.ListDdetallePatologia;
        this.ingresocyd.mCargarTabla();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10KeyReleased(KeyEvent evt) {
        this.listPatologias = new ArrayList();
        this.listPatologias = this.service.buscarPatologiaPorCie10(this.JTFCie10.getText(), this.programa);
        mCargarTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCie10KeyReleased(KeyEvent evt) {
        this.listPatologias = new ArrayList();
        this.listPatologias = this.service.buscarPatologiaPorNombre(this.JTFNombreCie10.getText(), this.programa);
        mCargarTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePatologiasAgregadasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.ListDdetallePatologia.get(this.JTDetallePatologiasAgregadas.getSelectedRow()).getId() == null) {
            int v = JOptionPane.showConfirmDialog(this, "DESEA ELIMINAR PATOLOGIA", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (v == 0) {
                this.ListDdetallePatologia.remove(this.JTDetallePatologiasAgregadas.getSelectedRow());
                mCargarTablaPatologiasSeleccionadas();
            }
        }
    }
}
