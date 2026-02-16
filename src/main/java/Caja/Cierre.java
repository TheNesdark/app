package Caja;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.caja.ReciboIngresoDAO;
import com.genoma.plus.dao.impl.caja.ReciboIngresoDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Caja/Cierre.class */
public class Cierre extends JInternalFrame {
    private DefaultTableModel modelo;
    private DefaultTableModel xModelo1;
    private claseCaja clasecaja;
    private String[] xidtipodoc;
    private String[] xidperiodo;
    private String[] xidtipodoc_ppt;
    private String[] xidperiodo_RUD;
    private String[] xidtipodoc_RUD;
    private String[][] xidperiodo_ppt;
    private ResultSet rs;
    private Object[] dato;
    private String sql;
    private String fechaInicio;
    private String idCierre;
    private ReciboIngresoDAO reciboIngresoDAO;
    private ButtonGroup JBG_Filtro;
    private ButtonGroup JBG_FiltroEstado;
    private JButton JBTExportar;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox JCBTipoDoc_RUD;
    private JCheckBox JCHFiltro;
    private JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JDateChooser JDFFechaC;
    private JPanel JPICiere;
    private JPanel JPIDContables;
    private JPanel JPIDContables1;
    private JPanel JPI_DatosCP;
    private JPanel JPI_Estado;
    private JPanel JPI_Filtro;
    private JPanel JPI_Historico;
    private JScrollPane JSPHistorico;
    private JRadioButton JTB_EFiltroActivos;
    private JRadioButton JTB_EFiltroAnulados;
    private JRadioButton JTB_EFiltroTodos;
    private JRadioButton JTB_FiltroConConsolido;
    private JRadioButton JTB_FiltroPorConsolidar;
    private JRadioButton JTB_FiltroTodos;
    private JTable JTB_Historico;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFHoraF;
    private JFormattedTextField JTFHoraI;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTable grid;
    private JLabel jLabel1;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextField txtCaja;
    private JFormattedTextField txtNoCierre;
    private JTextField txtReciboFin;
    private JTextField txtReciboIni;
    private JFormattedTextField txtValorCierre;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int filaGrid = 0;
    private int xllenoc = 0;
    private int xllenocg = 0;
    private boolean xlleno = false;
    private String filtro = "0";
    private String filtroEstado = "0,1";

    public Cierre(claseCaja xclasecaja) {
        initComponents();
        this.clasecaja = xclasecaja;
        setTitle("CIERRE DE CAJA :  " + this.clasecaja.getNbreCaja());
        nuevo();
        springStart();
    }

    public void anular() {
        if (this.JTPDatos.getSelectedIndex() != 1 || this.JTB_Historico.getSelectedRow() == -1) {
            return;
        }
        if (Long.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 8).toString()).longValue() == 0) {
            Anular frm = new Anular(null, true, "Cierre Caja", 12);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cierre con documento contable No. " + this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 8).toString() + " activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularCierre(String motivo, String observacion) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.reciboIngresoDAO.anularRecibo(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString(), motivo, observacion, Principal.usuarioSistemaDTO.getNombreUsuario());
            this.reciboIngresoDAO.actualizarDatosReciboCajaIdCierre(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            mCargar_DatosHistorico();
        }
    }

    private void springStart() {
        this.reciboIngresoDAO = (ReciboIngresoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reciboIngresoDAO");
    }

    public void mCargar_DatosHistorico() {
        try {
            mCrear_ModeloHistorico();
            this.sql = "SELECT k_cierre.Id , k_caja.Nbre AS Caja, DATE_FORMAT(k_cierre.FechaInicio, '%d/%m/%Y %h:%i:%s %p') AS FechaI , DATE_FORMAT(k_cierre.FechaFinal, '%d/%m/%Y %h:%i:%s %p') AS FechaF,k_cierre.Valor, w_persona.NUsuario AS Cajero,k_cierre.IdConsolidado, `k_cierre`.`Id_DocContable`, if(k_cierre.estado=1,'ACTIVO','ANULADO') Estado   FROM k_cierre INNER JOIN k_caja ON (k_cierre.Id_Caja = k_caja.Id) INNER JOIN w_persona ON (k_cierre.Id_Usuario = w_persona.Id_persona) WHERE (if(k_cierre.IdConsolidado=0,0,1) in(" + this.filtro + ") and NOT(k_cierre.FechaFinal IS NULL) and k_cierre.estado in(" + this.filtroEstado + ") ) order by  k_cierre.Id desc";
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int xnfila = 0;
                while (this.rs.next()) {
                    this.xModelo1.addRow(this.dato);
                    this.xModelo1.setValueAt(this.rs.getString(1), xnfila, 0);
                    this.xModelo1.setValueAt(this.rs.getString(2), xnfila, 1);
                    this.xModelo1.setValueAt(this.rs.getString(3), xnfila, 2);
                    this.xModelo1.setValueAt(this.rs.getString(4), xnfila, 3);
                    this.xModelo1.setValueAt(Long.valueOf(this.rs.getLong(5)), xnfila, 4);
                    this.xModelo1.setValueAt(this.rs.getString(6), xnfila, 5);
                    this.xModelo1.setValueAt(true, xnfila, 6);
                    this.xModelo1.setValueAt(this.rs.getString("IdConsolidado"), xnfila, 7);
                    this.xModelo1.setValueAt(Long.valueOf(this.rs.getLong("Id_DocContable")), xnfila, 8);
                    this.xModelo1.setValueAt(this.rs.getString("Estado"), xnfila, 9);
                    xnfila++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_ModeloHistorico() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"No Cierre", "Caja", "Fecha Inicial", "Fecha Final", "Valor", "Cajero", "Agregar", "No. Consolidado", "IdDocumento", "Estado"}) { // from class: Caja.Cierre.1
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Historico;
        JTable jTable2 = this.JTB_Historico;
        jTable.setAutoResizeMode(0);
        this.JTB_Historico.doLayout();
        this.JTB_Historico.setModel(this.xModelo1);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private String buscarRecibo(int op) {
        String fechaUC;
        String fechaUC2 = this.clasecaja.getFechaUltimoCierre();
        if (fechaUC2 == null) {
            fechaUC = "2010/01/01 00:01:00";
        } else {
            fechaUC = this.xmt.pasarFechaHora12a24(fechaUC2);
        }
        if (op == 0) {
            this.sql = "SELECT MIN(NoRecibo)";
        } else if (op == 1) {
            this.sql = "SELECT MAX(NoRecibo)";
        }
        this.sql += " FROM k_recibos WHERE (Id_Caja ='" + this.clasecaja.getIdCaja() + "' AND Fecha_Recibo > '" + fechaUC + "' AND UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' and Id_cierre=0)";
        this.sql = this.consultas.traerDato(this.sql);
        if (this.sql == null || this.sql.isEmpty()) {
            this.sql = "0";
        }
        this.consultas.cerrarConexionBd();
        return this.sql;
    }

    private void mCargar_DatosRecibo() {
        if (this.JCHFiltro.isSelected()) {
            this.sql = "SELECT k_recibos.Fecha_Recibo, k_recibos.NoRecibo,  CONCAT(k_recibos.Id_TipoDocumento,':', k_recibos.Identificacion) AS Documento, k_recibos.Nbre_Paciente, sum(`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`) AS vALOR, k_recibos.Descuento, k_recibos.Estado, `k_conceptos`.`Valor`, `k_conceptos`.`CDebito`, `k_conceptos`.`CCredito`    , k_conceptos.`RPresupuestal`, k_conceptos.`Nbre` as NConcepto,IF( d.`Id`  IS NULL , 0, d.`Id`)  AS Idtercero, k_recibos.Id_Paciente, `k_conceptos`.AMovContable  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) usuarioRecibo FROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)  INNER JOIN `k_conceptos` ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`)    INNER JOIN `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`)\n  INNER JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) \n LEFT JOIN (SELECT `Id` , `No_identificacion` , `Id_TipoIdentificacion`\nFROM `cc_terceros` \nGROUP BY `No_identificacion`, `Id_TipoIdentificacion`) d ON (d.`No_identificacion` =k_recibos.Identificacion\n    AND d.`Id_TipoIdentificacion` =k_recibos.Id_TipoDocumento)  WHERE k_itemrecibos.EsVisible=0 and  rh_tipo_persona_cargon.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and  k_recibos.Id_Caja ='" + this.clasecaja.getIdCaja() + "' AND  (date_format(k_recibos.Fecha_Recibo,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  date_format(k_recibos.Fecha_Recibo,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "')  AND Id_cierre=0   GROUP BY k_recibos.NoRecibo ORDER BY k_recibos.NoRecibo ASC ";
        } else {
            this.sql = "SELECT k_recibos.Fecha_Recibo, k_recibos.NoRecibo,  CONCAT(k_recibos.Id_TipoDocumento,':', k_recibos.Identificacion) AS Documento, k_recibos.Nbre_Paciente, sum(`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`) AS vALOR, k_recibos.Descuento, k_recibos.Estado, `k_conceptos`.`Valor`, `k_conceptos`.`CDebito`, `k_conceptos`.`CCredito`    , k_conceptos.`RPresupuestal`, k_conceptos.`Nbre` as NConcepto,IF( d.`Id`  IS NULL , 0, d.`Id`)  AS Idtercero, k_recibos.Id_Paciente, `k_conceptos`.AMovContable  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) usuarioRecibo FROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)  INNER JOIN `k_conceptos` ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`)    INNER JOIN `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`)\n  INNER JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) \n LEFT JOIN (SELECT `Id` , `No_identificacion` , `Id_TipoIdentificacion`\nFROM `cc_terceros` \nGROUP BY `No_identificacion`, `Id_TipoIdentificacion`) d ON (d.`No_identificacion` =k_recibos.Identificacion\n    AND d.`Id_TipoIdentificacion` =k_recibos.Id_TipoDocumento)  WHERE k_itemrecibos.EsVisible=0 and  k_recibos.Id_Caja ='" + this.clasecaja.getIdCaja() + "' AND  (k_recibos.Fecha_Recibo >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "' and  k_recibos.Fecha_Recibo <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "')  AND Id_cierre=0   GROUP BY k_recibos.NoRecibo ORDER BY k_recibos.NoRecibo ASC ";
        }
        this.rs = this.consultas.traerRs(this.sql);
        mCrear_ModeloRecibo();
        double vrCierre = 0.0d;
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.xmt.formatoAMD.format((Date) this.rs.getDate(1)), this.filaGrid, 0);
                this.modelo.setValueAt(this.xmt.formatoH12.format((Date) this.rs.getTime(1)), this.filaGrid, 1);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 2);
                this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 3);
                this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 4);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(5)), this.filaGrid, 5);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(5) - this.rs.getInt(6)), this.filaGrid, 7);
                if (this.rs.getInt(7) == 0) {
                    this.modelo.setValueAt("ACTIVO", this.filaGrid, 8);
                    vrCierre += (double) (this.rs.getInt(5) - this.rs.getInt(6));
                } else {
                    this.modelo.setValueAt("ANULADO", this.filaGrid, 8);
                }
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(8)), this.filaGrid, 9);
                this.modelo.setValueAt(this.rs.getString(9), this.filaGrid, 10);
                this.modelo.setValueAt(this.rs.getString(10), this.filaGrid, 11);
                this.modelo.setValueAt(this.rs.getString("RPresupuestal"), this.filaGrid, 12);
                this.modelo.setValueAt(this.rs.getString("NConcepto"), this.filaGrid, 13);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong("Idtercero")), this.filaGrid, 14);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong("Id_Paciente")), this.filaGrid, 15);
                this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("AMovContable")), this.filaGrid, 16);
                this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("usuarioRecibo")), this.filaGrid, 17);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
        this.txtValorCierre.setValue(Double.valueOf(vrCierre));
    }

    private void mCrear_ModeloRecibo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Hora", "No. Recibo", "Documento", "Usuario", "Valor", "Descuento", "Total", "Estado", "v/concepto", "Debito", "Credito", "RPResupuesto", "Concepto", "Id_tercero", "Id_Persona", "Aplica Contabilidad?", "Responsable"}) { // from class: Caja.Cierre.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, Double.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Boolean.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.filaGrid = 0;
    }

    public void buscar() {
        BusqCierre dialog = new BusqCierre(new JFrame(), false, this, this.clasecaja);
        dialog.setVisible(true);
    }

    public String getIdCierre() {
        return this.idCierre;
    }

    public void mGrabar() {
        if (this.grid.getRowCount() > 0) {
            if (this.txtNoCierre.getText().isEmpty()) {
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    mGrabar_Recibo();
                    this.clasecaja.imprimirCierre(this.txtNoCierre.getText());
                    return;
                }
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        mGrabar_Recibo();
                        this.clasecaja.imprimirCierre(this.txtNoCierre.getText());
                        return;
                    }
                    return;
                }
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
                    if (!this.xmt.mVerificarDatosLLeno(this.grid, 10) && !this.xmt.mVerificarDatosLLeno(this.grid, 11)) {
                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x2 == 0) {
                                    mGrabar_Recibo();
                                    mGenerarDocContable();
                                    this.clasecaja.imprimirCierre(this.txtNoCierre.getText());
                                    return;
                                }
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                            this.JCBPeriodoC.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento");
                        this.JCBTipoC.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Faltan cuentas puc en los conceptos");
                    return;
                }
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                    if (!this.xmt.mVerificarDatosLLeno(this.grid, 12)) {
                        if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_RUD.getSelectedIndex() != -1) {
                                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                    int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x3 == 0) {
                                        mGrabar_Recibo();
                                        mGenerarDoc_Presupuesto();
                                        this.clasecaja.imprimirCierre(this.txtNoCierre.getText());
                                        return;
                                    }
                                    return;
                                }
                                this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                this.JCBPeriodo_Ppt.requestFocus();
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de recaudo");
                            this.JCBTipoDoc_RUD.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de reconocimiento");
                        this.JCBTipoDoc_Ppt.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Faltan rubros presupuestales en los conceptos");
                    return;
                }
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                    if (!this.xmt.mVerificarDatosLLeno(this.grid, 10) && !this.xmt.mVerificarDatosLLeno(this.grid, 11) && !this.xmt.mVerificarDatosLLeno(this.grid, 12)) {
                        if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_RUD.getSelectedIndex() != -1) {
                                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                    if (this.JCBTipoC.getSelectedIndex() != -1) {
                                        if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                            int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            if (x4 == 0) {
                                                mGrabar_Recibo();
                                                mGenerarDocContable();
                                                mGenerarDoc_Presupuesto();
                                                this.clasecaja.imprimirCierre(this.txtNoCierre.getText());
                                                return;
                                            }
                                            return;
                                        }
                                        this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                        this.JCBPeriodoC.requestFocus();
                                        return;
                                    }
                                    this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento");
                                    this.JCBTipoC.requestFocus();
                                    return;
                                }
                                this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                this.JCBPeriodo_Ppt.requestFocus();
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de recaudo");
                            this.JCBTipoDoc_RUD.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de reconocimiento");
                        this.JCBTipoDoc_Ppt.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Faltan cuentas puc y/o rubros presupuestales en los conceptos");
                    return;
                }
                return;
            }
            this.xmt.mostrarMensaje("Cierre ya grabado");
            return;
        }
        this.xmt.mostrarMensaje("No hay recibos para realizar el cierre");
    }

    private void mGrabar_Recibo() {
        this.sql = "insert into k_cierre(Id_Caja ,  Id_Usuario  ,  FechaInicio  ,  FechaFinal , Valor, UsuarioS) values('" + this.clasecaja.getIdCaja() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "','" + this.txtValorCierre.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        System.out.println(this.sql);
        this.txtNoCierre.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        if (this.JCHFiltro.isSelected()) {
            this.sql = "UPDATE k_recibos,  (SELECT k_recibos.`Id`\n FROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)  INNER JOIN `k_conceptos` ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`)   LEFT JOIN `cc_terceros` ON (cc_terceros.`No_identificacion` = `k_recibos`.`Identificacion`)  AND (cc_terceros.`Id_TipoIdentificacion`= `k_recibos`.`Id_TipoDocumento`)\n WHERE  k_recibos.Id_UsuarioS ='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' and  k_recibos.Id_Caja ='" + this.clasecaja.getIdCaja() + "' AND  (date_format(k_recibos.Fecha_Recibo, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  date_format(k_recibos.Fecha_Recibo, '%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "')  AND Id_cierre=0   GROUP BY k_recibos.NoRecibo ORDER BY k_recibos.NoRecibo ASC \n) AS Tabla SET k_recibos.`Id_cierre`='" + this.txtNoCierre.getText() + "'  WHERE k_recibos.`Id`=Tabla.Id";
        } else {
            this.sql = "UPDATE k_recibos,  (SELECT k_recibos.`Id`\n FROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)  INNER JOIN `k_conceptos` ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`)   LEFT JOIN `cc_terceros` ON (cc_terceros.`No_identificacion` = `k_recibos`.`Identificacion`)  AND (cc_terceros.`Id_TipoIdentificacion`= `k_recibos`.`Id_TipoDocumento`)\n WHERE  k_recibos.Id_Caja ='" + this.clasecaja.getIdCaja() + "' AND  (k_recibos.Fecha_Recibo >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "' and  k_recibos.Fecha_Recibo <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "')  AND Id_cierre=0   GROUP BY k_recibos.NoRecibo ORDER BY k_recibos.NoRecibo ASC \n) AS Tabla SET k_recibos.`Id_cierre`='" + this.txtNoCierre.getText() + "'  WHERE k_recibos.`Id`=Tabla.Id";
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        if (this.grid.getRowCount() > 0) {
            if (this.txtNoCierre.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                        mGenerarDocContable();
                    }
                    if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                        mGenerarDoc_Presupuesto();
                    }
                    if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                        this.sql = "update k_cierre set Id_DocContable='" + this.JTFFNDoc.getText() + "' where Id='" + this.txtNoCierre.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                    }
                    if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                        this.sql = "update k_cierre set Id_DocPresupuesto='" + this.JTFFNDoc_Ppt.getText() + "'where Id='" + this.txtNoCierre.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                    }
                    this.consultas.cerrarConexionBd();
                    return;
                }
                return;
            }
            this.xmt.mostrarMensaje("Cierre ya grabado");
            return;
        }
        this.xmt.mostrarMensaje("No hay recibos para realizar el cierre");
    }

    public void nuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.fechaInicio = this.clasecaja.verificarCajaAbierta();
        this.txtCaja.setText(this.clasecaja.getNbreCaja());
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFHoraI.setValue(this.xmt.getFechaActual());
        this.JTFHoraF.setValue(this.xmt.getFechaActual());
        this.txtNoCierre.setText("");
        this.JTFFNDoc.setText("");
        this.JTFFNDoc_Ppt.setText("");
        this.txtValorCierre.setText("");
        this.txtReciboIni.setText(buscarRecibo(0));
        this.txtReciboFin.setText(buscarRecibo(1));
        mCargar_DatosRecibo();
        mCargar_DatosHistorico();
        this.xlleno = true;
        mLlenarCombo();
    }

    /* JADX WARN: Type inference failed for: r3v162, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPICiere = new JPanel();
        this.jPanel2 = new JPanel();
        this.txtReciboFin = new JTextField();
        this.txtReciboIni = new JTextField();
        this.txtCaja = new JTextField();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JTFHoraI = new JFormattedTextField();
        this.JTFHoraF = new JFormattedTextField();
        this.jLabel1 = new JLabel();
        this.jLabel9 = new JLabel();
        this.txtValorCierre = new JFormattedTextField();
        this.txtNoCierre = new JFormattedTextField();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.JPI_DatosCP = new JPanel();
        this.JPIDContables = new JPanel();
        this.JCBPeriodoC = new JComboBox();
        this.JCBTipoC = new JComboBox();
        this.JTFFNDoc = new JFormattedTextField();
        this.JDFFechaC = new JDateChooser();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCBTipoDoc_RUD = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JPI_Historico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JPI_Filtro = new JPanel();
        this.JTB_FiltroTodos = new JRadioButton();
        this.JTB_FiltroPorConsolidar = new JRadioButton();
        this.JTB_FiltroConConsolido = new JRadioButton();
        this.JPI_Estado = new JPanel();
        this.JTB_EFiltroTodos = new JRadioButton();
        this.JTB_EFiltroActivos = new JRadioButton();
        this.JTB_EFiltroAnulados = new JRadioButton();
        this.jPanel5 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CIERRE DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(728, 521));
        setName("Cierre");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN CAJA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.txtReciboFin.setBackground(new Color(0, 153, 153));
        this.txtReciboFin.setFont(new Font("Arial", 1, 14));
        this.txtReciboFin.setForeground(new Color(0, 0, 102));
        this.txtReciboFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Recibo Final", 0, 0, new Font("Arial", 1, 12)));
        this.txtReciboFin.setDisabledTextColor(new Color(0, 0, 153));
        this.txtReciboFin.setEnabled(false);
        this.txtReciboIni.setBackground(new Color(0, 153, 153));
        this.txtReciboIni.setFont(new Font("Arial", 1, 14));
        this.txtReciboIni.setForeground(new Color(0, 0, 102));
        this.txtReciboIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Recibo Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtReciboIni.setDisabledTextColor(new Color(0, 0, 153));
        this.txtReciboIni.setEnabled(false);
        this.txtCaja.setBackground(new Color(0, 153, 153));
        this.txtCaja.setFont(new Font("Arial", 1, 12));
        this.txtCaja.setForeground(new Color(204, 204, 255));
        this.txtCaja.setHorizontalAlignment(0);
        this.txtCaja.setBorder((Border) null);
        this.txtCaja.setDisabledTextColor(new Color(204, 255, 255));
        this.txtCaja.setEnabled(false);
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Cierre.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Cierre.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Cierre.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Cierre.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JTFHoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFHoraI.setFont(new Font("Arial", 1, 12));
        this.JTFHoraI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Cierre.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Cierre.this.JTFHoraIPropertyChange(evt);
            }
        });
        this.JTFHoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraF.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFHoraF.setFont(new Font("Arial", 1, 12));
        this.JTFHoraF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Cierre.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Cierre.this.JTFHoraFPropertyChange(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtCaja).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFHoraI, -2, 120, -2)).addComponent(this.txtReciboIni)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDCFechaFin, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JTFHoraF, -2, 120, -2)).addComponent(this.txtReciboFin)))).addGap(118, 118, 118)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.txtCaja, -2, 30, -2).addGap(11, 11, 11).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaInicio, -1, -1, 32767).addComponent(this.JTFHoraI).addComponent(this.JDCFechaFin, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFHoraF)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtReciboFin).addComponent(this.txtReciboIni)).addContainerGap()));
        this.jLabel1.setBackground(new Color(0, 153, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 102));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Valor Total");
        this.jLabel1.setOpaque(true);
        this.jLabel9.setBackground(new Color(0, 153, 153));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 102));
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("No. Cierre");
        this.jLabel9.setOpaque(true);
        this.txtValorCierre.setBackground(new Color(204, 255, 204));
        this.txtValorCierre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorCierre.setHorizontalAlignment(4);
        this.txtValorCierre.setDisabledTextColor(new Color(0, 0, 102));
        this.txtValorCierre.setEnabled(false);
        this.txtValorCierre.setFont(new Font("Arial", 1, 24));
        this.txtNoCierre.setBackground(new Color(204, 255, 204));
        this.txtNoCierre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtNoCierre.setHorizontalAlignment(4);
        this.txtNoCierre.setDisabledTextColor(new Color(0, 0, 102));
        this.txtNoCierre.setEnabled(false);
        this.txtNoCierre.setFont(new Font("Arial", 1, 24));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jScrollPane1.setBorder((Border) null);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.jTabbedPane1.addTab("DETALLE", this.jScrollPane1);
        this.JPIDContables.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTABLE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addActionListener(new ActionListener() { // from class: Caja.Cierre.7
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JCBTipoCActionPerformed(evt);
            }
        });
        this.JTFFNDoc.setEditable(false);
        this.JTFFNDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc.setHorizontalAlignment(0);
        this.JTFFNDoc.setFont(new Font("Arial", 1, 18));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDContablesLayout = new GroupLayout(this.JPIDContables);
        this.JPIDContables.setLayout(JPIDContablesLayout);
        JPIDContablesLayout.setHorizontalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JDFFechaC, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodoC, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoC, -2, 268, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDoc, -2, 140, -2).addContainerGap(-1, 32767)));
        JPIDContablesLayout.setVerticalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNDoc, -2, -1, -2)).addGap(0, 0, 32767)).addComponent(this.JDFFechaC, -1, -1, 32767)).addContainerGap()));
        this.JPIDContables1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PRESUPUESTALES", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Reconocimiento)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        this.JCBTipoDoc_RUD.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_RUD.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Recaudo)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDContables1Layout = new GroupLayout(this.JPIDContables1);
        this.JPIDContables1.setLayout(JPIDContables1Layout);
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_RUD, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addContainerGap(70, 32767)));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt).addComponent(this.JCBTipoDoc_RUD, -2, 50, -2)).addGap(9, 9, 9)));
        GroupLayout JPI_DatosCPLayout = new GroupLayout(this.JPI_DatosCP);
        this.JPI_DatosCP.setLayout(JPI_DatosCPLayout);
        JPI_DatosCPLayout.setHorizontalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDContables1, -1, -1, 32767).addComponent(this.JPIDContables, -1, -1, 32767)).addContainerGap()));
        JPI_DatosCPLayout.setVerticalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables, -2, -1, -2).addGap(24, 24, 24).addComponent(this.JPIDContables1, -2, -1, -2).addContainerGap(128, 32767)));
        this.jTabbedPane1.addTab("DATOS DE MOVIMIENTOS", this.JPI_DatosCP);
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.red);
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro por cajero?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Caja.Cierre.8
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPICiereLayout = new GroupLayout(this.JPICiere);
        this.JPICiere.setLayout(JPICiereLayout);
        JPICiereLayout.setHorizontalGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICiereLayout.createSequentialGroup().addContainerGap().addGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addGroup(JPICiereLayout.createSequentialGroup().addComponent(this.jPanel2, -2, 590, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9, -2, 250, -2).addComponent(this.txtNoCierre, -2, 250, -2).addComponent(this.jLabel1, -2, 250, -2).addComponent(this.txtValorCierre, -2, 250, -2)))).addContainerGap()));
        JPICiereLayout.setVerticalGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICiereLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICiereLayout.createSequentialGroup().addComponent(this.jLabel9, -2, 30, -2).addGap(0, 0, 0).addComponent(this.txtNoCierre, -2, 60, -2).addGap(0, 0, 0).addComponent(this.jLabel1, -2, 30, -2).addGap(0, 0, 0).addGroup(JPICiereLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorCierre, -2, 70, -2).addComponent(this.JCHFiltro))).addComponent(this.jPanel2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 424, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("DATOS DE CIERRE", this.JPICiere);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_Historico.getTableHeader().setReorderingAllowed(false);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Caja.Cierre.9
            public void mouseClicked(MouseEvent evt) {
                Cierre.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTB_Historico);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JTB_FiltroTodos);
        this.JTB_FiltroTodos.setFont(new Font("Arial", 1, 12));
        this.JTB_FiltroTodos.setText("Todos");
        this.JTB_FiltroTodos.addActionListener(new ActionListener() { // from class: Caja.Cierre.10
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_FiltroTodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JTB_FiltroPorConsolidar);
        this.JTB_FiltroPorConsolidar.setFont(new Font("Arial", 1, 12));
        this.JTB_FiltroPorConsolidar.setText("Por consolidar");
        this.JTB_FiltroPorConsolidar.addActionListener(new ActionListener() { // from class: Caja.Cierre.11
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_FiltroPorConsolidarActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JTB_FiltroConConsolido);
        this.JTB_FiltroConConsolido.setFont(new Font("Arial", 1, 12));
        this.JTB_FiltroConConsolido.setText("Con consolidado");
        this.JTB_FiltroConConsolido.addActionListener(new ActionListener() { // from class: Caja.Cierre.12
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_FiltroConConsolidoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTB_FiltroTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_FiltroPorConsolidar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_FiltroConConsolido).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTB_FiltroTodos).addComponent(this.JTB_FiltroPorConsolidar).addComponent(this.JTB_FiltroConConsolido)).addContainerGap(-1, 32767)));
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroEstado.add(this.JTB_EFiltroTodos);
        this.JTB_EFiltroTodos.setFont(new Font("Arial", 1, 12));
        this.JTB_EFiltroTodos.setSelected(true);
        this.JTB_EFiltroTodos.setText("Todos");
        this.JTB_EFiltroTodos.addActionListener(new ActionListener() { // from class: Caja.Cierre.13
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_EFiltroTodosActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstado.add(this.JTB_EFiltroActivos);
        this.JTB_EFiltroActivos.setFont(new Font("Arial", 1, 12));
        this.JTB_EFiltroActivos.setText("Activos");
        this.JTB_EFiltroActivos.addActionListener(new ActionListener() { // from class: Caja.Cierre.14
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_EFiltroActivosActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstado.add(this.JTB_EFiltroAnulados);
        this.JTB_EFiltroAnulados.setFont(new Font("Arial", 1, 12));
        this.JTB_EFiltroAnulados.setText("Anulados");
        this.JTB_EFiltroAnulados.addActionListener(new ActionListener() { // from class: Caja.Cierre.15
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JTB_EFiltroAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTB_EFiltroTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_EFiltroActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_EFiltroAnulados).addContainerGap(-1, 32767)));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTB_EFiltroTodos).addComponent(this.JTB_EFiltroActivos).addComponent(this.JTB_EFiltroAnulados)).addContainerGap(-1, 32767)));
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 1040, 32767)).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_Estado, -2, -1, -2))).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -2, -1, -2).addComponent(this.JPI_Estado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addComponent(this.JSPHistorico, -2, 535, -2).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Caja.Cierre.16
            public void mouseClicked(MouseEvent evt) {
                Cierre.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Caja.Cierre.17
            public void actionPerformed(ActionEvent evt) {
                Cierre.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 198, -2)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 680, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHoraIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
            this.JDFFechaC.setDate(this.JDCFechaFin.getDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHoraFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.clasecaja.imprimirCierre(this.xModelo1.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCActionPerformed(ActionEvent evt) {
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
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTPDatos.getSelectedIndex() == 0 && this.grid.getRowCount() > 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.grid, this.JTFRuta.getText(), "DETALLE " + getTitle());
            } else if (this.JTPDatos.getSelectedIndex() == 1 && this.JTB_Historico.getRowCount() > 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Historico, this.JTFRuta.getText(), "HISTORICO " + getTitle());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Tiene que haber al menos un resgitro en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_FiltroTodosActionPerformed(ActionEvent evt) {
        this.filtro = "0,1";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_FiltroPorConsolidarActionPerformed(ActionEvent evt) {
        this.filtro = "0";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_FiltroConConsolidoActionPerformed(ActionEvent evt) {
        this.filtro = "1";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_EFiltroTodosActionPerformed(ActionEvent evt) {
        this.filtroEstado = "0,1";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_EFiltroActivosActionPerformed(ActionEvent evt) {
        this.filtroEstado = "1";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_EFiltroAnuladosActionPerformed(ActionEvent evt) {
        this.filtroEstado = "0";
        mCargar_DatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargar_DatosRecibo();
    }

    private void mGenerarDoc_Presupuesto() {
        for (int y = 0; y < this.grid.getRowCount(); y++) {
            if (this.modelo.getValueAt(y, 8).equals("ACTIVO")) {
                this.sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,Observacion,  IdUsuarioR, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "',' CIERRE DE CAJA N° " + this.txtCaja.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.JTFFNDoc_Ppt.setText(this.consultas.ejecutarSQLId(this.sql));
                this.consultas.cerrarConexionBd();
                this.sql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`, idEncabezado, `Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.modelo.getValueAt(y, 12) + "', '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.modelo.getValueAt(y, 14) + "','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 13) + " -  RECIBO N° " + this.modelo.getValueAt(y, 2) + "');";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,Observacion,  IdUsuarioR, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_RUD[this.JCBTipoDoc_RUD.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "',' CIERRE DE CAJA N° " + this.txtCaja.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.JTFFNDoc_Ppt.setText(this.consultas.ejecutarSQLId(this.sql));
                this.consultas.cerrarConexionBd();
                this.sql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`, idEncabezado,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.modelo.getValueAt(y, 12) + "', '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.modelo.getValueAt(y, 14) + "','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 13) + " -  RECIBO N° " + this.modelo.getValueAt(y, 2) + "');";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void mGenerarDocContable() {
        String xid_tercero;
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion,  Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "',' CIERRE DE CAJA N° " + this.txtCaja.getText() + " N° " + this.txtNoCierre.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JTFFNDoc.setText(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            for (int y = 0; y < this.grid.getRowCount(); y++) {
                if (this.modelo.getValueAt(y, 8).equals("ACTIVO") && Boolean.valueOf(this.modelo.getValueAt(y, 16).toString()).booleanValue()) {
                    this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.modelo.getValueAt(y, 10) + "','0','" + Principal.informacionIps.getIdEmpresa() + "','" + this.modelo.getValueAt(y, 7) + "','0','" + this.modelo.getValueAt(y, 13) + " -  RECIBO N° " + this.modelo.getValueAt(y, 2) + "'  )";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    if (Long.valueOf(this.modelo.getValueAt(y, 14).toString()).longValue() == 0) {
                        if (this.modelo.getValueAt(y, 15).toString().equals("0")) {
                            xid_tercero = String.valueOf(Principal.informacionIps.getIdEmpresa());
                        } else {
                            this.sql = "INSERT INTO g_empresa (Id_TipoIdentificacion, No_identificacion, Dig_Verificacion, Id_Municipio, Direccion, Tel_Numero, Eps, Id_Persona, TipoPersona,Apellido1, Apellido2, Nombre1, Nombre2,Id_ClasificacionT, Fecha, UsuarioS) \nSELECT `g_persona`.`Id_TipoIdentificacion` , `g_persona`.`NoDocumento`  , ''  , `g_persona`.`Id_Municipio`  , `g_persona`.`Direccion` , `g_persona`.`Telefono` , 0 , `g_persona`.`Id` , 1 , `g_persona`.`Apellido1` , `g_persona`.`Apellido2` , `g_persona`.`Nombre1`  , `g_persona`.`Nombre2` , 1 , NOW(), '" + Principal.usuarioSistemaDTO.getLogin() + "'\nFROM `g_usuario`  INNER JOIN   `g_persona`   ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`g_persona`.`Id` ='" + this.modelo.getValueAt(y, 15) + "')";
                            ConsultasMySQL xct = new ConsultasMySQL();
                            xid_tercero = xct.ejecutarSQLId(this.sql);
                            xct.cerrarConexionBd();
                        }
                        this.modelo.setValueAt(xid_tercero, y, 14);
                        this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.modelo.getValueAt(y, 11) + "','1','" + xid_tercero + "','0','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 13) + " -  RECIBO N° " + this.modelo.getValueAt(y, 2) + "'  )";
                    } else {
                        String xid_tercero2 = this.modelo.getValueAt(y, 14).toString();
                        if (xid_tercero2.equals("") || xid_tercero2 == null) {
                            xid_tercero2 = String.valueOf(Principal.informacionIps.getIdEmpresa());
                        }
                        this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.modelo.getValueAt(y, 11) + "','1','" + xid_tercero2 + "','0','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 13) + " -  RECIBO N° " + this.modelo.getValueAt(y, 2) + "'  )";
                    }
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
            }
        }
        this.sql = "update k_cierre set Id_DocContable='" + this.JTFFNDoc.getText() + "' where Id='" + this.txtNoCierre.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
    }

    private void mLlenarCombo() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoC.removeAllItems();
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        this.JCBTipoDoc_RUD.removeAllItems();
        this.sql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.consultas.llenarCombo(this.sql, this.xidtipodoc, this.JCBTipoC);
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JCBTipoC.setSelectedItem("VENTAS");
        } else if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xidperiodo = this.consultas.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
        }
        this.sql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.consultas.llenarCombo(this.sql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt != null && this.xidtipodoc_ppt.length > 1) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.consultas.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt, 3);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.sql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=3 ";
        this.xidtipodoc_RUD = this.consultas.llenarCombo(this.sql, this.xidtipodoc_ppt, this.JCBTipoDoc_RUD);
        if (this.xidtipodoc_RUD != null && this.xidtipodoc_RUD.length > 1) {
            this.JCBTipoDoc_RUD.setSelectedIndex(-1);
        }
        this.consultas.cerrarConexionBd();
        this.xllenoc = 1;
        this.xllenocg = 1;
    }
}
