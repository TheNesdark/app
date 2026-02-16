package Caja;

import Acceso.Principal;
import Contabilidad.JIFSolicitudReembolsoCMV2;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.caja.JIFAsigancionReciboIngresos;
import com.genoma.plus.controller.caja.JIFRecibosEgresos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Caja/claseCaja.class */
public class claseCaja {
    public Cierre frmCierre;
    public Recibos frmRecibos;
    private Consolidado frmConsolidado;
    private CambiarDatos frmCambiarD;
    private String sql;
    private String fechacactual;
    private String CDebito;
    private String CCredito;
    public Principal frmPrincipal;
    private int modulo;
    private JIFConsultarRecibosC xjifconsultar_recibos;
    private JIFAsigancionReciboIngresos xJIFAsigancionReciboIngresos;
    public JIFRecibosEgresos xJIFRecibosEgresos;
    public JIFCierreEgresos xJIFCierreEgresos;
    private JIFSolicitudReembolsoCMV2 jIFSolicitudReembolsoCMV2;
    private JIF_Reportes_PyP_Generico jifreportes;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int idCaja = 0;
    private int inicioTurno = 1;
    private String nbreCaja = "";
    private int cajaAbierta = 1;

    public claseCaja(Principal frmP, int xmodulo) {
        this.frmPrincipal = frmP;
        this.modulo = xmodulo;
    }

    public void anular(String frm) {
        switch (frm) {
            case "Recibos":
                this.frmRecibos.anular();
                break;
            case "Cierre":
                this.frmCierre.anular();
                break;
            case "Consolidado":
                this.frmConsolidado.anular();
                break;
            case "xjifrecibosegresos":
                this.xJIFRecibosEgresos.anular();
                break;
            case "xjifcierreegresos":
                this.xJIFCierreEgresos.anular();
                break;
        }
    }

    public void anularRecibo(String idMotivo, String xobservacion) {
        this.sql = "UPDATE k_recibos SET  Estado ='" + idMotivo + "', ObservacionAnulado='" + xobservacion + "', UsuarioA='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', FechaA='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' WHERE (Id='" + this.frmRecibos.getIdRecibo() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.frmRecibos.txtEstado.setText("!!!ANULADO!!!");
        this.frmRecibos.txtEstado.setDisabledTextColor(Color.red);
        this.metodos.mostrarMensaje("Recibo ANULADO");
    }

    public void abrirCierre() {
        this.sql = "INSERT INTO k_cierre (Id_Caja, Id_Usuario, FechaInicio, Fecha, UsuarioS) VALUES ('" + getIdCaja() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void buscar(String frm) {
        switch (frm) {
            case "Recibos":
                this.frmRecibos.buscar();
                break;
            case "Cierre":
                this.frmCierre.buscar();
                break;
            case "Consolidado":
                this.frmConsolidado.buscar();
                break;
            case "xjifconsultar_reciboc":
                this.xjifconsultar_recibos.mBuscar();
                break;
            case "xjifasignacionreciboingresos":
                this.xJIFAsigancionReciboIngresos.mBuscar();
                break;
            case "xjifrecibosegresos":
                this.xJIFRecibosEgresos.mBuscar();
                break;
            case "jifSolicitudReembolso":
                this.jIFSolicitudReembolsoCMV2.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Recibos":
                this.frmRecibos = new Recibos(this);
                Principal.cargarPantalla(this.frmRecibos);
                break;
            case "Cierre":
                this.frmCierre = new Cierre(this);
                Principal.cargarPantalla(this.frmCierre);
                break;
            case "Consolidado":
                this.frmConsolidado = new Consolidado(this);
                Principal.cargarPantalla(this.frmConsolidado);
                break;
            case "CambiarDatos":
                this.frmCambiarD = new CambiarDatos(null, true);
                this.frmCambiarD.setVisible(true);
                break;
            case "Consultar Recibos":
                this.xjifconsultar_recibos = new JIFConsultarRecibosC("xjifconsultar_reciboc");
                Principal.cargarPantalla(this.xjifconsultar_recibos);
                break;
            case "Asinacion de Ingresos a Recibos de Caja":
                this.xJIFAsigancionReciboIngresos = new JIFAsigancionReciboIngresos();
                Principal.cargarPantalla(this.xJIFAsigancionReciboIngresos);
                break;
            case "Recibos Egresos":
                this.xJIFRecibosEgresos = new JIFRecibosEgresos(this);
                Principal.cargarPantalla(this.xJIFRecibosEgresos);
                break;
            case "Cierre de Egresos":
                this.xJIFCierreEgresos = new JIFCierreEgresos(this);
                Principal.cargarPantalla(this.xJIFCierreEgresos);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(12, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void desplazar(String frm, int boton) {
    }

    public int getCajaAbierta() {
        return this.cajaAbierta;
    }

    public int getIdCaja() {
        return this.idCaja;
    }

    public int getModulo() {
        return this.modulo;
    }

    public String getNbreCaja() {
        return this.nbreCaja;
    }

    public String getCDebito() {
        return this.CDebito;
    }

    public String getCCredito() {
        return this.CCredito;
    }

    public String getFechaUltimoCierre() {
        this.sql = "SELECT MAX(DATE_FORMAT(FechaFinal, '%Y/%m/%d %h:%i:%s %p')) FROM k_cierre WHERE (Id_Caja ='" + getIdCaja() + "' AND Id_Usuario ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        String dato = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return dato;
    }

    public String getFechaCierreActual() {
        return this.fechacactual;
    }

    public String getUltimoNoRecibo() {
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.sql = "SELECT  ifnull((max(`NoRecibo`)+1),1)NRecibo FROM `k_recibos_n` WHERE (`Id_Caja` ='" + getIdCaja() + "')";
        } else {
            this.sql = "SELECT  ifnull((max(`NoRecibo`)+1),1)NRecibo FROM `k_recibos` WHERE (`Id_Caja` ='" + getIdCaja() + "')";
        }
        String dato = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return dato;
    }

    public void grabar(String frm) {
        if (frm.equals("Recibos")) {
            this.frmRecibos.grabar();
            return;
        }
        if (frm.equals("Cierre")) {
            this.frmCierre.mGrabar();
            return;
        }
        if (frm.equals("Consolidado")) {
            this.frmConsolidado.grabar();
            return;
        }
        if (frm.equals("xjifasignacionreciboingresos")) {
            this.xJIFAsigancionReciboIngresos.mGrabar();
        } else if (frm.equals("xjifrecibosegresos")) {
            this.xJIFRecibosEgresos.mGuardar();
        } else if (frm.equals("xjifcierreegresos")) {
            this.xJIFCierreEgresos.mGrabar();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("Recibos")) {
            this.frmRecibos.imprimir();
        }
        if (frm.equals("xjifconsultar_reciboc")) {
            this.xjifconsultar_recibos.mImprimir();
        } else if (frm.equals("Consolidado")) {
            this.frmConsolidado.mImprimir();
        } else if (frm.equals("xjifrecibosegresos")) {
            this.xJIFRecibosEgresos.mImprimir();
        }
    }

    public void imprimirCierre(String IdCierre) {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idCierre";
        parametros[0][1] = IdCierre;
        parametros[1][0] = "VrLetras";
        parametros[1][1] = "Valor en letras pendiente";
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(parametros[2][1] + "RelacionRecibos", parametros);
        this.metodos.GenerarPDF(parametros[2][1] + "RelacionRecibosxConcepto", parametros);
        this.metodos.GenerarPDF(parametros[2][1] + "RelacionRecibosAnulados", parametros);
        this.consultas.cerrarConexionBd();
    }

    public void imprimirCierreEgresos(String IdCierre) {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idCierre";
        parametros[0][1] = IdCierre;
        parametros[1][0] = "VrLetras";
        parametros[1][1] = "Valor en letras pendiente";
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(parametros[2][1] + "RelacionRecibosEgresos", parametros);
        this.consultas.cerrarConexionBd();
    }

    public void imprimirListado(String fechaIni, String fechaFin, String idEmpresa, String nbreEmpresa, String idCC) {
        String[][] parametros = new String[8][2];
        parametros[0][0] = "fechaIni";
        parametros[0][1] = fechaIni;
        parametros[1][0] = "fechaFin";
        parametros[1][1] = fechaFin;
        parametros[2][0] = "idEmpresa";
        parametros[2][1] = idEmpresa;
        parametros[3][0] = "nbreEmpresa";
        parametros[3][1] = nbreEmpresa;
        parametros[4][0] = "idCC";
        parametros[4][1] = idCC;
        parametros[5][0] = "ruta";
        parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[6][0] = "SUBREPORT_DIR";
        parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[7][0] = "SUBREPORTFIRMA_DIR";
        parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(parametros[5][1] + "RelacionRecibosCondicionados", parametros);
    }

    public void imprimirRecibo(String idRecibo, String vrLetras, String xidCaja, JInternalFrame xjif) {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "idRecibo";
        parametros[0][1] = idRecibo;
        parametros[1][0] = "VrLetras";
        parametros[1][1] = this.metodos.mConvertirNumeroLetras(vrLetras.replace(".", ","));
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "IdCaja";
        parametros[3][1] = xidCaja;
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getFormaImpresionRecibo().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "ReciboCaja", parametros);
            return;
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Reibo_Caja_Tirilla", parametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
            Object[] botones1 = {"Tirilla", "Media Carta", "Cerrar"};
            int x = JOptionPane.showInternalOptionDialog(xjif, "Que desea hacer?", "VISUALIZACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
            if (x == 0) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Recibo_Caja_TirillaN", parametros);
                return;
            } else {
                if (x == 1) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "ReciboCaja", parametros);
                    return;
                }
                return;
            }
        }
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "ReciboCaja", parametros);
    }

    public void imprimirConsolidado(String idConsolidado) {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "idConsolidado";
        parametros[0][1] = idConsolidado;
        parametros[1][0] = "VrLetras";
        parametros[1][1] = "Valor en letras pendiente";
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(parametros[2][1] + "RelacionConsolidado", parametros);
    }

    public void imprimirConsolidadoG(String Fechai, String Fechaf) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "Fechai";
        parametros[0][1] = Fechai;
        parametros[1][0] = "FechaF";
        parametros[1][1] = Fechaf;
        parametros[2][0] = "UsuarioG";
        parametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[3][0] = "Cargo";
        parametros[3][1] = Principal.usuarioSistemaDTO.getNombreCargoUsuario();
        parametros[4][0] = "ruta";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[5][0] = "SUBREPORT_DIR";
        parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[6][0] = "SUBREPORTFIRMA_DIR";
        parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(parametros[4][1] + "C_Cierre_Consolidado_Presupuestal_Global", parametros);
    }

    public void nuevo(String frm) {
        if (frm.equals("Recibos")) {
            this.frmRecibos.nuevo();
            return;
        }
        if (frm.equals("Cierre")) {
            this.frmCierre.nuevo();
            return;
        }
        if (frm.equals("Consolidado")) {
            this.frmConsolidado.nuevo();
            return;
        }
        if (frm.equals("xjifconsultar_reciboc")) {
            this.xjifconsultar_recibos.mNuevo();
            return;
        }
        if (frm.equals("xjifasignacionreciboingresos")) {
            this.xJIFAsigancionReciboIngresos.mNuevo();
        } else if (frm.equals("xjifrecibosegresos")) {
            this.xJIFRecibosEgresos.mNuevo();
        } else if (frm.equals("xjifcierreegresos")) {
            this.xJIFCierreEgresos.mNuevo();
        }
    }

    public void setCajaAbierta(int id) {
        this.cajaAbierta = id;
    }

    public void setAsignarDatosCaja(int idCaja, String nbreCaja) {
        setCaja(idCaja);
        setNbreCaja(nbreCaja);
    }

    public String setActualizarNoRecibo() {
        long ultimo = Integer.parseInt(getUltimoNoRecibo()) + 1;
        this.sql = "UPDATE k_caja SET NoRecibo ='" + ultimo + "' WHERE (Id ='" + getIdCaja() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        return String.valueOf(ultimo);
    }

    public void setCaja(int xcaja) {
        this.idCaja = xcaja;
    }

    public void setNbreCaja(String xNbreCaja) {
        this.nbreCaja = xNbreCaja;
    }

    public void setFechaCierreActual(String xfechacactual) {
        this.fechacactual = xfechacactual;
    }

    public void setCDebito(String CDebito) {
        this.CDebito = CDebito;
    }

    public void setCCredito(String CCredito) {
        this.CCredito = CCredito;
    }

    public String verificarCajaAbierta() {
        this.sql = "SELECT DATE_FORMAT(FechaInicio, '%Y/%m/%d %h:%i:%s %p') AS FechaInicio FROM k_cierre WHERE (Id_Caja ='" + getIdCaja() + "' AND Id_Usuario ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND FechaFinal IS NULL)";
        String resultado = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return resultado;
    }

    public Boolean mVerificarFechaContable(String xFechaI, String xidPeriodo) {
        ResultSet xrs;
        Throwable th;
        boolean resultado = false;
        this.sql = "SELECT if(DATE_FORMAT(FechaI,'%Y-%m-%d')>='" + xFechaI + "' && DATE_FORMAT(FechaF,'%Y-%m-%d')<='" + xFechaI + "' ,true,false) as Estado FROM `cc_periodo_contable` WHERE (`Id` ='" + xidPeriodo + "');";
        try {
            xrs = this.consultas.traerRs(this.sql);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(claseCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        resultado = xrs.getBoolean(1);
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
                this.consultas.cerrarConexionBd();
                return Boolean.valueOf(resultado);
            } finally {
            }
        } finally {
        }
    }
}
