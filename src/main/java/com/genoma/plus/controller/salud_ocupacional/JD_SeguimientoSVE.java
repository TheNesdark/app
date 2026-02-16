package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.SoManpowerSeguimiento;
import com.genoma.plus.jpa.entities.SoManpowerSeguimientoDetalle;
import com.genoma.plus.jpa.entities.SoManpowerSeguimientoDetalleS;
import com.genoma.plus.jpa.entities.TipoVigilanciaDTO;
import com.genoma.plus.jpa.entities.VigilanciaSeguimientoEntity;
import com.genoma.plus.jpa.service.ISoManpowerSeguimientoDetalleSService;
import com.genoma.plus.jpa.service.ISoManpowerSeguimientoService;
import com.genoma.plus.jpa.service.ITipoVigilanciaSeguimientoService;
import com.genoma.plus.jpa.service.VigilanciaSeguimientoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JD_SeguimientoSVE.class */
public class JD_SeguimientoSVE extends JDialog {
    private DefaultTableModel modeloTipoVigilancia;
    private DefaultTableModel modelSeguimiento;
    private final ISoManpowerSeguimientoService iSoManpowerSeguimientoService;
    private final VigilanciaSeguimientoService iVigilanciaSeguimientoService;
    private final ISoManpowerSeguimientoDetalleSService iSoManpowerSeguimientoDetalleSService;
    private List<SoManpowerSeguimiento> listManpowerSeguimientos;
    private final Long idManPower;
    private final Metodos metodo;
    private Object[] dato;
    private List<SoManpowerSeguimientoDetalle> listManpowerSeguimientoDetalle;
    private TipoVigilanciaDTO tipoVigilanciaDTO;
    List<VigilanciaSeguimientoEntity> listVigilanciaSeguimientoEntity;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCBTiposSeguimiento;
    private JCheckBox JCHFiltroAnalisis;
    private JCheckBox JCHUltimo;
    private JPanel JPIDatosS;
    private JScrollPane JSPDescripcion_Seg;
    private JScrollPane JSPSHistorico;
    private JScrollPane JSPTipoVigilancia;
    private JTable JTBSHistorico;
    private JTable JTBTipoVigilancia;
    private JTextPane JTPDescripcion_Seg;

    public JD_SeguimientoSVE(Frame parent, boolean modal, Long idManPower) {
        super(parent, modal);
        this.metodo = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.iSoManpowerSeguimientoService = (ISoManpowerSeguimientoService) Principal.contexto.getBean(ISoManpowerSeguimientoService.class);
        Principal.contexto.getBean(ITipoVigilanciaSeguimientoService.class);
        this.iVigilanciaSeguimientoService = (VigilanciaSeguimientoService) Principal.contexto.getBean(VigilanciaSeguimientoService.class);
        this.iSoManpowerSeguimientoDetalleSService = (ISoManpowerSeguimientoDetalleSService) Principal.contexto.getBean(ISoManpowerSeguimientoDetalleSService.class);
        this.idManPower = idManPower;
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPTipoVigilancia = new JScrollPane();
        this.JTBTipoVigilancia = new JTable();
        this.JPIDatosS = new JPanel();
        this.JCBTiposSeguimiento = new JComboBox();
        this.JSPDescripcion_Seg = new JScrollPane();
        this.JTPDescripcion_Seg = new JTextPane();
        this.JCHUltimo = new JCheckBox();
        this.JCHFiltroAnalisis = new JCheckBox();
        this.JSPSHistorico = new JScrollPane();
        this.JTBSHistorico = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.JSPTipoVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE VIGILANCIA", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTBTipoVigilancia.setFont(new Font("Arial", 1, 12));
        this.JTBTipoVigilancia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBTipoVigilancia.setRowHeight(25);
        this.JTBTipoVigilancia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTipoVigilancia.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTipoVigilancia.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.1
            public void mouseClicked(MouseEvent evt) {
                JD_SeguimientoSVE.this.JTBTipoVigilanciaMouseClicked(evt);
            }
        });
        this.JSPTipoVigilancia.setViewportView(this.JTBTipoVigilancia);
        this.JPIDatosS.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA SEGUIMIENTO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBTiposSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTiposSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDescripcion_Seg.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDescripcion_Seg.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion_Seg.setViewportView(this.JTPDescripcion_Seg);
        this.JCHUltimo.setFont(new Font("Arial", 1, 12));
        this.JCHUltimo.setText("Ultimo?");
        this.JCHFiltroAnalisis.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroAnalisis.setText("Filtro Analisis");
        GroupLayout JPIDatosSLayout = new GroupLayout(this.JPIDatosS);
        this.JPIDatosS.setLayout(JPIDatosSLayout);
        JPIDatosSLayout.setHorizontalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addComponent(this.JCBTiposSeguimiento, -2, 697, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHUltimo).addComponent(this.JCHFiltroAnalisis, -2, 119, -2))).addComponent(this.JSPDescripcion_Seg)).addContainerGap()));
        JPIDatosSLayout.setVerticalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosSLayout.createSequentialGroup().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosSLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBTiposSeguimiento, -2, 50, -2)).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHUltimo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroAnalisis))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcion_Seg, -2, 81, -2).addGap(37, 37, 37)));
        this.JSPSHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTBSHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBSHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBSHistorico.setRowHeight(25);
        this.JTBSHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBSHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JSPSHistorico.setViewportView(this.JTBSHistorico);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.2
            public void actionPerformed(ActionEvent evt) {
                JD_SeguimientoSVE.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.3
            public void actionPerformed(ActionEvent evt) {
                JD_SeguimientoSVE.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.4
            public void actionPerformed(ActionEvent evt) {
                JD_SeguimientoSVE.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPSHistorico).addComponent(this.JPIDatosS, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JBT_Salir, -2, 300, -2)).addComponent(this.JSPTipoVigilancia, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPTipoVigilancia, -1, 187, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosS, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPSHistorico, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTipoVigilanciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            cargarDatosDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (this.JTBTipoVigilancia.getSelectedRow() != -1) {
            if (this.JCBTiposSeguimiento.getSelectedIndex() != -1) {
                if (!this.JTPDescripcion_Seg.getText().isEmpty()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        grabar();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Descripción no puede estar en blanco", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                this.JTPDescripcion_Seg.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo seguimiento", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            this.JCBTiposSeguimiento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un seguimiento", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTBTipoVigilancia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void cargarDatosDetalle() {
        crearModeloSeguimiento();
        this.metodo.mEstablecerTextEditor(this.JTBSHistorico, 2);
        this.metodo.mEstablecerTextEditor(this.JTBSHistorico, 3);
        this.metodo.mEstablecerTextEditor(this.JTBSHistorico, 5);
        this.listManpowerSeguimientoDetalle.get(this.JTBTipoVigilancia.getSelectedRow()).getSoManpowerSeguimientoDetalleSCollection().forEach(e -> {
            this.modelSeguimiento.addRow(this.dato);
            this.tipoVigilanciaDTO = e.getIdMpSDetalle().getIdTipoVigilancia();
            this.modelSeguimiento.setValueAt(e.getId(), this.JTBSHistorico.getRowCount() - 1, 0);
            this.modelSeguimiento.setValueAt(e.getFechaS(), this.JTBSHistorico.getRowCount() - 1, 1);
            this.modelSeguimiento.setValueAt(e.getIdVigilanciaS().getIdTVSeguimiento().getNbre(), this.JTBSHistorico.getRowCount() - 1, 2);
            this.modelSeguimiento.setValueAt(e.getDescrpcion(), this.JTBSHistorico.getRowCount() - 1, 3);
            this.modelSeguimiento.setValueAt(e.getIdEspecialidad().getNbre(), this.JTBSHistorico.getRowCount() - 1, 4);
            this.modelSeguimiento.setValueAt(e.getIdProfesional().getApellido1().concat(" ").concat(e.getIdProfesional().getApellido2().concat(" ").concat(e.getIdProfesional().getNombre1().concat(" ").concat(e.getIdProfesional().getNombre2()))), this.JTBSHistorico.getRowCount() - 1, 5);
        });
        llenarCombo(this.tipoVigilanciaDTO);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTipoVigilancia() {
        this.modeloTipoVigilancia = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Observación", "NDías", "FUSeguimiento", "FCierre", "FPSeguimiento", "CSeguimiento"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.5
            Class[] types = {Long.class, String.class, String.class, Long.class, Date.class, String.class, Date.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTipoVigilancia.setAutoResizeMode(0);
        this.JTBTipoVigilancia.doLayout();
        this.JTBTipoVigilancia.setModel(this.modeloTipoVigilancia);
        this.JTBTipoVigilancia.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBTipoVigilancia.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBTipoVigilancia.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBTipoVigilancia.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBTipoVigilancia.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBTipoVigilancia.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBTipoVigilancia.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBTipoVigilancia.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void cargarDatos() {
        crearModeloTipoVigilancia();
        System.out.println("" + this.idManPower);
        this.listManpowerSeguimientoDetalle = new ArrayList();
        this.listManpowerSeguimientos = this.iSoManpowerSeguimientoService.getListSoManpowerSeguimientoByIdManPowerOrderByNombre(this.idManPower);
        this.listManpowerSeguimientos.forEach(e -> {
            this.listManpowerSeguimientoDetalle = (List) e.getSoManpowerSeguimientoDetalleCollection();
            e.getSoManpowerSeguimientoDetalleCollection().forEach(d -> {
                Calendar calendar = Calendar.getInstance();
                Date dt = new Date();
                if (d.getFechaUS() != null) {
                    calendar.setTime(d.getFechaUS());
                    calendar.add(5, d.getNDiasS().shortValue());
                    dt = calendar.getTime();
                }
                this.modeloTipoVigilancia.addRow(this.dato);
                this.modeloTipoVigilancia.setValueAt(d.getId(), this.JTBTipoVigilancia.getRowCount() - 1, 0);
                this.modeloTipoVigilancia.setValueAt(d.getIdTipoVigilancia().getNombre(), this.JTBTipoVigilancia.getRowCount() - 1, 1);
                this.modeloTipoVigilancia.setValueAt(d.getObservacion(), this.JTBTipoVigilancia.getRowCount() - 1, 2);
                this.modeloTipoVigilancia.setValueAt(d.getNDiasS(), this.JTBTipoVigilancia.getRowCount() - 1, 3);
                this.modeloTipoVigilancia.setValueAt(d.getFechaUS(), this.JTBTipoVigilancia.getRowCount() - 1, 4);
                this.modeloTipoVigilancia.setValueAt(d.getFechaCierre(), this.JTBTipoVigilancia.getRowCount() - 1, 5);
                this.modeloTipoVigilancia.setValueAt(dt, this.JTBTipoVigilancia.getRowCount() - 1, 6);
            });
        });
    }

    private void nuevo() {
        this.JCBTiposSeguimiento.setSelectedIndex(-1);
        this.JTPDescripcion_Seg.setText("");
        this.JCHUltimo.setSelected(false);
        this.JCHFiltroAnalisis.setSelected(false);
        cargarDatosDetalle();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSeguimiento() {
        this.modelSeguimiento = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Descripción", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JD_SeguimientoSVE.6
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBSHistorico.setAutoResizeMode(0);
        this.JTBSHistorico.doLayout();
        this.JTBSHistorico.setModel(this.modelSeguimiento);
        this.JTBSHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBSHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBSHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBSHistorico.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTBSHistorico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBSHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void llenarCombo(TipoVigilanciaDTO tipoVigilanciaDTO) {
        this.listVigilanciaSeguimientoEntity = new ArrayList();
        this.JCBTiposSeguimiento.removeAllItems();
        this.listVigilanciaSeguimientoEntity = this.iVigilanciaSeguimientoService.getListVigilanciaSeguimientoEntity(tipoVigilanciaDTO, true);
        this.listVigilanciaSeguimientoEntity.forEach(e -> {
            this.JCBTiposSeguimiento.addItem(e.getIdTVSeguimiento().getNbre());
        });
    }

    private void grabar() {
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().intValue()));
        GPersona persona = new GPersona();
        persona.setId(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        SoManpowerSeguimientoDetalleS s = SoManpowerSeguimientoDetalleS.builder().idEspecialidad(especialidad).idProfesional(persona).idMpSDetalle(this.listManpowerSeguimientoDetalle.get(this.JTBTipoVigilancia.getSelectedRow())).idVigilanciaS(this.listVigilanciaSeguimientoEntity.get(this.JCBTiposSeguimiento.getSelectedIndex())).fechaS(this.metodo.getFechaActual()).descrpcion(this.JTPDescripcion_Seg.getText()).estado(true).fecha(this.metodo.getFechaActual()).usuarioS(Principal.usuarioSistemaDTO.getLogin()).build();
        this.iSoManpowerSeguimientoDetalleSService.save(s);
        cargarDatosDetalle();
    }
}
