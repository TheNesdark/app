package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO;
import com.genoma.plus.dto.salud_ocupacional.TipoCertificadoSoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIFTipoCertificadoSO.class */
public class JIFTipoCertificadoSO extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private CertificadoSoDAO xCertificadoSoDAO;
    private JButton JBTConceptos;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPEncabezado;
    private JScrollPane JSPPiePagina;
    private JTextArea JTAEncabezado;
    private JTextArea JTAPiePagina;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTabbedPane JTPVista;
    private Metodos xmt = new Metodos();
    private int xestado = 1;

    public JIFTipoCertificadoSO() {
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
        this.JTAEncabezado.setText("");
        this.JTAPiePagina.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatosTabla();
        this.JBTConceptos.setEnabled(false);
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoCertificadoSoDTO e = new TipoCertificadoSoDTO();
                if (Principal.txtNo.getText().isEmpty()) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEncabezado(this.JTAEncabezado.getText());
                    e.setPiePagina(this.JTAPiePagina.getText());
                    e.setEstado(this.xestado);
                    this.xCertificadoSoDAO.createTipoCertificado(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEncabezado(this.JTAEncabezado.getText());
                    e.setPiePagina(this.JTAPiePagina.getText());
                    e.setEstado(this.xestado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xCertificadoSoDAO.updateTipoCertificado(e);
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
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Encabezado", "PiePagina", "Estado"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFTipoCertificadoSO.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        List<TipoCertificadoSoDTO> list = this.xCertificadoSoDAO.listTipoCertificado();
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getEncabezado(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getPiePagina(), x, 3);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPVista = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPEncabezado = new JScrollPane();
        this.JTAEncabezado = new JTextArea();
        this.JSPPiePagina = new JScrollPane();
        this.JTAPiePagina = new JTextArea();
        this.JBTConceptos = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CERTIFICADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipocertificadoso");
        this.JTPVista.setForeground(Color.red);
        this.JTPVista.setFont(new Font("Arial", 1, 14));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFTipoCertificadoSO.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoCertificadoSO.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAEncabezado.setColumns(20);
        this.JTAEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTAEncabezado.setRows(5);
        this.JSPEncabezado.setViewportView(this.JTAEncabezado);
        this.JSPPiePagina.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Pagina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAPiePagina.setColumns(20);
        this.JTAPiePagina.setFont(new Font("Arial", 1, 12));
        this.JTAPiePagina.setRows(5);
        this.JSPPiePagina.setViewportView(this.JTAPiePagina);
        this.JBTConceptos.setFont(new Font("Arial", 1, 12));
        this.JBTConceptos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTConceptos.setText("Concepto de Certificado");
        this.JBTConceptos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFTipoCertificadoSO.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoCertificadoSO.this.JBTConceptosActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPPiePagina).addComponent(this.JSPEncabezado, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 498, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JBTConceptos, -1, -1, 32767)).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPiePagina, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTConceptos, -2, 50, -2).addGap(10, 10, 10)));
        this.JTPVista.addTab("DATOS", this.JPDatos);
        this.JPDatos.getAccessibleContext().setAccessibleName("");
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFTipoCertificadoSO.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoCertificadoSO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPVista.addTab("HISTÓRICO", this.JSPDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPVista, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPVista, -2, 387, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTAEncabezado.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTAPiePagina.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xestado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xestado = 0;
            }
            this.JBTConceptos.setEnabled(true);
            this.JTPVista.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConceptosActionPerformed(ActionEvent evt) {
        JDCertificadoxConceptoSO jdialog = new JDCertificadoxConceptoSO(null, true);
        jdialog.setLocationRelativeTo(this);
        jdialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }
}
