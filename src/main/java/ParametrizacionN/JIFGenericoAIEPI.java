package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.PAiepiClasificacion;
import com.genoma.plus.jpa.entities.PAiepiOncologicoPreguntas;
import com.genoma.plus.jpa.entities.PAiepiRespuestas;
import com.genoma.plus.jpa.service.IPAiepiClasificacionService;
import com.genoma.plus.jpa.service.IPAiepiOncologicoPreguntasService;
import com.genoma.plus.jpa.service.IPAiepiRespuestasService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenericoAIEPI.class */
public class JIFGenericoAIEPI extends JInternalFrame {
    private String xnombre;
    private DefaultTableModel model;
    private Metodos metodos;
    private Object[] data;
    private final PAiepiClasificacion aiepiClasificacion;
    private final IPAiepiClasificacionService aiepiClasificacionService;
    private List<PAiepiClasificacion> listAiepiClasificacion;
    private final PAiepiRespuestas aiepiRespuestas;
    private final IPAiepiRespuestasService aiepiRespuestasService;
    private List<PAiepiRespuestas> listAiepiRespuestas;
    private final PAiepiOncologicoPreguntas aiepiOncologicoPreguntas;
    private final IPAiepiOncologicoPreguntasService aiepiOncologicoPreguntasService;
    private List<PAiepiOncologicoPreguntas> listPAiepiOncologicoPreguntas;
    private boolean estado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private TextArea JTAClasificacion;
    private JTextField JTFOrden;
    private JTable JTable;
    private JPanel jPanel1;

    public JIFGenericoAIEPI(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombref;
        this.model = new DefaultTableModel();
        this.aiepiClasificacion = new PAiepiClasificacion();
        this.aiepiClasificacionService = (IPAiepiClasificacionService) Principal.contexto.getBean(IPAiepiClasificacionService.class);
        this.listAiepiClasificacion = new ArrayList();
        this.aiepiRespuestas = new PAiepiRespuestas();
        this.aiepiRespuestasService = (IPAiepiRespuestasService) Principal.contexto.getBean(IPAiepiRespuestasService.class);
        this.listAiepiRespuestas = new ArrayList();
        this.aiepiOncologicoPreguntas = new PAiepiOncologicoPreguntas();
        this.aiepiOncologicoPreguntasService = (IPAiepiOncologicoPreguntasService) Principal.contexto.getBean(IPAiepiOncologicoPreguntasService.class);
        this.listPAiepiOncologicoPreguntas = new ArrayList();
        this.estado = true;
        newM();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTAClasificacion = new TextArea();
        this.JTFOrden = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AIEPI");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifGenericoAiepi");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatos.setName("jiftecnologiasalud");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFOrden.setFont(new Font("Arial", 1, 13));
        this.JTFOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFOrden.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoAIEPI.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoAIEPI.this.JTFOrdenActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoAIEPI.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoAIEPI.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTAClasificacion, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFOrden, -2, 104, -2).addGap(40, 40, 40).addComponent(this.JCHEstado).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTAClasificacion, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOrden, -2, 48, -2).addComponent(this.JCHEstado)).addContainerGap()));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPDetalle.setName("aiepi");
        this.JSPDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoAIEPI.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoAIEPI.this.JSPDetalleMouseClicked(evt);
            }
        });
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoAIEPI.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoAIEPI.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 921, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 363, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOrdenActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.estado = true;
        } else {
            this.estado = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            selectRow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleMouseClicked(MouseEvent evt) {
    }

    public void newM() {
        loadDataTable();
        this.JCHEstado.setSelected(true);
        this.JTFOrden.setText("");
        this.JTAClasificacion.setText("");
        Principal.txtNo.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void createDataModel() {
        this.model = new DefaultTableModel(new Object[0], new String[]{"CÓDIGO", "DESCRIPCIÓN", "ORDEN", "ESTADO"}) { // from class: ParametrizacionN.JIFGenericoAIEPI.5
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.model);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void loadDataTable() {
        createDataModel();
        if (this.xnombre.equals("Clasificación AIEPI")) {
            this.listAiepiClasificacion = this.aiepiClasificacionService.getListPAiepiClasificacionByOrdenAsc();
            this.listAiepiClasificacion.forEach(e -> {
                this.model.addRow(this.data);
                this.model.setValueAt(e.getId(), this.JTable.getRowCount() - 1, 0);
                this.model.setValueAt(e.getDescripcion(), this.JTable.getRowCount() - 1, 1);
                this.model.setValueAt(e.getOrden(), this.JTable.getRowCount() - 1, 2);
                if (e.getEstado().intValue() == 1) {
                    this.estado = true;
                } else {
                    this.estado = false;
                }
                this.model.setValueAt(Boolean.valueOf(this.estado), this.JTable.getRowCount() - 1, 3);
            });
        } else if (this.xnombre.equals("Respuestas AIEPI")) {
            this.listAiepiRespuestas = this.aiepiRespuestasService.getListPAiepiRespuestasByTestPadreOrderedByOrden(0);
            this.listAiepiRespuestas.forEach(e2 -> {
                this.model.addRow(this.data);
                this.model.setValueAt(e2.getId(), this.JTable.getRowCount() - 1, 0);
                this.model.setValueAt(e2.getDescripcion(), this.JTable.getRowCount() - 1, 1);
                this.model.setValueAt(e2.getOrden(), this.JTable.getRowCount() - 1, 2);
                if (e2.getEstado().intValue() == 1) {
                    this.estado = true;
                } else {
                    this.estado = false;
                }
                this.model.setValueAt(Boolean.valueOf(this.estado), this.JTable.getRowCount() - 1, 3);
            });
        } else if (this.xnombre.equals("Preguntas AIEPI Oncologíco")) {
            this.listPAiepiOncologicoPreguntas = this.aiepiOncologicoPreguntasService.getListPAiepiOncologicoPreguntasByTestPadreAndOrden(0);
            this.listPAiepiOncologicoPreguntas.forEach(e3 -> {
                this.model.addRow(this.data);
                this.model.setValueAt(e3.getId(), this.JTable.getRowCount() - 1, 0);
                this.model.setValueAt(e3.getPregunta(), this.JTable.getRowCount() - 1, 1);
                this.model.setValueAt(e3.getOrden(), this.JTable.getRowCount() - 1, 2);
                if (e3.getEstado().intValue() == 1) {
                    this.estado = true;
                } else {
                    this.estado = false;
                }
                this.model.setValueAt(Boolean.valueOf(this.estado), this.JTable.getRowCount() - 1, 3);
            });
        }
    }

    private void selectRow() {
        this.JCHEstado.setSelected(Boolean.valueOf(this.model.getValueAt(this.JTable.getSelectedRow(), 3).toString()).booleanValue());
        this.JTFOrden.setText(this.model.getValueAt(this.JTable.getSelectedRow(), 2).toString());
        this.JTAClasificacion.setText(this.model.getValueAt(this.JTable.getSelectedRow(), 1).toString());
        Principal.txtNo.setText(this.model.getValueAt(this.JTable.getSelectedRow(), 0).toString());
    }

    public void save() {
        LocalDate currentDate = LocalDate.now();
        if (this.xnombre.equals("Clasificación AIEPI")) {
            if (!this.JTAClasificacion.getText().isEmpty()) {
                if (!this.JTFOrden.getText().isEmpty()) {
                    PAiepiClasificacion aiepi = new PAiepiClasificacion();
                    if (!Principal.txtNo.getText().isEmpty()) {
                        aiepi.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                        aiepi.setUsuarioSActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario());
                        aiepi.setFechaActualizacion(currentDate);
                    }
                    aiepi.setDescripcion(this.JTAClasificacion.getText().toUpperCase());
                    aiepi.setOrden(Integer.valueOf(Integer.parseInt(this.JTFOrden.getText().toString())));
                    if (this.estado) {
                        aiepi.setEstado(1);
                    } else {
                        aiepi.setEstado(0);
                    }
                    aiepi.setFechaCreacion(currentDate);
                    aiepi.setUsuarioS(Principal.usuarioSistemaDTO.getNombreUsuario());
                    this.aiepiClasificacionService.save(aiepi);
                    JOptionPane.showMessageDialog((Component) null, "¡Datos Guardados!");
                    newM();
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "Digite el orden");
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Digite una clasificación");
            return;
        }
        if (this.xnombre.equals("Respuestas AIEPI")) {
            if (!this.JTAClasificacion.getText().isEmpty()) {
                if (!this.JTFOrden.getText().isEmpty()) {
                    PAiepiRespuestas aiepi2 = new PAiepiRespuestas();
                    if (!Principal.txtNo.getText().isEmpty()) {
                        aiepi2.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                        aiepi2.setUsuarioSActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario());
                        aiepi2.setFechaActualizacion(currentDate);
                    }
                    aiepi2.setDescripcion(this.JTAClasificacion.getText().toUpperCase());
                    aiepi2.setOrden(Integer.valueOf(Integer.parseInt(this.JTFOrden.getText().toString())));
                    if (this.estado) {
                        aiepi2.setEstado(1);
                    } else {
                        aiepi2.setEstado(0);
                    }
                    aiepi2.setFechaCreacion(currentDate);
                    aiepi2.setUsuarioS(Principal.usuarioSistemaDTO.getNombreUsuario());
                    this.aiepiRespuestasService.save(aiepi2);
                    JOptionPane.showMessageDialog((Component) null, "¡Datos Guardados!");
                    newM();
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "Digite el orden");
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Digite una clasificación");
            return;
        }
        if (this.xnombre.equals("Preguntas AIEPI Oncologíco")) {
            if (!this.JTAClasificacion.getText().isEmpty()) {
                if (!this.JTFOrden.getText().isEmpty()) {
                    PAiepiOncologicoPreguntas aiepi3 = new PAiepiOncologicoPreguntas();
                    if (!Principal.txtNo.getText().isEmpty()) {
                        aiepi3.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                        aiepi3.setUsuarioSActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario());
                        aiepi3.setFechaActualizacion(currentDate);
                    }
                    aiepi3.setPregunta(this.JTAClasificacion.getText().toUpperCase());
                    aiepi3.setOrden(Integer.valueOf(Integer.parseInt(this.JTFOrden.getText().toString())));
                    if (this.estado) {
                        aiepi3.setEstado(1);
                    } else {
                        aiepi3.setEstado(0);
                    }
                    aiepi3.setFechaCreacion(currentDate);
                    aiepi3.setUsuarioS(Principal.usuarioSistemaDTO.getNombreUsuario());
                    this.aiepiOncologicoPreguntasService.save(aiepi3);
                    JOptionPane.showMessageDialog((Component) null, "¡Datos Guardados!");
                    newM();
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "Digite el orden");
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Digite una clasificación");
        }
    }
}
