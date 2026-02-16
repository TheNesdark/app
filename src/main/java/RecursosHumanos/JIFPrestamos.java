package RecursosHumanos;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.EmpleadosNomina;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.PersonaDTO;
import com.genoma.plus.jpa.entities.RhFinanciacion;
import com.genoma.plus.jpa.entities.RhFinanciacionDetalle;
import com.genoma.plus.jpa.entities.RhNominaConceptoUnidadf;
import com.genoma.plus.jpa.entities.RhNominaPersonaConceptos;
import com.genoma.plus.jpa.service.IEmpleadoNominaService;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.RhFinanciacionService;
import com.genoma.plus.jpa.service.RhNominaPersonaConceptosServices;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFPrestamos.class */
public class JIFPrestamos extends JInternalFrame {
    private RhFinanciacion rhFinanciacion;
    private PersonaDTO personaDTO;
    private List<RhNominaConceptoUnidadf> listConceptoUnidadFuncional;
    private JIDPrestamos_Buscador modelPrestamosBuscador;
    private DefaultTableModel xmodelo;
    private DefaultTableModel modelHistorico;
    private Object[] xdatos;
    private JButton JBBuscar;
    private JComboBox<String> JCBConcepto;
    private JComboBox<String> JCBTerceros;
    private JDateChooser JDCFecha;
    private JDateChooser JDCFechaInicio;
    private JLabel JLCodigo;
    private JTable JTDetalle;
    private JTextField JTFCuotaTotal;
    private JTextField JTFDocumento;
    private JTextField JTFFinanciado;
    private JTextField JTFNombre;
    private JTextField JTFNumeroCuotas;
    private JTextField JTFPorcentajeInteres;
    private JTextField JTFSaldoNetoPendiente;
    private JTextField JTFValorCuota;
    private JTextField JTFValorDescuento;
    private JTextField JTFValorInteres;
    private JTable JTHistorico;
    private JTabbedPane JTMenu;
    private JTextPane JTP_Observ;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextArea jTextArea1;
    private final Metodos metodos = new Metodos();
    private final IGEmpresaService gEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
    private final IEmpleadoNominaService personaService = (IEmpleadoNominaService) Principal.contexto.getBean(IEmpleadoNominaService.class);
    private final RhNominaPersonaConceptosServices rhNominaPersonaConceptosServices = (RhNominaPersonaConceptosServices) Principal.contexto.getBean(RhNominaPersonaConceptosServices.class);
    private final RhFinanciacionService rhFinanciacionService = (RhFinanciacionService) Principal.contexto.getBean(RhFinanciacionService.class);
    private List<GEmpresa> tercerosList = new ArrayList();
    private List<RhNominaPersonaConceptos> rhNominaPersonaConceptosList = new ArrayList();
    private List<RhFinanciacionDetalle> rhFinanciacionDetalleList = new ArrayList();
    private List<RhFinanciacion> rhFinanciacionHistoricoList = new ArrayList();
    private GEmpresa tercero = new GEmpresa();
    private RhNominaPersonaConceptos concepto = new RhNominaPersonaConceptos();
    private EmpleadosNomina empleadosNomina = new EmpleadosNomina();
    private EmpleadosNomina empleadosNominaHistorico = new EmpleadosNomina();
    private NumberFormat nf = NumberFormat.getInstance(new Locale("es", "CO"));

    public JIFPrestamos() {
        initComponents();
        this.JTFNombre.setEditable(false);
        nuevo();
    }

    public void nuevo() {
        this.JDCFecha.setDate(this.metodos.getFechaActual());
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.tercerosList = this.gEmpresaService.buscarPorNomina(true);
        this.tercerosList.stream().map(obj -> {
            String nombreEmpresa;
            if (!obj.getApellido1().isEmpty()) {
                nombreEmpresa = obj.getApellido1() + " " + obj.getApellido2() + " " + obj.getNombre1() + " " + obj.getNombre2();
            } else {
                nombreEmpresa = obj.getNbre();
            }
            return nombreEmpresa;
        }).forEachOrdered(nombreEmpresa -> {
            this.JCBTerceros.addItem(nombreEmpresa);
        });
        this.JTFFinanciado.setText("0");
        this.JTFNumeroCuotas.setText("0");
        this.JTFCuotaTotal.setText("0");
        this.JTFPorcentajeInteres.setText("0");
        this.JTFValorCuota.setText("0");
        this.JTFValorDescuento.setText("0");
        this.JTFValorInteres.setText("0");
        this.JTFSaldoNetoPendiente.setText("0");
        this.rhNominaPersonaConceptosList = new ArrayList();
        this.rhFinanciacionDetalleList = new ArrayList();
        this.rhFinanciacionHistoricoList = new ArrayList();
        crearTablaHistorico();
        mCrearModeloDatos();
    }

    private void calcular() {
        Double cuotaTotal = new Double(0.0d);
        Double financiado = Double.valueOf(!this.JTFFinanciado.getText().isEmpty() ? Double.parseDouble(this.JTFFinanciado.getText()) : 0.0d);
        int nCuotas = !this.JTFNumeroCuotas.getText().isEmpty() ? Integer.parseInt(this.JTFNumeroCuotas.getText()) : 0;
        if (financiado.doubleValue() != 0.0d && nCuotas != 0) {
            cuotaTotal = Double.valueOf(financiado.doubleValue() / ((double) nCuotas));
        }
        int porcentajeInteres = !this.JTFPorcentajeInteres.getText().isEmpty() ? Integer.parseInt(this.JTFPorcentajeInteres.getText()) : 0;
        Double valorDescuento = Double.valueOf(!this.JTFValorDescuento.getText().isEmpty() ? Double.parseDouble(this.JTFValorDescuento.getText()) : 0.0d);
        Double valorCuota = Double.valueOf(cuotaTotal.doubleValue() + ((cuotaTotal.doubleValue() * ((double) porcentajeInteres)) / 100.0d));
        Double valorInteres = Double.valueOf(valorCuota.doubleValue() - cuotaTotal.doubleValue());
        Double saldoNetoPendiente = Double.valueOf(financiado.doubleValue() - valorDescuento.doubleValue());
        if (cuotaTotal.doubleValue() != 0.0d) {
            this.JTFCuotaTotal.setText(this.nf.format(cuotaTotal));
        }
        if (valorCuota.doubleValue() != 0.0d) {
            this.JTFValorCuota.setText(this.nf.format(valorCuota));
        }
        if (valorInteres.doubleValue() != 0.0d) {
            this.JTFValorInteres.setText(this.nf.format(valorInteres));
        }
        if (saldoNetoPendiente.doubleValue() != 0.0d) {
            this.JTFSaldoNetoPendiente.setText(this.nf.format(saldoNetoPendiente));
        }
        if (this.JCBTerceros.getSelectedIndex() != -1) {
            this.tercero = (GEmpresa) filteringCombo(this.JCBTerceros.getSelectedIndex(), this.tercerosList);
        }
        System.out.println("llenardo " + this.JTP_Observ.getText());
        this.rhFinanciacion = RhFinanciacion.builder().id((Integer) null).fecha(this.JDCFecha.getDate()).fechaInicio(this.JDCFechaInicio.getDate()).vrfinanciado(financiado).numcuotas(Integer.valueOf(nCuotas)).cuotaactual(new Double(0.0d)).porcentajeInteres(porcentajeInteres).vrcuota(valorCuota).vrdescuento(valorDescuento).vrinteres(valorInteres).saldonetopendiente(saldoNetoPendiente).observacion(this.JTP_Observ.getText()).idUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue()).motivoAnulacion((String) null).observacionAnulacion((String) null).fechaAnulacion((Date) null).usuarioAnulacion((String) null).estado(true).idTercero(this.tercero).idRhConceptoUF(this.listConceptoUnidadFuncional.get(this.JCBConcepto.getSelectedIndex())).idPersonaRh(this.empleadosNomina).rhFinanciacionDetalleCollection((Collection) null).build();
        this.rhFinanciacionDetalleList.clear();
        for (int i = 0; i < nCuotas; i++) {
            this.rhFinanciacionDetalleList.add(new RhFinanciacionDetalle((Integer) null, i + 1, valorCuota, cuotaTotal, valorInteres, (Double) null, this.rhFinanciacion));
        }
        if (this.JTFFinanciado.getText() != "0" && this.JTFNumeroCuotas.getText() != "0" && this.JTFPorcentajeInteres.getText() != "0" && this.JTFSaldoNetoPendiente.getText() != "0") {
            mCrearModeloDatos();
            mCargarDatosTabla(this.rhFinanciacionDetalleList);
            this.rhFinanciacion.setRhFinanciacionDetalleCollection(this.rhFinanciacionDetalleList);
        }
    }

    public void mAnulacion() {
        Anular frm = new Anular(null, true, "Prestamo", 27);
        frm.setVisible(true);
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.metodos.getFechaActual());
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.JTFFinanciado.setText("0");
        this.JTFNumeroCuotas.setText("0");
        this.JTFCuotaTotal.setText("0");
        this.JTFPorcentajeInteres.setText("0");
        this.JTFValorCuota.setText("0");
        this.JTFValorDescuento.setText("0");
        this.JTFValorInteres.setText("0");
        this.JTFSaldoNetoPendiente.setText("0");
        this.JTP_Observ.setText("");
        this.JTFDocumento.setText("");
        this.JTFNombre.setText("");
        this.JCBTerceros.setSelectedIndex(-1);
        this.JLCodigo.setText("CÓDIGO:");
        this.rhNominaPersonaConceptosList = new ArrayList();
        this.rhFinanciacionDetalleList = new ArrayList();
        this.rhFinanciacionHistoricoList = new ArrayList();
        crearTablaHistorico();
        mCrearModeloDatos();
    }

    private void fillFinanciacionCampos() {
        this.tercerosList = this.gEmpresaService.buscarPorNomina(true);
        for (GEmpresa obj : this.tercerosList) {
            this.JCBTerceros.addItem(obj.getNbre());
        }
        int i = 0;
        while (true) {
            if (i >= this.JCBTerceros.getItemCount()) {
                break;
            }
            if (!((String) this.JCBTerceros.getItemAt(i)).equals(this.rhFinanciacion.getIdTercero().getNbre())) {
                i++;
            } else {
                this.JCBTerceros.setSelectedIndex(i);
                break;
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.JCBConcepto.getItemCount()) {
                break;
            }
            if (!((String) this.JCBConcepto.getItemAt(i2)).equals(this.rhFinanciacion.getIdRhConceptoUF().getRhNominaConceptos().getNbre())) {
                i2++;
            } else {
                this.JCBConcepto.setSelectedIndex(i2);
                break;
            }
        }
        this.JTFFinanciado.setText(this.nf.format(this.rhFinanciacion.getVrfinanciado()));
        this.JTFNumeroCuotas.setText(this.nf.format(this.rhFinanciacion.getNumcuotas()));
        this.JTFCuotaTotal.setText(this.nf.format(this.rhFinanciacion.getCuotaactual()));
        this.JTFPorcentajeInteres.setText(this.nf.format(this.rhFinanciacion.getPorcentajeInteres()));
        this.JTFValorCuota.setText(this.nf.format(this.rhFinanciacion.getVrcuota()));
        this.JTFValorDescuento.setText(this.nf.format(this.rhFinanciacion.getVrdescuento()));
        this.JTFValorInteres.setText(this.nf.format(this.rhFinanciacion.getVrinteres()));
        this.JTFSaldoNetoPendiente.setText(this.nf.format(this.rhFinanciacion.getSaldonetopendiente()));
        this.JTP_Observ.setText(this.rhFinanciacion.getObservacion());
        this.JDCFecha.setDate(this.rhFinanciacion.getFecha());
        this.JLCodigo.setText("CÓDIGO: " + this.rhFinanciacion.getId());
        mCrearModeloDatos();
        mCargarDatosTabla(new ArrayList(this.rhFinanciacion.getRhFinanciacionDetalleCollection()));
    }

    public void anularBase(String movito, String observacion) {
        this.rhFinanciacion.setEstado(false);
        this.rhFinanciacion.setFechaAnulacion(this.metodos.getFechaActual());
        this.rhFinanciacion.setMotivoAnulacion(movito);
        this.rhFinanciacion.setObservacionAnulacion(observacion);
        this.rhFinanciacion.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        int id = this.rhFinanciacionService.guardarRhFinanciacion(this.rhFinanciacion).intValue();
        if (this.rhFinanciacion.getId() != null) {
            if (id != 0) {
                this.JLCodigo.setText("CÓDIGO: " + this.rhFinanciacion.getId());
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Error al guardar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No hay datos para anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabar() {
        if (this.JCBConcepto.getSelectedIndex() != -1) {
            if (this.JCBTerceros.getSelectedIndex() != -1) {
                if (!this.JDCFecha.getDate().toString().isEmpty()) {
                    if (!this.JTFDocumento.getText().isEmpty()) {
                        if (this.JTFFinanciado.getText() != "0") {
                            if (this.JTFNumeroCuotas.getText() != "0") {
                                if (this.JTFPorcentajeInteres.getText() != "0") {
                                    if (!this.JTFValorDescuento.getText().isEmpty()) {
                                        if (!this.JTP_Observ.getText().isEmpty()) {
                                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            if (x == 0) {
                                                calcular();
                                                this.JDCFecha.requestFocus();
                                                System.out.println("Observaciion  :" + this.rhFinanciacion.getObservacion());
                                                int id = this.rhFinanciacionService.guardarRhFinanciacion(this.rhFinanciacion).intValue();
                                                if (id != 0) {
                                                    this.JLCodigo.setText("CÓDIGO: " + this.rhFinanciacion.getId());
                                                    return;
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Error al guardar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "El campo Observacion esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "El campo Valor Descuento esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "El campo Porcentaje Interes esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "El campo Numero Cuotas esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El campo Financiado esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo Documento esta vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTerceros.setSelectedIndex(-1);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBConcepto.setSelectedIndex(-1);
    }

    private void mCargarDatosTabla(List<RhFinanciacionDetalle> list) {
        for (int i = 0; i < list.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(i).getNoCuota()), i, 0);
            this.xmodelo.setValueAt(list.get(i).getValorCuotaMensual(), i, 1);
            this.xmodelo.setValueAt(list.get(i).getValorCapital(), i, 2);
            this.xmodelo.setValueAt(list.get(i).getValorInteres(), i, 3);
        }
    }

    private <T> T filteringCombo(int valor, List<T> lista) {
        return lista.get(valor);
    }

    private EmpleadosNomina buscarXdocumento(String value) {
        return this.personaService.buscarEmpleadoPorNumeroDocumento(value, true);
    }

    public void mGrabar() {
        grabar();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaHistorico() {
        this.modelHistorico = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaInicio", "Financiado", "N°Cuota", "Saldo Neto Pendiente"}) { // from class: RecursosHumanos.JIFPrestamos.1
            Class[] types = {Integer.class, Date.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.modelHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    private void cargarDatosHistorico() {
        crearTablaHistorico();
        for (RhFinanciacion emp : this.rhFinanciacionHistoricoList) {
            this.modelHistorico.addRow((Object[]) null);
            this.modelHistorico.setValueAt(emp.getId(), this.JTHistorico.getRowCount() - 1, 0);
            this.modelHistorico.setValueAt(emp.getFechaInicio(), this.JTHistorico.getRowCount() - 1, 1);
            this.modelHistorico.setValueAt(emp.getNumcuotas(), this.JTHistorico.getRowCount() - 1, 2);
            this.modelHistorico.setValueAt(emp.getCuotaactual(), this.JTHistorico.getRowCount() - 1, 3);
            this.modelHistorico.setValueAt(emp.getSaldonetopendiente(), this.JTHistorico.getRowCount() - 1, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Cuota", "Valor Cuota Mensual", "Valor Capital", "Valor Interes"}) { // from class: RecursosHumanos.JIFPrestamos.2
            Class[] types = {Integer.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
    }

    private void fillTextFieldWithPersona() {
        this.JTFDocumento.setText(this.personaDTO.noDocumento);
        this.JTFNombre.setText(this.personaDTO.nombre1 + " " + this.personaDTO.nombre2 + " " + this.personaDTO.apellido1 + " " + this.personaDTO.apellido2);
        fillConcept();
    }

    private void filldWithRhFinanciacion(RhFinanciacion rhFinanciacion) {
        this.rhFinanciacion = rhFinanciacion;
        fillFinanciacionCampos();
    }

    public void fillTextFieldWithPersona(EmpleadosNomina empleadosNomina) {
        this.empleadosNomina = empleadosNomina;
        this.personaDTO = this.empleadosNomina.getIdPersona();
        this.JTFDocumento.setText(this.personaDTO.noDocumento);
        this.JTFNombre.setText(this.personaDTO.nombre1 + " " + this.personaDTO.nombre2 + " " + this.personaDTO.apellido1 + " " + this.personaDTO.apellido2);
        fillConcept();
    }

    private void fillConcept() {
        this.listConceptoUnidadFuncional = new ArrayList();
        this.rhNominaPersonaConceptosList = this.rhNominaPersonaConceptosServices.buscarConceptoXEmpleadoNomina(this.empleadosNomina);
        this.listConceptoUnidadFuncional = (List) this.rhNominaPersonaConceptosList.stream().sorted(Comparator.comparing(e -> {
            return e.getIdRhConceptoUF().getRhNominaConceptos().getNbre();
        })).map(p -> {
            return p.getIdRhConceptoUF();
        }).collect(Collectors.toList());
        this.listConceptoUnidadFuncional.forEach(obj -> {
            this.JCBConcepto.addItem(obj.getRhNominaConceptos().getNbre());
        });
    }

    /* JADX WARN: Type inference failed for: r3v119, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v91, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.JTMenu = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTFNumeroCuotas = new JTextField();
        this.JDCFecha = new JDateChooser();
        this.JTFNombre = new JTextField();
        this.JCBConcepto = new JComboBox<>();
        this.JCBTerceros = new JComboBox<>();
        this.JTFDocumento = new JTextField();
        this.JTFFinanciado = new JTextField();
        this.JTFCuotaTotal = new JTextField();
        this.JTFPorcentajeInteres = new JTextField();
        this.JTFValorCuota = new JTextField();
        this.JTFValorDescuento = new JTextField();
        this.JTFValorInteres = new JTextField();
        this.JTFSaldoNetoPendiente = new JTextField();
        this.JBBuscar = new JButton();
        this.JDCFechaInicio = new JDateChooser();
        this.jScrollPane4 = new JScrollPane();
        this.JTP_Observ = new JTextPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JLCodigo = new JLabel();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTHistorico = new JTable();
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setRows(5);
        this.jScrollPane1.setViewportView(this.jTextArea1);
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE PRÉSTAMOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_prestamos");
        this.JTMenu.setForeground(new Color(0, 103, 0));
        this.JTMenu.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNumeroCuotas.setFont(new Font("Arial", 1, 12));
        this.JTFNumeroCuotas.setHorizontalAlignment(4);
        this.JTFNumeroCuotas.setBorder(BorderFactory.createTitledBorder((Border) null, "N. Cuotas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNumeroCuotas.addFocusListener(new FocusAdapter() { // from class: RecursosHumanos.JIFPrestamos.3
            public void focusLost(FocusEvent evt) {
                JIFPrestamos.this.JTFNumeroCuotasFocusLost(evt);
            }
        });
        this.JTFNumeroCuotas.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.4
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFNumeroCuotasKeyPressed(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTerceros.setFont(new Font("Arial", 1, 12));
        this.JCBTerceros.setBorder(BorderFactory.createTitledBorder((Border) null, "Terceros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDocumento.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.5
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFDocumentoKeyPressed(evt);
            }
        });
        this.JTFFinanciado.setFont(new Font("Arial", 1, 12));
        this.JTFFinanciado.setHorizontalAlignment(4);
        this.JTFFinanciado.setBorder(BorderFactory.createTitledBorder((Border) null, "Financiado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFinanciado.addFocusListener(new FocusAdapter() { // from class: RecursosHumanos.JIFPrestamos.6
            public void focusLost(FocusEvent evt) {
                JIFPrestamos.this.JTFFinanciadoFocusLost(evt);
            }
        });
        this.JTFFinanciado.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.7
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFFinanciadoKeyPressed(evt);
            }
        });
        this.JTFCuotaTotal.setEditable(false);
        this.JTFCuotaTotal.setFont(new Font("Arial", 1, 12));
        this.JTFCuotaTotal.setHorizontalAlignment(4);
        this.JTFCuotaTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuota Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPorcentajeInteres.setFont(new Font("Arial", 1, 12));
        this.JTFPorcentajeInteres.setHorizontalAlignment(4);
        this.JTFPorcentajeInteres.setBorder(BorderFactory.createTitledBorder((Border) null, "Porcentaje Interes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPorcentajeInteres.addFocusListener(new FocusAdapter() { // from class: RecursosHumanos.JIFPrestamos.8
            public void focusLost(FocusEvent evt) {
                JIFPrestamos.this.JTFPorcentajeInteresFocusLost(evt);
            }
        });
        this.JTFPorcentajeInteres.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.9
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFPorcentajeInteresKeyPressed(evt);
            }
        });
        this.JTFValorCuota.setEditable(false);
        this.JTFValorCuota.setFont(new Font("Arial", 1, 12));
        this.JTFValorCuota.setHorizontalAlignment(4);
        this.JTFValorCuota.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Cuota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValorDescuento.setFont(new Font("Arial", 1, 12));
        this.JTFValorDescuento.setHorizontalAlignment(4);
        this.JTFValorDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValorDescuento.addFocusListener(new FocusAdapter() { // from class: RecursosHumanos.JIFPrestamos.10
            public void focusLost(FocusEvent evt) {
                JIFPrestamos.this.JTFValorDescuentoFocusLost(evt);
            }
        });
        this.JTFValorDescuento.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.11
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFValorDescuentoKeyPressed(evt);
            }
        });
        this.JTFValorInteres.setEditable(false);
        this.JTFValorInteres.setFont(new Font("Arial", 1, 12));
        this.JTFValorInteres.setHorizontalAlignment(4);
        this.JTFValorInteres.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Interes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSaldoNetoPendiente.setEditable(false);
        this.JTFSaldoNetoPendiente.setFont(new Font("Arial", 1, 12));
        this.JTFSaldoNetoPendiente.setHorizontalAlignment(4);
        this.JTFSaldoNetoPendiente.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo Neto Pendiente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSaldoNetoPendiente.setName("xjif_prestamos");
        this.JTFSaldoNetoPendiente.addFocusListener(new FocusAdapter() { // from class: RecursosHumanos.JIFPrestamos.12
            public void focusLost(FocusEvent evt) {
                JIFPrestamos.this.JTFSaldoNetoPendienteFocusLost(evt);
            }
        });
        this.JTFSaldoNetoPendiente.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.13
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTFSaldoNetoPendienteKeyPressed(evt);
            }
        });
        this.JBBuscar.setFont(new Font("Arial", 1, 12));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFPrestamos.14
            public void actionPerformed(ActionEvent evt) {
                JIFPrestamos.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Observ.setFont(new Font("Arial", 1, 12));
        this.JTP_Observ.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFPrestamos.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPrestamos.this.JTP_ObservPropertyChange(evt);
            }
        });
        this.JTP_Observ.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFPrestamos.16
            public void keyPressed(KeyEvent evt) {
                JIFPrestamos.this.JTP_ObservKeyPressed(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTP_Observ);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 171, -2).addGap(18, 18, 18).addComponent(this.JTFDocumento, -1, 167, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFValorCuota, -1, 170, 32767).addComponent(this.JTFFinanciado)).addGap(28, 28, 28).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFValorDescuento, -1, 158, 32767).addComponent(this.JTFNumeroCuotas)))).addGap(42, 42, 42).addComponent(this.JTFNombre, -2, 272, -2).addGap(18, 18, 18).addComponent(this.JBBuscar, -2, 51, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBConcepto, -2, 342, -2).addGap(32, 32, 32).addComponent(this.JCBTerceros, -2, 368, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(374, 374, 374).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCuotaTotal, -1, 151, 32767).addComponent(this.JTFValorInteres))).addComponent(this.jScrollPane4)).addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaInicio, -1, 179, 32767).addComponent(this.JTFPorcentajeInteres, -1, 179, 32767).addComponent(this.JTFSaldoNetoPendiente)))).addContainerGap(23, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFecha, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDocumento, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JBBuscar, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConcepto, -2, 50, -2).addComponent(this.JCBTerceros, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFinanciado, -2, 50, -2).addComponent(this.JTFNumeroCuotas, -2, 50, -2).addComponent(this.JTFCuotaTotal, -2, 50, -2).addComponent(this.JTFPorcentajeInteres, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFValorCuota, -2, 50, -2).addComponent(this.JTFValorDescuento, -2, 50, -2).addComponent(this.JTFValorInteres, -2, 50, -2).addComponent(this.JTFSaldoNetoPendiente, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaInicio, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jScrollPane4, -2, 51, -2))).addContainerGap(25, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 771, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 191, 32767));
        this.JLCodigo.setFont(new Font("Arial", 1, 14));
        this.JLCodigo.setForeground(Color.red);
        this.JLCodigo.setText("CODIGO: ");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLCodigo).addGap(95, 95, 95)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap())));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLCodigo, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(201, 201, 201)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(0, 381, 32767).addComponent(this.jPanel2, -2, -1, -2))));
        this.JTMenu.addTab("REGISTRO", this.jPanel3);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFPrestamos.17
            public void mouseClicked(MouseEvent evt) {
                JIFPrestamos.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTHistorico);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 777, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 597, 32767));
        this.JTMenu.addTab("HISTÓRICO", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTMenu, -2, -1, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTMenu, -2, 643, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFDocumento.getText().isEmpty()) {
                this.empleadosNomina = buscarXdocumento(this.JTFDocumento.getText());
                this.personaDTO = this.empleadosNomina.getIdPersona();
                if (this.empleadosNomina != null) {
                    this.empleadosNominaHistorico = this.empleadosNomina;
                    this.rhFinanciacionHistoricoList = this.rhFinanciacionService.buscarHistoricoPrestamo(this.empleadosNominaHistorico);
                    cargarDatosHistorico();
                }
                fillTextFieldWithPersona();
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo N# Documento esta vacio", "Alert", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        System.out.println("boton observacion : " + this.JTP_Observ.getText());
        this.modelPrestamosBuscador = new JIDPrestamos_Buscador((Frame) null, true, this);
        this.modelPrestamosBuscador.setLocationRelativeTo(this);
        this.modelPrestamosBuscador.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFinanciadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFFinanciado.getText().isEmpty()) {
            this.JTFFinanciado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFinanciadoFocusLost(FocusEvent evt) {
        calcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNumeroCuotasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFNumeroCuotas.getText().isEmpty() && !this.JTFFinanciado.getText().isEmpty()) {
            this.JTFNumeroCuotas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNumeroCuotasFocusLost(FocusEvent evt) {
        calcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPorcentajeInteresKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && Integer.parseInt(this.JTFPorcentajeInteres.getText()) <= 100 && Integer.parseInt(this.JTFPorcentajeInteres.getText()) > 0) {
            this.JTFPorcentajeInteres.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPorcentajeInteresFocusLost(FocusEvent evt) {
        calcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFValorDescuento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorDescuentoFocusLost(FocusEvent evt) {
        calcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSaldoNetoPendienteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFSaldoNetoPendiente.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSaldoNetoPendienteFocusLost(FocusEvent evt) {
        calcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        this.JTDetalle.getModel();
        int selectedRowIndex = this.JTHistorico.getSelectedRow();
        filldWithRhFinanciacion(this.rhFinanciacionHistoricoList.get(selectedRowIndex));
        fillTextFieldWithPersona(this.empleadosNominaHistorico);
        this.JTMenu.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTP_Observ.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservPropertyChange(PropertyChangeEvent evt) {
        System.out.println("" + evt.getOldValue());
        System.out.println("" + evt.getNewValue());
    }
}
