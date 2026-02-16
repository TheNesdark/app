package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.enfermeria.AgendaProcedimientosDAO;
import com.genoma.plus.dao.impl.enfermeria.AgendaProcedimientosDAOImpl;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendProcedimiento.class */
public class JIF_AgendProcedimiento extends JInternalFrame {
    private DefaultTableModel modeloProcedimientos;
    private AgendaProcedimientosDAO agendaProcedimientosDAO;
    private Long idIngreso;
    private Timer timer;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    public JDateChooser JD_Fecha;
    private JLabel JLB_NumeroRegistro;
    private JPanel JPIFiltro;
    private JPanel JPI_Filtro;
    private JScrollPane JSPDatosProcedimientos;
    private JTable JTBDatosProcedimiento;
    private JTextField JTFRuta;
    private JTextField JTF_Buscar;
    private JRadioButton btnPorAtender;
    private JRadioButton btnTodas;
    private JRadioButton tnAtendidas;
    private String estado = "0";
    private Metodos metodos = new Metodos();
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    @Generated
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Generated
    public void setModeloProcedimientos(DefaultTableModel modeloProcedimientos) {
        this.modeloProcedimientos = modeloProcedimientos;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setAgendaProcedimientosDAO(AgendaProcedimientosDAO agendaProcedimientosDAO) {
        this.agendaProcedimientosDAO = agendaProcedimientosDAO;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setEstadoTarea(AtomicBoolean EstadoTarea) {
        this.EstadoTarea = EstadoTarea;
    }

    @Generated
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJBTExportar(JButton JBTExportar) {
        this.JBTExportar = JBTExportar;
    }

    @Generated
    public void setJD_Fecha(JDateChooser JD_Fecha) {
        this.JD_Fecha = JD_Fecha;
    }

    @Generated
    public void setJLB_NumeroRegistro(JLabel JLB_NumeroRegistro) {
        this.JLB_NumeroRegistro = JLB_NumeroRegistro;
    }

    @Generated
    public void setJPIFiltro(JPanel JPIFiltro) {
        this.JPIFiltro = JPIFiltro;
    }

    @Generated
    public void setJPI_Filtro(JPanel JPI_Filtro) {
        this.JPI_Filtro = JPI_Filtro;
    }

    @Generated
    public void setJSPDatosProcedimientos(JScrollPane JSPDatosProcedimientos) {
        this.JSPDatosProcedimientos = JSPDatosProcedimientos;
    }

    @Generated
    public void setJTBDatosProcedimiento(JTable JTBDatosProcedimiento) {
        this.JTBDatosProcedimiento = JTBDatosProcedimiento;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJTF_Buscar(JTextField JTF_Buscar) {
        this.JTF_Buscar = JTF_Buscar;
    }

    @Generated
    public void setBtnPorAtender(JRadioButton btnPorAtender) {
        this.btnPorAtender = btnPorAtender;
    }

    @Generated
    public void setBtnTodas(JRadioButton btnTodas) {
        this.btnTodas = btnTodas;
    }

    @Generated
    public void setTnAtendidas(JRadioButton tnAtendidas) {
        this.tnAtendidas = tnAtendidas;
    }

    @Generated
    public String getEstado() {
        return this.estado;
    }

    @Generated
    public DefaultTableModel getModeloProcedimientos() {
        return this.modeloProcedimientos;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public AgendaProcedimientosDAO getAgendaProcedimientosDAO() {
        return this.agendaProcedimientosDAO;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public AtomicBoolean getEstadoTarea() {
        return this.EstadoTarea;
    }

    public JIF_AgendProcedimiento() {
        initComponents();
        springStart();
        nuevo();
        ejecutarTareaTimer();
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JD_Fecha = new JDateChooser();
        this.JPIFiltro = new JPanel();
        this.btnTodas = new JRadioButton();
        this.btnPorAtender = new JRadioButton();
        this.tnAtendidas = new JRadioButton();
        this.JTF_Buscar = new JTextField();
        this.JSPDatosProcedimientos = new JScrollPane();
        this.JTBDatosProcedimiento = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLB_NumeroRegistro = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA DE PROCEDIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_AgendProcedimiento.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendProcedimiento.this.formInternalFrameClosing(evt);
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
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JD_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JD_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JD_Fecha.setFont(new Font("Arial", 1, 12));
        this.JD_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_AgendProcedimiento.this.JD_FechaPropertyChange(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_Filtro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendProcedimiento.this.btnTodasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(Color.blue);
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendProcedimiento.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.tnAtendidas);
        this.tnAtendidas.setFont(new Font("Arial", 1, 12));
        this.tnAtendidas.setForeground(Color.blue);
        this.tnAtendidas.setText("Atendidas");
        this.tnAtendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.6
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendProcedimiento.this.tnAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.tnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas).addContainerGap(37, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.tnAtendidas).addComponent(this.btnTodas)).addContainerGap()));
        this.JTF_Buscar.setFont(new Font("Arial", 1, 12));
        this.JTF_Buscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Buscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.7
            public void keyPressed(KeyEvent evt) {
                JIF_AgendProcedimiento.this.JTF_BuscarKeyPressed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JD_Fecha, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Buscar, -2, 425, -2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_Buscar, -1, 50, 32767).addComponent(this.JD_Fecha, -1, 50, 32767).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -2, 50, 32767)).addGap(17, 17, 17)));
        this.JSPDatosProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTBDatosProcedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosProcedimiento.setRowHeight(25);
        this.JTBDatosProcedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosProcedimiento.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosProcedimiento.setSelectionMode(0);
        this.JTBDatosProcedimiento.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.8
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendProcedimiento.this.JTBDatosProcedimientoMouseClicked(evt);
            }
        });
        this.JSPDatosProcedimientos.setViewportView(this.JTBDatosProcedimiento);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.9
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendProcedimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.10
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendProcedimiento.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLB_NumeroRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NumeroRegistro.setFont(new Font("Arial", 1, 18));
        this.JLB_NumeroRegistro.setForeground(Color.red);
        this.JLB_NumeroRegistro.setHorizontalAlignment(0);
        this.JLB_NumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 516, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 211, -2).addGap(221, 221, 221).addComponent(this.JLB_NumeroRegistro, -2, 139, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDatosProcedimientos, GroupLayout.Alignment.LEADING, -1, 1094, 32767))).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosProcedimientos, -2, 459, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 48, 32767).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JLB_NumeroRegistro, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD_FechaPropertyChange(PropertyChangeEvent evt) {
        if (this.JD_Fecha.getDate() != null) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
        setEstado("0,1,2");
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        setEstado("0");
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tnAtendidasActionPerformed(ActionEvent evt) {
        setEstado("1,2");
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTBDatosProcedimiento.getSelectedRow() != -1) {
            setIdIngreso(Long.valueOf(getModeloProcedimientos().getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 11).toString()));
            Principal.claseenfer.cargarPantalla("Notas_Procedimiento");
            Principal.claseenfer.xjifvisitasdoc.xjppersona.txtHistoria.setText(getModeloProcedimientos().getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 12).toString());
            Principal.claseenfer.xjifvisitasdoc.xjppersona.buscar(2);
            Principal.claseenfer.xjifvisitasdoc.noHistoria = getModeloProcedimientos().getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 12).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_BuscarKeyPressed(KeyEvent evt) {
        if (!this.JTF_Buscar.getText().isEmpty()) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBDatosProcedimiento.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDatosProcedimiento, this.metodos.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaProcedimiento() {
        this.modeloProcedimientos = new DefaultTableModel(new Object[0], new String[]{"Fecha Hora", "Documento", "Usuario", "Sexo", "Edad", "Entidad", "idProcedimiento", "Nombre Procedimiento", "Estado", "idEstado", "idOrden", "idIngreso", "NHistoria", "Sede"}) { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.11
            private final Class<?>[] columnTypes = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Integer.class, Long.class, Long.class, String.class, String.class};
            private final boolean[] columnEditables = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class<?> getColumnClass(int columnIndex) {
                return this.columnTypes[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.columnEditables[columnIndex];
            }
        };
        this.JTBDatosProcedimiento.setModel(this.modeloProcedimientos);
        this.JTBDatosProcedimiento.setAutoResizeMode(0);
        this.JTBDatosProcedimiento.createDefaultColumnsFromModel();
        if (this.JTBDatosProcedimiento.getColumnModel().getColumnCount() > 0) {
            int[] columnWidths = {100, 100, 200, 50, 100, 200, 80, 200, 100, 80, 80, 80, 100, 150};
            for (int i = 0; i < columnWidths.length; i++) {
                this.JTBDatosProcedimiento.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
            }
        }
    }

    public void nuevo() {
        this.JD_Fecha.setDate(getMetodos().getFechaActual());
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        setEstado("0");
    }

    private void springStart() {
        this.agendaProcedimientosDAO = (AgendaProcedimientosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("agendaProcedimientosDAOImpl");
    }

    @Generated
    public Timer getTimer() {
        return this.timer;
    }

    private void ejecutarTareaTimer() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento.12
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendProcedimiento.this.EstadoTarea.get()) {
                    JIF_AgendProcedimiento.this.cargarDatos();
                } else {
                    Logger.getLogger(getClass().getName()).info("Finaliza ejecución del Timer de Agenda de Procedimientos Enfermería");
                    JIF_AgendProcedimiento.this.timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    private void detenerTimer() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
    }

    public void cargarDatos() {
        List<Object[]> listadoAtencionServicios = this.agendaProcedimientosDAO.listCargarProcedimientos(getMetodos().formatoAMD1.format(this.JD_Fecha.getDate()), getEstado(), this.JTF_Buscar.getText());
        mCargaAgendaServicios(listadoAtencionServicios);
    }

    private void mCargaAgendaServicios(List<Object[]> listadoList) {
        Integer numero = 0;
        crearTablaAgendaProcedimiento();
        this.JSPDatosProcedimientos.remove(this.JTBDatosProcedimiento);
        this.JSPDatosProcedimientos.setViewportView((Component) null);
        this.JSPDatosProcedimientos.repaint();
        if (listadoList.size() != -1) {
            this.metodos.mEstablecerTextEditor(this.JTBDatosProcedimiento, 0);
            this.metodos.mEstablecerTextEditor(this.JTBDatosProcedimiento, 2);
            this.metodos.mEstablecerTextEditor(this.JTBDatosProcedimiento, 4);
            this.metodos.mEstablecerTextEditor(this.JTBDatosProcedimiento, 5);
            this.metodos.mEstablecerTextEditor(this.JTBDatosProcedimiento, 7);
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloProcedimientos.addRow((Object[]) null);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[0], i, 0);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[1], i, 1);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[2], i, 2);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[3], i, 3);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[4], i, 4);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[5], i, 5);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[6], i, 6);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[7], i, 7);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[8], i, 8);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[9], i, 9);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[10], i, 10);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[11], i, 11);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[12], i, 12);
                this.modeloProcedimientos.setValueAt(listadoList.get(i)[13], i, 13);
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloProcedimientos.setRowCount(listadoList.size());
            this.modeloProcedimientos.fireTableDataChanged();
        }
        this.JLB_NumeroRegistro.setText("" + numero);
        this.JSPDatosProcedimientos.setViewportView(this.JTBDatosProcedimiento);
        this.JSPDatosProcedimientos.repaint();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendProcedimiento$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 9).toString()).intValue() != 0) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void actualizarEstadoAtencion() {
        this.agendaProcedimientosDAO.actualizarEstadoAtencion(getIdIngreso());
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JButton getJBTExportar() {
        return this.JBTExportar;
    }

    @Generated
    public JDateChooser getJD_Fecha() {
        return this.JD_Fecha;
    }

    @Generated
    public JLabel getJLB_NumeroRegistro() {
        return this.JLB_NumeroRegistro;
    }

    @Generated
    public JPanel getJPIFiltro() {
        return this.JPIFiltro;
    }

    @Generated
    public JPanel getJPI_Filtro() {
        return this.JPI_Filtro;
    }

    @Generated
    public JScrollPane getJSPDatosProcedimientos() {
        return this.JSPDatosProcedimientos;
    }

    @Generated
    public JTable getJTBDatosProcedimiento() {
        return this.JTBDatosProcedimiento;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JTextField getJTF_Buscar() {
        return this.JTF_Buscar;
    }

    @Generated
    public JRadioButton getBtnPorAtender() {
        return this.btnPorAtender;
    }

    @Generated
    public JRadioButton getBtnTodas() {
        return this.btnTodas;
    }

    @Generated
    public JRadioButton getTnAtendidas() {
        return this.tnAtendidas;
    }
}
