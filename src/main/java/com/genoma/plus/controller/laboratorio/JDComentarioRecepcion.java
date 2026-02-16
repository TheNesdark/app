package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.DetalleRecepcionComentarioDTO;
import com.genoma.plus.jpa.projection.IDetalleRecepcionComentario;
import com.genoma.plus.jpa.service.IDetalleRecepcionComentarioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDComentarioRecepcion.class */
public class JDComentarioRecepcion extends JDialog {
    private DefaultTableModel modelo;
    private Metodos metodos;
    private Long idRecepcion;
    private Long idProcedimiento;
    private List<Long> idProcedimientos;
    private IDetalleRecepcionComentarioService comentarioService;
    private Object[] datos;
    private JButton JBGrabar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JDateChooser JDFechaC;
    private JScrollPane JSPDetalle1;
    private JTextArea JTADescripcionSeguimiento;
    private JTable JTDetalleC;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDComentarioRecepcion(Frame parent, boolean modal, Long idRecepcion, Long idProcedimiento) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.comentarioService = (IDetalleRecepcionComentarioService) Principal.contexto.getBean(IDetalleRecepcionComentarioService.class);
        initComponents();
        this.idRecepcion = idRecepcion;
        this.idProcedimiento = idProcedimiento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    public JDComentarioRecepcion(Frame parent, boolean modal, Long idRecepcion, List<Long> idProcedimientos) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.comentarioService = (IDetalleRecepcionComentarioService) Principal.contexto.getBean(IDetalleRecepcionComentarioService.class);
        initComponents();
        this.idProcedimientos = new ArrayList();
        this.idRecepcion = idRecepcion;
        this.idProcedimientos = idProcedimientos;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcionSeguimiento = new JTextArea();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JBNuevo = new JButton();
        this.JBGrabar = new JButton();
        this.JBSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO DE NOTAS");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JDFechaC.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDComentarioRecepcion.this.JDFechaCPropertyChange(evt);
            }
        });
        this.JTADescripcionSeguimiento.setColumns(20);
        this.JTADescripcionSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JTADescripcionSeguimiento.setRows(5);
        this.JTADescripcionSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTADescripcionSeguimiento);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jScrollPane1, -2, 662, -2)).addComponent(this.JDFechaC, -2, 115, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaC, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 92, 32767).addGap(12, 12, 12)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setSelectionBackground(Color.white);
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.2
            public void mouseClicked(MouseEvent evt) {
                JDComentarioRecepcion.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalleC);
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.3
            public void actionPerformed(ActionEvent evt) {
                JDComentarioRecepcion.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.4
            public void actionPerformed(ActionEvent evt) {
                JDComentarioRecepcion.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.5
            public void actionPerformed(ActionEvent evt) {
                JDComentarioRecepcion.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 250, -2).addGap(30, 30, 30).addComponent(this.JBGrabar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.JBSalir, -2, 250, -2))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 816, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 261, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBSalir, -1, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(193, 193, 193).addComponent(this.JSPDetalle1, -2, 248, -2).addContainerGap(61, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaCPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        confirmarYGrabarComentario();
    }

    private void grabarComentario(Long idProcedimiento) {
        System.out.println("idProcediemnto : " + idProcedimiento);
        DetalleRecepcionComentarioDTO comentarioDTO = DetalleRecepcionComentarioDTO.builder().descripcion(this.JTADescripcionSeguimiento.getText()).esRemitido(false).estado(true).fecha(this.metodos.formatoAMD.format(this.JDFechaC.getDate())).fechaRegistro(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual())).idEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()).idProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).idRecepcion(this.idRecepcion).idProcedimiento(idProcedimiento).idUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo()).build();
        if (this.JTDetalleC.getSelectedRow() != -1) {
            comentarioDTO.setId(Long.valueOf(this.modelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString()));
        }
        this.comentarioService.grabar(comentarioDTO);
    }

    private void confirmarYGrabarComentario() {
        if (this.JTADescripcionSeguimiento.getText().isEmpty()) {
            return;
        }
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de grabar?", "GRABAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (opcion != 0) {
            return;
        }
        if (this.idProcedimiento != null) {
            System.out.println("procedimiento ");
            grabarComentario(this.idProcedimiento);
        } else if (!this.idProcedimientos.isEmpty()) {
            System.out.println("lsita ");
            this.idProcedimientos.forEach(this::grabarComentario);
        }
        cargarHistorico();
    }

    private void nuevo() {
        this.JDFechaC.setDate(this.metodos.getFechaActual());
        this.JTADescripcionSeguimiento.setText("");
        cargarHistorico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSeguimientos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Descripcion", "Especialidad", "Profesional", "Fecha y Hora Registro"}) { // from class: com.genoma.plus.controller.laboratorio.JDComentarioRecepcion.6
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.doLayout();
        this.JTDetalleC.setModel(this.modelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void cargarHistorico() {
        List<IDetalleRecepcionComentario> lista = this.comentarioService.listaDetalle(this.idRecepcion);
        crearModeloSeguimientos();
        if (!lista.isEmpty()) {
            int index = 0;
            this.metodos.mEstablecerTextEditor(this.JTDetalleC, 2);
            for (IDetalleRecepcionComentario iDetalleRecepcionComentario : lista) {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getId(), index, 0);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getFecha(), index, 1);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getDescripcion(), index, 2);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getEspecialidad(), index, 3);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getProfesional(), index, 4);
                this.modelo.setValueAt(iDetalleRecepcionComentario.getFechaRegistro(), index, 5);
                index++;
            }
        }
    }
}
