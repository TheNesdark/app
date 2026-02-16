package com.genoma.plus.controller.rrhh;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.rrhh.ConsolidadoConceptosDAOImpl;
import com.genoma.plus.dao.rrhh.ConsolidadoConceptosDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.rrhh.ConsolidadoConceptosDTO;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFConsolidadoConceptosRH.class */
public class JIFConsolidadoConceptosRH extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidnomina;
    private String xsql;
    private ConsolidadoConceptosDAO xConsolidadoConceptosDAO;
    private JButton JBTExportar;
    private JComboBox JCBNomina;
    private JPanel JPFiltroPro;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JYearChooser JYC_FAno;
    private Metodos xmt = new Metodos();
    private boolean xllenoc = false;

    public JIFConsolidadoConceptosRH() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConsolidadoConceptosDAO = (ConsolidadoConceptosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consolidadoConceptosDAO");
    }

    public void mNuevo() {
        mLLenarNomina();
        mCrearModeloTabla();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    public void mImprimir() {
        if (this.JCBNomina.getSelectedIndex() != -1) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id_Liquidacion";
            mparametros[0][1] = this.xidnomina[this.JCBNomina.getSelectedIndex()];
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "N_Consolidado_Concepto", mparametros);
        }
    }

    private void mLLenarNomina() {
        this.xllenoc = false;
        this.JCBNomina.removeAllItems();
        List<GCGenericoDTO> list1 = this.xConsolidadoConceptosDAO.listaNomina(String.valueOf(this.JYC_FAno.getValue()));
        this.xidnomina = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidnomina[x] = String.valueOf(list1.get(x).getId());
            this.JCBNomina.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBNomina.setSelectedIndex(-1);
        this.xllenoc = true;
    }

    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdLiquidacion", "Rubro", "IdConcepto", "Concepto", "Dev_Asistencial", "Dev_Administrativo", "Ded_Asistencial", "Ded_Administrativo", "VEmp_Asistencial", "VEmp_Administrativo", "Clasificacion", "Periodo"}) { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.1
            Class[] types = {Long.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
    }

    public void mCargarDatosTabla() {
        mCrearModeloTabla();
        List<ConsolidadoConceptosDTO> list = this.xConsolidadoConceptosDAO.list(this.xidnomina[this.JCBNomina.getSelectedIndex()]);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x).getIdLiquidacion(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getRubroPresupuestal(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdConceptos(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNConceptos(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getDevAsistencial(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getDevAdministrativo(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getDedAsistencial(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getDedAdministrativo(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getVEmpresaAsistencial(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getVEmpresaAdministrativo(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getNClasificacion(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getPeriodo(), x, 11);
        }
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPFiltroPro = new JPanel();
        this.JYC_FAno = new JYearChooser();
        this.JCBNomina = new JComboBox();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO POR CONCEPTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadoconceptosrh");
        this.JPFiltroPro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYC_FAno.setBorder(BorderFactory.createTitledBorder((Border) null, "AÑO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYC_FAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoConceptosRH.this.JYC_FAnoPropertyChange(evt);
            }
        });
        this.JCBNomina.setFont(new Font("Arial", 1, 12));
        this.JCBNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNomina.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsolidadoConceptosRH.this.JCBNominaItemStateChanged(evt);
            }
        });
        this.JCBNomina.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoConceptosRH.this.JCBNominaActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroProLayout = new GroupLayout(this.JPFiltroPro);
        this.JPFiltroPro.setLayout(JPFiltroProLayout);
        JPFiltroProLayout.setHorizontalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addContainerGap().addComponent(this.JYC_FAno, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBNomina, -2, 369, -2).addContainerGap(-1, 32767)));
        JPFiltroProLayout.setVerticalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYC_FAno, -2, 50, -2).addComponent(this.JCBNomina, -2, 50, -2)).addContainerGap()));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoConceptosRH.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoConceptosRH.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoConceptosRH.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltroPro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSDetalle, GroupLayout.Alignment.TRAILING, -1, 957, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 178, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltroPro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -1, 284, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYC_FAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarNomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNominaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc && this.JCBNomina.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
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
        if (this.JTDetalle.getRowCount() > -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNominaActionPerformed(ActionEvent evt) {
    }
}
