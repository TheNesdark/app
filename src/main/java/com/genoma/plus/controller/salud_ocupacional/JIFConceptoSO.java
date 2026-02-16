package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO;
import com.genoma.plus.dto.salud_ocupacional.TipoConceptoSoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIFConceptoSO.class */
public class JIFConceptoSO extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private CertificadoSoDAO xCertificadoSoDAO;
    private ButtonGroup JBGOpciones;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JPanel JPOpciones;
    private JRadioButton JRDAptitudA;
    private JRadioButton JRDEgreso;
    private JRadioButton JRDIngreso;
    private JRadioButton JRDMedicinaD;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private int xtipo = 0;

    public JIFConceptoSO() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xCertificadoSoDAO = (CertificadoSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("certificadoSoDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JRDEgreso.setSelected(true);
        this.xtipo = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoConceptoSoDTO e = new TipoConceptoSoDTO();
                if (Principal.txtNo.getText().isEmpty()) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xtipo));
                    e.setEstado(this.xestado);
                    this.xCertificadoSoDAO.createTipoConcepto(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xtipo));
                    e.setEstado(this.xestado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xCertificadoSoDAO.updateTipoConcepto(e);
                }
            }
            mNuevo();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Estado"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        List<TipoConceptoSoDTO> list = this.xCertificadoSoDAO.listTipoConcepto();
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getTipo(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JPOpciones = new JPanel();
        this.JRDEgreso = new JRadioButton();
        this.JRDIngreso = new JRadioButton();
        this.JRDMedicinaD = new JRadioButton();
        this.JRDAptitudA = new JRadioButton();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTOS DE SALUD OCUPACIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipoconceptoso");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPOpciones.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones.add(this.JRDEgreso);
        this.JRDEgreso.setFont(new Font("Arial", 1, 12));
        this.JRDEgreso.setSelected(true);
        this.JRDEgreso.setText("Egreso");
        this.JRDEgreso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.2
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoSO.this.JRDEgresoActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRDIngreso);
        this.JRDIngreso.setFont(new Font("Arial", 1, 12));
        this.JRDIngreso.setText("Ingreso");
        this.JRDIngreso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.3
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoSO.this.JRDIngresoActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRDMedicinaD);
        this.JRDMedicinaD.setFont(new Font("Arial", 1, 12));
        this.JRDMedicinaD.setText("Medicina Deporte");
        this.JRDMedicinaD.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.4
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoSO.this.JRDMedicinaDActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRDAptitudA);
        this.JRDAptitudA.setFont(new Font("Arial", 1, 12));
        this.JRDAptitudA.setText("Aptitud Altura");
        this.JRDAptitudA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.5
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoSO.this.JRDAptitudAActionPerformed(evt);
            }
        });
        GroupLayout JPOpcionesLayout = new GroupLayout(this.JPOpciones);
        this.JPOpciones.setLayout(JPOpcionesLayout);
        JPOpcionesLayout.setHorizontalGroup(JPOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOpcionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JRDEgreso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addComponent(this.JRDIngreso).addGap(26, 26, 26).addComponent(this.JRDMedicinaD).addGap(27, 27, 27).addComponent(this.JRDAptitudA).addContainerGap()));
        JPOpcionesLayout.setVerticalGroup(JPOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOpcionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRDEgreso).addComponent(this.JRDIngreso).addComponent(this.JRDMedicinaD).addComponent(this.JRDAptitudA)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.6
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoSO.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPOpciones, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10).addComponent(this.JPOpciones, -2, -1, -2).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO.7
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoSO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPDatos, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 237, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if ("EGRESO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRDEgreso.setSelected(true);
                this.xtipo = 0;
            } else if ("INGRESO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRDIngreso.setSelected(true);
                this.xtipo = 1;
            } else if ("MEDICINA DEL DEPORTE".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRDMedicinaD.setSelected(true);
                this.xtipo = 2;
            } else {
                this.JRDAptitudA.setSelected(true);
                this.xtipo = 3;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xestado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRDAptitudAActionPerformed(ActionEvent evt) {
        this.xtipo = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRDEgresoActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRDIngresoActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRDMedicinaDActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }
}
