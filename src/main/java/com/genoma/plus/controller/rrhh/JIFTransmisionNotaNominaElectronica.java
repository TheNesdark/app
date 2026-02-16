package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import co.com.genomaempresarial.ankara.dto.EliminandoPredecesor;
import co.com.genomaempresarial.ankara.dto.NEliminar;
import co.com.genomaempresarial.ankara.dto.NEmpleador;
import co.com.genomaempresarial.ankara.dto.NInformacionGeneral;
import co.com.genomaempresarial.ankara.dto.NLugarGeneracionXML;
import co.com.genomaempresarial.ankara.dto.NNumeroSecuenciaXML;
import co.com.genomaempresarial.ankara.dto.NProveedorXML;
import co.com.genomaempresarial.ankara.dto.NominaIndividualDeAjuste;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.jpa.entity.ConceptoPorEmpleado;
import com.genoma.plus.jpa.entity.EmpleadoPorNomina;
import com.genoma.plus.jpa.entity.EmpleadorProyection;
import com.genoma.plus.jpa.entity.IEliminandoPredecesor;
import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.IProveedorXml;
import com.genoma.plus.jpa.entity.LugarDeGeneracion;
import com.genoma.plus.jpa.entity.NotasNominaElectronica;
import com.genoma.plus.jpa.entity.NovedadesNomina;
import com.genoma.plus.jpa.entity.TRM;
import com.genoma.plus.jpa.service.NominaService;
import com.genoma.plus.jpa.service.NotaNominaElectronicaService;
import com.genoma.plus.jpa.service.impl.NominaServiceImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFTransmisionNotaNominaElectronica.class */
public class JIFTransmisionNotaNominaElectronica extends JInternalFrame {
    private String[] idNomina;
    private DefaultTableModel modelo;
    private Object[] data;
    private JButton JBConsultar;
    private JButton JBTest;
    private JButton JBTransmitir;
    private JComboBox<String> JCBNomina;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL consulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private NominaService nominaService = (NominaService) Principal.contexto.getBean(NominaService.class);
    private NotaNominaElectronicaService notaNominaElectronicaService = (NotaNominaElectronicaService) Principal.contexto.getBean(NotaNominaElectronicaService.class);
    private Long consecutivo = 0L;
    private int ambiente = 0;

    public JIFTransmisionNotaNominaElectronica() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBNomina = new JComboBox<>();
        this.JBConsultar = new JButton();
        this.JBTransmitir = new JButton();
        this.JBTest = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 13), Color.red));
        this.JCBNomina.setFont(new Font("Arial", 1, 12));
        this.JCBNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "Nomina", 0, 0, new Font("Arial", 1, 13)));
        this.JBConsultar.setFont(new Font("Arial", 1, 12));
        this.JBConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBConsultar.setText("Consultar");
        this.JBConsultar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNotaNominaElectronica.1
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNotaNominaElectronica.this.JBConsultarActionPerformed(evt);
            }
        });
        this.JBTransmitir.setFont(new Font("Arial", 1, 12));
        this.JBTransmitir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTransmitir.setText("Transmitir");
        this.JBTransmitir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNotaNominaElectronica.2
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNotaNominaElectronica.this.JBTransmitirActionPerformed(evt);
            }
        });
        this.JBTest.setFont(new Font("Arial", 1, 12));
        this.JBTest.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTest.setText("Test");
        this.JBTest.setToolTipText("");
        this.JBTest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNotaNominaElectronica.3
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNotaNominaElectronica.this.JBTestActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBNomina, -2, 300, -2).addGap(52, 52, 52).addComponent(this.JBConsultar, -2, 200, -2).addGap(42, 42, 42).addComponent(this.JBTransmitir, -2, 200, -2).addGap(43, 43, 43).addComponent(this.JBTest, -2, 200, -2).addContainerGap(18, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBNomina, GroupLayout.Alignment.TRAILING, -1, 55, 32767).addComponent(this.JBConsultar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBTransmitir, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBTest, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jScrollPane1.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 2, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1073, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(556, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(108, 108, 108).addComponent(this.jScrollPane1, -1, 539, 32767).addContainerGap())));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBConsultarActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTransmitirActionPerformed(ActionEvent evt) {
        this.ambiente = 1;
        for (int j = 0; j < this.JTDetalle.getRowCount(); j++) {
            if (((Boolean) this.modelo.getValueAt(j, 0)).booleanValue()) {
                try {
                    this.consecutivo = insertarNota(this.modelo.getValueAt(j, 3).toString());
                    System.out.println("persona " + Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()]) + " " + this.modelo.getValueAt(j, 3).toString());
                    List<ConceptoPorEmpleado> listaConceptoPorEmpleado = this.nominaService.listaConceptoEmpleado(Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()])), Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(j, 3).toString().trim())));
                    System.out.println("busco" + this.modelo.getValueAt(j, 9).toString());
                    List<NovedadesNomina> listaNovedades = this.nominaService.obtenerNovedadesNomina(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(j, 4).toString().trim())), (Integer) this.modelo.getValueAt(j, 9));
                    System.out.println("busco");
                    armarJson(listaConceptoPorEmpleado, j, listaNovedades, Integer.valueOf(this.consecutivo.intValue()), this.modelo.getValueAt(j, 5).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(JIFTransmisionNotaNominaElectronica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTestActionPerformed(ActionEvent evt) {
        this.ambiente = 2;
        for (int k = 1; k < 10; k++) {
            for (int j = 0; j < this.JTDetalle.getRowCount(); j++) {
                if (((Boolean) this.modelo.getValueAt(j, 0)).booleanValue()) {
                    try {
                        insertarNota(this.modelo.getValueAt(j, 3).toString());
                        System.out.println("persona " + Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()]) + " " + Integer.parseInt(this.modelo.getValueAt(j, 4).toString()));
                        List<ConceptoPorEmpleado> listaConceptoPorEmpleado = this.nominaService.listaConceptoEmpleado(Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()])), (Integer) this.modelo.getValueAt(j, 4));
                        List<NovedadesNomina> listaNovedades = this.nominaService.obtenerNovedadesNomina((Integer) this.modelo.getValueAt(j, 4), (Integer) this.modelo.getValueAt(j, 9));
                        armarJson(listaConceptoPorEmpleado, j, listaNovedades, Integer.valueOf(k), this.modelo.getValueAt(j, 5).toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFTransmisionNotaNominaElectronica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
        }
    }

    private void cargarDatos() {
        mCrearModelo();
        List<EmpleadoPorNomina> listaEmpleado = this.nominaService.listaEmpleadosPorNominaEnviadas(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()]));
        for (int i = 0; i < listaEmpleado.size(); i++) {
            this.modelo.addRow(this.data);
            this.modelo.setValueAt(listaEmpleado.get(i).getFecha(), i, 1);
            this.modelo.setValueAt(listaEmpleado.get(i).getIdLiquidacion(), i, 2);
            this.modelo.setValueAt(listaEmpleado.get(i).getConsecutivo(), i, 3);
            this.modelo.setValueAt(listaEmpleado.get(i).getIdPersona(), i, 4);
            this.modelo.setValueAt(listaEmpleado.get(i).getNoDocumento(), i, 5);
            this.modelo.setValueAt(listaEmpleado.get(i).getEmpleado(), i, 6);
            this.modelo.setValueAt(listaEmpleado.get(i).getFechaIngreso(), i, 7);
            this.modelo.setValueAt(listaEmpleado.get(i).getTiempoLaborado(), i, 8);
            this.modelo.setValueAt(listaEmpleado.get(i).getIdPeriodo(), i, 9);
            this.modelo.setValueAt(false, i, 0);
        }
    }

    private void mCrearModelo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Selecionar", "Fecha", "Id", "Consecutivo", "idpersona", "NoDocumento", "Empleado", "FechaIngreso", "Tiempo Laborado", "IDPeriodo"}) { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNotaNominaElectronica.4
            Class[] types = {Boolean.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
    }

    private void cargarCombo() {
        this.idNomina = this.consulta.llenarCombo("SELECT rh.Id, IF(rh.Observacion='', CONCAT(rnp.Nbre, ' ', date_format(rh.FechaR, '%Y') ),rh.Observacion)  Observacion \n-- , rnld.cune \nFROM `rh_nomina_liquidacion` rh\ninner join rh_nomina_periodo rnp on (rnp.Id=rh.Id_Periodo)\n-- inner join rh_nomina_liquidacion_detalle rnld on (rnld.Id_Liquidacion=rh.Id)\nWHERE `rh`.`Estado` = 1 \norder by rh.FechaR desc", this.idNomina, this.JCBNomina);
    }

    private void springStart() {
        this.nominaService = (NominaServiceImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("nominaService");
    }

    private void armarJson(List<ConceptoPorEmpleado> listaConceptoPorEmpleado, int pos, List<NovedadesNomina> listaNovedades, Integer numero, String documento) throws SQLException {
        try {
            List notas = new ArrayList();
            notas.add("eliminacion de nomina");
            NEliminar eliminar = NEliminar.builder().eliminandoPredecesor(getEliminadoPredecesor(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(pos, 4).toString())), Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()])))).numeroSecuenciaXML(getNumeroDeSecuenciaXML(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(pos, 4).toString())), Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()])), numero, documento)).proveedorXML(getProveedorXML(numero.toString())).codigoQR("None").informacionGeneral(getInformacionGeneral(pos)).lugarGeneracionXML(getLugarGeneracion()).empleador(getEmpleador()).notas(notas).build();
            NominaIndividualDeAjuste nominaIndividualDeAjuste = NominaIndividualDeAjuste.builder().eliminar(eliminar).tipoNota("2").build();
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(nominaIndividualDeAjuste));
            this.nominaService.enviarNota(nominaIndividualDeAjuste);
        } catch (JsonProcessingException e) {
            Logger.getLogger(JIFTransmisionNotaNominaElectronica.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private EliminandoPredecesor getEliminadoPredecesor(Integer idPersona, Integer liquidacion) throws SQLException {
        System.out.println("idPersona " + idPersona + " idLiquidacion " + liquidacion);
        IEliminandoPredecesor iEliminandoPredecesor = this.nominaService.getPredecesor(idPersona, liquidacion);
        EliminandoPredecesor eliminandoPredecesor = EliminandoPredecesor.builder().cunePred(iEliminandoPredecesor.getCune()).fechaGenPred(iEliminandoPredecesor.getFecha()).numeroPred(iEliminandoPredecesor.getNumero()).build();
        return eliminandoPredecesor;
    }

    private NInformacionGeneral getInformacionGeneral(int pos) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date fecha = new Date();
        try {
            fecha = sdf.parse(sdf.format(fecha));
            System.out.println("fecha" + fecha.toString());
        } catch (Exception e) {
        }
        NInformacionGeneral informacionGeneral = NInformacionGeneral.builder().version("V1.0: Nota de Ajuste de Documento Soporte de Pago de Nómina Electrónica").ambiente(Integer.valueOf(this.ambiente)).tipoXML(103).cune("").encripCune("CUNE-SHA384").fechaGen(this.modelo.getValueAt(pos, 1).toString()).horaGen(fecha).tipoMoneda("COP").tRM(Integer.valueOf(getTMR(this.modelo.getValueAt(pos, 1).toString()))).build();
        return informacionGeneral;
    }

    private int getTMR(String fecha) {
        TRM tmr = this.nominaService.getTMR(fecha);
        return tmr.getValor().intValue();
    }

    private NNumeroSecuenciaXML getNumeroDeSecuenciaXML(Integer idPersona, Integer liquidacion, Integer numero, String documento) {
        System.out.println("numero" + numero);
        INumeroSecuenciaXML iNumeroSecuencia = this.notaNominaElectronicaService.numeroSecuenciaXMLNotas(numero);
        NNumeroSecuenciaXML numeroSecuenciaXML = NNumeroSecuenciaXML.builder().consecutivo(iNumeroSecuencia.getConsecutivo()).prefijo(iNumeroSecuencia.getPrefijo()).numero(iNumeroSecuencia.getNumero().trim()).codigoTrabajador(Integer.valueOf(Integer.parseInt(documento))).build();
        if (numero.intValue() > 0) {
            String consecutivo = numeroSecuenciaXML.getConsecutivo().substring(0, numeroSecuenciaXML.getConsecutivo().length() - numero.toString().length()).concat(numero.toString());
            System.out.println("consecutivo" + consecutivo);
            numeroSecuenciaXML.setConsecutivo(consecutivo);
            numeroSecuenciaXML.setNumero(numeroSecuenciaXML.getPrefijo().concat(consecutivo));
        }
        return numeroSecuenciaXML;
    }

    private NProveedorXML getProveedorXML(String numeroDocumento) {
        IProveedorXml nProveedorXML = this.nominaService.ObtenerProvedorXML();
        NProveedorXML proveedor = NProveedorXML.builder().razonSocial(nProveedorXML.getRazonSocial()).primerApellido(nProveedorXML.getRazonSocial()).segundoApellido(nProveedorXML.getSegundoApellido()).primerNombre(nProveedorXML.getPrimerNombre()).otrosNombres(nProveedorXML.getRazonSocial()).nit(nProveedorXML.getNit()).dv(nProveedorXML.getDv()).softwareID(nProveedorXML.getSoftwareId()).softwareSC(obtenerHuellaSoftware(nProveedorXML.getSoftwareId(), nProveedorXML.getPinSoftware(), numeroDocumento)).build();
        return proveedor;
    }

    private String obtenerHuellaSoftware(String softwareId, String ping, String numeroDocumento) {
        return DigestUtils.sha384Hex(softwareId.concat(ping).concat(numeroDocumento));
    }

    private NEmpleador getEmpleador() {
        EmpleadorProyection empleadorProyection = this.nominaService.getEmpleador();
        NEmpleador empleador = NEmpleador.builder().pais(empleadorProyection.getPais()).departamentoEstado(empleadorProyection.getDepartamentoEstado()).direccion(empleadorProyection.getDireccion()).municipioCiudad(empleadorProyection.getMunicipioCiudad()).dv(empleadorProyection.getDV()).razonSocial(empleadorProyection.getRazonSocial()).nit(empleadorProyection.getNit()).build();
        return empleador;
    }

    private Long insertarNota(String consecutivo) {
        NotasNominaElectronica notasNominaElectronica = NotasNominaElectronica.builder().estado(true).consecutivo(0L).noNomina(consecutivo).build();
        NotasNominaElectronica notas = this.notaNominaElectronicaService.guardar(notasNominaElectronica);
        return this.notaNominaElectronicaService.buscarNota(notas.getId());
    }

    private NLugarGeneracionXML getLugarGeneracion() {
        LugarDeGeneracion lugarDeGeneracion = this.nominaService.lugarDeGeneracion();
        NLugarGeneracionXML lugarGeneracionXML = NLugarGeneracionXML.builder().pais(lugarDeGeneracion.getPais()).departamentoEstado(lugarDeGeneracion.getDepartamento()).municipioCiudad(lugarDeGeneracion.getMunicipio()).idioma(lugarDeGeneracion.getIdioma()).build();
        return lugarGeneracionXML;
    }

    private void nuevo() {
        cargarCombo();
        mCrearModelo();
    }
}
