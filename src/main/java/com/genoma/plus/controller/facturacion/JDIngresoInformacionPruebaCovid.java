package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.controller.utilidades.GeneracionFichaTomaMuestraCovid19;
import com.genoma.plus.controller.utilidades.GeneracionFichaTomaMuestraCovid19_Nueva;
import com.genoma.plus.jpa.entities.IngresoPruebaCovidDTO;
import com.genoma.plus.jpa.entities.IngresoPruebaCovidDetalleViajeDTO;
import com.genoma.plus.jpa.service.IIngresoPruebaCovidDetalleViajeService;
import com.genoma.plus.jpa.service.IIngresoPruebaCovidService;
import com.itextpdf.text.DocumentException;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDIngresoInformacionPruebaCovid.class */
public class JDIngresoInformacionPruebaCovid extends JDialog {
    private IngresoPruebaCovidDTO ingresoPruebaCovidDTO;
    private List<IngresoPruebaCovidDetalleViajeDTO> ingresoPruebaCovidDetalleViajeDTO;
    private final IIngresoPruebaCovidService ingresoPruebaCovidService;
    private final IIngresoPruebaCovidDetalleViajeService ingresoPruebaCovidDetalleViajeService;
    private Long idIngreso;
    private Metodos metodos;
    private String codigoCups;
    private ButtonGroup JBG_FiltroContacto;
    private ButtonGroup JBG_FiltroHospitalizado;
    private ButtonGroup JBG_FiltroTipoContacto;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JButton JBT_Salir1;
    private JCheckBox JCH_Viajo;
    private JDateChooser JDFechaExposicion;
    private JDateChooser JD_4_1_1FechaSintomas;
    private JLabel JLB_3_Titulo;
    private JLabel JLB_4_Titulo2;
    private JLabel JLB_NRegistro;
    private JPanel JPI_3_3TipoContacto;
    private JPanel JPI_4ContactoSintomas;
    private JPanel JPI_4_2Hospitalizado;
    private JRadioButton JRB_3_3NoAplica;
    private JRadioButton JRB_4No;
    private JRadioButton JRB_4NoAplica;
    private JRadioButton JRB_4Si;
    private JRadioButton JRB_4_2No;
    private JRadioButton JRB_4_2NoAplica;
    private JRadioButton JRB_4_2Si;
    private JRadioButton JRB_CCompanero;
    private JRadioButton JRB_CFamiliar;
    private JRadioButton JRB_CPersonalSalud;
    private JRadioButton JRB_CSalaEspera;
    private JRadioButton JRB_CSocial;
    private JScrollPane JSP_DatosViaje;
    private JScrollPane JSP_IntitucionSalud;
    private JTable JTB_InformacionViaje;
    private JTextPane JTP_InstitucionSalud;

    @Generated
    public void setIngresoPruebaCovidDTO(IngresoPruebaCovidDTO ingresoPruebaCovidDTO) {
        this.ingresoPruebaCovidDTO = ingresoPruebaCovidDTO;
    }

    @Generated
    public void setIngresoPruebaCovidDetalleViajeDTO(List<IngresoPruebaCovidDetalleViajeDTO> ingresoPruebaCovidDetalleViajeDTO) {
        this.ingresoPruebaCovidDetalleViajeDTO = ingresoPruebaCovidDetalleViajeDTO;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setCodigoCups(String codigoCups) {
        this.codigoCups = codigoCups;
    }

    @Generated
    public void setJBG_FiltroContacto(ButtonGroup JBG_FiltroContacto) {
        this.JBG_FiltroContacto = JBG_FiltroContacto;
    }

    @Generated
    public void setJBG_FiltroHospitalizado(ButtonGroup JBG_FiltroHospitalizado) {
        this.JBG_FiltroHospitalizado = JBG_FiltroHospitalizado;
    }

    @Generated
    public void setJBG_FiltroTipoContacto(ButtonGroup JBG_FiltroTipoContacto) {
        this.JBG_FiltroTipoContacto = JBG_FiltroTipoContacto;
    }

    @Generated
    public void setJBT_Grabar(JButton JBT_Grabar) {
        this.JBT_Grabar = JBT_Grabar;
    }

    @Generated
    public void setJBT_Salir(JButton JBT_Salir) {
        this.JBT_Salir = JBT_Salir;
    }

    @Generated
    public void setJBT_Salir1(JButton JBT_Salir1) {
        this.JBT_Salir1 = JBT_Salir1;
    }

    @Generated
    public void setJCH_Viajo(JCheckBox JCH_Viajo) {
        this.JCH_Viajo = JCH_Viajo;
    }

    @Generated
    public void setJDFechaExposicion(JDateChooser JDFechaExposicion) {
        this.JDFechaExposicion = JDFechaExposicion;
    }

    @Generated
    public void setJD_4_1_1FechaSintomas(JDateChooser JD_4_1_1FechaSintomas) {
        this.JD_4_1_1FechaSintomas = JD_4_1_1FechaSintomas;
    }

    @Generated
    public void setJLB_3_Titulo(JLabel JLB_3_Titulo) {
        this.JLB_3_Titulo = JLB_3_Titulo;
    }

    @Generated
    public void setJLB_4_Titulo2(JLabel JLB_4_Titulo2) {
        this.JLB_4_Titulo2 = JLB_4_Titulo2;
    }

    @Generated
    public void setJLB_NRegistro(JLabel JLB_NRegistro) {
        this.JLB_NRegistro = JLB_NRegistro;
    }

    @Generated
    public void setJPI_3_3TipoContacto(JPanel JPI_3_3TipoContacto) {
        this.JPI_3_3TipoContacto = JPI_3_3TipoContacto;
    }

    @Generated
    public void setJPI_4ContactoSintomas(JPanel JPI_4ContactoSintomas) {
        this.JPI_4ContactoSintomas = JPI_4ContactoSintomas;
    }

    @Generated
    public void setJPI_4_2Hospitalizado(JPanel JPI_4_2Hospitalizado) {
        this.JPI_4_2Hospitalizado = JPI_4_2Hospitalizado;
    }

    @Generated
    public void setJRB_3_3NoAplica(JRadioButton JRB_3_3NoAplica) {
        this.JRB_3_3NoAplica = JRB_3_3NoAplica;
    }

    @Generated
    public void setJRB_4No(JRadioButton JRB_4No) {
        this.JRB_4No = JRB_4No;
    }

    @Generated
    public void setJRB_4NoAplica(JRadioButton JRB_4NoAplica) {
        this.JRB_4NoAplica = JRB_4NoAplica;
    }

    @Generated
    public void setJRB_4Si(JRadioButton JRB_4Si) {
        this.JRB_4Si = JRB_4Si;
    }

    @Generated
    public void setJRB_4_2No(JRadioButton JRB_4_2No) {
        this.JRB_4_2No = JRB_4_2No;
    }

    @Generated
    public void setJRB_4_2NoAplica(JRadioButton JRB_4_2NoAplica) {
        this.JRB_4_2NoAplica = JRB_4_2NoAplica;
    }

    @Generated
    public void setJRB_4_2Si(JRadioButton JRB_4_2Si) {
        this.JRB_4_2Si = JRB_4_2Si;
    }

    @Generated
    public void setJRB_CCompanero(JRadioButton JRB_CCompanero) {
        this.JRB_CCompanero = JRB_CCompanero;
    }

    @Generated
    public void setJRB_CFamiliar(JRadioButton JRB_CFamiliar) {
        this.JRB_CFamiliar = JRB_CFamiliar;
    }

    @Generated
    public void setJRB_CPersonalSalud(JRadioButton JRB_CPersonalSalud) {
        this.JRB_CPersonalSalud = JRB_CPersonalSalud;
    }

    @Generated
    public void setJRB_CSalaEspera(JRadioButton JRB_CSalaEspera) {
        this.JRB_CSalaEspera = JRB_CSalaEspera;
    }

    @Generated
    public void setJRB_CSocial(JRadioButton JRB_CSocial) {
        this.JRB_CSocial = JRB_CSocial;
    }

    @Generated
    public void setJSP_DatosViaje(JScrollPane JSP_DatosViaje) {
        this.JSP_DatosViaje = JSP_DatosViaje;
    }

    @Generated
    public void setJSP_IntitucionSalud(JScrollPane JSP_IntitucionSalud) {
        this.JSP_IntitucionSalud = JSP_IntitucionSalud;
    }

    @Generated
    public void setJTB_InformacionViaje(JTable JTB_InformacionViaje) {
        this.JTB_InformacionViaje = JTB_InformacionViaje;
    }

    @Generated
    public void setJTP_InstitucionSalud(JTextPane JTP_InstitucionSalud) {
        this.JTP_InstitucionSalud = JTP_InstitucionSalud;
    }

    @Generated
    public IngresoPruebaCovidDTO getIngresoPruebaCovidDTO() {
        return this.ingresoPruebaCovidDTO;
    }

    @Generated
    public List<IngresoPruebaCovidDetalleViajeDTO> getIngresoPruebaCovidDetalleViajeDTO() {
        return this.ingresoPruebaCovidDetalleViajeDTO;
    }

    @Generated
    public IIngresoPruebaCovidService getIngresoPruebaCovidService() {
        return this.ingresoPruebaCovidService;
    }

    @Generated
    public IIngresoPruebaCovidDetalleViajeService getIngresoPruebaCovidDetalleViajeService() {
        return this.ingresoPruebaCovidDetalleViajeService;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public String getCodigoCups() {
        return this.codigoCups;
    }

    public JDIngresoInformacionPruebaCovid(Frame parent, boolean modal, Long idIngreso, String codigoCups) {
        super(parent, modal);
        this.ingresoPruebaCovidService = (IIngresoPruebaCovidService) Principal.contexto.getBean(IIngresoPruebaCovidService.class);
        this.ingresoPruebaCovidDetalleViajeService = (IIngresoPruebaCovidDetalleViajeService) Principal.contexto.getBean(IIngresoPruebaCovidDetalleViajeService.class);
        this.metodos = new Metodos();
        initComponents();
        System.out.println("ingreso:  " + idIngreso);
        setIdIngreso(idIngreso);
        setCodigoCups(codigoCups);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.ingresoPruebaCovidDTO = new IngresoPruebaCovidDTO();
        this.ingresoPruebaCovidDetalleViajeDTO = new ArrayList();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_FiltroContacto = new ButtonGroup();
        this.JBG_FiltroTipoContacto = new ButtonGroup();
        this.JBG_FiltroHospitalizado = new ButtonGroup();
        this.JLB_3_Titulo = new JLabel();
        this.JCH_Viajo = new JCheckBox();
        this.JSP_DatosViaje = new JScrollPane();
        this.JTB_InformacionViaje = new JTable();
        this.JDFechaExposicion = new JDateChooser();
        this.JSP_IntitucionSalud = new JScrollPane();
        this.JTP_InstitucionSalud = new JTextPane();
        this.JLB_4_Titulo2 = new JLabel();
        this.JD_4_1_1FechaSintomas = new JDateChooser();
        this.JPI_4ContactoSintomas = new JPanel();
        this.JRB_4NoAplica = new JRadioButton();
        this.JRB_4Si = new JRadioButton();
        this.JRB_4No = new JRadioButton();
        this.JPI_4_2Hospitalizado = new JPanel();
        this.JRB_4_2NoAplica = new JRadioButton();
        this.JRB_4_2Si = new JRadioButton();
        this.JRB_4_2No = new JRadioButton();
        this.JPI_3_3TipoContacto = new JPanel();
        this.JRB_3_3NoAplica = new JRadioButton();
        this.JRB_CFamiliar = new JRadioButton();
        this.JRB_CCompanero = new JRadioButton();
        this.JRB_CPersonalSalud = new JRadioButton();
        this.JRB_CSalaEspera = new JRadioButton();
        this.JRB_CSocial = new JRadioButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JLB_NRegistro = new JLabel();
        this.JBT_Salir1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("SEGUIMIENTO A CONTACTOS DE CASOS POSITIVOS COVID-19");
        this.JLB_3_Titulo.setFont(new Font("Arial", 1, 14));
        this.JLB_3_Titulo.setForeground(Color.red);
        this.JLB_3_Titulo.setText("3. DESPLAZAMIENTO Y TIPO DE CONTACTO");
        this.JCH_Viajo.setFont(new Font("Arial", 1, 12));
        this.JCH_Viajo.setForeground(Color.blue);
        this.JCH_Viajo.setText("3.1 Viajó en los últimos 14 días?");
        this.JCH_Viajo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.1
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JCH_ViajoActionPerformed(evt);
            }
        });
        this.JSP_DatosViaje.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN SITIO DE VIAJE", 0, 0, new Font("Arial", 1, 12)));
        this.JTB_InformacionViaje.setFont(new Font("Arial", 1, 12));
        this.JTB_InformacionViaje.setModel(new DefaultTableModel(new Object[]{new Object[]{null, "", null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Pais", "Departamento o Estado", "Ciudad o Municipio", "Id"}) { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.2
            Class[] types = {String.class, String.class, String.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        });
        this.JTB_InformacionViaje.setRowHeight(25);
        this.JTB_InformacionViaje.setRowMargin(2);
        this.JTB_InformacionViaje.setSelectionMode(0);
        this.JSP_DatosViaje.setViewportView(this.JTB_InformacionViaje);
        this.JDFechaExposicion.setBorder(BorderFactory.createTitledBorder((Border) null, "3.2 Fecha de posible exposición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaExposicion.setDateFormatString("dd/MM/yyyy");
        this.JDFechaExposicion.setFont(new Font("Arial", 1, 12));
        this.JDFechaExposicion.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JDFechaExposicionPropertyChange(evt);
            }
        });
        this.JSP_IntitucionSalud.setBorder(BorderFactory.createTitledBorder((Border) null, "3.3.1 Si es personal de salud en qué institución labora?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_InstitucionSalud.setFont(new Font("Arial", 1, 12));
        this.JSP_IntitucionSalud.setViewportView(this.JTP_InstitucionSalud);
        this.JLB_4_Titulo2.setFont(new Font("Arial", 1, 14));
        this.JLB_4_Titulo2.setForeground(Color.red);
        this.JLB_4_Titulo2.setText("4. DATOS CLINICOS DEL CONTACTO");
        this.JD_4_1_1FechaSintomas.setBorder(BorderFactory.createTitledBorder((Border) null, "4.1.1 Fecha de inicio de síntomas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JD_4_1_1FechaSintomas.setDateFormatString("dd/MM/yyyy");
        this.JD_4_1_1FechaSintomas.setFont(new Font("Arial", 1, 12));
        this.JD_4_1_1FechaSintomas.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JD_4_1_1FechaSintomasPropertyChange(evt);
            }
        });
        this.JPI_4ContactoSintomas.setBorder(BorderFactory.createTitledBorder((Border) null, "4.1 Contacto con síntomas?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_4ContactoSintomas.setFont(new Font("Arial", 1, 12));
        this.JBG_FiltroContacto.add(this.JRB_4NoAplica);
        this.JRB_4NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_4NoAplica.setSelected(true);
        this.JRB_4NoAplica.setText("-1 No aplica");
        this.JRB_4NoAplica.setName("-1");
        this.JRB_4NoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.5
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4NoAplicaActionPerformed(evt);
            }
        });
        this.JBG_FiltroContacto.add(this.JRB_4Si);
        this.JRB_4Si.setFont(new Font("Arial", 1, 12));
        this.JRB_4Si.setText("1 Si");
        this.JRB_4Si.setName("1");
        this.JRB_4Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.6
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4SiActionPerformed(evt);
            }
        });
        this.JBG_FiltroContacto.add(this.JRB_4No);
        this.JRB_4No.setFont(new Font("Arial", 1, 12));
        this.JRB_4No.setText("2 No");
        this.JRB_4No.setName("2");
        this.JRB_4No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.7
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4NoActionPerformed(evt);
            }
        });
        GroupLayout JPI_4ContactoSintomasLayout = new GroupLayout(this.JPI_4ContactoSintomas);
        this.JPI_4ContactoSintomas.setLayout(JPI_4ContactoSintomasLayout);
        JPI_4ContactoSintomasLayout.setHorizontalGroup(JPI_4ContactoSintomasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_4ContactoSintomasLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_4NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_4Si).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_4No).addContainerGap(-1, 32767)));
        JPI_4ContactoSintomasLayout.setVerticalGroup(JPI_4ContactoSintomasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_4ContactoSintomasLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_4ContactoSintomasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_4NoAplica).addComponent(this.JRB_4Si).addComponent(this.JRB_4No))));
        this.JPI_4_2Hospitalizado.setBorder(BorderFactory.createTitledBorder((Border) null, "4.2 Hospitalizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_4_2Hospitalizado.setFont(new Font("Arial", 1, 12));
        this.JBG_FiltroHospitalizado.add(this.JRB_4_2NoAplica);
        this.JRB_4_2NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_4_2NoAplica.setSelected(true);
        this.JRB_4_2NoAplica.setText("-1 No aplica");
        this.JRB_4_2NoAplica.setName("-1");
        this.JRB_4_2NoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.8
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4_2NoAplicaActionPerformed(evt);
            }
        });
        this.JBG_FiltroHospitalizado.add(this.JRB_4_2Si);
        this.JRB_4_2Si.setFont(new Font("Arial", 1, 12));
        this.JRB_4_2Si.setText("1 Si");
        this.JRB_4_2Si.setName("1");
        this.JRB_4_2Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.9
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4_2SiActionPerformed(evt);
            }
        });
        this.JBG_FiltroHospitalizado.add(this.JRB_4_2No);
        this.JRB_4_2No.setFont(new Font("Arial", 1, 12));
        this.JRB_4_2No.setText("2 No");
        this.JRB_4_2No.setName("2");
        this.JRB_4_2No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.10
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_4_2NoActionPerformed(evt);
            }
        });
        GroupLayout JPI_4_2HospitalizadoLayout = new GroupLayout(this.JPI_4_2Hospitalizado);
        this.JPI_4_2Hospitalizado.setLayout(JPI_4_2HospitalizadoLayout);
        JPI_4_2HospitalizadoLayout.setHorizontalGroup(JPI_4_2HospitalizadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_4_2HospitalizadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_4_2NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_4_2Si).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_4_2No).addContainerGap(26, 32767)));
        JPI_4_2HospitalizadoLayout.setVerticalGroup(JPI_4_2HospitalizadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_4_2HospitalizadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_4_2HospitalizadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_4_2NoAplica).addComponent(this.JRB_4_2Si).addComponent(this.JRB_4_2No))));
        this.JPI_3_3TipoContacto.setBorder(BorderFactory.createTitledBorder((Border) null, "3.3 Tipo de contacto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_FiltroTipoContacto.add(this.JRB_3_3NoAplica);
        this.JRB_3_3NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_3_3NoAplica.setSelected(true);
        this.JRB_3_3NoAplica.setText("-1 No aplica");
        this.JRB_3_3NoAplica.setName("-1");
        this.JRB_3_3NoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.11
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_3_3NoAplicaActionPerformed(evt);
            }
        });
        this.JBG_FiltroTipoContacto.add(this.JRB_CFamiliar);
        this.JRB_CFamiliar.setFont(new Font("Arial", 1, 12));
        this.JRB_CFamiliar.setText("1. Familiar");
        this.JRB_CFamiliar.setName("1");
        this.JRB_CFamiliar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.12
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_CFamiliarActionPerformed(evt);
            }
        });
        this.JBG_FiltroTipoContacto.add(this.JRB_CCompanero);
        this.JRB_CCompanero.setFont(new Font("Arial", 1, 12));
        this.JRB_CCompanero.setText("2. Compañero de vuelo");
        this.JRB_CCompanero.setName("2");
        this.JRB_CCompanero.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.13
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_CCompaneroActionPerformed(evt);
            }
        });
        this.JBG_FiltroTipoContacto.add(this.JRB_CPersonalSalud);
        this.JRB_CPersonalSalud.setFont(new Font("Arial", 1, 12));
        this.JRB_CPersonalSalud.setText("3. Personal de salud");
        this.JRB_CPersonalSalud.setName("3");
        this.JRB_CPersonalSalud.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.14
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_CPersonalSaludActionPerformed(evt);
            }
        });
        this.JBG_FiltroTipoContacto.add(this.JRB_CSalaEspera);
        this.JRB_CSalaEspera.setFont(new Font("Arial", 1, 12));
        this.JRB_CSalaEspera.setText("4. Sala de espera");
        this.JRB_CSalaEspera.setName("4");
        this.JRB_CSalaEspera.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.15
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_CSalaEsperaActionPerformed(evt);
            }
        });
        this.JBG_FiltroTipoContacto.add(this.JRB_CSocial);
        this.JRB_CSocial.setFont(new Font("Arial", 1, 12));
        this.JRB_CSocial.setText("5. Social");
        this.JRB_CSocial.setName("5");
        this.JRB_CSocial.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.16
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JRB_CSocialActionPerformed(evt);
            }
        });
        GroupLayout JPI_3_3TipoContactoLayout = new GroupLayout(this.JPI_3_3TipoContacto);
        this.JPI_3_3TipoContacto.setLayout(JPI_3_3TipoContactoLayout);
        JPI_3_3TipoContactoLayout.setHorizontalGroup(JPI_3_3TipoContactoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_3_3TipoContactoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_3_3TipoContactoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_3_3NoAplica).addComponent(this.JRB_CCompanero).addComponent(this.JRB_CPersonalSalud).addComponent(this.JRB_CSalaEspera).addComponent(this.JRB_CSocial).addComponent(this.JRB_CFamiliar)).addContainerGap(-1, 32767)));
        JPI_3_3TipoContactoLayout.setVerticalGroup(JPI_3_3TipoContactoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_3_3TipoContactoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_3_3NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CFamiliar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CCompanero).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CPersonalSalud).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CSalaEspera).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CSocial).addContainerGap(-1, 32767)));
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setMnemonic('G');
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.setName("JBAdicionaPProcedimiento");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.17
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Grabar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.18
            public void keyPressed(KeyEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JBT_GrabarKeyPressed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setMnemonic('S');
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.setName("JBAdicionaPProcedimiento");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.19
            public void actionPerformed(ActionEvent evt) {
                JDIngresoInformacionPruebaCovid.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registo", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBT_Salir1.setMnemonic('S');
        this.JBT_Salir1.setText("Imprimir");
        this.JBT_Salir1.setName("JBAdicionaPProcedimiento");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid.20
            /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
            public void actionPerformed(ActionEvent evt) throws DocumentException {
                JDIngresoInformacionPruebaCovid.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JCH_Viajo).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_3_Titulo, -1, -1, 32767).addComponent(this.JLB_4_Titulo2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSP_IntitucionSalud, GroupLayout.Alignment.LEADING).addComponent(this.JSP_DatosViaje, GroupLayout.Alignment.LEADING, -1, 491, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaExposicion, -1, -1, 32767).addComponent(this.JPI_3_3TipoContacto, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addComponent(this.JPI_4ContactoSintomas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JD_4_1_1FechaSintomas, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_4_2Hospitalizado, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -2, 150, -2).addGap(62, 62, 62).addComponent(this.JBT_Salir1, -2, 150, -2).addGap(54, 54, 54).addComponent(this.JBT_Salir, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 153, -2))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLB_3_Titulo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Viajo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaExposicion, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_3_3TipoContacto, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JSP_DatosViaje, -2, 195, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_IntitucionSalud))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_4_Titulo2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JD_4_1_1FechaSintomas, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JPI_4ContactoSintomas, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addComponent(this.JPI_4_2Hospitalizado, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addComponent(this.JLB_NRegistro, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CSocialActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (this.JRB_CPersonalSalud.isSelected() && this.JTP_InstitucionSalud.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Nombre de institución de salud no puede estar en blanco ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_InstitucionSalud.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(this, "Esta Seguro de Guardar", "CONFIRMAR", 0, 1);
            if (n == 0) {
                grabar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_3_3NoAplicaActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CFamiliarActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CCompaneroActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CPersonalSaludActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CSalaEsperaActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setTipoContacto(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ViajoActionPerformed(ActionEvent evt) {
        if (this.JCH_Viajo.isSelected()) {
            getIngresoPruebaCovidDTO().setViajo(1);
        } else {
            getIngresoPruebaCovidDTO().setViajo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4NoAplicaActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setContactoSintomas(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4SiActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setContactoSintomas(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4NoActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setContactoSintomas(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4_2NoAplicaActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setHospitalizado(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4_2SiActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setHospitalizado(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4_2NoActionPerformed(ActionEvent evt) {
        getIngresoPruebaCovidDTO().setHospitalizado(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaExposicionPropertyChange(PropertyChangeEvent evt) {
        if (this.JDFechaExposicion.getDate() != null) {
            getIngresoPruebaCovidDTO().setFechaExposicion(this.JDFechaExposicion.getDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD_4_1_1FechaSintomasPropertyChange(PropertyChangeEvent evt) {
        if (this.JD_4_1_1FechaSintomas.getDate() != null) {
            getIngresoPruebaCovidDTO().setFechaInicioSintomas(this.JD_4_1_1FechaSintomas.getDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) throws DocumentException {
        imprimir();
    }

    private void nuevo() {
        setIngresoPruebaCovidDTO(getIngresoPruebaCovidService().findByIdIngresoAndEstado(getIdIngreso(), true));
        if (getIngresoPruebaCovidDTO() == null) {
            this.ingresoPruebaCovidDTO = new IngresoPruebaCovidDTO();
            getIngresoPruebaCovidDTO().setViajo(0);
            getIngresoPruebaCovidDTO().setTipoContacto(-1);
            getIngresoPruebaCovidDTO().setContactoSintomas(-1);
            getIngresoPruebaCovidDTO().setHospitalizado(-1);
            getIngresoPruebaCovidDTO().setTomaMuestra(true);
            getIngresoPruebaCovidDTO().setFechaTomaMuestra(getMetodos().getFechaActual());
            getIngresoPruebaCovidDTO().setEstado(true);
            getIngresoPruebaCovidDTO().setIdUsuariRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            getIngresoPruebaCovidDTO().setIdIngreso(getIdIngreso());
            return;
        }
        this.JLB_NRegistro.setText("" + getIngresoPruebaCovidDTO().getId());
        if (getIngresoPruebaCovidDTO().getViajo().intValue() == 0) {
            this.JCH_Viajo.setSelected(true);
        } else {
            this.JCH_Viajo.setSelected(true);
        }
        this.JDFechaExposicion.setDate(getIngresoPruebaCovidDTO().getFechaExposicion());
        for (int i = 0; i < this.JPI_3_3TipoContacto.getComponentCount(); i++) {
            JRadioButton e = this.JPI_3_3TipoContacto.getComponent(i);
            System.out.println("" + e.getName());
            if (e.getName().equals(getIngresoPruebaCovidDTO().getTipoContacto().toString())) {
                e.setSelected(true);
            }
        }
        for (int i2 = 0; i2 < this.JPI_4ContactoSintomas.getComponentCount(); i2++) {
            JRadioButton e2 = this.JPI_4ContactoSintomas.getComponent(i2);
            System.out.println("" + e2.getName());
            if (e2.getName().equals(getIngresoPruebaCovidDTO().getContactoSintomas().toString())) {
                e2.setSelected(true);
            }
        }
        for (int i3 = 0; i3 < this.JPI_4_2Hospitalizado.getComponentCount(); i3++) {
            JRadioButton e3 = this.JPI_4_2Hospitalizado.getComponent(i3);
            if (e3.getName().equals(getIngresoPruebaCovidDTO().getHospitalizado().toString())) {
                e3.setSelected(true);
            }
        }
        this.JTP_InstitucionSalud.setText(getIngresoPruebaCovidDTO().getInstitucionLabora());
        this.JD_4_1_1FechaSintomas.setDate(getIngresoPruebaCovidDTO().getFechaInicioSintomas());
        setIngresoPruebaCovidDetalleViajeDTO(getIngresoPruebaCovidDetalleViajeService().findByIdPruebaCovid(getIngresoPruebaCovidDTO().getId()));
        for (IngresoPruebaCovidDetalleViajeDTO next : this.ingresoPruebaCovidDetalleViajeDTO) {
            this.JTB_InformacionViaje.setValueAt(next.getPais(), 0, 0);
            this.JTB_InformacionViaje.setValueAt(next.getDepartamento(), 0, 1);
            this.JTB_InformacionViaje.setValueAt(next.getMunicipio(), 0, 2);
            this.JTB_InformacionViaje.setValueAt(next.getId(), 0, 3);
        }
    }

    private void grabar() {
        getIngresoPruebaCovidDTO().setFecha(getMetodos().getFechaActual());
        getIngresoPruebaCovidDTO().setInstitucionLabora(this.JTP_InstitucionSalud.getText());
        this.JLB_NRegistro.setText("" + getIngresoPruebaCovidService().save(this.ingresoPruebaCovidDTO));
        if (getIngresoPruebaCovidDetalleViajeDTO().isEmpty()) {
            for (int i = 0; i < this.JTB_InformacionViaje.getRowCount(); i++) {
                if (this.JTB_InformacionViaje.getValueAt(i, 0) != null) {
                    IngresoPruebaCovidDetalleViajeDTO e = IngresoPruebaCovidDetalleViajeDTO.builder().idPruebaCovid(Long.valueOf(this.JLB_NRegistro.getText())).pais(this.JTB_InformacionViaje.getValueAt(i, 0).toString()).departamento(this.JTB_InformacionViaje.getValueAt(i, 1).toString()).municipio(this.JTB_InformacionViaje.getValueAt(i, 2).toString()).build();
                    getIngresoPruebaCovidDetalleViajeDTO().add(e);
                }
            }
        } else {
            for (int i2 = 0; i2 < this.JTB_InformacionViaje.getRowCount(); i2++) {
                if (this.JTB_InformacionViaje.getValueAt(i2, 0) != null) {
                    for (int y = 0; y < getIngresoPruebaCovidDetalleViajeDTO().size(); y++) {
                        if (this.JTB_InformacionViaje.getValueAt(i2, 3).equals(getIngresoPruebaCovidDetalleViajeDTO().get(i2).getId())) {
                            getIngresoPruebaCovidDetalleViajeDTO().get(i2).setPais(this.JTB_InformacionViaje.getValueAt(i2, 0).toString());
                            getIngresoPruebaCovidDetalleViajeDTO().get(i2).setDepartamento(this.JTB_InformacionViaje.getValueAt(i2, 1).toString());
                            getIngresoPruebaCovidDetalleViajeDTO().get(i2).setMunicipio(this.JTB_InformacionViaje.getValueAt(i2, 2).toString());
                        }
                    }
                }
            }
        }
        getIngresoPruebaCovidDetalleViajeService().save(this.ingresoPruebaCovidDetalleViajeDTO);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void imprimir() throws DocumentException {
        if (!this.JLB_NRegistro.getText().isEmpty()) {
            if (getCodigoCups().equals("906270") || getCodigoCups().equals("10027") || getCodigoCups().equals("30025")) {
                GeneracionFichaTomaMuestraCovid19 generacionFichaTomaMuestraCovid19 = new GeneracionFichaTomaMuestraCovid19(Long.valueOf(this.JLB_NRegistro.getText()));
                generacionFichaTomaMuestraCovid19.generarPdf();
            } else if (getCodigoCups().equals("906340") || getCodigoCups().equals("1900000") || getCodigoCups().equals("908856")) {
                GeneracionFichaTomaMuestraCovid19_Nueva generacionFichaTomaMuestraCovid192 = new GeneracionFichaTomaMuestraCovid19_Nueva(Long.valueOf(this.JLB_NRegistro.getText()));
                generacionFichaTomaMuestraCovid192.generarPdf();
            }
        }
    }

    @Generated
    public ButtonGroup getJBG_FiltroContacto() {
        return this.JBG_FiltroContacto;
    }

    @Generated
    public ButtonGroup getJBG_FiltroHospitalizado() {
        return this.JBG_FiltroHospitalizado;
    }

    @Generated
    public ButtonGroup getJBG_FiltroTipoContacto() {
        return this.JBG_FiltroTipoContacto;
    }

    @Generated
    public JButton getJBT_Grabar() {
        return this.JBT_Grabar;
    }

    @Generated
    public JButton getJBT_Salir() {
        return this.JBT_Salir;
    }

    @Generated
    public JButton getJBT_Salir1() {
        return this.JBT_Salir1;
    }

    @Generated
    public JCheckBox getJCH_Viajo() {
        return this.JCH_Viajo;
    }

    @Generated
    public JDateChooser getJDFechaExposicion() {
        return this.JDFechaExposicion;
    }

    @Generated
    public JDateChooser getJD_4_1_1FechaSintomas() {
        return this.JD_4_1_1FechaSintomas;
    }

    @Generated
    public JLabel getJLB_3_Titulo() {
        return this.JLB_3_Titulo;
    }

    @Generated
    public JLabel getJLB_4_Titulo2() {
        return this.JLB_4_Titulo2;
    }

    @Generated
    public JLabel getJLB_NRegistro() {
        return this.JLB_NRegistro;
    }

    @Generated
    public JPanel getJPI_3_3TipoContacto() {
        return this.JPI_3_3TipoContacto;
    }

    @Generated
    public JPanel getJPI_4ContactoSintomas() {
        return this.JPI_4ContactoSintomas;
    }

    @Generated
    public JPanel getJPI_4_2Hospitalizado() {
        return this.JPI_4_2Hospitalizado;
    }

    @Generated
    public JRadioButton getJRB_3_3NoAplica() {
        return this.JRB_3_3NoAplica;
    }

    @Generated
    public JRadioButton getJRB_4No() {
        return this.JRB_4No;
    }

    @Generated
    public JRadioButton getJRB_4NoAplica() {
        return this.JRB_4NoAplica;
    }

    @Generated
    public JRadioButton getJRB_4Si() {
        return this.JRB_4Si;
    }

    @Generated
    public JRadioButton getJRB_4_2No() {
        return this.JRB_4_2No;
    }

    @Generated
    public JRadioButton getJRB_4_2NoAplica() {
        return this.JRB_4_2NoAplica;
    }

    @Generated
    public JRadioButton getJRB_4_2Si() {
        return this.JRB_4_2Si;
    }

    @Generated
    public JRadioButton getJRB_CCompanero() {
        return this.JRB_CCompanero;
    }

    @Generated
    public JRadioButton getJRB_CFamiliar() {
        return this.JRB_CFamiliar;
    }

    @Generated
    public JRadioButton getJRB_CPersonalSalud() {
        return this.JRB_CPersonalSalud;
    }

    @Generated
    public JRadioButton getJRB_CSalaEspera() {
        return this.JRB_CSalaEspera;
    }

    @Generated
    public JRadioButton getJRB_CSocial() {
        return this.JRB_CSocial;
    }

    @Generated
    public JScrollPane getJSP_DatosViaje() {
        return this.JSP_DatosViaje;
    }

    @Generated
    public JScrollPane getJSP_IntitucionSalud() {
        return this.JSP_IntitucionSalud;
    }

    @Generated
    public JTable getJTB_InformacionViaje() {
        return this.JTB_InformacionViaje;
    }

    @Generated
    public JTextPane getJTP_InstitucionSalud() {
        return this.JTP_InstitucionSalud;
    }
}
