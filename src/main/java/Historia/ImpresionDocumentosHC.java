package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.Clap;
import com.genoma.plus.controller.historia.ClapV2;
import com.genoma.plus.controller.historia.JPAFamiliograma;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.border.Border;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: GenomaP.jar:Historia/ImpresionDocumentosHC.class */
public class ImpresionDocumentosHC {
    private Object[] xdato;
    private JPAFamiliograma xJPAFamiliograma;
    private JPGraficasCyDImpresion xJPGraficasCyDImpresion;
    private JPGraficasPrenatalImpresion xJPGraficasPrenatalImpresion;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public void mImprimirOrdenesAyudasDx(int NCantidad, int xIdServicio, Long xNOrden, int xforma) {
        Metodos xmts = new Metodos();
        for (int i = 1; i <= NCantidad; i++) {
            if (xIdServicio == 2) {
                try {
                    String xpeso = "";
                    String xtalla = "";
                    String xnstiker = "1";
                    String xsql = "SELECT h_examenfisico.Talla , h_examenfisico.Peso FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + xNOrden + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                    ResultSet xrs = this.xct.traerRs(xsql);
                    if (xrs.next()) {
                        xrs.first();
                        xtalla = xrs.getString(1);
                        xpeso = xrs.getString(2);
                    }
                    xrs.close();
                    this.xct.cerrarConexionBd();
                    String xsql2 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + xNOrden + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                    ResultSet rs = this.xct.traerRs(xsql2);
                    if (rs.next()) {
                        rs.last();
                        xnstiker = String.valueOf(rs.getRow());
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                    String[][] mparametros = new String[6][2];
                    mparametros[0][0] = "idorden";
                    mparametros[0][1] = String.valueOf(xNOrden);
                    mparametros[1][0] = "talla";
                    mparametros[1][1] = "TALLA : " + xtalla;
                    mparametros[2][0] = "peso";
                    mparametros[2][1] = "PESO : " + xpeso;
                    mparametros[3][0] = "ns";
                    mparametros[3][1] = "N° Stiker : " + xnstiker;
                    mparametros[4][0] = "SUBREPORT_DIR";
                    mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        xmts.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL.jasper", mparametros);
                    } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL1.jasper", mparametros);
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL2.jasper", mparametros);
                        }
                    } else if (xforma == 0) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL", mparametros);
                            } else {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                            } else {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                            }
                        }
                    } else if (xforma == 1) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital.jasper", mparametros);
                            } else {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL1.jasper", mparametros);
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital.jasper", mparametros);
                            } else {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL1.jasper", mparametros);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else {
                String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + xNOrden + "'";
                String nota = this.xct.traerDato(sql);
                this.xct.cerrarConexionBd();
                String horario = "";
                if (xIdServicio == 3) {
                    horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
                }
                String[][] mparametros2 = new String[6][2];
                mparametros2[0][0] = "idorden";
                mparametros2[0][1] = String.valueOf(xNOrden);
                mparametros2[1][0] = "idservicio";
                mparametros2[1][1] = String.valueOf(xIdServicio);
                mparametros2[2][0] = "nota";
                mparametros2[2][1] = nota;
                mparametros2[3][0] = "horario";
                mparametros2[3][1] = horario;
                mparametros2[4][0] = "SUBREPORT_DIR";
                mparametros2[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros2[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO.jasper", mparametros2);
                } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL1.jasper", mparametros2);
                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL2.jasper", mparametros2);
                    }
                } else if (xforma == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xmt.PresentacionPreliminar(this.xmt.getRutaRep() + "RProcedimientosO1.jasper", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                            this.xmt.PresentacionPreliminar(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        } else {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                        }
                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xmt.PresentacionPreliminar(this.xmt.getRutaRep() + "RProcedimientosO1.jasper", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                            this.xmt.PresentacionPreliminar(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        } else {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                        }
                    }
                } else if (xforma == 1) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO1.jasper", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        } else {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        }
                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO1.jasper", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        } else {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                        }
                    }
                }
            }
        }
    }

    public void mImpirmirConceptoSoIngreso(String xIdConcepto) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xIdConcepto;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Mineros", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado", mparametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado_1", mparametros);
        }
    }

    public void mImprimirConceptoSoEgreso(String xIdConcepto) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xIdConcepto;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud", mparametros);
        }
    }

    public void mImprimirNotasClinciasNuevas(String xFitlroIn, String xTitulo, String xNombreReporte, int filtroVista, String idAtencion, String idUsuario, String idIngreso, boolean enviarCorreo, String correoUsuario) {
        System.out.println("xFitlroIn---- " + xFitlroIn);
        System.out.println("xTitulo---- " + xTitulo);
        System.out.println("xNombreReporte---- " + xNombreReporte);
        System.out.println("filtroVista---- " + filtroVista);
        System.out.println("idAtencion -- --- " + idAtencion);
        System.out.println("idUsuario ------- " + idUsuario);
        System.out.println("idIngreso ----- " + idIngreso);
        String[][] mparametros = new String[8][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = idAtencion;
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = idUsuario;
        mparametros[2][0] = "idingreso";
        mparametros[2][1] = idIngreso;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[5][0] = "filtroIn";
        mparametros[5][1] = xFitlroIn;
        mparametros[6][0] = "xTitulo";
        mparametros[6][1] = xTitulo;
        mparametros[7][0] = "OS";
        mparametros[7][1] = System.getProperty("os.name").substring(0, 3);
        switch (filtroVista) {
            case 0:
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + xNombreReporte, mparametros);
                break;
            case 1:
                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + xNombreReporte + ".jasper", mparametros);
                break;
            default:
                this.xmt.EnviarPDFGeneradoHC(xTitulo.toUpperCase(), this.xmt.getRutaRep() + xNombreReporte, mparametros, true, enviarCorreo, correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                break;
        }
    }

    public void mImprimirNotasClinciasNuevasIdNota(String xTitulo, String xNombreReporte, String idAtencion, String idNota) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = idAtencion;
        mparametros[1][0] = "idNota";
        mparametros[1][1] = idNota;
        mparametros[2][0] = "xTitulo";
        mparametros[2][1] = xTitulo;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + xNombreReporte, mparametros);
    }

    public void mImprimirFamiliograma(int idAtencion) throws SQLException {
        try {
            FileUtils.cleanDirectory(new File(this.xmt.mRutaSoporte("GraficoFamiliograma")));
            FileUtils.cleanDirectory(new File(this.xmt.mRutaSoporte("GraficoEcomapa")));
            String xsql = "SELECT\n    `ingreso`.`Id_Usuario`\n    , `ingreso`.`FechaIngreso`\n    , `h_atencion`.`Id`\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Id` =" + idAtencion + ");";
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                rs.last();
                int id = rs.getInt(1);
                String FechaR = rs.getString(2);
                this.xJPAFamiliograma = new JPAFamiliograma(idAtencion, FechaR, id);
                System.err.println(FechaR + "  " + id);
            }
        } catch (IOException ex) {
            Logger.getLogger(ImpresionDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGenerarGraficas(String IdPrograma, String IdPersona, String IdAtencion) {
        if (IdPrograma.equals("3")) {
            String idUserP = mConsultaIdUsuarioPrograma(IdPrograma, IdPersona, IdAtencion);
            if (idUserP != null && !idUserP.equals("")) {
                try {
                    FileUtils.cleanDirectory(new File(this.xmt.mRutaSoporte("jpaexamenfisicoprenatal")));
                    mRenderizarPanelGraficoPrenatal(Long.parseLong(IdPersona), Long.parseLong(idUserP));
                    mGenerarGraficaPrenatal();
                } catch (IOException ex) {
                    Logger.getLogger(ImpresionDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        } else if (IdPrograma.equals("4")) {
            String idUserP2 = mConsultaIdUsuarioPrograma(IdPrograma, IdPersona);
            if (idUserP2 != null && !idUserP2.equals("")) {
                try {
                    FileUtils.cleanDirectory(new File(this.xmt.mRutaSoporte("GraficasCyD")));
                    mRenderPanelGraficasCyD(Long.parseLong(IdPersona), Long.parseLong(idUserP2));
                    mGeneraGraficaCyD();
                } catch (IOException ex2) {
                    Logger.getLogger(ImpresionDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
            this.xmt.imprimirEscalaAbreviadaDeDesarrollo(IdAtencion, Long.valueOf(IdPersona).longValue());
        }
        try {
            mImprimirFamiliograma(Integer.parseInt(IdAtencion));
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void mRenderPanelGraficasCyD(long idUsuarioA, long idUsuarioPrograma) {
        this.xJPGraficasCyDImpresion = new JPGraficasCyDImpresion(idUsuarioA, idUsuarioPrograma);
        this.xJPGraficasCyDImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS CyD", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasCyDImpresion.setVisible(true);
        this.xJPGraficasCyDImpresion.setBounds(-10, 0, 896, 570);
        JDialog x = new JDialog();
        x.add(this.xJPGraficasCyDImpresion);
        x.setSize(200, 100);
        x.setLocationRelativeTo((Component) null);
        x.setVisible(true);
        x.dispose();
    }

    private void mGeneraGraficaCyD() {
        this.xJPGraficasCyDImpresion.mGeneraGrafico_ScreenShot();
    }

    private String mConsultaIdUsuarioPrograma(String IdPrograma, String IdPersona) {
        String idUsuarioPrograma = "";
        String sql = "SELECT Id FROM `g_usuarioxprograma` \nWHERE g_usuarioxprograma.`Id_Usuario`='" + IdPersona + "' AND Id_Programa=" + IdPrograma;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                idUsuarioPrograma = xrs.getString("Id");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idUsuarioPrograma;
    }

    private String mConsultaIdUsuarioPrograma(String IdPrograma, String IdPersona, String IdAtencion) {
        String idUsuarioPrograma = "";
        String sql = "SELECT g_usuarioxprograma.`Id`\nFROM\n    `baseserver`.`g_usuarioxprograma`\n    INNER JOIN `baseserver`.`h_examenfisico` \n        ON (`g_usuarioxprograma`.`Id` = `h_examenfisico`.`Id_Usuario_Programa`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)\n          WHERE g_usuarioxprograma.`Id_Usuario`=" + IdPersona + " AND Id_Programa=" + IdPrograma + " AND h_atencion.`Id`= " + IdAtencion;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                idUsuarioPrograma = xrs.getString("Id");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idUsuarioPrograma;
    }

    private void mRenderizarPanelGraficoPrenatal(long idUsuarioA, long idUsuarioPrograma) {
        JDialog prueba = new JDialog();
        this.xJPGraficasPrenatalImpresion = new JPGraficasPrenatalImpresion(idUsuarioA, idUsuarioPrograma);
        this.xJPGraficasPrenatalImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS PRENATAL", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasPrenatalImpresion.setVisible(true);
        this.xJPGraficasPrenatalImpresion.setBounds(-50, 0, 896, 570);
        prueba.add(this.xJPGraficasPrenatalImpresion);
        prueba.setSize(600, 700);
        prueba.setVisible(true);
        prueba.dispose();
    }

    private void mGenerarGraficaPrenatal() {
        this.xJPGraficasPrenatalImpresion.GenerarScreeshot();
    }

    public void GenerarCLAP(String IdPersona, String idAtencion) {
        String idUserP = mConsultaIdUsuarioPrograma("3", IdPersona, idAtencion);
        if (!idUserP.equals("") && !idUserP.isEmpty()) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                new ClapV2(Long.valueOf(idUserP));
            } else {
                new Clap(Long.valueOf(idUserP));
            }
        }
    }

    public void imprimirConsentimientoInformado(String idConsentimiento) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idConsentimiento";
        mparametros[0][1] = idConsentimiento;
        mparametros[1][0] = "usuarioSistemas";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        System.out.println("-> " + this.xmt.getRutaRep());
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ConsentimientoInformado", mparametros);
    }
}
