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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFProcedimientoxPaquete.class */
public class JIFFProcedimientoxPaquete extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String[] xidtiposervicio;
    private String[] xidprocedimiento;
    private String[] xidespecialidad;
    private String[] idFinalidad;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBFinalidad;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBTipoServicio;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFijo;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JSpinner JSPOrden;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xfijo = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFFProcedimientoxPaquete() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoServicio = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCHFijo = new JCheckBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPOrden = new JSpinner();
        this.JCBFinalidad = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROCEDIMIENTO POR PAQUETE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifprocedimientoxpaquete");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFProcedimientoxPaquete.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoServicio.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFProcedimientoxPaquete.this.JCBTipoServicioItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.3
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimientoxPaquete.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.4
            public void itemStateChanged(ItemEvent evt) {
                JIFFProcedimientoxPaquete.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCHFijo.setFont(new Font("Arial", 1, 12));
        this.JCHFijo.setSelected(true);
        this.JCHFijo.setText("Fijo?");
        this.JCHFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.5
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimientoxPaquete.this.JCHFijoActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBFinalidad.setFont(new Font("Arial", 1, 12));
        this.JCBFinalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "finalidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoServicio, -2, 374, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, 0, 332, 32767)).addComponent(this.JSPObservacion).addComponent(this.JCBFinalidad, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado, -2, 73, -2).addComponent(this.JCHFijo, -2, 63, -2)).addGap(33, 33, 33)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JSPOrden, -2, 94, -2).addContainerGap()))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoServicio).addComponent(this.JCBEspecialidad))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFijo).addComponent(this.JCBProcedimiento, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFinalidad, -2, -1, -2).addComponent(this.JSPOrden, -2, 39, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 47, -2)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.6
            public void mouseClicked(MouseEvent evt) {
                JIFFProcedimientoxPaquete.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 852, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 286, -2).addGap(25, 25, 25)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoServicio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBFinalidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHFijo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHFijo.isSelected()) {
                this.xfijo = 1;
            } else {
                this.xfijo = 0;
            }
            this.JSPOrden.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoServicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoServicio.getSelectedIndex() != -1) {
            this.JCBProcedimiento.removeAllItems();
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM f_tarifaprocedimiento INNER JOIN g_procedimiento  ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) WHERE (g_procedimiento.Id_tipoprocedimiento ='" + this.xidtiposervicio[this.JCBTipoServicio.getSelectedIndex()] + "' AND g_procedimiento.Estado =0) GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
            System.err.println(this.xsql);
            this.xidprocedimiento = this.xconsulta.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFijoActionPerformed(ActionEvent evt) {
        if (this.JCHFijo.isSelected()) {
            this.xfijo = 1;
        } else {
            this.xfijo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.lblNo.setText("");
    }

    public void mNuevo() {
        this.xestadog = false;
        this.xlleno = false;
        this.xsql = "SELECT f_tipoprocedimiento.Id, UCASE(f_tipoprocedimiento.Nbre) FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tipoclaseproc  ON (f_tipoprocedimiento.Id_tipoclaseproc = f_tipoclaseproc.Id) INNER JOIN f_tarifaprocedimiento  ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) WHERE (f_tipoclaseproc.EsQco =1) GROUP BY f_tipoprocedimiento.Id ORDER BY UCASE(f_tipoprocedimiento.Nbre) ASC ";
        this.JCBProcedimiento.removeAllItems();
        this.xidtiposervicio = this.xconsulta.llenarCombo(this.xsql, this.xidtiposervicio, this.JCBTipoServicio);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.xsql = "SELECT  `Id` , `Nbre` FROM `g_especialidad` WHERE (`Estado` =0) ORDER BY `Nbre` ASC";
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xconsulta.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xsql = "SELECT `Id`,`Nbre` FROM `f_tipofinprocedimiento` ;";
        this.JCBFinalidad.removeAllItems();
        this.idFinalidad = this.xconsulta.llenarCombo(this.xsql, this.idFinalidad, this.JCBFinalidad);
        this.JCBFinalidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
        this.xlleno = true;
        this.xestado = 1;
        this.xfijo = 0;
        this.JCHFijo.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.JCBTipoServicio.requestFocus();
        this.JSPOrden.setValue(0);
    }

    public void mGrabar() {
        if (this.JCBTipoServicio.getSelectedIndex() != -1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!this.xestadog) {
                            this.xsql = " Insert into g_procedimxpaquete(Id_Paquete, Id_Procedim, Id_Especial,Fijo,Observacion,Orden, Estado, UsuarioS,`idFinProcedimiento`)  values ('" + Principal.txtNo.getText() + "','" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xfijo + "','" + this.JTAObservacion.getText() + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.idFinalidad[this.JCBFinalidad.getSelectedIndex()] + "')";
                        } else {
                            this.xsql = "update g_procedimxpaquete set Id_Especial='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', Estado='" + this.xestado + "', Fijo='" + this.xfijo + "', Observacion='" + this.JTAObservacion.getText() + "', Orden='" + this.JSPOrden.getValue() + "', idFinProcedimiento ='" + this.idFinalidad[this.JCBFinalidad.getSelectedIndex()] + "'  where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                        }
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProcedimiento.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoServicio.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFFProcedimientoxPaquete.7
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Tipo Servicio", "Procedimiento", "Finalidad", "Estado", "Especialidad", "Fijo?", "Orden"};
            mCrearModeloDatos(xencabezado);
            String sql = "SELECT g_procedimxpaquete.Id, UCASE(f_tipoprocedimiento.Nbre) AS TipoProc, g_procedimiento.Nbre,f_tipofinprocedimiento.Nbre AS Finalidad, g_procedimxpaquete.Estado, g_especialidad.Nbre,g_procedimxpaquete.Fijo, g_procedimxpaquete.Orden FROM g_procedimiento  INNER JOIN g_procedimxpaquete ON (g_procedimiento.Id = g_procedimxpaquete.Id_Procedim) INNER JOIN g_especialidad ON (g_especialidad.Id = g_procedimxpaquete.Id_Especial)  INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)  INNER JOIN `f_tipofinprocedimiento`\n    ON(`g_procedimxpaquete`.`idFinProcedimiento` = `f_tipofinprocedimiento`.`Id`)WHERE (g_procedimxpaquete.Id_Paquete ='" + Principal.txtNo.getText() + "') ORDER BY TipoProc ASC, g_procedimiento.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
