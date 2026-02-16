package Laboratorio;

import Facturacion.Facturac;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JD_TipoRechazo.class */
public class JD_TipoRechazo extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private String xObjeto_Llamador;
    private RecepcionAuto xjif_recep;
    private Facturac xjif_facturac;
    private int xTipo;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Detalle;
    private JTextPane JTAObservacion;
    private JTable JTB_Detalle;

    public JD_TipoRechazo(Frame parent, boolean modal, JInternalFrame xjf, int xTipo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xObjeto_Llamador = "";
        this.xTipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(xjf);
        this.xTipo = xTipo;
        mCargar_Datos_Tabla();
        m_Realizar_Casting(xjf);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        setDefaultCloseOperation(2);
        setTitle("MOTIVO DE DEVOLUCIÓN DE MUESTRA");
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle.setToolTipText("Haga click sobre la fila para seleccionar el motivo de rechazo");
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_Detalle.setSelectionMode(0);
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JD_TipoRechazo.1
            public void mouseClicked(MouseEvent evt) {
                JD_TipoRechazo.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JTB_Detalle.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JD_TipoRechazo.2
            public void keyPressed(KeyEvent evt) {
                JD_TipoRechazo.this.JTB_DetalleKeyPressed(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Aceptar");
        this.JBT_Grabar.setEnabled(false);
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: Laboratorio.JD_TipoRechazo.3
            public void actionPerformed(ActionEvent evt) {
                JD_TipoRechazo.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Grabar.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JD_TipoRechazo.4
            public void keyPressed(KeyEvent evt) {
                JD_TipoRechazo.this.JBT_GrabarKeyPressed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Laboratorio.JD_TipoRechazo.5
            public void actionPerformed(ActionEvent evt) {
                JD_TipoRechazo.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_Salir.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JD_TipoRechazo.6
            public void keyPressed(KeyEvent evt) {
                JD_TipoRechazo.this.JBT_SalirKeyPressed(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 250, -2)).addComponent(this.JSPObservacion)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Detalle, -2, 237, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 69, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 53, -2).addComponent(this.JBT_Salir, -2, 53, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleKeyPressed(KeyEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
            if (evt.getKeyCode() == 10) {
                this.JBT_Grabar.setEnabled(true);
                this.JBT_Grabar.requestFocus();
                return;
            }
            return;
        }
        this.JBT_Grabar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JTB_Detalle.getSelectedRow() != -1) {
            mAsignarDato();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirKeyPressed(KeyEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
            this.JBT_Grabar.setEnabled(true);
            this.JBT_Grabar.requestFocus();
        } else {
            this.JBT_Grabar.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
            mAsignarDato();
        }
    }

    private void mAsignarDato() {
        try {
            if (this.xObjeto_Llamador.equals("Recepcion")) {
                this.xjif_recep.modelo.setValueAt(this.JTAObservacion.getText(), this.xjif_recep.grid.getSelectedRow(), 6);
                this.xjif_recep.modelo.setValueAt(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 0), this.xjif_recep.grid.getSelectedRow(), 7);
                dispose();
                this.xjif_recep.setSelected(true);
            } else if (this.xObjeto_Llamador.equals("Facturacion")) {
                this.xjif_facturac.frmOrdenes.modelo.setValueAt(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 0), this.xjif_facturac.frmOrdenes.gridDetalle.getSelectedRow(), 19);
                this.xjif_facturac.frmOrdenes.modelo.setValueAt(this.JTAObservacion.getText(), this.xjif_facturac.frmOrdenes.gridDetalle.getSelectedRow(), 20);
                dispose();
                this.xjif_facturac.setSelected(true);
            }
        } catch (PropertyVetoException e) {
            Logger.getLogger(JD_TipoRechazo.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_Modelo_Dato() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Motivo"}) { // from class: Laboratorio.JD_TipoRechazo.7
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void mCargar_Datos_Tabla() {
        try {
            mCrear_Modelo_Dato();
            this.xsql = "SELECT `Id` , `Nbre` FROM `l_tipo_rechazo` WHERE (`Id` <>1 AND `Estado` =1 and Tipo='" + this.xTipo + "') ORDER BY `Nbre` ASC ";
            System.err.println("rechazo" + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                this.JTAObservacion.setText("");
                this.xmt.mEstablecerTextEditor(this.JTB_Detalle, 1);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JD_TipoRechazo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void m_Realizar_Casting(JInternalFrame frm) {
        if (frm.getName().equals("Recepcion") || frm.getName().equals("xjifrecepcionlab")) {
            this.xjif_recep = (RecepcionAuto) frm;
            this.xObjeto_Llamador = "Recepcion";
        } else if (frm.getName().equals("Facturac")) {
            this.xjif_facturac = (Facturac) frm;
            this.xObjeto_Llamador = "Facturacion";
        }
    }
}
