package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/RecepcionManual.class */
public class RecepcionManual extends JInternalFrame {
    private Persona frmPersona;
    private DefaultTableModel modelo;
    private String sql;
    private Object[] fila;
    private String[][] parametros;
    private int filaGrid;
    private String[] listaExamen;
    private String[] xidempresa;
    private String[][] listaProfe;
    private JButton JBTCerrar2;
    private JComboBox JCBEmpresa;
    private JSpinner JTFFSPerimetroAbd;
    private JSpinner JTFFSPeso;
    private JSpinner JTFFSTalla;
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

    public RecepcionManual() {
        initComponents();
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionManual.1
            public void mouseClicked(MouseEvent e) {
                RecepcionManual.this.filaGrid = RecepcionManual.this.grid.rowAtPoint(e.getPoint());
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
            Object[] botones = {"Recepción", "Ordenes", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                BuscarOrden frm = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "RecepcionM");
                frm.setVisible(true);
                return;
            } else {
                if (n == 0) {
                    BuscarOrden frm2 = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "TomaManual");
                    frm2.setVisible(true);
                    return;
                }
                return;
            }
        }
        this.metodos.mostrarMensaje("Por favor seleccione el Usuario a quien se consultará");
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

    public void mCargarOrdenRecep() {
        crearGrid();
        this.sql = "SELECT l_recepcion.Id, l_recepcion.FechaRecep, profesional1.NProfesional, l_detallerecepcion.Id_Procedim, g_procedimiento.Nbre, l_detallerecepcion.Cantidad FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) WHERE (l_recepcion.Id ='" + Principal.txtNo.getText() + "'  AND l_recepcion.Estado =0) ORDER BY g_procedimiento.Nbre ASC ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.id = rs.getString(1);
                this.txtFecha.setDate(rs.getDate(2));
                this.cboProfesional.setSelectedItem(rs.getString(3));
                rs.beforeFirst();
                while (rs.next()) {
                    this.modelo.addRow(this.fila);
                    this.modelo.setValueAt(rs.getString(4), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(5), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString(6), this.filaGrid, 2);
                    this.filaGrid++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
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
        this.listaProfe = this.consultas.llenarComboyLista("SELECT Id_Persona, NProfesional, IdEspecialidad FROM profesional1 ORDER BY NProfesional ASC", this.listaProfe, this.cboProfesional, 3);
        this.cboProfesional.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.listaExamen = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_procedimiento WHERE (Estado =0    AND Id_tipoprocedimiento =6 ) ORDER BY Nbre ASC", this.listaExamen, this.cboExamen);
        this.cboExamen.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xidempresa = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_empresacontxconvenio WHERE (Estado =0) ORDER BY Nbre ASC ", this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(10, 15, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad"}) { // from class: Laboratorio.RecepcionManual.2
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
            if (!Principal.txtNo.getText().isEmpty()) {
                String xsql = "delete from l_detallerecepcion where Id_Procedim='" + this.modelo.getValueAt(this.grid.getSelectedRow(), 0) + "' and Id_Recepcion='" + Principal.txtNo.getText() + "'";
                this.consultas.ejecutarSQL(xsql);
                this.consultas.cerrarConexionBd();
            }
            this.modelo.removeRow(this.filaGrid);
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
                this.frmPersona.grabar();
                grabarCabecera();
                grabarDetalle();
                return;
            }
            return;
        }
        if (this.metodos.getPregunta("Deseas modificar la recepción?") == 0 && validarDatos() == 1) {
            this.frmPersona.grabar();
            grabarDetalle();
        }
    }

    private void grabarCabecera() {
        this.sql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , PAbdominal, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','0','" + this.txtObservaciones.getText() + "','" + this.listaProfe[this.cboProfesional.getSelectedIndex()][0] + "','" + this.listaProfe[this.cboProfesional.getSelectedIndex()][1] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.JTFFSPeso.getValue() + "','" + this.JTFFSTalla.getValue() + "','" + this.JTFFSPerimetroAbd.getValue() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.id = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.id);
        this.metodos.marcarEstado(2);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0) {
                this.sql = "INSERT IGNORE INTO  l_detallerecepcion(Id_Recepcion, fechaMuestra, Id_Procedim, Cantidad) VALUES('" + this.id + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    public void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Archivos de Programa\\Windows NT\\Accesorios\\wordpad.exe c:\\Genoma\\Reportes\\RTF_Salida.rtf");
        } catch (IOException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void imprimirSticker() {
        String[][] parametros = new String[3][2];
        parametros[0][0] = "id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        System.out.println(this.metodos.getRutaRep());
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker1", parametros);
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
        Principal.txtNo.setText("");
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

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtFecha = new JDateChooser();
        this.cboExamen = new JComboBox();
        this.cboProfesional = new JComboBox();
        this.txtCantidad = new JSpinner();
        this.JCBEmpresa = new JComboBox();
        this.btnCargar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        this.JBTCerrar2 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.JTFFSTalla = new JSpinner();
        this.JTFFSPeso = new JSpinner();
        this.JTFFSPerimetroAbd = new JSpinner();
        this.panelPersona = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECEPCIÓN MANUAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("TomaManual");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.RecepcionManual.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                RecepcionManual.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                RecepcionManual.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                RecepcionManual.this.formInternalFrameClosing(evt);
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
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ORDEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 0, 12));
        this.cboExamen.setFont(new Font("Arial", 1, 12));
        this.cboExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionManual.4
            public void actionPerformed(ActionEvent evt) {
                RecepcionManual.this.btnCargarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboProfesional, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 340, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.cboExamen, -2, 717, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCantidad, -2, 61, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCargar, -2, 122, -2).addContainerGap(24, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnCargar, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboProfesional, -2, -1, -2).addComponent(this.JCBEmpresa)).addGap(7, 7, 7)).addComponent(this.txtFecha, -2, -1, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboExamen, -2, -1, -2).addComponent(this.txtCantidad)))).addGap(16, 16, 16)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "PROEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionManual.5
            public void keyPressed(KeyEvent evt) {
                RecepcionManual.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid);
        this.JBTCerrar2.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTCerrar2.setText("Registro de Citología");
        this.JBTCerrar2.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionManual.6
            public void actionPerformed(ActionEvent evt) {
                RecepcionManual.this.JBTCerrar2ActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.txtObservaciones.setBorder((Border) null);
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla(cm)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso(Kg)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSPerimetroAbd.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JTFFSPerimetroAbd.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFFSTalla).addGap(18, 18, 18).addComponent(this.JTFFSPeso, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFSPerimetroAbd, -2, 130, -2).addGap(14, 14, 14).addComponent(this.jScrollPane1, -2, 306, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar2, -2, 240, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 12, 32767))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -1, 50, 32767).addComponent(this.JTFFSTalla).addComponent(this.JTFFSPeso).addComponent(this.JTFFSPerimetroAbd).addComponent(this.JBTCerrar2, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panelPersona.setMaximumSize((Dimension) null);
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.panelPersona, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addContainerGap(12, 32767)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar2ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("1010")) {
            try {
                Principal.clasepyp = new clasePyP(Principal.claselab.frmPrincipal);
                Principal.clasepyp.setXidrecepcion(Long.valueOf(Principal.txtNo.getText()).longValue());
                Principal.clasepyp.cargarPantalla("Toma");
                Principal.clasepyp.frmToma.frmPersona.txtHistoria.setText(this.frmPersona.getHistoria());
                Principal.clasepyp.frmToma.frmPersona.buscar(2);
                Principal.clasepyp.frmToma.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
