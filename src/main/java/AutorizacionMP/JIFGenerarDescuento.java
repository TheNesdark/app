package AutorizacionMP;

import Acceso.Principal;
import General.BuscarPersona;
import General.JDBiometrico;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFGenerarDescuento.class */
public class JIFGenerarDescuento extends JInternalFrame {
    private Persona frmPersona;
    private String[] xidtipodescuento;
    private String[] xidmunicipio;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ButtonGroup JBGOpciones;
    private JButton JBTBiometria;
    private JComboBox JCBMunicipioR;
    private JComboBox JCBTipoDescuento;
    public JDateChooser JDFFecha;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosDesc;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIHistorico;
    private JPanel JPINQuincena;
    private JRadioButton JRBDos;
    private JRadioButton JRBTres;
    private JRadioButton JRBUna;
    private JScrollPane JSPHC;
    private JScrollPane JSPNotasAdicionales;
    public JFormattedTextField JTFFTDescontado;
    public JFormattedTextField JTFFTDescuento;
    public JFormattedTextField JTFFTPDescontar;
    public JFormattedTextField JTFFValorDescuento;
    private JTable JTHistorico;
    private JTabbedPane JTPDatosR;
    private JTextPane JTPNotasAdicionales;
    private int xnquincenas = 3;
    private int xidrelacion = 0;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private long xidpersonad = 0;
    private boolean xesacumulado = false;

    public JIFGenerarDescuento() {
        initComponents();
        this.JDFFecha.setDate(this.xmetodos.getFechaActual());
        this.xidtipodescuento = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipo_descuento WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodescuento, this.JCBTipoDescuento);
        this.JCBTipoDescuento.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xidmunicipio = this.xconsultas.llenarCombo("SELECT Id, Nbre, Estado FROM baseserver.g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipioR);
        this.JCBMunicipioR.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        Principal.lblNo.setText("N° Descuento");
        mCargarPanelPersona();
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIConsolidado = new JPanel();
        this.JTFFTDescuento = new JFormattedTextField();
        this.JTFFTDescontado = new JFormattedTextField();
        this.JTFFTPDescontar = new JFormattedTextField();
        this.JTPDatosR = new JTabbedPane();
        this.JPIDatosDesc = new JPanel();
        this.JDFFecha = new JDateChooser();
        this.JCBMunicipioR = new JComboBox();
        this.JCBTipoDescuento = new JComboBox();
        this.JPINQuincena = new JPanel();
        this.JRBUna = new JRadioButton();
        this.JRBDos = new JRadioButton();
        this.JRBTres = new JRadioButton();
        this.JTFFValorDescuento = new JFormattedTextField();
        this.JSPNotasAdicionales = new JScrollPane();
        this.JTPNotasAdicionales = new JTextPane();
        this.JBTBiometria = new JButton();
        this.JPIHistorico = new JPanel();
        this.JSPHC = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifgeneraciondescuento");
        setNormalBounds(null);
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFGenerarDescuento.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerarDescuento.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIFDatosUsuario.setFont(new Font("Arial", 1, 12));
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Descuentos", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTDescuento.setHorizontalAlignment(4);
        this.JTFFTDescuento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFTDescuento.setFont(new Font("Arial", 1, 16));
        this.JTFFTDescuento.setValue(new Integer(0));
        this.JTFFTDescontado.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Descontado", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTDescontado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTDescontado.setHorizontalAlignment(4);
        this.JTFFTDescontado.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFTDescontado.setFont(new Font("Arial", 1, 16));
        this.JTFFTDescontado.setValue(new Integer(0));
        this.JTFFTPDescontar.setBorder(BorderFactory.createTitledBorder((Border) null, "Total PDescontar", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTPDescontar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTPDescontar.setHorizontalAlignment(4);
        this.JTFFTPDescontar.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFTPDescontar.setFont(new Font("Arial", 1, 16));
        this.JTFFTPDescontar.setValue(new Integer(0));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTDescuento, -2, 143, -2).addComponent(this.JTFFTDescontado, -2, 143, -2).addComponent(this.JTFFTPDescontar, -2, 143, -2)).addContainerGap(21, 32767)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addComponent(this.JTFFTDescuento, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTDescontado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTPDescontar, -2, 50, -2).addContainerGap(-1, 32767)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosUsuarioLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIConsolidado, -2, -1, -2).addContainerGap()));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIConsolidado, -2, -1, -2));
        this.JTPDatosR.setForeground(new Color(0, 103, 0));
        this.JTPDatosR.setFont(new Font("Arial", 1, 14));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipioR.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipioR.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDescuento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JPINQuincena.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Quincenas", 1, 0, new Font("Arial", 1, 12), new Color(0, 102, 51)));
        this.JBGOpciones.add(this.JRBUna);
        this.JRBUna.setFont(new Font("Arial", 1, 12));
        this.JRBUna.setForeground(new Color(0, 0, 153));
        this.JRBUna.setText("Una");
        this.JRBUna.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarDescuento.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarDescuento.this.JRBUnaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBDos);
        this.JRBDos.setFont(new Font("Arial", 1, 12));
        this.JRBDos.setForeground(new Color(0, 0, 153));
        this.JRBDos.setText("Dos");
        this.JRBDos.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarDescuento.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarDescuento.this.JRBDosActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBTres);
        this.JRBTres.setFont(new Font("Arial", 1, 12));
        this.JRBTres.setForeground(new Color(0, 0, 153));
        this.JRBTres.setSelected(true);
        this.JRBTres.setText("Tres");
        this.JRBTres.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarDescuento.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarDescuento.this.JRBTresActionPerformed(evt);
            }
        });
        GroupLayout JPINQuincenaLayout = new GroupLayout(this.JPINQuincena);
        this.JPINQuincena.setLayout(JPINQuincenaLayout);
        JPINQuincenaLayout.setHorizontalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBUna).addGap(18, 18, 18).addComponent(this.JRBDos).addGap(10, 10, 10).addComponent(this.JRBTres).addContainerGap(-1, 32767)));
        JPINQuincenaLayout.setVerticalGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINQuincenaLayout.createSequentialGroup().addGroup(JPINQuincenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUna).addComponent(this.JRBTres).addComponent(this.JRBDos)).addContainerGap(-1, 32767)));
        this.JTFFValorDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFValorDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFValorDescuento.setHorizontalAlignment(4);
        this.JTFFValorDescuento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorDescuento.setFont(new Font("Arial", 1, 14));
        this.JTFFValorDescuento.setValue(new Integer(0));
        this.JSPNotasAdicionales.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 1, 0, new Font("Arial", 1, 13), Color.blue));
        this.JSPNotasAdicionales.setFont(new Font("Arial", 1, 12));
        this.JTPNotasAdicionales.setFont(new Font("Arial", 1, 12));
        this.JSPNotasAdicionales.setViewportView(this.JTPNotasAdicionales);
        this.JBTBiometria.setFont(new Font("Arial", 1, 12));
        this.JBTBiometria.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTBiometria.setText("Firmado por Biometría");
        this.JBTBiometria.setEnabled(false);
        this.JBTBiometria.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarDescuento.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarDescuento.this.JBTBiometriaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosDescLayout = new GroupLayout(this.JPIDatosDesc);
        this.JPIDatosDesc.setLayout(JPIDatosDescLayout);
        JPIDatosDescLayout.setHorizontalGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDescLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNotasAdicionales, -1, 1152, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosDescLayout.createSequentialGroup().addComponent(this.JDFFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMunicipioR, 0, 371, 32767).addGap(9, 9, 9).addComponent(this.JCBTipoDescuento, -2, 251, -2).addGap(18, 18, 18).addComponent(this.JPINQuincena, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFFValorDescuento, -2, 143, -2)).addGroup(JPIDatosDescLayout.createSequentialGroup().addComponent(this.JBTBiometria).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosDescLayout.setVerticalGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDescLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFValorDescuento, -2, 50, -2).addGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDescuento, -2, 48, -2).addComponent(this.JCBMunicipioR, -2, 48, -2)).addComponent(this.JDFFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPINQuincena, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNotasAdicionales, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTBiometria, -2, 50, -2).addGap(19, 19, 19)));
        this.JTPDatosR.addTab("GENERACIÓN", this.JPIDatosDesc);
        this.JSPHC.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFGenerarDescuento.6
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarDescuento.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JTHistorico.addPropertyChangeListener(new PropertyChangeListener() { // from class: AutorizacionMP.JIFGenerarDescuento.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarDescuento.this.JTHistoricoPropertyChange(evt);
            }
        });
        this.JTHistorico.addKeyListener(new KeyAdapter() { // from class: AutorizacionMP.JIFGenerarDescuento.8
            public void keyPressed(KeyEvent evt) {
                JIFGenerarDescuento.this.JTHistoricoKeyPressed(evt);
            }
        });
        this.JSPHC.setViewportView(this.JTHistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHC, -1, 1152, 32767).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHC, -1, 215, 32767).addContainerGap()));
        this.JTPDatosR.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDatosR)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosR, -2, 268, -2).addContainerGap(43, 32767)));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDosActionPerformed(ActionEvent evt) {
        this.xnquincenas = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTresActionPerformed(ActionEvent evt) {
        this.xnquincenas = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        int xtipo;
        if (this.JTHistorico.getRowCount() > -1 && this.JTHistorico.getSelectedRow() != -1) {
            if (this.JTHistorico.getSelectedColumn() != 0) {
                if (this.JTHistorico.getSelectedColumn() == 14) {
                    mCalcularValores();
                    return;
                }
                if (this.JTHistorico.getSelectedColumn() == 15) {
                    int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cambiar el estado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (xv == 0) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 15).toString()).booleanValue()) {
                            xtipo = 1;
                        } else {
                            xtipo = 0;
                        }
                        mActualizarLiquidar(xtipo, Long.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString()).longValue());
                        return;
                    }
                    return;
                }
                return;
            }
            this.xidrelacion = 0;
            this.xesacumulado = false;
            Object[] botones = {"Cargar Descuento", "Visualizar", "Mostrar Soporte", "Descuentos Aplicados", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que acción desea realizar?", "DESCUENTO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
                this.JDFFecha.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
                this.JCBTipoDescuento.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
                this.JCBMunicipioR.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString());
                if (this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString().equals("1")) {
                    this.JRBUna.setSelected(true);
                } else if (this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString().equals("2")) {
                    this.JRBDos.setSelected(true);
                } else if (this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString().equals("3")) {
                    this.JRBTres.setSelected(true);
                }
                this.JTFFValorDescuento.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()));
                this.JTPNotasAdicionales.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
                this.xidrelacion = Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString()).intValue();
                this.xesacumulado = Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 10).toString()).booleanValue();
                this.JBTBiometria.setEnabled(true);
                this.JTPDatosR.setSelectedIndex(0);
                return;
            }
            if (n != 1) {
                if (n == 2) {
                    if (!this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString().equals("")) {
                        this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString());
                        return;
                    }
                    return;
                } else {
                    if (n == 3) {
                        JDConsultarDAplicados xjidc = new JDConsultarDAplicados(null, true, this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
                        xjidc.setVisible(true);
                        return;
                    }
                    return;
                }
            }
            String[][] mparametros = new String[4][2];
            new convertirNumerosLetras();
            mparametros[0][0] = "ndescuento";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString();
            mparametros[1][0] = "valorLetras";
            mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 11).toString());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString().equals("0")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RDescuentoNominaN", mparametros);
            } else {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RDescuentoNomina_1", mparametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JTHistorico.getSelectedRow() != -1 && this.JTHistorico.getSelectedColumn() == 12) {
            int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro actualizar el valor?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv == 0) {
                String xsql = "update d_descuento set VDescontado='" + this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 12) + "' where Id='" + this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "'";
                this.xconsultas.ejecutarSQL(xsql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTabla(this.frmPersona.getIdPersona());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBiometriaActionPerformed(ActionEvent evt) {
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
        this.frmPersona.setBounds(10, 20, 1000, 160);
        this.JPIFDatosUsuario.add(this.frmPersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mGuardarDDescuento() {
        String sql = "Insert Into d_descuento (FechaD, Id_PersonaDescuento, Id_TipoDescuento, Valor, NQuincenas, VDescontarQ, Observacion, Id_Municipio, Fecha, UsuarioS) values('" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + this.xidpersonad + "','" + this.xidtipodescuento[this.JCBTipoDescuento.getSelectedIndex()] + "','" + this.JTFFValorDescuento.getValue() + "','" + this.xnquincenas + "',Round('" + (Double.valueOf(this.JTFFValorDescuento.getValue().toString()).doubleValue() / ((double) this.xnquincenas)) + "'),'" + this.JTPNotasAdicionales.getText() + "','" + this.xidmunicipio[this.JCBMunicipioR.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
        this.xconsultas.cerrarConexionBd();
    }

    private void mLimpiarComponentes() {
        Principal.mLimpiarDatosP();
        this.JDFFecha.setDate(this.xmetodos.getFechaActual());
        this.JCBTipoDescuento.setSelectedIndex(-1);
        this.JCBMunicipioR.setSelectedIndex(-1);
        this.JRBTres.setSelected(true);
        this.xnquincenas = 3;
        this.JTFFValorDescuento.setValue(0);
        this.JTPNotasAdicionales.setText("");
    }

    public void mNuevo() {
        Object[] botones = {"Usuario", "Descuentos", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.frmPersona.nuevo();
            mLimpiarComponentes();
            this.xidpersonad = 0L;
            this.xidrelacion = 0;
            mCrearTabla();
            this.frmPersona.txtHistoria.requestFocus();
            return;
        }
        if (n == 1) {
            mLimpiarComponentes();
            this.JCBMunicipioR.requestFocus();
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.xidpersonad != 0) {
                if (this.JCBMunicipioR.getSelectedIndex() != -1) {
                    if (this.JCBTipoDescuento.getSelectedIndex() == -1) {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de descuento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoDescuento.requestFocus();
                        return;
                    }
                    if (Double.valueOf(this.JTFFValorDescuento.getText()).doubleValue() != 0.0d) {
                        int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (xv == 0) {
                            this.frmPersona.grabar();
                            mGuardarDDescuento();
                            mCargarDatosTabla(this.frmPersona.getIdPersona());
                            mImprimir();
                            this.JBTBiometria.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El varlo del descuento debe ser mayor que cero", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFValorDescuento.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBMunicipioR.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.frmPersona);
        frmBuscar.setVisible(true);
    }

    public void mBuscarUsuarioFpz(String xidpersona) {
        String sql = "SELECT Id_PersDescuento FROM baseserver.g_usuario_fpz WHERE (Id_Persona ='" + xidpersona + "')";
        this.xconsultas.traerRs(sql);
        try {
            ResultSet xr = this.xconsultas.traerRs(sql);
            if (xr.next()) {
                this.xidpersonad = xr.getLong(1);
                mCargarDatosTabla(xidpersona);
            } else {
                this.xidpersonad = 0L;
            }
            xr.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarDescuento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            new DecimalFormat("#0");
            Metodos xmt = new Metodos();
            String[][] mparametros = new String[4][2];
            new convertirNumerosLetras();
            mparametros[0][0] = "ndescuento";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "valorLetras";
            mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.JTFFValorDescuento.getValue().toString());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(xmt.getRutaRep() + "RDescuentoNominaN", mparametros);
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.xesacumulado) {
                int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (xv == 0) {
                    String sql = "Update d_descuento set Estado=1 where Id='" + Principal.txtNo.getText() + "' and EsAcumulado=0";
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                    Principal.txtEstado.setText("ANULADO");
                    mCargarDatosTabla(this.frmPersona.getIdPersona());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El descuento no se puede anular;\nSe ecuentra incluido en una relacion de cobro", "ANULAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el descuento para anular", "ANULAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTPDatosR.setSelectedIndex(1);
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tipo", "Valor", "NQuincena", "Observación", "NR", "Url", "IdAtencion", "Municipio", "Acumulado", "Valor", "VDescontado", "VPDescontar", "S", "Liquidar?"}) { // from class: AutorizacionMP.JIFGenerarDescuento.9
            Class[] types = {Long.class, String.class, String.class, Double.class, Integer.class, String.class, Integer.class, String.class, String.class, String.class, Boolean.class, String.class, Double.class, Double.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(14).setPreferredWidth(5);
        this.JTHistorico.getColumnModel().getColumn(15).setPreferredWidth(10);
    }

    private void mCargarDatosTabla(String xidusuario) {
        mCrearTabla();
        String sql = "SELECT d_descuento.Id, date_format(d_descuento.FechaD,'%d-%m-%Y') as FechaD, g_tipo_descuento.Nbre, d_descuento.Valor, d_descuento.NQuincenas,IF(d_descuento.Observacion IS NULL, '', d_descuento.Observacion) AS NObservacion, d_descuento.Id_RelacionC, d_descuento.Url,   d_descuento.Id_HAtencion, g_municipio.Nbre AS Municipio, d_descuento.EsAcumulado, d_descuento.VDescontado, (d_descuento.Valor-d_descuento.VDescontado) AS VPDescontar, d_descuento.Liquidar FROM d_descuento INNER JOIN g_tipo_descuento  ON (d_descuento.Id_TipoDescuento = g_tipo_descuento.Id) INNER JOIN g_municipio ON (d_descuento.Id_Municipio = g_municipio.Id) WHERE (d_descuento.Estado =0 AND d_descuento.Id_PersonaDescuento ='" + xidusuario + "') ORDER BY d_descuento.FechaD DESC, d_descuento.Id ASC ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                    this.xmodelo.setValueAt(this.xmetodos.mTraerUrlBD(rs.getString(8)), x, 7);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(11)), x, 10);
                    this.JTHistorico.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(rs.getString(4), x, 11);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), x, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(13)), x, 13);
                    this.xmodelo.setValueAt(false, x, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(14)), x, 15);
                    x++;
                }
                mCalcularValores();
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarDescuento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFGenerarDescuento$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean xtipo = Boolean.valueOf(table.getValueAt(row, 10).toString());
            if (xtipo.booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mCalcularValores() {
        this.JTFFTDescuento.setValue(new Double(0.0d));
        this.JTFFTDescontado.setValue(new Double(0.0d));
        this.JTFFTPDescontar.setValue(new Double(0.0d));
        double xvalor1 = 0.0d;
        for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 14).toString()).booleanValue()) {
                xvalor1 += Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue();
                this.JTFFTDescuento.setValue(Double.valueOf(Double.valueOf(this.JTFFTDescuento.getValue().toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue()));
                this.JTFFTDescontado.setValue(Double.valueOf(Double.valueOf(this.JTFFTDescontado.getValue().toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(x, 12).toString()).doubleValue()));
                this.JTFFTPDescontar.setValue(Double.valueOf(Double.valueOf(this.JTFFTPDescontar.getValue().toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(x, 13).toString()).doubleValue()));
            }
        }
    }

    private void mActualizarLiquidar(int xestado, long xiddescuento) {
        String xsql = "update d_descuento set Liquidar='" + xestado + "' where Id='" + xiddescuento + "' and Liquidar=0";
        this.xconsultas.ejecutarSQL(xsql);
        this.xconsultas.cerrarConexionBd();
    }
}
