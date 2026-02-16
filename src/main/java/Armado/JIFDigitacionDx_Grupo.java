package Armado;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFDigitacionDx_Grupo.class */
public class JIFDigitacionDx_Grupo extends JInternalFrame {
    private String[] xId_Procedimiento;
    private Object[] xdato;
    private JComboBox comboBox;
    private JComboBox JCB_Procedimiento;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JMenuItem JMIConsultarDx;
    private JMenuItem JMISalir;
    private JPopupMenu JMPAyuda;
    private JPanel JPIDatosFiltrado;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    private int xllenoc = 0;
    private int xllenat = 0;
    public int xposfila = -1;
    public int xposcolumna = -1;

    public JIFDigitacionDx_Grupo() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JMPAyuda = new JPopupMenu();
        this.JMIConsultarDx = new JMenuItem();
        this.JMISalir = new JMenuItem();
        this.JPIDatosFiltrado = new JPanel();
        this.JCB_Procedimiento = new JComboBox();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JMIConsultarDx.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarDx.setText("Consultar Dx");
        this.JMIConsultarDx.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx_Grupo.1
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx_Grupo.this.JMIConsultarDxActionPerformed(evt);
            }
        });
        this.JMPAyuda.add(this.JMIConsultarDx);
        this.JMISalir.setFont(new Font("Arial", 1, 12));
        this.JMISalir.setText("Salir");
        this.JMISalir.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx_Grupo.2
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx_Grupo.this.JMISalirActionPerformed(evt);
            }
        });
        this.JMPAyuda.add(this.JMISalir);
        setClosable(true);
        setIconifiable(true);
        setTitle("DIGITACIÓN DE DX PARA RIPS DE CONSULTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdigitaciondx");
        this.JPIDatosFiltrado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCB_Procedimiento.setFont(new Font("Arial", 1, 12));
        this.JCB_Procedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Procedimiento.addItemListener(new ItemListener() { // from class: Armado.JIFDigitacionDx_Grupo.3
            public void itemStateChanged(ItemEvent evt) {
                JIFDigitacionDx_Grupo.this.JCB_ProcedimientoItemStateChanged(evt);
            }
        });
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosFiltradoLayout = new GroupLayout(this.JPIDatosFiltrado);
        this.JPIDatosFiltrado.setLayout(JPIDatosFiltradoLayout);
        JPIDatosFiltradoLayout.setHorizontalGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCB_Procedimiento, 0, -1, 32767).addContainerGap()));
        JPIDatosFiltradoLayout.setVerticalGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2)).addComponent(this.JCB_Procedimiento, -2, 50, -2)).addContainerGap(24, 32767)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFDigitacionDx_Grupo.4
            public void mouseClicked(MouseEvent evt) {
                JIFDigitacionDx_Grupo.this.JTBResultadoMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JIFDigitacionDx_Grupo.this.JTBResultadoMousePressed(evt);
            }
        });
        this.JTBResultado.addFocusListener(new FocusAdapter() { // from class: Armado.JIFDigitacionDx_Grupo.5
            public void focusGained(FocusEvent evt) {
                JIFDigitacionDx_Grupo.this.JTBResultadoFocusGained(evt);
            }
        });
        this.JTBResultado.addKeyListener(new KeyAdapter() { // from class: Armado.JIFDigitacionDx_Grupo.6
            public void keyPressed(KeyEvent evt) {
                JIFDigitacionDx_Grupo.this.JTBResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING, -1, 1147, 32767).addComponent(this.JPIDatosFiltrado, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosFiltrado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 539, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ProcedimientoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoFocusGained(FocusEvent evt) {
        if (this.xllenat == 1 && this.JTBResultado.getSelectedRow() != -1) {
            if (this.JTBResultado.getSelectedColumn() == 4) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 4).toString(), this.JTBResultado.getSelectedRow(), 4);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 5) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString(), this.JTBResultado.getSelectedRow(), 5);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 6) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString(), this.JTBResultado.getSelectedRow(), 6);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 7 && !this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7).equals("")) {
                mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 7).toString(), this.JTBResultado.getSelectedRow(), 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (evt.getButton() == 3) {
            int pos1 = this.JTBResultado.rowAtPoint(evt.getPoint());
            if (pos1 == 4) {
                mBuscarPatologia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3 && this.xposcolumna != -1 && this.xposfila != -1 && this.xposcolumna >= 4 && this.xposcolumna <= 7) {
            this.JMPAyuda.setVisible(true);
            this.JMPAyuda.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISalirActionPerformed(ActionEvent evt) {
        this.JMPAyuda.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarDxActionPerformed(ActionEvent evt) {
        if (this.xposfila != -1 && this.xposcolumna != -1) {
            this.JMPAyuda.setVisible(false);
            JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) "", "digitaciondx");
            pac.setVisible(true);
            pac.setLocationRelativeTo(this);
        }
    }

    private void mBuscarPatologia() {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) "", "digitaciondx");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscarP(String codigo, int posf, int posc) {
        try {
            String sql = "SELECT Id, Nbre FROM baseserver.g_patologia where Id='" + codigo + "' and Estado=1";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.xmodelo.setValueAt(rs.getString(1), posf, posc);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Codigo Incorrecto", "VERIFICAR", 0);
                this.xmodelo.setValueAt("", posf, posc);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDigitacionDx_Grupo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel();
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("Tipo Procedimiento");
        this.xmodelo.addColumn("Tipo Dx");
        this.xmodelo.addColumn("Codigo DxP");
        this.xmodelo.addColumn("Codigo DxR1");
        this.xmodelo.addColumn("Codigo DxR2");
        this.xmodelo.addColumn("Codigo DxR3");
        this.xmodelo.addColumn("");
        this.xmodelo.addColumn("");
        this.xmodelo.addColumn("Profesional");
        this.xmodelo.addColumn("N° Historia");
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(20);
        TableColumn sportColumn = this.JTBResultado.getColumnModel().getColumn(3);
        this.comboBox = new JComboBox();
        this.comboBox.addItem("Impresión Dx");
        this.comboBox.addItem("Confirmado Nuevo");
        this.comboBox.addItem("Confirmado Repetido");
        sportColumn.setCellEditor(new DefaultCellEditor(this.comboBox));
    }

    public void mBuscar() {
    }

    private void mCargarDatos(String SQL) {
        ResultSet rs = this.xct.traerRs(SQL);
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int m = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), m, 8);
                    this.xmodelo.setValueAt(rs.getString(2), m, 0);
                    this.xmodelo.setValueAt(rs.getString(3), m, 1);
                    this.xmodelo.setValueAt(rs.getString(4), m, 2);
                    this.xmodelo.setValueAt("", m, 4);
                    this.xmodelo.setValueAt("", m, 5);
                    this.xmodelo.setValueAt("", m, 6);
                    this.xmodelo.setValueAt("", m, 7);
                    this.xmodelo.setValueAt(rs.getString(9), m, 9);
                    this.xmodelo.setValueAt(rs.getString(7), m, 10);
                    this.xmodelo.setValueAt(rs.getString(10), m, 11);
                    m++;
                }
                this.xllenat = 1;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDigitacionDx_Grupo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.xllenoc = 1;
    }

    private void mLLenar_Cbo_Procedimiento() {
        this.JCB_Procedimiento.removeAllItems();
        this.xId_Procedimiento = this.xct.llenarCombo("SELECT Id, Nbre FROM baseserver.g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xId_Procedimiento, this.JCB_Procedimiento);
        this.xct.cerrarConexionBd();
        this.JCB_Procedimiento.setSelectedIndex(-1);
        mCrearTablaDetalleProc();
        this.xllenoc = 0;
        this.JCB_Procedimiento.setSelectedIndex(-1);
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (mVerificarDatosT()) {
                for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
                    if (!this.xmodelo.getValueAt(x, 4).equals("")) {
                        String sql = "Insert into baseserver.f_itemripsconsulta(Id_Ordenes, Id_Procedimiento, Id_TipoDx, Id_DxPrincipal, DxRelacional1, DxRelacional2, DxRelacional3, Fecha, UsuarioS) values('" + this.xmodelo.getValueAt(x, 8) + "','" + this.xmodelo.getValueAt(x, 9) + "','" + mDdevuelveValorCombo(this.xmodelo.getValueAt(x, 3).toString()) + "','" + this.xmodelo.getValueAt(x, 4).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 5).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 6).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 7).toString().toUpperCase() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                    }
                }
                mCrearTablaDetalleProc();
                mBuscar();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe registro diligenciado en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private boolean mVerificarDatosT() {
        boolean ver = false;
        int i = 0;
        while (true) {
            if (i >= this.JTBResultado.getRowCount()) {
                break;
            }
            if (this.xmodelo.getValueAt(i, 4).equals("")) {
                i++;
            } else {
                ver = true;
                break;
            }
        }
        return ver;
    }

    private int mDdevuelveValorCombo(String dato) {
        int xv = 1;
        if (dato.equals("Impresión Dx")) {
            xv = 1;
        } else if (dato.equals("Confirmado Nuevo")) {
            xv = 2;
        } else if (dato.equals("Confirmado Repetido")) {
            xv = 3;
        }
        return xv;
    }
}
