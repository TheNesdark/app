package RecursosHumanos;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.EmpleadosNomina;
import com.genoma.plus.jpa.entities.PersonaDTO;
import com.genoma.plus.jpa.entities.RhFinanciacion;
import com.genoma.plus.jpa.entities.RhNominaConceptos;
import com.genoma.plus.jpa.entities.RhNominaNovedades;
import com.genoma.plus.jpa.entities.RhNominaNovedadesDetalle;
import com.genoma.plus.jpa.entities.RhNominaPersonaConceptos;
import com.genoma.plus.jpa.entities.RhPeriodoNomina;
import com.genoma.plus.jpa.projection.RhNominaNovedadesDTO;
import com.genoma.plus.jpa.service.CcPeriodoContableService;
import com.genoma.plus.jpa.service.IEmpleadoNominaService;
import com.genoma.plus.jpa.service.IRhPeriodoNominaService;
import com.genoma.plus.jpa.service.IUtilidades;
import com.genoma.plus.jpa.service.RhNominaConceptosService;
import com.genoma.plus.jpa.service.RhNominaNovedadesDetalleService;
import com.genoma.plus.jpa.service.RhNominaNovedadesService;
import com.genoma.plus.jpa.service.RhNominaPersonaConceptosServices;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
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
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFNovedadesNomina.class */
public class JIFNovedadesNomina extends JInternalFrame {
    private final IUtilidades utilidades;
    private JIDPrestamos_Buscador1 modelPrestamosBuscador1;
    List<CcPeriodoContable> listPeriodoContable;
    List<RhPeriodoNomina> listPeriodoNomina;
    List<RhNominaConceptos> listNominaConcepto;
    List<RhNominaNovedadesDTO> listNovedadesNomina;
    private List<RhNominaNovedadesDetalle> listDetalleNovedadesNomina;
    private List<RhNominaNovedades> listNovedades;
    private RhFinanciacion rhFinanciacion;
    private RhNominaNovedades nominaNovedades;
    private RhNominaNovedadesDetalle nominaNovedadesDetalle;
    private PersonaDTO personaDTO;
    private Object[] xdatos;
    private Object[] xdatos1;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private String cantidadH;
    private int tipoForma;
    private ButtonGroup JBG_Filtro;
    private JButton JBTAgregar;
    private JComboBox<String> JCBConcepto;
    private JComboBox<String> JCBPeriodo;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaFin;
    private JDateChooser JDFechaInicio;
    private JLabel JLBId;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulado;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFDocumento;
    private JTextField JTFNombre;
    private JTabbedPane JTMenu;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSpinner txtHoraFinal;
    private JSpinner txtHoraInicio;
    private JSpinner txtMinutoFinal;
    private JSpinner txtMinutoInicio;
    private final CcPeriodoContableService periodoContable = (CcPeriodoContableService) Principal.contexto.getBean(CcPeriodoContableService.class);
    private final IRhPeriodoNominaService periodoNomina = (IRhPeriodoNominaService) Principal.contexto.getBean(IRhPeriodoNominaService.class);
    private final RhNominaNovedadesService novedadesNominaService = (RhNominaNovedadesService) Principal.contexto.getBean(RhNominaNovedadesService.class);
    private final RhNominaNovedadesDetalleService novedadesNominaDetalleService = (RhNominaNovedadesDetalleService) Principal.contexto.getBean(RhNominaNovedadesDetalleService.class);
    private final RhNominaConceptosService nominaConcepto = (RhNominaConceptosService) Principal.contexto.getBean(RhNominaConceptosService.class);
    private final IEmpleadoNominaService personaService = (IEmpleadoNominaService) Principal.contexto.getBean(IEmpleadoNominaService.class);
    private final List<RhNominaPersonaConceptos> rhNominaPersonaConceptosList = new ArrayList();
    private final RhNominaPersonaConceptosServices rhNominaPersonaConceptosServices = (RhNominaPersonaConceptosServices) Principal.contexto.getBean(RhNominaPersonaConceptosServices.class);
    private EmpleadosNomina empleadosNomina = new EmpleadosNomina();
    private final Metodos xmetodo = new Metodos();
    private final int xnfila = 0;
    private long idPersona = 0;

    public JIFNovedadesNomina(int tipoForma, String nombre) {
        this.tipoForma = 0;
        initComponents();
        setName(nombre);
        this.utilidades = (IUtilidades) Principal.contexto.getBean(IUtilidades.class);
        this.tipoForma = tipoForma;
        mNuevo();
        this.JCBPeriodo.setSelectedIndex(-1);
        this.JCBConcepto.setSelectedIndex(-1);
        mCargarDatosTabla();
        Calendar c2 = new GregorianCalendar();
        this.JDFecha.setCalendar(c2);
    }

    public void mNuevo() {
        limpiar();
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.nominaNovedades = new RhNominaNovedades();
        this.nominaNovedadesDetalle = new RhNominaNovedadesDetalle();
        this.JLBId.setText(" ");
        this.listPeriodoNomina = new ArrayList();
        this.listPeriodoNomina = this.periodoNomina.listarFiltroEstado(true);
        if (!this.listPeriodoNomina.isEmpty()) {
            this.listPeriodoNomina.forEach(item -> {
                this.JCBPeriodo.addItem(item.getNombre());
            });
        }
        this.listNominaConcepto = new ArrayList();
        this.listNominaConcepto = this.nominaConcepto.cargarListaNominaConceptos();
        if (!this.listNominaConcepto.isEmpty()) {
            this.listNominaConcepto.forEach(item2 -> {
                this.JCBConcepto.addItem(item2.getNbre());
            });
        }
        mCrearModeloTabla1();
        this.JTFDocumento.setText("");
        this.JTFNombre.setText("");
    }

    public void mGrabar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            Grabar();
            this.JLBId.setText(this.nominaNovedades.getId().toString());
            mCargarDatosTabla();
        }
    }

    public void Grabar() {
        if (this.nominaNovedades == null) {
            this.nominaNovedades = new RhNominaNovedades();
        }
        List<RhNominaNovedadesDetalle> listNovedadesDetalle = new ArrayList<>();
        this.nominaNovedades.setFechaD(this.JDFecha.getDate());
        this.nominaNovedades.setEstado(true);
        this.nominaNovedades.setAnno(Integer.valueOf(this.xmetodo.formatoANO.format(this.JDFecha.getDate())));
        this.nominaNovedades.setIdPersonaCargo(this.empleadosNomina);
        this.nominaNovedades.setIdPeriodo(this.listPeriodoNomina.get(this.JCBPeriodo.getSelectedIndex()));
        this.nominaNovedades.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        for (int y = 0; y < this.JTDetalle1.getRowCount(); y++) {
            this.nominaNovedadesDetalle = new RhNominaNovedadesDetalle();
            RhNominaConceptos conceptos = new RhNominaConceptos();
            this.nominaNovedadesDetalle.setIdEncabezado(this.nominaNovedades);
            conceptos.setId(Integer.valueOf(this.xmodelo1.getValueAt(y, 2).toString()));
            this.nominaNovedadesDetalle.setIdConcepto(conceptos);
            this.nominaNovedadesDetalle.setFechaInicio(new Date(this.xmetodo.getPasarTextoaFecha(this.xmodelo1.getValueAt(y, 5).toString()).getTime()));
            this.nominaNovedadesDetalle.setHoraInicio(this.xmodelo1.getValueAt(y, 6).toString());
            this.nominaNovedadesDetalle.setFechaFin(new Date(this.xmetodo.getPasarTextoaFecha(this.xmodelo1.getValueAt(y, 7).toString()).getTime()));
            this.nominaNovedadesDetalle.setHoraFin(this.xmodelo1.getValueAt(y, 8).toString());
            this.nominaNovedadesDetalle.setIdLiquidacionNomina(0L);
            this.nominaNovedadesDetalle.setEstado(true);
            this.nominaNovedadesDetalle.setVerificado(true);
            this.nominaNovedadesDetalle.setCantidad(Double.valueOf(this.xmodelo1.getValueAt(y, 9).toString()));
            listNovedadesDetalle.add(this.nominaNovedadesDetalle);
        }
        this.nominaNovedades.setRhNominaNovedadesDetalles(listNovedadesDetalle);
        this.nominaNovedades = this.novedadesNominaService.grabar(this.nominaNovedades);
    }

    private EmpleadosNomina buscarXdocumento(String value, int forma) {
        if (forma == 0) {
            return this.personaService.buscarEmpleadoPorNumeroDocumento(value, true);
        }
        return this.personaService.buscarEmpleadoPorId(Long.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString()));
    }

    private void fillTextFieldWithPersona() {
        this.JTFDocumento.setText(this.personaDTO.noDocumento);
        this.JTFNombre.setText(this.personaDTO.nombre1 + " " + this.personaDTO.nombre2 + " " + this.personaDTO.apellido1 + " " + this.personaDTO.apellido2);
    }

    public void fillTextFieldWithPersona(EmpleadosNomina empleadosNomina) {
        this.empleadosNomina = empleadosNomina;
        this.personaDTO = this.empleadosNomina.getIdPersona();
        this.JTFDocumento.setText(this.personaDTO.noDocumento);
        this.JTFNombre.setText(this.personaDTO.nombre1 + " " + this.personaDTO.nombre2 + " " + this.personaDTO.apellido1 + " " + this.personaDTO.apellido2);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Persona Nomina", "Periodo", "estado"}) { // from class: RecursosHumanos.JIFNovedadesNomina.1
            Class[] types = {Long.class, java.util.Date.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "IdPeriodo", "IdConcepto", "Periodo", "Concepto", "Fecha Inicio", "Hora Inicio", "Fecha Fin", "Hora Fin", "cantidad"}) { // from class: RecursosHumanos.JIFNovedadesNomina.2
            Class[] types = {java.util.Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    public void mAnulacion() {
        Anular frm = new Anular((Frame) null, true, "NovedadesNomina", 27, this.tipoForma);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
    }

    public void anularBase(String movito, String observacion) {
        this.nominaNovedades.setEstado(false);
        this.nominaNovedades.setFechaAnulacion(this.xmetodo.getFechaActual());
        this.nominaNovedades.setMotivoAnulacion(movito);
        this.nominaNovedades.setObservacionAnulacion(observacion);
        this.nominaNovedades.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.novedadesNominaService.anular(this.nominaNovedades);
        mCargarDatosTabla();
    }

    private void mCargarDatosTabla1(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        String horaIni;
        String horaFin;
        String horaIni2;
        String horaFin2;
        this.JDFechaInicio.getDate();
        this.JDFechaFin.getDate();
        if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) < 10) {
            horaIni = "0" + this.txtHoraInicio.getValue().toString();
        } else {
            horaIni = this.txtHoraInicio.getValue().toString();
        }
        if (Integer.parseInt(this.txtHoraFinal.getValue().toString()) < 10) {
            horaFin = "0" + this.txtHoraFinal.getValue().toString();
        } else {
            horaFin = this.txtHoraFinal.getValue().toString();
        }
        if (Integer.parseInt(this.txtMinutoInicio.getValue().toString()) < 10) {
            horaIni2 = horaIni + ":0" + this.txtMinutoInicio.getValue().toString() + ":00";
        } else {
            horaIni2 = horaIni + ":" + this.txtMinutoInicio.getValue().toString() + ":00";
        }
        if (Integer.parseInt(this.txtMinutoFinal.getValue().toString()) < 10) {
            horaFin2 = horaFin + ":0" + this.txtMinutoFinal.getValue().toString() + ":00";
        } else {
            horaFin2 = horaFin + ":" + this.txtMinutoFinal.getValue().toString() + ":00";
        }
        Long[] time = this.utilidades.devolverNumerHorasEntreDosfechas(fechaInicio, fechaFin);
        Long numeroDias = this.utilidades.devolverCantidadDiasDosFecha(fechaInicio.toLocalDate(), fechaFin.toLocalDate());
        this.xmodelo1.addRow(this.xdatos1);
        this.xmodelo1.setValueAt(this.JDFecha.getDate(), this.JTDetalle1.getRowCount() - 1, 0);
        this.xmodelo1.setValueAt(Integer.valueOf(this.JCBPeriodo.getSelectedIndex()), this.JTDetalle1.getRowCount() - 1, 1);
        this.xmodelo1.setValueAt(this.listNominaConcepto.get(this.JCBConcepto.getSelectedIndex()).getId(), this.JTDetalle1.getRowCount() - 1, 2);
        this.xmodelo1.setValueAt(this.JCBPeriodo.getSelectedItem(), this.JTDetalle1.getRowCount() - 1, 3);
        this.xmodelo1.setValueAt(this.JCBConcepto.getSelectedItem(), this.JTDetalle1.getRowCount() - 1, 4);
        this.xmodelo1.setValueAt(this.xmetodo.formatoAMD1.format(this.JDFechaInicio.getDate()), this.JTDetalle1.getRowCount() - 1, 5);
        this.xmodelo1.setValueAt(horaIni2, this.JTDetalle1.getRowCount() - 1, 6);
        this.xmodelo1.setValueAt(this.xmetodo.formatoAMD1.format(this.JDFechaFin.getDate()), this.JTDetalle1.getRowCount() - 1, 7);
        this.xmodelo1.setValueAt(horaFin2, this.JTDetalle1.getRowCount() - 1, 8);
        if (this.listNominaConcepto.get(this.JCBConcepto.getSelectedIndex()).getTipoCalculo().intValue() == 2) {
            this.xmodelo1.setValueAt(Long.valueOf(numeroDias.longValue() + 1), this.JTDetalle1.getRowCount() - 1, 9);
        } else {
            this.xmodelo1.setValueAt(time[0] + "." + time[1], this.JTDetalle1.getRowCount() - 1, 9);
        }
    }

    private void mAgregarDetalle(LocalDateTime fecha1, LocalDateTime fecha2) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JCBConcepto.getSelectedIndex() != -1) {
                mCargarDatosTabla1(fecha1, fecha2);
                limpiar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConcepto.setSelectedIndex(-1);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.setSelectedIndex(-1);
    }

    public void limpiarTodo() {
        this.nominaNovedades = new RhNominaNovedades();
        this.nominaNovedadesDetalle = new RhNominaNovedadesDetalle();
        mCrearModeloTabla1();
        this.JTFNombre.setText("");
        this.JTFDocumento.setText("");
        this.JCBPeriodo.setSelectedIndex(-1);
        this.JCBConcepto.setSelectedIndex(-1);
        this.txtHoraInicio.setValue(0);
        this.txtMinutoInicio.setValue(0);
        this.txtHoraFinal.setValue(0);
        this.txtMinutoFinal.setValue(0);
        this.JDFechaInicio.setDate((java.util.Date) null);
        this.JDFechaFin.setDate((java.util.Date) null);
        this.JLBId.setText("");
    }

    public void limpiar() {
        this.JCBConcepto.setSelectedIndex(-1);
        this.txtHoraInicio.setValue(0);
        this.txtMinutoInicio.setValue(0);
        this.txtHoraFinal.setValue(0);
        this.txtMinutoFinal.setValue(0);
        this.JDFechaInicio.setDate((java.util.Date) null);
        this.JDFechaFin.setDate((java.util.Date) null);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        if (this.JRBTodos.isSelected()) {
            this.listNovedades = this.novedadesNominaService.listarTodasNovedades();
        } else if (this.JRBActivos.isSelected()) {
            this.listNovedades = this.novedadesNominaService.listaNovedadesEstado(true);
        } else if (this.JRBAnulado.isSelected()) {
            this.listNovedades = this.novedadesNominaService.listaNovedadesEstado(false);
        }
        if (!this.listNovedades.isEmpty()) {
            for (int i = 0; i < this.listNovedades.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listNovedades.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listNovedades.get(i).getFechaD(), i, 1);
                this.xmodelo.setValueAt(this.listNovedades.get(i).getIdPersonaCargo().getIdPersona().getApellido1() + " " + this.listNovedades.get(i).getIdPersonaCargo().getIdPersona().getApellido2() + " " + this.listNovedades.get(i).getIdPersonaCargo().getIdPersona().getNombre1() + " " + this.listNovedades.get(i).getIdPersonaCargo().getIdPersona().getNombre2(), i, 2);
                this.xmodelo.setValueAt(this.listNovedades.get(i).getIdPeriodo().getNombre(), i, 3);
                this.xmodelo.setValueAt(this.listNovedades.get(i).getEstado(), i, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v95, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JTMenu = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.jPanel3 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JTFDocumento = new JTextField();
        this.JTFNombre = new JTextField();
        this.JBTAgregar = new JButton();
        this.JCBConcepto = new JComboBox<>();
        this.JCBPeriodo = new JComboBox<>();
        this.jPanel10 = new JPanel();
        this.JDFechaInicio = new JDateChooser();
        this.txtHoraInicio = new JSpinner();
        this.txtMinutoInicio = new JSpinner();
        this.jPanel11 = new JPanel();
        this.txtMinutoFinal = new JSpinner();
        this.txtHoraFinal = new JSpinner();
        this.JDFechaFin = new JDateChooser();
        this.JLBId = new JLabel();
        this.jPanel2 = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel4 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBAnulado = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("NOVEDADES NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_NovedadesNomina");
        this.JTMenu.setForeground(new Color(0, 102, 0));
        this.JTMenu.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setSelectionBackground(Color.white);
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFNovedadesNomina.3
            public void mouseClicked(MouseEvent evt) {
                JIFNovedadesNomina.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDocumento.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFNovedadesNomina.4
            public void keyPressed(KeyEvent evt) {
                JIFNovedadesNomina.this.JTFDocumentoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFNovedadesNomina.this.JTFDocumentoKeyReleased(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFNovedadesNomina.5
            public void mouseClicked(MouseEvent evt) {
                JIFNovedadesNomina.this.JTFNombreMouseClicked(evt);
            }
        });
        this.JBTAgregar.setFont(new Font("Arial", 1, 12));
        this.JBTAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregar.setText("Agregar");
        this.JBTAgregar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFNovedadesNomina.6
            public void actionPerformed(ActionEvent evt) {
                JIFNovedadesNomina.this.JBTAgregarActionPerformed(evt);
            }
        });
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFNovedadesNomina.7
            public void itemStateChanged(ItemEvent evt) {
                JIFNovedadesNomina.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha / Hora de Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel10.setLayout((LayoutManager) null);
        this.JDFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.JDFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFNovedadesNomina.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFNovedadesNomina.this.JDFechaInicioPropertyChange(evt);
            }
        });
        this.jPanel10.add(this.JDFechaInicio);
        this.JDFechaInicio.setBounds(10, 20, 170, 50);
        this.txtHoraInicio.setFont(new Font("Arial", 1, 12));
        this.txtHoraInicio.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        this.txtHoraInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.jPanel10.add(this.txtHoraInicio);
        this.txtHoraInicio.setBounds(190, 25, 60, 40);
        this.txtMinutoInicio.setFont(new Font("Arial", 1, 12));
        this.txtMinutoInicio.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        this.txtMinutoInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Minutos", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.jPanel10.add(this.txtMinutoInicio);
        this.txtMinutoInicio.setBounds(250, 25, 60, 40);
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha / Hora Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel11.setLayout((LayoutManager) null);
        this.txtMinutoFinal.setFont(new Font("Arial", 1, 12));
        this.txtMinutoFinal.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        this.txtMinutoFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Minutos", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.jPanel11.add(this.txtMinutoFinal);
        this.txtMinutoFinal.setBounds(260, 25, 60, 40);
        this.txtHoraFinal.setFont(new Font("Arial", 1, 12));
        this.txtHoraFinal.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        this.txtHoraFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.jPanel11.add(this.txtHoraFinal);
        this.txtHoraFinal.setBounds(200, 25, 60, 40);
        this.JDFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 8), Color.blue));
        this.JDFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFNovedadesNomina.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFNovedadesNomina.this.JDFechaFinPropertyChange(evt);
            }
        });
        this.jPanel11.add(this.JDFechaFin);
        this.JDFechaFin.setBounds(10, 20, 180, 50);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAgregar, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDocumento, -2, 192, -2)).addComponent(this.jPanel10, -1, -1, 32767)).addGap(20, 20, 20)).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 324, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBConcepto, 0, 439, 32767).addComponent(this.JTFNombre).addComponent(this.jPanel11, -2, 331, -2)))).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDocumento, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addComponent(this.JDFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JCBConcepto, -2, 50, -2)).addGap(8, 8, 8).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel10, GroupLayout.Alignment.LEADING, -2, 80, -2).addComponent(this.jPanel11, -2, 80, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAgregar, -2, 53, -2).addGap(34, 34, 34)));
        this.JLBId.setBackground(new Color(255, 255, 255));
        this.JLBId.setFont(new Font("Arial", 1, 18));
        this.JLBId.setForeground(new Color(255, 0, 0));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle1, -2, 794, -2).addComponent(this.JLBId, -2, 95, -2)).addContainerGap(10, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel3, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBId, -2, 47, -2).addContainerGap()));
        this.JTMenu.addTab("REGISTRO", this.jPanel1);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFNovedadesNomina.10
            public void mouseClicked(MouseEvent evt) {
                JIFNovedadesNomina.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFNovedadesNomina.11
            public void actionPerformed(ActionEvent evt) {
                JIFNovedadesNomina.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activo");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFNovedadesNomina.12
            public void actionPerformed(ActionEvent evt) {
                JIFNovedadesNomina.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBAnulado);
        this.JRBAnulado.setFont(new Font("Arial", 1, 12));
        this.JRBAnulado.setText("Anulado");
        this.JRBAnulado.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFNovedadesNomina.13
            public void actionPerformed(ActionEvent evt) {
                JIFNovedadesNomina.this.JRBAnuladoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBActivos, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAnulado, -2, 85, -2).addContainerGap(32, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBAnulado)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 777, -2).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(18, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 477, -2).addContainerGap(22, 32767)));
        this.JTMenu.addTab("HISTÓRICO", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(22, 32767).addComponent(this.JTMenu, -2, 849, -2).addGap(20, 20, 20)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTMenu).addContainerGap()));
        getAccessibleContext().setAccessibleName("NovedadesNomina");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.idPersona = this.listNovedades.get(this.JTDetalle.getSelectedRow()).getIdPersonaCargo().getId().longValue();
            this.JDFecha.setDate(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getFechaD());
            this.JLBId.setText("" + this.listNovedades.get(this.JTDetalle.getSelectedRow()).getId());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFDocumento.setText(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getIdPersonaCargo().getIdPersona().getNoDocumento());
            this.JCBPeriodo.setSelectedItem(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getIdPeriodo().getNombre());
            mCrearModeloTabla1();
            this.listNovedades.get(this.JTDetalle.getSelectedRow()).getRhNominaNovedadesDetalles().forEach(e -> {
                this.xmodelo1.addRow(this.xdatos1);
                this.xmodelo1.setValueAt(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getFechaD(), this.JTDetalle1.getRowCount() - 1, 0);
                this.xmodelo1.setValueAt(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getIdPeriodo().getNombre(), this.JTDetalle1.getRowCount() - 1, 3);
                this.xmodelo1.setValueAt(e.getIdConcepto().getNbre(), this.JTDetalle1.getRowCount() - 1, 4);
                this.xmodelo1.setValueAt(this.listNovedades.get(this.JTDetalle.getSelectedRow()).getIdPeriodo().getId(), this.JTDetalle1.getRowCount() - 1, 1);
                this.xmodelo1.setValueAt(e.getIdConcepto().getId(), this.JTDetalle1.getRowCount() - 1, 2);
                this.xmodelo1.setValueAt(this.xmetodo.formatoAMD1.format(e.getFechaInicio()), this.JTDetalle1.getRowCount() - 1, 5);
                this.xmodelo1.setValueAt(e.getHoraInicio(), this.JTDetalle1.getRowCount() - 1, 7);
                this.xmodelo1.setValueAt(this.xmetodo.formatoAMD1.format(e.getFechaFin()), this.JTDetalle1.getRowCount() - 1, 7);
                this.xmodelo1.setValueAt(e.getHoraFin(), this.JTDetalle1.getRowCount() - 1, 8);
                this.xmodelo1.setValueAt(e.getCantidad(), this.JTDetalle1.getRowCount() - 1, 9);
            });
            this.nominaNovedades = this.listNovedades.get(this.JTDetalle.getSelectedRow());
            this.JTMenu.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            if (!this.JTFDocumento.getText().isEmpty()) {
                this.empleadosNomina = buscarXdocumento(this.JTFDocumento.getText(), 0);
                this.personaDTO = this.empleadosNomina.getIdPersona();
                fillTextFieldWithPersona();
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo N# Documento esta vacio", "Alert", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregarActionPerformed(ActionEvent evt) {
        if (this.JDFechaInicio.getDate() != null && this.JDFechaFin.getDate() != null && this.JCBConcepto.getSelectedIndex() != -1) {
            LocalDateTime fecha1 = LocalDateTime.of(Integer.valueOf(this.xmetodo.formatoANO.format(this.JDFechaInicio.getDate())).intValue(), Integer.valueOf(this.xmetodo.formatoMes.format(this.JDFechaInicio.getDate())).intValue(), Integer.valueOf(this.xmetodo.formatoDia.format(this.JDFechaInicio.getDate())).intValue(), Integer.valueOf(this.txtHoraInicio.getValue().toString()).intValue(), Integer.valueOf(this.txtMinutoInicio.getValue().toString()).intValue(), 0);
            LocalDateTime fecha2 = LocalDateTime.of(Integer.valueOf(this.xmetodo.formatoANO.format(this.JDFechaFin.getDate())).intValue(), Integer.valueOf(this.xmetodo.formatoMes.format(this.JDFechaFin.getDate())).intValue(), Integer.valueOf(this.xmetodo.formatoDia.format(this.JDFechaFin.getDate())).intValue(), Integer.valueOf(this.txtHoraFinal.getValue().toString()).intValue(), Integer.valueOf(this.txtMinutoFinal.getValue().toString()).intValue(), 0);
            if (fecha1.isBefore(fecha2)) {
                mAgregarDetalle(fecha1, fecha2);
                return;
            }
            String mensaje = "Fecha y hora fin menor a la fecha y hora inicial";
            if (this.listNominaConcepto.get(this.JCBConcepto.getSelectedIndex()).getTipoCalculo().intValue() == 2) {
                mensaje = "Fecha fin menor a la fecha inicial";
            }
            JOptionPane.showInternalMessageDialog(this, mensaje, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreMouseClicked(MouseEvent evt) {
        this.modelPrestamosBuscador1 = new JIDPrestamos_Buscador1((Frame) null, true, this);
        this.modelPrestamosBuscador1.setLocationRelativeTo(null);
        this.modelPrestamosBuscador1.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaInicioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDocumentoKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
        if (!this.listNominaConcepto.isEmpty() && this.JCBConcepto.getSelectedIndex() != -1) {
            if (this.listNominaConcepto.get(this.JCBConcepto.getSelectedIndex()).getTipoCalculo().intValue() == 2) {
                this.txtHoraFinal.setValue(23);
                this.txtMinutoFinal.setValue(59);
                enableCamposHora(false);
            } else {
                this.txtHoraFinal.setValue(0);
                this.txtMinutoFinal.setValue(0);
                enableCamposHora(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladoActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    private void enableCamposHora(Boolean estado) {
        this.txtHoraFinal.setEnabled(estado.booleanValue());
        this.txtHoraInicio.setEnabled(estado.booleanValue());
        this.txtMinutoFinal.setEnabled(estado.booleanValue());
        this.txtMinutoInicio.setEnabled(estado.booleanValue());
    }
}
