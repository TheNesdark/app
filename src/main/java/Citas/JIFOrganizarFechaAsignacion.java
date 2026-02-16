package Citas;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/JIFOrganizarFechaAsignacion.class */
public class JIFOrganizarFechaAsignacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    public static String[][] xidEmpresa;
    public static String[][] xidConvenio;
    public static String[][] xidespecialidad;
    private String xsql;
    private Object[] xdato;
    private JButton JBTExportar;
    public static JComboBox JCBConvenio;
    public static JComboBox JCBEmpresa;
    public static JComboBox JCBEspecialidad;
    private JCheckBox JCHConvenio;
    private JCheckBox JCHEmpresa;
    private JCheckBox JCHEspecialidad;
    public static JCheckBox JCHTodos;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPIDatosB;
    private JScrollPane JSPDetalleC;
    private JTable JTDetalleC;
    private JFormattedTextField JTFFPDias;
    private JFormattedTextField JTFFSDias;
    private JFormattedTextField JTFFTCitas;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFOrganizarFechaAsignacion() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatosB = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        JCBEspecialidad = new JComboBox();
        this.JTFFSDias = new JFormattedTextField();
        this.JTFFPDias = new JFormattedTextField();
        this.JTFFTCitas = new JFormattedTextField();
        JCBEmpresa = new JComboBox();
        JCHTodos = new JCheckBox();
        JCBConvenio = new JComboBox();
        this.JCHConvenio = new JCheckBox();
        this.JCHEspecialidad = new JCheckBox();
        this.JCHEmpresa = new JCheckBox();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR OPORTUNIDAD CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifreorganizardiaasignacioncitas");
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO DE BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFOrganizarFechaAsignacion.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFOrganizarFechaAsignacion.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFOrganizarFechaAsignacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFOrganizarFechaAsignacion.this.JDFFechaFPropertyChange(evt);
            }
        });
        JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Sumatoria N° Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSDias.setHorizontalAlignment(4);
        this.JTFFSDias.setFont(new Font("Arial", 1, 12));
        this.JTFFPDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPDias.setHorizontalAlignment(4);
        this.JTFFPDias.setFont(new Font("Arial", 1, 12));
        this.JTFFTCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Citas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTCitas.setHorizontalAlignment(4);
        this.JTFFTCitas.setFont(new Font("Arial", 1, 12));
        JCBEmpresa.setFont(new Font("Arial", 1, 12));
        JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBEmpresa.addItemListener(new ItemListener() { // from class: Citas.JIFOrganizarFechaAsignacion.3
            public void itemStateChanged(ItemEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        JCBEmpresa.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFOrganizarFechaAsignacion.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCBEmpresaPropertyChange(evt);
            }
        });
        JCHTodos.setFont(new Font("Arial", 1, 12));
        JCHTodos.setSelected(true);
        JCHTodos.setText("Todas");
        JCHTodos.addActionListener(new ActionListener() { // from class: Citas.JIFOrganizarFechaAsignacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCHTodosActionPerformed(evt);
            }
        });
        JCBConvenio.setFont(new Font("Arial", 1, 12));
        JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBConvenio.addItemListener(new ItemListener() { // from class: Citas.JIFOrganizarFechaAsignacion.6
            public void itemStateChanged(ItemEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCBConvenioItemStateChanged(evt);
            }
        });
        JCBConvenio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFOrganizarFechaAsignacion.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCBConvenioPropertyChange(evt);
            }
        });
        this.JCHConvenio.setFont(new Font("Arial", 1, 12));
        this.JCHConvenio.setText("Convenio");
        this.JCHConvenio.addActionListener(new ActionListener() { // from class: Citas.JIFOrganizarFechaAsignacion.8
            public void actionPerformed(ActionEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCHConvenioActionPerformed(evt);
            }
        });
        this.JCHEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCHEspecialidad.setText("Especialidad");
        this.JCHEspecialidad.addActionListener(new ActionListener() { // from class: Citas.JIFOrganizarFechaAsignacion.9
            public void actionPerformed(ActionEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCHEspecialidadActionPerformed(evt);
            }
        });
        this.JCHEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCHEmpresa.setText("Empresa");
        this.JCHEmpresa.addActionListener(new ActionListener() { // from class: Citas.JIFOrganizarFechaAsignacion.10
            public void actionPerformed(ActionEvent evt) {
                JIFOrganizarFechaAsignacion.this.JCHEmpresaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCHTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEmpresa).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHConvenio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEspecialidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSDias, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTCitas, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPDias, -2, 132, -2)).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(JCBEmpresa, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCBConvenio, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCBEspecialidad, -2, 351, -2))).addGap(10, 10, 10)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2))).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSDias, -2, 50, -2).addComponent(this.JTFFTCitas, -2, 50, -2).addComponent(this.JTFFPDias, -2, 50, -2).addComponent(this.JCHEmpresa).addComponent(JCHTodos).addComponent(this.JCHConvenio).addComponent(this.JCHEspecialidad)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JCBEmpresa, -2, 50, -2).addComponent(JCBConvenio, -2, 50, -2).addComponent(JCBEspecialidad, -2, 50, -2)).addContainerGap(10, 32767)));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(1);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JTDetalleC.addKeyListener(new KeyAdapter() { // from class: Citas.JIFOrganizarFechaAsignacion.11
            public void keyReleased(KeyEvent evt) {
                JIFOrganizarFechaAsignacion.this.JTDetalleCKeyReleased(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Citas.JIFOrganizarFechaAsignacion.12
            public void mouseClicked(MouseEvent evt) {
                JIFOrganizarFechaAsignacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Citas.JIFOrganizarFechaAsignacion.13
            public void actionPerformed(ActionEvent evt) {
                JIFOrganizarFechaAsignacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleC).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 145, -2)).addComponent(this.JPIDatosB, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleC, -1, 365, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            controlCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            controlCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JTDetalleC.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "UPDATE c_citas SET Fecha=STR_TO_DATE('" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 7).toString().substring(0, 2) + "," + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 7).toString().substring(3, 5) + "," + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 7).toString().substring(6, 10) + "', '%d,%m,%Y')  WHERE Id='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mLlenarDetalle();
            }
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleC.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleC, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodosActionPerformed(ActionEvent evt) {
        controlCheck();
        mLlenarDetalle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConvenioActionPerformed(ActionEvent evt) {
        controlCheck();
        mLlenarCombos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialidadActionPerformed(ActionEvent evt) {
        controlCheck();
        mLlenarCombos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmpresaActionPerformed(ActionEvent evt) {
        controlCheck();
        mLlenarCombos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCHConvenio.isSelected() && this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1 && this.xlleno) {
            mllenarComboConvenio();
        } else if (this.JCHEspecialidad.isSelected() && this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1 && this.xlleno) {
            mllenarComboEspecialidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioItemStateChanged(ItemEvent evt) {
        mllenarComboEspecialidad();
    }

    private void controlCheck() {
        if (JCHTodos.isSelected()) {
            this.JCHEmpresa.setSelected(false);
            JCBEmpresa.setEnabled(false);
            this.JCHConvenio.setSelected(false);
            JCBConvenio.setEnabled(false);
            this.JCHEspecialidad.setSelected(false);
            JCBEspecialidad.setEnabled(false);
        } else {
            JCHTodos.setSelected(false);
            if (this.JCHEmpresa.isSelected()) {
                JCBEmpresa.setEnabled(true);
            } else {
                JCBEmpresa.setEnabled(false);
            }
            if (this.JCHConvenio.isSelected()) {
                JCBConvenio.setEnabled(true);
            } else {
                JCBConvenio.setEnabled(false);
            }
            if (this.JCHEspecialidad.isSelected()) {
                JCBEspecialidad.setEnabled(true);
            } else {
                JCBEspecialidad.setEnabled(false);
            }
        }
        mLlenarCombos();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "Tipo Documento", "Documento", "Usuario", "Teléfono", "Fecha Cita", "Fecha Asignación", "DDías", "Eps", "Clase Cita", "Especialidad", "Profesional", "Nit", "Ips", "FSolicitudU", "FAsignación", "Edad", "Tipo", "Sede", "Parentezco", "FechaNac"}) { // from class: Citas.JIFOrganizarFechaAsignacion.14
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(21).setPreferredWidth(100);
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        JCHTodos.setSelected(true);
        controlCheck();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLlenarCombos();
        mLlenarDetalle();
    }

    private void mllenarComboEmpresa() {
        JCBEmpresa.removeAllItems();
        if (this.JCHEmpresa.isSelected()) {
            this.xsql = "SELECT cc_terceros.`Id`, cc_terceros.`RazonSocialCompleta`, 0\nFROM c_citas \nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id`=`c_citas`.`Id_EmpresaCont`)\nINNER JOIN cc_terceros ON (cc_terceros.`Id`=f_empresacontxconvenio.`Id_EmpresaCont`)\nWHERE (c_citas.Id_MotivoDesistida =1 AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') \nGROUP BY cc_terceros.`Id`\nORDER BY cc_terceros.`RazonSocialCompleta` ASC";
            xidEmpresa = this.xct.llenarComboyLista(this.xsql, xidEmpresa, JCBEmpresa, 3);
            JCBEmpresa.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    private void mllenarComboConvenio() {
        JCBConvenio.removeAllItems();
        if (this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1 && this.JCHConvenio.isSelected()) {
            this.xsql = "SELECT `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre`, 0 FROM `c_citas` INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1 AND f_empresacontxconvenio.Id_EmpresaCont=" + xidEmpresa[JCBEmpresa.getSelectedIndex()][0] + " AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC;";
            xidConvenio = this.xct.llenarComboyLista(this.xsql, xidConvenio, JCBConvenio, 3);
            JCBConvenio.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            return;
        }
        if (this.JCHConvenio.isSelected()) {
            this.xsql = "SELECT `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre`, 0 FROM `c_citas` INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC;";
            xidConvenio = this.xct.llenarComboyLista(this.xsql, xidConvenio, JCBConvenio, 3);
            JCBConvenio.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    private void mllenarComboEspecialidad() {
        JCBEspecialidad.removeAllItems();
        if (this.JCHConvenio.isSelected() && JCBConvenio.getSelectedIndex() != -1 && this.JCHEspecialidad.isSelected()) {
            this.xsql = "SELECT profesional1.IdEspecialidad, profesional1.Especialidad, profesional1.DiasCitas FROM profesional1 INNER JOIN  c_citas  ON (profesional1.Id_Persona = c_citas.Id_Profesional) AND (profesional1.IdEspecialidad = c_citas.Id_Especialidad) WHERE (c_citas.Id_MotivoDesistida =1 AND `c_citas`.`Id_EmpresaCont`= " + xidConvenio[JCBConvenio.getSelectedIndex()][0] + " AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY profesional1.IdEspecialidad  ORDER BY profesional1.Especialidad ASC ";
            xidespecialidad = this.xct.llenarComboyLista(this.xsql, xidespecialidad, JCBEspecialidad, 3);
            JCBEspecialidad.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            return;
        }
        if (this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1 && this.JCHEspecialidad.isSelected()) {
            this.xsql = "SELECT profesional1.IdEspecialidad, profesional1.Especialidad, profesional1.DiasCitas FROM profesional1 INNER JOIN  c_citas  ON (profesional1.Id_Persona = c_citas.Id_Profesional) AND (profesional1.IdEspecialidad = c_citas.Id_Especialidad) INNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id`=`c_citas`.`Id_EmpresaCont`) WHERE (c_citas.Id_MotivoDesistida =1 AND f_empresacontxconvenio.Id_EmpresaCont=" + xidEmpresa[JCBEmpresa.getSelectedIndex()][0] + " AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY profesional1.IdEspecialidad  ORDER BY profesional1.Especialidad ASC ";
            xidespecialidad = this.xct.llenarComboyLista(this.xsql, xidespecialidad, JCBEspecialidad, 3);
            JCBEspecialidad.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            return;
        }
        if (this.JCHEspecialidad.isSelected()) {
            this.xsql = "SELECT profesional1.IdEspecialidad, profesional1.Especialidad, profesional1.DiasCitas FROM profesional1 INNER JOIN  c_citas  ON (profesional1.Id_Persona = c_citas.Id_Profesional) AND (profesional1.IdEspecialidad = c_citas.Id_Especialidad) WHERE (c_citas.Id_MotivoDesistida =1 AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY profesional1.IdEspecialidad  ORDER BY profesional1.Especialidad ASC ";
            xidespecialidad = this.xct.llenarComboyLista(this.xsql, xidespecialidad, JCBEspecialidad, 3);
            JCBEspecialidad.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    private void mLlenarCombos() {
        this.xlleno = false;
        if (!JCHTodos.isSelected()) {
            mllenarComboEmpresa();
            mllenarComboConvenio();
            mllenarComboEspecialidad();
        }
        this.xlleno = true;
        mCrearTablaDetalle();
    }

    private void mLlenarDetalle() {
        this.JTFFPDias.setValue(new Integer(0));
        this.JTFFSDias.setValue(new Integer(0));
        this.JTFFTCitas.setValue(new Integer(0));
        mCrearTablaDetalle();
        this.xsql = "SELECT c_citas.Id, g_usuario.NoHistoria,g_persona.`Id_TipoIdentificacion`,g_persona.`NoDocumento`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, IF((`g_persona`.`Telefono` ='' AND `g_persona`.`Movil` =''), '', IF((`g_persona`.`Telefono` <>'' AND `g_persona`.`Movil`) ='', `g_persona`.`Telefono` ,IF((`g_persona`.`Telefono` ='' AND `g_persona`.`Movil` <>''), `g_persona`.`Movil`, CONCAT (`g_persona`.`Telefono` , ' - ', `g_persona`.`Movil`)))) AS `Telefono` , DATE_FORMAT(c_citas.Fecha_Cita,'%d-%m-%Y') AS FCita,DATE_FORMAT( c_citas.Fecha,'%d-%m-%Y') AS FAsignacion , \nDATEDIFF(c_citas.Fecha_Cita,c_citas.Fecha) AS DDiasCitas,f_empresacontxconvenio.`Nbre`, `c_clasecita`.`Nbre` AS ClaseCita, profesional1.Especialidad, profesional1.NProfesional, d_ips.`IdConcatenado`  , d_ips.`NEmpresa`,IF(DATE_FORMAT( c_citas.Fecha_SUsuario,'%d-%m-%Y') IS NULL,'',DATE_FORMAT( c_citas.Fecha_SUsuario,'%d-%m-%Y')) AS FSUsuario,IF(c_citas.`Telefonica`=0, 'PERSONAL',  IF(c_citas.`Telefonica`=1,'TELEFONICA',  IF(c_citas.`Telefonica`=2,'WEB','DEMANDA INDUCIDA'))) Fasignacion, `Devuelve_Edad_2F`(g_persona.`FechaNac`, c_citas.Fecha_Cita) Edad, `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, c_citas.Fecha_Cita) TEdad,\n`g_sedes`.`Nbre` AS Sede, g_parentesco.`Nbre` AS Parentezco, `g_persona`.`FechaNac` FROM `g_persona` INNER JOIN c_citas  ON (g_persona.Id = c_citas.Id_Usuario) INNER JOIN `g_usuario`  ON (g_persona.Id = g_usuario.`Id_persona`)  LEFT JOIN `g_usuario_fpz` ON (g_persona.Id = g_usuario_fpz.`Id_Persona`)\n LEFT JOIN  `g_parentesco` ON (g_usuario_fpz.`Id_Parentesco`=g_parentesco.`Id`) \nINNER JOIN `profesional1` ON (profesional1.Id_persona = c_citas.Id_Profesional)  AND (profesional1.IdEspecialidad = c_citas.Id_Especialidad) \nINNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id`= c_citas.`Id_EmpresaCont`)\nINNER JOIN `d_ips`  ON (d_ips.`Id`= f_empresacontxconvenio.`Id_GIps`) INNER JOIN `g_sedes`  ON (g_sedes.`Id`= c_citas.`Id_Sede`)  \nWHERE (c_citas.Id_MotivoDesistida =1 \n";
        if (this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1) {
            this.xsql += "AND f_empresacontxconvenio.Id_EmpresaCont ='" + xidEmpresa[JCBEmpresa.getSelectedIndex()][0] + "'\n";
        }
        if (this.JCHConvenio.isSelected() && JCBConvenio.getSelectedIndex() != -1) {
            this.xsql += "AND c_citas.Id_EmpresaCont ='" + xidConvenio[JCBConvenio.getSelectedIndex()][0] + "'\n";
        }
        if (this.JCHEspecialidad.isSelected() && JCBEspecialidad.getSelectedIndex() != -1) {
            this.xsql += "AND c_citas.Id_Especialidad ='" + xidespecialidad[JCBEspecialidad.getSelectedIndex()][0] + "'\n";
        }
        this.xsql += "AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') \nORDER BY c_citas.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) ASC";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalleC, 4);
                this.xmt.mEstablecerTextEditor(this.JTDetalleC, 9);
                this.xmt.mEstablecerTextEditor(this.JTDetalleC, 10);
                this.xmt.mEstablecerTextEditor(this.JTDetalleC, 12);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), xnfila, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), xnfila, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), xnfila, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), xnfila, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), xnfila, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), xnfila, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), xnfila, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), xnfila, 15);
                    this.xmodelo.setValueAt(xrs.getString("Fasignacion"), xnfila, 16);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Edad")), xnfila, 17);
                    this.xmodelo.setValueAt(xrs.getString("TEdad"), xnfila, 18);
                    this.xmodelo.setValueAt(xrs.getString("Sede"), xnfila, 19);
                    this.xmodelo.setValueAt(xrs.getString("Parentezco"), xnfila, 20);
                    this.xmodelo.setValueAt(xrs.getString("FechaNac"), xnfila, 21);
                    this.JTDetalleC.setDefaultRenderer(Object.class, new MiRender());
                    xnfila++;
                }
                this.xsql = "SELECT  SUM(DATEDIFF(c_citas.Fecha_Cita, c_citas.Fecha)) AS Numerador , COUNT(c_citas.Fecha_Cita) AS Denominador, ROUND((SUM(DATEDIFF(c_citas.Fecha_Cita, c_citas.Fecha))/COUNT(c_citas.Fecha_Cita))) AS Resultado FROM c_citas INNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id`=`c_citas`.`Id_EmpresaCont`) WHERE c_citas.Id_MotivoDesistida =1 AND c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' \n";
                if (this.JCHEmpresa.isSelected() && JCBEmpresa.getSelectedIndex() != -1) {
                    this.xsql += "AND f_empresacontxconvenio.Id_EmpresaCont ='" + xidEmpresa[JCBEmpresa.getSelectedIndex()][0] + "' ";
                }
                if (this.JCHConvenio.isSelected() && JCBConvenio.getSelectedIndex() != -1) {
                    this.xsql += "AND c_citas.Id_EmpresaCont ='" + xidConvenio[JCBConvenio.getSelectedIndex()][0] + "' ";
                }
                if (this.JCHEspecialidad.isSelected() && JCBEspecialidad.getSelectedIndex() != -1) {
                    this.xsql += "AND c_citas.Id_Especialidad ='" + xidespecialidad[JCBEspecialidad.getSelectedIndex()][0] + "' ";
                }
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet rs = xct1.traerRs(this.xsql);
                if (rs.next()) {
                    rs.first();
                    this.JTFFSDias.setValue(Long.valueOf(rs.getLong(1)));
                    this.JTFFTCitas.setValue(Long.valueOf(rs.getLong(2)));
                    this.JTFFPDias.setValue(Long.valueOf(rs.getLong(3)));
                }
                rs.close();
                xct1.cerrarConexionBd();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrganizarFechaAsignacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mLlenarDetalle();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/JIFOrganizarFechaAsignacion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Long xvalor = Long.valueOf(table.getValueAt(row, 8).toString());
            if (!JIFOrganizarFechaAsignacion.JCHTodos.isSelected() && JIFOrganizarFechaAsignacion.JCBEspecialidad.getSelectedIndex() != -1 && xvalor.longValue() > Long.valueOf(JIFOrganizarFechaAsignacion.xidespecialidad[JIFOrganizarFechaAsignacion.JCBEspecialidad.getSelectedIndex()][1]).longValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
