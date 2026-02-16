package Historia;

import Acceso.Principal;
import Citas.clasesCita;
import ImagenesDx.claseImagenesDx;
import Laboratorio.claseLab;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarAtenciones.class */
public class JIFConsultarAtenciones extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private DefaultTableModel xmodeloatencionesdigitalizadas;
    private DefaultTableModel xmodelojuntasmed;
    private TableColumn column;
    private Object[] dato;
    private ResultSet rs;
    private String[] xidespecialidad;
    private ConsultasMySQL xconsultasbd;
    private Metodos xmetodo;
    private clasesHistoriaCE xclase;
    private clasesCita xclasec;
    private claseLab xclaselab;
    private claseImagenesDx xclaserx;
    private int xid;
    private boolean xlleno;
    private JPGraficasCyDImpresion xJPGraficasCyDImpresion;
    private JPGraficasPrenatalImpresion xJPGraficasPrenatalImpresion;
    private JDialog prueba;
    private JButton JBTCerrar;
    private JComboBox JCBEspecialidad;
    private JCheckBox JCHFitro;
    private JPanel JPIFiltro;
    private JScrollPane JSPAtencionesDigitalizada;
    private JScrollPane JSPDetalleConsulta;
    private JScrollPane JSPJuntasMed;
    private JTable JTBAtencionesDigitalizadaas;
    public JTable JTBDetalle;
    private JTable JTBJuntasMed;
    private JTabbedPane JTPAtenciones;
    private JTabbedPane JTPOtros;

    public JIFConsultarAtenciones(clasesHistoriaCE xclase) {
        this.column = null;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xid = 0;
        this.xlleno = false;
        initComponents();
        this.xclase = xclase;
        this.xmetodo.cargarPanelOdontogramaDientes(this.JPIFiltro);
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
        mBuscarJuntas();
        mRenderPanelGraficasCyD();
        mRederPanelGraficaPrenatal();
    }

    private void mRenderPanelGraficasCyD() {
        this.xJPGraficasCyDImpresion = new JPGraficasCyDImpresion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue());
        this.xJPGraficasCyDImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS CyD", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasCyDImpresion.setVisible(false);
        this.xJPGraficasCyDImpresion.setBounds(-50, 0, 896, 570);
        this.JPIFiltro.add(this.xJPGraficasCyDImpresion);
    }

    private void mGeneraGraficaCyD() {
        this.xJPGraficasCyDImpresion.mGeneraGrafico_ScreenShot();
    }

    private void mRederPanelGraficaPrenatal() {
        this.prueba = new JDialog();
        this.xJPGraficasPrenatalImpresion = new JPGraficasPrenatalImpresion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue());
        this.xJPGraficasPrenatalImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS PRENATAL", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasPrenatalImpresion.setVisible(true);
        this.xJPGraficasPrenatalImpresion.setBounds(-50, 0, 896, 570);
        this.prueba.add(this.xJPGraficasPrenatalImpresion);
        this.prueba.setSize(600, 700);
        this.prueba.setVisible(true);
        this.prueba.dispose();
    }

    private void mGenerarGraficaPrenatal() {
        this.xJPGraficasPrenatalImpresion.GenerarScreeshot();
    }

    public JIFConsultarAtenciones(clasesCita xclase, int xid) {
        this.column = null;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xid = 0;
        this.xlleno = false;
        initComponents();
        this.xclasec = xclase;
        this.xid = 1;
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
    }

    public JIFConsultarAtenciones(claseLab xclaselab, int xid) {
        this.column = null;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xid = 0;
        this.xlleno = false;
        initComponents();
        this.xclaselab = xclaselab;
        this.xid = 2;
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
    }

    public JIFConsultarAtenciones(claseImagenesDx xclaserx, int xid) {
        this.column = null;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xid = 0;
        this.xlleno = false;
        initComponents();
        this.xclaserx = xclaserx;
        this.xid = xid;
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
    }

    private void initComponents() {
        this.JBTCerrar = new JButton();
        this.JTPAtenciones = new JTabbedPane();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPAtencionesDigitalizada = new JScrollPane();
        this.JTBAtencionesDigitalizadaas = new JTable();
        this.JTPOtros = new JTabbedPane();
        this.JSPJuntasMed = new JScrollPane();
        this.JTBJuntasMed = new JTable();
        this.JPIFiltro = new JPanel();
        this.JCHFitro = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        setClosable(true);
        setTitle("HISTÓRICO DE ATENCIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultaratenciones");
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(new Color(0, 0, 153));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarAtenciones.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAtenciones.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JTPAtenciones.setForeground(new Color(0, 102, 0));
        this.JTPAtenciones.setFont(new Font("Arial", 1, 13));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarAtenciones.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAtenciones.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JTPAtenciones.addTab("DIGITAL", this.JSPDetalleConsulta);
        this.JSPAtencionesDigitalizada.setBorder(BorderFactory.createEtchedBorder());
        this.JTBAtencionesDigitalizadaas.setFont(new Font("Arial", 1, 12));
        this.JTBAtencionesDigitalizadaas.setRowHeight(25);
        this.JTBAtencionesDigitalizadaas.setSelectionBackground(new Color(255, 255, 255));
        this.JTBAtencionesDigitalizadaas.setSelectionForeground(new Color(255, 0, 0));
        this.JTBAtencionesDigitalizadaas.setSelectionMode(0);
        this.JTBAtencionesDigitalizadaas.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarAtenciones.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAtenciones.this.JTBAtencionesDigitalizadaasMouseClicked(evt);
            }
        });
        this.JSPAtencionesDigitalizada.setViewportView(this.JTBAtencionesDigitalizadaas);
        this.JTPAtenciones.addTab("MANUALES", this.JSPAtencionesDigitalizada);
        this.JTPOtros.setForeground(new Color(0, 102, 0));
        this.JTPOtros.setFont(new Font("Arial", 1, 14));
        this.JSPJuntasMed.setBorder(BorderFactory.createEtchedBorder());
        this.JTBJuntasMed.setFont(new Font("Arial", 1, 12));
        this.JTBJuntasMed.setRowHeight(25);
        this.JTBJuntasMed.setSelectionBackground(new Color(255, 255, 255));
        this.JTBJuntasMed.setSelectionForeground(new Color(255, 0, 0));
        this.JTBJuntasMed.setSelectionMode(0);
        this.JTBJuntasMed.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarAtenciones.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAtenciones.this.JTBJuntasMedMouseClicked(evt);
            }
        });
        this.JSPJuntasMed.setViewportView(this.JTBJuntasMed);
        this.JTPOtros.addTab("JUNTAS MÉDICAS", this.JSPJuntasMed);
        this.JPIFiltro.setBorder(BorderFactory.createEtchedBorder());
        this.JCHFitro.setFont(new Font("Arial", 1, 12));
        this.JCHFitro.setForeground(Color.blue);
        this.JCHFitro.setText("Filtro por especialdiad");
        this.JCHFitro.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarAtenciones.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAtenciones.this.JCHFitroActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFConsultarAtenciones.6
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarAtenciones.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHFitro).addGap(35, 35, 35).addComponent(this.JCBEspecialidad, -2, 659, -2).addContainerGap(233, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHFitro).addContainerGap(28, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBEspecialidad, -2, -1, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPAtenciones, GroupLayout.Alignment.LEADING, -1, 1101, 32767).addComponent(this.JBTCerrar, GroupLayout.Alignment.LEADING, -1, 1101, 32767).addComponent(this.JTPOtros, GroupLayout.Alignment.LEADING, -1, 1101, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addGap(29, 29, 29).addComponent(this.JTPAtenciones, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPOtros, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar, -2, 42, -2).addContainerGap(47, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            mparametros[4][0] = "OS";
            mparametros[4][1] = System.getProperty("os.name").substring(0, 3);
            if (this.xid == 0) {
                mparametros[1][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
            } else if (this.xid == 1) {
                mparametros[1][1] = String.valueOf(this.xclasec.xjifhistoriaft.xjppersona.getIdPersona());
            } else if (this.xid == 2) {
                mparametros[1][1] = String.valueOf(this.xclaselab.frmRecep.frmPersona.getIdPersona());
            } else if (this.xid == 3) {
                mparametros[1][1] = String.valueOf(this.xclaserx.xjifrecepcion.frmPersona.getIdPersona());
            }
            if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString().equals("2")) {
                this.xmetodo.imprimirEscalaAbreviadaDeDesarrollo(mparametros[0][1], Long.parseLong(mparametros[1][1]));
            }
            if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("690")) {
                this.xmetodo.mGenerarGrafico(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            }
            if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("1023") || this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("1024") || this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("461") || this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("1032") || this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals("250")) {
                try {
                    String xTratamiento = null;
                    String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString() + "')";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(sql);
                    if (xrs.next()) {
                        xrs.first();
                        xTratamiento = xrs.getString(1);
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                    this.xmetodo.mTraerDatosDienteDxOdontInicial(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
                    this.xmetodo.mTraerDatosDienteProcOdontInicial(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
                    this.xmetodo.traerImagenOdontograma();
                    this.xmetodo.mTraerDatosDienteDxTratamiento(xTratamiento);
                    this.xmetodo.traerImagenOdontogramaDx();
                    this.xmetodo.mTraerDatosDienteProcTratamiento(xTratamiento);
                    this.xmetodo.traerImagenOdontogramaProc();
                    this.xmetodo.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                    this.xmetodo.traerImagenOdontogramaControlPlaca();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFConsultarAtenciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals("1")) {
                mGenerarGraficaPrenatal();
            } else if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals("2")) {
                mGeneraGraficaCyD();
            }
            mGenerarGraficaPrenatal();
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), mparametros);
            Principal.mGrabarLogAtenciones("HISTORIA CLINICA SISTEMATIZADA", this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        try {
            if (this.xid == 0) {
                this.xclase.xjifhistoriaclinica.setSelected(true);
            } else if (this.xid == 1) {
                this.xclasec.xjifhistoriaft.setSelected(true);
            } else if (this.xid == 2) {
                this.xclaselab.frmRecep.setSelected(true);
            } else if (this.xid == 3) {
                this.xclaserx.xjifrecepcion.setSelected(true);
            }
            dispose();
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFConsultarAtenciones.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAtencionesDigitalizadaasMouseClicked(MouseEvent evt) {
        if (this.JTBAtencionesDigitalizadaas.getSelectedRow() != -1 && this.JTBAtencionesDigitalizadaas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 0) != null) {
            this.xmetodo.mostrarPdf(this.xmodeloatencionesdigitalizadas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 4).toString());
            Principal.mGrabarLogAtenciones("HISTORIA CLINICA DIGITALIZADA", this.JTBAtencionesDigitalizadaas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 0).toString(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBJuntasMedMouseClicked(MouseEvent evt) {
        if (this.JTBJuntasMed.getSelectedRow() != -1) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.JTBJuntasMed.getValueAt(this.JTBJuntasMed.getSelectedRow(), 0).toString();
            parametros[1][0] = "usuario";
            parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_ActaMedica", parametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFitroActionPerformed(ActionEvent evt) {
        if (this.JCHFitro.isSelected()) {
            this.JCBEspecialidad.setEnabled(true);
            this.JCBEspecialidad.removeAllItems();
            String xsql = "SELECT  `g_especialidad`.`Id` , `g_especialidad`.`Nbre`  FROM `g_especialidad` INNER JOIN `h_atencion`  ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_atencion`.`Codigo_Dxp` <>'') GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ";
            this.xidespecialidad = this.xconsultasbd.llenarCombo(xsql, this.xidespecialidad, this.JCBEspecialidad);
            this.JCBEspecialidad.setSelectedItem(-1);
            this.xconsultasbd.cerrarConexionBd();
            this.xlleno = true;
            return;
        }
        this.xlleno = false;
        this.JCBEspecialidad.setEnabled(false);
        this.JCBEspecialidad.removeAllItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.modelosuministro = new DefaultTableModel(new Object[0], new String[]{"IdA", "Fecha y Hora", "Tipo Consulta", "Motivo Atención", "Dx", "Conclusión", "Profesional", "", "IdEspecialidad", "TipoAtencion", "TipoHC_Reporte", "Id_usuario", "EsPrenatal", "IdPrograma"}) { // from class: Historia.JIFConsultarAtenciones.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelosuministro);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            if (this.xid == 0) {
                if (this.JCHFitro.isSelected()) {
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, h_atencion.Motivo_Atencion, h_atencion.Codigo_Dxp, h_atencion.Conclusion, `profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, ingreso.Id_TipoAtencion, h_tipohistoria.`Reporte`, ingreso.Id_Usuario, `g_tipoprograma`.`EsPrenatal`, `g_tipoprograma`.`Id_TipoPrograma` FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (c_clasecita.`Id_Programa`=`g_tipoprograma`.`Id_TipoPrograma`) WHERE (ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_atencion.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND h_atencion.Estado =0 AND h_atencion.TipoGuardado in(1,2)) ORDER BY h_atencion.Fecha_Atencion DESC ";
                } else {
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, h_atencion.Motivo_Atencion, h_atencion.Codigo_Dxp, h_atencion.Conclusion, `profesional1`.`NProfesional`, c_clasecita.Id_Historia, `profesional1`.`IdEspecialidad`, ingreso.Id_TipoAtencion,  h_tipohistoria.`Reporte`, ingreso.Id_Usuario, `g_tipoprograma`.`EsPrenatal`, `g_tipoprograma`.`Id_TipoPrograma` FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (c_clasecita.`Id_Programa`=`g_tipoprograma`.`Id_TipoPrograma`) WHERE (ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_atencion.Estado =0 AND h_atencion.TipoGuardado in(1,2)) ORDER BY h_atencion.Fecha_Atencion DESC ";
                }
            } else if (this.xid == 1) {
                sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, h_atencion.Motivo_Atencion, h_atencion.Codigo_Dxp, h_atencion.Conclusion, `profesional1`.`NProfesional`, c_clasecita.Id_Historia, `profesional1`.`IdEspecialidad`, ingreso.Id_TipoAtencion, h_tipohistoria.`Reporte`, ingreso.Id_Usuario, `g_tipoprograma`.`EsPrenatal`, `g_tipoprograma`.`Id_TipoPrograma` FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (c_clasecita.`Id_Programa`=`g_tipoprograma`.`Id_TipoPrograma`) WHERE (ingreso.Id_Usuario ='" + this.xclasec.xjifhistoriaft.xjppersona.getIdPersona() + "' AND h_atencion.Estado =0 AND h_atencion.TipoGuardado in(1,2)) ORDER BY h_atencion.Fecha_Atencion DESC ";
            } else if (this.xid == 2) {
                sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, h_atencion.Motivo_Atencion, h_atencion.Codigo_Dxp, h_atencion.Conclusion, `profesional1`.`NProfesional`, c_clasecita.Id_Historia, `profesional1`.`IdEspecialidad`, ingreso.Id_TipoAtencion , h_tipohistoria.`Reporte`, ingreso.Id_Usuario, `g_tipoprograma`.`EsPrenatal`, `g_tipoprograma`.`Id_TipoPrograma` FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (c_clasecita.`Id_Programa`=`g_tipoprograma`.`Id_TipoPrograma`) WHERE (ingreso.Id_Usuario ='" + this.xclaselab.frmRecep.frmPersona.getIdPersona() + "' AND h_atencion.Estado =0 AND h_atencion.TipoGuardado in(1,2)) ORDER BY h_atencion.Fecha_Atencion DESC ";
            } else if (this.xid == 3) {
                sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, h_atencion.Motivo_Atencion, h_atencion.Codigo_Dxp, h_atencion.Conclusion, `profesional1`.`NProfesional`, c_clasecita.Id_Historia, `profesional1`.`IdEspecialidad`, ingreso.Id_TipoAtencion, h_tipohistoria.`Reporte`, ingreso.Id_Usuario, `g_tipoprograma`.`EsPrenatal`, `g_tipoprograma`.`Id_TipoPrograma` FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (c_clasecita.`Id_Programa`=`g_tipoprograma`.`Id_TipoPrograma`) WHERE (ingreso.Id_Usuario ='" + this.xclaserx.xjifrecepcion.frmPersona.getIdPersona() + "' AND h_atencion.Estado =0 AND h_atencion.TipoGuardado in(1,2)) ORDER BY h_atencion.Fecha_Atencion DESC ";
            }
            this.rs = this.xconsultasbd.traerRs(sql);
            mCrearTabla();
            this.rs.next();
            if (this.rs.getRow() != 0) {
                this.rs.beforeFirst();
                int i = 0;
                while (this.rs.next()) {
                    this.modelosuministro.addRow(this.dato);
                    this.modelosuministro.setValueAt(Long.valueOf(this.rs.getLong(1)), i, 0);
                    this.modelosuministro.setValueAt(this.rs.getString(2) + " " + this.rs.getString(3), i, 1);
                    this.modelosuministro.setValueAt(this.rs.getString(4), i, 2);
                    this.modelosuministro.setValueAt(this.rs.getString(5), i, 3);
                    this.modelosuministro.setValueAt(this.rs.getString(6), i, 4);
                    this.modelosuministro.setValueAt(this.rs.getString(7), i, 5);
                    this.modelosuministro.setValueAt(this.rs.getString(8), i, 6);
                    this.modelosuministro.setValueAt(this.rs.getString(9), i, 7);
                    this.modelosuministro.setValueAt(this.rs.getString(10), i, 8);
                    this.modelosuministro.setValueAt(this.rs.getString(11), i, 9);
                    this.modelosuministro.setValueAt(this.rs.getString(12), i, 10);
                    this.modelosuministro.setValueAt(this.rs.getString("Id_Usuario"), i, 11);
                    this.modelosuministro.setValueAt(this.rs.getString("EsPrenatal"), i, 12);
                    this.modelosuministro.setValueAt(this.rs.getString("Id_TipoPrograma"), i, 13);
                    i++;
                }
            }
            this.rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mCrearTablaDig() {
        this.xmodeloatencionesdigitalizadas = new DefaultTableModel();
        this.xmodeloatencionesdigitalizadas.addColumn("IdA");
        this.xmodeloatencionesdigitalizadas.addColumn("Fecha");
        this.xmodeloatencionesdigitalizadas.addColumn("Especialidad");
        this.xmodeloatencionesdigitalizadas.addColumn("Profesional");
        this.xmodeloatencionesdigitalizadas.addColumn("");
        this.JTBAtencionesDigitalizadaas.setModel(this.xmodeloatencionesdigitalizadas);
        this.column = this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(60);
        this.column = this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(200);
        this.column = this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(500);
        this.column = this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(4);
        this.column.setMinWidth(0);
        this.column.setMaxWidth(0);
    }

    private void mCargarDatosTablaDig() {
        try {
            String sql = null;
            if (this.xid == 0) {
                sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            } else if (this.xid == 1) {
                sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xclasec.xjifhistoriaft.xjppersona.getIdPersona() + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            } else if (this.xid == 2) {
                sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xclaselab.frmRecep.frmPersona.getIdPersona() + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            } else if (this.xid == 3) {
                sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xclaserx.xjifrecepcion.frmPersona.getIdPersona() + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            }
            ResultSet rs1 = this.xconsultasbd.traerRs(sql);
            rs1.next();
            if (rs1.getRow() != 0) {
                rs1.beforeFirst();
                int i = 0;
                while (rs1.next()) {
                    this.xmodeloatencionesdigitalizadas.addRow(this.dato);
                    this.xmodeloatencionesdigitalizadas.setValueAt(Long.valueOf(rs1.getLong(1)), i, 0);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs1.getString(2), i, 1);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs1.getString(3), i, 2);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs1.getString(4), i, 3);
                    this.xmodeloatencionesdigitalizadas.setValueAt(this.xmetodo.mTraerUrlBD(rs1.getString(5)), i, 4);
                    i++;
                }
            }
            rs1.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarAtenciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mBuscarJuntas() {
        String sql = "SELECT Id, DATE_FORMAT(Fechaj,'%d-%m-%Y') AS Fecha, Hora, Motivo, ResumenHC FROM h_rjuntamedica WHERE (Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY Fecha DESC ";
        this.JTBJuntasMed.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.xconsultasbd.llenarTabla(sql, this.JTBJuntasMed, this.xmodelojuntasmed);
        this.xconsultasbd.cerrarConexionBd();
        this.JTBJuntasMed.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBJuntasMed.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBJuntasMed.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBJuntasMed.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBJuntasMed.getColumnModel().getColumn(4).setPreferredWidth(200);
    }
}
