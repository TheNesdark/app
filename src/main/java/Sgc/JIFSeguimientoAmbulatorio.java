package Sgc;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Historia.JPGestionHC;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
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

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFSeguimientoAmbulatorio.class */
public class JIFSeguimientoAmbulatorio extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private String nombreFormulario;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar14;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLTotal;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta13;
    private JTabbedPane JTPDetalle;
    private JPanel jPanel15;
    private final Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private final ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private final Metodos metodos = new Metodos();

    public JIFSeguimientoAmbulatorio(String nombreFormulario) {
        initComponents();
        nuevo();
        this.nombreFormulario = nombreFormulario;
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JLTotal = new JLabel();
        this.JTPDetalle = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel15 = new JPanel();
        this.JTFRuta13 = new JTextField();
        this.JBTExportar14 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE SOLICITUDES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifSeguimientoSolicitudes");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFSeguimientoAmbulatorio.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSeguimientoAmbulatorio.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFSeguimientoAmbulatorio.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSeguimientoAmbulatorio.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFSeguimientoAmbulatorio.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSeguimientoAmbulatorio.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JDFechaF.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFSeguimientoAmbulatorio.4
            public void keyPressed(KeyEvent evt) {
                JIFSeguimientoAmbulatorio.this.JDFechaFKeyPressed(evt);
            }
        });
        this.JLTotal.setBackground(new Color(255, 255, 255));
        this.JLTotal.setFont(new Font("Arial", 1, 18));
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTROS", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal, -2, 164, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 45, -2).addComponent(this.JDFechaF, -2, 45, -2)).addContainerGap(-1, 32767)).addComponent(this.JLTotal, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        this.JTPDetalle.setForeground(new Color(0, 103, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFSeguimientoAmbulatorio.5
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoAmbulatorio.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel15.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta13.setFont(new Font("Arial", 1, 12));
        this.JTFRuta13.setText("C:\\Genoma\\plantilla");
        this.JTFRuta13.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta13.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFSeguimientoAmbulatorio.6
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoAmbulatorio.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta13.addActionListener(new ActionListener() { // from class: Sgc.JIFSeguimientoAmbulatorio.7
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimientoAmbulatorio.this.JTFRuta13ActionPerformed(evt);
            }
        });
        this.JBTExportar14.setFont(new Font("Arial", 1, 12));
        this.JBTExportar14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar14.setText("Exportar");
        this.JBTExportar14.addActionListener(new ActionListener() { // from class: Sgc.JIFSeguimientoAmbulatorio.8
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimientoAmbulatorio.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
        this.jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta13, -2, 382, -2).addGap(40, 40, 40).addComponent(this.JBTExportar14, -2, 330, -2).addContainerGap(-1, 32767)));
        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta13, -2, 50, -2).addComponent(this.JBTExportar14, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 1010, 32767).addComponent(this.jPanel15, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 317, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel15, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDetalle.addTab("HISTORICO", this.JPIDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDetalle).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -2, 437, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Seguimiento", "Impresión Centralizada", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n != 0 && n == 1) {
                imprmir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta13.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta13.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta13.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta13.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFKeyPressed(KeyEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            cargarDatos();
            contarRegistros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            cargarDatos();
            contarRegistros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta13ActionPerformed(ActionEvent evt) {
    }

    private void nuevo() {
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.JTFRuta13.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = true;
    }

    public void imprmir() {
        JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString(), Integer.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString()), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString());
        xjd.setLocationRelativeTo(this);
        xjd.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Convenio", "Tipo Identificacion", "Documentacion", "Primer Apellido", "Segundo Apellido", "Primer Nombre", "Segundo NOmbre ", "Telefono", "Celular", "Cups", "Nombre Cups", "Fecha Orden", "Cantidad", "Especialidad", "Profesional", "Con Seguimiento", "idAtencion", "idUsuario", "idIngreso", "idTipoAtencion", "idTipoHistoria", "correoElectronico"}) { // from class: Sgc.JIFSeguimientoAmbulatorio.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(80);
    }

    public void cargarDatos() {
        String sql;
        try {
            crearModelo();
            if (this.nombreFormulario.equals("AutoGestión servicios ambulatorios")) {
                sql = "with maestra as (\n\tselect hi.Id id,\n\t\n\tfe.Nbre convenio,\n\t\n\tgp2.Id_TipoIdentificacion tipoIdenticacion,\n\t\n\tgp2.NoDocumento documento,\n\t\n\tgp2.Apellido1 primerApellido,\n\t\n\tgp2.Apellido2 segundoApellido,\n\t\n\tgp2.Nombre1 primerNombre,\n\t\n\tgp2.Nombre2 segundoNombre,\n\t\n\tgp2.Telefono telefono,\n\t\n\tgp2.Movil celular,\n\t\n\tgp.C_Homologado cups,\n\t\n\tgp.Nbre nombreCups,\n\t\n\tho.FechaOrden fechaOrden,\n\t\n\thi.Cantidad Cantidad,\n\t\n\tge.Nbre especialidad,\n\t\n\tconcat(gp4.Apellido1,' ',gp4.Apellido2,' ',gp4.Nombre1,' ',gp4.Nombre2) profesional,  ha.Id idAtencion\n\t, gp2.Id idUsuario\n\t, i.Id idIngreso\n\t, i.Id_TipoAtencion idTipoAtencion\n\t, cc.Id_Historia idTipoHistoria\n\t, gp2.Correo correoElectronico\n\t\n\tfrom ingreso i\n\t\n\tinner join g_usuario gu on (gu.Id_persona=i.Id_Usuario)\n\t\n\tinner join g_persona gp2 on(gp2.Id=gu.Id_persona)\n\t\n\tinner join h_atencion ha on (ha.Id_Ingreso = i.Id) inner join c_clasecita cc on (cc.Id=ha.Id_ClaseCita)\n\t\n\tinner join h_ordenes ho on (ho.Id_Atencion=ha.Id)\n\t\n\tinner join h_itemordenesproced hi on (hi.Id_HOrdenes=ho.Id)\n\t\n\tinner join g_procedimiento gp on (gp.Id=hi.Id_Procedimiento)\n\t\n\tinner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\n\t\n\tinner join g_profesional gp3 on (gp3.Id_Persona=ho.Id_Profesional)\n\t\n\tinner join g_persona gp4 on (gp4.Id=gp3.Id_Persona)\n\t\n\tinner join g_especialidad ge on (ge.Id=ho.Id_Especialidad)\n\t\n\twhere (fe.esAutoGestion =1\n      and  ho.Id_TipoA =1\n\t\n\tand ho.FechaOrden between '" + this.metodos.formatoAMD1.format(this.JDFechaI.getDate()) + "' and '" + this.metodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\n\t)\n),\nseguimiento as (\n\tselect \n\tcount(his.id) cantidad, his.idItemsProcedimiento \n\tfrom h_itemordenesproced_seguimiento his \n\tinner join maestra m on (m.id=his.idItemsProcedimiento)\n\tGROUP by his.idItemsProcedimiento \n\n)\nSELECT \nm.id,\n\t\n\tm.convenio,\n\t\n\tm.tipoIdenticacion,\n\t\n\tm.documento,\n\t\n\tm.primerApellido,\n\t\n\tm.segundoApellido,\n\t\n\tm.primerNombre,\n\t\n\tm.segundoNombre,\n\t\n\tm.telefono,\n\t\n\tm.celular,\n\t\n\tm.cups,\n\t\n\tm.nombreCups,\n\t\n\tm.fechaOrden,\n\t\n\tm.Cantidad,\n\t\n\tm.especialidad,\n\t\n\tm.profesional,\n\tif(s.cantidad is null, false,true) seguimiento,  m.idAtencion\n\t, m.idUsuario\n\t, m.idIngreso\n\t, m.idTipoAtencion\n\t, m.idTipoHistoria\n\t, m.correoElectronico \nfrom maestra m \nleft join seguimiento s on (m.id=s.idItemsProcedimiento)\norder by m.fechaOrden asc";
            } else {
                sql = "with maestra as (\n\tselect hi.Id id,\n\t\n\tfe.Nbre convenio,\n\t\n\tgp2.Id_TipoIdentificacion tipoIdenticacion,\n\t\n\tgp2.NoDocumento documento,\n\t\n\tgp2.Apellido1 primerApellido,\n\t\n\tgp2.Apellido2 segundoApellido,\n\t\n\tgp2.Nombre1 primerNombre,\n\t\n\tgp2.Nombre2 segundoNombre,\n\t\n\tgp2.Telefono telefono,\n\t\n\tgp2.Movil celular,\n\t\n\tgp.C_Homologado cups,\n\t\n\tgp.Nbre nombreCups,\n\t\n\tho.FechaOrden fechaOrden,\n\t\n\thi.Cantidad Cantidad,\n\t\n\tge.Nbre especialidad,\n\t\n\tconcat(gp4.Apellido1,' ',gp4.Apellido2,' ',gp4.Nombre1,' ',gp4.Nombre2) profesional,  ha.Id idAtencion\n\t, gp2.Id idUsuario\n\t, i.Id idIngreso\n\t, i.Id_TipoAtencion idTipoAtencion\n\t, cc.Id_Historia idTipoHistoria\n\t, gp2.Correo correoElectronico\n\t\n\tfrom ingreso i\n\t\n\tinner join g_usuario gu on (gu.Id_persona=i.Id_Usuario)\n\t\n\tinner join g_persona gp2 on(gp2.Id=gu.Id_persona)\n\t\n\tinner join h_atencion ha on (ha.Id_Ingreso = i.Id) inner join c_clasecita cc on (cc.Id=ha.Id_ClaseCita) \n\t\n\tinner join h_ordenes ho on (ho.Id_Atencion=ha.Id)\n\t\n\tinner join h_itemordenesproced hi on (hi.Id_HOrdenes=ho.Id)\n\t\n\tinner join g_procedimiento gp on (gp.Id=hi.Id_Procedimiento)\n\t\n\tinner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\n\t\n\tinner join g_profesional gp3 on (gp3.Id_Persona=ho.Id_Profesional)\n\t\n\tinner join g_persona gp4 on (gp4.Id=gp3.Id_Persona)\n\t\n\tinner join g_especialidad ge on (ge.Id=ho.Id_Especialidad)\n\t\n\twhere (gp.Seguimiento=1\n\t\n\tand ho.FechaOrden between '" + this.metodos.formatoAMD1.format(this.JDFechaI.getDate()) + "' and '" + this.metodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\n\t)\n),\nseguimiento as (\n\tselect \n\tcount(his.id) cantidad, his.idItemsProcedimiento \n\tfrom h_itemordenesproced_seguimiento his \n\tinner join maestra m on (m.id=his.idItemsProcedimiento)\n\tGROUP by his.idItemsProcedimiento \n\n)\nSELECT \nm.id,\n\t\n\tm.convenio,\n\t\n\tm.tipoIdenticacion,\n\t\n\tm.documento,\n\t\n\tm.primerApellido,\n\t\n\tm.segundoApellido,\n\t\n\tm.primerNombre,\n\t\n\tm.segundoNombre,\n\t\n\tm.telefono,\n\t\n\tm.celular,\n\t\n\tm.cups,\n\t\n\tm.nombreCups,\n\t\n\tm.fechaOrden,\n\t\n\tm.Cantidad,\n\t\n\tm.especialidad,\n\t\n\tm.profesional,\n\tif(s.cantidad is null, false,true) seguimiento ,  m.idAtencion\n\t, m.idUsuario\n\t, m.idIngreso\n\t, m.idTipoAtencion\n\t, m.idTipoHistoria\n\t, m.correoElectronico\nfrom maestra m \nleft join seguimiento s on (m.id=s.idItemsProcedimiento)\norder by m.fechaOrden asc";
            }
            System.out.println(sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                        this.xmt.mEstablecerTextEditor(this.JTDetalle, 11);
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.dato);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("id")), n, 0);
                            this.xmodelo.setValueAt(xrs.getString("convenio"), n, 1);
                            this.xmodelo.setValueAt(xrs.getString("tipoIdenticacion"), n, 2);
                            this.xmodelo.setValueAt(xrs.getString("documento"), n, 3);
                            this.xmodelo.setValueAt(xrs.getString("primerApellido"), n, 4);
                            this.xmodelo.setValueAt(xrs.getString("segundoApellido"), n, 5);
                            this.xmodelo.setValueAt(xrs.getString("primerNombre"), n, 6);
                            this.xmodelo.setValueAt(xrs.getString("segundoNombre"), n, 7);
                            this.xmodelo.setValueAt(xrs.getString("telefono"), n, 8);
                            this.xmodelo.setValueAt(xrs.getString("celular"), n, 9);
                            this.xmodelo.setValueAt(xrs.getString("cups"), n, 10);
                            this.xmodelo.setValueAt(xrs.getString("nombreCups"), n, 11);
                            this.xmodelo.setValueAt(xrs.getDate("fechaOrden"), n, 12);
                            this.xmodelo.setValueAt(xrs.getString("Cantidad"), n, 13);
                            this.xmodelo.setValueAt(xrs.getString("especialidad"), n, 14);
                            this.xmodelo.setValueAt(xrs.getString("profesional"), n, 15);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("seguimiento")), n, 16);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idAtencion")), n, 17);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idUsuario")), n, 18);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idIngreso")), n, 19);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idTipoAtencion")), n, 20);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idTipoHistoria")), n, 21);
                            this.xmodelo.setValueAt(xrs.getString("correoElectronico"), n, 22);
                            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                            n++;
                        }
                    }
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
                    this.xconsultasbd.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFSeguimientoAmbulatorio$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 16).toString());
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

    private void contarRegistros() {
        Integer filas = Integer.valueOf(this.JTDetalle.getRowCount());
        this.JLTotal.setText("" + filas);
    }
}
