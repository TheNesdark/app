package Laboratorio;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFAuditoriaTiempos.class */
public class JIFAuditoriaTiempos extends JInternalFrame {
    private DefaultTableModel xmodelotabla;
    private Object xjfe;
    private String xnombre;
    private String xsql;
    private String[] xidsede;
    private String xFiltro;
    private ButtonGroup JBGFiltro;
    private JComboBox JCBSede;
    private JCheckBox JCHFiltro;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalleResultado;
    private JFormattedTextField JTFFNMuestrs;
    private JFormattedTextField JTFFNPromedio;
    private JFormattedTextField JTFFNPromediodia;
    private JFormattedTextField JTFFNTMinutos;
    private JFormattedTextField JTFFNTriage;
    private JTable JTResultado;
    private JPanel jPanel1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    public boolean xfiltro = true;
    public boolean xlleno = false;

    public JIFAuditoriaTiempos(String xnombre, String xnombref) {
        initComponents();
        setTitle(xnombref.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPIConsolidado = new JPanel();
        this.JTFFNTriage = new JFormattedTextField();
        this.JTFFNTMinutos = new JFormattedTextField();
        this.JTFFNPromedio = new JFormattedTextField();
        this.JTFFNMuestrs = new JFormattedTextField();
        this.JTFFNPromediodia = new JFormattedTextField();
        this.JCBSede = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA DE TIEMPO DE ESPERA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftiemposespera");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION TIEMPO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setName("jptriage");
        this.JPIDatosC.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFAuditoriaTiempos.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAuditoriaTiempos.this.JDCFechaIPropertyChange(evt);
            }
        });
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFAuditoriaTiempos.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAuditoriaTiempos.this.JDCFechaFPropertyChange(evt);
            }
        });
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "Consolidado", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ordenes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNTriage.setHorizontalAlignment(4);
        this.JTFFNTriage.setFont(new Font("Arial", 1, 12));
        this.JTFFNTMinutos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Minutos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNTMinutos.setHorizontalAlignment(4);
        this.JTFFNTMinutos.setFont(new Font("Arial", 1, 12));
        this.JTFFNPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio (Minutos)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNPromedio.setHorizontalAlignment(4);
        this.JTFFNPromedio.setFont(new Font("Arial", 1, 14));
        this.JTFFNMuestrs.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Estudios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNMuestrs.setHorizontalAlignment(4);
        this.JTFFNMuestrs.setFont(new Font("Arial", 1, 12));
        this.JTFFNPromediodia.setBorder(BorderFactory.createTitledBorder((Border) null, "Prom por día", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNPromediodia.setHorizontalAlignment(4);
        this.JTFFNPromediodia.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFNTriage, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNMuestrs, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNPromediodia, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNTMinutos, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNPromedio, -2, 135, -2)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNTriage, -2, -1, -2).addComponent(this.JTFFNTMinutos, -2, -1, -2).addComponent(this.JTFFNPromedio, -2, -1, -2).addComponent(this.JTFFNMuestrs, -2, -1, -2).addComponent(this.JTFFNPromediodia, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Laboratorio.JIFAuditoriaTiempos.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTiempos.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaF, -2, 143, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHFiltro).addGap(18, 18, 18).addComponent(this.JCBSede, 0, 233, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIConsolidado, -2, -1, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 56, -2).addComponent(this.JDCFechaF, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSede).addComponent(this.JCHFiltro)).addContainerGap()).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIConsolidado, -2, -1, -2).addGap(0, 0, 32767)));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JSPDetalleResultado))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleResultado, -2, 323, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 939, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 602, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mLLenarCombo();
    }

    private void mNuevo() {
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTablaDetalle();
        mLLenarCombo();
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBSede.removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.xnombre.equals("jiftiemposesperarx") || this.xnombre.equals("jiftiemposesperarx2")) {
            this.xsql = "SELECT `g_sedes`.`Id`, `g_sedes`.`Nbre` FROM  `l_recepcion` INNER JOIN  `g_sedes`  ON (`l_recepcion`.`Id_Sede` = `g_sedes`.`Id`) WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') >='" + this.xmetodos.formatoDMA1.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') <='" + this.xmetodos.formatoDMA.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0) GROUP BY `g_sedes`.`Id`";
        } else {
            this.xsql = "SELECT `g_sedes`.`Id`, `g_sedes`.`Nbre` FROM  `l_recepcion` INNER JOIN  `g_sedes`  ON (`l_recepcion`.`Id_Sede` = `g_sedes`.`Id`) WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') >='" + this.xmetodos.formatoDMA1.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') <='" + this.xmetodos.formatoDMA.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0) GROUP BY `g_sedes`.`Id`";
        }
        this.xidsede = xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBSede.getSelectedIndex() != -1) {
                mCrearTablaDetalle();
                mCargarDatosTabla();
                this.JTFFNPromediodia.setValue(Double.valueOf(Double.parseDouble(this.JTFFNMuestrs.getValue().toString()) / Double.parseDouble(this.JTFFNTriage.getValue().toString())));
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede a consultar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSede.requestFocus();
                return;
            }
        }
        mCrearTablaDetalle();
        mCargarDatosTabla();
        this.JTFFNPromediodia.setValue(Double.valueOf(Double.parseDouble(this.JTFFNMuestrs.getValue().toString()) / Double.parseDouble(this.JTFFNTriage.getValue().toString())));
    }

    private void mCrearTablaDetalle() {
        this.xmodelotabla = new DefaultTableModel() { // from class: Laboratorio.JIFAuditoriaTiempos.4
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.xmodelotabla.addColumn("Id");
        this.xmodelotabla.addColumn("Fecha Recepcion");
        this.xmodelotabla.addColumn("Hora Fact");
        this.xmodelotabla.addColumn("Hora Rep");
        this.xmodelotabla.addColumn("Diferencia");
        this.xmodelotabla.addColumn("");
        this.JTResultado.setModel(this.xmodelotabla);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql;
        if (this.xnombre.equals("jiftiemposesperarx") || this.xnombre.equals("jiftiemposesperarx2")) {
            this.JTFFNMuestrs.setValue(Integer.valueOf(mCalcularEstudio()));
            sql = "SELECT `h_radiologia`.`Id` AS Idradiologia, DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%d-%m-%Y') AS FechaRep,f_ordenes.HoraOrden AS HoraFact, DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S') AS HoraRecep, TIMEDIFF(DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S'),f_ordenes.HoraOrden) AS DifTiempo, HOUR(TIMEDIFF(DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S'),f_ordenes.HoraOrden))  AS Hora,MINUTE(TIMEDIFF(DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S'),f_ordenes.HoraOrden))  AS Minuto, SECOND(TIMEDIFF(DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S'),f_ordenes.HoraOrden))  AS segundo FROM h_radiologia INNER JOIN f_ordenes  ON (h_radiologia.`Id_OrdenFac` = f_ordenes.Id)WHERE (h_radiologia.Id <>0 AND h_radiologia.`Estado`=1 AND f_ordenes.HoraOrden IS NOT NULL AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d')>='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d')<='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND TIMEDIFF(DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%H:%i:%S'),f_ordenes.HoraOrden) >='00:00:00')";
        } else {
            this.JTFFNMuestrs.setValue(Integer.valueOf(mCalcularEstudio()));
            if (this.JCHFiltro.isSelected()) {
                sql = "SELECT\n  l_recepcion.Id AS Idrecepcion  , DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') AS FechaRep, DATE_FORMAT(f_ordenes.`Fecha`, '%H:%i:%S') AS HoraFact, DATE_FORMAT(l_recepcion.FechaRecep, '%H:%i:%S') AS HoraRecep, TIMEDIFF (DATE_FORMAT(l_recepcion.FechaRecep, '%H:%i:%S'), DATE_FORMAT(f_ordenes.Fecha, '%H:%i:%S')) AS DifTiempo\n  , HOUR(TIMEDIFF(DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S'), DATE_FORMAT(f_ordenes.Fecha, '%H:%i:%S'))) AS Hora, MINUTE(TIMEDIFF(DATE_FORMAT(l_recepcion.FechaRecep, '%H:%i:%S'), DATE_FORMAT(f_ordenes.Fecha, '%H:%i:%S'))) AS Minuto, SECOND(TIMEDIFF(DATE_FORMAT(l_recepcion.FechaRecep, '%H:%i:%S'), DATE_FORMAT(f_ordenes.Fecha, '%H:%i:%S'))) AS segundo FROM l_recepcion INNER JOIN f_ordenes  ON (l_recepcion.Id_OrdenFacturac = f_ordenes.Id)  WHERE (l_recepcion.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and l_recepcion.Id <>0 AND l_recepcion.`Estado`=0 AND f_ordenes.FechaRAtencion IS NOT NULL AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d')>='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' and DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d')<='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')) >='00:00:00')";
            } else {
                sql = "SELECT l_recepcion.Id AS Idrecepcion  , DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') AS FechaRep,DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S') AS HoraFact, DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S') AS HoraRecep, TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')) AS DifTiempo   , HOUR(TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')))  AS Hora, MINUTE(TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')))  AS Minuto, SECOND(TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')))  AS segundo  FROM l_recepcion INNER JOIN f_ordenes  ON (l_recepcion.Id_OrdenFacturac = f_ordenes.Id)  WHERE (l_recepcion.Id <>0 AND l_recepcion.`Estado`=0 AND f_ordenes.FechaRAtencion IS NOT NULL AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d')>='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' and DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d')<='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND TIMEDIFF(DATE_FORMAT(f_ordenes.FechaRAtencion,'%H:%i:%S'), DATE_FORMAT(l_recepcion.FechaRecep,'%H:%i:%S')) >='00:00:00')";
            }
        }
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                this.JTFFNTriage.setValue(new Integer(0));
                this.JTFFNTMinutos.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
                rs.beforeFirst();
                int xn = 0;
                int xnt = 0;
                int xh = 0;
                int xm = 0;
                int xs = 0;
                while (rs.next()) {
                    this.xmodelotabla.addRow((Object[]) null);
                    this.xmodelotabla.setValueAt(rs.getString(1), xn, 0);
                    this.xmodelotabla.setValueAt(rs.getString(2), xn, 1);
                    this.xmodelotabla.setValueAt(rs.getString(3), xn, 2);
                    this.xmodelotabla.setValueAt(rs.getString(4), xn, 3);
                    this.xmodelotabla.setValueAt(rs.getString(5), xn, 4);
                    xh += rs.getInt(6);
                    xm += rs.getInt(7);
                    xs += rs.getInt(8);
                    if (rs.getInt(7) >= 10) {
                        this.xmodelotabla.setValueAt("1", xn, 5);
                        this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    } else {
                        this.xmodelotabla.setValueAt("0", xn, 5);
                        this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    }
                    xn++;
                    xnt++;
                }
                double xtotalt = (xh * 60) + xm + (xs / 60);
                this.JTFFNTriage.setValue(Integer.valueOf(xnt));
                this.JTFFNTMinutos.setValue(Double.valueOf(xtotalt));
                this.JTFFNPromedio.setValue(Double.valueOf(xtotalt / ((double) xnt)));
            } else {
                this.JTFFNTriage.setValue(new Integer(0));
                this.JTFFNTMinutos.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaTiempos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mCalcularEstudio() {
        String sql;
        int valor = 0;
        if (this.xnombre.equals("jiftiemposesperarx") || this.xnombre.equals("jiftiemposesperarx2")) {
            sql = "SELECT COUNT(`h_radiologia_detalle`.`Id_radiologia`) AS placas FROM `h_radiologia_detalle` INNER JOIN `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)WHERE (DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d')<='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND h_radiologia.`Estado`=1)";
        } else if (this.JCHFiltro.isSelected()) {
            sql = "SELECT COUNT(`l_resultados`.`Id`) AS cantidad FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)WHERE (l_recepcion.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d') >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "'  AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d') <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0)";
        } else {
            sql = "SELECT COUNT(`l_resultados`.`Id`) AS cantidad FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d') >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "'  AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d') <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0)";
        }
        try {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                valor = xrs.getInt(1);
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaTiempos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return valor;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFAuditoriaTiempos$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 5).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
