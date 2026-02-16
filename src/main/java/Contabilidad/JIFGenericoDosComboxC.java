package Contabilidad;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenericoDosComboxC.class */
public class JIFGenericoDosComboxC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private JComboBox JCBGenerico1;
    private JComboBox JCBGenerico2;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesgrupo = 0;
    private boolean xestadog = false;

    public JIFGenericoDosComboxC(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico1 = new JComboBox();
        this.JCBGenerico2 = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBGRUPO DE FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsubgrupofac");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFGenericoDosComboxC.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFGenericoDosComboxC.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico1.setFont(new Font("Arial", 1, 13));
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico2.setFont(new Font("Arial", 1, 13));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGenerico1, GroupLayout.Alignment.TRAILING, 0, 702, 32767).addComponent(this.JCBGenerico2, 0, 702, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico1, -1, 50, 32767).addGap(18, 18, 18).addComponent(this.JCBGenerico2, -2, -1, -2).addGap(18, 18, 18)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenericoDosComboxC.2
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoDosComboxC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 738, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 319, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBGenerico1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.xestadog = false;
        this.JCBGenerico1.setSelectedIndex(-1);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCBGenerico1.requestFocus();
    }

    public void mGrabar() {
        if (!this.xestadog) {
            if (this.JCBGenerico1.getSelectedIndex() != -1) {
                if (this.JCBGenerico2.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = null;
                        if (this.xnombre.equals("jifservicioxprocedimiento")) {
                            sql = " Insert into f_tiposervtipoproced(Idtiposervicio, Idtipoprocedimiento, Fecha, UsuarioS)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifauxiliarxconcepto")) {
                            sql = " Insert into cc_presupuesto_puc(Id_ConceptoCmsa, Id_Puc, Fecha, UsuarioS)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjiftipoactividadproceso")) {
                            sql = " Insert into s_solicitud_tipo_tipoproceso(Id_TipoProceso, Id_TipoSolicitud, Fecha, UsuarioS)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBGenerico2.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 1", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico1.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFGenericoDosComboxC.3
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifservicioxprocedimiento")) {
                xencabezado = new String[]{"Servicio", "Tipo Procedimiento", "Id"};
                sql = "SELECT f_tiposervicio.Nbre, f_tipoprocedimiento.Nbre FROM baseserver.f_tiposervtipoproced INNER JOIN baseserver.f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN baseserver.f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) ORDER BY f_tiposervicio.Nbre ASC, f_tipoprocedimiento.Nbre ASC ";
            } else if (this.xnombre.equals("jifauxiliarxconcepto")) {
                xencabezado = new String[]{"Concepto", "Cuenta Auxiliar", "Id"};
                sql = "SELECT cc_conceptocmsa.Nbre, Concat(cc_puc.Id,'-',cc_puc.Nbre) as Cuenta   FROM cc_presupuesto_puc INNER JOIN cc_conceptocmsa  ON (cc_presupuesto_puc.Id_ConceptoCmsa = cc_conceptocmsa.Id) INNER JOIN baseserver.cc_puc  ON (cc_presupuesto_puc.Id_Puc = cc_puc.Id) ORDER BY cc_conceptocmsa.Nbre ASC,  Cuenta ASC ";
            } else if (this.xnombre.equals("xjiftipoactividadproceso")) {
                xencabezado = new String[]{"Proceso", "Actividad", "Id"};
                sql = "SELECT s_sgc_tipoproceso.Nbre, s_solicitud_tipo.Nbre, s_solicitud_tipo_tipoproceso.Id FROM s_solicitud_tipo_tipoproceso INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_solicitud_tipo  ON (s_solicitud_tipo_tipoproceso.Id_TipoSolicitud = s_solicitud_tipo.Id) WHERE (s_solicitud_tipo_tipoproceso.Estado =1) ORDER BY s_sgc_tipoproceso.Nbre ASC, s_solicitud_tipo.Nbre ASC ";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    if (this.xnombre.equals("xjiftipoactividadproceso")) {
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    } else {
                        this.xmodelo.setValueAt(new Long(0L), n, 2);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("jifservicioxprocedimiento")) {
            this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_tiposervicio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico1, this.JCBGenerico1);
            this.JCBGenerico1.setSelectedIndex(-1);
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_tipoprocedimiento WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
            this.JCBGenerico2.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            return;
        }
        if (this.xnombre.equals("jifauxiliarxconcepto")) {
            this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_conceptocmsa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico1, this.JCBGenerico1);
            this.JCBGenerico1.setSelectedIndex(-1);
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, CONCAT(Id,'-',Nbre) AS Cuenta FROM cc_puc WHERE (Nivel >=8) ORDER BY Id ASC, Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
            this.JCBGenerico2.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            return;
        }
        if (this.xnombre.equals("xjiftipoactividadproceso")) {
            this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico1, this.JCBGenerico1);
            this.JCBGenerico1.setSelectedIndex(-1);
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM s_solicitud_tipo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
            this.JCBGenerico2.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }
}
