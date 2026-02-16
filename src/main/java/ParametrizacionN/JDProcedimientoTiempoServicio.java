package ParametrizacionN;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.parametrizacion.ProcedimientoTiempoDTO;
import com.genoma.plus.controller.parametrizacion.TipoAtencionTiempoDTO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDProcedimientoTiempoServicio.class */
public class JDProcedimientoTiempoServicio extends JDialog {
    private final Metodos metodos;
    private List<ProcedimientoTiempoDTO> listProcedimientosdTOs;
    private ProcedimientoTiempoDTO procedimientoTiempoDTO;
    private DefaultTableModel modeloDato;
    private List<TipoAtencionTiempoDTO> atencionTiempoDTO;
    private List<TipoAtencionTiempoDTO> listTipoAtencionTiempo;
    private final String idProcedimiento;
    private Integer id;
    LocalDateTime fecha;
    int xestado;
    private JButton JBGuardar;
    private JButton JBSalir;
    private JButton JBT_NUevo;
    private JComboBox<String> JCB_Servicios;
    private JCheckBox JCHBEstado;
    private JTable JTableHistorico;
    private JLabel jLabel1;
    private JLabel jLabel1Nmbr;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSpinner jSpinnerTiempo;

    public JDProcedimientoTiempoServicio(Frame parent, boolean modal, String idProcedimiento, String nombreProcedimiento, String pnombre) {
        super(parent, modal);
        this.fecha = LocalDateTime.now();
        this.xestado = 0;
        initComponents();
        this.metodos = new Metodos();
        this.idProcedimiento = idProcedimiento;
        this.jLabel1Nmbr.setText(idProcedimiento + "-" + nombreProcedimiento);
        setTitle(pnombre);
        llenarComboServicio();
        crearModeloDato();
        cargartabla();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JCB_Servicios.addPopupMenuListener(new CustomPopupMenuListener(true, false));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDato() {
        this.modeloDato = new DefaultTableModel(new Object[0], new String[]{"Id", "Servicio", "Tiempo", "Estado"}) { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.1
            Class[] types = {String.class, String.class, LocalDate.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTableHistorico.setAutoResizeMode(4);
        this.JTableHistorico.doLayout();
        this.JTableHistorico.setModel(this.modeloDato);
        this.JTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTableHistorico.getColumnModel().getColumn(3).setPreferredWidth(40);
    }

    public void llenarComboServicio() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllTipoAtencion");
        System.out.println("recurso: " + microserviciosDomain.getUrlRecurso());
        String fullUrl = microserviciosDomain.getUrlRecurso();
        Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                this.atencionTiempoDTO = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<TipoAtencionTiempoDTO>>() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.2
                });
                System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.atencionTiempoDTO));
                this.atencionTiempoDTO = (List) this.atencionTiempoDTO.stream().filter(e -> {
                    return !e.isEstado();
                }).sorted((p1, p2) -> {
                    return p1.getNbre().compareTo(p2.getNbre());
                }).collect(Collectors.toList());
                this.atencionTiempoDTO.forEach(d -> {
                    this.JCB_Servicios.addItem(d.getNbre());
                });
                this.listTipoAtencionTiempo = this.atencionTiempoDTO;
            } catch (JsonProcessingException e2) {
            }
        }
        response.close();
        this.metodos.getResteasyClient().close();
    }

    private void cargartabla() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllProcedimientoTiempo");
            String fullUrl = microserviciosDomain.getUrlRecurso();
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            crearModeloDato();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                this.listProcedimientosdTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ProcedimientoTiempoDTO>>() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.3
                });
                Object[] dato = null;
                this.listProcedimientosdTOs.forEach(e -> {
                    this.modeloDato.addRow(dato);
                    this.modeloDato.setValueAt(e.getId(), this.JTableHistorico.getRowCount() - 1, 0);
                    TipoAtencionTiempoDTO servicio = this.atencionTiempoDTO.stream().filter(tipoAtencion -> {
                        return tipoAtencion.getId().equals(e.getIdServicio());
                    }).findFirst().orElse(null);
                    if (servicio != null) {
                        this.modeloDato.setValueAt(servicio.getNbre(), this.JTableHistorico.getRowCount() - 1, 1);
                    } else {
                        this.modeloDato.setValueAt("Nombre no encontrado", this.JTableHistorico.getRowCount() - 1, 1);
                    }
                    this.modeloDato.setValueAt(e.getTiempo(), this.JTableHistorico.getRowCount() - 1, 2);
                    this.modeloDato.setValueAt(e.getEstado(), this.JTableHistorico.getRowCount() - 1, 3);
                });
            }
            response.close();
            this.metodos.getResteasyClient().close();
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JDProcedimientoTiempoServicio.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    private void nuevo() {
        this.JCB_Servicios.removeAllItems();
        llenarComboServicio();
        this.jSpinnerTiempo.setValue(0);
        this.JCB_Servicios.setSelectedIndex(-1);
        cargartabla();
    }

    public void grabarTiempoProcedimiento() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "saveProcedimientoTiempo");
        System.out.println("" + microserviciosDomain);
        if (this.JCB_Servicios.getSelectedIndex() != -1) {
            System.out.println("" + this.JCB_Servicios);
            if (!this.jSpinnerTiempo.getValue().equals(0)) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    try {
                        int valorDelSpinner = ((Integer) this.jSpinnerTiempo.getValue()).intValue();
                        this.procedimientoTiempoDTO = ProcedimientoTiempoDTO.builder().id(this.id).idServicio(this.listTipoAtencionTiempo.get(this.JCB_Servicios.getSelectedIndex()).getId()).idProcedimiento(Long.valueOf(this.idProcedimiento)).tiempo(Integer.valueOf(valorDelSpinner)).estado(Boolean.valueOf(this.JCHBEstado.isSelected())).fecha(this.fecha).idUsuarioRh(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString()).build();
                        System.out.println("Lo que se graba" + this.procedimientoTiempoDTO);
                        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(this.procedimientoTiempoDTO)));
                        response.close();
                        this.metodos.getResteasyClient().close();
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(JDProcedimientoTiempoServicio.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                    nuevo();
                    cargartabla();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el Tiempo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.jSpinnerTiempo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCB_Servicios.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTableHistorico = new JTable();
        this.jPanel1 = new JPanel();
        this.jSpinnerTiempo = new JSpinner();
        this.jLabel1Nmbr = new JLabel();
        this.JCB_Servicios = new JComboBox<>();
        this.JCHBEstado = new JCheckBox();
        this.JBGuardar = new JButton();
        this.JBSalir = new JButton();
        this.JBT_NUevo = new JButton();
        this.jLabel1.setText("jLabel1");
        setTitle("Procedimiento Por Cnt");
        setIconImage(null);
        setName("JDCntCode");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTableHistorico.setFont(new Font("Arial", 1, 12));
        this.JTableHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTableHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.4
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientoTiempoServicio.this.JTableHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTableHistorico);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 105, 0)));
        this.jSpinnerTiempo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo(Minutos)", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.jLabel1Nmbr.setFont(new Font("Arial", 1, 14));
        this.jLabel1Nmbr.setBorder(new MatteBorder((Icon) null));
        this.JCB_Servicios.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicios.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicios.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.5
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoTiempoServicio.this.JCB_ServiciosActionPerformed(evt);
            }
        });
        this.JCHBEstado.setFont(new Font("Arial", 1, 12));
        this.JCHBEstado.setSelected(true);
        this.JCHBEstado.setText("Estado");
        this.JCHBEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.6
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoTiempoServicio.this.JCHBEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1Nmbr, -1, -1, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCB_Servicios, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, 32767).addComponent(this.jSpinnerTiempo, -2, 167, -2).addGap(18, 18, 18).addComponent(this.JCHBEstado).addGap(19, 19, 19)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1Nmbr, -1, 37, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBEstado, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jSpinnerTiempo, GroupLayout.Alignment.TRAILING, -2, 52, -2).addComponent(this.JCB_Servicios, -2, 50, -2)).addGap(12, 12, 12)));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.7
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientoTiempoServicio.this.JBGuardarMouseClicked(evt);
            }
        });
        this.JBGuardar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.8
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoTiempoServicio.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.9
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoTiempoServicio.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoTiempoServicio.10
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoTiempoServicio.this.JBT_NUevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 130, -2).addGap(108, 108, 108).addComponent(this.JBT_NUevo, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBSalir, -2, 130, -2)).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2)).addContainerGap(18, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarMouseClicked(MouseEvent evt) {
        grabarTiempoProcedimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTableHistorico.getSelectedRow() != -1) {
            this.id = Integer.valueOf(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 0).toString());
            this.JCB_Servicios.setSelectedItem(this.modeloDato.getValueAt(this.JTableHistorico.getSelectedRow(), 1).toString());
            this.jSpinnerTiempo.setValue(this.modeloDato.getValueAt(this.JTableHistorico.getSelectedRow(), 2));
            this.JCHBEstado.setSelected(Boolean.valueOf(this.modeloDato.getValueAt(this.JTableHistorico.getSelectedRow(), 3).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServiciosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHBEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }
}
