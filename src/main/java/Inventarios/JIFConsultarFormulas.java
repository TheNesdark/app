package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultarFormulas.class */
public class JIFConsultarFormulas extends JInternalFrame {
    private String[] xidtipoformula;
    private String[] xmunicipio;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private JComboBox JCBMunicipio;
    private JComboBox JCBTipoFormula;
    public static JCheckBox JCHFiltro;
    private JCheckBox JCH_Clasificado;
    private JCheckBox JCH_Interconsulta;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLNFormulas;
    private JLabel JLNItems;
    private JTabbedPane JPDatos;
    private JPanel JPIDatos;
    private JPanel JPIFormulas;
    private JPanel JPIItems;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JTable JTBDetalle2;
    private JTextField JTFNombreBusqueda;
    private ConsultasMySQL xconsultabd = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFConsultarFormulas() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBMunicipio = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoFormula = new JComboBox();
        this.JLNFormulas = new JLabel();
        this.JLNItems = new JLabel();
        JCHFiltro = new JCheckBox();
        this.JTFNombreBusqueda = new JTextField();
        this.JCH_Clasificado = new JCheckBox();
        this.JCH_Interconsulta = new JCheckBox();
        this.JPDatos = new JTabbedPane();
        this.JPIFormulas = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JPIItems = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTBDetalle2 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR FORMULA PARA DESPACHO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifconsultarformulas");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: Inventarios.JIFConsultarFormulas.1
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarFormulas.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoFormula.setFont(new Font("Arial", 1, 12));
        this.JCBTipoFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoFormula.addItemListener(new ItemListener() { // from class: Inventarios.JIFConsultarFormulas.2
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarFormulas.this.JCBTipoFormulaItemStateChanged(evt);
            }
        });
        this.JLNFormulas.setBackground(new Color(255, 255, 255));
        this.JLNFormulas.setFont(new Font("Arial", 1, 18));
        this.JLNFormulas.setForeground(Color.red);
        this.JLNFormulas.setHorizontalAlignment(0);
        this.JLNFormulas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Formulas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLNItems.setBackground(new Color(255, 255, 255));
        this.JLNItems.setFont(new Font("Arial", 1, 18));
        this.JLNItems.setForeground(Color.red);
        this.JLNItems.setHorizontalAlignment(0);
        this.JLNItems.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Items", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCHFiltro.setFont(new Font("Arial", 1, 12));
        JCHFiltro.setText("Filtro TF?");
        JCHFiltro.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultarFormulas.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarFormulas.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFConsultarFormulas.4
            public void keyTyped(KeyEvent evt) {
                JIFConsultarFormulas.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFConsultarFormulas.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        this.JCH_Clasificado.setBackground(new Color(133, 218, 160));
        this.JCH_Clasificado.setFont(new Font("Arial", 1, 12));
        this.JCH_Clasificado.setText("Despachado");
        this.JCH_Clasificado.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultarFormulas.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarFormulas.this.JCH_ClasificadoActionPerformed(evt);
            }
        });
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Entregado");
        this.JCH_Interconsulta.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultarFormulas.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarFormulas.this.JCH_InterconsultaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombreBusqueda, GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoFormula, -2, 223, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMunicipio, -2, 196, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLNFormulas, -2, 93, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLNItems, -2, 93, -2).addComponent(this.JCH_Clasificado, GroupLayout.Alignment.TRAILING, -2, 104, -2)).addComponent(this.JCH_Interconsulta)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoFormula, -2, 50, -2).addComponent(this.JCBMunicipio, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JLNItems, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JLNFormulas, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(JCHFiltro, GroupLayout.Alignment.TRAILING))).addGap(0, 6, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreBusqueda, -2, 50, -2).addComponent(this.JCH_Interconsulta)).addComponent(this.JCH_Clasificado)).addGap(10, 10, 10)));
        this.JPDatos.setForeground(new Color(0, 103, 0));
        this.JPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultarFormulas.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarFormulas.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ORDENES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        GroupLayout JPIFormulasLayout = new GroupLayout(this.JPIFormulas);
        this.JPIFormulas.setLayout(JPIFormulasLayout);
        JPIFormulasLayout.setHorizontalGroup(JPIFormulasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormulasLayout.createSequentialGroup().addContainerGap().addGroup(JPIFormulasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JSPDetalle1, -1, 972, 32767)).addContainerGap()));
        JPIFormulasLayout.setVerticalGroup(JPIFormulasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormulasLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JSPDetalle, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -1, 100, 32767).addContainerGap()));
        this.JPDatos.addTab("FORMULAS", this.JPIFormulas);
        this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle2.setRowHeight(25);
        this.JTBDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle2.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTBDetalle2);
        GroupLayout JPIItemsLayout = new GroupLayout(this.JPIItems);
        this.JPIItems.setLayout(JPIItemsLayout);
        JPIItemsLayout.setHorizontalGroup(JPIItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIItemsLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -2, 932, -2).addContainerGap(46, 32767)));
        JPIItemsLayout.setVerticalGroup(JPIItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIItemsLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -1, 361, 32767).addContainerGap()));
        this.JPDatos.addTab("C.PRODUCTOS", this.JPIItems);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(30, 30, 30).addComponent(this.JPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Consultar Items", "Imprimir", "Cambiar Estado", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "FORMULA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mCargarDatosTabla1();
                return;
            }
            if (n == 1) {
                mImprimir(Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()).longValue(), 2);
                return;
            }
            if (n == 2) {
                Object[] botones1 = {"Generada", "Empacada", "Cerrar"};
                int n1 = JOptionPane.showInternalOptionDialog(this, "A que estado desea cambiar la formula seleccionada?", "FORMULA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
                if (n1 == 0) {
                    String xsql = "update h_ordenes set  EstaEntregada=0 where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString() + "'";
                    this.xconsultabd.ejecutarSQL(xsql);
                    this.xconsultabd.cerrarConexionBd();
                } else if (n1 == 1) {
                    String xsql2 = "update h_ordenes set  EstaEntregada=1 where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString() + "'";
                    this.xconsultabd.ejecutarSQL(xsql2);
                    this.xconsultabd.cerrarConexionBd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoFormulaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoFormula.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBMunicipio.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ClasificadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_InterconsultaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDatosTabla();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.xidtipoformula = this.xconsultabd.llenarCombo("SELECT Id, Nbre FROM h_tipoformula WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoformula, this.JCBTipoFormula);
        this.xmunicipio = this.xconsultabd.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedItem("MONTELIBANO");
        this.xconsultabd.cerrarConexionBd();
        this.xlleno = true;
        mCrearTabla();
    }

    public void mBuscar() {
        if (this.JCBMunicipio.getSelectedIndex() != -1) {
            if (this.JCBTipoFormula.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                mCargarDatosTabla2();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de formula", "VERIFICAR", 0);
                this.JCBTipoFormula.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 0);
        this.JCBMunicipio.requestFocus();
    }

    public void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "N° HC", "Nombre Usuario", "Teléfono", "Especialidad", "Profesional", "Correo", "tipo"}) { // from class: Inventarios.JIFConsultarFormulas.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    public void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Medicamento", "Posología", "Duración", "Cantidad"}) { // from class: Inventarios.JIFConsultarFormulas.9
            Class[] types = {String.class, String.class, Long.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle1.setModel(this.xmodelo1);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    public void mCrearTabla2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Medicamento", "Presentación", "Laboratorío", "C/UE", "C/Tabletas", "C/Cajas"}) { // from class: Inventarios.JIFConsultarFormulas.10
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle2.setModel(this.xmodelo2);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            if (JCHFiltro.isSelected()) {
                sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS Fecha, persona.NoHistoria, persona.NUsuario, persona.Telefono, profesional1.Especialidad, profesional1.NProfesional, persona.Corre, h_ordenes.EstaEntregada FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN h_tipoformula  ON (h_ordenes.IdTipoFormula = h_tipoformula.Id) WHERE (h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0 AND h_ordenes.IdTipoFormula ='" + this.xidtipoformula[this.JCBTipoFormula.getSelectedIndex()] + "' AND h_ordenes.IdMunicipio ='" + this.xmunicipio[this.JCBMunicipio.getSelectedIndex()] + "'  AND (persona.NoHistoria like '" + this.JTFNombreBusqueda.getText() + "%' OR persona.NUsuario like '%" + this.JTFNombreBusqueda.getText() + "%')) GROUP BY h_ordenes.Id ORDER BY h_ordenes.FechaOrden ASC, persona.NUsuario ASC ";
            } else {
                sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS Fecha, persona.NoHistoria, persona.NUsuario, persona.Telefono, profesional1.Especialidad, profesional1.NProfesional, persona.Corre, h_ordenes.EstaEntregada FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN h_tipoformula  ON (h_ordenes.IdTipoFormula = h_tipoformula.Id) WHERE (h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0  AND h_ordenes.IdMunicipio ='" + this.xmunicipio[this.JCBMunicipio.getSelectedIndex()] + "' AND (persona.NoHistoria like '" + this.JTFNombreBusqueda.getText() + "%' OR persona.NUsuario like '%" + this.JTFNombreBusqueda.getText() + "%')) GROUP BY h_ordenes.Id ORDER BY h_ordenes.FechaOrden ASC, persona.NUsuario ASC ";
            }
            ResultSet rs = this.xconsultabd.traerRs(sql);
            mCrearTabla();
            if (rs.next()) {
                rs.last();
                this.JLNFormulas.setText("" + rs.getRow());
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(9)), i, 8);
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender1());
                    i++;
                }
            }
            rs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarFormulas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultarFormulas$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8).toString().equals("0")) {
                cell.setBackground(Color.WHITE);
            } else if (table.getValueAt(row, 8).toString().equals("1")) {
                cell.setBackground(new Color(255, 153, 153));
            } else if (table.getValueAt(row, 8).toString().equals("2")) {
                cell.setBackground(new Color(177, 251, 177));
            }
            return cell;
        }
    }

    private void mCargarDatosTabla2() {
        try {
            String sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministro.CantidadUnidad, SUM(h_itemordenessum.Cantidad) AS Cant, ROUND(SUM(h_itemordenessum.Cantidad)/i_suministro.CantidadUnidad) AS CUE FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN h_tipoformula  ON (h_ordenes.IdTipoFormula = h_tipoformula.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN baseserver.i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0 AND h_ordenes.IdTipoFormula ='" + this.xidtipoformula[this.JCBTipoFormula.getSelectedIndex()] + "' AND h_ordenes.IdMunicipio ='" + this.xmunicipio[this.JCBMunicipio.getSelectedIndex()] + "' AND h_ordenes.EstaEntregada <>2) GROUP BY i_suministro.Id ORDER BY i_suministro.Nbre ASC ";
            ResultSet rs = this.xconsultabd.traerRs(sql);
            mCrearTabla2();
            if (rs.next()) {
                rs.last();
                this.JLNItems.setText("" + rs.getRow());
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(5)), i, 4);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(6)), i, 5);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    i++;
                }
            }
            rs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarFormulas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        try {
            String sql = "SELECT h_ordenes.Id, i_suministro.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad FROM h_itemordenessum INNER JOIN h_ordenes  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) WHERE (h_ordenes.Id ='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "' AND h_itemordenessum.Estado =1) ";
            ResultSet rs = this.xconsultabd.traerRs(sql);
            mCrearTabla1();
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarFormulas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir(long idorden, int n) {
        try {
            String xnotasad = null;
            String tipo = "Farmacia";
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM baseserver.h_ordenes where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "'";
            new Metodos();
            ResultSet rsm = this.xconsultabd.traerRs(sql);
            rsm.first();
            this.xconsultabd.cerrarConexionBd();
            if (rsm.next()) {
                new Metodos();
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  baseserver.h_ordenes where  Id_Atencion='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6) + "' and Id>'" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "' order by Id";
                ResultSet xrsm = this.xconsultabd.traerRs(sql2);
                xrsm.next();
                if (xrsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + xrsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + this.xmt.formatoDMA.format((Date) xrsm.getDate(3));
                }
                xrsm.close();
                this.xconsultabd.cerrarConexionBd();
            }
            String[][] mparametros = new String[6][2];
            String usuario = Principal.usuarioSistemaDTO.getLogin();
            System.err.println("akita2");
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = String.valueOf(idorden);
                mparametros[1][0] = "xp2";
                mparametros[1][1] = tipo;
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = usuario;
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP", mparametros);
                tipo = "Usuario";
                System.err.println("akita1");
            }
            rsm.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
