package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Espirometria.class */
public class JPSo_Espirometria extends JPanel {
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private String[] xidResultado;
    private File xfile;
    private JButton JBGrabaInterp;
    private JButton JBTActualizar;
    private JButton JBTVisualizar;
    private JComboBox JCBClasificacion;
    private JComboBox JCBResultado;
    private JPanel JPInterpretacion;
    private JSpinner JSPFVCM;
    private JSpinner JSPFVCP;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObserE;
    private JScrollPane JSPObservacion;
    private JSpinner JSPVEF1M;
    private JSpinner JSPVEF1P;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionEspiro;
    public JTable JTDetalleHistorico;
    private JFormattedTextField JTFFDFVC;
    private JFormattedTextField JTFFDVEF1;
    private JFormattedTextField JTFFITift;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xid = "0";
    private String xidEspirometria = "0";

    public JPSo_Espirometria() {
        initComponents();
        this.xidResultado = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=1) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        mCargarDatos();
        mCargarDatosTabla();
    }

    private void mCalcular() {
        if (Double.valueOf(this.JSPVEF1M.getValue().toString()).doubleValue() != 0.0d && Double.valueOf(this.JSPFVCM.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFFITift.setValue(Double.valueOf((Double.valueOf(this.JSPVEF1M.getValue().toString()).doubleValue() * 100.0d) / Double.valueOf(this.JSPFVCM.getValue().toString()).doubleValue()));
        }
        if (Double.valueOf(this.JSPVEF1M.getValue().toString()).doubleValue() != 0.0d && Double.valueOf(this.JSPVEF1P.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFFDVEF1.setValue(Double.valueOf((Double.valueOf(this.JSPVEF1M.getValue().toString()).doubleValue() * 100.0d) / Double.valueOf(this.JSPVEF1P.getValue().toString()).doubleValue()));
        }
        if (Double.valueOf(this.JSPFVCM.getValue().toString()).doubleValue() != 0.0d && Double.valueOf(this.JSPFVCP.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFFDFVC.setValue(Double.valueOf((Double.valueOf(this.JSPFVCM.getValue().toString()).doubleValue() * 100.0d) / Double.valueOf(this.JSPFVCP.getValue().toString()).doubleValue()));
        }
    }

    /* JADX WARN: Type inference failed for: r3v83, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JSPFVCP = new JSpinner();
        this.JSPFVCM = new JSpinner();
        this.JSPVEF1P = new JSpinner();
        this.JSPVEF1M = new JSpinner();
        this.JCBClasificacion = new JComboBox();
        this.JTFFITift = new JFormattedTextField();
        this.JTFFDVEF1 = new JFormattedTextField();
        this.JTFFDFVC = new JFormattedTextField();
        this.JBTActualizar = new JButton();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacionEspiro = new JTextArea();
        this.JTFRuta = new JTextField();
        this.JBTVisualizar = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JPInterpretacion = new JPanel();
        this.JCBResultado = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGrabaInterp = new JButton();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "ESPIROMETRÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjifespirometria");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPFVCP.setFont(new Font("Arial", 1, 12));
        this.JSPFVCP.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFVCP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FVC Prevista", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFVCP.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Espirometria.1
            public void stateChanged(ChangeEvent evt) {
                JPSo_Espirometria.this.JSPFVCPStateChanged(evt);
            }
        });
        this.JSPFVCM.setFont(new Font("Arial", 1, 12));
        this.JSPFVCM.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFVCM.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FVC Medida", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFVCM.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Espirometria.2
            public void stateChanged(ChangeEvent evt) {
                JPSo_Espirometria.this.JSPFVCMStateChanged(evt);
            }
        });
        this.JSPVEF1P.setFont(new Font("Arial", 1, 12));
        this.JSPVEF1P.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPVEF1P.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "VEF1 Previsto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPVEF1P.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Espirometria.3
            public void stateChanged(ChangeEvent evt) {
                JPSo_Espirometria.this.JSPVEF1PStateChanged(evt);
            }
        });
        this.JSPVEF1M.setFont(new Font("Arial", 1, 12));
        this.JSPVEF1M.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPVEF1M.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "VEF1 Medido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPVEF1M.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Espirometria.4
            public void stateChanged(ChangeEvent evt) {
                JPSo_Espirometria.this.JSPVEF1MStateChanged(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "MIXTO", "OBSTRUCTIVO", "RESTRICTIVO"}));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Clasificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFITift.setEditable(false);
        this.JTFFITift.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Indice Tiftenau", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFITift.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFITift.setHorizontalAlignment(4);
        this.JTFFITift.setFocusable(false);
        this.JTFFITift.setFont(new Font("Arial", 1, 12));
        this.JTFFDVEF1.setEditable(false);
        this.JTFFDVEF1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Desviación VEF1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDVEF1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFDVEF1.setHorizontalAlignment(4);
        this.JTFFDVEF1.setFocusable(false);
        this.JTFFDVEF1.setFont(new Font("Arial", 1, 12));
        this.JTFFDFVC.setEditable(false);
        this.JTFFDFVC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Desviación FVC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDFVC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFDFVC.setHorizontalAlignment(4);
        this.JTFFDFVC.setFocusable(false);
        this.JTFFDFVC.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizar.setText("Grabar");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Espirometria.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_Espirometria.this.JBTActualizarActionPerformed(evt);
            }
        });
        this.JTAObservacionEspiro.setColumns(1);
        this.JTAObservacionEspiro.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionEspiro.setLineWrap(true);
        this.JTAObservacionEspiro.setRows(1);
        this.JTAObservacionEspiro.setTabSize(1);
        this.JTAObservacionEspiro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacionEspiro);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Ruta de Archivo a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Espirometria.6
            public void mouseClicked(MouseEvent evt) {
                JPSo_Espirometria.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Espirometria.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_Espirometria.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTVisualizar.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/outline_visibility_black_18dp.png")));
        this.JBTVisualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Espirometria.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_Espirometria.this.JBTVisualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObserE).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPFVCP, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPFVCM, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPVEF1P, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPVEF1M, -2, 120, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFITift, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDVEF1, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDFVC, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTActualizar, -2, 203, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTVisualizar, -2, 40, -2))).addGap(12, 12, 12))).addGap(21, 21, 21)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFVCP, -2, 50, -2).addComponent(this.JSPFVCM, -2, 50, -2).addComponent(this.JSPVEF1P, -2, 50, -2).addComponent(this.JSPVEF1M, -2, 50, -2))).addComponent(this.JBTActualizar, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFITift, -2, 50, -2).addComponent(this.JTFFDVEF1, -2, 50, -2).addComponent(this.JTFFDFVC, -2, 50, -2).addComponent(this.JCBClasificacion))).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JBTVisualizar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, 32767)).addComponent(this.JTFRuta)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE, -2, 116, -2).addContainerGap()));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.setSelectionMode(0);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Espirometria.9
            public void mouseClicked(MouseEvent evt) {
                JPSo_Espirometria.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "INTERPRETACIÓN MEDICA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBGrabaInterp.setFont(new Font("Arial", 1, 12));
        this.JBGrabaInterp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaInterp.setText("Actualizar  Interpretación");
        this.JBGrabaInterp.addActionListener(new ActionListener() { // from class: Historia.JPSo_Espirometria.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_Espirometria.this.JBGrabaInterpActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBResultado, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion).addGap(18, 18, 18).addComponent(this.JBGrabaInterp).addContainerGap()));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addComponent(this.JCBResultado, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(JPInterpretacionLayout.createSequentialGroup().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBGrabaInterp, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPObservacion, GroupLayout.Alignment.LEADING, -1, 57, 32767)).addGap(0, 9, 32767)))));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInterpretacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPHistorico, GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPHistorico, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFVCPStateChanged(ChangeEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFVCMStateChanged(ChangeEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPVEF1PStateChanged(ChangeEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPVEF1MStateChanged(ChangeEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            this.xidEspirometria = this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        if (Double.valueOf(this.JSPFVCM.getValue().toString()).doubleValue() == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JSPFVCM.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPFVCP.getValue().toString()).doubleValue() == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JSPFVCM.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPVEF1M.getValue().toString()).doubleValue() == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JSPFVCM.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPVEF1P.getValue().toString()).doubleValue() != 0.0d) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xmt.esIPSMineros() || Principal.informacionIps.getIdentificacion().equals("901420803")) {
                    if ("0".equals(this.xidEspirometria) || this.xidEspirometria == null) {
                        this.xsql = "insert into h_so_espirometria (Id_Usuario, `Id_Atencion`, `Fecha_R`, `FVCP`, `FVCM`, `VEF1P`, `VEF1M`, `IndicT`, `DVEF1`, `DFVC`,ObservacionEspiro, `Id_Profesional`, `Id_Especialidad`,Resultado, Ruta,`UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JSPFVCP.getValue() + "','" + this.JSPFVCM.getValue() + "','" + this.JSPVEF1P.getValue() + "','" + this.JSPVEF1M.getValue() + "','" + this.JTFFITift.getValue() + "','" + this.JTFFDVEF1.getValue() + "','" + this.JTFFDFVC.getValue() + "','" + this.JTAObservacionEspiro.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JCBClasificacion.getSelectedItem() + "','" + this.JTFRuta.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("insert" + this.xsql);
                        this.xidEspirometria = this.xct.ejecutarSQLId(this.xsql);
                    } else {
                        this.xsql = "UPDATE\n\th_so_espirometria\nSET\n\tId_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', FVCP = '" + this.JSPFVCP.getValue() + "', FVCM = '" + this.JSPFVCM.getValue() + "', VEF1P = '" + this.JSPVEF1P.getValue() + "', VEF1M = '" + this.JSPVEF1M.getValue() + "', IndicT = '" + this.JTFFITift.getValue() + "', DVEF1 = '" + this.JTFFDVEF1.getValue() + "', DFVC = '" + this.JTFFDFVC.getValue() + "', ObservacionEspiro = '" + this.JTAObservacionEspiro.getText() + "', Id_Profesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', Resultado = '" + this.JCBClasificacion.getSelectedItem() + "', Ruta = '" + this.JTFRuta.getText() + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' \nWHERE \t\n\th_so_espirometria.`Id`='" + this.xidEspirometria + "'";
                        System.out.println("update" + this.xsql);
                        this.xct.ejecutarSQL(this.xsql);
                    }
                } else {
                    this.xsql = "insert into h_so_espirometria (Id_Usuario, `Id_Atencion`, `Fecha_R`, `FVCP`, `FVCM`, `VEF1P`, `VEF1M`, `IndicT`, `DVEF1`, `DFVC`,ObservacionEspiro, `Id_Profesional`, `Id_Especialidad`,Resultado, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JSPFVCP.getValue() + "','" + this.JSPFVCM.getValue() + "','" + this.JSPVEF1P.getValue() + "','" + this.JSPVEF1M.getValue() + "','" + this.JTFFITift.getValue() + "','" + this.JTFFDVEF1.getValue() + "','" + this.JTFFDFVC.getValue() + "','" + this.JTAObservacionEspiro.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JCBClasificacion.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xidEspirometria = this.xct.ejecutarSQLId(this.xsql);
                    this.JBTActualizar.setEnabled(false);
                }
                this.xct.cerrarConexionBd();
                Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                this.xid = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                mCargarDatosTabla();
                this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
                mImprimir();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JSPFVCM.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaInterpActionPerformed(ActionEvent evt) {
        this.xsql = "update h_so_espirometria set `ResultadoM`='" + this.JCBResultado.getSelectedItem() + "', `Observacion`='" + this.JTAObservacion.getText() + "', `Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' where Id='" + this.xidEspirometria + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
            Principal.clasehistoriace.mActualizarVariable_ManPower("REspirometria", this.JCBResultado.getSelectedItem().toString(), "Observacion_Esp", this.JTAObservacion.getText());
            if (!this.JCBResultado.getSelectedItem().equals("NORMAL")) {
                Principal.clasehistoriace.mActualizarAlterado_ManPower();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("Y:\\SoporteEspirometria\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizarActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getIdentificacion().equals("901420803") && !this.JTFRuta.getText().isEmpty()) {
            try {
                String ruta = this.JTFRuta.getText();
                File archivo = new File(ruta);
                Desktop.getDesktop().open(archivo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void mCargarDatos() {
        if (!Principal.informacionIps.getIdentificacion().equals("901420803")) {
            this.JTFRuta.setVisible(false);
            this.JTFRuta.setEnabled(false);
            this.JBTVisualizar.setEnabled(false);
            this.JBTVisualizar.setVisible(false);
        }
        try {
            this.xsql = "SELECT `FVCP`, `FVCM`, `VEF1P`, `VEF1M` , `IndicT` , `DVEF1` , `DFVC` , `Resultado` , `ResultadoM` , `h_so_espirometria`.`Observacion`, `h_so_espirometria`.Id, IF((`h_so_espirometria`.ResultadoM='NULO'|| `h_so_espirometria`.ResultadoM=''),0,1) AS Estado , ObservacionEspiro, `h_atencion`.`TipoGuardado`, IFNULL(h_so_espirometria.Ruta, '') ruta FROM `h_atencion` INNER JOIN `h_so_espirometria` ON (`h_atencion`.`Id` = `h_so_espirometria`.`Id_Atencion`) WHERE (`h_so_espirometria`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_espirometria`.`Estado` =1) ORDER BY `h_so_espirometria`.Id DESC";
            System.out.println(" Consulta" + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            this.xidEspirometria = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            if (xrs.next()) {
                xrs.first();
                this.JSPFVCP.setValue(Double.valueOf(xrs.getDouble(1)));
                this.JSPFVCM.setValue(Double.valueOf(xrs.getDouble(2)));
                this.JSPVEF1P.setValue(Double.valueOf(xrs.getDouble(3)));
                this.JSPVEF1M.setValue(Double.valueOf(xrs.getDouble(4)));
                this.JTFFITift.setValue(Double.valueOf(xrs.getDouble(5)));
                this.JTFFDVEF1.setValue(Double.valueOf(xrs.getDouble(6)));
                this.JTFFDFVC.setValue(Double.valueOf(xrs.getDouble(7)));
                this.JCBClasificacion.setSelectedItem(xrs.getString(8));
                this.JCBResultado.setSelectedItem(xrs.getString(9));
                this.JTAObservacion.setText(xrs.getString(10));
                this.xidEspirometria = xrs.getString(11);
                this.JTFRuta.setText(xrs.getString("ruta"));
                this.JBTActualizar.setEnabled(false);
                if (this.xmt.esIPSMineros() || Principal.informacionIps.getIdentificacion().equals("901420803")) {
                    if (xrs.getInt("TipoGuardado") != 0) {
                        this.JBTActualizar.setEnabled(false);
                        this.JBGrabaInterp.setEnabled(false);
                    } else {
                        this.JBTActualizar.setEnabled(true);
                        this.JBGrabaInterp.setEnabled(true);
                    }
                } else if (xrs.getInt(12) == 1) {
                    this.JBGrabaInterp.setEnabled(false);
                }
                this.JTAObservacionEspiro.setText(xrs.getString(13));
            } else {
                this.xidEspirometria = "0";
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Fecha", "FVCP", "FVCM", "VEF1P", "VEF1M", "IndiceT", "DVEF1", "DFVC", "Resultado", "Mes"}) { // from class: Historia.JPSo_Espirometria.11
            Class[] types = {String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalleHistorico.getColumnModel().getColumn(11).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT `Id`, `Id_Atencion`, DATE_FORMAT(`Fecha_R`,'%d-%m-%Y') AS Fecha, `FVCP`, `FVCM`, `VEF1P`, `VEF1M`, `IndicT`, `DVEF1`, `DFVC`, `Resultado`, DATE_FORMAT(`Fecha_R`,'%Y'), CONCAT(MID(DevuelveMes(`Fecha_R`),1, 1),'',LOWER(MID(DevuelveMes(`Fecha_R`),2, LENGTH(DevuelveMes(`Fecha_R`))))) AS Mes FROM  `h_so_espirometria` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Estado=1 ) ORDER BY `Fecha_R` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12) + "\\" + xrs.getString(13), x, 11);
                    x++;
                }
            } else {
                mCrearModeloHistorico();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdEspirometria";
        mparametros[0][1] = this.xidEspirometria;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            if (this.xmt.esIPSMineros()) {
                this.xmt.mostrarPdf(this.xmt.mRutaSoporte("xjifespirometria") + this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 11).toString() + this.xmt.getBarra() + this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 1).toString() + ".pdf");
                return;
            } else {
                this.xmt.mostrarPdf("S:\\Salud Ocupacional\\Espirometrias\\" + this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 11).toString() + "\\" + this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 1).toString() + ".pdf");
                return;
            }
        }
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Espirometria_1", mparametros);
    }
}
