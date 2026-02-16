package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFDemandaIndusida.class */
public class JIFDemandaIndusida extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidprograma;
    private String[] xidprocedimiento;
    private String[] xidtipoprocedimiento;
    private String[] xidTEdadI;
    private String[] xidTEdadF;
    private int xtipor;
    private ButtonGroup JBGSexo;
    private ButtonGroup JBGTipoDato;
    private ButtonGroup JBGTipoEdad;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBPrograma;
    private JComboBox JCBTipoEdadF;
    private JComboBox JCBTipoEdadI;
    private JComboBox JCBTipoProcedimiento;
    private JCheckBox JCHEstado;
    private JCheckBox JChUnica;
    private JPanel JPTipoDato;
    private JRadioButton JRBFemenino;
    private JRadioButton JRBMasculino;
    private JRadioButton JRBNumerico;
    private JRadioButton JRBTexto;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFEdadF;
    private JFormattedTextField JTFFEdadI;
    private JFormattedTextField JTFFMeta;
    public JTextField JTFFNVariable;
    public JTextField JTFFNombre;
    private JFormattedTextField JTFFPeriodicidad;
    private JFormattedTextField JTFFPoblacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private String xsexo = "M";
    private boolean xestadog = false;
    private int xUnica = 0;

    public JIFDemandaIndusida(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSexo = new ButtonGroup();
        this.JBGTipoEdad = new ButtonGroup();
        this.JBGTipoDato = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JRBMasculino = new JRadioButton();
        this.JRBFemenino = new JRadioButton();
        this.JTFFEdadI = new JFormattedTextField();
        this.JTFFEdadF = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBPrograma = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JTFFPeriodicidad = new JFormattedTextField();
        this.JTFFMeta = new JFormattedTextField();
        this.JCBTipoProcedimiento = new JComboBox();
        this.JTFFPoblacion = new JFormattedTextField();
        this.JTFFNVariable = new JTextField();
        this.JTFFNombre = new JTextField();
        this.JChUnica = new JCheckBox();
        this.JCBTipoEdadI = new JComboBox();
        this.JCBTipoEdadF = new JComboBox();
        this.JPTipoDato = new JPanel();
        this.JRBNumerico = new JRadioButton();
        this.JRBTexto = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("DEMANDA INDUCIDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifdemandaind");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFDemandaIndusida.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFDemandaIndusida.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setMaximumSize((Dimension) null);
        this.JSPDetalle.setMinimumSize((Dimension) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFDemandaIndusida.2
            public void mouseClicked(MouseEvent evt) {
                JIFDemandaIndusida.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGSexo.add(this.JRBMasculino);
        this.JRBMasculino.setFont(new Font("Arial", 1, 12));
        this.JRBMasculino.setText("Masculino");
        this.JRBMasculino.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.3
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JRBMasculinoActionPerformed(evt);
            }
        });
        this.JBGSexo.add(this.JRBFemenino);
        this.JRBFemenino.setFont(new Font("Arial", 1, 12));
        this.JRBFemenino.setText("Femenino");
        this.JRBFemenino.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.4
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JRBFemeninoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBMasculino).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JRBFemenino).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMasculino).addComponent(this.JRBFemenino)));
        this.JTFFEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Inicial", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEdadI.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFEdadI.setHorizontalAlignment(4);
        this.JTFFEdadI.setFont(new Font("Arial", 1, 12));
        this.JTFFEdadI.setValue(new Integer(0));
        this.JTFFEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Final", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEdadF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFEdadF.setHorizontalAlignment(4);
        this.JTFFEdadF.setFont(new Font("Arial", 1, 12));
        this.JTFFEdadF.setValue(new Integer(0));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.5
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrograma.setMaximumSize((Dimension) null);
        this.JCBPrograma.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFDemandaIndusida.6
            public void itemStateChanged(ItemEvent evt) {
                JIFDemandaIndusida.this.JCBProgramaItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.setMaximumSize((Dimension) null);
        this.JTFFPeriodicidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Peridiocidad (Días)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPeriodicidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPeriodicidad.setHorizontalAlignment(4);
        this.JTFFPeriodicidad.setFont(new Font("Arial", 1, 12));
        this.JTFFPeriodicidad.setValue(new Integer(0));
        this.JTFFMeta.setBorder(BorderFactory.createTitledBorder((Border) null, "Meta(%)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFMeta.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFMeta.setHorizontalAlignment(4);
        this.JTFFMeta.setFont(new Font("Arial", 1, 12));
        this.JTFFMeta.setValue(new Integer(0));
        this.JCBTipoProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProcedimiento.setMaximumSize((Dimension) null);
        this.JCBTipoProcedimiento.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFDemandaIndusida.7
            public void itemStateChanged(ItemEvent evt) {
                JIFDemandaIndusida.this.JCBTipoProcedimientoItemStateChanged(evt);
            }
        });
        this.JTFFPoblacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Población", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPoblacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPoblacion.setHorizontalAlignment(4);
        this.JTFFPoblacion.setFont(new Font("Arial", 1, 12));
        this.JTFFPoblacion.setValue(new Integer(0));
        this.JTFFNVariable.setFont(new Font("Arial", 1, 12));
        this.JTFFNVariable.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Variable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Variable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JChUnica.setFont(new Font("Arial", 1, 12));
        this.JChUnica.setText("Única?");
        this.JChUnica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.8
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JChUnicaActionPerformed(evt);
            }
        });
        this.JCBTipoEdadI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEdadI.setMaximumSize((Dimension) null);
        this.JCBTipoEdadI.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFDemandaIndusida.9
            public void itemStateChanged(ItemEvent evt) {
                JIFDemandaIndusida.this.JCBTipoEdadIItemStateChanged(evt);
            }
        });
        this.JCBTipoEdadF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEdadF.setMaximumSize((Dimension) null);
        this.JCBTipoEdadF.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFDemandaIndusida.10
            public void itemStateChanged(ItemEvent evt) {
                JIFDemandaIndusida.this.JCBTipoEdadFItemStateChanged(evt);
            }
        });
        this.JPTipoDato.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Resultado", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoDato.add(this.JRBNumerico);
        this.JRBNumerico.setFont(new Font("Arial", 1, 12));
        this.JRBNumerico.setText("Numerico");
        this.JRBNumerico.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.11
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JRBNumericoActionPerformed(evt);
            }
        });
        this.JBGTipoDato.add(this.JRBTexto);
        this.JRBTexto.setFont(new Font("Arial", 1, 12));
        this.JRBTexto.setText("Texto");
        this.JRBTexto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFDemandaIndusida.12
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaIndusida.this.JRBTextoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoDatoLayout = new GroupLayout(this.JPTipoDato);
        this.JPTipoDato.setLayout(JPTipoDatoLayout);
        JPTipoDatoLayout.setHorizontalGroup(JPTipoDatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDatoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNumerico).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767).addComponent(this.JRBTexto).addContainerGap()));
        JPTipoDatoLayout.setVerticalGroup(JPTipoDatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDatoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNumerico).addComponent(this.JRBTexto)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFNombre).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFFPeriodicidad, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFMeta, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPoblacion, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNVariable, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JChUnica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoDato, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBPrograma, 0, -1, 32767).addComponent(this.JCBProcedimiento, 0, 537, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFFEdadI, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEdadI, -2, 57, -2).addGap(18, 18, 18).addComponent(this.JTFFEdadF, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEdadF, -2, 57, -2).addGap(18, 18, 18).addComponent(this.JCHEstado)).addComponent(this.JCBTipoProcedimiento, -2, 420, -2)))).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFFNombre, -2, -1, -2).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPrograma, -2, -1, -2).addComponent(this.JCBTipoProcedimiento, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcedimiento, -2, -1, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEdadI, -2, -1, -2).addComponent(this.JTFFEdadF).addComponent(this.JCBTipoEdadI, -2, -1, -2).addComponent(this.JCBTipoEdadF, -2, -1, -2).addComponent(this.JCHEstado))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFPeriodicidad).addComponent(this.JTFFMeta).addComponent(this.JTFFPoblacion).addComponent(this.JTFFNVariable, -2, -1, -2)).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -2, -1, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoDato, -2, -1, -2)))).addGroup(jPanel2Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.JChUnica))).addGap(3, 3, 3)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 278, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBPrograma.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBTipoProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFFEdadI.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())));
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("")) {
                this.JCBTipoEdadI.setSelectedIndex(-1);
            } else {
                this.JCBTipoEdadI.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            }
            this.JTFFEdadF.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString())));
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString().equals("")) {
                this.JCBTipoEdadF.setSelectedIndex(-1);
            } else {
                this.JCBTipoEdadF.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            }
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString().equals("MASCULINO")) {
                this.JRBMasculino.setSelected(true);
            } else {
                this.JRBFemenino.setSelected(true);
            }
            this.JTFFPeriodicidad.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString())));
            this.JTFFMeta.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString())));
            this.JTFFPoblacion.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString())));
            this.JTFFNVariable.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JChUnica.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).booleanValue());
            if (this.JChUnica.isSelected()) {
                this.xUnica = 1;
            } else {
                this.xUnica = 0;
            }
            if ("NUMERICO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString())) {
                this.JRBNumerico.setSelected(true);
                this.xtipor = 0;
            } else {
                this.JRBTexto.setSelected(true);
                this.xtipor = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMasculinoActionPerformed(ActionEvent evt) {
        this.xsexo = "M";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFemeninoActionPerformed(ActionEvent evt) {
        this.xsexo = "F";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.xestadog && this.JCBTipoProcedimiento.getSelectedIndex() != -1) {
            this.JCBProcedimiento.removeAllItems();
            this.xidprocedimiento = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `g_procedimiento` WHERE (`Id_tipoprocedimiento` ='" + this.xidtipoprocedimiento[this.JCBTipoProcedimiento.getSelectedIndex()] + "' AND Estado=0) ORDER BY Nbre ASC", this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProgramaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JChUnicaActionPerformed(ActionEvent evt) {
        if (this.JChUnica.isSelected()) {
            this.xUnica = 1;
        } else {
            this.xUnica = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEdadIItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEdadFItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNumericoActionPerformed(ActionEvent evt) {
        this.xtipor = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTextoActionPerformed(ActionEvent evt) {
        this.xtipor = 1;
    }

    public void mNuevo() {
        this.xestadog = false;
        Principal.txtNo.setText("");
        this.JTFFNombre.setText("");
        this.JCBPrograma.setSelectedIndex(-1);
        this.JCBTipoProcedimiento.setSelectedIndex(-1);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JCBPrograma.requestFocus();
        this.JTFFEdadI.setValue(0);
        this.JTFFEdadF.setValue(0);
        this.JTFFPeriodicidad.setValue(0);
        this.JTFFMeta.setValue(0);
        this.JTFFPoblacion.setValue(0);
        this.JTFFNVariable.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JRBMasculino.setSelected(true);
        this.JRBNumerico.setSelected(true);
        this.xtipor = 0;
        this.xsexo = "M";
        this.xUnica = 0;
        this.JChUnica.setSelected(false);
        this.JCBTipoEdadF.setSelectedIndex(-1);
        this.JCBTipoEdadI.setSelectedIndex(-1);
        this.xestadog = true;
    }

    public void mGrabar() {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBTipoEdadI.getSelectedIndex() != -1) {
                    if (this.JCBTipoEdadF.getSelectedIndex() != -1) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            if (Principal.txtNo.getText().isEmpty()) {
                                String sql = " Insert into p_demanda_inducida(Nbre,`Id_Programa`, `Id_Procedimiento`, `EdadI`, `EdadF`, `Id_Sexo`,Peridiocidad, Meta,Poblacion,NVariable,Unica, TEdadI, TEdadF, TipoDatoR,`Estado` , `Fecha`, `UsuarioS`)  values ('" + this.JTFFNombre.getText().toUpperCase() + "','" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "','" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.JTFFEdadI.getValue() + "','" + this.JTFFEdadF.getValue() + "','" + this.xsexo + "','" + this.JTFFPeriodicidad.getValue() + "','" + this.JTFFMeta.getValue() + "','" + this.JTFFPoblacion.getValue() + "','" + this.JTFFNVariable.getText().toUpperCase() + "','" + this.xUnica + "','" + this.JCBTipoEdadI.getSelectedItem() + "','" + this.JCBTipoEdadF.getSelectedItem() + "','" + this.xtipor + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsulta.ejecutarSQL(sql);
                                this.xconsulta.cerrarConexionBd();
                                mCargarDatosTabla();
                                mNuevo();
                                return;
                            }
                            String sql2 = " update p_demanda_inducida set Nbre='" + this.JTFFNombre.getText().toUpperCase() + "', Id_Programa='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "', Id_Procedimiento='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "' ,EdadI='" + this.JTFFEdadI.getValue() + "',EdadF='" + this.JTFFEdadF.getValue() + "', Id_Sexo='" + this.xsexo + "', Peridiocidad='" + this.JTFFPeriodicidad.getValue() + "', Meta='" + this.JTFFMeta.getValue() + "', Poblacion='" + this.JTFFPoblacion.getValue() + "', NVariable='" + this.JTFFNVariable.getText().toUpperCase() + "', Estado='" + this.xestado + "' ,Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' ,Unica='" + this.xUnica + "', TEdadI='" + this.JCBTipoEdadI.getSelectedItem() + "', TEdadF='" + this.JCBTipoEdadF.getSelectedItem() + "', TipoDatoR='" + this.xtipor + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' ";
                            this.xconsulta.ejecutarSQL(sql2);
                            this.xconsulta.cerrarConexionBd();
                            mCargarDatosTabla();
                            mNuevo();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de edad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoEdadF.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de edad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoEdadI.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar Procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPrograma.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFDemandaIndusida.13
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, Long.class, String.class, String.class, Long.class, Long.class, Long.class, String.class, Boolean.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(2);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Nombre", "Tipo Programa", "Procedimiento", "Edad Inicial", "TipoE", "Edad Final", "TipoE", "Sexo", "Peridiocidad", "Meta(%)", "Población", "NVariable", "Estado", "TP", "única?", "TipoR"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `p_demanda_inducida`.`Id` , p_demanda_inducida.Nbre, `g_tipoprograma`.`Nbre`, `g_procedimiento`.`Nbre` , `p_demanda_inducida`.`EdadI`, `p_demanda_inducida`.`EdadF`, `g_sexo`.`Nbre`,`p_demanda_inducida`.`Peridiocidad`,`p_demanda_inducida`.`Meta`,`p_demanda_inducida`.`Poblacion`,NVariable,`p_demanda_inducida`.`Estado`, `f_tipoprocedimiento`.`Nbre`, p_demanda_inducida.Unica , p_demanda_inducida.TEdadI, p_demanda_inducida.TEdadF, IF(p_demanda_inducida.TipoDatoR=0,'NUMERICO','TEXTO') AS TipoDatoR \nFROM `p_demanda_inducida` INNER JOIN `g_sexo` ON (`p_demanda_inducida`.`Id_Sexo` = `g_sexo`.`Id`)\nINNER JOIN `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN `f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\nINNER JOIN `g_tipoprograma` ON (`p_demanda_inducida`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) ORDER BY `g_tipoprograma`.`Nbre`,`g_procedimiento`.`Nbre`, `p_demanda_inducida`.`EdadI`\n");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("TEdadI"), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("TEdadF"), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 8);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDemandaIndusida.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.JCBPrograma.removeAllItems();
        this.xidprograma = this.xconsulta.llenarCombo("SELECT `Id_TipoPrograma` , `Nbre` FROM `g_tipoprograma` WHERE (`Estado` =0) ORDER BY Nbre ASC", this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipoProcedimiento.removeAllItems();
        this.xidtipoprocedimiento = this.xconsulta.llenarCombo("SELECT `f_tipoprocedimiento`.`Id`, `f_tipoprocedimiento`.`Nbre` FROM `g_procedimiento` INNER JOIN `baseserver`.`f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) WHERE (`f_tipoprocedimiento`.`Estado` =0) GROUP BY `f_tipoprocedimiento`.`Nbre` ORDER BY `f_tipoprocedimiento`.`Nbre`", this.xidtipoprocedimiento, this.JCBTipoProcedimiento);
        this.JCBTipoProcedimiento.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipoEdadI.removeAllItems();
        this.xidTEdadI = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoedad` WHERE (`Estado` =0);", this.xidTEdadI, this.JCBTipoEdadI);
        this.JCBTipoEdadI.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipoEdadF.removeAllItems();
        this.xidTEdadF = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoedad` WHERE (`Estado` =0);", this.xidTEdadF, this.JCBTipoEdadF);
        this.JCBTipoEdadF.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xestadog = true;
    }
}
