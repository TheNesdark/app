package Salud_Ocupacional;

import Acceso.Principal;
import Historia.JIFHistoriaClinica;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JPTestFatiga.class */
public class JPTestFatiga extends JPanel {
    private JIFTest_Fatiga xjiftestf;
    private JIFHistoriaClinica xjifhc;
    private String xsql;
    public DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private JLabel JLBNRegistro;
    private JLabel JLBP1;
    private JLabel JLBP2;
    private JLabel JLBP3;
    private JLabel JLBRiesgo;
    private JPanel JPIHistorico;
    private JPanel JPITest;
    private JSlider JSLBarra;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JTable JTDetalleHistorico;
    private JFormattedTextField JTFFP1;
    private JFormattedTextField JTFFP2;
    private JFormattedTextField JTFFP3;
    private JFormattedTextField JTFFPTotal;
    private JTabbedPane JTPDatos;
    private boolean xllenado = false;
    private String xnombre = "";
    private String xidatencion = "0";
    private String xidpersona = "0";
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JPTestFatiga(JInternalFrame xjif) {
        initComponents();
        mNuevo();
        mHacerCasting(xjif);
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPITest = new JPanel();
        this.JLBP1 = new JLabel();
        this.JTFFP1 = new JFormattedTextField();
        this.JLBP2 = new JLabel();
        this.JTFFP2 = new JFormattedTextField();
        this.JLBP3 = new JLabel();
        this.JTFFP3 = new JFormattedTextField();
        this.JTFFPTotal = new JFormattedTextField();
        this.JLBRiesgo = new JLabel();
        this.JSLBarra = new JSlider();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLBNRegistro = new JLabel();
        this.JPIHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE LA PRUEBA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjptestfatiga");
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JLBP1.setFont(new Font("Arial", 1, 12));
        this.JLBP1.setHorizontalAlignment(0);
        this.JLBP1.setText("<html><p align=\"center\">Cuantas horas has dormido en las ultimas 24 horas? </p><html/>");
        this.JTFFP1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFP1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFP1.setHorizontalAlignment(0);
        this.JTFFP1.setFont(new Font("Arial", 1, 16));
        this.JTFFP1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPTestFatiga.1
            public void actionPerformed(ActionEvent evt) {
                JPTestFatiga.this.JTFFP1ActionPerformed(evt);
            }
        });
        this.JTFFP1.addFocusListener(new FocusAdapter() { // from class: Salud_Ocupacional.JPTestFatiga.2
            public void focusLost(FocusEvent evt) {
                JPTestFatiga.this.JTFFP1FocusLost(evt);
            }
        });
        this.JTFFP1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JPTestFatiga.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPTestFatiga.this.JTFFP1PropertyChange(evt);
            }
        });
        this.JLBP2.setFont(new Font("Arial", 1, 12));
        this.JLBP2.setHorizontalAlignment(0);
        this.JLBP2.setText("<html><p align=\"center\">Cuantas horas has dormido en las ultimas 48 horas?</p><html/>");
        this.JTFFP2.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFP2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFP2.setHorizontalAlignment(0);
        this.JTFFP2.setFont(new Font("Arial", 1, 16));
        this.JTFFP2.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPTestFatiga.4
            public void actionPerformed(ActionEvent evt) {
                JPTestFatiga.this.JTFFP2ActionPerformed(evt);
            }
        });
        this.JTFFP2.addFocusListener(new FocusAdapter() { // from class: Salud_Ocupacional.JPTestFatiga.5
            public void focusLost(FocusEvent evt) {
                JPTestFatiga.this.JTFFP2FocusLost(evt);
            }
        });
        this.JTFFP2.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JPTestFatiga.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPTestFatiga.this.JTFFP2PropertyChange(evt);
            }
        });
        this.JLBP3.setFont(new Font("Arial", 1, 12));
        this.JLBP3.setHorizontalAlignment(0);
        this.JLBP3.setText("<html><p align=\"center\">Cuantas horas has estado despierto en total?</p><html/>");
        this.JTFFP3.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFP3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFP3.setHorizontalAlignment(0);
        this.JTFFP3.setFont(new Font("Arial", 1, 16));
        this.JTFFP3.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPTestFatiga.7
            public void actionPerformed(ActionEvent evt) {
                JPTestFatiga.this.JTFFP3ActionPerformed(evt);
            }
        });
        this.JTFFP3.addFocusListener(new FocusAdapter() { // from class: Salud_Ocupacional.JPTestFatiga.8
            public void focusLost(FocusEvent evt) {
                JPTestFatiga.this.JTFFP3FocusLost(evt);
            }
        });
        this.JTFFP3.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JPTestFatiga.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPTestFatiga.this.JTFFP3PropertyChange(evt);
            }
        });
        this.JTFFPTotal.setEditable(false);
        this.JTFFPTotal.setBackground(new Color(255, 255, 255));
        this.JTFFPTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "PUNTAJE TOTAL", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPTotal.setForeground(new Color(255, 0, 0));
        this.JTFFPTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFPTotal.setHorizontalAlignment(4);
        this.JTFFPTotal.setFocusable(false);
        this.JTFFPTotal.setFont(new Font("Arial", 1, 18));
        this.JLBRiesgo.setFont(new Font("Arial", 1, 18));
        this.JLBRiesgo.setHorizontalAlignment(0);
        this.JLBRiesgo.setOpaque(true);
        this.JSLBarra.setFont(new Font("Arial", 1, 14));
        this.JSLBarra.setMaximum(13);
        this.JSLBarra.setMinorTickSpacing(1);
        this.JSLBarra.setPaintTicks(true);
        this.JSLBarra.setValue(0);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLBNRegistro.setFont(new Font("Arial", 1, 16));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPITestLayout = new GroupLayout(this.JPITest);
        this.JPITest.setLayout(JPITestLayout);
        JPITestLayout.setHorizontalGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addContainerGap().addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITestLayout.createSequentialGroup().addComponent(this.JTFFPTotal, -2, 149, -2).addGap(18, 18, 18).addComponent(this.JLBRiesgo, -1, -1, 32767)).addGroup(JPITestLayout.createSequentialGroup().addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFP1).addComponent(this.JLBP1, -2, 171, -2)).addGap(66, 66, 66).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBP2, -2, 171, -2).addComponent(this.JTFFP2, -2, 171, -2)).addGap(80, 80, 80).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFFP3, -2, 171, -2)).addComponent(this.JLBP3, -2, 180, -2))).addComponent(this.JSLBarra, -2, 616, -2)).addGap(0, 114, 32767)).addGroup(JPITestLayout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 626, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRegistro, -1, -1, 32767))).addContainerGap()));
        JPITestLayout.setVerticalGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addContainerGap().addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBP1, -2, 58, -2).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBP3, -2, 58, -2).addComponent(this.JLBP2, -2, 58, -2))).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFP1, -2, 50, -2).addComponent(this.JTFFP2, -2, 50, -2))).addGroup(JPITestLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFP3, -2, 50, -2))).addGap(41, 41, 41).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPTotal, -2, 50, -2).addComponent(this.JLBRiesgo, -2, 48, -2)).addGap(18, 18, 18).addComponent(this.JSLBarra, -2, -1, -2).addGap(18, 18, 18).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNRegistro, -1, 41, 32767).addComponent(this.JSPObservacion, -2, 0, 32767)).addGap(40, 40, 40)));
        this.JTPDatos.addTab("TEST", this.JPITest);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JPTestFatiga.10
            public void mouseClicked(MouseEvent evt) {
                JPTestFatiga.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 783, 32767).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 347, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP1ActionPerformed(ActionEvent evt) {
        this.JTFFP1.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP1PropertyChange(PropertyChangeEvent evt) {
        if (this.xllenado) {
            mCalcular();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP1FocusLost(FocusEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP2ActionPerformed(ActionEvent evt) {
        this.JTFFP2.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP2PropertyChange(PropertyChangeEvent evt) {
        if (this.xllenado) {
            mCalcular();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP2FocusLost(FocusEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP3ActionPerformed(ActionEvent evt) {
        this.JTFFP1.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP3PropertyChange(PropertyChangeEvent evt) {
        if (this.xllenado) {
            mCalcular();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFP3FocusLost(FocusEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            this.xllenado = false;
            this.JLBNRegistro.setText(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
            System.out.println(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 2).toString());
            this.JTFFP1.setValue(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 2));
            this.JTFFP2.setValue(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3));
            this.JTFFP3.setValue(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 4));
            this.JTAObservacion.setText(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 6).toString());
            this.xllenado = true;
            mCalcular();
            this.JTPDatos.setSelectedIndex(0);
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    public void mNuevo() {
        this.xllenado = false;
        this.JTFFP1.setValue(new Integer(0));
        this.JTFFP2.setValue(new Integer(0));
        this.JTFFP3.setValue(new Integer(0));
        this.JTFFPTotal.setValue(new Integer(0));
        this.JSLBarra.setPaintTicks(true);
        this.JSLBarra.setPaintLabels(true);
        Dictionary labelTable = new Hashtable();
        labelTable.put(new Integer(0), new JLabel("NA"));
        for (int x = 1; x < this.JSLBarra.getMaximum(); x++) {
            labelTable.put(new Integer(x), new JLabel("" + x));
        }
        labelTable.put(new Integer(13), new JLabel("13+"));
        this.JSLBarra.setLabelTable(labelTable);
        this.JLBRiesgo.setText("");
        this.JLBNRegistro.setText("");
        this.JTAObservacion.setText("");
        this.JTFFP1.requestFocus();
        this.xllenado = true;
    }

    private void mCalcular() {
        if (Integer.valueOf(this.JTFFP1.getValue().toString()).intValue() > 0 && Integer.valueOf(this.JTFFP2.getValue().toString()).intValue() > 0 && Integer.valueOf(this.JTFFP3.getValue().toString()).intValue() > 0) {
            int xvalor1 = 0;
            int xvalor2 = 0;
            int xvalor3 = 0;
            if (Integer.valueOf(this.JTFFP1.getValue().toString()).intValue() < 6) {
                xvalor1 = 0 + (4 * (6 - Integer.valueOf(this.JTFFP1.getValue().toString()).intValue()));
            }
            if (Integer.valueOf(this.JTFFP2.getValue().toString()).intValue() < 12) {
                xvalor2 = 0 + (2 * (12 - Integer.valueOf(this.JTFFP2.getValue().toString()).intValue()));
            }
            if (Integer.valueOf(this.JTFFP3.getValue().toString()).intValue() < Integer.valueOf(this.JTFFP2.getValue().toString()).intValue()) {
                xvalor3 = 0 + (Integer.valueOf(this.JTFFP3.getValue().toString()).intValue() - Integer.valueOf(this.JTFFP2.getValue().toString()).intValue());
            }
            System.out.println("V1 " + xvalor1);
            System.out.println("V2 " + xvalor2);
            System.out.println("V3 " + xvalor3);
            int xtotal = xvalor1 + xvalor2 + xvalor3;
            this.JTFFPTotal.setValue(Integer.valueOf(xtotal));
            if (xtotal < 0) {
                xtotal = 0;
            }
            if (xtotal > this.JSLBarra.getMaximum()) {
                xtotal = this.JSLBarra.getMaximum();
            }
            if (xtotal > 0 && xtotal <= this.JSLBarra.getMaximum()) {
                this.JSLBarra.setValue(xtotal);
            }
            mEstablecerRiesgo();
        }
    }

    private void mEstablecerRiesgo() {
        if (Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() <= 0.0d) {
            this.JLBRiesgo.setText("NO APLICA");
            this.JLBRiesgo.setBackground(new Color(0, 255, 0));
            return;
        }
        if (Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() < 5.0d) {
            this.JLBRiesgo.setText("MENOR");
            this.JLBRiesgo.setBackground(new Color(255, 255, 0));
        } else if (Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() >= 5.0d && Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() < 11.0d) {
            this.JLBRiesgo.setText("MODERADO");
            this.JLBRiesgo.setBackground(new Color(255, 200, 0));
        } else if (Double.valueOf(this.JTFFPTotal.getValue().toString()).doubleValue() >= 11.0d) {
            this.JLBRiesgo.setText("SIGNIFICATIVO");
            this.JLBRiesgo.setBackground(new Color(255, 0, 0));
        }
    }

    private void mHacerCasting(JInternalFrame xjf) {
        if (xjf.getName().equals("xjiftestfatiga")) {
            this.xjiftestf = (JIFTest_Fatiga) xjf;
            this.xnombre = "xjifpruebaayd";
            this.xidatencion = "0";
            Principal.mLimpiarDatosP();
            return;
        }
        if (xjf.getName().equals("jifhistoriaclinica")) {
            this.xjifhc = (JIFHistoriaClinica) xjf;
            this.xnombre = "jifhistoriaclinica";
            this.xidatencion = this.xjifhc.JTFFNAtencion.getText();
            this.xidpersona = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
            return;
        }
        if (xjf.getName().equals("xjiftestfatigaE")) {
            this.xjiftestf = (JIFTest_Fatiga) xjf;
            this.xnombre = "xjiftestfatigaE";
            this.xidatencion = "0";
        }
    }

    public void mGrabar() {
        if (this.xmt.esIPSMineros()) {
            if (!this.JLBRiesgo.getText().isEmpty()) {
                if (this.xnombre.equals("xjifpruebaayd") || this.xnombre.equals("xjiftestfatigaE")) {
                    this.xjiftestf.xjppersona.grabar();
                    this.xidpersona = this.xjiftestf.xjppersona.getIdPersona();
                }
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.JLBNRegistro.getText().isEmpty()) {
                        this.xsql = "Insert into h_so_test_fatiga (`FechaT`, `Id_Usuario`, `Id_ATencion`, `P1`, `P2`, `P3`, `PTotal`, `Observacion`, `Riesgo`, `I_Profesional`, `Id_Especialidad`, `UsuarioS` ) values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidpersona + "','" + this.xidatencion + "','" + this.JTFFP1.getValue() + "','" + this.JTFFP2.getValue() + "','" + this.JTFFP3.getValue() + "','" + this.JTFFPTotal.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.JLBRiesgo.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                    } else {
                        this.xsql = "UPDATE h_so_test_fatiga SET `FechaT` = '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', `Id_Usuario` = '" + this.xidpersona + "', `Id_ATencion` = '" + this.xidatencion + "', `P1` = '" + this.JTFFP1.getValue() + "', `P2` = '" + this.JTFFP2.getValue() + "', `P3` = '" + this.JTFFP3.getValue() + "', `PTotal` = '" + this.JTFFPTotal.getValue() + "', `Observacion` = '" + this.JTAObservacion.getText() + "', `Riesgo` = '" + this.JLBRiesgo.getText() + "', `I_Profesional` = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', `Id_Especialidad` = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE h_so_test_fatiga.Id =" + this.JLBNRegistro.getText() + "";
                        this.xct.ejecutarSQL(this.xsql);
                    }
                    this.xct.cerrarConexionBd();
                    mCargarDatosTablaHistorico();
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFormaHistoria().intValue() == 1) {
                        Principal.clasehistoriace.historia_Clinica_v2.consultarEstadoItems(getName(), 1, true);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.JLBNRegistro.getText().isEmpty()) {
            if (!this.JLBRiesgo.getText().isEmpty()) {
                if (this.xnombre.equals("xjifpruebaayd") || this.xnombre.equals("xjiftestfatigaE")) {
                    this.xjiftestf.xjppersona.grabar();
                    this.xidpersona = this.xjiftestf.xjppersona.getIdPersona();
                }
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    this.xsql = "Insert into h_so_test_fatiga (`FechaT`, `Id_Usuario`, `Id_ATencion`, `P1`, `P2`, `P3`, `PTotal`, `Observacion`, `Riesgo`, `I_Profesional`, `Id_Especialidad`, `UsuarioS` ) values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidpersona + "','" + this.xidatencion + "','" + this.JTFFP1.getValue() + "','" + this.JTFFP2.getValue() + "','" + this.JTFFP3.getValue() + "','" + this.JTFFPTotal.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.JLBRiesgo.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    mCargarDatosTablaHistorico();
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFormaHistoria().intValue() == 1) {
                        Principal.clasehistoriace.historia_Clinica_v2.consultarEstadoItems(getName(), 1, true);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "P1", "P2", "P3", "R", "Observación", "Riesgo", "Especialidad", "Profesional"}) { // from class: Salud_Ocupacional.JPTestFatiga.11
            Class[] types = {Long.class, String.class, Long.class, Long.class, Long.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo1);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
    }

    public void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT `h_so_test_fatiga`.`Id`, date_format(`h_so_test_fatiga`.`FechaT`,'%d-%m-%Y') as Fecha, `h_so_test_fatiga`.`P1`, `h_so_test_fatiga`.`P2`, `h_so_test_fatiga`.`P3`, `h_so_test_fatiga`.`PTotal`, `h_so_test_fatiga`.`Observacion` , `h_so_test_fatiga`.`Riesgo` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` FROM   `h_so_test_fatiga`  INNER JOIN `profesional1`  ON (`h_so_test_fatiga`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_so_test_fatiga`.`I_Profesional`) WHERE (`h_so_test_fatiga`.`Id_Usuario` ='" + this.xidpersona + "' AND `h_so_test_fatiga`.`Estado`=1) ORDER BY `h_so_test_fatiga`.`FechaT` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTestFatiga.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getXidpersona() {
        return this.xidpersona;
    }

    public void setXidpersona(String xidpersona) {
        this.xidpersona = xidpersona;
    }

    public void mImprimir() {
        if (!this.JLBNRegistro.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRegistro.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Test_Fatiga", mparametros);
        }
    }
}
