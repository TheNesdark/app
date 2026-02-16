package com.genoma.plus.controller.laboratorio;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ProtocoloProcedimientoEmpresaDAOImpl;
import com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO;
import com.genoma.plus.dto.laboratorio.ProtocoloProcedimientoEmpresaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDHomologacionProtocolosEmpresa.class */
public class JDHomologacionProtocolosEmpresa extends JDialog {
    private Metodos xmt;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private ProtocoloProcedimientoEmpresaDAO xProtocoloProcedimientoEmpresaDAO;
    private String[] xIdEmpresa;
    private boolean xlleno;
    private long xId;
    private String idProcedimiento;
    private JButton JBGrabar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JComboBox<String> JCBEmpresa;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JDHomologacionProtocolosEmpresa(Frame parent, boolean modal, String idProcedimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xlleno = false;
        this.xId = 0L;
        initComponents();
        springStart();
        setTitle("HOMOLOGACION DE PROTOCOLOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idProcedimiento = idProcedimiento;
        mLlenarComboBox();
        this.JCBEmpresa.setSelectedIndex(-1);
        mNuevo();
    }

    private void springStart() {
        this.xProtocoloProcedimientoEmpresaDAO = (ProtocoloProcedimientoEmpresaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("protocoloProcedimientoEmpresaDAO");
    }

    public void mNuevo() {
        this.xlleno = false;
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            mCargadatos();
        } else {
            mCrearModelo();
        }
        this.xlleno = true;
    }

    public void mGrabar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTDetalle.getRowCount() > 0) {
                if (this.JCBEmpresa.getSelectedIndex() != -1) {
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        if (!this.xmodelo.getValueAt(i, 3).toString().isEmpty() && this.xmodelo.getValueAt(i, 3).toString().matches("^[0-9]*$")) {
                            ProtocoloProcedimientoEmpresaDTO e = new ProtocoloProcedimientoEmpresaDTO();
                            e.setIdProtocoloProcedimiento(Long.valueOf(this.xmodelo.getValueAt(i, 1).toString()).longValue());
                            e.setIdEmpresa(Long.valueOf(this.xIdEmpresa[this.JCBEmpresa.getSelectedIndex()]).longValue());
                            e.setCodigoExterno(Long.valueOf(this.xmodelo.getValueAt(i, 3).toString()).longValue());
                            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 5).toString()).booleanValue()) {
                                e.setId(Long.valueOf(this.xmodelo.getValueAt(i, 0).toString()).longValue());
                                e.setEstado(Boolean.valueOf(this.xmodelo.getValueAt(i, 4).toString()).booleanValue());
                                this.xProtocoloProcedimientoEmpresaDAO.update(e);
                            } else {
                                e.setEstado(true);
                                this.xProtocoloProcedimientoEmpresaDAO.create(e);
                            }
                        }
                    }
                } else {
                    this.xmt.mostrarMensaje("Por favor selecionar una empresa");
                }
            } else {
                this.xmt.mostrarMensaje("Tabla sin registros");
            }
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdProtocoloEmpresa", "Protocolo", "Codigo", "Estado", "Grabado?"}) { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.1
            Class[] types = {Long.class, Long.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    public void mCargadatos() {
        mCrearModelo();
        List<Object[]> ListaConsultas = this.xProtocoloProcedimientoEmpresaDAO.listaProtocolosProcedimientoEmpresa(this.idProcedimiento, this.xIdEmpresa[this.JCBEmpresa.getSelectedIndex()]);
        for (int x = 0; x < ListaConsultas.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            for (int j = 0; j < 6; j++) {
                this.xmodelo.setValueAt(ListaConsultas.get(x)[j], x, j);
            }
        }
    }

    public void mLlenarComboBox() {
        List<Object[]> listaEmpresa = this.xProtocoloProcedimientoEmpresaDAO.ListaEmpresa();
        this.xIdEmpresa = new String[listaEmpresa.size()];
        for (int x = 0; x < listaEmpresa.size(); x++) {
            this.xIdEmpresa[x] = listaEmpresa.get(x)[0].toString();
            this.JCBEmpresa.addItem(listaEmpresa.get(x)[1].toString());
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JBGrabar = new JButton();
        this.JBNuevo = new JButton();
        this.JBSalir = new JButton();
        this.jPanel1 = new JPanel();
        this.JCBEmpresa = new JComboBox<>();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.2
            public void mouseClicked(MouseEvent evt) {
                JDHomologacionProtocolosEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JDHomologacionProtocolosEmpresa.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JDHomologacionProtocolosEmpresa.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JDHomologacionProtocolosEmpresa.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JBNuevo, -2, 175, -2).addGap(18, 18, 18).addComponent(this.JBGrabar, -2, 168, -2).addGap(18, 18, 18).addComponent(this.JBSalir, -2, 161, -2).addContainerGap(24, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2))).addComponent(this.JBSalir, -1, -1, 32767))));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa.6
            public void itemStateChanged(ItemEvent evt) {
                JDHomologacionProtocolosEmpresa.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEmpresa, 0, -1, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEmpresa, -2, 48, -2).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            mCargadatos();
        }
    }
}
