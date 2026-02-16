package com.genoma.plus.controller.auditoria_medica;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.auditoria_medica.AuditoriaMedicaDAO;
import com.genoma.plus.dao.impl.auditoria_medica.AuditoriaMedicaDAOImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Auditoria_Facturacion.class */
public class JIF_Auditoria_Facturacion extends JInternalFrame {
    private AuditoriaMedicaDAO xAuditoriaMedicaDAO;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private String[] idServicio;
    private ButtonGroup JBG_Convenciones;
    private ButtonGroup JBG_Filtro;
    private ButtonGroup JBG_FiltroFF;
    private JButton JBTExportar;
    private JButton JBTRegistrarSeguimiento;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_CConSeguimiento;
    private JCheckBox JCH_CTodos;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_SSeguimiento;
    private JLabel JLN_NRegistro;
    private JPanel JPIConvenciones;
    private JPanel JPIFiltro;
    private JPanel JPI_Datos1;
    private JPanel JPI_Datos2;
    private JPanel JPI_FFacturacion;
    private JRadioButton JRBFF_Evento;
    private JRadioButton JRBFF_NOrden;
    private JRadioButton JRBFF_Todos;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFNo;
    private JTextField JTFRuta;
    private JTextField JTF_Filtro;
    private JTabbedPane JTP_Utilidades;
    private Metodos xmt = new Metodos();
    private String xtipo = "1,2,3,4,5";
    private String xFiltro = "0,1";
    private String xFiltroF = "0,1,2";
    private Boolean estadoLlenadoCombo = false;

    public JIF_Auditoria_Facturacion(String xTitulo) {
        initComponents();
        springStart();
        setTitle(getTitle() + " - " + xTitulo);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_Convenciones = new ButtonGroup();
        this.JBG_FiltroFF = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JTF_Filtro = new JTextField();
        this.JPI_FFacturacion = new JPanel();
        this.JRBFF_Todos = new JRadioButton();
        this.JRBFF_Evento = new JRadioButton();
        this.JRBFF_NOrden = new JRadioButton();
        this.JCH_Filtro = new JCheckBox();
        this.JCB_Servicio = new JComboBox<>();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JPIConvenciones = new JPanel();
        this.JCH_CTodos = new JCheckBox();
        this.JCH_SSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento = new JCheckBox();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JTFNo = new JTextField();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR ATENCIONES PARA AUDITORIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifAuditoriaMedicaFac");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_Filtro.setFont(new Font("Arial", 1, 12));
        this.JTF_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por: (Nombre ó Documento de Identidad)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_FFacturacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA DE FACTURACIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_FiltroFF.add(this.JRBFF_Todos);
        this.JRBFF_Todos.setFont(new Font("Arial", 1, 12));
        this.JRBFF_Todos.setSelected(true);
        this.JRBFF_Todos.setText("Todos");
        this.JRBFF_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.1
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JRBFF_TodosActionPerformed(evt);
            }
        });
        this.JBG_FiltroFF.add(this.JRBFF_Evento);
        this.JRBFF_Evento.setFont(new Font("Arial", 1, 12));
        this.JRBFF_Evento.setText("Orden Servicio");
        this.JRBFF_Evento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JRBFF_EventoActionPerformed(evt);
            }
        });
        this.JBG_FiltroFF.add(this.JRBFF_NOrden);
        this.JRBFF_NOrden.setFont(new Font("Arial", 1, 12));
        this.JRBFF_NOrden.setText("Evento");
        this.JRBFF_NOrden.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JRBFF_NOrdenActionPerformed(evt);
            }
        });
        GroupLayout JPI_FFacturacionLayout = new GroupLayout(this.JPI_FFacturacion);
        this.JPI_FFacturacion.setLayout(JPI_FFacturacionLayout);
        JPI_FFacturacionLayout.setHorizontalGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FFacturacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFF_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBFF_NOrden).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBFF_Evento).addContainerGap(-1, 32767)));
        JPI_FFacturacionLayout.setVerticalGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FFacturacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFF_Todos).addComponent(this.JRBFF_Evento).addComponent(this.JRBFF_NOrden)).addContainerGap(-1, 32767)));
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Todos");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JCH_FiltroActionPerformed(evt);
            }
        });
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.5
            public void itemStateChanged(ItemEvent evt) {
                JIF_Auditoria_Facturacion.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Servicio, -2, 273, -2).addGap(64, 64, 64).addComponent(this.JPI_FFacturacion, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Filtro, -2, 235, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLN_NRegistro, -1, -1, 32767).addComponent(this.JTF_Filtro).addComponent(this.JPI_FFacturacion, -1, -1, 32767))).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JCH_Filtro)).addComponent(this.JCB_Servicio, -2, 50, -2)))).addGap(26, 26, 26)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.6
            public void mouseClicked(MouseEvent evt) {
                JIF_Auditoria_Facturacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Convenciones.add(this.JCH_CTodos);
        this.JCH_CTodos.setFont(new Font("Arial", 1, 12));
        this.JCH_CTodos.setSelected(true);
        this.JCH_CTodos.setText("Todos");
        this.JCH_CTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JCH_CTodosActionPerformed(evt);
            }
        });
        this.JCH_SSeguimiento.setBackground(new Color(255, 255, 255));
        this.JBG_Convenciones.add(this.JCH_SSeguimiento);
        this.JCH_SSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_SSeguimiento.setText("Sin Seguimineto");
        this.JCH_SSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JCH_SSeguimientoActionPerformed(evt);
            }
        });
        this.JCH_CConSeguimiento.setBackground(Color.green);
        this.JBG_Convenciones.add(this.JCH_CConSeguimiento);
        this.JCH_CConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento.setText("Con seguimiento");
        this.JCH_CConSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JCH_CConSeguimientoActionPerformed(evt);
            }
        });
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SSeguimiento).addComponent(this.JCH_CConSeguimiento).addComponent(this.JCH_CTodos))));
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Seguimiento");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JTFNo.setFont(new Font("Arial", 1, 12));
        this.JTFNo.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNo.setEnabled(false);
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConvenciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRegistrarSeguimiento, -2, 506, -2).addGap(48, 48, 48).addComponent(this.JTFNo, -1, 194, 32767).addGap(16, 16, 16)));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIConvenciones, -1, -1, 32767).addComponent(this.JTFNo, -1, 55, 32767).addComponent(this.JBTRegistrarSeguimiento, -1, -1, 32767)).addContainerGap(16, 32767)));
        this.JTP_Utilidades.addTab("UTILIDAD", this.JPI_Datos1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.11
            public void mouseClicked(MouseEvent evt) {
                JIF_Auditoria_Facturacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.12
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Facturacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -1, 713, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 385, -2).addGap(15, 15, 15)));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(20, 32767)));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JSP_Detalle).addComponent(this.JTP_Utilidades)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -1, 336, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap()));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        cargarPantallaSeguimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CConSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFF_TodosActionPerformed(ActionEvent evt) {
        this.xFiltroF = "0,1,2";
        this.JTFNo.setEnabled(false);
        this.JTFNo.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFF_EventoActionPerformed(ActionEvent evt) {
        this.xFiltroF = "0,1";
        this.JTFNo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFF_NOrdenActionPerformed(ActionEvent evt) {
        this.xFiltroF = "2";
        this.JTFNo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            this.JCB_Servicio.setSelectedIndex(-1);
            this.JCB_Servicio.setEnabled(false);
            if (this.idServicio != null) {
                this.xtipo = "";
                for (String idServicio1 : this.idServicio) {
                    this.xtipo += idServicio1 + ",";
                }
                this.xtipo = this.xtipo.substring(0, this.xtipo.length() - 1);
            }
            mBuscar();
            return;
        }
        this.JCB_Servicio.setSelectedIndex(-1);
        this.JCB_Servicio.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            this.xtipo = this.idServicio[this.JCB_Servicio.getSelectedIndex()];
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            cargarPantallaSeguimiento();
        }
    }

    private void cargarPantallaSeguimiento() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.clasefacturacion.cargarPantalla("Facturación");
                Principal.clasefacturacion.xjiliqServicio.mNuevo();
                Principal.clasefacturacion.xjiliqServicio.xjppersona.txtHistoria.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                Principal.clasefacturacion.xjiliqServicio.xjppersona.buscar(2);
                Principal.clasefacturacion.xjiliqServicio.setxTipoAuditoria(1);
                Principal.clasefacturacion.xjiliqServicio.JLB_NIngreso.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString());
                Principal.clasefacturacion.xjiliqServicio.mInicar_Variables_Ingreso(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString());
                Principal.clasefacturacion.xjiliqServicio.setSelected(true);
                return;
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIF_Auditoria_Facturacion.class.getName()).log(Level.SEVERE, (String) null, e);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "NHistoria", "Documento", "Usuario", "Edad", "Tipo de Atención", "Convenio", "Norden", "N° Factura", "Total Servicio", "Copago", "CModeradora", "Total Eps", "Diagnóstico Principal", "Cama", "Ubicación", "Egreso", "IdIngreso", "IdAtencion", "IdUsuario", "CSeguimiento"}) { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Auditoria_Facturacion.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xAuditoriaMedicaDAO.listaFacturaAuditoria(this.xtipo, this.JTF_Filtro.getText(), this.xFiltro, this.xFiltroF, this.JTFNo.getText());
        mCreaModeloTabla();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 13);
        long xNregistro = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
            this.xModelo.setValueAt(list.get(x)[6], x, 6);
            this.xModelo.setValueAt(list.get(x)[7], x, 7);
            this.xModelo.setValueAt(list.get(x)[8], x, 8);
            this.xModelo.setValueAt(list.get(x)[9], x, 9);
            this.xModelo.setValueAt(list.get(x)[10], x, 10);
            this.xModelo.setValueAt(list.get(x)[11], x, 11);
            this.xModelo.setValueAt(list.get(x)[12], x, 12);
            this.xModelo.setValueAt(list.get(x)[13], x, 13);
            this.xModelo.setValueAt(list.get(x)[14], x, 14);
            this.xModelo.setValueAt(list.get(x)[15], x, 15);
            this.xModelo.setValueAt(list.get(x)[16], x, 16);
            this.xModelo.setValueAt(list.get(x)[17], x, 17);
            this.xModelo.setValueAt(list.get(x)[18], x, 18);
            this.xModelo.setValueAt(list.get(x)[19], x, 19);
            this.xModelo.setValueAt(list.get(x)[20], x, 20);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            xNregistro++;
        }
        this.JLN_NRegistro.setText("" + xNregistro);
    }

    private void springStart() {
        this.xAuditoriaMedicaDAO = (AuditoriaMedicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("auditoriaMedicaDAO");
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    public void mNuevo() {
        this.estadoLlenadoCombo = false;
        this.JCH_Filtro.setSelected(true);
        llenarComboServicio();
        this.JCB_Servicio.setEnabled(false);
        this.JTF_Filtro.setText("");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFNo.setText("");
        mCreaModeloTabla();
        this.estadoLlenadoCombo = true;
    }

    private void llenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        List<Object[]> listaServicio = this.xAuditoriaMedicaDAO.listaServiciosFiltradoFactura(this.JTF_Filtro.getText(), this.xFiltro, this.xFiltroF, this.JTFNo.getText());
        if (!listaServicio.isEmpty()) {
            this.xtipo = "";
            this.idServicio = new String[listaServicio.size()];
            for (int i = 0; i < listaServicio.size(); i++) {
                this.xtipo += listaServicio.get(i)[0].toString() + ",";
                this.idServicio[i] = listaServicio.get(i)[0].toString();
                this.JCB_Servicio.addItem(listaServicio.get(i)[1].toString());
            }
            this.JCB_Servicio.setSelectedIndex(-1);
            this.xtipo = this.xtipo.substring(0, this.xtipo.length() - 1);
            System.out.println("servicio : " + this.xtipo);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Auditoria_Facturacion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 20).toString());
            if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
