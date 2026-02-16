package AutorizacionMP;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Historia.JPOOrdenSuministroH;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFAutorizaciones.class */
public class JIFAutorizaciones extends JInternalFrame {
    public Persona frmPersona;
    public JPOOrdenSuministroH frmOrdenesSuministr;
    public JIFConsultarOrdenes frmConsultar;
    public String[] xidmunicipio;
    public String[] xidempresa;
    public String[][] xidprofesional;
    private ButtonGroup JBGOpciones;
    private JButton JBTAreaLab1;
    private JButton JBTPNoAutorizado;
    public JComboBox JCBEmpresaConvenio;
    public JComboBox JCBMunicipioR;
    public JComboBox JCBProfesional;
    private JCheckBox JCBSi;
    private JLabel JLBEtiqueta;
    private JPanel JPIDatoDescuento;
    private JPanel JPIDatosEntrega;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIFondo;
    private JPanel JPINQuincena;
    private JRadioButton JRBDos;
    private JRadioButton JRBTres;
    private JRadioButton JRBUna;
    private JScrollPane JSPNotasAdicionales;
    public JFormattedTextField JTFFValorDescuento;
    public JFormattedTextField JTFFValorDescuentoxQuinc;
    public JFormattedTextField JTFFValorTratamiento;
    private JTextField JTFPersonaRecibe;
    private JTaskPaneGroup JTPGUsuario;
    private JTextPane JTPNotasAdicionales;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTaskPane jTaskPane1;
    private JTaskPaneGroup jTaskPaneGroup2;
    private JTaskPaneGroup jTaskPaneGroup3;
    public int xnquincenas = 3;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int xguardado = 0;
    private long xidpersonad = 0;

    public JIFAutorizaciones() {
        initComponents();
        this.xidmunicipio = this.consultas.llenarCombo("SELECT Id, Nbre, Estado FROM baseserver.g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipioR);
        this.JCBMunicipioR.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xidempresa = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1 AND EsConvenioMp =1) ORDER BY Nbre ASC", this.xidempresa, this.JCBEmpresaConvenio);
        this.JCBEmpresaConvenio.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xidprofesional = this.consultas.llenarComboyLista("SELECT profesional.Id_Persona, profesional.NProfesional, g_especialidad.Id FROM baseserver.g_profesionalespecial INNER JOIN baseserver.g_profesional ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) WHERE (g_profesional.Estado =0) ORDER BY profesional.NProfesional ASC", this.xidprofesional, this.JCBProfesional, 3);
        this.JCBProfesional.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        Principal.lblNo.setText("N° Atención");
        Principal.lblFecha.setText("N° Descuento");
        Principal.txtFecha.setText((String) null);
        mCargarPanelPersona();
        mCargarPanelFormula();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jTaskPane1 = new JTaskPane();
        this.JTPGUsuario = new JTaskPaneGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JLBEtiqueta = new JLabel();
        this.jTaskPaneGroup2 = new JTaskPaneGroup();
        this.jPanel1 = new JPanel();
        this.JPIDatosEntrega = new JPanel();
        this.JCBMunicipioR = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBSi = new JCheckBox();
        this.JTFPersonaRecibe = new JTextField();
        this.JCBEmpresaConvenio = new JComboBox();
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
        this.jTaskPaneGroup3 = new JTaskPaneGroup();
        this.jPanel2 = new JPanel();
        this.JPIFondo = new JPanel();
        this.JBTPNoAutorizado = new JButton();
        this.JBTAreaLab1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUTORIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifautorizacion");
        setVisible(true);
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFAutorizaciones.1
            public void internalFrameActivated(InternalFrameEvent evt) {
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
                JIFAutorizaciones.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jTaskPane1.setAutoscrolls(true);
        this.jTaskPane1.setDoubleBuffered(true);
        this.jTaskPane1.setOpaque(false);
        this.JTPGUsuario.setSpecial(true);
        this.JTPGUsuario.setTitle("Usuario");
        this.JTPGUsuario.setFont(new Font("Arial", 1, 12));
        this.JTPGUsuario.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFAutorizaciones.2
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizaciones.this.JTPGUsuarioMouseClicked(evt);
            }
        });
        this.JTPGUsuario.addHierarchyListener(new HierarchyListener() { // from class: AutorizacionMP.JIFAutorizaciones.3
            public void hierarchyChanged(HierarchyEvent evt) {
                JIFAutorizaciones.this.JTPGUsuarioHierarchyChanged(evt);
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createEtchedBorder());
        this.JPIFDatosUsuario.setFont(new Font("Arial", 1, 12));
        this.JLBEtiqueta.setFont(new Font("Arial", 1, 18));
        this.JLBEtiqueta.setForeground(Color.red);
        this.JLBEtiqueta.setHorizontalAlignment(4);
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosUsuarioLayout.createSequentialGroup().addContainerGap(891, 32767).addComponent(this.JLBEtiqueta, -2, 234, -2).addContainerGap()));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosUsuarioLayout.createSequentialGroup().addComponent(this.JLBEtiqueta, -1, 163, 32767).addContainerGap()));
        this.JTPGUsuario.getContentPane().add(this.JPIFDatosUsuario);
        this.jTaskPane1.add(this.JTPGUsuario);
        this.jTaskPaneGroup2.setBackground(new Color(0, 102, 0));
        this.jTaskPaneGroup2.setExpanded(false);
        this.jTaskPaneGroup2.setSpecial(true);
        this.jTaskPaneGroup2.setTitle("Descuento");
        this.jTaskPaneGroup2.setFont(new Font("Arial", 1, 12));
        this.JPIDatosEntrega.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Adicionales", 2, 0, new Font("Tahoma", 1, 14), new Color(0, 102, 102)));
        this.JCBMunicipioR.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipioR.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional o Clinica", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JCBSi.setFont(new Font("Arial", 1, 11));
        this.JCBSi.setForeground(Color.blue);
        this.JCBSi.setText("Si");
        this.JCBSi.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.4
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JCBSiActionPerformed(evt);
            }
        });
        this.JTFPersonaRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFPersonaRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que Recibe", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JCBEmpresaConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Autorizada para Cobro", 2, 0, new Font("Arial", 1, 11), Color.blue));
        GroupLayout JPIDatosEntregaLayout = new GroupLayout(this.JPIDatosEntrega);
        this.JPIDatosEntrega.setLayout(JPIDatosEntregaLayout);
        JPIDatosEntregaLayout.setHorizontalGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addComponent(this.JCBMunicipioR, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, 0, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEntregaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFPersonaRecibe, -2, 199, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresaConvenio, -2, 266, -2))).addContainerGap()));
        JPIDatosEntregaLayout.setVerticalGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEntregaLayout.createSequentialGroup().addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipioR, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(JPIDatosEntregaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPersonaRecibe, -2, -1, -2).addComponent(this.JCBSi).addComponent(this.JCBEmpresaConvenio, -2, -1, -2)).addGap(25, 25, 25)));
        this.JPIDatoDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Descuento", 2, 0, new Font("Tahoma", 1, 14), new Color(0, 153, 153)));
        this.JPINQuincena.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Quincenas", 1, 0, new Font("Arial", 0, 11), new Color(0, 102, 102)));
        this.JBGOpciones.add(this.JRBUna);
        this.JRBUna.setFont(new Font("Arial", 1, 12));
        this.JRBUna.setForeground(new Color(0, 0, 153));
        this.JRBUna.setText("Una");
        this.JRBUna.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.5
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JRBUnaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBDos);
        this.JRBDos.setFont(new Font("Arial", 1, 12));
        this.JRBDos.setForeground(new Color(0, 0, 153));
        this.JRBDos.setText("Dos");
        this.JRBDos.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.6
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JRBDosActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBTres);
        this.JRBTres.setFont(new Font("Arial", 1, 12));
        this.JRBTres.setForeground(new Color(0, 0, 153));
        this.JRBTres.setSelected(true);
        this.JRBTres.setText("Tres");
        this.JRBTres.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.7
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JRBTresActionPerformed(evt);
            }
        });
        this.JTFFValorTratamiento.setEditable(false);
        this.JTFFValorTratamiento.setBackground(new Color(0, 0, 153));
        this.JTFFValorTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Tratamiento", 2, 0, new Font("Arial", 1, 11), new Color(204, 255, 255)));
        this.JTFFValorTratamiento.setForeground(new Color(255, 255, 255));
        this.JTFFValorTratamiento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTratamiento.setHorizontalAlignment(0);
        this.JTFFValorTratamiento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorTratamiento.setEnabled(false);
        this.JTFFValorTratamiento.setFont(new Font("Arial", 1, 18));
        this.JTFFValorTratamiento.setValue(new Integer(0));
        this.JSPNotasAdicionales.setBorder(BorderFactory.createTitledBorder((Border) null, "Notas Adicionales", 1, 0, new Font("Arial", 1, 11), new Color(0, 102, 102)));
        this.JSPNotasAdicionales.setFont(new Font("Arial", 1, 12));
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
        this.JTFFValorDescuentoxQuinc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Descuento x Quincena", 2, 0, new Font("Arial", 1, 11), new Color(204, 255, 255)));
        this.JTFFValorDescuentoxQuinc.setForeground(Color.red);
        this.JTFFValorDescuentoxQuinc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDescuentoxQuinc.setHorizontalAlignment(0);
        this.JTFFValorDescuentoxQuinc.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorDescuentoxQuinc.setEnabled(false);
        this.JTFFValorDescuentoxQuinc.setFont(new Font("Arial", 1, 18));
        this.JTFFValorDescuentoxQuinc.setValue(new Integer(0));
        GroupLayout JPINQuincenaLayout = new GroupLayout(this.JPINQuincena);
        this.JPINQuincena.setLayout(JPINQuincenaLayout);
        JPINQuincenaLayout.setHorizontalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addContainerGap().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addComponent(this.JRBUna).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDos).addGap(18, 18, 18).addComponent(this.JRBTres)).addComponent(this.JSPNotasAdicionales, -2, 218, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addComponent(this.JTFFValorTratamiento, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorDescuento, -2, 118, -2)).addGroup(JPINQuincenaLayout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.JTFFValorDescuentoxQuinc, -2, 176, -2))).addContainerGap()));
        JPINQuincenaLayout.setVerticalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINQuincenaLayout.createSequentialGroup().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPINQuincenaLayout.createSequentialGroup().addContainerGap().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorTratamiento, -2, 50, -2).addComponent(this.JTFFValorDescuento, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorDescuentoxQuinc, -2, 50, -2)).addGroup(JPINQuincenaLayout.createSequentialGroup().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUna).addComponent(this.JRBDos).addComponent(this.JRBTres)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNotasAdicionales))).addContainerGap()));
        GroupLayout JPIDatoDescuentoLayout = new GroupLayout(this.JPIDatoDescuento);
        this.JPIDatoDescuento.setLayout(JPIDatoDescuentoLayout);
        JPIDatoDescuentoLayout.setHorizontalGroup(JPIDatoDescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoDescuentoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPINQuincena, -2, -1, -2).addGap(82, 82, 82)));
        JPIDatoDescuentoLayout.setVerticalGroup(JPIDatoDescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoDescuentoLayout.createSequentialGroup().addComponent(this.JPINQuincena, -2, 138, -2).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEntrega, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatoDescuento, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPIDatoDescuento, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEntrega, -2, -1, -2))).addContainerGap()));
        this.jTaskPaneGroup2.getContentPane().add(this.jPanel1);
        this.jTaskPane1.add(this.jTaskPaneGroup2);
        this.jTaskPaneGroup3.setBackground(new Color(0, 102, 0));
        this.jTaskPaneGroup3.setExpanded(false);
        this.jTaskPaneGroup3.setSpecial(true);
        this.jTaskPaneGroup3.setTitle("Formulación");
        this.jTaskPaneGroup3.setFont(new Font("Arial", 1, 12));
        this.JPIFondo.setBorder(BorderFactory.createEtchedBorder());
        this.JBTPNoAutorizado.setFont(new Font("Arial", 1, 12));
        this.JBTPNoAutorizado.setForeground(Color.blue);
        this.JBTPNoAutorizado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/no autorizado.jpg")));
        this.JBTPNoAutorizado.setText("<html><P ALIGN=center>\nREGISTRAR PRODUCTOS \n               NO AUTORIZADOS");
        this.JBTPNoAutorizado.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.8
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JBTPNoAutorizadoActionPerformed(evt);
            }
        });
        this.JBTAreaLab1.setFont(new Font("Arial", 1, 12));
        this.JBTAreaLab1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Invima.png")));
        this.JBTAreaLab1.setText("<html><P ALIGN=center>Abrir Página Web");
        this.JBTAreaLab1.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAutorizaciones.9
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizaciones.this.JBTAreaLab1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFondoLayout = new GroupLayout(this.JPIFondo);
        this.JPIFondo.setLayout(JPIFondoLayout);
        JPIFondoLayout.setHorizontalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIFondoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAreaLab1).addComponent(this.JBTPNoAutorizado, -2, 215, -2)).addContainerGap(-1, 32767)));
        JPIFondoLayout.setVerticalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFondoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTPNoAutorizado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAreaLab1, -2, 50, -2).addContainerGap(-1, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 259, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFondo, -2, -1, -2).addContainerGap(-1, 32767))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 154, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFondo, -2, -1, -2).addContainerGap(-1, 32767))));
        GroupLayout jTaskPaneGroup3Layout = new GroupLayout(this.jTaskPaneGroup3.getContentPane());
        this.jTaskPaneGroup3.getContentPane().setLayout(jTaskPaneGroup3Layout);
        jTaskPaneGroup3Layout.setHorizontalGroup(jTaskPaneGroup3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jTaskPaneGroup3Layout.createSequentialGroup().addGap(525, 525, 525).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        jTaskPaneGroup3Layout.setVerticalGroup(jTaskPaneGroup3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2));
        this.jTaskPane1.add(this.jTaskPaneGroup3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTaskPane1, -2, 1181, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTaskPane1, -1, 920, 32767).addContainerGap()));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        dispose();
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
    public void JCBSiActionPerformed(ActionEvent evt) {
        if (this.JCBSi.isSelected()) {
            this.JTFPersonaRecibe.setText(this.frmPersona.txtNombre1.getText() + " " + this.frmPersona.txtNombre2.getText() + " " + this.frmPersona.txtApellido1.getText() + " " + this.frmPersona.txtApellido2.getText());
        } else {
            this.JTFPersonaRecibe.setText((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPGUsuarioHierarchyChanged(HierarchyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPGUsuarioMouseClicked(MouseEvent evt) {
        mExpansionUsuario();
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
                Desktop.getDesktop().browse(new URI("http://web.sivicos.gov.co:8080/consultas/consultas/consreg_encabcum.jsp"));
            } catch (IOException ex) {
                Logger.getLogger(JIFAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (URISyntaxException ex2) {
            Logger.getLogger(JIFAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mExpansionUsuario() {
        String Usuario = this.frmPersona.getApellido1().trim() + " " + this.frmPersona.getApellido2().trim() + " " + this.frmPersona.getNombre1().trim() + " " + this.frmPersona.getNombre2().trim();
        if (!this.JTPGUsuario.isExpanded()) {
            this.JTPGUsuario.setTitle("Usuario: " + Usuario);
        } else {
            this.JTPGUsuario.setTitle("Datos del Usuario");
        }
    }

    private void mCargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.frmPersona.setBounds(10, 10, 1000, 150);
        this.JPIFDatosUsuario.add(this.frmPersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargarPanelFormula() {
        this.frmOrdenesSuministr = new JPOOrdenSuministroH("Autorizacion", this);
        mostrarPanel(this.frmOrdenesSuministr);
    }

    public void mostrarPanel(JPanel formulario) {
        formulario.setBounds(5, 5, 850, 597);
        this.JPIFondo.add(formulario);
        this.JPIFondo.setVisible(true);
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
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBEmpresaConvenio.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBProfesional.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBMunicipioR.requestFocus();
        }
        return estado;
    }

    private void mGuardarDDescuento() {
        String sql = "Insert Into d_descuento (FechaD, Id_HAtencion, Id_PersonaDescuento, Valor, NQuincenas, VDescontarQ, PersonaRecibe, Id_Municipio, Fecha, UsuarioS) values('" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + Principal.txtNo.getText() + "','" + this.xidpersonad + "',Round(" + this.JTFFValorDescuento.getValue() + "),'" + this.xnquincenas + "',round(" + this.JTFFValorDescuentoxQuinc.getValue() + "),'" + this.JTFPersonaRecibe.getText() + "','" + this.xidmunicipio[this.JCBMunicipioR.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtFecha.setText(this.consultas.ejecutarSQLId(sql));
        this.consultas.cerrarConexionBd();
    }

    private void mLimpiarComponentes() {
        Principal.mLimpiarDatosP();
        this.JCBMunicipioR.setSelectedIndex(-1);
        this.JCBProfesional.setSelectedIndex(-1);
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
            JOptionPane.showInternalMessageDialog(this, "Debe tener seleccionado un usuario", "Consultar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
            Logger.getLogger(JIFAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
