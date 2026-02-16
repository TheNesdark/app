package Historia;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDBuscar_Informacion.class */
public class JDBuscar_Informacion extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private String xTitulo;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private JTextField xCodigo;
    private JTextField xNombre;
    private JComboBox idServicio;
    private JComboBox nombreProcedimiento;
    private JCheckBox xEstado;
    private int tipo;
    private JCheckBox JCH_Filtro;
    private JPanel JPI_Filtro;
    private JScrollPane JSP_DDetalle;
    private JTable JTB_DDetalle;
    private JTextField JTF_DNombre;

    public JDBuscar_Informacion(Frame parent, boolean modal, JTextField xcodigo, JTextField xnombre, JCheckBox xtipo, String xtitulo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xTitulo = "";
        this.tipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xCodigo = xcodigo;
        this.xNombre = xnombre;
        this.xTitulo = xtitulo;
        this.xEstado = xtipo;
    }

    public JDBuscar_Informacion(Frame parent, boolean modal, JTextField xcodigo, JTextField xnombre, String xtitulo, int tipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xTitulo = "";
        this.tipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xCodigo = xcodigo;
        this.xNombre = xnombre;
        this.xTitulo = xtitulo;
        this.tipo = tipo;
    }

    public JDBuscar_Informacion(Frame parent, boolean modal, JComboBox idServicio, JComboBox nombreProcedimiento, String xtitulo, int tipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xTitulo = "";
        this.tipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.idServicio = idServicio;
        this.nombreProcedimiento = nombreProcedimiento;
        this.xTitulo = xtitulo;
        this.tipo = tipo;
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Filtro = new JPanel();
        this.JTF_DNombre = new JTextField();
        this.JCH_Filtro = new JCheckBox();
        this.JSP_DDetalle = new JScrollPane();
        this.JTB_DDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("BÚSQUEDA DE INFORMACIÓN");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_DNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_DNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JDBuscar_Informacion.1
            public void keyPressed(KeyEvent evt) {
                JDBuscar_Informacion.this.JTF_DNombreKeyPressed(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setSelected(true);
        this.JCH_Filtro.setText("Comienza?");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: Historia.JDBuscar_Informacion.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscar_Informacion.this.JCH_FiltroActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF_DNombre, -1, 645, 32767).addGap(18, 18, 18).addComponent(this.JCH_Filtro).addGap(11, 11, 11)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Filtro).addComponent(this.JTF_DNombre, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_DDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_DDetalle.setFont(new Font("Arial", 1, 12));
        this.JTB_DDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DDetalle.setRowHeight(25);
        this.JTB_DDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DDetalle.setSelectionForeground(Color.red);
        this.JTB_DDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JDBuscar_Informacion.3
            public void mouseClicked(MouseEvent evt) throws JSONException {
                JDBuscar_Informacion.this.JTB_DDetalleMouseClicked(evt);
            }
        });
        this.JSP_DDetalle.setViewportView(this.JTB_DDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSP_DDetalle, -1, 785, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DDetalle, -1, 274, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            this.JCH_Filtro.setText("Comienza?");
        } else {
            this.JCH_Filtro.setText("Contiene?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DDetalleMouseClicked(MouseEvent evt) throws JSONException {
        if (this.JTB_DDetalle.getSelectedRow() != -1) {
            if (this.tipo == 0) {
                this.xCodigo.setText(this.xModelo.getValueAt(this.JTB_DDetalle.getSelectedRow(), 0).toString());
                this.xNombre.setText(this.xModelo.getValueAt(this.JTB_DDetalle.getSelectedRow(), 1).toString());
                if (this.xTitulo.equals("Suministro")) {
                    this.xEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTB_DDetalle.getSelectedRow(), 2).toString()).booleanValue());
                }
            } else {
                JSONArray jsonArray = new JSONArray(this.xModelo.getValueAt(this.JTB_DDetalle.getSelectedRow(), 3).toString());
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    this.idServicio.setSelectedItem(jsonObject.getString("servicio"));
                }
                this.nombreProcedimiento.setSelectedItem(this.xModelo.getValueAt(this.JTB_DDetalle.getSelectedRow(), 1).toString());
            }
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DNombreKeyPressed(KeyEvent evt) {
        if (!this.JTF_DNombre.getText().isEmpty()) {
            mCargarDatosTabla();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "Cobrable?", "Servicio"}) { // from class: Historia.JDBuscar_Informacion.4
            Class[] types = {String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_DDetalle.setModel(this.xModelo);
        this.JTB_DDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTB_DDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_DDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTB_DDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_DDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_DDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x01a1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:37:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01a5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:39:0x01a5 */
    private void mCargarDatosTabla() {
        try {
            mCrearModelo();
            if (this.JCH_Filtro.isSelected()) {
                if (this.xTitulo.equals("Procedimiento")) {
                    this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, true ,JSON_ARRAYAGG(JSON_OBJECT('servicio', ft.Nbre) order by ft.Nbre asc) AS tiposServicio\nFROM `g_procedimiento` \nINNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \nINNER JOIN  `f_tipoclaseproc`  ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`) \ninner join f_tiposervtipoproced ft2 on (ft2.Idtipoprocedimiento=f_tipoprocedimiento.Id)\ninner join f_tiposervicio ft on (ft.Id=ft2.Idtiposervicio)\nWHERE (`g_procedimiento`.`Nbre` like'" + this.JTF_DNombre.getText() + "%' AND `f_tipoclaseproc`.`EsQco` =" + this.tipo + " AND `g_procedimiento`.`Estado`=0)  \ngroup by  `g_procedimiento`.`Id`\nORDER BY `g_procedimiento`.`Nbre` ASC ";
                } else if (this.xTitulo.equals("Suministro")) {
                    this.xsql = "SELECT `i_suministro`.`Id` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro` , `i_suministro`.`Escobrable`, '' as tiposServicio FROM  `i_suministro` INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) LIKE '" + this.JTF_DNombre.getText() + "%' AND `i_suministro`.`EstaActivo` =1) ORDER BY `NSuministro` ASC ";
                }
            } else if (this.xTitulo.equals("Procedimiento")) {
                this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, true ,JSON_ARRAYAGG(JSON_OBJECT('servicio', ft.Nbre) order by ft.Nbre asc) AS tiposServicio\nFROM `g_procedimiento` \nINNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \nINNER JOIN  `f_tipoclaseproc`  ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`) \ninner join f_tiposervtipoproced ft2 on (ft2.Idtipoprocedimiento=f_tipoprocedimiento.Id)\ninner join f_tiposervicio ft on (ft.Id=ft2.Idtiposervicio)\nWHERE (`g_procedimiento`.`Nbre` like'%" + this.JTF_DNombre.getText() + "%' AND `f_tipoclaseproc`.`EsQco` =" + this.tipo + "  AND `g_procedimiento`.`Estado`=0)  \ngroup by  `g_procedimiento`.`Id`\nORDER BY `g_procedimiento`.`Nbre` ASC ";
            } else if (this.xTitulo.equals("Suministro")) {
                this.xsql = "SELECT `i_suministro`.`Id` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro` , `i_suministro`.`Escobrable`, '' as tiposServicio FROM  `i_suministro` INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) LIKE '%" + this.JTF_DNombre.getText() + "%' AND `i_suministro`.`EstaActivo` =1) ORDER BY `NSuministro` ASC ";
            }
            try {
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTB_DDetalle, 1);
                    while (xrs.next()) {
                        this.xModelo.addRow(this.xDatos);
                        this.xModelo.setValueAt(xrs.getString(1), x, 0);
                        this.xModelo.setValueAt(xrs.getString(2), x, 1);
                        this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), x, 2);
                        this.xModelo.setValueAt(xrs.getString("tiposServicio"), x, 3);
                        x++;
                    }
                } else {
                    mCrearModelo();
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
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
