package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIF_Consultar_Movimiento.class */
public class JIF_Consultar_Movimiento extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private String xcc_puc;
    private String xcc_documentoc;
    private String xcc_detalle_documentoc;
    private String[] xId_Tercero;
    private String[] xId_Puc;
    private WorkerSQL xWorkerSQL;
    private JButton JBTExportar;
    private JButton JBTTercero;
    public JComboBox JCB_CPuc;
    private JCheckBox JCHVisualizarNiif;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_Filtro1;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    public JLabel JLTercero;
    private JPanel JPI_Encabezado;
    private JPanel JPI_Exportar;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTFRuta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xLlenarC = false;
    public String xidTercero = "0";

    public JIF_Consultar_Movimiento() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Encabezado = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCH_Filtro = new JCheckBox();
        this.JCB_CPuc = new JComboBox();
        this.JCH_Filtro1 = new JCheckBox();
        this.JLTercero = new JLabel();
        this.JBTTercero = new JButton();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JPI_Exportar = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JCHVisualizarNiif = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("MOVIMIENTOS POR TERCERO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_consultar_mov_tercero");
        this.JPI_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_Movimiento.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_Movimiento.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        this.JCB_CPuc.setFont(new Font("Arial", 1, 12));
        this.JCB_CPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Filtro1.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro1.setText("Filtro");
        this.JCH_Filtro1.addActionListener(new ActionListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_Movimiento.this.JCH_Filtro1ActionPerformed(evt);
            }
        });
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setForeground(Color.red);
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLTercero.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_Movimiento.this.JLTerceroPropertyChange(evt);
            }
        });
        this.JBTTercero.setFont(new Font("Arial", 1, 12));
        this.JBTTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTTercero.setToolTipText("Buscar Terceros");
        this.JBTTercero.setName("xOrigen");
        this.JBTTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_Movimiento.this.JBTTerceroActionPerformed(evt);
            }
        });
        GroupLayout JPI_EncabezadoLayout = new GroupLayout(this.JPI_Encabezado);
        this.JPI_Encabezado.setLayout(JPI_EncabezadoLayout);
        JPI_EncabezadoLayout.setHorizontalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTercero, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTTercero, -2, 48, -2)).addComponent(this.JCB_CPuc, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Filtro1).addComponent(this.JCH_Filtro)).addContainerGap()));
        JPI_EncabezadoLayout.setVerticalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Filtro).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTercero, -2, 50, -2).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addComponent(this.JBTTercero, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_CPuc, -2, 50, -2).addComponent(this.JCH_Filtro1)).addContainerGap()));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JPI_Exportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_Movimiento.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIF_Consultar_Movimiento.7
            public void mouseClicked(MouseEvent evt) {
                JIF_Consultar_Movimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPI_ExportarLayout = new GroupLayout(this.JPI_Exportar);
        this.JPI_Exportar.setLayout(JPI_ExportarLayout);
        JPI_ExportarLayout.setHorizontalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(492, 492, 492).addComponent(this.JBTExportar, -2, 230, -2).addContainerGap(10, 32767)).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFRuta, -2, 461, -2).addContainerGap(268, 32767))));
        JPI_ExportarLayout.setVerticalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addComponent(this.JBTExportar, -2, 50, -2).addGap(0, 21, 32767)).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(-1, 32767))));
        this.JCHVisualizarNiif.setFont(new Font("Arial", 1, 13));
        this.JCHVisualizarNiif.setText("Visualizacion NIIF");
        this.JCHVisualizarNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIF_Consultar_Movimiento.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_Movimiento.this.JCHVisualizarNiifActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Exportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHVisualizarNiif).addGap(0, 21, 32767)).addComponent(this.JSP_Detalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Encabezado, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Encabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 342, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Exportar, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.JCHVisualizarNiif))).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle, this.JTFRuta.getText(), getTitle());
            }
        }
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
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.JCH_Filtro1.isSelected()) {
            if (this.xLlenarC) {
                mCargarCPuc();
            }
        } else {
            this.JCB_CPuc.removeAllItems();
            this.JCB_CPuc.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.JCH_Filtro1.isSelected()) {
            if (this.xLlenarC) {
                mCargarCPuc();
            }
        } else {
            this.JCB_CPuc.removeAllItems();
            this.JCB_CPuc.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLTerceroPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Filtro1ActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro1.isSelected()) {
            if (this.xLlenarC) {
                mCargarCPuc();
            }
        } else {
            this.JCB_CPuc.removeAllItems();
            this.JCB_CPuc.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVisualizarNiifActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro1.isSelected() && this.xLlenarC) {
            mCargarCPuc();
        }
    }

    public void mNuevo() {
        this.xLlenarC = false;
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xLlenarC = true;
        mCrearTabla();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Tercero", "Id_Doc", "Fecha", "Tipo Documento", "Cuenta Puc", "Nombre Puc", "Base", "V/Debito", "V/Credito", "Descripción", "Concepto", "N° Factura"}) { // from class: Contabilidad.JIF_Consultar_Movimiento.9
            Class[] types = {String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
    }

    public void mCargarDatosTabla() {
        try {
            mCrearTabla();
            if (this.JCHVisualizarNiif.isSelected()) {
                if (this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
                    this.xsql = "SELECT cc_terceros.TDCompleto2,cc_terceros.RazonSocialCompleta,cc_documentoc.Id,DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha,cc_tipo_documentoc.Nbre,cc_puc_niif.Id,cc_puc_niif.Nbre,cc_detalle_documentoc.Base,\n  cc_detalle_documentoc.VDebito,cc_detalle_documentoc.VCredito,cc_documentoc.Descripcion,cc_detalle_documentoc.Concepto,cc_detalle_documentoc.NFactura FROM cc_detalle_documentoc\n  INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n  INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n  INNER JOIN  `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n  INNER JOIN  `cc_puc_niif` ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\n  INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  \nWHERE (cc_detalle_documentoc.`Id_Tercero`= '" + this.xidTercero + "' AND cc_documentoc.FechaD >= '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.FechaD <= '" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado = 1 AND cc_puc_niif.Id='" + this.xId_Puc[this.JCB_CPuc.getSelectedIndex()] + "')\nORDER BY cc_documentoc.Id ASC";
                } else if (this.JCH_Filtro.isSelected() && !this.JCH_Filtro1.isSelected()) {
                    this.xsql = "SELECT cc_terceros.TDCompleto2,cc_terceros.RazonSocialCompleta,cc_documentoc.Id,DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha,cc_tipo_documentoc.Nbre,cc_puc_niif.Id,cc_puc_niif.Nbre,cc_detalle_documentoc.Base,\n  cc_detalle_documentoc.VDebito,cc_detalle_documentoc.VCredito,cc_documentoc.Descripcion,cc_detalle_documentoc.Concepto,cc_detalle_documentoc.NFactura FROM cc_detalle_documentoc\n  INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n  INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n  INNER JOIN  `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n  INNER JOIN  `cc_puc_niif` ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\n  INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  \nWHERE (cc_detalle_documentoc.`Id_Tercero`= '" + this.xidTercero + "' AND cc_documentoc.FechaD >= '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.FechaD <= '" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado = 1)\nORDER BY cc_documentoc.Id ASC";
                } else if (!this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
                    this.xsql = "SELECT cc_terceros.TDCompleto2,cc_terceros.RazonSocialCompleta,cc_documentoc.Id,DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha,cc_tipo_documentoc.Nbre,cc_puc_niif.Id,cc_puc_niif.Nbre,cc_detalle_documentoc.Base,\n  cc_detalle_documentoc.VDebito,cc_detalle_documentoc.VCredito,cc_documentoc.Descripcion,cc_detalle_documentoc.Concepto,cc_detalle_documentoc.NFactura FROM cc_detalle_documentoc\n  INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n  INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n  INNER JOIN  `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n  INNER JOIN  `cc_puc_niif` ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\n  INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  \nWHERE (cc_documentoc.FechaD >= '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.FechaD <= '" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado = 1 AND cc_puc_niif.Id='" + this.xId_Puc[this.JCB_CPuc.getSelectedIndex()] + "')\nORDER BY cc_documentoc.Id ASC";
                } else {
                    this.xsql = "SELECT cc_terceros.TDCompleto2,cc_terceros.RazonSocialCompleta,cc_documentoc.Id,DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha,cc_tipo_documentoc.Nbre,cc_puc_niif.Id,cc_puc_niif.Nbre,cc_detalle_documentoc.Base,\n  cc_detalle_documentoc.VDebito,cc_detalle_documentoc.VCredito,cc_documentoc.Descripcion,cc_detalle_documentoc.Concepto,cc_detalle_documentoc.NFactura FROM cc_detalle_documentoc\n  INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n  INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n  INNER JOIN  `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n  INNER JOIN  `cc_puc_niif` ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\n  INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  \nWHERE (cc_documentoc.FechaD >= '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.FechaD <= '" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado = 1)\nORDER BY cc_documentoc.Id ASC";
                }
            } else if (this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
                this.xsql = "SELECT cc_terceros.TDCompleto2, cc_terceros.RazonSocialCompleta, " + this.xcc_documentoc + ".Id , DATE_FORMAT(" + this.xcc_documentoc + ".FechaD,'%d-%m-%Y') AS Fecha , cc_tipo_documentoc.Nbre , " + this.xcc_puc + ".Id , " + this.xcc_puc + ".Nbre \n, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto, " + this.xcc_detalle_documentoc + ".NFactura\nFROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) INNER JOIN " + this.xcc_puc + "\nON (" + this.xcc_detalle_documentoc + ".Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN cc_tipo_documentoc ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE (`cc_terceros`.`Id`='" + this.xidTercero + "' AND  " + this.xcc_documentoc + ".FechaD >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND " + this.xcc_documentoc + ".Estado =1  AND " + this.xcc_detalle_documentoc + ".`Id_Puc` ='" + this.xId_Puc[this.JCB_CPuc.getSelectedIndex()] + "') \nORDER BY " + this.xcc_documentoc + ".Id ASC ";
            } else if (this.JCH_Filtro.isSelected() && !this.JCH_Filtro1.isSelected()) {
                this.xsql = "SELECT cc_terceros.TDCompleto2, cc_terceros.RazonSocialCompleta, " + this.xcc_documentoc + ".Id , DATE_FORMAT(" + this.xcc_documentoc + ".FechaD,'%d-%m-%Y') AS Fecha , cc_tipo_documentoc.Nbre , " + this.xcc_puc + ".Id , " + this.xcc_puc + ".Nbre \n, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto, " + this.xcc_detalle_documentoc + ".NFactura\nFROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) INNER JOIN " + this.xcc_puc + "\nON (" + this.xcc_detalle_documentoc + ".Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN cc_tipo_documentoc ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE (`cc_terceros`.`Id`='" + this.xidTercero + "' AND  " + this.xcc_documentoc + ".FechaD >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND " + this.xcc_documentoc + ".Estado =1) \nORDER BY " + this.xcc_documentoc + ".Id ASC ";
            } else if (!this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
                this.xsql = "SELECT cc_terceros.TDCompleto2, cc_terceros.RazonSocialCompleta, " + this.xcc_documentoc + ".Id , DATE_FORMAT(" + this.xcc_documentoc + ".FechaD,'%d-%m-%Y') AS Fecha , cc_tipo_documentoc.Nbre , " + this.xcc_puc + ".Id , " + this.xcc_puc + ".Nbre \n, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto, " + this.xcc_detalle_documentoc + ".NFactura\nFROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) INNER JOIN " + this.xcc_puc + "\nON (" + this.xcc_detalle_documentoc + ".Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN cc_tipo_documentoc ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE ( " + this.xcc_documentoc + ".FechaD >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "' AND " + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".`Id_Puc` ='" + this.xId_Puc[this.JCB_CPuc.getSelectedIndex()] + "') \nORDER BY " + this.xcc_documentoc + ".Id ASC ";
            } else {
                this.xsql = "SELECT cc_terceros.TDCompleto2, cc_terceros.RazonSocialCompleta, " + this.xcc_documentoc + ".Id , DATE_FORMAT(" + this.xcc_documentoc + ".FechaD,'%d-%m-%Y') AS Fecha , cc_tipo_documentoc.Nbre , " + this.xcc_puc + ".Id , " + this.xcc_puc + ".Nbre \n, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto, " + this.xcc_detalle_documentoc + ".NFactura\nFROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) INNER JOIN " + this.xcc_puc + "\nON (" + this.xcc_detalle_documentoc + ".Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN cc_tipo_documentoc ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE ( " + this.xcc_documentoc + ".FechaD >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "' AND " + this.xcc_documentoc + ".Estado =1) \nORDER BY " + this.xcc_documentoc + ".Id ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int i = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), i, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), i, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), i, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), i, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), i, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), i, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), i, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), i, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), i, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), i, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), i, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), i, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), i, 12);
                    i++;
                }
            } else {
                mCrearTabla();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Consultar_Movimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
            if (!this.JLTercero.getText().isEmpty()) {
                if (this.JCB_CPuc.getSelectedIndex() != -1) {
                    mMostrarLoad();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar cuenta puc", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCB_CPuc.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Falta seleccionar tercero", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JLTercero.requestFocus();
            return;
        }
        if (this.JCH_Filtro.isSelected() && !this.JCH_Filtro1.isSelected()) {
            if (!this.JLTercero.getText().isEmpty()) {
                mMostrarLoad();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Falta seleccionar tercero", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JLTercero.requestFocus();
                return;
            }
        }
        if (!this.JCH_Filtro.isSelected() && this.JCH_Filtro1.isSelected()) {
            if (this.JCB_CPuc.getSelectedIndex() != -1) {
                mMostrarLoad();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar cuenta puc", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_CPuc.requestFocus();
                return;
            }
        }
        mMostrarLoad();
    }

    public void mMostrarLoad() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
        this.xWorkerSQL.execute();
    }

    private void mCargarCPuc() {
        if (this.JCHVisualizarNiif.isSelected()) {
            this.xsql = "SELECT\ncc_puc_niif.`Id`\n,CONCAT(  cc_puc_niif.`Id`, '_',cc_puc_niif.`Nbre`) NPuc\n FROM\ncc_detalle_documentoc\n INNER JOIN cc_documentoc ON (cc_detalle_documentoc.`Id_Documentoc` = `cc_documentoc`.`Id`)\n INNER JOIN `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n INNER JOIN `cc_puc_niif` ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\n WHERE (`cc_documentoc`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `cc_documentoc`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\n GROUP BY cc_puc_niif.`Id`";
        } else {
            this.xsql = "SELECT\n `" + this.xcc_puc + "`.`Id`\n ,CONCAT(  `" + this.xcc_puc + "`.`Id`, '_',`" + this.xcc_puc + "`.`Nbre`) NPuc\nFROM\n `" + this.xcc_detalle_documentoc + "`\nINNER JOIN `" + this.xcc_documentoc + "` \n ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`)\nINNER JOIN `" + this.xcc_puc + "` \n ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`)\nWHERE (`" + this.xcc_documentoc + "`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'\n AND `" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\nGROUP BY `" + this.xcc_puc + "`.`Id`";
        }
        this.JCB_CPuc.removeAllItems();
        this.xId_Puc = this.xct.llenarCombo(this.xsql, this.xId_Puc, this.JCB_CPuc);
        this.JCB_CPuc.setSelectedIndex(-1);
    }
}
