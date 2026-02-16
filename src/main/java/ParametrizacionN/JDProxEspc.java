package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDProxEspc.class */
public class JDProxEspc extends JDialog {
    private Metodos xmetodos;
    private ConsultasMySQL xconsulta;
    private String xsql;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private String[] xespecilidad;
    private String[] xprocedimiento;
    private int xestado;
    private String xnull;
    private boolean xEstadog;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCB_Especialidad;
    private JCheckBox JCHEstado;
    private JFormattedTextField JFTDuracion;
    private JPanel JPI_Pxesp;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSP_PDetalle;
    private JTable JTB_PDetalle;
    private JTextPane JTPIndicacion;

    public JDProxEspc(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmetodos = new Metodos();
        this.xconsulta = new ConsultasMySQL();
        this.xestado = 0;
        this.xEstadog = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("PROCEDIMIENTO X ESPECIALIDAD");
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Pxesp = new JPanel();
        this.JCB_Especialidad = new JComboBox();
        this.JFTDuracion = new JFormattedTextField();
        this.JSPDescripcion = new JScrollPane();
        this.JTPIndicacion = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JBT_Grabar = new JButton();
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.JPI_Pxesp.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_Especialidad.setFont(new Font("Arial", 1, 12));
        this.JCB_Especialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Especialidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JDProxEspc.1
            public void itemStateChanged(ItemEvent evt) {
                JDProxEspc.this.JCB_EspecialidadItemStateChanged(evt);
            }
        });
        this.JFTDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duracion (Minutos)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTDuracion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JFTDuracion.setHorizontalAlignment(0);
        this.JFTDuracion.setFont(new Font("Arial", 1, 12));
        this.JFTDuracion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProxEspc.2
            public void actionPerformed(ActionEvent evt) {
                JDProxEspc.this.JFTDuracionActionPerformed(evt);
            }
        });
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Indicaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setAutoscrolls(true);
        this.JTPIndicacion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTPIndicacion);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProxEspc.3
            public void actionPerformed(ActionEvent evt) {
                JDProxEspc.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPI_PxespLayout = new GroupLayout(this.JPI_Pxesp);
        this.JPI_Pxesp.setLayout(JPI_PxespLayout);
        JPI_PxespLayout.setHorizontalGroup(JPI_PxespLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PxespLayout.createSequentialGroup().addComponent(this.JCB_Especialidad, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTDuracion, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JSPDescripcion));
        JPI_PxespLayout.setVerticalGroup(JPI_PxespLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PxespLayout.createSequentialGroup().addGroup(JPI_PxespLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Especialidad, -2, 50, -2).addComponent(this.JFTDuracion, -2, 50, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcion, -1, 61, 32767)));
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProxEspc.4
            public void actionPerformed(ActionEvent evt) {
                JDProxEspc.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JSP_PDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_PDetalle.setFont(new Font("Arial", 1, 12));
        this.JTB_PDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_PDetalle.setRowHeight(25);
        this.JTB_PDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_PDetalle.setSelectionForeground(Color.red);
        this.JTB_PDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDProxEspc.5
            public void mouseClicked(MouseEvent evt) {
                JDProxEspc.this.JTB_PDetalleMouseClicked(evt);
            }
        });
        this.JSP_PDetalle.setViewportView(this.JTB_PDetalle);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProxEspc.6
            public void actionPerformed(ActionEvent evt) {
                JDProxEspc.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProxEspc.7
            public void actionPerformed(ActionEvent evt) {
                JDProxEspc.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSP_PDetalle, -1, 803, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 239, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 251, -2)).addComponent(this.JPI_Pxesp, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Pxesp, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_PDetalle, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EspecialidadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_PDetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_PDetalle.getSelectedRow() != -1) {
            this.JCB_Especialidad.setSelectedItem(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 0));
            this.JFTDuracion.setText(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 2).toString());
            this.JTPIndicacion.setText(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.xEstadog = true;
        }
    }

    public void mNuevo() {
        this.JCB_Especialidad.removeAllItems();
        this.xespecilidad = this.xconsulta.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM `profesional1` GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC;", this.xespecilidad, this.JCB_Especialidad);
        this.JCB_Especialidad.setSelectedIndex(-1);
        this.JFTDuracion.setValue(new Long(0L));
        this.JTPIndicacion.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xEstadog = false;
    }

    public void mGrabar() {
        if (this.JCB_Especialidad.getSelectedIndex() != -1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (!this.JFTDuracion.getText().isEmpty() || !this.JFTDuracion.getText().equals("0")) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if (this.xEstadog) {
                            this.xsql = " update q_procedqxespec set Duracion='" + this.JFTDuracion.getText() + "', Indicaciones='" + this.JTPIndicacion.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_Procedimiento='" + Principal.txtNo.getText() + "' and Id_Especialidad='" + this.xespecilidad[this.JCB_Especialidad.getSelectedIndex()] + "'";
                        } else {
                            this.xsql = "INSERT IGNORE INTO q_procedqxespec (Id_Especialidad, Id_Procedimiento, Duracion, Indicaciones, Estado, Fecha, UsuarioS) values ('" + this.xespecilidad[this.JCB_Especialidad.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.JFTDuracion.getText() + "','" + this.JTPIndicacion.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La duracion no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JFTDuracion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCB_Especialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTDuracionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Procedimiento", "Duracion", "Indicaciones", "Estado"}) { // from class: ParametrizacionN.JDProxEspc.8
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_PDetalle.setModel(this.xModelo);
        this.JTB_PDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_PDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_PDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTB_PDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_PDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            this.xsql = "SELECT`g_especialidad`.`Nbre` AS `Especialidad`, `g_procedimiento`.`Nbre` AS `Procedimiento`, `q_procedqxespec`.`Duracion`, `q_procedqxespec`.`Indicaciones`, `q_procedqxespec`.`Estado`   \nFROM `g_procedimiento` INNER JOIN `q_procedqxespec` ON (`g_procedimiento`.`Id` = `q_procedqxespec`.`Id_Procedimiento`) INNER JOIN `baseserver`.`g_especialidad` ON (`g_especialidad`.`Id` = `q_procedqxespec`.`Id_Especialidad`)\nWHERE (`g_procedimiento`.`Id` ='" + Principal.txtNo.getText() + "') ORDER BY `Especialidad` ASC;";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(xrs.getString(1), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(xrs.getString(4), n, 3);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDProxEspc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
