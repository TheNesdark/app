package Inventarios;

import Acceso.Principal;
import ComprasBS.JIFConsultarEstadoOc;
import ComprasBS.JIFOrdenCompra;
import Contabilidad.JIFPeriodoContables;
import Historia.JIFRVisitasDomiciliarias;
import Mantenimiento.JIFReporte;
import Sig.JIFFConsultarInformacionGenerico;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente;
import com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables;
import com.genoma.plus.controller.inventario.JIFConsolidadoEntradas;
import com.genoma.plus.controller.inventario.JIFConsolidadoSalidas;
import com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima;
import com.genoma.plus.controller.inventario.JIFF_InformeSalidas;
import com.genoma.plus.controller.inventario.JIFInformeEntradas;
import com.genoma.plus.controller.inventario.JIFInventarioGeneral;
import com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.dto.inventario.InfomacionLote;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.projection.IInformacionOrdenMedicaSuministro;
import com.genoma.plus.jpa.service.IBodegaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/claseInventario.class */
public class claseInventario {
    public Principal frmPrincipal;
    private PrepararInventario frmPrepararInv;
    private Conteo frmConteo;
    private CerrarInventario frmCerrarInv;
    private CrearLote frmCrearLote;
    private ModificarLote frmModificarLote;
    private ImprimirInventario frmImprimirInv;
    public JIFReporte xjifreporte;
    private JIFConsultasInf xjifconsulta;
    private JIFAuditoriaTiemposPendientes xjiftiempos;
    private JIFConsultasInfMed xjifconsultam;
    private int tipoBodega;
    private int unidadEmpaque;
    public String idBodega;
    public String nbreBodega;
    public String xBodegaDestino;
    private JIFISuministroxLote xjifsuministrolote;
    private JIFGestionarPendiente xjifgestionpendiente;
    private JIFSolicitudPuntosR xjifsolicitudpr;
    private JIFOrdenCompra xjifcomprai;
    private JIFCambiarEstadoProductoSolicitud xjifmodificars;
    private JIFConsultarEstadoOc xjidconsultarordenc;
    private JIFCierresContables xjifcierrecontables;
    private JIFConsultaMovimientoP xjifconsultap;
    private JIFConsultarInfSum xjifconsultarinfsum;
    private JIFReposicionesBd jifreposicionesbd;
    private JIFReposicionesP jifreposicionesp;
    private JIFModificarCodAgr jifmodcodagrupacion;
    private JIFModificarR jifmodificarr;
    private JIFAgregarProductos jifadicionarproductos;
    private JIFAjustarPRMinMax xjifajustarminmax;
    private JIFConsultarFormulas xjifconsultarformulas;
    public JIFFormulacionMedica xjifformulacionmedica;
    private JIFMonitoreoInventario xjifmonitoreoinventario;
    private String xfechaperiodoi;
    private String xfechaperiodof;
    private JIFInformeConsolidadoMov xjifinformeconsmovimiento;
    private JIFTempBodega xjiftempbodega;
    private JIFRVisitasDomiciliarias xjifvisitasdom;
    private JIFPeriodoContables xjifperiodocontableI;
    private JIFKardex xjifkardex;
    private JIFAuditoriasProductos xjifauditoria;
    public JIFAgenda_Unidosis xjifagendaunidosis;
    private JIFInventarioGeneral xJIFInventarioGeneral;
    private JIFKardex_Producto xjif_kardex_p;
    private JIF_Cierre_Inventario xjif_CierreInventario;
    private JIFPrueba xjip;
    private Date xfechai;
    private Date xfechaf;
    private JIFFInfBodega xJIFFInfBodega;
    private JIFFConsultarInformacionGenerico xJIFFConsultarInformacionGenerico;
    private JIFInformeEntradas xJIFInformeEntradas;
    private JIFIAgenda_Cirugia xJIFIAgenda_Cirugia;
    private JIFInformesDespachoPaciente xJIFInformesDespachoPaciente;
    private JIFConsolidadoSalidas xJIFConsolidadoSalidas;
    private JIFConsolidadoEntradas xJIFConsolidadoEntradas;
    private JIFConsolidadoCierresContables xJIFConsolidadoCierresContables;
    private JIF_GestionInventarioCompras inventarioCompras;
    private JIFF_InformeSalidas xInformeSalidas;
    private List<Integer> listIdBodega;
    private JIF_Reportes_PyP_Generico jifreportes;
    private JIFConsultarSuministroFechaInvima consultarSuministroFechaInvima;
    public Entradas frmEntrada = null;
    public Despachos frmDespacho = null;
    public Salidas frmSalida = null;
    public ITraslados frmTraslado = null;
    public Faltantes frmFaltante = null;
    private ConsultarExistencias frmConsExis = null;
    private Kardex frmKardex = null;
    private InformeAuditoria frmInformesA = null;
    private Informes frmInformes = null;
    private boolean xestadop = false;
    private int xidperiodoc = -1;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private IBodegaDAO iBodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);

    public claseInventario(Principal frmP, int xmodulo) {
        this.frmPrincipal = frmP;
    }

    public claseInventario(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public List<Integer> getListaIdBodega() {
        this.listIdBodega = new ArrayList();
        this.listIdBodega.add(Integer.valueOf(getIdBodega()));
        return this.listIdBodega;
    }

    public String getIdBodega() {
        return this.idBodega;
    }

    public String getNbreBodega() {
        return this.nbreBodega;
    }

    public int getTipoBodega() {
        return this.tipoBodega;
    }

    public void setIdBodega(String id) {
        this.idBodega = id;
    }

    public void setNbreBodega(String nbre) {
        this.nbreBodega = nbre;
    }

    public void setTipoBodega(int tipo) {
        this.tipoBodega = tipo;
    }

    public int getUnidadEmpaque() {
        return this.unidadEmpaque;
    }

    public void setUnidadEmpaque(int unidadEmpaque) {
        this.unidadEmpaque = unidadEmpaque;
    }

    public void anular(String frm) {
        if (frm.equals("Entradas")) {
            this.frmEntrada.anular();
            return;
        }
        if (frm.equals("Despachos")) {
            this.frmDespacho.anular();
            return;
        }
        if (frm.equals("Salidas")) {
            this.frmSalida.anular();
            return;
        }
        if (frm.equals("ITraslados")) {
            this.frmTraslado.anular();
            return;
        }
        if (frm.equals("Faltantes")) {
            this.frmFaltante.anular();
        } else if (frm.equals("jifcompras1")) {
            this.xjifcomprai.mAnular();
        } else if (frm.equals("jifcompras2")) {
            this.xjifcomprai.mAnular();
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "Entradas":
                this.frmEntrada.buscarEntrada();
                break;
            case "xjifconsolidadocierrecontable":
                this.xJIFConsolidadoCierresContables.mBuscar();
                break;
            case "Despachos":
                this.frmDespacho.buscarDespachos();
                break;
            case "jif_gestion_inventario":
                this.inventarioCompras.buscar();
                break;
            case "Salidas":
                this.frmSalida.buscarSalidas();
                break;
            case "Traslados":
                this.frmTraslado.buscarTraslados();
                break;
            case "Faltantes":
                this.frmFaltante.buscarFaltante();
                break;
            case "jifconsultarinformesi":
                this.xjifconsulta.mBuscar();
                break;
            case "jifconsultarinformesi1":
                this.xjifconsulta.mBuscar();
                break;
            case "jifconsultarinformesi2":
                this.xjifconsulta.mBuscar();
                break;
            case "jiftiemposllamada":
                this.xjiftiempos.mBuscar();
                break;
            case "jifconsultarinformesm":
                this.xjifconsultam.mBuscar();
                break;
            case "jifgestionpendiente":
                this.xjifgestionpendiente.mBuscar();
                break;
            case "jifcompras1":
                this.xjifcomprai.mBuscar();
                break;
            case "jifcompras2":
                this.xjifcomprai.mBuscar();
                break;
            case "jismodificarsolicitudp":
                this.xjifmodificars.mBuscar();
                break;
            case "jifcierrescontables":
                this.xjifcierrecontables.mBuscar();
                break;
            case "jifconsultarinformesv":
                this.xjifconsultap.mBuscar();
                break;
            case "xjifconsultarinf":
            case "xjifconsultarpsrotacion":
            case "xjifconsultarfespecialidad":
                this.xjifconsultarinfsum.mBuscar();
                break;
            case "jifconsultarordenesc1":
                this.xjidconsultarordenc.mBuscar();
                break;
            case "jifconsultarformulas":
                this.xjifconsultarformulas.mBuscar();
                break;
            case "xjifajustarpminmax":
                this.xjifajustarminmax.mBuscar();
                break;
            case "xjifconsolidadomovimiento":
                this.xjifinformeconsmovimiento.mBuscar();
                break;
            case "xjifauditoriaaleatoria":
                this.xjifauditoria.mBuscar();
                break;
            case "xjifkardex":
                this.xjifkardex.mBuscar();
                break;
            case "xjifinventariogeneral":
                this.xJIFInventarioGeneral.mBuscar();
                break;
            case "xjifRotacionBodega":
                this.xJIFFInfBodega.mBuscar();
                break;
            case "LASA":
                this.xJIFFConsultarInformacionGenerico.mBuscar();
                break;
            case "jifinformeestradas":
                this.xJIFInformeEntradas.mBuscar();
                break;
            case "xjifinformesdespachopaciente":
                this.xJIFInformesDespachoPaciente.mBuscar();
                break;
            case "xjifconsolidadosalidas":
                this.xJIFConsolidadoSalidas.mBuscar();
                break;
            case "xjifconsolidadoentradas":
                this.xJIFConsolidadoEntradas.mBuscar();
                break;
            case "Informes1.5":
                this.xJIFFConsultarInformacionGenerico.mBuscar();
                break;
            case "jiff_InformeDeSalidas":
                this.xInformeSalidas.mBuscar();
                break;
            case "jifSuministrosFechaInvima":
                this.consultarSuministroFechaInvima.buscar();
                break;
            case "jmiInformesGeneralesInventario":
                this.jifreportes.mBuscar();
                break;
        }
    }

    public List<InfomacionLote> cargarLote(JComboBox combo, List<InfomacionLote> lista, List<IInformacionInventario> informacionInventarios) {
        List<InfomacionLote> listaLote = new ArrayList<>();
        combo.removeAllItems();
        for (int i = 0; i < informacionInventarios.size(); i++) {
            IInformacionInventario get = informacionInventarios.get(i);
            System.out.println("" + get.getTotalInventario());
            if (get.getTotalInventario().doubleValue() > 0.0d || get.getLote().equals("FALTANTE")) {
                InfomacionLote lote = new InfomacionLote();
                lote.setIdSumnistroBodega(get.getIdSUministroBodega());
                lote.setLote(get.getLote());
                lote.setFechaVencimiento(get.getFechaVencimientoLote());
                lote.setCantidad(get.getTotalInventario());
                lote.setCantidadPendiente(get.getCantidadPendiente());
                lote.setValor(get.getValorUnitario());
                listaLote.add(lote);
                String xtipo = null;
                if (get.getDiasDiferenciaSemaforo().intValue() <= 6) {
                    xtipo = "<html><P ALIGN=center><font face='Arial' color='red' size=3>" + get.getLote() + " - Vence " + get.getFechaVencimientoLote();
                } else if (get.getDiasDiferenciaSemaforo().intValue() > 6 && get.getDiasDiferenciaSemaforo().intValue() <= 12) {
                    xtipo = "<html><P ALIGN=center><font face='Arial' color='green' size=3>" + get.getLote() + " - Vence " + get.getFechaVencimientoLote();
                } else if (get.getDiasDiferenciaSemaforo().intValue() >= 13) {
                    xtipo = "<html><P ALIGN=center><font face='Arial' color='black' size=3>" + get.getLote() + " - Vence " + get.getFechaVencimientoLote();
                }
                combo.addItem(xtipo);
            }
        }
        return listaLote;
    }

    public List<IInformacionOrdenMedicaSuministro> listItemOrdenMedica(Date fechaCorte, List<Integer> listIdBodega, Long idSuministro, Double cantidad) {
        new ArrayList();
        List<IInformacionOrdenMedicaSuministro> informacionOrden = this.iBodegaDAO.listaItemsOrdenMedica(fechaCorte, listIdBodega, idSuministro, cantidad);
        return informacionOrden;
    }

    public List<IInformacionInventario> listInventarioGeneral(Date fechaCorte, List<Integer> listIdBodega, Integer filtro, Integer forma, String filroBusqueda, String sqlAdicional) {
        List<IInformacionInventario> informacionInventarios = new ArrayList();
        if (null != forma) {
            switch (forma.intValue()) {
                case 0:
                    informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIbodegaIdSuministroLote(fechaCorte, listIdBodega, filtro);
                    break;
                case 1:
                    informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIdBodegaIdSuministroCodigoBarra(fechaCorte, listIdBodega, filroBusqueda);
                    break;
                case 2:
                    informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIdbodegaIdSuministro(fechaCorte, listIdBodega, filtro, filroBusqueda);
                    break;
                case 3:
                    informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIdbodegaIdSuministroNombrePrincipioActivoConExistencia(fechaCorte, listIdBodega, filroBusqueda, sqlAdicional);
                    break;
            }
        }
        return informacionInventarios;
    }

    public String[][] cargarLote(JComboBox combo, String[][] lista, double existencia, String idBodega, String idProducto) {
        String sql;
        ConsultasMySQL consultas = new ConsultasMySQL();
        try {
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
            combo.removeAllItems();
            combo.setSelectedIndex(-1);
            if (existencia > 0.0d) {
                sql = "SELECT i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.FechaVencimiento, i_suministroxlotexbodega.Cantidad, ROUND((DATEDIFF(i_suministroxlotexbodega.FechaVencimiento, NOW())/30)) AS Dif, i_suministroxlotexbodega.CPendiente FROM  i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxlotexbodega.Cantidad >0  AND i_suministroxbodega.IdBodega ='" + idBodega + "' AND i_suministroxbodega.IdSuministro ='" + idProducto + "') ORDER BY i_suministroxlotexbodega.FechaVencimiento ASC";
            } else {
                sql = "SELECT i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.FechaVencimiento, i_suministroxlotexbodega.Cantidad, ROUND((DATEDIFF(i_suministroxlotexbodega.FechaVencimiento, NOW())/30)) AS Dif, i_suministroxlotexbodega.CPendiente FROM  i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (Lote = 'FALTANTE'  AND i_suministroxbodega.IdBodega ='" + idBodega + "' AND i_suministroxbodega.IdSuministro ='" + idProducto + "') ORDER BY i_suministroxlotexbodega.FechaVencimiento ASC";
            }
            ResultSet rs = consultas.traerRs(sql);
            if (rs.next()) {
                rs.last();
                int i = 0;
                int noFilas = rs.getRow();
                rs.beforeFirst();
                lista = new String[noFilas][6];
                while (rs.next()) {
                    lista[i][0] = rs.getString(1);
                    lista[i][1] = rs.getString(2);
                    lista[i][2] = formatofecha.format((Date) rs.getDate(3));
                    lista[i][3] = rs.getString(4);
                    lista[i][4] = rs.getString(6);
                    String xtipo = null;
                    if (rs.getInt(5) <= 6) {
                        xtipo = "<html><P ALIGN=center><font face='Arial' color='red' size=4>" + rs.getString(2) + " - Vence " + rs.getString(3).substring(0, 10) + "</font></P></html>";
                    } else if (rs.getInt(5) > 6 && rs.getInt(5) <= 12) {
                        xtipo = "<html><P ALIGN=center><font face='Arial' color='green' size=4>" + rs.getString(2) + " - Vence " + rs.getString(3).substring(0, 10) + "</font></P></html>";
                    } else if (rs.getInt(5) >= 13) {
                        xtipo = "<html><P ALIGN=center><font face='Arial' color='black' size=4>" + rs.getString(2) + " - Vence " + rs.getString(3).substring(0, 10) + "</font></P></html>";
                    }
                    combo.addItem(xtipo);
                    i++;
                }
            }
            combo.setSelectedIndex(-1);
            rs.close();
            consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            consultas.mostrarErrorSQL(ex);
        }
        return lista;
    }

    public void cargarPantalla(String frm, JTable datos) {
        if (frm.equals("jifcompras3")) {
            if (this.xjifcomprai != null) {
                this.xjifcomprai.dispose();
            }
            this.xjifcomprai = new JIFOrdenCompra(frm, datos);
            Principal.cargarPantalla(this.xjifcomprai);
            this.xjifcomprai.moveToFront();
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Entradas":
                if (this.frmEntrada != null) {
                    this.frmEntrada.dispose();
                }
                this.frmEntrada = new Entradas(this);
                Principal.cargarPantalla(this.frmEntrada);
                this.frmEntrada.moveToFront();
                break;
            case "jifSuministrosFechaInvima":
                this.consultarSuministroFechaInvima = new JIFConsultarSuministroFechaInvima();
                Principal.cargarPantalla(this.consultarSuministroFechaInvima);
                break;
            case "Inventario General":
                this.xJIFInventarioGeneral = new JIFInventarioGeneral();
                Principal.cargarPantalla(this.xJIFInventarioGeneral);
                break;
            case "Consolidado Cierre Contable":
                this.xJIFConsolidadoCierresContables = new JIFConsolidadoCierresContables();
                Principal.cargarPantalla(this.xJIFConsolidadoCierresContables);
                break;
            case "Agenda_Unidosis":
                this.xjifagendaunidosis = new JIFAgenda_Unidosis();
                Principal.cargarPantalla(this.xjifagendaunidosis);
                break;
            case "prueba":
                this.xjip = new JIFPrueba();
                Principal.cargarPantalla(this.xjip);
                break;
            case "Consolidado de Movimiento":
                this.xjifinformeconsmovimiento = new JIFInformeConsolidadoMov("xjifconsolidadomovimiento");
                Principal.cargarPantalla(this.xjifinformeconsmovimiento);
                break;
            case "Kardex_P":
                this.xjif_kardex_p = new JIFKardex_Producto();
                Principal.cargarPantalla(this.xjif_kardex_p);
                break;
            case "Kardex_I":
            case "Kardex":
                this.xjifkardex = new JIFKardex("xjifkardex");
                Principal.cargarPantalla(this.xjifkardex);
                break;
            case "Monitoreo Inventario":
                this.xjifmonitoreoinventario = new JIFMonitoreoInventario();
                Principal.cargarPantalla(this.xjifmonitoreoinventario);
                break;
            case "Consultar Formulacion Medica en Linea":
                this.xjifformulacionmedica = new JIFFormulacionMedica();
                Principal.cargarPantalla(this.xjifformulacionmedica);
                break;
            case "Consultar Formulas Generadas":
                this.xjifconsultarformulas = new JIFConsultarFormulas();
                Principal.cargarPantalla(this.xjifconsultarformulas);
                break;
            case "Ajustar Puntos":
                this.xjifajustarminmax = new JIFAjustarPRMinMax();
                Principal.cargarPantalla(this.xjifajustarminmax);
                break;
            case "Adicionar Productos Bodega-Proveedores":
                this.jifadicionarproductos = new JIFAgregarProductos();
                Principal.cargarPantalla(this.jifadicionarproductos);
                break;
            case "Modificar PReposicion, Minimos y Maximos":
                this.jifmodificarr = new JIFModificarR();
                Principal.cargarPantalla(this.jifmodificarr);
                break;
            case "Modificar y Consultar Código de Agrupación":
                this.jifmodcodagrupacion = new JIFModificarCodAgr();
                Principal.cargarPantalla(this.jifmodcodagrupacion);
                break;
            case "Despachos":
                if (this.frmDespacho != null) {
                    this.frmDespacho.dispose();
                }
                this.frmDespacho = new Despachos(this, 0);
                Principal.cargarPantalla(this.frmDespacho);
                this.frmDespacho.moveToFront();
                break;
            case "Despachos1":
                if (this.frmDespacho != null) {
                    this.frmDespacho.dispose();
                }
                this.frmDespacho = new Despachos(this, 1);
                Principal.cargarPantalla(this.frmDespacho);
                this.frmDespacho.moveToFront();
                break;
            case "Salidas":
                if (this.frmSalida != null) {
                    this.frmSalida.dispose();
                }
                this.frmSalida = new Salidas(this);
                Principal.cargarPantalla(this.frmSalida);
                this.frmSalida.moveToFront();
                break;
            case "Traslados":
                if (this.frmTraslado != null) {
                    this.frmTraslado.dispose();
                }
                this.frmTraslado = new ITraslados(this);
                Principal.cargarPantalla(this.frmTraslado);
                this.frmTraslado.moveToFront();
                break;
            case "Faltantes":
                if (this.frmFaltante != null) {
                    this.frmFaltante.dispose();
                }
                this.frmFaltante = new Faltantes(this);
                Principal.cargarPantalla(this.frmFaltante);
                this.frmFaltante.moveToFront();
                break;
            case "ConsultarExistencia":
                if (this.frmConsExis != null) {
                    this.frmConsExis.dispose();
                }
                this.frmConsExis = new ConsultarExistencias(this);
                Principal.cargarPantalla(this.frmConsExis);
                this.frmConsExis.moveToFront();
                break;
            case "InformeAuditoria":
                if (this.frmInformesA != null) {
                    this.frmInformesA.dispose();
                }
                this.frmInformesA = new InformeAuditoria();
                Principal.cargarPantalla(this.frmInformesA);
                this.frmInformesA.moveToFront();
                break;
            case "PrepararInventario":
                if (this.frmPrepararInv != null) {
                    this.frmPrepararInv.dispose();
                }
                this.frmPrepararInv = new PrepararInventario(this);
                Principal.cargarPantalla(this.frmPrepararInv);
                this.frmPrepararInv.moveToFront();
                break;
            case "Conteo1":
                if (this.frmConteo != null) {
                    this.frmConteo.dispose();
                }
                this.frmConteo = new Conteo(1);
                Principal.cargarPantalla(this.frmConteo);
                this.frmConteo.moveToFront();
                break;
            case "Conteo2":
                if (this.frmConteo != null) {
                    this.frmConteo.dispose();
                }
                this.frmConteo = new Conteo(2);
                Principal.cargarPantalla(this.frmConteo);
                this.frmConteo.moveToFront();
                break;
            case "CerrarInventario":
                if (this.frmCerrarInv != null) {
                    this.frmCerrarInv.dispose();
                }
                this.frmCerrarInv = new CerrarInventario();
                Principal.cargarPantalla(this.frmCerrarInv);
                this.frmCerrarInv.moveToFront();
                break;
            case "CrearLote":
                if (this.frmCrearLote != null) {
                    this.frmCrearLote.dispose();
                }
                this.frmCrearLote = new CrearLote();
                Principal.cargarPantalla(this.frmCrearLote);
                this.frmCrearLote.moveToFront();
                break;
            case "ModificarLote":
                if (this.frmModificarLote != null) {
                    this.frmModificarLote.dispose();
                }
                this.frmModificarLote = new ModificarLote(this);
                Principal.cargarPantalla(this.frmModificarLote);
                this.frmModificarLote.moveToFront();
                break;
            case "ImprimirInventario":
                if (this.frmImprimirInv != null) {
                    this.frmImprimirInv.dispose();
                }
                this.frmImprimirInv = new ImprimirInventario();
                Principal.cargarPantalla(this.frmImprimirInv);
                this.frmImprimirInv.moveToFront();
                break;
            case "Informes1.1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("INVENTARIO GENERAL POR AREA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.2":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("PROXIMOS A VENCER");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.3":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO DE PRODUCTOS");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.4":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    this.frmInformes = new Informes("LISTADO DE PRODUCTOS CON CANTIDAD.");
                } else {
                    this.frmInformes = new Informes("LISTADO BASICO DE MEDICAMENTOS");
                }
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.4.1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO BASICO DE MEDICAMENTOS PSIQUIATRA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.5":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("Informes1.5", frm);
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Informes1.6":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO GENERAL DE PRODUCTOS POR TIPO");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes1.7":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("MAXIMOS Y MINIMOS");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes2.1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("ENTRADA A INVENTARIO");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.1.1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("PENDIENTE POR DESPACHO");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.1.2":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO GENERAL DE PENDIENTES POR FECHA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.1.3":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO DE PENDIENTES SIN ENTREGAR POR FECHA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.2.1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("DESPACHOS POR FECHA POR PACIENTE");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.2.1_1":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("DESPACHOS POR FECHA POR PACIENTE PARA AUDITORIA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.2.2":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("DESPACHOS POR FECHA POR PRODUCTO");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes3.2.3":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("DESPACHOS POR EMPRESA");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Informes4":
                if (this.xInformeSalidas != null) {
                    this.xInformeSalidas.dispose();
                }
                this.xInformeSalidas = new JIFF_InformeSalidas();
                Principal.cargarPantalla(this.xInformeSalidas);
                this.xInformeSalidas.moveToFront();
                break;
            case "Informes5":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("TRASLADOS");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Reporte":
                if (this.xjifreporte != null) {
                    this.xjifreporte.dispose();
                }
                this.xjifreporte = new JIFReporte("jifreporte7");
                Principal.cargarPantalla(this.xjifreporte);
                this.xjifreporte.moveToFront();
                break;
            case "Movimiento":
                if (this.xjifconsulta != null) {
                    this.xjifconsulta.dispose();
                }
                this.xjifconsulta = new JIFConsultasInf("jifconsultarinformesi");
                Principal.cargarPantalla(this.xjifconsulta);
                this.xjifconsulta.moveToFront();
                break;
            case "Consolidado de Despacho":
                if (this.xjifconsulta != null) {
                    this.xjifconsulta.dispose();
                }
                this.xjifconsulta = new JIFConsultasInf("jifconsultarinformesi1");
                Principal.cargarPantalla(this.xjifconsulta);
                this.xjifconsulta.moveToFront();
                break;
            case "Consultar Tiempos de LLamada":
                if (this.xjiftiempos != null) {
                    this.xjiftiempos.dispose();
                }
                this.xjiftiempos = new JIFAuditoriaTiemposPendientes();
                Principal.cargarPantalla(this.xjiftiempos);
                this.xjiftiempos.moveToFront();
                break;
            case "Consolidado de Pendientes Generados":
                if (this.xjifconsulta != null) {
                    this.xjifconsulta.dispose();
                }
                this.xjifconsulta = new JIFConsultasInf("jifconsultarinformesi2");
                Principal.cargarPantalla(this.xjifconsulta);
                this.xjifconsulta.moveToFront();
                break;
            case "Consolidado de Despacho x Medico":
                if (this.xjifconsultam != null) {
                    this.xjifconsultam.dispose();
                }
                this.xjifconsultam = new JIFConsultasInfMed("jifconsultarinformesm");
                Principal.cargarPantalla(this.xjifconsultam);
                this.xjifconsultam.moveToFront();
                break;
            case "Suministro x Bodega x Lote":
                if (this.xjifsuministrolote != null) {
                    this.xjifsuministrolote.dispose();
                }
                this.xjifsuministrolote = new JIFISuministroxLote();
                Principal.cargarPantalla(this.xjifsuministrolote);
                this.xjifsuministrolote.moveToFront();
                break;
            case "Gestión de Pendiente":
                if (this.xjifgestionpendiente != null) {
                    this.xjifgestionpendiente.dispose();
                }
                this.xjifgestionpendiente = new JIFGestionarPendiente();
                Principal.cargarPantalla(this.xjifgestionpendiente);
                this.xjifgestionpendiente.moveToFront();
                break;
            case "Solicitud de Productos":
                if (!Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    if (this.xjifsolicitudpr != null) {
                        this.xjifsolicitudpr.dispose();
                    }
                    this.xjifsolicitudpr = new JIFSolicitudPuntosR();
                    Principal.cargarPantalla(this.xjifsolicitudpr);
                    this.xjifsolicitudpr.moveToFront();
                    break;
                } else {
                    if (this.inventarioCompras != null) {
                        this.inventarioCompras.dispose();
                    }
                    this.inventarioCompras = new JIF_GestionInventarioCompras();
                    Principal.cargarPantalla(this.inventarioCompras);
                    this.inventarioCompras.moveToFront();
                    break;
                }
                break;
            case "jifcompras1":
            case "jifcompras2":
                if (this.xjifcomprai != null) {
                    this.xjifcomprai.dispose();
                }
                this.xjifcomprai = new JIFOrdenCompra(frm, Long.valueOf(Principal.txtNo.getText()).longValue());
                Principal.cargarPantalla(this.xjifcomprai);
                this.xjifcomprai.moveToFront();
                break;
            case "Modificar Estado de Productos x Solicitud":
                if (this.xjifmodificars != null) {
                    this.xjifmodificars.dispose();
                }
                this.xjifmodificars = new JIFCambiarEstadoProductoSolicitud();
                Principal.cargarPantalla(this.xjifmodificars);
                this.xjifmodificars.moveToFront();
                break;
            case "Consultar Orden Compra":
                if (this.xjidconsultarordenc != null) {
                    this.xjidconsultarordenc.dispose();
                }
                this.xjidconsultarordenc = new JIFConsultarEstadoOc("jifconsultarordenesc1", this.frmEntrada);
                Principal.cargarPantalla(this.xjidconsultarordenc);
                this.xjidconsultarordenc.moveToFront();
                break;
            case "Informes1.8":
                if (this.frmInformes != null) {
                    this.frmInformes.dispose();
                }
                this.frmInformes = new Informes("LISTADO DE DISPOSITIVOS MEDICOS");
                Principal.cargarPantalla(this.frmInformes);
                this.frmInformes.moveToFront();
                break;
            case "Cierre de Costo":
                if (this.xjifcierrecontables != null) {
                    this.xjifcierrecontables.dispose();
                }
                this.xjifcierrecontables = new JIFCierresContables();
                Principal.cargarPantalla(this.xjifcierrecontables);
                this.xjifcierrecontables.moveToFront();
                break;
            case "Consultar Información Producto":
                if (this.xjifconsultap != null) {
                    this.xjifconsultap.dispose();
                }
                this.xjifconsultap = new JIFConsultaMovimientoP();
                Principal.cargarPantalla(this.xjifconsultap);
                this.xjifconsultap.moveToFront();
                break;
            case "Consultar Listado Productos Faltantes":
                if (this.xjifconsultarinfsum != null) {
                    this.xjifconsultarinfsum.dispose();
                }
                this.xjifconsultarinfsum = new JIFConsultarInfSum(frm.toUpperCase(), "xjifconsultarinf");
                Principal.cargarPantalla(this.xjifconsultarinfsum);
                this.xjifconsultarinfsum.moveToFront();
                break;
            case "Consultar Despacho x Especialidad":
                if (this.xjifconsultarinfsum != null) {
                    this.xjifconsultarinfsum.dispose();
                }
                this.xjifconsultarinfsum = new JIFConsultarInfSum(frm.toUpperCase(), "xjifconsultarfespecialidad");
                Principal.cargarPantalla(this.xjifconsultarinfsum);
                this.xjifconsultarinfsum.moveToFront();
                break;
            case "Reposiciones a Bodegas":
                this.jifreposicionesbd = new JIFReposicionesBd();
                Principal.cargarPantalla(this.jifreposicionesbd);
                break;
            case "Solicitud a Proveedores":
                this.jifreposicionesp = new JIFReposicionesP();
                Principal.cargarPantalla(this.jifreposicionesp);
                break;
            case "Temperatura Bodega":
                this.xjiftempbodega = new JIFTempBodega("Temperatura Bodega", frm);
                Principal.cargarPantalla(this.xjiftempbodega);
                break;
            case "Consultar Productos Sin Rotación":
                if (this.xjifconsultarinfsum != null) {
                    this.xjifconsultarinfsum.dispose();
                }
                this.xjifconsultarinfsum = new JIFConsultarInfSum(frm.toUpperCase(), "xjifconsultarpsrotacion");
                Principal.cargarPantalla(this.xjifconsultarinfsum);
                this.xjifconsultarinfsum.moveToFront();
                break;
            case "Registro de Notas Médicas":
                this.xjifvisitasdom = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), "Registro de Notas Médicas", "jifnotamedicaSF", new Long(0L), 0);
                Principal.cargarPantalla(this.xjifvisitasdom);
                break;
            case "Periodos Contables":
                this.xjifperiodocontableI = new JIFPeriodoContables("jifperiodocontableI");
                Principal.cargarPantalla(this.xjifperiodocontableI);
                break;
            case "Auditorias Aleatorias":
                this.xjifauditoria = new JIFAuditoriasProductos("xjifauditoriaaleatoria");
                Principal.cargarPantalla(this.xjifauditoria);
                break;
            case "UltimaRotacion":
                this.xJIFFInfBodega = new JIFFInfBodega("UltimaRotacion");
                Principal.cargarPantalla(this.xJIFFInfBodega);
                break;
            case "ClaLASA":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("LASA", "Clasificación LASA");
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Entrada a Inventario":
                this.xJIFInformeEntradas = new JIFInformeEntradas();
                Principal.cargarPantalla(this.xJIFInformeEntradas);
                break;
            case "Agenda_Cirugia":
                this.xJIFIAgenda_Cirugia = new JIFIAgenda_Cirugia();
                Principal.cargarPantalla(this.xJIFIAgenda_Cirugia);
                break;
            case "Informes de Despacho":
                this.xJIFInformesDespachoPaciente = new JIFInformesDespachoPaciente();
                Principal.cargarPantalla(this.xJIFInformesDespachoPaciente);
                break;
            case "Consolidado de Salidas":
                this.xJIFConsolidadoSalidas = new JIFConsolidadoSalidas();
                Principal.cargarPantalla(this.xJIFConsolidadoSalidas);
                break;
            case "Consolidado de Entradas":
                this.xJIFConsolidadoEntradas = new JIFConsolidadoEntradas();
                Principal.cargarPantalla(this.xJIFConsolidadoEntradas);
                break;
            case "jmiInformesGeneralesInventario":
                this.jifreportes = new JIF_Reportes_PyP_Generico(4, "INFORMES DE MODULO INVENTARIO", "jmiInformesGeneralesInventario");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void mCargarPantalla(String frm, String xnhc, Long xidunisodis, Long xIdIngreso, Boolean xFiltro, int xTipoProducto, int xCerrar, String xllamador) {
        if (frm.equals("Despachos")) {
            if (this.frmDespacho != null) {
                this.frmDespacho.dispose();
            }
            this.frmDespacho = new Despachos(this, 3, xnhc, xidunisodis, xIdIngreso, xFiltro, xTipoProducto, xCerrar, xllamador);
            Principal.cargarPantalla(this.frmDespacho);
            this.frmDespacho.moveToFront();
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "Entradas":
                this.frmEntrada.grabar();
                break;
            case "xjifconsultarpsrotacion":
                this.xjifconsultarinfsum.mGrabar();
                break;
            case "jifadicionarp":
                this.jifadicionarproductos.grabar();
                break;
            case "Despachos":
                this.frmDespacho.grabar();
                break;
            case "ITraslados":
                this.frmTraslado.grabar();
                break;
            case "Salidas":
                this.frmSalida.grabar();
                break;
            case "Faltantes":
                this.frmFaltante.grabar();
                break;
            case "PrepararInventario":
                this.frmPrepararInv.grabar();
                break;
            case "Conteo":
                this.frmConteo.grabar();
                break;
            case "CerrarInventario":
                this.frmCerrarInv.grabar();
                break;
            case "CrearLote":
                this.frmCrearLote.grabar();
                break;
            case "ModificarLote":
                this.frmModificarLote.grabar();
                break;
            case "jifreporte7":
                this.xjifreporte.grabar();
                break;
            case "jifsuministrolote":
                this.xjifsuministrolote.mGrabar();
                break;
            case "jifsolicitudproductos":
                this.xjifsolicitudpr.mGrabar();
                break;
            case "jifcompras1":
                this.xjifcomprai.mGrabar();
                break;
            case "jismodificarsolicitudp":
                this.xjifmodificars.mGrabar();
                break;
            case "jifgestionpendiente":
                this.xjifgestionpendiente.mGrabar();
                break;
            case "jifcompras2":
                this.xjifcomprai.mGrabar();
                break;
            case "jifcierrescontables":
                this.xjifcierrecontables.mGrabar();
                break;
            case "jifmodificarcodagrup":
                this.jifmodcodagrupacion.grabar();
                break;
            case "jifmodificarr":
                this.jifmodificarr.mGrabar();
                break;
            case "xjifmonitoreoinventario":
                this.xjifmonitoreoinventario.mGrabar();
                break;
            case "xjifajustarpminmax":
                this.xjifajustarminmax.mGrabar();
                break;
            case "Temperatura Bodega":
                this.xjiftempbodega.mGrabar();
                break;
            case "jifnotamedicaSF":
                this.xjifvisitasdom.grabar();
                break;
            case "jifperiodocontableI":
                this.xjifperiodocontableI.mGrabar();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "Entradas":
                this.frmEntrada.imprimir();
                break;
            case "Despachos":
                this.frmDespacho.mImprimir();
                break;
            case "Traslados":
            case "ITraslados":
                imprimirTraslado();
                break;
            case "ImprimirInventario":
                this.frmImprimirInv.imprimir();
                break;
            case "jifcompras1":
                this.xjifcomprai.mImprimir();
                break;
            case "jifcompras2":
                this.xjifcomprai.mImprimir();
                break;
            case "Temperatura Bodega":
                this.xjiftempbodega.mImprimir();
                break;
            case "xjifauditoriaaleatoria":
                this.xjifauditoria.mImprimir();
                break;
            case "xjifmonitoreoinventario":
                this.xjifmonitoreoinventario.mImprimir();
                break;
            case "Salidas":
                this.frmSalida.imprimir();
                break;
            case "xjifinformesdespachopaciente":
                this.xJIFInformesDespachoPaciente.mImprimir();
                break;
            case "Informes1.5":
                this.xJIFFConsultarInformacionGenerico.mIprimir(this.idBodega);
                break;
            case "jiff_InformeDeSalidas":
                this.xInformeSalidas.mImprimir();
                break;
            case "xjifinventariogeneral":
                this.xJIFInventarioGeneral.imprimir();
                break;
        }
    }

    private void imprimirTraslado() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "numero";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "NbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_Traslados", parametros);
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "Entradas":
                this.frmEntrada.nuevo();
                break;
            case "jifadicionarp":
                this.jifadicionarproductos.nuevo();
                break;
            case "xjifconsolidadocierrecontable":
                this.xJIFConsolidadoCierresContables.mNuevo();
                break;
            case "jifmodificarr":
                this.jifmodificarr.mNuevo();
                break;
            case "Despachos":
                this.frmDespacho.nuevo();
                break;
            case "jifmodificarcodagrup":
                this.jifmodcodagrupacion.nuevo();
                break;
            case "Salidas":
                this.frmSalida.nuevo();
                break;
            case "ITraslados":
                this.frmTraslado.nuevo();
                break;
            case "Faltantes":
                this.frmFaltante.nuevo();
                break;
            case "PrepararInventario":
                this.frmPrepararInv.nuevo();
                break;
            case "Conteo":
                this.frmConteo.nuevo();
                break;
            case "CerrarInventario":
                this.frmCerrarInv.nuevo();
                break;
            case "CrearLote":
                this.frmCrearLote.nuevo();
                break;
            case "ModificarLote":
                this.frmModificarLote.nuevo();
                break;
            case "jifreporte7":
                this.xjifreporte.nuevo();
                break;
            case "jifgestionpendiente":
                this.xjifgestionpendiente.mNuevo();
                break;
            case "jifsolicitudproductos":
                this.xjifsolicitudpr.mNuevo();
                break;
            case "jifcompras1":
                this.xjifcomprai.mNuevo();
                break;
            case "jifcompras2":
                this.xjifcomprai.mNuevo();
                break;
            case "jifcierrescontables":
                this.xjifcierrecontables.mNuevo();
                break;
            case "xjifconsultarinf":
                this.xjifconsultarinfsum.mNuevo();
                break;
            case "jifconsultarformulas":
                this.xjifconsultarformulas.mNuevo();
                break;
            case "xjifconsolidadomovimiento":
                this.xjifinformeconsmovimiento.mNuevo();
                break;
            case "Temperatura Bodega":
                this.xjiftempbodega.mNuevo();
                break;
            case "jifnotamedicaSF":
                this.xjifvisitasdom.nuevo();
                break;
            case "jifperiodocontableI":
                this.xjifperiodocontableI.mNuevo();
                break;
            case "xjifauditoriaaleatoria":
                this.xjifauditoria.mNuevo();
                break;
            case "jifinformeestradas":
                this.xJIFInformeEntradas.mNuevo();
                break;
            case "xjifinformesdespachopaciente":
                this.xJIFInformesDespachoPaciente.mNuevo();
                break;
            case "xjifconsolidadosalidas":
                this.xJIFConsolidadoSalidas.mNuevo();
                break;
            case "xjifconsolidadoentradas":
                this.xJIFConsolidadoEntradas.mNuevo();
                break;
            case "Informes1.5":
                this.xJIFFConsultarInformacionGenerico.mNuevo();
                break;
            case "jiff_InformeDeSalidas":
                this.xInformeSalidas.mNuevo();
                break;
            case "jifSuministrosFechaInvima":
                this.consultarSuministroFechaInvima.nuevo();
                break;
            default:
                this.metodos.mostrarMensaje("Esta Opción no esta permitida para esta Pantalla");
                break;
        }
    }

    public void mSumarCantidadInventario(int xidproducto, Double xcantidad, String xlote, String xfechav, Double xcpendiente) {
        try {
            String xsql = "SELECT Id, Lote FROM i_suministroxlotexbodega WHERE (Id ='" + xidproducto + "' AND Lote ='" + xlote + "')";
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                ConsultasMySQL ct = new ConsultasMySQL();
                String xsql2 = "update i_suministroxlotexbodega set Cantidad=Cantidad+" + xcantidad + ", CPendiente=CPendiente+" + xcpendiente + " where id=" + xidproducto + " and Lote='" + xlote + "'";
                ct.ejecutarSQL(xsql2);
                ct.cerrarConexionBd();
            } else {
                ConsultasMySQL ct2 = new ConsultasMySQL();
                String xsql3 = "insert into i_suministroxlotexbodega (Id, Lote, FechaVencimiento, Cantidad, CPendiente) values ('" + xidproducto + "','" + xlote + "','" + xfechav + "','" + xcantidad + "','" + xcpendiente + "')";
                ct2.ejecutarSQL(xsql3);
                ct2.cerrarConexionBd();
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarValorTarifa(String CodigoCUM, String CodigoATC, double xValor) {
        if (!CodigoCUM.isEmpty() || !CodigoATC.isEmpty()) {
            String xsql = "UPDATE f_tarifasuministro,(SELECT\n    `i_suministro`.`Id` AS IdSuministro\n    , `f_manual`.`Id` AS IdManual\nFROM\n    `f_tarifasuministro`\n    INNER JOIN `f_manual` \n        ON (`f_tarifasuministro`.`Id_manual` = `f_manual`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`f_tarifasuministro`.`Id_suministro` = `i_suministro`.`Id`)\nWHERE ( `i_suministro`.`CodigoCUM` ='" + CodigoCUM + "'\n    AND `i_suministro`.`CodigoAtc` ='" + CodigoATC + "'\n    AND `f_manual`.`Estado` = 0\n    AND `f_manual`.`ActualizarValorCompra` =1)) AS a\n    SET f_tarifasuministro.`Valor`=" + xValor + " WHERE f_tarifasuministro.`Id_suministro`=a.IdSuministro AND f_tarifasuministro.`Id_manual`=a.IdManual";
            this.xct.ejecutarSQL(xsql);
            this.xct.cerrarConexionBd();
        }
    }

    public void iniciarDatosFacturacion(String idSalida, String documento) {
        this.frmPrincipal.mIniciarDatosFacturacionInventario(idSalida, documento);
    }

    public void mActualizarValorPromedio(int xidproducto, double xvalor, double xvaloriva) {
        try {
            String xsql = "SELECT SUM(i_suministroxlotexbodega.Cantidad) AS Cantidad, i_suministroxbodega.Costo  FROM i_suministroxlotexbodega  INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)  WHERE (i_suministroxlotexbodega.Id ='" + xidproducto + "') GROUP BY i_suministroxlotexbodega.Id HAVING (Cantidad >=0) ";
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                rs.first();
                double xvalort = xvalor + xvaloriva;
                if (rs.getInt(1) > 0 && rs.getInt(2) > 0) {
                    String xsql2 = "update i_suministroxbodega set Costo=(((Costo)+ " + xvalort + ")/2) where id=" + xidproducto;
                    this.xct.ejecutarSQL(xsql2);
                    this.xct.cerrarConexionBd();
                } else {
                    String xsql3 = "update i_suministroxbodega set Costo=" + xvalort + " where id=" + xidproducto;
                    this.xct.ejecutarSQL(xsql3);
                    this.xct.cerrarConexionBd();
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarValorPromedioPanzenu(int idproducto, double xvalor, double valoriva, double cantidad) {
        try {
            String xsql = "SELECT SUM(i_suministroxlotexbodega.Cantidad) AS Cantidad, i_suministroxbodega.Costo  FROM i_suministroxlotexbodega  INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)  WHERE (i_suministroxlotexbodega.Id ='" + idproducto + "') GROUP BY i_suministroxlotexbodega.Id HAVING (Cantidad >=0) ";
            System.out.println(xsql);
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                rs.first();
                double xvalorU = xvalor + valoriva;
                System.out.println("aqui esta la cantidad" + cantidad);
                if (rs.getInt(1) > 0 && rs.getInt(2) > 0) {
                    double valor = xvalorU / cantidad;
                    System.out.println("aqui esta el valor: " + valor);
                    this.xct.ejecutarSQL("update i_suministroxbodega set Costo=" + valor + "  where id=" + idproducto);
                    this.xct.cerrarConexionBd();
                } else {
                    double valor2 = xvalorU / cantidad;
                    System.out.println("aqui esta el valor: " + valor2);
                    this.xct.ejecutarSQL("update i_suministroxbodega set Costo=" + valor2 + "  where id=" + idproducto);
                    this.xct.cerrarConexionBd();
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarValorPromedioSanJorge(int xidproducto, double xvalor, double xvaloriva, double cantidad) {
        double xcosto;
        try {
            String xsql = "SELECT\n    SUM(`i_suministroxlotexbodega`.`Cantidad`)Cantidad\n    , `i_suministroxbodega`.`Costo`\n    , `i_suministroxlotexbodega`.`Cantidad`\n    , `i_suministroxbodega`.`Id`\n    , `i_suministroxbodega`.`IdBodega`\n    , `i_suministroxbodega`.`IdSuministro`\nFROM\n    .`i_suministroxlotexbodega`\n    INNER JOIN `i_suministroxbodega` \n        ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`)\nWHERE (`i_suministroxbodega`.`Id` ='" + xidproducto + "')";
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                rs.first();
                double xvalort = (xvalor + xvaloriva) * cantidad;
                System.err.println("Valor 1" + xvalort);
                double cantidadN = cantidad + rs.getDouble(1);
                System.err.println("Cantidad" + cantidadN);
                ConsultasMySQL xct1 = new ConsultasMySQL();
                if (rs.getInt(1) > 0 && rs.getInt(2) > 0) {
                    xcosto = ((rs.getDouble(2) * rs.getDouble(1)) + xvalort) / cantidadN;
                } else {
                    xcosto = xvalort / cantidadN;
                }
                String xsql2 = "update i_suministroxbodega set Costo=" + xcosto + " where id=" + rs.getInt(4);
                xct1.ejecutarSQL(xsql2);
                xct1.cerrarConexionBd();
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    String xsql3 = "update i_suministroxbodega set Costo=" + xcosto + " where IdSuministro=" + rs.getInt(4) + " and IdBodega<>" + rs.getInt(5);
                    xct1.ejecutarSQL(xsql3);
                    xct1.cerrarConexionBd();
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mDescontarCantidadInventario(int xidproducto, Double xcantidad, String xlote, String xnentrada, String xafectacosto) {
        String xsql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad - '" + xcantidad + "') WHERE (Id = '" + xidproducto + "') AND (Lote = '" + xlote + "')";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
        if (xafectacosto.equals("1")) {
            ResultSet rs = this.xct.traerRs("SELECT ValorActual FROM i_tmpentrada WHERE (Id_Entrada ='" + xnentrada + "' AND Id_Suministro ='" + xidproducto + "')");
            try {
                if (rs.next()) {
                    rs.first();
                    mActualizarValormasIvaDelSuministro(0.0d, rs.getDouble(1), xidproducto);
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mActualizarIvaDelSuministro(double xiva, long xidproducto) {
        String xsql = "UPDATE i_suministro SET  Iva =" + xiva + " WHERE (Id = '" + xidproducto + "')";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    public void mActualizarValormasIvaDelSuministro(double xviva, double xvproducto, long xidproductobodega) {
        String xsql = "UPDATE i_suministroxbodega SET Costo = (" + (xvproducto + xviva) + ") WHERE (Id = '" + xidproductobodega + "')";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0146: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:20:0x0146 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x014b: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x014b */
    public String mVerificarSiProductoenBodega(String xid, String xidbodegad) {
        String xidproducto = "";
        try {
            try {
                String sql = "SELECT Id FROM i_suministroxbodega WHERE (IdSuministro ='" + xid + "' AND IdBodega ='" + xidbodegad + "') ";
                ResultSet rs = this.xct.traerRs(sql);
                Throwable th = null;
                if (rs.next()) {
                    xidproducto = rs.getString(1);
                } else {
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    String sql2 = "insert into i_suministroxbodega(IdBodega, IdSuministro, Minimo, Maximo, Reposicion, Existencia, Costo, Fecha, UsuarioS) values ('" + xidbodegad + "','" + xid + "','0','0','0','0','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    xidproducto = xct1.ejecutarSQLId(sql2);
                    String sql3 = "insert into i_suministroxlotexbodega(Id, Lote, FechaVencimiento, Cantidad) values ('" + xidproducto + "','FALTANTE','2050-12-31','0')";
                    xct1.ejecutarSQL(sql3);
                    xct1.cerrarConexionBd();
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
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xidproducto;
    }

    public void mBuscarIdPeriodoContable() {
        try {
            ResultSet rs = this.xct.traerRs("SELECT Id, Date_format(FechaI,'%m/%Y') as Fecha, Activo, FechaI, FechaF FROM i_periodo WHERE (Activo =1 AND Estado =1) ");
            if (rs.next()) {
                rs.last();
                if (rs.getRow() > 1) {
                    this.xidperiodoc = -1;
                } else {
                    rs.first();
                    this.xidperiodoc = rs.getInt(1);
                    this.xfechaperiodoi = rs.getString(2);
                    setXestadop(rs.getBoolean(3));
                    setXfechai(rs.getDate(4));
                    setXfechaf(rs.getDate(5));
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean mVerificarMovDPeriodo(Date xfecha) {
        boolean xestado = false;
        try {
            String sql = "SELECT IF('" + this.metodos.formatoAMD1.format(xfecha) + "' >=FechaI && '" + this.metodos.formatoAMD1.format(xfecha) + "' <=FechaF,FALSE,TRUE) AS FFecha FROM i_periodo WHERE i_periodo.Activo=1 AND i_periodo.Estado=1 AND DATE_FORMAT(i_periodo.`FechaF`,'%Y-%m')='" + this.metodos.formatoANO_MES.format(xfecha) + "'";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                xestado = rs.getBoolean(1);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    public void mActualizarFechaRotacion(long xidproducto) {
        String xsql = "update i_suministroxbodega set i_suministroxbodega.FechaUR='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "' where Id='" + xidproducto + "'";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
        String xsql2 = "SELECT i_suministroxbodega.IdSuministro FROM i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.Id ='" + xidproducto + "' AND i_suministroxbodega.CInventario =1) GROUP BY i_suministroxbodega.Id HAVING (SUM(i_suministroxlotexbodega.Cantidad) =0) ";
        ResultSet xrs = this.xct.traerRs(xsql2);
        try {
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                String xsql3 = "update i_suministro set ActivoHc=0 where Id='" + xrs.getLong(1) + "'";
                xct1.ejecutarSQL(xsql3);
                xct1.cerrarConexionBd();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getXfechaperiodo() {
        return this.xfechaperiodoi;
    }

    public void setXfechaperiodo(String xfechaperiodo) {
        this.xfechaperiodoi = xfechaperiodo;
    }

    public int getXidperiodoc() {
        return this.xidperiodoc;
    }

    public String getXfechaperiodof() {
        return this.xfechaperiodof;
    }

    public void setXfechaperiodof(String xfechaperiodof) {
        this.xfechaperiodof = xfechaperiodof;
    }

    public void setXfechai(Date xfechai) {
        this.xfechai = xfechai;
    }

    public void setXfechaf(Date xfechaf) {
        this.xfechaf = xfechaf;
    }

    public Date getXfechaf() {
        return this.xfechaf;
    }

    public Date getXfechai() {
        return this.xfechai;
    }

    public void setXestadop(boolean xestadop) {
        this.xestadop = xestadop;
    }

    public boolean isXestadop() {
        return this.xestadop;
    }

    public boolean mValidarFechasDoc(Date xfecha1) {
        boolean xestado = false;
        GregorianCalendar fecha = new GregorianCalendar();
        Date fecha1 = new Date();
        String texto = this.metodos.formatoDMA.format(xfecha1);
        String texto1 = this.metodos.formatoH24.format(fecha1);
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        String hora = texto1.substring(0, 2);
        String minuto = texto1.substring(3, 5);
        String segundo = texto1.substring(6, 8);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto), Integer.parseInt(segundo));
        Date fecha12 = fecha.getTime();
        if (fecha12.getTime() >= this.xfechai.getTime() && fecha12.getTime() <= this.xfechaf.getTime()) {
            xestado = true;
        }
        return xestado;
    }

    public String getxBodegaDestino() {
        return this.xBodegaDestino;
    }

    public void setxBodegaDestino(String xBodegaDestino) {
        this.xBodegaDestino = xBodegaDestino;
    }

    public void setXidperiodoc(int xidperiodoc) {
        this.xidperiodoc = xidperiodoc;
    }

    public void mReportesEntradas(String xidEntrada) {
        String nbreArchivo;
        String nbreArchivo2;
        String nbreArchivo3;
        Object[] botones = {"Acta Recepción", "Entrada", "Entrada Agrupada", "Todas", "Cerrar"};
        switch (this.metodos.getPregunta2("Por Favor Seleccione el Reporte a Imprimir", botones, "Cerrar")) {
            case 0:
                String[][] parametros = new String[5][2];
                parametros[0][0] = "numero";
                parametros[0][1] = xidEntrada;
                parametros[1][0] = "ruta";
                parametros[1][1] = this.metodos.getRutaRep();
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                parametros[4][0] = "nbreUsuario";
                parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    nbreArchivo3 = "I_ActaRecepcion";
                } else {
                    nbreArchivo3 = Principal.informacionIps.getPrefijoReportes() + "I_ActaRecepcion_1";
                }
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo3, parametros);
                break;
            case 1:
                String[][] parametros2 = new String[5][2];
                parametros2[0][0] = "numero";
                parametros2[0][1] = xidEntrada;
                parametros2[1][0] = "nbreUsuario";
                parametros2[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros2[2][0] = "ruta";
                parametros2[2][1] = this.metodos.getRutaRep();
                parametros2[3][0] = "SUBREPORT_DIR";
                parametros2[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros2[4][0] = "SUBREPORTFIRMA_DIR";
                parametros2[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    nbreArchivo2 = "I_EntradaAInventario";
                } else {
                    nbreArchivo2 = Principal.informacionIps.getPrefijoReportes() + "I_EntradaAInventario_1";
                }
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo2, parametros2);
                break;
            case 2:
                String[][] parametros3 = new String[5][2];
                parametros3[0][0] = "numero";
                parametros3[0][1] = xidEntrada;
                parametros3[1][0] = "nbreUsuario";
                parametros3[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros3[2][0] = "ruta";
                parametros3[2][1] = this.metodos.getRutaRep();
                parametros3[3][0] = "SUBREPORT_DIR";
                parametros3[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros3[4][0] = "SUBREPORTFIRMA_DIR";
                parametros3[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    nbreArchivo = "I_EntradaAInventarioAgrupada";
                } else {
                    nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "I_EntradaAInventarioAgrupada";
                }
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo, parametros3);
                break;
            case 3:
                String[][] parametros4 = new String[5][2];
                parametros4[0][0] = "numero";
                parametros4[0][1] = xidEntrada;
                parametros4[1][0] = "nbreUsuario";
                parametros4[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros4[2][0] = "ruta";
                parametros4[2][1] = this.metodos.getRutaRep();
                parametros4[3][0] = "SUBREPORT_DIR";
                parametros4[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros4[4][0] = "SUBREPORTFIRMA_DIR";
                parametros4[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_EntradaAInventario", parametros4);
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_ActaRecepcion", parametros4);
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_EntradaAInventarioAgrupada", parametros4);
                } else {
                    String nbreArchivo4 = Principal.informacionIps.getPrefijoReportes() + "I_EntradaAInventario_1";
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo4, parametros4);
                    String nbreArchivo5 = Principal.informacionIps.getPrefijoReportes() + "I_ActaRecepcion_1";
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo5, parametros4);
                    String nbreArchivo6 = Principal.informacionIps.getPrefijoReportes() + "I_EntradaAInventarioAgrupada";
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo6, parametros4);
                }
                break;
        }
    }

    public void mActualizarValores_Inventario(String xidbodega, String xperiodo) {
        String sql = "UPDATE `i_suministroxbodega`  SET `i_suministroxbodega`.`CExistencia`=0, `i_suministroxbodega`.`VInicial`=0, `i_suministroxbodega`.`CEntrada`=0, `i_suministroxbodega`.`CSalida`=0    WHERE `i_suministroxbodega`.`IdBodega` ='" + xidbodega + "' ";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle = "SELECT `i_detalleentrada`.`IdSuministro` AS `Id`, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`  FROM ((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) WHERE ((`i_entradas`.`Estado` = 0) AND (`i_entradas`.`IdBodega` = '" + xidbodega + "') AND (`i_entradas`.`Id_Periodo` >= 39 AND `i_entradas`.`Id_Periodo` <='" + xperiodo + "' )) GROUP BY `i_detalleentrada`.`IdSuministro` ";
        String sqlw = "CREATE VIEW i_tmp_datos AS " + sqle;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
        String sql2 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CEntrada`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega`='" + xidbodega + "' ";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle2 = "SELECT`i_detallesalida`.`IdSuministro` AS `Id`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad` FROM (`i_detallesalida` JOIN `i_salidas`  ON ((`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`))) WHERE ((`i_salidas`.`IdBodega` = '" + xidbodega + "')AND (`i_salidas`.`Id_Periodo` >= 39 AND `i_salidas`.`Id_Periodo` <= '" + xperiodo + "' ) AND (`i_salidas`.`Estado` = 0)) GROUP BY `i_detallesalida`.`IdSuministro` HAVING (`Cantidad` <> 0) ";
        String sqlw2 = "CREATE VIEW i_tmp_datos AS " + sqle2;
        this.xct.ejecutarSQL(sqlw2);
        this.xct.cerrarConexionBd();
        String sql3 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CSalida`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega` ='" + xidbodega + "' ";
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle3 = "SELECT `i_suministroxbodega`.`Id` AS `Id`, SUM(`i_suministroxlotexbodega`.`Cantidad`) AS `Cantidad` FROM (`i_suministroxlotexbodega` JOIN `i_suministroxbodega` ON ((`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`))) WHERE (`i_suministroxbodega`.`IdBodega` = '" + xidbodega + "') GROUP BY `i_suministroxbodega`.`Id` HAVING (`Cantidad` <> 0) ";
        String sqlw3 = "CREATE VIEW i_tmp_datos AS " + sqle3;
        this.xct.ejecutarSQL(sqlw3);
        this.xct.cerrarConexionBd();
        String sql4 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CExistencia`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`Id` AND i_suministroxbodega.`IdBodega` ='" + xidbodega + "' ";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle4 = "SELECT  `i_detalleentrada`.`IdSuministro` , ROUND(AVG(`i_detalleentrada`.`ValorUnitario`)) AS Valor FROM  `i_detalleentrada`  INNER JOIN `i_entradas`  ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_detalleentrada`.`IdSuministro`) INNER JOIN `i_suministro`  ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`) WHERE (`i_entradas`.`Estado`=0 AND `i_entradas`.`IdBodega` ='" + xidbodega + "' AND `i_entradas`.`Id_Periodo` >=27 AND `i_entradas`.`Id_Periodo` <='" + xperiodo + "') GROUP BY `i_detalleentrada`.`IdSuministro` ";
        String sqlw4 = "CREATE VIEW i_tmp_datos AS " + sqle4;
        this.xct.ejecutarSQL(sqlw4);
        this.xct.cerrarConexionBd();
        String sql5 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`VInicial`=i_tmp_datos.Valor WHERE i_tmp_datos.IdSuministro=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega` ='" + xidbodega + "' ";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
    }

    public boolean mConsultar_NDoc_Contable(int xtipo, long xnumero) {
        if (xtipo == 0) {
        }
        return false;
    }
}
