package Historia;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPHistoricoAtenciones.class */
public class JPHistoricoAtenciones extends JPanel {
    private String xsql;
    private clasesHistoriaCE xclase;
    private String[] xidespecialidad;
    private DefaultTableModel xmodeloatencionessistmatizadas;
    private DefaultTableModel modeloatencionesdigitalizadas;
    private Object[] dato;
    private JComboBox JCBEspecialidad;
    private JCheckBox JCHFiltro;
    private JPanel JPIDFiltro;
    private JScrollPane JSPDetalleConsulta;
    private JScrollPane JSPHistoriaDigitalizada;
    private JScrollPane JSPHistoricoA;
    private JTable JTBDetalle;
    private JTable JTDetalleHistoriaDigitalizada;
    private JTextPane JTPHistoricoA;
    private JTabbedPane JTPMenu;
    private JYearChooser JYAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno2 = false;

    public JPHistoricoAtenciones(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mNuevo();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual,   h_atencion.`Conclusion` , h_atencion.`Recomendaciones` FROM  h_atencion   INNER JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  INNER JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
        } else if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 461) {
            this.xsql = "SELECT\n\t    h_notasclinicas.`Id_Atencion`\n\t    , `h_notasclinicas`.`FechaNota`\n\t   , `profesional1`.`Especialidad`\n\t    , `profesional1`.`NProfesional`    \n\t    , IFNULL(`h_notasclinicas`.`EstadoGeneral`,'') AS EstadoGeneral\n\t    , IFNULL(`h_notasclinicas`.`InterpretacionAyudasDx`,'') AS InterpretacionAyudasDx\n\t    ,IFNULL(`h_notasclinicas`.`ObservacionP`,'') AS ObservacionP   \t    \n\t    , IFNULL(`h_notasclinicas`.`NombreProcedimiento`,'') AS NombreProcedimiento\n\t    , IFNULL(`h_notasclinicas`.`ComplicacionP`,'') AS ComplicacionP\n\t    , IFNULL(`h_notasclinicas`.`Descripcion`,'') AS Descripcion\n\t    \n\t    , `h_tiponota`.`Nbre` AS `NTipoNota`\n\t    , `h_notasclinicas`.`Id`\n\tFROM\n\t     `h_notasclinicas`\n\t    INNER JOIN  `h_tiponota` \n\t\tON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\n\t    INNER JOIN  `profesional1` \n\t\tON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)\n\tWHERE (`h_notasclinicas`.`Estado` =1 \n     AND `h_tiponota`.`Id_Clasificacion`  AND `h_notasclinicas`.`Id_Atencion`= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')\tORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` ASC  ";
        } else {
            this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual, IFNULL(CONCAT('DATOS EXAMEN FISICO : \n',CONCAT('Presión Arterial : ',IF(`h_examenfisico`.`TArtSentadoS`<>0, CONCAT(`h_examenfisico`.`TArtSentadoS`,'/', `h_examenfisico`.`TArtSentadoD`), '')) ,'     ', CONCAT('FC (p/m) : ',h_examenfisico.FCardiaca) ,'     ', CONCAT('FR (r/m): ',h_examenfisico.FRespiratoria) ,'     ', CONCAT('Talla (cm): ',h_examenfisico.Talla),'     ',CONCAT('Peso (Kg): ',h_examenfisico.Peso),'     ',CONCAT('Imc: ',h_examenfisico.IMC) ),'') AS Examen, IFNULL(h_examenfisico.Observacion,'') As Observacion, IFNULL(h_atencion.`Conclusion`,'') AS Conclusion , IFNULL(h_atencion.`Recomendaciones`,'') AS Recomendaciones FROM  h_atencion  LEFT JOIN h_examenfisico  ON (h_examenfisico.Id_Atencion = h_atencion.Id)  LEFT JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  LEFT JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
        }
        System.out.println("CONSULTA PRINCIPAL --------------------------------------------------> " + this.xsql);
        mComponerDatos(this.xsql);
        this.JTPHistoricoA.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDFiltro = new JPanel();
        this.JYAno = new JYearChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JTPMenu = new JTabbedPane();
        this.JSPHistoricoA = new JScrollPane();
        this.JTPHistoricoA = new JTextPane();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPHistoriaDigitalizada = new JScrollPane();
        this.JTDetalleHistoriaDigitalizada = new JTable();
        setAutoscrolls(true);
        setName("xjphistoricoa");
        this.JPIDFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPHistoricoAtenciones.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPHistoricoAtenciones.this.JYAnoPropertyChange(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JPHistoricoAtenciones.2
            public void itemStateChanged(ItemEvent evt) {
                JPHistoricoAtenciones.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBEspecialidad.addKeyListener(new KeyAdapter() { // from class: Historia.JPHistoricoAtenciones.3
            public void keyPressed(KeyEvent evt) {
                JPHistoricoAtenciones.this.JCBEspecialidadKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Aplicar filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Historia.JPHistoricoAtenciones.4
            public void actionPerformed(ActionEvent evt) {
                JPHistoricoAtenciones.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDFiltroLayout = new GroupLayout(this.JPIDFiltro);
        this.JPIDFiltro.setLayout(JPIDFiltroLayout);
        JPIDFiltroLayout.setHorizontalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JYAno, -2, 82, -2).addGap(18, 18, 18).addComponent(this.JCBEspecialidad, -2, 445, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPIDFiltroLayout.setVerticalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad).addGroup(JPIDFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFiltro).addComponent(this.JYAno, -2, 50, -2)))).addGap(0, 27, 32767)));
        this.JTPMenu.setForeground(new Color(0, 103, 0));
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTPHistoricoA.setEditable(false);
        this.JTPHistoricoA.setContentType("text/html");
        this.JTPHistoricoA.setFont(new Font("Arial", 1, 12));
        this.JTPHistoricoA.setCursor(new Cursor(0));
        this.JSPHistoricoA.setViewportView(this.JTPHistoricoA);
        this.JTPMenu.addTab("HISTORICO DE ATENCIONES", this.JSPHistoricoA);
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDetalleConsulta.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoricoAtenciones.5
            public void mouseClicked(MouseEvent evt) {
                JPHistoricoAtenciones.this.JSPDetalleConsultaMouseClicked(evt);
            }
        });
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoricoAtenciones.6
            public void mouseClicked(MouseEvent evt) {
                JPHistoricoAtenciones.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JTPMenu.addTab("ATENCIONES SISTEMATIZADAS", this.JSPDetalleConsulta);
        this.JTDetalleHistoriaDigitalizada.setFont(new Font("Arial", 0, 12));
        this.JTDetalleHistoriaDigitalizada.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleHistoriaDigitalizada.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoricoAtenciones.7
            public void mouseClicked(MouseEvent evt) {
                JPHistoricoAtenciones.this.JTDetalleHistoriaDigitalizadaMouseClicked(evt);
            }
        });
        this.JSPHistoriaDigitalizada.setViewportView(this.JTDetalleHistoriaDigitalizada);
        this.JTPMenu.addTab("ATENCIONES DIGITALIZADAS", this.JSPHistoriaDigitalizada);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPMenu).addComponent(this.JPIDFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenu).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        mLLenarCombo();
        mBuscar();
        mCargarDatosTablaSistematizada();
        cargarDatosHistoriasDigitalizadas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            mBuscar();
            mCargarDatosTablaSistematizada();
            cargarDatosHistoriasDigitalizadas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mBuscar();
            mCargarDatosTablaSistematizada();
            cargarDatosHistoriasDigitalizadas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        int columna = this.JTBDetalle.columnAtPoint(evt.getPoint());
        int fila = this.JTBDetalle.rowAtPoint(evt.getPoint());
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getModel().getColumnClass(columna).equals(JButton.class) && this.JTBDetalle.getSelectedRow() == fila) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString(), Integer.valueOf(this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()), "");
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleConsultaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoriaDigitalizadaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistoriaDigitalizada.getSelectedRow() != -1 && this.JTDetalleHistoriaDigitalizada.getValueAt(this.JTDetalleHistoriaDigitalizada.getSelectedRow(), 5) != null && this.JTDetalleHistoriaDigitalizada.getSelectedColumn() != 6) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0 || this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf").isEmpty()) {
                this.xmt.mostrarPdf(this.modeloatencionesdigitalizadas.getValueAt(this.JTDetalleHistoriaDigitalizada.getSelectedRow(), 5).toString());
            } else {
                this.xmt.mostrarPdf(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf") + "\\" + this.modeloatencionesdigitalizadas.getValueAt(this.JTDetalleHistoriaDigitalizada.getSelectedRow(), 5).toString());
            }
            Principal.mGrabarLogAtenciones("HISTORIA CLINICA DIGITALIZADA", this.JTDetalleHistoriaDigitalizada.getValueAt(this.JTDetalleHistoriaDigitalizada.getSelectedRow(), 0).toString(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        }
    }

    private void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual,   ifnull(h_atencion.`Conclusion`,'') , ifnull(h_atencion.`Recomendaciones`,'') FROM  h_atencion   INNER JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  INNER JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (profesional1.`IdEspecialidad`='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
                } else {
                    this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual, IFNULL(CONCAT('DATOS EXAMEN FISICO : \n', CONCAT('Presión Arterial : ',IF(`h_examenfisico`.`TArtSentadoS`<>0, CONCAT(`h_examenfisico`.`TArtSentadoS`,'/', `h_examenfisico`.`TArtSentadoD`), '')) ,'     ',CONCAT('FC (p/m) : ',h_examenfisico.FCardiaca) ,'     ', CONCAT('FR (r/m): ',h_examenfisico.FRespiratoria) ,'     ', CONCAT('Talla (cm): ',h_examenfisico.Talla),'     ',CONCAT('Peso (Kg): ',h_examenfisico.Peso),'     ',CONCAT('Imc: ',h_examenfisico.IMC)),'' ) AS Examen, IFNULL(h_examenfisico.Observacion,'') AS Observacion, ifnull(h_atencion.`Conclusion`,'') AS Conclusion, ifnull(h_atencion.`Recomendaciones`,'') AS Recomendaciones FROM  h_atencion   LEFT JOIN h_examenfisico  ON (h_examenfisico.Id_Atencion = h_atencion.Id)  LEFT JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  LEFT JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (profesional1.`IdEspecialidad`='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
                }
                mComponerDatos(this.xsql);
                return;
            }
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual,   ifnull(h_atencion.`Conclusion`,'') , ifnull(h_atencion.`Recomendaciones`,'') FROM  h_atencion   INNER JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  INNER JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
        } else if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 461) {
            this.xsql = "SELECT\n\t    h_notasclinicas.`Id_Atencion`\n\t    , `h_notasclinicas`.`FechaNota`\n\t   , `profesional1`.`Especialidad`\n\t    , `profesional1`.`NProfesional`    \n\t    , IFNULL(`h_notasclinicas`.`EstadoGeneral`,'') AS EstadoGeneral\n\t    , IFNULL(`h_notasclinicas`.`InterpretacionAyudasDx`,'') AS InterpretacionAyudasDx\n\t    ,IFNULL(`h_notasclinicas`.`ObservacionP`,'') AS ObservacionP   \t    \n\t    , IFNULL(`h_notasclinicas`.`NombreProcedimiento`,'') AS NombreProcedimiento\n\t    , IFNULL(`h_notasclinicas`.`ComplicacionP`,'') AS ComplicacionP\n\t    , IFNULL(`h_notasclinicas`.`Descripcion`,'') AS Descripcion\n\t    \n\t    , `h_tiponota`.`Nbre` AS `NTipoNota`\n\t    , `h_notasclinicas`.`Id`\n\tFROM\n\t     `h_notasclinicas`\n\t    INNER JOIN  `h_tiponota` \n\t\tON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\n\t    INNER JOIN  `profesional1` \n\t\tON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)\n\tWHERE (`h_notasclinicas`.`Estado` =1 \n     AND `h_tiponota`.`Id_Clasificacion`  AND `h_notasclinicas`.`Id_Atencion`= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')\n\tORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` ASC  ";
        } else {
            this.xsql = "SELECT  h_atencion.`Id`, DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencia, profesional1.`Especialidad`, profesional1.`NProfesional`, h_atencion.Motivo_atencion, IF(h_atencion.EActual IS NULL,'',h_atencion.EActual) AS EActual, IFNULL(CONCAT('DATOS EXAMEN FISICO : \n', CONCAT('Presión Arterial : ',IF(`h_examenfisico`.`TArtSentadoS`<>0, CONCAT(`h_examenfisico`.`TArtSentadoS`,'/', `h_examenfisico`.`TArtSentadoD`), '')) ,'     ', CONCAT('FC (p/m) : ',h_examenfisico.FCardiaca) ,'     ', CONCAT('FR (r/m): ',h_examenfisico.FRespiratoria) ,'     ', CONCAT('Talla (cm): ',h_examenfisico.Talla),'     ',CONCAT('Peso (Kg): ',h_examenfisico.Peso),'     ',CONCAT('Perimetro Abdominal: ',h_examenfisico.PerimetroAbdominal),'     ',CONCAT('Imc: ',h_examenfisico.IMC) ),'') AS Examen, h_examenfisico.Observacion,ifnull(h_atencion.`Conclusion`,'') , ifnull(h_atencion.`Recomendaciones`,'') FROM  h_atencion  LEFT JOIN h_examenfisico  ON (h_examenfisico.Id_Atencion = h_atencion.Id)  LEFT JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  LEFT JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "') ORDER BY h_atencion.`Fecha_Atencion` DESC  ";
        }
        System.out.println("Inicio : " + this.xsql);
        mComponerDatos(this.xsql);
    }

    private void mNuevo() {
        this.JYAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        mLLenarCombo();
        cargarDatosHistoriasDigitalizadas();
        this.xlleno2 = true;
    }

    private void mLLenarCombo() {
        ConsultasMySQL xct4 = new ConsultasMySQL();
        this.xlleno = true;
        this.JCBEspecialidad.removeAllItems();
        this.xsql = "SELECT profesional1.`IdEspecialidad`, profesional1.`Especialidad` FROM h_atencion  INNER JOIN `ingreso`  ON (ingreso.`Id` = h_atencion.`Id_Ingreso`)  INNER JOIN `profesional1`  ON (profesional1.`Id_Persona` = h_atencion.`Id_Profesional`) AND (profesional1.`IdEspecialidad` = h_atencion.`Id_Especialidad`)  WHERE (ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_atencion.`Codigo_Dxp`<>'' AND DATE_FORMAT(h_atencion.`Fecha_Atencion`,'%Y')='" + this.JYAno.getValue() + "' ) GROUP BY profesional1.`IdEspecialidad`  ORDER BY  profesional1.`Especialidad` ASC;  ";
        System.out.println(" Combo :  " + this.xsql);
        this.xidespecialidad = xct4.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        xct4.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mComponerDatos(String sql) {
        String xparte4;
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            String xparte2 = "";
            String xparte3 = "";
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String xparte1 = "<font face='Arial' color='red' size=4>" + xrs.getString(2) + "  :" + xrs.getString(3) + " - " + xrs.getString(4) + "</font><br>";
                    if (!Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        this.xsql = "SELECT h_grupoexamenfisico.Nbre, h_tipoexamenfisico.Nbre, h_detalleexamenfisico.Descripcion , h_grupoexamenfisico.Orden FROM  h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_detalleexamenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_grupoexamenfisico.Id = h_tipoexamenfisico.Id_GrupoExamenFisico) WHERE (h_examenfisico.Id_Atencion ='" + xrs.getString(1) + "' AND h_detalleexamenfisico.Valor =1) ORDER BY h_grupoexamenfisico.Orden ASC, h_tipoexamenfisico.Nbre ASC ";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        ResultSet xrs1 = xct1.traerRs(this.xsql);
                        if (xrs1.next()) {
                            xrs1.last();
                            int xn = xrs1.getRow();
                            if (xn == 1) {
                                xparte2 = "\n\nDETALLE EXÁMEN FÍSICO\n" + xrs1.getString(1) + "\t" + xrs1.getString(2) + "\t" + xrs1.getString(3);
                            } else {
                                xrs1.beforeFirst();
                                xparte2 = "\n\nDETALLE EXÁMEN FÍSICO";
                                while (xrs1.next()) {
                                    xparte2 = xparte2 + "\n" + xrs1.getString(1) + "\t" + xrs1.getString(2) + "\t" + xrs1.getString(3) + "\n";
                                }
                            }
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                    }
                    this.xsql = "SELECT`h_triage`.`Id`  \n    , CONCAT('Clasificación : ',`h_triage`.`Clasificacion`) AS Tipo\n    , CONCAT('Fecha y Hora: ',DATE_FORMAT(`h_triage`.`FechaTriage`, '%d-%m-%Y'),' ', `h_triage`.`HoraTriage`) AS Fecha\n    , CONCAT('Motivo Consulta : ',`h_triage`.`MotivoConsulta`) AS M0tivo\n    , IF(`h_triage`.`TArtSentadoD`=0,'',CONCAT('Presión : ',`h_triage`.`TArtSentadoD`,'/',`h_triage`.`TArtSentadoS`)) AS Presion\n    , IF(`h_triage`.`FCardiaca`=0,'',CONCAT('Fc : ',`h_triage`.`FCardiaca`)) AS FC\n    , IF(`h_triage`.`FRespiratoria`=0,'',CONCAT('Fr : ',`h_triage`.`FRespiratoria`)) AS Fr\n    , IF(`h_triage`.`Talla`=0,'',CONCAT('Talla : ',`h_triage`.`Talla`)) AS Talla\n    , IF(`h_triage`.`Peso`=0,'',CONCAT('Peso : ',`h_triage`.`Peso`)) AS Peso\n    , IF(`h_triage`.`IMC`=0,'',CONCAT('Imc : ',`h_triage`.`IMC`)) AS Imc\n    , IF(`h_triage`.`Temperatura`=0,'',CONCAT('T° : ',`h_triage`.`Temperatura`)) AS Temperatura\n    , IF(`h_triage`.`Ps2`=0,'',CONCAT('Ps2 : ',`h_triage`.`Ps2`)) AS Ps2\n    , concat(gp3.Apellido1, ' ', gp3.Apellido2,' ', gp3.Nombre1,' ', gp3.Nombre2)`NProfesional`\n    ,`ge`.Nbre `Especialidad`\n  ,IF(`g_patologia`.`Id` IS NULL, '',GROUP_CONCAT( IF(`h_atenciondx`.`Orden`=1,CONCAT('Diagnóstico Principal : ','\\t  ', `g_patologia`.`Id`,'-', `g_patologia`.`Nbre`),\n    IF(`h_atenciondx`.`Orden`=2,CONCAT('Diagnóstico Relacionado 1 : ',' ', `g_patologia`.`Id`,'-', `g_patologia`.`Nbre`),\n    IF(`h_atenciondx`.`Orden`=3,CONCAT('Diagnóstico Relacionado 2 : ',' ', `g_patologia`.`Id`,'-', `g_patologia`.`Nbre`),\n    CONCAT('Diagnóstico Relacionado 3 : ',' ', `g_patologia`.`Id`,'-', `g_patologia`.`Nbre`)))\n    ) ORDER BY`h_atenciondx`.`Orden` SEPARATOR'\\n' ))AS Patologia\n  \nFROM\n    `d_ips`,\n    `h_triage`\n    INNER JOIN `ingreso`\n        ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)\n    INNER JOIN g_profesional gp2\n        ON (gp2.Id_Persona  = `h_triage`.`Id_Profesional`) \n    inner join g_persona gp3 on (gp3.Id=gp2.Id_Persona)   \n    inner join g_especialidad ge on  (ge.Id  = `h_triage`.`Id_Especialidad`)\n    INNER JOIN `f_empresacontxconvenio`\n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_empresacont`\n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `f_tiporegimen`\n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `h_atenciondx`\n        ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN `g_patologia`\n        ON (`h_atenciondx`.`Id_Dx` = `g_patologia`.`Id`)\nWHERE (`h_atencion`.`Id` =" + xrs.getString(1) + ") GROUP BY `ingreso`.`Id`\nORDER BY `h_atenciondx`.`Orden` ASC";
                    ConsultasMySQL xct5 = new ConsultasMySQL();
                    ResultSet xrs5 = xct5.traerRs(this.xsql);
                    String xparte0 = "";
                    if (xrs5.next()) {
                        xrs5.first();
                        xparte0 = "<br><font face='Arial' color='red' size=4>CLASIFICACIÓN TRIAGE</font><br>" + xrs5.getString(2) + "-" + xrs5.getString(3) + " <br> " + xrs5.getString(4) + " <br> " + xrs5.getString(5) + "   " + xrs5.getString(6) + "   " + xrs5.getString(7) + "   " + xrs5.getString(8) + "   " + xrs5.getString(9) + "   " + xrs5.getString(10) + "   " + xrs5.getString(11) + "   " + xrs5.getString(12) + " <br> " + xrs5.getString(15) + " <br> " + xrs5.getString(13) + " <br> " + xrs5.getString(14);
                    } else {
                        System.out.println("No es urgencia");
                    }
                    xrs5.close();
                    xct5.cerrarConexionBd();
                    if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 461) {
                        this.xsql = "SELECT\n h_notaclinica_diagnostico.`NOrden`    , `h_notaclinica_diagnostico`.`Id_Patologia`\n    , `g_patologia`.`Nbre`\n    , `h_notasclinicas`.`Id_Atencion`\n    , `h_notasclinicas`.`Id`\nFROM\n    `baseserver`.`h_notaclinica_diagnostico`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_notaclinica_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`h_notasclinicas` \n        ON (`h_notaclinica_diagnostico`.`Id_NClinica` = `h_notasclinicas`.`Id`)\n    \nWHERE (`h_notasclinicas`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'\n    AND `h_notasclinicas`.`Id` ='" + xrs.getString(12) + "')";
                        ConsultasMySQL xct2 = new ConsultasMySQL();
                        ResultSet xrs2 = xct2.traerRs(this.xsql);
                        xparte4 = "";
                        if (xrs2.next()) {
                            xrs2.last();
                            int xn2 = xrs2.getRow();
                            if (xn2 == 1) {
                                xparte4 = "<br>IMPRESIÓN DIAGNÓSTICA<br>" + xrs2.getString(1) + "-" + xrs2.getString(2) + "  -  " + xrs2.getString(3);
                            } else {
                                xrs2.beforeFirst();
                                String xndx = "";
                                while (xrs2.next()) {
                                    xndx = xndx + xrs2.getString(1) + "-" + xrs2.getString(2) + "   -   " + xrs2.getString(3) + "<br>";
                                }
                                xparte4 = "<br>IMPRESIÓN DIAGNÓSTICA<br><br>" + xndx;
                            }
                        }
                        xrs2.close();
                        xct2.cerrarConexionBd();
                    } else {
                        this.xsql = "SELECT h_atenciondx.Orden, g_patologia.Id, g_patologia.Nbre FROM h_atenciondx INNER JOIN g_patologia  ON (h_atenciondx.Id_Dx = g_patologia.Id) WHERE (h_atenciondx.Id_Atencion ='" + xrs.getString(1) + "') ORDER BY h_atenciondx.Orden ASC ";
                        ConsultasMySQL xct22 = new ConsultasMySQL();
                        ResultSet xrs22 = xct22.traerRs(this.xsql);
                        xparte4 = "";
                        if (xrs22.next()) {
                            xrs22.last();
                            int xn3 = xrs22.getRow();
                            if (xn3 == 1) {
                                xparte4 = "<br>IMPRESIÓN DIAGNÓSTICA<br>" + xrs22.getString(1) + "-" + xrs22.getString(2) + "  -  " + xrs22.getString(3);
                            } else {
                                xrs22.beforeFirst();
                                String xndx2 = "";
                                while (xrs22.next()) {
                                    xndx2 = xndx2 + xrs22.getString(1) + "-" + xrs22.getString(2) + "   -   " + xrs22.getString(3) + "<br>";
                                }
                                xparte4 = "<br>IMPRESIÓN DIAGNÓSTICA<br><br>" + xndx2;
                            }
                        }
                        xrs22.close();
                        xct22.cerrarConexionBd();
                    }
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        xparte3 = xparte3 + xparte1 + " " + xrs.getString(5) + " " + xrs.getString(6) + " " + xrs.getString(7) + " " + xparte2 + "<br>" + xparte4 + "<br>" + xrs.getString(8) + "<br>" + xparte0 + "<br>--------------------------------------------------------------------------------------<br>";
                    } else {
                        xparte3 = xparte3 + xparte1 + " " + xrs.getString(5) + " " + xrs.getString(6) + " " + xrs.getString(7) + " " + xparte2 + "<br>" + xparte4 + "<br>" + xrs.getString(9) + " " + xrs.getString(10) + "<br>" + xparte0 + "<br>--------------------------------------------------------------------------------------<br>";
                    }
                }
            }
            this.JTPHistoricoA.setText(xparte3);
            this.JTPHistoricoA.setCaretPosition(0);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPORemisiones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloTablaHistoriasDigitalizadas() {
        this.modeloatencionesdigitalizadas = new DefaultTableModel(new Object[0], new String[]{"IdA", "¨Fecha", "Especialidad", "Profesional", "Tipo Doc", "", "Descargar"}) { // from class: Historia.JPHistoricoAtenciones.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistoriaDigitalizada.setModel(this.modeloatencionesdigitalizadas);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleHistoriaDigitalizada.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    private void cargarDatosHistoriasDigitalizadas() {
        try {
            String sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id) INNER JOIN h_tipodocumentoshc  ON (h_atencionesmanuales.Id_TipoDoc = h_tipodocumentoshc.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_atencionesmanuales.Estado=0) ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            ResultSet rs = this.xct.traerRs(sql);
            modeloTablaHistoriasDigitalizadas();
            System.out.println("HC Digitalizada " + sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.modeloatencionesdigitalizadas.addRow(this.dato);
                    this.modeloatencionesdigitalizadas.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.modeloatencionesdigitalizadas.setValueAt(rs.getString(2), i, 1);
                    this.modeloatencionesdigitalizadas.setValueAt(rs.getString(3), i, 2);
                    this.modeloatencionesdigitalizadas.setValueAt(rs.getString(4), i, 3);
                    this.modeloatencionesdigitalizadas.setValueAt(rs.getString(5), i, 4);
                    this.modeloatencionesdigitalizadas.setValueAt(rs.getString(6), i, 5);
                    this.modeloatencionesdigitalizadas.setValueAt(true, i, 6);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPHistoricoAtenciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodeloatencionessistmatizadas = new DefaultTableModel(new Object[0], new String[]{"IdA", "Fecha y Hora", "Tipo Consulta", "Profesional", "", "Id_Especialidad", "TipoC", "Descargar", "Tipo_HC", "Especialidad", "Id_Ingreso", "Id_Usuario", "Id_TipoAtencion", "Accion", "EsPrenatal", "IdEcografia"}) { // from class: Historia.JPHistoricoAtenciones.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, JButton.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JPHistoricoAtenciones.10
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBDetalle.setModel(this.xmodeloatencionessistmatizadas);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    private void mCargarDatosTablaSistematizada() {
        String sql;
        try {
            if (this.JCHFiltro.isSelected() && this.JCBEspecialidad.getSelectedIndex() != -1) {
                sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre,`profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias, h_tipohistoria.`Reporte`, `profesional1`.`Especialidad` ,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)  LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND ingreso.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
            } else {
                sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, `profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias, h_tipohistoria.`Reporte`, `profesional1`.`Especialidad` ,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)   LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
            }
            mCrearTabla();
            ResultSet rs = this.xct.traerRs(sql);
            System.out.println(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloatencionessistmatizadas.addRow(this.dato);
                    this.xmodeloatencionessistmatizadas.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(2) + " " + rs.getString(3), i, 1);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(4), i, 2);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(5), i, 3);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(6), i, 4);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(7), i, 5);
                    this.xmodeloatencionessistmatizadas.setValueAt(Long.valueOf(rs.getLong(8)), i, 6);
                    this.xmodeloatencionessistmatizadas.setValueAt(true, i, 7);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(9), i, 8);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(10), i, 9);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(11), i, 10);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(12), i, 11);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("Id_TipoAtencion"), i, 12);
                    this.xmodeloatencionessistmatizadas.setValueAt(new JButton("Imprimir"), i, 13);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("EsPrenatal"), i, 14);
                    this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("IdEcografia"), i, 15);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
