package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/TomaManual.class */
public class TomaManual extends JInternalFrame {
    private Persona frmPersona;
    private DefaultTableModel modelo;
    private String sql;
    private Object[] fila;
    private String[][] parametros;
    private int filaGrid;
    private String[] listaProfe;
    private String[] listaExamen;
    private JButton btnCargar;
    private JComboBox cboExamen;
    private JComboBox cboProfesional;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    private JSpinner txtCantidad;
    private JDateChooser txtFecha;
    private JEditorPane txtObservaciones;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String id = "";
    private int cboLleno = 0;

    public TomaManual() {
        initComponents();
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.TomaManual.1
            public void mouseClicked(MouseEvent e) {
                TomaManual.this.filaGrid = TomaManual.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public void anular() {
        if (Principal.txtNo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Toma para Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("La Toma de Muestra ya se encuentra Anulada.");
        } else {
            Anular frm = new Anular(null, true, "TomaManual", 24);
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
        if (this.frmPersona.txtHistoria.getText() != null && !this.frmPersona.txtHistoria.getText().equals("")) {
            BuscarOrden frm = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "TomaManual");
            frm.setVisible(true);
        } else {
            this.metodos.mostrarMensaje("Por favor seleccione el Usuario a quien se consultará");
        }
    }

    public void cargarOrden() {
        crearGrid();
        this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id, f_ordenes.FechaOrden, profesional.NProfesional, ingreso.Id_Usuario FROM f_itemordenesproced INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN profesional ON (profesional.Id_Persona = f_ordenes.Id_Profesional) INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) WHERE (f_ordenes.Id ='" + this.id + "' AND f_tipoprocedimiento.Id =6) ORDER BY g_procedimiento.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.fila);
                this.modelo.setValueAt(rs.getString("Id"), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString("Nbre"), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Cantidad"), this.filaGrid, 2);
                this.modelo.setValueAt(true, this.filaGrid, 3);
                this.txtFecha.setDate(rs.getDate("FechaOrden"));
                this.cboProfesional.setSelectedItem(rs.getString("NProfesional"));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargar() {
        if (this.cboExamen.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Examen");
            this.cboExamen.requestFocus();
            return;
        }
        int encontrado = 0;
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (this.modelo.getValueAt(f, 0).toString().equals(this.listaExamen[this.cboExamen.getSelectedIndex()])) {
                this.filaGrid = f;
                encontrado = 1;
            }
        }
        if (encontrado == 0) {
            this.modelo.addRow(this.fila);
        }
        this.modelo.setValueAt(this.listaExamen[this.cboExamen.getSelectedIndex()], this.filaGrid, 0);
        this.modelo.setValueAt(this.cboExamen.getSelectedItem(), this.filaGrid, 1);
        this.modelo.setValueAt(this.txtCantidad.getValue(), this.filaGrid, 2);
        this.filaGrid++;
    }

    private void cargarCombos() {
        this.listaProfe = this.consultas.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional ORDER BY NProfesional ASC", this.listaProfe, this.cboProfesional);
        this.listaExamen = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_procedimiento WHERE (Estado =0    AND Id_tipoprocedimiento =6) ORDER BY Nbre ASC", this.listaExamen, this.cboExamen);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
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
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad"}) { // from class: Laboratorio.TomaManual.2
            Class[] types = {String.class, String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(820);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(820);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(820);
        this.grid.getColumnModel().getColumn(2).setMinWidth(80);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(80);
        this.filaGrid = 0;
    }

    public void desplazar(int boton) {
        if (boton == 6) {
            this.sql = "SELECT MIN(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
        } else if (boton == 7) {
            if (this.id != null && Integer.parseInt(this.id) > 1) {
                this.id = String.valueOf(Integer.parseInt(this.id) - 1);
            }
        } else if (boton == 8) {
            if (this.id != null) {
                this.id = String.valueOf(Integer.parseInt(this.id) + 1);
            }
        } else if (boton == 9) {
            this.sql = "SELECT MAX(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
        }
        cargarOrden();
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
                imprimirSticker();
            }
        }
    }

    private void grabarCabecera() {
        this.sql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_OrdenFacturac, Observaciones, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','0','" + this.txtObservaciones.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.id = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.id);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0) {
                this.sql = "INSERT INTO l_detallerecepcion(Id_Recepcion, Id_Procedim, Cantidad) VALUES('" + this.id + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    public void imprimirSticker() {
        this.parametros = new String[5][2];
        this.parametros[0][0] = "noHistoria";
        this.parametros[0][1] = this.frmPersona.getHistoria();
        this.parametros[1][0] = "noRecep";
        this.parametros[1][1] = Principal.txtNo.getText();
        this.parametros[2][0] = "ruta";
        this.parametros[2][1] = this.metodos.getRutaRep();
        this.parametros[3][0] = "SUBREPORT_DIR";
        this.parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
        this.parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Sticker", this.parametros);
        this.consultas.cerrarConexionBd();
    }

    private void iniciar() {
        cargarCombos();
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        nuevo();
        this.frmPersona.txtHistoria.requestFocus();
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.cboProfesional.setSelectedIndex(-1);
        this.cboExamen.setSelectedIndex(-1);
        this.txtObservaciones.setText("");
        this.id = "";
        crearGrid();
        this.frmPersona.txtHistoria.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.frmPersona.txtHistoria.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Usuario");
            this.frmPersona.txtHistoria.requestFocus();
        } else if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que tenga Datos");
            this.txtFecha.requestFocus();
        } else if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que tenga Datos");
            this.cboProfesional.requestFocus();
        } else if (this.grid.getRowCount() < 1) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
            this.cboExamen.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtFecha = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.cboExamen = new JComboBox();
        this.cboProfesional = new JComboBox();
        this.btnCargar = new JButton();
        this.txtCantidad = new JSpinner();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAPTURA DE DATOS DE EXÁMENES DE LABORATORIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1212, 835));
        setMinimumSize(new Dimension(1212, 835));
        setName("TomaManual");
        setPreferredSize(new Dimension(1212, 835));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.TomaManual.3
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                TomaManual.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
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
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 0, 14));
        this.jPanel1.add(this.txtFecha, new AbsoluteConstraints(20, 20, 110, 50));
        this.txtObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(402, 20, 580, 60));
        this.cboExamen.setFont(new Font("Arial", 1, 12));
        this.cboExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Examen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboExamen, new AbsoluteConstraints(100, 80, 740, 50));
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Envia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboProfesional, new AbsoluteConstraints(140, 20, 250, 50));
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Laboratorio.TomaManual.4
            public void actionPerformed(ActionEvent evt) {
                TomaManual.this.btnCargarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCargar, new AbsoluteConstraints(850, 100, 130, 30));
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.txtCantidad, new AbsoluteConstraints(10, 80, 80, 50));
        this.jPanel5.add(this.jPanel1);
        this.jPanel1.setBounds(10, 190, 990, 140);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.TomaManual.5
            public void keyPressed(KeyEvent evt) {
                TomaManual.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid);
        this.jPanel5.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 340, 990, 320);
        getContentPane().add(this.jPanel5);
        this.jPanel5.setBounds(0, 0, 1020, 670);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }
}
