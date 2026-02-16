package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JIFRadicacionDocClinico.class */
public class JIFRadicacionDocClinico extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloobs;
    private Object[] xdatos;
    private String xnombre;
    private boolean xlleno;
    private String[] xdocumentos;
    private JButton JBArchivar;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroCombo;
    private ButtonGroup JBGTipoDoc;
    private JButton JBGrabarObs;
    private JComboBox JCBTipoDoc;
    private JCheckBox JCHEstado;
    private JDateChooser JDFechaI;
    private JLabel JLArchiva;
    private JLabel JLRecibe;
    private JPanel JPFiltroTabla;
    private JPanel JPIDatos;
    private JPanel JPObservaciones;
    private JPanel JPTipoDoc;
    private JPanel JPTipoDocClinico;
    private JRadioButton JRBAyudaDX;
    private JRadioButton JRBDocClinico;
    private JRadioButton JRBSinArchivar;
    private JRadioButton JRBSinArchivar1;
    private JRadioButton JRBTodas;
    private JRadioButton JRBTodas1;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleObs;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionDoc;
    private JTable JTDetalle;
    private JTextField JTFNoHistoria;
    private JTextField JTFNombre;
    private JTable JTObservacion;
    private JTabbedPane JTPDatos;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xpresentacion = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFRadicacionDocClinico(String xnombre) {
        initComponents();
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        setName(xnombre);
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v87, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v96, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGTipoDoc = new ButtonGroup();
        this.JBGFiltroCombo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNoHistoria = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JCBTipoDoc = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JPFiltroTabla = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBSinArchivar = new JRadioButton();
        this.JTFNombre = new JTextField();
        this.JPTipoDocClinico = new JPanel();
        this.JRBDocClinico = new JRadioButton();
        this.JRBAyudaDX = new JRadioButton();
        this.JPTipoDoc = new JPanel();
        this.JRBTodas1 = new JRadioButton();
        this.JRBSinArchivar1 = new JRadioButton();
        this.JLRecibe = new JLabel();
        this.JLArchiva = new JLabel();
        this.JBArchivar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPObservaciones = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservacionDoc = new JTextArea();
        this.JSPDetalleObs = new JScrollPane();
        this.JTObservacion = new JTable();
        this.JBGrabarObs = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: General.JIFRadicacionDocClinico.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRadicacionDocClinico.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNoHistoria.setFont(new Font("Arial", 1, 12));
        this.JTFNoHistoria.setToolTipText("");
        this.JTFNoHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoHistoria.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.2
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JTFNoHistoriaActionPerformed(evt);
            }
        });
        this.JTFNoHistoria.addFocusListener(new FocusAdapter() { // from class: General.JIFRadicacionDocClinico.3
            public void focusLost(FocusEvent evt) {
                JIFRadicacionDocClinico.this.JTFNoHistoriaFocusLost(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.4
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de documento clínico", 0, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.JPFiltroTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFiltro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setText("Todos");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.5
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBSinArchivar);
        this.JRBSinArchivar.setFont(new Font("Arial", 1, 12));
        this.JRBSinArchivar.setText("Por Archivar");
        this.JRBSinArchivar.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.6
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBSinArchivarActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroTablaLayout = new GroupLayout(this.JPFiltroTabla);
        this.JPFiltroTabla.setLayout(JPFiltroTablaLayout);
        JPFiltroTablaLayout.setHorizontalGroup(JPFiltroTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroTablaLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addComponent(this.JRBSinArchivar).addContainerGap()));
        JPFiltroTablaLayout.setVerticalGroup(JPFiltroTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroTablaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPFiltroTablaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBSinArchivar))));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPTipoDocClinico.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Tipo Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFiltroCombo.add(this.JRBDocClinico);
        this.JRBDocClinico.setFont(new Font("Arial", 1, 12));
        this.JRBDocClinico.setSelected(true);
        this.JRBDocClinico.setText("Doc Clínico");
        this.JRBDocClinico.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.7
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBDocClinicoActionPerformed(evt);
            }
        });
        this.JBGFiltroCombo.add(this.JRBAyudaDX);
        this.JRBAyudaDX.setFont(new Font("Arial", 1, 12));
        this.JRBAyudaDX.setText("Ayuda DX");
        this.JRBAyudaDX.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.8
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBAyudaDXActionPerformed(evt);
            }
        });
        GroupLayout JPTipoDocClinicoLayout = new GroupLayout(this.JPTipoDocClinico);
        this.JPTipoDocClinico.setLayout(JPTipoDocClinicoLayout);
        JPTipoDocClinicoLayout.setHorizontalGroup(JPTipoDocClinicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDocClinicoLayout.createSequentialGroup().addComponent(this.JRBDocClinico).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBAyudaDX).addContainerGap()));
        JPTipoDocClinicoLayout.setVerticalGroup(JPTipoDocClinicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDocClinicoLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoDocClinicoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDocClinico).addComponent(this.JRBAyudaDX)).addContainerGap(-1, 32767)));
        this.JPTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoDoc.add(this.JRBTodas1);
        this.JRBTodas1.setFont(new Font("Arial", 1, 12));
        this.JRBTodas1.setSelected(true);
        this.JRBTodas1.setText("Físico");
        this.JRBTodas1.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.9
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBTodas1ActionPerformed(evt);
            }
        });
        this.JBGTipoDoc.add(this.JRBSinArchivar1);
        this.JRBSinArchivar1.setFont(new Font("Arial", 1, 12));
        this.JRBSinArchivar1.setText("Digital");
        this.JRBSinArchivar1.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.10
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JRBSinArchivar1ActionPerformed(evt);
            }
        });
        GroupLayout JPTipoDocLayout = new GroupLayout(this.JPTipoDoc);
        this.JPTipoDoc.setLayout(JPTipoDocLayout);
        JPTipoDocLayout.setHorizontalGroup(JPTipoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDocLayout.createSequentialGroup().addComponent(this.JRBTodas1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JRBSinArchivar1).addContainerGap()));
        JPTipoDocLayout.setVerticalGroup(JPTipoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoDocLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPTipoDocLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas1).addComponent(this.JRBSinArchivar1))));
        this.JLRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Recibe: ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLArchiva.setBorder(BorderFactory.createTitledBorder((Border) null, "Archiva: ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDoc, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoDocClinico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoHistoria, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 275, -2).addGap(0, 3, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLRecibe, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoDoc, -2, -1, -2).addGap(32, 32, 32).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPFiltroTabla, -2, -1, -2).addGap(89, 89, 89).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addComponent(this.JLArchiva, -1, -1, 32767)))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPTipoDocClinico, -2, 52, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDoc, -2, 51, -2).addComponent(this.JTFNoHistoria, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addComponent(this.JDFechaI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipoDoc, -2, -1, -2).addComponent(this.jScrollPane2, -2, 43, -2).addComponent(this.JPFiltroTabla, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(15, 15, 15))).addGap(8, 8, 8).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLArchiva, -1, 51, 32767).addComponent(this.JLRecibe, -1, -1, 32767))));
        this.JBArchivar.setFont(new Font("Arial", 1, 12));
        this.JBArchivar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.JBArchivar.setText("Archivar");
        this.JBArchivar.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.11
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JBArchivarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: General.JIFRadicacionDocClinico.12
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacionDocClinico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        this.JTAObservacionDoc.setColumns(20);
        this.JTAObservacionDoc.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionDoc.setLineWrap(true);
        this.JTAObservacionDoc.setRows(5);
        this.JTAObservacionDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAObservacionDoc);
        this.JSPDetalleObs.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTObservacion.setSelectionBackground(new Color(255, 255, 255));
        this.JTObservacion.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleObs.setViewportView(this.JTObservacion);
        this.JBGrabarObs.setFont(new Font("Arial", 1, 12));
        this.JBGrabarObs.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarObs.setText("Grabar");
        this.JBGrabarObs.addActionListener(new ActionListener() { // from class: General.JIFRadicacionDocClinico.13
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionDocClinico.this.JBGrabarObsActionPerformed(evt);
            }
        });
        GroupLayout JPObservacionesLayout = new GroupLayout(this.JPObservaciones);
        this.JPObservaciones.setLayout(JPObservacionesLayout);
        JPObservacionesLayout.setHorizontalGroup(JPObservacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObservacionesLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 408, -2).addGap(18, 18, 18).addComponent(this.JBGrabarObs, -2, 113, -2).addContainerGap(465, 32767)).addGroup(JPObservacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObservacionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleObs, -2, 994, -2).addContainerGap(-1, 32767))));
        JPObservacionesLayout.setVerticalGroup(JPObservacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObservacionesLayout.createSequentialGroup().addContainerGap().addGroup(JPObservacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane3, -1, 43, 32767).addComponent(this.JBGrabarObs, -1, -1, 32767)).addContainerGap(204, 32767)).addGroup(JPObservacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPObservacionesLayout.createSequentialGroup().addContainerGap(74, 32767).addComponent(this.JSPDetalleObs, -2, 162, -2).addContainerGap(22, 32767))));
        this.JTPDatos.addTab("OBSERVACIONES POR DOCUMENTO", this.JPObservaciones);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBArchivar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBArchivar, -2, 48, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JTFNoHistoria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JLRecibe.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
            this.JLArchiva.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JCBTipoDoc.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            mCargarDatosObs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBArchivarActionPerformed(ActionEvent evt) {
        mArchivar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArchivarActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoHistoriaFocusLost(FocusEvent evt) {
        mBuscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoHistoriaActionPerformed(ActionEvent evt) {
        mBuscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDocClinicoActionPerformed(ActionEvent evt) {
        mIniciarComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAyudaDXActionPerformed(ActionEvent evt) {
        mIniciarComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodas1ActionPerformed(ActionEvent evt) {
        this.xpresentacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArchivar1ActionPerformed(ActionEvent evt) {
        this.xpresentacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarObsActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > -1 && this.JTDetalle.getSelectedRow() > -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = " Insert into gd_radicacion_observacion (`Id_Documento` , `Observacion` , `UsuarioS`)  values ('" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "','" + this.JTAObservacionDoc.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosObs();
                this.JTAObservacionDoc.setText("");
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTPDatos.setSelectedIndex(0);
    }

    private void mBuscarUsuario() {
        this.JTFNombre.setText("");
        try {
            String sql = "SELECT `NUsuario` FROM `persona` WHERE (`NoHistoria` ='" + this.JTFNoHistoria.getText() + "')";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JTFNombre.setText(xrs.getString(1));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacionDocClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mArchivar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String sql = " update gd_radicacion_doc set Fecha_Entrada='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "', Id_rh_persona_gd='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',EstadoAlmacenado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe selccionar una fila", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xid = "";
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JTFNoHistoria.setText("");
        this.JCHEstado.setSelected(true);
        this.JTAObservacion.setText("");
        this.xestado = 1;
        this.JTFNombre.setText("");
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.JLArchiva.setText("");
        this.JLRecibe.setText("");
    }

    public void mGrabar() {
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (!this.JTFNoHistoria.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into gd_radicacion_doc (`FechaR` , `TipoDocumento`, `NHistoria` ,Nbre, `Observacion`, `Id_rh_persona`, `EstadoRecibido`,PresentacionDoc, UsuarioS)  values ('" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.JCBTipoDoc.getSelectedItem() + "','" + this.JTFNoHistoria.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xestado + "','" + this.xpresentacion + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el número de historia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNoHistoria.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe escoger un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDoc.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No. Historia", "Nombre", "Fecha Recibido", "Tipo Doc", "Observación", "Recibido", "Almacenado", "Presentación", "Fecha Almacenamiento", "Recibe", "Archiva"}) { // from class: General.JIFRadicacionDocClinico.14
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(6);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(6);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            if (this.JRBSinArchivar.isSelected()) {
                sql = "SELECT `gd_radicacion_doc`.`Id` ,`gd_radicacion_doc`.`NHistoria`,`gd_radicacion_doc`.`Nbre` , `gd_radicacion_doc`.`FechaR`, `gd_radicacion_doc`.`TipoDocumento`, `gd_radicacion_doc`.`Observacion`, `gd_radicacion_doc`.`EstadoRecibido` , `gd_radicacion_doc`.`EstadoAlmacenado` ,IF(gd_radicacion_doc.`PresentacionDoc`=0,'Físico','Digital') AS PresentacionDoc, `gd_radicacion_doc`.`Fecha_Entrada` AS FechAlmacenamiento ,`persona`.`NUsuario`  AS recibe , IF(`persona_1`.`NUsuario` IS NULL,'',`persona_1`.`NUsuario`) AS archiva  FROM `gd_radicacion_doc`   INNER JOIN `rh_tipo_persona_cargon`  ON (`gd_radicacion_doc`.`Id_rh_persona` = `rh_tipo_persona_cargon`.`Id`)  INNER JOIN `persona`   ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`)  LEFT JOIN  `persona` AS `persona_1` ON (`gd_radicacion_doc`.`Id_rh_persona_gd` = `persona_1`.`Id_persona`) WHERE (`gd_radicacion_doc`.`EstadoAlmacenado`=0) ORDER BY `gd_radicacion_doc`.`Id` DESC";
            } else {
                sql = "SELECT `gd_radicacion_doc`.`Id` ,`gd_radicacion_doc`.`NHistoria`,`gd_radicacion_doc`.`Nbre` , `gd_radicacion_doc`.`FechaR`, `gd_radicacion_doc`.`TipoDocumento`, `gd_radicacion_doc`.`Observacion`, `gd_radicacion_doc`.`EstadoRecibido` , `gd_radicacion_doc`.`EstadoAlmacenado` ,IF(gd_radicacion_doc.`PresentacionDoc`=0,'Físico','Digital') AS PresentacionDoc, `gd_radicacion_doc`.`Fecha_Entrada` AS FechAlmacenamiento, `persona`.`NUsuario`  AS recibe , IF(`persona_1`.`NUsuario` IS NULL,'',`persona_1`.`NUsuario`) AS archiva  FROM `gd_radicacion_doc`   INNER JOIN `rh_tipo_persona_cargon`  ON (`gd_radicacion_doc`.`Id_rh_persona` = `rh_tipo_persona_cargon`.`Id`)  INNER JOIN `persona`   ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`)  LEFT JOIN  `persona` AS `persona_1` ON (`gd_radicacion_doc`.`Id_rh_persona_gd` = `persona_1`.`Id_persona`)  ORDER BY `gd_radicacion_doc`.`Id` DESC";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            TableColumnModel cmodel = this.JTDetalle.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(5).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(5).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacionDocClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosObs() {
        this.xmodeloobs = new DefaultTableModel(new Object[0], new String[]{"Observación", "Fecha"}) { // from class: General.JIFRadicacionDocClinico.15
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTObservacion.setModel(this.xmodeloobs);
        this.JTObservacion.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTObservacion.getColumnModel().getColumn(1).setPreferredWidth(20);
    }

    private void mCargarDatosObs() {
        try {
            mCrearModeloDatosObs();
            String sql = "SELECT `Observacion` , `Fecha` FROM `gd_radicacion_observacion` WHERE (`Id_Documento` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "')  ORDER BY Fecha DESC";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            TableColumnModel cmodel = this.JTObservacion.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(0).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloobs.addRow(this.xdatos);
                    this.xmodeloobs.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloobs.setValueAt(xrs.getString(2), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacionDocClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.JRBDocClinico.isSelected()) {
            this.JCBTipoDoc.removeAllItems();
            this.xdocumentos = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipodocumentoshc` WHERE (`Estado` =0) ORDER BY Nbre", this.xdocumentos, this.JCBTipoDoc);
            this.JCBTipoDoc.setSelectedIndex(-1);
        } else {
            this.JCBTipoDoc.removeAllItems();
            this.xdocumentos = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipoayudadx` WHERE (`Estado` =0) ORDER BY Nbre", this.xdocumentos, this.JCBTipoDoc);
            this.JCBTipoDoc.setSelectedIndex(-1);
        }
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        if (this.xnombre.equals("Archivar Documentos Clínicos")) {
            this.JBArchivar.setEnabled(true);
        } else {
            this.JBArchivar.setEnabled(false);
        }
    }
}
