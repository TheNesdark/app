package Citas;

import Acceso.Principal;
import Facturacion.Ingreso;
import Facturacion.JPEventoECat;
import General.Anular;
import General.JDAtencionesPreferenciales;
import General.JD_Anexo3;
import General.Persona;
import Historia.JIFAgendaMedico_N;
import Odontologia.JDTratamientos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.citas.JIFCarneCitas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CitaNP.class */
public class CitaNP extends JInternalFrame {
    private String[] xidsede;
    private String[][] listaClaseCita;
    private String sql;
    private String idCita;
    private String xsql;
    public int combocc;
    private Object[] dato;
    private DefaultTableModel modelo;
    public Persona frmPersona1;
    public Ingreso frmIngreso;
    private clasesCita clasescita;
    private hiloCNP hiloCNP;
    private Thread hilo;
    private JPEventoECat xJPEventoECat;
    private JD_Anexo3 xJD_Anexo3;
    private String MetodoFact;
    private boolean xlleno;
    private ButtonGroup GpoRemitido;
    private JButton JBT_AgendaMed;
    private JButton JBT_AgregarP;
    private JComboBox JCBSede;
    private JCheckBox JCHSaludOcupacional;
    public JCheckBox JCH_SParto;
    private JCheckBox JCH_Urgente;
    private JPanel JPIFondo;
    private JScrollPane JSP_HISTORICO;
    private JScrollPane JSP_Observacion;

    /* JADX INFO: renamed from: JTA_Observación, reason: contains not printable characters */
    private JTextArea f1JTA_Observacin;
    private JTextField JTFInstitucion;
    public JTextField JTFTratamientoO;
    public JRadioButton btnInterconsulta;
    public JRadioButton btnNoRemitido;
    public JRadioButton btnRemitido;
    public static JComboBox cboClaseCita;
    public static JTable grid;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel6;
    private JPanel panelIngreso;
    private JPanel panelPersona;
    public static JTextField txtConsultorio;
    private JTextField txtDuracion;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int filaGrid = 0;
    public int remitida = -1;
    public int xUrgente = 0;
    private int xsaludocupacional = 0;
    private int xSParto = 0;
    private String xid_Atencion = "";

    public CitaNP(clasesCita clase) {
        this.xlleno = false;
        initComponents();
        this.clasescita = clase;
        this.xlleno = false;
        iniciar();
        if (Principal.informacionIps.getNombreIps().equals("SALUD A SU HOGAR IPS S.A.S.")) {
            this.JBT_AgregarP.setEnabled(true);
        }
    }

    private boolean mVerificarCitasAsignadas() {
        boolean xestado = false;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            try {
                this.sql = "SELECT Id_Usuario, Id_Especialidad, Fecha_Cita, Id_MotivoDesistida FROM  c_citas WHERE (Id_Usuario ='" + this.frmPersona1.getIdPersona() + "' AND Id_Especialidad ='" + this.frmIngreso.getIdEspecialidad() + "' AND Fecha_Cita ='" + this.metodos.formatoAMD.format(this.frmIngreso.txtFecha.getDate()) + "' AND Id_MotivoDesistida =1) ";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                if (xrs.next()) {
                    xestado = true;
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(CitaNP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xestado;
    }

    public void anularAtencion(String id) {
    }

    private void mGrabar_Facturacion() {
        this.sql = "SELECT MetodoFact \n FROM c_citasnp   \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n WHERE (c_citasnp.Id ='" + this.idCita + "')";
        this.MetodoFact = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        switch (this.MetodoFact) {
            case "0":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n Valor AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,Valor,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,Valor,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f.CualValor=0,(((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMinimo),(((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMaximo)),f_procedempresaconvenio.Valor) AS Valor,\n t.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  WHERE f_procedimcentrocosto.Estado=0 GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`) \n WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1) ) TAB";
                String xN_Orden = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto , Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n\t porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\n\tSELECT c_citasnp.Id_ingreso  ,\n\t f_tiposervtipoproced.Idtiposervicio ,\n\t c_citasnp.Fecha_Cita ,\n\t c_citasnp.HoraInicial , \n\t c_citasnp.Id_Profesional ,\n\t c_citasnp.Id_Especialidad ,\n\t IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n\t g_procedimiento.Id,\n\t c_clasecita.Id_Finalidad,\n\t 1 AS Cantidad,\n\t f.Id_TipoPlan AS Id_TipoPlanEmp,\n\t f.MetodoFact,\n\t f.Redondeo,\n\t IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f.CualValor=0, t.VrMinimo,t.VrMaximo),f_procedempresaconvenio.Valor)  AS Valor,\n\t t.Id_TipoPlan AS Id_TipoPlanProc, \n\t g_procedimiento.porcentajeImpuesto, \n\t IF(f.CualValor=0, ((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100),((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)) AS valorImpuesto \n\t FROM c_citasnp   \n\t INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n\t INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n\t INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n\t INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n\t AND (t.Id_Manual = f.Id_Manual) \n\t INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n\t LEFT JOIN \n\t\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t WHERE f_procedimcentrocosto.Estado=0\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n\t ON \t aux.Id_Procedimiento=g_procedimiento.Id\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`)\n\t WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1)\t ) TAB";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
            case "1":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n VTotal AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,VTotal,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,VTotal,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\n((((SELECT IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100)+(SELECT IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor)) AS VTotal ,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n INNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_EmpresaConvenio=f.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`) \nLEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  WHERE f_procedimcentrocosto.Estado=0 GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id  --          LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`) \n WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1) ) TAB";
                String xN_Orden2 = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto , Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden2 + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n  porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\n`g_procedimiento`.`porcentajeImpuesto`,\n(((SELECT IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100) AS valorImpuesto,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n INNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_EmpresaConvenio=f.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \nLEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t WHERE f_procedimcentrocosto.Estado=0  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`)\n WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1)\t ) TAB";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
            case "2":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n VTotal AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,VTotal,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,VTotal,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n g_procedimiento.Id_TipoFinProced,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n((((SELECT IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100)+(SELECT IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor)) AS VTotal,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN f_servicioempresaconv   ON (f_servicioempresaconv.Id_EmpresaConvenio = f.Id) \n INNER JOIN f_manual ON f_servicioempresaconv.Id_Manual_n=f_manual.Id\n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON g_procedimiento.Id=t.Id_Procedimiento AND t.Id_Manual=f_manual.Id\n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t\tAND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n\t    LEFT JOIN g_historico_salario_minimo ON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t WHERE f_procedimcentrocosto.Estado=0 GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`)\n WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1) ) TAB";
                System.out.println("graba en ordenes -> " + this.sql);
                String xN_Orden3 = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto, Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden3 + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n  porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0, ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0, ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n(((SELECT IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0, ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0, ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100) AS valorImpuesto,\n`g_procedimiento`.`porcentajeImpuesto`,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN f_servicioempresaconv   ON (f_servicioempresaconv.Id_EmpresaConvenio = f.Id) \n INNER JOIN f_manual ON f_servicioempresaconv.Id_Manual_n=f_manual.Id\n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON g_procedimiento.Id=t.Id_Procedimiento AND t.Id_Manual=f_manual.Id\n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t\tAND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n\t    LEFT JOIN g_historico_salario_minimo ON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\tWHERE f_procedimcentrocosto.Estado=0  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`)\n WHERE (c_citasnp.Id ='" + this.idCita + "' AND f_tiposervicio.`EsConsulta`=1) ) TAB";
                System.out.println("graba en item orden -> " + this.sql);
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
        }
        mActualizar_Estado_citas();
    }

    public void mActualizar_Estado_citas() {
        this.sql = "Update c_citasnp set  EstaFacturada = 1, Id_ingreso='" + this.frmIngreso.getIdIngreso() + "' where id='" + this.idCita + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void asignarCita() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (validarDatos() == 1 && this.frmPersona1.validarDatos(1) == 1 && this.frmIngreso.getValidarComponentes() == 1) {
                if (!mVerificarCitasAsignadas()) {
                    if (Principal.informacionGeneralPrincipalDTO.getAplicaAtencionPreferencial().booleanValue()) {
                        JDAtencionesPreferenciales xjdatencion = new JDAtencionesPreferenciales(null, true, this);
                        xjdatencion.setVisible(true);
                    }
                    this.frmPersona1.grabar();
                    this.frmIngreso.grabar(this.frmPersona1.getIdPersona());
                    grabarCita();
                    if (this.JTFTratamientoO.getText().equals("0")) {
                        grabarAtencion();
                    } else {
                        mActualizaIngresoenCitas();
                    }
                    Principal.lblNo.setText("No. Ingreso");
                    Principal.txtNo.setText(this.frmIngreso.getIdIngreso());
                    Principal.txtEstado.setText("ACTIVA");
                    Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                    this.consultas.cerrarConexionBd();
                    cargarPacientesAgendados();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Usuario con cita programada para este dia.\nFavor revisar", "CONSULTAR CITASPROGRAMADAS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cita ya grabada!!!!", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void cargarClaseCita(int xfiltro, String xFecha, String xSexo) {
        String xsql;
        cboClaseCita.removeAllItems();
        this.xlleno = false;
        if (xfiltro == 0) {
            xsql = "SELECT c_clasecita.Id, c_clasecita.Nbre, c_clasecita.Duracion, `g_causaexterna`.`Nbre` AS CExterna, c_clasecita.Id_Finalidad \nFROM c_clasecita INNER JOIN `g_causaexterna` ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `c_clasecita_tipoatencion` ON (`c_clasecita`.`Id`=c_clasecita_tipoatencion.`idClaseCita`)\nWHERE (c_clasecita.Id_Especialidad = '" + this.frmIngreso.getIdEspecialidad() + "' AND c_clasecita_tipoatencion.`idTipoAtencion`='" + this.frmIngreso.cboTipoAtencion.getPopupTable().getValueAt(this.frmIngreso.cboTipoAtencion.getSelectedIndex(), 0).toString() + "' AND c_clasecita_tipoatencion.`Estado`=1 AND c_clasecita.Estado = 0 ) \nORDER BY c_clasecita.Nbre ASC";
        } else {
            xsql = "SELECT c_clasecita.Id, c_clasecita.Nbre, c_clasecita.Duracion, `g_causaexterna`.`Nbre` AS CExterna, c_clasecita.Id_Finalidad \nFROM c_clasecita INNER JOIN `g_causaexterna` ON (`c_clasecita`.`Id_CausaExterna` = `g_causaexterna`.`Id`) INNER JOIN `c_clasecita_tipoatencion` ON (`c_clasecita`.`Id`=c_clasecita_tipoatencion.`idClaseCita`)\nWHERE (c_clasecita.Id_Especialidad = '" + this.frmIngreso.getIdEspecialidad() + "' AND c_clasecita_tipoatencion.`idTipoAtencion`='" + this.frmIngreso.cboTipoAtencion.getPopupTable().getValueAt(this.frmIngreso.cboTipoAtencion.getSelectedIndex(), 0).toString() + "' AND c_clasecita_tipoatencion.`Estado`=1 AND c_clasecita.Estado = 0 \nAND `Sexo` IN ('A', '" + xSexo + "') \n AND ( DATEDIFF(NOW(),'" + xFecha + "') >= EdadI  AND DATEDIFF(NOW(),'" + xFecha + "') <= EdadM )) \nORDER BY c_clasecita.Nbre ASC";
        }
        this.listaClaseCita = this.consultas.llenarComboyLista(xsql, this.listaClaseCita, cboClaseCita, 5);
        this.consultas.cerrarConexionBd();
        if (!Principal.informacionIps.getIdentificacion().equals("8296850")) {
            if (cboClaseCita.getItemCount() >= 0) {
                cboClaseCita.setSelectedIndex(-1);
                this.combocc = 1;
                this.xlleno = true;
                return;
            }
            return;
        }
        cboClaseCita.setSelectedIndex(0);
    }

    private void cargarPanelPersona() {
        this.frmPersona1 = new Persona(this);
        this.frmPersona1.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona1.setBounds(1, 1, 980, 160);
        this.panelPersona.add(this.frmPersona1);
        this.panelPersona.setVisible(true);
        this.frmPersona1.citaNp = true;
    }

    private void cargarPanelIngreso() {
        this.frmIngreso = new Ingreso(this, "CitaNP", "1");
        this.frmIngreso.setVisible(true);
        this.panelIngreso.setVisible(false);
        this.frmIngreso.setBounds(1, 1, 1190, 200);
        this.panelIngreso.add(this.frmIngreso);
        this.panelIngreso.setVisible(true);
    }

    public void cargarPacientesAgendados() {
        this.sql = "SELECT concat(c_citasnp.fecha_Cita,' ',c_citasnp.HoraInicial) as Fecha, profesional1.`NProfesional`, c_clasecita.Nbre, c_clasecita.Duracion, c_citasnp.Id AS NoCita, c_citasnp.Id_ingreso as Ingreso, h_atencion.Id as Atencion, c_citasnp.Fecha_Cita, IF(c_citasnp.`EstaFacturada`=0, 'POR FACTURAR','FACTURADA') as Estado FROM w_persona INNER JOIN c_citasnp ON (w_persona.Id_persona = c_citasnp.Id_Usuario) INNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN ingreso ON (c_citasnp.Id_ingreso = ingreso.Id) INNER JOIN `profesional1` ON (c_citasnp.`Id_Profesional` = profesional1.`Id_Persona`)  AND (c_citasnp.`Id_Especialidad` = profesional1.`IdEspecialidad`) INNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE ( c_citasnp.Id_Especialidad ='" + this.frmIngreso.getIdEspecialidad() + "'  and c_citasnp.Id_Usuario='" + this.frmPersona1.IdPersona + "' AND c_citasnp.Id_Anulada =0) ORDER BY c_citasnp.fecha_Cita DESC ,c_citasnp.HoraInicial ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        crearGrid();
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.filaGrid++;
                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString("NProfesional"), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Nbre"), this.filaGrid, 2);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt("Duracion")), this.filaGrid, 3);
                this.modelo.setValueAt(Long.valueOf(rs.getLong("NoCita")), this.filaGrid, 4);
                this.modelo.setValueAt(Long.valueOf(rs.getLong("Ingreso")), this.filaGrid, 5);
                this.modelo.setValueAt(Long.valueOf(rs.getLong("Atencion")), this.filaGrid, 6);
                this.modelo.setValueAt("", this.filaGrid, 7);
                this.modelo.setValueAt(rs.getString("Estado"), this.filaGrid, 7);
                grid.setDefaultRenderer(Object.class, new MiRender());
            } catch (SQLException ex) {
                this.consultas.mostrarErrorE(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty() || !this.frmIngreso.getIdIngreso().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "idingreso";
            parametros[0][1] = this.frmIngreso.getIdIngreso();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Certificado_Ingreso", parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso En Blanco!!!!", "BUSCAR INGRESO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitaNP$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 7).toString().equals("FACTURADA")) {
                cell.setBackground(new Color(204, 255, 204));
                cell.setForeground(new Color(0, 0, 0));
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(new Color(0, 0, 0));
            }
            return cell;
        }
    }

    public final void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Hora", "Profesional", "Clase Cita", "Duración", "No. Cita", "No. Ingreso", "No. Atención", "Estado"}) { // from class: Citas.CitaNP.1
            Class[] types = {String.class, String.class, String.class, Integer.class, Long.class, Long.class, Long.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        grid.setAutoResizeMode(0);
        grid.doLayout();
        grid.setModel(this.modelo);
        grid.getColumnModel().getColumn(0).setPreferredWidth(150);
        grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        grid.getColumnModel().getColumn(2).setPreferredWidth(150);
        grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.filaGrid = -1;
    }

    public void desistir() {
        if (grid.getSelectedRow() != -1) {
            if (this.clasescita.verificarAtencionDx(Long.valueOf(this.modelo.getValueAt(grid.getSelectedRow(), 5).toString())).booleanValue()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    Anular frm = new Anular(null, true, "CitaNP", 7);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("Esta cita ya posee un ingreso");
        }
    }

    public void desistirCita(String detalle, String razon) {
        this.sql = "UPDATE c_citasnp SET  Id_Anulada ='" + razon + "' WHERE (Id='" + this.modelo.getValueAt(grid.getSelectedRow(), 4).toString() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE h_atencion SET  Estado =1 WHERE (Id='" + this.modelo.getValueAt(grid.getSelectedRow(), 6).toString() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE Ingreso SET  Estado =1 WHERE (Id='" + this.modelo.getValueAt(grid.getSelectedRow(), 5).toString() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "INSERT INTO c_desistidas (Id, Tipo, Detalle, Fecha, UsuarioS) VALUES('" + Principal.txtNo.getText() + "','2','" + detalle + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        cargarPacientesAgendados();
        this.metodos.mostrarMensaje("Cita Desistida");
    }

    private String grabarAtencion() {
        switch (Principal.informacionIps.getNombreIps()) {
            case "EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO":
                this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, `Remitido`,  `Institucion`, Urgente,Estado, Fecha, UsuarioS) VALUES ('" + this.frmIngreso.getIdIngreso() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActualPC()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','" + this.f1JTA_Observacin.getText() + "','','1','','','','','" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.remitida + "','" + this.JTFInstitucion.getText().toUpperCase() + "','" + this.xUrgente + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                break;
            case "CLINICA PAJONAL S.A.S":
            case "CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.":
            case "CAMBIA TU VIDA IPS SAS":
            case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA":
            case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
            case "UNION TEMPORAL CLINICA LAURELES":
            case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion,  Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, `Remitido`,  `Institucion`, Urgente,Estado, Fecha, UsuarioS) VALUES ('" + this.frmIngreso.getIdIngreso() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','','1','','','','','" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.remitida + "','" + this.JTFInstitucion.getText().toUpperCase() + "','" + this.xUrgente + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                break;
            default:
                this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, `Remitido`,  `Institucion`, Urgente,Estado, Fecha, UsuarioS) VALUES ('" + this.frmIngreso.getIdIngreso() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','','','1','','','','','" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.remitida + "','" + this.JTFInstitucion.getText().toUpperCase() + "','" + this.xUrgente + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                break;
        }
        String retorno = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "update ingreso set Id_Atencion='" + retorno + "', CS_Parto='" + this.xSParto + "' where Id='" + this.frmIngreso.getIdIngreso() + "'";
        Principal.txtNo.setText(this.frmIngreso.getIdIngreso());
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.xid_Atencion = retorno;
        mGrabar_Hospitalizacion();
        return retorno;
    }

    private void grabarCita() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
            this.sql = "INSERT INTO c_citasnp (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, Remitida, PrimerVez, Id_ingreso, So, Observacion,Urgente, Fecha, UsuarioS,Id_TratamientoO,NAutorizacion, Id_Sede, Id_UsuarioS) VALUES ('" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.frmPersona1.getIdPersona() + "','" + this.frmIngreso.getIdEmpresa() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.metodos.getFechaActualPC()) + "','" + this.remitida + "','" + this.clasescita.getCita1erVez(this.frmPersona1.getIdPersona(), this.frmIngreso.getIdEspecialidad()) + "','" + this.frmIngreso.getIdIngreso() + "','" + this.xsaludocupacional + "','" + this.f1JTA_Observacin.getText() + "','" + this.xUrgente + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFTratamientoO.getText() + "','" + this.frmIngreso.txtNoAutorizacion.getText() + "','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        } else if (Principal.informacionIps.getIdentificacion().equals("812001424")) {
            this.sql = "INSERT INTO c_citasnp (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, Remitida, PrimerVez, Id_ingreso, So, Observacion,Urgente, Fecha, UsuarioS,Id_TratamientoO,NAutorizacion, Id_Sede, Id_UsuarioS) VALUES ('" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.frmPersona1.getIdPersona() + "','" + this.frmIngreso.getIdEmpresa() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','" + this.remitida + "','" + this.clasescita.getCita1erVez(this.frmPersona1.getIdPersona(), this.frmIngreso.getIdEspecialidad()) + "','" + this.frmIngreso.getIdIngreso() + "','" + this.xsaludocupacional + "','" + this.f1JTA_Observacin.getText() + "','" + this.xUrgente + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFTratamientoO.getText() + "','" + this.frmIngreso.txtNoAutorizacion.getText() + "','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        } else {
            this.sql = "INSERT INTO c_citasnp (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, Remitida, PrimerVez, Id_ingreso, So, Observacion,Urgente, Fecha, UsuarioS,Id_TratamientoO,NAutorizacion, Id_Sede, Id_UsuarioS) VALUES ('" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.frmPersona1.getIdPersona() + "','" + this.frmIngreso.getIdEmpresa() + "','" + this.listaClaseCita[cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','" + this.remitida + "','" + this.clasescita.getCita1erVez(this.frmPersona1.getIdPersona(), this.frmIngreso.getIdEspecialidad()) + "','" + this.frmIngreso.getIdIngreso() + "','" + this.xsaludocupacional + "','" + this.f1JTA_Observacin.getText() + "','" + this.xUrgente + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFTratamientoO.getText() + "','" + this.frmIngreso.txtNoAutorizacion.getText() + "','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        }
        this.idCita = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.idCita);
        this.consultas.cerrarConexionBd();
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") && !Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") && !Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") && !this.btnRemitido.isSelected()) {
            mGrabar_Facturacion();
        }
        mVerificaCausaExterna();
    }

    private void mVerificaCausaExterna() {
        if (this.frmIngreso.cboCausaExterna.getPopupTable().getValueAt(this.frmIngreso.cboCausaExterna.getSelectedIndex(), 0).equals("2") || this.frmIngreso.cboCausaExterna.getPopupTable().getValueAt(this.frmIngreso.cboCausaExterna.getSelectedIndex(), 0).equals("6")) {
            this.xJPEventoECat = new JPEventoECat(null, true, this.frmPersona1.IdPersona, Long.valueOf(this.frmIngreso.cboCausaExterna.getPopupTable().getValueAt(this.frmIngreso.cboCausaExterna.getSelectedIndex(), 0).toString()).longValue(), Long.valueOf(this.frmIngreso.xidCondVict[this.frmIngreso.JCBCondVict.getSelectedIndex()].toString()).longValue(), this.frmIngreso.getIdIngreso());
            this.xJPEventoECat.setVisible(true);
        }
    }

    private void mActualizaIngresoenCitas() {
        String sql = "SELECT `h_atencion`.`Id_Ingreso`, h_atencion.`Id`  FROM `o_hc_tratamiento` INNER JOIN `baseserver`.`h_atencion`  ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`o_hc_tratamiento`.`Id` ='" + this.JTFTratamientoO.getText() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                String xIngreso = xrs.getString("Id_Ingreso");
                String sql2 = "UPDATE c_citasnp SET Id_ingreso='" + xIngreso + "' WHERE `Id`='" + this.idCita + "'";
                xct.ejecutarSQL(sql2);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void iniciar() {
        Principal.mLimpiarDatosP();
        cargarPanelPersona();
        cargarPanelIngreso();
        crearGrid();
        this.hiloCNP = new hiloCNP(this);
        this.hilo = new Thread(this.hiloCNP);
        this.hilo.start();
        this.xsql = "SELECT `g_sedes`.`Id` , `g_sedes`.`Nbre`\nFROM `g_usuario_sist_sede` INNER JOIN `g_sedes`  ON (`g_usuario_sist_sede`.`Id_Sede` = `g_sedes`.`Id`)\nWHERE (`g_usuario_sist_sede`.`Id_Persona` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND `g_usuario_sist_sede`.`Estado` =1)\nORDER BY `g_sedes`.`Nbre` ASC";
        this.JCBSede.removeAllItems();
        this.xidsede = this.consultas.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
    }

    private void interConsulta() {
        Remitidos frm1 = new Remitidos(this.frmPersona1.txtHistoria.getText(), this, 2);
        frm1.setVisible(true);
    }

    public void buscarPersona() {
        this.frmPersona1.buscar(2);
    }

    public void nuevo() {
        this.combocc = 0;
        Principal.mLimpiarDatosP();
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(-1);
        this.frmPersona1.nuevo();
        this.frmIngreso.nuevo();
        this.btnNoRemitido.setSelected(true);
        this.xsaludocupacional = 0;
        this.JCHSaludOcupacional.setSelected(false);
        cboClaseCita.setSelectedIndex(-1);
        txtConsultorio.setText("");
        this.f1JTA_Observacin.setText("");
        this.txtDuracion.setText("");
        this.JCH_Urgente.setSelected(false);
        this.JCH_SParto.setSelected(false);
        this.xUrgente = 0;
        this.xSParto = 0;
        crearGrid();
        this.frmPersona1.txtHistoria.requestFocus();
        this.JTFTratamientoO.setText("0");
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.frmPersona1.txtApellido1.getText().isEmpty() || this.frmPersona1.txtNombre1.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor registre un Usuario y coloque sus Nombres y Apellidos.");
            this.frmPersona1.txtApellido1.requestFocus();
        } else if (this.JCBSede.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Sede");
            this.JCBSede.requestFocus();
        } else if (cboClaseCita.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Clase de Cita");
            cboClaseCita.requestFocus();
        } else {
            retorno = this.frmIngreso.getValidarComponentes();
        }
        return retorno;
    }

    public void hiloEvaluador() {
        if (Integer.parseInt(this.frmIngreso.getIdEspecialidad()) > 0 && Integer.parseInt(this.frmIngreso.getIdProfesional()) > 0) {
            cargarPacientesAgendados();
        }
    }

    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.GpoRemitido = new ButtonGroup();
        this.JPIFondo = new JPanel();
        this.panelPersona = new JPanel();
        this.panelIngreso = new JPanel();
        this.jLabel4 = new JLabel();
        this.jPanel1 = new JPanel();
        cboClaseCita = new JComboBox();
        this.txtDuracion = new JTextField();
        txtConsultorio = new JTextField();
        this.jPanel6 = new JPanel();
        this.btnNoRemitido = new JRadioButton();
        this.btnRemitido = new JRadioButton();
        this.btnInterconsulta = new JRadioButton();
        this.JTFInstitucion = new JTextField();
        this.JCHSaludOcupacional = new JCheckBox();
        this.JCH_Urgente = new JCheckBox();
        this.JCH_SParto = new JCheckBox();
        this.JTFTratamientoO = new JTextField();
        this.JSP_HISTORICO = new JScrollPane();
        grid = new JTable();
        this.JSP_Observacion = new JScrollPane();
        this.f1JTA_Observacin = new JTextArea();
        this.JCBSede = new JComboBox();
        this.JBT_AgregarP = new JButton();
        this.JBT_AgendaMed = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ASIGNACIÓN DE CITA NO PROGRAMADA");
        setDoubleBuffered(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("CitaNP");
        setPreferredSize(new Dimension(1180, 783));
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.CitaNP.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                CitaNP.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFondo.setLayout(new AbsoluteLayout());
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 990, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.JPIFondo.add(this.panelPersona, new AbsoluteConstraints(0, 0, 990, 160));
        this.panelIngreso.setBorder(BorderFactory.createEtchedBorder());
        this.panelIngreso.setPreferredSize(new Dimension(1199, 185));
        GroupLayout panelIngresoLayout = new GroupLayout(this.panelIngreso);
        this.panelIngreso.setLayout(panelIngresoLayout);
        panelIngresoLayout.setHorizontalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1156, 32767));
        panelIngresoLayout.setVerticalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 206, 32767));
        this.JPIFondo.add(this.panelIngreso, new AbsoluteConstraints(0, 160, 1160, 210));
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(0, 0, 204));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscarCita.jpg")));
        this.jLabel4.setText("Buscar Citas");
        this.jLabel4.setToolTipText("Muestra todas las citas que han sido asignadas al usuario");
        this.jLabel4.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel4.setCursor(new Cursor(0));
        this.jLabel4.setHorizontalTextPosition(0);
        this.jLabel4.setVerticalTextPosition(3);
        this.jLabel4.addMouseListener(new MouseAdapter() { // from class: Citas.CitaNP.3
            public void mouseClicked(MouseEvent evt) {
                CitaNP.this.jLabel4MouseClicked(evt);
            }
        });
        this.JPIFondo.add(this.jLabel4, new AbsoluteConstraints(1000, 0, 140, 150));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE CITA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        cboClaseCita.setFont(new Font("Arial", 1, 12));
        cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        cboClaseCita.setName("cboClaseCita");
        cboClaseCita.addItemListener(new ItemListener() { // from class: Citas.CitaNP.4
            public void itemStateChanged(ItemEvent evt) {
                CitaNP.this.cboClaseCitaItemStateChanged(evt);
            }
        });
        cboClaseCita.addMouseListener(new MouseAdapter() { // from class: Citas.CitaNP.5
            public void mouseClicked(MouseEvent evt) {
                CitaNP.this.cboClaseCitaMouseClicked(evt);
            }
        });
        cboClaseCita.addActionListener(new ActionListener() { // from class: Citas.CitaNP.6
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.cboClaseCitaActionPerformed(evt);
            }
        });
        this.txtDuracion.setEditable(false);
        this.txtDuracion.setBackground(new Color(0, 0, 153));
        this.txtDuracion.setFont(new Font("Arial", 1, 12));
        this.txtDuracion.setForeground(new Color(255, 255, 255));
        this.txtDuracion.setHorizontalAlignment(0);
        this.txtDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtDuracion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtDuracion.setEnabled(false);
        this.txtDuracion.setName("txtDuracion");
        txtConsultorio.setEditable(false);
        txtConsultorio.setBackground(new Color(0, 0, 153));
        txtConsultorio.setFont(new Font("Arial", 1, 12));
        txtConsultorio.setForeground(new Color(255, 255, 255));
        txtConsultorio.setHorizontalAlignment(0);
        txtConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        txtConsultorio.setDisabledTextColor(new Color(255, 255, 255));
        txtConsultorio.setEnabled(false);
        txtConsultorio.setName("txtConsultorio");
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Viene Remitido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel6.setLayout((LayoutManager) null);
        this.GpoRemitido.add(this.btnNoRemitido);
        this.btnNoRemitido.setFont(new Font("Arial", 1, 12));
        this.btnNoRemitido.setSelected(true);
        this.btnNoRemitido.setText("No");
        this.btnNoRemitido.addActionListener(new ActionListener() { // from class: Citas.CitaNP.7
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.btnNoRemitidoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnNoRemitido);
        this.btnNoRemitido.setBounds(20, 20, 50, 19);
        this.GpoRemitido.add(this.btnRemitido);
        this.btnRemitido.setFont(new Font("Arial", 1, 12));
        this.btnRemitido.setText("Si");
        this.btnRemitido.addActionListener(new ActionListener() { // from class: Citas.CitaNP.8
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.btnRemitidoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnRemitido);
        this.btnRemitido.setBounds(80, 20, 50, 19);
        this.GpoRemitido.add(this.btnInterconsulta);
        this.btnInterconsulta.setFont(new Font("Arial", 1, 12));
        this.btnInterconsulta.setText("Interconsulta");
        this.btnInterconsulta.addActionListener(new ActionListener() { // from class: Citas.CitaNP.9
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.btnInterconsultaActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnInterconsulta);
        this.btnInterconsulta.setBounds(160, 20, 100, 19);
        this.JTFInstitucion.setFont(new Font("Arial", 1, 12));
        this.JTFInstitucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Insitución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel6.add(this.JTFInstitucion);
        this.JTFInstitucion.setBounds(10, 40, 280, 40);
        this.JCHSaludOcupacional.setFont(new Font("Arial", 1, 12));
        this.JCHSaludOcupacional.setText("Salud Ocupacional");
        this.JCHSaludOcupacional.addActionListener(new ActionListener() { // from class: Citas.CitaNP.10
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JCHSaludOcupacionalActionPerformed(evt);
            }
        });
        this.JCH_Urgente.setFont(new Font("Arial", 1, 12));
        this.JCH_Urgente.setForeground(Color.red);
        this.JCH_Urgente.setText("Urgente?");
        this.JCH_Urgente.addActionListener(new ActionListener() { // from class: Citas.CitaNP.11
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JCH_UrgenteActionPerformed(evt);
            }
        });
        this.JCH_SParto.setFont(new Font("Arial", 1, 12));
        this.JCH_SParto.setForeground(Color.red);
        this.JCH_SParto.setText("S. Parto");
        this.JCH_SParto.setToolTipText("Clasificar solo si es materna y va para la sala de partos");
        this.JCH_SParto.addActionListener(new ActionListener() { // from class: Citas.CitaNP.12
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JCH_SPartoActionPerformed(evt);
            }
        });
        this.JTFTratamientoO.setEditable(false);
        this.JTFTratamientoO.setFont(new Font("Arial", 1, 18));
        this.JTFTratamientoO.setForeground(Color.red);
        this.JTFTratamientoO.setHorizontalAlignment(0);
        this.JTFTratamientoO.setText("0");
        this.JTFTratamientoO.setToolTipText("Código Tratamiento Odontología");
        this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Tratamiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTratamientoO.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFTratamientoO.setName("txtCupo");
        this.JTFTratamientoO.addMouseListener(new MouseAdapter() { // from class: Citas.CitaNP.13
            public void mouseClicked(MouseEvent evt) {
                CitaNP.this.JTFTratamientoOMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHSaludOcupacional, -2, 142, -2).addGap(2, 2, 2).addComponent(this.JCH_Urgente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SParto)).addComponent(this.JTFTratamientoO, -2, 120, -2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -2, 302, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.txtDuracion, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtConsultorio, -2, 192, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(cboClaseCita, -2, 302, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(cboClaseCita, -2, 50, -2).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDuracion, -2, 50, -2).addComponent(txtConsultorio, -2, 50, -2)).addGap(5, 5, 5).addComponent(this.jPanel6, -2, 83, -2).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSaludOcupacional, -2, 20, -2).addComponent(this.JCH_Urgente, -2, 20, -2).addComponent(this.JCH_SParto, -2, 20, -2)).addGap(5, 5, 5).addComponent(this.JTFTratamientoO, -2, 40, -2).addGap(5, 5, 5)));
        this.JSP_HISTORICO.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        grid.setFont(new Font("Arial", 1, 12));
        grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        grid.setAutoResizeMode(3);
        grid.setCellSelectionEnabled(true);
        grid.setName("grid");
        grid.setRowHeight(25);
        grid.setSelectionBackground(new Color(255, 255, 255));
        grid.setSelectionForeground(new Color(255, 0, 0));
        grid.setSelectionMode(0);
        grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitaNP.14
            public void mouseClicked(MouseEvent evt) {
                CitaNP.this.gridMouseClicked(evt);
            }
        });
        this.JSP_HISTORICO.setViewportView(grid);
        this.JSP_Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.f1JTA_Observacin.setColumns(1);
        this.f1JTA_Observacin.setFont(new Font("Arial", 1, 12));
        this.f1JTA_Observacin.setRows(1);
        this.JSP_Observacion.setViewportView(this.f1JTA_Observacin);
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSede.setName("cboClaseCita");
        this.JCBSede.addActionListener(new ActionListener() { // from class: Citas.CitaNP.15
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JCBSedeActionPerformed(evt);
            }
        });
        this.JBT_AgregarP.setFont(new Font("Arial", 1, 12));
        this.JBT_AgregarP.setForeground(new Color(0, 0, 255));
        this.JBT_AgregarP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Consolidado.png")));
        this.JBT_AgregarP.setText("ANEXO 3");
        this.JBT_AgregarP.setEnabled(false);
        this.JBT_AgregarP.addActionListener(new ActionListener() { // from class: Citas.CitaNP.16
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JBT_AgregarPActionPerformed(evt);
            }
        });
        this.JBT_AgendaMed.setFont(new Font("Arial", 1, 12));
        this.JBT_AgendaMed.setForeground(new Color(0, 0, 255));
        this.JBT_AgendaMed.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.JBT_AgendaMed.setText("Agenda Profesional");
        this.JBT_AgendaMed.addActionListener(new ActionListener() { // from class: Citas.CitaNP.17
            public void actionPerformed(ActionEvent evt) {
                CitaNP.this.JBT_AgendaMedActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIFondo, -2, -1, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSP_Observacion, -2, 496, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_AgregarP, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JBT_AgendaMed, -2, 162, -2)).addComponent(this.JSP_HISTORICO, -2, 810, -2)).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSede, 0, -1, 32767).addComponent(this.jPanel1, -2, -1, -2)))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPIFondo, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JSP_HISTORICO, -2, 290, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_AgendaMed, -2, 55, -2).addComponent(this.JBT_AgregarP, -2, 55, -2)).addComponent(this.JSP_Observacion, -2, 65, -2)).addGap(20, 20, 20)).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCBSede, -2, 50, -2).addGap(2, 2, 2).addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()))));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaActionPerformed(ActionEvent evt) {
        if (this.xlleno && cboClaseCita.getSelectedIndex() > -1) {
            this.txtDuracion.setText(this.listaClaseCita[cboClaseCita.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNoRemitidoActionPerformed(ActionEvent evt) {
        this.remitida = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRemitidoActionPerformed(ActionEvent evt) {
        this.remitida = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInterconsultaActionPerformed(ActionEvent evt) {
        interConsulta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel4MouseClicked(MouseEvent evt) {
        JIFCarneCitas frmB = new JIFCarneCitas(null, true, this.frmPersona1.getIdPersona(), "CitaNP", this);
        frmB.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSaludOcupacionalActionPerformed(ActionEvent evt) {
        if (this.JCHSaludOcupacional.isSelected()) {
            this.xsaludocupacional = 1;
        } else {
            this.xsaludocupacional = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (grid.getSelectedRow() != -1) {
            this.frmIngreso.cargarIngreso(this.modelo.getValueAt(grid.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AgendaMedActionPerformed(ActionEvent evt) {
        if (this.frmIngreso.cboEspecialidad.getSelectedIndex() != -1) {
            JIFAgendaMedico_N JIFAgendaMedico = new JIFAgendaMedico_N(this.frmIngreso.getIdProfesional(), this.frmIngreso.getIdEspecialidad(), 1);
            Principal.informacionGeneralPrincipalDTO.setAsignacionCitaAgenda(false);
            Principal.cargarPantalla(JIFAgendaMedico);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_UrgenteActionPerformed(ActionEvent evt) {
        if (this.JCH_Urgente.isSelected()) {
            this.xUrgente = 1;
        } else {
            this.xUrgente = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SPartoActionPerformed(ActionEvent evt) {
        if (this.JCH_SParto.isSelected()) {
            this.xSParto = 1;
        } else {
            this.xSParto = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTratamientoOMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()].equals("1024") || this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()].equals("1023") || this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()].equals("461") || this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()].equals("1032") || this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()].equals("250")) {
                JDTratamientos xtratmientoO = new JDTratamientos(Principal.clasescita.frmPrincipal, true, this);
                xtratmientoO.setLocationRelativeTo(Principal.clasescita.frmPrincipal);
                xtratmientoO.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaItemStateChanged(ItemEvent evt) {
        if (cboClaseCita.getSelectedIndex() != -1 && this.xlleno && !Principal.informacionIps.getNombreIps().equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
            this.frmIngreso.cboCausaExterna.setSelectedItem(this.listaClaseCita[cboClaseCita.getSelectedIndex()][2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AgregarPActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.xJD_Anexo3 = new JD_Anexo3(null, true, this);
            this.xJD_Anexo3.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Ingreso En Blanco!!!!", "BUSCAR INGRESO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mGrabar_Hospitalizacion() {
        if (this.frmIngreso.cboTipoAtencion.getSelectedItem().equals("HOSPITALIZACION")) {
            try {
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs("SELECT  `Id` FROM `h_orden_hospitalizacion` WHERE (`Id_Atencion`  ='" + this.xid_Atencion + "' AND `Estado` =1)");
                if (!xrs.next()) {
                    mDuplicar_Ingreso_Hospitalizacion(Principal.txtNo.getText());
                    if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        this.sql = "insert into h_orden_hospitalizacion(`Id_Atencion`, `FechaH`, `Id_Profesional_O`, `Id_Especialidad_O`, `Dx_Cie10`, `Observacion`, `UsuarioS`) values('" + this.xid_Atencion + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmIngreso.xIdProfesional[this.frmIngreso.cboProfesional.getSelectedIndex()] + "','" + this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()] + "','0000','','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                    }
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(CitaNP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mDuplicar_Ingreso_Hospitalizacion(String Id_Ingreso) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.xsql = "insert into h_notasclinicas (`Id_Atencion` , `Id_Tipo_Atencion` , `Id_TipoNota` , `FechaNota` , `HoraNota` , `Descripcion` , `Id_Profesional` , `Id_Especialidad` , `UsuarioS`) values('" + this.xid_Atencion + "','2','32','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','SE ORDENA HOSPITALIZACIÓN','" + this.frmIngreso.xIdProfesional[this.frmIngreso.cboProfesional.getSelectedIndex()] + "','" + this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xid_NotaClinica = this.consultas.ejecutarSQLId(this.xsql);
            this.consultas.cerrarConexionBd();
            this.xsql = "insert into h_ordenes_interconsultas(`Id_Nota`, `Id_Especialidad`, `UsuarioS`) values('" + xid_NotaClinica + "','" + this.frmIngreso.xidEspecialidad[this.frmIngreso.cboEspecialidad.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.xsql);
            this.consultas.cerrarConexionBd();
        }
    }
}
