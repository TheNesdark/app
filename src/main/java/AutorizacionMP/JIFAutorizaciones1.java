package AutorizacionMP;

import Acceso.Principal;
import General.BuscarPersona;
import General.JDBiometrico;
import General.Persona;
import Historia.JPOOrdenSuministroH;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFAutorizaciones1.class */
public class JIFAutorizaciones1 extends JInternalFrame {
    public Persona frmPersona;
    public JPOOrdenSuministroH frmOrdenesSuministr;
    public JIFConsultarOrdenes frmConsultar;
    public String[] xidmunicipio;
    public String[] xidempresa;
    public String[][] xidprofesional;
    private ButtonGroup JBGQuincenas;
    private JButton JBTAreaLab1;
    private JButton JBTPNoAutorizado;
    public JComboBox JCBEmpresaConvenio;
    public JComboBox JCBMunicipioR;
    public JComboBox JCBProfesional;
    private JCheckBox JCBSi;
    private JLabel JLBEtiqueta;
    private JPanel JPIDatoDescuento;
    private JPanel JPIDatosAdicionales;
    private JPanel JPIDatosEntrega;
    private JPanel JPIDatosF;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIFormula;
    private JPanel JPINQuincena;
    private JRadioButton JRBDos;
    private JRadioButton JRBTres;
    private JRadioButton JRBUna;
    private JScrollPane JSPFormula;
    private JScrollPane JSPNotasAdicionales;
    public JFormattedTextField JTFFValorDescuento;
    public JFormattedTextField JTFFValorDescuentoxQuinc;
    public JFormattedTextField JTFFValorTratamiento;
    private JTextField JTFPersonaRecibe;
    private JTabbedPane JTPDatos;
    private JTextPane JTPNotasAdicionales;
    private JButton jButton2;
    public int xnquincenas = 3;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int xguardado = 0;
    private long xidpersonad = 0;

    public JIFAutorizaciones1() {
        initComponents();
        mLimpiarComponentes();
        mCargarPanelPersona();
        mCargarPanelFormula();
    }

    private void initComponents() {
        this.JBGQuincenas = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JLBEtiqueta = new JLabel();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosF = new JPanel();
        this.JSPFormula = new JScrollPane();
        this.JPIFormula = new JPanel();
        this.JBTPNoAutorizado = new JButton();
        this.JBTAreaLab1 = new JButton();
        this.JPIDatoDescuento = new JPanel();
        this.JPINQuincena = new JPanel();
        this.JRBUna = new JRadioButton();
        this.JRBDos = new JRadioButton();
        this.JRBTres = new JRadioButton();
        this.JTFFValorTratamiento = new JFormattedTextField();
        this.JSPNotasAdicionales = new JScrollPane();
        this.JTPNotasAdicionales = new JTextPane();
        this.JTFFValorDescuento = new JFormattedTextField();
        this.JTFFValorDescuentoxQuinc = new JFormattedTextField();
        this.jButton2 = new JButton();
        this.JPIDatosAdicionales = new JPanel();
        this.JPIDatosEntrega = new JPanel();
        this.JCBMunicipioR = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBSi = new JCheckBox();
        this.JTFPersonaRecibe = new JTextField();
        this.JCBEmpresaConvenio = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUTORIZACIÓN DE MEDICAMENTOS MEDICINA PREPAGADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifautorizacion");
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 962, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 178, 32767));
        this.JLBEtiqueta.setFont(new Font("Arial", 1, 18));
        this.JLBEtiqueta.setForeground(Color.red);
        this.JLBEtiqueta.setHorizontalAlignment(4);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPFormula.setHorizontalScrollBarPolicy(31);
        this.JSPFormula.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFormulaLayout = new GroupLayout(this.JPIFormula);
        this.JPIFormula.setLayout(JPIFormulaLayout);
        JPIFormulaLayout.setHorizontalGroup(JPIFormulaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1178, 32767));
        JPIFormulaLayout.setVerticalGroup(JPIFormulaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 574, 32767));
        this.JSPFormula.setViewportView(this.JPIFormula);
        this.JBTPNoAutorizado.setFont(new Font("Arial", 1, 12));
        this.JBTPNoAutorizado.setForeground(Color.blue);
        this.JBTPNoAutorizado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/no autorizado.jpg")));
        this.JBTPNoAutorizado.setText("<html><P ALIGN=center>\nREGISTRAR PRODUCTOS \n               NO AUTORIZADOS");
        this.JBTPNoAutorizado.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.1
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JBTPNoAutorizadoActionPerformed(evt);
            }
        });
        this.JBTAreaLab1.setFont(new Font("Arial", 1, 12));
        this.JBTAreaLab1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Invima.png")));
        this.JBTAreaLab1.setText("<html><P ALIGN=center>Abrir Página Web");
        this.JBTAreaLab1.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.2
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JBTAreaLab1ActionPerformed(evt);
            }
        });
        this.JPIDatoDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL DESCUENTO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JPINQuincena.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Quincenas", 1, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGQuincenas.add(this.JRBUna);
        this.JRBUna.setFont(new Font("Arial", 1, 12));
        this.JRBUna.setForeground(new Color(0, 0, 255));
        this.JRBUna.setText("Una");
        this.JRBUna.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.3
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JRBUnaActionPerformed(evt);
            }
        });
        this.JBGQuincenas.add(this.JRBDos);
        this.JRBDos.setFont(new Font("Arial", 1, 12));
        this.JRBDos.setForeground(new Color(0, 0, 255));
        this.JRBDos.setText("Dos");
        this.JRBDos.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.4
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JRBDosActionPerformed(evt);
            }
        });
        this.JBGQuincenas.add(this.JRBTres);
        this.JRBTres.setFont(new Font("Arial", 1, 12));
        this.JRBTres.setForeground(new Color(0, 0, 255));
        this.JRBTres.setSelected(true);
        this.JRBTres.setText("Tres");
        this.JRBTres.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.5
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JRBTresActionPerformed(evt);
            }
        });
        this.JTFFValorTratamiento.setEditable(false);
        this.JTFFValorTratamiento.setBackground(new Color(0, 0, 153));
        this.JTFFValorTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Tto", 2, 0, new Font("Arial", 1, 11), new Color(204, 255, 255)));
        this.JTFFValorTratamiento.setForeground(new Color(255, 255, 255));
        this.JTFFValorTratamiento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTratamiento.setHorizontalAlignment(0);
        this.JTFFValorTratamiento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorTratamiento.setEnabled(false);
        this.JTFFValorTratamiento.setFont(new Font("Arial", 1, 18));
        this.JTFFValorTratamiento.setValue(new Integer(0));
        this.JSPNotasAdicionales.setBorder(BorderFactory.createTitledBorder((Border) null, "Notas Adicionales", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JSPNotasAdicionales.setFont(new Font("Arial", 1, 12));
        this.JTPNotasAdicionales.setFont(new Font("Arial", 1, 12));
        this.JSPNotasAdicionales.setViewportView(this.JTPNotasAdicionales);
        this.JTFFValorDescuento.setEditable(false);
        this.JTFFValorDescuento.setBackground(new Color(0, 0, 153));
        this.JTFFValorDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Descuento", 2, 0, new Font("Arial", 1, 11), new Color(204, 255, 255)));
        this.JTFFValorDescuento.setForeground(Color.red);
        this.JTFFValorDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDescuento.setHorizontalAlignment(0);
        this.JTFFValorDescuento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorDescuento.setEnabled(false);
        this.JTFFValorDescuento.setFont(new Font("Arial", 1, 18));
        this.JTFFValorDescuento.setValue(new Integer(0));
        this.JTFFValorDescuentoxQuinc.setEditable(false);
        this.JTFFValorDescuentoxQuinc.setBackground(new Color(0, 0, 153));
        this.JTFFValorDescuentoxQuinc.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Descuento x Quincena", 2, 0, new Font("Arial", 1, 11), new Color(204, 255, 255)));
        this.JTFFValorDescuentoxQuinc.setForeground(Color.red);
        this.JTFFValorDescuentoxQuinc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDescuentoxQuinc.setHorizontalAlignment(0);
        this.JTFFValorDescuentoxQuinc.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorDescuentoxQuinc.setEnabled(false);
        this.JTFFValorDescuentoxQuinc.setFont(new Font("Arial", 1, 18));
        this.JTFFValorDescuentoxQuinc.setValue(new Integer(0));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.jButton2.setText("Firmado por Biometría");
        this.jButton2.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.6
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPINQuincenaLayout = new GroupLayout(this.JPINQuincena);
        this.JPINQuincena.setLayout(JPINQuincenaLayout);
        JPINQuincenaLayout.setHorizontalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JTFFValorDescuentoxQuinc, -2, 150, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPINQuincenaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPNotasAdicionales).addContainerGap()).addGroup(JPINQuincenaLayout.createSequentialGroup().addContainerGap().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addComponent(this.JRBUna).addGap(18, 18, 18).addComponent(this.JRBDos).addGap(18, 18, 18).addComponent(this.JRBTres)).addGroup(JPINQuincenaLayout.createSequentialGroup().addComponent(this.JTFFValorTratamiento, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorDescuento, -2, 110, -2)).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
        JPINQuincenaLayout.setVerticalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINQuincenaLayout.createSequentialGroup().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUna).addComponent(this.JRBDos).addComponent(this.JRBTres)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorTratamiento, -2, 50, -2).addComponent(this.JTFFValorDescuento, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorDescuentoxQuinc, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNotasAdicionales, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2, -1, -1, 32767).addGap(18, 18, 18)));
        GroupLayout JPIDatoDescuentoLayout = new GroupLayout(this.JPIDatoDescuento);
        this.JPIDatoDescuento.setLayout(JPIDatoDescuentoLayout);
        JPIDatoDescuentoLayout.setHorizontalGroup(JPIDatoDescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoDescuentoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPINQuincena, -2, 248, 32767).addContainerGap()));
        JPIDatoDescuentoLayout.setVerticalGroup(JPIDatoDescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPINQuincena, -1, -1, 32767));
        GroupLayout JPIDatosFLayout = new GroupLayout(this.JPIDatosF);
        this.JPIDatosF.setLayout(JPIDatosFLayout);
        JPIDatosFLayout.setHorizontalGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosFLayout.createSequentialGroup().addContainerGap(881, 32767).addGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAreaLab1, -2, 268, -2).addComponent(this.JBTPNoAutorizado, -2, 268, -2).addComponent(this.JPIDatoDescuento, -2, -1, -2)).addContainerGap()).addGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosFLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPFormula, -2, 861, -2).addContainerGap(300, 32767))));
        JPIDatosFLayout.setVerticalGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTPNoAutorizado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAreaLab1, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JPIDatoDescuento, -2, -1, -2).addContainerGap(109, 32767)).addGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosFLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPFormula, -2, 510, -2).addGap(77, 77, 77))));
        this.JTPDatos.addTab("FORMULA", this.JPIDatosF);
        this.JPIDatosEntrega.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ADICIONALES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBMunicipioR.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipioR.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional o Clinica", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSi.setFont(new Font("Arial", 1, 12));
        this.JCBSi.setForeground(Color.blue);
        this.JCBSi.setText("Si");
        this.JCBSi.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones1.7
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones1.this.JCBSiActionPerformed(evt);
            }
        });
        this.JTFPersonaRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFPersonaRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que Recibe", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresaConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Autorizada para Cobro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosEntregaLayout = new GroupLayout(this.JPIDatosEntrega);
        this.JPIDatosEntrega.setLayout(JPIDatosEntregaLayout);
        JPIDatosEntregaLayout.setHorizontalGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addComponent(this.JCBMunicipioR, -2, 324, -2).addGap(18, 18, 18).addComponent(this.JCBProfesional, -2, 517, -2).addGap(0, 252, 32767)).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addComponent(this.JTFPersonaRecibe, -2, 450, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSi).addGap(18, 18, 18).addComponent(this.JCBEmpresaConvenio, 0, -1, 32767))).addContainerGap()));
        JPIDatosEntregaLayout.setVerticalGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipioR, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPersonaRecibe, -2, -1, -2).addComponent(this.JCBSi).addComponent(this.JCBEmpresaConvenio, -2, -1, -2)).addGap(25, 25, 25)));
        GroupLayout JPIDatosAdicionalesLayout = new GroupLayout(this.JPIDatosAdicionales);
        this.JPIDatosAdicionales.setLayout(JPIDatosAdicionalesLayout);
        JPIDatosAdicionalesLayout.setHorizontalGroup(JPIDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEntrega, -2, -1, -2).addContainerGap(-1, 32767)));
        JPIDatosAdicionalesLayout.setVerticalGroup(JPIDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEntrega, -2, -1, -2).addContainerGap(358, 32767)));
        this.JTPDatos.addTab("DESCUENTO", this.JPIDatosAdicionales);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBEtiqueta, -2, 192, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFDatosUsuario, -1, -1, 32767).addComponent(this.JLBEtiqueta, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 567, -2).addContainerGap(27, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSiActionPerformed(ActionEvent evt) {
        if (this.JCBSi.isSelected()) {
            this.JTFPersonaRecibe.setText(this.frmPersona.txtNombre1.getText() + " " + this.frmPersona.txtNombre2.getText() + " " + this.frmPersona.txtApellido1.getText() + " " + this.frmPersona.txtApellido2.getText());
        } else {
            this.JTFPersonaRecibe.setText((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUnaActionPerformed(ActionEvent evt) {
        this.xnquincenas = 1;
        this.frmOrdenesSuministr.mCalcularTotalFormula();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDosActionPerformed(ActionEvent evt) {
        this.xnquincenas = 2;
        this.frmOrdenesSuministr.mCalcularTotalFormula();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTresActionPerformed(ActionEvent evt) {
        this.xnquincenas = 3;
        this.frmOrdenesSuministr.mCalcularTotalFormula();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPNoAutorizadoActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().equals("")) {
            Object[] botones = {"Registrar", "Consultar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "PRODUCTOS NEGADOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                Principal.claseautorizacionmp.cargarPantalla("PNoAutorizados");
                return;
            } else {
                if (n == 1) {
                    Principal.claseautorizacionmp.cargarPantalla("PNoAutorizadosC");
                    return;
                }
                return;
            }
        }
        Principal.claseautorizacionmp.cargarPantalla("PNoAutorizadosC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAreaLab1ActionPerformed(ActionEvent evt) {
        try {
            try {
                Desktop.getDesktop().browse(new URI("http://consultaregistro.invima.gov.co:8082/Consultas/consultas/consreg_encabcum.jsp"));
            } catch (IOException ex) {
                Logger.getLogger(JIFAutorizaciones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (URISyntaxException ex2) {
            Logger.getLogger(JIFAutorizaciones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), Principal.txtNo.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
        }
    }

    private void mCargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.frmPersona.setBounds(10, 20, 940, 160);
        this.JPIFDatosUsuario.add(this.frmPersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargarPanelFormula() {
        this.frmOrdenesSuministr = new JPOOrdenSuministroH("Autorizacion", this);
        mostrarPanel(this.frmOrdenesSuministr);
    }

    public void mostrarPanel(JPanel formulario) {
        formulario.setBounds(5, 5, 850, 597);
        this.JPIFormula.add(formulario);
        this.JPIFormula.setVisible(true);
        repaint();
    }

    public boolean verificar() {
        boolean estado = false;
        if (this.JCBMunicipioR.getSelectedIndex() != -1) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (this.JCBEmpresaConvenio.getSelectedIndex() != -1) {
                    if (this.frmOrdenesSuministr.mVerificarDatos()) {
                        estado = true;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe adicionar un medicamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTPDatos.setSelectedIndex(0);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTPDatos.setSelectedIndex(1);
                    this.JCBEmpresaConvenio.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTPDatos.setSelectedIndex(1);
                this.JCBProfesional.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPDatos.setSelectedIndex(1);
            this.JCBMunicipioR.requestFocus();
        }
        return estado;
    }

    public void mVerificarAlergia(String usuario) {
        try {
            String sql = "SELECT `g_usuarioxtipoalerta`.`Detalle` FROM `g_usuarioxtipoalerta`  INNER JOIN `baseserver`.`g_tipoalerta` ON (`g_usuarioxtipoalerta`.`Id_TipoAlerta` = `g_tipoalerta`.`Id`) WHERE (`g_tipoalerta`.`EsHC` =1 AND `g_usuarioxtipoalerta`.`Id_Usuario` ='" + usuario + "' AND `g_usuarioxtipoalerta`.`Id_TipoAlerta` =4)";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                String xalergias = "";
                while (xrs.next()) {
                    xalergias = xalergias + "<html><P ALIGN=left><font color=#FF0000> " + xrs.getString(1) + "</font> <P>";
                }
                JOptionPane.showMessageDialog(this, xalergias, " PACIENTE CON ALERGIA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizaciones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGuardarDDescuento() {
        String sql = "Insert Into d_descuento (FechaD, Id_HAtencion, Id_PersonaDescuento, Valor, NQuincenas, VDescontarQ, PersonaRecibe, Id_Municipio, Fecha, UsuarioS) values('" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + Principal.txtNo.getText() + "','" + this.xidpersonad + "',Round(" + this.JTFFValorDescuento.getValue() + "),'" + this.xnquincenas + "',round(" + this.JTFFValorDescuentoxQuinc.getValue() + "),'" + this.JTFPersonaRecibe.getText() + "','" + this.xidmunicipio[this.JCBMunicipioR.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(sql));
        this.consultas.cerrarConexionBd();
    }

    private void mLimpiarComponentes() {
        Principal.mLimpiarDatosP();
        this.JCBMunicipioR.removeAllItems();
        this.JCBEmpresaConvenio.removeAllItems();
        this.JCBProfesional.removeAllItems();
        this.xidmunicipio = this.consultas.llenarCombo("SELECT Id, Nbre, Estado FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipioR);
        this.JCBMunicipioR.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xidempresa = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1 AND EsConvenioMp =1) ORDER BY Nbre ASC", this.xidempresa, this.JCBEmpresaConvenio);
        this.JCBEmpresaConvenio.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xidprofesional = this.consultas.llenarComboyLista("SELECT profesional.Id_Persona, profesional.NProfesional, g_especialidad.Id FROM baseserver.g_profesionalespecial INNER JOIN g_profesional ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) WHERE (g_profesional.Estado =0) ORDER BY profesional.NProfesional ASC", this.xidprofesional, this.JCBProfesional, 3);
        this.JCBProfesional.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        Principal.lblNo.setText("N° Atención");
        Principal.lblFecha.setText("N° Descuento");
        Principal.txtFecha.setText((String) null);
        this.JCBSi.setSelected(false);
        this.JRBTres.setSelected(true);
        this.JCBEmpresaConvenio.setSelectedIndex(-1);
        this.JLBEtiqueta.setText("");
        this.JTFFValorDescuento.setValue(0);
        this.JTFFValorDescuentoxQuinc.setValue(0);
        this.JTFFValorTratamiento.setValue(0);
        this.JTFPersonaRecibe.setText((String) null);
        this.JTPNotasAdicionales.setText((String) null);
        this.JLBEtiqueta.setIcon((Icon) null);
        this.xguardado = 0;
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Formula", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.frmPersona.nuevo();
            this.frmOrdenesSuministr.nuevo();
            mLimpiarComponentes();
            this.frmPersona.txtHistoria.requestFocus();
            this.xidpersonad = 0L;
            return;
        }
        if (n == 1) {
            this.frmOrdenesSuministr.nuevo();
            mLimpiarComponentes();
            this.JCBMunicipioR.requestFocus();
        }
    }

    public void grabar() {
        if (verificar() && this.xguardado == 0) {
            this.frmPersona.grabar();
            this.frmOrdenesSuministr.grabar();
            int xv = JOptionPane.showInternalConfirmDialog(this, "Desea generar el descuento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv == 0) {
                mGuardarDDescuento();
            }
        }
    }

    public void buscar() {
        Object[] botones = {"Usuario", "Atenciones", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this.frmPersona);
            frmBuscar.setVisible(true);
            return;
        }
        if (n == 1) {
            if (!this.frmPersona.getIdPersona().equals("0")) {
                this.frmConsultar = new JIFConsultarOrdenes(this);
                Principal.PanelPpal.add(this.frmConsultar, JLayeredPane.DEFAULT_LAYER);
                this.frmConsultar.setVisible(true);
                try {
                    this.frmConsultar.setSelected(true);
                    return;
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, e);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe tener seleccionado un usuario", "CONSULTAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
        }
    }

    public void mBuscarUsuarioPEnvioMedicamento(String xidpersona) {
        String sql = "SELECT ingreso.Id_Usuario FROM d_programaenviomedicamentos INNER JOIN h_ordenes  ON (d_programaenviomedicamentos.N_OrdenHc = h_ordenes.Id) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + xidpersona + "'  AND d_programaenviomedicamentos.Estado =1) ";
        ResultSet xr = this.consultas.traerRs(sql);
        try {
            if (xr.next()) {
                this.JLBEtiqueta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gif animado.gif")));
            } else {
                this.JLBEtiqueta.setIcon((Icon) null);
            }
            xr.close();
            this.consultas.cerrarConexionBd();
            String sql2 = "SELECT Id_PersDescuento FROM baseserver.g_usuario_fpz WHERE (Id_Persona ='" + xidpersona + "')";
            ResultSet xr2 = this.consultas.traerRs(sql2);
            if (xr2.next()) {
                this.xidpersonad = xr2.getLong(1);
            } else {
                this.xidpersonad = 0L;
            }
            xr2.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizaciones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
