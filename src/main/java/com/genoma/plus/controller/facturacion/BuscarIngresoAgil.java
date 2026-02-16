package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.Ingreso;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.IngresoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/BuscarIngresoAgil.class */
public class BuscarIngresoAgil extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private DefaultTableModel modelo;
    private final IngresoService ingresoService;
    private GUsuario usuario;
    private Ingreso ingreso;
    private List<Ingreso> list;
    private Object[] datos;
    private final GUsuarioService usuarioService;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_Carga;
    private JButton JBT_Salir;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_FActivos;
    private JRadioButton JRB_FAnulados;
    private JRadioButton JRB_FTodos;
    private JScrollPane JSP_Datos;
    private JTable JTB_Datos;

    public BuscarIngresoAgil(Frame parent, boolean modal, JInternalFrame frm, GUsuario usuario) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        initComponents();
        this.usuarioService = (GUsuarioService) Principal.contexto.getBean(GUsuarioService.class);
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.usuario = usuario;
        buscarIngreso();
    }

    private void buscarIngreso() {
        crearmodelo();
        this.list = new ArrayList();
        System.out.println("" + this.usuario.getId());
        this.list = this.ingresoService.listaIngresoPorIdUsuario(this.usuario);
        System.out.println("" + this.list.size());
        if (this.list != null && !this.list.isEmpty()) {
            this.list.forEach(detalle -> {
                this.modelo.addRow(this.datos);
                this.JTB_Datos.setValueAt(detalle.getId(), this.JTB_Datos.getRowCount() - 1, 0);
                this.JTB_Datos.setValueAt(detalle.getFecha(), this.JTB_Datos.getRowCount() - 1, 1);
                this.JTB_Datos.setValueAt(detalle.getHoraIngreso(), this.JTB_Datos.getRowCount() - 1, 2);
                this.JTB_Datos.setValueAt(detalle.getIdEmpresaContxConv().getNbre(), this.JTB_Datos.getRowCount() - 1, 3);
                this.JTB_Datos.setValueAt(detalle.getIdEstrato().getNbre(), this.JTB_Datos.getRowCount() - 1, 4);
                this.JTB_Datos.setValueAt(detalle.getIdEspecialidad().getNbre(), this.JTB_Datos.getRowCount() - 1, 5);
                this.JTB_Datos.setValueAt(Integer.valueOf(detalle.getIdProfesional()), this.JTB_Datos.getRowCount() - 1, 6);
                this.JTB_Datos.setValueAt(detalle.getIdTipoAtencion().getNbre(), this.JTB_Datos.getRowCount() - 1, 7);
                this.JTB_Datos.setValueAt(detalle.getIdSede(), this.JTB_Datos.getRowCount() - 1, 8);
                this.JTB_Datos.setValueAt(detalle.getEstado(), this.JTB_Datos.getRowCount() - 1, 9);
            });
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearmodelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "Fecha", "Hora", "Empresa", "Estrato", "Especialidad", "Profesional", "Tipo Atencion", "Sede", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.1
            Class[] types = {Integer.class, Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Datos;
        JTable jTable2 = this.JTB_Datos;
        jTable.setAutoResizeMode(0);
        this.JTB_Datos.doLayout();
        this.JTB_Datos.setModel(this.modelo);
        this.JTB_Datos.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Datos.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTB_Datos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Datos.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTB_Datos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Datos.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTB_Datos.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTB_Datos.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTB_Datos.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTB_Datos.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    private void cargar() {
    }

    private void salir() {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSP_Datos = new JScrollPane();
        this.JTB_Datos = new JTable();
        this.JBT_Carga = new JButton();
        this.JBT_Salir = new JButton();
        this.JPI_Filtro = new JPanel();
        this.JRB_FTodos = new JRadioButton();
        this.JRB_FActivos = new JRadioButton();
        this.JRB_FAnulados = new JRadioButton();
        setDefaultCloseOperation(2);
        this.JSP_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "RSULTADO DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Datos.setFont(new Font("Arial", 1, 12));
        this.JTB_Datos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Datos.setAutoResizeMode(0);
        this.JTB_Datos.setRowHeight(25);
        this.JTB_Datos.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Datos.setSelectionForeground(Color.red);
        this.JTB_Datos.setSelectionMode(0);
        this.JSP_Datos.setViewportView(this.JTB_Datos);
        this.JBT_Carga.setFont(new Font("Arial", 1, 12));
        this.JBT_Carga.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Carga.setText("Cargar");
        this.JBT_Carga.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.2
            public void actionPerformed(ActionEvent evt) {
                BuscarIngresoAgil.this.JBT_CargaActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.3
            public void actionPerformed(ActionEvent evt) {
                BuscarIngresoAgil.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_FTodos);
        this.JRB_FTodos.setFont(new Font("Arial", 1, 12));
        this.JRB_FTodos.setText("Todos");
        this.JRB_FTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.4
            public void actionPerformed(ActionEvent evt) {
                BuscarIngresoAgil.this.JRB_FTodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_FActivos);
        this.JRB_FActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_FActivos.setSelected(true);
        this.JRB_FActivos.setText("Activos");
        this.JRB_FActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.5
            public void actionPerformed(ActionEvent evt) {
                BuscarIngresoAgil.this.JRB_FActivosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_FAnulados);
        this.JRB_FAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_FAnulados.setText("Anulados");
        this.JRB_FAnulados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.BuscarIngresoAgil.6
            public void actionPerformed(ActionEvent evt) {
                BuscarIngresoAgil.this.JRB_FAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addComponent(this.JRB_FTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FAnulados)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FTodos).addComponent(this.JRB_FActivos).addComponent(this.JRB_FAnulados)).addGap(0, 5, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Carga, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 200, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JSP_Datos, -2, 886, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Datos, -2, 285, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Carga, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addComponent(this.JPI_Filtro, -2, -1, -2)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        salir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FTodosActionPerformed(ActionEvent evt) {
        buscarIngreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FActivosActionPerformed(ActionEvent evt) {
        buscarIngreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FAnuladosActionPerformed(ActionEvent evt) {
        buscarIngreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargaActionPerformed(ActionEvent evt) {
    }
}
