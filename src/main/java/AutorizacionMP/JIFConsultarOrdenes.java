package AutorizacionMP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultarOrdenes.class */
public class JIFConsultarOrdenes extends JInternalFrame {
    private Object[] xdato;
    private DefaultTableModel xmodeloorden;
    private DefaultTableModel xmodeloitems;
    private JIFAutorizaciones1 xjif;
    private ButtonGroup JBGEstado;
    private JButton JBTCerrar;
    private JPanel JPIEstado;
    private JPanel JPIInformacion;
    private JRadioButton JRBDespachada;
    private JRadioButton JRBEntregada;
    private JRadioButton JRBPorEntregar;
    private JScrollPane JSPDatosDetalle;
    private JScrollPane JSPDatosOrdenes;
    private JTable JTBDatosDetalle;
    private JTable JTBDatosOrdenes;
    private JFormattedTextField JTFFNQuincena;
    private JFormattedTextField JTFFNTratamientoMax;
    private JFormattedTextField JTFFValorDescuento;
    private JFormattedTextField JTFFValorOrden;
    private JFormattedTextField JTFFValorTratamiento;
    private int xestado = 0;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public JIFConsultarOrdenes(JIFAutorizaciones1 xjif) {
        initComponents();
        this.xjif = xjif;
        mCargarTable();
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JSPDatosOrdenes = new JScrollPane();
        this.JTBDatosOrdenes = new JTable();
        this.JBTCerrar = new JButton();
        this.JSPDatosDetalle = new JScrollPane();
        this.JTBDatosDetalle = new JTable();
        this.JPIEstado = new JPanel();
        this.JRBPorEntregar = new JRadioButton();
        this.JRBDespachada = new JRadioButton();
        this.JRBEntregada = new JRadioButton();
        this.JPIInformacion = new JPanel();
        this.JTFFValorOrden = new JFormattedTextField();
        this.JTFFValorTratamiento = new JFormattedTextField();
        this.JTFFValorDescuento = new JFormattedTextField();
        this.JTFFNQuincena = new JFormattedTextField();
        this.JTFFNTratamientoMax = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarmedicamentos");
        setPreferredSize(new Dimension(1181, 717));
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFConsultarOrdenes.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFConsultarOrdenes.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JSPDatosOrdenes.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTBDatosOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTBDatosOrdenes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosOrdenes.setRowHeight(25);
        this.JTBDatosOrdenes.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosOrdenes.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosOrdenes.setSelectionMode(0);
        this.JTBDatosOrdenes.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultarOrdenes.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarOrdenes.this.JTBDatosOrdenesMouseClicked(evt);
            }
        });
        this.JSPDatosOrdenes.setViewportView(this.JTBDatosOrdenes);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(new Color(0, 0, 204));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarOrdenes.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarOrdenes.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JSPDatosDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDatosDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDatosDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosDetalle.setRowHeight(25);
        this.JTBDatosDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosDetalle.setSelectionMode(0);
        this.JSPDatosDetalle.setViewportView(this.JTBDatosDetalle);
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGEstado.add(this.JRBPorEntregar);
        this.JRBPorEntregar.setFont(new Font("Arial", 1, 12));
        this.JRBPorEntregar.setForeground(Color.blue);
        this.JRBPorEntregar.setSelected(true);
        this.JRBPorEntregar.setText("Impresa");
        this.JRBPorEntregar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarOrdenes.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarOrdenes.this.JRBPorEntregarActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBDespachada);
        this.JRBDespachada.setFont(new Font("Arial", 1, 12));
        this.JRBDespachada.setForeground(Color.blue);
        this.JRBDespachada.setText("Despachada/Autorizada");
        this.JRBDespachada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarOrdenes.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarOrdenes.this.JRBDespachadaActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBEntregada);
        this.JRBEntregada.setFont(new Font("Arial", 1, 12));
        this.JRBEntregada.setForeground(Color.blue);
        this.JRBEntregada.setText("Empacada");
        this.JRBEntregada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarOrdenes.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarOrdenes.this.JRBEntregadaActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPorEntregar).addGap(18, 18, 18).addComponent(this.JRBEntregada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBDespachada).addContainerGap()));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorEntregar).addComponent(this.JRBDespachada).addComponent(this.JRBEntregada)));
        this.JPIInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 18), Color.red), "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFValorOrden.setEditable(false);
        this.JTFFValorOrden.setBackground(new Color(0, 0, 153));
        this.JTFFValorOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Orden", 2, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.JTFFValorOrden.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorOrden.setHorizontalAlignment(0);
        this.JTFFValorOrden.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorOrden.setEnabled(false);
        this.JTFFValorOrden.setFont(new Font("Arial", 1, 16));
        this.JTFFValorTratamiento.setEditable(false);
        this.JTFFValorTratamiento.setBackground(new Color(0, 0, 153));
        this.JTFFValorTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Tratamiento", 2, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.JTFFValorTratamiento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTratamiento.setHorizontalAlignment(0);
        this.JTFFValorTratamiento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorTratamiento.setEnabled(false);
        this.JTFFValorTratamiento.setFont(new Font("Arial", 1, 16));
        this.JTFFValorDescuento.setEditable(false);
        this.JTFFValorDescuento.setBackground(new Color(0, 0, 153));
        this.JTFFValorDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Descuento", 2, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.JTFFValorDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDescuento.setHorizontalAlignment(0);
        this.JTFFValorDescuento.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFValorDescuento.setEnabled(false);
        this.JTFFValorDescuento.setFont(new Font("Arial", 1, 16));
        this.JTFFNQuincena.setEditable(false);
        this.JTFFNQuincena.setBackground(new Color(0, 0, 153));
        this.JTFFNQuincena.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Quincenas", 2, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.JTFFNQuincena.setHorizontalAlignment(0);
        this.JTFFNQuincena.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFNQuincena.setEnabled(false);
        this.JTFFNQuincena.setFont(new Font("Arial", 1, 16));
        this.JTFFNTratamientoMax.setEditable(false);
        this.JTFFNTratamientoMax.setBackground(new Color(0, 0, 153));
        this.JTFFNTratamientoMax.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Max Tratamiento", 2, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.JTFFNTratamientoMax.setHorizontalAlignment(0);
        this.JTFFNTratamientoMax.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFNTratamientoMax.setEnabled(false);
        this.JTFFNTratamientoMax.setFont(new Font("Arial", 1, 16));
        GroupLayout JPIInformacionLayout = new GroupLayout(this.JPIInformacion);
        this.JPIInformacion.setLayout(JPIInformacionLayout);
        JPIInformacionLayout.setHorizontalGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInformacionLayout.createSequentialGroup().addComponent(this.JTFFValorOrden, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFNTratamientoMax, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFValorTratamiento, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFValorDescuento, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFNQuincena, -2, 130, -2).addContainerGap(-1, 32767)));
        JPIInformacionLayout.setVerticalGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIInformacionLayout.createSequentialGroup().addGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorOrden, -2, 60, -2).addComponent(this.JTFFNTratamientoMax, -2, 60, -2).addComponent(this.JTFFValorTratamiento, -2, 60, -2).addComponent(this.JTFFValorDescuento, -2, 60, -2).addComponent(this.JTFFNQuincena, -2, 60, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatosOrdenes, -1, 1145, 32767).addComponent(this.JSPDatosDetalle, -1, 1131, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPIInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstado, -1, -1, 32767).addComponent(this.JBTCerrar, -1, -1, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosOrdenes, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosDetalle, -2, 279, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar)).addComponent(this.JPIInformacion, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap(25, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        cerrar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntregadaActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mCargarTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorEntregarActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mCargarTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDespachadaActionPerformed(ActionEvent evt) {
        this.xestado = 2;
        mCargarTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosOrdenesMouseClicked(MouseEvent evt) {
        if (this.JTBDatosOrdenes.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea cargar la orden para modificarla?", "CARGAR ORDEN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjif.frmOrdenesSuministr.mBuscarSuministro(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0).toString(), true);
                this.xjif.frmOrdenesSuministr.JTFNordenSum.setText(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0).toString());
                dispose();
                return;
            }
            mCargarItemSuministro();
            if (!this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 8).toString().isEmpty() || !this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 9).toString().isEmpty()) {
                Object[] botones = {"Formula", "Guía de Envió", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, (Icon) null, botones, "Cerrar");
                if (n == 0) {
                    this.xmetodos.mostrarPdf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 8).toString());
                } else if (n == 1) {
                    this.xmetodos.mostrarPdf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 9).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
    }

    private void cerrar() {
        if (Principal.PanelPpal.getComponent(1).getName().equals("jifautorizacion")) {
            try {
                this.xjif.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFConsultarOrdenes.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mCargarTable() {
        this.xmodeloorden = new DefaultTableModel();
        this.xmodeloorden.addColumn("N° Orden");
        this.xmodeloorden.addColumn("Fecha");
        this.xmodeloorden.addColumn("Profesional o Clinica");
        this.xmodeloorden.addColumn("Ciudad");
        this.xmodeloorden.addColumn("Fecha Atención");
        this.xmodeloorden.addColumn("");
        this.xmodeloorden.addColumn("Tipo");
        this.xmodeloorden.addColumn("N° Descuento");
        this.xmodeloorden.addColumn("Soporte");
        this.xmodeloorden.addColumn("Soporte Guia");
        this.xmodeloorden.addColumn("Estado");
        this.JTBDatosOrdenes.setModel(this.xmodeloorden);
        this.JTBDatosOrdenes.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDatosOrdenes.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDatosOrdenes.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDatosOrdenes.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDatosOrdenes.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosOrdenes.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDatosOrdenes.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTBDatosOrdenes.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosOrdenes.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosOrdenes.getColumnModel().getColumn(10).setMaxWidth(0);
        mTraerDatosTablaOrdenes();
    }

    private void mTraerDatosTablaOrdenes() {
        try {
            String sql = "SELECT h_ordenes.Id AS IdOrden, DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m%/%Y') as FechaOrden, profesional.NProfesional, g_municipio.Nbre, DATE_FORMAT(h_atencion.Fecha_Atencion,'%d/%m%/%Y') as FechaAtencion ,h_atencion.Id, h_ordenes.EstaEntregada, concat(h_ordenes.NoFormInicio,' de ' ,h_ordenes.NoFormuFin) as tipo, h_ordenes.UrlSoporte, h_ordenes.UrlGuiaEnvio, h_ordenes.EstaEntregada  FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN  ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN  g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN  profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN  g_municipio  ON (g_municipio.Id = h_ordenes.IdMunicipio) WHERE (ingreso.Id_Usuario ='" + this.xjif.frmPersona.getIdPersona() + "' AND h_ordenes.Estado =0 and h_ordenes.EstaEntregada='" + this.xestado + "' AND h_ordenes.`Id_TipoServicio`=7 ) ORDER BY h_ordenes.FechaOrden DESC";
            ConsultasMySQL xt = new ConsultasMySQL();
            ResultSet rs = xt.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloorden.addRow(this.xdato);
                    this.xmodeloorden.setValueAt(rs.getString(1), i, 0);
                    this.xmodeloorden.setValueAt(rs.getString(2), i, 1);
                    this.xmodeloorden.setValueAt(rs.getString(3), i, 2);
                    this.xmodeloorden.setValueAt(rs.getString(4), i, 3);
                    this.xmodeloorden.setValueAt(rs.getString(5), i, 4);
                    this.xmodeloorden.setValueAt(rs.getString(6), i, 5);
                    this.xmodeloorden.setValueAt(rs.getString(8), i, 6);
                    this.xmodeloorden.setValueAt(mBuscarNDescuento(rs.getLong(6)), i, 7);
                    this.xmodeloorden.setValueAt(this.xmetodos.mTraerUrlBD(rs.getString(9)), i, 8);
                    this.xmodeloorden.setValueAt(this.xmetodos.mTraerUrlBD(rs.getString(10)), i, 9);
                    this.xmodeloorden.setValueAt(rs.getString(11), i, 10);
                    this.JTBDatosOrdenes.setDefaultRenderer(Object.class, new MiRender1());
                    i++;
                }
                rs.close();
            }
            xt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultarOrdenes$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 10).toString().equals("0")) {
                cell.setBackground(Color.WHITE);
            } else if (table.getValueAt(row, 10).toString().equals("1")) {
                cell.setBackground(new Color(255, 153, 153));
            } else if (table.getValueAt(row, 10).toString().equals("2")) {
                cell.setBackground(new Color(177, 251, 177));
            }
            return cell;
        }
    }

    private String mBuscarNDescuento(long xv) {
        String xndescuento = null;
        ConsultasMySQL xtm = new ConsultasMySQL();
        try {
            ResultSet rs1 = xtm.traerRs("SELECT Id FROM d_descuento WHERE (Id_HAtencion ='" + xv + "' and d_descuento.Estado=0)");
            if (rs1.next()) {
                rs1.first();
                xndescuento = rs1.getString(1);
            } else {
                xndescuento = "0";
            }
            rs1.close();
            xtm.cerrarConexionBd();
            return xndescuento;
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return xndescuento;
        }
    }

    private void mCargarItemSuministro() {
        this.xmodeloitems = new DefaultTableModel();
        this.xmodeloitems.addColumn("Producto");
        this.xmodeloitems.addColumn("Principio Activo");
        this.xmodeloitems.addColumn("Posologia");
        this.xmodeloitems.addColumn("Cantidad");
        this.xmodeloitems.addColumn("V/Unitario");
        this.xmodeloitems.addColumn("V/Total");
        this.JTBDatosDetalle.setModel(this.xmodeloitems);
        this.JTBDatosDetalle.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTBDatosDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDatosDetalle.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTBDatosDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBDatosDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        mTraerDatosTablaItems(Long.valueOf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0).toString()).longValue(), Long.valueOf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 5).toString()).longValue());
    }

    private void mTraerDatosTablaItems(long norden, long natencion) {
        String sql;
        String sql2;
        try {
            if (!this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString().equals("0")) {
                sql = "SELECT i_suministro.Nbre, i_concentracion.Nbre, i_presentacioncomercial.Nbre, i_principioactivo.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, h_itemordenessum.ValorUnitario, h_itemordenessum.ValorTotal, d_descuento.Valor, d_descuento.NQuincenas FROM  h_ordenes INNER JOIN  h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id)INNER JOIN  h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN  i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN  i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN  i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN  i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN  i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN  d_descuento  ON (d_descuento.Id_HAtencion = h_atencion.Id) WHERE (h_ordenes.Id ='" + norden + "' and h_itemordenessum.Estado=1) ORDER BY i_suministro.Nbre ASC ";
            } else {
                sql = "SELECT i_suministro.Nbre, i_concentracion.Nbre, i_presentacioncomercial.Nbre, i_principioactivo.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, h_itemordenessum.ValorUnitario, h_itemordenessum.ValorTotal, h_ordenes.EstaEntregada, h_ordenes.Estado FROM  h_ordenes INNER JOIN  h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id)INNER JOIN  h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN  i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN  i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN  i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN  i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN  i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) WHERE (h_ordenes.Id ='" + norden + "' and h_itemordenessum.Estado=1) ORDER BY i_suministro.Nbre ASC ";
            }
            ConsultasMySQL xt = new ConsultasMySQL();
            ResultSet rs = xt.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                long valor = 0;
                while (rs.next()) {
                    this.xmodeloitems.addRow(this.xdato);
                    this.xmodeloitems.setValueAt(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3), i, 0);
                    this.xmodeloitems.setValueAt(rs.getString(4), i, 1);
                    this.xmodeloitems.setValueAt(rs.getString(5) + " x " + rs.getString(6), i, 2);
                    this.xmodeloitems.setValueAt(rs.getString(7), i, 3);
                    this.xmodeloitems.setValueAt(rs.getString(8), i, 4);
                    this.xmodeloitems.setValueAt(rs.getString(9), i, 5);
                    valor += rs.getLong(9);
                    i++;
                }
                rs.first();
                if (!this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString().equals("0")) {
                    this.JTFFValorDescuento.setValue(Long.valueOf(rs.getLong(10)));
                    sql2 = "SELECT sum(h_itemordenessum.ValorTotal) as total, max(h_ordenes.NoFormuFin) as ntto FROM  h_ordenes INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN  h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN  d_descuento ON (d_descuento.Id_HAtencion = h_atencion.Id) WHERE (h_atencion.Id ='" + natencion + "') GROUP BY h_atencion.Id ";
                } else {
                    this.JTFFValorDescuento.setValue(0);
                    sql2 = "SELECT sum(h_itemordenessum.ValorTotal) as total, max(h_ordenes.NoFormuFin) as ntto FROM  h_ordenes INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN  h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id)  WHERE (h_atencion.Id ='" + natencion + "') GROUP BY h_atencion.Id ";
                }
                this.JTFFValorOrden.setValue(Long.valueOf(valor));
                if (!this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString().equals("0")) {
                    this.JTFFNQuincena.setValue(Integer.valueOf(rs.getInt(11)));
                } else {
                    this.JTFFNQuincena.setValue(0);
                }
                ConsultasMySQL xr = new ConsultasMySQL();
                ResultSet xrs = xr.traerRs(sql2);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFFValorTratamiento.setValue(Long.valueOf(xrs.getLong(1)));
                    this.JTFFNTratamientoMax.setValue(Integer.valueOf(xrs.getInt(2)));
                }
                xrs.close();
                xr.cerrarConexionBd();
            }
            rs.close();
            xt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void anular() {
        if (this.JTBDatosOrdenes.getSelectedRow() != -1) {
            String string2 = "Todas las Ordenes de la atención N° " + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 5);
            String string3 = "Descuento de Nomina N° " + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7);
            Object[] botones = {"Anular Orden Seleccionada", string2, string3, "Cerrar"};
            ConsultasMySQL xt1 = new ConsultasMySQL();
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                String sql = "Update h_ordenes set Estado=1 where id='" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0) + "'";
                xt1.ejecutarSQL(sql);
                xt1.cerrarConexionBd();
                mCargarTable();
                return;
            }
            if (n == 1) {
                String sql2 = "Update h_ordenes set Estado=1 where id_Atencion='" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 5) + "'";
                xt1.ejecutarSQL(sql2);
                xt1.cerrarConexionBd();
                mAnularDescuento();
                mCargarTable();
                return;
            }
            if (n == 2) {
                mAnularDescuento();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila de la tbla", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mAnularDescuento() {
        if (!this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString().equals("0")) {
            ConsultasMySQL xt2 = new ConsultasMySQL();
            String sql = "Update d_descuento set Estado=1 where Id='" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7) + "'";
            xt2.ejecutarSQL(sql);
            xt2.cerrarConexionBd();
            mCargarTable();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La Orden no tiene descuento generado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void imprimir() {
        if (this.JTBDatosOrdenes.getSelectedRow() != -1) {
            String string1 = "Formula Orden N° " + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0);
            String string2 = "Descuento N° " + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7);
            Object[] botones = {string1, string2, "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea imprimir", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mImprimir(Long.valueOf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0).toString()).longValue(), 1);
                mCambiarEstadoOrden(Long.valueOf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0).toString()).longValue());
            } else if (n == 1) {
                mImprimirDescuento();
            }
        }
    }

    private void mImprimirDescuento() {
        Metodos xmt = new Metodos();
        String[][] mparametros = new String[4][2];
        new convertirNumerosLetras();
        mparametros[0][0] = "ndescuento";
        mparametros[0][1] = this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString();
        mparametros[1][0] = "valorLetras";
        mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.JTFFValorDescuento.getValue().toString());
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = xmt.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = xmt.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(xmt.getRutaRep() + "RDescuentoNomina", mparametros);
        this.xmetodos.GenerarPDF(xmt.getRutaRep() + "RDescuentoNomina_1", mparametros);
    }

    private void mImprimir(long idorden, int n) {
        try {
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String tipo = "Farmacia";
            new convertirNumerosLetras();
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where Id='" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0) + "'";
            new Metodos();
            ResultSet rsm = this.consultas.traerRs(sql);
            if (rsm.next()) {
                rsm.first();
                new Metodos();
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM   h_ordenes where  Id_Atencion='" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 5) + "' and Id>'" + this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 0) + "' order by Id";
                ResultSet xrsm = this.consultas.traerRs(sql2);
                if (xrsm.next()) {
                    xrsm.first();
                    xnotasad = "Orden N° : " + xrsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) xrsm.getDate(3));
                }
                xrsm.close();
                rsm.close();
                this.consultas.cerrarConexionBd();
            }
            String[][] mparametros = new String[8][2];
            String usuario = Principal.usuarioSistemaDTO.getLogin();
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "ndescuento";
                mparametros[0][1] = this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString();
                mparametros[1][0] = "valorLetras";
                mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.JTFFValorDescuento.getValue().toString());
                mparametros[2][0] = "norden";
                mparametros[2][1] = String.valueOf(idorden);
                mparametros[3][0] = "xp2";
                mparametros[3][1] = tipo;
                mparametros[4][0] = "ip";
                mparametros[4][1] = xnotasad;
                mparametros[5][0] = "nusuarios";
                mparametros[5][1] = usuario;
                mparametros[6][0] = "SUBREPORT_DIR";
                mparametros[6][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[7][0] = "SUBREPORTFIRMA_DIR";
                mparametros[7][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                if (Integer.valueOf(this.xmodeloorden.getValueAt(this.JTBDatosOrdenes.getSelectedRow(), 7).toString()).intValue() != 0) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RDescuentoNomina", mparametros);
                }
                String xsql = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + idorden + "') ";
                ResultSet xrs = this.consultas.traerRs(xsql);
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getInt(1) == 1) {
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RFormulaGeneralMP", mparametros);
                    } else {
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros);
                    }
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
                tipo = "Usuario";
            }
            rsm.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mCambiarEstadoOrden(long idor) {
        ConsultasMySQL xt3 = new ConsultasMySQL();
        String sql = "update  h_ordenes set EstaEntregada=1 where Id='" + idor + "'";
        xt3.ejecutarSQL(sql);
        xt3.cerrarConexionBd();
    }
}
