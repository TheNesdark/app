package Sgc;

import Acceso.Principal;
import GestionDoc.JDRespuesta;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFEncuestaS.class */
public class JIFEncuestaS extends JInternalFrame {
    public DefaultTableModel xmodelo;
    private String[] xidtipoencuesta;
    private Object[] xdato;
    private String xnombre;
    private String[] xidtipop;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    private String xsql;
    private JButton JBTGrabar;
    private JButton JBTVisualizarSol;
    private JComboBox JCBNEncuentas;
    private JComboBox JCBProceso;
    private JComboBox JCBTProceso;
    public JDateChooser JDCFecha;
    private JPanel JPIDatosI;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacionG;
    private JTextPane JTAObservacionG;
    public JTable JTDetalle;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    private long xidingreso = 0;
    private int xposfila = -1;

    public JIFEncuestaS(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        mNuevo(0);
        System.out.println(xnombre);
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosI = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBNEncuentas = new JComboBox();
        this.JSPObservacionG = new JScrollPane();
        this.JTAObservacionG = new JTextPane();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JBTVisualizarSol = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGrabar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE ENCUESTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifregistroencuesta");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFEncuestaS.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEncuestaS.this.formInternalFrameClosing(evt);
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
        this.JPIDatosI.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JCBNEncuentas.setFont(new Font("Arial", 1, 12));
        this.JCBNEncuentas.setBorder(BorderFactory.createTitledBorder((Border) null, "Encuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNEncuentas.addItemListener(new ItemListener() { // from class: Sgc.JIFEncuestaS.2
            public void itemStateChanged(ItemEvent evt) {
                JIFEncuestaS.this.JCBNEncuentasItemStateChanged(evt);
            }
        });
        this.JSPObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionG.setViewportView(this.JTAObservacionG);
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: Sgc.JIFEncuestaS.3
            public void itemStateChanged(ItemEvent evt) {
                JIFEncuestaS.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso.addItemListener(new ItemListener() { // from class: Sgc.JIFEncuestaS.4
            public void itemStateChanged(ItemEvent evt) {
                JIFEncuestaS.this.JCBProcesoItemStateChanged(evt);
            }
        });
        this.JBTVisualizarSol.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizarSol.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTVisualizarSol.setText("Visualizar Solicitud");
        this.JBTVisualizarSol.addActionListener(new ActionListener() { // from class: Sgc.JIFEncuestaS.5
            public void actionPerformed(ActionEvent evt) {
                JIFEncuestaS.this.JBTVisualizarSolActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosILayout = new GroupLayout(this.JPIDatosI);
        this.JPIDatosI.setLayout(JPIDatosILayout);
        JPIDatosILayout.setHorizontalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosILayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTProceso, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 466, -2)).addComponent(this.JCBNEncuentas, GroupLayout.Alignment.LEADING, 0, 863, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosILayout.createSequentialGroup().addComponent(this.JSPObservacionG, -2, 684, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTVisualizarSol, -1, -1, 32767))).addContainerGap()));
        JPIDatosILayout.setVerticalGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosILayout.createSequentialGroup().addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFecha, -2, -1, -2).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.JCBNEncuentas).addGroup(JPIDatosILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosILayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionG, -2, 68, -2)).addGroup(JPIDatosILayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JBTVisualizarSol, -1, -1, 32767)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(2);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFEncuestaS.6
            public void mouseClicked(MouseEvent evt) {
                JIFEncuestaS.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.setEnabled(false);
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Sgc.JIFEncuestaS.7
            public void actionPerformed(ActionEvent evt) {
                JIFEncuestaS.this.JBTGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 899, 32767).addComponent(this.JPIDatosI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTGrabar, GroupLayout.Alignment.LEADING, -1, 899, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabar, -1, 110, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedColumn() == 2) {
            if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta")) {
                JDRespuesta xjdrespuesta = new JDRespuesta(Principal.clasegestiondoc.frmPrincipal, true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this);
                xjdrespuesta.setLocationRelativeTo(Principal.clasegestiondoc.frmPrincipal);
                xjdrespuesta.setVisible(true);
                return;
            }
            if (this.xnombre.equals("xjifregistroencuesta1")) {
                JDRespuesta xjdrespuesta2 = new JDRespuesta(Principal.clasegeneral.frmPrincipal, true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this);
                xjdrespuesta2.setLocationRelativeTo(Principal.clasegeneral.frmPrincipal);
                xjdrespuesta2.setVisible(true);
            } else if (this.xnombre.equals("xjifregistroencuesta2")) {
                JDRespuesta xjdrespuesta3 = new JDRespuesta(Principal.clasefacturacion.frmPrincipal, true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this);
                xjdrespuesta3.setLocationRelativeTo(Principal.clasegeneral.frmPrincipal);
                xjdrespuesta3.setVisible(true);
            } else if (this.xnombre.equals("xjifregistroencuesta3")) {
                JDRespuesta xjdrespuesta4 = new JDRespuesta(Principal.xclasesgc.frmPrincipal, true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this);
                xjdrespuesta4.setLocationRelativeTo(Principal.xclasesgc.frmPrincipal);
                xjdrespuesta4.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta3")) {
                this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre, s_sgc_tipoproceso.Correo FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_tipoproceso.Id = t_e_tipo_encuesta_detalle.Id_TipoProceso) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id)  INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) WHERE (t_e_tipo_encuesta.Estado =1 AND t_e_tipo_encuesta.Cerrada=0 AND s_sgc_tipoproceso.Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "') GROUP BY s_sgc_tipoproceso.Id ORDER BY s_sgc_tipoproceso.Nbre ASC";
                this.xidproceso = xct1.llenarComboyLista(this.xsql, this.xidproceso, this.JCBProceso, 3);
                this.JCBProceso.setSelectedIndex(-1);
                xct1.cerrarConexionBd();
            } else if (this.xnombre.equals("xjifregistroencuesta1") || this.xnombre.equals("xjifregistroencuesta2")) {
                this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre, s_sgc_tipoproceso.Correo FROM t_e_tipo_encuesta_detalle  INNER JOIN t_e_tipo_encuesta ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id)  INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id)  INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id)  INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id)  WHERE (t_e_tipo_encuesta_detalle.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoEncuesta() + "' AND t_e_tipo_encuesta_detalle.Diligencio =0 AND s_sgc_procesos.Id ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "') ";
                this.xidproceso = xct1.llenarComboyLista(this.xsql, this.xidproceso, this.JCBProceso, 3);
                xct1.cerrarConexionBd();
                mLLenarEncuesta();
            }
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProceso.getSelectedIndex() != -1) {
            this.xlleno2 = false;
            this.JCBNEncuentas.removeAllItems();
            ConsultasMySQL xct2 = new ConsultasMySQL();
            if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta3")) {
                this.xsql = "SELECT t_e_tipo_encuesta_detalle.Id , t_encuestas.Nbre  FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_tipoproceso.Id = t_e_tipo_encuesta_detalle.Id_TipoProceso) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) WHERE (t_e_tipo_encuesta_detalle.Id_TipoProceso ='" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "' AND t_e_tipo_encuesta.Cerrada=0 ) GROUP BY t_e_tipo_encuesta_detalle.Id  ORDER BY t_encuestas.Nbre ASC ";
                this.xidtipoencuesta = xct2.llenarCombo(this.xsql, this.xidtipoencuesta, this.JCBNEncuentas);
                this.JCBNEncuentas.setSelectedIndex(-1);
                xct2.cerrarConexionBd();
            } else if (this.xnombre.equals("xjifregistroencuesta1")) {
                mLLenarEncuesta();
            }
            this.xlleno2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNEncuentasItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBNEncuentas.getSelectedIndex() != -1) {
            mCargarDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizarSolActionPerformed(ActionEvent evt) {
        System.out.println(Principal.informacionGeneralPrincipalDTO.getIdSolicitudEncuesta());
        if (Principal.informacionGeneralPrincipalDTO.getIdSolicitudEncuesta().longValue() != 0) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdSolicitudEncuesta());
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "S_Solicitud_SI", mparametros);
        }
    }

    public void mNuevo(int x) {
        if (x == 0) {
            if (!this.xnombre.equals("xjifregistroencuesta2")) {
                Principal.mLimpiarDatosP();
            }
            this.xlleno = false;
            this.xlleno1 = false;
            this.xlleno2 = false;
            this.JDCFecha.setDate(this.xmt.getFechaActual());
            this.JCBNEncuentas.removeAllItems();
            this.JCBProceso.removeAllItems();
            this.JCBTProceso.removeAllItems();
            this.JCBNEncuentas.removeAllItems();
            this.xidtipop = this.xct.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
            this.JCBTProceso.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta3")) {
                mCrearTablaDetalle();
                this.JBTGrabar.setEnabled(false);
            } else if (this.xnombre.equals("xjifregistroencuesta1") || this.xnombre.equals("xjifregistroencuesta2")) {
                String sql = "SELECT t_e_tipo_encuesta_detalle.Id, t_encuestas.Nbre, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, t_e_tipo_encuesta_detalle.Id_Solicitud FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (t_e_tipo_encuesta_detalle.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoEncuesta() + "' AND t_e_tipo_encuesta_detalle.Diligencio =0) ";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs = xct1.traerRs(sql);
                try {
                    if (xrs.next()) {
                        xrs.first();
                        System.out.println(xrs.getString(3));
                        this.xlleno = true;
                        this.JCBTProceso.setSelectedItem(xrs.getString(3));
                    }
                    xrs.close();
                    xct1.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFEncuestaS.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                if (this.xnombre.equals("xjifregistroencuesta2")) {
                    this.JBTGrabar.setEnabled(true);
                } else {
                    this.JBTGrabar.setEnabled(false);
                }
            }
            this.JTAObservacionG.setText("");
            this.xlleno = true;
            return;
        }
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        mCargarDetalle();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Respuesta", "Observación", "IdTipoResp", "IdRespuesta", "ValorN", "TipoV"}) { // from class: Sgc.JIFEncuestaS.8
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, true, true, true, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDetalle() {
        if (this.JCBNEncuentas.getSelectedIndex() != -1) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                mCrearTablaDetalle();
                String sql = null;
                if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta2") || this.xnombre.equals("xjifregistroencuesta3")) {
                    sql = "SELECT t_epregunta.Id, t_epregunta.Nbre, t_epregunta.Id_tipor, t_epregunta.`CValor` FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_tipoproceso.Id = t_e_tipo_encuesta_detalle.Id_TipoProceso) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN t_tipoencuestaxpregunta  ON (t_tipoencuestaxpregunta.Id_Tipo_Encuesta = t_encuestas.Id) INNER JOIN t_epregunta  ON (t_tipoencuestaxpregunta.Id_Pregunta = t_epregunta.Id) WHERE (t_e_tipo_encuesta_detalle.Id ='" + this.xidtipoencuesta[this.JCBNEncuentas.getSelectedIndex()] + "' AND t_tipoencuestaxpregunta.Estado=1) ORDER BY t_tipoencuestaxpregunta.Orden ASC  ";
                } else if (this.xnombre.equals("xjifregistroencuesta1")) {
                    sql = "SELECT t_epregunta.Id, t_epregunta.Nbre, t_epregunta.Id_tipor, t_epregunta.`CValor` FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN t_tipoencuestaxpregunta  ON (t_tipoencuestaxpregunta.Id_Tipo_Encuesta = t_encuestas.Id) INNER JOIN t_epregunta  ON (t_tipoencuestaxpregunta.Id_Pregunta = t_epregunta.Id) WHERE (t_e_tipo_encuesta_detalle.Id ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoEncuesta() + "' AND t_tipoencuestaxpregunta.Estado=1) ORDER BY t_tipoencuestaxpregunta.Orden ASC ";
                }
                ResultSet rs = this.xct.traerRs(sql);
                TableColumnModel cmodel = this.JTDetalle.getColumnModel();
                TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
                cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
                TextAreaEditor textEditor = new TextAreaEditor();
                cmodel.getColumn(1).setCellEditor(textEditor);
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 0;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                            this.xmodelo.setValueAt(rs.getString(2), x, 1);
                            this.xmodelo.setValueAt("", x, 2);
                            this.xmodelo.setValueAt("", x, 3);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(3)), x, 4);
                            this.xmodelo.setValueAt(new Integer(0), x, 5);
                            this.xmodelo.setValueAt(new Integer(0), x, 6);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(4)), x, 7);
                            x++;
                        }
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    this.xct.mostrarErrorSQL(ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un área", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProceso.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBNEncuentas.requestFocus();
    }

    public void mGrabar() {
        if (this.xnombre.equals("xjifregistroencuesta") || this.xnombre.equals("xjifregistroencuesta1") || this.xnombre.equals("xjifregistroencuesta3")) {
            mVerificarFLlenadoEncuesta(this.JTDetalle, 7);
            if (this.xposfila == -1) {
                mGrabar2();
                return;
            } else if (!this.xmodelo.getValueAt(this.xposfila, 6).toString().equals("0")) {
                mGrabar2();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Faltan digitar valor de respuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTDetalle.requestFocus();
                return;
            }
        }
        if (this.xnombre.equals("xjifregistroencuesta2")) {
            mGrabar1();
        }
    }

    private void mGrabar2() {
        if (this.JCBNEncuentas.getSelectedIndex() != -1) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                if (Principal.txtNo.getText().isEmpty()) {
                    if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 2)) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into t_encuestas_registro (FechaEncuestas, Id_TipoEncuestaD, ObservacionG , Id_Ingreso, UsuarioS, Fecha)  values('" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xidtipoencuesta[this.JCBNEncuentas.getSelectedIndex()] + "','" + this.JTAObservacionG.getText() + "','" + getXidingreso() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "')";
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                            this.xct.cerrarConexionBd();
                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                String sql2 = "insert into t_detalle_encuesta_registro(Id_Encuestas, Id_Pregunta, Id_Respuesta, ObservacionG, ValorN) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 6) + "')";
                                this.xct.ejecutarSQL(sql2);
                                this.xct.cerrarConexionBd();
                            }
                            mCierreEncuestaUsuario();
                            mActualizarSolicitud();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Faltan respuestas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un área", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProceso.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBNEncuentas.requestFocus();
    }

    public void mGrabar1() {
        if (this.JCBNEncuentas.getSelectedIndex() != -1) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 2)) {
                    try {
                        String sql = "insert into t_encuestas_registro (FechaEncuestas, Id_TipoEncuestaD, ObservacionG , Id_Ingreso, UsuarioS, Fecha)  values('" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xidtipoencuesta[this.JCBNEncuentas.getSelectedIndex()] + "','" + this.JTAObservacionG.getText() + "','" + getXidingreso() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "')";
                        String xid = this.xct.ejecutarSQLId(sql);
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                            String sql2 = "insert into t_detalle_encuesta_registro(Id_Encuestas, Id_Pregunta, Id_Respuesta, ObservacionG) values('" + xid + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + this.xmodelo.getValueAt(y, 3) + "')";
                            this.xct.ejecutarSQL(sql2);
                            this.xct.cerrarConexionBd();
                        }
                        mCierreEncuestaUsuario();
                        mActualizarSolicitud();
                        dispose();
                        Principal.clasefacturacion.frmFacturac.setSelected(true);
                        return;
                    } catch (PropertyVetoException e) {
                        Logger.getLogger(JIFEncuestaS.class.getName()).log(Level.SEVERE, (String) null, e);
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Faltan respuestas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un área", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProceso.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBNEncuentas.requestFocus();
    }

    private void mActualizarSolicitud() {
        String xsql = "update s_solicitud set Id_Encuesta='" + Principal.txtNo.getText() + "' where Id='" + Principal.informacionGeneralPrincipalDTO.getIdSolicitudEncuesta() + "'";
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCierreEncuestaUsuario() {
        if (this.xnombre.equals("xjifregistroencuesta1")) {
            String sql = "update t_e_tipo_encuesta_detalle set Diligencio=1, FechaD='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoEncuesta() + "' and Id_UsuarioG='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        }
    }

    public long getXidingreso() {
        return this.xidingreso;
    }

    public void setXidingreso(long xidingreso) {
        this.xidingreso = xidingreso;
    }

    private void mLLenarEncuesta() {
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT t_e_tipo_encuesta_detalle.Id, t_encuestas.Nbre FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (t_e_tipo_encuesta_detalle.Diligencio =0 AND t_e_tipo_encuesta_detalle.Id ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoEncuesta() + "' AND s_sgc_procesos.Id ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "') ";
        this.xidtipoencuesta = xct2.llenarCombo(this.xsql, this.xidtipoencuesta, this.JCBNEncuentas);
        mCargarDetalle();
        xct2.cerrarConexionBd();
    }

    public void mVerificarFLlenadoEncuesta(JTable xjtabla, int xpos) {
        this.xposfila = -1;
        if (xjtabla.getRowCount() > 0) {
            for (int i = 0; i < xjtabla.getRowCount(); i++) {
                if (xjtabla.getValueAt(i, xpos).toString().equals("1")) {
                    this.xposfila = i;
                    return;
                }
            }
        }
    }
}
