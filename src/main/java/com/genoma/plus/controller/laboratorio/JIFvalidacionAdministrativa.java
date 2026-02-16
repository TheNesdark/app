package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.general.dto.DepartamentDTO;
import com.genoma.plus.controller.general.dto.MunicipalityDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.InfoDate;
import com.genoma.plus.controller.laboratorio.dto.InfoResultadosDTO;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFvalidacionAdministrativa.class */
public class JIFvalidacionAdministrativa extends JInternalFrame {
    private Metodos metodos;
    private List<InfoResultadosDTO> infoResultadosDTOs = null;
    private DefaultTableModel modeloDato;
    private List<MunicipalityDTO> listMunicipality;
    private List<DepartamentDTO> listDepartament;
    private int idMunicipality;
    private List<String> idDepartament;
    private List<String> nameDepartament;
    private JButton JBTCarguesA1;
    private JButton JBTRegistrarValidacion;
    private JComboBox<String> JCB_Municipio;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JLabel JLBNRegristro;
    private JPanel JPIFiltroConsulta;
    private JPanel JPI_UDatos2;
    private JScrollPane JSDetalle;
    private JTabbedPane JTB_DatosU;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JIFvalidacionAdministrativa() {
        initComponents();
        this.metodos = new Metodos();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFiltroConsulta = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JLBNRegristro = new JLabel();
        this.JCB_Municipio = new JComboBox<>();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTB_DatosU = new JTabbedPane();
        this.JPI_UDatos2 = new JPanel();
        this.JBTCarguesA1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTRegistrarValidacion = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("VALIDACI�N ADMINISTRATIVA DE RESULTADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifValidacionAdministrativa");
        this.JPIFiltroConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACI�N PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JLBNRegristro.setFont(new Font("Arial", 1, 12));
        this.JLBNRegristro.setForeground(Color.red);
        this.JLBNRegristro.setHorizontalAlignment(0);
        this.JLBNRegristro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Municipio.setFont(new Font("Arial", 1, 12));
        this.JCB_Municipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Municipio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.1
            public void itemStateChanged(ItemEvent evt) {
                JIFvalidacionAdministrativa.this.JCB_MunicipioItemStateChanged(evt);
            }
        });
        GroupLayout JPIFiltroConsultaLayout = new GroupLayout(this.JPIFiltroConsulta);
        this.JPIFiltroConsulta.setLayout(JPIFiltroConsultaLayout);
        JPIFiltroConsultaLayout.setHorizontalGroup(JPIFiltroConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroConsultaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JDFFechaI, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JDFFechaF, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JCB_Municipio, 0, -1, 32767).addGap(435, 435, 435).addComponent(this.JLBNRegristro, -2, 141, -2).addGap(20, 20, 20)));
        JPIFiltroConsultaLayout.setVerticalGroup(JPIFiltroConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroConsultaLayout.createSequentialGroup().addContainerGap(19, 32767).addGroup(JPIFiltroConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCB_Municipio, -2, 50, -2).addGroup(JPIFiltroConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIFiltroConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addComponent(this.JLBNRegristro, -1, -1, 32767))).addContainerGap()));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.2
            public void mouseClicked(MouseEvent evt) {
                JIFvalidacionAdministrativa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JTB_DatosU.setForeground(new Color(0, 103, 0));
        this.JTB_DatosU.setFont(new Font("Arial", 1, 14));
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.3
            public void actionPerformed(ActionEvent evt) {
                JIFvalidacionAdministrativa.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicaci�n de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.4
            public void mouseClicked(MouseEvent evt) {
                JIFvalidacionAdministrativa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTRegistrarValidacion.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarValidacion.setForeground(Color.red);
        this.JBTRegistrarValidacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarValidacion.setText("Validaci�n o Seguimiento");
        this.JBTRegistrarValidacion.setToolTipText("");
        this.JBTRegistrarValidacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.5
            public void actionPerformed(ActionEvent evt) {
                JIFvalidacionAdministrativa.this.JBTRegistrarValidacionActionPerformed(evt);
            }
        });
        GroupLayout JPI_UDatos2Layout = new GroupLayout(this.JPI_UDatos2);
        this.JPI_UDatos2.setLayout(JPI_UDatos2Layout);
        JPI_UDatos2Layout.setHorizontalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 460, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCarguesA1, -2, 171, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 157, 32767).addComponent(this.JBTRegistrarValidacion, -2, 366, -2).addContainerGap()));
        JPI_UDatos2Layout.setVerticalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos2Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTCarguesA1, -2, 50, -2).addComponent(this.JBTRegistrarValidacion, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTB_DatosU.addTab("UTILIDADES", this.JPI_UDatos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltroConsulta, -1, -1, 32767).addComponent(this.JSDetalle).addComponent(this.JTB_DatosU)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPIFiltroConsulta, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSDetalle, -1, 344, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTB_DatosU, -2, 107, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            imprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarValidacionActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            List<Long> idDetalle = new ArrayList<>();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.parseBoolean(this.JTDetalle.getValueAt(i, 0).toString())) {
                    idDetalle.add(this.infoResultadosDTOs.get(i).getIdDetalleRecepcion());
                }
            }
            if (!idDetalle.isEmpty()) {
                JD_ValidacionAdministrativa jdva = new JD_ValidacionAdministrativa(null, true, idDetalle);
                jdva.setLocationRelativeTo(this);
                jdva.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_MunicipioItemStateChanged(ItemEvent evt) {
        getIdMunicipality();
    }

    private void JCB_MunicipioActionPerformed(ActionEvent evt) {
    }

    private void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    public void nuevo() {
        this.idMunicipality = -1;
        this.idDepartament = new ArrayList();
        this.nameDepartament = new ArrayList();
        this.JDFFechaI.setDate(this.metodos.getFechaActual());
        this.JDFFechaF.setDate(this.metodos.getFechaActual());
        this.infoResultadosDTOs = new ArrayList();
        crearModeloDato();
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        llenarComboMunicipality();
    }

    public void buscar() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "jifValidacionAdministrativa");
            MetodosGenericos<InfoDate> metodosGenericos = new MetodosGenericos<>();
            InfoDate date = InfoDate.builder().dateInit(this.metodos.formatoAMD1.format(this.JDFFechaI.getDate())).dateEnd(this.metodos.formatoAMD1.format(this.JDFFechaF.getDate())).idMunicipality(this.idMunicipality + "").build();
            System.out.println("datee--- " + date);
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(date);
            System.out.println("fullurl --- " + fullUrl);
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            crearModeloDato();
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 5);
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                this.infoResultadosDTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<InfoResultadosDTO>>() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.6
                });
                Object[] dato = null;
                this.infoResultadosDTOs.forEach(e -> {
                    this.modeloDato.addRow(dato);
                    this.modeloDato.setValueAt(false, this.JTDetalle.getRowCount() - 1, 0);
                    this.modeloDato.setValueAt(e.getFecha(), this.JTDetalle.getRowCount() - 1, 1);
                    this.modeloDato.setValueAt(e.getIdRecepcion(), this.JTDetalle.getRowCount() - 1, 2);
                    this.modeloDato.setValueAt(e.getDocumento(), this.JTDetalle.getRowCount() - 1, 3);
                    this.modeloDato.setValueAt(e.getNombreUsuario(), this.JTDetalle.getRowCount() - 1, 4);
                    this.modeloDato.setValueAt(e.getNombreProcedimiento(), this.JTDetalle.getRowCount() - 1, 5);
                    this.modeloDato.setValueAt(e.getFechaHoraValidado(), this.JTDetalle.getRowCount() - 1, 6);
                    this.modeloDato.setValueAt(e.getNombreProfesionalValida(), this.JTDetalle.getRowCount() - 1, 7);
                    this.modeloDato.setValueAt(e.getEspecialidaValida(), this.JTDetalle.getRowCount() - 1, 8);
                });
                this.JLBNRegristro.setText("" + this.JTDetalle.getRowCount());
            }
            response.close();
            this.metodos.getResteasyClient().close();
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JIFvalidacionAdministrativa.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDato() {
        this.modeloDato = new DefaultTableModel(new Object[0], new String[]{"S", "Fecha", "N° Recepción", "Documento", "Usuario", "Procedimiento", "Fecha Validado", "Profesional Valida", "Especialidad"}) { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.7
            Class[] types = {Boolean.class, LocalDate.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloDato);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    private void imprimir() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Normal", "Por Procedimiento", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
            if (n == 0) {
                impresion.mImprimirResultado(String.valueOf(this.infoResultadosDTOs.get(this.JTDetalle.getSelectedRow()).getIdRecepcion()), "", this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra(), this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra(), true, String.valueOf(this.infoResultadosDTOs.get(this.JTDetalle.getSelectedRow()).getIdUsuario()), true);
            } else if (n == 1) {
                impresion.mImprimirResultado(String.valueOf(this.infoResultadosDTOs.get(this.JTDetalle.getSelectedRow()).getIdRecepcion()), String.valueOf(this.infoResultadosDTOs.get(this.JTDetalle.getSelectedRow()).getIdCodigoProcedimiento()), this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra(), this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra(), true, String.valueOf(this.infoResultadosDTOs.get(this.JTDetalle.getSelectedRow()).getIdUsuario()), true);
            }
        }
    }

    private void getIdMunicipality() {
        String selectedMunicipalityId = (String) this.JCB_Municipio.getSelectedItem();
        if (selectedMunicipalityId != null) {
            String[] parts = selectedMunicipalityId.split(" - ");
            if (parts.length > 0) {
                String selectedId = parts[2];
                System.out.println("id municipio art -> " + selectedId);
                this.idMunicipality = Integer.parseInt(selectedId);
            }
        }
    }

    private void getDepartament() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "departament");
        new MetodosGenericos();
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        System.out.println("response -> " + microserviciosDomain.getUrlRecurso());
        int statusCode = response.getStatus();
        System.out.println("status code --- " + statusCode);
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                List<DepartamentDTO> listDepartamentLocal = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<DepartamentDTO>>() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.8
                });
                System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.listMunicipality));
                this.listDepartament = (List) listDepartamentLocal.stream().filter(e -> {
                    return !e.getState().booleanValue();
                }).sorted((p1, p2) -> {
                    return p1.getName().compareTo(p2.getName());
                }).collect(Collectors.toList());
                System.out.println("lista departamento -> " + this.listDepartament);
                this.listDepartament.forEach(d -> {
                    this.idDepartament.add(d.getId().toString());
                    this.nameDepartament.add(d.getName().toString());
                    System.out.println("id departamentoooo ---- " + this.idDepartament);
                });
            } catch (JsonProcessingException e2) {
                Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e2);
            }
            this.JCB_Municipio.setSelectedIndex(-1);
        }
        response.close();
        this.metodos.getResteasyClient().close();
    }

    private void llenarComboMunicipality() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "municipality");
        new MetodosGenericos();
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        System.out.println("response -> " + microserviciosDomain.getUrlRecurso());
        int statusCode = response.getStatus();
        System.out.println("status code --- " + statusCode);
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                List<MunicipalityDTO> listMunicipalityLocal = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<MunicipalityDTO>>() { // from class: com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa.9
                });
                System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.listMunicipality));
                this.listMunicipality = (List) listMunicipalityLocal.stream().filter(e -> {
                    return !e.getState().booleanValue();
                }).sorted((p1, p2) -> {
                    return p1.getName().compareTo(p2.getName());
                }).collect(Collectors.toList());
                System.out.println("lista municipio -> " + this.listMunicipality);
                getDepartament();
                this.listMunicipality.forEach(d -> {
                    String departamentoNombre = "";
                    int index = this.idDepartament.indexOf(d.getIdDpto().toString());
                    if (index != -1 && index < this.nameDepartament.size()) {
                        departamentoNombre = this.nameDepartament.get(index);
                    }
                    String nombreCompleto = d.getName() + " - " + departamentoNombre.toUpperCase() + " - " + d.getId();
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        if (Arrays.asList("TUCHIN", "SAHAGUN", "PUERTO LIBERTADOR", "LA APARTADA", "CHINU", "TIERRALTA", "VALENCIA", "PLANETA RICA", "MONTELIBANO", "PUEBLO NUEVO", "SAN ANDRES", "MONTERIA", "SAN BERNARDO", "CHIMA", "LORICA", "BUENAVISTA", "SAN ANTERO", "MOMIL", "AYAPEL", "SAN JOSE DE URE").contains(d.getName())) {
                            this.JCB_Municipio.addItem(nombreCompleto);
                            return;
                        }
                        return;
                    }
                    this.JCB_Municipio.addItem(nombreCompleto);
                });
            } catch (JsonProcessingException e2) {
                Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e2);
            }
            this.JCB_Municipio.setSelectedIndex(-1);
        }
        response.close();
        this.metodos.getResteasyClient().close();
    }
}
