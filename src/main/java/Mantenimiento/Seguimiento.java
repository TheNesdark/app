package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/Seguimiento.class */
public class Seguimiento extends JInternalFrame {
    private String[] xidarea;
    private String[] xidtipo;
    private String[] xidestado;
    public DefaultTableModel xmodelo;
    public String sql;
    public Object[] dato;
    public claseMantenimiento Cmantenimiento;
    Color xcolor;
    private JComboBox JCBArea;
    private JComboBox JCBTipo;
    private JComboBox JCBestado;
    private JPanel JPDatosP;
    private JPanel JPEvaluacion;
    private JRadioButton JRBA;
    private JRadioButton JRBP;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDescripcion1;
    private JTextPane JTPDescripcion;
    private JTextPane JTPobservacion;
    private ButtonGroup buttonGroup1;
    private JDateChooser jDateChooser1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private ConsultasMySQL xconsulta2 = new ConsultasMySQL();
    private char xevaluacion = 'P';
    private Metodos Fecha = new Metodos();
    public boolean lleno = false;
    private Metodos xmetodo = new Metodos();

    public Seguimiento(String Ids) {
        initComponents();
        this.jDateChooser1.setDate(this.Fecha.getFechaActual());
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xidtipo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tiporeporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipo, this.JCBTipo);
        this.JCBTipo.setSelectedIndex(-1);
        this.xidestado = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipoestadoreporte WHERE (Estado =1)", this.xidestado, this.JCBestado);
        this.JCBestado.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        consultar(Ids);
        llenatabla();
        verifica();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPDatosP = new JPanel();
        this.JCBArea = new JComboBox();
        this.JCBTipo = new JComboBox();
        this.JSPDescripcion = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel1 = new JPanel();
        this.JPEvaluacion = new JPanel();
        this.JRBP = new JRadioButton();
        this.JRBA = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jPanel3 = new JPanel();
        this.jDateChooser1 = new JDateChooser();
        this.jPanel5 = new JPanel();
        this.JCBestado = new JComboBox();
        this.JSPDescripcion1 = new JScrollPane();
        this.JTPobservacion = new JTextPane();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SEGUIMIENTO REPORTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(961, 734));
        setMinimumSize(new Dimension(961, 734));
        setName("seguimiento");
        getContentPane().setLayout((LayoutManager) null);
        this.JPDatosP.setBorder(BorderFactory.createTitledBorder(""));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.setEnabled(false);
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipo.setEnabled(false);
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DEL REPORTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPDescripcion.setEditable(false);
        this.JTPDescripcion.setBorder(BorderFactory.createBevelBorder(0));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTPDescripcion);
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.jTable1.setRowHeight(25);
        this.jTable1.setSelectionBackground(new Color(255, 255, 255));
        this.jTable1.setSelectionForeground(new Color(255, 0, 0));
        this.jTable1.setSelectionMode(0);
        this.jTable1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Seguimiento.1
            public void mouseClicked(MouseEvent evt) {
                Seguimiento.this.jTable1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout JPDatosPLayout = new GroupLayout(this.JPDatosP);
        this.JPDatosP.setLayout(JPDatosPLayout);
        JPDatosPLayout.setHorizontalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPDatosPLayout.createSequentialGroup().addComponent(this.JCBArea, -2, 269, -2).addGap(18, 18, 18).addComponent(this.JCBTipo, -2, 247, -2))).addContainerGap()));
        JPDatosPLayout.setVerticalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipo, -2, -1, -2).addComponent(this.JCBArea, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcion, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 361, 32767)));
        getContentPane().add(this.JPDatosP);
        this.JPDatosP.setBounds(10, 11, 558, 680);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Seguimiento del Reporte", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JPEvaluacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Evaluación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPEvaluacion.setEnabled(false);
        this.buttonGroup1.add(this.JRBP);
        this.JRBP.setFont(new Font("Arial", 1, 12));
        this.JRBP.setSelected(true);
        this.JRBP.setText("P");
        this.JRBP.setEnabled(false);
        this.JRBP.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento.2
            public void actionPerformed(ActionEvent evt) {
                Seguimiento.this.JRBPActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBA);
        this.JRBA.setFont(new Font("Arial", 1, 12));
        this.JRBA.setText("C");
        this.JRBA.setEnabled(false);
        this.JRBA.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento.3
            public void actionPerformed(ActionEvent evt) {
                Seguimiento.this.JRBAActionPerformed(evt);
            }
        });
        GroupLayout JPEvaluacionLayout = new GroupLayout(this.JPEvaluacion);
        this.JPEvaluacion.setLayout(JPEvaluacionLayout);
        JPEvaluacionLayout.setHorizontalGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaluacionLayout.createSequentialGroup().addComponent(this.JRBP).addGap(18, 18, 18).addComponent(this.JRBA).addContainerGap(-1, 32767)));
        JPEvaluacionLayout.setVerticalGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaluacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBP).addComponent(this.JRBA))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Reporte", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel2.setEnabled(false);
        this.jTextField1.setEditable(false);
        this.jTextField1.setFont(new Font("Arial", 1, 18));
        this.jTextField1.setForeground(new Color(0, 0, 255));
        this.jTextField1.setBorder(new SoftBevelBorder(0));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jTextField1, -1, 166, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField1, -1, 31, 32767));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Reporte", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel3.setEnabled(false);
        this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser1.setEnabled(false);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jDateChooser1, -1, 268, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jDateChooser1, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Nuevo Estado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBestado.setFont(new Font("Arial", 1, 12));
        this.JCBestado.setBorder(BorderFactory.createBevelBorder(0));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBestado, GroupLayout.Alignment.TRAILING, 0, 288, 32767));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCBestado, -2, 27, -2).addContainerGap(-1, 32767)));
        this.JSPDescripcion1.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPobservacion.setBorder(BorderFactory.createBevelBorder(0));
        this.JTPobservacion.setFont(new Font("Arial", 1, 12));
        this.JTPobservacion.setCaretColor(new Color(255, 0, 0));
        this.JSPDescripcion1.setViewportView(this.JTPobservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion1, GroupLayout.Alignment.TRAILING, -1, 304, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPEvaluacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -1, -1, 32767)).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.JPEvaluacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDescripcion1, -1, 428, 32767)));
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(590, 10, 340, 680);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.jTable1.getSelectedRow() != -1) {
            this.JTPobservacion.setText(this.xmodelo.getValueAt(this.jTable1.getSelectedRow(), 2).toString());
            this.JTPobservacion.setForeground(new Color(255, 255, 255));
            this.JTPobservacion.setBackground(new Color(0, 102, 102));
            this.JTPobservacion.setEditable(false);
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Metodos xmt = new Metodos();
                String sql2 = "insert into m_seguimiento(Id_reporte, FechaSeguimiento, Observacion) values ('" + this.jTextField1.getText() + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + this.JTPobservacion.getText() + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql2));
                this.xconsulta.cerrarConexionBd();
                String sql3 = " UPDATE m_reporte set Id_EstadoReporte = '" + this.xidestado[this.JCBestado.getSelectedIndex()] + "' where Id = '" + this.jTextField1.getText() + "'";
                this.xconsulta.ejecutarSQL(sql3);
                this.xconsulta.cerrarConexionBd();
                llenatabla();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                if (this.JCBestado.getSelectedItem().equals("CONCLUIDA")) {
                    mandacorreo2();
                    mandacorreo3();
                } else {
                    mandacorreo();
                }
            }
        }
    }

    private void consultar(String Ids) {
        String cons = "SELECT     f_centrocosto.Nbre    , m_tiporeporte.Nbre    , m_reporte.TipoEvaluacion    , m_reporte.Id    , m_reporte.FechaR, m_reporte.DescripcionR, m_tipoestadoreporte.Nbre FROM    baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id)WHERE (m_reporte.Id = '" + Ids + "')";
        ResultSet Rf = this.xconsulta.traerRs(cons);
        System.out.print(cons);
        try {
            if (Rf.next()) {
                Rf.first();
                this.JCBArea.setSelectedItem(Rf.getString(1));
                this.JCBTipo.setSelectedItem(Rf.getString(2));
                if (Rf.getString(3).equals("P")) {
                    this.JRBP.setSelected(true);
                } else {
                    this.JRBA.setSelected(true);
                }
                this.jTextField1.setText(Rf.getString(4));
                this.jDateChooser1.setDate(Rf.getDate(5));
                this.JTPDescripcion.setText(Rf.getString(6));
                this.JCBestado.setSelectedItem(Rf.getString(7));
            }
            Rf.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mostrar(String Idd) {
        String cons = "select Observacion from baseserver.m_seguimiento where (Id_reporte = '" + Idd + "') ";
        ResultSet Rf = this.xconsulta.traerRs(cons);
        System.out.print(cons);
        try {
            if (Rf.next()) {
                Rf.first();
                this.JTPobservacion.setText(Rf.getString(1));
            }
            Rf.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mandacorreo() {
        String correo = "SELECT g_persona.Correo FROM baseserver.m_reporte INNER JOIN baseserver.g_persona ON (m_reporte.Id_UsuarioS = g_persona.Id) INNER JOIN baseserver.g_usuario ON (g_usuario.Id_persona = g_persona.Id) WHERE m_reporte.Id  = '" + this.jTextField1.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        this.xconsulta.cerrarConexionBd();
        String mensaje = "para el área de Logistica y Mantenimiento es muy importante su oportuna notificación, por tanto informamos que el reporte anexo a este correo se ha ingresado a nuestro sistema de planificación de mantenimiento.  Una vez demos por terminado el trabajo que originó esta solicitud, emitiremos una respuesta formal por parte de nuestra área. \n\nEl reporte # " + this.jTextField1.getText() + "\nque usted generó en la fecha : " + this.xmetodo.formatoDMA.format(this.jDateChooser1.getDate()) + "\nCambio al estado : " + this.JCBestado.getSelectedItem() + "\nCon la siguiente Observaion : " + this.JTPobservacion.getText();
        Email em = new Email();
        em.Send("logistica@fundacionpanzenu.org.co", mensaje, datos, "REPORTE DE MANTENIMIENTO");
        JOptionPane.showInternalMessageDialog(this, "Se Envio un correo al usuario que genero el reporte con el nuevo estado?", "ENVIO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mandacorreo2() {
        String correo = "SELECT g_persona.Correo FROM baseserver.m_reporte INNER JOIN baseserver.g_persona ON (m_reporte.Id_UsuarioS = g_persona.Id) INNER JOIN baseserver.g_usuario ON (g_usuario.Id_persona = g_persona.Id) WHERE m_reporte.Id  = '" + this.jTextField1.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        this.xconsulta.cerrarConexionBd();
        String mensaje = "Su reporte se ha realizdo satisfactoriamente.  Lo invitamos a continuar reportando los eventos detectados.  Cordialmente, Area de Logística y  Mantenimiento\n\nEl reporte # " + this.jTextField1.getText() + "\nque usted generó en la fecha : " + this.xmetodo.formatoDMA.format(this.jDateChooser1.getDate()) + "\nCambio al estado : " + this.JCBestado.getSelectedItem() + "\nCon la siguiente Observaion : " + this.JTPobservacion.getText();
        Email em = new Email();
        em.Send("logistica@fundacionpanzenu.org.co", mensaje, datos, "REPORTE DE MANTENIMIENTO");
        JOptionPane.showInternalMessageDialog(this, "Se Envio un correo al usuario que genero el reporte con el nuevo estado?", "ENVIO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mandacorreo3() {
        String correo = "SELECT g_persona.Correo FROM baseserver.m_reporte INNER JOIN baseserver.g_persona ON (m_reporte.Id_UsuarioS = g_persona.Id) INNER JOIN baseserver.g_usuario ON (g_usuario.Id_persona = g_persona.Id) WHERE m_reporte.Id  = '" + this.jTextField1.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        this.xconsulta.cerrarConexionBd();
        String mensaje = "Con el fin de medir el indice de satisfacción de los usuarios, lo invitamos a llenar la siguiente encuesta\nPor favor califique como excelente, bueno, regular o malo\n\n1. Como califica el servicio brindado por el área de Infraestructura?\n\n\n\n2. Como califica el tiempo de respuesta a su solicitud?\n\n\n\n ////////////////////////////////////////////////////////////////////////////////////////////////////////////\nEsta encuenta correspon al reporte # " + this.jTextField1.getText() + "\nque usted generó en la fecha : " + this.xmetodo.formatoDMA.format(this.jDateChooser1.getDate()) + "\nCambio al estado : " + this.JCBestado.getSelectedItem() + "\n\n\nMuchas Gracias. ";
        Email em = new Email();
        em.Send("logistica@fundacionpanzenu.org.co", mensaje, datos, "Encuesta Satisfaccion Reportes de Mantenimiento (Reenvie este correo)");
        JOptionPane.showInternalMessageDialog(this, "Se envio encuesta al usuario", "ENVIO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void verifica() {
        if (this.xidestado[this.JCBestado.getSelectedIndex()].equals("4")) {
            this.JCBestado.setEnabled(false);
            this.JTPobservacion.setEditable(false);
        }
    }

    private void llenatabla() {
        this.sql = "SELECT IDS, date_format( m_seguimiento.FechaSeguimiento,'%d/%m/%y'), Observacion from m_seguimiento where Id_reporte= '" + this.jTextField1.getText() + "'";
        crearGrid();
        cargarDatos(this.sql);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "fecha", "Observacion"}) { // from class: Mantenimiento.Seguimiento.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTable1.setModel(this.xmodelo);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(4);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(13);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    public final void cargarDatos(String dat) {
        ResultSet rs = this.xconsulta2.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta2.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta2.cerrarConexionBd();
    }
}
