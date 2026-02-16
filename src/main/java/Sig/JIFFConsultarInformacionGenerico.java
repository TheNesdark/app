package Sig;

import Acceso.Principal;
import Inventarios.claseInventario;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFFConsultarInformacionGenerico.class */
public class JIFFConsultarInformacionGenerico extends JInternalFrame {
    private String xNombre;
    private String xsql;
    private String xNombreCombo;
    private DefaultTableModel xModelo;
    private String[] xIdGenerico;
    private Object[] xDato;
    private claseInventario xclaseInventario;
    private WorkerSQL xWorkerSQL;
    private JButton JBTExportar;
    private JComboBox JCBGenerico;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JFormattedTextField JTFTotal;
    private boolean xLleno = true;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos metodos = new Metodos();

    public JIFFConsultarInformacionGenerico(String xNombre, String xTitulo) {
        initComponents();
        System.out.println("xNombre-->" + xNombre);
        setName(xNombre);
        this.xNombre = xNombre;
        setTitle(xTitulo.toUpperCase());
        mNuevo();
    }

    public void mNuevo() {
        this.xLleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBGenerico.setSelectedIndex(-1);
        if (this.xNombre.equals("ConsultarPrograma")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloPrograma();
            this.xNombreCombo = "Programa";
            return;
        }
        if (this.xNombre.equals("ConsultarEspecialidad")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloEspecialidad();
            this.xNombreCombo = "Especialidad";
            return;
        }
        if (this.xNombre.equals("ConsultarRadiologia")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloRadiologia();
            return;
        }
        if (this.xNombre.equals("ConsultarProcedimiento")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloProcedimiento();
            return;
        }
        if (this.xNombre.equals("ConsultarProcedimientoDet")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloProcedimientoDet();
            return;
        }
        if (this.xNombre.equals("ConsolidadoAsignacionCitas")) {
            this.JTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Citas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            mCrearModeloAsigancionCitas();
            this.xNombreCombo = "Total Citas";
            return;
        }
        if (this.xNombre.equals("CitasPorEmpresa")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloCitasPorEmpresa();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("RiesgoObstetrico")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloRiesgoObstetrico();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("RiesgoCardiovascular")) {
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloRiesgoCardiovascular();
            return;
        }
        if (this.xNombre.equals("ConsolidadoAtencionFecha")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoAtencionFecha();
            return;
        }
        if (this.xNombre.equals("ProcedimientosEmpresa")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloProcedimientosEmpresa();
            return;
        }
        if (this.xNombre.equals("CirugiasNoProgramadas")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloCirugiasNoProgramadas();
            return;
        }
        if (this.xNombre.equals("ConsolidadoPorProfesional")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoPorProfesional();
            return;
        }
        if (this.xNombre.equals("CirugiasPorEPS")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloCirugiasPorEPS();
            return;
        }
        if (this.xNombre.equals("CirugiasUsuariosEPSyProfesional")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloCirugiasUsuariosEPSyProfesional();
            return;
        }
        if (this.xNombre.equals("DetalleEntradaPorBodega")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloDetalleEntradaPorBodega();
            this.xNombreCombo = "Bodega";
            return;
        }
        if (this.xNombre.equals("ConsultarAtenciones")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsultarAtenciones();
            return;
        }
        if (this.xNombre.equals("ConsolidadOrdenesMedico")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoOrdenesMedico();
            this.xNombreCombo = "Tipo Servicio";
            return;
        }
        if (this.xNombre.equals("ConsolidOrdenConvenioProf")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoOrdenesMedico();
            this.xNombreCombo = "Tipo Servicio";
            return;
        }
        if (this.xNombre.equals("EstadisProcedLab")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloEstadisProcedLab();
            return;
        }
        if (this.xNombre.equals("ConsolProcedLabDet")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolProcedLabDet();
            return;
        }
        if (this.xNombre.equals("pacienteFacAtencionLab")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloPacienteFacAtencion();
            this.xNombreCombo = "Tipo Servicio";
            return;
        }
        if (this.xNombre.equals("pacienteFacAtencionRad")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloPacienteFacAtencion();
            this.xNombreCombo = "Sede";
            return;
        }
        if (this.xNombre.equals("InformeControlPrenatar")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mLlenarCombo();
            this.JCBGenerico.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloControlPrenatal();
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("ConsultaSaludOcupacionalDX")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloSaludOcupacionalDX();
            this.xNombreCombo = "EPS";
            return;
        }
        if (this.xNombre.equals("ConsultarOrdenesProcedimiento")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            this.JCBGenerico.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloConsultarOrdenProced();
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("ConsultaInforLipidosCarbo")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloInforLipidosCarbo();
            this.xNombreCombo = "Programa";
            return;
        }
        if (this.xNombre.equals("totalDosiSuministradas")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            this.JCBGenerico.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloTotalDosiSuministradas();
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("totalDosiSuministroEntidad")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            this.JCBGenerico.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloTotalDosiSuministroEntidad();
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("vacunacionAplicxUsuario")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            this.JCBGenerico.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloVacunacionAplicxUsuario();
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("formuSubgruFarmacologico")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Subgrupo Químico", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloFormuSubgruFarmacologico();
            this.xNombreCombo = "Subgrupo Químico";
            return;
        }
        if (this.xNombre.equals("empresaConveFarmacologico")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Subgrupo Químico", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloEmpresaConveFarmacologico();
            this.xNombreCombo = "Subgrupo Químico";
            return;
        }
        if (this.xNombre.equals("informeAutorizacion")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloInformeAutorizacion();
            this.xNombreCombo = "Tercero";
            return;
        }
        if (this.xNombre.equals("consolDescuenNomina")) {
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolDescuenNomina();
            this.JCHFiltro.setVisible(false);
            this.xNombreCombo = "";
            return;
        }
        if (this.xNombre.equals("informeRes4725")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloInformeRes4725();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("produccionPorSedeYProfesional")) {
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            this.JCHFiltro.setVisible(false);
            mCrearModeloProduccionPorSedeYProfesional();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("LASA")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación LASA", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            this.JDFechaI.setVisible(false);
            this.JDFechaF.setVisible(false);
            this.xNombreCombo = "LASA";
            this.xIdGenerico = this.xct.llenarCombo("SELECT Id, Nombre FROM `i_clasif_lasa` WHERE Estado=1", this.xIdGenerico, this.JCBGenerico);
            System.out.println("SQL LASA-->SELECT Id, Nombre FROM `i_clasif_lasa` WHERE Estado=1");
            this.JCBGenerico.setSelectedIndex(-1);
            return;
        }
        if (this.xNombre.equals("consultaPrenatal")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloConsultaPrenatal();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("lecturaPorEmpresaYValor")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(true);
            mCrearModeloLecturaPorEmpresaYValor();
            this.xNombreCombo = "Profesional";
            return;
        }
        if (this.xNombre.equals("consolidadocartera")) {
            this.JCHFiltro.setVisible(false);
            this.JCHFiltro.setSelected(false);
            this.JCBGenerico.setVisible(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoCartera();
            return;
        }
        if (this.xNombre.equals("consolidadoglosas")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCHFiltro.setSelected(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoGlosas();
            mLlenarCombo();
            return;
        }
        if (this.xNombre.equals("consolidadoglosasdefinitivo")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCHFiltro.setSelected(false);
            this.JTFTotal.setVisible(false);
            mCrearModeloConsolidadoGlosasDefinitivo();
            mLlenarCombo();
            this.xNombreCombo = "Empresa";
            return;
        }
        if (this.xNombre.equals("Informes1.5")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoria", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(true);
            this.JDFechaI.setVisible(false);
            this.JDFechaF.setVisible(false);
            mCrearModelolistadoProductoCategoria();
            this.xNombreCombo = "Categoria";
            mLlenarCombo();
            this.JTFTotal.setVisible(false);
            this.xLleno = true;
            return;
        }
        if (this.xNombre.equals("ProcedimientosOrdenadosUsuario")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFTotal.setVisible(false);
            mCrearModeloProcedimientosOrdenadosUsuario();
            this.xNombreCombo = "Tipo Servicio";
        }
    }

    public void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBGenerico.getSelectedIndex() != -1) {
                if (this.xNombre.equals("ConsultarPrograma")) {
                    mCargarDatosPrograma();
                    return;
                }
                if (this.xNombre.equals("ConsultarEspecialidad")) {
                    mCargarDatosEspecialidad();
                    return;
                }
                if (this.xNombre.equals("CitasPorEmpresa")) {
                    mCargarDatosCitasPorEmpresa();
                    return;
                }
                if (this.xNombre.equals("RiesgoObstetrico")) {
                    mCargarDatosRiesgoObstetrico();
                    return;
                }
                if (this.xNombre.equals("CirugiasNoProgramadas")) {
                    mCargarDatosCirugiasNoProgramadas();
                    return;
                }
                if (this.xNombre.equals("ConsolidadoPorProfesional")) {
                    mCargarDatosConsolidadoPorProfesional();
                    return;
                }
                if (this.xNombre.equals("CirugiasPorEPS")) {
                    mCargarDatosCirugiasPorEPS();
                    return;
                }
                if (this.xNombre.equals("CirugiasUsuariosEPSyProfesional")) {
                    mCargarDatosCirugiasUsuariosEPSyProfesional();
                    return;
                }
                if (this.xNombre.equals("DetalleEntradaPorBodega")) {
                    mCargarDatosDetalleEntradaPorBodega();
                    return;
                }
                if (this.xNombre.equals("ConsultarAtenciones")) {
                    mCargarDatosConsultarAtenciones();
                    return;
                }
                if (this.xNombre.equals("ConsolidadOrdenesMedico")) {
                    mCargarDatosConsolidadoOrdenesMedico();
                    return;
                }
                if (this.xNombre.equals("ConsolidOrdenConvenioProf")) {
                    mCargarDatosConsolidOrdenConvenioProf();
                    return;
                }
                if (this.xNombre.equals("pacienteFacAtencionLab") || this.xNombre.equals("pacienteFacAtencionRad")) {
                    mCargarDatosPacienteFacAtencion();
                    return;
                }
                if (this.xNombre.equals("ConsultaInforLipidosCarbo")) {
                    mCargarDatosInforLipidosCarbo();
                    return;
                }
                if (this.xNombre.equals("ConsultarOrdenesProcedimiento")) {
                    mCargarDatosConsultarOrdenProced();
                    return;
                }
                if (this.xNombre.equals("formuSubgruFarmacologico")) {
                    mCargarDatosFormuSubgruFarmacologico();
                    return;
                }
                if (this.xNombre.equals("empresaConveFarmacologico")) {
                    mCargarDatosEmpresaConveFarmacologico();
                    return;
                }
                if (this.xNombre.equals("informeAutorizacion")) {
                    mCargarDatosInformeAutorizacion();
                    return;
                }
                if (this.xNombre.equals("informeRes4725")) {
                    mCargarDatosInformeRes4725();
                    return;
                }
                if (this.xNombre.equals("LASA")) {
                    mCargarDatosLASA();
                    return;
                }
                if (this.xNombre.equals("consultaPrenatal")) {
                    mCargarDatosConsultaPrenatal();
                    return;
                }
                if (this.xNombre.equals("lecturaPorEmpresaYValor")) {
                    mCargarDatosLecturaPorEmpresaYValor();
                    return;
                }
                if (this.xNombre.equals("consolidadocartera")) {
                    mCargarDatosConsolidadoCartera();
                    return;
                }
                if (this.xNombre.equals("consolidadoglosas")) {
                    mCargarDatosConsolidadoGlosa();
                    return;
                }
                if (this.xNombre.equals("Informes1.5")) {
                    mCargarDatoslistadoProductoCategoria();
                    return;
                } else if (this.xNombre.equals("consolidadoglosasdefinitivo")) {
                    mCargarDatosConsolidadoGlosaDefinitivo();
                    return;
                } else {
                    if (this.xNombre.equals("ProcedimientosOrdenadosUsuario")) {
                        mCargarProcedimientosOrdenadosUsuario();
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar " + this.xNombreCombo, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBGenerico.requestFocus();
            return;
        }
        if (this.xNombre.equals("ConsultarPrograma")) {
            mCargarDatosPrograma();
            return;
        }
        if (this.xNombre.equals("ConsultarEspecialidad")) {
            mCargarDatosEspecialidad();
            return;
        }
        if (this.xNombre.equals("ConsultarRadiologia")) {
            mCargarDatosRadiologia();
            return;
        }
        if (this.xNombre.equals("ConsultarProcedimiento")) {
            mCargarDatosProcedimiento();
            return;
        }
        if (this.xNombre.equals("ConsultarProcedimientoDet")) {
            mCargarDatosProcedimientoDet();
            return;
        }
        if (this.xNombre.equals("ConsolidadoAsignacionCitas")) {
            mCargarDatosAsignacionCitas();
            return;
        }
        if (this.xNombre.equals("CitasPorEmpresa")) {
            mCargarDatosCitasPorEmpresa();
            return;
        }
        if (this.xNombre.equals("RiesgoObstetrico")) {
            mCargarDatosRiesgoObstetrico();
            return;
        }
        if (this.xNombre.equals("RiesgoCardiovascular")) {
            mCargarDatosRiesgoCardiovascular();
            return;
        }
        if (this.xNombre.equals("ConsolidadoAtencionFecha")) {
            mCargarDatosConsolidadoAtencionFecha();
            return;
        }
        if (this.xNombre.equals("ProcedimientosEmpresa")) {
            mCargarDatosProcedimientosEmpresa();
            return;
        }
        if (this.xNombre.equals("CirugiasNoProgramadas")) {
            mCargarDatosCirugiasNoProgramadas();
            return;
        }
        if (this.xNombre.equals("ConsolidadoPorProfesional")) {
            mCargarDatosConsolidadoPorProfesional();
            return;
        }
        if (this.xNombre.equals("CirugiasPorEPS")) {
            mCargarDatosCirugiasPorEPS();
            return;
        }
        if (this.xNombre.equals("CirugiasUsuariosEPSyProfesional")) {
            mCargarDatosCirugiasUsuariosEPSyProfesional();
            return;
        }
        if (this.xNombre.equals("DetalleEntradaPorBodega")) {
            mCargarDatosDetalleEntradaPorBodega();
            return;
        }
        if (this.xNombre.equals("ConsultarAtenciones")) {
            mCargarDatosConsultarAtenciones();
            return;
        }
        if (this.xNombre.equals("ConsolidadOrdenesMedico")) {
            mCargarDatosConsolidadoOrdenesMedico();
            return;
        }
        if (this.xNombre.equals("ConsolidOrdenConvenioProf")) {
            mCargarDatosConsolidOrdenConvenioProf();
            return;
        }
        if (this.xNombre.equals("EstadisProcedLab")) {
            mCargarDatosEstadisProcedLab();
            return;
        }
        if (this.xNombre.equals("ConsolProcedLabDet")) {
            mCargarDatosConsolProcedLabDet();
            return;
        }
        if (this.xNombre.equals("pacienteFacAtencionLab") || this.xNombre.equals("pacienteFacAtencionRad")) {
            mCargarDatosPacienteFacAtencion();
            return;
        }
        if (this.xNombre.equals("InformeControlPrenatar")) {
            mCargarDatosControlPrenatal();
            return;
        }
        if (this.xNombre.equals("ConsultaSaludOcupacionalDX")) {
            mCargarDatosSaludOcupacionalDX();
            return;
        }
        if (this.xNombre.equals("ConsultarOrdenesProcedimiento")) {
            mCargarDatosConsultarOrdenProced();
            return;
        }
        if (this.xNombre.equals("ConsultaInforLipidosCarbo")) {
            mCargarDatosInforLipidosCarbo();
            return;
        }
        if (this.xNombre.equals("totalDosiSuministradas")) {
            mCargarTotalDosiSuministradas();
            return;
        }
        if (this.xNombre.equals("totalDosiSuministroEntidad")) {
            mCargarTotalDosiSuministroEntidad();
            return;
        }
        if (this.xNombre.equals("vacunacionAplicxUsuario")) {
            mCargarDatosVacunacionAplicxUsuario();
            return;
        }
        if (this.xNombre.equals("formuSubgruFarmacologico")) {
            mCargarDatosFormuSubgruFarmacologico();
            return;
        }
        if (this.xNombre.equals("empresaConveFarmacologico")) {
            mCargarDatosEmpresaConveFarmacologico();
            return;
        }
        if (this.xNombre.equals("informeAutorizacion")) {
            mCargarDatosInformeAutorizacion();
            return;
        }
        if (this.xNombre.equals("consolDescuenNomina")) {
            mCargarDatosConsolDescuenNomina();
            return;
        }
        if (this.xNombre.equals("informeRes4725")) {
            mCargarDatosInformeRes4725();
            return;
        }
        if (this.xNombre.equals("produccionPorSedeYProfesional")) {
            mCargarDatosProduccionPorSedeYProfesional();
            return;
        }
        if (this.xNombre.equals("LASA")) {
            mCargarDatosLASA();
            return;
        }
        if (this.xNombre.equals("consultaPrenatal")) {
            mCargarDatosConsultaPrenatal();
            return;
        }
        if (this.xNombre.equals("lecturaPorEmpresaYValor")) {
            mCargarDatosLecturaPorEmpresaYValor();
            return;
        }
        if (this.xNombre.equals("consolidadocartera")) {
            mCargarDatosConsolidadoCartera();
            return;
        }
        if (this.xNombre.equals("consolidadoglosas")) {
            mCargarDatosConsolidadoGlosa();
            return;
        }
        if (this.xNombre.equals("consolidadoglosasdefinitivo")) {
            mCargarDatosConsolidadoGlosaDefinitivo();
        } else if (this.xNombre.equals("Informes1.5")) {
            mCargarDatoslistadoProductoCategoria();
        } else if (this.xNombre.equals("ProcedimientosOrdenadosUsuario")) {
            mCargarProcedimientosOrdenadosUsuario();
        }
    }

    private void mCrearModeloConsolidadoGlosas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"No. Factura", "Fecha Evento", "Tercero", "Empresa Convenio", "Servicio", "Total Servicio", "C/Moderadora", "Copago", "V/Neto", "No. Radicado", "Fecha Radicado", "No. RadicacionG", "FechaG", "Concepto de Pago", "Observacion", "Valor", "IdRespuesta", "Detalle Respuesta", "G/Aceptada", "G/Recuperada", "idDocumentoC", "PeriodoC", "Tipo DocumentoC"}) { // from class: Sig.JIFFConsultarInformacionGenerico.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, Double.class, Double.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
    }

    private void mCargarDatosConsolidadoGlosa() {
        mCrearModeloConsolidadoGlosas();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT\n    CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) AS `NFactura`\n    , `f_factura_evento`.`Fecha_FacturaEvento`\n    , `cc_terceros`.`RazonSocialCompleta` AS `NTercero`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`\n    , `f_subgruposervicio`.`Nbre` AS `NServicio`\n    , `f_liquidacion`.`TotalServicio`\n    , `f_liquidacion`.`CuotaModeradora`\n    , `f_liquidacion`.`Copago`\n    , IF(`g_empresacont`.`Id_TipoEmprCont`=4, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`TotalEps`) AS `VNeto`\n    , `f_factura_evento`.`NRadicado`\n    , `f_factura_evento`.`FechaRadicado`\n    , `f_factura_glosa`.`NRadicacionG`\n    , `f_factura_glosa`.`FechaG`\n    , `f_tipoconcepto_pago`.`Nbre`\n    , `f_factura_glosa`.`ObservacionG`\n    , `f_factura_glosa`.`Valor`\n    , IFNULL(`f_factura_glosa_respuesta`.`Id`, '') IdRespuesta\n    , if(length(IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, ''))>=32767, left(IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, ''), 32766), IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, '') ) DetalleR\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorA`, 0) GAceptada\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorR`, 0) GRecuperada\n    , IFNULL(`cc_documentoc`.`Id`,0) idDocumentoC\n    , IFNULL(`cc_periodo_contable`.`Nbre`,'NA') periodoContable\n    , IFNULL(`cc_tipo_documentoc`.`Nbre`,'Sin Documento') tipoDocumento    \nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_subgrupo_empresa` \n        ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n    LEFT JOIN  `f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) AND (f_factura_glosa_respuesta.`Estado`=1)\n    INNER JOIN  `f_subgruposervicio` \n        ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n    INNER JOIN  `f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\n LEFT JOIN `cc_documentoc`\n        ON(`f_factura_glosa`.`IdDocumentoC` = `cc_documentoc`.`Id`)\n    left JOIN `cc_periodo_contable`\n        ON(`cc_periodo_contable`.`Id` = `cc_documentoc`.`Id_PeriodoC`)\n    left JOIN `cc_tipo_documentoc`\n        ON(`cc_tipo_documentoc`.`Id` = `cc_documentoc`.`Id_TipoComprobante`)WHERE (`f_factura_glosa`.`FechaG` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `f_factura_glosa`.`FechaG` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_factura_evento`.`EstaArmada` =2\n    AND `f_factura_glosa`.`Estado` =1 and `cc_terceros`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "');";
            } else {
                this.xsql = "SELECT\n    CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) AS `NFactura`\n    , `f_factura_evento`.`Fecha_FacturaEvento`\n    , `cc_terceros`.`RazonSocialCompleta` AS `NTercero`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`\n    , `f_subgruposervicio`.`Nbre` AS `NServicio`\n    , `f_liquidacion`.`TotalServicio`\n    , `f_liquidacion`.`CuotaModeradora`\n    , `f_liquidacion`.`Copago`\n    , IF(`g_empresacont`.`Id_TipoEmprCont`=4, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`TotalEps`) AS `VNeto`\n    , `f_factura_evento`.`NRadicado`\n    , `f_factura_evento`.`FechaRadicado`\n    , `f_factura_glosa`.`NRadicacionG`\n    , `f_factura_glosa`.`FechaG`\n    , `f_tipoconcepto_pago`.`Nbre`\n    , `f_factura_glosa`.`ObservacionG`\n    , `f_factura_glosa`.`Valor`\n    , IFNULL(`f_factura_glosa_respuesta`.`Id`, '') IdRespuesta\n    , if(length(IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, ''))>=32767, left(IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, ''), 32766), IFNULL(`f_factura_glosa_respuesta`.`DetalleR`, '') ) DetalleR\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorA`, 0) GAceptada\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorR`, 0) GRecuperada\n    , IFNULL(`cc_documentoc`.`Id`,0) idDocumentoC\n    , IFNULL(`cc_periodo_contable`.`Nbre`,'NA') as periodoContable\n    , IFNULL(`cc_tipo_documentoc`.`Nbre`,'Sin Documento') as tipoDocumento    \nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_subgrupo_empresa` \n        ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n    LEFT JOIN  `f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) AND (f_factura_glosa_respuesta.`Estado`=1)\n    INNER JOIN  `f_subgruposervicio` \n        ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n    INNER JOIN  `f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\nLEFT JOIN `cc_documentoc`\n        ON(`f_factura_glosa`.`IdDocumentoC` = `cc_documentoc`.`Id`)\n    left JOIN `cc_periodo_contable`\n        ON(`cc_periodo_contable`.`Id` = `cc_documentoc`.`Id_PeriodoC`)\n    left JOIN `cc_tipo_documentoc`\n        ON(`cc_tipo_documentoc`.`Id` = `cc_documentoc`.`Id_TipoComprobante`)WHERE (`f_factura_glosa`.`FechaG` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `f_factura_glosa`.`FechaG` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_factura_evento`.`EstaArmada` =2\n    AND `f_factura_glosa`.`Estado` =1 );";
            }
            System.out.println("Consolidado de Glosa --->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(6)), n, 5);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(7)), n, 6);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(8)), n, 7);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(16)), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(19)), n, 18);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(20)), n, 19);
                    this.xModelo.setValueAt(rs.getString("idDocumentoC"), n, 20);
                    this.xModelo.setValueAt(rs.getString("periodoContable"), n, 21);
                    this.xModelo.setValueAt(rs.getString("tipoDocumento"), n, 22);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloConsolidadoGlosasDefinitivo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Entidad", "No. Factura", "Valor Factura", "Fecha Radicacion", "Fecha Glosa", "Concepto Glosa", "Fecha Respuesta", "Valor Glosado", "Valor Levantado", "IdGlosa"}) { // from class: Sig.JIFFConsultarInformacionGenerico.2
            Class[] types = {String.class, String.class, Double.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatosConsolidadoGlosaDefinitivo() {
        mCrearModeloConsolidadoGlosasDefinitivo();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT\n    `cc_terceros`.`RazonSocialCompleta` AS `entidad`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`, CONCAT(`f_factura_evento`.`Prefijo`, '', `f_factura_evento`.`No_FacturaEvento_M`)) AS `numeroFactura`\n    , `f_liquidacion`.`TotalEps` AS `valorFactura`\n    , IFNULL(`f_factura_evento`.`FechaRadicado`,'') AS `fechaRadicacion`\n    , IFNULL(`f_factura_glosa`.`FechaG`,'') AS `fechaGlosa`\n    , `f_tipoconcepto_pago`.`Nbre` AS `conceptoGlosa`\n    , IFNULL(`f_factura_glosa_respuesta`.`FechaD`,'') AS `fechaRespuesta`\n    , IFNULL(`f_factura_glosa`.`Valor`,0) AS `valorGlosado`\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorA`,0) AS `valorLevantado` \n    , f_factura_glosa_respuesta.`Id`  \nFROM\n    `baseserver`.`f_factura_evento`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\n    LEFT JOIN `baseserver`.`f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nWHERE ( `f_factura_glosa`.`FechaG` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `f_factura_glosa`.`FechaG` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_empresacontxconvenio`.`Id_EmpresaCont`= " + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + " AND `f_factura_glosa`.`Estado` =1);";
            } else {
                this.xsql = "SELECT\n    `cc_terceros`.`RazonSocialCompleta` AS `entidad`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`, CONCAT(`f_factura_evento`.`Prefijo`, '', `f_factura_evento`.`No_FacturaEvento_M`)) AS `numeroFactura`\n    , `f_liquidacion`.`TotalEps` AS `valorFactura`\n    , IFNULL(`f_factura_evento`.`FechaRadicado`,'') AS `fechaRadicacion`\n    , IFNULL(`f_factura_glosa`.`FechaG`,'') AS `fechaGlosa`\n    , `f_tipoconcepto_pago`.`Nbre` AS `conceptoGlosa`\n    , IFNULL(`f_factura_glosa_respuesta`.`FechaD`,'') AS `fechaRespuesta`\n    , IFNULL(`f_factura_glosa`.`Valor`,0) AS `valorGlosado`\n    , IFNULL(`f_factura_glosa_respuesta`.`ValorA`,0) AS `valorLevantado` \n    , f_factura_glosa_respuesta.`Id`  \nFROM\n    `baseserver`.`f_factura_evento`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\n    LEFT JOIN `baseserver`.`f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nWHERE ( `f_factura_glosa`.`FechaG` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `f_factura_glosa`.`FechaG` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_factura_glosa`.`Estado` =1);";
            }
            System.out.println("Consolidado de Glosa --->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(8)), n, 7);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 8);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(10)), n, 9);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloConsolidadoCartera() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"IdTercero", "Tercero", "IdConvenio", "Empresa Convenio", "Total Servicio", "Total Descuento", "Total C/Moderadora", "Total Copago", "V/Total", "V/Glosa", "V/Aceptado", "V/Recuperable", "v/Pagado", "Saldo", "Regimen"}) { // from class: Sig.JIFFConsultarInformacionGenerico.3
            Class[] types = {Long.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(250);
    }

    private void mCargarDatosConsolidadoCartera() {
        mCrearModeloConsolidadoCartera();
        try {
            this.xsql = null;
            this.xsql = "SELECT\n    `cc_terceros`.`Id` AS `IdTercero`\n    , `cc_terceros`.`RazonSocial` AS `NTercero`\n    , `f_empresacontxconvenio`.`Id` AS `IdConvenio`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`\n    , ROUND(SUM(`f_liquidacion`.`TotalServicio`)) AS `TotalServicio`\n    , ROUND(SUM(`f_liquidacion`.`TotalDescuento`)) AS `TotalDescuento`\n    , ROUND(SUM(`f_liquidacion`.`CuotaModeradora`)) AS `TotalCModeradora`\n    , ROUND(SUM(`f_liquidacion`.`Copago`)) AS `TotalCopago`\n    , ROUND(SUM(IF(`g_empresacont`.`Id_TipoEmprCont`=4, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`TotalEps`))) AS `VTotal`\n    , ROUND(SUM(IFNULL(`f_factura_glosa`.`Valor`,0))) AS `VGlosado`\n    , ROUND(SUM(IFNULL(`f_factura_glosa_respuesta`.`ValorA`,0))) AS `VAceptado`\n    , ROUND(SUM(IFNULL(`f_factura_glosa_respuesta`.`ValorR`,0))) AS `VRecuperable`\n    , ROUND(SUM(IFNULL(`f_factura_pagos`.`Valor`,0))) AS `VPagado`\n    ,  ROUND((SUM(IF(`g_empresacont`.`Id_TipoEmprCont`=4, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`TotalEps`))-SUM(IFNULL(`f_factura_glosa_respuesta`.`ValorA`,0)))-SUM(IFNULL(`f_factura_pagos`.`Valor`,0)) ) Saldo \n    , `f_tiporegimen`.`Nbre` AS `NRegimen`\nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)\n    LEFT JOIN  `f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) AND (f_factura_glosa.`Estado`=1)\n    LEFT JOIN  `f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) AND (f_factura_glosa_respuesta.`Estado`=1)\n    LEFT JOIN  `f_factura_pagos` \n        ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) AND (f_factura_pagos.`Estado`=1)\nWHERE (f_factura_glosa.`FechaG` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND f_factura_glosa.`FechaG` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY `IdConvenio`\nORDER BY `NTercero` ASC, `NEmpresaConvenio` ASC;";
            System.out.println("Consolidado de Cartera --->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(5)), n, 4);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(6)), n, 5);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(7)), n, 6);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(8)), n, 7);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 8);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(10)), n, 9);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(11)), n, 10);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(12)), n, 11);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(13)), n, 12);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(14)), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    n++;
                }
                mTotalizarDatos();
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloLecturaPorEmpresaYValor() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FechaL", "Especialidad", "NProfesional", "Cod_Proced", "Procedimiento", "Cantidad", "ValorUnitario", "% Impuesto", "ValorImpuesto", "Total", "Empresa", "NoHistoria", "NUsuario", "UsuarioS", "IdIngreso"}) { // from class: Sig.JIFFConsultarInformacionGenerico.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
    }

    private void mCargarDatosLecturaPorEmpresaYValor() {
        mCrearModeloLecturaPorEmpresaYValor();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n    `h_radiologia_lectura_encabezado`.`FechaL`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `g_procedimiento`.`Id` AS IdProcedimiento\n    , `g_procedimiento`.`Nbre` AS procedimiento\n    , `f_itemordenesproced`.`Cantidad`\n    , `f_itemordenesproced`.`ValorUnitario`\n    , `f_itemordenesproced`.`porcentajeImpuesto`\n    , `f_itemordenesproced`.`valorImpuesto`\n    , ((`f_itemordenesproced`.`Cantidad * `f_itemordenesproced`.`ValorUnitario`)+valorImpuesto) AS ValorTotal\n    , `f_empresacontxconvenio`.`Nbre` AS `EMpresa`\n    , persona.`NoHistoria`\n    , persona.`NUsuario`\n    , h_radiologia_lectura_encabezado.`UsuarioS`\n    , ingreso.`Id` AS IdIngreso\nFROM\n     `h_radiologia_detalle`\n    INNER JOIN  `h_radiologia` \n        ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`)\n    INNER JOIN  `h_radiologia_lectura_encabezado` \n        ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `persona`\n        ON (`persona`.`Id_persona`= `ingreso`.`Id_Usuario`)\n    INNER JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `h_radiologia_detalle`.`Id_Procedimiento`) AND (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_radiologia_lectura_encabezado`.`FechaL` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`FechaL` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`Estado` =1\n    AND `f_ordenes`.`Estado` =0 AND `profesional1`.Id_Persona='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')\nORDER BY `profesional1`.`NProfesional` ASC, `g_procedimiento`.`Nbre` ASC;";
                System.out.println("Informes de Lectura por Empresa y Valor --->   " + this.xsql);
            } else {
                this.xsql = "SELECT\n    `h_radiologia_lectura_encabezado`.`FechaL`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `g_procedimiento`.`Id` AS IdProcedimiento\n    , `g_procedimiento`.`Nbre` AS procedimiento\n    , `f_itemordenesproced`.`Cantidad`\n    , `f_itemordenesproced`.`ValorUnitario`\n    , `f_itemordenesproced`.`porcentajeImpuesto`\n    , `f_itemordenesproced`.`valorImpuesto`\n    , ((`f_itemordenesproced`.`Cantidad * `f_itemordenesproced`.`ValorUnitario`)+valorImpuesto) AS ValorTotal\n    , `f_empresacontxconvenio`.`Nbre` AS `EMpresa`\n    , persona.`NoHistoria`\n    , persona.`NUsuario`\n    , h_radiologia_lectura_encabezado.`UsuarioS`\n    , ingreso.`Id` AS IdIngreso\nFROM\n     `h_radiologia_detalle`\n    INNER JOIN  `h_radiologia` \n        ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`)\n    INNER JOIN  `h_radiologia_lectura_encabezado` \n        ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `persona`\n        ON (`persona`.`Id_persona`= `ingreso`.`Id_Usuario`)\n    INNER JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `h_radiologia_detalle`.`Id_Procedimiento`) AND (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_radiologia_lectura_encabezado`.`FechaL` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`FechaL` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`Estado` =1\n    AND `f_ordenes`.`Estado` =0)\nORDER BY `profesional1`.`NProfesional` ASC, `g_procedimiento`.`Nbre` ASC;";
                System.out.println("Informes de Lectura por Empresa y Valor --->   " + this.xsql);
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                double total = 0.0d;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(6)), n, 5);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(7)), n, 6);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(8)), n, 7);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 8);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(10)), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    n++;
                    total += rs.getDouble(10);
                }
                this.JTFTotal.setValue(Double.valueOf(total));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloConsultaPrenatal() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "Municipio", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Edad", "Direccion", "Telefono", "Movil", "estadoCivil", "nivelEducativo", "Ocupacion", "FIngreso", "FUM", "FPP", "SGestacionInicio", "SGestacionActual", "NGestacion", "NPartos", "NCesareas", "NAbortos", "NEctopico", "Peso_Inicio", "Talla", "Imc", "Peso", "NCOntroles", "FControl", "PAS", "PAD", "FProximoControl", "FechaRH", "ResultadoRH", "FechaHEMATOCRITOS 1", "ResultadoHEMATOCRITOS 1", "FechaHEMATOCRITOS 2", "ResultadoHEMATOCRITOS 2", "FechaHEMATOCRITOS 3", "ResultadoHEMATOCRITOS 3", "FechaHEPATITISB 1", "ResultadoHEPATITISB 1", "FechaHEPATITISB 2", "ResultadoHEPATITISB 2", "FechaHEPATITISB 3", "ResultadoHEPATITISB 3", "FechaTestSull 1", "ResultadoTestSull 1", "FechaTestSull 2", "ResultadoTestSull 2", "FechaTestSull 3", "ResultadoTestSull 3", "FechaVIH 1", "ResultadoVIH 1", "FechaVIH 2", "ResultadoVIH 2", "FechaVIH 3", "ResultadoVIH 3", "FechaVDRL 1", "ResultadoVDRL 1", "FechaVDRL 2", "ResultadoVDRL 2", "FechaVDRL 3", "ResultadoVDRL 3", "FechaHEMOGRAMA 1", "ResultadoHEMOGRAMA 1", "FechaHEMOGRAMA 2", "ResultadoHEMOGRAMA 2", "FechaHEMOGRAMA 3", "ResultadoHEMOGRAMA 3", "FechaGLICEMIA 1", "ResultadoGLICEMIA 1", "FechaGLICEMIA 2", "ResultadoGLICEMIA 2", "FechaGLICEMIA 3", "ResultadoGLICEMIA 3", "FechaUROANALISIS 1", "FechaUROANALISIS 2", "FechaUROANALISIS 3", "Fecha FROTIS VAGINAL 1", "Fecha FROTIS VAGINAL 2", "Fecha FROTIS VAGINAL 3", "FTomaCitologia", "FResultadoCitologia", "FechaUROCULTIVO", "NIps", "DireccionIps", "Tel_IPS", "EmpresaFacturo", "IdUsuarioPrograma", "Id_persona"}) { // from class: Sig.JIFFConsultarInformacionGenerico.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(71).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(72).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(73).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(74).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(75).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(76).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(77).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(78).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(79).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(80).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(81).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(82).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(83).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(84).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(85).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(86).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(87).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(88).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(89).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(90).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(91).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(92).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(93).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(94).setPreferredWidth(150);
    }

    private void mCargarDatosConsultaPrenatal() {
        mCrearModeloConsultaPrenatal();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    this.xsql = "SELECT *  FROM (\nSELECT\n  COUNT(*) over(PARTITION BY ingreso.Id_Usuario ORDER BY h_atencion.Fecha_Atencion DESC) conteo,\n  UCASE(f_tiporegimen.Nbre) AS Regimen,\n  UCASE(g_departamento.Nbre) AS Departamento,\n  g_municipio.Nbre AS Municipio,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.FechaNac,\n  Devuelve_Edad_2F(g_persona.FechaNac,h_atencion.Fecha_Atencion) AS Edad,\n  g_persona.Direccion,\n  IF(g_persona.Telefono = '','NO TIENE',IFNULL(g_persona.Telefono,'NO TIENE')) AS Telefono,\n  IF(g_persona.Movil = '','NO TIENE',IFNULL(g_persona.Movil,'NO TIENE')) AS Movil,\n  IFNULL(g_usuarioxprograma.FechaIngreso,'') FIngreso,\n  IFNULL(g_usuarioxprograma.UltimaMestruacion,'') FUM,\n  IFNULL(g_usuarioxprograma.PartoProbable,'') FPP,\n  IFNULL(g_usuarioxprograma.SemanaGestacion,'') SGestacionInicio,\n  IFNULL(h_examenfisico.SGestacion,0) SGestacionActual,\n  IFNULL(ag.No_G, 0) NGestacion,\n  IFNULL(ag.No_P, 0) NPartos,\n  IFNULL(ag.No_C, 0) NCesareas,\n  IFNULL(ag.No_A, 0) NAbortos,\n  IFNULL(ag.No_E, 0) NEctopico,\n  ROUND(IFNULL(h_examenfisico.Peso, 0),2) Peso,\n  IFNULL(h_examenfisico.Talla, 0) Talla,\n  IFNULL(h_examenfisico.IMC, 0) Imc,\n  IFNULL(h_examenfisico.TArtSentadoS,0) PAS,\n  IFNULL(h_examenfisico.TArtSentadoD,0) PAD,\n  IFNULL(nc.Cantidad, 0) AS NCOntroles,\n  h_atencion.Fecha_Atencion FControl,\n  IFNULL(fc.Fecha_Cita, '') FProximoControl,\n  IFNULL(HL.FToma, '') AS FechaRH,\n  IFNULL(HL.VrNumerico, '') AS ResultadoRH,\n  IFNULL(ct.FToma, '') FTomaCitologia,\n  IFNULL(ct.FResultado, '') FResultadoCitologia,\n  g_ips.Nbre AS NIps,\n  g_ips.Direccion DireccionIps,\n  g_ips.Telefono AS Tel_IPS,\n  f_empresacontxconvenio.Nbre AS EmpresaFacturo,\n  IFNULL(g_usuarioxprograma.Peso_Inicio,'') AS Peso_Inicio,\n  IF(h_atencion.IdUsuarioPrograma=0,g_usuarioxprograma.Id,h_atencion.IdUsuarioPrograma) AS IdUsuarioPrograma,\n  g_usuario.Id_persona,\n  g_estadocivil.Nbre AS estadoCivil,\n  g_nivelestudio.Nbre AS nivelEducativo,\n  g_ocupacion.Nbre AS Ocupacion\nFROM  g_ips,  h_atencion\n  INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n  INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_municipio ON (g_persona.Id_Municipio = g_municipio.Id)\n  INNER JOIN g_departamento ON (g_municipio.Id_Dpto = g_departamento.Id)\n  INNER JOIN f_tiporegimen ON (f_empresacontxconvenio.Id_TipoRegimen = f_tiporegimen.Id)\n  INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n  INNER JOIN g_estadocivil ON (g_persona.Id_EstadoCivil = g_estadocivil.Id)\n  INNER JOIN g_nivelestudio ON (g_nivelestudio.Id = ingreso.Id_NivelEstudio)\n  INNER JOIN g_ocupacion ON (g_ocupacion.Id = ingreso.Id_Ocupacion)\n  LEFT JOIN h_examenfisico ON (h_examenfisico.Id_Atencion = h_atencion.Id)\n  LEFT JOIN g_usuarioxprograma ON (g_usuarioxprograma.Id_Usuario = g_usuario.Id_persona) AND (g_usuarioxprograma.Id_Programa=c_clasecita.Id_Programa)\n  LEFT JOIN (SELECT d.Id_Usuario,\n      h_antecedenteginecologico.No_G,\n      h_antecedenteginecologico.No_P,\n      h_antecedenteginecologico.No_C,\n      h_antecedenteginecologico.No_A,\n      h_antecedenteginecologico.No_E\n    FROM h_antecedenteginecologico\n     INNER JOIN (SELECT MAX(Id) Id,Id_Usuario\n     FROM h_antecedenteginecologico\n     GROUP BY Id_Usuario)\n     d ON (d.Id = h_antecedenteginecologico.Id)) ag ON ( ag.Id_Usuario = ingreso.Id_Usuario)\n         -- Numero de controles ----------------------------------------------------------------\n   LEFT JOIN (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '06'\n    AND ingreso.`Estado`=0  \n      )\n    GROUP BY ingreso.Id_Usuario) nc ON (nc.Id_Usuario = g_usuario.Id_persona) \n   LEFT JOIN (SELECT c_citas.Fecha_Cita,\n      c_citas.Id_Usuario\n    FROM c_citas\n      INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)\n    WHERE (c_clasecita.Id_Finalidad = 06 AND c_citas.Id_MotivoDesistida = 1 AND c_citas.Asistida = 0)\n    GROUP BY c_citas.Id_Usuario) fc ON (fc.Id_Usuario = g_usuario.Id_persona) AND (fc.Fecha_Cita > h_atencion.Fecha_Atencion) \n   LEFT JOIN\n    (SELECT\n      DATE_FORMAT(l_recepcion.FechaRecep,\n        '%Y-%m-%d'\n      ) AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM\n      l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim)\n        AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (202))\n    GROUP BY l_recepcion.Id_Paciente) HL ON (HL.Id_Paciente = g_usuario.Id_persona)         \n   LEFT JOIN (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      IFNULL(l_resultados.FechaResult,'') FResultado,\n      l_recepcion.Id_Paciente,\n      MAX(l_recepcion_citologia.Id_Recepcion)\n    FROM l_recepcion_citologia\n      INNER JOIN l_recepcion ON (l_recepcion_citologia.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      LEFT JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n    WHERE (l_recepcion.Estado = 0) GROUP BY l_recepcion.Id_Paciente) ct ON (ct.Id_Paciente = g_usuario.Id_persona)\nWHERE (h_atencion.Codigo_Dxp <> ''\n    AND c_clasecita.Id_Finalidad = '06'\n    AND ingreso.FechaIngreso >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.FechaIngreso <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND IFNULL(g_usuarioxprograma.FechaEgreso, 1)=1 AND f_empresacontxconvenio.Id='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n  )\n GROUP BY g_persona.`Id` , ingreso.`Id`\nORDER BY g_persona.NoDocumento ASC ) setDatos \nWHERE  setDatos.conteo=1;";
                } else {
                    this.xsql = "SELECT\n  UCASE(f_tiporegimen.Nbre) AS Regimen,\n  UCASE(g_departamento.Nbre) AS Departamento,\n  g_municipio.Nbre AS Municipio,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.FechaNac,\n  Devuelve_Edad_2F(g_persona.FechaNac,h_atencion.Fecha_Atencion) AS Edad,\n  g_persona.Direccion,\n  IF(g_persona.Telefono = '','NO TIENE',IFNULL(g_persona.Telefono,'NO TIENE')) AS Telefono,\n  IF(g_persona.Movil = '','NO TIENE',IFNULL(g_persona.Movil,'NO TIENE')) AS Movil,\n  IFNULL(g_usuarioxprograma.FechaIngreso,'') FIngreso,\n  IFNULL(g_usuarioxprograma.UltimaMestruacion,'') FUM,\n  IFNULL(g_usuarioxprograma.PartoProbable,'') FPP,\n  IFNULL(g_usuarioxprograma.SemanaGestacion,'') SGestacionInicio,\n  IFNULL(h_examenfisico.SGestacion,0) SGestacionActual,\n  IFNULL(ag.No_G, 0) NGestacion,\n  IFNULL(ag.No_P, 0) NPartos,\n  IFNULL(ag.No_C, 0) NCesareas,\n  IFNULL(ag.No_A, 0) NAbortos,\n  IFNULL(ag.No_E, 0) NEctopico,\n  ROUND(IFNULL(h_examenfisico.Peso, 0),2) Peso,\n  IFNULL(h_examenfisico.Talla, 0) Talla,\n  IFNULL(h_examenfisico.IMC, 0) Imc,\n  IFNULL(h_examenfisico.TArtSentadoS,0) PAS,\n  IFNULL(h_examenfisico.TArtSentadoD,0) PAD,\n  IFNULL(nc.Cantidad, 0) AS NCOntroles,\n  h_atencion.Fecha_Atencion FControl,\n  IFNULL(fc.Fecha_Cita, '') FProximoControl,\n  IFNULL(HL.FToma, '') AS FechaRH,\n  IFNULL(HL.VrNumerico, '') AS ResultadoRH,\n  IFNULL(ct.FToma, '') FTomaCitologia,\n  IFNULL(ct.FResultado, '') FResultadoCitologia,\n  g_ips.Nbre AS NIps,\n  g_ips.Direccion DireccionIps,\n  g_ips.Telefono AS Tel_IPS,\n  f_empresacontxconvenio.Nbre AS EmpresaFacturo,\n  IFNULL(g_usuarioxprograma.Peso_Inicio,'') AS Peso_Inicio,\n  IF(h_atencion.IdUsuarioPrograma=0,g_usuarioxprograma.Id,h_atencion.IdUsuarioPrograma) AS IdUsuarioPrograma,\n  g_usuario.Id_persona,\n  g_estadocivil.Nbre AS estadoCivil,\n  g_nivelestudio.Nbre AS nivelEducativo,\n  g_ocupacion.Nbre AS Ocupacion\nFROM  g_ips,  h_atencion\n  INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n  INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_municipio ON (g_persona.Id_Municipio = g_municipio.Id)\n  INNER JOIN g_departamento ON (g_municipio.Id_Dpto = g_departamento.Id)\n  INNER JOIN f_tiporegimen ON (f_empresacontxconvenio.Id_TipoRegimen = f_tiporegimen.Id)\n  INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n  INNER JOIN g_estadocivil ON (g_persona.Id_EstadoCivil = g_estadocivil.Id)\n  INNER JOIN g_nivelestudio ON (g_nivelestudio.Id = ingreso.Id_NivelEstudio)\n  INNER JOIN g_ocupacion ON (g_ocupacion.Id = ingreso.Id_Ocupacion)\n  LEFT JOIN h_examenfisico ON (h_examenfisico.Id_Atencion = h_atencion.Id)\n  LEFT JOIN g_usuarioxprograma ON (g_usuarioxprograma.Id_Usuario = g_usuario.Id_persona) AND (g_usuarioxprograma.Id_Programa=c_clasecita.Id_Programa)\n  LEFT JOIN (SELECT d.Id_Usuario,\n      h_antecedenteginecologico.No_G,\n      h_antecedenteginecologico.No_P,\n      h_antecedenteginecologico.No_C,\n      h_antecedenteginecologico.No_A,\n      h_antecedenteginecologico.No_E\n    FROM h_antecedenteginecologico\n      INNER JOIN (SELECT MAX(Id) Id,Id_Usuario\n        FROM h_antecedenteginecologico\n        GROUP BY Id_Usuario) d ON (d.Id = h_antecedenteginecologico.Id)) ag ON ( ag.Id_Usuario = ingreso.Id_Usuario) -- Numero de controles\n   LEFT JOIN (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '06')\n    GROUP BY ingreso.Id_Usuario) nc ON (nc.Id_Usuario = g_usuario.Id_persona) \n   LEFT JOIN (SELECT c_citas.Fecha_Cita,\n      c_citas.Id_Usuario\n    FROM c_citas\n      INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)\n    WHERE (c_clasecita.Id_Finalidad = 06 AND c_citas.Id_MotivoDesistida = 1 AND c_citas.Asistida = 0)\n    GROUP BY c_citas.Id_Usuario) fc ON (fc.Id_Usuario = g_usuario.Id_persona) AND (fc.Fecha_Cita > h_atencion.Fecha_Atencion) \n   LEFT JOIN\n    (SELECT\n      DATE_FORMAT(l_recepcion.FechaRecep,\n        '%Y-%m-%d'\n      ) AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM\n      l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim)\n        AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (202))\n    GROUP BY l_recepcion.Id_Paciente) HL ON (HL.Id_Paciente = g_usuario.Id_persona)         \n   LEFT JOIN (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      IFNULL(l_resultados.FechaResult,'') FResultado,\n      l_recepcion.Id_Paciente,\n      MAX(l_recepcion_citologia.Id_Recepcion)\n    FROM l_recepcion_citologia\n      INNER JOIN l_recepcion ON (l_recepcion_citologia.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      LEFT JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n    WHERE (l_recepcion.Estado = 0) GROUP BY l_recepcion.Id_Paciente) ct ON (ct.Id_Paciente = g_usuario.Id_persona)\nWHERE (h_atencion.Codigo_Dxp <> ''\n    AND c_clasecita.Id_Finalidad = '06'\n    AND ingreso.FechaIngreso >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.FechaIngreso <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND IFNULL(g_usuarioxprograma.FechaEgreso, 1)=1 AND f_empresacontxconvenio.Id='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n  );";
                }
            } else {
                this.xsql = "SELECT\n  UCASE(f_tiporegimen.Nbre) AS Regimen,\n  UCASE(g_departamento.Nbre) AS Departamento,\n  g_municipio.Nbre AS Municipio,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.FechaNac,\n  Devuelve_Edad_2F(g_persona.FechaNac,h_atencion.Fecha_Atencion) AS Edad,\n  g_persona.Direccion,\n  IF(g_persona.Telefono = '','NO TIENE',IFNULL(g_persona.Telefono,'NO TIENE')) AS Telefono,\n  IF(g_persona.Movil = '','NO TIENE',IFNULL(g_persona.Movil,'NO TIENE')) AS Movil,\n  IFNULL(g_usuarioxprograma.FechaIngreso,'') FIngreso,\n  IFNULL(g_usuarioxprograma.UltimaMestruacion,'') FUM,\n  IFNULL(g_usuarioxprograma.PartoProbable,'') FPP,\n  IFNULL(g_usuarioxprograma.SemanaGestacion,'') SGestacionInicio,\n  IFNULL(h_examenfisico.SGestacion,0) SGestacionActual,\n  IFNULL(ag.No_G, 0) NGestacion,\n  IFNULL(ag.No_P, 0) NPartos,\n  IFNULL(ag.No_C, 0) NCesareas,\n  IFNULL(ag.No_A, 0) NAbortos,\n  IFNULL(ag.No_E, 0) NEctopico,\n  ROUND(IFNULL(h_examenfisico.Peso, 0),2) Peso,\n  IFNULL(h_examenfisico.Talla, 0) Talla,\n  IFNULL(h_examenfisico.IMC, 0) Imc,\n  IFNULL(h_examenfisico.TArtSentadoS,0) PAS,\n  IFNULL(h_examenfisico.TArtSentadoD,0) PAD,\n  IFNULL(nc.Cantidad, 0) AS NCOntroles,\n  h_atencion.Fecha_Atencion FControl,\n  IFNULL(fc.Fecha_Cita, '') FProximoControl,\n  IFNULL(HL.FToma, '') AS FechaRH,\n  IFNULL(HL.VrNumerico, '') AS ResultadoRH,\n  IFNULL(ct.FToma, '') FTomaCitologia,\n  IFNULL(ct.FResultado, '') FResultadoCitologia,\n  g_ips.Nbre AS NIps,\n  g_ips.Direccion DireccionIps,\n  g_ips.Telefono AS Tel_IPS,\n  f_empresacontxconvenio.Nbre AS EmpresaFacturo,\n  IFNULL(g_usuarioxprograma.Peso_Inicio,'') AS Peso_Inicio,\n  IF(h_atencion.IdUsuarioPrograma=0,g_usuarioxprograma.Id,h_atencion.IdUsuarioPrograma) AS IdUsuarioPrograma,\n  g_usuario.Id_persona,\n  g_estadocivil.Nbre AS estadoCivil,\n  g_nivelestudio.Nbre AS nivelEducativo,\n  g_ocupacion.Nbre AS Ocupacion\nFROM  g_ips,  h_atencion\n  INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n  INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_municipio ON (g_persona.Id_Municipio = g_municipio.Id)\n  INNER JOIN g_departamento ON (g_municipio.Id_Dpto = g_departamento.Id)\n  INNER JOIN f_tiporegimen ON (f_empresacontxconvenio.Id_TipoRegimen = f_tiporegimen.Id)\n  INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n  INNER JOIN g_estadocivil ON (g_persona.Id_EstadoCivil = g_estadocivil.Id)\n  INNER JOIN g_nivelestudio ON (g_nivelestudio.Id = ingreso.Id_NivelEstudio)\n  INNER JOIN g_ocupacion ON (g_ocupacion.Id = ingreso.Id_Ocupacion)\n  LEFT JOIN h_examenfisico ON (h_examenfisico.Id_Atencion = h_atencion.Id)\n  LEFT JOIN g_usuarioxprograma ON (g_usuarioxprograma.Id_Usuario = g_usuario.Id_persona) AND (g_usuarioxprograma.Id_Programa=c_clasecita.Id_Programa)\n  LEFT JOIN (SELECT d.Id_Usuario,\n      h_antecedenteginecologico.No_G,\n      h_antecedenteginecologico.No_P,\n      h_antecedenteginecologico.No_C,\n      h_antecedenteginecologico.No_A,\n      h_antecedenteginecologico.No_E\n    FROM h_antecedenteginecologico\n      INNER JOIN (SELECT MAX(Id) Id,Id_Usuario\n        FROM h_antecedenteginecologico\n        GROUP BY Id_Usuario) d ON (d.Id = h_antecedenteginecologico.Id)) ag ON ( ag.Id_Usuario = ingreso.Id_Usuario) -- Numero de controles\n   LEFT JOIN (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '06')\n    GROUP BY ingreso.Id_Usuario) nc ON (nc.Id_Usuario = g_usuario.Id_persona) \n   LEFT JOIN (SELECT c_citas.Fecha_Cita,\n      c_citas.Id_Usuario\n    FROM c_citas\n      INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)\n    WHERE (c_clasecita.Id_Finalidad = 06 AND c_citas.Id_MotivoDesistida = 1 AND c_citas.Asistida = 0)\n    GROUP BY c_citas.Id_Usuario) fc ON (fc.Id_Usuario = g_usuario.Id_persona) AND (fc.Fecha_Cita > h_atencion.Fecha_Atencion) \n   LEFT JOIN\n    (SELECT\n      DATE_FORMAT(l_recepcion.FechaRecep,\n        '%Y-%m-%d'\n      ) AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM\n      l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim)\n        AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (202))\n    GROUP BY l_recepcion.Id_Paciente) HL ON (HL.Id_Paciente = g_usuario.Id_persona)         \n   LEFT JOIN (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      IFNULL(l_resultados.FechaResult,'') FResultado,\n      l_recepcion.Id_Paciente,\n      MAX(l_recepcion_citologia.Id_Recepcion)\n    FROM l_recepcion_citologia\n      INNER JOIN l_recepcion ON (l_recepcion_citologia.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      LEFT JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n    WHERE (l_recepcion.Estado = 0) GROUP BY l_recepcion.Id_Paciente) ct ON (ct.Id_Paciente = g_usuario.Id_persona)\nWHERE (h_atencion.Codigo_Dxp <> ''\n    AND c_clasecita.Id_Finalidad = '06'\n    AND ingreso.FechaIngreso >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.FechaIngreso <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND IFNULL(g_usuarioxprograma.FechaEgreso, 1)=1);";
            }
            System.out.println("Consulta Prenatal " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString("Regimen"), n, 0);
                    this.xModelo.setValueAt(rs.getString("Departamento"), n, 1);
                    this.xModelo.setValueAt(rs.getString("Municipio"), n, 2);
                    this.xModelo.setValueAt(rs.getString("Nombre1"), n, 3);
                    this.xModelo.setValueAt(rs.getString("Nombre2"), n, 4);
                    this.xModelo.setValueAt(rs.getString("Apellido1"), n, 5);
                    this.xModelo.setValueAt(rs.getString("Apellido2"), n, 6);
                    this.xModelo.setValueAt(rs.getString("Id_TipoIdentificacion"), n, 7);
                    this.xModelo.setValueAt(rs.getString("NoDocumento"), n, 8);
                    this.xModelo.setValueAt(rs.getString("FechaNac"), n, 9);
                    this.xModelo.setValueAt(rs.getString("Edad"), n, 10);
                    this.xModelo.setValueAt(rs.getString("Direccion"), n, 11);
                    this.xModelo.setValueAt(rs.getString("Telefono"), n, 12);
                    this.xModelo.setValueAt(rs.getString("Movil"), n, 13);
                    this.xModelo.setValueAt(rs.getString("estadoCivil"), n, 14);
                    this.xModelo.setValueAt(rs.getString("nivelEducativo"), n, 15);
                    this.xModelo.setValueAt(rs.getString("Ocupacion"), n, 16);
                    this.xModelo.setValueAt(rs.getString("FIngreso"), n, 17);
                    this.xModelo.setValueAt(rs.getString("FUM"), n, 18);
                    this.xModelo.setValueAt(rs.getString("FPP"), n, 19);
                    this.xModelo.setValueAt(rs.getString("SGestacionInicio"), n, 20);
                    this.xModelo.setValueAt(rs.getString("SGestacionActual"), n, 21);
                    this.xModelo.setValueAt(rs.getString("NGestacion"), n, 22);
                    this.xModelo.setValueAt(rs.getString("NPartos"), n, 23);
                    this.xModelo.setValueAt(rs.getString("NCesareas"), n, 24);
                    this.xModelo.setValueAt(rs.getString("NAbortos"), n, 25);
                    this.xModelo.setValueAt(rs.getString("NEctopico"), n, 26);
                    this.xModelo.setValueAt(rs.getString("Peso_Inicio"), n, 27);
                    this.xModelo.setValueAt(rs.getString("Talla"), n, 28);
                    this.xModelo.setValueAt(rs.getString("Imc"), n, 29);
                    this.xModelo.setValueAt(rs.getString("Peso"), n, 30);
                    this.xModelo.setValueAt(rs.getString("NCOntroles"), n, 31);
                    this.xModelo.setValueAt(rs.getString("FControl"), n, 32);
                    this.xModelo.setValueAt(rs.getString("PAS"), n, 33);
                    this.xModelo.setValueAt(rs.getString("PAD"), n, 34);
                    this.xModelo.setValueAt(rs.getString("FProximoControl"), n, 35);
                    this.xModelo.setValueAt(rs.getString("FechaRH"), n, 36);
                    this.xModelo.setValueAt(rs.getString("ResultadoRH"), n, 37);
                    this.xModelo.setValueAt(rs.getString("FTomaCitologia"), n, 86);
                    this.xModelo.setValueAt(rs.getString("FResultadoCitologia"), n, 87);
                    this.xModelo.setValueAt(rs.getString("NIps"), n, 89);
                    this.xModelo.setValueAt(rs.getString("DireccionIps"), n, 90);
                    this.xModelo.setValueAt(rs.getString("Tel_IPS"), n, 91);
                    this.xModelo.setValueAt(rs.getString("EmpresaFacturo"), n, 92);
                    this.xModelo.setValueAt(rs.getString("IdUsuarioPrograma"), n, 93);
                    this.xModelo.setValueAt(rs.getString("Id_persona"), n, 94);
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xsql = "SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_detalleresultado`.`VrNumerico`\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(266)\n AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'\n    )\nORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3 ";
                    System.out.println("VIH: " + this.xsql);
                    ResultSet xrs1 = xct.traerRs(this.xsql);
                    if (xrs1.next()) {
                        int i = 0;
                        xrs1.beforeFirst();
                        while (xrs1.next()) {
                            this.xModelo.setValueAt(xrs1.getString(1), n, 56 + (i * 2));
                            this.xModelo.setValueAt(xrs1.getString(2), n, 57 + (i * 2));
                            i++;
                        }
                    }
                    this.xsql = "SELECT DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` ,\n  `l_detalleresultado`.`VrNumerico`\n FROM `l_detallerecepcion` \n INNER JOIN `l_recepcion` ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \n INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) \n AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n  WHERE (`l_recepcion`.`Estado` =0 AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(276)\n  AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'\n  ) \n ORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3 ";
                    System.out.println("SIFILIS: " + this.xsql);
                    ResultSet xrs12 = xct.traerRs(this.xsql);
                    if (xrs12.next()) {
                        int i2 = 0;
                        xrs12.beforeFirst();
                        while (xrs12.next()) {
                            this.xModelo.setValueAt(xrs12.getString(1), n, 62 + (i2 * 2));
                            this.xModelo.setValueAt(xrs12.getString(2), n, 63 + (i2 * 2));
                            i2++;
                        }
                    }
                    this.xsql = "SELECT\n   DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` ,\n  `l_detalleresultado`.`VrNumerico`\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(2)\n    AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'\n   )\nORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3 ";
                    System.out.println("HEMOGRAMA: " + this.xsql);
                    ResultSet xrs13 = xct.traerRs(this.xsql);
                    if (xrs13.next()) {
                        xrs13.beforeFirst();
                        int i3 = 0;
                        while (xrs13.next()) {
                            this.xModelo.setValueAt(xrs13.getString(1), n, 68 + (i3 * 2));
                            this.xModelo.setValueAt(xrs13.getString(2), n, 69 + (i3 * 2));
                            i3++;
                        }
                    }
                    this.xsql = "SELECT\n     DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` ,\n  `l_detalleresultado`.`VrNumerico`\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(283)\n    AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'    \n    )\nORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3";
                    System.out.println("GLICEMIA: " + this.xsql);
                    ResultSet xrs14 = xct.traerRs(this.xsql);
                    if (xrs14.next()) {
                        xrs14.beforeFirst();
                        int i4 = 0;
                        while (xrs14.next()) {
                            this.xModelo.setValueAt(xrs14.getString(1), n, 74 + (i4 * 2));
                            this.xModelo.setValueAt(xrs14.getString(2), n, 75 + (i4 * 2));
                            i4++;
                        }
                    }
                    this.xsql = "SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` \nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` IN(907106)AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'    \n    )\n    GROUP BY `l_recepcion`.`Id`\nORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3 ";
                    System.out.println("DATOS DE ORINA: " + this.xsql);
                    ResultSet xrs15 = xct.traerRs(this.xsql);
                    if (xrs15.next()) {
                        int i5 = 0;
                        xrs15.beforeFirst();
                        while (xrs15.next()) {
                            this.xModelo.setValueAt(xrs15.getString(1), n, 80 + i5);
                            i5++;
                        }
                    }
                    this.xsql = "SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` \nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` IN(901304)\n AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'    \n    )\nORDER BY `l_recepcion`.`FechaRecep` ASC LIMIT 3";
                    System.out.println("FROTIS VAGINAL: " + this.xsql);
                    ResultSet xrs16 = xct.traerRs(this.xsql);
                    if (xrs16.next()) {
                        int i6 = 0;
                        xrs16.beforeFirst();
                        while (xrs16.next()) {
                            this.xModelo.setValueAt(xrs16.getString(1), n, 83 + i6);
                            i6++;
                        }
                    }
                    this.xsql = "SELECT\n  DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n  l_recepcion.Id_Paciente,\n  l_detalleresultado.VrNumerico,\n  MAX(l_recepcion.Id)\nFROM l_detallerecepcion\n  INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n  INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\nWHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (3, 4)\n AND l_recepcion.Id_Paciente = '" + rs.getString("Id_Persona") + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d')>= '" + rs.getString("FIngreso") + "')GROUP BY l_recepcion.Id_Paciente ORDER BY l_recepcion.FechaRecep ASC LIMIT 3;";
                    System.out.println("HEMATOCRITOS: " + this.xsql);
                    ResultSet xrs17 = xct.traerRs(this.xsql);
                    if (xrs17.next()) {
                        int i7 = 0;
                        xrs17.beforeFirst();
                        while (xrs17.next()) {
                            this.xModelo.setValueAt(xrs17.getString(1), n, 38 + (i7 * 2));
                            this.xModelo.setValueAt(xrs17.getString(2), n, 39 + (i7 * 2));
                            i7++;
                        }
                    }
                    this.xsql = "SELECT\n  DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n  l_recepcion.Id_Paciente,\n  l_detalleresultado.VrNumerico,\n  MAX(l_recepcion.Id)\nFROM l_detallerecepcion\n  INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n  INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\nWHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (373) AND l_recepcion.Id_Paciente = '" + rs.getString("Id_Persona") + "' \nAND DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d')>='" + rs.getString("FIngreso") + "' )GROUP BY l_recepcion.Id_Paciente ORDER BY l_recepcion.FechaRecep ASC LIMIT 3;";
                    System.out.println("HEPATITIS B: " + this.xsql);
                    ResultSet xrs18 = xct.traerRs(this.xsql);
                    if (xrs18.next()) {
                        int i8 = 0;
                        xrs18.beforeFirst();
                        while (xrs18.next()) {
                            this.xModelo.setValueAt(xrs18.getString(1), n, 44 + (i8 * 2));
                            this.xModelo.setValueAt(xrs18.getString(2), n, 45 + (i8 * 2));
                            i8++;
                        }
                    }
                    this.xsql = "SELECT\n  DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n  l_recepcion.Id_Paciente,\n  l_detalleresultado.VrNumerico,\n  MAX(l_recepcion.Id)\nFROM l_detallerecepcion\n  INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n  INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\nWHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (200) AND l_recepcion.Id_Paciente = '" + rs.getString("Id_Persona") + "' \nAND DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d')>='" + rs.getString("FIngreso") + "' )GROUP BY l_recepcion.Id_Paciente ORDER BY l_recepcion.FechaRecep ASC LIMIT 3;";
                    System.out.println("TEST SULLIVAN: " + this.xsql);
                    ResultSet xrs19 = xct.traerRs(this.xsql);
                    if (xrs19.next()) {
                        int i9 = 0;
                        xrs19.beforeFirst();
                        while (xrs19.next()) {
                            this.xModelo.setValueAt(xrs19.getString("FToma"), n, 50 + (i9 * 2));
                            this.xModelo.setValueAt(xrs19.getString("VrNumerico"), n, 51 + (i9 * 2));
                            i9++;
                        }
                    }
                    this.xsql = "SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma` \nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` IN(901235)\n AND `l_recepcion`.`Id_Paciente`='" + rs.getString("Id_Persona") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')>='" + rs.getString("FIngreso") + "'\n   AND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    )\nORDER BY `l_recepcion`.`FechaRecep` DESC LIMIT 1";
                    System.out.println("UROCULTIVO: " + this.xsql);
                    ResultSet xrs110 = xct.traerRs(this.xsql);
                    if (xrs110.next()) {
                        int i10 = 0;
                        xrs110.beforeFirst();
                        while (xrs110.next()) {
                            this.xModelo.setValueAt(xrs110.getString("FToma"), n, 88);
                            i10++;
                        }
                    }
                    xrs110.close();
                    xct.cerrarConexionBd();
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloProduccionPorSedeYProfesional() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NConevenio", "Id", "NFinalidad", "FechaIngreso", "FechaIngreso", "Id_Persona", "NProfesional", "Id", "NProedimiento", "Id_persona", "NUsuario", "Id_TipoIdentificacion", "NoDocumento", "Edad", "TipoEdad", "Id_DxPrincipal", "DxRelacional1", "DxRelacional2", "DxRelacional3", "Sede"}) { // from class: Sig.JIFFConsultarInformacionGenerico.6
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
    }

    private void mCargarDatosProduccionPorSedeYProfesional() {
        mCrearModeloProduccionPorSedeYProfesional();
        try {
            this.xsql = null;
            this.xsql = "SELECT\n    `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` AS `NConevenio`\n    , `f_tipofinprocedimiento`.`Id`\n    , `f_tipofinprocedimiento`.`Nbre` AS `NFinalidad`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`FechaIngreso`\n    , `profesional1`.`Id_Persona`\n    , `profesional1`.`NProfesional`\n    , `g_procedimiento`.`Id`\n    , `g_procedimiento`.`Nbre` AS `NProedimiento`\n    , `g_persona`.Id `Id_persona`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) `NUsuario`\n    , g_persona.`Id_TipoIdentificacion` \n    , g_persona.`NoDocumento`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`,`ingreso`.`FechaIngreso` ) Edad\n    , `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,`ingreso`.`FechaIngreso` ) TipoEdad\n    ,IFNULL(`f_itemripsconsulta`.`Id_DxPrincipal`,'')Id_DxPrincipal\n    , IFNULL(`f_itemripsconsulta`.`DxRelacional1`,'')DxRelacional1\n    , IFNULL(`f_itemripsconsulta`.`DxRelacional2`,'')DxRelacional2\n    , IFNULL(`f_itemripsconsulta`.`DxRelacional3`,'')DxRelacional3, g_sedes.`Nbre` AS Sede\nFROM\n     `f_ordenes`\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n         INNER JOIN  `g_sedes`\n        ON (`g_sedes`.`Id`= `ingreso`.`Id_Sede`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `f_tipofinprocedimiento` \n        ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`)\n    INNER JOIN  `g_persona`\n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    LEFT JOIN  `f_itemripsconsulta` \n        ON (`f_itemripsconsulta`.`Id_Ordenes` = `f_itemordenesproced`.`Id_Ordenes`) AND (`f_itemripsconsulta`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`)\nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `f_ordenes`.`Estado` =0)\nORDER BY `NConevenio` ASC, `NFinalidad` ASC, `profesional1`.`NProfesional` ASC;";
            System.out.println("Produccion por Sede y Profesional  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(7)), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(11)), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloInformeRes2463() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Id_Sexo", "Id_R2463", "CRips", "Id_Etnia", "IdPoblacionEspecial", "Mnunicipio", "Telefono", "FAfiliacion", "CodigoOrganismo", "HTA", "FechaDxHTA", "EsDiabetes", "FechaDiabetes", "Peso", "Talla", "TArtSentadoS", "TArtSentadoD", "CreatininaR", "CreatininaF", "ColesterolTR", "ColesterolTF", "ColesterolCHDL", "ColesterolCHDL", "ColesterolLDL", "ColesterolLDL", "MedcamentosHTA", "MedcamentosHTA1", "Hemoglobina", "Nbre"}) { // from class: Sig.JIFFConsultarInformacionGenerico.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(50);
    }

    private void mCargarDatosInformeRes2463() {
        mCrearModeloInformeRes2463();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `g_persona`.`Nombre1`\n    , IF(`g_persona`.`Nombre2`='', 'NONE',`g_persona`.`Nombre2`) AS `Nombre2`\n    , `g_persona`.`Apellido1`\n    , IF(`g_persona`.`Apellido2`='', 'NONE',`g_persona`.`Apellido2`)   AS `Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`, f_tiporegimen.`Id_R2463` , f_empresacontxconvenio.`CRips`\n    , `g_persona`.`Id_Etnia`    \n    , `g_usuario`.`IdPoblacionEspecial`    \n    , g_municipio.`Nbre` Mnunicipio\n, `g_persona`.`Movil` AS `Telefono`\n, '' AS `FAfiliacion` , g_ips.`CodigoOrganismo`   \n, IFNULL(g_usuarioxprograma.`EsDM_HTA`,2) HTA\n, IFNULL(g_usuarioxprograma.`FechaDxhta`,'1800-01-01') FechaDxHTA\n, IF(g_usuarioxprograma.`FechaDIab` IS NULL,2, 1) EsDiabetes\n, IFNULL(g_usuarioxprograma.`FechaDIab`,'1845-01-01') FechaDiabetes\n, IFNULL(h_examenfisico.`Peso`, '') Peso\n, IFNULL(h_examenfisico.`Talla`, '')Talla\n,IFNULL( h_examenfisico.`TArtSentadoS`, '') TArtSentadoS\n,IFNULL(h_examenfisico.`TArtSentadoD`, '') TArtSentadoD\n, IFNULL(C.Resultado, '99') CreatininaR\n, IFNULL(C.Fecha,'1800-01-01')CreatininaF\n, IFNULL(Ct.Resultado, '99') ColesterolTR\n, IFNULL(Ct.Fecha,'1800-01-01')ColesterolTF\n, IFNULL(CHDL.Resultado, '99') ColesterolCHDL\n, IFNULL(CHDL.Fecha,'1800-01-01')ColesterolCHDL       \n, IFNULL(LDL.Resultado, '99') ColesterolLDL\n, IFNULL(LDL.Fecha,'1800-01-01')ColesterolLDL\n, IF(MHTA.MedHta IS NULL, '99', '1') MedcamentosHTA\n, IF(MHTA1.MedHta IS NULL, '99', '1') MedcamentosHTA1\n, IFNULL(HB.Resultado, '99') Hemoglobina\n, cc_terceros.RazonSocialCompleta\n    \nFROM `g_ips`, \n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        LEFT JOIN `h_examenfisico`\n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN cc_terceros \n        ON (cc_terceros.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n LEFT JOIN `g_usuarioxprograma` \n        ON (`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`) AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)        \n -- CREATININA\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903825\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) C ON (C.`Id_Paciente`=`ingreso`.`Id_Usuario`)        \n\n-- COLESTEROL TOTAL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903818 AND l_protocoloxprocedimiento.`Id_Protocolo`=55\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) Ct ON (Ct.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n\n-- COLESTEROL HDL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903815 AND l_protocoloxprocedimiento.`Id_Protocolo`=56\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) CHDL ON (CHDL.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n\n\n-- COLESTEROL LDL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903816 AND l_protocoloxprocedimiento.`Id_Protocolo`=57\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) LDL ON (LDL.`Id_Paciente`=`ingreso`.`Id_Usuario`)    \n\n-- medicamentos de hta\nLEFT JOIN (SELECT\n    `i_salidas`.`IdDestino` MedHta\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`i_atcsubgrupofarmacologico`.`Id` ='C09A'\n    AND `i_salidas`.`Estado` =0    \n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `i_salidas`.`IdDestino`) MHTA ON(MHTA.MedHta=ingreso.`Id_Usuario`)\n\n\n-- medicamentos de hta II\nLEFT JOIN (SELECT\n    `i_salidas`.`IdDestino` MedHta\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`i_atcsubgrupofarmacologico`.`Id` ='C09C'\n    AND `i_salidas`.`Estado` =0    \n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `i_salidas`.`IdDestino`) MHTA1 ON(MHTA1.MedHta=ingreso.`Id_Usuario`)\n\n\n-- HEMOGLOBINA\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =902210 AND l_protocoloxprocedimiento.`Id_Protocolo`IN(2,1)\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) HB ON (HB.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n        \nWHERE (`c_clasecita`.`Id_Programa` IN(1,2) AND h_atencion.`Codigo_Dxp`<>'' AND cc_terceros.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "');";
            } else {
                this.xsql = "SELECT `g_persona`.`Nombre1`\n    , IF(`g_persona`.`Nombre2`='', 'NONE',`g_persona`.`Nombre2`) AS `Nombre2`\n    , `g_persona`.`Apellido1`\n    , IF(`g_persona`.`Apellido2`='', 'NONE',`g_persona`.`Apellido2`)   AS `Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`, f_tiporegimen.`Id_R2463` , f_empresacontxconvenio.`CRips`\n    , `g_persona`.`Id_Etnia`    \n    , `g_usuario`.`IdPoblacionEspecial`    \n    , g_municipio.`Nbre` Mnunicipio\n, `g_persona`.`Movil` AS `Telefono`\n, '' AS `FAfiliacion` , g_ips.`CodigoOrganismo`   \n, IFNULL(g_usuarioxprograma.`EsDM_HTA`,2) HTA\n, IFNULL(g_usuarioxprograma.`FechaDxhta`,'1800-01-01') FechaDxHTA\n, IF(g_usuarioxprograma.`FechaDIab` IS NULL,2, 1) EsDiabetes\n, IFNULL(g_usuarioxprograma.`FechaDIab`,'1845-01-01') FechaDiabetes\n, IFNULL(h_examenfisico.`Peso`, '') Peso\n, IFNULL(h_examenfisico.`Talla`, '')Talla\n,IFNULL( h_examenfisico.`TArtSentadoS`, '') TArtSentadoS\n,IFNULL(h_examenfisico.`TArtSentadoD`, '') TArtSentadoD\n, IFNULL(C.Resultado, '99') CreatininaR\n, IFNULL(C.Fecha,'1800-01-01')CreatininaF\n, IFNULL(Ct.Resultado, '99') ColesterolTR\n, IFNULL(Ct.Fecha,'1800-01-01')ColesterolTF\n, IFNULL(CHDL.Resultado, '99') ColesterolCHDL\n, IFNULL(CHDL.Fecha,'1800-01-01')ColesterolCHDL       \n, IFNULL(LDL.Resultado, '99') ColesterolLDL\n, IFNULL(LDL.Fecha,'1800-01-01')ColesterolLDL\n, IF(MHTA.MedHta IS NULL, '99', '1') MedcamentosHTA\n, IF(MHTA1.MedHta IS NULL, '99', '1') MedcamentosHTA1\n, IFNULL(HB.Resultado, '99') Hemoglobina\n, cc_terceros.RazonSocialCompleta\n    \nFROM `g_ips`, \n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        LEFT JOIN `h_examenfisico`\n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN cc_terceros \n        ON (cc_terceros.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n LEFT JOIN `g_usuarioxprograma` \n        ON (`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`) AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)        \n -- CREATININA\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903825\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) C ON (C.`Id_Paciente`=`ingreso`.`Id_Usuario`)        \n\n-- COLESTEROL TOTAL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903818 AND l_protocoloxprocedimiento.`Id_Protocolo`=55\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) Ct ON (Ct.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n\n-- COLESTEROL HDL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903815 AND l_protocoloxprocedimiento.`Id_Protocolo`=56\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) CHDL ON (CHDL.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n\n\n-- COLESTEROL LDL\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =903816 AND l_protocoloxprocedimiento.`Id_Protocolo`=57\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) LDL ON (LDL.`Id_Paciente`=`ingreso`.`Id_Usuario`)    \n\n-- medicamentos de hta\nLEFT JOIN (SELECT\n    `i_salidas`.`IdDestino` MedHta\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`i_atcsubgrupofarmacologico`.`Id` ='C09A'\n    AND `i_salidas`.`Estado` =0    \n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `i_salidas`.`IdDestino`) MHTA ON(MHTA.MedHta=ingreso.`Id_Usuario`)\n\n\n-- medicamentos de hta II\nLEFT JOIN (SELECT\n    `i_salidas`.`IdDestino` MedHta\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`i_atcsubgrupofarmacologico`.`Id` ='C09C'\n    AND `i_salidas`.`Estado` =0    \n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `i_salidas`.`IdDestino`) MHTA1 ON(MHTA1.MedHta=ingreso.`Id_Usuario`)\n\n\n-- HEMOGLOBINA\n LEFT JOIN (SELECT MAX(l_recepcion.`Id`), `l_recepcion`.`Id_Paciente`,\n    DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\n    , `l_detalleresultado`.`VrNumerico` Resultado\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `l_detalleresultado`.`Id_Procedimiento` =902210 AND l_protocoloxprocedimiento.`Id_Protocolo`IN(2,1)\n    AND `l_resultados`.`Estado` =0 \n    )\nGROUP BY `l_recepcion`.Id_Paciente) HB ON (HB.`Id_Paciente`=`ingreso`.`Id_Usuario`)      \n        \nWHERE (`c_clasecita`.`Id_Programa` IN(1,2) AND h_atencion.`Codigo_Dxp`<>'');";
            }
            System.out.println("Informe 2463 :   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 30);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    this.xModelo.setValueAt(rs.getString(33), n, 32);
                    this.xModelo.setValueAt(rs.getString(34), n, 33);
                    this.xModelo.setValueAt(rs.getString(35), n, 34);
                    this.xModelo.setValueAt(rs.getString(36), n, 35);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloInformeRes4725() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id_Programa", "Empresa", "Id_TipoRegimen", "IdPoblacionEspecial", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Id_Sexo", "Id_Etnia", "Direccion", "Telefono", "CMunicipio", "FAfiliacion", "PPGestante", "TTuberculosis", "FVIH", "CLPruebaVIH", "VDRL"}) { // from class: Sig.JIFFConsultarInformacionGenerico.8
            Class[] types = {Long.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
    }

    private void mCargarDatosInformeRes4725() {
        mCrearModeloInformeRes4725();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n    `c_clasecita`.`Id_Programa`, cc_terceros.RazonSocialCompleta\n    , `f_empresacontxconvenio`.`Id_TipoRegimen`, `g_usuario`.`IdPoblacionEspecial`\n    , `g_persona`.`Nombre1`, IF(`g_persona`.`Nombre2`='', 'NONE',`g_persona`.`Nombre2`) AS `Nombre2`\n    , `g_persona`.`Apellido1`, IF(`g_persona`.`Apellido2`='', 'NONE',`g_persona`.`Apellido2`)   AS `Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`, `g_persona`.`Id_Etnia`, `g_persona`.`Direccion`, `g_persona`.`Movil` AS `Telefono`\n    ,  MID(`g_municipio`.`Id`,3,3) AS `CMunicipio`, '' AS `FAfiliacion`\n    , IF(`g_tipoprograma`.`EsPrenatal`=1,IF( c_clasecita.`Id`=39, 2, 1),IF(`g_persona`.`Id_Sexo`='F', 0, 3)) AS `PPGestante`\n    , IF( c_clasecita.`Id`=41, 1, 0) AS `TTuberculosis`\n    , IFNULL((SELECT DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\nFROM `l_detalleresultado` INNER JOIN `l_resultados` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_protocoloxprocedimiento` \nON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \nAND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detalleresultado`.`Id_Procedimiento`)\nINNER JOIN `l_recepcion` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND `l_detalleresultado`.`Id_Procedimiento` IN(906255, 906249)\nAND `l_resultados`.`Estado` =0 AND `l_recepcion`.`Id_Paciente` =`ingreso`.`Id_Usuario`)\nGROUP BY `l_recepcion`.`Id_Paciente` ), '1799-01-01') FVIH,'3' CLPruebaVIH, IFNULL((SELECT\nGROUP_CONCAT(DISTINCT CONCAT(DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d'), ' ' ,l_detalleresultado.`VrNumerico`)  SEPARATOR'\\n') AS `Fecha`\nFROM `l_detalleresultado`\nINNER JOIN `l_resultados` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_detalleresultado`.`Fecha`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `l_detalleresultado`.`Fecha`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND `l_detalleresultado`.`Id_Procedimiento` =906916 AND `l_resultados`.`Estado` =0 AND `l_recepcion`.`Id_Paciente` =`ingreso`.`Id_Usuario`)\nGROUP BY `l_recepcion`.`Id_Paciente` ORDER BY `l_detalleresultado`.`Fecha`), '') VDRL\nFROM `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nINNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\nINNER JOIN cc_terceros ON (cc_terceros.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nINNER JOIN `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nWHERE (`c_clasecita`.`Id_Programa` IN(3,18) AND `ingreso`.`Id_Usuario` AND cc_terceros.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')\nGROUP BY ingreso.`Id_Usuario` ORDER BY `g_persona`.`Apellido1`, `g_persona`.`Apellido2`";
            } else {
                this.xsql = "SELECT\n    `c_clasecita`.`Id_Programa`, cc_terceros.RazonSocialCompleta\n    , `f_empresacontxconvenio`.`Id_TipoRegimen`, `g_usuario`.`IdPoblacionEspecial`\n    , `g_persona`.`Nombre1`, IF(`g_persona`.`Nombre2`='', 'NONE',`g_persona`.`Nombre2`) AS `Nombre2`\n    , `g_persona`.`Apellido1`, IF(`g_persona`.`Apellido2`='', 'NONE',`g_persona`.`Apellido2`)   AS `Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`, `g_persona`.`Id_Etnia`, `g_persona`.`Direccion`, `g_persona`.`Movil` AS `Telefono`\n    ,  MID(`g_municipio`.`Id`,3,3) AS `CMunicipio`, '' AS `FAfiliacion`\n    , IF(`g_tipoprograma`.`EsPrenatal`=1,IF( c_clasecita.`Id`=39, 2, 1),IF(`g_persona`.`Id_Sexo`='F', 0, 3)) AS `PPGestante`\n    , IF( c_clasecita.`Id`=41, 1, 0) AS `TTuberculosis`\n    , IFNULL((SELECT DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d')     AS `Fecha`\nFROM `l_detalleresultado` INNER JOIN `l_resultados` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_protocoloxprocedimiento` \nON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \nAND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detalleresultado`.`Id_Procedimiento`)\nINNER JOIN `l_recepcion` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_resultados`.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND `l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND `l_detalleresultado`.`Id_Procedimiento` IN(906255, 906249)\nAND `l_resultados`.`Estado` =0 AND `l_recepcion`.`Id_Paciente` =`ingreso`.`Id_Usuario`)\nGROUP BY `l_recepcion`.`Id_Paciente` ), '1799-01-01') FVIH,'3' CLPruebaVIH, IFNULL((SELECT\nGROUP_CONCAT(DISTINCT CONCAT(DATE_FORMAT(`l_detalleresultado`.`Fecha`, '%Y-%m-%d'), ' ' ,l_detalleresultado.`VrNumerico`)  SEPARATOR'\\n') AS `Fecha`\nFROM `l_detalleresultado`\nINNER JOIN `l_resultados` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_detalleresultado`.`Fecha`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `l_detalleresultado`.`Fecha`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND `l_detalleresultado`.`Id_Procedimiento` =906916 AND `l_resultados`.`Estado` =0 AND `l_recepcion`.`Id_Paciente` =`ingreso`.`Id_Usuario`)\nGROUP BY `l_recepcion`.`Id_Paciente` ORDER BY `l_detalleresultado`.`Fecha`), '') VDRL\nFROM `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nINNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\nINNER JOIN cc_terceros ON (cc_terceros.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nINNER JOIN `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nWHERE (`c_clasecita`.`Id_Programa` IN(3,18) AND `ingreso`.`Id_Usuario`)\nGROUP BY ingreso.`Id_Usuario` ORDER BY `g_persona`.`Apellido1`, `g_persona`.`Apellido2`";
            }
            System.out.println("Informe 4725 :   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(4)), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(13)), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatoslistadoProductoCategoria() {
        mCrearModelolistadoProductoCategoria();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT    i_suministro.Nbre AS Producto    , i_principioactivo.Nbre AS P_Activo    , i_formafarmaceutica.Nbre AS formaF    , i_concentracion.Nbre AS Concentracion    , i_suministro.RegistroInvima    , i_presentacioncomercial.Nbre AS PComercial    , i_categoria.Nbre AS Categoria FROM g_ips,    i_suministro    INNER JOIN i_principioactivo        ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)    INNER JOIN i_concentracion        ON (i_suministro.IdConcentracion = i_concentracion.Id)    INNER JOIN i_presentacioncomercial        ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)    INNER JOIN i_presentacionfarmaceutica        ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)    INNER JOIN i_formafarmaceutica        ON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id)    INNER JOIN i_categoria        ON (i_suministro.IdCategoria = i_categoria.Id)        WHERE(i_categoria.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')ORDER BY Categoria ASC, Producto ASC;";
            } else {
                this.xsql = "SELECT    i_suministro.Nbre AS Producto    , i_principioactivo.Nbre AS P_Activo    , i_formafarmaceutica.Nbre AS formaF    , i_concentracion.Nbre AS Concentracion    , i_suministro.RegistroInvima    , i_presentacioncomercial.Nbre AS PComercial    , i_categoria.Nbre AS Categoria FROM g_ips,    i_suministro    INNER JOIN i_principioactivo        ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)    INNER JOIN i_concentracion        ON (i_suministro.IdConcentracion = i_concentracion.Id)    INNER JOIN i_presentacioncomercial        ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)    INNER JOIN i_presentacionfarmaceutica        ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)    INNER JOIN i_formafarmaceutica        ON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id)    INNER JOIN i_categoria        ON (i_suministro.IdCategoria = i_categoria.Id)ORDER BY Categoria ASC, Producto ASC;";
            }
            System.out.println("Produccion por Sede y Profesional  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModelolistadoProductoCategoria() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Producto", "P_Activo", "F_Farmaceutica", "Concentracion", "R_Invima", "P_comercial", "Categoria"}) { // from class: Sig.JIFFConsultarInformacionGenerico.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCrearModeloConsolDescuenNomina() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaD", "Id_TipoIden", "NoDocumento", "NUsuario", "IdTipoEmpr", "TipoEmpresa", "Valor", "VDescontado"}) { // from class: Sig.JIFFConsultarInformacionGenerico.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCargarDatosConsolDescuenNomina() {
        mCrearModeloConsolDescuenNomina();
        try {
            this.xsql = null;
            this.xsql = "SELECT\n    `d_descuento`.`Id`\n    , `d_descuento`.`FechaD`\n    , `persona_fpz`.`Id_TipoIdentificacion`\n    , `persona_fpz`.`NoDocumento`\n    , `persona_fpz`.`NUsuario`\n    , `persona_fpz`.`IdTipoEmpresa`\n    , `persona_fpz`.`TipoEmpresa`\n    , `d_descuento`.`Valor`\n    ,ROUND(IF( IF(`d_descuento`.`VDescontado`=`d_descuento`.`Valor`, `d_descuento`.`Valor`\n    ,SUM(`d_detalle_relacion`.`VDescontado`)) IS NULL, 0\n    ,IF(`d_descuento`.`VDescontado`=`d_descuento`.`Valor`, `d_descuento`.`Valor`\n    ,SUM(`d_detalle_relacion`.`VDescontado`)))) AS VDescontado\n    #, sum(`d_detalle_relacion`.`VDescontado`) AS `VDescontado`\n    #, `d_descuento`.`Excluir`\n    #, `d_descuento`.`VDescontado`\nFROM  `d_descuento`  \n    LEFT JOIN `d_detalle_relacion` ON (`d_detalle_relacion`.`Id_Descuento` = `d_descuento`.`Id`)\n    INNER JOIN `persona_fpz` ON (`persona_fpz`.`Id_persona` = `d_descuento`.`Id_PersonaDescuento`)\nWHERE (`d_descuento`.`FechaD` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `d_descuento`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `d_descuento`.`Id` ORDER BY `persona_fpz`.`NUsuario` ASC;";
            System.out.println("Descuento Informe Facturacion :   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(6)), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(8)), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloPrograma() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Especialidad", "Profesional", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "TipoIdentificación", "NoDocumento", "Edad", "NConvenio", "Direccion", "Barrio", "Municipio", "Telefono", "Movil", "Programa", "Nuevo", "SGestación", "CDxP", "NDxP", "CDxR1", "NDxR1", "CDxR2", "NDxR2", "CDxR3", "NDxR3"}) { // from class: Sig.JIFFConsultarInformacionGenerico.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
    }

    private void mCrearModeloEspecialidad() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id_Tercero", "Empresa", "Id_Convenio", "Convenio", "Id_Programa", "Programa", "Id_ClaseCita", "Tipo Cita", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCrearModeloRadiologia() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Razon Social", "Nombre", "Total Órdenes", "Orden Ambularia", "Orden Hospitalizado", "Orden Urgencia", "Total Estudios", "Est Ambulatoria", "Est. Hospitalizado", "Est. Urgencia"}) { // from class: Sig.JIFFConsultarInformacionGenerico.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
    }

    private void mCrearModeloProcedimiento() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Procedimiento", "Total Órdenes", "Orden Ambularia", "Orden Hospitalizado", "Orden Urgencia", "Total Estudios", "Est Ambulatoria", "Est. Hospitalizado", "Est. Urgencia"}) { // from class: Sig.JIFFConsultarInformacionGenerico.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
    }

    private void mCrearModeloProcedimientoDet() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Razon Social", "Nombre", "Nombre Procedimiento", "Total Órdenes", "Orden Ambularia", "Orden Hospitalizado", "Orden Urgencia", "Total Estudios", "Est Ambulatoria", "Est. Hospitalizado", "Est. Urgencia"}) { // from class: Sig.JIFFConsultarInformacionGenerico.15
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(60);
    }

    private void mCrearModeloAsigancionCitas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre Usuario", "Cantidad Citas"}) { // from class: Sig.JIFFConsultarInformacionGenerico.16
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
    }

    private void mCrearModeloCitasPorEmpresa() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Usuario", "Sexo", "Clase Cita", "EmpresaC", "EmpresaF", "Fecha I", "Hora Atención", "Especialiad", "Profesional", "Id", "Fecha Solicitud", "Fecha Asignacion", "Forma"}) { // from class: Sig.JIFFConsultarInformacionGenerico.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
    }

    private void mCrearModeloEstadisProcedLab() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Procedimiento", "Total Órdenes", "Orden Ambulatorio", "Orden Hospitalizado", "Orden Urgencia", "Total Estudios", "Est Ambulatorio", "Est Hospitalizado", "Est. Urgencia"}) { // from class: Sig.JIFFConsultarInformacionGenerico.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
    }

    private void mCrearModeloConsolProcedLabDet() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Razón Social", "Nombre", "Procedimiento", "Total Órdenes", "Orden Ambulatoria", "Orden Hospitalizado", "Orden Urgencia", "Total Estudio", "Est. Ambulatoria", "Est. Hospitalizado", "Est. Urgencia"}) { // from class: Sig.JIFFConsultarInformacionGenerico.19
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(60);
    }

    private void mCrearModeloRiesgoObstetrico() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FechaI", "FechaA", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "TipoIdentificación", "NoDocumento", "FechaN", "Edad", "NSexo", "EPS", "Direccion", "Barrio", "Municipio", "Telefono", "Movil", "EMenarquia", "FUMestruacion", "PIntergenesico", "EGestación", "CDxP", "CRiesgo", "Cie10P", "Cie10S", "FPParto", "NEmbarazo", "NAbortos", "NPartos", "NCesareas", "NEctopicos", "NNacMuertos", "NNacVivos", "FUParto", "FULegrado", "Peso", "Talla", "Imc", "PSistolica", "PDistolica", "Id", "RHemoglobina", "FHemoglobina", "RHematocrito", "FHematocrito", "RHemoclasificacion", "FHemoclasificacion", "RVDRL", "FVDRL", "RVih", "RVih", "RGlucosa", "FGlucosa", "RSullivan", "FSullivan", "ROrina", "FOrina", "RUrocultivo", "RIgG", "FIgG", "RIgM", "FIgM", "RHepatitisB", "FHepatitisB"}) { // from class: Sig.JIFFConsultarInformacionGenerico.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMaxWidth(0);
    }

    private void mCrearModeloRiesgoCardiovascular() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FIngreso", "FAtencion", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Edad", "NSexo", "EPS", "Direccion", "NBarrio", "NMunicipio", "Telefono", "Celular", "CHTA", "Fecha_conf", "CostosHTA", "CDiabetes", "Fecha_confdbt", "CostosDBT", "EtiologiaR", "Peso", "Talla", "Imc", "Psistolica", "Pdistolica", "clasificacion", "Id", "RCreatinida", "FCreatinida", "RHemoglobinaGlico", "FHemoglobinaGlico", "RCTotal", "FCTotal", "RCHdl", "FCHdl", "RCLdl", "FCLdl", "RCTrigliceridos", "FCTrigliceridos", "RPotasio", "FPotasio", "RMicroalbuminuria", "FMicroalbuminuria", "Id", "NPatologia", "ClasiCita", "MInhibidor", "MAntagonista", "EnfRenal"}) { // from class: Sig.JIFFConsultarInformacionGenerico.21
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMaxWidth(0);
    }

    private void mCrearModeloConsolidadoAtencionFecha() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Ingreso", "Empresa", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.22
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCrearModeloProcedimientosEmpresa() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.23
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mCrearModeloCirugiasNoProgramadas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"IdEmpresa", "Nombre Empresa", "IdClaseCita", "Clase Cita", "Especialidad", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.24
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCrearModeloConsolidadoPorProfesional() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Especialidad", "Id_Profesional", "Profesional", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.25
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCrearModeloCirugiasPorEPS() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Convenio", "Id", "Especialidad", "Id_Profesional", "Profesional", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.26
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCrearModeloCirugiasUsuariosEPSyProfesional() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Convenio", "Id", "Especialidad", "Id_Profesional", "Profesional", "Documento", "Nombre Paciente", "Edad", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.27
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(40);
    }

    private void mCrearModeloDetalleEntradaPorBodega() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Factura", "Periodo", "TipoMovimiento", "Id", "Id", "Suministro", "Presentación", "Cantidad", "Valor Unitario", "Iva", "Total", "Razón Social"}) { // from class: Sig.JIFFConsultarInformacionGenerico.28
            Class[] types = {Long.class, Long.class, String.class, String.class, Long.class, Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
    }

    private void mCrearModeloConsultarAtenciones() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Hora Atención", "No Historia", "Usuario", "Edad", "Codigo Dxp", "Profesional", "Especialidad", "Id", "Id_Usuario", "Nombre Dx", "Motivo Atención", "Conclusión", "Recomendaciones", "Sede", "0", "Id Especialista", "Clase de Citas", "Finalidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.29
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(80);
    }

    private void mCrearModeloConsolidadoOrdenesMedico() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Especialidad", "Profesional", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.30
            Class[] types = {String.class, String.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCrearModeloConsolidOrdenConvenioProf() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Empresa Convenio", "Especialidad", "Profesional", "Id", "Procedimiento", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.31
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mCrearModeloPacienteFacAtencion() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FechaD", "NoHistoria", "Nombre", "Edad", "Sexo", "HoraIngreso", "Estado", "NTipo", "EmpresaFac"}) { // from class: Sig.JIFFConsultarInformacionGenerico.32
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    private void mCrearModeloControlPrenatal() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "Municipio", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Edad", "Direccion", "Telefono", "FUMestruacion", "SemanaG", "NControles", "Edad Gestacion Parto", "FUltimoCOntrol", "FechaTomaVIH", "ResultadoVIH", "FechaTomaSifilis", "ResultadoSifilis", "NIps", "DireccionIps", "TelefonoIps", "CRiesgo", "EmpresaFacturada"}) { // from class: Sig.JIFFConsultarInformacionGenerico.33
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
    }

    private void mCrearModeloSaludOcupacionalDX() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Atencion", "Tipo Identificacion", "NoDocumento", "Nombre", "Edad", "Escolaridad", "EstadoCivil", "NEps", "AccidenteTrabajo", "EnfermedadProfesional", "P Deporte", "C Deporte", "Fuma", "Obs Fuma", "C Alcohol", "Cual Alcohol", "ObsAlcohol", "Visiometia", "R V Observacion", "Resultado Audiometria", "RAObservacion", "Resultado Espirometria", "REObservacion", "ROsteomuscular", "Concepto", "DxP", "DxR1", "IMC", "Recomendaciones", "Observacion", "NEmpresa"}) { // from class: Sig.JIFFConsultarInformacionGenerico.34
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
    }

    private void mCrearModeloConsultarOrdenProced() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Atencion", "Tipo Identificacion", "NoDocumento", "NoHistoria", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Edad", "TEdad", "NTIpoCita", "Profesional", "Dx_P", "NDx_P", "Dx_P1", "NDx_P1", "Dx_P2", "NDx_P2", "Dx_P3", "NDx_P3", "IdServ", "Servicio", "IdProce", "Procedimiento"}) { // from class: Sig.JIFFConsultarInformacionGenerico.35
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(80);
    }

    private void mCrearModeloInforLipidosCarbo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Aten", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Tipo Doc", "NoDocumento", "NoHistoria", "NEntidad", "TipoAfiliado", "Parentesco", "Edad", "RColesterolTotal", "RCHDL", "RCLDL", "RTrigliceridos", "RGlucosa", "TtoFarmacologico", "Programa", "CDxP", "DxP", "CDx1", "Dx1", "CDx2", "Dx2", "CDx3", "Dx3", "FUltimaCNutricion"}) { // from class: Sig.JIFFConsultarInformacionGenerico.36
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(80);
    }

    private void mCrearModeloTotalDosiSuministradas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Vacuna", "Dosis", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.37
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    private void mCrearModeloTotalDosiSuministroEntidad() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Empresa", "Vacuna", "Dosis", "Cantidad"}) { // from class: Sig.JIFFConsultarInformacionGenerico.38
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void mCrearModeloVacunacionAplicxUsuario() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Empresa", "Tipo Doc", "No Doc", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Sexo", "Edad", "T Edad", "Dirección", "Barrio", "Municipio", "Vacuna", "Dosis", "Vacunador"}) { // from class: Sig.JIFFConsultarInformacionGenerico.39
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    private void mCrearModeloFormuSubgruFarmacologico() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Doc", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Sexo", "Edad", "T Edad", "FechaOrden", "IdSuministro", "NSuministro", "NPricincipioActivo", "Cantidad", "NSubGrupoFamacologico", "Especialidad", "Profesional"}) { // from class: Sig.JIFFConsultarInformacionGenerico.40
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    private void mCrearModeloEmpresaConveFarmacologico() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Doc", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Sexo", "Edad", "T Edad", "FechaOrden", "IdSuministro", "NSuministro", "NPricincipioActivo", "Cantidad", "NSubGrupoFamacologico", "Empresa"}) { // from class: Sig.JIFFConsultarInformacionGenerico.41
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
    }

    private void mCrearModeloInformeAutorizacion() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaA", "Razón Social", "No Documento", "Usuario", "IdProce", "Procedimiento", "Cantidad", "Valor", "Obervación", "Empresa a Facturar"}) { // from class: Sig.JIFFConsultarInformacionGenerico.42
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
    }

    private void mCrearModeloProcedimientosOrdenadosUsuario() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Identificacion", "No. Documento", "Apellido No.1", "Apellido No.2", "Nombre No.1", "Nombre No.2", "Sexo", "Edad", "Fecha Orden", "IdProcedimiento", "Procedimiento", "Convenio", "Especialidad", "Profesional"}) { // from class: Sig.JIFFConsultarInformacionGenerico.43
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
    }

    private void mCargarDatosInformeAutorizacion() {
        mCrearModeloInformeAutorizacion();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n    `f_a_autorizacion_servicios`.`Id`\n    , `f_a_autorizacion_servicios`.`FechaA`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , gp.NoDocumento `NoDocumento`\n    , concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n    , `g_procedimiento`.`Id` AS IdProcedimiento\n    , `g_procedimiento`.`Nbre` AS Procedimiento\n    , `f_a_autorizacion_servicios_detalle`.`Cantidad`\n    , `f_a_autorizacion_servicios_detalle`.`Valor`\n    , if(`f_a_autorizacion_servicios_detalle`.`Observacion`='null','', `f_a_autorizacion_servicios_detalle`.`Observacion`) Observacion, ifnull(`f_empresacontxconvenio`.`Nbre`,'NO APLICA') AS `NEmpresaConvenio`\nFROM\n    `f_a_autorizacion_servicios` \n    INNER JOIN `f_a_autorizacion_servicios_detalle`\n        ON (`f_a_autorizacion_servicios_detalle`.`Id_Autorizacion` = `f_a_autorizacion_servicios`.`Id`)\n    INNER JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_a_autorizacion_servicios`.`Id_Tercero`)\n    INNER JOIN g_persona gp \n        ON (`gp`.`Id` = `f_a_autorizacion_servicios`.`Id_Persona`)\n    INNER JOIN `g_procedimiento` \n        ON (`f_a_autorizacion_servicios_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n inner JOIN  `f_empresacontxconvenio` \n        ON (`f_a_autorizacion_servicios`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`) \nWHERE (`f_a_autorizacion_servicios`.`FechaA` between '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `cc_terceros`.`RazonSocialCompleta` LIKE '" + this.JCBGenerico.getSelectedItem() + "' AND\nf_a_autorizacion_servicios.`Estado` =1);";
            } else {
                this.xsql = "SELECT\n    `f_a_autorizacion_servicios`.`Id`\n    , `f_a_autorizacion_servicios`.`FechaA`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , gp.NoDocumento `NoDocumento`\n    , concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n    , `g_procedimiento`.`Id` AS IdProcedimiento\n    , `g_procedimiento`.`Nbre` AS Procedimiento\n    , `f_a_autorizacion_servicios_detalle`.`Cantidad`\n    , `f_a_autorizacion_servicios_detalle`.`Valor`\n    , if(`f_a_autorizacion_servicios_detalle`.`Observacion`='null','', `f_a_autorizacion_servicios_detalle`.`Observacion`) Observacion, ifnull(`f_empresacontxconvenio`.`Nbre`,'NO APLICA') AS `NEmpresaConvenio`\nFROM\n    `f_a_autorizacion_servicios` \n    INNER JOIN `f_a_autorizacion_servicios_detalle`\n        ON (`f_a_autorizacion_servicios_detalle`.`Id_Autorizacion` = `f_a_autorizacion_servicios`.`Id`)\n    INNER JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_a_autorizacion_servicios`.`Id_Tercero`)\n    INNER JOIN g_persona gp \n        ON (`gp`.`Id` = `f_a_autorizacion_servicios`.`Id_Persona`)\n    INNER JOIN `g_procedimiento` \n        ON (`f_a_autorizacion_servicios_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n inner JOIN  `f_empresacontxconvenio` \n        ON (`f_a_autorizacion_servicios`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`)  \nWHERE (`f_a_autorizacion_servicios`.`FechaA` between '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND f_a_autorizacion_servicios.`Estado` =1);";
            }
            System.out.println("Informe Autorización " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(6)), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(8)), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString("NEmpresaConvenio"), n, 10);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosEmpresaConveFarmacologico() {
        mCrearModeloEmpresaConveFarmacologico();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_Sexo` AS `Sexo`, \n    `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `TipoEad`\n    , `h_ordenes`.`FechaOrden`, `i_suministro`.`Id` AS `IdSuministro`, `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_principioactivo`.`Nbre` AS `NPricincipioActivo`, `h_itemordenessum`.`Cantidad` AS `Cantidad`\n    , `i_atcsubgrupofarmacologico`.`Nbre` AS `NSubGrupoFamacologico`, `f_empresacontxconvenio`.`Nbre` AS `Empresa`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `h_ordenes` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN  `i_atcsubgrupofarmacologico` ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_ordenes`.`Estado` =0\n    AND `i_atcsubgrupofarmacologico`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')\nORDER BY `g_persona`.`Apellido1` ASC, `g_persona`.`Apellido2` ASC, `g_persona`.`Nombre1` ASC, \n`g_persona`.`Nombre2` ASC, `h_ordenes`.`FechaOrden` ASC, `NSuministro` ASC;";
            } else {
                this.xsql = "SELECT\n    `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo` AS `Sexo`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `TipoEad`\n    , `h_ordenes`.`FechaOrden`\n    , `i_suministro`.`Id` AS `IdSuministro`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_principioactivo`.`Nbre` AS `NPricincipioActivo`\n    , `h_itemordenessum`.`Cantidad` AS `Cantidad`\n    , `i_atcsubgrupofarmacologico`.`Nbre` AS `NSubGrupoFamacologico`\n    , `f_empresacontxconvenio`.`Nbre` AS `Empresa`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN  `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_ordenes`.`Estado` =0)\nORDER BY `g_persona`.`Apellido1` ASC, `g_persona`.`Apellido2` ASC, `g_persona`.`Nombre1` ASC, `g_persona`.`Nombre2` ASC, `h_ordenes`.`FechaOrden` ASC, `NSuministro` ASC;";
            }
            System.out.println("Convenio por Empresa Farmacológico====>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(11)), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosFormuSubgruFarmacologico() {
        mCrearModeloFormuSubgruFarmacologico();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT  `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_Sexo` AS `Sexo`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `TipoEad`\n    , `h_ordenes`.`FechaOrden`, `i_suministro`.`Id` AS `IdSuministro`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_principioactivo`.`Nbre` AS `NPricincipioActivo`\n    , `h_itemordenessum`.`Cantidad` AS `Cantidad`\n    , `i_atcsubgrupofarmacologico`.`Nbre` AS `NSubGrupoFamacologico`\n    , profesional1.`Especialidad`\n    , profesional1.`NProfesional` \nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN `profesional1`\n        ON (`h_ordenes`.`Id_Profesional` = profesional1.`Id_Persona`) AND (profesional1.`IdEspecialidad`=h_ordenes.`Id_Especialidad`) \n    INNER JOIN `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_ordenes`.`Estado` =0\n    AND `i_atcsubgrupofarmacologico`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')\nGROUP BY `g_persona`.`Apellido2`\nORDER BY `g_persona`.`Apellido1` ASC, `g_persona`.`Apellido2` ASC, `g_persona`.`Nombre1` \nASC, `g_persona`.`Nombre2` ASC, `h_ordenes`.`FechaOrden` ASC, `NSuministro` ASC;";
            } else {
                this.xsql = "SELECT  `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_Sexo` AS `Sexo`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,`h_ordenes`.`FechaOrden`) AS `TipoEad`\n    , `h_ordenes`.`FechaOrden`, `i_suministro`.`Id` AS `IdSuministro`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_principioactivo`.`Nbre` AS `NPricincipioActivo`\n    , `h_itemordenessum`.`Cantidad` AS `Cantidad`\n    , `i_atcsubgrupofarmacologico`.`Nbre` AS `NSubGrupoFamacologico`\n    , profesional1.`Especialidad`\n    , profesional1.`NProfesional` \nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN `profesional1`\n        ON (`h_ordenes`.`Id_Profesional` = profesional1.`Id_Persona`) AND (profesional1.`IdEspecialidad`=h_ordenes.`Id_Especialidad`) \n    INNER JOIN `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_ordenes`.`Estado` =0\n    )\nGROUP BY `g_persona`.`Apellido2`\nORDER BY `g_persona`.`Apellido1` ASC, `g_persona`.`Apellido2` ASC, `g_persona`.`Nombre1` \nASC, `g_persona`.`Nombre2` ASC, `h_ordenes`.`FechaOrden` ASC, `NSuministro` ASC;";
            }
            System.out.println("Formulación Por Subgrupo Farmacológico====>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(11)), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosVacunacionAplicxUsuario() {
        mCrearModeloVacunacionAplicxUsuario();
        try {
            this.xsql = null;
            this.xsql = "SELECT\n    `p_vacunacion_carnet`.`FechaVacuna` AS `FAplicacion`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `p_vacunacion_carnet`.`FechaVacuna`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,  `p_vacunacion_carnet`.`FechaVacuna`) AS `TEdad`\n    , `g_persona`.`Direccion`\n    , `g_barrio`.`Nbre` AS `Barrio`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `p_vacunacion_vacunas`.`Nbre` AS `NVacuna`\n    , `p_vacunacion_dosis`.`Nbre` AS `NDosis`\n    , `p_vacunacion_carnet`.`Vacunador`\nFROM\n       `p_vacunacion_esquema`\n    INNER JOIN    `p_vacunacion_carnet` \n        ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`)\n    INNER JOIN    `p_vacunacion_vacunas` \n        ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`)\n    INNER JOIN    `p_vacunacion_dosis` \n        ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`)\n    INNER JOIN    `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`)\n    INNER JOIN    `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN    `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN    `g_empresa` \n        ON (`g_empresa`.`Id` = `g_usuario`.`Id_EmpresaCont`)\n    INNER JOIN    `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)\n    INNER JOIN    `g_municipio` \n        ON (`g_empresa`.`Id_Municipio` = `g_municipio`.`Id`)\nWHERE (`p_vacunacion_carnet`.`FechaVacuna`  >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `g_persona`.`Apellido1` ASC, `g_persona`.`Apellido2` ASC, `g_persona`.`Nombre1` ASC, `g_persona`.`Nombre2` ASC, `NVacuna` ASC, `NDosis` ASC;";
            System.out.println("Total de Dosis Suministradas==>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarTotalDosiSuministroEntidad() {
        mCrearModeloTotalDosiSuministroEntidad();
        try {
            this.xsql = null;
            this.xsql = "SELECT `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta`, `p_vacunacion_vacunas`.`Nbre` AS `NVacuna`, \n`p_vacunacion_dosis`.`Nbre` AS `NDosis`, COUNT(`p_vacunacion_dosis`.`Id`) AS `Cantidad`\nFROM\n      `p_vacunacion_esquema`\n    INNER JOIN   `p_vacunacion_carnet` \n        ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`)\n    INNER JOIN   `p_vacunacion_vacunas` \n        ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`)\n    INNER JOIN   `p_vacunacion_dosis` \n        ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`)\n    INNER JOIN   `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`)\n    INNER JOIN   `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN   `g_empresa` \n        ON (`g_empresa`.`Id` = `g_usuario`.`Id_EmpresaCont`)\n    INNER JOIN   `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)\nWHERE (`p_vacunacion_carnet`.`FechaVacuna`  >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `p_vacunacion_vacunas`.`Id`, `p_vacunacion_dosis`.`Id`\nORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `NVacuna` ASC;";
            System.out.println("Total de Dosis Suministradas==>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTotalizarDatos() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            xvalor += Double.valueOf(this.xModelo.getValueAt(x, 5).toString()).doubleValue() * Double.valueOf(this.xModelo.getValueAt(x, 6).toString()).doubleValue();
        }
        this.JTFTotal.setValue(Double.valueOf(xvalor));
    }

    private void mCargarTotalDosiSuministradas() {
        mCrearModeloTotalDosiSuministradas();
        try {
            this.xsql = null;
            this.xsql = "SELECT `p_vacunacion_vacunas`.`Nbre` AS `NVacuna`\n    , `p_vacunacion_dosis`.`Nbre` AS `NDosis`\n    , COUNT(`p_vacunacion_dosis`.`Id`) AS `Cantidad`\nFROM  `p_vacunacion_esquema`\n    INNER JOIN  `p_vacunacion_carnet` \n        ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`)\n    INNER JOIN  `p_vacunacion_vacunas` \n        ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`)\n    INNER JOIN  `p_vacunacion_dosis` \n        ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_usuario`.`Id_Arl` = `g_empresa`.`Id`)\nWHERE (`p_vacunacion_carnet`.`FechaVacuna`  >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY `p_vacunacion_vacunas`.`Id`, `p_vacunacion_dosis`.`Id`\nORDER BY `NVacuna` ASC;";
            System.out.println("Total de Dosis Suministradas==>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosInforLipidosCarbo() {
        mCrearModeloInforLipidosCarbo();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT h_atencion.`Id`,`h_atencion`.`Fecha_Atencion`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`\n    , `g_usuario`.`NoHistoria`, cc_terceros.RazonSocialCompleta AS `NEntidad`, `g_tipoafiliado`.`Nbre` AS `TipoAfiliado`, `g_parentesco`.`Nbre` AS `Parentesco`\n    ,`Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_atencion`.`Fecha_Atencion`) Edad\n    , IFNULL(CTotal.Resultado,'') RColesterolTotal, IFNULL(CHdl.Resultado ,'') RCHDL, IFNULL(CLdl.Resultado,'') RCLDL\n    , IFNULL(Trigliceridos.Resultado,'')  RTrigliceridos, IFNULL(Glucosa.Resultado,'') RGlucosa, IFNULL(TFarmacologico.Nproducto,'NO') TtoFarmacologico\n    , IFNULL(UProgama.Programa,'') AS Programa,g_patologia.`Id` CDxP, g_patologia.`Nbre` DxP, IFNULL(g_patologia1.`Id`,'')CDx1\n    , IFNULL(g_patologia1.`Nbre`,'')Dx1, IFNULL(g_patologia2.`Id`,'')CDx2, IFNULL(g_patologia2.`Nbre`,'')Dx2\n    , IFNULL(g_patologia3.`Id`,'')CDx3, IFNULL(g_patologia3.`Nbre`,'')Dx3, IFNULL(UCitaNutricion.FUltimaCNutricion,'')FUltimaCNutricion\nFROM\n     `h_atencion`\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n   INNER JOIN  `g_usuarioxprograma`\n        ON (`g_usuario`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)\n    INNER JOIN  cc_terceros \n        ON (`g_usuario`.`Id_Arl` = cc_terceros.`Id`)\n    INNER JOIN  `g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN  `g_patologia`\n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia1\n        ON (`h_atencion`.`Codigo_DxR1` = `g_patologia1`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia2\n        ON (`h_atencion`.`Codigo_DxR2` = `g_patologia2`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia3\n        ON (`h_atencion`.`Codigo_DxR3` = `g_patologia3`.`Id`)        \n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_parentesco` \n        ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`)\n#CONSULTA RESULTADO DE COLESTEROL TOTAL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \nFROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903818\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CTotal ON (CTotal.Id_Paciente=`g_persona`.`Id`)   \n#CONSULTA RESULTADO DE COLESTEROL HDL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903815\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CHdl ON (CHdl.Id_Paciente=`g_persona`.`Id`)   \n #CONSULTA RESULTADO DE COLESTEROL LDL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n  FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903816\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CLdl ON (CLdl.Id_Paciente=`g_persona`.`Id`)   \n       \n       #CONSULTA RESULTADO DE TRIGLICERIDOS\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \nFROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903868\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) Trigliceridos ON (Trigliceridos.Id_Paciente=`g_persona`.`Id`)   \n #CONSULTA RESULTADO DE GLUCOSA\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n  FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903841\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) Glucosa ON (Glucosa.Id_Paciente=`g_persona`.`Id`)   \n\nLEFT JOIN (SELECT GROUP_CONCAT(`h_ordenes`.`FechaOrden`,'\\n', `c_clasecita`.`Nbre`,'\\n', `i_suministro`.`Nbre` SEPARATOR '\\n') Nproducto\n    , `ingreso`.`Id_Usuario`\nFROM `h_itemordenessum`\n    INNER JOIN  `h_ordenes` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND `i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` IN('C10A', 'A10B')\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`, `h_ordenes`.`Id`\nORDER BY `ingreso`.`Id_Usuario` ASC ) TFarmacologico ON (TFarmacologico.Id_Usuario=`g_persona`.`Id`)                 \n#CONSULTA DE PROGRAMAS\nLEFT JOIN (SELECT\n   GROUP_CONCAT(`g_tipoprograma`.`Nbre` SEPARATOR '\\n') Programa\n    , `g_usuarioxprograma`.`Id_Usuario`\nFROM `g_usuarioxprograma`\n    INNER JOIN  `g_tipoprograma` \n        ON (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nWHERE ( `g_usuarioxprograma`.`Estado` =1)\nGROUP BY `g_usuarioxprograma`.`Id_Usuario`) UProgama  ON(UProgama.Id_Usuario= `g_persona`.`Id`)   \n#ULTIMA CONSULTA DE NUTRICION\nLEFT JOIN (SELECT MAX(`h_atencion`.`Fecha_Atencion`) FUltimaCNutricion, `ingreso`.`Id_Usuario`\nFROM `h_atencion`\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Especialidad` =451)\nGROUP BY  `ingreso`.`Id_Usuario` ORDER BY `h_atencion`.`Fecha_Atencion` DESC) UCitaNutricion ON(UCitaNutricion.Id_Usuario= `g_persona`.`Id`)   \nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND g_usuarioxprograma.`Id_Programa`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n    AND h_atencion.`Codigo_Dxp`<>'') GROUP BY h_atencion.`Id`;";
            } else {
                this.xsql = "SELECT h_atencion.`Id`,`h_atencion`.`Fecha_Atencion`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`\n    , `g_usuario`.`NoHistoria`, cc_terceros.RazonSocialCompleta AS `NEntidad`, `g_tipoafiliado`.`Nbre` AS `TipoAfiliado`, `g_parentesco`.`Nbre` AS `Parentesco`\n    ,`Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`h_atencion`.`Fecha_Atencion`) Edad\n    , IFNULL(CTotal.Resultado,'') RColesterolTotal, IFNULL(CHdl.Resultado ,'') RCHDL, IFNULL(CLdl.Resultado,'') RCLDL\n    , IFNULL(Trigliceridos.Resultado,'')  RTrigliceridos, IFNULL(Glucosa.Resultado,'') RGlucosa, IFNULL(TFarmacologico.Nproducto,'NO') TtoFarmacologico\n    , IFNULL(UProgama.Programa,'') AS Programa,g_patologia.`Id` CDxP, g_patologia.`Nbre` DxP, IFNULL(g_patologia1.`Id`,'')CDx1\n    , IFNULL(g_patologia1.`Nbre`,'')Dx1, IFNULL(g_patologia2.`Id`,'')CDx2, IFNULL(g_patologia2.`Nbre`,'')Dx2\n    , IFNULL(g_patologia3.`Id`,'')CDx3, IFNULL(g_patologia3.`Nbre`,'')Dx3, IFNULL(UCitaNutricion.FUltimaCNutricion,'')FUltimaCNutricion\nFROM\n     `h_atencion`\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n   INNER JOIN  `g_usuarioxprograma`\n        ON (`g_usuario`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)\n    INNER JOIN  cc_terceros \n        ON (`g_usuario`.`Id_Arl` = cc_terceros.`Id`)\n    INNER JOIN  `g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN  `g_patologia`\n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia1\n        ON (`h_atencion`.`Codigo_DxR1` = `g_patologia1`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia2\n        ON (`h_atencion`.`Codigo_DxR2` = `g_patologia2`.`Id`)\n    LEFT JOIN  `g_patologia` g_patologia3\n        ON (`h_atencion`.`Codigo_DxR3` = `g_patologia3`.`Id`)        \n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_parentesco` \n        ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`)\n#CONSULTA RESULTADO DE COLESTEROL TOTAL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \nFROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903818\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CTotal ON (CTotal.Id_Paciente=`g_persona`.`Id`)   \n#CONSULTA RESULTADO DE COLESTEROL HDL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903815\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CHdl ON (CHdl.Id_Paciente=`g_persona`.`Id`)   \n #CONSULTA RESULTADO DE COLESTEROL LDL\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n  FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903816\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) CLdl ON (CLdl.Id_Paciente=`g_persona`.`Id`)   \n       \n       #CONSULTA RESULTADO DE TRIGLICERIDOS\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \nFROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903868\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) Trigliceridos ON (Trigliceridos.Id_Paciente=`g_persona`.`Id`)   \n #CONSULTA RESULTADO DE GLUCOSA\nLEFT JOIN (SELECT  `l_recepcion`.`Id_Paciente` ,\n    GROUP_CONCAT(CONCAT(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y'), ' - ',`l_detalleresultado`.`VrNumerico` ) ORDER BY `l_recepcion`.`FechaRecep` DESC SEPARATOR '\\n')  AS Resultado \n  FROM `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nWHERE (`g_procedimiento`.`Id`= 903841\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` ) Glucosa ON (Glucosa.Id_Paciente=`g_persona`.`Id`)   \n\nLEFT JOIN (SELECT GROUP_CONCAT(`h_ordenes`.`FechaOrden`,'\\n', `c_clasecita`.`Nbre`,'\\n', `i_suministro`.`Nbre` SEPARATOR '\\n') Nproducto\n    , `ingreso`.`Id_Usuario`\nFROM `h_itemordenessum`\n    INNER JOIN  `h_ordenes` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` IN('C10A', 'A10B')\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`, `h_ordenes`.`Id`\nORDER BY `ingreso`.`Id_Usuario` ASC ) TFarmacologico ON (TFarmacologico.Id_Usuario=`g_persona`.`Id`)                 \n#CONSULTA DE PROGRAMAS\nLEFT JOIN (SELECT\n   GROUP_CONCAT(`g_tipoprograma`.`Nbre` SEPARATOR '\\n') Programa\n    , `g_usuarioxprograma`.`Id_Usuario`\nFROM `g_usuarioxprograma`\n    INNER JOIN  `g_tipoprograma` \n        ON (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nWHERE ( `g_usuarioxprograma`.`Estado` =1)\nGROUP BY `g_usuarioxprograma`.`Id_Usuario`) UProgama  ON(UProgama.Id_Usuario= `g_persona`.`Id`)   \n#ULTIMA CONSULTA DE NUTRICION\nLEFT JOIN (SELECT MAX(`h_atencion`.`Fecha_Atencion`) FUltimaCNutricion, `ingreso`.`Id_Usuario`\nFROM `h_atencion`\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Especialidad` =451)\nGROUP BY  `ingreso`.`Id_Usuario` ORDER BY `h_atencion`.`Fecha_Atencion` DESC) UCitaNutricion ON(UCitaNutricion.Id_Usuario= `g_persona`.`Id`)   \nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND h_atencion.`Codigo_Dxp`<>'') GROUP BY h_atencion.`Id`;";
            }
            System.out.println("Consulta Informacion de Lipidos y Carbohidratos====>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsultarOrdenProced() {
        mCrearModeloConsultarOrdenProced();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n    `h_atencion`.`Fecha_Atencion`  \n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,  `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,  `h_atencion`.`Fecha_Atencion`) AS `TEdad`  \n    , `c_clasecita`.`Nbre` AS `NTIpoCita`\n    , CONCAT(`Profesional`.`Apellido1` ,' ', `Profesional`.`Apellido2`,' ',  `Profesional`.`Nombre1`,' ', `Profesional`.`Nombre2`) AS `Profesional`\n    , IFNULL(`g_patologia`.`Id`,'') AS `Dx_P`\n    , IFNULL(`g_patologia`.`Nbre`,'') AS `NDx_P`\n    , IFNULL(`g_patologia_1`.`Id`,'') AS `Dx_P1`\n    ,  IFNULL(`g_patologia_1`.`Nbre`,'') AS `NDx_P1`\n    ,  IFNULL(`g_patologia_2`.`Id`,'') AS `Dx_P2`\n    ,  IFNULL(`g_patologia_2`.`Nbre`,'') AS `NDx_P2`\n    ,  IFNULL(`g_patologia_3`.`Id`,'') AS `Dx_P3`\n    ,  IFNULL(`g_patologia_3`.`Nbre`,'') AS `NDx_P3`\n    , `f_tiposervicio`.`Id` AS IdServ\n    , `f_tiposervicio`.`Nbre` AS Servicio\n    , `g_procedimiento`.`Id` AS IdProce\n    , `g_procedimiento`.`Nbre` AS Procedimiento\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` AS `Profesional` \n        ON (`Profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_3` \n        ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenesproced` \n        ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `h_itemordenesproced`.`Id_Procedimiento`)\n    INNER JOIN  `f_tiposervicio` \n        ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `g_procedimiento`.`Nbre` LIKE '" + this.JCBGenerico.getSelectedItem() + "')\nORDER BY `h_atencion`.`Fecha_Atencion` ASC, `f_tiposervicio`.`Nbre` ASC;";
            } else {
                this.xsql = "SELECT\n    `h_atencion`.`Fecha_Atencion`  \n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`,  `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,  `h_atencion`.`Fecha_Atencion`) AS `TEdad`  \n    , `c_clasecita`.`Nbre` AS `NTIpoCita`\n    , CONCAT(`Profesional`.`Apellido1` ,' ', `Profesional`.`Apellido2`,' ',  `Profesional`.`Nombre1`,' ', `Profesional`.`Nombre2`) AS `Profesional`\n    , `g_patologia`.`Id` AS `Dx_P`\n    , `g_patologia`.`Nbre` AS `NDx_P`\n    , IFNULL(`g_patologia_1`.`Id`,'') AS `Dx_P1`\n    ,  IFNULL(`g_patologia_1`.`Nbre`,'') AS `NDx_P1`\n    ,  IFNULL(`g_patologia_2`.`Id`,'') AS `Dx_P2`\n    ,  IFNULL(`g_patologia_2`.`Nbre`,'') AS `NDx_P2`\n    ,  IFNULL(`g_patologia_3`.`Id`,'') AS `Dx_P3`\n    ,  IFNULL(`g_patologia_3`.`Nbre`,'') AS `NDx_P3`\n    , `f_tiposervicio`.`Id` AS IdServ\n    , `f_tiposervicio`.`Nbre` AS Servicio\n    , `g_procedimiento`.`Id` AS IdProce\n    , `g_procedimiento`.`Nbre` AS Procedimiento\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` AS `Profesional` \n        ON (`Profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_3` \n        ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenesproced` \n        ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `h_itemordenesproced`.`Id_Procedimiento`)\n    INNER JOIN  `f_tiposervicio` \n        ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') \nORDER BY `h_atencion`.`Fecha_Atencion` ASC, `f_tiposervicio`.`Nbre` ASC;";
            }
            System.out.println("Orden x Procedimiento ====>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosSaludOcupacionalDX() {
        mCrearModeloSaludOcupacionalDX();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT\n    `h_atencion`.`Id`\n    , `h_atencion`.`Fecha_Atencion`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_nivelestudio`.`Nbre` AS `Escolaridad`\n    , `g_estadocivil`.`Nbre` AS `EstadoCivil`\n    , `h_so_datos_ocupacionales`.`Eps` AS `NEps`\n    , IFNULL(GROUP_CONCAT(CONCAT(`h_so_accidentes_trabajo`.`Empresa`, ' AÑO: ', `h_so_accidentes_trabajo`.`Fecha_AT`) SEPARATOR '\\n'),'') AS `AccidenteTrabajo`\n    , IFNULL(GROUP_CONCAT(CONCAT(`h_so_enfermedad_profesional`.`Empresa`, ' AÑO: ', `h_so_enfermedad_profesional`.`FechaEP`) SEPARATOR '\\n'),'') AS `EnfermedadProfesional`\n    , IF(`h_habitos`.`Habito_Deporte` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Habito_Deporte`=1,'SI','NO')) AS `PDeporte`\n    , IFNULL(`h_habitos`.`Cual_Deporte`,'') AS `CDeporte`\n    , IF(`h_habitos`.`Id_TipoCantCigarro` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Id_TipoCantCigarro`=1,'NO','SI')) AS `Fuma`\n    , IFNULL(`h_habitos`.`ObserFuma`,'') AS `ObsFuma`\n    ,  IF(`h_habitos`.`Habito_Alcohol` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Habito_Alcohol`=1,'SI','NO')) AS `CAlcohol`\n    , IFNULL(`h_habitos`.`Cual_Alcohol`,'') AS `CualAlcohol`\n    , IFNULL(`h_habitos`.`ObserALcohol`,'') AS `ObsAlcohol`\n    , IFNULL(`h_so_visiometria`.`Resultado`,'') AS `RVisiometia`\n    , IFNULL(`h_so_visiometria`.`ObservacionVisio`,'') AS `RVObservacion`\n    , IFNULL(`h_so_audiometria`.`ResultadoM`,'') AS `RAudiometria`\n    , IFNULL(`h_so_audiometria`.`ObservacionM`,'') AS `RAObservacion`\n    ,  IFNULL(`h_so_espirometria_g`.`ResultadoM`,'') AS `REspirometria`\n    , IFNULL(`h_so_espirometria_g`.`Observacion`,'') AS `REObservacion`\n    , IFNULL(`h_so_examen_osteomuscular`.`Resultado`,'') AS `ROsteomuscular`\n    , `so_tipo_concepto`.`Nbre` AS `Concepto`\n    , `g_patologia`.`Nbre` AS `DxP`\n    , IFNULL(`g_patologia_1`.`Nbre`,'') AS `DxR1`\n    , `h_examenfisico`.`IMC`\n    , `h_atencion`.`Recomendaciones`\n    , IFNULL(`h_so_concepto_laboral`.`Observacion`,'') AS `Observacion` \n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_estadocivil` \n        ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`)\n    INNER JOIN  `g_nivelestudio` \n        ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)\n    INNER JOIN  `h_so_datos_ocupacionales` \n        ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `g_cargos` \n        ON (`h_so_datos_ocupacionales`.`IdCargo` = `g_cargos`.`Id`)\n    LEFT JOIN  `h_so_accidentes_trabajo` \n        ON (`h_so_accidentes_trabajo`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_enfermedad_profesional` \n        ON (`h_so_enfermedad_profesional`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`) \n    LEFT JOIN  `h_habitos` \n        ON (`h_habitos`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_visiometria` \n        ON (`h_so_visiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_audiometria` \n        ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_espirometria_g` \n        ON (`h_so_espirometria_g`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_examen_osteomuscular` \n        ON (`h_so_examen_osteomuscular`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_concepto_laboral` \n        ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `so_tipo_concepto` \n        ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `h_examenfisico` \n        ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'AND f_empresacontxconvenio.Id_EmpresaConvenio ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')GROUP BY `h_atencion`.`Id`;";
            } else {
                this.xsql = "SELECT\n    `h_atencion`.`Id`\n    , `h_atencion`.`Fecha_Atencion`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_nivelestudio`.`Nbre` AS `Escolaridad`\n    , `g_estadocivil`.`Nbre` AS `EstadoCivil`\n    , `h_so_datos_ocupacionales`.`Eps` AS `NEps`\n    , IFNULL(GROUP_CONCAT(CONCAT(`h_so_accidentes_trabajo`.`Empresa`, ' AÑO: ', `h_so_accidentes_trabajo`.`Fecha_AT`) SEPARATOR '\\n'),'') AS `AccidenteTrabajo`\n    , IFNULL(GROUP_CONCAT(CONCAT(`h_so_enfermedad_profesional`.`Empresa`, ' AÑO: ', `h_so_enfermedad_profesional`.`FechaEP`) SEPARATOR '\\n'),'') AS `EnfermedadProfesional`\n    , IF(`h_habitos`.`Habito_Deporte` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Habito_Deporte`=1,'SI','NO')) AS `PDeporte`\n    , IFNULL(`h_habitos`.`Cual_Deporte`,'') AS `CDeporte`\n    , IF(`h_habitos`.`Id_TipoCantCigarro` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Id_TipoCantCigarro`=1,'NO','SI')) AS `Fuma`\n    , IFNULL(`h_habitos`.`ObserFuma`,'') AS `ObsFuma`\n    ,  IF(`h_habitos`.`Habito_Alcohol` IS NULL,'NO REGISTRA', IF(`h_habitos`.`Habito_Alcohol`=1,'SI','NO')) AS `CAlcohol`\n    , IFNULL(`h_habitos`.`Cual_Alcohol`,'') AS `CualAlcohol`\n    , IFNULL(`h_habitos`.`ObserALcohol`,'') AS `ObsAlcohol`\n    , IFNULL(`h_so_visiometria`.`Resultado`,'') AS `RVisiometia`\n    , IFNULL(`h_so_visiometria`.`ObservacionVisio`,'') AS `RVObservacion`\n    , IFNULL(`h_so_audiometria`.`ResultadoM`,'') AS `RAudiometria`\n    , IFNULL(`h_so_audiometria`.`ObservacionM`,'') AS `RAObservacion`\n    ,  IFNULL(`h_so_espirometria_g`.`ResultadoM`,'') AS `REspirometria`\n    , IFNULL(`h_so_espirometria_g`.`Observacion`,'') AS `REObservacion`\n    , IFNULL(`h_so_examen_osteomuscular`.`Resultado`,'') AS `ROsteomuscular`\n    , `so_tipo_concepto`.`Nbre` AS `Concepto`\n    , `g_patologia`.`Nbre` AS `DxP`\n    , IFNULL(`g_patologia_1`.`Nbre`,'') AS `DxR1`\n    , `h_examenfisico`.`IMC`\n    , `h_atencion`.`Recomendaciones`\n    , IFNULL(`h_so_concepto_laboral`.`Observacion`,'') AS `Observacion` \n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_estadocivil` \n        ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`)\n    INNER JOIN  `g_nivelestudio` \n        ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)\n    INNER JOIN  `h_so_datos_ocupacionales` \n        ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `g_cargos` \n        ON (`h_so_datos_ocupacionales`.`IdCargo` = `g_cargos`.`Id`)\n    LEFT JOIN  `h_so_accidentes_trabajo` \n        ON (`h_so_accidentes_trabajo`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_enfermedad_profesional` \n        ON (`h_so_enfermedad_profesional`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`) \n    LEFT JOIN  `h_habitos` \n        ON (`h_habitos`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_visiometria` \n        ON (`h_so_visiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_audiometria` \n        ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_espirometria_g` \n        ON (`h_so_espirometria_g`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_examen_osteomuscular` \n        ON (`h_so_examen_osteomuscular`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `h_so_concepto_laboral` \n        ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `so_tipo_concepto` \n        ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `h_examenfisico` \n        ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')GROUP BY `h_atencion`.`Id`;";
            }
            System.out.println("Detalle Entrada Por Bodega   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 17);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 20);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosControlPrenatal() {
        mCrearModeloControlPrenatal();
        try {
            this.xsql = null;
            this.xsql = "SELECT      `f_tiporegimen`.`Nbre` AS `Regimen`      , `g_departamento`.`Nbre` AS `Departamento`      , `g_municipio`.`Nbre` AS `Municipio`      , `g_persona`.`Nombre1`      , `g_persona`.`Nombre2`      , `g_persona`.`Apellido1`      , `g_persona`.`Apellido2`      , `g_persona`.`Id_TipoIdentificacion`      , `g_persona`.`NoDocumento`      , `g_persona`.`FechaNac`      , `Devuelve_Edad_2F`( `g_persona`.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad`    , `g_persona`.`Direccion`      , IF((`g_persona`.`Telefono`='' ||`g_persona`.`Movil`='' ), 'NO REGISTRA', IF(`g_persona`.`Telefono`='',`g_persona`.`Movil`,`g_persona`.`Telefono`)) AS Telefono        , IFNULL(`h_antecedenteginecologico`.`FUMestruacion`, '')FUMestruacion      , IFNULL(`h_antecedenteginecologico`.`SemanaG`, '') SemanaG         , IFNULL(D.NControles, '') NControles,  IFNULL(D.Edad_Gestacion_Parto, '') EdadGestacional      , DATE_FORMAT(IFNULL(E.Fecha_Atencion,`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y') FUltimoCOntrol          , IFNULL(F.FechaToma,'')FechaTomaVIH      , IFNULL(F.Resultado,'') ResultadoVIH      , IFNULL(G.FechaToma,'')FechaTomaSifilis      , IFNULL(G.Resultado,'') ResultadoSifilis      , d_ips.`NEmpresa` AS NIps      , d_ips.`Direccion` AS DireccionIps      , d_ips.`Telefono` AS TelefonoIps,       IF((h_tipo_riesgo.`Nbre` IS NULL OR h_tipo_riesgo.`Nbre`='NO APLICA'),'',h_tipo_riesgo.`Nbre`) CRiesgo      , f_empresacontxconvenio.`Nbre` AS EmpresaFacturada  FROM `d_ips`,      `h_atencion`      INNER JOIN `ingreso`           ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)      INNER JOIN `g_persona`           ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)       LEFT JOIN `h_examenfisico`          ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)             LEFT JOIN `h_tipo_riesgo`          ON (`h_tipo_riesgo`.`Id` = `h_examenfisico`.`Id_CRiesgo`)          INNER JOIN `f_empresacontxconvenio`           ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)      INNER JOIN `g_usuario`           ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)      INNER JOIN `g_municipio`           ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)      INNER JOIN `f_tiporegimen`           ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)      INNER JOIN `g_departamento`           ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)      LEFT JOIN `h_antecedenteginecologico`           ON (`h_antecedenteginecologico`.`Id_Atencion` = `h_atencion`.`Id`)      INNER JOIN `c_clasecita`           ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  \t\tLEFT JOIN(SELECT `ingreso`.`Id_Usuario`,       COUNT(`h_atencion`.`IdUsuarioPrograma`) AS `NControles`, `c_clasecita`.`Id_Programa`, g_usuarioxprograma.`Edad_Gestacion_Parto`  FROM      `h_atencion`      INNER JOIN `c_clasecita`           ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)      INNER JOIN `ingreso`           ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)      INNER JOIN `g_usuarioxprograma`           ON (`g_usuarioxprograma`.`Id` = `h_atencion`.`IdUsuarioPrograma`)  WHERE (`h_atencion`.`Codigo_Dxp` <>'')  GROUP BY `ingreso`.`Id_Usuario`) D ON (D.Id_Usuario = `g_persona`.`Id`) AND(D.Id_Programa=3)     LEFT JOIN  (SELECT h_atencion.`Fecha_Atencion`, `ingreso`.`Id_Usuario` , `c_clasecita`.`Id_Programa`  FROM       `h_atencion`      INNER JOIN `c_clasecita`           ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)      INNER JOIN `ingreso`           ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)      INNER JOIN `g_usuarioxprograma`           ON (`g_usuarioxprograma`.`Id` = `h_atencion`.`IdUsuarioPrograma`)  WHERE (`h_atencion`.`Codigo_Dxp` <>'' )  ORDER BY  h_atencion.`Fecha_Atencion` DESC LIMIT 1) E  ON (E.Id_Usuario=`g_persona`.`Id`)  AND(E.Id_Programa=3)     LEFT JOIN (SELECT      DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y') FechaToma      , `l_recepcion`.`Id_Paciente`         , `l_detalleresultado`.`VrNumerico` Resultado,   MAX(l_recepcion.`Id`)  FROM      `l_detalleresultado`      INNER JOIN `l_resultados`           ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)      INNER JOIN `l_recepcion`           ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)      INNER JOIN `g_procedimiento`           ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)  WHERE (`g_procedimiento`.`Id`= 906255      AND `l_recepcion`.`Estado` =0      AND `l_resultados`.`Estado` =0)  GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` DESC) F ON (F.Id_Paciente=`g_persona`.`Id`)     LEFT JOIN (SELECT      DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%d-%m-%Y') FechaToma      , `l_recepcion`.`Id_Paciente`         , `l_detalleresultado`.`VrNumerico` Resultado,   MAX(l_recepcion.`Id`)  FROM      `l_detalleresultado`      INNER JOIN `l_resultados`           ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)      INNER JOIN `l_recepcion`           ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)      INNER JOIN `g_procedimiento`           ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)  WHERE (`g_procedimiento`.`Id`= 906916    AND `l_recepcion`.`Estado` =0    AND `l_resultados`.`Estado` =0)  GROUP BY `l_recepcion`.`Id_Paciente`  ORDER BY `l_recepcion`.`FechaRecep` DESC) G ON (G.Id_Paciente=`g_persona`.`Id`)     WHERE (`c_clasecita`.`Id_Programa` =3  AND `h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'   AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND h_atencion.`Codigo_Dxp`<>'');";
            System.out.println("Detalle Entrada Por Bodega   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosPacienteFacAtencion() {
        mCrearModeloPacienteFacAtencion();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                if (this.xNombre.equals("pacienteFacAtencionLab")) {
                    this.xsql = "SELECT DATE_FORMAT(f_ordenes.`FechaOrden`,'%d-%m-%Y') AS FechaD, `g_usuario`.`NoHistoria`,  CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`,  `ingreso`.`HoraIngreso`,  IF(`f_ordenes`.`EstadoRecep`=0, 'POR RECEPCIONAR', IF(`f_ordenes`.`EstadoRecep`=1, 'RECEPCIONADO', 'ATENDIDO')) AS Estado, `g_tipoatencion`.`Nbre` AS  NTipo, f_empresacontxconvenio.`Nbre` AS EmpresaFac  FROM  `f_itemordenesproced`  INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)    INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`)  INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)  INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)   INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)     WHERE (`f_ordenes`.`Id_TipoServicio` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "' AND f_ordenes.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND f_ordenes.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND`f_ordenes`.`Estado` =0 ) GROUP BY `f_ordenes`.`Id`ORDER BY `ingreso`.`HoraIngreso` ASC";
                } else if (this.xNombre.equals("pacienteFacAtencionRad")) {
                    this.xsql = "SELECT DATE_FORMAT(f_ordenes.`FechaOrden`,'%d-%m-%Y') AS FechaD,g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NUsuario,   CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo` AS NSexo, ingreso.HoraIngreso, IF(f_ordenes.EstadoRecep=0,'POR ATENDER',IF(f_ordenes.EstadoRecep=1,'RECEPCIONADO','ATENDIDO')) AS estadoRecepcion,   IF(ingreso.`Id_Especialidad`='690','SALUD OCUPACIONAL',g_tipoatencion.`Nbre`) AS TipoAtencion, f_empresacontxconvenio.`Nbre` AS EmpresaFac      FROM f_itemordenesproced      INNER JOIN l_codigoprouni ON (f_itemordenesproced.Id_Procedimiento = l_codigoprouni.Id_Procedimiento)      INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)      INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)          INNER JOIN ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)      INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`)      INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)      INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)         INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)       INNER JOIN `g_tipoatencion`  ON (g_tipoatencion.`Id` = ingreso.`Id_TipoAtencion`)       LEFT JOIN `f_camas`  ON (f_camas.`Id` = ingreso.`Cama`)   LEFT JOIN `f_unidadcama`  ON (f_camas.`Id_UnidadCamas` = f_unidadcama.`Id`) LEFT JOIN  `l_recepcion` ON (l_recepcion.`Id_OrdenFacturac`=f_ordenes.`Id` AND f_ordenes.`Estado`=0)   WHERE ( g_procedimiento.EsOdontologico=0   AND f_ordenes.EstadoRecep IN(0,1,2) AND ingreso.Id_Sede ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "' AND f_ordenes.LProcesamiento='0' AND f_ordenes.Estado =0 AND ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND f_ordenes.`FechaOrden`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  )  GROUP BY f_ordenes.Id ORDER BY ingreso.HoraIngreso ASC, ingreso.FechaIngreso ASC";
                }
            } else if (this.xNombre.equals("pacienteFacAtencionLab")) {
                this.xsql = "SELECT DATE_FORMAT(f_ordenes.`FechaOrden`,'%d-%m-%Y') AS FechaD, `g_usuario`.`NoHistoria`,  CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`,  `ingreso`.`HoraIngreso`,  IF(`f_ordenes`.`EstadoRecep`=0, 'POR RECEPCIONAR', IF(`f_ordenes`.`EstadoRecep`=1, 'RECEPCIONADO', 'ATENDIDO')) AS Estado, `g_tipoatencion`.`Nbre` AS  NTipo, f_empresacontxconvenio.`Nbre` AS EmpresaFac  FROM  `f_itemordenesproced`  INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)    INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`)  INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)  INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)   INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)     WHERE (f_ordenes.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND f_ordenes.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND`f_ordenes`.`Estado` =0 ) GROUP BY `f_ordenes`.`Id`ORDER BY `ingreso`.`HoraIngreso` ASC";
            } else if (this.xNombre.equals("pacienteFacAtencionRad")) {
                this.xsql = "SELECT DATE_FORMAT(f_ordenes.`FechaOrden`,'%d-%m-%Y') AS FechaD,g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NUsuario,   CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo` AS NSexo, ingreso.HoraIngreso, IF(f_ordenes.EstadoRecep=0,'POR ATENDER',IF(f_ordenes.EstadoRecep=1,'RECEPCIONADO','ATENDIDO')) AS estadoRecepcion,   IF(ingreso.`Id_Especialidad`='690','SALUD OCUPACIONAL',g_tipoatencion.`Nbre`) AS TipoAtencion, f_empresacontxconvenio.`Nbre` AS EmpresaFac      FROM f_itemordenesproced      INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)      INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)          INNER JOIN ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)      INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`)      INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)       INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)         INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)       INNER JOIN `g_tipoatencion`  ON (g_tipoatencion.`Id` = ingreso.`Id_TipoAtencion`)       LEFT JOIN `f_camas`  ON (f_camas.`Id` = ingreso.`Cama`)   LEFT JOIN `f_unidadcama`  ON (f_camas.`Id_UnidadCamas` = f_unidadcama.`Id`) LEFT JOIN  `l_recepcion` ON (l_recepcion.`Id_OrdenFacturac`=f_ordenes.`Id` AND f_ordenes.`Estado`=0)   WHERE ( g_procedimiento.EsOdontologico=0  AND g_procedimiento.`Id_tipoprocedimiento`=8  AND f_ordenes.EstadoRecep IN(0,1,2) AND f_ordenes.LProcesamiento='0'AND f_ordenes.Estado =0 AND ingreso.FechaIngreso >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND f_ordenes.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  )  GROUP BY f_ordenes.Id ORDER BY ingreso.HoraIngreso ASC, ingreso.FechaIngreso ASC";
            }
            System.out.println("Listado De Pacientes Facturados Para Atención---- > " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsolidOrdenConvenioProf() {
        mCrearModeloConsolidOrdenConvenioProf();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`, `profesional1`.`Especialidad`     , `profesional1`.`NProfesional` , `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` AS `NProcedimiento`     , COUNT(`g_procedimiento`.`Id`) AS `Cantidad`     FROM    `h_atencion`     INNER JOIN    `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN    `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN    `h_ordenes` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN    `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)     INNER JOIN    `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)     INNER JOIN    `g_procedimiento` ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)     INNER JOIN    `profesional1` ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'     AND `f_tiposervicio`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "') GROUP BY `profesional1`.`Id_Persona`, `f_empresacontxconvenio`.`Id`, `g_procedimiento`.`Id` ORDER BY `NEmpresaConvenio` ASC, `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NProcedimiento` ASC;";
            } else {
                this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`, `profesional1`.`Especialidad`      , `profesional1`.`NProfesional` , `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` AS `NProcedimiento`      , COUNT(`g_procedimiento`.`Id`) AS `Cantidad`      FROM    `h_atencion`      INNER JOIN    `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)      INNER JOIN    `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)      INNER JOIN    `h_ordenes` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)      INNER JOIN    `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)      INNER JOIN    `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)      INNER JOIN    `g_procedimiento` ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)      INNER JOIN    `profesional1` ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`)  WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'      AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) GROUP BY `profesional1`.`Id_Persona`, `f_empresacontxconvenio`.`Id`, `g_procedimiento`.`Id`  ORDER BY `NEmpresaConvenio` ASC, `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NProcedimiento` ASC;";
            }
            System.out.println("Consolidado Ordenes x ConvenioMedico   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(4)), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(6)), n, 5);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsolidadoOrdenesMedico() {
        mCrearModeloConsolidadoOrdenesMedico();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` AS `NProcedimiento`,  COUNT(`g_procedimiento`.`Id`) AS `Cantidad`FROM`h_atencion` INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `h_ordenes`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN  `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)INNER JOIN  `g_procedimiento`  ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'    AND `f_tiposervicio`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "') GROUP BY `profesional1`.`Id_Persona`, `g_procedimiento`.`Id` ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NProcedimiento` ASC";
            } else {
                this.xsql = "SELECT `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` AS `NProcedimiento`,  COUNT(`g_procedimiento`.`Id`) AS `Cantidad`FROM`h_atencion` INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `h_ordenes`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN  `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)INNER JOIN  `g_procedimiento`  ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `profesional1`.`Id_Persona`, `g_procedimiento`.`Id` ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NProcedimiento` ASC";
            }
            System.out.println("Consolidado Ordenes x Medico   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosCirugiasNoProgramadas() {
        mCrearModeloCirugiasNoProgramadas();
        try {
            this.xsql = null;
            this.xsql = "SELECT `f_empresacontxconvenio`.`Id` AS IdEmpresa , `f_empresacontxconvenio`.`Nbre` AS NombreEmpresa , `c_clasecita`.`Id` AS IdClaseCita , `c_clasecita`.`Nbre` AS ClaseCita , `g_especialidad`.`Nbre` AS `NEspecialidad` , COUNT(`c_clasecita`.`Id`) AS `Cantidad` FROM `c_citasnp` INNER JOIN  `g_profesional`  ON (`c_citasnp`.`Id_Profesional` = `g_profesional`.`Id_Persona`) INNER JOIN  `g_persona`  ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citasnp`.`Id_Especialidad`) INNER JOIN  `g_usuario`  ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1` ON (`g_usuario`.`Id_persona` = `g_persona_1`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_procedimiento`  ON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `c_citasnp`.`Id_Anulada` =0 AND `c_clasecita`.`EsQx` =1) GROUP BY `f_empresacontxconvenio`.`Id`, `c_clasecita`.`Id`, `g_especialidad`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `c_clasecita`.`Nbre` ASC;";
            System.out.println("Cirugias No Programadas   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(7)), n, 5);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsolidadoPorProfesional() {
        mCrearModeloConsolidadoPorProfesional();
        try {
            this.xsql = null;
            this.xsql = "SELECT      `g_especialidad`.`Id`      , `g_especialidad`.`Nbre` AS `NEspecialidad`      , `h_orden_qx_procedimientos`.`Id_Profesional`      , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`)  AS `NProfesional`      , `g_procedimiento`.`Id`      , `g_procedimiento`.`Nbre` AS `NProcedimiemto`      , COUNT(`g_procedimiento`.`Id`) AS `Cantidad`  FROM       `h_orden_qx`      INNER JOIN  `h_atencion`           ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`)      INNER JOIN  `ingreso`           ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)      INNER JOIN  `h_orden_qx_procedimientos`           ON (`h_orden_qx_procedimientos`.`Id_Orden_Qx` = `h_orden_qx`.`Id`)      INNER JOIN  `g_procedimiento`           ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`)      INNER JOIN  `g_especialidad`           ON (`h_orden_qx_procedimientos`.`Id_Especialidad` = `g_especialidad`.`Id`)      INNER JOIN  `g_profesional`           ON (`h_orden_qx_procedimientos`.`Id_Profesional` = `g_profesional`.`Id_Persona`)      INNER JOIN  `g_persona`           ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`)      INNER JOIN  `f_empresacontxconvenio`           ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  WHERE (`h_orden_qx`.`Estado` =1      AND `h_orden_qx`.`Fecha_Inicial` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'      AND `h_orden_qx`.`Fecha_Inicial` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  GROUP BY `g_especialidad`.`Id`, `h_orden_qx_procedimientos`.`Id_Profesional`, `g_procedimiento`.`Id`  ORDER BY `NEspecialidad` ASC, `h_orden_qx`.`Fecha_Inicial` ASC, `h_orden_qx_procedimientos`.`Id_Profesional` ASC, `NProcedimiemto` ASC;";
            System.out.println("consolidado por profesional   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(7)), n, 6);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosCirugiasPorEPS() {
        mCrearModeloCirugiasPorEPS();
        try {
            this.xsql = null;
            this.xsql = "SELECT     `f_empresacontxconvenio`.`Id`     , `f_empresacontxconvenio`.`Nbre` AS `NCOnvenio`     , `g_especialidad`.`Id`     , `g_especialidad`.`Nbre` AS `NEspecialidad`     , `h_orden_qx_procedimientos`.`Id_Profesional`     , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`)  AS `NProfesional`     , `g_procedimiento`.`Id`     , `g_procedimiento`.`Nbre` AS `NProcedimiemto`     , COUNT(`g_procedimiento`.`Id`) AS `Cantidad`  FROM     `h_orden_qx`     INNER JOIN `h_atencion`          ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN `ingreso`          ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `h_orden_qx_procedimientos`          ON (`h_orden_qx_procedimientos`.`Id_Orden_Qx` = `h_orden_qx`.`Id`)     INNER JOIN `g_procedimiento`          ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`)     INNER JOIN `g_especialidad`          ON (`h_orden_qx_procedimientos`.`Id_Especialidad` = `g_especialidad`.`Id`)     INNER JOIN `g_profesional`          ON (`h_orden_qx_procedimientos`.`Id_Profesional` = `g_profesional`.`Id_Persona`)     INNER JOIN `f_empresacontxconvenio`          ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN `g_usuario`          ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)     INNER JOIN `g_persona`          ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`)     INNER JOIN `g_persona` AS `g_persona_1`         ON (`g_usuario`.`Id_persona` = `g_persona_1`.`Id`)  WHERE (`h_orden_qx`.`Estado` =1     AND `h_orden_qx`.`Fecha_Inicial` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_orden_qx`.`Fecha_Inicial` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  GROUP BY `f_empresacontxconvenio`.`Id`, `g_especialidad`.`Id`, `h_orden_qx_procedimientos`.`Id_Profesional`, `g_procedimiento`.`Id`  ORDER BY `NCOnvenio` ASC, `NEspecialidad` ASC, `NProfesional` ASC, `NProcedimiemto` ASC, `h_orden_qx`.`Fecha_Inicial` ASC;";
            System.out.println("Cirugias Por EPS   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(7)), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosCirugiasUsuariosEPSyProfesional() {
        mCrearModeloCirugiasUsuariosEPSyProfesional();
        try {
            this.xsql = null;
            this.xsql = " SELECT     `f_empresacontxconvenio`.`Id`     , `f_empresacontxconvenio`.`Nbre` AS `NCOnvenio`     , `g_especialidad`.`Id`     , `g_especialidad`.`Nbre` AS `NEspecialidad`     , `h_orden_qx_procedimientos`.`Id_Profesional`     , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`)  AS `NProfesional`     , `g_persona_1`.`NoDocumento`     , CONCAT(`g_persona_1`.`Apellido1`,' ', `g_persona_1`.`Apellido2`,' ', `g_persona_1`.`Nombre1` ,' ', `g_persona_1`.`Nombre2`) AS NombrePaciente    , `g_persona_1`.`Edad`     , `g_procedimiento`.`Id`     , `g_procedimiento`.`Nbre` AS `NProcedimiemto`     , COUNT(`g_procedimiento`.`Id`) AS `Cantidad`  FROM     `h_orden_qx`     INNER JOIN `h_atencion`          ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN `ingreso`          ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `h_orden_qx_procedimientos`          ON (`h_orden_qx_procedimientos`.`Id_Orden_Qx` = `h_orden_qx`.`Id`)     INNER JOIN `g_procedimiento`          ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`)     INNER JOIN `g_especialidad`          ON (`h_orden_qx_procedimientos`.`Id_Especialidad` = `g_especialidad`.`Id`)     INNER JOIN `g_profesional`          ON (`h_orden_qx_procedimientos`.`Id_Profesional` = `g_profesional`.`Id_Persona`)     INNER JOIN `f_empresacontxconvenio`          ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN `g_usuario`          ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)     INNER JOIN `g_persona`          ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`)     INNER JOIN `g_persona` AS `g_persona_1`         ON (`g_usuario`.`Id_persona` = `g_persona_1`.`Id`)  WHERE (`h_orden_qx`.`Estado` =1     AND `h_orden_qx`.`Fecha_Inicial` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_orden_qx`.`Fecha_Inicial` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  GROUP BY `f_empresacontxconvenio`.`Id`, `g_especialidad`.`Id`, `h_orden_qx_procedimientos`.`Id_Profesional`, `g_persona_1`.`NoDocumento`, `g_procedimiento`.`Id`  ORDER BY `NCOnvenio` ASC, `NEspecialidad` ASC, `NProfesional` ASC, `NProcedimiemto` ASC, `h_orden_qx`.`Fecha_Inicial` ASC;";
            System.out.println("Cirugias por Usuarios EPS y Profesional   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(3)), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(10)), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(12)), n, 11);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsultarAtenciones() {
        mCrearModeloConsultarAtenciones();
        try {
            this.xsql = null;
            this.xsql = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS fechaa, h_atencion.Hora_Atencion, persona.NoHistoria, persona.NUsuario,   persona.`Edad`Edad, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, h_atencion.Motivo_Atencion, h_atencion.Conclusion, h_atencion.Recomendaciones, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad, c_clasecita.`Nbre` NClaseCita, f_tipofinprocedimiento.`Nbre` NFinProcedimiento     FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario)   INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)      AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)       INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)       INNER JOIN g_usuario  ON (persona.Id_persona = g_usuario.Id_persona)       INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)     INNER JOIN `c_clasecita` ON (c_clasecita.Id = h_atencion.`Id_ClaseCita`)   INNER JOIN `f_tipofinprocedimiento`ON (f_tipofinprocedimiento.Id = c_clasecita.`Id_Finalidad`)  WHERE (h_atencion.Codigo_Dxp <>'' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'   AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
            System.out.println("Consultar Atenciones   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(9)), n, 8);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(10)), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString("NClaseCita"), n, 17);
                    this.xModelo.setValueAt(rs.getString("NFinProcedimiento"), n, 18);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosProcedimientosEmpresa() {
        mCrearModeloProcedimientosEmpresa();
        try {
            this.xsql = null;
            this.xsql = " SELECT  f_empresacontxconvenio . Nbre  ,  g_procedimiento . Id ,  g_procedimiento . Nbre , SUM( o_hc_tratamiento_procedimiento . Cantidad ) AS Cantidad \n FROM o_hc_tratamiento_procedimiento \niNNER JOIN   o_hc_tratamiento  ON ( o_hc_tratamiento_procedimiento . Id_Tratamiento  =  o_hc_tratamiento . Id ) \ninner join h_atencion ha on (ha.Id=o_hc_tratamiento.Id_Atencion)\nINNER JOIN   ingreso  ON ( ingreso . Id  =  ha.Id_Ingreso  )\nINNER JOIN   f_empresacontxconvenio ON ( ingreso . Id_EmpresaContxConv  =  f_empresacontxconvenio . Id ) \nINNER JOIN   g_procedimiento ON ( o_hc_tratamiento_procedimiento . IdProcedimiento  =  g_procedimiento . Id )\nWHERE ( ingreso . FechaIngreso  between '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND  '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND  o_hc_tratamiento_procedimiento . Estado  =1)\n GROUP BY  f_empresacontxconvenio . Id ,  g_procedimiento . Id \n ORDER BY  f_empresacontxconvenio . Nbre  ASC,  g_procedimiento . Nbre  ASC";
            System.out.println("Procedimientos Por Empresa   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsolidadoAtencionFecha() {
        mCrearModeloConsolidadoAtencionFecha();
        try {
            this.xsql = null;
            this.xsql = "SELECT  ingreso . FechaIngreso  ,  f_empresacontxconvenio . Nbre \n , COUNT( ingreso . FechaIngreso ) AS  Cantidad \nFROM   o_hc_tratamiento_procedimiento \nINNER JOIN   o_hc_tratamiento  ON ( o_hc_tratamiento_procedimiento . Id_Tratamiento  =  o_hc_tratamiento . Id )\ninner join h_atencion ha on (ha.Id=o_hc_tratamiento.Id_Atencion)\nINNER JOIN   ingreso  ON ( ingreso . Id  =  ha.Id_Ingreso  )\nINNER JOIN   f_empresacontxconvenio  ON ( ingreso . Id_EmpresaContxConv  =  f_empresacontxconvenio . Id )\nWHERE ( ingreso . FechaIngreso  between '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND  '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\nAND  o_hc_tratamiento_procedimiento . Estado  =1) \nGROUP BY  ingreso . FechaIngreso ,  f_empresacontxconvenio . Id ORDER BY  f_empresacontxconvenio . Nbre  ASC";
            System.out.println("Consolidado Atencions x Fecha --->  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRiesgoCardiovascular() {
        mCrearModeloRiesgoCardiovascular();
        try {
            this.xsql = null;
            this.xsql = "SELECT `f_co_atencion`.`Fecha_ingreso`, `f_co_atencion`.`Fecha_atencion`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`Apellido1`      , `persona`.`Apellido2`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`FechaNac`, `Devuelve_Edad_2F`(`persona`.`FechaNac`, `f_co_atencion`.`Fecha_atencion`) AS `Edad`      , `persona`.`NSexo`, `persona`.`EPS`, `persona`.`Direccion`, `persona`.`NBarrio`, `persona`.`NMunicipio`, `persona`.`Telefono`, `persona`.`Celular`     , IF(`f_co_cardiovascular`.`ConfirmadoHTA` =0, 'NO', 'SI') AS `CHTA`, `f_co_cardiovascular`.`Fecha_conf`, `f_co_cardiovascular`.`CostosHTA`     ,  IF(`f_co_cardiovascular`.`ConfirmadoDBT` =0, 'NO', 'SI') AS `CDiabetes`, `f_co_cardiovascular`.`Fecha_confdbt`, `f_co_cardiovascular`.`CostosDBT`     , `f_co_cardiovascular`.`EtiologiaR`, `f_co_atencion`.`Peso`, `f_co_atencion`.`Talla`, `f_co_atencion`.`Imc`, `f_co_atencion`.`Psistolica`     , `f_co_atencion`.`Pdistolica`, `f_co_cardiovascular`.`clasificacion`, `f_co_atencion`.`Id`,     #DATOS DE LA CREATININA   IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`AND `g_procedimiento`.`Id` =903825) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida`INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`AND `g_procedimiento`.`Id` =903825) GROUP BY `g_procedimiento`.`Id`  )) AS RCreatinida,  IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`AND `g_procedimiento`.`Id` =903825) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903825) GROUP BY `g_procedimiento`.`Id` )) AS FCreatinida,  #DATOS DE LA HEMOGLOBINA  IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)  INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`AND `g_procedimiento`.`Id` =903426) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903426)  GROUP BY `g_procedimiento`.`Id` )) AS RHemoglobinaGlico,  IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903426) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903426) GROUP BY `g_procedimiento`.`Id`  )) AS FHemoglobinaGlico, #RESULTADO COLESTEROL TOTAL IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados`   ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)INNER JOIN  `g_procedimiento`   ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`)WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`  AND `g_procedimiento`.`Id` =903818) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`      FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)  INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903818) GROUP BY `g_procedimiento`.`Id` )) AS RCTotal,  IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados`   ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903818) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903818) GROUP BY `g_procedimiento`.`Id`  )) AS FCTotal,   #RESULTADO COLESTEROL HDL  IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)  INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903815) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903815) GROUP BY `g_procedimiento`.`Id` )) AS RCHdl, IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados`  ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903815) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903815) GROUP BY `g_procedimiento`.`Id`  )) AS FCHdl, #RESULTADO COLESTEROL LDL  IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)  INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903816) GROUP BY `g_procedimiento`.`Id`  )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`  FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903816) GROUP BY `g_procedimiento`.`Id` )) AS RCLdl,  IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados`   ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)INNER JOIN  `g_procedimiento`   ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903816) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`  FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903816) GROUP BY `g_procedimiento`.`Id` )) AS FCLdl, #RESULTADO TRIGLICERIDOS IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903868) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida`INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`)WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903868) GROUP BY `g_procedimiento`.`Id` )) AS RCTrigliceridos , IF( (SELECT `f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id`AND `g_procedimiento`.`Id` =903868) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903868) GROUP BY `g_procedimiento`.`Id`  )) AS FCTrigliceridos,  #RESULTADO POTASIO  IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903859) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`  FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`)WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903859) GROUP BY `g_procedimiento`.`Id` )) AS RPotasio , IF( (SELECT `f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903859) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903859) GROUP BY `g_procedimiento`.`Id`  )) AS FPotasio, #RESULTADO MICROALBUMINUIRIA IF( (SELECT`f_co_resultados`.`Resultado`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903026) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Resultado`   FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento` ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903026) GROUP BY `g_procedimiento`.`Id` )) AS RMicroalbuminuria , IF( (SELECT `f_co_resultados`.`Fecha_R`    FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados`  ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento`ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903026) GROUP BY `g_procedimiento`.`Id` )  IS NULL, 0,(SELECT`f_co_resultados`.`Fecha_R`     FROM `p_demanda_inducida` INNER JOIN  `f_co_resultados` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`) INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_co_resultados`.`Id_antencion` =`f_co_atencion`.`Id` AND `g_procedimiento`.`Id` =903026) GROUP BY `g_procedimiento`.`Id`  )) AS FMicroalbuminuria, g_patologia.`Id`, g_patologia.`Nbre` AS NPatologia, c_clasecita.`Nbre` AS ClasiCita, IF(f_co_cardiovascular.`Medicamento1`=0, 'NO', 'SI') AS MInhibidor, IF(f_co_cardiovascular.`Medicamento2`=0, 'NO', 'SI') AS MAntagonista, IF(f_co_cardiovascular.`EnfRenal`=0, 'NO', 'SI') AS EnfRenal FROM `f_co_cardiovascular` INNER JOIN  `f_co_atencion` ON (`f_co_cardiovascular`.`Id_atencion` = `f_co_atencion`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `f_co_atencion`.`Id_persona`) INNER JOIN  `g_patologia` ON (`g_patologia`.`Id` = `f_co_atencion`.`cie10P`) INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `f_co_atencion`.`Id_clasecita`) WHERE `f_co_atencion`.`Fecha_ingreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'   AND `f_co_atencion`.`Fecha_ingreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  ";
            System.out.println("Riesgo Cardiovascular  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 30);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    this.xModelo.setValueAt(rs.getString(33), n, 32);
                    this.xModelo.setValueAt(rs.getString(34), n, 33);
                    this.xModelo.setValueAt(rs.getString(35), n, 34);
                    this.xModelo.setValueAt(rs.getString(36), n, 35);
                    this.xModelo.setValueAt(rs.getString(37), n, 36);
                    this.xModelo.setValueAt(rs.getString(38), n, 37);
                    this.xModelo.setValueAt(rs.getString(39), n, 38);
                    this.xModelo.setValueAt(rs.getString(40), n, 39);
                    this.xModelo.setValueAt(rs.getString(41), n, 40);
                    this.xModelo.setValueAt(rs.getString(42), n, 41);
                    this.xModelo.setValueAt(rs.getString(43), n, 42);
                    this.xModelo.setValueAt(rs.getString(44), n, 43);
                    this.xModelo.setValueAt(rs.getString(45), n, 44);
                    this.xModelo.setValueAt(rs.getString(46), n, 45);
                    this.xModelo.setValueAt(rs.getString(47), n, 46);
                    this.xModelo.setValueAt(rs.getString(48), n, 47);
                    this.xModelo.setValueAt(rs.getString(49), n, 48);
                    this.xModelo.setValueAt(rs.getString(50), n, 49);
                    this.xModelo.setValueAt(rs.getString(51), n, 50);
                    this.xModelo.setValueAt(rs.getString(52), n, 51);
                    this.xModelo.setValueAt(rs.getString(53), n, 52);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRiesgoObstetrico() {
        mCrearModeloRiesgoObstetrico();
        try {
            this.xsql = null;
            if (!this.JCHFiltro.isSelected() || this.xLleno) {
                this.xsql = "";
            } else {
                this.xsql = "";
            }
            System.out.println("Riesgo Obstétrico  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 30);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    this.xModelo.setValueAt(rs.getString(33), n, 32);
                    this.xModelo.setValueAt(rs.getString(34), n, 33);
                    this.xModelo.setValueAt(rs.getString(35), n, 34);
                    this.xModelo.setValueAt(rs.getString(36), n, 35);
                    this.xModelo.setValueAt(rs.getString(37), n, 36);
                    this.xModelo.setValueAt(rs.getString(38), n, 37);
                    this.xModelo.setValueAt(rs.getString(39), n, 38);
                    this.xModelo.setValueAt(rs.getString(40), n, 39);
                    this.xModelo.setValueAt(rs.getString(41), n, 40);
                    this.xModelo.setValueAt(rs.getString(42), n, 41);
                    this.xModelo.setValueAt(rs.getString(43), n, 42);
                    this.xModelo.setValueAt(rs.getString(44), n, 43);
                    this.xModelo.setValueAt(rs.getString(45), n, 44);
                    this.xModelo.setValueAt(rs.getString(46), n, 45);
                    this.xModelo.setValueAt(rs.getString(47), n, 46);
                    this.xModelo.setValueAt(rs.getString(48), n, 47);
                    this.xModelo.setValueAt(rs.getString(49), n, 49);
                    this.xModelo.setValueAt(rs.getString(50), n, 50);
                    this.xModelo.setValueAt(rs.getString(51), n, 51);
                    this.xModelo.setValueAt(rs.getString(52), n, 52);
                    this.xModelo.setValueAt(rs.getString(53), n, 53);
                    this.xModelo.setValueAt(rs.getString(54), n, 54);
                    this.xModelo.setValueAt(rs.getString(55), n, 55);
                    this.xModelo.setValueAt(rs.getString(56), n, 56);
                    this.xModelo.setValueAt(rs.getString(57), n, 57);
                    this.xModelo.setValueAt(rs.getString(58), n, 58);
                    this.xModelo.setValueAt(rs.getString(59), n, 59);
                    this.xModelo.setValueAt(rs.getString(60), n, 60);
                    this.xModelo.setValueAt(rs.getString(61), n, 61);
                    this.xModelo.setValueAt(rs.getString(62), n, 62);
                    this.xModelo.setValueAt(rs.getString(63), n, 63);
                    this.xModelo.setValueAt(rs.getString(64), n, 64);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosPrograma() {
        mCrearModeloPrograma();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Apellido1` , `g_persona`.`Apellido2`,    `g_persona`.`Id_TipoIdentificacion` , `g_persona`.`NoDocumento`,  `Devuelve_Edad_2F`(`g_persona`.`FechaNac` , `h_atencion`.`Fecha_Atencion`) AS `Edad`    , `f_empresacontxconvenio`.`Nbre` AS `NConvenio`, `g_persona`.`Direccion`, `g_barrio`.`Nbre` AS `NBarrio`, `g_municipio`.`Nbre` AS `NMunicipio`, `g_persona`.`Telefono`    , `g_persona`.`Movil`, IF(`g_usuarioxprograma`.`EsIngreso` IS NULL ,'NO', 'SI') AS `PROGRAMA`, IF(`c_clasecita`.`EsControl` = 1, 'NO', 'SI') AS `NUEVO`, ifnull(`h_examenfisico`.`SGestacion`, 0) SGestacion     , `g_patologia`.`Id` AS `CDx_P`, `g_patologia`.`Nbre` AS `NDx_P`, IF(`g_patologia_1`.`Id` IS NULL, '',`g_patologia_1`.`Id` ) AS `CDx_R1`,  IF(`g_patologia_1`.`Id` IS NULL, '',`g_patologia_1`.`Nbre`) AS `NDx_R1`    ,  IF(`g_patologia_2`.`Id` IS NULL, '',`g_patologia_2`.`Id`) AS `CDx_R2`,  IF(`g_patologia_2`.`Id` IS NULL, '',`g_patologia_2`.`Nbre`) AS `NDx_R2`,  IF(`g_patologia_3`.`Id` IS NULL, '',`g_patologia_3`.`Id`) AS `CDx_R3`    ,  IF(`g_patologia_3`.`Id` IS NULL, '',`g_patologia_3`.`Nbre`) AS `NDx_R3`FROM    `h_atencion` INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)    INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `g_empresa` ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)    INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)INNER JOIN  `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)    INNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)INNER JOIN  `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)INNER JOIN  `g_barrio`    ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)    INNER JOIN  `profesional1`    ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)LEFT JOIN  `g_usuarioxprograma`     ON (`g_usuarioxprograma`.`Id` = `h_atencion`.`IdUsuarioPrograma`) AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)LEFT JOIN  `h_examenfisico`    ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN  `g_patologia`ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)LEFT JOIN  `g_patologia` AS `g_patologia_1`    ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)LEFT JOIN  `g_patologia` AS `g_patologia_2`ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)LEFT JOIN  `g_patologia` AS `g_patologia_3`    ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'    AND `h_atencion`.`Codigo_Dxp` <>'' AND `g_tipoprograma`.`Id_TipoPrograma` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NConvenio` ASC, `g_persona`.`Apellido1` ASC; ";
            } else {
                this.xsql = "SELECT `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2`    , `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`,  `Devuelve_Edad_2F`(`g_persona`.`FechaNac` , `h_atencion`.`Fecha_Atencion`) AS `Edad`, `f_empresacontxconvenio`.`Nbre` AS `NConvenio`    , `g_persona`.`Direccion`, `g_barrio`.`Nbre` AS `NBarrio`, `g_municipio`.`Nbre` AS `NMunicipio`, `g_persona`.`Telefono`, `g_persona`.`Movil`    , IF(`g_usuarioxprograma`.`EsIngreso` IS NULL ,'NO', 'SI') AS `PROGRAMA`, IF(`c_clasecita`.`EsControl` = 1, 'NO', 'SI') AS `NUEVO`, ifnull(`h_examenfisico`.`SGestacion`, 0) SGestacion     , `g_patologia`.`Id` AS `CDx_P`, `g_patologia`.`Nbre` AS `NDx_P`, IF(`g_patologia_1`.`Id` IS NULL, '',`g_patologia_1`.`Id` ) AS `CDx_R1`,  IF(`g_patologia_1`.`Id` IS NULL, '',`g_patologia_1`.`Nbre`) AS `NDx_R1`    ,  IF(`g_patologia_2`.`Id` IS NULL, '',`g_patologia_2`.`Id`) AS `CDx_R2`,  IF(`g_patologia_2`.`Id` IS NULL, '',`g_patologia_2`.`Nbre`) AS `NDx_R2`,  IF(`g_patologia_3`.`Id` IS NULL, '',`g_patologia_3`.`Id`) AS `CDx_R3`    ,  IF(`g_patologia_3`.`Id` IS NULL, '',`g_patologia_3`.`Nbre`) AS `NDx_R3`FROM `h_atencion`INNER JOIN  `ingreso`        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `f_empresacontxconvenio`        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)    INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `g_empresa`        ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)INNER JOIN  `g_tipoprograma`        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)INNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)    INNER JOIN  `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)INNER JOIN  `g_barrio` ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)    INNER JOIN  `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)    LEFT JOIN  `g_usuarioxprograma` ON (`g_usuarioxprograma`.`Id` = `h_atencion`.`IdUsuarioPrograma`) AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)    LEFT JOIN  `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN  `g_patologia` ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)    LEFT JOIN  `g_patologia` AS `g_patologia_1` ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)LEFT JOIN  `g_patologia` AS `g_patologia_2`        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)LEFT JOIN  `g_patologia` AS `g_patologia_3` ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND `h_atencion`.`Codigo_Dxp` <>'')ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `NConvenio` ASC, `g_persona`.`Apellido1` ASC;";
            }
            System.out.println("Programa   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosEspecialidad() {
        mCrearModeloEspecialidad();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta` AS `Empresa`, `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre` AS `Convenio`, `g_tipoprograma`.`Id_TipoPrograma`, `g_tipoprograma`.`Nbre` AS `NPrograma`, `c_clasecita`.`Id`, `c_clasecita`.`Nbre` AS `TipCita`, COUNT(`c_clasecita`.`Id`) AS `Cantidad`FROM  `h_atencion`INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio`ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `g_empresa` ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)INNER JOIN  `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND `h_atencion`.`Codigo_Dxp` <>''    AND `h_atencion`.`Id_Especialidad` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')GROUP BY `cc_terceros`.`Id`, `f_empresacontxconvenio`.`Id`, `c_clasecita`.`Id`ORDER BY `Empresa` ASC, `Convenio` ASC, `NPrograma` ASC, `TipCita` ASC";
            } else {
                this.xsql = "SELECT `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta` AS `Empresa`, `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre` AS `Convenio`, `g_tipoprograma`.`Id_TipoPrograma`, `g_tipoprograma`.`Nbre` AS `NPrograma`, `c_clasecita`.`Id`, `c_clasecita`.`Nbre` AS `TipCita`, COUNT(`c_clasecita`.`Id`) AS `Cantidad`FROM  `h_atencion`INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio`ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `g_empresa` ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)INNER JOIN  `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND `h_atencion`.`Codigo_Dxp` <>'')GROUP BY `cc_terceros`.`Id`, `f_empresacontxconvenio`.`Id`, `c_clasecita`.`Id`ORDER BY `Empresa` ASC, `Convenio` ASC, `NPrograma` ASC, `TipCita` ASC;";
            }
            System.out.println("Especialidad   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRadiologia() {
        mCrearModeloRadiologia();
        try {
            this.xsql = null;
            this.xsql = "SELECT RazonSocialCompleta,  Nbre,  SUM(TOTAL_ORDENES) TOTAL_ORDENES ,  SUM(ORD_AMBULATORIA) ORD_AMBULATORIA,  SUM(ORD_HOSPITALIZADO) ORD_HOSPITALIZADO,  SUM(ORD_URGENCIA) ORD_URGENCIA,  SUM(TOTAL_ESTUDIOS) TOTAL_ESTUDIOS ,  SUM(EST_AMBULATORIA) EST_AMBULATORIA,  SUM(EST_HOSPITALIZADO) EST_HOSPITALIZADO,  SUM(EST_URGENCIA) EST_URGENCIA FROM (SELECT RazonSocialCompleta,Nbre,SUM(NOrden) TOTAL_ORDENES, CASE WHEN  Id_TipoA=1 THEN SUM(NOrden)ELSE 0 END  ORD_AMBULATORIA, CASE WHEN  Id_TipoA=2 THEN SUM(NOrden) ELSE 0 END  ORD_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NOrden) ELSE 0 END  ORD_URGENCIA, SUM(NEstudios) TOTAL_ESTUDIOS, CASE WHEN  Id_TipoA=1 THEN SUM(NEstudios) ELSE 0 END  EST_AMBULATORIA,  CASE WHEN  Id_TipoA=2 THEN SUM(NEstudios) ELSE 0 END  EST_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NEstudios) ELSE 0 END  EST_URGENCIA FROM (SELECT `cc_terceros`.`RazonSocialCompleta`,  `f_empresacontxconvenio`.`Nbre`, h_radiologia.Id_TipoA, COUNT(DISTINCT(`h_radiologia`.`Id`)) AS `NOrden`, COUNT(`h_radiologia_detalle`.`Id`) AS `NEstudios` FROM `h_radiologia_detalle`  INNER JOIN  `h_radiologia` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)INNER JOIN  `f_ordenes` ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN  `g_procedimiento`ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN  `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)  WHERE (`h_radiologia`.`Estado` =1 AND `f_ordenes`.`Estado` =0  AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `cc_terceros`.`RazonSocialCompleta`, `f_empresacontxconvenio`.`Id`, h_radiologia.Id_TipoA ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `f_empresacontxconvenio`.`Nbre` ASC,   h_radiologia.Id_TipoA) A GROUP BY RazonSocialCompleta, Nbre,Id_TipoA) B GROUP BY RazonSocialCompleta, Nbre";
            System.out.println("Radiología   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosProcedimientoDet() {
        mCrearModeloProcedimientoDet();
        try {
            this.xsql = null;
            this.xsql = "SELECT RazonSocialCompleta, Nbre,NProcedimiento, SUM(TOTAL_ORDENES) TOTAL_ORDENES , SUM(ORD_AMBULATORIA) ORD_AMBULATORIA, SUM(ORD_HOSPITALIZADO) ORD_HOSPITALIZADO, SUM(ORD_URGENCIA) ORD_URGENCIA, SUM(TOTAL_ESTUDIOS) TOTAL_ESTUDIOS , SUM(EST_AMBULATORIA) EST_AMBULATORIA, SUM(EST_HOSPITALIZADO) EST_HOSPITALIZADO, SUM(EST_URGENCIA) EST_URGENCIA FROM (SELECT RazonSocialCompleta,Nbre, Id_Procedimiento,NProcedimiento,SUM(NOrden) TOTAL_ORDENES, CASE WHEN  Id_TipoA=1 THEN SUM(NOrden) ELSE 0 END  ORD_AMBULATORIA, CASE WHEN  Id_TipoA=2 THEN SUM(NOrden) ELSE 0 END  ORD_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NOrden) ELSE 0 END  ORD_URGENCIA, SUM(NEstudios) TOTAL_ESTUDIOS, CASE WHEN  Id_TipoA=1 THEN SUM(NEstudios)ELSE 0 END  EST_AMBULATORIA,CASE WHEN  Id_TipoA=2 THEN SUM(NEstudios) ELSE 0 END  EST_HOSPITALIZADO,CASE WHEN  Id_TipoA=3 THEN SUM(NEstudios) ELSE 0 END  EST_URGENCIA FROM (SELECT `cc_terceros`.`RazonSocialCompleta` , `f_empresacontxconvenio`.`Nbre`, h_radiologia.Id_TipoA,`g_procedimiento`.`Id` AS Id_Procedimiento, g_procedimiento.`Nbre` AS NProcedimiento    , COUNT(DISTINCT(`h_radiologia`.`Id`)) AS `NOrden` , COUNT(`h_radiologia_detalle`.`Id`) AS `NEstudios` FROM  `h_radiologia_detalle` INNER JOIN  `h_radiologia` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)INNER JOIN  `f_ordenes` ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN  `g_procedimiento` ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`) WHERE (`h_radiologia`.`Estado` =1 AND `f_ordenes`.`Estado` =0     AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')GROUP BY `cc_terceros`.`RazonSocialCompleta`, `f_empresacontxconvenio`.`Id`, h_radiologia.Id_TipoA, `g_procedimiento`.`Id`ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `f_empresacontxconvenio`.`Nbre` ASC, NProcedimiento ASC,   h_radiologia.Id_TipoA) A GROUP BY RazonSocialCompleta, Nbre,Id_TipoA, NProcedimiento) B GROUP BY RazonSocialCompleta, Nbre, Id_Procedimiento";
            System.out.println("Procedimiento Detalle   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosProcedimiento() {
        mCrearModeloProcedimiento();
        try {
            this.xsql = null;
            this.xsql = "SELECT NProcedimiento,  SUM(TOTAL_ORDENES) TOTAL_ORDENES ,  SUM(ORD_AMBULATORIA) ORD_AMBULATORIA,  SUM(ORD_HOSPITALIZADO) ORD_HOSPITALIZADO,  SUM(ORD_URGENCIA) ORD_URGENCIA,  SUM(TOTAL_ESTUDIOS) TOTAL_ESTUDIOS ,  SUM(EST_AMBULATORIA) EST_AMBULATORIA,  SUM(EST_HOSPITALIZADO) EST_HOSPITALIZADO,  SUM(EST_URGENCIA) EST_URGENCIA FROM (SELECT RazonSocialCompleta, Nbre, Id_Procedimiento,NProcedimiento,SUM(NOrden) TOTAL_ORDENES, CASE WHEN  Id_TipoA=1 THEN SUM(NOrden) ELSE 0 END  ORD_AMBULATORIA,  CASE WHEN  Id_TipoA=2 THEN SUM(NOrden) ELSE 0 END  ORD_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NOrden) ELSE 0 END  ORD_URGENCIA,  SUM(NEstudios) TOTAL_ESTUDIOS, CASE WHEN  Id_TipoA=1 THEN SUM(NEstudios) ELSE 0 END  EST_AMBULATORIA, CASE WHEN  Id_TipoA=2 THEN SUM(NEstudios)   ELSE 0 END  EST_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NEstudios) ELSE 0 END  EST_URGENCIA FROM (SELECT `cc_terceros`.`RazonSocialCompleta`,  `f_empresacontxconvenio`.`Nbre`, h_radiologia.Id_TipoA,`g_procedimiento`.`Id` AS Id_Procedimiento, g_procedimiento.`Nbre` AS NProcedimiento, COUNT(DISTINCT(`h_radiologia`.`Id`)) AS `NOrden`     , COUNT(`h_radiologia_detalle`.`Id`) AS `NEstudios` FROM   `h_radiologia_detalle` INNER JOIN   `h_radiologia` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)     INNER JOIN   `f_ordenes` ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN   `g_procedimiento` ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)     INNER JOIN   `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN   `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN   `cc_terceros` ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`) WHERE (`h_radiologia`.`Estado` =1 AND `f_ordenes`.`Estado` =0      AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND DATE_FORMAT(h_radiologia.`Fecha_Rec`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `g_procedimiento`.`Id`,  h_radiologia.Id_TipoA ORDER BY NProcedimiento ASC,   h_radiologia.Id_TipoA) A GROUP BY Id_Procedimiento, Id_TipoA) B GROUP BY Id_Procedimiento";
            System.out.println("Procedimiento   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosAsignacionCitas() {
        mCrearModeloAsigancionCitas();
        try {
            this.xsql = null;
            this.xsql = "SELECT CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , COUNT(`c_citas`.`Id`) AS `Cantidad`FROM  `rh_tipo_persona_cargon` INNER JOIN  `c_citas` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `c_citas`.`Id_UsuarioS`) INNER JOIN  `f_empresacontxconvenio`ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `c_citas`.`Id_MotivoDesistida` =1)GROUP BY `g_persona`.`Id`ORDER BY `NUsuario` ASC";
            System.out.println("Procedimiento   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int xTotal = 0;
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(2)), n, 1);
                    xTotal = (int) (((long) xTotal) + rs.getLong(2));
                    n++;
                }
                this.JTFTotal.setValue("" + xTotal);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosCitasPorEmpresa() {
        mCrearModeloCitasPorEmpresa();
        try {
            this.xsql = null;
            this.xsql = "DROP TABLE IF EXISTS c_tmp_rcitas; ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "CREATE TABLE c_tmp_rcitas SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`, CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre` AS `NClaseCita`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`, `g_ips`.`Nbre` AS `NEntidadF`, `c_citas`.`Fecha_Cita` AS `FechaI`, `c_citas`.`HoraInicial` AS `HoraA`, `g_especialidad`.`Nbre` AS `NEspecialidad`, CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`, `f_empresacontxconvenio`.`Id`,IF(`c_citas`.`Fecha_SUsuario` IS NULL, '',`c_citas`.`Fecha_SUsuario`)AS FechaSolicitud,c_citas.`Fecha`AS FechaAsisnacion, 'PROGRAMADA   ' as Forma FROM  `g_persona` INNER JOIN  `c_citas` ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)INNER JOIN  `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1` ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`) INNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND c_citas.`Id_MotivoDesistida`=1 AND f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')ORDER BY `FechaI` ASC, `HoraA` ASC";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO c_tmp_rcitas(  `Documento` , `NUsuario`  , `Id_Sexo` , `NClaseCita` , `NEmpresaC` , `NEntidadF` , `FechaI` , `HoraA` , `NEspecialidad` , `NProfesional` , `Id` , `FechaSolicitud` , `FechaAsisnacion` , `Forma`) SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`,  CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`,  `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre` AS `NClaseCita`,   `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`, `g_ips`.`Nbre` AS `NEntidadF`,    `c_citasnp`.`Fecha_Cita` AS `FechaI`, `c_citasnp`.`HoraInicial` AS `HoraA`, `g_especialidad`.`Nbre` AS `NEspecialidad`,    CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`,     `f_empresacontxconvenio`.`Id` ,IF(`c_citasnp`.`Fecha_Cita`IS NULL, '',`c_citasnp`.`Fecha_Cita`)AS FechaSolicitud,c_citasnp.`Fecha`AS FechaAsisnacion  , 'NO PROGRAMADA' AS Forma FROM  `g_persona` INNER JOIN  `c_citasnp` ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)INNER JOIN  `f_empresacontxconvenio` ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `c_clasecita` ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1`  ON (`g_persona_1`.`Id` = `c_citasnp`.`Id_Profesional`) INNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `c_citasnp`.`Id_Especialidad`)  WHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND c_citasnp.`Id_Anulada`=0 AND f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')ORDER BY `FechaI` ASC, `HoraA` ASC";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            } else {
                this.xsql = "CREATE TABLE c_tmp_rcitas  SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`, CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre` AS `NClaseCita`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`, `g_ips`.`Nbre` AS `NEntidadF`, `c_citas`.`Fecha_Cita` AS `FechaI`, `c_citas`.`HoraInicial` AS `HoraA`, `g_especialidad`.`Nbre` AS `NEspecialidad`, CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`, `f_empresacontxconvenio`.`Id` ,IF(`c_citas`.`Fecha_SUsuario` IS NULL, '',`c_citas`.`Fecha_SUsuario`)AS FechaSolicitud,c_citas.`Fecha`AS FechaAsisnacion, 'PROGRAMADA   ' as Forma FROM  `g_persona` INNER JOIN  `c_citas` ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)INNER JOIN  `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1`  ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`) INNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND c_citas.`Id_MotivoDesistida`=1)ORDER BY `FechaI` ASC, `HoraA` ASC";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO c_tmp_rcitas(  `Documento` , `NUsuario`  , `Id_Sexo` , `NClaseCita` , `NEmpresaC` , `NEntidadF` , `FechaI` , `HoraA` , `NEspecialidad` , `NProfesional` , `Id` , `FechaSolicitud` , `FechaAsisnacion` , `Forma`) SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`,  CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`,  `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre` AS `NClaseCita`,   `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`, `g_ips`.`Nbre` AS `NEntidadF`,    `c_citasnp`.`Fecha_Cita` AS `FechaI`, `c_citasnp`.`HoraInicial` AS `HoraA`, `g_especialidad`.`Nbre` AS `NEspecialidad`,    CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`,     `f_empresacontxconvenio`.`Id` ,IF(`c_citasnp`.`Fecha_Cita`IS NULL, '',`c_citasnp`.`Fecha_Cita`)AS FechaSolicitud,c_citasnp.`Fecha`AS FechaAsisnacion  , 'NO PROGRAMADA' AS Forma FROM  `g_persona` INNER JOIN  `c_citasnp` ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)INNER JOIN  `f_empresacontxconvenio` ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `c_clasecita` ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1`  ON (`g_persona_1`.`Id` = `c_citasnp`.`Id_Profesional`) INNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `c_citasnp`.`Id_Especialidad`)  WHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND c_citasnp.`Id_Anulada`=0 )ORDER BY `FechaI` ASC, `HoraA` ASC";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            this.xsql = "SELECT  `Documento` , `NUsuario`  , `Id_Sexo` , `NClaseCita`  , `NEmpresaC` , `NEntidadF`  , `FechaI` , `HoraA` , `NEspecialidad` , `NProfesional` , `Id` , `FechaSolicitud`  , `FechaAsisnacion` , `Forma` FROM `c_tmp_rcitas` ORDER BY `FechaI` ASC, `HoraA` ASC";
            System.out.println("Citas Por Empresa  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosDetalleEntradaPorBodega() {
        mCrearModeloDetalleEntradaPorBodega();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT     `i_entradas`.`Id`     , `i_entradas`.`NoFactura`     , `i_periodo`.`Nbre` AS `NPeriodo`     , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimiento`     , `i_tiposmovimientos`.`Id`     , `i_suministro`.`Id`     , `i_suministro`.`Nbre` AS `NSuministro`     , `i_presentacionfarmaceutica`.`Nbre` AS `NPresentacion`     , `i_detalleentrada`.`Cantidad`     , `i_detalleentrada`.`ValorUnitario`     , `i_detalleentrada`.`Iva`     , ROUND(`i_detalleentrada`.`ValorUnitario`* `i_detalleentrada`.`Cantidad`) AS `Total`     , `cc_terceros`.`RazonSocialCompleta`  FROM     `i_detalleentrada`     INNER JOIN `i_entradas`          ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)     INNER JOIN `i_periodo`          ON (`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)     INNER JOIN `i_tiposmovimientos`          ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)     INNER JOIN `i_suministro`          ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`)     INNER JOIN `i_presentacionfarmaceutica`          ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)     INNER JOIN `cc_terceros`          ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)  WHERE (`i_entradas`.`Estado` =0     AND `i_entradas`.`IdBodega` = '" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'     AND `i_entradas`.`FechaEntrada` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'     AND `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')  ORDER BY `i_entradas`.`Id` ASC, `NSuministro` ASC, `NPresentacion` ASC, `i_periodo`.`FechaI` ASC;";
            }
            System.out.println("Detalle Entrada Por Bodega   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(2)), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(5)), n, 4);
                    this.xModelo.setValueAt(Long.valueOf(rs.getLong(6)), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 8);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(10)), n, 9);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(11)), n, 10);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble(12)), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosConsolProcedLabDet() {
        mCrearModeloConsolProcedLabDet();
        try {
            this.xsql = null;
            this.xsql = " SELECT RazonSocialCompleta,                          Nbre,NProcedimiento,                          SUM(TOTAL_ORDENES) TOTAL_ORDENES ,                          SUM(ORD_AMBULATORIA) ORD_AMBULATORIA,                          SUM(ORD_HOSPITALIZADO) ORD_HOSPITALIZADO,                          SUM(ORD_URGENCIA) ORD_URGENCIA,                          SUM(TOTAL_ESTUDIOS) TOTAL_ESTUDIOS ,                          SUM(EST_AMBULATORIA) EST_AMBULATORIA,                          SUM(EST_HOSPITALIZADO) EST_HOSPITALIZADO,                          SUM(EST_URGENCIA) EST_URGENCIA                          FROM (SELECT RazonSocialCompleta,Nbre, Id_Procedimiento,NProcedimiento,SUM(NOrden) TOTAL_ORDENES, CASE WHEN  Id_TipoA=1 THEN SUM(NOrden) ELSE 0 END  ORD_AMBULATORIA,                          CASE WHEN  Id_TipoA=2 THEN SUM(NOrden) ELSE 0 END  ORD_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NOrden) ELSE 0 END  ORD_URGENCIA,                          SUM(NEstudios) TOTAL_ESTUDIOS, CASE WHEN  Id_TipoA=1 THEN SUM(NEstudios)ELSE 0 END  EST_AMBULATORIA,CASE WHEN  Id_TipoA=2 THEN SUM(NEstudios) ELSE 0 END  EST_HOSPITALIZADO,                         CASE WHEN  Id_TipoA=3 THEN SUM(NEstudios) ELSE 0 END  EST_URGENCIA FROM                          (SELECT `cc_terceros`.`RazonSocialCompleta` , `f_empresacontxconvenio`.`Nbre`, l_recepcion.Id_TipoA,`g_procedimiento`.`Id` AS Id_Procedimiento, g_procedimiento.`Nbre` AS NProcedimiento                             , COUNT(DISTINCT(`l_recepcion`.`Id`)) AS `NOrden` , COUNT(`l_detallerecepcion`.`Id_Recepcion`) AS `NEstudios`                          FROM  `l_detallerecepcion`                            INNER JOIN   `l_recepcion` ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)                              INNER JOIN   `f_ordenes` ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)                             INNER JOIN   `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)                              INNER JOIN   `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)                             INNER JOIN   `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)                              INNER JOIN   `cc_terceros` ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)                             WHERE (`l_recepcion`.`Estado` =0 AND `f_ordenes`.`Estado` =0                              AND DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  )                         GROUP BY `cc_terceros`.`RazonSocialCompleta`, `f_empresacontxconvenio`.`Id`,  l_recepcion.Id_TipoA, `g_procedimiento`.`Id`                         ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `f_empresacontxconvenio`.`Nbre` ASC, NProcedimiento ASC,   l_recepcion.Id_TipoA) A                          GROUP BY RazonSocialCompleta, Nbre,Id_TipoA, NProcedimiento) B GROUP BY RazonSocialCompleta, Nbre, Id_Procedimiento;";
            System.out.println("Consolidado Procedi  Detallado Lab--->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosEstadisProcedLab() {
        mCrearModeloEstadisProcedLab();
        try {
            this.xsql = null;
            this.xsql = "SELECT NProcedimiento,                           SUM(TOTAL_ORDENES) TOTAL_ORDENES ,                           SUM(ORD_AMBULATORIA) ORD_AMBULATORIA,                           SUM(ORD_HOSPITALIZADO) ORD_HOSPITALIZADO,                           SUM(ORD_URGENCIA) ORD_URGENCIA,                           SUM(TOTAL_ESTUDIOS) TOTAL_ESTUDIOS ,                           SUM(EST_AMBULATORIA) EST_AMBULATORIA,                           SUM(EST_HOSPITALIZADO) EST_HOSPITALIZADO,                           SUM(EST_URGENCIA) EST_URGENCIA                          FROM (SELECT RazonSocialCompleta, Nbre, Id_Procedimiento,NProcedimiento,SUM(NOrden) TOTAL_ORDENES, CASE WHEN  Id_TipoA=1 THEN SUM(NOrden) ELSE 0 END  ORD_AMBULATORIA,                           CASE WHEN  Id_TipoA=2 THEN SUM(NOrden) ELSE 0 END  ORD_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NOrden) ELSE 0 END  ORD_URGENCIA,                           SUM(NEstudios) TOTAL_ESTUDIOS, CASE WHEN  Id_TipoA=1 THEN SUM(NEstudios) ELSE 0 END  EST_AMBULATORIA, CASE WHEN  Id_TipoA=2 THEN SUM(NEstudios)                            ELSE 0 END  EST_HOSPITALIZADO, CASE WHEN  Id_TipoA=3 THEN SUM(NEstudios) ELSE 0 END  EST_URGENCIA FROM (SELECT `cc_terceros`.`RazonSocialCompleta`,                           `f_empresacontxconvenio`.`Nbre`, l_recepcion.Id_TipoA,`g_procedimiento`.`Id` AS Id_Procedimiento, g_procedimiento.`Nbre` AS NProcedimiento, COUNT(DISTINCT(`l_recepcion`.`Id`)) AS `NOrden`                              , COUNT(`l_detallerecepcion`.`Id_Procedim`) AS `NEstudios`                             FROM  `l_detallerecepcion`                            INNER JOIN   `l_recepcion` ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)                              INNER JOIN   `f_ordenes` ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)                             INNER JOIN   `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)                              INNER JOIN   `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)                             INNER JOIN   `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)                              INNER JOIN   `cc_terceros` ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)                             WHERE ( DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')                          GROUP BY `g_procedimiento`.`Id`,  l_recepcion.Id_TipoA ORDER BY NProcedimiento ASC,    l_recepcion.Id_TipoA) A GROUP BY Id_Procedimiento, Id_TipoA) B GROUP BY Id_Procedimiento ;";
            System.out.println("Procedimiento Lab--->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarProcedimientosOrdenadosUsuario() {
        mCrearModeloProcedimientosOrdenadosUsuario();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT \n  g_persona.`Id_TipoIdentificacion`\n, g_persona.`NoDocumento`\n, g_persona.`Apellido1`\n, g_persona.`Apellido2`\n, g_persona.`Nombre1`\n, g_persona.`Nombre2`\n, g_persona.`Id_Sexo`, `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`\n, h_atencion.`Fecha_Atencion`) Edad\n, h_ordenes.`FechaOrden`,  `g_procedimiento`.`Id` \n,`g_procedimiento`.`Nbre` AS `NProcedimiento`\n, f_empresacontxconvenio.`Nbre` EmpresaConvenio\n, g_especialidad.`Nbre` `Especialidad`\n, CONCAT(profesional1.`Apellido1`,' ', profesional1.`Apellido2`,' ',profesional1.`Nombre1`,' ',profesional1.`Nombre2`)`NProfesional`\nFROM`h_atencion` \nINNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `g_usuario` ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\nINNER JOIN `g_persona`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `h_ordenes`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN  `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) \nINNER JOIN  `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN  `g_procedimiento`  ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN  g_persona `profesional1`  ON (`profesional1`.`Id` = `h_ordenes`.`Id_Profesional`) \nINNER JOIN `g_especialidad` ON (`g_especialidad`.`Id` = `h_ordenes`.`Id_Especialidad`)\n WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_tiposervicio`.`Id` ='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "') \n-- GROUP BY `profesional1`.`Id_Persona`, `g_procedimiento`.`Id` \nORDER BY g_especialidad.`Nbre` ASC, `NProfesional` ASC, `NProcedimiento` ASC";
            } else {
                this.xsql = "SELECT \n  g_persona.`Id_TipoIdentificacion`\n, g_persona.`NoDocumento`\n, g_persona.`Apellido1`\n, g_persona.`Apellido2`\n, g_persona.`Nombre1`\n, g_persona.`Nombre2`\n, g_persona.`Id_Sexo`, `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`\n, h_atencion.`Fecha_Atencion`) Edad\n, h_ordenes.`FechaOrden`,  `g_procedimiento`.`Id` \n,`g_procedimiento`.`Nbre` AS `NProcedimiento`\n, f_empresacontxconvenio.`Nbre` EmpresaConvenio\n, g_especialidad.`Nbre` `Especialidad`\n, CONCAT(profesional1.`Apellido1`,' ', profesional1.`Apellido2`,' ',profesional1.`Nombre1`,' ',profesional1.`Nombre2`)`NProfesional`\nFROM`h_atencion` \nINNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `g_usuario` ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\nINNER JOIN `g_persona`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `h_ordenes`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN  `h_itemordenesproced` ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) \nINNER JOIN  `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN  `g_procedimiento`  ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN  g_persona `profesional1`  ON (`profesional1`.`Id` = `h_ordenes`.`Id_Profesional`) \nINNER JOIN `g_especialidad` ON (`g_especialidad`.`Id` = `h_ordenes`.`Id_Especialidad`)\n WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'     AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n-- GROUP BY `profesional1`.`Id_Persona`, `g_procedimiento`.`Id` \nORDER BY g_especialidad.`Nbre` ASC, `NProfesional` ASC, `NProcedimiento` ASC";
            }
            System.out.println("Procedimiento Lab--->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBGenerico = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFTotal = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA DE INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFFConsultarInformacionGenerico.44
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultarInformacionGenerico.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFFConsultarInformacionGenerico.45
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultarInformacionGenerico.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setToolTipText("");
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Aplicar Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIFFConsultarInformacionGenerico.46
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInformacionGenerico.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico, -2, 715, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap(21, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(JPDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCBGenerico, -2, 50, -2)))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Sig.JIFFConsultarInformacionGenerico.47
            public void keyPressed(KeyEvent evt) {
                JIFFConsultarInformacionGenerico.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFFConsultarInformacionGenerico.48
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInformacionGenerico.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFFConsultarInformacionGenerico.49
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInformacionGenerico.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 512, -2).addGap(39, 39, 39).addComponent(this.JBTExportar, -2, 225, -2).addContainerGap(149, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -1, 53, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addGap(16, 16, 16)));
        this.JTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFTotal.setHorizontalAlignment(4);
        this.JTFTotal.setFont(new Font("Arial", 1, 14));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFTotal)).addComponent(this.JPDatos, -1, 1155, 32767).addComponent(this.JSPDetalle, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPDatos, 91, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -2, -1, -2).addComponent(this.JTFTotal)).addGap(10, 10, 10)));
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCBGenerico.setSelectedIndex(-1);
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && evt.getKeyCode() == 127) {
            this.xModelo.removeRow(this.JTDetalle.getSelectedRow());
            mTotalizarDatos();
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    private void mLlenarCombo() {
        this.xLleno = false;
        this.JCBGenerico.removeAllItems();
        System.out.println("" + this.xNombre);
        if (this.xNombre.equals("ConsultarPrograma")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT`g_tipoprograma`.`Id_TipoPrograma`, `g_tipoprograma`.`Nbre` AS `NPrograma`FROM`h_atencion`INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)INNER JOIN  `g_empresacont`    ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `g_empresa` ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)    INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)INNER JOIN  `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)    INNER JOIN  `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND `h_atencion`.`Codigo_Dxp` <>'')GROUP BY `g_tipoprograma`.`Id_TipoPrograma`ORDER BY `NPrograma` ASC", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("ConsultarEspecialidad")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT `profesional1`.`IdEspecialidad`,`profesional1`.`Especialidad`FROM`h_atencion`INNER JOIN   `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)    INNER JOIN   `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN   `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)    INNER JOIN   `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)INNER JOIN   `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)    INNER JOIN   `g_empresa` ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)INNER JOIN   `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresa`.`Id`)    INNER JOIN   `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)INNER JOIN   `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)    INNER JOIN   `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)INNER JOIN   `g_barrio` ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)    INNER JOIN   `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)    LEFT JOIN   `g_usuarioxprograma` ON (`g_usuarioxprograma`.`Id` = `h_atencion`.`IdUsuarioPrograma`) AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)    LEFT JOIN   `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN   `g_patologia` ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)    LEFT JOIN   `g_patologia` AS `g_patologia_1` ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)LEFT JOIN   `g_patologia` AS `g_patologia_2`        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)LEFT JOIN   `g_patologia` AS `g_patologia_3` ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND `h_atencion`.`Codigo_Dxp` <>'')    GROUP BY `profesional1`.`IdEspecialidad`ORDER BY `profesional1`.`Especialidad` ASC", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("CitasPorEmpresa")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre` FROM `g_persona` INNER JOIN  `c_citas` ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)INNER JOIN  `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1` ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`) INNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND c_citas.`Id_MotivoDesistida`=1) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC;", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("RiesgoObstetrico")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT persona.`IdEmpresaCont`, `persona`.`EPS`FROM`f_co_atencion`INNER JOIN  `persona` ON (`persona`.`Id_persona` = `f_co_atencion`.`Id_persona`)WHERE (f_co_atencion.`Fecha_atencion`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND f_co_atencion.`Fecha_atencion`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'AND f_co_atencion.`Estado`=1) GROUP BY persona.`IdEmpresaCont` ORDER BY  `persona`.`EPS` ASC;", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("DetalleEntradaPorBodega")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT     `i_bodegas`.`Id`     , `i_bodegas`.`Nbre`  FROM     `i_entradas`     INNER JOIN `i_bodegas`          ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)  WHERE (`i_entradas`.`FechaEntrada` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'     AND `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'     AND `i_bodegas`.`Estado` =0)  ORDER BY `i_bodegas`.`Nbre` ASC;", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("ConsolidadOrdenesMedico") || this.xNombre.equals("ConsolidOrdenConvenioProf") || this.xNombre.equals("ProcedimientosOrdenadosUsuario")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT `f_tiposervicio`.`Id`, `f_tiposervicio`.`Nbre` AS `TipoServicio`  FROM `h_ordenes` INNER JOIN  `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'      AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `f_tiposervicio`.`Id` ORDER BY `TipoServicio` ASC;", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("pacienteFacAtencionLab")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT `f_tiposervicio`.`Id`,`f_tiposervicio`.`Nbre` FROM  `f_tiposervicio` WHERE Estado=0", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("pacienteFacAtencionRad")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT `Id`,`Nbre`FROM `g_sedes` WHERE Estado=1", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (this.xNombre.equals("ConsultaInforLipidosCarbo")) {
            this.xIdGenerico = this.xct.llenarCombo("SELECT g_tipoprograma.`Id_TipoPrograma`, `g_tipoprograma`.`Nbre` FROM `h_atencion` \nINNER JOIN   `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nINNER JOIN   `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN   `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\nINNER JOIN   `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN   `g_usuarioxprograma` ON (`g_usuario`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)\nINNER JOIN   `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma` = `g_usuarioxprograma`.`Id_Programa`)            \nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \n    AND h_atencion.`Codigo_Dxp`<>'') GROUP BY  g_usuarioxprograma.`Id_Programa`;", this.xIdGenerico, this.JCBGenerico);
            this.JCBGenerico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else if (!this.xNombre.equals("ConsultarOrdenesProcedimiento")) {
            if (this.xNombre.equals("formuSubgruFarmacologico") || this.xNombre.equals("empresaConveFarmacologico")) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `i_atcsubgrupofarmacologico`.`Id`, `i_atcsubgrupofarmacologico`.`Nbre`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN  `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\nWHERE (`h_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_ordenes`.`Estado` =0\n   )\nGROUP BY `i_atcsubgrupofarmacologico`.`Id`\nORDER BY  `i_atcsubgrupofarmacologico`.`Nbre` ASC;", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("informeAutorizacion")) {
                this.xsql = "SELECT `cc_terceros`.Id,`cc_terceros`.`RazonSocialCompleta`\nFROM`f_a_autorizacion_servicios_detalle` \nINNER JOIN `f_a_autorizacion_servicios` ON (`f_a_autorizacion_servicios_detalle`.`Id_Autorizacion` = `f_a_autorizacion_servicios`.`Id`)\nINNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `f_a_autorizacion_servicios`.`Id_Tercero`)\nINNER JOIN `persona` ON (`persona`.`Id_persona` = `f_a_autorizacion_servicios`.`Id_Persona`)\nINNER JOIN `g_procedimiento` ON (`f_a_autorizacion_servicios_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (`f_a_autorizacion_servicios`.`FechaA`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `f_a_autorizacion_servicios`.`FechaA`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND\nf_a_autorizacion_servicios.`Estado` =1) GROUP BY `cc_terceros`.Id ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC;";
                System.out.println("" + this.xsql);
                this.xIdGenerico = this.xct.llenarCombo(this.xsql, this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("informeRes2463") || this.xNombre.equals("informeRes4725")) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT cc_terceros.`Id`,\ncc_terceros.RazonSocialCompleta\nFROM `g_ips`, `h_atencion`INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    LEFT JOIN `h_examenfisico` ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN cc_terceros ON (cc_terceros.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `g_tipoprograma` ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN `f_tiporegimen` ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n LEFT JOIN `g_usuarioxprograma` ON (`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`) \n AND (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)        \nWHERE (`c_clasecita`.`Id_Programa` IN(1,2) AND h_atencion.`Codigo_Dxp`<>'')\nGROUP BY cc_terceros.RazonSocialCompleta", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("consultaPrenatal")) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre` \nFROM baseserver.`g_ips`, \n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n     \n        \n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n          LEFT JOIN  `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `g_usuarioxprograma` ON (`g_usuarioxprograma`.`Id`= `h_atencion`.`IdUsuarioPrograma`)\n    \n    LEFT JOIN (SELECT d.Id_Usuario, h_antecedenteginecologico.`No_G`, h_antecedenteginecologico.`No_P`, h_antecedenteginecologico.`No_C`, h_antecedenteginecologico.`No_A`, h_antecedenteginecologico.`No_E`\n\nFROM `h_antecedenteginecologico` \nINNER JOIN (\nSELECT\n    MAX(`Id`) Id\n    , `Id_Usuario`\nFROM\n     `h_antecedenteginecologico`\nGROUP BY `Id_Usuario`) d ON (d.Id=h_antecedenteginecologico.`Id`)) ag ON (ag.Id_Usuario=`ingreso`.`Id_Usuario`)\n        -- Numero de controles\n        \n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  \n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='06')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n\n-- FECHA DEL PROXIMO CONTROL\n\nLEFT JOIN (SELECT\n    `c_citas`.`Fecha_Cita`\n    , `c_citas`.`Id_Usuario`\nFROM\n     `c_citas`\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` =06\n    AND `c_citas`.`Id_MotivoDesistida` =1) GROUP BY `c_citas`.`Id_Usuario`) fc ON (fc.Id_Usuario=`g_usuario`.`Id_persona`) AND (fc.Fecha_Cita>h_atencion.`Fecha_Atencion`)\n\n\n\n-- DATOS HEMOCLASIFICAICON\nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(202))\nGROUP BY `l_recepcion`.`Id_Paciente`)  HL ON(HL.Id_Paciente=`g_usuario`.`Id_persona`)    \n\n\n\n-- DATOS DE HEPATITIS B\nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(373))\nGROUP BY `l_recepcion`.`Id_Paciente`)  HPT ON(HPT.Id_Paciente=`g_usuario`.`Id_persona`)   \n\n-- DATOS TEST SULLIVAN\nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(200))\nGROUP BY `l_recepcion`.`Id_Paciente`)  TESS ON(TESS.Id_Paciente=`g_usuario`.`Id_persona`)  \n\n\n\n\n-- DATOS DE CITOLOGIA        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n     `l_recepcion_citologia`\n    INNER JOIN  `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    \n        \n        \n        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='06' \n    AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \nGROUP BY `f_empresacontxconvenio`.`Id`;", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("lecturaPorEmpresaYValor")) {
                String sql = "SELECT `profesional1`.`Id_Persona`\n    , `profesional1`.`NProfesional`\n FROM  `h_radiologia_detalle`\n    INNER JOIN  `h_radiologia` \n        ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`)\n    INNER JOIN  `h_radiologia_lectura_encabezado` \n        ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\n  WHERE (`h_radiologia_lectura_encabezado`.`FechaL` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`FechaL` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `h_radiologia_lectura_encabezado`.`Estado` =1\n    AND `f_ordenes`.`Estado` =0 )\nGROUP BY `profesional1`.`NProfesional` ORDER BY `profesional1`.`NProfesional` ASC;";
                this.xIdGenerico = this.xct.llenarCombo(sql, this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                System.out.println("sql-->" + sql);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("LASA")) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT Id, Nombre FROM `i_clasif_lasa` WHERE Estado=1", this.xIdGenerico, this.JCBGenerico);
                System.out.println("SQL LASA-->SELECT Id, Nombre FROM `i_clasif_lasa` WHERE Estado=1");
                this.JCBGenerico.setSelectedIndex(-1);
            } else if (this.xNombre.equals("Informes1.5")) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `Id`   , `Nbre` FROM   `i_categoria` WHERE (`Estado` =0);", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("consolidadoglosas")) {
                String sql2 = "SELECT\n   `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`\n    \nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_subgrupo_empresa` \n        ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n    LEFT JOIN  `f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) AND (f_factura_glosa_respuesta.`Estado`=1)\n    INNER JOIN  `f_subgruposervicio` \n        ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n    INNER JOIN  `f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\nWHERE (`f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_factura_evento`.`EstaArmada` =2\n    AND `f_factura_glosa`.`Estado` =1)\n    GROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC";
                this.xIdGenerico = this.xct.llenarCombo(sql2, this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            } else if (this.xNombre.equals("consolidadoglosasdefinitivo")) {
                String sql3 = "SELECT\n    `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta` AS `entidad`\nFROM\n    `baseserver`.`f_factura_evento`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\n    LEFT JOIN `baseserver`.`f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nWHERE ( `f_factura_glosa`.`FechaG` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `f_factura_glosa`.`FechaG` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_factura_glosa`.`Estado` =1)\nGROUP BY entidad\nORDEr BY entidad ASC;";
                this.xIdGenerico = this.xct.llenarCombo(sql3, this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
            }
        }
        System.out.println("si entra al informe Empresa por valor");
        this.xLleno = true;
    }

    private void mCreaModeloLASA() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Cod. Barra", "NombreMedicamento", "Clas. LASA", "Principio Activo", "Pres.Farmaceutica", "Pres.Comercial", "Vía Administración", "Concentración", "Clasificación", "Categoría", "Laboratorio", "ProduceSueño"}) { // from class: Sig.JIFFConsultarInformacionGenerico.50
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    private void mCargarDatosLASA() {
        mCreaModeloLASA();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT\n    `i_suministro`.`Id`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre` AS Suministro\n    , `i_clasif_lasa`.`Nombre` AS LASA\n    , `i_principioactivo`.`Nbre` AS PrincipioActivo\n    , `i_presentacionfarmaceutica`.`Nbre` AS PresFarmaceutica\n    , `i_presentacioncomercial`.`Nbre` AS PresComercial\n    , `i_viaadministracion`.`Nbre` AS ViaAdmin\n    , `i_concentracion`.`Nbre` AS Concentracion\n    , `i_clasificacion`.`Nbre` AS Clasificacion\n    , `i_categoria`.`Nbre` AS Categoria\n    , `i_laboratorio`.`Nbre` AS Laboratorio\n     ,  IF(i_suministro.`DLogo` IS NULL,'No',IF(i_suministro.`DLogo`='','No','Sí')) AS Suenio FROM\n     `i_suministro`\n    INNER JOIN  `i_clasif_lasa` \n        ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN  `i_viaadministracion` \n        ON (`i_suministro`.`IdViaAdministracion` = `i_viaadministracion`.`Id`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN  `i_clasificacion` \n        ON (`i_suministro`.`IdClasificacion` = `i_clasificacion`.`Id`)\n    INNER JOIN  `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN  `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n        \n WHERE (i_suministro.`Id_Cla_Lasa`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "')             ORDER BY  `i_suministro`.`Nbre` ASC;";
            } else {
                this.xsql = "SELECT\n    `i_suministro`.`Id`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre` AS Suministro\n    , `i_clasif_lasa`.`Nombre` AS LASA\n    , `i_principioactivo`.`Nbre` AS PrincipioActivo\n    , `i_presentacionfarmaceutica`.`Nbre` AS PresFarmaceutica\n    , `i_presentacioncomercial`.`Nbre` AS PresComercial\n    , `i_viaadministracion`.`Nbre` AS ViaAdmin\n    , `i_concentracion`.`Nbre` AS Concentracion\n    , `i_clasificacion`.`Nbre` AS Clasificacion\n    , `i_categoria`.`Nbre` AS Categoria\n    , `i_laboratorio`.`Nbre` AS Laboratorio\n     ,  IF(i_suministro.`DLogo` IS NULL,'No',IF(i_suministro.`DLogo`='','No','Sí')) AS Suenio FROM\n     `i_suministro`\n    INNER JOIN  `i_clasif_lasa` \n        ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN  `i_viaadministracion` \n        ON (`i_suministro`.`IdViaAdministracion` = `i_viaadministracion`.`Id`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN  `i_clasificacion` \n        ON (`i_suministro`.`IdClasificacion` = `i_clasificacion`.`Id`)\n    INNER JOIN  `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN  `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n        \n        ORDER BY  `i_suministro`.`Nbre` ASC;";
            }
            System.out.println("LASA--->   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultarInformacionGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mIprimir(String Idbodega) {
        String nbreArchivo;
        System.out.println("entre--->   ");
        if (this.JTDetalle.getRowCount() != 0) {
            System.out.println("entra tabla llena--->   ");
            if (this.JCHFiltro.isSelected()) {
                System.out.println("entre filtro--->   ");
                String[][] parametros = new String[5][3];
                parametros[0][0] = "ruta";
                parametros[0][1] = this.metodos.getRutaRep();
                parametros[1][0] = "IdBodega";
                parametros[1][1] = Idbodega;
                parametros[2][0] = "IdCategoria";
                parametros[2][1] = this.xIdGenerico[this.JCBGenerico.getSelectedIndex()];
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_ListadoGeneralDeProductosPorCategoriaFiltro", parametros);
                return;
            }
            System.out.println("entre sin filtro--->   ");
            String[][] parametros2 = new String[4][2];
            parametros2[0][0] = "ruta";
            parametros2[0][1] = this.metodos.getRutaRep();
            parametros2[1][0] = "IdBodega";
            parametros2[1][1] = Idbodega;
            parametros2[2][0] = "SUBREPORT_DIR";
            parametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros2[3][0] = "SUBREPORTFIRMA_DIR";
            parametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                nbreArchivo = "I_ListadoGeneralDeProductosPorCategoria";
            } else {
                nbreArchivo = "I_ListadoGeneralDeProductosPorCategoria_1";
            }
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo, parametros2);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cargar Datos Ha Imprimir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }
}
