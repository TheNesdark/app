package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.CensoHospitalizacionDAOImpl;
import com.genoma.plus.dao.sig.CensoHospitalizacionDAO;
import com.genoma.plus.dto.sig.CensoHospitalizacionDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
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
import java.util.Date;
import java.util.List;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/CensoHospitalizacion.class */
public class CensoHospitalizacion extends JInternalFrame {
    private DefaultTableModel xModelo;
    private CensoHospitalizacionDAO xCensoHospitalizacionDAO;
    private Object[] xDato;
    private String[] xComboEmpresa;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public CensoHospitalizacion() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xCensoHospitalizacionDAO = (CensoHospitalizacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("censoHospitalizacionDAO");
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mLlenarComboEmpresa() {
        this.xlleno = false;
        this.JCBEmpresa.removeAllItems();
        List<GenericoComboDTO> list = this.xCensoHospitalizacionDAO.cargarCombo(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xComboEmpresa = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xComboEmpresa[x] = String.valueOf(list.get(x).getId());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xlleno = true;
    }

    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FechaIngreso", "HoraIngreso", "Documento", "NUsuario", "Id_Sexo", "Edad", "Codigo_Dxp", "NPatologia", "Codigo_DxR1", "NPatologiaR1", "Especialidad", "NProfesional", "nEmpresaConvenio", "Tipo Atención", "Fecha_Egreso", "Hora_Egreso", "#", "nombreIps", "tipoDocumento", "numeroDocumento", "fechaNacimiento", "primerApellido", "segundoApellido", "primerNombre", "segundoNombre", "edad", "sexo", "escolaridad", "municipioResidencia", "regional", "nombreRegimen", "telefono", "celular", "Codigo_Dxp", "NPatologia", "FechaIngreso", "diasEstancia"}) { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.1
            Class[] types = {Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Date.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModelo();
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                List<CensoHospitalizacionDTO> list = this.xCensoHospitalizacionDAO.cargarBusquedaConvenio(Integer.parseInt(this.xComboEmpresa[this.JCBEmpresa.getSelectedIndex()]), this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                for (int x = 0; x < list.size(); x++) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(list.get(x).getFechaIngreso(), x, 0);
                    this.xModelo.setValueAt(list.get(x).getHoraIngreso(), x, 1);
                    this.xModelo.setValueAt(list.get(x).getDocumento(), x, 2);
                    this.xModelo.setValueAt(list.get(x).getNUsuario(), x, 3);
                    this.xModelo.setValueAt(list.get(x).getId_Sexo(), x, 4);
                    this.xModelo.setValueAt(list.get(x).getEdad(), x, 5);
                    this.xModelo.setValueAt(list.get(x).getCodigo_Dxp(), x, 6);
                    this.xModelo.setValueAt(list.get(x).getNPatologia(), x, 7);
                    this.xModelo.setValueAt(list.get(x).getCodigoDxRelacionado1(), x, 8);
                    this.xModelo.setValueAt(list.get(x).getNombreDxRelacionado1(), x, 9);
                    this.xModelo.setValueAt(list.get(x).getEspecialidad(), x, 10);
                    this.xModelo.setValueAt(list.get(x).getNProfesional(), x, 11);
                    this.xModelo.setValueAt(list.get(x).getNEmpresaConvenio(), x, 12);
                    this.xModelo.setValueAt(list.get(x).getTipoAtencion(), x, 13);
                    this.xModelo.setValueAt(list.get(x).getFecha_Egreso(), x, 14);
                    this.xModelo.setValueAt(list.get(x).getHora_Egreso(), x, 15);
                    this.xModelo.setValueAt(Integer.valueOf(x + 1), x, 16);
                    this.xModelo.setValueAt(list.get(x).getNombreIps(), x, 17);
                    this.xModelo.setValueAt(list.get(x).getTipoDocumento(), x, 18);
                    this.xModelo.setValueAt(list.get(x).getNumeroDocumento(), x, 19);
                    this.xModelo.setValueAt(list.get(x).getFechaNacimiento(), x, 20);
                    this.xModelo.setValueAt(list.get(x).getPrimerApellido(), x, 21);
                    this.xModelo.setValueAt(list.get(x).getSegundoApellido(), x, 22);
                    this.xModelo.setValueAt(list.get(x).getPrimerNombre(), x, 23);
                    this.xModelo.setValueAt(list.get(x).getSegundoNombre(), x, 24);
                    this.xModelo.setValueAt(list.get(x).getEdadNumerica(), x, 25);
                    this.xModelo.setValueAt(list.get(x).getSexo(), x, 26);
                    this.xModelo.setValueAt(list.get(x).getEscolaridad(), x, 27);
                    this.xModelo.setValueAt(list.get(x).getMunicipioResidencia(), x, 28);
                    this.xModelo.setValueAt(list.get(x).getRegional(), x, 29);
                    this.xModelo.setValueAt(list.get(x).getNombreRegimen(), x, 30);
                    this.xModelo.setValueAt(list.get(x).getTelefono(), x, 31);
                    this.xModelo.setValueAt(list.get(x).getCelular(), x, 32);
                    this.xModelo.setValueAt(list.get(x).getCodigo_Dxp(), x, 33);
                    this.xModelo.setValueAt(list.get(x).getNPatologia(), x, 34);
                    this.xModelo.setValueAt(list.get(x).getFechaIngreso(), x, 35);
                    this.xModelo.setValueAt(list.get(x).getDiasEstancia(), x, 36);
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar empresa", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        List<CensoHospitalizacionDTO> list2 = this.xCensoHospitalizacionDAO.cargarBusqueda(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list2.get(x2).getFechaIngreso(), x2, 0);
            this.xModelo.setValueAt(list2.get(x2).getHoraIngreso(), x2, 1);
            this.xModelo.setValueAt(list2.get(x2).getDocumento(), x2, 2);
            this.xModelo.setValueAt(list2.get(x2).getNUsuario(), x2, 3);
            this.xModelo.setValueAt(list2.get(x2).getId_Sexo(), x2, 4);
            this.xModelo.setValueAt(list2.get(x2).getEdad(), x2, 5);
            this.xModelo.setValueAt(list2.get(x2).getCodigo_Dxp(), x2, 6);
            this.xModelo.setValueAt(list2.get(x2).getNPatologia(), x2, 7);
            this.xModelo.setValueAt(list2.get(x2).getCodigoDxRelacionado1(), x2, 8);
            this.xModelo.setValueAt(list2.get(x2).getNombreDxRelacionado1(), x2, 9);
            this.xModelo.setValueAt(list2.get(x2).getEspecialidad(), x2, 10);
            this.xModelo.setValueAt(list2.get(x2).getNProfesional(), x2, 11);
            this.xModelo.setValueAt(list2.get(x2).getNEmpresaConvenio(), x2, 12);
            this.xModelo.setValueAt(list2.get(x2).getTipoAtencion(), x2, 13);
            this.xModelo.setValueAt(list2.get(x2).getFecha_Egreso(), x2, 14);
            this.xModelo.setValueAt(list2.get(x2).getHora_Egreso(), x2, 15);
            this.xModelo.setValueAt(Integer.valueOf(x2 + 1), x2, 16);
            this.xModelo.setValueAt(list2.get(x2).getNombreIps(), x2, 17);
            this.xModelo.setValueAt(list2.get(x2).getTipoDocumento(), x2, 18);
            this.xModelo.setValueAt(list2.get(x2).getNumeroDocumento(), x2, 19);
            this.xModelo.setValueAt(list2.get(x2).getFechaNacimiento(), x2, 20);
            this.xModelo.setValueAt(list2.get(x2).getPrimerApellido(), x2, 21);
            this.xModelo.setValueAt(list2.get(x2).getSegundoApellido(), x2, 22);
            this.xModelo.setValueAt(list2.get(x2).getPrimerNombre(), x2, 23);
            this.xModelo.setValueAt(list2.get(x2).getSegundoNombre(), x2, 24);
            this.xModelo.setValueAt(list2.get(x2).getEdadNumerica(), x2, 25);
            this.xModelo.setValueAt(list2.get(x2).getSexo(), x2, 26);
            this.xModelo.setValueAt(list2.get(x2).getEscolaridad(), x2, 27);
            this.xModelo.setValueAt(list2.get(x2).getMunicipioResidencia(), x2, 28);
            this.xModelo.setValueAt(list2.get(x2).getRegional(), x2, 29);
            this.xModelo.setValueAt(list2.get(x2).getNombreRegimen(), x2, 30);
            this.xModelo.setValueAt(list2.get(x2).getTelefono(), x2, 31);
            this.xModelo.setValueAt(list2.get(x2).getCelular(), x2, 32);
            this.xModelo.setValueAt(list2.get(x2).getCodigo_Dxp(), x2, 33);
            this.xModelo.setValueAt(list2.get(x2).getNPatologia(), x2, 34);
            this.xModelo.setValueAt(list2.get(x2).getFechaIngreso(), x2, 35);
            this.xModelo.setValueAt(list2.get(x2).getDiasEstancia(), x2, 36);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModelo();
        mLlenarComboEmpresa();
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

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CENSO HOSPITALIZACIÓN");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Censo Hospitalización");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CensoHospitalizacion.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CensoHospitalizacion.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Aplicar Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.4
            public void actionPerformed(ActionEvent evt) {
                CensoHospitalizacion.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, 0, 595, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(61, 61, 61)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 55, -2).addComponent(this.JDFechaF, -2, 55, -2)).addComponent(this.JCBEmpresa, -2, 58, -2).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHFiltro))).addContainerGap(-1, 32767)));
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.5
            public void mouseClicked(MouseEvent evt) {
                CensoHospitalizacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.CensoHospitalizacion.6
            public void actionPerformed(ActionEvent evt) {
                CensoHospitalizacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 225, -2).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, -1, 32767).addGroup(JPExportarLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFRuta, -1, 58, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPDatos, -2, 1062, -2).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 0, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 394, 32767).addGap(18, 18, 18).addComponent(this.JPExportar, -2, -1, -2).addContainerGap()));
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
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }
}
