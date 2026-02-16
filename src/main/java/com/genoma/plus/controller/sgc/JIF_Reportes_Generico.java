package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.InformeCitologia;
import com.genoma.plus.jpa.service.ReporteGenericoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Reportes_Generico.class */
public class JIF_Reportes_Generico extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private String nombre;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private Boolean xy = false;
    private final ReporteGenericoService servicio = (ReporteGenericoService) Principal.contexto.getBean(ReporteGenericoService.class);

    public JIF_Reportes_Generico(String nombre) {
        initComponents();
        this.nombre = nombre;
        setTitle("Reporte " + nombre);
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JLBLCont.setText("0");
    }

    private void mCrearModeloCitologias() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id_TipoIdentificacion", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "Edad", "Etnia", "SI_VictimaConflictoArmado", "NO_VictimaConflictoArmado", "SI_PresentaDiscapacidad", "NO_PresentaDiscapacidad", "TipoDiscapacidad", "LGTB", "Municipio", "Barrio", "Direccion", "Telefono", "Movil", "InicioVidaSexual", "No_G", "No_P", "No_A", "No_C", "Histerectomia", "ActualmenteEmbarazada", "FechaToma", "Profesional", "Especialidad", "LaboratorioRemision", "FechaEnvioMuestra", "T_EntreTomaYEnvio", "FechaReciboResultado", "T_EntreEnvioYResultado", "FechaEntregaResultado", "T_EntreTomaYEntrega", "FechaProximaCitologia", "AlarmaProximaCita", "Dias", "NbreCalidadMuestra", "PresenCompZonaTransfor", "Conducta", "Categorizacion", "MICROORGANISMOS", "Resultado", "FechaProximaCita", "NecesitaRemision", "FechaRemision", "EspecialidadRemision", "VacunaVPH", "MuertePorCancer", "FechaMuerte"}) { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(150);
    }

    private void mCargarDatosTablaCitologias() {
        mCrearModeloCitologias();
        List<InformeCitologia> list = this.servicio.buscarCitologias(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getId_TipoIdentificacion(), x, 0);
            this.xModelo.setValueAt(list.get(x).getNoDocumento(), x, 1);
            this.xModelo.setValueAt(list.get(x).getApellido1(), x, 2);
            this.xModelo.setValueAt(list.get(x).getApellido2(), x, 3);
            this.xModelo.setValueAt(list.get(x).getNombre1(), x, 4);
            this.xModelo.setValueAt(list.get(x).getNombre2(), x, 5);
            this.xModelo.setValueAt(list.get(x).getFechaNac(), x, 6);
            this.xModelo.setValueAt(list.get(x).getEdad(), x, 7);
            this.xModelo.setValueAt(list.get(x).getEtnia(), x, 8);
            this.xModelo.setValueAt(list.get(x).getSi_VictimaConflictoArmado(), x, 9);
            this.xModelo.setValueAt(list.get(x).getNo_VictimaConflictoArmado(), x, 10);
            this.xModelo.setValueAt(list.get(x).getSi_PresentaDiscapacidad(), x, 11);
            this.xModelo.setValueAt(list.get(x).getNo_PresentaDiscapacidad(), x, 12);
            this.xModelo.setValueAt(list.get(x).getTipoDiscapacidad(), x, 13);
            this.xModelo.setValueAt(list.get(x).getLgtb(), x, 14);
            this.xModelo.setValueAt(list.get(x).getMunicipio(), x, 15);
            this.xModelo.setValueAt(list.get(x).getBarrio(), x, 16);
            this.xModelo.setValueAt(list.get(x).getDireccion(), x, 17);
            this.xModelo.setValueAt(list.get(x).getTelefono(), x, 18);
            this.xModelo.setValueAt(list.get(x).getMovil(), x, 19);
            this.xModelo.setValueAt(list.get(x).getInicioVidaSexual(), x, 20);
            this.xModelo.setValueAt(list.get(x).getNo_G(), x, 21);
            this.xModelo.setValueAt(list.get(x).getNo_P(), x, 22);
            this.xModelo.setValueAt(list.get(x).getNo_A(), x, 23);
            this.xModelo.setValueAt(list.get(x).getNo_C(), x, 24);
            this.xModelo.setValueAt(list.get(x).getHisterectomia(), x, 25);
            this.xModelo.setValueAt(list.get(x).getActualmenteEmbarazada(), x, 26);
            this.xModelo.setValueAt(list.get(x).getFechaToma(), x, 27);
            this.xModelo.setValueAt(list.get(x).getProfesional(), x, 28);
            this.xModelo.setValueAt(list.get(x).getEspecialidad(), x, 29);
            this.xModelo.setValueAt(list.get(x).getLaboratorioRemision(), x, 30);
            this.xModelo.setValueAt(list.get(x).getFechaEnvioMuestra(), x, 31);
            this.xModelo.setValueAt(list.get(x).getT_EntreTomaYEnvio(), x, 32);
            this.xModelo.setValueAt(list.get(x).getFechaReciboResultado(), x, 33);
            this.xModelo.setValueAt(list.get(x).getT_EntreEnvioYResultado(), x, 34);
            this.xModelo.setValueAt(list.get(x).getFechaEntregaResultado(), x, 35);
            this.xModelo.setValueAt(list.get(x).getT_EntreTomaYEntrega(), x, 36);
            this.xModelo.setValueAt(list.get(x).getFechaProximaCitologia(), x, 37);
            this.xModelo.setValueAt(list.get(x).getAlarmaProximaCita(), x, 38);
            this.xModelo.setValueAt(list.get(x).getDias(), x, 39);
            this.xModelo.setValueAt(list.get(x).getNbreCalidadMuestra(), x, 40);
            this.xModelo.setValueAt(list.get(x).getPresenCompZonaTransfor(), x, 41);
            this.xModelo.setValueAt(list.get(x).getConducta(), x, 42);
            this.xModelo.setValueAt(list.get(x).getCategorizacion(), x, 43);
            this.xModelo.setValueAt(list.get(x).getMicroorganismos(), x, 44);
            this.xModelo.setValueAt(list.get(x).getResultado(), x, 45);
            this.xModelo.setValueAt(list.get(x).getFechaProximaCita(), x, 46);
            this.xModelo.setValueAt(list.get(x).getNecesitaRemision(), x, 47);
            this.xModelo.setValueAt(list.get(x).getFechaRemision(), x, 48);
            this.xModelo.setValueAt(list.get(x).getEspecialidadRemision(), x, 49);
            this.xModelo.setValueAt(list.get(x).getVacunaVPH(), x, 50);
            this.xModelo.setValueAt(list.get(x).getMuertePorCancer(), x, 51);
            this.xModelo.setValueAt(list.get(x).getFechaMuerte(), x, 52);
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mBuscar() {
        if (this.nombre.equals("Citologias")) {
            mCargarDatosTablaCitologias();
        }
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("Reporte");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_ReportesGenerico");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Reportes_Generico.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Reportes_Generico.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Reportes_Generico.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Reportes_Generico.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_Generico.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Reportes_Generico.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 467, -2).addGap(0, 0, 0).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addContainerGap(16, 32767)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -2, 87, -2).addComponent(this.JPExportar, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 472, -2).addContainerGap(-1, 32767)));
        getAccessibleContext().setAccessibleName("Reporte");
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }
}
