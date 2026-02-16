package ComprasBS;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import Presupuesto.JDBusquedaDocPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFOrdenServicio.class */
public class JIFOrdenServicio extends JInternalFrame {
    private DefaultTableModel xmodeloc;
    private String[] xidempresa;
    private String[] xidunidadfuncional;
    private String[] xiadministrador;
    private String[] xIdTipoDoc;
    private Object[] xdato;
    private JIFConsultarDatosV xjifbuscarorden;
    private JButton JBBuscar;
    private JComboBox JCBAdministrador;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoDoc;
    private JComboBox JCBUnidadF;
    private JDateChooser JDFFechaC;
    public JLabel JLCodigoDoc;
    public JLabel JLCodigoDoc1;
    private JPanel JPIDatosC;
    private JPanel JPIDatosP;
    private JScrollPane JSPDetalleC;
    public JSpinner JSPIva;
    private JScrollPane JSPObjetivoG;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObjetivoG;
    private JTextPane JTAObservacion;
    public JTable JTDetalleC;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalIva;
    private JFormattedTextField JTFFValorPropuesta;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    public long xcodigop = 1;
    private String xsql = null;
    private boolean xejecutado = false;
    private boolean xlleno = false;
    public int xIdMovDisponibilidad = 0;

    public JIFOrdenServicio() {
        initComponents();
        this.xidunidadfuncional = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfuncional, this.JCBUnidadF);
        this.xiadministrador = this.xconsultas.llenarCombo("SELECT rh_tipo_persona_cargon.Id_Persona, persona.NUsuario FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (rh_tipo_persona_cargon.Estado =1) ORDER BY persona.NUsuario ASC", this.xiadministrador, this.JCBAdministrador);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
        if (!mPresupuesto()) {
            this.JBBuscar.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v70, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JCBTipoDoc = new JComboBox();
        this.JLCodigoDoc1 = new JLabel();
        this.JPIDatosC = new JPanel();
        this.JSPObjetivoG = new JScrollPane();
        this.JTAObjetivoG = new JTextPane();
        this.JTFFValorPropuesta = new JFormattedTextField();
        this.JSPIva = new JSpinner();
        this.JTFFTotalIva = new JFormattedTextField();
        this.JTFFTotal = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JCBAdministrador = new JComboBox();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("ORDEN DE SERVICIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifordenservicio");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFOrdenServicio.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFOrdenServicio.this.formInternalFrameClosing(evt);
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
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ComprasBS.JIFOrdenServicio.2
            public void itemStateChanged(ItemEvent evt) {
                JIFOrdenServicio.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.addItemListener(new ItemListener() { // from class: ComprasBS.JIFOrdenServicio.3
            public void itemStateChanged(ItemEvent evt) {
                JIFOrdenServicio.this.JCBTipoDocItemStateChanged(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setText("0");
        this.JLCodigoDoc1.setToolTipText("");
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDoc, -2, 486, -2).addGap(18, 18, 18).addComponent(this.JLCodigoDoc1, -2, 125, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 258, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTercero, -2, 474, -2))).addGap(250, 250, 250)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDoc, -2, -1, -2).addComponent(this.JLCodigoDoc1, -2, 43, -2).addComponent(this.JDFFechaC, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, -1, -2).addComponent(this.JCBUnidadF)).addContainerGap()));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL SERVICIO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPObjetivoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObjetivoG.setFont(new Font("Arial", 1, 12));
        this.JSPObjetivoG.setViewportView(this.JTAObjetivoG);
        this.JTFFValorPropuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Propuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPropuesta.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPropuesta.setHorizontalAlignment(4);
        this.JTFFValorPropuesta.setFont(new Font("Arial", 1, 13));
        this.JTFFValorPropuesta.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenServicio.4
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenServicio.this.JTFFValorPropuestaActionPerformed(evt);
            }
        });
        this.JTFFValorPropuesta.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFOrdenServicio.5
            public void focusLost(FocusEvent evt) {
                JIFOrdenServicio.this.JTFFValorPropuestaFocusLost(evt);
            }
        });
        this.JSPIva.setFont(new Font("Arial", 1, 13));
        this.JSPIva.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPIva.setBorder(BorderFactory.createTitledBorder((Border) null, "% Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPIva.addChangeListener(new ChangeListener() { // from class: ComprasBS.JIFOrdenServicio.6
            public void stateChanged(ChangeEvent evt) {
                JIFOrdenServicio.this.JSPIvaStateChanged(evt);
            }
        });
        this.JTFFTotalIva.setEditable(false);
        this.JTFFTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalIva.setHorizontalAlignment(4);
        this.JTFFTotalIva.setFont(new Font("Arial", 1, 13));
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 13));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObjetivoG, -1, 773, 32767).addComponent(this.JSPObservacion, -1, 769, 32767).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFFValorPropuesta, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPIva, -2, -1, -2).addGap(14, 14, 14).addComponent(this.JTFFTotalIva, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal, -2, 123, -2))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObjetivoG, -2, 86, -2).addGap(14, 14, 14).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFValorPropuesta, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalIva, -1, 52, 32767).addComponent(this.JSPIva, -2, 52, -2)).addComponent(this.JTFFTotal)).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 73, -2).addContainerGap()));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "Condiciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalleC.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setForeground(new Color(0, 0, 204));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(2);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setGridColor(new Color(204, 255, 204));
        this.JTDetalleC.setRowHeight(20);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JCBAdministrador.setFont(new Font("Arial", 1, 12));
        this.JCBAdministrador.setBorder(BorderFactory.createTitledBorder((Border) null, "Administrador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenServicio.7
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenServicio.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setText("0");
        this.JLCodigoDoc.setToolTipText("");
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalleC, -2, 437, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAdministrador, 0, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JLCodigoDoc, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2).addGap(0, 0, 32767)))).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -2, 795, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatosC, -2, -1, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCBAdministrador, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLCodigoDoc, -1, -1, 32767).addComponent(this.JBBuscar, -2, 53, -2))).addComponent(this.JSPDetalleC, -2, 127, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.JCBTercero.removeAllItems();
            this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta FROM cc_unidadfuncionalxempresa  INNER JOIN cc_terceros ON (cc_unidadfuncionalxempresa.Id_Empresa = cc_terceros.Id) WHERE (cc_unidadfuncionalxempresa.Estado =1 AND cc_unidadfuncionalxempresa.Id_UnidadF ='" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "') ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            this.xidempresa = this.xconsultas.llenarCombo(this.xsql, this.xidempresa, this.JCBTercero);
            this.JCBTercero.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorPropuestaActionPerformed(ActionEvent evt) {
        this.JTFFValorPropuesta.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorPropuestaFocusLost(FocusEvent evt) {
        mTotalizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIvaStateChanged(ChangeEvent evt) {
        mTotalizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        JDBusquedaDocPTO x = new JDBusquedaDocPTO(null, true, this, "9", "");
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDoc.getSelectedIndex() != -1) {
            mConsecutivo();
        }
    }

    private void mConsecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(CONVERT(`NInterno`, UNSIGNED)) as MaximoCons FROM `cc_orden_compra` WHERE (`Id_TipoDocF` ='" + this.xIdTipoDoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            this.JLCodigoDoc1.setText("" + (Con + 1));
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTotalizar() {
        this.JTFFTotalIva.setValue(Double.valueOf((Double.valueOf(this.JTFFValorPropuesta.getValue().toString()).doubleValue() * Double.valueOf(this.JSPIva.getValue().toString()).doubleValue()) / 100.0d));
        this.JTFFTotal.setValue(Double.valueOf(Double.valueOf(this.JTFFValorPropuesta.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFTotalIva.getValue().toString()).doubleValue()));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBTercero.removeAllItems();
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBAdministrador.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTAObjetivoG.setText("");
        this.JTFFValorPropuesta.setValue(new Integer(0));
        this.JTFFTotalIva.setValue(new Integer(0));
        this.JTFFTotal.setValue(new Integer(0));
        this.JSPIva.setValue(new Integer(0));
        this.JCBTipoDoc.removeAllItems();
        this.xIdTipoDoc = this.xconsultas.llenarCombo("SELECT `Id` , `Nbre` FROM `cc_tipo_documentof` WHERE (`Tipo` =2)   ORDER BY `Nbre` ASC", this.xIdTipoDoc, this.JCBTipoDoc);
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.xlleno = true;
        mCargarDatosTablaCond();
        this.JDFFechaC.requestFocus();
    }

    private void mCrearTablaCond() {
        this.xmodeloc = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Aplica"}) { // from class: ComprasBS.JIFOrdenServicio.8
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodeloc);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JCBAdministrador.getSelectedIndex() != -1) {
                    if (this.JCBTipoDoc.getSelectedIndex() == -1) {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoDoc.requestFocus();
                        return;
                    }
                    if (Double.valueOf(this.JTFFTotal.getValue().toString()).doubleValue() != 0.0d) {
                        if (!mPresupuesto()) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                String sql = "insert into cc_orden_compra (FechaC, Id_Tercero, Id_UnidadF,NInterno, Id_TipoDocF, ObjetivoG, Observacion, ValorP, Iva, Id_Administrador, IdDisponibilidad, Fecha, UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "','" + this.JLCodigoDoc1.getText() + "','" + this.xIdTipoDoc[this.JCBTipoDoc.getSelectedIndex()] + "','" + this.JTAObjetivoG.getText() + "','" + this.JTAObservacion.getText() + "','" + this.JTFFValorPropuesta.getValue() + "','" + this.JSPIva.getValue() + "','" + this.xiadministrador[this.JCBAdministrador.getSelectedIndex()] + "','" + this.xIdMovDisponibilidad + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                                Principal.txtEstado.setText("ACTIVA");
                                this.xconsultas.cerrarConexionBd();
                                if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalleC, 2)) {
                                    for (int y = 0; y < this.JTDetalleC.getRowCount(); y++) {
                                        if (Boolean.valueOf(this.xmodeloc.getValueAt(y, 2).toString()).booleanValue()) {
                                            String sql2 = "insert into cc_detalle_orden_compra_condiciones (Id_OrdenC, Id_TipoCondiciones) Values ('" + Principal.txtNo.getText() + "','" + this.xmodeloc.getValueAt(y, 0) + "')";
                                            this.xconsultas.ejecutarSQL(sql2);
                                            this.xconsultas.cerrarConexionBd();
                                        }
                                    }
                                }
                                mImprimir();
                                mGrabarUsuarioA();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Disponibilidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JLCodigoDoc.requestFocus();
                        this.JLCodigoDoc.setBackground(Color.red);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El Valor de la propuesta no puede ser 0", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFValorPropuesta.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un administrador", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBAdministrador.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenServicio", mparametros);
        }
    }

    public void mBuscar() {
        this.xjifbuscarorden = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.xjifbuscarorden);
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && Principal.txtEstado.getText().equals("ACTIVA")) {
            if (!this.xejecutado) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "update cc_orden_compra set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                    Principal.txtEstado.setText("ANULADO");
                    this.xsql = "SELECT g_persona.Correo FROM cc_detalle_firma_ordenc INNER JOIN cc_usuarioxdocumentof ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN g_persona  ON (cc_usuarioxdocumentof.Id_Persona = g_persona.Id) WHERE (cc_detalle_firma_ordenc.Id_OrdenC ='" + Principal.txtNo.getText() + "') ";
                    ResultSet xrs = this.xconsultas.traerRs(this.xsql);
                    try {
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                this.xmetodos.mEnvioCorreoElectronico("Se anulo la orden de servicio N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.JCBUnidadF.getSelectedItem().toString(), xrs.getString(1), "ANULACIÓN ORDEN DE SERVICIO", Principal.usuarioSistemaDTO.getLogin());
                            }
                        }
                        xrs.close();
                        this.xconsultas.cerrarConexionBd();
                        return;
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        return;
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Comprobante no se puede anular ya fue ejecutado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe registro para anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCargarDatosTablaCond() {
        try {
            mCrearTablaCond();
            ResultSet xrs = this.xconsultas.traerRs("SELECT Id, Nbre FROM cc_tipo_condiciones_compra WHERE (Estado =1) ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloc.addRow(this.xdato);
                    this.xmodeloc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloc.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloc.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarUsuarioA() {
        try {
            this.xsql = "SELECT cc_usuarioxdocumentof.Id, persona.Corre FROM persona INNER JOIN cc_usuarioxdocumentof ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) WHERE (cc_usuarioxdocumentof.MontoM <=" + this.JTFFTotal.getValue() + " AND cc_usuarioxdocumentof.Monto >=" + this.JTFFTotal.getValue() + " AND cc_usuarioxdocumentof.Id_TipoDocF =1 AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xsql = "insert into cc_detalle_firma_ordenc (Id_OrdenC, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + rs.getInt(1) + "')";
                    xct.ejecutarSQL(this.xsql);
                    xct.cerrarConexionBd();
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosOrden(long xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT cc_orden_compra.Id, cc_orden_compra.FechaC, cc_unidad_funcional.Nbre, cc_terceros.RazonSocialCompleta, cc_orden_compra.ObjetivoG, cc_orden_compra.ValorP, cc_orden_compra.Iva , cc_orden_compra.Observacion, persona.NUsuario, if(cc_orden_compra.Estado=1,'ACTIVA','ANULADA') AS Estado  FROM cc_orden_compra INNER JOIN cc_terceros ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) INNER JOIN cc_unidad_funcional ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN persona  ON (persona.Id_persona = cc_orden_compra.Id_Administrador)  WHERE (cc_orden_compra.Id ='" + xid + "')";
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                Principal.txtNo.setText(rs.getString(1));
                Principal.txtEstado.setText(rs.getString(10));
                this.JDFFechaC.setDate(rs.getDate(2));
                this.JCBUnidadF.setSelectedItem(rs.getString(3));
                this.JCBTercero.setSelectedItem(rs.getString(4));
                this.JTAObjetivoG.setText(rs.getString(5));
                this.JTFFValorPropuesta.setValue(Double.valueOf(rs.getDouble(6)));
                this.JSPIva.setValue(Double.valueOf(rs.getDouble(7)));
                this.JTAObservacion.setText(rs.getString(8));
                this.JCBAdministrador.setSelectedItem(rs.getString(9));
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mPresupuesto() {
        boolean xPto = false;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && this.JLCodigoDoc.getText().equals("0")) {
            xPto = true;
        }
        return xPto;
    }
}
