package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTableX;
import Utilidades.Metodos;
import Utilidades.RowEditorModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPCefalometria.class */
public class JPCefalometria extends JPanel {
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelocombo;
    private DefaultTableModel xmodelohistorico;
    private Object[] xdato;
    private String[] xidgenerico;
    private JTableX JTDetalleCombo;
    private JTable tabla_combo;
    private ButtonGroup JBGRM;
    private JButton JBGuardar;
    public JDateChooser JDFecha;
    private JPanel JPDatos;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPHistorico;
    private JTextArea JTAObservacion;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private long xrmolar = 0;
    private long xrcanino = 0;
    private long xconceptoh = 0;
    private long xconceptov = 0;
    private long xrtrasversal = 0;
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xexamen = "";
    RowEditorModel rm = new RowEditorModel();
    ArrayList editors = new ArrayList();
    Metodos xmt = new Metodos();
    private long xranalisis = 0;
    private String xcefalometria = "";

    public JPCefalometria() {
        initComponents();
        mNuevo();
        mBuscarHistorico();
        mBuscaCefalometriaUsuarioAtencion();
    }

    private void mNuevo() {
        this.JDFecha.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Opciones", "Observación"}) { // from class: Odontologia.JPCefalometria.1
            Class[] types = {Integer.class, String.class, JComboBox.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCombo = new JTableX(this.xmodelo2);
        this.JTDetalleCombo.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDetalleCombo.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleCombo.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleCombo.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleCombo.setRowEditorModel(this.rm);
        this.jScrollPane1.getViewport().add(this.JTDetalleCombo);
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO `o_cefalometria_analisis` ( `IdAtencion`, `IdTratamiento`, `FechaAnalisis`, `Realizado`, `IdProfesional`, `IdEspecialidad`, `Observacion`, IdUsuario, `UsuarioS`)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "', '" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "', '" + this.xranalisis + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  '" + this.JTAObservacion.getText() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xcefalometria = this.xconsulta.ejecutarSQLId(sql);
            this.xconsulta.cerrarConexionBd();
            for (int y = 0; y < this.tabla_combo.getRowCount(); y++) {
                if (this.xmodelocombo.getValueAt(y, 2) != null) {
                    String sql2 = "INSERT INTO  `o_cefalometria_analisis_detalle` (`IdCefalometria`, `IdCabecera`, `Respuesta`, `Observacion`,  `UsuarioS`)  VALUES ('" + this.xcefalometria + "', '" + this.xmodelocombo.getValueAt(y, 0) + "', '" + this.xmodelocombo.getValueAt(y, 2) + "', '" + this.xmodelocombo.getValueAt(y, 3) + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                }
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mBuscarHistorico();
        }
    }

    private JComboBox mLlenaComboModelo(int xid) {
        JComboBox xcomboBox = new JComboBox();
        xcomboBox.removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT `o_cefalometria_x_concepto`.`IdConcepto`,`o_cefalometria_concepto`.`Nbre`  FROM `o_cefalometria_x_concepto`  INNER JOIN `baseserver`.`o_cefalometria_concepto`  ON (`o_cefalometria_x_concepto`.`IdConcepto` = `o_cefalometria_concepto`.`Id`)  WHERE (`o_cefalometria_x_concepto`.`Estado` =1  AND `o_cefalometria_x_concepto`.`IdCabezera` ='" + xid + "') ";
        this.xidgenerico = xct.llenarCombo(sql, this.xidgenerico, xcomboBox);
        xcomboBox.setSelectedIndex(-1);
        xct.cerrarConexionBd();
        return xcomboBox;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloDatosCombo() {
        String[] columnNames = {"Id", "Concepto", "Opciones", "Observación"};
        this.xmodelocombo = new DefaultTableModel(new Object[0], columnNames) { // from class: Odontologia.JPCefalometria.2
            Class[] types = {Integer.class, String.class, JComboBox.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelocombo) { // from class: Odontologia.JPCefalometria.3
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 2 && row < JPCefalometria.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JPCefalometria.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.jScrollPane1.getViewport().add(this.tabla_combo);
    }

    private void mLLenaTablaconCombo() {
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs_combo = xct.traerRs("SELECT `Id` , `Nbre` FROM `o_cefalometria_cabecera` WHERE (`Estado` =1) ORDER BY `Orden` ASC");
        mModeloDatosCombo();
        try {
            if (xrs_combo.next()) {
                xrs_combo.beforeFirst();
                int n = 0;
                while (xrs_combo.next()) {
                    this.xmodelocombo.addRow(this.xdato);
                    this.xmodelocombo.setValueAt(Integer.valueOf(xrs_combo.getInt(1)), n, 0);
                    this.xmodelocombo.setValueAt(xrs_combo.getString(2), n, 1);
                    DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo(xrs_combo.getInt(1)));
                    this.editors.add(defaultCellEditor);
                    this.xmodelocombo.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs_combo.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPCefalometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaCefalometriaUsuarioAtencion() {
        String sql = "SELECT  `o_cefalometria_analisis`.`Id` , `o_cefalometria_analisis`.`FechaAnalisis`  , `o_cefalometria_analisis`.`Realizado` , `o_cefalometria_analisis`.`Observacion`  , `o_cefalometria_analisis_detalle`.`IdCabecera` , `o_cefalometria_cabecera`.`Nbre` AS Cabecera , `o_cefalometria_analisis_detalle`.`Respuesta` , `o_cefalometria_analisis_detalle`.`Observacion` AS ObsRespuesta FROM `o_cefalometria_analisis_detalle` INNER JOIN  `o_cefalometria_analisis`  ON (`o_cefalometria_analisis_detalle`.`IdCefalometria` = `o_cefalometria_analisis`.`Id`)  INNER JOIN `baseserver`.`o_cefalometria_cabecera`  ON (`o_cefalometria_analisis_detalle`.`IdCabecera` = `o_cefalometria_cabecera`.`Id`) WHERE (`o_cefalometria_analisis`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND `o_cefalometria_analisis`.`IdAtencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs_combo = xct.traerRs(sql);
        mModeloDatosCombo();
        try {
            if (xrs_combo.next()) {
                this.JDFecha.setDate(xrs_combo.getDate("FechaAnalisis"));
                if (xrs_combo.getLong("Realizado") == 0) {
                    this.JRBNo.setSelected(true);
                } else {
                    this.JRBSi.setSelected(true);
                }
                this.JTAObservacion.setText(xrs_combo.getString("Observacion"));
                xrs_combo.beforeFirst();
                int n = 0;
                while (xrs_combo.next()) {
                    this.xmodelocombo.addRow(this.xdato);
                    this.xmodelocombo.setValueAt(Integer.valueOf(xrs_combo.getInt("IdCabecera")), n, 0);
                    this.xmodelocombo.setValueAt(xrs_combo.getString("Cabecera"), n, 1);
                    DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo(xrs_combo.getInt("IdCabecera")));
                    this.editors.add(defaultCellEditor);
                    this.xmodelocombo.setValueAt(xrs_combo.getString("Respuesta"), n, 2);
                    this.xmodelocombo.setValueAt(xrs_combo.getString("ObsRespuesta"), n, 3);
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                mLLenaTablaconCombo();
            }
            xrs_combo.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPCefalometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelohistorico = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Profesional", "Especialidad"}) { // from class: Odontologia.JPCefalometria.4
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelohistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    private void mBuscarHistorico() {
        mCrearModeloHistorico();
        String sql = "SELECT `o_cefalometria_analisis`.`Id` , `o_cefalometria_analisis`.`IdAtencion` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `o_cefalometria_analisis`  INNER JOIN  `profesional1`   ON (`o_cefalometria_analisis`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`o_cefalometria_analisis`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`o_cefalometria_analisis`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelohistorico.addRow(this.xdato);
                    this.xmodelohistorico.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelohistorico.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelohistorico.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelohistorico.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mArmaCefalometriaConCombo() {
        mCrearModelo2();
        ResultSet xrs = this.xconsulta.traerRs("SELECT `Id` , `Nbre` FROM `o_cefalometria_cabecera` WHERE (`Estado` =1) ORDER BY `Orden` ASC");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    if (this.xmodelo2.isCellEditable(n, 2)) {
                        this.rm.addEditorForRow(n, new DefaultCellEditor(mLlenaComboModelo(xrs.getInt(1))));
                    }
                    this.xmodelo2.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPCefalometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGRM = new ButtonGroup();
        this.JBGuardar = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JPDatos = new JPanel();
        this.JDFecha = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel3 = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jpcefalometria");
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPCefalometria.5
            public void actionPerformed(ActionEvent evt) {
                JPCefalometria.this.JBGuardarActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(0, 107, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JDFecha.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPCefalometria.6
            public void keyPressed(KeyEvent evt) {
                JPCefalometria.this.JDFechaKeyPressed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Se realiza análisis?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGRM.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Sí");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Odontologia.JPCefalometria.7
            public void actionPerformed(ActionEvent evt) {
                JPCefalometria.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGRM.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Odontologia.JPCefalometria.8
            public void actionPerformed(ActionEvent evt) {
                JPCefalometria.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(33, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addGap(3, 3, 3)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, 130, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(29, 29, 29).addComponent(this.jScrollPane2, -1, 396, 32767).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFecha, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.JPDatos, -1, -1, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPDatos, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 273, -2).addGap(0, 6, 32767)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel2);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPCefalometria.9
            public void mouseClicked(MouseEvent evt) {
                JPCefalometria.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 732, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 354, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel3);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addComponent(this.JBGuardar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 405, -2).addGap(5, 5, 5).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xranalisis = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xranalisis = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
    }

    private void mVerificaAnalisis() {
        String sql = "`Id` , `FechaAnalisis` , `Realizado` , `Observacion` FROM `o_cefalometria_analisis` WHERE (`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xcefalometria = xrs.getString(1);
                this.JDFecha.setDate(xrs.getDate(2));
                if (xrs.getLong(3) == 0) {
                    this.JRBNo.setSelected(true);
                } else {
                    this.JRBSi.setSelected(true);
                }
                this.JTAObservacion.setText(xrs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPCefalometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
