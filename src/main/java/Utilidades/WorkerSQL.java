package Utilidades;

import Acceso.Principal;
import Armado.JIFArmado;
import Armado.JIFGestionCartera;
import Contabilidad.JIFBuscarDocumentosC;
import Contabilidad.JIFConsultar_BGeneral;
import Contabilidad.JIFConsultar_BalanceP;
import Contabilidad.JIFConsultar_BalanceP_Fecha;
import Contabilidad.JIFConsultar_LibroAuxiliar_Fecha;
import Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta;
import Contabilidad.JIFConsultar_LibroAuxiliar_Terceros;
import Contabilidad.JIFEstadosFinanc_Comparativos;
import Contabilidad.JIF_Consultar_Movimiento;
import Historia.JIFHistoriaClinica;
import Laboratorio.JIFExportacionDatos;
import Laboratorio.JIFImportacionHL7Infinity;
import Laboratorio.JIFPlanillaTrabajo;
import RecursosHumanos.JIF_Nomina_Causacion;
import Salud_Ocupacional.JDCargueManPower;
import Salud_Ocupacional.JIFGestion_ManPower;
import Salud_Ocupacional.JIFSegProcedimiento;
import Salud_Ocupacional.JIFSeguimiento_SVE;
import Sgc.JIFFicha5w1H;
import Sig.JIF_Informes_GResoluciones;
import com.genoma.plus.controller.comprabs.JIFContratoInformeCgr;
import com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento;
import com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote;
import com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat;
import com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal;
import com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera;
import com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030;
import com.genoma.plus.controller.laboratorio.JIF_ValidacionResultado_Interfaz;
import com.genoma.plus.controller.salud_ocupacional.JIFInformesSo;
import com.genoma.plus.controller.sgc.JIFImportacionDatosUsuarios;
import com.genoma.plus.controller.sig.JIFDiagnosticoSalud;
import com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion;
import com.genoma.plus.controller.sig.JIFInformeMorbilidadIra;
import com.genoma.plus.controller.sig.JIFInformesGenericoSO;
import com.genoma.plus.controller.sig.JIF_GeneracionRipsMinisterio;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/WorkerSQL.class */
public class WorkerSQL extends SwingWorker<Void, Void> {
    private String frmllamador;
    private JIFGestion_ManPower xJIFGestion_ManPower;
    private JDCargueManPower xJDCargueManPower;
    private JIFSegProcedimiento xJIFSegProcedimiento;
    private JIFSeguimiento_SVE xJIFSeguimiento_SVE;
    private JIF_Informes_GResoluciones xJIFInformeResoluciones;
    private JIFImportacionHL7Infinity xJIFImportacionHL7Infinity;
    private JIFInformesSo xJIFInformesSo;
    private JIFArmado xJIFArmado;
    private JIFBuscarDocumentosC buscarDocumentosC;
    private JIFInfoAtencionPrioritariaxClasificacion xJIFInfoAtencionPrioritariaxClasificacion;
    private JIFGestionCartera xJIFGestionCartera;
    private JIFGC_Pagos_Grupal xJIFGC_Pagos_Grupal;
    private JIFDiagnosticoSalud xJIFDiagnosticoSalud;
    private JIF_Nomina_Causacion xJIF_Nomina_Causacion;
    private JIFConsultarIngresoSoat xJIFConsultarIngresoSoat;
    private JIF_ConsolidadoCartera xJIFConsolidadoCartera;
    private JIFPlanillaTrabajo xJIFPlanillaTrabajo;
    private JIF_Consultar_Movimiento xJIF_Consultar_Movimiento;
    private JIFConsultar_LibroAuxiliar_RangoCuenta xJIF_FConsultar_LibroAuxiliar_RangoCuenta;
    private JIFConsultar_LibroAuxiliar_Fecha xJIFConsultar_LibroAuxiliar_Fecha;
    private JIFConsultar_LibroAuxiliar_Terceros xJIFConsultar_LibroAuxiliar_Terceros;
    private JIFConsultar_BGeneral xJIFConsultar_BGeneral;
    private JIFConsultar_BalanceP xJIFConsultar_BalanceP;
    private JIFEstadosFinanc_Comparativos xJIFEstadosFinan_Comparativos;
    private JIFConsultar_BalanceP_Fecha xJIFConsultar_BalanceP_Fecha;
    private JIFFicha5w1H xJIFFicha5w1H;
    private JIF_GeneracionCircular030 xJIF_GeneracionCircular030;
    private JIFExportacionDatos xJIFExportacionDatos;
    private JIFHistoriaClinica xJIFHistoriaClinica;
    private JIFContratoInformeCgr xJIFContratoInformeCgr;
    private JIFConsultarMovimiento xJIFConsultarMovimiento;
    private JIFInformeMorbilidadIra xJIFInformeMorbilidadIra;
    private JIFInformesGenericoSO xJIFInformesGenericoSO;
    private JIF_ValidacionResultado_Interfaz xjiValidacionResultado;
    private JIF_GeneracionRipsMinisterio generacionRipsMiniterio;
    private JIFDigitalizacionSopote xJIFDitigalizacionSoporte;
    private JIFImportacionDatosUsuarios jifImporteDatosUsuarios;
    private String nombre = "OK";
    private final String mensajeLoading = "";
    private JDialog xJDialog = new JDialog(this.xJDialog, true);
    private JDialog xJDialog = new JDialog(this.xJDialog, true);
    private final JLabel estado = new JLabel();

    public WorkerSQL(final String mensajeLoading, Object nbreFrm) {
        realizarcasting(nbreFrm);
        addPropertyChangeListener(new PropertyChangeListener() { // from class: Utilidades.WorkerSQL.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                if ("state".equals(evt.getPropertyName()) && WorkerSQL.this.getState() == SwingWorker.StateValue.STARTED) {
                    SwingUtilities.invokeLater(new Runnable() { // from class: Utilidades.WorkerSQL.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (WorkerSQL.this.getState() == SwingWorker.StateValue.STARTED) {
                                System.out.println("Entroooo");
                                WorkerSQL.this.estado.setText(mensajeLoading);
                                WorkerSQL.this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wait.gif")));
                                WorkerSQL.this.xJDialog.getContentPane().setLayout(new FlowLayout());
                                WorkerSQL.this.xJDialog.getContentPane().add(WorkerSQL.this.estado);
                                WorkerSQL.this.xJDialog.setBounds(400, 200, 300, 100);
                                WorkerSQL.this.xJDialog.setLocationRelativeTo((Component) null);
                                WorkerSQL.this.xJDialog.setDefaultCloseOperation(0);
                                WorkerSQL.this.xJDialog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
                                WorkerSQL.this.xJDialog.setTitle("TAREA EN CURSO, POR FAVOR ESPERE...");
                                WorkerSQL.this.xJDialog.setVisible(true);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: doInBackground, reason: merged with bridge method [inline-methods] */
    public Void m53doInBackground() throws Exception {
        if (this.frmllamador.equals("JIFGestion_ManPower")) {
            this.xJIFGestion_ManPower.mImportar();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso terminado");
        } else if (this.frmllamador.equals("JDCargueManPower")) {
            this.xJDCargueManPower.mValidar();
            if (this.xJDCargueManPower.JLErrores.getText().equals("0")) {
                this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                this.estado.setText("Validación correcta");
            } else {
                this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
                this.estado.setText("Validación incorrecta, verificar");
            }
        } else if (this.frmllamador.equals("JIFSegProcedimiento")) {
            this.xJIFSegProcedimiento.mImportar();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Importación correcta");
        } else if (this.frmllamador.equals("JIFSeguimiento_SVE")) {
            System.out.println("entra...JIFSeguimiento_SVE");
            this.xJIFSeguimiento_SVE.mCargarDatosTablaD();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("xjif_informes_resoluciones")) {
            this.xJIFInformeResoluciones.mBuscarInformacion();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFImportacionHL7Infinity")) {
            this.xJIFImportacionHL7Infinity.mLeerArchivos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFArmado")) {
            this.xJIFArmado.mCrearArchivos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFBuscarDocumentosC")) {
            this.buscarDocumentosC.crearPdf();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFDigitalizacionSopote")) {
            this.xJIFDitigalizacionSoporte.GenerarReportes();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFInformesSo")) {
            this.xJIFInformesSo.mBuscar_C();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFInfoAtencionPrioritariaxClasificacion")) {
            this.xJIFInfoAtencionPrioritariaxClasificacion.mCargarDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFGC_Pagos_Grupal")) {
            this.xJIFGC_Pagos_Grupal.mCargarTablaDetalle();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIFDiagnosticoSalud")) {
            this.xJIFDiagnosticoSalud.mCargarDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        } else if (this.frmllamador.equals("JIF_Nomina_Causacion")) {
            this.xJIF_Nomina_Causacion.mGrabarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIF_Nomina_Causacion_GMovPresupuestal")) {
            this.xJIF_Nomina_Causacion.mGrabarMPresupuesto();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIF_Nomina_Causacion_Actualizar")) {
            this.xJIF_Nomina_Causacion.mBtnActualizar();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultarIngresoSoat")) {
            this.xJIFConsultarIngresoSoat.mBuscaDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFGestionCarteraBuscar")) {
            this.xJIFGestionCartera.mCargarInformacion();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("xjifconsolidadoCartera")) {
            this.xJIFConsolidadoCartera.mBuscarD();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIF_Consultar_Movimiento")) {
            this.xJIF_Consultar_Movimiento.mCargarDatosTabla();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_LibroAuxiliar_RangoCuenta")) {
            this.xJIF_FConsultar_LibroAuxiliar_RangoCuenta.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_LibroAuxiliar_Fecha")) {
            this.xJIFConsultar_LibroAuxiliar_Fecha.mBuscarSeleccionTab();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_LibroAuxiliar_Terceros")) {
            this.xJIFConsultar_LibroAuxiliar_Terceros.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_BGeneral")) {
            this.xJIFConsultar_BGeneral.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_BalanceP")) {
            this.xJIFConsultar_BalanceP.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultar_BalanceP_Fecha")) {
            this.xJIFConsultar_BalanceP_Fecha.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFEstadosFinanc_Comparativos")) {
            this.xJIFEstadosFinan_Comparativos.mBuscarM();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFFicha5w1H")) {
            this.xJIFFicha5w1H.mVisualizarDoc();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIF_GeneracionCircular030")) {
            this.xJIF_GeneracionCircular030.mCargarConsolidado();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFExportacionDatos")) {
            this.xJIFExportacionDatos.mCastearMaquina();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFHistoriaClinica")) {
            this.xJIFHistoriaClinica.mCargarPanelConLoad();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFContratoInformeCgr")) {
            this.xJIFContratoInformeCgr.mCargarDatosTablaDetalle();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFConsultarMovimiento")) {
            this.xJIFConsultarMovimiento.mCargarDatosTabla();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFInformeMorbilidadIra")) {
            this.xJIFInformeMorbilidadIra.mBuscaDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIFInformesGenericoSO") || this.frmllamador.equals("JIFInformesGenericoSO1")) {
            this.xJIFInformesGenericoSO.mCastCargarDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("xJIfValidacionResultadoInterfaz")) {
            this.xjiValidacionResultado.mCargarDatos();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("JIF_GeneracionRipsMinisterio")) {
            this.generacionRipsMiniterio.mCargarConsolidado();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("jifImporteDatosUsuarios")) {
            this.jifImporteDatosUsuarios.Cargar();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        } else if (this.frmllamador.equals("jifImporteDatosUsuariosExcel")) {
            this.jifImporteDatosUsuarios.CrearTabla();
            this.estado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.estado.setText("Proceso de Cargado Finalizado");
        }
        try {
            Thread.sleep(1000L);
            return null;
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerSQL.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return null;
        }
    }

    protected void done() {
        this.estado.setIcon((Icon) null);
        this.estado.setText("Proceso Finalizado");
        this.xJDialog.dispose();
    }

    private void realizarcasting(Object frm) {
        System.out.println("frm.getClass().getName()->" + frm.getClass().getSimpleName());
        if (frm.getClass().getSimpleName().equals("JIFGestion_ManPower")) {
            this.xJIFGestion_ManPower = (JIFGestion_ManPower) frm;
            this.frmllamador = "JIFGestion_ManPower";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JDCargueManPower")) {
            this.xJDCargueManPower = (JDCargueManPower) frm;
            this.frmllamador = "JDCargueManPower";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFSegProcedimiento")) {
            this.xJIFSegProcedimiento = (JIFSegProcedimiento) frm;
            this.frmllamador = "JIFSegProcedimiento";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFSeguimiento_SVE")) {
            this.xJIFSeguimiento_SVE = (JIFSeguimiento_SVE) frm;
            this.frmllamador = "JIFSeguimiento_SVE";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_Informes_GResoluciones")) {
            this.xJIFInformeResoluciones = (JIF_Informes_GResoluciones) frm;
            this.frmllamador = "xjif_informes_resoluciones";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFImportacionHL7Infinity")) {
            this.xJIFImportacionHL7Infinity = (JIFImportacionHL7Infinity) frm;
            this.frmllamador = "JIFImportacionHL7Infinity";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFArmado")) {
            this.xJIFArmado = (JIFArmado) frm;
            this.frmllamador = "JIFArmado";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFBuscarDocumentosC")) {
            this.buscarDocumentosC = (JIFBuscarDocumentosC) frm;
            this.frmllamador = "JIFBuscarDocumentosC";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFDigitalizacionSopote")) {
            this.xJIFDitigalizacionSoporte = (JIFDigitalizacionSopote) frm;
            this.frmllamador = "JIFDigitalizacionSopote";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFInformesSo")) {
            this.xJIFInformesSo = (JIFInformesSo) frm;
            this.frmllamador = "JIFInformesSo";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFInfoAtencionPrioritariaxClasificacion")) {
            this.xJIFInfoAtencionPrioritariaxClasificacion = (JIFInfoAtencionPrioritariaxClasificacion) frm;
            this.frmllamador = "JIFInfoAtencionPrioritariaxClasificacion";
            return;
        }
        if (frm.toString().equals("JIFGestionCarteraBuscar")) {
            this.xJIFGestionCartera = (JIFGestionCartera) Principal.xclasegc.xjifgestioncartera;
            this.frmllamador = "JIFGestionCarteraBuscar";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFGestionCartera")) {
            this.xJIFGestionCartera = (JIFGestionCartera) frm;
            this.frmllamador = "JIFGestionCartera";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFGC_Pagos_Grupal")) {
            this.xJIFGC_Pagos_Grupal = (JIFGC_Pagos_Grupal) frm;
            this.frmllamador = "JIFGC_Pagos_Grupal";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFDiagnosticoSalud")) {
            this.xJIFDiagnosticoSalud = (JIFDiagnosticoSalud) frm;
            this.frmllamador = "JIFDiagnosticoSalud";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_Nomina_Causacion")) {
            this.xJIF_Nomina_Causacion = (JIF_Nomina_Causacion) frm;
            this.frmllamador = "JIF_Nomina_Causacion";
            return;
        }
        if (frm.toString().equals("JIF_Nomina_Causacion_GMovPresupuestal")) {
            this.xJIF_Nomina_Causacion = (JIF_Nomina_Causacion) Principal.claserecursoshumanos.xJif_CausacionNomina;
            this.frmllamador = "JIF_Nomina_Causacion_GMovPresupuestal";
            return;
        }
        if (frm.toString().equals("JIF_Nomina_Causacion_Actualizar")) {
            this.xJIF_Nomina_Causacion = (JIF_Nomina_Causacion) Principal.claserecursoshumanos.xJif_CausacionNomina;
            this.frmllamador = "JIF_Nomina_Causacion_Actualizar";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultarIngresoSoat")) {
            this.xJIFConsultarIngresoSoat = (JIFConsultarIngresoSoat) frm;
            this.frmllamador = "JIFConsultarIngresoSoat";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_ConsolidadoCartera")) {
            this.xJIFConsolidadoCartera = (JIF_ConsolidadoCartera) frm;
            this.frmllamador = "xjifconsolidadoCartera";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFPlanillaTrabajo")) {
            this.xJIFPlanillaTrabajo = (JIFPlanillaTrabajo) frm;
            this.frmllamador = "JIFPlanillaTrabajo";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_Consultar_Movimiento")) {
            this.xJIF_Consultar_Movimiento = (JIF_Consultar_Movimiento) frm;
            this.frmllamador = "JIF_Consultar_Movimiento";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_RangoCuenta")) {
            this.xJIF_FConsultar_LibroAuxiliar_RangoCuenta = (JIFConsultar_LibroAuxiliar_RangoCuenta) frm;
            this.frmllamador = "JIFConsultar_LibroAuxiliar_RangoCuenta";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Fecha")) {
            this.xJIFConsultar_LibroAuxiliar_Fecha = (JIFConsultar_LibroAuxiliar_Fecha) frm;
            this.frmllamador = "JIFConsultar_LibroAuxiliar_Fecha";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Terceros")) {
            this.xJIFConsultar_LibroAuxiliar_Terceros = (JIFConsultar_LibroAuxiliar_Terceros) frm;
            this.frmllamador = "JIFConsultar_LibroAuxiliar_Terceros";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_BGeneral")) {
            this.xJIFConsultar_BGeneral = (JIFConsultar_BGeneral) frm;
            this.frmllamador = "JIFConsultar_BGeneral";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_BalanceP")) {
            this.xJIFConsultar_BalanceP = (JIFConsultar_BalanceP) frm;
            this.frmllamador = "JIFConsultar_BalanceP";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFEstadosFinanc_Comparativos")) {
            this.xJIFEstadosFinan_Comparativos = (JIFEstadosFinanc_Comparativos) frm;
            this.frmllamador = "JIFEstadosFinanc_Comparativos";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultar_BalanceP_Fecha")) {
            this.xJIFConsultar_BalanceP_Fecha = (JIFConsultar_BalanceP_Fecha) frm;
            this.frmllamador = "JIFConsultar_BalanceP_Fecha";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFFicha5w1H")) {
            this.xJIFFicha5w1H = (JIFFicha5w1H) frm;
            this.frmllamador = "JIFFicha5w1H";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_GeneracionCircular030")) {
            this.xJIF_GeneracionCircular030 = (JIF_GeneracionCircular030) frm;
            this.frmllamador = "JIF_GeneracionCircular030";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFExportacionDatos")) {
            this.xJIFExportacionDatos = (JIFExportacionDatos) frm;
            this.frmllamador = "JIFExportacionDatos";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFHistoriaClinica")) {
            this.xJIFHistoriaClinica = (JIFHistoriaClinica) frm;
            this.frmllamador = "JIFHistoriaClinica";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFContratoInformeCgr")) {
            this.xJIFContratoInformeCgr = (JIFContratoInformeCgr) frm;
            this.frmllamador = "JIFContratoInformeCgr";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFConsultarMovimiento")) {
            this.xJIFConsultarMovimiento = (JIFConsultarMovimiento) frm;
            this.frmllamador = "JIFConsultarMovimiento";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFInformeMorbilidadIra")) {
            this.xJIFInformeMorbilidadIra = (JIFInformeMorbilidadIra) frm;
            this.frmllamador = "JIFInformeMorbilidadIra";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIFInformesGenericoSO")) {
            this.xJIFInformesGenericoSO = (JIFInformesGenericoSO) frm;
            this.frmllamador = "JIFInformesGenericoSO";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_ValidacionResultado_Interfaz")) {
            this.xjiValidacionResultado = (JIF_ValidacionResultado_Interfaz) frm;
            this.frmllamador = "xJIfValidacionResultadoInterfaz";
            return;
        }
        if (frm.getClass().getSimpleName().equals("JIF_GeneracionRipsMinisterio")) {
            this.generacionRipsMiniterio = (JIF_GeneracionRipsMinisterio) frm;
            this.frmllamador = "JIF_GeneracionRipsMinisterio";
        } else if (frm.getClass().getSimpleName().equals("JIFImportacionDatosUsuarios")) {
            this.jifImporteDatosUsuarios = (JIFImportacionDatosUsuarios) frm;
            this.frmllamador = "jifImporteDatosUsuarios";
        } else if (frm.toString().equals("jifImporteDatosUsuariosExcel")) {
            this.jifImporteDatosUsuarios = (JIFImportacionDatosUsuarios) Principal.clasegeneral.importarDatosUsuario;
            this.frmllamador = "jifImporteDatosUsuariosExcel";
        }
    }
}
