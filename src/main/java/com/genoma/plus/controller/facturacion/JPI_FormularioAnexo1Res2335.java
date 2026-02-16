package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Laboratorio.JIFRemisionLab;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.historia.ImpresionAnexo2335;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.AnexoDatoUsuarioDto;
import com.genoma.plus.controller.historia.dto.AnexoInformacionIpsDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO;
import com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo1Res2335.class */
public class JPI_FormularioAnexo1Res2335 extends JPanel {
    private Long idIngreso;
    private IngresoAnexo1DTO ingresoAnexo1DTO;
    private List<MunicipioDTO> municipioDTOs;
    private List<TipoIdentificacionDTO> tipoIdentificacionDTOs;
    private String codigoRips;
    private InformacionAtencionAnexo2DAO informacionAtencionAnexo2DAO;
    private ButtonGroup JBG_Filtro;
    private JComboBox JCB_Municipio;
    private JComboBox JCB_TipoDocumento;
    public JCheckBox JCH_TraerDatos;
    private JDateChooser JDFecha;
    private JDateChooser JD_FechaNacimiento;
    private JLabel JLB_Consecutivo;
    private JLabel JLB_Id;
    private JPanel JPI_InformacionUBD;
    private JFormattedTextField JTFF_Hora;
    public JFormattedTextField JTF_Apellido1;
    public JFormattedTextField JTF_Apellido2;
    public JTextField JTF_Correo;
    public JTextField JTF_Direccion;
    public JTextField JTF_DireccionAlternativa;
    public JFormattedTextField JTF_Documento;
    public JFormattedTextField JTF_Nombre1;
    public JFormattedTextField JTF_Nombre2;
    public JTextField JTF_NombreEmergencia;
    public JTextField JTF_Telefono;
    public JTextField JTF_TelefonoAlternativo;
    private final IIngresoAnexo1Service ingresoAnexo1Service = (IIngresoAnexo1Service) Principal.contexto.getBean(IIngresoAnexo1Service.class);
    private final IMunicipioService municipioService = (IMunicipioService) Principal.contexto.getBean(IMunicipioService.class);
    private final ITipoIdentificacionService tipoIdentificacionService = (ITipoIdentificacionService) Principal.contexto.getBean(ITipoIdentificacionService.class);
    private Metodos metodos = new Metodos();
    private Integer tipo = -1;
    private Integer tipoAnexo = 1;

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
    public void setTipoAnexo(Integer tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    @Generated
    public void setCodigoRips(String codigoRips) {
        this.codigoRips = codigoRips;
    }

    @Generated
    public void setInformacionAtencionAnexo2DAO(InformacionAtencionAnexo2DAO informacionAtencionAnexo2DAO) {
        this.informacionAtencionAnexo2DAO = informacionAtencionAnexo2DAO;
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
    public void setJCH_TraerDatos(JCheckBox JCH_TraerDatos) {
        this.JCH_TraerDatos = JCH_TraerDatos;
    }

    @Generated
    public void setJDFecha(JDateChooser JDFecha) {
        this.JDFecha = JDFecha;
    }

    @Generated
    public void setJD_FechaNacimiento(JDateChooser JD_FechaNacimiento) {
        this.JD_FechaNacimiento = JD_FechaNacimiento;
    }

    @Generated
    public void setJLB_Consecutivo(JLabel JLB_Consecutivo) {
        this.JLB_Consecutivo = JLB_Consecutivo;
    }

    @Generated
    public void setJLB_Id(JLabel JLB_Id) {
        this.JLB_Id = JLB_Id;
    }

    @Generated
    public void setJPI_InformacionUBD(JPanel JPI_InformacionUBD) {
        this.JPI_InformacionUBD = JPI_InformacionUBD;
    }

    @Generated
    public void setJTFF_Hora(JFormattedTextField JTFF_Hora) {
        this.JTFF_Hora = JTFF_Hora;
    }

    @Generated
    public void setJTF_Apellido1(JFormattedTextField JTF_Apellido1) {
        this.JTF_Apellido1 = JTF_Apellido1;
    }

    @Generated
    public void setJTF_Apellido2(JFormattedTextField JTF_Apellido2) {
        this.JTF_Apellido2 = JTF_Apellido2;
    }

    @Generated
    public void setJTF_Correo(JTextField JTF_Correo) {
        this.JTF_Correo = JTF_Correo;
    }

    @Generated
    public void setJTF_Direccion(JTextField JTF_Direccion) {
        this.JTF_Direccion = JTF_Direccion;
    }

    @Generated
    public void setJTF_DireccionAlternativa(JTextField JTF_DireccionAlternativa) {
        this.JTF_DireccionAlternativa = JTF_DireccionAlternativa;
    }

    @Generated
    public void setJTF_Documento(JFormattedTextField JTF_Documento) {
        this.JTF_Documento = JTF_Documento;
    }

    @Generated
    public void setJTF_Nombre1(JFormattedTextField JTF_Nombre1) {
        this.JTF_Nombre1 = JTF_Nombre1;
    }

    @Generated
    public void setJTF_Nombre2(JFormattedTextField JTF_Nombre2) {
        this.JTF_Nombre2 = JTF_Nombre2;
    }

    @Generated
    public void setJTF_NombreEmergencia(JTextField JTF_NombreEmergencia) {
        this.JTF_NombreEmergencia = JTF_NombreEmergencia;
    }

    @Generated
    public void setJTF_Telefono(JTextField JTF_Telefono) {
        this.JTF_Telefono = JTF_Telefono;
    }

    @Generated
    public void setJTF_TelefonoAlternativo(JTextField JTF_TelefonoAlternativo) {
        this.JTF_TelefonoAlternativo = JTF_TelefonoAlternativo;
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

    @Generated
    public Integer getTipoAnexo() {
        return this.tipoAnexo;
    }

    @Generated
    public String getCodigoRips() {
        return this.codigoRips;
    }

    @Generated
    public InformacionAtencionAnexo2DAO getInformacionAtencionAnexo2DAO() {
        return this.informacionAtencionAnexo2DAO;
    }

    public JPI_FormularioAnexo1Res2335(Long idIngreso, String codigoRips) {
        initComponents();
        setIdIngreso(idIngreso);
        setCodigoRips(codigoRips);
        springStart();
        nuevo();
    }

    private void springStart() {
        this.informacionAtencionAnexo2DAO = (InformacionAtencionAnexo2DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informacionAtencionAnexo2DAOImpl");
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
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
        this.JLB_Id = new JLabel();
        this.JTF_Correo = new JTextField();
        this.JTF_DireccionAlternativa = new JTextField();
        this.JTF_TelefonoAlternativo = new JTextField();
        this.JTF_NombreEmergencia = new JTextField();
        this.JDFecha = new JDateChooser();
        this.JTFF_Hora = new JFormattedTextField();
        this.JLB_Consecutivo = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ANEXO 1", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpi_ingresoAnexo1Res2335");
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
        this.JCH_TraerDatos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1Res2335.1
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo1Res2335.this.JCH_TraerDatosActionPerformed(evt);
            }
        });
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_Correo.setFont(new Font("Arial", 1, 12));
        this.JTF_Correo.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DireccionAlternativa.setFont(new Font("Arial", 1, 12));
        this.JTF_DireccionAlternativa.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección Alternativa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_TelefonoAlternativo.setFont(new Font("Arial", 1, 12));
        this.JTF_TelefonoAlternativo.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono Contacto Emergencia", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NombreEmergencia.setFont(new Font("Arial", 1, 12));
        this.JTF_NombreEmergencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Contacto Emergencia", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setToolTipText("Formato hh:mm p");
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1Res2335.2
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo1Res2335.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1Res2335.3
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo1Res2335.this.JTFF_HoraFocusGained(evt);
            }
        });
        this.JLB_Consecutivo.setFont(new Font("Arial", 1, 14));
        this.JLB_Consecutivo.setHorizontalAlignment(0);
        this.JLB_Consecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_InformacionUBDLayout = new GroupLayout(this.JPI_InformacionUBD);
        this.JPI_InformacionUBD.setLayout(JPI_InformacionUBDLayout);
        JPI_InformacionUBDLayout.setHorizontalGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JTF_NombreEmergencia, -2, 497, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_TelefonoAlternativo)).addComponent(this.JTF_DireccionAlternativa, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JD_FechaNacimiento, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Direccion, -2, 422, -2).addGap(18, 18, 18).addComponent(this.JTF_Telefono, -1, 231, 32767)).addComponent(this.JCB_Municipio, GroupLayout.Alignment.LEADING, -2, 278, -2).addComponent(this.JTF_Correo, GroupLayout.Alignment.LEADING)).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JTF_Apellido1, -2, 169, -2).addGap(18, 18, 18).addComponent(this.JTF_Apellido2, -2, 169, -2).addGap(18, 18, 18).addComponent(this.JTF_Nombre1, -2, 169, -2).addGap(18, 18, 18).addComponent(this.JTF_Nombre2, -2, 169, -2))).addGap(0, 0, 32767)).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addComponent(this.JDFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addComponent(this.JTFF_Hora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoDocumento, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Documento, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_TraerDatos).addGap(31, 31, 31)))).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JLB_Id, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Consecutivo, -2, 121, -2).addGap(0, 0, 32767)));
        JPI_InformacionUBDLayout.setVerticalGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionUBDLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoDocumento, -2, -1, -2).addComponent(this.JTF_Documento, -2, 47, -2).addComponent(this.JCH_TraerDatos).addComponent(this.JTFF_Hora, -2, 42, -2)).addGap(8, 8, 8)).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionUBDLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, -1, -2).addGap(18, 18, 18))).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Apellido1, -2, 47, -2).addComponent(this.JTF_Apellido2, -2, 47, -2).addComponent(this.JTF_Nombre1, -2, 47, -2).addComponent(this.JTF_Nombre2, -2, 47, -2)).addGap(10, 10, 10).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JD_FechaNacimiento, -2, 50, -2).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Direccion, -2, 47, -2).addComponent(this.JTF_Telefono, -2, 47, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Municipio, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Correo, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_DireccionAlternativa, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NombreEmergencia, -2, 47, -2).addComponent(this.JTF_TelefonoAlternativo, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_InformacionUBDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Id, -2, 50, -2).addComponent(this.JLB_Consecutivo, -2, 50, -2)).addContainerGap(13, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 4, 32767).addComponent(this.JPI_InformacionUBD, -2, -1, -2).addGap(0, 3, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPI_InformacionUBD, -2, -1, -2).addGap(5, 5, 5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_TraerDatosActionPerformed(ActionEvent evt) {
        if (this.JCH_TraerDatos.isSelected()) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
        this.JDFecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusGained(FocusEvent evt) {
        this.JTFF_Hora.selectAll();
    }

    private void llenerCombosTipoDocumento(String datos, JComboBox e) {
        for (TipoIdentificacionDTO tipoIdentificacionDTO : this.tipoIdentificacionDTOs) {
            if (tipoIdentificacionDTO.getId().equals(datos)) {
                e.setSelectedItem(tipoIdentificacionDTO.getNombre());
                return;
            }
        }
    }

    public void cargarDatos() {
        System.out.println("wentroo a persona");
        this.JCB_TipoDocumento.setSelectedItem(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboTipoIdentificacion.getSelectedItem());
        this.JTF_Documento.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtIdentificacion.getText());
        this.JTF_Apellido1.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido1.getText());
        this.JTF_Apellido2.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtApellido2.getText());
        this.JTF_Nombre1.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre1.getText());
        this.JTF_Nombre2.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtNombre2.getText());
        this.JD_FechaNacimiento.setDate(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboFechaNacimiento.getDate());
        this.JTF_Direccion.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtDireccion.getText());
        this.JTF_Correo.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtCorreo.getText());
        if (!Principal.clasefacturacion.xjiliqServicio.xjppersona.txtTelefono.getText().equals("")) {
            this.JTF_Telefono.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtTelefono.getText());
        } else {
            this.JTF_Telefono.setText(Principal.clasefacturacion.xjiliqServicio.xjppersona.txtTelefono1.getText());
        }
        this.JCB_Municipio.setSelectedItem(Principal.clasefacturacion.xjiliqServicio.xjppersona.cboMunicipio.getSelectedItem());
        Optional<List<Object[]>> informacion = this.informacionAtencionAnexo2DAO.obtenerInformacionIngresoAnexo2Res2335(this.idIngreso);
        if (informacion.isPresent()) {
            List<Object[]> resultList = informacion.get();
            for (Object[] fila : resultList) {
                String nombreEmergencia = (String) fila[0];
                String telefonoAlternativo = (String) fila[1];
                this.JTF_NombreEmergencia.setText(nombreEmergencia);
                this.JTF_TelefonoAlternativo.setText(telefonoAlternativo);
            }
        }
    }

    private void llenerCombosDatosMunicipio(String datos, JComboBox e) {
        for (MunicipioDTO municipioDTO : this.municipioDTOs) {
            if (municipioDTO.getId().equals(datos)) {
                e.setSelectedItem(municipioDTO.getNombre());
                return;
            }
        }
    }

    public void nuevo() {
        setMunicipioDTOs(getMunicipioService().listaMunicipioConcatenadoDepartamentoEstado(false));
        setTipoIdentificacionDTOs(getTipoIdentificacionService().listaTipoIdentificacionPorEstado(false));
        this.JDFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JCB_Municipio.removeAllItems();
        getMunicipioDTOs().forEach(municipioDTO -> {
            this.JCB_Municipio.addItem(municipioDTO.getNombre());
        });
        this.JCB_Municipio.setSelectedIndex(-1);
        this.JCB_TipoDocumento.removeAllItems();
        getTipoIdentificacionDTOs().forEach(identificacionDTO -> {
            this.JCB_TipoDocumento.addItem(identificacionDTO.getNombre());
        });
        this.JCB_TipoDocumento.setSelectedIndex(-1);
        buscarAnexo();
    }

    private void buscarAnexo() {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "finByAnexoIngreso");
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.idIngreso + "/" + this.tipoAnexo;
            if (fullUrl == null || fullUrl.trim().isEmpty()) {
                System.err.println("Error: La URL es nula o vacía.");
                return;
            }
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            Throwable th = null;
            try {
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        Anexo2335Dto anexo2335Dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<Anexo2335Dto>() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1Res2335.4
                        });
                        if (anexo2335Dto != null && anexo2335Dto.getId() != null) {
                            System.err.println("id" + anexo2335Dto.getId());
                            this.JLB_Id.setText(anexo2335Dto.getId().toString());
                            this.JDFecha.setDate(Date.valueOf(anexo2335Dto.getFechaRegistro()));
                            this.JLB_Consecutivo.setText(this.metodos.numeroCerosIzquierda(anexo2335Dto.getId(), 12));
                            this.JTF_Documento.setText(anexo2335Dto.getAnexoDatoUsuario().getNumeroDocumento());
                            this.JTF_Apellido1.setText(anexo2335Dto.getAnexoDatoUsuario().getPrimerApellido());
                            this.JTF_Apellido2.setText(anexo2335Dto.getAnexoDatoUsuario().getSegundoApellido());
                            this.JTF_Nombre1.setText(anexo2335Dto.getAnexoDatoUsuario().getPrimerNombre());
                            this.JTF_Nombre2.setText(anexo2335Dto.getAnexoDatoUsuario().getSegundoNombre());
                            this.JD_FechaNacimiento.setDate(Date.valueOf(anexo2335Dto.getAnexoDatoUsuario().getFechaNacimiento()));
                            this.JTFF_Hora.setText(anexo2335Dto.getHoraRegistro().toString());
                            this.JTF_Direccion.setText(anexo2335Dto.getAnexoDatoUsuario().getDireccion());
                            this.JTF_Telefono.setText(anexo2335Dto.getAnexoDatoUsuario().getTelefono());
                            llenerCombosTipoDocumento(anexo2335Dto.getAnexoDatoUsuario().getTipoDocumento(), this.JCB_TipoDocumento);
                            llenerCombosDatosMunicipio(anexo2335Dto.getAnexoDatoUsuario().getMunicipio(), this.JCB_Municipio);
                            this.JTF_Correo.setText(anexo2335Dto.getAnexoDatoUsuario().getCorreo());
                            this.JTF_DireccionAlternativa.setText(anexo2335Dto.getAnexoDatoUsuario().getDireccionAlternativa());
                            this.JTF_NombreEmergencia.setText(anexo2335Dto.getAnexoDatoUsuario().getNombreContactoEmergencia());
                            this.JTF_TelefonoAlternativo.setText(anexo2335Dto.getAnexoDatoUsuario().getTelefonoContactoEmergencia());
                        }
                    } catch (Exception e) {
                        Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
                    }
                }
                this.metodos.getResteasyClient().close();
            } finally {
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        response.close();
                    }
                }
            }
        }
    }

    public void grabar() {
        if (this.JCB_TipoDocumento.getSelectedIndex() != -1) {
            if (!this.JTF_Documento.getText().isEmpty()) {
                if (!this.JTF_Apellido1.getText().isEmpty()) {
                    if (!this.JTF_Nombre1.getText().isEmpty()) {
                        if (this.JCB_Municipio.getSelectedIndex() != -1) {
                            int n = JOptionPane.showInternalConfirmDialog(Principal.clasefacturacion.xjiliqServicio, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                try {
                                    System.err.println("this.idIngreso" + this.idIngreso);
                                    Anexo2335Dto anexo2335Dto = new Anexo2335Dto();
                                    if (!this.JLB_Id.getText().equals("")) {
                                        anexo2335Dto.setId(Long.valueOf(Long.parseLong(this.JLB_Id.getText())));
                                    }
                                    anexo2335Dto.setIngresoId(Long.valueOf(this.idIngreso.longValue()));
                                    anexo2335Dto.setIdOrden(Long.valueOf(Long.parseLong("0")));
                                    anexo2335Dto.setFechaRegistro(this.metodos.formatoAMD1.format(this.JDFecha.getDate()));
                                    anexo2335Dto.setHoraRegistro(this.JTFF_Hora.getText());
                                    anexo2335Dto.setTipoAnexo(1);
                                    anexo2335Dto.setEstado(true);
                                    anexo2335Dto.setProfesionalId("0");
                                    anexo2335Dto.setEspecialidadId("0");
                                    anexo2335Dto.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                    AnexoInformacionIpsDto anexoInformacionIpsDto = new AnexoInformacionIpsDto();
                                    anexoInformacionIpsDto.setCodigoEntidadPagadora(getCodigoRips());
                                    anexoInformacionIpsDto.setCodigoPrestador(Principal.informacionIps.getCodigoOrganismo());
                                    anexoInformacionIpsDto.setNumeroAutorizacion("");
                                    anexoInformacionIpsDto.setNumeroIdentificacionIps(Principal.informacionIps.getIdentificacion());
                                    anexo2335Dto.setAnexoInformacionIps(anexoInformacionIpsDto);
                                    AnexoDatoUsuarioDto anexoDatoUsuarioDto = new AnexoDatoUsuarioDto();
                                    anexoDatoUsuarioDto.setPrimerApellido(this.JTF_Apellido1.getText());
                                    anexoDatoUsuarioDto.setSegundoApellido(this.JTF_Apellido2.getText());
                                    anexoDatoUsuarioDto.setPrimerNombre(this.JTF_Nombre1.getText());
                                    anexoDatoUsuarioDto.setSegundoNombre(this.JTF_Nombre1.getText());
                                    anexoDatoUsuarioDto.setTipoDocumento(getTipoIdentificacionDTOs().get(this.JCB_TipoDocumento.getSelectedIndex()).getId());
                                    anexoDatoUsuarioDto.setNumeroDocumento(this.JTF_Documento.getText());
                                    anexoDatoUsuarioDto.setFechaNacimiento(this.metodos.formatoAMD1.format(this.JD_FechaNacimiento.getDate()));
                                    anexoDatoUsuarioDto.setDireccion(this.JTF_Direccion.getText());
                                    anexoDatoUsuarioDto.setTelefono(this.JTF_Telefono.getText());
                                    anexoDatoUsuarioDto.setMunicipio(this.municipioDTOs.get(this.JCB_Municipio.getSelectedIndex()).getId());
                                    anexoDatoUsuarioDto.setCorreo(this.JTF_Correo.getText());
                                    anexoDatoUsuarioDto.setDireccionAlternativa(this.JTF_DireccionAlternativa.getText());
                                    anexoDatoUsuarioDto.setNombreContactoEmergencia(this.JTF_NombreEmergencia.getText());
                                    anexoDatoUsuarioDto.setTelefonoContactoEmergencia(this.JTF_TelefonoAlternativo.getText());
                                    anexo2335Dto.setAnexoDatoUsuario(anexoDatoUsuarioDto);
                                    System.out.println(this.metodos.getMapper().writeValueAsString(anexo2335Dto));
                                    try {
                                        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "RegistroAnexo2335");
                                        Response responsePos = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(anexo2335Dto)));
                                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenter.class);
                                        Anexo2335Dto dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), Anexo2335Dto.class);
                                        System.err.println("dtoId" + dto.getConsecutivo());
                                        this.JLB_Id.setText("" + dto.getId());
                                        this.JLB_Consecutivo.setText(this.metodos.numeroCerosIzquierda(dto.getId(), 12));
                                        System.err.println("dtoId" + dto.getConsecutivo());
                                        responsePos.close();
                                        this.metodos.getResteasyClient().close();
                                    } catch (JsonProcessingException e) {
                                        Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, (String) null, e);
                                    }
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
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

    public void imprimir() {
    }

    public void anular() {
    }

    public void anularDetalle(String conceptoAnulacion, String detalleAnulacion) {
        getIngresoAnexo1DTO().setEstado(Boolean.FALSE);
        getIngresoAnexo1DTO().setConceptoAnulacion(conceptoAnulacion);
        getIngresoAnexo1DTO().setObservacionAnulacion(detalleAnulacion);
        getIngresoAnexo1DTO().setFechaAnulacion(getMetodos().getFechaActual());
        getIngresoAnexo1DTO().setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
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
    public JCheckBox getJCH_TraerDatos() {
        return this.JCH_TraerDatos;
    }

    @Generated
    public JDateChooser getJDFecha() {
        return this.JDFecha;
    }

    @Generated
    public JDateChooser getJD_FechaNacimiento() {
        return this.JD_FechaNacimiento;
    }

    @Generated
    public JLabel getJLB_Consecutivo() {
        return this.JLB_Consecutivo;
    }

    @Generated
    public JLabel getJLB_Id() {
        return this.JLB_Id;
    }

    @Generated
    public JPanel getJPI_InformacionUBD() {
        return this.JPI_InformacionUBD;
    }

    @Generated
    public JFormattedTextField getJTFF_Hora() {
        return this.JTFF_Hora;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido1() {
        return this.JTF_Apellido1;
    }

    @Generated
    public JFormattedTextField getJTF_Apellido2() {
        return this.JTF_Apellido2;
    }

    @Generated
    public JTextField getJTF_Correo() {
        return this.JTF_Correo;
    }

    @Generated
    public JTextField getJTF_Direccion() {
        return this.JTF_Direccion;
    }

    @Generated
    public JTextField getJTF_DireccionAlternativa() {
        return this.JTF_DireccionAlternativa;
    }

    @Generated
    public JFormattedTextField getJTF_Documento() {
        return this.JTF_Documento;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre1() {
        return this.JTF_Nombre1;
    }

    @Generated
    public JFormattedTextField getJTF_Nombre2() {
        return this.JTF_Nombre2;
    }

    @Generated
    public JTextField getJTF_NombreEmergencia() {
        return this.JTF_NombreEmergencia;
    }

    @Generated
    public JTextField getJTF_Telefono() {
        return this.JTF_Telefono;
    }

    @Generated
    public JTextField getJTF_TelefonoAlternativo() {
        return this.JTF_TelefonoAlternativo;
    }
}
