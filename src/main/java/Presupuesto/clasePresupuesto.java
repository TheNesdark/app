package Presupuesto;

import Acceso.Principal;
import ComprasBS.JIFCotizacion;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR;
import com.genoma.plus.controller.presupuesto.JIFFMovimiento_new;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/clasePresupuesto.class */
public class clasePresupuesto {
    public Principal frmPrincipal;
    public JIFFMovimiento xJIFFMovimiento;
    private JIFCotizacion xJIFCotizacion;
    private JIFFCarguePTOInicial xJIFFCarguePTOInicial;
    private JIFConsultaRubros xJIFConsultaRubros;
    private JIFConsultaDec2193 xJIFConsultaDec2193;
    private JIFConsultaRubrosPeriodos xJIFConsultaRubrosPeriodos;
    private JIFBuscarDocPresup xJIFBuscarDocPresup;
    private JIFFOperacionPTO xJIFFOperacionPTO;
    public JIFFSolicitudPTO xJIFFSolicitudPTO;
    public JIFFMovimientoManual xJIFFMovimientoManual;
    private JIFMovManual xJIFMovManual;
    private JIFF_InformesCuentasxPagarPTO xJIFF_InformesCuentasxPagarPTO;
    private JIFFMovManualOP_PP xJIFFMovManualOP_PP;
    private JIFLibroPresupuestal xJIFLibroPresupuestal;
    public JIFAnularDocumento xJIFAnularDocumento;
    public JIFConsultarInformacionCGR consultarInformacionCGR;
    public JIFFSolicitudPTO_v2 xJIFFSolicitudPTO_v2;
    public JIFFMovimiento_new jIFFMovimiento_new;
    private JIF_Reportes_PyP_Generico jifreportes;
    public JIFFSolicitudPresupuestal jifsolicitud_new;
    public JIFCompromisoPresupuestal jifcompromisopresupuestal;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xMensaje = "";

    public clasePresupuesto(Principal xjfp) {
        this.frmPrincipal = xjfp;
        this.frmPrincipal.JLBPeridoC.setVisible(true);
        this.frmPrincipal.JLBPeridoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.RED));
    }

    public void buscar(String frm) {
        switch (frm) {
            case "xjifMovimientoPPTO":
                this.xJIFFMovimiento.mBuscar();
                return;
            case "xjifMovimientoPPTO_N":
                this.jIFFMovimiento_new.buscar();
                return;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO.mBuscar();
                return;
            case "xBuscarDocumPpto":
                this.xJIFBuscarDocPresup.mBuscar();
                return;
            case "jiffInformeCuentasxPagar":
                this.xJIFF_InformesCuentasxPagarPTO.mBuscar();
                return;
            case "jifLibroPresupuestal":
                this.xJIFLibroPresupuestal.mBuscar();
                return;
            case "xjifAnularDocumentos":
                this.xJIFAnularDocumento.mBuscaDocumento();
                return;
            case "xConsultaRubros":
                this.xJIFConsultaRubros.buscar();
                return;
            case "jifConsultarInformeCgrPresupuesto":
                this.consultarInformacionCGR.buscar();
                return;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2.mBuscar();
                return;
            case "jifMovManualOP_PP":
                this.xJIFFMovManualOP_PP.mBuscar();
                return;
            case "jifsolicitud_new":
                this.jifsolicitud_new.mBuscar();
                break;
            case "jifcompromisopresupuestal":
                break;
            default:
                return;
        }
        this.jifcompromisopresupuestal.buscar();
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Disponibilidad":
                this.xJIFFMovimiento = new JIFFMovimiento("9");
                Principal.cargarPantalla(this.xJIFFMovimiento);
                break;
            case "Disponibilidad_N":
                this.jIFFMovimiento_new = new JIFFMovimiento_new("9");
                Principal.cargarPantalla(this.jIFFMovimiento_new);
                break;
            case "Compromiso_N":
                this.jIFFMovimiento_new = new JIFFMovimiento_new("4");
                Principal.cargarPantalla(this.jIFFMovimiento_new);
                break;
            case "Compromiso":
                this.xJIFFMovimiento = new JIFFMovimiento("4");
                Principal.cargarPantalla(this.xJIFFMovimiento);
                break;
            case "Obligación":
                this.xJIFFMovimiento = new JIFFMovimiento("5");
                Principal.cargarPantalla(this.xJIFFMovimiento);
                break;
            case "Pagos":
                this.xJIFFMovimiento = new JIFFMovimiento("6");
                Principal.cargarPantalla(this.xJIFFMovimiento);
                break;
            case "Solicitudes":
                this.xJIFCotizacion = new JIFCotizacion("xjifSolicitudPTO");
                Principal.cargarPantalla(this.xJIFCotizacion);
                break;
            case "CargueInicial":
                this.xJIFFCarguePTOInicial = new JIFFCarguePTOInicial();
                Principal.cargarPantalla(this.xJIFFCarguePTOInicial);
                break;
            case "xConsultaRubros":
                this.xJIFConsultaRubros = new JIFConsultaRubros();
                Principal.cargarPantalla(this.xJIFConsultaRubros);
                break;
            case "xConsultaDec2193":
                this.xJIFConsultaDec2193 = new JIFConsultaDec2193();
                Principal.cargarPantalla(this.xJIFConsultaDec2193);
                break;
            case "xConsultaRubrosPer":
                this.xJIFConsultaRubrosPeriodos = new JIFConsultaRubrosPeriodos();
                Principal.cargarPantalla(this.xJIFConsultaRubrosPeriodos);
                break;
            case "xBuscarDocumPpto":
                this.xJIFBuscarDocPresup = new JIFBuscarDocPresup();
                Principal.cargarPantalla(this.xJIFBuscarDocPresup);
                break;
            case "Operaciones":
                this.xJIFFOperacionPTO = new JIFFOperacionPTO();
                Principal.cargarPantalla(this.xJIFFOperacionPTO);
                break;
            case "SolicitudDisponibilidad":
                if (Principal.informacionIps.getTiposolicitudcdp() == 1) {
                    this.xJIFFSolicitudPTO_v2 = new JIFFSolicitudPTO_v2();
                    Principal.cargarPantalla(this.xJIFFSolicitudPTO_v2);
                    break;
                } else {
                    this.xJIFFSolicitudPTO = new JIFFSolicitudPTO();
                    Principal.cargarPantalla(this.xJIFFSolicitudPTO);
                    break;
                }
                break;
            case "xMovManuales":
                this.xJIFFMovimientoManual = new JIFFMovimientoManual();
                Principal.cargarPantalla(this.xJIFFMovimientoManual);
                break;
            case "xMovimientosManuales":
                this.xJIFMovManual = new JIFMovManual();
                Principal.cargarPantalla(this.xJIFMovManual);
                break;
            case "jiffInformeCuentasxPagar":
                this.xJIFF_InformesCuentasxPagarPTO = new JIFF_InformesCuentasxPagarPTO();
                Principal.cargarPantalla(this.xJIFF_InformesCuentasxPagarPTO);
                break;
            case "Movimientos_Manuales_OB_PP":
                this.xJIFFMovManualOP_PP = new JIFFMovManualOP_PP();
                Principal.cargarPantalla(this.xJIFFMovManualOP_PP);
                break;
            case "Libros Presupuestales":
                this.xJIFLibroPresupuestal = new JIFLibroPresupuestal();
                Principal.cargarPantalla(this.xJIFLibroPresupuestal);
                break;
            case "AnulaDocPresupuesto":
                this.xJIFAnularDocumento = new JIFAnularDocumento();
                Principal.cargarPantalla(this.xJIFAnularDocumento);
                break;
            case "Informes CGR":
                this.consultarInformacionCGR = new JIFConsultarInformacionCGR();
                Principal.cargarPantalla(this.consultarInformacionCGR);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(26, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
            case "Solicitud (Nueva Beta)":
                this.jifsolicitud_new = new JIFFSolicitudPresupuestal();
                Principal.cargarPantalla(this.jifsolicitud_new);
                break;
            case "Compromiso (Nuevo Beta)":
                this.jifcompromisopresupuestal = new JIFCompromisoPresupuestal("4");
                Principal.cargarPantalla(this.jifcompromisopresupuestal);
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "xjifMovimientoPPTO":
                this.xJIFFMovimiento.mGrabar();
                break;
            case "xjifMovimientoPPTO_N":
                this.jIFFMovimiento_new.grabar();
                break;
            case "xjifPTOInicial":
                this.xJIFFCarguePTOInicial.mGrabar();
                break;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO.mGrabar();
                break;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2.mGrabar();
                break;
            case "jifsolicitud_new":
                this.jifsolicitud_new.mGrabar();
                break;
            case "jifcompromisopresupuestal":
                this.jifcompromisopresupuestal.grabar();
                break;
        }
        if (frm.equals("xjifMovimientoManual")) {
            this.xJIFFMovimientoManual.mGrabar();
        }
        if (frm.equals("jifMovimientoManual")) {
            this.xJIFMovManual.mGrabar();
        } else if (frm.equals("jifMovManualOP_PP")) {
            this.xJIFFMovManualOP_PP.mGrabar();
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "xjifMovimientoPPTO":
                this.xJIFFMovimiento.mNuevo();
                return;
            case "xjifMovimientoPPTO_N":
                this.jIFFMovimiento_new.nuevo();
                return;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO.mNuevo();
                return;
            case "xjifMovimientoManual":
                this.xJIFFMovimientoManual.mNuevo();
                return;
            case "xConsultaDec2193":
                this.xJIFConsultaDec2193.mNuevo();
                return;
            case "jifMovManualOP_PP":
                this.xJIFFMovManualOP_PP.mNuevo();
                return;
            case "jifConsultarInformeCgrPresupuesto":
                this.consultarInformacionCGR.nuevo();
                return;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2.mNuevo();
                return;
            case "jifsolicitud_new":
                this.jifsolicitud_new.mNuevo();
                break;
            case "jifcompromisopresupuestal":
                break;
            default:
                return;
        }
        this.jifcompromisopresupuestal.nuevo();
    }

    public void mAnular(String frm) {
        switch (frm) {
            case "xjifMovimientoManual":
                this.xJIFFMovimientoManual.mAnular();
                break;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO.mAnular();
                break;
            case "xjifMovimientoPPTO":
                this.xJIFFMovimiento.mAnular();
                break;
            case "xjifAnularDocumentos":
                this.xJIFAnularDocumento.mAnular();
                break;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2.mAnular();
                break;
            case "jifsolicitud_new":
                this.jifsolicitud_new.mAnular();
                break;
            case "xjifMovimientoPPTO_N":
                this.jIFFMovimiento_new.mAnular();
                break;
            case "jifcompromisopresupuestal":
                this.jifcompromisopresupuestal.mAnular();
                break;
        }
    }

    public void mImprimir(String frm) {
        switch (frm) {
            case "xjifMovimientoPPTO":
                this.xJIFFMovimiento.mImiprimir();
                break;
            case "xjifMovimientoPPTO_N":
                this.jIFFMovimiento_new.imprimir();
                break;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO.mImprimir();
                break;
            case "xConsultaRubros":
                this.xJIFConsultaRubros.mImprimir();
                break;
            case "xBuscarDocumPpto":
                this.xJIFBuscarDocPresup.mImprimir();
                break;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2.mImprimir();
                break;
            case "jifsolicitud_new":
                this.jifsolicitud_new.mImprimir();
                break;
            case "jifcompromisopresupuestal":
                this.jifcompromisopresupuestal.imprimir();
                break;
        }
    }

    public String mValidarAnulado(String xIdDOcumento, String xIdTipoDoc) {
        String xsql = null;
        if (xIdTipoDoc.equals("4")) {
            xsql = "SELECT CONCAT(`pp_tipo_documentos`.`Nbre` ,' : ', GROUP_CONCAT(`pp_movimiento`.`Id` ORDER BY `pp_movimiento`.`Id` ASC SEPARATOR ',' )) N\nFROM `pp_detalle_movimiento` INNER JOIN `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nINNER JOIN `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` IN(12,13,5, 14,15,6) AND `pp_movimiento`.`IdCompromiso` ='" + xIdDOcumento + "' AND pp_detalle_movimiento.`Estado`=1)\nGROUP BY `pp_tipo_documentos`.`Id`";
        } else if (xIdTipoDoc.equals("5")) {
            xsql = "SELECT CONCAT(`pp_tipo_documentos`.`Nbre` ,' : ', GROUP_CONCAT(`pp_movimiento`.`Id` ORDER BY `pp_movimiento`.`Id` ASC SEPARATOR ',' )) N\nFROM `pp_detalle_movimiento` INNER JOIN `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nINNER JOIN `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` IN(14,15,6) AND `pp_movimiento`.`IdObligacion` ='" + xIdDOcumento + "' AND pp_detalle_movimiento.`Estado`=1)\nGROUP BY `pp_tipo_documentos`.`Id`";
        } else if (xIdTipoDoc.equals("9")) {
            xsql = "SELECT CONCAT(`pp_tipo_documentos`.`Nbre` ,' : ', GROUP_CONCAT(`pp_movimiento`.`Id` ORDER BY `pp_movimiento`.`Id` ASC SEPARATOR ',' )) N\nFROM `pp_detalle_movimiento` INNER JOIN `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nINNER JOIN `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` IN(10,11, 12,13,5, 14,15,6) AND `pp_movimiento`.`IdDisponibilidad` ='" + xIdDOcumento + "' AND pp_detalle_movimiento.`Estado`=1)\nGROUP BY `pp_tipo_documentos`.`Id`";
        }
        System.out.println("" + xsql);
        try {
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.last();
                int xFila = xrs.getRow();
                if (xFila == 0) {
                    xrs.first();
                    setxMensaje(xrs.getString(1));
                } else {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        setxMensaje(getxMensaje() + "\n" + xrs.getString(1));
                    }
                }
            } else {
                setxMensaje("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(clasePresupuesto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return getxMensaje();
    }

    public void mAnularMovimiento(String xId, String xMotivo, String xId_Mov, String xNombreObjeto) {
        String idDisp = null;
        String sql = "SELECT `IdDisponibilidad` FROM `pp_movimiento` WHERE id = '" + xId_Mov + "'";
        System.out.println("buscar disponibilidad -> " + sql);
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                idDisp = xrs.getString("IdDisponibilidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(clasePresupuesto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        String xsql = "update pp_movimiento set Id_MotivoAnulacion='" + xId + "', Observacion_Anul='" + xMotivo + "', FechaAnulacion= now(), Usuario_Anul='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' Where Id='" + xId_Mov + "'";
        System.out.println("Anular movimiento -> " + xsql);
        this.xct.ejecutarSQL(xsql);
        if (xNombreObjeto.equals("COMPROMISO PRESUPUESTAL")) {
            String xsql2 = "update pp_movimiento set `IdCompromiso`=0 ,`IdDisponibilidad`=0 , `IdObligacion`=0  Where Id='" + xId_Mov + "'";
            System.out.println(xsql2);
            this.xct.ejecutarSQL(xsql2);
            String sql2 = "update pp_movimiento set `IdCompromiso`=0  Where Id='" + idDisp + "'";
            System.out.println(sql2);
            this.xct.ejecutarSQL(sql2);
        }
        String xsql3 = "update pp_detalle_movimiento set Estado=0 where Id_Movimiento='" + xId_Mov + "'";
        System.out.println("Anular detalle -> " + xsql3);
        this.xct.ejecutarSQL(xsql3);
        this.xct.cerrarConexionBd();
    }

    public void mAnulaMovimientoPTO(String xId, String xMotivo, String xId_Mov) {
        String xsql = "update pp_movimiento set Id_MotivoAnulacion='" + xId + "', Observacion_Anul='" + xMotivo + "', FechaAnulacion= now(), Usuario_Anul='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' Where Id='" + xId_Mov + "'";
        System.out.println("Anula Encabezado-->" + xsql);
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
        String xIdTipoDocumento = "";
        String xIdDisponibilidad = "";
        String xIdCompromiso = "";
        String xsql2 = "update pp_detalle_movimiento set Estado=0 where Id_Movimiento='" + xId_Mov + "'";
        System.out.println("Anula detalle-->" + xsql2);
        this.xct.ejecutarSQL(xsql2);
        this.xct.cerrarConexionBd();
        String xsql3 = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`Id_TipoDoc`\n    , `pp_movimiento`.`IdDisponibilidad`\n    , `pp_movimiento`.`IdCompromiso`\n    , `pp_movimiento`.`IdObligacion`\n    , `pp_tipo_documentos`.`Id_ClaseDoc`\nFROM\n    `baseserver`.`pp_movimiento`\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_movimiento`.`Id` =" + xId_Mov + ");";
        try {
            System.out.println("consulta " + xsql3);
            ResultSet xrs = this.xct.traerRs(xsql3);
            if (xrs.next()) {
                xrs.last();
                int xFila = xrs.getRow();
                if (xFila == 0) {
                    xrs.first();
                    xIdTipoDocumento = xrs.getString(6);
                    xIdDisponibilidad = xrs.getString(3);
                    xIdCompromiso = xrs.getString(4);
                    System.out.println("tipo Movimiento" + xIdTipoDocumento);
                } else {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        xIdTipoDocumento = xrs.getString(6);
                        xIdDisponibilidad = xrs.getString(3);
                        xIdCompromiso = xrs.getString(4);
                        System.out.println("tipo Movimiento" + xIdTipoDocumento);
                    }
                }
            }
            System.out.println("tipo Movimiento" + xIdTipoDocumento);
        } catch (Exception e) {
        }
        if (xIdTipoDocumento.equals("4")) {
            xsql3 = "UPDATE `pp_movimiento` SET `pp_movimiento`.`IdCompromiso` =0 WHERE (`pp_movimiento`.`Id`=" + xIdDisponibilidad + ")";
        } else if (xIdTipoDocumento.equals("5")) {
            xsql3 = "UPDATE `pp_movimiento` SET `pp_movimiento`.`IdObligacion` =0 WHERE (`pp_movimiento`.`Id`=" + xIdCompromiso + ")";
        }
        System.out.println("libera el movimiento anterior" + xsql3);
        this.xct.ejecutarSQL(xsql3);
        this.xct.cerrarConexionBd();
    }

    public void mAnularSolicitud(String xId, String xMotivo, String xId_Mov) {
        String xsql = "update cc_r_requisicion set Estado=0, Id_MotivoAnulacion='" + xId + "', Observacion_Anul='" + xMotivo + "', Fecha_Anul= now(), Usuario_Anul='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' Where Id='" + xId_Mov + "'";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    public void mAnularSolicitudPTOV2(String xId, String xMotivo, String xId_Mov) {
        try {
            String xsql = "update pp_solicitud_pto set Estado=0, Id_MotivoAnulacion='" + xId + "', Observacion_Anul='" + xMotivo + "', Fecha_Anul= now(), Uuario_Anul ='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' Where Id='" + xId_Mov + "'";
            System.out.println(xsql);
            this.xct.ejecutarSQL(xsql);
            this.xct.cerrarConexionBd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getxMensaje() {
        return this.xMensaje;
    }

    public void setxMensaje(String xMensaje) {
        this.xMensaje = xMensaje;
    }
}
