package Salud_Ocupacional;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Laboratorio.JIFPlanillaTrabajo;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.LlamadasEntity;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.LlamadasService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFAgenda.class */
public class JIFAgenda extends JInternalFrame {
    private Object[] xdato;
    private String xsql;
    private boolean xlleno1;
    private int xAplicaFiltroP;
    public DefaultTableModel xmodelo;
    private clasesHistoriaCE xclaseHC;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JComboBox JCBProcedimiento;
    public JDateChooser JDCFecha;
    private JPanel JPIDatosB;
    private JPanel JPIFiltro;
    private JScrollPane JSPDatosAgenta;
    private JTable JTBDatosAgenda;
    private JTextField JTF_Nombre;
    public JRadioButton btnAtendidas;
    public JRadioButton btnPorAtender;
    public JRadioButton btnTodas;
    private JTextField txtCantidad;
    private Metodos xmt = new Metodos();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String[][] xidprocedimiento = (String[][]) null;
    private boolean xlleno = false;
    private int estado = 2;
    private Integer num = 0;
    private Integer estado_ = 0;
    private final EstadoAtencionService estadoAtencion = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public JIFAgenda(clasesHistoriaCE xclaseHC, int xAplicaFiltroP) {
        this.xAplicaFiltroP = 0;
        initComponents();
        this.xclaseHC = xclaseHC;
        this.xAplicaFiltroP = xAplicaFiltroP;
        mNuevo();
        ejecutarTareaTimer();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.btnTodas = new JRadioButton();
        this.btnPorAtender = new JRadioButton();
        this.btnAtendidas = new JRadioButton();
        this.txtCantidad = new JTextField();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JPIDatosB = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBProcedimiento = new JComboBox();
        this.JTF_Nombre = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(926, 583));
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: Salud_Ocupacional.JIFAgenda.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIFAgenda.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFAgenda.2
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAgenda.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setSelected(true);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFAgenda.3
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.btnTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(Color.blue);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFAgenda.4
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnAtendidas);
        this.btnAtendidas.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas.setForeground(Color.blue);
        this.btnAtendidas.setText("Atendidas");
        this.btnAtendidas.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFAgenda.5
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.btnAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas).addContainerGap(14, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.btnAtendidas).addComponent(this.btnTodas)).addContainerGap(-1, 32767)));
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setForeground(new Color(255, 0, 0));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.JSPDatosAgenta.setBorder(BorderFactory.createTitledBorder((Border) null, "LISTADO DE USUARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setCursor(new Cursor(0));
        this.JTBDatosAgenda.setRowHeight(25);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFAgenda.6
            public void mouseClicked(MouseEvent evt) {
                JIFAgenda.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JTBDatosAgenda.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFAgenda.7
            public void keyPressed(KeyEvent evt) {
                JIFAgenda.this.JTBDatosAgendaKeyPressed(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JIFAgenda.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgenda.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFAgenda.9
            public void itemStateChanged(ItemEvent evt) {
                JIFAgenda.this.JCBProcedimientoItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProcedimiento, -2, 684, -2).addContainerGap(-1, 32767)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, -2, 50, -2).addComponent(this.JDCFecha, -2, 50, -2)).addContainerGap(30, 32767)));
        this.JTF_Nombre.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_Nombre.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFAgenda.10
            public void keyPressed(KeyEvent evt) {
                JIFAgenda.this.JTF_NombreKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosB, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPIFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.txtCantidad, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Nombre, -2, 280, -2).addGap(0, 277, 32767)).addComponent(this.JSPDatosAgenta)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosAgenta, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTF_Nombre, GroupLayout.Alignment.TRAILING, -2, 54, -2).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.txtCantidad)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
        this.estado = 2;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarComboProc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1 && this.JCBProcedimiento.getSelectedIndex() != -1 && this.JTBDatosAgenda.getSelectedColumn() != 13) {
            if (this.JTBDatosAgenda.getSelectedColumn() != 10) {
                try {
                    this.JTBDatosAgenda.setCursor(new Cursor(3));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 3).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 7).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][1]));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 9).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(Long.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0]));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(this.JCBProcedimiento.getSelectedItem().toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 12).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + " " + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    System.out.println(Integer.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][3]));
                    if (Integer.parseInt(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][3]) == 1) {
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setExpandirHistoria(true);
                    } else {
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setExpandirHistoria(false);
                    }
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 11).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][2]));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(1);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(0L);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 15).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 16).toString()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 17).toString()));
                    this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_So");
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][2]));
                    try {
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(this.estadoAtencion.mTipoGuardado(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()).getTipoGuardado()));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.toString());
                    }
                    dispose();
                    this.EstadoTarea.set(false);
                    Principal.xclaseso.xjifagenda = null;
                    finalize();
                    this.JTBDatosAgenda.setCursor(new Cursor(0));
                    return;
                } catch (Throwable ex) {
                    Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, ex);
                    return;
                }
            }
            return;
        }
        LlamadasEntity seguimientos = new LlamadasEntity();
        if (this.JTBDatosAgenda.getSelectedColumn() == 13) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de  llamar al paciente " + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2) + " en el consultorio " + Principal.consultorio + "?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                seguimientos.setDocumento(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                seguimientos.setNombre(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
                seguimientos.setProfesional(Principal.usuarioSistemaDTO.getNombreUsuario());
                seguimientos.setConsultorio(Principal.consultorio);
                seguimientos.setEstado(1);
                seguimientos.setUbicacion(Principal.ubicacion);
                System.out.println(Principal.ubicacion);
                if (this.num.intValue() < 3) {
                    new ArrayList();
                    List<LlamadasEntity> list = this.llamadasService.ListarPacientes((String) this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1), Principal.consultorio);
                    if (list.isEmpty()) {
                        seguimientos.setOriginal(1);
                    } else {
                        seguimientos.setOriginal((Integer) null);
                    }
                    primerPaciente();
                    System.out.println("si actualizo");
                    this.llamadasService.Grabar(seguimientos);
                    this.estado_ = 1;
                    System.out.println("el estado es de: " + this.estado_);
                    System.out.println("si grabo");
                    this.num = Integer.valueOf(list.size());
                    return;
                }
                int x1 = JOptionPane.showConfirmDialog(this, "se excedio el numero de llamados, quieres volver a llamar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                if (x1 == 0) {
                    this.num = 0;
                }
            }
        }
    }

    private void buscaarPacientes(String documento) {
        new ArrayList();
        this.num = 0;
        List<LlamadasEntity> list = this.llamadasService.ListarPacientes(documento, Principal.consultorio);
        System.out.println(list.toString());
        if (!list.isEmpty()) {
            this.num = Integer.valueOf(list.size());
        }
        System.out.println(this.num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        System.out.println(this.JTBDatosAgenda.getSelectedColumn());
        if (evt.getKeyCode() == 18 && this.JTBDatosAgenda.getSelectedColumn() != 10) {
            mActualizar_DAtencion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NombreKeyPressed(KeyEvent evt) {
        if (this.xlleno1 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCargarDatos();
        }
    }

    private void mActualizar_DAtencion() {
        if (Long.parseLong(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()) == 0) {
            this.xsql = "update ingreso set Id_Atencion='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10) + "' Where Id='" + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
        mCargarDatos();
    }

    private void mLLenarComboProc() {
        this.xlleno1 = false;
        this.JCBProcedimiento.removeAllItems();
        if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
            if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 33) {
                if (this.xAplicaFiltroP == 0) {
                    this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `g_procedimiento`.`Id` not in (1966127,1966128,1966129)) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
                } else {
                    this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) LEFT JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `g_procedimiento`.`Id` not in (1966127,1966128,1966129)) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
                }
            } else if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 2) {
                if (this.xAplicaFiltroP == 0) {
                    this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `g_procedimiento`.`Id` in (1966127,1966128,1966129)) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
                } else {
                    this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) LEFT JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `g_procedimiento`.`Id` in (1966127,1966128,1966129)) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
                }
            }
        } else if (this.xAplicaFiltroP == 0) {
            this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
        } else {
            this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) LEFT JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
        }
        System.out.println(">>> " + this.xsql);
        this.xidprocedimiento = this.xct.llenarComboyLista(this.xsql, this.xidprocedimiento, this.JCBProcedimiento, 5);
        if (this.xidprocedimiento != null) {
            if (this.xidprocedimiento.length > 0) {
                this.JCBProcedimiento.setSelectedIndex(0);
            } else {
                this.JCBProcedimiento.setSelectedIndex(-1);
            }
        }
        this.xct.cerrarConexionBd();
        mCargarDatos();
        this.xlleno1 = true;
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Salud_Ocupacional.JIFAgenda.11
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIFAgenda.this.EstadoTarea.get()) {
                    JIFAgenda.this.mCargarDatos();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Salud Ocupacional");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Hora", "No. Historia", "Usuario", "Edad", "Sexo", "Estado", "NEstado", "Id_UsuarioS", "Id_Ingreso", "Id_Orden", "Id_Atencion", "IdTipoAtencion", "Empresa", "Accion Llamar", "Accion Atendido", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Salud_Ocupacional.JIFAgenda.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, JButton.class, JButton.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Salud_Ocupacional.JIFAgenda.13
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTBDatosAgenda;
        JTable jTable2 = this.JTBDatosAgenda;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda.doLayout();
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setMaxWidth(0);
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarDatos() {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCrearModeloTabla();
            if (this.JTF_Nombre.getText().isEmpty()) {
                if (this.xAplicaFiltroP == 0) {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF( g_procedimiento.`EsCita`=0, IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER','ATENDIDO'), IF( (IFNULL(h_atencion.`Codigo_Dxp`,'')='' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0) ,'POR ATENDER',  IF((IFNULL(h_atencion.`Codigo_Dxp`,'')<>'' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0), 'ATENDIDO HC' , 'ATENDIDO'))) AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `ingreso`.`Id_Atencion` AS IdAtencion,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio   ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM  `f_ordenes` INNER JOIN `f_itemordenesproced`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`FechaIngreso` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                } else {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF( g_procedimiento.`EsCita`=0, IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER','ATENDIDO'), IF( (IFNULL(h_atencion.`Codigo_Dxp`,'')='' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0) ,'POR ATENDER',  IF((IFNULL(h_atencion.`Codigo_Dxp`,'')<>'' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0), 'ATENDIDO HC' , 'ATENDIDO'))) AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `ingreso`.`Id_Atencion` AS IdAtencion,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio    ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `f_ordenes` INNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `ingreso`.`FechaIngreso` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                }
            } else if (this.xAplicaFiltroP == 0) {
                this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF( g_procedimiento.`EsCita`=0, IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER','ATENDIDO'), IF( (IFNULL(h_atencion.`Codigo_Dxp`,'')='' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0) ,'POR ATENDER',  IF((IFNULL(h_atencion.`Codigo_Dxp`,'')<>'' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0), 'ATENDIDO HC' , 'ATENDIDO'))) AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `ingreso`.`Id_Atencion` AS IdAtencion,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio    ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM   `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE ((CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
            } else {
                this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF( g_procedimiento.`EsCita`=0, IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER','ATENDIDO'), IF( (IFNULL(h_atencion.`Codigo_Dxp`,'')='' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0) ,'POR ATENDER',  IF((IFNULL(h_atencion.`Codigo_Dxp`,'')<>'' AND IFNULL(h_so_concepto_laboral.`Id`,0)=0), 'ATENDIDO HC' , 'ATENDIDO'))) AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `ingreso`.`Id_Atencion` AS IdAtencion,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio   ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM  `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
            }
            switch (this.estado) {
                case 0:
                    this.xsql += " and `f_itemordenesproced`.`EsRecepcionado`='0' ) ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
                case 1:
                    this.xsql += " and `f_itemordenesproced`.`EsRecepcionado`='1' ) ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
                case 2:
                    this.xsql += ") ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
            }
            System.out.println("cargar tabla agenda -> " + this.xsql);
            try {
                ResultSet rs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    int filaGrid = 0;
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(rs.getString("HoraIngreso"), filaGrid, 0);
                            this.xmodelo.setValueAt(rs.getString("NoHistoria"), filaGrid, 1);
                            this.xmodelo.setValueAt(rs.getString("NUsuario"), filaGrid, 2);
                            this.xmodelo.setValueAt(rs.getString("Edad"), filaGrid, 3);
                            this.xmodelo.setValueAt(rs.getString("NSexo"), filaGrid, 4);
                            this.xmodelo.setValueAt(rs.getString("NEstado"), filaGrid, 5);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("TEstado")), filaGrid, 6);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Usuario")), filaGrid, 7);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Ingreso")), filaGrid, 8);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Orden")), filaGrid, 9);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdAtencion")), filaGrid, 10);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_TipoAtencion")), filaGrid, 11);
                            this.xmodelo.setValueAt(rs.getString("convenio"), filaGrid, 12);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), filaGrid, 15);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), filaGrid, 16);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), filaGrid, 17);
                            buscaarPacientes(rs.getString("NoHistoria"));
                            if (this.num.intValue() == 0) {
                                this.xmodelo.setValueAt(new JButton("Llamar "), filaGrid, 13);
                            } else {
                                this.xmodelo.setValueAt(new JButton("Llamar " + this.num), filaGrid, 13);
                            }
                            this.xmodelo.setValueAt(new JButton("Atendido"), filaGrid, 14);
                            System.out.println(rs.getString("NoHistoria"));
                            this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                            filaGrid++;
                        }
                        this.txtCantidad.setText("" + filaGrid);
                    } else {
                        mCrearModeloTabla();
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        mCrearModeloTabla();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFAgenda$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            switch (table.getValueAt(row, 5).toString()) {
                case "POR ATENDER":
                    cell.setBackground(new Color(0, 0, 102));
                    cell.setForeground(Color.WHITE);
                    break;
                case "ATENDIDO":
                    cell.setBackground(new Color(103, 0, 103));
                    cell.setForeground(Color.WHITE);
                    break;
                case "ATENDIDO HC":
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setForeground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    private void primerPaciente() {
        try {
            this.xsql = "UPDATE ll_datos_basicos set Estado=1 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1) + "' AND Consultorio ='" + Principal.consultorio + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
