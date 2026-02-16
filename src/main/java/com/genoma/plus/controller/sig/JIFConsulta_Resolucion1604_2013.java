package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.Resolucion1604_DAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFConsulta_Resolucion1604_2013.class */
public class JIFConsulta_Resolucion1604_2013 extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Resolucion1604_DAO xResolucion1604_DAO;
    private String[] xIdEmpresa;
    private Object[] xDatos;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCH_Filtro;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPI_Exportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xIdEmpresaC = "0";

    public JIFConsulta_Resolucion1604_2013() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Exportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("INFORME RESOLUCION 1604 DE 2013");
        setName("xJif_informe_resolucion1604");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        this.JCH_Filtro.setToolTipText("");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JCH_FiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 562, -2).addGap(18, 18, 18).addComponent(this.JCH_Filtro).addGap(17, 17, 17)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JCH_Filtro))).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Exportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTACION", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsulta_Resolucion1604_2013.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_ExportarLayout = new GroupLayout(this.JPI_Exportar);
        this.JPI_Exportar.setLayout(JPI_ExportarLayout);
        JPI_ExportarLayout.setHorizontalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 512, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 225, -2).addContainerGap(-1, 32767)));
        JPI_ExportarLayout.setVerticalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ExportarLayout.createSequentialGroup().addContainerGap(14, 32767).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta, -1, 50, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle).addComponent(this.JPI_Exportar, -1, -1, 32767)).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 332, 32767).addGap(18, 18, 18).addComponent(this.JPI_Exportar, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
                this.xIdEmpresaC = this.xIdEmpresa[this.JCBEmpresa.getSelectedIndex()];
                return;
            }
            return;
        }
        this.xIdEmpresaC = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.xIdEmpresaC = this.xIdEmpresa[this.JCBEmpresa.getSelectedIndex()];
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre1", "Nombre2", "Apellido1", "Apellido2", "TD", "NDocumento", "Sexo", "NSuministro", "Concentracion", "FormaFarmaceutica", "ViaAdministracion", "Frecuencia", "Duracion", "CantOrdenada", "CantDespachada", "Codigo_Dxp", "Codigo_DxR1", "FechaOrden", "FechaSalida", "IdOrden", "TipoMOvimiento", "NEmpresa"}) { // from class: com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(200);
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCreaModeloTabla();
        mLlenarCombo();
    }

    private void springStart() {
        this.xResolucion1604_DAO = (Resolucion1604_DAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("resolucion1604_DAOImpl");
    }

    private void mLlenarCombo() {
        List<GenericoComboDTO> list = this.xResolucion1604_DAO.comboEmpresa(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xIdEmpresa = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xIdEmpresa[x] = String.valueOf(list.get(x).getId());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xlleno = true;
    }

    public void mBuscar() {
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                List<Object[]> list = this.xResolucion1604_DAO.listadoDatosResolucion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), Boolean.valueOf(this.JCH_Filtro.isSelected()), this.xIdEmpresaC);
                mCargarDatos(list);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1);
                this.JCBEmpresa.requestFocus();
                return;
            }
        }
        List<Object[]> list2 = this.xResolucion1604_DAO.listadoDatosResolucion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), Boolean.valueOf(this.JCH_Filtro.isSelected()), this.xIdEmpresaC);
        mCargarDatos(list2);
    }

    private void mCargarDatos(List<Object[]> xlista) {
        mCreaModeloTabla();
        for (int x = 0; x < xlista.size(); x++) {
            this.xModelo.addRow(this.xDatos);
            this.xModelo.setValueAt(xlista.get(x)[0], x, 0);
            this.xModelo.setValueAt(xlista.get(x)[1], x, 1);
            this.xModelo.setValueAt(xlista.get(x)[2], x, 2);
            this.xModelo.setValueAt(xlista.get(x)[3], x, 3);
            this.xModelo.setValueAt(xlista.get(x)[4], x, 4);
            this.xModelo.setValueAt(xlista.get(x)[5], x, 5);
            this.xModelo.setValueAt(xlista.get(x)[6], x, 6);
            this.xModelo.setValueAt(xlista.get(x)[7], x, 7);
            this.xModelo.setValueAt(xlista.get(x)[8], x, 8);
            this.xModelo.setValueAt(xlista.get(x)[9], x, 9);
            this.xModelo.setValueAt(xlista.get(x)[10], x, 10);
            this.xModelo.setValueAt(xlista.get(x)[11], x, 11);
            this.xModelo.setValueAt(xlista.get(x)[12], x, 12);
            this.xModelo.setValueAt(xlista.get(x)[13], x, 13);
            this.xModelo.setValueAt(xlista.get(x)[14], x, 14);
            this.xModelo.setValueAt(xlista.get(x)[15], x, 15);
            this.xModelo.setValueAt(xlista.get(x)[16], x, 16);
            this.xModelo.setValueAt(xlista.get(x)[17], x, 17);
            this.xModelo.setValueAt(xlista.get(x)[18], x, 18);
            this.xModelo.setValueAt(xlista.get(x)[19], x, 19);
            this.xModelo.setValueAt(xlista.get(x)[20], x, 20);
            this.xModelo.setValueAt(xlista.get(x)[21], x, 21);
        }
    }
}
