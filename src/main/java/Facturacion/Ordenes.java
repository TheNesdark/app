package Facturacion;

import Acceso.Principal;
import Caja.JP_ReciboCaja;
import Laboratorio.JD_TipoRechazo;
import Utilidades.CargarCombosVarios;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.genoma.plus.dao.facturacion.SalidaInventarioParaFacturacionDAO;
import com.genoma.plus.dao.impl.facturacion.SalidaInventarioParaFacturacionDAOImpl;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Ordenes.class */
public class Ordenes extends JPanel {
    public DefaultTableModel modelo;
    private DefaultTableModel modcombos;
    private DefaultTableModel modelocita1;
    private DefaultTableModel modelocita2;
    private DefaultTableModel modelototales;
    private DefaultTableModel modelordmed;
    private DefaultTableModel modelon2;
    private DefaultTableModel modelon2t;
    private DefaultTableModel xmodelotratamiento;
    private String sql;
    private String idEmpresaCont;
    private String idPlanEmpresaCont;
    private String cualValor;
    private String filtroProcxEmp;
    private String idServicio;
    private String tipoServicio;
    private int filaGridDetalle;
    private int filaGridDetalle1;
    private int filaGridTotales;
    private int filaGridTotales1;
    public Facturac frmFacturac;
    public Facturac1 frmFacturac1;
    private ResultSet rs;
    private Object[] xdato;
    public JP_ReciboCaja xJp_RCaja;
    private String xIdFinalidad;
    private String idOrdenItemsGIIS;
    private Long idHOrden;
    private List<GServicioGrupoEntity> listGrupoEntitys;
    private List<GServicioRipsEntity> ListripsEntitys;
    private SalidaInventarioParaFacturacionDAO inventarioParaFacturacionDAO;
    private String idIngreso;
    public JTabbedPane DetalleFacturacion;
    private ButtonGroup JBG_FiltroOrdenes;
    private JButton JBTGrabar;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBSevicioRips;
    private JCheckBox JCH_VisualizarAnt;
    public JDateChooser JDC_FechaCitas;
    private JScrollPane JDPTratamientos;
    public JLabel JLBIngreso;
    private JPanel JPIDNiveles;
    private JPanel JPINivel2;
    private JPanel JPINivel3;
    private JPanel JPI_FiltroOrdenes;
    private JPanel JPI_Recibo_Caja;
    private JPanel JPTratamientos;
    private JRadioButton JRB_FAno;
    private JRadioButton JRB_FTodas;
    private JScrollPane JSPDatosTabla;
    private JScrollPane JSPDatosTabla1;
    private JSpinner JSPPImpuesto;
    private JScrollPane JSPTotales;
    private JScrollPane JSPTotales1;
    private JFormattedTextField JTFFDescuento;
    private JFormattedTextField JTFF_VTotalImpuesto;
    private JTabbedPane JTPDatos;
    private JTable JTTratamientos;
    private JYearChooser JYC_FAno;
    private JButton btnAdicionar;
    private JCheckBox btnDescuento;
    public JTableComboBox cboCentroCosto;
    public JTableComboBox cboFinProcedimiento;
    public JTableComboBox cboProcedSuministro;
    public JTableComboBox cboServicio;
    private JTable gridCita1;
    private JTable gridCita2;
    public JTable gridDetalle;
    private JTable gridDetalle1;
    private JTable gridOrdMed;
    public JTable gridTotales;
    public JTable gridTotales1;
    private JScrollPane panelCita1;
    private JScrollPane panelCita2;
    private JScrollPane panelOrdMed;
    private JPanel pesCitas;
    private JPanel pesOrdenesM;
    private JPanel pesServicios;
    public JFormattedTextField txtCantidad;
    public JTextField txtCodigo;
    public JDateChooser txtFecha;
    private JFormattedTextField txtVrTotal;
    private JFormattedTextField txtVrUnitario;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String idCita = "null";
    private String xidorden = "0";
    private String xRedondeo = "0";
    private String xId_MetodoFac = "0";
    private int validarDatos = 0;
    private int xEsTipoCita = 0;
    private Object[] datos = {"", "", "", "", "", "", "", "", "", new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), ""};
    private Object[] datosTotales = {"", "", "", "", "", new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), "", ""};
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private double xvalor = 0.0d;
    private double valorImpuesto = 0.0d;
    private int esPrioritario = 0;
    private String idOrdenItems = "";
    private String xactualizarestadopro = "0";
    private String xidclasecita = "0";

    public Ordenes(Facturac frmF, int llamador) {
        this.idOrdenItemsGIIS = "";
        initComponents();
        this.frmFacturac = frmF;
        springStart();
        this.idHOrden = new Long(0L);
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.JDC_FechaCitas.setDate(this.metodos.getFechaActual());
        this.JTPDatos.remove(1);
        limpiar();
        CrearGridDetalle();
        CrearGridDetalle1();
        CrearGridTotales();
        CrearGridTotales1();
        if (frmF.cajaAbierta == 0) {
            mCargar_Panel_ReciboCaja();
        } else {
            this.DetalleFacturacion.setEnabledAt(4, false);
        }
        if (llamador == 1 && this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex() > -1) {
            this.idEmpresaCont = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString();
            this.cualValor = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getCualValor();
            this.idPlanEmpresaCont = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getidTipoPlan();
            this.filtroProcxEmp = String.valueOf(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getFiltroProcxEmp());
            cargarCboservicio(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString());
        }
        mSeleccionar_Datos();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.DetalleFacturacion.remove(4);
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            this.idOrdenItemsGIIS = "0";
        }
    }

    public Ordenes(Facturac1 frmF, int llamador) {
        this.idOrdenItemsGIIS = "";
        initComponents();
        this.frmFacturac1 = frmF;
        springStart();
        this.idHOrden = new Long(0L);
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.JDC_FechaCitas.setDate(this.metodos.getFechaActual());
        this.JTPDatos.remove(1);
        limpiar();
        CrearGridDetalle();
        CrearGridDetalle1();
        CrearGridTotales();
        CrearGridTotales1();
        if (frmF.cajaAbierta == 0) {
            mCargar_Panel_ReciboCaja();
        } else {
            this.DetalleFacturacion.setEnabledAt(4, false);
        }
        if (llamador == 1 && this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex() > -1) {
            this.idEmpresaCont = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString();
            this.cualValor = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getCualValor();
            this.idPlanEmpresaCont = this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getidTipoPlan();
            this.filtroProcxEmp = String.valueOf(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getFiltroProcxEmp());
            cargarCboservicio(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString());
        }
        mSeleccionar_Datos();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.DetalleFacturacion.remove(4);
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            this.idOrdenItemsGIIS = "0";
        }
    }

    private void springStart() {
        this.inventarioParaFacturacionDAO = (SalidaInventarioParaFacturacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("salidaInventarioParaFacturacionDAOImpl");
    }

    public void mSeleccionar_Datos() {
    }

    private void mCargar_Panel_ReciboCaja() {
        this.xJp_RCaja = new JP_ReciboCaja(this.frmFacturac);
        this.xJp_RCaja.setVisible(true);
        this.JPI_Recibo_Caja.setVisible(false);
        this.xJp_RCaja.setBounds(1, 1, 884, 400);
        this.JPI_Recibo_Caja.add(this.xJp_RCaja);
        this.JPI_Recibo_Caja.setVisible(true);
    }

    public int getEsPrioritario() {
        return this.esPrioritario;
    }

    public void setEsPrioritario(int esPrioritario) {
        this.esPrioritario = esPrioritario;
    }

    public void setidEmpresaCont(String id) {
        this.idEmpresaCont = id;
    }

    public String getidEmpresaCont() {
        return this.idEmpresaCont;
    }

    public void setidPlanEmpresaCont(String id) {
        this.idPlanEmpresaCont = id;
    }

    public String getidPlanEmpresaCont() {
        return this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getidTipoPlan();
    }

    public void setCualValor(String Valor) {
        this.cualValor = Valor;
    }

    public String getXidorden() {
        return this.xidorden;
    }

    public void setXidorden(String xidorden) {
        this.xidorden = xidorden;
    }

    public String getCualValor() {
        return this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getCualValor();
    }

    public void setFiltroProcxEmp(String Filtro) {
        this.filtroProcxEmp = Filtro;
    }

    public String getFiltroProcxEmp() {
        return this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getFiltroProcxEmp();
    }

    public void setIdServicio(String Id) {
        this.idServicio = Id;
    }

    public String getIdServicio() {
        return this.idServicio;
    }

    public void setTipoServicio(String Tipo) {
        this.tipoServicio = Tipo;
    }

    public String getTipoServicio() {
        return this.tipoServicio;
    }

    public String getXidclasecita() {
        return this.xidclasecita;
    }

    public void setXidclasecita(String xidclasecita) {
        this.xidclasecita = xidclasecita;
    }

    public int getxEsTipoCita() {
        return this.xEsTipoCita;
    }

    public void setxEsTipoCita(int xEsTipoCita) {
        this.xEsTipoCita = xEsTipoCita;
    }

    public String getxId_MetodoFac() {
        return this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getMetodoFact();
    }

    public void setxId_MetodoFac(String xId_MetodoFac) {
        this.xId_MetodoFac = xId_MetodoFac;
    }

    public void actualizar_citas() {
        if (getxEsTipoCita() == 0) {
            this.sql = "UPDATE c_citas set Asistida=1, Id_ingreso=" + this.frmFacturac.frmIngreso.getIdIngreso() + " WHERE id=" + getIdCita() + " and Id_ingreso=0";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE c_citas set Asistida=1 , Id_ingresoReal = " + this.frmFacturac.frmIngreso.getIdIngreso() + " WHERE id=" + getIdCita() + "";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            return;
        }
        this.sql = "Update c_citasnp set  EstaFacturada = 1, Id_ingreso='" + this.frmFacturac.frmIngreso.getIdIngreso() + "' where id='" + getIdCita() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void actualizarUnicoRegistro(int PosServicio, int tipoOperacion, int NoFilaDetalle) {
        int NoItem = Integer.parseInt(this.modelototales.getValueAt(PosServicio, 5).toString());
        double VrServicio = Double.valueOf(this.modelototales.getValueAt(PosServicio, 6).toString()).doubleValue();
        double VrDescuento = Double.valueOf(this.modelototales.getValueAt(PosServicio, 7).toString()).doubleValue();
        double VrPlan = Double.valueOf(this.modelototales.getValueAt(PosServicio, 8).toString()).doubleValue();
        double VrNoPlan = Double.valueOf(this.modelototales.getValueAt(PosServicio, 9).toString()).doubleValue();
        if (tipoOperacion == 1) {
            this.modelototales.setValueAt(Integer.valueOf(NoItem + 1), PosServicio, 5);
            this.modelototales.setValueAt(Double.valueOf(VrServicio + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFDescuento.getValue().toString()).doubleValue()), PosServicio, 6);
            this.modelototales.setValueAt(Double.valueOf(VrDescuento + Double.valueOf(this.JTFFDescuento.getValue().toString()).doubleValue()), PosServicio, 7);
            if (getTipoServicio().equals("Es_Proc")) {
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                    if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString()) && !getidPlanEmpresaCont().equals("4")) {
                        this.modelototales.setValueAt(Double.valueOf(VrPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 8);
                        return;
                    } else {
                        this.modelototales.setValueAt(Double.valueOf(VrNoPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 9);
                        return;
                    }
                }
                if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString())) {
                    this.modelototales.setValueAt(Double.valueOf(VrPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 8);
                    return;
                } else {
                    this.modelototales.setValueAt(Double.valueOf(VrNoPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 9);
                    return;
                }
            }
            if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7).toString())) {
                this.modelototales.setValueAt(Double.valueOf(VrPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 8);
                return;
            } else {
                this.modelototales.setValueAt(Double.valueOf(VrNoPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 9);
                return;
            }
        }
        if (Integer.parseInt(this.modelototales.getValueAt(PosServicio, 5).toString()) == 1) {
            this.modelototales.removeRow(PosServicio);
            this.filaGridTotales--;
            return;
        }
        this.modelototales.setValueAt(Integer.valueOf(NoItem - 1), PosServicio, 5);
        this.modelototales.setValueAt(Double.valueOf(VrServicio - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 6);
        this.modelototales.setValueAt(Double.valueOf(VrDescuento - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 12).toString()).doubleValue()), PosServicio, 7);
        if (getidPlanEmpresaCont().equals(this.modelo.getValueAt(NoFilaDetalle, 14).toString())) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                if (!getidPlanEmpresaCont().equals("4")) {
                    this.modelototales.setValueAt(Double.valueOf(VrPlan - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 8);
                    return;
                } else {
                    this.modelototales.setValueAt(Double.valueOf(VrNoPlan - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 9);
                    return;
                }
            }
            this.modelototales.setValueAt(Double.valueOf(VrPlan - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 8);
            return;
        }
        this.modelototales.setValueAt(Double.valueOf(VrNoPlan - Double.valueOf(this.modelo.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 9);
    }

    private void actualizarUnicoRegistro1(int PosServicio, int tipoOperacion, int NoFilaDetalle) {
        int NoItem = Integer.parseInt(this.modelon2t.getValueAt(PosServicio, 5).toString());
        double VrServicio = Double.valueOf(this.modelon2t.getValueAt(PosServicio, 6).toString()).doubleValue();
        double VrDescuento = Double.valueOf(this.modelon2t.getValueAt(PosServicio, 7).toString()).doubleValue();
        double VrPlan = Double.valueOf(this.modelon2t.getValueAt(PosServicio, 8).toString()).doubleValue();
        double VrNoPlan = Double.valueOf(this.modelon2t.getValueAt(PosServicio, 9).toString()).doubleValue();
        if (tipoOperacion == 1) {
            this.modelon2t.setValueAt(Integer.valueOf(NoItem + 1), PosServicio, 5);
            this.modelon2t.setValueAt(Double.valueOf(VrServicio + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 6);
            if (this.btnDescuento.isSelected()) {
                this.modelon2t.setValueAt(Double.valueOf(VrDescuento + getCalcularDescuento()), PosServicio, 7);
            }
            if (getTipoServicio().equals("Es_Proc")) {
                if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString())) {
                    this.modelon2t.setValueAt(Double.valueOf(VrPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 8);
                    return;
                } else {
                    this.modelon2t.setValueAt(Double.valueOf(VrNoPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 9);
                    return;
                }
            }
            if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7).toString())) {
                this.modelon2t.setValueAt(Double.valueOf(VrPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 8);
                return;
            } else {
                this.modelon2t.setValueAt(Double.valueOf(VrNoPlan + Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue()), PosServicio, 9);
                return;
            }
        }
        if (Integer.parseInt(this.modelon2t.getValueAt(PosServicio, 5).toString()) == 1) {
            this.modelon2t.removeRow(PosServicio);
            this.filaGridTotales1--;
            return;
        }
        this.modelon2t.setValueAt(Integer.valueOf(NoItem - 1), PosServicio, 5);
        this.modelon2t.setValueAt(Double.valueOf(VrServicio - Double.valueOf(this.modelon2.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 6);
        this.modelon2t.setValueAt(Double.valueOf(VrDescuento - Double.valueOf(this.modelon2.getValueAt(NoFilaDetalle, 12).toString()).doubleValue()), PosServicio, 7);
        if (getidPlanEmpresaCont().equals(this.modelon2.getValueAt(NoFilaDetalle, 14).toString())) {
            this.modelon2t.setValueAt(Double.valueOf(VrPlan - Double.valueOf(this.modelon2.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 8);
        } else {
            this.modelon2t.setValueAt(Double.valueOf(VrNoPlan - Double.valueOf(this.modelon2.getValueAt(NoFilaDetalle, 11).toString()).doubleValue()), PosServicio, 9);
        }
    }

    public void adicionarDetalle() {
        if (validarCampos() == 1) {
            if (verificarProc_Sum(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString()) == 0) {
                if (getTipoServicio().equals("Es_Proc")) {
                    if (this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7).toString().equals("1")) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            if (this.frmFacturac.frmPersona.cboSexo.getSelectedIndex() != -1) {
                                Paquetes frmPq = new Paquetes(null, true, false, Integer.parseInt(this.frmFacturac.frmPersona.listasegmento[this.frmFacturac.frmPersona.JCBSegmento.getSelectedIndex()]), Long.parseLong(this.frmFacturac.frmPersona.getIdPersona()), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().longValue(), this, this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString(), this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()), this.frmFacturac.frmPersona.listaSexo[this.frmFacturac.frmPersona.cboSexo.getSelectedIndex()]);
                                frmPq.setVisible(true);
                                return;
                            }
                            return;
                        }
                        if (this.frmFacturac.frmPersona.listasegmento[this.frmFacturac.frmPersona.JCBSegmento.getSelectedIndex()].equals("1")) {
                            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                mPaquete(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString());
                                return;
                            } else {
                                if (this.frmFacturac.frmPersona.cboSexo.getSelectedIndex() != -1) {
                                    Paquetes frmPq2 = new Paquetes(null, true, this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString(), this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 2).toString(), this, this.txtCodigo.getText(), true, this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()), this.frmFacturac.frmPersona.listaSexo[this.frmFacturac.frmPersona.cboSexo.getSelectedIndex()]);
                                    frmPq2.setVisible(true);
                                    return;
                                }
                                return;
                            }
                        }
                        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                            mPaquete(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString());
                            return;
                        } else {
                            if (this.frmFacturac.frmPersona.cboSexo.getSelectedIndex() != -1) {
                                Paquetes frmPq3 = new Paquetes(null, true, false, Integer.valueOf(this.frmFacturac.frmPersona.listasegmento[this.frmFacturac.frmPersona.JCBSegmento.getSelectedIndex()]).intValue(), Long.valueOf(this.frmFacturac.frmPersona.getIdPersona()).longValue(), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().longValue(), this, this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString(), this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()), this.frmFacturac.frmPersona.listaSexo[this.frmFacturac.frmPersona.cboSexo.getSelectedIndex()]);
                                frmPq3.setVisible(true);
                                return;
                            }
                            return;
                        }
                    }
                    mAdicionarTablaDetalle();
                    return;
                }
                mAdicionarTablaDetalle();
                return;
            }
            this.metodos.mostrarMensaje("Este Procedimiento o Suministro ya se encuentra agregado");
        }
    }

    /* JADX WARN: Finally extract failed */
    private void mPaquete(String idProcPadre) {
        String xsql;
        try {
            switch (Integer.valueOf(getxId_MetodoFac()).intValue()) {
                case 0:
                    xsql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n            IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo) AS Valor,\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString() + "'  \n           AND h_procedimientoxprelacionado.`Estado`=1  AND f_tiposervtipoproced.Idtiposervicio='" + getIdServicio() + "'\n            AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "' and f_tarifaprocedimiento.Id_Procedimiento<>'" + idProcPadre + "' ) \n            ORDER BY NProcedimiento ASC; ";
                    break;
                case 1:
                    xsql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            WHERE f_empresacontxconvenio.Id ='" + this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString() + "' \n           AND h_procedimientoxprelacionado.`Estado`=1 AND f_tiposervtipoproced.Idtiposervicio='" + getIdServicio() + "'\n            AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "' and f_tarifaprocedimiento.Id_Procedimiento<>'" + idProcPadre + "' \n            ORDER BY NProcedimiento ASC;";
                    break;
                default:
                    xsql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t        INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n\t\t    WHERE f_empresacontxconvenio.Id ='" + this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString() + "' \n\t\t\tAND h_procedimientoxprelacionado.`Estado`=1    AND f_tiposervtipoproced.Idtiposervicio='" + getIdServicio() + "' \n\t\t\t    AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "'  and f_tarifaprocedimiento.Id_Procedimiento<>'" + idProcPadre + "'\n\t\t       ORDER BY NProcedimiento ASC; ";
                    break;
            }
            ResultSet xrs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                this.metodos.mEstablecerTextEditor(this.gridDetalle, 3);
                mAdicionarTablaDetalle();
                while (xrs.next()) {
                    this.txtCodigo.setText(xrs.getString("Id"));
                    verificarCodProcSum();
                    this.txtCantidad.requestFocus();
                    this.txtCantidad.transferFocus();
                    validar_perderfoco();
                    adicionarDetalle();
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
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JD_Registro_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mAdicionarTablaDetalle() {
        this.metodos.mEstablecerTextEditor(this.gridDetalle, 3);
        if (!this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getIdEmpresaConvenio().equals("0")) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(getIdServicio(), this.filaGridDetalle, 0);
            this.modelo.setValueAt(this.cboServicio.getSelectedItem(), this.filaGridDetalle, 1);
            this.modelo.setValueAt(getTipoServicio(), this.filaGridDetalle, 2);
            this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0), this.filaGridDetalle, 3);
            this.modelo.setValueAt(this.cboProcedSuministro.getSelectedItem(), this.filaGridDetalle, 4);
            if (getTipoServicio().equals("Es_Proc")) {
                this.modelo.setValueAt(this.cboFinProcedimiento.getPopupTable().getValueAt(this.cboFinProcedimiento.getSelectedIndex(), 0), this.filaGridDetalle, 5);
                this.modelo.setValueAt(this.cboFinProcedimiento.getSelectedItem(), this.filaGridDetalle, 6);
                this.modelo.setValueAt(this.cboCentroCosto.getPopupTable().getValueAt(this.cboCentroCosto.getSelectedIndex(), 0), this.filaGridDetalle, 7);
                this.modelo.setValueAt(this.cboCentroCosto.getSelectedItem(), this.filaGridDetalle, 8);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6), this.filaGridDetalle, 14);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 11), this.filaGridDetalle, 23);
                this.modelo.setValueAt("", this.filaGridDetalle, 24);
                this.modelo.setValueAt("", this.filaGridDetalle, 25);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            } else {
                this.modelo.setValueAt("0", this.filaGridDetalle, 5);
                this.modelo.setValueAt("No Aplica", this.filaGridDetalle, 6);
                this.modelo.setValueAt("0", this.filaGridDetalle, 7);
                this.modelo.setValueAt("No Aplica", this.filaGridDetalle, 8);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7), this.filaGridDetalle, 14);
                this.modelo.setValueAt(false, this.filaGridDetalle, 23);
                this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoPrescripcionMiPres.getText(), this.filaGridDetalle, 24);
                this.modelo.setValueAt("", this.filaGridDetalle, 25);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            }
            this.modelo.setValueAt(this.txtCantidad.getText(), this.filaGridDetalle, 9);
            this.modelo.setValueAt(this.txtVrUnitario.getValue(), this.filaGridDetalle, 10);
            this.modelo.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle, 11);
            if (this.btnDescuento.isSelected()) {
                this.modelo.setValueAt(Long.valueOf(getCalcularDescuento()), this.filaGridDetalle, 12);
                this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.txtVrTotal.getValue().toString()) - getCalcularDescuento()), this.filaGridDetalle, 13);
            } else {
                this.modelo.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle, 13);
            }
            this.modelo.setValueAt(this.JTFFDescuento.getValue(), this.filaGridDetalle, 12);
            this.modelo.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridDetalle, 15);
            this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 8), this.filaGridDetalle, 16);
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                this.modelo.setValueAt(this.idOrdenItemsGIIS, this.filaGridDetalle, 17);
            } else if (this.idOrdenItems.equals("")) {
                this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoAutorizacion.getText(), this.filaGridDetalle, 17);
            } else {
                this.modelo.setValueAt(this.idOrdenItems, this.filaGridDetalle, 17);
            }
            this.modelo.setValueAt(true, this.filaGridDetalle, 18);
            this.modelo.setValueAt("1", this.filaGridDetalle, 19);
            this.modelo.setValueAt("", this.filaGridDetalle, 20);
            if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                this.modelo.setValueAt(this.JSPPImpuesto.getValue(), this.filaGridDetalle, 21);
                this.modelo.setValueAt(this.JTFF_VTotalImpuesto.getValue(), this.filaGridDetalle, 22);
            } else {
                this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGridDetalle, 21);
                this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGridDetalle, 22);
            }
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            if (this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 13).toString().equals("1")) {
                System.out.println("aplica consentimiento");
                this.modelo.setValueAt(new JButton("Generación"), this.filaGridDetalle, 30);
            } else {
                this.modelo.setValueAt(new JButton(""), this.filaGridDetalle, 30);
            }
            Sumar_RestarTotales(1);
            this.filaGridDetalle++;
            setValidarDatos(this.filaGridDetalle);
            cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
            this.txtCodigo.requestFocus();
            return;
        }
        if (this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 4).equals(1)) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(getIdServicio(), this.filaGridDetalle, 0);
            this.modelo.setValueAt(this.cboServicio.getSelectedItem(), this.filaGridDetalle, 1);
            this.modelo.setValueAt(getTipoServicio(), this.filaGridDetalle, 2);
            this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0), this.filaGridDetalle, 3);
            this.modelo.setValueAt(this.cboProcedSuministro.getSelectedItem(), this.filaGridDetalle, 4);
            if (getTipoServicio().equals("Es_Proc")) {
                this.modelo.setValueAt(this.cboFinProcedimiento.getPopupTable().getValueAt(this.cboFinProcedimiento.getSelectedIndex(), 0), this.filaGridDetalle, 5);
                this.modelo.setValueAt(this.cboFinProcedimiento.getSelectedItem(), this.filaGridDetalle, 6);
                this.modelo.setValueAt(this.cboCentroCosto.getPopupTable().getValueAt(this.cboCentroCosto.getSelectedIndex(), 0), this.filaGridDetalle, 7);
                this.modelo.setValueAt(this.cboCentroCosto.getSelectedItem(), this.filaGridDetalle, 8);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6), this.filaGridDetalle, 14);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 11), this.filaGridDetalle, 23);
                this.modelo.setValueAt("", this.filaGridDetalle, 24);
                this.modelo.setValueAt("", this.filaGridDetalle, 25);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            } else {
                this.modelo.setValueAt("0", this.filaGridDetalle, 5);
                this.modelo.setValueAt("No Aplica", this.filaGridDetalle, 6);
                this.modelo.setValueAt("0", this.filaGridDetalle, 7);
                this.modelo.setValueAt("No Aplica", this.filaGridDetalle, 8);
                this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6), this.filaGridDetalle, 14);
                this.modelo.setValueAt(false, this.filaGridDetalle, 23);
                this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoPrescripcionMiPres.getText(), this.filaGridDetalle, 24);
                this.modelo.setValueAt("", this.filaGridDetalle, 25);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
                this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
                this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            }
            this.modelo.setValueAt(this.txtCantidad.getText(), this.filaGridDetalle, 9);
            this.modelo.setValueAt(this.txtVrUnitario.getValue(), this.filaGridDetalle, 10);
            this.modelo.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle, 11);
            if (this.btnDescuento.isSelected()) {
                this.modelo.setValueAt(Long.valueOf(getCalcularDescuento()), this.filaGridDetalle, 12);
                this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.txtVrTotal.getValue().toString()) - getCalcularDescuento()), this.filaGridDetalle, 13);
            } else {
                this.modelo.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle, 13);
            }
            this.modelo.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridDetalle, 15);
            this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 8), this.filaGridDetalle, 16);
            this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoAutorizacion.getText(), this.filaGridDetalle, 17);
            this.modelo.setValueAt(true, this.filaGridDetalle, 18);
            this.modelo.setValueAt("1", this.filaGridDetalle, 19);
            this.modelo.setValueAt("", this.filaGridDetalle, 20);
            if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                this.modelo.setValueAt(this.JSPPImpuesto.getValue(), this.filaGridDetalle, 21);
                this.modelo.setValueAt(this.JTFF_VTotalImpuesto.getValue(), this.filaGridDetalle, 22);
            } else {
                this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGridDetalle, 21);
                this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGridDetalle, 22);
            }
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGridDetalle, 26);
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGridDetalle, 27);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGridDetalle, 28);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGridDetalle, 29);
            if (this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 13).toString().equals("1")) {
                System.out.println("aplica consentimiento");
                this.modelo.setValueAt(new JButton("Generación"), this.filaGridDetalle, 30);
            } else {
                this.modelo.setValueAt(new JButton(""), this.filaGridDetalle, 30);
            }
            Sumar_RestarTotales(1);
            this.filaGridDetalle++;
            setValidarDatos(this.filaGridDetalle);
            cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
            limpiar();
            this.txtCodigo.requestFocus();
            return;
        }
        this.modelon2.addRow(this.datos);
        this.modelon2.setValueAt(getIdServicio(), this.filaGridDetalle1, 0);
        this.modelon2.setValueAt(this.cboServicio.getSelectedItem(), this.filaGridDetalle1, 1);
        this.modelon2.setValueAt(getTipoServicio(), this.filaGridDetalle1, 2);
        this.modelon2.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0), this.filaGridDetalle1, 3);
        this.modelon2.setValueAt(this.cboProcedSuministro.getSelectedItem(), this.filaGridDetalle1, 4);
        if (getTipoServicio().equals("Es_Proc")) {
            this.modelon2.setValueAt(this.cboFinProcedimiento.getPopupTable().getValueAt(this.cboFinProcedimiento.getSelectedIndex(), 0), this.filaGridDetalle1, 5);
            this.modelon2.setValueAt(this.cboFinProcedimiento.getSelectedItem(), this.filaGridDetalle1, 6);
            this.modelon2.setValueAt(this.cboCentroCosto.getPopupTable().getValueAt(this.cboCentroCosto.getSelectedIndex(), 0), this.filaGridDetalle1, 7);
            this.modelon2.setValueAt(this.cboCentroCosto.getSelectedItem(), this.filaGridDetalle1, 8);
            this.modelon2.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6), this.filaGridDetalle1, 14);
            this.modelo.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 11), this.filaGridDetalle, 23);
            this.modelo.setValueAt("", this.filaGridDetalle, 24);
            this.modelo.setValueAt("", this.filaGridDetalle, 25);
        } else {
            this.modelon2.setValueAt("0", this.filaGridDetalle1, 5);
            this.modelon2.setValueAt("No Aplica", this.filaGridDetalle1, 6);
            this.modelon2.setValueAt("0", this.filaGridDetalle1, 7);
            this.modelon2.setValueAt("No Aplica", this.filaGridDetalle1, 8);
            this.modelon2.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6), this.filaGridDetalle1, 14);
            this.modelo.setValueAt(false, this.filaGridDetalle, 23);
            this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoPrescripcionMiPres.getText(), this.filaGridDetalle, 24);
            this.modelo.setValueAt("", this.filaGridDetalle, 25);
        }
        this.modelon2.setValueAt(this.txtCantidad.getText(), this.filaGridDetalle1, 9);
        this.modelon2.setValueAt(this.txtVrUnitario.getValue(), this.filaGridDetalle1, 10);
        this.modelon2.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle1, 11);
        if (this.btnDescuento.isSelected()) {
            this.modelon2.setValueAt(Long.valueOf(getCalcularDescuento()), this.filaGridDetalle1, 12);
            this.modelon2.setValueAt(Long.valueOf(Long.parseLong(this.txtVrTotal.getValue().toString()) - getCalcularDescuento()), this.filaGridDetalle1, 13);
        } else {
            this.modelon2.setValueAt(this.txtVrTotal.getValue(), this.filaGridDetalle1, 13);
        }
        this.modelon2.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridDetalle1, 15);
        this.modelon2.setValueAt(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 8), this.filaGridDetalle1, 16);
        this.modelo.setValueAt(this.frmFacturac.frmIngreso.txtNoAutorizacion.getText(), this.filaGridDetalle, 17);
        if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
            this.modelon2.setValueAt(this.JSPPImpuesto.getValue(), this.filaGridDetalle1, 17);
            this.modelon2.setValueAt(this.JTFF_VTotalImpuesto.getValue(), this.filaGridDetalle1, 18);
        } else {
            this.modelon2.setValueAt(new Double(0.0d), this.filaGridDetalle1, 17);
            this.modelon2.setValueAt(new Double(0.0d), this.filaGridDetalle1, 18);
        }
        Sumar_RestarTotales1(1);
        this.filaGridDetalle1++;
        setValidarDatos(this.filaGridDetalle1);
        cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
        limpiar();
        this.txtCodigo.requestFocus();
    }

    private void adicionarUnicoRegistro() {
        this.modelototales.addRow(this.datosTotales);
        this.modelototales.setValueAt(this.cboCentroCosto.getPopupTable().getValueAt(this.cboCentroCosto.getSelectedIndex(), 0), this.filaGridTotales, 0);
        this.modelototales.setValueAt(this.cboCentroCosto.getSelectedItem(), this.filaGridTotales, 1);
        this.modelototales.setValueAt(getIdServicio(), this.filaGridTotales, 2);
        this.modelototales.setValueAt(getTipoServicio(), this.filaGridTotales, 3);
        this.modelototales.setValueAt(this.cboServicio.getSelectedItem(), this.filaGridTotales, 4);
        this.modelototales.setValueAt(1, this.filaGridTotales, 5);
        this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFDescuento.getValue().toString()).doubleValue()), this.filaGridTotales, 6);
        this.modelototales.setValueAt(this.frmFacturac.frmIngreso.xIdProfesional[this.frmFacturac.frmIngreso.cboProfesional.getSelectedIndex()], this.filaGridTotales, 10);
        this.modelototales.setValueAt(this.frmFacturac.frmIngreso.cboProfesional.getSelectedItem(), this.filaGridTotales, 11);
        this.modelototales.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridTotales, 14);
        this.modelototales.setValueAt(this.JTFFDescuento.getValue(), this.filaGridTotales, 7);
        System.out.println("Plan -> " + getidPlanEmpresaCont());
        System.out.println("servicio -> " + this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString());
        if (getTipoServicio().equals("Es_Proc")) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString()) && !getidPlanEmpresaCont().equals("4")) {
                    this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 8);
                    return;
                } else {
                    this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 9);
                    return;
                }
            }
            if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString())) {
                this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 8);
                return;
            } else {
                this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 9);
                return;
            }
        }
        if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7).toString())) {
            this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 8);
        } else {
            this.modelototales.setValueAt(Double.valueOf(Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() - Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 7).toString()).doubleValue()), this.filaGridTotales, 9);
        }
    }

    private void adicionarUnicoRegistro1() {
        this.modelon2t.addRow(this.datosTotales);
        this.modelon2t.setValueAt(this.cboCentroCosto.getPopupTable().getValueAt(this.cboCentroCosto.getSelectedIndex(), 0), this.filaGridTotales1, 0);
        this.modelon2t.setValueAt(this.cboCentroCosto.getSelectedItem(), this.filaGridTotales1, 1);
        this.modelon2t.setValueAt(getIdServicio(), this.filaGridTotales1, 2);
        this.modelon2t.setValueAt(getTipoServicio(), this.filaGridTotales1, 3);
        this.modelon2t.setValueAt(this.cboServicio.getSelectedItem(), this.filaGridTotales1, 4);
        this.modelon2t.setValueAt(1, this.filaGridTotales1, 5);
        this.modelon2t.setValueAt(this.txtVrTotal.getValue(), this.filaGridTotales1, 6);
        this.modelon2t.setValueAt(this.frmFacturac.frmIngreso.xIdProfesional[this.frmFacturac.frmIngreso.cboProfesional.getSelectedIndex()], this.filaGridTotales1, 10);
        this.modelon2t.setValueAt(this.frmFacturac.frmIngreso.cboProfesional.getSelectedItem(), this.filaGridTotales1, 11);
        this.modelon2t.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridTotales1, 14);
        if (this.btnDescuento.isSelected()) {
            this.modelon2t.setValueAt(Long.valueOf(getCalcularDescuento()), this.filaGridTotales1, 7);
        }
        if (getTipoServicio().equals("Es_Proc")) {
            if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 6).toString())) {
                this.modelon2t.setValueAt(this.txtVrTotal.getValue(), this.filaGridTotales1, 8);
                return;
            } else {
                this.modelon2t.setValueAt(this.txtVrTotal.getValue(), this.filaGridTotales1, 9);
                return;
            }
        }
        if (getidPlanEmpresaCont().equals(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 7).toString())) {
            this.modelon2t.setValueAt(this.txtVrTotal.getValue(), this.filaGridTotales1, 8);
        } else {
            this.modelon2t.setValueAt(this.txtVrTotal.getValue(), this.filaGridTotales1, 9);
        }
    }

    private void borrarRegistroTabla() {
        if (this.modelo.getRowCount() > 0) {
            int NoFila = this.gridDetalle.getSelectedRow();
            String IdServicio = this.modelo.getValueAt(NoFila, 0).toString();
            int NoFilaServicio = verificarServiciov2(IdServicio);
            actualizarUnicoRegistro(NoFilaServicio, 0, NoFila);
            this.modelo.removeRow(NoFila);
            this.filaGridDetalle--;
            setValidarDatos(this.filaGridDetalle);
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    public void buscarCitasUsuario(String idUsuario) {
        if (this.JCH_VisualizarAnt.isSelected()) {
            this.sql = "SELECT c_citas.Id as No_Cita, profesional1.NProfesional as Profesional, c_clasecita.Nbre as Clase_Cita, g_especialidad.Nbre as Especialidad, c_citas.Fecha_Cita,c_citas.HoraInicial as Hora_Inicial, c_citas.HoraFinal as Hora_Final,  g_procedimiento.Nbre as Procedimiento_Asociado, g_procedimiento.Id, f_tiposervicio.Nbre as Tipo_Servicio, c_clasecita.Id, IF(c_clasecita.EsSO=1,'si','no') as EsSO,c_citas.`Id_TratamientoO` AS TTO_Odont, f_tipofinprocedimiento.`Nbre` as Finalidad, `g_causaexterna`.`Nbre` AS CausaExterna,`f_empresacontxconvenio`.`Nbre` NEmpresaConvenio,c_citas.NAutorizacion  FROM profesional1 INNER JOIN c_citas ON (profesional1.Id_Persona = c_citas.Id_Profesional)  AND (profesional1.IdEspecialidad= c_citas.Id_Especialidad) INNER JOIN g_especialidad ON (c_citas.Id_Especialidad = g_especialidad.Id) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = c_clasecita.`Id_Finalidad`)   INNER JOIN `g_causaexterna`   ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citas.Id_Usuario ='" + idUsuario + "' AND c_citas.Asistida=0 AND c_citas.Id_MotivoDesistida=1   and c_citas.Fecha_Cita<='" + this.metodos.formatoAMD.format(this.JDC_FechaCitas.getDate()) + "') GROUP BY c_citas.Id";
        } else {
            this.sql = "SELECT c_citas.Id as No_Cita, profesional1.NProfesional as Profesional, c_clasecita.Nbre as Clase_Cita, g_especialidad.Nbre as Especialidad, c_citas.Fecha_Cita,c_citas.HoraInicial as Hora_Inicial, c_citas.HoraFinal as Hora_Final, g_procedimiento.Nbre as Procedimiento_Asociado, g_procedimiento.Id, f_tiposervicio.Nbre as Tipo_Servicio, c_clasecita.Id, IF(c_clasecita.EsSO=1,'si','no') as EsSO,c_citas.`Id_TratamientoO` AS TTO_Odont, f_tipofinprocedimiento.`Nbre` as Finalidad, `g_causaexterna`.`Nbre` AS CausaExterna,`f_empresacontxconvenio`.`Nbre` NEmpresaConvenio,c_citas.NAutorizacion   FROM profesional1 INNER JOIN c_citas ON (profesional1.Id_Persona = c_citas.Id_Profesional)  AND (profesional1.IdEspecialidad= c_citas.Id_Especialidad) INNER JOIN g_especialidad ON (c_citas.Id_Especialidad = g_especialidad.Id) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = c_clasecita.`Id_Finalidad`)   INNER JOIN `g_causaexterna`   ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citas.Id_Usuario ='" + idUsuario + "' AND c_citas.Asistida=0 AND c_citas.Id_MotivoDesistida=1 and c_citas.Fecha_Cita='" + this.metodos.formatoAMD.format(this.JDC_FechaCitas.getDate()) + "') GROUP BY c_citas.Id";
        }
        System.out.println(" Citas Programadas : " + this.sql);
        this.gridCita1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        System.out.println(" Citas Programadas : " + this.sql);
        this.consultas.llenarTabla(this.sql, this.gridCita1, this.modelocita1);
        this.consultas.cerrarConexionBd();
        JTable jTable = this.gridCita1;
        JTable jTable2 = this.gridCita1;
        jTable.setAutoResizeMode(0);
        this.gridCita1.doLayout();
        if (this.JCH_VisualizarAnt.isSelected()) {
            this.sql = "SELECT c_citasnp.Id as No_Cita, w_profesional.NProfesional as Profesional, c_clasecita.Nbre as Clase_Cita, w_profesional.Especialidad as Especialidad, c_citasnp.Fecha_Cita,c_citasnp.HoraInicial as Hora_Inicial,  g_procedimiento.Nbre as Procedimiento_Asociado, g_procedimiento.Id, f_tiposervicio.Nbre as Tipo_Servicio, c_citasnp.Id_ingreso, c_clasecita.Id AS No_Ingreso, c_clasecita.Id, IF(c_clasecita.EsSO=1,'si','no') as EsSO, c_citasnp.Id_TratamientoO AS TTO_Odont, f_tipofinprocedimiento.`Nbre` as Finalidad, `g_causaexterna`.`Nbre` AS CausaExterna,`f_empresacontxconvenio`.`Nbre` NEmpresaConvenio,c_citasnp.NAutorizacion  FROM w_profesional INNER JOIN c_citasnp ON (w_profesional.Id_Persona = c_citasnp.Id_Profesional)  AND (w_profesional.IdEspecialidad=c_citasnp.Id_Especialidad)   INNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = c_clasecita.`Id_Finalidad`)  INNER JOIN `g_causaexterna`   ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citasnp.Id_Usuario ='" + idUsuario + "' AND c_citasnp.EstaFacturada=0 AND c_citasnp.Id_MotivoDesistida=0 and c_citasnp.Fecha_Cita<='" + this.metodos.formatoAMD.format(this.JDC_FechaCitas.getDate()) + "') GROUP BY c_citasnp.Id";
        } else {
            this.sql = "SELECT c_citasnp.Id as No_Cita, w_profesional.NProfesional as Profesional, c_clasecita.Nbre as Clase_Cita, w_profesional.Especialidad as Especialidad, c_citasnp.Fecha_Cita,c_citasnp.HoraInicial as Hora_Inicial,  g_procedimiento.Nbre as Procedimiento_Asociado, g_procedimiento.Id, f_tiposervicio.Nbre as Tipo_Servicio, c_citasnp.Id_ingreso, c_clasecita.Id AS No_Ingreso, c_clasecita.Id, IF(c_clasecita.EsSO=1,'si','no') as EsSO, c_citasnp.Id_TratamientoO AS TTO_Odont,f_tipofinprocedimiento.`Nbre` as Finalidad, `g_causaexterna`.`Nbre` AS CausaExterna,`f_empresacontxconvenio`.`Nbre` NEmpresaConvenio,c_citasnp.NAutorizacion  FROM w_profesional INNER JOIN c_citasnp ON (w_profesional.Id_Persona = c_citasnp.Id_Profesional)  AND (w_profesional.IdEspecialidad=c_citasnp.Id_Especialidad)   INNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = c_clasecita.`Id_Finalidad`)  INNER JOIN `g_causaexterna`   ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citasnp.Id_Usuario ='" + idUsuario + "' AND c_citasnp.EstaFacturada=0 AND c_citasnp.Id_MotivoDesistida=0 and c_citasnp.Fecha_Cita='" + this.metodos.formatoAMD.format(this.JDC_FechaCitas.getDate()) + "') GROUP BY c_citasnp.Id";
        }
        this.gridCita2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.consultas.llenarTabla(this.sql, this.gridCita2, this.modelocita2);
        this.consultas.cerrarConexionBd();
        this.gridCita1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridCita1.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.gridCita1.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.gridCita1.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.gridCita1.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridCita1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.gridCita1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.gridCita1.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.gridCita1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.gridCita1.getColumnModel().getColumn(8).setMinWidth(0);
        this.gridCita1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.gridCita1.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.gridCita1.getColumnModel().getColumn(9).setMinWidth(0);
        this.gridCita1.getColumnModel().getColumn(9).setMaxWidth(0);
        this.gridCita1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.gridCita1.getColumnModel().getColumn(10).setMinWidth(0);
        this.gridCita1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.gridCita1.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.gridCita1.getColumnModel().getColumn(11).setMinWidth(0);
        this.gridCita1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.gridCita1.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.gridCita1.getColumnModel().getColumn(12).setMinWidth(0);
        this.gridCita1.getColumnModel().getColumn(12).setMaxWidth(0);
        this.gridCita1.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.gridCita1.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.gridCita1.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.gridCita1.getColumnModel().getColumn(16).setPreferredWidth(100);
        JTable jTable3 = this.gridCita2;
        JTable jTable4 = this.gridCita2;
        jTable3.setAutoResizeMode(0);
        this.gridCita2.doLayout();
        this.gridCita2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridCita2.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.gridCita2.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.gridCita2.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.gridCita2.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridCita2.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.gridCita2.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.gridCita2.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.gridCita2.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridCita2.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridCita2.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridCita2.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.gridCita2.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.gridCita2.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.gridCita2.getColumnModel().getColumn(11).setPreferredWidth(100);
        buscarOrdenesHC(idUsuario);
        mConsultarTratamientos(idUsuario);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void buscarOrdenesHC(String idUsuario) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        String filtroHOrden = "";
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            filtroHOrden = " AND `h_ordenes`.`id_f_ordenes` = 0 ";
        }
        if (this.JRB_FTodas.isSelected()) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.sql = "SELECT h_ordenes.Id, f_tiposervicio.Nbre as Servicio, h_ordenes.FechaOrden as Fecha, profesional.NProfesional as Profesional, g_especialidad.Nbre as Especialidad, h_atencion.Codigo_Dxp, c_clasecita.`Id_Finalidad` FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN `c_clasecita`  ON (c_clasecita.`Id` = h_atencion.`Id_ClaseCita`) INNER JOIN f_tiposervicio  ON (h_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN g_profesionalespecial  ON (profesional.Id_Persona = g_profesionalespecial.Id_Profesional) and (g_profesionalespecial.Id_Especialidad=h_atencion.Id_Especialidad) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) WHERE (ingreso.Id_Usuario ='" + idUsuario + "' AND f_tipoprocedimiento.Id_tipoclaseproc in(2) AND h_ordenes.Estado =0 AND h_ordenes.EstaEntregada in(0,1) and h_ordenes.`Id_TipoA`=1) GROUP BY h_ordenes.Id ORDER BY f_tiposervicio.Nbre ASC, h_ordenes.FechaOrden ASC, h_ordenes.Id ASC ";
            } else {
                this.sql = "SELECT h_ordenes.Id, f_tiposervicio.Nbre as Servicio, h_ordenes.FechaOrden as Fecha, profesional.NProfesional as Profesional, g_especialidad.Nbre as Especialidad, h_atencion.Codigo_Dxp, c_clasecita.`Id_Finalidad` FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN `c_clasecita`  ON (c_clasecita.`Id` = h_atencion.`Id_ClaseCita`) INNER JOIN f_tiposervicio  ON (h_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN g_profesionalespecial  ON (profesional.Id_Persona = g_profesionalespecial.Id_Profesional) and (g_profesionalespecial.Id_Especialidad=h_atencion.Id_Especialidad) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) WHERE (ingreso.Id_Usuario ='" + idUsuario + "' AND f_tipoprocedimiento.Id_tipoclaseproc in(2,3) AND h_ordenes.Estado =0 AND h_ordenes.EstaEntregada in(0,1) and h_ordenes.`Id_TipoA`=1 " + filtroHOrden + ")  GROUP BY h_ordenes.Id ORDER BY f_tiposervicio.Nbre ASC, h_ordenes.FechaOrden ASC, h_ordenes.Id ASC ";
            }
        } else if (this.JRB_FAno.isSelected()) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.sql = "SELECT h_ordenes.Id, f_tiposervicio.Nbre as Servicio, h_ordenes.FechaOrden as Fecha, profesional.NProfesional as Profesional, g_especialidad.Nbre as Especialidad, h_atencion.Codigo_Dxp, c_clasecita.`Id_Finalidad` FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN `c_clasecita`  ON (c_clasecita.`Id` = h_atencion.`Id_ClaseCita`) INNER JOIN f_tiposervicio  ON (h_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN g_profesionalespecial  ON (profesional.Id_Persona = g_profesionalespecial.Id_Profesional) and (g_profesionalespecial.Id_Especialidad=h_atencion.Id_Especialidad) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) WHERE ( date_format(h_ordenes.FechaOrden,'%Y')='" + this.JYC_FAno.getValue() + "' and ingreso.Id_Usuario ='" + idUsuario + "' AND f_tipoprocedimiento.Id_tipoclaseproc in(2) AND h_ordenes.Estado =0 AND h_ordenes.EstaEntregada in(0,1) and h_ordenes.`Id_TipoA`=1) GROUP BY h_ordenes.Id ORDER BY f_tiposervicio.Nbre ASC, h_ordenes.FechaOrden ASC, h_ordenes.Id ASC ";
            } else {
                this.sql = "SELECT h_ordenes.Id, f_tiposervicio.Nbre as Servicio, h_ordenes.FechaOrden as Fecha, profesional.NProfesional as Profesional, g_especialidad.Nbre as Especialidad, h_atencion.Codigo_Dxp, c_clasecita.`Id_Finalidad` FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN `c_clasecita`  ON (c_clasecita.`Id` = h_atencion.`Id_ClaseCita`) INNER JOIN f_tiposervicio  ON (h_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN g_profesionalespecial  ON (profesional.Id_Persona = g_profesionalespecial.Id_Profesional) and (g_profesionalespecial.Id_Especialidad=h_atencion.Id_Especialidad) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) WHERE ( date_format(h_ordenes.FechaOrden,'%Y')='" + this.JYC_FAno.getValue() + "' and ingreso.Id_Usuario ='" + idUsuario + "' AND f_tipoprocedimiento.Id_tipoclaseproc in(2,3) AND h_ordenes.Estado =0 AND h_ordenes.EstaEntregada in(0,1) and h_ordenes.`Id_TipoA`=1 " + filtroHOrden + ")  GROUP BY h_ordenes.Id ORDER BY f_tiposervicio.Nbre ASC, h_ordenes.FechaOrden ASC, h_ordenes.Id ASC ";
            }
        }
        this.gridOrdMed.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        xct1.llenarTabla(this.sql, this.gridOrdMed, this.modelordmed);
        xct1.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloTratamiento() {
        this.xmodelotratamiento = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional", "Especialidad", "Estado"}) { // from class: Facturacion.Ordenes.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTTratamientos.setModel(this.xmodelotratamiento);
        this.JTTratamientos.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTTratamientos.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTTratamientos.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTTratamientos.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTTratamientos.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    public void mConsultarTratamientos(String idUsuario) {
        String sql = "SELECT `o_hc_tratamiento`.`Id` , `o_hc_tratamiento`.`FInicio` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`, IF(h_atencion.`TipoGuardado`=0,'Abierto','Cerrado') AS TipoGuardado -- ingreso.`Id` as IdIngreso,\n   /* IFNULL(`f_liquidacion`.id,0) AS IdLiquidacion */  FROM `o_hc_tratamiento`  INNER JOIN `profesional1`   ON (`o_hc_tratamiento`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`o_hc_tratamiento`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN `o_hc_tratamiento_procedimiento`  ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)  INNER JOIN  `h_atencion`  ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) /* left join `f_ordenes` on ( `f_ordenes`.`Id_Ingreso` = ingreso.`Id`) */ \n   LEFT JOIN `f_liquidacion` ON ( `f_liquidacion`.`Id_Ingreso` = ingreso.id) WHERE (`ingreso`.`Id_Usuario` ='" + idUsuario + "' AND `o_hc_tratamiento_procedimiento`.`Id_Ingreso`=0 /* AND IFNULL(`f_liquidacion`.id,0) = 0 */) GROUP BY `o_hc_tratamiento`.`Id`, `o_hc_tratamiento_procedimiento`.`Id_Ingreso` ORDER BY `o_hc_tratamiento`.`FInicio` DESC";
        ResultSet xrs = this.consultas.traerRs(sql);
        mModeloTratamiento();
        System.out.println("Sql -> " + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelotratamiento.addRow(this.xdato);
                    this.xmodelotratamiento.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelotratamiento.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelotratamiento.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotratamiento.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotratamiento.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void calcularValorTotalProc_Sum() {
        double ValorImpuesto = 0.0d;
        double Valor = (Long.valueOf(this.txtCantidad.getText()).longValue() * Double.valueOf(this.txtVrUnitario.getValue().toString()).doubleValue()) - Double.parseDouble(this.JTFFDescuento.getValue().toString());
        if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
            ValorImpuesto = ((Double.valueOf(this.txtVrUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSPPImpuesto.getValue().toString()).doubleValue()) / 100.0d) * ((double) Integer.parseInt(this.txtCantidad.getText()));
        }
        this.txtVrTotal.setValue(Long.valueOf(Math.round(ValorImpuesto + Valor)));
        this.JTFF_VTotalImpuesto.setValue(Long.valueOf(Math.round(ValorImpuesto)));
    }

    public void CargarCombos() {
        this.xlleno1 = false;
        this.listGrupoEntitys = new ArrayList();
        this.sql = "SELECT Id, Nbre as Centro_Costo FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC";
        mLlenarComboFinalidad();
        this.consultas.cerrarConexionBd();
        this.consultas.llenarComboTabla(this.sql, this.cboCentroCosto, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.xlleno1 = true;
    }

    public void cargarCboservicio(String getidEmpresaCont) {
        CrearGridDetalle();
        CrearGridTotales();
        this.sql = " SELECT f_tiposervicio.Id AS Id, f_tiposervicio.Nbre AS Servicio, f_servicioempresaconv.Porcentaje_Descuento, IF((f_tipoprocedimiento.Id_tipoclaseproc=2 ||f_tipoprocedimiento.Id_tipoclaseproc=0 ||f_tipoprocedimiento.Id_tipoclaseproc=4 ),'Es_Proc','Es_Sum') as Tipo FROM f_tiposervtipoproced INNER JOIN f_tipoprocedimiento ON(f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_tipoprocedimiento.Id_tipoclaseproc IN(0,2,3,4) and f_tipoprocedimiento.EsValor=1 AND f_servicioempresaconv.Estado =0 AND f_servicioempresaconv.Id_EmpresaConvenio ='" + getidEmpresaCont + "') GROUP BY f_tiposervicio.Id, f_tiposervicio.Nbre ORDER BY f_tiposervicio.Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboServicio, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    public void cargar_Cod_Val_cbosCCFinProc() {
        if (this.cboProcedSuministro.getSelectedIndex() > -1) {
            String idFilaSel = this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString();
            if (Double.valueOf(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 3).toString()).doubleValue() != 0.0d) {
                if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                    this.valorImpuesto = Math.round((Double.valueOf(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 3).toString().replaceAll("\\.0", "")).doubleValue() * Double.valueOf(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 12).toString().replaceAll("\\.0", "")).doubleValue()) / 100.0d);
                } else {
                    this.xvalor = 0.0d;
                    this.valorImpuesto = 0.0d;
                }
                this.xvalor = Double.valueOf(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 3).toString().replaceAll("\\.0", "")).doubleValue();
            } else {
                this.xvalor = 0.0d;
                this.valorImpuesto = 0.0d;
            }
            CargarCombosVarios cargarCombosVarios = new CargarCombosVarios();
            cargarCombosVarios.cargarComboBoxServicioGrupoProcedimiento(this.JCBGrupoSevicio, this.JCBSevicioRips, Long.valueOf(idFilaSel));
            if (getTipoServicio().equals("Es_Proc")) {
                this.cboCentroCosto.setSelectedItem(getCentroCosto(idFilaSel));
                System.err.println("" + getFinalidadProc(idFilaSel));
                this.cboFinProcedimiento.setSelectedItem(getFinalidadProc(idFilaSel));
            } else {
                this.cboFinProcedimiento.setSelectedIndex(0);
            }
            this.txtCodigo.setText(idFilaSel);
            this.JTFF_VTotalImpuesto.setValue(Long.valueOf(Math.round(this.valorImpuesto)));
            this.txtVrUnitario.setValue(Double.valueOf(this.xvalor));
            this.JSPPImpuesto.setValue(Double.valueOf(this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 12).toString().replaceAll("\\.0", "")));
            calcularValorTotalProc_Sum();
        }
    }

    private void mLlenarComboFinalidad() {
        this.consultas.llenarComboTabla("SELECT Id, concat(Id,'-',Nbre) Nbre FROM f_tipofinprocedimiento ORDER BY Nbre ASC", this.cboFinProcedimiento, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    private void cambioCboServicio() {
        if (this.cboServicio.getSelectedIndex() > -1) {
            int Fila = this.cboServicio.getSelectedIndex();
            setIdServicio(this.cboServicio.getPopupTable().getValueAt(Fila, 0).toString());
            setTipoServicio(this.cboServicio.getPopupTable().getValueAt(Fila, 3).toString());
            if (this.cboServicio.getSelectedItem().equals("FARMACIA")) {
                this.JCBGrupoSevicio.setSelectedItem("Apoyo diagnóstico y complementación  terapéutica");
                this.JCBSevicioRips.setSelectedItem("SERVICIO FARMACEUTICO");
                if (Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579")) {
                    this.cboCentroCosto.setSelectedItem("SERVICIO FARMACEUTICO");
                } else {
                    this.cboCentroCosto.setSelectedItem("FARMACIA");
                }
            }
            cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
        }
    }

    public void cargarCboProcedSum(String idEmpresaCont, String idServicio, String TipoServicio, String CualValor, String FiltroProcxEmp) {
        int Fila = this.cboServicio.getSelectedIndex();
        this.txtCodigo.setText("");
        double VrDescuento = Double.parseDouble(this.cboServicio.getPopupTable().getValueAt(Fila, 2).toString());
        if (VrDescuento != 0.0d) {
            this.btnDescuento.setEnabled(true);
        } else {
            this.btnDescuento.setEnabled(false);
        }
        if (TipoServicio.equals("Es_Proc")) {
            this.cboFinProcedimiento.setEnabled(true);
            this.cboCentroCosto.setEnabled(true);
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                FiltroProcxEmp = "1";
            }
            System.out.println("metodo : " + getxId_MetodoFac());
            System.out.println("filtro : " + FiltroProcxEmp);
            if (FiltroProcxEmp.equals("0")) {
                switch (getxId_MetodoFac()) {
                    case "0":
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor) ,if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)) AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n             FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0) \n            ORDER BY Procedimiento ASC; ";
                            break;
                        } else {
                            this.sql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor) ,if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)) AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n             FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n            ORDER BY Procedimiento ASC; ";
                            break;
                        }
                        break;
                    case "1":
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\t\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n              \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0\n            ORDER BY Procedimiento ASC;";
                            break;
                        } else {
                            this.sql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\t\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n            ORDER BY Procedimiento ASC;";
                            break;
                        }
                        break;
                    default:
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0, if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0, if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0, if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0, if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n\t\t    WHERE f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY Procedimiento ASC; ";
                            break;
                        } else {
                            this.sql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor), (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0,if(f_procedempresaconvenio.Valor=1,0,f_procedempresaconvenio.Valor),ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n\t\t    WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "' \n\t\t\t    AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n\t\t       ORDER BY Procedimiento ASC; ";
                            break;
                        }
                        break;
                }
            } else {
                switch (getxId_MetodoFac()) {
                    case "0":
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n       IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor)  AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n             FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0) \n            ORDER BY Procedimiento ASC; ";
                            break;
                        } else {
                            this.sql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n          IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor) AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n             FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n            ORDER BY Procedimiento ASC; ";
                            break;
                        }
                        break;
                    case "1":
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\t\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0\n            ORDER BY Procedimiento ASC;";
                            break;
                        } else {
                            this.sql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\t\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "'\n            AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n            ORDER BY Procedimiento ASC;";
                            break;
                        }
                        break;
                    default:
                        if (this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            this.sql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n\t\t    WHERE f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY Procedimiento ASC; ";
                            break;
                        } else {
                            this.sql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,IF(g_procedimiento.`Id_TipoProcRIPS`=5,1,0) TipoR,g_procedimiento.`Es_Prioritario`, g_procedimiento.porcentajeImpuesto\n            , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \n \t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n\t\t    WHERE (f_empresacontxconvenio.Id ='" + idEmpresaCont + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + idServicio + "' \n\t\t\t    AND g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + this.frmFacturac.frmPersona.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate()) + "') <= g_procedimiento.EdadM)) \n\t\t       ORDER BY Procedimiento ASC; ";
                            break;
                        }
                        break;
                }
            }
        } else if (Principal.informacionIps.getAplicaNombreGenerico().booleanValue()) {
            this.sql = "SELECT i_suministro.Id, f_tarifasuministro.Codigo, IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`))  AS Suministro\n, round(IF(IFNULL(f_servicioempresaconv.`Incr_Decrem`,0) = 0, ROUND(f_tarifasuministro.Valor), \nround((f_tarifasuministro.Valor)+ ((f_tarifasuministro.Valor*(f_servicioempresaconv.`Incr_Decrem`/100)))) \n\n)) AS Valor\n, IF(i_suministro.EsMaterial=0,'NO','SI') AS Es_Material, IF(f_tarifasuministro.Id_TipoPlan=1,'POS','NO POS') AS Tipo,\n i_tipoproducto.Nbre AS Tipo_Producto, f_tarifasuministro.Id_TipoPlan AS IdPlan, '0',f_empresacontxconvenio.Id_Manual,0, 0, `i_suministro`.`Iva` \n , IFNULL(f_servicioempresaconv.`Incr_Decrem`,0)\n  ,  0  aplicaConsentimiento \n  FROM i_suministro \n INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id)  INNER JOIN `i_principioactivo`  ON (`i_principioactivo`.`Id` = `i_suministro`.`IdPrincipioActivo`) \n INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\n  INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) \n  INNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) \n  INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)  INNER JOIN  `i_formafarmaceutica`  ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n INNER JOIN  `i_presentacioncomercial`    ON (`i_presentacioncomercial`.`Id` = `i_suministro`.`IdPresentacionComercial`)  \n   INNER JOIN f_empresacontxconvenio ON (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \n   LEFT JOIN `f_servicioempresaconv` ON (f_servicioempresaconv.`Id_EmpresaConvenio`= f_empresacontxconvenio.Id) AND (f_servicioempresaconv.`Id_TipoServicio`=7)\n   \n   WHERE (i_suministro.EstaActivo =1 \n    AND f_empresacontxconvenio.Id =" + idEmpresaCont + "\n   ) ORDER BY Suministro";
        } else {
            this.sql = "SELECT i_suministro.Id, f_tarifasuministro.Codigo, CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) AS Suministro\n, round(IF(IFNULL(f_servicioempresaconv.`Incr_Decrem`,0) = 0, ROUND(f_tarifasuministro.Valor), \nround((f_tarifasuministro.Valor)+ ((f_tarifasuministro.Valor*(f_servicioempresaconv.`Incr_Decrem`/100)))) \n\n)) AS Valor\n, IF(i_suministro.EsMaterial=0,'NO','SI') AS Es_Material, IF(f_tarifasuministro.Id_TipoPlan=1,'POS','NO POS') AS Tipo,\n i_tipoproducto.Nbre AS Tipo_Producto, f_tarifasuministro.Id_TipoPlan AS IdPlan, '0',f_empresacontxconvenio.Id_Manual,0, 0, `i_suministro`.`Iva` \n , IFNULL(f_servicioempresaconv.`Incr_Decrem`,0)\n  ,  0  aplicaConsentimiento \n  FROM i_suministro \n INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \n INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\n  INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) \n  INNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) \n  INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n   INNER JOIN f_empresacontxconvenio ON (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \n   LEFT JOIN `f_servicioempresaconv` ON (f_servicioempresaconv.`Id_EmpresaConvenio`= f_empresacontxconvenio.Id) AND (f_servicioempresaconv.`Id_TipoServicio`=7)\n   \n   WHERE (i_suministro.EstaActivo =1 \n    AND f_empresacontxconvenio.Id =" + idEmpresaCont + "\n   ) ORDER BY Suministro";
        }
        System.out.println("procedi : " + this.sql);
        this.consultas.llenarComboTabla(this.sql, this.cboProcedSuministro, this.modcombos, 2);
        this.consultas.cerrarConexionBd();
    }

    private void CrearGridDetalle() {
        this.modelo = new DefaultTableModel() { // from class: Facturacion.Ordenes.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, Integer.class, String.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, true, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.gridDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Facturacion.Ordenes.3
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.modelo.addColumn("");
        this.modelo.addColumn("Servicio");
        this.modelo.addColumn("");
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Procedimiento o Suministro");
        this.modelo.addColumn("id");
        this.modelo.addColumn("Finalidad");
        this.modelo.addColumn("");
        this.modelo.addColumn("CentroCosto");
        this.modelo.addColumn("Cant.");
        this.modelo.addColumn("Vr. Unitario");
        this.modelo.addColumn("Vr. SubTotal");
        this.modelo.addColumn("Vr. Descuento");
        this.modelo.addColumn("Vr. Total");
        this.modelo.addColumn("");
        this.modelo.addColumn("Especialidad");
        this.modelo.addColumn("");
        this.modelo.addColumn("N° Autorización");
        this.modelo.addColumn("GP");
        this.modelo.addColumn("Id_Rechazo");
        this.modelo.addColumn("Observacion");
        this.modelo.addColumn("% Impuesto");
        this.modelo.addColumn("Vr. Impuesto");
        this.modelo.addColumn("Es Prioritario");
        this.modelo.addColumn("No. Prescripcion Mipres");
        this.modelo.addColumn("No. Entrega Mipres");
        this.modelo.addColumn("Código Grupo");
        this.modelo.addColumn("Nombre Grupo");
        this.modelo.addColumn("Código Servicio Rips");
        this.modelo.addColumn("Nombre Servicio Rips");
        this.modelo.addColumn("Consentimiento");
        this.gridDetalle.setAutoResizeMode(0);
        this.gridDetalle.doLayout();
        this.gridDetalle.setModel(this.modelo);
        this.gridDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.gridDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.gridDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.gridDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.gridDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.gridDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.gridDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.gridDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.gridDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.gridDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.gridDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.gridDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.gridDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.gridDetalle.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.gridDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.filaGridDetalle = 0;
    }

    private void CrearGridDetalle1() {
        this.modelon2 = new DefaultTableModel() { // from class: Facturacion.Ordenes.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelon2.addColumn("");
        this.modelon2.addColumn("Servicio");
        this.modelon2.addColumn("");
        this.modelon2.addColumn("Codigo");
        this.modelon2.addColumn("Procedimiento o Suministro");
        this.modelon2.addColumn("");
        this.modelon2.addColumn("Finalidad");
        this.modelon2.addColumn("");
        this.modelon2.addColumn("CentroCosto");
        this.modelon2.addColumn("Cant.");
        this.modelon2.addColumn("Vr. Unitario");
        this.modelon2.addColumn("Vr. SubTotal");
        this.modelon2.addColumn("Vr. Descuento");
        this.modelon2.addColumn("Vr. Total");
        this.modelon2.addColumn("");
        this.modelon2.addColumn("Especialidad");
        this.modelon2.addColumn("");
        this.modelon2.addColumn("% Impuesto");
        this.modelon2.addColumn("Vr. Impuesto");
        this.modelon2.addColumn("No. Prescripcion Mipres");
        this.modelon2.addColumn("No. Entrega Mipres");
        this.gridDetalle1.setModel(this.modelon2);
        this.gridDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.gridDetalle1.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(2).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.gridDetalle1.getColumnModel().getColumn(4).setPreferredWidth(500);
        this.gridDetalle1.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(5).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(5).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.gridDetalle1.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.gridDetalle1.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.gridDetalle1.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.gridDetalle1.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.gridDetalle1.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(14).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(14).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(15).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(15).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(16).setMinWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(16).setMaxWidth(0);
        this.gridDetalle1.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.gridDetalle1.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.gridDetalle1.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.gridDetalle1.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.filaGridDetalle1 = 0;
    }

    private void CrearGridTotales() {
        this.modelototales = new DefaultTableModel() { // from class: Facturacion.Ordenes.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelototales.addColumn("");
        this.modelototales.addColumn("Centro de Costo");
        this.modelototales.addColumn("");
        this.modelototales.addColumn("");
        this.modelototales.addColumn("Servicio");
        this.modelototales.addColumn("No. Item");
        this.modelototales.addColumn("Vr. Servicio");
        this.modelototales.addColumn("Vr. Descuento");
        this.modelototales.addColumn("Vr. Plan");
        this.modelototales.addColumn("Vr. No Plan");
        this.modelototales.addColumn("");
        this.modelototales.addColumn("Profesional");
        this.modelototales.addColumn("No. Orden");
        this.modelototales.addColumn("Estado");
        this.modelototales.addColumn("Especialidad");
        this.gridTotales.setModel(this.modelototales);
        this.gridTotales.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridTotales.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.gridTotales.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(2).setMaxWidth(0);
        this.gridTotales.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridTotales.getColumnModel().getColumn(4).setPreferredWidth(180);
        this.gridTotales.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.gridTotales.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.gridTotales.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.gridTotales.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.gridTotales.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.gridTotales.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(10).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(10).setMaxWidth(0);
        this.gridTotales.getColumnModel().getColumn(11).setPreferredWidth(170);
        this.gridTotales.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.gridTotales.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(13).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(13).setMaxWidth(0);
        this.gridTotales.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.gridTotales.getColumnModel().getColumn(14).setMinWidth(0);
        this.gridTotales.getColumnModel().getColumn(14).setMaxWidth(0);
        this.filaGridTotales = 0;
    }

    private void CrearGridTotales1() {
        this.modelon2t = new DefaultTableModel() { // from class: Facturacion.Ordenes.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelon2t.addColumn("");
        this.modelon2t.addColumn("Centro de Costo");
        this.modelon2t.addColumn("");
        this.modelon2t.addColumn("");
        this.modelon2t.addColumn("Servicio");
        this.modelon2t.addColumn("No. Item");
        this.modelon2t.addColumn("Vr. Servicio");
        this.modelon2t.addColumn("Vr. Descuento");
        this.modelon2t.addColumn("Vr. Plan");
        this.modelon2t.addColumn("Vr. No Plan");
        this.modelon2t.addColumn("");
        this.modelon2t.addColumn("Profesional");
        this.modelon2t.addColumn("No. Orden");
        this.modelon2t.addColumn("Estado");
        this.modelon2t.addColumn("Especialidad");
        this.gridTotales1.setModel(this.modelon2t);
        this.gridTotales1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridTotales1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.gridTotales1.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(2).setMaxWidth(0);
        this.gridTotales1.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridTotales1.getColumnModel().getColumn(4).setPreferredWidth(180);
        this.gridTotales1.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.gridTotales1.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.gridTotales1.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.gridTotales1.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.gridTotales1.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.gridTotales1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(10).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.gridTotales1.getColumnModel().getColumn(11).setPreferredWidth(170);
        this.gridTotales1.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.gridTotales1.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(13).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(13).setMaxWidth(0);
        this.gridTotales1.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.gridTotales1.getColumnModel().getColumn(14).setMinWidth(0);
        this.gridTotales1.getColumnModel().getColumn(14).setMaxWidth(0);
        this.filaGridTotales1 = 0;
    }

    private long getCalcularDescuento() {
        long VrDescuento = Math.round((Double.parseDouble(this.txtVrTotal.getValue().toString()) * getValorDescuento()) / 100.0d);
        return VrDescuento;
    }

    private String getCentroCosto(String id) {
        this.sql = "SELECT f_centrocosto.Nbre FROM f_procedimcentrocosto INNER JOIN f_centrocosto  ON (f_procedimcentrocosto.Id_CentroCosto = f_centrocosto.Id) WHERE (f_procedimcentrocosto.Id_Procedimiento ='" + id + "') ";
        this.sql = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return this.sql;
    }

    private String getFinalidadProc(String id) {
        this.sql = "SELECT concat(f_tipofinprocedimiento.Id, '-',f_tipofinprocedimiento.Nbre) Nbre FROM g_procedimiento INNER JOIN f_tipofinprocedimiento ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) WHERE (g_procedimiento.Id ='" + id + "')";
        this.sql = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return this.sql;
    }

    private String getTraerCodigo(String id) {
        if (getTipoServicio().equals("Es_Proc")) {
            this.sql = "SELECT Nbre FROM g_procedimiento WHERE (Id ='" + id + "' || C_Homologado='" + id + "' and g_procedimiento.Estado=0)";
        } else if (Principal.informacionIps.getAplicaNombreGenerico().booleanValue()) {
            this.sql = "SELECT IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`))  AS Sumnistro  FROM i_suministro \n INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id)  INNER JOIN `i_principioactivo`  ON (`i_principioactivo`.`Id` = `i_suministro`.`IdPrincipioActivo`) \n INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\n  INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) \n  INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)  INNER JOIN  `i_formafarmaceutica`  ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n INNER JOIN  `i_presentacioncomercial`    ON (`i_presentacioncomercial`.`Id` = `i_suministro`.`IdPresentacionComercial`)  \nWHERE (i_suministro.Id =" + id + " AND i_suministro.EstaActivo =1)";
        } else {
            this.sql = "SELECT CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) AS Sumnistro  FROM i_suministro \n INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id)  INNER JOIN `i_principioactivo`  ON (`i_principioactivo`.`Id` = `i_suministro`.`IdPrincipioActivo`) \n INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\n  INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) \n  INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)  INNER JOIN  `i_formafarmaceutica`  ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n INNER JOIN  `i_presentacioncomercial`    ON (`i_presentacioncomercial`.`Id` = `i_suministro`.`IdPresentacionComercial`)  \nWHERE (i_suministro.Id =" + id + " AND i_suministro.EstaActivo =1)";
        }
        this.sql = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return this.sql;
    }

    private double getValorDescuento() {
        int Fila = this.cboServicio.getSelectedIndex();
        double PorcDescuento = Double.parseDouble(this.cboServicio.getPopupTable().getValueAt(Fila, 2).toString());
        if (PorcDescuento != 0.0d) {
            this.btnDescuento.setEnabled(true);
        } else {
            this.btnDescuento.setEnabled(false);
        }
        return PorcDescuento;
    }

    public void grabar(String idIngreso) {
        int NoFilaT = this.gridTotales.getRowCount();
        double VrAcomulado = 0.0d;
        this.idIngreso = idIngreso;
        if (NoFilaT > 0) {
            for (int i = 1; i <= NoFilaT; i++) {
                String IdCC = this.gridTotales.getValueAt(i - 1, 0).toString();
                String IdServicio = this.gridTotales.getValueAt(i - 1, 2).toString();
                String TipoProc = this.gridTotales.getValueAt(i - 1, 3).toString();
                int NoItems = Integer.parseInt(this.gridTotales.getValueAt(i - 1, 5).toString());
                double VrServicio = Double.valueOf(this.gridTotales.getValueAt(i - 1, 6).toString()).doubleValue();
                double VrDescuento = Double.valueOf(this.gridTotales.getValueAt(i - 1, 7).toString()).doubleValue();
                double VrPlan = Double.valueOf(this.gridTotales.getValueAt(i - 1, 8).toString()).doubleValue();
                VrAcomulado += VrPlan;
                double VrPaciente = Double.valueOf(this.gridTotales.getValueAt(i - 1, 9).toString()).doubleValue();
                this.gridTotales.getValueAt(i - 1, 10).toString();
                int xtiporep = 0;
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (IdServicio.equals("2")) {
                        Object[] botones = {"Laboratorio", "Consultorio", "Humalib", "Cerrar"};
                        int m = JOptionPane.showInternalOptionDialog(this.frmFacturac, "El examen facturado, será procesado en:", "SELECCIONAR", 0, 3, (Icon) null, botones, "Cerrar");
                        switch (m) {
                            case 0:
                                xtiporep = 0;
                                break;
                            case 1:
                                xtiporep = 1;
                                break;
                            case 2:
                                xtiporep = 2;
                                break;
                        }
                        this.frmFacturac.clasefacturacion.setXlugarprocesamiento(xtiporep);
                    } else if (IdServicio.equals("3")) {
                        int n = JOptionPane.showConfirmDialog(this.frmFacturac, "El examen facturado, será realizado en la institución?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            xtiporep = 0;
                        } else {
                            xtiporep = 1;
                        }
                        this.frmFacturac.clasefacturacion.setXlugarprocesamiento(xtiporep);
                    }
                }
                int j = 0;
                while (true) {
                    if (j < this.gridDetalle.getRowCount()) {
                        if (!Boolean.valueOf(this.gridDetalle.getValueAt(j, 23).toString()).booleanValue()) {
                            j++;
                        } else {
                            setEsPrioritario(1);
                        }
                    }
                }
                this.sql = "INSERT INTO f_ordenes (Id_Ingreso,Id_TipoServicio,FechaOrden,HoraOrden,Id_Profesional,Id_Especialidad,Id_CentroCosto,TotalOrdenes,TotalEPS,TotalDescuento,TotalPaciente, EstadoRecep, LProcesamiento,EsPrioritaria, Fecha,UsuarioS) values(" + idIngreso + "," + IdServicio + ",'" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "'," + this.frmFacturac.frmIngreso.xIdProfesional[this.frmFacturac.frmIngreso.cboProfesional.getSelectedIndex()] + "," + this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()] + "," + IdCC + "," + VrServicio + "," + VrPlan + "," + VrDescuento + "," + VrPaciente + ",'" + xtiporep + "','" + xtiporep + "','" + getEsPrioritario() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String IdOrden = this.consultas.ejecutarSQLId(this.sql);
                setXidorden(IdOrden);
                this.consultas.cerrarConexionBd();
                mCambiarEstadoProcedimiento();
                this.gridTotales.setValueAt(IdOrden, i - 1, 12);
                this.gridTotales.setValueAt("Activa", i - 1, 13);
                grabarItemOrdenes(IdOrden, NoItems, TipoProc, IdServicio, idIngreso);
                try {
                    if (this.idHOrden.longValue() > 0) {
                        String sqlF = "UPDATE `h_ordenes` SET `id_f_ordenes` = '" + IdOrden + "', EstaEntregada=2 WHERE `Id` = '" + this.idHOrden + "'";
                        this.xct.ejecutarSQL(sqlF);
                        this.xct.cerrarConexionBd();
                        this.idHOrden = 0L;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (IdServicio.equals("2") || IdServicio.equals("5")) {
                    mGrabar_Rechazo();
                    if (this.frmFacturac.clasefacturacion.getXrecepcionalaboratorio() == 0) {
                        this.frmFacturac.clasefacturacion.cargarPantalla("Recepcion Laboratorio");
                        this.frmFacturac.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(this.frmFacturac.frmOrdenes.getXidorden());
                        this.frmFacturac.clasefacturacion.xjifrecepcionlab.buscarOrden();
                        this.frmFacturac.clasefacturacion.xjifrecepcionlab.setIdOrdenExterna(this.frmFacturac.getIdOrdenSimedis());
                    }
                }
            }
            if (!getIdCita().equals("null")) {
                actualizar_citas();
                buscarCitasUsuario(this.frmFacturac.frmPersona.getIdPersona());
            }
            mVerificarProcEsCita();
            setEsPrioritario(0);
            return;
        }
        this.metodos.mostrarMensaje("Por favor adicione procedimientos");
    }

    private void mGrabar_Rechazo() {
        if (this.metodos.mVerificarDatosTablaTrue(this.gridDetalle, 18, "false")) {
            this.sql = "insert into l_rechazo (`FechaR`, `Id_Usuario`,`Id_Ingreso`, `Id_UsuarioS`    , `UsuarioS` ) Values('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmFacturac.frmPersona.getIdPersona() + "','" + this.frmFacturac.frmIngreso.getIdIngreso() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xid_rechazo = this.consultas.ejecutarSQLId(this.sql);
            this.consultas.cerrarConexionBd();
            this.frmFacturac.clasefacturacion.setxId_Rechazo(Long.valueOf(xid_rechazo).longValue());
            for (int f = 0; f < this.gridDetalle.getRowCount(); f++) {
                if (this.gridDetalle.getValueAt(f, 18).equals(false)) {
                    this.sql = "insert into l_rechazo_detalle(`Id_Rechazo`, `Id_Procedimiento`, `Cantidad`, `Id_TipoRechazo`, `Observacion`, `UsuarioS` ) values('" + xid_rechazo + "','" + this.modelo.getValueAt(f, 3) + "','" + this.modelo.getValueAt(f, 9) + "','" + this.modelo.getValueAt(f, 19) + "','" + this.modelo.getValueAt(f, 20) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
            }
        }
    }

    public void grabar1(String idIngreso) {
        int NoFilaT = this.gridTotales1.getRowCount();
        double VrAcomulado = 0.0d;
        if (NoFilaT > 0) {
            for (int i = 1; i <= NoFilaT; i++) {
                String IdCC = this.gridTotales1.getValueAt(i - 1, 0).toString();
                String IdServicio = this.gridTotales1.getValueAt(i - 1, 2).toString();
                String TipoProc = this.gridTotales1.getValueAt(i - 1, 3).toString();
                int NoItems = Integer.parseInt(this.gridTotales1.getValueAt(i - 1, 5).toString());
                double VrServicio = Double.valueOf(this.gridTotales1.getValueAt(i - 1, 6).toString()).doubleValue();
                double VrDescuento = Double.valueOf(this.gridTotales1.getValueAt(i - 1, 7).toString()).doubleValue();
                double VrPlan = Double.valueOf(this.gridTotales1.getValueAt(i - 1, 8).toString()).doubleValue();
                VrAcomulado += VrPlan;
                double VrPaciente = Double.valueOf(this.gridTotales1.getValueAt(i - 1, 9).toString()).doubleValue();
                String idProfesional = this.gridTotales1.getValueAt(i - 1, 10).toString();
                int xtiporep = 0;
                if (Principal.informacionIps.getEsFpz().intValue() == 0 && IdServicio.equals("2")) {
                    Object[] botones = {"Laboratorio", "Consultorio", "Humalib", "Cerrar"};
                    int m = JOptionPane.showInternalOptionDialog(this, "El examen facturado, será procesado en:", "SELECCIONAR", 0, 3, (Icon) null, botones, "Cerrar");
                    switch (m) {
                        case 0:
                            xtiporep = 0;
                            break;
                        case 1:
                            xtiporep = 1;
                            break;
                        case 2:
                            xtiporep = 2;
                            break;
                    }
                    this.frmFacturac.clasefacturacion.setXlugarprocesamiento(xtiporep);
                }
                this.sql = "INSERT INTO f_ordenes (Id_Ingreso,Id_TipoServicio,FechaOrden,HoraOrden,Id_Profesional,Id_Especialidad,Id_CentroCosto,TotalOrdenes,TotalEPS,TotalDescuento,TotalPaciente, EstadoRecep, LProcesamiento, Fecha,UsuarioS) values(" + idIngreso + "," + IdServicio + ",'" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "'," + idProfesional + "," + this.gridTotales1.getValueAt(i - 1, 14).toString() + "," + IdCC + "," + VrServicio + "," + VrPlan + "," + VrDescuento + "," + VrPaciente + ",'" + xtiporep + "','" + xtiporep + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String IdOrden = this.consultas.ejecutarSQLId(this.sql);
                setXidorden(IdOrden);
                this.consultas.cerrarConexionBd();
                mCambiarEstadoProcedimiento();
                this.gridTotales1.setValueAt(IdOrden, i - 1, 12);
                this.gridTotales1.setValueAt("Activa", i - 1, 13);
                if (this.gridTotales1.getValueAt(i - 1, 2).toString().equals("2") || this.gridTotales1.getValueAt(i - 1, 2).toString().equals("5")) {
                    this.frmFacturac.clasefacturacion.setXrecepcionalaboratorio(0);
                }
                grabarItemOrdenes1(IdOrden, NoItems, TipoProc, IdServicio);
                if ((IdServicio.equals("2") || IdServicio.equals("5")) && this.frmFacturac.clasefacturacion.getXrecepcionalaboratorio() == 0) {
                    this.frmFacturac.clasefacturacion.cargarPantalla("Recepcion Laboratorio");
                    this.frmFacturac.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(this.frmFacturac.frmOrdenes.getXidorden());
                    this.frmFacturac.clasefacturacion.xjifrecepcionlab.buscarOrden();
                }
                this.metodos.getInterceptor(Long.valueOf(idIngreso), "GRABAR ORDEN", "Se graba orden y su detalle", false);
            }
            if (!getIdCita().equals("null")) {
                actualizar_citas();
                buscarCitasUsuario(this.frmFacturac.frmPersona.getIdPersona());
            }
            mVerificarProcEsCita();
            this.metodos.mostrarMensaje("Guardo Exitosamente");
            return;
        }
        this.metodos.mostrarMensaje("Por favor adicione procedimientos");
    }

    private void mCambiarEstadoProcedimiento() {
        if (!this.xactualizarestadopro.equals("0")) {
            this.sql = "Update h_ordenes set EstaEntregada=1  where id='" + this.xactualizarestadopro + "'";
            this.xct.ejecutarSQL(this.sql);
            this.xct.cerrarConexionBd();
        }
    }

    public void mVerificarProcEsCita() {
        if (this.gridDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.gridDetalle.getRowCount(); x++) {
                if (this.modelo.getValueAt(x, 16).toString().equals("true") || this.modelo.getValueAt(x, 16).toString().equals("1")) {
                    this.frmFacturac.xesconsulta = true;
                    return;
                }
            }
        }
    }

    private void grabarItemOrdenes(String IdOrden, int NoItem, String TipoProc, String IdServicio, String xidingreso) {
        int i = 1;
        int j = 1;
        int NoFilaD = this.gridDetalle.getRowCount();
        while (i <= NoFilaD && j <= NoItem) {
            if (this.gridDetalle.getValueAt(i - 1, 0).toString().equals(IdServicio)) {
                if (TipoProc.equals("Es_Proc")) {
                    this.sql = "INSERT INTO f_itemordenesproced (Id_Ordenes,Id_Procedimiento,Id_TipofinProc,Cantidad,ValorUnitario,ValorDescuento,Id_CentroCosto, NAutorizacion,porcentajeImpuesto,valorImpuesto, idModalidadAtencion, idServicioRips, idMipres, Fecha,UsuarioS) values(" + IdOrden + "," + this.gridDetalle.getValueAt(i - 1, 3).toString() + ",'" + this.gridDetalle.getValueAt(i - 1, 5).toString() + "'," + this.gridDetalle.getValueAt(i - 1, 9).toString() + "," + this.gridDetalle.getValueAt(i - 1, 10).toString() + "," + this.gridDetalle.getValueAt(i - 1, 12).toString() + "," + this.gridDetalle.getValueAt(i - 1, 7).toString() + ",'" + this.gridDetalle.getValueAt(i - 1, 17).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 21).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 22).toString() + "','" + this.frmFacturac.frmIngreso.listGModalidadatencions.get(this.frmFacturac.frmIngreso.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.gridDetalle.getValueAt(i - 1, 28).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 25).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    if (!this.xactualizarestadopro.equals("0") && this.gridOrdMed.getSelectedRow() != -1) {
                        this.sql = "Update h_itemordenesproced set Id_Orden_Fac='" + IdOrden + "'  where Id_HOrdenes='" + this.xactualizarestadopro + "' and Id_Procedimiento='" + this.gridDetalle.getValueAt(i - 1, 3).toString() + "'";
                        this.xct.ejecutarSQL(this.sql);
                        this.xct.cerrarConexionBd();
                    }
                } else {
                    this.sql = "INSERT INTO f_itemordenessum (Id_Ordenes,Id_Suministro,Cantidad,ValorUnit,ValorDesc,EsCobrable,porcentajeImpuesto,valorImpuesto,idPrescripcionMipres,idEntregaMipres, idModalidadAtencion, idServicioRips,Fecha,UsuarioS) values(" + IdOrden + "," + this.gridDetalle.getValueAt(i - 1, 3).toString() + "," + this.gridDetalle.getValueAt(i - 1, 9).toString() + "," + this.gridDetalle.getValueAt(i - 1, 10).toString() + "," + this.gridDetalle.getValueAt(i - 1, 12).toString() + ",1,'" + this.gridDetalle.getValueAt(i - 1, 21).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 22).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 24).toString() + "','" + this.gridDetalle.getValueAt(i - 1, 25).toString() + "','" + this.frmFacturac.frmIngreso.listGModalidadatencions.get(this.frmFacturac.frmIngreso.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.gridDetalle.getValueAt(i - 1, 28).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
                if (this.JTTratamientos.getSelectedRow() != -1) {
                    this.sql = "Update o_hc_tratamiento_procedimiento set Id_Ingreso='" + xidingreso + "' where Id_Tratamiento='" + this.JTTratamientos.getValueAt(this.JTTratamientos.getSelectedRow(), 0).toString() + "' and IdProcedimiento='" + this.gridDetalle.getValueAt(i - 1, 3).toString() + "' and Id_Ingreso=0";
                    this.xct.ejecutarSQL(this.sql);
                    this.xct.cerrarConexionBd();
                }
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    private void grabarItemOrdenes1(String IdOrden, int NoItem, String TipoProc, String IdServicio) {
        int i = 1;
        int j = 1;
        int NoFilaD = this.gridDetalle1.getRowCount();
        while (i <= NoFilaD && j <= NoItem) {
            if (this.gridDetalle1.getValueAt(i - 1, 0).toString().equals(IdServicio)) {
                if (TipoProc.equals("Es_Proc")) {
                    this.sql = "INSERT INTO f_itemordenesproced (Id_Ordenes,Id_Procedimiento,Id_TipofinProc,Cantidad,ValorUnitario,ValorDescuento,Id_CentroCosto,porcentajeImpuesto,valorImpuesto,Fecha,UsuarioS) values(" + IdOrden + "," + this.gridDetalle1.getValueAt(i - 1, 3).toString() + ",'" + this.gridDetalle1.getValueAt(i - 1, 5).toString() + "'," + this.gridDetalle1.getValueAt(i - 1, 9).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 10).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 12).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 7).toString() + ",'" + this.gridDetalle1.getValueAt(i - 1, 17).toString() + "','" + this.gridDetalle1.getValueAt(i - 1, 18).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    if (!this.xactualizarestadopro.equals("0")) {
                        this.sql = "Update h_itemordenesproced set Id_Orden_Fac='" + IdOrden + "'  where id='" + this.xactualizarestadopro + "' and Id_Procedimiento='" + this.gridDetalle1.getValueAt(i - 1, 3).toString() + "'";
                        this.xct.ejecutarSQL(this.sql);
                        this.xct.cerrarConexionBd();
                    }
                } else {
                    this.sql = "INSERT INTO f_itemordenessum (Id_Ordenes,Id_Suministro,Cantidad,ValorUnit,ValorDesc,EsCobrable,porcentajeImpuesto,valorImpuesto,idPrescripcionMipres,idEntregaMipres,Fecha,UsuarioS) values(" + IdOrden + "," + this.gridDetalle1.getValueAt(i - 1, 3).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 9).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 10).toString() + "," + this.gridDetalle1.getValueAt(i - 1, 12).toString() + ",0,'" + this.gridDetalle1.getValueAt(i - 1, 17).toString() + "','" + this.gridDetalle1.getValueAt(i - 1, 18).toString() + "','" + this.gridDetalle1.getValueAt(i - 1, 19).toString() + "','" + this.gridDetalle1.getValueAt(i - 1, 20).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    private void limpiar() {
        this.btnDescuento.setSelected(false);
        CargarCombos();
        this.txtCantidad.setText("1");
        this.txtVrTotal.setText("0");
        this.txtVrTotal.setValue(new Integer(0));
        this.txtVrTotal.setText("0");
        this.JTFFDescuento.setValue(new Integer(0));
        this.txtVrUnitario.setText("0");
        this.txtVrUnitario.setValue(new Integer(0));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    public void nuevo() {
        this.xlleno = false;
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        CargarCombos();
        setIdCita("null");
        this.xlleno = true;
        CrearGridDetalle();
        CrearGridTotales();
        CrearGridDetalle1();
        CrearGridTotales1();
        this.gridOrdMed.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridCita1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridCita2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        mModeloTratamiento();
        this.txtCodigo.setText("");
        this.txtCantidad.setText("1");
        this.JSPPImpuesto.setValue(new Float(0.0f));
        this.JTFF_VTotalImpuesto.setValue(0);
        cargarCboservicio(this.idEmpresaCont);
        this.consultas.llenarComboTabla(this.sql, this.cboProcedSuministro, this.modcombos, 2);
        this.xactualizarestadopro = "0";
        this.xidclasecita = "0";
        this.xEsTipoCita = 0;
        this.esPrioritario = 0;
        setXidorden("0");
        this.JLBIngreso.setText("");
        mSeleccionar_Datos();
    }

    public void anular(String idMotivo, String Observacion, Integer forma) {
        ResultSet xrs;
        if (forma.intValue() == 1) {
            try {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                this.sql = "SELECT f_ordenes.Id_OrdenRecep FROM l_recepcion INNER JOIN f_ordenes  ON (l_recepcion.Id = f_ordenes.Id_OrdenRecep) WHERE (f_ordenes.Id_OrdenRecep <>0 AND f_ordenes.Id in(" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdOrdenes() + ") AND l_recepcion.Estado =0 AND f_ordenes.Estado =0) ";
                xrs = xct1.traerRs(this.sql);
                Throwable th = null;
                try {
                    try {
                        if (xrs.next()) {
                            int x = JOptionPane.showConfirmDialog((Component) null, "Orden con recepción activa;\nDesea anular?", "ANULACIÓN DE RECEPCIÓN DE LABORATORIO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                ConsultasMySQL xct2 = new ConsultasMySQL();
                                this.sql = "update l_recepcion set Estado=1 where Id='" + xrs.getString(1) + "'";
                                xct2.ejecutarSQL(this.sql);
                                xct2.cerrarConexionBd();
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
                        xct1.cerrarConexionBd();
                        this.sql = "UPDATE f_ordenes SET Estado=1, `Id_MotivoAnulacion`='" + idMotivo + "' , `Fecha_Anulacion`=now() , `Detalle_Anulacion`='" + Observacion + "' , `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE Id in('" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdOrdenes() + "')";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.sql = "UPDATE `c_citas` SET `Id_Ingreso`=0, `Asistida` = 0 WHERE `Id_Ingreso`='" + Principal.txtNo.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.sql = "UPDATE `c_citas` SET `Id_Ingreso`=0, `Asistida` = 0 WHERE `Id_ingresoReal`='" + Principal.txtNo.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.metodos.getInterceptor(Long.valueOf(Principal.txtNo.getText()), "ANULACIÓN ORDEN", Observacion, false);
                        return;
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        if (this.gridTotales.getRowCount() > 0 && this.gridTotales.getSelectedRow() > -1) {
            try {
                ConsultasMySQL xct12 = new ConsultasMySQL();
                this.sql = "SELECT f_ordenes.Id_OrdenRecep FROM l_recepcion INNER JOIN f_ordenes  ON (l_recepcion.Id = f_ordenes.Id_OrdenRecep) WHERE (f_ordenes.Id_OrdenRecep <>0 AND f_ordenes.Id ='" + this.gridTotales.getValueAt(this.gridTotales.getSelectedRow(), 12) + "' AND l_recepcion.Estado =0 AND f_ordenes.Estado =0) ";
                xrs = xct12.traerRs(this.sql);
                Throwable th4 = null;
                try {
                    try {
                        if (xrs.next()) {
                            int x2 = JOptionPane.showConfirmDialog((Component) null, "Orden con recepción activa;\nDesea anular?", "ANULACIÓN DE RECEPCIÓN DE LABORATORIO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x2 == 0) {
                                ConsultasMySQL xct22 = new ConsultasMySQL();
                                this.sql = "update l_recepcion set Estado=1 where Id='" + xrs.getString(1) + "'";
                                xct22.ejecutarSQL(this.sql);
                                xct22.cerrarConexionBd();
                            }
                        }
                        if (xrs != null) {
                            if (0 != 0) {
                                try {
                                    xrs.close();
                                } catch (Throwable th5) {
                                    th4.addSuppressed(th5);
                                }
                            } else {
                                xrs.close();
                            }
                        }
                        xct12.cerrarConexionBd();
                        this.sql = "UPDATE f_ordenes SET Estado=1, `Id_MotivoAnulacion`='" + idMotivo + "' , `Fecha_Anulacion`=now() , `Detalle_Anulacion`='" + Observacion + "' , `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE Id=" + this.gridTotales.getValueAt(this.gridTotales.getSelectedRow(), 12);
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.sql = "UPDATE `c_citas` SET `Id_Ingreso`=0, `Asistida` = 0 WHERE `Id_Ingreso`='" + Principal.txtNo.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.sql = "UPDATE `c_citas` SET `Id_Ingreso`=0, `Asistida` = 0 WHERE `Id_ingresoReal`= '" + Principal.txtNo.getText() + "'";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.metodos.getInterceptor(Long.valueOf(Principal.txtNo.getText()), "ANULACIÓN ORDEN", Observacion, false);
                        this.metodos.mostrarMensaje("Se ha Anulado la Orden No: " + this.gridTotales.getValueAt(this.gridTotales.getSelectedRow(), 12));
                        nuevo();
                        return;
                    } finally {
                    }
                } catch (Throwable th6) {
                    th4 = th6;
                    throw th6;
                }
            } catch (SQLException ex2) {
                Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                return;
            }
        }
        this.metodos.mostrarMensaje("Por favor Seleccione una orden");
    }

    private void Sumar_RestarTotales(int tipoOperacion) {
        if (this.modelototales.getRowCount() == 0) {
            adicionarUnicoRegistro();
            this.filaGridTotales++;
            return;
        }
        int NoFilas = verificarServicio(getIdServicio());
        if (NoFilas == -1) {
            adicionarUnicoRegistro();
            this.filaGridTotales++;
        } else {
            actualizarUnicoRegistro(NoFilas, tipoOperacion, -1);
        }
    }

    private void Sumar_RestarTotales1(int tipoOperacion) {
        if (this.modelon2t.getRowCount() == 0) {
            adicionarUnicoRegistro1();
            this.filaGridTotales1++;
            return;
        }
        int NoFilas = verificarServicio(getIdServicio());
        if (NoFilas == -1) {
            adicionarUnicoRegistro1();
            this.filaGridTotales1++;
        } else {
            actualizarUnicoRegistro1(NoFilas, tipoOperacion, -1);
        }
    }

    public void cargar_detalle(String id_Orden, int Tipo) {
        CrearGridDetalle();
        int NoFila = 0;
        try {
            if (Tipo == 0) {
                this.sql = "SELECT f_ordenes.Id_TipoServicio , f_tiposervicio.Nbre AS Tipo_Servicio , f_itemordenesproced.Id_Procedimiento, g_procedimiento.Nbre AS Procedimiento, f_itemordenesproced.Id_TipofinProc, f_tipofinprocedimiento.Nbre AS FinProc, f_itemordenesproced.Id_CentroCosto, f_centrocosto.Nbre AS CentroCosto, f_itemordenesproced.Cantidad, f_itemordenesproced.ValorUnitario, ((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto) AS Subtotal, f_itemordenesproced.ValorDescuento, (((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto)-f_itemordenesproced.ValorDescuento) AS Total, w_profesional.Especialidad, f_itemordenesproced.porcentajeImpuesto, f_itemordenesproced.valorImpuesto, '' AS idPrescripcionMipres, '' AS idEntregaMipres, ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips  FROM f_ordenes INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN w_profesional ON (f_ordenes.Id_Profesional = w_profesional.Id_Persona) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipofinprocedimiento ON (f_itemordenesproced.Id_TipofinProc = f_tipofinprocedimiento.Id) INNER JOIN f_centrocosto ON (f_itemordenesproced.Id_CentroCosto = f_centrocosto.Id) AND (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) inner join g_modalidad_atencion gma on (gma.id=f_itemordenesproced.idModalidadAtencion)\ninner join g_servicios_rips gsr on (gsr.id=f_itemordenesproced.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\nWHERE (f_ordenes.Id=" + id_Orden + " AND f_ordenes.Id_Especialidad=w_profesional.IdEspecialidad) ORDER BY Procedimiento ASC;";
            } else {
                this.sql = "SELECT f_ordenes.Id_TipoServicio , f_tiposervicio.Nbre, f_itemordenessum.Id_Suministro, CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) AS Sumnistro, 0 AS idFinalidad, 'No Aplica' AS Finalidad, 0 AS idCC, 'No Aplica' AS CentroCosto, f_itemordenessum.Cantidad, f_itemordenessum.ValorUnit, ((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto) AS Subtotal, f_itemordenessum.ValorDesc, (((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)-f_itemordenessum.ValorDesc) AS Total, w_profesional.Especialidad, f_itemordenessum.porcentajeImpuesto, f_itemordenessum.valorImpuesto, f_itemordenessum.idPrescripcionMipres, f_itemordenessum.idEntregaMipres , ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips FROM f_ordenes INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN w_profesional ON (f_ordenes.Id_Profesional = w_profesional.Id_Persona) INNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) inner join g_modalidad_atencion gma on (gma.id=f_itemordenessum.idModalidadAtencion)\ninner join g_servicios_rips gsr on (gsr.id=f_itemordenessum.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\nWHERE (f_ordenes.Id=" + id_Orden + " AND f_ordenes.Id_Especialidad=w_profesional.IdEspecialidad)";
            }
            this.rs = this.consultas.traerRs(this.sql);
            while (this.rs.next()) {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(this.rs.getString(1), NoFila, 0);
                this.modelo.setValueAt(this.rs.getString(2), NoFila, 1);
                if (Tipo == 0) {
                    this.modelo.setValueAt("Es_Proc", NoFila, 2);
                } else {
                    this.modelo.setValueAt("Es_Sum", NoFila, 2);
                }
                this.modelo.setValueAt(this.rs.getString(3), NoFila, 3);
                this.modelo.setValueAt(this.rs.getString(4), NoFila, 4);
                this.modelo.setValueAt(this.rs.getString(5), NoFila, 5);
                this.modelo.setValueAt(this.rs.getString(6), NoFila, 6);
                this.modelo.setValueAt(this.rs.getString(7), NoFila, 7);
                this.modelo.setValueAt(this.rs.getString(8), NoFila, 8);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(9)), NoFila, 9);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong(10)), NoFila, 10);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong(11)), NoFila, 11);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong(12)), NoFila, 12);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong(13)), NoFila, 13);
                this.modelo.setValueAt(this.rs.getString(14), NoFila, 15);
                this.modelo.setValueAt(Double.valueOf(this.rs.getDouble("porcentajeImpuesto")), NoFila, 21);
                this.modelo.setValueAt(Double.valueOf(this.rs.getDouble("valorImpuesto")), NoFila, 22);
                this.modelo.setValueAt(this.rs.getString("idPrescripcionMipres"), NoFila, 24);
                this.modelo.setValueAt(this.rs.getString("idEntregaMipres"), NoFila, 25);
                this.modelo.setValueAt(this.rs.getString("idGrupo"), NoFila, 26);
                this.modelo.setValueAt(this.rs.getString("nombreGrupo"), NoFila, 27);
                this.modelo.setValueAt(this.rs.getString("idServicioRips"), NoFila, 28);
                this.modelo.setValueAt(this.rs.getString("nombreServicioRips"), NoFila, 29);
                NoFila++;
                this.modelototales.setValueAt(Integer.valueOf(NoFila), 0, 5);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void cargar_Orden_Fact(String id_Orden, int Tipo) {
        ConsultasMySQL xct;
        ResultSet xrs;
        Throwable th;
        try {
            this.sql = "SELECT f_ordenes.Id , f_ordenes.FechaOrden , f_ordenes.Id_CentroCosto , w_centrocosto.Nbre , f_ordenes.Id_TipoServicio, f_tiposervicio.Nbre, f_ordenes.TotalOrdenes, f_ordenes.TotalDescuento, f_ordenes.TotalEPS, f_ordenes.TotalPaciente, f_ordenes.Id_Profesional, w_profesional.NProfesional, IF(f_ordenes.Estado=0,'Activa','Anulada') as Estado,w_profesional.Especialidad FROM f_ordenes  INNER JOIN w_centrocosto ON (f_ordenes.Id_CentroCosto = w_centrocosto.Id) INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN w_profesional ON (f_ordenes.Id_Profesional = w_profesional.Id_Persona) WHERE (f_ordenes.Id =" + id_Orden + " AND f_ordenes.Id_Especialidad=w_profesional.IdEspecialidad)";
            xct = new ConsultasMySQL();
            xrs = xct.traerRs(this.sql);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (xrs.next()) {
                    this.txtFecha.setDate(xrs.getDate(2));
                    CrearGridTotales();
                    this.modelototales.addRow(this.datosTotales);
                    this.modelototales.setValueAt(xrs.getString(3), 0, 0);
                    this.modelototales.setValueAt(xrs.getString(4), 0, 1);
                    this.modelototales.setValueAt(xrs.getString(5), 0, 2);
                    if (Tipo == 0) {
                        this.modelototales.setValueAt("Es_Proc", 0, 3);
                    } else {
                        this.modelototales.setValueAt("Es_Sum", 0, 3);
                    }
                    this.modelototales.setValueAt(xrs.getString(6), 0, 4);
                    this.modelototales.setValueAt(Long.valueOf(xrs.getLong(7)), 0, 6);
                    this.modelototales.setValueAt(Long.valueOf(xrs.getLong(8)), 0, 7);
                    this.modelototales.setValueAt(Long.valueOf(xrs.getLong(9)), 0, 8);
                    this.modelototales.setValueAt(Long.valueOf(xrs.getLong(10)), 0, 9);
                    this.modelototales.setValueAt(xrs.getString(11), 0, 10);
                    this.modelototales.setValueAt(xrs.getString(12), 0, 11);
                    this.modelototales.setValueAt(xrs.getString(1), 0, 12);
                    this.modelototales.setValueAt(xrs.getString(13), 0, 13);
                    this.modelototales.setValueAt(xrs.getString(14), 0, 14);
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
                xct.cerrarConexionBd();
                cargar_detalle(id_Orden, Tipo);
            } finally {
            }
        } finally {
        }
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.cboServicio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Servicio");
            this.cboServicio.requestFocus();
        } else if (this.cboProcedSuministro.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione Procedimiento o Suministro");
            this.cboProcedSuministro.requestFocus();
        } else if (Integer.parseInt(this.txtCantidad.getText()) == 0) {
            this.metodos.mostrarMensaje("Por favor digite la Cantidad Correcta");
            this.txtCantidad.requestFocus();
        } else if (getTipoServicio().equals("Es_Proc") && this.cboCentroCosto.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor Seleccione el Centro de Costo del Procedimiento");
            this.cboCentroCosto.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public void validar_perderfoco() {
        if (Integer.parseInt(this.txtCantidad.getText()) > 0) {
            calcularValorTotalProc_Sum();
            return;
        }
        this.txtCantidad.selectAll();
        this.txtVrTotal.setText("");
        this.txtCantidad.requestFocus();
    }

    public void adicionarDetallePaquete(String codProc, String nbreProc, String codFinal, String codCC, String idServicio, String nbreServicio, String tipoServicio, String tipoPlan, int cant, int valor, int descuento, String idpaquete, String idespecial, String escita, double porcentajeImpuesto, boolean es_prioritario) {
        if (verificarProc_Sum(codProc) == 0) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(idServicio, this.filaGridDetalle, 0);
            this.modelo.setValueAt(nbreServicio, this.filaGridDetalle, 1);
            this.modelo.setValueAt(tipoServicio, this.filaGridDetalle, 2);
            this.modelo.setValueAt(codProc, this.filaGridDetalle, 3);
            this.modelo.setValueAt(nbreProc, this.filaGridDetalle, 4);
            this.modelo.setValueAt(codFinal, this.filaGridDetalle, 5);
            this.modelo.setValueAt(getFinalidadProc(codProc), this.filaGridDetalle, 6);
            this.modelo.setValueAt(codCC, this.filaGridDetalle, 7);
            this.modelo.setValueAt(getCentroCosto(codProc), this.filaGridDetalle, 8);
            this.modelo.setValueAt(tipoPlan, this.filaGridDetalle, 14);
            this.modelo.setValueAt(Integer.valueOf(cant), this.filaGridDetalle, 9);
            this.modelo.setValueAt(Integer.valueOf(valor), this.filaGridDetalle, 10);
            this.modelo.setValueAt(Double.valueOf((((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento))), this.filaGridDetalle, 11);
            this.modelo.setValueAt(Integer.valueOf(descuento), this.filaGridDetalle, 12);
            this.modelo.setValueAt(Double.valueOf((((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento))), this.filaGridDetalle, 13);
            this.modelo.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridDetalle, 15);
            this.modelo.setValueAt(escita, this.filaGridDetalle, 16);
            this.modelo.setValueAt("", this.filaGridDetalle, 17);
            this.modelo.setValueAt(true, this.filaGridDetalle, 18);
            this.modelo.setValueAt("1", this.filaGridDetalle, 19);
            this.modelo.setValueAt(Double.valueOf(porcentajeImpuesto), this.filaGridDetalle, 21);
            this.modelo.setValueAt(Double.valueOf(((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)), this.filaGridDetalle, 22);
            this.modelo.setValueAt(Boolean.valueOf(es_prioritario), this.filaGridDetalle, 23);
            int encontrado = 0;
            for (int g = 0; g < this.modelototales.getRowCount(); g++) {
                if (this.modelototales.getValueAt(g, 2).toString().equals(idServicio)) {
                    encontrado = 1;
                    this.filaGridTotales = g;
                }
            }
            if (encontrado == 0) {
                this.modelototales.addRow(this.datosTotales);
                this.modelototales.setValueAt(codCC, this.filaGridTotales, 0);
                this.modelototales.setValueAt(getCentroCosto(codProc), this.filaGridTotales, 1);
                this.modelototales.setValueAt(idServicio, this.filaGridTotales, 2);
                this.modelototales.setValueAt(tipoServicio, this.filaGridTotales, 3);
                this.modelototales.setValueAt(nbreServicio, this.filaGridTotales, 4);
                this.modelototales.setValueAt(1, this.filaGridTotales, 5);
                this.modelototales.setValueAt(Double.valueOf((((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento))), this.filaGridTotales, 6);
                this.modelototales.setValueAt(this.frmFacturac.frmIngreso.xIdProfesional[this.frmFacturac.frmIngreso.cboProfesional.getSelectedIndex()], this.filaGridTotales, 10);
                this.modelototales.setValueAt(this.frmFacturac.frmIngreso.cboProfesional.getSelectedItem(), this.filaGridTotales, 11);
                this.modelototales.setValueAt(this.frmFacturac.frmIngreso.xidEspecialidad[this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex()], this.filaGridTotales, 14);
                this.modelototales.setValueAt(Integer.valueOf(descuento), this.filaGridTotales, 7);
                if (getidPlanEmpresaCont().equals(tipoPlan)) {
                    this.modelototales.setValueAt(Double.valueOf((((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento))), this.filaGridTotales, 8);
                } else {
                    this.modelototales.setValueAt(Double.valueOf((((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento))), this.filaGridTotales, 9);
                }
                this.filaGridTotales++;
            } else {
                int item = Integer.parseInt(this.modelototales.getValueAt(this.filaGridTotales, 5).toString()) + 1;
                double vrtotal = Double.valueOf(this.modelototales.getValueAt(this.filaGridTotales, 6).toString()).doubleValue() + (((((double) valor) * porcentajeImpuesto) / 100.0d) * ((double) cant)) + ((double) ((cant * valor) - descuento));
                this.modelototales.setValueAt(Integer.valueOf(item), this.filaGridTotales, 5);
                this.modelototales.setValueAt(Double.valueOf(vrtotal), this.filaGridTotales, 6);
                if (getidPlanEmpresaCont().equals(tipoPlan)) {
                    this.modelototales.setValueAt(Double.valueOf(vrtotal), this.filaGridTotales, 8);
                } else {
                    this.modelototales.setValueAt(Double.valueOf(vrtotal), this.filaGridTotales, 9);
                }
                this.filaGridTotales++;
            }
            this.filaGridDetalle++;
            setValidarDatos(this.filaGridDetalle);
            return;
        }
        this.metodos.mostrarMensaje("Este Procedimiento o Suministro ya se encuentra agregado");
    }

    public void verificarCodProcSum() {
        if (getTraerCodigo(this.txtCodigo.getText()).equals("")) {
            this.metodos.mostrarMensaje("Codigo no Existe");
            cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
            limpiar();
            return;
        }
        for (int i = 0; i < this.cboProcedSuministro.getPopupTable().getModel().getRowCount(); i++) {
            String codigo = this.cboProcedSuministro.getPopupTable().getModel().getValueAt(i, 0).toString();
            if (codigo.equals(this.txtCodigo.getText())) {
                this.cboProcedSuministro.setSelectedIndex(i);
                return;
            }
        }
    }

    private int verificarProc_Sum(String Id) {
        int retorno = 0;
        if (this.filaGridDetalle > 0) {
            for (int i = 0; retorno == 0 && i < this.filaGridDetalle; i++) {
                if (Id.equals(this.modelo.getValueAt(i, 3).toString())) {
                    retorno = 1;
                }
            }
        }
        return retorno;
    }

    private void buscarProcSum() {
        if (this.cboServicio.getSelectedIndex() > -1) {
            if (getTipoServicio().equals("Es_Proc")) {
                BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, this, "Facturacion");
                frmBuscarProced.setVisible(true);
                return;
            } else {
                BuscarSum frmBuscarSum = new BuscarSum(null, true, this);
                frmBuscarSum.setVisible(true);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.cboServicio.requestFocus();
    }

    private void verifSelEmpresaCitas() {
        this.frmFacturac.frmIngreso.cboEmpresa.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 15));
        this.frmFacturac.frmIngreso.cboEspecialidad.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 3));
        this.frmFacturac.frmIngreso.cboProfesional.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 1));
        setIdCita(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 0).toString());
        this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 8).toString();
        String Servicio = this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 9).toString();
        setXidclasecita(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 10).toString());
        this.frmFacturac.xesso = this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 11).toString();
        this.frmFacturac.frmIngreso.xTratamiento = this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 12).toString();
        this.frmFacturac.frmIngreso.cboCausaExterna.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 14));
        this.cboServicio.setSelectedItem(Servicio);
        this.cboProcedSuministro.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 7));
        this.DetalleFacturacion.setSelectedIndex(0);
        verificarCodProcSum();
        this.cboFinProcedimiento.setSelectedItem(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 13));
        this.frmFacturac.frmIngreso.txtNoAutorizacion.setText(this.gridCita1.getValueAt(this.gridCita1.getSelectedRow(), 16).toString());
        setxEsTipoCita(0);
    }

    private void cargarIngresoCitasNoProgramada() {
        this.frmFacturac.frmIngreso.cargarIngreso(this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 9).toString());
        setIdCita(this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 0).toString());
        String IdProc = this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 7).toString();
        String Servicio = this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 8).toString();
        this.frmFacturac.frmIngreso.xTratamiento = this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 13).toString();
        setxEsTipoCita(1);
        this.frmFacturac.frmIngreso.cboCausaExterna.setSelectedItem(this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 15));
        this.cboFinProcedimiento.setSelectedItem(this.gridCita2.getValueAt(this.gridCita2.getSelectedRow(), 14));
        this.cboServicio.setSelectedItem(Servicio);
        this.txtCodigo.setText(IdProc);
        this.DetalleFacturacion.setSelectedIndex(0);
        verificarCodProcSum();
    }

    private int verificarServicio(String Id) {
        int i = 0;
        int posServicio = -1;
        if (this.filaGridTotales > 0) {
            while (true) {
                if (i >= this.filaGridTotales) {
                    break;
                }
                if (Id.equals(this.modelototales.getValueAt(i, 2).toString())) {
                    posServicio = i;
                    break;
                }
                i++;
            }
        }
        return posServicio;
    }

    private int verificarServiciov2(String Id) {
        int i = 0;
        int posServicio = -1;
        this.filaGridTotales = this.gridTotales.getRowCount();
        if (this.filaGridTotales > 0) {
            while (true) {
                if (i >= this.filaGridTotales) {
                    break;
                }
                if (Id.equals(this.modelototales.getValueAt(i, 2).toString())) {
                    posServicio = i;
                    break;
                }
                i++;
            }
        }
        return posServicio;
    }

    /* JADX WARN: Type inference failed for: r3v108, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v163, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v170, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v194, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v234, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v86, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_FiltroOrdenes = new ButtonGroup();
        this.DetalleFacturacion = new JTabbedPane();
        this.pesServicios = new JPanel();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.btnDescuento = new JCheckBox();
        try {
            this.cboServicio = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.txtCodigo = new JTextField();
        try {
            this.cboProcedSuministro = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.txtCantidad = new JFormattedTextField();
        this.JSPPImpuesto = new JSpinner();
        this.txtVrUnitario = new JFormattedTextField();
        this.JTFFDescuento = new JFormattedTextField();
        this.JTFF_VTotalImpuesto = new JFormattedTextField();
        this.txtVrTotal = new JFormattedTextField();
        this.btnAdicionar = new JButton();
        try {
            this.cboFinProcedimiento = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboCentroCosto = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        this.JTPDatos = new JTabbedPane();
        this.JPIDNiveles = new JPanel();
        this.JSPDatosTabla = new JScrollPane();
        this.gridDetalle = new JTable();
        this.JPINivel2 = new JPanel();
        this.JSPDatosTabla1 = new JScrollPane();
        this.gridDetalle1 = new JTable();
        this.JSPTotales1 = new JScrollPane();
        this.gridTotales1 = new JTable();
        this.JBTGrabar = new JButton();
        this.JLBIngreso = new JLabel();
        this.JPINivel3 = new JPanel();
        this.JSPTotales = new JScrollPane();
        this.gridTotales = new JTable();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.pesCitas = new JPanel();
        this.panelCita1 = new JScrollPane();
        this.gridCita1 = new JTable();
        this.panelCita2 = new JScrollPane();
        this.gridCita2 = new JTable();
        this.JCH_VisualizarAnt = new JCheckBox();
        this.JDC_FechaCitas = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.pesOrdenesM = new JPanel();
        this.panelOrdMed = new JScrollPane();
        this.gridOrdMed = new JTable();
        this.JPI_FiltroOrdenes = new JPanel();
        this.JYC_FAno = new JYearChooser();
        this.JRB_FTodas = new JRadioButton();
        this.JRB_FAno = new JRadioButton();
        this.JPTratamientos = new JPanel();
        this.JDPTratamientos = new JScrollPane();
        this.JTTratamientos = new JTable();
        this.JPI_Recibo_Caja = new JPanel();
        setName("Ordenes");
        this.DetalleFacturacion.setForeground(new Color(0, 103, 0));
        this.DetalleFacturacion.setFont(new Font("Arial", 1, 14));
        this.DetalleFacturacion.setName("Ordenes");
        this.DetalleFacturacion.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.7
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.DetalleFacturacionKeyPressed(evt);
            }
        });
        this.pesServicios.setBorder(BorderFactory.createEtchedBorder());
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.btnDescuento.setFont(new Font("Arial", 1, 12));
        this.btnDescuento.setForeground(Color.blue);
        this.btnDescuento.setText("Aplicar Descuento?");
        this.btnDescuento.setToolTipText("Aplicar Descuento");
        this.btnDescuento.setEnabled(false);
        this.cboServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboServicio.setFont(new Font("Arial", 1, 12));
        this.cboServicio.setShowTableGrid(true);
        this.cboServicio.setShowTableHeaders(true);
        this.cboServicio.addItemListener(new ItemListener() { // from class: Facturacion.Ordenes.8
            public void itemStateChanged(ItemEvent evt) {
                Ordenes.this.cboServicioItemStateChanged(evt);
            }
        });
        this.cboServicio.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.9
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.cboServicioActionPerformed(evt);
            }
        });
        this.cboServicio.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.10
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.cboServicioKeyPressed(evt);
            }
        });
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.11
            public void focusLost(FocusEvent evt) {
                Ordenes.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.12
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.13
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.txtCodigoKeyPressed(evt);
            }
        });
        this.cboProcedSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos y/o Suministro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProcedSuministro.setFont(new Font("Arial", 1, 12));
        this.cboProcedSuministro.addItemListener(new ItemListener() { // from class: Facturacion.Ordenes.14
            public void itemStateChanged(ItemEvent evt) {
                Ordenes.this.cboProcedSuministroItemStateChanged(evt);
            }
        });
        this.cboProcedSuministro.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.15
            public void focusLost(FocusEvent evt) {
                Ordenes.this.cboProcedSuministroFocusLost(evt);
            }
        });
        this.cboProcedSuministro.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.16
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.cboProcedSuministroMouseClicked(evt);
            }
        });
        this.cboProcedSuministro.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.17
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.cboProcedSuministroActionPerformed(evt);
            }
        });
        this.cboProcedSuministro.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.18
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.cboProcedSuministroKeyPressed(evt);
            }
        });
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtCantidad.setHorizontalAlignment(4);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.19
            public void focusLost(FocusEvent evt) {
                Ordenes.this.txtCantidadFocusLost(evt);
            }
        });
        this.txtCantidad.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.20
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.txtCantidadActionPerformed(evt);
            }
        });
        this.txtCantidad.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.21
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.txtCantidadKeyPressed(evt);
            }
        });
        this.JSPPImpuesto.setFont(new Font("Arial", 1, 12));
        this.JSPPImpuesto.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "% Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPImpuesto.addChangeListener(new ChangeListener() { // from class: Facturacion.Ordenes.22
            public void stateChanged(ChangeEvent evt) {
                Ordenes.this.JSPPImpuestoStateChanged(evt);
            }
        });
        this.JSPPImpuesto.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.23
            public void focusLost(FocusEvent evt) {
                Ordenes.this.JSPPImpuestoFocusLost(evt);
            }
        });
        this.JSPPImpuesto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Ordenes.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Ordenes.this.JSPPImpuestoPropertyChange(evt);
            }
        });
        this.txtVrUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVrUnitario.setForeground(Color.red);
        this.txtVrUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.txtVrUnitario.setHorizontalAlignment(4);
        this.txtVrUnitario.setFont(new Font("Arial", 1, 12));
        this.txtVrUnitario.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.25
            public void focusLost(FocusEvent evt) {
                Ordenes.this.txtVrUnitarioFocusLost(evt);
            }
        });
        this.txtVrUnitario.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.26
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.txtVrUnitarioKeyPressed(evt);
            }
        });
        this.JTFFDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDescuento.setForeground(Color.red);
        this.JTFFDescuento.setHorizontalAlignment(4);
        this.JTFFDescuento.setFont(new Font("Arial", 1, 12));
        this.JTFFDescuento.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ordenes.27
            public void focusLost(FocusEvent evt) {
                Ordenes.this.JTFFDescuentoFocusLost(evt);
            }
        });
        this.JTFFDescuento.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.28
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.JTFFDescuentoActionPerformed(evt);
            }
        });
        this.JTFFDescuento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Ordenes.29
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Ordenes.this.JTFFDescuentoPropertyChange(evt);
            }
        });
        this.JTFFDescuento.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.30
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.JTFFDescuentoKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                Ordenes.this.JTFFDescuentoKeyTyped(evt);
            }
        });
        this.JTFF_VTotalImpuesto.setEditable(false);
        this.JTFF_VTotalImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTotalImpuesto.setForeground(Color.red);
        this.JTFF_VTotalImpuesto.setHorizontalAlignment(4);
        this.JTFF_VTotalImpuesto.setFont(new Font("Arial", 1, 12));
        this.txtVrTotal.setEditable(false);
        this.txtVrTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVrTotal.setForeground(Color.red);
        this.txtVrTotal.setHorizontalAlignment(4);
        this.txtVrTotal.setFont(new Font("Arial", 1, 12));
        this.btnAdicionar.setFont(new Font("Arial", 1, 12));
        this.btnAdicionar.setForeground(Color.red);
        this.btnAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAdicionar.setText("Adicionar");
        this.btnAdicionar.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.31
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.btnAdicionarActionPerformed(evt);
            }
        });
        this.btnAdicionar.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.32
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.btnAdicionarKeyPressed(evt);
            }
        });
        this.cboFinProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad Tecnología en Salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboFinProcedimiento.setFont(new Font("Arial", 1, 12));
        this.cboFinProcedimiento.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.33
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.cboFinProcedimientoKeyPressed(evt);
            }
        });
        this.cboCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo del Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCentroCosto.setFont(new Font("Arial", 1, 12));
        this.cboCentroCosto.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.34
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.cboCentroCostoKeyPressed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDatosTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTO Y/O SUMINISTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.gridDetalle.setFont(new Font("Arial", 1, 12));
        this.gridDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.gridDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.gridDetalle.setSelectionMode(0);
        this.gridDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.35
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.gridDetalleMouseClicked(evt);
            }
        });
        this.gridDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.36
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.gridDetalleKeyPressed(evt);
            }
        });
        this.JSPDatosTabla.setViewportView(this.gridDetalle);
        GroupLayout JPIDNivelesLayout = new GroupLayout(this.JPIDNiveles);
        this.JPIDNiveles.setLayout(JPIDNivelesLayout);
        JPIDNivelesLayout.setHorizontalGroup(JPIDNivelesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1130, 32767).addGroup(JPIDNivelesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDNivelesLayout.createSequentialGroup().addComponent(this.JSPDatosTabla, -1, 1124, 32767).addContainerGap())));
        JPIDNivelesLayout.setVerticalGroup(JPIDNivelesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 207, 32767).addGroup(JPIDNivelesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDNivelesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDatosTabla, -2, 195, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("DETALLE", this.JPIDNiveles);
        this.JSPDatosTabla1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.gridDetalle1.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.37
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.gridDetalle1KeyPressed(evt);
            }
        });
        this.JSPDatosTabla1.setViewportView(this.gridDetalle1);
        this.JSPTotales1.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.gridTotales1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPTotales1.setViewportView(this.gridTotales1);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setForeground(Color.red);
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.38
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ordenes.39
            public void keyPressed(KeyEvent evt) {
                Ordenes.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JLBIngreso.setFont(new Font("Arial", 1, 18));
        this.JLBIngreso.setHorizontalAlignment(0);
        GroupLayout JPINivel2Layout = new GroupLayout(this.JPINivel2);
        this.JPINivel2.setLayout(JPINivel2Layout);
        JPINivel2Layout.setHorizontalGroup(JPINivel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINivel2Layout.createSequentialGroup().addContainerGap().addGroup(JPINivel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINivel2Layout.createSequentialGroup().addComponent(this.JSPTotales1, -1, 990, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPINivel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBIngreso, -1, -1, 32767).addComponent(this.JBTGrabar))).addComponent(this.JSPDatosTabla1, -1, 1105, 32767)).addContainerGap()));
        JPINivel2Layout.setVerticalGroup(JPINivel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINivel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosTabla1, -1, 65, 32767).addGap(18, 18, 18).addGroup(JPINivel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPINivel2Layout.createSequentialGroup().addComponent(this.JLBIngreso, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabar, -2, 44, -2)).addComponent(this.JSPTotales1, -2, 0, 32767)).addContainerGap()));
        this.JTPDatos.addTab("NIVEL 2", this.JPINivel2);
        this.JSPTotales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.gridTotales.setFont(new Font("Arial", 1, 12));
        this.gridTotales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridTotales.setSelectionBackground(new Color(255, 255, 255));
        this.gridTotales.setSelectionForeground(new Color(255, 0, 0));
        this.gridTotales.setSelectionMode(0);
        this.JSPTotales.setViewportView(this.gridTotales);
        GroupLayout JPINivel3Layout = new GroupLayout(this.JPINivel3);
        this.JPINivel3.setLayout(JPINivel3Layout);
        JPINivel3Layout.setHorizontalGroup(JPINivel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1109, 32767).addGroup(JPINivel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINivel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPTotales, -1, 1105, 32767).addContainerGap())));
        JPINivel3Layout.setVerticalGroup(JPINivel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 203, 32767).addGroup(JPINivel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINivel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPTotales, -1, 191, 32767).addContainerGap())));
        this.JTPDatos.addTab("TOTAL SERVICIO", this.JPINivel3);
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Facturacion.Ordenes.40
            public void itemStateChanged(ItemEvent evt) {
                Ordenes.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout pesServiciosLayout = new GroupLayout(this.pesServicios);
        this.pesServicios.setLayout(pesServiciosLayout);
        pesServiciosLayout.setHorizontalGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesServiciosLayout.createSequentialGroup().addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesServiciosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTPDatos, -2, 1130, -2)).addGroup(pesServiciosLayout.createSequentialGroup().addContainerGap().addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, pesServiciosLayout.createSequentialGroup().addComponent(this.txtFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboServicio, -2, 229, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGrupoSevicio, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSevicioRips, 0, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, pesServiciosLayout.createSequentialGroup().addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(pesServiciosLayout.createSequentialGroup().addComponent(this.cboFinProcedimiento, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboCentroCosto, -1, -1, 32767)).addGroup(pesServiciosLayout.createSequentialGroup().addComponent(this.txtCodigo, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboProcedSuministro, -2, 452, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCantidad, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPImpuesto, -2, 100, -2))).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesServiciosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVrUnitario, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDescuento, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VTotalImpuesto, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVrTotal, -2, 90, -2)).addGroup(pesServiciosLayout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.btnDescuento, -2, 140, -2).addGap(18, 18, 18).addComponent(this.btnAdicionar, -2, 170, -2))))))).addGap(15, 15, 15)));
        pesServiciosLayout.setVerticalGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesServiciosLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFecha, -2, 50, -2).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboServicio, -2, 50, -2).addComponent(this.JCBGrupoSevicio, -2, 50, -2).addComponent(this.JCBSevicioRips, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCantidad, -1, 51, 32767).addComponent(this.JSPPImpuesto, -2, 50, -2).addComponent(this.txtVrUnitario, -2, 50, -2).addComponent(this.JTFFDescuento, -2, 50, -2).addComponent(this.JTFF_VTotalImpuesto, -2, 50, -2).addComponent(this.txtVrTotal, -2, 50, -2).addComponent(this.txtCodigo, -2, 50, -2).addComponent(this.cboProcedSuministro, -2, 50, -2)).addGap(10, 10, 10).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboFinProcedimiento, -2, 50, -2).addGroup(pesServiciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboCentroCosto, -2, 50, -2).addComponent(this.btnDescuento, -2, 40, -2)).addComponent(this.btnAdicionar, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 234, -2)));
        this.DetalleFacturacion.addTab("ORDENES", this.pesServicios);
        this.panelCita1.setBorder(BorderFactory.createTitledBorder((Border) null, "PROGRAMADAS", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.gridCita1.setFont(new Font("Arial", 1, 12));
        this.gridCita1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridCita1.setSelectionBackground(new Color(255, 255, 255));
        this.gridCita1.setSelectionForeground(new Color(255, 0, 0));
        this.gridCita1.setSelectionMode(0);
        this.gridCita1.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.41
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.gridCita1MouseClicked(evt);
            }
        });
        this.panelCita1.setViewportView(this.gridCita1);
        this.panelCita2.setBorder(BorderFactory.createTitledBorder((Border) null, "NO PROGRAMADAS", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.gridCita2.setFont(new Font("Arial", 1, 12));
        this.gridCita2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridCita2.setSelectionBackground(new Color(255, 255, 255));
        this.gridCita2.setSelectionForeground(new Color(255, 0, 0));
        this.gridCita2.setSelectionMode(0);
        this.gridCita2.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.42
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.gridCita2MouseClicked(evt);
            }
        });
        this.panelCita2.setViewportView(this.gridCita2);
        this.JCH_VisualizarAnt.setFont(new Font("Arial", 1, 12));
        this.JCH_VisualizarAnt.setText("Visualizar citas dias anteriores a la fecha actual?");
        this.JCH_VisualizarAnt.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.43
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.JCH_VisualizarAntActionPerformed(evt);
            }
        });
        this.JDC_FechaCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaCitas.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaCitas.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaCitas.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Ordenes.44
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Ordenes.this.JDC_FechaCitasPropertyChange(evt);
            }
        });
        GroupLayout pesCitasLayout = new GroupLayout(this.pesCitas);
        this.pesCitas.setLayout(pesCitasLayout);
        pesCitasLayout.setHorizontalGroup(pesCitasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesCitasLayout.createSequentialGroup().addContainerGap().addGroup(pesCitasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelCita2, -1, 1124, 32767).addComponent(this.panelCita1, -1, 1132, 32767).addGroup(pesCitasLayout.createSequentialGroup().addComponent(this.JDC_FechaCitas, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_VisualizarAnt).addGap(0, 0, 32767))).addContainerGap()));
        pesCitasLayout.setVerticalGroup(pesCitasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, pesCitasLayout.createSequentialGroup().addGroup(pesCitasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_FechaCitas, -2, 50, -2).addComponent(this.JCH_VisualizarAnt)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelCita1, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelCita2, -2, 155, -2).addContainerGap(28, 32767)));
        this.DetalleFacturacion.addTab("CITAS", this.pesCitas);
        this.gridOrdMed.setFont(new Font("Arial", 1, 12));
        this.gridOrdMed.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridOrdMed.setSelectionBackground(new Color(255, 255, 255));
        this.gridOrdMed.setSelectionForeground(new Color(255, 0, 0));
        this.gridOrdMed.setSelectionMode(0);
        this.gridOrdMed.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.45
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.gridOrdMedMouseClicked(evt);
            }
        });
        this.panelOrdMed.setViewportView(this.gridOrdMed);
        this.JPI_FiltroOrdenes.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO VISUALIZAR", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JYC_FAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Ordenes.46
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Ordenes.this.JYC_FAnoPropertyChange(evt);
            }
        });
        this.JBG_FiltroOrdenes.add(this.JRB_FTodas);
        this.JRB_FTodas.setFont(new Font("Arial", 1, 12));
        this.JRB_FTodas.setText("Toda");
        this.JRB_FTodas.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.47
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.JRB_FTodasMouseClicked(evt);
            }
        });
        this.JRB_FTodas.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.48
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.JRB_FTodasActionPerformed(evt);
            }
        });
        this.JBG_FiltroOrdenes.add(this.JRB_FAno);
        this.JRB_FAno.setFont(new Font("Arial", 1, 12));
        this.JRB_FAno.setSelected(true);
        this.JRB_FAno.setText("Año");
        this.JRB_FAno.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes.49
            public void actionPerformed(ActionEvent evt) {
                Ordenes.this.JRB_FAnoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroOrdenesLayout = new GroupLayout(this.JPI_FiltroOrdenes);
        this.JPI_FiltroOrdenes.setLayout(JPI_FiltroOrdenesLayout);
        JPI_FiltroOrdenesLayout.setHorizontalGroup(JPI_FiltroOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroOrdenesLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FTodas).addGap(18, 18, 18).addComponent(this.JRB_FAno).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JYC_FAno, -1, -1, 32767).addContainerGap()));
        JPI_FiltroOrdenesLayout.setVerticalGroup(JPI_FiltroOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroOrdenesLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_FiltroOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYC_FAno, GroupLayout.Alignment.TRAILING, -2, 23, -2).addGroup(JPI_FiltroOrdenesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FTodas).addComponent(this.JRB_FAno))).addGap(0, 6, 32767)));
        GroupLayout pesOrdenesMLayout = new GroupLayout(this.pesOrdenesM);
        this.pesOrdenesM.setLayout(pesOrdenesMLayout);
        pesOrdenesMLayout.setHorizontalGroup(pesOrdenesMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pesOrdenesMLayout.createSequentialGroup().addContainerGap().addGroup(pesOrdenesMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelOrdMed, -2, 1123, -2).addComponent(this.JPI_FiltroOrdenes, -2, -1, -2)).addContainerGap(-1, 32767)));
        pesOrdenesMLayout.setVerticalGroup(pesOrdenesMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, pesOrdenesMLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPI_FiltroOrdenes, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelOrdMed, -2, 296, -2).addGap(82, 82, 82)));
        this.DetalleFacturacion.addTab("ORDENES HISTORIA CLINICA", this.pesOrdenesM);
        this.JTTratamientos.setFont(new Font("Arial", 1, 12));
        this.JTTratamientos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTTratamientos.setSelectionBackground(new Color(255, 255, 255));
        this.JTTratamientos.setSelectionForeground(Color.red);
        this.JTTratamientos.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ordenes.50
            public void mouseClicked(MouseEvent evt) {
                Ordenes.this.JTTratamientosMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                Ordenes.this.JTTratamientosMouseEntered(evt);
            }
        });
        this.JDPTratamientos.setViewportView(this.JTTratamientos);
        GroupLayout JPTratamientosLayout = new GroupLayout(this.JPTratamientos);
        this.JPTratamientos.setLayout(JPTratamientosLayout);
        JPTratamientosLayout.setHorizontalGroup(JPTratamientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTratamientosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDPTratamientos, -2, 1119, -2).addContainerGap(-1, 32767)));
        JPTratamientosLayout.setVerticalGroup(JPTratamientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTratamientosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDPTratamientos, -2, -1, -2).addContainerGap(-1, 32767)));
        this.DetalleFacturacion.addTab("TRATAMIENTOS ODONTOLOGICOS", this.JPTratamientos);
        GroupLayout JPI_Recibo_CajaLayout = new GroupLayout(this.JPI_Recibo_Caja);
        this.JPI_Recibo_Caja.setLayout(JPI_Recibo_CajaLayout);
        JPI_Recibo_CajaLayout.setHorizontalGroup(JPI_Recibo_CajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1152, 32767));
        JPI_Recibo_CajaLayout.setVerticalGroup(JPI_Recibo_CajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 434, 32767));
        this.DetalleFacturacion.addTab("RECIBO DE CAJA", this.JPI_Recibo_Caja);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.DetalleFacturacion, -2, 1157, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.DetalleFacturacion, -2, 465, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            borrarRegistroTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAdicionarActionPerformed(ActionEvent evt) {
        if (this.cboFinProcedimiento.getSelectedIndex() != -1) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                if (!this.txtVrUnitario.getText().equals("0")) {
                    if (this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex() != -1) {
                        if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                            if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                                adicionarDetalle();
                                cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
                                this.txtCantidad.setText("1");
                                this.JSPPImpuesto.setValue(Float.valueOf(0.0f));
                                this.txtVrTotal.setValue(0);
                                this.JTFFDescuento.setValue(0);
                                this.txtVrUnitario.setValue(0);
                                this.txtCodigo.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBGrupoSevicio.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items servicio rips", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBSevicioRips.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.frmFacturac.frmIngreso.cboEspecialidad.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Valor unitario no puede ser cero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            if (this.frmFacturac.frmIngreso.cboEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                    if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                        bajarTabla("");
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBGrupoSevicio.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items servicio rips", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBSevicioRips.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.frmFacturac.frmIngreso.cboEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una finalidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.cboFinProcedimiento.requestFocus();
    }

    public void bajarTabla(String idOrdenP) {
        this.idOrdenItems = idOrdenP;
        adicionarDetalle();
        cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
        this.txtCantidad.setText("1");
        this.JSPPImpuesto.setValue(Float.valueOf(0.0f));
        this.txtVrTotal.setValue(0);
        this.JTFFDescuento.setValue(0);
        this.txtVrUnitario.setValue(0);
        this.txtCodigo.requestFocus();
        setEsPrioritario(0);
    }

    public void bajarTablaInterfaceGIIS(String idOrdenPInternos) {
        this.idOrdenItemsGIIS = idOrdenPInternos;
        System.err.println("idordenes" + this.idOrdenItemsGIIS);
        adicionarDetalle();
        cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
        this.txtCantidad.setText("1");
        this.JSPPImpuesto.setValue(new Float(0.0f));
        this.txtVrTotal.setValue(new Integer(0));
        this.JTFFDescuento.setValue(new Integer(0));
        this.txtVrUnitario.setValue(new Integer(0));
        this.txtCodigo.requestFocus();
        setEsPrioritario(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") && !Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") && !Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                adicionarDetalle();
                this.txtCodigo.requestFocus();
                return;
            }
            if (Double.valueOf(this.txtVrUnitario.getText()).doubleValue() > 0.0d) {
                adicionarDetalle();
                cargarCboProcedSum(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), getIdServicio(), getTipoServicio(), getCualValor(), getFiltroProcxEmp());
                this.txtCantidad.setText("1");
                this.txtVrTotal.setValue(new Integer(0));
                this.JTFFDescuento.setValue(new Integer(0));
                this.txtVrUnitario.setValue(new Integer(0));
                this.txtCodigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Valor unitario no puede ser cero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.txtCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            buscarProcSum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboServicioItemStateChanged(ItemEvent evt) {
        cambioCboServicio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridCita1MouseClicked(MouseEvent evt) {
        verifSelEmpresaCitas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridCita2MouseClicked(MouseEvent evt) {
        cargarIngresoCitasNoProgramada();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DetalleFacturacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.DetalleFacturacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboServicioActionPerformed(ActionEvent evt) {
        if (!Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
            this.txtCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCentroCostoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.btnAdicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroItemStateChanged(ItemEvent evt) {
        if (this.cboProcedSuministro.getSelectedIndex() != -1) {
            cargar_Cod_Val_cbosCCFinProc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroFocusLost(FocusEvent evt) {
    }

    private void txtCantidadFocusGained(FocusEvent evt) {
        this.txtCantidad.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadFocusLost(FocusEvent evt) {
        validar_perderfoco();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            validar_perderfoco();
            this.txtCantidad.transferFocus();
        }
    }

    private void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        if (!this.txtCodigo.getText().isEmpty()) {
            verificarCodProcSum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.txtCodigo.getText().isEmpty()) {
                verificarCodProcSum();
            }
            this.btnAdicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridOrdMedMouseClicked(MouseEvent evt) {
        cargarOrdenes();
        this.idHOrden = Long.valueOf(this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDetalle1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JLBIngreso.getText().isEmpty() && this.gridDetalle1.getRowCount() >= 0) {
            this.frmFacturac.clasefacturacion.grabar("FacturacN2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTratamientosMouseClicked(MouseEvent evt) {
        cargarTratamiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoFocusLost(FocusEvent evt) {
        validar_perderfoco();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            validar_perderfoco();
            this.cboFinProcedimiento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDetalleMouseClicked(MouseEvent evt) {
        if (this.gridDetalle.getSelectedRow() != -1 && this.gridDetalle.getSelectedColumn() == 18) {
            if (Boolean.parseBoolean(this.modelo.getValueAt(this.gridDetalle.getSelectedRow(), 18).toString())) {
                this.modelo.setValueAt(1, this.gridDetalle.getSelectedRow(), 19);
                return;
            } else {
                JD_TipoRechazo frmCR = new JD_TipoRechazo(null, true, this.frmFacturac, 1);
                frmCR.setVisible(true);
                return;
            }
        }
        if (this.gridDetalle.getModel().getColumnClass(30).equals(JButton.class) && this.gridDetalle.getSelectedColumn() == 30 && this.gridDetalle.getSelectedRow() != -1) {
            new JDConsentimientoInformado(null, true, this.idIngreso, this.modelo.getValueAt(this.gridDetalle.getSelectedRow(), 3).toString(), this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVrUnitarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (this.xvalor == 0.0d && Double.valueOf(this.txtVrUnitario.getValue().toString()).doubleValue() > this.xvalor) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Deseas actualizar el valor para este manual?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.sql = "update f_tarifaprocedimiento set `VrMinimo`=" + this.txtVrUnitario.getValue() + " , `VrMaximo`=" + this.txtVrUnitario.getValue() + " WHERE (`Id_Procedimiento` ='" + this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 0).toString() + "' AND `Id_Manual` ='" + this.cboProcedSuministro.getPopupTable().getValueAt(this.cboProcedSuministro.getSelectedIndex(), 9).toString() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                }
            }
            this.txtVrUnitario.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoActionPerformed(ActionEvent evt) {
        validar_perderfoco();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_VisualizarAntActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarCitasUsuario(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            validar_perderfoco();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboServicioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboServicio.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFinProcedimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboFinProcedimiento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboProcedSuministro.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FTodasMouseClicked(MouseEvent evt) {
        if (!this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FAnoActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FTodasActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYC_FAnoPropertyChange(PropertyChangeEvent evt) {
        if (!this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTratamientosMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoStateChanged(ChangeEvent evt) {
        validar_perderfoco();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaCitasPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && !this.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            buscarCitasUsuario(this.frmFacturac.frmPersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadActionPerformed(ActionEvent evt) {
        validar_perderfoco();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVrUnitarioFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno1) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
    }

    public int getValidarDatos() {
        return this.validarDatos;
    }

    public void setValidarDatos(int validarDatos) {
        this.validarDatos = validarDatos;
    }

    public String getIdCita() {
        return this.idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getxRedondeo() {
        return this.xRedondeo;
    }

    public void setxRedondeo(String xRedondeo) {
        this.xRedondeo = xRedondeo;
    }

    private void cargarOrdenes() {
        if (this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex() == -1) {
            this.metodos.mostrarMensaje("Por favor seleccione la Empresa Contratante");
            return;
        }
        if (this.gridOrdMed.getSelectedRow() > -1) {
            this.frmFacturac.frmIngreso.cboEspecialidad.setSelectedItem(this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 4));
            this.frmFacturac.frmIngreso.cboProfesional.setSelectedItem(this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 3));
            this.frmFacturac.frmIngreso.JTFCie10.setText(this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 5).toString());
            this.frmFacturac.frmIngreso.mBuscar_Patologia(this.frmFacturac.frmIngreso.JTFCie10, this.frmFacturac.frmIngreso.JTF_DNombre);
            this.xactualizarestadopro = this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 0).toString();
            cargarProcedimientos(this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 0).toString(), this.gridOrdMed.getValueAt(this.gridOrdMed.getSelectedRow(), 1).toString());
            this.DetalleFacturacion.setSelectedIndex(0);
        }
    }

    private void cargarTratamiento() {
        if (this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex() == -1) {
            this.metodos.mostrarMensaje("Por favor seleccione la Empresa Contratante");
            return;
        }
        if (this.JTTratamientos.getSelectedRow() > -1) {
            this.frmFacturac.frmIngreso.cboEspecialidad.setSelectedItem(this.JTTratamientos.getValueAt(this.JTTratamientos.getSelectedRow(), 3));
            this.frmFacturac.frmIngreso.cboProfesional.setSelectedItem(this.JTTratamientos.getValueAt(this.JTTratamientos.getSelectedRow(), 2));
            this.xactualizarestadopro = this.JTTratamientos.getValueAt(this.JTTratamientos.getSelectedRow(), 0).toString();
            cargarProcTratamiento(this.JTTratamientos.getValueAt(this.JTTratamientos.getSelectedRow(), 0).toString());
            this.DetalleFacturacion.setSelectedIndex(0);
        }
    }

    private void cargarProcedimientos(String id, String Servicio) {
        try {
            if (Servicio.equals("FARMACIA")) {
                this.sql = "SELECT   `i_suministro`.`Id` , `h_itemordenessum`.`Cantidad`, '' NFinproced, 0 Es_Prioritario, i_suministro.Nbre as nombreProcedimientoSuministro, ggs.nombre grupoServicio, gsr.nombre servicioRips FROM `h_itemordenessum`  INNER JOIN  `h_ordenes`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `i_suministro`  ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) inner join g_servicios_rips gsr on (gsr.id=h_itemordenesproced.idServicioRips) inner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio) WHERE (`h_ordenes`.`Id` ='" + id + "') ";
                this.cboCentroCosto.setSelectedItem("CONSULTA EXTERNA");
            } else {
                this.sql = "SELECT g_procedimiento.id, concat(f_tipofinprocedimiento.Id, '-',f_tipofinprocedimiento.Nbre) AS NFinproced,h_itemordenesproced.Cantidad, g_procedimiento.`Es_Prioritario`, g_procedimiento.Nbre as nombreProcedimientoSuministro, ggs.nombre grupoServicio, gsr.nombre servicioRips  FROM h_itemordenesproced  INNER JOIN h_ordenes ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipofinprocedimiento ON  (h_itemordenesproced.IdtipofinProc = f_tipofinprocedimiento.Id) inner join g_servicios_rips gsr on (gsr.id=h_itemordenesproced.idServicioRips) inner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio) WHERE (h_ordenes.Id ='" + id + "') ";
            }
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.cboServicio.setSelectedItem(Servicio);
                            this.cboProcedSuministro.setSelectedItem(xrs.getString("nombreProcedimientoSuministro"));
                            this.txtCodigo.setText(xrs.getString("id"));
                            this.JCBGrupoSevicio.setSelectedItem(xrs.getString("grupoServicio"));
                            this.JCBSevicioRips.setSelectedItem(xrs.getString("servicioRips"));
                            verificarCodProcSum();
                            this.txtCantidad.setText(xrs.getString("Cantidad"));
                            this.cboFinProcedimiento.setSelectedItem(xrs.getString("NFinproced"));
                            this.txtCantidad.requestFocus();
                            this.txtCantidad.transferFocus();
                            if (xrs.getInt("Es_Prioritario") == 1) {
                                setEsPrioritario(1);
                            }
                            validar_perderfoco();
                            adicionarDetalle();
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
                    xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void cargarSalida(String idSalida) {
        List<Object[]> listInformacionSalida = this.inventarioParaFacturacionDAO.listadoSalidaInventario(idSalida);
        if (!listInformacionSalida.isEmpty()) {
            this.frmFacturac.frmIngreso.cboEmpresa.setSelectedItem(listInformacionSalida.get(0)[2]);
            this.frmFacturac.frmIngreso.cboEspecialidad.setSelectedItem(listInformacionSalida.get(0)[3]);
            this.frmFacturac.frmIngreso.cboProfesional.setSelectedItem(listInformacionSalida.get(0)[4]);
            this.frmFacturac.frmIngreso.cboEstrato1.setSelectedItem(listInformacionSalida.get(0)[10]);
            this.frmFacturac.frmIngreso.JTFCie10.setText(listInformacionSalida.get(0)[8].toString());
            this.frmFacturac.frmIngreso.cboCausaExterna.setSelectedItem(listInformacionSalida.get(0)[9]);
            this.cboCentroCosto.setSelectedItem("FARMACIA");
            this.JCBGrupoSevicio.setSelectedItem("Apoyo diagnóstico y complementación  terapéutica");
            this.JCBSevicioRips.setSelectedItem("SERVICIO FARMACEUTICO");
            this.cboFinProcedimiento.setSelectedItem("TRATAMIENTO");
            this.cboServicio.setSelectedItem("FARMACIA");
            for (int i = 0; i < listInformacionSalida.size(); i++) {
                this.txtCodigo.setText(listInformacionSalida.get(i)[5].toString());
                this.txtCodigo.transferFocus();
                this.txtCantidad.setText("" + Long.valueOf(listInformacionSalida.get(i)[7].toString().replace(',', '.')));
                verificarCodProcSum();
                if (Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579")) {
                    this.cboCentroCosto.setSelectedItem("SERVICIO FARMACEUTICO");
                } else {
                    this.cboCentroCosto.setSelectedItem("FARMACIA");
                }
                validar_perderfoco();
                adicionarDetalle();
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0170: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:28:0x0170 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0174: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x0174 */
    private void cargarProcTratamiento(String id) {
        try {
            try {
                this.sql = "SELECT  `f_tiposervtipoproced`.`Idtiposervicio` , `f_tiposervicio`.`Nbre` AS servicio , `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre` AS Procedimiento \n, SUM(`o_hc_tratamiento_procedimiento`.`Cantidad`) AS Cantidad \n, CONCAT(f_tipofinprocedimiento.`Id`, '-',f_tipofinprocedimiento.`Nbre`) Finalidad\n, ifnull(gp.Id, '0000') codigoCie10, ifnull(gp.Nbre,'') nombreCie10\n FROM o_hc_tratamiento oht\n inner join   `o_hc_tratamiento_procedimiento`   on ( `o_hc_tratamiento_procedimiento`.Id_Tratamiento=oht.Id)\nINNER JOIN  `g_procedimiento`   ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \n  INNER JOIN  `f_tipofinprocedimiento`  ON (`g_procedimiento`.`Id_TipoFinProced` = f_tipofinprocedimiento.`Id`) \n INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \n INNER JOIN `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n inner join h_atencion ha on (ha.Id=oht.Id_Atencion)\n left join g_patologia gp on (gp.Id=ha.Codigo_Dxp)\n WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + id + "' AND o_hc_tratamiento_procedimiento.Id_Ingreso=0) \nGROUP BY `o_hc_tratamiento_procedimiento`.`IdProcedimiento` ";
                System.out.println("sql = " + this.sql);
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(this.sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        this.cboServicio.setSelectedItem(xrs.getString("servicio"));
                        if (this.frmFacturac.frmIngreso != null) {
                            this.frmFacturac.frmIngreso.JTFCie10.setText(xrs.getString("codigoCie10"));
                            this.frmFacturac.frmIngreso.JTF_DNombre.setText(xrs.getString("nombreCie10"));
                        }
                        this.txtCodigo.setText(xrs.getString("IdProcedimiento"));
                        setTipoServicio("Es_Proc");
                        verificarCodProcSum();
                        if (this.cboProcedSuministro.getSelectedIndex() != -1) {
                            this.cboFinProcedimiento.setSelectedItem(xrs.getString("Finalidad"));
                            this.txtCantidad.setText(xrs.getString("Cantidad"));
                            this.txtCantidad.requestFocus();
                            this.txtCantidad.transferFocus();
                            validar_perderfoco();
                            adicionarDetalle();
                        } else {
                            limpiar();
                            this.txtCodigo.requestFocus();
                        }
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this.frmFacturac, "Este Tratamiento no tiene procedimientos para facturar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
                xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ordenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
