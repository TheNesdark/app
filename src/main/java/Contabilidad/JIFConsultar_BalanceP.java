package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JYearChooser;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultar_BalanceP.class */
public class JIFConsultar_BalanceP extends JInternalFrame {
    private String[][] xid;
    private String xPadre;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private String xTitulo;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBG_Tipo;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JCheckBox JCHAplicaNiif;
    private JCheckBox JCH_CSaldo;
    private JCheckBox JCH_IncluirMovCierre;
    private JCheckBox JCH_Tercero;
    private JPanel JPI_Vsualizar;
    private JRadioButton JRB_Tipo1;
    private JRadioButton JRB_Tipo2;
    private JTextField JTFRuta;
    private JTable JTH_Detalle;
    private JYearChooser JYCAno;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xNCaracter = 0;
    private final int xM = 2;
    private String[] x6 = new String[4];
    private String[] x8 = new String[5];
    private String[] x10 = new String[6];
    private String[] x12 = new String[7];
    private String xAplicaNiif = "in(0)";
    private String xIncluirCierre = "in(0,1)";
    private Metodos xmt = new Metodos();

    public JIFConsultar_BalanceP(String xTitulo) {
        initComponents();
        setTitle(xTitulo.toUpperCase());
        this.xTitulo = xTitulo;
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mCargarCombo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Tipo = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JCHActivo = new JCheckBox();
        this.JCH_Tercero = new JCheckBox();
        this.JCH_CSaldo = new JCheckBox();
        this.JCHAplicaNiif = new JCheckBox();
        this.JCH_IncluirMovCierre = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTH_Detalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPI_Vsualizar = new JPanel();
        this.JRB_Tipo1 = new JRadioButton();
        this.JRB_Tipo2 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTAR BALANCE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifbalancecontable_n");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultar_BalanceP.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultar_BalanceP.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCH_Tercero.setFont(new Font("Arial", 1, 13));
        this.JCH_Tercero.setText("Tercero");
        this.JCH_Tercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JCH_TerceroActionPerformed(evt);
            }
        });
        this.JCH_CSaldo.setFont(new Font("Arial", 1, 13));
        this.JCH_CSaldo.setSelected(true);
        this.JCH_CSaldo.setText("Con saldo?");
        this.JCH_CSaldo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JCH_CSaldoActionPerformed(evt);
            }
        });
        this.JCHAplicaNiif.setFont(new Font("Arial", 1, 13));
        this.JCHAplicaNiif.setText("Aplica NIIF");
        this.JCHAplicaNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JCHAplicaNiifActionPerformed(evt);
            }
        });
        this.JCH_IncluirMovCierre.setFont(new Font("Arial", 1, 13));
        this.JCH_IncluirMovCierre.setSelected(true);
        this.JCH_IncluirMovCierre.setText("Incluir Movimiento Cierre?");
        this.JCH_IncluirMovCierre.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JCH_IncluirMovCierreActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodo, -2, 352, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCH_IncluirMovCierre, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_CSaldo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHActivo, -2, 79, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHAplicaNiif, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Tercero, -2, 183, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Tercero).addComponent(this.JCHAplicaNiif)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHActivo).addComponent(this.JCH_CSaldo).addComponent(this.JCH_IncluirMovCierre))).addComponent(this.JCBPeriodo, -2, 50, -2)).addComponent(this.JYCAno, -2, 50, -2)).addGap(5, 5, 5)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTH_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTH_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTH_Detalle.setRowHeight(25);
        this.JTH_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTH_Detalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTH_Detalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultar_BalanceP.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_BalanceP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPI_Vsualizar.setBorder(BorderFactory.createTitledBorder((Border) null, "Visualización cuentas puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Tipo.add(this.JRB_Tipo1);
        this.JRB_Tipo1.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo1.setSelected(true);
        this.JRB_Tipo1.setText("Colgaap");
        this.JRB_Tipo1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JRB_Tipo1ActionPerformed(evt);
            }
        });
        this.JBG_Tipo.add(this.JRB_Tipo2);
        this.JRB_Tipo2.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo2.setText("Niif");
        this.JRB_Tipo2.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_BalanceP.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_BalanceP.this.JRB_Tipo2ActionPerformed(evt);
            }
        });
        GroupLayout JPI_VsualizarLayout = new GroupLayout(this.JPI_Vsualizar);
        this.JPI_Vsualizar.setLayout(JPI_VsualizarLayout);
        JPI_VsualizarLayout.setHorizontalGroup(JPI_VsualizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_VsualizarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Tipo1).addGap(18, 18, 18).addComponent(this.JRB_Tipo2).addContainerGap(37, 32767)));
        JPI_VsualizarLayout.setVerticalGroup(JPI_VsualizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_VsualizarLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_VsualizarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Tipo1).addComponent(this.JRB_Tipo2))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_Vsualizar, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 464, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JPI_Vsualizar, -1, -1, 32767)).addContainerGap()));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTH_Detalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTH_Detalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_TerceroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CSaldoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaNiifActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaNiif.isSelected()) {
            this.xAplicaNiif = "IN (0,1)";
            this.JRB_Tipo2.setSelected(true);
        } else {
            this.xAplicaNiif = "IN (0)";
            this.JRB_Tipo1.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_IncluirMovCierreActionPerformed(ActionEvent evt) {
        if (this.JCH_IncluirMovCierre.isSelected()) {
            this.xIncluirCierre = "in(0,1)";
        } else {
            this.xIncluirCierre = "in(0)";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo2ActionPerformed(ActionEvent evt) {
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscar_Niif() {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_BalanceP.mBuscar_Niif():void");
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscarM() {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_BalanceP.mBuscarM():void");
    }

    private void mConsultaTercero() {
        this.xct.ejecutarSQL("delete from cc_balance_tercero");
        this.xct.cerrarConexionBd();
        String xsql = " INSERT INTO cc_balance_tercero( `Id_Auxiliar` ,`Id_Tercero` , `SAnterior` , `VDebito` , `VCredito` , `SActual`) SELECT   Id_Puc,  Id_Tercero,  SUM(SALDO_ANTERIOR) SALDO_ANTERIOR,  SUM(VDEBITO) VDEBITO,  SUM(VCREDITO) VCREDITO,  SUM(SALDO_ACTUAL) SALDO_ACTUAL FROM (  SELECT   Id_Puc,   DET.Id_Tercero,   PUC.Tipo,   ENC.Id_PeriodoC,   CASE WHEN ENC.Id_PeriodoC<'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' THEN    CASE WHEN PUC.Tipo=0 THEN     DET.VDebito-DET.VCredito    ELSE     DET.VCredito-DET.VDebito     END   ELSE    0    END  SALDO_ANTERIOR,         CASE WHEN ENC.Id_PeriodoC='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' THEN    DET.VDebito   ELSE    0   END  VDEBITO,      CASE WHEN ENC.Id_PeriodoC='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' THEN    DET.VCredito   ELSE    0   END  VCREDITO,       CASE WHEN PUC.Tipo=0 THEN    DET.VDebito-DET.VCredito   ELSE    DET.VCredito-DET.VDebito    END SALDO_ACTUAL  FROM  " + this.xcc_detalle_documentoc + " DET  INNER JOIN " + this.xcc_documentoc + "  ENC  ON DET.Id_Documentoc = ENC.Id  INNER JOIN cc_periodo_contable   ON ENC.Id_PeriodoC = cc_periodo_contable.Id  INNER JOIN `cc_tipo_documentoc` \n        ON (`ENC`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN " + this.xcc_puc + " PUC   ON (DET.Id_Puc = PUC.Id)  WHERE cc_periodo_contable.EsCierre " + this.xIncluirCierre + " and PUC.AplicaNiif " + this.xAplicaNiif + " and `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + " and  ENC.Estado=1  AND Id_PeriodoC<='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' ) TODO GROUP BY Id_Puc, Id_Tercero";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCargarCombo() {
        String sql;
        this.JCBPeriodo.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (this.JCHActivo.isSelected()) {
            sql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE Activo=1 and date_format(FechaI,'%Y')='" + this.JYCAno.getValue() + "' ORDER BY Id DESC; ";
        } else {
            sql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE  Activo=0 and date_format(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(sql, this.xid, this.JCBPeriodo, 6);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdPuc", "Nombre PUC", "S/Anterior", "V/Debito", "V/Credito", "S/Actual"}) { // from class: Contabilidad.JIFConsultar_BalanceP.11
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTH_Detalle.setModel(this.xmodelo2);
        JTable jTable = this.JTH_Detalle;
        JTable jTable2 = this.JTH_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTH_Detalle.doLayout();
        this.JTH_Detalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTH_Detalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void mCargarHistorial() {
        String xsql2;
        String xsql22;
        try {
            mCrearModeloDatos2();
            if (this.JCH_CSaldo.isSelected()) {
                if (this.JRB_Tipo1.isSelected()) {
                    xsql2 = "SELECT " + this.xcc_puc + ".Id, " + this.xcc_puc + ".Nbre, " + this.xcc_puc + ".SaldoAnterior, " + this.xcc_puc + ".VDebito, " + this.xcc_puc + ".VCredito, " + this.xcc_puc + ".SaldoActual, " + this.xcc_puc + ".id_nivel,  " + this.xcc_puc + ".Id_Tercero \nFROM  " + this.xcc_puc + " ,`d_ips`\nWHERE( (" + this.xcc_puc + ".SaldoAnterior<>0 || " + this.xcc_puc + ".VDebito<>0 || " + this.xcc_puc + ".VCredito<>0 || " + this.xcc_puc + ".SaldoActual<>0) and " + this.xcc_puc + ".AplicaNiif " + this.xAplicaNiif + "  ) \nORDER BY " + this.xcc_puc + ".Id ASC";
                } else {
                    xsql2 = "SELECT cc_puc_niif.Id, cc_puc_niif.Nbre,cc_puc_niif.SaldoAnterior,cc_puc_niif.VDebito, cc_puc_niif.VCredito, cc_puc_niif.SaldoActual,cc_puc_niif.id_nivel, cc_puc_niif.Id_Tercero \nFROM cc_puc_niif ,`d_ips`\nWHERE( (cc_puc_niif.SaldoAnterior<>0 || cc_puc_niif.VDebito<>0 || cc_puc_niif.VCredito<>0 ||cc_puc_niif.SaldoActual<>0)   ) \nORDER BY cc_puc_niif.Id ASC";
                }
            } else if (this.JRB_Tipo1.isSelected()) {
                xsql2 = "SELECT " + this.xcc_puc + ".Id, " + this.xcc_puc + ".Nbre, " + this.xcc_puc + ".SaldoAnterior, " + this.xcc_puc + ".VDebito, " + this.xcc_puc + ".VCredito, " + this.xcc_puc + ".SaldoActual, " + this.xcc_puc + ".id_nivel,  " + this.xcc_puc + ".Id_Tercero \nFROM  " + this.xcc_puc + " ,`d_ips`\n where " + this.xcc_puc + ".AplicaNiif " + this.xAplicaNiif + " ORDER BY " + this.xcc_puc + ".Id ASC";
            } else {
                xsql2 = "SELECT cc_puc_niif.Id, cc_puc_niif.Nbre, cc_puc_niif.SaldoAnterior, cc_puc_niif.VDebito,cc_puc_niif.VCredito, cc_puc_niif.SaldoActual, cc_puc_niif.id_nivel, cc_puc_niif.Id_Tercero \n FROM cc_puc_niif ,`d_ips`\nORDER BY cc_puc_niif.Id ASC";
            }
            ResultSet xrs1 = this.xct.traerRs(xsql2);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(3)), i, 2);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(4)), i, 3);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(5)), i, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(6)), i, 5);
                    i++;
                    if (xrs1.getInt(8) == 1 && this.JCH_Tercero.isSelected()) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        if (this.JRB_Tipo1.isSelected()) {
                            xsql22 = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, SUM(`cc_balance_tercero`.`SAnterior`) AS `SAnterior`, SUM(`cc_balance_tercero`.`VDebito`) AS `VDebito`, SUM(`cc_balance_tercero`.`VCredito`) AS `VCredito`, SUM(`cc_balance_tercero`.`SActual`) AS `SActual`\nFROM `cc_terceros` \nINNER JOIN `cc_balance_tercero` ON (`cc_terceros`.`Id` = `cc_balance_tercero`.`Id_Tercero`) \nINNER JOIN `" + this.xcc_puc + "` ON (`cc_balance_tercero`.`Id_Auxiliar` = `" + this.xcc_puc + "`.`Id`)\nWHERE (`cc_balance_tercero`.`Id_Auxiliar` ='" + xrs1.getString(1) + "'  AND `" + this.xcc_puc + "`.`Id_Tercero` =1)\n GROUP BY `cc_balance_tercero`.`Id_Auxiliar`, `cc_balance_tercero`.`Id_Tercero` \n ORDER BY `cc_terceros`.`RazonSocial` ASC";
                        } else {
                            xsql22 = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, SUM(`cc_balance_tercero`.`SAnterior`) AS `SAnterior`, SUM(`cc_balance_tercero`.`VDebito`) AS `VDebito`, SUM(`cc_balance_tercero`.`VCredito`) AS `VCredito`, SUM(`cc_balance_tercero`.`SActual`) AS `SActual`\nFROM `cc_terceros`\nINNER JOIN `cc_balance_tercero` ON (`cc_terceros`.`Id` = `cc_balance_tercero`.`Id_Tercero`)\n    INNER JOIN `cc_pucg_niif`\n        ON (`cc_pucg_niif`.`Id_Puc_G` = `cc_balance_tercero`.`Id_Auxiliar`)\n    INNER JOIN  `cc_puc_niif` \n        ON (`cc_pucg_niif`.`Id_Puc_Niif` = `cc_puc_niif`.`Id`)\nWHERE (`cc_puc_niif`.`Id` ='" + xrs1.getString(1) + "' AND cc_puc_niif.`Id_Tercero` =1)\n GROUP BY `cc_balance_tercero`.`Id_Auxiliar`, `cc_balance_tercero`.`Id_Tercero`\n ORDER BY `cc_terceros`.`RazonSocial` ASC";
                        }
                        ResultSet xrs2 = xct1.traerRs(xsql22);
                        if (xrs2.next()) {
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                this.xmodelo2.addRow(this.xdatos);
                                this.xmodelo2.setValueAt(xrs2.getString(1), i, 0);
                                this.xmodelo2.setValueAt(xrs2.getString(2), i, 1);
                                this.xmodelo2.setValueAt(Double.valueOf(xrs2.getDouble(3)), i, 2);
                                this.xmodelo2.setValueAt(Double.valueOf(xrs2.getDouble(4)), i, 3);
                                this.xmodelo2.setValueAt(Double.valueOf(xrs2.getDouble(5)), i, 4);
                                this.xmodelo2.setValueAt(Double.valueOf(xrs2.getDouble(6)), i, 5);
                                i++;
                            }
                        }
                        xrs2.close();
                        xct1.cerrarConexionBd();
                    }
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_BalanceP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = this.JCBPeriodo.getSelectedItem().toString() + " - " + this.JYCAno.getValue();
        parametros[2][0] = "Titulo";
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JCH_Tercero.isSelected()) {
            if (this.JRB_Tipo1.isSelected()) {
                parametros[2][1] = "BALANCE DE COMPROBACIÓN POR TERCERO Y CON SALDO";
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion_Tercero_CSaldo", parametros);
                return;
            } else {
                parametros[2][1] = "BALANCE DE COMPROBACIÓN POR TERCERO Y CON SALDO NIIF";
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion_Tercero_CSaldo_Niif", parametros);
                return;
            }
        }
        if (this.JCH_CSaldo.isSelected()) {
            if (this.JRB_Tipo1.isSelected()) {
                parametros[2][1] = "BALANCE DE COMPROBACIÓN CON SALDO";
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion_CSaldo", parametros);
                return;
            } else {
                parametros[2][1] = "BALANCE DE COMPROBACIÓN CON SALDO NIIF";
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion_CSaldo_Niif", parametros);
                return;
            }
        }
        if (this.JRB_Tipo1.isSelected()) {
            parametros[2][1] = "BALANCE DE COMPROBACIÓN";
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion", parametros);
        } else {
            parametros[2][1] = "BALANCE DE COMPROBACIÓN NIIF";
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Prueba_Comprobacion_Niif", parametros);
        }
    }
}
