package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JtreeTable.MyAbstractTreeTableModel;
import Utilidades.JtreeTable.MyDataModel;
import Utilidades.JtreeTable.MyDataNode;
import Utilidades.JtreeTable.MyTreeTable;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRubros.class */
public class JIFRubros extends JInternalFrame {
    private MyTreeTable myTreeTable;
    private MyAbstractTreeTableModel treeTableModel;
    private JButton JBTExportar;
    private JCheckBox JCHTercero;
    private JCheckBox JCHUltNivel;
    private JRadioButton JRIGastos;
    private JRadioButton JRIngresos;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private ButtonGroup Tipo;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private Metodos xmt = new Metodos();
    private String xTipoR = "I";
    private int xUltimoN = 0;
    private int xAplicaTercero = 0;
    List<MyDataNode> children1 = new ArrayList();
    List<MyDataNode> children2 = new ArrayList();
    List<MyDataNode> children3 = new ArrayList();
    List<MyDataNode> children4 = new ArrayList();
    List<MyDataNode> children5 = new ArrayList();
    List<MyDataNode> children6 = new ArrayList();
    List<MyDataNode> children7 = new ArrayList();
    List<MyDataNode> children8 = new ArrayList();
    List<MyDataNode> children9 = new ArrayList();
    List<MyDataNode> children10 = new ArrayList();
    List<MyDataNode> children12 = new ArrayList();
    List<MyDataNode> children13 = new ArrayList();
    MyDataNode root = null;
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFRubros() {
        initComponents();
        mIniciaJtreeTable();
    }

    private void initComponents() {
        this.Tipo = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.jPanel2 = new JPanel();
        this.JRIGastos = new JRadioButton();
        this.JRIngresos = new JRadioButton();
        this.JTFNombre = new JTextField();
        this.JCHUltNivel = new JCheckBox();
        this.JCHTercero = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("RUBROS PRESUPUESTALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifRubrosPTO");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS PRESUPUESTALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Tipo.add(this.JRIGastos);
        this.JRIGastos.setFont(new Font("Arial", 1, 12));
        this.JRIGastos.setText("Gastos");
        this.JRIGastos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRubros.1
            public void actionPerformed(ActionEvent evt) {
                JIFRubros.this.JRIGastosActionPerformed(evt);
            }
        });
        this.Tipo.add(this.JRIngresos);
        this.JRIngresos.setFont(new Font("Arial", 1, 12));
        this.JRIngresos.setSelected(true);
        this.JRIngresos.setText("Ingresos");
        this.JRIngresos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRubros.2
            public void actionPerformed(ActionEvent evt) {
                JIFRubros.this.JRIngresosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRIngresos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRIGastos).addGap(2, 2, 2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRIGastos).addComponent(this.JRIngresos)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHUltNivel.setFont(new Font("Arial", 1, 12));
        this.JCHUltNivel.setText("Último Nivel?");
        this.JCHUltNivel.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRubros.3
            public void actionPerformed(ActionEvent evt) {
                JIFRubros.this.JCHUltNivelActionPerformed(evt);
            }
        });
        this.JCHTercero.setFont(new Font("Arial", 1, 12));
        this.JCHTercero.setText("Aplica Tercero?");
        this.JCHTercero.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRubros.4
            public void actionPerformed(ActionEvent evt) {
                JIFRubros.this.JCHTerceroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFCodigo, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHUltNivel).addGap(18, 18, 18).addComponent(this.JCHTercero).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCodigo, -1, 47, 32767).addComponent(this.JTFNombre))).addComponent(this.jPanel2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHUltNivel).addComponent(this.JCHTercero))));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRubros.5
            public void mouseClicked(MouseEvent evt) {
                JIFRubros.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRubros.6
            public void actionPerformed(ActionEvent evt) {
                JIFRubros.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 643, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 221, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(5, 5, 5).addComponent(this.jScrollPane1, -1, 410, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, 56, 32767).addComponent(this.JTFRuta)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTerceroActionPerformed(ActionEvent evt) {
        if (this.JCHTercero.isSelected()) {
            this.xAplicaTercero = 1;
        } else {
            this.xAplicaTercero = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRIngresosActionPerformed(ActionEvent evt) {
        this.xTipoR = "I";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRIGastosActionPerformed(ActionEvent evt) {
        this.xTipoR = "G";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUltNivelActionPerformed(ActionEvent evt) {
        if (this.JCHUltNivel.isSelected()) {
            this.xUltimoN = 1;
        } else {
            this.xUltimoN = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.myTreeTable.getRowCount() > -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.myTreeTable, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
            }
        }
    }

    public void mGrabar() {
        Object nodo = this.myTreeTable.tree.getLastSelectedPathComponent();
        if (nodo == null) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        MyDataNode clsPlantilla = (MyDataNode) nodo;
        if (clsPlantilla.getxUNivel().equals("NO")) {
            if (!this.JTFCodigo.getText().isEmpty()) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = "INSERT INTO  `pp_rubros` (Id,`Nbre`,`IdPadre`,`TipoRubro`,`UltNivel`,`Aplica_Tercero`,`UsuarioS`)\nVALUES ( '" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + clsPlantilla.getIdRubro() + "','" + this.xTipoR + "','" + this.xUltimoN + "','" + this.xAplicaTercero + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        int xPosScroll = this.jScrollPane1.getVerticalScrollBar().getValue();
                        this.children1.removeAll(this.children1);
                        this.myTreeTable.setModel(new DefaultTableModel());
                        mIniciaJtreeTable();
                        this.jScrollPane1.getVerticalScrollBar().setValue(xPosScroll + 20);
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar el nombre del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el código del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No puede crear un rubro debajo de un rubro último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JRIngresos.setSelected(true);
        this.xTipoR = "I";
        this.JCHUltNivel.setSelected(false);
        this.JCHTercero.setSelected(false);
        this.xUltimoN = 0;
        this.xAplicaTercero = 0;
    }

    private void mIniciaJtreeTable() {
        createDataStructure("-1");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.treeTableModel = new MyDataModel(createDataStructure());
        this.myTreeTable = new MyTreeTable(this.treeTableModel);
        this.jScrollPane1.getViewport().add(this.myTreeTable);
    }

    private List<MyDataNode> createDataStructure(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQL-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    System.out.println("IdPadre-->" + xrs.getString("IdPadre"));
                    this.children1.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild2(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    System.out.println("children1-->" + this.children1);
                    System.out.println("n-->" + n);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children1;
    }

    private List<MyDataNode> createDataStructureChild2(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQL-->" + sql);
        try {
            if (xrs.next()) {
                this.children2 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    System.out.println("IdPadre-->" + xrs.getString("IdPadre"));
                    this.children2.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild3(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    System.out.println("children2-->" + this.children2);
                    n++;
                }
            } else {
                this.children2 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children2;
    }

    private List<MyDataNode> createDataStructureChild3(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children3 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children3.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild4(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children3 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children3;
    }

    private List<MyDataNode> createDataStructureChild4(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children4 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children4.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild5(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children4 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children4;
    }

    private List<MyDataNode> createDataStructureChild5(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children5 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children5.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild6(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children5 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children5;
    }

    private List<MyDataNode> createDataStructureChild6(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children6 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children6.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild7(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children6 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children6;
    }

    private List<MyDataNode> createDataStructureChild7(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children7 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children7.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild8(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children7 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children7;
    }

    private List<MyDataNode> createDataStructureChild8(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children8 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children8.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild9(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children8 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children8;
    }

    private List<MyDataNode> createDataStructureChild9(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children9 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children9.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild10(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children9 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children9;
    }

    private List<MyDataNode> createDataStructureChild10(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children10 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children10.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), null, xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children10 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children10;
    }

    private MyDataNode createDataStructure() {
        this.root = new MyDataNode("Rubros Presupuestales", "", "", "", this.children1, "0", "0", "");
        return this.root;
    }
}
