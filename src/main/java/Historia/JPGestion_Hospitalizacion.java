package Historia;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGestion_Hospitalizacion.class */
public class JPGestion_Hospitalizacion extends JPanel {
    private String xid_atencion;
    private String xId_Ingreso;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String xsql;
    private String xcodigo_cie10;
    private String xnombre_cie10;
    private String xNombreLlamador;
    private String[][] xid_pabellon;
    private String[][] xid_cama;
    private boolean xlleno;
    private boolean xlleno1;
    private int xtipo;
    private String tipoAtencion;
    private Boolean forma;
    private JButton JBTGrabar;
    private JButton JBTGrabar1;
    private JComboBox JCB_ACama;
    private JComboBox JCB_APabellon;
    private JCheckBox JCHTipoAtencion;
    private JDateChooser JDC_AFecha;
    private JDateChooser JDC_OFechaS;
    private JDateChooser JDC_SFecha;
    private JLabel JLBNRegistroC;
    private JPanel JPIAsignacion;
    private JPanel JPIDSolicitud;
    private JPanel JPI_DOrden;
    private JScrollPane JSP_OObservacion;
    private JTextArea JTA_OObservacion;
    public JFormattedTextField JTFF_AHora;
    public JFormattedTextField JTFF_OHora;
    public JFormattedTextField JTFF_SHora;
    public JTextField JTF_ANProfesional;
    public JTextField JTF_OCDxP;
    public JTextField JTF_ONCodigoDxP;
    public JTextField JTF_ONProfesional;
    public JTextField JTF_SNProfesional1;

    public JPGestion_Hospitalizacion(String xid_atencion, Boolean forma) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xcodigo_cie10 = "";
        this.xnombre_cie10 = "";
        this.xNombreLlamador = "";
        this.xlleno = false;
        this.xlleno1 = false;
        this.xtipo = 0;
        this.tipoAtencion = "";
        initComponents();
        this.xid_atencion = xid_atencion;
        this.forma = forma;
        mNuevo();
    }

    public JPGestion_Hospitalizacion(String xid_atencion, String xcie10, String xncie10, int xtipo, String xi_ingreso, String xNombreLlamador, Boolean forma) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xcodigo_cie10 = "";
        this.xnombre_cie10 = "";
        this.xNombreLlamador = "";
        this.xlleno = false;
        this.xlleno1 = false;
        this.xtipo = 0;
        this.tipoAtencion = "";
        initComponents();
        this.xtipo = xtipo;
        this.xNombreLlamador = xNombreLlamador;
        this.xid_atencion = xid_atencion;
        this.xId_Ingreso = xi_ingreso;
        this.xcodigo_cie10 = xcie10;
        this.xnombre_cie10 = xncie10;
        this.forma = forma;
        if (!this.forma.booleanValue()) {
            this.JBTGrabar1.setVisible(false);
        }
        mNuevo();
        mBuscar_Informacion_BD();
    }

    private void initComponents() {
        this.JPI_DOrden = new JPanel();
        this.JDC_OFechaS = new JDateChooser();
        this.JTFF_OHora = new JFormattedTextField();
        this.JTF_ONProfesional = new JTextField();
        this.JTF_OCDxP = new JTextField();
        this.JTF_ONCodigoDxP = new JTextField();
        this.JSP_OObservacion = new JScrollPane();
        this.JTA_OObservacion = new JTextArea();
        this.JPIDSolicitud = new JPanel();
        this.JDC_SFecha = new JDateChooser();
        this.JTFF_SHora = new JFormattedTextField();
        this.JTF_SNProfesional1 = new JTextField();
        this.JPIAsignacion = new JPanel();
        this.JDC_AFecha = new JDateChooser();
        this.JTFF_AHora = new JFormattedTextField();
        this.JCB_APabellon = new JComboBox();
        this.JCB_ACama = new JComboBox();
        this.JTF_ANProfesional = new JTextField();
        this.JCHTipoAtencion = new JCheckBox();
        this.JBTGrabar = new JButton();
        this.JLBNRegistroC = new JLabel();
        this.JBTGrabar1 = new JButton();
        this.JPI_DOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ORDEN MEDICA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDC_OFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_OFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDC_OFechaS.setFont(new Font("Arial", 1, 12));
        this.JTFF_OHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_OHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_OHora.setFont(new Font("Tahoma", 1, 12));
        this.JTFF_OHora.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.1
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JTFF_OHoraActionPerformed(evt);
            }
        });
        this.JTFF_OHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPGestion_Hospitalizacion.2
            public void keyPressed(KeyEvent evt) {
                JPGestion_Hospitalizacion.this.JTFF_OHoraKeyPressed(evt);
            }
        });
        this.JTF_ONProfesional.setFont(new Font("Arial", 1, 12));
        this.JTF_ONProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_OCDxP.setFont(new Font("Arial", 1, 12));
        this.JTF_OCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_ONCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTF_ONCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSP_OObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_OObservacion.setColumns(20);
        this.JTA_OObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_OObservacion.setLineWrap(true);
        this.JTA_OObservacion.setRows(1);
        this.JTA_OObservacion.setTabSize(1);
        this.JTA_OObservacion.setBorder((Border) null);
        this.JSP_OObservacion.setViewportView(this.JTA_OObservacion);
        GroupLayout JPI_DOrdenLayout = new GroupLayout(this.JPI_DOrden);
        this.JPI_DOrden.setLayout(JPI_DOrdenLayout);
        JPI_DOrdenLayout.setHorizontalGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DOrdenLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DOrdenLayout.createSequentialGroup().addComponent(this.JDC_OFechaS, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_OHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_ONProfesional, -2, 543, -2)).addGroup(JPI_DOrdenLayout.createSequentialGroup().addComponent(this.JTF_OCDxP, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_ONCodigoDxP)).addComponent(this.JSP_OObservacion)).addContainerGap()));
        JPI_DOrdenLayout.setVerticalGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DOrdenLayout.createSequentialGroup().addGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ONProfesional, -2, -1, -2).addComponent(this.JTFF_OHora, -2, -1, -2)).addComponent(this.JDC_OFechaS, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_ONCodigoDxP, -2, -1, -2).addComponent(this.JTF_OCDxP, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_OObservacion, -1, 47, 32767)));
        this.JPIDSolicitud.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE SOLICITUD", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDC_SFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_SFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_SFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_SHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_SHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_SHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_SHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPGestion_Hospitalizacion.3
            public void keyPressed(KeyEvent evt) {
                JPGestion_Hospitalizacion.this.JTFF_SHoraKeyPressed(evt);
            }
        });
        this.JTF_SNProfesional1.setFont(new Font("Arial", 1, 12));
        this.JTF_SNProfesional1.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_SNProfesional1.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.4
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JTF_SNProfesional1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDSolicitudLayout = new GroupLayout(this.JPIDSolicitud);
        this.JPIDSolicitud.setLayout(JPIDSolicitudLayout);
        JPIDSolicitudLayout.setHorizontalGroup(JPIDSolicitudLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSolicitudLayout.createSequentialGroup().addContainerGap().addComponent(this.JDC_SFecha, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_SHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_SNProfesional1, -2, 548, -2).addContainerGap()));
        JPIDSolicitudLayout.setVerticalGroup(JPIDSolicitudLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSolicitudLayout.createSequentialGroup().addGroup(JPIDSolicitudLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDC_SFecha, -1, 45, 32767).addGroup(JPIDSolicitudLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_SNProfesional1).addComponent(this.JTFF_SHora))).addGap(0, 14, 32767)));
        this.JPIAsignacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ASIGNACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDC_AFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_AFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_AFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_AHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_AHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_AHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_AHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPGestion_Hospitalizacion.5
            public void keyPressed(KeyEvent evt) {
                JPGestion_Hospitalizacion.this.JTFF_AHoraKeyPressed(evt);
            }
        });
        this.JCB_APabellon.setFont(new Font("Arial", 1, 12));
        this.JCB_APabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_APabellon.addItemListener(new ItemListener() { // from class: Historia.JPGestion_Hospitalizacion.6
            public void itemStateChanged(ItemEvent evt) {
                JPGestion_Hospitalizacion.this.JCB_APabellonItemStateChanged(evt);
            }
        });
        this.JCB_APabellon.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.7
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JCB_APabellonActionPerformed(evt);
            }
        });
        this.JCB_ACama.setFont(new Font("Arial", 1, 12));
        this.JCB_ACama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_ACama.addItemListener(new ItemListener() { // from class: Historia.JPGestion_Hospitalizacion.8
            public void itemStateChanged(ItemEvent evt) {
                JPGestion_Hospitalizacion.this.JCB_ACamaItemStateChanged(evt);
            }
        });
        this.JTF_ANProfesional.setFont(new Font("Arial", 1, 12));
        this.JTF_ANProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_ANProfesional.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.9
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JTF_ANProfesionalActionPerformed(evt);
            }
        });
        this.JCHTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCHTipoAtencion.setSelected(true);
        this.JCHTipoAtencion.setText("Modificar Tipo de Atencion");
        this.JCHTipoAtencion.setEnabled(false);
        GroupLayout JPIAsignacionLayout = new GroupLayout(this.JPIAsignacion);
        this.JPIAsignacion.setLayout(JPIAsignacionLayout);
        JPIAsignacionLayout.setHorizontalGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAsignacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAsignacionLayout.createSequentialGroup().addComponent(this.JTF_ANProfesional).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHTipoAtencion)).addGroup(JPIAsignacionLayout.createSequentialGroup().addComponent(this.JDC_AFecha, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_AHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_APabellon, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCB_ACama, -2, 217, -2))).addContainerGap()));
        JPIAsignacionLayout.setVerticalGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAsignacionLayout.createSequentialGroup().addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDC_AFecha, -1, -1, 32767).addComponent(this.JCB_ACama, -2, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_AHora).addComponent(this.JCB_APabellon))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ANProfesional, -2, 45, -2).addComponent(this.JCHTipoAtencion)).addGap(19, 19, 19)));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar Orden");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.10
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistroC.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistroC.setForeground(new Color(255, 0, 0));
        this.JLBNRegistroC.setHorizontalAlignment(0);
        this.JLBNRegistroC.setBorder(BorderFactory.createTitledBorder((Border) null, "Registro N°", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTGrabar1.setText("Salir");
        this.JBTGrabar1.addActionListener(new ActionListener() { // from class: Historia.JPGestion_Hospitalizacion.11
            public void actionPerformed(ActionEvent evt) {
                JPGestion_Hospitalizacion.this.JBTGrabar1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DOrden, -1, -1, 32767).addComponent(this.JPIDSolicitud, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIAsignacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 273, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabar1, -2, 273, -2).addGap(41, 41, 41).addComponent(this.JLBNRegistroC, -2, 157, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DOrden, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDSolicitud, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIAsignacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 50, -2).addComponent(this.JBTGrabar1, -2, 50, -2)).addComponent(this.JLBNRegistroC, GroupLayout.Alignment.TRAILING, -2, 52, -2)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_SHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_SHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_AHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_AHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_OHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_OHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_APabellon.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCB_ACama.removeAllItems();
            if (this.JBTGrabar.isEnabled()) {
                this.xsql = "SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_camas`.`Disponible`, CObservacion FROM `f_camas` INNER JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1 AND `f_camas`.`Disponible` =0 AND `f_camas`.`Id_UnidadCamas` ='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][0] + "') ORDER BY `f_camas`.`Nbre` ASC ";
            } else {
                this.xsql = "SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_camas`.`Disponible`, CObservacion FROM `f_camas` INNER JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1 AND `f_camas`.`Disponible` =0 AND `f_camas`.`Id_UnidadCamas` ='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][0] + "') ORDER BY `f_camas`.`Nbre` ASC ";
            }
            this.xid_cama = xct1.llenarComboyLista(this.xsql, this.xid_cama, this.JCB_ACama, 4);
            this.JCB_ACama.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        switch (this.xtipo) {
            case 0:
                if (this.JLBNRegistroC.getText().isEmpty()) {
                    if (!this.JTF_OCDxP.getText().isEmpty()) {
                        if (!this.JTF_ONCodigoDxP.getText().isEmpty()) {
                            if (this.forma.booleanValue()) {
                                int x = JOptionPane.showConfirmDialog(Principal.clasehistoriace.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xJPEgresoUrgencias.xgestion_h, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x == 0) {
                                    mGrabarOrdenMedica();
                                    mBuscar_Informacion_BD();
                                }
                            } else {
                                int x2 = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x2 == 0) {
                                    mGrabarOrdenMedica();
                                    mBuscar_Informacion_BD();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "El Nombre Dx no pueder estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTF_ONCodigoDxP.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El Codigo Dx no pueder estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTF_OCDxP.requestFocus();
                    }
                } else if (this.forma.booleanValue()) {
                    int x3 = JOptionPane.showConfirmDialog(Principal.clasehistoriace.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xJPEgresoUrgencias.xgestion_h, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x3 == 0) {
                        mGrabarSolicitud();
                        mBuscar_Informacion_BD();
                    }
                } else {
                    int x4 = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x4 == 0) {
                        mGrabarSolicitud();
                        mBuscar_Informacion_BD();
                    }
                }
                break;
            case 3:
                if (!this.JLBNRegistroC.getText().isEmpty()) {
                    if (this.forma.booleanValue()) {
                        int x5 = JOptionPane.showConfirmDialog(Principal.clasehistoriace.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xJPEgresoUrgencias.xgestion_h, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x5 == 0) {
                            mGrabarSolicitud();
                            mBuscar_Informacion_BD();
                        }
                    } else {
                        int x6 = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x6 == 0) {
                            mGrabarSolicitud();
                            mBuscar_Informacion_BD();
                        }
                    }
                }
                break;
            case 4:
                if (!this.JLBNRegistroC.getText().isEmpty()) {
                    if (this.JCB_ACama.getSelectedIndex() != -1) {
                        int x7 = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x7 == 0) {
                            mGrabarAsignacion();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar la cama asignar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCB_ACama.requestFocus();
                    }
                }
                break;
            case 5:
                if (!this.JLBNRegistroC.getText().isEmpty() && this.JCB_ACama.getSelectedIndex() != -1) {
                    int x8 = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x8 == 0) {
                        mGrabarAsignacion();
                    }
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_SNProfesional1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ANProfesionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ACamaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCB_ACama.getSelectedIndex() != -1) {
            if (this.xid_cama[this.JCB_ACama.getSelectedIndex()][2].equals("1")) {
                this.JCHTipoAtencion.setSelected(false);
            } else {
                this.JCHTipoAtencion.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_OHoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabar1ActionPerformed(ActionEvent evt) {
        if (this.forma.booleanValue()) {
            Principal.clasehistoriace.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xJPEgresoUrgencias.xgestion_h.dispose();
        }
    }

    private void mGrabarOrdenMedica() {
        this.xsql = "insert into h_orden_hospitalizacion(`Id_Atencion`, `FechaH`, `Id_Profesional_O`, `Id_Especialidad_O`, `Dx_Cie10`, `Observacion`, `UsuarioS`) values('" + this.xid_atencion + "','" + this.xmt.formatoAMD.format(this.JDC_OFechaS.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_OHora.getValue()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JTF_OCDxP.getText() + "','" + this.JTA_OObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.JLBNRegistroC.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        if (this.xNombreLlamador.equals("xjifhistoriauh")) {
            this.xsql = "update h_orden_hospitalizacion  set `FechaS`='" + this.xmt.formatoAMD.format(this.JDC_SFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_SHora.getValue()) + "', `Id_Profesional_S`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', `Id_Especialidad_S`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' Where Id='" + this.JLBNRegistroC.getText() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mGrabarSolicitud() {
        this.xsql = "update h_orden_hospitalizacion  set `FechaS`='" + this.xmt.formatoAMD.format(this.JDC_SFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_SHora.getValue()) + "', `Id_Profesional_S`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', `Id_Especialidad_S`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' Where Id='" + this.JLBNRegistroC.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGrabarAsignacion() {
        if ("812005644".equals(Principal.informacionIps.getIdTipoIdentificacion()) || "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA".equals(Principal.informacionIps.getNombreIps())) {
            if (validarEstado()) {
                grabarAsignacionBase();
                mBuscar_Informacion_BD();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Falta egreso en tipo de atención actual : " + this.tipoAtencion + "</html>", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        grabarAsignacionBase();
        mBuscar_Informacion_BD();
    }

    public void grabarAsignacionBase() {
        this.xsql = "update h_orden_hospitalizacion  set `FechaA`='" + this.xmt.formatoAMD.format(this.JDC_SFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_SHora.getValue()) + "', `Id_Profesional_A`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', `Id_Especialidad_A`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', `Id_Cama`='" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "' Where Id='" + this.JLBNRegistroC.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update ingreso set `Id_TipoAtencion`='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][2] + "', `Cama`='" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "' where Id='" + this.xId_Ingreso + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_camas set `Disponible`=1  where Id='" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_orden_hospitalizacion_traslado( `IdOrdenHosp` , `Id_Atencion` , `Fecha_Ingreso` , `Id_CamaOrigen`) values('" + this.JLBNRegistroC.getText() + "','" + this.xid_atencion + "','" + this.xmt.formatoAMD.format(this.JDC_SFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_SHora.getValue()) + "','" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private boolean validarEstado() {
        boolean estado = false;
        try {
            String sql = "SELECT ingreso.Id, ingreso.Id_TipoAtencion\n, ifnull(h_egreso_atencion.Id,0) idEgreso, g_tipoatencion.Nbre as tipoAtencion\nfrom ingreso\ninner join g_tipoatencion on (g_tipoatencion.Id=ingreso.Id_TipoAtencion)\nleft join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Estado=1) \nand (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion)\nwhere ingreso.Id=" + this.xId_Ingreso;
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.tipoAtencion = rs.getString("tipoAtencion");
                if (!rs.getString("Id_TipoAtencion").equals(this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][2])) {
                    estado = rs.getLong("idEgreso") != 0;
                } else if (rs.getLong("idEgreso") == 0) {
                    estado = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPGestion_Hospitalizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JLBNRegistroC.setText("");
        switch (this.xtipo) {
            case 0:
                if (this.xNombreLlamador.equals("xjifhistoriauh")) {
                    this.JPIAsignacion.setVisible(false);
                } else {
                    this.JPIDSolicitud.setVisible(false);
                    this.JPIAsignacion.setVisible(false);
                }
                this.JBTGrabar.setText("Grabar Orden");
                break;
            case 3:
                this.JBTGrabar.setText("Guardar Solicitud");
                break;
            case 4:
            case 5:
                this.JBTGrabar.setText("Guardar Asignación");
                break;
        }
        this.JDC_OFechaS.setDate(this.xmt.getFechaActual());
        this.JTFF_OHora.setValue(this.xmt.getFechaActual());
        this.JDC_AFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_AHora.setValue(this.xmt.getFechaActual());
        this.JDC_SFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_SHora.setValue(this.xmt.getFechaActual());
        this.JTF_OCDxP.setText(this.xcodigo_cie10);
        this.JTF_ONCodigoDxP.setText(this.xnombre_cie10);
        this.JCB_APabellon.removeAllItems();
        this.xsql = "SELECT `f_unidadcama`.`Id`, `f_unidadcama`.`Nbre`, f_unidadcama.EsHosp, `f_unidadcama`.`idTipoAtencion` FROM `f_camas` INNER JOIN  `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1) GROUP BY `f_unidadcama`.`Id` ORDER BY `f_unidadcama`.`Nbre` ASC ";
        this.xid_pabellon = this.xct.llenarComboyLista(this.xsql, this.xid_pabellon, this.JCB_APabellon, 4);
        this.JCB_APabellon.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mBuscar_Informacion_BD() {
        try {
            this.xsql = "SELECT `h_orden_hospitalizacion`.`Id`,  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaH`,'%Y-%m-%d') AS `Fecha`, DATE_FORMAT(`h_orden_hospitalizacion`.`FechaH`,'%H:%m:%s') AS `Hora` , CONCAT(`profesional1`.`NProfesional`,' - ', `profesional1`.`Especialidad`) AS `Profesional` , `g_patologia`.`Id` , `g_patologia`.`Nbre` , `h_orden_hospitalizacion`.`Observacion` , IF(`h_orden_hospitalizacion`.`FechaS` IS NULL,  DATE_FORMAT(NOW(),'%Y-%m-%d'),  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaS`,'%Y-%m-%d')) AS `FEchaS` , IF(`h_orden_hospitalizacion`.`FechaS` IS NULL,  DATE_FORMAT(NOW(),'%H:%m:%s'),  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaS`,'%H:%m:%s') ) AS `HoraS`  , IF(`Profesional_Solicitante`.`Especialidad` IS NULL, '', CONCAT(`Profesional_Solicitante`.`NProfesional`,' - ',`Profesional_Solicitante`.`Especialidad` )) AS `PSolictante` , IF(`h_orden_hospitalizacion`.`FechaA` IS NULL,  DATE_FORMAT(NOW(),'%Y-%m-%d'),  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaA`,'%Y-%m-%d')) AS `FEchaA` , IF(`h_orden_hospitalizacion`.`FechaA` IS NULL,  DATE_FORMAT(NOW(),'%H:%m:%s'),  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaA`,'%H:%m:%s') ) AS `HoraA`  , IF(`PAsignado`.`Especialidad` IS NULL, '', CONCAT(`PAsignado`.`NProfesional`,' - ',`PAsignado`.`Especialidad` )) AS `PAsignado`     , IF(`f_unidadcama`.`Nbre`  IS NULL , '', `f_unidadcama`.`Nbre`) AS Pabellon , IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre` ) AS Cama     FROM  `profesional1` INNER JOIN `h_orden_hospitalizacion`  ON (`profesional1`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_O`) AND (`profesional1`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_O`) INNER JOIN h_atencion ON( h_orden_hospitalizacion.`Id_Atencion`=h_atencion.`Id`) INNER JOIN `ingreso` ON( ingreso.`Id`=h_atencion.`Id_Ingreso`) INNER JOIN `g_patologia`  ON (`h_orden_hospitalizacion`.`Dx_Cie10` = `g_patologia`.`Id`) LEFT JOIN `profesional1` AS `Profesional_Solicitante`  ON (`Profesional_Solicitante`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_S`) AND (`Profesional_Solicitante`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_S`) LEFT JOIN `profesional1` AS `PAsignado`  ON (`PAsignado`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_A`) AND (`PAsignado`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_A`)   LEFT JOIN `f_camas`  ON (`f_camas`.`Id` = `ingreso`.`Cama`)  LEFT JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`h_orden_hospitalizacion`.`Id_Atencion` ='" + this.xid_atencion + "' AND `h_orden_hospitalizacion`.`Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNRegistroC.setText(xrs.getString(1));
                this.JDC_OFechaS.setDate(xrs.getDate(2));
                this.JTFF_OHora.setText(xrs.getString(3));
                this.JTF_ONProfesional.setText(xrs.getString(4));
                this.JTF_OCDxP.setText(xrs.getString(5));
                this.JTF_ONCodigoDxP.setText(xrs.getString(6));
                this.JTA_OObservacion.setText(xrs.getString(7));
                this.JDC_SFecha.setDate(xrs.getDate(8));
                this.JTFF_SHora.setText(xrs.getString(9));
                this.JTF_SNProfesional1.setText(xrs.getString(10));
                this.JDC_AFecha.setDate(xrs.getDate(11));
                this.JTFF_AHora.setText(xrs.getString(12));
                this.JTF_ANProfesional.setText(xrs.getString(13));
                if (this.xtipo == 0) {
                    if (this.xNombreLlamador.equals("xjifhistoriauh")) {
                        if (!xrs.getString(4).equals("") && !xrs.getString(10).equals("")) {
                            this.JBTGrabar.setEnabled(false);
                        }
                    } else if (!xrs.getString(4).equals("")) {
                        this.JBTGrabar.setEnabled(false);
                    }
                } else if (this.xtipo == 3 && !xrs.getString(10).equals("")) {
                    this.JBTGrabar.setEnabled(false);
                } else if (this.xtipo == 4 && !xrs.getString(15).equals("")) {
                    this.JBTGrabar.setEnabled(false);
                } else if (this.xtipo == 5 && !xrs.getString(15).equals("")) {
                    this.JBTGrabar.setEnabled(false);
                }
                this.JCB_APabellon.setSelectedItem(xrs.getString(14));
                this.JCB_ACama.setSelectedItem(xrs.getString(15));
            } else {
                this.xsql = "SELECT `g_patologia`.`Id` , `g_patologia`.`Nbre` FROM `g_patologia` INNER JOIN  `h_atencion`  ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`) WHERE (`h_atencion`.`Id` ='" + this.xid_atencion + "') ";
                xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTF_OCDxP.setText(xrs.getString(1));
                    this.JTF_ONCodigoDxP.setText(xrs.getString(2));
                } else {
                    mNuevo();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestion_Hospitalizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
