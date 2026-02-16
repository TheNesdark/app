package ParametrizacionN;

import Acceso.Principal;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFichaTecnicaIndicador.class */
public class JIFFichaTecnicaIndicador extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloc;
    private DefaultTableModel xmodelot;
    private String[] xidunidadmedida;
    private String[] xidentidad;
    private String[] xidtipoproceso;
    private String xsql;
    private Object[] xdato;
    private JComboBox JCBEntidad;
    private JComboBox JCBEntidad1;
    private JComboBox JCBProceso;
    private JComboBox JCBProceso1;
    private JComboBox JCBUnidadMedida;
    private JCheckBox JCHArchivo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPIHistorico;
    private JScrollPane JSPDDenominador;
    private JScrollPane JSPDFCalculo;
    private JScrollPane JSPDFuente;
    private JScrollPane JSPDNumerador;
    private JScrollPane JSPDescripcionI;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPDetalleS;
    private JScrollPane JSPDetalleT;
    private JSpinner JSPFrecuencia;
    private JScrollPane JSPObjetivo;
    private JTextPane JTADDenominador;
    private JTextPane JTADFCalculo;
    private JTextPane JTADFuente;
    private JTextPane JTADNumerador;
    private JTextPane JTADescripcionI;
    private JTextPane JTAObjetivo;
    private JTable JTDetalleC;
    private JTable JTDetalleS;
    private JTable JTDetalleT;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFSqlDenominador;
    private JFormattedTextField JTFFSqlNumerador;
    private JTextField JTFNArchivo;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xestado = 1;

    public JIFFichaTecnicaIndicador() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v92, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JSPDescripcionI = new JScrollPane();
        this.JTADescripcionI = new JTextPane();
        this.JSPObjetivo = new JScrollPane();
        this.JTAObjetivo = new JTextPane();
        this.JCBUnidadMedida = new JComboBox();
        this.JCHArchivo = new JCheckBox();
        this.JTFNArchivo = new JTextField();
        this.JSPDFuente = new JScrollPane();
        this.JTADFuente = new JTextPane();
        this.JSPDFCalculo = new JScrollPane();
        this.JTADFCalculo = new JTextPane();
        this.JSPDNumerador = new JScrollPane();
        this.JTADNumerador = new JTextPane();
        this.JSPDDenominador = new JScrollPane();
        this.JTADDenominador = new JTextPane();
        this.JSPFrecuencia = new JSpinner();
        this.JTFCodigo = new JTextField();
        this.JTFFSqlNumerador = new JFormattedTextField();
        this.JTFFSqlDenominador = new JFormattedTextField();
        this.JCBEntidad = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JSPDetalleT = new JScrollPane();
        this.JTDetalleT = new JTable();
        this.JCHEstado = new JCheckBox();
        this.JPIHistorico = new JPanel();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBEntidad1 = new JComboBox();
        this.JCBProceso1 = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("FICHA TÉCNICA INDICADOR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("xjiffichatecnicaindicador");
        setNormalBounds(null);
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFichaTecnicaIndicador.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDescripcionI.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionI.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionI.setViewportView(this.JTADescripcionI);
        this.JSPObjetivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObjetivo.setFont(new Font("Arial", 1, 12));
        this.JSPObjetivo.setViewportView(this.JTAObjetivo);
        this.JCBUnidadMedida.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadMedida.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Medida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHArchivo.setFont(new Font("Arial", 1, 12));
        this.JCHArchivo.setText("Archivo?");
        this.JCHArchivo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.2
            public void actionPerformed(ActionEvent evt) {
                JIFFichaTecnicaIndicador.this.JCHArchivoActionPerformed(evt);
            }
        });
        this.JTFNArchivo.setFont(new Font("Arial", 1, 12));
        this.JTFNArchivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDFuente.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Fuente de Información", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADFuente.setFont(new Font("Arial", 1, 12));
        this.JSPDFuente.setViewportView(this.JTADFuente);
        this.JSPDFCalculo.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Forma de Calculo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADFCalculo.setFont(new Font("Arial", 1, 12));
        this.JSPDFCalculo.setViewportView(this.JTADFCalculo);
        this.JSPDNumerador.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Numerador", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADNumerador.setFont(new Font("Arial", 1, 12));
        this.JSPDNumerador.setViewportView(this.JTADNumerador);
        this.JSPDDenominador.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Denominador", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADDenominador.setFont(new Font("Arial", 1, 12));
        this.JSPDDenominador.setViewportView(this.JTADDenominador);
        this.JSPFrecuencia.setFont(new Font("Arial", 1, 12));
        this.JSPFrecuencia.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSqlNumerador.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Sql Numerador", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSqlNumerador.setHorizontalAlignment(4);
        this.JTFFSqlNumerador.setFont(new Font("Arial", 1, 12));
        this.JTFFSqlNumerador.setValue(new Long(0L));
        this.JTFFSqlDenominador.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Sql Denominador", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSqlDenominador.setHorizontalAlignment(4);
        this.JTFFSqlDenominador.setFont(new Font("Arial", 1, 12));
        this.JTFFSqlDenominador.setValue(new Long(0L));
        this.JCBEntidad.setFont(new Font("Arial", 1, 12));
        this.JCBEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "CARACTERÍSTICA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setForeground(new Color(0, 0, 204));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(1);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JSPDetalleT.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE INDICADOR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleT.setFont(new Font("Arial", 1, 12));
        this.JTDetalleT.setForeground(new Color(0, 0, 204));
        this.JTDetalleT.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleT.setEditingColumn(1);
        this.JTDetalleT.setEditingRow(1);
        this.JTDetalleT.setRowHeight(25);
        this.JTDetalleT.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleT.setSelectionForeground(Color.red);
        this.JTDetalleT.setSelectionMode(0);
        this.JSPDetalleT.setViewportView(this.JTDetalleT);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.3
            public void actionPerformed(ActionEvent evt) {
                JIFFichaTecnicaIndicador.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBUnidadMedida, -2, 457, -2).addGap(18, 18, 18).addComponent(this.JCHArchivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNArchivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDescripcionI, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObjetivo)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDFuente, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDFCalculo)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDNumerador, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDDenominador, -2, 453, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPFrecuencia, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCodigo, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSqlNumerador, -2, 149, -2).addGap(10, 10, 10).addComponent(this.JTFFSqlDenominador, -2, 149, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBEntidad, -2, 237, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleT, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.JSPDetalleC, -2, 0, 32767)))).addGap(24, 24, 24)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcionI, -2, 73, -2).addComponent(this.JSPObjetivo, -2, 73, -2)).addGap(32, 32, 32).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadMedida, -2, 50, -2).addComponent(this.JCHArchivo).addComponent(this.JTFNArchivo, -2, -1, -2).addComponent(this.JCHEstado)).addGap(32, 32, 32).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDFuente, -2, 73, -2).addComponent(this.JSPDFCalculo, -2, 73, -2)).addGap(26, 26, 26).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDDenominador, -2, 73, -2).addComponent(this.JSPDNumerador, -2, 73, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFrecuencia, -2, -1, -2).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFFSqlNumerador).addComponent(this.JTFFSqlDenominador)).addGap(43, 43, 43).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEntidad, -2, 50, -2).addComponent(this.JCBProceso, -2, 50, -2)).addGap(65, 65, 65)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDetalleC, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleT, -2, 87, -2).addContainerGap()))));
        this.JTPDatos.addTab("DATOS", this.JPIDatos);
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setForeground(new Color(0, 0, 204));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleS.setEditingColumn(1);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.setSelectionMode(0);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.4
            public void mouseClicked(MouseEvent evt) {
                JIFFichaTecnicaIndicador.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO DE BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBEntidad1.setFont(new Font("Arial", 1, 12));
        this.JCBEntidad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso1.setFont(new Font("Arial", 1, 12));
        this.JCBProceso1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBProceso1, 0, 308, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEntidad1, -2, 237, -2).addGap(331, 331, 331)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProceso1, -2, 50, -2).addComponent(this.JCBEntidad1, -2, 50, -2)).addContainerGap(39, 32767)));
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleS, GroupLayout.Alignment.LEADING, -1, 902, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JSPDetalleS, -2, 410, -2).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 927, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 604, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHArchivoActionPerformed(ActionEvent evt) {
        if (this.JCHArchivo.isSelected()) {
            this.JTFNArchivo.setEnabled(true);
            this.JTFNArchivo.setText("");
            this.JTFNArchivo.requestFocus();
        } else {
            this.JTFNArchivo.setEnabled(false);
            this.JTFNArchivo.setText("");
            this.JTFNArchivo.transferFocus();
        }
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
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            try {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 0).toString());
                this.JTADescripcionI.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 1).toString());
                this.JTAObjetivo.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString());
                this.JCBUnidadMedida.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 3).toString());
                if (this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 4).toString().isEmpty()) {
                    this.JCHArchivo.setSelected(false);
                } else {
                    this.JCHArchivo.setSelected(true);
                }
                this.JTFNArchivo.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 4).toString());
                this.JTADFuente.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 5).toString());
                this.JTADFCalculo.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 6).toString());
                this.JTADNumerador.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 7).toString());
                this.JTADDenominador.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 8).toString());
                this.JSPFrecuencia.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 9).toString()));
                this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 10).toString());
                this.JTFFSqlNumerador.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 11).toString()));
                this.JTFFSqlDenominador.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 12).toString()));
                this.JCBEntidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString());
                this.JCBProceso.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 14).toString());
                this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()).booleanValue());
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()).booleanValue()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 1;
                }
                this.xsql = "SELECT Id_tipocaracteristicas FROM s_sgc_i_fichatecnica_tipocaracteristicas WHERE (Id_fichatecnicai ='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 0).toString() + "') ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int y = 0;
                    while (xrs.next()) {
                        for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
                            if (xrs.getLong(1) == Integer.valueOf(this.xmodeloc.getValueAt(x, 0).toString()).intValue()) {
                                this.xmodeloc.setValueAt(true, x, 2);
                            }
                        }
                        y++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                this.xsql = "SELECT Id_TipoIndicador FROM s_sgc_i_fichatecnica_tipoindicador WHERE (Id_fichatecnicai ='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 0).toString() + "') ";
                ResultSet xrs2 = this.xct.traerRs(this.xsql);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    int y2 = 0;
                    while (xrs2.next()) {
                        for (int x2 = 0; x2 < this.JTDetalleT.getRowCount(); x2++) {
                            if (xrs2.getLong(1) == Integer.valueOf(this.xmodelot.getValueAt(x2, 0).toString()).intValue()) {
                                this.xmodelot.setValueAt(true, x2, 2);
                            }
                        }
                        y2++;
                    }
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
                this.JTPDatos.setSelectedIndex(0);
            } catch (SQLException ex) {
                Logger.getLogger(JIFFichaTecnicaIndicador.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JTADDenominador.setText("");
        this.JTADFCalculo.setText("");
        this.JTADFuente.setText("");
        this.JTADNumerador.setText("");
        this.JTADescripcionI.setText("");
        this.JTAObjetivo.setText("");
        this.JTFCodigo.setText("");
        this.JTFNArchivo.setText("");
        this.JTFFSqlDenominador.setValue(new Integer(0));
        this.JTFFSqlNumerador.setValue(new Integer(0));
        this.JCHArchivo.setSelected(false);
        this.JCHEstado.setSelected(false);
        this.xestado = 1;
        this.JSPFrecuencia.setValue(new Integer(0));
        mLlenarDetalleCaracteristica();
        mLlenarDetalleTipo();
        mLlenarHistorico();
        this.JCBUnidadMedida.removeAllItems();
        this.xidunidadmedida = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipounidadmedida WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadmedida, this.JCBUnidadMedida);
        if (this.xidunidadmedida.length > 1) {
            this.JCBUnidadMedida.setSelectedIndex(-1);
        } else {
            this.JCBUnidadMedida.setSelectedIndex(0);
        }
        this.JCBEntidad.removeAllItems();
        this.xidentidad = this.xct.llenarCombo("SELECT Id, Nbre FROM g_tipoentidad WHERE (Es_institucion =0 AND Estado =1) ORDER BY Nbre ASC", this.xidentidad, this.JCBEntidad);
        if (this.xidentidad.length > 1) {
            this.JCBEntidad.setSelectedIndex(-1);
        } else {
            this.JCBEntidad.setSelectedIndex(0);
        }
        this.JCBProceso.removeAllItems();
        this.xidtipoproceso = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoproceso, this.JCBProceso);
        if (this.xidtipoproceso.length > 1) {
            this.JCBProceso.setSelectedIndex(-1);
        } else {
            this.JCBProceso.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JTADescripcionI.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTADescripcionI.getText().isEmpty()) {
            if (this.JCBUnidadMedida.getSelectedIndex() != -1) {
                if (this.JCBEntidad.getSelectedIndex() != -1) {
                    if (this.JCBProceso.getSelectedIndex() != -1) {
                        if (Integer.valueOf(this.JSPFrecuencia.getValue().toString()).intValue() > 0) {
                            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleC, 2)) {
                                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleT, 2)) {
                                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (y == 0) {
                                        if (Principal.txtNo.getText().isEmpty()) {
                                            this.xsql = "insert into s_sgc_i_fichatecnica ( Descripcion, Objetivo, Id_UnidadMedida, NbreArchivo, DFuenteInformacion, DFormaCalculo, DNumerador, DDenominador, Frecuencia, Codigo, Id_SqlNumerador, Id_SqlDenominador, Id_TipoEntidad, Id_TipoProceso, UsuarioS ) values('" + this.JTADescripcionI.getText() + "','" + this.JTAObjetivo.getText() + "','" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "','" + this.JTFNArchivo.getText() + "','" + this.JTADFuente.getText() + "','" + this.JTADFCalculo.getText() + "','" + this.JTADNumerador.getText() + "','" + this.JTADDenominador.getText() + "','" + this.JSPFrecuencia.getValue() + "','" + this.JTFCodigo.getText() + "','" + this.JTFFSqlNumerador.getValue() + "','" + this.JTFFSqlDenominador.getValue() + "','" + this.xidentidad[this.JCBEntidad.getSelectedIndex()] + "','" + this.xidtipoproceso[this.JCBProceso.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                            this.xct.cerrarConexionBd();
                                        } else {
                                            this.xsql = "update s_sgc_i_fichatecnica set Descripcion='" + this.JTADescripcionI.getText() + "',Objetivo='" + this.JTAObjetivo.getText() + "',Id_UnidadMedida='" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "',NbreArchivo='" + this.JTFNArchivo.getText() + "',DFuenteInformacion='" + this.JTADFuente.getText() + "',DFormaCalculo='" + this.JTADFCalculo.getText() + "',DNumerador='" + this.JTADNumerador.getText() + "',DDenominador='" + this.JTADDenominador.getText() + "',Frecuencia='" + this.JSPFrecuencia.getValue() + "',Codigo='" + this.JTFCodigo.getText() + "',Id_SqlNumerador='" + this.JTFFSqlNumerador.getValue() + "',Id_SqlDenominador='" + this.JTFFSqlDenominador.getValue() + "',Id_TipoEntidad='" + this.xidentidad[this.JCBEntidad.getSelectedIndex()] + "',Id_TipoProceso='" + this.xidtipoproceso[this.JCBProceso.getSelectedIndex()] + "',Estado='" + this.xestado + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                                            this.xct.ejecutarSQL(this.xsql);
                                            this.xct.cerrarConexionBd();
                                        }
                                        for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
                                            if (Boolean.valueOf(this.xmodeloc.getValueAt(x, 2).toString()).booleanValue()) {
                                                this.xsql = "insert ignore into  s_sgc_i_fichatecnica_tipocaracteristicas(Id_fichatecnicai, Id_tipocaracteristicas) values('" + Principal.txtNo.getText() + "','" + this.xmodeloc.getValueAt(x, 0) + "')";
                                                this.xct.ejecutarSQL(this.xsql);
                                                this.xct.cerrarConexionBd();
                                            }
                                        }
                                        for (int x2 = 0; x2 < this.JTDetalleT.getRowCount(); x2++) {
                                            if (Boolean.valueOf(this.xmodelot.getValueAt(x2, 2).toString()).booleanValue()) {
                                                this.xsql = "insert ignore into s_sgc_i_fichatecnica_tipoindicador(Id_fichatecnicai, Id_TipoIndicador) values('" + Principal.txtNo.getText() + "','" + this.xmodelot.getValueAt(x2, 0) + "')";
                                                this.xct.ejecutarSQL(this.xsql);
                                                this.xct.cerrarConexionBd();
                                            }
                                        }
                                        mLlenarHistorico();
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "No hay tipo seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTDetalleT.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "No hay característica seleccionada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTDetalleC.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Frecuencia debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JSPFrecuencia.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBProceso.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una entidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEntidad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad de medida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadMedida.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTADescripcionI.requestFocus();
    }

    private void mCrearTablaDetalleCaracteristicas() {
        this.xmodeloc = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Agregar"}) { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.5
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
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCrearTablaDetalleTipo() {
        this.xmodelot = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Agregar"}) { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.6
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleT.setModel(this.xmodelot);
        this.JTDetalleT.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleT.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleT.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleT.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleT.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Descripción", "Objetivo", "Unidad Medida", "NArchivo", "FInformacion", "DFormaCalculo", "DNumerador", "DDenominador", "Fecuencia", "Codigo", "SqlNumerador", "SqlDenominador", "Entidad", "Proceso", "Estado"}) { // from class: ParametrizacionN.JIFFichaTecnicaIndicador.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleS.setModel(this.xmodelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTDetalleS.getColumnModel().getColumn(14).setPreferredWidth(30);
        this.JTDetalleS.getColumnModel().getColumn(15).setPreferredWidth(10);
    }

    private void mLlenarDetalleCaracteristica() {
        mCrearTablaDetalleCaracteristicas();
        this.xsql = "SELECT Id, Nbre FROM s_sgc_tipocaracteristicas WHERE (Estado =1) ORDER BY Nbre ASC";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodeloc.addRow(this.xdato);
                    this.xmodeloc.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodeloc.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodeloc.setValueAt(false, xnfila, 2);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFichaTecnicaIndicador.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarDetalleTipo() {
        mCrearTablaDetalleTipo();
        this.xsql = "SELECT Id, Nbre FROM s_sgc_tipoindicador WHERE (Estado =1) ORDER BY Nbre ASC";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelot.addRow(this.xdato);
                    this.xmodelot.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelot.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelot.setValueAt(false, xnfila, 2);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFichaTecnicaIndicador.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarHistorico() {
        mCrearTablaHistorico();
        this.xsql = "SELECT s_sgc_i_fichatecnica.Id, s_sgc_i_fichatecnica.Descripcion, s_sgc_i_fichatecnica.Objetivo, s_sgc_tipounidadmedida.Nbre AS UN, s_sgc_i_fichatecnica.NbreArchivo , s_sgc_i_fichatecnica.DFuenteInformacion, s_sgc_i_fichatecnica.DFormaCalculo, s_sgc_i_fichatecnica.DNumerador, s_sgc_i_fichatecnica.DDenominador, s_sgc_i_fichatecnica.Frecuencia , s_sgc_i_fichatecnica.Codigo, s_sgc_i_fichatecnica.Id_SqlNumerador, s_sgc_i_fichatecnica.Id_SqlDenominador, g_tipoentidad.Nbre, s_sgc_tipoproceso.Nbre, s_sgc_i_fichatecnica.Estado FROM s_sgc_i_fichatecnica INNER JOIN s_sgc_tipounidadmedida  ON (s_sgc_i_fichatecnica.Id_UnidadMedida = s_sgc_tipounidadmedida.Id) INNER JOIN g_tipoentidad ON (s_sgc_i_fichatecnica.Id_TipoEntidad = g_tipoentidad.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_i_fichatecnica.Id_TipoProceso = s_sgc_tipoproceso.Id) ORDER BY s_sgc_i_fichatecnica.Descripcion ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), xnfila, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), xnfila, 8);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), xnfila, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), xnfila, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), xnfila, 11);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), xnfila, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), xnfila, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), xnfila, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), xnfila, 15);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFichaTecnicaIndicador.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
