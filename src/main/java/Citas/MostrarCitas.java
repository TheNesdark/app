package Citas;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/MostrarCitas.class */
public class MostrarCitas extends JInternalFrame {
    DefaultTableModel modelo;
    private String[] listaProfesional;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    private JButton btnCerrar;
    private JButton btnMirar;
    private JComboBox cboProfesional;
    private JTable grid;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JDateChooser txtFecha;
    int cboLleno = 0;
    int filaGrid = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private GregorianCalendar fecha = new GregorianCalendar();
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    public MostrarCitas(String profesional) {
        initComponents();
        setLocation(1, 1);
        this.txtFecha.setDate(this.fecha.getTime());
        crearGrid();
        cargarCombos();
        this.cboProfesional.setSelectedItem(profesional);
        this.btnMirar.doClick();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.cboProfesional = new JComboBox();
        this.txtFecha = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnMirar = new JButton();
        this.btnCerrar = new JButton();
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE CITAS PROGRAMADAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(541, 574));
        setMinimumSize(new Dimension(541, 574));
        setName("MostrarCitas");
        setPreferredSize(new Dimension(541, 574));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout((LayoutManager) null);
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboProfesional);
        this.cboProfesional.setBounds(20, 25, 310, 43);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFecha);
        this.txtFecha.setBounds(350, 18, 140, 50);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 130, 470, 340);
        this.btnMirar.setFont(new Font("Arial", 1, 12));
        this.btnMirar.setText("Mirar Programación");
        this.btnMirar.addActionListener(new ActionListener() { // from class: Citas.MostrarCitas.1
            public void actionPerformed(ActionEvent evt) {
                MostrarCitas.this.btnMirarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnMirar);
        this.btnMirar.setBounds(20, 80, 470, 40);
        this.btnCerrar.setFont(new Font("Arial", 1, 12));
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Citas.MostrarCitas.2
            public void actionPerformed(ActionEvent evt) {
                MostrarCitas.this.btnCerrarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCerrar);
        this.btnCerrar.setBounds(20, 480, 470, 40);
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(10, 10, 510, 530);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMirarActionPerformed(ActionEvent evt) {
        buscarCitas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void buscarCitas() {
        String horaInicio;
        try {
            this.sql = "SELECT c_citasnp.HoraInicial, persona.NUsuario FROM baseserver.c_citasnp INNER JOIN baseserver.g_usuario ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN baseserver.persona  ON (g_usuario.Id_persona = persona.Id_persona) WHERE (c_citasnp.Id_Profesional = '" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "' AND c_citasnp.Fecha_Cita = '" + this.formatoFecha.format(this.txtFecha.getDate()) + "')";
            this.rs = this.consultas.traerRs(this.sql);
            crearGrid();
            this.rs.last();
            if (this.rs.getRow() > -1) {
                this.filaGrid = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    if (Integer.parseInt(this.rs.getString(1).substring(0, 2)) < 13) {
                        horaInicio = this.rs.getString(1).substring(0, 5) + " AM";
                    } else {
                        String horaInicio2 = String.valueOf(Integer.parseInt(this.rs.getString(1).substring(0, 2)) - 12);
                        if (horaInicio2.length() == 1) {
                            horaInicio2 = "0" + horaInicio2;
                        }
                        horaInicio = horaInicio2 + this.rs.getString(1).substring(2, 5) + " PM";
                    }
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(horaInicio, this.filaGrid, 0);
                    this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.filaGrid++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarCitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarCombos() {
        this.listaProfesional = this.consultas.llenarCombo("SELECT Id_Persona, NProfesional FROM baseserver.profesional ORDER BY NProfesional ASC", this.listaProfesional, this.cboProfesional);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Citas.MostrarCitas.3
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Hora");
        this.modelo.addColumn("Usuario");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
    }
}
