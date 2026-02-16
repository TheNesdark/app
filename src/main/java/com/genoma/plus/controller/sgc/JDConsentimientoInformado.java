package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import General.JDBiometrico;
import Historia.ImpresionDocumentosHC;
import Historia.JPOOrdenProcedimientosH;
import Laboratorio.RecepcionAuto;
import Odontologia.JPOdontograma;
import Odontologia.JPOdontogramaClinico;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl;
import com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO;
import com.genoma.plus.dto.sgc.ConsentimientoInformadoDTO;
import com.genoma.plus.dto.sgc.ConsentimientoInfxRiesgoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JDConsentimientoInformado.class */
public class JDConsentimientoInformado extends JDialog {
    private int xAcepta;
    private int xAceptaG;
    private String xidIngreso;
    private String xidProcedimiento;
    private String frmllamador;
    private String[][] xidConsentimiento;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xDato;
    private ConsentimientoInformadoDAO xConsentimientoInformadoDAO;
    private Metodos xmt;
    private boolean xlleno;
    private ConsultasMySQL xconsultas;
    private JPOOrdenProcedimientosH xJPOOrdenProcedimientosH;
    private RecepcionAuto xRecepcionAuto;
    private JPOdontograma xJPOdontograma;
    private JPOdontogramaClinico xJPOdontogramaClinico;
    private String idEspecialidad;
    private String idProfesional;
    private JButton JBTHuella;
    public JButton JBT_Grabar;
    public JButton JBT_Grabar1;
    public JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JComboBox<String> JCBConsentimiento;
    private JCheckBox JCHAcepta;
    private JLabel JLNConsentimiento;
    private JPanel JPAnotaciones;
    private JPanel JPDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPEncabezado;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPNota;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPPiePagina;
    private JTextArea JTAEncabezado;
    private JTextArea JTANota;
    private JTextArea JTAObservacion;
    private JTextArea JTAPiePagina;
    private JTable JTDetalle;
    private JTable JTHistorico;
    private JTabbedPane JTPGeneral;
    private JTabbedPane JTPMenu2;

    public JDConsentimientoInformado(Frame parent, boolean modal, String xidIngreso, String xidProcedimiento, Object frm, String idEspecialidad, String idProfesional) {
        super(parent, modal);
        this.xAcepta = 1;
        this.xAceptaG = 0;
        this.xmt = new Metodos();
        this.xlleno = false;
        this.xconsultas = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("CONSENTIMIENTOS INFORMADOS");
        this.JBT_Grabar1.setEnabled(false);
        this.xidIngreso = xidIngreso;
        this.xidProcedimiento = xidProcedimiento;
        realizarcasting(frm);
        springStart();
        mNuevo();
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            this.JTANota.setEnabled(false);
        }
    }

    private void springStart() {
        this.xConsentimientoInformadoDAO = (ConsentimientoInformadoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consentimientoInformadoDAO");
    }

    private void mLLenaCombo() {
        this.xlleno = false;
        this.JCBConsentimiento.removeAllItems();
        String xsql = "SELECT\n    `h_tipoconsentimiento`.`Id`\n    , IFNULL(`h_tipoconsentimiento`.`Nbre`,'') Nbre\n    , IFNULL(`h_tipoconsentimiento`.`Encabezado`,'') Encabezado\n    , IFNULL(`h_tipoconsentimiento`.`Nota1`,'') Nota1\n    , IFNULL(`h_tipoconsentimiento`.`PiePagina`,'') PiePagina\nFROM\n    `g_procedimientoxconsentimiento`\n    INNER JOIN `h_tipoconsentimiento` \n        ON (`g_procedimientoxconsentimiento`.`Id_TipoConsentimiento` = `h_tipoconsentimiento`.`Id`)\nWHERE (`g_procedimientoxconsentimiento`.`Estado` =1\n    AND `g_procedimientoxconsentimiento`.`Id_Procedimiento` ='" + this.xidProcedimiento + "')\nORDER BY `h_tipoconsentimiento`.`Nbre` ASC;";
        System.out.println("" + xsql);
        this.xidConsentimiento = this.xconsultas.llenarComboyLista(xsql, this.xidConsentimiento, this.JCBConsentimiento, 5);
        this.JCBConsentimiento.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.xlleno = true;
    }

    public void mNuevo() {
        mLLenaCombo();
        this.JTAEncabezado.setText("");
        this.JTANota.setText("");
        this.JTAPiePagina.setText("");
        this.JTAObservacion.setText("");
        this.JCHAcepta.setSelected(true);
        this.xAcepta = 1;
        this.JLNConsentimiento.setText("0");
        mCargarDatosTablaHistorico();
        if (this.xlleno && this.JCBConsentimiento.getSelectedIndex() != -1) {
            mCargarDatosTablaDetalle(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][0]);
        }
        llenarDatosFormulario();
    }

    public void mGrabar() {
        if (this.JLNConsentimiento.getText().equals("0")) {
            if (this.JCBConsentimiento.getSelectedIndex() != -1) {
                if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    grabarBase();
                    return;
                } else {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 4)) {
                        grabarBase();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una complicacion de riesgo de la tabla detalle", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTPGeneral.setSelectedIndex(0);
                    this.JTPMenu2.setSelectedIndex(1);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBConsentimiento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Este Consentimiento Informado Ya Se Encuentra Grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void grabarBase() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            ConsentimientoInformadoDTO xObjEncabezado = new ConsentimientoInformadoDTO();
            xObjEncabezado.setIngreso(Long.valueOf(this.xidIngreso));
            xObjEncabezado.setIdTipoConcentimiento(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][0]);
            xObjEncabezado.setEncabezado(this.JTAEncabezado.getText());
            xObjEncabezado.setNota(this.JTANota.getText());
            xObjEncabezado.setPiePagina(this.JTAPiePagina.getText());
            xObjEncabezado.setObservacion(this.JTAObservacion.getText());
            xObjEncabezado.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
            xObjEncabezado.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
            xObjEncabezado.setAcepta(this.xAcepta);
            xObjEncabezado.setIdProcedimiento(this.xidProcedimiento);
            String xidEncabezado = this.xConsentimientoInformadoDAO.create_return_id(xObjEncabezado);
            this.JLNConsentimiento.setText(xidEncabezado);
            ConsentimientoInfxRiesgoDTO xObjConcentimineto = new ConsentimientoInfxRiesgoDTO();
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (!Boolean.valueOf(this.xmodelo1.getValueAt(x, 3).toString()).booleanValue() && Boolean.valueOf(this.xmodelo1.getValueAt(x, 4).toString()).booleanValue()) {
                    xObjConcentimineto.setIdConsentimiento(Long.valueOf(xidEncabezado).longValue());
                    xObjConcentimineto.setIdTipoRiesgoComplicacion(this.xmodelo1.getValueAt(x, 0).toString());
                    xObjConcentimineto.setObservacion(this.xmodelo1.getValueAt(x, 2).toString());
                    this.xConsentimientoInformadoDAO.mCreateConcentimientoxRiesgo(xObjConcentimineto);
                }
            }
            mCargarDatosTablaHistorico();
            mCargarDatosTablaDetalle(xidEncabezado);
            mEnviarIdConsecutivo();
            this.JBT_NUevo.setEnabled(false);
            this.JBT_Grabar.setEnabled(false);
            this.JBT_Grabar1.setEnabled(true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdIngreso", "Tipo Consentimiento", "Encabezado", "Nota", "Pie de Pagina", "Observacion", "Especialidad", "Profesional", "Acepta?"}) { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
    }

    private void mCargarDatosTablaHistorico() {
        mCrearModeloTablaHistorico();
        List<ConsentimientoInformadoDTO> list = this.xConsentimientoInformadoDAO.listConcentimientoInf(this.xidIngreso);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 3);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 4);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 5);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 6);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIngreso(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdTipoConcentimiento(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getEncabezado(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getNota(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getPiePagina(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getIdEspecialidad(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getIdProfesional(), x, 8);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 9);
            } else {
                this.xmodelo.setValueAt(false, x, 9);
            }
        }
    }

    private void llenarDatosFormulario() {
        if (this.JCBConsentimiento.getSelectedIndex() != -1 && this.xlleno) {
            this.JTAEncabezado.setText(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][1]);
            this.JTANota.setText(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][2]);
            this.JTAPiePagina.setText(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][3]);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Complicacion de Riesgo", "Observacion", "Grabada", "Seleccionar", "Tipo"}) { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.2
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCargarDatosTablaDetalle(String xidConsentimiento) {
        mCrearModeloTablaDetalle();
        List<ConsentimientoInfxRiesgoDTO> list = this.xConsentimientoInformadoDAO.listConsentimientoDetalle(this.JLNConsentimiento.getText(), this.xidProcedimiento);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo1.addRow(this.xDato);
            this.xmodelo1.setValueAt(Long.valueOf(list.get(x).getIdConsentimiento()), x, 0);
            this.xmodelo1.setValueAt(list.get(x).getIdTipoRiesgoComplicacion(), x, 1);
            this.xmodelo1.setValueAt(list.get(x).getObservacion(), x, 2);
            this.xmodelo1.setValueAt(list.get(x).getTipo(), x, 5);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo1.setValueAt(true, x, 3);
                this.xmodelo1.setValueAt(true, x, 4);
            } else {
                this.xmodelo1.setValueAt(false, x, 3);
                this.xmodelo1.setValueAt(false, x, 4);
            }
        }
    }

    private void realizarcasting(Object frm) {
        switch (frm.getClass().getSimpleName()) {
            case "JPOOrdenProcedimientosH":
                this.xJPOOrdenProcedimientosH = (JPOOrdenProcedimientosH) frm;
                this.frmllamador = "JPOOrdenProcedimientosH";
                break;
            case "RecepcionAuto":
                this.xRecepcionAuto = (RecepcionAuto) frm;
                this.frmllamador = "RecepcionAuto";
                break;
            case "JPOdontograma":
                this.xJPOdontograma = (JPOdontograma) frm;
                this.frmllamador = "JPOdontograma";
                break;
            case "xJPOdontogramaClinico":
                this.xJPOdontogramaClinico = (JPOdontogramaClinico) frm;
                this.frmllamador = "JPOdontogramaClinico";
                break;
        }
    }

    private void mEnviarIdConsecutivo() {
        if (this.frmllamador.equals("JPOOrdenProcedimientosH")) {
            this.xJPOOrdenProcedimientosH.xmodelodetallet.setValueAt(Long.valueOf(this.JLNConsentimiento.getText()), this.xJPOOrdenProcedimientosH.JTDatosDetProcedimiento.getSelectedRow(), 16);
        } else if (this.frmllamador.equals("RecepcionAuto")) {
            this.xRecepcionAuto.modelo.setValueAt(Long.valueOf(this.JLNConsentimiento.getText()), this.xRecepcionAuto.grid.getSelectedRow(), 10);
        }
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPGeneral = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JBTHuella = new JButton();
        this.JCHAcepta = new JCheckBox();
        this.JCBConsentimiento = new JComboBox<>();
        this.JTPMenu2 = new JTabbedPane();
        this.JPAnotaciones = new JPanel();
        this.JSPEncabezado = new JScrollPane();
        this.JTAEncabezado = new JTextArea();
        this.JSPPiePagina = new JScrollPane();
        this.JTAPiePagina = new JTextArea();
        this.JSPNota = new JScrollPane();
        this.JTANota = new JTextArea();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JLNConsentimiento = new JLabel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JBT_Grabar1 = new JButton();
        setDefaultCloseOperation(2);
        this.JTPGeneral.setForeground(Color.red);
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.3
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.JCHAcepta.setFont(new Font("Arial", 1, 12));
        this.JCHAcepta.setText("Acepta?");
        this.JCHAcepta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.4
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JCHAceptaActionPerformed(evt);
            }
        });
        this.JCBConsentimiento.setFont(new Font("Arial", 1, 12));
        this.JCBConsentimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Consentimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConsentimiento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.5
            public void itemStateChanged(ItemEvent evt) {
                JDConsentimientoInformado.this.JCBConsentimientoItemStateChanged(evt);
            }
        });
        this.JTPMenu2.setForeground(new Color(0, 103, 0));
        this.JTPMenu2.setFont(new Font("Arial", 1, 14));
        this.JSPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAEncabezado.setColumns(20);
        this.JTAEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTAEncabezado.setLineWrap(true);
        this.JTAEncabezado.setRows(1);
        this.JTAEncabezado.setTabSize(1);
        this.JTAEncabezado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.6
            public void keyPressed(KeyEvent evt) {
                JDConsentimientoInformado.this.JTAEncabezadoKeyPressed(evt);
            }
        });
        this.JSPEncabezado.setViewportView(this.JTAEncabezado);
        this.JSPPiePagina.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Pagina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAPiePagina.setColumns(20);
        this.JTAPiePagina.setFont(new Font("Arial", 1, 12));
        this.JTAPiePagina.setLineWrap(true);
        this.JTAPiePagina.setRows(1);
        this.JTAPiePagina.setTabSize(1);
        this.JTAPiePagina.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.7
            public void keyPressed(KeyEvent evt) {
                JDConsentimientoInformado.this.JTAPiePaginaKeyPressed(evt);
            }
        });
        this.JSPPiePagina.setViewportView(this.JTAPiePagina);
        this.JSPNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTANota.setColumns(20);
        this.JTANota.setFont(new Font("Arial", 1, 12));
        this.JTANota.setLineWrap(true);
        this.JTANota.setRows(1);
        this.JTANota.setTabSize(1);
        this.JTANota.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.8
            public void keyPressed(KeyEvent evt) {
                JDConsentimientoInformado.this.JTANotaKeyPressed(evt);
            }
        });
        this.JSPNota.setViewportView(this.JTANota);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setWrapStyleWord(true);
        this.JTAObservacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.9
            public void keyPressed(KeyEvent evt) {
                JDConsentimientoInformado.this.JTAObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPAnotacionesLayout = new GroupLayout(this.JPAnotaciones);
        this.JPAnotaciones.setLayout(JPAnotacionesLayout);
        JPAnotacionesLayout.setHorizontalGroup(JPAnotacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAnotacionesLayout.createSequentialGroup().addContainerGap().addGroup(JPAnotacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -1, 649, 32767).addComponent(this.JSPEncabezado).addComponent(this.JSPNota).addComponent(this.JSPPiePagina, GroupLayout.Alignment.TRAILING)).addGap(10, 10, 10)));
        JPAnotacionesLayout.setVerticalGroup(JPAnotacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAnotacionesLayout.createSequentialGroup().addComponent(this.JSPEncabezado, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNota, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPiePagina, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 89, -2).addGap(0, 0, 32767)));
        this.JTPMenu2.addTab("ANOTACIONES", this.JPAnotaciones);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPMenu2.addTab("DETALLE", this.JSPDetalle);
        this.JLNConsentimiento.setFont(new Font("Arial", 1, 12));
        this.JLNConsentimiento.setForeground(Color.blue);
        this.JLNConsentimiento.setHorizontalAlignment(0);
        this.JLNConsentimiento.setText("0");
        this.JLNConsentimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPMenu2, -1, 672, 32767).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBConsentimiento, -2, 413, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAcepta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLNConsentimiento, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHuella, -2, 50, -2))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConsentimiento, -2, 50, -2).addComponent(this.JCHAcepta).addComponent(this.JLNConsentimiento, -1, 50, 32767)).addComponent(this.JBTHuella, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addComponent(this.JTPMenu2, -2, 419, -2).addGap(10, 10, 10)));
        this.JTPGeneral.addTab("INFORMACION", this.JPDatos);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.10
            public void mouseClicked(MouseEvent evt) {
                JDConsentimientoInformado.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTPGeneral.addTab("HISTORICO", this.JSPHistorico);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.11
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.12
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.13
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JBT_Grabar1.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBT_Grabar1.setText("Imprimir");
        this.JBT_Grabar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDConsentimientoInformado.14
            public void actionPerformed(ActionEvent evt) {
                JDConsentimientoInformado.this.JBT_Grabar1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPGeneral, -2, 705, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir1, -2, 170, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPGeneral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2).addComponent(this.JBT_Grabar1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAPiePaginaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAceptaActionPerformed(ActionEvent evt) {
        if (this.JCHAcepta.isSelected()) {
            this.xAcepta = 1;
        } else {
            this.xAcepta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAEncabezadoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTANotaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        if (!this.JLNConsentimiento.getText().equals("0")) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "xjdconcentimientoinformado", this.JLNConsentimiento.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un registro del Historico", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JLNConsentimiento.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBConsentimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JTAEncabezado.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JTANota.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            this.JTAPiePagina.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString());
            if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString())) {
                this.xAcepta = 1;
                this.JCHAcepta.setSelected(true);
                this.JBT_Grabar1.setEnabled(true);
            } else {
                this.xAcepta = 0;
                this.JCHAcepta.setSelected(false);
                this.JBT_Grabar1.setEnabled(true);
            }
            this.xAceptaG = 1;
            mCargarDatosTablaDetalle(this.JLNConsentimiento.getText());
            this.JTPGeneral.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConsentimientoItemStateChanged(ItemEvent evt) {
        llenarDatosFormulario();
        if (this.xlleno && this.JCBConsentimiento.getSelectedIndex() != -1) {
            mCargarDatosTablaDetalle(this.xidConsentimiento[this.JCBConsentimiento.getSelectedIndex()][0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Grabar1ActionPerformed(ActionEvent evt) {
        if (!this.JLNConsentimiento.getText().isEmpty()) {
            ImpresionDocumentosHC impresion = new ImpresionDocumentosHC();
            impresion.imprimirConsentimientoInformado(this.JLNConsentimiento.getText());
        }
    }
}
