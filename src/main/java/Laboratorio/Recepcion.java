package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Recepcion.class */
public class Recepcion extends JInternalFrame {
    private Persona frmPersona;
    private DefaultTableModel modelo;
    private String sql;
    private Object[] fila;
    private int filaGrid;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    public JTextField txtFecha;
    public JTextField txtNoOrden;
    private JEditorPane txtObservaciones;
    private JTextField txtProfesional;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String id = "";

    public Recepcion() {
        initComponents();
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Recepcion.1
            public void mouseClicked(MouseEvent e) {
                Recepcion.this.filaGrid = Recepcion.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public void anular() {
        if (Principal.txtNo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Toma para Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("La Toma de Muestra ya se encuentra Anulada.");
        } else {
            Anular frm = new Anular(null, true, "Recepcion", 24);
            frm.setVisible(true);
        }
    }

    public void anularOrden(String razon) {
        this.sql = "UPDATE l_recepcion SET Estado ='" + razon + "' WHERE Id='" + this.id + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.marcarEstado(1);
        this.metodos.mostrarMensaje("Toma de Muestra Anulada");
    }

    public void buscar() {
        BuscarOrden frm = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "Recepcion");
        frm.setVisible(true);
    }

    public void buscarOrden() {
        String idPaciente = "0";
        crearGrid();
        this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id, f_ordenes.FechaOrden, profesional.NProfesional, ingreso.Id_Usuario FROM f_itemordenesproced INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN profesional ON (profesional.Id_Persona = f_ordenes.Id_Profesional) INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) WHERE (f_ordenes.Id ='" + this.txtNoOrden.getText() + "' AND f_tipoprocedimiento.Id =6) ORDER BY g_procedimiento.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.fila);
                this.modelo.setValueAt(rs.getString("Id"), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString("Nbre"), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Cantidad"), this.filaGrid, 2);
                this.modelo.setValueAt(true, this.filaGrid, 3);
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaOrden")));
                this.txtProfesional.setText(rs.getString("NProfesional"));
                idPaciente = rs.getString("Id_Usuario");
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        this.frmPersona.setIdPersona(idPaciente);
        this.frmPersona.buscar(1);
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad", "Realizar"}) { // from class: Laboratorio.Recepcion.2
            Class[] types = {String.class, String.class, Integer.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(750);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(750);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(750);
        this.grid.getColumnModel().getColumn(2).setMinWidth(80);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(3).setMinWidth(80);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(80);
        this.filaGrid = 0;
    }

    public void desplazar(int boton) {
        if (boton == 6) {
            this.sql = "SELECT MIN(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.txtNoOrden.setText(this.id);
        } else if (boton == 7) {
            if (this.id != null && Integer.parseInt(this.id) > 1) {
                this.id = String.valueOf(Integer.parseInt(this.id) - 1);
                this.txtNoOrden.setText(this.id);
            }
        } else if (boton == 8) {
            if (this.id != null) {
                this.id = String.valueOf(Integer.parseInt(this.id) + 1);
                this.txtNoOrden.setText(this.id);
            }
        } else if (boton == 9) {
            this.sql = "SELECT MAX(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.txtNoOrden.setText(this.id);
        }
        buscarOrden();
    }

    private void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar El Examen?") == 0) {
            this.modelo.removeRow(this.filaGrid);
        }
    }

    public void grabar() {
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
            this.frmPersona.grabar();
            grabarCabecera();
            grabarDetalle();
            if (this.metodos.getPregunta("Registro Grabado, desea Imprimir los Sticker?") == 0) {
                this.metodos.mostrarMensaje("Opcion Pendiente");
            }
        }
    }

    private void grabarCabecera() {
        this.sql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_OrdenFacturac, Observaciones, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.id = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.id);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0 && this.modelo.getValueAt(f, 3).equals(true)) {
                this.sql = "INSERT INTO l_detallerecepcion(Id_Recepcion, Id_Procedim, fechaMuestra,Cantidad) VALUES('" + this.id + "','" + this.modelo.getValueAt(f, 0) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.modelo.getValueAt(f, 2) + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    public void imprimir() {
    }

    private void iniciar() {
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.frmPersona.txtHistoria.requestFocus();
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        this.txtNoOrden.setText("");
        this.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
        this.txtProfesional.setText("");
        this.txtObservaciones.setText("");
        this.id = "";
        crearGrid();
        this.frmPersona.txtHistoria.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtNoOrden.getText() == null || this.txtNoOrden.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
        } else if (this.txtFecha.getText() == null || this.txtProfesional.getText() == null || this.txtProfesional.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que contenga datos");
        } else if (this.grid.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtNoOrden = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.txtProfesional = new JTextField();
        this.txtFecha = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAPTURA DE DATOS DE EXÁMENES DE LABORATORIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1212, 835));
        setMinimumSize(new Dimension(1212, 835));
        setName("Recepcion");
        setPreferredSize(new Dimension(1212, 835));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.Recepcion.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                Recepcion.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout((LayoutManager) null);
        this.panelPersona.setBorder(BorderFactory.createBevelBorder(0));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        this.panelPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 996, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 166, 32767));
        this.jPanel5.add(this.panelPersona);
        this.panelPersona.setBounds(10, 10, 990, 170);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA ORDEN", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Número de Orden / Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: Laboratorio.Recepcion.4
            public void actionPerformed(ActionEvent evt) {
                Recepcion.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: Laboratorio.Recepcion.5
            public void focusLost(FocusEvent evt) {
                Recepcion.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtNoOrden, new AbsoluteConstraints(20, 30, 190, 50));
        this.txtObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(402, 20, 580, 120));
        this.txtProfesional.setBackground((Color) null);
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setForeground(new Color(0, 0, 204));
        this.txtProfesional.setHorizontalAlignment(0);
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProfesional.setEnabled(false);
        this.jPanel1.add(this.txtProfesional, new AbsoluteConstraints(20, 90, 360, 50));
        this.txtFecha.setBackground((Color) null);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDisabledTextColor(new Color(0, 0, 0));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setMinimumSize(new Dimension(30, 54));
        this.txtFecha.setPreferredSize(new Dimension(30, 54));
        this.txtFecha.addActionListener(new ActionListener() { // from class: Laboratorio.Recepcion.6
            public void actionPerformed(ActionEvent evt) {
                Recepcion.this.txtFechaActionPerformed(evt);
            }
        });
        this.txtFecha.addFocusListener(new FocusAdapter() { // from class: Laboratorio.Recepcion.7
            public void focusLost(FocusEvent evt) {
                Recepcion.this.txtFechaFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtFecha, new AbsoluteConstraints(220, 30, 160, 50));
        this.jPanel5.add(this.jPanel1);
        this.jPanel1.setBounds(10, 190, 990, 150);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Recepcion.8
            public void keyPressed(KeyEvent evt) {
                Recepcion.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid);
        this.jPanel5.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 350, 990, 300);
        getContentPane().add(this.jPanel5);
        this.jPanel5.setBounds(0, 0, 1020, 670);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenFocusLost(FocusEvent evt) {
        this.id = this.txtNoOrden.getText();
        buscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenActionPerformed(ActionEvent evt) {
        this.txtFecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFocusLost(FocusEvent evt) {
    }
}
