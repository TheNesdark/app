package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFInformeC_PFecha.class */
public class JIFInformeC_PFecha extends JInternalFrame {
    private String xnombre;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private String[][] xid;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JCheckBox JCHDetalle;
    private JCheckBox JCHFiltro;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPIDatos;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFBusqueda;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xcodigopro = "";

    public JIFInformeC_PFecha(String xnombre) {
        initComponents();
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
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

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JTFBusqueda = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JCHDetalle = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformescontables_fecha");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "AUXILIAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 256, 32767).addContainerGap()));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Puc", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFInformeC_PFecha.1
            public void keyPressed(KeyEvent evt) {
                JIFInformeC_PFecha.this.JTFBusquedaKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 13));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro");
        this.JCHDetalle.setFont(new Font("Arial", 1, 13));
        this.JCHDetalle.setText("Detalle");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFBusqueda, -2, 158, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHDetalle).addContainerGap(85, 32767)).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -1, -1, 32767).addComponent(this.JDCFechaFin, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFBusqueda, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCHDetalle))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosC, -2, -1, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaKeyPressed(KeyEvent evt) {
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Auxiliar", "Consultar?"}) { // from class: Contabilidad.JIFInformeC_PFecha.2
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
    }

    private void mCargarDatos() {
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "SELECT `" + this.xcc_puc + "`.`Id`  , `" + this.xcc_puc + "`.`Nbre`\nFROM `" + this.xcc_detalle_documentoc + "`  INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`)\nWHERE  `" + this.xcc_puc + "`.`Id` like '" + this.JTFBusqueda.getText() + "%'\nGROUP BY `" + this.xcc_puc + "`.`Id`\nORDER BY `" + this.xcc_puc + "`.`Id` ASC";
        } else {
            this.xsql = "SELECT `" + this.xcc_puc + "`.`Id`  , `" + this.xcc_puc + "`.`Nbre`\nFROM `" + this.xcc_detalle_documentoc + "`  INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`)\nGROUP BY `" + this.xcc_puc + "`.`Id`\nORDER BY `" + this.xcc_puc + "`.`Id` ASC";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mNuevo() {
        this.JTFBusqueda.setText("");
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        mCrearModeloDatos();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscar() {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFInformeC_PFecha.mBuscar():void");
    }

    private void mConsultaTercero() {
        this.xcodigopro = "";
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.JTDetalle.getValueAt(x, 2).toString()).booleanValue()) {
                this.xcodigopro += "','" + this.xmodelo.getValueAt(x, 0).toString() + "','";
            }
        }
        this.xct.ejecutarSQL("delete from cc_balance_tercero");
        this.xct.cerrarConexionBd();
        String xsql = " INSERT INTO cc_balance_tercero( `Id_Auxiliar` ,`Id_Tercero` , `SAnterior` , `VDebito` , `VCredito` , `SActual`) SELECT   Id_Puc,  Id_Tercero,  SUM(SALDO_ANTERIOR) SALDO_ANTERIOR,  SUM(VDEBITO) VDEBITO,  SUM(VCREDITO) VCREDITO,  SUM(SALDO_ACTUAL) SALDO_ACTUAL FROM (  SELECT   Id_Puc,   DET.Id_Tercero,   PUC.Tipo,   ENC.Id_PeriodoC,   CASE WHEN ENC.FechaD<'" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' THEN    CASE WHEN PUC.Tipo=0 THEN     DET.VDebito-DET.VCredito    ELSE     DET.VCredito-DET.VDebito     END   ELSE    0    END  SALDO_ANTERIOR,         CASE WHEN (ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "') THEN    DET.VDebito   ELSE    0   END  VDEBITO,      CASE WHEN (ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "') THEN    DET.VCredito   ELSE    0   END  VCREDITO,       CASE WHEN PUC.Tipo=0 THEN    DET.VDebito-DET.VCredito   ELSE    DET.VCredito-DET.VDebito    END SALDO_ACTUAL  FROM  " + this.xcc_detalle_documentoc + " DET  INNER JOIN " + this.xcc_documentoc + "  ENC  ON DET.Id_Documentoc = ENC.Id  INNER JOIN " + this.xcc_puc + " PUC   ON (DET.Id_Puc = PUC.Id)  WHERE Id_Puc in('" + this.xcodigopro + "') and ENC.Estado=1  AND Id_PeriodoC<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' ) TODO GROUP BY Id_Puc, Id_Tercero";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Del " + this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " Al " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "p1";
        parametros[2][1] = this.xcodigopro.substring(2, this.xcodigopro.length() - 2);
        parametros[3][0] = "Titulo";
        parametros[3][1] = getTitle();
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xnombre.equals("Informe Libro Auxiliar")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar", parametros);
        } else {
            if (!this.xnombre.equals("Informe Libro Auxiliar Tercero") && this.xnombre.equals("Informe Libro Auxiliar Banco")) {
            }
        }
    }
}
