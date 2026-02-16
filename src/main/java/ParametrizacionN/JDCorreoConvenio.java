package ParametrizacionN;

import Historia.JPI_Control_Impresion;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.general.dto.ModuleDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.parametrizacion.ConventionDTO;
import com.genoma.plus.controller.parametrizacion.CorreosConvenioDTO;
import com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDCorreoConvenio.class */
public class JDCorreoConvenio extends JDialog {
    private Integer idConvenioE;
    private int xestadoec;
    private Object[] xdato;
    private DefaultTableModel modeloDato;
    private Integer idModulo;
    private String xId_Ingreso;
    private ConventionDTO convenioDto;
    private ConventionDTO DetalleConvenioDTO;
    private Metodos metodos;
    private List<CorreosConvenioDTO> listDto;
    private List<ModuleDTO> listModuloDTOs;
    private int xestado;
    private JButton JBtnGuardar;
    private JButton JBtnNuevo;
    private JButton JBtnSalir;
    private JComboBox JCBModulo;
    private JCheckBox JCHEstadoEC;
    private JPanel JPI_Exportacion6;
    private JFormattedTextField JTFArea;
    private JFormattedTextField JTFCorreo;
    private JTable JTableHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDCorreoConvenio(Frame parent, boolean modal, Object xllamador, Integer idConvenioe) {
        super(parent, modal);
        this.xestadoec = 0;
        this.DetalleConvenioDTO = new ConventionDTO();
        this.metodos = new Metodos();
        this.xestado = 0;
        initComponents();
        this.idConvenioE = idConvenioe;
        this.listDto = new ArrayList();
        this.listModuloDTOs = new ArrayList();
        cargarCombo();
        buscarCorreosConvenio();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDato() {
        this.modeloDato = new DefaultTableModel(new Object[0], new String[]{"Modulo", "Area", "Correo", "Estado"}) { // from class: ParametrizacionN.JDCorreoConvenio.1
            Class[] types = {String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTableHistorico.setModel(this.modeloDato);
        this.JTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.JTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTableHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void limpiar() {
        this.JTFArea.setText("");
        this.JTFCorreo.setText("");
        this.JCHEstadoEC.isSelected();
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0148: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:25:0x0148 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x014c: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:27:0x014c */
    private void buscarCorreosConvenio() {
        try {
            try {
                crearModeloDato();
                RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "ListaCorreosConvenio");
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.idConvenioE;
                System.out.println("fullurlSql --- " + fullUrl);
                Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
                Throwable th = null;
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        this.DetalleConvenioDTO = (ConventionDTO) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<ConventionDTO>() { // from class: ParametrizacionN.JDCorreoConvenio.2
                        });
                        if (this.DetalleConvenioDTO != null) {
                            this.JTableHistorico.setAutoResizeMode(4);
                            if (this.DetalleConvenioDTO.getMetadataDomain() != null) {
                                this.listDto = new ArrayList();
                                System.out.println(this.DetalleConvenioDTO.getMetadataDomain());
                                this.listDto = this.DetalleConvenioDTO.getMetadataDomain();
                                this.listDto.forEach(e -> {
                                    this.modeloDato.addRow(this.xdato);
                                    this.JTableHistorico.setValueAt(obtenerNombreModuloPorId(e.getIdModulo()), this.JTableHistorico.getRowCount() - 1, 0);
                                    this.modeloDato.setValueAt(e.getArea(), this.JTableHistorico.getRowCount() - 1, 1);
                                    this.modeloDato.setValueAt(e.getCorreo(), this.JTableHistorico.getRowCount() - 1, 2);
                                    this.modeloDato.setValueAt(e.getEstado(), this.JTableHistorico.getRowCount() - 1, 3);
                                });
                            }
                        }
                    } catch (JsonProcessingException e2) {
                        Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, e2);
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
        } catch (NumberFormatException e3) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
        }
    }

    public void grabarCorreoConvenio() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "saveCorreoConvenio");
        if (this.JTFArea.getText() != null) {
            if (this.JTFCorreo.getText() != null) {
                if (!this.metodos.getValidacionCorreo(this.JTFCorreo.getText()).booleanValue()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        try {
                            CorreosConvenioDTO dTO = CorreosConvenioDTO.builder().idModulo(this.listModuloDTOs.get(this.JCBModulo.getSelectedIndex()).getId()).area(this.JTFArea.getText()).correo(this.JTFCorreo.getText()).estado(Boolean.valueOf(this.JCHEstadoEC.isSelected())).build();
                            this.listDto.add(dTO);
                            this.convenioDto = ConventionDTO.builder().id(this.idConvenioE).name("").metadataDomain(this.listDto).build();
                            Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(this.convenioDto)));
                            response.close();
                            this.metodos.getResteasyClient().close();
                            buscarCorreosConvenio();
                            return;
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JDProcedimientoCntCode.class.getName()).log(Level.SEVERE, (String) null, e);
                            return;
                        }
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Correo electrónico no cumple con características\nFavor revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCorreo.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debes llenar Correo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCorreo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe llenar  area", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFArea.requestFocus();
    }

    private String obtenerNombreModuloPorId(Integer idModulo) {
        return (String) this.listModuloDTOs.stream().filter(modulo -> {
            return modulo.getId().equals(idModulo);
        }).map((v0) -> {
            return v0.getName();
        }).findFirst().orElse("Nombre desconocido");
    }

    private void cargarCombo() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "moduleFind");
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        Throwable th = null;
        try {
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    this.listModuloDTOs = new ArrayList();
                    this.listModuloDTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ModuleDTO>>() { // from class: ParametrizacionN.JDCorreoConvenio.3
                    });
                    this.listModuloDTOs = (List) this.listModuloDTOs.stream().filter(e -> {
                        return !e.getState().booleanValue();
                    }).sorted((p1, p2) -> {
                        return p1.getName().compareTo(p2.getName());
                    }).collect(Collectors.toList());
                    this.listModuloDTOs.forEach(e2 -> {
                        this.JCBModulo.addItem(e2.getName());
                    });
                } catch (JsonProcessingException e3) {
                    Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e3);
                }
            }
            this.metodos.getResteasyClient().close();
        } finally {
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
        }
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFArea = new JFormattedTextField();
        this.JTFCorreo = new JFormattedTextField();
        this.JCHEstadoEC = new JCheckBox();
        this.JCBModulo = new JComboBox();
        this.JPI_Exportacion6 = new JPanel();
        this.JBtnSalir = new JButton();
        this.JBtnNuevo = new JButton();
        this.JBtnGuardar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTableHistorico = new JTable();
        setDefaultCloseOperation(2);
        setTitle("CORREO CONVENIO");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFArea.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEC.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEC.setSelected(true);
        this.JCHEstadoEC.setText("Estado");
        this.JCHEstadoEC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCorreoConvenio.4
            public void actionPerformed(ActionEvent evt) {
                JDCorreoConvenio.this.JCHEstadoECActionPerformed(evt);
            }
        });
        this.JCBModulo.setFont(new Font("Arial", 1, 12));
        this.JCBModulo.setBorder(BorderFactory.createTitledBorder((Border) null, "Modulos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBModulo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCorreoConvenio.5
            public void actionPerformed(ActionEvent evt) {
                JDCorreoConvenio.this.JCBModuloActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBModulo, 0, 305, 32767).addComponent(this.JTFCorreo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFArea, -2, 164, -2).addComponent(this.JCHEstadoEC)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFArea, -2, 50, -2).addComponent(this.JCBModulo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCorreo, -2, 50, -2).addComponent(this.JCHEstadoEC, -2, 41, -2)).addContainerGap()));
        this.JTFArea.getAccessibleContext().setAccessibleDescription("");
        this.JBtnSalir.setFont(new Font("Arial", 1, 12));
        this.JBtnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBtnSalir.setText("Salir");
        this.JBtnSalir.setToolTipText("Grabar");
        this.JBtnSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCorreoConvenio.6
            public void actionPerformed(ActionEvent evt) {
                JDCorreoConvenio.this.JBtnSalirActionPerformed(evt);
            }
        });
        this.JBtnNuevo.setFont(new Font("Arial", 1, 12));
        this.JBtnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBtnNuevo.setText("Nuevo");
        this.JBtnNuevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCorreoConvenio.7
            public void actionPerformed(ActionEvent evt) {
                JDCorreoConvenio.this.JBtnNuevoActionPerformed(evt);
            }
        });
        this.JBtnGuardar.setFont(new Font("Arial", 1, 12));
        this.JBtnGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBtnGuardar.setText("Guardar");
        this.JBtnGuardar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCorreoConvenio.8
            public void actionPerformed(ActionEvent evt) {
                JDCorreoConvenio.this.JBtnGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Exportacion6Layout = new GroupLayout(this.JPI_Exportacion6);
        this.JPI_Exportacion6.setLayout(JPI_Exportacion6Layout);
        JPI_Exportacion6Layout.setHorizontalGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Exportacion6Layout.createSequentialGroup().addComponent(this.JBtnGuardar, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBtnNuevo, -2, 130, -2).addGap(59, 59, 59).addComponent(this.JBtnSalir, -2, 130, -2).addContainerGap()));
        JPI_Exportacion6Layout.setVerticalGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Exportacion6Layout.createSequentialGroup().addGap(0, 3, 32767).addGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBtnGuardar, -2, 50, -2).addComponent(this.JBtnNuevo, -2, 50, -2).addComponent(this.JBtnSalir, -2, 50, -2)).addContainerGap()));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTableHistorico.setFont(new Font("Arial", 1, 12));
        this.JTableHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTableHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDCorreoConvenio.9
            public void mouseClicked(MouseEvent evt) {
                JDCorreoConvenio.this.JTableHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTableHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Exportacion6, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 513, 32767)).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Exportacion6, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTableHistorico.getSelectedRow() != -1) {
            this.JCBModulo.setSelectedItem(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 0).toString());
            this.JTFArea.setText(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 1).toString());
            this.JTFCorreo.setText(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 2).toString());
            this.JCHEstadoEC.setSelected(Boolean.parseBoolean(this.modeloDato.getValueAt(this.JTableHistorico.getSelectedRow(), 3).toString()));
            this.listDto.remove(this.JTableHistorico.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBtnNuevoActionPerformed(ActionEvent evt) {
        limpiar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBtnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBtnGuardarActionPerformed(ActionEvent evt) {
        grabarCorreoConvenio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoECActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEC.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBModuloActionPerformed(ActionEvent evt) {
    }
}
