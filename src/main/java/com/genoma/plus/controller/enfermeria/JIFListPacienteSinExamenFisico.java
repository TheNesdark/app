package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.enfermeria.dto.ListPacienteSinExamenFisicoDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIFListPacienteSinExamenFisico.class */
public class JIFListPacienteSinExamenFisico extends JInternalFrame {
    private DefaultTableModel modelo;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idServicio;
    private JComboBox<String> JCB_Servicio;
    private JDateChooser JDFechaInicio;
    private JTable JTDetalle;
    private JTextField JTFBuscar;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private Metodos metodo = new Metodos();
    Object[] datos = null;
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);
    public Boolean esLlenoCombo = false;

    public JIFListPacienteSinExamenFisico() {
        initComponents();
        springStart();
        nuevo();
    }

    private void springStart() {
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JDFechaInicio = new JDateChooser();
        this.JCB_Servicio = new JComboBox<>();
        this.JTFBuscar = new JTextField();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LISTA PACIENTES SIN EXAMENEFISICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiflListPacienteSinExamenFisico");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel2.setBorder(new SoftBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.1
            public void mouseClicked(MouseEvent evt) {
                JIFListPacienteSinExamenFisico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, -1, -2).addContainerGap()));
        this.JDFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFListPacienteSinExamenFisico.this.JDFechaInicioPropertyChange(evt);
            }
        });
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setToolTipText("");
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.3
            public void itemStateChanged(ItemEvent evt) {
                JIFListPacienteSinExamenFisico.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.4
            public void keyPressed(KeyEvent evt) {
                JIFListPacienteSinExamenFisico.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 10));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("ACTUALIZAR");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.5
            public void actionPerformed(ActionEvent evt) {
                JIFListPacienteSinExamenFisico.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaInicio, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Servicio, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFBuscar, -2, 467, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 135, -2).addGap(0, 10, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Servicio, -2, 50, -2).addComponent(this.JTFBuscar, -2, 50, -2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaInicio, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1, -2, 51, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.esLlenoCombo.booleanValue()) {
            cargarPaciente();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
        if (this.esLlenoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            cargarPaciente();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFBuscar.getText().isEmpty()) {
            creaModeloTabla();
            cargarPaciente();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        this.EstadoTarea.set(false);
        Long idAtencion = Long.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        JDSignosVitalesEnfermeria jDSignosVitalesEnfermeria = new JDSignosVitalesEnfermeria(null, true, idAtencion);
        jDSignosVitalesEnfermeria.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        cargarPaciente();
    }

    public void nuevo() {
        this.JDFechaInicio.setDate(this.metodo.getFechaActual());
        this.esLlenoCombo = false;
        this.JTFBuscar.setText("  ");
        LlenarComboServicio();
        this.esLlenoCombo = true;
        creaModeloTabla();
        ejecutarTareaTimer();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void creaModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"idPersona", "idIngreso", "idAtencion", "fechaIngreso", "paciente", "convenio", "claseCita", "profesional", "especialidad", "exemenFisico", "idProfesional", "idEspecialidad"}) { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarPaciente() {
        creaModeloTabla();
        RecursosMicroserviciosDomain microserviciosDomain = this.metodo.getParametrosEncriptados("100", "ListpacienteSinExamenFisico");
        new ArrayList();
        System.err.println("idServicio" + this.idServicio[this.JCB_Servicio.getSelectedIndex()]);
        System.err.println("fecha" + this.metodo.formatoAMD1.format(this.JDFechaInicio.getDate()));
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/date/" + this.metodo.formatoAMD1.format(this.JDFechaInicio.getDate()) + "/idServicio/" + this.idServicio[this.JCB_Servicio.getSelectedIndex()] + "/nombre/" + this.JTFBuscar.getText();
        System.err.println("fullUrl" + fullUrl);
        Response response = this.metodo.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodo.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                List<ListPacienteSinExamenFisicoDto> listPacienteSinExamenFisicoDto = (List) this.metodo.getMapper().readValue(this.metodo.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ListPacienteSinExamenFisicoDto>>() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.7
                });
                listPacienteSinExamenFisicoDto.forEach(e -> {
                    this.modelo.addRow(this.datos);
                    this.JTDetalle.setValueAt(e.getIdPersona(), this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(e.getIdIngreso(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(e.getIdAtencion(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt(e.getFechaIngreso(), this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(e.getPaciente(), this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(e.getConvenio(), this.JTDetalle.getRowCount() - 1, 5);
                    this.JTDetalle.setValueAt(e.getClaseCita(), this.JTDetalle.getRowCount() - 1, 6);
                    this.JTDetalle.setValueAt(e.getProfesional(), this.JTDetalle.getRowCount() - 1, 7);
                    this.JTDetalle.setValueAt(e.getEspecialidad(), this.JTDetalle.getRowCount() - 1, 8);
                    this.JTDetalle.setValueAt(e.getExemenFisico(), this.JTDetalle.getRowCount() - 1, 9);
                    this.JTDetalle.setValueAt(e.getIdProfesional(), this.JTDetalle.getRowCount() - 1, 10);
                    this.JTDetalle.setValueAt(e.getIdEspecialidad(), this.JTDetalle.getRowCount() - 1, 11);
                });
            } catch (Exception e2) {
                Logger.getLogger(ListPacienteSinExamenFisicoDto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
            }
        }
        response.close();
        this.metodo.getResteasyClient().close();
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.enfermeria.JIFListPacienteSinExamenFisico.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIFListPacienteSinExamenFisico.this.EstadoTarea.get()) {
                    JIFListPacienteSinExamenFisico.this.cargarPaciente();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Laboratorio");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    private void LlenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        List<Object[]> listServicio = this.informacionVariaUrgenciasHospitalizacionDAO.listadoServiciosEnfermeria();
        if (listServicio != null && !listServicio.isEmpty()) {
            this.idServicio = new String[listServicio.size()];
            for (int i = 0; i < listServicio.size(); i++) {
                Object[] servicio = listServicio.get(i);
                if (servicio != null && servicio.length >= 2) {
                    this.idServicio[i] = String.valueOf(servicio[0]);
                    this.JCB_Servicio.addItem(String.valueOf(servicio[1]));
                }
            }
            if (Principal.informacionGeneralPrincipalDTO != null && Principal.informacionGeneralPrincipalDTO.getNombreServicio() != null) {
                this.JCB_Servicio.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreServicio());
                return;
            }
            return;
        }
        System.out.print("NULL");
    }
}
