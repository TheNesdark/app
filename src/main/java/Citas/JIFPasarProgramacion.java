package Citas;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/JIFPasarProgramacion.class */
public class JIFPasarProgramacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloAgenda;
    private Object[] xdatos;
    private Object[] xdatosAgenda;
    private String[] xidespecialidad;
    private String[] xidprofesionalo;
    private String[] xidprofesionald;
    private String[] xIdConsultorioO;
    private String[] xIdConsultorioD;
    private String[] xIdSEdeO;
    private String[] xIdSEdeD;
    private ButtonGroup JBGTipo;
    private JComboBox JCBConsultorioD;
    private JComboBox JCBConsultorioO;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesionalD;
    private JComboBox JCBProfesionalO;
    private JComboBox JCBSedeDestino;
    private JComboBox JCBSedeOrigen;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDCFechaD;
    private JDateChooser JDCFechaO;
    private JPanel JPIDatosI;
    private JRadioButton JRBCopiar;
    private JRadioButton JRBMoverAgendaCitas;
    private JRadioButton JRBMoverCitas;
    private JScrollPane JSPAgenda;
    private JScrollPane JSPCitas;
    private JTable JTAgenda;
    private JTable JTCitas;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xtipo = false;
    private boolean xSeleccionar = true;
    private boolean editable = false;

    public JIFPasarProgramacion() {
        initComponents();
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDatosI = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JDCFechaO = new JDateChooser();
        this.JDCFechaD = new JDateChooser();
        this.JCBProfesionalO = new JComboBox();
        this.JCBProfesionalD = new JComboBox();
        this.JRBMoverAgendaCitas = new JRadioButton();
        this.JRBCopiar = new JRadioButton();
        this.JCBConsultorioO = new JComboBox();
        this.JCBConsultorioD = new JComboBox();
        this.JRBMoverCitas = new JRadioButton();
        this.JCBSedeOrigen = new JComboBox();
        this.JCBSedeDestino = new JComboBox();
        this.JSPCitas = new JScrollPane();
        this.JTCitas = new JTable();
        this.JSPAgenda = new JScrollPane();
        this.JTAgenda = new JTable();
        this.JCHSeleccionar = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("PASAR PROGRAMACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcitasxlote");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatosI.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE CITAS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)), "", 2, 0));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Citas.JIFPasarProgramacion.1
            public void itemStateChanged(ItemEvent evt) {
                JIFPasarProgramacion.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JDCFechaO.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Origen", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaO.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaO.setFont(new Font("Arial", 1, 12));
        this.JDCFechaO.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFPasarProgramacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPasarProgramacion.this.JDCFechaOPropertyChange(evt);
            }
        });
        this.JDCFechaD.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Destino", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaD.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaD.setFont(new Font("Arial", 1, 12));
        this.JCBProfesionalO.setFont(new Font("Arial", 1, 12));
        this.JCBProfesionalO.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesionalO.addItemListener(new ItemListener() { // from class: Citas.JIFPasarProgramacion.3
            public void itemStateChanged(ItemEvent evt) {
                JIFPasarProgramacion.this.JCBProfesionalOItemStateChanged(evt);
            }
        });
        this.JCBProfesionalD.setFont(new Font("Arial", 1, 12));
        this.JCBProfesionalD.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBMoverAgendaCitas);
        this.JRBMoverAgendaCitas.setFont(new Font("Arial", 1, 12));
        this.JRBMoverAgendaCitas.setSelected(true);
        this.JRBMoverAgendaCitas.setText("Mover Agenda y Citas");
        this.JRBMoverAgendaCitas.addActionListener(new ActionListener() { // from class: Citas.JIFPasarProgramacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFPasarProgramacion.this.JRBMoverAgendaCitasActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBCopiar);
        this.JRBCopiar.setFont(new Font("Arial", 1, 12));
        this.JRBCopiar.setText("Copiar");
        this.JRBCopiar.addActionListener(new ActionListener() { // from class: Citas.JIFPasarProgramacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFPasarProgramacion.this.JRBCopiarActionPerformed(evt);
            }
        });
        this.JCBConsultorioO.setFont(new Font("Arial", 1, 12));
        this.JCBConsultorioO.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConsultorioO.addItemListener(new ItemListener() { // from class: Citas.JIFPasarProgramacion.6
            public void itemStateChanged(ItemEvent evt) {
                JIFPasarProgramacion.this.JCBConsultorioOItemStateChanged(evt);
            }
        });
        this.JCBConsultorioD.setFont(new Font("Arial", 1, 12));
        this.JCBConsultorioD.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBMoverCitas);
        this.JRBMoverCitas.setFont(new Font("Arial", 1, 12));
        this.JRBMoverCitas.setText("Mover citas");
        this.JRBMoverCitas.addActionListener(new ActionListener() { // from class: Citas.JIFPasarProgramacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFPasarProgramacion.this.JRBMoverCitasActionPerformed(evt);
            }
        });
        this.JCBSedeOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBSedeOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSedeOrigen.addItemListener(new ItemListener() { // from class: Citas.JIFPasarProgramacion.8
            public void itemStateChanged(ItemEvent evt) {
                JIFPasarProgramacion.this.JCBSedeOrigenItemStateChanged(evt);
            }
        });
        this.JCBSedeDestino.setFont(new Font("Arial", 1, 12));
        this.JCBSedeDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosILayout = new GroupLayout(this.JPIDatosI);
        this.JPIDatosI.setLayout(JPIDatosILayout);
        JPIDatosILayout.setHorizontalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addComponent(this.JCBProfesionalO, -2, 417, -2).addGap(18, 18, 18).addComponent(this.JCBProfesionalD, 0, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosILayout.createSequentialGroup().addComponent(this.JCBConsultorioO, -2, 417, -2).addGap(18, 18, 18).addComponent(this.JCBConsultorioD, 0, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosILayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBMoverCitas).addComponent(this.JRBMoverAgendaCitas).addComponent(this.JRBCopiar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 484, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaO, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCFechaD, -2, 110, -2)).addGroup(JPIDatosILayout.createSequentialGroup().addComponent(this.JCBSedeOrigen, -2, 417, -2).addGap(18, 18, 18).addComponent(this.JCBSedeDestino, 0, -1, 32767))).addContainerGap()));
        JPIDatosILayout.setVerticalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosILayout.createSequentialGroup().addContainerGap().addComponent(this.JRBMoverAgendaCitas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBMoverCitas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCopiar)).addGroup(JPIDatosILayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEspecialidad, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaO, -2, 50, -2).addComponent(this.JDCFechaD, -2, 50, -2))))).addGap(18, 18, 32767).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesionalO, -2, 50, -2).addComponent(this.JCBProfesionalD, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConsultorioO, -2, 50, -2).addComponent(this.JCBConsultorioD, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSedeOrigen, -2, 50, -2).addComponent(this.JCBSedeDestino, -2, 50, -2))));
        this.JSPCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "CITAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTCitas.setFont(new Font("Arial", 1, 12));
        this.JTCitas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCitas.setRowHeight(25);
        this.JTCitas.setSelectionBackground(new Color(255, 255, 255));
        this.JTCitas.setSelectionForeground(new Color(255, 0, 0));
        this.JTCitas.setSelectionMode(0);
        this.JTCitas.addMouseListener(new MouseAdapter() { // from class: Citas.JIFPasarProgramacion.9
            public void mouseClicked(MouseEvent evt) {
                JIFPasarProgramacion.this.JTCitasMouseClicked(evt);
            }
        });
        this.JSPCitas.setViewportView(this.JTCitas);
        this.JSPAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENDA", 2, 0, new Font("Arial", 1, 14), new Color(255, 51, 51)));
        this.JTAgenda.setFont(new Font("Arial", 1, 12));
        this.JTAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgenda.addMouseListener(new MouseAdapter() { // from class: Citas.JIFPasarProgramacion.10
            public void mouseClicked(MouseEvent evt) {
                JIFPasarProgramacion.this.JTAgendaMouseClicked(evt);
            }
        });
        this.JTAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFPasarProgramacion.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPasarProgramacion.this.JTAgendaPropertyChange(evt);
            }
        });
        this.JSPAgenda.setViewportView(this.JTAgenda);
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setSelected(true);
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: Citas.JIFPasarProgramacion.12
            public void actionPerformed(ActionEvent evt) {
                JIFPasarProgramacion.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosI, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(758, 758, 758).addComponent(this.JCHSeleccionar).addGap(14, 14, 14)).addComponent(this.JSPCitas).addComponent(this.JSPAgenda)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosI, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAgenda, -2, 138, -2).addGap(18, 18, 18).addComponent(this.JSPCitas, -2, 192, -2).addContainerGap(68, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBProfesionalO.removeAllItems();
            this.JCBProfesionalD.removeAllItems();
            String sql = "SELECT `profesional1`.`Id_Persona`, `profesional1`.`NProfesional` FROM `profesional1` INNER JOIN  `c_confcitas`  ON (`profesional1`.`Id_Persona` = `c_confcitas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_confcitas`.`Id_Especialidad`) WHERE (`c_confcitas`.`Estado` =0 AND `c_confcitas`.`Id_Especialidad` ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') GROUP BY `profesional1`.`Id_Persona` ORDER BY `profesional1`.`NProfesional` ASC ";
            this.xidprofesionalo = xct.llenarCombo(sql, this.xidprofesionalo, this.JCBProfesionalO);
            this.JCBProfesionalO.setSelectedIndex(-1);
            this.xidprofesionald = xct.llenarCombo(sql, this.xidprofesionald, this.JCBProfesionalD);
            this.JCBProfesionalD.setSelectedIndex(-1);
            xct.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalOItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProfesionalO.getSelectedIndex() != -1) {
            mCargarDatosAgenda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMoverAgendaCitasActionPerformed(ActionEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JCBProfesionalO.getSelectedIndex() != -1) {
                this.xtipo = false;
                this.editable = false;
                mCargarDatosAgenda();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el profesional de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProfesionalO.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCopiarActionPerformed(ActionEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JCBProfesionalO.getSelectedIndex() != -1) {
                this.xtipo = true;
                this.editable = true;
                mCargarDatosAgenda();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el profesional de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProfesionalO.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaOPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.JCBProfesionalO.getSelectedIndex() != -1) {
            mCargarDatosAgenda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JTCitas.getRowCount() != 0) {
            if (this.JCHSeleccionar.isSelected()) {
                this.xSeleccionar = true;
            } else {
                this.xSeleccionar = false;
            }
            for (int x = 0; x < this.JTCitas.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(this.xSeleccionar), x, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConsultorioOItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCitasMouseClicked(MouseEvent evt) {
        if (this.JTCitas.getSelectedRow() != -1) {
            this.JCBConsultorioO.setSelectedItem(this.xmodelo.getValueAt(this.JTCitas.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaMouseClicked(MouseEvent evt) {
        if (this.JTAgenda.getRowCount() > 0) {
            if (this.JTAgenda.getSelectedColumn() == 8) {
                mCargarDatosTabla();
            }
            this.JCBConsultorioO.setSelectedItem(this.xmodeloAgenda.getValueAt(this.JTAgenda.getSelectedRow(), 4));
            this.JCBSedeOrigen.setSelectedItem(this.xmodeloAgenda.getValueAt(this.JTAgenda.getSelectedRow(), 7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMoverCitasActionPerformed(ActionEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JCBProfesionalO.getSelectedIndex() != -1) {
                this.editable = true;
                mCargarDatosAgenda();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el profesional de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProfesionalO.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeOrigenItemStateChanged(ItemEvent evt) {
    }

    private void mIniciarComponentes() {
        this.JDCFechaO.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaD.setDate(this.xmetodos.getFechaActual());
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT  `g_especialidad`.`Id` , `g_especialidad`.`Nbre` FROM `g_especialidad` INNER JOIN  `c_citas`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) WHERE (`c_citas`.`Id_MotivoDesistida` =1) GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBConsultorioO.removeAllItems();
        this.xIdConsultorioO = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `c_consultorio` WHERE Estado=0 ORDER BY Nbre ASC;", this.xIdConsultorioO, this.JCBConsultorioO);
        this.JCBConsultorioO.setSelectedIndex(-1);
        this.JCBConsultorioD.removeAllItems();
        this.xIdConsultorioD = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `c_consultorio` WHERE Estado=0 ORDER BY Nbre ASC;", this.xIdConsultorioD, this.JCBConsultorioD);
        this.JCBConsultorioD.setSelectedIndex(-1);
        this.JCBSedeOrigen.removeAllItems();
        this.xIdSEdeO = this.xconsulta.llenarCombo("SELECT Id,Nbre FROM g_sedes;", this.xIdSEdeO, this.JCBSedeOrigen);
        this.JCBSedeOrigen.setSelectedIndex(-1);
        this.JCBSedeDestino.removeAllItems();
        this.xIdSEdeD = this.xconsulta.llenarCombo("SELECT Id,Nbre FROM g_sedes;", this.xIdSEdeD, this.JCBSedeDestino);
        this.JCBSedeDestino.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "N° Historia", "Usuario", "Hora", "Pasar?", "Consultorio"}) { // from class: Citas.JIFPasarProgramacion.13
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCitas.setModel(this.xmodelo);
        this.JTCitas.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTCitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTCitas.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTCitas.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTCitas.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTCitas.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            int n = 0;
            for (int i = 0; i < this.JTAgenda.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloAgenda.getValueAt(i, 8).toString()).booleanValue()) {
                    String sql = "SELECT c_citas.Id, persona.NoHistoria, persona.NUsuario, CONCAT(c_citas.HoraInicial,' - ',c_citas.HoraFinal) Hora, c_consultorio.`Nbre` consultorio \nFROM persona INNER JOIN c_citas  ON (persona.Id_persona = c_citas.Id_Usuario) \nINNER JOIN `c_consultorio` ON (c_consultorio.`Id` = `c_citas`.`Id_Consultorio`) \nWHERE (c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Profesional ='" + this.xidprofesionalo[this.JCBProfesionalO.getSelectedIndex()] + "' AND c_citas.Fecha_Cita ='" + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "'\nAND c_citas.HoraInicial BETWEEN '" + this.xmodeloAgenda.getValueAt(i, 2) + "' AND '" + this.xmodeloAgenda.getValueAt(i, 3) + "') ORDER BY c_citas.HoraInicial ASC\n";
                    ResultSet xrs = this.xconsulta.traerRs(sql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(true, n, 4);
                            this.xmodelo.setValueAt(xrs.getString(5), n, 5);
                            n++;
                        }
                    }
                    xrs.close();
                    this.xconsulta.cerrarConexionBd();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosMoverCitas() {
        try {
            mCrearModeloDatos();
            int n = 0;
            String sql = "SELECT c_citas.Id, persona.NoHistoria, persona.NUsuario, CONCAT(c_citas.HoraInicial,' - ',c_citas.HoraFinal) Hora, c_consultorio.`Nbre` consultorio \nFROM persona INNER JOIN c_citas  ON (persona.Id_persona = c_citas.Id_Usuario) \nINNER JOIN `c_consultorio` ON (c_consultorio.`Id` = `c_citas`.`Id_Consultorio`) \nWHERE (c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Profesional ='" + this.xidprofesionalo[this.JCBProfesionalO.getSelectedIndex()] + "' AND c_citas.Fecha_Cita ='" + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "') \n ORDER BY c_citas.HoraInicial ASC\n";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(true, n, 4);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloAgenda() {
        this.xmodeloAgenda = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "HoraI", "HoraF", "Consultorio", "Cant. Citas", "Tipo", "Sede", "Pasar?"}) { // from class: Citas.JIFPasarProgramacion.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgenda.setModel(this.xmodeloAgenda);
        this.JTAgenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTAgenda.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mCargarDatosAgenda() {
        try {
            mCrearModeloAgenda();
            String sql = "SELECT\n  c_confcitas.Id,\n  DATE_FORMAT(c_confcitas.Fecha_ConfCitas, '%Y/%m/%d') AS Fecha,\n  DATE_FORMAT(c_confcitas.HoraInicial, '%H:%i') AS HoraI,\n  DATE_FORMAT(c_confcitas.HoraFinal, '%H:%i') AS HoraF,\n  c_consultorio.Nbre AS Consultorio,\n  c_confcitas.Cupo AS 'Cant. Citas',\n  IF(c_confcitas.TipoAgenda = 1,'General',IF(c_confcitas.TipoAgenda = 2,'Especial','Vacaciones')) Tipo,\n  g_sedes.Nbre AS Sede\nFROM\n  c_confcitas\n  INNER JOIN c_consultorio\n    ON (c_confcitas.Id_Consultorio = c_consultorio.Id)\n  INNER JOIN g_sedes\n  ON (g_sedes.Id = c_confcitas.IdSede)\nWHERE \n  (c_confcitas.Id_Profesional = '" + this.xidprofesionalo[this.JCBProfesionalO.getSelectedIndex()] + "'\n    AND c_confcitas.Id_Especialidad = '" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'\n    AND DATE_FORMAT(c_confcitas.Fecha_ConfCitas, '%Y/%m/%d') = '" + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "' AND c_confcitas.Estado = 0)\nORDER BY c_confcitas.Fecha_ConfCitas DESC,\n  c_confcitas.HoraInicial;";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloAgenda.addRow(this.xdatosAgenda);
                    this.xmodeloAgenda.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloAgenda.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloAgenda.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloAgenda.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloAgenda.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloAgenda.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloAgenda.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloAgenda.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloAgenda.setValueAt(true, n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (this.JRBMoverCitas.isSelected() || this.JRBCopiar.isSelected()) {
            mCargarDatosMoverCitas();
        } else {
            mCargarDatosTabla();
        }
    }

    public void mGrabar() {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JCBProfesionalO.getSelectedIndex() != -1) {
                if (this.JCBConsultorioO.getSelectedIndex() != -1) {
                    if (this.JCBProfesionalD.getSelectedIndex() != -1) {
                        if (this.JCBConsultorioD.getSelectedIndex() != -1) {
                            if (this.JCBSedeOrigen.getSelectedIndex() != -1 && this.JCBSedeDestino.getSelectedIndex() != -1 && validarProgramacion().booleanValue()) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    if (this.JRBMoverCitas.isSelected()) {
                                        System.err.println("ENTRO en 1");
                                        for (int z = 0; z < this.JTCitas.getRowCount(); z++) {
                                            if (Boolean.valueOf(this.xmodelo.getValueAt(z, 4).toString()).booleanValue()) {
                                                String sql = "update c_citas set Id_Profesional='" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "', Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', Id_Consultorio='" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "', Id_Sede='" + this.xIdSEdeD[this.JCBSedeDestino.getSelectedIndex()] + "', Fecha_Cita='" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "' where id='" + this.xmodelo.getValueAt(z, 0) + "'";
                                                System.out.println("insercion-->" + sql);
                                                this.xconsulta.ejecutarSQL(sql);
                                                this.xconsulta.cerrarConexionBd();
                                            }
                                        }
                                    } else if (this.JRBMoverAgendaCitas.isSelected()) {
                                        System.err.println("ENTRO en 2");
                                        for (int z2 = 0; z2 < this.JTAgenda.getRowCount(); z2++) {
                                            if (Boolean.valueOf(this.xmodeloAgenda.getValueAt(z2, 8).toString()).booleanValue()) {
                                                String sql2 = "UPDATE c_confcitas \n     SET \n    c_confcitas.`Id_Profesional`= '" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "',\n    `Id_Especialidad` ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', \n    `Id_Consultorio` ='" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "',\n    `IdSede` ='" + this.xIdSEdeD[this.JCBSedeDestino.getSelectedIndex()] + "',\n    `Fecha_ConfCitas` ='" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "'\n    WHERE c_confcitas.`Id`='" + this.xmodeloAgenda.getValueAt(z2, 0) + "'";
                                                System.out.println("insercion-->" + sql2);
                                                this.xconsulta.ejecutarSQL(sql2);
                                                this.xconsulta.cerrarConexionBd();
                                            }
                                        }
                                        for (int z3 = 0; z3 < this.JTCitas.getRowCount(); z3++) {
                                            if (Boolean.valueOf(this.xmodelo.getValueAt(z3, 4).toString()).booleanValue()) {
                                                String sql3 = "update c_citas set Id_Profesional='" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "', Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', Id_Consultorio='" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "', Fecha_Cita='" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "' where id='" + this.xmodelo.getValueAt(z3, 0) + "'";
                                                System.out.println("insercion-->" + sql3);
                                                this.xconsulta.ejecutarSQL(sql3);
                                                this.xconsulta.cerrarConexionBd();
                                            }
                                        }
                                    } else if (this.JRBCopiar.isSelected()) {
                                        System.err.println("ENTRO en 3");
                                        for (int z4 = 0; z4 < this.JTCitas.getRowCount(); z4++) {
                                            if (Boolean.valueOf(this.xmodelo.getValueAt(z4, 4).toString()).booleanValue()) {
                                                String sql4 = "INSERT INTO  c_citas(Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, HoraFinal, Telefonica, Remitida, PrimerVez, Exclusion, DetalleExclusion, Asistida, Id_ingreso, Id_Consultorio, Fecha, UsuarioS,Id_Sede)  SELECT '" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "', '" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', Id_Usuario, Id_EmpresaCont, Id_ClaseCita,'" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "', HoraInicial, HoraFinal, Telefonica, Remitida, PrimerVez, Exclusion, DetalleExclusion,0,0, '" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "', '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "', '" + this.xIdSEdeD[this.JCBSedeDestino.getSelectedIndex()] + "' FROM c_citas WHERE (Id ='" + this.xmodelo.getValueAt(z4, 0) + "' AND `Id_MotivoDesistida`=1) ";
                                                System.out.println("insercion-->" + sql4);
                                                this.xconsulta.ejecutarSQL(sql4);
                                                this.xconsulta.cerrarConexionBd();
                                            }
                                        }
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Proceso Finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    mCargarDatosAgenda();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el consultorio de destino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBConsultorioD.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el profesional de destino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBProfesionalD.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el consultorio de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConsultorioO.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar el profesional de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProfesionalO.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    private Boolean validarProgramacion() {
        Boolean bol = false;
        if (this.JRBMoverCitas.isSelected() || this.JRBCopiar.isSelected()) {
            bol = validarCitas();
        } else {
            if (this.JTAgenda.getRowCount() > 0) {
                bol = true;
                int z = 0;
                while (z < this.JTAgenda.getRowCount()) {
                    if (this.xmodeloAgenda.getValueAt(z, 6).equals("General") && Boolean.valueOf(this.xmodeloAgenda.getValueAt(z, 8).toString()).booleanValue()) {
                        JOptionPane.showInternalMessageDialog(this, "No se puede mover una agenda Tipo 'General' \n", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        bol = false;
                        z = this.JTAgenda.getRowCount();
                    } else if (Boolean.valueOf(this.xmodeloAgenda.getValueAt(z, 8).toString()).booleanValue()) {
                        String sql = "SELECT\n    CONCAT (DATE_FORMAT(cd.HoraInicial,'%H:%i'),' - ',DATE_FORMAT(cd.HoraFinal,'%H:%i')) AS Hora\nFROM\n    c_confcitas cd\n    INNER JOIN c_confcitas co ON co.Id = '" + this.xmodeloAgenda.getValueAt(z, 0) + "'\n\nWHERE (cd.Id_Profesional = '" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "'\n    AND cd.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'\n    AND cd.Fecha_confCitas ='" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "'\n    AND cd.Estado =0\n    AND (cd.HoraInicial BETWEEN co.HoraInicial AND co.HoraFinal\n    OR cd.HoraFinal BETWEEN co.HoraInicial AND co.HoraFinal\n    OR co.HoraInicial BETWEEN cd.HoraInicial AND cd.HoraFinal\n    OR co.HoraFinal BETWEEN cd.HoraInicial AND cd.HoraFinal)    AND cd.HoraInicial <> co.HoraFinal \n    AND co.HoraInicial <> cd.HoraFinal)";
                        this.xconsulta.traerDato(sql);
                        int rowD = 0;
                        String v = "";
                        try {
                            ResultSet rsdato = this.xconsulta.getResultSet(sql);
                            while (rsdato.next()) {
                                rowD++;
                                v = rsdato.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                        this.xconsulta.cerrarConexionBd();
                        if (!v.isEmpty()) {
                            bol = false;
                            JOptionPane.showInternalMessageDialog(this, "Este profecional ya tiene agenda creada\n" + this.JCBProfesionalD.getSelectedItem() + "\nFecha: " + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "\nHora: " + v, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    }
                    z++;
                }
            }
            if (bol.booleanValue()) {
                bol = validarCitas();
            }
        }
        return bol;
    }

    private Boolean validarCitas() {
        Boolean bol = true;
        String citas = "";
        for (int z = 0; z < this.JTCitas.getRowCount(); z++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(z, 4).toString()).booleanValue()) {
                String sql = "SELECT\n  CONCAT(\n    DATE_FORMAT(cd.HoraInicial, '%H:%i'),\n    ' - ',\n    DATE_FORMAT(cd.HoraFinal, '%H:%i')\n  ) AS Hora\nFROM\n  `c_citas` cd\n  INNER JOIN `c_citas` co\n    ON co.Id = '" + this.xmodelo.getValueAt(z, 0).toString() + "'\nWHERE  (\n    cd.Id_Profesional = '" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "'\n    AND cd.Id_Especialidad = '" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'\n    AND cd.Fecha_Cita = '" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "'\n    AND (\n      cd.HoraInicial BETWEEN co.HoraInicial\n      AND co.HoraFinal\n      OR cd.HoraFinal BETWEEN co.HoraInicial\n      AND co.HoraFinal\n      OR co.HoraInicial BETWEEN cd.HoraInicial\n      AND cd.HoraFinal\n      OR co.HoraFinal BETWEEN cd.HoraInicial\n      AND cd.HoraFinal\n    )\n    AND cd.HoraInicial <> co.HoraFinal\n    AND co.HoraInicial <> cd.HoraFinal\n  );";
                int rowD = 0;
                String v = "";
                try {
                    ResultSet rsdato = this.xconsulta.getResultSet(sql);
                    while (rsdato.next()) {
                        rowD++;
                        v = rsdato.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                this.xconsulta.cerrarConexionBd();
                if (!v.isEmpty()) {
                    bol = false;
                    citas = citas + "Hora: " + v + "\n";
                }
            }
        }
        if (!bol.booleanValue()) {
            JOptionPane.showInternalMessageDialog(this, "Este profecional ya tiene Citas en estas horas\n" + this.JCBProfesionalD.getSelectedItem() + "\nFecha: " + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "\n" + citas, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        return bol;
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBProfesionalO.removeAllItems();
        this.JCBProfesionalD.removeAllItems();
        mIniciarComponentes();
    }

    private boolean mVerificarAgendaDestino() {
        boolean xresultado = false;
        String sql = "SELECT Id FROM  c_confcitas WHERE (Id_Profesional ='" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "' AND `Id_Consultorio` ='" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "' AND Estado =0 AND Fecha_ConfCitas ='" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "') ";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xresultado = true;
            } else {
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql2 = "INSERT INTO c_confcitas( `Id_Profesional`, `Id_Especialidad`, `Id_Consultorio`, `TipoAgenda`, `DiaSemana`, `Fecha_ConfCitas`, `HoraInicial`, `HoraFinal`, `Cupo`, `AgendaGralUltConf`, `EsAdicional`, Id_Consultorio, `Estado`, `Fecha`, `UsuarioS`) SELECT '" + this.xidprofesionald[this.JCBProfesionalD.getSelectedIndex()] + "', `Id_Especialidad`, `Id_Consultorio`, `TipoAgenda`, `DiaSemana`,'" + this.xmetodos.formatoAMD.format(this.JDCFechaD.getDate()) + "', `HoraInicial`, `HoraFinal`, `Cupo`, `AgendaGralUltConf`, `EsAdicional`,'" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "', `Estado`, '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "' FROM `c_confcitas` WHERE (`Id_Profesional` ='" + this.xidprofesionalo[this.JCBProfesionalO.getSelectedIndex()] + "' AND `Id_Consultorio` ='" + this.xIdConsultorioD[this.JCBConsultorioD.getSelectedIndex()] + "' AND `Fecha_ConfCitas` ='" + this.xmetodos.formatoAMD.format(this.JDCFechaO.getDate()) + "' AND `Estado` =0) ";
                xct.ejecutarSQL(sql2);
                xct.cerrarConexionBd();
                xresultado = true;
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xresultado;
    }
}
