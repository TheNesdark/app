package com.genoma.plus.controller.historia;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.AtencionDietaDTO;
import com.genoma.plus.jpa.service.IAtencionDietaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JDObservacionDietaSuspendida.class */
public class JDObservacionDietaSuspendida extends JDialog {
    private Long idAtencion;
    private AtencionDietaDTO xAtencionDietaDTO;
    private final IAtencionDietaDAO xIAtencionDietaDAO;
    private JButton JBGuardar;
    private JButton JBSalir;
    private JPanel JPIDatos;
    private JTextArea JTAObservasion;
    private JScrollPane jScrollPane1;

    public JDObservacionDietaSuspendida(Frame parent, boolean modal, Long id) {
        super(parent, modal);
        this.idAtencion = 0L;
        this.xIAtencionDietaDAO = (IAtencionDietaDAO) Principal.contexto.getBean(IAtencionDietaDAO.class);
        initComponents();
        setLocationRelativeTo(this);
        this.idAtencion = id;
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservasion = new JTextArea();
        this.JBSalir = new JButton();
        this.JBGuardar = new JButton();
        setDefaultCloseOperation(2);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN DE SUSPENSIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTAObservasion.setColumns(20);
        this.JTAObservasion.setRows(5);
        this.jScrollPane1.setViewportView(this.JTAObservasion);
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JDObservacionDietaSuspendida.1
            public void actionPerformed(ActionEvent evt) {
                JDObservacionDietaSuspendida.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Ok");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JDObservacionDietaSuspendida.2
            public void actionPerformed(ActionEvent evt) {
                JDObservacionDietaSuspendida.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 531, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JBGuardar, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBSalir, -2, 186, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBSalir, -2, 54, -2).addComponent(this.JBGuardar, -2, 54, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTAObservasion.getText().isEmpty() && this.idAtencion.longValue() > 0) {
            this.xIAtencionDietaDAO.update(Boolean.FALSE, this.JTAObservasion.getText(), this.idAtencion);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
