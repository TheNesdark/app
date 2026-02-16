package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEcografiaPelvica.class */
public class JPAEcografiaPelvica extends JPanel {
    private String xnombre;
    private clasesHistoriaCE xclase;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    String[] xpresentacion;
    private String xidecografia;
    private ButtonGroup JBGMiometrio;
    private ButtonGroup JBGTipo;
    private JButton JBTGuardar;
    private JComboBox JCBUPosicion;
    private JPanel JPDerecho;
    private JPanel JPEcografia;
    private JPanel JPHistorico;
    private JPanel JPIIzquierdo;
    private JPanel JPIOvario;
    private JPanel JPTipo;
    private JPanel JPUMiometrio;
    private JPanel JPUtero;
    private JRadioButton JRBTransAbdominal;
    private JRadioButton JRBTransvaginal;
    private JRadioButton JRBUHeterogeneo;
    private JRadioButton JRBUHomogeneo;
    private JScrollPane JSPHistorico;
    private JTextArea JTAConclusion;
    public JTable JTDetalleHistorico;
    private JFormattedTextField JTFFODAnteroP;
    private JFormattedTextField JTFFODLongitud;
    private JFormattedTextField JTFFODTranverso;
    private JFormattedTextField JTFFOIAnteroP;
    private JFormattedTextField JTFFOILongitud;
    private JFormattedTextField JTFFOITranverso;
    private JFormattedTextField JTFFUAnteroP;
    private JFormattedTextField JTFFUEndometrio;
    private JFormattedTextField JTFFULongitud;
    private JFormattedTextField JTFFUTranverso;
    private JTabbedPane JTPEcografias;
    private JScrollPane jScrollPane1;
    private int estado = 2;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xtipoe = 1;
    private String xumiometrio = "NO APLICA";

    public JPAEcografiaPelvica(String nombre, clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        this.xnombre = nombre;
        mNuevo();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v175, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGMiometrio = new ButtonGroup();
        this.JTPEcografias = new JTabbedPane();
        this.JPEcografia = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBTransAbdominal = new JRadioButton();
        this.JRBTransvaginal = new JRadioButton();
        this.JBTGuardar = new JButton();
        this.JPUtero = new JPanel();
        this.JCBUPosicion = new JComboBox();
        this.JTFFULongitud = new JFormattedTextField();
        this.JTFFUAnteroP = new JFormattedTextField();
        this.JTFFUTranverso = new JFormattedTextField();
        this.JTFFUEndometrio = new JFormattedTextField();
        this.JPUMiometrio = new JPanel();
        this.JRBUHomogeneo = new JRadioButton();
        this.JRBUHeterogeneo = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConclusion = new JTextArea();
        this.JPIOvario = new JPanel();
        this.JPDerecho = new JPanel();
        this.JTFFODLongitud = new JFormattedTextField();
        this.JTFFODAnteroP = new JFormattedTextField();
        this.JTFFODTranverso = new JFormattedTextField();
        this.JPIIzquierdo = new JPanel();
        this.JTFFOILongitud = new JFormattedTextField();
        this.JTFFOIAnteroP = new JFormattedTextField();
        this.JTFFOITranverso = new JFormattedTextField();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setName("jpaecografiapelvica");
        this.JTPEcografias.setForeground(new Color(255, 0, 0));
        this.JTPEcografias.setFont(new Font("Arial", 1, 14));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGTipo.add(this.JRBTransAbdominal);
        this.JRBTransAbdominal.setFont(new Font("Arial", 1, 12));
        this.JRBTransAbdominal.setText("Transvaginal");
        this.JRBTransAbdominal.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaPelvica.1
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaPelvica.this.JRBTransAbdominalActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBTransvaginal);
        this.JRBTransvaginal.setFont(new Font("Arial", 1, 12));
        this.JRBTransvaginal.setSelected(true);
        this.JRBTransvaginal.setText("TransAbdominal");
        this.JRBTransvaginal.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaPelvica.2
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaPelvica.this.JRBTransvaginalActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPTipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTransvaginal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTransAbdominal).addContainerGap(89, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTransAbdominal, -2, 23, -2).addComponent(this.JRBTransvaginal)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaPelvica.3
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaPelvica.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JPUtero.setBorder(BorderFactory.createTitledBorder((Border) null, "UTERO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUPosicion.setFont(new Font("Arial", 1, 12));
        this.JCBUPosicion.setModel(new DefaultComboBoxModel(new String[]{"NO APLICA", "AVF", "RVF", "AV", "RV"}));
        this.JCBUPosicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Posición", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFULongitud.setBorder(BorderFactory.createTitledBorder((Border) null, "Longitud(mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFULongitud.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFULongitud.setHorizontalAlignment(4);
        this.JTFFULongitud.setFont(new Font("Arial", 1, 12));
        this.JTFFULongitud.setValue(new Integer(0));
        this.JTFFUAnteroP.setBorder(BorderFactory.createTitledBorder((Border) null, "AP (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFUAnteroP.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFUAnteroP.setHorizontalAlignment(4);
        this.JTFFUAnteroP.setFont(new Font("Arial", 1, 12));
        this.JTFFUAnteroP.setValue(new Integer(0));
        this.JTFFUTranverso.setBorder(BorderFactory.createTitledBorder((Border) null, "Transverso (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFUTranverso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFUTranverso.setHorizontalAlignment(4);
        this.JTFFUTranverso.setFont(new Font("Arial", 1, 12));
        this.JTFFUTranverso.setValue(new Integer(0));
        this.JTFFUEndometrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Endometrio (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFUEndometrio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFUEndometrio.setHorizontalAlignment(4);
        this.JTFFUEndometrio.setFont(new Font("Arial", 1, 12));
        this.JTFFUEndometrio.setValue(new Integer(0));
        this.JPUMiometrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Miometrio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGMiometrio.add(this.JRBUHomogeneo);
        this.JRBUHomogeneo.setFont(new Font("Arial", 1, 12));
        this.JRBUHomogeneo.setSelected(true);
        this.JRBUHomogeneo.setText("HOMOGENEO");
        this.JRBUHomogeneo.setToolTipText("");
        this.JRBUHomogeneo.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaPelvica.4
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaPelvica.this.JRBUHomogeneoActionPerformed(evt);
            }
        });
        this.JBGMiometrio.add(this.JRBUHeterogeneo);
        this.JRBUHeterogeneo.setFont(new Font("Arial", 1, 12));
        this.JRBUHeterogeneo.setText("HETEROGENEO");
        this.JRBUHeterogeneo.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaPelvica.5
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaPelvica.this.JRBUHeterogeneoActionPerformed(evt);
            }
        });
        GroupLayout JPUMiometrioLayout = new GroupLayout(this.JPUMiometrio);
        this.JPUMiometrio.setLayout(JPUMiometrioLayout);
        JPUMiometrioLayout.setHorizontalGroup(JPUMiometrioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUMiometrioLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBUHomogeneo).addGap(18, 18, 18).addComponent(this.JRBUHeterogeneo).addContainerGap(-1, 32767)));
        JPUMiometrioLayout.setVerticalGroup(JPUMiometrioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUMiometrioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUHeterogeneo, -2, 23, -2).addComponent(this.JRBUHomogeneo)));
        GroupLayout JPUteroLayout = new GroupLayout(this.JPUtero);
        this.JPUtero.setLayout(JPUteroLayout);
        JPUteroLayout.setHorizontalGroup(JPUteroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUteroLayout.createSequentialGroup().addContainerGap().addGroup(JPUteroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUteroLayout.createSequentialGroup().addComponent(this.JCBUPosicion, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFULongitud, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFUAnteroP, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFUTranverso, -2, 130, -2)).addGroup(JPUteroLayout.createSequentialGroup().addComponent(this.JPUMiometrio, -2, -1, -2).addGap(45, 45, 45).addComponent(this.JTFFUEndometrio, -2, 130, -2))).addContainerGap(52, 32767)));
        JPUteroLayout.setVerticalGroup(JPUteroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUteroLayout.createSequentialGroup().addContainerGap().addGroup(JPUteroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBUPosicion, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPUteroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFULongitud, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JTFFUAnteroP).addComponent(this.JTFFUTranverso))).addGap(18, 18, 18).addGroup(JPUteroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPUMiometrio, -2, 43, -2).addComponent(this.JTFFUEndometrio, -2, 50, -2)).addContainerGap(16, 32767)));
        this.JTFFULongitud.getAccessibleContext().setAccessibleName("120");
        this.JTFFUAnteroP.getAccessibleContext().setAccessibleName("120");
        this.JTFFUTranverso.getAccessibleContext().setAccessibleName("120");
        this.JTAConclusion.setColumns(1);
        this.JTAConclusion.setFont(new Font("Arial", 1, 12));
        this.JTAConclusion.setRows(1);
        this.JTAConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Conclusión", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAConclusion);
        this.JPIOvario.setBorder(BorderFactory.createTitledBorder((Border) null, "OVARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDerecho.setBorder(BorderFactory.createTitledBorder((Border) null, "Derecho", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFODLongitud.setBorder(BorderFactory.createTitledBorder((Border) null, "Longitud(mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFODLongitud.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFODLongitud.setHorizontalAlignment(4);
        this.JTFFODLongitud.setFont(new Font("Arial", 1, 12));
        this.JTFFODLongitud.setValue(new Integer(0));
        this.JTFFODAnteroP.setBorder(BorderFactory.createTitledBorder((Border) null, "AP (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFODAnteroP.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFODAnteroP.setHorizontalAlignment(4);
        this.JTFFODAnteroP.setFont(new Font("Arial", 1, 12));
        this.JTFFODAnteroP.setValue(new Integer(0));
        this.JTFFODTranverso.setBorder(BorderFactory.createTitledBorder((Border) null, "Transverso (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFODTranverso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFODTranverso.setHorizontalAlignment(4);
        this.JTFFODTranverso.setFont(new Font("Arial", 1, 12));
        this.JTFFODTranverso.setValue(new Integer(0));
        GroupLayout JPDerechoLayout = new GroupLayout(this.JPDerecho);
        this.JPDerecho.setLayout(JPDerechoLayout);
        JPDerechoLayout.setHorizontalGroup(JPDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 408, 32767).addGroup(JPDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFODLongitud, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFODAnteroP, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFODTranverso, -2, 120, -2).addContainerGap(-1, 32767))));
        JPDerechoLayout.setVerticalGroup(JPDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 66, 32767).addGroup(JPDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDerechoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFODLongitud, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JTFFODAnteroP).addComponent(this.JTFFODTranverso)).addContainerGap(-1, 32767))));
        this.JPIIzquierdo.setBorder(BorderFactory.createTitledBorder((Border) null, "Izquierdo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFOILongitud.setBorder(BorderFactory.createTitledBorder((Border) null, "Longitud(mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFOILongitud.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFOILongitud.setHorizontalAlignment(4);
        this.JTFFOILongitud.setFont(new Font("Arial", 1, 12));
        this.JTFFOILongitud.setValue(new Integer(0));
        this.JTFFOIAnteroP.setBorder(BorderFactory.createTitledBorder((Border) null, "AP (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFOIAnteroP.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFOIAnteroP.setHorizontalAlignment(4);
        this.JTFFOIAnteroP.setFont(new Font("Arial", 1, 12));
        this.JTFFOIAnteroP.setValue(new Integer(0));
        this.JTFFOITranverso.setBorder(BorderFactory.createTitledBorder((Border) null, "Transverso (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFOITranverso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFOITranverso.setHorizontalAlignment(4);
        this.JTFFOITranverso.setFont(new Font("Arial", 1, 12));
        this.JTFFOITranverso.setValue(new Integer(0));
        GroupLayout JPIIzquierdoLayout = new GroupLayout(this.JPIIzquierdo);
        this.JPIIzquierdo.setLayout(JPIIzquierdoLayout);
        JPIIzquierdoLayout.setHorizontalGroup(JPIIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 408, 32767).addGroup(JPIIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFOILongitud, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFOIAnteroP, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFOITranverso, -2, 120, -2).addContainerGap(-1, 32767))));
        JPIIzquierdoLayout.setVerticalGroup(JPIIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 66, 32767).addGroup(JPIIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIzquierdoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFOILongitud, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JTFFOIAnteroP).addComponent(this.JTFFOITranverso)).addContainerGap(-1, 32767))));
        GroupLayout JPIOvarioLayout = new GroupLayout(this.JPIOvario);
        this.JPIOvario.setLayout(JPIOvarioLayout);
        JPIOvarioLayout.setHorizontalGroup(JPIOvarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOvarioLayout.createSequentialGroup().addContainerGap().addGroup(JPIOvarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDerecho, -2, -1, -2).addComponent(this.JPIIzquierdo, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPIOvarioLayout.setVerticalGroup(JPIOvarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOvarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDerecho, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIIzquierdo, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout JPEcografiaLayout = new GroupLayout(this.JPEcografia);
        this.JPEcografia.setLayout(JPEcografiaLayout);
        JPEcografiaLayout.setHorizontalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPTipo, -2, -1, -2).addComponent(this.JPUtero, -2, -1, -2).addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTGuardar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPEcografiaLayout.createSequentialGroup().addComponent(this.JPIOvario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 322, -2)))).addContainerGap(-1, 32767)));
        JPEcografiaLayout.setVerticalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPUtero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIOvario, -2, -1, -2).addComponent(this.jScrollPane1, -2, 179, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGuardar, -2, 48, -2).addContainerGap(14, 32767)));
        this.JTPEcografias.addTab("ECOGRAFÍA", this.JPEcografia);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPAEcografiaPelvica.6
            public void mouseClicked(MouseEvent evt) {
                JPAEcografiaPelvica.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 784, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(251, 32767)));
        this.JTPEcografias.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPEcografias, -2, 809, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEcografias)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xidecografia = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTransvaginalActionPerformed(ActionEvent evt) {
        this.xtipoe = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTransAbdominalActionPerformed(ActionEvent evt) {
        this.xtipoe = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUHomogeneoActionPerformed(ActionEvent evt) {
        this.xumiometrio = this.JRBUHomogeneo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUHeterogeneoActionPerformed(ActionEvent evt) {
        this.xumiometrio = this.JRBUHeterogeneo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mNuevo() {
        this.JRBTransAbdominal.setSelected(true);
        this.xtipoe = 1;
        this.JCBUPosicion.setSelectedItem("NO APLICA");
        this.JTFFULongitud.setValue(new Double(0.0d));
        this.JTFFUAnteroP.setValue(new Double(0.0d));
        this.JTFFUTranverso.setValue(new Double(0.0d));
        this.JTFFUEndometrio.setValue(new Double(0.0d));
        this.JRBUHeterogeneo.setSelected(false);
        this.JRBUHomogeneo.setSelected(false);
        this.xumiometrio = "NO APLICA";
        this.JTFFODLongitud.setValue(new Double(0.0d));
        this.JTFFODAnteroP.setValue(new Double(0.0d));
        this.JTFFODTranverso.setValue(new Double(0.0d));
        this.JTFFOILongitud.setValue(new Double(0.0d));
        this.JTFFOIAnteroP.setValue(new Double(0.0d));
        this.JTFFOITranverso.setValue(new Double(0.0d));
        this.JTAConclusion.setText("");
        this.JRBTransAbdominal.requestFocus();
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "COMFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO h_ecog_obstetrica (`Id_Atencion` , `TipoE` , `UPosicion` , `ULongitud` , `UAnteroPosterior` , `UTranverso` , `UMiometrio`  , `UEndometrio`  , `OLongitudD` , `OAnteroPosteriorD` , `OTransversoD` , `OLongitudI`  , `OAnteroPosteriorI` , `OTransversoI`  , `Conclusion` , `UsuarioS` )values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xtipoe + "','" + this.JCBUPosicion.getSelectedItem() + "','" + this.JTFFULongitud.getValue() + "','" + this.JTFFUAnteroP.getValue() + "','" + this.JTFFUTranverso.getValue() + "','" + this.xumiometrio + "','" + this.JTFFUEndometrio.getValue() + "','" + this.JTFFODLongitud.getValue() + "','" + this.JTFFODAnteroP.getValue() + "','" + this.JTFFODTranverso.getValue() + "','" + this.JTFFOILongitud.getValue() + "','" + this.JTFFOIAnteroP.getValue() + "','" + this.JTFFOITranverso.getValue() + "','" + this.JTAConclusion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xidecografia = this.xconsultasbd.ejecutarSQLId(sql);
            this.xconsultasbd.cerrarConexionBd();
            mImprimir();
            this.xclase.mCambiarEstadoHc(1);
            this.xclase.mCambiarEstadoCita();
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional"}) { // from class: Historia.JPAEcografiaPelvica.7
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_ecog_obstetrica`.`Id` , `h_atencion`.`Fecha_Atencion` , `profesional1`.`NProfesional` FROM `h_ecog_obstetrica`   INNER JOIN  `h_atencion`  ON (`h_ecog_obstetrica`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND `h_ecog_obstetrica`.`TipoE` >0 AND  `h_ecog_obstetrica`.`Estado`=1) ORDER BY `h_ecog_obstetrica`.`Id` DESC";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.xidecografia;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_Ecografia_Pelvica", mparametros);
    }
}
