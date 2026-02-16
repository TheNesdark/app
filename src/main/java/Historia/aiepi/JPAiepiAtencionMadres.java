package Historia.aiepi;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.CheckBoxRenderer;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepiAtencionMadres.class */
public class JPAiepiAtencionMadres extends JPanel {
    protected Hashtable editors;
    protected TableCellEditor editor;
    protected TableCellEditor defaultEditor;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodeloDx1;
    private DefaultTableModel xmodeloDx2;
    private DefaultTableModel xmodeloDx3;
    private DefaultTableModel xmodelocri;
    private Object[] xdatos;
    private ButtonGroup JBGDIarrea;
    private JPanel JPBloque2;
    private JPanel JPForm;
    private JScrollPane JSCriterioRiesgo;
    private JScrollPane JSPDx1;
    private JScrollPane JSPDx2;
    private JScrollPane JSPane;
    private JScrollPane JSPane1;
    private JTable JTBloque2;
    private JTable JTCriterioRiesgo;
    private JTable JTDetalle;
    private JTable JTDx1;
    private JTable JTDx2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JPAiepiAtencionMadres() {
        initComponents();
        mllenaModelo();
        mllenaModeloBloque2();
        mllenaModeloDx1();
        mllenaModeloDx2();
        mllenaModeloCriterioRiesgo();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGDIarrea = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.JPForm = new JPanel();
        this.jPanel1 = new JPanel();
        this.JSPane = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDx1 = new JScrollPane();
        this.JTDx1 = new JTable();
        this.JSCriterioRiesgo = new JScrollPane();
        this.JTCriterioRiesgo = new JTable();
        this.JPBloque2 = new JPanel();
        this.JSPane1 = new JScrollPane();
        this.JTBloque2 = new JTable();
        this.JSPDx2 = new JScrollPane();
        this.JTDx2 = new JTable();
        setName("jpAiepiMaterna");
        this.JPForm.setName("");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "VERIFICAR EL RIESGO DURANTE EL EMBARAZO QUE AFECTA EL BIENESTAR FETAL", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPane.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPane.setViewportView(this.JTDetalle);
        this.JSPDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDx1.setFont(new Font("Arial", 1, 12));
        this.JTDx1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPDx1.setViewportView(this.JTDx1);
        this.JSCriterioRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE RIESGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTCriterioRiesgo.setFont(new Font("Arial", 1, 12));
        this.JTCriterioRiesgo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSCriterioRiesgo.setViewportView(this.JTCriterioRiesgo);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPane, -1, 372, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDx1, -2, 0, 32767).addComponent(this.JSCriterioRiesgo, -1, 344, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPane, -2, 378, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPDx1, -2, 186, -2).addGap(0, 0, 0).addComponent(this.JSCriterioRiesgo, -2, 0, 32767))).addGap(0, 0, 32767)));
        this.JPBloque2.setBorder(BorderFactory.createTitledBorder((Border) null, "¿TIENE DIARREA?", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBloque2.setFont(new Font("Arial", 1, 12));
        this.JTBloque2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPane1.setViewportView(this.JTBloque2);
        this.JSPDx2.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDx2.setFont(new Font("Arial", 1, 12));
        this.JTDx2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPDx2.setViewportView(this.JTDx2);
        GroupLayout JPBloque2Layout = new GroupLayout(this.JPBloque2);
        this.JPBloque2.setLayout(JPBloque2Layout);
        JPBloque2Layout.setHorizontalGroup(JPBloque2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBloque2Layout.createSequentialGroup().addComponent(this.JSPane1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDx2, -2, 0, 32767).addGap(4, 4, 4)));
        JPBloque2Layout.setVerticalGroup(JPBloque2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDx2, -1, 188, 32767).addComponent(this.JSPane1, -2, 0, 32767));
        GroupLayout JPFormLayout = new GroupLayout(this.JPForm);
        this.JPForm.setLayout(JPFormLayout);
        JPFormLayout.setHorizontalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addContainerGap().addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JPBloque2, -1, -1, 32767)).addContainerGap()));
        JPFormLayout.setVerticalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addGap(4, 4, 4).addComponent(this.JPBloque2, -2, -1, -2).addContainerGap(23, 32767)));
        this.jScrollPane1.setViewportView(this.JPForm);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 631, -2).addGap(3, 3, 3)));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "tipo", "Respuesta"}) { // from class: Historia.aiepi.JPAiepiAtencionMadres.1
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(330);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mllenaModelo() {
        mCreaModelo();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id` , `Pregunta` , `TipoPreg` FROM `p_aiepi_madres` WHERE (`Estado` =1 AND Bloque=1)");
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
                EachRowRenderer rowRenderer = new EachRowRenderer();
                EachRowEditor rowEditor = new EachRowEditor(this.JTDetalle);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    if (this.xmodelo.getValueAt(n, 2).toString().equals("0")) {
                        rowRenderer.add(n, checkBoxRenderer);
                    }
                    switch (this.xmodelo.getValueAt(n, 2).toString()) {
                        case "1":
                            JComboBox comboBox = new JComboBox();
                            comboBox.addItem("NO");
                            comboBox.addItem("SI");
                            DefaultCellEditor comboBoxEditor = new DefaultCellEditor(comboBox);
                            rowEditor.setEditorAt(n, comboBoxEditor);
                            this.xmodelo.setValueAt(" ", n, 3);
                            break;
                        case "0":
                            JCheckBox checkBox = new JCheckBox();
                            checkBox.setHorizontalAlignment(0);
                            DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
                            rowEditor.setEditorAt(n, checkBoxEditor);
                            this.xmodelo.setValueAt(false, n, 3);
                            break;
                    }
                    n++;
                }
                this.JTDetalle.getColumn("Respuesta").setCellRenderer(rowRenderer);
                this.JTDetalle.getColumn("Respuesta").setCellEditor(rowEditor);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepiAtencionMadres.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloBloque2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "tipo", "Respuesta"}) { // from class: Historia.aiepi.JPAiepiAtencionMadres.2
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }
                return false;
            }
        };
        this.JTBloque2.setModel(this.xmodelo2);
        this.JTBloque2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBloque2.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBloque2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBloque2.getColumnModel().getColumn(1).setPreferredWidth(330);
        this.JTBloque2.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBloque2.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBloque2.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBloque2.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mllenaModeloBloque2() {
        mCreaModeloBloque2();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id` , `Pregunta` , `TipoPreg` FROM `p_aiepi_madres` WHERE (`Estado` =1 AND Bloque=2)");
        this.xmt.mEstablecerTextEditor(this.JTBloque2, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
                EachRowRenderer rowRenderer = new EachRowRenderer();
                EachRowEditor rowEditor = new EachRowEditor(this.JTBloque2);
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    if (this.xmodelo2.getValueAt(n, 2).toString().equals("0")) {
                        rowRenderer.add(n, checkBoxRenderer);
                    }
                    switch (this.xmodelo2.getValueAt(n, 2).toString()) {
                        case "1":
                            JComboBox comboBox = new JComboBox();
                            comboBox.addItem("NO");
                            comboBox.addItem("SI");
                            DefaultCellEditor comboBoxEditor = new DefaultCellEditor(comboBox);
                            rowEditor.setEditorAt(n, comboBoxEditor);
                            break;
                        case "0":
                            JCheckBox checkBox = new JCheckBox();
                            checkBox.setHorizontalAlignment(0);
                            DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
                            rowEditor.setEditorAt(n, checkBoxEditor);
                            this.xmodelo2.setValueAt(false, n, 3);
                            break;
                    }
                    n++;
                }
                this.JTBloque2.getColumn("Respuesta").setCellRenderer(rowRenderer);
                this.JTBloque2.getColumn("Respuesta").setCellEditor(rowEditor);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepiAtencionMadres.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDx1() {
        this.xmodeloDx1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Dx", "Aplica?"}) { // from class: Historia.aiepi.JPAiepiAtencionMadres.3
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDx1.setModel(this.xmodeloDx1);
        this.JTDx1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDx1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDx1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDx1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDx1.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mllenaModeloDx1() {
        mCreaModeloDx1();
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , `Nbre` FROM `p_aiepi_dx` WHERE (`IdPregunta` =21 AND `Estado` =1)");
        this.xmt.mEstablecerTextEditor(this.JTDx1, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDx1.addRow(this.xdatos);
                    this.xmodeloDx1.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloDx1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloDx1.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepiAtencionMadres.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloCriterioRiesgo() {
        this.xmodelocri = new DefaultTableModel(new Object[0], new String[]{"Id", "Criterio del riesgo", "Aplica?"}) { // from class: Historia.aiepi.JPAiepiAtencionMadres.4
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCriterioRiesgo.setModel(this.xmodelocri);
        this.JTCriterioRiesgo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTCriterioRiesgo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTCriterioRiesgo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTCriterioRiesgo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTCriterioRiesgo.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mllenaModeloCriterioRiesgo() {
        mCreaModeloCriterioRiesgo();
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , `Nbre` FROM `p_aiepi_dx` WHERE (`IdPregunta` =23 AND `Estado` =1)");
        this.xmt.mEstablecerTextEditor(this.JTCriterioRiesgo, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelocri.addRow(this.xdatos);
                    this.xmodelocri.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelocri.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelocri.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepiAtencionMadres.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDx2() {
        this.xmodeloDx2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Dx", "Aplica?"}) { // from class: Historia.aiepi.JPAiepiAtencionMadres.5
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDx2.setModel(this.xmodeloDx2);
        this.JTDx2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDx2.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDx2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDx2.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDx2.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mllenaModeloDx2() {
        mCreaModeloDx2();
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , `Nbre` FROM `p_aiepi_dx` WHERE (`IdPregunta` =22 AND `Estado` =1)");
        this.xmt.mEstablecerTextEditor(this.JTDx2, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDx2.addRow(this.xdatos);
                    this.xmodeloDx2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloDx2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloDx2.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepiAtencionMadres.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        if (!mValidaExamen()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = " INSERT INTO  `p_aiepi_encabezado` ( `FechaR`, `IdAtencion`, `IdUsuario`, `IdProfesional`, `IdEspecialista`, `UsuarioS`)  VALUES ( '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                String xidEncabezado = this.xct.ejecutarSQLId(sql);
                this.xct.cerrarConexionBd();
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    String sql2 = "INSERT INTO  `p_aiepi_madres_respuesta` (`IdPregunta`, `IdEncabezado`, `Respuesta`,  `UsuarioS`)\nVALUES ('" + this.xmodelo.getValueAt(i, 0) + "', '" + xidEncabezado + "', '" + this.xmodelo.getValueAt(i, 3) + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                }
                for (int i2 = 0; i2 < this.JTDx1.getRowCount(); i2++) {
                    if (Boolean.valueOf(this.xmodeloDx1.getValueAt(i2, 2).toString()).booleanValue()) {
                        String sql3 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx1.getValueAt(i2, 0) + "', '" + xidEncabezado + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql3);
                        this.xct.cerrarConexionBd();
                    }
                }
                for (int i3 = 0; i3 < this.JTCriterioRiesgo.getRowCount(); i3++) {
                    if (Boolean.valueOf(this.xmodelocri.getValueAt(i3, 2).toString()).booleanValue()) {
                        String sql7 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodelocri.getValueAt(i3, 0) + "', '" + xidEncabezado + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql7);
                        this.xct.cerrarConexionBd();
                    }
                }
                for (int i4 = 0; i4 < this.JTBloque2.getRowCount(); i4++) {
                    String sql4 = "INSERT INTO  `p_aiepi_madres_respuesta` (`IdPregunta`, `IdEncabezado`, `Respuesta`,  `UsuarioS`)\nVALUES ('" + this.xmodelo2.getValueAt(i4, 0) + "', '" + xidEncabezado + "', '" + this.xmodelo2.getValueAt(i4, 3) + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql4);
                    this.xct.cerrarConexionBd();
                }
                for (int i5 = 0; i5 < this.JTDx2.getRowCount(); i5++) {
                    if (Boolean.valueOf(this.xmodeloDx2.getValueAt(i5, 2).toString()).booleanValue()) {
                        String sql32 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx2.getValueAt(i5, 0) + "', '" + xidEncabezado + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql32);
                        this.xct.cerrarConexionBd();
                    }
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe una evaluación en esta atención", "ERROR", 0);
    }

    private boolean mValidaExamen() {
        boolean xExiste = false;
        String sql = "SELECT `FechaR`,`IdAtencion`,`IdUsuario` FROM `p_aiepi_encabezado` WHERE (IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }
}
