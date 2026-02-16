package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.jdesktop.layout.GroupLayout;

/* JADX INFO: loaded from: GenomaP.jar:General/AccesoModulos.class */
public class AccesoModulos extends JDialog {
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private DefaultTableModel modcombos;
    private DefaultTableModel modcombos2;
    private String tabla;
    private String sql;
    private String id;
    private String nbre;
    private String xidasignarcitas;
    private String idConsultorio;
    private Principal frmPrincipal;
    private int xVFiltro;
    private ButtonGroup JBG_Filtro;
    private JLabel JLBTitulo;
    private JPanel JPI_VAgendas;
    private JRadioButton JRB_CExterna;
    private JRadioButton JRB_Hospitalizacion;
    private JRadioButton JRB_SParto;
    private JRadioButton JRB_Todas;
    private JRadioButton JRB_Urgencias;
    private JButton btnOk;
    private JButton btnSalir;
    private JTableComboBox combo;
    private JTableComboBox combo2;
    private JPanel jPanel1;
    private JSeparator jSeparator1;

    public AccesoModulos(Frame parent, boolean modal, String titulo, String etiqueta, String Tabla, Principal frm) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xVFiltro = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.metodos.limpiarDatosPrincipal();
        setLocationRelativeTo(null);
        setTitle(Principal.getTitulo());
        this.JLBTitulo.setText(titulo);
        this.combo.setBorder(BorderFactory.createTitledBorder((Border) null, etiqueta, 0, 0, new Font("Arial", 1, 12)));
        this.tabla = Tabla;
        this.frmPrincipal = frm;
        cargarCombo();
        if (Tabla.equals("h_historia")) {
            this.JPI_VAgendas.setVisible(true);
            this.combo2.setVisible(true);
        } else {
            this.JPI_VAgendas.setVisible(false);
            if (this.combo.getPopupTable().getRowCount() == 1) {
                this.combo.setSelectedIndex(0);
                if (this.combo2.getPopupTable().getRowCount() == 1) {
                    this.combo2.setSelectedIndex(0);
                    entregarDato();
                    dispose();
                } else {
                    setVisible(true);
                    setEnabled(true);
                }
            } else {
                setVisible(true);
                setEnabled(true);
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.")) {
            this.JRB_Hospitalizacion.setText("Rehabilitación");
            this.JRB_Hospitalizacion.setToolTipText("Rehabilitación");
            this.JRB_SParto.setVisible(false);
            this.JRB_Urgencias.setVisible(false);
        }
        if (Principal.informacionIps.getNombreIps().equals("SALUD A SU HOGAR IPS S.A.S.")) {
            this.JRB_SParto.setVisible(false);
            this.JRB_Urgencias.setVisible(false);
            this.JRB_Todas.setVisible(false);
            this.JRB_CExterna.setVisible(false);
            this.JRB_Todas.setSelected(false);
            this.JRB_Hospitalizacion.setSelected(true);
        }
    }

    private String getId() {
        return this.id;
    }

    private String getNbre() {
        return this.nbre;
    }

    private void setId() {
        this.id = this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 0).toString();
    }

    private void setNbre() {
        this.nbre = this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 1).toString();
    }

    public String getXidasignarcitas() {
        return this.xidasignarcitas;
    }

    public void setXidasignarcitas() {
        this.xidasignarcitas = this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 2).toString();
    }

    private void ocultarComponentes() {
        this.combo2.setVisible(false);
        pack();
    }

    private void cargarCombo() {
        switch (this.tabla) {
            case "k_caja":
                this.sql = "SELECT k_caja.Id, k_caja.Nbre, `k_caja`.`CPuc_Debito`, `k_caja`.`CPuc_Credito` FROM g_usuariosxcajac INNER JOIN k_caja ON (g_usuariosxcajac.Id_Caja = k_caja.Id) WHERE (g_usuariosxcajac.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'   AND g_usuariosxcajac.Estado =1) ORDER BY k_caja.Nbre ASC";
                ocultarComponentes();
                break;
            case "g_especialidad":
            case "h_historia":
            case "h_enfermeria":
            case "laboratorio":
            case "Citologia":
            case "h_historia1":
                this.sql = "SELECT g_especialidad.Id, g_especialidad.Nbre, g_especialidad.AsignarCita, g_profesional.Tarjeta  FROM g_profesionalespecial INNER JOIN g_especialidad ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) inner join g_profesional on  (g_profesionalespecial.Id_Profesional=g_profesional.Id_Persona) WHERE (g_profesionalespecial.Estado=0 and g_profesionalespecial.Id_Profesional ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "') ORDER BY g_especialidad.Nbre ASC";
                break;
            case "i_bodegas":
            case "i_bodegas_F":
                this.sql = "SELECT   g_usuariosxbodega.Id_Bodega as Id, i_bodegas.Nbre as Bodega, i_bodegas.Principal as Principal, i_bodegas.UnidadEmpaque FROM g_usuariosxbodega INNER JOIN i_bodegas ON (g_usuariosxbodega.Id_Bodega = i_bodegas.Id) WHERE (`g_usuariosxbodega`.`Estado` = 1 AND g_usuariosxbodega.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "') ORDER BY i_bodegas.Nbre ASC";
                ocultarComponentes();
                break;
            case "cajam":
                this.sql = "SELECT cc_tipo_caja.Id, cc_tipo_caja.Nbre FROM g_usuariosxcaja INNER JOIN cc_tipo_caja  ON (g_usuariosxcaja.Id_TipoCaja = cc_tipo_caja.Id) WHERE (g_usuariosxcaja.Estado =1 AND g_usuariosxcaja.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "') ORDER BY cc_tipo_caja.Nbre ASC";
                ocultarComponentes();
                break;
            case "xjif_ficha":
                this.sql = "SELECT s_sgc_tipoproceso.`Id`, s_sgc_tipoproceso.`Nbre`   FROM persona  INNER JOIN rh_tipo_persona_cargon   ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)   INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona)  INNER JOIN `s_sgc_tipoproceso`  ON (s_sgc_tipoproceso.id = s_sgc_usuario_tipoproceso.`Id_TipoProceso`)  WHERE (s_sgc_tipoproceso.`Estado`=1 AND rh_tipo_persona_cargon.`Id`='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "') GROUP BY s_sgc_tipoproceso.`Id` ORDER BY s_sgc_tipoproceso.`Nbre` ASC  ";
                break;
        }
        this.consultas.llenarComboTabla(this.sql, this.combo, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    private void cargarConsultorio() {
        if (this.combo.getSelectedIndex() != -1) {
            this.sql = "select cc.Id id , cc.Nbre nombre, cc.Ubicacion  ubicacion\nfrom c_consultorio cc \ninner join c_claseconsultorio cc2 on (cc.Id_ClaseCons=cc2.Id)\nwhere cc2.Id_Especialidad =" + getId() + " and cc.Estado =0\norder by nombre asc";
        }
        this.consultas.llenarComboTabla(this.sql, this.combo2, this.modcombos2, 1);
        this.consultas.cerrarConexionBd();
    }

    private void entregarDato() {
        if (getId() != null && getNbre() != null) {
            switch (this.tabla) {
                case "k_caja":
                    this.frmPrincipal.activarMenu = 1;
                    this.frmPrincipal.setAsignarDatosCaja(Integer.parseInt(getId()), this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 1).toString(), this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 2).toString(), this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 3).toString());
                    this.frmPrincipal.cajaAbierta = 0;
                    break;
                case "g_especialidad":
                    this.frmPrincipal.activarMenu = 1;
                    this.frmPrincipal.setAsignarDatosTriage(getId(), getNbre());
                    break;
                case "i_bodegas":
                case "i_bodegas_F":
                    this.frmPrincipal.activarMenu = 1;
                    Principal principal = this.frmPrincipal;
                    Principal.informacionGeneralPrincipalDTO.setActivarModulo(1);
                    this.frmPrincipal.setAsignarDatosBodega(getId(), getNbre(), Integer.parseInt(this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 2).toString()), Integer.parseInt(this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 3).toString()));
                    break;
                case "h_historia":
                case "h_historia1":
                    this.frmPrincipal.activarMenu = 1;
                    Principal.informacionGeneralPrincipalDTO.setIdEspecialidad(Long.valueOf(getId()));
                    Principal.informacionGeneralPrincipalDTO.setNombreEspecialidad(getNbre());
                    Principal.informacionGeneralPrincipalDTO.setAsignacionCitaAgenda(true);
                    this.frmPrincipal.setAsignarDatosHistoriaCE(getId(), getNbre(), getXidasignarcitas(), this.xVFiltro, 0);
                    break;
                case "h_enfermeria":
                case "laboratorio":
                case "Citologia":
                    Principal.informacionGeneralPrincipalDTO.setIdEspecialidad(Long.valueOf(getId()));
                    Principal.informacionGeneralPrincipalDTO.setIdConsultorio(Long.valueOf(this.combo2.getPopupTable().getValueAt(this.combo2.getSelectedIndex(), 0).toString()));
                    Principal.informacionGeneralPrincipalDTO.setUbicacion(this.combo2.getPopupTable().getValueAt(this.combo2.getSelectedIndex(), 2).toString());
                    Principal.informacionGeneralPrincipalDTO.setNombreEspecialidad(getNbre());
                    Principal.informacionGeneralPrincipalDTO.setIdUsuarioExterno(this.combo.getPopupTable().getValueAt(this.combo.getSelectedIndex(), 3).toString());
                    this.frmPrincipal.activarMenu = 1;
                    break;
                case "cajam":
                    this.frmPrincipal.activarMenu = 1;
                    Principal.informacionGeneralPrincipalDTO.setIdCajaMenor(Long.valueOf(getId()));
                    Principal.informacionGeneralPrincipalDTO.setNombreCajaMenor(getNbre());
                    break;
                case "xjif_ficha":
                    Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(getId()));
                    Principal.informacionGeneralPrincipalDTO.setActivarModulo(1);
                    break;
            }
            dispose();
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione una opción");
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.btnSalir = new JButton();
        this.btnOk = new JButton();
        this.JLBTitulo = new JLabel();
        this.jPanel1 = new JPanel();
        try {
            this.combo = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.combo2 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.JPI_VAgendas = new JPanel();
        this.JRB_Todas = new JRadioButton();
        this.JRB_CExterna = new JRadioButton();
        this.JRB_Urgencias = new JRadioButton();
        this.JRB_SParto = new JRadioButton();
        this.JRB_Hospitalizacion = new JRadioButton();
        this.jSeparator1 = new JSeparator();
        setDefaultCloseOperation(2);
        setName("AccesoModulos");
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: General.AccesoModulos.1
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Ok");
        this.btnOk.addActionListener(new ActionListener() { // from class: General.AccesoModulos.2
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.btnOkActionPerformed(evt);
            }
        });
        this.JLBTitulo.setFont(new Font("Arial", 1, 18));
        this.JLBTitulo.setForeground(new Color(0, 102, 0));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("SELECCIÓN DE PERIODO CONTABLE");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder(0));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.combo.setBorder(BorderFactory.createTitledBorder((Border) null, "ETIQUETA", 0, 0, new Font("Arial", 1, 12)));
        this.combo.setFont(new Font("Arial", 1, 12));
        this.combo.setShowTableGrid(true);
        this.combo.setShowTableHeaders(false);
        this.combo.addItemListener(new ItemListener() { // from class: General.AccesoModulos.3
            public void itemStateChanged(ItemEvent evt) {
                AccesoModulos.this.comboItemStateChanged(evt);
            }
        });
        this.combo.addActionListener(new ActionListener() { // from class: General.AccesoModulos.4
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.comboActionPerformed(evt);
            }
        });
        this.combo2.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTORIO", 0, 0, new Font("Arial", 1, 12)));
        this.combo2.setFont(new Font("Arial", 1, 12));
        this.combo2.setShowTableGrid(true);
        this.combo2.setShowTableHeaders(false);
        this.combo2.addItemListener(new ItemListener() { // from class: General.AccesoModulos.5
            public void itemStateChanged(ItemEvent evt) {
                AccesoModulos.this.combo2ItemStateChanged(evt);
            }
        });
        this.combo2.addActionListener(new ActionListener() { // from class: General.AccesoModulos.6
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.combo2ActionPerformed(evt);
            }
        });
        this.JPI_VAgendas.setBorder(BorderFactory.createTitledBorder((Border) null, "VISUALIZAR AGENDAS", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setSelected(true);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: General.AccesoModulos.7
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.JRB_TodasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_CExterna);
        this.JRB_CExterna.setFont(new Font("Arial", 1, 12));
        this.JRB_CExterna.setText("Consulta Externa");
        this.JRB_CExterna.addActionListener(new ActionListener() { // from class: General.AccesoModulos.8
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.JRB_CExternaActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Urgencias);
        this.JRB_Urgencias.setFont(new Font("Arial", 1, 12));
        this.JRB_Urgencias.setText("Urgencias");
        this.JRB_Urgencias.addActionListener(new ActionListener() { // from class: General.AccesoModulos.9
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.JRB_UrgenciasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_SParto);
        this.JRB_SParto.setFont(new Font("Arial", 1, 12));
        this.JRB_SParto.setText("S.Parto");
        this.JRB_SParto.setToolTipText("Sala de Parto");
        this.JRB_SParto.addActionListener(new ActionListener() { // from class: General.AccesoModulos.10
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.JRB_SPartoActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Hospitalizacion);
        this.JRB_Hospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JRB_Hospitalizacion.setText("Hospitalización");
        this.JRB_Hospitalizacion.setToolTipText("Hospitalización");
        this.JRB_Hospitalizacion.addActionListener(new ActionListener() { // from class: General.AccesoModulos.11
            public void actionPerformed(ActionEvent evt) {
                AccesoModulos.this.JRB_HospitalizacionActionPerformed(evt);
            }
        });
        GroupLayout JPI_VAgendasLayout = new GroupLayout(this.JPI_VAgendas);
        this.JPI_VAgendas.setLayout(JPI_VAgendasLayout);
        JPI_VAgendasLayout.setHorizontalGroup(JPI_VAgendasLayout.createParallelGroup(1).add(JPI_VAgendasLayout.createSequentialGroup().addContainerGap().add(this.JRB_Todas).addPreferredGap(0).add(this.JRB_CExterna).addPreferredGap(1).add(this.JRB_Urgencias).addPreferredGap(0).add(this.JRB_SParto).addPreferredGap(1).add(this.JRB_Hospitalizacion).addContainerGap(31, 32767)));
        JPI_VAgendasLayout.setVerticalGroup(JPI_VAgendasLayout.createParallelGroup(1).add(JPI_VAgendasLayout.createSequentialGroup().addContainerGap().add(JPI_VAgendasLayout.createParallelGroup(3).add(this.JRB_Todas).add(this.JRB_CExterna).add(this.JRB_Urgencias).add(this.JRB_SParto).add(this.JRB_Hospitalizacion)).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createParallelGroup(1, false).add(this.combo, -1, 506, 32767).add(this.combo2, -1, -1, 32767)).add(this.JPI_VAgendas, -2, -1, -2)).addContainerGap(23, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.combo, -2, 50, -2).add(29, 29, 29).add(this.combo2, -2, 50, -2).addPreferredGap(0).add(this.JPI_VAgendas, -2, -1, -2).addContainerGap(12, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(6, 6, 6).add(this.btnOk, -2, 200, -2).addPreferredGap(0, -1, 32767).add(this.btnSalir, -2, 200, -2)).add(layout.createSequentialGroup().addContainerGap().add(this.jPanel1, -2, -1, -2).add(0, 0, 32767)).add(layout.createSequentialGroup().addContainerGap().add(this.JLBTitulo, -1, -1, 32767)).add(layout.createSequentialGroup().addContainerGap().add(this.jSeparator1))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(18, 18, 18).add(this.JLBTitulo, -2, 37, -2).addPreferredGap(0).add(this.jPanel1, -2, -1, -2).addPreferredGap(1).add(this.jSeparator1, -2, 10, -2).addPreferredGap(0, 10, 32767).add(layout.createParallelGroup(3).add(this.btnOk, -2, 50, -2).add(this.btnSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setActivarModulo(new Integer(0));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        entregarDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void comboItemStateChanged(ItemEvent evt) {
        setId();
        setNbre();
        if (this.tabla.equals("h_historia")) {
            setXidasignarcitas();
        }
        if (this.combo.getPopupTable().getRowCount() != -1) {
            cargarConsultorio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        this.xVFiltro = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CExternaActionPerformed(ActionEvent evt) {
        this.xVFiltro = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_UrgenciasActionPerformed(ActionEvent evt) {
        this.xVFiltro = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SPartoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xVFiltro = 5;
        } else {
            this.xVFiltro = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_HospitalizacionActionPerformed(ActionEvent evt) {
        this.xVFiltro = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combo2ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void comboActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combo2ActionPerformed(ActionEvent evt) {
        if (this.combo2.getSelectedIndex() != -1) {
            Principal.consultorio = this.combo2.getSelectedItem().toString();
            JTable popupTable = this.combo2.getPopupTable();
            if (popupTable != null) {
                Object value = popupTable.getValueAt(this.combo2.getSelectedIndex(), 2);
                Principal.ubicacion = value != null ? value.toString() : "";
            } else {
                Principal.ubicacion = "";
                System.err.println("¡El popupTable es null! Verifica si ya está cargado.");
            }
        }
    }
}
