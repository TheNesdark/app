package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.ImpresionDocumentosHC;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.FamiliogramaDetalleDAO;
import com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO;
import com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO;
import com.genoma.plus.dao.historia.FamiliogramaEntornoDAO;
import com.genoma.plus.dao.historia.RelacionesFamiliaresDAO;
import com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl;
import com.genoma.plus.dao.impl.historia.FamiliogramaDetalleRelacionDAOImpl;
import com.genoma.plus.dao.impl.historia.FamiliogramaEncabezadoDAOImpl;
import com.genoma.plus.dao.impl.historia.FamiliogramaEntornoDAOImpl;
import com.genoma.plus.dao.impl.historia.RelacionesFamiliaresDAOImpl;
import com.genoma.plus.dto.historia.FamiliogramaDetalleDTO;
import com.genoma.plus.dto.historia.FamiliogramaDetalleRelacionDTO;
import com.genoma.plus.dto.historia.FamiliogramaEncabezadoDTO;
import com.genoma.plus.dto.historia.FamiliogramaEntornoDTO;
import com.genoma.plus.dto.historia.RelacionesFamiliaresDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAFamiliograma.class */
public class JPAFamiliograma extends JPanel {
    private DefaultTableModel xmodeloF;
    private DefaultTableModel xmodeloE;
    private Object[] xdatos;
    private Object[] xdatosE;
    private FamiliogramaDetalleDAO xFamiliogramaDetalleDAO;
    private String[] xIdSexo;
    private String[] xIdRoles;
    private String[] xidEntornos;
    private String[] xidRelaciones;
    private FamiliogramaEncabezadoDAO xFamiliogramaEncabezadoDAO;
    private JInternalFrame j;
    private int idAtencion;
    private String FechaR;
    private FamiliogramaEntornoDAO xFamiliogramaEntornoDAO;
    private String[] xIdRelacionesF;
    private CanvasEcomapa canvasE;
    private String[] xIdEstadoCivil;
    private RelacionesFamiliaresDAO xRelacionesFamiliaresDAO;
    private FamiliogramaDetalleRelacionDAO xDetalleRelacionDAO;
    private List<RelacionesFamiliaresDTO> listadoR;
    private Relaciones[] relacionesF;
    private Persona Paciente;
    private int idFamiliograma;
    private long idPersonaA;
    private DefaultTableModel xModeloH;
    private JPanel frameEcomapa;
    private Object[] pacienteC;
    private int persona;
    private JButton JBAgregar;
    private JButton JBAgregarE;
    private JCheckBox JCBEmbarazo;
    private JComboBox<String> JCBEntorno;
    private JComboBox<String> JCBEstadoCivil;
    private JComboBox<String> JCBRelacion;
    private JComboBox<String> JCBRol;
    private JComboBox<String> JCBSexo;
    private JComboBox<String> JCBTRelacionF;
    private JCheckBox JCEsAdoptado;
    private JCheckBox JCEsGemelo;
    private JCheckBox JCEstado;
    private JCheckBox JCEstadoE;
    private JComboBox<String> JCTipoTiempo;
    private JCheckBox JCVive;
    private JLabel JLConsecutivo;
    private JPanel JPEcomapa;
    private JPanel JPFamilia;
    private JSpinner JSEdad;
    private JTable JTDetalle;
    private JTable JTDetalleE;
    private JTextField JTFNombre;
    private JTextField JTFOcupacion;
    private JTable JTHistorico;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private ImpresionDocumentosHC xDocumentosHC = new ImpresionDocumentosHC();
    private final Metodos xmt = new Metodos();
    private int banderaE = 0;
    private int banderaF = 0;
    private int conta = 1;
    private Persona[] familiaF = null;
    private int idEncabezado = 0;
    private List<FamiliogramaEncabezadoDTO> listaFE = null;
    private List<Object[]> listaFD = null;
    private List<Object[]> listaFDR = null;
    private int xguardadoF = 0;
    private int xguardadoE = 0;

    public JPAFamiliograma(int idAtencion, String FechaR, long idPersona) {
        this.idPersonaA = 0L;
        initComponents();
        springStart();
        mCrearModeloF();
        mCrearModeloE();
        llenarCombox();
        this.idAtencion = idAtencion;
        this.idPersonaA = idPersona;
        this.FechaR = FechaR;
        this.listadoR = this.xRelacionesFamiliaresDAO.listadoRelaciones();
        VerficarFexistente();
        mCargarDatosE();
        mNuevo();
        this.JCBEntorno.setSelectedIndex(-1);
        this.JCBRelacion.setSelectedIndex(-1);
        mCargarDatosH();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xFamiliogramaDetalleDAO = (FamiliogramaDetalleDAOImpl) classPathXmlApplicationContext.getBean("FDetalleDAO");
        this.xFamiliogramaEncabezadoDAO = (FamiliogramaEncabezadoDAOImpl) classPathXmlApplicationContext.getBean("FEncabezadoDAO");
        this.xFamiliogramaEntornoDAO = (FamiliogramaEntornoDAOImpl) classPathXmlApplicationContext.getBean("FamiliogramaEDAO");
        this.xRelacionesFamiliaresDAO = (RelacionesFamiliaresDAOImpl) classPathXmlApplicationContext.getBean("RFamiliaresDAO");
        this.xDetalleRelacionDAO = (FamiliogramaDetalleRelacionDAOImpl) classPathXmlApplicationContext.getBean("FDetalleRelacionesDAO");
    }

    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v144, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane2 = new JTabbedPane();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPFamilia = new JPanel();
        this.jPanel2 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBRol = new JComboBox<>();
        this.JCBSexo = new JComboBox<>();
        this.JSEdad = new JSpinner();
        this.JCVive = new JCheckBox();
        this.JCBEmbarazo = new JCheckBox();
        this.JTFOcupacion = new JTextField();
        this.JCBEstadoCivil = new JComboBox<>();
        this.JCBTRelacionF = new JComboBox<>();
        this.JCEstado = new JCheckBox();
        this.JCEsAdoptado = new JCheckBox();
        this.JCEsGemelo = new JCheckBox();
        this.JCTipoTiempo = new JComboBox<>();
        this.JLConsecutivo = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel5 = new JPanel();
        this.jButton1 = new JButton();
        this.JBAgregar = new JButton();
        this.JPEcomapa = new JPanel();
        this.jPanel3 = new JPanel();
        this.JCBEntorno = new JComboBox<>();
        this.JCBRelacion = new JComboBox<>();
        this.JCEstadoE = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleE = new JTable();
        this.jPanel1 = new JPanel();
        this.JBAgregarE = new JButton();
        this.jButton2 = new JButton();
        this.jPanel4 = new JPanel();
        this.jPanel6 = new JPanel();
        this.jPanel7 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xJPFamiliograma");
        this.jTabbedPane2.setFont(new Font("Arial", 1, 13));
        this.jTabbedPane2.setName("Familiograma_Ecomapa");
        this.jTabbedPane1.setFont(new Font("Arial", 1, 13));
        this.jTabbedPane1.setName("Ecomapa");
        this.jTabbedPane1.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.1
            public void stateChanged(ChangeEvent evt) {
                JPAFamiliograma.this.jTabbedPane1StateChanged(evt);
            }
        });
        this.JPFamilia.setName("Familia");
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRol.setFont(new Font("Arial", 1, 12));
        this.JCBRol.setBorder(BorderFactory.createTitledBorder((Border) null, "Rol Familiar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexo.setFont(new Font("Arial", 1, 12));
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSEdad.setFont(new Font("Arial", 1, 12));
        this.JSEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCVive.setFont(new Font("Arial", 1, 12));
        this.JCVive.setForeground(Color.blue);
        this.JCVive.setText("vive?");
        this.JCBEmbarazo.setFont(new Font("Arial", 1, 12));
        this.JCBEmbarazo.setForeground(Color.blue);
        this.JCBEmbarazo.setText("EsEmbarazada");
        this.JTFOcupacion.setFont(new Font("Arial", 1, 12));
        this.JTFOcupacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ocupacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstadoCivil.setFont(new Font("Arial", 1, 12));
        this.JCBEstadoCivil.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado civil", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTRelacionF.setFont(new Font("Arial", 1, 12));
        this.JCBTRelacionF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo De Relacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        this.JCEsAdoptado.setFont(new Font("Arial", 1, 12));
        this.JCEsAdoptado.setForeground(Color.blue);
        this.JCEsAdoptado.setText("esAdoptado?");
        this.JCEsGemelo.setFont(new Font("Arial", 1, 12));
        this.JCEsGemelo.setForeground(Color.blue);
        this.JCEsGemelo.setText("esGemelo?");
        this.JCEsGemelo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.2
            public void actionPerformed(ActionEvent evt) {
                JPAFamiliograma.this.JCEsGemeloActionPerformed(evt);
            }
        });
        this.JCTipoTiempo.setFont(new Font("Arial", 1, 12));
        this.JCTipoTiempo.setModel(new DefaultComboBoxModel(new String[]{"AÑO", "MES", "DIA"}));
        this.JCTipoTiempo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Tiempo", 0, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JLConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JLConsecutivo.setForeground(Color.red);
        this.JLConsecutivo.setHorizontalAlignment(0);
        this.JLConsecutivo.setToolTipText("");
        this.JLConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 183, 32767).addComponent(this.JTFOcupacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBTRelacionF, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEstado).addComponent(this.JCVive))).addComponent(this.JCBRol, -2, 246, -2)).addGap(13, 13, 13).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEstadoCivil, 0, 124, 32767).addComponent(this.JCBSexo, 0, -1, 32767)).addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEsGemelo).addComponent(this.JCEsAdoptado).addComponent(this.JCBEmbarazo)).addGap(18, 18, 18).addComponent(this.JLConsecutivo, -1, -1, 32767).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSEdad, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCTipoTiempo, 0, 142, 32767)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 56, -2).addComponent(this.JCBRol).addComponent(this.JCBSexo, -2, 56, -2).addComponent(this.JSEdad, -2, 56, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCTipoTiempo, -2, 56, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCVive)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOcupacion, -2, 51, -2).addComponent(this.JCBTRelacionF, -2, 51, -2))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEstadoCivil, GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBEmbarazo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCEsAdoptado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCEsGemelo)).addComponent(this.JLConsecutivo, -2, 55, -2)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.3
            public void mouseClicked(MouseEvent evt) {
                JPAFamiliograma.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 10, 32767));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Generar Familiograma");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.4
            public void actionPerformed(ActionEvent evt) {
                JPAFamiliograma.this.jButton1ActionPerformed(evt);
            }
        });
        this.JBAgregar.setFont(new Font("Arial", 1, 12));
        this.JBAgregar.setText("Añadir");
        this.JBAgregar.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.5
            public void mouseClicked(MouseEvent evt) {
                JPAFamiliograma.this.JBAgregarMouseClicked(evt);
            }
        });
        this.JBAgregar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.6
            public void actionPerformed(ActionEvent evt) {
                JPAFamiliograma.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout JPFamiliaLayout = new GroupLayout(this.JPFamilia);
        this.JPFamilia.setLayout(JPFamiliaLayout);
        JPFamiliaLayout.setHorizontalGroup(JPFamiliaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFamiliaLayout.createSequentialGroup().addContainerGap().addGroup(JPFamiliaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.JBAgregar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane1).addComponent(this.jPanel2, -1, -1, 32767)).addComponent(this.jPanel5, -1, -1, 32767)));
        JPFamiliaLayout.setVerticalGroup(JPFamiliaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFamiliaLayout.createSequentialGroup().addGroup(JPFamiliaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFamiliaLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jPanel5, -2, -1, -2)).addGroup(JPFamiliaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 263, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 50, -2).addContainerGap(119, 32767)));
        this.jTabbedPane1.addTab("Familia", this.JPFamilia);
        this.JPEcomapa.setName("Ecomapa");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBEntorno.setFont(new Font("Arial", 1, 12));
        this.JCBEntorno.setBorder(BorderFactory.createTitledBorder((Border) null, "Entorno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRelacion.setFont(new Font("Arial", 1, 12));
        this.JCBRelacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Relacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstadoE.setFont(new Font("Arial", 1, 12));
        this.JCEstadoE.setForeground(Color.blue);
        this.JCEstadoE.setText("Estado");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEntorno, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRelacion, -2, 184, -2).addGap(73, 73, 73).addComponent(this.JCEstadoE).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEstadoE).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEntorno).addComponent(this.JCBRelacion))).addContainerGap(25, 32767)));
        this.jScrollPane2.setName("");
        this.JTDetalleE.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleE.setSelectionBackground(Color.white);
        this.JTDetalleE.setSelectionForeground(Color.red);
        this.JTDetalleE.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.7
            public void mouseClicked(MouseEvent evt) {
                JPAFamiliograma.this.JTDetalleEMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleE);
        this.JBAgregarE.setFont(new Font("Arial", 1, 12));
        this.JBAgregarE.setText("Añadir");
        this.JBAgregarE.setActionCommand("Agregar");
        this.JBAgregarE.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.8
            public void actionPerformed(ActionEvent evt) {
                JPAFamiliograma.this.JBAgregarEActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBAgregarE, -1, -1, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAgregarE, -1, 50, 32767));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("Generar Ecomapa");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.9
            public void actionPerformed(ActionEvent evt) {
                JPAFamiliograma.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPEcomapaLayout = new GroupLayout(this.JPEcomapa);
        this.JPEcomapa.setLayout(JPEcomapaLayout);
        JPEcomapaLayout.setHorizontalGroup(JPEcomapaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcomapaLayout.createSequentialGroup().addContainerGap().addGroup(JPEcomapaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jScrollPane2).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jButton2, -1, -1, 32767)).addContainerGap()));
        JPEcomapaLayout.setVerticalGroup(JPEcomapaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcomapaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 327, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2, -2, 50, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("Ecomapa", this.JPEcomapa);
        this.jPanel4.setName("Grafico Familiograma");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 841, 32767));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.jTabbedPane1.addTab("Grafico Familiograma", this.jPanel4);
        this.jPanel6.setBackground(Color.white);
        this.jPanel6.setName("Grafico Ecomapa");
        this.jPanel6.setOpaque(false);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 841, 32767));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 684, 32767));
        this.jTabbedPane1.addTab("Grafico Ecomapa", this.jPanel6);
        this.jTabbedPane2.addTab("Atencion", this.jTabbedPane1);
        this.jPanel7.setName("Historico");
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 13), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.10
            public void mouseClicked(MouseEvent evt) {
                JPAFamiliograma.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTHistorico);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 846, 32767));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 711, 32767)));
        this.jTabbedPane2.addTab("Historico", this.jPanel7);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane2, -2, -1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBRol.setSelectedIndex(TraerSelecionCombo(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString(), this.xIdRoles));
            this.JCBSexo.setSelectedIndex(TraerSelecionCombo(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), this.xIdSexo));
            this.JSEdad.setValue(Integer.valueOf(Integer.parseInt(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString())));
            this.JCVive.setSelected(((Boolean) this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 8)).booleanValue());
            this.JTFOcupacion.setText(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString();
            this.JCBTRelacionF.setSelectedIndex(TraerSelecionCombo(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString(), this.xIdRelacionesF));
            this.JCBEstadoCivil.setSelectedIndex(TraerSelecionCombo(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString(), this.xIdEstadoCivil));
            this.JCBEmbarazo.setSelected(((Boolean) this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 14)).booleanValue());
            this.JCEsAdoptado.setSelected(((Boolean) this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 15)).booleanValue());
            this.JCEsGemelo.setSelected(((Boolean) this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 16)).booleanValue());
            this.JCEstado.setSelected(((Boolean) this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 17)).booleanValue());
            this.JCTipoTiempo.setSelectedItem(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 19));
        }
        this.banderaF = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarMouseClicked(MouseEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBRol.getSelectedIndex() != -1) {
                if (this.JCBSexo.getSelectedIndex() != -1) {
                    if (((Integer) this.JSEdad.getValue()).intValue() > 0) {
                        if (this.banderaF == 0) {
                            this.xdatos = new Object[20];
                            this.xdatos[0] = Integer.valueOf(this.conta);
                            this.xdatos[1] = Integer.valueOf(this.conta);
                            this.xdatos[2] = this.JTFNombre.getText();
                            this.xdatos[3] = this.xIdRoles[this.JCBRol.getSelectedIndex()];
                            this.xdatos[4] = this.JCBRol.getItemAt(this.JCBRol.getSelectedIndex());
                            this.xdatos[5] = this.xIdSexo[this.JCBSexo.getSelectedIndex()];
                            this.xdatos[6] = this.JCBSexo.getItemAt(this.JCBSexo.getSelectedIndex());
                            this.xdatos[7] = Integer.valueOf(((Integer) this.JSEdad.getValue()).intValue());
                            this.xdatos[8] = Boolean.valueOf(this.JCVive.isSelected());
                            this.xdatos[9] = this.JTFOcupacion.getText();
                            this.xdatos[10] = this.xIdRelacionesF[this.JCBTRelacionF.getSelectedIndex()];
                            this.xdatos[11] = this.JCBTRelacionF.getSelectedItem().toString();
                            this.xdatos[12] = this.xIdEstadoCivil[this.JCBEstadoCivil.getSelectedIndex()];
                            this.xdatos[13] = this.JCBEstadoCivil.getSelectedItem().toString();
                            this.xdatos[14] = Boolean.valueOf(this.JCBEmbarazo.isSelected());
                            this.xdatos[15] = Boolean.valueOf(this.JCEsAdoptado.isSelected());
                            this.xdatos[16] = Boolean.valueOf(this.JCEsGemelo.isSelected());
                            this.xdatos[17] = Boolean.valueOf(this.JCEstado.isSelected());
                            this.xdatos[19] = this.JCTipoTiempo.getSelectedItem().toString();
                            this.xmodeloF.addRow(this.xdatos);
                            this.conta++;
                        } else {
                            this.xmodeloF.setValueAt(this.xmodeloF.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.JTDetalle.getSelectedRow(), 0);
                            this.xmodeloF.setValueAt(0, this.JTDetalle.getSelectedRow(), 1);
                            this.xmodeloF.setValueAt(this.JTFNombre.getText(), this.JTDetalle.getSelectedRow(), 2);
                            this.xmodeloF.setValueAt(this.xIdRoles[this.JCBRol.getSelectedIndex()], this.JTDetalle.getSelectedRow(), 3);
                            this.xmodeloF.setValueAt(this.JCBRol.getItemAt(this.JCBRol.getSelectedIndex()), this.JTDetalle.getSelectedRow(), 4);
                            this.xmodeloF.setValueAt(this.xIdSexo[this.JCBSexo.getSelectedIndex()], this.JTDetalle.getSelectedRow(), 5);
                            this.xmodeloF.setValueAt(this.JCBSexo.getItemAt(this.JCBSexo.getSelectedIndex()), this.JTDetalle.getSelectedRow(), 6);
                            this.xmodeloF.setValueAt(Integer.valueOf(((Integer) this.JSEdad.getValue()).intValue()), this.JTDetalle.getSelectedRow(), 7);
                            this.xmodeloF.setValueAt(Boolean.valueOf(this.JCVive.isSelected()), this.JTDetalle.getSelectedRow(), 8);
                            this.xmodeloF.setValueAt(this.JTFOcupacion.getText(), this.JTDetalle.getSelectedRow(), 9);
                            this.xmodeloF.setValueAt(this.xIdRelacionesF[this.JCBTRelacionF.getSelectedIndex()], this.JTDetalle.getSelectedRow(), 10);
                            this.xmodeloF.setValueAt(this.JCBTRelacionF.getSelectedItem().toString(), this.JTDetalle.getSelectedRow(), 11);
                            this.xmodeloF.setValueAt(this.xIdEstadoCivil[this.JCBEstadoCivil.getSelectedIndex()], this.JTDetalle.getSelectedRow(), 12);
                            this.xmodeloF.setValueAt(this.JCBEstadoCivil.getSelectedItem().toString(), this.JTDetalle.getSelectedRow(), 13);
                            this.xmodeloF.setValueAt(Boolean.valueOf(this.JCBEmbarazo.isSelected()), this.JTDetalle.getSelectedRow(), 14);
                            this.xmodeloF.setValueAt(Boolean.valueOf(this.JCEsAdoptado.isSelected()), this.JTDetalle.getSelectedRow(), 15);
                            this.xmodeloF.setValueAt(Boolean.valueOf(this.JCEsGemelo.isSelected()), this.JTDetalle.getSelectedRow(), 16);
                            this.xmodeloF.setValueAt(Boolean.valueOf(this.JCEstado.isSelected()), this.JTDetalle.getSelectedRow(), 17);
                            this.xmodeloF.setValueAt(this.JCTipoTiempo.getSelectedItem().toString(), this.JTDetalle.getSelectedRow(), 19);
                            this.banderaF = 0;
                        }
                        mNuevo();
                        return;
                    }
                    this.xmt.mostrarMensaje("Edad no valida");
                    return;
                }
                this.xmt.mostrarMensaje("Por favor selecionar un sexo");
                return;
            }
            this.xmt.mostrarMensaje("Por favor selecionar un rol");
            return;
        }
        this.xmt.mostrarMensaje("Por favor ingresar un nombre");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        DibujarGraficoF();
        try {
            this.xDocumentosHC.mImprimirFamiliograma(this.idAtencion);
        } catch (SQLException ex) {
            Logger.getLogger(JPAFamiliograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void DibujarGraficoF() {
        if (this.xmodeloF.getRowCount() > 5) {
            JPanel frameFamiliograma = new JPanel();
            Component canvasFamiliograma = new CanvasFamiliograma();
            frameFamiliograma.add(canvasFamiliograma);
            frameFamiliograma.setLayout((LayoutManager) null);
            frameFamiliograma.setSize(1000, 750);
            frameFamiliograma.setName("Grafico Familiograma");
            for (int x = 0; x < this.jTabbedPane1.getComponentCount(); x++) {
                System.out.println(this.jTabbedPane1.getComponent(x).getName());
                if (this.jTabbedPane1.getComponent(x).getName().equals("Grafico Familiograma")) {
                    this.jTabbedPane1.remove(x);
                }
            }
            this.jTabbedPane1.addTab("Grafico Familiograma", frameFamiliograma);
            Persona[] famili = casting(this.xmodeloF);
            Persona[] familia = mRedimencionarArray(famili);
            if (validarFamilia(familia)) {
                Relaciones[] Relaciones = armarRelaciones(familia);
                this.relacionesF = Relaciones;
                Persona[] armarFamiliograma = ArmarFamiliograma(familia);
                Persona[] padres = canvasFamiliograma.obtenerPersonas(armarFamiliograma, 4);
                if (mValidarRelacionesConyugales(padres)) {
                    if (padres.length < 2 || padres == null || ((padres.length == 2 && padres[0].getSexo().equals("M") && padres[1].getSexo().equals("M")) || (padres.length == 2 && padres[0].getSexo().equals("F") && padres[1].getSexo().equals("F")))) {
                        this.xmt.mostrarMensaje("Datos invalidos Por favor verifique los datos  \n de la segunda generacion esten bien");
                        return;
                    }
                    Persona[] Hijos = canvasFamiliograma.obtenerPersonas(armarFamiliograma, 3);
                    if (Hijos.length < 0 || Hijos == null) {
                        this.xmt.mostrarMensaje("Datos invalidos revisar la tercera generacion");
                        return;
                    }
                    this.familiaF = fusionarArray(padres, Hijos);
                    Persona[] abueloM = canvasFamiliograma.obtenerPersonas(armarFamiliograma, 7);
                    if (mValidarRelacionesConyugales(abueloM)) {
                        Persona[] abueloP = canvasFamiliograma.obtenerPersonas(familia, 14);
                        if (mValidarRelacionesConyugales(abueloP)) {
                            if (abueloP.length >= 2 && abueloM.length >= 2) {
                                Persona padre = getMadre(padres, "M");
                                Persona[] tiosP = canvasFamiliograma.obtenerPersonas(armarFamiliograma, 8);
                                Persona madre = getMadre(padres, "F");
                                Persona[] tiosM = canvasFamiliograma.obtenerPersonas(armarFamiliograma, 15);
                                canvasFamiliograma.dibujarAbuelosP(abueloP);
                                canvasFamiliograma.dibujarAbuelosM(abueloM);
                                canvasFamiliograma.dibujarHijosAbueloM(canvasFamiliograma.ordenarPorEdades(canvasFamiliograma.fusionarArray(tiosM, madre)));
                                canvasFamiliograma.dibujarHijosAbueloP(canvasFamiliograma.ordenarPorEdades(canvasFamiliograma.fusionarArray(tiosP, padre)));
                                canvasFamiliograma.dibujarHijos(canvasFamiliograma.ordenarPorEdades(Hijos));
                                canvasFamiliograma.dibujarGuia();
                                canvasFamiliograma.dibujarRelaciones(Relaciones);
                                try {
                                    repaint();
                                    this.xmt.saveScreenShot(canvasFamiliograma, "Familiograma.png", "GraficoFamiliograma");
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            return;
                        }
                        this.xmt.mostrarMensaje("Estados civil de la primera generacion no validos");
                        return;
                    }
                    this.xmt.mostrarMensaje("Estados civil de la primera generacion no validos");
                    return;
                }
                this.xmt.mostrarMensaje("Estados civil de la segunda generacion no validos");
                return;
            }
            this.xmt.mostrarMensaje("Recuerde que se deben ingresar la informacion \n de 3 generaciones");
            return;
        }
        this.xmt.mostrarMensaje("Recuerde que se deben ingresar la informacion \n de 3 generaciones la cantidad de personas no es valida");
    }

    public Persona[] mRedimencionarArray(Persona[] familia) {
        int nVacios = 0;
        for (Persona persona : familia) {
            if (persona == null) {
                nVacios++;
            }
        }
        int conta = 0;
        Persona[] aux = new Persona[familia.length - nVacios];
        for (int j = 0; j < familia.length; j++) {
            if (familia[j] != null) {
                aux[conta] = familia[j];
                conta++;
            }
        }
        return aux;
    }

    public boolean validarFamilia(Persona[] familia) {
        boolean resul = true;
        int rolPaciente = obtenerRolPaciente();
        if (rolPaciente == 4) {
            for (int x = 0; x < familia.length; x++) {
                if (familia[x] != null && (familia[x].getRol() == 7 || familia[x].getRol() == 14)) {
                    resul = false;
                }
            }
        }
        return resul;
    }

    public boolean mValidarRelacionesConyugales(Persona[] pareja) {
        boolean resp = false;
        if (pareja[0].getIdEstadocivil() == pareja[1].getIdEstadocivil()) {
            resp = true;
        }
        return resp;
    }

    public Persona[] fusionarArray(Persona[] n1, Persona[] n2) {
        Persona[] familia = new Persona[n1.length + n2.length];
        int conta = 0;
        for (Persona persona : n1) {
            familia[conta] = persona;
            conta++;
        }
        for (Persona persona2 : n2) {
            familia[conta] = persona2;
            conta++;
        }
        for (Persona persona3 : familia) {
            System.out.println("familia " + persona3.getPrimerNom());
        }
        return familia;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEMouseClicked(MouseEvent evt) {
        if (this.JTDetalleE.getSelectedRow() != -1) {
            this.JCBEntorno.setSelectedIndex(TraerSelecionCombo(this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 2).toString(), this.xidEntornos));
            this.JCBRelacion.setSelectedIndex(TraerSelecionCombo(this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 4).toString(), this.xidRelaciones));
            this.JCEstadoE.setSelected(((Boolean) this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 6)).booleanValue());
            this.banderaE = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarEActionPerformed(ActionEvent evt) {
        if (this.JCBEntorno.getSelectedIndex() != -1) {
            if (this.JCBRelacion.getSelectedIndex() != -1) {
                if (this.banderaE == 0) {
                    if (validarEntornos(this.xmodeloE, this.xidEntornos[this.JCBEntorno.getSelectedIndex()])) {
                        this.xdatosE = new Object[7];
                        this.xdatosE[0] = 0;
                        this.xdatosE[1] = 0;
                        this.xdatosE[2] = this.xidEntornos[this.JCBEntorno.getSelectedIndex()];
                        this.xdatosE[3] = this.JCBEntorno.getSelectedItem().toString();
                        this.xdatosE[4] = this.xidRelaciones[this.JCBRelacion.getSelectedIndex()];
                        this.xdatosE[5] = this.JCBRelacion.getSelectedItem().toString();
                        this.xdatosE[6] = Boolean.valueOf(this.JCEstadoE.isSelected());
                        this.xmodeloE.addRow(this.xdatosE);
                        this.JCBEntorno.setSelectedIndex(-1);
                        this.JCBRelacion.setSelectedIndex(-1);
                        this.JCEstadoE.setSelected(true);
                        this.conta++;
                        return;
                    }
                    this.xmt.mostrarMensaje("Este entorno ya exite");
                    return;
                }
                this.xmodeloE.setValueAt(this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 0), this.JTDetalleE.getSelectedRow(), 0);
                this.xmodeloE.setValueAt(0, this.JTDetalleE.getSelectedRow(), 1);
                this.xmodeloE.setValueAt(this.xidEntornos[this.JCBEntorno.getSelectedIndex()], this.JTDetalleE.getSelectedRow(), 2);
                this.xmodeloE.setValueAt(this.JCBEntorno.getSelectedItem().toString(), this.JTDetalleE.getSelectedRow(), 3);
                this.xmodeloE.setValueAt(this.xidRelaciones[this.JCBRelacion.getSelectedIndex()], this.JTDetalleE.getSelectedRow(), 4);
                this.xmodeloE.setValueAt(this.JCBRelacion.getSelectedItem().toString(), this.JTDetalleE.getSelectedRow(), 5);
                this.xmodeloE.setValueAt(Boolean.valueOf(this.JCEstadoE.isSelected()), this.JTDetalleE.getSelectedRow(), 6);
                this.JCBEntorno.setSelectedIndex(-1);
                this.JCBRelacion.setSelectedIndex(-1);
                this.JCEstadoE.setSelected(true);
                this.banderaE = 0;
                return;
            }
            this.xmt.mostrarMensaje("Se de selecionar un tipo de relacion");
            return;
        }
        this.xmt.mostrarMensaje("Se debe selecionar un entorno");
    }

    private boolean validarEntornos(DefaultTableModel xmodeloEN, String idEntorno) {
        boolean valid = true;
        for (int x = 0; x < xmodeloEN.getRowCount(); x++) {
            if (xmodeloEN.getValueAt(x, 2).toString().equals(idEntorno)) {
                valid = false;
            }
        }
        return valid;
    }

    private void VerficarFexistente() {
        this.listaFE = this.xFamiliogramaEncabezadoDAO.ListadoFEncabezado(this.idAtencion);
        if (!this.listaFE.isEmpty()) {
            this.listaFD = this.xFamiliogramaDetalleDAO.lisdatoFDetalle(this.listaFE.get(0).getId());
            this.listaFDR = this.xDetalleRelacionDAO.listadoDRelacion(this.listaFE.get(0).getId());
            this.xguardadoF = 1;
            this.idEncabezado = this.listaFE.get(0).getId();
            this.idFamiliograma = this.listaFE.get(0).getId();
            this.JLConsecutivo.setText(this.listaFE.get(0).getId() + "");
            if (!this.listaFDR.isEmpty() && !this.listaFD.isEmpty()) {
                CargarDatos();
            }
            DibujarGraficoF();
            List<Object[]> listaEntorno = this.xFamiliogramaEntornoDAO.listadoFEntorno(this.idFamiliograma);
            if (!listaEntorno.isEmpty()) {
                this.xguardadoE = 1;
            }
        }
    }

    private void CargarFamiliograma() {
        this.listaFE = this.xFamiliogramaEncabezadoDAO.ListadoFEncabezado(this.idAtencion);
        if (this.listaFE.size() > 0) {
            this.listaFD = this.xFamiliogramaDetalleDAO.lisdatoFDetalle(this.listaFE.get(0).getId());
            this.listaFDR = this.xDetalleRelacionDAO.listadoDRelacion(this.listaFE.get(0).getId());
            this.idFamiliograma = this.listaFE.get(0).getId();
            this.JLConsecutivo.setText(this.listaFE.get(0).getId() + "");
            if (this.listaFDR.size() > 0 && this.listaFD.size() > 0) {
                CargarDatos();
            }
            DibujarGraficoF();
            mCargarDatosE();
            List<Object[]> auxEcomapa = this.xFamiliogramaEntornoDAO.listadoFEntorno(this.idFamiliograma);
            if (auxEcomapa.size() > 0) {
                dibujarGraficoE();
            }
        }
    }

    private void CargarDatos() {
        int count = 0;
        for (int x = 0; x < this.listaFD.size(); x++) {
            if (((Boolean) this.listaFD.get(x)[10]).booleanValue()) {
                this.pacienteC = this.listaFD.get(x);
            } else {
                this.xmodeloF.addRow(this.xdatos);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[0], count, 0);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[1], count, 1);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[2], count, 2);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[3], count, 3);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[4], count, 4);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[5], count, 5);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[6].toString(), count, 6);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[7].toString(), count, 7);
                this.xmodeloF.setValueAt(Boolean.valueOf(((Boolean) this.listaFD.get(x)[8]).booleanValue()), count, 8);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[9].toString(), count, 9);
                getRelacion(((Integer) this.listaFD.get(x)[0]).intValue(), count);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[12].toString(), count, 12);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[13], count, 13);
                this.xmodeloF.setValueAt(Boolean.valueOf(((Boolean) this.listaFD.get(x)[14]).booleanValue()), count, 14);
                this.xmodeloF.setValueAt(Boolean.valueOf(((Boolean) this.listaFD.get(x)[15]).booleanValue()), count, 15);
                this.xmodeloF.setValueAt(Boolean.valueOf(((Boolean) this.listaFD.get(x)[16]).booleanValue()), count, 16);
                this.xmodeloF.setValueAt(Boolean.valueOf(((Boolean) this.listaFD.get(x)[17]).booleanValue()), count, 17);
                this.xmodeloF.setValueAt(this.listaFD.get(x)[18], count, 19);
                count++;
            }
        }
    }

    public void getRelacion(int id, int pos) {
        System.out.println(" columnas " + this.xmodeloF.getColumnCount());
        for (int x = 0; x < this.listaFDR.size(); x++) {
            if (((Integer) this.listaFDR.get(x)[1]).intValue() == id) {
                this.xmodeloF.setValueAt(this.listaFDR.get(x)[3], pos, 10);
                this.xmodeloF.setValueAt(this.listaFDR.get(x)[6], pos, 11);
                this.xmodeloF.setValueAt(this.listaFDR.get(x)[0], pos, 18);
            }
        }
    }

    public String getrol(int idp, String sql) {
        List<Object[]> lista = this.xFamiliogramaDetalleDAO.TraerIds(sql);
        String rol = "";
        for (int x = 0; x < lista.size(); x++) {
            if (Integer.parseInt(lista.get(x)[0].toString()) == idp) {
                rol = lista.get(x)[1].toString();
            }
        }
        return rol;
    }

    private Persona[] casting(DefaultTableModel xm) {
        Persona[] familia = new Persona[xm.getRowCount() + 1];
        for (int x = 0; x < xm.getRowCount(); x++) {
            if (((Boolean) xm.getValueAt(x, 17)).booleanValue()) {
                familia[x] = new Persona(x + 1, xm.getValueAt(x, 2).toString(), xm.getValueAt(x, 7).toString(), xm.getValueAt(x, 5).toString(), ((Boolean) xm.getValueAt(x, 8)).booleanValue(), false, Integer.parseInt(xm.getValueAt(x, 3).toString()), xm.getValueAt(x, 9).toString(), Integer.parseInt(xm.getValueAt(x, 12).toString()), ((Boolean) xm.getValueAt(x, 14)).booleanValue(), ((Boolean) xm.getValueAt(x, 15)).booleanValue(), ((Boolean) xm.getValueAt(x, 16)).booleanValue(), xm.getValueAt(x, 19).toString());
            }
        }
        Paciente();
        familia[xm.getRowCount()] = this.Paciente;
        return familia;
    }

    private void Paciente() {
        List<Object[]> datosPaciente = this.xFamiliogramaDetalleDAO.DatosPaciente(this.idPersonaA);
        if (((Integer) datosPaciente.get(0)[5]).intValue() == 33) {
            this.Paciente = new Persona(this.xmodeloF.getRowCount() + 1, datosPaciente.get(0)[1].toString(), datosPaciente.get(0)[3].toString(), datosPaciente.get(0)[2].toString(), true, true, obtenerRolPaciente(), "No Aplica", ((Integer) datosPaciente.get(0)[4]).intValue(), true, false, false, datosPaciente.get(0)[6].toString());
        } else {
            this.Paciente = new Persona(this.xmodeloF.getRowCount() + 1, datosPaciente.get(0)[1].toString(), datosPaciente.get(0)[3].toString(), datosPaciente.get(0)[2].toString(), true, true, obtenerRolPaciente(), "No Aplica", ((Integer) datosPaciente.get(0)[4]).intValue(), false, false, false, datosPaciente.get(0)[6].toString());
        }
    }

    private Persona getMadre(Persona[] per, String sexo) {
        Persona padres = null;
        for (int x = 0; x < per.length; x++) {
            if (per[x].getSexo().equals(sexo)) {
                padres = per[x];
            }
        }
        return padres;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        dibujarGraficoE();
    }

    private void dibujarGraficoE() {
        System.out.println("ENTRA A METODO ECOMAPA");
        this.canvasE = new CanvasEcomapa();
        if (this.familiaF != null) {
            this.frameEcomapa = new JPanel();
            this.frameEcomapa.add(this.canvasE);
            this.frameEcomapa.setLayout((LayoutManager) null);
            this.frameEcomapa.setSize(1000, 750);
            this.frameEcomapa.setName("Grafico Ecomapa");
            for (int x = 0; x < this.jTabbedPane1.getComponentCount(); x++) {
                System.out.println(this.jTabbedPane1.getComponent(x).getName());
                if (this.jTabbedPane1.getComponent(x).getName().equals("Grafico Ecomapa")) {
                    this.jTabbedPane1.remove(x);
                }
            }
            this.jTabbedPane1.add(this.frameEcomapa);
            this.canvasE.setGuia(1);
            if (this.xmodeloE.getRowCount() > 0) {
                if (this.xmodeloF.getRowCount() > 5) {
                    this.canvasE.setGuia(0);
                    List<Object[]> listadoEntornos = this.xFamiliogramaDetalleDAO.TraerIds("SELECT `Id`,`Nbre` FROM `g_entorno_familiar`");
                    this.canvasE.dibujarEntorno(listadoEntornos);
                    Persona[] padres = this.canvasE.getPadres(this.familiaF);
                    this.canvasE.dibujarPadres(padres);
                    Persona[] hijos = this.canvasE.getHijos(this.familiaF);
                    this.canvasE.dibujarHijos(this.canvasE.ordenarPorEdades(hijos));
                    int filasR = validarEstado();
                    int conta = 0;
                    Relaciones[] r = new Relaciones[filasR];
                    for (int x2 = 0; x2 < this.xmodeloE.getRowCount(); x2++) {
                        if (((Boolean) this.xmodeloE.getValueAt(x2, 6)).booleanValue()) {
                            r[conta] = new Relaciones(paciente(this.familiaF).getIdPos(), Integer.parseInt(this.xmodeloE.getValueAt(x2, 2).toString()), Integer.parseInt(this.xmodeloE.getValueAt(x2, 4).toString()), ObtenerAbreviatura(this.xidRelaciones[Integer.parseInt(this.xmodeloE.getValueAt(x2, 4).toString()) - 1]));
                            conta++;
                        }
                    }
                    if (this.xmodeloE.getRowCount() > 0) {
                        this.canvasE.dibRelaciones(r, this.familiaF);
                        try {
                            repaint();
                            this.xmt.saveScreenShot(this.canvasE, "Ecomapa.png", "GraficoEcomapa");
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    this.xmt.mostrarMensaje("Debe almenos tener una relacion con el entorno");
                    return;
                }
                this.xmt.mostrarMensaje("Para generar el Ecomapa se debe generar Primero \n el Familiograma");
            }
        }
    }

    private int validarEstado() {
        int row = 0;
        for (int x = 0; x < this.xmodeloE.getRowCount(); x++) {
            if (((Boolean) this.xmodeloE.getValueAt(x, 6)).booleanValue()) {
                row++;
            }
        }
        return row;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTabbedPane1StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.xmodeloF.getRowCount() == 0 && this.xguardadoF == 0) {
            int auxAtencion = this.idAtencion;
            this.idAtencion = ((Integer) this.xModeloH.getValueAt(this.JTHistorico.getSelectedRow(), 2)).intValue();
            CargarFamiliograma();
            this.idAtencion = auxAtencion;
            return;
        }
        if (this.xmodeloF.getRowCount() > 0 && this.xguardadoF == 0) {
            mCrearModeloF();
            int auxAtencion2 = this.idAtencion;
            this.idAtencion = ((Integer) this.xModeloH.getValueAt(this.JTHistorico.getSelectedRow(), 2)).intValue();
            CargarFamiliograma();
            this.idAtencion = auxAtencion2;
            return;
        }
        if (this.xmodeloE.getRowCount() == 0) {
            int auxAtencion3 = this.idAtencion;
            this.idAtencion = ((Integer) this.xModeloH.getValueAt(this.JTHistorico.getSelectedRow(), 2)).intValue();
            int auxE = TraerEncabezadoF(this.idAtencion);
            List<Object[]> EnList = this.xFamiliogramaEntornoDAO.listadoFEntorno(auxE);
            if (EnList.size() > 0) {
                this.idFamiliograma = auxE;
                mCargarDatosE();
            }
            this.idAtencion = auxAtencion3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCEsGemeloActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
    }

    public void CargarDatosFyE(int idAtencion) {
        this.idAtencion = idAtencion;
        if (this.xmodeloF.getRowCount() == 0 && this.xguardadoF == 0) {
            int i = this.idAtencion;
            CargarFamiliograma();
            return;
        }
        if (this.xmodeloF.getRowCount() > 0 && this.xguardadoF == 0) {
            mCrearModeloF();
            CargarFamiliograma();
        } else if (this.xmodeloE.getRowCount() == 0) {
            int auxE = TraerEncabezadoF(idAtencion);
            List<Object[]> EnList = this.xFamiliogramaEntornoDAO.listadoFEntorno(auxE);
            if (EnList.size() > 0) {
                this.idFamiliograma = auxE;
                mCargarDatosE();
            }
        }
    }

    public int TraerEncabezadoF(int idatencion) {
        List<FamiliogramaEncabezadoDTO> listE = this.xFamiliogramaEncabezadoDAO.ListadoFEncabezado(idatencion);
        if (listE.size() > 0) {
            return listE.get(0).getId();
        }
        return 0;
    }

    public int TraerSelecionCombo(String id, String[] arr) {
        int pos = 0;
        for (int x = 0; x < arr.length; x++) {
            if (id.equals(arr[x])) {
                pos = x;
            }
        }
        return pos;
    }

    public Persona paciente(Persona[] p) {
        Persona per = null;
        for (int x = 0; x < p.length; x++) {
            if (p[x].getEsPaciente()) {
                per = p[x];
            }
        }
        return per;
    }

    private int obtenerRolPaciente() {
        int rol = 0;
        boolean hijo = false;
        boolean padres = false;
        boolean esposa_o = false;
        boolean abuelo = false;
        for (int x = 0; x < this.xmodeloF.getRowCount(); x++) {
            if (Integer.parseInt(this.xmodeloF.getValueAt(x, 3).toString()) == 2 && ((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue()) {
                esposa_o = true;
            }
            if (Integer.parseInt(this.xmodeloF.getValueAt(x, 3).toString()) == 3 && ((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue()) {
                hijo = true;
            }
            if (Integer.parseInt(this.xmodeloF.getValueAt(x, 3).toString()) == 4 && ((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue()) {
                padres = true;
            }
            if (Integer.parseInt(this.xmodeloF.getValueAt(x, 3).toString()) == 7 && ((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue()) {
                abuelo = true;
            }
        }
        if (hijo && esposa_o && padres && !abuelo) {
            rol = 4;
        }
        if (abuelo) {
            rol = 3;
        }
        return rol;
    }

    public void armarFamiliaEcomapa() {
        boolean hijos = false;
        if (this.xmodeloF.getRowCount() < 3) {
            this.xmt.mostrarMensaje("Esta familia no es valida");
            return;
        }
        for (int x = 0; x < this.xmodeloF.getRowCount(); x++) {
            if (((Integer) this.xmodeloF.getValueAt(x, 3)).intValue() == 3) {
                hijos = true;
            }
        }
        if (hijos) {
        }
    }

    private Relaciones[] armarRelaciones(Persona[] familia) {
        Relaciones[] rFamiliares = new Relaciones[familia.length - 1];
        int conta = 0;
        for (int x = 0; x < this.xmodeloF.getRowCount(); x++) {
            if (((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue()) {
                rFamiliares[conta] = new Relaciones(familia[conta].getIdPos(), familia[familia.length - 1].getIdPos(), Integer.parseInt(this.xmodeloF.getValueAt(x, 10).toString()), ObtenerAbreviatura(this.xmodeloF.getValueAt(x, 10).toString()));
                conta++;
            }
        }
        return rFamiliares;
    }

    private String ObtenerAbreviatura(String id) {
        String abreviatura = "";
        for (int x = 0; x < this.listadoR.size(); x++) {
            if (this.listadoR.get(x).getId() == Integer.parseInt(id)) {
                abreviatura = this.listadoR.get(x).getAbreviatura();
            }
        }
        return abreviatura;
    }

    private Persona[] ArmarFamiliograma(Persona[] per) {
        int rol = per[per.length - 1].getRol();
        String sexo = per[per.length - 1].getSexo();
        if (rol == 4) {
            for (int x = 0; x < per.length - 1; x++) {
                if (per[x].getRol() == 4 && sexo.equals("M")) {
                    per[x].setRol(14);
                }
                if (per[x].getRol() == 4 && sexo.equals("F")) {
                    per[x].setRol(7);
                }
                if (per[x].getRol() == 12 && sexo.equals("M")) {
                    per[x].setRol(7);
                }
                if (per[x].getRol() == 12 && sexo.equals("F")) {
                    per[x].setRol(14);
                }
                if (per[x].getRol() == 6 && sexo.equals("M")) {
                    per[x].setRol(8);
                }
                if (per[x].getRol() == 6 && sexo.equals("F")) {
                    per[x].setRol(15);
                }
                if (per[x].getRol() == 2) {
                    per[x].setRol(4);
                }
                if (per[x].getRol() == 11 && sexo.equals("M")) {
                    per[x].setRol(15);
                }
                if (per[x].getRol() == 11 && sexo.equals("F")) {
                    per[x].setRol(8);
                }
            }
        } else if (rol == 3) {
            for (int x2 = 0; x2 < per.length; x2++) {
                if (per[x2].getRol() == 6) {
                    per[x2].setRol(3);
                }
            }
        }
        return per;
    }

    public void mNuevo() {
        if (this.jTabbedPane1.getSelectedComponent().getName().equals("Familia")) {
            this.JTFNombre.setText("");
            this.JCBRol.setSelectedIndex(-1);
            this.JCBSexo.setSelectedIndex(-1);
            this.JCBSexo.setSelectedIndex(-1);
            this.JTFOcupacion.setText("");
            this.JSEdad.setValue(0);
            this.JCBEmbarazo.setSelected(false);
            this.JCEstado.setSelected(true);
            this.JCVive.setSelected(true);
            this.JCEstadoE.setSelected(true);
            this.JCBTRelacionF.setSelectedIndex(-1);
            this.JCBEstadoCivil.setSelectedIndex(-1);
            this.JCEsGemelo.setSelected(false);
            this.JCEsAdoptado.setSelected(false);
            this.JLConsecutivo.setText("0");
        } else if (this.jTabbedPane1.getSelectedComponent().getName().equals("Ecomapa")) {
            this.JCBEntorno.setSelectedIndex(-1);
            this.JCBRelacion.setSelectedIndex(-1);
            this.JCEstadoE.setSelected(true);
        }
        this.banderaE = 0;
    }

    public void llenarCombox() {
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.xIdEstadoCivil = retornarDatos(this.JCBEstadoCivil, "SELECT `Id`,`Nbre` FROM `g_estadocivil` WHERE `Estado` =0");
            this.xIdRoles = retornarDatos(this.JCBRol, "SELECT `g_parentesco`.`Id`, `g_parentesco`.`Nbre` FROM `g_parentesco` WHERE id <> 5 AND `id` <>1 AND `id` <> 13 ORDER BY `Nbre` ASC");
            this.xIdSexo = retornarDatos(this.JCBSexo, "SELECT `g_sexo`.`Id`,`g_sexo`.`Nbre` FROM `g_sexo`");
            this.xIdRelacionesF = retornarDatos(this.JCBTRelacionF, "SELECT `Id`,`Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=0");
            this.xidEntornos = retornarDatos(this.JCBEntorno, "SELECT `Id`,`Nbre` FROM `g_entorno_familiar` WHERE `Estado` =1;");
            this.xidRelaciones = retornarDatos(this.JCBRelacion, "SELECT  `Id`, `Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=2;");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MEXION SALUD IPS")) {
            this.xIdRoles = retornarDatos(this.JCBRol, "SELECT `g_parentesco`.`Id`, `g_parentesco`.`Nbre` FROM `g_parentesco` WHERE estado = 0");
            this.xIdEstadoCivil = retornarDatos(this.JCBEstadoCivil, "SELECT `Id`,`Nbre` FROM `g_estadocivil` WHERE `Estado` =0 AND  `id` < 3 OR `id`>5 OR id =4");
            this.xIdSexo = retornarDatos(this.JCBSexo, "SELECT `g_sexo`.`Id`,`g_sexo`.`Nbre` FROM `g_sexo`");
            this.xIdRelacionesF = retornarDatos(this.JCBTRelacionF, "SELECT `Id`,`Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=0");
            this.xidEntornos = retornarDatos(this.JCBEntorno, "SELECT `Id`,`Nbre` FROM `g_entorno_familiar` WHERE `Estado` =1;");
            this.xidRelaciones = retornarDatos(this.JCBRelacion, "SELECT  `Id`, `Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=2;");
            return;
        }
        this.xIdEstadoCivil = retornarDatos(this.JCBEstadoCivil, "SELECT `Id`,`Nbre` FROM `g_estadocivil` WHERE `Estado` =0 AND  `id` < 3 OR `id`>5 OR id =4");
        this.xIdRoles = retornarDatos(this.JCBRol, "SELECT `g_parentesco`.`Id`, `g_parentesco`.`Nbre` FROM `g_parentesco` WHERE id <> 5 AND `id` <>1 AND `id` <> 13 ORDER BY `Nbre` ASC");
        this.xIdSexo = retornarDatos(this.JCBSexo, "SELECT `g_sexo`.`Id`,`g_sexo`.`Nbre` FROM `g_sexo`");
        this.xIdRelacionesF = retornarDatos(this.JCBTRelacionF, "SELECT `Id`,`Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=0");
        this.xidEntornos = retornarDatos(this.JCBEntorno, "SELECT `Id`,`Nbre` FROM `g_entorno_familiar` WHERE `Estado` =1;");
        this.xidRelaciones = retornarDatos(this.JCBRelacion, "SELECT  `Id`, `Nbre` FROM `g_relaciones_medicina_familar` WHERE `Estado`=1 AND `Tipo`=2;");
    }

    private String[] retornarDatos(JComboBox c, String sql) {
        List<Object[]> lista = this.xFamiliogramaDetalleDAO.TraerIds(sql);
        String[] ids = new String[lista.size()];
        for (int x = 0; x < lista.size(); x++) {
            ids[x] = lista.get(x)[0].toString();
            c.addItem(lista.get(x)[1]);
        }
        return ids;
    }

    public void mGuardar() {
        if (this.jTabbedPane1.getSelectedComponent().getName().equals("Familia")) {
            if (this.xguardadoF == 0) {
                if (this.JTDetalle.getRowCount() > 5) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        FamiliogramaEncabezadoDTO XEncabezado = new FamiliogramaEncabezadoDTO();
                        XEncabezado.setIdAtencion(this.idAtencion);
                        XEncabezado.setIdEspecialidad(Integer.parseInt(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString()));
                        this.FechaR.substring(0, 10);
                        System.out.println(traerFecha(this.FechaR.substring(0, 10)));
                        XEncabezado.setFechaR(traerFecha(this.FechaR.substring(0, 10)));
                        XEncabezado.setIdProfesional(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString()));
                        XEncabezado.setEstado(true);
                        XEncabezado.setIdUsuario(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString()));
                        this.idEncabezado = this.xFamiliogramaEncabezadoDAO.mCreate(XEncabezado);
                        this.JLConsecutivo.setText(this.idEncabezado + "");
                        int idPaciente = InsertarPaciente(this.idEncabezado);
                        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                            FamiliogramaDetalleDTO detalle = new FamiliogramaDetalleDTO();
                            detalle.setIdFamiliograma(this.idEncabezado);
                            detalle.setNombre(this.xmodeloF.getValueAt(x, 2).toString());
                            System.out.println(this.xmodeloF.getValueAt(x, 3).toString());
                            detalle.setIdParentesco(Integer.parseInt(this.xmodeloF.getValueAt(x, 3).toString()));
                            detalle.setIdSexo(this.xmodeloF.getValueAt(x, 5).toString());
                            detalle.setEdad(this.xmodeloF.getValueAt(x, 7).toString());
                            detalle.setVive(((Boolean) this.xmodeloF.getValueAt(x, 8)).booleanValue());
                            detalle.setOcupacion(this.xmodeloF.getValueAt(x, 9).toString());
                            detalle.setIdestadoCivil(Integer.parseInt(this.xmodeloF.getValueAt(x, 12).toString()));
                            detalle.setEsPaciente(false);
                            detalle.setEsEmbarazada(((Boolean) this.xmodeloF.getValueAt(x, 14)).booleanValue());
                            detalle.setEsAdoptado(((Boolean) this.xmodeloF.getValueAt(x, 15)).booleanValue());
                            detalle.setEsGemelo(((Boolean) this.xmodeloF.getValueAt(x, 16)).booleanValue());
                            detalle.setEstado(((Boolean) this.xmodeloF.getValueAt(x, 17)).booleanValue());
                            detalle.setTipoTiempoEdad(this.xmodeloF.getValueAt(x, 19).toString());
                            detalle.setUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                            int idDetalle = this.xFamiliogramaDetalleDAO.mCreate(detalle);
                            FamiliogramaDetalleRelacionDTO FDR = new FamiliogramaDetalleRelacionDTO();
                            FDR.setIdFamiliogramaD(Integer.valueOf(idDetalle));
                            FDR.setIdFamiliogramaD1(Integer.valueOf(idPaciente));
                            FDR.setIdTipoRelacion(Integer.valueOf(this.relacionesF[x].getTipoDeRelacion()));
                            FDR.setAbreviatura(this.relacionesF[x].getAbreviatura());
                            FDR.setEstado(true);
                            FDR.setIdIUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                            FDR.setIdFamiliograma(this.idEncabezado);
                            this.xDetalleRelacionDAO.mCreate(FDR);
                        }
                        this.xguardadoF = 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                this.xFamiliogramaDetalleDAO.anularDetalle(this.idEncabezado);
                this.xDetalleRelacionDAO.mAnularDetalle(this.idEncabezado);
                int idPaciente2 = InsertarPaciente(this.idEncabezado);
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    FamiliogramaDetalleDTO detalle2 = new FamiliogramaDetalleDTO();
                    detalle2.setIdFamiliograma(this.idEncabezado);
                    detalle2.setNombre(this.xmodeloF.getValueAt(x2, 2).toString());
                    System.out.println(this.xmodeloF.getValueAt(x2, 3).toString());
                    detalle2.setIdParentesco(Integer.parseInt(this.xmodeloF.getValueAt(x2, 3).toString()));
                    detalle2.setIdSexo(this.xmodeloF.getValueAt(x2, 5).toString());
                    detalle2.setEdad(this.xmodeloF.getValueAt(x2, 7).toString());
                    detalle2.setVive(((Boolean) this.xmodeloF.getValueAt(x2, 8)).booleanValue());
                    detalle2.setOcupacion(this.xmodeloF.getValueAt(x2, 9).toString());
                    detalle2.setIdestadoCivil(Integer.parseInt(this.xmodeloF.getValueAt(x2, 12).toString()));
                    detalle2.setEsPaciente(false);
                    detalle2.setEsEmbarazada(((Boolean) this.xmodeloF.getValueAt(x2, 14)).booleanValue());
                    detalle2.setEsAdoptado(((Boolean) this.xmodeloF.getValueAt(x2, 15)).booleanValue());
                    detalle2.setEsGemelo(((Boolean) this.xmodeloF.getValueAt(x2, 16)).booleanValue());
                    detalle2.setEstado(((Boolean) this.xmodeloF.getValueAt(x2, 17)).booleanValue());
                    detalle2.setTipoTiempoEdad(this.xmodeloF.getValueAt(x2, 19).toString());
                    detalle2.setUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    this.persona = this.xFamiliogramaDetalleDAO.mCreate(detalle2);
                    FamiliogramaDetalleRelacionDTO FDR2 = new FamiliogramaDetalleRelacionDTO();
                    FDR2.setIdFamiliogramaD(Integer.valueOf(this.persona));
                    FDR2.setIdFamiliogramaD1(Integer.valueOf(idPaciente2));
                    FDR2.setIdTipoRelacion(Integer.valueOf(this.relacionesF[x2].getTipoDeRelacion()));
                    FDR2.setAbreviatura(this.relacionesF[x2].getAbreviatura());
                    FDR2.setIdFamiliograma(this.idEncabezado);
                    FDR2.setEstado(true);
                    FDR2.setIdIUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                    this.xDetalleRelacionDAO.mCreate(FDR2);
                }
                return;
            }
            return;
        }
        if (this.jTabbedPane1.getSelectedComponent().getName().equals("Ecomapa")) {
            if (this.xguardadoE == 0) {
                if (this.idEncabezado != 0) {
                    if (this.JTDetalleE.getRowCount() > 0) {
                        int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n3 == 0) {
                            for (int j = 0; j < this.JTDetalleE.getRowCount(); j++) {
                                FamiliogramaEntornoDTO xEntorno = new FamiliogramaEntornoDTO();
                                xEntorno.setIdfamiliograma(this.idEncabezado);
                                xEntorno.setIdEntorno(Integer.parseInt(this.xmodeloE.getValueAt(j, 2).toString()));
                                xEntorno.setIdTipoRelacion(Integer.parseInt(this.xmodeloE.getValueAt(j, 4).toString()));
                                xEntorno.setEstado(((Boolean) this.xmodeloE.getValueAt(j, 6)).booleanValue());
                                xEntorno.setAbreviatura("NN");
                                xEntorno.setIdUsuario(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString()));
                                this.xFamiliogramaEntornoDAO.mCreate(xEntorno);
                                this.xguardadoE = 1;
                            }
                            return;
                        }
                        return;
                    }
                    this.xmt.mostrarMensaje("el Ecomapa debe tener todas sus relaciones");
                    return;
                }
                this.xmt.mostrarMensaje("Se debe desarrollar primero el familiograma");
                return;
            }
            this.xmt.mostrarMensaje("Ya esta atencion cuenta con un Ecomapa");
        }
    }

    private String traerFecha(String fecha) {
        String dia = fecha.substring(8, 10);
        String mes = fecha.substring(5, 7);
        String year = fecha.substring(0, 4);
        return "" + year + "-" + mes + "-" + dia;
    }

    private int InsertarPaciente(int id) {
        Paciente();
        FamiliogramaDetalleDTO detalle = new FamiliogramaDetalleDTO();
        detalle.setIdFamiliograma(id);
        detalle.setNombre(this.Paciente.getPrimerNom());
        detalle.setIdParentesco(obtenerRolPaciente());
        detalle.setIdSexo(this.Paciente.getSexo());
        detalle.setEdad(this.Paciente.getEdad());
        detalle.setVive(this.Paciente.getVive());
        detalle.setOcupacion(this.Paciente.getOcupacion());
        detalle.setIdestadoCivil(this.Paciente.getIdEstadocivil());
        detalle.setEsPaciente(true);
        detalle.setEsAdoptado(false);
        detalle.setEsGemelo(false);
        detalle.setEstado(true);
        detalle.setUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        int idP = this.xFamiliogramaDetalleDAO.mCreate(detalle);
        return idP;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloHistorico() {
        this.xModeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "idAtencion", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.11
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xModeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(300);
    }

    public void mCargarDatosH() {
        mCrearModeloHistorico();
        List<Object[]> listadoFamiliogramas = this.xFamiliogramaEncabezadoDAO.traerFamiliogramas(this.idPersonaA);
        for (int x = 0; x < listadoFamiliogramas.size(); x++) {
            this.xModeloH.addRow(this.xdatos);
            for (int j = 0; j < 5; j++) {
                this.xModeloH.setValueAt(listadoFamiliogramas.get(x)[j], x, j);
            }
        }
    }

    public void actualizarModelo(int id) {
        List<Object[]> listadoDetalle = this.xFamiliogramaDetalleDAO.traerfamilia(id);
        for (int x = 0; x < listadoDetalle.size(); x++) {
            if (((Boolean) listadoDetalle.get(x)[12]).booleanValue()) {
                this.Paciente.setIdPos(((Integer) listadoDetalle.get(x)[0]).intValue());
            } else {
                this.xmodeloF.setValueAt(listadoDetalle.get(x)[0], x, 0);
            }
        }
        Persona[] familia = casting(this.xmodeloF);
        Relaciones[] Relaciones = armarRelaciones(familia);
        this.relacionesF = Relaciones;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloF() {
        this.xmodeloF = new DefaultTableModel(new Object[0], new String[]{"Id", "IdFamiliograma", "Nombre", "IdParentesco", "Parentesco", "IdSexo", "Sexo", "Edad", "vive?", "Ocupacion", "idTipoRelacion", "Relacion", "idEstadoCivil", "EstadoCivil", "Embarazo", "esAdoptada", "esGemelo", "Estado", "idRelacion", "TipoTiempoEdad"}) { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.12
            Class[] types = {Integer.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodeloF);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(70);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloE() {
        this.xmodeloE = new DefaultTableModel(new Object[0], new String[]{"Id", "IdFamiliograma", "IdEntorno", "Entorno", "IdTipoRelacion", "Tipo de relacion", "Estado"}) { // from class: com.genoma.plus.controller.historia.JPAFamiliograma.13
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleE.setModel(this.xmodeloE);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(0).setMinWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(6).setPreferredWidth(70);
    }

    public void mCargarDatosE() {
        mCrearModeloE();
        List<Object[]> ListadoEcomapa = this.xFamiliogramaEntornoDAO.listadoFEntorno(this.idFamiliograma);
        for (int x = 0; x < ListadoEcomapa.size(); x++) {
            this.xmodeloE.addRow(this.xdatosE);
            for (int j = 0; j < 7; j++) {
                this.xmodeloE.setValueAt(ListadoEcomapa.get(x)[j], x, j);
            }
        }
        if (ListadoEcomapa.size() > 0) {
            this.xguardadoE = 1;
            dibujarGraficoE();
        } else {
            this.xguardadoE = 0;
            dibujarGraficoE();
        }
    }
}
