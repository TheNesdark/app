package com.genoma.plus.controller.sgc;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.MedicamentosEntregadosPorEPSDAO;
import com.genoma.plus.dto.sgc.MedicamentosEntregadosPorEPSDTO;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_MedicamentosEntregadosPorEPS.class */
public class JIF_MedicamentosEntregadosPorEPS extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private Object[] xDatoF;
    private List<Object[]> listConvenio;
    private String nombre;
    private MedicamentosEntregadosPorEPSDAO xMedicamentosEntregadosPorEPSDAO;
    private MedicamentosEntregadosPorEPSDTO dto;
    private String[] idempresa;
    private JButton JBTExportar;
    private JComboBox<String> JCBIps;
    private JCheckBox JCHFiltroIPS;
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
    private boolean xlleno = false;

    public JIF_MedicamentosEntregadosPorEPS() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xMedicamentosEntregadosPorEPSDAO = (MedicamentosEntregadosPorEPSDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("medicamentosEntregadosPorEPSDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JLBLCont.setText("0");
    }

    private void mllenarCombo() {
        this.xlleno = false;
        this.JCBIps.removeAllItems();
        List<Object[]> list1 = this.xMedicamentosEntregadosPorEPSDAO.listarEPS(this.dto);
        this.idempresa = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.idempresa[x] = list1.get(x)[0].toString();
            this.JCBIps.addItem(list1.get(x)[1].toString());
        }
        this.JCBIps.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBIps.setSelectedIndex(-1);
        this.xlleno = true;
    }

    private void mCrearModeloTotalDiasHospitalizado() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Municipio", "TipoIdentificacion", "NoDocumento", "Apellido_1", "Apellido_2", "Nombre_1", "Nombre_2", "Edad", "Direccion", "Telefono", "Movil", "Empresa", "Diagnostico", "Programa", "Especialidad", "Fecha", "Nit", "Ips", "Medicamento", "Cantidad", "CodigoCUM", "TipoAtencion"}) { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
    }

    private void mCargarDatosTablaTotalDiasHospitalizado() {
        mCrearModeloTotalDiasHospitalizado();
        this.dto = new MedicamentosEntregadosPorEPSDTO();
        this.dto.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.dto.setFechaFin(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        if (this.JCHFiltroIPS.isSelected() && this.JCBIps.getSelectedIndex() != -1) {
            this.dto.setIdIPS(Long.valueOf(this.idempresa[this.JCBIps.getSelectedIndex()]).longValue());
        } else {
            this.dto.setIdIPS(0L);
        }
        List<Object[]> list = this.xMedicamentosEntregadosPorEPSDAO.medicamentosEntregadosPorEPS(this.dto);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 22; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mBuscar() {
        mCargarDatosTablaTotalDiasHospitalizado();
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
        this.JCBIps = new JComboBox<>();
        this.JCHFiltroIPS = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("Medicamentos Entregados");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_MedicamentosEntregadosPorEPS");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(18, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(7, 32767)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.4
            public void mouseClicked(MouseEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.5
            public void actionPerformed(ActionEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.6
            public void actionPerformed(ActionEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 467, -2).addGap(0, 0, 0).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addContainerGap(16, 32767)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        this.JCBIps.setFont(new Font("Arial", 1, 12));
        this.JCBIps.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroIPS.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroIPS.setForeground(Color.blue);
        this.JCHFiltroIPS.setText("Filtro Entidad?");
        this.JCHFiltroIPS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS.7
            public void actionPerformed(ActionEvent evt) {
                JIF_MedicamentosEntregadosPorEPS.this.JCHFiltroIPSActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JCHFiltroIPS).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBIps, 0, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -2, 87, -2).addComponent(this.JPExportar, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBIps, -2, 50, -2).addComponent(this.JCHFiltroIPS)).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 405, -2).addContainerGap(-1, 32767)));
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
        if (this.xlleno) {
            mllenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mllenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroIPSActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroIPS.isSelected()) {
            mllenarCombo();
        } else {
            this.JCBIps.removeAllItems();
        }
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
