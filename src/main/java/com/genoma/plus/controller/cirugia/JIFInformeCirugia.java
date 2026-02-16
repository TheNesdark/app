package com.genoma.plus.controller.cirugia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.InformeCirugia;
import com.genoma.plus.jpa.service.InformeCirugiaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/cirugia/JIFInformeCirugia.class */
public class JIFInformeCirugia extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] datos;
    private Metodos metodo = new Metodos();
    private final InformeCirugiaService informeCirugia = (InformeCirugiaService) Principal.contexto.getBean(InformeCirugiaService.class);
    private JButton JBTExportar;
    private JDateChooser JDCFechaFinal;
    private JDateChooser JDCFechaInicial;
    private JLabel JLOportunidad;
    private JLabel JLProgamadas;
    private JLabel JLPromedioCancelada;
    private JPanel JPI_Consolidado;
    private JPanel JPI_Utilidades;
    private JTabbedPane JTB_DatosUtilidades;
    private JTable JTDatos;
    private JTextField JTFRuta;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JIFInformeCirugia() {
        initComponents();
        this.JDCFechaInicial.setDate(this.metodo.getFechaActual());
        this.JDCFechaFinal.setDate(this.metodo.getFechaActual());
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDCFechaFinal = new JDateChooser();
        this.JDCFechaInicial = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDatos = new JTable();
        this.JTB_DatosUtilidades = new JTabbedPane();
        this.JPI_Consolidado = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JLPromedioCancelada = new JLabel();
        this.JLProgamadas = new JLabel();
        this.JLOportunidad = new JLabel();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setMaximizable(true);
        setTitle("INFORME CIRUGIA PROGRAMADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jIFInformeCirugia");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFinal.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFinal.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFinal.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.cirugia.JIFInformeCirugia.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeCirugia.this.JDCFechaFinalPropertyChange(evt);
            }
        });
        this.JDCFechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicial.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicial.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicial.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.cirugia.JIFInformeCirugia.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeCirugia.this.JDCFechaInicialPropertyChange(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JDCFechaInicial, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JDCFechaFinal, -2, 150, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaFinal, -2, 57, -2).addComponent(this.JDCFechaInicial, -2, 57, -2)).addContainerGap(14, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDatos.setFont(new Font("Arial", 1, 12));
        this.JTDatos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDatos.setRowHeight(25);
        this.jScrollPane1.setViewportView(this.JTDatos);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 425, 32767));
        this.JTB_DatosUtilidades.setForeground(new Color(0, 103, 0));
        this.JTB_DatosUtilidades.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Promedio Canceladas:");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Total Programadas:");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Oportunidad:");
        this.JLPromedioCancelada.setFont(new Font("Arial", 1, 12));
        this.JLPromedioCancelada.setHorizontalAlignment(0);
        this.JLPromedioCancelada.setText("0");
        this.JLProgamadas.setFont(new Font("Arial", 1, 12));
        this.JLProgamadas.setHorizontalAlignment(0);
        this.JLProgamadas.setText("0");
        this.JLOportunidad.setFont(new Font("Arial", 1, 12));
        this.JLOportunidad.setHorizontalAlignment(0);
        this.JLOportunidad.setText("0");
        GroupLayout JPI_ConsolidadoLayout = new GroupLayout(this.JPI_Consolidado);
        this.JPI_Consolidado.setLayout(JPI_ConsolidadoLayout);
        JPI_ConsolidadoLayout.setHorizontalGroup(JPI_ConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsolidadoLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLPromedioCancelada, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLProgamadas, -2, 70, -2).addGap(35, 35, 35).addComponent(this.jLabel3, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLOportunidad, -2, 70, -2).addContainerGap(658, 32767)));
        JPI_ConsolidadoLayout.setVerticalGroup(JPI_ConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 39, -2).addComponent(this.jLabel2, -2, 39, -2).addComponent(this.JLPromedioCancelada, -2, 39, -2).addComponent(this.JLProgamadas, -2, 39, -2).addComponent(this.jLabel3, -2, 39, -2).addComponent(this.JLOportunidad, -2, 39, -2)).addContainerGap(14, 32767)));
        this.JTB_DatosUtilidades.addTab("CONSOLIDADO", this.JPI_Consolidado);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.cirugia.JIFInformeCirugia.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformeCirugia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIFInformeCirugia.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformeCirugia.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JTFRuta, -2, 580, -2).addGap(63, 63, 63).addComponent(this.JBTExportar, -2, 137, -2).addContainerGap(528, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 9, 32767)));
        this.JTB_DatosUtilidades.addTab("UTILIDADES", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JTB_DatosUtilidades, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTB_DatosUtilidades, -2, 105, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinalPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicialPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDatos.getRowCount() != -1) {
            this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDatos, this.metodo.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + "Listado De Cirugias");
        }
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

    private void crearModelo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Departamento", "CodDepartamento", "Municipio", "CodMunicipio", "TipoDoc", "NumeroDoc", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNacimiento", "Sexo", "Direccion", "Movil", "FechaSolicitud", "FechaCX", "CodigoCups", "Procedimiento", "Especialidad", "NombreProfesional", "NombreConvenio", "NombreEntidad", "Cancelacion", "MotivoAnulacion", "DiasDiferencia"}) { // from class: com.genoma.plus.controller.cirugia.JIFInformeCirugia.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDatos.setModel(this.modelo);
        JTable jTable = this.JTDatos;
        JTable jTable2 = this.JTDatos;
        jTable.setAutoResizeMode(0);
        this.JTDatos.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDatos.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDatos.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDatos.getColumnModel().getColumn(17).setPreferredWidth(250);
        this.JTDatos.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDatos.getColumnModel().getColumn(19).setPreferredWidth(250);
        this.JTDatos.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDatos.getColumnModel().getColumn(21).setPreferredWidth(250);
        this.JTDatos.getColumnModel().getColumn(22).setPreferredWidth(250);
        this.JTDatos.getColumnModel().getColumn(23).setPreferredWidth(250);
        this.JTDatos.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.metodo.mEstablecerTextEditor(this.JTDatos, 17);
        this.metodo.mEstablecerTextEditor(this.JTDatos, 21);
        this.metodo.mEstablecerTextEditor(this.JTDatos, 20);
        this.metodo.mEstablecerTextEditor(this.JTDatos, 19);
    }

    public void cargarDatos() {
        System.out.println("pruebaaaaaaa");
        crearModelo();
        System.out.println(" fecha inicio " + this.metodo.formatoAMD1.format(this.JDCFechaInicial.getDate()).concat(" ").concat(this.metodo.formatoAMD1.format(this.JDCFechaFinal.getDate())));
        List<InformeCirugia> listaInformeCirugia = this.informeCirugia.listaInformeCirugia(this.metodo.formatoAMD1.format(this.JDCFechaInicial.getDate()), this.metodo.formatoAMD1.format(this.JDCFechaFinal.getDate()));
        Integer canceladas = 0;
        Integer realizada = 0;
        Integer cantidadDeTiempo = 0;
        int x = 0;
        for (InformeCirugia listaInformeCirugia1 : listaInformeCirugia) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(listaInformeCirugia1.getDepartamento(), x, 0);
            this.modelo.setValueAt(listaInformeCirugia1.getCodigoDepartamento(), x, 1);
            this.modelo.setValueAt(listaInformeCirugia1.getMunicipio(), x, 2);
            this.modelo.setValueAt(listaInformeCirugia1.getCodigoMunicipio(), x, 3);
            this.modelo.setValueAt(listaInformeCirugia1.getTipoDocumento(), x, 4);
            this.modelo.setValueAt(listaInformeCirugia1.getNumeroDocumento(), x, 5);
            this.modelo.setValueAt(listaInformeCirugia1.getApellido1(), x, 6);
            this.modelo.setValueAt(listaInformeCirugia1.getApellido2(), x, 7);
            this.modelo.setValueAt(listaInformeCirugia1.getNombre1(), x, 8);
            this.modelo.setValueAt(listaInformeCirugia1.getNombre2(), x, 9);
            this.modelo.setValueAt(listaInformeCirugia1.getFechaNacimiento(), x, 10);
            this.modelo.setValueAt(listaInformeCirugia1.getIdSexo(), x, 11);
            this.modelo.setValueAt(listaInformeCirugia1.getDireccion(), x, 12);
            this.modelo.setValueAt(listaInformeCirugia1.getMovil(), x, 13);
            this.modelo.setValueAt(listaInformeCirugia1.getFechaSolicitud(), x, 14);
            this.modelo.setValueAt(listaInformeCirugia1.getFechaCx(), x, 15);
            this.modelo.setValueAt(listaInformeCirugia1.getCodigoCups(), x, 16);
            this.modelo.setValueAt(listaInformeCirugia1.getProcedimiento(), x, 17);
            this.modelo.setValueAt(listaInformeCirugia1.getEspecialidad(), x, 18);
            this.modelo.setValueAt(listaInformeCirugia1.getNombreProfesional(), x, 19);
            this.modelo.setValueAt(listaInformeCirugia1.getNombreConvenio(), x, 20);
            this.modelo.setValueAt(listaInformeCirugia1.getNombreEntidad(), x, 21);
            this.modelo.setValueAt(listaInformeCirugia1.getCancelacion(), x, 22);
            this.modelo.setValueAt(listaInformeCirugia1.getMotivoAnulacion(), x, 23);
            this.modelo.setValueAt(listaInformeCirugia1.getDiasDiferencia(), x, 24);
            System.out.println(" " + listaInformeCirugia1.getCancelacion());
            if (listaInformeCirugia1.getCancelacion().equals("SI")) {
                canceladas = Integer.valueOf(canceladas.intValue() + 1);
            }
            if (listaInformeCirugia1.getRealizada().equals("SI")) {
                realizada = Integer.valueOf(realizada.intValue() + 1);
            }
            cantidadDeTiempo = Integer.valueOf(cantidadDeTiempo.intValue() + listaInformeCirugia1.getDiasDiferencia().intValue());
            x++;
        }
        if (listaInformeCirugia.size() > 0) {
            System.out.println(" " + canceladas);
            this.JLPromedioCancelada.setText("" + ((canceladas.intValue() * 100) / listaInformeCirugia.size()) + "%");
        }
        this.JLProgamadas.setText(" " + listaInformeCirugia.size());
        if (realizada.intValue() > 0) {
            this.JLOportunidad.setText("" + (cantidadDeTiempo.intValue() / realizada.intValue()));
        }
    }
}
