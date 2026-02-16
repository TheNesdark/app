package Triage;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Triage/Triage.class */
public class Triage extends JInternalFrame {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int xtipo = 0;
    private int clasificacion = 0;
    public String[] listaCausaExterna;
    private String sql;
    private String idAgenda;
    private Persona frmPersona;
    private claseTriage clasetriage;
    private JLabel JLBPBSentado;
    private JPanel JPIClasificacion;
    private JButton btnAmarillo;
    private JButton btnNaranja;
    private JButton btnRojo;
    private JButton btnVerde;
    public JComboBox cboCausaExterna;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JPanel panelPersona;
    private JTextArea txtAntecedentes;
    public JFormattedTextField txtEstado;
    private JFormattedTextField txtFc;
    public JFormattedTextField txtFecha;
    private JFormattedTextField txtFr;
    public JFormattedTextField txtHora;
    private JFormattedTextField txtImc;
    private JTextArea txtMedicacion;
    private JTextArea txtMotivoConsulta;
    public JFormattedTextField txtNoTriage;
    private JFormattedTextField txtPeso;
    private JFormattedTextField txtPresionDiastolica;
    private JFormattedTextField txtPresionSistolica;
    private JFormattedTextField txtPs2;
    private JFormattedTextField txtTalla;
    private JFormattedTextField txtTemperatura;
    private JTextArea txthallazgoClinico;

    public Triage() {
        initComponents();
    }

    public Triage(String historia, String IdAgenda, claseTriage Clasetriage) {
        initComponents();
        this.clasetriage = Clasetriage;
        this.idAgenda = IdAgenda;
        this.frmPersona = new Persona(this);
        cargarPanelPersona(historia);
        Principal.activarBotones();
        this.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
        this.txtHora.setText(this.metodos.formatoH12.format(this.metodos.getFechaActual()));
        this.txtEstado.setText("Activo");
        this.listaCausaExterna = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_causaexterna ORDER BY Nbre ASC", this.listaCausaExterna, this.cboCausaExterna);
        this.cboCausaExterna.setSelectedItem("Enfermedad General");
        this.consultas.cerrarConexionBd();
    }

    public void anular() {
        this.metodos.mostrarMensaje("Botón pendiente");
    }

    public void buscar(int op) {
        this.sql = "SELECT u_triage.*, g_causaexterna.Nbre FROM  u_triage INNER JOIN g_causaexterna ON (u_triage.Id_CausaExterna = g_causaexterna.Id) WHERE (u_triage.Id ";
        if (this.txtNoTriage.getText().isEmpty()) {
            this.txtNoTriage.setText("1000000");
        }
        switch (op) {
            case 1:
                this.sql += "< " + this.txtNoTriage.getText() + " AND Id_Usuario=" + this.frmPersona.getIdPersona() + ") ORDER BY Id ASC";
                break;
            case 2:
                this.sql += "< " + this.txtNoTriage.getText() + " AND Id_Usuario=" + this.frmPersona.getIdPersona() + ") ORDER BY Id DESC";
                break;
            case 3:
                this.sql += "> " + this.txtNoTriage.getText() + " AND Id_Usuario=" + this.frmPersona.getIdPersona() + ") ORDER BY Id ASC";
                break;
            case 4:
                this.sql += "> " + this.txtNoTriage.getText() + " AND Id_Usuario=" + this.frmPersona.getIdPersona() + ") ORDER BY Id DESC";
                break;
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            limpiarBotonesTriage();
            this.txtNoTriage.setText(rs.getString("Id"));
            this.txtPresionDiastolica.setValue(Integer.valueOf(rs.getInt("TensionArtD")));
            this.txtPresionSistolica.setValue(Integer.valueOf(rs.getInt("TensionArtS")));
            this.txtFc.setValue(Long.valueOf(rs.getLong("FCardiaca")));
            this.txtFr.setValue(Long.valueOf(rs.getLong("FRespiratoria")));
            this.txtTalla.setValue(Long.valueOf(rs.getLong("Talla")));
            this.txtPeso.setValue(Long.valueOf(rs.getLong("Peso")));
            this.txtTemperatura.setValue(Long.valueOf(rs.getLong("Temperatura")));
            this.txtPs2.setValue(Long.valueOf(rs.getLong("Ps2")));
            switch (rs.getInt("Clasificacion")) {
                case 1:
                    this.btnRojo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                    break;
                case 2:
                    this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                    break;
                case 3:
                    this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                    break;
                case 4:
                    this.btnVerde.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                    break;
            }
            this.txtFecha.setValue(rs.getString("FechaTriage"));
            this.txtHora.setValue(this.metodos.formatoH12.format((Date) rs.getDate("Hora")));
            this.txtMotivoConsulta.setText(rs.getString("MotivoConsulta"));
            this.txthallazgoClinico.setText(rs.getString("HallazgoClinico"));
            this.txtAntecedentes.setText(rs.getString("Antecente"));
            this.txtMedicacion.setText(rs.getString("Medicacion"));
            this.cboCausaExterna.setSelectedItem("Nbre");
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void calcularImc() {
        Double peso = Double.valueOf(Double.parseDouble(this.txtPeso.getValue().toString()));
        Double talla = Double.valueOf(Double.parseDouble(this.txtTalla.getValue().toString()));
        Double imc = Double.valueOf((peso.doubleValue() / (talla.doubleValue() * talla.doubleValue())) * 10000.0d);
        this.txtImc.setText(String.valueOf(this.metodos.redondear(imc.doubleValue(), 0)));
    }

    private void cambiarEstadoAgenda() {
        this.sql = "UPDATE u_triageagenda SET Estado = 1 WHERE Id ='" + this.idAgenda + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarPanelPersona(String historia) {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1190, 500);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
        this.frmPersona.txtHistoria.requestFocus();
        this.frmPersona.txtHistoria.setText(historia);
        this.frmPersona.buscar(2);
    }

    private void clasificarBotonTriage() {
        this.btnRojo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnVerde.setIcon(new ImageIcon(getClass().getResource("")));
        switch (this.clasificacion) {
            case 1:
                this.btnRojo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 2:
                this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 3:
                this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 4:
                this.btnVerde.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
        }
    }

    public void grabar() {
        int validar = validarCampos();
        if (validar == 1) {
            grabarTriage();
            cambiarEstadoAgenda();
            imprimir();
            this.metodos.mostrarMensaje("TRIAGE Grabado, Ok");
        }
    }

    private void grabarTriage() {
        this.sql = "INSERT INTO u_triage (Id_Usuario, TensionArtD, TensionArtS, FCardiaca, FRespiratoria, Talla, Peso, Temperatura, Ps2, Clasificacion, FechaTriage, Hora, MotivoConsulta, HallazgoClinico, Antecedente, Medicacion, Id_CausaExterna, Id_Profesional, Id_Especialidad, Id_Agenda, Atendido, Fecha, UsuarioS) VALUES('" + this.frmPersona.getIdPersona() + "','" + this.txtPresionDiastolica.getValue().toString() + "','" + this.txtPresionSistolica.getValue().toString() + "','" + this.txtFc.getValue().toString() + "','" + this.txtFr.getValue().toString() + "','" + this.txtTalla.getValue().toString() + "','" + this.txtPeso.getValue().toString() + "','" + this.txtTemperatura.getValue().toString() + "','" + this.txtPs2.getValue().toString() + "','" + this.clasificacion + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.txtMotivoConsulta.getText() + "','" + this.txthallazgoClinico.getText() + "','" + this.txtAntecedentes.getText() + "','" + this.txtMedicacion.getText() + "','" + this.listaCausaExterna[this.cboCausaExterna.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.clasetriage.getIdEspecial() + "','" + this.idAgenda + "','1','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.txtNoTriage.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        Principal.desactivarBotonesGuardar();
    }

    public void imprimir() {
        Principal.clasetriage.imprimirtriage(this.txtNoTriage.getText());
    }

    private void limpiarBotonesTriage() {
        this.btnRojo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnVerde.setIcon(new ImageIcon(getClass().getResource("")));
    }

    private int validarCampos() {
        int valor = 0;
        if (this.frmPersona.txtHistoria.getText().isEmpty() || this.frmPersona.txtHistoria.getText() == null) {
            this.metodos.mostrarMensaje("Por Favor seleccione al Usuario que atenderá\nRemítase a la Agenda Programada y seleccione al Usuario");
        } else if (this.txtMotivoConsulta.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite el Motivo de la Consulta.");
            this.txtMotivoConsulta.requestFocus();
        } else if (this.txthallazgoClinico.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite el Hallazgo Clínico encontrado.");
            this.txthallazgoClinico.requestFocus();
        } else if (this.clasificacion == 0) {
            this.metodos.mostrarMensaje("Por Favor Clasifique el TRIAGE presionando unos de los Botones de colores.");
        } else {
            valor = 1;
        }
        return valor;
    }

    private void validarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.metodos.mostrarMensaje("La Presión Sistólica es Baja\nPor favor verifique el valor introducido o este alerta sobre el valor tomado");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.metodos.mostrarMensaje("La Presión Sistólica es Alta\nPor favor verifique el valor introducido o este alerta sobre el valor tomado");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.metodos.mostrarMensaje("La Presión Diastólica es Baja\nPor favor verifique el valor introducido o este alerta sobre el valor tomado");
        } else if (valor > 0 && valor > 90) {
            this.metodos.mostrarMensaje("La Presión Diastólica es Alta\nPor favor verifique el valor introducido o este alerta sobre el valor tomado");
        }
    }

    private void initComponents() {
        this.panelPersona = new JPanel();
        this.txtNoTriage = new JFormattedTextField();
        this.txtEstado = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.jPanel4 = new JPanel();
        this.txtPresionSistolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.txtPresionDiastolica = new JFormattedTextField();
        this.cboCausaExterna = new JComboBox();
        this.jPanel3 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.txtFc = new JFormattedTextField();
        this.txtFr = new JFormattedTextField();
        this.txtTemperatura = new JFormattedTextField();
        this.txtPs2 = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txtMotivoConsulta = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.txthallazgoClinico = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.txtMedicacion = new JTextArea();
        this.jPanel1 = new JPanel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.txtImc = new JFormattedTextField();
        this.jLabel7 = new JLabel();
        this.txtTalla = new JFormattedTextField();
        this.txtPeso = new JFormattedTextField();
        this.jScrollPane4 = new JScrollPane();
        this.txtAntecedentes = new JTextArea();
        this.txtFecha = new JFormattedTextField();
        this.txtHora = new JFormattedTextField();
        this.JPIClasificacion = new JPanel();
        this.btnVerde = new JButton();
        this.btnAmarillo = new JButton();
        this.btnNaranja = new JButton();
        this.btnRojo = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TRIAGE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Triage");
        getContentPane().setLayout(new AbsoluteLayout());
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 990, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 150, 32767));
        getContentPane().add(this.panelPersona, new AbsoluteConstraints(0, 60, 990, 150));
        this.txtNoTriage.setEditable(false);
        this.txtNoTriage.setBackground(new Color(0, 0, 102));
        this.txtNoTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "Triage N°", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtNoTriage.setForeground(new Color(255, 255, 255));
        this.txtNoTriage.setHorizontalAlignment(0);
        this.txtNoTriage.setDisabledTextColor(new Color(255, 255, 255));
        this.txtNoTriage.setEnabled(false);
        this.txtNoTriage.setFont(new Font("Arial", 1, 18));
        this.txtNoTriage.addActionListener(new ActionListener() { // from class: Triage.Triage.1
            public void actionPerformed(ActionEvent evt) {
                Triage.this.txtNoTriageActionPerformed(evt);
            }
        });
        getContentPane().add(this.txtNoTriage, new AbsoluteConstraints(668, 0, 350, 50));
        this.txtEstado.setBackground(new Color(0, 0, 102));
        this.txtEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtEstado.setForeground(new Color(255, 255, 255));
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setDisabledTextColor(new Color(255, 255, 255));
        this.txtEstado.setEnabled(false);
        this.txtEstado.setFont(new Font("Arial", 1, 18));
        getContentPane().add(this.txtEstado, new AbsoluteConstraints(402, 0, 260, 50));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del TRIAGE", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.txtPresionSistolica.setHorizontalAlignment(4);
        this.txtPresionSistolica.setText("0");
        this.txtPresionSistolica.setFocusLostBehavior(2);
        this.txtPresionSistolica.setFont(new Font("Arial", 1, 12));
        this.txtPresionSistolica.setName("fechanaciemiento");
        this.txtPresionSistolica.setValue(0);
        this.txtPresionSistolica.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.2
            public void focusGained(FocusEvent evt) {
                Triage.this.txtPresionSistolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Triage.this.txtPresionSistolicaFocusLost(evt);
            }
        });
        this.txtPresionSistolica.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.3
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtPresionSistolicaKeyPressed(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.txtPresionDiastolica.setHorizontalAlignment(4);
        this.txtPresionDiastolica.setText("0");
        this.txtPresionDiastolica.setFocusLostBehavior(2);
        this.txtPresionDiastolica.setFont(new Font("Arial", 1, 12));
        this.txtPresionDiastolica.setName("fechanaciemiento");
        this.txtPresionDiastolica.setValue(0);
        this.txtPresionDiastolica.addActionListener(new ActionListener() { // from class: Triage.Triage.4
            public void actionPerformed(ActionEvent evt) {
                Triage.this.txtPresionDiastolicaActionPerformed(evt);
            }
        });
        this.txtPresionDiastolica.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.5
            public void focusGained(FocusEvent evt) {
                Triage.this.txtPresionDiastolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Triage.this.txtPresionDiastolicaFocusLost(evt);
            }
        });
        this.txtPresionDiastolica.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.6
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtPresionDiastolicaKeyPressed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.txtPresionSistolica, -2, 54, -2).addGap(12, 12, 12).addComponent(this.JLBPBSentado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtPresionDiastolica, -2, 60, -2).addContainerGap(17, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtPresionSistolica, -2, 25, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtPresionDiastolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2)))));
        this.jPanel2.add(this.jPanel4);
        this.jPanel4.setBounds(10, 20, 180, 60);
        this.cboCausaExterna.setFont(new Font("Arial", 1, 12));
        this.cboCausaExterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa Externa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.jPanel2.add(this.cboCausaExterna);
        this.cboCausaExterna.setBounds(720, 30, 250, 50);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Signos Vitales", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 204));
        this.jLabel1.setText("Fc (p/m)");
        this.jPanel3.add(this.jLabel1);
        this.jLabel1.setBounds(10, 20, 60, 15);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 204));
        this.jLabel2.setText("Fr (r/m)");
        this.jPanel3.add(this.jLabel2);
        this.jLabel2.setBounds(80, 20, 60, 15);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 204));
        this.jLabel3.setText("T (ªC)");
        this.jPanel3.add(this.jLabel3);
        this.jLabel3.setBounds(150, 20, 60, 15);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 204));
        this.jLabel4.setText("Ps2");
        this.jPanel3.add(this.jLabel4);
        this.jLabel4.setBounds(220, 20, 60, 15);
        this.txtFc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtFc.setHorizontalAlignment(4);
        this.txtFc.setValue(0);
        this.txtFc.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.7
            public void focusGained(FocusEvent evt) {
                Triage.this.txtFcFocusGained(evt);
            }
        });
        this.txtFc.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.8
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtFcKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.txtFc);
        this.txtFc.setBounds(10, 40, 60, 20);
        this.txtFr.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtFr.setHorizontalAlignment(4);
        this.txtFr.setValue(0);
        this.txtFr.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.9
            public void focusGained(FocusEvent evt) {
                Triage.this.txtFrFocusGained(evt);
            }
        });
        this.txtFr.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.10
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtFrKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.txtFr);
        this.txtFr.setBounds(80, 40, 60, 20);
        this.txtTemperatura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtTemperatura.setHorizontalAlignment(4);
        this.txtTemperatura.setValue(0);
        this.txtTemperatura.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.11
            public void focusGained(FocusEvent evt) {
                Triage.this.txtTemperaturaFocusGained(evt);
            }
        });
        this.txtTemperatura.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.12
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtTemperaturaKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.txtTemperatura);
        this.txtTemperatura.setBounds(150, 40, 60, 20);
        this.txtPs2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtPs2.setHorizontalAlignment(4);
        this.txtPs2.setValue(0);
        this.txtPs2.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.13
            public void focusGained(FocusEvent evt) {
                Triage.this.txtPs2FocusGained(evt);
            }
        });
        this.txtPs2.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.14
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtPs2KeyPressed(evt);
            }
        });
        this.jPanel3.add(this.txtPs2);
        this.txtPs2.setBounds(220, 40, 60, 20);
        this.jPanel2.add(this.jPanel3);
        this.jPanel3.setBounds(200, 20, 290, 70);
        this.txtMotivoConsulta.setColumns(20);
        this.txtMotivoConsulta.setRows(5);
        this.txtMotivoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Consulta", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jScrollPane1.setViewportView(this.txtMotivoConsulta);
        this.jPanel2.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 97, 510, 130);
        this.txthallazgoClinico.setColumns(20);
        this.txthallazgoClinico.setRows(5);
        this.txthallazgoClinico.setBorder(BorderFactory.createTitledBorder((Border) null, "Hallazgo Clínico", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jScrollPane2.setViewportView(this.txthallazgoClinico);
        this.jPanel2.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(530, 100, 440, 130);
        this.txtMedicacion.setColumns(20);
        this.txtMedicacion.setRows(5);
        this.txtMedicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicación", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jScrollPane3.setViewportView(this.txtMedicacion);
        this.jPanel2.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 240, 510, 110);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Indice de Masa Corporal", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 204));
        this.jLabel5.setText("Talla (cm)");
        this.jPanel1.add(this.jLabel5);
        this.jLabel5.setBounds(10, 20, 60, 15);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 204));
        this.jLabel6.setText("Peso (Kg)");
        this.jPanel1.add(this.jLabel6);
        this.jLabel6.setBounds(80, 20, 60, 15);
        this.txtImc.setBackground(new Color(0, 0, 102));
        this.txtImc.setHorizontalAlignment(0);
        this.txtImc.setDisabledTextColor(new Color(204, 255, 255));
        this.txtImc.setEnabled(false);
        this.txtImc.setFont(new Font("Tahoma", 1, 12));
        this.jPanel1.add(this.txtImc);
        this.txtImc.setBounds(150, 40, 60, 21);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 204));
        this.jLabel7.setText("Resultado");
        this.jPanel1.add(this.jLabel7);
        this.jLabel7.setBounds(150, 20, 60, 15);
        this.txtTalla.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtTalla.setHorizontalAlignment(4);
        this.txtTalla.setValue(0);
        this.txtTalla.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.15
            public void focusGained(FocusEvent evt) {
                Triage.this.txtTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Triage.this.txtTallaFocusLost(evt);
            }
        });
        this.txtTalla.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.16
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtTallaKeyPressed(evt);
            }
        });
        this.jPanel1.add(this.txtTalla);
        this.txtTalla.setBounds(10, 40, 60, 20);
        this.txtPeso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtPeso.setHorizontalAlignment(4);
        this.txtPeso.setValue(0);
        this.txtPeso.addFocusListener(new FocusAdapter() { // from class: Triage.Triage.17
            public void focusGained(FocusEvent evt) {
                Triage.this.txtPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Triage.this.txtPesoFocusLost(evt);
            }
        });
        this.txtPeso.addKeyListener(new KeyAdapter() { // from class: Triage.Triage.18
            public void keyPressed(KeyEvent evt) {
                Triage.this.txtPesoKeyPressed(evt);
            }
        });
        this.jPanel1.add(this.txtPeso);
        this.txtPeso.setBounds(80, 40, 60, 20);
        this.jPanel2.add(this.jPanel1);
        this.jPanel1.setBounds(490, 20, 220, 70);
        this.txtAntecedentes.setColumns(20);
        this.txtAntecedentes.setRows(5);
        this.txtAntecedentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Antecedentes Relevantes", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jScrollPane4.setViewportView(this.txtAntecedentes);
        this.jPanel2.add(this.jScrollPane4);
        this.jScrollPane4.setBounds(530, 240, 440, 110);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 220, 990, 360));
        this.txtFecha.setEditable(false);
        this.txtFecha.setBackground(new Color(0, 0, 102));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 18));
        getContentPane().add(this.txtFecha, new AbsoluteConstraints(10, 0, 190, 50));
        this.txtHora.setEditable(false);
        this.txtHora.setBackground(new Color(0, 0, 102));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 1, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtHora.setHorizontalAlignment(0);
        this.txtHora.setDisabledTextColor(new Color(255, 255, 255));
        this.txtHora.setEnabled(false);
        this.txtHora.setFont(new Font("Arial", 1, 18));
        getContentPane().add(this.txtHora, new AbsoluteConstraints(206, 0, 190, 50));
        this.JPIClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 51)));
        this.btnVerde.setBackground(Color.lightGray);
        this.btnVerde.setFont(new Font("Arial", 1, 14));
        this.btnVerde.setForeground(new Color(0, 0, 204));
        this.btnVerde.setText("4");
        this.btnVerde.addActionListener(new ActionListener() { // from class: Triage.Triage.19
            public void actionPerformed(ActionEvent evt) {
                Triage.this.btnVerdeActionPerformed(evt);
            }
        });
        this.btnAmarillo.setBackground(new Color(9, 168, 9));
        this.btnAmarillo.setFont(new Font("Arial", 1, 14));
        this.btnAmarillo.setForeground(new Color(0, 0, 204));
        this.btnAmarillo.setText("3");
        this.btnAmarillo.addActionListener(new ActionListener() { // from class: Triage.Triage.20
            public void actionPerformed(ActionEvent evt) {
                Triage.this.btnAmarilloActionPerformed(evt);
            }
        });
        this.btnNaranja.setBackground(Color.yellow);
        this.btnNaranja.setFont(new Font("Arial", 1, 14));
        this.btnNaranja.setForeground(new Color(0, 0, 204));
        this.btnNaranja.setText("2");
        this.btnNaranja.addActionListener(new ActionListener() { // from class: Triage.Triage.21
            public void actionPerformed(ActionEvent evt) {
                Triage.this.btnNaranjaActionPerformed(evt);
            }
        });
        this.btnRojo.setBackground(Color.red);
        this.btnRojo.setFont(new Font("Arial", 1, 14));
        this.btnRojo.setForeground(new Color(0, 0, 204));
        this.btnRojo.setText("1");
        this.btnRojo.addActionListener(new ActionListener() { // from class: Triage.Triage.22
            public void actionPerformed(ActionEvent evt) {
                Triage.this.btnRojoActionPerformed(evt);
            }
        });
        GroupLayout JPIClasificacionLayout = new GroupLayout(this.JPIClasificacion);
        this.JPIClasificacion.setLayout(JPIClasificacionLayout);
        JPIClasificacionLayout.setHorizontalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnAmarillo, -2, 120, -2).addComponent(this.btnNaranja, -2, 120, -2).addComponent(this.btnRojo, -2, 120, -2).addComponent(this.btnVerde, -2, 120, -2)).addContainerGap(18, 32767)));
        JPIClasificacionLayout.setVerticalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addComponent(this.btnRojo, -1, 114, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNaranja, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAmarillo, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnVerde, -1, 123, 32767).addContainerGap()));
        getContentPane().add(this.JPIClasificacion, new AbsoluteConstraints(1010, 60, 160, 510));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoTriageActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSistolicaFocusLost(FocusEvent evt) {
        if (Integer.parseInt(this.txtPresionSistolica.getText()) > 0) {
            validarPresion(Integer.valueOf(this.txtPresionSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSistolicaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtPresionDiastolica.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionDiastolicaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionDiastolicaFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.23
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtPresionDiastolica.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionDiastolicaFocusLost(FocusEvent evt) {
        if (Integer.parseInt(this.txtPresionDiastolica.getText()) > 0) {
            validarPresion(Integer.valueOf(this.txtPresionDiastolica.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionDiastolicaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtFc.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVerdeActionPerformed(ActionEvent evt) {
        this.clasificacion = 4;
        clasificarBotonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAmarilloActionPerformed(ActionEvent evt) {
        this.clasificacion = 3;
        clasificarBotonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNaranjaActionPerformed(ActionEvent evt) {
        this.clasificacion = 2;
        clasificarBotonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRojoActionPerformed(ActionEvent evt) {
        this.clasificacion = 1;
        clasificarBotonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSistolicaFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.24
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtPresionSistolica.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboCausaExterna.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtPeso.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPs2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtTalla.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTemperaturaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtPs2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFcKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtFr.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFrKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtTemperatura.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFcFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.25
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtFc.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFrFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.26
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtFr.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTemperaturaFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.27
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtTemperatura.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPs2FocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.28
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtPs2.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.29
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtTalla.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Triage.Triage.30
            @Override // java.lang.Runnable
            public void run() {
                Triage.this.txtPeso.selectAll();
            }
        });
    }
}
