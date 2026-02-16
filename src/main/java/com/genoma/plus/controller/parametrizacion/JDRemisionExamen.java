package com.genoma.plus.controller.parametrizacion;

import ParametrizacionN.JDProcedimientoTiempoServicio;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JDRemisionExamen.class */
public class JDRemisionExamen extends JDialog {
    private List<RemisionExamenDTO> listRemisionExamendTOs;
    private RemisionExamenDTO remisionExamenDTO;
    LocalDateTime fecha;
    private DefaultTableModel modeloTabla;
    private Metodos metodos;
    private List<TipoProgramaDTO> tipoProgramaDTOs;
    private List<GenericParametrizacionDTO> listGenericParametrizacionDTOs;
    private List<GenericParametrizacionDTO> listParametrizacionDTOs;
    private Long id;
    public JButton JBGuardar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JComboBox JCBEmpresa;
    private JComboBox JCBIdgrupo2;
    private JComboBox JCBIdgrupo3;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBTipoPrograma;
    private JCheckBox JCHEstado;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JDRemisionExamen(Frame parent, boolean modal, String idProcedimiento) {
        super(parent, modal);
        this.fecha = LocalDateTime.now();
        initComponents();
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        cargarComboPrograma();
        cargarComboEmpresaConvenio();
        cargarComboProcedimiento();
        this.JCBTipoPrograma.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBEmpresa.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProcedimiento.addPopupMenuListener(new CustomPopupMenuListener(true, false));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearModelTabla() {
        this.modeloTabla = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa Convenio", "Procedimiento", "Tipo Programa", "Estado"}) { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.1
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setAutoResizeMode(4);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.modeloTabla);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public void cargarTabla() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllRemisionExamen");
            String fullUrl = microserviciosDomain.getUrlRecurso();
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            Throwable th = null;
            try {
                System.out.println("microservicio" + response);
                crearModelTabla();
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    this.listRemisionExamendTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<RemisionExamenDTO>>() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.2
                    });
                    this.listRemisionExamendTOs.forEach(e -> {
                        Object[] dato = new Object[4];
                        this.modeloTabla.addRow(dato);
                        this.modeloTabla.setValueAt(e.getId(), this.JTHistorico.getRowCount() - 1, 0);
                        this.modeloTabla.setValueAt(e.getNombreConvenio(), this.JTHistorico.getRowCount() - 1, 1);
                        this.modeloTabla.setValueAt(e.getNombreProcedimiento(), this.JTHistorico.getRowCount() - 1, 2);
                        this.modeloTabla.setValueAt(e.getNombrePrograma(), this.JTHistorico.getRowCount() - 1, 3);
                        this.modeloTabla.setValueAt(e.getEstado(), this.JTHistorico.getRowCount() - 1, 4);
                    });
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
            } finally {
            }
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JDProcedimientoCntCode.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e2);
        }
    }

    public void cargarComboPrograma() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllProgramType");
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        Throwable th = null;
        try {
            try {
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        List<TipoProgramaDTO> listModelLocal = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<TipoProgramaDTO>>() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.3
                        });
                        System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.tipoProgramaDTOs));
                        this.tipoProgramaDTOs = (List) listModelLocal.stream().filter(e -> {
                            return !e.getEstado().booleanValue();
                        }).sorted((p1, p2) -> {
                            return p1.getNbre().compareTo(p2.getNbre());
                        }).collect(Collectors.toList());
                        this.tipoProgramaDTOs.forEach(e2 -> {
                            this.JCBTipoPrograma.addItem(e2.getNbre());
                        });
                    } catch (JsonProcessingException e3) {
                        Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e3);
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
            } finally {
            }
        } catch (Throwable th3) {
            if (response != null) {
                if (th != null) {
                    try {
                        response.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    response.close();
                }
            }
            throw th3;
        }
    }

    private void cargarComboEmpresaConvenio() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllCompanyAgreement");
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        Throwable th = null;
        try {
            try {
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        List<GenericParametrizacionDTO> dTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<GenericParametrizacionDTO>>() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.4
                        });
                        System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.listParametrizacionDTOs));
                        this.listParametrizacionDTOs = (List) dTOs.stream().filter(e -> {
                            return !e.getEstado().booleanValue();
                        }).sorted((p1, p2) -> {
                            return p1.getNombre().compareTo(p2.getNombre());
                        }).collect(Collectors.toList());
                        this.listParametrizacionDTOs.forEach(e2 -> {
                            this.JCBEmpresa.addItem(e2.getNombre());
                        });
                    } catch (JsonProcessingException e3) {
                        Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e3);
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
            } finally {
            }
        } catch (Throwable th3) {
            if (response != null) {
                if (th != null) {
                    try {
                        response.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    response.close();
                }
            }
            throw th3;
        }
    }

    private void cargarComboProcedimiento() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllProcedure");
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        Throwable th = null;
        try {
            try {
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        List<GenericParametrizacionDTO> listModelLocal = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<GenericParametrizacionDTO>>() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.5
                        });
                        System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.listGenericParametrizacionDTOs));
                        this.listGenericParametrizacionDTOs = (List) listModelLocal.stream().filter(e -> {
                            return !e.getEstado().booleanValue();
                        }).sorted((p1, p2) -> {
                            return p1.getNombre().compareTo(p2.getNombre());
                        }).collect(Collectors.toList());
                        this.listGenericParametrizacionDTOs.forEach(e2 -> {
                            this.JCBProcedimiento.addItem(e2.getNombre());
                        });
                    } catch (JsonProcessingException e3) {
                        Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e3);
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
            } finally {
            }
        } catch (Throwable th3) {
            if (response != null) {
                if (th != null) {
                    try {
                        response.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    response.close();
                }
            }
            throw th3;
        }
    }

    private void nuevo() {
        this.JCBEmpresa.removeAllItems();
        this.JCBProcedimiento.removeAllItems();
        this.JCBTipoPrograma.removeAllItems();
        cargarTabla();
        cargarComboEmpresaConvenio();
        cargarComboProcedimiento();
        cargarComboPrograma();
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JCBTipoPrograma.setSelectedIndex(-1);
    }

    private void grabarRemision() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "saveRemisionExamen");
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBTipoPrograma.getSelectedIndex() != -1) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        try {
                            this.remisionExamenDTO = RemisionExamenDTO.builder().id(this.id).idEmpresaConvenio(this.listParametrizacionDTOs.get(this.JCBEmpresa.getSelectedIndex()).getId()).idProcedimiento(this.listGenericParametrizacionDTOs.get(this.JCBProcedimiento.getSelectedIndex()).getId()).idTipoPrograma(this.tipoProgramaDTOs.get(this.JCBTipoPrograma.getSelectedIndex()).getIdTipoPrograma()).estado(Boolean.valueOf(this.JCHEstado.isSelected())).fecha(this.fecha).idUsuarioS(null).build();
                            System.out.println("Lo que se graba" + this.remisionExamenDTO);
                            Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(this.remisionExamenDTO)));
                            response.close();
                            this.metodos.getResteasyClient().close();
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JDProcedimientoTiempoServicio.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                        nuevo();
                        cargarTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoPrograma.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEmpresa.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JCBIdgrupo2 = new JComboBox();
        this.JCBIdgrupo3 = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        this.jPanel2 = new JPanel();
        this.JBGuardar = new JButton();
        this.JBSalir = new JButton();
        this.JBNuevo = new JButton();
        this.jPanel1 = new JPanel();
        this.JCBProcedimiento = new JComboBox();
        this.JCBTipoPrograma = new JComboBox();
        this.JCBEmpresa = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBIdgrupo2.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo UVRQx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIdgrupo3.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo UVRQx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        setDefaultCloseOperation(2);
        setTitle("REMISION EXAMEN");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.6
            public void mouseClicked(MouseEvent evt) {
                JDRemisionExamen.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.7
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.8
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.setToolTipText("Grabar");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.9
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JBNuevoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JBGuardar, -2, 147, -2).addGap(120, 120, 120).addComponent(this.JBNuevo, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBSalir, -2, 155, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2).addComponent(this.JBNuevo, -2, 50, -2)).addGap(26, 26, 26)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 105, 0)));
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.10
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JCBProcedimientoActionPerformed(evt);
            }
        });
        this.JCBTipoPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPrograma.setActionCommand("");
        this.JCBTipoPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPrograma.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.11
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JCBTipoProgramaActionPerformed(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDRemisionExamen.12
            public void actionPerformed(ActionEvent evt) {
                JDRemisionExamen.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcedimiento, 0, -1, 32767).addComponent(this.JCBEmpresa, -2, 411, -2)).addGap(40, 40, 40).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoPrograma, -2, 270, -2).addComponent(this.JCHEstado, -2, 90, -2))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 7, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoPrograma, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JCBEmpresa, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcedimiento, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JCHEstado).addGap(18, 18, 18)))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jScrollPane1)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 236, 32767).addGap(18, 18, 18).addComponent(this.jPanel2, -2, 68, -2).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        grabarRemision();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProgramaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTHistorico.getSelectedRow() != -1) {
            this.id = Long.valueOf(this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBProcedimiento.setSelectedItem(this.modeloTabla.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCBEmpresa.setSelectedItem(this.modeloTabla.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCBTipoPrograma.setSelectedItem(this.modeloTabla.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.parseBoolean(this.modeloTabla.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoActionPerformed(ActionEvent evt) {
    }
}
