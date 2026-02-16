package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Laboratorio.crear_ArchivosPlanos;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFExportacionResultadosInstitucional.class */
public class JIFExportacionResultadosInstitucional extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private LaboratorioDAO xLaboratorioDAO;
    private String[] idEmpresa;
    private File xfile;
    private JButton JBTExportar;
    private JComboBox<String> JCBTercero;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetaller;
    private JTable JTDetalle;
    private JTextField JTFFiltro;
    private JTextField JTFRuta;

    public JIFExportacionResultadosInstitucional() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xLaboratorioDAO = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        llenarCombo();
    }

    private void llenarCombo() {
        this.JCBTercero.removeAllItems();
        List<GCGenericoDTO> list1 = this.xLaboratorioDAO.listaEmpresaExporactionHomologada();
        this.idEmpresa = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.idEmpresa[x] = String.valueOf(list1.get(x).getId());
            this.JCBTercero.addItem(list1.get(x).getNombre());
        }
        this.JCBTercero.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTercero.setSelectedIndex(-1);
    }

    public void mBuscar() {
        if (this.JCBTercero.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "FechaSolicitud", "NumSolicitud", "ccpaciente", "nombrepaciente", "codigoprocedimiento", "CodigoParametro", "nombreprocedimiento", "nombreparametro", "resultado", "fecha", "valor1", "valor2", "Orden", "IdPersona", "LoteProcedimiento"}) { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.1
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xLaboratorioDAO.listaResultadosExportacionInstitucional(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.idEmpresa[this.JCBTercero.getSelectedIndex()], this.JTFFiltro.getText());
        mCrearModeloDatos();
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(false, x, 0);
                this.xmodelo.setValueAt(list.get(x)[0], x, 1);
                this.xmodelo.setValueAt(list.get(x)[1], x, 2);
                this.xmodelo.setValueAt(list.get(x)[2], x, 3);
                this.xmodelo.setValueAt(list.get(x)[3], x, 4);
                this.xmodelo.setValueAt(list.get(x)[4], x, 5);
                this.xmodelo.setValueAt(list.get(x)[5], x, 6);
                this.xmodelo.setValueAt(list.get(x)[6], x, 7);
                this.xmodelo.setValueAt(list.get(x)[7], x, 8);
                this.xmodelo.setValueAt(list.get(x)[8], x, 9);
                this.xmodelo.setValueAt(list.get(x)[9], x, 10);
                this.xmodelo.setValueAt(list.get(x)[10], x, 11);
                this.xmodelo.setValueAt(list.get(x)[11], x, 12);
                this.xmodelo.setValueAt(list.get(x)[12], x, 13);
                this.xmodelo.setValueAt(list.get(x)[13], x, 14);
                this.xmodelo.setValueAt(list.get(x)[14], x, 15);
            }
        }
    }

    private void mGenerarArchivoPlano() {
        try {
            String sFichero = this.JTFRuta.getText() + "Genoma_" + this.xmt.formatoDMAH24_Unida.format(this.xmt.getFechaActual()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("FechaSolicitud|NumSolicitud|ccpaciente|nombrepaciente|codigoprocedimiento|CodigoParametro|nombreprocedimiento|nombreparametro|resultado|fecha|valor1|valor2|Orden");
            bw.newLine();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 0).toString()).booleanValue()) {
                    bw.write(this.xmodelo.getValueAt(i, 1).toString().trim() + "|" + this.xmodelo.getValueAt(i, 2).toString().trim() + "|" + this.xmodelo.getValueAt(i, 3).toString().trim() + "|" + this.xmodelo.getValueAt(i, 4).toString().trim() + "|" + this.xmodelo.getValueAt(i, 5).toString().trim() + "|" + this.xmodelo.getValueAt(i, 6).toString().trim() + "|" + this.xmodelo.getValueAt(i, 7).toString().trim() + "|" + this.xmodelo.getValueAt(i, 8).toString().trim() + "|" + this.xmodelo.getValueAt(i, 9).toString().trim() + "|" + this.xmodelo.getValueAt(i, 10).toString().trim() + "|" + this.xmodelo.getValueAt(i, 11).toString() + "|" + this.xmodelo.getValueAt(i, 12).toString() + "|" + this.xmodelo.getValueAt(i, 13).toString().trim());
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(crear_ArchivosPlanos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarLotePDF() {
        String adjunto;
        File f1;
        String x = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        File directorio = new File(this.JTFRuta.getText() + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 0).toString().equals("true") && !this.xmt.mExisteArchivo(directorio + this.xmt.getBarra() + this.xmodelo.getValueAt(i, 13).toString() + "-" + this.xmodelo.getValueAt(i, 15).toString() + ".pdf")) {
                    ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                    new File("");
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(i, 2).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xmodelo.getValueAt(i, 14).toString(), false);
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 13).toString() + "-" + this.xmodelo.getValueAt(i, 15).toString() + ".pdf";
                        f1 = new File(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf");
                    } else {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(i, 2).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xmodelo.getValueAt(i, 14).toString(), false);
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 13).toString() + "-" + this.xmodelo.getValueAt(i, 15).toString() + ".pdf";
                        f1 = new File(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf");
                    }
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(directorio, f2.getName()));
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetaller = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTercero = new JComboBox<>();
        this.JTFFiltro = new JTextField();
        this.JCHSeleccionar = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXPORTACION DE RESULTADOS INSTITUCIONAL ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifexportacionresultadosinstitucional");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.2
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionResultadosInstitucional.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.3
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionResultadosInstitucional.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.4
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionResultadosInstitucional.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JSPDetaller.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetaller.setViewportView(this.JTDetalle);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero a Homologar Resultados", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.setFont(new Font("Arial", 1, 12));
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar Documento / Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.5
            public void keyPressed(KeyEvent evt) {
                JIFExportacionResultadosInstitucional.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFiltro, -1, 411, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero).addComponent(this.JTFFiltro)).addComponent(this.JDFechaI, -1, 50, 32767).addComponent(this.JDFechaF, -1, 50, 32767)).addContainerGap(-1, 32767)));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional.6
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionResultadosInstitucional.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetaller).addGroup(layout.createSequentialGroup().addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 191, -2)).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetaller, -2, 280, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta).addComponent(this.JCHSeleccionar)).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
            mGenerarArchivoPlano();
            mGenerarLotePDF();
            JOptionPane.showInternalMessageDialog(this, "El proceso de generacion del archivo de exportacion ha finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar recepcioón a generar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xmodelo.setValueAt(Boolean.valueOf(this.JCHSeleccionar.isSelected()), i, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyPressed(KeyEvent evt) {
        mBuscar();
    }
}
