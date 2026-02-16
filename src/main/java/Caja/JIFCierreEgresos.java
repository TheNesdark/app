package Caja;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.caja.ReciboEgresosDAO;
import com.genoma.plus.dao.caja.ReciboIngresoDAO;
import com.genoma.plus.dao.impl.caja.ReciboIngresoDAOImpl;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

/* JADX INFO: loaded from: GenomaP.jar:Caja/JIFCierreEgresos.class */
public class JIFCierreEgresos extends JInternalFrame {
    private DefaultTableModel xmodeloD;
    private DefaultTableModel xmodeloH;
    private ReciboEgresosDAO xReciboEgresosDAO;
    private Object[] xDato;
    private String[] xidtipodoc;
    private String[] xidperiodo;
    private String[] xidtipodoc_ppt;
    private String[] xidperiodo_ppt;
    private String[] xidperiodo_RUD;
    private String[] xidtipodoc_RUD;
    private claseCaja clasecaja;
    private String sql;
    private String fechaInicio;
    private String idCierre;
    private ReciboIngresoDAO reciboIngresoDAO;
    private JButton JBTExportar;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox JCBTipoDoc_RUD;
    private JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JDateChooser JDFFechaC;
    private JPanel JPCierre;
    private JPanel JPExportar;
    private JPanel JPIDContables;
    private JPanel JPIDContables1;
    private JPanel JPMovimiento;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPHistorico;
    private JTable JTDetalle;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFHoraF;
    private JFormattedTextField JTFHoraI;
    private JTextField JTFRuta;
    private JTable JTHistorico;
    private JTabbedPane JTPGeneral;
    private JTabbedPane JTPMovimientos;
    private JFormattedTextField txtValorCierre;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xllenoc = 0;
    private int xllenocg = 0;
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public JIFCierreEgresos(claseCaja xclasecaja) {
        initComponents();
        this.clasecaja = xclasecaja;
        setTitle("CIERRE DE CAJA DE EGRESOS :  " + this.clasecaja.getNbreCaja());
        mNuevo();
        springStart();
    }

    private void springStart() {
        this.reciboIngresoDAO = (ReciboIngresoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reciboIngresoDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.fechaInicio = this.clasecaja.verificarCajaAbierta();
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFHoraI.setValue(this.xmt.getFechaActual());
        this.JTFHoraF.setValue(this.xmt.getFechaActual());
        this.JTFFNDoc.setText("");
        this.JTFFNDoc_Ppt.setText("");
        mCargar_DatosRecibo();
        mCargar_DatosHistorico();
        this.xlleno = true;
        mLlenarCombos();
    }

    public void mGrabar() {
        if (this.JTDetalle.getRowCount() > 0) {
            if (Principal.txtNo.getText().isEmpty()) {
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    mGrabar_Recibo();
                    this.clasecaja.imprimirCierreEgresos(Principal.txtNo.getText());
                } else if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        mGrabar_Recibo();
                        this.clasecaja.imprimirCierreEgresos(Principal.txtNo.getText());
                    }
                } else if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
                    if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 6) && !this.xmt.mVerificarDatosLLeno(this.JTDetalle, 7)) {
                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x2 == 0) {
                                    mGrabar_Recibo();
                                    mGenerarDocContable();
                                    this.clasecaja.imprimirCierreEgresos(Principal.txtNo.getText());
                                }
                            } else {
                                this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                this.JCBPeriodoC.requestFocus();
                            }
                        } else {
                            this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento");
                            this.JCBTipoC.requestFocus();
                        }
                    } else {
                        this.xmt.mostrarMensaje("Faltan cuentas puc en los conceptos");
                    }
                } else if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                    if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 8)) {
                        if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_RUD.getSelectedIndex() != -1) {
                                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                    int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x3 == 0) {
                                        mGrabar_Recibo();
                                        mGenerarDoc_Presupuesto();
                                        this.clasecaja.imprimirCierreEgresos(Principal.txtNo.getText());
                                    }
                                } else {
                                    this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                    this.JCBPeriodo_Ppt.requestFocus();
                                }
                            } else {
                                this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de recaudo");
                                this.JCBTipoDoc_RUD.requestFocus();
                            }
                        } else {
                            this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de reconocimiento");
                            this.JCBTipoDoc_Ppt.requestFocus();
                        }
                    } else {
                        this.xmt.mostrarMensaje("Faltan rubros presupuestales en los conceptos");
                    }
                } else if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                    if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 6) && !this.xmt.mVerificarDatosLLeno(this.JTDetalle, 7) && !this.xmt.mVerificarDatosLLeno(this.JTDetalle, 8)) {
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
                                                this.clasecaja.imprimirCierreEgresos(Principal.txtNo.getText());
                                            }
                                        } else {
                                            this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                            this.JCBPeriodoC.requestFocus();
                                        }
                                    } else {
                                        this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento");
                                        this.JCBTipoC.requestFocus();
                                    }
                                } else {
                                    this.xmt.mostrarMensaje("Debe seleccionar el período contable");
                                    this.JCBPeriodo_Ppt.requestFocus();
                                }
                            } else {
                                this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de recaudo");
                                this.JCBTipoDoc_RUD.requestFocus();
                            }
                        } else {
                            this.xmt.mostrarMensaje("Debe seleccionar el tipo de documento de reconocimiento");
                            this.JCBTipoDoc_Ppt.requestFocus();
                        }
                    } else {
                        this.xmt.mostrarMensaje("Faltan cuentas puc y/o rubros presupuestales en los conceptos");
                    }
                }
            } else {
                this.xmt.mostrarMensaje("Cierre ya grabado");
            }
        } else {
            this.xmt.mostrarMensaje("No hay recibos para realizar el cierre");
        }
        mCargar_DatosHistorico();
    }

    private void mGrabar_Recibo() {
        this.sql = "insert into k_cierre_egresos (Id_Caja ,  Id_Usuario  ,  FechaInicio  ,  FechaFinal , Valor, UsuarioS) values('" + this.clasecaja.getIdCaja() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "','" + this.txtValorCierre.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE k_recibos_egresos,  (\nSELECT k_recibos_egresos.`Id`,  k_recibos_egresos.IdCierre\nFROM  `k_recibos_egresos`\nINNER JOIN k_recibos_egreso_detalle   ON (`k_recibos_egreso_detalle`.`Id_Recibo` = `k_recibos_egresos`.`Id`)  \nINNER JOIN `k_conceptos` ON (`k_recibos_egreso_detalle`.`IdConcepto` = `k_conceptos`.`Id`)  \nINNER JOIN `cc_terceros` ON (cc_terceros.`Id` = `k_recibos_egresos`.`Id_Tercero`)\nWHERE  (k_recibos_egresos.IdCaja ='" + this.clasecaja.getIdCaja() + "' \n AND (k_recibos_egresos.FechaR BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "'  AND '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "')  \n AND k_recibos_egresos.IdCierre=0\n) \nGROUP BY k_recibos_egresos.`Id` \nORDER BY k_recibos_egresos.`Id` ASC \n) AS Tabla SET k_recibos_egresos.`Idcierre`='" + Principal.txtNo.getText() + "'  WHERE k_recibos_egresos.`Id`=Tabla.Id";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void mGenerarDoc_Presupuesto() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                if (this.xmodeloD.getValueAt(y, 5).equals("ACTIVO")) {
                    this.sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,Observacion,  IdUsuarioR, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "',' CIERRE DE CAJA DE EGRESOS N° " + this.clasecaja.getNbreCaja() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.JTFFNDoc_Ppt.setText(this.consultas.ejecutarSQLId(this.sql));
                    this.consultas.cerrarConexionBd();
                    this.sql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodeloD.getValueAt(y, 8) + "','" + this.xmodeloD.getValueAt(y, 10) + "','" + this.xmodeloD.getValueAt(y, 4) + "','" + this.xmodeloD.getValueAt(y, 9) + " -  RECIBO N° " + this.xmodeloD.getValueAt(y, 1) + "');";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    this.sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,Observacion,  IdUsuarioR, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "','" + this.xidtipodoc_RUD[this.JCBTipoDoc_RUD.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',' CIERRE DE CAJA DE EGRESOS N° " + this.clasecaja.getNbreCaja() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.JTFFNDoc_Ppt.setText(this.consultas.ejecutarSQLId(this.sql));
                    this.consultas.cerrarConexionBd();
                    this.sql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodeloD.getValueAt(y, 8) + "','" + this.xmodeloD.getValueAt(y, 10) + "','" + this.xmodeloD.getValueAt(y, 4) + "','" + this.xmodeloD.getValueAt(y, 9) + " -  RECIBO N° " + this.xmodeloD.getValueAt(y, 1) + "');";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
            }
        }
    }

    private void mGenerarDocContable() {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion,  Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','CIERRE DE CAJA DE EGRESOS N° " + this.clasecaja.getNbreCaja() + " N° " + Principal.txtNo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JTFFNDoc.setText(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                if (this.xmodeloD.getValueAt(y, 5).equals("ACTIVO") && Boolean.valueOf(this.xmodeloD.getValueAt(y, 11).toString()).booleanValue()) {
                    this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito,NFactura, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodeloD.getValueAt(y, 6) + "','0','" + this.xmodeloD.getValueAt(y, 10) + "','" + this.xmodeloD.getValueAt(y, 4) + "','0','" + this.xmodeloD.getValueAt(y, 12) + "','" + this.xmodeloD.getValueAt(y, 9) + " -  RECIBO N° " + this.xmodeloD.getValueAt(y, 1) + "'  )";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                        this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito,NFactura, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodeloD.getValueAt(y, 7) + "','1','" + this.xmodeloD.getValueAt(y, 10) + "','0','" + this.xmodeloD.getValueAt(y, 4) + "','" + this.xmodeloD.getValueAt(y, 12) + "','" + this.xmodeloD.getValueAt(y, 9) + " -  RECIBO N° " + this.xmodeloD.getValueAt(y, 1) + "'  )";
                    } else {
                        this.sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito,NFactura, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodeloD.getValueAt(y, 7) + "','1','" + Principal.informacionIps.getIdEmpresa() + "','0','" + this.xmodeloD.getValueAt(y, 4) + "','" + this.xmodeloD.getValueAt(y, 12) + "','" + this.xmodeloD.getValueAt(y, 9) + " -  RECIBO N° " + this.xmodeloD.getValueAt(y, 1) + "'  )";
                    }
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
            }
        }
        this.sql = "update k_cierre_egresos set Id_DocContable='" + this.JTFFNDoc.getText() + "' where Id='" + Principal.txtNo.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
    }

    private void mLlenarCombos() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoC.removeAllItems();
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        this.JCBTipoDoc_RUD.removeAllItems();
        this.sql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsEgreso` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.consultas.llenarCombo(this.sql, this.xidtipodoc, this.JCBTipoC);
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JCBTipoC.setSelectedItem("EGRESOS DE CAJA ");
        } else if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xidperiodo = this.consultas.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
        }
        this.sql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.consultas.llenarCombo(this.sql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.consultas.llenarCombo("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.sql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=3 ";
        this.xidtipodoc_RUD = this.consultas.llenarCombo(this.sql, this.xidtipodoc_ppt, this.JCBTipoDoc_RUD);
        if (this.xidtipodoc_RUD.length > 1) {
            this.JCBTipoDoc_RUD.setSelectedIndex(-1);
        }
        this.consultas.cerrarConexionBd();
        this.xllenoc = 1;
        this.xllenocg = 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_ModeloHistorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"No Cierre", "Caja", "Fecha Inicial", "Fecha Final", "Valor", "Cajero", "Agregar", "idDocumentoC", "Estado", "Fecha Anulación", "Observación Anulación", "Usuario de Anulación"}) { // from class: Caja.JIFCierreEgresos.1
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xmodeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(280);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(200);
    }

    public void mCargar_DatosHistorico() {
        try {
            mCrear_ModeloHistorico();
            this.sql = "SELECT k_cierre_egresos.Id , k_caja.Nbre AS Caja, k_cierre_egresos.FechaInicio AS FechaI , k_cierre_egresos.FechaFinal AS FechaF , k_cierre_egresos.Valor, w_persona.NUsuario AS Cajero, k_cierre_egresos.Id_DocContable , k_cierre_egresos.estado, k_cierre_egresos.Fecha_Anulacion, k_cierre_egresos.Detalle_Anulacion, k_cierre_egresos.Usuario_Anulacion  FROM k_cierre_egresos INNER JOIN k_caja \nON (k_cierre_egresos.Id_Caja = k_caja.Id) INNER JOIN w_persona ON (k_cierre_egresos.Id_Usuario = w_persona.Id_persona) WHERE (k_cierre_egresos.IdConsolidado =0 AND NOT(k_cierre_egresos.FechaFinal IS NULL) ) ORDER BY  k_cierre_egresos.Id DESC";
            ResultSet rs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int xnfila = 0;
                    while (rs.next()) {
                        this.xmodeloH.addRow(this.xDato);
                        this.xmodeloH.setValueAt(rs.getString(1), xnfila, 0);
                        this.xmodeloH.setValueAt(rs.getString(2), xnfila, 1);
                        this.xmodeloH.setValueAt(rs.getString(3), xnfila, 2);
                        this.xmodeloH.setValueAt(rs.getString(4), xnfila, 3);
                        this.xmodeloH.setValueAt(Long.valueOf(rs.getLong(5)), xnfila, 4);
                        this.xmodeloH.setValueAt(rs.getString(6), xnfila, 5);
                        this.xmodeloH.setValueAt(true, xnfila, 6);
                        this.xmodeloH.setValueAt(rs.getString("Id_DocContable"), xnfila, 7);
                        this.xmodeloH.setValueAt(Boolean.valueOf(rs.getBoolean("estado")), xnfila, 8);
                        this.xmodeloH.setValueAt(rs.getString("Fecha_Anulacion"), xnfila, 9);
                        this.xmodeloH.setValueAt(rs.getString("Detalle_Anulacion"), xnfila, 10);
                        this.xmodeloH.setValueAt(rs.getString("Usuario_Anulacion"), xnfila, 11);
                        xnfila++;
                    }
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.consultas.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mCrear_ModeloRecibo() {
        this.xmodeloD = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "No. Recibo", "Documento", "Usuario", "Total", "Estado", "Debito", "Credito", "RPResupuesto", "Concepto", "Id_tercero", "Aplica Contabilidad?", "No. Factura"}) { // from class: Caja.JIFCierreEgresos.2
            Class[] types = {String.class, Long.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, Long.class, Boolean.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodeloD);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
    }

    private void mCargar_DatosRecibo() {
        this.sql = "SELECT\n    `k_recibos_egresos`.`FechaR`\n    , `k_recibos_egresos`.`Id`\n    , `cc_terceros`.`TDCompleto` AS `Documento`\n    , TRIM(`cc_terceros`.`RazonSocialCompleta`) AS `Tercero`\n    , SUM(`k_recibos_egreso_detalle`.`Valor`) AS Total\n    , `k_recibos_egresos`.`Estado`\n    , `k_conceptos`.`CDebito`\n    , `k_conceptos`.`CCredito`\n    , `k_conceptos`.`RPresupuestal`\n    , `k_conceptos`.`Nbre`\n    , `cc_terceros`.`Id` AS IdTercero\n    , `k_conceptos`.AMovContable \n    , `k_recibos_egresos`.`numeroFactura`\nFROM\n    `cc_terceros`\n    INNER JOIN `k_recibos_egresos` \n        ON (`cc_terceros`.`Id` = `k_recibos_egresos`.`Id_Tercero`)\n    INNER JOIN `k_recibos_egreso_detalle` \n        ON (`k_recibos_egreso_detalle`.`Id_Recibo` = `k_recibos_egresos`.`Id`)\n    INNER JOIN `k_conceptos` \n        ON (`k_recibos_egreso_detalle`.`IdConcepto` = `k_conceptos`.`Id`)\nWHERE (`k_recibos_egresos`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " " + this.JTFHoraI.getText() + "'\n    AND `k_recibos_egresos`.`IdCierre` =0\n    AND `k_recibos_egresos`.`IdCaja` ='" + this.clasecaja.getIdCaja() + "')\n    AND (`k_recibos_egresos`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + " " + this.JTFHoraF.getText() + "')\nGROUP BY `k_recibos_egresos`.`Id`, `cc_terceros`.`Id` , `k_conceptos`.`CDebito`\nORDER BY `k_recibos_egresos`.`Id` DESC;";
        ResultSet rs = this.consultas.traerRs(this.sql);
        mCrear_ModeloRecibo();
        try {
            Double vrCierre = Double.valueOf(0.0d);
            if (rs.next()) {
                rs.beforeFirst();
                int xnfila = 0;
                while (rs.next()) {
                    this.xmodeloD.addRow(this.xDato);
                    this.xmodeloD.setValueAt(this.xmt.formatoAMD.format((Date) rs.getDate(1)), xnfila, 0);
                    this.xmodeloD.setValueAt(Long.valueOf(rs.getLong(2)), xnfila, 1);
                    this.xmodeloD.setValueAt(rs.getString(3), xnfila, 2);
                    this.xmodeloD.setValueAt(rs.getString(4), xnfila, 3);
                    this.xmodeloD.setValueAt(Double.valueOf(rs.getDouble(5)), xnfila, 4);
                    if (rs.getInt(6) == 0) {
                        this.xmodeloD.setValueAt("ACTIVO", xnfila, 5);
                        vrCierre = Double.valueOf(vrCierre.doubleValue() + rs.getDouble(5));
                        this.txtValorCierre.setValue(vrCierre);
                    } else {
                        this.xmodeloD.setValueAt("ANULADO", xnfila, 5);
                    }
                    this.xmodeloD.setValueAt(rs.getString(7), xnfila, 6);
                    this.xmodeloD.setValueAt(rs.getString(8), xnfila, 7);
                    this.xmodeloD.setValueAt(rs.getString(9), xnfila, 8);
                    this.xmodeloD.setValueAt(rs.getString(10), xnfila, 9);
                    this.xmodeloD.setValueAt(Long.valueOf(rs.getLong(11)), xnfila, 10);
                    this.xmodeloD.setValueAt(Boolean.valueOf(rs.getBoolean(12)), xnfila, 11);
                    this.xmodeloD.setValueAt(rs.getString("numeroFactura"), xnfila, 12);
                    xnfila++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v107, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPGeneral = new JTabbedPane();
        this.JPCierre = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.txtValorCierre = new JFormattedTextField();
        this.JTPMovimientos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPMovimiento = new JPanel();
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
        this.JTFHoraI = new JFormattedTextField();
        this.JTFHoraF = new JFormattedTextField();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRE DE EGRESOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcierreegresos");
        this.JTPGeneral.setForeground(Color.red);
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIFCierreEgresos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierreEgresos.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIFCierreEgresos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierreEgresos.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.txtValorCierre.setEditable(false);
        this.txtValorCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtValorCierre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorCierre.setHorizontalAlignment(4);
        this.txtValorCierre.setDisabledTextColor(new Color(0, 0, 102));
        this.txtValorCierre.setFont(new Font("Arial", 1, 24));
        this.JTPMovimientos.setForeground(new Color(0, 103, 0));
        this.JTPMovimientos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPMovimientos.addTab("DETALLE", this.JSPDetalle);
        this.JPIDContables.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTABLE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addActionListener(new ActionListener() { // from class: Caja.JIFCierreEgresos.5
            public void actionPerformed(ActionEvent evt) {
                JIFCierreEgresos.this.JCBTipoCActionPerformed(evt);
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
        JPIDContablesLayout.setHorizontalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JDFFechaC, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodoC, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoC, -2, 268, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDoc, -2, 140, -2).addContainerGap(117, 32767)));
        JPIDContablesLayout.setVerticalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNDoc, -2, -1, -2)).addGap(0, 2, 32767)).addComponent(this.JDFFechaC, -1, -1, 32767)).addContainerGap()));
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
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_RUD, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addGap(18, 18, 18)));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt).addComponent(this.JCBTipoDoc_RUD, -2, 50, -2)).addContainerGap()));
        GroupLayout JPMovimientoLayout = new GroupLayout(this.JPMovimiento);
        this.JPMovimiento.setLayout(JPMovimientoLayout);
        JPMovimientoLayout.setHorizontalGroup(JPMovimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPMovimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovimientoLayout.createSequentialGroup().addComponent(this.JPIDContables, -1, -1, -2).addGap(0, 0, 32767)).addComponent(this.JPIDContables1, -1, -1, 32767)).addContainerGap()));
        JPMovimientoLayout.setVerticalGroup(JPMovimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables, -2, -1, -2).addGap(24, 24, 24).addComponent(this.JPIDContables1, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPMovimientos.addTab("DATOS DE MOVIMIENTOS", this.JPMovimiento);
        this.JTFHoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFHoraI.setFont(new Font("Arial", 1, 12));
        this.JTFHoraI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIFCierreEgresos.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierreEgresos.this.JTFHoraIPropertyChange(evt);
            }
        });
        this.JTFHoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraF.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFHoraF.setFont(new Font("Arial", 1, 12));
        this.JTFHoraF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIFCierreEgresos.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierreEgresos.this.JTFHoraFPropertyChange(evt);
            }
        });
        GroupLayout JPCierreLayout = new GroupLayout(this.JPCierre);
        this.JPCierre.setLayout(JPCierreLayout);
        JPCierreLayout.setHorizontalGroup(JPCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCierreLayout.createSequentialGroup().addContainerGap().addGroup(JPCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPMovimientos).addGroup(JPCierreLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFHoraI, -2, 120, -2).addGap(27, 27, 27).addComponent(this.JDCFechaFin, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFHoraF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtValorCierre, -2, 250, -2))).addContainerGap()));
        JPCierreLayout.setVerticalGroup(JPCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCierreLayout.createSequentialGroup().addContainerGap().addGroup(JPCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaFin, -2, 50, -2).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.txtValorCierre, -2, 60, -2).addGroup(JPCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFHoraI).addComponent(this.JTFHoraF, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMovimientos, -2, 278, -2).addGap(10, 10, 10)));
        this.JTPGeneral.addTab("DATOS DE CIERRE", this.JPCierre);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Caja.JIFCierreEgresos.8
            public void mouseClicked(MouseEvent evt) {
                JIFCierreEgresos.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTPGeneral.addTab("HISTÓRICO", this.JSPHistorico);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Caja.JIFCierreEgresos.9
            public void mouseClicked(MouseEvent evt) {
                JIFCierreEgresos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Caja.JIFCierreEgresos.10
            public void actionPerformed(ActionEvent evt) {
                JIFCierreEgresos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 180, -2).addGap(18, 18, 18)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(11, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral).addComponent(this.JPExportar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPGeneral, -2, 393, -2).addGap(10, 10, 10).addComponent(this.JPExportar, -1, -1, 32767)));
        pack();
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
            if (this.JTPGeneral.getSelectedIndex() == 0 && this.JTDetalle.getRowCount() > 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), "DETALLE " + getTitle());
            } else if (this.JTPGeneral.getSelectedIndex() == 1 && this.JTHistorico.getRowCount() > 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTHistorico, this.JTFRuta.getText(), "HISTORICO " + getTitle());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Tiene que haber al menos un resgitro en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHoraIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHoraFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DatosRecibo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.clasecaja.imprimirCierreEgresos(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
        }
    }

    public void anular() {
        if (this.JTPGeneral.getSelectedIndex() != 1 || this.JTHistorico.getSelectedRow() == -1) {
            return;
        }
        if (Long.valueOf(this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString()).longValue() == 0) {
            Anular frm = new Anular(null, true, "Cierre Recibo Egreso", 12);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cierre con documento contable No. " + this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString() + " activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularCierre(String motivo, String observacion) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.reciboIngresoDAO.anularCierreReciboEgreso(this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString(), motivo, observacion, Principal.usuarioSistemaDTO.getNombreUsuario());
            this.reciboIngresoDAO.actualizarDatosReciboCajaIdCierre(this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            mCargar_DatosHistorico();
        }
    }
}
