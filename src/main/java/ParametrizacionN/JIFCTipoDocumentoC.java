package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFCTipoDocumentoC.class */
public class JIFCTipoDocumentoC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String[] xidClasificacion;
    private JComboBox<String> JCBClasificacion;
    private JCheckBox JCHAjuste;
    private JCheckBox JCHEsContable;
    private JCheckBox JCHEsEgreso;
    private JCheckBox JCHEstado;
    private JCheckBox JCHVentas;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFNConsecutivo;
    private JTextField JTFNReporte;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xescontable = 1;
    private int xesajuste = 0;
    private int xesventas = 0;
    private int xesegreso = 0;
    private Boolean xlleno = false;

    public JIFCTipoDocumentoC() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFNReporte = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JCHEsContable = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JCHAjuste = new JCheckBox();
        this.JCHVentas = new JCheckBox();
        this.JTFFNConsecutivo = new JFormattedTextField();
        this.JCHEsEgreso = new JCheckBox();
        this.JCBClasificacion = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DOCUMENTO CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifdoccontable");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCTipoDocumentoC.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNReporte.setFont(new Font("Arial", 1, 12));
        this.JTFNReporte.setToolTipText("");
        this.JTFNReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsContable.setFont(new Font("Arial", 1, 12));
        this.JCHEsContable.setSelected(true);
        this.JCHEsContable.setText("Es Contable?");
        this.JCHEsContable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.2
            public void actionPerformed(ActionEvent evt) {
                JIFCTipoDocumentoC.this.JCHEsContableActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.3
            public void actionPerformed(ActionEvent evt) {
                JIFCTipoDocumentoC.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHAjuste.setFont(new Font("Arial", 1, 12));
        this.JCHAjuste.setSelected(true);
        this.JCHAjuste.setText("Es Ajuste?");
        this.JCHAjuste.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.4
            public void actionPerformed(ActionEvent evt) {
                JIFCTipoDocumentoC.this.JCHAjusteActionPerformed(evt);
            }
        });
        this.JCHVentas.setFont(new Font("Arial", 1, 12));
        this.JCHVentas.setText("Es Ventas?");
        this.JCHVentas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.5
            public void actionPerformed(ActionEvent evt) {
                JIFCTipoDocumentoC.this.JCHVentasActionPerformed(evt);
            }
        });
        this.JTFFNConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNConsecutivo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("######"))));
        this.JTFFNConsecutivo.setHorizontalAlignment(4);
        this.JTFFNConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JCHEsEgreso.setFont(new Font("Arial", 1, 12));
        this.JCHEsEgreso.setText("Es Egreso?");
        this.JCHEsEgreso.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTipoDocumentoC.6
            public void actionPerformed(ActionEvent evt) {
                JIFCTipoDocumentoC.this.JCHEsEgresoActionPerformed(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -1, 550, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNConsecutivo, -2, 126, -2).addGap(10, 10, 10)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNReporte, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCodigo, -2, 112, -2)).addComponent(this.JCBClasificacion, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsEgreso).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsContable).addComponent(this.JCHAjuste)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHVentas)))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFFNConsecutivo, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNReporte, -2, -1, -2).addComponent(this.JTFCodigo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, -2, 50, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsContable).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAjuste).addComponent(this.JCHVentas)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsEgreso))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCTipoDocumentoC.7
            public void mouseClicked(MouseEvent evt) {
                JIFCTipoDocumentoC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 266, 32767).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNReporte.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEsContable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEsContable.isSelected()) {
                this.xescontable = 1;
            } else {
                this.xescontable = 0;
            }
            this.JCHAjuste.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHAjuste.isSelected()) {
                this.xesajuste = 1;
            } else {
                this.xesajuste = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCHVentas.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHVentas.isSelected()) {
                this.xesventas = 1;
            } else {
                this.xesventas = 0;
            }
            this.JTFFNConsecutivo.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8));
            this.JCHEsEgreso.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEsEgreso.isSelected()) {
                this.xesegreso = 1;
            } else {
                this.xesegreso = 0;
            }
            this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsContableActionPerformed(ActionEvent evt) {
        if (this.JCHEsContable.isSelected()) {
            this.xescontable = 1;
        } else {
            this.xescontable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAjusteActionPerformed(ActionEvent evt) {
        if (this.JCHAjuste.isSelected()) {
            this.xesajuste = 1;
        } else {
            this.xesajuste = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVentasActionPerformed(ActionEvent evt) {
        if (this.JCHVentas.isSelected()) {
            this.xesventas = 1;
        } else {
            this.xesventas = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsEgresoActionPerformed(ActionEvent evt) {
        if (this.JCHEsEgreso.isSelected()) {
            this.xesegreso = 1;
        } else {
            this.xesegreso = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFNReporte.setText("");
        this.JTFCodigo.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHEsContable.setSelected(true);
        this.JCHAjuste.setSelected(false);
        this.JCHVentas.setSelected(false);
        this.JCHEsEgreso.setSelected(false);
        this.JTFFNConsecutivo.setValue(new Integer(0));
        this.xescontable = 1;
        this.xestado = 1;
        this.xesajuste = 0;
        this.xesventas = 0;
        this.xesegreso = 0;
        mLLenaCombo();
        mCargarDatosTabla();
        this.JTFNombre.requestFocus();
    }

    private void mLLenaCombo() {
        this.xlleno = false;
        this.JCBClasificacion.removeAllItems();
        this.xidClasificacion = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `cc_tipo_documento_clasificacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.xidClasificacion, this.JCBClasificacion);
        this.JCBClasificacion.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBClasificacion.setSelectedIndex(-1);
        this.xlleno = true;
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    this.xsql = " Insert into cc_tipo_documentoc(Nbre, NReporte, CodigoC, EsContable,EsAjuste, EsVentas, Estado, NConsecutivo, EsEgreso, IdClasificacion, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFNReporte.getText() + "','" + this.JTFCodigo.getText().toUpperCase() + "','" + this.xescontable + "','" + this.xesajuste + "','" + this.xesventas + "','" + this.xestado + "','" + this.JTFFNConsecutivo.getValue() + "','" + this.xesegreso + "','" + this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    this.xsql = " update cc_tipo_documentoc set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',NReporte='" + this.JTFNReporte.getText() + "',CodigoC='" + this.JTFCodigo.getText().toUpperCase() + "',EsContable='" + this.xescontable + "',EsAjuste='" + this.xesajuste + "',EsVentas='" + this.xesventas + "',Estado='" + this.xestado + "',NConsecutivo='" + this.JTFFNConsecutivo.getValue() + "',EsEgreso='" + this.xesegreso + "',IdClasificacion='" + this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()] + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(this.xsql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Nombre Reporte", "Código", "Es Contable", "EsAjuste", "Estado", "EsVentas", "No Consecutivo", "EsEgreso", "Clasificacion"}) { // from class: ParametrizacionN.JIFCTipoDocumentoC.8
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Integer.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT\n    `cc_tipo_documentoc`.`Id`\n    , `cc_tipo_documentoc`.`Nbre`\n    , `cc_tipo_documentoc`.`NReporte`\n    , `cc_tipo_documentoc`.`CodigoC`\n    , `cc_tipo_documentoc`.`EsContable`\n    , `cc_tipo_documentoc`.`EsAjuste`\n    , `cc_tipo_documentoc`.`Estado`\n    , `cc_tipo_documentoc`.`EsVentas`\n    , `cc_tipo_documentoc`.`NConsecutivo`\n    , `cc_tipo_documentoc`.`EsEgreso`\n    , `cc_tipo_documento_clasificacion`.`Nbre` AS `Clasificacion`\nFROM\n    `cc_tipo_documentoc`\n    INNER JOIN `cc_tipo_documento_clasificacion` \n        ON (`cc_tipo_documentoc`.`IdClasificacion` = `cc_tipo_documento_clasificacion`.`Id`)\nORDER BY `cc_tipo_documentoc`.`Nbre` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCTipoDocumentoC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
