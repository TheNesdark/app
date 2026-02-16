package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInf1Comb2Tabla.class */
public class JIFConsultarInf1Comb2Tabla extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private String xtipofiltro;
    private Object[] xdato;
    private String xnombre;
    private String[] xiddatoc;
    private JButton JBTExportar;
    private JComboBox JCBComboxUno;
    private JCheckBox JCHFiltroR;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDatosConsolidado;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    public JTable JTConsolidado;
    public JTable JTDetalle;
    private JFormattedTextField JTFFCuatro;
    private JFormattedTextField JTFFDos;
    private JFormattedTextField JTFFTres;
    private JFormattedTextField JTFFUno;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipoc = 0;
    private boolean xlleno = false;

    public JIFConsultarInf1Comb2Tabla(String xnombre, String xtitulo) {
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JCBComboxUno = new JComboBox();
        this.JCHFiltroR = new JCheckBox();
        this.JPIDatosConsolidado = new JPanel();
        this.JTFFUno = new JFormattedTextField();
        this.JTFFDos = new JFormattedTextField();
        this.JTFFTres = new JFormattedTextField();
        this.JTFFCuatro = new JFormattedTextField();
        this.JTPDatos = new JTabbedPane();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultardatosg");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sig.JIFConsultarInf1Comb2Tabla.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFConsultarInf1Comb2Tabla.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFConsultarInf1Comb2Tabla.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInf1Comb2Tabla.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf1Comb2Tabla.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCBComboxUno.setFont(new Font("Arial", 1, 12));
        this.JCBComboxUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroR.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroR.setForeground(Color.blue);
        this.JCHFiltroR.setSelected(true);
        this.JCHFiltroR.setText("Filtro");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltroR).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBComboxUno, 0, 468, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 558, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 221, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBComboxUno, -2, -1, -2).addComponent(this.JCHFiltroR))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, 50, 32767)).addGap(11, 11, 11)));
        this.JPIDatosConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFUno.setFont(new Font("Arial", 1, 12));
        this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDos.setFont(new Font("Arial", 1, 12));
        this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTres.setFont(new Font("Arial", 1, 12));
        this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuatro.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosConsolidadoLayout = new GroupLayout(this.JPIDatosConsolidado);
        this.JPIDatosConsolidado.setLayout(JPIDatosConsolidadoLayout);
        JPIDatosConsolidadoLayout.setHorizontalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFUno, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFDos, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFTres, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFCuatro, -2, 109, -2).addContainerGap(313, 32767)));
        JPIDatosConsolidadoLayout.setVerticalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFUno, -2, -1, -2).addComponent(this.JTFFDos, -2, -1, -2).addComponent(this.JTFFTres, -2, -1, -2).addComponent(this.JTFFCuatro, -2, -1, -2)).addContainerGap(27, 32767)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTConsolidado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setEditingColumn(0);
        this.JTConsolidado.setEditingRow(0);
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setRowMargin(4);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JTConsolidado.setSelectionMode(0);
        this.JTConsolidado.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf1Comb2Tabla.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JTConsolidadoMouseClicked(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JTPDatos.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf1Comb2Tabla.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf1Comb2Tabla.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosConsolidado, -1, -1, 32767).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -1, 255, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosConsolidado, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            if (this.JTConsolidado.getRowCount() != -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTConsolidado, this.JTFRuta.getText(), getTitle());
            }
        } else if (this.JTPDatos.getSelectedIndex() == 1 && this.JTDetalle.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTConsolidado.getSelectedRow() != -1 && this.xnombre.equals("xjifremisionesxprofesional")) {
            mCargarDetalleEs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xnombre.equals("xjifremisionesxprofesional")) {
            if (this.JTDetalle.getSelectedColumn() != 8) {
                if (this.JTDetalle.getSelectedColumn() == 10) {
                    String[][] mparametros = new String[3][2];
                    mparametros[0][0] = "idremision";
                    mparametros[0][1] = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString();
                    mparametros[1][0] = "SUBREPORT_DIR";
                    mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemisionTO", mparametros);
                    return;
                }
                return;
            }
            String[][] mparametros2 = new String[4][2];
            mparametros2[0][0] = "idatencion1";
            mparametros2[0][1] = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString();
            mparametros2[1][0] = "idpaciente1";
            mparametros2[1][1] = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString();
            mparametros2[2][0] = "SUBREPORT_DIR";
            mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.xiddatoc[this.JCBComboxUno.getSelectedIndex()].equals("690")) {
                this.xmt.mGenerarGrafico(this.xmodelo1.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ", mparametros2);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.xnombre.equals("xjifremisionesxprofesional")) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.xnombre.equals("xjifremisionesxprofesional")) {
            mLLenarCombo();
        }
    }

    public void mBuscar() {
        if (this.xnombre.equals("xjifinformacionxespecialidad")) {
            this.xtipoc = 0;
            if (this.JCHFiltroR.isSelected()) {
                if (this.JCBComboxUno.getSelectedIndex() != -1) {
                    mCrearVistas();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debes de seleccionar una especialidad", "VERIFICAR", 1);
                    this.JCBComboxUno.requestFocus();
                    return;
                }
            }
            mCrearVistas();
            return;
        }
        if (this.xnombre.equals("xjifremisionesxprofesional")) {
            if (this.JCHFiltroR.isSelected()) {
                if (this.JCBComboxUno.getSelectedIndex() != -1) {
                    mCargarConsolidado();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debes de seleccionar una especialidad", "VERIFICAR", 1);
                    this.JCBComboxUno.requestFocus();
                    return;
                }
            }
            mCargarConsolidado();
        }
    }

    private void mCrearVistas_Remisiones() {
        this.xsql = "SELECT `profesional1`.`Id_Persona`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, COUNT(`g_especialidad`.`Id`) AS `Cantidad`, `profesional1`.`IdEspecialidad` as IdEsp FROM  `profesional1` INNER JOIN  `h_remisiones`  ON (`profesional1`.`Id_Persona` = `h_remisiones`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_remisiones`.`Id_EspecialidadR`) INNER JOIN `g_especialidad`  ON (`h_remisiones`.`I_Especialidad` = `g_especialidad`.`Id`) WHERE (`h_remisiones`.`Estado` =0  AND `h_remisiones`.`Fecha` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `h_remisiones`.`Fecha` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `profesional1`.`Id_Persona` ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `g_especialidad`.`Nbre` ASC ";
        this.xmt.mCrearVista("v_h_remisionesc", this.xsql);
        this.xsql = "SELECT `profesional1`.`Id_Persona`, `g_especialidad`.`Id`, `g_especialidad`.`Nbre`, COUNT(`g_especialidad`.`Id`) AS `CantidadD` FROM  `profesional1` INNER JOIN `h_remisiones`  ON (`profesional1`.`Id_Persona` = `h_remisiones`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_remisiones`.`Id_EspecialidadR`) INNER JOIN `g_especialidad`  ON (`h_remisiones`.`I_Especialidad` = `g_especialidad`.`Id`) WHERE (`h_remisiones`.`Estado` =0 AND `h_remisiones`.`Fecha` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `h_remisiones`.`Fecha` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `profesional1`.`Id_Persona`, `g_especialidad`.`Id` ";
        this.xmt.mCrearVista("v_h_remisionesd", this.xsql);
    }

    private void mEliminarVistas_Remisiones() {
        this.xsql = "DROP VIEW IF EXISTS v_h_remisionesc";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_h_remisionesd";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBComboxUno.removeAllItems();
        this.xsql = "SELECT g_especialidad.Id, g_especialidad.Nbre FROM g_especialidad INNER JOIN c_citas  ON (g_especialidad.Id = c_citas.Id_Especialidad) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC ";
        this.xiddatoc = this.xct.llenarCombo(this.xsql, this.xiddatoc, this.JCBComboxUno);
        this.JCBComboxUno.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        if (this.xnombre.equals("xjifinformacionxespecialidad")) {
            mCrearTablaConsolidado();
            mFijarTitulosCombos();
            this.JTPDatos.removeTabAt(1);
        } else if (this.xnombre.equals("xjifremisionesxprofesional")) {
            mCrearTablaConsolidado1();
            this.JPIDatosConsolidado.setVisible(false);
            this.JSPConsolidado.setSize(800, 100);
            mLLenarCombo();
        }
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBComboxUno.removeAllItems();
        this.xsql = "SELECT `profesional1`.`IdEspecialidad`, `profesional1`.`Especialidad` FROM `profesional1` INNER JOIN `h_remisiones`  ON (`profesional1`.`Id_Persona` = `h_remisiones`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_remisiones`.`Id_EspecialidadR`) WHERE (`h_remisiones`.`Estado` =0 AND `h_remisiones`.`Fecha` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `h_remisiones`.`Fecha` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `profesional1`.`IdEspecialidad` ORDER BY `profesional1`.`Especialidad` ASC ";
        this.xiddatoc = this.xct.llenarCombo(this.xsql, this.xiddatoc, this.JCBComboxUno);
        this.JCBComboxUno.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mCrearTablaConsolidado() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Especilidad", "Profesional", "NVisita", "VHora", "HCont", "HLab", "% Cumplimiento", "NCitasAsignadas", "IdProfesional", "IdEspecialidad", "Asistidas", "No Asistidas"}) { // from class: Sig.JIFConsultarInf1Comb2Tabla.8
            Class[] types = {String.class, String.class, Long.class, Long.class, Long.class, Long.class, Double.class, Long.class, Long.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodelo);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(10).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(11).setPreferredWidth(15);
    }

    private void mCrearTablaConsolidado1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdProfesional", "Especialidad", "Profesional", "EspecialidadR", "N°Rem", "N°RemEsp", "%", "Id_EspecialidaR"}) { // from class: Sig.JIFConsultarInf1Comb2Tabla.9
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Long.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTConsolidado;
        JTable jTable2 = this.JTConsolidado;
        jTable.setAutoResizeMode(0);
        this.JTConsolidado.doLayout();
        this.JTConsolidado.setModel(this.xmodelo);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"N°HC", "Usuario", "Sexo", "Edad", "Email", "Telefono", "Cargo", "UN", "Id_Atencion", "Fecha", "Id_AtencionR", "Id_Remision", "Id_Usuario"}) { // from class: Sig.JIFConsultarInf1Comb2Tabla.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Date.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
    }

    private void mCargarDetalle() {
        mCrearTablaConsolidado();
        if (this.JCHFiltroR.isSelected()) {
            this.xsql = "SELECT `v_c_citas`.Especialidad,`v_c_citas`.`NProfesional`, `v_c_citas`.`NVisitas`, `v_c_citas`.`ValorHoraC`, `v_c_citas`.`NHorasC`, `v_c_citas`.`HLaboradas` , IF(`v_c_citas`.`PCumpl` IS NULL ,0,`v_c_citas`.`PCumpl`) AS PCumplimiento , `v_c_citas`.`NCitasAsignadas` , `v_c_citas`.`IdEspecialidad` , `v_c_citas`.`Id_Persona` , IF(`v_c_citas_as`.`Cant` IS NULL,0,`v_c_citas_as`.`Cant`) AS `Asistidas` , IF(`v_c_citas_ns`.`Cant` IS NULL, 0,`v_c_citas_ns`.`Cant`)  AS `Nasistidas` FROM `v_c_citas_ns` RIGHT JOIN  `v_c_citas`  ON (`v_c_citas_ns`.`Id_Persona` = `v_c_citas`.`Id_Persona`) AND (`v_c_citas_ns`.`IdEspecialidad` = `v_c_citas`.`IdEspecialidad`) LEFT JOIN `v_c_citas_as`  ON (`v_c_citas_as`.`Id_Persona` = `v_c_citas`.`Id_Persona`) AND (`v_c_citas_as`.`IdEspecialidad` = `v_c_citas`.`IdEspecialidad`)  WHERE `v_c_citas`.`IdEspecialidad`='" + this.xiddatoc[this.JCBComboxUno.getSelectedIndex()] + "' ORDER BY `v_c_citas`.Especialidad ASC,  `v_c_citas`.`NProfesional` ASC ";
        } else {
            this.xsql = "SELECT `v_c_citas`.Especialidad,`v_c_citas`.`NProfesional`, `v_c_citas`.`NVisitas`, `v_c_citas`.`ValorHoraC`, `v_c_citas`.`NHorasC`, `v_c_citas`.`HLaboradas` , IF(`v_c_citas`.`PCumpl` IS NULL ,0,`v_c_citas`.`PCumpl`) AS PCumplimiento , `v_c_citas`.`NCitasAsignadas` , `v_c_citas`.`IdEspecialidad` , `v_c_citas`.`Id_Persona` , IF(`v_c_citas_as`.`Cant` IS NULL,0,`v_c_citas_as`.`Cant`) AS `Asistidas` , IF(`v_c_citas_ns`.`Cant` IS NULL, 0,`v_c_citas_ns`.`Cant`)  AS `Nasistidas` FROM `v_c_citas_ns` RIGHT JOIN  `v_c_citas`  ON (`v_c_citas_ns`.`Id_Persona` = `v_c_citas`.`Id_Persona`) AND (`v_c_citas_ns`.`IdEspecialidad` = `v_c_citas`.`IdEspecialidad`) LEFT JOIN `v_c_citas_as`  ON (`v_c_citas_as`.`Id_Persona` = `v_c_citas`.`Id_Persona`) AND (`v_c_citas_as`.`IdEspecialidad` = `v_c_citas`.`IdEspecialidad`) ORDER BY `v_c_citas`.Especialidad ASC,  `v_c_citas`.`NProfesional` ASC ";
        }
        System.out.println(" primera : " + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                int xvalor1 = 0;
                int xvalor2 = 0;
                int xvalor3 = 0;
                int xvalor4 = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 7);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), x, 9);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(11)), x, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), x, 11);
                    xvalor1 = (int) (((long) xvalor1) + rs.getLong(3));
                    xvalor2 = (int) (((long) xvalor2) + rs.getLong(5));
                    xvalor3 = (int) (((long) xvalor3) + rs.getLong(6));
                    xvalor4 = (int) (((long) xvalor4) + rs.getLong(8));
                    x++;
                }
                this.JTFFUno.setValue(Integer.valueOf(xvalor1));
                this.JTFFDos.setValue(Integer.valueOf(xvalor2));
                this.JTFFTres.setValue(Integer.valueOf(xvalor3));
                this.JTFFCuatro.setValue(Integer.valueOf(xvalor4));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCrearVistas() {
        this.xsql = "DROP VIEW IF EXISTS v_c_citas ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE    VIEW `v_c_citas`  AS SELECT profesional1.Especialidad, profesional1.NProfesional, g_profesional.NVisitas, g_profesional.ValorHoraC, g_profesional.NHorasC, HOUR(TIMEDIFF(MAX(c_citas.HoraFinal),MIN(c_citas.HoraInicial))) AS HLaboradas ,  ROUND((HOUR(TIMEDIFF(MAX(c_citas.HoraFinal),MIN(c_citas.HoraInicial))) / g_profesional.NHorasC)*100) AS PCumpl , COUNT(c_citas.Id) AS NCitasAsignadas , profesional1.IdEspecialidad ,profesional1.Id_Persona FROM profesional1  INNER JOIN c_citas  ON (profesional1.IdEspecialidad = c_citas.Id_Especialidad)  AND (profesional1.Id_Persona = c_citas.Id_Profesional)   INNER JOIN g_profesional  ON (c_citas.Id_Profesional = g_profesional.Id_Persona)  WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND c_citas.Fecha_Cita  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND c_citas.Id_MotivoDesistida =1)   GROUP BY profesional1.NProfesional  ORDER BY profesional1.Especialidad ASC, profesional1.NProfesional ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_c_citas_as ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_c_citas_as`  AS SELECT `profesional1`.`Id_Persona`, `profesional1`.`IdEspecialidad`   , COUNT(`c_citas`.`Id`) AS `Cant`     FROM `profesional1` INNER JOIN `c_citas`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `c_citas`.`Asistida` <>0) GROUP BY `profesional1`.`Id_Persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_c_citas_ns ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_c_citas_ns`  AS SELECT `profesional1`.`Id_Persona`, `profesional1`.`IdEspecialidad`   , COUNT(`c_citas`.`Id`) AS `Cant`     FROM `profesional1` INNER JOIN `c_citas`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `c_citas`.`Asistida` =0) GROUP BY `profesional1`.`Id_Persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDetalle();
        this.xsql = "DROP VIEW IF EXISTS v_c_citas ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_c_citas_as ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_c_citas_ns ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCargarConsolidado() {
        String sql;
        mCrearTablaConsolidado1();
        if (this.JCHFiltroR.isSelected()) {
            sql = "with maestra as (\nSELECT  gp.Id as idProfesional\n, ge.Id as idEspecialidadProfesional\n, ge.Nbre  as  nombreEspecialidadProfesional\n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2) as nombreProfesional \n, g_especialidad.Id  as idEspecialidadRemitir\n, g_especialidad.Nbre as especialidadARemitir\n-- , count(g_especialidad.Id) as cantidadRemisiones\n ,  count(g_especialidad.Id) over(PARTITION by  gp.Id) cantidadRemisiones\nFROM g_persona gp \nINNER JOIN h_atencion  ON (gp.Id = h_atencion.Id_Profesional)\ninner join g_especialidad ge  on (ge.Id=h_atencion.Id_Especialidad)\nINNER JOIN h_remisiones  ON (h_remisiones.Id_Atencion = h_atencion.Id) \nINNER JOIN g_especialidad  ON (h_remisiones.I_Especialidad = g_especialidad.Id) \nWHERE (ge.Id ='" + this.xiddatoc[this.JCBComboxUno.getSelectedIndex()] + "' and  h_atencion.Fecha_Atencion BETWEEN  '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \nAND h_atencion.Codigo_Dxp <>'' AND h_remisiones.Estado =0) \n-- GROUP BY gp.Id , g_especialidad.Id \nORDER BY nombreEspecialidadProfesional ASC, nombreProfesional ASC \n)\nSELECT maestra.idProfesional, maestra.nombreEspecialidadProfesional\n, maestra.nombreProfesional\n, maestra.especialidadARemitir\n, maestra.cantidadRemisiones\n, COUNT(maestra.idEspecialidadRemitir) cantidadPorEspecialidad\n, round(((COUNT(maestra.idEspecialidadRemitir)/ maestra.cantidadRemisiones)*100),2) porcentaje\n,idEspecialidadRemitir\nFROM maestra\ngroup by maestra.idProfesional, maestra.idEspecialidadRemitir\norder  by nombreEspecialidadProfesional ASC, nombreProfesional ASC, especialidadARemitir asc";
        } else {
            sql = "with maestra as (\nSELECT  gp.Id as idProfesional\n, ge.Id as idEspecialidadProfesional\n, ge.Nbre  as  nombreEspecialidadProfesional\n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2) as nombreProfesional \n, g_especialidad.Id  as idEspecialidadRemitir\n, g_especialidad.Nbre as especialidadARemitir\n-- , count(g_especialidad.Id) as cantidadRemisiones\n ,  count(g_especialidad.Id) over(PARTITION by  gp.Id) cantidadRemisiones\nFROM g_persona gp \nINNER JOIN h_atencion  ON (gp.Id = h_atencion.Id_Profesional)\ninner join g_especialidad ge  on (ge.Id=h_atencion.Id_Especialidad)\nINNER JOIN h_remisiones  ON (h_remisiones.Id_Atencion = h_atencion.Id) \nINNER JOIN g_especialidad  ON (h_remisiones.I_Especialidad = g_especialidad.Id) \nWHERE (h_atencion.Fecha_Atencion BETWEEN  '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \nAND h_atencion.Codigo_Dxp <>'' AND h_remisiones.Estado =0) \n-- GROUP BY gp.Id , g_especialidad.Id \nORDER BY nombreEspecialidadProfesional ASC, nombreProfesional ASC \n)\nSELECT maestra.idProfesional, maestra.nombreEspecialidadProfesional\n, maestra.nombreProfesional\n, maestra.especialidadARemitir\n, maestra.cantidadRemisiones\n, COUNT(maestra.idEspecialidadRemitir) cantidadPorEspecialidad\n, round(((COUNT(maestra.idEspecialidadRemitir)/ maestra.cantidadRemisiones)*100),2) porcentaje\n,idEspecialidadRemitir\nFROM maestra\ngroup by maestra.idProfesional, maestra.idEspecialidadRemitir\norder  by nombreEspecialidadProfesional ASC, nombreProfesional ASC, especialidadARemitir asc";
        }
        System.out.println(" primera --------->: " + sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idProfesional")), x, 0);
                    this.xmodelo.setValueAt(rs.getString("nombreEspecialidadProfesional"), x, 1);
                    this.xmodelo.setValueAt(rs.getString("nombreProfesional"), x, 2);
                    this.xmodelo.setValueAt(rs.getString("especialidadARemitir"), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("cantidadRemisiones")), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("cantidadPorEspecialidad")), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("porcentaje")), x, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idEspecialidadRemitir")), x, 7);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDetalleEs() {
        mCrearTablaDetalle1();
        if (this.JCHFiltroR.isSelected()) {
            this.xsql = "SELECT  \ngu.NoHistoria numeroHistoria\n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2) as nombreUsuario\n, gp.Id_Sexo as idSexo\n, concat(Devuelve_Edad_2F(gp.`FechaNac`,h_atencion.Fecha_Atencion ) ,'  ', Devuelve_Tipo_Edad_2F(gp.`FechaNac`,h_atencion.Fecha_Atencion)) as edad\n, gp.Correo \n, gp.Telefono \n, gi.`SO_Cargo`\n, gi.`SO_UNegocio`\n, `h_atencion`.`Id`\n, h_remisiones.Fecha \n, `h_remisiones`.`Id_AtencionR`, \n`h_remisiones`.`Id`\n, gp.Id  as  Id_persona \nFROM ingreso gi \ninner join g_persona gp on (gp.Id=gi.Id_Usuario)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\nINNER JOIN h_atencion  ON (gi.Id = h_atencion.Id_Ingreso)\ninner join g_especialidad ge  on (ge.Id=h_atencion.Id_Especialidad)\nINNER JOIN h_remisiones  ON (h_remisiones.Id_Atencion = h_atencion.Id) \nINNER JOIN g_especialidad  ON (h_remisiones.I_Especialidad = g_especialidad.Id) \nWHERE (h_atencion.Fecha_Atencion BETWEEN  '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \nAND h_atencion.Codigo_Dxp <>'' AND h_remisiones.Estado =0\n AND `h_remisiones`.`I_Especialidad` ='" + this.xmodelo.getValueAt(this.JTConsolidado.getSelectedRow(), 7) + "' \n AND `h_atencion`.`Id_Especialidad` ='" + this.xiddatoc[this.JCBComboxUno.getSelectedIndex()] + "'\n) ";
        } else {
            this.xsql = "SELECT  \ngu.NoHistoria numeroHistoria\n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2) as nombreUsuario\n, gp.Id_Sexo as idSexo\n, concat(Devuelve_Edad_2F(gp.`FechaNac`,h_atencion.Fecha_Atencion ) ,'  ', Devuelve_Tipo_Edad_2F(gp.`FechaNac`,h_atencion.Fecha_Atencion)) as edad\n, gp.Correo \n, gp.Telefono \n, gi.`SO_Cargo`\n, gi.`SO_UNegocio`\n, `h_atencion`.`Id`\n, h_remisiones.Fecha \n, `h_remisiones`.`Id_AtencionR`, \n`h_remisiones`.`Id`\n, gp.Id  as  Id_persona \nFROM ingreso gi \ninner join g_persona gp on (gp.Id=gi.Id_Usuario)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\nINNER JOIN h_atencion  ON (gi.Id = h_atencion.Id_Ingreso)\ninner join g_especialidad ge  on (ge.Id=h_atencion.Id_Especialidad)\nINNER JOIN h_remisiones  ON (h_remisiones.Id_Atencion = h_atencion.Id) \nINNER JOIN g_especialidad  ON (h_remisiones.I_Especialidad = g_especialidad.Id) \nWHERE (h_atencion.Fecha_Atencion BETWEEN  '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \nAND h_atencion.Codigo_Dxp <>'' AND h_remisiones.Estado =0\n AND `h_remisiones`.`I_Especialidad` ='" + this.xmodelo.getValueAt(this.JTConsolidado.getSelectedRow(), 7) + "' \nAND h_atencion.Id_Profesional ='" + this.xmodelo.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "' \n) ";
        }
        System.out.println(" primera :---------Detalle1 " + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo1.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo1.setValueAt(rs.getDate(10), x, 9);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(11)), x, 10);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(12)), x, 11);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(13)), x, 12);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private int mCargarDatosTipoC(long xidespecialidad, String xfiltroxql, long xidpersona) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        int xcant = 0;
        this.xsql = "SELECT COUNT(c_citas.Asistida) FROM profesional1 INNER JOIN c_citas  ON (profesional1.IdEspecialidad = c_citas.Id_Especialidad) AND (profesional1.Id_Persona = c_citas.Id_Profesional) INNER JOIN g_profesional  ON (c_citas.Id_Profesional = g_profesional.Id_Persona) WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Especialidad ='" + xidespecialidad + "' AND c_citas.Asistida" + xfiltroxql + " AND profesional1.Id_Persona ='" + xidpersona + "') GROUP BY profesional1.NProfesional, c_citas.Asistida ORDER BY profesional1.Especialidad ASC, profesional1.NProfesional ASC ";
        ResultSet xrs = xct1.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                xcant = xrs.getInt(1);
            } else {
                xcant = 0;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInf1Comb2Tabla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xcant;
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Plantilla", 0);
                for (int x = 0; x < this.JTConsolidado.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTConsolidado.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTConsolidado.getRowCount(); x2++) {
                    if (this.xnombre.equals("xjifinformacionxespecialidad")) {
                        sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Number(1, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 1).toString()).longValue()));
                        sheet.addCell(new Number(2, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).longValue()));
                        sheet.addCell(new Number(3, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).longValue()));
                        sheet.addCell(new Number(4, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).longValue()));
                        sheet.addCell(new Number(5, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).doubleValue()));
                        sheet.addCell(new Number(6, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).longValue()));
                        sheet.addCell(new Number(7, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).longValue()));
                        sheet.addCell(new Number(8, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 8).toString()).longValue()));
                        sheet.addCell(new Number(9, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 9).toString()).longValue()));
                        sheet.addCell(new Number(10, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 10).toString()).longValue()));
                    } else if (this.xnombre.equals("xjifremisionesxprofesional")) {
                        sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                        sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Number(4, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).longValue()));
                        sheet.addCell(new Number(5, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).longValue()));
                        sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInf1CombTabla1.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInf1CombTabla1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mFijarTitulosCombos() {
        this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Visitas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "HContratada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "HLaboradas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "Citas Asignadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }
}
