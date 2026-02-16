package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDSo_Cuestionario_Respuesta.class */
public class JDSo_Cuestionario_Respuesta extends JDialog {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelores;
    private ConsultasMySQL xct;
    private Metodos metodos;
    private Object[] xdato;
    private JPSo_Cuestionarios xjpcuestionario;
    private String[][] xidrespuesta;
    private String xsql;
    private String xid;
    private boolean xlleno;
    private JButton JBTCerrar;
    private JButton JBTGrabar;
    private JScrollPane JSPDetalleRespuesta;
    private JScrollPane JSPDetalleSub;
    private JTable JTDetalleSub;
    private JTable JTRespuesta;

    public JDSo_Cuestionario_Respuesta(Frame parent, boolean modal, JPSo_Cuestionarios xjpcuestionario) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xid = "0";
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjpcuestionario = xjpcuestionario;
        mNuevo();
        mCargarRespuesta();
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalleSub = new JScrollPane();
        this.JTDetalleSub = new JTable();
        this.JBTGrabar = new JButton();
        this.JBTCerrar = new JButton();
        this.JSPDetalleRespuesta = new JScrollPane();
        this.JTRespuesta = new JTable();
        setDefaultCloseOperation(2);
        setTitle("RESPUESTA");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalleSub.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleSub.setFocusable(false);
        this.JTDetalleSub.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSub.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleSub.setRowHeight(25);
        this.JTDetalleSub.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleSub.setSelectionForeground(Color.red);
        this.JTDetalleSub.setSelectionMode(0);
        this.JSPDetalleSub.setViewportView(this.JTDetalleSub);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JDSo_Cuestionario_Respuesta.1
            public void actionPerformed(ActionEvent evt) {
                JDSo_Cuestionario_Respuesta.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Historia.JDSo_Cuestionario_Respuesta.2
            public void keyPressed(KeyEvent evt) {
                JDSo_Cuestionario_Respuesta.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JDSo_Cuestionario_Respuesta.3
            public void actionPerformed(ActionEvent evt) {
                JDSo_Cuestionario_Respuesta.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTCerrar.addKeyListener(new KeyAdapter() { // from class: Historia.JDSo_Cuestionario_Respuesta.4
            public void keyPressed(KeyEvent evt) {
                JDSo_Cuestionario_Respuesta.this.JBTCerrarKeyPressed(evt);
            }
        });
        this.JSPDetalleRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "RESPUESTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleRespuesta.setFocusable(false);
        this.JTRespuesta.setFont(new Font("Arial", 1, 12));
        this.JTRespuesta.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRespuesta.setSelectionBackground(new Color(255, 255, 255));
        this.JTRespuesta.setSelectionForeground(new Color(255, 0, 0));
        this.JTRespuesta.addMouseListener(new MouseAdapter() { // from class: Historia.JDSo_Cuestionario_Respuesta.5
            public void mouseClicked(MouseEvent evt) {
                JDSo_Cuestionario_Respuesta.this.JTRespuestaMouseClicked(evt);
            }
        });
        this.JSPDetalleRespuesta.setViewportView(this.JTRespuesta);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalleRespuesta, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleSub, -2, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -1, 251, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 246, -2).addGap(4, 4, 4))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleSub, -1, 153, 32767).addComponent(this.JSPDetalleRespuesta, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 67, -2).addComponent(this.JBTCerrar, -2, 67, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRespuestaMouseClicked(MouseEvent evt) {
        if (this.JTRespuesta.getSelectedRow() != -1 && this.xmodelores.getValueAt(this.JTRespuesta.getSelectedRow(), 1).equals("SI")) {
            mCargarDetalle();
        } else {
            mCrearTablaDetalle();
        }
        this.JBTGrabar.requestFocus();
    }

    private void mGrabar() {
        if (this.JTRespuesta.getSelectedRow() != -1) {
            this.xsql = "insert into h_so_cuestionario_detalle(`Id_Cuestionario`, `Id_Pregunta`, `Id_Respuesta`, `ValorR`,`ValorC`, `UsuarioS`) values('" + this.xjpcuestionario.JLBNRegistro.getText() + "','" + this.xjpcuestionario.JTDetalleP.getValueAt(this.xjpcuestionario.JTDetalleP.getSelectedRow(), 0) + "','" + this.xmodelores.getValueAt(this.JTRespuesta.getSelectedRow(), 0) + "','" + this.xmodelores.getValueAt(this.JTRespuesta.getSelectedRow(), 1) + "','" + this.xmodelores.getValueAt(this.JTRespuesta.getSelectedRow(), 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xid = this.xct.ejecutarSQLId(this.xsql);
            this.xct.cerrarConexionBd();
            for (int x = 0; x < this.JTDetalleSub.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                    this.xsql = "insert into h_so_cuestionario_detalle_subcategoria(`Id_CDetalle`, `Id_SubCategoria`, `Observacion`, `UsuarioS`) values('" + this.xid + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            this.xjpcuestionario.xmodelo.setValueAt(this.xmodelores.getValueAt(this.JTRespuesta.getSelectedRow(), 1), this.xjpcuestionario.JTDetalleP.getSelectedRow(), 3);
            this.xjpcuestionario.xmodelo.setValueAt("", this.xjpcuestionario.JTDetalleP.getSelectedRow(), 4);
            this.xjpcuestionario.xmodelo.setValueAt(this.xid, this.xjpcuestionario.JTDetalleP.getSelectedRow(), 6);
            dispose();
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JBTGrabar.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Observación", "Aplica?"}) { // from class: Historia.JDSo_Cuestionario_Respuesta.6
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleSub.setModel(this.xmodelo);
        this.JTDetalleSub.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleSub.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleSub.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleSub.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleSub.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleSub.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        String sql = "SELECT `so_tipo_subcategoria`.`Id`, `so_tipo_subcategoria`.`Nbre`  FROM `so_tipo_pregunta_subcategoria` INNER JOIN `so_tipo_preguntas`  ON (`so_tipo_pregunta_subcategoria`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) INNER JOIN  `so_tipo_subcategoria`  ON (`so_tipo_pregunta_subcategoria`.`Id_Subcategoria` = `so_tipo_subcategoria`.`Id`) WHERE (`so_tipo_pregunta_subcategoria`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + this.xjpcuestionario.JTDetalleP.getValueAt(this.xjpcuestionario.JTDetalleP.getSelectedRow(), 0) + "') ORDER BY `so_tipo_pregunta_subcategoria`.`NOrden` ASC ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt("", x, 2);
                    this.xmodelo.setValueAt(false, x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCrearTablaRespuesta() {
        this.xmodelores = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "SubCat", "ValCuantitativo"}) { // from class: Historia.JDSo_Cuestionario_Respuesta.7
            Class[] types = {Long.class, String.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTRespuesta.setModel(this.xmodelores);
        JTable jTable = this.JTRespuesta;
        JTable jTable2 = this.JTRespuesta;
        jTable.setAutoResizeMode(0);
        this.JTRespuesta.doLayout();
        this.JTRespuesta.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTRespuesta.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarRespuesta() {
        mCrearTablaRespuesta();
        String sql = "SELECT `so_tipo_respuesta`.`Id`, `so_tipo_respuesta`.`Nbre`, `so_tipo_preguntas`.`Maneja_Sub`, `so_tipo_pregunta_respuesta`.VCuantitativo  FROM `so_tipo_pregunta_respuesta` INNER JOIN  `so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) INNER JOIN  `so_tipo_respuesta`  ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`) WHERE (`so_tipo_pregunta_respuesta`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + this.xjpcuestionario.JTDetalleP.getValueAt(this.xjpcuestionario.JTDetalleP.getSelectedRow(), 0) + "') ORDER BY `so_tipo_pregunta_respuesta`.`NOrden` ASC ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.metodos.mEstablecerTextEditor(this.JTRespuesta, 1);
                while (rs.next()) {
                    this.xmodelores.addRow(this.xdato);
                    this.xmodelores.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelores.setValueAt(rs.getString(2), x, 1);
                    this.xmodelores.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelores.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
