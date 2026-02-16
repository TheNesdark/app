package com.genoma.plus.controller.comprabs;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.comprabs.CierreOrdenDAO;
import com.genoma.plus.dao.impl.comprabs.CierreOrdenDAOImpl;
import com.genoma.plus.dto.comprabs.CierreOrdenDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/comprabs/JDCierreOrden.class */
public class JDCierreOrden extends JDialog {
    private Metodos xmt;
    private CierreOrdenDAO xCierreOrdenDAO;
    private int xgrabar;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JDateChooser JDCFechaC;
    private JLabel JLBCNCierre;
    private JScrollPane JSPCObservacion;
    private JTextPane JTAObservacion;
    private JPanel jPanel1;

    public JDCierreOrden(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xgrabar = 0;
        initComponents();
        springStart();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("CIERRE DE ORDENES");
        mNuevo();
    }

    private void springStart() {
        this.xCierreOrdenDAO = (CierreOrdenDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("cierreOrdenDAO");
    }

    public void mNuevo() {
        this.JDCFechaC.setDate(this.xmt.getFechaActual());
        this.JTAObservacion.setText("");
        mCargarDatos(String.valueOf(Principal.txtNo.getText()));
    }

    public void mGrabar() {
        if (this.xgrabar != 1) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    CierreOrdenDTO e = new CierreOrdenDTO();
                    e.setFecha(this.xmt.formatoAMD.format(this.JDCFechaC.getDate()));
                    e.setIdOrdenCompra(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    e.setObservacion(this.JTAObservacion.getText());
                    e.setEstado(1);
                    this.xCierreOrdenDAO.create(e);
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar una Observacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTAObservacion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Este cierre ya esta grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mCargarDatos(String xidOrdenCompra) {
        List<CierreOrdenDTO> list = this.xCierreOrdenDAO.list(xidOrdenCompra);
        if (list.size() != 0) {
            this.JLBCNCierre.setText(String.valueOf(list.get(0).getId()));
            this.JDCFechaC.setDate(Date.valueOf(list.get(0).getFecha()));
            this.JTAObservacion.setText(list.get(0).getObservacion());
            this.xgrabar = 1;
            return;
        }
        this.xgrabar = 0;
    }

    private void initComponents() {
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.jPanel1 = new JPanel();
        this.JDCFechaC = new JDateChooser();
        this.JSPCObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JLBCNCierre = new JLabel();
        setDefaultCloseOperation(2);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JDCierreOrden.1
            public void actionPerformed(ActionEvent evt) {
                JDCierreOrden.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JDCierreOrden.2
            public void actionPerformed(ActionEvent evt) {
                JDCierreOrden.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACON", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPCObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPCObservacion.setViewportView(this.JTAObservacion);
        this.JLBCNCierre.setBackground(new Color(255, 255, 255));
        this.JLBCNCierre.setFont(new Font("Arial", 1, 24));
        this.JLBCNCierre.setHorizontalAlignment(0);
        this.JLBCNCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cierre", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPCObservacion).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFechaC, -2, 146, -2).addGap(123, 123, 123).addComponent(this.JLBCNCierre, -1, 181, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaC, -2, -1, -2).addComponent(this.JLBCNCierre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCObservacion, -1, 137, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -1, 230, 32767).addGap(4, 4, 4))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
