package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionLabExterno.class */
public class JIFImportacionLabExterno extends JInternalFrame {
    private Object[] dato;
    private String sql;
    public DefaultTableModel xmodelo;
    private claseLab xclaselab;
    private File xfile;
    private String[] xlistaBact;
    private int xtipo;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JButton JBTEscuchar;
    private JButton JBTGrabar;
    private JButton JBTValdiar;
    private JCheckBox JCHProtocolo;
    private JScrollPane JSPDatos;
    private JTable JTBDatosImp;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public boolean xestado = false;

    public JIFImportacionLabExterno(String xtitulo, int xtipo) {
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        setTitle(xtitulo);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JSPDatos = new JScrollPane();
        this.JTBDatosImp = new JTable();
        this.JBTEscuchar = new JButton();
        this.JBTGrabar = new JButton();
        this.JBTValdiar = new JButton();
        this.JCHProtocolo = new JCheckBox();
        setClosable(true);
        setTitle("IMPORTACIÓN RESULTADOS LABORATORIO EXTERNO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifimportacionlabexterno");
        this.JSPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A IMPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosImp.setFont(new Font("Arial", 1, 12));
        this.JTBDatosImp.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosImp.setAutoResizeMode(4);
        this.JTBDatosImp.setRowHeight(25);
        this.JTBDatosImp.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosImp.setSelectionForeground(Color.red);
        this.JTBDatosImp.setSelectionMode(0);
        this.JTBDatosImp.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFImportacionLabExterno.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFImportacionLabExterno.this.JTBDatosImpPropertyChange(evt);
            }
        });
        this.JTBDatosImp.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFImportacionLabExterno.2
            public void keyPressed(KeyEvent evt) {
                JIFImportacionLabExterno.this.JTBDatosImpKeyPressed(evt);
            }
        });
        this.JSPDatos.setViewportView(this.JTBDatosImp);
        this.JBTEscuchar.setFont(new Font("Arial", 1, 12));
        this.JBTEscuchar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.JBTEscuchar.setText("Cargar Archivo");
        this.JBTEscuchar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionLabExterno.3
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionLabExterno.this.JBTEscucharActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionLabExterno.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionLabExterno.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTValdiar.setFont(new Font("Arial", 1, 12));
        this.JBTValdiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTValdiar.setText("Validar");
        this.JBTValdiar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionLabExterno.5
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionLabExterno.this.JBTValdiarActionPerformed(evt);
            }
        });
        this.JCHProtocolo.setFont(new Font("Arial", 1, 12));
        this.JCHProtocolo.setText("Es Protocolo?");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDatos, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTEscuchar, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JBTValdiar, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JBTGrabar, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JCHProtocolo).addGap(16, 16, 16))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatos, -2, 370, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEscuchar, -2, 55, -2).addComponent(this.JBTGrabar, -2, 55, -2).addComponent(this.JBTValdiar, -2, 55, -2).addComponent(this.JCHProtocolo)).addGap(10, 10, 10)));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEscucharActionPerformed(ActionEvent evt) {
        mCargarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.xtipo == 0) {
            mGrabar();
        } else if (this.xtipo == 1) {
            mGrabar1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValdiarActionPerformed(ActionEvent evt) {
        if (this.JTBDatosImp.getRowCount() >= 0) {
            if (this.xtipo == 0) {
                for (int x = 0; x < this.JTBDatosImp.getRowCount(); x++) {
                    mVerificarProtocoloxProcedimiento(this.xmodelo.getValueAt(x, 8).toString(), this.xmodelo.getValueAt(x, 3).toString());
                    this.sql = "SELECT l_detallerecepcion.Resultado, l_detallerecepcion.NArchivo, l_detallerecepcion.Id_Procedim FROM l_detallerecepcion INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (l_detallerecepcion.Id_Recepcion ='" + this.xmodelo.getValueAt(x, 8) + "' AND l_protocoloxprocedimiento.Id ='" + this.xmodelo.getValueAt(x, 10) + "') ";
                    ResultSet xrs = this.xct.traerRs(this.sql);
                    try {
                        if (xrs.next()) {
                            xrs.first();
                            this.xmodelo.setValueAt(true, x, 9);
                            this.xmodelo.setValueAt(xrs.getString(3), x, 13);
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                return;
            }
            if (this.xtipo == 1) {
                for (int x2 = 0; x2 < this.JTBDatosImp.getRowCount(); x2++) {
                    if (!this.JCHProtocolo.isSelected()) {
                        this.sql = "SELECT `l_protocoloxprocedimiento`.`Id`, IF(`persona`.`IdSexo`='M',`l_protocolos`.`VrMinM`, `l_protocolos`.`VrMinF`) AS `VRMinimo`, IF(`persona`.`IdSexo`='M',`l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMaxF`) AS `VRMaximo`,  `l_detallerecepcion`.`Resultado`, `l_detallerecepcion`.Id_Procedim,`persona`.`NUsuario`, `persona`.`NoHistoria`, `g_procedimiento`.`Nbre`,`l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.CExamen FROM `l_detallerecepcion`  INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)  INNER JOIN `persona`  ON (`l_recepcion`.`Id_Paciente` = `persona`.`Id_persona`)  INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN  `l_protocolos`   ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)  INNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)  WHERE (`l_recepcion`.`Id` ='" + this.xmodelo.getValueAt(x2, 0) + "'   AND `l_protocolos`.`Abreviatura` ='" + this.xmodelo.getValueAt(x2, 1) + "' AND `l_recepcion`.`Estado`=0) ";
                    } else {
                        this.sql = "SELECT `l_protocoloxprocedimiento`.`Id`, IF(`persona`.`IdSexo`='M',`l_protocolos`.`VrMinM`, `l_protocolos`.`VrMinF`) AS `VRMinimo`, IF(`persona`.`IdSexo`='M',`l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMaxF`) AS `VRMaximo`,  `l_detallerecepcion`.`Resultado`, `l_detallerecepcion`.Id_Procedim,`persona`.`NUsuario`, `persona`.`NoHistoria`, `g_procedimiento`.`Nbre`,`l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.CExamen FROM `l_detallerecepcion`  INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)  INNER JOIN `persona`  ON (`l_recepcion`.`Id_Paciente` = `persona`.`Id_persona`)  INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN  `l_protocolos`   ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)  INNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)  WHERE (`l_recepcion`.`Id` ='" + this.xmodelo.getValueAt(x2, 0) + "'  AND l_tipomuestra.`Abreviatura`='" + this.xmodelo.getValueAt(x2, 16) + "' AND `l_protocolos`.`Abreviatura` ='" + this.xmodelo.getValueAt(x2, 1) + "' AND `l_recepcion`.`Estado`=0) ";
                    }
                    ResultSet xrs2 = this.xct.traerRs(this.sql);
                    try {
                        if (xrs2.next()) {
                            xrs2.first();
                            this.xmodelo.setValueAt(xrs2.getString(1), x2, 4);
                            this.xmodelo.setValueAt(xrs2.getString(2), x2, 5);
                            this.xmodelo.setValueAt(xrs2.getString(3), x2, 6);
                            this.xmodelo.setValueAt(xrs2.getString(5), x2, 10);
                            this.xmodelo.setValueAt(xrs2.getString(6), x2, 11);
                            this.xmodelo.setValueAt(xrs2.getString(7), x2, 12);
                            this.xmodelo.setValueAt(xrs2.getString(8), x2, 13);
                            this.xmodelo.setValueAt(xrs2.getString(9), x2, 14);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs2.getInt(10)), x2, 15);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs2.getBoolean(4)), x2, 7);
                            this.xmodelo.setValueAt(false, x2, 8);
                            this.xmodelo.setValueAt(false, x2, 9);
                            this.JTBDatosImp.setDefaultRenderer(Object.class, new MiRender());
                            if (!this.xmodelo.getValueAt(x2, 5).toString().equals("") && !this.xmodelo.getValueAt(x2, 6).toString().equals("")) {
                                mValidarAlterado(x2);
                            }
                        } else {
                            this.xmodelo.setValueAt(false, x2, 8);
                            this.xmodelo.setValueAt(false, x2, 9);
                            this.xmodelo.setValueAt(false, x2, 7);
                            this.xmodelo.setValueAt("", x2, 10);
                            this.JTBDatosImp.setDefaultRenderer(Object.class, new MiRender());
                        }
                        xrs2.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosImpKeyPressed(KeyEvent evt) {
        if (this.JTBDatosImp.getSelectedRow() != -1 && this.xtipo == 0 && this.JTBDatosImp.getSelectedColumn() == 8) {
            this.xmodelo.setValueAt(mConsultarIdProtocoloxProcedimiento(this.xmodelo.getValueAt(this.JTBDatosImp.getSelectedRow(), 3).toString(), this.xmodelo.getValueAt(this.JTBDatosImp.getSelectedRow(), 8).toString()), this.JTBDatosImp.getSelectedRow(), 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosImpPropertyChange(PropertyChangeEvent evt) {
        if (this.JTBDatosImp.getSelectedRow() != -1 && this.xtipo == 0 && this.JTBDatosImp.getSelectedColumn() == 8) {
            this.xmodelo.setValueAt(mConsultarIdProtocoloxProcedimiento(this.xmodelo.getValueAt(this.JTBDatosImp.getSelectedRow(), 3).toString(), this.xmodelo.getValueAt(this.JTBDatosImp.getSelectedRow(), 8).toString()), this.JTBDatosImp.getSelectedRow(), 10);
        }
    }

    private void mValidarAlterado(int xnfila) {
        double xvminimo = Double.parseDouble(this.xmodelo.getValueAt(xnfila, 5).toString());
        double xvmaximo = Double.parseDouble(this.xmodelo.getValueAt(xnfila, 6).toString());
        double xvalorr = Double.parseDouble(this.xmodelo.getValueAt(xnfila, 2).toString());
        if (xvalorr < xvminimo || xvalorr > xvmaximo) {
            this.xmodelo.setValueAt(true, xnfila, 8);
        } else {
            this.xmodelo.setValueAt(false, xnfila, 8);
        }
    }

    public void mNuevo() {
        if (this.xtipo == 0) {
            mCrearTabla();
        } else if (this.xtipo == 1) {
            mCrearTabla1();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "NHc", "Usuario", "Procolo", "Procedimiento", "Resultado", "VRef1", "VRef2", "NOrden", "Cargar?", "IdP", "VNRecepcion", "Alterado", "IdProcedimiento", "FechaC", "Id_Usuario", "NExamen"}) { // from class: Laboratorio.JIFImportacionLabExterno.6
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, false, false, false, false, true, true, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDatosImp;
        JTable jTable2 = this.JTBDatosImp;
        jTable.setAutoResizeMode(0);
        this.JTBDatosImp.doLayout();
        this.JTBDatosImp.setModel(this.xmodelo);
        this.JTBDatosImp.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTBDatosImp.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDatosImp.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBDatosImp.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTBDatosImp.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(16).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Recepción", "Abreviatura", "Valor", "fecha", "Protocolo", "VRef1", "VRef2", "Resultado", "Alterado", "Cargar?", "IdProcedimiento", "NUsuario", "NHC", "NProcedimiento", "Id_Usuario", "NExamen", "Tipo"}) { // from class: Laboratorio.JIFImportacionLabExterno.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosImp.setModel(this.xmodelo);
        this.JTBDatosImp.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDatosImp.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBDatosImp.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDatosImp.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDatosImp.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTBDatosImp.getColumnModel().getColumn(16).setPreferredWidth(10);
    }

    private void mCargarArchivos() {
        JFileChooser xfilec;
        if (this.xtipo == 0) {
            xfilec = new JFileChooser("c:\\");
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            xfilec = new JFileChooser("C:\\Program Files (x86)\\A25\\Export");
        } else {
            xfilec = new JFileChooser("C:\\Users\\usuario\\AppData\\Local\\VirtualStore\\Program Files (x86)\\A15\\Export");
        }
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            try {
                if (this.xtipo == 0) {
                    mCrearTabla();
                } else if (this.xtipo == 1) {
                    mCrearTabla1();
                }
                this.xfile = xfilec.getSelectedFile();
                String xnombre = xfilec.getSelectedFile().getName();
                System.out.println(xnombre);
                BufferedReader bf = new BufferedReader(new FileReader(this.xfile.getAbsolutePath()));
                String linea = bf.readLine();
                Vector xvector = new Vector();
                int nlineas = 0;
                while (linea != null) {
                    System.out.println("Linea : " + linea);
                    xvector.add(linea + "\n");
                    linea = bf.readLine();
                    nlineas++;
                }
                int xfila = 0;
                if (this.xtipo == 0) {
                    mCrearTabla();
                    for (int x = 1; x < xvector.size(); x++) {
                        this.xmodelo.addRow(this.dato);
                        mSepararCadena(xvector.get(x).toString(), xfila);
                        xfila++;
                        this.xestado = false;
                    }
                } else {
                    mCrearTabla1();
                    for (int x2 = 0; x2 < xvector.size(); x2++) {
                        this.xmodelo.addRow(this.dato);
                        mSepararCadena1(xvector.get(x2).toString(), xfila);
                        xfila++;
                        this.xestado = false;
                    }
                }
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private String mQuitarEspaciosBlanco(String xtexto) {
        String xnuevacadena = "";
        StringTokenizer stTexto = new StringTokenizer(xtexto);
        while (stTexto.hasMoreElements()) {
            xnuevacadena = xnuevacadena + stTexto.nextElement();
        }
        return xnuevacadena;
    }

    private void mSepararCadena(String xtexto, int xnf) {
        StringTokenizer tokens = new StringTokenizer(xtexto, "|");
        int xcolumna = tokens.countTokens();
        String[][] xdatos = new String[xcolumna][1];
        int i = 0;
        while (tokens.hasMoreElements()) {
            String str = tokens.nextToken();
            xdatos[i][0] = str;
            i++;
            System.out.println(str);
        }
        this.xmodelo.setValueAt(xdatos[0][0], xnf, 0);
        this.xmodelo.setValueAt(xdatos[2][0], xnf, 1);
        this.xmodelo.setValueAt(xdatos[3][0], xnf, 2);
        this.xmodelo.setValueAt(mQuitarEspaciosBlanco(xdatos[4][0]), xnf, 3);
        this.xmodelo.setValueAt(xdatos[6][0], xnf, 4);
        this.xmodelo.setValueAt(mQuitarEspaciosBlanco(xdatos[8][0]), xnf, 5);
        this.xmodelo.setValueAt(xdatos[10][0], xnf, 6);
        this.xmodelo.setValueAt(xdatos[11][0], xnf, 7);
        this.xmodelo.setValueAt(mQuitarEspaciosBlanco(xdatos[12][0]), xnf, 8);
        this.xmodelo.setValueAt(false, xnf, 9);
        this.xmodelo.setValueAt(mConsultarIdProtocoloxProcedimiento(mQuitarEspaciosBlanco(xdatos[4][0]), mQuitarEspaciosBlanco(xdatos[12][0])), xnf, 10);
        this.xmodelo.setValueAt(false, xnf, 11);
        this.xmodelo.setValueAt(false, xnf, 12);
        this.xmodelo.setValueAt("0", xnf, 13);
        this.xmodelo.setValueAt(xdatos[9][0], xnf, 14);
    }

    private void mSepararCadena1(String xtexto, int xnf) {
        StringTokenizer tokens = new StringTokenizer(xtexto, "\t");
        int xcolumna = tokens.countTokens();
        String[][] xdatos = new String[xcolumna][1];
        int i = 0;
        while (tokens.hasMoreElements()) {
            String str = tokens.nextToken();
            xdatos[i][0] = str;
            i++;
        }
        this.xmodelo.setValueAt(xdatos[0][0], xnf, 0);
        this.xmodelo.setValueAt(xdatos[1][0], xnf, 1);
        this.xmodelo.setValueAt(xdatos[3][0].toString().replaceAll(",", "."), xnf, 2);
        this.xmodelo.setValueAt(xdatos[5][0].substring(6, 10) + "-" + xdatos[5][0].substring(3, 5) + "-" + xdatos[5][0].substring(0, 2) + " " + xdatos[5][0].substring(11, 19), xnf, 3);
        this.xmodelo.setValueAt(xdatos[2][0].toString().replaceAll(",", "."), xnf, 16);
    }

    private String mConsultarIdProtocoloxProcedimiento(String xid, String xidrecepcion) {
        String xidp = "0";
        this.sql = "SELECT `l_protocoloxprocedimiento`.`Id` FROM `l_detallerecepcion` INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_recepcion`.`Id` ='" + xidrecepcion + "' AND `l_protocolos`.`Id` ='" + xid + "') ";
        ResultSet xrs = this.xct.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xidp = xrs.getString(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xidp;
    }

    private void mVerificarProtocoloxProcedimiento(String xidrecepcion, String xidprotocolo) {
        try {
            this.sql = "SELECT `l_protocoloxprocedimiento`.`Id` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_recepcion`.`Id` ='" + xidrecepcion + "' AND `l_protocolos`.`Id` ='" + xidprotocolo + "' and `l_protocoloxprocedimiento`.`Estado`=0) ORDER BY `g_procedimiento`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                System.out.println(xrs.getString(1));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String xdatoc = "";
            boolean xtipo1 = false;
            for (int x = 0; x < this.JTBDatosImp.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                    try {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        this.sql = "SELECT l_detallerecepcion.Resultado, l_detallerecepcion.NArchivo, l_resultados.Id   FROM l_detallerecepcion INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) INNER JOIN l_resultados  ON (l_resultados.Id_Recepcion = l_detallerecepcion.Id_Recepcion) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) AND (l_detalleresultado.Id_Resultado = l_resultados.Id) WHERE (l_detallerecepcion.Id_Recepcion ='" + this.xmodelo.getValueAt(x, 8) + "' AND l_protocoloxprocedimiento.Id ='" + this.xmodelo.getValueAt(x, 10) + "') ";
                        this.xct.ejecutarSQL(this.sql);
                        this.xct.cerrarConexionBd();
                        ResultSet xrs1 = xct1.traerRs(this.sql);
                        if (!xrs1.next()) {
                            this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional,Id_Especialidad, fecha, UsuarioS)  VALUES('" + this.xmodelo.getValueAt(x, 8).toString() + "','" + this.xmodelo.getValueAt(x, 0).toString().substring(0, 4) + "-" + this.xmodelo.getValueAt(x, 0).toString().substring(4, 6) + "-" + this.xmodelo.getValueAt(x, 0).toString().substring(6, 8) + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.sql);
                            String noResult = this.xct.ejecutarSQLId(this.sql);
                            this.xct.cerrarConexionBd();
                            this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, IdProfesionalV, IdEspecialidadV, Id_Procedimiento, Id_ProtocolProcedim, Resultado, VrNumerico, VReferencia1, VReferencia2)  VALUES('" + noResult + "','" + this.xmodelo.getValueAt(x, 0).toString().substring(0, 4) + "-" + this.xmodelo.getValueAt(x, 0).toString().substring(4, 6) + "-" + this.xmodelo.getValueAt(x, 0).toString().substring(6, 8) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmodelo.getValueAt(x, 13) + "','" + this.xmodelo.getValueAt(x, 10) + "','82','" + this.xmodelo.getValueAt(x, 5) + "','" + this.xmodelo.getValueAt(x, 6) + "','" + this.xmodelo.getValueAt(x, 7) + "')";
                            this.xct.ejecutarSQL(this.sql);
                            this.xct.cerrarConexionBd();
                            int xalterado = 0;
                            System.out.println(this.xmodelo.getValueAt(x, 12).toString());
                            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 12).toString()).booleanValue()) {
                                xdatoc = xdatoc + "\n" + this.xmodelo.getValueAt(x, 2).toString() + "\t N° HC: " + this.xmodelo.getValueAt(x, 1).toString() + "Exámen :\t" + this.xmodelo.getValueAt(x, 4).toString() + "\t\tResultado : " + this.xmodelo.getValueAt(x, 5).toString() + "\t\tVRefMinimo : " + this.xmodelo.getValueAt(x, 6).toString() + "\t\tVRefMax : " + this.xmodelo.getValueAt(x, 7).toString() + "\n";
                                xtipo1 = true;
                                xalterado = 1;
                            }
                            mCambiarEstadoExamen(this.xmodelo.getValueAt(x, 8).toString(), this.xmodelo.getValueAt(x, 13).toString(), 1, 1, xalterado, this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFImportacionLabExterno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            mEnviarCorreoAlterados(xdatoc, xtipo1);
            this.JBTGrabar.setEnabled(false);
        }
    }

    private void mGrabar1() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String xdatoc = "";
            boolean xtipo = false;
            for (int x = 0; x < this.JTBDatosImp.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo.getValueAt(x, 7).toString()).booleanValue()) {
                    this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, Id_Especialidad, fecha, UsuarioS)  VALUES('" + this.xmodelo.getValueAt(x, 0).toString() + "','" + this.xmodelo.getValueAt(x, 3).toString() + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.sql);
                    String noResult = this.xct.ejecutarSQLId(this.sql);
                    this.xct.cerrarConexionBd();
                    this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, IdProfesionalV, IdEspecialidadV, Id_ProtocolProcedim, Id_Procedimiento, Resultado, VrNumerico, VReferencia1, VReferencia2)  VALUES('" + noResult + "','" + this.xmodelo.getValueAt(x, 3).toString() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmodelo.getValueAt(x, 4) + "','" + this.xmodelo.getValueAt(x, 10) + "','82','" + this.xmodelo.getValueAt(x, 2) + "','" + this.xmodelo.getValueAt(x, 5) + "','" + this.xmodelo.getValueAt(x, 6) + "')";
                    this.xct.ejecutarSQL(this.sql);
                    this.xct.cerrarConexionBd();
                    int xalterado = 0;
                    System.out.println(this.xmodelo.getValueAt(x, 8).toString());
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                        xdatoc = xdatoc + "\n" + this.xmodelo.getValueAt(x, 11).toString() + "\t N° HC: " + this.xmodelo.getValueAt(x, 12).toString() + "Exámen :\t" + this.xmodelo.getValueAt(x, 13).toString() + "\t\tResultado : " + this.xmodelo.getValueAt(x, 2).toString() + "\t\tVRefMinimo : " + this.xmodelo.getValueAt(x, 5).toString() + "\t\tVRefMax : " + this.xmodelo.getValueAt(x, 6).toString() + "\n";
                        xtipo = true;
                        xalterado = 1;
                    }
                    mCambiarEstadoExamen(this.xmodelo.getValueAt(x, 0).toString(), this.xmodelo.getValueAt(x, 10).toString(), 1, 1, xalterado, this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                    if (Integer.valueOf(this.xmodelo.getValueAt(x, 15).toString()).intValue() != 0) {
                        System.out.println(this.xmodelo.getValueAt(x, 0).toString());
                        System.out.println(this.xmodelo.getValueAt(x, 14).toString());
                        System.out.println(this.xmodelo.getValueAt(x, 15).toString());
                        System.out.println(this.xmodelo.getValueAt(x, 4).toString());
                        Principal.claselab.mGrabarHistorico(this.xmodelo.getValueAt(x, 0).toString(), this.xmodelo.getValueAt(x, 14).toString(), this.xmodelo.getValueAt(x, 4).toString(), Integer.valueOf(this.xmodelo.getValueAt(x, 15).toString()).intValue());
                    }
                }
            }
            mEnviarCorreoAlterados(xdatoc, xtipo);
            this.JBTGrabar.setEnabled(false);
        }
    }

    private void mEnviarCorreoAlterados(String xdatos, boolean xenvio) {
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && xenvio) {
            String xmensaje = "Relación de usuarios con exámen(es) alterados de acuerdo a los valores de referencia el resultado de LABORATORIO ECHAVARRIA.\n\n" + xdatos + "\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
            this.metodos.mEnvioCorreoElectronico(xmensaje, "medicos@fundacionpanzenu.org.co", "RESULTADO DE EXÁMEN ALTERADO", Principal.usuarioSistemaDTO.getLogin());
        }
    }

    private void mCambiarEstadoExamen(String xidrecepcion, String xidprocedimiento, int xestado, int xvalidado, int xalterado, String xfecha) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        String xsql = "update l_detallerecepcion set Resultado='" + xestado + "', Alterado='" + xalterado + "', ValidadoLab='" + xvalidado + "', FechaResultado='" + xfecha + "' where Id_Recepcion='" + xidrecepcion + "' and Id_Procedim='" + xidprocedimiento + "'";
        xct1.ejecutarSQL(xsql);
        xct1.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionLabExterno$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 7).toString()).booleanValue()) {
                cell.setBackground(new Color(51, 240, 255));
                cell.setForeground(new Color(0, 0, 0));
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(new Color(0, 0, 0));
            }
            return cell;
        }
    }
}
