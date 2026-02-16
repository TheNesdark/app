package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JDR_Variables_4505.class */
public class JDR_Variables_4505 extends JDialog {
    private DefaultTableModel xModelo_Datos;
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private String xId_Variable;
    private Object[] xDatos;
    private JIFConsultarInfR4505 xJif_C;
    private JRadioButton xRb_Boton;
    private JButton JBTEjecutar;
    private JButton JBTSalir;
    private JLabel JLBTitulo;
    private JScrollPane JSP_RDetalle;
    private JTable JTB_RDetalle_Datos;

    public JDR_Variables_4505(Frame parent, boolean modal, String xId_Variable, JIFConsultarInfR4505 xjif, JRadioButton xRb_Boton) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        initComponents();
        this.xJif_C = xjif;
        this.xRb_Boton = xRb_Boton;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xId_Variable = xId_Variable;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSP_RDetalle = new JScrollPane();
        this.JTB_RDetalle_Datos = new JTable();
        this.JLBTitulo = new JLabel();
        this.JBTEjecutar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CONSULTA");
        this.JSP_RDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_RDetalle_Datos.setFont(new Font("Arial", 1, 12));
        this.JTB_RDetalle_Datos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RDetalle_Datos.setRowHeight(25);
        this.JTB_RDetalle_Datos.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_RDetalle_Datos.setSelectionForeground(Color.red);
        this.JSP_RDetalle.setViewportView(this.JTB_RDetalle_Datos);
        this.JLBTitulo.setFont(new Font("Arial", 1, 16));
        this.JLBTitulo.setForeground(Color.red);
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("ACTUALIZACIÓN DE INFORMACIÓN");
        this.JLBTitulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JBTEjecutar.setFont(new Font("Arial", 1, 12));
        this.JBTEjecutar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTEjecutar.setText("Ejecutar");
        this.JBTEjecutar.addActionListener(new ActionListener() { // from class: Sig.JDR_Variables_4505.1
            public void actionPerformed(ActionEvent evt) {
                JDR_Variables_4505.this.JBTEjecutarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Sig.JDR_Variables_4505.2
            public void actionPerformed(ActionEvent evt) {
                JDR_Variables_4505.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_RDetalle, -1, 736, 32767).addComponent(this.JLBTitulo, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTEjecutar, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 335, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_RDetalle, -1, 235, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEjecutar, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        try {
            dispose();
            this.xJif_C.setSelected(true);
        } catch (PropertyVetoException e) {
            Logger.getLogger(JDR_Variables_4505.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEjecutarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTB_RDetalle_Datos, 3)) {
            for (int x = 0; x < this.JTB_RDetalle_Datos.getRowCount(); x++) {
                if (!this.xModelo_Datos.getValueAt(x, 1).toString().equals("") && Boolean.valueOf(this.xModelo_Datos.getValueAt(x, 3).toString()).booleanValue()) {
                    try {
                        PreparedStatement xpt = this.xct.establecerConexionBd().prepareStatement(this.xModelo_Datos.getValueAt(x, 1).toString());
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 1) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 2) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 3) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 4) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 5) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 6) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 7) {
                                xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 8) {
                                xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 9) {
                                xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 10) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaI.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 11) {
                                xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 12) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 13) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 14) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 15) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 16) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 17) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 18) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 19) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 20) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 21) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 22) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(11, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(12, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 23) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 24) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 25) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(11, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(12, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 26) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 27) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 28 || Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 29) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            }
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 1) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 2) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 3) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 4) {
                            xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 5) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 6) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 7) {
                            xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 8) {
                            xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 9) {
                            xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 10) {
                            xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaI.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 11) {
                            xpt.setString(1, this.xmt.formatoAMD.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 12) {
                            xpt.setString(1, this.xmt.formatoANO.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 13) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 14) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 15) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 16) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 17) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 18) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 19) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 20) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 21) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 22) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(11, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(12, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 23) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 24) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 25) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(8, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(9, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(10, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(11, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(12, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 26) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(4, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(5, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(6, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(7, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 27) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 4).toString()).intValue() == 28) {
                            xpt.setString(1, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                            xpt.setString(2, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaI.getDate()));
                            xpt.setString(3, this.xmt.formatoAMD1.format(this.xJif_C.JDFechaF.getDate()));
                        }
                        if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 5).toString()).intValue() == 1) {
                            String xSql_Vista = xpt.toString().substring(44, xpt.toString().length());
                            System.out.println("vista antes : " + xSql_Vista);
                            xpt.close();
                            this.xct.cerrarConexionBd();
                            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "CREATE VIEW  `v_r_tmp`  AS " + xSql_Vista;
                            System.out.println(xSql_Vista);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "UPDATE `p_res_4505_r`, `v_r_tmp`  SET p_res_4505_r." + this.xId_Variable + "=v_r_tmp.Valor WHERE p_res_4505_R.`Id_Persona`=v_r_tmp.Id_Persona ";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xRb_Boton.setForeground(Color.red);
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 5).toString()).intValue() == 0) {
                            System.out.println(xpt);
                            String xSql_Vista2 = xpt.toString().substring(44, xpt.toString().length());
                            System.out.println(xSql_Vista2);
                            xpt.execute();
                            xpt.close();
                            this.xct.cerrarConexionBd();
                            this.xRb_Boton.setForeground(Color.red);
                        } else if (Integer.valueOf(this.xModelo_Datos.getValueAt(x, 5).toString()).intValue() == 4) {
                            System.out.println(xpt);
                            String xSql_Vista3 = xpt.toString().substring(44, xpt.toString().length());
                            System.out.println(xSql_Vista3);
                            xpt.execute();
                            xpt.close();
                            this.xct.cerrarConexionBd();
                            this.xRb_Boton.setForeground(Color.red);
                        }
                        this.xModelo_Datos.setValueAt("PROCESADO", x, 2);
                        dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(JDR_Variables_4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Datos() {
        this.xModelo_Datos = new DefaultTableModel(new Object[0], new String[]{"Descripción", "Nsql", "Estado Proceso", "Actualizar", "NParametros", "Tipo"}) { // from class: Sig.JDR_Variables_4505.3
            Class[] types = {String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_RDetalle_Datos.setModel(this.xModelo_Datos);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mNuevo() {
        mCargarDatosTabla();
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModelo_Datos();
            if (this.xJif_C.resolucion.equals("4505")) {
                this.xsql = "SELECT `Descripcion` , `NSql`, `NParametros`, `Tipo` FROM `p_res_4505_sql` WHERE (`NVariable` ='" + this.xId_Variable + "' AND Estado=1) ORDER BY ORDEN ASC ";
            } else if (this.xJif_C.resolucion.equals("202")) {
                this.xsql = "SELECT `Descripcion` , `NSql`, `NParametros`, `Tipo` FROM `p_res_4505_sql_nueva` WHERE (`NVariable` ='" + this.xId_Variable + "' AND Estado=1) ORDER BY ORDEN ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_RDetalle_Datos, 0);
                while (xrs.next()) {
                    this.xModelo_Datos.addRow(this.xDatos);
                    this.xModelo_Datos.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo_Datos.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Datos.setValueAt("", x, 2);
                    this.xModelo_Datos.setValueAt(true, x, 3);
                    this.xModelo_Datos.setValueAt(Long.valueOf(xrs.getLong(3)), x, 4);
                    this.xModelo_Datos.setValueAt(Long.valueOf(xrs.getLong(4)), x, 5);
                    x++;
                }
            } else {
                mCrearModelo_Datos();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDR_Variables_4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
