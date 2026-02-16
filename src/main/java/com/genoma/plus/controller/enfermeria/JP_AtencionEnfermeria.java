package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import General.Anular;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HEnfAtencion;
import com.genoma.plus.jpa.entities.HEnfAtencionDetalleNanda;
import com.genoma.plus.jpa.entities.HEnfAtencionDetalleNic;
import com.genoma.plus.jpa.entities.HEnfAtencionDetalleNoc;
import com.genoma.plus.jpa.entities.HEnfTiponanda;
import com.genoma.plus.jpa.entities.HEnfTiponic;
import com.genoma.plus.jpa.entities.HEnfTiponoc;
import com.genoma.plus.jpa.projection.IEnfHistoricoAtencion;
import com.genoma.plus.jpa.service.IHEnfAtencionService;
import com.genoma.plus.jpa.service.IHEnfTiponandaService;
import com.genoma.plus.jpa.service.IHEnfTiponicService;
import com.genoma.plus.jpa.service.IHEnfTiponocService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JP_AtencionEnfermeria.class */
public class JP_AtencionEnfermeria extends JPanel {
    private DefaultTableModel modeloNanda;
    private DefaultTableModel modeloNic;
    private DefaultTableModel modeloNoc;
    private DefaultTableModel modeloHistorico;
    private final Metodos metodo;
    private final IHEnfTiponandaService tiponandaService;
    private final IHEnfTiponicService tiponicService;
    private final IHEnfTiponocService tiponocService;
    private final IHEnfAtencionService atencionService;
    private List<HEnfTiponanda> listTipoNanda;
    private List<HEnfTiponic> listTipoNic;
    private List<HEnfTiponoc> listTipoNoc;
    private HEnfAtencion atencion;
    private Long idAtencion;
    private List<Integer> estado;
    private JLabel JLB_Id;
    private JPanel JPIFiltroEstado;
    private JPanel JPI_Datos;
    private JTabbedPane JPI_Detalle;
    private JPanel JPI_Historico;
    private JRadioButton JRB_Activo;
    private JRadioButton JRB_Anulado;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPEFObservaciones;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_Nanda;
    private JScrollPane JSP_Nic;
    private JScrollPane JSP_Noc;
    private JTable JTB_Historico;
    private JTable JTB_Nanda;
    private JTable JTB_Nic;
    private JTable JTB_Noc;
    private JTextPane JTPEFObservaciones;
    private JTabbedPane JTP_Datos;
    private ButtonGroup buttonGroup1;

    public JP_AtencionEnfermeria(String idAtencion, String titulo) {
        initComponents();
        this.metodo = new Metodos();
        this.idAtencion = Long.valueOf(idAtencion);
        this.tiponandaService = (IHEnfTiponandaService) Principal.contexto.getBean(IHEnfTiponandaService.class);
        this.tiponicService = (IHEnfTiponicService) Principal.contexto.getBean(IHEnfTiponicService.class);
        this.tiponocService = (IHEnfTiponocService) Principal.contexto.getBean(IHEnfTiponocService.class);
        this.atencionService = (IHEnfAtencionService) Principal.contexto.getBean(IHEnfAtencionService.class);
        this.listTipoNanda = new ArrayList();
        this.listTipoNic = new ArrayList();
        this.listTipoNoc = new ArrayList();
        this.atencion = new HEnfAtencion();
        setBorder(BorderFactory.createTitledBorder((Border) null, titulo, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Datos = new JPanel();
        this.JPI_Detalle = new JTabbedPane();
        this.JSP_Nanda = new JScrollPane();
        this.JTB_Nanda = new JTable();
        this.JSP_Noc = new JScrollPane();
        this.JTB_Noc = new JTable();
        this.JSP_Nic = new JScrollPane();
        this.JTB_Nic = new JTable();
        this.JSPEFObservaciones = new JScrollPane();
        this.JTPEFObservaciones = new JTextPane();
        this.JLB_Id = new JLabel();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JPIFiltroEstado = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Activo = new JRadioButton();
        this.JRB_Anulado = new JRadioButton();
        setName("jpi_atencionEnfermeria");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Detalle.setForeground(Color.red);
        this.JPI_Detalle.setFont(new Font("Arial", 1, 14));
        this.JSP_Nanda.setFont(new Font("Arial", 1, 14));
        this.JTB_Nanda.setFont(new Font("Arial", 1, 12));
        this.JTB_Nanda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Nanda.setRowHeight(25);
        this.JSP_Nanda.setViewportView(this.JTB_Nanda);
        this.JPI_Detalle.addTab("Diagnóstico de Enfermería", this.JSP_Nanda);
        this.JSP_Noc.setFont(new Font("Arial", 1, 14));
        this.JTB_Noc.setFont(new Font("Arial", 1, 12));
        this.JTB_Noc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Noc.setRowHeight(25);
        this.JSP_Noc.setViewportView(this.JTB_Noc);
        this.JPI_Detalle.addTab("Resultados esperados(NOC)", this.JSP_Noc);
        this.JSP_Nic.setFont(new Font("Arial", 1, 14));
        this.JTB_Nic.setFont(new Font("Arial", 1, 12));
        this.JTB_Nic.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Nic.setRowHeight(25);
        this.JSP_Nic.setViewportView(this.JTB_Nic);
        this.JPI_Detalle.addTab("Intervenciones (NIC)", this.JSP_Nic);
        this.JSPEFObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Evaluación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.1
            public void keyPressed(KeyEvent evt) {
                JP_AtencionEnfermeria.this.JTPEFObservacionesKeyPressed(evt);
            }
        });
        this.JSPEFObservaciones.setViewportView(this.JTPEFObservaciones);
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_Detalle)).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPEFObservaciones, -2, 656, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Id, -1, 128, 32767))).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Detalle, -1, 409, 32767).addGap(18, 18, 18).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPEFObservaciones, -1, 58, 32767).addComponent(this.JLB_Id, -1, -1, 32767))));
        this.JTP_Datos.addTab("INFORMACIÓN", this.JPI_Datos);
        this.JSP_Historico.setFont(new Font("Arial", 1, 14));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.2
            public void mouseClicked(MouseEvent evt) {
                JP_AtencionEnfermeria.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        this.JPIFiltroEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro estado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.3
            public void actionPerformed(ActionEvent evt) {
                JP_AtencionEnfermeria.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_Activo);
        this.JRB_Activo.setFont(new Font("Arial", 1, 12));
        this.JRB_Activo.setSelected(true);
        this.JRB_Activo.setText("Activos");
        this.JRB_Activo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.4
            public void actionPerformed(ActionEvent evt) {
                JP_AtencionEnfermeria.this.JRB_ActivoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_Anulado);
        this.JRB_Anulado.setFont(new Font("Arial", 1, 12));
        this.JRB_Anulado.setText("Anulado");
        this.JRB_Anulado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.5
            public void actionPerformed(ActionEvent evt) {
                JP_AtencionEnfermeria.this.JRB_AnuladoActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroEstadoLayout = new GroupLayout(this.JPIFiltroEstado);
        this.JPIFiltroEstado.setLayout(JPIFiltroEstadoLayout);
        JPIFiltroEstadoLayout.setHorizontalGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addGap(18, 18, 18).addComponent(this.JRB_Activo, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Anulado, -2, 78, -2).addContainerGap(19, 32767)));
        JPIFiltroEstadoLayout.setVerticalGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Activo).addComponent(this.JRB_Anulado))));
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JPIFiltroEstado, -2, -1, -2).addContainerGap(520, 32767)).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(15, 32767).addComponent(this.JSP_Historico, -2, 778, -2).addContainerGap(15, 32767))));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(439, 32767).addComponent(this.JPIFiltroEstado, -2, -1, -2).addContainerGap()).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -2, 424, -2).addContainerGap(61, 32767))));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, -1, -2).addContainerGap(13, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEFObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEFObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            this.atencion = new HEnfAtencion();
            this.atencion = this.atencionService.findById(Integer.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()));
            this.JLB_Id.setText("" + this.atencion.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        this.estado = new ArrayList();
        this.estado.add(1);
        this.estado.add(0);
        cargarDatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ActivoActionPerformed(ActionEvent evt) {
        this.estado = new ArrayList();
        this.estado.add(1);
        cargarDatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AnuladoActionPerformed(ActionEvent evt) {
        this.estado = new ArrayList();
        this.estado.add(0);
        cargarDatosHistorico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloNanda() {
        this.modeloNanda = new DefaultTableModel(new Object[0], new String[]{"S", "Diagnóstico", "Clase", "Dominio", "id"}) { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.6
            Class[] types = {Boolean.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Nanda.setAutoResizeMode(0);
        this.JTB_Nanda.doLayout();
        this.JTB_Nanda.setModel(this.modeloNanda);
        this.JTB_Nanda.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_Nanda.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTB_Nanda.getColumnModel().getColumn(2).setPreferredWidth(160);
        this.JTB_Nanda.getColumnModel().getColumn(3).setPreferredWidth(160);
        this.JTB_Nanda.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_Nanda.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_Nanda.getColumnModel().getColumn(4).setMaxWidth(0);
        this.metodo.mEstablecerTextEditor(this.JTB_Nanda, 1);
        this.metodo.mEstablecerTextEditor(this.JTB_Nanda, 2);
        this.metodo.mEstablecerTextEditor(this.JTB_Nanda, 3);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloNic() {
        this.modeloNic = new DefaultTableModel(new Object[0], new String[]{"S", "nombre", "id"}) { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.7
            Class[] types = {Boolean.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Nic.setAutoResizeMode(0);
        this.JTB_Nic.doLayout();
        this.JTB_Nic.setModel(this.modeloNic);
        this.JTB_Nic.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_Nic.getColumnModel().getColumn(1).setPreferredWidth(730);
        this.JTB_Nic.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTB_Nic.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTB_Nic.getColumnModel().getColumn(2).setMaxWidth(0);
        this.metodo.mEstablecerTextEditor(this.JTB_Nic, 1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloNoc() {
        this.modeloNoc = new DefaultTableModel(new Object[0], new String[]{"S", "nombre", "id"}) { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.8
            Class[] types = {Boolean.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Noc.setAutoResizeMode(0);
        this.JTB_Noc.doLayout();
        this.JTB_Noc.setModel(this.modeloNoc);
        this.JTB_Noc.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_Noc.getColumnModel().getColumn(1).setPreferredWidth(730);
        this.JTB_Noc.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTB_Noc.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTB_Noc.getColumnModel().getColumn(2).setMaxWidth(0);
        this.metodo.mEstablecerTextEditor(this.JTB_Noc, 1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"id", "Fecha", "observación", "profesional", "especialidad", "estado"}) { // from class: com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria.9
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setAutoResizeMode(0);
        this.JTB_Historico.doLayout();
        this.JTB_Historico.setModel(this.modeloHistorico);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void cargarDatosModelo() {
        crearModeloNanda();
        Object[] datos = null;
        this.listTipoNanda = this.tiponandaService.findAllByEstado(true);
        if (!this.listTipoNanda.isEmpty()) {
            this.listTipoNanda.forEach(e -> {
                this.modeloNanda.addRow(datos);
                this.modeloNanda.setValueAt(false, this.JTB_Nanda.getRowCount() - 1, 0);
                this.modeloNanda.setValueAt(e.getCodigo().concat(" ").concat(e.getNombreDiagnostico()), this.JTB_Nanda.getRowCount() - 1, 1);
                this.modeloNanda.setValueAt(e.getNombreClase(), this.JTB_Nanda.getRowCount() - 1, 2);
                this.modeloNanda.setValueAt(e.getNombreDominio(), this.JTB_Nanda.getRowCount() - 1, 3);
                this.modeloNanda.setValueAt(e.getId(), this.JTB_Nanda.getRowCount() - 1, 4);
            });
        }
        crearModeloNoc();
        this.listTipoNoc = this.tiponocService.findAllByEstado(true);
        if (!this.listTipoNoc.isEmpty()) {
            this.listTipoNoc.forEach(e2 -> {
                this.modeloNoc.addRow(datos);
                this.modeloNoc.setValueAt(false, this.JTB_Noc.getRowCount() - 1, 0);
                this.modeloNoc.setValueAt(e2.getCodigo().concat(" ").concat(e2.getNombre()), this.JTB_Noc.getRowCount() - 1, 1);
                this.modeloNoc.setValueAt(e2.getId(), this.JTB_Noc.getRowCount() - 1, 2);
            });
        }
        crearModeloNic();
        this.listTipoNic = this.tiponicService.findAllByEstado(true);
        if (!this.listTipoNic.isEmpty()) {
            this.listTipoNic.forEach(e3 -> {
                this.modeloNic.addRow(datos);
                this.modeloNic.setValueAt(false, this.JTB_Nic.getRowCount() - 1, 0);
                this.modeloNic.setValueAt(e3.getCodigo().concat(" ").concat(e3.getNombre()), this.JTB_Nic.getRowCount() - 1, 1);
                this.modeloNic.setValueAt(e3.getId(), this.JTB_Nic.getRowCount() - 1, 2);
            });
        }
    }

    private void cargarDatosHistorico() {
        crearModeloHistorico();
        Object[] datos = null;
        List<IEnfHistoricoAtencion> list = this.atencionService.listHistoricoAtenciones(this.idAtencion, this.estado);
        if (!list.isEmpty()) {
            list.forEach(e -> {
                this.modeloHistorico.addRow(datos);
                this.modeloHistorico.setValueAt(e.getId(), this.JTB_Historico.getRowCount() - 1, 0);
                this.modeloHistorico.setValueAt(e.getFechaRegistro(), this.JTB_Historico.getRowCount() - 1, 1);
                this.modeloHistorico.setValueAt(e.getObservacion(), this.JTB_Historico.getRowCount() - 1, 2);
                this.modeloHistorico.setValueAt(e.getNombreProfesional(), this.JTB_Historico.getRowCount() - 1, 3);
                this.modeloHistorico.setValueAt(e.getNombreEspecialidad(), this.JTB_Historico.getRowCount() - 1, 4);
                this.modeloHistorico.setValueAt(e.getEstado(), this.JTB_Historico.getRowCount() - 1, 5);
            });
        }
    }

    public void nuevo() {
        this.JLB_Id.setText("");
        this.JRB_Activo.setSelected(true);
        this.estado = new ArrayList();
        this.estado.add(1);
        cargarDatosModelo();
        cargarDatosHistorico();
    }

    public void grabar() {
        if (this.metodo.mVerificarDatosTablaTrue(this.JTB_Nanda, 0)) {
            if (this.metodo.mVerificarDatosTablaTrue(this.JTB_Noc, 0)) {
                if (this.metodo.mVerificarDatosTablaTrue(this.JTB_Nic, 0)) {
                    int x = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.atencion.setEstado(true);
                        this.atencion.setFecha(this.metodo.getFechaActual());
                        this.atencion.setIdAtencion(this.idAtencion);
                        this.atencion.setFechaRegistro(this.metodo.getFechaActual());
                        this.atencion.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                        this.atencion.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                        this.atencion.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        this.atencion.setObservacion(this.JTPEFObservaciones.getText());
                        List<HEnfAtencionDetalleNanda> listDetalleNanda = new ArrayList<>();
                        for (int i = 0; i < this.JTB_Nanda.getRowCount(); i++) {
                            if (Boolean.valueOf(this.JTB_Nanda.getValueAt(i, 0).toString()).booleanValue()) {
                                HEnfAtencionDetalleNanda nanda = new HEnfAtencionDetalleNanda();
                                nanda.setIdAtencionEnf(this.atencion);
                                nanda.setIdTipoNanda(this.listTipoNanda.get(i));
                                listDetalleNanda.add(nanda);
                            }
                        }
                        this.atencion.setHEnfAtencionDetalleNandaCollection(listDetalleNanda);
                        List<HEnfAtencionDetalleNic> listDetalleNic = new ArrayList<>();
                        for (int i2 = 0; i2 < this.JTB_Nic.getRowCount(); i2++) {
                            if (Boolean.valueOf(this.JTB_Nic.getValueAt(i2, 0).toString()).booleanValue()) {
                                HEnfAtencionDetalleNic nic = new HEnfAtencionDetalleNic();
                                nic.setIdAtencionEnf(this.atencion);
                                nic.setIdTipoNic(this.listTipoNic.get(i2));
                                listDetalleNic.add(nic);
                            }
                        }
                        this.atencion.setHEnfAtencionDetalleNicCollection(listDetalleNic);
                        List<HEnfAtencionDetalleNoc> listDetalleNoc = new ArrayList<>();
                        for (int i3 = 0; i3 < this.JTB_Noc.getRowCount(); i3++) {
                            if (Boolean.valueOf(this.JTB_Noc.getValueAt(i3, 0).toString()).booleanValue()) {
                                HEnfAtencionDetalleNoc noc = new HEnfAtencionDetalleNoc();
                                noc.setIdAtencionEnf(this.atencion);
                                noc.setIdTipoNoc(this.listTipoNoc.get(i3));
                                listDetalleNoc.add(noc);
                            }
                        }
                        this.atencion.setHEnfAtencionDetalleNocCollection(listDetalleNoc);
                        this.atencion = this.atencionService.save(this.atencion);
                        this.JLB_Id.setText("" + this.atencion.getId());
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe haber seleccionado por lo meno una inervención NIC", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JPI_Detalle.setSelectedIndex(2);
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe haber seleccionado por lo meno un resultado esperado NOC", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JPI_Detalle.setSelectedIndex(1);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe haber seleccionado por lo meno un diagnóstico NANDA", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JPI_Detalle.setSelectedIndex(0);
    }

    public void imprimir() {
        ClaseImpresionInformes informes = new ClaseImpresionInformes();
        informes.imprimirHistoriaProcesoEnfemero(String.valueOf(this.idAtencion));
    }

    public void anular() {
        if (!this.JLB_Id.getText().isEmpty() && this.atencion.isEstado()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jpi_atencionEnfermeria", 3);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularDatos(String xid, String xmotivo) {
        this.atencion.setEstado(false);
        this.atencion.setConceptoAnulacion(xid);
        this.atencion.setFechaAnulacion(this.metodo.getFechaActual());
        this.atencion.setObservacionAnulacion(xmotivo);
        this.atencion.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.atencionService.save(this.atencion);
        nuevo();
    }
}
