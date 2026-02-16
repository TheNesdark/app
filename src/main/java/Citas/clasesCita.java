package Citas;

import Acceso.Principal;
import Cirugia.JIF_Programacion_Cx;
import Contabilidad.JIFRegistroSReembolso;
import Enfermeria.Agenda;
import Facturacion.JIFInformacion_Empresa;
import General.BuscarPersona;
import GestionDoc.JIFSolicitudDocumentosHC;
import Historia.JIFCierreFT;
import Historia.JIFConsultarAtenciones;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFHistoriaFT;
import Historia.JIFRegistroAtencionesEsp;
import Historia.JIFRetroFt;
import Historia.JIFSeguimientoFT;
import Historia.JIFSeguimientoOrdenesLab;
import Mantenimiento.JIFReporte;
import ParametrizacionN.JIFGAlertaxUsuario;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas;
import com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Citas/clasesCita.class */
public class clasesCita {
    private String sql;
    public Principal frmPrincipal;
    public CitasGral frmCita;
    public CitaNP frmCitaNP;
    private BuscarPersona frmBuscarP;
    public Programar_Citas frmProgramar;
    private PasarTurnos frmPasarTurno;
    public JIFHistoriaFT xjifhistoriaft;
    private JIFSeguimientoFT xjifseguimientoft;
    private JIFRetroFt xretro;
    private JIFCierreFT xjifcierreft;
    public JIFReporte xjifreporte;
    private JIFPasarProgramacion xjifpasarprogramacion;
    private JIFEliminarProgramacionCitas xjifanularprogramacion;
    private Agenda xjifagenda;
    private JIFConsultarCitas xjifconsultarcitas;
    JIFConsultarAtenciones xjifconsultaratenciones;
    private JIFRegistroSReembolso xjifsolicitudreembolso;
    private JIFSeguimientoOrdenesLab xjifseguimientollab;
    private JIFOrganizarFechaAsignacion xjiforganizarfechaasignacion;
    private JIFSolicitudDocumentosHC xjifsolicituddoc;
    private JIFGAlertaxUsuario xjifJIFGAlertaxUsuario;
    private JIFInformacion_Empresa xjifconsultar_infempresa;
    private JIFRegistroAtencionesEsp xjifatencionesp;
    private JIFConsultarExamenesxUsuario xjiconsultarexusuario;
    private JIFConsultarCitasAtendidas xJIFConsultarCitasAtendidas;
    private JIF_Programacion_Cx xjif_progracion_cx;
    private JIFConsultarCitaNoAtendidas xJIFConsultarCitaNoAtendidas;
    private JIF_Reportes_PyP_Generico jifreportes;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public CitaTerapia frmCitaTerapia = null;
    private long xTipoTerapia = 0;
    private long xIdIngreso = 0;
    private long xIdAtencion = 0;
    private long xidcita = 0;
    private long xid_manpower = 0;
    private String xNHistoria = null;
    private String xsql = "";

    public clasesCita(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public clasesCita(Principal frmP, String xe) {
        this.frmPrincipal = frmP;
    }

    public void buscar(String frm) {
        if (frm.equals("Citas")) {
            this.frmBuscarP = new BuscarPersona(null, true, this.frmCita.frmPersona);
            this.frmBuscarP.setVisible(true);
            return;
        }
        if (frm.equals("CitaNP")) {
            this.frmBuscarP = new BuscarPersona(null, true, this.frmCitaNP.frmPersona1);
            this.frmBuscarP.setVisible(true);
            return;
        }
        if (frm.equals("jifconsultarcitas")) {
            this.xjifconsultarcitas.mBuscar();
            return;
        }
        if (frm.equals("jifregistroreembolso1")) {
            this.xjifsolicitudreembolso.mBuscar();
            return;
        }
        if (frm.equals("jifseguimientolab1")) {
            this.xjifseguimientollab.mBuscar();
            return;
        }
        if (frm.equals("xjifreorganizardiaasignacioncitas")) {
            this.xjiforganizarfechaasignacion.mBuscar();
            return;
        }
        if (frm.equals("xjifsolicituddochc1")) {
            this.xjifsolicituddoc.mBuscar();
            return;
        }
        if (frm.equals("xjifconsulta_informacion_2")) {
            this.xjifconsultar_infempresa.mBuscar();
            return;
        }
        if (frm.equals("jifconsultarRemOrd")) {
            this.xjiconsultarexusuario.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarcitasprofesional")) {
            this.xJIFConsultarCitasAtendidas.mBuscar();
            return;
        }
        if (frm.equals("Programación Cirugia")) {
            this.xjif_progracion_cx.mBuscar();
            return;
        }
        if (frm.equals("jifregistroatencionesp2")) {
            this.xjifatencionesp.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarcitasnoatendidas")) {
            this.xJIFConsultarCitaNoAtendidas.mBuscar();
        } else if (frm.equals("CitaTerapia")) {
            this.frmBuscarP = new BuscarPersona(null, true, this.frmCitaTerapia.frmPersona);
            this.frmBuscarP.setVisible(true);
        }
    }

    public void cargarPantalla(String frm, Principal frmP) {
        this.frmPrincipal = frmP;
        if (frm.equals("CitasTerapia")) {
            if (this.frmCitaTerapia != null) {
                this.frmCitaTerapia.dispose();
            }
            this.frmCitaTerapia = new CitaTerapia(this);
            Principal.cargarPantalla(this.frmCitaTerapia);
            this.frmCitaTerapia.moveToFront();
        }
    }

    public void cargarPantalla(Principal frmP, String frm) {
        this.frmPrincipal = frmP;
        if (frm.equals("Citas")) {
            if (this.frmCita != null) {
                this.frmCita.dispose();
            }
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                this.frmCita = new CitasGral(7, this, this.frmPrincipal);
                Principal.cargarPantalla(this.frmCita);
                this.frmCita.moveToFront();
                return;
            } else {
                this.frmCita = new CitasGral(this, this.frmPrincipal);
                Principal.cargarPantalla(this.frmCita);
                this.frmCita.moveToFront();
                return;
            }
        }
        if (frm.equals("Consultar Tiempo Atención")) {
            this.xjifconsultar_infempresa = new JIFInformacion_Empresa("xjifconsulta_informacion_2", frm.toUpperCase());
            Principal.cargarPantalla(this.xjifconsultar_infempresa);
            return;
        }
        if (frm.equals("Solicitud de Documentos Clínicos")) {
            this.xjifsolicituddoc = new JIFSolicitudDocumentosHC("xjifsolicituddochc1");
            Principal.cargarPantalla(this.xjifsolicituddoc);
            return;
        }
        if (frm.equals("Atención Especial")) {
            if (this.xjifatencionesp != null) {
                this.xjifatencionesp.dispose();
            }
            this.xjifatencionesp = new JIFRegistroAtencionesEsp("jifregistroatencionesp2");
            Principal.cargarPantalla(this.xjifatencionesp);
            this.xjifatencionesp.moveToFront();
            return;
        }
        if (frm.equals("CitasNP")) {
            if (this.frmCitaNP != null) {
                this.frmCitaNP.dispose();
            }
            this.frmCitaNP = new CitaNP(this);
            Principal.cargarPantalla(this.frmCitaNP);
            this.frmCitaNP.moveToFront();
            return;
        }
        if (frm.equals("CitasTerapia")) {
            if (this.frmCitaTerapia != null) {
                this.frmCitaTerapia.dispose();
            }
            this.frmCitaTerapia = new CitaTerapia(this);
            Principal.cargarPantalla(this.frmCitaTerapia);
            this.frmCitaTerapia.moveToFront();
            return;
        }
        if (frm.equals("Programar")) {
            if (this.frmProgramar != null) {
                this.frmProgramar.dispose();
            }
            this.frmProgramar = new Programar_Citas(this);
            Principal.cargarPantalla(this.frmProgramar);
            this.frmProgramar.moveToFront();
            return;
        }
        if (frm.equals("PasarTurnos")) {
            if (this.frmPasarTurno != null) {
                this.frmPasarTurno.dispose();
            }
            this.frmPasarTurno = new PasarTurnos();
            Principal.cargarPantalla(this.frmPasarTurno);
            this.frmPasarTurno.moveToFront();
            return;
        }
        if (frm.equals("Historia FT")) {
            this.xjifhistoriaft = new JIFHistoriaFT();
            Principal.cargarPantalla(this.xjifhistoriaft);
            return;
        }
        if (frm.equals("jifseguimientoft")) {
            this.xjifseguimientoft = new JIFSeguimientoFT();
            Principal.cargarPantalla(this.xjifseguimientoft);
            return;
        }
        if (frm.equals("jifcierreft")) {
            this.xjifcierreft = new JIFCierreFT(this.xjifhistoriaft);
            Principal.cargarPantalla(this.xjifcierreft);
            return;
        }
        if (frm.equals("jifretroalimentacion")) {
            this.xretro = new JIFRetroFt(this.xjifhistoriaft);
            Principal.cargarPantalla(this.xretro);
            return;
        }
        if (frm.equals("Reporte")) {
            if (this.xjifreporte != null) {
                this.xjifreporte.dispose();
            }
            this.xjifreporte = new JIFReporte("jifreporte2");
            Principal.cargarPantalla(this.xjifreporte);
            this.xjifreporte.moveToFront();
            return;
        }
        if (frm.equals("Pasar Citas por Lote")) {
            if (this.xjifpasarprogramacion != null) {
                this.xjifpasarprogramacion.dispose();
            }
            this.xjifpasarprogramacion = new JIFPasarProgramacion();
            Principal.cargarPantalla(this.xjifpasarprogramacion);
            this.xjifpasarprogramacion.moveToFront();
            return;
        }
        if (frm.equals("Anular Programación")) {
            if (this.xjifanularprogramacion != null) {
                this.xjifanularprogramacion.dispose();
            }
            this.xjifanularprogramacion = new JIFEliminarProgramacionCitas();
            Principal.cargarPantalla(this.xjifanularprogramacion);
            this.xjifanularprogramacion.moveToFront();
            return;
        }
        if (frm.equals("Consultar Agenda Enfermería")) {
            if (this.xjifagenda != null) {
                this.xjifagenda.dispose();
            }
            this.xjifagenda = new Agenda();
            Principal.cargarPantalla(this.xjifagenda);
            this.xjifagenda.moveToFront();
            return;
        }
        if (frm.equals("Consultar Citas por Usuario")) {
            if (this.xjifconsultarcitas != null) {
                this.xjifconsultarcitas.dispose();
            }
            this.xjifconsultarcitas = new JIFConsultarCitas();
            Principal.cargarPantalla(this.xjifconsultarcitas);
            this.xjifconsultarcitas.moveToFront();
            return;
        }
        if (frm.equals("Consultar Atenciones")) {
            if (this.xjifconsultaratenciones != null) {
                this.xjifconsultaratenciones.dispose();
            }
            this.xjifconsultaratenciones = new JIFConsultarAtenciones(this, 1);
            Principal.cargarPantalla(this.xjifconsultaratenciones);
            this.xjifconsultaratenciones.moveToFront();
            return;
        }
        if (frm.equals("Registro de Reembolso")) {
            if (this.xjifsolicitudreembolso != null) {
                this.xjifsolicitudreembolso.dispose();
            }
            this.xjifsolicitudreembolso = new JIFRegistroSReembolso("jifregistroreembolso1");
            Principal.cargarPantalla(this.xjifsolicitudreembolso);
            this.xjifsolicitudreembolso.moveToFront();
            return;
        }
        if (frm.equals("Registro de Exámenes Alterados")) {
            if (this.xjifseguimientollab != null) {
                this.xjifseguimientollab.dispose();
            }
            this.xjifseguimientollab = new JIFSeguimientoOrdenesLab("jifseguimientolab1");
            Principal.cargarPantalla(this.xjifseguimientollab);
            this.xjifseguimientollab.moveToFront();
            return;
        }
        if (frm.equals("Reorganizar Dias de Asignacion")) {
            if (this.xjiforganizarfechaasignacion != null) {
                this.xjiforganizarfechaasignacion.dispose();
            }
            this.xjiforganizarfechaasignacion = new JIFOrganizarFechaAsignacion();
            Principal.cargarPantalla(this.xjiforganizarfechaasignacion);
            this.xjiforganizarfechaasignacion.moveToFront();
            return;
        }
        if (frm.equals("Alerta por Usuario")) {
            if (this.xjifJIFGAlertaxUsuario != null) {
                this.xjifJIFGAlertaxUsuario.dispose();
            }
            this.xjifJIFGAlertaxUsuario = new JIFGAlertaxUsuario("jifalertaxusuario");
            Principal.cargarPantalla(this.xjifJIFGAlertaxUsuario);
            this.xjifJIFGAlertaxUsuario.moveToFront();
            return;
        }
        if (frm.equals("Consultar Remisiones y Ordenes")) {
            this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarRemOrd");
            Principal.cargarPantalla(this.xjiconsultarexusuario);
            return;
        }
        if (frm.equals("Citas Atendidas Por Profesional")) {
            this.xJIFConsultarCitasAtendidas = new JIFConsultarCitasAtendidas();
            Principal.cargarPantalla(this.xJIFConsultarCitasAtendidas);
            return;
        }
        if (frm.equals("Programación Cirugia")) {
            this.xjif_progracion_cx = new JIF_Programacion_Cx("Programación Cirugia", frm);
            Principal.cargarPantalla(this.xjif_progracion_cx);
        } else if (frm.equals("Citas No Atendidas")) {
            this.xJIFConsultarCitaNoAtendidas = new JIFConsultarCitaNoAtendidas();
            Principal.cargarPantalla(this.xJIFConsultarCitaNoAtendidas);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(7, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void desistirCita(String detalle, String motivo, String idProfesional) {
        this.sql = "UPDATE c_citas SET  Id_MotivoDesistida ='" + motivo + "' WHERE (Id='" + Principal.txtNo.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "INSERT INTO c_desistidas (Id, Detalle, Fecha, UsuarioS) VALUES('" + Principal.txtNo.getText() + "','" + detalle + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE g_ips SET g_ips.NoCita = '" + Principal.txtNo.getText() + "', IdProfesionalUltimaCita ='" + idProfesional + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE so_manporwer_detalle SET Id_Cita = '" + Principal.txtNo.getText() + "', FProgramacion =NULL where Id_Cita='" + Principal.txtNo.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        if (Principal.clasescita.frmCita != null) {
            Principal.clasescita.frmCita.cargarHorarioGrid();
        }
        if (Principal.clasescita.frmCitaTerapia != null) {
            Principal.clasescita.frmCitaTerapia.cargarHorarioGrid();
        }
        Principal.txtNo.setText("");
        this.metodos.mostrarMensaje("Cita Desistida");
    }

    public int getCita1erVez(String idEspecial, String idPersona) {
        int ano = Integer.parseInt(this.metodos.formatoAMD.format(this.metodos.getFechaActual()).substring(0, 4));
        this.sql = "SELECT Id_Especialidad FROM baseserver.c_citas WHERE (Id_Especialidad ='" + idEspecial + "' AND Id_Usuario ='" + idPersona + "' AND YEAR(Fecha_Cita) ='" + ano + "' AND Id_MotivoDesistida =1)";
        String retorno = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (retorno != null || !retorno.equals("")) {
            retorno = "1";
        }
        return Integer.parseInt(retorno);
    }

    public void mIniciarD() {
        this.frmPrincipal.mIniciarDatosFacturacion();
    }

    public void grabar(String frm) {
        if (frm.equals("Citas")) {
            this.frmCita.mAsignarCitas();
            return;
        }
        if (frm.equals("CitaNP")) {
            this.frmCitaNP.asignarCita();
            return;
        }
        if (frm.equals("Programar")) {
            this.frmProgramar.grabar();
            return;
        }
        if (frm.equals("PasarTurnos")) {
            this.frmPasarTurno.grabar();
            return;
        }
        if (frm.equals("jifhistoriaft")) {
            this.xjifhistoriaft.grabar();
            return;
        }
        if (frm.equals("jifseguimientoft")) {
            this.xjifseguimientoft.grabar();
            return;
        }
        if (frm.equals("jifcierreft")) {
            this.xjifcierreft.grabar();
            return;
        }
        if (frm.equals("jifreporte2")) {
            this.xjifreporte.grabar();
            return;
        }
        if (frm.equals("jifcitasxlote")) {
            this.xjifpasarprogramacion.mGrabar();
            return;
        }
        if (frm.equals("jifregistroreembolso1")) {
            this.xjifsolicitudreembolso.mGrabar();
            return;
        }
        if (frm.equals("jifseguimientolab1")) {
            this.xjifseguimientollab.mGrabar();
            return;
        }
        if (frm.equals("xjifsolicituddochc1")) {
            this.xjifsolicituddoc.mGrabar();
            return;
        }
        if (frm.equals("jifalertaxusuario")) {
            this.xjifJIFGAlertaxUsuario.mGrabar();
            return;
        }
        if (frm.equals("jifregistroatencionesp2")) {
            this.xjifatencionesp.mGrabar();
        } else if (frm.equals("Programación Cirugia")) {
            try {
                this.xjif_progracion_cx.mGrabar();
            } catch (ParseException ex) {
                Logger.getLogger(clasesCita.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifeliminarprogramacioncitas":
                this.xjifanularprogramacion.mAnular();
                break;
            case "jifregistroreembolso1":
                this.xjifsolicitudreembolso.mAnular();
                break;
            case "xjifsolicituddochc1":
                this.xjifsolicituddoc.mAnular();
                break;
            case "Programación Cirugia":
                this.xjif_progracion_cx.mAnular();
                break;
        }
    }

    public void imprimirCita(String xtipo, String xnombre, JInternalFrame xjif) {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "numero";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            if (xtipo.equals("0")) {
                Object[] botones1 = {"Tirilla", "Media Carta", "Cerrar"};
                int x = JOptionPane.showInternalOptionDialog(xjif, "Que desea hacer?", "VISUALIZACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
                if (x == 0) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recordatorio_Tirilla", parametros);
                    return;
                } else {
                    if (x == 1) {
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita", parametros);
                        return;
                    }
                    return;
                }
            }
            if (xnombre.equals("EXAMEN DE INGRESO") || xnombre.equals("EXAMEN DE EGRESO") || xnombre.equals("EXAMEN PERIODICO")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita_So", parametros);
                return;
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recordatorio_Tirilla", parametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita_Radiologos_Asociados", parametros);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recordatorio_Tirilla", parametros);
            return;
        }
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            Object[] botones12 = {"Tirilla", "Media Carta", "Cerrar"};
            int x2 = JOptionPane.showInternalOptionDialog(xjif, "Que desea hacer?", "VISUALIZACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones12, "Cerrar");
            if (x2 == 0) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recordatorio_Tirilla", parametros);
                return;
            } else {
                if (x2 == 1) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "C_RecordatorioDeCita1", parametros);
                    return;
                }
                return;
            }
        }
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "C_RecordatorioDeCita1", parametros);
    }

    public void imprimirRecordatorioCita(String idCita) {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "numero";
        parametros[0][1] = idCita;
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recordatorio_Tirilla", parametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "C_RecordatorioDeCita1", parametros);
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "Citas":
                this.frmCita.nuevo();
                break;
            case "xjifreorganizardiaasignacioncitas":
                this.xjiforganizarfechaasignacion.mNuevo();
                break;
            case "CitaNP":
                this.frmCitaNP.nuevo();
                break;
            case "xjifconsulta_informacion_2":
                this.xjifconsultar_infempresa.mNuevo();
                break;
            case "CitaTerapia":
                this.frmCitaTerapia.nuevo();
                break;
            case "Programar":
                this.frmProgramar.nuevo();
                break;
            case "PasarTurnos":
                this.frmPasarTurno.nuevo();
                break;
            case "jifhistoriaft":
                this.xjifhistoriaft.nuevo();
                break;
            case "jifseguimientoft":
                this.xjifseguimientoft.nuevo();
                break;
            case "jifreporte2":
                this.xjifreporte.nuevo();
                break;
            case "jifcitasxlote":
                this.xjifpasarprogramacion.mNuevo();
                break;
            case "jifconsultarcitas":
                this.xjifconsultarcitas.mNuevo();
                break;
            case "jifregistroreembolso1":
                this.xjifsolicitudreembolso.mNuevo();
                break;
            case "xjifsolicituddochc1":
                this.xjifsolicituddoc.mNuevo();
                break;
            case "jifregistroatencionesp2":
                this.xjifatencionesp.mNuevo();
                break;
            case "jifalertaxusuario":
                this.xjifJIFGAlertaxUsuario.mNuevo();
                break;
            case "jifconsultarRemOrd":
                this.xjiconsultarexusuario.mNuevo();
                break;
            case "xjifconsultarcitasprofesional":
                this.xJIFConsultarCitasAtendidas.mNuevo();
                break;
            case "Programación Cirugia":
                this.xjif_progracion_cx.mNuevo();
                break;
            case "xjifconsultarcitasnoatendidas":
                this.xJIFConsultarCitaNoAtendidas.mNuevo();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "jifregistroreembolso1":
                this.xjifsolicitudreembolso.mImprimir();
                break;
            case "jifhistoriaft":
                this.xjifhistoriaft.mImprimir();
                break;
            case "xjifsolicituddochc1":
                this.xjifsolicituddoc.mImprimir();
                break;
            case "xjifconsultarcitasprofesional":
                this.xJIFConsultarCitasAtendidas.mImprimir();
                break;
            case "xjifconsultarcitasnoatendidas":
                this.xJIFConsultarCitaNoAtendidas.mImprimir();
                break;
            case "CitaNP":
                this.frmCitaNP.mImprimir();
                break;
        }
    }

    public long getxTipoTerapia() {
        return this.xTipoTerapia;
    }

    public void setxTipoTerapia(long xTipoTerapia) {
        this.xTipoTerapia = xTipoTerapia;
    }

    public long getxIdIngreso() {
        return this.xIdIngreso;
    }

    public void setxIdIngreso(long xIdIngreso) {
        this.xIdIngreso = xIdIngreso;
    }

    public String getxNHistoria() {
        return this.xNHistoria;
    }

    public void setxNHistoria(String xNHistoria) {
        this.xNHistoria = xNHistoria;
    }

    public long getxIdAtencion() {
        return this.xIdAtencion;
    }

    public void setxIdAtencion(long xIdAtencion) {
        this.xIdAtencion = xIdAtencion;
    }

    public long getXidcita() {
        return this.xidcita;
    }

    public void setXidcita(long xidcita) {
        this.xidcita = xidcita;
    }

    public long getXid_manpower() {
        return this.xid_manpower;
    }

    public void setXid_manpower(long xid_manpower) {
        this.xid_manpower = xid_manpower;
    }

    public void mActualizarFechaCita_Periodico(String xid, String xfecha) {
        this.xsql = "UPDATE so_manporwer_detalle SET Id_Cita='" + xid + "', FProgramacion='" + xfecha + "' where Id='" + this.xid_manpower + "'";
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
    }

    public Boolean verificarAtencionDx(Long idIngreso) {
        boolean xexiste = false;
        this.sql = "SELECT\n    `h_atencion`.`Codigo_Dxp`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`Id` =" + idIngreso + "\n    AND `h_atencion`.`Estado` =0);";
        ResultSet xrs = this.consultas.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (!xrs.getString("Codigo_Dxp").isEmpty()) {
                    xexiste = false;
                } else {
                    xexiste = true;
                }
            } else {
                xexiste = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(xexiste);
    }
}
