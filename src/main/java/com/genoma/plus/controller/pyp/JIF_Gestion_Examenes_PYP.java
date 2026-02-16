package com.genoma.plus.controller.pyp;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.pyp.GestionExamenesPyPDAOImpl;
import com.genoma.plus.dao.pyp.GestionExamenesPyPDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_Gestion_Examenes_PYP.class */
public class JIF_Gestion_Examenes_PYP extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private GestionExamenesPyPDAO xGestionExamenesPyp;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBT_AbrirHC;
    private JButton JBT_RegistrarSeguimiento;
    private JCheckBox JCH_CConSeguimiento;
    private JCheckBox JCH_CTodos;
    private JCheckBox JCH_SSeguimiento;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
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
    private String xFiltro = "0,1";

    public JIF_Gestion_Examenes_PYP() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JTF_Filtro = new JTextField();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JPIConvenciones = new JPanel();
        this.JCH_CTodos = new JCheckBox();
        this.JCH_SSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento = new JCheckBox();
        this.JBT_RegistrarSeguimiento = new JButton();
        this.JBT_AbrirHC = new JButton();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION Y SEGUIMIENTO DE PROCEDIMIENTOS PYP");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJifGestionExamenesPyp");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_Filtro.setFont(new Font("Arial", 1, 12));
        this.JTF_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por: (Nombre ó Documento de Identidad)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Filtro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.1
            public void keyPressed(KeyEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JTF_FiltroKeyPressed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767).addComponent(this.JTF_Filtro, -2, 557, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addComponent(this.JLN_NRegistro, -2, 57, -2).addComponent(this.JTF_Filtro, -2, 57, -2)).addContainerGap(15, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JCH_CTodos);
        this.JCH_CTodos.setFont(new Font("Arial", 1, 12));
        this.JCH_CTodos.setSelected(true);
        this.JCH_CTodos.setText("Todos");
        this.JCH_CTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JCH_CTodosActionPerformed(evt);
            }
        });
        this.JCH_SSeguimiento.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JCH_SSeguimiento);
        this.JCH_SSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_SSeguimiento.setText("Sin Seguimineto");
        this.JCH_SSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JCH_SSeguimientoActionPerformed(evt);
            }
        });
        this.JCH_CConSeguimiento.setBackground(Color.green);
        this.JBG_Filtro.add(this.JCH_CConSeguimiento);
        this.JCH_CConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento.setText("Con seguimiento");
        this.JCH_CConSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JCH_CConSeguimientoActionPerformed(evt);
            }
        });
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SSeguimiento).addComponent(this.JCH_CConSeguimiento).addComponent(this.JCH_CTodos))));
        this.JBT_RegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBT_RegistrarSeguimiento.setForeground(Color.red);
        this.JBT_RegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBT_RegistrarSeguimiento.setText("Realizar Seguimiento");
        this.JBT_RegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JBT_RegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JBT_AbrirHC.setFont(new Font("Arial", 1, 12));
        this.JBT_AbrirHC.setForeground(Color.red);
        this.JBT_AbrirHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_AbrirHC.setText("Abrir Historia Clinica");
        this.JBT_AbrirHC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JBT_AbrirHCActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConvenciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, 32767).addComponent(this.JBT_RegistrarSeguimiento, -2, 222, -2).addGap(44, 44, 44).addComponent(this.JBT_AbrirHC, -2, 222, -2).addContainerGap()));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_Datos1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 5, -2).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_RegistrarSeguimiento, -2, 50, -2).addComponent(this.JBT_AbrirHC, -2, 50, -2))).addComponent(this.JPIConvenciones, -1, -1, 32767)).addGap(30, 30, 30)));
        this.JTP_Utilidades.addTab("UTILIDAD", this.JPI_Datos1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.7
            public void mouseClicked(MouseEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Examenes_PYP.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 487, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 264, -2).addContainerGap(301, 32767)));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(20, 32767)));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIFiltro, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JSP_Detalle).addComponent(this.JTP_Utilidades, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -1, 332, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CConSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_RegistrarSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_Seguimiento_ExamenesPyP xJDSeguimiento = new JD_Seguimiento_ExamenesPyP(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString()));
            xJDSeguimiento.setLocationRelativeTo(this);
            xJDSeguimiento.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AbrirHCActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta("0");
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(Long.parseLong(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString())));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(Long.parseLong(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString())));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(0L);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(new Long(0L));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(new Long(0L));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio("");
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString()));
            Principal.clasehistoriace.mBuscarAtencionIngreso();
            Principal.clasehistoriace.cargarPantalla("Historia", Principal.clasehistoriace.frmPrincipal, "Historia_Med_Auditoria");
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
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
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon("src/Imagenes/Question.png"));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_FiltroKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "No Historia", "Usuario", "Edad", "Sexo", "Telefono", "Empresa Convenio", "IdProcedimiento", "NProcedimiento", "Especialidad", "Profesional", "IdIngreso", "IdAtencion", "IdUsuario", "IdTipoCita", "IdTipoHistoria", "IdPrograma", "FechaAtencion", "IdTipoAtencion", "Seguimiento", "IdItem"}) { // from class: com.genoma.plus.controller.pyp.JIF_Gestion_Examenes_PYP.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTF_Filtro.setText("");
        this.xFiltro = "0,1";
        this.JCH_CTodos.setSelected(true);
        mCreaModeloTabla();
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xGestionExamenesPyp.listaOrdenesProcedimientos(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro, this.JTF_Filtro.getText());
        mCreaModeloTabla();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 7);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 9);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 11);
        long xNregistro = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            for (int y = 0; y < this.JTDetalle.getColumnCount(); y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            xNregistro++;
        }
        this.JLN_NRegistro.setText("" + xNregistro);
    }

    private void springStart() {
        this.xGestionExamenesPyp = (GestionExamenesPyPDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gestionExamenesPyPDAO");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_Gestion_Examenes_PYP$MiRender.class */
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
