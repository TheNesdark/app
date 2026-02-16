package com.genoma.plus.controller.referencia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformeRemision;
import com.genoma.plus.jpa.service.IRemisionesService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JIF_ConsolidadoReferencia.class */
public class JIF_ConsolidadoReferencia extends JInternalFrame {
    private List<Integer> filtro;
    private DefaultTableModel modelo;
    private Object[] dato;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_NRegistro;
    private JPanel JPIDatos;
    private JPanel JPIUtilidades;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private final Metodos metodos = new Metodos();
    private final IRemisionesService remisionesService = (IRemisionesService) Principal.contexto.getBean(IRemisionesService.class);

    public JIF_ConsolidadoReferencia() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JLB_NRegistro = new JLabel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.JPIUtilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE  REFERENCIA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifConsolidadoReferencia");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistro.setForeground(Color.red);
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registros", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JDFechaI, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 163, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_NRegistro, -1, 59, 32767).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JIF_ConsolidadoReferencia.1
            public void mouseClicked(MouseEvent evt) {
                JIF_ConsolidadoReferencia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_ConsolidadoReferencia.2
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoReferencia.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIUtilidadesLayout = new GroupLayout(this.JPIUtilidades);
        this.JPIUtilidades.setLayout(JPIUtilidadesLayout);
        JPIUtilidadesLayout.setHorizontalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFRuta, -2, 792, -2).addGap(59, 59, 59).addComponent(this.JBTExportar, -2, 211, -2).addContainerGap(39, 32767)));
        JPIUtilidadesLayout.setVerticalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(7, 32767)));
        this.JTPDatos.addTab("UTILIDADES", this.JPIUtilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 424, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 109, -2).addGap(16, 16, 16)));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
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
                    this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.metodos.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    private void crearTabla() {
        this.modelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.referencia.JIF_ConsolidadoReferencia.3
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Fecha_Remision");
        this.modelo.addColumn("Hora_Remision");
        this.modelo.addColumn("Identificacion");
        this.modelo.addColumn("Nombre Usuario");
        this.modelo.addColumn("Edad");
        this.modelo.addColumn("Sexo");
        this.modelo.addColumn("Empresa Convenio");
        this.modelo.addColumn("Servicio");
        this.modelo.addColumn("Especialidad Remite");
        this.modelo.addColumn("Diagnostico Ingreso");
        this.modelo.addColumn("Nombre Patologia");
        this.modelo.addColumn("Especialidad Remitente");
        this.modelo.addColumn("Aceptado");
        this.modelo.addColumn("Profesional Remite");
        this.modelo.addColumn("Profesional Acepta");
        this.modelo.addColumn("Fecha Llegada");
        this.modelo.addColumn("Diagnostico Final");
        this.modelo.addColumn("Auxiliar Remision");
        this.modelo.addColumn("Conductor");
        this.modelo.addColumn("Profesional Remision");
        this.modelo.addColumn("Municipio Destino");
        this.modelo.addColumn("Institucion Recibe");
        this.modelo.addColumn("Observacion");
        this.modelo.addColumn("fechaUbicacion");
        this.modelo.addColumn("fechaSalida");
        this.modelo.addColumn("idAtencion");
        this.modelo.addColumn("idPersona");
        this.modelo.addColumn("idIngreso");
        this.modelo.addColumn("Cerrado");
        this.modelo.addColumn("idTipoAtencion");
        this.modelo.addColumn("idTipoHistoria");
        this.modelo.addColumn("Nombre Acompañante");
        this.modelo.addColumn("Telefono Acompañante");
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(150);
        this.JTDetalle.setModel(this.modelo);
    }

    private void cargarDatosTabla() {
        List<IInformeRemision> lista = this.remisionesService.listaConsolidadaRemisiones(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
        crearTabla();
        if (!lista.isEmpty()) {
            int x = 0;
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 7);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 10);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 17);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 23);
            for (IInformeRemision iInformeRemision : lista) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(lista.get(x).getIdRemision(), x, 0);
                this.modelo.setValueAt(lista.get(x).getFecha(), x, 1);
                this.modelo.setValueAt(lista.get(x).getHora(), x, 2);
                this.modelo.setValueAt(lista.get(x).getIdentificacion(), x, 3);
                this.modelo.setValueAt(lista.get(x).getNombreUsuario(), x, 4);
                this.modelo.setValueAt(lista.get(x).getEdad(), x, 5);
                this.modelo.setValueAt(lista.get(x).getSexo(), x, 6);
                this.modelo.setValueAt(lista.get(x).getEmpresaConvenio(), x, 7);
                this.modelo.setValueAt(lista.get(x).getServicio(), x, 8);
                this.modelo.setValueAt(lista.get(x).getEspecialidadRemite(), x, 9);
                this.modelo.setValueAt(lista.get(x).getDiagnosticoIngreso(), x, 10);
                this.modelo.setValueAt(lista.get(x).getNombrePatologia(), x, 11);
                this.modelo.setValueAt(lista.get(x).getEspecialidadRemitente(), x, 12);
                this.modelo.setValueAt(lista.get(x).getAceptado(), x, 13);
                this.modelo.setValueAt(lista.get(x).getProfesionalRemite(), x, 14);
                this.modelo.setValueAt(lista.get(x).getProfesionalAcepta(), x, 15);
                this.modelo.setValueAt(lista.get(x).getFechaLlegada(), x, 16);
                this.modelo.setValueAt(lista.get(x).getDiagnosticoFinal(), x, 17);
                this.modelo.setValueAt(lista.get(x).getAuxiliarRemision(), x, 18);
                this.modelo.setValueAt(lista.get(x).getConductor(), x, 19);
                this.modelo.setValueAt(lista.get(x).getProfesionalRemision(), x, 20);
                this.modelo.setValueAt(lista.get(x).getMunicipioDestino(), x, 21);
                this.modelo.setValueAt(lista.get(x).getInstitucionRecibe(), x, 22);
                this.modelo.setValueAt(lista.get(x).getObservacion(), x, 23);
                this.modelo.setValueAt(lista.get(x).getFechaUbicacion(), x, 24);
                this.modelo.setValueAt(lista.get(x).getFechaSalida(), x, 25);
                this.modelo.setValueAt(lista.get(x).getIdAtencion(), x, 26);
                this.modelo.setValueAt(lista.get(x).getIdPersona(), x, 27);
                this.modelo.setValueAt(lista.get(x).getIdIngreso(), x, 28);
                this.modelo.setValueAt(lista.get(x).getCerrado(), x, 29);
                this.modelo.setValueAt(lista.get(x).getIdTipoAtencion(), x, 30);
                this.modelo.setValueAt(lista.get(x).getIdTipoHistoria(), x, 31);
                this.modelo.setValueAt(lista.get(x).getNombreAcompanante(), x, 32);
                this.modelo.setValueAt(lista.get(x).getTelefonoAcompanante(), x, 33);
                this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                x++;
            }
            this.JLB_NRegistro.setText("" + this.JTDetalle.getRowCount());
        }
    }

    public void buscar() {
        cargarDatosTabla();
    }

    public void nuevo() {
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JIF_ConsolidadoReferencia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Integer nvalidacion = Integer.valueOf(table.getValueAt(row, 29).toString());
            if (nvalidacion.intValue() == 1) {
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
