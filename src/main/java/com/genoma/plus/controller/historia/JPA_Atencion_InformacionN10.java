package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO;
import com.genoma.plus.dao.impl.historia.Atencion_Informacion_N10_DAOImpl;
import com.genoma.plus.dto.historia.Atencion_Informacion_n10DTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_Atencion_InformacionN10.class */
public class JPA_Atencion_InformacionN10 extends JPanel {
    private Atencion_Informacion_N10DAO atencion_Informacion_N10DAO;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHistorico;
    private Object[] datos;
    private final Metodos metodos = new Metodos();
    private final String idAtencion;
    private final String nombreItems;
    private final String idTipoHistoria;
    private final String sexo;
    private final String fechaAtencion;
    private final String fechaNacimiento;
    private final Integer tipoHistoria;
    private final Long idUsuarioAtendido;
    int fila;
    private JButton JBTExportar;
    private JButton JBTGuardar;
    private JCheckBox JCH_ValorporDefecto;
    private JPanel JPI_Detalle;
    private JPanel JPI_Historico;
    private JScrollPane JSP_Antecedentes;
    private JScrollPane JSP_Historico_Antecedentes;
    private JTable JTB_Antecedentes;
    private JTabbedPane JTB_Datos;
    private JTable JTB_Historico_Antecedentes;
    private JTextField JTFRuta;

    public JPA_Atencion_InformacionN10(String nombreItems, String idAtencion, String idTipoHistoria, Integer tipoHistoria, String sexo, String fechaAtencion, String fechaNacimiento, Long idUsuarioAtendido) {
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, nombreItems, 2, 0, new Font("Arial", 1, 14), Color.red));
        springStart();
        this.idAtencion = idAtencion;
        this.idTipoHistoria = idTipoHistoria;
        this.nombreItems = nombreItems;
        this.tipoHistoria = tipoHistoria;
        this.sexo = sexo;
        this.fechaAtencion = fechaAtencion;
        this.fechaNacimiento = fechaNacimiento;
        this.idUsuarioAtendido = idUsuarioAtendido;
        mCargarDatosTabla();
        cargarDatosTablaHistorico();
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() == 1) {
            this.JBTGuardar.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Detalle = new JPanel();
        this.JSP_Antecedentes = new JScrollPane();
        this.JTB_Antecedentes = new JTable();
        this.JCH_ValorporDefecto = new JCheckBox();
        this.JBTGuardar = new JButton();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico_Antecedentes = new JScrollPane();
        this.JTB_Historico_Antecedentes = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TITULO", 2, 0, new Font("Arial", 1, 14), Color.red));
        setName("jpa_atencion_informacionn10");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_Atencion_InformacionN10.this.formAncestorRemoved(evt);
            }
        });
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JTB_Datos.addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.2
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_Atencion_InformacionN10.this.JTB_DatosAncestorRemoved(evt);
            }
        });
        this.JTB_Antecedentes.setFont(new Font("Arial", 1, 12));
        this.JTB_Antecedentes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Antecedentes.setRowHeight(50);
        this.JTB_Antecedentes.setSelectionBackground(Color.white);
        this.JTB_Antecedentes.setSelectionForeground(Color.red);
        this.JTB_Antecedentes.setSelectionMode(0);
        this.JTB_Antecedentes.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.3
            public void mouseClicked(MouseEvent evt) {
                JPA_Atencion_InformacionN10.this.JTB_AntecedentesMouseClicked(evt);
            }
        });
        this.JSP_Antecedentes.setViewportView(this.JTB_Antecedentes);
        this.JCH_ValorporDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto.setForeground(Color.red);
        this.JCH_ValorporDefecto.setText("Utilizar valor por defecto?");
        this.JCH_ValorporDefecto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.4
            public void actionPerformed(ActionEvent evt) {
                JPA_Atencion_InformacionN10.this.JCH_ValorporDefectoActionPerformed(evt);
            }
        });
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.5
            public void actionPerformed(ActionEvent evt) {
                JPA_Atencion_InformacionN10.this.JBTGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardar, -1, -1, 32767).addComponent(this.JSP_Antecedentes, -1, 769, 32767).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JCH_ValorporDefecto).addGap(0, 0, 32767))).addContainerGap()));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_ValorporDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Antecedentes, -2, 432, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -1, -1, 32767).addContainerGap()));
        this.JTB_Datos.addTab("DETALLE", this.JPI_Detalle);
        this.JTB_Historico_Antecedentes.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico_Antecedentes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico_Antecedentes.setRowHeight(50);
        this.JTB_Historico_Antecedentes.setSelectionBackground(Color.white);
        this.JTB_Historico_Antecedentes.setSelectionForeground(Color.red);
        this.JTB_Historico_Antecedentes.setSelectionMode(0);
        this.JSP_Historico_Antecedentes.setViewportView(this.JTB_Historico_Antecedentes);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.6
            public void mouseClicked(MouseEvent evt) {
                JPA_Atencion_InformacionN10.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.7
            public void actionPerformed(ActionEvent evt) {
                JPA_Atencion_InformacionN10.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Historico_Antecedentes, -1, 769, 32767).addGroup(JPI_HistoricoLayout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 209, -2))).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico_Antecedentes, -2, 455, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        this.JTB_Datos.addTab("HÍSTORICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto.isSelected()) {
            for (int i = 0; i < this.JTB_Antecedentes.getRowCount(); i++) {
                if (Long.valueOf(this.modelo.getValueAt(i, 3).toString()).longValue() == 0 && this.modelo.getValueAt(i, 2).toString().equals("")) {
                    this.modelo.setValueAt(this.modelo.getValueAt(i, 4).toString(), i, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DatosAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTB_Historico_Antecedentes.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Historico_Antecedentes, this.JTFRuta.getText(), getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AntecedentesMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 0) {
            if (this.JTB_Antecedentes.getSelectedColumn() == 6) {
                if (((Boolean) this.JTB_Antecedentes.getValueAt(this.JTB_Antecedentes.getSelectedRow(), 5)).booleanValue()) {
                    this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 5);
                }
            } else if (this.JTB_Antecedentes.getSelectedColumn() == 5 && ((Boolean) this.JTB_Antecedentes.getValueAt(this.JTB_Antecedentes.getSelectedRow(), 6)).booleanValue()) {
                this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 6);
            }
        }
    }

    private void springStart() {
        this.atencion_Informacion_N10DAO = (Atencion_Informacion_N10_DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("Atencion_Informacion_N10_DAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloDatos() {
        String[] encabezado = {"IdCNivel", "NItems", "Observacion", "Id", "VDefecto"};
        if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
            if (this.nombreItems.equals("ENFERMEDADES O TRASTORNOS EN FAMILIARES COLATERALES")) {
                encabezado = new String[]{"IdCNivel", "Antecedente", "Familiar que lo presenta", "Id", "VDefecto"};
            }
            if (this.nombreItems.equals("MOTRICIDAD GRUESA") || this.nombreItems.equals("MOTRICIDAD FINA")) {
                encabezado = new String[]{"IdCNivel", "Hábil para", "SI / NO", "Id", "VDefecto"};
            }
            if (this.nombreItems.equals("LENGUAJE")) {
                encabezado = new String[]{"IdCNivel", "Dificultades del lenguaje", "SI / NO", "Id", "VDefecto"};
            }
        }
        this.modelo = new DefaultTableModel(new Object[0], encabezado) { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.8
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Antecedentes.setModel(this.modelo);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Antecedentes.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"idAtención", "Fecha", "Nombre de Items", "Observación", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Historico_Antecedentes;
        JTable jTable2 = this.JTB_Historico_Antecedentes;
        jTable.setAutoResizeMode(0);
        this.JTB_Historico_Antecedentes.doLayout();
        this.JTB_Historico_Antecedentes.setModel(this.modeloHistorico);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_Historico_Antecedentes.getColumnModel().getColumn(5).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        modeloDatos();
        List<Object[]> list = this.atencion_Informacion_N10DAO.listAtencionFiltradaNombreItems(Long.valueOf(this.idAtencion), this.nombreItems, this.idTipoHistoria, this.tipoHistoria, this.sexo, this.fechaAtencion, this.fechaNacimiento);
        this.metodos.mEstablecerTextEditor(this.JTB_Antecedentes, 1);
        this.metodos.mEstablecerTextEditor(this.JTB_Antecedentes, 2);
        for (int x = 0; x < list.size(); x++) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(list.get(x)[0], x, 0);
            this.modelo.setValueAt(list.get(x)[1], x, 1);
            this.modelo.setValueAt(list.get(x)[2], x, 2);
            this.modelo.setValueAt(list.get(x)[3], x, 3);
            this.modelo.setValueAt(list.get(x)[4], x, 4);
        }
    }

    private void cargarDatosTablaHistorico() {
        modeloHistorico();
        List<Object[]> list = this.atencion_Informacion_N10DAO.listHistoricoAtenciones(Long.valueOf(this.idAtencion), this.nombreItems, this.idUsuarioAtendido);
        this.metodos.mEstablecerTextEditor(this.JTB_Historico_Antecedentes, 3);
        this.metodos.mEstablecerTextEditor(this.JTB_Historico_Antecedentes, 5);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.modeloHistorico.addRow(this.datos);
                this.modeloHistorico.setValueAt(list.get(x)[0], x, 0);
                this.modeloHistorico.setValueAt(list.get(x)[1], x, 1);
                this.modeloHistorico.setValueAt(list.get(x)[2], x, 2);
                this.modeloHistorico.setValueAt(list.get(x)[3], x, 3);
                this.modeloHistorico.setValueAt(list.get(x)[4], x, 4);
                this.modeloHistorico.setValueAt(list.get(x)[5], x, 5);
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    public void mGrabar() {
        if (this.JTB_Antecedentes.isEditing()) {
            this.JTB_Antecedentes.getCellEditor().stopCellEditing();
        }
        if (!this.metodos.mVerificarDatosLLeno(this.JTB_Antecedentes, 2)) {
            for (int x = 0; x < this.JTB_Antecedentes.getRowCount(); x++) {
                Atencion_Informacion_n10DTO e = new Atencion_Informacion_n10DTO();
                e.setIdAtencion(Long.valueOf(this.idAtencion));
                e.setIdItems(Long.valueOf(this.JTB_Antecedentes.getValueAt(x, 0).toString()));
                e.setNombre(this.JTB_Antecedentes.getValueAt(x, 1).toString());
                e.setDetalle(this.JTB_Antecedentes.getValueAt(x, 2).toString());
                e.setId(Long.valueOf(this.JTB_Antecedentes.getValueAt(x, 3).toString()));
                e.setId_UsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                e.setEstado(true);
                e.setFecha(this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()));
                if (Long.parseLong(this.JTB_Antecedentes.getValueAt(x, 3).toString()) == 0) {
                    this.atencion_Informacion_N10DAO.mCreate(e);
                } else {
                    this.atencion_Informacion_N10DAO.mUpdate(e);
                }
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mCargarDatosTabla();
        }
        cargarDatosTablaHistorico();
    }
}
