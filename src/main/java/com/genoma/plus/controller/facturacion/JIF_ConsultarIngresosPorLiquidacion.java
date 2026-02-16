package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformeIngresoSinLiquidacion;
import com.genoma.plus.jpa.service.IngresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIF_ConsultarIngresosPorLiquidacion.class */
public class JIF_ConsultarIngresosPorLiquidacion extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] dato;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_NRegistro;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    Metodos metodo = new Metodos();
    private final IngresoService ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);

    public JIF_ConsultarIngresosPorLiquidacion() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JLB_NRegistro = new JLabel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INGRESOS POR LIQUIDACIÓN");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifConsultarIngresosLiquidacion");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 138, -2).addGap(19, 19, 19)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_NRegistro, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2))).addGap(9, 9, 9)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIF_ConsultarIngresosPorLiquidacion.1
            public void mouseClicked(MouseEvent evt) {
                JIF_ConsultarIngresosPorLiquidacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIF_ConsultarIngresosPorLiquidacion.2
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsultarIngresosPorLiquidacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 685, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JBTExportar, -2, 211, -2)).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(13, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(21, 32767)));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.metodo.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    public void nuevo() {
        this.JDFechaI.setDate(this.metodo.getFechaActual());
        this.JDFechaF.setDate(this.metodo.getFechaActual());
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion() + "Planilla");
        crearTabla();
    }

    public void crearTabla() {
        this.modelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.facturacion.JIF_ConsultarIngresosPorLiquidacion.3
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modelo.addColumn("Id Ingreso");
        this.modelo.addColumn("Fecha Ingreso");
        this.modelo.addColumn("Numero Historia");
        this.modelo.addColumn("Tipo Atencion");
        this.modelo.addColumn("Nombre Usuario");
        this.modelo.addColumn("Codigo Diagnostico");
        this.modelo.addColumn("Nombre  Convenio");
        this.modelo.addColumn("Detalle Anulacion");
        this.modelo.addColumn("Fecha Anulacion");
        this.modelo.addColumn("Usuario Anulacion");
        this.modelo.addColumn("Valor Ingreso");
        this.modelo.addColumn("Usuario Sistemas");
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.setModel(this.modelo);
    }

    private void cargarDatosTable() {
        List<IInformeIngresoSinLiquidacion> ingresoSinLiquidacion = this.ingresoService.informeIngresoSinLiquidacion(new Long(1L), this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()));
        crearTabla();
        if (!ingresoSinLiquidacion.isEmpty()) {
            int fila = 0;
            for (IInformeIngresoSinLiquidacion next : ingresoSinLiquidacion) {
                this.modelo.addRow((Object[]) null);
                this.modelo.setValueAt(next.getIdIngreso(), fila, 0);
                this.modelo.setValueAt(next.getFechaIngreso(), fila, 1);
                this.modelo.setValueAt(next.getNumeroHistoria(), fila, 2);
                this.modelo.setValueAt(next.getTipoAtencion(), fila, 3);
                this.modelo.setValueAt(next.getNombreUsuario(), fila, 4);
                this.modelo.setValueAt(next.getCodigoDiagnostico(), fila, 5);
                this.modelo.setValueAt(next.getNombreConvenio(), fila, 6);
                this.modelo.setValueAt(next.getDetalleAnulacion(), fila, 7);
                this.modelo.setValueAt(next.getFechaAnulacion(), fila, 8);
                this.modelo.setValueAt(next.getUsuarioAnulacion(), fila, 9);
                this.modelo.setValueAt(next.getValorTotal(), fila, 10);
                this.modelo.setValueAt(next.getUsuarioSistemas(), fila, 11);
                fila++;
            }
            this.JLB_NRegistro.setText("" + fila);
        }
    }

    public void buscar() {
        cargarDatosTable();
    }
}
