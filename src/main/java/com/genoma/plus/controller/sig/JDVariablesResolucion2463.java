package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl;
import com.genoma.plus.dao.sig.Resolucion2463_DAO;
import com.genoma.plus.dto.sig.JDVariablesResolucion2463DTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JDVariablesResolucion2463.class */
public class JDVariablesResolucion2463 extends JDialog {
    private JIFFConsultarInfoRes2463 xjiffRes2463;
    private JRadioButton xjrButon;
    private String xIdVariable;
    private DefaultTableModel xModelo;
    private Resolucion2463_DAO xResolucion2463_DAO;
    private Object[] xDato;
    private Metodos xmt;
    private JButton JBTEjecutar;
    private JButton JBTSalir;
    private JLabel JLBTitulo;
    private JScrollPane JSP_RDetalle;
    private JTable JTB_RDetalle_Datos;

    public JDVariablesResolucion2463(Frame parent, boolean modal, String xIdVarible, JIFFConsultarInfoRes2463 xjiffRes2463, JRadioButton xjrButon) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xjiffRes2463 = xjiffRes2463;
        this.xjrButon = xjrButon;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xIdVariable = xIdVarible;
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xResolucion2463_DAO = (Resolucion2463_DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("resolucion2463DAOImpl");
    }

    private void mNuevo() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLBTitulo = new JLabel();
        this.JSP_RDetalle = new JScrollPane();
        this.JTB_RDetalle_Datos = new JTable();
        this.JBTEjecutar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JLBTitulo.setFont(new Font("Arial", 1, 16));
        this.JLBTitulo.setForeground(Color.red);
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("ACTUALIZACIÓN DE INFORMACIÓN");
        this.JLBTitulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JSP_RDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_RDetalle_Datos.setFont(new Font("Arial", 1, 12));
        this.JTB_RDetalle_Datos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RDetalle_Datos.setRowHeight(25);
        this.JTB_RDetalle_Datos.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_RDetalle_Datos.setSelectionForeground(Color.red);
        this.JSP_RDetalle.setViewportView(this.JTB_RDetalle_Datos);
        this.JBTEjecutar.setFont(new Font("Arial", 1, 12));
        this.JBTEjecutar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTEjecutar.setText("Ejecutar");
        this.JBTEjecutar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JDVariablesResolucion2463.1
            public void actionPerformed(ActionEvent evt) {
                JDVariablesResolucion2463.this.JBTEjecutarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JDVariablesResolucion2463.2
            public void actionPerformed(ActionEvent evt) {
                JDVariablesResolucion2463.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_RDetalle, -1, 715, 32767).addComponent(this.JLBTitulo, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTEjecutar, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 335, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_RDetalle, -1, 329, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEjecutar, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        try {
            dispose();
            this.xjiffRes2463.setSelected(true);
        } catch (PropertyVetoException e) {
            Logger.getLogger(JDVariablesResolucion2463.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEjecutarActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea actualizar la Variable?  " + this.xIdVariable, "Actualizar por Lotes", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
            try {
                mActualizar();
                this.xjiffRes2463.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JDVariablesResolucion2463.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mActualizar() {
        this.xResolucion2463_DAO.mEjecutarSqlJDialog2463(this.xmt.formatoAMD1.format(this.xjiffRes2463.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.xjiffRes2463.JDFechaF.getDate()), this.JTB_RDetalle_Datos, this.xModelo, this.xjrButon);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Descripción", "Nsql", "Estado Proceso", "Actualizar", "NParametros", "Orden"}) { // from class: com.genoma.plus.controller.sig.JDVariablesResolucion2463.3
            Class[] types = {String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_RDetalle_Datos.setModel(this.xModelo);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_RDetalle_Datos.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        mCrearModelo();
        List<JDVariablesResolucion2463DTO> list = this.xResolucion2463_DAO.mCargarDatosSql2463(this.xIdVariable);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getXDescripcion(), x, 0);
            this.xModelo.setValueAt(list.get(x).getXNSql(), x, 1);
            this.xModelo.setValueAt("", x, 2);
            this.xModelo.setValueAt(true, x, 3);
            this.xModelo.setValueAt(Long.valueOf(list.get(x).getXNParametros()), x, 4);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getXOrden()), x, 5);
        }
    }
}
