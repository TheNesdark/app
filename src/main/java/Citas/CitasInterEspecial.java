package Citas;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.citas.JIFCarneCitas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CitasInterEspecial.class */
public class CitasInterEspecial extends JInternalFrame {
    public String[] listaDiasFestivos;
    public String[] listaProfesional;
    public String[] xidempresafac;
    public String[] xidsede;
    public String[][] listaClaseCita;
    public ResultSet rs;
    public String sql;
    public String idProfesional;
    public String nbreProfesional;
    public String idEspecialD;
    public String nbreEspecialD;
    public String IdRemision;
    public static String NoCitaIps;
    public Object[] dato;
    public DefaultTableModel modeloGrid;
    private String idPaciente;
    private ClaseHiloCita hCita;
    private Thread hilo;
    public JButton boton;
    private Calendario frmCal;
    private clasesCita clasescita;
    private JComboBox JCBEmpresa;
    private JComboBox JCBSede;
    private JButton btnBuscarCita;
    private JButton btnSalir;
    private JComboBox cboClaseCita;
    public JComboBox cboProfesional;
    public JTable grid;
    private ButtonGroup grupoRemision;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JMenuItem mnAsignar;
    private JMenuItem mnAsistida;
    private JMenuItem mnDesistir;
    private JMenuItem mnLlamar;
    private JPopupMenu mnPopup;
    private JMenuItem mnReasignar;
    private JMenuItem mnRecordatorio;
    private JMenuItem mnSalir;
    private JPanel panelCal;
    public static JTextField txtConsultorio;
    private JTextField txtDuracion;
    public JTextField txtNoCita;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int filaGrid = 0;
    public int motivoDesistida = 1;
    public String[][] listaPacientesConCita = new String[0][0];
    public int filaListaDiasConCita = 0;
    public int cboLleno = 0;
    public int combocc = 0;
    public DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
    private int citaTelefonica = 0;
    private int citaPrimerVez = 0;
    public int remitida = -1;
    private int idReasignar = 0;
    private String NoCitaAReasignar = "0";
    public DecimalFormat formato2Digito = new DecimalFormat("#0");

    public CitasInterEspecial(String IdEspecialD, String NbreProfesional, String IdPaciente, String IdIngreso, String NbreEspecialD, String IdRemision, clasesCita claseC) {
        this.idEspecialD = "";
        initComponents();
        this.clasescita = claseC;
        this.idEspecialD = IdEspecialD;
        this.nbreProfesional = NbreProfesional;
        this.idPaciente = IdPaciente;
        this.nbreEspecialD = NbreEspecialD;
        this.IdRemision = IdRemision;
        cargarCalendario();
        cargarProfesionales();
        cargarClaseCita();
        cargarNoCitaIps();
        mllenarComboEmpresaFac();
        this.hCita = new ClaseHiloCita(this, this.txtNoCita.getText(), this.idProfesional);
        this.hilo = new Thread(this.hCita);
        this.hilo.start();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitasInterEspecial.1
            public void mouseClicked(MouseEvent e) {
                CitasInterEspecial.this.filaGrid = CitasInterEspecial.this.grid.rowAtPoint(e.getPoint());
                if (CitasInterEspecial.this.grid.getValueAt(CitasInterEspecial.this.filaGrid, 3) == null) {
                    CitasInterEspecial.this.txtNoCita.setText("0");
                } else {
                    CitasInterEspecial.this.txtNoCita.setText(CitasInterEspecial.this.grid.getValueAt(CitasInterEspecial.this.filaGrid, 3).toString());
                }
            }
        });
    }

    private void cargarCalendario() {
        this.frmCal = new Calendario(this);
        this.frmCal.setBounds(1, 1, 292, 292);
        this.panelCal.add(this.frmCal);
        this.panelCal.setVisible(true);
        this.frmCal.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r3v87, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.mnPopup = new JPopupMenu();
        this.mnAsignar = new JMenuItem();
        this.mnReasignar = new JMenuItem();
        this.mnDesistir = new JMenuItem();
        this.mnAsistida = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnRecordatorio = new JMenuItem();
        this.mnLlamar = new JMenuItem();
        this.jSeparator2 = new JSeparator();
        this.mnSalir = new JMenuItem();
        this.grupoRemision = new ButtonGroup();
        this.jPanel5 = new JPanel();
        this.panelCal = new JPanel();
        this.btnSalir = new JButton();
        this.jPanel1 = new JPanel();
        this.cboClaseCita = new JComboBox();
        this.txtDuracion = new JTextField();
        txtConsultorio = new JTextField();
        this.cboProfesional = new JComboBox();
        this.JCBEmpresa = new JComboBox();
        this.JCBSede = new JComboBox();
        this.jPanel3 = new JPanel();
        this.txtNoCita = new JTextField();
        this.btnBuscarCita = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.mnAsignar.setText("Asignar Cita");
        this.mnAsignar.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.2
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnAsignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsignar);
        this.mnReasignar.setText("Reasignar Cita");
        this.mnReasignar.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.3
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnReasignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnReasignar);
        this.mnDesistir.setText("Desistir Cita");
        this.mnDesistir.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.4
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnDesistirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnDesistir);
        this.mnAsistida.setText("Asistida");
        this.mnAsistida.setToolTipText("Presione si el usuario asistió su cita");
        this.mnAsistida.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.5
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnAsistidaActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsistida);
        this.mnPopup.add(this.jSeparator1);
        this.mnRecordatorio.setText("Imprimir Recordatorio de Cita");
        this.mnRecordatorio.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.6
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnRecordatorioActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnRecordatorio);
        this.mnLlamar.setText("Llamar al Usuario");
        this.mnLlamar.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.7
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnLlamarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnLlamar);
        this.mnPopup.add(this.jSeparator2);
        this.mnSalir.setText("Salir");
        this.mnSalir.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.8
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.mnSalirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnSalir);
        setClosable(true);
        setTitle("ASIGNACIÓN DE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(963, 775));
        setMinimumSize(new Dimension(963, 775));
        setName("CitasInterEspecial");
        setPreferredSize(new Dimension(963, 775));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.panelCal.setBorder(BorderFactory.createEtchedBorder(0));
        this.panelCal.setMaximumSize(new Dimension(289, 291));
        this.panelCal.setMinimumSize(new Dimension(289, 291));
        this.panelCal.setPreferredSize(new Dimension(289, 291));
        this.panelCal.setLayout((LayoutManager) null);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.9
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE LA CITA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.cboClaseCita.setFont(new Font("Arial", 1, 12));
        this.cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase de cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboClaseCita.setName("cboClaseCita");
        this.cboClaseCita.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.10
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.cboClaseCitaActionPerformed(evt);
            }
        });
        this.txtDuracion.setEditable(false);
        this.txtDuracion.setBackground(new Color(0, 0, 153));
        this.txtDuracion.setFont(new Font("Arial", 1, 12));
        this.txtDuracion.setForeground(new Color(255, 255, 255));
        this.txtDuracion.setHorizontalAlignment(0);
        this.txtDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración (minutos)", 0, 0, new Font("Arial", 1, 12)));
        this.txtDuracion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtDuracion.setEnabled(false);
        this.txtDuracion.setName("txtDuracion");
        txtConsultorio.setBackground(new Color(0, 0, 153));
        txtConsultorio.setFont(new Font("Arial", 1, 12));
        txtConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio", 0, 0, new Font("Arial", 1, 12)));
        txtConsultorio.setDisabledTextColor(new Color(255, 255, 255));
        txtConsultorio.setEnabled(false);
        txtConsultorio.setName("txtConsultorio");
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProfesional.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.11
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.cboProfesionalActionPerformed(evt);
            }
        });
        this.cboProfesional.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.CitasInterEspecial.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CitasInterEspecial.this.cboProfesionalPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa para facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEmpresa.setName("cboClaseCita");
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.13
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSede.setName("cboClaseCita");
        this.JCBSede.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.14
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.JCBSedeActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBSede, -2, 226, -2).addGap(18, 18, 18).addComponent(this.JCBEmpresa, -2, 444, -2).addGap(18, 18, 18).addComponent(this.txtDuracion, -1, 141, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.cboProfesional, -2, 321, -2).addGap(18, 18, 18).addComponent(this.cboClaseCita, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtConsultorio))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSede, -2, 50, -2).addComponent(this.txtDuracion, -2, 50, -2).addComponent(this.JCBEmpresa, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboProfesional, -2, 50, -2).addComponent(this.cboClaseCita, -2, 50, -2).addComponent(txtConsultorio, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.txtNoCita.setEditable(false);
        this.txtNoCita.setBackground(new Color(0, 0, 153));
        this.txtNoCita.setFont(new Font("Arial", 1, 18));
        this.txtNoCita.setForeground(new Color(255, 255, 255));
        this.txtNoCita.setHorizontalAlignment(4);
        this.txtNoCita.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cita", 2, 0, new Font("Arial", 1, 12), Color.white));
        this.txtNoCita.setDisabledTextColor(new Color(204, 204, 255));
        this.txtNoCita.setEnabled(false);
        this.btnBuscarCita.setFont(new Font("Arial", 1, 12));
        this.btnBuscarCita.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaEspecial.png")));
        this.btnBuscarCita.setText("Buscar Citas");
        this.btnBuscarCita.addActionListener(new ActionListener() { // from class: Citas.CitasInterEspecial.15
            public void actionPerformed(ActionEvent evt) {
                CitasInterEspecial.this.btnBuscarCitaActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.txtNoCita, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscarCita, -2, 200, -2).addContainerGap(18, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNoCita, -1, 60, 32767).addComponent(this.btnBuscarCita, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setForeground(new Color(0, 0, 102));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(3);
        this.grid.setCellSelectionEnabled(true);
        this.grid.setName("grid");
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitasInterEspecial.16
            public void mouseReleased(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseExited(evt);
            }

            public void mousePressed(MouseEvent evt) {
                CitasInterEspecial.this.gridMousePressed(evt);
            }
        });
        this.grid.addMouseMotionListener(new MouseMotionAdapter() { // from class: Citas.CitasInterEspecial.17
            public void mouseDragged(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseDragged(evt);
            }

            public void mouseMoved(MouseEvent evt) {
                CitasInterEspecial.this.gridMouseMoved(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(1);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnSalir, -2, 484, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 590, -2).addGap(10, 10, 10).addComponent(this.panelCal, -2, 290, -2)).addComponent(this.jPanel1, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelCal, -2, 292, -2).addGap(0, 101, 32767)).addComponent(this.jScrollPane3, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.btnSalir, -2, 83, -2)).addGap(24, 24, 24)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel5, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarActionPerformed(ActionEvent evt) {
        asignarCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnDesistirActionPerformed(ActionEvent evt) {
        desistir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnSalirActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarCitaActionPerformed(ActionEvent evt) {
        JIFCarneCitas frmB = new JIFCarneCitas(null, true, this.idPaciente, "CitasInterEspecial", this);
        frmB.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnRecordatorioActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        this.clasescita.imprimirCita("0", this.cboClaseCita.getSelectedItem().toString(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3) {
            this.mnPopup.setVisible(true);
            this.mnPopup.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnReasignarActionPerformed(ActionEvent evt) {
        reasignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseMoved(MouseEvent evt) {
        this.grid.setToolTipText(this.modeloGrid.getValueAt(this.filaGrid, 5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseDragged(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnLlamarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsistidaActionPerformed(ActionEvent evt) {
        asistirCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaActionPerformed(ActionEvent evt) {
        if (this.cboLleno != 1 || this.cboClaseCita.getSelectedIndex() > -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboProfesional.getSelectedIndex() > -1) {
            cargarProgCalendario();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    private void asignarCita() {
        this.mnPopup.setVisible(false);
        if (getValidarCampos() == 1) {
            if (this.idReasignar == 0) {
                grabar();
            } else {
                modificarCita();
            }
            cargarHorarioGrid();
        }
    }

    private void asistirCita() {
        this.mnPopup.setVisible(false);
        if (this.txtNoCita.getText().equals("0")) {
            this.metodos.mostrarMensaje("Por favor seleccione una Cita");
            return;
        }
        this.sql = "UPDATE c_citas SET Asistida = 1 WHERE Id ='" + this.txtNoCita.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Ok la Cita fue Asistida por el Usuario");
    }

    public void cargarAgenda() {
        this.frmCal.refrescar();
        this.frmCal.limpiarListaDiasConCita();
        this.frmCal.montarAgendaGeneral(this.idProfesional, this.idEspecialD);
        this.frmCal.montarAgendaEspecial(this.idProfesional, this.idEspecialD);
        this.frmCal.montarAgendaExcepcion(this.idProfesional, this.idEspecialD);
    }

    public void cargarPacienteConCita() {
        try {
            this.sql = "SELECT c_citas.HoraInicial, c_citas.HoraFinal, persona.NUsuario, c_clasecita.Duracion, c_citas.Id, persona.Id_persona, c_clasecita.Nbre, g_parentesco.EsTrabajador, persona.NoHistoria FROM  c_citas INNER JOIN  c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN  persona ON (c_citas.Id_Usuario = persona.Id_persona) INNER JOIN  g_usuario ON (persona.Id_persona = g_usuario.Id_persona) LEFT JOIN  g_usuario_fpz ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona) LEFT JOIN  g_parentesco ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) WHERE (c_citas.Fecha_Cita ='" + this.frmCal.getAno() + "-" + this.frmCal.getMes() + "1-" + this.formato2Digito.format(this.frmCal.getDia()) + "' AND c_citas.Id_Profesional ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "' AND c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Especialidad ='" + this.idEspecialD + "') ORDER BY c_citas.HoraInicial ASC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.listaPacientesConCita = new String[this.rs.getRow()][9];
            if (this.rs.getRow() > 0) {
                int fila = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.listaPacientesConCita[fila][0] = this.rs.getString(1);
                    this.listaPacientesConCita[fila][1] = this.rs.getString(2);
                    this.listaPacientesConCita[fila][2] = this.rs.getString(3);
                    this.listaPacientesConCita[fila][3] = this.rs.getString(4);
                    this.listaPacientesConCita[fila][4] = this.rs.getString(5);
                    this.listaPacientesConCita[fila][5] = this.rs.getString(6);
                    this.listaPacientesConCita[fila][6] = this.rs.getString(7);
                    if (this.rs.getString(8) != null) {
                        if (this.rs.getString(8).equals("1")) {
                            this.listaPacientesConCita[fila][7] = "1";
                        } else {
                            this.listaPacientesConCita[fila][7] = "0";
                        }
                    } else {
                        this.listaPacientesConCita[fila][7] = "0";
                    }
                    this.listaPacientesConCita[fila][8] = this.rs.getString(9);
                    fila++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(CitasInterEspecial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarProfesionales() {
        this.sql = "SELECT Id_Persona, NProfesional FROM  profesional1 WHERE (IdEspecialidad ='" + this.idEspecialD + "') ORDER BY NProfesional ASC";
        this.listaProfesional = this.consultas.llenarCombo(this.sql, this.listaProfesional, this.cboProfesional);
        this.cboProfesional.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarProgCalendario() {
        crearGrid();
        setProfesional();
        cargarAgenda();
    }

    private void cargarClaseCita() {
        this.cboClaseCita.removeAllItems();
        this.listaClaseCita = this.consultas.llenarComboyLista("SELECT Id, Nbre, Duracion FROM c_clasecita WHERE Id_Especialidad ='" + this.idEspecialD + "' ORDER BY Nbre ASC", this.listaClaseCita, this.cboClaseCita, 100);
        if (this.cboClaseCita.getItemCount() > 0) {
            this.cboClaseCita.setSelectedIndex(-1);
            this.combocc = 1;
        }
        this.consultas.cerrarConexionBd();
    }

    public void cargarHorarioGrid() {
        cargarPacienteConCita();
        for (int i = 0; i < 1000; i++) {
        }
    }

    private void cargarNoCitaIps() {
        this.sql = "SELECT NoCita FROM g_ips";
        NoCitaIps = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void crearGrid() {
        this.modeloGrid = new DefaultTableModel() { // from class: Citas.CitasInterEspecial.18
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGrid.addColumn("DESDE");
        this.modeloGrid.addColumn("HASTA");
        this.modeloGrid.addColumn("USUARIO");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.grid.setModel(this.modeloGrid);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void desistir() {
        this.mnPopup.setVisible(false);
        Anular frm1 = new Anular(null, true, "CitasInterEspecial", 7);
        frm1.setVisible(true);
    }

    public String getHora(int hInicial, int min) {
        String hora;
        if (hInicial < 10) {
            if (min < 10) {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":0" + String.valueOf(min));
            } else {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":" + String.valueOf(min));
            }
        } else if (min < 10) {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":0" + String.valueOf(min));
        } else {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":" + String.valueOf(min));
        }
        return hora;
    }

    private int getValidarCampos() {
        int validar = 0;
        if (this.nbreProfesional.isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Profesional.");
            this.cboProfesional.requestFocus();
        } else if (this.metodos.getFechaActual().getTime() > this.frmCal.getFecha().getTime().getTime()) {
            this.metodos.mostrarMensaje("No puede asignar una Cita en Fechas anteriores a la actual\nPor favor verifique las fechas");
        } else if (this.cboClaseCita.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la Clase de Cita.");
            this.cboClaseCita.requestFocus();
        } else {
            validar = 1;
        }
        return validar;
    }

    public void grabar() {
        grabarCita();
        if (this.metodos.getPregunta("Desea recordatorio de cita") == 0) {
        }
    }

    public void grabarCita() {
        String horaI = this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 5);
        if (this.grid.getValueAt(this.filaGrid, 0).toString().substring(6, 8).equals("PM")) {
            horaI = String.valueOf(12 + Integer.parseInt(this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 2))) + ":" + this.grid.getValueAt(this.filaGrid, 0).toString().substring(3, 5);
        }
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        this.sql = "INSERT INTO c_citas (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, HoraFinal, Telefonica, Remitida, PrimerVez, Asistida, Fecha, UsuarioS) VALUES ('" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.idEspecialD + "','" + this.idEspecialD + "','" + this.idEspecialD + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMD.format(this.frmCal.getFecha()) + "','" + horaI + "','" + horaF + "','" + this.citaTelefonica + "','" + this.remitida + "','" + this.citaPrimerVez + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.txtNoCita.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        this.grid.setValueAt(horaF, this.filaGrid, 1);
        this.grid.setValueAt(this.txtNoCita.getText(), this.filaGrid, 3);
        this.sql = "UPDATE g_ips SET g_ips.NoCita = '" + this.txtNoCita.getText() + "', IdProfesionalUltimaCita ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Cita Grabada, Ok");
    }

    private void mllenarComboEmpresaFac() {
        this.JCBEmpresa.removeAllItems();
        this.xidempresafac = this.consultas.llenarCombo("SELECT `f_empresacontxconvenio`.`Id`, UCASE(`f_empresacontxconvenio`.`Nbre`) AS NEmpresa FROM  `f_empresacontxconvenio` INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)  WHERE (`f_empresacontxconvenio`.`Estado` =0 AND `g_empresa`.`Estado` =1) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ", this.xidempresafac, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.JCBSede.removeAllItems();
        this.xidsede = this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_sedes` WHERE (`Estado` =1) ORDER BY `Nbre` ASC ", this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.consultas.cerrarConexionBd();
    }

    private void llenarFilaVacaciones(String hora) {
        for (int p = 0; p < this.modeloGrid.getRowCount(); p++) {
            if (this.modeloGrid.getValueAt(p, 0).toString().equals(hora)) {
                this.modeloGrid.setValueAt("Libre / Permiso / Vacaciones", p, 2);
                return;
            }
        }
    }

    private void llenarFilaVacia(int fila, String hora) {
        this.modeloGrid.addRow(this.dato);
        this.modeloGrid.setValueAt(hora, fila, 0);
        this.modeloGrid.setValueAt(" ", fila, 2);
        this.modeloGrid.setValueAt("", fila, 5);
        this.modeloGrid.setValueAt("0", fila, 6);
    }

    private void modificarCita() {
        String horaI = this.metodos.pasarHora12a24(this.modeloGrid.getValueAt(this.filaGrid, 0).toString());
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        this.sql = "UPDATE c_citas SET Id_Profesional ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "', Id_Especialidad ='" + this.idEspecialD + "', Id_ClaseCita ='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "', Fecha_Cita ='" + this.metodos.formatoAMD.format(this.frmCal.getFecha()) + "', HoraInicial ='" + horaI + "', HoraFinal ='" + horaF + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id = '" + this.NoCitaAReasignar + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.idReasignar = 0;
        this.NoCitaAReasignar = "";
        this.metodos.mostrarMensaje("Cita Reasignada, Ok");
    }

    public void nuevo() {
        this.txtNoCita.setText("Nuevo");
        mllenarComboEmpresaFac();
    }

    private void reasignar() {
        this.mnPopup.setVisible(false);
        if (!this.modeloGrid.getValueAt(this.filaGrid, 2).toString().equals("")) {
            this.idReasignar = 1;
            this.NoCitaAReasignar = this.txtNoCita.getText();
        } else {
            this.metodos.mostrarMensaje("Por favor seleccione al usuario que desea Reasignar la Cita.\nLuego busque el día y la fecha de destino para Reasignar");
        }
    }

    private void setProfesional() {
        this.idProfesional = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
        this.nbreProfesional = this.cboProfesional.getSelectedItem().toString();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitasInterEspecial$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 6).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(255, 255, 204));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
