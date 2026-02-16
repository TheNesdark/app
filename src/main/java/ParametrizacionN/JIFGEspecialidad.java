package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGEspecialidad.class */
public class JIFGEspecialidad extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String xnombrer;
    private String cespecialidad;
    private JButton JBTTipoFormula;
    private JComboBox<String> JCBLista;
    private JCheckBox JCHAnasteciologia;
    private JCheckBox JCHAsignarCita;
    private JCheckBox JCHBacteriologia;
    private JCheckBox JCHEsFisioterapia;
    private JCheckBox JCHEsOdontologia;
    private JCheckBox JCHEsPyP;
    private JCheckBox JCHEsQx;
    private JCheckBox JCHEstado;
    private JCheckBox JCHG_Ordenes;
    private JCheckBox JCHRValoracion;
    private JCheckBox JCH_Epicrisis;
    private JPanel JPIDatos;
    private JSpinner JSPCitaRepetida;
    private JSpinner JSPCitasxDia;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCespecialidd;
    private JTextField JTFCups;
    private JTextField JTFNombre;
    private JTextField JTFNombreR;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesodontologia = 0;
    private int xespyp = 0;
    private int xesfisioterapia = 0;
    private int xesbacteriologia = 0;
    private int xasignarcita = 0;
    private int xrvaloracion = 0;
    private int xv_Epicrisis = 0;
    private int xQx = 0;
    private int xG_Ordenes = 0;
    private int xanestesioligia = 0;
    private int idCrips = 5;
    private boolean xestadog = false;

    public JIFGEspecialidad() {
        initComponents();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEsOdontologia = new JCheckBox();
        this.JCHEsPyP = new JCheckBox();
        this.JCHEsFisioterapia = new JCheckBox();
        this.JCHBacteriologia = new JCheckBox();
        this.JCHAsignarCita = new JCheckBox();
        this.JSPCitasxDia = new JSpinner();
        this.JCHRValoracion = new JCheckBox();
        this.JCH_Epicrisis = new JCheckBox();
        this.JCHEsQx = new JCheckBox();
        this.JTFCups = new JTextField();
        this.JCHG_Ordenes = new JCheckBox();
        this.JSPCitaRepetida = new JSpinner();
        this.JCHAnasteciologia = new JCheckBox();
        this.JCBLista = new JComboBox<>();
        this.JTFNombreR = new JTextField();
        this.JTFCespecialidd = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTTipoFormula = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ESPECIALIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifespecialidad");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGEspecialidad.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGEspecialidad.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.2
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsOdontologia.setFont(new Font("Arial", 1, 12));
        this.JCHEsOdontologia.setText("Es Odontología?");
        this.JCHEsOdontologia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.3
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHEsOdontologiaActionPerformed(evt);
            }
        });
        this.JCHEsPyP.setFont(new Font("Arial", 1, 12));
        this.JCHEsPyP.setText("Es PyP?");
        this.JCHEsPyP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.4
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHEsPyPActionPerformed(evt);
            }
        });
        this.JCHEsFisioterapia.setFont(new Font("Arial", 1, 12));
        this.JCHEsFisioterapia.setText("Es Fisioterapia?");
        this.JCHEsFisioterapia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.5
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHEsFisioterapiaActionPerformed(evt);
            }
        });
        this.JCHBacteriologia.setFont(new Font("Arial", 1, 12));
        this.JCHBacteriologia.setText("Es Bacteriología?");
        this.JCHBacteriologia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.6
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHBacteriologiaActionPerformed(evt);
            }
        });
        this.JCHAsignarCita.setFont(new Font("Arial", 1, 12));
        this.JCHAsignarCita.setText("Asignar Cita?");
        this.JCHAsignarCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.7
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHAsignarCitaActionPerformed(evt);
            }
        });
        this.JSPCitasxDia.setFont(new Font("Arial", 1, 12));
        this.JSPCitasxDia.setModel(new SpinnerNumberModel(0, 0, 3, 1));
        this.JSPCitasxDia.setToolTipText("");
        this.JSPCitasxDia.setBorder(BorderFactory.createTitledBorder((Border) null, "Citas por Día", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHRValoracion.setFont(new Font("Arial", 1, 12));
        this.JCHRValoracion.setText("RValoración");
        this.JCHRValoracion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.8
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHRValoracionActionPerformed(evt);
            }
        });
        this.JCH_Epicrisis.setFont(new Font("Arial", 1, 12));
        this.JCH_Epicrisis.setText("Epicrsis");
        this.JCH_Epicrisis.setToolTipText("Visualizar en reporte de epicrisis");
        this.JCH_Epicrisis.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.9
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCH_EpicrisisActionPerformed(evt);
            }
        });
        this.JCHEsQx.setFont(new Font("Arial", 1, 12));
        this.JCHEsQx.setText("Es Qx?");
        this.JCHEsQx.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.10
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHEsQxActionPerformed(evt);
            }
        });
        this.JTFCups.setFont(new Font("Arial", 1, 12));
        this.JTFCups.setBorder(BorderFactory.createTitledBorder((Border) null, "Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHG_Ordenes.setFont(new Font("Arial", 1, 12));
        this.JCHG_Ordenes.setText("Órden");
        this.JCHG_Ordenes.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.11
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHG_OrdenesActionPerformed(evt);
            }
        });
        this.JSPCitaRepetida.setFont(new Font("Arial", 1, 12));
        this.JSPCitaRepetida.setBorder(BorderFactory.createTitledBorder((Border) null, "Citas Repetidas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAnasteciologia.setFont(new Font("Arial", 1, 12));
        this.JCHAnasteciologia.setText("Anestesiologia ?");
        this.JCHAnasteciologia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.12
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JCHAnasteciologiaActionPerformed(evt);
            }
        });
        this.JCBLista.setFont(new Font("Arial", 1, 12));
        this.JCBLista.setModel(new DefaultComboBoxModel(new String[]{"Medicos Especialistas", "Medicos Generales", "Enfermera", "Auxiliar De Enfermeria", "Otro"}));
        this.JCBLista.setBorder(BorderFactory.createTitledBorder((Border) null, "Lista", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLista.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFGEspecialidad.13
            public void itemStateChanged(ItemEvent evt) {
                JIFGEspecialidad.this.JCBListaItemStateChanged(evt);
            }
        });
        this.JTFNombreR.setFont(new Font("Arial", 1, 12));
        this.JTFNombreR.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Visulizar En Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCespecialidd.setFont(new Font("Arial", 1, 12));
        this.JTFCespecialidd.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 772, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsOdontologia).addComponent(this.JCHAsignarCita)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsPyP).addComponent(this.JCHRValoracion))).addComponent(this.JCBLista, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsFisioterapia).addComponent(this.JCH_Epicrisis)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHBacteriologia, -1, -1, 32767).addComponent(this.JCHAnasteciologia, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsQx).addComponent(this.JCHG_Ordenes))).addComponent(this.JTFNombreR, -2, 343, -2)).addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCespecialidd, -2, 141, -2).addComponent(this.JSPCitaRepetida, -2, 135, -2)).addGap(18, 18, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JCHEstado)).addComponent(this.JTFCups).addComponent(this.JSPCitasxDia, -1, 135, 32767)))).addGap(15, 15, 15)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado, GroupLayout.Alignment.TRAILING)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsOdontologia).addComponent(this.JCHEsPyP).addComponent(this.JCHBacteriologia).addComponent(this.JCHG_Ordenes)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAsignarCita).addComponent(this.JCHRValoracion)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAnasteciologia).addComponent(this.JCHEsQx)))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsFisioterapia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Epicrisis)))).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCitasxDia, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBLista).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreR, -2, -1, -2).addComponent(this.JTFCespecialidd, -2, -1, -2).addComponent(this.JTFCups, -2, -1, -2)).addGap(0, 8, 32767)))).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCitaRepetida, -2, 41, -2).addGap(0, 0, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGEspecialidad.14
            public void mouseClicked(MouseEvent evt) {
                JIFGEspecialidad.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTTipoFormula.setFont(new Font("Arial", 1, 12));
        this.JBTTipoFormula.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBTTipoFormula.setText("Agregar Tipo de Formula");
        this.JBTTipoFormula.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGEspecialidad.15
            public void actionPerformed(ActionEvent evt) {
                JIFGEspecialidad.this.JBTTipoFormulaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTTipoFormula, -2, 244, -2).addComponent(this.JPIDatos, -2, -1, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 268, -2).addGap(18, 18, 18).addComponent(this.JBTTipoFormula, -2, 50, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEsOdontologia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JCHEsPyP.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHEsFisioterapia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JCHBacteriologia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCHAsignarCita.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JSPCitasxDia.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
            this.JSPCitaRepetida.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            this.JCHRValoracion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            this.JCHEsQx.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).booleanValue());
            this.JCHG_Ordenes.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()).booleanValue());
            this.JCH_Epicrisis.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).booleanValue());
            this.JTFCups.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            this.JCHAnasteciologia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).booleanValue());
            this.JCBLista.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString());
            if ("Medicos Especialistas".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString())) {
                this.idCrips = 1;
            } else if ("Medicos Generales".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString())) {
                this.idCrips = 2;
            } else if ("Enfermera".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString())) {
                this.idCrips = 3;
            } else if ("Auxiliar De Enfermeria".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString())) {
                this.idCrips = 4;
            } else {
                this.idCrips = 5;
            }
            this.JTFNombreR.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString());
            this.JTFCespecialidd.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsOdontologiaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPyPActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsFisioterapiaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBacteriologiaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAsignarCitaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRValoracionActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTipoFormulaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tipo de Fórmula");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe selccionar una Especialidad de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EpicrisisActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsQxActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHG_OrdenesActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnasteciologiaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBListaItemStateChanged(ItemEvent evt) {
        switch (this.JCBLista.getSelectedIndex()) {
            case 0:
                this.idCrips = 1;
                break;
            case 1:
                this.idCrips = 2;
                break;
            case 2:
                this.idCrips = 3;
                break;
            case 3:
                this.idCrips = 4;
                break;
            case 4:
                this.idCrips = 5;
                break;
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEsOdontologia.setSelected(false);
        this.JCHEsFisioterapia.setSelected(false);
        this.JCHBacteriologia.setSelected(false);
        this.JCHEsPyP.setSelected(false);
        this.JCHAsignarCita.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JSPCitasxDia.setValue(new Integer(0));
        this.JSPCitaRepetida.setValue(new Integer(0));
        this.JCHRValoracion.setSelected(false);
        this.JCHEsQx.setSelected(false);
        this.JCHG_Ordenes.setSelected(false);
        this.JCH_Epicrisis.setSelected(false);
        this.JTFCups.setText("");
        this.JTFNombreR.setText("");
        this.JTFCespecialidd.setText("");
        this.idCrips = 5;
        mCargarDatosTabla();
        mIniciarCheck();
        this.JTFNombre.requestFocus();
        this.JCBLista.setSelectedIndex(4);
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into g_especialidad(Nbre, EsOdontologia, EsPyP, Fisioterapia, Bacteriologia, DiasCitas, CitaRepetida, Estado, AsignarCita, RValoracion, Es_Qx,G_Ordenes,VEpicrisis,Cups,Id_CRips,NMostrar,CEspecilidad ,EsAnestesiologia , Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xesodontologia + "','" + this.xespyp + "','" + this.xesfisioterapia + "','" + this.xesbacteriologia + "','" + this.JSPCitasxDia.getValue() + "','" + this.JSPCitaRepetida.getValue() + "','" + this.xestado + "','" + this.xasignarcita + "','" + this.xrvaloracion + "','" + this.xQx + "','" + this.xG_Ordenes + "','" + this.xv_Epicrisis + "','" + this.JTFCups.getText() + "','" + this.idCrips + "','" + this.JTFNombreR.getText().toUpperCase() + "','" + this.JTFCespecialidd.getText().toUpperCase() + "','" + this.xanestesioligia + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    mNuevo();
                } else {
                    sql = " update g_especialidad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsOdontologia='" + this.xesodontologia + "',EsPyP='" + this.xespyp + "', Fisioterapia='" + this.xesfisioterapia + "',Bacteriologia='" + this.xesbacteriologia + "', DiasCitas='" + this.JSPCitasxDia.getValue() + "', CitaRepetida='" + this.JSPCitaRepetida.getValue() + "',AsignarCita='" + this.xasignarcita + "',Estado='" + this.xestado + "', RValoracion='" + this.xrvaloracion + "', Es_Qx='" + this.xQx + "', G_Ordenes='" + this.xG_Ordenes + "', VEpicrisis='" + this.xv_Epicrisis + "', Cups='" + this.JTFCups.getText() + "', EsAnestesiologia='" + this.xanestesioligia + "', Id_CRips='" + this.idCrips + "', NMostrar='" + this.JTFNombreR.getText().toUpperCase() + "', CEspecilidad='" + this.JTFCespecialidd.getText().toUpperCase() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    mNuevo();
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Es Odontología?", "Es PyP?", "Es Fisioterapia?", "Es Bacteriología?", "Asignar Cita?", "Citas x Día", "Citas Repetidas", "Estado", "RValoración", "Es Qx", "Órdenes", "VEpicrisis", "Cups", "Es Anestesiologia?", "Id_Crips", "NombreR", "Codigo Especialidad"}) { // from class: ParametrizacionN.JIFGEspecialidad.16
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Long.class, Long.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(120);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, EsOdontologia, EsPyP, Fisioterapia, Bacteriologia, AsignarCita, DiasCitas,CitaRepetida, Estado, RValoracion,Es_Qx,G_Ordenes, VEpicrisis,Cups , EsAnestesiologia ,IF(Id_CRips=1,'Medicos Especialistas',IF(Id_CRips=2,'Medicos Generales',IF(Id_CRips=3,'Enfermera',IF(Id_CRips=4,'Auxiliar De Enfermeria','Otros'))))AS Id_CRips ,NMostrar ,CEspecilidad FROM g_especialidad ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 11);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(13)), n, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSPresentacionFarmaceuta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarCheck() {
        if (this.JCHEsOdontologia.isSelected()) {
            this.xesodontologia = 1;
        } else {
            this.xesodontologia = 0;
        }
        if (this.JCHEsPyP.isSelected()) {
            this.xespyp = 1;
        } else {
            this.xespyp = 0;
        }
        if (this.JCHEsFisioterapia.isSelected()) {
            this.xesfisioterapia = 1;
        } else {
            this.xesfisioterapia = 0;
        }
        if (this.JCHBacteriologia.isSelected()) {
            this.xesbacteriologia = 1;
        } else {
            this.xesbacteriologia = 0;
        }
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        if (this.JCHAsignarCita.isSelected()) {
            this.xasignarcita = 1;
        } else {
            this.xasignarcita = 0;
        }
        if (this.JCHRValoracion.isSelected()) {
            this.xrvaloracion = 1;
        } else {
            this.xrvaloracion = 0;
        }
        if (this.JCH_Epicrisis.isSelected()) {
            this.xv_Epicrisis = 1;
        } else {
            this.xv_Epicrisis = 0;
        }
        if (this.JCHEsQx.isSelected()) {
            this.xQx = 1;
        } else {
            this.xQx = 0;
        }
        if (this.JCHG_Ordenes.isSelected()) {
            this.xG_Ordenes = 1;
        } else {
            this.xG_Ordenes = 0;
        }
        if (this.JCHAnasteciologia.isSelected()) {
            this.xanestesioligia = 1;
        } else {
            this.xanestesioligia = 0;
        }
    }
}
