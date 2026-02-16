package Triage;

import Acceso.Principal;
import Utilidades.Metodos;

/* JADX INFO: loaded from: GenomaP.jar:Triage/claseTriage.class */
public class claseTriage {
    private Agendar agendar;
    private Agenda agenda;
    private Triage triage;
    private AgendaLista agendalista;
    private BuscarTriage buscarTriage;
    private String idEspecial;
    private String nbreEspecial;
    private Metodos metodos = new Metodos();
    public Principal frmPrincipal;
    private int modulo;

    public claseTriage(Principal frmP, int xmodulo) {
        this.frmPrincipal = frmP;
        this.modulo = xmodulo;
    }

    public void botones(int boton, String frm) {
        if (frm.equals("Agendar") && boton == 1) {
            this.agendar.nuevo();
            return;
        }
        if (frm.equals("Agendar") && boton == 2) {
            this.agendar.grabar();
            return;
        }
        if (frm.equals("Agendar") && boton == 3) {
            this.agendar.anular();
            return;
        }
        if (frm.equals("Agendar") && boton == 4) {
            this.agendar.imprimir();
            return;
        }
        if (frm.equals("Agendar") && boton == 5) {
            this.agendar.buscar();
            return;
        }
        if (frm.equals("Agendar") && boton == 6) {
            this.agendar.desplazarRegistro();
            return;
        }
        if (frm.equals("Agendar") && boton == 7) {
            this.agendar.desplazarRegistro();
            return;
        }
        if (frm.equals("Agendar") && boton == 8) {
            this.agendar.desplazarRegistro();
            return;
        }
        if (frm.equals("Agendar") && boton == 9) {
            this.agendar.desplazarRegistro();
            return;
        }
        if (frm.equals("Agendar") && boton == 10) {
            this.agendar.cancelar();
            return;
        }
        if (frm.equals("Triage") && boton == 2) {
            this.triage.grabar();
            return;
        }
        if (frm.equals("Triage") && boton == 3) {
            this.triage.anular();
            return;
        }
        if (frm.equals("Triage") && boton == 4) {
            this.triage.imprimir();
            return;
        }
        if (frm.equals("Triage") && boton == 10) {
            this.agendar.cancelar();
            return;
        }
        if (frm.equals("BuscarTriage") && boton == 5) {
            this.buscarTriage.buscar();
        } else if (frm.equals("BuscarTriage") && boton == 1) {
            this.buscarTriage.nuevo();
        }
    }

    public int getModulo() {
        return this.modulo;
    }

    public void imprimirtriage(String No) {
        if (!No.isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdTriage";
            mparametros[0][1] = No;
            mparametros[1][0] = "ruta";
            mparametros[1][1] = this.metodos.getRutaRep();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "U_Triage", mparametros);
        }
    }

    public void nuevo(String pantalla) {
        if (pantalla.equals("Agendar")) {
            this.agendar = new Agendar(this);
            this.agendar.nuevo();
        }
    }

    public void Triage(int op, String idHistoria, String IdTriage) {
        switch (op) {
            case 1:
                this.agendar = new Agendar(this);
                Principal.cargarPantalla(this.agendar);
                break;
            case 2:
                this.agenda = new Agenda(this);
                Principal.cargarPantalla(this.agenda);
                break;
            case 3:
                this.triage = new Triage(idHistoria, IdTriage, this);
                Principal.cargarPantalla(this.triage);
                break;
            case 4:
                this.buscarTriage = new BuscarTriage(this);
                Principal.cargarPantalla(this.buscarTriage);
                break;
            case 5:
                this.agendalista = new AgendaLista(this);
                Principal.cargarPantalla(this.agendalista);
                break;
        }
    }

    public String getIdEspecial() {
        return this.idEspecial;
    }

    public String getNbreEspecial() {
        return this.nbreEspecial;
    }

    public void setIdEspecial(String id) {
        this.idEspecial = id;
    }

    public void setNbreEspecial(String nbre) {
        this.nbreEspecial = nbre;
    }
}
