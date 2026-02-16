package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IReporteSolicitudAlimentacionDTO;
import com.genoma.plus.jpa.projection.ITipoAtencionSolicitudAlimentacion;
import com.genoma.plus.jpa.service.ISolicitudAlimentacionDAO;
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
import java.beans.PropertyChangeListener;
import java.io.File;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIFReporteSolicitudAlimentacion.class */
public class JIFReporteSolicitudAlimentacion extends JInternalFrame {
    private DefaultTableModel modelo;
    private List<ITipoAtencionSolicitudAlimentacion> listaTipoAtencion;
    private String jornada;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JComboBox JCB_Servicio;
    private JCheckBox JCH_FIltroSeleccionar;
    private JCheckBox JCH_FiltroServicio;
    private JDateChooser JDFechaFin;
    private JDateChooser JDFechaInicio;
    private JLabel JLB_NRegistro;
    private JPanel JPI_InformacionFiltro;
    private JPanel JPI_Utilidades;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos metodo = new Metodos();
    private Boolean lleno = false;
    private final ISolicitudAlimentacionDAO solicitudAlimentacionDAO = (ISolicitudAlimentacionDAO) Principal.contexto.getBean(ISolicitudAlimentacionDAO.class);
    private String idImpresion = "";

    @Generated
    public void setMetodo(Metodos metodo) {
        this.metodo = metodo;
    }

    @Generated
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    @Generated
    public void setLleno(Boolean lleno) {
        this.lleno = lleno;
    }

    @Generated
    public void setListaTipoAtencion(List<ITipoAtencionSolicitudAlimentacion> listaTipoAtencion) {
        this.listaTipoAtencion = listaTipoAtencion;
    }

    @Generated
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @Generated
    public void setIdImpresion(String idImpresion) {
        this.idImpresion = idImpresion;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJBTExportar(JButton JBTExportar) {
        this.JBTExportar = JBTExportar;
    }

    @Generated
    public void setJCB_Servicio(JComboBox JCB_Servicio) {
        this.JCB_Servicio = JCB_Servicio;
    }

    @Generated
    public void setJCH_FIltroSeleccionar(JCheckBox JCH_FIltroSeleccionar) {
        this.JCH_FIltroSeleccionar = JCH_FIltroSeleccionar;
    }

    @Generated
    public void setJCH_FiltroServicio(JCheckBox JCH_FiltroServicio) {
        this.JCH_FiltroServicio = JCH_FiltroServicio;
    }

    @Generated
    public void setJDFechaFin(JDateChooser JDFechaFin) {
        this.JDFechaFin = JDFechaFin;
    }

    @Generated
    public void setJDFechaInicio(JDateChooser JDFechaInicio) {
        this.JDFechaInicio = JDFechaInicio;
    }

    @Generated
    public void setJLB_NRegistro(JLabel JLB_NRegistro) {
        this.JLB_NRegistro = JLB_NRegistro;
    }

    @Generated
    public void setJPI_InformacionFiltro(JPanel JPI_InformacionFiltro) {
        this.JPI_InformacionFiltro = JPI_InformacionFiltro;
    }

    @Generated
    public void setJPI_Utilidades(JPanel JPI_Utilidades) {
        this.JPI_Utilidades = JPI_Utilidades;
    }

    @Generated
    public void setJSPDetalle(JScrollPane JSPDetalle) {
        this.JSPDetalle = JSPDetalle;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public Metodos getMetodo() {
        return this.metodo;
    }

    @Generated
    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    @Generated
    public Boolean getLleno() {
        return this.lleno;
    }

    @Generated
    public ISolicitudAlimentacionDAO getSolicitudAlimentacionDAO() {
        return this.solicitudAlimentacionDAO;
    }

    @Generated
    public List<ITipoAtencionSolicitudAlimentacion> getListaTipoAtencion() {
        return this.listaTipoAtencion;
    }

    @Generated
    public String getJornada() {
        return this.jornada;
    }

    @Generated
    public String getIdImpresion() {
        return this.idImpresion;
    }

    public JIFReporteSolicitudAlimentacion() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_InformacionFiltro = new JPanel();
        this.JDFechaInicio = new JDateChooser();
        this.JDFechaFin = new JDateChooser();
        this.JCB_Servicio = new JComboBox();
        this.JCH_FiltroServicio = new JCheckBox();
        this.JCH_FIltroSeleccionar = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLB_NRegistro = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE SOLICITUD ALIMENTACIÓN");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifReporteSolicitudAlimentacion");
        this.JPI_InformacionFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JDFechaInicioPropertyChange(evt);
            }
        });
        this.JDFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JDFechaFinPropertyChange(evt);
            }
        });
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.3
            public void itemStateChanged(ItemEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_FiltroServicio.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroServicio.setText("Filtro por servicio?");
        this.JCH_FIltroSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_FIltroSeleccionar.setText("Seleccionar/quitar?");
        this.JCH_FIltroSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JCH_FIltroSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_InformacionFiltroLayout = new GroupLayout(this.JPI_InformacionFiltro);
        this.JPI_InformacionFiltro.setLayout(JPI_InformacionFiltroLayout);
        JPI_InformacionFiltroLayout.setHorizontalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaInicio, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaFin, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, 32767).addComponent(this.JCB_Servicio, -2, 353, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_FiltroServicio).addGap(81, 81, 81).addComponent(this.JCH_FIltroSeleccionar).addContainerGap()));
        JPI_InformacionFiltroLayout.setVerticalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_FiltroServicio).addComponent(this.JCH_FIltroSeleccionar)).addComponent(this.JCB_Servicio, -2, 50, -2).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicio, -2, 50, -2).addComponent(this.JDFechaFin, -2, 50, -2))).addContainerGap(26, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.5
            public void mouseClicked(MouseEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Utilidades.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDADES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.6
            public void mouseClicked(MouseEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFReporteSolicitudAlimentacion.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 322, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 138, -2).addGap(12, 12, 12)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.JLB_NRegistro, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_InformacionFiltro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle).addComponent(this.JPI_Utilidades, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_InformacionFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 432, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Utilidades, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            setIdImpresion("");
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.modelo.getValueAt(x, 0).toString()).booleanValue()) {
                    setIdImpresion(getIdImpresion() + "," + this.modelo.getValueAt(x, 1).toString());
                }
            }
            System.out.println("Id impresion: " + getIdImpresion());
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + getMetodo().getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                getMetodo().mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (getLleno().booleanValue()) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (getLleno().booleanValue()) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FIltroSeleccionarActionPerformed(ActionEvent evt) {
        seleccionarDatosTabla(Boolean.valueOf(this.JCH_FIltroSeleccionar.isSelected()));
    }

    public void seleccionarDatosTabla(Boolean estado) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            getModelo().setValueAt(estado, i, 0);
            if (Boolean.valueOf(this.modelo.getValueAt(i, 0).toString()).booleanValue()) {
                setIdImpresion(getIdImpresion() + "," + this.modelo.getValueAt(i, 1).toString());
            }
        }
    }

    public void imprimir() {
        ClaseImpresionInformes e = new ClaseImpresionInformes();
        e.imprimirSolicitudAlimentacion(getIdImpresion().substring(1, getIdImpresion().length()));
    }

    public void nuevo() {
        setLleno(false);
        this.JDFechaInicio.setDate(getMetodo().getFechaActual());
        this.JDFechaFin.setDate(getMetodo().getFechaActual());
        this.JTFRuta.setText(getMetodo().getDirectorioExportacion() + "Planilla");
        setLleno(true);
        llenarCombo();
        creaModeloTabla();
    }

    public void buscar() {
        if (this.JCH_FiltroServicio.isSelected()) {
            if (this.JCB_Servicio.getSelectedIndex() != -1) {
                cargarDatosTable();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar tipo servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_Servicio.requestFocus();
                return;
            }
        }
        cargarDatosTable();
    }

    private void llenarCombo() {
        this.JCB_Servicio.removeAllItems();
        this.listaTipoAtencion = this.solicitudAlimentacionDAO.listaTipoAtencionFiltroFecha(getMetodo().formatoAMD1.format(this.JDFechaInicio.getDate()), getMetodo().formatoAMD1.format(this.JDFechaFin.getDate()));
        for (ITipoAtencionSolicitudAlimentacion next : this.listaTipoAtencion) {
            this.JCB_Servicio.addItem(next.getNombre());
        }
        this.JCB_Servicio.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void creaModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "Id", "Fecha Solictud", "Servicio", "Jornada", "Observación", "Funcionario", "Cargo"}) { // from class: com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion.8
            Class[] types = {Boolean.class, Long.class, Date.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
    }

    private void cargarDatosTable() {
        List<IReporteSolicitudAlimentacionDTO> reporteSolicitudAlimentacionDTOs;
        if (this.JCH_FiltroServicio.isSelected()) {
            reporteSolicitudAlimentacionDTOs = getSolicitudAlimentacionDAO().listaSolicitudAlimentacionFiltroServicio(getMetodo().formatoAMD1.format(this.JDFechaInicio.getDate()), getMetodo().formatoAMD1.format(this.JDFechaFin.getDate()), String.valueOf(getListaTipoAtencion().get(this.JCB_Servicio.getSelectedIndex()).getId()));
        } else {
            reporteSolicitudAlimentacionDTOs = getSolicitudAlimentacionDAO().listaSolicitudAlimentacion(getMetodo().formatoAMD1.format(this.JDFechaInicio.getDate()), getMetodo().formatoAMD1.format(this.JDFechaFin.getDate()));
        }
        creaModeloTabla();
        if (!reporteSolicitudAlimentacionDTOs.isEmpty()) {
            int fila = 0;
            for (IReporteSolicitudAlimentacionDTO next : reporteSolicitudAlimentacionDTOs) {
                this.modelo.addRow((Object[]) null);
                this.modelo.setValueAt(false, fila, 0);
                this.modelo.setValueAt(next.getId(), fila, 1);
                this.modelo.setValueAt(next.getFechaSolicitud(), fila, 2);
                this.modelo.setValueAt(next.getServicio(), fila, 3);
                this.modelo.setValueAt(next.getJornada(), fila, 4);
                this.modelo.setValueAt(next.getObservacion(), fila, 5);
                this.modelo.setValueAt(next.getUsuarioCargo(), fila, 6);
                this.modelo.setValueAt(next.getCargo(), fila, 7);
                fila++;
            }
            this.JLB_NRegistro.setText("" + fila);
        }
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JButton getJBTExportar() {
        return this.JBTExportar;
    }

    @Generated
    public JComboBox getJCB_Servicio() {
        return this.JCB_Servicio;
    }

    @Generated
    public JCheckBox getJCH_FIltroSeleccionar() {
        return this.JCH_FIltroSeleccionar;
    }

    @Generated
    public JCheckBox getJCH_FiltroServicio() {
        return this.JCH_FiltroServicio;
    }

    @Generated
    public JDateChooser getJDFechaFin() {
        return this.JDFechaFin;
    }

    @Generated
    public JDateChooser getJDFechaInicio() {
        return this.JDFechaInicio;
    }

    @Generated
    public JLabel getJLB_NRegistro() {
        return this.JLB_NRegistro;
    }

    @Generated
    public JPanel getJPI_InformacionFiltro() {
        return this.JPI_InformacionFiltro;
    }

    @Generated
    public JPanel getJPI_Utilidades() {
        return this.JPI_Utilidades;
    }

    @Generated
    public JScrollPane getJSPDetalle() {
        return this.JSPDetalle;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }
}
