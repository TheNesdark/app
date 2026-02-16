package Facturacion;

import Acceso.Principal;
import General.Anular;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.JTextFieldValidator;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO;
import com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl;
import com.genoma.plus.dto.facturacion.ItemsRipsNacimientosDTO;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPQuirurgico.class */
public class JPQuirurgico extends JPanel {
    private int filaGrid;
    private int cboLleno;
    private String sql;
    private String tipoServicio;
    private String esConjunto;
    private DefaultTableModel modelo;
    private DefaultTableModel xmodeloRN;
    private DefaultTableModel xModelo;
    private DefaultTableModel xModeloHD;
    private DefaultTableModel xModeloInfQx;
    private JIFLiqServicios xliq;
    private int[] Valores;
    private String xsql;
    private Object[] xDatos2;
    private Object[] xDatos;
    private Object[] xDatos3;
    private Object[] xDatos4;
    private String[] xTipoParto;
    private String xFechaNac;
    private String xSexoPers;
    private int MetodoFact;
    private int Redondeo;
    private LiquidacionCirugiaDAO liquidacionCirugiaDAO;
    public List<GServicioGrupoEntity> listGrupoEntitys;
    public List<GServicioRipsEntity> ListripsEntitys;
    private String[] xId_Finalidad;
    private String[] idDestino;
    private JButton JBAdicionar;
    private JButton JBBUscarDx;
    private JButton JBBUscarDxC;
    private JButton JBBUscarDxM;
    private JButton JBBUscarDxP;
    private JButton JBBUscarDxR;
    private JButton JBT_Anexo3;
    private JComboBox JCBDestino;
    private JComboBox JCBFinalidad;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBSevicioRips;
    private JComboBox JCBTParto;
    private JDateChooser JDC_NFecha;
    private JDateChooser JDC_NFechaM;
    private JLabel JLBNumero;
    private JPanel JPDHistorico;
    private JPanel JPI_CPrennatal;
    private JPanel JPI_CPrennatal1;
    private JPanel JPI_CPrennatal2;
    private JPanel JPI_DNacimiento;
    private JPanel JPI_DRecienNacido;
    private JPanel JPI_DatosC;
    private JPanel JPI_Liquidacion;
    private JPanel JPInformeQx;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBVivo;
    private JRadioButton JRB_Fem;
    private JRadioButton JRB_Masc;
    private JRadioButton JRB_NCpNo;
    private JRadioButton JRB_NCpSi;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistoricoDetalle;
    private JScrollPane JSPInformeQx;
    private JTabbedPane JTD_DProcedimiento;
    private JTable JTDetalleNacimiento;
    private JTextField JTFAPGar;
    public JTextField JTFCDxP;
    public JTextField JTFCDxPM;
    public JTextFieldValidator JTFFNControles;
    public JTextFieldValidator JTFFSNumHijo;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    private JFormattedTextField JTFF_EdadGestacional;
    private JFormattedTextField JTFF_NHora;
    private JFormattedTextField JTFF_NHoraM;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNCodigoDxPM;
    private JTable JTHistorico;
    private JTable JTHistoricoDetalle;
    private JTable JTInformeQx;
    private JTabbedPane JTP_Cirugia;
    private JTabbedPane JTP_Liquidacion;
    private JRadioButton btnBilateralNo;
    private JRadioButton btnBilateralSi;
    private JButton btnCargar;
    private JCheckBox btnCobrable;
    private JRadioButton btnDiferenteVia;
    private JRadioButton btnIgualVia;
    private JButton btnLiquidar;
    private JTableComboBox cboAnestesiologo;
    private JTableComboBox cboAyudante;
    private JTableComboBox cboCC;
    private JTableComboBox cboCirugia;
    private JTableComboBox cboCirujano;
    private JTableComboBox cboEspecialidad;
    private JTableComboBox cboPerfusionista;
    private JTableComboBox cboTipoAnestesia;
    private JTableComboBox cboTipoSala;
    private JTableComboBox cboTipoServicio;
    private JCheckBox chAnestesiologo;
    private JCheckBox chAyudante;
    private JCheckBox chCirugia;
    private JCheckBox chMateriales;
    private JCheckBox chPerfusionista;
    private JCheckBox chSala;
    private JTable grid;
    private ButtonGroup grupoBilateral;
    private ButtonGroup grupoEstado;
    private ButtonGroup grupoPrenatal;
    private ButtonGroup grupoSexo;
    private ButtonGroup grupoVia;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelDatos;
    private JTextField txtCirugia;
    private JTextField txtCodDxCompli;
    private JTextField txtCodDxPpal;
    private JTextField txtCodDxRel;
    private JTextField txtDxCompli;
    private JTextField txtDxPpal;
    private JTextField txtDxRel;
    private JDateChooser txtFecha;
    private JFormattedTextField txtHoraFin;
    private JFormattedTextField txtHoraIni;
    public JFormattedTextField txtNoPrescripcionMiPres;
    private JFormattedTextField txtValorMateriales;
    private JFormattedTextField txtVrAnestesiologo;
    private JFormattedTextField txtVrAyudante;
    private JFormattedTextField txtVrConjunto;
    private JFormattedTextField txtVrHonorarios;
    private JFormattedTextField txtVrPerfusionista;
    private JFormattedTextField txtVrSala;
    private JFormattedTextField txtVrTotal;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Object[] dato = {"", "", 0, "", "", "", "", "", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0, "", 0, 0L, 0L, 0L, 0L, 0L, 0L, "", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, "", 0L, 0L, ""};
    private int viaAcceso = 0;
    private int bilateral = 0;
    private int cobrable = 1;
    private String xNTabla_Tmp = "";
    private int xEstadoNacido = 1;
    private int xCPrenatal = 0;
    private String xSexo = "M";
    private int sw_conj = 0;
    private long xid_HOrdenQX = 0;

    public JPQuirurgico(JIFLiqServicios xliq) {
        this.xliq = null;
        this.MetodoFact = 2;
        initComponents();
        springStart();
        this.xliq = xliq;
        this.xliq.clasefacturacion.mInicar_Variables_Ingreso(this.xliq.JLB_NIngreso.getText());
        this.JDC_NFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_NHora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHoraIni.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.txtHoraFin.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.MetodoFact = this.xliq.clasefacturacion.getxMetodoFact();
        this.Redondeo = this.xliq.clasefacturacion.getxRedondeo();
        cargarCombos();
        mCrearGrid();
        mCreaModeloRN();
        this.xFechaNac = this.metodos.formatoAMD.format(this.xliq.xjppersona.cboFechaNacimiento.getDate());
        this.xSexoPers = this.xliq.xjppersona.getIdSexo();
        this.JTFCDxPM.setEnabled(false);
        this.JBBUscarDxM.setEnabled(false);
        this.JDC_NFechaM.setDate((Date) null);
        this.JDC_NFechaM.setEnabled(false);
        this.JTFF_NHoraM.setText("");
        this.JTFF_NHoraM.setEnabled(false);
        this.JTFF_EdadGestacional.setText("0");
        this.txtNoPrescripcionMiPres.setText("");
        this.JTFAPGar.setText("0");
        mCargarDatosTabla();
        mCrearTablaHistoricoDetalle();
        mBuscaDx();
        mCargarDatosInformeQx();
    }

    public void anular() {
        this.metodos.mostrarMensaje("Opción pendiente");
    }

    private void springStart() {
        this.liquidacionCirugiaDAO = (LiquidacionCirugiaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("liquidacionCirugiaDAOImpl");
    }

    private void mBajarCirugiaAlGrid() {
        int x = 3;
        if (this.cboTipoSala.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Tipo de Sala");
            this.cboTipoSala.requestFocus();
            return;
        }
        if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Especialida del Cirujano");
            this.cboEspecialidad.requestFocus();
            return;
        }
        if (this.cboCirujano.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Cirujano que intervendrá en la Cirugía");
            this.cboCirujano.requestFocus();
            return;
        }
        if (this.cboCirugia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Cirugía que se Practicó");
            this.cboCirugia.requestFocus();
            return;
        }
        if (this.JCBGrupoSevicio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el grupo de servicio");
            this.JTP_Cirugia.setSelectedIndex(0);
            this.JCBGrupoSevicio.requestFocus();
            return;
        }
        if (this.JCBSevicioRips.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el grupo de servicio rips");
            this.JTP_Cirugia.setSelectedIndex(0);
            this.JCBSevicioRips.requestFocus();
            return;
        }
        if (this.txtDxPpal.getText().equals("")) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Diagnostico Principal de la Cirugía");
            this.txtCodDxPpal.requestFocus();
            return;
        }
        if (this.JCBFinalidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la finalidad");
            this.JCBFinalidad.requestFocus();
            return;
        }
        if (!this.btnCobrable.isSelected()) {
            x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de agregar el Procedimiento como NO Cobrable?", "Procedimientos No Cobrable", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
        if (x == 0 || x == 3) {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(this.txtCirugia.getText(), this.filaGrid, 0);
            this.modelo.setValueAt(this.cboCirugia.getSelectedItem(), this.filaGrid, 1);
            System.err.println("cboCirugia.getSelectedItem()" + this.cboCirugia.getSelectedItem());
            this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 3), this.filaGrid, 2);
            System.err.println("cboCirugia.getPopupTable().getValueAt(cboCirugia.getSelectedIndex(), 3)" + this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 3));
            this.modelo.setValueAt(this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 1), this.filaGrid, 3);
            this.modelo.setValueAt(this.cboCirujano.getPopupTable().getValueAt(this.cboCirujano.getSelectedIndex(), 1), this.filaGrid, 4);
            if (this.viaAcceso == 0) {
                this.modelo.setValueAt("Igual", this.filaGrid, 5);
            } else {
                this.modelo.setValueAt("Diferente", this.filaGrid, 5);
            }
            if (this.bilateral == 0) {
                this.modelo.setValueAt("No", this.filaGrid, 6);
            } else {
                this.modelo.setValueAt("Si", this.filaGrid, 6);
            }
            this.modelo.setValueAt(this.txtCodDxPpal.getText(), this.filaGrid, 7);
            this.modelo.setValueAt(this.txtCodDxRel.getText(), this.filaGrid, 8);
            this.modelo.setValueAt(this.txtCodDxCompli.getText(), this.filaGrid, 9);
            this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 6), this.filaGrid, 16);
            this.modelo.setValueAt(this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0), this.filaGrid, 17);
            this.modelo.setValueAt(this.cboCirujano.getPopupTable().getValueAt(this.cboCirujano.getSelectedIndex(), 0), this.filaGrid, 28);
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.filaGrid, 66);
            this.modelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.filaGrid, 67);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.filaGrid, 68);
            this.modelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.filaGrid, 69);
            this.modelo.setValueAt(this.txtNoPrescripcionMiPres.getText(), this.filaGrid, 71);
            this.modelo.setValueAt(this.xId_Finalidad[this.JCBFinalidad.getSelectedIndex()], this.filaGrid, 70);
            if (this.cobrable == 0) {
                this.modelo.setValueAt("No", this.filaGrid, 26);
            } else {
                this.modelo.setValueAt("Si", this.filaGrid, 26);
            }
            this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 5), this.filaGrid, 27);
            switch (this.esConjunto) {
                case "1":
                    this.modelo.setValueAt("Si", this.filaGrid, 41);
                    this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 7), this.filaGrid, 42);
                    break;
                case "2":
                    this.modelo.setValueAt("Pq", this.filaGrid, 41);
                    this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 7), this.filaGrid, 42);
                    break;
                default:
                    this.modelo.setValueAt("No", this.filaGrid, 41);
                    this.modelo.setValueAt(0, this.filaGrid, 42);
                    break;
            }
            this.modelo.setValueAt(this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 0), this.filaGrid, 44);
            this.filaGrid++;
        }
    }

    private void borrarRegistroTabla() {
        if (this.modelo.getRowCount() > 0) {
            int NoFila = this.grid.getSelectedRow();
            this.modelo.removeRow(NoFila);
            this.filaGrid--;
        }
    }

    private void mPonerHonario_Cero(int xcolumna, boolean xforma, int xcolumna_o) {
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            if (xforma) {
                this.modelo.setValueAt(this.modelo.getValueAt(x, xcolumna_o), x, xcolumna);
            } else {
                this.modelo.setValueAt(0, x, xcolumna);
            }
        }
        mTotalizar_Cirugias();
    }

    private String buscar(String tabla, String id) {
        this.sql = "SELECT Nbre FROM " + tabla + " WHERE Id ='" + id + "'";
        String xdato = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return xdato;
    }

    private void cargarValoresTabla() {
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            this.sql = "SELECT MedEsp, Anestesia, Ayudante, Sala, Material, Perfusion FROM   q_grupouvr WHERE (Id ='" + this.modelo.getValueAt(f, 27).toString() + "' AND Id_TipoSala='" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0).toString() + "')";
            ResultSet rs = this.consultas.traerRs(this.sql);
            int colGrid = 10;
            while (rs.next()) {
                try {
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(1)), f, 29);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(2)), f, 30);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(3)), f, 31);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(4)), f, 32);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(5)), f, 33);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(6)), f, 34);
                    for (int cRs_fArray = 1; cRs_fArray < 7; cRs_fArray++) {
                        if (this.Valores[cRs_fArray] == 0) {
                            cargarHonorario(rs.getString(cRs_fArray), f, colGrid, this.modelo.getValueAt(f, 0).toString(), this.modelo.getValueAt(f, 2).toString());
                            colGrid++;
                        } else {
                            if (!rs.getString(cRs_fArray).equals("0")) {
                                cargarHonorario(rs.getString(cRs_fArray), f, colGrid, this.modelo.getValueAt(f, 0).toString());
                            }
                            colGrid++;
                        }
                    }
                } catch (SQLException ex) {
                    this.consultas.mostrarErrorSQL(ex);
                }
            }
            rs.close();
        }
        this.consultas.cerrarConexionBd();
    }

    private void mTotalizar_Cirugias() {
        double xhmedico = 0.0d;
        double xhanestesia = 0.0d;
        double xhayudante = 0.0d;
        double xvderecho_sala = 0.0d;
        double xv_materiales = 0.0d;
        double xhperfusionista = 0.0d;
        double xconjunto = 0.0d;
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            xhmedico += Double.valueOf(this.modelo.getValueAt(x, 19).toString()).doubleValue();
            xhanestesia += Double.valueOf(this.modelo.getValueAt(x, 20).toString()).doubleValue();
            xhayudante += Double.valueOf(this.modelo.getValueAt(x, 21).toString()).doubleValue();
            xvderecho_sala += Double.valueOf(this.modelo.getValueAt(x, 22).toString()).doubleValue();
            xv_materiales += Double.valueOf(this.modelo.getValueAt(x, 23).toString()).doubleValue();
            xhperfusionista += Double.valueOf(this.modelo.getValueAt(x, 24).toString()).doubleValue();
            xconjunto += Double.valueOf(this.modelo.getValueAt(x, 43).toString()).doubleValue();
        }
        this.txtVrHonorarios.setValue(Long.valueOf(Math.round(xhmedico)));
        this.txtVrAnestesiologo.setValue(Long.valueOf(Math.round(xhanestesia)));
        this.txtVrAyudante.setValue(Long.valueOf(Math.round(xhayudante)));
        this.txtVrSala.setValue(Long.valueOf(Math.round(xvderecho_sala)));
        this.txtValorMateriales.setValue(Long.valueOf(Math.round(xv_materiales)));
        this.txtVrPerfusionista.setValue(Long.valueOf(Math.round(xhperfusionista)));
        this.txtVrConjunto.setValue(Long.valueOf(Math.round(xconjunto)));
        this.txtVrTotal.setValue(Long.valueOf(Math.round(xhmedico) + Math.round(xhanestesia) + Math.round(xhayudante) + Math.round(xvderecho_sala) + Math.round(xv_materiales) + Math.round(xhperfusionista) + Math.round(xconjunto)));
    }

    private void mOrdenar_TablaCx() {
        ResultSet xrs;
        Throwable th;
        for (int x = 0; x < 10; x++) {
            try {
                this.xsql = "SHOW TABLES LIKE 'q_tmp_" + x + "' ";
                xrs = this.consultas.traerRs(this.xsql);
                th = null;
                try {
                    try {
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th2;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            if (!xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xNTabla_Tmp = "q_tmp_" + x;
                this.xsql = "CREATE TABLE `q_tmp_" + x + "` ( `Codigo` VARCHAR(20) DEFAULT '', `Nbre` VARCHAR(2000) DEFAULT '', `GUvr` SMALLINT(4) DEFAULT '0', `Especialidad` VARCHAR(200) DEFAULT '', `Profesional` VARCHAR(200) DEFAULT '', `Via` VARCHAR(20) DEFAULT '', `Bilateral` VARCHAR(20) DEFAULT '', `DxP` VARCHAR(4) DEFAULT '', `DxR` VARCHAR(4) DEFAULT '', `DxC` VARCHAR(4) DEFAULT '',`NOrden` MEDIUMINT(5) DEFAULT '0', `Id_Especialidad` BIGINT(20) DEFAULT '0',`No_Autoriz` VARCHAR(20) DEFAULT '', `Cobrable` VARCHAR(2) DEFAULT '', `Id_GUvr` MEDIUMINT(5) DEFAULT '0', `Id_Profesional` BIGINT(20) DEFAULT '0',EsConj VARCHAR(20) DEFAULT '', VrConjunto DOUBLE DEFAULT '0' , Cod_Servicio VARCHAR(20) DEFAULT '', idGrupo VARCHAR(3) DEFAULT '', nombreGrupo VARCHAR(200) DEFAULT '', idServicioRips VARCHAR(3) DEFAULT '', nombreServicio VARCHAR(300) DEFAULT '', idFinalidad VARCHAR(5) DEFAULT '', idMipres VARCHAR(50) DEFAULT '' ) ENGINE=INNODB DEFAULT CHARSET=latin1 ";
                xct.ejecutarSQL(this.xsql);
                xct.cerrarConexionBd();
                for (int y = 0; y < this.grid.getRowCount(); y++) {
                    this.xsql = "insert into " + this.xNTabla_Tmp + "(`Codigo` , `Nbre` , `GUvr` , `Especialidad` , `Profesional` , `Via` , `Bilateral` , `DxP` , `DxR` , `DxC` , `NOrden` , `Id_Especialidad` ,`No_Autoriz`, `Cobrable` , `Id_GUvr` , `Id_Profesional`,EsConj,VrConjunto, Cod_Servicio, idGrupo, nombreGrupo, idServicioRips, nombreServicio, idFinalidad, idMipres )  values('" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 1) + "','" + this.modelo.getValueAt(y, 2) + "','" + this.modelo.getValueAt(y, 3) + "','" + this.modelo.getValueAt(y, 4) + "','" + this.modelo.getValueAt(y, 5) + "','" + this.modelo.getValueAt(y, 6) + "','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 8) + "','" + this.modelo.getValueAt(y, 9) + "','" + this.modelo.getValueAt(y, 16) + "','" + this.modelo.getValueAt(y, 17) + "','" + this.modelo.getValueAt(y, 25) + "','" + this.modelo.getValueAt(y, 26) + "','" + this.modelo.getValueAt(y, 27) + "','" + this.modelo.getValueAt(y, 28) + "','" + this.modelo.getValueAt(y, 41) + "','" + this.modelo.getValueAt(y, 42) + "','" + this.modelo.getValueAt(y, 44) + "','" + this.modelo.getValueAt(y, 66) + "','" + this.modelo.getValueAt(y, 67) + "','" + this.modelo.getValueAt(y, 68) + "','" + this.modelo.getValueAt(y, 69) + "','" + this.modelo.getValueAt(y, 70) + "','" + this.modelo.getValueAt(y, 71) + "')";
                    System.out.println(this.xsql);
                    xct.ejecutarSQL(this.xsql);
                    xct.cerrarConexionBd();
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        xrs.close();
                    }
                }
                return;
            }
            if (xrs != null) {
                if (0 != 0) {
                    try {
                        xrs.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    xrs.close();
                }
            }
            this.consultas.cerrarConexionBd();
            Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarTipoLiq() {
        int f = 0;
        while (true) {
            if (f >= this.modelo.getRowCount()) {
                break;
            }
            if (!this.modelo.getValueAt(f, 41).toString().equals("Si")) {
                f++;
            } else {
                this.sw_conj = 1;
                break;
            }
        }
        if (this.sw_conj == 1) {
            mCargar_Datos_OrdenadosP();
        } else {
            mCargar_Datos_OrdenadosT();
        }
    }

    private void mCargar_Datos_OrdenadosP() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.xsql = "SELECT   Codigo,   Nbre,   GUvr,   Especialidad,   Profesional,   Via,   Bilateral,   DxP,   DxR,   DxC,   NOrden,   Id_Especialidad,   No_Autoriz,   Cobrable,   Id_GUvr,   Id_Profesional,   EsConj,   VrConjunto,   Cod_Servicio,  idGrupo, nombreGrupo, idServicioRips, nombreServicio, idFinalidad, idMipres  FROM " + this.xNTabla_Tmp + " ORDER BY VrConjunto DESC, GUvr DESC";
            this.filaGrid = 0;
            mCrearGrid();
            int xorden = 1;
            ResultSet xrs1 = xct.traerRs(this.xsql);
            Throwable th = null;
            while (xrs1.next()) {
                try {
                    try {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(xrs1.getString(1), this.filaGrid, 0);
                        this.modelo.setValueAt(xrs1.getString(2), this.filaGrid, 1);
                        this.modelo.setValueAt(xrs1.getString(3), this.filaGrid, 2);
                        this.modelo.setValueAt(xrs1.getString(4), this.filaGrid, 3);
                        this.modelo.setValueAt(xrs1.getString(5), this.filaGrid, 4);
                        this.modelo.setValueAt(xrs1.getString(6), this.filaGrid, 5);
                        this.modelo.setValueAt(xrs1.getString(7), this.filaGrid, 6);
                        this.modelo.setValueAt(xrs1.getString(8), this.filaGrid, 7);
                        this.modelo.setValueAt(xrs1.getString(9), this.filaGrid, 8);
                        this.modelo.setValueAt(xrs1.getString(10), this.filaGrid, 9);
                        if (xrs1.getString(14).equals("Si")) {
                            this.modelo.setValueAt(Integer.valueOf(xorden), this.filaGrid, 18);
                            xorden++;
                        } else {
                            this.modelo.setValueAt(-1, this.filaGrid, 18);
                        }
                        this.modelo.setValueAt(xrs1.getString(12), this.filaGrid, 17);
                        this.modelo.setValueAt(xrs1.getString(13), this.filaGrid, 25);
                        this.modelo.setValueAt(xrs1.getString(14), this.filaGrid, 26);
                        this.modelo.setValueAt(xrs1.getString(15), this.filaGrid, 27);
                        this.modelo.setValueAt(xrs1.getString(16), this.filaGrid, 28);
                        this.modelo.setValueAt(xrs1.getString(17), this.filaGrid, 41);
                        this.modelo.setValueAt(Double.valueOf(xrs1.getDouble(18)), this.filaGrid, 42);
                        this.modelo.setValueAt(xrs1.getString(19), this.filaGrid, 44);
                        this.modelo.setValueAt(xrs1.getString("idGrupo"), this.filaGrid, 66);
                        this.modelo.setValueAt(xrs1.getString("nombreGrupo"), this.filaGrid, 67);
                        this.modelo.setValueAt(xrs1.getString("idServicioRips"), this.filaGrid, 68);
                        this.modelo.setValueAt(xrs1.getString("nombreServicio"), this.filaGrid, 69);
                        this.modelo.setValueAt(xrs1.getString("idFinalidad"), this.filaGrid, 70);
                        this.modelo.setValueAt(xrs1.getString("idMipres"), this.filaGrid, 71);
                        this.filaGrid++;
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th2;
                }
            }
            if (xrs1 != null) {
                if (0 != 0) {
                    try {
                        xrs1.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    xrs1.close();
                }
            }
            this.xsql = "SELECT  A.Codigo,Id_Especialidad FROM  (SELECT T.* FROM " + this.xNTabla_Tmp + " T   ORDER BY VrConjunto DESC, GUvr DESC) A ORDER BY Id_Especialidad,VrConjunto DESC,GUvr DESC";
            xrs1 = xct.traerRs(this.xsql);
            Throwable th4 = null;
            try {
                try {
                    if (xrs1.next()) {
                        String esp = xrs1.getString(2);
                        xrs1.beforeFirst();
                        int xOrden = 1;
                        while (xrs1.next()) {
                            if (!esp.equals(xrs1.getString(2))) {
                                esp = xrs1.getString(2);
                                xOrden = 1;
                            }
                            int f = 0;
                            while (true) {
                                if (f >= this.modelo.getRowCount()) {
                                    break;
                                }
                                if (!this.modelo.getValueAt(f, 0).toString().equals(xrs1.getString(1))) {
                                    f++;
                                } else if (this.modelo.getValueAt(f, 26).toString().equals("Si")) {
                                    this.modelo.setValueAt(Integer.valueOf(xOrden), f, 16);
                                    xOrden++;
                                } else {
                                    this.modelo.setValueAt("-1", f, 16);
                                }
                            }
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct.cerrarConexionBd();
                    this.xsql = "DROP TABLE " + this.xNTabla_Tmp;
                    xct.ejecutarSQL(this.xsql);
                    xct.cerrarConexionBd();
                } finally {
                    if (xrs1 != null) {
                        if (th4 != null) {
                            try {
                                xrs1.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                }
            } catch (Throwable th7) {
                th4 = th7;
                throw th7;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x03b1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:54:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x03b5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:56:0x03b5 */
    private void mCargar_Datos_OrdenadosT() {
        ResultSet xrs1;
        Throwable th;
        Throwable th2;
        try {
            try {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xsql = "SELECT  `Id_Especialidad` , COUNT(`Especialidad`) AS `Cantidad` , MAX(`GUvr`) AS `GV` FROM " + this.xNTabla_Tmp + " GROUP BY `Id_Especialidad` ORDER BY `GV` DESC ";
                ResultSet xrs = xct.traerRs(this.xsql);
                Throwable th3 = null;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    this.filaGrid = 0;
                    mCrearGrid();
                    while (xrs.next()) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        this.xsql = "SELECT  `Codigo` , `Nbre` , `GUvr` , `Especialidad` , `Profesional` , `Via` , `Bilateral` , `DxP` , `DxR` , `DxC` , `NOrden` , `Id_Especialidad` ,`No_Autoriz`, `Cobrable` , `Id_GUvr` , `Id_Profesional`,EsConj,VrConjunto,Cod_Servicio, Cod_Servicio,  idGrupo, nombreGrupo, idServicioRips, nombreServicio, idFinalidad, idMipres   FROM  " + this.xNTabla_Tmp + " WHERE (`Id_Especialidad` ='" + xrs.getString(1) + "') ORDER BY Cobrable DESC,`GUvr` DESC  ";
                        xrs1 = xct1.traerRs(this.xsql);
                        Throwable th4 = null;
                        try {
                            try {
                                int xorden = 1;
                                if (xrs1.next()) {
                                    xrs1.beforeFirst();
                                    while (xrs1.next()) {
                                        this.modelo.addRow(this.dato);
                                        this.modelo.setValueAt(xrs1.getString(1), this.filaGrid, 0);
                                        this.modelo.setValueAt(xrs1.getString(2), this.filaGrid, 1);
                                        this.modelo.setValueAt(xrs1.getString(3), this.filaGrid, 2);
                                        this.modelo.setValueAt(xrs1.getString(4), this.filaGrid, 3);
                                        this.modelo.setValueAt(xrs1.getString(5), this.filaGrid, 4);
                                        this.modelo.setValueAt(xrs1.getString(6), this.filaGrid, 5);
                                        this.modelo.setValueAt(xrs1.getString(7), this.filaGrid, 6);
                                        this.modelo.setValueAt(xrs1.getString(8), this.filaGrid, 7);
                                        this.modelo.setValueAt(xrs1.getString(9), this.filaGrid, 8);
                                        this.modelo.setValueAt(xrs1.getString(10), this.filaGrid, 9);
                                        if (xrs1.getString(14).equals("Si")) {
                                            this.modelo.setValueAt(Integer.valueOf(xorden), this.filaGrid, 16);
                                            xorden++;
                                        } else {
                                            this.modelo.setValueAt(-1, this.filaGrid, 16);
                                        }
                                        this.modelo.setValueAt(xrs1.getString(12), this.filaGrid, 17);
                                        this.modelo.setValueAt(xrs1.getString(13), this.filaGrid, 25);
                                        this.modelo.setValueAt(xrs1.getString(14), this.filaGrid, 26);
                                        this.modelo.setValueAt(xrs1.getString(15), this.filaGrid, 27);
                                        this.modelo.setValueAt(xrs1.getString(16), this.filaGrid, 28);
                                        this.modelo.setValueAt(xrs1.getString(17), this.filaGrid, 41);
                                        this.modelo.setValueAt(Double.valueOf(xrs1.getDouble(18)), this.filaGrid, 42);
                                        this.modelo.setValueAt(xrs1.getString(19), this.filaGrid, 44);
                                        this.modelo.setValueAt(xrs1.getString("idGrupo"), this.filaGrid, 66);
                                        this.modelo.setValueAt(xrs1.getString("nombreGrupo"), this.filaGrid, 67);
                                        this.modelo.setValueAt(xrs1.getString("idServicioRips"), this.filaGrid, 68);
                                        this.modelo.setValueAt(xrs1.getString("nombreServicio"), this.filaGrid, 69);
                                        this.modelo.setValueAt(xrs1.getString("idFinalidad"), this.filaGrid, 70);
                                        this.modelo.setValueAt(xrs1.getString("idMipres"), this.filaGrid, 71);
                                        this.filaGrid++;
                                    }
                                }
                                if (xrs1 != null) {
                                    if (0 != 0) {
                                        try {
                                            xrs1.close();
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                        }
                                    } else {
                                        xrs1.close();
                                    }
                                }
                                xct1.cerrarConexionBd();
                            } finally {
                                if (xrs1 != null) {
                                    if (th2 != null) {
                                        try {
                                            xrs1.close();
                                        } catch (Throwable th6) {
                                            th.addSuppressed(th6);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th4 = th7;
                            throw th7;
                        }
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th8) {
                            th3.addSuppressed(th8);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xsql = "SELECT  distinct `Codigo`, `Cobrable` FROM  " + this.xNTabla_Tmp + " ORDER BY Cobrable DESC,`GUvr` DESC   ";
                xrs1 = xct.traerRs(this.xsql);
                th = null;
                try {
                    try {
                        if (xrs1.next()) {
                            xrs1.beforeFirst();
                            int xordenAnestesia = 1;
                            while (xrs1.next()) {
                                for (int x = 0; x < this.grid.getRowCount(); x++) {
                                    if (this.modelo.getValueAt(x, 0).equals(xrs1.getString(1))) {
                                        if (xrs1.getString(2).equals("Si")) {
                                            this.modelo.setValueAt(Integer.valueOf(xordenAnestesia), x, 18);
                                            xordenAnestesia++;
                                        } else {
                                            this.modelo.setValueAt(-1, x, 18);
                                        }
                                    }
                                }
                            }
                        }
                        if (xrs1 != null) {
                            if (0 != 0) {
                                try {
                                    xrs1.close();
                                } catch (Throwable th9) {
                                    th.addSuppressed(th9);
                                }
                            } else {
                                xrs1.close();
                            }
                        }
                        xct.cerrarConexionBd();
                        this.xsql = "DROP TABLE " + this.xNTabla_Tmp;
                        xct.ejecutarSQL(this.xsql);
                        xct.cerrarConexionBd();
                    } finally {
                        if (xrs1 != null) {
                            if (th2 != null) {
                                try {
                                    xrs1.close();
                                } catch (Throwable th10) {
                                    th.addSuppressed(th10);
                                }
                            }
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    throw th11;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } finally {
        }
    }

    private void liquidar() {
        limpiarValor();
        String especial = this.modelo.getValueAt(0, 3).toString();
        int f = 1;
        while (true) {
            if (f < this.modelo.getRowCount()) {
                if (especial.equals(this.modelo.getValueAt(f, 3).toString()) || !"Si".equals(this.modelo.getValueAt(f, 26).toString())) {
                    f++;
                } else {
                    especial = "1";
                    break;
                }
            } else {
                break;
            }
        }
        if (especial.equals("1")) {
            esquemaEspecialDiferente();
        } else {
            esquemaEspecialUnica();
        }
    }

    private void esquemaEspecialUnica() {
        int x_tipo;
        String via;
        Double valor;
        String esConj = "No";
        Double.valueOf(0.0d);
        if (this.modelo.getValueAt(0, 26).toString().equals("Si")) {
            String viaAccMayor = this.modelo.getValueAt(0, 5).toString();
            for (int x = 0; x < this.grid.getRowCount(); x++) {
                switch (this.modelo.getValueAt(x, 41).toString()) {
                    case "Si":
                        esConj = "Si";
                        x_tipo = 7;
                        break;
                    case "Pq":
                        esConj = "Si";
                        x_tipo = 8;
                        break;
                    default:
                        x_tipo = 1;
                        break;
                }
                for (int z = 10; z < 16; z++) {
                    if (x_tipo == 1) {
                        int No_Cirugia = Integer.parseInt(this.modelo.getValueAt(x, 16).toString());
                        if (No_Cirugia > 3) {
                            No_Cirugia = 3;
                        }
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp FROM `q_excepcion` WHERE (`Id_TipoManual` =(SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio`     INNER JOIN `f_manual` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`)  WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "') AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia + "') ";
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp  FROM `q_excepcion` WHERE (`Id_TipoManual` =(SELECT f_manual.Id_TipoManQx FROM f_servicioempresaconv  INNER JOIN f_manual ON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)  WHERE f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xliq.getXidempresa() + "'   AND f_servicioempresaconv.Id_TipoServicio ='" + this.tipoServicio + "') AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia + "') ";
                        }
                        System.out.println("Cirujano : " + this.xsql);
                    } else {
                        int No_Cirugia2 = Integer.parseInt(this.modelo.getValueAt(x, 18).toString());
                        if (No_Cirugia2 > 3) {
                            No_Cirugia2 = 3;
                        }
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio`     INNER JOIN `f_manual` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`)  WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "')";
                            if (x_tipo == 4) {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' AND Id_TipoSala ='" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "'  ";
                            } else {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' ";
                            }
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp  FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT f_manual.Id_TipoManQx FROM f_servicioempresaconv  INNER JOIN f_manual ON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)  WHERE f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xliq.getXidempresa() + "'   AND f_servicioempresaconv.Id_TipoServicio ='" + this.tipoServicio + "')";
                            if (x_tipo == 4) {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' AND Id_TipoSala ='" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "'  ";
                            } else {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' ";
                            }
                        }
                        System.out.println(" Cirugia Anestesia y Otros : " + this.xsql);
                    }
                    String viaCirAct = this.modelo.getValueAt(x, 5).toString();
                    if (viaAccMayor.equals(viaCirAct)) {
                        via = "0";
                    } else {
                        via = "1";
                    }
                    int porcTipoExc = validarTipoExcepcion(this.xsql, via, "0");
                    if (esConj.equals("No")) {
                        if (this.Redondeo == 0 || this.Redondeo == 2) {
                            valor = Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 9 + x_tipo).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d);
                        } else {
                            valor = redondear(Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 9 + x_tipo).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d));
                        }
                    } else {
                        valor = Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 42).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d);
                    }
                    int porcTipoBil = 0;
                    Double vrBilateral = Double.valueOf(0.0d);
                    if (this.modelo.getValueAt(x, 6).toString().equals("Si")) {
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , `IgualVia_IgualEsp` , `IgualVia_DifEsp` , `DifVia_IgualEsp` , `DifVia_DifEsp` FROM `q_excepcion` WHERE `Id_TipoManual` = (SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio` INNER JOIN `f_manual` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) WHERE f_empresacontxconvenio.Id = '" + this.xliq.getXidempresa() + "') AND `Id_TipoHonorario` = '" + x_tipo + "' AND `Id_TipoCirugia` = '0' AND `Id_TipoSala` = '" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "' ";
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , `IgualVia_IgualEsp` , `IgualVia_DifEsp` , `DifVia_IgualEsp` , `DifVia_DifEsp` FROM `q_excepcion` WHERE `Id_TipoManual` = (SELECT f_manual.Id_TipoManQx FROM f_servicioempresaconv INNER JOIN f_manual ON (f_servicioempresaconv.Id_Manual_n = f_manual.Id) WHERE f_servicioempresaconv.Id_EmpresaConvenio = '" + this.xliq.getXidempresa() + "' AND f_servicioempresaconv.Id_TipoServicio = '" + this.tipoServicio + "') AND `Id_TipoHonorario` = '" + x_tipo + "' AND `Id_TipoCirugia` = '0' AND `Id_TipoSala` = '" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "' ";
                        }
                        System.out.println("Bilateral k : " + this.xsql);
                        porcTipoBil = validarTipoExcepcion(this.xsql, via, "0");
                        System.out.println("Porcentaje Bilateral : " + porcTipoBil);
                        if (this.Redondeo == 0 || this.Redondeo == 2) {
                            vrBilateral = Double.valueOf((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d);
                            valor = Double.valueOf(valor.doubleValue() + ((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d));
                        } else {
                            vrBilateral = redondear(Double.valueOf((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d));
                            valor = redondear(Double.valueOf(valor.doubleValue() + ((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d)));
                        }
                    }
                    if (esConj.equals("No")) {
                        this.modelo.setValueAt(valor, x, 18 + x_tipo);
                        this.modelo.setValueAt(valor, x, 34 + x_tipo);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoExc), x, 44 + x_tipo);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoBil), x, 51 + x_tipo);
                        this.modelo.setValueAt(vrBilateral, x, 58 + x_tipo);
                    } else {
                        this.modelo.setValueAt(valor, x, 43);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoExc), x, 51);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoBil), x, 58);
                        this.modelo.setValueAt(vrBilateral, x, 65);
                    }
                    if (esConj.equals("Si") || esConj.equals("Pq")) {
                        esConj = "No";
                    } else {
                        x_tipo++;
                    }
                }
            }
            return;
        }
        this.metodos.mostrarMensaje("Solo Existe una Cirugia para Liquidar y no es cobrable");
    }

    private void esquemaEspecialDiferente() {
        int x_tipo;
        String via;
        String especialidad;
        Double valor;
        String esConj = "No";
        Double.valueOf(0.0d);
        if (this.modelo.getValueAt(0, 26).toString().equals("Si")) {
            String viaAccMayor = this.modelo.getValueAt(0, 5).toString();
            String espCirMayor = this.modelo.getValueAt(0, 17).toString();
            for (int x = 0; x < this.grid.getRowCount(); x++) {
                if (this.modelo.getValueAt(x, 41).toString().equals("Si")) {
                    esConj = "Si";
                    x_tipo = 7;
                } else if (this.modelo.getValueAt(x, 41).toString().equals("Pq")) {
                    esConj = "Pq";
                    x_tipo = 8;
                } else {
                    x_tipo = 1;
                }
                for (int z = 10; z < 16; z++) {
                    if (x_tipo == 1) {
                        int No_Cirugia = Integer.parseInt(this.modelo.getValueAt(x, 16).toString());
                        if (No_Cirugia > 3) {
                            No_Cirugia = 3;
                        }
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio`     INNER JOIN `f_manual` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`)  WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "' GROUP BY f_manual.Id_TipoManQx ) AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia + "' ";
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp  FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT f_manual.Id_TipoManQx FROM f_servicioempresaconv  INNER JOIN f_manual ON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)  WHERE f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xliq.getXidempresa() + "'   AND f_servicioempresaconv.Id_TipoServicio ='" + this.tipoServicio + "' GROUP BY f_manual.Id_TipoManQx ) AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia + "' ";
                        }
                        System.out.println("Cirujano : " + this.xsql);
                    } else {
                        int No_Cirugia2 = Integer.parseInt(this.modelo.getValueAt(x, 18).toString());
                        if (No_Cirugia2 > 3) {
                            No_Cirugia2 = 3;
                        }
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , `IgualVia_IgualEsp` , `IgualVia_DifEsp` , `DifVia_IgualEsp` , `DifVia_DifEsp` FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio`     INNER JOIN `f_manual` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`)  WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "' GROUP BY f_manual.Id_TipoManQx )";
                            if (x_tipo == 4) {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' AND Id_TipoSala ='" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "'  ";
                            } else {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' ";
                            }
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila` , IgualVia_IgualEsp , IgualVia_DifEsp , DifVia_IgualEsp , DifVia_DifEsp  FROM `q_excepcion` WHERE `Id_TipoManual` =(SELECT f_manual.Id_TipoManQx FROM f_servicioempresaconv  INNER JOIN f_manual ON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)  WHERE f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xliq.getXidempresa() + "'   AND f_servicioempresaconv.Id_TipoServicio ='" + this.tipoServicio + "' GROUP BY f_manual.Id_TipoManQx  )";
                            if (x_tipo == 4) {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' AND Id_TipoSala ='" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "'  ";
                            } else {
                                this.xsql += " AND `Id_TipoHonorario` ='" + x_tipo + "' AND `Id_TipoCirugia` ='" + No_Cirugia2 + "' ";
                            }
                        }
                        System.out.println("Anestesia y otros : " + this.xsql);
                    }
                    String viaCirAct = this.modelo.getValueAt(x, 5).toString();
                    if (viaAccMayor.equals(viaCirAct)) {
                        via = "0";
                    } else {
                        via = "1";
                    }
                    String espCirAct = this.modelo.getValueAt(x, 17).toString();
                    if (espCirMayor.equals(espCirAct)) {
                        especialidad = "0";
                    } else {
                        especialidad = "1";
                    }
                    int porcTipoExc = validarTipoExcepcion(this.xsql, via, especialidad);
                    System.out.println("Porcentaje Tipo Exc : " + porcTipoExc);
                    if (esConj.equals("No")) {
                        if (this.Redondeo == 0 || this.Redondeo == 2) {
                            valor = Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 9 + x_tipo).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d);
                        } else {
                            valor = redondear(Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 9 + x_tipo).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d));
                        }
                    } else {
                        valor = Double.valueOf((Double.valueOf(this.modelo.getValueAt(x, 42).toString()).doubleValue() * ((double) porcTipoExc)) / 100.0d);
                    }
                    int porcTipoBil = 0;
                    Double vrBilateral = Double.valueOf(0.0d);
                    if (this.modelo.getValueAt(x, 6).toString().equals("Si")) {
                        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
                            this.xsql = "SELECT Id_TipoExcepcion , `Unico_Bila`, `IgualVia_IgualEsp`, `IgualVia_DifEsp`, `DifVia_IgualEsp`, `DifVia_DifEsp` FROM `q_excepcion` WHERE `Id_TipoManual` = (SELECT `f_manual`.`Id_TipoManQx` FROM `f_empresacontxconvenio` INNER JOIN `f_manual` ON `f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id` WHERE `f_empresacontxconvenio`.`Id` = '" + this.xliq.getXidempresa() + "' GROUP BY `f_manual`.`Id_TipoManQx`) AND `Id_TipoHonorario` = '" + x_tipo + "' AND `Id_TipoCirugia` = '0' AND `Id_TipoSala` = '" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "' ";
                        } else {
                            this.xsql = "SELECT Id_TipoExcepcion, `Unico_Bila`, `IgualVia_IgualEsp`, `IgualVia_DifEsp`, `DifVia_IgualEsp`, `DifVia_DifEsp` FROM `q_excepcion` WHERE `Id_TipoManual` = (SELECT `f_manual`.`Id_TipoManQx` FROM `f_servicioempresaconv` INNER JOIN `f_manual` ON `f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id` WHERE `f_servicioempresaconv`.`Id_EmpresaConvenio` = '" + this.xliq.getXidempresa() + "' AND `f_servicioempresaconv`.`Id_TipoServicio` = '" + this.tipoServicio + "' GROUP BY `f_manual`.`Id_TipoManQx`) AND `Id_TipoHonorario` = '" + x_tipo + "' AND `Id_TipoCirugia` = '0' AND `Id_TipoSala` = '" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0) + "' ";
                        }
                        System.out.println("Bilateral : " + this.xsql);
                        porcTipoBil = validarTipoExcepcion(this.xsql, via, especialidad);
                        if (this.Redondeo == 0 || this.Redondeo == 2) {
                            vrBilateral = Double.valueOf((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d);
                            valor = Double.valueOf(valor.doubleValue() + ((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d));
                        } else {
                            vrBilateral = redondear(Double.valueOf((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d));
                            valor = redondear(Double.valueOf(valor.doubleValue() + ((valor.doubleValue() * ((double) porcTipoBil)) / 100.0d)));
                        }
                    }
                    if (esConj.equals("No")) {
                        this.modelo.setValueAt(valor, x, 18 + x_tipo);
                        this.modelo.setValueAt(valor, x, 34 + x_tipo);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoExc), x, 44 + x_tipo);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoBil), x, 51 + x_tipo);
                        this.modelo.setValueAt(vrBilateral, x, 58 + x_tipo);
                    } else {
                        this.modelo.setValueAt(valor, x, 43);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoExc), x, 51);
                        this.modelo.setValueAt(Integer.valueOf(porcTipoBil), x, 58);
                        this.modelo.setValueAt(vrBilateral, x, 65);
                    }
                    if (esConj.equals("Si") || esConj.equals("Pq")) {
                        esConj = "No";
                        break;
                    }
                    x_tipo++;
                }
            }
            return;
        }
        this.metodos.mostrarMensaje("Solo Existe una Cirugia para Liquidar y no es cobrable");
    }

    private int validarTipoExcepcion(String sql, String viaAcceso, String espec) {
        int retorno = 0;
        ResultSet rs = this.consultas.traerRs(sql);
        while (rs.next()) {
            try {
                String tipoExc = rs.getString("Id_TipoExcepcion");
                switch (tipoExc) {
                    case "P":
                        retorno = rs.getInt("Unico_Bila");
                        break;
                    case "G":
                        retorno = rs.getInt("Unico_Bila");
                        break;
                    case "Y":
                        if (viaAcceso.equals("0") && espec.equals("0")) {
                            retorno = rs.getInt("IgualVia_IgualEsp");
                            break;
                        } else {
                            if (viaAcceso.equals("0") && espec.equals("1")) {
                                retorno = rs.getInt("IgualVia_DifEsp");
                            } else if (viaAcceso.equals("1") && espec.equals("0")) {
                                retorno = rs.getInt("DifVia_IgualEsp");
                            } else if (viaAcceso.equals("1") && espec.equals("1")) {
                                retorno = rs.getInt("DifVia_DifEsp");
                            }
                            break;
                        }
                        break;
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        return retorno;
    }

    public void mGrabar() {
        int xescobrable;
        int xesconjunto;
        if (this.JTP_Cirugia.getSelectedIndex() == 3) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                this.xsql = "UPDATE `f_ordenesqx` SET  `NAutorizacion` = '" + this.xModeloHD.getValueAt(this.JTHistoricoDetalle.getSelectedRow(), 2) + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + this.xModeloHD.getValueAt(this.JTHistoricoDetalle.getSelectedRow(), 0) + "'";
                this.consultas.ejecutarSQL(this.xsql);
                this.consultas.cerrarConexionBd();
                mCargarDatosTablaHistoricoDetalle(this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
                return;
            }
            return;
        }
        if (this.xliq.getxId_Liqidacion() == 0 && !this.xliq.JLB_NIngreso.getText().isEmpty()) {
            if (validarDatos() == 1) {
                if (!this.JLBNumero.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "Registro ya grabado!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                if (Double.valueOf(this.txtVrTotal.getValue().toString()).doubleValue() != 0.0d) {
                    int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y2 == 0) {
                        this.xsql = "INSERT INTO f_ordenes (Id_Ingreso,Id_TipoServicio,FechaOrden,HoraOrden,Id_Profesional,Id_Especialidad,Id_CentroCosto,TotalOrdenes,TotalEPS,TotalPaciente, Fecha,UsuarioS) values(" + this.xliq.JLB_NIngreso.getText() + "," + this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 0).toString() + ",'" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.txtHoraIni.getText() + "','" + this.cboCirujano.getPopupTable().getValueAt(this.cboCirujano.getSelectedIndex(), 0).toString() + "','" + this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0).toString() + "','" + this.cboCC.getPopupTable().getValueAt(this.cboCC.getSelectedIndex(), 0).toString() + "','" + this.txtVrTotal.getValue() + "','" + this.txtVrTotal.getValue() + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.JLBNumero.setText(this.consultas.ejecutarSQLId(this.xsql));
                        this.consultas.cerrarConexionBd();
                        for (int x = 0; x < this.grid.getRowCount(); x++) {
                            double VrBase = 0.0d;
                            double PorcCobro = 0.0d;
                            double VrCobro = 0.0d;
                            double PorcBilat = 0.0d;
                            double VrBilat = 0.0d;
                            if (this.modelo.getValueAt(x, 26).toString().equals("Si")) {
                                xescobrable = 1;
                            } else {
                                xescobrable = 0;
                            }
                            if (this.modelo.getValueAt(x, 41).toString().equals("Si")) {
                                xesconjunto = 1;
                                VrBase = Double.valueOf(this.modelo.getValueAt(x, 42).toString()).doubleValue();
                                PorcCobro = Double.valueOf(this.modelo.getValueAt(x, 51).toString()).doubleValue();
                                VrCobro = Double.valueOf(this.modelo.getValueAt(x, 43).toString()).doubleValue() - Double.valueOf(this.modelo.getValueAt(x, 65).toString()).doubleValue();
                                PorcBilat = Double.valueOf(this.modelo.getValueAt(x, 58).toString()).doubleValue();
                                VrBilat = Double.valueOf(this.modelo.getValueAt(x, 65).toString()).doubleValue();
                            } else {
                                xesconjunto = 0;
                            }
                            this.xsql = "insert into f_ordenesqx ( `Id_Orden` , `Id_Procedimiento`,Id_TipoServicio, `Id_TipoSala` , `Id_TipoAnestesia` ,  `Id_Especialidad` , `Id_profesional` , `Id_ProfAnestesia` , `Id_ProfAyudante` , `Id_ProfePerfusionista` ,  `HoraInicio` , `HoraFinal` ,`ViaAcceso`  , `Bilateral`,Grupo_UVR , `EsCobrable` , EsConjunto,`DxP`, `DxR` , `DxC` , `NOrden` ,VrBase,PorcCobro,VrCobro,PorcBilat,VrBilat, `Valor` , idModalidadAtencion, idServicioRips,idFinalidad, idMipres,  `UsuarioS`)Values('" + this.JLBNumero.getText() + "','" + this.modelo.getValueAt(x, 0) + "','" + this.modelo.getValueAt(x, 44) + "','" + this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 0).toString() + "','" + this.cboTipoAnestesia.getPopupTable().getValueAt(this.cboTipoAnestesia.getSelectedIndex(), 0).toString() + "','" + this.modelo.getValueAt(x, 17) + "','" + this.modelo.getValueAt(x, 28) + "','" + this.cboAnestesiologo.getPopupTable().getValueAt(this.cboAnestesiologo.getSelectedIndex(), 0).toString() + "','" + this.cboAyudante.getPopupTable().getValueAt(this.cboAyudante.getSelectedIndex(), 0).toString() + "','" + this.cboPerfusionista.getPopupTable().getValueAt(this.cboPerfusionista.getSelectedIndex(), 0).toString() + "','" + this.txtHoraIni.getValue() + "','" + this.txtHoraFin.getValue() + "','" + this.modelo.getValueAt(x, 5).toString() + "','" + this.modelo.getValueAt(x, 6).toString() + "','" + this.modelo.getValueAt(x, 2).toString() + "','" + xescobrable + "','" + xesconjunto + "','" + this.modelo.getValueAt(x, 7).toString() + "','" + this.modelo.getValueAt(x, 8).toString() + "','" + this.modelo.getValueAt(x, 9).toString() + "','" + x + "','" + Math.round(VrBase) + "','" + PorcCobro + "','" + Math.round(VrCobro) + "','" + PorcBilat + "','" + Math.round(VrBilat) + "','" + Math.round(Double.valueOf(this.modelo.getValueAt(x, 19).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 20).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 21).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 22).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 23).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 24).toString()).doubleValue() + Double.valueOf(this.modelo.getValueAt(x, 43).toString()).doubleValue()) + "','" + this.xliq.getIdModalidadAtencion() + "','" + this.modelo.getValueAt(x, 68).toString() + "','" + this.modelo.getValueAt(x, 70).toString() + "','" + this.modelo.getValueAt(x, 71).toString() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            String xid = this.consultas.ejecutarSQLId(this.xsql);
                            this.consultas.cerrarConexionBd();
                            int xorden = 0;
                            for (int z = 19; z < 25; z++) {
                                if (Double.valueOf(this.modelo.getValueAt(x, z).toString()).doubleValue() > 0.0d) {
                                    this.xsql = "insert into f_itemordenesqx (`Id_OrdenQX` , `Id_Procedimiento` , `OrdenLiq` , `Id_TipoHonorario` ,VrBase,PorcCobro,VrCobro,PorcBilat,VrBilat, `Valor`) values('" + xid + "','" + this.modelo.getValueAt(x, 29 + xorden).toString() + "','" + xorden + "','" + (xorden + 1) + "','" + Math.round(Double.valueOf(this.modelo.getValueAt(x, z - 9).toString()).doubleValue()) + "','" + Double.valueOf(this.modelo.getValueAt(x, z + 26).toString()) + "','" + Math.round(Double.valueOf(this.modelo.getValueAt(x, z).toString()).doubleValue() - Double.valueOf(this.modelo.getValueAt(x, z + 40).toString()).doubleValue()) + "','" + Double.valueOf(this.modelo.getValueAt(x, z + 33).toString()) + "','" + Math.round(Double.valueOf(this.modelo.getValueAt(x, z + 40).toString()).doubleValue()) + "','" + Math.round(Double.valueOf(this.modelo.getValueAt(x, z).toString()).doubleValue()) + "')";
                                    this.consultas.ejecutarSQL(this.xsql);
                                    this.consultas.cerrarConexionBd();
                                }
                                xorden++;
                            }
                        }
                        mGrabarNacimientos();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe registro liquidado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCargarTipoCobro() {
        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
            this.sql = "SELECT q_tipomanualqx.Id, q_tipomanualqx.Medico, q_tipomanualqx.Anestesia, q_tipomanualqx.Ayudante, q_tipomanualqx.Sala, q_tipomanualqx.Materia, q_tipomanualqx.Perfusion FROM   f_manual INNER JOIN  q_tipomanualqx ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id) INNER JOIN  f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) WHERE (f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "')";
        } else {
            this.sql = "SELECT  q_tipomanualqx.Id, q_tipomanualqx.Medico, q_tipomanualqx.Anestesia, q_tipomanualqx.Ayudante, q_tipomanualqx.Sala,    q_tipomanualqx.Materia, q_tipomanualqx.Perfusion    FROM   f_manual INNER JOIN  q_tipomanualqx    ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id)   INNER JOIN f_servicioempresaconv   ON ( f_servicioempresaconv.Id_Manual_n=f_manual.Id)    INNER JOIN  f_empresacontxconvenio    ON (f_empresacontxconvenio.Id= f_servicioempresaconv.Id_EmpresaConvenio) WHERE (f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "' AND f_servicioempresaconv.Id_TipoServicio='" + this.tipoServicio + "')";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.Valores = new int[7];
                this.Valores[0] = rs.getInt(1);
                this.Valores[1] = rs.getInt(2);
                this.Valores[2] = rs.getInt(3);
                this.Valores[3] = rs.getInt(4);
                this.Valores[4] = rs.getInt(5);
                this.Valores[5] = rs.getInt(6);
                this.Valores[6] = rs.getInt(7);
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarHonorario(String idProce, int fil, int col, String idCxPpal) {
        try {
            if (this.MetodoFact == 0) {
                this.sql = "SELECT  f_tarifaprocedimiento.VrMinimo  AS VrMin,          f_tarifaprocedimiento.VrMaximo  AS VrMax,          f_empresacontxconvenio.CualValor  FROM  f_empresacontxconvenio  INNER JOIN  f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)    WHERE (f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "' AND f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "')";
            } else if (this.MetodoFact == 1) {
                this.sql = "SELECT            \t     CASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t     END AS VrMin, \t     CASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\tEND AS VrMax, \t     f_empresacontxconvenio.CualValor\t   \t    FROM f_tarifaprocedimiento              INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)              INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)              INNER JOIN f_servicioempresaconv  ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id)              WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'                  AND f_servicioempresaconv.`Id_TipoServicio`='" + this.tipoServicio + "'                          AND f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "'             AND g_procedimiento.Estado=0";
            } else {
                this.sql = "SELECT  \t\t \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))) \t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))) \t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1) \t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2) \t\t\t     END)\t \t\tEND AS VrMin, \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))) \t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))) \t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1) \t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2) \t\t\t     END)\t \t\tEND \t\t AS VrMax, \t\t f_empresacontxconvenio.CualValor   \t    FROM \t\t    `f_tarifaprocedimiento` \t\t    INNER JOIN `g_procedimiento`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \t\t    INNER JOIN `f_manual`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Manual` = `f_manual`.`Id`) \t\t    INNER JOIN `f_servicioempresaconv`  \t\t\tON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`) \t\t    INNER JOIN `f_empresacontxconvenio`  \t\t\tON (`f_servicioempresaconv`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`) \t\t    LEFT JOIN `g_historico_salario_minimo`  \t\t\tON (`f_servicioempresaconv`.`Anno` = `g_historico_salario_minimo`.`Ano`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'                  AND f_servicioempresaconv.`Id_TipoServicio`='" + this.tipoServicio + "'                          AND f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "'             \t\tAND g_procedimiento.Estado=0";
            }
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            if (rs1.next()) {
                if (rs1.getString(3).equals("0")) {
                    if (rs1.getString(1) != null) {
                        this.modelo.setValueAt(Double.valueOf(rs1.getDouble(1)), fil, col);
                    } else {
                        this.modelo.setValueAt(0, fil, col);
                    }
                } else if (rs1.getString(2) != null) {
                    this.modelo.setValueAt(Double.valueOf(rs1.getDouble(2)), fil, col);
                } else {
                    this.modelo.setValueAt(0, fil, col);
                }
            }
            rs1.close();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarHonorario(String idProce, int fil, int col, String idCxPpal, String UVR) {
        try {
            if (this.MetodoFact == 0) {
                this.sql = "SELECT  f_tarifaprocedimiento.VrMinimo  AS VrMin,          f_tarifaprocedimiento.VrMaximo  AS VrMax,          f_empresacontxconvenio.CualValor  FROM  f_empresacontxconvenio  INNER JOIN  f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)    WHERE (f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "' AND f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "')";
            } else if (this.MetodoFact == 1) {
                this.sql = "SELECT            \t     CASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t     END AS VrMin, \t     CASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\tEND AS VrMax, \t     f_empresacontxconvenio.CualValor\t   \t    FROM f_tarifaprocedimiento              INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)              INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)              INNER JOIN f_servicioempresaconv  ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id)              WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'                  AND f_servicioempresaconv.`Id_TipoServicio`='" + this.tipoServicio + "'                          AND f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "'             AND g_procedimiento.Estado=0";
            } else {
                this.sql = "SELECT  \t\t \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))) \t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))) \t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1) \t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2) \t\t\t     END)\t \t\tEND AS VrMin, \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t \t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))) \t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1) \t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))) \t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))) \t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1) \t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2) \t\t\t     END)\t \t\tEND \t\t AS VrMax, \t\t f_empresacontxconvenio.CualValor   \t    FROM \t\t    `f_tarifaprocedimiento` \t\t    INNER JOIN `g_procedimiento`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \t\t    INNER JOIN `f_manual`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Manual` = `f_manual`.`Id`) \t\t    INNER JOIN `f_servicioempresaconv`  \t\t\tON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`) \t\t    INNER JOIN `f_empresacontxconvenio`  \t\t\tON (`f_servicioempresaconv`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`) \t\t    LEFT JOIN `g_historico_salario_minimo`  \t\t\tON (`f_servicioempresaconv`.`Anno` = `g_historico_salario_minimo`.`Ano`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'                  AND f_servicioempresaconv.`Id_TipoServicio`='" + this.tipoServicio + "'                          AND f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "'             \t\tAND g_procedimiento.Estado=0";
            }
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            if (rs1.next()) {
                if (rs1.getString(3).equals("0")) {
                    if (rs1.getString(1) != null) {
                        this.modelo.setValueAt(Double.valueOf(rs1.getDouble(1) * Long.parseLong(UVR)), fil, col);
                    } else {
                        this.modelo.setValueAt(0, fil, col);
                    }
                } else if (rs1.getString(2) != null) {
                    this.modelo.setValueAt(Double.valueOf(rs1.getDouble(2) * Long.parseLong(UVR)), fil, col);
                } else {
                    this.modelo.setValueAt(0, fil, col);
                }
            }
            rs1.close();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
        this.sql = "SELECT `f_tiposervicio`.`Id` , `f_tiposervicio`.`Nbre`,f_tiposervicio.`esConjunto` AS Tipo  ,  CASE (f_empresacontxconvenio.`MetodoFact`) WHEN\t0 THEN \t0 WHEN\t1 THEN\tf_servicioempresaconv.`Incr_Decrem` WHEN\t2 THEN\tf_servicioempresaconv.`Incr_Decrem` END AS Porcentaje FROM `f_tiposervtipoproced`  INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) INNER JOIN f_servicioempresaconv ON  f_servicioempresaconv.`Id_TipoServicio`=`f_tiposervicio`.`Id` INNER JOIN  f_empresacontxconvenio ON (f_empresacontxconvenio.`Id`=f_servicioempresaconv.`Id_EmpresaConvenio`) INNER JOIN  `f_tipoprocedimiento` ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)  INNER JOIN  `f_tipoclaseproc`  ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`) WHERE (`f_tipoclaseproc`.`EsQco` =0)  AND (f_empresacontxconvenio.`Id` ='" + this.xliq.getXidempresa() + "') group by `f_tiposervicio`.`Id` ";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoServicio, this.modelo, 1);
        if (this.MetodoFact == 0 || this.MetodoFact == 1) {
            this.sql = "SELECT DISTINCT q_tiposala.Id, q_tiposala.Nbre, q_tiposala.InCruento FROM      q_grupouvr INNER JOIN  q_tipomanualqx          ON (q_grupouvr.Id_TipoManualQX = q_tipomanualqx.Id)     INNER JOIN  q_tiposala          ON (q_grupouvr.Id_TipoSala = q_tiposala.Id)     INNER JOIN  f_manual          ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id)     INNER JOIN  f_empresacontxconvenio          ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) WHERE (f_empresacontxconvenio.`Id` ='" + this.xliq.getXidempresa() + "')";
        } else {
            this.sql = "SELECT DISTINCT q_tiposala.Id, q_tiposala.Nbre, q_tiposala.InCruento FROM   q_grupouvr INNER JOIN  q_tipomanualqx    ON (q_grupouvr.Id_TipoManualQX = q_tipomanualqx.Id)   INNER JOIN  q_tiposala    ON (q_grupouvr.Id_TipoSala = q_tiposala.Id)   INNER JOIN  f_manual    ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id)   INNER JOIN f_servicioempresaconv \t ON ( f_servicioempresaconv.Id_Manual_n=f_manual.Id)\t   INNER JOIN  f_empresacontxconvenio    ON (f_empresacontxconvenio.Id= f_servicioempresaconv.Id_EmpresaConvenio)   WHERE (f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "' )";
        }
        this.consultas.llenarComboTabla(this.sql, this.cboTipoSala, this.modelo, 1);
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional WHERE (Anestesiologia =1) group by Id_Persona ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboAnestesiologo, this.modelo, 1);
        this.sql = "SELECT Id, Nbre, GeneraCobro FROM q_tipoanestesia WHERE estado = 0 ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoAnestesia, this.modelo, 1);
        this.sql = "SELECT Id, Nbre as Centro_Costo FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboCC, this.modelo, 1);
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional group by Id_Persona  ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboAyudante, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboPerfusionista, this.modelo, 1);
        this.sql = "SELECT Id, Nbre FROM  g_especialidad WHERE (Es_Qx =1 AND Estado =0) ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboEspecialidad, this.modelo, 1);
        this.JCBDestino.removeAllItems();
        this.idDestino = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `g_tipodestino` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.idDestino, this.JCBDestino);
        this.JCBDestino.setSelectedIndex(-1);
        this.xTipoParto = this.consultas.llenarCombo("SELECT  `Id` , `Nbre` FROM `f_tipoparto`", this.xTipoParto, this.JCBTParto);
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.JCBFinalidad.removeAllItems();
        this.xsql = "SELECT `Id` , `Nbre` FROM `f_tipofinprocedimiento` ORDER BY `Nbre` ASC ";
        this.xId_Finalidad = this.xct.llenarCombo(this.xsql, this.xId_Finalidad, this.JCBFinalidad);
        this.JCBFinalidad.setSelectedItem("No aplica");
        limpiarCombos();
        this.cboLleno = 1;
        this.JCBGrupoSevicio.setSelectedItem("Quirúrgico");
        this.consultas.cerrarConexionBd();
    }

    private void cargarProcedim() {
        if (this.esConjunto.equals("1")) {
            switch (this.MetodoFact) {
                case 0:
                    this.sql = "SELECT  f_tarifaprocedimiento.Id_Procedimiento AS Id,      f_tarifaprocedimiento.CodCUPS,      0 AS P,      0 AS GrupoUvr,     g_procedimiento.NivelComplejidad,      0 AS IdGrupoUVR,      0 AS Orden,        IF(IFNULL(f_procedempresaconvenio.Valor,0)=0, IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor) AS Valor_Conjunto,      g_procedimiento.Nbre AS Procedimiento      FROM f_tarifaprocedimiento      INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)      INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)      LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n    INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)      INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)      INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)      WHERE (f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'     AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "'     AND g_procedimiento.Estado=0)  HAVING Valor_Conjunto<>0     ORDER BY Procedimiento ASC;";
                    break;
                case 1:
                    this.sql = "SELECT      f_tarifaprocedimiento.Id_Procedimiento AS Id,              f_tarifaprocedimiento.CodCUPS,      0 AS P,              0 AS GrupoUvr,             g_procedimiento.NivelComplejidad,              0 AS IdGrupoUVR,              0 AS Orden,              IF(f_empresacontxconvenio.CualValor=0,  \t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\tEND, \t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\tEND) AS Valor_Conjunto,               g_procedimiento.Nbre AS Procedimiento             FROM f_tarifaprocedimiento              INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)              INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)      LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)              INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)              INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)             INNER JOIN f_servicioempresaconv              ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id)               AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'             AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "'             AND g_procedimiento.Estado=0 HAVING Valor_Conjunto<>0            ORDER BY Procedimiento ASC;          ";
                    break;
                case 2:
                    this.sql = "SELECT  \t\t             f_tarifaprocedimiento.Id_Procedimiento AS Id,              f_tarifaprocedimiento.CodCUPS,      0 AS P,              0 AS GrupoUvr,             g_procedimiento.NivelComplejidad,              0 AS IdGrupoUVR,              0 AS Orden,             IF(f_empresacontxconvenio.CualValor=0,  \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor) \t\t\t     END)\t \t\tEND, \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor) \t\t\t     END)\t \t\tEND \t\t) AS Valor_Conjunto,               g_procedimiento.Nbre AS Procedimiento  \t    FROM \t\t    `f_tarifaprocedimiento` \t\t    INNER JOIN `g_procedimiento`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \t\t    INNER JOIN `f_tipoplan`  \t\t\tON (`f_tarifaprocedimiento`.`Id_TipoPlan` = `f_tipoplan`.`Id`) \t\t    INNER JOIN `f_manual`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Manual` = `f_manual`.`Id`) \t\t    INNER JOIN `f_tipoprocedimiento`  \t\t\tON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \t\t    INNER JOIN `f_servicioempresaconv`  \t\t\tON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`) \t\t    INNER JOIN `f_empresacontxconvenio`  \t\t\tON (`f_servicioempresaconv`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`)     LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n\t\t    INNER JOIN `f_tiposervtipoproced`  \t\t\tON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) AND (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervtipoproced`.`Idtiposervicio`) \t\t    LEFT JOIN `g_historico_salario_minimo`  \t\t\tON (`f_servicioempresaconv`.`Anno` = `g_historico_salario_minimo`.`Ano`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'             AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "' \t\t\t    AND g_procedimiento.Estado=0  HAVING Valor_Conjunto<>0\t\t       ORDER BY Procedimiento ASC;                     \t\t";
                    break;
            }
        } else if (this.esConjunto.equals("2")) {
            if (this.MetodoFact == 0) {
                this.sql = "SELECT  f_tarifaprocedimiento.Id_Procedimiento AS Id,      f_tarifaprocedimiento.CodCUPS,      0 AS P,      0 AS GrupoUvr,     g_procedimiento.NivelComplejidad,      0 AS IdGrupoUVR,      0 AS Orden,        IF(IFNULL(f_procedempresaconvenio.Valor,0)=0, IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor) AS Valor_Conjunto,      g_procedimiento.Nbre AS Procedimiento      FROM f_tarifaprocedimiento      INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)      INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)      LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n    INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)      INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)      INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)      WHERE (f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'     AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "'     AND g_procedimiento.Estado=0)  HAVING Valor_Conjunto<>0     ORDER BY Procedimiento ASC;";
            } else if (this.MetodoFact == 1) {
                this.sql = "SELECT      f_tarifaprocedimiento.Id_Procedimiento AS Id,              f_tarifaprocedimiento.CodCUPS,      0 AS P,              0 AS GrupoUvr,             g_procedimiento.NivelComplejidad,              0 AS IdGrupoUVR,              0 AS Orden,              IF(f_empresacontxconvenio.CualValor=0,  \t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\tEND, \t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\tEND) AS Valor_Conjunto,               g_procedimiento.Nbre AS Procedimiento             FROM f_tarifaprocedimiento              INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)              INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual)      LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)              INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)              INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)             INNER JOIN f_servicioempresaconv              ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id)               AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'             AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "'             AND g_procedimiento.Estado=0 HAVING Valor_Conjunto<>0            ORDER BY Procedimiento ASC;          ";
            } else if (this.MetodoFact == 2) {
                this.sql = "SELECT  DISTINCT\t\t             f_tarifaprocedimiento.Id_Procedimiento AS Id,              f_tarifaprocedimiento.CodCUPS,      0 AS P,               q_procedtipomanqx.Grupo_UVR,             g_procedimiento.NivelComplejidad,              q_grupouvr.Id AS IdGrupoUVR,              q_grupouvr.Orden,             IF(f_empresacontxconvenio.CualValor=0,  \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor) \t\t\t     END)\t \t\tEND, \t\tCASE (f_manual.AplicaFactor) \t\t   WHEN 0 THEN \t\t\tCASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\tEND \t\t   WHEN 1 THEN \t\t\tIF(f_servicioempresaconv.AplicaFactor=0, \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t \t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor) \t\t\t     END,\t \t\t\t     CASE (f_empresacontxconvenio.Redondeo) \t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor) \t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor,0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)+ \t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.`VSDiario`),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor) \t\t\t     END)\t \t\tEND \t\t) AS Valor_Conjunto,               g_procedimiento.Nbre AS Procedimiento  \t    FROM \t\t    `f_tarifaprocedimiento` \t\t    INNER JOIN `g_procedimiento`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)              INNER JOIN q_procedtipomanqx                 ON ( q_procedtipomanqx.Id_Procedimiento = g_procedimiento.Id )              INNER JOIN q_grupouvr                 ON (  q_procedtipomanqx.Id_GrupoUVRQx = q_grupouvr.Id )                   AND ( q_procedtipomanqx.Id_TipoManualQx = q_grupouvr.Id_TipoManualQX ) \t\t    INNER JOIN `f_tipoplan`  \t\t\tON (`f_tarifaprocedimiento`.`Id_TipoPlan` = `f_tipoplan`.`Id`) \t\t    INNER JOIN `f_manual`  \t\t\tON (`f_tarifaprocedimiento`.`Id_Manual` = `f_manual`.`Id`)                   AND (q_grupouvr.Id_TipoManualQX = f_manual.Id_TipoManQx)  \t\t    INNER JOIN `f_tipoprocedimiento`  \t\t\tON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \t\t    INNER JOIN `f_servicioempresaconv`  \t\t\tON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`) \t\t    INNER JOIN `f_empresacontxconvenio`  \t\t\tON (`f_servicioempresaconv`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`)     LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n\t\t    INNER JOIN `f_tiposervtipoproced`  \t\t\tON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) AND (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervtipoproced`.`Idtiposervicio`) \t\t    LEFT JOIN `g_historico_salario_minimo`  \t\t\tON (`f_servicioempresaconv`.`Anno` = `g_historico_salario_minimo`.`Ano`)             WHERE f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'             AND f_tiposervtipoproced.Idtiposervicio='" + this.tipoServicio + "' \t\t\t    AND g_procedimiento.Estado=0  HAVING Valor_Conjunto<>0\t\t       ORDER BY Procedimiento ASC;                     \t\t";
            }
        } else if (this.MetodoFact == 0 || this.MetodoFact == 1) {
            this.sql = "SELECT DISTINCT g_procedimiento.Id, q_procedtipomanqx.CodCups,  0 AS P,  q_procedtipomanqx.Grupo_UVR, g_procedimiento.NivelComplejidad, q_grupouvr.Id AS IdGrupoUVR, q_grupouvr.Orden , g_procedimiento.Nbre AS Procedimiento     FROM   q_procedtipomanqx     INNER JOIN g_procedimiento          ON (q_procedtipomanqx.Id_Procedimiento = g_procedimiento.Id)     INNER JOIN f_tiposervtipoproced          ON (g_procedimiento.Id_tipoprocedimiento = f_tiposervtipoproced.Idtipoprocedimiento)     INNER JOIN q_grupouvr          ON (q_procedtipomanqx.Id_GrupoUVRQx = q_grupouvr.Id) AND (q_procedtipomanqx.Id_TipoManualQx = q_grupouvr.Id_TipoManualQX)     INNER JOIN f_manual          ON (f_manual.Id_TipoManQx = q_grupouvr.Id_TipoManualQX)     INNER JOIN f_tiposervicio          ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id)     INNER JOIN f_empresacontxconvenio          ON (f_empresacontxconvenio.Id_Manual = f_manual.Id)     WHERE      f_tiposervicio.Id ='" + this.tipoServicio + "'  AND  f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'      ORDER BY  g_procedimiento.Nbre;    ";
        } else {
            this.sql = "SELECT DISTINCT g_procedimiento.Id, q_procedtipomanqx.CodCups,  0 AS P,q_procedtipomanqx.Grupo_UVR,                  g_procedimiento.NivelComplejidad, q_grupouvr.Id AS IdGrupoUVR, q_grupouvr.Orden, g_procedimiento.Nbre AS Procedimiento  FROM     q_procedtipomanqx     INNER JOIN g_procedimiento          ON (q_procedtipomanqx.Id_Procedimiento = g_procedimiento.Id)     INNER JOIN f_tiposervtipoproced          ON (g_procedimiento.Id_tipoprocedimiento = f_tiposervtipoproced.Idtipoprocedimiento)     INNER JOIN q_grupouvr          ON (q_procedtipomanqx.Id_GrupoUVRQx = q_grupouvr.Id) AND (q_procedtipomanqx.Id_TipoManualQx = q_grupouvr.Id_TipoManualQX)     INNER JOIN f_manual          ON (q_grupouvr.Id_TipoManualQX = f_manual.Id_TipoManQx)     INNER JOIN f_tiposervicio          ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id)     INNER JOIN f_servicioempresaconv          ON (f_servicioempresaconv.Id_TipoServicio = f_tiposervicio.Id)     INNER JOIN f_empresacontxconvenio          ON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)          AND (f_servicioempresaconv.Id_Manual_n = f_manual.Id)      WHERE      f_tiposervicio.Id ='" + this.tipoServicio + "'  AND  f_empresacontxconvenio.Id ='" + this.xliq.getXidempresa() + "'      ORDER BY  g_procedimiento.Nbre ";
        }
        System.out.println("Sql para proced :" + this.sql);
        if (this.esConjunto.equals("1") || this.esConjunto.equals("2")) {
            this.consultas.llenarComboTabla(this.sql, this.cboCirugia, this.modelo, 8);
        } else {
            this.consultas.llenarComboTabla(this.sql, this.cboCirugia, this.modelo, 7);
        }
        this.consultas.cerrarConexionBd();
    }

    private void cargarCirujano() {
        this.cboCirujano.removeAll();
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional WHERE (Es_Qx =1 and IdEspecialidad='" + this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0) + "') ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboCirujano, this.modelo, 1);
        this.consultas.cerrarConexionBd();
    }

    private void mCrearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Facturacion.JPQuirurgico.1
            Class[] types = {String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, Double.class, Double.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, false, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modelo.addColumn("Código");
        this.modelo.addColumn("Procedimiento Qco");
        this.modelo.addColumn("Grupo/UVR");
        this.modelo.addColumn("Especialidad");
        this.modelo.addColumn("Profesional");
        this.modelo.addColumn("Via Acceso");
        this.modelo.addColumn("Bilateral");
        this.modelo.addColumn("Dx. Ppal");
        this.modelo.addColumn("Dx. Rel");
        this.modelo.addColumn("Dx. Compl");
        this.modelo.addColumn("Hon. Médicos");
        this.modelo.addColumn("Hon. Anest.");
        this.modelo.addColumn("Hon. Ayud.");
        this.modelo.addColumn("Der. Sala");
        this.modelo.addColumn("Material");
        this.modelo.addColumn("Perfusión");
        this.modelo.addColumn("Orden");
        this.modelo.addColumn("Id_Esp");
        this.modelo.addColumn("Orden_A");
        this.modelo.addColumn("Vr. Méd");
        this.modelo.addColumn("Vr. Anest");
        this.modelo.addColumn("Vr. Ayud");
        this.modelo.addColumn("Vr. Sala");
        this.modelo.addColumn("Vr. Mater");
        this.modelo.addColumn("Vr. Perfus");
        this.modelo.addColumn("Cod. Autoriz.");
        this.modelo.addColumn("Cobrable");
        this.modelo.addColumn("IdGrupoUVR");
        this.modelo.addColumn("Id_Profesional");
        this.modelo.addColumn("Cod. Méd");
        this.modelo.addColumn("Cod. Anest");
        this.modelo.addColumn("Cod. Ayud");
        this.modelo.addColumn("Cod. Sala");
        this.modelo.addColumn("Cod. Mater");
        this.modelo.addColumn("Cod. Perfus");
        this.modelo.addColumn("Vr. Méd");
        this.modelo.addColumn("Vr. Anest_O");
        this.modelo.addColumn("Vr. Ayud_O");
        this.modelo.addColumn("Vr. Sala_O");
        this.modelo.addColumn("Vr. Mater_O");
        this.modelo.addColumn("Vr. Perfus_O");
        this.modelo.addColumn("Es Conjunto");
        this.modelo.addColumn("Vr. Conjunto");
        this.modelo.addColumn("Vr. Cobrado Conjunto");
        this.modelo.addColumn("Cod. Servicio");
        this.modelo.addColumn("%  Médico");
        this.modelo.addColumn("%  Anestesia");
        this.modelo.addColumn("%  Ayudante");
        this.modelo.addColumn("%  Sala");
        this.modelo.addColumn("%  Material");
        this.modelo.addColumn("%  Perfusión");
        this.modelo.addColumn("% Conjunto");
        this.modelo.addColumn("% Bilateral Méd");
        this.modelo.addColumn("% Bilateral Anest");
        this.modelo.addColumn("% Bilateral Ayudante");
        this.modelo.addColumn("% Bilateral Sala");
        this.modelo.addColumn("% Bilateral Material");
        this.modelo.addColumn("% Bilateral Perfusion");
        this.modelo.addColumn("% Bilateral Conjunto");
        this.modelo.addColumn("Vr. Bil. Médico");
        this.modelo.addColumn("Vr. Bil. Anest");
        this.modelo.addColumn("Vr. Bil. Ayudante");
        this.modelo.addColumn("Vr. Bil. Sala");
        this.modelo.addColumn("Vr. Bil. Material");
        this.modelo.addColumn("Vr. Bil. Perfusión");
        this.modelo.addColumn("Vr. Bil. Conjunto");
        this.modelo.addColumn("Código Grupo");
        this.modelo.addColumn("Nombre Grupo");
        this.modelo.addColumn("Código Servicio Rips");
        this.modelo.addColumn("Nombre Servicio Rips");
        this.modelo.addColumn("IdFinalidad");
        this.modelo.addColumn("Numero Mipres");
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(27).setMinWidth(0);
        this.grid.getColumnModel().getColumn(27).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(28).setMinWidth(0);
        this.grid.getColumnModel().getColumn(28).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(29).setMinWidth(0);
        this.grid.getColumnModel().getColumn(29).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(30).setMinWidth(0);
        this.grid.getColumnModel().getColumn(30).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(31).setMinWidth(0);
        this.grid.getColumnModel().getColumn(31).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(32).setMinWidth(0);
        this.grid.getColumnModel().getColumn(32).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(33).setMinWidth(0);
        this.grid.getColumnModel().getColumn(33).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(34).setMinWidth(0);
        this.grid.getColumnModel().getColumn(34).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(35).setMinWidth(0);
        this.grid.getColumnModel().getColumn(35).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(36).setMinWidth(0);
        this.grid.getColumnModel().getColumn(36).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(37).setMinWidth(0);
        this.grid.getColumnModel().getColumn(37).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(38).setMinWidth(0);
        this.grid.getColumnModel().getColumn(38).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(39).setMinWidth(0);
        this.grid.getColumnModel().getColumn(39).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(40).setMinWidth(0);
        this.grid.getColumnModel().getColumn(40).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(41).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(42).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(43).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(44).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(44).setMinWidth(80);
        this.grid.getColumnModel().getColumn(44).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(45).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(45).setMinWidth(80);
        this.grid.getColumnModel().getColumn(45).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(46).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(46).setMinWidth(80);
        this.grid.getColumnModel().getColumn(46).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(47).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(47).setMinWidth(80);
        this.grid.getColumnModel().getColumn(47).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(48).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(48).setMinWidth(80);
        this.grid.getColumnModel().getColumn(48).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(49).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(49).setMinWidth(80);
        this.grid.getColumnModel().getColumn(49).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(50).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(50).setMinWidth(80);
        this.grid.getColumnModel().getColumn(50).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(51).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(51).setMinWidth(80);
        this.grid.getColumnModel().getColumn(51).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(52).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(52).setMinWidth(80);
        this.grid.getColumnModel().getColumn(52).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(53).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(54).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(55).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(56).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(57).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(58).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(59).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(60).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(61).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(62).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(63).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(64).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(65).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(66).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(67).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(68).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(69).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(70).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(71).setPreferredWidth(100);
        this.filaGrid = 0;
        this.grid.setModel(this.modelo);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Valor", "Especialidad", "Profesional", "Centro Costo", "Estado"}) { // from class: Facturacion.JPQuirurgico.2
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xModelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    public void mCargarDatosTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `f_ordenes`.`Id` , DATE_FORMAT(`f_ordenes`.`FechaOrden`,'%d-%m-%Y') , `f_tiposervicio`.`Nbre` , `f_ordenes`.`TotalOrdenes` ,`profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `f_centrocosto`.`Nbre` , `f_ordenes`.`Estado` FROM `f_ordenes` INNER JOIN `f_tiposervicio`  ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN f_ordenesqx  ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) INNER JOIN `f_centrocosto` ON (`f_ordenes`.`Id_CentroCosto` = `f_centrocosto`.`Id`)  WHERE (`f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso` ='" + this.xliq.JLB_NIngreso.getText() + "') GROUP BY `f_ordenes`.`Id` ORDER BY `f_ordenes`.`FechaOrden` DESC, `f_tiposervicio`.`Nbre` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTHistorico, 4);
                this.xmt.mEstablecerTextEditor(this.JTHistorico, 5);
                this.xmt.mEstablecerTextEditor(this.JTHistorico, 6);
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xModelo.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo.setValueAt(xrs.getString(6), x, 5);
                    this.xModelo.setValueAt(xrs.getString(7), x, 6);
                    this.xModelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(8)), x, 7);
                    x++;
                }
            } else {
                mCrearTabla();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistoricoDetalle() {
        this.xModeloHD = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Nº Autorizacion"}) { // from class: Facturacion.JPQuirurgico.3
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoDetalle.setModel(this.xModeloHD);
        this.JTHistoricoDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTHistoricoDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTHistoricoDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void mCargarDatosTablaHistoricoDetalle(String xidorden) {
        try {
            mCrearTablaHistoricoDetalle();
            this.xsql = "SELECT `f_ordenesqx`.`Id`, `g_procedimiento`.`Nbre` AS `Procedimiento`, `f_ordenesqx`.`NAutorizacion` FROM `f_ordenesqx`\nINNER JOIN `g_procedimiento` ON (`f_ordenesqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nWHERE (`f_ordenesqx`.`Id_Orden` ='" + xidorden + "' AND `f_ordenesqx`.`Estado` =1) ORDER BY `Procedimiento` ASC;";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTHistoricoDetalle, 1);
                while (xrs.next()) {
                    this.xModeloHD.addRow(this.xDatos3);
                    this.xModeloHD.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModeloHD.setValueAt(xrs.getString(2), x, 1);
                    this.xModeloHD.setValueAt(xrs.getString(3), x, 2);
                    x++;
                }
            } else {
                mCrearTabla();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (this.xliq.getxId_Liqidacion() == 0) {
            if (this.JTHistorico.getSelectedRow() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "FacturacionQX", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa; No se puede anular el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular(String xid, String xdetalle) {
        this.xsql = "update f_ordenes set `Estado`=1, `Id_MotivoAnulacion`='" + xid + "', `Detalle_Anulacion`='" + xdetalle + "', `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDatosTabla();
    }

    public void grabar() {
        if (validarDatos() == 1) {
            this.metodos.mostrarMensaje("Cirugías Grabadas");
        }
    }

    private void limpiarCombos() {
        this.cboTipoServicio.setSelectedItem("");
        this.cboTipoSala.setSelectedIndex(-1);
        this.cboAnestesiologo.setSelectedIndex(-1);
        this.cboAyudante.setSelectedIndex(-1);
        this.cboPerfusionista.setSelectedIndex(-1);
        this.cboTipoAnestesia.setSelectedIndex(-1);
        this.cboCirujano.setSelectedIndex(-1);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboCirugia.setSelectedIndex(-1);
        this.txtCodDxPpal.setText("");
        this.txtDxPpal.setText("");
        this.txtDxRel.setText("");
        this.txtCodDxRel.setText("");
        this.txtCodDxCompli.setText("");
        this.txtDxCompli.setText("");
        this.JCBTParto.setSelectedIndex(-1);
    }

    private void limpiarValor() {
        this.txtVrHonorarios.setValue(0);
        this.txtVrAnestesiologo.setValue(0);
        this.txtVrAyudante.setValue(0);
        this.txtVrSala.setValue(0);
        this.txtValorMateriales.setValue(0);
        this.txtVrPerfusionista.setValue(0);
        this.txtVrConjunto.setValue(0);
        this.txtVrTotal.setValue(0);
    }

    public void nuevo() {
        limpiarCombos();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHoraIni.setText("");
        this.txtHoraFin.setText("");
        this.btnIgualVia.setSelected(true);
        this.btnBilateralNo.setSelected(true);
        this.txtCodDxPpal.setText("");
        this.txtCodDxRel.setText("");
        this.txtCodDxCompli.setText("");
        this.txtVrHonorarios.setValue(0);
        this.txtVrAnestesiologo.setValue(0);
        this.txtVrAyudante.setValue(0);
        this.txtVrPerfusionista.setValue(0);
        this.txtVrSala.setValue(0);
        this.txtValorMateriales.setValue(0);
        this.txtVrConjunto.setValue(0);
        this.txtVrTotal.setValue(0);
        mCrearGrid();
        mCreaModeloRN();
    }

    private Double redondear(Double valor) {
        Double valor2;
        Double residuo = Double.valueOf(valor.doubleValue() % 100.0d);
        if (residuo.doubleValue() >= 50.0d) {
            valor2 = Double.valueOf(valor.doubleValue() + (100.0d - residuo.doubleValue()));
        } else {
            valor2 = Double.valueOf(valor.doubleValue() - residuo.doubleValue());
        }
        return valor2;
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.JTP_Cirugia.getSelectedIndex() == 3) {
            if (this.JTHistoricoDetalle.getSelectedRow() == -1) {
                this.metodos.mostrarMensaje("Por favor seleccionar un registro en el detalle del historico");
            } else {
                retorno = 1;
            }
        } else if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor coloque la Fecha de la Cirugía");
            this.txtFecha.requestFocus();
        } else if (this.txtHoraIni.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor coloque la Hora de Inicio de la Cirugía");
            this.txtHoraIni.requestFocus();
        } else if (this.txtHoraFin.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor coloque la Hora de Finalización de la Cirugía");
            this.txtHoraFin.requestFocus();
        } else if (this.cboTipoServicio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Servicio");
            this.cboTipoServicio.requestFocus();
        } else if (this.cboCC.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Centro de Costos");
            this.cboCC.requestFocus();
        } else if (this.cboTipoSala.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Sala");
            this.cboTipoSala.requestFocus();
        } else if (this.cboAnestesiologo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Anestesiologo que interviene en la Cirugía");
            this.cboAnestesiologo.requestFocus();
        } else if (this.cboTipoAnestesia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Anestesia");
            this.cboTipoAnestesia.requestFocus();
        } else if (this.cboAyudante.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Ayudante");
            this.cboAyudante.requestFocus();
        } else if (this.cboPerfusionista.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Perfusionista");
            this.cboPerfusionista.requestFocus();
        } else if (this.grid.getRowCount() <= 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Cirugía para liquidar");
            this.cboCirugia.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "recien_nacidos", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscarPatologiaCx(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "Cirugias", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloRN() {
        this.xmodeloRN = new DefaultTableModel(new Object[0], new String[]{"No. Hijo", "TParto", "FechaNac", "HoraNac", "EstadoNacido", "CPrenatal", "EdadGest", "Sexo", "Peso", "Talla", "Apgar", "Dx_Nac", "Dx_Muerte", "FechaM", "HoraM", "IdTipoParto", "idDestino", "numeroControles"}) { // from class: Facturacion.JPQuirurgico.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNacimiento.setModel(this.xmodeloRN);
        this.JTDetalleNacimiento.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleNacimiento.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(11).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(12).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(14).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(15).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(16).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(17).setPreferredWidth(30);
    }

    private void mAdicionarNacimientos() {
        this.xmodeloRN.addRow(this.xDatos4);
        int n = this.JTDetalleNacimiento.getRowCount() - 1;
        this.xmodeloRN.setValueAt(Integer.valueOf(n + 1), n, 0);
        this.xmodeloRN.setValueAt(this.JCBTParto.getSelectedItem(), n, 1);
        this.xmodeloRN.setValueAt(this.metodos.formatoAMD.format(this.JDC_NFecha.getDate()), n, 2);
        this.xmodeloRN.setValueAt(this.JTFF_NHora.getText(), n, 3);
        if (this.xEstadoNacido == 1) {
            this.xmodeloRN.setValueAt("VIVO", n, 4);
        } else {
            this.xmodeloRN.setValueAt("MUERTO", n, 4);
            this.xmodeloRN.setValueAt(this.metodos.formatoAMD.format(this.JDC_NFechaM.getDate()), n, 13);
            this.xmodeloRN.setValueAt(this.JTFF_NHoraM.getText(), n, 14);
        }
        if (this.xCPrenatal == 1) {
            this.xmodeloRN.setValueAt("SI", n, 5);
        } else {
            this.xmodeloRN.setValueAt("NO", n, 5);
        }
        this.xmodeloRN.setValueAt(this.JTFF_EdadGestacional.getText(), n, 6);
        this.xmodeloRN.setValueAt(this.xSexo, n, 7);
        this.xmodeloRN.setValueAt(Double.valueOf(this.JTFFSPeso.getText()), n, 8);
        this.xmodeloRN.setValueAt(Double.valueOf(this.JTFFSTalla.getText()), n, 9);
        this.xmodeloRN.setValueAt(this.JTFAPGar.getText(), n, 10);
        this.xmodeloRN.setValueAt(this.JTFCDxP.getText(), n, 11);
        this.xmodeloRN.setValueAt(this.JTFCDxPM.getText(), n, 12);
        this.xmodeloRN.setValueAt(this.xTipoParto[this.JCBTParto.getSelectedIndex()], n, 15);
        this.xmodeloRN.setValueAt(this.idDestino[this.JCBDestino.getSelectedIndex()], n, 16);
        this.xmodeloRN.setValueAt(this.JTFFNControles.getText(), n, 17);
    }

    private void mGrabarNacimientos() {
        for (int i = 0; i < this.JTDetalleNacimiento.getRowCount(); i++) {
            ItemsRipsNacimientosDTO e = new ItemsRipsNacimientosDTO();
            e.setIdOrdenQx(this.JLBNumero.getText());
            e.setIdIngreso(Long.valueOf(this.xliq.JLB_NIngreso.getText()));
            e.setNHijo(Integer.valueOf(this.xmodeloRN.getValueAt(i, 0).toString()).intValue());
            e.setIdTipoParto(Integer.valueOf(this.xmodeloRN.getValueAt(i, 15).toString()).intValue());
            e.setApgar(Integer.valueOf(this.xmodeloRN.getValueAt(i, 10).toString()).intValue());
            e.setDiagnosticoMuerteN(this.xmodeloRN.getValueAt(i, 12).toString());
            e.setDiagnosticoNacido(this.xmodeloRN.getValueAt(i, 11).toString());
            e.setEdadGestacional(Integer.valueOf(this.xmodeloRN.getValueAt(i, 6).toString()).intValue());
            if (this.xmodeloRN.getValueAt(i, 4).toString().equals("VIVO")) {
                e.setEstadoNacido(1);
            } else {
                e.setEstadoNacido(0);
                e.setFechaMuerte(this.xmodeloRN.getValueAt(i, 13).toString());
                e.setHoraMuere(this.xmodeloRN.getValueAt(i, 14).toString());
            }
            e.setFechaNacimiento(this.xmodeloRN.getValueAt(i, 2).toString());
            e.setHoraNacimiento(this.xmodeloRN.getValueAt(i, 3).toString());
            e.setIdSexo(this.xmodeloRN.getValueAt(i, 7).toString());
            e.setPeso(Double.valueOf(this.xmodeloRN.getValueAt(i, 8).toString()).doubleValue());
            e.setTalla(Double.valueOf(this.xmodeloRN.getValueAt(i, 9).toString()).doubleValue());
            if (this.xmodeloRN.getValueAt(i, 5).toString().equals("SI")) {
                e.setCPrenatal(true);
            } else {
                e.setCPrenatal(false);
            }
            e.setNumeroControles(Integer.valueOf(this.xmodeloRN.getValueAt(i, 17).toString()));
            e.setIdDestino(Integer.valueOf(this.xmodeloRN.getValueAt(i, 16).toString()));
            this.liquidacionCirugiaDAO.mCreateItemsRipsNacimiento(e);
        }
        this.liquidacionCirugiaDAO.mActualizarIdOrdenQxHistoria(this.JLBNumero.getText(), String.valueOf(this.xid_HOrdenQX));
    }

    private void mBuscaInformacionNacidos() {
        ResultSet xrs = this.consultas.traerRs("SELECT `f_itemripsnacido`.`NoHijo` , `f_tipoparto`.`Nbre` AS TParto  , `f_itemripsnacido`.`FechaN` , `f_itemripsnacido`.`HoraN`     , IF(`f_itemripsnacido`.`EstadoN`=1,'VIVO','MUERTO') AS EstadoN  , IF(`f_itemripsnacido`.`CPrenatal`=1,'SI','NO') AS CPrenatal, `f_itemripsnacido`.`EdadG` , `f_itemripsnacido`.`Id_Sexo`     , `f_itemripsnacido`.`Peso` , `f_itemripsnacido`.`Talla` , `f_itemripsnacido`.`Apgar` , `f_itemripsnacido`.`DxN`     , `f_itemripsnacido`.`DxM` , `f_itemripsnacido`.`FechaM` , `f_itemripsnacido`.`HoraM`  FROM `f_itemripsnacido` INNER JOIN `f_tipoparto`  ON (`f_itemripsnacido`.`Id_TipoParto` = `f_tipoparto`.`Id`)  WHERE (`f_itemripsnacido`.`Id_Orden` =1 AND f_itemripsnacido.`Estado`=1);");
        mCreaModeloRN();
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloRN.addRow(this.xDatos2);
                    this.xmodeloRN.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloRN.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloRN.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloRN.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloRN.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloRN.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloRN.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloRN.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloRN.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodeloRN.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xmodeloRN.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloRN.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloRN.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloRN.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloRN.setValueAt(xrs.getString(15), n, 14);
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLimpiaRNacido() {
        this.JDC_NFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_NHora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JTFCDxPM.setEnabled(false);
        this.JBBUscarDxM.setEnabled(false);
        this.JDC_NFechaM.setDate((Date) null);
        this.JDC_NFechaM.setEnabled(false);
        this.JTFF_NHoraM.setText("");
        this.JTFF_NHoraM.setEnabled(false);
        this.JTFF_EdadGestacional.setText("0");
        this.JTFAPGar.setText("0");
        this.xEstadoNacido = 1;
        this.xCPrenatal = 0;
        this.JRBVivo.setSelected(true);
        this.JRB_NCpNo.setSelected(true);
        this.JRB_Masc.setSelected(true);
        this.xSexo = "M";
        this.JCBTParto.setSelectedIndex(-1);
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFCDxPM.setText("");
        this.JTFNCodigoDxPM.setText("");
        this.JTFFSPeso.setText("0");
        this.JTFFSTalla.setText("0");
        this.JTFFSNumHijo.setText("0");
    }

    private String getAnestesiologo() {
        return this.cboAnestesiologo.getPopupTable().getValueAt(this.cboAnestesiologo.getSelectedIndex(), 1).toString();
    }

    private String getAyudante() {
        return this.cboAyudante.getPopupTable().getValueAt(this.cboAyudante.getSelectedIndex(), 1).toString();
    }

    private String getTipoSala() {
        return this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 1).toString();
    }

    private String getTipoAnestesia() {
        return this.cboTipoAnestesia.getPopupTable().getValueAt(this.cboTipoAnestesia.getSelectedIndex(), 1).toString();
    }

    private void mCargarDatosInformeQx() {
        mCrearTablaInformeQx();
        List<Object[]> list = this.liquidacionCirugiaDAO.listadoCirugiaHistoria(String.valueOf(this.xliq.getxId_Atencion()));
        if (!list.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTInformeQx, 5);
            for (int x = 0; x < list.size(); x++) {
                this.xModeloInfQx.addRow(this.xDatos4);
                for (int i = 0; i < this.JTInformeQx.getColumnCount(); i++) {
                    this.xModeloInfQx.setValueAt(list.get(x)[i], x, i);
                }
                this.JTDetalleNacimiento.setDefaultRenderer(Object.class, new MiRender());
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPQuirurgico$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 6).toString()).longValue() != 0) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaInformeQx() {
        this.xModeloInfQx = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Inicial", "Hora Inicial", "Hora Final", "Tipo de Anestesia", "Procedimiento", "IdOrdenF", "NServicio"}) { // from class: Facturacion.JPQuirurgico.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTInformeQx;
        JTable jTable2 = this.JTInformeQx;
        jTable.setAutoResizeMode(0);
        this.JTInformeQx.doLayout();
        this.JTInformeQx.setModel(this.xModeloInfQx);
        this.JTInformeQx.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTInformeQx.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTInformeQx.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTInformeQx.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTInformeQx.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTInformeQx.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTInformeQx.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTInformeQx.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosDiagnosticos() {
        List<Object[]> list = this.liquidacionCirugiaDAO.listadoDiagnosticoCirugiaHistoria(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 0).toString());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                if (Integer.valueOf(list.get(x)[2].toString()).intValue() == 0) {
                    this.txtCodDxPpal.setText(list.get(x)[0].toString());
                    this.txtDxPpal.setText(list.get(x)[1].toString());
                } else {
                    this.txtCodDxCompli.setText(list.get(x)[0].toString());
                    this.txtDxCompli.setText(list.get(x)[1].toString());
                }
            }
        }
    }

    private void mCargarDatosProcedimiento() {
        List<Object[]> list = this.liquidacionCirugiaDAO.listadoProcedimientosdeCirugiaHistoria(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 0).toString());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.cboEspecialidad.setSelectedItem(list.get(x)[2]);
                this.cboCirujano.setSelectedItem(list.get(x)[7]);
                this.txtCirugia.setText(list.get(x)[0].toString());
                System.err.println("list.get(x)[1].toString()" + list.get(x)[1].toString());
                this.cboCirugia.setSelectedItem(list.get(x)[1].toString());
                if (list.get(x)[3].equals(false)) {
                    this.btnBilateralNo.setSelected(true);
                } else {
                    this.btnBilateralSi.setSelected(true);
                }
                if (list.get(x)[4].equals(false)) {
                    this.btnIgualVia.setSelected(true);
                } else {
                    this.btnDiferenteVia.setSelected(true);
                }
                mBajarCirugiaAlGrid();
            }
        }
    }

    private void mCargarDatosIntegrantes() {
        List<Object[]> list = this.liquidacionCirugiaDAO.listadoIntegrantesCirugiaHistoria(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 0).toString());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x)[1].equals("ENFERMERIA") || list.get(x)[1].equals("ENFERMERÍA") || list.get(x)[1].equals("AYUDANTE QUIRURGICO")) {
                    this.cboAyudante.setSelectedItem(list.get(x)[0]);
                    this.cboPerfusionista.setSelectedItem(list.get(x)[0]);
                } else if (list.get(x)[1].equals("ANESTESIOLOGIA")) {
                    this.cboAnestesiologo.setSelectedItem(list.get(x)[0]);
                }
            }
        }
    }

    private void mCargarDatosNacido() {
        List<Object[]> list = this.liquidacionCirugiaDAO.listadoNacimientosCirugiaHistoria(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 0).toString());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.JDC_NFecha.setDate(java.sql.Date.valueOf(list.get(x)[0].toString()));
                this.JTFF_NHora.setValue(list.get(x)[1]);
                if (list.get(x)[2].equals("VIVO")) {
                    this.JRBVivo.setSelected(true);
                    this.xEstadoNacido = 1;
                } else {
                    this.JRBMuerto.setSelected(true);
                    this.xEstadoNacido = 0;
                }
                if (list.get(x)[3].equals(true)) {
                    this.JRB_NCpSi.setSelected(true);
                    this.xCPrenatal = 1;
                } else {
                    this.JRB_NCpNo.setSelected(true);
                    this.xCPrenatal = 0;
                }
                this.JTFF_EdadGestacional.setValue(list.get(x)[4]);
                if (list.get(x)[5].equals("FEMENINO")) {
                    this.JRB_Fem.setSelected(true);
                    this.xSexo = "F";
                } else {
                    this.JRB_Masc.setSelected(true);
                    this.xSexo = "M";
                }
                this.JTFFSPeso.setText(list.get(x)[6].toString());
                this.JTFFSTalla.setText(list.get(x)[7].toString());
                this.JTFFSNumHijo.setText(list.get(x)[8].toString());
                this.JTFAPGar.setText(list.get(x)[15].toString());
                this.JCBTParto.setSelectedItem(list.get(x)[16].toString());
                this.JTFCDxP.setText(list.get(x)[9].toString());
                this.JTFNCodigoDxP.setText(list.get(x)[10].toString());
                this.JTFCDxPM.setText(list.get(x)[11].toString());
                this.JTFNCodigoDxPM.setText(list.get(x)[12].toString());
                mAdicionarNacimientos();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v210, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v458, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v479, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v491, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v509, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.grupoVia = new ButtonGroup();
        this.grupoBilateral = new ButtonGroup();
        this.grupoPrenatal = new ButtonGroup();
        this.grupoSexo = new ButtonGroup();
        this.grupoEstado = new ButtonGroup();
        this.JTP_Cirugia = new JTabbedPane();
        this.JPI_DatosC = new JPanel();
        this.txtFecha = new JDateChooser();
        this.txtHoraIni = new JFormattedTextField();
        this.txtHoraFin = new JFormattedTextField();
        try {
            this.cboTipoServicio = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboTipoSala = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        try {
            this.cboCC = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboAnestesiologo = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        try {
            this.cboAyudante = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e15) {
            e15.printStackTrace();
        }
        try {
            this.cboPerfusionista = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e16) {
            e16.printStackTrace();
        }
        try {
            this.cboTipoAnestesia = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e17) {
            e17.printStackTrace();
        }
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.txtNoPrescripcionMiPres = new JFormattedTextField();
        this.panelDatos = new JPanel();
        this.JTD_DProcedimiento = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jLabel8 = new JLabel();
        this.txtCodDxPpal = new JTextField();
        this.jLabel14 = new JLabel();
        this.txtCodDxRel = new JTextField();
        this.txtCodDxCompli = new JTextField();
        this.jLabel15 = new JLabel();
        this.JBBUscarDxP = new JButton();
        this.JBBUscarDxC = new JButton();
        this.JBBUscarDxR = new JButton();
        this.txtDxCompli = new JTextField();
        this.txtDxPpal = new JTextField();
        this.txtDxRel = new JTextField();
        this.jPanel1 = new JPanel();
        try {
            this.cboEspecialidad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e18) {
            e18.printStackTrace();
        }
        try {
            this.cboCirujano = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e19) {
            e19.printStackTrace();
        }
        this.txtCirugia = new JTextField();
        try {
            this.cboCirugia = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e110) {
            e110.printStackTrace();
        }
        this.btnCobrable = new JCheckBox();
        this.jPanel7 = new JPanel();
        this.btnIgualVia = new JRadioButton();
        this.btnDiferenteVia = new JRadioButton();
        this.jPanel6 = new JPanel();
        this.btnBilateralNo = new JRadioButton();
        this.btnBilateralSi = new JRadioButton();
        this.btnCargar = new JButton();
        this.JCBFinalidad = new JComboBox();
        this.JTP_Liquidacion = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.JPI_Liquidacion = new JPanel();
        this.chMateriales = new JCheckBox();
        this.chCirugia = new JCheckBox();
        this.chAnestesiologo = new JCheckBox();
        this.chAyudante = new JCheckBox();
        this.chPerfusionista = new JCheckBox();
        this.chSala = new JCheckBox();
        this.txtVrAyudante = new JFormattedTextField();
        this.txtVrHonorarios = new JFormattedTextField();
        this.txtVrAnestesiologo = new JFormattedTextField();
        this.txtVrTotal = new JFormattedTextField();
        this.txtVrSala = new JFormattedTextField();
        this.txtValorMateriales = new JFormattedTextField();
        this.txtVrPerfusionista = new JFormattedTextField();
        this.btnLiquidar = new JButton();
        this.JLBNumero = new JLabel();
        this.txtVrConjunto = new JFormattedTextField();
        this.JPI_DNacimiento = new JPanel();
        this.JPI_DRecienNacido = new JPanel();
        this.JDC_NFecha = new JDateChooser();
        this.JTFF_NHora = new JFormattedTextField();
        this.JPI_CPrennatal = new JPanel();
        this.JRB_NCpSi = new JRadioButton();
        this.JRB_NCpNo = new JRadioButton();
        this.JTFF_EdadGestacional = new JFormattedTextField();
        this.JPI_CPrennatal1 = new JPanel();
        this.JRB_Masc = new JRadioButton();
        this.JRB_Fem = new JRadioButton();
        this.JTFFSPeso = new JTextFieldValidator();
        this.jPanel3 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JBBUscarDx = new JButton();
        this.jPanel4 = new JPanel();
        this.JTFCDxPM = new JTextField();
        this.JTFNCodigoDxPM = new JTextField();
        this.JBBUscarDxM = new JButton();
        this.JDC_NFechaM = new JDateChooser();
        this.JTFF_NHoraM = new JFormattedTextField();
        this.JPI_CPrennatal2 = new JPanel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSNumHijo = new JTextFieldValidator();
        this.JTFAPGar = new JTextField();
        this.JCBTParto = new JComboBox();
        this.JTFFNControles = new JTextFieldValidator();
        this.JCBDestino = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleNacimiento = new JTable();
        this.JBAdicionar = new JButton();
        this.JPDHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBT_Anexo3 = new JButton();
        this.JSPHistoricoDetalle = new JScrollPane();
        this.JTHistoricoDetalle = new JTable();
        this.JPInformeQx = new JPanel();
        this.JSPInformeQx = new JScrollPane();
        this.JTInformeQx = new JTable();
        setName("xjp_quirurgico");
        this.JTP_Cirugia.setForeground(new Color(0, 103, 0));
        this.JTP_Cirugia.setTabLayoutPolicy(1);
        this.JTP_Cirugia.setFont(new Font("Arial", 1, 14));
        this.JTP_Cirugia.setName("xjp_quirurgico");
        this.JPI_DatosC.setBorder(BorderFactory.createEtchedBorder());
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtHoraIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.txtHoraIni.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.txtHoraIni.setHorizontalAlignment(4);
        this.txtHoraIni.setToolTipText("Formato hh:mm p");
        this.txtHoraIni.setFont(new Font("Arial", 1, 12));
        this.txtHoraIni.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.6
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtHoraIniActionPerformed(evt);
            }
        });
        this.txtHoraIni.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.7
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtHoraIniFocusGained(evt);
            }
        });
        this.txtHoraFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.txtHoraFin.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
        this.txtHoraFin.setHorizontalAlignment(4);
        this.txtHoraFin.setToolTipText("Formato hh:mm p");
        this.txtHoraFin.setFont(new Font("Arial", 1, 12));
        this.txtHoraFin.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.8
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtHoraFinFocusGained(evt);
            }
        });
        this.cboTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboTipoServicio.setFont(new Font("Arial", 1, 12));
        this.cboTipoServicio.setShowTableGrid(true);
        this.cboTipoServicio.setShowTableHeaders(true);
        this.cboTipoServicio.addItemListener(new ItemListener() { // from class: Facturacion.JPQuirurgico.9
            public void itemStateChanged(ItemEvent evt) {
                JPQuirurgico.this.cboTipoServicioItemStateChanged(evt);
            }
        });
        this.cboTipoServicio.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.10
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.cboTipoServicioActionPerformed(evt);
            }
        });
        this.cboTipoSala.setBorder(BorderFactory.createTitledBorder((Border) null, "Sala", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboTipoSala.setFont(new Font("Arial", 1, 12));
        this.cboTipoSala.setShowTableGrid(true);
        this.cboTipoSala.setShowTableHeaders(true);
        this.cboCC.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCC.setFont(new Font("Arial", 1, 12));
        this.cboCC.setShowTableGrid(true);
        this.cboCC.setShowTableHeaders(true);
        this.cboAnestesiologo.setBorder(BorderFactory.createTitledBorder((Border) null, "Anastesiologo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboAnestesiologo.setFont(new Font("Arial", 1, 12));
        this.cboAnestesiologo.setShowTableGrid(true);
        this.cboAnestesiologo.setShowTableHeaders(true);
        this.cboAyudante.setBorder(BorderFactory.createTitledBorder((Border) null, "Ayudante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboAyudante.setFont(new Font("Arial", 1, 12));
        this.cboAyudante.setShowTableGrid(true);
        this.cboAyudante.setShowTableHeaders(true);
        this.cboPerfusionista.setBorder(BorderFactory.createTitledBorder((Border) null, "Instrumentador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboPerfusionista.setFont(new Font("Arial", 1, 12));
        this.cboPerfusionista.setShowTableGrid(true);
        this.cboPerfusionista.setShowTableHeaders(true);
        this.cboPerfusionista.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.11
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.cboPerfusionistaActionPerformed(evt);
            }
        });
        this.cboTipoAnestesia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Anestesia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboTipoAnestesia.setFont(new Font("Arial", 1, 12));
        this.cboTipoAnestesia.setShowTableGrid(true);
        this.cboTipoAnestesia.setShowTableHeaders(true);
        this.cboTipoAnestesia.addItemListener(new ItemListener() { // from class: Facturacion.JPQuirurgico.12
            public void itemStateChanged(ItemEvent evt) {
                JPQuirurgico.this.cboTipoAnestesiaItemStateChanged(evt);
            }
        });
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Facturacion.JPQuirurgico.13
            public void itemStateChanged(ItemEvent evt) {
                JPQuirurgico.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        this.txtNoPrescripcionMiPres.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Mipres", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPrescripcionMiPres.setFont(new Font("Arial", 1, 12));
        this.txtNoPrescripcionMiPres.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.14
            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtNoPrescripcionMiPresFocusLost(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.15
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtNoPrescripcionMiPresActionPerformed(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPQuirurgico.16
            public void keyPressed(KeyEvent evt) {
                JPQuirurgico.this.txtNoPrescripcionMiPresKeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosCLayout = new GroupLayout(this.JPI_DatosC);
        this.JPI_DatosC.setLayout(JPI_DatosCLayout);
        JPI_DatosCLayout.setHorizontalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createSequentialGroup().addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI_DatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGrupoSevicio, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSevicioRips, 0, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPI_DatosCLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.cboAnestesiologo, -1, -1, 32767).addGroup(JPI_DatosCLayout.createSequentialGroup().addComponent(this.txtFecha, -2, 119, -2).addGap(31, 31, 31).addComponent(this.txtHoraIni, -2, 90, -2).addGap(37, 37, 37).addComponent(this.txtHoraFin, -2, 97, -2)).addComponent(this.cboTipoSala, -1, -1, 32767).addComponent(this.cboTipoAnestesia, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.cboAyudante, GroupLayout.Alignment.LEADING, -2, 350, -2).addComponent(this.cboCC, GroupLayout.Alignment.LEADING, -2, 350, -2).addComponent(this.cboTipoServicio, GroupLayout.Alignment.LEADING, -2, 350, -2)).addComponent(this.cboPerfusionista, GroupLayout.Alignment.TRAILING, -2, 350, -2)))).addGap(83, 83, 83)).addGroup(JPI_DatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.txtNoPrescripcionMiPres, -2, 231, -2).addContainerGap(-1, 32767)));
        JPI_DatosCLayout.setVerticalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtHoraIni, -2, -1, -2).addComponent(this.txtHoraFin, -2, -1, -2).addComponent(this.cboTipoServicio, -2, -1, -2)).addComponent(this.txtFecha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboTipoSala, -2, -1, -2).addComponent(this.cboCC, -1, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboAnestesiologo, -2, -1, -2).addComponent(this.cboAyudante, -1, -1, -2)).addGap(18, 18, 18).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboTipoAnestesia, -2, -1, -2).addComponent(this.cboPerfusionista, -1, -1, -2)).addGap(18, 18, 18).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, 50, -2).addComponent(this.JCBSevicioRips, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoPrescripcionMiPres, -2, 50, -2).addContainerGap()));
        this.cboPerfusionista.getAccessibleContext().setAccessibleDescription("");
        this.JTP_Cirugia.addTab("INFORMACIÓN GENERAL", this.JPI_DatosC);
        this.panelDatos.setBorder(BorderFactory.createEtchedBorder());
        this.JTD_DProcedimiento.setForeground(Color.red);
        this.JTD_DProcedimiento.setFont(new Font("Arial", 1, 14));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("Diagnostico Principal");
        this.txtCodDxPpal.setFont(new Font("Arial", 1, 12));
        this.txtCodDxPpal.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodDxPpal.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.17
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxPpalFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxPpalFocusLost(evt);
            }
        });
        this.txtCodDxPpal.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.18
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtCodDxPpalActionPerformed(evt);
            }
        });
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setHorizontalAlignment(0);
        this.jLabel14.setText("Dx Relacional");
        this.txtCodDxRel.setFont(new Font("Arial", 1, 12));
        this.txtCodDxRel.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodDxRel.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.19
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxRelFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxRelFocusLost(evt);
            }
        });
        this.txtCodDxRel.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.20
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtCodDxRelActionPerformed(evt);
            }
        });
        this.txtCodDxCompli.setFont(new Font("Arial", 1, 12));
        this.txtCodDxCompli.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodDxCompli.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.21
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxCompliFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtCodDxCompliFocusLost(evt);
            }
        });
        this.txtCodDxCompli.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.22
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtCodDxCompliActionPerformed(evt);
            }
        });
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setHorizontalAlignment(0);
        this.jLabel15.setText("Dx Complicación");
        this.JBBUscarDxP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDxP.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDxP.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.23
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBBUscarDxPActionPerformed(evt);
            }
        });
        this.JBBUscarDxC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDxC.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDxC.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.24
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBBUscarDxCActionPerformed(evt);
            }
        });
        this.JBBUscarDxR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDxR.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDxR.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.25
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBBUscarDxRActionPerformed(evt);
            }
        });
        this.txtDxCompli.setEditable(false);
        this.txtDxCompli.setFont(new Font("Arial", 1, 12));
        this.txtDxCompli.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDxCompli.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.26
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtDxCompliFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtDxCompliFocusLost(evt);
            }
        });
        this.txtDxCompli.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.27
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtDxCompliActionPerformed(evt);
            }
        });
        this.txtDxPpal.setEditable(false);
        this.txtDxPpal.setFont(new Font("Arial", 1, 12));
        this.txtDxPpal.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDxPpal.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.28
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtDxPpalFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtDxPpalFocusLost(evt);
            }
        });
        this.txtDxPpal.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.29
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtDxPpalActionPerformed(evt);
            }
        });
        this.txtDxRel.setEditable(false);
        this.txtDxRel.setFont(new Font("Arial", 1, 12));
        this.txtDxRel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDxRel.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.30
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtDxRelFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtDxRelFocusLost(evt);
            }
        });
        this.txtDxRel.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.31
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtDxRelActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel15, -1, -1, 32767).addComponent(this.jLabel8, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCodDxCompli, -2, 64, -2).addGap(7, 7, 7).addComponent(this.JBBUscarDxC, -2, 54, -2).addGap(17, 17, 17).addComponent(this.txtDxCompli, -1, 656, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCodDxRel, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBUscarDxR, -2, 54, -2).addGap(18, 18, 18).addComponent(this.txtDxRel)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCodDxPpal, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBUscarDxP, -2, 54, -2).addGap(18, 18, 18).addComponent(this.txtDxPpal)).addComponent(this.jLabel14, -1, -1, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCodDxPpal, -1, 46, 32767).addComponent(this.JBBUscarDxP, -1, -1, 32767).addComponent(this.txtDxPpal)).addGap(18, 18, 18).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtDxRel, -2, -1, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBBUscarDxR, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.txtCodDxRel, GroupLayout.Alignment.LEADING))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCodDxCompli, -2, -1, -2).addComponent(this.txtDxCompli, -2, -1, -2)).addComponent(this.JBBUscarDxC, -1, 43, 32767)).addGap(16, 16, 16)));
        this.JTD_DProcedimiento.addTab("DIAGNÓSTICO", this.jPanel2);
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setShowTableGrid(true);
        this.cboEspecialidad.setShowTableHeaders(true);
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JPQuirurgico.32
            public void itemStateChanged(ItemEvent evt) {
                JPQuirurgico.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.cboCirujano.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCirujano.setFont(new Font("Arial", 1, 12));
        this.cboCirujano.setShowTableGrid(true);
        this.cboCirujano.setShowTableHeaders(true);
        this.cboCirujano.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.33
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.cboCirujanoActionPerformed(evt);
            }
        });
        this.txtCirugia.setFont(new Font("Arial", 1, 12));
        this.txtCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCirugia.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.34
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.txtCirugiaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.txtCirugiaFocusLost(evt);
            }
        });
        this.txtCirugia.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.35
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.txtCirugiaActionPerformed(evt);
            }
        });
        this.cboCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCirugia.setFont(new Font("Arial", 1, 12));
        this.cboCirugia.setShowTableGrid(true);
        this.cboCirugia.setShowTableHeaders(false);
        this.cboCirugia.addItemListener(new ItemListener() { // from class: Facturacion.JPQuirurgico.36
            public void itemStateChanged(ItemEvent evt) {
                JPQuirurgico.this.cboCirugiaItemStateChanged(evt);
            }
        });
        this.btnCobrable.setFont(new Font("Arial", 1, 12));
        this.btnCobrable.setSelected(true);
        this.btnCobrable.setText("Es Cobrable");
        this.btnCobrable.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.37
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnCobrableActionPerformed(evt);
            }
        });
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "Via de Acceso", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel7.setLayout((LayoutManager) null);
        this.grupoVia.add(this.btnIgualVia);
        this.btnIgualVia.setFont(new Font("Arial", 1, 12));
        this.btnIgualVia.setSelected(true);
        this.btnIgualVia.setText("Igual");
        this.btnIgualVia.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.38
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnIgualViaActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.btnIgualVia);
        this.btnIgualVia.setBounds(10, 20, 80, 19);
        this.grupoVia.add(this.btnDiferenteVia);
        this.btnDiferenteVia.setFont(new Font("Arial", 1, 12));
        this.btnDiferenteVia.setText("Diferente");
        this.btnDiferenteVia.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.39
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnDiferenteViaActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.btnDiferenteVia);
        this.btnDiferenteVia.setBounds(130, 20, 90, 19);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Bilateral", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.grupoBilateral.add(this.btnBilateralNo);
        this.btnBilateralNo.setFont(new Font("Arial", 1, 12));
        this.btnBilateralNo.setSelected(true);
        this.btnBilateralNo.setText("No");
        this.btnBilateralNo.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.40
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnBilateralNoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnBilateralNo);
        this.btnBilateralNo.setBounds(10, 20, 50, 19);
        this.grupoBilateral.add(this.btnBilateralSi);
        this.btnBilateralSi.setFont(new Font("Arial", 1, 12));
        this.btnBilateralSi.setText("Si");
        this.btnBilateralSi.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.41
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnBilateralSiActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnBilateralSi);
        this.btnBilateralSi.setBounds(140, 20, 50, 19);
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.setHorizontalTextPosition(4);
        this.btnCargar.setVerticalTextPosition(3);
        this.btnCargar.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.42
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnCargarActionPerformed(evt);
            }
        });
        this.JCBFinalidad.setFont(new Font("Arial", 1, 12));
        this.JCBFinalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.cboEspecialidad, -2, 294, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboCirujano, -2, 430, -2)).addComponent(this.JCBFinalidad, -2, 304, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtCirugia, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboCirugia, -2, 592, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnCobrable, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, 260, -2).addGap(20, 20, 20).addComponent(this.jPanel6, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargar, -2, 109, -2))).addGap(33, 33, 33)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboEspecialidad, -2, -1, -2).addComponent(this.cboCirujano, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCirugia, -2, 39, -2).addComponent(this.cboCirugia, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBFinalidad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnCobrable).addComponent(this.jPanel6, -1, 41, 32767).addComponent(this.jPanel7, -1, -1, 32767))).addComponent(this.btnCargar, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(53, 53, 53)));
        this.JTD_DProcedimiento.addTab("PROCEDIMIENTO", this.jPanel1);
        this.JTP_Liquidacion.setForeground(Color.red);
        this.JTP_Liquidacion.setFont(new Font("Arial", 1, 14));
        this.jScrollPane1.setAutoscrolls(true);
        this.grid.setBackground(new Color(204, 255, 255));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setAutoResizeMode(1);
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPQuirurgico.43
            public void keyPressed(KeyEvent evt) {
                JPQuirurgico.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(1);
        this.JTP_Liquidacion.addTab("CIRUGÍAS", this.jScrollPane1);
        this.chMateriales.setFont(new Font("Arial", 1, 12));
        this.chMateriales.setSelected(true);
        this.chMateriales.setText("Materiales");
        this.chMateriales.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.44
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chMaterialesActionPerformed(evt);
            }
        });
        this.chCirugia.setFont(new Font("Arial", 1, 12));
        this.chCirugia.setSelected(true);
        this.chCirugia.setText("Cirujano");
        this.chCirugia.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.45
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chCirugiaActionPerformed(evt);
            }
        });
        this.chAnestesiologo.setFont(new Font("Arial", 1, 12));
        this.chAnestesiologo.setSelected(true);
        this.chAnestesiologo.setText("Anestesiólogo");
        this.chAnestesiologo.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.46
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chAnestesiologoActionPerformed(evt);
            }
        });
        this.chAyudante.setFont(new Font("Arial", 1, 12));
        this.chAyudante.setSelected(true);
        this.chAyudante.setText("Ayudante");
        this.chAyudante.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.47
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chAyudanteActionPerformed(evt);
            }
        });
        this.chPerfusionista.setFont(new Font("Arial", 1, 12));
        this.chPerfusionista.setSelected(true);
        this.chPerfusionista.setText("Perfusionista");
        this.chPerfusionista.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.48
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chPerfusionistaActionPerformed(evt);
            }
        });
        this.chSala.setFont(new Font("Arial", 1, 12));
        this.chSala.setSelected(true);
        this.chSala.setText("Sala de Cirugía");
        this.chSala.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.49
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.chSalaActionPerformed(evt);
            }
        });
        this.txtVrAyudante.setForeground(Color.red);
        this.txtVrAyudante.setHorizontalAlignment(0);
        this.txtVrAyudante.setText("0");
        this.txtVrAyudante.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrAyudante.setEnabled(false);
        this.txtVrAyudante.setFont(new Font("Arial", 1, 14));
        this.txtVrHonorarios.setForeground(Color.red);
        this.txtVrHonorarios.setHorizontalAlignment(0);
        this.txtVrHonorarios.setText("0");
        this.txtVrHonorarios.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrHonorarios.setEnabled(false);
        this.txtVrHonorarios.setFont(new Font("Arial", 1, 14));
        this.txtVrHonorarios.setVerifyInputWhenFocusTarget(false);
        this.txtVrAnestesiologo.setForeground(Color.red);
        this.txtVrAnestesiologo.setHorizontalAlignment(0);
        this.txtVrAnestesiologo.setText("0");
        this.txtVrAnestesiologo.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrAnestesiologo.setEnabled(false);
        this.txtVrAnestesiologo.setFont(new Font("Arial", 1, 14));
        this.txtVrTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Tahoma", 1, 14), new Color(0, 0, 51)));
        this.txtVrTotal.setForeground(Color.red);
        this.txtVrTotal.setHorizontalAlignment(0);
        this.txtVrTotal.setText("0");
        this.txtVrTotal.setFont(new Font("Arial", 1, 18));
        this.txtVrTotal.setValue(new Long(0L));
        this.txtVrSala.setForeground(Color.red);
        this.txtVrSala.setHorizontalAlignment(0);
        this.txtVrSala.setText("0");
        this.txtVrSala.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrSala.setEnabled(false);
        this.txtVrSala.setFont(new Font("Arial", 1, 14));
        this.txtValorMateriales.setForeground(Color.red);
        this.txtValorMateriales.setHorizontalAlignment(0);
        this.txtValorMateriales.setText("0");
        this.txtValorMateriales.setDisabledTextColor(new Color(0, 0, 102));
        this.txtValorMateriales.setEnabled(false);
        this.txtValorMateriales.setFont(new Font("Arial", 1, 14));
        this.txtVrPerfusionista.setForeground(Color.red);
        this.txtVrPerfusionista.setHorizontalAlignment(0);
        this.txtVrPerfusionista.setText("0");
        this.txtVrPerfusionista.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrPerfusionista.setEnabled(false);
        this.txtVrPerfusionista.setFont(new Font("Arial", 1, 14));
        this.btnLiquidar.setFont(new Font("Arial", 1, 12));
        this.btnLiquidar.setText("Liquidar");
        this.btnLiquidar.setMaximumSize(new Dimension(25, 23));
        this.btnLiquidar.setMinimumSize(new Dimension(25, 23));
        this.btnLiquidar.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.50
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.btnLiquidarActionPerformed(evt);
            }
        });
        this.JLBNumero.setFont(new Font("Arial", 1, 14));
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVrConjunto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Conjunto", 0, 0, new Font("Tahoma", 1, 14), new Color(0, 0, 51)));
        this.txtVrConjunto.setForeground(Color.red);
        this.txtVrConjunto.setHorizontalAlignment(0);
        this.txtVrConjunto.setText("0");
        this.txtVrConjunto.setFont(new Font("Arial", 1, 18));
        GroupLayout JPI_LiquidacionLayout = new GroupLayout(this.JPI_Liquidacion);
        this.JPI_Liquidacion.setLayout(JPI_LiquidacionLayout);
        JPI_LiquidacionLayout.setHorizontalGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.chAnestesiologo).addComponent(this.txtVrAnestesiologo, -2, 120, -2).addComponent(this.chCirugia).addComponent(this.txtVrHonorarios, -2, 120, -2)).addGap(27, 27, 27).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtVrSala, -2, 130, -2).addComponent(this.chPerfusionista, -2, 130, -2).addComponent(this.chSala, -2, 130, -2).addComponent(this.txtVrPerfusionista, -2, 109, -2)).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.chAyudante).addComponent(this.txtVrAyudante, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtVrConjunto, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnLiquidar, -1, -1, 32767)).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.chMateriales, -2, 110, -2).addGap(26, 26, 26)).addGroup(GroupLayout.Alignment.TRAILING, JPI_LiquidacionLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorMateriales, -2, 120, -2).addGap(18, 18, 18))).addComponent(this.txtVrTotal, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNumero, -2, 121, -2))).addGap(254, 254, 254)));
        JPI_LiquidacionLayout.setVerticalGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.chCirugia).addComponent(this.chPerfusionista).addComponent(this.chAyudante)).addGap(7, 7, 7).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtVrHonorarios, -2, 30, -2).addComponent(this.txtVrPerfusionista, -2, 30, -2).addComponent(this.txtVrAyudante, -2, 30, -2)).addGap(35, 35, 35).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.chAnestesiologo).addComponent(this.chSala, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtVrAnestesiologo, -2, 30, -2).addComponent(this.txtVrSala, -2, 30, -2))).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addComponent(this.chMateriales).addGap(18, 18, 18).addComponent(this.txtValorMateriales, -2, 30, -2)))).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LiquidacionLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.txtVrConjunto, -2, 60, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_LiquidacionLayout.createSequentialGroup().addContainerGap().addComponent(this.btnLiquidar, -2, 66, -2))).addGap(26, 26, 26).addGroup(JPI_LiquidacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtVrTotal, -2, 60, -2).addComponent(this.JLBNumero, -2, 60, -2)))).addContainerGap()));
        this.JTP_Liquidacion.addTab("LIQUIDACIÓN", this.JPI_Liquidacion);
        GroupLayout panelDatosLayout = new GroupLayout(this.panelDatos);
        this.panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Liquidacion, -2, 0, 32767).addComponent(this.JTD_DProcedimiento)).addContainerGap()));
        panelDatosLayout.setVerticalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTD_DProcedimiento, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Liquidacion, -1, 340, 32767).addContainerGap()));
        this.JTP_Cirugia.addTab("REGISTRO DE PROCEDIMIENTOS", this.panelDatos);
        this.JPI_DRecienNacido.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RECIEN NACIDO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDC_NFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_NFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_NHora.setToolTipText("Formato hh:mm p");
        this.JTFF_NHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHora.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.51
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFF_NHoraFocusGained(evt);
            }
        });
        this.JTFF_NHora.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.52
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFF_NHoraActionPerformed(evt);
            }
        });
        this.JPI_CPrennatal.setBorder(BorderFactory.createTitledBorder((Border) null, "C.Prenatal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoPrenatal.add(this.JRB_NCpSi);
        this.JRB_NCpSi.setFont(new Font("Arial", 1, 12));
        this.JRB_NCpSi.setText("SI");
        this.JRB_NCpSi.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.53
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRB_NCpSiActionPerformed(evt);
            }
        });
        this.grupoPrenatal.add(this.JRB_NCpNo);
        this.JRB_NCpNo.setFont(new Font("Arial", 1, 12));
        this.JRB_NCpNo.setSelected(true);
        this.JRB_NCpNo.setText("NO");
        this.JRB_NCpNo.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.54
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRB_NCpNoActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatalLayout = new GroupLayout(this.JPI_CPrennatal);
        this.JPI_CPrennatal.setLayout(JPI_CPrennatalLayout);
        JPI_CPrennatalLayout.setHorizontalGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatalLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRB_NCpSi).addGap(3, 3, 3).addComponent(this.JRB_NCpNo).addGap(2, 2, 2)));
        JPI_CPrennatalLayout.setVerticalGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatalLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_NCpSi).addComponent(this.JRB_NCpNo)).addContainerGap(-1, 32767)));
        this.JTFF_EdadGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad gestacional (Semanas)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_EdadGestacional.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.JTFF_EdadGestacional.setHorizontalAlignment(4);
        this.JTFF_EdadGestacional.setToolTipText("Semanas de Gestación");
        this.JTFF_EdadGestacional.setFont(new Font("Arial", 1, 12));
        this.JTFF_EdadGestacional.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.55
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFF_EdadGestacionalFocusGained(evt);
            }
        });
        this.JTFF_EdadGestacional.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.56
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFF_EdadGestacionalActionPerformed(evt);
            }
        });
        this.JPI_CPrennatal1.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoSexo.add(this.JRB_Masc);
        this.JRB_Masc.setFont(new Font("Arial", 1, 12));
        this.JRB_Masc.setSelected(true);
        this.JRB_Masc.setText("M");
        this.JRB_Masc.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.57
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRB_MascActionPerformed(evt);
            }
        });
        this.grupoSexo.add(this.JRB_Fem);
        this.JRB_Fem.setFont(new Font("Arial", 1, 12));
        this.JRB_Fem.setText("F");
        this.JRB_Fem.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.58
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRB_FemActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatal1Layout = new GroupLayout(this.JPI_CPrennatal1);
        this.JPI_CPrennatal1.setLayout(JPI_CPrennatal1Layout);
        JPI_CPrennatal1Layout.setHorizontalGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRB_Masc).addGap(5, 5, 5).addComponent(this.JRB_Fem).addContainerGap(-1, 32767)));
        JPI_CPrennatal1Layout.setVerticalGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal1Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Masc).addComponent(this.JRB_Fem)).addContainerGap(-1, 32767)));
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.59
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.60
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO DEL RECIÉN NACIDO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.setEnabled(false);
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPQuirurgico.61
            public void mouseClicked(MouseEvent evt) {
                JPQuirurgico.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPQuirurgico.62
            public void keyPressed(KeyEvent evt) {
                JPQuirurgico.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JBBUscarDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDx.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDx.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.63
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBBUscarDxActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 520, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBUscarDx, -2, 56, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2))).addComponent(this.JBBUscarDx, -2, 45, -2)).addGap(5, 5, 5)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "CAUSA BÁSICA DE MUERTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCDxPM.setFont(new Font("Arial", 1, 12));
        this.JTFCDxPM.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxPM.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.64
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFCDxPMFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.JTFCDxPMFocusLost(evt);
            }
        });
        this.JTFCDxPM.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPQuirurgico.65
            public void keyPressed(KeyEvent evt) {
                JPQuirurgico.this.JTFCDxPMKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxPM.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxPM.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxPM.setEnabled(false);
        this.JTFNCodigoDxPM.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPQuirurgico.66
            public void mouseClicked(MouseEvent evt) {
                JPQuirurgico.this.JTFNCodigoDxPMMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxPM.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPQuirurgico.67
            public void keyPressed(KeyEvent evt) {
                JPQuirurgico.this.JTFNCodigoDxPMKeyPressed(evt);
            }
        });
        this.JBBUscarDxM.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDxM.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDxM.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.68
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBBUscarDxMActionPerformed(evt);
            }
        });
        this.JDC_NFechaM.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_NFechaM.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHoraM.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_NHoraM.setToolTipText("Formato hh:mm p");
        this.JTFF_NHoraM.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHoraM.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.69
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFF_NHoraMActionPerformed(evt);
            }
        });
        this.JTFF_NHoraM.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.70
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFF_NHoraMFocusGained(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFCDxPM, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxPM, -2, 385, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBBUscarDxM, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_NFechaM, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_NHoraM, -2, 82, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_NFechaM, -2, 50, -2).addComponent(this.JTFF_NHoraM, -2, 45, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBBUscarDxM, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxPM, -2, -1, -2).addComponent(this.JTFNCodigoDxPM, -2, -1, -2)))).addGap(10, 10, 10)));
        this.JPI_CPrennatal2.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoEstado.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("VIVO");
        this.JRBVivo.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.71
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRBVivoActionPerformed(evt);
            }
        });
        this.grupoEstado.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setText("MUERTO");
        this.JRBMuerto.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.72
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JRBMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatal2Layout = new GroupLayout(this.JPI_CPrennatal2);
        this.JPI_CPrennatal2.setLayout(JPI_CPrennatal2Layout);
        JPI_CPrennatal2Layout.setHorizontalGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBVivo).addGap(18, 18, 18).addComponent(this.JRBMuerto).addContainerGap(-1, 32767)));
        JPI_CPrennatal2Layout.setVerticalGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVivo).addComponent(this.JRBMuerto))));
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.73
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.74
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSNumHijo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSNumHijo.setHorizontalAlignment(0);
        this.JTFFSNumHijo.setText("0");
        this.JTFFSNumHijo.setToolTipText("Talla en Centimetros");
        this.JTFFSNumHijo.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSNumHijo.setFocusAccelerator('C');
        this.JTFFSNumHijo.setFont(new Font("Arial", 1, 12));
        this.JTFFSNumHijo.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.75
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFFSNumHijoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.JTFFSNumHijoFocusLost(evt);
            }
        });
        this.JTFFSNumHijo.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.76
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFFSNumHijoActionPerformed(evt);
            }
        });
        this.JTFAPGar.setFont(new Font("Arial", 1, 12));
        this.JTFAPGar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue), "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTParto.setFont(new Font("Arial", 1, 12));
        this.JCBTParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNControles.setBorder(BorderFactory.createTitledBorder((Border) null, "No.Controles", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNControles.setHorizontalAlignment(0);
        this.JTFFNControles.setText("0");
        this.JTFFNControles.setToolTipText("Talla en Centimetros");
        this.JTFFNControles.setExprecionRegular("^[0.0-9]*$");
        this.JTFFNControles.setFocusAccelerator('C');
        this.JTFFNControles.setFont(new Font("Arial", 1, 12));
        this.JTFFNControles.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPQuirurgico.77
            public void focusGained(FocusEvent evt) {
                JPQuirurgico.this.JTFFNControlesFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPQuirurgico.this.JTFFNControlesFocusLost(evt);
            }
        });
        this.JTFFNControles.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.78
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JTFFNControlesActionPerformed(evt);
            }
        });
        this.JCBDestino.setFont(new Font("Arial", 1, 12));
        this.JCBDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPI_DRecienNacidoLayout = new GroupLayout(this.JPI_DRecienNacido);
        this.JPI_DRecienNacido.setLayout(JPI_DRecienNacidoLayout);
        JPI_DRecienNacidoLayout.setHorizontalGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.JDC_NFecha, -2, 127, -2).addGap(12, 12, 12).addComponent(this.JTFF_NHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_CPrennatal2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_CPrennatal, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFNControles, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_EdadGestacional, -2, 188, -2).addGap(18, 18, 18)).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.JPI_CPrennatal1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSNumHijo, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAPGar, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTParto, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDestino, -2, 171, -2).addContainerGap()))));
        JPI_DRecienNacidoLayout.setVerticalGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DRecienNacidoLayout.createSequentialGroup().addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_CPrennatal2, -1, -1, 32767).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNControles, -2, 50, -2).addComponent(this.JTFF_EdadGestacional, -2, 45, -2)).addComponent(this.JPI_CPrennatal, -2, -1, -2).addComponent(this.JDC_NFecha, -2, 50, -2).addComponent(this.JTFF_NHora, -2, 48, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFAPGar).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSPeso, -2, 50, -2).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSNumHijo, -2, 50, -2).addComponent(this.JCBTParto, -2, 46, -2)).addComponent(this.JPI_CPrennatal1, -1, -1, 32767).addComponent(this.JCBDestino)).addGap(8, 8, 8).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addGap(5, 5, 5)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleNacimiento.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNacimiento.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleNacimiento.setSelectionBackground(Color.white);
        this.JTDetalleNacimiento.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTDetalleNacimiento);
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.setToolTipText("");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.79
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DNacimientoLayout = new GroupLayout(this.JPI_DNacimiento);
        this.JPI_DNacimiento.setLayout(JPI_DNacimientoLayout);
        JPI_DNacimientoLayout.setHorizontalGroup(JPI_DNacimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DNacimientoLayout.createSequentialGroup().addGroup(JPI_DNacimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2).addComponent(this.JPI_DRecienNacido, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPI_DNacimientoLayout.setVerticalGroup(JPI_DNacimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNacimientoLayout.createSequentialGroup().addComponent(this.JPI_DRecienNacido, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 207, 32767).addContainerGap()));
        this.JTP_Cirugia.addTab("REGISTRO DE NACIMIENTOS", this.JPI_DNacimiento);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPQuirurgico.80
            public void mouseClicked(MouseEvent evt) {
                JPQuirurgico.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JBT_Anexo3.setFont(new Font("Arial", 1, 12));
        this.JBT_Anexo3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_Anexo3.setText("Anexo 3");
        this.JBT_Anexo3.addActionListener(new ActionListener() { // from class: Facturacion.JPQuirurgico.81
            public void actionPerformed(ActionEvent evt) {
                JPQuirurgico.this.JBT_Anexo3ActionPerformed(evt);
            }
        });
        this.JSPHistoricoDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistoricoDetalle.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoDetalle.setSelectionBackground(Color.white);
        this.JTHistoricoDetalle.setSelectionForeground(Color.red);
        this.JSPHistoricoDetalle.setViewportView(this.JTHistoricoDetalle);
        GroupLayout JPDHistoricoLayout = new GroupLayout(this.JPDHistorico);
        this.JPDHistorico.setLayout(JPDHistoricoLayout);
        JPDHistoricoLayout.setHorizontalGroup(JPDHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPDHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -1, 805, 32767).addComponent(this.JBT_Anexo3, -1, -1, 32767).addComponent(this.JSPHistoricoDetalle)).addContainerGap()));
        JPDHistoricoLayout.setVerticalGroup(JPDHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 270, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistoricoDetalle, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Anexo3, -2, 50, -2).addContainerGap(110, 32767)));
        this.JTP_Cirugia.addTab("HISTÓRICO", this.JPDHistorico);
        this.JSPInformeQx.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTInformeQx.setFont(new Font("Arial", 1, 12));
        this.JTInformeQx.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTInformeQx.setSelectionBackground(Color.white);
        this.JTInformeQx.setSelectionForeground(Color.red);
        this.JTInformeQx.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPQuirurgico.82
            public void mouseClicked(MouseEvent evt) {
                JPQuirurgico.this.JTInformeQxMouseClicked(evt);
            }
        });
        this.JSPInformeQx.setViewportView(this.JTInformeQx);
        GroupLayout JPInformeQxLayout = new GroupLayout(this.JPInformeQx);
        this.JPInformeQx.setLayout(JPInformeQxLayout);
        JPInformeQxLayout.setHorizontalGroup(JPInformeQxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformeQxLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPInformeQx, -1, 805, 32767).addContainerGap()));
        JPInformeQxLayout.setVerticalGroup(JPInformeQxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformeQxLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPInformeQx, -1, 613, 32767).addContainerGap()));
        this.JTP_Cirugia.addTab("INFORME QUIRÚRGICO", this.JPInformeQx);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Cirugia, -2, 824, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTP_Cirugia, -1, 608, 32767).addContainerGap()));
        this.JTP_Cirugia.getAccessibleContext().setAccessibleName("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoAnestesiaItemStateChanged(ItemEvent evt) {
        if (this.cboTipoAnestesia.getPopupTable().getValueAt(this.cboTipoAnestesia.getSelectedIndex(), 2).toString().equals("true")) {
            this.chAnestesiologo.setEnabled(true);
            this.chAnestesiologo.setSelected(true);
        } else {
            this.chAnestesiologo.setEnabled(true);
            this.chAnestesiologo.setSelected(true);
        }
        this.txtVrAnestesiologo.setValue(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraIniActionPerformed(ActionEvent evt) {
        this.txtHoraFin.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraIniFocusGained(FocusEvent evt) {
        this.txtHoraIni.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraFinFocusGained(FocusEvent evt) {
        this.txtHoraFin.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBilateralNoActionPerformed(ActionEvent evt) {
        this.bilateral = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBilateralSiActionPerformed(ActionEvent evt) {
        this.bilateral = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIgualViaActionPerformed(ActionEvent evt) {
        this.viaAcceso = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDiferenteViaActionPerformed(ActionEvent evt) {
        this.viaAcceso = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        mBajarCirugiaAlGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxCompliActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxCompliFocusGained(FocusEvent evt) {
        this.txtCodDxCompli.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxCompliFocusLost(FocusEvent evt) {
        if (!this.txtCodDxCompli.getText().equals("")) {
            this.txtCodDxCompli.setText(this.txtCodDxCompli.getText().toUpperCase());
            if (this.metodos.mValidarDx(this.txtCodDxCompli.getText(), this.xFechaNac, this.xSexoPers)) {
                this.txtDxCompli.setText(buscar("g_patologia", this.txtCodDxCompli.getText()));
                return;
            }
            this.metodos.mostrarMensaje("El Dx no aplica para Sexo y/o Edad");
            this.txtCodDxCompli.setText("");
            this.txtDxCompli.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaActionPerformed(ActionEvent evt) {
        this.cboCirugia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaFocusGained(FocusEvent evt) {
        this.txtCirugia.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaFocusLost(FocusEvent evt) {
        this.cboCirugia.setSelectedItem(buscar("g_procedimiento", this.txtCirugia.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxPpalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxPpalFocusGained(FocusEvent evt) {
        this.txtCodDxPpal.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxPpalFocusLost(FocusEvent evt) {
        if (!this.txtCodDxPpal.getText().equals("")) {
            this.txtCodDxPpal.setText(this.txtCodDxPpal.getText().toUpperCase());
            if (this.metodos.mValidarDx(this.txtCodDxPpal.getText(), this.xFechaNac, this.xSexoPers)) {
                this.txtDxPpal.setText(buscar("g_patologia", this.txtCodDxPpal.getText()));
                return;
            }
            this.metodos.mostrarMensaje("El Dx no aplica para Sexo y/o Edad");
            this.txtCodDxPpal.setText("");
            this.txtDxPpal.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxRelActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxRelFocusGained(FocusEvent evt) {
        this.txtCodDxRel.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodDxRelFocusLost(FocusEvent evt) {
        if (!this.txtCodDxRel.getText().equals("")) {
            this.txtCodDxRel.setText(this.txtCodDxRel.getText().toUpperCase());
            if (this.metodos.mValidarDx(this.txtCodDxRel.getText(), this.xFechaNac, this.xSexoPers)) {
                this.txtDxRel.setText(buscar("g_patologia", this.txtCodDxRel.getText()));
                return;
            }
            this.metodos.mostrarMensaje("El Dx no aplica para Sexo y/o Edad");
            this.txtCodDxRel.setText("");
            this.txtDxRel.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1) {
            cargarCirujano();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCirugiaItemStateChanged(ItemEvent evt) {
        if (this.cboCirugia.getSelectedIndex() > -1) {
            this.txtCirugia.setText(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLiquidarActionPerformed(ActionEvent evt) {
        this.chCirugia.setSelected(true);
        this.chAnestesiologo.setSelected(true);
        this.chAyudante.setSelected(true);
        this.chMateriales.setSelected(true);
        this.chSala.setSelected(true);
        this.chPerfusionista.setSelected(true);
        mOrdenar_TablaCx();
        mVerificarTipoLiq();
        cargarValoresTabla();
        liquidar();
        mTotalizar_Cirugias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            borrarRegistroTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCobrableActionPerformed(ActionEvent evt) {
        if (this.btnCobrable.isSelected()) {
            this.cobrable = 1;
        } else {
            this.cobrable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoServicioItemStateChanged(ItemEvent evt) {
        this.tipoServicio = this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 0).toString();
        this.esConjunto = this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 2).toString();
        mCargarTipoCobro();
        cargarProcedim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NHoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NHoraFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_EdadGestacionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_EdadGestacionalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPMFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPMKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NHoraMActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NHoraMFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxActionPerformed(ActionEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxMActionPerformed(ActionEvent evt) {
        mBuscarPatologiaN(this.JTFCDxPM, this.JTFNCodigoDxPM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuertoActionPerformed(ActionEvent evt) {
        this.xEstadoNacido = 0;
        this.JTFCDxPM.setEnabled(true);
        this.JBBUscarDxM.setEnabled(true);
        this.JDC_NFechaM.setDate(this.metodos.getFechaActual());
        this.JDC_NFechaM.setEnabled(true);
        this.JTFF_NHoraM.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JTFF_NHoraM.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVivoActionPerformed(ActionEvent evt) {
        this.xEstadoNacido = 1;
        this.JTFCDxPM.setEnabled(false);
        this.JBBUscarDxM.setEnabled(false);
        this.JDC_NFechaM.setDate((Date) null);
        this.JDC_NFechaM.setEnabled(false);
        this.JTFF_NHoraM.setText("");
        this.JTFF_NHoraM.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSNumHijoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSNumHijoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSNumHijoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JRBMuerto.isSelected()) {
            if (this.JTFF_EdadGestacional.getText().equals("0")) {
                JOptionPane.showInternalMessageDialog(this, "La edad gestacional debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFF_EdadGestacional.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFSPeso.getText()).doubleValue() == 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "El peso debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSPeso.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFSTalla.getText()).doubleValue() == 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "La Talla debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSTalla.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFSNumHijo.getText()).doubleValue() != 0.0d) {
                if (!this.JTFCDxP.getText().equals("")) {
                    if (!this.JTFCDxPM.getText().equals("")) {
                        if (this.JCBTParto.getSelectedIndex() != -1) {
                            if (this.JCBDestino.getSelectedIndex() > -1) {
                                mAdicionarNacimientos();
                                return;
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe Seleccionar el destino del recien nacido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBDestino.requestFocus();
                                return;
                            }
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar el tipo de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTParto.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoMuerto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFCDxPM.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoVivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCDxP.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Numero de Hijo debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSNumHijo.requestFocus();
            return;
        }
        if (this.JTFF_EdadGestacional.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "La edad gestacional debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFF_EdadGestacional.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFSPeso.getText()).doubleValue() == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "El peso debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSPeso.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFSTalla.getText()).doubleValue() == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "La Talla debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFSNumHijo.getText()).doubleValue() != 0.0d) {
            if (!this.JTFCDxP.getText().equals("")) {
                if (this.JCBTParto.getSelectedIndex() != -1) {
                    mAdicionarNacimientos();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar la el tipo de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTParto.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoVivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El Numero de Hijo debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFSNumHijo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NCpSiActionPerformed(ActionEvent evt) {
        this.xCPrenatal = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NCpNoActionPerformed(ActionEvent evt) {
        this.xCPrenatal = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_MascActionPerformed(ActionEvent evt) {
        this.xSexo = "M";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FemActionPerformed(ActionEvent evt) {
        this.xSexo = "F";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chCirugiaActionPerformed(ActionEvent evt) {
        if (this.chCirugia.isSelected()) {
            mPonerHonario_Cero(19, true, 35);
        } else {
            mPonerHonario_Cero(19, false, 35);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chAnestesiologoActionPerformed(ActionEvent evt) {
        if (this.chAnestesiologo.isSelected()) {
            mPonerHonario_Cero(20, true, 36);
        } else {
            mPonerHonario_Cero(20, false, 36);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chAyudanteActionPerformed(ActionEvent evt) {
        if (this.chAyudante.isSelected()) {
            mPonerHonario_Cero(21, true, 37);
        } else {
            mPonerHonario_Cero(21, false, 37);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chSalaActionPerformed(ActionEvent evt) {
        if (this.chSala.isSelected()) {
            mPonerHonario_Cero(22, true, 38);
        } else {
            mPonerHonario_Cero(22, false, 38);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chMaterialesActionPerformed(ActionEvent evt) {
        if (this.chMateriales.isSelected()) {
            mPonerHonario_Cero(23, true, 39);
        } else {
            mPonerHonario_Cero(23, false, 39);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chPerfusionistaActionPerformed(ActionEvent evt) {
        if (this.chPerfusionista.isSelected()) {
            mPonerHonario_Cero(24, true, 40);
        } else {
            mPonerHonario_Cero(24, false, 40);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxPActionPerformed(ActionEvent evt) {
        mBuscarPatologiaCx(this.txtCodDxPpal, this.txtDxPpal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxRActionPerformed(ActionEvent evt) {
        mBuscarPatologiaCx(this.txtCodDxRel, this.txtDxRel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxCActionPerformed(ActionEvent evt) {
        mBuscarPatologiaCx(this.txtCodDxCompli, this.txtDxCompli);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Anexo3ActionPerformed(ActionEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            String sql = "SELECT  `IdAteAnexo3`, Id FROM `f_ordene_anexo_tres` WHERE (`IdOrden` ='" + this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "'  AND `Estado` =1)";
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    mVerAnexo3(xrs.getString("Id"));
                } else if (this.JTHistorico.getSelectedRow() != -1) {
                    String xId = mGeneraNoAtencion();
                    String sql2 = "INSERT INTO `f_ordene_anexo_tres` ( `IdOrden`, IdIngreso, `IdAteAnexo3`, `IdUsuarioS`, `FechaR`, `HoraR`, `UsuarioS`)\nVALUES ( '" + this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "', '" + this.xliq.JLB_NIngreso.getText() + "', '" + xId + "', '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + this.xmt.formatoH24.format(this.xmt.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    String xIdN = xct1.ejecutarSQLId(sql2);
                    xct1.cerrarConexionBd();
                    mVerAnexo3(xIdN);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una orden", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            mCargarDatosTablaHistoricoDetalle(this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTInformeQxMouseClicked(MouseEvent evt) {
        if (this.JTInformeQx.getSelectedRow() != -1) {
            if (Long.valueOf(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 6).toString()).longValue() == 0) {
                this.xid_HOrdenQX = Long.valueOf(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 0).toString()).longValue();
                this.txtFecha.setDate(java.sql.Date.valueOf(this.xModeloInfQx.getValueAt(this.JTInformeQx.getSelectedRow(), 1).toString()));
                this.txtHoraIni.setText(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 2).toString());
                this.txtHoraFin.setText(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 3).toString());
                this.cboTipoAnestesia.setSelectedItem(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 4).toString());
                this.cboTipoServicio.setSelectedItem(this.JTInformeQx.getValueAt(this.JTInformeQx.getSelectedRow(), 7).toString());
                mCargarDatosIntegrantes();
                mCargarDatosDiagnosticos();
                mCargarDatosProcedimiento();
                mCargarDatosNacido();
                this.JTP_Cirugia.setSelectedIndex(0);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Registro ya liquidado!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboPerfusionistaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoServicioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCirujanoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPMFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNControlesFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNControlesFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNControlesActionPerformed(ActionEvent evt) {
    }

    private String mGeneraNoAtencion() {
        String xNoAtencion = null;
        String sql = "SELECT `f_ordene_anexo_tres`.`Id` , IF(MAX(`f_ordene_anexo_tres`.`IdAteAnexo3`)IS NULL,1,(MAX(`f_ordene_anexo_tres`.`IdAteAnexo3`)+1)) AS maximo\n , `f_ordene_anexo_tres`.`FechaR` FROM `f_ordene_anexo_tres`  INNER JOIN f_ordenes  ON (`f_ordene_anexo_tres`.`IdOrden` = `f_ordenes`.`Id`) WHERE (date_format(`f_ordene_anexo_tres`.`FechaR`,'%Y') ='" + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xNoAtencion = xrs.getString("maximo");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xNoAtencion;
    }

    private void mVerAnexo3(String xIdAnexo3) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            try {
                this.xsql = "SELECT\n    `h_atencion`.`Id` IdAtencion\n    , `f_ordenes`.`Id` IdOrden\nFROM\n     `f_ordenes`\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`f_ordenes`.`Id` ='" + this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "')";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    ReporteAnexo3_Fac x = new ReporteAnexo3_Fac(xrs.getString("IdAtencion"), this.xModelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString(), 1, xIdAnexo3);
                    x.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + this.xmt.getBarra() + "H_Anexo3_Orden_" + xIdAnexo3 + ".pdf");
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscaDx() {
        String sql = "SELECT     `h_orden_qx_diagnostico`.`Id_Patologia`     , `g_patologia`.`Nbre` AS Patologia    , `h_orden_qx_diagnostico`.`Tipo` FROM      `h_orden_qx_diagnostico`     INNER JOIN  `h_orden_qx`          ON (`h_orden_qx_diagnostico`.`Id_Orden_Qx` = `h_orden_qx`.`Id`)     INNER JOIN  `g_patologia`          ON (`h_orden_qx_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)     INNER JOIN  `h_atencion`          ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_orden_qx`.`Estado` =1     AND `h_atencion`.`Id_Ingreso` ='" + this.xliq.JLB_NIngreso.getText() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (xrs.getInt("Tipo") == 0) {
                        this.txtCodDxPpal.setText(xrs.getString("Id_Patologia"));
                        this.txtDxPpal.setText(xrs.getString("Patologia"));
                    } else if (xrs.getInt("Tipo") == 2) {
                        this.txtCodDxCompli.setText(xrs.getString("Id_Patologia"));
                        this.txtDxCompli.setText(xrs.getString("Patologia"));
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
