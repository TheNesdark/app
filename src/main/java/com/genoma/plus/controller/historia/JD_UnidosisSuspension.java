package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_SuspensionDAO;
import com.genoma.plus.dao.impl.historia.Orden_Unidosis_Detalle_SuspensionDAOImpl;
import com.genoma.plus.dto.historia.Orden_Unidosis_Detalle_SuspensionDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JD_UnidosisSuspension.class */
public class JD_UnidosisSuspension extends JDialog {
    private Orden_Unidosis_Detalle_SuspensionDAO orden_Unidosis_Detalle_SuspensionDAO;
    private Metodos metodo;
    private final JPIOrden_Tratamiento_Nueva jPIOrden_Tratamiento_Nueva;
    private JButton JBT_Ok;
    private JButton JBT_Salir;
    public JDateChooser JDFecha;
    private JLabel JLBNRegistro;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JFormattedTextField JTFFHora;
    private JPanel jPanel1;

    public JD_UnidosisSuspension(Frame parent, boolean modal, JPIOrden_Tratamiento_Nueva jPIOrden_Tratamiento_Nueva) {
        super(parent, modal);
        this.metodo = new Metodos();
        initComponents();
        this.jPIOrden_Tratamiento_Nueva = jPIOrden_Tratamiento_Nueva;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        nuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLBNRegistro = new JLabel();
        this.JBT_Ok = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JD_UnidosisSuspension.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_UnidosisSuspension.this.JDFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JD_UnidosisSuspension.2
            public void keyPressed(KeyEvent evt) {
                JD_UnidosisSuspension.this.JTAObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNRegistro, -2, 124, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFHora, -2, 48, -2))).addComponent(this.JLBNRegistro, -1, 60, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 184, -2).addContainerGap(20, 32767)));
        this.JBT_Ok.setFont(new Font("Arial", 1, 12));
        this.JBT_Ok.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Ok.setText("Grabar");
        this.JBT_Ok.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JD_UnidosisSuspension.3
            public void actionPerformed(ActionEvent evt) {
                JD_UnidosisSuspension.this.JBT_OkActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JD_UnidosisSuspension.4
            public void actionPerformed(ActionEvent evt) {
                JD_UnidosisSuspension.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Ok, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 241, 32767).addComponent(this.JBT_Salir, -2, 200, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Ok, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTAObservacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OkActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void springStart() {
        this.orden_Unidosis_Detalle_SuspensionDAO = (Orden_Unidosis_Detalle_SuspensionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("orden_Unidosis_Detalle_SuspensionDAOImpl");
    }

    private void nuevo() {
        this.JLBNRegistro.setText("");
        this.JDFecha.setDate(this.metodo.getFechaActual());
        this.JTFFHora.setText(this.metodo.formatoH24.format(this.metodo.getFechaActual()));
        this.JTAObservacion.setText("");
    }

    private void grabar() {
        if (!this.JTFFHora.getText().isEmpty()) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                Orden_Unidosis_Detalle_SuspensionDTO e = new Orden_Unidosis_Detalle_SuspensionDTO();
                e.setFechaSuspension(this.metodo.formatoAMD1.format(this.JDFecha.getDate()) + " " + this.JTFFHora.getText());
                e.setObservacion(this.JTAObservacion.getText());
                e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                e.setEstado(true);
                e.setFecha(this.metodo.formatoAMDH24.format(this.metodo.getFechaActual()));
                this.jPIOrden_Tratamiento_Nueva.grabarSuspencion(e);
                dispose();
                return;
            }
            this.metodo.mostrarMensaje("Campo observacion no puede estar en blanco");
            this.JTAObservacion.requestFocus();
            return;
        }
        this.metodo.mostrarMensaje("Campo fecha no puede estar en blanco");
        this.JTFFHora.requestFocus();
    }
}
