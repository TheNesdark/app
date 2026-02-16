package Armado;

import Acceso.Principal;
import Facturacion.JIFLiqServicios;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JPGlosa.class */
public class JPGlosa extends JPanel {
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodelo4;
    private String[] xidempresa;
    private String[] xidetapa;
    private String[] xidtipodoc;
    private String[][] xidconceptop;
    private String[][] xidconceptog;
    private String[][] xidconceptod;
    private String[][] xCuenta;
    private String xsql;
    private String xidLiquidacion;
    private String xllamador;
    private String msg;
    private Object[] xdato;
    private File xfile;
    private File directorio;
    private String[][] xencabezado;
    private GCuentaDAOImpl gcuenta;
    private PresupuestoDAOImpl presupuesto;
    private ContabilidadDAOImpl contabilidad;
    private long xIdDocRespuestaGlosa;
    private WorkerSQL xWorkerSQL;
    private JIFLiqServicios xJIFLiqServicios;
    private JButton JBTAdicionarSoporteR;
    private JButton JBTExportar;
    private JButton JBTRespImprimir;
    private JComboBox JCBConceptoG;
    private JComboBox JCBTipoC;
    private JCheckBox JCHEsTraslado;
    private JCheckBox JCHEstadoSoporte;
    private JCheckBox JCH_AplicaMC;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFechaGlosa;
    private JDateChooser JDFechaRGlosa;
    private JLabel JLBNRespuesta;
    private JLabel JLNRoRadicado;
    private JPanel JPIDRespuesta;
    private JPanel JPIDSoportes;
    private JPanel JPIDatosGlosa;
    private JPanel JPIRespuesta;
    private JPanel JPI_InformacionContable;
    private JPanel JPI_Utilizades;
    private JScrollPane JSPDetalleG;
    private JScrollPane JSPHistoricoResp;
    private JScrollPane JSPObsGlosa;
    private JScrollPane JSPObservacionSoporte;
    private JScrollPane JSPRespuesraGlosa;
    private JScrollPane JSPRespuestaSoporte;
    private JTextPane JTAObsGlosa;
    private JTextArea JTAObservacionSoporte;
    private JTextPane JTARespuesraGlosa;
    private JTabbedPane JTBDetalleGlosa;
    private JTable JTDetalleG;
    private JFormattedTextField JTFFRValorAceptado;
    private JFormattedTextField JTFFRValorGlosado;
    private JFormattedTextField JTFFRValorRecobrado;
    private JFormattedTextField JTFFValorGlosado;
    private JTextField JTFNGlosa;
    private JTextField JTFRuta;
    private JTextField JTFSoporteRespuesta;
    private JTextField JTFUrlSoporteGS;
    private JTable JTHistoricoResp;
    private JTabbedPane JTPDatosRespuesta;
    private JTabbedPane JTPDatosU;
    private JTable JTRespuestaSoporte;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xestadograbadorglosa = false;
    private boolean xerror = false;
    private double xvalorg = 0.0d;
    private int xcjuridico = 0;
    private int xtraslado = 0;
    private int xsoporterespuesta = 0;
    private int xgrabadosoporteRespuesta = 0;
    private long xConsecutivo = 0;
    private long xIdDocGlosa = 0;
    private long xIdDocDevoluciones = 0;
    private Object[] fila = new Object[39];

    public JPGlosa(JIFLiqServicios xJIFLiqServicios, String xllamador) {
        initComponents();
        springStart();
        this.xJIFLiqServicios = xJIFLiqServicios;
        this.xidLiquidacion = String.valueOf(xJIFLiqServicios.getxId_Liqidacion());
        this.xllamador = xllamador;
        mConsultarFactura();
        mNuevo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.gcuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.presupuesto = (PresupuestoDAOImpl) classPathXmlApplicationContext.getBean("presupuestoDAOImpl");
        this.contabilidad = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
    }

    public void mNuevo() {
        if (this.xllamador.equals("Radicación")) {
            this.JTBDetalleGlosa.remove(1);
        } else if (this.xllamador.equals("Respuesta")) {
            this.JTPDatosU.remove(0);
        }
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        mBucarDetalleGlosas();
        mCrearTablaSoporteRespuestaGlosa();
        mNuevaRadica();
        mNuevaGlosa();
        mNuevoRespuestaSoporte();
    }

    public void mGrabar() {
        if (this.xllamador.equals("Radicación")) {
            mGrabarGlosa();
        } else if (this.xllamador.equals("Respuesta")) {
            mGrabarRespuestaGlosa();
        }
    }

    private void mGrabarGlosa() {
        if (!this.xerror) {
            if (this.fila[8] != null && ((Boolean) this.fila[8]).booleanValue()) {
                if (this.JCBConceptoG.getSelectedIndex() == -1) {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBConceptoG.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue() > 0.0d) {
                    if (this.JCH_AplicaMC.isSelected()) {
                        if (!this.fila[32].toString().equals("") && !this.fila[33].toString().equals("")) {
                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                if (Principal.xclase.mValidarFechasDoc(this.JDFechaGlosa.getDate())) {
                                    mGenerarDocContableGlosa();
                                    mGrabar_Glosa();
                                    mBucarDetalleGlosas();
                                    mNuevaGlosa();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Faltan parametrizacion de cuentas contables para radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    mGrabar_Glosa();
                    mBucarDetalleGlosas();
                    mNuevaGlosa();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta registrar el valor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValorGlosado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta registro de datos de radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, this.msg, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarRespuestaGlosa() {
        if (!this.xerror) {
            if (this.JTDetalleG.getSelectedRow() != -1) {
                if (!this.JTARespuesraGlosa.getText().isEmpty()) {
                    if (this.JLBNRespuesta.getText().isEmpty()) {
                        if (mValidarValoresRespuesta()) {
                            if (this.JCH_AplicaMC.isSelected()) {
                                if (mVerificaUltNivel(this.fila[32].toString()) && mVerificaUltNivel(this.fila[33].toString()) && mVerificaUltNivel(this.fila[35].toString()) && mVerificaUltNivel(this.fila[34].toString())) {
                                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x == 0) {
                                        mGenerarDocContableRespuestaGlosa();
                                        mGrabar_RespuestaGlosa();
                                        mActualizarLiquidacionRespuestaGlosa();
                                        mBucarHistoricoRespuestaGlosas();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x2 == 0) {
                                mGrabar_RespuestaGlosa();
                                mActualizarLiquidacionRespuestaGlosa();
                                mBucarHistoricoRespuestaGlosas();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Respuesta ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Respuesta no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTARespuesraGlosa.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una glosa a responder", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBDetalleGlosa.setSelectedIndex(0);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, this.msg, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mBuscar() {
        mBucarDetalleGlosas();
        mNuevaRadica();
        mNuevaGlosa();
    }

    public void mAnular() {
        if (this.xllamador.equals("Radicación")) {
            if (this.JTDetalleG.getSelectedRow() != -1) {
                if (Long.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 9).toString()).longValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "Glosa Con Documento Contable Activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTBDetalleGlosa.setSelectedIndex(1);
                    return;
                } else {
                    if (Double.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 8).toString()).doubleValue() == 0.0d) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            Anular frm = new Anular(null, true, "xjpglosa", 5);
                            frm.setVisible(true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Glosa con respuesta activa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTBDetalleGlosa.setSelectedIndex(1);
                    this.JTPDatosRespuesta.setSelectedIndex(2);
                    return;
                }
            }
            return;
        }
        if (!this.xllamador.equals("Respuesta") || this.JLBNRespuesta.getText().isEmpty()) {
            return;
        }
        if (Long.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 7).toString()).longValue() == 0) {
            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                Anular frm2 = new Anular(null, true, "xjpglosaRespuestas", 5);
                frm2.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Respuesta Glosa Con Documento Contable Activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBDetalleGlosa.setSelectedIndex(1);
    }

    public void mAnular_Glosa(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        this.xsql = "update f_factura_glosa set Estado=0,  Id_Motivo_Anulacion=" + idMotivoAnulacion + ",`Motivo_Anulacion`='" + xMotivo + "' ,`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' ,`Observacion_Anulacion`='" + xObservacion + "' ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id= '" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mBuscar();
    }

    public void mAnular_RGlosa(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        this.xsql = "update f_factura_glosa_respuesta set Estado=0, Id_Motivo_Anulacion=" + idMotivoAnulacion + ",`Motivo_Anulacion`='" + xMotivo + "' ,`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' ,`Observacion_Anulacion`='" + xObservacion + "' ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id='" + this.JLBNRespuesta.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_liquidacion set VGlosaR=VGlosaR-" + this.JTFFRValorRecobrado.getValue() + ", TGlosa=TGlosa-" + this.JTFFRValorGlosado.getValue() + ", VGlosaNR=VGlosaNR-" + this.JTFFRValorAceptado.getValue() + " ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id= '" + this.xidLiquidacion + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mBuscar();
    }

    private void mLLenarCEmpresa() {
        this.xlleno = false;
        mCrearTablaDetalleGlosa();
        mNuevaRadica();
        mNuevaGlosa();
    }

    private void mCrearTablaDetalleGlosa() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Concepto", "NRadicación", "Valor", "Observación", "Estado", "UrlSoporte", "VRespuesta", "idDocumentoC"}) { // from class: Armado.JPGlosa.1
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleG.setModel(this.xmodelo2);
        this.JTDetalleG.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleG.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleG.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleG.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleG.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    private void mCrearTablaHistoricoRespuestaGlosa() {
        this.xmodelo3 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "VGlosado", "VNRecuperable", "V/Recuperable", "EsTraslado?", "IdDocumentoC"}) { // from class: Armado.JPGlosa.2
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTHistoricoResp.setModel(this.xmodelo3);
        this.JTHistoricoResp.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistoricoResp.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistoricoResp.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTHistoricoResp.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistoricoResp.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistoricoResp.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistoricoResp.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTHistoricoResp.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    private void mCrearTablaSoporteRespuestaGlosa() {
        this.xmodelo4 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Observacion", "Ruta", "Estado"}) { // from class: Armado.JPGlosa.3
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTRespuestaSoporte.setModel(this.xmodelo4);
        this.JTRespuestaSoporte.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTRespuestaSoporte.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTRespuestaSoporte.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTRespuestaSoporte.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mGenerarDatosCartera() {
        mCrearEncabezado();
        mCrearTabla();
        mAlterarTabla();
        mllenarTabla();
        mActualizarDatos();
    }

    private void mCrearEncabezado() {
        this.xsql = "SELECT `Id`, `Nbre`, `VMinimo`, `VMaximo`  FROM  `f_tipo_periodos_cartera` WHERE (`Estado` =1) ORDER BY `Orden` ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.last();
                this.xencabezado = new String[xrs.getRow()][3];
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xencabezado[x][0] = xrs.getString(2);
                    this.xencabezado[x][1] = xrs.getString(3);
                    this.xencabezado[x][2] = xrs.getString(4);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTabla() {
        this.xsql = "DROP TABLE IF EXISTS f_tmp_cartera";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `f_tmp_cartera` ( `Id` smallint(5) NOT NULL default '0', `Empresa` varchar(2000) default '' ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mAlterarTabla() {
        for (int x = 0; x < this.xencabezado.length; x++) {
            if (x == 0) {
                this.xsql = "alter table  f_tmp_cartera add " + this.xencabezado[x][0] + " double default '0' after `Empresa` ";
            } else {
                this.xsql = "alter table  f_tmp_cartera add " + this.xencabezado[x][0] + " double default '0' after " + this.xencabezado[x - 1][0] + " ";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mllenarTabla() {
        this.xsql = "INSERT INTO f_tmp_cartera (Id, Empresa) SELECT g_empresacont.Id_empresa,  `cc_terceros`.`RazonSocialCompleta` FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)   INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)   INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)  INNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)   INNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)  WHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "'  AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0   AND f_factura_evento.EstaArmada=2 AND (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))<>0 )    GROUP BY  g_empresacont.Id_empresa ORDER BY  `cc_terceros`.`RazonSocialCompleta` ASC  ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mActualizarDatos() {
        try {
            this.xsql = "SELECT `Id` FROM `f_tmp_cartera` ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    for (int x = 0; x < this.xencabezado.length; x++) {
                        this.xsql = "SELECT SUM(IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)) AS Saldo FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)   INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)   INNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)   INNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) WHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "'  AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0  AND g_empresacont.Id_empresa=" + xrs.getLong(1) + " AND f_factura_evento.EstaArmada=2 AND (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))<>0  AND (IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(),  DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) >=" + Long.valueOf(this.xencabezado[x][1]) + " AND (IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(),  DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) <=" + Long.valueOf(this.xencabezado[x][2]) + ")  GROUP BY g_empresacont.Id_empresa  ORDER BY  f_factura_evento.Fecha_FacturaEvento ASC, f_subgruposervicio.Nbre ASC, f_factura_evento.No_FacturaEvento ASC ";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        ResultSet xrs1 = xct1.traerRs(this.xsql);
                        if (xrs1.next()) {
                            xrs1.first();
                            ConsultasMySQL xct2 = new ConsultasMySQL();
                            this.xsql = "update f_tmp_cartera set " + this.xencabezado[x][0] + "=" + xrs1.getDouble(1) + " where Id='" + xrs.getString(1) + "'";
                            xct2.ejecutarSQL(this.xsql);
                            xct2.cerrarConexionBd();
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarFactura() {
        mCrearTablaDetalleGlosa();
        this.xsql = "SELECT  DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento, '%d-%m-%Y') AS FechaFac , IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento)) NFactura ,f_subgruposervicio.Nbre NServicio , f_liquidacion.TotalServicio , f_liquidacion.TotalDescuento, f_liquidacion.CuotaModeradora,  f_liquidacion.Copago , IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente, f_liquidacion.TotalEps ) AS TotalF , IF(f_factura_evento.FechaEntrega IS NULL, FALSE, TRUE) AS Radicado, f_factura_evento.NRadicado,  IF(f_factura_evento.FechaEntrega IS NULL, '' ,DATE_FORMAT(f_factura_evento.FechaEntrega,'%d/%m/%Y')) AS FechaE,IF(f_factura_evento.FechaRadicado IS NULL, '' ,DATE_FORMAT(f_factura_evento.FechaRadicado,'%d/%m/%Y')) FechaRad,   f_liquidacion.Id, IF(f_factura_evento.ObservacionRad IS NULL, '', f_factura_evento.ObservacionRad) AS CRad , (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)) AS Saldo,f_liquidacion.TPagado, f_liquidacion.TGlosa, f_liquidacion.VGlosaR,  f_liquidacion.VGlosaNR, IF(f_liquidacion.FechaUltimoPago IS NULL, '' ,DATE_FORMAT(f_liquidacion.FechaUltimoPago,'%d/%m/%Y')) AS FechaUP  , IF(   (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) )AS NDias, IFNULL(DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY),'') AS NFecha, f_empresacontxconvenio.Nbre NEmpresa, f_factura_evento.No_CuentaCobro, f_factura_evento.UrlRadicado, `CJuridico`, `g_etapa_proceso`.`Nbre`,'' AS  NIps, f_subgrupo_empresa.`CPuc_Credito_R`, f_subgrupo_empresa.`CPuc_Debito_R`, g_empresacont.`Id_empresa`, f_factura_evento.Id_DocumentoCR    ,`f_subgrupo_empresa`.`CPuc_Debito_G`, `f_subgrupo_empresa`.`CPuc_Credito_G`, IFNULL(`f_subgrupo_empresa`.`CPuc_Debito_GS`,'') AS `CPuc_Debito_GS`, IFNULL(`f_subgrupo_empresa`.`CPuc_Credito_GS`,'') AS `CPuc_Credito_GS`, f_tiporegimen.`Nbre` Regimen, `f_subgrupo_empresa`.`CPuc_Debito_D` , `f_subgrupo_empresa`.`CPuc_Credito_D` \nFROM f_factura_evento \nINNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \nINNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)  \nINNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  \nINNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  \nINNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  \nINNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)  \nINNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) \nINNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = f_tiporegimen.`Id`) \nWHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "' AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0 AND f_liquidacion.`Id`='" + this.xidLiquidacion + "' AND f_factura_evento.EstaArmada=2)  ORDER BY  f_factura_evento.Fecha_FacturaEvento ASC, f_subgruposervicio.Nbre ASC, f_factura_evento.No_FacturaEvento ASC  ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.fila[0] = xrs.getString(1);
                    this.fila[1] = xrs.getString(2);
                    this.fila[2] = xrs.getString(3);
                    this.fila[3] = Double.valueOf(xrs.getDouble(4));
                    this.fila[4] = Double.valueOf(xrs.getDouble(5));
                    this.fila[5] = Double.valueOf(xrs.getDouble(6));
                    this.fila[6] = Double.valueOf(xrs.getDouble(7));
                    this.fila[7] = Double.valueOf(xrs.getDouble(8));
                    this.fila[8] = Boolean.valueOf(xrs.getBoolean(9));
                    this.fila[9] = xrs.getString(10);
                    this.fila[10] = xrs.getString(11);
                    this.fila[11] = xrs.getString(12);
                    this.fila[12] = Long.valueOf(xrs.getLong(13));
                    this.fila[13] = xrs.getString(14);
                    this.fila[14] = Double.valueOf(xrs.getDouble(15));
                    this.fila[15] = Double.valueOf(xrs.getDouble(16));
                    this.fila[16] = Double.valueOf(xrs.getDouble(17));
                    this.fila[17] = Double.valueOf(xrs.getDouble(18));
                    this.fila[18] = Double.valueOf(xrs.getDouble(19));
                    this.fila[19] = xrs.getString(20);
                    this.fila[20] = Long.valueOf(xrs.getLong(21));
                    this.fila[21] = xrs.getString(23);
                    this.fila[22] = Long.valueOf(xrs.getLong(24));
                    this.fila[23] = this.xmt.mTraerUrlBD(xrs.getString(25));
                    this.fila[24] = Long.valueOf(xrs.getLong(26));
                    this.fila[25] = xrs.getString(27);
                    this.fila[26] = xrs.getString("NIps");
                    this.fila[27] = false;
                    this.fila[28] = xrs.getString("CPuc_Credito_R");
                    this.fila[29] = xrs.getString("CPuc_Debito_R");
                    this.fila[30] = xrs.getString("Id_empresa");
                    this.fila[31] = xrs.getString("Id_DocumentoCR");
                    this.fila[32] = xrs.getString("CPuc_Debito_G");
                    this.fila[33] = xrs.getString("CPuc_Credito_G");
                    this.fila[34] = xrs.getString("CPuc_Debito_GS");
                    this.fila[35] = xrs.getString("CPuc_Credito_GS");
                    this.fila[36] = xrs.getString("Regimen");
                    this.fila[37] = xrs.getString("CPuc_Debito_D");
                    this.fila[38] = xrs.getString("CPuc_Credito_D");
                }
            } else {
                this.msg = "Esta Factura No cumple Con Los Requerimientos";
                this.xerror = true;
            }
            if (this.fila[9].toString().isEmpty()) {
                this.JLNRoRadicado.setText("0");
            } else {
                this.JLNRoRadicado.setText(this.fila[9].toString());
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarDetalleGlosas() {
        mCrearTablaDetalleGlosa();
        this.xsql = "SELECT f_factura_glosa.Id, f_factura_glosa.FechaG, f_tipoconcepto_pago.Nbre, f_factura_glosa.NRadicacionG, f_factura_glosa.Valor, f_factura_glosa.ObservacionG, f_factura_glosa.Estado, f_factura_glosa.UrlSoporte ,IF((SELECT SUM( `f_factura_glosa_respuesta`.`ValorG`) FROM `f_factura_glosa_respuesta` WHERE ( `f_factura_glosa_respuesta`.`Id_Factura_glosa` =  f_factura_glosa.Id AND  `f_factura_glosa_respuesta`.`Estado` =1) GROUP BY  `f_factura_glosa_respuesta`.`Id_Factura_glosa`) IS NULL, 0, (SELECT SUM( `f_factura_glosa_respuesta`.`ValorG`) FROM `f_factura_glosa_respuesta` WHERE ( `f_factura_glosa_respuesta`.`Id_Factura_glosa` =  f_factura_glosa.Id AND  `f_factura_glosa_respuesta`.`Estado` =1) GROUP BY  `f_factura_glosa_respuesta`.`Id_Factura_glosa`)) AS `ValorR`, `f_factura_glosa`.`IdDocumentoC`  FROM f_factura_glosa INNER JOIN f_tipoconcepto_pago  ON (f_factura_glosa.Id_ConceptoG = f_tipoconcepto_pago.Id) WHERE (f_factura_glosa.Id_Liquidacion ='" + this.xidLiquidacion + "' and f_factura_glosa.Estado=1) ORDER BY f_factura_glosa.FechaG DESC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 4);
                    this.xmodelo2.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo2.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), xnfila, 6);
                    this.xmodelo2.setValueAt(xrs.getString(8), xnfila, 7);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble("ValorR")), xnfila, 8);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong("IdDocumentoC")), xnfila, 9);
                    this.xvalorg += xrs.getDouble(5);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarHistoricoRespuestaGlosas() {
        mCrearTablaHistoricoRespuestaGlosa();
        this.xsql = "SELECT Id ,date_format(Fecha,'%d-%m-%Y'), DetalleR, ValorG , ValorA, ValorR, EsTraslado, IdDocumentoC  FROM f_factura_glosa_respuesta WHERE (Estado =1 AND Id_Factura_glosa ='" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "') ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo3.addRow(this.xdato);
                    this.xmodelo3.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo3.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo3.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(4)), xnfila, 3);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 4);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo3.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), xnfila, 6);
                    this.xmodelo3.setValueAt(Long.valueOf(xrs.getLong(8)), xnfila, 7);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarSoporteRespuestaGlosas() {
        mCrearTablaSoporteRespuestaGlosa();
        this.xsql = "SELECT `Id`, `Observacion`, `UrlSoporte`, `Estado` FROM `f_factura_glosa_respuesta_soporte` WHERE (`Id_Respuesta` ='" + this.JLBNRespuesta.getText() + "') ORDER BY `Id` DESC;";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo4.addRow(this.xdato);
                    this.xmodelo4.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo4.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo4.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo4.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), xnfila, 3);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevaRadica() {
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
    }

    private void mNuevaGlosa() {
        this.xlleno1 = false;
        this.JDFechaGlosa.setDate(this.xmt.getFechaActual());
        this.JDFechaRGlosa.setDate(this.xmt.getFechaActual());
        this.JCBConceptoG.removeAllItems();
        this.xidconceptog = this.xct.llenarComboyLista("SELECT Id, Nbre, Completo FROM f_tipoconcepto_pago WHERE (Estado =1 AND Tipo=1) ORDER BY Nbre ASC", this.xidconceptog, this.JCBConceptoG, 3);
        this.JCBConceptoG.setSelectedIndex(-1);
        this.JTFFValorGlosado.setValue(new Double(0.0d));
        this.JTAObsGlosa.setText("");
        this.JTFNGlosa.setText("");
        this.xct.cerrarConexionBd();
        this.JTARespuesraGlosa.setText("");
        this.xestadograbadorglosa = false;
        this.JTFFRValorGlosado.setValue(new Double(0.0d));
        this.JTFFRValorAceptado.setValue(new Double(0.0d));
        this.JTFFRValorRecobrado.setValue(new Double(0.0d));
        this.JLBNRespuesta.setText("");
        this.JTFUrlSoporteGS.setText("");
        this.JCHEsTraslado.setSelected(false);
        this.xtraslado = 0;
        this.xIdDocGlosa = 0L;
        this.xIdDocRespuestaGlosa = 0L;
        this.xlleno1 = true;
    }

    private void mNuevoRespuestaSoporte() {
        this.directorio = new File(this.xmt.mRutaSoporte("JPSoporteRespuestaG"));
        this.JTFSoporteRespuesta.setText("");
        this.JTAObservacionSoporte.setText("");
        this.JCHEstadoSoporte.setSelected(true);
        this.xsoporterespuesta = 1;
        this.xgrabadosoporteRespuesta = 0;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JPGlosa$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Double.valueOf(table.getValueAt(row, 14).toString()).doubleValue() == 0.0d) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(new Color(255, 255, 255));
            }
            return cell;
        }
    }

    private void mActualizarLiquidacionRespuestaGlosa() {
        this.xsql = "update f_liquidacion set VGlosaR=VGlosaR+" + this.JTFFRValorRecobrado.getValue() + ", VGlosaNR=VGlosaNR+" + this.JTFFRValorAceptado.getValue() + " where Id= '" + this.xidLiquidacion + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xidLiquidacion + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private Double mActualizarValorGlosado(String xidliquidacion) {
        double xvalor = 0.0d;
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(Valor) FROM f_factura_glosa WHERE (Id_Liquidacion ='" + xidliquidacion + "' AND Estado =1 and Id_PeriodoC<='" + Principal.xclase.getXidperiodoc() + "') GROUP BY Id_Liquidacion ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                xvalor = xrs.getDouble(1);
                this.xsql = "update f_liquidacion set TGlosa='" + xvalor + "' where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xvalor);
    }

    private Double mActualizarValorPagado(String xidliquidacion) {
        double xvalor = 0.0d;
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(Valor) FROM f_factura_pagos WHERE (Id_Liquidacion ='" + xidliquidacion + "' AND Estado =1 and Id_PeriodoC<='" + Principal.xclase.getXidperiodoc() + "') GROUP BY Id_Liquidacion ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                xvalor = xrs.getDouble(1);
                this.xsql = "update f_liquidacion set TPagado='" + xvalor + "' where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            } else {
                ConsultasMySQL xct22 = new ConsultasMySQL();
                this.xsql = "update f_liquidacion set TPagado='0.0' where Id='" + xidliquidacion + "'";
                xct22.ejecutarSQL(this.xsql);
                xct22.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xvalor);
    }

    private void mActualizarDatosL() {
        this.xsql = "update `f_liquidacion` set `f_liquidacion`.`TPagado`=0, `f_liquidacion`.`TGlosa`=0, `f_liquidacion`.`VGlosaNR`=0, `f_liquidacion`.`VGlosaR`=0 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_pagos`.`Id_Liquidacion`, SUM(`f_factura_pagos`.`Valor`) AS `Total`, MAX(`f_factura_pagos`.`FechaAbono`) AS `FechaA` FROM  `f_factura_pagos` INNER JOIN `f_liquidacion`  ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_pagos`.`Estado` =1 AND `f_factura_pagos`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "') GROUP BY `f_factura_pagos`.`Id_Liquidacion`";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`TPagado`=v_f_tmp.Total, `f_liquidacion`.`FechaUltimoPago`=v_f_tmp.FechaA WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa`.`Valor`) AS ValorG  FROM  `f_factura_glosa` INNER JOIN `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion`";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`TGlosa`=v_f_tmp.ValorG  WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa_respuesta`.`ValorA`) AS `VNRecuperable`, SUM(`f_factura_glosa_respuesta`.`ValorR`) AS `VRecuperable` FROM `f_factura_glosa`INNER JOIN`f_liquidacion` ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_factura_glosa_respuesta`  ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1 AND `f_factura_glosa_respuesta`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`VGlosaNR`=v_f_tmp.VNRecuperable, `f_liquidacion`.`VGlosaR`=v_f_tmp.VRecuperable WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
    }

    private boolean mVerificaUltNivel(String xcampo) {
        boolean xOk = false;
        String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0 || "".equals(xrs.getString("UNivel"))) {
                    JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    xOk = true;
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xcampo + " NO Existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }

    private void mCalcularVRespuestaGlosa() {
        this.JTFFRValorRecobrado.setValue(Double.valueOf(Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() - Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue()));
    }

    private void mValidarVGlosado() {
        if (Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue() > Double.valueOf(this.fila[14].toString()).doubleValue() && Double.valueOf(this.fila[14].toString()).doubleValue() < Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor de glosa mayor que el saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValorGlosado.requestFocus();
        }
    }

    private void mGrabar_Glosa() {
        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            this.xsql = "insert into f_factura_glosa(Id_PeriodoC, Id_Liquidacion, Id_ConceptoG, NRadicacionG, FechaG, ObservacionG, Valor, UrlSoporte, IdDocumentoC,UsuarioS) values('" + Principal.xclase.getXidperiodoc() + "','" + this.xidLiquidacion + "','" + this.xidconceptog[this.JCBConceptoG.getSelectedIndex()][0] + "','" + this.JTFNGlosa.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + this.JTAObsGlosa.getText() + "','" + this.JTFFValorGlosado.getValue() + "','" + this.JTFUrlSoporteGS.getText() + "','" + this.xIdDocGlosa + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_liquidacion set TGlosa=TGlosa+" + this.JTFFValorGlosado.getValue() + " where Id='" + this.xidLiquidacion + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "' where Id_Liquidacion='" + this.xidLiquidacion + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mGrabar_RespuestaGlosa() {
        this.xsql = "insert into f_factura_glosa_respuesta (Id_PeriodoC, Id_Factura_glosa, DetalleR, ValorG, ValorA, ValorR, EsTraslado, IdDocumentoC, UsuarioS, Id_Usuario ) values ('" + Principal.xclase.getXidperiodoc() + "','" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "','" + this.JTARespuesraGlosa.getText() + "','" + this.JTFFRValorGlosado.getValue() + "','" + this.JTFFRValorAceptado.getValue() + "','" + this.JTFFRValorRecobrado.getValue() + "','" + this.xtraslado + "','" + this.xIdDocRespuestaGlosa + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
        this.JLBNRespuesta.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xidLiquidacion + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xestadograbadorglosa = true;
    }

    private void mConsecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mGenerarDocContableGlosa() {
        this.xIdDocGlosa = 0L;
        mConsecutivo();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','GLOSA FACTURA DE VENTA N° " + this.fila[1] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xIdDocGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.fila[32] + "','0','" + this.fila[30] + "','0','" + this.fila[1] + "','" + this.JTFFValorGlosado.getValue() + "','0','GLOSA FACTURA DE VENTA N° " + this.fila[1] + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.fila[33] + "','1','" + this.fila[30] + "','0','" + this.fila[1] + "','0','" + this.JTFFValorGlosado.getValue() + "','GLOSA FACTURA DE VENTA N° " + this.fila[1] + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDocContableRespuestaGlosa() {
        this.xIdDocRespuestaGlosa = 0L;
        mConsecutivo();
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() == 0.0d) {
            this.xCuenta = new String[1][3];
            this.xCuenta[0][0] = this.fila[32].toString();
            this.xCuenta[0][1] = this.fila[33].toString();
            this.xCuenta[0][2] = this.JTFFRValorAceptado.getValue().toString();
        } else if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() >= 0.0d) {
            this.xCuenta = new String[2][3];
            this.xCuenta[0][0] = this.fila[32].toString();
            this.xCuenta[0][1] = this.fila[33].toString();
            this.xCuenta[0][2] = this.JTFFRValorAceptado.getValue().toString();
            this.xCuenta[1][0] = this.fila[35].toString();
            this.xCuenta[1][1] = this.fila[34].toString();
            this.xCuenta[1][2] = this.JTFFRValorRecobrado.getValue().toString();
        } else if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() == 0.0d && Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() > 0.0d) {
            this.xCuenta = new String[1][3];
            this.xCuenta[0][0] = this.fila[35].toString();
            this.xCuenta[0][1] = this.fila[34].toString();
            this.xCuenta[0][2] = this.JTFFRValorRecobrado.getValue().toString();
        }
        if (this.xCuenta.length != 0) {
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.fila[1] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xIdDocRespuestaGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
            this.xct.cerrarConexionBd();
            for (int x = 0; x < this.xCuenta.length; x++) {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.xCuenta[x][0] + "','0','" + this.fila[30] + "','0','" + this.fila[1] + "','" + this.xCuenta[x][2] + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.fila[1] + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.xCuenta[x][1] + "','1','" + this.fila[30] + "','0','" + this.fila[1] + "','0','" + this.xCuenta[x][2] + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.fila[1] + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Error Al Generar Documento Contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private boolean mValidarValoresRespuesta() {
        boolean xvalidado = true;
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor Aceptado no puede ser mayor al Valor Glosado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            xvalidado = false;
        } else if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor a Recobrar no puede ser mayor al Valor Glosado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            xvalidado = false;
        }
        return xvalidado;
    }

    /* JADX WARN: Type inference failed for: r3v143, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v173, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatosU = new JTabbedPane();
        this.JPIDatosGlosa = new JPanel();
        this.JDFechaGlosa = new JDateChooser();
        this.JTFNGlosa = new JTextField();
        this.JCBConceptoG = new JComboBox();
        this.JSPObsGlosa = new JScrollPane();
        this.JTAObsGlosa = new JTextPane();
        this.JTFFValorGlosado = new JFormattedTextField();
        this.JTFUrlSoporteGS = new JTextField();
        this.JLNRoRadicado = new JLabel();
        this.JPI_InformacionContable = new JPanel();
        this.JCH_AplicaMC = new JCheckBox();
        this.JCBTipoC = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.JPI_Utilizades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTBDetalleGlosa = new JTabbedPane();
        this.JSPDetalleG = new JScrollPane();
        this.JTDetalleG = new JTable();
        this.JPIRespuesta = new JPanel();
        this.JTPDatosRespuesta = new JTabbedPane();
        this.JPIDRespuesta = new JPanel();
        this.JSPRespuesraGlosa = new JScrollPane();
        this.JTARespuesraGlosa = new JTextPane();
        this.JTFFRValorGlosado = new JFormattedTextField();
        this.JTFFRValorAceptado = new JFormattedTextField();
        this.JTFFRValorRecobrado = new JFormattedTextField();
        this.JDFechaRGlosa = new JDateChooser();
        this.JLBNRespuesta = new JLabel();
        this.JBTRespImprimir = new JButton();
        this.JCHEsTraslado = new JCheckBox();
        this.JPIDSoportes = new JPanel();
        this.JSPRespuestaSoporte = new JScrollPane();
        this.JTRespuestaSoporte = new JTable();
        this.JSPObservacionSoporte = new JScrollPane();
        this.JTAObservacionSoporte = new JTextArea();
        this.JTFSoporteRespuesta = new JTextField();
        this.JBTAdicionarSoporteR = new JButton();
        this.JCHEstadoSoporte = new JCheckBox();
        this.JSPHistoricoResp = new JScrollPane();
        this.JTHistoricoResp = new JTable();
        setName("xjpglosa");
        setPreferredSize(new Dimension(850, 514));
        this.JTPDatosU.setForeground(Color.red);
        this.JTPDatosU.setFont(new Font("Arial", 1, 14));
        this.JDFechaGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaGlosa.setDateFormatString("dd/MM/yyyy");
        this.JDFechaGlosa.setFont(new Font("Arial", 1, 12));
        this.JTFNGlosa.setFont(new Font("Arial", 1, 12));
        this.JTFNGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoG.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoG.addItemListener(new ItemListener() { // from class: Armado.JPGlosa.4
            public void itemStateChanged(ItemEvent evt) {
                JPGlosa.this.JCBConceptoGItemStateChanged(evt);
            }
        });
        this.JSPObsGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsGlosa.setFont(new Font("Arial", 1, 12));
        this.JSPObsGlosa.setViewportView(this.JTAObsGlosa);
        this.JTFFValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorGlosado.setHorizontalAlignment(4);
        this.JTFFValorGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFValorGlosado.setValue(new Long(0L));
        this.JTFFValorGlosado.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.5
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JTFFValorGlosadoActionPerformed(evt);
            }
        });
        this.JTFFValorGlosado.addFocusListener(new FocusAdapter() { // from class: Armado.JPGlosa.6
            public void focusLost(FocusEvent evt) {
                JPGlosa.this.JTFFValorGlosadoFocusLost(evt);
            }
        });
        this.JTFFValorGlosado.addKeyListener(new KeyAdapter() { // from class: Armado.JPGlosa.7
            public void keyPressed(KeyEvent evt) {
                JPGlosa.this.JTFFValorGlosadoKeyPressed(evt);
            }
        });
        this.JTFUrlSoporteGS.setFont(new Font("Arial", 1, 12));
        this.JTFUrlSoporteGS.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUrlSoporteGS.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.8
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTFUrlSoporteGSMouseClicked(evt);
            }
        });
        this.JLNRoRadicado.setFont(new Font("Arial", 1, 12));
        this.JLNRoRadicado.setForeground(Color.blue);
        this.JLNRoRadicado.setHorizontalAlignment(0);
        this.JLNRoRadicado.setText("0");
        this.JLNRoRadicado.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Radicado", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIDatosGlosaLayout = new GroupLayout(this.JPIDatosGlosa);
        this.JPIDatosGlosa.setLayout(JPIDatosGlosaLayout);
        JPIDatosGlosaLayout.setHorizontalGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addComponent(this.JDFechaGlosa, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNGlosa, -2, 125, -2)).addComponent(this.JTFUrlSoporteGS, -2, 250, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBConceptoG, 0, 401, 32767).addComponent(this.JSPObsGlosa)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorGlosado, -1, 127, 32767).addComponent(this.JLNRoRadicado, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPIDatosGlosaLayout.setVerticalGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNGlosa, -1, 52, 32767).addComponent(this.JCBConceptoG, -2, 50, -2).addComponent(this.JTFFValorGlosado)).addComponent(this.JDFechaGlosa, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(11, 11, 11).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsGlosa, GroupLayout.Alignment.TRAILING, -1, 49, 32767).addComponent(this.JTFUrlSoporteGS, GroupLayout.Alignment.TRAILING).addComponent(this.JLNRoRadicado, -1, -1, 32767)).addContainerGap()));
        this.JTPDatosU.addTab("DATOS GLOSA", this.JPIDatosGlosa);
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica?");
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_InformacionContableLayout = new GroupLayout(this.JPI_InformacionContable);
        this.JPI_InformacionContable.setLayout(JPI_InformacionContableLayout);
        JPI_InformacionContableLayout.setHorizontalGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaC, -2, 112, -2).addGap(14, 14, 14).addComponent(this.JCH_AplicaMC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoC, -2, 438, -2).addContainerGap(162, 32767)));
        JPI_InformacionContableLayout.setVerticalGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addGap(43, 43, 43).addComponent(this.JCH_AplicaMC)).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JDFFechaC, -2, 50, -2)))).addGap(10, 10, 10)));
        this.JTPDatosU.addTab("DATOS CONTABLES", this.JPI_InformacionContable);
        this.JPI_Utilizades.setForeground(Color.red);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.9
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.10
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilizadesLayout = new GroupLayout(this.JPI_Utilizades);
        this.JPI_Utilizades.setLayout(JPI_UtilizadesLayout);
        JPI_UtilizadesLayout.setHorizontalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilizadesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 645, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 158, -2).addGap(209, 209, 209)));
        JPI_UtilizadesLayout.setVerticalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilizadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(10, 10, 10)));
        this.JTPDatosU.addTab("UTILIDADES", this.JPI_Utilizades);
        this.JTBDetalleGlosa.setForeground(new Color(0, 103, 0));
        this.JTBDetalleGlosa.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleG.setFont(new Font("Arial", 1, 12));
        this.JTDetalleG.setFont(new Font("Arial", 1, 12));
        this.JTDetalleG.setForeground(new Color(0, 0, 204));
        this.JTDetalleG.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleG.setEditingColumn(1);
        this.JTDetalleG.setEditingRow(1);
        this.JTDetalleG.setRowHeight(25);
        this.JTDetalleG.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleG.setSelectionForeground(Color.red);
        this.JTDetalleG.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.11
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTDetalleGMouseClicked(evt);
            }
        });
        this.JSPDetalleG.setViewportView(this.JTDetalleG);
        this.JTBDetalleGlosa.addTab("DETALLE", this.JSPDetalleG);
        this.JTPDatosRespuesta.setForeground(Color.red);
        this.JTPDatosRespuesta.setFont(new Font("Arial", 1, 14));
        this.JSPRespuesraGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTARespuesraGlosa.setFont(new Font("Arial", 1, 12));
        this.JSPRespuesraGlosa.setViewportView(this.JTARespuesraGlosa);
        this.JTFFRValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Glosado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFRValorGlosado.setHorizontalAlignment(4);
        this.JTFFRValorGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorGlosado.setValue(new Long(0L));
        this.JTFFRValorGlosado.addKeyListener(new KeyAdapter() { // from class: Armado.JPGlosa.12
            public void keyPressed(KeyEvent evt) {
                JPGlosa.this.JTFFRValorGlosadoKeyPressed(evt);
            }
        });
        this.JTFFRValorAceptado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Aceptado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorAceptado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFRValorAceptado.setHorizontalAlignment(4);
        this.JTFFRValorAceptado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorAceptado.setValue(new Long(0L));
        this.JTFFRValorAceptado.addFocusListener(new FocusAdapter() { // from class: Armado.JPGlosa.13
            public void focusLost(FocusEvent evt) {
                JPGlosa.this.JTFFRValorAceptadoFocusLost(evt);
            }
        });
        this.JTFFRValorAceptado.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.14
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JTFFRValorAceptadoActionPerformed(evt);
            }
        });
        this.JTFFRValorAceptado.addKeyListener(new KeyAdapter() { // from class: Armado.JPGlosa.15
            public void keyPressed(KeyEvent evt) {
                JPGlosa.this.JTFFRValorAceptadoKeyPressed(evt);
            }
        });
        this.JTFFRValorRecobrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor a Recobrar", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorRecobrado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFRValorRecobrado.setHorizontalAlignment(4);
        this.JTFFRValorRecobrado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorRecobrado.setValue(new Long(0L));
        this.JDFechaRGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRGlosa.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRGlosa.setEnabled(false);
        this.JDFechaRGlosa.setFont(new Font("Arial", 1, 12));
        this.JLBNRespuesta.setFont(new Font("Arial", 1, 18));
        this.JLBNRespuesta.setHorizontalAlignment(0);
        this.JLBNRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTRespImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTRespImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTRespImprimir.setText("Imprimir");
        this.JBTRespImprimir.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.16
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JBTRespImprimirActionPerformed(evt);
            }
        });
        this.JCHEsTraslado.setFont(new Font("Arial", 1, 12));
        this.JCHEsTraslado.setText("Es Traslado?");
        this.JCHEsTraslado.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.17
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JCHEsTrasladoActionPerformed(evt);
            }
        });
        GroupLayout JPIDRespuestaLayout = new GroupLayout(this.JPIDRespuesta);
        this.JPIDRespuesta.setLayout(JPIDRespuestaLayout);
        JPIDRespuestaLayout.setHorizontalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRespuesraGlosa, -2, 800, -2).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JTFFRValorGlosado, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFRValorAceptado, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFRValorRecobrado, -1, 161, 32767)).addComponent(this.JBTRespImprimir, -1, -1, 32767)).addGap(10, 10, 10).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsTraslado).addGroup(JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JDFechaRGlosa, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRespuesta, -2, 119, -2))))).addGap(62, 62, 62)));
        JPIDRespuestaLayout.setVerticalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPRespuesraGlosa, -1, 130, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFRValorGlosado, -2, -1, -2).addComponent(this.JTFFRValorAceptado, -2, -1, -2).addComponent(this.JTFFRValorRecobrado, -2, -1, -2)).addComponent(this.JDFechaRGlosa, -2, -1, -2)).addComponent(this.JLBNRespuesta, -2, 43, -2)).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCHEsTraslado)).addGroup(JPIDRespuestaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRespImprimir, -2, 56, -2))).addContainerGap()));
        this.JTPDatosRespuesta.addTab("RESPUESTA", this.JPIDRespuesta);
        this.JSPRespuestaSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRespuestaSoporte.setSelectionBackground(Color.white);
        this.JTRespuestaSoporte.setSelectionForeground(Color.red);
        this.JTRespuestaSoporte.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.18
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTRespuestaSoporteMouseClicked(evt);
            }
        });
        this.JSPRespuestaSoporte.setViewportView(this.JTRespuestaSoporte);
        this.JSPObservacionSoporte.setViewportBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionSoporte.setColumns(20);
        this.JTAObservacionSoporte.setRows(5);
        this.JSPObservacionSoporte.setViewportView(this.JTAObservacionSoporte);
        this.JTFSoporteRespuesta.setFont(new Font("Arial", 1, 12));
        this.JTFSoporteRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSoporteRespuesta.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.19
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTFSoporteRespuestaMouseClicked(evt);
            }
        });
        this.JBTAdicionarSoporteR.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarSoporteR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarSoporteR.setText("Grabar");
        this.JBTAdicionarSoporteR.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.20
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JBTAdicionarSoporteRActionPerformed(evt);
            }
        });
        this.JCHEstadoSoporte.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSoporte.setSelected(true);
        this.JCHEstadoSoporte.setText("Estado");
        this.JCHEstadoSoporte.addActionListener(new ActionListener() { // from class: Armado.JPGlosa.21
            public void actionPerformed(ActionEvent evt) {
                JPGlosa.this.JCHEstadoSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPIDSoportesLayout = new GroupLayout(this.JPIDSoportes);
        this.JPIDSoportes.setLayout(JPIDSoportesLayout);
        JPIDSoportesLayout.setHorizontalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacionSoporte).addGroup(JPIDSoportesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPRespuestaSoporte, -2, 800, -2).addGroup(JPIDSoportesLayout.createSequentialGroup().addComponent(this.JTFSoporteRespuesta, -2, 583, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarSoporteR, -2, 142, -2))))).addGap(59, 59, 59)));
        JPIDSoportesLayout.setVerticalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFSoporteRespuesta, -2, 50, -2).addComponent(this.JBTAdicionarSoporteR, -2, 53, -2).addComponent(this.JCHEstadoSoporte)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacionSoporte, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespuestaSoporte, -1, 100, 32767).addContainerGap()));
        this.JTPDatosRespuesta.addTab("SOPORTES", this.JPIDSoportes);
        this.JSPHistoricoResp.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoResp.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoResp.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoResp.setEditingColumn(1);
        this.JTHistoricoResp.setEditingRow(1);
        this.JTHistoricoResp.setRowHeight(25);
        this.JTHistoricoResp.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoResp.setSelectionForeground(Color.red);
        this.JTHistoricoResp.addMouseListener(new MouseAdapter() { // from class: Armado.JPGlosa.22
            public void mouseClicked(MouseEvent evt) {
                JPGlosa.this.JTHistoricoRespMouseClicked(evt);
            }
        });
        this.JSPHistoricoResp.setViewportView(this.JTHistoricoResp);
        this.JTPDatosRespuesta.addTab("HISTÓRICO", this.JSPHistoricoResp);
        GroupLayout JPIRespuestaLayout = new GroupLayout(this.JPIRespuesta);
        this.JPIRespuesta.setLayout(JPIRespuestaLayout);
        JPIRespuestaLayout.setHorizontalGroup(JPIRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRespuestaLayout.createSequentialGroup().addComponent(this.JTPDatosRespuesta, -2, 816, 32767).addContainerGap()));
        JPIRespuestaLayout.setVerticalGroup(JPIRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRespuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosRespuesta, -1, 357, 32767).addContainerGap()));
        this.JTBDetalleGlosa.addTab("RESPUESTA", this.JPIRespuesta);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosU, -2, 822, -2).addComponent(this.JTBDetalleGlosa, -2, 824, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosU, -2, -1, -2).addGap(0, 0, 0).addComponent(this.JTBDetalleGlosa, -1, 357, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoGItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoActionPerformed(ActionEvent evt) {
        this.JTFFValorGlosado.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoFocusLost(FocusEvent evt) {
        mValidarVGlosado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 18) {
            this.JTFFValorGlosado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFUrlSoporteGSMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\Soporte Glosas GP\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFUrlSoporteGS.setText(this.xfile.getAbsolutePath());
                this.JTFUrlSoporteGS.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorGlosadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFRValorAceptado.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoFocusLost(FocusEvent evt) {
        mCalcularVRespuestaGlosa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoActionPerformed(ActionEvent evt) {
        mCalcularVRespuestaGlosa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFRValorAceptado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRespImprimirActionPerformed(ActionEvent evt) {
        if (!this.JLBNRespuesta.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRespuesta.getText();
            mparametros[1][0] = "usuarioSiste";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa", mparametros);
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa_2", mparametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa_1", mparametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsTrasladoActionPerformed(ActionEvent evt) {
        if (this.JCHEsTraslado.isSelected()) {
            this.xtraslado = 1;
        } else {
            this.xtraslado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRespuestaSoporteMouseClicked(MouseEvent evt) {
        if (this.JTRespuestaSoporte.getSelectedRow() != -1) {
            this.JTAObservacionSoporte.setText(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 1).toString());
            this.JTFSoporteRespuesta.setText(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstadoSoporte.setSelected(true);
                this.xsoporterespuesta = 1;
            } else {
                this.JCHEstadoSoporte.setSelected(false);
                this.xsoporterespuesta = 0;
            }
            this.xgrabadosoporteRespuesta = 1;
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 2).toString();
                this.xmt.mostrarPdf(this.directorio + "\\" + rutaa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSoporteRespuestaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFSoporteRespuesta.setText(this.xfile.getAbsolutePath());
                this.JTFSoporteRespuesta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarSoporteRActionPerformed(ActionEvent evt) {
        if (!this.xerror) {
            if (!this.JLBNRespuesta.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.xgrabadosoporteRespuesta == 1) {
                        this.xct.ejecutarSQL("UPDATE `f_factura_glosa_respuesta_soporte`\nSET\n  `Observacion` = '" + this.JTAObservacionSoporte.getText() + "',\n  `Estado` = '" + this.xsoporterespuesta + "',\n  `Id_UsuarioR` = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\nWHERE `Id` = '" + this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 0) + "';");
                        this.xct.cerrarConexionBd();
                    } else {
                        File directorio = new File(this.xmt.mRutaSoporte("JPSoporteRespuestaG"));
                        String xidDoc = this.xct.ejecutarSQLId("INSERT INTO `f_factura_glosa_respuesta_soporte` (`Id_Respuesta`,`Observacion`,`Estado`,`Id_UsuarioR`)\nVALUES('" + this.JLBNRespuesta.getText() + "','" + this.JTAObservacionSoporte.getText() + "','" + this.xsoporterespuesta + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "');");
                        String adjunto = xidDoc + "_" + this.JLBNRespuesta.getText() + ".pdf";
                        String sql = "UPDATE f_factura_glosa_respuesta_soporte set UrlSoporte='" + this.xmt.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        File f1 = new File(this.JTFSoporteRespuesta.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mNuevoRespuestaSoporte();
                    }
                    mBucarSoporteRespuestaGlosas();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Respuesta no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTARespuesraGlosa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, this.msg, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSoporteActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoSoporte.isSelected()) {
            this.xsoporterespuesta = 1;
        } else {
            this.xsoporterespuesta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoRespMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoResp.getSelectedRow() != -1) {
            this.JLBNRespuesta.setText(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 0).toString());
            this.JDFechaRGlosa.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 1).toString()));
            this.JTARespuesraGlosa.setText(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 2).toString());
            this.JTFFRValorGlosado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 3).toString()));
            this.JTFFRValorAceptado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 4).toString()));
            this.JTFFRValorRecobrado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 5).toString()));
            this.JCHEsTraslado.setSelected(Boolean.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEsTraslado.isSelected()) {
                this.xtraslado = 1;
            } else {
                this.xtraslado = 0;
            }
            mBucarSoporteRespuestaGlosas();
            this.JTPDatosRespuesta.setSelectedIndex(0);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleG.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.JTBDetalleGlosa.getSelectedIndex() == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleG, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "GLOSAS");
                        return;
                    } else {
                        if (this.JTPDatosRespuesta.getSelectedIndex() == 2) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTHistoricoResp, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "RESPUESTAS GLOSA");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleGMouseClicked(MouseEvent evt) {
        mBucarHistoricoRespuestaGlosas();
        if (this.JTDetalleG.getSelectedRow() != -1 && this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 7).equals("")) {
            if (this.xllamador.equals("Respuesta")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea generar respuesta?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.JTFFRValorGlosado.setValue(Double.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 4).toString()));
                    this.JTBDetalleGlosa.setSelectedIndex(1);
                    this.JTARespuesraGlosa.requestFocus();
                    this.xIdDocRespuestaGlosa = 0L;
                    return;
                }
                return;
            }
            return;
        }
        Object[] botones = {"Generar Respuesta", "Visualizar Soporte", "Cerrar"};
        int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "CONFIRMAR", 0, 3, (Icon) null, botones, "Cerrar");
        if (n == 0) {
            if (this.xllamador.equals("Respuesta")) {
                this.JTFFRValorGlosado.setValue(Double.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 4).toString()));
                this.JTBDetalleGlosa.setSelectedIndex(1);
                this.JTARespuesraGlosa.requestFocus();
                this.xIdDocRespuestaGlosa = 0L;
                return;
            }
            return;
        }
        if (n == 1) {
            this.xmt.mostrarPdf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 7).toString());
        }
    }
}
