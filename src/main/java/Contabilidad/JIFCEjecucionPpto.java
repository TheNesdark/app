package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCEjecucionPpto.class */
public class JIFCEjecucionPpto extends JInternalFrame {
    private DefaultTableModel xmodelodpc;
    private DefaultTableModel xmodeloep;
    private String[] xidperiodof;
    private boolean xlleno;
    private Object[] xdato;
    private String xsql;
    private String xcc_puc;
    private Vector xvector;
    private Class[] xtypes;
    private boolean[] xcanEdit;
    private JComboBox JCBPeridoF;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetallePc;
    private JScrollPane JSPDetallePpt;
    private JTable JTDetallePc;
    private JTable JTDetallePpt;
    private JButton jButton1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xllenoppto = false;

    public JIFCEjecucionPpto() {
        this.xlleno = false;
        initComponents();
        this.xidperiodof = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_periodo_financiero WHERE (Estado =1) ORDER BY Nbre ASC", this.xidperiodof, this.JCBPeridoF);
        this.xconsultas.cerrarConexionBd();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        mNuevo();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JCBPeridoF = new JComboBox();
        this.JSPDetallePc = new JScrollPane();
        this.JTDetallePc = new JTable();
        this.jButton1 = new JButton();
        this.JSPDetallePpt = new JScrollPane();
        this.JTDetallePpt = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("EJECUCIÓN PRESUPUESTAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcejecucionppto");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeridoF.setFont(new Font("Arial", 0, 13));
        this.JCBPeridoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Financiero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeridoF.addItemListener(new ItemListener() { // from class: Contabilidad.JIFCEjecucionPpto.1
            public void itemStateChanged(ItemEvent evt) {
                JIFCEjecucionPpto.this.JCBPeridoFItemStateChanged(evt);
            }
        });
        this.JSPDetallePc.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodos Contables", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetallePc.setFont(new Font("Arial", 1, 12));
        this.JTDetallePc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetallePc.setRowHeight(25);
        this.JTDetallePc.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFCEjecucionPpto.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCEjecucionPpto.this.JTDetallePcPropertyChange(evt);
            }
        });
        this.JSPDetallePc.setViewportView(this.JTDetallePc);
        this.jButton1.setText("jButton1");
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCEjecucionPpto.3
            public void actionPerformed(ActionEvent evt) {
                JIFCEjecucionPpto.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeridoF, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JSPDetallePc, -1, 554, 32767).addGap(18, 18, 18).addComponent(this.jButton1).addGap(132, 132, 132)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBPeridoF).addGap(49, 49, 49)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton1).addGap(25, 25, 25)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JSPDetallePc, -2, 97, -2).addContainerGap()));
        this.JSPDetallePpt.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetallePpt.setFont(new Font("Arial", 1, 12));
        this.JTDetallePpt.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetallePpt.setRowHeight(25);
        this.JSPDetallePpt.setViewportView(this.JTDetallePpt);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetallePpt, GroupLayout.Alignment.LEADING, -1, 1059, 32767).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetallePpt, -2, 499, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeridoFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBPeridoF.getSelectedIndex() != -1) {
            mCargarDatosTPeriodoC();
            this.xllenoppto = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePcPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoppto && this.JTDetallePc.getSelectedRow() != -1) {
            mAgregarColumnaTablaPpto();
            mCargarDatosTPpto();
            this.xmodelodpc.setValueAt(Integer.valueOf(this.JTDetallePpt.getColumnCount() - 3), this.JTDetallePc.getSelectedRow(), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mCargarValoresPresupuesto();
    }

    public void mNuevo() {
        this.JCBPeridoF.setSelectedIndex(-1);
        mCrearTablaPeriodoC();
    }

    private void mCrearTablaPeriodoC() {
        this.xmodelodpc = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Perido", "Estado", "Consultar?", "PeridoL", "IdColumna", "Total Ejecutado"}) { // from class: Contabilidad.JIFCEjecucionPpto.4
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetallePc.setModel(this.xmodelodpc);
        this.JTDetallePc.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDetallePc.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetallePc.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetallePc.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetallePc.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetallePc.getColumnModel().getColumn(6).setPreferredWidth(40);
    }

    private void mCrearTablaPpt() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.5
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt1() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.6
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt2() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.7
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt3() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.8
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt4() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.9
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt5() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.10
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt6() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.11
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt7() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.12
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt8() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.13
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt9() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.14
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt10() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.15
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt11() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.16
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCrearTablaPpt12() {
        this.xmodeloep = new DefaultTableModel(null, this.xvector) { // from class: Contabilidad.JIFCEjecucionPpto.17
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePpt.setModel(this.xmodeloep);
    }

    private void mCargarDatosTPeriodoC() {
        this.xsql = "SELECT Id, DATE_FORMAT(FechaI,'%m-%Y') AS PeridoC, Activo, IF(Activo=0,FALSE,TRUE) AS Tipo ,CONCAT(IF(DATE_FORMAT(FechaI,'%m')='01','ENERO',IF(DATE_FORMAT(FechaI,'%m')='02','FEBRERO', IF(DATE_FORMAT(FechaI,'%m')='03','MARZO',IF(DATE_FORMAT(FechaI,'%m')='04','ABRIL', IF(DATE_FORMAT(FechaI,'%m')='05' ,'MAYO',IF(DATE_FORMAT(FechaI,'%m')='06' ,'JUNIO',IF(DATE_FORMAT(FechaI,'%m')='07' ,'JULIO',IF(DATE_FORMAT(FechaI,'%m')='08' ,'AGOSTO', IF(DATE_FORMAT(FechaI,'%m')='09' ,'SEPTIEMBRE',IF(DATE_FORMAT(FechaI,'%m')='10' ,'OCTUBRE', IF(DATE_FORMAT(FechaI,'%m')='11' ,'NOVIEMBRE','DICIEMBRE'))))))))))),'-',DATE_FORMAT(FechaI,'%Y')) AS PeriodoN  FROM cc_periodo_contable WHERE cc_periodo_contable.Id_PeriodoF='" + this.xidperiodof[this.JCBPeridoF.getSelectedIndex()] + "'";
        mCrearTablaPeriodoC();
        ResultSet rs = this.xconsultas.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelodpc.addRow(this.xdato);
                    this.xmodelodpc.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelodpc.setValueAt(rs.getString(2), x, 1);
                    this.xmodelodpc.setValueAt(Boolean.valueOf(rs.getBoolean(3)), x, 2);
                    this.xmodelodpc.setValueAt(false, x, 3);
                    this.xmodelodpc.setValueAt(rs.getString(5), x, 4);
                    this.xmodelodpc.setValueAt(new Integer(0), x, 5);
                    this.xmodelodpc.setValueAt(new Integer(0), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosTPpto() {
        this.xsql = "SELECT cc_presupuesto_puc.Id, cc_conceptocmsa.Nbre, cc_presupuesto_puc.Id_Puc, " + this.xcc_puc + ".Nbre, cc_presupuesto_puc.Valor, cc_presupuesto_puc.TipoRecurso FROM cc_presupuesto_puc INNER JOIN " + this.xcc_puc + " ON (cc_presupuesto_puc.Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN cc_conceptocmsa  ON (cc_presupuesto_puc.Id_ConceptoCmsa = cc_conceptocmsa.Id) WHERE (cc_presupuesto_puc.Estado =1 AND cc_presupuesto_puc.Id_PeriodoF =1) ORDER BY cc_conceptocmsa.Nbre ASC, cc_presupuesto_puc.Id_Puc ASC ";
        ResultSet rs = this.xconsultas.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloep.addRow(this.xdato);
                    this.xmodeloep.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodeloep.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloep.setValueAt(rs.getString(3), x, 2);
                    this.xmodeloep.setValueAt(rs.getString(4), x, 3);
                    this.xmodeloep.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodeloep.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mAgregarColumnaTablaPpto() {
        this.xvector = new Vector();
        this.xvector.add("Id");
        this.xvector.add("Concepto");
        this.xvector.add("Cuenta");
        this.xvector.add("Nombre Cuenta");
        this.xvector.add("Valor");
        this.xvector.add("Recurso");
        int xnumero = 0;
        for (int x = 0; x < this.JTDetallePc.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelodpc.getValueAt(x, 3).toString()).booleanValue()) {
                xnumero++;
                this.xvector.add("Ejecutado-" + this.xmodelodpc.getValueAt(x, 4).toString());
                this.xvector.add("% Ejecución-" + this.xmodelodpc.getValueAt(x, 4).toString());
                this.xvector.add("Saldo-" + this.xmodelodpc.getValueAt(x, 4).toString());
            }
        }
        mInicializarTipoDatosTable(xnumero);
    }

    public Class[] mInicializarTipoDatosTable(int xn) {
        switch (xn) {
            case 1:
                mCrearTablaPpt1();
                break;
            case 2:
                mCrearTablaPpt2();
                break;
            case 3:
                mCrearTablaPpt3();
                break;
            case 4:
                mCrearTablaPpt4();
                break;
            case 5:
                mCrearTablaPpt5();
            case 6:
                mCrearTablaPpt6();
                break;
            case 7:
                mCrearTablaPpt7();
                break;
            case 8:
                mCrearTablaPpt8();
                break;
            case 9:
                mCrearTablaPpt9();
                break;
            case 10:
                mCrearTablaPpt10();
                break;
            case 11:
                mCrearTablaPpt11();
                break;
            case 12:
                mCrearTablaPpt12();
                break;
            default:
                mCrearTablaPpt();
                break;
        }
        return this.xtypes;
    }

    private void mCargarValoresPresupuesto() {
        for (int x = 0; x < this.JTDetallePc.getRowCount(); x++) {
            if (Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() != 0) {
                double xvalottotal = 0.0d;
                for (int y = 0; y < this.JTDetallePpt.getRowCount(); y++) {
                    try {
                        this.xsql = "SELECT Valor FROM cc_presupuesto WHERE (Id_PresupuestoPuc ='" + this.xmodeloep.getValueAt(y, 0) + "' AND Id_periodoC ='" + this.xmodelodpc.getValueAt(x, 0) + "') ";
                        ResultSet rs = this.xconsultas.traerRs(this.xsql);
                        if (rs.next()) {
                            rs.first();
                            this.xmodeloep.setValueAt(Double.valueOf(rs.getDouble(1)), y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue());
                            Double xvalor = Double.valueOf((rs.getDouble(1) / Double.valueOf(this.xmodeloep.getValueAt(y, 4).toString()).doubleValue()) * 100.0d);
                            if (xvalor.doubleValue() > 0.0d && !xvalor.toString().equals("Infinity")) {
                                this.xmodeloep.setValueAt(xvalor, y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() + 1);
                            } else {
                                this.xmodeloep.setValueAt(0, y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() + 1);
                            }
                            this.xmodeloep.setValueAt(Double.valueOf(rs.getDouble(1) - Double.valueOf(this.xmodeloep.getValueAt(y, 4).toString()).doubleValue()), y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() + 2);
                            xvalottotal += rs.getDouble(1);
                        } else {
                            this.xmodeloep.setValueAt(0, y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue());
                            this.xmodeloep.setValueAt(0, y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() + 1);
                            this.xmodeloep.setValueAt(Double.valueOf(0.0d - Double.valueOf(this.xmodeloep.getValueAt(y, 4).toString()).doubleValue()), y, Integer.valueOf(this.xmodelodpc.getValueAt(x, 5).toString()).intValue() + 2);
                        }
                        rs.close();
                        this.xconsultas.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFCEjecucionPpto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                this.xmodelodpc.setValueAt(Double.valueOf(xvalottotal), x, 6);
            }
        }
    }

    private void mCalcularDatos() {
    }
}
