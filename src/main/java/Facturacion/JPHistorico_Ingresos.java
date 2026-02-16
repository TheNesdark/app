package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPHistorico_Ingresos.class */
public class JPHistorico_Ingresos extends JPanel {
    private JIFLiqServicios xliq;
    private DefaultTableModel xmodeloingresos;
    private Object[] xdatos;
    private ButtonGroup JBG_Filtro;
    private JCheckBox JCHIngresos;
    private JCheckBox JCH_PFacturar;
    private JPanel JPHistorico;
    private JScrollPane JSPIngresos;
    private JTable JTDetalleIngresos;
    private JTabbedPane JTPHistoricos;
    private JYearChooser JYAno;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPHistorico_Ingresos(JIFLiqServicios xliq) {
        initComponents();
        this.xliq = xliq;
        mBuscarIngresos();
    }

    private void mBuscarIngresos() {
        String sql;
        String sqlBase = "SELECT  ingreso.Id  , ingreso.FechaIngreso  , ingreso.HoraIngreso  , f_empresacontxconvenio.Nbre  convenio , f_estrato.Nbre  estrato, profesional1.Especialidad  , profesional1.NProfesional   , g_tipoatencion.Nbre tipoAtencion  , f_empresacontxconvenio.Id_Manual  , f_empresacontxconvenio.EsCapitado  , f_empresacontxconvenio.CualValor  , f_empresacontxconvenio.FiltroProcxEmp , g_empresacont.Id_TipoPlan , f_empresacontxconvenio.Id idEmpresaConvenio , f_estratoxemprcontconv.PorcSubsidio , f_estratoxemprcontconv.ValorMaximo  , ingreso.SiCopago , ingreso.Id_TipoAtencion       ,IFNULL(f_factura_capita.`No_FacturaCapita`, '') FCapita        , IF( `cc_resolucion_dian`.`trasmision` = 1,IFNULL(f_factura_evento.`No_FacturaEvento_M`,''),IFNULL(f_factura_evento.`No_FacturaEvento`,'') ) FEvento \t , IFNULL(f_liquidacion.`Id` , 0) IdLiquidacion \t , IFNULL(h_atencion.Id , 0) Id_Atencion \t , f_estratoxemprcontconv.TopeAtencion  \t , f_estratoxemprcontconv.ToPeAnual \t , f_empresacontxconvenio.Id_GIps, f_estratoxemprcontconv.Editable  , ingreso.Id_CondVict, f_empresacontxconvenio.GMovimientoContable ,ifnull(`c_clasecita`.`Id_Historia`,0) idTipoHistoria, ingreso.UsuarioS  FROM `ingreso` INNER JOIN  `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) INNER JOIN  `f_estrato`  ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`) LEFT JOIN  `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) LEFT JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `ingreso`.`Id_Especialidad`) INNER JOIN  `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `f_estrato`.`Id`) LEFT JOIN  `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  left JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) LEFT JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) AND (f_factura_capita.`Estado`=0)  LEFT JOIN  `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) AND (f_factura_evento.`Estado`=0)     left JOIN `cc_resolucion_dian`\n     ON(`cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)WHERE  ingreso.Id_Usuario = '" + this.xliq.xjppersona.getIdPersona() + "' AND  \tingreso.Estado=0 ";
        if (this.JCHIngresos.isSelected()) {
            sql = sqlBase + " GROUP BY ingreso.`Id` ORDER BY FechaIngreso DESC,HoraIngreso DESC";
        } else if (this.JCH_PFacturar.isSelected()) {
            sql = sqlBase + " and f_liquidacion.Id is null  AND  DATE_FORMAT(FechaIngreso,'%Y')='" + String.valueOf(this.JYAno.getValue()) + "'   GROUP BY ingreso.`Id` ORDER BY FechaIngreso DESC,HoraIngreso DESC";
        } else {
            sql = sqlBase + " and f_liquidacion.Id is not null AND  DATE_FORMAT(FechaIngreso,'%Y')='" + String.valueOf(this.JYAno.getValue()) + "'  ORDER BY FechaIngreso DESC,HoraIngreso DESC";
        }
        try {
            System.out.println("Historico .." + sql);
            mCrearModeloDatosIngresos();
            ResultSet xrs = this.xconsulta.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodeloingresos.addRow(this.xdatos);
                            this.xmodeloingresos.setValueAt(Integer.valueOf(xrs.getInt("Id")), n, 0);
                            this.xmodeloingresos.setValueAt(xrs.getString("FechaIngreso"), n, 1);
                            this.xmodeloingresos.setValueAt(xrs.getString("HoraIngreso"), n, 2);
                            this.xmodeloingresos.setValueAt(xrs.getString("convenio"), n, 3);
                            this.xmodeloingresos.setValueAt(xrs.getString("estrato"), n, 4);
                            this.xmodeloingresos.setValueAt(xrs.getString("Especialidad"), n, 5);
                            this.xmodeloingresos.setValueAt(xrs.getString("NProfesional"), n, 6);
                            this.xmodeloingresos.setValueAt(xrs.getString("tipoAtencion"), n, 7);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Id_Manual")), n, 8);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("EsCapitado")), n, 9);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("CualValor")), n, 10);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("FiltroProcxEmp")), n, 11);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Id_TipoPlan")), n, 12);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("idEmpresaConvenio")), n, 13);
                            this.xmodeloingresos.setValueAt(0, n, 14);
                            this.xmodeloingresos.setValueAt(xrs.getString("FCapita"), n, 15);
                            this.xmodeloingresos.setValueAt(xrs.getString("FEvento"), n, 16);
                            this.xmodeloingresos.setValueAt(Double.valueOf(xrs.getDouble("PorcSubsidio")), n, 17);
                            this.xmodeloingresos.setValueAt(Double.valueOf(xrs.getDouble("ValorMaximo")), n, 18);
                            this.xmodeloingresos.setValueAt(xrs.getString("SiCopago"), n, 19);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("IdLiquidacion")), n, 20);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), n, 21);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Id_Atencion")), n, 22);
                            this.xmodeloingresos.setValueAt(Double.valueOf(xrs.getDouble("TopeAtencion")), n, 23);
                            this.xmodeloingresos.setValueAt(Double.valueOf(xrs.getDouble("TopeAnual")), n, 24);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Id_GIps")), n, 25);
                            this.xmodeloingresos.setValueAt(Long.valueOf(xrs.getLong("Editable")), n, 26);
                            this.xmodeloingresos.setValueAt(xrs.getString("Id_CondVict"), n, 27);
                            this.xmodeloingresos.setValueAt(xrs.getString("GMovimientoContable"), n, 28);
                            this.xmodeloingresos.setValueAt(xrs.getString("idTipoHistoria"), n, 29);
                            this.xmodeloingresos.setValueAt(xrs.getString("UsuarioS"), n, 30);
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPHistorico_Ingresos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosIngresos() {
        this.xmodeloingresos = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Empresa", "Estrato", "Especialidad", "Profesional", "Tipo Atención", "IdManual", "EsCapitado", "CualValor", "FiltroProc", "IdTipoPlan", "IdEmpresa", "NF", "FCapita", "FEvento", "Porcentaje", "CModeradora", "Tipo", "Id_Liquidacion", "Id_TipoAtencion", "Id_Atencion", "TAtencion", "TAnual", "Id_GIps", "Editable", "Cvictima", "GMovContable", "idTipoHistoria", "UsuarioSistemas"}) { // from class: Facturacion.JPHistorico_Ingresos.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Integer.class, String.class, String.class, Double.class, Double.class, Long.class, Long.class, Long.class, Long.class, Double.class, Long.class, Long.class, Integer.class, String.class, Integer.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleIngresos;
        JTable jTable2 = this.JTDetalleIngresos;
        jTable.setAutoResizeMode(0);
        this.JTDetalleIngresos.doLayout();
        this.JTDetalleIngresos.setModel(this.xmodeloingresos);
        this.JTDetalleIngresos.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleIngresos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleIngresos.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleIngresos.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(30).setPreferredWidth(150);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTDetalleIngresos.getColumnModel().getColumn(0).setPreferredWidth(70);
            this.JTDetalleIngresos.getColumnModel().getColumn(1).setPreferredWidth(80);
            this.JTDetalleIngresos.getColumnModel().getColumn(2).setPreferredWidth(80);
            this.JTDetalleIngresos.getColumnModel().getColumn(3).setPreferredWidth(180);
            this.JTDetalleIngresos.getColumnModel().getColumn(4).setPreferredWidth(70);
            this.JTDetalleIngresos.getColumnModel().getColumn(5).setPreferredWidth(90);
            this.JTDetalleIngresos.getColumnModel().getColumn(15).setPreferredWidth(80);
            this.JTDetalleIngresos.getColumnModel().getColumn(16).setPreferredWidth(80);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JTPHistoricos = new JTabbedPane();
        this.JPHistorico = new JPanel();
        this.JSPIngresos = new JScrollPane();
        this.JTDetalleIngresos = new JTable();
        this.JYAno = new JYearChooser();
        this.JCHIngresos = new JCheckBox();
        this.JCH_PFacturar = new JCheckBox();
        setName("jifhistoricoingreso");
        setPreferredSize(new Dimension(823, 488));
        this.JTPHistoricos.setForeground(new Color(255, 0, 0));
        this.JTPHistoricos.setFont(new Font("Arial", 1, 14));
        this.JTPHistoricos.setName("");
        this.JSPIngresos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE INGRESOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleIngresos.setFont(new Font("Arial", 1, 12));
        this.JTDetalleIngresos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleIngresos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleIngresos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleIngresos.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPHistorico_Ingresos.2
            public void mouseClicked(MouseEvent evt) {
                JPHistorico_Ingresos.this.JTDetalleIngresosMouseClicked(evt);
            }
        });
        this.JSPIngresos.setViewportView(this.JTDetalleIngresos);
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JPHistorico_Ingresos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPHistorico_Ingresos.this.JYAnoPropertyChange(evt);
            }
        });
        this.JBG_Filtro.add(this.JCHIngresos);
        this.JCHIngresos.setFont(new Font("Arial", 1, 12));
        this.JCHIngresos.setText("Todos los Ingresos?");
        this.JCHIngresos.setToolTipText("Visualizar todos los ingresos");
        this.JCHIngresos.addActionListener(new ActionListener() { // from class: Facturacion.JPHistorico_Ingresos.4
            public void actionPerformed(ActionEvent evt) {
                JPHistorico_Ingresos.this.JCHIngresosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCH_PFacturar);
        this.JCH_PFacturar.setFont(new Font("Arial", 1, 12));
        this.JCH_PFacturar.setSelected(true);
        this.JCH_PFacturar.setText("Por Facturar?");
        this.JCH_PFacturar.setToolTipText("Solo visualiza los ingresos por facturar");
        this.JCH_PFacturar.addActionListener(new ActionListener() { // from class: Facturacion.JPHistorico_Ingresos.5
            public void actionPerformed(ActionEvent evt) {
                JPHistorico_Ingresos.this.JCH_PFacturarActionPerformed(evt);
            }
        });
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPIngresos, -1, 778, 32767).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JYAno, -2, 82, -2).addGap(18, 18, 18).addComponent(this.JCHIngresos).addGap(28, 28, 28).addComponent(this.JCH_PFacturar).addGap(0, 0, 32767))).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYAno, -1, 54, 32767).addGroup(JPHistoricoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_PFacturar).addComponent(this.JCHIngresos)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPIngresos, -2, 353, -2).addContainerGap()));
        this.JTPHistoricos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPHistoricos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPHistoricos, -2, 466, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleIngresosMouseClicked(MouseEvent evt) {
        if (this.JTDetalleIngresos.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 0).toString());
            this.xliq.JLB_NIngreso.setText(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 0).toString());
            this.xliq.xIdManual = this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 8).toString();
            this.xliq.setxEsCapitado(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 9).toString());
            this.xliq.xCValor = this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 10).toString();
            this.xliq.xFiltroProc = this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 11).toString();
            this.xliq.xIdTipoPlan = this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 12).toString();
            this.xliq.setXidempresa(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 13).toString()));
            this.xliq.setxPCopago(Double.parseDouble(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 17).toString()));
            this.xliq.setxCModeradora(Double.parseDouble(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 18).toString()));
            this.xliq.setxTopeAtencion(Double.parseDouble(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 23).toString()));
            this.xliq.setxTopeAnual(Double.parseDouble(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 24).toString()));
            this.xliq.setxTipoEstrato(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 19).toString()));
            this.xliq.setxId_Liqidacion(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 20).toString()));
            this.xliq.setxId_TipoAtencion(Integer.parseInt(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 21).toString()));
            this.xliq.setxId_Atencion(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 22).toString()));
            this.xliq.setxId_GIps(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 25).toString()));
            this.xliq.setxId_Editable(Integer.parseInt(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 26).toString()));
            this.xliq.setxMovContable(Long.valueOf(Long.parseLong(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 28).toString())));
            this.xliq.setxGeneraMovContable(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 28).toString());
            this.xliq.setIdTipoHistoria(Integer.parseInt(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 29).toString()));
            this.xliq.mInicar_Variables_Ingreso(this.xmodeloingresos.getValueAt(this.JTDetalleIngresos.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        mBuscarIngresos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIngresosActionPerformed(ActionEvent evt) {
        mBuscarIngresos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PFacturarActionPerformed(ActionEvent evt) {
        if (this.JCH_PFacturar.isSelected()) {
            this.JCH_PFacturar.setText("Por Facturar?");
            this.JCH_PFacturar.setToolTipText("Solo visualiza los ingresos por facturar");
        } else {
            this.JCH_PFacturar.setText("Facturadas?");
            this.JCH_PFacturar.setToolTipText("Solo visualiza los ingresos por facturar");
        }
        mBuscarIngresos();
    }
}
