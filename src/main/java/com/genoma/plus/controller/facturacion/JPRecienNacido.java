package com.genoma.plus.controller.facturacion;

import Facturacion.JPQuirurgico;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO;
import com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl;
import com.genoma.plus.dto.facturacion.ItemsRipsNacimientosDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPRecienNacido.class */
public class JPRecienNacido extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int xEstadoNacido = 1;
    private int xCPrenatal = 0;
    private String xSexo = "M";
    Long idIngreso;
    private String[] xTipoParto;
    private Object[] xDatos;
    private DefaultTableModel xmodeloRN;
    private LiquidacionCirugiaDAO liquidacionCirugiaDAO;
    private JButton JBAdicionar;
    private JButton JBBUscarDx;
    private JButton JBBUscarDxM;
    private JComboBox JCBTParto;
    private JDateChooser JDC_NFecha;
    private JDateChooser JDC_NFechaM;
    private JPanel JPI_CPrennatal;
    private JPanel JPI_CPrennatal1;
    private JPanel JPI_CPrennatal2;
    private JPanel JPI_DRecienNacido;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBVivo;
    private JRadioButton JRB_Fem;
    private JRadioButton JRB_Masc;
    private JRadioButton JRB_NCpNo;
    private JRadioButton JRB_NCpSi;
    private JTable JTDetalleNacimiento;
    private JTextField JTFAPGar;
    public JTextField JTFCDxP;
    public JTextField JTFCDxPM;
    public JTextFieldValidator JTFFSNumHijo;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    private JFormattedTextField JTFF_EdadGestacional;
    private JFormattedTextField JTFF_NHora;
    private JFormattedTextField JTFF_NHoraM;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNCodigoDxPM;
    private ButtonGroup grupoEstado;
    private ButtonGroup grupoPrenatal;
    private ButtonGroup grupoSexo;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane2;

    public JPRecienNacido(Long idIngreso) {
        initComponents();
        springStart();
        this.idIngreso = idIngreso;
        nuevo();
    }

    private void springStart() {
        this.liquidacionCirugiaDAO = (LiquidacionCirugiaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("liquidacionCirugiaDAOImpl");
    }

    private void nuevo() {
        this.JDC_NFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_NHora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JTFCDxPM.setEnabled(false);
        this.JBBUscarDxM.setEnabled(false);
        this.JDC_NFechaM.setDate((Date) null);
        this.JDC_NFechaM.setEnabled(false);
        this.JTFF_NHoraM.setText("");
        this.JTFF_NHoraM.setEnabled(false);
        this.JTFF_EdadGestacional.setText("0");
        this.JTFAPGar.setText("0");
        this.xEstadoNacido = 1;
        this.xCPrenatal = 0;
        this.JRBVivo.setSelected(true);
        this.JRB_NCpNo.setSelected(true);
        this.JRB_Masc.setSelected(true);
        this.xSexo = "M";
        this.JCBTParto.setSelectedIndex(-1);
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFCDxPM.setText("");
        this.JTFNCodigoDxPM.setText("");
        this.JTFFSPeso.setText("0");
        this.JTFFSTalla.setText("0");
        this.JTFFSNumHijo.setText("0");
        this.JCBTParto.removeAllItems();
        this.xTipoParto = this.consultas.llenarCombo("SELECT  `Id` , `Nbre` FROM `f_tipoparto`", this.xTipoParto, this.JCBTParto);
        this.JCBTParto.setSelectedIndex(-1);
        mBuscaInformacionNacidos();
    }

    public void grabar() {
        int n = this.JTDetalleNacimiento.getRowCount();
        ItemsRipsNacimientosDTO e = new ItemsRipsNacimientosDTO();
        e.setIdOrdenQx("0");
        e.setIdIngreso(this.idIngreso);
        e.setNHijo(n + 1);
        e.setIdTipoParto(Integer.valueOf(this.xTipoParto[this.JCBTParto.getSelectedIndex()]).intValue());
        e.setApgar(Integer.valueOf(this.JTFAPGar.getText()).intValue());
        e.setDiagnosticoMuerteN(this.JTFCDxPM.getText());
        e.setDiagnosticoNacido(this.JTFCDxP.getText());
        e.setEdadGestacional(Integer.valueOf(this.JTFF_EdadGestacional.getText()).intValue());
        if (this.xEstadoNacido == 1) {
            e.setEstadoNacido(1);
        } else {
            e.setEstadoNacido(0);
            e.setFechaMuerte(this.metodos.formatoAMD.format(this.JDC_NFechaM.getDate()));
            e.setHoraMuere(this.JTFF_NHoraM.getText());
        }
        e.setFechaNacimiento(this.metodos.formatoAMD.format(this.JDC_NFecha.getDate()));
        e.setHoraNacimiento(this.JTFF_NHora.getText());
        e.setIdSexo(this.xSexo);
        e.setPeso(Double.parseDouble(this.JTFFSPeso.getText()));
        e.setTalla(Double.parseDouble(this.JTFFSTalla.getText()));
        if (this.xCPrenatal == 1) {
            e.setCPrenatal(true);
        } else {
            e.setCPrenatal(false);
        }
        this.liquidacionCirugiaDAO.mCreateItemsRipsNacimiento(e);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloRN() {
        this.xmodeloRN = new DefaultTableModel(new Object[0], new String[]{"No. Hijo", "TParto", "FechaNac", "HoraNac", "EstadoNacido", "CPrenatal", "EdadGest", "Sexo", "Peso", "Talla", "Apgar", "Dx_Nac", "Dx_Muerte", "FechaM", "HoraM", "IdTipoParto"}) { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNacimiento.setModel(this.xmodeloRN);
        this.JTDetalleNacimiento.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleNacimiento.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(11).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(12).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(14).setPreferredWidth(30);
        this.JTDetalleNacimiento.getColumnModel().getColumn(15).setPreferredWidth(30);
    }

    private void mBuscaInformacionNacidos() {
        String sql = "SELECT `f_itemripsnacido`.`NoHijo` , `f_tipoparto`.`Nbre` AS TParto  , `f_itemripsnacido`.`FechaN` , `f_itemripsnacido`.`HoraN`     , IF(`f_itemripsnacido`.`EstadoN`=1,'VIVO','MUERTO') AS EstadoN  , IF(`f_itemripsnacido`.`CPrenatal`=1,'SI','NO') AS CPrenatal, `f_itemripsnacido`.`EdadG` , `f_itemripsnacido`.`Id_Sexo`     , `f_itemripsnacido`.`Peso` , `f_itemripsnacido`.`Talla` , `f_itemripsnacido`.`Apgar` , `f_itemripsnacido`.`DxN`     , `f_itemripsnacido`.`DxM` , `f_itemripsnacido`.`FechaM` , `f_itemripsnacido`.`HoraM`  FROM `f_itemripsnacido` INNER JOIN `f_tipoparto`  ON (`f_itemripsnacido`.`Id_TipoParto` = `f_tipoparto`.`Id`)  WHERE (`f_itemripsnacido`.`idIngreso`=" + this.idIngreso + " AND f_itemripsnacido.`Estado`=1);";
        ResultSet xrs = this.consultas.traerRs(sql);
        System.out.println("Consulta RN-->" + sql);
        mCreaModeloRN();
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloRN.addRow(this.xDatos);
                    this.xmodeloRN.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloRN.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloRN.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloRN.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloRN.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloRN.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloRN.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloRN.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloRN.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodeloRN.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xmodeloRN.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloRN.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloRN.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloRN.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloRN.setValueAt(xrs.getString(15), n, 14);
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPQuirurgico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "recien_nacidos", 0);
        pac.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r3v160, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.grupoEstado = new ButtonGroup();
        this.grupoSexo = new ButtonGroup();
        this.grupoPrenatal = new ButtonGroup();
        this.JPI_DRecienNacido = new JPanel();
        this.JDC_NFecha = new JDateChooser();
        this.JTFF_NHora = new JFormattedTextField();
        this.JPI_CPrennatal = new JPanel();
        this.JRB_NCpSi = new JRadioButton();
        this.JRB_NCpNo = new JRadioButton();
        this.JTFF_EdadGestacional = new JFormattedTextField();
        this.JPI_CPrennatal1 = new JPanel();
        this.JRB_Masc = new JRadioButton();
        this.JRB_Fem = new JRadioButton();
        this.JTFFSPeso = new JTextFieldValidator();
        this.jPanel3 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JBBUscarDx = new JButton();
        this.jPanel4 = new JPanel();
        this.JTFCDxPM = new JTextField();
        this.JTFNCodigoDxPM = new JTextField();
        this.JBBUscarDxM = new JButton();
        this.JDC_NFechaM = new JDateChooser();
        this.JTFF_NHoraM = new JFormattedTextField();
        this.JPI_CPrennatal2 = new JPanel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSNumHijo = new JTextFieldValidator();
        this.JTFAPGar = new JTextField();
        this.JCBTParto = new JComboBox();
        this.JBAdicionar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleNacimiento = new JTable();
        setName("xjpreciennacido");
        this.JPI_DRecienNacido.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RECIEN NACIDO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDC_NFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_NFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_NHora.setToolTipText("Formato hh:mm p");
        this.JTFF_NHora.setFont(new Font("Arial", 1, 12));
        this.JPI_CPrennatal.setBorder(BorderFactory.createTitledBorder((Border) null, "C.Prenatal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoPrenatal.add(this.JRB_NCpSi);
        this.JRB_NCpSi.setFont(new Font("Arial", 1, 12));
        this.JRB_NCpSi.setText("SI");
        this.JRB_NCpSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.2
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRB_NCpSiActionPerformed(evt);
            }
        });
        this.grupoPrenatal.add(this.JRB_NCpNo);
        this.JRB_NCpNo.setFont(new Font("Arial", 1, 12));
        this.JRB_NCpNo.setSelected(true);
        this.JRB_NCpNo.setText("NO");
        this.JRB_NCpNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.3
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRB_NCpNoActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatalLayout = new GroupLayout(this.JPI_CPrennatal);
        this.JPI_CPrennatal.setLayout(JPI_CPrennatalLayout);
        JPI_CPrennatalLayout.setHorizontalGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatalLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRB_NCpSi).addGap(3, 3, 3).addComponent(this.JRB_NCpNo).addGap(2, 2, 2)));
        JPI_CPrennatalLayout.setVerticalGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatalLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_CPrennatalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_NCpSi).addComponent(this.JRB_NCpNo)).addContainerGap(-1, 32767)));
        this.JTFF_EdadGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad gestacional (Semanas)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_EdadGestacional.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.JTFF_EdadGestacional.setHorizontalAlignment(4);
        this.JTFF_EdadGestacional.setToolTipText("Semanas de Gestación");
        this.JTFF_EdadGestacional.setFont(new Font("Arial", 1, 12));
        this.JPI_CPrennatal1.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoSexo.add(this.JRB_Masc);
        this.JRB_Masc.setFont(new Font("Arial", 1, 12));
        this.JRB_Masc.setSelected(true);
        this.JRB_Masc.setText("M");
        this.JRB_Masc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.4
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRB_MascActionPerformed(evt);
            }
        });
        this.grupoSexo.add(this.JRB_Fem);
        this.JRB_Fem.setFont(new Font("Arial", 1, 12));
        this.JRB_Fem.setText("F");
        this.JRB_Fem.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.5
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRB_FemActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatal1Layout = new GroupLayout(this.JPI_CPrennatal1);
        this.JPI_CPrennatal1.setLayout(JPI_CPrennatal1Layout);
        JPI_CPrennatal1Layout.setHorizontalGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRB_Masc).addGap(5, 5, 5).addComponent(this.JRB_Fem).addContainerGap(-1, 32767)));
        JPI_CPrennatal1Layout.setVerticalGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal1Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_CPrennatal1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Masc).addComponent(this.JRB_Fem)).addContainerGap(-1, 32767)));
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.6
            public void focusGained(FocusEvent evt) {
                JPRecienNacido.this.JTFFSPesoFocusGained(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO DEL RECIÉN NACIDO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.setEnabled(false);
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.7
            public void mouseClicked(MouseEvent evt) {
                JPRecienNacido.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.8
            public void keyPressed(KeyEvent evt) {
                JPRecienNacido.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JBBUscarDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDx.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDx.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.9
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JBBUscarDxActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 520, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBUscarDx, -2, 56, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2))).addComponent(this.JBBUscarDx, -2, 45, -2)).addGap(5, 5, 5)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "CAUSA BÁSICA DE MUERTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCDxPM.setFont(new Font("Arial", 1, 12));
        this.JTFCDxPM.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxPM.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxPM.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxPM.setEnabled(false);
        this.JBBUscarDxM.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBUscarDxM.setToolTipText("Buscar Diagnósticos");
        this.JBBUscarDxM.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.10
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JBBUscarDxMActionPerformed(evt);
            }
        });
        this.JDC_NFechaM.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_NFechaM.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHoraM.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_NHoraM.setToolTipText("Formato hh:mm p");
        this.JTFF_NHoraM.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFCDxPM, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxPM, -2, 385, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBBUscarDxM, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_NFechaM, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_NHoraM, -2, 82, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_NFechaM, -2, 50, -2).addComponent(this.JTFF_NHoraM, -2, 45, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBBUscarDxM, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxPM, -2, -1, -2).addComponent(this.JTFNCodigoDxPM, -2, -1, -2)))).addGap(10, 10, 10)));
        this.JPI_CPrennatal2.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.grupoEstado.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("VIVO");
        this.JRBVivo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.11
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRBVivoActionPerformed(evt);
            }
        });
        this.grupoEstado.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setText("MUERTO");
        this.JRBMuerto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.12
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JRBMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPI_CPrennatal2Layout = new GroupLayout(this.JPI_CPrennatal2);
        this.JPI_CPrennatal2.setLayout(JPI_CPrennatal2Layout);
        JPI_CPrennatal2Layout.setHorizontalGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBVivo).addGap(18, 18, 18).addComponent(this.JRBMuerto).addContainerGap(-1, 32767)));
        JPI_CPrennatal2Layout.setVerticalGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CPrennatal2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_CPrennatal2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVivo).addComponent(this.JRBMuerto))));
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.13
            public void focusGained(FocusEvent evt) {
                JPRecienNacido.this.JTFFSTallaFocusGained(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.14
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSNumHijo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSNumHijo.setHorizontalAlignment(0);
        this.JTFFSNumHijo.setText("0");
        this.JTFFSNumHijo.setToolTipText("Talla en Centimetros");
        this.JTFFSNumHijo.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSNumHijo.setFocusAccelerator('C');
        this.JTFFSNumHijo.setFont(new Font("Arial", 1, 12));
        this.JTFAPGar.setFont(new Font("Arial", 1, 12));
        this.JTFAPGar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue), "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTParto.setFont(new Font("Arial", 1, 12));
        this.JCBTParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DRecienNacidoLayout = new GroupLayout(this.JPI_DRecienNacido);
        this.JPI_DRecienNacido.setLayout(JPI_DRecienNacidoLayout);
        JPI_DRecienNacidoLayout.setHorizontalGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_CPrennatal1, -2, -1, -2).addComponent(this.JDC_NFecha, -2, 127, -2)).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSNumHijo, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAPGar, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTParto, -2, 203, -2).addContainerGap(-1, 32767)).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFF_NHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_CPrennatal2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_CPrennatal, -2, -1, -2).addGap(34, 34, 34).addComponent(this.JTFF_EdadGestacional, -2, 188, -2).addGap(30, 30, 30)))))));
        JPI_DRecienNacidoLayout.setVerticalGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DRecienNacidoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.JPI_CPrennatal2, -1, -1, 32767).addGap(2, 2, 2)).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addComponent(this.JPI_CPrennatal, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPI_DRecienNacidoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_NHora, -2, 48, -2).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFF_EdadGestacional, -2, 45, -2).addComponent(this.JDC_NFecha, -2, 50, -2))))).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFAPGar, -2, 50, -2).addGroup(JPI_DRecienNacidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSPeso, -2, 50, -2).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSNumHijo, -2, 50, -2).addComponent(this.JCBTParto, -2, 46, -2)).addComponent(this.JPI_CPrennatal1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addGap(5, 5, 5)));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.setToolTipText("");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPRecienNacido.15
            public void actionPerformed(ActionEvent evt) {
                JPRecienNacido.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleNacimiento.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNacimiento.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleNacimiento.setSelectionBackground(Color.white);
        this.JTDetalleNacimiento.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTDetalleNacimiento);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2).addComponent(this.JPI_DRecienNacido, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_DRecienNacido, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 205, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NCpSiActionPerformed(ActionEvent evt) {
        this.xCPrenatal = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NCpNoActionPerformed(ActionEvent evt) {
        this.xCPrenatal = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_MascActionPerformed(ActionEvent evt) {
        this.xSexo = "M";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FemActionPerformed(ActionEvent evt) {
        this.xSexo = "F";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxActionPerformed(ActionEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBUscarDxMActionPerformed(ActionEvent evt) {
        mBuscarPatologiaN(this.JTFCDxPM, this.JTFNCodigoDxPM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVivoActionPerformed(ActionEvent evt) {
        this.xEstadoNacido = 1;
        this.JTFCDxPM.setEnabled(false);
        this.JBBUscarDxM.setEnabled(false);
        this.JDC_NFechaM.setDate((Date) null);
        this.JDC_NFechaM.setEnabled(false);
        this.JTFF_NHoraM.setText("");
        this.JTFF_NHoraM.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuertoActionPerformed(ActionEvent evt) {
        this.xEstadoNacido = 0;
        this.JTFCDxPM.setEnabled(true);
        this.JBBUscarDxM.setEnabled(true);
        this.JDC_NFechaM.setDate(this.metodos.getFechaActual());
        this.JDC_NFechaM.setEnabled(true);
        this.JTFF_NHoraM.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JTFF_NHoraM.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JRBMuerto.isSelected()) {
            if (this.JTFF_EdadGestacional.getText().equals("0")) {
                JOptionPane.showInternalMessageDialog(this, "La edad gestacional debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFF_EdadGestacional.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSPeso.getText()) == 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "El peso debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSPeso.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSTalla.getText()) == 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "La Talla debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSTalla.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSNumHijo.getText()) != 0.0d) {
                if (!this.JTFCDxP.getText().equals("")) {
                    if (!this.JTFCDxPM.getText().equals("")) {
                        if (this.JCBTParto.getSelectedIndex() != -1) {
                            grabar();
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar el tipo de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBTParto.requestFocus();
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoMuerto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFCDxPM.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoVivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCDxP.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Numero de Hijo debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSNumHijo.requestFocus();
            return;
        }
        if (this.JTFF_EdadGestacional.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "La edad gestacional debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFF_EdadGestacional.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFSPeso.getText()) == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "El peso debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSPeso.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFSTalla.getText()) == 0.0d) {
            JOptionPane.showInternalMessageDialog(this, "La Talla debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFSNumHijo.getText()) != 0.0d) {
            if (!this.JTFCDxP.getText().equals("")) {
                if (this.JCBTParto.getSelectedIndex() != -1) {
                    grabar();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar la el tipo de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTParto.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Digite el Diagnóstico del nacidoVivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El Numero de Hijo debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFSNumHijo.requestFocus();
    }
}
