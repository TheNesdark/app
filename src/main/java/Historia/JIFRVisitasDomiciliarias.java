package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.ClaseImpresionInformes;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFRVisitasDomiciliarias.class */
public class JIFRVisitasDomiciliarias extends JInternalFrame {
    public String[] xidtiponota;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xidespecialidad;
    private String xnombre;
    private Long xidingreso;
    private String[][] xidatenciones;
    private String[] xidespecialidadc;
    private Integer forma;
    private ButtonGroup JBGOpciones;
    private JButton JBT_NotaP;
    public JComboBox JCBAtencionesMed;
    public JComboBox JCBEspecialidad;
    private JComboBox JCBTipoNota;
    private JCheckBox JCHFiltro;
    private JDateChooser JDCFecha;
    private JPanel JPDatosVis;
    private JPanel JPDescripcion;
    private JPanel JPIFDatosUsuario;
    private JPanel JPINotaOrden;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPNotas;
    private JScrollPane JSPNotasO;
    private JTable JTDetalle;
    private JTable JTDetalleN;
    private JFormattedTextField JTFFHora;
    private JTabbedPane JTPDatos;
    public JTextPane JTPNota;
    public int xnquincenas = 3;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;
    public String noHistoria = "";

    public JIFRVisitasDomiciliarias(String xidespecialidad, String xtitulo, String xnombre, Long xidingreso, Integer forma) {
        this.forma = 0;
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        setTitle(xtitulo);
        this.xidespecialidad = xidespecialidad;
        this.xidingreso = xidingreso;
        mCargasPanelUsuario();
        mLimpiarComponentes();
        this.forma = forma;
        if (forma.intValue() == 1) {
            this.JTPDatos.remove(0);
        }
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v81, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPDatosVis = new JPanel();
        this.JPDescripcion = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JCBTipoNota = new JComboBox();
        this.JBT_NotaP = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JPINotaOrden = new JPanel();
        this.JSPNotasO = new JScrollPane();
        this.JTDetalleN = new JTable();
        this.JCBEspecialidad = new JComboBox();
        this.JCBAtencionesMed = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("VISITAS DOMICILIARIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifvisitadomiciliaria");
        setNormalBounds(null);
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFRVisitasDomiciliarias.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRVisitasDomiciliarias.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 167, 32767));
        this.JPDatosVis.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDescripcion.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "Nota", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JTPNota.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRVisitasDomiciliarias.2
            public void keyPressed(KeyEvent evt) {
                JIFRVisitasDomiciliarias.this.JTPNotaKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_NotaP.setFont(new Font("Arial", 1, 12));
        this.JBT_NotaP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NotaP.setText("<html><P ALIGN=center>Notas Predefinidas");
        this.JBT_NotaP.addActionListener(new ActionListener() { // from class: Historia.JIFRVisitasDomiciliarias.3
            public void actionPerformed(ActionEvent evt) {
                JIFRVisitasDomiciliarias.this.JBT_NotaPActionPerformed(evt);
            }
        });
        this.JBT_NotaP.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRVisitasDomiciliarias.4
            public void keyPressed(KeyEvent evt) {
                JIFRVisitasDomiciliarias.this.JBT_NotaPKeyPressed(evt);
            }
        });
        GroupLayout JPDescripcionLayout = new GroupLayout(this.JPDescripcion);
        this.JPDescripcion.setLayout(JPDescripcionLayout);
        JPDescripcionLayout.setHorizontalGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDescripcionLayout.createSequentialGroup().addContainerGap().addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDescripcionLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFHora, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoNota, -2, 501, -2).addGap(0, 0, 32767)).addGroup(JPDescripcionLayout.createSequentialGroup().addComponent(this.JSPNotas, -2, 810, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_NotaP, -2, 130, -2))).addContainerGap()));
        JPDescripcionLayout.setVerticalGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDescripcionLayout.createSequentialGroup().addContainerGap().addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoNota, GroupLayout.Alignment.TRAILING, -1, 52, 32767).addComponent(this.JTFFHora, GroupLayout.Alignment.TRAILING, -1, 52, 32767).addComponent(this.JDCFecha, GroupLayout.Alignment.TRAILING, -1, 52, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_NotaP, -2, 90, -2).addComponent(this.JSPNotas, -1, 97, 32767)).addContainerGap()));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalleN.setFont(new Font("Arial", 1, 12));
        this.JTDetalleN.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleN.setRowHeight(25);
        this.JTDetalleN.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleN.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleN.setSelectionMode(0);
        this.JTDetalleN.addMouseListener(new MouseAdapter() { // from class: Historia.JIFRVisitasDomiciliarias.5
            public void mouseClicked(MouseEvent evt) {
                JIFRVisitasDomiciliarias.this.JTDetalleNMouseClicked(evt);
            }
        });
        this.JSPNotasO.setViewportView(this.JTDetalleN);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFRVisitasDomiciliarias.6
            public void itemStateChanged(ItemEvent evt) {
                JIFRVisitasDomiciliarias.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBAtencionesMed.setFont(new Font("Arial", 1, 12));
        this.JCBAtencionesMed.setBorder(BorderFactory.createTitledBorder((Border) null, "Atenciones Médicas", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Filtro Por Especialdiad");
        GroupLayout JPINotaOrdenLayout = new GroupLayout(this.JPINotaOrden);
        this.JPINotaOrden.setLayout(JPINotaOrdenLayout);
        JPINotaOrdenLayout.setHorizontalGroup(JPINotaOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINotaOrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEspecialidad, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAtencionesMed, -2, 442, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro, -2, 175, -2).addContainerGap(89, 32767)).addGroup(JPINotaOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotaOrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPNotasO, -1, 962, 32767).addContainerGap())));
        JPINotaOrdenLayout.setVerticalGroup(JPINotaOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotaOrdenLayout.createSequentialGroup().addGap(164, 164, 164).addGroup(JPINotaOrdenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 52, 32767).addComponent(this.JCBAtencionesMed, -1, 52, 32767).addComponent(this.JCHFiltro)).addGap(41, 41, 41)).addGroup(JPINotaOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotaOrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPNotasO, -2, 150, -2).addContainerGap(101, 32767))));
        this.JTPDatos.addTab("NOTA/ORDEN", this.JPINotaOrden);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFRVisitasDomiciliarias.7
            public void mouseClicked(MouseEvent evt) {
                JIFRVisitasDomiciliarias.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout JPDatosVisLayout = new GroupLayout(this.JPDatosVis);
        this.JPDatosVis.setLayout(JPDatosVisLayout);
        JPDatosVisLayout.setHorizontalGroup(JPDatosVisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosVisLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosVisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.JPDescripcion, -1, -1, 32767)).addContainerGap()));
        JPDatosVisLayout.setVerticalGroup(JPDatosVisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosVisLayout.createSequentialGroup().addComponent(this.JPDescripcion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 266, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosVis, -2, -1, -2).addComponent(this.JPIFDatosUsuario, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPDatosVis, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        dispose();
        if (this.xnombre.equals("xjifnotas")) {
            if (Principal.claseenfer.xjifagenda != null) {
                Principal.claseenfer.xjifagenda.setVisible(true);
            }
            if (Principal.claseenfer.agendProcedimiento != null) {
                Principal.claseenfer.agendProcedimiento.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPNotaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPNota.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPNota.setText(this.JTPNota.getText().substring(0, this.JTPNota.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoNota.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTPNota.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            ClaseImpresionInformes informes = new ClaseImpresionInformes();
            informes.imprimirNotas(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleNMouseClicked(MouseEvent evt) {
        if (this.JTDetalleN.getRowCount() != -1) {
            Object[] botones = {"Nota", "Historia", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                String[][] mparametros = new String[7][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 8).toString();
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                mparametros[4][0] = "idNota";
                mparametros[4][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 0).toString();
                mparametros[6][0] = "xTitulo";
                mparametros[6][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 3).toString();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 4).toString(), mparametros);
                return;
            }
            if (n == 1) {
                String[][] mparametros2 = new String[7][2];
                mparametros2[0][0] = "idatencion1";
                mparametros2[0][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 8).toString();
                mparametros2[1][0] = "idpaciente1";
                mparametros2[1][1] = this.xjppersona.getIdPersona();
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                mparametros2[4][0] = "idNota";
                mparametros2[4][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 0).toString();
                mparametros2[6][0] = "xTitulo";
                mparametros2[6][1] = this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 3).toString();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + this.xmodelo1.getValueAt(this.JTDetalleN.getSelectedRow(), 4).toString(), mparametros2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        String xsql;
        if (this.JCBEspecialidad.getSelectedIndex() != -1 && this.xlleno && !this.xjppersona.getIdPersona().equals("")) {
            this.JCBAtencionesMed.removeAllItems();
            if (this.JCHFiltro.isSelected()) {
                xsql = "SELECT h_atencion.Id, CONCAT(DATE_FORMAT(Fecha_Atencion,'%d-%m-%Y'), ' - ' ,  profesional1.NProfesional,' - ', g_tipoatencion.`Nbre`,' - Atención ',h_atencion.Id) AS atencion, `ingreso`.`Id_TipoAtencion`  \nFROM h_atencion \nINNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) \nINNER JOIN g_tipoatencion ON (`g_tipoatencion`.`Id`=`ingreso`.`Id_TipoAtencion`) \nWHERE (h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' \nAND h_atencion.Id_Especialidad ='" + this.xidespecialidadc[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion DESC ";
            } else {
                xsql = "SELECT h_atencion.Id, CONCAT(DATE_FORMAT(Fecha_Atencion,'%d-%m-%Y'), ' - ' ,  profesional1.NProfesional  ) AS atencion, `ingreso`.`Id_TipoAtencion`  \nFROM h_atencion \nINNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) \nWHERE (h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') ORDER BY h_atencion.Fecha_Atencion DESC ";
            }
            System.out.println(xsql);
            this.xidatenciones = this.xconsultasbd.llenarComboyLista(xsql, this.xidatenciones, this.JCBAtencionesMed, 3);
            this.xconsultasbd.cerrarConexionBd();
            this.JCBAtencionesMed.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_NotasP();
        }
    }

    private void mCargar_NotasP() {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTPNota, this.JTPNota, 0);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo Nota", "Descripción", "Profesional", "Especialidad"}) { // from class: Historia.JIFRVisitasDomiciliarias.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo Nota", "Nparametro", "Descripción", "Profesional", "Especialidad", "idatencion", "idusuario"}) { // from class: Historia.JIFRVisitasDomiciliarias.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleN;
        JTable jTable2 = this.JTDetalleN;
        jTable.setAutoResizeMode(0);
        this.JTDetalleN.doLayout();
        this.JTDetalleN.setModel(this.xmodelo1);
        this.JTDetalleN.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleN.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleN.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleN.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleN.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleN.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalleN.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalleN.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalleN.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleN.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    public void mBuscarAatenciones() {
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT h_rvisitasdomiciliarias.Id, DATE_FORMAT(h_rvisitasdomiciliarias.FechaV,'%d-%m-%Y') AS Fecha, h_rvisitasdomiciliarias.HoraV, h_tiponota.Nbre , h_rvisitasdomiciliarias.Descripcion, profesional1.NProfesional, profesional1.Especialidad, h_rvisitasdomiciliarias.Id_Persona FROM h_rvisitasdomiciliarias INNER JOIN profesional1  ON (h_rvisitasdomiciliarias.Id_Profesional = profesional1.Id_Persona) AND (h_rvisitasdomiciliarias.Id_Especialidad = profesional1.IdEspecialidad) INNER JOIN h_tiponota  ON (h_rvisitasdomiciliarias.Id_TipoNota= h_tiponota.Id) WHERE (h_rvisitasdomiciliarias.Id_Persona ='" + this.xjppersona.getIdPersona() + "')  ORDER BY h_rvisitasdomiciliarias.FechaV DESC, h_rvisitasdomiciliarias.HoraV DESC ";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 4);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 5);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 6);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRVisitasDomiciliarias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        try {
            mCrearModeloDatos1();
            String sql = "SELECT h_notasclinicas.Id, DATE_FORMAT(FechaNota,'%d-%m-%Y') AS Fecha, h_notasclinicas.HoraNota, h_tiponota.Nbre, h_tiponota.NReporte, h_notasclinicas.Descripcion, profesional1.Especialidad, profesional1.NProfesional, h_atencion.Id, ingreso.Id_Usuario FROM h_notasclinicas INNER JOIN h_tiponota  ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id) INNER JOIN profesional1  ON (h_notasclinicas.Id_Profesional = profesional1.Id_Persona) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad) INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') ORDER BY FechaNota DESC ";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRVisitasDomiciliarias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("") || Principal.txtNo.getText() == null) {
            if (!this.JTPNota.getText().isEmpty()) {
                if (this.JCBTipoNota.getSelectedIndex() != -1) {
                    this.xjppersona.grabar();
                    if (this.xnombre.equals("xjifnotasmedicas") || this.xnombre.equals("jifregistronota")) {
                        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                            if (this.JCBAtencionesMed.getSelectedIndex() != -1) {
                                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x == 0) {
                                    mGrabarNota();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una atención", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBAtencionesMed.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBEspecialidad.requestFocus();
                        return;
                    }
                    if (this.xnombre.equals("xjifnotas") || this.xnombre.equals("xjifnotasmedicas1") || this.xnombre.equals("jifvisitadomiciliaria") || this.xnombre.equals("jifnotamedicaSF")) {
                        if (this.xidingreso == null || this.xidingreso.longValue() == 0) {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar este usuario desde la agenda", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            return;
                        }
                        if (this.noHistoria.equals(this.xjppersona.txtHistoria.getText().trim())) {
                            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x2 == 0) {
                                mGuardarDato();
                                if (this.forma.intValue() == 1) {
                                    Principal.claseenfer.agendProcedimiento.actualizarEstadoAtencion();
                                }
                                ClaseImpresionInformes informes = new ClaseImpresionInformes();
                                informes.imprimirNotas(Principal.txtNo.getText());
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar este usuario desde la agenda", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoNota.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Nota no puede ser nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPNota.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Nota ya grabada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mGuardarDato() {
        String sql = "Insert into h_rvisitasdomiciliarias (Id_Persona, Id_Ingreso, Id_TipoNota, FechaV, HoraV, Descripcion, Id_Profesional, Id_Especialidad, UsuarioS, Fecha) Values('" + this.xjppersona.getIdPersona() + "','" + this.xidingreso + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.JTPNota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xidespecialidad + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
        Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
        this.xconsultasbd.cerrarConexionBd();
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    private void mGrabarNota() {
        String sql = "insert into  h_notasclinicas (Id_Atencion, Id_Tipo_Atencion, FechaNota, HoraNota, Id_TipoNota, Descripcion, Id_Profesional, Id_Especialidad,Fecha, UsuarioS) values ('" + this.xidatenciones[this.JCBAtencionesMed.getSelectedIndex()][0] + "','" + this.xidatenciones[this.JCBAtencionesMed.getSelectedIndex()][1] + "','" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.JTPNota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xidespecialidad + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
        this.xconsultasbd.cerrarConexionBd();
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    private void mLimpiarComponentes() {
        Principal.txtNo.setText("");
        this.xlleno = false;
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JTFFHora.setText(this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()));
        this.JCBTipoNota.removeAllItems();
        this.xidtiponota = this.xconsultasbd.llenarCombo("SELECT h_tiponota.Id, h_tiponota.Nbre FROM h_tiponota inner join h_tiponota_especialidad on (h_tiponota.Id=h_tiponota_especialidad.Id_TipoNota)  \nWHERE (h_tiponota_especialidad.Estado =1 and h_tiponota_especialidad.Id_Especialidad=" + this.xidespecialidad + ") ORDER BY h_tiponota.Nbre ASC", this.xidtiponota, this.JCBTipoNota);
        this.JCBTipoNota.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.JTPNota.setText("");
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidadc = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidadc, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.JCBAtencionesMed.removeAllItems();
        this.xlleno = true;
        mCrearModeloDatos();
        mCrearModeloDatos1();
        this.JDCFecha.requestFocus();
    }

    private void mNuevoNota() {
        Principal.mLimpiarDatosP();
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JTFFHora.setText(this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()));
        this.JTPNota.setText("");
        this.JCBTipoNota.setSelectedIndex(-1);
        this.xlleno = false;
        this.JCBAtencionesMed.removeAllItems();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xlleno = true;
        this.JDCFecha.requestFocus();
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Nota", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjppersona.nuevo();
            mLimpiarComponentes();
            this.xidingreso = 0L;
        } else if (n == 1) {
            mNuevoNota();
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }
}
