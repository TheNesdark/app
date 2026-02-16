package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcPeriodoFinanciero;
import com.genoma.plus.jpa.entities.SoTipoSistemaVigilancia;
import com.genoma.plus.jpa.projection.IInformeSistemaVigilancia;
import com.genoma.plus.jpa.service.ICcPeriodoFinancieroService;
import com.genoma.plus.jpa.service.ISoManpowerSeguimientoService;
import com.genoma.plus.jpa.service.ISoTipoSistemaVigilanciaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIF_InformeSistemaVigilancia.class */
public class JIF_InformeSistemaVigilancia extends JInternalFrame {
    private Metodos mt = new Metodos();
    private DefaultTableModel modelo;
    private Object[] dato;
    private List<CcPeriodoFinanciero> listPeriodoFinanciero;
    private List<SoTipoSistemaVigilancia> listSoTipoSistemaVigilancia;
    private final ICcPeriodoFinancieroService iCcPeriodoFinancieroService;
    private final ISoTipoSistemaVigilanciaService iSoTipoSistemaVigilanciaService;
    private final ISoManpowerSeguimientoService iSoManpowerSeguimientoService;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBT_Seguimiento;
    private JComboBox<String> JCBPeriodo;
    private JComboBox<String> JCBSistemaVigilancia;
    private JCheckBox JCHConSeguimiento;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHSinSeguimiento;
    private JCheckBox JCHTodos;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPIDConvenciones;
    private JPanel JPI_Utilidades;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;

    public JIF_InformeSistemaVigilancia() {
        initComponents();
        this.iCcPeriodoFinancieroService = (ICcPeriodoFinancieroService) Principal.contexto.getBean(ICcPeriodoFinancieroService.class);
        this.iSoTipoSistemaVigilanciaService = (ISoTipoSistemaVigilanciaService) Principal.contexto.getBean(ISoTipoSistemaVigilanciaService.class);
        this.iSoManpowerSeguimientoService = (ISoManpowerSeguimientoService) Principal.contexto.getBean(ISoManpowerSeguimientoService.class);
        nuevo();
    }

    public void nuevo() {
        this.JTFRuta.setText(this.mt.getDirectorioExportacion() + "Planilla");
        crearModelo();
        cargarCombo();
        this.JLBLCont.setText("0");
    }

    private void cargarCombo() {
        this.listPeriodoFinanciero = new ArrayList();
        this.listSoTipoSistemaVigilancia = new ArrayList();
        this.JCBPeriodo.removeAllItems();
        this.JCBSistemaVigilancia.removeAllItems();
        this.JCBSistemaVigilancia.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.listPeriodoFinanciero = this.iCcPeriodoFinancieroService.getListFilterEstadoOrderByFechaIDesc(true);
        this.listPeriodoFinanciero.forEach(e -> {
            this.JCBPeriodo.addItem(e.getNbre());
        });
        this.listSoTipoSistemaVigilancia = this.iSoTipoSistemaVigilanciaService.getListFilterEstadoOrderByNombre(true);
        this.listSoTipoSistemaVigilancia.forEach(e2 -> {
            this.JCBSistemaVigilancia.addItem(e2.getNombre());
        });
    }

    private void crearModelo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Codigo", "Cedula", "Tipo Contrato", "Tipo Empleado", "Nombre Completo", "Cargo", "Grupo", "Email", "Unidad", "Fecha Ingreso", "Seg", "Nombre Sistema", "idManPower", "nSeguimiento"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void cargarDatos() {
        List<IInformeSistemaVigilancia> listFiltrada;
        crearModelo();
        List<Integer> listSeleccion = new ArrayList<>();
        if (this.JCHFiltro.isSelected()) {
            listSeleccion.add(this.listSoTipoSistemaVigilancia.get(this.JCBSistemaVigilancia.getSelectedIndex()).getId());
        } else {
            this.listSoTipoSistemaVigilancia.forEach(e -> {
                listSeleccion.add(e.getId());
            });
        }
        new ArrayList();
        List<IInformeSistemaVigilancia> list = this.iSoTipoSistemaVigilanciaService.getListInformeManPowerSistemaVigilancia(this.listPeriodoFinanciero.get(this.JCBPeriodo.getSelectedIndex()).getId(), listSeleccion);
        if (this.JCHSinSeguimiento.isSelected()) {
            listFiltrada = (List) list.stream().filter(e2 -> {
                return e2.getCantidadSeguimiento().intValue() == 0;
            }).collect(Collectors.toList());
        } else if (this.JCHConSeguimiento.isSelected()) {
            listFiltrada = (List) list.stream().filter(e3 -> {
                return e3.getCantidadSeguimiento().intValue() > 0;
            }).collect(Collectors.toList());
        } else {
            listFiltrada = list;
        }
        listFiltrada.forEach(e4 -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e4.getCodigo(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e4.getCedula(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e4.getTipoContrato(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e4.getTipoEmpleado(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(e4.getNombreCompleto(), this.JTDetalle.getRowCount() - 1, 4);
            this.modelo.setValueAt(e4.getCargo(), this.JTDetalle.getRowCount() - 1, 5);
            this.modelo.setValueAt(e4.getGrupo(), this.JTDetalle.getRowCount() - 1, 6);
            this.modelo.setValueAt(e4.getEmail(), this.JTDetalle.getRowCount() - 1, 7);
            this.modelo.setValueAt(e4.getUnidad(), this.JTDetalle.getRowCount() - 1, 8);
            this.modelo.setValueAt(e4.getFechaIngreso(), this.JTDetalle.getRowCount() - 1, 9);
            this.modelo.setValueAt(e4.getSeg(), this.JTDetalle.getRowCount() - 1, 10);
            this.modelo.setValueAt(e4.getSistemaVigilancia(), this.JTDetalle.getRowCount() - 1, 11);
            this.modelo.setValueAt(e4.getIdManPower(), this.JTDetalle.getRowCount() - 1, 12);
            this.modelo.setValueAt(e4.getCantidadSeguimiento(), this.JTDetalle.getRowCount() - 1, 13);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender1());
        });
        if (listFiltrada != null) {
            this.JLBLCont.setText("" + listFiltrada.size());
        }
    }

    public void buscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            cargarDatos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        }
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JCBPeriodo = new JComboBox<>();
        this.JCBSistemaVigilancia = new JComboBox<>();
        this.JCHFiltro = new JCheckBox();
        this.JPIDConvenciones = new JPanel();
        this.JCHTodos = new JCheckBox();
        this.JCHSinSeguimiento = new JCheckBox();
        this.JCHConSeguimiento = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Utilidades = new JPanel();
        this.JBT_Seguimiento = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME TIPO SISTEMA VIGILANCIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformesistemavigilancia");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCBSistemaVigilancia.setFont(new Font("Arial", 1, 12));
        this.JCBSistemaVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Sistema Vigilancia", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro?");
        this.JPIDConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JCHTodos);
        this.JCHTodos.setFont(new Font("Arial", 1, 12));
        this.JCHTodos.setSelected(true);
        this.JCHTodos.setText("Todos");
        this.JCHTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.2
            public void actionPerformed(ActionEvent evt) {
                JIF_InformeSistemaVigilancia.this.JCHTodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCHSinSeguimiento);
        this.JCHSinSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHSinSeguimiento.setText("Sin seguimiento");
        this.JCHSinSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.3
            public void actionPerformed(ActionEvent evt) {
                JIF_InformeSistemaVigilancia.this.JCHSinSeguimientoActionPerformed(evt);
            }
        });
        this.JCHConSeguimiento.setBackground(Color.yellow);
        this.JBG_Filtro.add(this.JCHConSeguimiento);
        this.JCHConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHConSeguimiento.setText("Con Seguimiento");
        this.JCHConSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.4
            public void actionPerformed(ActionEvent evt) {
                JIF_InformeSistemaVigilancia.this.JCHConSeguimientoActionPerformed(evt);
            }
        });
        GroupLayout JPIDConvencionesLayout = new GroupLayout(this.JPIDConvenciones);
        this.JPIDConvenciones.setLayout(JPIDConvencionesLayout);
        JPIDConvencionesLayout.setHorizontalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSinSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JCHConSeguimiento).addContainerGap()));
        JPIDConvencionesLayout.setVerticalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSinSeguimiento).addComponent(this.JCHConSeguimiento).addComponent(this.JCHTodos)).addContainerGap(8, 32767)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSistemaVigilancia, -2, 508, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDConvenciones, -2, -1, -2).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -1, 50, 32767).addComponent(this.JCBSistemaVigilancia, -1, 50, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDConvenciones, -2, -1, -2).addComponent(this.JCHFiltro)))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JBT_Seguimiento.setFont(new Font("Arial", 1, 12));
        this.JBT_Seguimiento.setForeground(Color.red);
        this.JBT_Seguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBT_Seguimiento.setText("Hallazgo SVE");
        this.JBT_Seguimiento.setToolTipText("Hallazgo sistema de vigilancia epidemiológica");
        this.JBT_Seguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.5
            public void actionPerformed(ActionEvent evt) {
                JIF_InformeSistemaVigilancia.this.JBT_SeguimientoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.6
            public void mouseClicked(MouseEvent evt) {
                JIF_InformeSistemaVigilancia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia.7
            public void actionPerformed(ActionEvent evt) {
                JIF_InformeSistemaVigilancia.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLBLCont.setFont(new Font("Arial", 1, 14));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        this.JLBLCont.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBT_Seguimiento, -2, 194, -2).addGap(32, 32, 32).addComponent(this.JTFRuta, -2, 467, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 127, 32767).addComponent(this.JLBLCont, -2, 159, -2).addGap(21, 21, 21)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Seguimiento, -1, -1, 32767).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBLCont, -2, 48, -2).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, -1, 48, 32767).addComponent(this.JTFRuta, -1, 48, 32767))).addGap(0, 0, 32767))).addContainerGap()));
        this.JTP_Datos.addTab("UTILIDADES", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos)).addComponent(this.JPDatos, -1, 1175, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JPDatos, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 367, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 100, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.mt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_SeguimientoSVE seguimientoSVE = new JD_SeguimientoSVE(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()));
            seguimientoSVE.setLocationRelativeTo(this);
            seguimientoSVE.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodosActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSinSeguimientoActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConSeguimientoActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.mt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIF_InformeSistemaVigilancia$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 13).toString()).intValue() == 0) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
