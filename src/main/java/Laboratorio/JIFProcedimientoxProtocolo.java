package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia;
import com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos;
import com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito;
import com.genoma.plus.controller.laboratorio.JDHomologacionProtocolosEmpresa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFProcedimientoxProtocolo.class */
public class JIFProcedimientoxProtocolo extends JInternalFrame {
    private Object[] xdato;
    private DefaultTableModel xmodelo;
    private String[] xidprotocolo;
    private String[] xidprocedimiento;
    private String[] xidarea;
    private String xsql;
    private JButton JBEquipo;
    private JButton JBFormula;
    private JComboBox JCBArea;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBProtocolo;
    private JCheckBox JCHAplicaDecimal;
    private JCheckBox JCHCNOrdenRecepcion;
    private JCheckBox JCHEstado;
    private JCheckBox JCHObligatorio;
    private JPanel JPIDAlerta;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNCaracteres;
    private JSpinner JSPNExamen;
    private JSpinner JSPNOrden;
    private JTable JTBDetalle;
    private JTextField JTFFVMaximo;
    private JTextField JTFFVMinimo;
    private JTextField JTFINAdicional;
    private JTextField JTFIdInfinity;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 0;
    private int xCNOrdenRecepcion = 0;
    private int aplicaDecimal = 1;
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFProcedimientoxProtocolo() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.xlleno1 = false;
        this.JTFINAdicional.setText("");
        this.JCBProtocolo.removeAllItems();
        this.xidprotocolo = this.xct.llenarCombo("SELECT Id, CONCAT(Nbre,' (',Id,')') as Nbre FROM l_protocolos WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprotocolo, this.JCBProtocolo);
        this.JCBProtocolo.setSelectedIndex(-1);
        this.JCBProcedimiento.removeAllItems();
        this.JCBArea.removeAllItems();
        this.xidarea = this.xct.llenarCombo("SELECT l_areas.Id, l_areas.Nbre FROM l_areas INNER JOIN g_procedimiento  ON (l_areas.Id = g_procedimiento.Id_Area) WHERE (l_areas.Estado =0) GROUP BY l_areas.Id ORDER BY l_areas.Nbre ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JSPNOrden.setValue(new Integer(0));
        this.JSPNExamen.setValue(new Integer(0));
        this.JTFFVMinimo.setText("0");
        this.JTFFVMaximo.setText("0");
        this.JTFIdInfinity.setText("");
        this.xestado = 0;
        this.JCHEstado.setSelected(true);
        this.xCNOrdenRecepcion = 0;
        this.JCHCNOrdenRecepcion.setSelected(false);
        this.JCHAplicaDecimal.setSelected(false);
        this.aplicaDecimal = 1;
        this.JSPNCaracteres.setEnabled(false);
        this.JSPNCaracteres.setValue(0);
        mCrearModeloDatos();
        this.xlleno = true;
        this.JCBArea.requestFocus();
    }

    private boolean verificarCaracteres(String valor) {
        return valor.matches("^[0-9]{1,5}(\\,[0-9]{0,2})?$");
    }

    public void mGrabar() {
        if (this.JCBArea.getSelectedIndex() != -1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBProtocolo.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        int esObligatorio = 0;
                        if (this.JCHObligatorio.isSelected()) {
                            esObligatorio = 1;
                        }
                        if (!Principal.txtNo.getText().isEmpty()) {
                            this.xsql = "update l_protocoloxprocedimiento set Estado='" + this.xestado + "', Orden='" + this.JSPNOrden.getValue() + "', CExamen='" + this.JSPNExamen.getValue() + "', CMinimo='" + this.JTFFVMinimo.getText().replaceAll(",", ".") + "', CMaximo='" + this.JTFFVMaximo.getText().replaceAll(",", ".") + "', NAdicional='" + this.JTFINAdicional.getText().toString() + "', IdInfinity='" + this.JTFIdInfinity.getText() + "', CNOrden_Recepcion='" + this.xCNOrdenRecepcion + "', AplicaDecimales='" + this.aplicaDecimal + "', NoDecimales='" + this.JSPNCaracteres.getValue() + "', esObligatorio='" + esObligatorio + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        } else {
                            this.xsql = " insert into l_protocoloxprocedimiento(Id_Protocolo, Id_Procedim, Orden, CExamen, CMinimo, CMaximo, NAdicional, IdInfinity, CNOrden_Recepcion, AplicaDecimales, NoDecimales, Estado, esObligatorio, formula, Fecha, UsuarioS) values ('" + this.xidprotocolo[this.JCBProtocolo.getSelectedIndex()] + "','" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.JSPNOrden.getValue() + "','" + this.JSPNExamen.getValue() + "','" + this.JTFFVMinimo.getText().replaceAll(",", ".") + "','" + this.JTFFVMaximo.getText().replaceAll(",", ".") + "','" + this.JTFINAdicional.getText() + "','" + this.JTFIdInfinity.getText() + "','" + this.xCNOrdenRecepcion + "','" + this.aplicaDecimal + "','" + this.JSPNCaracteres.getValue() + "','" + this.xestado + "','" + esObligatorio + "','','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        if (!this.JCHEstado.isSelected()) {
                            this.xsql = "DELETE pj\nFROM l_protocolosxequipos_jornada pj\nJOIN l_protocolosxequipos pe ON pj.idProtocoloEquipo = pe.Id\nWHERE pe.IdProtocoloProcedimiento = " + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString();
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "DELETE FROM l_protocolosxequipos\nWHERE IdProtocoloProcedimiento =" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString();
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un protocolo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProtocolo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un área", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBArea.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "N° Orden", "Estado", "NExamen", "V/Mínimo", "V/Máximo", "Ref", "N° Adicional", "Cod. Infinity", "OrdenR?", "AplicaDecimal", "No. Decimales", "IdProtocolo", "Obligatorio?", "Modificar", "Tipo Muestra"}) { // from class: Laboratorio.JIFProcedimientoxProtocolo.1
            Class[] types = {Long.class, String.class, Long.class, Boolean.class, Long.class, Double.class, Double.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Integer.class, String.class, Boolean.class, JButton.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.JTBDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.JIFProcedimientoxProtocolo.2
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT\n\tlp.Id,\n\tCONCAT(lp2.Nbre, ' (', lp2.Id, ')') as Nbre,\n\tlp.Orden,\n\tlp.Estado,\n\tlp.CExamen,\n\tlp.CMinimo,\n\tlp.CMaximo,\n\tlp2.Abreviatura,\n\tlp.NAdicional,\n\tlp.IdInfinity,\n\tlp.CNOrden_Recepcion,\n\tlp.AplicaDecimales,\n\tlp.NoDecimales,\n\tlp2.`Id` AS idProtocolo,\n\tlp.esObligatorio,\n\tlt.Nbre AS tipoMuestra\nFROM\n\tl_protocoloxprocedimiento lp \nINNER JOIN l_protocolos lp2 ON\n\t(lp.Id_Protocolo = lp2.Id)\nINNER JOIN l_tipomuestra lt ON\n\t(lp2.Id_Tipo_Muestra = lt.Id)\nWHERE\n\t(lp.Estado = 0\n\t\tand lp.Id_Procedim = " + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + ")\nORDER BY\n\tlp.Orden asc,\n\tlp2.Nbre ASC";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("AplicaDecimales")), n, 11);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("NoDecimales")), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("esObligatorio")), n, 14);
                    this.xmodelo.setValueAt(new JButton("Modificar"), n, 15);
                    this.xmodelo.setValueAt(xrs.getString("tipoMuestra"), n, 16);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFProcedimientoxProtocolo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JCBArea = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JCBProtocolo = new JComboBox();
        this.JSPNOrden = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JSPNExamen = new JSpinner();
        this.JPIDAlerta = new JPanel();
        this.JTFFVMinimo = new JTextField();
        this.JTFFVMaximo = new JTextField();
        this.JTFINAdicional = new JTextField();
        this.JTFIdInfinity = new JTextField();
        this.JCHCNOrdenRecepcion = new JCheckBox();
        this.JCHAplicaDecimal = new JCheckBox();
        this.JSPNCaracteres = new JSpinner();
        this.JCHObligatorio = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JBFormula = new JButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.JBEquipo = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROTOCOLO POR PROCEDIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ProtocolxAreaxProcedim");
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.3
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFProcedimientoxProtocolo.this.formInternalFrameClosing(evt);
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
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Área", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.4
            public void itemStateChanged(ItemEvent evt) {
                JIFProcedimientoxProtocolo.this.JCBAreaItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.5
            public void itemStateChanged(ItemEvent evt) {
                JIFProcedimientoxProtocolo.this.JCBProcedimientoItemStateChanged(evt);
            }
        });
        this.JCBProtocolo.setFont(new Font("Arial", 1, 12));
        this.JCBProtocolo.setBorder(BorderFactory.createTitledBorder((Border) null, "Protocolo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProtocolo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.6
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JCBProtocoloActionPerformed(evt);
            }
        });
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.7
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPNExamen.setFont(new Font("Arial", 1, 12));
        this.JSPNExamen.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNExamen.setToolTipText("N° Items para incluir en la grafica");
        this.JSPNExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDAlerta.setBorder(BorderFactory.createTitledBorder((Border) null, "Límite de Seguridad", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFVMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFVMinimo.setHorizontalAlignment(0);
        this.JTFFVMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVMinimo.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFProcedimientoxProtocolo.8
            public void focusLost(FocusEvent evt) {
                JIFProcedimientoxProtocolo.this.JTFFVMinimoFocusLost(evt);
            }
        });
        this.JTFFVMaximo.setFont(new Font("Arial", 1, 12));
        this.JTFFVMaximo.setHorizontalAlignment(0);
        this.JTFFVMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVMaximo.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFProcedimientoxProtocolo.9
            public void focusLost(FocusEvent evt) {
                JIFProcedimientoxProtocolo.this.JTFFVMaximoFocusLost(evt);
            }
        });
        this.JTFFVMaximo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.10
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JTFFVMaximoActionPerformed(evt);
            }
        });
        GroupLayout JPIDAlertaLayout = new GroupLayout(this.JPIDAlerta);
        this.JPIDAlerta.setLayout(JPIDAlertaLayout);
        JPIDAlertaLayout.setHorizontalGroup(JPIDAlertaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAlertaLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFFVMinimo, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVMaximo, -2, 82, -2).addGap(10, 10, 10)));
        JPIDAlertaLayout.setVerticalGroup(JPIDAlertaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAlertaLayout.createSequentialGroup().addGroup(JPIDAlertaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFVMinimo, -2, 50, -2).addComponent(this.JTFFVMaximo, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTFINAdicional.setFont(new Font("Arial", 1, 12));
        this.JTFINAdicional.setToolTipText("Complemento Para la Recepción");
        this.JTFINAdicional.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Adicional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdInfinity.setFont(new Font("Arial", 1, 12));
        this.JTFIdInfinity.setToolTipText("");
        this.JTFIdInfinity.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Externo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdInfinity.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.11
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JTFIdInfinityActionPerformed(evt);
            }
        });
        this.JCHCNOrdenRecepcion.setFont(new Font("Arial", 1, 12));
        this.JCHCNOrdenRecepcion.setSelected(true);
        this.JCHCNOrdenRecepcion.setText("Orden Recepcion?");
        this.JCHCNOrdenRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.12
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JCHCNOrdenRecepcionActionPerformed(evt);
            }
        });
        this.JCHAplicaDecimal.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaDecimal.setText("Aplica Redondeo?");
        this.JCHAplicaDecimal.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.13
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JCHAplicaDecimalActionPerformed(evt);
            }
        });
        this.JSPNCaracteres.setFont(new Font("Arial", 1, 12));
        this.JSPNCaracteres.setModel(new SpinnerNumberModel(0, 0, 5, 1));
        this.JSPNCaracteres.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Decimales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHObligatorio.setFont(new Font("Arial", 1, 12));
        this.JCHObligatorio.setText("Obligatorio?");
        this.JCHObligatorio.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.14
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JCHObligatorioActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBProtocolo, -2, 554, -2).addGap(28, 28, 28).addComponent(this.JSPNExamen).addGap(14, 14, 14).addComponent(this.JSPNOrden).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNCaracteres, -2, 98, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBArea, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimiento, -2, 589, -2)))).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFINAdicional, -2, 178, -2).addGap(20, 20, 20).addComponent(this.JPIDAlerta, -2, -1, -2).addGap(4, 4, 4).addComponent(this.JTFIdInfinity, -2, 178, -2).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCNOrdenRecepcion).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAplicaDecimal).addComponent(this.JCHObligatorio)))).addGap(30, 30, 30)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFINAdicional, -2, 56, -2).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArea, -2, 50, -2).addComponent(this.JCBProcedimiento, -2, 50, -2)).addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProtocolo, -2, 50, -2).addComponent(this.JSPNOrden, -2, 50, -2).addComponent(this.JSPNExamen, -2, 50, -2).addComponent(this.JSPNCaracteres, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDAlerta, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHAplicaDecimal)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCNOrdenRecepcion).addComponent(this.JCHObligatorio))).addComponent(this.JTFIdInfinity, -2, 56, -2))))).addGap(8, 8, 8)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFProcedimientoxProtocolo.15
            public void mouseClicked(MouseEvent evt) {
                JIFProcedimientoxProtocolo.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "CONFIGURACIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBFormula.setFont(new Font("Arial", 1, 12));
        this.JBFormula.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Presupuesto2.png")));
        this.JBFormula.setText("Formula");
        this.JBFormula.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.16
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JBFormulaActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Mantenimiento.jpg")));
        this.jButton1.setText("Homologacion");
        this.jButton1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.17
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.jButton2.setText("Resultados Por Patologia");
        this.jButton2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.18
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.jButton2ActionPerformed(evt);
            }
        });
        this.JBEquipo.setFont(new Font("Arial", 1, 12));
        this.JBEquipo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configurar29x27.png")));
        this.JBEquipo.setText("Analizador");
        this.JBEquipo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxProtocolo.19
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxProtocolo.this.JBEquipoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBEquipo, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBFormula, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 218, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 50, -2).addComponent(this.JBEquipo, -2, 50, -2).addComponent(this.JBFormula, -2, 50, -2).addComponent(this.jButton2, -2, 50, -2)).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 331, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAreaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBArea.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBProcedimiento.removeAllItems();
            this.xsql = "SELECT  l_codigoprouni.Id_CodProcedUnif, g_procedimiento.Nbre  FROM l_codigoprouni INNER JOIN g_procedimiento ON (l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id)  WHERE (g_procedimiento.Estado =0 AND g_procedimiento.Id_Area ='" + this.xidarea[this.JCBArea.getSelectedIndex()] + "') GROUP BY l_codigoprouni.Id_CodProcedUnif ORDER BY g_procedimiento.Nbre ASC ";
            this.xidprocedimiento = this.xct.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xlleno1 = true;
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.JCBProtocolo.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            this.JSPNOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString()));
            this.JCHEstado.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString()));
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JSPNExamen.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()));
            this.JTFFVMinimo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString().replaceAll("\\.", ","));
            this.JTFFVMaximo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString().replaceAll("\\.", ","));
            this.JTFINAdicional.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString());
            this.JTFIdInfinity.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString());
            this.JCHCNOrdenRecepcion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString()).booleanValue());
            if (this.JCHCNOrdenRecepcion.isSelected()) {
                this.xCNOrdenRecepcion = 1;
            } else {
                this.xCNOrdenRecepcion = 0;
            }
            this.JCHAplicaDecimal.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString()));
            this.JCHObligatorio.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).toString()));
            if (this.JCHAplicaDecimal.isSelected()) {
                this.aplicaDecimal = 1;
                this.JSPNCaracteres.setEnabled(true);
                this.JSPNCaracteres.setValue(2);
            } else {
                this.aplicaDecimal = 0;
                this.JSPNCaracteres.setEnabled(false);
                this.JSPNCaracteres.setValue(0);
            }
            this.JSPNCaracteres.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString()));
            if (this.JTBDetalle.getModel().getColumnClass(15).equals(JButton.class) && this.JTBDetalle.getSelectedColumn() == 15) {
                Principal.claselab.cargarPantalla("Protocolos", Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCNOrdenRecepcionActionPerformed(ActionEvent evt) {
        if (this.JCHCNOrdenRecepcion.isSelected()) {
            this.xCNOrdenRecepcion = 1;
        } else {
            this.xCNOrdenRecepcion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProtocoloActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdInfinityActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaDecimalActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaDecimal.isSelected()) {
            this.aplicaDecimal = 1;
            this.JSPNCaracteres.setEnabled(true);
            this.JSPNCaracteres.setValue(2);
        } else {
            this.aplicaDecimal = 0;
            this.JSPNCaracteres.setEnabled(false);
            this.JSPNCaracteres.setValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVMinimoFocusLost(FocusEvent evt) {
        if (!verificarCaracteres(this.JTFFVMinimo.getText())) {
            this.JTFFVMinimo.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVMaximoFocusLost(FocusEvent evt) {
        if (!verificarCaracteres(this.JTFFVMaximo.getText())) {
            this.JTFFVMaximo.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVMaximoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            JDHomologacionProtocolosEmpresa PxEquipos = new JDHomologacionProtocolosEmpresa(null, true, this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()]);
            PxEquipos.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            JDConfiguracionResultadoPorPatologia xJDConfiguracionResultadoPorPatologia = new JDConfiguracionResultadoPorPatologia(null, true, this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).toString());
            xJDConfiguracionResultadoPorPatologia.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Registro de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHObligatorioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBEquipoActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            JDFProtocolosxEquipos protocolosxEquipos = new JDFProtocolosxEquipos(null, true, Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()));
            protocolosxEquipos.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Registro de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFormulaActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            JDFormulaPorAnalito formulaPorAnalito = new JDFormulaPorAnalito(null, true, Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()));
            formulaPorAnalito.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Registro de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }
}
