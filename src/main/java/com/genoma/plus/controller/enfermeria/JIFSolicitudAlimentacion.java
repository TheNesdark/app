package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.SolicitudAlimentacionDTO;
import com.genoma.plus.jpa.entities.SolicitudAlimentacionDetalleDTO;
import com.genoma.plus.jpa.projection.IInformacionSolicitudDietaDTO;
import com.genoma.plus.jpa.projection.ITipoAtencionSolicitudAlimentacion;
import com.genoma.plus.jpa.service.ISolicitudAlimentacionDAO;
import com.genoma.plus.jpa.service.ISolicitudAlimentacionDetalleDAO;
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
import java.io.File;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIFSolicitudAlimentacion.class */
public class JIFSolicitudAlimentacion extends JInternalFrame {
    private DefaultTableModel modelo;
    private List<ITipoAtencionSolicitudAlimentacion> listaTipoAtencion;
    private List<IInformacionSolicitudDietaDTO> informacionSolicitudDietaDTOs;
    private String jornada;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JComboBox JCB_Servicio;
    private JCheckBox JCH_Almuerzo;
    private JCheckBox JCH_Cena;
    private JCheckBox JCH_Desayuno;
    private JCheckBox JCH_Seleccionar;
    private JDateChooser JDFechaS;
    private JLabel JLB_NRegistro;
    private JLabel JLB_NSolicitud;
    private JPanel JPI_InformacionFiltro;
    private JPanel JPI_Utilidades;
    private JPanel JP_FIltroJornada;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos metodo = new Metodos();
    private Boolean lleno = false;
    private final ISolicitudAlimentacionDAO solicitudAlimentacionDAO = (ISolicitudAlimentacionDAO) Principal.contexto.getBean(ISolicitudAlimentacionDAO.class);
    private final ISolicitudAlimentacionDetalleDAO solicitudAlimentacionDetalleDAO = (ISolicitudAlimentacionDetalleDAO) Principal.contexto.getBean(ISolicitudAlimentacionDetalleDAO.class);

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
    public void setInformacionSolicitudDietaDTOs(List<IInformacionSolicitudDietaDTO> informacionSolicitudDietaDTOs) {
        this.informacionSolicitudDietaDTOs = informacionSolicitudDietaDTOs;
    }

    @Generated
    public void setJornada(String jornada) {
        this.jornada = jornada;
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
    public void setJCH_Almuerzo(JCheckBox JCH_Almuerzo) {
        this.JCH_Almuerzo = JCH_Almuerzo;
    }

    @Generated
    public void setJCH_Cena(JCheckBox JCH_Cena) {
        this.JCH_Cena = JCH_Cena;
    }

    @Generated
    public void setJCH_Desayuno(JCheckBox JCH_Desayuno) {
        this.JCH_Desayuno = JCH_Desayuno;
    }

    @Generated
    public void setJCH_Seleccionar(JCheckBox JCH_Seleccionar) {
        this.JCH_Seleccionar = JCH_Seleccionar;
    }

    @Generated
    public void setJDFechaS(JDateChooser JDFechaS) {
        this.JDFechaS = JDFechaS;
    }

    @Generated
    public void setJLB_NRegistro(JLabel JLB_NRegistro) {
        this.JLB_NRegistro = JLB_NRegistro;
    }

    @Generated
    public void setJLB_NSolicitud(JLabel JLB_NSolicitud) {
        this.JLB_NSolicitud = JLB_NSolicitud;
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
    public void setJP_FIltroJornada(JPanel JP_FIltroJornada) {
        this.JP_FIltroJornada = JP_FIltroJornada;
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
    public ISolicitudAlimentacionDetalleDAO getSolicitudAlimentacionDetalleDAO() {
        return this.solicitudAlimentacionDetalleDAO;
    }

    @Generated
    public List<ITipoAtencionSolicitudAlimentacion> getListaTipoAtencion() {
        return this.listaTipoAtencion;
    }

    @Generated
    public List<IInformacionSolicitudDietaDTO> getInformacionSolicitudDietaDTOs() {
        return this.informacionSolicitudDietaDTOs;
    }

    @Generated
    public String getJornada() {
        return this.jornada;
    }

    public JIFSolicitudAlimentacion() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v58, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_InformacionFiltro = new JPanel();
        this.JDFechaS = new JDateChooser();
        this.JCB_Servicio = new JComboBox();
        this.JP_FIltroJornada = new JPanel();
        this.JCH_Desayuno = new JCheckBox();
        this.JCH_Almuerzo = new JCheckBox();
        this.JCH_Cena = new JCheckBox();
        this.JCH_Seleccionar = new JCheckBox();
        this.JLB_NSolicitud = new JLabel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLB_NRegistro = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD DE ALIMENTACIÓN");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSolicitudAlimentacion");
        this.JPI_InformacionFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDFechaS.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.1
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudAlimentacion.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JP_FIltroJornada.setBorder(BorderFactory.createTitledBorder((Border) null, "Jornada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JCH_Desayuno);
        this.JCH_Desayuno.setFont(new Font("Arial", 1, 12));
        this.JCH_Desayuno.setSelected(true);
        this.JCH_Desayuno.setText("Desayuno");
        this.JCH_Desayuno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.2
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudAlimentacion.this.JCH_DesayunoActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCH_Almuerzo);
        this.JCH_Almuerzo.setFont(new Font("Arial", 1, 12));
        this.JCH_Almuerzo.setText("Almuerzo");
        this.JCH_Almuerzo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.3
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudAlimentacion.this.JCH_AlmuerzoActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCH_Cena);
        this.JCH_Cena.setFont(new Font("Arial", 1, 12));
        this.JCH_Cena.setText("Cena");
        this.JCH_Cena.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudAlimentacion.this.JCH_CenaActionPerformed(evt);
            }
        });
        GroupLayout JP_FIltroJornadaLayout = new GroupLayout(this.JP_FIltroJornada);
        this.JP_FIltroJornada.setLayout(JP_FIltroJornadaLayout);
        JP_FIltroJornadaLayout.setHorizontalGroup(JP_FIltroJornadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FIltroJornadaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Desayuno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Almuerzo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Cena).addContainerGap(-1, 32767)));
        JP_FIltroJornadaLayout.setVerticalGroup(JP_FIltroJornadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FIltroJornadaLayout.createSequentialGroup().addContainerGap().addGroup(JP_FIltroJornadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Desayuno).addComponent(this.JCH_Almuerzo).addComponent(this.JCH_Cena)).addContainerGap(8, 32767)));
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar/quitar");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudAlimentacion.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        this.JLB_NSolicitud.setFont(new Font("Arial", 1, 14));
        this.JLB_NSolicitud.setHorizontalAlignment(0);
        this.JLB_NSolicitud.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPI_InformacionFiltroLayout = new GroupLayout(this.JPI_InformacionFiltro);
        this.JPI_InformacionFiltro.setLayout(JPI_InformacionFiltroLayout);
        JPI_InformacionFiltroLayout.setHorizontalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaS, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_Servicio, -2, 353, -2).addGap(18, 18, 18).addComponent(this.JP_FIltroJornada, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Seleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, 32767).addComponent(this.JLB_NSolicitud, -2, 138, -2).addContainerGap()));
        JPI_InformacionFiltroLayout.setVerticalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JLB_NSolicitud, -2, 50, -2)).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGap(7, 7, 7).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Seleccionar).addComponent(this.JCB_Servicio, -2, 50, -2).addComponent(this.JDFechaS, -2, 50, -2).addComponent(this.JP_FIltroJornada, -2, -1, -2)))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.6
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudAlimentacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Utilidades.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDADES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.7
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudAlimentacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.8
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudAlimentacion.this.JBTExportarActionPerformed(evt);
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
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        seleccionarDeseleccionar(Boolean.valueOf(this.JCH_Seleccionar.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 6) {
            System.out.println("" + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6));
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
    public void JCH_DesayunoActionPerformed(ActionEvent evt) {
        setJornada(this.JCH_Desayuno.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AlmuerzoActionPerformed(ActionEvent evt) {
        setJornada(this.JCH_Almuerzo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CenaActionPerformed(ActionEvent evt) {
        setJornada(this.JCH_Cena.getText());
    }

    public void seleccionarDeseleccionar(Boolean estado) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.JTDetalle.setValueAt(estado, i, 0);
        }
    }

    public void nuevo() {
        setLleno(false);
        this.JCH_Desayuno.setSelected(true);
        setJornada(this.JCH_Desayuno.getText());
        this.JLB_NRegistro.setText("");
        this.JLB_NSolicitud.setText("");
        this.JDFechaS.setDate(getMetodo().getFechaActual());
        this.JTFRuta.setText(getMetodo().getDirectorioExportacion() + "Planilla");
        llenarCombo();
        setLleno(true);
        creaModeloTabla();
    }

    public void buscar() {
        if (this.JCB_Servicio.getSelectedIndex() != -1) {
            cargarDatosTable();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe  seleccionar tipo servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_Servicio.requestFocus();
        }
    }

    private void llenarCombo() {
        this.JCB_Servicio.removeAllItems();
        this.listaTipoAtencion = this.solicitudAlimentacionDAO.listaTipoAtencion();
        for (ITipoAtencionSolicitudAlimentacion next : this.listaTipoAtencion) {
            this.JCB_Servicio.addItem(next.getNombre());
        }
        this.JCB_Servicio.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void creaModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Selección", "Fecha Ingreso", "Documento", "Nombre Usuario", "Sexo", "Cant", "Observación", "Empresa Contratante", "Fecha Orden", "TipoDieta", "Desayuno", "Almuerzo", "Cena", "Observación", "Especialidad", "Profesional", "Tipo Atención", "Ubicación", "idDieta"}) { // from class: com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion.9
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    private void cargarDatosTable() {
        setInformacionSolicitudDietaDTOs(getSolicitudAlimentacionDAO().listaSolicitudDieta(getListaTipoAtencion().get(this.JCB_Servicio.getSelectedIndex()).getId()));
        creaModeloTabla();
        if (!getInformacionSolicitudDietaDTOs().isEmpty()) {
            int fila = 0;
            for (IInformacionSolicitudDietaDTO next : getInformacionSolicitudDietaDTOs()) {
                this.modelo.addRow((Object[]) null);
                this.modelo.setValueAt(false, fila, 0);
                this.modelo.setValueAt(next.getFechaIngreso(), fila, 1);
                this.modelo.setValueAt(next.getDocumento(), fila, 2);
                this.modelo.setValueAt(next.getUsuario(), fila, 3);
                this.modelo.setValueAt(next.getSexo(), fila, 4);
                this.modelo.setValueAt(1, fila, 5);
                this.modelo.setValueAt("", fila, 6);
                this.modelo.setValueAt(next.getEmpresaContratante(), fila, 7);
                this.modelo.setValueAt(next.getFechaOrden(), fila, 8);
                this.modelo.setValueAt(next.getTipoDieta(), fila, 9);
                this.modelo.setValueAt(next.getDesayuno(), fila, 10);
                this.modelo.setValueAt(next.getAlmuerzo(), fila, 11);
                this.modelo.setValueAt(next.getCena(), fila, 12);
                this.modelo.setValueAt(next.getObservacion(), fila, 13);
                this.modelo.setValueAt(next.getEspecialidad(), fila, 14);
                this.modelo.setValueAt(next.getProfesional(), fila, 15);
                this.modelo.setValueAt(next.getTipoAtencion(), fila, 16);
                this.modelo.setValueAt(next.getUbicacion(), fila, 17);
                this.modelo.setValueAt(next.getIdAtencionDieta(), fila, 18);
                fila++;
            }
            this.JLB_NRegistro.setText("" + fila);
        }
    }

    public void grabar() {
        if (this.JLB_NSolicitud.getText().isEmpty()) {
            if (getMetodo().mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
                SolicitudAlimentacionDTO e = new SolicitudAlimentacionDTO();
                e.setFecha(getMetodo().getFechaActual());
                System.out.println("" + getMetodo().formatoAMD.format(this.JDFechaS.getDate()));
                e.setFechaSolicitud(this.JDFechaS.getDate());
                e.setEstado(true);
                e.setIdPersonaRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                e.setIdServicio(getListaTipoAtencion().get(this.JCB_Servicio.getSelectedIndex()).getId());
                e.setJornada(getJornada());
                Long idSolicitud = this.solicitudAlimentacionDAO.create(e);
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                        SolicitudAlimentacionDetalleDTO d = new SolicitudAlimentacionDetalleDTO();
                        d.setIdSolicitud(idSolicitud);
                        d.setCantidad(Integer.valueOf(this.JTDetalle.getValueAt(i, 5).toString()));
                        d.setObservacion(this.JTDetalle.getValueAt(i, 6).toString());
                        d.setIdAtencionDieta(Long.valueOf(this.JTDetalle.getValueAt(i, 18).toString()));
                        d.setUbicacion(this.JTDetalle.getValueAt(i, 17).toString());
                        this.solicitudAlimentacionDetalleDAO.create(d);
                    }
                }
                this.JLB_NSolicitud.setText("" + idSolicitud);
                ClaseImpresionInformes i2 = new ClaseImpresionInformes();
                i2.imprimirSolicitudAlimentacion(String.valueOf(idSolicitud));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen usuarios seleccionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Solicitud ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
    public JCheckBox getJCH_Almuerzo() {
        return this.JCH_Almuerzo;
    }

    @Generated
    public JCheckBox getJCH_Cena() {
        return this.JCH_Cena;
    }

    @Generated
    public JCheckBox getJCH_Desayuno() {
        return this.JCH_Desayuno;
    }

    @Generated
    public JCheckBox getJCH_Seleccionar() {
        return this.JCH_Seleccionar;
    }

    @Generated
    public JDateChooser getJDFechaS() {
        return this.JDFechaS;
    }

    @Generated
    public JLabel getJLB_NRegistro() {
        return this.JLB_NRegistro;
    }

    @Generated
    public JLabel getJLB_NSolicitud() {
        return this.JLB_NSolicitud;
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
    public JPanel getJP_FIltroJornada() {
        return this.JP_FIltroJornada;
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
