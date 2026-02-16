package com.genoma.plus.controller.auditoria_medica;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.auditoria_medica.CierreSeguimientoDAO;
import com.genoma.plus.dao.impl.auditoria_medica.CierreSeguimientoDAOImpl;
import com.genoma.plus.dto.auditoria_medica.CierreSeguimientoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JD_Cierre_Seguimiento.class */
public class JD_Cierre_Seguimiento extends JDialog {
    private Metodos xmt;
    private Long xIdSeguimiento;
    private CierreSeguimientoDAO xCierreSeguimiento;
    private JButton JBGuardar;
    private JButton JBT_Salir;
    private JDateChooser JDFechaC;
    private JLabel JLN_NCierre;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;

    public JD_Cierre_Seguimiento(Frame parent, boolean modal, Long xIdSeguimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xIdSeguimiento = xIdSeguimiento;
        springStart();
        mCargarCierre();
    }

    private void initComponents() {
        this.JDFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLN_NCierre = new JLabel();
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CIERRE DE SEGUIMIENTO");
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLN_NCierre.setFont(new Font("Arial", 1, 14));
        this.JLN_NCierre.setHorizontalAlignment(0);
        this.JLN_NCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cierre", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JD_Cierre_Seguimiento.1
            public void actionPerformed(ActionEvent evt) {
                JD_Cierre_Seguimiento.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JD_Cierre_Seguimiento.2
            public void actionPerformed(ActionEvent evt) {
                JD_Cierre_Seguimiento.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 261, -2)).addComponent(this.JSPObservacion, -1, 637, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLN_NCierre, -2, 153, -2))).addGap(14, 14, 14)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaC, -2, 56, -2).addComponent(this.JLN_NCierre, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 174, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGuardar, -2, 44, -2).addComponent(this.JBT_Salir, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (this.JLN_NCierre.getText().isEmpty()) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    try {
                        CierreSeguimientoDTO e = new CierreSeguimientoDTO();
                        e.setFecha(this.xmt.formatoAMD1.format(this.JDFechaC.getDate()));
                        e.setObservacion(this.JTAObservacion.getText());
                        e.setIdSeguimiento(this.xIdSeguimiento.longValue());
                        e.setIdPersonaRh(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                        this.xCierreSeguimiento.create(e);
                        Principal.xclaseAuditoriaMedica.xJIFCierre_Seguimiento.mBuscar();
                        dispose();
                        Principal.xclaseAuditoriaMedica.xJIFCierre_Seguimiento.setSelected(true);
                        return;
                    } catch (PropertyVetoException e2) {
                        Logger.getLogger(JD_Cierre_Seguimiento.class.getName()).log(Level.SEVERE, (String) null, e2);
                        return;
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La observacion no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void springStart() {
        this.xCierreSeguimiento = (CierreSeguimientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("cierreSeguimentoDAO");
    }

    private void mCargarCierre() {
        List<CierreSeguimientoDTO> xlist = this.xCierreSeguimiento.listCierreSeguiento(this.xIdSeguimiento);
        if (!xlist.isEmpty()) {
            this.JLN_NCierre.setText("" + xlist.get(0).getId());
            this.JDFechaC.setDate(this.xmt.getPasarTextoaFecha(xlist.get(0).getFecha()));
            this.JTAObservacion.setText(xlist.get(0).getObservacion());
        } else {
            this.JLN_NCierre.setText("");
            this.JDFechaC.setDate(this.xmt.getFechaActual());
            this.JTAObservacion.setText("");
        }
    }
}
