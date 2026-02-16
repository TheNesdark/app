package com.genoma.plus.controller.sig;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.projection.IEstadisticaMorbilidadMortalidad;
import com.genoma.plus.jpa.projection.IEstadisticaMorbilidadMortalidadDetalleUsuario;
import com.genoma.plus.jpa.service.IHAtencionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFEstadisticaMorbilidadMortalidad.class */
public class JIFEstadisticaMorbilidadMortalidad extends JInternalFrame {
    private List<GenericCombo> generalDTOs;
    private Integer tipo;
    private List<Integer> idLista;
    private DefaultTableModel modeloData;
    private DefaultTableModel modeloDetalle;
    private List<Integer> listaFiltro;
    private List<Integer> listaEstadoSalida;
    private Object[] datos;
    private String tituloColumna;
    private JButton JBTExportar;
    private JComboBox JCBUno;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleUsuario;
    public JTable JTDetalle;
    public JTable JTDetalleUsuario;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Consolidado;
    private ButtonGroup buttonGroup1;
    private Metodos metodos = new Metodos();
    private final IHAtencionService iHAtencionService = (IHAtencionService) Principal.contexto.getBean(IHAtencionService.class);
    private Boolean llenoComponente = false;

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setGeneralDTOs(List<GenericCombo> generalDTOs) {
        this.generalDTOs = generalDTOs;
    }

    @Generated
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Generated
    public void setIdLista(List<Integer> idLista) {
        this.idLista = idLista;
    }

    @Generated
    public void setLlenoComponente(Boolean llenoComponente) {
        this.llenoComponente = llenoComponente;
    }

    @Generated
    public void setModeloData(DefaultTableModel modeloData) {
        this.modeloData = modeloData;
    }

    @Generated
    public void setModeloDetalle(DefaultTableModel modeloDetalle) {
        this.modeloDetalle = modeloDetalle;
    }

    @Generated
    public void setListaFiltro(List<Integer> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    @Generated
    public void setListaEstadoSalida(List<Integer> listaEstadoSalida) {
        this.listaEstadoSalida = listaEstadoSalida;
    }

    @Generated
    public void setDatos(Object[] datos) {
        this.datos = datos;
    }

    @Generated
    public void setTituloColumna(String tituloColumna) {
        this.tituloColumna = tituloColumna;
    }

    @Generated
    public void setJBTExportar(JButton JBTExportar) {
        this.JBTExportar = JBTExportar;
    }

    @Generated
    public void setJCBUno(JComboBox JCBUno) {
        this.JCBUno = JCBUno;
    }

    @Generated
    public void setJCHFiltro(JCheckBox JCHFiltro) {
        this.JCHFiltro = JCHFiltro;
    }

    @Generated
    public void setJDFechaF(JDateChooser JDFechaF) {
        this.JDFechaF = JDFechaF;
    }

    @Generated
    public void setJDFechaI(JDateChooser JDFechaI) {
        this.JDFechaI = JDFechaI;
    }

    @Generated
    public void setJPIDatos(JPanel JPIDatos) {
        this.JPIDatos = JPIDatos;
    }

    @Generated
    public void setJSPCantidad(JSpinner JSPCantidad) {
        this.JSPCantidad = JSPCantidad;
    }

    @Generated
    public void setJSPDetalle(JScrollPane JSPDetalle) {
        this.JSPDetalle = JSPDetalle;
    }

    @Generated
    public void setJSPDetalleUsuario(JScrollPane JSPDetalleUsuario) {
        this.JSPDetalleUsuario = JSPDetalleUsuario;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public void setJTDetalleUsuario(JTable JTDetalleUsuario) {
        this.JTDetalleUsuario = JTDetalleUsuario;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJTP_Consolidado(JTabbedPane JTP_Consolidado) {
        this.JTP_Consolidado = JTP_Consolidado;
    }

    @Generated
    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public IHAtencionService getIHAtencionService() {
        return this.iHAtencionService;
    }

    @Generated
    public List<GenericCombo> getGeneralDTOs() {
        return this.generalDTOs;
    }

    @Generated
    public Integer getTipo() {
        return this.tipo;
    }

    @Generated
    public List<Integer> getIdLista() {
        return this.idLista;
    }

    @Generated
    public Boolean getLlenoComponente() {
        return this.llenoComponente;
    }

    @Generated
    public DefaultTableModel getModeloData() {
        return this.modeloData;
    }

    @Generated
    public DefaultTableModel getModeloDetalle() {
        return this.modeloDetalle;
    }

    @Generated
    public List<Integer> getListaFiltro() {
        return this.listaFiltro;
    }

    @Generated
    public List<Integer> getListaEstadoSalida() {
        return this.listaEstadoSalida;
    }

    @Generated
    public Object[] getDatos() {
        return this.datos;
    }

    @Generated
    public String getTituloColumna() {
        return this.tituloColumna;
    }

    public JIFEstadisticaMorbilidadMortalidad(String nombre, Integer tipo) {
        initComponents();
        setTitle(nombre.toUpperCase());
        setTipo(tipo);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBUno = new JComboBox();
        this.JSPCantidad = new JSpinner();
        this.JCHFiltro = new JCheckBox();
        this.JTP_Consolidado = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleUsuario = new JScrollPane();
        this.JTDetalleUsuario = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmorbilidad_mortalidad");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(10, 1, (Comparable) null, 1));
        this.JSPCantidad.setToolTipText("Número causas de patologías a consultar");
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.3
            public void actionPerformed(ActionEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBUno, -2, 444, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(181, 181, 181).addComponent(this.JSPCantidad, -2, 83, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBUno, GroupLayout.Alignment.LEADING, -2, 50, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPCantidad, -2, 52, -2).addComponent(this.JCHFiltro)).addGap(16, 16, 16)));
        this.JTP_Consolidado.setForeground(Color.red);
        this.JTP_Consolidado.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JSPDetalle.setAutoscrolls(true);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setCellSelectionEnabled(true);
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.4
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_Consolidado.addTab("CONSOLIDADO", this.JSPDetalle);
        this.JSPDetalleUsuario.setBorder((Border) null);
        this.JSPDetalleUsuario.setAutoscrolls(true);
        this.JTDetalleUsuario.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleUsuario.setFont(new Font("Arial", 1, 12));
        this.JTDetalleUsuario.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleUsuario.setAutoResizeMode(0);
        this.JTDetalleUsuario.setCellSelectionEnabled(true);
        this.JTDetalleUsuario.setEditingColumn(1);
        this.JTDetalleUsuario.setEditingRow(1);
        this.JTDetalleUsuario.setRowHeight(25);
        this.JTDetalleUsuario.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleUsuario.setSelectionForeground(Color.red);
        this.JTDetalleUsuario.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.5
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JTDetalleUsuarioMouseClicked(evt);
            }
        });
        this.JSPDetalleUsuario.setViewportView(this.JTDetalleUsuario);
        this.JTP_Consolidado.addTab("DETALLE USUARIO", this.JSPDetalleUsuario);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.6
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.7
            public void actionPerformed(ActionEvent evt) {
                JIFEstadisticaMorbilidadMortalidad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 396, -2)).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTP_Consolidado, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTP_Consolidado, -2, 501, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2)).addGap(17, 17, 17)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (getLlenoComponente().booleanValue()) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (getLlenoComponente().booleanValue()) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            cargarDatosTablaMorbilidadDetalle();
            this.JTP_Consolidado.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(getMetodos().getDirectorioExportacion());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + getMetodos().getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTP_Consolidado.getSelectedIndex() == 0) {
            if (this.JTDetalle.getRowCount() > 0) {
                this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        } else if (this.JTP_Consolidado.getSelectedIndex() == 1 && this.JTDetalleUsuario.getRowCount() > 0) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleUsuario, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCBUno.setEnabled(true);
        } else {
            this.JCBUno.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleUsuarioMouseClicked(MouseEvent evt) {
        if (this.JTDetalleUsuario.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.JTDetalleUsuario.getValueAt(this.JTDetalleUsuario.getSelectedRow(), 11).toString(), this.JTDetalleUsuario.getValueAt(this.JTDetalleUsuario.getSelectedRow(), 12).toString(), this.JTDetalleUsuario.getValueAt(this.JTDetalleUsuario.getSelectedRow(), 10).toString(), this.JTDetalleUsuario.getValueAt(this.JTDetalleUsuario.getSelectedRow(), 13).toString(), Integer.valueOf(this.JTDetalleUsuario.getValueAt(this.JTDetalleUsuario.getSelectedRow(), 14).toString()), "");
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
        }
    }

    public void nuevo() {
        setLlenoComponente(false);
        this.JCBUno.setEnabled(false);
        if (getTipo().intValue() == 0) {
            setTituloColumna("Especialidad");
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, getTituloColumna(), 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (getTipo().intValue() == 1) {
            setTituloColumna("Servicio");
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, getTituloColumna(), 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
        this.JTFRuta.setText(getMetodos().getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.JSPCantidad.setValue(10);
        llenarCombo();
        setLlenoComponente(true);
        crearModeloDatos();
    }

    private void llenarCombo() {
        this.JCBUno.removeAllItems();
        this.generalDTOs = new ArrayList();
        this.listaEstadoSalida = new ArrayList();
        if (null != getTipo()) {
            switch (getTipo().intValue()) {
                case 0:
                    setGeneralDTOs(this.iHAtencionService.listaEspecialidadAtencion(this.JDFechaI.getDate(), this.JDFechaF.getDate()));
                    break;
                case 1:
                    this.listaEstadoSalida.add(1);
                    this.listaEstadoSalida.add(0);
                    this.listaEstadoSalida.add(2);
                    setGeneralDTOs(this.iHAtencionService.listaServicioAtencion(this.JDFechaI.getDate(), this.JDFechaF.getDate(), this.listaEstadoSalida));
                    break;
                case 2:
                    this.listaEstadoSalida.add(2);
                    setGeneralDTOs(this.iHAtencionService.listaServicioAtencion(this.JDFechaI.getDate(), this.JDFechaF.getDate(), this.listaEstadoSalida));
                    break;
            }
        }
        if (!getGeneralDTOs().isEmpty()) {
            getGeneralDTOs().forEach(item -> {
                this.JCBUno.addItem(item.getNombre());
            });
            if (getGeneralDTOs().size() > 1) {
                this.JCBUno.setSelectedIndex(-1);
            }
        }
    }

    public void buscar() {
        cargarDatosTablaMorbilidad();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modeloData = new DefaultTableModel(new Object[0], new String[]{"Orden", "id", "Nombre", "Cie10", "Nombre Cie10", "Cantidad"}) { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.8
            Class[] types = {Integer.class, Integer.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modeloData);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosDetalle() {
        this.modeloDetalle = new DefaultTableModel(new Object[0], new String[]{"Fecha Atencion", "Documento", "Usuario", "Sexo", "Fecha Nacimiento", "Edad", "Convenio", getTituloColumna(), "Cie10", "Nombre Cie10", "idIngreso", "idAtencion", "idUsuario", "idTipoAtencion", "idTipoHitoria"}) { // from class: com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad.9
            Class[] types = {Date.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleUsuario;
        JTable jTable2 = this.JTDetalleUsuario;
        jTable.setAutoResizeMode(0);
        this.JTDetalleUsuario.doLayout();
        this.JTDetalleUsuario.setModel(this.modeloDetalle);
        this.JTDetalleUsuario.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalleUsuario.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalleUsuario.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalleUsuario.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalleUsuario.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(14).setPreferredWidth(50);
    }

    private void cargarDatosTablaMorbilidad() {
        List<IEstadisticaMorbilidadMortalidad> list = new ArrayList<>();
        if (validarLlenadoCombo().booleanValue()) {
            crearModeloDatos();
            if (getTipo().intValue() == 0) {
                list = this.iHAtencionService.listaMobilidadPorEspecialidad(this.JDFechaI.getDate(), this.JDFechaF.getDate(), getListaFiltro(), Integer.valueOf(getJSPCantidad().getValue().toString()));
            } else if (getTipo().intValue() == 1 || getTipo().intValue() == 2) {
                list = this.iHAtencionService.listaMobilidadPorServicio(this.JDFechaI.getDate(), this.JDFechaF.getDate(), getListaFiltro(), Integer.valueOf(getJSPCantidad().getValue().toString()), this.listaEstadoSalida);
            }
            if (!list.isEmpty()) {
                this.metodos.mEstablecerTextEditor(this.JTDetalle, 3);
                list.forEach(item -> {
                    this.modeloData.addRow(this.datos);
                    this.JTDetalle.setValueAt(item.getOrden(), this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(item.getId(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(item.getNombre(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt(item.getCodigoPatologia(), this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(item.getNombrePatologia(), this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(item.getCantidad(), this.JTDetalle.getRowCount() - 1, 5);
                });
            }
        }
    }

    private void cargarDatosTablaMorbilidadDetalle() {
        List<IEstadisticaMorbilidadMortalidadDetalleUsuario> list = new ArrayList<>();
        crearModeloDatosDetalle();
        if (getTipo().intValue() == 0) {
            list = this.iHAtencionService.listaMobilidadPorEspecialidadDetalleUsuario(this.JDFechaI.getDate(), this.JDFechaF.getDate(), getListaFiltro(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        } else if (getTipo().intValue() == 1 || getTipo().intValue() == 2) {
            list = this.iHAtencionService.listaMobilidadPorServicioDetalleUsuario(this.JDFechaI.getDate(), this.JDFechaF.getDate(), getListaFiltro(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString(), this.listaEstadoSalida);
        }
        if (!list.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTDetalleUsuario, 2);
            this.metodos.mEstablecerTextEditor(this.JTDetalleUsuario, 6);
            this.metodos.mEstablecerTextEditor(this.JTDetalleUsuario, 9);
            list.forEach(item -> {
                this.modeloDetalle.addRow(this.datos);
                this.JTDetalleUsuario.setValueAt(item.getFechaAtencion(), this.JTDetalleUsuario.getRowCount() - 1, 0);
                this.JTDetalleUsuario.setValueAt(item.getNumeroDocumento(), this.JTDetalleUsuario.getRowCount() - 1, 1);
                this.JTDetalleUsuario.setValueAt(item.getNombreUsuario(), this.JTDetalleUsuario.getRowCount() - 1, 2);
                this.JTDetalleUsuario.setValueAt(item.getSexo(), this.JTDetalleUsuario.getRowCount() - 1, 3);
                this.JTDetalleUsuario.setValueAt(item.getFechaNacimiento(), this.JTDetalleUsuario.getRowCount() - 1, 4);
                this.JTDetalleUsuario.setValueAt(item.getEdad(), this.JTDetalleUsuario.getRowCount() - 1, 5);
                this.JTDetalleUsuario.setValueAt(item.getNombreConvenio(), this.JTDetalleUsuario.getRowCount() - 1, 6);
                this.JTDetalleUsuario.setValueAt(item.getNombreFiltro(), this.JTDetalleUsuario.getRowCount() - 1, 7);
                this.JTDetalleUsuario.setValueAt(item.getCodigoPatologia(), this.JTDetalleUsuario.getRowCount() - 1, 8);
                this.JTDetalleUsuario.setValueAt(item.getNombrePatologia(), this.JTDetalleUsuario.getRowCount() - 1, 9);
                this.JTDetalleUsuario.setValueAt(item.getIdIngreso(), this.JTDetalleUsuario.getRowCount() - 1, 10);
                this.JTDetalleUsuario.setValueAt(item.getIdAtencion(), this.JTDetalleUsuario.getRowCount() - 1, 11);
                this.JTDetalleUsuario.setValueAt(item.getIdUsuario(), this.JTDetalleUsuario.getRowCount() - 1, 12);
                this.JTDetalleUsuario.setValueAt(item.getIdTipoAtencion(), this.JTDetalleUsuario.getRowCount() - 1, 13);
                this.JTDetalleUsuario.setValueAt(item.getIdTIpoHistoria(), this.JTDetalleUsuario.getRowCount() - 1, 14);
            });
        }
    }

    private Boolean validarLlenadoCombo() {
        Boolean estado;
        this.listaFiltro = new ArrayList();
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBUno.getSelectedIndex() != -1) {
                getListaFiltro().add(getGeneralDTOs().get(this.JCBUno.getSelectedIndex()).getId());
                estado = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBUno.requestFocus();
                estado = false;
            }
        } else {
            getGeneralDTOs().forEach(item -> {
                getListaFiltro().add(item.getId());
            });
            estado = true;
        }
        return estado;
    }

    @Generated
    public JButton getJBTExportar() {
        return this.JBTExportar;
    }

    @Generated
    public JComboBox getJCBUno() {
        return this.JCBUno;
    }

    @Generated
    public JCheckBox getJCHFiltro() {
        return this.JCHFiltro;
    }

    @Generated
    public JDateChooser getJDFechaF() {
        return this.JDFechaF;
    }

    @Generated
    public JDateChooser getJDFechaI() {
        return this.JDFechaI;
    }

    @Generated
    public JPanel getJPIDatos() {
        return this.JPIDatos;
    }

    @Generated
    public JSpinner getJSPCantidad() {
        return this.JSPCantidad;
    }

    @Generated
    public JScrollPane getJSPDetalle() {
        return this.JSPDetalle;
    }

    @Generated
    public JScrollPane getJSPDetalleUsuario() {
        return this.JSPDetalleUsuario;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }

    @Generated
    public JTable getJTDetalleUsuario() {
        return this.JTDetalleUsuario;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JTabbedPane getJTP_Consolidado() {
        return this.JTP_Consolidado;
    }

    @Generated
    public ButtonGroup getButtonGroup1() {
        return this.buttonGroup1;
    }
}
