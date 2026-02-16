package Caja;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Caja/CambiarDatos.class */
public class CambiarDatos extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    int cboLleno;
    private String[] listaCC;
    private String[] listaConceptos;
    private String[][] listaEPS;
    private ResultSet rs;
    private String sql;
    private claseCaja clasecaja;
    private JToggleButton btnGrabar;
    private JToggleButton btnNuevo;
    private JToggleButton btnSalir;
    private JComboBox cboCC;
    private JComboBox cboConcepto;
    private JComboBox cboEPS;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JFormattedTextField txtFecha;
    private JFormattedTextField txtNoRecibo;
    private JTextField txtPaciente;
    private JFormattedTextField txtValor;

    public CambiarDatos(Frame parent, boolean modal) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.cboLleno = 0;
        initComponents();
        setLocationRelativeTo(null);
        cargarCombos();
        nuevo();
    }

    private void cargarCombos() {
        this.listaCC = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE Estado = 0 ORDER BY Nbre ASC", this.listaCC, this.cboCC);
        this.listaEPS = this.consultas.llenarComboyLista("SELECT Id, Nbre, EsCapitado FROM f_empresacontxconvenio WHERE Estado = 0 ORDER BY Nbre ASC", this.listaEPS, this.cboEPS, 3);
        this.listaConceptos = this.consultas.llenarCombo("SELECT Id, Nbre FROM k_conceptos WHERE Estado = 0 ORDER BY Nbre ASC", this.listaConceptos, this.cboConcepto);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    public void buscarRecibo() {
        this.sql = "SELECT k_recibos.Id, k_recibos.Fecha_Recibo, f_centrocosto.Nbre AS CC, f_empresacontxconvenio.Nbre AS Empresa, k_recibos.Nbre_Paciente AS Paciente FROM k_recibos INNER JOIN f_centrocosto ON (k_recibos.Id_CentroCosto = f_centrocosto.Id) INNER JOIN f_empresacontxconvenio ON (k_recibos.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (k_recibos.Norecibo=" + this.txtNoRecibo.getText() + " AND k_recibos.Estado=0)";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.last()) {
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) this.rs.getDate("Fecha_Recibo")));
                this.cboCC.setSelectedItem(this.rs.getString("CC"));
                this.cboEPS.setSelectedItem(this.rs.getString("Empresa"));
                this.txtPaciente.setText(this.rs.getString("Paciente"));
                String id = this.rs.getString("Id");
                this.rs.close();
                this.consultas.cerrarConexionBd();
                this.sql = "SELECT SUM(Cantidad) * VrUnitario AS Valor FROM k_itemrecibos WHERE (Id_Recibo ='" + id + "')";
                this.txtValor.setValue(Integer.valueOf(Integer.parseInt(this.consultas.traerDato(this.sql))));
            } else {
                this.metodos.mostrarMensaje("No se encontró el Recibo solicitado");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void nuevo() {
        this.txtNoRecibo.setText("");
        this.txtFecha.setText("");
        this.txtPaciente.setText("");
        this.txtValor.setValue(0);
        this.cboCC.setSelectedIndex(-1);
        this.cboConcepto.setSelectedIndex(-1);
        this.cboEPS.setSelectedIndex(-1);
        this.txtNoRecibo.requestFocus();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.cboCC = new JComboBox();
        this.txtNoRecibo = new JFormattedTextField();
        this.cboEPS = new JComboBox();
        this.jLabel3 = new JLabel();
        this.cboConcepto = new JComboBox();
        this.jLabel2 = new JLabel();
        this.txtValor = new JFormattedTextField();
        this.txtFecha = new JFormattedTextField();
        this.txtPaciente = new JTextField();
        this.btnNuevo = new JToggleButton();
        this.btnGrabar = new JToggleButton();
        this.btnSalir = new JToggleButton();
        setDefaultCloseOperation(2);
        setName("CambiarDatos");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del recibo", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 102)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.cboCC.setFont(new Font("Arial", 1, 12));
        this.cboCC.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.jPanel1.add(this.cboCC);
        this.cboCC.setBounds(130, 30, 220, 50);
        this.txtNoRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.txtNoRecibo.setFont(new Font("Arial", 1, 12));
        this.txtNoRecibo.addFocusListener(new FocusAdapter() { // from class: Caja.CambiarDatos.1
            public void focusLost(FocusEvent evt) {
                CambiarDatos.this.txtNoReciboFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtNoRecibo);
        this.txtNoRecibo.setBounds(10, 40, 110, 40);
        this.cboEPS.setFont(new Font("Arial", 1, 12));
        this.cboEPS.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS o Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.jPanel1.add(this.cboEPS);
        this.cboEPS.setBounds(360, 30, 250, 50);
        this.jLabel3.setFont(new Font("Tahoma", 0, 13));
        this.jLabel3.setForeground(new Color(0, 0, 153));
        this.jLabel3.setText("Usuario");
        this.jPanel1.add(this.jLabel3);
        this.jLabel3.setBounds(130, 90, 100, 20);
        this.cboConcepto.setFont(new Font("Arial", 1, 12));
        this.cboConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.jPanel1.add(this.cboConcepto);
        this.cboConcepto.setBounds(10, 170, 890, 50);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 153));
        this.jLabel2.setText("Vr. Total");
        this.jPanel1.add(this.jLabel2);
        this.jLabel2.setBounds(650, 30, 160, 15);
        this.txtValor.setBackground(new Color(0, 0, 102));
        this.txtValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.txtValor.setHorizontalAlignment(4);
        this.txtValor.setDisabledTextColor(new Color(204, 255, 255));
        this.txtValor.setEnabled(false);
        this.txtValor.setFont(new Font("Arial", 1, 18));
        this.jPanel1.add(this.txtValor);
        this.txtValor.setBounds(650, 50, 250, 110);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addFocusListener(new FocusAdapter() { // from class: Caja.CambiarDatos.2
            public void focusLost(FocusEvent evt) {
                CambiarDatos.this.txtFechaFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtFecha);
        this.txtFecha.setBounds(10, 100, 110, 40);
        this.txtPaciente.setBackground(new Color(0, 0, 102));
        this.txtPaciente.setFont(new Font("Arial", 1, 14));
        this.txtPaciente.setDisabledTextColor(new Color(204, 255, 255));
        this.txtPaciente.setEnabled(false);
        this.jPanel1.add(this.txtPaciente);
        this.txtPaciente.setBounds(130, 110, 470, 30);
        this.btnNuevo.setFont(new Font("Arial", 1, 12));
        this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnNuevo.setText("Nuevo");
        this.btnNuevo.addActionListener(new ActionListener() { // from class: Caja.CambiarDatos.3
            public void actionPerformed(ActionEvent evt) {
                CambiarDatos.this.btnNuevoActionPerformed(evt);
            }
        });
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Caja.CambiarDatos.4
            public void actionPerformed(ActionEvent evt) {
                CambiarDatos.this.btnSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(577, 32767).addComponent(this.btnNuevo).addGap(18, 18, 18).addComponent(this.btnGrabar).addGap(18, 18, 18).addComponent(this.btnSalir).addContainerGap()).addComponent(this.jPanel1, -1, 920, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnSalir).addComponent(this.btnGrabar).addComponent(this.btnNuevo)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoReciboFocusLost(FocusEvent evt) {
        buscarRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // from class: Caja.CambiarDatos.5
            @Override // java.lang.Runnable
            public void run() {
                CambiarDatos dialog = new CambiarDatos(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() { // from class: Caja.CambiarDatos.5.1
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
