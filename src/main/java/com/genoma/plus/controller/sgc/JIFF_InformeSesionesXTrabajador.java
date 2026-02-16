package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SGC_InformeSesionesXTrabajadorDAOImpl;
import com.genoma.plus.dao.sgc.SGC_InformeSesionesXTrabajadorDAO;
import com.genoma.plus.dto.sgc.SGC_InformeSesionesXTrabajadorDTO;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_InformeSesionesXTrabajador.class */
public class JIFF_InformeSesionesXTrabajador extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private SGC_InformeSesionesXTrabajadorDAO xSGC_InformeSesionesXTrabajadorDAO;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JButton jButton1;

    public JIFF_InformeSesionesXTrabajador() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSGC_InformeSesionesXTrabajadorDAO = (SGC_InformeSesionesXTrabajadorDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sGCInformeSesionesXTrabajadorDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloSesionesXTrabajador();
    }

    private void mCrearModeloSesionesXTrabajador() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id_Atención", "FechaHc", "Cie10", "Patología", "NoDocumento", "Persona", "Cant_Sesiones", "ClaseCita"}) { // from class: com.genoma.plus.controller.sgc.JIFF_InformeSesionesXTrabajador.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloSesionesXTrabajador();
        List<SGC_InformeSesionesXTrabajadorDTO> list = this.xSGC_InformeSesionesXTrabajadorDAO.cargarBusqueda(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getId_Atencion(), x, 0);
            this.xModelo.setValueAt(list.get(x).getFechaHc(), x, 1);
            this.xModelo.setValueAt(list.get(x).getCie10(), x, 2);
            this.xModelo.setValueAt(list.get(x).getPatologia(), x, 3);
            this.xModelo.setValueAt(list.get(x).getNoDocumento(), x, 4);
            this.xModelo.setValueAt(list.get(x).getPersona(), x, 5);
            this.xModelo.setValueAt(list.get(x).getCant_Sesiones(), x, 6);
            this.xModelo.setValueAt(list.get(x).getClaseCita(), x, 7);
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jButton1 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SESIONES X TRABAJADOR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiffSesionesXTrabajdor");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("jButton1");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformeSesionesXTrabajador.2
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformeSesionesXTrabajador.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2)).addGroup(JPDatosLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.jButton1))).addContainerGap(26, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_InformeSesionesXTrabajador.3
            public void mouseClicked(MouseEvent evt) {
                JIFF_InformeSesionesXTrabajador.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformeSesionesXTrabajador.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformeSesionesXTrabajador.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 462, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 225, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addGap(0, 45, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.JPDatos, -1, 119, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 479, -2)));
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
    public void jButton1ActionPerformed(ActionEvent evt) {
        mBuscar();
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
