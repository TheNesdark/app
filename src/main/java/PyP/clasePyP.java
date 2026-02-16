package PyP;

import Acceso.Principal;
import Citas.CitasGral;
import Citas.clasesCita;
import Historia.JIFAgendaMedico;
import Informes.JIFProgramacionActividadesPyP;
import Informes.JIFRActividades;
import Informes.JIFRegistroActividadesPyPUsuario;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.controller.pyp.JIF_AgendaVacunacion;
import com.genoma.plus.controller.pyp.JIF_EgresoPrograma;
import com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.sql.ResultSet;
import java.sql.SQLException;

/* JADX INFO: loaded from: GenomaP.jar:PyP/clasePyP.class */
public class clasePyP {
    public Principal frmPrincipal;
    public Vacunacion frmVacunacion;
    public JIFCACervix frmToma;
    public CACervixResultado frmResultado;
    public CACervixCorreo frmCACervixCorreo;
    private UsuarioxPrograma frmUxPrg;
    private JIFAgendaMedico xjifagenda;
    public CyD frmCyD;
    public CitasGral frmCita;
    private String sql;
    private long xidrecepcion = 0;
    private long xid_tipof = 0;
    private long xid_ingreso = 0;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private ResultSet rs;
    private String xidnhc;
    private JIFEnvioCorreoM xjifenviaremail;
    private JIFGestionProgramaP xjifgestionpolimedicados;
    private JIFUsuarioxPrograma xJIFUsuarioxPrograma;
    private JIFPyP_InformesC xjifpyp_informesc;
    private JIFRegistro4505 xJIFRegistro4505;
    private JIFRegistroActividadesPyPUsuario xJIFRegistroActividadesPyPUsuario;
    private JIFRActividades xJIFRActividades;
    private JIFProgramacionActividadesPyP xJIFProgramacionActividadesPyP;
    public JIF_AgendaVacunacion xJIFAgendaVacunacion;
    public JIF_Gestion_Examenes_PYP xJIFGestionExamen;
    private JIF_EgresoPrograma xJIFEgresoPrograma;
    private JIF_Reportes_PyP_Generico jifreportes;

    public clasePyP(Principal frm) {
        this.frmPrincipal = frm;
    }

    public String getXidnhc() {
        return this.xidnhc;
    }

    public void setXidnhc(String xidnhc) {
        this.xidnhc = xidnhc;
    }

    public long getXidrecepcion() {
        return this.xidrecepcion;
    }

    public void setXidrecepcion(long xidrecepcion) {
        this.xidrecepcion = xidrecepcion;
    }

    public long getXid_tipof() {
        return this.xid_tipof;
    }

    public void setXid_tipof(long xid_tipof) {
        this.xid_tipof = xid_tipof;
    }

    public long getXid_ingreso() {
        return this.xid_ingreso;
    }

    public void setXid_ingreso(long xid_ingreso) {
        this.xid_ingreso = xid_ingreso;
    }

    public void cargarPantalla(String frm, String xNHistoria, boolean xAgenda, Long xIdOrden, Long xIdIngreso, Long idProfesional, String nombreVacunador) {
        if (frm.equals("Vacunacion")) {
            if (this.frmVacunacion != null) {
                this.frmVacunacion.dispose();
            }
            this.frmVacunacion = new Vacunacion(xNHistoria, this, true, xIdOrden, xIdIngreso, idProfesional, nombreVacunador);
            Principal.cargarPantalla(this.frmVacunacion);
            this.frmVacunacion.moveToFront();
        }
    }

    public void cargarPantalla(String frm, int modulo) {
        switch (frm) {
            case "Toma":
                if (this.frmToma != null) {
                    this.frmToma.dispose();
                }
                this.frmToma = new JIFCACervix(this, modulo);
                Principal.cargarPantalla(this.frmToma);
                this.frmToma.moveToFront();
                break;
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Toma":
                if (this.frmToma != null) {
                    this.frmToma.dispose();
                }
                this.frmToma = new JIFCACervix(this, 0);
                Principal.cargarPantalla(this.frmToma);
                this.frmToma.moveToFront();
                break;
            case "Resultado":
                if (this.frmResultado != null) {
                    this.frmResultado.dispose();
                }
                this.frmResultado = new CACervixResultado(this);
                Principal.cargarPantalla(this.frmResultado);
                this.frmResultado.moveToFront();
                break;
            case "CACervixCorreo":
                if (this.xjifenviaremail != null) {
                    this.xjifenviaremail.dispose();
                }
                this.xjifenviaremail = new JIFEnvioCorreoM();
                Principal.cargarPantalla(this.xjifenviaremail);
                this.xjifenviaremail.moveToFront();
                break;
            case "AgendaVacunacion":
                if (this.xJIFAgendaVacunacion != null) {
                    this.xJIFAgendaVacunacion.dispose();
                }
                this.xJIFAgendaVacunacion = new JIF_AgendaVacunacion(this);
                Principal.cargarPantalla(this.xJIFAgendaVacunacion);
                this.xJIFAgendaVacunacion.moveToFront();
                break;
            case "Vacunacion":
                if (this.frmVacunacion != null) {
                    this.frmVacunacion.dispose();
                }
                this.frmVacunacion = new Vacunacion("0", this, false, new Long(0L), new Long(0L), new Long(0L), "0");
                Principal.cargarPantalla(this.frmVacunacion);
                this.frmVacunacion.moveToFront();
                break;
            case "Ingreso":
                if (this.frmUxPrg != null) {
                    this.frmUxPrg.dispose();
                }
                this.frmUxPrg = new UsuarioxPrograma(1, this);
                Principal.cargarPantalla(this.frmUxPrg);
                this.frmUxPrg.moveToFront();
                break;
            case "Egreso":
                if (this.frmUxPrg != null) {
                    this.frmUxPrg.dispose();
                }
                this.frmUxPrg = new UsuarioxPrograma(2, this);
                Principal.cargarPantalla(this.frmUxPrg);
                this.frmUxPrg.moveToFront();
                break;
            case "CyD":
                if (this.frmCyD != null) {
                    this.frmCyD.dispose();
                }
                this.frmCyD = new CyD(this);
                Principal.cargarPantalla(this.frmCyD);
                this.frmCyD.moveToFront();
                break;
            case "Cita":
                if (this.frmCita != null) {
                    this.frmCita.dispose();
                }
                Principal.clasescita = new clasesCita(this.frmPrincipal);
                this.frmCita = new CitasGral(Principal.clasescita, this.frmPrincipal);
                Principal.cargarPantalla(this.frmCita);
                this.frmCita.moveToFront();
                break;
            case "Agenda":
                if (this.frmResultado != null) {
                    this.frmResultado.dispose();
                }
                this.xjifagenda = new JIFAgendaMedico(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), this, 1);
                Principal.cargarPantalla(this.xjifagenda);
                this.xjifagenda.moveToFront();
                break;
            case "Toma1":
                if (this.frmToma != null) {
                    this.frmToma.dispose();
                }
                this.frmToma = new JIFCACervix(this, getXidnhc());
                Principal.cargarPantalla(this.frmToma);
                this.frmToma.moveToFront();
                break;
            case "Gestion Polimedicados":
                if (this.xjifgestionpolimedicados != null) {
                    this.xjifgestionpolimedicados.dispose();
                }
                this.xjifgestionpolimedicados = new JIFGestionProgramaP();
                Principal.cargarPantalla(this.xjifgestionpolimedicados);
                this.xjifgestionpolimedicados.moveToFront();
                break;
            case "Ingreso HTA":
                if (this.xJIFUsuarioxPrograma != null) {
                    this.xJIFUsuarioxPrograma.dispose();
                }
                this.xJIFUsuarioxPrograma = new JIFUsuarioxPrograma("xjifingresohta", "Ingreso de usuarios HTA");
                Principal.cargarPantalla(this.xJIFUsuarioxPrograma);
                this.xJIFUsuarioxPrograma.moveToFront();
                break;
            case "Ingreso Diabetes":
                if (this.xJIFUsuarioxPrograma != null) {
                    this.xJIFUsuarioxPrograma.dispose();
                }
                this.xJIFUsuarioxPrograma = new JIFUsuarioxPrograma("xjifingresodiabetes", "Ingreso de usuarios Diabetes");
                Principal.cargarPantalla(this.xJIFUsuarioxPrograma);
                this.xJIFUsuarioxPrograma.moveToFront();
                break;
            case "Informe de Citología":
                if (this.xjifpyp_informesc != null) {
                    this.xjifpyp_informesc.dispose();
                }
                this.xjifpyp_informesc = new JIFPyP_InformesC("xjif_pyp_informes", frm.toUpperCase());
                Principal.cargarPantalla(this.xjifpyp_informesc);
                this.xjifpyp_informesc.moveToFront();
                break;
            case "Registro individual 4505":
                if (this.xJIFRegistro4505 != null) {
                    this.xJIFRegistro4505.dispose();
                }
                this.xJIFRegistro4505 = new JIFRegistro4505();
                Principal.cargarPantalla(this.xJIFRegistro4505);
                this.xJIFRegistro4505.moveToFront();
                break;
            case "Registro Actividades por Usuario":
                if (this.xJIFRegistroActividadesPyPUsuario != null) {
                    this.xJIFRegistroActividadesPyPUsuario.dispose();
                }
                this.xJIFRegistroActividadesPyPUsuario = new JIFRegistroActividadesPyPUsuario();
                Principal.cargarPantalla(this.xJIFRegistroActividadesPyPUsuario);
                this.xJIFRegistroActividadesPyPUsuario.moveToFront();
                break;
            case "Registro Actividades":
                if (this.xJIFRActividades != null) {
                    this.xJIFRActividades.dispose();
                }
                this.xJIFRActividades = new JIFRActividades();
                Principal.cargarPantalla(this.xJIFRActividades);
                this.xJIFRActividades.moveToFront();
                break;
            case "ProActividades":
                if (this.xJIFProgramacionActividadesPyP != null) {
                    this.xJIFProgramacionActividadesPyP.dispose();
                }
                this.xJIFProgramacionActividadesPyP = new JIFProgramacionActividadesPyP();
                Principal.cargarPantalla(this.xJIFProgramacionActividadesPyP);
                this.xJIFProgramacionActividadesPyP.moveToFront();
                break;
            case "GestionProcedimientos":
                if (this.xJIFGestionExamen != null) {
                    this.xJIFGestionExamen.dispose();
                }
                this.xJIFGestionExamen = new JIF_Gestion_Examenes_PYP();
                Principal.cargarPantalla(this.xJIFGestionExamen);
                this.xJIFGestionExamen.moveToFront();
                break;
            case "Egreso de Usuarios Del Programa":
                if (this.xJIFEgresoPrograma != null) {
                    this.xJIFEgresoPrograma.dispose();
                }
                this.xJIFEgresoPrograma = new JIF_EgresoPrograma();
                Principal.cargarPantalla(this.xJIFEgresoPrograma);
                this.xJIFEgresoPrograma.moveToFront();
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(10, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public String[] getCitologiaAnterior(String idPersona, String idCitologia) {
        String ultimaCita = "0";
        String resultado = "0";
        String[] retorno = new String[2];
        this.sql = "SELECT p_citologia.FechaToma, p_citologia_conceptoestudio.Nbre, p_citologia.Id FROM p_citologia_resultados INNER JOIN p_citologia ON (p_citologia_resultados.Id_Citologia = p_citologia.Id) INNER JOIN p_citologia_conceptoestudio ON (p_citologia_resultados.Id_ConceptoEstudio = p_citologia_conceptoestudio.Id) WHERE (p_citologia.Id_Persona ='" + idPersona + "' AND p_citologia.Id <'" + idCitologia + "') ORDER BY p_citologia.Id DESC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                String id = this.rs.getString(3);
                this.rs.beforeFirst();
                while (true) {
                    if (!this.rs.next()) {
                        break;
                    }
                    if (this.rs.getString(3).equals(id)) {
                        ultimaCita = this.rs.getString(1);
                        resultado = resultado + this.rs.getString(2) + ", ";
                    } else {
                        resultado = resultado.substring(0, resultado.length() - 2);
                        break;
                    }
                }
            }
            retorno[0] = ultimaCita;
            retorno[1] = resultado;
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        return retorno;
    }

    public void imprimirCitologia(String idPersona, String idCitologia) {
    }

    public void anular(String frm) {
        if (frm.equals("Vacunacion")) {
            this.frmVacunacion.borrar();
        } else if (frm.equals("CACervixResultado")) {
            this.frmResultado.anular();
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "CACervixToma":
                this.frmToma.buscar();
                break;
            case "CACervixResultado":
                this.frmResultado.buscar();
                break;
            case "Vacunacion":
                this.frmVacunacion.buscar();
                break;
            case "jifenviaremail":
                this.xjifenviaremail.mBuscar();
                break;
            case "xjifgestionpolimedicados":
                this.xjifgestionpolimedicados.mBuscar();
                break;
            case "xjif_pyp_informes":
                this.xjifpyp_informesc.mBuscar();
                break;
            case "jifregactividadespyp":
                this.xJIFRegistroActividadesPyPUsuario.mBuscar();
                break;
            case "UsuarioxPrograma":
                this.frmUxPrg.mBuscar();
                break;
            case "xJifGestionExamenesPyp":
                this.xJIFGestionExamen.mBuscar();
                break;
            case "xjifegresoprograma":
                this.xJIFEgresoPrograma.mBuscar();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "Vacunacion":
                this.frmVacunacion.imprimirCarnet();
                break;
            case "UsuarioxPrograma":
                this.frmUxPrg.imprimir();
                break;
            case "CACervixToma":
                this.frmToma.mImprimir();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "Vacunacion":
                this.frmVacunacion.nuevo();
                break;
            case "CACervixToma":
                this.frmToma.mNuevo();
                break;
            case "CACervixResultado":
                this.frmResultado.nuevo();
                break;
            case "UsuarioxPrograma":
                this.frmUxPrg.nuevo();
                break;
            case "CyD":
                this.frmCyD.nuevo();
                break;
            case "xjifgestionpolimedicados":
                this.xjifgestionpolimedicados.mNuevo();
                break;
            case "xjifingresohta":
            case "xjifingresodiabetes":
                this.xJIFUsuarioxPrograma.mNuevo();
                break;
            case "xjif_pyp_informes":
                this.xjifpyp_informesc.mNuevo();
                break;
            case "xjifR4505":
                this.xJIFRegistro4505.mNuevo();
                break;
            case "jifregactividadespyp":
                this.xJIFRegistroActividadesPyPUsuario.mNuevo();
                break;
            case "jifractividadespyp":
                this.xJIFRActividades.nuevo();
                break;
            case "jifprogactividadespyp":
                this.xJIFProgramacionActividadesPyP.nuevo();
                break;
            case "xJifGestionExamenesPyp":
                this.xJIFGestionExamen.mNuevo();
                break;
            case "xjifegresoprograma":
                this.xJIFEgresoPrograma.mNuevo();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "Vacunacion":
                this.frmVacunacion.grabar();
                break;
            case "CACervixToma":
                this.frmToma.mGrabar();
                break;
            case "CACervixResultado":
                this.frmResultado.grabar();
                break;
            case "UsuarioxPrograma":
                this.frmUxPrg.grabar();
                break;
            case "xjifingresohta":
            case "xjifingresodiabetes":
                this.xJIFUsuarioxPrograma.mGrabar();
                break;
            case "CyD":
                this.frmCyD.grabar();
                break;
            case "jifractividadespyp":
                this.xJIFRActividades.grabar();
                break;
            case "jifprogactividadespyp":
                this.xJIFProgramacionActividadesPyP.grabar();
                break;
        }
    }

    public void irAlRegistro(int reg, String frm) {
        switch (reg) {
            case 1:
                Principal.txtNo.setText("1");
                break;
            case 2:
                int p = Integer.parseInt(Principal.txtNo.getText()) - 1;
                if (p < 1) {
                    p = 1;
                }
                Principal.txtNo.setText(String.valueOf(p));
                break;
            case 3:
                Principal.txtNo.setText(String.valueOf(Integer.parseInt(Principal.txtNo.getText()) + 1));
                break;
            case 4:
                Principal.txtNo.setText("-1");
                break;
        }
    }
}
