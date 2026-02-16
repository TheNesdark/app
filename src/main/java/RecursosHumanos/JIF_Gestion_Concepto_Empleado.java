package RecursosHumanos;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.rrhh.GeneralDAOImpl;
import com.genoma.plus.dao.impl.rrhh.GestionConceptoPersonaDAOImpl;
import com.genoma.plus.dao.rrhh.GeneralRhDAO;
import com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIF_Gestion_Concepto_Empleado.class */
public class JIF_Gestion_Concepto_Empleado extends JInternalFrame {
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xId_UnidadF;
    private String[] xId_Concepto;
    private GeneralRhDAO generalRhDAO;
    private GestionConceptoPersonaDAO gestionConceptoPersonaDAO;
    private ButtonGroup JBG_Accion;
    private ButtonGroup JBG_Forma;
    private JButton JBT_Actualizar1;
    private JComboBox JCB_Concepto;
    private JComboBox JCB_UnidadF;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_FiltroSoloConcepto;
    private JPanel JPI_Accion;
    private JPanel JPI_Filtro;
    private JPanel JPI_Seleccion;
    private JRadioButton JRBActivar;
    private JRadioButton JRBActivar1;
    private JRadioButton JRB_Ninguno;
    private JRadioButton JRB_Todos;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTFBuscarPorNombre;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIF_Gestion_Concepto_Empleado() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Forma = new ButtonGroup();
        this.JBG_Accion = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JCB_UnidadF = new JComboBox();
        this.JCB_Concepto = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JCH_FiltroSoloConcepto = new JCheckBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JPI_Seleccion = new JPanel();
        this.JRBActivar = new JRadioButton();
        this.JRBActivar1 = new JRadioButton();
        this.JPI_Accion = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Ninguno = new JRadioButton();
        this.JBT_Actualizar1 = new JButton();
        this.JTFBuscarPorNombre = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE CONCEPTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_gestion_concepto_empleado");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_UnidadF.setFont(new Font("Arial", 1, 12));
        this.JCB_UnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_UnidadF.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JCB_UnidadFItemStateChanged(evt);
            }
        });
        this.JCB_Concepto.setFont(new Font("Arial", 1, 12));
        this.JCB_Concepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro?");
        this.JCH_FiltroSoloConcepto.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroSoloConcepto.setText("SoloConcepto?");
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCB_UnidadF, -2, 320, -2).addGap(18, 18, 18).addComponent(this.JCB_Concepto, -2, 617, -2).addGap(18, 18, 18).addComponent(this.JCH_Filtro).addGap(18, 18, 18).addComponent(this.JCH_FiltroSoloConcepto).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_UnidadF, -2, 50, -2).addComponent(this.JCB_Concepto, -2, 50, -2).addComponent(this.JCH_Filtro).addComponent(this.JCH_FiltroSoloConcepto)).addContainerGap(23, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JTB_Detalle.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.2
            public void keyPressed(KeyEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JTB_DetalleKeyPressed(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JPI_Seleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBG_Forma.add(this.JRBActivar);
        this.JRBActivar.setFont(new Font("Arial", 1, 12));
        this.JRBActivar.setText("Activar");
        this.JRBActivar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JRBActivarActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRBActivar1);
        this.JRBActivar1.setFont(new Font("Arial", 1, 12));
        this.JRBActivar1.setText("Desactivar");
        this.JRBActivar1.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JRBActivar1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_SeleccionLayout = new GroupLayout(this.JPI_Seleccion);
        this.JPI_Seleccion.setLayout(JPI_SeleccionLayout);
        JPI_SeleccionLayout.setHorizontalGroup(JPI_SeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBActivar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBActivar1).addContainerGap(-1, 32767)));
        JPI_SeleccionLayout.setVerticalGroup(JPI_SeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBActivar).addComponent(this.JRBActivar1, -2, 23, -2)));
        this.JPI_Accion.setBorder(BorderFactory.createTitledBorder((Border) null, "Selección", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBG_Accion.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Accion.add(this.JRB_Ninguno);
        this.JRB_Ninguno.setFont(new Font("Arial", 1, 12));
        this.JRB_Ninguno.setSelected(true);
        this.JRB_Ninguno.setText("Ninguno");
        this.JRB_Ninguno.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JRB_NingunoActionPerformed(evt);
            }
        });
        GroupLayout JPI_AccionLayout = new GroupLayout(this.JPI_Accion);
        this.JPI_Accion.setLayout(JPI_AccionLayout);
        JPI_AccionLayout.setHorizontalGroup(JPI_AccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Ninguno).addContainerGap(-1, 32767)));
        JPI_AccionLayout.setVerticalGroup(JPI_AccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Ninguno, -2, 23, -2)));
        this.JBT_Actualizar1.setFont(new Font("Arial", 1, 12));
        this.JBT_Actualizar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBT_Actualizar1.setText("Inicializar Valores(Fijos - No Horas)");
        this.JBT_Actualizar1.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JBT_Actualizar1ActionPerformed(evt);
            }
        });
        this.JTFBuscarPorNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por nombre o cedula", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFBuscarPorNombre.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Concepto_Empleado.this.JTFBuscarPorNombreActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSP_Detalle).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Seleccion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPI_Accion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFBuscarPorNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Actualizar1, -2, 301, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -2, 563, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Seleccion, -1, -1, 32767).addComponent(this.JPI_Accion, -1, -1, 32767).addComponent(this.JBT_Actualizar1, -2, 50, -2).addComponent(this.JTFBuscarPorNombre, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_UnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_UnidadF.getSelectedIndex() != -1) {
            this.JCB_Concepto.removeAllItems();
            List<Object[]> listaConcepto = this.generalRhDAO.listadoConceptoNominaUnidadFuncional(this.xId_UnidadF[this.JCB_UnidadF.getSelectedIndex()]);
            if (!listaConcepto.isEmpty()) {
                this.xId_Concepto = new String[listaConcepto.size()];
                for (int x = 0; x < listaConcepto.size(); x++) {
                    this.xId_Concepto[x] = String.valueOf(listaConcepto.get(x)[0]);
                    this.JCB_Concepto.addItem(listaConcepto.get(x)[1]);
                }
                this.JCB_Concepto.setSelectedIndex(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivarActionPerformed(ActionEvent evt) {
        mActivarDesactivar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivar1ActionPerformed(ActionEvent evt) {
        mActivarDesactivar(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            mSeleccionar(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NingunoActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            mSeleccionar(false);
        }
    }

    private void mSeleccionar(boolean estado) {
        for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(estado), x, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Actualizar1ActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            Object[] botones = {"Todo(Valor fijo - No Horas)", "Por Concepto (Valor Fijo)", "No Horas", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea actualizar?", "ACTUALIZACIÓN DE INFORMACIÓN NOMINA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.gestionConceptoPersonaDAO.iniciarValoresFijos("", "");
                this.gestionConceptoPersonaDAO.iniciarValoresHoras("", "");
                cargarDatosTabla();
                return;
            }
            if (n == 1) {
                for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 10).toString()).booleanValue()) {
                        this.gestionConceptoPersonaDAO.iniciarValoresFijos(this.xmodelo.getValueAt(x, 9).toString(), this.xmodelo.getValueAt(x, 8).toString());
                        cargarDatosTabla();
                    }
                }
                return;
            }
            if (n == 2) {
                for (int x2 = 0; x2 < this.JTB_Detalle.getRowCount(); x2++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x2, 10).toString()).booleanValue()) {
                        this.gestionConceptoPersonaDAO.iniciarValoresHoras(this.xmodelo.getValueAt(x2, 9).toString(), this.xmodelo.getValueAt(x2, 8).toString());
                        cargarDatosTabla();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleKeyPressed(KeyEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != 1) {
            if (this.JTB_Detalle.getSelectedColumn() == 5 || this.JTB_Detalle.getSelectedColumn() == 6 || this.JTB_Detalle.getSelectedColumn() == 7) {
                if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
                    if (this.JTB_Detalle.isEditing()) {
                        this.JTB_Detalle.getCellEditor().stopCellEditing();
                    }
                    this.gestionConceptoPersonaDAO.actualizarValoresConceptoPersona(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 9).toString(), this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString(), Boolean.valueOf(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 7).toString()), Double.valueOf(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 5).toString()), Double.valueOf(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 6).toString()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarPorNombreActionPerformed(ActionEvent evt) {
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.generalRhDAO = (GeneralDAOImpl) classPathXmlApplicationContext.getBean("generalDAO1");
        this.gestionConceptoPersonaDAO = (GestionConceptoPersonaDAOImpl) classPathXmlApplicationContext.getBean("gestionConceptoPersonaDAOImpl");
    }

    public void mGrabar() {
        int z = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (z == 0) {
            for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 10).toString()).booleanValue()) {
                    this.gestionConceptoPersonaDAO.actualizarValoresConceptoPersona(this.xmodelo.getValueAt(x, 9).toString(), this.xmodelo.getValueAt(x, 8).toString(), Boolean.valueOf(this.xmodelo.getValueAt(x, 7).toString()), Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()), Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()));
                }
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCB_Concepto.removeAllItems();
        this.JCB_UnidadF.removeAllItems();
        List<Object[]> listaUnidadFucional = this.generalRhDAO.listadoUnidadFuncionalConceptoNomina();
        if (!listaUnidadFucional.isEmpty()) {
            this.xId_UnidadF = new String[listaUnidadFucional.size()];
            for (int x = 0; x < listaUnidadFucional.size(); x++) {
                this.xId_UnidadF[x] = String.valueOf(listaUnidadFucional.get(x)[0]);
                this.JCB_UnidadF.addItem(listaUnidadFucional.get(x)[1]);
            }
        }
        this.JCB_UnidadF.setSelectedIndex(-1);
        this.xlleno = true;
        crearTablaDatos();
    }

    private void crearTablaDatos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Empleado", "Unidad Funcional", "Concepto", "FormaCalculo", "Valor", "NoHoras", "Estado", "Id_Persona", "Id_Concepto", "Aplica?"}) { // from class: RecursosHumanos.JIF_Gestion_Concepto_Empleado.9
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Boolean.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(50);
    }

    private void cargarDatosTabla() {
        List<Object[]> listadoPersonasConcepto;
        crearTablaDatos();
        if (this.JCH_Filtro.isSelected() && !this.JCH_FiltroSoloConcepto.isSelected()) {
            listadoPersonasConcepto = this.gestionConceptoPersonaDAO.listadoConceptosPersona(this.xId_Concepto[this.JCB_Concepto.getSelectedIndex()], 0, this.JTFBuscarPorNombre.getText());
        } else if (this.JCH_FiltroSoloConcepto.isSelected()) {
            listadoPersonasConcepto = this.gestionConceptoPersonaDAO.listadoConceptosPersona(this.xId_Concepto[this.JCB_Concepto.getSelectedIndex()], 1, this.JTFBuscarPorNombre.getText());
        } else {
            listadoPersonasConcepto = this.gestionConceptoPersonaDAO.listadoConceptosPersona("", 0, this.JTFBuscarPorNombre.getText());
        }
        if (!listadoPersonasConcepto.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTB_Detalle, 1);
            this.xmt.mEstablecerTextEditor(this.JTB_Detalle, 2);
            this.xmt.mEstablecerTextEditor(this.JTB_Detalle, 3);
            for (int i = 0; i < listadoPersonasConcepto.size(); i++) {
                this.xmodelo.addRow(this.xdato);
                for (int j = 0; j < this.JTB_Detalle.getColumnCount(); j++) {
                    this.xmodelo.setValueAt(listadoPersonasConcepto.get(i)[j], i, j);
                }
            }
        }
    }

    public void mBuscar() {
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCB_Concepto.getSelectedIndex() != -1) {
                cargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_Concepto.requestFocus();
                return;
            }
        }
        cargarDatosTabla();
    }

    private void mActivarDesactivar(boolean estado) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                if (this.JRB_Todos.isSelected()) {
                    this.xmodelo.setValueAt(Boolean.valueOf(estado), x, 7);
                } else if (Long.valueOf(this.xmodelo.getValueAt(x, 6).toString()) == Long.valueOf(this.xId_UnidadF[this.JCB_UnidadF.getSelectedIndex()])) {
                    this.xmodelo.setValueAt(Boolean.valueOf(estado), x, 7);
                }
            }
        }
    }
}
