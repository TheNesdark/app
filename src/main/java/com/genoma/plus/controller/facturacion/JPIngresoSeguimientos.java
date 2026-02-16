package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos;
import com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO;
import com.genoma.plus.dao.impl.facturacion.IngresoSeguimientosDAOImpl;
import com.genoma.plus.dto.facturacion.IngresoSeguimientoDetalleDTO;
import com.genoma.plus.dto.facturacion.IngresoSeguimientosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
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
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPIngresoSeguimientos.class */
public class JPIngresoSeguimientos extends JPanel {
    private int xForma;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private IngresoSeguimientosDAO xIngresoSeguimientosDAO;
    private Object[] xDato;
    private long xId_Ingreso;
    private long xidSeguimiento;
    private String[] xidTipoSeguimiento;
    private File xfile;
    private File directorio;
    private JButton JBT_OBuscarUsuario;
    private JComboBox JCBTipoSeguimiento;
    private JCheckBox JCHEstadoDetalle;
    private JCheckBox JCHGAlerta;
    private JCheckBox JCHUSeguimiento;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaIDetalle;
    private JPanel JPDatos;
    private JPanel JPDatos1;
    private JPanel JPDetalleSeguimiento;
    private JScrollPane JSDetalle;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacionDetalle;
    private JScrollPane JSPSeguimientos;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    public JTextField JTF_OCargo;
    public JTextField JTF_ONombre;
    private JTabbedPane JTPOpciones;
    private JTable JTSeguimientos;
    private int xAlerta = 1;
    private int xguardar = 0;
    private int xguardardetalle = 0;
    private int xEstadoDetalle = 0;
    private int xUSeguimiento = 0;
    private Metodos xmetodo = new Metodos();
    public long xIdPersonaResponsable = 0;

    public JPIngresoSeguimientos(Long xId_Ingreso, int xForma) {
        initComponents();
        this.xId_Ingreso = xId_Ingreso.longValue();
        this.xForma = xForma;
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xIngresoSeguimientosDAO = (IngresoSeguimientosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ingresoSeguimientosDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmetodo.getFechaActual());
        this.JCBTipoSeguimiento.removeAllItems();
        List<GCGenericoDTO> list1 = this.xIngresoSeguimientosDAO.mTipoSeguimiento();
        this.xidTipoSeguimiento = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTipoSeguimiento[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoSeguimiento.addItem(list1.get(x).getNombre());
        }
        this.JCBTipoSeguimiento.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTF_OCargo.setText("");
        this.JTF_ONombre.setText("");
        this.JCHGAlerta.setSelected(false);
        this.xAlerta = 0;
        this.xguardar = 0;
        this.xIdPersonaResponsable = 0L;
        mNuevoDetalle();
        mBuscaDatos();
    }

    private void mNuevoDetalle() {
        this.directorio = new File(this.xmetodo.mRutaSoporte("JPIngresoSeguimientos"));
        this.JDFechaIDetalle.setDate(this.xmetodo.getFechaActual());
        this.JTAObservacionDetalle.setText("");
        this.JTFRuta.setText("");
        this.JCHUSeguimiento.setSelected(false);
        this.xUSeguimiento = 0;
        this.JCHEstadoDetalle.setSelected(true);
        this.xEstadoDetalle = 1;
        this.xguardardetalle = 0;
        if (this.JTDetalle.getSelectedRow() != -1) {
            mBuscaDatosDetalle();
        } else {
            mModeloDetalle();
        }
    }

    public void mGuardar() {
        if (this.JTPOpciones.getSelectedIndex() == 0) {
            mGuardarEncabezado();
        } else {
            mGuardarDetalle();
        }
    }

    public void mGuardarEncabezado() {
        if (this.JCBTipoSeguimiento.getSelectedIndex() != -1) {
            if (!this.JTAObservacion.getText().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xguardar == 0) {
                        IngresoSeguimientosDTO e = new IngresoSeguimientosDTO();
                        e.setIdIngreso(this.xId_Ingreso);
                        e.setFecha(this.xmetodo.formatoAMD1.format(this.JDFechaI.getDate()));
                        e.setObservacion(this.JTAObservacion.getText());
                        e.setEstado(1);
                        e.setForma(this.xForma);
                        e.setGAlerta(this.xAlerta);
                        e.setIdUsuarioResponsable(Long.valueOf(this.xIdPersonaResponsable));
                        e.setIdTipoSegumiento(this.xidTipoSeguimiento[this.JCBTipoSeguimiento.getSelectedIndex()]);
                        this.xIngresoSeguimientosDAO.mcreate(e);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar una Observacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTAObservacion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe un Tipo de Seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTAObservacion.requestFocus();
    }

    public void mGuardarDetalle() {
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
            if (!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue()) {
                if (Objects.equals(Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()))) {
                    if (this.JTDetalle.getSelectedRow() != -1) {
                        if (!this.JTAObservacionDetalle.getText().isEmpty()) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                IngresoSeguimientoDetalleDTO e = new IngresoSeguimientoDetalleDTO();
                                if (this.xguardardetalle == 0) {
                                    this.directorio = new File(this.xmetodo.mRutaSoporte("JPIngresoSeguimientos"));
                                    e.setIdIngresoSeguimiento(this.xidSeguimiento);
                                    e.setFecha(this.xmetodo.formatoAMD1.format(this.JDFechaIDetalle.getDate()));
                                    e.setObservacion(this.JTAObservacionDetalle.getText());
                                    e.setUSeguimiento(this.xUSeguimiento);
                                    e.setEstado(this.xEstadoDetalle);
                                    String xidDoc = this.xIngresoSeguimientosDAO.create_return_id_Detalle(e);
                                    if (!this.JTFRuta.getText().isEmpty()) {
                                        String adjunto = xidDoc + "_" + this.xidSeguimiento + "_" + this.xId_Ingreso + ".pdf";
                                        e.setUrlEvidencia(this.xmetodo.mTraerUrlBD(adjunto));
                                        e.setId(Integer.valueOf(xidDoc).intValue());
                                        this.xIngresoSeguimientosDAO.mUpdateURLDetalle(e);
                                        File f1 = new File(this.JTFRuta.getText());
                                        File f2 = new File(adjunto);
                                        f1.renameTo(f2);
                                        f2.renameTo(new File(this.directorio, f2.getName()));
                                    }
                                } else {
                                    e.setFecha(this.xmetodo.formatoAMD1.format(this.JDFechaIDetalle.getDate()));
                                    e.setObservacion(this.JTAObservacionDetalle.getText());
                                    e.setUSeguimiento(this.xUSeguimiento);
                                    e.setEstado(this.xEstadoDetalle);
                                    e.setId(Long.valueOf(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 0).toString()).longValue());
                                    this.xIngresoSeguimientosDAO.mUpdateDetalle(e);
                                }
                                mNuevoDetalle();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe digitar una observacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JTAObservacionDetalle.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar un registro de seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Usted no es el responsable de hacerle segumiento a este registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este Seguimiento ya se encuentra Cerrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este Seguimiento se encuentra Anulado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnular() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (!this.xmetodo.mVerificarDatosTablaTrue(this.JTSeguimientos, 5)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "xjpIngresoSeguimientos", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este seguimiento tiene evidencias activas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro de seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnular_Seguimiento(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        IngresoSeguimientosDTO e = new IngresoSeguimientosDTO();
        e.setIdMotivoAnulacion(Long.valueOf(idMotivoAnulacion));
        e.setMotivoAnulacion(xMotivo);
        e.setObservacionAnulacion(xObservacion);
        e.setFechaAnulacion(this.xmetodo.formatoAMD1.format(this.xmetodo.getFechaActual()));
        e.setUsuarioRHAnulacion(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        e.setEstado(0);
        e.setId(this.xidSeguimiento);
        this.xIngresoSeguimientosDAO.mDelete(e);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observacion", "Estado", "Alerta", "Tipo de Seguimiento", "Factura?", "Cerrado?", "Responsable", "Cargo", "Cargo"}) { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Boolean.class, Boolean.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    private void mBuscaDatos() {
        mModelo();
        List<IngresoSeguimientosDTO> list = this.xIngresoSeguimientosDAO.mListar(Long.valueOf(this.xId_Ingreso));
        this.xmetodo.mEstablecerTextEditor(this.JTDetalle, 2);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            if (list.get(x).getGAlerta() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            this.xmodelo.setValueAt(list.get(x).getIdTipoSegumiento(), x, 5);
            if (list.get(x).getPCierreFactura() == 1) {
                this.xmodelo.setValueAt(true, x, 6);
            } else {
                this.xmodelo.setValueAt(false, x, 6);
            }
            if (list.get(x).getCerrado() == 1) {
                this.xmodelo.setValueAt(true, x, 7);
            } else {
                this.xmodelo.setValueAt(false, x, 7);
            }
            this.xmodelo.setValueAt(list.get(x).getPersonaResponsable(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getCargoResponsable(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getIdUsuarioResponsable(), x, 10);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observacion", "Evidencia", "Ultimo Seguimiento?", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.2
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSeguimientos.setModel(this.xmodelo1);
        this.JTSeguimientos.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTSeguimientos.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTSeguimientos.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTSeguimientos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTSeguimientos.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTSeguimientos.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mBuscaDatosDetalle() {
        mModeloDetalle();
        List<IngresoSeguimientoDetalleDTO> list = this.xIngresoSeguimientosDAO.mListarDetalle(Long.valueOf(this.xidSeguimiento));
        this.xmetodo.mEstablecerTextEditor(this.JTSeguimientos, 2);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo1.addRow(this.xDato);
            this.xmodelo1.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo1.setValueAt(list.get(x).getFecha(), x, 1);
            this.xmodelo1.setValueAt(list.get(x).getObservacion(), x, 2);
            this.xmodelo1.setValueAt(list.get(x).getUrlEvidencia(), x, 3);
            if (list.get(x).getUSeguimiento() == 1) {
                this.xmodelo1.setValueAt(true, x, 4);
            } else {
                this.xmodelo1.setValueAt(false, x, 4);
            }
            if (list.get(x).getEstado() == 1) {
                this.xmodelo1.setValueAt(true, x, 5);
            } else {
                this.xmodelo1.setValueAt(false, x, 5);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPIngresoSeguimientos$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 4).toString());
            if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCHGAlerta = new JCheckBox();
        this.JCBTipoSeguimiento = new JComboBox();
        this.JTF_OCargo = new JTextField();
        this.JTF_ONombre = new JTextField();
        this.JBT_OBuscarUsuario = new JButton();
        this.JTPOpciones = new JTabbedPane();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPDetalleSeguimiento = new JPanel();
        this.JSPSeguimientos = new JScrollPane();
        this.JTSeguimientos = new JTable();
        this.JPDatos1 = new JPanel();
        this.JDFechaIDetalle = new JDateChooser();
        this.JSPObservacionDetalle = new JScrollPane();
        this.JTAObservacionDetalle = new JTextArea();
        this.JCHEstadoDetalle = new JCheckBox();
        this.JCHUSeguimiento = new JCheckBox();
        this.JTFRuta = new JTextField();
        setName("xjpingresoseguimientos");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCHGAlerta.setFont(new Font("Arial", 1, 12));
        this.JCHGAlerta.setText("Generar Alerta?");
        this.JCHGAlerta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.3
            public void actionPerformed(ActionEvent evt) {
                JPIngresoSeguimientos.this.JCHGAlertaActionPerformed(evt);
            }
        });
        this.JCBTipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoSeguimiento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.4
            public void itemStateChanged(ItemEvent evt) {
                JPIngresoSeguimientos.this.JCBTipoSeguimientoItemStateChanged(evt);
            }
        });
        this.JTF_OCargo.setFont(new Font("Arial", 1, 12));
        this.JTF_OCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONombre.setFont(new Font("Arial", 1, 12));
        this.JTF_ONombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_OBuscarUsuario.setFont(new Font("Arial", 1, 14));
        this.JBT_OBuscarUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBT_OBuscarUsuario.setText("...");
        this.JBT_OBuscarUsuario.setToolTipText("Buscar usuarios en recurso humano");
        this.JBT_OBuscarUsuario.setIconTextGap(3);
        this.JBT_OBuscarUsuario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.5
            public void actionPerformed(ActionEvent evt) {
                JPIngresoSeguimientos.this.JBT_OBuscarUsuarioActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoSeguimiento, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHGAlerta)).addComponent(this.JSPObservacion).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTF_OCargo, -2, 229, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_ONombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_OBuscarUsuario, -2, 38, -2))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHGAlerta).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JCBTipoSeguimiento, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JSPObservacion, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_OCargo, -2, 50, -2).addComponent(this.JTF_ONombre, -2, 50, -2).addComponent(this.JBT_OBuscarUsuario, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.6
            public void mouseClicked(MouseEvent evt) {
                JPIngresoSeguimientos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JTPOpciones.addTab("SEGUIMIENTOS", this.JSDetalle);
        this.JSPSeguimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTSeguimientos.setFont(new Font("Arial", 1, 12));
        this.JTSeguimientos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTSeguimientos.setSelectionBackground(Color.white);
        this.JTSeguimientos.setSelectionForeground(Color.red);
        this.JTSeguimientos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.7
            public void mouseClicked(MouseEvent evt) {
                JPIngresoSeguimientos.this.JTSeguimientosMouseClicked(evt);
            }
        });
        this.JSPSeguimientos.setViewportView(this.JTSeguimientos);
        this.JPDatos1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaIDetalle.setDateFormatString("dd/MM/yyyy");
        this.JDFechaIDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionDetalle.setColumns(20);
        this.JTAObservacionDetalle.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionDetalle.setRows(5);
        this.JSPObservacionDetalle.setViewportView(this.JTAObservacionDetalle);
        this.JCHEstadoDetalle.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoDetalle.setText("Estado");
        this.JCHEstadoDetalle.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.8
            public void actionPerformed(ActionEvent evt) {
                JPIngresoSeguimientos.this.JCHEstadoDetalleActionPerformed(evt);
            }
        });
        this.JCHUSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHUSeguimiento.setText("Ultimo Seguimiento?");
        this.JCHUSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.9
            public void actionPerformed(ActionEvent evt) {
                JPIngresoSeguimientos.this.JCHUSeguimientoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPIngresoSeguimientos.10
            public void mouseClicked(MouseEvent evt) {
                JPIngresoSeguimientos.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPDatos1Layout = new GroupLayout(this.JPDatos1);
        this.JPDatos1.setLayout(JPDatos1Layout);
        JPDatos1Layout.setHorizontalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addContainerGap().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JDFechaIDetalle, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacionDetalle, -1, 428, 32767).addContainerGap()).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstadoDetalle).addComponent(this.JCHUSeguimiento))))));
        JPDatos1Layout.setVerticalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacionDetalle, -2, 50, -2).addComponent(this.JDFechaIDetalle, -2, 56, -2)).addGap(10, 10, 10).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JCHEstadoDetalle).addGap(3, 3, 3).addComponent(this.JCHUSeguimiento)).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        GroupLayout JPDetalleSeguimientoLayout = new GroupLayout(this.JPDetalleSeguimiento);
        this.JPDetalleSeguimiento.setLayout(JPDetalleSeguimientoLayout);
        JPDetalleSeguimientoLayout.setHorizontalGroup(JPDetalleSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleSeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPDetalleSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos1, -1, -1, 32767).addComponent(this.JSPSeguimientos, GroupLayout.Alignment.TRAILING, -1, 607, 32767)).addContainerGap()));
        JPDetalleSeguimientoLayout.setVerticalGroup(JPDetalleSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleSeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPSeguimientos, -2, 118, -2).addGap(110, 110, 110)));
        this.JTPOpciones.addTab("DETALLE", this.JPDetalleSeguimiento);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JTPOpciones)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPOpciones, -2, 274, -2).addContainerGap()));
        this.JTPOpciones.getAccessibleContext().setAccessibleName("JTPOpciones");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xForma == 0) {
                this.xidSeguimiento = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).longValue();
                mBuscaDatosDetalle();
                this.JTPOpciones.setSelectedIndex(1);
                return;
            }
            System.out.println("id usuario  :" + Principal.usuarioSistemaDTO.getIdPersonaCargo());
            System.out.println("id seleccion : " + Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()));
            if (Principal.usuarioSistemaDTO.getIdPersonaCargo() == Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString())) {
                this.xidSeguimiento = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).longValue();
                mBuscaDatosDetalle();
                mNuevoDetalle();
                this.JTPOpciones.setSelectedIndex(1);
                return;
            }
            mBuscaDatosDetalle();
            mNuevoDetalle();
            JOptionPane.showInternalMessageDialog(this, "Usted no es el responsable de hacerle segumiento a este registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGAlertaActionPerformed(ActionEvent evt) {
        if (this.JCHGAlerta.isSelected()) {
            this.xAlerta = 1;
        } else {
            this.xAlerta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoSeguimientoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoDetalleActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoDetalle.isSelected()) {
            this.xEstadoDetalle = 1;
        } else {
            this.xEstadoDetalle = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JCHUSeguimiento.isSelected()) {
            this.xUSeguimiento = 1;
        } else {
            this.xUSeguimiento = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSeguimientosMouseClicked(MouseEvent evt) {
        if (this.JTSeguimientos.getSelectedRow() != -1) {
            this.JDFechaIDetalle.setDate(Date.valueOf(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 1).toString()));
            this.JTAObservacionDetalle.setText(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 2).toString());
            this.JTFRuta.setText(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 3).toString());
            if (Boolean.parseBoolean(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 4).toString())) {
                this.xUSeguimiento = 1;
                this.JCHUSeguimiento.setSelected(true);
            } else {
                this.xUSeguimiento = 0;
                this.JCHUSeguimiento.setSelected(false);
            }
            if (Boolean.parseBoolean(this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 5).toString())) {
                this.xEstadoDetalle = 1;
                this.JCHEstadoDetalle.setSelected(true);
            } else {
                this.xEstadoDetalle = 0;
                this.JCHEstadoDetalle.setSelected(false);
            }
            this.xguardardetalle = 1;
            if (evt.getClickCount() == 2) {
                this.xmetodo.mostrarPdf(this.directorio + "\\" + this.xmodelo1.getValueAt(this.JTSeguimientos.getSelectedRow(), 3).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OBuscarUsuarioActionPerformed(ActionEvent evt) {
        JD_ConsultarUsuariosCargos xJDConsultar = new JD_ConsultarUsuariosCargos(null, true, "xJifSEguimiento", Principal.clasefacturacion.xjiliqServicio);
        xJDConsultar.setVisible(true);
        xJDConsultar.setLocationRelativeTo(this);
    }
}
