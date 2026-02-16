package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JDCargarInformacionVentas.class */
public class JDCargarInformacionVentas extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String[][] xidempresa;
    private JIFDocContable xjifdocontable;
    private String xobjetollamador;
    private Object[] xdato;
    private boolean xlleno;
    private String xsql;
    private DefaultTableModel xmodelo;
    private String xModulo;
    private JButton JBTCarguesA;
    private JButton JBTCarguesA1;
    private JComboBox JCBEmpresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;

    public JDCargarInformacionVentas(Frame parent, boolean modal, JIFDocContable xjif, String xModulo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xlleno = false;
        this.xModulo = "";
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        setTitle("INFORMACIÓN DE " + xModulo);
        this.xjifdocontable = xjif;
        this.xModulo = xModulo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCarguesA = new JButton();
        this.JBTCarguesA1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("INFORMACIÓN DE VENTAS");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JDCargarInformacionVentas.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDCargarInformacionVentas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 13));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JDCargarInformacionVentas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDCargarInformacionVentas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(13, 13, 13).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, -1, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addComponent(this.JCBEmpresa, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 204, 204));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Cargar Información");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: Contabilidad.JDCargarInformacionVentas.3
            public void actionPerformed(ActionEvent evt) {
                JDCargarInformacionVentas.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBTCarguesA1.setText("Buscar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Contabilidad.JDCargarInformacionVentas.4
            public void actionPerformed(ActionEvent evt) {
                JDCargarInformacionVentas.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTCarguesA1, -2, 390, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JBTCarguesA, -2, 390, -2)).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 248, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCarguesA1, -2, 50, -2).addComponent(this.JBTCarguesA, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCambio_Propiedad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCambio_Propiedad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.xModulo.equals("CIERRE CAJA")) {
                mCargar_Datos_Cierre_Caja();
            } else if (this.xModulo.equals("VENTAS")) {
                mCargarDatosTabla();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mImportar();
        }
    }

    private void mCambio_Propiedad() {
        if (this.xModulo.equals("CIERRE CAJA")) {
            mLlenarComboCaja();
        } else if (this.xModulo.equals("VENTAS")) {
            mLlenarComboEmpresa();
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"N°Factura", "Grupo", "Subgrupo", "CDebito", "CCredito", "TotalG", "TotalSubG", "IdTerceroComodin", "Id", "Cargar?", "NPuc", "Tipo"}) { // from class: Contabilidad.JDCargarInformacionVentas.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, Long.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        mCrearTablaDetalle();
        String xsql1 = null;
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
            this.xsql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento , f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, f_liquidacion.TotalEps, SUM(fact_liquidacion.TotalEps) AS Total, g_empresa.DocComodin , g_empresa.Id, cc_puc.Nbre, cc_puc.Tipo FROM f_factura_evento INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)INNER JOIN f_factura_capita  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) INNER JOIN fact_liquidacion  ON (fact_liquidacion.Id = f_factura_capita.Id_Liquidacion) INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = fact_liquidacion.Id_SubGrupoServicio) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)  INNER JOIN f_cuentacobro ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) AND (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id) INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Credito)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0) GROUP BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ORDER BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ASC, f_gruposervicio.Nbre ASC ";
            xsql1 = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, f_liquidacion.TotalEps, SUM(fact_liquidacion.TotalEps) AS Total, g_empresa.DocComodin , g_empresa.Id, cc_puc.Nbre, cc_puc.Tipo FROM f_factura_evento INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)INNER JOIN f_factura_capita  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) INNER JOIN fact_liquidacion  ON (fact_liquidacion.Id = f_factura_capita.Id_Liquidacion) INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = fact_liquidacion.Id_SubGrupoServicio) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)  INNER JOIN f_cuentacobro ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) AND (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id) INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Debito)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0 ) GROUP BY f_subgrupo_empresa.CPuc_Debito ORDER BY f_factura_evento.No_FacturaEvento ASC, f_gruposervicio.Nbre ASC ";
        } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1")) {
            if (!this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("4")) {
                this.xsql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento , f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, IF( g_empresacont.Id_TipoRegimen=4, f_liquidacion.TotalPaciente, f_liquidacion.TotalEps) AS TotalEps, IF( g_empresacont.Id_TipoRegimen=4, SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) AS Total, IF(f_factura_evento.`TipoFactura`=0, g_empresa.DocComodin ,g_empresa.`No_identificacion`) , g_empresa.Id, cc_puc.Nbre, cc_puc.Tipo  FROM f_factura_evento  INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = f_liquidacion.Id_SubGrupoServicio)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)     INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Credito)   INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Fecha_FacturaEvento  >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0) GROUP BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ORDER BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ASC, f_gruposervicio.Nbre ASC ";
                xsql1 = "SELECT f_factura_evento.No_FacturaEvento, f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, IF( g_empresacont.Id_TipoRegimen=4, f_liquidacion.TotalPaciente, f_liquidacion.TotalEps) AS TotalEps,   IF( g_empresacont.Id_TipoRegimen=4, SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) AS Total, g_empresa.DocComodin , g_empresa.Id, cc_puc.Nbre, cc_puc.Tipo  FROM f_factura_evento INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)  INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = f_liquidacion.Id_SubGrupoServicio)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)    INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Debito)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Fecha_FacturaEvento  >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0 ) GROUP BY f_subgrupo_empresa.CPuc_Debito ORDER BY f_factura_evento.No_FacturaEvento ASC, f_gruposervicio.Nbre ASC ";
            } else {
                this.xsql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, IF( g_empresacont.Id_TipoRegimen=4, f_liquidacion.TotalPaciente, f_liquidacion.TotalEps) AS TotalEps, IF( g_empresacont.Id_TipoRegimen=4, SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) AS Total, IF(f_factura_evento.`TipoFactura`=0, g_empresa.DocComodin ,g_persona.`NoDocumento`) , ingreso.Id_Usuario, cc_puc.Nbre, cc_puc.Tipo  FROM f_factura_evento  INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN  ingreso  ON (ingreso.Id= f_liquidacion.Id_Ingreso)  INNER JOIN  g_persona  ON (ingreso.`Id_Usuario`= g_persona.`Id`)   INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = f_liquidacion.Id_SubGrupoServicio)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)     INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Credito)   INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Fecha_FacturaEvento  >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0) GROUP BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ORDER BY f_factura_evento.No_FacturaEvento, f_subgruposervicio.Nbre ASC, f_gruposervicio.Nbre ASC ";
                xsql1 = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, f_gruposervicio.Nbre, f_subgruposervicio.Nbre, f_subgrupo_empresa.CPuc_Debito, f_subgrupo_empresa.CPuc_Credito, IF( g_empresacont.Id_TipoRegimen=4, f_liquidacion.TotalPaciente, f_liquidacion.TotalEps) AS TotalEps,   IF( g_empresacont.Id_TipoRegimen=4, SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) AS Total, g_empresa.DocComodin , 12215, cc_puc.Nbre, cc_puc.Tipo  FROM f_factura_evento INNER JOIN  f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN  ingreso  ON (ingreso.Id= f_liquidacion.Id_Ingreso) INNER JOIN  g_persona  ON (ingreso.`Id_Usuario`= g_persona.`Id`)  INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)  INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id = f_liquidacion.Id_SubGrupoServicio)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id)    INNER JOIN cc_puc ON (cc_puc.Id = f_subgrupo_empresa.CPuc_Debito)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)  WHERE (f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Fecha_FacturaEvento  >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Id_DocumentoC=0 ) GROUP BY f_subgrupo_empresa.CPuc_Debito ORDER BY f_factura_evento.No_FacturaEvento ASC, f_gruposervicio.Nbre ASC ";
            }
        }
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(true, n, 9);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 10);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(11)), n, 11);
                    n++;
                }
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs1 = xct2.traerRs(xsql1);
                xrs1.first();
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(xrs1.getString(1), n, 0);
                this.xmodelo.setValueAt(xrs1.getString(2), n, 1);
                this.xmodelo.setValueAt(xrs1.getString(3), n, 2);
                this.xmodelo.setValueAt(xrs1.getString(4), n, 3);
                this.xmodelo.setValueAt(xrs1.getString(5), n, 4);
                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble(6)), n, 5);
                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble(7)), n, 6);
                this.xmodelo.setValueAt(xrs1.getString(8), n, 7);
                this.xmodelo.setValueAt(xrs1.getString(9), n, 8);
                this.xmodelo.setValueAt(true, n, 9);
                this.xmodelo.setValueAt(xrs1.getString(10), n, 10);
                this.xmodelo.setValueAt(Integer.valueOf(xrs1.getInt(11)), n, 11);
                xrs1.close();
                xct2.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDCargarInformacionVentas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_Datos_Cierre_Caja() {
        try {
            mCrearTabla_Cierre_Caja();
            this.xsql = "SELECT  `k_cierre_n`.`Id` AS `Id_Cierre` , `k_caja`.`Nbre` AS `NCaja` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NCajero`  , `k_cierre_n`.`FechaI` AS `FCierre_Inicial` , `k_cierre_n`.`FechaF` AS `FCierre_Final` , `k_cierre_n`.`Valor` AS `VTotalCierre` , `k_cierre_n`.`Observacion` AS `ObservacionCierre` , `k_cierre_n`.`Id_DocumentoC` , `k_cierre_n`.`Estado` FROM `k_cierre_n` INNER JOIN `rh_tipo_persona_cargon`   ON (`k_cierre_n`.`Id_Usuario` = `rh_tipo_persona_cargon`.`Id`)  INNER JOIN `k_caja`   ON (`k_caja`.`Id` = `k_cierre_n`.`Id_Caja`)    INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)  INNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) WHERE (`k_cierre_n`.Estado=1 and `k_cierre_n`.`FechaI`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `k_cierre_n`.`FechaI`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  and `k_cierre_n`.`Id_DocumentoC` =0) ORDER BY `k_cierre_n`.`Id` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), xnfila, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), xnfila, 8);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDCargarInformacionVentas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        if (this.xModulo.equals("CIERRE CAJA")) {
            mLlenarComboCaja();
        } else if (this.xModulo.equals("VENTAS")) {
            mLlenarComboEmpresa();
        }
        this.xlleno = true;
    }

    private void mLlenarComboEmpresa() {
        mCrearTablaDetalle();
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.removeAllItems();
        this.xsql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, f_empresacontxconvenio.EsCapitado, g_empresacont.Id_TipoRegimen FROM f_factura_evento INNER JOIN baseserver.f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'   AND f_factura_evento.EstaArmada =2 and  f_factura_evento.Id_DocumentoC=0) GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC ";
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 4);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void mLlenarComboCaja() {
        mCrearTabla_Cierre_Caja();
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.removeAllItems();
        this.xsql = "SELECT  `k_caja`.`Id` , `k_caja`.`Nbre`,0 FROM  `k_cierre_n` INNER JOIN  `k_caja`  ON (`k_cierre_n`.`Id_Caja` = `k_caja`.`Id`) WHERE (`k_cierre_n`.`Id_DocumentoC` =0 AND `k_cierre_n`.`Estado` =1 AND `k_cierre_n`.`FechaI` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `k_cierre_n`.`FechaF` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') group by `k_caja`.`Id`";
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 2);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void mCrearTabla_Cierre_Caja() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Caja", "Cajero", "F_Inicial", "F_Final", "Valor", "Observacion", "Id_Doc", "Estado"}) { // from class: Contabilidad.JDCargarInformacionVentas.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    private void mImportar() {
        if (this.xModulo.equals("VENTAS")) {
            if (this.JTDetalle.getRowCount() != -1) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    this.xjifdocontable.xmodelo.addRow(this.xdato);
                    if (Long.valueOf(this.xmodelo.getValueAt(x, 11).toString()).longValue() == 0) {
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()), x, 0);
                        this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x, 4);
                        this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()), x, 3);
                        this.xjifdocontable.xmodelo.setValueAt("SERVICIOS MEDICOS", x, 8);
                    } else {
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(this.xmodelo.getValueAt(x, 4).toString()), x, 0);
                        this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x, 3);
                        this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()), x, 4);
                        this.xjifdocontable.xmodelo.setValueAt(this.xmodelo.getValueAt(x, 2).toString(), x, 8);
                    }
                    this.xjifdocontable.xmodelo.setValueAt(this.xmodelo.getValueAt(x, 10).toString(), x, 1);
                    this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(this.xmodelo.getValueAt(x, 11).toString()), x, 2);
                    this.xjifdocontable.xmodelo.setValueAt("", x, 11);
                    if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("4")) {
                        try {
                            ResultSet rs = this.xct.traerRs("SELECT Id, Nbre FROM g_empresa WHERE (DocComodin ='" + this.xmodelo.getValueAt(x, 7).toString() + "') ");
                            if (rs.next()) {
                                rs.first();
                                this.xjifdocontable.xmodelo.setValueAt(rs.getString(1), x, 5);
                                this.xjifdocontable.xmodelo.setValueAt(rs.getString(2), x, 6);
                            } else {
                                this.xjifdocontable.xmodelo.setValueAt("", x, 5);
                                this.xjifdocontable.xmodelo.setValueAt("", x, 6);
                            }
                            rs.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex) {
                            Logger.getLogger(JDCargarInformacionVentas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                    } else {
                        this.xjifdocontable.xmodelo.setValueAt(this.xmodelo.getValueAt(x, 8).toString(), x, 5);
                        this.xjifdocontable.xmodelo.setValueAt(this.JCBEmpresa.getSelectedItem(), x, 6);
                    }
                    this.xjifdocontable.xmodelo.setValueAt(new Long(0L), x, 7);
                    this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()), x, 9);
                    this.xjifdocontable.xmodelo.setValueAt(new Long(0L), x, 10);
                }
                this.xjifdocontable.setXtipo(2);
                this.xjifdocontable.mSumarValores();
            }
        } else if (this.xModulo.equals("CIERRE CAJA")) {
            try {
                this.xsql = "SELECT `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_puc`.`Tipo` , SUM(`k_itemrecibos`.`VrUnitario`) AS `Valor` ,  `k_recibos_n`.`Id_Tercero` , `cc_terceros`.`RazonSocialCompleta` , 0 AS `MReciboCM` , `k_conceptos`.`Nbre` AS `Concepto` , `k_cierre_n`.`Id` AS `Id_Temp` , 0 AS `Id_Radicacion` , 0 AS `NFactura`  FROM  `k_recibos_n` INNER JOIN `k_cierre_n`  ON (`k_recibos_n`.`Id_Cierre` = `k_cierre_n`.`Id`) INNER JOIN `k_itemrecibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos_n`.`Id`) INNER JOIN `k_conceptos`  ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`) INNER JOIN `cc_puc`  ON (`cc_puc`.`Id` = `k_conceptos`.`CCredito`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `k_recibos_n`.`Id_Tercero`) WHERE (`k_cierre_n`.`Id` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') GROUP BY `cc_puc`.`Id`, `k_recibos_n`.`Id_Tercero` ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                int xfila = 0;
                if (xrs.next()) {
                    xrs.first();
                    this.xjifdocontable.setxId_CCaja(xrs.getLong("Id_Temp"));
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        this.xjifdocontable.xmodelo.addRow(this.xdato);
                        this.xjifdocontable.xmodelo.setValueAt(xrs.getString("Id"), xfila, 0);
                        this.xjifdocontable.xmodelo.setValueAt(xrs.getString("Nbre"), xfila, 1);
                        this.xjifdocontable.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Tipo")), xfila, 2);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 3);
                        this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), xfila, 4);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 5);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Tercero")), xfila, 6);
                        this.xjifdocontable.xmodelo.setValueAt(xrs.getString("RazonSocialCompleta"), xfila, 7);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs.getLong("MReciboCM")), xfila, 8);
                        this.xjifdocontable.xmodelo.setValueAt(xrs.getString("Concepto"), xfila, 9);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Temp")), xfila, 10);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Radicacion")), xfila, 11);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs.getLong("NFactura")), xfila, 12);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 13);
                        this.xjifdocontable.xmodelo.setValueAt(false, xfila, 14);
                        xfila++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                this.xsql = "SELECT `cc_puc`.`Id` , `cc_puc`.`Nbre` , SUM(`k_itemrecibos`.`VrUnitario`) AS `Valor` , `cc_puc`.`Tipo` , `k_recibos_n`.`Id_Tercero` , `cc_terceros`.`RazonSocialCompleta` , 0 AS `MReciboCM` , `k_formapago`.`Nbre` AS `Concepto` , `k_cierre_n`.`Id` AS `Id_Temp` , 0 AS `Id_Radicacion` , 0 AS `NFactura`  FROM  `k_recibos_n` INNER JOIN `k_cierre_n`  ON (`k_recibos_n`.`Id_Cierre` = `k_cierre_n`.`Id`)  INNER JOIN `k_itemrecibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos_n`.`Id`)  INNER JOIN `k_formapago`  ON (`k_recibos_n`.`Id_FPago` = `k_formapago`.`Id`)  INNER JOIN `cc_puc`  ON (`cc_puc`.`Id` = `k_formapago`.`CDebito`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `k_recibos_n`.`Id_Tercero`) WHERE (`k_cierre_n`.`Id` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') GROUP BY `cc_puc`.`Id`, `k_recibos_n`.`Id_Tercero` ";
                ResultSet xrs2 = this.xct.traerRs(this.xsql);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    while (xrs2.next()) {
                        this.xjifdocontable.xmodelo.addRow(this.xdato);
                        this.xjifdocontable.xmodelo.setValueAt(xrs2.getString("Id"), xfila, 0);
                        this.xjifdocontable.xmodelo.setValueAt(xrs2.getString("Nbre"), xfila, 1);
                        this.xjifdocontable.xmodelo.setValueAt(Integer.valueOf(xrs2.getInt("Tipo")), xfila, 2);
                        this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble("Valor")), xfila, 3);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 4);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 5);
                        this.xjifdocontable.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), xfila, 6);
                        this.xjifdocontable.xmodelo.setValueAt(Principal.informacionIps.getNombreIps(), xfila, 7);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs2.getLong("MReciboCM")), xfila, 8);
                        this.xjifdocontable.xmodelo.setValueAt(xrs2.getString("Concepto"), xfila, 9);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs2.getLong("Id_Temp")), xfila, 10);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs2.getLong("Id_Radicacion")), xfila, 11);
                        this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(xrs2.getLong("NFactura")), xfila, 12);
                        this.xjifdocontable.xmodelo.setValueAt(0, xfila, 13);
                        this.xjifdocontable.xmodelo.setValueAt(false, xfila, 14);
                        xfila++;
                    }
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
                this.xjifdocontable.mSumarValores();
            } catch (SQLException ex2) {
                Logger.getLogger(JDCargarInformacionVentas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
        dispose();
    }
}
