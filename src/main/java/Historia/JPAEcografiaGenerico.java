package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEcografiaGenerico.class */
public class JPAEcografiaGenerico extends JPanel {
    private String xnombre;
    private String nombreItems;
    private clasesHistoriaCE xclase;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    private ButtonGroup JBGEstado;
    private JButton JBTGuardar;
    private JLabel JLBNumero;
    private JPanel JPEcografia;
    private JPanel JPHistorico;
    private JScrollPane JSPEcografia;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JTable JTDetalleEcografia;
    public JTable JTDetalleHistorico;
    private JTabbedPane JTPEcografias;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPAEcografiaGenerico(String nombre, clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        setBorder(BorderFactory.createTitledBorder((Border) null, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta(), 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xnombre = nombre;
        setName(nombre);
        mCargarDatosTabla();
        mCargarDatosTablaHistorico();
    }

    public JPAEcografiaGenerico(String nombre, clasesHistoriaCE xclase, String nombreItems) {
        initComponents();
        this.xclase = xclase;
        this.nombreItems = nombreItems;
        setBorder(BorderFactory.createTitledBorder((Border) null, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta(), 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xnombre = nombre;
        setName(nombre);
        mCargarDatosTabla();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JTPEcografias = new JTabbedPane();
        this.JPEcografia = new JPanel();
        this.JSPEcografia = new JScrollPane();
        this.JTDetalleEcografia = new JTable();
        this.JBTGuardar = new JButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLBNumero = new JLabel();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ECOGRAFÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjifecografia");
        this.JTPEcografias.setForeground(new Color(255, 0, 0));
        this.JTPEcografias.setFont(new Font("Arial", 1, 14));
        this.JSPEcografia.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleEcografia.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEcografia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEcografia.setRowHeight(25);
        this.JTDetalleEcografia.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEcografia.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleEcografia.addMouseListener(new MouseAdapter() { // from class: Historia.JPAEcografiaGenerico.1
            public void mouseClicked(MouseEvent evt) {
                JPAEcografiaGenerico.this.JTDetalleEcografiaMouseClicked(evt);
            }
        });
        this.JSPEcografia.setViewportView(this.JTDetalleEcografia);
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaGenerico.2
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaGenerico.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPAEcografiaGenerico.3
            public void keyPressed(KeyEvent evt) {
                JPAEcografiaGenerico.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLBNumero.setFont(new Font("Arial", 1, 18));
        this.JLBNumero.setForeground(new Color(255, 0, 0));
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Ecografía", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPEcografiaLayout = new GroupLayout(this.JPEcografia);
        this.JPEcografia.setLayout(JPEcografiaLayout);
        JPEcografiaLayout.setHorizontalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPEcografia, GroupLayout.Alignment.TRAILING, -1, 773, 32767).addGroup(JPEcografiaLayout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 638, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNumero, -1, -1, 32767)).addComponent(this.JBTGuardar, -1, -1, 32767)).addContainerGap()));
        JPEcografiaLayout.setVerticalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPEcografia, -1, 216, 32767).addGap(18, 18, 18).addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNumero, -1, -1, 32767).addComponent(this.JSPObservacion, -1, 81, 32767)).addGap(18, 18, 18).addComponent(this.JBTGuardar, -2, 50, -2).addGap(20, 20, 20)));
        this.JTPEcografias.addTab("ECOGRAFÍA", this.JPEcografia);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPAEcografiaGenerico.4
            public void mouseClicked(MouseEvent evt) {
                JPAEcografiaGenerico.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 773, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(114, 32767)));
        this.JTPEcografias.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEcografias).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEcografias).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEcografiaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleEcografia.getSelectedColumn() == 2) {
            mCargarTipoResultadoD(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarRespuestas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.JLBNumero.setText(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
            mImprimir();
        }
    }

    private void mCargarTipoResultadoD(int xcoluma) {
        JDResultadoDescriptivoSO frmDES = new JDResultadoDescriptivoSO(null, true, this.xnombre, xcoluma, this);
        frmDES.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Parte a examinar", "Respuesta", "TipoE"}) { // from class: Historia.JPAEcografiaGenerico.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEcografia.setModel(this.xmodelo);
        this.JTDetalleEcografia.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleEcografia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleEcografia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleEcografia.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleEcografia.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalleEcografia.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleEcografia.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleEcografia.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            sql = null;
            switch (this.xnombre) {
                case "jifecoabdominal":
                    sql = "SELECT  `h_ecog_parametrizacion`.`Id_Partes` , `h_ecog_datosp`.`Nbre` , `h_ecog_parametrizacion`.`Id_TipoEco` FROM `h_ecog_parametrizacion` INNER JOIN  `h_ecog_datosp`  ON (`h_ecog_parametrizacion`.`Id_Partes` = `h_ecog_datosp`.`Id`) INNER JOIN `h_chistoria` ON (`h_ecog_parametrizacion`.`Id_TipoEco` = `h_chistoria`.`Id`) WHERE (`h_chistoria`.`Nbre` ='Ecografia Abdominal') ORDER BY `h_ecog_parametrizacion`.`Orden` ASC";
                    break;
                case "jifecoecobiliarab":
                    sql = "SELECT  `h_ecog_parametrizacion`.`Id_Partes` , `h_ecog_datosp`.`Nbre` , `h_ecog_parametrizacion`.`Id_TipoEco` FROM `h_ecog_parametrizacion` INNER JOIN  `h_ecog_datosp`  ON (`h_ecog_parametrizacion`.`Id_Partes` = `h_ecog_datosp`.`Id`) INNER JOIN `h_chistoria` ON (`h_ecog_parametrizacion`.`Id_TipoEco` = `h_chistoria`.`Id`) WHERE (`h_chistoria`.`Nbre` ='Ecografía Ecobiliarab') ORDER BY `h_ecog_parametrizacion`.`Orden` ASC";
                    break;
                case "xjifecografia":
                    sql = "SELECT  `h_ecog_parametrizacion`.`Id_Partes` , `h_ecog_datosp`.`Nbre` , `h_ecog_parametrizacion`.`Id_TipoEco` FROM `h_ecog_parametrizacion` INNER JOIN  `h_ecog_datosp`  ON (`h_ecog_parametrizacion`.`Id_Partes` = `h_ecog_datosp`.`Id`) INNER JOIN `h_chistoria` ON (`h_ecog_parametrizacion`.`Id_TipoEco` = `h_chistoria`.`Id`) WHERE (`h_chistoria`.`Nbre` ='" + this.nombreItems + "' || `h_chistoria`.`Nbre` ='" + this.nombreItems + "') ORDER BY `h_ecog_parametrizacion`.`Orden` ASC";
                    break;
            }
            System.out.println("Ecografia: " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    TableColumnModel cmodel = this.JTDetalleEcografia.getColumnModel();
                    TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
                    cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
                    TextAreaEditor textEditor = new TextAreaEditor();
                    cmodel.getColumn(2).setCellEditor(textEditor);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt("", n, 2);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsultasbd.cerrarConexionBd();
                    if (this.JTDetalleEcografia.getRowCount() != -1) {
                        this.xmodelo.setValueAt(clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta(), 0, 2);
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAEcografiaGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarRespuestas() {
        if (this.JLBNumero.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "insert into h_ecografia_general (`Fecha_R` , `Id_Atencion`, `Observacion`, `Id_Profesional`, `Id_Especialidad`, Id_ClaseCita, `Usuarios`)  values('" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdClaseCita() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JLBNumero.setText(this.xconsultasbd.ejecutarSQLId(sql));
                this.xconsultasbd.cerrarConexionBd();
                for (int x = 0; x < this.JTDetalleEcografia.getRowCount(); x++) {
                    if (!this.xmodelo.getValueAt(x, 0).equals("")) {
                        String sql2 = "insert into  h_ecog_detalle(`Id_Ecografia`  , `Id_Parte` , `Respuesta`, `Id_TipoEco` , `UsuarioS`)values ('" + this.JLBNumero.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + this.xmodelo.getValueAt(x, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultasbd.ejecutarSQL(sql2);
                        this.xconsultasbd.cerrarConexionBd();
                    }
                }
                mCargarDatosTablaHistorico();
                mImprimir2();
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() != null && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
                    this.xclase.mCambiarEstadoHc(1);
                    this.xclase.mCambiarEstadoCita();
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ecografia ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo de Ecografia", "Especialidad", "Profesional", "idAtencion"}) { // from class: Historia.JPAEcografiaGenerico.6
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_ecografia_general`.`Id`, DATE_FORMAT(`h_ecografia_general`.`Fecha_R`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, h_ecografia_general.Id_Atencion FROM  `h_ecog_detalle` INNER JOIN  `h_ecografia_general`  ON (`h_ecog_detalle`.`Id_Ecografia` = `h_ecografia_general`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_ecografia_general`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_ecografia_general`.`Id_Profesional`) INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id` = `h_ecografia_general`.`Id_Atencion`) INNER JOIN  `c_clasecita`  ON (`h_ecografia_general`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_procedimiento`  ON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_ecografia_general`.`Estado` =1) GROUP BY `h_ecografia_general`.`Id` ORDER BY `h_ecografia_general`.`Fecha_R` DESC ";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodeloh.addRow(this.xdatos);
                            this.xmodeloh.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                            this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                            this.xmodeloh.setValueAt(xrs.getString(4), n, 3);
                            this.xmodeloh.setValueAt(xrs.getString(5), n, 4);
                            this.xmodeloh.setValueAt(xrs.getString(6), n, 5);
                            n++;
                        }
                        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsultasbd.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBNumero.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            System.out.println("" + this.nombreItems);
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
            if (this.nombreItems.equals("Colonoscopia_Dx") || this.nombreItems.equals("Endoscopia_Dx") || this.nombreItems.equals("Colposcopia_Dx") || this.nombreItems.equals("Crioterapia_Dx")) {
                mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 5).toString();
            }
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (this.nombreItems.equals("Colonoscopia_Dx") || this.nombreItems.equals("Endoscopia_Dx") || this.nombreItems.equals("Colposcopia_Dx") || this.nombreItems.equals("Crioterapia_Dx")) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "Pajonal_H_ReporteProcedimientosDx", mparametros);
            } else {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "h", mparametros);
            }
        }
    }

    public void mImprimir2() {
        if (!this.JLBNumero.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.JLBNumero.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_Ecografia_General", mparametros);
        }
    }
}
