package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFRegistroIndicadores.class */
public class JIFRegistroIndicadores extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[] xidentidad;
    private String[] xidtipoproceso;
    private String[] xidperiodo;
    private String xsql;
    private Object[] xdato;
    private JButton JBTActulizarD;
    private JButton JBTGenerar;
    private JComboBox JCBEntidad;
    private JComboBox JCBPeriodo;
    private JComboBox JCBProceso;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPIDatosB;
    private JPanel JPIDatosG;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalleC;
    private JYearChooser JYCAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFRegistroIndicadores() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosB = new JPanel();
        this.JCBProceso = new JComboBox();
        this.JCBEntidad = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JBTActulizarD = new JButton();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JPIDatosG = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE INDICADORES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifregistroindicadores");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFRegistroIndicadores.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroIndicadores.this.formInternalFrameClosing(evt);
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
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEntidad.setFont(new Font("Arial", 1, 12));
        this.JCBEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Reporte a Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 13));
        this.JBTActulizarD.setFont(new Font("Arial", 1, 12));
        this.JBTActulizarD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActulizarD.setText("Actualizar");
        this.JBTActulizarD.addActionListener(new ActionListener() { // from class: Sgc.JIFRegistroIndicadores.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroIndicadores.this.JBTActulizarDActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JCBProceso, -2, 321, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEntidad, 0, 605, 32767)).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 431, 32767).addComponent(this.JBTActulizarD, -2, 275, -2))).addContainerGap()));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProceso, -2, 50, -2).addComponent(this.JCBEntidad, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTActulizarD, -1, -1, 32767).addComponent(this.JDFFechaI, -1, 45, 32767).addComponent(this.JDFFechaF, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(1);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JPIDatosG.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA GENERACIÓN DE INDICADORES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo a Reportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Sgc.JIFRegistroIndicadores.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroIndicadores.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosGLayout = new GroupLayout(this.JPIDatosG);
        this.JPIDatosG.setLayout(JPIDatosGLayout);
        JPIDatosGLayout.setHorizontalGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 226, -2).addGap(18, 18, 18).addComponent(this.JYCAno, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion, -1, 444, 32767).addGap(18, 18, 18).addComponent(this.JBTGenerar).addContainerGap()));
        JPIDatosGLayout.setVerticalGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacion, -2, -1, -2).addComponent(this.JBTGenerar, -1, 52, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosGLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JYCAno, -2, -1, -2).addComponent(this.JCBPeriodo, -2, 50, -2)))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatosG, -1, -1, 32767).addContainerGap()).addComponent(this.JSPDetalleC, -1, 968, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIDatosB, -1, -1, 32767).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleC, -2, 317, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosG, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActulizarDActionPerformed(ActionEvent evt) {
        mConsultarDatosIndicador();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            mGenerarArchivo();
        }
    }

    private String mCargarDirectorio() {
        String directorio = "C:\\";
        JFileChooser dir = new JFileChooser(directorio);
        dir.setFileSelectionMode(1);
        int returnVal = dir.showOpenDialog(this);
        if (returnVal == 0) {
            directorio = dir.getSelectedFile().toString();
        }
        return directorio + "\\";
    }

    private void mGenerarArchivo() {
        String dir = mCargarDirectorio();
        this.xsql = "SELECT g_ips.Identificacion, g_ips.DigitoVerificacion, g_ips.CodigoOrganismo, s_sgc_periodos.Codigo, s_sgc_i_reporte.Ano, s_sgc_i_fichatecnica.Codigo, s_sgc_i_reporte_detalle.Numerador, s_sgc_i_reporte_detalle.Denominador, s_sgc_i_reporte_detalle.Resultado, g_tipoentidad.RColumna, CONCAT(g_ips.CodigoOrganismo,'',s_sgc_i_reporte.Ano,'',g_tipoentidad.CodigoA) AS NArchivo, s_sgc_i_reporte_detalle.Id_FichaTecnica     FROM g_ips, s_sgc_i_reporte_detalle INNER JOIN s_sgc_i_reporte  ON (s_sgc_i_reporte_detalle.Id_Reporte = s_sgc_i_reporte.Id) INNER JOIN s_sgc_periodos  ON (s_sgc_i_reporte.Id_Periodo = s_sgc_periodos.Id) INNER JOIN g_tipoentidad  ON (s_sgc_i_reporte.Id_TipoReporte = g_tipoentidad.Id) INNER JOIN s_sgc_i_fichatecnica  ON (s_sgc_i_reporte_detalle.Id_FichaTecnica = s_sgc_i_fichatecnica.Id) WHERE (s_sgc_i_reporte.Id ='" + Principal.txtNo.getText() + "') ORDER BY s_sgc_i_reporte_detalle.Id_FichaTecnica ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                FileWriter fw = new FileWriter(dir + "\\" + xrs.getString(11) + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salArch = new PrintWriter(bw);
                if (xrs.getBoolean(10)) {
                    String xdato1 = xrs.getString(1) + "," + xrs.getString(2) + "," + xrs.getString(3) + "," + xrs.getString(4) + "," + xrs.getString(5) + ",";
                    String xdato2 = "";
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        xdato2 = xdato2 + xrs.getString(9) + ",";
                    }
                    salArch.println(xdato1 + xdato2.substring(0, xdato2.length() - 1));
                    salArch.close();
                } else {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String xdato12 = xrs.getString(1) + "," + xrs.getString(2) + "," + xrs.getString(3) + "," + xrs.getString(4) + "," + xrs.getString(5) + "," + xrs.getString(6) + "," + xrs.getString(7) + "," + xrs.getString(8);
                        salArch.println(xdato12);
                    }
                    salArch.close();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (IOException ex) {
            Logger.getLogger(JIFRegistroIndicadores.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFRegistroIndicadores.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBProceso.removeAllItems();
        this.xidtipoproceso = this.xct.llenarCombo("SELECT s_sgc_tipoproceso.Id , s_sgc_tipoproceso.Nbre FROM s_sgc_i_fichatecnica INNER JOIN s_sgc_tipoproceso  ON (s_sgc_i_fichatecnica.Id_TipoProceso = s_sgc_tipoproceso.Id) GROUP BY s_sgc_tipoproceso.Id ORDER BY s_sgc_tipoproceso.Nbre ASC", this.xidtipoproceso, this.JCBProceso);
        this.xct.cerrarConexionBd();
        if (this.xidtipoproceso.length < 1) {
            this.JCBProceso.setSelectedIndex(-1);
        } else {
            this.JCBProceso.setSelectedIndex(0);
        }
        this.JCBEntidad.removeAllItems();
        this.xidentidad = this.xct.llenarCombo("SELECT g_tipoentidad.Id, g_tipoentidad.Nbre FROM s_sgc_i_fichatecnica INNER JOIN g_tipoentidad  ON (s_sgc_i_fichatecnica.Id_TipoEntidad = g_tipoentidad.Id) GROUP BY g_tipoentidad.Id ORDER BY g_tipoentidad.Nbre ASC", this.xidentidad, this.JCBEntidad);
        this.xct.cerrarConexionBd();
        if (this.xidentidad.length < 1) {
            this.JCBEntidad.setSelectedIndex(-1);
        } else {
            this.JCBEntidad.setSelectedIndex(0);
        }
        this.JCBPeriodo.removeAllItems();
        this.xidperiodo = this.xct.llenarCombo("SELECT Id, Nbre, Estado FROM s_sgc_periodos WHERE (Estado =1) ORDER BY Id ASC", this.xidperiodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        if (this.xidperiodo.length < 1) {
            this.JCBPeriodo.setSelectedIndex(-1);
        } else {
            this.JCBPeriodo.setSelectedIndex(0);
        }
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTAObservacion.setText("");
        this.JCBPeriodo.setSelectedIndex(-1);
        mCrearTablaDetalleTipo();
    }

    public void mBuscar() {
        if (this.JCBProceso.getSelectedIndex() != -1) {
            if (this.JCBEntidad.getSelectedIndex() != -1) {
                mLlenarDetalle();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una entidad", "VERIFICAR", 1);
                this.JCBEntidad.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1);
        this.JCBProceso.requestFocus();
    }

    private void mCrearTablaDetalleTipo() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "V/Numerador", "V/Demonimador", "Resultado", "IdSql1", "IdSql2", "C?"}) { // from class: Sgc.JIFRegistroIndicadores.4
            Class[] types = {Long.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    private void mLlenarDetalle() {
        mCrearTablaDetalleTipo();
        this.xsql = "SELECT Id, Descripcion,0,0,0, Id_SqlNumerador, Id_SqlDenominador FROM s_sgc_i_fichatecnica WHERE (Estado =1 AND Id_TipoEntidad ='" + this.xidentidad[this.JCBEntidad.getSelectedIndex()] + "' AND Id_TipoProceso ='" + this.xidtipoproceso[this.JCBProceso.getSelectedIndex()] + "') ORDER BY Id ASC";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), xnfila, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), xnfila, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), xnfila, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), xnfila, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), xnfila, 6);
                    this.xmodelo.setValueAt(false, xnfila, 7);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroIndicadores.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarDatosIndicador() {
        for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
            try {
                ResultSet xrs = this.xct.traerRs("SELECT ConsultaSql, NParametro FROM s_consultas_sql WHERE (Id ='" + this.xmodelo.getValueAt(x, 5) + "')");
                if (xrs.next()) {
                    xrs.first();
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    System.out.println(xrs.getString(1));
                    PreparedStatement xpt = xct1.establecerConexionBd().prepareStatement(xrs.getString(1));
                    xpt.setString(1, this.xmt.formatoAMD.format(this.JDFFechaI.getDate()));
                    xpt.setString(2, this.xmt.formatoAMD.format(this.JDFFechaF.getDate()));
                    if (xrs.getInt(2) == 3) {
                        xpt.setString(3, this.xmt.formatoAMD.format(this.JDFFechaF.getDate()));
                    }
                    ResultSet rs = xpt.executeQuery();
                    if (rs.next()) {
                        rs.last();
                        if (rs.getRow() == 1) {
                            rs.first();
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 2);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(2)), x, 3);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 4);
                            this.xmodelo.setValueAt(true, x, 7);
                        } else {
                            rs.beforeFirst();
                            long xvalor = 0;
                            long xvalor1 = 0;
                            long xvalor2 = 2;
                            while (rs.next()) {
                                xvalor += rs.getLong(1);
                                xvalor1 += rs.getLong(2);
                                xvalor2 += rs.getLong(3);
                            }
                            this.xmodelo.setValueAt(Long.valueOf(xvalor), x, 2);
                            this.xmodelo.setValueAt(Long.valueOf(xvalor1), x, 3);
                            this.xmodelo.setValueAt(Long.valueOf(xvalor2), x, 4);
                            this.xmodelo.setValueAt(true, x, 7);
                        }
                    }
                    rs.close();
                    xpt.close();
                    xct1.cerrarConexionBd();
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroIndicadores.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.xmt.mVerificarDatosLLeno(this.JTDetalleC, 7)) {
                if (this.JCBPeriodo.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "insert into s_sgc_i_reporte (Id_TProceso, Id_TipoReporte, Id_Periodo, Ano, Observacion, UsuarioS) values ('" + this.xidtipoproceso[this.JCBProceso.getSelectedIndex()] + "','" + this.xidentidad[this.JCBEntidad.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "','" + this.JYCAno.getValue() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTDetalleC.getRowCount(); y++) {
                            this.xsql = "insert into s_sgc_i_reporte_detalle (Id_Reporte, Id_FichaTecnica, Numerador, Denominador, Resultado) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 4) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selecionar el periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBPeriodo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Faltan infomación en los indicadores", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Indicadores ya grabados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }
}
