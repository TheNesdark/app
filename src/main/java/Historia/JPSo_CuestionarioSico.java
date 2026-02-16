package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_CuestionarioSico.class */
public class JPSo_CuestionarioSico extends JPanel {
    public int xtipo;
    private Object[] xdatos;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloR;
    public DefaultTableModel xmodelocombo;
    private String xsql;
    private JTable tabla_combo;
    JComboBox xcomboBox;
    JComboBox[] xcomboBox1;
    private String[][] xidgenerico;
    private JButton JBTGrabar;
    public JLabel JLBNRegistro;
    private JLabel JLBResultado;
    private JLabel JLBResultado1;
    private JPanel JPIPreguntas;
    private JPanel JPIResultado;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalleP;
    private JScrollPane JSPObservacionG;
    private JTextArea JTAObservacionG;
    public JTable JTDetalleCR;
    private JTabbedPane JTPDatos;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    ArrayList editors = new ArrayList();
    private boolean xlleno = false;

    public JPSo_CuestionarioSico(String xnombre, int xtipo) {
        this.xtipo = 1;
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, xnombre, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xtipo = xtipo;
        mNuevo();
        setEventoMouseClicked(this.tabla_combo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCambiaElementoCombo() {
        if (this.xcomboBox1[this.tabla_combo.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.xmodelocombo.setValueAt(this.xidgenerico[this.xcomboBox1[this.tabla_combo.getSelectedRow()].getSelectedIndex()][0], this.tabla_combo.getSelectedRow(), 7);
            this.xmodelocombo.setValueAt(Double.valueOf(this.xidgenerico[this.xcomboBox1[this.tabla_combo.getSelectedRow()].getSelectedIndex()][1]), this.tabla_combo.getSelectedRow(), 6);
        }
    }

    private JComboBox mLlenaComboModelo(int xid, int xFila) {
        this.xcomboBox = new JComboBox();
        this.xcomboBox1[xFila] = new JComboBox();
        this.xcomboBox1[xFila].setName("combo" + xFila);
        this.xcomboBox1[xFila].removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT `so_tipo_respuesta`.`Id`, `so_tipo_respuesta`.`Nbre`, `so_tipo_pregunta_respuesta`.VCuantitativo   FROM `so_tipo_pregunta_respuesta` INNER JOIN  `so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)    INNER JOIN  `so_tipo_respuesta`  ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)    WHERE (`so_tipo_pregunta_respuesta`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + xid + "') ORDER BY `so_tipo_pregunta_respuesta`.`NOrden` ASC ";
        this.xidgenerico = xct.llenarComboyLista(sql, this.xidgenerico, this.xcomboBox1[xFila], 3);
        this.xcomboBox1[xFila].setSelectedIndex(-1);
        xct.cerrarConexionBd();
        this.xlleno = true;
        return this.xcomboBox1[xFila];
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaS() {
        String[] columnNames = {"Id", "N°", "Pregunta", "Respuesta", "Observación", "id_cuestionario", "ValorC", "IdRespuesta"};
        this.xmodelocombo = new DefaultTableModel(new Object[0], columnNames) { // from class: Historia.JPSo_CuestionarioSico.1
            Class[] types = {Integer.class, Integer.class, String.class, JComboBox.class, String.class, Long.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelocombo) { // from class: Historia.JPSo_CuestionarioSico.2
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 3 && row < JPSo_CuestionarioSico.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JPSo_CuestionarioSico.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(2);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setPreferredWidth(6);
        this.tabla_combo.getColumnModel().getColumn(6).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.tabla_combo.getColumnModel().getColumn(7).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JSPDetalleP.getViewport().add(this.tabla_combo);
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIPreguntas = new JPanel();
        this.JSPDetalleP = new JScrollPane();
        this.JSPObservacionG = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JPIResultado = new JPanel();
        this.JSPConsolidado = new JScrollPane();
        this.JTDetalleCR = new JTable();
        this.JLBResultado = new JLabel();
        this.JLBResultado1 = new JLabel();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CUESTIONARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjpcuestionarios_sico");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setTabSize(1);
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacionG.setViewportView(this.JTAObservacionG);
        GroupLayout JPIPreguntasLayout = new GroupLayout(this.JPIPreguntas);
        this.JPIPreguntas.setLayout(JPIPreguntasLayout);
        JPIPreguntasLayout.setHorizontalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleP, -1, 767, 32767).addComponent(this.JSPObservacionG)).addContainerGap(18, 32767)));
        JPIPreguntasLayout.setVerticalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleP, -1, 407, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionG, -2, 65, -2).addContainerGap()));
        this.JTPDatos.addTab("PREGUNTAS", this.JPIPreguntas);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleCR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCR.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleCR.setRowHeight(25);
        this.JTDetalleCR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCR.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleCR.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_CuestionarioSico.3
            public void mouseClicked(MouseEvent evt) {
                JPSo_CuestionarioSico.this.JTDetalleCRMouseClicked(evt);
            }
        });
        this.JTDetalleCR.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_CuestionarioSico.4
            public void keyPressed(KeyEvent evt) {
                JPSo_CuestionarioSico.this.JTDetalleCRKeyPressed(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTDetalleCR);
        this.JLBResultado.setFont(new Font("Arial", 1, 14));
        this.JLBResultado.setForeground(new Color(255, 9, 244));
        this.JLBResultado.setHorizontalAlignment(0);
        this.JLBResultado1.setFont(new Font("Arial", 1, 14));
        this.JLBResultado1.setForeground(new Color(255, 9, 244));
        this.JLBResultado1.setHorizontalAlignment(0);
        GroupLayout JPIResultadoLayout = new GroupLayout(this.JPIResultado);
        this.JPIResultado.setLayout(JPIResultadoLayout);
        JPIResultadoLayout.setHorizontalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPConsolidado, -1, 775, 32767).addComponent(this.JLBResultado, -1, -1, 32767).addComponent(this.JLBResultado1, -1, -1, 32767)).addContainerGap()));
        JPIResultadoLayout.setVerticalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPConsolidado, -2, 151, -2).addGap(18, 18, 18).addComponent(this.JLBResultado, -2, 43, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBResultado1, -2, 43, -2).addContainerGap(228, 32767)));
        this.JTPDatos.addTab("RESULTADO", this.JPIResultado);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSo_CuestionarioSico.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_CuestionarioSico.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 650, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistro, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 536, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGrabar, -2, 56, -2).addComponent(this.JLBNRegistro, -2, 55, -2)).addContainerGap(13, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRMouseClicked(MouseEvent evt) {
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_CuestionarioSico.6
            public void mouseClicked(MouseEvent e) {
                JPSo_CuestionarioSico.this.tabla_comboMouseClicked(e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tabla_comboMouseClicked(MouseEvent evt) {
        if (this.tabla_combo.getSelectedRow() > -1) {
            mCambiaElementoCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRKeyPressed(KeyEvent evt) {
    }

    private void mCargarResultado() {
    }

    private void mNuevo() {
        mCrearRegistro();
    }

    public void mGrabar() {
        if (!this.xmt.mVerificarDatosLLenoCero(this.tabla_combo, 7)) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update h_so_cuestionarios_encabezado set Observacion='" + this.JTAObservacionG.getText() + "', Cerrado=1 where Id='" + this.JLBNRegistro.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                for (int y = 0; y < this.tabla_combo.getRowCount(); y++) {
                    this.xsql = "INSERT INTO  `h_so_cuestionario_detalle` ( `Id_Cuestionario`, `Id_Pregunta`, `Id_Respuesta`, `ValorR`, `ValorC`, `Observacion`,  `UsuarioS`)  VALUES ( '" + this.xmodelocombo.getValueAt(y, 5) + "', '" + this.xmodelocombo.getValueAt(y, 0) + "', '" + this.xidgenerico[this.xcomboBox1[y].getSelectedIndex()][0] + "', '" + this.xmodelocombo.getValueAt(y, 3) + "', '" + Double.valueOf(this.xidgenerico[this.xcomboBox1[y].getSelectedIndex()][1].toString()) + "', '" + this.xmodelocombo.getValueAt(y, 4) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
                Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                mCargarDatosTabla(1);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JBTGrabar.setEnabled(false);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Faltan preguntas por contestar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Id", "Dimensión", "Puntaje", "Promedio"}) { // from class: Historia.JPSo_CuestionarioSico.7
            Class[] types = {Long.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCR.setModel(this.xmodeloR);
        this.JTDetalleCR.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleCR.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleCR.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTabla(int xforma) {
        try {
            mCrearModeloTablaS();
            if (xforma == 0) {
                this.xsql = "SELECT `Id`, `Nbre` FROM `so_tipo_preguntas` WHERE (`Id_TipoC` ='" + this.xtipo + "' AND `Estado` =1) ORDER BY `Orden` ASC ";
            } else {
                this.xsql = "SELECT `so_tipo_preguntas`.`Id`, `so_tipo_preguntas`.`Nbre`, `h_so_cuestionario_detalle`.`ValorR`, IF(`h_so_cuestionario_detalle`.`Observacion` IS NULL,'',`h_so_cuestionario_detalle`.`Observacion`)  AS ObsP, `h_so_cuestionario_detalle`.`Id`, IF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',`h_so_cuestionarios_encabezado`.`Observacion`) AS ObsP, `h_so_cuestionarios_encabezado`.`Cerrado`, h_so_cuestionario_detalle.Id_Cuestionario, h_so_cuestionario_detalle.ValorC, h_so_cuestionario_detalle.Id_Respuesta FROM  `h_so_cuestionario_detalle` INNER JOIN  `h_so_cuestionarios_encabezado`  ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`) INNER JOIN  `so_tipo_preguntas`  ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) WHERE (`h_so_cuestionarios_encabezado`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_cuestionarios_encabezado`.`Id_Cuestionario` ='" + this.xtipo + "' AND `h_so_cuestionarios_encabezado`.`Estado` =1) ORDER BY `so_tipo_preguntas`.`Orden` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            this.xmt.mEstablecerTextEditor(this.tabla_combo, 2);
            if (xrs.next()) {
                xrs.last();
                this.xcomboBox1 = new JComboBox[xrs.getRow()];
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelocombo.addRow(this.xdatos);
                    this.xmodelocombo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelocombo.setValueAt(Integer.valueOf(x + 1), x, 1);
                    this.xmodelocombo.setValueAt(xrs.getString(2), x, 2);
                    if (xforma == 0) {
                        DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo(xrs.getInt(1), x));
                        this.editors.add(defaultCellEditor);
                        this.xmodelocombo.setValueAt("", x, 4);
                        this.xmodelocombo.setValueAt(this.JLBNRegistro.getText(), x, 5);
                        this.xmodelocombo.setValueAt(0, x, 6);
                        this.xmodelocombo.setValueAt(0, x, 7);
                    } else {
                        DefaultCellEditor defaultCellEditor2 = new DefaultCellEditor(mLlenaComboModelo(xrs.getInt(1), x));
                        this.editors.add(defaultCellEditor2);
                        this.xmodelocombo.setValueAt(xrs.getString(3), x, 3);
                        this.xmodelocombo.setValueAt(xrs.getString(4), x, 4);
                        this.xmodelocombo.setValueAt(Long.valueOf(xrs.getLong("Id_Cuestionario")), x, 5);
                        this.xmodelocombo.setValueAt(Double.valueOf(xrs.getDouble("ValorC")), x, 6);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt("Id_Respuesta")), x, 7);
                        this.JTAObservacionG.setText(xrs.getString(6));
                        if (xrs.getBoolean(8)) {
                            this.JBTGrabar.setEnabled(false);
                        } else {
                            this.JBTGrabar.setEnabled(true);
                        }
                    }
                    this.xcomboBox1[x].addItemListener(new ItemListener() { // from class: Historia.JPSo_CuestionarioSico.8
                        public void itemStateChanged(ItemEvent e) {
                            JPSo_CuestionarioSico.this.mCambiaElementoCombo();
                        }
                    });
                    x++;
                }
                mCargarDatosC();
            } else {
                mCargarDatosTabla(0);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_CuestionarioSico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearRegistro() {
        try {
            this.xsql = "SELECT `Id` FROM `h_so_cuestionarios_encabezado` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Cuestionario ='" + this.xtipo + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNRegistro.setText(xrs.getString(1));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                mCargarDatosTabla(1);
            } else {
                this.xsql = "insert into h_so_cuestionarios_encabezado(`Id_Usuario`,`Id_Atencion`, `FechaR`, `Id_Cuestionario`, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xtipo + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                this.xct.cerrarConexionBd();
                mCargarDatosTabla(0);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_CuestionarioSico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBNRegistro.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRegistro.getText();
            mparametros[1][0] = "P1";
            mparametros[1][1] = this.JLBResultado.getText();
            mparametros[2][0] = "P2";
            mparametros[2][1] = this.JLBResultado1.getText();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (this.xtipo == 12) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Fatiga", mparametros);
                    return;
                }
                if (this.xtipo == 9) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Estilo_Afronamiento", mparametros);
                    return;
                } else if (this.xtipo == 10 || this.xtipo == 11) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral", mparametros);
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral_Consolidado", mparametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
                    return;
                }
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_CuestionarioSico$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 5).toString()).longValue() == 0) {
                cell.setBackground(new Color(255, 102, 0));
            } else {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x01d5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs1' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:40:0x01d5 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x01d9: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:42:0x01d9 */
    private void mCargarDatosC() {
        try {
            mCrearModeloTablaR();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "";
            if (this.xtipo == 9) {
                this.xsql = "SELECT `so_tipo_pregunta_dimension`.`Id`, `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`, SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor` , (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) as total     FROM  `h_so_cuestionario_detalle` INNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`) INNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`) INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`) INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`) INNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`) INNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`) WHERE (`h_so_cuestionarios_encabezado`.`Id` ='" + this.JLBNRegistro.getText() + "'  AND `h_so_cuestionarios_encabezado`.`Estado`=1) GROUP BY `so_tipo_pregunta_dimension`.`Id` ";
            }
            if (!this.xsql.equals("")) {
                try {
                    ResultSet xrs1 = xct1.traerRs(this.xsql);
                    Throwable th = null;
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        while (xrs1.next()) {
                            this.xmodeloR.addRow(this.xdatos);
                            this.xmodeloR.setValueAt(Long.valueOf(xrs1.getLong(1)), x, 0);
                            this.xmodeloR.setValueAt(xrs1.getString(2), x, 1);
                            this.xmodeloR.setValueAt(Double.valueOf(xrs1.getDouble(3)), x, 2);
                            this.xmodeloR.setValueAt(Double.valueOf(xrs1.getDouble(4)), x, 3);
                            x++;
                        }
                        if (this.xtipo == 9) {
                            if (Double.valueOf(this.xmodeloR.getValueAt(0, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() || Double.valueOf(this.xmodeloR.getValueAt(1, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue()) {
                                this.JLBResultado.setText("PREVALECE EL ENFRENTAMIENTO ACTIVO DE LAS TENSIONES Y SUS ORIGENES - VERDADERO");
                            } else {
                                this.JLBResultado.setText("PREVALECE EL ENFRENTAMIENTO ACTIVO DE LAS TENSIONES Y SUS ORIGENES - FALSO");
                            }
                            if (Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(0, 3).toString()).doubleValue() || Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(1, 3).toString()).doubleValue()) {
                                this.JLBResultado1.setText("ENFRENTAMIENTO PREDOMINANTE EVITATIVO DE LAS SITUACIONES GENERADORAS DE TENSIÓN - FALSO");
                            } else {
                                this.JLBResultado1.setText("ENFRENTAMIENTO PREDOMINANTE EVITATIVO DE LAS SITUACIONES GENERADORAS DE TENSIÓN - FALSO");
                            }
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_CuestionarioSico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
