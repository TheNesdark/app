package Triage;

import Acceso.Menus;
import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/* JADX INFO: loaded from: GenomaP.jar:Triage/Agendar.class */
public class Agendar extends JInternalFrame {
    private Persona frmPersona;
    private String sql;
    private String[] listaEmpresa;
    private claseTriage clasetriage;
    private JComboBox cboEmpresa;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JPanel panelPersona;
    private JTextArea txtMotivoConsulta;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int cboLleno = 0;

    public Agendar(claseTriage Clasetriage) {
        initComponents();
        this.clasetriage = Clasetriage;
        this.frmPersona = new Persona(this);
        cargarPanelPersona();
        cargarCombos();
        nuevo();
    }

    public void menuA() {
        this.metodos.mostrarMensaje("Ok se activo");
    }

    public void anular() {
        this.metodos.mostrarMensaje("Opción pendiente por desarrollo");
    }

    public void buscar() {
        this.frmPersona.buscar(3);
    }

    public void cancelar() {
        this.metodos.mostrarMensaje("Opción pendiente por desarrollo");
    }

    private void cargarCombos() {
        this.sql = "SELECT Id, Nbre FROM f_empresacontxconvenio WHERE (Estado =0) ORDER BY Nbre ASC";
        this.listaEmpresa = this.consultas.llenarCombo(this.sql, this.listaEmpresa, this.cboEmpresa);
        this.cboEmpresa.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarPanelPersona() {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 980, 500);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    public void desplazarRegistro() {
        this.metodos.mostrarMensaje("Opción no permitida en esta Pantalla");
    }

    public void grabar() {
        if (this.frmPersona.txtHistoria.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor asigne un Usuario Para realizar el triage");
            return;
        }
        if (this.txtMotivoConsulta.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor asigne un Motivo de Consulta");
            this.txtMotivoConsulta.requestFocus();
        } else if (this.cboEmpresa.getSelectedIndex() < 0 && this.cboLleno == 1) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Empresa a la cual se Facturá");
            this.cboEmpresa.requestFocus();
        } else {
            this.frmPersona.grabar();
            grabarRegistro();
            Principal.desactivarBotonesGuardar();
        }
    }

    private void grabarRegistro() {
        this.sql = "INSERT INTO u_triageagenda(Id_Persona, Fecha_Agenda, Observacion, Id_EmpresaConv, Fecha, UsuarioS) VALUE('" + this.frmPersona.getIdPersona() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.txtMotivoConsulta.getText() + "','" + this.listaEmpresa[this.cboEmpresa.getSelectedIndex()] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        Principal.desactivarBotonesGuardar();
        this.metodos.mostrarMensaje("Registro Grabado");
    }

    public void imprimir() {
        this.metodos.mostrarMensaje("Botón no disponible para esta Pantalla");
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        Principal.txtNo.setText("");
        this.txtMotivoConsulta.setText("");
        this.cboEmpresa.setSelectedIndex(-1);
        Principal.activarBotones();
    }

    private void initComponents() {
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.txtMotivoConsulta = new JTextArea();
        this.jLabel3 = new JLabel();
        this.cboEmpresa = new JComboBox();
        this.jLabel1 = new JLabel();
        this.jLabel4 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("AGENDAR TRIAGE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Agendar");
        addInternalFrameListener(new InternalFrameListener() { // from class: Triage.Agendar.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                Agendar.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.panelPersona.setFont(new Font("Arial", 1, 12));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 990, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 180, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setFont(new Font("Arial", 1, 12));
        this.jPanel1.setLayout((LayoutManager) null);
        this.txtMotivoConsulta.setColumns(20);
        this.txtMotivoConsulta.setRows(5);
        this.txtMotivoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Consulta", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane1.setViewportView(this.txtMotivoConsulta);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 20, 580, 200);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Empresa a quien se Facturará");
        this.jPanel1.add(this.jLabel3);
        this.jLabel3.setBounds(680, 20, 170, 15);
        this.cboEmpresa.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.cboEmpresa);
        this.cboEmpresa.setBounds(600, 40, 360, 30);
        this.jLabel1.setBackground(new Color(0, 0, 102));
        this.jLabel1.setFont(new Font("Arial", 1, 24));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("AGENDAR TRIAGE");
        this.jLabel1.setOpaque(true);
        this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscarCita.jpg")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel4).addGap(176, 176, 176)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1, -1, 994, 32767).addContainerGap())).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addContainerGap()))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 980, -2).addContainerGap(24, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, 32767).addComponent(this.jLabel4, -2, 101, -2).addGap(69, 69, 69)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(266, 266, 266).addComponent(this.jPanel1, -2, 240, -2).addContainerGap(19, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasetriage.frmPrincipal.mQuitarBarraMenu();
        Principal principal = this.clasetriage.frmPrincipal;
        Menus menus = this.clasetriage.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuTriage, this.clasetriage.getModulo());
    }
}
