package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entity.NominaNovedadesDetalle;
import com.genoma.plus.jpa.entity.NominaNovedadesEncabezado;
import com.genoma.plus.jpa.service.DetalleNovedadesNominaService;
import com.genoma.plus.jpa.service.EncabezadoNovedadesNominaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFReporteHorasExtras.class */
public class JIFReporteHorasExtras extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String xsql;
    private Object[] xdato;
    private String[] xidtiponovedad;
    private String[] xPeriodoNomina;
    private String[][] xidtipoconcepto;
    private JButton JBTCarguesA;
    private JComboBox JCBConcepto;
    private JComboBox JCBPeriodoNomina;
    private JComboBox JCBTipoReporte;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JDateChooser JDFFechaR;
    private JPanel JPIDatos;
    private JPanel JPIDatosR;
    private JPanel JPIPeriodo;
    private JPanel JPIPeriodo1;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNHoras;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFHoraFin;
    private JFormattedTextField JTFFHoraInicio;
    private JButton jButton1;
    public JTextField jTextField1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xnfila = -1;
    public Integer idPersona = 0;
    public Double salarioEmpleado = Double.valueOf(0.0d);
    private EncabezadoNovedadesNominaService encabezadoNovedadesNomina = (EncabezadoNovedadesNominaService) Principal.contexto.getBean(EncabezadoNovedadesNominaService.class);
    private DetalleNovedadesNominaService detalleNovedadesNominaService = (DetalleNovedadesNominaService) Principal.contexto.getBean(DetalleNovedadesNominaService.class);

    public JIFReporteHorasExtras() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v100, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JPIPeriodo = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCBTipoReporte = new JComboBox();
        this.JCBPeriodoNomina = new JComboBox();
        this.jButton1 = new JButton();
        this.jTextField1 = new JTextField();
        this.JPIDatosR = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JCBConcepto = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JSPNHoras = new JSpinner();
        this.JBTCarguesA = new JButton();
        this.JPIPeriodo1 = new JPanel();
        this.JTFFHoraFin = new JFormattedTextField();
        this.JTFFHoraInicio = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setTitle("REPORTE DE RECARGOS Y HORA EXTRAS");
        setFrameIcon(null);
        setName("xjifreportehorasextras");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período Laborado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIPeriodoLayout = new GroupLayout(this.JPIPeriodo);
        this.JPIPeriodo.setLayout(JPIPeriodoLayout);
        JPIPeriodoLayout.setHorizontalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 109, -2).addContainerGap(48, 32767)));
        JPIPeriodoLayout.setVerticalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)));
        this.JCBTipoReporte.setFont(new Font("Arial", 1, 12));
        this.JCBTipoReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoReporte.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.1
            public void itemStateChanged(ItemEvent evt) {
                JIFReporteHorasExtras.this.JCBTipoReporteItemStateChanged(evt);
            }
        });
        this.JCBPeriodoNomina.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Nomina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodoNomina.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.2
            public void itemStateChanged(ItemEvent evt) {
                JIFReporteHorasExtras.this.JCBPeriodoNominaItemStateChanged(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Empleado");
        this.jButton1.setToolTipText("");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.3
            public void actionPerformed(ActionEvent evt) {
                JIFReporteHorasExtras.this.jButton1ActionPerformed(evt);
            }
        });
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setToolTipText("");
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIPeriodo, -1, -1, 32767).addComponent(this.JCBTipoReporte, 0, -1, 32767)).addGap(40, 40, 40).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodoNomina, -2, 280, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTextField1, -2, 299, -2))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoReporte, -2, -1, -2).addComponent(this.JCBPeriodoNomina, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPeriodo, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTextField1, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGap(31, 31, 31)));
        this.JPIDatosR.setBorder(BorderFactory.createTitledBorder((Border) null, "REPORTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JSPNHoras.setFont(new Font("Arial", 1, 12));
        this.JSPNHoras.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNHoras.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Adicionar");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.4
            public void actionPerformed(ActionEvent evt) {
                JIFReporteHorasExtras.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JPIPeriodo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Horas", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFHoraFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFHoraFin.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHoraFin.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFHoraInicio.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHoraInicio.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIPeriodo1Layout = new GroupLayout(this.JPIPeriodo1);
        this.JPIPeriodo1.setLayout(JPIPeriodo1Layout);
        JPIPeriodo1Layout.setHorizontalGroup(JPIPeriodo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPeriodo1Layout.createSequentialGroup().addContainerGap(34, 32767).addComponent(this.JTFFHoraInicio, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraFin, -2, 136, -2).addContainerGap()));
        JPIPeriodo1Layout.setVerticalGroup(JPIPeriodo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodo1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraFin).addComponent(this.JTFFHoraInicio)));
        GroupLayout JPIDatosRLayout = new GroupLayout(this.JPIDatosR);
        this.JPIDatosR.setLayout(JPIDatosRLayout);
        JPIDatosRLayout.setHorizontalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addComponent(this.JPIPeriodo1, -2, -1, -2).addGap(567, 567, 567)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosRLayout.createSequentialGroup().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTCarguesA, -1, -1, 32767).addGroup(JPIDatosRLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 109, -2).addGap(2, 2, 2).addComponent(this.JCBConcepto, -2, 353, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNHoras, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 419, 32767))).addContainerGap()))));
        JPIDatosRLayout.setVerticalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNHoras, -2, 46, -2).addComponent(this.JCBConcepto, -2, -1, -2)).addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, -1, -2).addComponent(this.JDFFechaR, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.JPIPeriodo1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCarguesA, -2, 44, -2)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.5
            public void keyPressed(KeyEvent evt) {
                JIFReporteHorasExtras.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosR, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JPIDatosR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 182, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoReporteItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoReporte.getSelectedIndex() != -1 && this.xlleno) {
            this.JCBConcepto.removeAllItems();
            this.xsql = "SELECT rh_nomina_novedad_concepto.Id, rh_nomina_conceptos.Nbre,rh_nomina_conceptos .Id as idConcepto, `rh_nomina_conceptos`.`Valor` as valor FROM rh_nomina_novedad_concepto INNER JOIN rh_nomina_conceptos  ON (rh_nomina_novedad_concepto.Id_Concepto = rh_nomina_conceptos.Id) WHERE (rh_nomina_novedad_concepto.Estado =1 AND rh_nomina_novedad_concepto.Id_Novedad ='" + this.xidtiponovedad[this.JCBTipoReporte.getSelectedIndex()] + "' AND rh_nomina_conceptos.ReporteU =1) ORDER BY rh_nomina_conceptos.Nbre ASC ";
            System.out.println(this.xsql);
            this.xidtipoconcepto = this.xct.llenarComboyLista(this.xsql, this.xidtipoconcepto, this.JCBConcepto, 4);
            this.xPeriodoNomina = this.xct.llenarCombo("SELECT Id, Nbre  FROM `rh_nomina_periodo` WHERE Estado = 1", this.xPeriodoNomina, this.JCBPeriodoNomina);
            this.JCBPeriodoNomina.setSelectedIndex(-1);
            this.JCBConcepto.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1);
            this.JCBConcepto.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPNHoras.getValue().toString()).doubleValue() > 0.0d) {
            this.xnfila++;
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(this.xmt.formatoAMD.format(this.JDFFechaR.getDate()), this.xnfila, 0);
            this.xmodelo.setValueAt(this.xidtipoconcepto[this.JCBConcepto.getSelectedIndex()][0], this.xnfila, 1);
            this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 2);
            this.xmodelo.setValueAt(this.JSPNHoras.getValue(), this.xnfila, 3);
            this.xmodelo.setValueAt(this.JTAObservacion.getText(), this.xnfila, 4);
            this.xmodelo.setValueAt(this.xmt.formatoH24.format(this.JTFFHoraInicio.getValue()), this.xnfila, 5);
            this.xmodelo.setValueAt(this.xmt.formatoH24.format(this.JTFFHoraFin.getValue()), this.xnfila, 6);
            this.xmodelo.setValueAt(this.xidtipoconcepto[this.JCBConcepto.getSelectedIndex()][1], this.xnfila, 7);
            System.out.println("prueba " + this.xidtipoconcepto[this.JCBConcepto.getSelectedIndex()][2]);
            this.xmodelo.setValueAt(Double.valueOf(Double.parseDouble(this.xidtipoconcepto[this.JCBConcepto.getSelectedIndex()][2])), this.xnfila, 8);
            this.JDFFechaR.setDate(this.xmt.getFechaActual());
            this.JCBConcepto.setSelectedIndex(-1);
            this.JSPNHoras.setValue(new Double(0.0d));
            this.JTAObservacion.setText("");
            this.JCBConcepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "N Horas debe ser mayor que cero", "VERIFICAR", 1);
        this.JSPNHoras.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3);
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                this.xnfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoNominaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        BusquedaEmpleado busquedaEmpleadoDialog = new BusquedaEmpleado(null, true, this);
        busquedaEmpleadoDialog.setVisible(true);
    }

    public void mNuevo() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBConcepto.removeAllItems();
        this.JCBTipoReporte.removeAllItems();
        this.xsql = "SELECT rh_nomina_tipo_novedades.Id , rh_nomina_tipo_novedades.Nbre FROM rh_nomina_novedad_concepto INNER JOIN rh_nomina_tipo_novedades  ON (rh_nomina_novedad_concepto.Id_Novedad = rh_nomina_tipo_novedades.Id) INNER JOIN rh_nomina_conceptos  ON (rh_nomina_novedad_concepto.Id_Concepto = rh_nomina_conceptos.Id) WHERE (  rh_nomina_tipo_novedades.ReporteU =1 AND rh_nomina_tipo_novedades.Estado =1) GROUP BY rh_nomina_tipo_novedades.Id ORDER BY rh_nomina_tipo_novedades.Nbre ASC ";
        this.xidtiponovedad = this.xct.llenarCombo(this.xsql, this.xidtiponovedad, this.JCBTipoReporte);
        this.JCBTipoReporte.setSelectedIndex(-1);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        this.xlleno = true;
        this.JTFFHoraInicio.setValue(this.xmt.getFechaActual());
        this.JTFFHoraFin.setValue(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Id", "Concepto", "Cant", "Observación", "Hora Inicio", "Hora Fin", "conceptoN", "%"}) { // from class: com.genoma.plus.controller.rrhh.JIFReporteHorasExtras.6
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.xnfila = -1;
    }

    public void mGrabar() {
        System.out.println("Grabar");
        DateTimeFormatter.ofPattern("dd-MM-yyyy");
        NominaNovedadesEncabezado novedadesEncabezado = NominaNovedadesEncabezado.builder().idTercero(this.idPersona).fechaD(LocalDate.now()).idPeriodo(Integer.valueOf(Integer.parseInt(this.xPeriodoNomina[this.JCBPeriodoNomina.getSelectedIndex()]))).usuario(Principal.usuarioSistemaDTO.getLogin()).build();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<NominaNovedadesDetalle> listaDetalle = new ArrayList<>();
        for (int j = 0; j < this.JTDetalle.getRowCount(); j++) {
            Date date = new Date();
            try {
                date = new SimpleDateFormat("yyyy/MM/dd").parse(this.xmodelo.getValueAt(j, 0).toString());
            } catch (ParseException ex) {
                Logger.getLogger(JIFReporteHorasExtras.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            NominaNovedadesDetalle nominaNovedadesDetalle = NominaNovedadesDetalle.builder().cantidad(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(j, 3).toString()))).estado(true).nominaNovedadesEncabezado(novedadesEncabezado).horaFin(LocalTime.parse(this.xmodelo.getValueAt(j, 6).toString(), formatter)).horaInicio(LocalTime.parse(this.xmodelo.getValueAt(j, 5).toString(), formatter)).idConcepto(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(j, 1).toString()))).verificado(false).fechaD(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).fechaInicio(this.JDFFechaI.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).fechaFin(this.JDFFechaF.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).valor(obtenerSalario(Integer.parseInt(this.xmodelo.getValueAt(j, 3).toString()), Double.parseDouble(this.xmodelo.getValueAt(j, 8).toString()))).build();
            listaDetalle.add(nominaNovedadesDetalle);
            actualizarHorasConceptoHoras(Integer.parseInt(this.xmodelo.getValueAt(j, 3).toString()), this.xmodelo.getValueAt(j, 7).toString());
        }
        novedadesEncabezado.setListaDetalle(listaDetalle);
        this.encabezadoNovedadesNomina.guardar(novedadesEncabezado);
    }

    private void actualizarHorasConceptoHoras(int cantidad, String concepto) {
        String sql = "SELECT\n    `rh_nomina_tercero_conceptos`.`Id`\n    , `rh_nomina_tercero_conceptos`.`Id_TerceroC`\n    , `rh_nomina_concepto_unidadf`.`Id_ConceptosN`\nFROM\n    `baseservercount`.`rh_nomina_tercero_conceptos`\n    INNER JOIN `baseservercount`.`rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_tercero_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)\nWHERE (`rh_nomina_tercero_conceptos`.`Id_TerceroC` = '" + this.idPersona + "' \n    AND `rh_nomina_concepto_unidadf`.`Id_ConceptosN` ='" + concepto + "')";
        String id = this.xct.traerDato(sql);
        this.xct.ejecutaSQLUpdate("UPDATE `rh_nomina_tercero_conceptos` SET `rh_nomina_tercero_conceptos`.`NHoras` = " + cantidad + " WHERE `rh_nomina_tercero_conceptos`.`Id` = " + id);
        System.out.println("id " + id);
    }

    private Double obtenerSalario(int cantidad, double porcentaje) {
        try {
            return Double.valueOf(((this.salarioEmpleado.doubleValue() * porcentaje) / 100.0d) * ((double) cantidad));
        } catch (Exception e) {
            System.out.println("error");
            return Double.valueOf(0.0d);
        }
    }
}
