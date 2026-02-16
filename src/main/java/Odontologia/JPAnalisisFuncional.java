package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPAnalisisFuncional.class */
public class JPAnalisisFuncional extends JPanel {
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private JPOdontogramaDientes xJPOdontogramaDientes;
    private JButton JBGuardar;
    private JComboBox JCBAltFonacion;
    private JComboBox JCBApertMaxima;
    private JComboBox JCBArtitEstado;
    private JComboBox JCBArtrEstado;
    private JComboBox JCBArtrEstadoIzq;
    private JComboBox JCBArtrSi;
    private JComboBox JCBArtrSiIzq;
    private JComboBox JCBArtritEstadoIzq;
    private JComboBox JCBArtritSi;
    private JComboBox JCBArtritSiIzq;
    private JComboBox JCBBiberon;
    private JComboBox JCBBrincoEstado;
    private JComboBox JCBBrincoEstadoIzq;
    private JComboBox JCBBrincoSiIzq;
    private JComboBox JCBBrincos;
    private JComboBox JCBBruxismo;
    private JComboBox JCBContPrematuro;
    private JComboBox JCBCrepEstado;
    private JComboBox JCBCrepEstadoIzq;
    private JComboBox JCBCrepSi;
    private JComboBox JCBCrepSiIzq;
    private JComboBox JCBDeflexMand;
    private JComboBox JCBDeglAtipica;
    private JComboBox JCBDesDerecha;
    private JComboBox JCBDesIzqueirda;
    private JComboBox JCBDesvMand;
    private JComboBox JCBDolorEstado;
    private JComboBox JCBDolorEstadoIzq;
    private JComboBox JCBDolorSi;
    private JComboBox JCBDolorSiIzq;
    private JComboBox JCBGuiAnt;
    private JComboBox JCBHabitos;
    private JComboBox JCBMasticacion;
    private JComboBox JCBNormEstado;
    private JComboBox JCBNormEstadoIzq;
    private JComboBox JCBNormSi;
    private JComboBox JCBNormSiIzq;
    private JComboBox JCBOnicofagia;
    private JComboBox JCBRespiracion;
    private JComboBox JCBRuidoEstado;
    private JComboBox JCBRuidoEstadoIzq;
    private JComboBox JCBRuidoSi;
    private JComboBox JCBRuidoSiIzq;
    private JComboBox JCBSubluxEstado;
    private JComboBox JCBSubluxEstadoIzq;
    private JComboBox JCBSubluxSi;
    private JComboBox JCBSubluxSiIzq;
    private JComboBox JCBSucDigital;
    private JComboBox JCBSucLabial;
    private JComboBox JCBSucObjetos;
    private JFormattedTextField JFTFMMApertMaxima;
    private JFormattedTextField JFTFMMEspacioLibreInterO;
    private JPanel JPDatosAnalisis;
    private JPanel JPHistorico;
    private JScrollPane JSPAnalisisFuncional;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion1;
    private JScrollPane JSPRespiracion;
    private JScrollPane JSPRespiracion1;
    private JScrollPane JSPRespiracion10;
    private JScrollPane JSPRespiracion11;
    private JScrollPane JSPRespiracion12;
    private JScrollPane JSPRespiracion13;
    private JScrollPane JSPRespiracion2;
    private JScrollPane JSPRespiracion3;
    private JScrollPane JSPRespiracion4;
    private JScrollPane JSPRespiracion5;
    private JScrollPane JSPRespiracion6;
    private JScrollPane JSPRespiracion7;
    private JScrollPane JSPRespiracion8;
    private JScrollPane JSPRespiracion9;
    private JTextArea JTAAltFonacion;
    private JTextArea JTAAlteraciones;
    private JTextArea JTABruxismo;
    private JTextArea JTADeflexMand;
    private JTextArea JTADesvMandi;
    private JTextArea JTAObAtipica;
    private JTextArea JTAObBiberon;
    private JTextArea JTAObDigital;
    private JTextArea JTAObLabial;
    private JTextArea JTAObObjetos;
    private JTextArea JTAObOnicofagia;
    private JTextArea JTAObsContaPrematuro;
    private JTextArea JTAObsMasticacion;
    private JTextArea JTAObsRespiracion;
    private JTextArea JTAObservacionesGen;
    private JTextField JTFCualesHabi;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private String xAnaFuncional = "";
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xsql = null;
    Metodos xmt = new Metodos();
    JPanel xJPanel = new JPanel();

    public JPAnalisisFuncional() {
        initComponents();
        mCargarCombosParametros();
        mBuscarHistorico();
        this.xmt.cargarPanelOdontogramaDientes(this);
        this.JFTFMMApertMaxima.setValue(0);
        this.JFTFMMEspacioLibreInterO.setValue(0);
        this.JCBApertMaxima.setVisible(false);
        this.JFTFMMApertMaxima.setVisible(false);
        this.JFTFMMEspacioLibreInterO.setVisible(false);
    }

    private String[] mllenarCombos(String xv, JComboBox xcombo) {
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion   ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id)  WHERE (o_tipo_contenido_descripcion.Id ='" + xv + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_parametros.Nbre ASC, o_tipo_descripcionxparametro.NOrden ASC ";
        String[] xvalor = this.xconsulta.llenarCombo(this.xsql, null, xcombo);
        this.xconsulta.cerrarConexionBd();
        return xvalor;
    }

    private void mCargarCombosParametros() {
        mllenarCombos("12", this.JCBHabitos);
        this.JCBHabitos.setSelectedIndex(-1);
        mllenarCombos("13", this.JCBRespiracion);
        this.JCBRespiracion.setSelectedIndex(-1);
        mllenarCombos("240", this.JCBMasticacion);
        this.JCBMasticacion.setSelectedIndex(-1);
        mllenarCombos("25", this.JCBBiberon);
        this.JCBBiberon.setSelectedIndex(-1);
        mllenarCombos("26", this.JCBSucObjetos);
        this.JCBSucObjetos.setSelectedIndex(-1);
        mllenarCombos("27", this.JCBSucDigital);
        this.JCBSucDigital.setSelectedIndex(-1);
        mllenarCombos("28", this.JCBSucLabial);
        this.JCBSucLabial.setSelectedIndex(-1);
        mllenarCombos("29", this.JCBDeglAtipica);
        this.JCBDeglAtipica.setSelectedIndex(-1);
        mllenarCombos("30", this.JCBOnicofagia);
        this.JCBOnicofagia.setSelectedIndex(-1);
        mllenarCombos("31", this.JCBBruxismo);
        this.JCBBruxismo.setSelectedIndex(-1);
        mllenarCombos("32", this.JCBAltFonacion);
        this.JCBAltFonacion.setSelectedIndex(-1);
        mllenarCombos("33", this.JCBDesDerecha);
        this.JCBDesDerecha.setSelectedIndex(-1);
        mllenarCombos("34", this.JCBDesIzqueirda);
        this.JCBDesIzqueirda.setSelectedIndex(-1);
        mllenarCombos("35", this.JCBGuiAnt);
        this.JCBGuiAnt.setSelectedIndex(-1);
        mllenarCombos("241", this.JCBDesvMand);
        this.JCBDesvMand.setSelectedIndex(-1);
        mllenarCombos("37", this.JCBDeflexMand);
        this.JCBDeflexMand.setSelectedIndex(-1);
        mllenarCombos("38", this.JCBApertMaxima);
        this.JCBApertMaxima.setSelectedIndex(-1);
        mllenarCombos("242", this.JCBNormSi);
        this.JCBNormSi.setSelectedIndex(-1);
        mllenarCombos("43", this.JCBRuidoSi);
        this.JCBRuidoSi.setSelectedIndex(-1);
        mllenarCombos("44", this.JCBCrepSi);
        this.JCBCrepSi.setSelectedIndex(-1);
        mllenarCombos("49", this.JCBContPrematuro);
        this.JCBContPrematuro.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v436, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGuardar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPAnalisisFuncional = new JScrollPane();
        this.JPDatosAnalisis = new JPanel();
        this.JCBHabitos = new JComboBox();
        this.JSPObservacion1 = new JScrollPane();
        this.JTAAlteraciones = new JTextArea();
        this.JTFCualesHabi = new JTextField();
        this.JCBRespiracion = new JComboBox();
        this.JSPRespiracion = new JScrollPane();
        this.JTAObsRespiracion = new JTextArea();
        this.JCBMasticacion = new JComboBox();
        this.JSPRespiracion1 = new JScrollPane();
        this.JTAObsMasticacion = new JTextArea();
        this.JCBBiberon = new JComboBox();
        this.JSPRespiracion2 = new JScrollPane();
        this.JTAObBiberon = new JTextArea();
        this.JCBSucObjetos = new JComboBox();
        this.JSPRespiracion3 = new JScrollPane();
        this.JTAObObjetos = new JTextArea();
        this.JCBSucDigital = new JComboBox();
        this.JSPRespiracion4 = new JScrollPane();
        this.JTAObDigital = new JTextArea();
        this.JCBSucLabial = new JComboBox();
        this.JSPRespiracion5 = new JScrollPane();
        this.JTAObLabial = new JTextArea();
        this.JCBDeglAtipica = new JComboBox();
        this.JSPRespiracion6 = new JScrollPane();
        this.JTAObAtipica = new JTextArea();
        this.JCBOnicofagia = new JComboBox();
        this.JSPRespiracion7 = new JScrollPane();
        this.JTAObOnicofagia = new JTextArea();
        this.JCBBruxismo = new JComboBox();
        this.JSPRespiracion8 = new JScrollPane();
        this.JTABruxismo = new JTextArea();
        this.JCBAltFonacion = new JComboBox();
        this.JSPRespiracion9 = new JScrollPane();
        this.JTAAltFonacion = new JTextArea();
        this.JCBDesDerecha = new JComboBox();
        this.JCBDesIzqueirda = new JComboBox();
        this.JCBGuiAnt = new JComboBox();
        this.JCBDesvMand = new JComboBox();
        this.JSPRespiracion10 = new JScrollPane();
        this.JTADesvMandi = new JTextArea();
        this.JCBDeflexMand = new JComboBox();
        this.JSPRespiracion11 = new JScrollPane();
        this.JTADeflexMand = new JTextArea();
        this.JCBApertMaxima = new JComboBox();
        this.JFTFMMApertMaxima = new JFormattedTextField();
        this.JCBNormSi = new JComboBox();
        this.JCBNormEstado = new JComboBox();
        this.JCBRuidoSi = new JComboBox();
        this.JCBRuidoEstado = new JComboBox();
        this.JCBCrepSi = new JComboBox();
        this.JCBCrepEstado = new JComboBox();
        this.JCBArtrSi = new JComboBox();
        this.JCBArtrEstado = new JComboBox();
        this.JCBNormSiIzq = new JComboBox();
        this.JCBRuidoSiIzq = new JComboBox();
        this.JCBCrepSiIzq = new JComboBox();
        this.JCBArtrSiIzq = new JComboBox();
        this.JCBNormEstadoIzq = new JComboBox();
        this.JCBRuidoEstadoIzq = new JComboBox();
        this.JCBCrepEstadoIzq = new JComboBox();
        this.JCBArtrEstadoIzq = new JComboBox();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.JCBBrincos = new JComboBox();
        this.JCBBrincoEstado = new JComboBox();
        this.JCBBrincoSiIzq = new JComboBox();
        this.JCBBrincoEstadoIzq = new JComboBox();
        this.JCBSubluxEstadoIzq = new JComboBox();
        this.JCBSubluxSiIzq = new JComboBox();
        this.JCBSubluxEstado = new JComboBox();
        this.JCBSubluxSi = new JComboBox();
        this.JCBDolorSi = new JComboBox();
        this.JCBDolorEstado = new JComboBox();
        this.JCBArtitEstado = new JComboBox();
        this.JCBArtritSi = new JComboBox();
        this.JCBArtritSiIzq = new JComboBox();
        this.JCBArtritEstadoIzq = new JComboBox();
        this.JCBDolorSiIzq = new JComboBox();
        this.JCBDolorEstadoIzq = new JComboBox();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.JFTFMMEspacioLibreInterO = new JFormattedTextField();
        this.JCBContPrematuro = new JComboBox();
        this.JSPRespiracion12 = new JScrollPane();
        this.JTAObsContaPrematuro = new JTextArea();
        this.JSPRespiracion13 = new JScrollPane();
        this.JTAObservacionesGen = new JTextArea();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jpanalisisfuncional");
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.1
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 107, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPAnalisisFuncional.setHorizontalScrollBarPolicy(31);
        this.JCBHabitos.setFont(new Font("Arial", 1, 12));
        this.JCBHabitos.setBorder(BorderFactory.createTitledBorder((Border) null, "Hábitos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAAlteraciones.setColumns(1);
        this.JTAAlteraciones.setFont(new Font("Arial", 0, 12));
        this.JTAAlteraciones.setLineWrap(true);
        this.JTAAlteraciones.setRows(1);
        this.JTAAlteraciones.setToolTipText("");
        this.JTAAlteraciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Alteraciones Musculares", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion1.setViewportView(this.JTAAlteraciones);
        this.JTFCualesHabi.setFont(new Font("Arial", 1, 12));
        this.JTFCualesHabi.setToolTipText("");
        this.JTFCualesHabi.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRespiracion.setFont(new Font("Arial", 1, 12));
        this.JCBRespiracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Respiración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsRespiracion.setColumns(1);
        this.JTAObsRespiracion.setFont(new Font("Arial", 0, 12));
        this.JTAObsRespiracion.setLineWrap(true);
        this.JTAObsRespiracion.setRows(1);
        this.JTAObsRespiracion.setToolTipText("");
        this.JTAObsRespiracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion.setViewportView(this.JTAObsRespiracion);
        this.JCBMasticacion.setFont(new Font("Arial", 1, 12));
        this.JCBMasticacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Masticación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsMasticacion.setColumns(1);
        this.JTAObsMasticacion.setFont(new Font("Arial", 0, 12));
        this.JTAObsMasticacion.setLineWrap(true);
        this.JTAObsMasticacion.setRows(1);
        this.JTAObsMasticacion.setToolTipText("");
        this.JTAObsMasticacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion1.setViewportView(this.JTAObsMasticacion);
        this.JCBBiberon.setFont(new Font("Arial", 1, 12));
        this.JCBBiberon.setBorder(BorderFactory.createTitledBorder((Border) null, "Uso prolongado Biberon", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObBiberon.setColumns(1);
        this.JTAObBiberon.setFont(new Font("Arial", 0, 12));
        this.JTAObBiberon.setLineWrap(true);
        this.JTAObBiberon.setRows(1);
        this.JTAObBiberon.setToolTipText("");
        this.JTAObBiberon.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion2.setViewportView(this.JTAObBiberon);
        this.JCBSucObjetos.setFont(new Font("Arial", 1, 12));
        this.JCBSucObjetos.setBorder(BorderFactory.createTitledBorder((Border) null, "Succión de Objetos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObObjetos.setColumns(1);
        this.JTAObObjetos.setFont(new Font("Arial", 0, 12));
        this.JTAObObjetos.setLineWrap(true);
        this.JTAObObjetos.setRows(1);
        this.JTAObObjetos.setToolTipText("");
        this.JTAObObjetos.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion3.setViewportView(this.JTAObObjetos);
        this.JCBSucDigital.setFont(new Font("Arial", 1, 12));
        this.JCBSucDigital.setBorder(BorderFactory.createTitledBorder((Border) null, "Succión de Digital", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSucDigital.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.2
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSucDigitalActionPerformed(evt);
            }
        });
        this.JTAObDigital.setColumns(1);
        this.JTAObDigital.setFont(new Font("Arial", 0, 12));
        this.JTAObDigital.setLineWrap(true);
        this.JTAObDigital.setRows(1);
        this.JTAObDigital.setToolTipText("");
        this.JTAObDigital.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion4.setViewportView(this.JTAObDigital);
        this.JCBSucLabial.setFont(new Font("Arial", 1, 12));
        this.JCBSucLabial.setBorder(BorderFactory.createTitledBorder((Border) null, "Succión Labial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSucLabial.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.3
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSucLabialActionPerformed(evt);
            }
        });
        this.JTAObLabial.setColumns(1);
        this.JTAObLabial.setFont(new Font("Arial", 0, 12));
        this.JTAObLabial.setLineWrap(true);
        this.JTAObLabial.setRows(1);
        this.JTAObLabial.setToolTipText("");
        this.JTAObLabial.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion5.setViewportView(this.JTAObLabial);
        this.JCBDeglAtipica.setFont(new Font("Arial", 1, 12));
        this.JCBDeglAtipica.setBorder(BorderFactory.createTitledBorder((Border) null, "Deglución Atípica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDeglAtipica.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.4
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDeglAtipicaActionPerformed(evt);
            }
        });
        this.JTAObAtipica.setColumns(1);
        this.JTAObAtipica.setFont(new Font("Arial", 0, 12));
        this.JTAObAtipica.setLineWrap(true);
        this.JTAObAtipica.setRows(1);
        this.JTAObAtipica.setToolTipText("");
        this.JTAObAtipica.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion6.setViewportView(this.JTAObAtipica);
        this.JCBOnicofagia.setFont(new Font("Arial", 1, 12));
        this.JCBOnicofagia.setBorder(BorderFactory.createTitledBorder((Border) null, "Onicofagia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBOnicofagia.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.5
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBOnicofagiaActionPerformed(evt);
            }
        });
        this.JTAObOnicofagia.setColumns(1);
        this.JTAObOnicofagia.setFont(new Font("Arial", 0, 12));
        this.JTAObOnicofagia.setLineWrap(true);
        this.JTAObOnicofagia.setRows(1);
        this.JTAObOnicofagia.setToolTipText("");
        this.JTAObOnicofagia.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion7.setViewportView(this.JTAObOnicofagia);
        this.JCBBruxismo.setFont(new Font("Arial", 1, 12));
        this.JCBBruxismo.setBorder(BorderFactory.createTitledBorder((Border) null, "Bruxismo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBruxismo.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.6
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBBruxismoActionPerformed(evt);
            }
        });
        this.JTABruxismo.setColumns(1);
        this.JTABruxismo.setFont(new Font("Arial", 0, 12));
        this.JTABruxismo.setLineWrap(true);
        this.JTABruxismo.setRows(1);
        this.JTABruxismo.setToolTipText("");
        this.JTABruxismo.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion8.setViewportView(this.JTABruxismo);
        this.JCBAltFonacion.setFont(new Font("Arial", 1, 12));
        this.JCBAltFonacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Alt. en la Fonación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAltFonacion.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.7
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBAltFonacionActionPerformed(evt);
            }
        });
        this.JTAAltFonacion.setColumns(1);
        this.JTAAltFonacion.setFont(new Font("Arial", 0, 12));
        this.JTAAltFonacion.setLineWrap(true);
        this.JTAAltFonacion.setRows(1);
        this.JTAAltFonacion.setToolTipText("");
        this.JTAAltFonacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion9.setViewportView(this.JTAAltFonacion);
        this.JCBDesDerecha.setFont(new Font("Arial", 1, 12));
        this.JCBDesDerecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Desoclusión Derecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDesDerecha.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.8
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDesDerechaActionPerformed(evt);
            }
        });
        this.JCBDesIzqueirda.setFont(new Font("Arial", 1, 12));
        this.JCBDesIzqueirda.setBorder(BorderFactory.createTitledBorder((Border) null, "Desoclusión Izquierda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDesIzqueirda.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.9
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDesIzqueirdaActionPerformed(evt);
            }
        });
        this.JCBGuiAnt.setFont(new Font("Arial", 1, 12));
        this.JCBGuiAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Guía Anterior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGuiAnt.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.10
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBGuiAntActionPerformed(evt);
            }
        });
        this.JCBDesvMand.setFont(new Font("Arial", 1, 12));
        this.JCBDesvMand.setBorder(BorderFactory.createTitledBorder((Border) null, "Desviacion Mandibular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDesvMand.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.11
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDesvMandActionPerformed(evt);
            }
        });
        this.JTADesvMandi.setColumns(1);
        this.JTADesvMandi.setFont(new Font("Arial", 0, 12));
        this.JTADesvMandi.setLineWrap(true);
        this.JTADesvMandi.setRows(1);
        this.JTADesvMandi.setToolTipText("");
        this.JTADesvMandi.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion10.setViewportView(this.JTADesvMandi);
        this.JCBDeflexMand.setFont(new Font("Arial", 1, 12));
        this.JCBDeflexMand.setBorder(BorderFactory.createTitledBorder((Border) null, "Deflexión Mandibular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDeflexMand.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.12
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDeflexMandActionPerformed(evt);
            }
        });
        this.JTADeflexMand.setColumns(1);
        this.JTADeflexMand.setFont(new Font("Arial", 0, 12));
        this.JTADeflexMand.setLineWrap(true);
        this.JTADeflexMand.setRows(1);
        this.JTADeflexMand.setToolTipText("");
        this.JTADeflexMand.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion11.setViewportView(this.JTADeflexMand);
        this.JCBApertMaxima.setFont(new Font("Arial", 1, 12));
        this.JCBApertMaxima.setBorder(BorderFactory.createTitledBorder((Border) null, "Apertura Máxima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBApertMaxima.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.13
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBApertMaximaActionPerformed(evt);
            }
        });
        this.JFTFMMApertMaxima.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMApertMaxima.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMApertMaxima.setHorizontalAlignment(4);
        this.JFTFMMApertMaxima.setFont(new Font("Arial", 1, 12));
        this.JCBNormSi.setFont(new Font("Arial", 1, 12));
        this.JCBNormSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNormSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.14
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBNormSiActionPerformed(evt);
            }
        });
        this.JCBNormEstado.setFont(new Font("Arial", 1, 12));
        this.JCBNormEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBNormEstado.setSelectedIndex(-1);
        this.JCBNormEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNormEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.15
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBNormEstadoActionPerformed(evt);
            }
        });
        this.JCBRuidoSi.setFont(new Font("Arial", 1, 12));
        this.JCBRuidoSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRuidoSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.16
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBRuidoSiActionPerformed(evt);
            }
        });
        this.JCBRuidoEstado.setFont(new Font("Arial", 1, 12));
        this.JCBRuidoEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBRuidoEstado.setSelectedIndex(-1);
        this.JCBRuidoEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRuidoEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.17
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBRuidoEstadoActionPerformed(evt);
            }
        });
        this.JCBCrepSi.setFont(new Font("Arial", 1, 12));
        this.JCBCrepSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCrepSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.18
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBCrepSiActionPerformed(evt);
            }
        });
        this.JCBCrepEstado.setFont(new Font("Arial", 1, 12));
        this.JCBCrepEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBCrepEstado.setSelectedIndex(-1);
        this.JCBCrepEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCrepEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.19
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBCrepEstadoActionPerformed(evt);
            }
        });
        this.JCBArtrSi.setFont(new Font("Arial", 1, 12));
        this.JCBArtrSi.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBArtrSi.setSelectedIndex(-1);
        this.JCBArtrSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtrSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.20
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtrSiActionPerformed(evt);
            }
        });
        this.JCBArtrEstado.setFont(new Font("Arial", 1, 12));
        this.JCBArtrEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBArtrEstado.setSelectedIndex(-1);
        this.JCBArtrEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtrEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.21
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtrEstadoActionPerformed(evt);
            }
        });
        this.JCBNormSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBNormSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBNormSiIzq.setSelectedIndex(-1);
        this.JCBNormSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNormSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.22
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBNormSiIzqActionPerformed(evt);
            }
        });
        this.JCBRuidoSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBRuidoSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBRuidoSiIzq.setSelectedIndex(-1);
        this.JCBRuidoSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRuidoSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.23
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBRuidoSiIzqActionPerformed(evt);
            }
        });
        this.JCBCrepSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBCrepSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBCrepSiIzq.setSelectedIndex(-1);
        this.JCBCrepSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCrepSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.24
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBCrepSiIzqActionPerformed(evt);
            }
        });
        this.JCBArtrSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBArtrSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBArtrSiIzq.setSelectedIndex(-1);
        this.JCBArtrSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtrSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.25
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtrSiIzqActionPerformed(evt);
            }
        });
        this.JCBNormEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBNormEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBNormEstadoIzq.setSelectedIndex(-1);
        this.JCBNormEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNormEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.26
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBNormEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBRuidoEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBRuidoEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBRuidoEstadoIzq.setSelectedIndex(-1);
        this.JCBRuidoEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRuidoEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.27
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBRuidoEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBCrepEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBCrepEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBCrepEstadoIzq.setSelectedIndex(-1);
        this.JCBCrepEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCrepEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.28
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBCrepEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBArtrEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBArtrEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBArtrEstadoIzq.setSelectedIndex(-1);
        this.JCBArtrEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtrEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.29
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtrEstadoIzqActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("DERECHO");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("IZQUIERDO");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("NORMAL");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 255));
        this.jLabel4.setText("RUIDOS");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 255));
        this.jLabel5.setText("CREPITACIÓN");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 255));
        this.jLabel6.setText("ARTROSIS");
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 255));
        this.jLabel11.setText("ARTRITIS");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 0, 255));
        this.jLabel12.setText("DOLOR");
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 255));
        this.jLabel13.setText("SUBLUXACIÓN");
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 0, 255));
        this.jLabel14.setText("BRINCOS");
        this.JCBBrincos.setFont(new Font("Arial", 1, 12));
        this.JCBBrincos.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBBrincos.setSelectedIndex(-1);
        this.JCBBrincos.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBrincos.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.30
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBBrincosActionPerformed(evt);
            }
        });
        this.JCBBrincoEstado.setFont(new Font("Arial", 1, 12));
        this.JCBBrincoEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBBrincoEstado.setSelectedIndex(-1);
        this.JCBBrincoEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBrincoEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.31
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBBrincoEstadoActionPerformed(evt);
            }
        });
        this.JCBBrincoSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBBrincoSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBBrincoSiIzq.setSelectedIndex(-1);
        this.JCBBrincoSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBrincoSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.32
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBBrincoSiIzqActionPerformed(evt);
            }
        });
        this.JCBBrincoEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBBrincoEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBBrincoEstadoIzq.setSelectedIndex(-1);
        this.JCBBrincoEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBrincoEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.33
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBBrincoEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBSubluxEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBSubluxEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBSubluxEstadoIzq.setSelectedIndex(-1);
        this.JCBSubluxEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubluxEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.34
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSubluxEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBSubluxSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBSubluxSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBSubluxSiIzq.setSelectedIndex(-1);
        this.JCBSubluxSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubluxSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.35
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSubluxSiIzqActionPerformed(evt);
            }
        });
        this.JCBSubluxEstado.setFont(new Font("Arial", 1, 12));
        this.JCBSubluxEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBSubluxEstado.setSelectedIndex(-1);
        this.JCBSubluxEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubluxEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.36
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSubluxEstadoActionPerformed(evt);
            }
        });
        this.JCBSubluxSi.setFont(new Font("Arial", 1, 12));
        this.JCBSubluxSi.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBSubluxSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubluxSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.37
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBSubluxSiActionPerformed(evt);
            }
        });
        this.JCBDolorSi.setFont(new Font("Arial", 1, 12));
        this.JCBDolorSi.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBDolorSi.setSelectedIndex(-1);
        this.JCBDolorSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDolorSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.38
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDolorSiActionPerformed(evt);
            }
        });
        this.JCBDolorEstado.setFont(new Font("Arial", 1, 12));
        this.JCBDolorEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBDolorEstado.setSelectedIndex(-1);
        this.JCBDolorEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDolorEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.39
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDolorEstadoActionPerformed(evt);
            }
        });
        this.JCBArtitEstado.setFont(new Font("Arial", 1, 12));
        this.JCBArtitEstado.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBArtitEstado.setSelectedIndex(-1);
        this.JCBArtitEstado.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtitEstado.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.40
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtitEstadoActionPerformed(evt);
            }
        });
        this.JCBArtritSi.setFont(new Font("Arial", 1, 12));
        this.JCBArtritSi.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBArtritSi.setSelectedIndex(-1);
        this.JCBArtritSi.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtritSi.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.41
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtritSiActionPerformed(evt);
            }
        });
        this.JCBArtritSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBArtritSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBArtritSiIzq.setSelectedIndex(-1);
        this.JCBArtritSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtritSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.42
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtritSiIzqActionPerformed(evt);
            }
        });
        this.JCBArtritEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBArtritEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBArtritEstadoIzq.setSelectedIndex(-1);
        this.JCBArtritEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArtritEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.43
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBArtritEstadoIzqActionPerformed(evt);
            }
        });
        this.JCBDolorSiIzq.setFont(new Font("Arial", 1, 12));
        this.JCBDolorSiIzq.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBDolorSiIzq.setSelectedIndex(-1);
        this.JCBDolorSiIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDolorSiIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.44
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDolorSiIzqActionPerformed(evt);
            }
        });
        this.JCBDolorEstadoIzq.setFont(new Font("Arial", 1, 12));
        this.JCBDolorEstadoIzq.setModel(new DefaultComboBoxModel(new String[]{"APERTURA", "CIERRE"}));
        this.JCBDolorEstadoIzq.setSelectedIndex(-1);
        this.JCBDolorEstadoIzq.setBorder(BorderFactory.createTitledBorder((Border) null, " ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDolorEstadoIzq.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.45
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBDolorEstadoIzqActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 255));
        this.jLabel7.setText("DERECHO");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 0, 255));
        this.jLabel8.setText("IZQUIERDO");
        this.JFTFMMEspacioLibreInterO.setBorder(BorderFactory.createTitledBorder((Border) null, "Espacio libre interoclusal (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMEspacioLibreInterO.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMEspacioLibreInterO.setHorizontalAlignment(4);
        this.JFTFMMEspacioLibreInterO.setFont(new Font("Arial", 1, 12));
        this.JCBContPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCBContPrematuro.setBorder(BorderFactory.createTitledBorder((Border) null, "Contacto Prematuro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBContPrematuro.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisFuncional.46
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisFuncional.this.JCBContPrematuroActionPerformed(evt);
            }
        });
        this.JTAObsContaPrematuro.setColumns(1);
        this.JTAObsContaPrematuro.setFont(new Font("Arial", 0, 12));
        this.JTAObsContaPrematuro.setLineWrap(true);
        this.JTAObsContaPrematuro.setRows(1);
        this.JTAObsContaPrematuro.setToolTipText("");
        this.JTAObsContaPrematuro.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion12.setViewportView(this.JTAObsContaPrematuro);
        this.JTAObservacionesGen.setColumns(1);
        this.JTAObservacionesGen.setFont(new Font("Arial", 0, 12));
        this.JTAObservacionesGen.setLineWrap(true);
        this.JTAObservacionesGen.setRows(1);
        this.JTAObservacionesGen.setToolTipText("");
        this.JTAObservacionesGen.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion13.setViewportView(this.JTAObservacionesGen);
        GroupLayout JPDatosAnalisisLayout = new GroupLayout(this.JPDatosAnalisis);
        this.JPDatosAnalisis.setLayout(JPDatosAnalisisLayout);
        JPDatosAnalisisLayout.setHorizontalGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBHabitos, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCualesHabi)).addComponent(this.JSPObservacion1).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGuiAnt, -2, 243, -2).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBRespiracion, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBMasticacion, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion1, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBBiberon, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion2, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBSucObjetos, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion3, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBSucDigital, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion4, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBSucLabial, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion5, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBDeglAtipica, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion6, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBOnicofagia, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion7, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBBruxismo, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion8, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBAltFonacion, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion9, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBDesvMand, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRespiracion10, -2, 362, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBApertMaxima, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBDeflexMand, GroupLayout.Alignment.LEADING, 0, 160, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRespiracion11, -2, 362, -2).addComponent(this.JFTFMMApertMaxima, -2, 82, -2)))).addGap(0, 0, 32767))).addContainerGap(-1, 32767)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDesDerecha, 0, 243, 32767).addComponent(this.JCBDesIzqueirda, 0, -1, 32767)).addContainerGap(-1, 32767)))).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel5).addComponent(this.jLabel4).addComponent(this.jLabel6)).addGap(3, 3, 3).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBCrepSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBCrepEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBRuidoSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBRuidoEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBNormSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBNormEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBArtrSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBArtrEstado, -2, 89, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBArtrSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBArtrEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBCrepSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBCrepEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBRuidoSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBRuidoEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBNormSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBNormEstadoIzq, -2, 89, -2)))).addGap(3, 3, 3).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.jLabel13).addComponent(this.jLabel12).addComponent(this.jLabel14)).addGap(3, 3, 3).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBSubluxSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBSubluxEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBDolorSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBDolorEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBArtritSi, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBArtitEstado, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBBrincos, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBBrincoEstado, -2, 89, -2))).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBBrincoSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBBrincoEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBSubluxSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBSubluxEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBDolorSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBDolorEstadoIzq, -2, 89, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addComponent(this.JCBArtritSiIzq, -2, 59, -2).addGap(2, 2, 2).addComponent(this.JCBArtritEstadoIzq, -2, 89, -2)))).addGap(0, 11, 32767)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(119, 119, 119).addComponent(this.jLabel1).addGap(101, 101, 101).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel7).addGap(101, 101, 101).addComponent(this.jLabel8).addGap(58, 58, 58)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRespiracion13, -2, 745, -2).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBContPrematuro, GroupLayout.Alignment.LEADING, 0, 206, 32767).addComponent(this.JFTFMMEspacioLibreInterO, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespiracion12, -2, 362, -2))).addContainerGap(-1, 32767)));
        JPDatosAnalisisLayout.setVerticalGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion1, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHabitos, -2, 50, -2).addComponent(this.JTFCualesHabi, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBRespiracion, -1, 50, 32767).addComponent(this.JSPRespiracion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBMasticacion).addComponent(this.JSPRespiracion1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBBiberon).addComponent(this.JSPRespiracion2, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSucObjetos).addComponent(this.JSPRespiracion3, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSucDigital).addComponent(this.JSPRespiracion4, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSucLabial).addComponent(this.JSPRespiracion5, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDeglAtipica).addComponent(this.JSPRespiracion6, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBOnicofagia).addComponent(this.JSPRespiracion7, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBBruxismo).addComponent(this.JSPRespiracion8, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBAltFonacion).addComponent(this.JSPRespiracion9, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDesDerecha, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDesIzqueirda, -2, 50, -2).addGap(6, 6, 6).addComponent(this.JCBGuiAnt, -2, 50, -2).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDesvMand).addComponent(this.JSPRespiracion10, -2, 50, -2)).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDeflexMand).addComponent(this.JSPRespiracion11, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBApertMaxima).addComponent(this.JFTFMMApertMaxima, -2, 50, -2)).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel7).addComponent(this.jLabel8)).addGap(5, 5, 5).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNormSi).addComponent(this.JCBNormEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRuidoSi).addComponent(this.JCBRuidoEstado).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCrepSi).addComponent(this.JCBCrepEstado).addComponent(this.jLabel5))).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel3))).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jLabel6).addGap(0, 0, 32767)).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArtrSi).addComponent(this.JCBArtrEstado))).addGap(15, 15, 15).addComponent(this.JFTFMMEspacioLibreInterO, -2, 50, -2)).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArtritSi).addComponent(this.JCBArtitEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDolorSi).addComponent(this.JCBDolorEstado).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSubluxSi).addComponent(this.JCBSubluxEstado).addComponent(this.jLabel13))).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel11))).addGap(6, 6, 6).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jLabel14).addGap(0, 0, 32767)).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBrincos).addComponent(this.JCBBrincoEstado)))).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArtritSiIzq).addComponent(this.JCBArtritEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDolorSiIzq).addComponent(this.JCBDolorEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSubluxSiIzq).addComponent(this.JCBSubluxEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBrincoSiIzq).addComponent(this.JCBBrincoEstadoIzq))).addGroup(JPDatosAnalisisLayout.createSequentialGroup().addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNormSiIzq).addComponent(this.JCBNormEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRuidoSiIzq).addComponent(this.JCBRuidoEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCrepSiIzq).addComponent(this.JCBCrepEstadoIzq)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArtrSiIzq).addComponent(this.JCBArtrEstadoIzq)))).addGap(74, 74, 74))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBContPrematuro).addComponent(this.JSPRespiracion12, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespiracion13, -2, 109, -2).addContainerGap()));
        this.JSPAnalisisFuncional.setViewportView(this.JPDatosAnalisis);
        this.JTPDatos.addTab("ANALISIS FUNCIONAL", this.JSPAnalisisFuncional);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPAnalisisFuncional.47
            public void mouseClicked(MouseEvent evt) {
                JPAnalisisFuncional.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 694, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 284, -2).addContainerGap(227, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBGuardar, -2, 652, -2).addGap(0, 57, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 553, -2).addGap(10, 10, 10).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        mVerificaAnalisisAtencion();
        mImprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSucDigitalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSucLabialActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDeglAtipicaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOnicofagiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBruxismoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAltFonacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDesDerechaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDesIzqueirdaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGuiAntActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDesvMandActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDeflexMandActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBApertMaximaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNormSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNormEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRuidoSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRuidoEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCrepSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCrepEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtrSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtrEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNormSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRuidoSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCrepSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtrSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNormEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRuidoEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCrepEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtrEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBrincosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBrincoEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBrincoSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBrincoEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubluxEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubluxSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubluxEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubluxSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDolorSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDolorEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtitEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtritSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtritSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArtritEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDolorSiIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDolorEstadoIzqActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBContPrematuroActionPerformed(ActionEvent evt) {
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.xAnaFuncional.equals("")) {
                String sql = "INSERT INTO `baseserver`.`o_analisis_funcional`  ( `IdAtencion`,  `IdUsuario`,  `IdTratamiento`, `IdProfesional`, `IdEspecialidad`, `AlterMuscular`, `Habitos`,  `ObsHabitos`, `Respiracion`, `ObsRespiracion`,  `Masticacion`, `ObsMasticacion`, `UsoProlo`, `ObsUsoProlo`, `SucObjeto`, `ObsSucObj`, `SucDigital`, `ObsSucDigital`, `SucLabial`, `ObsSucLabial`, `DegAtipica`, `ObsDegAtipica`, `Onicofagia`, `ObsOnicofagia`, `Bruxismo`, `ObsBruxismo`,  `AltFonacion`, `ObsAltFonacion`, `DesDerecha`,  `DesIzquierda`, `GuiaAnterior`, `DesvMand`,  `ObsDesvMand`, `DefleMand`, `ObsDefleMand`, `AperMaxima`, `ValAperMax`,  `NormalDer`, `NormalEstDer`, `NormalIzq`, `NormalEstIzq`, `RuidoDer`, `RuidoEstDer`, `RuidoIzq`, `RuidoEstIzq`, `CrepitacionDer`, `CrepitacionEstDer`, `CrepitacionIzq`, `CrepitacionEstIzq`, `ArtrosisDer`, `ArtrosisEstDer`, `ArtrosisIzq`, `ArtrosisEstIzq`, `ArtritisDer`, `ArtritisEstDer`, `ArtritisIzq`,  `ArtritisEstIzq`, `DolorDer`, `DolorEstDer`, `DolorIzq`, `DolorEstIzq`, `SubluxacionDer`, `SubluxacionEstDer`, `SubluxacionIzq`, `SubluxacionEstIzq`, `BrincosDer`, `BrincosEstDer`, `BrincosIzq`, `BrincosEstIzq`,  `EspLInter`, `ContPrema`, `ObsContPrema`, `Obsgeneral`, `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',  '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.JTAAlteraciones.getText() + "',  '" + this.JCBHabitos.getSelectedItem() + "',  '" + this.JTFCualesHabi.getText() + "', '" + this.JCBRespiracion.getSelectedItem() + "',  '" + this.JTAObsRespiracion.getText() + "', '" + this.JCBMasticacion.getSelectedItem() + "', '" + this.JTAObsMasticacion.getText() + "', '" + this.JCBBiberon.getSelectedItem() + "',  '" + this.JTAObBiberon.getText() + "', '" + this.JCBSucObjetos.getSelectedItem() + "',  '" + this.JTAObObjetos.getText() + "', '" + this.JCBSucDigital.getSelectedItem() + "', '" + this.JTAObDigital.getText() + "',  '" + this.JCBSucLabial.getSelectedItem() + "', '" + this.JTAObLabial.getText() + "', '" + this.JCBDeglAtipica.getSelectedItem() + "',  '" + this.JTAObAtipica.getText() + "',  '" + this.JCBOnicofagia.getSelectedItem() + "', '" + this.JTAObOnicofagia.getText() + "', '" + this.JCBBruxismo.getSelectedItem() + "', '" + this.JTABruxismo.getText() + "', '" + this.JCBAltFonacion.getSelectedItem() + "', '" + this.JTAAltFonacion.getText() + "', '" + this.JCBDesDerecha.getSelectedItem() + "', '" + this.JCBDesIzqueirda.getSelectedItem() + "',  '" + this.JCBGuiAnt.getSelectedItem() + "', '" + this.JCBDesvMand.getSelectedItem() + "', '" + this.JTADesvMandi.getText() + "',  '" + this.JCBDeflexMand.getSelectedItem() + "', '" + this.JTADeflexMand.getText() + "', '" + this.JCBApertMaxima.getSelectedItem() + "', '" + this.JFTFMMApertMaxima.getValue() + "',  '" + this.JCBNormSi.getSelectedItem() + "', '" + this.JCBNormEstado.getSelectedItem() + "', '" + this.JCBNormSiIzq.getSelectedItem() + "', '" + this.JCBNormEstadoIzq.getSelectedItem() + "', '" + this.JCBRuidoSi.getSelectedItem() + "', '" + this.JCBRuidoEstado.getSelectedItem() + "', '" + this.JCBRuidoSiIzq.getSelectedItem() + "', '" + this.JCBRuidoEstadoIzq.getSelectedItem() + "', '" + this.JCBCrepSi.getSelectedItem() + "', '" + this.JCBCrepEstado.getSelectedItem() + "', '" + this.JCBCrepSiIzq.getSelectedItem() + "',  '" + this.JCBCrepEstadoIzq.getSelectedItem() + "', '" + this.JCBArtrSi.getSelectedItem() + "', '" + this.JCBArtrEstado.getSelectedItem() + "',  '" + this.JCBArtrSiIzq.getSelectedItem() + "', '" + this.JCBArtrEstadoIzq.getSelectedItem() + "',  '" + this.JCBArtritSi.getSelectedItem() + "', '" + this.JCBArtitEstado.getSelectedItem() + "', '" + this.JCBArtritSiIzq.getSelectedItem() + "', '" + this.JCBArtritEstadoIzq.getSelectedItem() + "', '" + this.JCBDolorSi.getSelectedItem() + "', '" + this.JCBDolorEstado.getSelectedItem() + "', '" + this.JCBDolorSiIzq.getSelectedItem() + "', '" + this.JCBDolorEstadoIzq.getSelectedItem() + "', '" + this.JCBSubluxSi.getSelectedItem() + "', '" + this.JCBSubluxEstado.getSelectedItem() + "', '" + this.JCBSubluxSiIzq.getSelectedItem() + "', '" + this.JCBSubluxEstadoIzq.getSelectedItem() + "', '" + this.JCBBrincos.getSelectedItem() + "',  '" + this.JCBBrincoEstado.getSelectedItem() + "', '" + this.JCBBrincoSiIzq.getSelectedItem() + "',  '" + this.JCBBrincoEstadoIzq.getSelectedItem() + "', '" + this.JFTFMMEspacioLibreInterO.getValue() + "', '" + this.JCBContPrematuro.getSelectedItem() + "',  '" + this.JTAObsContaPrematuro.getText() + "', '" + this.JTAObservacionesGen.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xAnaFuncional = this.xconsulta.ejecutarSQLId(sql);
            } else {
                String sql2 = "UPDATE `o_analisis_funcional` SET   `AlterMuscular` = '" + this.JTAAlteraciones.getText() + "',   `Habitos` = '" + this.JCBHabitos.getSelectedItem() + "',   `ObsHabitos` = '" + this.JTFCualesHabi.getText() + "',   `Respiracion` = '" + this.JCBRespiracion.getSelectedItem() + "',   `ObsRespiracion` = '" + this.JTAObsRespiracion.getText() + "',   `Masticacion` = '" + this.JCBMasticacion.getSelectedItem() + "',   `ObsMasticacion` = '" + this.JTAObsMasticacion.getText() + "',   `UsoProlo` = '" + this.JCBBiberon.getSelectedItem() + "',   `ObsUsoProlo` = '" + this.JTAObBiberon.getText() + "',   `SucObjeto` = '" + this.JCBSucObjetos.getSelectedItem() + "',   `ObsSucObj` = '" + this.JTAObObjetos.getText() + "',   `SucDigital` = '" + this.JCBSucDigital.getSelectedItem() + "',   `ObsSucDigital` = '" + this.JTAObDigital.getText() + "',   `SucLabial` = '" + this.JCBSucLabial.getSelectedItem() + "',   `ObsSucLabial` = '" + this.JTAObLabial.getText() + "',   `DegAtipica` = '" + this.JCBDeglAtipica.getSelectedItem() + "',   `ObsDegAtipica` = '" + this.JTAObAtipica.getText() + "',   `Onicofagia` = '" + this.JCBOnicofagia.getSelectedItem() + "',   `ObsOnicofagia` = '" + this.JTAObOnicofagia.getText() + "',   `Bruxismo` = '" + this.JCBBruxismo.getSelectedItem() + "',   `ObsBruxismo` = '" + this.JTABruxismo.getText() + "',   `AltFonacion` = '" + this.JCBAltFonacion.getSelectedItem() + "',   `ObsAltFonacion` = '" + this.JTAAltFonacion.getText() + "',   `DesDerecha` = '" + this.JCBDesDerecha.getSelectedItem() + "',   `DesIzquierda` = '" + this.JCBDesIzqueirda.getSelectedItem() + "',   `GuiaAnterior` = '" + this.JCBGuiAnt.getSelectedItem() + "',   `DesvMand` = '" + this.JCBDesvMand.getSelectedItem() + "',   `ObsDesvMand` = '" + this.JTADesvMandi.getText() + "',   `DefleMand` = '" + this.JCBDeflexMand.getSelectedItem() + "',   `ObsDefleMand` = '" + this.JTADeflexMand.getText() + "',   `AperMaxima` = '" + this.JCBApertMaxima.getSelectedItem() + "',   `ValAperMax` = '" + this.JFTFMMApertMaxima.getValue() + "',   `NormalDer` = '" + this.JCBNormSi.getSelectedItem() + "',   `NormalEstDer` = '" + this.JCBNormEstado.getSelectedItem() + "',   `NormalIzq` = '" + this.JCBNormSiIzq.getSelectedItem() + "',   `NormalEstIzq` = '" + this.JCBNormEstadoIzq.getSelectedItem() + "',   `RuidoDer` = '" + this.JCBRuidoSi.getSelectedItem() + "',   `RuidoEstDer` = '" + this.JCBRuidoEstado.getSelectedItem() + "',   `RuidoIzq` = '" + this.JCBRuidoSiIzq.getSelectedItem() + "',   `RuidoEstIzq` = '" + this.JCBRuidoEstadoIzq.getSelectedItem() + "',   `CrepitacionDer` = '" + this.JCBCrepSi.getSelectedItem() + "',   `CrepitacionEstDer` = '" + this.JCBCrepEstado.getSelectedItem() + "',   `CrepitacionIzq` = '" + this.JCBCrepSiIzq.getSelectedItem() + "',   `CrepitacionEstIzq` = '" + this.JCBCrepEstadoIzq.getSelectedItem() + "',   `ArtrosisDer` = '" + this.JCBArtrSi.getSelectedItem() + "',   `ArtrosisEstDer` = '" + this.JCBArtrEstado.getSelectedItem() + "',   `ArtrosisIzq` = '" + this.JCBArtrSiIzq.getSelectedItem() + "',   `ArtrosisEstIzq` = '" + this.JCBArtrEstadoIzq.getSelectedItem() + "',   `ArtritisDer` = '" + this.JCBArtritSi.getSelectedItem() + "',   `ArtritisEstDer` = '" + this.JCBArtitEstado.getSelectedItem() + "',   `ArtritisIzq` = '" + this.JCBArtritSiIzq.getSelectedItem() + "',   `ArtritisEstIzq` = '" + this.JCBArtritEstadoIzq.getSelectedItem() + "',   `DolorDer` = '" + this.JCBDolorSi.getSelectedItem() + "',   `DolorEstDer` = '" + this.JCBDolorEstado.getSelectedItem() + "',   `DolorIzq` = '" + this.JCBDolorSiIzq.getSelectedItem() + "',   `DolorEstIzq` = '" + this.JCBDolorEstadoIzq.getSelectedItem() + "',   `SubluxacionDer` = '" + this.JCBSubluxSi.getSelectedItem() + "',   `SubluxacionEstDer` = '" + this.JCBSubluxEstado.getSelectedItem() + "',   `SubluxacionIzq` = '" + this.JCBSubluxSiIzq.getSelectedItem() + "',   `SubluxacionEstIzq` = '" + this.JCBSubluxEstadoIzq.getSelectedItem() + "',   `BrincosDer` = '" + this.JCBBrincos.getSelectedItem() + "',   `BrincosEstDer` = '" + this.JCBBrincoEstado.getSelectedItem() + "',   `BrincosIzq` = '" + this.JCBBrincoSiIzq.getSelectedItem() + "',   `BrincosEstIzq` = '" + this.JCBBrincoEstadoIzq.getSelectedItem() + "',   `EspLInter` = '" + this.JFTFMMEspacioLibreInterO.getValue() + "',   `ContPrema` = '" + this.JCBContPrematuro.getSelectedItem() + "',   `ObsContPrema` = '" + this.JTAObsContaPrematuro.getText() + "',   `Obsgeneral` = '" + this.JTAObservacionesGen.getText() + "',   `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + this.xAnaFuncional + "'";
                this.xconsulta.ejecutarSQL(sql2);
            }
            this.xconsulta.cerrarConexionBd();
            mBuscarHistorico();
        }
    }

    private void mVerificaAnalisisAtencion() {
        String sql = "SELECT `Id`  , `IdAtencion` FROM `o_analisis_funcional` WHERE (`IdUsuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                mBuscarDatosBD(xrs.getInt("Id"));
                this.xAnaFuncional = xrs.getString("Id");
                this.JTPDatos.setSelectedIndex(0);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosBD(int xid) {
        String sql = "SELECT `AlterMuscular`,  `Habitos`,  `ObsHabitos`,  `Respiracion`, `ObsRespiracion`, `Masticacion`, `ObsMasticacion`,  `UsoProlo`, `ObsUsoProlo`, `SucObjeto`, `ObsSucObj`,  `SucDigital`, `ObsSucDigital`, `SucLabial`, `ObsSucLabial`,  `DegAtipica`, `ObsDegAtipica`, `Onicofagia`, `ObsOnicofagia`, `Bruxismo`, `ObsBruxismo`, `AltFonacion`, `ObsAltFonacion`,  `DesDerecha`, `DesIzquierda`, `GuiaAnterior`, `DesvMand`, `ObsDesvMand`,  `DefleMand`, `ObsDefleMand`,  `AperMaxima`,  `ValAperMax`, `NormalDer`, `NormalEstDer`, `NormalIzq`, `NormalEstIzq`, `RuidoDer`, `RuidoEstDer`, `RuidoIzq`,  `RuidoEstIzq`, `CrepitacionDer`, `CrepitacionEstDer`, `CrepitacionIzq`, `CrepitacionEstIzq`,  `ArtrosisDer`,  `ArtrosisEstDer`, `ArtrosisIzq`,  `ArtrosisEstIzq`, `ArtritisDer`, `ArtritisEstDer`, `ArtritisIzq`, `ArtritisEstIzq`,  `DolorDer`, `DolorEstDer`,  `DolorIzq`, `DolorEstIzq`, `SubluxacionDer`, `SubluxacionEstDer`, `SubluxacionIzq`,  `SubluxacionEstIzq`, `BrincosDer`, `BrincosEstDer`,  `BrincosIzq`, `BrincosEstIzq`, `EspLInter`, `ContPrema`, `ObsContPrema`,  `Obsgeneral`  FROM `o_analisis_funcional` WHERE Id='" + xid + "' ";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTAObservacionesGen.setText(xrs.getString("Obsgeneral"));
                this.JTAObsContaPrematuro.setText(xrs.getString("ObsContPrema"));
                this.JCBContPrematuro.setSelectedItem(xrs.getString("ContPrema"));
                this.JFTFMMEspacioLibreInterO.setValue(Double.valueOf(xrs.getDouble("EspLInter")));
                this.JCBBrincoEstadoIzq.setSelectedItem(xrs.getString("BrincosEstIzq"));
                this.JCBBrincoSiIzq.setSelectedItem(xrs.getString("BrincosIzq"));
                this.JCBBrincoEstado.setSelectedItem(xrs.getString("BrincosEstDer"));
                this.JCBBrincos.setSelectedItem(xrs.getString("BrincosDer"));
                this.JCBSubluxEstadoIzq.setSelectedItem(xrs.getString("SubluxacionEstIzq"));
                this.JCBSubluxSiIzq.setSelectedItem(xrs.getString("SubluxacionIzq"));
                this.JCBSubluxEstado.setSelectedItem(xrs.getString("SubluxacionEstDer"));
                this.JCBSubluxSi.setSelectedItem(xrs.getString("SubluxacionDer"));
                this.JCBDolorEstadoIzq.setSelectedItem(xrs.getString("DolorEstIzq"));
                this.JCBDolorSiIzq.setSelectedItem(xrs.getString("DolorIzq"));
                this.JCBDolorEstado.setSelectedItem(xrs.getString("DolorEstDer"));
                this.JCBDolorSi.setSelectedItem(xrs.getString("DolorDer"));
                this.JCBArtritEstadoIzq.setSelectedItem(xrs.getString("ArtritisEstIzq"));
                this.JCBArtritSiIzq.setSelectedItem(xrs.getString("ArtritisIzq"));
                this.JCBArtitEstado.setSelectedItem(xrs.getString("ArtritisEstDer"));
                this.JCBArtritSi.setSelectedItem(xrs.getString("ArtritisDer"));
                this.JCBArtrEstadoIzq.setSelectedItem(xrs.getString("ArtrosisEstIzq"));
                this.JCBArtrSiIzq.setSelectedItem(xrs.getString("ArtrosisIzq"));
                this.JCBArtrEstado.setSelectedItem(xrs.getString("ArtrosisEstDer"));
                this.JCBArtrSi.setSelectedItem(xrs.getString("ArtrosisDer"));
                this.JCBCrepEstadoIzq.setSelectedItem(xrs.getString("CrepitacionEstIzq"));
                this.JCBCrepSiIzq.setSelectedItem(xrs.getString("CrepitacionIzq"));
                this.JCBCrepEstado.setSelectedItem(xrs.getString("CrepitacionEstDer"));
                this.JCBCrepSi.setSelectedItem(xrs.getString("CrepitacionDer"));
                this.JCBRuidoEstadoIzq.setSelectedItem(xrs.getString("RuidoEstIzq"));
                this.JCBRuidoSiIzq.setSelectedItem(xrs.getString("RuidoIzq"));
                this.JCBRuidoEstado.setSelectedItem(xrs.getString("RuidoEstDer"));
                this.JCBRuidoSi.setSelectedItem(xrs.getString("RuidoDer"));
                this.JCBNormEstadoIzq.setSelectedItem(xrs.getString("NormalEstIzq"));
                this.JCBNormSiIzq.setSelectedItem(xrs.getString("NormalIzq"));
                this.JCBNormEstado.setSelectedItem(xrs.getString("NormalEstDer"));
                this.JCBNormSi.setSelectedItem(xrs.getString("NormalDer"));
                this.JFTFMMApertMaxima.setValue(Double.valueOf(xrs.getDouble("ValAperMax")));
                this.JCBApertMaxima.setSelectedItem(xrs.getString("AperMaxima"));
                this.JTADeflexMand.setText(xrs.getString("ObsDefleMand"));
                this.JCBDeflexMand.setSelectedItem(xrs.getString("DefleMand"));
                this.JTADesvMandi.setText(xrs.getString("ObsDesvMand"));
                this.JCBDesvMand.setSelectedItem(xrs.getString("DesvMand"));
                this.JCBGuiAnt.setSelectedItem(xrs.getString("GuiaAnterior"));
                this.JCBDesIzqueirda.setSelectedItem(xrs.getString("DesIzquierda"));
                this.JCBDesDerecha.setSelectedItem(xrs.getString("DesDerecha"));
                this.JTAAltFonacion.setText(xrs.getString("ObsAltFonacion"));
                this.JCBAltFonacion.setSelectedItem(xrs.getString("AltFonacion"));
                this.JTABruxismo.setText(xrs.getString("ObsBruxismo"));
                this.JCBBruxismo.setSelectedItem(xrs.getString("Bruxismo"));
                this.JTAObOnicofagia.setText(xrs.getString("ObsOnicofagia"));
                this.JCBOnicofagia.setSelectedItem(xrs.getString("Onicofagia"));
                this.JTAObAtipica.setText(xrs.getString("ObsDegAtipica"));
                this.JCBDeglAtipica.setSelectedItem(xrs.getString("DegAtipica"));
                this.JTAObLabial.setText(xrs.getString("ObsSucLabial"));
                this.JCBSucLabial.setSelectedItem(xrs.getString("SucLabial"));
                this.JTAObDigital.setText(xrs.getString("ObsSucDigital"));
                this.JCBSucDigital.setSelectedItem(xrs.getString("SucDigital"));
                this.JTAObObjetos.setText(xrs.getString("ObsSucObj"));
                this.JCBSucObjetos.setSelectedItem(xrs.getString("SucObjeto"));
                this.JTAObBiberon.setText(xrs.getString("ObsUsoProlo"));
                this.JCBBiberon.setSelectedItem(xrs.getString("UsoProlo"));
                this.JTAObsMasticacion.setText(xrs.getString("ObsMasticacion"));
                this.JCBMasticacion.setSelectedItem(xrs.getString("Masticacion"));
                this.JTAObsRespiracion.setText(xrs.getString("ObsRespiracion"));
                this.JCBRespiracion.setSelectedItem(xrs.getString("Respiracion"));
                this.JTFCualesHabi.setText(xrs.getString("ObsHabitos"));
                this.JCBHabitos.setSelectedItem(xrs.getString("Habitos"));
                this.JTAAlteraciones.setText(xrs.getString("AlterMuscular"));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Fecha", "Profesional", "Especialidad", "IdTrata"}) { // from class: Odontologia.JPAnalisisFuncional.48
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo2);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mBuscarHistorico() {
        mCrearModeloHistorico();
        String sql = "SELECT `o_analisis_funcional`.`Id` , `o_analisis_funcional`.`IdAtencion` , DATE_FORMAT(o_analisis_funcional.`Fecha`,'%d-%m-%Y') AS Fecha, `profesional1`.`NProfesional` , `profesional1`.`Especialidad`, o_analisis_funcional.IdTratamiento  FROM `o_analisis_funcional`  INNER JOIN  `profesional1`   ON (`o_analisis_funcional`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`o_analisis_funcional`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`o_analisis_funcional`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo2.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo2.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarPanelOdontogramaDientes() {
        this.xJPOdontogramaDientes = new JPOdontogramaDientes();
        add(this.xJPOdontogramaDientes);
        this.xJPOdontogramaDientes.setVisible(false);
        this.xJPOdontogramaDientes.setBounds(1, 1, 699, 340);
    }

    private void mImprimir() {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString();
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mparametros[2][0] = "id_tratamiento";
        mparametros[2][1] = this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.mTraerDatosDienteDxOdontInicial(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        this.xmt.mTraerDatosDienteProcOdontInicial(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        this.xmt.traerImagenOdontograma();
        this.xmt.mTraerDatosDienteDxTratamiento(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
        this.xmt.traerImagenOdontogramaDx();
        this.xmt.mTraerDatosDienteProcTratamiento(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
        this.xmt.traerImagenOdontogramaProc();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaOdontologia", mparametros);
    }
}
