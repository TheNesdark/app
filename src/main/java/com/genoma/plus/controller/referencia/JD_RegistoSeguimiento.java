package com.genoma.plus.controller.referencia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RemisionesSeguimientosDTO;
import com.genoma.plus.jpa.projection.IRemisionSeguiminiento;
import com.genoma.plus.jpa.service.IRemisionesSeguimientoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JD_RegistoSeguimiento.class */
public class JD_RegistoSeguimiento extends JDialog {
    private Long idRemision;
    private Metodos metodos;
    private final IRemisionesSeguimientoService seguimientoService;
    private DefaultTableModel modelo;
    private Object[] dato;
    private JButton JBGuardar;
    private JButton JBNuevo;
    private JButton JBTImprimir;
    private JButton JBT_Salir;
    private JDateChooser JDFechaC;
    private JPanel JPI_DatosRegistro;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Detalle;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFHora;

    public JD_RegistoSeguimiento(Frame parent, boolean modal, Long idRemision) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.seguimientoService = (IRemisionesSeguimientoService) Principal.contexto.getBean(IRemisionesSeguimientoService.class);
        initComponents();
        this.idRemision = idRemision;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosRegistro = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTFHora = new JFormattedTextField();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBNuevo = new JButton();
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JBTImprimir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO DE SEGUIMIENTO");
        setFont(new Font("Arial", 1, 14));
        this.JPI_DatosRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS REGISTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_DatosRegistro.setFont(new Font("Arial", 1, 14));
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.JTFHora.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_DatosRegistroLayout = new GroupLayout(this.JPI_DatosRegistro);
        this.JPI_DatosRegistro.setLayout(JPI_DatosRegistroLayout);
        JPI_DatosRegistroLayout.setHorizontalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addGap(35, 35, 35).addComponent(this.JTFHora, -2, 110, -2).addGap(0, 0, 32767)).addComponent(this.JSPObservacion, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPI_DatosRegistroLayout.setVerticalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaC, -2, 50, -2).addComponent(this.JTFHora)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, -1, -2).addGap(14, 14, 14)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoSeguimiento.1
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimiento.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoSeguimiento.2
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimiento.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoSeguimiento.3
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimiento.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoSeguimiento.4
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimiento.this.JBTImprimirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGuardar, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTImprimir, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JBT_Salir, -2, 200, -2)).addComponent(this.JPI_DatosRegistro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPI_DatosRegistro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -2, 208, -2).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBTImprimir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.JDFechaC.setDate(this.metodos.getFechaActualPC());
        this.JTFHora.setValue(this.metodos.getFechaActual());
        this.JTAObservacion.setText("");
        cargarDatosTabla();
        this.JDFechaC.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTAObservacion.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                RemisionesSeguimientosDTO seguimientosDTO = new RemisionesSeguimientosDTO();
                seguimientosDTO.setIdRemision(this.idRemision);
                seguimientosDTO.setFechaHora(this.metodos.formatoAMD.format(this.JDFechaC.getDate()) + " " + this.metodos.formatoH24.format(this.JTFHora.getValue()));
                seguimientosDTO.setDescripcion(this.JTAObservacion.getText());
                seguimientosDTO.setEstado(true);
                seguimientosDTO.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                seguimientosDTO.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                seguimientosDTO.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                seguimientosDTO.setFecha(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                this.seguimientoService.save(seguimientosDTO);
                nuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La observación no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            String[][] parametros = new String[5][2];
            parametros[0][0] = "numero";
            parametros[0][1] = this.idRemision.toString();
            parametros[1][0] = "ruta";
            parametros[1][1] = this.metodos.getRutaRep();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            parametros[4][0] = "nbreUsuario";
            parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_Ref_SeguimientoBitacora", parametros);
        }
    }

    private void crearTabla() {
        this.modelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.referencia.JD_RegistoSeguimiento.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Fecha_Hora");
        this.modelo.addColumn("Descripcion");
        this.modelo.addColumn("Cargo");
        this.modelo.addColumn("Persona Registro");
        this.modelo.addColumn("Estado");
        this.modelo.addColumn("Fecha Registro");
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.setModel(this.modelo);
    }

    private void cargarDatosTabla() {
        List<IRemisionSeguiminiento> lista = this.seguimientoService.listaSeguimientosPorIdRemision(this.idRemision);
        crearTabla();
        if (!lista.isEmpty()) {
            int x = 0;
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 2);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 3);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 4);
            for (IRemisionSeguiminiento iRemisionSeguiminiento : lista) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(lista.get(x).getId(), x, 0);
                this.modelo.setValueAt(lista.get(x).getFechaHora(), x, 1);
                this.modelo.setValueAt(lista.get(x).getDescripcion(), x, 2);
                this.modelo.setValueAt(lista.get(x).getEspecialidad(), x, 3);
                this.modelo.setValueAt(lista.get(x).getProfesional(), x, 4);
                this.modelo.setValueAt(lista.get(x).getEstado(), x, 5);
                this.modelo.setValueAt(lista.get(x).getFecha(), x, 6);
                x++;
            }
        }
    }
}
