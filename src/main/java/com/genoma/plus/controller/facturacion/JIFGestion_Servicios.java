package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Sgc.JD_RegistoSeguimientoAmbulatorio;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.OrdenProcedimientoProjection;
import com.genoma.plus.jpa.service.HItemordenesProcedSeguimientoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFGestion_Servicios.class */
public class JIFGestion_Servicios extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private final HItemordenesProcedSeguimientoService seguimientoService;
    private List<OrdenProcedimientoProjection> listOrdenesProcedimiento;
    private List<Integer> parametro;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar14;
    private JButton JBTRegistrarSeguimiento;
    private JButton JBT_FactruacionServicios;
    private JButton JBT_ImpresionCentralizada;
    private JLabel JLTotal;
    private JPanel JPIDatos;
    private JPanel JPI_DatosExportacion;
    private JPanel JPI_Filtro;
    private JPanel JPI_Utilidades;
    private JRadioButton JRB_Cerrado;
    private JRadioButton JRB_ConSeguimiento;
    private JRadioButton JRB_SinSeguimiento;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta13;
    private JTabbedPane JTP_DatosU;
    private final Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private final ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private final Metodos metodos = new Metodos();
    private String nombreFormulario = "";

    public JIFGestion_Servicios(String nombre) {
        initComponents();
        setName(nombre);
        this.seguimientoService = (HItemordenesProcedSeguimientoService) Principal.contexto.getBean(HItemordenesProcedSeguimientoService.class);
        nuevo();
        if (getName().equals("jifGestionSolicitudes1")) {
            this.JBT_FactruacionServicios.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JLTotal = new JLabel();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_SinSeguimiento = new JRadioButton();
        this.JRB_ConSeguimiento = new JRadioButton();
        this.JRB_Cerrado = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_DatosU = new JTabbedPane();
        this.JPI_Utilidades = new JPanel();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JBT_ImpresionCentralizada = new JButton();
        this.JBT_FactruacionServicios = new JButton();
        this.JPI_DatosExportacion = new JPanel();
        this.JTFRuta13 = new JTextField();
        this.JBTExportar14 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE SOLICITUDES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifGestionSolicitudes");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGestion_Servicios.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JLTotal.setBackground(new Color(255, 255, 255));
        this.JLTotal.setFont(new Font("Arial", 1, 14));
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.2
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JRB_SinSeguimiento.setBackground(new Color(255, 255, 255));
        this.JBGSeleccion.add(this.JRB_SinSeguimiento);
        this.JRB_SinSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JRB_SinSeguimiento.setSelected(true);
        this.JRB_SinSeguimiento.setText("Sin Segimiento");
        this.JRB_SinSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JRB_SinSeguimientoActionPerformed(evt);
            }
        });
        this.JRB_ConSeguimiento.setBackground(new Color(255, 255, 204));
        this.JBGSeleccion.add(this.JRB_ConSeguimiento);
        this.JRB_ConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JRB_ConSeguimiento.setText("Con Segimiento");
        this.JRB_ConSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JRB_ConSeguimientoActionPerformed(evt);
            }
        });
        this.JRB_Cerrado.setBackground(new Color(153, 255, 102));
        this.JBGSeleccion.add(this.JRB_Cerrado);
        this.JRB_Cerrado.setFont(new Font("Arial", 1, 12));
        this.JRB_Cerrado.setText("Cerrado");
        this.JRB_Cerrado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.5
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JRB_CerradoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_SinSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_ConSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Cerrado).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_SinSeguimiento, -1, -1, 32767).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_ConSeguimiento).addComponent(this.JRB_Cerrado)).addGap(0, 0, 32767))).addContainerGap()));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal, -2, 164, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLTotal, -1, -1, 32767).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.6
            public void mouseClicked(MouseEvent evt) {
                JIFGestion_Servicios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_DatosU.setForeground(Color.red);
        this.JTP_DatosU.setFont(new Font("Arial", 1, 14));
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Seguimiento");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JBT_ImpresionCentralizada.setFont(new Font("Arial", 1, 12));
        this.JBT_ImpresionCentralizada.setForeground(Color.red);
        this.JBT_ImpresionCentralizada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBT_ImpresionCentralizada.setText("Impresión centralizada");
        this.JBT_ImpresionCentralizada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.8
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JBT_ImpresionCentralizadaActionPerformed(evt);
            }
        });
        this.JBT_FactruacionServicios.setFont(new Font("Arial", 1, 12));
        this.JBT_FactruacionServicios.setForeground(Color.red);
        this.JBT_FactruacionServicios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.JBT_FactruacionServicios.setText("Facturacion servicios");
        this.JBT_FactruacionServicios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.9
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JBT_FactruacionServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTRegistrarSeguimiento, -2, 319, -2).addGap(55, 55, 55).addComponent(this.JBT_ImpresionCentralizada, -2, 319, -2).addGap(47, 47, 47).addComponent(this.JBT_FactruacionServicios, -2, 319, -2).addContainerGap(71, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createSequentialGroup().addContainerGap(35, 32767).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTRegistrarSeguimiento, -2, 50, -2).addComponent(this.JBT_ImpresionCentralizada, -2, 50, -2).addComponent(this.JBT_FactruacionServicios, -2, 50, -2)).addGap(24, 24, 24)));
        this.JTP_DatosU.addTab("UTILIDADES", this.JPI_Utilidades);
        this.JTFRuta13.setFont(new Font("Arial", 1, 12));
        this.JTFRuta13.setText("C:\\Genoma\\plantilla");
        this.JTFRuta13.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta13.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.10
            public void mouseClicked(MouseEvent evt) {
                JIFGestion_Servicios.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar14.setFont(new Font("Arial", 1, 12));
        this.JBTExportar14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar14.setText("Exportar");
        this.JBTExportar14.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_Servicios.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosExportacionLayout = new GroupLayout(this.JPI_DatosExportacion);
        this.JPI_DatosExportacion.setLayout(JPI_DatosExportacionLayout);
        JPI_DatosExportacionLayout.setHorizontalGroup(JPI_DatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosExportacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta13, -2, 382, -2).addGap(40, 40, 40).addComponent(this.JBTExportar14, -2, 330, -2).addContainerGap(-1, 32767)));
        JPI_DatosExportacionLayout.setVerticalGroup(JPI_DatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosExportacionLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPI_DatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta13, -2, 50, -2).addComponent(this.JBTExportar14, -2, 50, -2)).addContainerGap(37, 32767)));
        this.JTP_DatosU.addTab("EXPORTAR", this.JPI_DatosExportacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTP_DatosU)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_DatosU, -2, 140, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            List<String> botones = new ArrayList<>(Arrays.asList("Seguimiento", "Impresión Centralizada"));
            if (getName().equals("jifGestionSolicitudes")) {
                botones.add("Facturación Servicios");
            }
            botones.add("Cerrar");
            int n = JOptionPane.showInternalOptionDialog(this, "¿Qué información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones.toArray(), "Cerrar");
            switch (n) {
                case 0:
                    cargarPantallaSeguimiento();
                    break;
                case 1:
                    imprmir();
                    break;
                case 2:
                    if (getName().equals("jifGestionSolicitudes")) {
                        abrirFacturacion();
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta13.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta13.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta13.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta13.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SinSeguimientoActionPerformed(ActionEvent evt) {
        this.parametro = new ArrayList(Arrays.asList(0));
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ConSeguimientoActionPerformed(ActionEvent evt) {
        this.parametro = new ArrayList(Arrays.asList(2));
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CerradoActionPerformed(ActionEvent evt) {
        this.parametro = new ArrayList(Arrays.asList(1));
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        this.parametro = new ArrayList(Arrays.asList(0, 1, 2));
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        cargarPantallaSeguimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ImpresionCentralizadaActionPerformed(ActionEvent evt) {
        imprmir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_FactruacionServiciosActionPerformed(ActionEvent evt) {
        abrirFacturacion();
    }

    private void nuevo() {
        this.JTFRuta13.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.parametro = new ArrayList(Arrays.asList(0));
        buscar();
    }

    private void abrirFacturacion() {
        if (this.JTDetalle.getSelectedRow() == -1) {
            mostrarMensaje("Debe seleccionar un registro de la tabla", "VERIFICAR");
            return;
        }
        String[] anexos = {"Anexo1", "Anexo2", "Anexo3", "Cerrar"};
        int opcionAnexo = mostrarDialogo("¿Qué información desea cargar?", anexos, "Cerrar");
        if (opcionAnexo < 0 || opcionAnexo >= 3) {
            return;
        }
        String anexoSeleccionado = "Anexo " + (opcionAnexo + 1);
        String[] normas = {"Norma 3047", "Norma 2335", "Cerrar"};
        int opcionNorma = mostrarDialogo("¿Qué información desea cargar?", normas, "Cerrar");
        if (opcionNorma < 0 || opcionNorma >= 2) {
            return;
        }
        String resolucion = opcionNorma == 0 ? anexoSeleccionado : anexoSeleccionado + " Resolución 2335";
        cargarFacturacionResolucion(resolucion);
    }

    private int mostrarDialogo(String mensaje, String[] opciones, String opcionPorDefecto) {
        return JOptionPane.showInternalOptionDialog(this, mensaje, "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), opciones, opcionPorDefecto);
    }

    private void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showInternalMessageDialog(this, mensaje, titulo, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void cargarFacturacionResolucion(String nombre) {
        System.out.println("Hoja " + nombre);
        int filaSeleccionada = this.JTDetalle.getSelectedRow();
        String documento = this.listOrdenesProcedimiento.get(filaSeleccionada).getDocumento().substring(3);
        String idIngreso = this.listOrdenesProcedimiento.get(filaSeleccionada).getIdIngreso().toString();
        Principal.clasefacturacion.cargarPantalla("Facturación");
        Principal.clasefacturacion.xjiliqServicio.mNuevo();
        Principal.clasefacturacion.xjiliqServicio.xjppersona.txtHistoria.setText(documento);
        Principal.clasefacturacion.xjiliqServicio.xjppersona.buscar(2);
        Principal.clasefacturacion.xjiliqServicio.JLB_NIngreso.setText(idIngreso);
        Principal.clasefacturacion.xjiliqServicio.mInicar_Variables_Ingreso(idIngreso);
        Principal.clasefacturacion.xjiliqServicio.selectNode(nombre);
        Principal.clasefacturacion.xjiliqServicio.mAcciones_Arbol();
        switch (nombre) {
            case "Anexo 1":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo1.JCH_TraerDatos.setSelected(true);
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo1.cargarDatos();
                break;
            case "Anexo 1 Resolución 2335":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo1Res2335.JCH_TraerDatos.setSelected(true);
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo1Res2335.cargarDatos();
                break;
            case "Anexo 2":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo2.consultarDatosAnexo();
                break;
            case "Anexo 2 Resolución 2335":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo2Res2335.consultarDatosAnexo();
                break;
            case "Anexo 3":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo3.cargarDatosGestionServicios(cargarItems());
                break;
            case "Anexo 3 Resolución 2335":
                Principal.clasefacturacion.xjiliqServicio.formularioAnexo3Res2335.cargarDetalleItemsOrden(cargarItems());
                break;
        }
    }

    private List<OrdenProcedimientoProjection> cargarItems() {
        List<OrdenProcedimientoProjection> list = new ArrayList<>();
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.parseBoolean(this.JTDetalle.getValueAt(i, 0).toString())) {
                list.add(this.listOrdenesProcedimiento.get(i));
            }
        }
        return list;
    }

    public void imprmir() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdAtencion().toString(), this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdUsuario().toString(), this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdIngreso().toString(), this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdTipoAtencion().toString(), Integer.valueOf(this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdTipoHistoria().intValue()), this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getCorreoElectronico());
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro de la tabla", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "idItemsOrden", "Fecha", "Documento", "Usuario", "Convenio", "Celular", "correoElectronico", "Cups", "Nombre Procedimiento", "Cantidad", "Especialidad", "Profesional", "Servicio", "Cama", "DxPrincipal", "DxRelacionado1", "DxRelacionado2", "DxRelacionado3", "Grupo Rips", "SubGrupo Rips", "Finalidad Procedimiento", "cerrado"}) { // from class: com.genoma.plus.controller.facturacion.JIFGestion_Servicios.12
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    public void buscar() {
        this.listOrdenesProcedimiento = new ArrayList();
        Boolean forma = false;
        if (getName().equals("jifGestionSolicitudes1")) {
            forma = true;
        }
        this.listOrdenesProcedimiento = this.seguimientoService.listOrdenesSeguimiento(this.parametro, forma);
        crearModelo();
        if (!this.listOrdenesProcedimiento.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
            this.listOrdenesProcedimiento.forEach(e -> {
                this.xmodelo.addRow(this.dato);
                int n = this.JTDetalle.getRowCount() - 1;
                this.xmodelo.setValueAt(false, n, 0);
                this.xmodelo.setValueAt(e.getIdItemsOrden(), n, 1);
                this.xmodelo.setValueAt(e.getFechaOrden(), n, 2);
                this.xmodelo.setValueAt(e.getDocumento(), n, 3);
                this.xmodelo.setValueAt(e.getUsuario(), n, 4);
                this.xmodelo.setValueAt(e.getConvenio(), n, 5);
                this.xmodelo.setValueAt(e.getCelular(), n, 6);
                this.xmodelo.setValueAt(e.getCorreoElectronico(), n, 7);
                this.xmodelo.setValueAt(e.getCups(), n, 8);
                this.xmodelo.setValueAt(e.getNombreCups(), n, 9);
                this.xmodelo.setValueAt(e.getCantidad(), n, 10);
                this.xmodelo.setValueAt(e.getEspecialidad(), n, 11);
                this.xmodelo.setValueAt(e.getProfesional(), n, 12);
                this.xmodelo.setValueAt(e.getServicio(), n, 13);
                this.xmodelo.setValueAt(e.getCama(), n, 14);
                this.xmodelo.setValueAt(e.getDiagnosticoP(), n, 15);
                this.xmodelo.setValueAt(e.getDiagnosticoR1(), n, 16);
                this.xmodelo.setValueAt(e.getDiagnosticoR2(), n, 17);
                this.xmodelo.setValueAt(e.getDiagnosticoR3(), n, 18);
                this.xmodelo.setValueAt(e.getGrupoRips(), n, 19);
                this.xmodelo.setValueAt(e.getSubGrupoRips(), n, 20);
                this.xmodelo.setValueAt(e.getFinalidadProcedimiento(), n, 21);
                this.xmodelo.setValueAt(e.getCerrado(), n, 22);
                this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            });
            this.JLTotal.setText("" + this.listOrdenesProcedimiento.size());
        }
    }

    private void cargarPantallaSeguimiento() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_RegistoSeguimientoAmbulatorio registoSeguimiento = new JD_RegistoSeguimientoAmbulatorio(null, true, this.listOrdenesProcedimiento.get(this.JTDetalle.getSelectedRow()).getIdItemsOrden());
            registoSeguimiento.setLocationRelativeTo(this);
            registoSeguimiento.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro de la tabla", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFGestion_Servicios$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Integer estado = obtenerEntero(table, row, 22);
            cell.setBackground(getColorPorEstado(estado));
            cell.setForeground(Color.BLACK);
            return cell;
        }

        private Integer obtenerEntero(JTable table, int row, int column) {
            try {
                Object valor = table.getValueAt(row, column);
                if (valor instanceof Number) {
                    return Integer.valueOf(((Number) valor).intValue());
                }
                return Integer.valueOf(valor.toString().trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }

        private Color getColorPorEstado(Integer estado) {
            if (estado == null) {
                return Color.WHITE;
            }
            switch (estado.intValue()) {
                case 1:
                    return new Color(153, 255, 102);
                case 2:
                    return new Color(255, 255, 204);
                default:
                    return Color.WHITE;
            }
        }
    }
}
