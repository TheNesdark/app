package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAgenda_Unidosis.class */
public class JIFAgenda_Unidosis extends JInternalFrame {
    private String xsql;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private Thread hilo;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGTipoA;
    private JCheckBox JCH_Agrupacion;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JLabel JLBNRegistro;
    private JPanel JPIDatosC;
    private JPanel JPIEstado;
    private JRadioButton JRBDespachada;
    private JRadioButton JRBPorDespachar;
    private JScrollPane JSPAgenda;
    public JTable JTAgenda;
    private JTextField JTFNombreBusqueda;
    private JTabbedPane JTPDatosA;
    private int xtipoa = 3;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);
    private long xN_Usuarios = 0;

    public JIFAgenda_Unidosis() {
        initComponents();
        mNuevo();
        mEjecutaTarea();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoA = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JLBNRegistro = new JLabel();
        this.JPIEstado = new JPanel();
        this.JRBPorDespachar = new JRadioButton();
        this.JRBDespachada = new JRadioButton();
        this.JCH_Agrupacion = new JCheckBox();
        this.JTFNombreBusqueda = new JTextField();
        this.JTPDatosA = new JTabbedPane();
        this.JSPAgenda = new JScrollPane();
        this.JTAgenda = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA DE  USUARIOS EN URGENCIAS U HOSPITALIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFAgenda_Unidosis.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFAgenda_Unidosis.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAgenda_Unidosis.this.formInternalFrameClosing(evt);
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
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstado.add(this.JRBPorDespachar);
        this.JRBPorDespachar.setFont(new Font("Arial", 1, 12));
        this.JRBPorDespachar.setForeground(Color.blue);
        this.JRBPorDespachar.setSelected(true);
        this.JRBPorDespachar.setText("Por despachar");
        this.JRBPorDespachar.addActionListener(new ActionListener() { // from class: Inventarios.JIFAgenda_Unidosis.2
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda_Unidosis.this.JRBPorDespacharActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBDespachada);
        this.JRBDespachada.setFont(new Font("Arial", 1, 12));
        this.JRBDespachada.setForeground(Color.blue);
        this.JRBDespachada.setText("Despachada");
        this.JRBDespachada.addActionListener(new ActionListener() { // from class: Inventarios.JIFAgenda_Unidosis.3
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda_Unidosis.this.JRBDespachadaActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPorDespachar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDespachada).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorDespachar).addComponent(this.JRBDespachada)));
        this.JCH_Agrupacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupacion.setText("Agrupación tipo producto");
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFAgenda_Unidosis.4
            public void keyTyped(KeyEvent evt) {
                JIFAgenda_Unidosis.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFAgenda_Unidosis.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreBusqueda).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JCH_Agrupacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 147, 32767).addComponent(this.JPIEstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistro, -2, 170, -2))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Agrupacion).addComponent(this.JPIEstado, -2, -1, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNRegistro, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 50, -2).addComponent(this.JDCFechaF, -2, 50, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFNombreBusqueda, -2, 50, -2)));
        this.JTPDatosA.setForeground(Color.red);
        this.JTPDatosA.setFont(new Font("Arial", 1, 14));
        this.JSPAgenda.addMouseMotionListener(new MouseMotionAdapter() { // from class: Inventarios.JIFAgenda_Unidosis.5
            public void mouseMoved(MouseEvent evt) {
                JIFAgenda_Unidosis.this.JSPAgendaMouseMoved(evt);
            }
        });
        this.JSPAgenda.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAgenda_Unidosis.6
            public void mouseExited(MouseEvent evt) {
                JIFAgenda_Unidosis.this.JSPAgendaMouseExited(evt);
            }
        });
        this.JTAgenda.setFont(new Font("Arial", 1, 12));
        this.JTAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgenda.setRowHeight(25);
        this.JTAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgenda.setSelectionMode(0);
        this.JTAgenda.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAgenda_Unidosis.7
            public void mouseClicked(MouseEvent evt) {
                JIFAgenda_Unidosis.this.JTAgendaMouseClicked(evt);
            }
        });
        this.JTAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFAgenda_Unidosis.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgenda_Unidosis.this.JTAgendaPropertyChange(evt);
            }
        });
        this.JSPAgenda.setViewportView(this.JTAgenda);
        this.JTPDatosA.addTab("AGENDA", this.JSPAgenda);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosA).addComponent(this.JPIDatosC, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatosA, -2, 335, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorDespacharActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDespachadaActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTAgenda.getSelectedRow() != -1) {
            Object[] botones = {"Dispensar", "Dispensar y Cerrar", "Cerrar Unidosis", "Visualizar", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y != 0 && y != 1) {
                if (y == 2) {
                    System.out.println("Entro a cerrar unidosis ID:: " + Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString()));
                    cerrarUnidosis(Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString()));
                    return;
                } else {
                    if (y == 3) {
                        mImprimir();
                        return;
                    }
                    return;
                }
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 10).toString()).longValue() == 0) {
                try {
                    setVisible(false);
                    this.estadoAgenda.set(false);
                    Principal.xClaseInventario.mCargarPantalla("Despachos", this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 2).toString(), Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString()), Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 12).toString()), Boolean.valueOf(this.JCH_Agrupacion.isSelected()), Integer.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 14).toString()).intValue(), y, "JIFAgenda_Unidosis");
                    return;
                } catch (Throwable ex) {
                    Logger.getLogger(JIFAgenda_Unidosis.class.getName()).log(Level.SEVERE, (String) null, ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Unidosis ya cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    void cerrarUnidosis(Long idOrden) {
        String xsql = "UPDATE h_ordenes_unidosis_detalle SET Id_Salida=-1 , usuario='" + Principal.usuarioSistemaDTO.getLogin() + "', fechaCierre = NOW() where Id_Ordenes ='" + idOrden + "' and Id_Salida =0";
        try {
            int result = this.xct.ejecutaSQLUpdate(xsql);
            if (result > 0) {
                System.out.println("Registro unidosis :: " + idOrden + " :: cerrado");
                System.out.println("Registro modificados a -1  === " + result + "");
                mCargarDatos();
            }
            this.xct.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFAgenda_Unidosis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPAgendaMouseMoved(MouseEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPAgendaMouseExited(MouseEvent evt) {
        this.estadoAgenda.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        this.estadoAgenda.set(false);
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ordene_unidosis", mparametros);
    }

    private void mEjecutaTarea() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Inventarios.JIFAgenda_Unidosis.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIFAgenda_Unidosis.this.estadoAgenda.get()) {
                    JIFAgenda_Unidosis.this.mCargarDatos();
                } else {
                    timer.cancel();
                }
                System.out.println(" tarea ejecutando time");
            }
        }, 0L, 5000L);
    }

    private void mNuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
            this.JCH_Agrupacion.setSelected(false);
        } else {
            this.JCH_Agrupacion.setSelected(true);
        }
        mCrearTablaAgenda();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "No. Historia", "Usuario", "Sexo", "Edad", "Especialidad", "Profesional", "Cama", "Tipo Atenciòn", "Id_Salida", "Empresa", "Id_Ingreso", "Tipo", "IdTipo", "Productos"}) { // from class: Inventarios.JIFAgenda_Unidosis.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgenda.setAutoResizeMode(0);
        this.JTAgenda.doLayout();
        this.JTAgenda.setModel(this.xmodelo);
        this.JTAgenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTAgenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTAgenda.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTAgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(11).setPreferredWidth(250);
        this.JTAgenda.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgenda.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgenda.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgenda.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTAgenda.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTAgenda.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTAgenda.getColumnModel().getColumn(15).setPreferredWidth(900);
    }

    public void mCargarDatos() {
        if (this.JDCFechaI.getDate() != null && this.xmodelo != null) {
            String valorPorDespachar = " and  houd.Id_Salida<>0 ";
            String valorAgrupado = " group by  hou.Id ";
            if (this.JRBPorDespachar.isSelected()) {
                valorPorDespachar = " and  houd.Id_Salida=0  ";
            }
            if (this.JCH_Agrupacion.isSelected()) {
                valorAgrupado = " group by  hou.Id, is2.esMaterial ";
            }
            this.xsql = "select hou.Id idUnidosis\n,DATE_FORMAT(hou.Fecha_S,'%Y-%m-%d %H:%s') fechaSolictud\n, gu.NoHistoria  numeroHistoria\n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) as nombreUsuario\n, gp.Id_Sexo  idSexo\n , concat(Devuelve_Edad_2F(gp.FechaNac, DATE_FORMAT(hou.Fecha_S,'%Y-%m-%d')), ' ', Devuelve_Tipo_Edad_2F(gp.FechaNac, DATE_FORMAT(hou.Fecha_S,'%Y-%m-%d'))) edad\n, ge.Nbre  especialidad\n,  concat(gp1.Apellido1,' ', gp1.Apellido2,' ', gp1.Nombre1,' ', gp1.Nombre2) as profesional\n, ifnull(fc.Nbre, '') cama\n, gt.Nbre tipoAtencion\n, houd.Id_Salida  idSalida\n, fe.Nbre  empresaConvenio\n, i.Id idIngreso\n,  IF(is2.`EsMaterial`=0, 'MEDICAMENTOS', 'MATERIALES') tipo \n,  is2.`EsMaterial`  esMaterial\n ,group_concat(distinct  is2.Nbre separator ';') suministro\n\nfrom h_ordenes_unidosis hou\ninner join h_ordenes_unidosis_detalle houd  on (houd.Id_Ordenes=hou.Id)\ninner join i_suministro is2 on (is2.Id=houd.Id_Suministro)\ninner join h_atencion ha ON(ha.Id=hou.Id_Atencion)\ninner join ingreso i on (i.Id=ha.Id_Ingreso)\ninner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\ninner join g_persona gp on (gp.Id=i.Id_Usuario)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\ninner join g_especialidad ge on (ge.Id=hou.Id_Especialidad)\ninner join g_persona gp1 on (gp1.Id=hou.Id_Profesional)\ninner join g_tipoatencion gt on (gt.Id=hou.Tipo )\nleft join f_camas fc on (i.Cama=fc.Id)\nwhere (DATE_FORMAT(hou.Fecha_S,'%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' and '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'\n\tand hou.Estado=1\n \t" + valorPorDespachar + "\t\n)\n " + valorAgrupado + " \n HAVING nombreUsuario like  '%" + this.JTFNombreBusqueda.getText() + "%' ";
            System.out.println(this.xsql);
            try {
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (xrs.next()) {
                        mCrearTablaAgenda();
                        xrs.beforeFirst();
                        int xfila = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                            this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                            this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                            this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                            this.xmodelo.setValueAt(xrs.getString(8), xfila, 7);
                            this.xmodelo.setValueAt(xrs.getString(9), xfila, 8);
                            this.xmodelo.setValueAt(xrs.getString(10), xfila, 9);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idSalida")), xfila, 10);
                            this.xmodelo.setValueAt(xrs.getString(12), xfila, 11);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idIngreso")), xfila, 12);
                            this.xmodelo.setValueAt(xrs.getString("tipo"), xfila, 13);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("esMaterial")), xfila, 14);
                            this.xmodelo.setValueAt(xrs.getString("suministro"), xfila, 15);
                            xfila++;
                        }
                        if (this.xN_Usuarios != xrs.getRow()) {
                            this.xmt.mReproducir_Sonido(2);
                            this.xN_Usuarios = xrs.getRow();
                            this.JTPDatosA.setBackgroundAt(0, new Color(0, 255, 255));
                        }
                        this.JLBNRegistro.setText("" + xfila);
                    }
                    xrs.close();
                    this.xct.cerrarConexionBd();
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgenda_Unidosis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAgenda_Unidosis$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 11).toString().equals("NUEVA ORDEN")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
