package ParametrizacionN;

import Acceso.Principal;
import Contabilidad.JIFPuc;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFSubGrupoFacturaxEmpresa.class */
public class JIFFSubGrupoFacturaxEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidgrupo;
    private String[] xidsubgrupo;
    private String[] xidRubro;
    private JButton JBAdicionMasiva;
    private JComboBox JCBGrupo;
    private JComboBox JCBRubro;
    private JComboBox JCBSubCBGrupo;
    private JCheckBox JCHContable;
    private JCheckBox JCHEstado;
    private JPanel JPICuentasGen;
    private JPanel JPICuentasNS;
    private JPanel JPICuentasPag;
    private JPanel JPICuentasRad;
    private JPanel JPICuentasSub;
    private JPanel JPIDatos;
    private JPanel JPIDatosC;
    private JPanel JPPucDevoluciones;
    private JPanel JPPucGananciaPerdida;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodRubro;
    private JTextField JTFCreditoDev;
    private JTextField JTFCreditoG;
    private JTextField JTFCreditoG1;
    private JTextField JTFCreditoNs;
    private JTextField JTFCreditoPag;
    private JTextField JTFCreditoRad;
    private JTextField JTFCreditoSub;
    private JTextField JTFDebitoDev;
    private JTextField JTFDebitoG;
    private JTextField JTFDebitoNs;
    private JTextField JTFDebitoPag;
    private JTextField JTFDebitoRad;
    private JTextField JTFDebitoSub;
    private JTextField JTFPucGanancia;
    private JTextField JTFPucPerdida;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private String xid = "0";
    private boolean xlleno = false;
    private long xcontable = 0;

    public JIFFSubGrupoFacturaxEmpresa() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JCBGrupo = new JComboBox();
        this.JCBSubCBGrupo = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JPIDatosC = new JPanel();
        this.JPICuentasGen = new JPanel();
        this.JTFDebitoG = new JTextField();
        this.JTFCreditoG = new JTextField();
        this.JTFCreditoG1 = new JTextField();
        this.JPICuentasRad = new JPanel();
        this.JTFDebitoRad = new JTextField();
        this.JTFCreditoRad = new JTextField();
        this.JPICuentasNS = new JPanel();
        this.JTFDebitoNs = new JTextField();
        this.JTFCreditoNs = new JTextField();
        this.JPICuentasSub = new JPanel();
        this.JTFDebitoSub = new JTextField();
        this.JTFCreditoSub = new JTextField();
        this.JPICuentasPag = new JPanel();
        this.JTFDebitoPag = new JTextField();
        this.JTFCreditoPag = new JTextField();
        this.JCHContable = new JCheckBox();
        this.JPPucGananciaPerdida = new JPanel();
        this.JTFPucGanancia = new JTextField();
        this.JTFPucPerdida = new JTextField();
        this.JPPucDevoluciones = new JPanel();
        this.JTFDebitoDev = new JTextField();
        this.JTFCreditoDev = new JTextField();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JTFCodRubro = new JTextField();
        this.JCBRubro = new JComboBox();
        this.JBAdicionMasiva = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBGRUPO FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsubgrupofacempresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.1
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sub Grupo Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBSubCBGrupo, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBGrupo, 0, 965, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado))).addGap(18, 18, 18)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupo, -2, 50, -2).addComponent(this.JCHEstado)).addGap(33, 33, 33).addComponent(this.JCBSubCBGrupo, -2, 50, -2).addContainerGap(52, 32767)));
        this.JTPDatos.addTab("DATOS FACTURA", this.JPIDatos);
        this.JPICuentasGen.setBorder(BorderFactory.createTitledBorder((Border) null, "Generación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoG.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoG.setToolTipText("");
        this.JTFDebitoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoG.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.4
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoGFocusLost(evt);
            }
        });
        this.JTFDebitoG.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.5
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoGMouseClicked(evt);
            }
        });
        this.JTFCreditoG.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoG.setToolTipText("");
        this.JTFCreditoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoG.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.6
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoGFocusLost(evt);
            }
        });
        this.JTFCreditoG.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.7
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoGMouseClicked(evt);
            }
        });
        this.JTFCreditoG1.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoG1.setToolTipText("Cuenta Puc Crédito Copago-CM");
        this.JTFCreditoG1.setBorder(BorderFactory.createTitledBorder((Border) null, "Copago-CM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoG1.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.8
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoG1FocusLost(evt);
            }
        });
        this.JTFCreditoG1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.9
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoG1MouseClicked(evt);
            }
        });
        this.JTFCreditoG1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.10
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoG1ActionPerformed(evt);
            }
        });
        GroupLayout JPICuentasGenLayout = new GroupLayout(this.JPICuentasGen);
        this.JPICuentasGen.setLayout(JPICuentasGenLayout);
        JPICuentasGenLayout.setHorizontalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoG, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoG, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoG1, -1, 105, 32767).addContainerGap()));
        JPICuentasGenLayout.setVerticalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createSequentialGroup().addGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoG, -2, 40, -2).addComponent(this.JTFCreditoG, -2, 40, -2).addComponent(this.JTFCreditoG1, -2, 40, -2)).addGap(12, 12, 12)));
        this.JPICuentasRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Radicación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoRad.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoRad.setToolTipText("");
        this.JTFDebitoRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoRad.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.11
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoRadFocusLost(evt);
            }
        });
        this.JTFDebitoRad.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.12
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoRadMouseClicked(evt);
            }
        });
        this.JTFCreditoRad.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoRad.setToolTipText("");
        this.JTFCreditoRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoRad.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.13
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoRadFocusLost(evt);
            }
        });
        this.JTFCreditoRad.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.14
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoRadMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasRadLayout = new GroupLayout(this.JPICuentasRad);
        this.JPICuentasRad.setLayout(JPICuentasRadLayout);
        JPICuentasRadLayout.setHorizontalGroup(JPICuentasRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasRadLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoRad, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoRad, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasRadLayout.setVerticalGroup(JPICuentasRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasRadLayout.createSequentialGroup().addGroup(JPICuentasRadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoRad, -2, 40, -2).addComponent(this.JTFCreditoRad, -2, 40, -2)).addGap(12, 12, 12)));
        this.JPICuentasNS.setBorder(BorderFactory.createTitledBorder((Border) null, "Radicacion Glosa", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoNs.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoNs.setToolTipText("");
        this.JTFDebitoNs.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoNs.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.15
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoNsFocusLost(evt);
            }
        });
        this.JTFDebitoNs.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.16
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoNsMouseClicked(evt);
            }
        });
        this.JTFCreditoNs.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoNs.setToolTipText("");
        this.JTFCreditoNs.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoNs.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.17
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoNsFocusLost(evt);
            }
        });
        this.JTFCreditoNs.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.18
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoNsMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasNSLayout = new GroupLayout(this.JPICuentasNS);
        this.JPICuentasNS.setLayout(JPICuentasNSLayout);
        JPICuentasNSLayout.setHorizontalGroup(JPICuentasNSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasNSLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoNs, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoNs, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasNSLayout.setVerticalGroup(JPICuentasNSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasNSLayout.createSequentialGroup().addGroup(JPICuentasNSLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoNs, -2, 40, -2).addComponent(this.JTFCreditoNs, -2, 40, -2)).addGap(12, 12, 12)));
        this.JPICuentasSub.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta Glosa", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoSub.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoSub.setToolTipText("");
        this.JTFDebitoSub.setBorder(BorderFactory.createTitledBorder((Border) null, "Subsanable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoSub.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.19
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoSubFocusLost(evt);
            }
        });
        this.JTFDebitoSub.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.20
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoSubMouseClicked(evt);
            }
        });
        this.JTFCreditoSub.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoSub.setToolTipText("");
        this.JTFCreditoSub.setBorder(BorderFactory.createTitledBorder((Border) null, "No Subsanable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoSub.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.21
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoSubFocusLost(evt);
            }
        });
        this.JTFCreditoSub.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.22
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoSubMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasSubLayout = new GroupLayout(this.JPICuentasSub);
        this.JPICuentasSub.setLayout(JPICuentasSubLayout);
        JPICuentasSubLayout.setHorizontalGroup(JPICuentasSubLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasSubLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoSub, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoSub, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasSubLayout.setVerticalGroup(JPICuentasSubLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasSubLayout.createSequentialGroup().addGroup(JPICuentasSubLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoSub, -2, 40, -2).addComponent(this.JTFCreditoSub, -2, 40, -2)).addGap(12, 12, 12)));
        this.JPICuentasPag.setBorder(BorderFactory.createTitledBorder((Border) null, "Pago", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoPag.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoPag.setToolTipText("");
        this.JTFDebitoPag.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoPag.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.23
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoPagFocusLost(evt);
            }
        });
        this.JTFDebitoPag.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.24
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoPagMouseClicked(evt);
            }
        });
        this.JTFCreditoPag.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoPag.setToolTipText("");
        this.JTFCreditoPag.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoPag.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.25
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoPagFocusLost(evt);
            }
        });
        this.JTFCreditoPag.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.26
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoPagMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasPagLayout = new GroupLayout(this.JPICuentasPag);
        this.JPICuentasPag.setLayout(JPICuentasPagLayout);
        JPICuentasPagLayout.setHorizontalGroup(JPICuentasPagLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasPagLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoPag, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoPag, -2, 105, -2).addContainerGap(42, 32767)));
        JPICuentasPagLayout.setVerticalGroup(JPICuentasPagLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasPagLayout.createSequentialGroup().addGroup(JPICuentasPagLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoPag, -2, 40, -2).addComponent(this.JTFCreditoPag, -2, 40, -2)).addGap(12, 12, 12)));
        this.JCHContable.setFont(new Font("Arial", 1, 12));
        this.JCHContable.setText("Es Contable?");
        this.JCHContable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.27
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JCHContableActionPerformed(evt);
            }
        });
        this.JPPucGananciaPerdida.setBorder(BorderFactory.createTitledBorder((Border) null, "Ganancia y Pérdida", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFPucGanancia.setFont(new Font("Arial", 1, 12));
        this.JTFPucGanancia.setToolTipText("");
        this.JTFPucGanancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ganancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPucGanancia.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.28
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFPucGananciaFocusLost(evt);
            }
        });
        this.JTFPucPerdida.setFont(new Font("Arial", 1, 12));
        this.JTFPucPerdida.setToolTipText("");
        this.JTFPucPerdida.setBorder(BorderFactory.createTitledBorder((Border) null, "Pérdida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPucPerdida.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.29
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFPucPerdidaFocusLost(evt);
            }
        });
        GroupLayout JPPucGananciaPerdidaLayout = new GroupLayout(this.JPPucGananciaPerdida);
        this.JPPucGananciaPerdida.setLayout(JPPucGananciaPerdidaLayout);
        JPPucGananciaPerdidaLayout.setHorizontalGroup(JPPucGananciaPerdidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPucGananciaPerdidaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFPucGanancia, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFPucPerdida, -2, 105, -2).addContainerGap(-1, 32767)));
        JPPucGananciaPerdidaLayout.setVerticalGroup(JPPucGananciaPerdidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPucGananciaPerdidaLayout.createSequentialGroup().addGroup(JPPucGananciaPerdidaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPucGanancia, -2, 40, -2).addComponent(this.JTFPucPerdida, -2, 40, -2)).addGap(12, 12, 12)));
        this.JPPucDevoluciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Devoluciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoDev.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoDev.setToolTipText("");
        this.JTFDebitoDev.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoDev.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.30
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoDevFocusLost(evt);
            }
        });
        this.JTFDebitoDev.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.31
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFDebitoDevMouseClicked(evt);
            }
        });
        this.JTFCreditoDev.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoDev.setToolTipText("");
        this.JTFCreditoDev.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoDev.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.32
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoDevFocusLost(evt);
            }
        });
        this.JTFCreditoDev.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.33
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCreditoDevMouseClicked(evt);
            }
        });
        GroupLayout JPPucDevolucionesLayout = new GroupLayout(this.JPPucDevoluciones);
        this.JPPucDevoluciones.setLayout(JPPucDevolucionesLayout);
        JPPucDevolucionesLayout.setHorizontalGroup(JPPucDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPucDevolucionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoDev, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoDev, -2, 105, -2).addContainerGap(-1, 32767)));
        JPPucDevolucionesLayout.setVerticalGroup(JPPucDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPucDevolucionesLayout.createSequentialGroup().addGroup(JPPucDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoDev, -2, 40, -2).addComponent(this.JTFCreditoDev, -2, 40, -2)).addGap(12, 12, 12)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JPICuentasNS, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPICuentasSub, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPucGananciaPerdida, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPucDevoluciones, -2, -1, -2)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JPICuentasGen, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JPICuentasRad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICuentasPag, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHContable))).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICuentasRad, -2, -1, -2).addComponent(this.JPICuentasGen, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JPICuentasPag, -2, -1, -2)).addGap(12, 12, 12)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHContable).addGap(29, 29, 29))).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICuentasSub, -2, -1, -2).addComponent(this.JPPucGananciaPerdida, -2, -1, -2).addComponent(this.JPICuentasNS, -2, -1, -2).addComponent(this.JPPucDevoluciones, -2, -1, -2)).addContainerGap(22, 32767)));
        this.JTPDatos.addTab("DATOS CONTABLES", this.JPIDatosC);
        this.JTFCodRubro.setFont(new Font("Arial", 1, 12));
        this.JTFCodRubro.setToolTipText("");
        this.JTFCodRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodRubro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.34
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCodRubroActionPerformed(evt);
            }
        });
        this.JTFCodRubro.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.35
            public void focusLost(FocusEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JTFCodRubroFocusLost(evt);
            }
        });
        this.JCBRubro.setFont(new Font("Arial", 1, 12));
        this.JCBRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubro.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.36
            public void itemStateChanged(ItemEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JCBRubroItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodRubro, -1, 180, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubro, -2, 869, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBRubro, -1, 50, 32767).addComponent(this.JTFCodRubro)).addContainerGap(116, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        this.JTPDatos.addTab("DATOS PRESUPUESTO", this.jPanel1);
        this.JBAdicionMasiva.setFont(new Font("Arial", 1, 12));
        this.JBAdicionMasiva.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.JBAdicionMasiva.setText("Adicion Selectiva de Subgrupos Factura");
        this.JBAdicionMasiva.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.37
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFacturaxEmpresa.this.JBAdicionMasivaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JBAdicionMasiva, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 330, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionMasiva, -2, 50, -2).addGap(10, 10, 10)));
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
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JCBGrupo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBSubCBGrupo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFDebitoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFCreditoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTFCreditoG1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString());
            this.JTFDebitoRad.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTFCreditoRad.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTFDebitoNs.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JTFCreditoNs.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
            this.JTFDebitoSub.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JTFCreditoSub.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
            this.JTFDebitoPag.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString());
            this.JTFCreditoPag.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            this.JTFCodRubro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString());
            this.JTFPucGanancia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString());
            this.JTFPucPerdida.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString());
            mVerificarRubro();
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCHContable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()).booleanValue());
            if (this.JCHContable.isSelected()) {
                this.xcontable = 1L;
            } else {
                this.xcontable = 0L;
            }
            this.JTFDebitoDev.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString());
            this.JTFCreditoDev.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString());
            this.JCBRubro.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19) + " " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBGrupo.getSelectedIndex() != -1) {
            this.JCBSubCBGrupo.removeAllItems();
            this.xidsubgrupo = this.xconsulta.llenarCombo("SELECT Id_SubgrupoServicio, Nbre FROM f_subgruposervicio WHERE (Id_GrupoServicio ='" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "') ORDER BY Nbre ASC", this.xidsubgrupo, this.JCBSubCBGrupo);
            this.JCBSubCBGrupo.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContableActionPerformed(ActionEvent evt) {
        if (this.JCHContable.isSelected()) {
            this.xcontable = 1L;
        } else {
            this.xcontable = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubroItemStateChanged(ItemEvent evt) {
        if (this.JCBRubro.getSelectedIndex() != -1 && this.xlleno) {
            this.JTFCodRubro.setText(this.xidRubro[this.JCBRubro.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodRubroActionPerformed(ActionEvent evt) {
        mVerificarRubro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodRubroFocusLost(FocusEvent evt) {
        mVerificarRubro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoGFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoG.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoG.getText())) {
            this.JTFDebitoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoG.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoG.getText())) {
            this.JTFCreditoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoG1ActionPerformed(ActionEvent evt) {
        if (!this.JTFCreditoG.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoG.getText())) {
            this.JTFCreditoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoG1FocusLost(FocusEvent evt) {
        if (!this.JTFCreditoG1.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoG1.getText())) {
            this.JTFCreditoG1.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoRadFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoRad.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoRad.getText())) {
            this.JTFDebitoRad.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoRadFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoRad.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoRad.getText())) {
            this.JTFCreditoRad.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoPagFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoPag.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoPag.getText())) {
            this.JTFDebitoPag.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoPagFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoPag.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoPag.getText())) {
            this.JTFCreditoPag.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoNsFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoNs.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoNs.getText())) {
            this.JTFDebitoNs.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoNsFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoNs.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoNs.getText())) {
            this.JTFCreditoNs.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoSubFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoSub.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoSub.getText())) {
            this.JTFDebitoSub.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoSubFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoSub.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoSub.getText())) {
            this.JTFCreditoSub.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPucGananciaFocusLost(FocusEvent evt) {
        if (!this.JTFPucGanancia.getText().isEmpty() && mVerificaUltNivel(this.JTFPucGanancia.getText())) {
            this.JTFPucGanancia.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPucPerdidaFocusLost(FocusEvent evt) {
        if (!this.JTFPucPerdida.getText().isEmpty() && mVerificaUltNivel(this.JTFPucPerdida.getText())) {
            this.JTFPucPerdida.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoGMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoG);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoG);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoG1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoG1);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoRadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoRad);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoRadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoRad);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoPagMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoPag);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoPagMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoPag);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoNsMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoNs);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoNsMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoNs);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoSubMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoSub);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoSubMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoSub);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoDevFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoDev.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoDev.getText())) {
            this.JTFDebitoDev.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoDevFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoDev.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoDev.getText())) {
            this.JTFCreditoDev.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoDevMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoDev);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoDevMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoDev);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionMasivaActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            JDListadoSubgrupoFactura ListadoGenerico = new JDListadoSubgrupoFactura(null, true, Long.valueOf(Principal.claseparametrizacionn.xjifempresaBienestar.xidempresacont));
            ListadoGenerico.setLocationRelativeTo(this);
            ListadoGenerico.setVisible(true);
        } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            JDListadoSubgrupoFactura ListadoGenerico2 = new JDListadoSubgrupoFactura(null, true, Long.valueOf(Principal.claseparametrizacionn.xjifempresa.xidempresacont));
            ListadoGenerico2.setLocationRelativeTo(this);
            ListadoGenerico2.setVisible(true);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xid = "0";
        this.JCBSubCBGrupo.removeAllItems();
        this.xidgrupo = this.xconsulta.llenarCombo("SELECT Id_GrupoServicio, Nbre, Estado FROM f_gruposervicio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgrupo, this.JCBGrupo);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
        this.JCHEstado.setSelected(true);
        this.JTFCreditoG.setText("");
        this.JTFDebitoG.setText("");
        this.JTFCreditoRad.setText("");
        this.JTFDebitoRad.setText("");
        this.JTFCreditoNs.setText("");
        this.JTFDebitoNs.setText("");
        this.JTFCreditoSub.setText("");
        this.JTFDebitoSub.setText("");
        this.JTFCreditoPag.setText("");
        this.JTFDebitoPag.setText("");
        this.JTFPucGanancia.setText("");
        this.JTFPucPerdida.setText("");
        this.JTFCreditoG1.setText("");
        this.JTFDebitoDev.setText("");
        this.JTFCreditoDev.setText("");
        this.xestado = 1;
        this.JCBGrupo.setSelectedIndex(-1);
        this.xidRubro = this.xconsulta.llenarCombo("SELECT pp.Id, CONCAT(pp.Id,' ',pp.`Nbre`) AS Nbre  \nFROM `pp_rubros` pp\ninner join pp_rubros_encabezado er on (er.id=pp.idEncabezadoRubro)\nWHERE pp.`UltNivel`=1 AND pp.`TipoRubro`='I' and er.estado=1", this.xidRubro, this.JCBRubro);
        this.JCBRubro.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mGrabar() {
        String sql;
        int xidempresacont;
        if (this.JCBGrupo.getSelectedIndex() != -1) {
            if (this.JCBSubCBGrupo.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String xIdRubroP = "";
                    if (this.JCBRubro.getSelectedIndex() > -1) {
                        xIdRubroP = this.xidRubro[this.JCBRubro.getSelectedIndex()];
                    }
                    if (this.xid.equals("0")) {
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            xidempresacont = Principal.claseparametrizacionn.xjifempresaBienestar.xidempresacont;
                        } else {
                            xidempresacont = Principal.claseparametrizacionn.xjifempresa.xidempresacont;
                        }
                        sql = " Insert into f_subgrupo_empresa(Id_SubGrupo, Id_Empresa, CPuc_Debito, CPuc_Credito, CPuc_Credito_PC, `CPuc_Debito_R`, `CPuc_Credito_R`, `CPuc_Debito_G`, `CPuc_Credito_G`, `CPuc_Debito_GS`, `CPuc_Credito_GS`, `CPuc_Debito_P`, `CPuc_Credito_P`,CPuc_Ganancia,CPuc_Perdida, CPuc_Debito_D, CPuc_Credito_D,EsContable,IdRubro,Estado,UsuarioS)  values ('" + this.xidsubgrupo[this.JCBSubCBGrupo.getSelectedIndex()] + "','" + xidempresacont + "','" + this.JTFDebitoG.getText() + "','" + this.JTFCreditoG.getText() + "','" + this.JTFCreditoG1.getText() + "','" + this.JTFDebitoRad.getText() + "','" + this.JTFCreditoRad.getText() + "','" + this.JTFDebitoNs.getText() + "','" + this.JTFCreditoNs.getText() + "','" + this.JTFDebitoSub.getText() + "','" + this.JTFCreditoSub.getText() + "','" + this.JTFDebitoPag.getText() + "','" + this.JTFCreditoPag.getText() + "','" + this.JTFPucGanancia.getText() + "','" + this.JTFPucPerdida.getText() + "','" + this.JTFDebitoDev.getText() + "','" + this.JTFCreditoDev.getText() + "','" + this.xcontable + "','" + xIdRubroP + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update f_subgrupo_empresa set Estado='" + this.xestado + "', CPuc_Debito='" + this.JTFDebitoG.getText() + "', CPuc_Credito='" + this.JTFCreditoG.getText() + "', CPuc_Credito_PC='" + this.JTFCreditoG1.getText() + "', CPuc_Debito_R='" + this.JTFDebitoRad.getText() + "', CPuc_Credito_R='" + this.JTFCreditoRad.getText() + "', CPuc_Debito_G ='" + this.JTFDebitoNs.getText() + "', CPuc_Credito_G='" + this.JTFCreditoNs.getText() + "', CPuc_Debito_GS='" + this.JTFDebitoSub.getText() + "', CPuc_Credito_GS='" + this.JTFCreditoSub.getText() + "', CPuc_Debito_P='" + this.JTFDebitoPag.getText() + "', CPuc_Credito_P='" + this.JTFCreditoPag.getText() + "', CPuc_Ganancia='" + this.JTFPucGanancia.getText() + "', CPuc_Perdida='" + this.JTFPucPerdida.getText() + "', CPuc_Debito_D='" + this.JTFDebitoDev.getText() + "', CPuc_Credito_D='" + this.JTFCreditoDev.getText() + "', EsContable='" + this.xcontable + "', IdRubro='" + xIdRubroP + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    this.JCBRubro.setSelectedIndex(-1);
                    this.JTFCodRubro.setText("");
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un subgrupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSubCBGrupo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBGrupo.requestFocus();
    }

    private void mVerificarRubro() {
        String sql = "SELECT Nbre FROM `pp_rubros` WHERE Id='" + this.JTFCodRubro.getText() + "'";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCBRubro.setSelectedItem(xrs.getString("Nbre"));
            } else {
                this.JCBRubro.setSelectedIndex(-1);
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFacturaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Grupo", "SubGrupo", "EsGrupo?", "Debito", "Credito", "Estado", "Debito", "Credito", "Debito", "Credito", "Debito", "Credito", "Debito", "Credito", "Ganancia", "Pérdida", "EsContable", "Credito", "Cód. Rubro", "Debito", "Credito", "NombreRubro"}) { // from class: ParametrizacionN.JIFFSubGrupoFacturaxEmpresa.38
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        int xidempresacont;
        try {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                xidempresacont = Principal.claseparametrizacionn.xjifempresaBienestar.xidempresacont;
            } else {
                xidempresacont = Principal.claseparametrizacionn.xjifempresa.xidempresacont;
            }
            mCrearModeloDatos();
            String sql = "SELECT f_subgrupo_empresa.Id, \nf_gruposervicio.Nbre, \nf_subgruposervicio.Nbre, \nf_subgruposervicio.EsGrupo, \nIFNULL(f_subgrupo_empresa.CPuc_Debito, '') CPuc_Debito,\nIFNULL(f_subgrupo_empresa.CPuc_Credito, '') CPuc_Credito,\nf_subgrupo_empresa.Estado,\nIFNULL(`CPuc_Debito_R`, '') CPuc_Debito_R,\nIFNULL(`CPuc_Credito_R`, '') CPuc_Credito_R,\nIFNULL(`CPuc_Debito_G`, '') CPuc_Debito_G,\nIFNULL(`CPuc_Credito_G`, '') CPuc_Credito_G,\nIFNULL(`CPuc_Debito_GS`, '') CPuc_Debito_GS, \nIFNULL(`CPuc_Credito_GS`, '') CPuc_Credito_GS, \nIFNULL(`CPuc_Debito_P`, '') CPuc_Debito_P, \nIFNULL(`CPuc_Credito_P`, '') CPuc_Credito_P,\nIFNULL(CPuc_Ganancia, '') CPuc_Ganancia,\nIFNULL(CPuc_Perdida, '') CPuc_Perdida, \nEsContable, \nIFNULL(f_subgrupo_empresa.CPuc_Credito_PC, '') CPuc_Credito_PC, \nIFNULL(f_subgrupo_empresa.IdRubro, '') IdRubro, \nIFNULL(CPuc_Debito_D, '') CPuc_Debito_D, \nIFNULL(CPuc_Credito_D, '') CPuc_Credito_D, \nIFNULL(pr.Nbre, '') nombreRubro\nFROM f_subgrupo_empresa \n  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) \n  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  \n  LEFT JOIN pp_rubros pr ON (pr.Id=f_subgrupo_empresa.IdRubro)\n  LEFT JOIN `pp_rubros_encabezado` ON (pp_rubros_encabezado.`id` =pr.`idEncabezadoRubro`)  AND (DATE_FORMAT(pp_rubros_encabezado.`fechaI`,'%Y') = DATE_FORMAT(NOW(),'%Y'))\n  WHERE (f_subgrupo_empresa.Id_Empresa ='" + xidempresacont + "' AND f_subgrupo_empresa.Estado =1\n   \n  ) \n GROUP BY f_subgrupo_empresa.Id   ORDER BY f_gruposervicio.Nbre ASC ";
            System.out.println("Consulta subgrupo -> " + sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(18)), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString("nombreRubro"), n, 22);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFacturaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaUltNivel(String xcampo) {
        boolean xOk = false;
        String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0 || "".equals(xrs.getString("UNivel"))) {
                    xOk = true;
                    JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                xOk = true;
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSMovimientoxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }
}
