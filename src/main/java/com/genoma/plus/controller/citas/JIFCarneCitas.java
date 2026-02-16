package com.genoma.plus.controller.citas;

import Acceso.Principal;
import Citas.CitasGral;
import Historia.JIFSeguimientoOrdenesLab;
import Utilidades.Metodos;
import com.genoma.plus.dao.citas.CarneCitasDAO;
import com.genoma.plus.dao.impl.citas.CarneCitasDAOImpl;
import com.genoma.plus.dao.impl.parametrizacion.EspecialidadDAOImpl;
import com.genoma.plus.dao.parametrizacion.EspecialidadDAO;
import com.genoma.plus.dto.citas.CarneCitasDTO;
import com.genoma.plus.jpa.projection.ICarneCitas;
import com.genoma.plus.jpa.service.IClaseCitaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/citas/JIFCarneCitas.class */
public class JIFCarneCitas extends JDialog {
    public String idYear;
    private CarneCitasDTO carneCitasDTO;
    private CarneCitasDAOImpl carneCitasDAOImpl;
    private CarneCitasDAO carneCitasDAO;
    private EspecialidadDAOImpl especialidadDAOImpl;
    private EspecialidadDAO especialidadDAO;
    private String[] especialidad;
    private String idPersona;
    private String frmLlamador;
    private DefaultTableModel modelo;
    private int fila;
    private CitasGral frmCita;
    private JIFSeguimientoOrdenesLab xjifseg;
    private Metodos metodos;
    boolean componentesInicializados;
    private String[] centroDeCosto;
    List<Object[]> listadoEspecialidad;
    private List<Integer> filtro;
    private final IClaseCitaService citaService;
    private ButtonGroup JBG_Filtro;
    private JCheckBox JCHFiltro_anno;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_Activas;
    private JRadioButton JRB_Cancelada;
    private JRadioButton JRB_Todas;
    private JButton btnCargarCita;
    private JButton btnSalir;
    private JTable grid;
    private JComboBox<String> jCBEspecialidad;
    private JCheckBox jCHBFiltroEspecialidad;
    private JLabel jLabelNoProgramadas1;
    private JScrollPane jScrollPane1;
    private JSpinner jSpinAnno;
    private JLabel jlabelProgramadas;
    private JPanel panelFondo;

    public JIFCarneCitas(Frame parent, boolean modal, String idpersona, String nbre, Object frm) {
        super(parent, modal);
        this.idYear = "2020";
        this.metodos = new Metodos();
        this.componentesInicializados = false;
        this.citaService = (IClaseCitaService) Principal.contexto.getBean(IClaseCitaService.class);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idPersona = idpersona;
        this.frmLlamador = nbre;
        this.jSpinAnno.setValue(Integer.valueOf(this.metodos.formatoANO.format(this.metodos.getFechaActual())));
        this.idYear = this.jSpinAnno.getValue().toString();
        springStart();
        this.filtro = new ArrayList();
        this.filtro.add(1);
        this.componentesInicializados = true;
        iniciar(frm);
        buscarCitas(this.idYear, this.idPersona);
        this.grid.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.1
            public void mouseClicked(MouseEvent e) {
                JIFCarneCitas.this.fila = JIFCarneCitas.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.carneCitasDAO = (CarneCitasDAOImpl) classPathXmlApplicationContext.getBean("carneCitasDAOImpl");
        this.especialidadDAO = (EspecialidadDAOImpl) classPathXmlApplicationContext.getBean("especialidadDAOImpl");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/citas/JIFCarneCitas$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 14).toString()).booleanValue()) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void iniciar(Object frm) {
        if (this.frmLlamador.equals("Citas")) {
            this.frmCita = (CitasGral) frm;
            this.btnCargarCita.setEnabled(true);
        } else if (this.frmLlamador.equals("jifseguimientolab1")) {
            this.xjifseg = (JIFSeguimientoOrdenesLab) frm;
            this.btnCargarCita.setEnabled(true);
        }
        this.listadoEspecialidad = this.especialidadDAO.listEspecialidad();
        this.especialidad = new String[this.listadoEspecialidad.size()];
        this.jCBEspecialidad.removeAllItems();
        if (this.listadoEspecialidad.size() > 0) {
            for (int z = 0; z < this.listadoEspecialidad.size(); z++) {
                this.jCBEspecialidad.addItem(this.listadoEspecialidad.get(z)[1].toString());
                this.especialidad[z] = this.listadoEspecialidad.get(z)[0].toString();
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.JCHFiltro_anno.setSelected(true);
        }
        try {
            buscarCitas(this.idYear, this.idPersona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Clase Cita", "Profesional", "Especialidad", "Fecha", "Hora Inicio", "Hora Final", "Asistida", "Estado", "IdProfesional", "IdEspecial", "IdCita", "Sede", "Usuario Asignación", "Motivo Desistida", "Programada", "Usuario_Desiste", "Fecha_Desiste"}) { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(14).setMinWidth(0);
        this.grid.getColumnModel().getColumn(14).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    public void buscarCitas(String xidYear, String xidPersona) {
        List<ICarneCitas> citas;
        try {
            crearGrid();
            new ArrayList();
            if (this.jCHBFiltroEspecialidad.isSelected() && this.jCBEspecialidad.getSelectedIndex() > -1 && this.listadoEspecialidad != null) {
                String xidEspecialidad = this.listadoEspecialidad.get(this.jCBEspecialidad.getSelectedIndex())[0].toString();
                citas = this.citaService.listaCitasPorUsuarioIdEspecialidad(Integer.valueOf(this.idYear), Long.valueOf(this.idPersona), Integer.valueOf(xidEspecialidad), this.filtro);
            } else {
                citas = this.citaService.listaCitasPorUsuario(Integer.valueOf(this.idYear), Long.valueOf(this.idPersona), this.filtro, Boolean.valueOf(this.JCHFiltro_anno.isSelected()));
            }
            if (!citas.isEmpty()) {
                this.metodos.mEstablecerTextEditor(this.grid, 0);
                for (int i = 0; i < citas.size(); i++) {
                    this.modelo.addRow(new Object[]{citas.get(i).getClaseCita(), citas.get(i).getProfesional(), citas.get(i).getEspecialidad(), citas.get(i).getFecha_Cita(), citas.get(i).getHoraInicial(), citas.get(i).getHoraFinal(), citas.get(i).getAsistida(), citas.get(i).getId_MotivoDesistida(), citas.get(i).getId_USuario(), citas.get(i).getIdEspecialidad(), citas.get(i).getIdCita(), citas.get(i).getSede(), citas.get(i).getUsuarioAsigna(), citas.get(i).getDetalle(), citas.get(i).getTipoCita(), citas.get(i).getUsuarioDesiste(), citas.get(i).getFechaDesiste()});
                    this.grid.setDefaultRenderer(Object.class, new MiRender2());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void impresionRecordatorioCitas(String idCita) {
        if (this.frmCita != null) {
            this.frmCita.clasescita.imprimirRecordatorioCita(idCita);
        }
    }

    private void cargarCitaProgramada(CarneCitasDTO xcarneCitasDTO) {
        if (this.frmLlamador.equals("Citas")) {
            this.frmCita.cargarCita(xcarneCitasDTO.getProfesional(), xcarneCitasDTO.getEspecialidad(), xcarneCitasDTO.getFecha_Cita());
        } else if (this.frmLlamador.equals("jifseguimientolab1")) {
            this.xjifseg.JTFFNCita.setValue(Long.valueOf(xcarneCitasDTO.getIdCita()));
        }
        dispose();
    }

    private void cargarCitaNoProgramada(CarneCitasDTO xcarneCitasDTO) {
        if (this.frmLlamador.equals("jifseguimientolab1")) {
            this.xjifseg.JTFFNCita.setValue(Long.valueOf(xcarneCitasDTO.getIdCita()));
        }
        dispose();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.panelFondo = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jSpinAnno = new JSpinner();
        this.jlabelProgramadas = new JLabel();
        this.jLabelNoProgramadas1 = new JLabel();
        this.jCBEspecialidad = new JComboBox<>();
        this.jCHBFiltroEspecialidad = new JCheckBox();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todas = new JRadioButton();
        this.JRB_Activas = new JRadioButton();
        this.JRB_Cancelada = new JRadioButton();
        this.btnSalir = new JButton();
        this.btnCargarCita = new JButton();
        this.JCHFiltro_anno = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("LISTADO DE CITAS");
        setName("BuscarCita");
        this.panelFondo.setBorder(BorderFactory.createEtchedBorder());
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.3
            public void mouseClicked(MouseEvent evt) {
                JIFCarneCitas.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(0);
        this.jSpinAnno.setFont(new Font("Arial", 1, 12));
        this.jSpinAnno.setModel(new SpinnerNumberModel(2020, 1800, 2500, 1));
        this.jSpinAnno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jSpinAnno.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.4
            public void stateChanged(ChangeEvent evt) {
                JIFCarneCitas.this.jSpinAnnoStateChanged(evt);
            }
        });
        this.jlabelProgramadas.setBackground(Color.white);
        this.jlabelProgramadas.setFont(new Font("Arial", 1, 12));
        this.jlabelProgramadas.setHorizontalAlignment(0);
        this.jlabelProgramadas.setText("Citas Programadas");
        this.jlabelProgramadas.setOpaque(true);
        this.jLabelNoProgramadas1.setBackground(new Color(177, 251, 177));
        this.jLabelNoProgramadas1.setFont(new Font("Arial", 1, 12));
        this.jLabelNoProgramadas1.setHorizontalAlignment(0);
        this.jLabelNoProgramadas1.setText("Citas No Programadas");
        this.jLabelNoProgramadas1.setOpaque(true);
        this.jCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.jCBEspecialidad.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCHBFiltroEspecialidad.setFont(new Font("Arial", 1, 12));
        this.jCHBFiltroEspecialidad.setText("Filtro Especialidad");
        this.jCHBFiltroEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.5
            public void itemStateChanged(ItemEvent evt) {
                JIFCarneCitas.this.jCHBFiltroEspecialidadItemStateChanged(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.6
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.JRB_TodasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Activas);
        this.JRB_Activas.setFont(new Font("Arial", 1, 12));
        this.JRB_Activas.setSelected(true);
        this.JRB_Activas.setText("Activas");
        this.JRB_Activas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.7
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.JRB_ActivasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Cancelada);
        this.JRB_Cancelada.setFont(new Font("Arial", 1, 12));
        this.JRB_Cancelada.setText("Cancelada");
        this.JRB_Cancelada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.8
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.JRB_CanceladaActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JRB_Todas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Activas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Cancelada).addGap(0, 0, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todas).addComponent(this.JRB_Activas).addComponent(this.JRB_Cancelada)).addGap(0, 12, 32767)));
        GroupLayout panelFondoLayout = new GroupLayout(this.panelFondo);
        this.panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelFondoLayout.createSequentialGroup().addContainerGap().addGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(panelFondoLayout.createSequentialGroup().addComponent(this.jSpinAnno, -2, 100, -2).addGap(18, 18, 18).addComponent(this.jCBEspecialidad, -2, 333, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCHBFiltroEspecialidad).addGap(18, 18, 18).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabelNoProgramadas1, -2, 160, -2).addComponent(this.jlabelProgramadas, -2, 160, -2)))).addContainerGap()));
        panelFondoLayout.setVerticalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelFondoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jSpinAnno, -2, 50, -2).addComponent(this.jCBEspecialidad, -2, 50, -2).addComponent(this.jCHBFiltroEspecialidad)).addGroup(panelFondoLayout.createSequentialGroup().addComponent(this.jlabelProgramadas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabelNoProgramadas1))).addComponent(this.JPI_Filtro, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 473, -2).addContainerGap()));
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setForeground(new Color(0, 0, 153));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.9
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnCargarCita.setFont(new Font("Arial", 1, 12));
        this.btnCargarCita.setForeground(new Color(0, 0, 153));
        this.btnCargarCita.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cita.png")));
        this.btnCargarCita.setText("Cargar Cita ");
        this.btnCargarCita.setEnabled(false);
        this.btnCargarCita.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.10
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.btnCargarCitaActionPerformed(evt);
            }
        });
        this.JCHFiltro_anno.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_anno.setText("Filtro Año ");
        this.JCHFiltro_anno.setToolTipText("");
        this.JCHFiltro_anno.setName("JCHFiltro_anno");
        this.JCHFiltro_anno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFCarneCitas.11
            public void actionPerformed(ActionEvent evt) {
                JIFCarneCitas.this.JCHFiltro_annoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelFondo, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHFiltro_anno).addGap(107, 107, 107).addComponent(this.btnCargarCita, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnSalir, -2, 296, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.panelFondo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnSalir, -2, 50, -2).addComponent(this.btnCargarCita, -2, 50, -2).addComponent(this.JCHFiltro_anno)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarCitaActionPerformed(ActionEvent evt) {
        if (this.modelo.getRowCount() > 0) {
            this.carneCitasDTO = new CarneCitasDTO();
            this.carneCitasDTO.setClaseCita(this.modelo.getValueAt(this.fila, 0).toString());
            this.carneCitasDTO.setProfesional(this.modelo.getValueAt(this.fila, 1).toString());
            this.carneCitasDTO.setEspecialidad(this.modelo.getValueAt(this.fila, 2).toString());
            this.carneCitasDTO.setFecha_Cita(this.modelo.getValueAt(this.fila, 3).toString());
            this.carneCitasDTO.setHoraInicial(this.modelo.getValueAt(this.fila, 4).toString());
            this.carneCitasDTO.setHoraFinal(this.modelo.getValueAt(this.fila, 5).toString());
            this.carneCitasDTO.setAsistida(Boolean.valueOf(this.modelo.getValueAt(this.fila, 6).toString()));
            this.carneCitasDTO.setId_MotivoDesistida(this.modelo.getValueAt(this.fila, 7).toString());
            this.carneCitasDTO.setId_USuario(this.modelo.getValueAt(this.fila, 8).toString());
            this.carneCitasDTO.setIdEspecialidad(this.modelo.getValueAt(this.fila, 9).toString());
            this.carneCitasDTO.setIdCita(this.modelo.getValueAt(this.fila, 10).toString());
            this.carneCitasDTO.setSede(this.modelo.getValueAt(this.fila, 11).toString());
            this.carneCitasDTO.setDetalle(this.modelo.getValueAt(this.fila, 13).toString());
            this.carneCitasDTO.setTipoCita(Boolean.valueOf(this.modelo.getValueAt(this.fila, 14).toString()));
        }
        cargarCita(this.carneCitasDTO);
    }

    private void cargarCita(CarneCitasDTO xcarneCitasDTOx) {
        if (this.carneCitasDTO.getTipoCita().booleanValue()) {
            cargarCitaProgramada(xcarneCitasDTOx);
        } else {
            cargarCitaNoProgramada(xcarneCitasDTOx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            String tipoCita = this.grid.getValueAt(this.grid.getSelectedRow(), 14).toString();
            String idCita = this.grid.getValueAt(this.grid.getSelectedRow(), 10).toString();
            if (tipoCita.equalsIgnoreCase("TRUE")) {
                impresionRecordatorioCitas(idCita);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCHBFiltroEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.componentesInicializados) {
            buscarCitas(this.idYear, this.idPersona);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(0);
        this.filtro.add(1);
        buscarCitas(this.idYear, this.idPersona);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ActivasActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(0);
        buscarCitas(this.idYear, this.idPersona);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CanceladaActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(1);
        buscarCitas(this.idYear, this.idPersona);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jSpinAnnoStateChanged(ChangeEvent evt) {
        if (this.componentesInicializados) {
            try {
                this.idYear = String.valueOf(Integer.parseInt(this.jSpinAnno.getValue().toString()));
                if (this.idPersona != null && this.idYear != null) {
                    buscarCitas(this.idYear, this.idPersona);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltro_annoActionPerformed(ActionEvent evt) {
        buscarCitas(this.idYear, this.idPersona);
    }
}
