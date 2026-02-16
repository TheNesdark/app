package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EspecialidadProfesionalDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.EspecialidadProfesionalDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JD_AccesoInicial_Efermeria.class */
public class JD_AccesoInicial_Efermeria extends JDialog {
    private EspecialidadProfesionalDAO especialidadProfesionalDAO;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idEspecialidad;
    private String[] idServicio;
    private Boolean estadoLlenadoCombo;
    private Principal frmPrincipal;
    private Integer modulo;
    private Metodos metodos;
    private JButton JBT_Ok;
    private JButton JBT_Salir;
    private JComboBox<String> JCB_Especialidad;
    private JComboBox<String> JCB_Servicio;
    private JLabel JLB_Titulo;
    private JPanel JPI_Datos;
    private JPanel JPI_Servicio;

    public JD_AccesoInicial_Efermeria(Frame parent, boolean modal, Principal frmPrincipal, Integer modulo) {
        super(parent, modal);
        this.estadoLlenadoCombo = false;
        initComponents();
        this.modulo = modulo;
        this.frmPrincipal = frmPrincipal;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        nuevo();
    }

    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JCB_Especialidad = new JComboBox<>();
        this.JPI_Servicio = new JPanel();
        this.JCB_Servicio = new JComboBox<>();
        this.JBT_Ok = new JButton();
        this.JBT_Salir = new JButton();
        this.JLB_Titulo = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("MÓDULO ENFERMERÍA");
        this.JPI_Datos.setBorder(BorderFactory.createBevelBorder(0));
        this.JCB_Especialidad.setFont(new Font("Arial", 1, 12));
        this.JCB_Especialidad.setToolTipText("");
        this.JCB_Especialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Especialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JD_AccesoInicial_Efermeria.1
            public void itemStateChanged(ItemEvent evt) {
                JD_AccesoInicial_Efermeria.this.JCB_EspecialidadItemStateChanged(evt);
            }
        });
        this.JPI_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO PREDETERMINADO DE SERVICIO PARA AGENDA", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setToolTipText("");
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_ServicioLayout = new GroupLayout(this.JPI_Servicio);
        this.JPI_Servicio.setLayout(JPI_ServicioLayout);
        JPI_ServicioLayout.setHorizontalGroup(JPI_ServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ServicioLayout.createSequentialGroup().addContainerGap().addComponent(this.JCB_Servicio, 0, 472, 32767).addContainerGap()));
        JPI_ServicioLayout.setVerticalGroup(JPI_ServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServicioLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCB_Servicio, -2, 50, -2).addContainerGap(17, 32767)));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Servicio, -1, -1, 32767).addComponent(this.JCB_Especialidad, 0, -1, 32767)).addContainerGap(-1, 32767)));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JCB_Especialidad, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JPI_Servicio, -1, -1, 32767).addGap(36, 36, 36)));
        this.JBT_Ok.setFont(new Font("Arial", 1, 12));
        this.JBT_Ok.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Ok.setText("Ok");
        this.JBT_Ok.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JD_AccesoInicial_Efermeria.2
            public void actionPerformed(ActionEvent evt) {
                JD_AccesoInicial_Efermeria.this.JBT_OkActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JD_AccesoInicial_Efermeria.3
            public void actionPerformed(ActionEvent evt) {
                JD_AccesoInicial_Efermeria.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JLB_Titulo.setBackground(new Color(0, 51, 153));
        this.JLB_Titulo.setFont(new Font("Arial", 1, 14));
        this.JLB_Titulo.setForeground(new Color(204, 255, 204));
        this.JLB_Titulo.setHorizontalAlignment(0);
        this.JLB_Titulo.setText("SELECCIÓN DE INFORMACIÓN");
        this.JLB_Titulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JLB_Titulo.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLB_Titulo, -1, 534, 32767).addComponent(this.JPI_Datos, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBT_Ok, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, 32767).addComponent(this.JBT_Salir, -2, 200, -2))).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JLB_Titulo, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Datos, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Ok, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OkActionPerformed(ActionEvent evt) {
        if (this.JCB_Especialidad.getSelectedIndex() != -1) {
            if (this.idServicio != null) {
                if (this.JCB_Servicio.getSelectedIndex() != -1) {
                    this.frmPrincipal.activarMenu = 1;
                    Principal.informacionGeneralPrincipalDTO.setIdEspecialidad(Long.valueOf(this.idEspecialidad[this.JCB_Especialidad.getSelectedIndex()]));
                    Principal.informacionGeneralPrincipalDTO.setNombreEspecialidad(this.JCB_Especialidad.getSelectedItem().toString());
                    Principal.informacionGeneralPrincipalDTO.setIdServicio(Long.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]));
                    Principal.informacionGeneralPrincipalDTO.setNombreServicio(this.JCB_Servicio.getSelectedItem().toString());
                    Principal.informacionGeneralPrincipalDTO.setAsignacionCitaAgenda(true);
                    this.frmPrincipal.setAsignarDatosHistoriaCE(this.idEspecialidad[this.JCB_Especialidad.getSelectedIndex()], this.JCB_Especialidad.getSelectedItem().toString(), "0", 0, 0);
                    dispose();
                    return;
                }
                this.metodos.mostrarMensaje("Por favor seleccione un servicio");
                this.JCB_Servicio.requestFocus();
                return;
            }
            this.frmPrincipal.activarMenu = 1;
            Principal.informacionGeneralPrincipalDTO.setIdEspecialidad(Long.valueOf(this.idEspecialidad[this.JCB_Especialidad.getSelectedIndex()]));
            Principal.informacionGeneralPrincipalDTO.setNombreEspecialidad(this.JCB_Especialidad.getSelectedItem().toString());
            Principal.informacionGeneralPrincipalDTO.setIdServicio(new Long(0L));
            Principal.informacionGeneralPrincipalDTO.setNombreServicio("");
            Principal.informacionGeneralPrincipalDTO.setAsignacionCitaAgenda(true);
            this.frmPrincipal.setAsignarDatosHistoriaCE(this.idEspecialidad[this.JCB_Especialidad.getSelectedIndex()], this.JCB_Especialidad.getSelectedItem().toString(), "0", 0, 0);
            dispose();
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione una especialidad");
        this.JCB_Especialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setActivarModulo(0);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EspecialidadItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue() && this.JCB_Especialidad.getSelectedIndex() != -1) {
            LlenarComboServicio();
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.especialidadProfesionalDAO = (EspecialidadProfesionalDAOImpl) classPathXmlApplicationContext.getBean("especialidadProfesionalDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    private void LlenarComboEspecialidad() {
        this.JCB_Especialidad.removeAllItems();
        List<Object[]> listEspecialidad = this.especialidadProfesionalDAO.listadoEspecialidadProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        if (!listEspecialidad.isEmpty()) {
            this.idEspecialidad = new String[listEspecialidad.size()];
            for (int i = 0; i < listEspecialidad.size(); i++) {
                this.idEspecialidad[i] = String.valueOf(listEspecialidad.get(i)[0]);
                this.JCB_Especialidad.addItem(listEspecialidad.get(i)[1].toString());
            }
            this.JCB_Especialidad.setSelectedIndex(-1);
        }
    }

    private void LlenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        List<Object[]> listServicio = this.informacionVariaUrgenciasHospitalizacionDAO.listadoServiciosEnfermeria();
        if (!listServicio.isEmpty()) {
            this.idServicio = new String[listServicio.size()];
            for (int i = 0; i < listServicio.size(); i++) {
                this.idServicio[i] = String.valueOf(listServicio.get(i)[0]);
                this.JCB_Servicio.addItem(listServicio.get(i)[1].toString());
            }
            if (listServicio.size() > 1) {
                this.JCB_Servicio.setSelectedIndex(-1);
            }
        }
    }

    private void nuevo() {
        this.estadoLlenadoCombo = false;
        LlenarComboEspecialidad();
        this.estadoLlenadoCombo = true;
    }
}
