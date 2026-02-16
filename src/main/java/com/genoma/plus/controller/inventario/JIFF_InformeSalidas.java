package com.genoma.plus.controller.inventario;

import Utilidades.Metodos;
import com.genoma.plus.dao.inventario.InformeSalidasDAO;
import com.genoma.plus.dto.inventario.InformeSalidasDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFF_InformeSalidas.class */
public class JIFF_InformeSalidas extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private InformeSalidasDAO dao;
    private List<Object[]> listBodega;
    private String[][] parametros;
    private JButton JBTExportar;
    private JComboBox<String> JCBBodega;
    private JCheckBox JCBFiltroBodega;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JRadioButton JRBActivo;
    private JRadioButton JRBAnulado;
    private JScrollPane JSPDetalle;
    private JRadioButton JTBTodo;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private InformeSalidasDTO dto = new InformeSalidasDTO();
    private Boolean validaFechaI = false;
    private Boolean validaFechaF = false;

    public JIFF_InformeSalidas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.dao = (InformeSalidasDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeSalidasDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloEjecucionPresupuestal();
        mCargarCombo();
        this.JLBLCont.setText("0");
    }

    public void mBuscar() {
        this.dto = new InformeSalidasDTO();
        this.dto.setFechaI(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.dto.setFechaF(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.dto.setFiltroC("");
        if (this.JRBActivo.isSelected()) {
            this.dto.setEstado("0");
        } else if (this.JRBAnulado.isSelected()) {
            this.dto.setEstado("1");
        } else {
            this.dto.setEstado("");
        }
        if (this.JCBFiltroBodega.isSelected()) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                this.dto.setFiltroC(this.listBodega.get(this.JCBBodega.getSelectedIndex())[0].toString());
                mCargarDatosTablaEjecucionPresupuestal();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        mCargarDatosTablaEjecucionPresupuestal();
    }

    public void mCargarCombo() {
        this.listBodega = this.dao.mCargarCombo(this.dto);
        this.JCBBodega.removeAllItems();
        for (int i = 0; i < this.listBodega.size(); i++) {
            this.JCBBodega.addItem(this.listBodega.get(i)[1].toString());
        }
        this.JCBBodega.setSelectedIndex(-1);
    }

    private void mCrearModeloEjecucionPresupuestal() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "IdTipoMovimiento", "NMOvimiento", "FechaSalida", "destino", "idSUministro", "nombreSumistro", "laboratorio", "presentacionFarmaceutica", "presentacionComercial", "tipoProducto", "Lote", "FechaVencimiento", "CantidadSolicitada", "CantidadDespachada", "valorUnitario", "Observacion", "Id_DocContable", "OrdenH", "Id_Ingreso", "Estado"}) { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, String.class, Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
    }

    private void mCargarDatosTablaEjecucionPresupuestal() {
        mCrearModeloEjecucionPresupuestal();
        List<Object[]> list = this.dao.mCargarTabla(this.dto);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 20; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mImprimir() {
        if (this.JTDetalle.getSelectedRow() >= 0) {
            String bodega = "";
            if (this.JCBFiltroBodega.isSelected()) {
                bodega = this.JCBBodega.getSelectedItem().toString();
            }
            this.parametros = new String[5][2];
            this.parametros[0][0] = "IdSalida";
            this.parametros[0][1] = this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.parametros[1][0] = "BodegaOrigen";
            this.parametros[1][1] = bodega;
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_SalidasABodega", this.parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila de la tabla", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBBodega = new JComboBox<>();
        this.JCBFiltroBodega = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JRBActivo = new JRadioButton();
        this.JRBAnulado = new JRadioButton();
        this.JTBTodo = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("Informe de salida");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiff_InformeDeSalidas");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 14));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_InformeSalidas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 14));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_InformeSalidas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCBBodega.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformeSalidas.this.JCBBodegaActionPerformed(evt);
            }
        });
        this.JCBFiltroBodega.setText("Filtar por Bodega");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar por estado", 2, 0, new Font("Dialog", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRBActivo);
        this.JRBActivo.setSelected(true);
        this.JRBActivo.setText("Activo");
        this.buttonGroup1.add(this.JRBAnulado);
        this.JRBAnulado.setText("Anulado");
        this.buttonGroup1.add(this.JTBTodo);
        this.JTBTodo.setText("Todo");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBTodo).addComponent(this.JRBActivo).addComponent(this.JRBAnulado)).addGap(0, 41, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBActivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBAnulado)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, -2, 491, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFiltroBodega).addGap(16, 16, 16).addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBBodega, GroupLayout.Alignment.LEADING, -1, 56, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 0, 32767))).addContainerGap()).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBFiltroBodega).addContainerGap(-1, 32767)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.5
            public void mouseClicked(MouseEvent evt) {
                JIFF_InformeSalidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.6
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformeSalidas.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFF_InformeSalidas.7
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformeSalidas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 558, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JPDatos, -1, 1130, 32767).addComponent(this.JSPDetalle, -2, 0, 32767)).addGap(0, 0, 0)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 378, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
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
    public void JCBBodegaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.validaFechaF.booleanValue() && this.validaFechaI.booleanValue()) {
            System.out.println("Entro fechaF");
            this.dto = new InformeSalidasDTO();
            this.dto.setFechaI(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.dto.setFechaF(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarCombo();
            return;
        }
        this.validaFechaF = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.validaFechaF.booleanValue() && this.validaFechaI.booleanValue()) {
            System.out.println("Entro fechaI");
            this.dto = new InformeSalidasDTO();
            this.dto.setFechaI(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.dto.setFechaF(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarCombo();
            return;
        }
        this.validaFechaI = true;
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
