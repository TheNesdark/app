package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFUnidadFuncional.class */
public class JIFUnidadFuncional extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xestadoc = 1;
    private boolean xestadog = false;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloc;
    private DefaultTableModel xmodelouf;
    String[] xidpuc;
    String[] xiduf;
    private Object[] xdatos;
    private JButton JBTAdicionar;
    private JButton JBTAdicionar1;
    private JComboBox JCBCuenta;
    private JComboBox JCBUnidadF;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoC;
    private JPanel JPCuenta;
    private JPanel JPICuentasDep;
    private JPanel JPICuentasMovi;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JPanel JPIUFRrhh;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPDetalleUF;
    private JSpinner JSPPorcentaje;
    private JTable JTDetalle;
    private JTable JTDetalleC;
    private JTable JTDetalleUF;
    private JTextField JTFD_Credito;
    private JTextField JTFD_Debito;
    private JFormattedTextField JTFFValorPpto;
    private JTextField JTFM_Credito;
    private JTextField JTFM_Debito;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosUF;

    public JIFUnidadFuncional() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v102, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v136, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v78, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFValorPpto = new JFormattedTextField();
        this.JSPPorcentaje = new JSpinner();
        this.JPICuentasMovi = new JPanel();
        this.JTFM_Debito = new JTextField();
        this.JTFM_Credito = new JTextField();
        this.JPICuentasDep = new JPanel();
        this.JTFD_Debito = new JTextField();
        this.JTFD_Credito = new JTextField();
        this.JTPDatosUF = new JTabbedPane();
        this.JPCuenta = new JPanel();
        this.JCBCuenta = new JComboBox();
        this.JCHEstadoC = new JCheckBox();
        this.JBTAdicionar = new JButton();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JPIUFRrhh = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JBTAdicionar1 = new JButton();
        this.JSPDetalleUF = new JScrollPane();
        this.JTDetalleUF = new JTable();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("ÁREA FUNCIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifareafuncional");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFUnidadFuncional.1
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadFuncional.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFValorPpto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor PPTO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPpto.setHorizontalAlignment(4);
        this.JTFFValorPpto.setText("0");
        this.JTFFValorPpto.setFont(new Font("Arial", 1, 13));
        this.JSPPorcentaje.setFont(new Font("Arial", 1, 13));
        this.JSPPorcentaje.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPorcentaje.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPICuentasMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Puc Depreciación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFM_Debito.setFont(new Font("Arial", 1, 12));
        this.JTFM_Debito.setToolTipText("");
        this.JTFM_Debito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFM_Credito.setFont(new Font("Arial", 1, 12));
        this.JTFM_Credito.setToolTipText("");
        this.JTFM_Credito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasMoviLayout = new GroupLayout(this.JPICuentasMovi);
        this.JPICuentasMovi.setLayout(JPICuentasMoviLayout);
        JPICuentasMoviLayout.setHorizontalGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasMoviLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFM_Debito, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFM_Credito, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasMoviLayout.setVerticalGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasMoviLayout.createSequentialGroup().addGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFM_Debito, -2, -1, -2).addComponent(this.JTFM_Credito, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JPICuentasDep.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Puc para de Baja", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFD_Debito.setFont(new Font("Arial", 1, 12));
        this.JTFD_Debito.setToolTipText("");
        this.JTFD_Debito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFD_Credito.setFont(new Font("Arial", 1, 12));
        this.JTFD_Credito.setToolTipText("");
        this.JTFD_Credito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasDepLayout = new GroupLayout(this.JPICuentasDep);
        this.JPICuentasDep.setLayout(JPICuentasDepLayout);
        JPICuentasDepLayout.setHorizontalGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDepLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFD_Debito, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFD_Credito, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasDepLayout.setVerticalGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDepLayout.createSequentialGroup().addGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFD_Debito, -2, -1, -2).addComponent(this.JTFD_Credito, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 450, -2).addGap(18, 18, 18).addComponent(this.JSPPorcentaje, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFValorPpto, -2, 136, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPICuentasMovi, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPICuentasDep, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JTFFValorPpto, -2, -1, -2).addComponent(this.JSPPorcentaje, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICuentasDep, -2, -1, -2).addComponent(this.JPICuentasMovi, -2, -1, -2)).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JTPDatosUF.setForeground(new Color(0, 103, 0));
        this.JTPDatosUF.setFont(new Font("Arial", 1, 14));
        this.JCBCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.setEnabled(false);
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFUnidadFuncional.2
            public void itemStateChanged(ItemEvent evt) {
                JIFUnidadFuncional.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCHEstadoC.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoC.setSelected(true);
        this.JCHEstadoC.setText("Estado");
        this.JCHEstadoC.setEnabled(false);
        this.JCHEstadoC.addActionListener(new ActionListener() { // from class: Contabilidad.JIFUnidadFuncional.3
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadFuncional.this.JCHEstadoCActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.setEnabled(false);
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFUnidadFuncional.4
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadFuncional.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFUnidadFuncional.5
            public void mouseClicked(MouseEvent evt) {
                JIFUnidadFuncional.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        GroupLayout JPCuentaLayout = new GroupLayout(this.JPCuenta);
        this.JPCuenta.setLayout(JPCuentaLayout);
        JPCuentaLayout.setHorizontalGroup(JPCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCuentaLayout.createSequentialGroup().addContainerGap().addGroup(JPCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleC).addGroup(JPCuentaLayout.createSequentialGroup().addComponent(this.JCBCuenta, -2, 474, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 140, -2))).addContainerGap()));
        JPCuentaLayout.setVerticalGroup(JPCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCuentaLayout.createSequentialGroup().addContainerGap().addGroup(JPCuentaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPCuentaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCuenta, -1, 50, 32767).addComponent(this.JCHEstadoC))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleC, -1, 115, 32767).addContainerGap()));
        this.JTPDatosUF.addTab("CUENTA POR UNIDAD FUNCIONAL", this.JPCuenta);
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "UNIDAD FUNCIONAL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.setEnabled(false);
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: Contabilidad.JIFUnidadFuncional.6
            public void itemStateChanged(ItemEvent evt) {
                JIFUnidadFuncional.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar1.setText("Adicionar");
        this.JBTAdicionar1.setEnabled(false);
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFUnidadFuncional.7
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadFuncional.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        this.JSPDetalleUF.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleUF.setFont(new Font("Arial", 1, 12));
        this.JTDetalleUF.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleUF.setRowHeight(25);
        this.JTDetalleUF.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFUnidadFuncional.8
            public void mouseClicked(MouseEvent evt) {
                JIFUnidadFuncional.this.JTDetalleUFMouseClicked(evt);
            }
        });
        this.JSPDetalleUF.setViewportView(this.JTDetalleUF);
        GroupLayout JPIUFRrhhLayout = new GroupLayout(this.JPIUFRrhh);
        this.JPIUFRrhh.setLayout(JPIUFRrhhLayout);
        JPIUFRrhhLayout.setHorizontalGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 707, 32767).addGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUFRrhhLayout.createSequentialGroup().addContainerGap().addGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleUF).addGroup(JPIUFRrhhLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 537, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar1, -2, 140, -2))).addContainerGap())));
        JPIUFRrhhLayout.setVerticalGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 193, 32767).addGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUFRrhhLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIUFRrhhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar1, -1, 50, 32767).addComponent(this.JCBUnidadF, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleUF, -1, 115, 32767).addGap(11, 11, 11))));
        this.JTPDatosUF.addTab("UNIDAD FUNCIONAL RRHH", this.JPIUFRrhh);
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPDatosUF, -2, 709, -2).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosUF, -2, 224, -2).addContainerGap(12, 32767)));
        this.JTPDatos.addTab("DATOS", this.JPIDetalle);
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFUnidadFuncional.9
            public void mouseClicked(MouseEvent evt) {
                JIFUnidadFuncional.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("HISTÓRICO", this.JSPDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 454, -2).addContainerGap(-1, 32767)));
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
            this.JSPPorcentaje.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JTFFValorPpto.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JTFM_Debito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTFM_Credito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JTFD_Debito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTFD_Credito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            mCargarDatosTablaC();
            mCargarDatosTablaUf();
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoC.isSelected()) {
            this.xestadoc = 1;
        } else {
            this.xestadoc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.JCBCuenta.getSelectedIndex() != -1) {
            this.JBTAdicionar.setEnabled(true);
        } else {
            this.JBTAdicionar.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabarC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            this.JCBCuenta.setSelectedItem(this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString() + "-" + this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString());
            this.JCHEstadoC.setSelected(Boolean.valueOf(this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstadoC.isSelected()) {
                this.xestadoc = 1;
            } else {
                this.xestadoc = 0;
            }
            this.xestadog = true;
            this.JBTAdicionar.setEnabled(true);
            return;
        }
        this.xestadog = false;
        this.JBTAdicionar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleUFMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
        mGrabarUF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.JCBUnidadF.getSelectedIndex() != -1) {
            this.JBTAdicionar1.setEnabled(true);
        } else {
            this.JBTAdicionar1.setEnabled(false);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFD_Credito.setText("");
        this.JTFD_Debito.setText("");
        this.JTFM_Credito.setText("");
        this.JTFM_Debito.setText("");
        this.JSPPorcentaje.setValue(new Integer(0));
        this.JTFFValorPpto.setValue(new Double(0.0d));
        this.JCHEstado.setSelected(true);
        this.JCBCuenta.removeAllItems();
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.xidpuc = this.xconsulta.llenarCombo("SELECT Id, CONCAT(Id ,'-',Nbre) AS grupo , Nivel FROM cc_puc WHERE (Id_Nivel in(3,4)) ORDER BY Id ASC", this.xidpuc, this.JCBCuenta);
        } else {
            this.xidpuc = this.xconsulta.llenarCombo("SELECT Id, CONCAT(Id ,'-',Nbre) AS grupo , Nivel FROM cc_puc WHERE (Id_Nivel =3) ORDER BY Id ASC", this.xidpuc, this.JCBCuenta);
        }
        this.JCBCuenta.setSelectedIndex(-1);
        this.JCBUnidadF.removeAllItems();
        this.xiduf = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM rh_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xiduf, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
        mCrearModeloDatosC();
        this.xestado = 1;
        this.xestadoc = 1;
        this.xestadog = false;
        mCrearModeloDatosC();
        mCrearModeloDatosUf();
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into cc_unidad_funcional(Nbre, Porcetaje, ValorPpto, `M_Debito`, `M_Credito`, `D_Debito`, `D_Credito`, Estado, Fecha, UsuarioS )  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPPorcentaje.getValue() + "','" + this.JTFFValorPpto.getValue() + "','" + this.JTFM_Debito.getText() + "','" + this.JTFM_Credito.getText() + "','" + this.JTFD_Debito.getText() + "','" + this.JTFD_Credito.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update cc_unidad_funcional set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Porcetaje='" + this.JSPPorcentaje.getValue() + "', ValorPpto='" + this.JTFFValorPpto.getValue() + "',M_Debito='" + this.JTFM_Debito.getText() + "',M_Credito='" + this.JTFM_Credito.getText() + "',D_Debito='" + this.JTFD_Debito.getText() + "',D_Credito='" + this.JTFD_Credito.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    private void mGrabarC() {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBCuenta.getSelectedIndex() != -1) {
                if (this.xestadog) {
                    sql = " update cc_pucxunidad_funcional set Estado='" + this.xestadoc + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_UnidadFuncional='" + Principal.txtNo.getText() + "' and Id_Puc='" + this.xidpuc[this.JCBCuenta.getSelectedIndex()] + "'";
                } else {
                    sql = " Insert into cc_pucxunidad_funcional(Id_Puc, Id_UnidadFuncional, Estado, Fecha, UsuarioS )  values ('" + this.xidpuc[this.JCBCuenta.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.xestadoc + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTablaC();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCuenta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarUF() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBUnidadF.getSelectedIndex() != -1) {
                String sql = " Insert ignore into  cc_unidad_funcional_rrhhuf(Id_Unidad_Funcional, Id_UF_RRHH , UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xiduf[this.JCBUnidadF.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTablaUf();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadF.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "%", "Valor", "Estado", "M_Debito", "M_Credito", "D_Debito", "D_Credito"}) { // from class: Contabilidad.JIFUnidadFuncional.10
            Class[] types = {Long.class, String.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(220);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosUf() {
        this.xmodelouf = new DefaultTableModel(new Object[0], new String[]{"Unidad Funcional"}) { // from class: Contabilidad.JIFUnidadFuncional.11
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleUF.setModel(this.xmodelouf);
        this.JTDetalleUF.getColumnModel().getColumn(0).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC() {
        this.JCBCuenta.setSelectedIndex(-1);
        this.JCBCuenta.setEnabled(false);
        this.JCHEstadoC.setEnabled(false);
        this.JCHEstadoC.setSelected(true);
        this.xmodeloc = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: Contabilidad.JIFUnidadFuncional.12
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodeloc);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, Porcetaje, ValorPpto, Estado, `M_Debito`, `M_Credito`, `D_Debito`, `D_Credito` FROM cc_unidad_funcional ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaC() {
        try {
            mCrearModeloDatosC();
            this.JCBCuenta.setEnabled(true);
            this.JCHEstadoC.setEnabled(true);
            String sql = "SELECT cc_pucxunidad_funcional.Id_Puc, cc_puc.Nbre, cc_pucxunidad_funcional.Estado FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Id_UnidadFuncional ='" + Principal.txtNo.getText() + "') ORDER BY cc_pucxunidad_funcional.Id_Puc ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloc.addRow(this.xdatos);
                    this.xmodeloc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloc.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloc.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaUf() {
        try {
            mCrearModeloDatosUf();
            this.JCBUnidadF.setEnabled(true);
            String sql = "SELECT rh_unidad_funcional.Nbre  FROM cc_unidad_funcional_rrhhuf INNER JOIN rh_unidad_funcional  ON (cc_unidad_funcional_rrhhuf.Id_UF_RRHH = rh_unidad_funcional.Id) WHERE (cc_unidad_funcional_rrhhuf.Id_Unidad_Funcional ='" + Principal.txtNo.getText() + "') ORDER BY rh_unidad_funcional.Nbre  ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelouf.addRow(this.xdatos);
                    this.xmodelouf.setValueAt(xrs.getString(1), n, 0);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mExportar() throws IOException {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
            WritableSheet sheet = workbook.createSheet("plantilla", 0);
            sheet.addCell(new Label(0, 0, "Unidad Funcional"));
            sheet.addCell(new Label(1, 0, "Cuenta"));
            sheet.addCell(new Label(2, 0, "Nombre"));
            ConsultasMySQL xt2 = new ConsultasMySQL();
            ResultSet rs = xt2.traerRs("SELECT cc_unidad_funcional.Nbre, cc_puc.Id, cc_puc.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) INNER JOIN cc_puc ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) ORDER BY cc_unidad_funcional.Nbre ASC, cc_puc.Id ASC ");
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 1;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            workbook.write();
            workbook.close();
        } catch (WriteException e) {
            Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex2) {
            Logger.getLogger(JIFUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }
}
