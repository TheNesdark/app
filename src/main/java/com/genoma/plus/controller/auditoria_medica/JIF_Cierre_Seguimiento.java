package com.genoma.plus.controller.auditoria_medica;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Cierre_Seguimiento.class */
public class JIF_Cierre_Seguimiento extends JInternalFrame {
    private AuditoriaMedicaDAO xAuditoriaMedicaDAO;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private String[] idServicio;
    private ButtonGroup JBG_Convenciones;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBT_AbrirHC;
    private JButton JBT_RegistrarSeguimiento;
    private JButton JBT_RegistrarSeguimiento1;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_CTodos;
    private JCheckBox JCH_Cerrado;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_PorCerrar;
    private JLabel JLN_NRegistro;
    private JPanel JPIConvenciones;
    private JPanel JPIFiltro;
    private JPanel JPI_Datos1;
    private JPanel JPI_Datos2;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextField JTF_Filtro;
    private JTabbedPane JTP_Utilidades;
    private Metodos xmt = new Metodos();
    private String xtipo = "1,2,3,4,5,6";
    private String xFiltro = "0,1";
    private Boolean estadoLlenadoCombo = false;

    public JIF_Cierre_Seguimiento() {
        initComponents();
        springStart();
        mNuevo();
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("0") || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("")) {
            this.JBT_AbrirHC.setEnabled(false);
        } else {
            this.JBT_AbrirHC.setEnabled(true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_Convenciones = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JTF_Filtro = new JTextField();
        this.JCB_Servicio = new JComboBox<>();
        this.JCH_Filtro = new JCheckBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JPIConvenciones = new JPanel();
        this.JCH_CTodos = new JCheckBox();
        this.JCH_Cerrado = new JCheckBox();
        this.JCH_PorCerrar = new JCheckBox();
        this.JBT_RegistrarSeguimiento = new JButton();
        this.JBT_AbrirHC = new JButton();
        this.JBT_RegistrarSeguimiento1 = new JButton();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTOS DE AUDITORIAS CONCURRENTES O ADMINISTRATIVAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifCierreSeguimientoAuditoriaMedica");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_Filtro.setFont(new Font("Arial", 1, 12));
        this.JTF_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por: (Nombre ó Documento de Identidad)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_Cierre_Seguimiento.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Todos");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JCH_FiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Servicio, -2, 273, -2).addGap(70, 70, 70).addComponent(this.JTF_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JCH_Filtro)).addComponent(this.JCB_Servicio, -2, 50, -2).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLN_NRegistro, -1, -1, 32767).addComponent(this.JTF_Filtro, -1, 68, 32767))).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.3
            public void mouseClicked(MouseEvent evt) {
                JIF_Cierre_Seguimiento.this.JTDetalleMouseClicked(evt);
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
        this.JCH_CTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JCH_CTodosActionPerformed(evt);
            }
        });
        this.JCH_Cerrado.setBackground(Color.green);
        this.JBG_Convenciones.add(this.JCH_Cerrado);
        this.JCH_Cerrado.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrado.setText("Cerrado");
        this.JCH_Cerrado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JCH_CerradoActionPerformed(evt);
            }
        });
        this.JCH_PorCerrar.setBackground(Color.cyan);
        this.JBG_Convenciones.add(this.JCH_PorCerrar);
        this.JCH_PorCerrar.setFont(new Font("Arial", 1, 12));
        this.JCH_PorCerrar.setText("Por Cerrar");
        this.JCH_PorCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JCH_PorCerrarActionPerformed(evt);
            }
        });
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Cerrado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_PorCerrar).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Cerrado).addComponent(this.JCH_PorCerrar).addComponent(this.JCH_CTodos))));
        this.JBT_RegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBT_RegistrarSeguimiento.setForeground(Color.red);
        this.JBT_RegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_RegistrarSeguimiento.setText("Cierre");
        this.JBT_RegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JBT_RegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JBT_AbrirHC.setFont(new Font("Arial", 1, 12));
        this.JBT_AbrirHC.setForeground(Color.red);
        this.JBT_AbrirHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_AbrirHC.setText("Abrir Historia Clinica");
        this.JBT_AbrirHC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JBT_AbrirHCActionPerformed(evt);
            }
        });
        this.JBT_RegistrarSeguimiento1.setFont(new Font("Arial", 1, 12));
        this.JBT_RegistrarSeguimiento1.setForeground(Color.red);
        this.JBT_RegistrarSeguimiento1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBT_RegistrarSeguimiento1.setText("Verificar Seguimientos");
        this.JBT_RegistrarSeguimiento1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JBT_RegistrarSeguimiento1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConvenciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JBT_RegistrarSeguimiento1, -2, 222, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_RegistrarSeguimiento, -2, 222, -2).addGap(44, 44, 44).addComponent(this.JBT_AbrirHC, -2, 222, -2).addContainerGap()));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_Datos1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 5, -2).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_RegistrarSeguimiento, -2, 50, -2).addComponent(this.JBT_AbrirHC, -2, 50, -2).addComponent(this.JBT_RegistrarSeguimiento1, -2, 50, -2))).addComponent(this.JPIConvenciones, -1, -1, 32767)).addGap(30, 30, 30)));
        this.JTP_Utilidades.addTab("UTILIDAD", this.JPI_Datos1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.10
            public void mouseClicked(MouseEvent evt) {
                JIF_Cierre_Seguimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.11
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Seguimiento.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -1, 745, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 264, -2).addContainerGap()));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(32, 32767)));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Utilidades).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 375, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap(-1, 32767)));
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
    public void JBT_RegistrarSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_Cierre_Seguimiento xJDCierre = new JD_Cierre_Seguimiento(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 26).toString()));
            xJDCierre.setLocationRelativeTo(this);
            xJDCierre.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CerradoActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PorCerrarActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AbrirHCActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 23).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta("");
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(Long.parseLong(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString())));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(Long.parseLong(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString())));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 28).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(0L);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(new Long(0L));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio("");
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 30).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 29).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 31).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControlHistoria(2);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
            Principal.clasehistoriace.mBuscarAtencionIngreso();
            Principal.clasehistoriace.cargarPantalla("Historia", Principal.clasehistoriace.frmPrincipal, "Historia_Med_Auditoria");
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_RegistrarSeguimiento1ActionPerformed(ActionEvent evt) {
        cargarPantallaVerificacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            this.xtipo = this.idServicio[this.JCB_Servicio.getSelectedIndex()];
            mBuscar();
        }
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            cargarPantallaVerificacion();
        }
    }

    private void cargarPantallaVerificacion() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_VerificacionSeguimientos xJDVerificacion = new JD_VerificacionSeguimientos(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()));
            xJDVerificacion.setLocationRelativeTo(this);
            xJDVerificacion.setVisible(true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "Usuario", "Edad", "Sexo", "TipoSeguimiento", "Detalle Seguimiento", "Diagnóstico Principal", "Cama", "Ubicación", "Tipo de Atención", "Convenio", "Norden", "N° Factura", "Total Servicio", "Copago", "CModeradora", "Total Eps", "EstadoFac", "Egreso", "IdIngreso", "IdAtencion", "IdUsuario", "NHistoria", "Cierre", "IdUltimoSeguimiento", "IdSeguimiento", "IdTipoCita", "IdTipoHistoria", "IdPrograma", "FechaAtencion", "IdTIpoAtencion", "Respuesta"}) { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Cierre_Seguimiento.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, Boolean.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xAuditoriaMedicaDAO.listaSeguimiento_Para_Cierre(this.xtipo, this.JTF_Filtro.getText(), this.xFiltro);
        mCreaModeloTabla();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 32);
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
            this.xModelo.setValueAt(list.get(x)[21], x, 21);
            this.xModelo.setValueAt(list.get(x)[22], x, 22);
            this.xModelo.setValueAt(list.get(x)[23], x, 23);
            this.xModelo.setValueAt(list.get(x)[24], x, 24);
            this.xModelo.setValueAt(list.get(x)[25], x, 25);
            this.xModelo.setValueAt(list.get(x)[26], x, 26);
            this.xModelo.setValueAt(list.get(x)[27], x, 27);
            this.xModelo.setValueAt(list.get(x)[28], x, 28);
            this.xModelo.setValueAt(list.get(x)[29], x, 29);
            this.xModelo.setValueAt(list.get(x)[30], x, 30);
            this.xModelo.setValueAt(list.get(x)[31], x, 31);
            this.xModelo.setValueAt(list.get(x)[32], x, 32);
            if (list.get(x)[24].toString().equals("1")) {
                this.xModelo.setValueAt(true, x, 24);
            } else {
                this.xModelo.setValueAt(false, x, 24);
            }
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
        mCargarDatosTabla();
        this.estadoLlenadoCombo = true;
    }

    private void llenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        List<Object[]> listaServicio = this.xAuditoriaMedicaDAO.listaServiciosFiltradoPorCierresDeSeguimiento(this.JTF_Filtro.getText(), this.xFiltro);
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Cierre_Seguimiento$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 24).toString());
            if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else if (Integer.valueOf(table.getValueAt(row, 25).toString()).intValue() == 0) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
