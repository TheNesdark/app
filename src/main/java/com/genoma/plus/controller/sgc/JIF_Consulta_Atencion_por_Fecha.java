package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.ConsultaAtencionPorFecha;
import com.genoma.plus.jpa.service.ConsultarAtencionPorFechaService;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consulta_Atencion_por_Fecha.class */
public class JIF_Consulta_Atencion_por_Fecha extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
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
    private final ConsultarAtencionPorFechaService xConsultarAtencionPorFechaService = (ConsultarAtencionPorFechaService) Principal.contexto.getBean(ConsultarAtencionPorFechaService.class);

    public JIF_Consulta_Atencion_por_Fecha() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JLBLCont.setText("0");
    }

    private void mCrearModeloInformeDiagnostico() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaIngreso", "tipoAtencin", "empresaConvenio", "Id_TipoIdentificacion", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Id_Sexo", "FechaNac", "municipio", "barrio", "Direccion", "Telefono", "Movil", "Correo", "claseCita", "Motivo_Atencion", "EActual", "Codigo_Dxp", "Id_TipoDx", "Codigo_DxR1", "Codigo_DxR2", "Codigo_DxR3", "especialdiad", "profesional"}) { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
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
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
    }

    private void mCargarDatosTablaInformeDiagnostico() {
        mCrearModeloInformeDiagnostico();
        List<ConsultaAtencionPorFecha> list = this.xConsultarAtencionPorFechaService.ConsultarAtencionPorFecha(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getId(), x, 0);
            this.xModelo.setValueAt(list.get(x).getFechaIngreso(), x, 1);
            this.xModelo.setValueAt(list.get(x).getTipoAtencin(), x, 2);
            this.xModelo.setValueAt(list.get(x).getEmpresaConvenio(), x, 3);
            this.xModelo.setValueAt(list.get(x).getId_TipoIdentificacion(), x, 4);
            this.xModelo.setValueAt(list.get(x).getNoDocumento(), x, 5);
            this.xModelo.setValueAt(list.get(x).getApellido1(), x, 6);
            this.xModelo.setValueAt(list.get(x).getApellido2(), x, 7);
            this.xModelo.setValueAt(list.get(x).getNombre1(), x, 8);
            this.xModelo.setValueAt(list.get(x).getNombre2(), x, 9);
            this.xModelo.setValueAt(list.get(x).getId_Sexo(), x, 10);
            this.xModelo.setValueAt(list.get(x).getFechaNac(), x, 11);
            this.xModelo.setValueAt(list.get(x).getMunicipio(), x, 12);
            this.xModelo.setValueAt(list.get(x).getBarrio(), x, 13);
            this.xModelo.setValueAt(list.get(x).getDireccion(), x, 14);
            this.xModelo.setValueAt(list.get(x).getTelefono(), x, 15);
            this.xModelo.setValueAt(list.get(x).getMovil(), x, 16);
            this.xModelo.setValueAt(list.get(x).getCorreo(), x, 17);
            this.xModelo.setValueAt(list.get(x).getClaseCita(), x, 18);
            this.xModelo.setValueAt(list.get(x).getMotivo_Atencion(), x, 19);
            this.xModelo.setValueAt(list.get(x).getEActual(), x, 20);
            this.xModelo.setValueAt(list.get(x).getCodigo_Dxp(), x, 21);
            this.xModelo.setValueAt(list.get(x).getId_TipoDx(), x, 22);
            this.xModelo.setValueAt(list.get(x).getCodigo_DxR1(), x, 23);
            this.xModelo.setValueAt(list.get(x).getCodigo_DxR2(), x, 24);
            this.xModelo.setValueAt(list.get(x).getCodigo_DxR3(), x, 25);
            this.xModelo.setValueAt(list.get(x).getEspecialdiad(), x, 26);
            this.xModelo.setValueAt(list.get(x).getProfesional(), x, 27);
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mBuscar() {
        mCargarDatosTablaInformeDiagnostico();
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
        setTitle("Consultar Atención Por Fecha");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_ConsultarAtencionPorFecha");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consulta_Atencion_por_Fecha.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consulta_Atencion_por_Fecha.this.JDFechaFPropertyChange(evt);
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Consulta_Atencion_por_Fecha.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Consulta_Atencion_por_Fecha.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Consulta_Atencion_por_Fecha.this.JBTExportarActionPerformed(evt);
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
