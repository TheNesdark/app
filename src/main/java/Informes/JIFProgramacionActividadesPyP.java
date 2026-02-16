package Informes;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFProgramacionActividadesPyP.class */
public class JIFProgramacionActividadesPyP extends JInternalFrame {
    private Object[] dato;
    private DefaultTableModel xmodelodatos;
    private String[] xidactividad;
    private String[] xidprofesional;
    private boolean xestadof = false;
    private boolean xestadoact = false;
    private int xestado = 1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private JComboBox JCBActividad;
    private JCheckBox JCBEstado;
    private JComboBox JCBProfesional;
    public JDateChooser JDCFecha;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    public JFormattedTextField JTFFHora;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JLabel txtTitulo;

    public JIFProgramacionActividadesPyP() {
        initComponents();
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        mLlenarCombobox();
        mCrearTabla();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txtTitulo = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBEstado = new JCheckBox();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBActividad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROGRAMACION DE ACTIVIDADES EDUCATIVAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifprogactividadespyp");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("jpprogactividades");
        this.txtTitulo.setBackground((Color) null);
        this.txtTitulo.setFont(new Font("Arial", 1, 14));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("PROGRAMACION DE ACTIVIDADES EDUCATIVAS");
        this.txtTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.txtTitulo.setOpaque(true);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Informes.JIFProgramacionActividadesPyP.1
            public void mouseClicked(MouseEvent evt) {
                JIFProgramacionActividadesPyP.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JCBEstado.setSelected(true);
        this.JCBEstado.setText("Estado");
        this.JCBEstado.addActionListener(new ActionListener() { // from class: Informes.JIFProgramacionActividadesPyP.2
            public void actionPerformed(ActionEvent evt) {
                JIFProgramacionActividadesPyP.this.JCBEstadoActionPerformed(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.addKeyListener(new KeyAdapter() { // from class: Informes.JIFProgramacionActividadesPyP.3
            public void keyPressed(KeyEvent evt) {
                JIFProgramacionActividadesPyP.this.JTFFHoraKeyPressed(evt);
            }
        });
        this.JCBActividad.setFont(new Font("Arial", 1, 12));
        this.JCBActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBActividad.addItemListener(new ItemListener() { // from class: Informes.JIFProgramacionActividadesPyP.4
            public void itemStateChanged(ItemEvent evt) {
                JIFProgramacionActividadesPyP.this.JCBActividadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.addItemListener(new ItemListener() { // from class: Informes.JIFProgramacionActividadesPyP.5
            public void itemStateChanged(ItemEvent evt) {
                JIFProgramacionActividadesPyP.this.JCBProfesionalItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 945, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBProfesional, 0, 844, 32767).addGap(18, 18, 18).addComponent(this.JCBEstado, -2, 83, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBActividad, 0, 678, 32767)).addComponent(this.txtTitulo, GroupLayout.Alignment.LEADING, -1, 945, 32767).addComponent(this.jSeparator1, -1, 945, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtTitulo, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFecha, -2, 61, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 49, -2).addComponent(this.JCBActividad, -2, -1, -2))).addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEstado).addComponent(this.JCBProfesional, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 390, -2).addGap(20, 20, 20)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 989, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 691, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(60, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            GregorianCalendar xhoys = new GregorianCalendar();
            int dia = Integer.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().substring(0, 2)).intValue();
            int mes = Integer.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().substring(3, 5)).intValue() - 1;
            int ano = Integer.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().substring(6, 10)).intValue();
            xhoys.set(ano, mes, dia);
            this.JCBActividad.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            this.JCBProfesional.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            this.JTFFHora.setValue(Time.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString()));
            this.JDCFecha.setDate(xhoys.getTime());
            if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString().equals("true")) {
                this.JCBEstado.setSelected(true);
            } else {
                this.JCBEstado.setSelected(false);
            }
            this.xestadoact = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstadoActionPerformed(ActionEvent evt) {
        if (this.JCBEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActividadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalItemStateChanged(ItemEvent evt) {
    }

    private void mCrearTabla() {
        this.xmodelodatos = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Fecha", "Hora", "Profesional", "Estado"}) { // from class: Informes.JIFProgramacionActividadesPyP.6
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodelodatos);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(430);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(430);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(430);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.JTBDetalle.getColumnModel().getColumn(2).setMinWidth(90);
        this.JTBDetalle.getColumnModel().getColumn(2).setMaxWidth(90);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(70);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(70);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(220);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            ResultSet rs = this.xconsultas.traerRs("SELECT p_planeacionactividades.Id, p_actividades.Nbre, DATE_FORMAT(p_planeacionactividades.Fecha_Actividad, '%d/%m/%Y') AS FechaAct, p_planeacionactividades.Hora_Actividad, profesional.NProfesional, p_planeacionactividades.Estado  FROM baseserver.p_planeacionactividades INNER JOIN baseserver.p_actividades  ON (p_planeacionactividades.Id_PActividad = p_actividades.Id) INNER JOIN baseserver.profesional  ON (p_planeacionactividades.Id_Profesional = profesional.Id_Persona)ORDER BY p_planeacionactividades.Fecha_Actividad ASC, p_planeacionactividades.Hora_Actividad ASC, p_actividades.Nbre ASC ");
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelodatos.addRow(this.dato);
                    this.xmodelodatos.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelodatos.setValueAt(rs.getString(2), i, 1);
                    this.xmodelodatos.setValueAt(rs.getString(3), i, 2);
                    this.xmodelodatos.setValueAt(rs.getString(4), i, 3);
                    this.xmodelodatos.setValueAt(rs.getString(5), i, 4);
                    this.xmodelodatos.setValueAt(Boolean.valueOf(rs.getBoolean(6)), i, 5);
                    i++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFProgramacionActividadesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (this.JCBActividad.getSelectedIndex() != -1) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (!this.JTFFHora.getText().isEmpty()) {
                    if (!this.xestadof) {
                        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 2);
                        if (n == 0) {
                            if (!this.xestadoact) {
                                String sql = "insert into baseserver.p_planeacionactividades (Id_PActividad, Fecha_Actividad, Hora_Actividad, Id_Profesional, Estado, Fecha, UsuarioS)  values('" + this.xidactividad[this.JCBActividad.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsultas.ejecutarSQL(sql);
                                this.xconsultas.cerrarConexionBd();
                                mCrearTabla();
                                mCargarDatosTabla();
                                this.xestadof = true;
                                nuevo();
                                return;
                            }
                            if (this.JTBDetalle.getSelectedRow() != -1) {
                                String sql2 = "update  baseserver.p_planeacionactividades set Id_PActividad='" + this.xidactividad[this.JCBActividad.getSelectedIndex()] + "', Fecha_Actividad='" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "', Hora_Actividad='" + this.JTFFHora.getText() + "', Id_Profesional='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where id='" + this.xmodelodatos.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                                this.xconsultas.ejecutarSQL(sql2);
                                this.xconsultas.cerrarConexionBd();
                                mCrearTabla();
                                mCargarDatosTabla();
                                this.xestadof = true;
                                nuevo();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe seleccionar el registro a modificar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "La hora no puede se nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFHora.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBProfesional.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una actividad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBActividad.requestFocus();
    }

    public void nuevo() {
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        mLlenarCombobox();
        this.xestadof = false;
        this.xestadoact = false;
        this.xestado = 0;
        this.JDCFecha.requestFocus();
    }

    private void mLlenarCombobox() {
        this.xidactividad = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM baseserver.p_actividades WHERE (Estado =1) ORDER BY Nbre ASC", this.xidactividad, this.JCBActividad);
        this.JCBActividad.setSelectedItem(-1);
        this.xidprofesional = this.xconsultas.llenarCombo("SELECT Id_Persona, NProfesional FROM baseserver.profesional ORDER BY NProfesional ASC", this.xidprofesional, this.JCBProfesional);
        this.JCBProfesional.setSelectedItem(-1);
        this.xconsultas.cerrarConexionBd();
    }
}
