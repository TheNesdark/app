package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPATestSmokingAndSubstance.class */
public class JPATestSmokingAndSubstance extends JPanel {
    private CuestionarioDAO xCuestionarioDAO;
    private CuestionarioDetalleDAO xCuestionarioDetalleDAO;
    private CuestionarioDetalleSubCategoriaDAO xCuestionarioDetalleSubCategoriaDAO;
    private DefaultTableModel modeloPreguntas;
    JTableComboBox[] xcomboBox3;
    public DefaultTableModel xmodeloSubC;
    JComboBox xcomboBox;
    JComboBox[] xcomboBox1;
    private String[][] xidgenerico;
    private DefaultTableModel modcombos;
    private DefaultTableModel modeloRespuestas;
    private String xsql;
    private Object[] xdatos;
    private String numeroCuestionario;
    private JButton JBTGrabar;
    public JLabel JLBNRegistro;
    private JPanel JSPResultado;
    private JScrollPane JSPResultados;
    private JScrollPane JSPTablaPreguntas;
    private JTable JTPreguntas;
    private JTable JTResultado;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private boolean xlleno = false;
    ArrayList editors = new ArrayList();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private double resultadoTabaco = 0.0d;
    private double resultadoAlcohol = 0.0d;
    private double resultadoCannabis = 0.0d;
    private double resultadoCocaina = 0.0d;
    private double resultadoAnfetaminas = 0.0d;
    private double resultadoInhalante = 0.0d;
    private double resultadoSedante = 0.0d;
    private double resultadoAlucinogenos = 0.0d;
    private double resultadoOpiacetos = 0.0d;
    private double resultadoOtrasDrogas = 0.0d;
    private double[] resultados = new double[10];
    List<Object[]> listaGeneral = new ArrayList();

    public JPATestSmokingAndSubstance() {
        initComponents();
        springStart();
        nuevo();
        setEventoMouseClicked(this.JTPreguntas);
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xCuestionarioDAO = (CuestionarioDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDAO");
        this.xCuestionarioDetalleDAO = (CuestionarioDetalleDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDetalleDAO");
        this.xCuestionarioDetalleSubCategoriaDAO = (CuestionarioDetalleSubCategoriaDAOImpl) classPathXmlApplicationContext.getBean("cuestionarioDetalleSubCategoriaDAO");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JSPTablaPreguntas = new JScrollPane();
        this.JTPreguntas = new JTable();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        this.jPanel2 = new JPanel();
        this.JSPResultado = new JPanel();
        this.JSPResultados = new JScrollPane();
        this.JTResultado = new JTable();
        setName("JPATestSmokingAnd Substance");
        this.jTabbedPane1.setName("JPATestSmokingAndSubstance");
        this.JSPTablaPreguntas.setBorder(BorderFactory.createTitledBorder((Border) null, "Preguntas", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPreguntas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTPreguntas.setName("Preguntas");
        this.JSPTablaPreguntas.setViewportView(this.JTPreguntas);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.1
            public void actionPerformed(ActionEvent evt) {
                JPATestSmokingAndSubstance.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPTablaPreguntas, -1, 846, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 536, -2).addGap(137, 137, 137).addComponent(this.JLBNRegistro, -2, 151, -2).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPTablaPreguntas, -2, 452, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGrabar, -2, 56, -2).addComponent(this.JLBNRegistro, -2, 53, -2))));
        this.jTabbedPane1.addTab("Preguntas", this.jPanel1);
        this.jPanel2.setName("Resultado");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPResultados.setViewportView(this.JTResultado);
        GroupLayout JSPResultadoLayout = new GroupLayout(this.JSPResultado);
        this.JSPResultado.setLayout(JSPResultadoLayout);
        JSPResultadoLayout.setHorizontalGroup(JSPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultados, -1, 824, 32767));
        JSPResultadoLayout.setVerticalGroup(JSPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultados, -1, 502, 32767));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSPResultado, -1, -1, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        this.jTabbedPane1.addTab("Resultado", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        String[] columnNames = {"Id", "Categoria", "N°", "Pregunta", "Respuesta", "id_cuestionario", "ValorC", "IdRespuesta", "IdC_detalle", "Observacion"};
        this.modeloPreguntas = new DefaultTableModel(new Object[0], columnNames) { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.2
            Class[] types = {Integer.class, String.class, Integer.class, String.class, JTableComboBox[].class, Long.class, Double.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPreguntas = new JTable(this.modeloPreguntas) { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.3
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 4 && row < JPATestSmokingAndSubstance.this.JTPreguntas.getRowCount()) {
                    return (TableCellEditor) JPATestSmokingAndSubstance.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.JTPreguntas.setFont(new Font("Arial", 1, 12));
        this.JTPreguntas.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTPreguntas.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTPreguntas.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTPreguntas.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTPreguntas.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(9).setPreferredWidth(170);
        this.JSPTablaPreguntas.getViewport().add(this.JTPreguntas);
    }

    private void mVerificarExistenciaEncuesta() {
        try {
            this.xsql = "SELECT `Id` FROM `h_so_cuestionarios_encabezado` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Cuestionario ='38' AND `Estado` =1) ";
            System.out.println("Seleciona para ver si tiene cuestionario activo-->" + this.xsql);
            ResultSet xrs = this.xct.getResultSet(this.xsql);
            if (xrs.next()) {
                xrs.first();
                System.out.println("" + xrs.getString("Id"));
                this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JLBNRegistro.setText(xrs.getString("Id"));
                cargarDatosTabla(1);
            } else {
                cargarDatosTabla(0);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void inicializarResultado() {
        for (int j = 0; j < 10; j++) {
            this.resultados[j] = 0.0d;
        }
    }

    public void mGrabar() {
        if ((this.JBTGrabar.isEnabled() && this.JLBNRegistro.getText().isEmpty()) || this.JLBNRegistro.getText() == null) {
            if (!this.metodos.mVerificarDatosLLenoCero(this.JTPreguntas, 7)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String xValorT = "";
                    System.out.println("tamaño resultado " + this.JTResultado.getRowCount());
                    for (int z = 0; z < this.JTResultado.getRowCount(); z++) {
                        if (Boolean.valueOf(this.modeloRespuestas.getValueAt(z, 4).toString()).booleanValue()) {
                            xValorT = this.JTResultado.getValueAt(z, 1).toString();
                        }
                    }
                    CuestionarioDTO xObjEncabezado = new CuestionarioDTO();
                    xObjEncabezado.setIdUsuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                    xObjEncabezado.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                    xObjEncabezado.setFechaR(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
                    xObjEncabezado.setIdCuestionario(38L);
                    xObjEncabezado.setObservacion("");
                    xObjEncabezado.setIdEspecialidad(Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()));
                    xObjEncabezado.setIdProfesional(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()));
                    xObjEncabezado.setCerrado(true);
                    xObjEncabezado.setResultadoTexto(xValorT);
                    xObjEncabezado.setResultadoValor("");
                    xObjEncabezado.setUUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    Long xIdEncabezado = this.xCuestionarioDAO.mCrear(xObjEncabezado);
                    this.JLBNRegistro.setText(String.valueOf(xIdEncabezado));
                    for (int y = 0; y < this.JTPreguntas.getRowCount(); y++) {
                        System.out.println("modelo xValorc" + Double.valueOf(this.modeloPreguntas.getValueAt(y, 6).toString().replace(",", ".")));
                        CuestionarioDetalleDTO xCuestionarioDetalle = new CuestionarioDetalleDTO();
                        xCuestionarioDetalle.setIdCuestionario(xIdEncabezado);
                        xCuestionarioDetalle.setIdPregunta(Long.valueOf(this.modeloPreguntas.getValueAt(y, 0).toString()));
                        xCuestionarioDetalle.setIdRespuesta(Long.valueOf(this.modeloPreguntas.getValueAt(y, 7).toString()));
                        xCuestionarioDetalle.setValorR(this.modeloPreguntas.getValueAt(y, 4).toString());
                        xCuestionarioDetalle.setValorC(Long.valueOf((long) 0.0d));
                        xCuestionarioDetalle.setObservacion(this.modeloPreguntas.getValueAt(y, 9).toString());
                        xCuestionarioDetalle.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.xCuestionarioDetalleDAO.mCrear(xCuestionarioDetalle);
                    }
                    cargarDatosTabla(1);
                    this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Faltan preguntas por contestar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este Cuestionario Ya Se Encuentra Grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void cargarDatosTabla(int id) {
        crearModelo();
        this.metodos.mEstablecerTextEditor(this.JTPreguntas, 1);
        this.metodos.mEstablecerTextEditor(this.JTPreguntas, 3);
        List<Object[]> list = this.xCuestionarioDAO.mListCuestionarioSmoking(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), 38, id);
        if (list.size() > 0) {
            this.xcomboBox3 = new JTableComboBox[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.modeloPreguntas.addRow(this.xdatos);
                this.modeloPreguntas.setValueAt(list.get(x)[0], x, 0);
                if (list.get(x)[1].toString().isEmpty()) {
                    this.JTPreguntas.getColumnModel().getColumn(1).setPreferredWidth(0);
                    this.JTPreguntas.getColumnModel().getColumn(1).setMinWidth(0);
                    this.JTPreguntas.getColumnModel().getColumn(1).setMaxWidth(0);
                    this.modeloPreguntas.setValueAt(list.get(x)[3], x, 2);
                }
                this.modeloPreguntas.setValueAt(list.get(x)[1], x, 1);
                this.modeloPreguntas.setValueAt(list.get(x)[3], x, 2);
                this.modeloPreguntas.setValueAt(list.get(x)[2], x, 3);
                if (id == 0) {
                    DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo1(Integer.valueOf(list.get(x)[0].toString()).intValue(), x));
                    this.editors.add(defaultCellEditor);
                    this.modeloPreguntas.setValueAt("", x, 9);
                    this.modeloPreguntas.setValueAt(this.numeroCuestionario, x, 5);
                    this.modeloPreguntas.setValueAt(0, x, 6);
                    this.modeloPreguntas.setValueAt(0, x, 7);
                    this.modeloPreguntas.setValueAt(0, x, 8);
                } else {
                    DefaultCellEditor defaultCellEditor2 = new DefaultCellEditor(mLlenaComboModelo1(Integer.valueOf(list.get(x)[0].toString()).intValue(), x));
                    this.editors.add(defaultCellEditor2);
                    this.modeloPreguntas.setValueAt(list.get(x)[3].toString(), x, 4);
                    this.modeloPreguntas.setValueAt(list.get(x)[4], x, 9);
                    this.modeloPreguntas.setValueAt(list.get(x)[8], x, 5);
                    this.modeloPreguntas.setValueAt(list.get(x)[9], x, 6);
                    this.modeloPreguntas.setValueAt(list.get(x)[10], x, 7);
                    this.modeloPreguntas.setValueAt(list.get(x)[11], x, 8);
                    this.modeloPreguntas.setValueAt(list.get(x)[12], x, 2);
                    if (!list.get(x)[8].toString().equals("0")) {
                    }
                }
                this.xcomboBox3[x].addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.4
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("item seleccionado-->" + e.getItem());
                        JPATestSmokingAndSubstance.this.mCambiaElementoCombo();
                        JPATestSmokingAndSubstance.this.llenarComboApartirDeLaprimeraSeleccion(JPATestSmokingAndSubstance.this.JTPreguntas.getSelectedRow(), JPATestSmokingAndSubstance.this.JTPreguntas.getRowCount(), "NO");
                        JPATestSmokingAndSubstance.this.llenarComboApartirDeLaprimeraSeleccion(JPATestSmokingAndSubstance.this.JTPreguntas.getSelectedRow() + 10, 60, "Nunca");
                    }
                });
            }
            if (id == 1) {
                mSumatoria();
                return;
            }
            return;
        }
        cargarDatosTabla(0);
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
        }
        return this.xcomboBox3[xFila];
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.5
            public void mouseClicked(MouseEvent e) {
                JPATestSmokingAndSubstance.this.JTPreguntasMouseClicked(e);
            }
        });
    }

    private JComboBox mLlenaComboModelo(int xid, int xFila) {
        System.out.println("Fila creada---->" + xFila);
        this.xcomboBox1[xFila] = new JComboBox();
        this.xcomboBox1[xFila].setName("combo" + xFila);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        String sql = "SELECT `so_tipo_respuesta`.`Id`, `so_tipo_respuesta`.`Nbre`, `so_tipo_pregunta_respuesta`.VCuantitativo   FROM `so_tipo_pregunta_respuesta` INNER JOIN  `so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)    INNER JOIN  `so_tipo_respuesta`  ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)    WHERE (`so_tipo_pregunta_respuesta`.`Estado` =1 AND `so_tipo_preguntas`.`Id` ='" + xid + "') ORDER BY `so_tipo_pregunta_respuesta`.`NOrden` ASC ";
        this.xidgenerico = xct1.llenarComboyLista(sql, this.xidgenerico, this.xcomboBox1[xFila], 3);
        this.xcomboBox1[xFila].setSelectedIndex(-1);
        xct1.cerrarConexionBd();
        this.xlleno = true;
        return this.xcomboBox1[xFila];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPreguntasMouseClicked(MouseEvent evt) {
        if (this.JTPreguntas.getSelectedRow() > -1) {
            mCambiaElementoCombo();
            llenarComboApartirDeLaprimeraSeleccion(this.JTPreguntas.getSelectedRow(), this.JTPreguntas.getRowCount(), "NO");
            if (this.JTPreguntas.getSelectedRow() > 9 && this.JTPreguntas.getSelectedRow() < 20) {
                llenarComboApartirDeLaprimeraSeleccion(this.JTPreguntas.getSelectedRow() + 10, 60, "Nunca");
            }
            System.out.println("Se seleccionó la fila-->" + this.JTPreguntas.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llenarComboApartirDeLaprimeraSeleccion(int fila, int fin, String palabra) {
        if (this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 1).equals(palabra)) {
            for (int j = fila; j < fin; j++) {
                if (this.JTPreguntas.getValueAt(j, 2).toString().equals(this.JTPreguntas.getValueAt(fila, 2).toString()) && this.xlleno) {
                    DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo1(Integer.parseInt(this.modeloPreguntas.getValueAt(j, 0).toString()), j));
                    this.editors.add(defaultCellEditor);
                    this.modeloPreguntas.setValueAt("Nunca", j, 4);
                    if (j > 9) {
                        this.xcomboBox3[j].setSelectedIndex(0);
                    }
                    mCambiaElementoCombo2(j);
                    this.modeloPreguntas.fireTableDataChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCambiaElementoCombo() {
        if (this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.modeloPreguntas.setValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex(), 0), this.JTPreguntas.getSelectedRow(), 7);
            this.modeloPreguntas.setValueAt(Double.valueOf(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex(), 2).toString()), this.JTPreguntas.getSelectedRow(), 6);
            System.out.println("tabla preguntas " + this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex(), 0));
            if (this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex(), 1) != null && this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.JTPreguntas.getSelectedRow()].getSelectedIndex(), 1).toString().equals("SI")) {
                System.out.println("Entro a los datos");
            } else {
                System.out.println("Entro al modelo---- :(");
            }
        } else {
            System.out.println("Entro al modelo---- :(");
        }
        mSumatoria();
    }

    private void nuevo() {
        mVerificarExistenciaEncuesta();
        verificarHistoriaCerrada();
    }

    private void mSumatoria() {
        inicializarResultado();
        for (int x = 0; x < this.JTPreguntas.getRowCount(); x++) {
            if (!this.modeloPreguntas.getValueAt(x, 6).toString().equals("0")) {
                switch (((Integer) this.modeloPreguntas.getValueAt(x, 2)).intValue()) {
                    case 1:
                        this.resultados[0] = this.resultados[0] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 2:
                        this.resultados[1] = this.resultados[1] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 3:
                        this.resultados[2] = this.resultados[2] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 4:
                        this.resultados[3] = this.resultados[3] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 5:
                        this.resultados[4] = this.resultados[4] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 6:
                        this.resultados[5] = this.resultados[5] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 7:
                        this.resultados[6] = this.resultados[6] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 8:
                        this.resultados[7] = this.resultados[7] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 9:
                        this.resultados[8] = this.resultados[8] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                    case 10:
                        this.resultados[9] = this.resultados[9] + Double.parseDouble(this.modeloPreguntas.getValueAt(x, 6).toString());
                        break;
                }
            }
        }
        cargarResultado();
    }

    public void cargarResultado() {
        crearModeloResultado();
        this.listaGeneral = new ArrayList();
        for (int j = 0; j <= 9; j++) {
            List<Object[]> lista = this.xCuestionarioDAO.mResultadoPorItems(j + 1, this.resultados[j]);
            if (lista.size() > 0) {
                for (int x = 0; x < 3; x++) {
                    this.listaGeneral.add(lista.get(x));
                }
            }
        }
        if (this.listaGeneral.size() > 0) {
            for (int j2 = 0; j2 < this.listaGeneral.size(); j2++) {
                this.modeloRespuestas.addRow(this.xdatos);
                for (int x2 = 0; x2 < 6; x2++) {
                    this.modeloRespuestas.setValueAt(this.listaGeneral.get(j2)[x2], j2, x2);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                }
            }
        }
    }

    private void mCambiaElementoCombo2(int fila) {
        if (this.xcomboBox3[fila].getSelectedIndex() != -1 && this.xlleno) {
            this.modeloPreguntas.setValueAt(this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 0), fila, 7);
            this.modeloPreguntas.setValueAt(Double.valueOf(this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 2).toString()), fila, 6);
            System.out.println("tabla preguntas " + this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 0));
            if (this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 1) != null && this.xcomboBox3[fila].getPopupTable().getValueAt(this.xcomboBox3[fila].getSelectedIndex(), 1).toString().equals("SI")) {
                System.out.println("Entro a los datos");
                return;
            } else {
                System.out.println("Entro al modelo---- :(");
                return;
            }
        }
        System.out.println("Entro al modelo---- :(");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPATestSmokingAndSubstance$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5) != null) {
                if (Boolean.valueOf(table.getValueAt(row, 5).toString()).booleanValue()) {
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloResultado() {
        String[] columnNames = {"Id", "Sustancia", "Valor Minimo", "Valor Maximo", "Resultado", "Selecion"};
        this.modeloRespuestas = new DefaultTableModel(new Object[0], columnNames) { // from class: com.genoma.plus.controller.historia.JPATestSmokingAndSubstance.6
            Class[] types = {Integer.class, String.class, Integer.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.modeloRespuestas);
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JSPResultados.getViewport().add(this.JTResultado);
    }

    private void verificarHistoriaCerrada() {
        String sql = "SELECT TipoGuardado FROM h_atencion WHERE Id = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next() && rs.getInt("TipoGuardado") == 1) {
                this.JBTGrabar.setEnabled(false);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
