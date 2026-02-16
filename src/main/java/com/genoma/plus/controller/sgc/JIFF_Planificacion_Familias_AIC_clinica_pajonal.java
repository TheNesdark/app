package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.Planificacion_Familias_AIC_clinica_pajonalDAO;
import com.genoma.plus.dto.sgc.Planificacion_Familias_AIC_clinica_pajonalDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_Planificacion_Familias_AIC_clinica_pajonal.class */
public class JIFF_Planificacion_Familias_AIC_clinica_pajonal extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private Planificacion_Familias_AIC_clinica_pajonalDAO xPlanificacion_Familias_AIC_clinica_pajonalDAO;
    private List<Object[]> listConvenio;
    private JButton JBTExportar;
    private JComboBox<String> JCBConvenio;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JRadioButton JRBConvenio;
    private JRadioButton JRBFecha;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private Planificacion_Familias_AIC_clinica_pajonalDTO planificacion_Familias_AIC_clinica_pajonalDTO = new Planificacion_Familias_AIC_clinica_pajonalDTO();

    public JIFF_Planificacion_Familias_AIC_clinica_pajonal() {
        initComponents();
        springStart();
        mNuevo();
        mCargarCombo();
    }

    private void springStart() {
        this.xPlanificacion_Familias_AIC_clinica_pajonalDAO = (Planificacion_Familias_AIC_clinica_pajonalDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("planificacion_Familias_AIC_clinica_pajonalDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloPlanificacion_Familias();
    }

    private void mCrearModeloPlanificacion_Familias() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha_Atencion", "NoDocumento", "Id_TipoIdentificacion", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "FechaNac", "Edad", "Id_Sexo", "municipio", "Barrio", "Direccion", "Zona", "Etnia", "NEducativo", "Estado Civil", "Telefono", "Movil", "FUMestruacion", "FUM", "No_G", "No_P", "No_C", "No_A", "No_V", "No_M", "FechaResultado", "resultado", "Peso", "Talla", "IMC", "TArtSentadoD", "TArtSentadoS", "Nbre", "Fentrega", "EPS", "clasesita"}) { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(250);
    }

    private void mCargarDatosTabla(Boolean bol) {
        mCrearModeloPlanificacion_Familias();
        List<Object[]> list = this.xPlanificacion_Familias_AIC_clinica_pajonalDAO.mBuscarPlanificacionFamiliar(this.planificacion_Familias_AIC_clinica_pajonalDTO, bol);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 38; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
    }

    public void mCargarCombo() {
        this.JCBConvenio.removeAllItems();
        this.listConvenio = this.xPlanificacion_Familias_AIC_clinica_pajonalDAO.mCargarCombo();
        for (int i = 0; i < this.listConvenio.size(); i++) {
            this.JCBConvenio.addItem(this.listConvenio.get(i)[1].toString());
        }
        this.JCBConvenio.setSelectedIndex(-1);
    }

    public void mBuscar() {
        this.planificacion_Familias_AIC_clinica_pajonalDTO = new Planificacion_Familias_AIC_clinica_pajonalDTO();
        if (this.JRBFecha.isSelected()) {
            this.planificacion_Familias_AIC_clinica_pajonalDTO.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.planificacion_Familias_AIC_clinica_pajonalDTO.setFechaFin(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarDatosTabla(true);
        } else if (this.JRBConvenio.isSelected() && this.JCBConvenio.getSelectedIndex() != -1) {
            for (int i = 0; i < this.listConvenio.size(); i++) {
                if (this.JCBConvenio.getSelectedItem().equals(this.listConvenio.get(i)[1].toString())) {
                    this.planificacion_Familias_AIC_clinica_pajonalDTO.setConvenio(this.listConvenio.get(i)[0].toString());
                }
            }
            mCargarDatosTabla(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.JRBFecha = new JRadioButton();
        this.JRBConvenio = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.JCBConvenio = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Planificacion Familias AIC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiff_planificacion_Familias_AIC_clinica_pajonal");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Opcion", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.buttonGroup1.add(this.JRBFecha);
        this.JRBFecha.setSelected(true);
        this.JRBFecha.setText("Por fecha");
        this.JRBFecha.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.2
            public void actionPerformed(ActionEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JRBFechaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBConvenio);
        this.JRBConvenio.setText("Por convenio");
        this.JRBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.3
            public void actionPerformed(ActionEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JRBConvenioActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JRBFecha).addGap(50, 50, 50).addComponent(this.JRBConvenio).addContainerGap(17, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFecha).addComponent(this.JRBConvenio)).addGap(0, 0, 32767)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.JCBConvenio.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.JCBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JCBConvenioActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, GroupLayout.Alignment.TRAILING, 0, -1, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, -2, 36, -2));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addGap(58, 58, 58)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.5
            public void mouseClicked(MouseEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.6
            public void actionPerformed(ActionEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal.7
            public void actionPerformed(ActionEvent evt) {
                JIFF_Planificacion_Familias_AIC_clinica_pajonal.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGap(154, 154, 154).addComponent(this.JTFRuta, -2, 734, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(194, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, 1243, 32767).addComponent(this.JSPDetalle, -2, 0, 32767).addComponent(this.JPExportar, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 436, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addContainerGap()));
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
    public void JRBConvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
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
