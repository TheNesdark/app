package Armado;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFConciliacionCartera.class */
public class JIFConciliacionCartera extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String[][] xid;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JCheckBox JCHFiltroP;
    private JPanel JPIDGlosas;
    private JPanel JPIDPagos;
    private JPanel JPIDatos;
    private JScrollPane JSPDConsolidado;
    private JScrollPane JSPHPDetalle;
    private JScrollPane JSPRGDetalle;
    private JTable JTBDConsolidado;
    private JTable JTBHPDetalle;
    private JTable JTBRGDetalle;
    private JFormattedTextField JTFFGTotal;
    private JFormattedTextField JTFFGTotalNR;
    private JFormattedTextField JTFFGTotalR;
    private JFormattedTextField JTFFPTotal;
    private JTabbedPane JTPDetalle;
    private JYearChooser JYCAno;

    public JIFConciliacionCartera() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JCHFiltroP = new JCheckBox();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDConsolidado = new JScrollPane();
        this.JTBDConsolidado = new JTable();
        this.JPIDPagos = new JPanel();
        this.JSPHPDetalle = new JScrollPane();
        this.JTBHPDetalle = new JTable();
        this.JTFFPTotal = new JFormattedTextField();
        this.JPIDGlosas = new JPanel();
        this.JSPRGDetalle = new JScrollPane();
        this.JTBRGDetalle = new JTable();
        this.JTFFGTotal = new JFormattedTextField();
        this.JTFFGTotalR = new JFormattedTextField();
        this.JTFFGTotalNR = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCILIACIÓN DE CARTERA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconciliacioncartera");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFConciliacionCartera.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConciliacionCartera.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Armado.JIFConciliacionCartera.2
            public void actionPerformed(ActionEvent evt) {
                JIFConciliacionCartera.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCHFiltroP.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroP.setSelected(true);
        this.JCHFiltroP.setText("Filtro por periodo?");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo).addGap(36, 36, 36).addComponent(this.JCHFiltroP).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHActivo).addComponent(this.JCHFiltroP)).addComponent(this.JYCAno, -2, -1, -2).addComponent(this.JCBPeriodo, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTPDetalle.setForeground(new Color(0, 103, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTBDConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTBDConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDConsolidado.setRowHeight(25);
        this.JTBDConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDConsolidado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFConciliacionCartera.3
            public void mouseClicked(MouseEvent evt) {
                JIFConciliacionCartera.this.JTBDConsolidadoMouseClicked(evt);
            }
        });
        this.JSPDConsolidado.setViewportView(this.JTBDConsolidado);
        this.JTPDetalle.addTab("CONSOLIDADO", this.JSPDConsolidado);
        this.JSPHPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBHPDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHPDetalle.setRowHeight(25);
        this.JTBHPDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHPDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHPDetalle.addMouseListener(new MouseAdapter() { // from class: Armado.JIFConciliacionCartera.4
            public void mouseClicked(MouseEvent evt) {
                JIFConciliacionCartera.this.JTBHPDetalleMouseClicked(evt);
            }
        });
        this.JSPHPDetalle.setViewportView(this.JTBHPDetalle);
        this.JTFFPTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPTotal.setHorizontalAlignment(4);
        this.JTFFPTotal.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDPagosLayout = new GroupLayout(this.JPIDPagos);
        this.JPIDPagos.setLayout(JPIDPagosLayout);
        JPIDPagosLayout.setHorizontalGroup(JPIDPagosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDPagosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPHPDetalle, -2, 821, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDPagosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFPTotal, -2, 149, -2).addContainerGap()));
        JPIDPagosLayout.setVerticalGroup(JPIDPagosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPagosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHPDetalle, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPTotal, -2, 50, -2).addContainerGap(27, 32767)));
        this.JTPDetalle.addTab("HISTÓRICO PAGOS", this.JPIDPagos);
        this.JSPRGDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBRGDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBRGDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRGDetalle.setRowHeight(25);
        this.JTBRGDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRGDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRGDetalle.addMouseListener(new MouseAdapter() { // from class: Armado.JIFConciliacionCartera.5
            public void mouseClicked(MouseEvent evt) {
                JIFConciliacionCartera.this.JTBRGDetalleMouseClicked(evt);
            }
        });
        this.JSPRGDetalle.setViewportView(this.JTBRGDetalle);
        this.JTFFGTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Glosas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFGTotal.setHorizontalAlignment(4);
        this.JTFFGTotal.setFont(new Font("Arial", 1, 14));
        this.JTFFGTotalR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total GlosaR", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFGTotalR.setHorizontalAlignment(4);
        this.JTFFGTotalR.setToolTipText("Total Glosa Recuperable");
        this.JTFFGTotalR.setFont(new Font("Arial", 1, 14));
        this.JTFFGTotalNR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total GloraNR", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFGTotalNR.setHorizontalAlignment(4);
        this.JTFFGTotalNR.setToolTipText("Total Glosa No Recuperable");
        this.JTFFGTotalNR.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDGlosasLayout = new GroupLayout(this.JPIDGlosas);
        this.JPIDGlosas.setLayout(JPIDGlosasLayout);
        JPIDGlosasLayout.setHorizontalGroup(JPIDGlosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGlosasLayout.createSequentialGroup().addGap(317, 317, 317).addComponent(this.JTFFGTotal, -2, 149, -2).addGap(18, 18, 18).addComponent(this.JTFFGTotalR, -2, 149, -2).addGap(18, 18, 18).addComponent(this.JTFFGTotalNR, -2, 149, -2).addContainerGap(41, 32767)).addGroup(JPIDGlosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDGlosasLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPRGDetalle, -2, 821, -2).addContainerGap(-1, 32767))));
        JPIDGlosasLayout.setVerticalGroup(JPIDGlosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDGlosasLayout.createSequentialGroup().addContainerGap(293, 32767).addGroup(JPIDGlosasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFGTotal, -2, 50, -2).addComponent(this.JTFFGTotalR, -2, 50, -2).addComponent(this.JTFFGTotalNR, -2, 50, -2)).addContainerGap()).addGroup(JPIDGlosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGlosasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPRGDetalle, -2, 255, -2).addContainerGap(88, 32767))));
        this.JTPDetalle.addTab("HISTÓRICO GLOSAS", this.JPIDGlosas);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDetalle, -1, 385, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTBDConsolidado.getSelectedRow() != -1) {
            mCagarDetallePago();
            mCagarDetalleGlosa();
            mTotalizarGlosas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHPDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBHPDetalle.getSelectedRow() != -1 && !this.xmodelo1.getValueAt(this.JTBHPDetalle.getSelectedRow(), 5).equals("")) {
            this.xmt.mostrarPdf(this.xmodelo1.getValueAt(this.JTBHPDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRGDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBRGDetalle.getSelectedRow() != -1 && !this.xmodelo2.getValueAt(this.JTBRGDetalle.getSelectedRow(), 7).equals("")) {
            this.xmt.mostrarPdf(this.xmodelo2.getValueAt(this.JTBRGDetalle.getSelectedRow(), 7).toString());
        }
    }

    public void mNuevo() {
        mCargarCombo();
        mCrearTablaConsolidado();
        mCrearTablaRPago();
        mCrearTablaRGlosa();
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, DevuelveMes(FechaI)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, DevuelveMes(FechaI)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
        this.xct.cerrarConexionBd();
    }

    private void mCrearTablaConsolidado() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Empresa", "V/Neto", "V/Pagado", "V/Glosado", "V/RGlosa", "VNRGLosa", "Total"}) { // from class: Armado.JIFConciliacionCartera.6
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDConsolidado.setModel(this.xmodelo);
        this.JTBDConsolidado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDConsolidado.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBDConsolidado.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDConsolidado.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDConsolidado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDConsolidado.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDConsolidado.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDConsolidado.getColumnModel().getColumn(7).setPreferredWidth(20);
    }

    private void mCrearTablaRPago() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Concepto", "Valor", "Observacion", "Url Soporte", "Periodo"}) { // from class: Armado.JIFConciliacionCartera.7
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBHPDetalle.setModel(this.xmodelo1);
        this.JTBHPDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBHPDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBHPDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBHPDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBHPDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBHPDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBHPDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBHPDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBHPDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCrearTablaRGlosa() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Concepto", "Valor", "V/Recuperable", "V/NRecuperable", "Observacion", "Url Soporte", "Periodo"}) { // from class: Armado.JIFConciliacionCartera.8
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBRGDetalle.setModel(this.xmodelo2);
        this.JTBRGDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBRGDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBRGDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBRGDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBRGDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBRGDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBRGDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBRGDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBRGDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBRGDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBRGDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            this.xsql = "DELETE FROM `f_tmp_cartera`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into f_tmp_cartera (Id_Empresa, VNeto) SELECT`f_empresacontxconvenio`.`Id`, SUM(`f_liquidacion`.`TotalEps`) AS ValorT  FROM  `f_factura_evento` INNER JOIN `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)  INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  WHERE (f_cuentacobro.Id_PeriodoC<='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' and `f_factura_evento`.`Fecha_FacturaEvento` >='2011-01-01' AND `f_factura_evento`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `f_cuentacobro`.`Estado` =0)  GROUP BY `f_empresacontxconvenio`.`Id` HAVING (SUM(`f_liquidacion`.`TotalEps`) <>0) ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT `Id` FROM `f_tmp_cartera` ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                while (xrs.next()) {
                    this.xsql = "UPDATE `f_tmp_cartera`  SET f_tmp_cartera.`VPagado`=(SELECT SUM(`f_factura_pagos`.`Valor`) AS `Valor` FROM `f_factura_pagos` INNER JOIN  `f_liquidacion`  ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_pagos`.`Estado` =1 AND `f_factura_pagos`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `f_liquidacion`.`IdEmpresaContxConv` ='" + xrs.getString(1) + "') ) WHERE f_tmp_cartera.`Id_Empresa`='" + xrs.getString(1) + "'";
                    xct1.ejecutarSQL(this.xsql);
                    xct1.cerrarConexionBd();
                    this.xsql = "UPDATE `f_tmp_cartera`  SET f_tmp_cartera.`VGlosado`=(SELECT SUM(`f_factura_glosa`.`Valor`) AS `Valor` FROM `f_factura_glosa` INNER JOIN  `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Estado` =1 AND `f_factura_glosa`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `f_liquidacion`.`IdEmpresaContxConv` ='" + xrs.getString(1) + "') ) WHERE f_tmp_cartera.`Id_Empresa`='" + xrs.getString(1) + "'";
                    xct1.ejecutarSQL(this.xsql);
                    xct1.cerrarConexionBd();
                    this.xsql = "UPDATE `f_tmp_cartera`  SET f_tmp_cartera.`VRGlosa`=(SELECT SUM(DISTINCT(`f_factura_glosa_respuesta`.`ValorR`)) AS `Valor`  FROM `f_factura_glosa` INNER JOIN  `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_factura_glosa_respuesta`  ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_glosa_respuesta`.`Estado` =1 AND `f_factura_glosa_respuesta`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `f_liquidacion`.`IdEmpresaContxConv` ='" + xrs.getString(1) + "') ) WHERE f_tmp_cartera.`Id_Empresa`='" + xrs.getString(1) + "'";
                    xct1.ejecutarSQL(this.xsql);
                    xct1.cerrarConexionBd();
                    this.xsql = "UPDATE `f_tmp_cartera`  SET f_tmp_cartera.`VNRGlosa`=(SELECT SUM(`f_factura_glosa_respuesta`.`ValorA`) AS `Valor`  FROM `f_factura_glosa` INNER JOIN  `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_factura_glosa_respuesta`  ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_glosa_respuesta`.`Estado` =1 AND `f_factura_glosa_respuesta`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `f_liquidacion`.`IdEmpresaContxConv` ='" + xrs.getString(1) + "') ) WHERE f_tmp_cartera.`Id_Empresa`='" + xrs.getString(1) + "'";
                    xct1.ejecutarSQL(this.xsql);
                    xct1.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT `f_tmp_cartera`.`Id`, `f_empresacontxconvenio`.`Nbre`,`f_tmp_cartera`.`VNeto`, IF(`f_tmp_cartera`.`VPagado` IS NULL,0,`f_tmp_cartera`.`VPagado`) AS VPagado ,  IF(`f_tmp_cartera`.`VGlosado` IS NULL,0,`f_tmp_cartera`.`VGlosado`) AS VGlosado , IF(`f_tmp_cartera`.`VRGlosa` IS NULL,0,`f_tmp_cartera`.`VRGlosa`) AS VRGlosa ,IF(`f_tmp_cartera`.`VNRGlosa` IS NULL,0,`f_tmp_cartera`.`VNRGlosa`) AS VNRGlosa, (`f_tmp_cartera`.`VNeto`-IF(`f_tmp_cartera`.`VPagado` IS NULL,0,`f_tmp_cartera`.`VPagado`) -IF(`f_tmp_cartera`.`VGlosado` IS NULL,0,`f_tmp_cartera`.`VGlosado`) ) AS Saldo FROM  `f_empresacontxconvenio` INNER JOIN `f_tmp_cartera`  ON (`f_empresacontxconvenio`.`Id` = `f_tmp_cartera`.`Id_Empresa`) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                int x = 0;
                mCrearTablaConsolidado();
                while (xrs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs2.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs2.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble(8)), x, 7);
                    x++;
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConciliacionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCagarDetallePago() {
        try {
            if (this.JCHFiltroP.isSelected()) {
                this.xsql = "SELECT `f_factura_pagos`.`Id`, DATE_FORMAT(`f_factura_pagos`.`FechaAbono`,'%d-%m-%Y') AS Fecha, CONCAT(`f_tipoconcepto_pago`.`Nbre`,' N° ', IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento))) AS cONCEPTO, `f_factura_pagos`.`Valor`, `f_factura_pagos`.`Observacion`, `f_factura_pagos`.`UrlSoporte`, CONCAT(`DevuelveMes`(cc_periodo_contable.`FechaI`),' ',DATE_FORMAT(cc_periodo_contable.`FechaI`,'%Y')) AS Periodo  FROM  `f_factura_pagos`  INNER JOIN `f_liquidacion`   ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tipoconcepto_pago` ON (`f_factura_pagos`.`Id_ConceptoPago` = `f_tipoconcepto_pago`.`Id`)INNER JOIN  `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `cc_periodo_contable`ON (`cc_periodo_contable`.`Id` = `f_factura_pagos`.`Id_PeriodoC`)  WHERE (`f_liquidacion`.`IdEmpresaContxConv` ='" + this.xmodelo.getValueAt(this.JTBDConsolidado.getSelectedRow(), 0) + "' AND `f_factura_pagos`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `f_factura_pagos`.`Estado` =1) ORDER BY `f_factura_pagos`.`FechaAbono` DESC ";
            } else {
                this.xsql = "SELECT `f_factura_pagos`.`Id`, DATE_FORMAT(`f_factura_pagos`.`FechaAbono`,'%d-%m-%Y') AS Fecha, CONCAT(`f_tipoconcepto_pago`.`Nbre`,' N° ', IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento))) AS cONCEPTO, `f_factura_pagos`.`Valor`, `f_factura_pagos`.`Observacion`, `f_factura_pagos`.`UrlSoporte`, CONCAT(`DevuelveMes`(cc_periodo_contable.`FechaI`),' ',DATE_FORMAT(cc_periodo_contable.`FechaI`,'%Y')) AS Periodo  FROM  `f_factura_pagos`  INNER JOIN `f_liquidacion`   ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tipoconcepto_pago` ON (`f_factura_pagos`.`Id_ConceptoPago` = `f_tipoconcepto_pago`.`Id`)INNER JOIN  `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `cc_periodo_contable`ON (`cc_periodo_contable`.`Id` = `f_factura_pagos`.`Id_PeriodoC`)  WHERE (`f_liquidacion`.`IdEmpresaContxConv` ='" + this.xmodelo.getValueAt(this.JTBDConsolidado.getSelectedRow(), 0) + "' AND  `f_factura_pagos`.`Estado` =1) ORDER BY `f_factura_pagos`.`FechaAbono` DESC ";
            }
            mCrearTablaRPago();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            double xvalor = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), x, 6);
                    xvalor += xrs.getDouble(4);
                    x++;
                }
            }
            this.JTFFPTotal.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConciliacionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCagarDetalleGlosa() {
        try {
            if (this.JCHFiltroP.isSelected()) {
                this.xsql = "SELECT `f_factura_glosa`.`Id`, DATE_FORMAT(`f_factura_glosa`.`FechaG`,'%d-%m-%Y') AS Fecha,CONCAT(`f_tipoconcepto_pago`.`Nbre`,' N° ', IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento))) AS cONCEPTO , `f_factura_glosa`.`Valor` , `f_factura_glosa`.`ObservacionG` , `f_factura_glosa`.`UrlSoporte`, CONCAT(`DevuelveMes`(cc_periodo_contable.`FechaI`),' ',DATE_FORMAT(cc_periodo_contable.`FechaI`,'%Y')) AS Periodo FROM  `f_factura_glosa` INNER JOIN  `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tipoconcepto_pago`  ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `cc_periodo_contable`  ON (`f_factura_glosa`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (`f_liquidacion`.`IdEmpresaContxConv` ='" + this.xmodelo.getValueAt(this.JTBDConsolidado.getSelectedRow(), 0) + "' AND `f_factura_glosa`.`Estado` =1 AND `f_factura_glosa`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' ) ORDER BY `f_factura_glosa`.`FechaG` DESC ";
            } else {
                this.xsql = "SELECT `f_factura_glosa`.`Id`, DATE_FORMAT(`f_factura_glosa`.`FechaG`,'%d-%m-%Y') AS Fecha,CONCAT(`f_tipoconcepto_pago`.`Nbre`,' N° ', IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento))) AS cONCEPTO , `f_factura_glosa`.`Valor` , `f_factura_glosa`.`ObservacionG` , `f_factura_glosa`.`UrlSoporte`, CONCAT(`DevuelveMes`(cc_periodo_contable.`FechaI`),' ',DATE_FORMAT(cc_periodo_contable.`FechaI`,'%Y')) AS Periodo FROM  `f_factura_glosa` INNER JOIN  `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tipoconcepto_pago`  ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `cc_periodo_contable`  ON (`f_factura_glosa`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (`f_liquidacion`.`IdEmpresaContxConv` ='" + this.xmodelo.getValueAt(this.JTBDConsolidado.getSelectedRow(), 0) + "' AND `f_factura_glosa`.`Estado` =1  ) ORDER BY `f_factura_glosa`.`FechaG` DESC ";
            }
            mCrearTablaRGlosa();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            double xvalor = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    mCargarValoresGlosa(xrs.getLong(1), x);
                    this.xmodelo2.setValueAt(xrs.getString(5), x, 6);
                    this.xmodelo2.setValueAt(xrs.getString(6), x, 7);
                    this.xmodelo2.setValueAt(xrs.getString(7), x, 8);
                    xvalor += xrs.getDouble(4);
                    x++;
                }
            }
            this.JTFFGTotal.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConciliacionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTotalizarGlosas() {
        double xgr = 0.0d;
        double xgnr = 0.0d;
        for (int x = 0; x < this.JTBRGDetalle.getRowCount(); x++) {
            xgr += Double.valueOf(this.xmodelo2.getValueAt(x, 4).toString()).doubleValue();
            xgnr += Double.valueOf(this.xmodelo2.getValueAt(x, 5).toString()).doubleValue();
        }
        this.JTFFGTotalR.setValue(Double.valueOf(xgr));
        this.JTFFGTotalNR.setValue(Double.valueOf(xgnr));
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mCargarValoresGlosa(long xid, int xpos) {
        try {
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(`ValorA`) AS `VAceptado`, SUM(`ValorR`) AS `VRecuperado` FROM  `f_factura_glosa_respuesta` WHERE (`Id_Factura_glosa` ='" + xid + "' AND `Estado` =1) GROUP BY `Id_Factura_glosa` ";
            ResultSet rs = xct2.traerRs(this.xsql);
            if (rs.next()) {
                rs.first();
                this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(2)), xpos, 4);
                this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(1)), xpos, 5);
            } else {
                this.xmodelo2.setValueAt(0, xpos, 4);
                this.xmodelo2.setValueAt(0, xpos, 5);
            }
            rs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConciliacionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
