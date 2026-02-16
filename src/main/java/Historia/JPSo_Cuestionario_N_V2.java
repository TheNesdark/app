package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.CuestionarioDAO;
import com.genoma.plus.dao.historia.CuestionarioDetalleDAO;
import com.genoma.plus.dao.historia.CuestionarioDetalleSubCategoriaDAO;
import com.genoma.plus.dao.impl.historia.CuestionarioDAOImpl;
import com.genoma.plus.dao.impl.historia.CuestionarioDetalleDAOImpl;
import com.genoma.plus.dao.impl.historia.CuestionarioDetalleSubCategoriaDAOImpl;
import com.genoma.plus.dto.historia.CuestionarioDTO;
import com.genoma.plus.dto.historia.CuestionarioDetalleDTO;
import com.genoma.plus.dto.historia.CuestionarioDetalleSubCategoriaDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Cuestionario_N_V2.class */
public class JPSo_Cuestionario_N_V2 extends JPanel {
    public int xtipo;
    private Object[] xdatos;
    private Object[] xdatos1;
    private Object[] xdatosH;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloR;
    public DefaultTableModel xmodelocombo;
    public DefaultTableModel xmodeloSubC;
    public DefaultTableModel xModeloHistorico;
    private DefaultTableModel modcombos;
    private String xsql;
    private JTable tabla_combo;
    JComboBox xcomboBox;
    JComboBox[] xcomboBox1;
    JTableComboBox[] xcomboBox3;
    private String[][] xidgenerico;
    List<CuestionarioDetalleSubCategoriaDTO> xTemporal;
    private CuestionarioDAO xCuestionarioDAO;
    private CuestionarioDetalleDAO xCuestionarioDetalleDAO;
    private CuestionarioDetalleSubCategoriaDAO xCuestionarioDetalleSubCategoriaDAO;
    private Integer idClasificacion;
    private JButton JBTGrabar;
    public JLabel JLBNRegistro;
    private JLabel JLBResultado;
    private JLabel JLBResultado1;
    private JLabel JLB_Encabezado;
    private JLabel JLB_Resultado;
    private JPanel JPHistorico;
    private JPanel JPIPreguntas;
    private JPanel JPIResultado;
    private JScrollPane JSPCategoria;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalleP;
    private JScrollPane JSPObservacionG;
    private JTextArea JTAObservacionG;
    private JTable JTCategoria;
    public JTable JTDetalleCR;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    ArrayList editors = new ArrayList();
    private boolean xlleno = false;
    private Map<String, Double> agrupacionDato = new HashMap();

    public JPSo_Cuestionario_N_V2(String xnombre, int xtipo, Integer idClasificacion) {
        this.xtipo = 1;
        initComponents();
        springStart();
        setBorder(BorderFactory.createTitledBorder((Border) null, xnombre, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xtipo = xtipo;
        this.idClasificacion = idClasificacion;
        if (this.idClasificacion.intValue() != 0) {
            buscarIdCuestionarioPorIdClasificacion();
        }
        mNuevo();
        setEventoMouseClicked(this.tabla_combo);
        if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
            this.JSPCategoria.setVisible(false);
            this.JLB_Resultado.setVisible(false);
            this.JPIResultado.setVisible(false);
            this.JSPConsolidado.setVisible(false);
            this.JTDetalleCR.setVisible(false);
            this.JLBResultado.setVisible(false);
            this.JLBResultado1.setVisible(false);
            this.JTPDatos.setEnabledAt(1, false);
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xCuestionarioDAO = (CuestionarioDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDAO");
        this.xCuestionarioDetalleDAO = (CuestionarioDetalleDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDetalleDAO");
        this.xCuestionarioDetalleSubCategoriaDAO = (CuestionarioDetalleSubCategoriaDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDetalleSubCategoriaDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCambiaElementoCombo() {
        if (this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.xmodelocombo.setValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 0), this.tabla_combo.getSelectedRow(), 8);
            this.xmodelocombo.setValueAt(Double.valueOf(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 2).toString()), this.tabla_combo.getSelectedRow(), 7);
            if (this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 1) != null && this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 1).toString().equals("SI")) {
                mCargarTablaSubCategorias();
            } else {
                mCrearTablaSubCategoria();
            }
        } else {
            mCrearTablaSubCategoria();
        }
        mSumatoria();
    }

    private JComboBox mLlenaComboModelo(int xid, int xFila) {
        this.xcomboBox1[xFila] = new JComboBox();
        this.xcomboBox1[xFila].setName("combo" + xFila);
        this.xcomboBox1[xFila].setSize(200, 50);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        String sql = "SELECT `so_tipo_respuesta`.`Id`, `so_tipo_respuesta`.`Nbre`, `so_tipo_pregunta_respuesta`.VCuantitativo   FROM `so_tipo_pregunta_respuesta` INNER JOIN  `so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)    INNER JOIN  `so_tipo_respuesta`  ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)    WHERE (`so_tipo_pregunta_respuesta`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + xid + "') ORDER BY `so_tipo_pregunta_respuesta`.`NOrden` ASC ";
        this.xidgenerico = xct1.llenarComboyLista(sql, this.xidgenerico, this.xcomboBox1[xFila], 3);
        this.xcomboBox1[xFila].setSelectedIndex(-1);
        xct1.cerrarConexionBd();
        this.xlleno = true;
        return this.xcomboBox1[xFila];
    }

    private JTableComboBox mLlenaComboModelo1(int xid, int xFila) {
        try {
            this.xcomboBox3[xFila] = new JTableComboBox();
            this.xcomboBox3[xFila].setName("combo" + xFila);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String sql = "SELECT `so_tipo_respuesta`.`Id`, `so_tipo_respuesta`.`Nbre`, `so_tipo_pregunta_respuesta`.VCuantitativo   FROM `so_tipo_pregunta_respuesta` INNER JOIN  `so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)    INNER JOIN  `so_tipo_respuesta`  ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)    WHERE (`so_tipo_pregunta_respuesta`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + xid + "') ORDER BY `so_tipo_pregunta_respuesta`.`NOrden` ASC ";
            xct1.llenarComboTabla(sql, this.xcomboBox3[xFila], this.modcombos, 1);
            xct1.cerrarConexionBd();
            this.xlleno = true;
        } catch (IncompatibleLookAndFeelException e) {
            Logger.getLogger(JPSo_Cuestionario_N_V2.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return this.xcomboBox3[xFila];
    }

    private void buscarIdCuestionarioPorIdClasificacion() {
        try {
            this.xsql = "SELECT Id from so_tipo_cuestionario where so_tipo_cuestionario.idClasificacion =" + this.idClasificacion + " and so_tipo_cuestionario.Estado =1";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xtipo = xrs.getInt("Id");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSumatoria() {
        for (int y = 0; y < this.JTDetalleCR.getRowCount(); y++) {
            this.xmodeloR.setValueAt(false, y, 4);
        }
        this.agrupacionDato.entrySet().forEach(entry -> {
            entry.setValue(Double.valueOf(0.0d));
        });
        double xvalor = 0.0d;
        for (int x = 0; x < this.tabla_combo.getRowCount(); x++) {
            if (!this.xmodelocombo.getValueAt(x, 7).toString().equals("0")) {
                xvalor += Double.valueOf(this.xmodelocombo.getValueAt(x, 7).toString()).doubleValue();
            }
            for (Map.Entry<String, Double> entry2 : this.agrupacionDato.entrySet()) {
                entry2.getKey();
                entry2.getValue();
                if (entry2.getKey().equals(this.xmodelocombo.getValueAt(x, 1).toString())) {
                    entry2.setValue(Double.valueOf(entry2.getValue().doubleValue() + Double.valueOf(this.xmodelocombo.getValueAt(x, 7).toString()).doubleValue()));
                }
            }
        }
        this.JLB_Resultado.setText("" + xvalor);
        this.agrupacionDato.entrySet().forEach(entry3 -> {
            String key = (String) entry3.getKey();
            Double value = (Double) entry3.getValue();
            for (int y2 = 0; y2 < this.JTDetalleCR.getRowCount(); y2++) {
                if (this.xmodeloR.getValueAt(y2, 0).equals(key) && value.doubleValue() >= Double.valueOf(this.xmodeloR.getValueAt(y2, 2).toString()).doubleValue() && value.doubleValue() <= Double.valueOf(this.xmodeloR.getValueAt(y2, 3).toString()).doubleValue()) {
                    this.xmodeloR.setValueAt(true, y2, 4);
                }
            }
        });
        mCargarResultado();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaS() {
        String[] columnNames = {"Id", "Categoria", "N°", "Pregunta", "Respuesta", "Observación", "id_cuestionario", "ValorC", "IdR    espuesta", "IdC_detalle"};
        this.xmodelocombo = new DefaultTableModel(new Object[0], columnNames) { // from class: Historia.JPSo_Cuestionario_N_V2.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, JTableComboBox[].class, String.class, Long.class, Double.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelocombo) { // from class: Historia.JPSo_Cuestionario_N_V2.2
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 4 && row < JPSo_Cuestionario_N_V2.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JPSo_Cuestionario_N_V2.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.setFont(new Font("Arial", 1, 12));
        this.tabla_combo.setRowHeight(100);
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.tabla_combo.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setMaxWidth(0);
        if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
            this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(0);
            this.tabla_combo.getColumnModel().getColumn(2).setMinWidth(0);
            this.tabla_combo.getColumnModel().getColumn(2).setMaxWidth(0);
            this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(0);
            this.tabla_combo.getColumnModel().getColumn(5).setMinWidth(0);
            this.tabla_combo.getColumnModel().getColumn(5).setMaxWidth(0);
            this.tabla_combo.getColumnModel().getColumn(9).setPreferredWidth(0);
            this.tabla_combo.getColumnModel().getColumn(9).setMinWidth(0);
            this.tabla_combo.getColumnModel().getColumn(9).setMaxWidth(0);
        }
        this.JSPDetalleP.getViewport().add(this.tabla_combo);
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIPreguntas = new JPanel();
        this.JSPDetalleP = new JScrollPane();
        this.JSPObservacionG = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JSPCategoria = new JScrollPane();
        this.JTCategoria = new JTable();
        this.JPIResultado = new JPanel();
        this.JSPConsolidado = new JScrollPane();
        this.JTDetalleCR = new JTable();
        this.JLBResultado = new JLabel();
        this.JLBResultado1 = new JLabel();
        this.JPHistorico = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        this.JLB_Resultado = new JLabel();
        this.JLB_Encabezado = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CUESTIONARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjpcuestionarios_n");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setTabSize(1);
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacionG.setPreferredSize(new Dimension(116, 100));
        this.JSPObservacionG.setViewportView(this.JTAObservacionG);
        this.JSPCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "SUBCATEGORIA", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTCategoria.setFont(new Font("Arial", 1, 12));
        this.JTCategoria.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCategoria.setSelectionBackground(Color.white);
        this.JTCategoria.setSelectionForeground(Color.red);
        this.JTCategoria.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPSo_Cuestionario_N_V2.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPSo_Cuestionario_N_V2.this.JTCategoriaPropertyChange(evt);
            }
        });
        this.JSPCategoria.setViewportView(this.JTCategoria);
        GroupLayout JPIPreguntasLayout = new GroupLayout(this.JPIPreguntas);
        this.JPIPreguntas.setLayout(JPIPreguntasLayout);
        JPIPreguntasLayout.setHorizontalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleP).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JSPObservacionG, -2, 344, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCategoria, -1, 409, 32767))).addContainerGap()));
        JPIPreguntasLayout.setVerticalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPreguntasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleP, -2, 363, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPCategoria, -2, 0, 32767).addComponent(this.JSPObservacionG, -1, 93, 32767)).addGap(528, 528, 528)));
        this.JTPDatos.addTab("PREGUNTAS", this.JPIPreguntas);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleCR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCR.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleCR.setRowHeight(25);
        this.JTDetalleCR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCR.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleCR.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Cuestionario_N_V2.4
            public void mouseClicked(MouseEvent evt) {
                JPSo_Cuestionario_N_V2.this.JTDetalleCRMouseClicked(evt);
            }
        });
        this.JTDetalleCR.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPSo_Cuestionario_N_V2.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPSo_Cuestionario_N_V2.this.JTDetalleCRPropertyChange(evt);
            }
        });
        this.JTDetalleCR.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Cuestionario_N_V2.6
            public void keyPressed(KeyEvent evt) {
                JPSo_Cuestionario_N_V2.this.JTDetalleCRKeyPressed(evt);
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
        JPIResultadoLayout.setHorizontalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPConsolidado, -1, 759, 32767).addComponent(this.JLBResultado, -1, -1, 32767).addComponent(this.JLBResultado1, -1, -1, 32767)).addContainerGap()));
        JPIResultadoLayout.setVerticalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPConsolidado, -2, 375, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBResultado, -2, 43, -2).addGap(41, 41, 41).addComponent(this.JLBResultado1, -2, 43, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("RESULTADO", this.JPIResultado);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 759, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 471, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("HISTORICO", this.JPHistorico);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Cuestionario_N_V2.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_Cuestionario_N_V2.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JLB_Resultado.setFont(new Font("Arial", 1, 14));
        this.JLB_Resultado.setForeground(Color.red);
        this.JLB_Resultado.setHorizontalAlignment(0);
        this.JLB_Resultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 12)));
        this.JLB_Encabezado.setFont(new Font("Arial", 1, 12));
        this.JLB_Encabezado.setForeground(Color.red);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Encabezado, -1, -1, 32767).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 536, -2).addGap(4, 4, 4).addComponent(this.JLB_Resultado, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRegistro, -2, 120, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JLB_Encabezado, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 519, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNRegistro, -2, 55, -2).addComponent(this.JBTGrabar, -1, -1, 32767).addComponent(this.JLB_Resultado, -2, 55, -2)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRMouseClicked(MouseEvent evt) {
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Cuestionario_N_V2.8
            public void mouseClicked(MouseEvent e) {
                JPSo_Cuestionario_N_V2.this.tabla_comboMouseClicked(e);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCategoriaPropertyChange(PropertyChangeEvent evt) {
        if (this.JLBNRegistro.getText().isEmpty() && this.JTCategoria.getRowCount() > 0 && this.JTCategoria.getSelectedRow() != -1) {
            Integer pos = verificarExistenciatemporal(Long.valueOf(this.xmodelocombo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString()), Long.valueOf(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 0).toString()));
            if (pos.intValue() != -1) {
                this.xTemporal.get(pos.intValue()).setObservacion(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 2).toString());
                this.xTemporal.get(pos.intValue()).setAplica(Boolean.valueOf(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 3).toString()).booleanValue());
            } else {
                this.xTemporal.add(CuestionarioDetalleSubCategoriaDTO.builder().idCDetalle(Long.valueOf(this.xmodelocombo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString())).idSubCategoria(Long.valueOf(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 0).toString())).observacion(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 2).toString()).aplica(Boolean.valueOf(this.xmodeloSubC.getValueAt(this.JTCategoria.getSelectedRow(), 3).toString()).booleanValue()).build());
            }
        }
    }

    private Integer verificarExistenciatemporal(Long IdPregunta, Long IdSubCategoria) {
        Integer pos = -1;
        if (!this.xTemporal.isEmpty()) {
            int x = 0;
            while (true) {
                if (x < this.xTemporal.size()) {
                    if (!Objects.equals(this.xTemporal.get(x).getIdCDetalle(), IdPregunta) || !Objects.equals(this.xTemporal.get(x).getIdSubCategoria(), IdSubCategoria)) {
                        x++;
                    } else {
                        pos = Integer.valueOf(x);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return pos;
    }

    private void mNuevo() {
        this.xTemporal = new ArrayList();
        mCrearTablaSubCategoria();
        mVerificarExistenciaEncuesta();
        mCargarTablaHistorico();
    }

    public void mGrabar() {
        if (this.JBTGrabar.isEnabled()) {
            if (!this.xmt.mVerificarDatosLLenoCero(this.tabla_combo, 8)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String xValorT = "";
                    for (int z = 0; z < this.JTDetalleCR.getRowCount(); z++) {
                        if (Boolean.valueOf(this.xmodeloR.getValueAt(z, 4).toString()).booleanValue()) {
                            xValorT = this.JTDetalleCR.getValueAt(z, 1).toString();
                        }
                    }
                    CuestionarioDTO xObjEncabezado = new CuestionarioDTO();
                    xObjEncabezado.setIdUsuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                    xObjEncabezado.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                    xObjEncabezado.setFechaR(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                    xObjEncabezado.setIdCuestionario(Long.valueOf(this.xtipo));
                    xObjEncabezado.setObservacion(this.JTAObservacionG.getText());
                    xObjEncabezado.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                    xObjEncabezado.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                    xObjEncabezado.setCerrado(true);
                    xObjEncabezado.setResultadoTexto(xValorT);
                    xObjEncabezado.setResultadoValor(this.JLB_Resultado.getText());
                    xObjEncabezado.setUUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    Long xIdEncabezado = this.xCuestionarioDAO.mCrear(xObjEncabezado);
                    this.JLBNRegistro.setText(String.valueOf(xIdEncabezado));
                    for (int y = 0; y < this.tabla_combo.getRowCount(); y++) {
                        double xValorC = Double.valueOf(this.xmodelocombo.getValueAt(y, 7).toString().replace(",", ".")).doubleValue();
                        CuestionarioDetalleDTO xCuestionarioDetalle = new CuestionarioDetalleDTO();
                        xCuestionarioDetalle.setIdCuestionario(xIdEncabezado);
                        xCuestionarioDetalle.setIdPregunta(Long.valueOf(this.xmodelocombo.getValueAt(y, 0).toString()));
                        xCuestionarioDetalle.setIdRespuesta(Long.valueOf(this.xmodelocombo.getValueAt(y, 8).toString()));
                        xCuestionarioDetalle.setValorR(this.xmodelocombo.getValueAt(y, 4).toString());
                        xCuestionarioDetalle.setValorC(Long.valueOf((long) xValorC));
                        xCuestionarioDetalle.setObservacion(this.xmodelocombo.getValueAt(y, 5).toString());
                        xCuestionarioDetalle.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        Long xIdCuestionarioDetalle = this.xCuestionarioDetalleDAO.mCrear(xCuestionarioDetalle);
                        if (!this.xTemporal.isEmpty()) {
                            for (int z2 = 0; z2 < this.xTemporal.size(); z2++) {
                                if (this.xTemporal.get(z2).getIdCDetalle() == Long.valueOf(this.xmodelocombo.getValueAt(y, 0).toString()) && this.xTemporal.get(z2).isAplica()) {
                                    CuestionarioDetalleSubCategoriaDTO CuestionarioDetalleSubCategoria = new CuestionarioDetalleSubCategoriaDTO();
                                    CuestionarioDetalleSubCategoria.setIdCDetalle(xIdCuestionarioDetalle);
                                    CuestionarioDetalleSubCategoria.setIdSubCategoria(this.xTemporal.get(z2).getIdSubCategoria());
                                    CuestionarioDetalleSubCategoria.setObservacion(this.xTemporal.get(z2).getObservacion());
                                    CuestionarioDetalleSubCategoria.setEstado(true);
                                    this.xCuestionarioDetalleSubCategoriaDAO.mCrear(CuestionarioDetalleSubCategoria);
                                }
                            }
                        }
                    }
                    Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                    mCargarDatosTabla(1);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    this.JBTGrabar.setEnabled(false);
                    mCargarTablaHistorico();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Faltan preguntas por contestar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este Cuestionario Ya Se Encuentra Grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "VMinimo", "VMaximo", "Seleccion", "Referencia"}) { // from class: Historia.JPSo_Cuestionario_N_V2.9
            Class[] types = {String.class, String.class, Double.class, Double.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalleCR.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleCR.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleCR.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleCR.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleCR.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaHistorico() {
        this.xModeloHistorico = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Pregunta", "Respuesta", "Observación"}) { // from class: Historia.JPSo_Cuestionario_N_V2.10
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xModeloHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 1);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 3);
    }

    private void mCargarTablaHistorico() {
        List<Object[]> list = this.xCuestionarioDAO.mListHistoricoCuestionario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), this.xtipo, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString());
        mCrearModeloTablaHistorico();
        for (int i = 0; i < list.size(); i++) {
            this.xModeloHistorico.addRow(this.xdatosH);
            this.xModeloHistorico.setValueAt(list.get(i)[0].toString(), i, 0);
            this.xModeloHistorico.setValueAt(list.get(i)[1].toString(), i, 1);
            this.xModeloHistorico.setValueAt(list.get(i)[2].toString(), i, 2);
            this.xModeloHistorico.setValueAt(list.get(i)[3].toString(), i, 3);
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x016b: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:26:0x016b */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x016f: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:28:0x016f */
    private void mCargarResultado() {
        String valor = this.JLB_Resultado.getText();
        System.out.println("valor obtenido: " + valor);
        mCrearModeloTablaR();
        if (!valor.isEmpty()) {
            this.xsql = "SELECT\n    `Id_Interno`\n    , `Nbre`\n    , `VMinimo`\n    , `VMaximo`\n    , IF((" + valor + ">=VMinimo AND " + valor + " <VMaximo), true, false) AS `Esta`\n FROM\n   `so_tipo_cuestionario_valoracion`\nWHERE (`Id_Cuestionario` ='" + this.xtipo + "')\nORDER BY `Id_Interno` asc ,  `NOrden` ASC";
            System.out.println("" + this.xsql);
            try {
                try {
                    ResultSet xrs = this.xct.traerRs(this.xsql);
                    Throwable th = null;
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int x = 0;
                        while (xrs.next()) {
                            this.xmodeloR.addRow(this.xdatos);
                            this.xmodeloR.setValueAt(xrs.getString("Id_Interno"), x, 0);
                            this.xmodeloR.setValueAt(xrs.getString("Nbre"), x, 1);
                            this.xmodeloR.setValueAt(Double.valueOf(xrs.getDouble("VMinimo")), x, 2);
                            this.xmodeloR.setValueAt(Double.valueOf(xrs.getDouble("VMaximo")), x, 3);
                            this.xmodeloR.setValueAt(Boolean.valueOf(xrs.getBoolean("Esta")), x, 4);
                            this.JTDetalleCR.setDefaultRenderer(Object.class, new MiRender());
                            x++;
                        }
                    } else {
                        this.JTPDatos.remove(1);
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
                    return;
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPSo_Cuestionario_N_V2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        System.out.println("error");
    }

    private void mCargarDatosTabla(int xforma) {
        mCrearModeloTablaS();
        List<Object[]> list = this.xCuestionarioDAO.mListCuestionario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), this.xtipo, xforma);
        this.xmt.mEstablecerTextEditor(this.tabla_combo, 3);
        this.xmt.mEstablecerTextEditor(this.tabla_combo, 4);
        if (!list.isEmpty()) {
            mCargarResultado();
            if (list.get(0)[3] != null) {
                this.JLB_Encabezado.setText("<html><P ALIGN=left><font color=#0000FF> " + list.get(0)[3] + "</font></p>");
            }
            this.xcomboBox3 = new JTableComboBox[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.xmodelocombo.addRow(this.xdatos);
                this.xmodelocombo.setValueAt(list.get(x)[0], x, 0);
                if (list.get(x)[1].toString().isEmpty()) {
                    if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(50);
                    } else {
                        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(0);
                        this.tabla_combo.getColumnModel().getColumn(1).setMinWidth(0);
                        this.tabla_combo.getColumnModel().getColumn(1).setMaxWidth(0);
                    }
                }
                this.xmodelocombo.setValueAt(list.get(x)[1], x, 1);
                this.agrupacionDato.put(list.get(x)[1].toString(), Double.valueOf(0.0d));
                this.xmodelocombo.setValueAt(Integer.valueOf(x + 1), x, 2);
                this.xmodelocombo.setValueAt(list.get(x)[2], x, 3);
                if (xforma == 0) {
                    DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo1(Integer.valueOf(list.get(x)[0].toString()).intValue(), x));
                    this.editors.add(defaultCellEditor);
                    this.xmodelocombo.setValueAt("", x, 4);
                    this.xmodelocombo.setValueAt(this.JLBNRegistro.getText(), x, 5);
                    this.xmodelocombo.setValueAt(0, x, 6);
                    this.xmodelocombo.setValueAt(0, x, 7);
                    this.xmodelocombo.setValueAt(0, x, 8);
                } else {
                    DefaultCellEditor defaultCellEditor2 = new DefaultCellEditor(mLlenaComboModelo1(Integer.valueOf(list.get(x)[0].toString()).intValue(), x));
                    this.editors.add(defaultCellEditor2);
                    this.xmodelocombo.setValueAt(list.get(x)[3].toString(), x, 4);
                    this.xmodelocombo.setValueAt(list.get(x)[4], x, 5);
                    this.xmodelocombo.setValueAt(list.get(x)[8], x, 6);
                    this.xmodelocombo.setValueAt(list.get(x)[9], x, 7);
                    this.xmodelocombo.setValueAt(list.get(x)[10], x, 8);
                    this.xmodelocombo.setValueAt(list.get(x)[11], x, 9);
                    this.JTAObservacionG.setText(list.get(x)[6].toString());
                    if (!list.get(x)[8].toString().equals("0")) {
                        this.JBTGrabar.setEnabled(false);
                    } else {
                        this.JBTGrabar.setEnabled(true);
                    }
                }
                this.xcomboBox3[x].addItemListener(new ItemListener() { // from class: Historia.JPSo_Cuestionario_N_V2.11
                    public void itemStateChanged(ItemEvent e) {
                        JPSo_Cuestionario_N_V2.this.mCambiaElementoCombo();
                    }
                });
            }
            mSumatoria();
            return;
        }
        mCargarDatosTabla(0);
    }

    private void mVerificarExistenciaEncuesta() {
        try {
            this.xsql = "SELECT `Id` FROM `h_so_cuestionarios_encabezado` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Cuestionario ='" + this.xtipo + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNRegistro.setText(xrs.getString(1));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                mCargarDatosTabla(1);
            } else {
                mCargarDatosTabla(0);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionario_N_V2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
                switch (this.xtipo) {
                    case 9:
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Estilo_Afronamiento", mparametros);
                        break;
                    case 10:
                    case 11:
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral", mparametros);
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral_Consolidado", mparametros);
                        break;
                    case 12:
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Fatiga", mparametros);
                        break;
                    default:
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
                        break;
                }
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Cuestionario_N_V2$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 4).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mCrearTablaSubCategoria() {
        this.xmodeloSubC = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Observación", "Aplica?"}) { // from class: Historia.JPSo_Cuestionario_N_V2.12
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTCategoria.setModel(this.xmodeloSubC);
        this.JTCategoria.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTCategoria.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTCategoria.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTCategoria.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTCategoria.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTCategoria.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarTablaSubCategorias() {
        List<CuestionarioDetalleSubCategoriaDTO> list;
        mCrearTablaSubCategoria();
        if (this.JLBNRegistro.getText().isEmpty()) {
            list = this.xCuestionarioDetalleSubCategoriaDAO.mListCuestionario(Long.valueOf(this.xmodelocombo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString()), 0);
        } else {
            list = this.xCuestionarioDetalleSubCategoriaDAO.mListCuestionario(Long.valueOf(this.xmodelocombo.getValueAt(this.tabla_combo.getSelectedRow(), 8).toString()), 1);
        }
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloSubC.addRow(this.xdatos1);
                this.xmodeloSubC.setValueAt(list.get(x).getIdSubCategoria(), x, 0);
                this.xmodeloSubC.setValueAt(list.get(x).getNbreSubCategoria(), x, 1);
                this.xmodeloSubC.setValueAt(list.get(x).getObservacion(), x, 2);
                this.xmodeloSubC.setValueAt(Boolean.valueOf(list.get(x).isAplica()), x, 3);
                if (this.JLBNRegistro.getText().isEmpty()) {
                    llenarTablaConInformacionDeTemporal(Long.valueOf(this.xmodelocombo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString()), list.get(x).getIdSubCategoria(), x);
                }
            }
        }
    }

    private void llenarTablaConInformacionDeTemporal(Long IdPregunta, Long IdSubCategoria, int pos) {
        if (!this.xTemporal.isEmpty()) {
            for (int x = 0; x < this.xTemporal.size(); x++) {
                if (Objects.equals(this.xTemporal.get(x).getIdCDetalle(), IdPregunta) && Objects.equals(this.xTemporal.get(x).getIdSubCategoria(), IdSubCategoria)) {
                    this.xmodeloSubC.setValueAt(this.xTemporal.get(x).getObservacion(), pos, 2);
                    this.xmodeloSubC.setValueAt(Boolean.valueOf(this.xTemporal.get(x).isAplica()), pos, 3);
                    return;
                }
            }
        }
    }
}
