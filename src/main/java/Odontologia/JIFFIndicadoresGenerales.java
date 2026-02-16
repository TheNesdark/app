package Odontologia;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.Generico1Combo1CheckDAO;
import com.genoma.plus.dao.impl.general.Generico1Combo1CheckDAOImpl;
import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.CantidadCitasOdontDTO;
import com.genoma.plus.dto.sgc.CantidadProcedimientosOdontDTO;
import com.genoma.plus.dto.sgc.InasistenciaOdontDTO;
import com.genoma.plus.dto.sgc.ProcedimientosPacienteOdontDTO;
import com.genoma.plus.dto.sgc.RegistroDiarioOdontologiaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.lang.reflect.Field;
import java.util.ArrayList;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JIFFIndicadoresGenerales.class */
public class JIFFIndicadoresGenerales extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private InformesSgcDAO xInformesSgcDAO;
    private Generico1Combo1CheckDAO xGenerico1Combo1CheckDAO;
    private String[] xidGenerico;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodelo4;
    private DefaultTableModel xmodelo5;
    private List<RegistroDiarioOdontologiaDTO> listRegistroDiarioOdontologiaDTO;
    private List<CantidadProcedimientosOdontDTO> listCantidadProcedimientosOdontDTO;
    private List<ProcedimientosPacienteOdontDTO> listProcedimientosPacienteOdontDTO;
    private List<CantidadCitasOdontDTO> listCantidadCitasOdontDTO;
    private List<InasistenciaOdontDTO> listInasistenciaOdontDTO;
    private JButton JBTExportar;
    private JComboBox JCBProfesional;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JTable JTCantCitas;
    private JTable JTCantProcedimientos;
    private JTextField JTFRuta;
    private JTable JTInasistencia;
    private JTable JTProcedimientoPaciente;
    private JTable JTRegistroActividades;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTabbedPane jTabbedPane1;

    public JIFFIndicadoresGenerales() {
        initComponents();
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        springStart();
        mIniciaCombo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xInformesSgcDAO = (InformesSgcDAOImpl) classPathXmlApplicationContext.getBean("informesSgcDAO");
        this.xGenerico1Combo1CheckDAO = (Generico1Combo1CheckDAOImpl) classPathXmlApplicationContext.getBean("generico1Combo1CheckDAO");
    }

    private void mIniciaCombo() {
        List<GCGenericoDTO> list1 = this.xGenerico1Combo1CheckDAO.listComboGenerico("select g_profesional.Id_Persona as Id, \nconcat(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ', g_persona.Nombre2) Nbre\nfrom g_profesional\ninner join g_profesionalespecial on (g_profesional.Id_Persona=g_profesionalespecial.Id_Profesional)\ninner join g_persona on (g_profesional.Id_Persona=g_persona.Id)\nwhere g_profesionalespecial.Id_Especialidad in (461,1032,1023,1024,1035,250)");
        this.xidGenerico = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidGenerico[x] = String.valueOf(list1.get(x).getId());
            this.JCBProfesional.addItem(list1.get(x).getNombre());
        }
        this.JCBProfesional.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProfesional.setSelectedIndex(-1);
    }

    public void buscarDatos() {
        System.out.println("busca datos....");
        this.listRegistroDiarioOdontologiaDTO = new ArrayList();
        this.listRegistroDiarioOdontologiaDTO = this.xInformesSgcDAO.getRegistroDiarioOdontologia(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xidGenerico[this.JCBProfesional.getSelectedIndex()]));
        RegistroDiarioOdontologiaDTO rdo = new RegistroDiarioOdontologiaDTO();
        String[] header = new String[rdo.getClass().getFields().length];
        int i = 0;
        for (Field f : rdo.getClass().getFields()) {
            header[i] = f.getName();
            i++;
        }
        this.xmodelo1 = new DefaultTableModel(0, 0);
        this.JTRegistroActividades.setModel(this.xmodelo1);
        this.JTRegistroActividades.setAutoResizeMode(0);
        List<Object[]> rows = new ArrayList<>();
        for (RegistroDiarioOdontologiaDTO rd : this.listRegistroDiarioOdontologiaDTO) {
            System.out.println("rd-->" + rd.getCodCita());
            Object[] data = {rd.getCodCita(), rd.getFecha_Cita(), rd.getTipoIdentificacion(), rd.getNoDocumento(), rd.getPaciente(), rd.getSexo(), rd.getFechaNac(), rd.getEdad(), rd.getClasificacionCita(), rd.getTipoCita(), rd.getEps(), rd.getCodigoTratamiento(), rd.getFechaInicioTratamiento(), rd.getFechaFinalTratamiento(), rd.getEstadoTratamiento(), rd.getCodigoIngreso(), rd.getProfesional(), rd.getCodigo_Dxp(), rd.getCodigo_DxR1(), rd.getCodigo_DxR2(), rd.getCodigo_DxR3()};
            rows.add(data);
        }
        populatetable(this.JTRegistroActividades, header, rows);
        this.listCantidadProcedimientosOdontDTO = new ArrayList();
        this.listCantidadProcedimientosOdontDTO = this.xInformesSgcDAO.getCantidadProcedimientosOdont(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xidGenerico[this.JCBProfesional.getSelectedIndex()]));
        CantidadProcedimientosOdontDTO cp = new CantidadProcedimientosOdontDTO();
        String[] header2 = new String[cp.getClass().getFields().length];
        int x = 0;
        for (Field f2 : cp.getClass().getFields()) {
            header2[x] = f2.getName();
            x++;
        }
        this.xmodelo2 = new DefaultTableModel(0, 0);
        this.JTCantProcedimientos.setModel(this.xmodelo2);
        this.JTCantProcedimientos.setAutoResizeMode(0);
        List<Object[]> rows2 = new ArrayList<>();
        for (CantidadProcedimientosOdontDTO rd2 : this.listCantidadProcedimientosOdontDTO) {
            Object[] data2 = {rd2.getGrupo(), rd2.getProcedimiento(), rd2.getTotalProcedimiento(), rd2.getUsuario()};
            rows2.add(data2);
        }
        populatetable(this.JTCantProcedimientos, header2, rows2);
        this.listProcedimientosPacienteOdontDTO = new ArrayList();
        this.listProcedimientosPacienteOdontDTO = this.xInformesSgcDAO.getProcedimientosPacienteOdont(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xidGenerico[this.JCBProfesional.getSelectedIndex()]));
        ProcedimientosPacienteOdontDTO pp = new ProcedimientosPacienteOdontDTO();
        String[] header3 = new String[pp.getClass().getFields().length];
        int y = 0;
        for (Field f3 : pp.getClass().getFields()) {
            header3[y] = f3.getName();
            y++;
        }
        this.xmodelo3 = new DefaultTableModel(0, 0);
        this.JTProcedimientoPaciente.setModel(this.xmodelo3);
        this.JTProcedimientoPaciente.setAutoResizeMode(0);
        List<Object[]> rows3 = new ArrayList<>();
        for (ProcedimientosPacienteOdontDTO prp : this.listProcedimientosPacienteOdontDTO) {
            Object[] data3 = {prp.getCodCita(), prp.getFecha_Cita(), prp.getTipoIdentificacion(), prp.getNoDocumento(), prp.getPaciente(), prp.getSexo(), prp.getFechaNac(), prp.getEdad(), prp.getClasificacionCita(), prp.getTipoCita(), prp.getEps(), prp.getCodigoTratamiento(), prp.getFechaInicioTratamiento(), prp.getFechaFinTratamiento(), prp.getEstadoTratamiento(), prp.getCodIngreso(), prp.getProfesional(), prp.getCodigo_Dxp(), prp.getGrupoProcedimiento(), prp.getProcedimiento(), prp.getCantidad()};
            rows3.add(data3);
        }
        populatetable(this.JTProcedimientoPaciente, header3, rows3);
        this.listCantidadCitasOdontDTO = new ArrayList();
        this.listCantidadCitasOdontDTO = this.xInformesSgcDAO.getCantidadCitasOdont(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xidGenerico[this.JCBProfesional.getSelectedIndex()]));
        CantidadCitasOdontDTO cc = new CantidadCitasOdontDTO();
        String[] header4 = new String[cc.getClass().getFields().length];
        int z = 0;
        for (Field f4 : cc.getClass().getFields()) {
            header4[z] = f4.getName();
            z++;
        }
        this.xmodelo4 = new DefaultTableModel(0, 0);
        this.JTCantCitas.setModel(this.xmodelo4);
        this.JTCantCitas.setAutoResizeMode(0);
        List<Object[]> rows4 = new ArrayList<>();
        for (CantidadCitasOdontDTO cci : this.listCantidadCitasOdontDTO) {
            Object[] data4 = {cci.getTipoCita(), cci.getClasificacionCita(), cci.getCantidad()};
            rows4.add(data4);
        }
        populatetable(this.JTCantCitas, header4, rows4);
        this.listInasistenciaOdontDTO = new ArrayList();
        this.listInasistenciaOdontDTO = this.xInformesSgcDAO.getInasistenciaOdont(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xidGenerico[this.JCBProfesional.getSelectedIndex()]));
        InasistenciaOdontDTO in = new InasistenciaOdontDTO();
        String[] header5 = new String[in.getClass().getFields().length];
        int b = 0;
        for (Field f5 : in.getClass().getFields()) {
            header5[b] = f5.getName();
            b++;
        }
        this.xmodelo5 = new DefaultTableModel(0, 0);
        this.JTInasistencia.setModel(this.xmodelo5);
        this.JTInasistencia.setAutoResizeMode(0);
        List<Object[]> rows5 = new ArrayList<>();
        for (InasistenciaOdontDTO ina : this.listInasistenciaOdontDTO) {
            Object[] data5 = {ina.getTipoCita(), ina.getClasificacionCita(), ina.getMotivoAnulacion(), ina.getCantidad()};
            rows5.add(data5);
        }
        populatetable(this.JTInasistencia, header5, rows5);
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTRegistroActividades = new JTable();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTCantProcedimientos = new JTable();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTProcedimientoPaciente = new JTable();
        this.jPanel5 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.JTCantCitas = new JTable();
        this.jPanel6 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.JTInasistencia = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INDICADORES GENERALES");
        setName("jifIndicadoresOdontologia");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS PARA BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Odontologia.JIFFIndicadoresGenerales.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFIndicadoresGenerales.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Odontologia.JIFFIndicadoresGenerales.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFIndicadoresGenerales.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.addItemListener(new ItemListener() { // from class: Odontologia.JIFFIndicadoresGenerales.3
            public void itemStateChanged(ItemEvent evt) {
                JIFFIndicadoresGenerales.this.JCBProfesionalItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(13, 13, 13).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBProfesional, -2, 529, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addComponent(this.JCBProfesional, -2, -1, -2)).addGap(10, 10, 10)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setToolTipText("");
        this.jPanel2.setToolTipText("");
        this.JTRegistroActividades.setFont(new Font("Arial", 1, 12));
        this.JTRegistroActividades.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRegistroActividades.setSelectionBackground(new Color(255, 255, 255));
        this.JTRegistroActividades.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTRegistroActividades);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 919, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 273, -2).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("REGISTRO DE ACTIVIDADES", this.jPanel2);
        this.JTCantProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JTCantProcedimientos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCantProcedimientos.setSelectionBackground(new Color(255, 255, 255));
        this.JTCantProcedimientos.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTCantProcedimientos);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 919, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 304, -2).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("CANT.PROCEDIMIENTOS", this.jPanel3);
        this.JTProcedimientoPaciente.setFont(new Font("Arial", 1, 12));
        this.JTProcedimientoPaciente.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTProcedimientoPaciente.setSelectionBackground(new Color(255, 255, 255));
        this.JTProcedimientoPaciente.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.JTProcedimientoPaciente);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 919, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 304, -2).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("PROCEDIMIENTOS x PACIENTE", this.jPanel4);
        this.JTCantCitas.setFont(new Font("Arial", 1, 12));
        this.JTCantCitas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCantCitas.setSelectionBackground(new Color(255, 255, 255));
        this.JTCantCitas.setSelectionForeground(Color.red);
        this.jScrollPane4.setViewportView(this.JTCantCitas);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 919, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -2, 304, -2).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("CANT. CLASE CITAS", this.jPanel5);
        this.JTInasistencia.setFont(new Font("Arial", 1, 12));
        this.JTInasistencia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTInasistencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTInasistencia.setSelectionForeground(Color.red);
        this.jScrollPane5.setViewportView(this.JTInasistencia);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 919, 32767).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -2, 304, -2).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("INANSISTENCIA", this.jPanel6);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFFIndicadoresGenerales.4
            public void mouseClicked(MouseEvent evt) {
                JIFFIndicadoresGenerales.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Odontologia.JIFFIndicadoresGenerales.5
            public void actionPerformed(ActionEvent evt) {
                JIFFIndicadoresGenerales.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Odontologia.JIFFIndicadoresGenerales.6
            public void actionPerformed(ActionEvent evt) {
                JIFFIndicadoresGenerales.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 599, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar, -2, 268, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -1, 53, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalItemStateChanged(ItemEvent evt) {
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
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        switch (this.jTabbedPane1.getSelectedIndex()) {
            case 0:
                mExportar(this.JTRegistroActividades, "REGISTRO DE ACTIVIDADES");
                break;
            case 1:
                mExportar(this.JTCantProcedimientos, "CANTIDAD DE PROCEDIMIENTOS");
                break;
            case 2:
                mExportar(this.JTProcedimientoPaciente, "DETALLE DE PROCEDIMIENTOS x PACIENTE");
                break;
            case 3:
                mExportar(this.JTCantCitas, "CANTIDAD DE CITAS");
                break;
            case 4:
                mExportar(this.JTInasistencia, "INASISTENCIA");
                break;
        }
    }

    private void mExportar(JTable table, String titulo) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (table.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(table, this.JTFRuta.getText(), titulo);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    public void populatetable(JTable table, String[] header, List<Object[]> rows) {
        removeRowSelection(table);
        System.out.println("populatetable");
        DefaultTableModel tablemodel = table.getModel();
        tablemodel.setRowCount(0);
        for (String col : header) {
            tablemodel.addColumn(col);
        }
        for (Object[] row : rows) {
            tablemodel.addRow(row);
        }
        table.setModel(tablemodel);
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            int row2 = 0;
            while (true) {
                if (row2 < table.getRowCount()) {
                    TableCellRenderer cellRenderer = table.getCellRenderer(row2, column);
                    Component c = table.prepareRenderer(cellRenderer, row2, column);
                    int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                    preferredWidth = Math.max(preferredWidth, width);
                    if (preferredWidth < maxWidth) {
                        row2++;
                    } else {
                        preferredWidth = maxWidth;
                        break;
                    }
                }
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    public static void removeRowSelection(JTable table) {
        if (table.getRowCount() > 0) {
            table.removeRowSelectionInterval(0, table.getRowCount() - 1);
        }
    }
}
