package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO;
import com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl;
import com.genoma.plus.dto.contabilidad.PucTipoDeInformeDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFPucNifTipoInforme.class */
public class JIFPucNifTipoInforme extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private PucTipoDeInformesDAO xPucTipoDeInformesDAO;
    private String[] xidTipo;
    private JComboBox<String> JCBTipoInforme;
    private JCheckBox JCEstado;
    private JTextArea JTAConsultaSQL;
    private JTable JTDetalle;
    private JTextField JTFCodigoConcepto;
    private JTextField JTFCodigoPuc;
    private JTextField JTFNombreConcepto;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JIFPucNifTipoInforme() {
        initComponents();
        springStart();
        mllenarCombo();
        mNuevo();
    }

    private void springStart() {
        this.xPucTipoDeInformesDAO = (PucTipoDeInformeDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("PucTipodeInformeDAO");
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTipoInforme = new JComboBox<>();
        this.JTFCodigoConcepto = new JTextField();
        this.JTFCodigoPuc = new JTextField();
        this.JTFNombreConcepto = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConsultaSQL = new JTextArea();
        this.JCEstado = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Puc Niif  Tipo de Informe");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFPucTipoInforme");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPucNifTipoInforme.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFPucNifTipoInforme.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBTipoInforme.setFont(new Font("Arial", 1, 12));
        this.JCBTipoInforme.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Informe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoConcepto.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoPuc.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoPuc.setForeground(Color.black);
        this.JTFCodigoPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreConcepto.setFont(new Font("Arial", 1, 12));
        this.JTFNombreConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAConsultaSQL.setColumns(20);
        this.JTAConsultaSQL.setFont(new Font("Arial", 1, 12));
        this.JTAConsultaSQL.setRows(5);
        this.JTAConsultaSQL.setBorder(BorderFactory.createTitledBorder((Border) null, "Consulta SQL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAConsultaSQL);
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCBTipoInforme, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 382, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoPuc, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCodigoConcepto, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombreConcepto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCEstado)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoConcepto, -2, 43, -2).addComponent(this.JTFCodigoPuc, -2, 50, -2)).addComponent(this.JTFNombreConcepto, -2, 50, -2).addComponent(this.JCEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoInforme, -2, 50, -2).addComponent(this.jScrollPane1, -2, 83, -2)).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFPucNifTipoInforme.2
            public void mouseClicked(MouseEvent evt) {
                JIFPucNifTipoInforme.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 0, 32767).addComponent(this.jScrollPane2, -1, 629, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 181, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFCodigoPuc.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        this.JTFCodigoConcepto.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        this.JTFNombreConcepto.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        this.JTAConsultaSQL.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
        this.JCBTipoInforme.setSelectedIndex(idCombo(((Integer) this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1)).intValue()));
        this.JCEstado.setSelected(((Boolean) this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7)).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public int idCombo(int id) {
        int pos = 0;
        for (int x = 0; x < this.xidTipo.length; x++) {
            if (id == Integer.parseInt(this.xidTipo[x])) {
                pos = x;
            }
        }
        return pos;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "idTipoInforme", "Tipo Informe", "Codigo Puc", "Codigo Concepto", "Nombre Concepto", "Consulta SQL", "estado"}) { // from class: com.genoma.plus.controller.contabilidad.JIFPucNifTipoInforme.3
            Class[] types = {Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(260);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        List<Object[]> lista = this.xPucTipoDeInformesDAO.listaPucTdeInforme();
        mCrearModelo();
        for (int x = 0; x < lista.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 8; j++) {
                this.xmodelo.setValueAt(lista.get(x)[j], x, j);
            }
        }
    }

    private void mllenarCombo() {
        List<Object[]> listaTInforme = this.xPucTipoDeInformesDAO.listaTipoInformes();
        this.xidTipo = new String[listaTInforme.size()];
        for (int x = 0; x < listaTInforme.size(); x++) {
            this.xidTipo[x] = listaTInforme.get(x)[0].toString();
            this.JCBTipoInforme.addItem(listaTInforme.get(x)[1].toString());
        }
    }

    public void mNuevo() {
        this.JTFCodigoPuc.setText("");
        this.JTFCodigoConcepto.setText("");
        this.JTFNombreConcepto.setText("");
        this.JTAConsultaSQL.setText("");
        this.JCEstado.setSelected(true);
        this.JCBTipoInforme.setSelectedIndex(-1);
        Principal.mLimpiarDatosP();
        mCargarDatos();
    }

    public void mGuardar() {
        if (!this.JTFCodigoPuc.getText().isEmpty() && !this.JTFCodigoConcepto.getText().isEmpty() && !this.JTFNombreConcepto.getText().isEmpty() && this.JCBTipoInforme.getSelectedIndex() != -1 && !this.JTAConsultaSQL.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                PucTipoDeInformeDTO puc = new PucTipoDeInformeDTO();
                puc.setCodigoConcepto(this.JTFCodigoConcepto.getText());
                puc.setCodigoPuc(this.JTFCodigoPuc.getText());
                puc.setNombreConcepto(this.JTFNombreConcepto.getText());
                puc.setConsultaSQL(this.JTAConsultaSQL.getText());
                puc.setEstado(this.JCEstado.isSelected());
                puc.setIdtipoinforme(Integer.parseInt(this.xidTipo[this.JCBTipoInforme.getSelectedIndex()]));
                puc.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                if (Principal.txtNo.getText().isEmpty()) {
                    this.xPucTipoDeInformesDAO.mCreate(puc);
                } else {
                    puc.setId(Integer.parseInt(Principal.txtNo.getText()));
                    this.xPucTipoDeInformesDAO.mUpdate(puc);
                }
                mNuevo();
            }
        }
    }
}
