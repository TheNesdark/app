package RecursosHumanos;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFAnticipos.class */
public class JIFAnticipos extends JInternalFrame {
    private String[] xidunidadf;
    private String[] xidtipoanticipo;
    private String[] xidconcepto;
    private String[][] xidpersona;
    private String[][] xidaeropuerto;
    private String[][] xidconceptodetalle;
    private String[][] xidmunicipio;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloc;
    private String xsql;
    private String xnombreaeropuerto;
    private Object[] xdato;
    private double xvaloraeropuerto;
    private JButton JBTCarguesA;
    private JComboBox JCBAeropuerto;
    private JComboBox JCBConcepto;
    private JComboBox JCBConceptoDetalle;
    private JComboBox JCBDestino;
    private JComboBox JCBEmpleado;
    private JComboBox JCBTipoAnticipo;
    private JComboBox JCBUnidadF;
    private JCheckBox JCHIdaRegreso;
    private JDateChooser JDFFechaAnt;
    private JDateChooser JDFFechaL;
    private JDateChooser JDFFechaS;
    private JPanel JPIDatosAnt;
    private JPanel JPIDatosB;
    private JPanel JPIDatosDesc;
    private JScrollPane JSPConcepto;
    private JScrollPane JSPDetalleS;
    private JSpinner JSPNDias;
    private JTextPane JTAConcepto;
    private JTable JTDetalleS;
    private JTextField JTFCargo;
    private JFormattedTextField JTFFHoraL;
    private JFormattedTextField JTFFHoraS;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFValor;
    private JTabbedPane JTPDatosV;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    private int xvt = 1;
    private int xnfila = -1;

    public JIFAnticipos() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v99, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatosV = new JTabbedPane();
        this.JPIDatosB = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCBEmpleado = new JComboBox();
        this.JTFCargo = new JTextField();
        this.JCBTipoAnticipo = new JComboBox();
        this.JDFFechaAnt = new JDateChooser();
        this.JPIDatosAnt = new JPanel();
        this.JDFFechaS = new JDateChooser();
        this.JTFFHoraS = new JFormattedTextField();
        this.JDFFechaL = new JDateChooser();
        this.JTFFHoraL = new JFormattedTextField();
        this.JSPNDias = new JSpinner();
        this.JSPConcepto = new JScrollPane();
        this.JTAConcepto = new JTextPane();
        this.JCBDestino = new JComboBox();
        this.JCBAeropuerto = new JComboBox();
        this.JPIDatosDesc = new JPanel();
        this.JCBConcepto = new JComboBox();
        this.JCBConceptoDetalle = new JComboBox();
        this.JCHIdaRegreso = new JCheckBox();
        this.JTFFValor = new JFormattedTextField();
        this.JBTCarguesA = new JButton();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JTFFTotal = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("VIÁTICOS Y GASTOS DE VIAJE");
        setFont(new Font("Arial", 1, 13));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifanticipo");
        addInternalFrameListener(new InternalFrameListener() { // from class: RecursosHumanos.JIFAnticipos.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAnticipos.this.formInternalFrameClosing(evt);
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
        this.JTPDatosV.setForeground(new Color(0, 103, 0));
        this.JTPDatosV.setFont(new Font("Arial", 1, 14));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.2
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBEmpleado.setFont(new Font("Arial", 1, 12));
        this.JCBEmpleado.setBorder(BorderFactory.createTitledBorder((Border) null, "Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpleado.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.3
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBEmpleadoItemStateChanged(evt);
            }
        });
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setHorizontalAlignment(2);
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAnticipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAnticipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Anticipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaAnt.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaAnt.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JDFFechaAnt, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoAnticipo, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUnidadF, 0, 397, 32767)).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JCBEmpleado, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCargo, -1, 491, 32767))).addContainerGap()));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFFechaAnt, GroupLayout.Alignment.TRAILING, -1, 45, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoAnticipo).addComponent(this.JCBUnidadF, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCargo, -2, 50, -2).addComponent(this.JCBEmpleado, -2, 50, -2)).addContainerGap(42, 32767)));
        this.JTPDatosV.addTab("DATOS BÁSICOS", this.JPIDatosB);
        this.JDFFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Salida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaS.setFont(new Font("Arial", 1, 12));
        this.JDFFechaS.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFAnticipos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAnticipos.this.JDFFechaSPropertyChange(evt);
            }
        });
        this.JTFFHoraS.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Salida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraS.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance())));
        this.JTFFHoraS.setFont(new Font("Arial", 1, 12));
        this.JDFFechaL.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Llegada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaL.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaL.setFont(new Font("Arial", 1, 12));
        this.JDFFechaL.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFAnticipos.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAnticipos.this.JDFFechaLPropertyChange(evt);
            }
        });
        this.JTFFHoraL.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Llegada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraL.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance())));
        this.JTFFHoraL.setFont(new Font("Arial", 1, 12));
        this.JSPNDias.setFont(new Font("Arial", 1, 12));
        this.JSPNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "NDías", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNDias.addChangeListener(new ChangeListener() { // from class: RecursosHumanos.JIFAnticipos.6
            public void stateChanged(ChangeEvent evt) {
                JIFAnticipos.this.JSPNDiasStateChanged(evt);
            }
        });
        this.JSPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConcepto.setFont(new Font("Arial", 1, 12));
        this.JTAConcepto.setFont(new Font("Arial", 1, 12));
        this.JSPConcepto.setViewportView(this.JTAConcepto);
        this.JCBDestino.setFont(new Font("Arial", 1, 12));
        this.JCBDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDestino.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.7
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBDestinoItemStateChanged(evt);
            }
        });
        this.JCBAeropuerto.setFont(new Font("Arial", 1, 12));
        this.JCBAeropuerto.setBorder(BorderFactory.createTitledBorder((Border) null, "Aeropuerto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAeropuerto.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.8
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBAeropuertoItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosAntLayout = new GroupLayout(this.JPIDatosAnt);
        this.JPIDatosAnt.setLayout(JPIDatosAntLayout);
        JPIDatosAntLayout.setHorizontalGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntLayout.createSequentialGroup().addComponent(this.JDFFechaS, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFHoraS, -2, 97, -2)).addComponent(this.JCBAeropuerto, -2, 216, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntLayout.createSequentialGroup().addComponent(this.JCBDestino, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaL, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraL, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNDias, -2, 63, -2)).addComponent(this.JSPConcepto, -1, 584, 32767)).addContainerGap()));
        JPIDatosAntLayout.setVerticalGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaS, -2, 51, -2).addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraS, -2, 47, -2).addComponent(this.JCBDestino, -2, -1, -2)).addComponent(this.JDFFechaL, -2, 52, -2).addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraL, -2, 49, -2).addComponent(this.JSPNDias, -2, 47, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPConcepto, -2, -1, -2).addComponent(this.JCBAeropuerto, -2, -1, -2)).addContainerGap(42, 32767)));
        this.JTPDatosV.addTab("DATOS DE VIAJE", this.JPIDatosAnt);
        this.JPIDatosDesc.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.9
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JCBConceptoDetalle.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoDetalle.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFAnticipos.10
            public void itemStateChanged(ItemEvent evt) {
                JIFAnticipos.this.JCBConceptoDetalleItemStateChanged(evt);
            }
        });
        this.JCHIdaRegreso.setFont(new Font("Arial", 1, 12));
        this.JCHIdaRegreso.setText("D");
        this.JCHIdaRegreso.setToolTipText("Es de Ida y Regreso");
        this.JCHIdaRegreso.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFAnticipos.11
            public void actionPerformed(ActionEvent evt) {
                JIFAnticipos.this.JCHIdaRegresoActionPerformed(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Adicionar");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFAnticipos.12
            public void actionPerformed(ActionEvent evt) {
                JIFAnticipos.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setForeground(new Color(0, 0, 204));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleS.setEditingColumn(2);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setGridColor(new Color(0, 0, 0));
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.setSelectionMode(0);
        this.JTDetalleS.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFAnticipos.13
            public void keyPressed(KeyEvent evt) {
                JIFAnticipos.this.JTDetalleSKeyPressed(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosDescLayout = new GroupLayout(this.JPIDatosDesc);
        this.JPIDatosDesc.setLayout(JPIDatosDescLayout);
        JPIDatosDescLayout.setHorizontalGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosDescLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFTotal, -2, 167, -2).addComponent(this.JBTCarguesA, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalleS, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosDescLayout.createSequentialGroup().addComponent(this.JCBConcepto, -2, 216, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConceptoDetalle, -2, 413, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHIdaRegreso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor))).addContainerGap()));
        JPIDatosDescLayout.setVerticalGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDescLayout.createSequentialGroup().addGroup(JPIDatosDescLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConcepto, -2, -1, -2).addComponent(this.JCBConceptoDetalle, -2, -1, -2).addComponent(this.JCHIdaRegreso).addComponent(this.JTFFValor, -2, 49, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCarguesA, -2, 44, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleS, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.JTFFTotal, -2, 49, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosDesc, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPDatosV, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosV, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosDesc, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBEmpleado.removeAllItems();
            this.xsql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, rh_tipo_cargo.Nbre, persona.Corre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_unidad_funcional ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) WHERE (rh_unidad_funcional.Id ='" + this.xidunidadf[this.JCBUnidadF.getSelectedIndex()] + "' AND rh_tipo_persona_cargon.Estado =1) ORDER BY persona.NUsuario ASC ";
            this.xidpersona = this.xct.llenarComboyLista(this.xsql, this.xidpersona, this.JCBEmpleado, 4);
            this.JCBEmpleado.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpleadoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBEmpleado.getSelectedIndex() != -1) {
            this.JTFCargo.setText(this.xidpersona[this.JCBEmpleado.getSelectedIndex()][1]);
        } else {
            this.JTFCargo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDestinoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDestino.getSelectedIndex() != -1) {
            this.JCBAeropuerto.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xidaeropuerto = xct1.llenarComboyLista("SELECT Id, Nbre, Valor FROM g_areopuertos WHERE (Id_Municipio ='" + this.xidmunicipio[this.JCBDestino.getSelectedIndex()][0] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidaeropuerto, this.JCBAeropuerto, 3);
            if (this.xidaeropuerto.length > 0) {
                this.JCBAeropuerto.setSelectedIndex(0);
                this.xvaloraeropuerto = Double.valueOf(this.xidaeropuerto[this.JCBAeropuerto.getSelectedIndex()][1]).doubleValue();
            } else {
                this.xnombreaeropuerto = "NO APLICA";
                this.xvaloraeropuerto = 0.0d;
            }
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaLPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcularDias();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaSPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcularDias();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBConcepto.getSelectedIndex() != -1) {
            this.xlleno2 = false;
            this.JCBConceptoDetalle.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT cc_anticipo_tipo_detalle.Id, cc_anticipo_detalle_concepto.Nbre, IF(cc_anticipo_tipo_detalle.VFijo=1,cc_anticipo_tipo_detalle.Valor,0) AS Valor, cc_anticipo_detalle_concepto.EsCalculado FROM cc_anticipo_tipo_detalle INNER JOIN cc_anticipo_detalle_concepto  ON (cc_anticipo_tipo_detalle.Id_DetalleConcepto = cc_anticipo_detalle_concepto.Id) WHERE (cc_anticipo_tipo_detalle.Estado =1 AND cc_anticipo_tipo_detalle.Id_TipoConcepto ='" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()] + "') ORDER BY cc_anticipo_detalle_concepto.Nbre ASC ";
            this.xidconceptodetalle = xct1.llenarComboyLista(this.xsql, this.xidconceptodetalle, this.JCBConceptoDetalle, 4);
            this.JCBConceptoDetalle.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoDetalleItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBConceptoDetalle.getSelectedIndex() != -1) {
            mCarcularDatosConcepto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNDiasStateChanged(ChangeEvent evt) {
        if (this.xlleno && this.JCBConcepto.getSelectedIndex() != -1) {
            mCarcularDatosConcepto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIdaRegresoActionPerformed(ActionEvent evt) {
        if (this.JCHIdaRegreso.isSelected()) {
            this.xvt = 2;
        } else {
            this.xvt = 1;
        }
        mCarcularDatosConcepto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (!this.xmt.mVerificarDatosDoblesTabla(this.JTDetalleS, 0, this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][0])) {
            if (this.JCBConceptoDetalle.getSelectedIndex() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleecion un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConceptoDetalle.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() > 0.0d) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][0]), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JCBConceptoDetalle.getSelectedItem().toString(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 3);
                this.JTFFValor.setValue(new Double(0.0d));
                this.JCBConceptoDetalle.removeAllItems();
                this.JCBConcepto.setSelectedIndex(-1);
                this.JCBConcepto.requestFocus();
                mCalcularTotal();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe registra el valor del concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValor.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe concepto registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleS.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalleS.getSelectedRow());
                this.xnfila--;
            }
            mCalcularTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAeropuertoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBAeropuerto.getSelectedIndex() != -1) {
            if (this.xidaeropuerto.length > 0) {
                this.xnombreaeropuerto = this.JCBAeropuerto.getSelectedItem().toString();
                this.xvaloraeropuerto = Double.valueOf(this.xidaeropuerto[this.JCBAeropuerto.getSelectedIndex()][1]).doubleValue();
                return;
            }
            return;
        }
        this.xnombreaeropuerto = "NO APLICA";
        this.xvaloraeropuerto = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    private void mCarcularDatosConcepto() {
        this.JTFFValor.setValue(new Double(0.0d));
        if (this.xidconcepto[this.JCBConcepto.getSelectedIndex()].equals("2")) {
            if (this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][2].equals("1")) {
                this.JCHIdaRegreso.setEnabled(true);
                if (this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][0].equals("4")) {
                    this.JTFFValor.setValue(Double.valueOf(this.xvaloraeropuerto * ((double) this.xvt)));
                    return;
                } else {
                    if (this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][0].equals("5")) {
                        this.JTFFValor.setValue(Double.valueOf(Double.valueOf(this.xidmunicipio[this.JCBDestino.getSelectedIndex()][1]).doubleValue() * ((double) this.xvt)));
                        System.out.println(" Vm " + this.xidmunicipio[this.JCBDestino.getSelectedIndex()][1]);
                        return;
                    }
                    return;
                }
            }
            this.JCHIdaRegreso.setEnabled(false);
            return;
        }
        this.JCHIdaRegreso.setEnabled(false);
        if (this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][2].equals("1")) {
            if (Long.valueOf(this.JSPNDias.getValue().toString()).longValue() > 0) {
                this.JTFFValor.setValue(Double.valueOf(Double.valueOf(this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][1]).doubleValue() * Long.valueOf(this.JSPNDias.getValue().toString()).longValue()));
            } else {
                this.JTFFValor.setValue(Double.valueOf(this.xidconceptodetalle[this.JCBConceptoDetalle.getSelectedIndex()][1]));
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.xlleno1 = false;
        this.xlleno2 = false;
        this.JCBEmpleado.removeAllItems();
        this.JCBUnidadF.removeAllItems();
        this.JCBTipoAnticipo.removeAllItems();
        this.JCBDestino.removeAllItems();
        this.xsql = "SELECT rh_unidad_funcional.Id, rh_unidad_funcional.Nbre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_unidad_funcional  ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) GROUP BY rh_unidad_funcional.Id ORDER BY rh_unidad_funcional.Nbre ASC ";
        this.xidunidadf = this.xct.llenarCombo(this.xsql, this.xidunidadf, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JDFFechaAnt.setDate(this.xmt.getFechaActual());
        this.xidtipoanticipo = this.xct.llenarCombo("SELECT Id, Nbre FROM cc_anticipo_tipo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoanticipo, this.JCBTipoAnticipo);
        this.JCBTipoAnticipo.setSelectedIndex(-1);
        this.xsql = "SELECT g_municipio.Id, CONCAT(g_municipio.Nbre,' - ',UCASE(g_departamento.Nbre)) AS NMunicipio, g_municipio.VTaxi FROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0) ORDER BY CONCAT(g_municipio.Nbre,' - ',UCASE(g_departamento.Nbre))";
        this.xidmunicipio = this.xct.llenarComboyLista(this.xsql, this.xidmunicipio, this.JCBDestino, 3);
        this.JCBConceptoDetalle.removeAllItems();
        this.JCBDestino.setSelectedIndex(-1);
        this.JCBConcepto.removeAllItems();
        this.xsql = "SELECT cc_anticipo_tipo_concepto.Id, cc_anticipo_tipo_concepto.Nbre FROM cc_anticipo_tipo_detalle INNER JOIN cc_anticipo_tipo_concepto  ON (cc_anticipo_tipo_detalle.Id_TipoConcepto = cc_anticipo_tipo_concepto.Id) INNER JOIN cc_anticipo_detalle_concepto  ON (cc_anticipo_tipo_detalle.Id_DetalleConcepto = cc_anticipo_detalle_concepto.Id) WHERE (cc_anticipo_tipo_detalle.Estado =1)GROUP BY cc_anticipo_tipo_concepto.Id ORDER BY cc_anticipo_tipo_concepto.Nbre ASC ";
        this.xidconcepto = this.xct.llenarCombo(this.xsql, this.xidconcepto, this.JCBConcepto);
        this.JCBConcepto.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFCargo.setText("");
        this.JDFFechaS.setDate(this.xmt.getFechaActual());
        this.JTFFHoraS.setValue(this.xmt.getFechaActual());
        this.JDFFechaL.setDate(this.xmt.getFechaActual());
        this.JTFFHoraL.setValue(this.xmt.getFechaActual());
        this.JTAConcepto.setText("");
        this.JCHIdaRegreso.setEnabled(false);
        this.JTFFTotal.setValue(new Double(0.0d));
        mCrearTablaDetalle();
        this.xlleno = true;
    }

    private void mCalcularDias() {
        Long xdias = Long.valueOf((this.JDFFechaL.getDate().getTime() - this.JDFFechaS.getDate().getTime()) / 86400000);
        System.out.println(xdias);
        this.JSPNDias.setValue(xdias);
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Concepto", "Detalle", "Valor"}) { // from class: RecursosHumanos.JIFAnticipos.14
            Class[] types = {Long.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleS.setModel(this.xmodelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.xnfila = -1;
    }

    private void mCalcularTotal() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.JTDetalleS.getRowCount(); x++) {
            xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue();
        }
        this.JTFFTotal.setValue(Double.valueOf(xvalor));
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoAnticipo.getSelectedIndex() != -1) {
                if (this.JCBEmpleado.getSelectedIndex() != -1) {
                    if (this.JCBDestino.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            this.xsql = "insert into cc_anticipos(Id_Tipo_PersonaC, Id_Tipo_Anticipo, FechaA, Concepto, Fecha_Salida, Hora_Salida, Fecha_Llegada, Hora_Llegada, Ndias, Id_CDestino, NAeropuerto, UsuarioS) values('" + this.xidpersona[this.JCBEmpleado.getSelectedIndex()][0] + "','" + this.xidtipoanticipo[this.JCBTipoAnticipo.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaAnt.getDate()) + "','" + this.JTAConcepto.getText() + "','" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHoraS.getValue()) + "','" + this.xmt.formatoAMD.format(this.JDFFechaL.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHoraL.getValue()) + "','" + this.JSPNDias.getValue() + "','" + this.xidmunicipio[this.JCBDestino.getSelectedIndex()][0] + "','" + this.xnombreaeropuerto + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                            this.xct.cerrarConexionBd();
                            for (int z = 0; z < this.JTDetalleS.getRowCount(); z++) {
                                this.xsql = "insert into cc_anticipos_detalle (Id_Anticipo, Id_TipoDetalle, Valor) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(z, 0) + "','" + this.xmodelo.getValueAt(z, 3) + "')";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                            ConsultasMySQL xct1 = new ConsultasMySQL();
                            this.xsql = "insert into cc_anticipos_firma (Id_Anticipos, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + this.xidpersona[this.JCBEmpleado.getSelectedIndex()][0] + "')";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xmt.mEnvioCorreoElectronico("Se le ha generado el anticipo N°" + Principal.txtNo.getText() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", this.xidpersona[this.JCBEmpleado.getSelectedIndex()][2], "AUTORIZACIÓN DE ANTICIPOS", Principal.usuarioSistemaDTO.getLogin());
                            mGrabarUsuarioA();
                            mImprimir();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ciudad de destino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBDestino.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un empleado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoAnticipo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de anticipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoAnticipo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarUsuarioA() {
        try {
            this.xsql = "SELECT rh_tipo_persona_cargon.Id, persona.Corre  FROM rh_tipo_persona_cargon INNER JOIN cc_usuarioxdocumentof  ON (rh_tipo_persona_cargon.Id_Persona = cc_usuarioxdocumentof.Id_Persona) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (cc_usuarioxdocumentof.Id_TipoDocF =7 AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    this.xsql = "insert into cc_anticipos_firma (Id_Anticipos, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + rs.getInt(1) + "')";
                    xct1.ejecutarSQL(this.xsql);
                    xct1.cerrarConexionBd();
                    this.xmt.mEnvioCorreoElectronico("Se ha generado el anticipo N°" + Principal.txtNo.getText() + "\n al señor(a) : " + this.JCBEmpleado.getSelectedItem().toString() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", rs.getString(2), "AUTORIZACIÓN DE ANTICIPOS", Principal.usuarioSistemaDTO.getLogin());
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnticipos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Anticipos", mparametros);
        }
    }
}
