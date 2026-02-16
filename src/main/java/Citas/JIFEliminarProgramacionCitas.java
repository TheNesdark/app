package Citas;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/JIFEliminarProgramacionCitas.class */
public class JIFEliminarProgramacionCitas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidespecialidad;
    private String[] xidprofesionalo;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JDateChooser JDCFecha;
    private JPanel JPIDatosI;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFEliminarProgramacionCitas() {
        initComponents();
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosI = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JDCFecha = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("ANULAR PROGRAMACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifeliminarprogramacioncitas");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatosI.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE CITAS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)), "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Citas.JIFEliminarProgramacionCitas.1
            public void itemStateChanged(ItemEvent evt) {
                JIFEliminarProgramacionCitas.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.JIFEliminarProgramacionCitas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFEliminarProgramacionCitas.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.addItemListener(new ItemListener() { // from class: Citas.JIFEliminarProgramacionCitas.3
            public void itemStateChanged(ItemEvent evt) {
                JIFEliminarProgramacionCitas.this.JCBProfesionalItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosILayout = new GroupLayout(this.JPIDatosI);
        this.JPIDatosI.setLayout(JPIDatosILayout);
        JPIDatosILayout.setHorizontalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEspecialidad, 0, 472, 32767)).addComponent(this.JCBProfesional, 0, 625, 32767)).addContainerGap()));
        JPIDatosILayout.setVerticalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addContainerGap(12, 32767).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFecha, -2, 56, -2).addComponent(this.JCBEspecialidad, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JCBProfesional, -2, -1, -2)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 659, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JSPDetalle, -2, 301, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProfesional.removeAllItems();
            String sql = "SELECT Id_Persona, NProfesional FROM baseserver.profesional1 WHERE (IdEspecialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND Estado =0) ORDER BY NProfesional ASC";
            this.xidprofesionalo = xct1.llenarCombo(sql, this.xidprofesionalo, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProfesional.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno1 && this.JCBProfesional.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    private void mIniciarComponentes() {
        this.xlleno = false;
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0 AND AsignarCita =1) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "", "Tipo Agenda", "Hora Inicial", "Hora Final", "Estado"}) { // from class: Citas.JIFEliminarProgramacionCitas.4
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT Id, TipoAgenda, if(TipoAgenda=1,'GENERAL',if(TipoAgenda=2, 'ESPECIAL','VACACIONES')) as TipoAgenda, HoraInicial, HoraFinal, Estado FROM baseserver.c_confcitas WHERE (Id_Profesional ='" + this.xidprofesionalo[this.JCBProfesional.getSelectedIndex()] + "' AND Fecha_ConfCitas ='" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "') ORDER BY HoraFinal ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEliminarProgramacionCitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        int x;
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (!mVerificarAgendaDestino()) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                                x = 0;
                            } else {
                                x = 1;
                            }
                            String sql = "update c_confcitas set Estado='" + x + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.txtNo.getText() + "' where id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            JOptionPane.showInternalMessageDialog(this, "Proceso Finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Existen usuarios para esta programación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila de la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBEspecialidad.removeAllItems();
        this.JCBProfesional.removeAllItems();
        mIniciarComponentes();
    }

    private boolean mVerificarAgendaDestino() {
        boolean xresultado = false;
        String sql = "SELECT Id FROM baseserver.c_citas WHERE (Fecha_Cita ='" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND Id_Profesional ='" + this.xidprofesionalo[this.JCBProfesional.getSelectedIndex()] + "'AND Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and Id_MotivoDesistida =1)";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xresultado = true;
            } else {
                xresultado = false;
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPasarProgramacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xresultado;
    }
}
