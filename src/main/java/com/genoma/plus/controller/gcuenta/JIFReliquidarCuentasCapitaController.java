package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.gcuenta.dto.ConvenioDTO;
import com.genoma.plus.controller.gcuenta.dto.InfoDataConvenio;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.general.dto.InfoDataReportePyp;
import com.genoma.plus.controller.general.dto.ReportePyPDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFReliquidarCuentasCapitaController.class */
public final class JIFReliquidarCuentasCapitaController extends JInternalFrame {
    private Metodos metodos;
    private List<ConvenioDTO> listConvenioDTO;
    private int idConvenio;
    private Boolean estadoLlenadoCombo = false;
    private List<String> query = new ArrayList();
    private ConsultasMySQL mariaDB = new ConsultasMySQL();
    private JComboBox<String> JCB_Convenios;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel jPanel1;

    public JIFReliquidarCuentasCapitaController() {
        this.metodos = new Metodos();
        initComponents();
        this.metodos = new Metodos();
        nuevo();
    }

    public void nuevo() {
        this.idConvenio = -1;
        this.estadoLlenadoCombo = false;
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        llenarComboConvenio();
        this.estadoLlenadoCombo = true;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCB_Convenios = new JComboBox<>();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reliquidar Factura Capita");
        setFocusable(false);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setInheritsPopupMenu(true);
        setName("jifReliquidarCuentasCapita");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "REQUISITOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReliquidarCuentasCapitaController.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReliquidarCuentasCapitaController.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.JDFechaI, -2, 136, -2).addGap(0, 0, 0).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(23, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(0, 0, 0)));
        this.JCB_Convenios.setFont(new Font("Arial", 1, 12));
        this.JCB_Convenios.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Convenios.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController.3
            public void itemStateChanged(ItemEvent evt) {
                JIFReliquidarCuentasCapitaController.this.JCB_ConveniosItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPDatos, -2, 305, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Convenios, -2, 412, -2).addGap(5, 5, 5)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCB_Convenios, -2, 60, -2).addComponent(this.JPDatos, -2, 80, -2)).addGap(5, 5, 5)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue()) {
            llenarComboConvenio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue()) {
            llenarComboConvenio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ConveniosItemStateChanged(ItemEvent evt) {
        obtenerIdConvenio();
    }

    public void mGrabar() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("100", "ConsultasPyP");
            MetodosGenericos<InfoDataReportePyp> metodosGenericos = new MetodosGenericos<>();
            InfoDataReportePyp info = InfoDataReportePyp.builder().name("Consultas Reliquidacion").idModule(24).build();
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(info);
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            Throwable th = null;
            try {
                try {
                    int statusCode = response.getStatus();
                    System.out.println("status code --- " + statusCode);
                    if (statusCode == 200) {
                        try {
                            new CustomPresenter();
                            CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                            List<ReportePyPDTO> listConsultasSQL = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ReportePyPDTO>>() { // from class: com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController.4
                            });
                            listConsultasSQL.forEach(listaSql -> {
                                ResultSet rs;
                                Throwable th2;
                                String ConsultaSql = listaSql.getSql().replaceAll(":FechaInicio", this.metodos.formatoAMD1.format(this.JDFechaI.getDate())).replaceAll(":FechaFinal", this.metodos.formatoAMD1.format(this.JDFechaF.getDate())).replaceAll(":IdConvenio", String.valueOf(this.idConvenio));
                                System.err.println("sql" + ConsultaSql);
                                try {
                                    rs = this.mariaDB.traerRs(ConsultaSql);
                                    th2 = null;
                                } catch (SQLException ex) {
                                    Logger.getLogger(JIFReliquidarCuentasCapitaController.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                }
                                try {
                                    try {
                                        if (rs.next()) {
                                            rs.beforeFirst();
                                        }
                                        if (rs != null) {
                                            if (0 != 0) {
                                                try {
                                                    rs.close();
                                                } catch (Throwable th3) {
                                                    th2.addSuppressed(th3);
                                                }
                                            } else {
                                                rs.close();
                                            }
                                        }
                                        this.mariaDB.cerrarConexionBd();
                                    } finally {
                                    }
                                } finally {
                                }
                            });
                            JOptionPane.showInternalMessageDialog(this, "Proceso Finalizado.", "TERMINADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                    }
                    if (response != null) {
                        if (0 != 0) {
                            try {
                                response.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            response.close();
                        }
                    }
                    this.metodos.getResteasyClient().close();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (Throwable th4) {
                if (response != null) {
                    if (th != null) {
                        try {
                            response.close();
                        } catch (Throwable th5) {
                            th.addSuppressed(th5);
                        }
                    } else {
                        response.close();
                    }
                }
                throw th4;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "USTED NO CUENTA CON ESTA FUNCIONALIDAD. COMUNÍQUESE CON GENOMA EMPRESARIAL, LÍNEA DE ATENCIÓN: 3204074890.", "FINALIZADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void llenarComboConvenio() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("9", "jifReliquidarCuentasCapita");
        MetodosGenericos<InfoDataConvenio> metodosGenericos = new MetodosGenericos<>();
        InfoDataConvenio date = InfoDataConvenio.builder().dateStart(this.metodos.formatoAMD1.format(this.JDFechaI.getDate())).dateEnd(this.metodos.formatoAMD1.format(this.JDFechaF.getDate())).build();
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(date);
        System.out.println("fullurlSql --- " + fullUrl);
        Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
        Throwable th = null;
        try {
            try {
                int statusCode = response.getStatus();
                System.out.println("status code --- " + statusCode);
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        List<ConvenioDTO> listConvenioCapita = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ConvenioDTO>>() { // from class: com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController.5
                        });
                        System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(listConvenioCapita));
                        this.JCB_Convenios.removeAllItems();
                        listConvenioCapita.forEach(convenio -> {
                            this.JCB_Convenios.addItem(convenio.getId().toString() + "-" + convenio.getName());
                        });
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                    this.JCB_Convenios.setSelectedIndex(-1);
                }
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                            return;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            return;
                        }
                    }
                    response.close();
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (Throwable th4) {
            if (response != null) {
                if (th != null) {
                    try {
                        response.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    response.close();
                }
            }
            throw th4;
        }
    }

    public int obtenerIdConvenio() {
        if (this.JCB_Convenios.getSelectedIndex() != -1) {
            int indiceSeleccionado = this.JCB_Convenios.getSelectedIndex();
            String itemSeleccionado = (String) this.JCB_Convenios.getItemAt(indiceSeleccionado);
            String[] partes = itemSeleccionado.split("-");
            if (partes.length > 0) {
                this.idConvenio = Integer.parseInt(partes[0].trim());
                System.err.println("idCon: " + this.idConvenio);
            } else {
                System.err.println("No se pudo obtener el ID del convenio");
            }
        } else {
            System.err.println("No hay elemento seleccionado en el JComboBox");
        }
        return this.idConvenio;
    }
}
