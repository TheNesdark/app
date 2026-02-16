package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.GeneracionAnexoTecnico1;
import com.genoma.plus.jpa.entities.IngresoAnexo1DTO;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.service.IIngresoAnexo1Service;
import com.genoma.plus.jpa.service.IMunicipioService;
import com.genoma.plus.jpa.service.ITipoIdentificacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo1.class */
public class JPI_FormularioAnexo1 extends JPanel {
    private Long idIngreso;
    private IngresoAnexo1DTO ingresoAnexo1DTO;
    private List<MunicipioDTO> municipioDTOs;
    private List<TipoIdentificacionDTO> tipoIdentificacionDTOs;
    private ButtonGroup JBG_Filtro;
    private JComboBox JCB_Municipio;
    private JComboBox JCB_TipoDocumento;
    private JComboBox JCB_TipoDocumento_nuevo;
    private JCheckBox JCH_Pregunta1;
    private JCheckBox JCH_Pregunta2;
    public JCheckBox JCH_TraerDatos;
    private JDateChooser JD_FechaNacimiento;
    private JDateChooser JD_FechaNacimiento_nuevo;
    private JLabel JLB_Consecutivo;
    private JLabel JLB_IdTabla;
    private JPanel JPI_InformacionUBD;
    private JPanel JPI_InformacionUDocumento;
    private JScrollPane JSP_Observacion;
    public JFormattedTextField JTF_Apellido1;
    public JFormattedTextField JTF_Apellido1_nuevo;
    public JFormattedTextField JTF_Apellido2;
    public JFormattedTextField JTF_Apellido2_nuevo;
    public JTextField JTF_Direccion;
    public JFormattedTextField JTF_Documento;
    public JFormattedTextField JTF_Documento_nuevo;
    public JFormattedTextField JTF_Nombre1;
    public JFormattedTextField JTF_Nombre1_nuevo;
    public JFormattedTextField JTF_Nombre2;
    public JFormattedTextField JTF_Nombre2_nuevo;
    public JTextField JTF_Telefono;
    private JTabbedPane JTP_DatosAnexo;
    public JTextPane JTP_Observacion;
    private final IIngresoAnexo1Service ingresoAnexo1Service = (IIngresoAnexo1Service) Principal.contexto.getBean(IIngresoAnexo1Service.class);
    private final IMunicipioService municipioService = (IMunicipioService) Principal.contexto.getBean(IMunicipioService.class);
    private final ITipoIdentificacionService tipoIdentificacionService = (ITipoIdentificacionService) Principal.contexto.getBean(ITipoIdentificacionService.class);
    private Metodos metodos = new Metodos();
    private Integer tipo = -1;

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setIngresoAnexo1DTO(IngresoAnexo1DTO ingresoAnexo1DTO) {
        this.ingresoAnexo1DTO = ingresoAnexo1DTO;
    }

    @Generated
    public void setMunicipioDTOs(List<MunicipioDTO> municipioDTOs) {
        this.municipioDTOs = municipioDTOs;
    }

    @Generated
    public void setTipoIdentificacionDTOs(List<TipoIdentificacionDTO> tipoIdentificacionDTOs) {
        this.tipoIdentificacionDTOs = tipoIdentificacionDTOs;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJCB_Municipio(JComboBox JCB_Municipio) {
        this.JCB_Municipio = JCB_Municipio;
    }

    @Generated
    public void setJCB_TipoDocumento(JComboBox JCB_TipoDocumento) {
        this.JCB_TipoDocumento = JCB_TipoDocumento;
    }

    @Generated
    public void setJCB_TipoDocumento_nuevo(JComboBox JCB_TipoDocumento_nuevo) {
        this.JCB_TipoDocumento_nuevo = JCB_TipoDocumento_nuevo;
    }

    @Generated
    public void setJCH_Pregunta1(JCheckBox JCH_Pregunta1) {
        this.JCH_Pregunta1 = JCH_Pregunta1;
    }

    @Generated
    public void setJCH_Pregunta2(JCheckBox JCH_Pregunta2) {
        this.JCH_Pregunta2 = JCH_Pregunta2;
    }

    @Generated
    public void setJCH_TraerDatos(JCheckBox JCH_TraerDatos) {
        this.JCH_TraerDatos = JCH_TraerDatos;
    }

    @Generated
    public void setJD_FechaNacimiento(JDateChooser JD_FechaNacimiento) {
        this.JD_FechaNacimiento = JD_FechaNacimiento;
    }

    @Generated
    public void setJD_FechaNacimiento_nuevo(JDateChooser JD_FechaNacimiento_nuevo) {
        this.JD_FechaNacimiento_nuevo = JD_FechaNacimiento_nuevo;
    }

    @Generated
    public void setJLB_Consecutivo(JLabel JLB_Consecutivo) {
        this.JLB_Consecutivo = JLB_Consecutivo;
    }

    @Generated
    public void setJLB_IdTabla(JLabel JLB_IdTabla) {
        this.JLB_IdTabla = JLB_IdTabla;
    }

    @Generated
    public void setJPI_InformacionUBD(JPanel JPI_InformacionUBD) {
        this.JPI_InformacionUBD = JPI_InformacionUBD;
    }

    @Generated
    public void setJPI_InformacionUDocumento(JPanel JPI_InformacionUDocumento) {
        this.JPI_InformacionUDocumento = JPI_InformacionUDocumento;
    }

    @Generated
    public void setJSP_Observacion(JScrollPane JSP_Observacion) {
        this.JSP_Observacion = JSP_Observacion;
    }

    @Generated
    public void setJTF_Apellido1(JFormattedTextField JTF_Apellido1) {
        this.JTF_Apellido1 = JTF_Apellido1;
    }

    @Generated
    public void setJTF_Apellido1_nuevo(JFormattedTextField JTF_Apellido1_nuevo) {
        this.JTF_Apellido1_nuevo = JTF_Apellido1_nuevo;
    }

    @Generated
    public void setJTF_Apellido2(JFormattedTextField JTF_Apellido2) {
        this.JTF_Apellido2 = JTF_Apellido2;
    }

    @Generated
    public void setJTF_Apellido2_nuevo(JFormattedTextField JTF_Apellido2_nuevo) {
        this.JTF_Apellido2_nuevo = JTF_Apellido2_nuevo;
    }

    @Generated
    public void setJTF_Direccion(JTextField JTF_Direccion) {
        this.JTF_Direccion = JTF_Direccion;
    }

    @Generated
    public void setJTF_Documento(JFormattedTextField JTF_Documento) {
        this.JTF_Documento = JTF_Documento;
    }

    @Generated
    public void setJTF_Documento_nuevo(JFormattedTextField JTF_Documento_nuevo) {
        this.JTF_Documento_nuevo = JTF_Documento_nuevo;
    }

    @Generated
    public void setJTF_Nombre1(JFormattedTextField JTF_Nombre1) {
        this.JTF_Nombre1 = JTF_Nombre1;
    }

    @Generated
    public void setJTF_Nombre1_nuevo(JFormattedTextField JTF_Nombre1_nuevo) {
        this.JTF_Nombre1_nuevo = JTF_Nombre1_nuevo;
    }

    @Generated
    public void setJTF_Nombre2(JFormattedTextField JTF_Nombre2) {
        this.JTF_Nombre2 = JTF_Nombre2;
    }

    @Generated
    public void setJTF_Nombre2_nuevo(JFormattedTextField JTF_Nombre2_nuevo) {
        this.JTF_Nombre2_nuevo = JTF_Nombre2_nuevo;
    }

    @Generated
    public void setJTF_Telefono(JTextField JTF_Telefono) {
        this.JTF_Telefono = JTF_Telefono;
    }

    @Generated
    public void setJTP_DatosAnexo(JTabbedPane JTP_DatosAnexo) {
        this.JTP_DatosAnexo = JTP_DatosAnexo;
    }

    @Generated
    public void setJTP_Observacion(JTextPane JTP_Observacion) {
        this.JTP_Observacion = JTP_Observacion;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public IngresoAnexo1DTO getIngresoAnexo1DTO() {
        return this.ingresoAnexo1DTO;
    }

    @Generated
    public IIngresoAnexo1Service getIngresoAnexo1Service() {
        return this.ingresoAnexo1Service;
    }

    @Generated
    public IMunicipioService getMunicipioService() {
        return this.municipioService;
    }

    @Generated
    public ITipoIdentificacionService getTipoIdentificacionService() {
        return this.tipoIdentificacionService;
    }

    @Generated
    public List<MunicipioDTO> getMunicipioDTOs() {
        return this.municipioDTOs;
    }

    @Generated
    public List<TipoIdentificacionDTO> getTipoIdentificacionDTOs() {
        return this.tipoIdentificacionDTOs;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public Integer getTipo() {
        return this.tipo;
    }

    public JPI_FormularioAnexo1(Long idIngreso) {
        initComponents();
        setIdIngreso(idIngreso);
        nuevo();
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JTP_DatosAnexo = new JTabbedPane();
        this.JPI_InformacionUBD = new JPanel();
        this.JCB_TipoDocumento = new JComboBox();
        this.JTF_Documento = new JFormattedTextField();
        this.JTF_Apellido1 = new JFormattedTextField();
        this.JTF_Apellido2 = new JFormattedTextField();
        this.JTF_Nombre1 = new JFormattedTextField();
        this.JTF_Nombre2 = new JFormattedTextField();
        this.JD_FechaNacimiento = new JDateChooser();
        this.JTF_Direccion = new JTextField();
        this.JCB_Municipio = new JComboBox();
        this.JTF_Telefono = new JTextField();
        this.JCH_TraerDatos = new JCheckBox();
        this.JLB_IdTabla = new JLabel();
        this.JLB_Consecutivo = new JLabel();
        this.JPI_InformacionUDocumento = new JPanel();
        this.JCH_Pregunta1 = new JCheckBox();
        this.JCH_Pregunta2 = new JCheckBox();
        this.JTF_Apellido1_nuevo = new JFormattedTextField();
        this.JTF_Apellido2_nuevo = new JFormattedTextField();
        this.JTF_Nombre1_nuevo = new JFormattedTextField();
        this.JTF_Nombre2_nuevo = new JFormattedTextField();
        this.JCB_TipoDocumento_nuevo = new JComboBox();
        this.JTF_Documento_nuevo = new JFormattedTextField();
        this.JD_FechaNacimiento_nuevo = new JDateChooser();
        this.JSP_Observacion = new JScrollPane();
        this.JTP_Observacion = new JTextPane();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ANEXO 1", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpi_ingresoAnexo1");
        this.JTP_DatosAnexo.setForeground(Color.red);
        this.JTP_DatosAnexo.setFont(new Font("Arial", 1, 14));
        this.JPI_InformacionUBD.setFont(new Font("Arial", 1, 14));
        this.JCB_TipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_Documento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Documento.setFont(new Font("Arial", 1, 12));
        this.JTF_Apellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Apellido1.setFont(new Font("Arial", 1, 12));
        this.JTF_Apellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Apellido2.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Nombre1.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Nombre2.setFont(new Font("Arial", 1, 12));
        this.JD_FechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JD_FechaNacimiento.setDateFormatString("dd/MM/yyyy");
        this.JD_FechaNacimiento.setFont(new Font("Arial", 1, 12));
        this.JTF_Direccion.setFont(new Font("Arial", 1, 12));
        this.JTF_Direccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Municipio.setFont(new Font("Arial", 1, 12));
        this.JCB_Municipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_Telefono.setFont(new Font("Arial", 1, 12));
        this.JTF_Telefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_TraerDatos.setFont(new Font("Arial", 1, 12));
        this.JCH_TraerDatos.setText("Traer datos de usuario?");
        this.JCH_TraerDatos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1.1
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo1.this.JCH_TraerDatosActionPerformed(evt);
            }
        });
        this.JLB_IdTabla.setFont(new Font("Arial", 1, 14));
        this.JLB_IdTabla.setHorizontalAlignment(0);
        this.JLB_IdTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB_Consecutivo.setFont(new Font("Arial", 1, 14));
        this.JLB_Consecutivo.setHorizontalAlignment(0);
        this.JLB_Consecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_InformacionUBDLayout = new GroupLayout(this.JPI_InformacionUBD);
        this.JPI_InformacionUBD.setLayout(JPI_InformacionUBDLayout);
        JPI_InformacionUBDLayout.setHorizontalGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JCB_Municipio, -2, 278, -2).addContainerGap(514, 32767)).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JCB_TipoDocumento, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Documento, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_TraerDatos).addGap(41, 41, 41)).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionUBDLayout.createSequentialGroup().addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JLB_IdTabla, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_Consecutivo, -2, 121, -2)).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JD_FechaNacimiento, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Direccion, -2, 422, -2).addGap(18, 18, 18).addComponent(this.JTF_Telefono)).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JTF_Apellido1, -2, 169, -2).addGap(18, 18, 18).addComponent(this.JTF_Apellido2, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_Nombre1, -2, 169, -2).addGap(18, 18, 18).addComponent(this.JTF_Nombre2, -2, 169, -2))).addGap(18, 18, 18)))));
        JPI_InformacionUBDLayout.setVerticalGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_Documento, -2, 47, -2).addComponent(this.JCB_TipoDocumento, -2, -1, -2).addComponent(this.JCH_TraerDatos)).addGap(18, 18, 18).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Apellido1, -2, 47, -2).addComponent(this.JTF_Apellido2, -2, 47, -2).addComponent(this.JTF_Nombre1, -2, 47, -2).addComponent(this.JTF_Nombre2, -2, 47, -2)).addGap(26, 26, 26).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JD_FechaNacimiento, -2, 50, -2).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Direccion, -2, 47, -2).addComponent(this.JTF_Telefono, -2, 47, -2))).addGap(28, 28, 28).addComponent(this.JCB_Municipio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, 32767).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_IdTabla, -2, 50, -2).addComponent(this.JLB_Consecutivo, -2, 50, -2)).addGap(28, 28, 28)));
        this.JTP_DatosAnexo.addTab("DATOS DEL USUARIO (como aparece en la base de datos)", this.JPI_InformacionUBD);
        this.JPI_InformacionUDocumento.setFont(new Font("Arial", 1, 14));
        this.JBG_Filtro.add(this.JCH_Pregunta1);
        this.JCH_Pregunta1.setFont(new Font("Arial", 1, 12));
        this.JCH_Pregunta1.setText("El usuario no existe en la base de datos");
        this.JCH_Pregunta1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1.2
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo1.this.JCH_Pregunta1ActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCH_Pregunta2);
        this.JCH_Pregunta2.setFont(new Font("Arial", 1, 12));
        this.JCH_Pregunta2.setText("<html><P ALIGN=center>Los datos del usuario no corresponden con los del documento de identificación presentado");
        this.JCH_Pregunta2.setActionCommand("Historial de viaje o que haya vivido en un pais o área con circulación viral confirmada del nuevo coronavirus (SARS-CoV-2) en los 14 dias anteriores al inicio de los síntomas.");
        this.JCH_Pregunta2.setHorizontalAlignment(11);
        this.JCH_Pregunta2.setVerticalTextPosition(1);
        this.JCH_Pregunta2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1.3
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo1.this.JCH_Pregunta2ActionPerformed(evt);
            }
        });
        this.JTF_Apellido1_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Apellido1_nuevo.setFont(new Font("Arial", 1, 12));
        this.JTF_Apellido2_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Apellido2_nuevo.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre1_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Nombre1_nuevo.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre2_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Nombre2_nuevo.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDocumento_nuevo.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDocumento_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_Documento_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Documento_nuevo.setFont(new Font("Arial", 1, 12));
        this.JD_FechaNacimiento_nuevo.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JD_FechaNacimiento_nuevo.setDateFormatString("dd/MM/yyyy");
        this.JD_FechaNacimiento_nuevo.setFont(new Font("Arial", 1, 12));
        this.JSP_Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Observacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1.4
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo1.this.JTP_ObservacionKeyPressed(evt);
            }
        });
        this.JSP_Observacion.setViewportView(this.JTP_Observacion);
        GroupLayout JPI_InformacionUDocumentoLayout = new GroupLayout(this.JPI_InformacionUDocumento);
        this.JPI_InformacionUDocumento.setLayout(JPI_InformacionUDocumentoLayout);
        JPI_InformacionUDocumentoLayout.setHorizontalGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUDocumentoLayout.createSequentialGroup().addGap(47, 47, 47).addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_InformacionUDocumentoLayout.createSequentialGroup().addComponent(this.JTF_Apellido1_nuevo, -2, 281, -2).addGap(118, 118, 118).addComponent(this.JCB_TipoDocumento_nuevo, -2, 287, -2)).addGroup(JPI_InformacionUDocumentoLayout.createSequentialGroup().addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTF_Nombre1_nuevo).addComponent(this.JTF_Apellido2_nuevo).addComponent(this.JTF_Nombre2_nuevo, GroupLayout.Alignment.LEADING, -2, 281, -2)).addGap(118, 118, 118).addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_Documento_nuevo).addGroup(JPI_InformacionUDocumentoLayout.createSequentialGroup().addComponent(this.JD_FechaNacimiento_nuevo, -2, 172, -2).addGap(0, 0, 32767)))).addComponent(this.JSP_Observacion, -2, 686, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionUDocumentoLayout.createSequentialGroup().addContainerGap(44, 32767).addComponent(this.JCH_Pregunta1).addGap(18, 18, 18).addComponent(this.JCH_Pregunta2, -2, 473, -2).addContainerGap()));
        JPI_InformacionUDocumentoLayout.setVerticalGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionUDocumentoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUDocumentoLayout.createSequentialGroup().addComponent(this.JCH_Pregunta1).addGap(0, 17, 32767)).addComponent(this.JCH_Pregunta2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoDocumento_nuevo, -2, -1, -2).addComponent(this.JTF_Apellido1_nuevo, -2, 47, -2)).addGap(18, 18, 18).addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Apellido2_nuevo, -2, 47, -2).addComponent(this.JTF_Documento_nuevo, -2, 47, -2)).addGap(18, 18, 18).addGroup(JPI_InformacionUDocumentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_Nombre1_nuevo, -2, 47, -2).addComponent(this.JD_FechaNacimiento_nuevo, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JTF_Nombre2_nuevo, -2, 47, -2).addGap(18, 18, 18).addComponent(this.JSP_Observacion, -2, 67, -2).addContainerGap()));
        this.JTP_DatosAnexo.addTab("<html><P ALIGN=center>DATOS DEL USUARIO (Según documento Identidad)", this.JPI_InformacionUDocumento);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(16, 32767).addComponent(this.JTP_DatosAnexo, -2, 819, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTP_DatosAnexo, -2, 442, -2).addContainerGap(26, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservacionKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 9) {
            this.JTP_Observacion.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Observacion.setText(this.JTP_Observacion.getText().substring(0, this.JTP_Observacion.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_TraerDatosActionPerformed(ActionEvent evt) {
        if (this.JCH_TraerDatos.isSelected()) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Pregunta1ActionPerformed(ActionEvent evt) {
        setTipo(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Pregunta2ActionPerformed(ActionEvent evt) {
        setTipo(1);
    }

    public void cargarDatos() {
        this.JCB_TipoDocumento.setSelectedItem(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboTipoIdentificacion.getSelectedItem());
        this.JTF_Documento.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtIdentificacion.getText());
        this.JTF_Apellido1.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido1.getText());
        this.JTF_Apellido2.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido2.getText());
        this.JTF_Nombre1.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre1.getText());
        this.JTF_Nombre2.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre2.getText());
        this.JD_FechaNacimiento.setDate(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboFechaNacimiento.getDate());
        this.JTF_Direccion.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtDireccion.getText());
        this.JTF_Telefono.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtTelefono1.getText());
        this.JCB_Municipio.setSelectedItem(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboMunicipio.getSelectedItem());
        this.JCB_TipoDocumento_nuevo.setSelectedItem(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboTipoIdentificacion.getSelectedItem());
        this.JTF_Documento_nuevo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtIdentificacion.getText());
        this.JTF_Apellido1_nuevo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido1.getText());
        this.JTF_Apellido2_nuevo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido2.getText());
        this.JTF_Nombre1_nuevo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre1.getText());
        this.JTF_Nombre2_nuevo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre2.getText());
        this.JD_FechaNacimiento_nuevo.setDate(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboFechaNacimiento.getDate());
    }

    public void nuevo() {
        setMunicipioDTOs(getMunicipioService().listaMunicipioConcatenadoDepartamentoEstado(false));
        setTipoIdentificacionDTOs(getTipoIdentificacionService().listaTipoIdentificacionPorEstado(false));
        this.JCB_Municipio.removeAllItems();
        getMunicipioDTOs().forEach(municipioDTO -> {
            this.JCB_Municipio.addItem(municipioDTO.getNombre());
        });
        this.JCB_Municipio.setSelectedIndex(-1);
        this.JCB_TipoDocumento.removeAllItems();
        this.JCB_TipoDocumento_nuevo.removeAllItems();
        getTipoIdentificacionDTOs().forEach(identificacionDTO -> {
            this.JCB_TipoDocumento.addItem(identificacionDTO.getNombre());
            this.JCB_TipoDocumento_nuevo.addItem(identificacionDTO.getNombre());
        });
        this.JCB_TipoDocumento.setSelectedIndex(-1);
        this.JCB_TipoDocumento_nuevo.setSelectedIndex(-1);
        setIngresoAnexo1DTO(getIngresoAnexo1Service().anexoUnoPorIdIngreso(getIdIngreso(), true));
        if (getIngresoAnexo1DTO() == null) {
            this.ingresoAnexo1DTO = new IngresoAnexo1DTO();
            return;
        }
        this.JLB_IdTabla.setText("" + getIngresoAnexo1DTO().getId());
        this.JLB_Consecutivo.setText("" + getIngresoAnexo1DTO().getNumeroConsecutivo());
        this.JTF_Documento.setText(getIngresoAnexo1DTO().getNumeroIdentificacion());
        this.JTF_Apellido1.setText(getIngresoAnexo1DTO().getPrimerApellido());
        this.JTF_Apellido2.setText(getIngresoAnexo1DTO().getSegundoApellido());
        this.JTF_Nombre1.setText(getIngresoAnexo1DTO().getPrimerNombre());
        this.JTF_Nombre2.setText(getIngresoAnexo1DTO().getSegundoNombre());
        this.JD_FechaNacimiento.setDate(getIngresoAnexo1DTO().getFechaNacimiento());
        this.JTF_Direccion.setText(getIngresoAnexo1DTO().getDireccion());
        this.JTF_Telefono.setText(getIngresoAnexo1DTO().getTelefono());
        llenerCombosTipoDocumento(getIngresoAnexo1DTO().getIdTipoIdentificacion(), this.JCB_TipoDocumento);
        llenerCombosDatosMunicipio(getIngresoAnexo1DTO().getIdMunicipio(), this.JCB_Municipio);
        if (getIngresoAnexo1DTO().getTipo().intValue() == 0) {
            this.JCH_Pregunta1.setSelected(true);
        } else {
            this.JCH_Pregunta2.setSelected(true);
        }
        this.JTF_Documento_nuevo.setText(getIngresoAnexo1DTO().getNumeroIdentificacionInconsistencia());
        this.JTF_Apellido1_nuevo.setText(getIngresoAnexo1DTO().getPrimerApellidoInconsistencia());
        this.JTF_Apellido2_nuevo.setText(getIngresoAnexo1DTO().getSegundoApellidoInconsistencia());
        this.JTF_Nombre1_nuevo.setText(getIngresoAnexo1DTO().getPrimerNombreInconsistencia());
        this.JTF_Nombre2_nuevo.setText(getIngresoAnexo1DTO().getSegundoNombreInconsistencia());
        this.JD_FechaNacimiento_nuevo.setDate(getIngresoAnexo1DTO().getFechaNacimientoInconsistencia());
        this.JTP_Observacion.setText(getIngresoAnexo1DTO().getObservacion());
        llenerCombosTipoDocumento(getIngresoAnexo1DTO().getIdTipoIdentificacionInconsistencia(), this.JCB_TipoDocumento_nuevo);
    }

    private void llenerCombosDatosMunicipio(String datos, JComboBox e) {
        for (MunicipioDTO municipioDTO : this.municipioDTOs) {
            if (municipioDTO.getId().equals(datos)) {
                e.setSelectedItem(municipioDTO.getNombre());
                return;
            }
        }
    }

    private void llenerCombosTipoDocumento(String datos, JComboBox e) {
        for (TipoIdentificacionDTO tipoIdentificacionDTO : this.tipoIdentificacionDTOs) {
            if (tipoIdentificacionDTO.getId().equals(datos)) {
                e.setSelectedItem(tipoIdentificacionDTO.getNombre());
                return;
            }
        }
    }

    public void grabar() {
        if (getIngresoAnexo1DTO().getId() == null) {
            if (this.JCB_TipoDocumento.getSelectedIndex() != -1) {
                if (!this.JTF_Documento.getText().isEmpty()) {
                    if (!this.JTF_Apellido1.getText().isEmpty()) {
                        if (!this.JTF_Nombre1.getText().isEmpty()) {
                            if (this.JCB_Municipio.getSelectedIndex() != -1) {
                                int n = JOptionPane.showInternalConfirmDialog(Principal.clasefacturacion.xjiliqServicio, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    getIngresoAnexo1DTO().setNumeroConsecutivo(new Long(0L));
                                    getIngresoAnexo1DTO().setFechaHora(getMetodos().getFechaActual());
                                    getIngresoAnexo1DTO().setIdIngreso(getIdIngreso());
                                    getIngresoAnexo1DTO().setTipo(getTipo());
                                    getIngresoAnexo1DTO().setIdTipoIdentificacion(getTipoIdentificacionDTOs().get(this.JCB_TipoDocumento.getSelectedIndex()).getId());
                                    getIngresoAnexo1DTO().setNumeroIdentificacion(this.JTF_Documento.getText());
                                    getIngresoAnexo1DTO().setPrimerApellido(this.JTF_Apellido1.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setSegundoApellido(this.JTF_Apellido2.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setSegundoNombre(this.JTF_Nombre2.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setPrimerNombre(this.JTF_Nombre1.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setFechaNacimiento(this.JD_FechaNacimiento.getDate());
                                    getIngresoAnexo1DTO().setDireccion(this.JTF_Direccion.getText());
                                    getIngresoAnexo1DTO().setTelefono(this.JTF_Telefono.getText());
                                    getIngresoAnexo1DTO().setIdMunicipio(this.municipioDTOs.get(this.JCB_Municipio.getSelectedIndex()).getId());
                                    getIngresoAnexo1DTO().setIdTipoIdentificacionInconsistencia(getTipoIdentificacionDTOs().get(this.JCB_TipoDocumento.getSelectedIndex()).getId());
                                    getIngresoAnexo1DTO().setNumeroIdentificacionInconsistencia(this.JTF_Documento_nuevo.getText());
                                    getIngresoAnexo1DTO().setPrimerApellidoInconsistencia(this.JTF_Apellido1_nuevo.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setSegundoApellidoInconsistencia(this.JTF_Apellido2_nuevo.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setSegundoNombreInconsistencia(this.JTF_Nombre2_nuevo.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setPrimerNombreInconsistencia(this.JTF_Nombre1_nuevo.getText().toUpperCase());
                                    getIngresoAnexo1DTO().setFechaNacimientoInconsistencia(this.JD_FechaNacimiento_nuevo.getDate());
                                    getIngresoAnexo1DTO().setEstado(Boolean.TRUE);
                                    getIngresoAnexo1DTO().setObservacion(this.JTP_Observacion.getText());
                                    getIngresoAnexo1DTO().setIdPersonaCargo(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                    this.JLB_IdTabla.setText("" + this.ingresoAnexo1Service.grabar(this.ingresoAnexo1DTO));
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Debe seleccionar municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCB_Municipio.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Primer nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTF_Nombre1.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Primer apellido no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_Apellido1.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Documento no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_Documento.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(Principal.clasefacturacion.xjiliqServicio, "Debe seleccionar tipo documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_TipoDocumento.requestFocus();
        }
    }

    public void imprimir() {
        if (!this.JLB_IdTabla.getText().isEmpty()) {
            GeneracionAnexoTecnico1 generacionAnexoTecnico1 = new GeneracionAnexoTecnico1(Long.valueOf(this.JLB_IdTabla.getText()));
            generacionAnexoTecnico1.generarPdf();
        }
    }

    public void anular() {
        if (!this.JLB_IdTabla.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "ANULACIÓN DE ANEXO TECNICO 1", 5);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void anularDetalle(String conceptoAnulacion, String detalleAnulacion) {
        getIngresoAnexo1DTO().setEstado(Boolean.FALSE);
        getIngresoAnexo1DTO().setConceptoAnulacion(conceptoAnulacion);
        getIngresoAnexo1DTO().setObservacionAnulacion(detalleAnulacion);
        getIngresoAnexo1DTO().setFechaAnulacion(getMetodos().getFechaActual());
        getIngresoAnexo1DTO().setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.JLB_IdTabla.setText("" + this.ingresoAnexo1Service.grabar(this.ingresoAnexo1DTO));
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JComboBox getJCB_Municipio() {
        return this.JCB_Municipio;
    }

    @Generated
    public JComboBox getJCB_TipoDocumento() {
        return this.JCB_TipoDocumento;
    }

    @Generated
    public JComboBox getJCB_TipoDocumento_nuevo() {
        return this.JCB_TipoDocumento_nuevo;
    }

    @Generated
    public JCheckBox getJCH_Pregunta1() {
        return this.JCH_Pregunta1;
    }

    @Generated
    public JCheckBox getJCH_Pregunta2() {
        return this.JCH_Pregunta2;
    }

    @Generated
    public JCheckBox getJCH_TraerDatos() {
        return this.JCH_TraerDatos;
    }

    @Generated
    public JDateChooser getJD_FechaNacimiento() {
        return this.JD_FechaNacimiento;
    }

    @Generated
    public JDateChooser getJD_FechaNacimiento_nuevo() {
        return this.JD_FechaNacimiento_nuevo;
    }

    @Generated
    public JLabel getJLB_Consecutivo() {
        return this.JLB_Consecutivo;
    }

    @Generated
    public JLabel getJLB_IdTabla() {
        return this.JLB_IdTabla;
    }

    @Generated
    public JPanel getJPI_InformacionUBD() {
        return this.JPI_InformacionUBD;
    }

    @Generated
    public JPanel getJPI_InformacionUDocumento() {
        return this.JPI_InformacionUDocumento;
    }

    @Generated
    public JScrollPane getJSP_Observacion() {
        return this.JSP_Observacion;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido1() {
        return this.JTF_Apellido1;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido1_nuevo() {
        return this.JTF_Apellido1_nuevo;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido2() {
        return this.JTF_Apellido2;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido2_nuevo() {
        return this.JTF_Apellido2_nuevo;
    }

    @Generated
    public JTextField getJTF_Direccion() {
        return this.JTF_Direccion;
    }

    @Generated
    public JFormattedTextField getJTF_Documento() {
        return this.JTF_Documento;
    }

    @Generated
    public JFormattedTextField getJTF_Documento_nuevo() {
        return this.JTF_Documento_nuevo;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre1() {
        return this.JTF_Nombre1;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre1_nuevo() {
        return this.JTF_Nombre1_nuevo;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre2() {
        return this.JTF_Nombre2;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre2_nuevo() {
        return this.JTF_Nombre2_nuevo;
    }

    @Generated
    public JTextField getJTF_Telefono() {
        return this.JTF_Telefono;
    }

    @Generated
    public JTabbedPane getJTP_DatosAnexo() {
        return this.JTP_DatosAnexo;
    }

    @Generated
    public JTextPane getJTP_Observacion() {
        return this.JTP_Observacion;
    }
}
