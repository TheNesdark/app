package General;

import Acceso.Principal;
import Facturacion.Furcen;
import Facturacion.Furips_PA_V2023;
import Facturacion.Furips_PB_V2023;
import Facturacion.Furtran;
import Historia.ImpresionDocumentosHC;
import Historia.JPASaludOcupacional;
import Historia.JPGestionHC;
import Historia.JPI_Control_Impresion;
import Historia.ReporteAnexo3;
import Historia.ReporteAnexo3_Interconsulta;
import Historia.ReporteRemision;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.genoma.plus.controller.laboratorio.ImpresionReporteCitologiaBethesda;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dto.historia.RegistroLlamadasDTO;
import com.genoma.plus.dto.historia.SeguimientoPosparto;
import com.genoma.plus.dto.soporte_digitalizado.ImpresionReportesDTO;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.projection.HSeguimientoPospartoProjection;
import com.genoma.plus.jpa.projection.IGLlamadasProjection;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/ClaseImpresionInformes.class */
public class ClaseImpresionInformes {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultasMySQL = new ConsultasMySQL();
    private ImpresionDocumentosHC xImpresionDc = new ImpresionDocumentosHC();
    private JPanel panel = new JPanel();
    private static final String NOMBRE_SUBREPORTFIRMA_DIR = "SUBREPORTFIRMA_DIR";
    private static final String NOMBRE_SUBREPORT_DIR = "SUBREPORT_DIR";
    private static String SUBREPORT_DIR;
    private static String SUBREPORTFIRMA_DIR;

    public ClaseImpresionInformes() {
        SUBREPORT_DIR = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        SUBREPORTFIRMA_DIR = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
    }

    public void mImprimirLecturaRadiologia(String xIdRadadiologia) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = String.valueOf(xIdRadadiologia);
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = SUBREPORT_DIR;
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = SUBREPORTFIRMA_DIR;
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Radiologia_Informe_Lectura_RadiologosAs", mparametros);
    }

    public void imprimirHistoriaProcesoEnfemero(String idAtencion) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = idAtencion;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = SUBREPORT_DIR;
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = SUBREPORTFIRMA_DIR;
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Enfermeria_Atencion", mparametros);
    }

    public void imprmirAdicionesReintegroIndividual(String idMovimientoAdicionReintegro, String valor) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idDocumento";
        mparametros[0][1] = idMovimientoAdicionReintegro;
        mparametros[1][0] = "numeroLetra1";
        mparametros[1][1] = this.metodos.mConvertirNumeroLetras(valor);
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = SUBREPORT_DIR;
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = SUBREPORTFIRMA_DIR;
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_AdicionReintegros_Disponibilidad_Individual", mparametros);
    }

    public void mImprimirConceptoOcupacional(String idConcepto) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = idConcepto;
        mparametros[1][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
                return;
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_Mineros", mparametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_Firmado", mparametros);
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concepto_Aptitud_Firmado_1", mparametros);
        }
    }

    public void mImprimirTriage(String idAtencion, String idTriage) {
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion;
            mparametros[1][0] = "nusuarios";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[4][0] = "nbreUsuario";
            mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Clasificacion_Triage_IdAtencion_San_Jorge", mparametros);
                return;
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_Clasificacion_Triage_IdAtencion", mparametros);
                return;
            }
        }
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idt";
        parametros[0][1] = idTriage;
        parametros[1][0] = "ruta";
        parametros[1][1] = this.metodos.getRutaRep();
        parametros[2][0] = NOMBRE_SUBREPORT_DIR;
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RTriage", parametros);
    }

    public void imprimirTestRespiratorio(String idIngreso) {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idingreso";
        parametros[0][1] = idIngreso;
        parametros[1][0] = "ruta";
        parametros[1][1] = this.metodos.getRutaRep();
        parametros[2][0] = NOMBRE_SUBREPORT_DIR;
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2", parametros);
        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2_V2", parametros);
        }
    }

    public void imprimirSolicitudAlimentacion(String idSolicitud) {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[5][2];
        parametros[0][0] = "idSolicitud";
        parametros[0][1] = idSolicitud;
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = NOMBRE_SUBREPORT_DIR;
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        parametros[4][0] = "nbreUsuario";
        parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        metodos.GenerarPDF(metodos.getRutaRep() + "Pajonal_H_Solicitud_Alimentacion", parametros);
    }

    public void visualizarFacturasEvento(Long idFactura, String numeroFactura) {
        String ruta;
        try {
            String sql = "SELECT `pdf` FROM `f_factura_evento` WHERE( `f_factura_evento`.`No_FacturaEvento` =  " + idFactura + " )";
            if (this.metodos.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(this.metodos.getBarra()).concat(numeroFactura).concat(".pdf"))) {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(this.metodos.getBarra()).concat(numeroFactura).concat(".pdf");
            } else if (this.metodos.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(this.metodos.getBarra()).concat(numeroFactura).concat("_facturaPdf.pdf"))) {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(this.metodos.getBarra()).concat(numeroFactura).concat("_facturaPdf.pdf");
            } else {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat("_facturaPdf.pdf");
            }
            this.metodos.recuperarBlob(sql, 0, "FacturaNo" + numeroFactura, 0, ruta);
        } catch (Exception e) {
        }
    }

    public void visualizarNota(String numeroFactura) {
        String ruta;
        try {
            if (this.metodos.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(".pdf"))) {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(".pdf");
            } else {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura).concat(this.metodos.getBarra()).concat(numeroFactura).concat(".pdf");
            }
            this.metodos.recuperarBlob("", 0, "NotaNo" + numeroFactura, 0, ruta);
        } catch (Exception e) {
        }
    }

    public String consultarAdjuntosDian(String idIngreso) {
        String ruta = "";
        try {
            String xsql = "SELECT\n\tconcat(f_factura_evento.Prefijo, '', f_factura_evento.No_FacturaEvento_M) numeroFactura\nFROM\n\t`f_liquidacion`\nleft join f_factura_evento on\n\t(f_factura_evento.Id_Liquidacion = f_liquidacion.Id)\n\tand (f_factura_evento.Estado = 0)\nleft join cc_resolucion_dian on\n\t(cc_resolucion_dian.Id = f_factura_evento.idResolucionDian)\nWHERE\n\t(\n f_liquidacion.`Id_Ingreso` =" + idIngreso + "\n\t\tAND f_liquidacion.`Estado` = 0\n\t\tAND trasmision = 1\n)";
            System.out.println("" + xsql);
            ResultSet xrs = this.consultasMySQL.getResultSet(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(xrs.getString("numeroFactura"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClaseImpresionInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return ruta;
    }

    public String visualizarFacturasEventoMetodoPrinicpal(String idIngreso, String valorServicios, String valorPlan, String valorDescuento, String valorCopagoModeradora, String valorUsuario, String valorEps, int formaVisualizacion, int crearPdf) {
        String pathArchivo = "";
        try {
            String[][] mparametros = new String[11][2];
            mparametros[0][0] = "idingreso";
            mparametros[0][1] = idIngreso;
            mparametros[1][0] = "usuario";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[3][0] = "vservicios";
            mparametros[3][1] = valorServicios;
            mparametros[4][0] = "vplan";
            mparametros[4][1] = valorPlan;
            mparametros[5][0] = "vdescuento";
            mparametros[5][1] = valorDescuento;
            mparametros[6][0] = "vrecuperacion";
            mparametros[6][1] = valorCopagoModeradora;
            mparametros[7][0] = "vusuario";
            mparametros[7][1] = valorUsuario;
            mparametros[8][0] = "veps";
            mparametros[8][1] = valorEps;
            mparametros[9][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[9][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[10][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[10][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            String xsql = "SELECT round(f_liquidacion.`TotalEps`) as totalEps , f_liquidacion.`Id_Ingreso`, f_factura_evento.No_FacturaEvento,\nifnull(cc_resolucion_dian.trasmision,0) as trasmision, ifnull(f_factura_evento.pdf, null) as pdf, concat(f_factura_evento.Prefijo, '',f_factura_evento.No_FacturaEvento_M) numeroFactura\nFROM `f_liquidacion`\nleft join f_factura_evento on (f_factura_evento.Id_Liquidacion=f_liquidacion.Id) and (f_factura_evento.Estado=0)\nleft join cc_resolucion_dian on (cc_resolucion_dian.Id=f_factura_evento.idResolucionDian)\nWHERE (\n f_liquidacion.`Id_Ingreso` =" + idIngreso + " \nAND f_liquidacion.`Estado` =0)";
            System.out.println("" + xsql);
            ResultSet rs = this.consultasMySQL.getResultSet(xsql);
            if (rs.next()) {
                rs.first();
                if (rs.getBoolean("trasmision")) {
                    if (rs.getString("pdf") == null) {
                        if (formaVisualizacion == 1) {
                            pathArchivo = this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Liquidacion_Servicios";
                            if (crearPdf == 1) {
                                this.metodos.CrearPDF(pathArchivo, mparametros);
                            } else {
                                this.metodos.GenerarPDF(pathArchivo, mparametros);
                            }
                        } else {
                            this.metodos.PresentacionImpresora(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Liquidacion_Servicios.jasper", mparametros);
                        }
                    } else {
                        String sql = "SELECT `pdf` FROM `f_factura_evento` WHERE( `f_factura_evento`.`No_FacturaEvento` =  " + rs.getLong("No_FacturaEvento") + " )";
                        if (this.metodos.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")).concat(this.metodos.getBarra()).concat(rs.getString("numeroFactura")).concat(".pdf"))) {
                            System.out.println(" 0 ");
                            String ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")).concat(this.metodos.getBarra()).concat(rs.getString("numeroFactura").concat(".pdf"));
                            pathArchivo = this.metodos.recuperarBlob(sql, 0, "FacturaNo" + rs.getString("numeroFactura"), crearPdf, ruta);
                        } else if (this.metodos.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")).concat(this.metodos.getBarra()).concat(rs.getString("numeroFactura")).concat("_facturaPdf.pdf"))) {
                            System.out.println(" 1 ");
                            String ruta2 = Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")).concat(this.metodos.getBarra()).concat(rs.getString("numeroFactura")).concat("_facturaPdf.pdf");
                            pathArchivo = this.metodos.recuperarBlob(sql, 0, "FacturaNo" + rs.getString("numeroFactura"), crearPdf, ruta2);
                        } else if (Metodos.getSystemSO().contains("win")) {
                            String ruta3 = Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")).concat("_facturaPdf.pdf");
                            pathArchivo = this.metodos.recuperarBlob(sql, 0, "FacturaNo" + rs.getString("numeroFactura"), crearPdf, ruta3);
                        } else {
                            pathArchivo = this.metodos.getFilePdfPath(Principal.informacionIps.getUrlRecursosAnkara().concat(rs.getString("numeroFactura")), rs.getString("numeroFactura").concat(".pdf"), false);
                        }
                    }
                } else if (formaVisualizacion == 1) {
                    pathArchivo = this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Liquidacion_Servicios";
                    if (crearPdf == 1) {
                        this.metodos.CrearPDF(pathArchivo, mparametros);
                    } else {
                        this.metodos.GenerarPDF(pathArchivo, mparametros);
                    }
                } else {
                    this.metodos.PresentacionImpresora(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Liquidacion_Servicios.jasper", mparametros);
                }
            } else if (formaVisualizacion == 1) {
                pathArchivo = this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Liquidacion_Servicios_Previo";
                if (crearPdf == 1) {
                    this.metodos.CrearPDF(pathArchivo, mparametros);
                } else {
                    this.metodos.GenerarPDF(pathArchivo, mparametros);
                }
            } else {
                this.metodos.PresentacionImpresora(this.metodos.getRutaRep() + "F_Liquidacion_Servicios_Previo.jasper", mparametros);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClaseImpresionInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(ClaseImpresionInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return pathArchivo;
    }

    private void generarPdf() {
    }

    public void mImprimir_Factura(String xreporte, String idIngreso, String valorLetras) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = idIngreso;
        mparametros[1][0] = "usuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = "valorletra";
        mparametros[2][1] = valorLetras;
        mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + xreporte, mparametros);
    }

    public void imprimirFacturaInternas(String idFactura) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = idFactura;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "CC_Factura_Interna", mparametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "CC_DocumentoSoporte", mparametros);
        }
    }

    public List<String> impresionReportes(ImpresionReportesDTO e) {
        String narchivo;
        List<String> archivo = new ArrayList<>();
        if (e.getEsDocumentoEscaneado().intValue() == 0) {
            String[][] mparametros = new String[9][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = e.getIdAtencion().toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = e.getIdUsuario().toString();
            mparametros[2][0] = "idingreso";
            mparametros[2][1] = e.getIdIngreso().toString();
            mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[5][0] = "tituloReporte";
            mparametros[6][0] = "nbreUsuario";
            mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[7][0] = "SO";
            mparametros[7][1] = this.metodos.getSO();
            mparametros[8][0] = "idAtencion";
            mparametros[8][1] = e.getIdAtencion().toString();
            switch (e.getEspecial().intValue()) {
                case 0:
                    if (!e.getNombrePDF().isEmpty()) {
                        mparametros[5][1] = e.getTitulo();
                        archivo.add(this.metodos.getRutaRep() + e.getNombrePDF() + ".pdf");
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + e.getNombrePDF(), mparametros, e.getVisualizar());
                        Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    }
                    break;
                case 1:
                    archivo.addAll(mImprimirEvento(e.getIdIngreso(), 1L));
                    break;
                case 2:
                    archivo.addAll(mImprimirEvento(e.getIdIngreso(), 2L));
                    break;
                case 3:
                    archivo.addAll(mImprimir_Formula(e.getIdAtencion(), "0", e.getVisualizar()));
                    break;
                case 4:
                    archivo.addAll(mImprimir_CTC(e.getIdAtencion(), e.getVisualizar()));
                    break;
                case 5:
                    archivo.addAll(mImprimir_AyudaDx(e.getIdAtencion(), e.getVisualizar()));
                    break;
                case 6:
                    archivo.addAll(mImprimir_AyudaDx_Anexo3(e.getIdAtencion(), 1, "0", 0));
                    break;
                case 7:
                    archivo.addAll(mImprimir_AyudaDx_Anexo3(e.getIdAtencion(), 0, "0", 0));
                    break;
                case 8:
                    archivo.addAll(Imprimir_Remision(e.getIdAtencion(), 0, e.getVisualizar()));
                    break;
                case 9:
                    archivo.addAll(Imprimir_Remision(e.getIdAtencion(), 1, e.getVisualizar()));
                    break;
                case 10:
                    archivo.addAll(mImprimeHistoriaOdontologia(e.getIdAtencion(), e.getIdUsuario(), e.getVisualizar()));
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 11:
                    archivo.addAll(mImprimeHistoriaSO(e.getIdAtencion(), e.getIdUsuario(), e.getVisualizar()));
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 12:
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        archivo.addAll(Imprimir_Remision(e.getIdAtencion(), 1, e.getVisualizar()));
                    } else {
                        archivo.addAll(mImprimir_Anexo3_Interconsulta(e.getIdAtencion()));
                    }
                    break;
                case 13:
                    archivo.addAll(mImprir_InformeQx(e.getIdAtencion(), e.getNombrePDF(), e.getTitulo(), e.getVisualizar()));
                    break;
                case 14:
                    archivo.addAll(mImprimir_Autorizacion(e.getIdIngreso(), e.getNombrePDF(), e.getVisualizar()));
                    break;
                case 15:
                    archivo.addAll(mImprimir_RLaboratorio(e.getIdIngreso(), e.getIdUsuario(), e.getVisualizar()));
                    break;
                case 16:
                    archivo.addAll(mImprimir_EpHosp(e.getIdAtencion(), e.getNombrePDF(), e.getIdTipoAtencion(), e.getVisualizar()));
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 17:
                    archivo.addAll(mImprir_Hc(e.getIdIngreso(), e.getIdAtencion(), e.getIdUsuario(), e.getVisualizar()));
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 18:
                    archivo.addAll(mImprir_HcNacimiento(e.getIdAtencion(), e.getNombrePDF(), e.getVisualizar()));
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 19:
                    if (e.getTitulo().equals("Ecografias Obstetrica")) {
                        archivo.addAll(mImprimirEcografia(e.getIdAtencion(), e.getVisualizar()));
                        break;
                    } else {
                        if (e.getTitulo().equals("Ecografias General")) {
                            archivo.addAll(mImprimirEcografiaGeneral(e.getIdAtencion(), e.getVisualizar()));
                        }
                        break;
                    }
                case 20:
                    archivo.addAll(Furtran(e.getIdIngreso(), e.getTitulo()));
                    break;
                case 30:
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 31:
                    Principal.mGrabarLogAtenciones(e.getTitulo(), e.getIdAtencion().toString(), e.getIdUsuario().toString());
                    break;
                case 40:
                    archivo.addAll(mImprimirNotasClinciasNuevas("2,4,5,7", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 41:
                    archivo.addAll(mImprimirNotasClinciasNuevas("3", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 42:
                    archivo.addAll(mImprimirNotasClinciasNuevas("5", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 43:
                    archivo.addAll(mImprimirNotasClinciasNuevas("6", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 44:
                    archivo.addAll(mImprimirNotasClinciasNuevas("7,13", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 45:
                    archivo.addAll(mImprimirNotasClinciasNuevas("8", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 46:
                    this.xImpresionDc.mGenerarGraficas("4", e.getIdUsuario().toString(), e.getIdAtencion().toString());
                    archivo.addAll(mImprimirNotasClinciasNuevas("0", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 47:
                    this.xImpresionDc.mGenerarGraficas("3", e.getIdUsuario().toString(), e.getIdAtencion().toString());
                    archivo.addAll(mImprimirNotasClinciasNuevas("0", e.getTitulo().toUpperCase(), e.getNombrePDF(), e.getVisualizar(), e.getIdAtencion(), e.getIdUsuario(), e.getIdIngreso()));
                    break;
                case 50:
                    archivo.addAll(imprimirConsentimientoInformado(e.getIdIngreso(), e.getVisualizar()));
                    break;
                case 60:
                    archivo.addAll(imprimirTestRespiratorio2(e.getIdIngreso(), e.getVisualizar()));
                    break;
                case 61:
                    if (e.getIdIngreso().longValue() != 0) {
                        for (int i = 0; i < 2; i++) {
                            if (i == 0) {
                                narchivo = imprimir_FacturayOrden1(0, e.getNoFactura(), e.getIdIngreso(), Principal.usuarioSistemaDTO.getLogin(), e.getIdIdentificadorTipoFactura().intValue(), 2, e.getNit(), 1, true);
                            } else {
                                narchivo = imprimir_FacturayOrden1(0, e.getNoFactura(), e.getIdIngreso(), Principal.usuarioSistemaDTO.getLogin(), e.getIdIdentificadorTipoFactura().intValue(), 2, e.getNit(), 1, false);
                            }
                            if (!narchivo.isEmpty()) {
                                if (!Principal.informacionIps.getUrlRecursosAnkara().isEmpty() && Principal.informacionIps.getUrlRecursosAnkara() != null) {
                                    if (narchivo.contains(Principal.informacionIps.getUrlRecursosAnkara())) {
                                        archivo.add(this.metodos.FileCopy(narchivo, e.getRutaCarpeta(), narchivo.substring(narchivo.lastIndexOf(this.metodos.getBarra()) + 1).replace(".pdf", "") + "_tmp.pdf"));
                                    } else {
                                        archivo.add(narchivo);
                                    }
                                } else {
                                    archivo.add(narchivo);
                                }
                            }
                        }
                    }
                    break;
                case 62:
                    archivo.addAll(imprimirHistoriaFisioTerapia(e.getIdUsuario(), e.getFechaI(), e.getFechaF()));
                    break;
                case 63:
                    archivo.addAll(imprimirRecibo(e.getIdIngreso()));
                    break;
                case 64:
                    archivo.addAll(imprimirUnidosis(e.getIdAtencion()));
                    break;
                case 65:
                    archivo.addAll(imprimirAtencionParto(e.getIdAtencion(), e.getNombrePDF(), e.getTitulo(), e.getVisualizar()));
                    break;
                case 66:
                    archivo.addAll(mImprimirEvento(e.getIdIngreso(), 1L));
                    break;
                case 67:
                    archivo.addAll(mImprimirEvento(e.getIdIngreso(), 2L));
                    break;
                case 68:
                    archivo.addAll(mImprimirCitologias(e.getIdIngreso()));
                    break;
            }
        } else if (e.getIdReporte().longValue() != 0) {
            archivo.addAll(impresionSoporteAnexoPersona(e.getIdUsuario(), e.getIdReporte(), e.getRutaCarpeta()));
            archivo.addAll(impresionSoportesEscaneadosIngreso(e.getIdIngreso(), e.getIdReporte(), e.getRutaCarpeta()));
            archivo.addAll(impresionSoportesAyudasDX(e.getIdAtencion(), e.getIdReporte(), e.getRutaCarpeta()));
            archivo.addAll(impresionSoportesAtencionesManuales(e.getIdIngreso(), e.getIdReporte(), e.getRutaCarpeta()));
        }
        return archivo;
    }

    private List<String> mImprimirCitologias(Long idIngreso) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0) {
            try {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String xsql = "SELECT\n\tpc.Id,\n\tCAST(lrc.Id_Consecutivo AS UNSIGNED) as consecutivo,\n\tgp2.NoDocumento,\n\tCONCAT(gp2.Apellido1, ' ', gp2.Apellido2, ' ', gp2.Nombre1, ' ', gp2.Nombre2) as nombreUsuario,\n\tdate_format(l_recepcion.FechaRecep, '%d-%m-%Y') as fechaRecepcion\nFROM\n\tp_citologia pc\ninner join l_recepcion_citologia lrc on\n\t(lrc.Id_Recepcion = pc.Id_Recepcion )\nINNER JOIN p_citologiaesquema ON\n\tpc.Id_Esquema = p_citologiaesquema.Id\nINNER JOIN l_recepcion ON\n\tl_recepcion.Id = pc.Id_Recepcion\ninner join f_ordenes fo ON\n\tfo.Id = l_recepcion.Id_OrdenFacturac\ninner join ingreso i on\n\ti.Id = fo.Id_Ingreso\nINNER JOIN l_detallerecepcion ON\n\tl_recepcion.Id = l_detallerecepcion.Id_Recepcion\nINNER JOIN g_procedimiento gp ON\n\tgp.Id = l_detallerecepcion.Id_Procedim\nINNER JOIN p_citologia_resultados pcr ON\n\tpcr.Id_Citologia = pc.Id\ninner join g_persona gp2 ON\n\tgp2.Id = l_recepcion.Id_Paciente\nleft join l_detallerecepcion_comentario ldc on\n\t(ldc.Id_Recepcion = pc.Id_Recepcion)\n\tand (ldc.Estado = 1)\nWHERE\n\t i.Id =" + idIngreso + "\n\tAND pc.Estado = 0\ngroup by\n\tpcr.Id\nORDER BY\n\tpc.FechaToma DESC";
                System.out.println(xsql);
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String nombreArchivo2 = xrs.getString("consecutivo") + "_" + xrs.getString("NoDocumento") + "_" + xrs.getString("nombreUsuario") + "_" + xrs.getString("fechaRecepcion") + ".pdf";
                        this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + "H_CitologiaLiquida.pdf"));
                        this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + nombreArchivo2));
                        ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
                        bethesda.generarReporte(Long.valueOf(xrs.getLong("Id")), 2);
                        if (this.metodos.mExisteArchivo(this.metodos.getRutaRep() + "H_CitologiaLiquida.pdf")) {
                            String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "H_CitologiaLiquida.pdf", rutaTemp, "H_CitologiaLiquida0_tmp.pdf");
                            archivo.add(rutaFinal);
                        }
                        if (this.metodos.mExisteArchivo(this.metodos.getRutaRep() + nombreArchivo2)) {
                            archivo.add(this.metodos.getRutaRep() + nombreArchivo2);
                        }
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> mImprimirEvento(Long idIngreso, long xtipo) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0) {
            try {
                String xsql = "SELECT `Id_Eventoecat`, `Id_Persona`, `Id_Ingreso`, Id FROM `a_eventoecat_paciente` WHERE (`Id_Ingreso` ='" + idIngreso + "')";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.first();
                    if (xtipo == 1) {
                        Furips_PA_V2023 xfrPA = new Furips_PA_V2023(xrs.getString(1), xrs.getString(2), xrs.getString("Id_Ingreso"), "", "");
                        xfrPA.build();
                        archivo.add(this.metodos.getRutaRep() + "furipsPA_v2023.pdf");
                    } else if (xtipo == 2) {
                        Furips_PB_V2023 xfr = new Furips_PB_V2023(xrs.getString(4), xrs.getString(1), xrs.getString("Id_Ingreso"), "", "", "");
                        xfr.build();
                        archivo.add(this.metodos.getRutaRep() + "furipsPB_v2023.pdf");
                    } else if (xtipo == 3) {
                        Furcen xfr2 = new Furcen(xrs.getString(1));
                        xfr2.build();
                        archivo.add(this.metodos.getRutaRep() + "furcen.pdf");
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> mImprimir_Formula(Long idAtencion, String n, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            String NOrden = "";
            if (n == "0") {
                try {
                    String xsql = "SELECT  `h_ordenes`.`Id` FROM `h_itemordenessum` INNER JOIN  `h_ordenes`   ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =0  AND `h_ordenes`.`Id_Atencion` ='" + idAtencion + "') GROUP BY `h_ordenes`.`Id` ORDER BY `h_ordenes`.`Id` ASC ";
                    ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                    if (xrs.next()) {
                        xrs.first();
                        NOrden = xrs.getString(1);
                    }
                    xrs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else {
                NOrden = n;
            }
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + NOrden + "'";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rsm = xct1.traerRs(sql);
            if (rsm.next()) {
                rsm.first();
                long xida = rsm.getLong(1);
                ConsultasMySQL xct2 = new ConsultasMySQL();
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + NOrden + "' order by Id";
                rsm = xct2.traerRs(sql2);
                if (rsm.next()) {
                    xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                }
                xct2.cerrarConexionBd();
            }
            rsm.close();
            xct1.cerrarConexionBd();
            String[][] mparametros = new String[7][2];
            mparametros[0][0] = "norden";
            mparametros[0][1] = NOrden;
            mparametros[1][0] = "xp2";
            mparametros[1][1] = "Farmacia";
            mparametros[2][0] = "ip";
            mparametros[2][1] = xnotasad;
            mparametros[3][0] = "nusuarios";
            mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[4][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[5][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[6][0] = "nbreUsuario";
            mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                ConsultasMySQL xct3 = new ConsultasMySQL();
                String xsql2 = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + NOrden + "') ";
                ResultSet xrs1 = xct3.traerRs(xsql2);
                if (xrs1.next()) {
                    xrs1.first();
                    if (xrs1.getInt(1) == 1) {
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP.pdf");
                    } else {
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP_Directivos.pdf");
                    }
                }
                xrs1.close();
                xct3.cerrarConexionBd();
            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                switch (Principal.informacionIps.getNombreIps()) {
                    case "CLINICA PAJONAL S.A.S":
                    case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                    case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                    case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "Pajonal_RFormulaGeneralMP2.pdf");
                        break;
                    default:
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP1", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP1.pdf");
                        break;
                }
            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                switch (Principal.informacionIps.getNombreIps()) {
                    case "CLINICA OFTALMOLOGICA DAJUD SAS":
                    case "COD-OPTICA UT":
                    case "JAIME CESAR DAJUD FERNANDEZ":
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP2_CDajud.pdf");
                        break;
                    case "CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.":
                    case "UNION TEMPORAL CLINICA LAURELES":
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras.pdf");
                        break;
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP_Hospital.pdf");
                    case "CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S":
                        this.metodos.GenerarPDF("Pajonal_RFormulaGeneralMP2", mparametros);
                        archivo.add(this.metodos.getRutaRep() + "Pajonal_RFormulaGeneralMP2");
                        break;
                    case "CLINICA PAJONAL S.A.S":
                    case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                    case "E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO":
                    case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                    case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                        this.metodos.GenerarPDF("Pajonal_RFormulaGeneralMP2", mparametros);
                        archivo.add(this.metodos.getRutaRep() + "Pajonal_RFormulaGeneralMP2");
                        break;
                    default:
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RFormulaGeneralMP2", mparametros, visualizar);
                        archivo.add(this.metodos.getRutaRep() + "RFormulaGeneralMP2.pdf");
                        break;
                }
            }
            this.consultasMySQL.cerrarConexionBd();
        }
        return archivo;
    }

    private List<String> mImprimir_CTC(Long idAtencion, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            try {
                String xsql = "SELECT `h_ordenes`.`Id` AS `Id_Orden` , `h_concecutivo_ctc`.`Id` AS `Id_Ctc` FROM `h_itemordenessum`  INNER JOIN  `h_ordenes`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `h_concecutivo_ctc`  ON (`h_concecutivo_ctc`.`IdOrden` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =1  AND `h_ordenes`.`Id_Atencion` ='" + idAtencion + "') GROUP BY `Id_Orden` ORDER BY `Id_Orden` ASC ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.first();
                    String[][] parametros = new String[4][2];
                    parametros[0][0] = "ID_Conc";
                    parametros[0][1] = xrs.getString(1);
                    parametros[1][0] = NOMBRE_SUBREPORT_DIR;
                    parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                    parametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                    parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                    parametros[3][0] = "nbreUsuario";
                    parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "R_MedicamentoNoPOS", parametros, visualizar);
                    archivo.add(this.metodos.getRutaRep() + "R_MedicamentoNoPOS.pdf");
                    xrs.close();
                    this.consultasMySQL.cerrarConexionBd();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> mImprimir_AyudaDx(Long idAtencion, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            try {
                String xsql = "SELECT  `h_ordenes`.`Id` AS `Id_Orden` , `h_ordenes`.`Id_TipoServicio` FROM `h_itemordenesproced` INNER JOIN  `h_ordenes`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`Id_Atencion` ='" + idAtencion + "') GROUP BY `Id_Orden` ORDER BY `Id_Orden` ASC ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    while (xrs.next()) {
                        if (xrs.getInt(2) == 2) {
                            String xpeso = "";
                            String xtalla = "";
                            String xnstiker = "1";
                            String xsql2 = "SELECT h_examenfisico.Talla , h_examenfisico.Peso  FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + xrs.getString(1) + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                            ResultSet xrs1 = xct1.traerRs(xsql2);
                            if (xrs1.next()) {
                                xrs1.first();
                                xtalla = xrs1.getString(1);
                                xpeso = xrs1.getString(2);
                            }
                            xrs1.close();
                            xct1.cerrarConexionBd();
                            String xsql3 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + xrs.getString(1) + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                            ResultSet rs = xct1.traerRs(xsql3);
                            if (rs.next()) {
                                rs.last();
                                xnstiker = String.valueOf(rs.getRow());
                            }
                            rs.close();
                            xct1.cerrarConexionBd();
                            String[][] mparametros = new String[7][2];
                            mparametros[0][0] = "idorden";
                            mparametros[0][1] = xrs.getString(1);
                            mparametros[1][0] = "talla";
                            mparametros[1][1] = "TALLA : " + xtalla;
                            mparametros[2][0] = "peso";
                            mparametros[2][1] = "PESO : " + xpeso;
                            mparametros[3][0] = "ns";
                            mparametros[3][1] = "N° Stiker : " + xnstiker;
                            mparametros[4][0] = NOMBRE_SUBREPORT_DIR;
                            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                            mparametros[5][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                            mparametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                            mparametros[6][0] = "nbreUsuario";
                            mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosL", mparametros, visualizar);
                                archivo.add(this.metodos.getRutaRep() + "RProcedimientosL.pdf");
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosL_1_Hospital.pdf");
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosL1", mparametros, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosL1.pdf");
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosL_1_Hospital.pdf");
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosL2", mparametros, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosL2.pdf");
                                }
                            }
                        } else {
                            String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + xrs.getString(1) + "'";
                            String nota = xct1.traerDato(sql);
                            xct1.cerrarConexionBd();
                            String horario = "";
                            if (xrs.getInt(2) == 3) {
                                horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
                            }
                            String[][] mparametros2 = new String[7][2];
                            mparametros2[0][0] = "idorden";
                            mparametros2[0][1] = xrs.getString(1);
                            mparametros2[1][0] = "idservicio";
                            mparametros2[1][1] = xrs.getString(2);
                            mparametros2[2][0] = "nota";
                            mparametros2[2][1] = nota;
                            mparametros2[3][0] = "horario";
                            mparametros2[3][1] = horario;
                            mparametros2[4][0] = NOMBRE_SUBREPORT_DIR;
                            mparametros2[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                            mparametros2[5][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                            mparametros2[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                            mparametros2[6][0] = "nbreUsuario";
                            mparametros2[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosO", mparametros2, visualizar);
                                archivo.add(this.metodos.getRutaRep() + "RProcedimientosO.pdf");
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosO_Hospital.pdf", mparametros2, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosO_Hospital");
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosO1", mparametros2, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosO1.pdf");
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosO_Hospital", mparametros2, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosO_Hospital.pdf");
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RProcedimientosO2", mparametros2, visualizar);
                                    archivo.add(this.metodos.getRutaRep() + "RProcedimientosO2.pdf");
                                }
                            }
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> mImprimir_AyudaDx_Anexo3(Long idAtencion, int xn, String idOrden, int opc) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            if (opc == 0) {
                new ReporteAnexo3(idAtencion.toString(), idOrden, xn, 1);
                archivo.add(this.metodos.getRutaRep() + "H_Anexo3_Orden.pdf");
            } else if (xn == 0) {
                ReporteAnexo3 x = new ReporteAnexo3(idAtencion.toString(), idOrden, xn, 1);
                x.build();
                archivo.add(this.metodos.getRutaRep() + "H_Anexo3_Orden.pdf");
            } else {
                ReporteAnexo3 x2 = new ReporteAnexo3(idAtencion.toString(), idOrden, xn, 1);
                x2.build();
                archivo.add(this.metodos.getRutaRep() + "H_Anexo3_Orden.pdf");
            }
        }
        return archivo;
    }

    public List<String> Imprimir_Remision(Long idAtencion, int xId_Items, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            try {
                String xsql = "SELECT `Id` FROM `h_remisiones` WHERE (`Id_Atencion` ='" + idAtencion + "'  AND `Estado` =0) ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        if (xId_Items == 0) {
                            String[][] mparametros = new String[6][2];
                            mparametros[0][0] = "idremision";
                            mparametros[0][1] = xrs.getString(1);
                            mparametros[1][0] = "idatencion1";
                            mparametros[1][1] = idAtencion.toString();
                            mparametros[2][0] = "marca";
                            mparametros[2][1] = "HISTORIA CLINICA";
                            mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
                            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                            mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                            mparametros[5][0] = "nbreUsuario";
                            mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                archivo.add(this.metodos.getRutaRep() + "RRemisionTO.pdf");
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RRemisionTO", mparametros, visualizar);
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                archivo.add(this.metodos.getRutaRep() + "RRemision1.pdf");
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RRemision1", mparametros, visualizar);
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                archivo.add(this.metodos.getRutaRep() + "RRemision2.pdf");
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RRemision2", mparametros, visualizar);
                            }
                        } else {
                            ReporteRemision xReporteRemision = new ReporteRemision(idAtencion.toString(), xrs.getString(1));
                            xReporteRemision.build();
                            archivo.add(this.metodos.getRutaRep() + "FReferencia_" + xrs.getString(1) + ".pdf");
                        }
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> mImprimeHistoriaOdontologia(Long idAtencion, Long idUsuario, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        try {
            if (idAtencion.longValue() != 0 && idUsuario.longValue() != 0) {
                JDialog prueba = new JDialog();
                JPanel panel = new JPanel();
                this.panel.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
                this.panel.setVisible(true);
                this.panel.setBounds(0, 0, 100, 100);
                prueba.add(panel);
                prueba.setSize(10, 10);
                prueba.setVisible(true);
                this.metodos.cargarPanelOdontogramaDientes(panel);
                String[][] mparametros = new String[6][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion.toString();
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = idUsuario.toString();
                mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
                mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                mparametros[4][0] = "nbreUsuario";
                mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                mparametros[5][0] = "nbreUsuario";
                mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + idAtencion + "')";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    String xTratamiento = xrs.getString(1);
                    this.metodos.mTraerDatosDienteDxOdontInicial(idUsuario.toString());
                    this.metodos.mTraerDatosDienteProcOdontInicial(idUsuario.toString());
                    this.metodos.traerImagenOdontograma();
                    this.metodos.mTraerDatosDienteDxTratamiento(xTratamiento);
                    this.metodos.traerImagenOdontogramaDx();
                    this.metodos.mTraerDatosDienteProcTratamiento(xTratamiento);
                    this.metodos.traerImagenOdontogramaProc();
                    this.metodos.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                    this.metodos.traerImagenOdontogramaControlPlaca();
                    archivo.add(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_HistoriaClinicaOdontologia.pdf");
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_HistoriaClinicaOdontologia", mparametros, visualizar);
                }
                prueba.dispose();
                xrs.close();
                xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return archivo;
    }

    private List<String> mImprimeHistoriaSO(Long idAtencion, Long idUsuario, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0 && idUsuario.longValue() != 0) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion.toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = idUsuario.toString();
            mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.mGenerarGrafico(idAtencion.toString());
            archivo.add(this.metodos.getRutaRep() + "H_HistoriaClinicaSO_FPZ.pdf");
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_HistoriaClinicaSO_FPZ", mparametros, visualizar);
        }
        return archivo;
    }

    private List<String> mImprimir_Anexo3_Interconsulta(Long idAtencion) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            ReporteAnexo3_Interconsulta x = new ReporteAnexo3_Interconsulta(idAtencion.toString(), "0", 0);
            x.build();
            archivo.add(this.metodos.getRutaRep() + "H_Anexo3_Orden" + idAtencion + ".pdf");
        }
        return archivo;
    }

    private List<String> mImprir_InformeQx(Long idAtencion, String nombreReporte, String titulo, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        try {
            if (idAtencion.longValue() != 0 && !nombreReporte.isEmpty()) {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String xsql = "SELECT `Id` FROM `h_orden_qx` WHERE (`Id_Atencion` ='" + idAtencion + "' AND `Estado` =1 AND IF(`Fecha_Final` IS NULL,0,1)=1) ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[5][2];
                        mparametros[0][0] = "Id";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[3][0] = "tituloReporte";
                        mparametros[3][1] = titulo;
                        mparametros[4][0] = "nbreUsuario";
                        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + nombreReporte, mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + nombreReporte + ".pdf", rutaTemp, nombreReporte + "_" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return archivo;
    }

    public List<String> mImprimir_Autorizacion(Long idIngreso, String nombreReporte, Boolean Visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0 && !nombreReporte.isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idingreso";
            mparametros[0][1] = idIngreso.toString();
            mparametros[1][0] = "usuario";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[4][0] = "nbreUsuario";
            mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            archivo.add(this.metodos.getRutaRep() + nombreReporte + ".pdf");
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + nombreReporte, mparametros, Visualizar);
        }
        return archivo;
    }

    private List<String> mImprimir_RLaboratorio(Long idIngreso, Long idUsuario, Boolean Visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0 && idUsuario.longValue() != 0) {
            try {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String rutaSoportesExternos = this.metodos.mRutaSoporte("JDCarguePDFResultadosExternos");
                String rutaFinal = "";
                ResultSet xrs = this.consultasMySQL.traerRs("SELECT\n\t`l_recepcion`.`Id`\nFROM\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `l_resultados` ON\n\t(`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `l_detalleresultado` ON\n\t(`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\n\tAND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nINNER JOIN `f_ordenes` ON\n\t(`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN `ingreso` ON\n\t(`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE\n\t(`ingreso`.`Id` = " + idIngreso + "\n\t\tAND `l_recepcion`.`Estado` = 0)\nGROUP BY\n\t`l_recepcion`.`Id`\nORDER BY\n\t`l_recepcion`.`FechaRecep` DESC");
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf"));
                        ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                        impresion.mImprimirResultado(xrs.getString(1), "", this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra(), this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra(), true, idUsuario.toString(), Visualizar.booleanValue());
                        rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf", rutaTemp, Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado_" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                String xsql = "SELECT\n\tl_detallerecepcion.ArchivoResultadoExterno, l_detallerecepcion.Id_Recepcion, l_detallerecepcion.Id_Procedim\nFROM\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_resultados` ON\n\t(`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_detalleresultado` ON\n\t(`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\n\tAND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nINNER JOIN `f_ordenes` ON\n\t(`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN `ingreso` ON\n\t(`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE\n\t(`ingreso`.`Id` = " + idIngreso + "\n\t\tAND `l_recepcion`.`Estado` = 0             AND l_detallerecepcion.ArchivoResultadoExterno is not null )\n group by l_recepcion.`Id` ORDER BY\n\t`l_recepcion`.`FechaRecep` DESC";
                System.err.println("externos" + xsql);
                ResultSet xrs2 = this.consultasMySQL.traerRs(xsql);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    while (xrs2.next()) {
                        if (xrs2.getString("ArchivoResultadoExterno").contains("pdf")) {
                            if (this.metodos.mExisteArchivo(rutaSoportesExternos + xrs2.getString("ArchivoResultadoExterno"))) {
                                rutaFinal = this.metodos.FileCopy(rutaSoportesExternos + xrs2.getString("ArchivoResultadoExterno"), rutaTemp, xrs2.getString("ArchivoResultadoExterno").replace(".pdf", "") + "0_tmp.pdf");
                            }
                        } else {
                            rutaFinal = rutaTemp + this.metodos.getBarra() + xrs2.getString("Id_Recepcion") + "_" + xrs2.getString("Id_Procedim") + "_tmp.pdf";
                            System.out.println(rutaFinal);
                            File file = new File(rutaFinal);
                            FileOutputStream fos = new FileOutputStream(file);
                            Blob bin = xrs2.getBlob(1);
                            InputStream inStream = bin.getBinaryStream();
                            int size = (int) bin.length();
                            byte[] buffer = new byte[size];
                            while (true) {
                                int length = inStream.read(buffer);
                                if (length != -1) {
                                    fos.write(buffer, 0, length);
                                }
                            }
                        }
                        archivo.add(rutaFinal);
                    }
                }
                xrs2.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClaseImpresionInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (IOException ex2) {
                Logger.getLogger(ClaseImpresionInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (SQLException ex3) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
            }
        }
        return archivo;
    }

    private List<String> mImprimir_EpHosp(Long idAtencion, String nombreReporte, Long idTipoAtencion, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0 && !nombreReporte.isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion.toString();
            mparametros[1][0] = "Id_Tipo";
            mparametros[1][1] = idTipoAtencion.toString();
            mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[4][0] = "nbreUsuario";
            mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            archivo.add(this.metodos.getRutaRep() + nombreReporte + ".pdf");
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + nombreReporte, mparametros, visualizar);
        }
        return archivo;
    }

    private List<String> mImprir_Hc(Long idIngreso, Long idAtencion, Long idUsuario, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        try {
            if (idIngreso.longValue() != 0 && idAtencion.longValue() != 0 && idUsuario.longValue() != 0) {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String xsql = "SELECT  `h_atencion`.`Id` , `h_tipohistoria`.`Reporte` FROM `h_atencion` INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`TipoGuardado` =1 AND `h_atencion`.`Id` ='" + idAtencion + "') ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[6][2];
                        mparametros[0][0] = "idatencion1";
                        mparametros[0][1] = idAtencion.toString();
                        mparametros[1][0] = "idpaciente1";
                        mparametros[1][1] = idUsuario.toString();
                        mparametros[2][0] = "idingreso";
                        mparametros[2][1] = idIngreso.toString();
                        mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[5][0] = "nbreUsuario";
                        mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + xrs.getString(2), mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + xrs.getString(2) + ".pdf", rutaTemp, xrs.getString(2) + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return archivo;
    }

    private List<String> mImprir_HcNacimiento(Long idAtencion, String nombreReporte, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0 && !nombreReporte.isEmpty()) {
            try {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String xsql = "SELECT  `h_atencion`.`Id` , `h_orden_qx_nacido_detalle`.`Id` , `ingreso`.`Id_Usuario` \nFROM   `h_orden_qx` INNER JOIN   `h_atencion`  ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN   `h_orden_qx_nacidos`  ON (`h_orden_qx_nacidos`.`IdOrdenQx` = `h_orden_qx`.`Id`)\nINNER JOIN   `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN   `h_orden_qx_nacido_detalle`  ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`)\nWHERE (`h_atencion`.`Id` ='" + idAtencion + "' AND `h_orden_qx`.`Estado` =1) ";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[6][2];
                        mparametros[0][0] = "idatencion1";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = "idpaciente1";
                        mparametros[1][1] = xrs.getString(3);
                        mparametros[2][0] = "ID_RNACIDO";
                        mparametros[2][1] = xrs.getString(2);
                        mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[5][0] = "nbreUsuario";
                        mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + nombreReporte, mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + nombreReporte + ".pdf", rutaTemp, nombreReporte + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List mImprimirEcografia(Long idAtencion, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            try {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String sql = "SELECT `h_ecog_obstetrica`.Id, DATE_FORMAT(`h_ecog_obstetrica`.`Fecha`,'%d-%m-%Y' ), `profesional1`.`NProfesional`  FROM `h_ecog_obstetrica` INNER JOIN `h_atencion`  ON (`h_ecog_obstetrica`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ecog_obstetrica`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ecog_obstetrica`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_ecog_obstetrica`.`Id_Atencion` ='" + idAtencion + "')";
                ResultSet xrs = this.consultasMySQL.traerRs(sql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[4][2];
                        mparametros[0][0] = "idatencion1";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[3][0] = "nbreUsuario";
                        mparametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Ecografia_Obstetrica", mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "H_Ecografia_Obstetrica.pdf", rutaTemp, "H_Ecografia_Obstetrica" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List mImprimirEcografiaGeneral(Long idAtencion, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        try {
            if (idAtencion.longValue() != 0) {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String sql = "SELECT `h_ecografia_general`.`Id`FROM  `h_ecog_detalle` INNER JOIN  `h_ecografia_general`  ON (`h_ecog_detalle`.`Id_Ecografia` = `h_ecografia_general`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_ecografia_general`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_ecografia_general`.`Id_Profesional`) INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id` = `h_ecografia_general`.`Id_Atencion`) INNER JOIN  `c_clasecita`  ON (`h_ecografia_general`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_procedimiento`  ON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_ecografia_general`.`Id_Atencion` ='" + idAtencion + "' AND `h_ecografia_general`.`Estado` =1) GROUP BY `h_ecografia_general`.`Id` ORDER BY `h_ecografia_general`.`Fecha_R` DESC ";
                System.out.println(sql);
                ResultSet xrs = this.consultasMySQL.traerRs(sql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[4][2];
                        mparametros[0][0] = "idatencion1";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[3][0] = "nbreUsuario";
                        mparametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Ecografia_General", mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "H_Ecografia_General.pdf", rutaTemp, "H_Ecografia_General" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return archivo;
    }

    private List Furtran(Long idIngreso, String titulo) {
        List<String> archivo = new ArrayList<>();
        String rutaTemp = this.metodos.mRutaSoporte("temp");
        if (idIngreso.longValue() != 0) {
            String sql = "SELECT a_furtran.`Id` , a_furtran.`FechaR` , a_furtran.`NEmpresaT` , CONCAT(a_furtran.`Apellido1`, '' ,a_furtran.`Apellido2`, ' ', a_furtran.`Nombre1`, ' ', a_furtran.`Nombre2`) AS Usuario, a_furtran.`NumDocumento` \nFROM `a_furtran`\nINNER JOIN `a_furtran_persona` ON (`a_furtran_persona`.`IdFurtran` = a_furtran.`Id`)\nINNER JOIN `a_eventoecat_paciente` ON (`a_eventoecat_paciente`.`Id` = a_furtran_persona.`IdPersonaEvento`)\nWHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + idIngreso + "' AND a_furtran.`Estado` =1) ORDER BY a_furtran.`FechaR` DESC;";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        if (titulo.equals("Furtran")) {
                            Furtran furtran = new Furtran(xrs.getString(1), 0);
                            furtran.build();
                        } else if (titulo.equals("Furtran Glosa")) {
                            Furtran furtran2 = new Furtran(xrs.getString(1), 1);
                            furtran2.build();
                        }
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "Furtran.pdf", rutaTemp, "Furtran" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    public List<String> mImprimirNotasClinciasNuevas(String xFitlroIn, String xTitulo, String xNombreReporte, Boolean visualizar, Long idAtencion, Long idUsuario, Long idIngreso) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0 && idAtencion.longValue() != 0 && idUsuario.longValue() != 0 && !xNombreReporte.isEmpty()) {
            String[][] mparametros = new String[8][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion.toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = idUsuario.toString();
            mparametros[2][0] = "idingreso";
            mparametros[2][1] = idIngreso.toString();
            mparametros[3][0] = NOMBRE_SUBREPORT_DIR;
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[4][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            mparametros[5][0] = "filtroIn";
            mparametros[5][1] = xFitlroIn;
            mparametros[6][0] = "xTitulo";
            mparametros[6][1] = xTitulo;
            mparametros[7][0] = "OS";
            mparametros[7][1] = System.getProperty("os.name").substring(0, 3);
            archivo.add(this.metodos.getRutaRep() + xNombreReporte + ".pdf");
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + xNombreReporte, mparametros, visualizar);
        }
        return archivo;
    }

    public List imprimirConsentimientoInformado(Long idIngreso, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0) {
            String rutaTemp = this.metodos.mRutaSoporte("temp");
            try {
                String xsql = "SELECT\n    `ingreso_consentimiento_informado`.`Id`\n    , `h_tipoconsentimiento`.`Nbre` nombreConsentimiento\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\nFROM\n     `ingreso_consentimiento_informado`\n    INNER JOIN  `h_tipoconsentimiento` \n        ON (`ingreso_consentimiento_informado`.`Id_TipoConsentimiento` = `h_tipoconsentimiento`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`ingreso_consentimiento_informado`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `ingreso_consentimiento_informado`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `ingreso_consentimiento_informado`.`Id_Profesional`)\nWHERE (`ingreso_consentimiento_informado`.`Estado` =1\n    AND `ingreso`.`Id` =" + idIngreso + ")";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[4][2];
                        mparametros[0][0] = "idConsentimiento";
                        mparametros[0][1] = xrs.getString("Id");
                        mparametros[1][0] = "usuarioSistemas";
                        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_ConsentimientoInformado", mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "H_ConsentimientoInformado.pdf", rutaTemp, "H_ConsentimientoInformado" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    public List imprimirTestRespiratorio2(Long idIngreso, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "idingreso";
            parametros[0][1] = idIngreso.toString();
            parametros[1][0] = "ruta";
            parametros[1][1] = this.metodos.getRutaRep();
            parametros[2][0] = NOMBRE_SUBREPORT_DIR;
            parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
            parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                archivo.add(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2.pdf");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2", parametros, visualizar);
            } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                archivo.add(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2_V2.pdf");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_TestRespiratorio_SARS-CoV-2_V2", parametros, visualizar);
            }
        }
        return archivo;
    }

    public String imprimir_FacturayOrden1(int op, String NoFactura, Long idIngreso, String UsuarioS, int esCapitado, int TipoFactura, String N_Ips, int crearPDF, boolean esFacturaDian) {
        String xarchivo = "";
        if (idIngreso.longValue() != 0) {
            if (esFacturaDian) {
                xarchivo = visualizarFacturasEventoMetodoPrinicpal(idIngreso.toString(), "0", "0", "0", "0", "0", "0", 1, crearPDF);
            } else {
                String[][] mparametros = new String[8][2];
                new convertirNumerosLetras();
                mparametros[0][0] = "idingreso";
                mparametros[0][1] = idIngreso.toString();
                mparametros[1][0] = "usuarioSiste";
                mparametros[1][1] = UsuarioS;
                mparametros[2][0] = "valorletra";
                mparametros[3][0] = "ruta";
                mparametros[3][1] = this.metodos.getRutaRep();
                mparametros[4][0] = "noFactura";
                mparametros[4][1] = NoFactura;
                mparametros[5][0] = "ntriage";
                mparametros[5][1] = this.consultasMySQL.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
                mparametros[6][0] = NOMBRE_SUBREPORT_DIR;
                mparametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros[7][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                mparametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                this.consultasMySQL.cerrarConexionBd();
                if (esCapitado == 0 || esCapitado == 1) {
                    switch (TipoFactura) {
                        case 1:
                            String sql = "SELECT f_liquidacion.TotalEps FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                            String valor = this.consultasMySQL.traerDato(sql);
                            this.consultasMySQL.cerrarConexionBd();
                            mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor);
                            if (op == 0) {
                                xarchivo = "F_NotaFCapitacionCarta";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                            } else {
                                xarchivo = "F_NotaFCapitacionCarta";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta", (Object[][]) mparametros, (Boolean) false);
                            }
                            break;
                        case 2:
                            String sql2 = "SELECT ROUND((f_liquidacion.TotalPaciente+f_liquidacion.Copago+f_liquidacion.CuotaModeradora)) AS total FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                            String valor2 = this.consultasMySQL.traerDato(sql2);
                            this.consultasMySQL.cerrarConexionBd();
                            mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor2);
                            if (op == 0) {
                                xarchivo = "F_NotaFCapitacionCartaUsuario";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                            } else {
                                xarchivo = "F_NotaFCapitacionCartaUsuario";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                            }
                            break;
                    }
                } else {
                    switch (TipoFactura) {
                        case 1:
                            String sql3 = "SELECT f_liquidacion.TotalPaciente FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_factura_evento.No_FacturaEvento = '" + NoFactura + "'";
                            String valor3 = this.consultasMySQL.traerDato(sql3);
                            this.consultasMySQL.cerrarConexionBd();
                            mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor3);
                            if (op == 0) {
                                xarchivo = "F_Liquidacion_Servicios";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                            } else {
                                xarchivo = "F_Liquidacion_Servicios";
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                            }
                            break;
                        case 2:
                            String sql4 = "SELECT f_liquidacion.TotalEps FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND IF(f_factura_evento.`Prefijo`='',f_factura_evento.No_FacturaEvento ,CONCAT(`Prefijo`,'-',f_factura_evento.No_FacturaEvento)) = '" + NoFactura + "'";
                            String valor4 = this.consultasMySQL.traerDato(sql4);
                            this.consultasMySQL.cerrarConexionBd();
                            mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor4);
                            if (op == 0) {
                                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    xarchivo = "F_Liquidacion_Servicios_Psiquiatras";
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    xarchivo = "F_Liquidacion_Servicios";
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                                } else {
                                    xarchivo = "F_FacturaEventoCarta";
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + xarchivo, (Object[][]) mparametros, (Boolean) false);
                                }
                            } else {
                                mImprimir_Factura(idIngreso.toString(), N_Ips, this.metodos.mConvertirNumeroLetras(valor4));
                            }
                            break;
                    }
                }
                xarchivo = this.metodos.getRutaRep() + xarchivo + ".pdf";
            }
        }
        return xarchivo;
    }

    public void impresionSolicitudesInternas(String idSolicitud) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = idSolicitud;
        mparametros[1][0] = "nbreUsuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "i_solicitud_pedido_interno", mparametros);
    }

    public List impresionSoporteAnexoPersona(Long idUsuario, Long idReporte, String rutaCarpeta) {
        String rutaFinal;
        List<String> archivo = new ArrayList<>();
        String directorio = this.metodos.mRutaSoporte("Persona");
        if (idUsuario.longValue() != 0 && idReporte.longValue() != 0) {
            try {
                String xsql = "SELECT\n\tgpd.Ruta\nFROM\n\tg_persona_documento gpd\ninner join g_tipo_documento_soporte gtds on\n\tgtds.Id = gpd.IdTipoDoc\nWHERE\n\tgpd.Estado = 1\n\tAND gpd.IdPersona = " + idUsuario + "\n\tAND gtds.IdReporte = " + idReporte;
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        if (Metodos.getSystemSO().contains("win")) {
                            rutaFinal = this.metodos.FileCopy(directorio + xrs.getString(1), rutaCarpeta, xrs.getString(1).replace(".pdf", "") + "AP_tmp.pdf");
                        } else {
                            rutaFinal = this.metodos.getFilePdfPath(directorio, xrs.getString(1), false);
                        }
                        if (!rutaFinal.isEmpty() && rutaFinal != null) {
                            archivo.add(rutaFinal);
                        } else {
                            archivo.add("");
                        }
                    }
                } else {
                    archivo.add("");
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            archivo.add("");
        }
        return archivo;
    }

    public List impresionSoportesEscaneadosIngreso(Long idIngreso, Long idReporte, String rutaCarpeta) {
        String rutaFinal;
        List<String> archivo = new ArrayList<>();
        String directorio = this.metodos.mRutaSoporte("JPIngresoDocumento");
        if (idIngreso.longValue() != 0 && idReporte.longValue() != 0) {
            try {
                String xsql = "SELECT\n  `Ruta`\nFROM\n  `ingreso_documento`\n  INNER JOIN `g_tipo_documento_soporte`\n    ON (g_tipo_documento_soporte.`Id` = `ingreso_documento`.`IdTipoDoc`)\nWHERE (\n    ingreso_documento.`Estado` = 1\n    AND g_tipo_documento_soporte.`Estado` = 1\n    AND `Id_Ingreso` = " + idIngreso + "\n    AND `g_tipo_documento_soporte`.`IdReporte` = " + idReporte + ")";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        if (Metodos.getSystemSO().contains("win")) {
                            rutaFinal = this.metodos.FileCopy(directorio + xrs.getString(1), rutaCarpeta, xrs.getString(1).replace(".pdf", "") + "F_tmp.pdf");
                        } else {
                            rutaFinal = this.metodos.getFilePdfPath(directorio, xrs.getString(1), false);
                        }
                        if (!rutaFinal.isEmpty() && rutaFinal != null) {
                            archivo.add(rutaFinal);
                        } else {
                            archivo.add("");
                        }
                    }
                } else {
                    archivo.add("");
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            archivo.add("");
        }
        return archivo;
    }

    public List impresionSoportesAtencionesManuales(Long idIngreso, Long idReporte, String rutaCarpeta) {
        List<String> archivo = new ArrayList<>();
        String directorio = this.metodos.mRutaSoporte("JIFCargarDocumentosHC");
        if (idIngreso.longValue() != 0 && idReporte.longValue() != 0) {
            try {
                String xsql = "SELECT\n  `Url`\nFROM\n  `h_atencionesmanuales`\n  INNER JOIN `h_tipodocumentoshc`\n    ON (h_tipodocumentoshc.`Id` = `h_atencionesmanuales`.`Id_TipoDoc`)\nWHERE (\n    h_atencionesmanuales.`Estado` = 0\n    AND h_atencionesmanuales.`Id_Ingreso` =  " + idIngreso + "\n    AND `h_tipodocumentoshc`.`IdReporte` = " + idReporte + " \n    )";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        if (Metodos.getSystemSO().contains("win")) {
                            this.metodos.FileCopy(directorio + xrs.getString(1), rutaCarpeta, xrs.getString(1).replace(".pdf", "") + "AM_tmp.pdf");
                        } else {
                            this.metodos.getFilePdfPath(directorio, xrs.getString(1), false);
                        }
                        String rutaFinal = this.metodos.getFilePdfPath(directorio, xrs.getString(1), false);
                        if (!rutaFinal.isEmpty() && rutaFinal != null) {
                            archivo.add(rutaFinal);
                        } else {
                            archivo.add("");
                        }
                    }
                } else {
                    archivo.add("");
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            archivo.add("");
        }
        return archivo;
    }

    public List impresionSoportesAyudasDX(Long idAtencion, Long idReporte, String rutaCarpeta) {
        String rutaFinal;
        List<String> archivo = new ArrayList<>();
        String directorio = this.metodos.mRutaSoporte("JPEscaneoDocumentosEnf");
        if (idAtencion.longValue() != 0 && idReporte.longValue() != 0) {
            try {
                String xsql = "SELECT\n  `Url`\nFROM\n  `h_resultadoayudasdx`\n  INNER JOIN `h_tipoayudadx`\n    ON (h_tipoayudadx.`Id` = `h_resultadoayudasdx`.`Id_TipoAyudaDX`)\nWHERE (\n    h_resultadoayudasdx.`Estado` = 0\n    AND `h_resultadoayudasdx`.`IdAtencion` =  " + idAtencion + "\n    AND `h_tipoayudadx`.`IdReporte` =  " + idReporte + " \n    )";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        if (Metodos.getSystemSO().contains("win")) {
                            rutaFinal = this.metodos.FileCopy(directorio + xrs.getString(1), rutaCarpeta, xrs.getString(1).replace(".pdf", "") + "DX_tmp.pdf");
                        } else {
                            rutaFinal = this.metodos.getFilePdfPath(directorio, xrs.getString(1), false);
                        }
                        System.out.println("---> " + rutaFinal);
                        if (!rutaFinal.isEmpty() && rutaFinal != null) {
                            archivo.add(rutaFinal);
                        } else {
                            archivo.add("");
                        }
                    }
                } else {
                    archivo.add("");
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            archivo.add("");
        }
        return archivo;
    }

    public void imprimirNotas(String idNota) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = idNota;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_NotasImpresa_1", mparametros);
        } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_NotasImpresa_2_SJorge", mparametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_NotasImpresa_2", mparametros);
        }
    }

    public void imprimirRegistroLlamadas(List<IGLlamadasProjection> listaLlamadas, GPersona gpersona) {
        RegistroLlamadasDTO registroLlamadas = new RegistroLlamadasDTO(listaLlamadas, gpersona);
        registroLlamadas.setInformacionIpsDTO(Principal.informacionIps);
        registroLlamadas.setRutaFirmas(this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra());
        registroLlamadas.setRutaSubReportes(this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra());
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_RegistroLlamadasUsuario", registroLlamadas, "H_RegistroLlamadasUsuario", true);
    }

    public void imprimirRegistroSeguimientosPosparto(List<HSeguimientoPospartoProjection> listaSeguimientos, GPersona gPersona) {
        SeguimientoPosparto registroSeguimientos = new SeguimientoPosparto(listaSeguimientos, gPersona);
        registroSeguimientos.setInformacionIpsDTO(Principal.informacionIps);
        registroSeguimientos.setRutaFirmas(this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra());
        registroSeguimientos.setRutaSubReportes(this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra());
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "RegistroSeguimientoPosparto", registroSeguimientos, "RegistroSeguimientoPosparto", true);
    }

    private List<String> imprimirHistoriaFisioTerapia(Long idUsuario, String fechaI, String fechaF) {
        List<String> archivo = new ArrayList<>();
        if (idUsuario.longValue() != 0) {
            String rutaTemp = this.metodos.mRutaSoporte("temp");
            String sql = "SELECT\n\tha.Id\nFROM\n\th_atencionf ha\ninner join h_seguimientof hs \non\n\t(hs.Id_AtencionF = ha.Id)\nWHERE\n\t(ha.Id_Usuario = " + idUsuario + "\n\t\tAND DATE_FORMAT(hs.FechaS, '%Y-%m-%d')>= '" + fechaI + "'\n\t\t\tAND DATE_FORMAT(hs.FechaS, '%Y-%m-%d')<= '" + fechaF + "'\n\t\t\t\tAND ha.Estado <>-1)\nGROUP BY\n\tha.Id";
            System.out.println(sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] parametros = new String[3][2];
                        parametros[0][0] = "idatencion1";
                        parametros[0][1] = xrs.getString(1);
                        parametros[1][0] = NOMBRE_SUBREPORT_DIR;
                        parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        parametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_HistoriaClinicaFT", (Object[][]) parametros, (Boolean) false);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "H_HistoriaClinicaFT.pdf", rutaTemp, "H_HistoriaClinicaFT" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    public List<String> imprimirRecibo(Long idIngreso) {
        List<String> archivo = new ArrayList<>();
        if (idIngreso.longValue() != 0) {
            String sql = "SELECT\n\tkr.Id as idRecibo,\n\tIF(fe.Id_EmpresaCont=6,(fl.TotalServicio-fl.TotalDescuento), (fl.TotalPaciente+fl.CuotaModeradora+fl.Copago)) AS total\nFROM\n\tk_recibos kr\ninner join f_liquidacion fl on (fl.Id_Ingreso=kr.Id_Ingreso)\ninner join ingreso i on (i.Id=fl.Id_Ingreso)\ninner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\nWHERE\n\t(kr.Id_Ingreso=" + idIngreso + "\n\t\tand kr.Estado = 0)";
            System.out.println(sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] parametros = new String[6][2];
                        parametros[0][0] = "idRecibo";
                        parametros[0][1] = xrs.getString("idRecibo");
                        parametros[1][0] = "VrLetras";
                        parametros[1][1] = this.metodos.mConvertirNumeroLetras(xrs.getString("total").replace(".", ","));
                        parametros[2][0] = "ruta";
                        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        parametros[3][0] = "IdCaja";
                        parametros[3][1] = "";
                        parametros[4][0] = NOMBRE_SUBREPORT_DIR;
                        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        parametros[5][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        archivo.add(this.metodos.getRutaRep() + "ReciboCaja.pdf");
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "ReciboCaja", parametros);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    public List<String> imprimirUnidosis(Long idAtencion) {
        List<String> archivo = new ArrayList<>();
        if (idAtencion.longValue() != 0) {
            String rutaTemp = this.metodos.mRutaSoporte("temp");
            String sql = "SELECT `h_ordenes_unidosis`.`Id` FROM `h_ordenes_unidosis` WHERE (`h_ordenes_unidosis`.`Id_Atencion` ='" + idAtencion + "' AND  `h_ordenes_unidosis`.Estado=1) ";
            System.out.println(sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[5][2];
                        mparametros[0][0] = "id";
                        mparametros[0][1] = xrs.getString("Id");
                        mparametros[1][0] = "nusuarios";
                        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                        mparametros[2][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[3][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[4][0] = "nbreUsuario";
                        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_H_ordene_unidosis", (Object[][]) mparametros, (Boolean) false);
                            String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + "Pajonal_H_ordene_unidosis.pdf", rutaTemp, "Pajonal_H_ordene_unidosis" + x + "_tmp.pdf");
                            System.out.println(rutaFinal);
                            archivo.add(rutaFinal);
                        } else {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_ordene_unidosis", (Object[][]) mparametros, (Boolean) false);
                            archivo.add(this.metodos.FileCopy(this.metodos.getRutaRep() + "H_ordene_unidosis.pdf", rutaTemp, "H_ordene_unidosis" + x + "_tmp.pdf"));
                        }
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return archivo;
    }

    private List<String> imprimirAtencionParto(Long idAtencion, String nombreReporte, String titulo, Boolean visualizar) {
        List<String> archivo = new ArrayList<>();
        try {
            if (idAtencion.longValue() != 0 && !nombreReporte.isEmpty()) {
                String rutaTemp = this.metodos.mRutaSoporte("temp");
                String xsql = "SELECT\n\thoq.Id\nFROM\n\th_orden_qx_procedimientos hoqp\nINNER JOIN h_orden_qx hoq \nON\n\t(hoq.Id = hoqp.Id_Orden_Qx)\nINNER JOIN g_procedimiento gp \nON\n\t(gp.Id = hoqp.Id_Procedimiento)\nWHERE\n\t(gp.Id IN (735930, 735910, 7359101, 7353001)\n\t\tAND hoq.Estado = 1\n\t\tAND IF(hoq.Fecha_Final IS NULL,0,1)= 1\n\t\t\tAND hoq.Id_Atencion = " + idAtencion + " )";
                ResultSet xrs = this.consultasMySQL.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        String[][] mparametros = new String[5][2];
                        mparametros[0][0] = "Id";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = NOMBRE_SUBREPORT_DIR;
                        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        mparametros[2][0] = NOMBRE_SUBREPORTFIRMA_DIR;
                        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        mparametros[3][0] = "tituloReporte";
                        mparametros[3][1] = titulo;
                        mparametros[4][0] = "nbreUsuario";
                        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + nombreReporte, mparametros, visualizar);
                        String rutaFinal = this.metodos.FileCopy(this.metodos.getRutaRep() + nombreReporte + ".pdf", rutaTemp, nombreReporte + "_" + x + "_tmp.pdf");
                        archivo.add(rutaFinal);
                        x++;
                    }
                }
                xrs.close();
                this.consultasMySQL.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return archivo;
    }
}
