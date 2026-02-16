package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import com.genoma.plus.dao.historia.AntecedenteFamiliarTextoDAO;
import com.genoma.plus.dao.impl.historia.AntecedenteFamiliarTextoDAOImpl;
import com.genoma.plus.dto.historia.AntecedenteFamiliarTextoDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAntecedenteFamiliarTexto.class */
public class JPAntecedenteFamiliarTexto extends JPanel {
    private AntecedenteFamiliarTextoDAO antecedenteFamiliarTextoDAO;
    private clasesHistoriaCE xClaseHC;
    private JButton JBTGuardar;
    private JScrollPane JSPObservacionExamen;
    public JTextField JTFNNota;
    private JTextPane JTPHObservacionExamenFisico;
    private JLabel lblInicio2;

    public JPAntecedenteFamiliarTexto(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mCargarDato();
    }

    private void springStart() {
        this.antecedenteFamiliarTextoDAO = (AntecedenteFamiliarTextoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("antecedenteFamiliarTextoDAOImpl");
    }

    private void initComponents() {
        this.lblInicio2 = new JLabel();
        this.JSPObservacionExamen = new JScrollPane();
        this.JTPHObservacionExamenFisico = new JTextPane();
        this.JBTGuardar = new JButton();
        this.JTFNNota = new JTextField();
        setName("jpiantecedentesFamiliares");
        setPreferredSize(new Dimension(800, 668));
        setRequestFocusEnabled(false);
        this.lblInicio2.setFont(new Font("Arial", 1, 14));
        this.lblInicio2.setForeground(Color.red);
        this.lblInicio2.setHorizontalAlignment(0);
        this.lblInicio2.setText("ANTECEDENTES FAMILIARES");
        this.JSPObservacionExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHObservacionExamenFisico.setFont(new Font("Arial", 0, 13));
        this.JTPHObservacionExamenFisico.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPAntecedenteFamiliarTexto.1
            public void keyPressed(KeyEvent evt) {
                JPAntecedenteFamiliarTexto.this.JTPHObservacionExamenFisicoKeyPressed(evt);
            }
        });
        this.JSPObservacionExamen.setViewportView(this.JTPHObservacionExamenFisico);
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAntecedenteFamiliarTexto.2
            public void actionPerformed(ActionEvent evt) {
                JPAntecedenteFamiliarTexto.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JTFNNota.setFont(new Font("Arial", 1, 24));
        this.JTFNNota.setHorizontalAlignment(0);
        this.JTFNNota.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblInicio2, -1, 778, 32767).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPObservacionExamen))).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardar, -2, 650, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNNota, -1, 122, 32767))).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lblInicio2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionExamen, -2, 496, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNNota).addComponent(this.JBTGuardar, -1, -1, 32767)).addContainerGap(16, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHObservacionExamenFisicoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPHObservacionExamenFisico.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mGrabar() {
        if (!this.JTPHObservacionExamenFisico.getText().isEmpty()) {
            AntecedenteFamiliarTextoDTO e = new AntecedenteFamiliarTextoDTO();
            e.setDescripcion(this.JTPHObservacionExamenFisico.getText());
            e.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
            e.setEstado(true);
            e.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            if (this.JTFNNota.getText().isEmpty()) {
                this.JTFNNota.setText("" + this.antecedenteFamiliarTextoDAO.crear(e));
                return;
            } else {
                this.antecedenteFamiliarTextoDAO.actualizar(this.JTFNNota.getText(), e);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "EL campo no puede ser nulo", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCargarDato() {
        List<AntecedenteFamiliarTextoDTO> e = this.antecedenteFamiliarTextoDAO.antecedenteFamiliarTextoDTO(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
        if (!e.isEmpty()) {
            this.JTPHObservacionExamenFisico.setText(e.get(0).getDescripcion());
            this.JTFNNota.setText("" + e.get(0).getId());
        }
    }

    private void mNuevo() {
        this.JTFNNota.setText("");
        this.JTPHObservacionExamenFisico.setText("");
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() == 2) {
            this.JBTGuardar.setEnabled(false);
        } else {
            this.JBTGuardar.setEnabled(true);
        }
    }
}
